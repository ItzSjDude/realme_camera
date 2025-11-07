package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsMultiThumbnailSequenceView extends android.widget.HorizontalScrollView implements com.meicam.sdk.NvsIconGenerator.IconCallback {
    private static final java.lang.String TAG = "Meicam";
    public static final int THUMBNAIL_IMAGE_FILLMODE_ASPECTCROP = 1;
    public static final int THUMBNAIL_IMAGE_FILLMODE_STRETCH = 0;
    private static final int THUMBNAIL_SEQUENCE_FLAGS_CACHED_KEYFRAME_ONLY = 1;
    private static final int THUMBNAIL_SEQUENCE_FLAGS_CACHED_KEYFRAME_ONLY_VALID = 2;
    private com.meicam.sdk.NvsMultiThumbnailSequenceView.ContentView m_contentView;
    private int m_contentWidth;
    private java.util.ArrayList<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> m_descArray;
    private int m_endPadding;
    private com.meicam.sdk.NvsIconGenerator m_iconGenerator;
    private int m_maxThumbnailWidth;
    private long m_maxTimelinePosToScroll;
    private double m_pixelPerMicrosecond;
    android.graphics.Bitmap m_placeholderBitmap;
    private com.meicam.sdk.NvsMultiThumbnailSequenceView.OnScrollChangeListener m_scrollChangeListener;
    private boolean m_scrollEnabled;
    private int m_startPadding;
    private float m_thumbnailAspectRatio;
    private int m_thumbnailImageFillMode;
    private java.util.TreeMap<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId, com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail> m_thumbnailMap;
    private java.util.ArrayList<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence> m_thumbnailSequenceArray;
    private java.util.TreeMap<java.lang.Integer, com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence> m_thumbnailSequenceMap;
    private boolean m_updatingThumbnail;

    public interface OnScrollChangeListener {
        void onScrollChanged(com.meicam.sdk.NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView, int i_renamed, int i2);
    }

    private static class Thumbnail {
        android.widget.ImageView m_imageView;
        com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence m_owner;
        long m_timestamp = 0;
        long m_iconTaskId = 0;
        boolean m_imageViewUpToDate = false;
        boolean m_touched = false;
    }

    public static class ThumbnailSequenceDesc {
        public java.lang.String mediaFilePath;
        public long inPoint = 0;
        public long outPoint = 4000000;
        public long trimIn = 0;
        public long trimOut = 4000000;
        public boolean stillImageHint = false;
        public boolean onlyDecodeKeyFrame = false;
        public float thumbnailAspectRatio = 0.0f;
    }

    private static class ThumbnailSequence {
        java.lang.String m_mediaFilePath;
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

        public long calcTimestampFromX(int i_renamed) {
            return this.m_trimIn + ((long) java.lang.Math.floor((((i_renamed - this.m_x) / this.m_width) * this.m_trimDuration) + 0.5d));
        }
    }

    private static class ThumbnailId implements java.lang.Comparable<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId> {
        public int m_seqIndex;
        public long m_timestamp;

        public ThumbnailId(int i_renamed, long j_renamed) {
            this.m_seqIndex = i_renamed;
            this.m_timestamp = j_renamed;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId thumbnailId) {
            int i_renamed = this.m_seqIndex;
            int i2 = thumbnailId.m_seqIndex;
            if (i_renamed < i2) {
                return -1;
            }
            if (i_renamed > i2) {
                return 1;
            }
            long j_renamed = this.m_timestamp;
            long j2 = thumbnailId.m_timestamp;
            if (j_renamed < j2) {
                return -1;
            }
            return j_renamed > j2 ? 1 : 0;
        }
    }

    private class ContentView extends android.view.ViewGroup {
        @Override // android.view.ViewGroup
        public boolean shouldDelayChildPressedState() {
            return false;
        }

        public ContentView(android.content.Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int i_renamed, int i2) {
            int i3 = com.meicam.sdk.NvsMultiThumbnailSequenceView.this.m_contentWidth;
            int mode = android.view.View.MeasureSpec.getMode(i2);
            int size = android.view.View.MeasureSpec.getSize(i2);
            if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
                size = com.meicam.sdk.NvsMultiThumbnailSequenceView.this.getHeight();
            }
            setMeasuredDimension(resolveSizeAndState(java.lang.Math.max(i3, getSuggestedMinimumWidth()), i_renamed, 0), resolveSizeAndState(java.lang.Math.max(size, getSuggestedMinimumHeight()), i2, 0));
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
            com.meicam.sdk.NvsMultiThumbnailSequenceView.this.updateThumbnails();
        }

        @Override // android.view.View
        protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
            if (i2 != i4) {
                com.meicam.sdk.NvsMultiThumbnailSequenceView.this.requestUpdateThumbnailSequenceGeometry();
            }
            super.onSizeChanged(i_renamed, i2, i3, i4);
        }
    }

    public NvsMultiThumbnailSequenceView(android.content.Context context) {
        super(context);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new java.util.ArrayList<>();
        this.m_thumbnailSequenceMap = new java.util.TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new java.util.TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsMultiThumbnailSequenceView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new java.util.ArrayList<>();
        this.m_thumbnailSequenceMap = new java.util.TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new java.util.TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsMultiThumbnailSequenceView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new java.util.ArrayList<>();
        this.m_thumbnailSequenceMap = new java.util.TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new java.util.TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsMultiThumbnailSequenceView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.m_iconGenerator = null;
        this.m_scrollEnabled = true;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_pixelPerMicrosecond = 7.2E-5d;
        this.m_startPadding = 0;
        this.m_endPadding = 0;
        this.m_thumbnailImageFillMode = 0;
        this.m_maxTimelinePosToScroll = 0L;
        this.m_thumbnailSequenceArray = new java.util.ArrayList<>();
        this.m_thumbnailSequenceMap = new java.util.TreeMap<>();
        this.m_contentWidth = 0;
        this.m_thumbnailMap = new java.util.TreeMap<>();
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public void setThumbnailSequenceDescArray(java.util.ArrayList<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> arrayList) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (arrayList == this.m_descArray) {
            return;
        }
        clearThumbnailSequences();
        this.m_placeholderBitmap = null;
        this.m_descArray = arrayList;
        if (arrayList != null) {
            int i_renamed = 0;
            java.util.Iterator<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> it = arrayList.iterator();
            long j_renamed = 0;
            while (it.hasNext()) {
                com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc next = it.next();
                if (next.mediaFilePath == null || next.inPoint < j_renamed || next.outPoint <= next.inPoint || next.trimIn < 0 || next.trimOut <= next.trimIn) {
                    android.util.Log.e_renamed(TAG, "Invalid ThumbnailSequenceDesc!");
                } else {
                    com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence thumbnailSequence = new com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence();
                    thumbnailSequence.m_index = i_renamed;
                    thumbnailSequence.m_mediaFilePath = next.mediaFilePath;
                    thumbnailSequence.m_inPoint = next.inPoint;
                    thumbnailSequence.m_outPoint = next.outPoint;
                    thumbnailSequence.m_trimIn = next.trimIn;
                    thumbnailSequence.m_trimDuration = next.trimOut - next.trimIn;
                    thumbnailSequence.m_stillImageHint = next.stillImageHint;
                    thumbnailSequence.m_onlyDecodeKeyFrame = next.onlyDecodeKeyFrame;
                    thumbnailSequence.m_thumbnailAspectRatio = next.thumbnailAspectRatio;
                    this.m_thumbnailSequenceArray.add(thumbnailSequence);
                    i_renamed++;
                    j_renamed = next.outPoint;
                }
            }
        }
        updateThumbnailSequenceGeometry();
    }

    public java.util.ArrayList<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> getThumbnailSequenceDescArray() {
        return this.m_descArray;
    }

    public void setThumbnailImageFillMode(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        int i2 = this.m_thumbnailImageFillMode;
        if (i2 != 1 && i2 != 0) {
            this.m_thumbnailImageFillMode = 0;
        }
        if (this.m_thumbnailImageFillMode == i_renamed) {
            return;
        }
        this.m_thumbnailImageFillMode = i_renamed;
        updateThumbnailSequenceGeometry();
    }

    public int getThumbnailImageFillMode() {
        return this.m_thumbnailImageFillMode;
    }

    public void setThumbnailAspectRatio(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (f_renamed < 0.1f) {
            f_renamed = 0.1f;
        } else if (f_renamed > 10.0f) {
            f_renamed = 10.0f;
        }
        if (java.lang.Math.abs(this.m_thumbnailAspectRatio - f_renamed) < 0.001f) {
            return;
        }
        this.m_thumbnailAspectRatio = f_renamed;
        updateThumbnailSequenceGeometry();
    }

    public float getThumbnailAspectRatio() {
        return this.m_thumbnailAspectRatio;
    }

    public void setPixelPerMicrosecond(double d_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (d_renamed <= 0.0d || d_renamed == this.m_pixelPerMicrosecond) {
            return;
        }
        this.m_pixelPerMicrosecond = d_renamed;
        updateThumbnailSequenceGeometry();
    }

    public double getPixelPerMicrosecond() {
        return this.m_pixelPerMicrosecond;
    }

    public void setStartPadding(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed < 0 || i_renamed == this.m_startPadding) {
            return;
        }
        this.m_startPadding = i_renamed;
        updateThumbnailSequenceGeometry();
    }

    public int getStartPadding() {
        return this.m_startPadding;
    }

    public void setEndPadding(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed < 0 || i_renamed == this.m_endPadding) {
            return;
        }
        this.m_endPadding = i_renamed;
        updateThumbnailSequenceGeometry();
    }

    public int getEndPadding() {
        return this.m_endPadding;
    }

    public void setMaxTimelinePosToScroll(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        long jMax = java.lang.Math.max(i_renamed, 0);
        if (jMax == this.m_maxTimelinePosToScroll) {
            return;
        }
        this.m_maxTimelinePosToScroll = jMax;
        updateThumbnailSequenceGeometry();
    }

    public long getMaxTimelinePosToScroll() {
        return this.m_maxTimelinePosToScroll;
    }

    public long mapTimelinePosFromX(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return (long) java.lang.Math.floor((((i_renamed + getScrollX()) - this.m_startPadding) / this.m_pixelPerMicrosecond) + 0.5d);
    }

    public int mapXFromTimelinePos(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return (((int) java.lang.Math.floor((j_renamed * this.m_pixelPerMicrosecond) + 0.5d)) + this.m_startPadding) - getScrollX();
    }

    public void scaleWithAnchor(double d_renamed, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (d_renamed <= 0.0d) {
            return;
        }
        long jMapTimelinePosFromX = mapTimelinePosFromX(i_renamed);
        this.m_pixelPerMicrosecond *= d_renamed;
        updateThumbnailSequenceGeometry();
        scrollTo((getScrollX() + mapXFromTimelinePos(jMapTimelinePosFromX)) - i_renamed, 0);
    }

    public void setOnScrollChangeListenser(com.meicam.sdk.NvsMultiThumbnailSequenceView.OnScrollChangeListener onScrollChangeListener) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_scrollChangeListener = onScrollChangeListener;
    }

    public com.meicam.sdk.NvsMultiThumbnailSequenceView.OnScrollChangeListener getOnScrollChangeListenser() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_scrollChangeListener;
    }

    public void setScrollEnabled(boolean z_renamed) {
        this.m_scrollEnabled = z_renamed;
    }

    public boolean getScrollEnabled() {
        return this.m_scrollEnabled;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.m_iconGenerator = new com.meicam.sdk.NvsIconGenerator();
        this.m_iconGenerator.setIconCallback(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cancelIconTask();
        this.m_scrollChangeListener = null;
        com.meicam.sdk.NvsIconGenerator nvsIconGenerator = this.m_iconGenerator;
        if (nvsIconGenerator != null) {
            nvsIconGenerator.release();
            this.m_iconGenerator = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i_renamed, int i2, int i3, int i4) {
        super.onScrollChanged(i_renamed, i2, i3, i4);
        com.meicam.sdk.NvsMultiThumbnailSequenceView.OnScrollChangeListener onScrollChangeListener = this.m_scrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(this, i_renamed, i3);
        }
        updateThumbnails();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.m_scrollEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.m_scrollEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private void init(android.content.Context context) {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.m_contentView = new com.meicam.sdk.NvsMultiThumbnailSequenceView.ContentView(context);
        addView(this.m_contentView, new android.widget.FrameLayout.LayoutParams(-2, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUpdateThumbnailSequenceGeometry() {
        new android.os.Handler().post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsMultiThumbnailSequenceView.1
            @Override // java.lang.Runnable
            public void run() {
                com.meicam.sdk.NvsMultiThumbnailSequenceView.this.updateThumbnailSequenceGeometry();
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
        int i_renamed = this.m_startPadding;
        this.m_maxThumbnailWidth = 0;
        java.util.Iterator<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence> it = this.m_thumbnailSequenceArray.iterator();
        while (it.hasNext()) {
            com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence next = it.next();
            next.m_flags &= -3;
            int iFloor = ((int) java.lang.Math.floor((next.m_inPoint * this.m_pixelPerMicrosecond) + 0.5d)) + this.m_startPadding;
            int iFloor2 = ((int) java.lang.Math.floor((next.m_outPoint * this.m_pixelPerMicrosecond) + 0.5d)) + this.m_startPadding;
            if (iFloor2 > iFloor) {
                next.m_x = iFloor;
                next.m_width = iFloor2 - iFloor;
                next.m_thumbnailWidth = (int) java.lang.Math.floor((r0 * (next.m_thumbnailAspectRatio > 0.0f ? next.m_thumbnailAspectRatio : this.m_thumbnailAspectRatio)) + 0.5d);
                next.m_thumbnailWidth = java.lang.Math.max(next.m_thumbnailWidth, 1);
                this.m_maxThumbnailWidth = java.lang.Math.max(next.m_thumbnailWidth, this.m_maxThumbnailWidth);
                this.m_thumbnailSequenceMap.put(java.lang.Integer.valueOf(iFloor), next);
                i_renamed = iFloor2;
            }
        }
        long j_renamed = this.m_maxTimelinePosToScroll;
        if (j_renamed <= 0) {
            i_renamed += this.m_endPadding;
        } else {
            int iFloor3 = (int) java.lang.Math.floor(this.m_startPadding + (j_renamed * this.m_pixelPerMicrosecond) + 0.5d);
            if (iFloor3 < i_renamed) {
                i_renamed = iFloor3;
            }
        }
        this.m_contentWidth = i_renamed;
        this.m_contentView.layout(0, 0, this.m_contentWidth, getHeight());
        this.m_contentView.requestLayout();
        if (getWidth() + getScrollX() <= this.m_contentWidth || (iMax = java.lang.Math.max(getScrollX() - ((getWidth() + getScrollX()) - this.m_contentWidth), 0)) == getScrollX()) {
            return;
        }
        scrollTo(iMax, 0);
    }

    private static class ClipImageView extends android.widget.ImageView {
        private int m_clipWidth;

        ClipImageView(android.content.Context context, int i_renamed) {
            super(context);
            this.m_clipWidth = i_renamed;
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(android.graphics.Canvas canvas) {
            canvas.clipRect(new android.graphics.Rect(0, 0, this.m_clipWidth, getHeight()));
            super.onDraw(canvas);
        }
    }

    public void updateThumbnails() {
        android.graphics.drawable.Drawable drawable;
        android.graphics.Bitmap bitmap;
        int i_renamed;
        boolean z_renamed;
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
        int iMax = java.lang.Math.max(scrollX - i2, this.m_startPadding);
        int i3 = width + iMax + i2;
        if (i3 <= iMax) {
            clearThumbnails();
            return;
        }
        java.lang.Integer numFloorKey = this.m_thumbnailSequenceMap.floorKey(java.lang.Integer.valueOf(iMax));
        if (numFloorKey == null) {
            numFloorKey = this.m_thumbnailSequenceMap.firstKey();
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence>> it = this.m_thumbnailSequenceMap.tailMap(numFloorKey).entrySet().iterator();
        while (it.hasNext()) {
            com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence value = it.next().getValue();
            if (value.m_x + value.m_width >= iMax) {
                if (value.m_x >= i3) {
                    break;
                }
                if (value.m_x < iMax) {
                    i_renamed = value.m_x + (((iMax - value.m_x) / value.m_thumbnailWidth) * value.m_thumbnailWidth);
                } else {
                    i_renamed = value.m_x;
                }
                int i4 = value.m_x + value.m_width;
                while (true) {
                    if (i_renamed >= i4) {
                        z_renamed = false;
                        break;
                    }
                    if (i_renamed >= i3) {
                        z_renamed = true;
                        break;
                    }
                    int i5 = value.m_thumbnailWidth;
                    if (i_renamed + i5 > i4) {
                        i5 = i4 - i_renamed;
                    }
                    long jCalcTimestampFromX = value.calcTimestampFromX(i_renamed);
                    com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId thumbnailId = new com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId(value.m_index, jCalcTimestampFromX);
                    com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail thumbnail = this.m_thumbnailMap.get(thumbnailId);
                    if (thumbnail == null) {
                        com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail thumbnail2 = new com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail();
                        thumbnail2.m_owner = value;
                        thumbnail2.m_timestamp = jCalcTimestampFromX;
                        thumbnail2.m_imageViewUpToDate = false;
                        thumbnail2.m_touched = true;
                        this.m_thumbnailMap.put(thumbnailId, thumbnail2);
                        if (i5 == value.m_thumbnailWidth) {
                            thumbnail2.m_imageView = new android.widget.ImageView(getContext());
                        } else {
                            thumbnail2.m_imageView = new com.meicam.sdk.NvsMultiThumbnailSequenceView.ClipImageView(getContext(), i5);
                        }
                        int i6 = this.m_thumbnailImageFillMode;
                        if (i6 == 0) {
                            thumbnail2.m_imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                        } else if (i6 == 1) {
                            thumbnail2.m_imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                        }
                        this.m_contentView.addView(thumbnail2.m_imageView);
                        thumbnail2.m_imageView.layout(i_renamed, 0, value.m_thumbnailWidth + i_renamed, this.m_contentView.getHeight());
                    } else {
                        thumbnail.m_touched = true;
                    }
                    i_renamed += i5;
                }
                if (z_renamed) {
                    break;
                }
            }
        }
        this.m_updatingThumbnail = true;
        java.util.TreeMap treeMap = new java.util.TreeMap();
        java.util.Iterator<java.util.Map.Entry<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId, com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail>> it2 = this.m_thumbnailMap.entrySet().iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            java.util.Map.Entry<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId, com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail> next = it2.next();
            com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail value2 = next.getValue();
            if (value2.m_imageView != null && (drawable = value2.m_imageView.getDrawable()) != null && (bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap()) != null) {
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
                    treeMap.put(next.getKey(), ((android.graphics.drawable.BitmapDrawable) value2.m_imageView.getDrawable()).getBitmap());
                } else {
                    long j_renamed = value2.m_owner.m_stillImageHint ? 0L : value2.m_timestamp;
                    updateKeyframeOnlyModeForThumbnailSequence(value2.m_owner);
                    int i7 = (value2.m_owner.m_flags & 1) != 0 ? 1 : 0;
                    android.graphics.Bitmap iconFromCache = this.m_iconGenerator.getIconFromCache(value2.m_owner.m_mediaFilePath, j_renamed, i7);
                    if (iconFromCache != null) {
                        treeMap.put(next.getKey(), iconFromCache);
                        if (setBitmapToThumbnail(iconFromCache, value2)) {
                            value2.m_imageViewUpToDate = true;
                            value2.m_iconTaskId = 0L;
                        }
                    } else {
                        value2.m_iconTaskId = this.m_iconGenerator.getIcon(value2.m_owner.m_mediaFilePath, j_renamed, i7);
                        z2 = true;
                    }
                }
            }
        }
        this.m_updatingThumbnail = false;
        if (z2) {
            if (treeMap.isEmpty()) {
                if (this.m_placeholderBitmap != null) {
                    java.util.Iterator<java.util.Map.Entry<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId, com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail>> it3 = this.m_thumbnailMap.entrySet().iterator();
                    while (it3.hasNext()) {
                        com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail value3 = it3.next().getValue();
                        if (!value3.m_imageViewUpToDate) {
                            setBitmapToThumbnail(this.m_placeholderBitmap, value3);
                        }
                    }
                    return;
                }
                return;
            }
            for (java.util.Map.Entry<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId, com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail> entry : this.m_thumbnailMap.entrySet()) {
                com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail value4 = entry.getValue();
                if (!value4.m_imageViewUpToDate) {
                    java.util.Map.Entry entryCeilingEntry = treeMap.ceilingEntry(entry.getKey());
                    if (entryCeilingEntry != null) {
                        setBitmapToThumbnail((android.graphics.Bitmap) entryCeilingEntry.getValue(), value4);
                    } else {
                        setBitmapToThumbnail((android.graphics.Bitmap) treeMap.lastEntry().getValue(), value4);
                    }
                }
            }
        }
    }

    private void updateKeyframeOnlyModeForThumbnailSequence(com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequence thumbnailSequence) {
        if ((thumbnailSequence.m_flags & 2) != 0) {
            return;
        }
        if (thumbnailSequence.m_onlyDecodeKeyFrame) {
            thumbnailSequence.m_flags |= 3;
            return;
        }
        if (shouldDecodecKeyFrameOnly(thumbnailSequence.m_mediaFilePath, java.lang.Math.max((long) ((thumbnailSequence.m_thumbnailWidth / this.m_pixelPerMicrosecond) + 0.5d), 1L))) {
            thumbnailSequence.m_flags |= 1;
        } else {
            thumbnailSequence.m_flags &= -2;
        }
        thumbnailSequence.m_flags |= 2;
    }

    private boolean shouldDecodecKeyFrameOnly(java.lang.String str, long j_renamed) {
        com.meicam.sdk.NvsAVFileInfo aVFileInfo;
        com.meicam.sdk.NvsRational videoStreamFrameRate;
        com.meicam.sdk.NvsStreamingContext nvsStreamingContext = com.meicam.sdk.NvsStreamingContext.getInstance();
        if (nvsStreamingContext == null || (aVFileInfo = nvsStreamingContext.getAVFileInfo(str)) == null || aVFileInfo.getVideoStreamCount() < 1 || (videoStreamFrameRate = aVFileInfo.getVideoStreamFrameRate(0)) == null || videoStreamFrameRate.den <= 0 || videoStreamFrameRate.num <= 0 || aVFileInfo.getVideoStreamDuration(0) < j_renamed) {
            return false;
        }
        int iDetectVideoFileKeyframeInterval = nvsStreamingContext.detectVideoFileKeyframeInterval(str);
        if (iDetectVideoFileKeyframeInterval == 0) {
            iDetectVideoFileKeyframeInterval = 30;
        } else if (iDetectVideoFileKeyframeInterval == 1) {
            return false;
        }
        int i_renamed = (int) (iDetectVideoFileKeyframeInterval * (videoStreamFrameRate.den / videoStreamFrameRate.num) * 1000000.0d);
        if (iDetectVideoFileKeyframeInterval <= 30) {
            if (j_renamed > i_renamed * 0.9d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 60) {
            if (j_renamed > i_renamed * 0.8d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 100) {
            if (j_renamed > i_renamed * 0.7d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 150) {
            if (j_renamed > i_renamed * 0.5d) {
                return true;
            }
        } else if (iDetectVideoFileKeyframeInterval <= 250) {
            if (j_renamed > i_renamed * 0.3d) {
                return true;
            }
        } else if (j_renamed > i_renamed * 0.2d) {
            return true;
        }
        return false;
    }

    private boolean setBitmapToThumbnail(android.graphics.Bitmap bitmap, com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail thumbnail) {
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
        java.util.Iterator<java.util.Map.Entry<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailId, com.meicam.sdk.NvsMultiThumbnailSequenceView.Thumbnail>> it = this.m_thumbnailMap.entrySet().iterator();
        while (it.hasNext()) {
            this.m_contentView.removeView(it.next().getValue().m_imageView);
        }
        this.m_thumbnailMap.clear();
    }

    private void cancelIconTask() {
        com.meicam.sdk.NvsIconGenerator nvsIconGenerator = this.m_iconGenerator;
        if (nvsIconGenerator != null) {
            nvsIconGenerator.cancelTask(0L);
        }
    }

    @Override // com.meicam.sdk.NvsIconGenerator.IconCallback
    public void onIconReady(android.graphics.Bitmap bitmap, long j_renamed, long j2) {
        if (!this.m_updatingThumbnail) {
            updateThumbnails();
        } else {
            new android.os.Handler().post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsMultiThumbnailSequenceView.2
                @Override // java.lang.Runnable
                public void run() {
                    com.meicam.sdk.NvsMultiThumbnailSequenceView.this.updateThumbnails();
                }
            });
        }
    }
}
