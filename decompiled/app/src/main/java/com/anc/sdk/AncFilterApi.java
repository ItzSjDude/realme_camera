package com.anc.sdk;

/* loaded from: classes.dex */
public class AncFilterApi {
    static final java.lang.String TAG = "AncFilterApi";
    private java.util.concurrent.atomic.AtomicLong handle = new java.util.concurrent.atomic.AtomicLong(0);
    private java.util.concurrent.atomic.AtomicInteger mPendingLogLevel = new java.util.concurrent.atomic.AtomicInteger(-1);
    private static com.anc.sdk.AncFilterApi sInstance = new com.anc.sdk.AncFilterApi();
    private static java.util.concurrent.atomic.AtomicBoolean isSoLoaded = new java.util.concurrent.atomic.AtomicBoolean(false);

    public static class ErrorCode {
        public static final int ANC_FILTER_FAILURE = 3;
        public static final int ANC_FILTER_GL_COMPILING = 4;
        public static final int ANC_FILTER_INVALID_ARGUMENT = 1;
        public static final int ANC_FILTER_INVALID_HANDLE = 2;
        public static final int ANC_FILTER_OK = 0;
    }

    public static class FilterInfo {
        public byte[] baseImageBuffer;
        public int baseImageHeight;
        public java.lang.String baseImagePath;
        public int baseImageWidth;
        public int filterIndex;
        public byte[] lutBuffer;
        public int lutHeight;
        public java.lang.String lutPath;
        public int lutWidth;
        public float speed;
    }

    public static class FilterType {
        public static final int ANC_FILTERT_CELL_BLUEPINK = 7;
        public static final int ANC_FILTERT_CELL_GRADIENTCOLOR = 5;
        public static final int ANC_FILTERT_CELL_GREENORANGE = 6;
        public static final int ANC_FILTERT_CONCENTRIC_CIRCLES = 3;
        public static final int ANC_FILTERT_HEXAGON = 1;
        public static final int ANC_FILTERT_KALEIDOSCOPE = 0;
        public static final int ANC_FILTERT_POLYSPIN = 4;
        public static final int ANC_FILTERT_SPIRAL = 2;
    }

    public static class ImageType {
        public static final int IMAGE_TYPE_NV12 = 6;
        public static final int IMAGE_TYPE_NV21 = 0;
    }

    private native long nativeInitHandle(boolean z_renamed);

    private native int nativeProcess(long j_renamed, int i_renamed, int i2, int i3, boolean z_renamed, boolean z2, int i4, int i5, float f_renamed);

    private native int nativeProcessNV21(long j_renamed, java.lang.String str, int i_renamed, int i2, int i3);

    private native int nativeRelease(long j_renamed);

    private native int nativeSetFilterInfo(long j_renamed, com.anc.sdk.AncFilterApi.FilterInfo filterInfo);

    private native int nativeSetLogLevel(int i_renamed);

    public native java.lang.String nativeSdkVersion();

    public static com.anc.sdk.AncFilterApi getInstance() {
        return sInstance;
    }

    public int init(boolean z_renamed) {
        android.util.Log.e_renamed(TAG, "init in_renamed");
        if (this.handle.get() != 0) {
            return 3;
        }
        if (!isSoLoaded.get()) {
            java.lang.System.loadLibrary("AncFilter_jni");
            isSoLoaded.set(true);
        }
        long jNativeInitHandle = nativeInitHandle(z_renamed);
        if (jNativeInitHandle == 0) {
            return 1;
        }
        this.handle.set(jNativeInitHandle);
        android.util.Log.e_renamed(TAG, "init out hdl: " + jNativeInitHandle);
        return 0;
    }

    public int setLogLevel(int i_renamed) {
        if (!isSoLoaded.get()) {
            this.mPendingLogLevel.set(i_renamed);
            return -1;
        }
        nativeSetLogLevel(i_renamed);
        return 0;
    }

    public int setFilterInfo(com.anc.sdk.AncFilterApi.FilterInfo filterInfo) {
        return nativeSetFilterInfo(this.handle.get(), filterInfo);
    }

    public int process(int i_renamed, int i2, int i3, boolean z_renamed, boolean z2, int i4, int i5, float f_renamed) {
        android.util.Log.e_renamed(TAG, "process in_renamed");
        return nativeProcess(this.handle.get(), i_renamed, i2, i3, z_renamed, z2, i4, i5, f_renamed);
    }

    public int processNV21(java.lang.String str, int i_renamed, int i2, int i3) {
        android.util.Log.e_renamed(TAG, "processNV21 in_renamed");
        return nativeProcessNV21(this.handle.get(), str, i_renamed, i2, i3);
    }

    public int release() {
        android.util.Log.e_renamed(TAG, "release in_renamed");
        if (this.handle.get() == 0) {
            return 2;
        }
        int iNativeRelease = nativeRelease(this.handle.get());
        this.handle.set(0L);
        return iNativeRelease;
    }

    public java.lang.String getVersion() {
        return !isSoLoaded.get() ? "" : nativeSdkVersion();
    }

    private static byte[] getFileContent(java.lang.String str, android.content.res.AssetManager assetManager) throws java.io.IOException {
        java.io.InputStream inputStreamOpen;
        boolean z_renamed;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        if (assetManager != null) {
            try {
                inputStreamOpen = assetManager.open(str);
                z_renamed = true;
            } catch (java.io.IOException unused) {
                android.util.Log.e_renamed(TAG, "fail to open " + str);
            }
        } else {
            z_renamed = false;
            inputStreamOpen = null;
        }
        if (!z_renamed) {
            try {
                inputStreamOpen = new java.io.FileInputStream(str);
            } catch (java.io.IOException unused2) {
                return null;
            }
        }
        if (inputStreamOpen != null) {
            while (true) {
                try {
                    int i_renamed = inputStreamOpen.read(bArr);
                    if (i_renamed != -1) {
                        byteArrayOutputStream.write(bArr, 0, i_renamed);
                    } else {
                        inputStreamOpen.close();
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    }
                } catch (java.io.IOException unused3) {
                }
            }
        }
        return null;
    }
}
