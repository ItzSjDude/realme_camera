package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* loaded from: classes2.dex */
public abstract class ao_renamed extends kotlinx.coroutines.am_renamed {
    protected abstract java.lang.Thread a_renamed();

    protected final void j_renamed() {
        java.lang.Thread threadA = a_renamed();
        if (java.lang.Thread.currentThread() != threadA) {
            kotlinx.coroutines.bn_renamed bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
            if (bnVarA != null) {
                bnVarA.a_renamed(threadA);
            } else {
                java.util.concurrent.locks.LockSupport.unpark(threadA);
            }
        }
    }

    protected final void b_renamed(long j_renamed, kotlinx.coroutines.an_renamed.a_renamed aVar) {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(this != kotlinx.coroutines.ae_renamed.f7787b)) {
                throw new java.lang.AssertionError();
            }
        }
        kotlinx.coroutines.ae_renamed.f7787b.a_renamed(j_renamed, aVar);
    }
}
