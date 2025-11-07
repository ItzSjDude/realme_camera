package com.cdv.p098io;

import android.graphics.SurfaceTexture;

/* loaded from: classes.dex */
public class NvCameraSurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {
    private final int m_texId;

    private static native void notifyCameraFrameAvailable(int OplusGLSurfaceView_13);

    public NvCameraSurfaceTextureListener(int OplusGLSurfaceView_13) {
        this.m_texId = OplusGLSurfaceView_13;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyCameraFrameAvailable(this.m_texId);
    }
}
