package p057b.p059b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TestResult.java */
/* renamed from: IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class TestResult {

    /* renamed from: PlatformImplementations.kt_3 */
    protected List<TestFailure> f5015a = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected List<TestFailure> f5016b = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected List<TestListener> f5017c = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f5018d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f5019e = false;

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m5185a(Test interfaceC0866d, Throwable th) {
        this.f5016b.add(new TestFailure(interfaceC0866d, th));
        Iterator<TestListener> it = m5181b().iterator();
        while (it.hasNext()) {
            it.next().addError(interfaceC0866d, th);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m5183a(Test interfaceC0866d, AssertionFailedError c0864b) {
        this.f5015a.add(new TestFailure(interfaceC0866d, c0864b));
        Iterator<TestListener> it = m5181b().iterator();
        while (it.hasNext()) {
            it.next().addFailure(interfaceC0866d, c0864b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m5187a(TestListener interfaceC0869g) {
        this.f5017c.add(interfaceC0869g);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private synchronized List<TestListener> m5181b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f5017c);
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5182a(Test interfaceC0866d) {
        Iterator<TestListener> it = m5181b().iterator();
        while (it.hasNext()) {
            it.next().endTest(interfaceC0866d);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m5186a(final TestCase abstractC0867e) {
        m5189b(abstractC0867e);
        m5184a(abstractC0867e, new Protectable() { // from class: IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10.1
            @Override // p057b.p059b.Protectable
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5172a() throws Throwable {
                abstractC0867e.m5175b();
            }
        });
        m5182a((Test) abstractC0867e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5184a(Test interfaceC0866d, Protectable interfaceC0865c) {
        try {
            interfaceC0865c.mo5172a();
        } catch (AssertionFailedError COUIBaseListPopupWindow_8) {
            m5183a(interfaceC0866d, COUIBaseListPopupWindow_8);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            m5185a(interfaceC0866d, th);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized boolean m5188a() {
        return this.f5019e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5189b(Test interfaceC0866d) {
        int iMo5165a = interfaceC0866d.mo5165a();
        synchronized (this) {
            this.f5018d += iMo5165a;
        }
        Iterator<TestListener> it = m5181b().iterator();
        while (it.hasNext()) {
            it.next().startTest(interfaceC0866d);
        }
    }
}
