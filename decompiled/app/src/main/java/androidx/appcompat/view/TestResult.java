package androidx.appcompat.view;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.core.h_renamed.aa_renamed f345b;
    private android.view.animation.Interpolator d_renamed;
    private boolean e_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f346c = -1;
    private final androidx.core.h_renamed.ab_renamed f_renamed = new androidx.core.h_renamed.ab_renamed() { // from class: androidx.appcompat.view.h_renamed.1

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f348b = false;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f349c = 0;

        @Override // androidx.core.h_renamed.ab_renamed, androidx.core.h_renamed.aa_renamed
        public void a_renamed(android.view.View view) {
            if (this.f348b) {
                return;
            }
            this.f348b = true;
            if (androidx.appcompat.view.h_renamed.this.f345b != null) {
                androidx.appcompat.view.h_renamed.this.f345b.a_renamed(null);
            }
        }

        void a_renamed() {
            this.f349c = 0;
            this.f348b = false;
            androidx.appcompat.view.h_renamed.this.b_renamed();
        }

        @Override // androidx.core.h_renamed.ab_renamed, androidx.core.h_renamed.aa_renamed
        public void b_renamed(android.view.View view) {
            int i_renamed = this.f349c + 1;
            this.f349c = i_renamed;
            if (i_renamed == androidx.appcompat.view.h_renamed.this.f344a.size()) {
                if (androidx.appcompat.view.h_renamed.this.f345b != null) {
                    androidx.appcompat.view.h_renamed.this.f345b.b_renamed(null);
                }
                a_renamed();
            }
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.ArrayList<androidx.core.h_renamed.z_renamed> f344a = new java.util.ArrayList<>();

    public androidx.appcompat.view.h_renamed a_renamed(androidx.core.h_renamed.z_renamed zVar) {
        if (!this.e_renamed) {
            this.f344a.add(zVar);
        }
        return this;
    }

    public androidx.appcompat.view.h_renamed a_renamed(androidx.core.h_renamed.z_renamed zVar, androidx.core.h_renamed.z_renamed zVar2) {
        this.f344a.add(zVar);
        zVar2.b_renamed(zVar.a_renamed());
        this.f344a.add(zVar2);
        return this;
    }

    public void a_renamed() {
        if (this.e_renamed) {
            return;
        }
        java.util.Iterator<androidx.core.h_renamed.z_renamed> it = this.f344a.iterator();
        while (it.hasNext()) {
            androidx.core.h_renamed.z_renamed next = it.next();
            long j_renamed = this.f346c;
            if (j_renamed >= 0) {
                next.a_renamed(j_renamed);
            }
            android.view.animation.Interpolator interpolator = this.d_renamed;
            if (interpolator != null) {
                next.a_renamed(interpolator);
            }
            if (this.f345b != null) {
                next.a_renamed(this.f_renamed);
            }
            next.c_renamed();
        }
        this.e_renamed = true;
    }

    void b_renamed() {
        this.e_renamed = false;
    }

    public void c_renamed() {
        if (this.e_renamed) {
            java.util.Iterator<androidx.core.h_renamed.z_renamed> it = this.f344a.iterator();
            while (it.hasNext()) {
                it.next().b_renamed();
            }
            this.e_renamed = false;
        }
    }

    public androidx.appcompat.view.h_renamed a_renamed(long j_renamed) {
        if (!this.e_renamed) {
            this.f346c = j_renamed;
        }
        return this;
    }

    public androidx.appcompat.view.h_renamed a_renamed(android.view.animation.Interpolator interpolator) {
        if (!this.e_renamed) {
            this.d_renamed = interpolator;
        }
        return this;
    }

    public androidx.appcompat.view.h_renamed a_renamed(androidx.core.h_renamed.aa_renamed aaVar) {
        if (!this.e_renamed) {
            this.f345b = aaVar;
        }
        return this;
    }
}
