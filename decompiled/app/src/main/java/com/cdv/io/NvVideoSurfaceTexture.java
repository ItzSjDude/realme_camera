package com.cdv.io;

/* loaded from: classes.dex */
public class NvVideoSurfaceTexture implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private final int m_texId;

    private static native void notifyFrameAvailable(int i_renamed);

    public NvVideoSurfaceTexture(int i_renamed) {
        this.m_texId = i_renamed;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        notifyFrameAvailable(this.m_texId);
    }
}
