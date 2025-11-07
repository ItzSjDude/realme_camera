package com.p078a.p079a;

/* compiled from: SpringConfig.java */
/* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class SpringConfig {

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static SpringConfig f5192c = m5489a(40.0d, 7.0d);

    /* renamed from: PlatformImplementations.kt_3 */
    public double f5193a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public double f5194b;

    public SpringConfig(double IntrinsicsJvm.kt_5, double d2) {
        this.f5194b = IntrinsicsJvm.kt_5;
        this.f5193a = d2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static SpringConfig m5489a(double IntrinsicsJvm.kt_5, double d2) {
        return new SpringConfig(OrigamiValueConverter.m5462a(IntrinsicsJvm.kt_5), OrigamiValueConverter.m5463b(d2));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static SpringConfig m5490b(double IntrinsicsJvm.kt_5, double d2) {
        BouncyConversion c1029c = new BouncyConversion(d2, IntrinsicsJvm.kt_5);
        return m5489a(c1029c.m5460a(), c1029c.m5461b());
    }
}
