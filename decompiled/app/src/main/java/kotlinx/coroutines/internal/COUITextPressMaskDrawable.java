package kotlinx.coroutines.internal;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes2.dex */
public final class q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7884a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String f7885b;

    static {
        java.lang.Object objM4constructorimpl;
        java.lang.Object objM4constructorimpl2;
        try {
            c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(java.lang.Class.forName("c_renamed.c_renamed.b_renamed.a_renamed.a_renamed").getCanonicalName());
        } catch (java.lang.Throwable th) {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th));
        }
        f7884a = (java.lang.String) (c_renamed.m_renamed.m7exceptionOrNullimpl(objM4constructorimpl) == null ? objM4constructorimpl : "c_renamed.c_renamed.b_renamed.a_renamed.a_renamed");
        try {
            c_renamed.m_renamed.a_renamed aVar3 = c_renamed.m_renamed.Companion;
            objM4constructorimpl2 = c_renamed.m_renamed.m4constructorimpl(java.lang.Class.forName("kotlinx.coroutines.internal.q_renamed").getCanonicalName());
        } catch (java.lang.Throwable th2) {
            c_renamed.m_renamed.a_renamed aVar4 = c_renamed.m_renamed.Companion;
            objM4constructorimpl2 = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th2));
        }
        f7885b = (java.lang.String) (c_renamed.m_renamed.m7exceptionOrNullimpl(objM4constructorimpl2) == null ? objM4constructorimpl2 : "kotlinx.coroutines.internal.q_renamed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E_renamed extends java.lang.Throwable> E_renamed b_renamed(E_renamed e_renamed, c_renamed.c_renamed.b_renamed.a_renamed.d_renamed dVar) {
        c_renamed.l_renamed lVarB = b_renamed(e_renamed);
        java.lang.Throwable th = (java.lang.Throwable) lVarB.component1();
        java.lang.StackTraceElement[] stackTraceElementArr = (java.lang.StackTraceElement[]) lVarB.component2();
        java.lang.Throwable thA = kotlinx.coroutines.internal.d_renamed.a_renamed(th);
        if (thA == null || (!c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) thA.getMessage(), (java.lang.Object) th.getMessage()))) {
            return e_renamed;
        }
        java.util.ArrayDeque<java.lang.StackTraceElement> arrayDequeA = a_renamed(dVar);
        if (arrayDequeA.isEmpty()) {
            return e_renamed;
        }
        if (th != e_renamed) {
            a_renamed(stackTraceElementArr, arrayDequeA);
        }
        return (E_renamed) a_renamed(th, thA, arrayDequeA);
    }

    private static final <E_renamed extends java.lang.Throwable> E_renamed a_renamed(E_renamed e_renamed, E_renamed e2, java.util.ArrayDeque<java.lang.StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(a_renamed("Coroutine boundary"));
        java.lang.StackTraceElement[] stackTrace = e_renamed.getStackTrace();
        int iA = a_renamed(stackTrace, f7884a);
        int i_renamed = 0;
        if (iA != -1) {
            java.lang.StackTraceElement[] stackTraceElementArr = new java.lang.StackTraceElement[arrayDeque.size() + iA];
            for (int i2 = 0; i2 < iA; i2++) {
                stackTraceElementArr[i2] = stackTrace[i2];
            }
            java.util.Iterator<T_renamed> it = arrayDeque.iterator();
            while (it.hasNext()) {
                stackTraceElementArr[iA + i_renamed] = (java.lang.StackTraceElement) it.next();
                i_renamed++;
            }
            e2.setStackTrace(stackTraceElementArr);
            return e2;
        }
        java.lang.Object[] array = arrayDeque.toArray(new java.lang.StackTraceElement[0]);
        if (array == null) {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.Array<T_renamed>");
        }
        e2.setStackTrace((java.lang.StackTraceElement[]) array);
        return e2;
    }

    private static final <E_renamed extends java.lang.Throwable> c_renamed.l_renamed<E_renamed, java.lang.StackTraceElement[]> b_renamed(E_renamed e_renamed) {
        boolean z_renamed;
        java.lang.Throwable cause = e_renamed.getCause();
        if (cause != null && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(cause.getClass(), e_renamed.getClass())) {
            java.lang.StackTraceElement[] stackTrace = e_renamed.getStackTrace();
            int length = stackTrace.length;
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= length) {
                    z_renamed = false;
                    break;
                }
                if (a_renamed(stackTrace[i_renamed])) {
                    z_renamed = true;
                    break;
                }
                i_renamed++;
            }
            if (z_renamed) {
                return c_renamed.p_renamed.a_renamed(cause, stackTrace);
            }
            return c_renamed.p_renamed.a_renamed(e_renamed, new java.lang.StackTraceElement[0]);
        }
        return c_renamed.p_renamed.a_renamed(e_renamed, new java.lang.StackTraceElement[0]);
    }

    public static final <E_renamed extends java.lang.Throwable> E_renamed a_renamed(E_renamed e_renamed) {
        E_renamed e2 = (E_renamed) e_renamed.getCause();
        if (e2 != null) {
            boolean z_renamed = true;
            if (!(!c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(e2.getClass(), e_renamed.getClass()))) {
                java.lang.StackTraceElement[] stackTrace = e_renamed.getStackTrace();
                int length = stackTrace.length;
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= length) {
                        z_renamed = false;
                        break;
                    }
                    if (a_renamed(stackTrace[i_renamed])) {
                        break;
                    }
                    i_renamed++;
                }
                if (z_renamed) {
                    return e2;
                }
            }
        }
        return e_renamed;
    }

    private static final java.util.ArrayDeque<java.lang.StackTraceElement> a_renamed(c_renamed.c_renamed.b_renamed.a_renamed.d_renamed dVar) {
        java.util.ArrayDeque<java.lang.StackTraceElement> arrayDeque = new java.util.ArrayDeque<>();
        java.lang.StackTraceElement stackTraceElement = dVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(dVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.d_renamed)) {
                dVar = null;
            }
            if (dVar == null || (dVar = dVar.getCallerFrame()) == null) {
                break;
            }
            java.lang.StackTraceElement stackTraceElement2 = dVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    public static final java.lang.StackTraceElement a_renamed(java.lang.String str) {
        return new java.lang.StackTraceElement("\b_renamed\b_renamed\b_renamed(" + str, "\b_renamed", "\b_renamed", -1);
    }

    public static final boolean a_renamed(java.lang.StackTraceElement stackTraceElement) {
        return c_renamed.k_renamed.d_renamed.a_renamed(stackTraceElement.getClassName(), "\b_renamed\b_renamed\b_renamed", false, 2, (java.lang.Object) null);
    }

    private static final boolean a_renamed(java.lang.StackTraceElement stackTraceElement, java.lang.StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) stackTraceElement.getMethodName(), (java.lang.Object) stackTraceElement2.getMethodName()) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) stackTraceElement.getFileName(), (java.lang.Object) stackTraceElement2.getFileName()) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) stackTraceElement.getClassName(), (java.lang.Object) stackTraceElement2.getClassName());
    }

    private static final void a_renamed(java.lang.StackTraceElement[] stackTraceElementArr, java.util.ArrayDeque<java.lang.StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= length) {
                i_renamed = -1;
                break;
            } else if (a_renamed(stackTraceElementArr[i_renamed])) {
                break;
            } else {
                i_renamed++;
            }
        }
        int i2 = i_renamed + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (a_renamed(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            } else {
                length2--;
            }
        }
    }

    private static final int a_renamed(java.lang.StackTraceElement[] stackTraceElementArr, java.lang.String str) {
        int length = stackTraceElementArr.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            if (c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) str, (java.lang.Object) stackTraceElementArr[i_renamed].getClassName())) {
                return i_renamed;
            }
        }
        return -1;
    }
}
