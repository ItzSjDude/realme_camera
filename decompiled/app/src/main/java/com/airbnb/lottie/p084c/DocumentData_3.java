package com.airbnb.lottie.p084c;

/* compiled from: DocumentData.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class DocumentData_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    public final String f5496a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final String f5497b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final float f5498c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final PlatformImplementations.kt_3 f5499d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final int f5500e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final float f5501f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final float f5502g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public final int f5503h;

    /* renamed from: OplusGLSurfaceView_13 */
    public final int f5504i;

    /* renamed from: OplusGLSurfaceView_15 */
    public final float f5505j;

    /* renamed from: OplusGLSurfaceView_5 */
    public final boolean f5506k;

    /* compiled from: DocumentData.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData_3(String str, String str2, float COUIBaseListPopupWindow_12, PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, float f2, float f3, int i2, int i3, float f4, boolean z) {
        this.f5496a = str;
        this.f5497b = str2;
        this.f5498c = COUIBaseListPopupWindow_12;
        this.f5499d = aVar;
        this.f5500e = OplusGLSurfaceView_13;
        this.f5501f = f2;
        this.f5502g = f3;
        this.f5503h = i2;
        this.f5504i = i3;
        this.f5505j = f4;
        this.f5506k = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f5496a.hashCode() * 31) + this.f5497b.hashCode()) * 31) + this.f5498c)) * 31) + this.f5499d.ordinal()) * 31) + this.f5500e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f5501f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f5503h;
    }
}
