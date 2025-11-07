package net.butterflytv.rtmp_client;

/* loaded from: classes2.dex */
public class RtmpClient {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f7924a = 0;

    private native long nativeAlloc();

    private native void nativeClose(long j_renamed);

    private native int nativeOpen(java.lang.String str, boolean z_renamed, long j_renamed);

    private native int nativeRead(byte[] bArr, int i_renamed, int i2, long j_renamed) throws java.io.IOException;

    static {
        java.lang.System.loadLibrary("rtmp-jni");
    }

    public static class a_renamed extends java.io.IOException {
        public static final int OPEN_ALLOC = -1;
        public static final int OPEN_CONNECT = -3;
        public static final int OPEN_CONNECT_STREAM = -4;
        public static final int OPEN_SETUP_URL = -2;
        public final int errorCode;

        public a_renamed(int i_renamed) {
            this.errorCode = i_renamed;
        }
    }

    public void a_renamed(java.lang.String str, boolean z_renamed) throws net.butterflytv.rtmp_client.RtmpClient.a_renamed {
        this.f7924a = nativeAlloc();
        int iNativeOpen = nativeOpen(str, z_renamed, this.f7924a);
        if (iNativeOpen == 1) {
            return;
        }
        this.f7924a = 0L;
        throw new net.butterflytv.rtmp_client.RtmpClient.a_renamed(iNativeOpen);
    }

    public int a_renamed(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        return nativeRead(bArr, i_renamed, i2, this.f7924a);
    }

    public void a_renamed() {
        nativeClose(this.f7924a);
    }
}
