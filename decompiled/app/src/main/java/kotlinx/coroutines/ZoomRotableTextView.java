package kotlinx.coroutines;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes2.dex */
public abstract class ah_renamed<T_renamed> extends kotlinx.coroutines.b_renamed.i_renamed {
    public int e_renamed;

    /* JADX WARN: Multi-variable type inference failed */
    public <T_renamed> T_renamed a_renamed(java.lang.Object obj) {
        return obj;
    }

    public void a_renamed(java.lang.Object obj, java.lang.Throwable th) {
    }

    public abstract java.lang.Object b_renamed();

    public abstract c_renamed.c_renamed.d_renamed<T_renamed> e_renamed();

    public ah_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public final java.lang.Throwable b_renamed(java.lang.Object obj) {
        if (!(obj instanceof kotlinx.coroutines.l_renamed)) {
            obj = null;
        }
        kotlinx.coroutines.l_renamed lVar = (kotlinx.coroutines.l_renamed) obj;
        if (lVar != null) {
            return lVar.f7899a;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.Object objM4constructorimpl;
        java.lang.Object objM4constructorimpl2;
        java.lang.Object objM4constructorimpl3;
        java.util.concurrent.CancellationException cancellationExceptionB;
        kotlinx.coroutines.b_renamed.j_renamed jVar = this.g_renamed;
        java.lang.Throwable th = (java.lang.Throwable) null;
        try {
            c_renamed.c_renamed.d_renamed<T_renamed> dVarE = e_renamed();
            if (dVarE == null) {
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.DispatchedContinuation<T_renamed>");
            }
            kotlinx.coroutines.af_renamed afVar = (kotlinx.coroutines.af_renamed) dVarE;
            c_renamed.c_renamed.d_renamed<T_renamed> dVar = afVar.d_renamed;
            c_renamed.c_renamed.g_renamed context = dVar.getContext();
            java.lang.Object objB = b_renamed();
            java.lang.Object objA = kotlinx.coroutines.internal.v_renamed.a_renamed(context, afVar.f7789b);
            try {
                java.lang.Throwable thB = b_renamed(objB);
                kotlinx.coroutines.ay_renamed ayVar = kotlinx.coroutines.ai_renamed.a_renamed(this.e_renamed) ? (kotlinx.coroutines.ay_renamed) context.get(kotlinx.coroutines.ay_renamed.f7812b) : null;
                if (thB == null && ayVar != null && !ayVar.b_renamed()) {
                    java.util.concurrent.CancellationException cancellationExceptionH = ayVar.h_renamed();
                    a_renamed(objB, cancellationExceptionH);
                    c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                    if (kotlinx.coroutines.ac_renamed.c_renamed() && (dVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.d_renamed)) {
                        cancellationExceptionB = kotlinx.coroutines.internal.q_renamed.b_renamed(cancellationExceptionH, (c_renamed.c_renamed.b_renamed.a_renamed.d_renamed) dVar);
                    } else {
                        cancellationExceptionB = cancellationExceptionH;
                    }
                    dVar.resumeWith(c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(cancellationExceptionB)));
                } else if (thB != null) {
                    c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
                    dVar.resumeWith(c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(thB)));
                } else {
                    T_renamed tA = a_renamed(objB);
                    c_renamed.m_renamed.a_renamed aVar3 = c_renamed.m_renamed.Companion;
                    dVar.resumeWith(c_renamed.m_renamed.m4constructorimpl(tA));
                }
                c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                try {
                    c_renamed.m_renamed.a_renamed aVar4 = c_renamed.m_renamed.Companion;
                    kotlinx.coroutines.ah_renamed<T_renamed> ahVar = this;
                    jVar.a_renamed();
                    objM4constructorimpl3 = c_renamed.m_renamed.m4constructorimpl(c_renamed.s_renamed.f1925a);
                } catch (java.lang.Throwable th2) {
                    c_renamed.m_renamed.a_renamed aVar5 = c_renamed.m_renamed.Companion;
                    objM4constructorimpl3 = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th2));
                }
                a_renamed(th, c_renamed.m_renamed.m7exceptionOrNullimpl(objM4constructorimpl3));
            } finally {
                kotlinx.coroutines.internal.v_renamed.b_renamed(context, objA);
            }
        } catch (java.lang.Throwable th3) {
            try {
                c_renamed.m_renamed.a_renamed aVar6 = c_renamed.m_renamed.Companion;
                kotlinx.coroutines.ah_renamed<T_renamed> ahVar2 = this;
                jVar.a_renamed();
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.s_renamed.f1925a);
            } catch (java.lang.Throwable th4) {
                c_renamed.m_renamed.a_renamed aVar7 = c_renamed.m_renamed.Companion;
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th4));
            }
            a_renamed(th, c_renamed.m_renamed.m7exceptionOrNullimpl(objM4constructorimpl));
            throw th3;
        }
    }

    public final void a_renamed(java.lang.Throwable th, java.lang.Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            c_renamed.a_renamed.a_renamed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) th);
        kotlinx.coroutines.v_renamed.a_renamed(e_renamed().getContext(), new kotlinx.coroutines.ab_renamed("Fatal exception in_renamed coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }
}
