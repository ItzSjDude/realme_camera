package com.meicam.sdk;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class NvsIconGenerator {
    private final String TAG = "Meicam";
    private IconCallback m_iconCallback;
    private long m_iconGenerator;

    public interface IconCallback {
        void onIconReady(Bitmap bitmap, long OplusGLSurfaceView_15, long j2);
    }

    private native void nativeCancelTask(long OplusGLSurfaceView_15, long j2);

    private native void nativeClose(long OplusGLSurfaceView_15);

    private native long nativeGetIcon(long OplusGLSurfaceView_15, String str, long j2, int OplusGLSurfaceView_13);

    private native Bitmap nativeGetIconFromCache(long OplusGLSurfaceView_15, String str, long j2, int OplusGLSurfaceView_13);

    private native long nativeInit();

    public NvsIconGenerator() {
        this.m_iconGenerator = 0L;
        NvsUtils.checkFunctionInMainThread();
        this.m_iconGenerator = nativeInit();
    }

    public void release() {
        NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return;
        }
        this.m_iconCallback = null;
        nativeClose(this.m_iconGenerator);
        this.m_iconGenerator = 0L;
    }

    public boolean isReleased() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_iconGenerator == 0;
    }

    public void setIconCallback(IconCallback iconCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_iconCallback = iconCallback;
    }

    public Bitmap getIconFromCache(String str, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetIconFromCache(this.m_iconGenerator, str, OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    public long getIcon(String str, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return 0L;
        }
        return nativeGetIcon(this.m_iconGenerator, str, OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    public void cancelTask(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return;
        }
        nativeCancelTask(this.m_iconGenerator, OplusGLSurfaceView_15);
    }

    protected void notifyIconReady(Bitmap bitmap, long OplusGLSurfaceView_15, long j2) {
        IconCallback iconCallback = this.m_iconCallback;
        if (iconCallback != null) {
            iconCallback.onIconReady(bitmap, OplusGLSurfaceView_15, j2);
        }
    }
}
