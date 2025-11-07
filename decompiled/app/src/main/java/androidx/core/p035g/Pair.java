package androidx.core.p035g;

/* compiled from: Pair.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class Pair<F, S> {

    /* renamed from: PlatformImplementations.kt_3 */
    public final F f2937a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final S f2938b;

    public Pair(F COUIBaseListPopupWindow_12, S s) {
        this.f2937a = COUIBaseListPopupWindow_12;
        this.f2938b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair c0457d = (Pair) obj;
        return ObjectsCompat.m2530a(c0457d.f2937a, this.f2937a) && ObjectsCompat.m2530a(c0457d.f2938b, this.f2938b);
    }

    public int hashCode() {
        F COUIBaseListPopupWindow_12 = this.f2937a;
        int iHashCode = COUIBaseListPopupWindow_12 == null ? 0 : COUIBaseListPopupWindow_12.hashCode();
        S s = this.f2938b;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f2937a) + " " + String.valueOf(this.f2938b) + "}";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <A, B> Pair<A, B> m2531a(A a2, B b2) {
        return new Pair<>(a2, b2);
    }
}
