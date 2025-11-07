package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ViewModelStore.java */
/* renamed from: androidx.lifecycle.s */
/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: PlatformImplementations.kt_3 */
    private final HashMap<String, ViewModel> f3655a = new HashMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    final void m3682a(String str, ViewModel abstractC0614q) {
        ViewModel abstractC0614qPut = this.f3655a.put(str, abstractC0614q);
        if (abstractC0614qPut != null) {
            abstractC0614qPut.mo3530a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final ViewModel m3680a(String str) {
        return this.f3655a.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m3681a() {
        Iterator<ViewModel> it = this.f3655a.values().iterator();
        while (it.hasNext()) {
            it.next().m3676d();
        }
        this.f3655a.clear();
    }
}
