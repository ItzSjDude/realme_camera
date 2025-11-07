package androidx.recyclerview.widget;

/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
final class a_renamed implements androidx.recyclerview.widget.m_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.ArrayList<androidx.recyclerview.widget.a_renamed.b_renamed> f1455a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final java.util.ArrayList<androidx.recyclerview.widget.a_renamed.b_renamed> f1456b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final androidx.recyclerview.widget.a_renamed.AdapterHelper_2 f1457c;
    java.lang.Runnable d_renamed;
    final boolean e_renamed;
    final androidx.recyclerview.widget.m_renamed f_renamed;
    private androidx.core.g_renamed.e_renamed.a_renamed<androidx.recyclerview.widget.a_renamed.b_renamed> g_renamed;
    private int h_renamed;

    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a_renamed$a_renamed, reason: collision with other inner class name */
    interface AdapterHelper_2 {
        androidx.recyclerview.widget.RecyclerView.w_renamed a_renamed(int i_renamed);

        void a_renamed(int i_renamed, int i2);

        void a_renamed(int i_renamed, int i2, java.lang.Object obj);

        void a_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar);

        void b_renamed(int i_renamed, int i2);

        void b_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar);

        void c_renamed(int i_renamed, int i2);

        void d_renamed(int i_renamed, int i2);
    }

    a_renamed(androidx.recyclerview.widget.a_renamed.AdapterHelper_2 interfaceC0037a) {
        this(interfaceC0037a, false);
    }

    a_renamed(androidx.recyclerview.widget.a_renamed.AdapterHelper_2 interfaceC0037a, boolean z_renamed) {
        this.g_renamed = new androidx.core.g_renamed.e_renamed.b_renamed(30);
        this.f1455a = new java.util.ArrayList<>();
        this.f1456b = new java.util.ArrayList<>();
        this.h_renamed = 0;
        this.f1457c = interfaceC0037a;
        this.e_renamed = z_renamed;
        this.f_renamed = new androidx.recyclerview.widget.m_renamed(this);
    }

    void a_renamed() {
        a_renamed(this.f1455a);
        a_renamed(this.f1456b);
        this.h_renamed = 0;
    }

    void b_renamed() {
        this.f_renamed.a_renamed(this.f1455a);
        int size = this.f1455a.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVar = this.f1455a.get(i_renamed);
            int i2 = bVar.f1458a;
            if (i2 == 1) {
                f_renamed(bVar);
            } else if (i2 == 2) {
                c_renamed(bVar);
            } else if (i2 == 4) {
                d_renamed(bVar);
            } else if (i2 == 8) {
                b_renamed(bVar);
            }
            java.lang.Runnable runnable = this.d_renamed;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1455a.clear();
    }

    void c_renamed() {
        int size = this.f1456b.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1457c.b_renamed(this.f1456b.get(i_renamed));
        }
        a_renamed(this.f1456b);
        this.h_renamed = 0;
    }

    private void b_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
        g_renamed(bVar);
    }

    private void c_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
        boolean z_renamed;
        boolean z2;
        int i_renamed = bVar.f1459b;
        int i2 = bVar.f1459b + bVar.d_renamed;
        int i3 = bVar.f1459b;
        boolean z3 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f1457c.a_renamed(i3) != null || d_renamed(i3)) {
                if (z3) {
                    z_renamed = false;
                } else {
                    e_renamed(a_renamed(2, i_renamed, i4, null));
                    z_renamed = true;
                }
                z2 = true;
            } else {
                if (z3) {
                    g_renamed(a_renamed(2, i_renamed, i4, null));
                    z_renamed = true;
                } else {
                    z_renamed = false;
                }
                z2 = false;
            }
            if (z_renamed) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            z3 = z2;
        }
        if (i4 != bVar.d_renamed) {
            a_renamed(bVar);
            bVar = a_renamed(2, i_renamed, i4, null);
        }
        if (!z3) {
            e_renamed(bVar);
        } else {
            g_renamed(bVar);
        }
    }

    private void d_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
        int i_renamed = bVar.f1459b;
        int i2 = bVar.f1459b + bVar.d_renamed;
        boolean z_renamed = -1;
        int i3 = i_renamed;
        int i4 = 0;
        for (int i5 = bVar.f1459b; i5 < i2; i5++) {
            if (this.f1457c.a_renamed(i5) != null || d_renamed(i5)) {
                if (!z_renamed) {
                    e_renamed(a_renamed(4, i3, i4, bVar.f1460c));
                    i3 = i5;
                    i4 = 0;
                }
                z_renamed = true;
            } else {
                if (z_renamed) {
                    g_renamed(a_renamed(4, i3, i4, bVar.f1460c));
                    i3 = i5;
                    i4 = 0;
                }
                z_renamed = false;
            }
            i4++;
        }
        if (i4 != bVar.d_renamed) {
            java.lang.Object obj = bVar.f1460c;
            a_renamed(bVar);
            bVar = a_renamed(4, i3, i4, obj);
        }
        if (!z_renamed) {
            e_renamed(bVar);
        } else {
            g_renamed(bVar);
        }
    }

    private void e_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
        int i_renamed;
        if (bVar.f1458a == 1 || bVar.f1458a == 8) {
            throw new java.lang.IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iD = d_renamed(bVar.f1459b, bVar.f1458a);
        int i2 = bVar.f1459b;
        int i3 = bVar.f1458a;
        if (i3 == 2) {
            i_renamed = 0;
        } else {
            if (i3 != 4) {
                throw new java.lang.IllegalArgumentException("op should be_renamed remove or update." + bVar);
            }
            i_renamed = 1;
        }
        int i4 = iD;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.d_renamed; i7++) {
            int iD2 = d_renamed(bVar.f1459b + (i_renamed * i7), bVar.f1458a);
            int i8 = bVar.f1458a;
            if (i8 == 2 ? iD2 == i4 : i8 == 4 && iD2 == i4 + 1) {
                i6++;
            } else {
                androidx.recyclerview.widget.a_renamed.b_renamed bVarA = a_renamed(bVar.f1458a, i4, i6, bVar.f1460c);
                a_renamed(bVarA, i5);
                a_renamed(bVarA);
                if (bVar.f1458a == 4) {
                    i5 += i6;
                }
                i6 = 1;
                i4 = iD2;
            }
        }
        java.lang.Object obj = bVar.f1460c;
        a_renamed(bVar);
        if (i6 > 0) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVarA2 = a_renamed(bVar.f1458a, i4, i6, obj);
            a_renamed(bVarA2, i5);
            a_renamed(bVarA2);
        }
    }

    void a_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar, int i_renamed) {
        this.f1457c.a_renamed(bVar);
        int i2 = bVar.f1458a;
        if (i2 == 2) {
            this.f1457c.a_renamed(i_renamed, bVar.d_renamed);
        } else {
            if (i2 == 4) {
                this.f1457c.a_renamed(i_renamed, bVar.d_renamed, bVar.f1460c);
                return;
            }
            throw new java.lang.IllegalArgumentException("only remove and update ops can be_renamed dispatched in_renamed first pass");
        }
    }

    private int d_renamed(int i_renamed, int i2) {
        int i3;
        int i4;
        for (int size = this.f1456b.size() - 1; size >= 0; size--) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVar = this.f1456b.get(size);
            if (bVar.f1458a == 8) {
                if (bVar.f1459b < bVar.d_renamed) {
                    i3 = bVar.f1459b;
                    i4 = bVar.d_renamed;
                } else {
                    i3 = bVar.d_renamed;
                    i4 = bVar.f1459b;
                }
                if (i_renamed >= i3 && i_renamed <= i4) {
                    if (i3 == bVar.f1459b) {
                        if (i2 == 1) {
                            bVar.d_renamed++;
                        } else if (i2 == 2) {
                            bVar.d_renamed--;
                        }
                        i_renamed++;
                    } else {
                        if (i2 == 1) {
                            bVar.f1459b++;
                        } else if (i2 == 2) {
                            bVar.f1459b--;
                        }
                        i_renamed--;
                    }
                } else if (i_renamed < bVar.f1459b) {
                    if (i2 == 1) {
                        bVar.f1459b++;
                        bVar.d_renamed++;
                    } else if (i2 == 2) {
                        bVar.f1459b--;
                        bVar.d_renamed--;
                    }
                }
            } else if (bVar.f1459b <= i_renamed) {
                if (bVar.f1458a == 1) {
                    i_renamed -= bVar.d_renamed;
                } else if (bVar.f1458a == 2) {
                    i_renamed += bVar.d_renamed;
                }
            } else if (i2 == 1) {
                bVar.f1459b++;
            } else if (i2 == 2) {
                bVar.f1459b--;
            }
        }
        for (int size2 = this.f1456b.size() - 1; size2 >= 0; size2--) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVar2 = this.f1456b.get(size2);
            if (bVar2.f1458a == 8) {
                if (bVar2.d_renamed == bVar2.f1459b || bVar2.d_renamed < 0) {
                    this.f1456b.remove(size2);
                    a_renamed(bVar2);
                }
            } else if (bVar2.d_renamed <= 0) {
                this.f1456b.remove(size2);
                a_renamed(bVar2);
            }
        }
        return i_renamed;
    }

    private boolean d_renamed(int i_renamed) {
        int size = this.f1456b.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVar = this.f1456b.get(i2);
            if (bVar.f1458a == 8) {
                if (a_renamed(bVar.d_renamed, i2 + 1) == i_renamed) {
                    return true;
                }
            } else if (bVar.f1458a == 1) {
                int i3 = bVar.f1459b + bVar.d_renamed;
                for (int i4 = bVar.f1459b; i4 < i3; i4++) {
                    if (a_renamed(i4, i2 + 1) == i_renamed) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void f_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
        g_renamed(bVar);
    }

    private void g_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
        this.f1456b.add(bVar);
        int i_renamed = bVar.f1458a;
        if (i_renamed == 1) {
            this.f1457c.c_renamed(bVar.f1459b, bVar.d_renamed);
            return;
        }
        if (i_renamed == 2) {
            this.f1457c.b_renamed(bVar.f1459b, bVar.d_renamed);
            return;
        }
        if (i_renamed == 4) {
            this.f1457c.a_renamed(bVar.f1459b, bVar.d_renamed, bVar.f1460c);
        } else {
            if (i_renamed == 8) {
                this.f1457c.d_renamed(bVar.f1459b, bVar.d_renamed);
                return;
            }
            throw new java.lang.IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    boolean d_renamed() {
        return this.f1455a.size() > 0;
    }

    boolean a_renamed(int i_renamed) {
        return (this.h_renamed & i_renamed) != 0;
    }

    int b_renamed(int i_renamed) {
        return a_renamed(i_renamed, 0);
    }

    int a_renamed(int i_renamed, int i2) {
        int size = this.f1456b.size();
        while (i2 < size) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVar = this.f1456b.get(i2);
            if (bVar.f1458a == 8) {
                if (bVar.f1459b == i_renamed) {
                    i_renamed = bVar.d_renamed;
                } else {
                    if (bVar.f1459b < i_renamed) {
                        i_renamed--;
                    }
                    if (bVar.d_renamed <= i_renamed) {
                        i_renamed++;
                    }
                }
            } else if (bVar.f1459b > i_renamed) {
                continue;
            } else if (bVar.f1458a == 2) {
                if (i_renamed < bVar.f1459b + bVar.d_renamed) {
                    return -1;
                }
                i_renamed -= bVar.d_renamed;
            } else if (bVar.f1458a == 1) {
                i_renamed += bVar.d_renamed;
            }
            i2++;
        }
        return i_renamed;
    }

    boolean a_renamed(int i_renamed, int i2, java.lang.Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f1455a.add(a_renamed(4, i_renamed, i2, obj));
        this.h_renamed |= 4;
        return this.f1455a.size() == 1;
    }

    boolean b_renamed(int i_renamed, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1455a.add(a_renamed(1, i_renamed, i2, null));
        this.h_renamed |= 1;
        return this.f1455a.size() == 1;
    }

    boolean c_renamed(int i_renamed, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1455a.add(a_renamed(2, i_renamed, i2, null));
        this.h_renamed |= 2;
        return this.f1455a.size() == 1;
    }

    boolean a_renamed(int i_renamed, int i2, int i3) {
        if (i_renamed == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new java.lang.IllegalArgumentException("Moving more than 1 item is_renamed not supported yet");
        }
        this.f1455a.add(a_renamed(8, i_renamed, i2, null));
        this.h_renamed |= 8;
        return this.f1455a.size() == 1;
    }

    void e_renamed() {
        c_renamed();
        int size = this.f1455a.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVar = this.f1455a.get(i_renamed);
            int i2 = bVar.f1458a;
            if (i2 == 1) {
                this.f1457c.b_renamed(bVar);
                this.f1457c.c_renamed(bVar.f1459b, bVar.d_renamed);
            } else if (i2 == 2) {
                this.f1457c.b_renamed(bVar);
                this.f1457c.a_renamed(bVar.f1459b, bVar.d_renamed);
            } else if (i2 == 4) {
                this.f1457c.b_renamed(bVar);
                this.f1457c.a_renamed(bVar.f1459b, bVar.d_renamed, bVar.f1460c);
            } else if (i2 == 8) {
                this.f1457c.b_renamed(bVar);
                this.f1457c.d_renamed(bVar.f1459b, bVar.d_renamed);
            }
            java.lang.Runnable runnable = this.d_renamed;
            if (runnable != null) {
                runnable.run();
            }
        }
        a_renamed(this.f1455a);
        this.h_renamed = 0;
    }

    public int c_renamed(int i_renamed) {
        int size = this.f1455a.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.recyclerview.widget.a_renamed.b_renamed bVar = this.f1455a.get(i2);
            int i3 = bVar.f1458a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (bVar.f1459b == i_renamed) {
                            i_renamed = bVar.d_renamed;
                        } else {
                            if (bVar.f1459b < i_renamed) {
                                i_renamed--;
                            }
                            if (bVar.d_renamed <= i_renamed) {
                                i_renamed++;
                            }
                        }
                    }
                } else if (bVar.f1459b > i_renamed) {
                    continue;
                } else {
                    if (bVar.f1459b + bVar.d_renamed > i_renamed) {
                        return -1;
                    }
                    i_renamed -= bVar.d_renamed;
                }
            } else if (bVar.f1459b <= i_renamed) {
                i_renamed += bVar.d_renamed;
            }
        }
        return i_renamed;
    }

    boolean f_renamed() {
        return (this.f1456b.isEmpty() || this.f1455a.isEmpty()) ? false : true;
    }

    /* compiled from: AdapterHelper.java */
    static final class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1458a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1459b;

        /* renamed from: c_renamed, reason: collision with root package name */
        java.lang.Object f1460c;
        int d_renamed;

        b_renamed(int i_renamed, int i2, int i3, java.lang.Object obj) {
            this.f1458a = i_renamed;
            this.f1459b = i2;
            this.d_renamed = i3;
            this.f1460c = obj;
        }

        java.lang.String a_renamed() {
            int i_renamed = this.f1458a;
            return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 4 ? i_renamed != 8 ? "??" : "mv" : "up_renamed" : "rm" : "add";
        }

        public java.lang.String toString() {
            return java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + "[" + a_renamed() + ",s_renamed:" + this.f1459b + "c_renamed:" + this.d_renamed + ",p_renamed:" + this.f1460c + "]";
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.recyclerview.widget.a_renamed.b_renamed)) {
                return false;
            }
            androidx.recyclerview.widget.a_renamed.b_renamed bVar = (androidx.recyclerview.widget.a_renamed.b_renamed) obj;
            int i_renamed = this.f1458a;
            if (i_renamed != bVar.f1458a) {
                return false;
            }
            if (i_renamed == 8 && java.lang.Math.abs(this.d_renamed - this.f1459b) == 1 && this.d_renamed == bVar.f1459b && this.f1459b == bVar.d_renamed) {
                return true;
            }
            if (this.d_renamed != bVar.d_renamed || this.f1459b != bVar.f1459b) {
                return false;
            }
            java.lang.Object obj2 = this.f1460c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1460c)) {
                    return false;
                }
            } else if (bVar.f1460c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1458a * 31) + this.f1459b) * 31) + this.d_renamed;
        }
    }

    @Override // androidx.recyclerview.widget.m_renamed.a_renamed
    public androidx.recyclerview.widget.a_renamed.b_renamed a_renamed(int i_renamed, int i2, int i3, java.lang.Object obj) {
        androidx.recyclerview.widget.a_renamed.b_renamed bVarA = this.g_renamed.a_renamed();
        if (bVarA == null) {
            return new androidx.recyclerview.widget.a_renamed.b_renamed(i_renamed, i2, i3, obj);
        }
        bVarA.f1458a = i_renamed;
        bVarA.f1459b = i2;
        bVarA.d_renamed = i3;
        bVarA.f1460c = obj;
        return bVarA;
    }

    @Override // androidx.recyclerview.widget.m_renamed.a_renamed
    public void a_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
        if (this.e_renamed) {
            return;
        }
        bVar.f1460c = null;
        this.g_renamed.a_renamed(bVar);
    }

    void a_renamed(java.util.List<androidx.recyclerview.widget.a_renamed.b_renamed> list) {
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            a_renamed(list.get(i_renamed));
        }
        list.clear();
    }
}
