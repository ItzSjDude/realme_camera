package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import p061c.Tuples.kt_2;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.Tuples.kt;
import p061c.p064c.p066b.p067a.CoroutineStackFrame.kt;
import p061c.p070f.p072b.Intrinsics;
import p061c.p077k.C1005d;

/* compiled from: StackTraceRecovery.kt */
/* renamed from: kotlinx.coroutines.internal.q */
/* loaded from: classes2.dex */
public final class StackTraceRecovery.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f24715a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String f24716b;

    static {
        Object objM26270constructorimpl;
        Object objM26270constructorimpl2;
        try {
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Class.forName("IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3").getCanonicalName());
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th));
        }
        f24715a = (String) (Result.kt.m26273exceptionOrNullimpl(objM26270constructorimpl) == null ? objM26270constructorimpl : "IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3");
        try {
            Result.kt.PlatformImplementations.kt_3 aVar3 = Result.kt.Companion;
            objM26270constructorimpl2 = Result.kt.m26270constructorimpl(Class.forName("kotlinx.coroutines.internal.q").getCanonicalName());
        } catch (Throwable th2) {
            Result.kt.PlatformImplementations.kt_3 aVar4 = Result.kt.Companion;
            objM26270constructorimpl2 = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th2));
        }
        f24716b = (String) (Result.kt.m26273exceptionOrNullimpl(objM26270constructorimpl2) == null ? objM26270constructorimpl2 : "kotlinx.coroutines.internal.q");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <E extends Throwable> E m25897b(E COUIBaseListPopupWindow_8, CoroutineStackFrame.kt interfaceC0921d) {
        Tuples.kt_2 c1018lM25896b = m25896b(COUIBaseListPopupWindow_8);
        Throwable th = (Throwable) c1018lM25896b.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c1018lM25896b.component2();
        Throwable thM25836a = ExceptionsConstuctor.kt.m25836a(th);
        if (thM25836a == null || (!Intrinsics.m5299a((Object) thM25836a.getMessage(), (Object) th.getMessage()))) {
            return COUIBaseListPopupWindow_8;
        }
        ArrayDeque<StackTraceElement> arrayDequeM25892a = m25892a(interfaceC0921d);
        if (arrayDequeM25892a.isEmpty()) {
            return COUIBaseListPopupWindow_8;
        }
        if (th != COUIBaseListPopupWindow_8) {
            m25893a(stackTraceElementArr, arrayDequeM25892a);
        }
        return (E) m25891a(th, thM25836a, arrayDequeM25892a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final <E extends Throwable> E m25891a(E COUIBaseListPopupWindow_8, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(m25888a("Coroutine boundary"));
        StackTraceElement[] stackTrace = COUIBaseListPopupWindow_8.getStackTrace();
        int iM25887a = m25887a(stackTrace, f24715a);
        int OplusGLSurfaceView_13 = 0;
        if (iM25887a != -1) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + iM25887a];
            for (int i2 = 0; i2 < iM25887a; i2++) {
                stackTraceElementArr[i2] = stackTrace[i2];
            }
            Iterator<T> it = arrayDeque.iterator();
            while (it.hasNext()) {
                stackTraceElementArr[iM25887a + OplusGLSurfaceView_13] = (StackTraceElement) it.next();
                OplusGLSurfaceView_13++;
            }
            e2.setStackTrace(stackTraceElementArr);
            return e2;
        }
        Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        e2.setStackTrace((StackTraceElement[]) array);
        return e2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final <E extends Throwable> Tuples.kt_2<E, StackTraceElement[]> m25896b(E COUIBaseListPopupWindow_8) {
        boolean z;
        Throwable cause = COUIBaseListPopupWindow_8.getCause();
        if (cause != null && Intrinsics.m5299a(cause.getClass(), COUIBaseListPopupWindow_8.getClass())) {
            StackTraceElement[] stackTrace = COUIBaseListPopupWindow_8.getStackTrace();
            int length = stackTrace.length;
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= length) {
                    z = false;
                    break;
                }
                if (m25894a(stackTrace[OplusGLSurfaceView_13])) {
                    z = true;
                    break;
                }
                OplusGLSurfaceView_13++;
            }
            if (z) {
                return Tuples.kt.m5382a(cause, stackTrace);
            }
            return Tuples.kt.m5382a(COUIBaseListPopupWindow_8, new StackTraceElement[0]);
        }
        return Tuples.kt.m5382a(COUIBaseListPopupWindow_8, new StackTraceElement[0]);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <E extends Throwable> E m25889a(E COUIBaseListPopupWindow_8) {
        E e2 = (E) COUIBaseListPopupWindow_8.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!Intrinsics.m5299a(e2.getClass(), COUIBaseListPopupWindow_8.getClass()))) {
                StackTraceElement[] stackTrace = COUIBaseListPopupWindow_8.getStackTrace();
                int length = stackTrace.length;
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= length) {
                        z = false;
                        break;
                    }
                    if (m25894a(stackTrace[OplusGLSurfaceView_13])) {
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
                if (z) {
                    return e2;
                }
            }
        }
        return COUIBaseListPopupWindow_8;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ArrayDeque<StackTraceElement> m25892a(CoroutineStackFrame.kt interfaceC0921d) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = interfaceC0921d.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(interfaceC0921d instanceof CoroutineStackFrame.kt)) {
                interfaceC0921d = null;
            }
            if (interfaceC0921d == null || (interfaceC0921d = interfaceC0921d.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = interfaceC0921d.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final StackTraceElement m25888a(String str) {
        return new StackTraceElement("\IntrinsicsJvm.kt_4\IntrinsicsJvm.kt_4\IntrinsicsJvm.kt_4(" + str, "\IntrinsicsJvm.kt_4", "\IntrinsicsJvm.kt_4", -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m25894a(StackTraceElement stackTraceElement) {
        return C1005d.m5356a(stackTraceElement.getClassName(), "\IntrinsicsJvm.kt_4\IntrinsicsJvm.kt_4\IntrinsicsJvm.kt_4", false, 2, (Object) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean m25895a(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.m5299a((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && Intrinsics.m5299a((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && Intrinsics.m5299a((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final void m25893a(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= length) {
                OplusGLSurfaceView_13 = -1;
                break;
            } else if (m25894a(stackTraceElementArr[OplusGLSurfaceView_13])) {
                break;
            } else {
                OplusGLSurfaceView_13++;
            }
        }
        int i2 = OplusGLSurfaceView_13 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (m25895a(stackTraceElementArr[length2], arrayDeque.getLast())) {
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

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int m25887a(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            if (Intrinsics.m5299a((Object) str, (Object) stackTraceElementArr[OplusGLSurfaceView_13].getClassName())) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }
}
