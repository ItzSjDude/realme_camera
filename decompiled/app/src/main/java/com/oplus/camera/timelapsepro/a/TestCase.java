package com.oplus.camera.timelapsepro.a_renamed;

/* compiled from: ProParameter.java */
/* loaded from: classes2.dex */
public abstract class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final android.content.res.Resources f5642a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected final int f5643b;
    private java.lang.String f_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed.b_renamed l_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed.a_renamed m_renamed;
    private long g_renamed = 0;
    protected int e_renamed = 0;
    private int h_renamed = 0;
    private boolean i_renamed = false;
    private boolean j_renamed = true;
    private boolean k_renamed = true;
    private long n_renamed = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected java.util.List<java.lang.String> f5644c = new java.util.ArrayList();
    protected java.util.List<java.lang.String> d_renamed = new java.util.ArrayList();

    /* compiled from: ProParameter.java */
    public interface a_renamed {
        void a_renamed();
    }

    /* compiled from: ProParameter.java */
    public interface b_renamed {
        void onValueChange(int i_renamed, int i2);
    }

    public void a_renamed(java.lang.String str) {
    }

    public boolean a_renamed() {
        return true;
    }

    public abstract int c_renamed();

    public abstract java.lang.String d_renamed();

    public abstract java.lang.String e_renamed();

    public int l_renamed() {
        return -1;
    }

    public boolean m_renamed() {
        return false;
    }

    public e_renamed(android.app.Activity activity, java.lang.String str, int i_renamed) {
        this.f_renamed = str;
        this.f5643b = i_renamed;
        this.f5642a = activity.getResources();
    }

    public java.lang.String f_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }

    public boolean g_renamed() {
        return this.j_renamed;
    }

    public boolean h_renamed() {
        return this.k_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
        d_renamed(false);
    }

    public boolean i_renamed() {
        return this.i_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.i_renamed = z_renamed;
        d_renamed(false);
    }

    public java.util.List<java.lang.String> j_renamed() {
        return this.f5644c;
    }

    public java.util.List<java.lang.String> k_renamed() {
        return this.d_renamed;
    }

    public int n_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(int i_renamed) {
        if (!g_renamed() || !i_renamed() || this.l_renamed == null || 100 >= java.lang.System.currentTimeMillis() - this.g_renamed || this.h_renamed == i_renamed) {
            return;
        }
        this.g_renamed = java.lang.System.currentTimeMillis();
        this.h_renamed = i_renamed;
        this.l_renamed.onValueChange(this.f5643b, i_renamed);
    }

    public void b_renamed() {
        a_renamed(true);
    }

    public java.util.List<? extends com.oplus.camera.timelapsepro.a_renamed.g_renamed> o_renamed() {
        java.util.List<java.lang.String> list = this.d_renamed;
        if (list == null || list.size() <= 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (final java.lang.String str : this.d_renamed) {
            arrayList.add(new com.oplus.camera.timelapsepro.a_renamed.g_renamed() { // from class: com.oplus.camera.timelapsepro.a_renamed.e_renamed.1
                @Override // com.oplus.camera.timelapsepro.a_renamed.g_renamed
                public java.lang.String f__renamed() {
                    if (com.oplus.camera.timelapsepro.a_renamed.e_renamed.this.b_renamed(str)) {
                        return str.substring(0, r2.length() - 1);
                    }
                    return str;
                }

                @Override // com.oplus.camera.timelapsepro.a_renamed.g_renamed
                public java.lang.String g__renamed() {
                    if (com.oplus.camera.timelapsepro.a_renamed.e_renamed.this.b_renamed(str)) {
                        return str.substring(r2.length() - 1);
                    }
                    return super.g__renamed();
                }

                @Override // com.oplus.camera.timelapsepro.a_renamed.g_renamed
                public java.lang.String c_renamed() {
                    return str;
                }
            });
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b_renamed(java.lang.String str) {
        return !java.lang.Character.isDigit(str.charAt(str.length() - 1));
    }

    protected void p_renamed() {
        d_renamed(true);
    }

    public void d_renamed(boolean z_renamed) {
        if (this.m_renamed != null) {
            if (z_renamed) {
                if (100 > java.lang.System.currentTimeMillis() - this.n_renamed) {
                    return;
                } else {
                    this.n_renamed = java.lang.System.currentTimeMillis();
                }
            }
            this.m_renamed.a_renamed();
        }
    }

    public void a_renamed(com.oplus.camera.timelapsepro.a_renamed.e_renamed.b_renamed bVar) {
        com.oplus.camera.e_renamed.a_renamed("ProParameter", "setValueChangedCallback, " + getClass().getSimpleName() + " callback: " + bVar);
        this.l_renamed = bVar;
    }

    public void a_renamed(com.oplus.camera.timelapsepro.a_renamed.e_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("ProParameter", "setOnUpdateCallback, " + getClass().getSimpleName() + " onUpdateCallback: " + aVar);
        this.m_renamed = aVar;
    }

    public java.lang.String toString() {
        return "ProParameter{mPreKey='" + this.f_renamed + "', mValueList=" + this.f5644c + ", mNameList=" + this.d_renamed + ", mCurrentPosition=" + this.e_renamed + ", mLastPosition=" + this.h_renamed + ", mbSelect=" + this.i_renamed + ", mbAuto=" + this.j_renamed + '}';
    }
}
