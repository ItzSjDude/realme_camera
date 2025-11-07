package com.arcsoft.arcsoftjni;

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
    private android.content.Context mContext;

    public static class AvatarEngineCamera {
        public float fCameraCx;
        public float fCameraCy;
        public float fCameraFx;
        public float fCameraFy;
        public int iFrameHeight;
        public int iFrameWidth;
    }

    private native long nativeCreate();

    private native void nativeDestroy(long j_renamed);

    private static native java.lang.Object nativeGetVersion();

    private native long nativeInitialize(long j_renamed, java.lang.String str, java.lang.String str2, int i_renamed, java.lang.Object obj);

    private native long nativeProcess(long j_renamed, java.lang.Object obj, java.lang.Object obj2, int i_renamed, int i2, boolean z_renamed);

    private native void nativeReleaseRender(long j_renamed);

    private native long nativeRender(long j_renamed, int i_renamed, int i2, int i3, boolean z_renamed, int[] iArr, java.lang.Object obj);

    private native long nativeSetCamera(long j_renamed, java.lang.Object obj, java.lang.Object obj2);

    private native long nativeSetDeviceOrientation(long j_renamed, int i_renamed);

    private native long nativeSetTemplate(long j_renamed, java.lang.String str);

    private native void nativeUninitialize(long j_renamed);

    static {
        java.lang.System.loadLibrary("AvatarEngineRender");
        java.lang.System.loadLibrary("AvatarEngineRenderNative");
    }

    public ArcSoftAvatarEngine(android.content.Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public long initialize(java.lang.String str, java.lang.String str2, int i_renamed) {
        this.lHandle = nativeCreate();
        return nativeInitialize(this.lHandle, str, str2, i_renamed, this.mContext);
    }

    public long setTemplate(java.lang.String str) {
        return nativeSetTemplate(this.lHandle, str);
    }

    public long setCamera(com.arcsoft.arcsoftjni.ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera, com.arcsoft.arcsoftjni.ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera2) {
        return nativeSetCamera(this.lHandle, avatarEngineCamera, avatarEngineCamera2);
    }

    public void uninitialize() {
        nativeUninitialize(this.lHandle);
        nativeDestroy(this.lHandle);
    }

    public long process(com.arcsoft.arcsoftjni.ArcSoftOffscreen arcSoftOffscreen, com.arcsoft.arcsoftjni.ArcSoftOffscreen arcSoftOffscreen2, int i_renamed, int i2, boolean z_renamed) {
        return nativeProcess(this.lHandle, arcSoftOffscreen, arcSoftOffscreen2, i_renamed, i2, z_renamed);
    }

    public long render(int i_renamed, int i2, int i3, boolean z_renamed, int[] iArr, com.arcsoft.arcsoftjni.ArcSoftOffscreen arcSoftOffscreen) {
        return nativeRender(this.lHandle, i_renamed, i2, i3, z_renamed, iArr, arcSoftOffscreen);
    }

    public long setDevicesOrientation(int i_renamed) {
        return nativeSetDeviceOrientation(this.lHandle, i_renamed);
    }

    public void releaseRender() {
        nativeReleaseRender(this.lHandle);
    }

    public static com.arcsoft.arcsoftjni.ArcSoftVersion getVersion() {
        return (com.arcsoft.arcsoftjni.ArcSoftVersion) nativeGetVersion();
    }

    long getHandle() {
        return this.lHandle;
    }
}
