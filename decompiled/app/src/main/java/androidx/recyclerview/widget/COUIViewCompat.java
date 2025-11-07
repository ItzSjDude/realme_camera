package androidx.recyclerview.widget;

/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
class t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.recyclerview.widget.t_renamed.b_renamed f1555a;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.recyclerview.widget.t_renamed.a_renamed f1556b = new androidx.recyclerview.widget.t_renamed.a_renamed();

    /* compiled from: ViewBoundsCheck.java */
    interface b_renamed {
        int a_renamed();

        int a_renamed(android.view.View view);

        android.view.View a_renamed(int i_renamed);

        int b_renamed();

        int b_renamed(android.view.View view);
    }

    t_renamed(androidx.recyclerview.widget.t_renamed.b_renamed bVar) {
        this.f1555a = bVar;
    }

    /* compiled from: ViewBoundsCheck.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1557a = 0;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1558b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1559c;
        int d_renamed;
        int e_renamed;

        int a_renamed(int i_renamed, int i2) {
            if (i_renamed > i2) {
                return 1;
            }
            return i_renamed == i2 ? 2 : 4;
        }

        a_renamed() {
        }

        void a_renamed(int i_renamed, int i2, int i3, int i4) {
            this.f1558b = i_renamed;
            this.f1559c = i2;
            this.d_renamed = i3;
            this.e_renamed = i4;
        }

        void a_renamed(int i_renamed) {
            this.f1557a = i_renamed | this.f1557a;
        }

        void a_renamed() {
            this.f1557a = 0;
        }

        boolean b_renamed() {
            int i_renamed = this.f1557a;
            if ((i_renamed & 7) != 0 && (i_renamed & (a_renamed(this.d_renamed, this.f1558b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1557a;
            if ((i2 & 112) != 0 && (i2 & (a_renamed(this.d_renamed, this.f1559c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1557a;
            if ((i3 & 1792) != 0 && (i3 & (a_renamed(this.e_renamed, this.f1558b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1557a;
            return (i4 & 28672) == 0 || ((a_renamed(this.e_renamed, this.f1559c) << 12) & i4) != 0;
        }
    }

    android.view.View a_renamed(int i_renamed, int i2, int i3, int i4) {
        int iA = this.f1555a.a_renamed();
        int iB = this.f1555a.b_renamed();
        int i5 = i2 > i_renamed ? 1 : -1;
        android.view.View view = null;
        while (i_renamed != i2) {
            android.view.View viewA = this.f1555a.a_renamed(i_renamed);
            this.f1556b.a_renamed(iA, iB, this.f1555a.a_renamed(viewA), this.f1555a.b_renamed(viewA));
            if (i3 != 0) {
                this.f1556b.a_renamed();
                this.f1556b.a_renamed(i3);
                if (this.f1556b.b_renamed()) {
                    return viewA;
                }
            }
            if (i4 != 0) {
                this.f1556b.a_renamed();
                this.f1556b.a_renamed(i4);
                if (this.f1556b.b_renamed()) {
                    view = viewA;
                }
            }
            i_renamed += i5;
        }
        return view;
    }

    boolean a_renamed(android.view.View view, int i_renamed) {
        this.f1556b.a_renamed(this.f1555a.a_renamed(), this.f1555a.b_renamed(), this.f1555a.a_renamed(view), this.f1555a.b_renamed(view));
        if (i_renamed == 0) {
            return false;
        }
        this.f1556b.a_renamed();
        this.f1556b.a_renamed(i_renamed);
        return this.f1556b.b_renamed();
    }
}
