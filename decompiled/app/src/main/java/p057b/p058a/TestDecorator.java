package p057b.p058a;

import p057b.p059b.Assert;
import p057b.p059b.TestResult;
import p057b.p059b.Test;

/* compiled from: TestDecorator.java */
/* renamed from: IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class TestDecorator extends Assert implements Test {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Test f5011a;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5166a(TestResult c0870h) {
        this.f5011a.mo5168b(c0870h);
    }

    @Override // p057b.p059b.Test
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo5165a() {
        return this.f5011a.mo5165a();
    }

    @Override // p057b.p059b.Test
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5168b(TestResult c0870h) {
        m5166a(c0870h);
    }

    public String toString() {
        return this.f5011a.toString();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Test m5167b() {
        return this.f5011a;
    }
}
