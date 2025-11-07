package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher.kt;
import p061c.ExceptionsH.kt;

/* compiled from: MainDispatchers.kt */
/* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public final class MainDispatchers.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f24711a = true;

    /* renamed from: PlatformImplementations.kt_3 */
    public static final MainCoroutineDispatcher.kt m25881a(MainDispatcherFactory.kt mainDispatcherFactory, List<? extends MainDispatcherFactory.kt> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return m25882a(th, mainDispatcherFactory.hintOnError());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ MainDispatchers.kt_2 m25883a(Throwable th, String str, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            th = (Throwable) null;
        }
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            str = (String) null;
        }
        return m25882a(th, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final MainDispatchers.kt_2 m25882a(Throwable th, String str) throws Throwable {
        if (f24711a) {
            return new MainDispatchers.kt_2(th, str);
        }
        if (th != null) {
            throw th;
        }
        m25880a();
        throw new ExceptionsH.kt();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Void m25880a() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_11. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
