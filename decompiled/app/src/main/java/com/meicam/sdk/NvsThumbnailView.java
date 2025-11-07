package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsThumbnailView extends android.view.View {
    private long m_internalObj;
    private java.lang.String m_mediaFilePath;
    private boolean m_needUpdate;
    private boolean m_painting;
    private android.graphics.Bitmap m_thumbnail;

    private native void nativeCancelIconTask(long j_renamed);

    private native void nativeClose(long j_renamed);

    private native void nativeGetThumbnail(long j_renamed, java.lang.String str);

    private native long nativeInit();

    public NvsThumbnailView(android.content.Context context) {
        super(context);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public NvsThumbnailView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public NvsThumbnailView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public NvsThumbnailView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public void setMediaFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        java.lang.String str2 = this.m_mediaFilePath;
        if (str2 == null || str == null || !str2.equals(str)) {
            this.m_mediaFilePath = str;
            this.m_needUpdate = true;
            cancelIconTask();
            invalidate();
        }
    }

    public java.lang.String getMediaFilePath() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_mediaFilePath;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        java.lang.String str = this.m_mediaFilePath;
        if (str == null || str.isEmpty()) {
            return;
        }
        if (this.m_thumbnail == null || this.m_needUpdate) {
            if (this.m_internalObj == 0) {
                return;
            }
            this.m_needUpdate = false;
            this.m_painting = true;
            if (!isInEditMode()) {
                nativeGetThumbnail(this.m_internalObj, this.m_mediaFilePath);
            }
            this.m_painting = false;
            return;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        getDrawingRect(rect);
        int width = this.m_thumbnail.getWidth();
        double d_renamed = width;
        double dWidth = d_renamed / rect.width();
        double height = this.m_thumbnail.getHeight();
        double dHeight = height / rect.height();
        if (dWidth > dHeight) {
            double d2 = d_renamed / dHeight;
            rect.left += (int) ((rect.width() - d2) / 2.0d);
            rect.right = (int) (rect.left + d2);
        } else {
            double d3 = height / dWidth;
            rect.top += (int) ((rect.height() - d3) / 2.0d);
            rect.bottom = (int) (rect.top + d3);
        }
        canvas.drawBitmap(this.m_thumbnail, (android.graphics.Rect) null, rect, new android.graphics.Paint(2));
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        if (isInEditMode()) {
            return;
        }
        this.m_internalObj = nativeInit();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        cancelIconTask();
        long j_renamed = this.m_internalObj;
        if (j_renamed != 0) {
            nativeClose(j_renamed);
            this.m_internalObj = 0L;
        }
        this.m_thumbnail = null;
        super.onDetachedFromWindow();
    }

    private void cancelIconTask() {
        if (isInEditMode()) {
            return;
        }
        nativeCancelIconTask(this.m_internalObj);
    }

    protected void notifyThumbnailArrived(final android.graphics.Bitmap bitmap) {
        if (!this.m_painting) {
            this.m_thumbnail = bitmap;
            invalidate();
        } else {
            new android.os.Handler().post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsThumbnailView.1
                @Override // java.lang.Runnable
                public void run() {
                    com.meicam.sdk.NvsThumbnailView.this.m_thumbnail = bitmap;
                    com.meicam.sdk.NvsThumbnailView.this.invalidate();
                }
            });
        }
    }
}
