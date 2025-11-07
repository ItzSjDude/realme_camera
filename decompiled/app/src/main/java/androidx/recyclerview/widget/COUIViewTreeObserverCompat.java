package androidx.recyclerview.widget;

/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
class u_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView.w_renamed, androidx.recyclerview.widget.u_renamed.a_renamed> f1560a = new androidx.collection.SimpleArrayMap<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    final androidx.collection.LongSparseArray<androidx.recyclerview.widget.RecyclerView.w_renamed> f1561b = new androidx.collection.LongSparseArray<>();

    /* compiled from: ViewInfoStore.java */
    interface b_renamed {
        void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar);

        void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2);

        void b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2);

        void c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2);
    }

    u_renamed() {
    }

    void a_renamed() {
        this.f1560a.clear();
        this.f1561b.clear();
    }

    void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVarA = this.f1560a.get(wVar);
        if (aVarA == null) {
            aVarA = androidx.recyclerview.widget.u_renamed.a_renamed.a_renamed();
            this.f1560a.put(wVar, aVarA);
        }
        aVarA.f1563b = cVar;
        aVarA.f1562a |= 4;
    }

    boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVar = this.f1560a.get(wVar);
        return (aVar == null || (aVar.f1562a & 1) == 0) ? false : true;
    }

    androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        return a_renamed(wVar, 4);
    }

    androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        return a_renamed(wVar, 8);
    }

    private androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVarValueAt;
        androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar;
        int iIndexOfKey = this.f1560a.indexOfKey(wVar);
        if (iIndexOfKey < 0 || (aVarValueAt = this.f1560a.valueAt(iIndexOfKey)) == null || (aVarValueAt.f1562a & i_renamed) == 0) {
            return null;
        }
        aVarValueAt.f1562a &= ~i_renamed;
        if (i_renamed == 4) {
            cVar = aVarValueAt.f1563b;
        } else if (i_renamed == 8) {
            cVar = aVarValueAt.f1564c;
        } else {
            throw new java.lang.IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVarValueAt.f1562a & 12) == 0) {
            this.f1560a.removeAt(iIndexOfKey);
            androidx.recyclerview.widget.u_renamed.a_renamed.a_renamed(aVarValueAt);
        }
        return cVar;
    }

    void a_renamed(long j_renamed, androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        this.f1561b.put(j_renamed, wVar);
    }

    void b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVarA = this.f1560a.get(wVar);
        if (aVarA == null) {
            aVarA = androidx.recyclerview.widget.u_renamed.a_renamed.a_renamed();
            this.f1560a.put(wVar, aVarA);
        }
        aVarA.f1562a |= 2;
        aVarA.f1563b = cVar;
    }

    boolean d_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVar = this.f1560a.get(wVar);
        return (aVar == null || (aVar.f1562a & 4) == 0) ? false : true;
    }

    androidx.recyclerview.widget.RecyclerView.w_renamed a_renamed(long j_renamed) {
        return this.f1561b.get(j_renamed);
    }

    void c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVarA = this.f1560a.get(wVar);
        if (aVarA == null) {
            aVarA = androidx.recyclerview.widget.u_renamed.a_renamed.a_renamed();
            this.f1560a.put(wVar, aVarA);
        }
        aVarA.f1564c = cVar;
        aVarA.f1562a |= 8;
    }

    void e_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVarA = this.f1560a.get(wVar);
        if (aVarA == null) {
            aVarA = androidx.recyclerview.widget.u_renamed.a_renamed.a_renamed();
            this.f1560a.put(wVar, aVarA);
        }
        aVarA.f1562a |= 1;
    }

    void f_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        androidx.recyclerview.widget.u_renamed.a_renamed aVar = this.f1560a.get(wVar);
        if (aVar == null) {
            return;
        }
        aVar.f1562a &= -2;
    }

    void a_renamed(androidx.recyclerview.widget.u_renamed.b_renamed bVar) {
        for (int size = this.f1560a.size() - 1; size >= 0; size--) {
            androidx.recyclerview.widget.RecyclerView.w_renamed wVarKeyAt = this.f1560a.keyAt(size);
            androidx.recyclerview.widget.u_renamed.a_renamed aVarRemoveAt = this.f1560a.removeAt(size);
            if ((aVarRemoveAt.f1562a & 3) == 3) {
                bVar.a_renamed(wVarKeyAt);
            } else if ((aVarRemoveAt.f1562a & 1) != 0) {
                if (aVarRemoveAt.f1563b == null) {
                    bVar.a_renamed(wVarKeyAt);
                } else {
                    bVar.a_renamed(wVarKeyAt, aVarRemoveAt.f1563b, aVarRemoveAt.f1564c);
                }
            } else if ((aVarRemoveAt.f1562a & 14) == 14) {
                bVar.b_renamed(wVarKeyAt, aVarRemoveAt.f1563b, aVarRemoveAt.f1564c);
            } else if ((aVarRemoveAt.f1562a & 12) == 12) {
                bVar.c_renamed(wVarKeyAt, aVarRemoveAt.f1563b, aVarRemoveAt.f1564c);
            } else if ((aVarRemoveAt.f1562a & 4) != 0) {
                bVar.a_renamed(wVarKeyAt, aVarRemoveAt.f1563b, null);
            } else if ((aVarRemoveAt.f1562a & 8) != 0) {
                bVar.b_renamed(wVarKeyAt, aVarRemoveAt.f1563b, aVarRemoveAt.f1564c);
            } else {
                int i_renamed = aVarRemoveAt.f1562a;
            }
            androidx.recyclerview.widget.u_renamed.a_renamed.a_renamed(aVarRemoveAt);
        }
    }

    void g_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        int size = this.f1561b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (wVar == this.f1561b.valueAt(size)) {
                this.f1561b.removeAt(size);
                break;
            }
            size--;
        }
        androidx.recyclerview.widget.u_renamed.a_renamed aVarRemove = this.f1560a.remove(wVar);
        if (aVarRemove != null) {
            androidx.recyclerview.widget.u_renamed.a_renamed.a_renamed(aVarRemove);
        }
    }

    void b_renamed() {
        androidx.recyclerview.widget.u_renamed.a_renamed.b_renamed();
    }

    public void h_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        f_renamed(wVar);
    }

    /* compiled from: ViewInfoStore.java */
    static class a_renamed {
        static androidx.core.g_renamed.e_renamed.a_renamed<androidx.recyclerview.widget.u_renamed.a_renamed> d_renamed = new androidx.core.g_renamed.e_renamed.b_renamed(20);

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1562a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed f1563b;

        /* renamed from: c_renamed, reason: collision with root package name */
        androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed f1564c;

        private a_renamed() {
        }

        static androidx.recyclerview.widget.u_renamed.a_renamed a_renamed() {
            androidx.recyclerview.widget.u_renamed.a_renamed aVarA = d_renamed.a_renamed();
            return aVarA == null ? new androidx.recyclerview.widget.u_renamed.a_renamed() : aVarA;
        }

        static void a_renamed(androidx.recyclerview.widget.u_renamed.a_renamed aVar) {
            aVar.f1562a = 0;
            aVar.f1563b = null;
            aVar.f1564c = null;
            d_renamed.a_renamed(aVar);
        }

        static void b_renamed() {
            while (d_renamed.a_renamed() != null) {
            }
        }
    }
}
