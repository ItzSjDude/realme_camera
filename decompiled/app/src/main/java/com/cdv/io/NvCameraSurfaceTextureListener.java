package com.cdv.io;

/* loaded from: classes.dex */
public class NvCameraSurfaceTextureListener implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private final int m_texId;

    private static native void notifyCameraFrameAvailable(int i_renamed);

    public NvCameraSurfaceTextureListener(int i_renamed) {
        this.m_texId = i_renamed;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        notifyCameraFrameAvailable(this.m_texId);
    }
}
