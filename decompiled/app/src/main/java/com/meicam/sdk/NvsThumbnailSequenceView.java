package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsThumbnailSequenceView extends android.view.ViewGroup {
    private long m_duration;
    private com.meicam.sdk.NvsMultiThumbnailSequenceView m_internalView;
    private java.lang.String m_mediaFilePath;
    private boolean m_needsUpdateInternalView;
    private long m_startTime;
    private boolean m_stillImageHint;
    private float m_thumbnailAspectRatio;
    private int m_thumbnailImageFillMode;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public NvsThumbnailSequenceView(android.content.Context context) {
        super(context);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsThumbnailSequenceView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsThumbnailSequenceView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    public NvsThumbnailSequenceView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.m_startTime = 0L;
        this.m_duration = 4000000L;
        this.m_thumbnailAspectRatio = 0.5625f;
        this.m_stillImageHint = false;
        this.m_thumbnailImageFillMode = 0;
        this.m_needsUpdateInternalView = false;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init(context);
    }

    private void init(android.content.Context context) {
        this.m_internalView = new com.meicam.sdk.NvsMultiThumbnailSequenceView(context);
        this.m_internalView.setScrollEnabled(false);
        addView(this.m_internalView, new android.view.ViewGroup.LayoutParams(-1, -1));
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
        updateInternalView();
    }

    public int getThumbnailImageFillMode() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_thumbnailImageFillMode;
    }

    public void setMediaFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        java.lang.String str2 = this.m_mediaFilePath;
        if (str2 == null || str == null || !str2.equals(str)) {
            this.m_mediaFilePath = str;
            updateInternalView();
        }
    }

    public java.lang.String getMediaFilePath() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_mediaFilePath;
    }

    public void setStartTime(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (j_renamed < 0) {
            j_renamed = 0;
        }
        if (j_renamed == this.m_startTime) {
            return;
        }
        this.m_startTime = j_renamed;
        updateInternalView();
    }

    public long getStartTime() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_startTime;
    }

    public void setDuration(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (j_renamed <= 0) {
            j_renamed = 1;
        }
        if (j_renamed == this.m_duration) {
            return;
        }
        this.m_duration = j_renamed;
        updateInternalView();
    }

    public long getDuration() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_duration;
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
        updateInternalView();
    }

    public float getThumbnailAspectRatio() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_thumbnailAspectRatio;
    }

    public void setStillImageHint(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (z_renamed == this.m_stillImageHint) {
            return;
        }
        this.m_stillImageHint = z_renamed;
        updateInternalView();
    }

    public boolean getStillImageHint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_stillImageHint;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        this.m_internalView.measure(i_renamed, i2);
        super.onMeasure(i_renamed, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        this.m_internalView.layout(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        if (i3 != i_renamed) {
            updateInternalView();
        }
        super.onSizeChanged(i_renamed, i2, i3, i4);
    }

    private void updateInternalView() {
        this.m_needsUpdateInternalView = true;
        new android.os.Handler().post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsThumbnailSequenceView.1
            @Override // java.lang.Runnable
            public void run() {
                com.meicam.sdk.NvsThumbnailSequenceView.this.doUpdateInternalView();
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
            com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc thumbnailSequenceDesc = new com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc();
            thumbnailSequenceDesc.mediaFilePath = this.m_mediaFilePath;
            thumbnailSequenceDesc.inPoint = 0L;
            thumbnailSequenceDesc.outPoint = this.m_duration;
            thumbnailSequenceDesc.trimIn = this.m_startTime;
            thumbnailSequenceDesc.trimOut = thumbnailSequenceDesc.trimIn + this.m_duration;
            thumbnailSequenceDesc.stillImageHint = this.m_stillImageHint;
            java.util.ArrayList<com.meicam.sdk.NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc> arrayList = new java.util.ArrayList<>();
            arrayList.add(thumbnailSequenceDesc);
            this.m_internalView.setThumbnailSequenceDescArray(arrayList);
        }
    }
}
