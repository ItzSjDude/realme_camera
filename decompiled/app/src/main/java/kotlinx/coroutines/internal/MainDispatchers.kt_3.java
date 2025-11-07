package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.MainCoroutineDispatcher.kt;
import p061c.p076j.C0995c;

/* compiled from: MainDispatchers.kt */
/* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public final class MainDispatchers.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final MainCoroutineDispatcher.kt f24708a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final MainDispatchers.kt_3 f24709b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final boolean f24710c;

    static {
        MainDispatchers.kt_3 c3934l = new MainDispatchers.kt_3();
        f24709b = c3934l;
        f24710c = C3941s.m25904a("kotlinx.coroutines.fast.service.loader", true);
        f24708a = c3934l.m25879a();
    }

    private MainDispatchers.kt_3() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final MainCoroutineDispatcher.kt m25879a() {
        Object next;
        MainCoroutineDispatcher.kt abstractC3903bfM25881a;
        try {
            List<MainDispatcherFactory.kt> listM25842a = f24710c ? FastServiceLoader.kt_2.f24689a.m25842a() : C0995c.m5344b(C0995c.m5342a(ServiceLoader.load(MainDispatcherFactory.kt.class, MainDispatcherFactory.kt.class.getClassLoader()).iterator()));
            Iterator<T> it = listM25842a.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory.kt) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory.kt) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory.kt mainDispatcherFactory = (MainDispatcherFactory.kt) next;
            return (mainDispatcherFactory == null || (abstractC3903bfM25881a = MainDispatchers.kt.m25881a(mainDispatcherFactory, listM25842a)) == null) ? MainDispatchers.kt.m25883a(null, null, 3, null) : abstractC3903bfM25881a;
        } catch (Throwable th) {
            return MainDispatchers.kt.m25883a(th, null, 2, null);
        }
    }
}
