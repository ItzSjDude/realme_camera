package com.arcsoft.arcsoftjni;

import android.content.Context;

/* loaded from: classes.dex */
public class ArcSoftAvatarEngine {
    public static final int ASL_MERR_BAD_STATE = 5;
    public static final int ASL_MERR_EXPIRED = 7;
    public static final int ASL_MERR_FILE_NOT_FOUND = 6;
    public static final int ASL_MERR_INVALID_PARAM = 2;
    public static final int ASL_MERR_NO_MEMORY = 4;
    public static final int ASL_MERR_UNKNOWN = 1;
    public static final int ASL_MERR_UNSUPPORTED = 3;
    public static final int ArcSoft_Avatar_Max_Support_Face_Num = 1;
    private static final int MERR_BASIC_BASE = 1;
    private long lHandle;
    private Context mContext;

    public static class AvatarEngineCamera {
        public float fCameraCx;
        public float fCameraCy;
        public float fCameraFx;
        public float fCameraFy;
        public int iFrameHeight;
        public int iFrameWidth;
    }

    private native long nativeCreate();

    private native void nativeDestroy(long OplusGLSurfaceView_15);

    private static native Object nativeGetVersion();

    private native long nativeInitialize(long OplusGLSurfaceView_15, String str, String str2, int OplusGLSurfaceView_13, Object obj);

    private native long nativeProcess(long OplusGLSurfaceView_15, Object obj, Object obj2, int OplusGLSurfaceView_13, int i2, boolean z);

    private native void nativeReleaseRender(long OplusGLSurfaceView_15);

    private native long nativeRender(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int[] iArr, Object obj);

    private native long nativeSetCamera(long OplusGLSurfaceView_15, Object obj, Object obj2);

    private native long nativeSetDeviceOrientation(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native long nativeSetTemplate(long OplusGLSurfaceView_15, String str);

    private native void nativeUninitialize(long OplusGLSurfaceView_15);

    static {
        System.loadLibrary("AvatarEngineRender");
        System.loadLibrary("AvatarEngineRenderNative");
    }

    public ArcSoftAvatarEngine(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public long initialize(String str, String str2, int OplusGLSurfaceView_13) {
        this.lHandle = nativeCreate();
        return nativeInitialize(this.lHandle, str, str2, OplusGLSurfaceView_13, this.mContext);
    }

    public long setTemplate(String str) {
        return nativeSetTemplate(this.lHandle, str);
    }

    public long setCamera(AvatarEngineCamera avatarEngineCamera, AvatarEngineCamera avatarEngineCamera2) {
        return nativeSetCamera(this.lHandle, avatarEngineCamera, avatarEngineCamera2);
    }

    public void uninitialize() {
        nativeUninitialize(this.lHandle);
        nativeDestroy(this.lHandle);
    }

    public long process(ArcSoftOffscreen arcSoftOffscreen, ArcSoftOffscreen arcSoftOffscreen2, int OplusGLSurfaceView_13, int i2, boolean z) {
        return nativeProcess(this.lHandle, arcSoftOffscreen, arcSoftOffscreen2, OplusGLSurfaceView_13, i2, z);
    }

    public long render(int OplusGLSurfaceView_13, int i2, int i3, boolean z, int[] iArr, ArcSoftOffscreen arcSoftOffscreen) {
        return nativeRender(this.lHandle, OplusGLSurfaceView_13, i2, i3, z, iArr, arcSoftOffscreen);
    }

    public long setDevicesOrientation(int OplusGLSurfaceView_13) {
        return nativeSetDeviceOrientation(this.lHandle, OplusGLSurfaceView_13);
    }

    public void releaseRender() {
        nativeReleaseRender(this.lHandle);
    }

    public static ArcSoftVersion getVersion() {
        return (ArcSoftVersion) nativeGetVersion();
    }

    long getHandle() {
        return this.lHandle;
    }
}
