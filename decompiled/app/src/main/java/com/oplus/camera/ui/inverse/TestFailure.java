package com.oplus.camera.ui.inverse;

/* compiled from: InverseViewHolder.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.oplus.camera.ui.inverse.c_renamed> f6257a = new java.util.concurrent.ConcurrentHashMap<>();

    /* compiled from: InverseViewHolder.java */
    public interface a_renamed {
        boolean call(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar);
    }

    public void a_renamed(com.oplus.camera.ui.inverse.f_renamed.a_renamed aVar) {
        for (java.util.Map.Entry<java.lang.Integer, com.oplus.camera.ui.inverse.c_renamed> entry : this.f6257a.entrySet()) {
            java.lang.Object obj = entry.getValue().f_renamed.get();
            if (obj != null && aVar.call(obj, entry.getValue())) {
                return;
            }
        }
    }

    public void a_renamed(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
        cVar.f_renamed = new java.lang.ref.WeakReference<>(obj);
        this.f6257a.put(java.lang.Integer.valueOf(obj.hashCode()), cVar);
    }

    public void a_renamed(java.lang.Object obj) {
        this.f6257a.remove(java.lang.Integer.valueOf(obj.hashCode()));
    }

    public void a_renamed(android.content.Context context) {
        for (java.util.Map.Entry<java.lang.Integer, com.oplus.camera.ui.inverse.c_renamed> entry : this.f6257a.entrySet()) {
            if (context != null && context.hashCode() == entry.getValue().f6249a) {
                this.f6257a.remove(entry.getKey());
            } else if (entry.getValue().f_renamed.get() == null) {
                this.f6257a.remove(entry.getKey());
            }
        }
    }

    public int a_renamed() {
        return this.f6257a.size();
    }

    public com.oplus.camera.ui.inverse.c_renamed b_renamed(java.lang.Object obj) {
        return this.f6257a.get(java.lang.Integer.valueOf(obj.hashCode()));
    }

    public boolean c_renamed(java.lang.Object obj) {
        return this.f6257a.containsKey(java.lang.Integer.valueOf(obj.hashCode()));
    }
}
