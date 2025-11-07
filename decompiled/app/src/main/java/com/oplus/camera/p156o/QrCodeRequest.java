package com.oplus.camera.p156o;

import android.graphics.Rect;
import android.util.Size;

/* compiled from: QrCodeRequest.java */
/* renamed from: com.oplus.camera.o.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class QrCodeRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private byte[] f14767a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Rect f14768b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Size f14769c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f14770d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f14771e;

    public QrCodeRequest(byte[] bArr, Rect rect, Size size, int OplusGLSurfaceView_13, int i2) {
        this.f14767a = null;
        this.f14768b = null;
        this.f14769c = null;
        this.f14770d = 0;
        this.f14771e = 0;
        this.f14767a = bArr;
        this.f14768b = rect;
        this.f14769c = size;
        this.f14770d = OplusGLSurfaceView_13;
        this.f14771e = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] m14796a() {
        return this.f14767a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m14797b() {
        return this.f14770d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m14798c() {
        return this.f14771e;
    }
}
