package androidx.coordinatorlayout.widget;

/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class a_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.core.g_renamed.e_renamed.a_renamed<java.util.ArrayList<T_renamed>> f775a = new androidx.core.g_renamed.e_renamed.b_renamed(10);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.collection.SimpleArrayMap<T_renamed, java.util.ArrayList<T_renamed>> f776b = new androidx.collection.SimpleArrayMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.ArrayList<T_renamed> f777c = new java.util.ArrayList<>();
    private final java.util.HashSet<T_renamed> d_renamed = new java.util.HashSet<>();

    public void a_renamed(T_renamed t_renamed) {
        if (this.f776b.containsKey(t_renamed)) {
            return;
        }
        this.f776b.put(t_renamed, null);
    }

    public boolean b_renamed(T_renamed t_renamed) {
        return this.f776b.containsKey(t_renamed);
    }

    public void a_renamed(T_renamed t_renamed, T_renamed t2) {
        if (!this.f776b.containsKey(t_renamed) || !this.f776b.containsKey(t2)) {
            throw new java.lang.IllegalArgumentException("All nodes must be_renamed present in_renamed the graph before being added as_renamed an_renamed edge");
        }
        java.util.ArrayList<T_renamed> arrayListC = this.f776b.get(t_renamed);
        if (arrayListC == null) {
            arrayListC = c_renamed();
            this.f776b.put(t_renamed, arrayListC);
        }
        arrayListC.add(t2);
    }

    public java.util.List c_renamed(T_renamed t_renamed) {
        return this.f776b.get(t_renamed);
    }

    public java.util.List<T_renamed> d_renamed(T_renamed t_renamed) {
        int size = this.f776b.size();
        java.util.ArrayList arrayList = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.util.ArrayList<T_renamed> arrayListValueAt = this.f776b.valueAt(i_renamed);
            if (arrayListValueAt != null && arrayListValueAt.contains(t_renamed)) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.add(this.f776b.keyAt(i_renamed));
            }
        }
        return arrayList;
    }

    public boolean e_renamed(T_renamed t_renamed) {
        int size = this.f776b.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.util.ArrayList<T_renamed> arrayListValueAt = this.f776b.valueAt(i_renamed);
            if (arrayListValueAt != null && arrayListValueAt.contains(t_renamed)) {
                return true;
            }
        }
        return false;
    }

    public void a_renamed() {
        int size = this.f776b.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.util.ArrayList<T_renamed> arrayListValueAt = this.f776b.valueAt(i_renamed);
            if (arrayListValueAt != null) {
                a_renamed((java.util.ArrayList) arrayListValueAt);
            }
        }
        this.f776b.clear();
    }

    public java.util.ArrayList<T_renamed> b_renamed() {
        this.f777c.clear();
        this.d_renamed.clear();
        int size = this.f776b.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            a_renamed(this.f776b.keyAt(i_renamed), this.f777c, this.d_renamed);
        }
        return this.f777c;
    }

    private void a_renamed(T_renamed t_renamed, java.util.ArrayList<T_renamed> arrayList, java.util.HashSet<T_renamed> hashSet) {
        if (arrayList.contains(t_renamed)) {
            return;
        }
        if (hashSet.contains(t_renamed)) {
            throw new java.lang.RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t_renamed);
        java.util.ArrayList<T_renamed> arrayList2 = this.f776b.get(t_renamed);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                a_renamed(arrayList2.get(i_renamed), arrayList, hashSet);
            }
        }
        hashSet.remove(t_renamed);
        arrayList.add(t_renamed);
    }

    private java.util.ArrayList<T_renamed> c_renamed() {
        java.util.ArrayList<T_renamed> arrayListA = this.f775a.a_renamed();
        return arrayListA == null ? new java.util.ArrayList<>() : arrayListA;
    }

    private void a_renamed(java.util.ArrayList<T_renamed> arrayList) {
        arrayList.clear();
        this.f775a.a_renamed(arrayList);
    }
}
