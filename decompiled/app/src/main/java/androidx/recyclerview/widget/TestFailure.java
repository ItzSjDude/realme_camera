package androidx.recyclerview.widget;

/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Comparator<androidx.recyclerview.widget.f_renamed.c_renamed> f1500a = new java.util.Comparator<androidx.recyclerview.widget.f_renamed.c_renamed>() { // from class: androidx.recyclerview.widget.f_renamed.1
        @Override // java.util.Comparator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.recyclerview.widget.f_renamed.c_renamed cVar, androidx.recyclerview.widget.f_renamed.c_renamed cVar2) {
            return cVar.f1503a - cVar2.f1503a;
        }
    };

    /* compiled from: DiffUtil.java */
    public static abstract class a_renamed {
        public abstract int a_renamed();

        public abstract boolean a_renamed(int i_renamed, int i2);

        public abstract int b_renamed();

        public abstract boolean b_renamed(int i_renamed, int i2);

        public java.lang.Object c_renamed(int i_renamed, int i2) {
            return null;
        }
    }

    public static androidx.recyclerview.widget.f_renamed.d_renamed a_renamed(androidx.recyclerview.widget.f_renamed.a_renamed aVar) {
        return a_renamed(aVar, true);
    }

    public static androidx.recyclerview.widget.f_renamed.d_renamed a_renamed(androidx.recyclerview.widget.f_renamed.a_renamed aVar, boolean z_renamed) {
        int iA = aVar.a_renamed();
        int iB = aVar.b_renamed();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(new androidx.recyclerview.widget.f_renamed.DiffUtil_5(0, iA, 0, iB));
        int i_renamed = ((((iA + iB) + 1) / 2) * 2) + 1;
        androidx.recyclerview.widget.f_renamed.b_renamed bVar = new androidx.recyclerview.widget.f_renamed.b_renamed(i_renamed);
        androidx.recyclerview.widget.f_renamed.b_renamed bVar2 = new androidx.recyclerview.widget.f_renamed.b_renamed(i_renamed);
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        while (!arrayList2.isEmpty()) {
            androidx.recyclerview.widget.f_renamed.DiffUtil_5 c0038f = (androidx.recyclerview.widget.f_renamed.DiffUtil_5) arrayList2.remove(arrayList2.size() - 1);
            androidx.recyclerview.widget.f_renamed.g_renamed gVarA = a_renamed(c0038f, aVar, bVar, bVar2);
            if (gVarA != null) {
                if (gVarA.c_renamed() > 0) {
                    arrayList.add(gVarA.d_renamed());
                }
                androidx.recyclerview.widget.f_renamed.DiffUtil_5 c0038f2 = arrayList3.isEmpty() ? new androidx.recyclerview.widget.f_renamed.DiffUtil_5() : (androidx.recyclerview.widget.f_renamed.DiffUtil_5) arrayList3.remove(arrayList3.size() - 1);
                c0038f2.f1512a = c0038f.f1512a;
                c0038f2.f1514c = c0038f.f1514c;
                c0038f2.f1513b = gVarA.f1515a;
                c0038f2.d_renamed = gVarA.f1516b;
                arrayList2.add(c0038f2);
                c0038f.f1513b = c0038f.f1513b;
                c0038f.d_renamed = c0038f.d_renamed;
                c0038f.f1512a = gVarA.f1517c;
                c0038f.f1514c = gVarA.d_renamed;
                arrayList2.add(c0038f);
            } else {
                arrayList3.add(c0038f);
            }
        }
        java.util.Collections.sort(arrayList, f1500a);
        return new androidx.recyclerview.widget.f_renamed.d_renamed(aVar, arrayList, bVar.a_renamed(), bVar2.a_renamed(), z_renamed);
    }

    private static androidx.recyclerview.widget.f_renamed.g_renamed a_renamed(androidx.recyclerview.widget.f_renamed.DiffUtil_5 c0038f, androidx.recyclerview.widget.f_renamed.a_renamed aVar, androidx.recyclerview.widget.f_renamed.b_renamed bVar, androidx.recyclerview.widget.f_renamed.b_renamed bVar2) {
        if (c0038f.a_renamed() >= 1 && c0038f.b_renamed() >= 1) {
            int iA = ((c0038f.a_renamed() + c0038f.b_renamed()) + 1) / 2;
            bVar.a_renamed(1, c0038f.f1512a);
            bVar2.a_renamed(1, c0038f.f1513b);
            for (int i_renamed = 0; i_renamed < iA; i_renamed++) {
                androidx.recyclerview.widget.f_renamed.g_renamed gVarA = a_renamed(c0038f, aVar, bVar, bVar2, i_renamed);
                if (gVarA != null) {
                    return gVarA;
                }
                androidx.recyclerview.widget.f_renamed.g_renamed gVarB = b_renamed(c0038f, aVar, bVar, bVar2, i_renamed);
                if (gVarB != null) {
                    return gVarB;
                }
            }
        }
        return null;
    }

    private static androidx.recyclerview.widget.f_renamed.g_renamed a_renamed(androidx.recyclerview.widget.f_renamed.DiffUtil_5 c0038f, androidx.recyclerview.widget.f_renamed.a_renamed aVar, androidx.recyclerview.widget.f_renamed.b_renamed bVar, androidx.recyclerview.widget.f_renamed.b_renamed bVar2, int i_renamed) {
        int iA;
        int i2;
        int i3;
        boolean z_renamed = java.lang.Math.abs(c0038f.a_renamed() - c0038f.b_renamed()) % 2 == 1;
        int iA2 = c0038f.a_renamed() - c0038f.b_renamed();
        int i4 = -i_renamed;
        for (int i5 = i4; i5 <= i_renamed; i5 += 2) {
            if (i5 == i4 || (i5 != i_renamed && bVar.a_renamed(i5 + 1) > bVar.a_renamed(i5 - 1))) {
                iA = bVar.a_renamed(i5 + 1);
                i2 = iA;
            } else {
                int iA3 = bVar.a_renamed(i5 - 1);
                i2 = iA3;
                iA = iA3 + 1;
            }
            int i6 = (c0038f.f1514c + (iA - c0038f.f1512a)) - i5;
            int i7 = (i_renamed == 0 || iA != i2) ? i6 : i6 - 1;
            while (iA < c0038f.f1513b && i6 < c0038f.d_renamed) {
                if (!aVar.a_renamed(iA, i6)) {
                    break;
                }
                iA++;
                i6++;
            }
            bVar.a_renamed(i5, iA);
            if (z_renamed && (i3 = iA2 - i5) >= i4 + 1 && i3 <= i_renamed - 1) {
                if (bVar2.a_renamed(i3) <= iA) {
                    androidx.recyclerview.widget.f_renamed.g_renamed gVar = new androidx.recyclerview.widget.f_renamed.g_renamed();
                    gVar.f1515a = i2;
                    gVar.f1516b = i7;
                    gVar.f1517c = iA;
                    gVar.d_renamed = i6;
                    gVar.e_renamed = false;
                    return gVar;
                }
            }
        }
        return null;
    }

    private static androidx.recyclerview.widget.f_renamed.g_renamed b_renamed(androidx.recyclerview.widget.f_renamed.DiffUtil_5 c0038f, androidx.recyclerview.widget.f_renamed.a_renamed aVar, androidx.recyclerview.widget.f_renamed.b_renamed bVar, androidx.recyclerview.widget.f_renamed.b_renamed bVar2, int i_renamed) {
        int iA;
        int i2;
        int i3;
        boolean z_renamed = (c0038f.a_renamed() - c0038f.b_renamed()) % 2 == 0;
        int iA2 = c0038f.a_renamed() - c0038f.b_renamed();
        int i4 = -i_renamed;
        for (int i5 = i4; i5 <= i_renamed; i5 += 2) {
            if (i5 == i4 || (i5 != i_renamed && bVar2.a_renamed(i5 + 1) < bVar2.a_renamed(i5 - 1))) {
                iA = bVar2.a_renamed(i5 + 1);
                i2 = iA;
            } else {
                int iA3 = bVar2.a_renamed(i5 - 1);
                i2 = iA3;
                iA = iA3 - 1;
            }
            int i6 = c0038f.d_renamed - ((c0038f.f1513b - iA) - i5);
            int i7 = (i_renamed == 0 || iA != i2) ? i6 : i6 + 1;
            while (iA > c0038f.f1512a && i6 > c0038f.f1514c) {
                if (!aVar.a_renamed(iA - 1, i6 - 1)) {
                    break;
                }
                iA--;
                i6--;
            }
            bVar2.a_renamed(i5, iA);
            if (z_renamed && (i3 = iA2 - i5) >= i4 && i3 <= i_renamed) {
                if (bVar.a_renamed(i3) >= iA) {
                    androidx.recyclerview.widget.f_renamed.g_renamed gVar = new androidx.recyclerview.widget.f_renamed.g_renamed();
                    gVar.f1515a = iA;
                    gVar.f1516b = i6;
                    gVar.f1517c = i2;
                    gVar.d_renamed = i7;
                    gVar.e_renamed = true;
                    return gVar;
                }
            }
        }
        return null;
    }

    /* compiled from: DiffUtil.java */
    static class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final int f1503a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final int f1504b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final int f1505c;

        c_renamed(int i_renamed, int i2, int i3) {
            this.f1503a = i_renamed;
            this.f1504b = i2;
            this.f1505c = i3;
        }

        int a_renamed() {
            return this.f1503a + this.f1505c;
        }

        int b_renamed() {
            return this.f1504b + this.f1505c;
        }
    }

    /* compiled from: DiffUtil.java */
    static class g_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f1515a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f1516b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f1517c;
        public int d_renamed;
        public boolean e_renamed;

        g_renamed() {
        }

        boolean a_renamed() {
            return this.d_renamed - this.f1516b != this.f1517c - this.f1515a;
        }

        boolean b_renamed() {
            return this.d_renamed - this.f1516b > this.f1517c - this.f1515a;
        }

        int c_renamed() {
            return java.lang.Math.min(this.f1517c - this.f1515a, this.d_renamed - this.f1516b);
        }

        androidx.recyclerview.widget.f_renamed.c_renamed d_renamed() {
            if (a_renamed()) {
                if (this.e_renamed) {
                    return new androidx.recyclerview.widget.f_renamed.c_renamed(this.f1515a, this.f1516b, c_renamed());
                }
                if (b_renamed()) {
                    return new androidx.recyclerview.widget.f_renamed.c_renamed(this.f1515a, this.f1516b + 1, c_renamed());
                }
                return new androidx.recyclerview.widget.f_renamed.c_renamed(this.f1515a + 1, this.f1516b, c_renamed());
            }
            int i_renamed = this.f1515a;
            return new androidx.recyclerview.widget.f_renamed.c_renamed(i_renamed, this.f1516b, this.f1517c - i_renamed);
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.f_renamed$f_renamed, reason: collision with other inner class name */
    static class DiffUtil_5 {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1512a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1513b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1514c;
        int d_renamed;

        public DiffUtil_5() {
        }

        public DiffUtil_5(int i_renamed, int i2, int i3, int i4) {
            this.f1512a = i_renamed;
            this.f1513b = i2;
            this.f1514c = i3;
            this.d_renamed = i4;
        }

        int a_renamed() {
            return this.f1513b - this.f1512a;
        }

        int b_renamed() {
            return this.d_renamed - this.f1514c;
        }
    }

    /* compiled from: DiffUtil.java */
    public static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.util.List<androidx.recyclerview.widget.f_renamed.c_renamed> f1506a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int[] f1507b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int[] f1508c;
        private final androidx.recyclerview.widget.f_renamed.a_renamed d_renamed;
        private final int e_renamed;
        private final int f_renamed;
        private final boolean g_renamed;

        d_renamed(androidx.recyclerview.widget.f_renamed.a_renamed aVar, java.util.List<androidx.recyclerview.widget.f_renamed.c_renamed> list, int[] iArr, int[] iArr2, boolean z_renamed) {
            this.f1506a = list;
            this.f1507b = iArr;
            this.f1508c = iArr2;
            java.util.Arrays.fill(this.f1507b, 0);
            java.util.Arrays.fill(this.f1508c, 0);
            this.d_renamed = aVar;
            this.e_renamed = aVar.a_renamed();
            this.f_renamed = aVar.b_renamed();
            this.g_renamed = z_renamed;
            a_renamed();
            b_renamed();
        }

        private void a_renamed() {
            androidx.recyclerview.widget.f_renamed.c_renamed cVar = this.f1506a.isEmpty() ? null : this.f1506a.get(0);
            if (cVar == null || cVar.f1503a != 0 || cVar.f1504b != 0) {
                this.f1506a.add(0, new androidx.recyclerview.widget.f_renamed.c_renamed(0, 0, 0));
            }
            this.f1506a.add(new androidx.recyclerview.widget.f_renamed.c_renamed(this.e_renamed, this.f_renamed, 0));
        }

        private void b_renamed() {
            for (androidx.recyclerview.widget.f_renamed.c_renamed cVar : this.f1506a) {
                for (int i_renamed = 0; i_renamed < cVar.f1505c; i_renamed++) {
                    int i2 = cVar.f1503a + i_renamed;
                    int i3 = cVar.f1504b + i_renamed;
                    int i4 = this.d_renamed.b_renamed(i2, i3) ? 1 : 2;
                    this.f1507b[i2] = (i3 << 4) | i4;
                    this.f1508c[i3] = (i2 << 4) | i4;
                }
            }
            if (this.g_renamed) {
                c_renamed();
            }
        }

        private void c_renamed() {
            int iA = 0;
            for (androidx.recyclerview.widget.f_renamed.c_renamed cVar : this.f1506a) {
                while (iA < cVar.f1503a) {
                    if (this.f1507b[iA] == 0) {
                        a_renamed(iA);
                    }
                    iA++;
                }
                iA = cVar.a_renamed();
            }
        }

        private void a_renamed(int i_renamed) {
            int size = this.f1506a.size();
            int iB = 0;
            for (int i2 = 0; i2 < size; i2++) {
                androidx.recyclerview.widget.f_renamed.c_renamed cVar = this.f1506a.get(i2);
                while (iB < cVar.f1504b) {
                    if (this.f1508c[iB] == 0 && this.d_renamed.a_renamed(i_renamed, iB)) {
                        int i3 = this.d_renamed.b_renamed(i_renamed, iB) ? 8 : 4;
                        this.f1507b[i_renamed] = (iB << 4) | i3;
                        this.f1508c[iB] = (i_renamed << 4) | i3;
                        return;
                    }
                    iB++;
                }
                iB = cVar.b_renamed();
            }
        }

        public void a_renamed(androidx.recyclerview.widget.RecyclerView.a_renamed aVar) {
            a_renamed(new androidx.recyclerview.widget.b_renamed(aVar));
        }

        public void a_renamed(androidx.recyclerview.widget.l_renamed lVar) {
            androidx.recyclerview.widget.c_renamed cVar;
            int i_renamed;
            if (lVar instanceof androidx.recyclerview.widget.c_renamed) {
                cVar = (androidx.recyclerview.widget.c_renamed) lVar;
            } else {
                cVar = new androidx.recyclerview.widget.c_renamed(lVar);
            }
            int i2 = this.e_renamed;
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
            int i3 = this.e_renamed;
            int i4 = this.f_renamed;
            for (int size = this.f1506a.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.f_renamed.c_renamed cVar2 = this.f1506a.get(size);
                int iA = cVar2.a_renamed();
                int iB = cVar2.b_renamed();
                while (true) {
                    if (i3 <= iA) {
                        break;
                    }
                    i3--;
                    int i5 = this.f1507b[i3];
                    if ((i5 & 12) != 0) {
                        int i6 = i5 >> 4;
                        androidx.recyclerview.widget.f_renamed.e_renamed eVarA = a_renamed(arrayDeque, i6, false);
                        if (eVarA != null) {
                            int i7 = (i2 - eVarA.f1510b) - 1;
                            cVar.c_renamed(i3, i7);
                            if ((i5 & 4) != 0) {
                                cVar.a_renamed(i7, 1, this.d_renamed.c_renamed(i3, i6));
                            }
                        } else {
                            arrayDeque.add(new androidx.recyclerview.widget.f_renamed.e_renamed(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        cVar.b_renamed(i3, 1);
                        i2--;
                    }
                }
                while (i4 > iB) {
                    i4--;
                    int i8 = this.f1508c[i4];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        androidx.recyclerview.widget.f_renamed.e_renamed eVarA2 = a_renamed(arrayDeque, i9, true);
                        if (eVarA2 == null) {
                            arrayDeque.add(new androidx.recyclerview.widget.f_renamed.e_renamed(i4, i2 - i3, false));
                        } else {
                            cVar.c_renamed((i2 - eVarA2.f1510b) - 1, i3);
                            if ((i8 & 4) != 0) {
                                cVar.a_renamed(i3, 1, this.d_renamed.c_renamed(i9, i4));
                            }
                        }
                    } else {
                        cVar.a_renamed(i3, 1);
                        i2++;
                    }
                }
                int i10 = cVar2.f1503a;
                int i11 = cVar2.f1504b;
                for (i_renamed = 0; i_renamed < cVar2.f1505c; i_renamed++) {
                    if ((this.f1507b[i10] & 15) == 2) {
                        cVar.a_renamed(i10, 1, this.d_renamed.c_renamed(i10, i11));
                    }
                    i10++;
                    i11++;
                }
                i3 = cVar2.f1503a;
                i4 = cVar2.f1504b;
            }
            cVar.a_renamed();
        }

        private static androidx.recyclerview.widget.f_renamed.e_renamed a_renamed(java.util.Collection<androidx.recyclerview.widget.f_renamed.e_renamed> collection, int i_renamed, boolean z_renamed) {
            androidx.recyclerview.widget.f_renamed.e_renamed next;
            java.util.Iterator<androidx.recyclerview.widget.f_renamed.e_renamed> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.f1509a == i_renamed && next.f1511c == z_renamed) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                androidx.recyclerview.widget.f_renamed.e_renamed next2 = it.next();
                if (z_renamed) {
                    next2.f1510b--;
                } else {
                    next2.f1510b++;
                }
            }
            return next;
        }
    }

    /* compiled from: DiffUtil.java */
    private static class e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1509a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1510b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f1511c;

        e_renamed(int i_renamed, int i2, boolean z_renamed) {
            this.f1509a = i_renamed;
            this.f1510b = i2;
            this.f1511c = z_renamed;
        }
    }

    /* compiled from: DiffUtil.java */
    static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final int[] f1501a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f1502b;

        b_renamed(int i_renamed) {
            this.f1501a = new int[i_renamed];
            this.f1502b = this.f1501a.length / 2;
        }

        int a_renamed(int i_renamed) {
            return this.f1501a[i_renamed + this.f1502b];
        }

        int[] a_renamed() {
            return this.f1501a;
        }

        void a_renamed(int i_renamed, int i2) {
            this.f1501a[i_renamed + this.f1502b] = i2;
        }
    }
}
