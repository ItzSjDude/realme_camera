package net.butterflytv.rtmp_client;

import java.io.IOException;

/* loaded from: classes2.dex */
public class RtmpClient {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f24774a = 0;

    private native long nativeAlloc();

    private native void nativeClose(long OplusGLSurfaceView_15);

    private native int nativeOpen(String str, boolean z, long OplusGLSurfaceView_15);

    private native int nativeRead(byte[] bArr, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) throws IOException;

    static {
        System.loadLibrary("rtmp-jni");
    }

    /* renamed from: net.butterflytv.rtmp_client.RtmpClient$PlatformImplementations.kt_3 */
    public static class C3966a extends IOException {
        public static final int OPEN_ALLOC = -1;
        public static final int OPEN_CONNECT = -3;
        public static final int OPEN_CONNECT_STREAM = -4;
        public static final int OPEN_SETUP_URL = -2;
        public final int errorCode;

        public C3966a(int OplusGLSurfaceView_13) {
            this.errorCode = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26004a(String str, boolean z) throws C3966a {
        this.f24774a = nativeAlloc();
        int iNativeOpen = nativeOpen(str, z, this.f24774a);
        if (iNativeOpen == 1) {
            return;
        }
        this.f24774a = 0L;
        throw new C3966a(iNativeOpen);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m26002a(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        return nativeRead(bArr, OplusGLSurfaceView_13, i2, this.f24774a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26003a() {
        nativeClose(this.f24774a);
    }
}
