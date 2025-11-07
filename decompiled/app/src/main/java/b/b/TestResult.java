package b_renamed.b_renamed;

/* compiled from: TestResult.java */
/* loaded from: classes.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected java.util.List<b_renamed.b_renamed.f_renamed> f1877a = new java.util.ArrayList();

    /* renamed from: b_renamed, reason: collision with root package name */
    protected java.util.List<b_renamed.b_renamed.f_renamed> f1878b = new java.util.ArrayList();

    /* renamed from: c_renamed, reason: collision with root package name */
    protected java.util.List<b_renamed.b_renamed.g_renamed> f1879c = new java.util.ArrayList();
    protected int d_renamed = 0;
    private boolean e_renamed = false;

    public synchronized void a_renamed(b_renamed.b_renamed.d_renamed dVar, java.lang.Throwable th) {
        this.f1878b.add(new b_renamed.b_renamed.f_renamed(dVar, th));
        java.util.Iterator<b_renamed.b_renamed.g_renamed> it = b_renamed().iterator();
        while (it.hasNext()) {
            it.next().addError(dVar, th);
        }
    }

    public synchronized void a_renamed(b_renamed.b_renamed.d_renamed dVar, b_renamed.b_renamed.b_renamed bVar) {
        this.f1877a.add(new b_renamed.b_renamed.f_renamed(dVar, bVar));
        java.util.Iterator<b_renamed.b_renamed.g_renamed> it = b_renamed().iterator();
        while (it.hasNext()) {
            it.next().addFailure(dVar, bVar);
        }
    }

    public synchronized void a_renamed(b_renamed.b_renamed.g_renamed gVar) {
        this.f1879c.add(gVar);
    }

    private synchronized java.util.List<b_renamed.b_renamed.g_renamed> b_renamed() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        arrayList.addAll(this.f1879c);
        return arrayList;
    }

    public void a_renamed(b_renamed.b_renamed.d_renamed dVar) {
        java.util.Iterator<b_renamed.b_renamed.g_renamed> it = b_renamed().iterator();
        while (it.hasNext()) {
            it.next().endTest(dVar);
        }
    }

    protected void a_renamed(final b_renamed.b_renamed.e_renamed eVar) {
        b_renamed(eVar);
        a_renamed(eVar, new b_renamed.b_renamed.c_renamed() { // from class: b_renamed.b_renamed.h_renamed.1
            @Override // b_renamed.b_renamed.c_renamed
            public void a_renamed() throws java.lang.Throwable {
                eVar.b_renamed();
            }
        });
        a_renamed((b_renamed.b_renamed.d_renamed) eVar);
    }

    public void a_renamed(b_renamed.b_renamed.d_renamed dVar, b_renamed.b_renamed.c_renamed cVar) {
        try {
            cVar.a_renamed();
        } catch (b_renamed.b_renamed.b_renamed e_renamed) {
            a_renamed(dVar, e_renamed);
        } catch (java.lang.ThreadDeath e2) {
            throw e2;
        } catch (java.lang.Throwable th) {
            a_renamed(dVar, th);
        }
    }

    public synchronized boolean a_renamed() {
        return this.e_renamed;
    }

    public void b_renamed(b_renamed.b_renamed.d_renamed dVar) {
        int iA = dVar.a_renamed();
        synchronized (this) {
            this.d_renamed += iA;
        }
        java.util.Iterator<b_renamed.b_renamed.g_renamed> it = b_renamed().iterator();
        while (it.hasNext()) {
            it.next().startTest(dVar);
        }
    }
}
