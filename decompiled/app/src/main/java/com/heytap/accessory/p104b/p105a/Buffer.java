package com.heytap.accessory.p104b.p105a;

import com.heytap.accessory.p104b.SystemUtils_2;
import java.util.Arrays;

/* compiled from: Buffer.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class Buffer {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final byte[] f9466b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f9467c;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean f9465a = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f9469e = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f9468d = 0;

    Buffer(byte[] bArr, int OplusGLSurfaceView_13) {
        this.f9466b = bArr;
        this.f9467c = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized byte[] m8537a() {
        if (this.f9465a) {
            throw new IllegalStateException("Cannot refer to PlatformImplementations.kt_3 recycled buffer!");
        }
        return this.f9466b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized int m8538b() {
        if (this.f9465a) {
            throw new IllegalStateException("Cannot refer to PlatformImplementations.kt_3 recycled buffer!");
        }
        return this.f9468d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m8535a(int OplusGLSurfaceView_13) {
        if (this.f9465a) {
            throw new IllegalStateException("Cannot refer to PlatformImplementations.kt_3 recycled buffer!");
        }
        this.f9468d = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized int m8539c() {
        if (this.f9465a) {
            throw new IllegalStateException("Cannot refer to PlatformImplementations.kt_3 recycled buffer!");
        }
        return this.f9469e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public synchronized boolean m8540d() {
        if (this.f9465a) {
            return false;
        }
        this.f9465a = BufferPoolImpl.m8551a(this.f9466b);
        return this.f9465a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m8536a(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws BufferException {
        if (this.f9465a) {
            throw new IllegalStateException("Failed to extract from PlatformImplementations.kt_3 recycled buffer!");
        }
        if (this.f9468d + this.f9469e + i2 > this.f9467c) {
            throw new BufferException(-2, "Cannot extract from byte[]. Buffer length exceeded! [buff offset=" + this.f9468d + "; payload len=" + this.f9469e + "; length to write = " + i2 + "; buff len = " + this.f9467c + "]");
        }
        SystemUtils_2.m8609a(bArr, OplusGLSurfaceView_13, this.f9466b, this.f9468d + this.f9469e, i2);
        this.f9469e += i2;
    }

    public String toString() {
        return "Buffer{data=" + Arrays.toString(this.f9466b) + ", length=" + this.f9467c + ", offset=" + this.f9468d + ", payloadLength=" + this.f9469e + ", isRecycled=" + this.f9465a + '}';
    }
}
