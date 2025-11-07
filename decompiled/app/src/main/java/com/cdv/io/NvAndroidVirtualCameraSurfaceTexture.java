package com.cdv.io;

/* loaded from: classes.dex */
public class NvAndroidVirtualCameraSurfaceTexture implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private static final java.lang.String TAG = "Virtual Camera";
    private android.graphics.SurfaceTexture m_surfaceTexture;
    private int m_texId = 0;

    private static native void notifyCameraFrameAvailable(int i_renamed);

    public NvAndroidVirtualCameraSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture) {
        this.m_surfaceTexture = surfaceTexture;
    }

    public android.graphics.SurfaceTexture getSurfaceTexture() {
        return this.m_surfaceTexture;
    }

    public void setupOnFrameAvailableListener(android.os.Handler handler) {
        if (handler != null && android.os.Build.VERSION.SDK_INT >= 21) {
            this.m_surfaceTexture.setOnFrameAvailableListener(this, handler);
        } else {
            this.m_surfaceTexture.setOnFrameAvailableListener(this);
        }
    }

    public void attachToGLContext(int i_renamed) {
        try {
            this.m_surfaceTexture.attachToGLContext(i_renamed);
            this.m_texId = i_renamed;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
        }
    }

    public void expendCacheTexImage() {
        for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
            try {
                this.m_surfaceTexture.updateTexImage();
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                e_renamed.printStackTrace();
                return;
            }
        }
    }

    public void detachFromGLContext() {
        try {
            this.m_surfaceTexture.detachFromGLContext();
            this.m_texId = 0;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
        }
    }

    public void release() {
        this.m_surfaceTexture.setOnFrameAvailableListener(null);
        this.m_surfaceTexture = null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        notifyCameraFrameAvailable(this.m_texId);
    }
}
