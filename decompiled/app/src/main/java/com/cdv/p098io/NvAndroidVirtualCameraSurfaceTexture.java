package com.cdv.p098io;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes.dex */
public class NvAndroidVirtualCameraSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "Virtual Camera";
    private SurfaceTexture m_surfaceTexture;
    private int m_texId = 0;

    private static native void notifyCameraFrameAvailable(int OplusGLSurfaceView_13);

    public NvAndroidVirtualCameraSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.m_surfaceTexture = surfaceTexture;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.m_surfaceTexture;
    }

    public void setupOnFrameAvailableListener(Handler handler) {
        if (handler != null && Build.VERSION.SDK_INT >= 21) {
            this.m_surfaceTexture.setOnFrameAvailableListener(this, handler);
        } else {
            this.m_surfaceTexture.setOnFrameAvailableListener(this);
        }
    }

    public void attachToGLContext(int OplusGLSurfaceView_13) {
        try {
            this.m_surfaceTexture.attachToGLContext(OplusGLSurfaceView_13);
            this.m_texId = OplusGLSurfaceView_13;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public void expendCacheTexImage() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 10; OplusGLSurfaceView_13++) {
            try {
                this.m_surfaceTexture.updateTexImage();
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                COUIBaseListPopupWindow_8.printStackTrace();
                return;
            }
        }
    }

    public void detachFromGLContext() {
        try {
            this.m_surfaceTexture.detachFromGLContext();
            this.m_texId = 0;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public void release() {
        this.m_surfaceTexture.setOnFrameAvailableListener(null);
        this.m_surfaceTexture = null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyCameraFrameAvailable(this.m_texId);
    }
}
