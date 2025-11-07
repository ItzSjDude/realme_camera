package com.meicam.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.meicam.sdk.NvsIconGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class NvsMultiThumbnailSequenceView extends HorizontalScrollView implements NvsIconGenerator.IconCallback {
    private static final String TAG = "Meicam";
    public static final int THUMBNAIL_IMAGE_FILLMODE_ASPECTCROP = 1;
    public static final int THUMBNAIL_IMAGE_FILLMODE_STRETCH = 0;
    private static final int THUMBNAIL_SEQUENCE_FLAGS_CACHED_KEYFRAME_ONLY = 1;

    /* renamed from: THUMBNAIL_SEQUENCE_FLAGS_CACHED_KEYFRAME_ONLY_VALID */
    private static final int f9714xd64ef40 = 2;
    private ContentView m_contentView;
    private int m_contentWidth;
    private ArrayList<ThumbnailSequenceDesc> m_descArray;
    private int m_endPadding;
    private NvsIconGenerator m_iconGenerator;
    private int m_maxThumbnailWidth;
    private long m_maxTimelinePosToScroll;
    private double m_pixelPerMicrosecond;
    Bitmap m_placeholderBitmap;
    private OnScrollChangeListener m_scrollChangeListener;
    private boolean m_scrollEnabled;
    private int m_startPadding;
    private float m_thumbnailAspectRatio;
    private int m_thumbnailImageFillMode;
    private TreeMap<ThumbnailId, Thumbnail> m_thumbnailMap;
    private ArrayList<ThumbnailSequence> m_thumbnailSequenceArray;
    private TreeMap<Integer, ThumbnailSequence> m_thumbnailSequenceMap;
    private boolean m_updatingThumbnail;

    public interface OnScrollChangeListener {
        void onScrollChanged(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView, int OplusGLSurfaceView_13, int i2);
    }

    private static class Thumbnail {
        ImageView m_imageView;
        ThumbnailSequence m_owner;
        long m_timestamp = 0;
        long m_iconTaskId = 0;
        boolean m_imageViewUpToDate = false;
        boolean m_touched = false;
    }

    public static class ThumbnailSequenceDesc {
        public String mediaFilePath;
        public long inPoint = 0;
        public long outPoint = 4000000;
        public long trimIn = 0;
        public long trimOut = 4000000;
        public boolean stillImageHint = false;
        public boolean onlyDecodeKeyFrame = false;
        public float thumbnailAspectRatio = 0.0f;
    }

    private static class ThumbnailSequence {
        String m_mediaFilePath;
        int m_index = 0;
        long m_inPoint = 0;
        long m_outPoint = 0;
        long m_trimIn = 0;
        long m_trimDuration = 0;
        boolean m_stillImageHint = false;
        boolean m_onlyDecodeKeyFrame = false;
        public float m_thumbnailAspectRatio = 0.0f;
        int m_flags = 0;
        int m_x = 0;
        int m_width = 0;
        int m_thumbnailWidth = 0;

        public long calcTimestampFromX(int OplusGLSurfaceView_13) {
            return this.m_trimIn + ((long) Math.floor((((OplusGLSurfaceView_13 - this.m_x) / this.m_width) * this.m_trimDuration) + 0.5d));
        }
    }

    private static class ThumbnailId implements Comparable<ThumbnailId> {
        public int m_seqIndex;
        public long m_timestamp;

        public ThumbnailId(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this.m_seqIndex = OplusGLSurfaceView_13;
            this.m_timestamp = OplusGLSurfaceView_15;
        }

        @Override // java.lang.Comparable
        public int compareTo(ThumbnailId thumbnailId) {
            int OplusGLSurfaceView_13 = this.m_seqIndex;
            int i2 = thumbnailId.m_seqIndex;
            if (OplusGLSurfaceView_13 < i2) {
                return -1;
            }
            if (OplusGLSurfaceView_13 > i2) {
                return 1;
            }
            long OplusGLSurfaceView_15 = this.m_timestamp;
            long j2 = thumbnailId.m_timestamp;
            if (OplusGLSurfaceView_15 < j2) {
                return -1;
            }
            return OplusGLSurfaceView_15 > j2 ? 1 : 0;
        }
    }

    private class ContentView extends ViewGroup {
        @Override // android.view.ViewGroup
        public boolean shouldDelayChildPressedState() {
            return false;
        }

        public ContentView(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
            int i3 = NvsMultiThumbnailSequenceView.this.m_contentWidth;
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
                size = NvsMultiThumbnailSequenceView.this.getHeight();
            }
            setMeasuredDimension(resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), OplusGLSurfaceView_13, 0), resolveSizeAndState(Math.max(size, getSuggestedMinimumHeight()), i2, 0));
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            NvsMultiThumbnailSequenceView.this.updateThumbnails();
        }

        @Override // android.view.View
        protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            if (i2 != i4) {
                NvsMultiThumbnailSequenceView.this.requestUpdateThumbnailSequenceGeometry();
            }
            super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    public NvsMultiThumbnailSequenceView(Context context) {
        super(context);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new ArrayList<>();
        this.m_thumbnailSequenceMap = new TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsMultiThumbnailSequenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new ArrayList<>();
        this.m_thumbnailSequenceMap = new TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsMultiThumbnailSequenceView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new ArrayList<>();
        this.m_thumbnailSequenceMap = new TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsMultiThumbnailSequenceView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new ArrayList<>();
        this.m_thumbnailSequenceMap = new TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public void setThumbnailSequenceDescArray(ArrayList<ThumbnailSequenceDesc> arrayList) {
        NvsUtils.checkFunctionInMainThread();
        if (arrayList == this.m_descArray) {
            return;
        }
        clearThumbnailSequences();
        this.m_placeholderBitmap = null;
        this.m_descArray = arrayList;
        if (arrayList != null) {
            int OplusGLSurfaceView_13 = 0;
            Iterator<ThumbnailSequenceDesc> it = arrayList.iterator();
            long OplusGLSurfaceView_15 = 0;
            while (it.hasNext()) {
                ThumbnailSequenceDesc next = it.next();
                if (next.mediaFilePath == null || next.inPoint < OplusGLSurfaceView_15 || next.outPoint <= next.inPoint || next.trimIn < 0 || next.trimOut <= next.trimIn) {
                    Log.COUIBaseListPopupWindow_8(TAG, "Invalid ThumbnailSequenceDesc!");
                } else {
                    ThumbnailSequence thumbnailSequence = new ThumbnailSequence();
                    thumbnailSequence.m_index = OplusGLSurfaceView_13;
                    thumbnailSequence.m_mediaFilePath = next.mediaFilePath;
                    thumbnailSequence.m_inPoint = next.inPoint;
                    thumbnailSequence.m_outPoint = next.outPoint;
                    thumbnailSequence.m_trimIn = next.trimIn;
                    thumbnailSequence.m_trimDuration = next.trimOut - next.trimIn;
                    thumbnailSequence.m_stillImageHint = next.stillImageHint;
                    thumbnailSequence.m_onlyDecodeKeyFrame = next.onlyDecodeKeyFrame;
                    thumbnailSequence.m_thumbnailAspectRatio = next.thumbnailAspectRatio;
                    this.m_thumbnailSequenceArray.add(thumbnailSequence);
                    OplusGLSurfaceView_13++;
                    OplusGLSurfaceView_15 = next.outPoint;
                }
            }
        }
        updateThumbnailSequenceGeometry();
    }

    public ArrayList<ThumbnailSequenceDesc> getThumbnailSequenceDescArray() {
        return this.m_descArray;
    }

    public void setThumbnailImageFillMode(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        int i2 = this.m_thumbnailImageFillMode;
        if (i2 != 1 && i2 != 0) {
            this.m_thumbnailImageFillMode = 0;
        }
        if (this.m_thumbnailImageFillMode == OplusGLSurfaceView_13) {
            return;
        }
        this.m_thumbnailImageFillMode = OplusGLSurfaceView_13;
        updateThumbnailSequenceGeometry();
    }

    public int getThumbnailImageFillMode() {
        return this.m_thumbnailImageFillMode;
    }

    public void setThumbnailAspectRatio(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        if (COUIBaseListPopupWindow_12 < 0.1f) {
            COUIBaseListPopupWindow_12 = 0.1f;
        } else if (COUIBaseListPopupWindow_12 > 10.0f) {
            COUIBaseListPopupWindow_12 = 10.0f;
        }
        if (Math.abs(this.m_thumbnailAspectRatio - COUIBaseListPopupWindow_12) < 0.001f) {
            return;
        }
        this.m_thumbnailAspectRatio = COUIBaseListPopupWindow_12;
        updateThumbnailSequenceGeometry();
    }

    public float getThumbnailAspectRatio() {
        return this.m_thumbnailAspectRatio;
    }

    public void setPixelPerMicrosecond(double IntrinsicsJvm.kt_5) {
        NvsUtils.checkFunctionInMainThread();
        if (IntrinsicsJvm.kt_5 <= 0.0d || IntrinsicsJvm.kt_5 == this.m_pixelPerMicrosecond) {
            return;
        }
        this.m_pixelPerMicrosecond = IntrinsicsJvm.kt_5;
        updateThumbnailSequenceGeometry();
    }

    public double getPixelPerMicrosecond() {
        return this.m_pixelPerMicrosecond;
    }

    public void setStartPadding(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 == this.m_startPadding) {
            return;
        }
        this.m_startPadding = OplusGLSurfaceView_13;
        updateThumbnailSequenceGeometry();
    }

    public int getStartPadding() {
        return this.m_startPadding;
    }

    public void setEndPadding(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 == this.m_endPadding) {
            return;
        }
        this.m_endPadding = OplusGLSurfaceView_13;
        updateThumbnailSequenceGeometry();
    }

    public int getEndPadding() {
        return this.m_endPadding;
    }

    public void setMaxTimelinePosToScroll(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        long jMax = Math.max(OplusGLSurfaceView_13, 0);
        if (jMax == this.m_maxTimelinePosToScroll) {
            return;
        }
        this.m_maxTimelinePosToScroll = jMax;
        updateThumbnailSequenceGeometry();
    }

    public long getMaxTimelinePosToScroll() {
        return this.m_maxTimelinePosToScroll;
    }

    public long mapTimelinePosFromX(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return (long) Math.floor((((OplusGLSurfaceView_13 + getScrollX()) - this.m_startPadding) / this.m_pixelPerMicrosecond) + 0.5d);
    }

    public int mapXFromTimelinePos(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return (((int) Math.floor((OplusGLSurfaceView_15 * this.m_pixelPerMicrosecond) + 0.5d)) + this.m_startPadding) - getScrollX();
    }

    public void scaleWithAnchor(double IntrinsicsJvm.kt_5, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (IntrinsicsJvm.kt_5 <= 0.0d) {
            return;
        }
        long jMapTimelinePosFromX = mapTimelinePosFromX(OplusGLSurfaceView_13);
        this.m_pixelPerMicrosecond *= IntrinsicsJvm.kt_5;
        updateThumbnailSequenceGeometry();
        scrollTo((getScrollX() + mapXFromTimelinePos(jMapTimelinePosFromX)) - OplusGLSurfaceView_13, 0);
    }

    public void setOnScrollChangeListenser(OnScrollChangeListener onScrollChangeListener) {
        NvsUtils.checkFunctionInMainThread();
        this.m_scrollChangeListener = onScrollChangeListener;
    }

    public OnScrollChangeListener getOnScrollChangeListenser() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_scrollChangeListener;
    }

    public void setScrollEnabled(boolean z) {
        this.m_scrollEnabled = z;
    }

    public boolean getScrollEnabled() {
        return this.m_scrollEnabled;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.m_iconGenerator = new NvsIconGenerator();
        this.m_iconGenerator.setIconCallback(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cancelIconTask();
        this.m_scrollChangeListener = null;
        NvsIconGenerator nvsIconGenerator = this.m_iconGenerator;
        if (nvsIconGenerator != null) {
            nvsIconGenerator.release();
            this.m_iconGenerator = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onScrollChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onScrollChanged(OplusGLSurfaceView_13, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.m_scrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(this, OplusGLSurfaceView_13, i3);
        }
        updateThumbnails();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m_scrollEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.m_scrollEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private void init(Context context) {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.m_contentView = new ContentView(context);
        addView(this.m_contentView, new FrameLayout.LayoutParams(-2, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUpdateThumbnailSequenceGeometry() {
        new Handler().post(new Runnable() { // from class: com.meicam.sdk.NvsMultiThumbnailSequenceView.1
            @Override // java.lang.Runnable
            public void run() {
                NvsMultiThumbnailSequenceView.this.updateThumbnailSequenceGeometry();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateThumbnailSequenceGeometry() {
        int iMax;
        cancelIconTask();
        clearThumbnails();
        if (getHeight() == 0) {
            return;
        }
        this.m_thumbnailSequenceMap.clear();
        int OplusGLSurfaceView_13 = this.m_startPadding;
        this.m_maxThumbnailWidth = 0;
        Iterator<ThumbnailSequence> it = this.m_thumbnailSequenceArray.iterator();
        while (it.hasNext()) {
            ThumbnailSequence next = it.next();
            next.m_flags &= -3;
            int iFloor = ((int) Math.floor((next.m_inPoint * this.m_pixelPerMicrosecond) + 0.5d)) + this.m_startPadding;
            int iFloor2 = ((int) Math.floor((next.m_outPoint * this.m_pixelPerMicrosecond) + 0.5d)) + this.m_startPadding;
            if (iFloor2 > iFloor) {
                next.m_x = iFloor;
                next.m_width = iFloor2 - iFloor;
                next.m_thumbnailWidth = (int) Math.floor((r0 * (next.m_thumbnailAspectRatio > 0.0f ? next.m_thumbnailAspectRatio : this.m_thumbnailAspectRatio)) + 0.5d);
                next.m_thumbnailWidth = Math.max(next.m_thumbnailWidth, 1);
                this.m_maxThumbnailWidth = Math.max(next.m_thumbnailWidth, this.m_maxThumbnailWidth);
                this.m_thumbnailSequenceMap.put(Integer.valueOf(iFloor), next);
                OplusGLSurfaceView_13 = iFloor2;
            }
        }
        long OplusGLSurfaceView_15 = this.m_maxTimelinePosToScroll;
        if (OplusGLSurfaceView_15 <= 0) {
            OplusGLSurfaceView_13 += this.m_endPadding;
        } else {
            int iFloor3 = (int) Math.floor(this.m_startPadding + (OplusGLSurfaceView_15 * this.m_pixelPerMicrosecond) + 0.5d);
            if (iFloor3 < OplusGLSurfaceView_13) {
                OplusGLSurfaceView_13 = iFloor3;
            }
        }
        this.m_contentWidth = OplusGLSurfaceView_13;
        this.m_contentView.layout(0, 0, this.m_contentWidth, getHeight());
        this.m_contentView.requestLayout();
        if (getWidth() + getScrollX() <= this.m_contentWidth || (iMax = Math.max(getScrollX() - ((getWidth() + getScrollX()) - this.m_contentWidth), 0)) == getScrollX()) {
            return;
        }
        scrollTo(iMax, 0);
    }

    private static class ClipImageView extends ImageView {
        private int m_clipWidth;

        ClipImageView(Context context, int OplusGLSurfaceView_13) {
            super(context);
            this.m_clipWidth = OplusGLSurfaceView_13;
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.clipRect(new Rect(0, 0, this.m_clipWidth, getHeight()));
            super.onDraw(canvas);
        }
    }

    public void updateThumbnails() {
        Drawable drawable;
        Bitmap bitmap;
        int OplusGLSurfaceView_13;
        boolean z;
        if (this.m_iconGenerator == null) {
            return;
        }
        if (this.m_thumbnailSequenceMap.isEmpty()) {
            clearThumbnails();
            return;
        }
        int i2 = this.m_maxThumbnailWidth;
        int scrollX = getScrollX();
        int width = getWidth();
        int iMax = Math.max(scrollX - i2, this.m_startPadding);
        int i3 = width + iMax + i2;
        if (i3 <= iMax) {
            clearThumbnails();
            return;
        }
        Integer numFloorKey = this.m_thumbnailSequenceMap.floorKey(Integer.valueOf(iMax));
        if (numFloorKey == null) {
            numFloorKey = this.m_thumbnailSequenceMap.firstKey();
        }
        Iterator<Map.Entry<Integer, ThumbnailSequence>> it = this.m_thumbnailSequenceMap.tailMap(numFloorKey).entrySet().iterator();
        while (it.hasNext()) {
            ThumbnailSequence value = it.next().getValue();
            if (value.m_x + value.m_width >= iMax) {
                if (value.m_x >= i3) {
                    break;
                }
                if (value.m_x < iMax) {
                    OplusGLSurfaceView_13 = value.m_x + (((iMax - value.m_x) / value.m_thumbnailWidth) * value.m_thumbnailWidth);
                } else {
                    OplusGLSurfaceView_13 = value.m_x;
                }
                int i4 = value.m_x + value.m_width;
                while (true) {
                    if (OplusGLSurfaceView_13 >= i4) {
                        z = false;
                        break;
                    }
                    if (OplusGLSurfaceView_13 >= i3) {
                        z = true;
                        break;
                    }
                    int i5 = value.m_thumbnailWidth;
                    if (OplusGLSurfaceView_13 + i5 > i4) {
                        i5 = i4 - OplusGLSurfaceView_13;
                    }
                    long jCalcTimestampFromX = value.calcTimestampFromX(OplusGLSurfaceView_13);
                    ThumbnailId thumbnailId = new ThumbnailId(value.m_index, jCalcTimestampFromX);
                    Thumbnail thumbnail = this.m_thumbnailMap.get(thumbnailId);
                    if (thumbnail == null) {
                        Thumbnail thumbnail2 = new Thumbnail();
                        thumbnail2.m_owner = value;
                        thumbnail2.m_timestamp = jCalcTimestampFromX;
                        thumbnail2.m_imageViewUpToDate = false;
                        thumbnail2.m_touched = true;
                        this.m_thumbnailMap.put(thumbnailId, thumbnail2);
                        if (i5 == value.m_thumbnailWidth) {
                            thumbnail2.m_imageView = new ImageView(getContext());
                        } else {
                            thumbnail2.m_imageView = new ClipImageView(getContext(), i5);
                        }
                        int i6 = this.m_thumbnailImageFillMode;
                        if (i6 == 0) {
                            thumbnail2.m_imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        } else if (i6 == 1) {
                            thumbnail2.m_imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                        this.m_contentView.addView(thumbnail2.m_imageView);
                        thumbnail2.m_imageView.layout(OplusGLSurfaceView_13, 0, value.m_thumbnailWidth + OplusGLSurfaceView_13, this.m_contentView.getHeight());
                    } else {
                        thumbnail.m_touched = true;
                    }
                    OplusGLSurfaceView_13 += i5;
                }
                if (z) {
                    break;
                }
            }
        }
        this.m_updatingThumbnail = true;
        TreeMap treeMap = new TreeMap();
        Iterator<Map.Entry<ThumbnailId, Thumbnail>> it2 = this.m_thumbnailMap.entrySet().iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            Map.Entry<ThumbnailId, Thumbnail> next = it2.next();
            Thumbnail value2 = next.getValue();
            if (value2.m_imageView != null && (drawable = value2.m_imageView.getDrawable()) != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                this.m_placeholderBitmap = bitmap;
            }
            if (!value2.m_touched) {
                if (value2.m_iconTaskId != 0) {
                    this.m_iconGenerator.cancelTask(value2.m_iconTaskId);
                }
                this.m_contentView.removeView(value2.m_imageView);
                it2.remove();
            } else {
                value2.m_touched = false;
                if (value2.m_imageViewUpToDate) {
                    treeMap.put(next.getKey(), ((BitmapDrawable) value2.m_imageView.getDrawable()).getBitmap());
                } else {
                    long OplusGLSurfaceView_15 = value2.m_owner.m_stillImageHint ? 0L : value2.m_timestamp;
                    updateKeyframeOnlyModeForThumbnailSequence(value2.m_owner);
                    int i7 = (value2.m_owner.m_flags & 1) != 0 ? 1 : 0;
                    Bitmap iconFromCache = this.m_iconGenerator.getIconFromCache(value2.m_owner.m_mediaFilePath, OplusGLSurfaceView_15, i7);
                    if (iconFromCache != null) {
                        treeMap.put(next.getKey(), iconFromCache);
                        if (setBitmapToThumbnail(iconFromCache, value2)) {
                            value2.m_imageViewUpToDate = true;
                            value2.m_iconTaskId = 0L;
                        }
                    } else {
                        value2.m_iconTaskId = this.m_iconGenerator.getIcon(value2.m_owner.m_mediaFilePath, OplusGLSurfaceView_15, i7);
                        z2 = true;
                    }
                }
            }
        }
        this.m_updatingThumbnail = false;
        if (z2) {
            if (treeMap.isEmpty()) {
                if (this.m_placeholderBitmap != null) {
                    Iterator<Map.Entry<ThumbnailId, Thumbnail>> it3 = this.m_thumbnailMap.entrySet().iterator();
                    while (it3.hasNext()) {
                        Thumbnail value3 = it3.next().getValue();
                        if (!value3.m_imageViewUpToDate) {
                            setBitmapToThumbnail(this.m_placeholderBitmap, value3);
                        }
                    }
                    return;
                }
                return;
            }
            for (Map.Entry<ThumbnailId, Thumbnail> entry : this.m_thumbnailMap.entrySet()) {
                Thumbnail value4 = entry.getValue();
                if (!value4.m_imageViewUpToDate) {
                    Map.Entry entryCeilingEntry = treeMap.ceilingEntry(entry.getKey());
                    if (entryCeilingEntry != null) {
                        setBitmapToThumbnail((Bitmap) entryCeilingEntry.getValue(), value4);
                    } else {
                        setBitmapToThumbnail((Bitmap) treeMap.lastEntry().getValue(), value4);
                    }
                }
            }
        }
    }

    private void updateKeyframeOnlyModeForThumbnailSequence(ThumbnailSequence thumbnailSequence) {
        if ((thumbnailSequence.m_flags & 2) != 0) {
            return;
        }
        if (thumbnailSequence.m_onlyDecodeKeyFrame) {
            thumbnailSequence.m_flags |= 3;
            return;
        }
        if (shouldDecodecKeyFrameOnly(thumbnailSequence.m_mediaFilePath, Math.max((long) ((thumbnailSequence.m_thumbnailWidth / this.m_pixelPerMicrosecond) + 0.5d), 1L))) {
            thumbnailSequence.m_flags |= 1;
        } else {
            thumbnailSequence.m_flags &= -2;
        }
        thumbnailSequence.m_flags |= 2;
    }

    private boolean shouldDecodecKeyFrameOnly(String str, long OplusGLSurfaceView_15) {
        NvsAVFileInfo aVFileInfo;
        NvsRational videoStreamFrameRate;
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        if (nvsStreamingContext == null || (aVFileInfo = nvsStreamingContext.getAVFileInfo(str)) == null || aVFileInfo.getVideoStreamCount() < 1 || (videoStreamFrameRate = aVFileInfo.getVideoStreamFrameRate(0)) == null || videoStreamFrameRate.den <= 0 || videoStreamFrameRate.num <= 0 || aVFileInfo.getVideoStreamDuration(0) < OplusGLSurfaceView_15) {
            return false;
        }
        int iDetectVideoFileKeyframeInterval = nvsStreamingContext.detectVideoFileKeyframeInterval(str);
        if (iDetectVideoFileKeyframeInterval == 0) {
            iDetectVideoFileKeyframeInterval = 30;
        } else if (iDetectVideoFileKeyframeInterval == 1) {
            return false;
        }
        int OplusGLSurfaceView_13 = (int) (iDetectVideoFileKeyframeInterval * (videoStreamFrameRate.den / videoStreamFrameRate.num) * 1000000.0d);
        if (iDetectVideoFileKeyframeInterval <= 30) {
            if (OplusGLSurfaceView_15 > OplusGLSurfaceView_13 * 0.9d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 60) {
            if (OplusGLSurfaceView_15 > OplusGLSurfaceView_13 * 0.8d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 100) {
            if (OplusGLSurfaceView_15 > OplusGLSurfaceView_13 * 0.7d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 150) {
            if (OplusGLSurfaceView_15 > OplusGLSurfaceView_13 * 0.5d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 250) {
            if (OplusGLSurfaceView_15 > OplusGLSurfaceView_13 * 0.3d) {
                return true;
            }
        } else if (OplusGLSurfaceView_15 > OplusGLSurfaceView_13 * 0.2d) {
            return true;
        }
        return false;
    }

    private boolean setBitmapToThumbnail(Bitmap bitmap, Thumbnail thumbnail) {
        if (bitmap == null || thumbnail.m_imageView == null) {
            return false;
        }
        thumbnail.m_imageView.setImageBitmap(bitmap);
        return true;
    }

    private void clearThumbnailSequences() {
        cancelIconTask();
        clearThumbnails();
        this.m_thumbnailSequenceArray.clear();
        this.m_thumbnailSequenceMap.clear();
        this.m_contentWidth = 0;
    }

    private void clearThumbnails() {
        Iterator<Map.Entry<ThumbnailId, Thumbnail>> it = this.m_thumbnailMap.entrySet().iterator();
        while (it.hasNext()) {
            this.m_contentView.removeView(it.next().getValue().m_imageView);
        }
        this.m_thumbnailMap.clear();
    }

    private void cancelIconTask() {
        NvsIconGenerator nvsIconGenerator = this.m_iconGenerator;
        if (nvsIconGenerator != null) {
            nvsIconGenerator.cancelTask(0L);
        }
    }

    @Override // com.meicam.sdk.NvsIconGenerator.IconCallback
    public void onIconReady(Bitmap bitmap, long OplusGLSurfaceView_15, long j2) {
        if (!this.m_updatingThumbnail) {
            updateThumbnails();
        } else {
            new Handler().post(new Runnable() { // from class: com.meicam.sdk.NvsMultiThumbnailSequenceView.2
                @Override // java.lang.Runnable
                public void run() {
                    NvsMultiThumbnailSequenceView.this.updateThumbnails();
                }
            });
        }
    }
}
