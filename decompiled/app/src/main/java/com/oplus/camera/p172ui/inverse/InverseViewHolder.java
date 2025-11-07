package com.oplus.camera.p172ui.inverse;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: InverseViewHolder.java */
/* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class InverseViewHolder {

    /* renamed from: PlatformImplementations.kt_3 */
    private ConcurrentHashMap<Integer, InverseData> f18756a = new ConcurrentHashMap<>();

    /* compiled from: InverseViewHolder.java */
    /* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        boolean call(Object obj, InverseData c3225c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20154a(PlatformImplementations.kt_3 aVar) {
        for (Map.Entry<Integer, InverseData> entry : this.f18756a.entrySet()) {
            Object obj = entry.getValue().f18750f.get();
            if (obj != null && aVar.call(obj, entry.getValue())) {
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20156a(Object obj, InverseData c3225c) {
        c3225c.f18750f = new WeakReference<>(obj);
        this.f18756a.put(Integer.valueOf(obj.hashCode()), c3225c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20155a(Object obj) {
        this.f18756a.remove(Integer.valueOf(obj.hashCode()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20153a(Context context) {
        for (Map.Entry<Integer, InverseData> entry : this.f18756a.entrySet()) {
            if (context != null && context.hashCode() == entry.getValue().f18745a) {
                this.f18756a.remove(entry.getKey());
            } else if (entry.getValue().f18750f.get() == null) {
                this.f18756a.remove(entry.getKey());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m20152a() {
        return this.f18756a.size();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public InverseData m20157b(Object obj) {
        return this.f18756a.get(Integer.valueOf(obj.hashCode()));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m20158c(Object obj) {
        return this.f18756a.containsKey(Integer.valueOf(obj.hashCode()));
    }
}
