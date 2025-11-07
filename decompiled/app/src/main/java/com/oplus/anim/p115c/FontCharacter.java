package com.oplus.anim.p115c;

import com.oplus.anim.p115c.p117b.ShapeGroup;
import java.util.List;

/* compiled from: FontCharacter.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class FontCharacter {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<ShapeGroup> f10306a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final char f10307b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final double f10308c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final double f10309d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f10310e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final String f10311f;

    public FontCharacter(List<ShapeGroup> list, char c2, double IntrinsicsJvm.kt_5, double d2, String str, String str2) {
        this.f10306a = list;
        this.f10307b = c2;
        this.f10308c = IntrinsicsJvm.kt_5;
        this.f10309d = d2;
        this.f10310e = str;
        this.f10311f = str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m9130a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<ShapeGroup> m9131a() {
        return this.f10306a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public double m9132b() {
        return this.f10309d;
    }

    public int hashCode() {
        return m9130a(this.f10307b, this.f10311f, this.f10310e);
    }
}
