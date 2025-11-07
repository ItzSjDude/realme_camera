package com.meicam.sdk;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.meicam.sdk.NvsMultiThumbnailSequenceView;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class NvsThumbnailSequenceView extends ViewGroup {
    private long m_duration;
    private NvsMultiThumbnailSequenceView m_internalView;
    private String m_mediaFilePath;
    private boolean m_needsUpdateInternalView;
    private long m_startTime;
    private boolean m_stillImageHint;
    private float m_thumbnailAspectRatio;
    private int m_thumbnailImageFillMode;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public NvsThumbnailSequenceView(Context context) {
        super(context);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsThumbnailSequenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsThumbnailSequenceView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsThumbnailSequenceView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    private void init(Context context) {
        this.m_internalView = new NvsMultiThumbnailSequenceView(context);
        this.m_internalView.setScrollEnabled(false);
        addView(this.m_internalView, new ViewGroup.LayoutParams(-1, -1));
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
        updateInternalView();
    }

    public int getThumbnailImageFillMode() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_thumbnailImageFillMode;
    }

    public void setMediaFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        String str2 = this.m_mediaFilePath;
        if (str2 == null || str == null || !str2.equals(str)) {
            this.m_mediaFilePath = str;
            updateInternalView();
        }
    }

    public String getMediaFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_mediaFilePath;
    }

    public void setStartTime(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_15 < 0) {
            OplusGLSurfaceView_15 = 0;
        }
        if (OplusGLSurfaceView_15 == this.m_startTime) {
            return;
        }
        this.m_startTime = OplusGLSurfaceView_15;
        updateInternalView();
    }

    public long getStartTime() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_startTime;
    }

    public void setDuration(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_15 <= 0) {
            OplusGLSurfaceView_15 = 1;
        }
        if (OplusGLSurfaceView_15 == this.m_duration) {
            return;
        }
        this.m_duration = OplusGLSurfaceView_15;
        updateInternalView();
    }

    public long getDuration() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_duration;
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
        updateInternalView();
    }

    public float getThumbnailAspectRatio() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_thumbnailAspectRatio;
    }

    public void setStillImageHint(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        if (z == this.m_stillImageHint) {
            return;
        }
        this.m_stillImageHint = z;
        updateInternalView();
    }

    public boolean getStillImageHint() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_stillImageHint;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        this.m_internalView.measure(OplusGLSurfaceView_13, i2);
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.m_internalView.layout(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i3 != OplusGLSurfaceView_13) {
            updateInternalView();
        }
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
    }

    private void updateInternalView() {
        this.m_needsUpdateInternalView = true;
        new Handler().post(new Runnable() { // from class: com.meicam.sdk.NvsThumbnailSequenceView.1
            @Override // java.lang.Runnable
            public void run() {
                NvsThumbnailSequenceView.this.doUpdateInternalView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateInternalView() {
        if (this.m_needsUpdateInternalView) {
            this.m_needsUpdateInternalView = false;
            this.m_internalView.setThumbnailAspectRatio(this.m_thumbnailAspectRatio);
            this.m_internalView.setPixelPerMicrosecond(getWidth() / this.m_duration);
            this.m_internalView.setThumbnailImageFillMode(this.m_thumbnailImageFillMode);
            if (this.m_mediaFilePath == null) {
                this.m_internalView.setThumbnailSequenceDescArray(null);
                return;
            }
            NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc thumbnailSequenceDesc = new NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc();
            thumbnailSequenceDesc.mediaFilePath = this.m_mediaFilePath;
            thumbnailSequenceDesc.inPoint = 0L;
            thumbnailSequenceDesc.outPoint = this.m_duration;
            thumbnailSequenceDesc.trimIn = this.m_startTime;
            thumbnailSequenceDesc.trimOut = thumbnailSequenceDesc.trimIn + this.m_duration;
            thumbnailSequenceDesc.stillImageHint = this.m_stillImageHint;
            ArrayList<NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> arrayList = new ArrayList<>();
            arrayList.add(thumbnailSequenceDesc);
            this.m_internalView.setThumbnailSequenceDescArray(arrayList);
        }
    }
}
