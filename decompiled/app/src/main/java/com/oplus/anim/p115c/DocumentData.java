package com.oplus.anim.p115c;

/* compiled from: DocumentData.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class DocumentData {

    /* renamed from: PlatformImplementations.kt_3 */
    public final String f10118a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final String f10119b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final double f10120c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final PlatformImplementations.kt_3 f10121d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final int f10122e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final double f10123f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final double f10124g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public final int f10125h;

    /* renamed from: OplusGLSurfaceView_13 */
    public final int f10126i;

    /* renamed from: OplusGLSurfaceView_15 */
    public final double f10127j;

    /* renamed from: OplusGLSurfaceView_5 */
    public final boolean f10128k;

    /* compiled from: DocumentData.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, double IntrinsicsJvm.kt_5, PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, double d2, double d3, int i2, int i3, double d4, boolean z) {
        this.f10118a = str;
        this.f10119b = str2;
        this.f10120c = IntrinsicsJvm.kt_5;
        this.f10121d = aVar;
        this.f10122e = OplusGLSurfaceView_13;
        this.f10123f = d2;
        this.f10124g = d3;
        this.f10125h = i2;
        this.f10126i = i3;
        this.f10127j = d4;
        this.f10128k = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f10118a.hashCode() * 31) + this.f10119b.hashCode()) * 31) + this.f10120c)) * 31) + this.f10121d.ordinal()) * 31) + this.f10122e;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f10123f);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.f10125h;
    }
}
