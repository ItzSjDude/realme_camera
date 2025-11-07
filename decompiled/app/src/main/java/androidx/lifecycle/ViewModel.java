package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ViewModel.java */
/* renamed from: androidx.lifecycle.q */
/* loaded from: classes.dex */
public abstract class ViewModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Map<String, Object> f3651a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private volatile boolean f3652b = false;

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3530a() {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    final void m3676d() {
        this.f3652b = true;
        Map<String, Object> map = this.f3651a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f3651a.values().iterator();
                while (it.hasNext()) {
                    m3675a(it.next());
                }
            }
        }
        mo3530a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3675a(Object obj) throws IOException {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            }
        }
    }
}
