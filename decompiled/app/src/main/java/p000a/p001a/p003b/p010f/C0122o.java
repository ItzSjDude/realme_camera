package p000a.p001a.p003b.p010f;

import p000a.p001a.p003b.p007c.C0094d;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.o */
/* loaded from: classes.dex */
public class C0122o {

    /* renamed from: PlatformImplementations.kt_3 */
    public C0094d[] f564a = {null, null};

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f565b = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public C0094d m562a() {
        return this.f564a[this.f565b];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m563a(C0094d c0094d, C0094d c0094d2) {
        C0094d[] c0094dArr = this.f564a;
        c0094dArr[0] = c0094d;
        c0094dArr[1] = c0094d2;
        this.f565b = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public C0094d m564b() {
        C0094d[] c0094dArr = this.f564a;
        return c0094dArr[(this.f565b + 1) % c0094dArr.length];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m565c() {
        this.f565b = (this.f565b + 1) % this.f564a.length;
    }
}
