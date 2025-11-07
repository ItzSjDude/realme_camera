package com.heytap.accessory.p104b.p105a;

/* compiled from: BufferException.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class BufferException extends Exception {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f9470a;

    public BufferException() {
    }

    public BufferException(int OplusGLSurfaceView_13, String str) {
        super(str);
        this.f9470a = OplusGLSurfaceView_13;
    }

    public BufferException(int OplusGLSurfaceView_13, Throwable th) {
        super(th);
    }

    public BufferException(int OplusGLSurfaceView_13, String str, Throwable th) {
        super(str, th);
        this.f9470a = OplusGLSurfaceView_13;
    }

    public int getErrorCode() {
        return this.f9470a;
    }
}
