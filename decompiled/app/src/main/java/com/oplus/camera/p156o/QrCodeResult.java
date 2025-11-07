package com.oplus.camera.p156o;

import android.graphics.RectF;

/* compiled from: QrCodeResult.java */
/* renamed from: com.oplus.camera.o.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class QrCodeResult {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f14774a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f14775b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f14776c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RectF f14777d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f14778e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f14779f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f14780g = false;

    /* compiled from: QrCodeResult.java */
    /* renamed from: com.oplus.camera.o.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        HTTP,
        INSTANT,
        WIFI,
        NONE
    }

    public QrCodeResult(String str, PlatformImplementations.kt_3 aVar, String str2, RectF rectF, int OplusGLSurfaceView_13, int i2) {
        this.f14774a = "";
        this.f14775b = null;
        this.f14776c = "";
        this.f14777d = null;
        this.f14778e = 0;
        this.f14779f = 0;
        this.f14774a = str;
        this.f14775b = aVar;
        this.f14776c = str2;
        this.f14777d = rectF;
        this.f14778e = OplusGLSurfaceView_13;
        this.f14779f = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m14805a() {
        return this.f14774a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m14807b() {
        return this.f14776c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public PlatformImplementations.kt_3 m14808c() {
        return this.f14775b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public RectF m14809d() {
        return this.f14777d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m14810e() {
        return this.f14778e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m14811f() {
        return this.f14779f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public synchronized boolean m14812g() {
        return this.f14780g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m14806a(boolean z) {
        this.f14780g = z;
    }

    public String toString() {
        return "QrCodeResult{mContent='" + this.f14774a + "', mType=" + this.f14775b + ", mScanStatus='" + this.f14776c + "'}";
    }
}
