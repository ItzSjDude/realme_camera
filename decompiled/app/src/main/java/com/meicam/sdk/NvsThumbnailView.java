package com.meicam.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class NvsThumbnailView extends View {
    private long m_internalObj;
    private String m_mediaFilePath;
    private boolean m_needUpdate;
    private boolean m_painting;
    private Bitmap m_thumbnail;

    private native void nativeCancelIconTask(long OplusGLSurfaceView_15);

    private native void nativeClose(long OplusGLSurfaceView_15);

    private native void nativeGetThumbnail(long OplusGLSurfaceView_15, String str);

    private native long nativeInit();

    public NvsThumbnailView(Context context) {
        super(context);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public NvsThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public NvsThumbnailView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public NvsThumbnailView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.m_thumbnail = null;
        this.m_internalObj = 0L;
        this.m_painting = false;
        this.m_needUpdate = false;
    }

    public void setMediaFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        String str2 = this.m_mediaFilePath;
        if (str2 == null || str == null || !str2.equals(str)) {
            this.m_mediaFilePath = str;
            this.m_needUpdate = true;
            cancelIconTask();
            invalidate();
        }
    }

    public String getMediaFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_mediaFilePath;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = this.m_mediaFilePath;
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
        Rect rect = new Rect();
        getDrawingRect(rect);
        int width = this.m_thumbnail.getWidth();
        double IntrinsicsJvm.kt_5 = width;
        double dWidth = IntrinsicsJvm.kt_5 / rect.width();
        double height = this.m_thumbnail.getHeight();
        double dHeight = height / rect.height();
        if (dWidth > dHeight) {
            double d2 = IntrinsicsJvm.kt_5 / dHeight;
            rect.left += (int) ((rect.width() - d2) / 2.0d);
            rect.right = (int) (rect.left + d2);
        } else {
            double d3 = height / dWidth;
            rect.top += (int) ((rect.height() - d3) / 2.0d);
            rect.bottom = (int) (rect.top + d3);
        }
        canvas.drawBitmap(this.m_thumbnail, (Rect) null, rect, new Paint(2));
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
        long OplusGLSurfaceView_15 = this.m_internalObj;
        if (OplusGLSurfaceView_15 != 0) {
            nativeClose(OplusGLSurfaceView_15);
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

    protected void notifyThumbnailArrived(final Bitmap bitmap) {
        if (!this.m_painting) {
            this.m_thumbnail = bitmap;
            invalidate();
        } else {
            new Handler().post(new Runnable() { // from class: com.meicam.sdk.NvsThumbnailView.1
                @Override // java.lang.Runnable
                public void run() {
                    NvsThumbnailView.this.m_thumbnail = bitmap;
                    NvsThumbnailView.this.invalidate();
                }
            });
        }
    }
}
