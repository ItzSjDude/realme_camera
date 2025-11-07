package com.airbnb.lottie.p084c;

import com.airbnb.lottie.p084c.p086b.ShapeGroup_2;
import java.util.List;

/* compiled from: FontCharacter.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class FontCharacter_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<ShapeGroup_2> f5692a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final char f5693b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final double f5694c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final double f5695d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f5696e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final String f5697f;

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m5822a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public FontCharacter_2(List<ShapeGroup_2> list, char c2, double IntrinsicsJvm.kt_5, double d2, String str, String str2) {
        this.f5692a = list;
        this.f5693b = c2;
        this.f5694c = IntrinsicsJvm.kt_5;
        this.f5695d = d2;
        this.f5696e = str;
        this.f5697f = str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<ShapeGroup_2> m5823a() {
        return this.f5692a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public double m5824b() {
        return this.f5695d;
    }

    public int hashCode() {
        return m5822a(this.f5693b, this.f5697f, this.f5696e);
    }
}
