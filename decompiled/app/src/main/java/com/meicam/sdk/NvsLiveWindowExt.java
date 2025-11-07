package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsLiveWindowExt extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener {
    public static final int FILLMODE_PRESERVEASPECTCROP = 0;
    public static final int FILLMODE_PRESERVEASPECTFIT = 1;
    public static final int FILLMODE_PRESERVEASPECTFIT_BLUR = 3;
    public static final int FILLMODE_STRETCH = 2;
    protected int m_fillMode;
    private java.lang.Object m_frameInfoMutex;
    protected long m_internalObject;
    private android.view.View m_overlayBuddy;
    private java.util.ArrayList<com.meicam.sdk.NvsLiveWindow.VideoFrameInfo> m_pendingVideoFrameInfoList;
    private android.view.Surface m_surface;
    private boolean m_verbose;
    private com.meicam.sdk.NvsLiveWindow.VideoFrameCallback m_videoFrameCallback;

    private native void nativeClearVideoFrame(long j_renamed);

    private native void nativeClose(long j_renamed);

    private native boolean nativeGetStopRenderingBeforeNextSurfaceChange(long j_renamed);

    private native void nativeInit(boolean z_renamed);

    private native android.graphics.PointF nativeMapCanonicalToView(long j_renamed, android.graphics.PointF pointF);

    private native android.graphics.PointF nativeMapNormalizedToView(long j_renamed, android.graphics.PointF pointF);

    private native android.graphics.PointF nativeMapViewToCanonical(long j_renamed, android.graphics.PointF pointF);

    private native android.graphics.PointF nativeMapViewToNormalized(long j_renamed, android.graphics.PointF pointF);

    private native void nativeOnSizeChanged(long j_renamed, int i_renamed, int i2);

    private native void nativeRepaintVideoFrame(long j_renamed);

    private native void nativeSetBackgroundColor(long j_renamed, float f_renamed, float f2, float f3);

    private native void nativeSetFillMode(long j_renamed, int i_renamed);

    private native void nativeSetStopRenderingBeforeNextSurfaceChange(long j_renamed, boolean z_renamed);

    private native void nativeSetVideoFrameCallback(long j_renamed, com.meicam.sdk.NvsLiveWindow.InternalVideoFrameCallback internalVideoFrameCallback);

    private native void nativeSurfaceChanged(long j_renamed, android.view.Surface surface, int i_renamed, int i2);

    private native void nativeSurfaceDestroyed(long j_renamed);

    private native android.graphics.Bitmap nativeTakeScreenshot(long j_renamed);

    public NvsLiveWindowExt(android.content.Context context) {
        super(context);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new java.util.ArrayList<>();
        this.m_frameInfoMutex = new java.lang.Object();
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsLiveWindowExt(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new java.util.ArrayList<>();
        this.m_frameInfoMutex = new java.lang.Object();
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsLiveWindowExt(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new java.util.ArrayList<>();
        this.m_frameInfoMutex = new java.lang.Object();
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsLiveWindowExt(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new java.util.ArrayList<>();
        this.m_frameInfoMutex = new java.lang.Object();
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public void setFillMode(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed == this.m_fillMode) {
            return;
        }
        this.m_fillMode = i_renamed;
        nativeSetFillMode(this.m_internalObject, i_renamed);
    }

    public int getFillMode() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_fillMode;
    }

    public android.graphics.PointF mapCanonicalToView(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapCanonicalToView(this.m_internalObject, pointF);
    }

    public android.graphics.PointF mapViewToCanonical(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapViewToCanonical(this.m_internalObject, pointF);
    }

    public android.graphics.PointF mapNormalizedToView(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapNormalizedToView(this.m_internalObject, pointF);
    }

    public android.graphics.PointF mapViewToNormalized(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapViewToNormalized(this.m_internalObject, pointF);
    }

    public void repaintVideoFrame() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeRepaintVideoFrame(this.m_internalObject);
    }

    public void clearVideoFrame() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeClearVideoFrame(this.m_internalObject);
    }

    public android.graphics.Bitmap takeScreenshot() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeTakeScreenshot(this.m_internalObject);
    }

    public void setBackgroundColor(float f_renamed, float f2, float f3) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetBackgroundColor(this.m_internalObject, f_renamed, f2, f3);
    }

    public void setOverlayBuddy(android.view.View view) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_overlayBuddy = view;
    }

    public void setVideoFrameCallback(com.meicam.sdk.NvsLiveWindow.VideoFrameCallback videoFrameCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (isInEditMode()) {
            return;
        }
        this.m_videoFrameCallback = videoFrameCallback;
        if (videoFrameCallback != null) {
            nativeSetVideoFrameCallback(this.m_internalObject, new com.meicam.sdk.NvsLiveWindow.InternalVideoFrameCallback() { // from class: com.meicam.sdk.NvsLiveWindowExt.1
                @Override // com.meicam.sdk.NvsLiveWindow.InternalVideoFrameCallback
                public void onVideoFrameRendered(com.meicam.sdk.NvsLiveWindow.VideoFrameInfo videoFrameInfo) {
                    if (com.meicam.sdk.NvsLiveWindowExt.this.m_verbose) {
                        android.util.Log.d_renamed("Meishe", "frame rendered, frame id_renamed=" + videoFrameInfo.frameId);
                    }
                    synchronized (com.meicam.sdk.NvsLiveWindowExt.this.m_frameInfoMutex) {
                        if (videoFrameInfo.frameId < 0) {
                            com.meicam.sdk.NvsLiveWindowExt.this.m_pendingVideoFrameInfoList.clear();
                        }
                        com.meicam.sdk.NvsLiveWindowExt.this.m_pendingVideoFrameInfoList.add(videoFrameInfo);
                    }
                }
            });
        } else {
            nativeSetVideoFrameCallback(this.m_internalObject, null);
        }
    }

    public void setStopRenderingBeforeNextSurfaceChange(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStopRenderingBeforeNextSurfaceChange(this.m_internalObject, z_renamed);
    }

    public boolean getStopRenderingBeforeNextSurfaceChange() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetStopRenderingBeforeNextSurfaceChange(this.m_internalObject);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        android.view.View view = this.m_overlayBuddy;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        init();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        nativeSetVideoFrameCallback(this.m_internalObject, null);
        if (!isInEditMode()) {
            destroyCurrentSurface();
            long j_renamed = this.m_internalObject;
            if (j_renamed != 0) {
                nativeClose(j_renamed);
                this.m_internalObject = 0L;
            }
        }
        setSurfaceTextureListener(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        if (!isInEditMode()) {
            nativeOnSizeChanged(this.m_internalObject, i_renamed, i2);
        }
        super.onSizeChanged(i_renamed, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
        destroyCurrentSurface();
        if (isInEditMode() || i_renamed < 1 || i2 < 1) {
            return;
        }
        this.m_surface = new android.view.Surface(surfaceTexture);
        nativeSurfaceChanged(this.m_internalObject, this.m_surface, i_renamed, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
        destroyCurrentSurface();
        if (isInEditMode() || i_renamed < 1 || i2 < 1) {
            return;
        }
        this.m_surface = new android.view.Surface(surfaceTexture);
        nativeSurfaceChanged(this.m_internalObject, this.m_surface, i_renamed, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        if (isInEditMode()) {
            return true;
        }
        destroyCurrentSurface();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        if (this.m_videoFrameCallback == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.m_verbose) {
            android.util.Log.d_renamed("Meishe", "surface texture updated, frame id_renamed=" + timestamp);
        }
        com.meicam.sdk.NvsLiveWindow.VideoFrameInfo videoFrameInfo = null;
        synchronized (this.m_frameInfoMutex) {
            java.util.Iterator<com.meicam.sdk.NvsLiveWindow.VideoFrameInfo> it = this.m_pendingVideoFrameInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.meicam.sdk.NvsLiveWindow.VideoFrameInfo next = it.next();
                if (next.frameId == timestamp) {
                    if (this.m_verbose) {
                        android.util.Log.d_renamed("Meishe", "Found frame info, frame id_renamed=" + timestamp);
                    }
                    videoFrameInfo = next;
                }
            }
            if (videoFrameInfo != null) {
                while (!this.m_pendingVideoFrameInfoList.isEmpty() && this.m_pendingVideoFrameInfoList.get(0).frameId < timestamp) {
                    this.m_pendingVideoFrameInfoList.remove(0);
                }
            } else if (!this.m_pendingVideoFrameInfoList.isEmpty()) {
                videoFrameInfo = this.m_pendingVideoFrameInfoList.get(this.m_pendingVideoFrameInfoList.size() - 1);
                this.m_pendingVideoFrameInfoList.clear();
            }
        }
        if (videoFrameInfo != null) {
            this.m_videoFrameCallback.onVideoFrameRendered(videoFrameInfo);
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
        if (isInEditMode() || this.m_internalObject != 0) {
            return;
        }
        nativeInit(true);
    }

    private void destroyCurrentSurface() {
        if (isInEditMode() || this.m_surface == null) {
            return;
        }
        nativeSurfaceDestroyed(this.m_internalObject);
        this.m_surface.release();
        this.m_surface = null;
    }
}
