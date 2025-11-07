package com.b_renamed.a_renamed;

/* compiled from: SceneLoader.java */
/* loaded from: classes.dex */
public class j_renamed implements org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static float[] f2360c = {1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final com.b_renamed.a_renamed.c_renamed f2361a;
    private org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed f_renamed;
    private long y_renamed;
    private java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> d_renamed = new java.util.ArrayList();
    private boolean e_renamed = false;
    private boolean g_renamed = true;
    private boolean h_renamed = false;
    private boolean i_renamed = false;
    private boolean j_renamed = false;
    private boolean k_renamed = false;
    private boolean l_renamed = true;
    private boolean m_renamed = true;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private boolean p_renamed = false;
    private boolean q_renamed = false;
    private boolean r_renamed = false;
    private boolean s_renamed = false;
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private boolean v_renamed = false;
    private org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed w_renamed = null;
    private final float[] x_renamed = {0.0f, 0.0f, 6.0f, 1.0f};
    private float z_renamed = -0.0094f;
    private float A_renamed = -6.8E-4f;
    private float B_renamed = -0.07f;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.util.Set<com.b_renamed.a_renamed.a_renamed.e_renamed> f2362b = new java.util.HashSet();

    private void a_renamed(java.lang.String str) {
    }

    private void r_renamed() {
    }

    public void a_renamed(float f_renamed, float f2) {
    }

    public void b_renamed(float f_renamed, float f2) {
    }

    public j_renamed(com.b_renamed.a_renamed.c_renamed cVar) {
        this.f2361a = cVar;
    }

    public void a_renamed() {
        this.f_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed(-0.0f, 0.0f, -5.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.42f, 0.42f, 0.42f, -0.42f);
        this.f_renamed.a_renamed(true);
        this.y_renamed = android.os.SystemClock.uptimeMillis();
        if (com.b_renamed.a_renamed.c_renamed.f2337b != null) {
            new org.andresoviedo.android_3d_model_engine.c_renamed.c_renamed(this.f2361a.f2338c, a_renamed(com.b_renamed.a_renamed.c_renamed.f2337b), this).execute(new java.lang.Void[0]);
        }
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed b_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar) {
        this.f2362b.add(eVar);
    }

    public void b_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar) {
        this.f2362b.remove(eVar);
    }

    public com.b_renamed.a_renamed.a_renamed.j_renamed a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed dVar, boolean z_renamed) {
        return a_renamed(dVar, z_renamed, null);
    }

    /* compiled from: SceneLoader.java */
    /* renamed from: com.b_renamed.a_renamed.j_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2363a = new int[com.b_renamed.a_renamed.a_renamed.d_renamed.values().length];

        static {
            try {
                f2363a[com.b_renamed.a_renamed.a_renamed.d_renamed.DollyZoom.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2363a[com.b_renamed.a_renamed.a_renamed.d_renamed.FixedGaze.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f2363a[com.b_renamed.a_renamed.a_renamed.d_renamed.Circle.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f2363a[com.b_renamed.a_renamed.a_renamed.d_renamed.Swing.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f2363a[com.b_renamed.a_renamed.a_renamed.d_renamed.None.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public com.b_renamed.a_renamed.a_renamed.j_renamed a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed dVar, boolean z_renamed, com.b_renamed.a_renamed.a_renamed.a_renamed aVar) {
        if (dVar == null) {
            return null;
        }
        int i_renamed = com.b_renamed.a_renamed.j_renamed.SceneLoader_2.f2363a[dVar.ordinal()];
        if (i_renamed == 1) {
            this.f_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed(-0.0f, 0.0f, -5.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.42f, 0.42f, 0.42f, -0.42f);
            if (aVar == null) {
                return new com.b_renamed.a_renamed.a_renamed.h_renamed(this.f_renamed, z_renamed);
            }
            return new com.b_renamed.a_renamed.a_renamed.h_renamed(this.f_renamed, z_renamed, aVar);
        }
        if (i_renamed == 2) {
            if (z_renamed) {
                this.f_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed(2.0f, -0.5f, -5.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.26f, 0.26f, 0.26f, -0.26f);
            } else {
                this.f_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed(0.5f, 2.0f, -5.0f, 0.0f, -0.0f, 3.0f, 0.0f, 1.0f, 0.0f, -0.26f, 0.26f, 0.26f, -0.26f);
            }
            if (aVar == null) {
                return new com.b_renamed.a_renamed.a_renamed.i_renamed(this.f_renamed, z_renamed);
            }
            return new com.b_renamed.a_renamed.a_renamed.i_renamed(this.f_renamed, z_renamed, aVar);
        }
        if (i_renamed == 3) {
            this.f_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed(-0.0f, 0.0f, -7.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.26f, 0.26f, 0.26f, -0.26f);
            if (aVar == null) {
                return new com.b_renamed.a_renamed.a_renamed.g_renamed(this.f_renamed, z_renamed);
            }
            return new com.b_renamed.a_renamed.a_renamed.g_renamed(this.f_renamed, z_renamed, aVar);
        }
        if (i_renamed == 4) {
            this.f_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed(-0.0f, 0.0f, -7.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.3f, 0.3f, 0.3f, -0.3f);
            if (aVar == null) {
                return new com.b_renamed.a_renamed.a_renamed.k_renamed(this.f_renamed, z_renamed);
            }
            return new com.b_renamed.a_renamed.a_renamed.k_renamed(this.f_renamed, z_renamed, aVar);
        }
        throw new java.lang.RuntimeException("Invalid AnimID:" + dVar);
    }

    public boolean c_renamed() {
        q_renamed();
        this.f_renamed.b_renamed();
        if (!this.d_renamed.isEmpty()) {
            java.util.Iterator<com.b_renamed.a_renamed.a_renamed.e_renamed> it = this.f2362b.iterator();
            while (it.hasNext()) {
                if (it.next().b_renamed()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void q_renamed() {
        if (this.n_renamed) {
            long jUptimeMillis = android.os.SystemClock.uptimeMillis() % com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        }
    }

    synchronized void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.d_renamed);
        arrayList.add(gVar);
        this.d_renamed = arrayList;
        r_renamed();
    }

    public synchronized java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> d_renamed() {
        return this.d_renamed;
    }

    public boolean e_renamed() {
        return this.h_renamed;
    }

    public boolean f_renamed() {
        return this.i_renamed;
    }

    public boolean g_renamed() {
        return this.p_renamed;
    }

    public boolean h_renamed() {
        return this.v_renamed;
    }

    public boolean i_renamed() {
        return this.l_renamed;
    }

    public boolean j_renamed() {
        return this.m_renamed;
    }

    public boolean k_renamed() {
        return this.o_renamed;
    }

    public boolean l_renamed() {
        return this.r_renamed;
    }

    public boolean m_renamed() {
        return this.t_renamed;
    }

    public boolean n_renamed() {
        return this.u_renamed;
    }

    public boolean o_renamed() {
        return this.g_renamed;
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed
    public void p_renamed() {
        org.andresoviedo.a_renamed.a_renamed.b_renamed.a_renamed(this.f2361a.f2338c);
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed
    public void a_renamed(java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> list) {
        java.util.Iterator<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().q_renamed() == null) {
                com.b_renamed.a_renamed.b_renamed.a_renamed("LoaderTask", "no texture loaded... ");
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar : list) {
            a_renamed(gVar);
            arrayList.addAll(gVar.M_renamed());
        }
        if (!arrayList.isEmpty()) {
            a_renamed(arrayList.toString());
        }
        a_renamed("Build complete (" + ((android.os.SystemClock.uptimeMillis() - this.y_renamed) + " ms") + ")");
        org.andresoviedo.a_renamed.a_renamed.b_renamed.a_renamed((android.content.Context) null);
        if (this.f2361a.d_renamed() != null) {
            this.f2361a.d_renamed().c_renamed();
        }
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed
    public void a_renamed(java.lang.Exception exc) {
        com.b_renamed.a_renamed.b_renamed.a_renamed("SceneLoader", exc.getMessage(), exc);
        a_renamed("There was a_renamed problem building the model: " + exc.getMessage());
        org.andresoviedo.a_renamed.a_renamed.b_renamed.a_renamed((android.content.Context) null);
    }

    private com.b_renamed.a_renamed.g_renamed[] a_renamed(com.b_renamed.a_renamed.g_renamed gVar) {
        com.b_renamed.a_renamed.b_renamed.d_renamed("SceneLoader", "faces of_renamed input model:" + gVar.f2353c.length);
        int i_renamed = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < gVar.f2353c.length; i3 += 3) {
            int i4 = gVar.f2353c[i3];
            int i5 = gVar.f2353c[i3 + 1];
            int i6 = gVar.f2353c[i3 + 2];
            if ((gVar.f2352b[(i4 * 4) + 3] & 255) == 255 && (gVar.f2352b[(i5 * 4) + 3] & 255) == 255 && (gVar.f2352b[(i6 * 4) + 3] & 255) == 255) {
                i2++;
            } else {
                i_renamed++;
            }
        }
        if (i_renamed == 0 || i2 == 0) {
            com.b_renamed.a_renamed.b_renamed.d_renamed("SceneLoader", "only one modelfaces of_renamed front model:" + i_renamed + "faces of_renamed back model:" + i2);
            return new com.b_renamed.a_renamed.g_renamed[]{gVar};
        }
        com.b_renamed.a_renamed.g_renamed gVar2 = new com.b_renamed.a_renamed.g_renamed(gVar);
        com.b_renamed.a_renamed.g_renamed gVar3 = new com.b_renamed.a_renamed.g_renamed(gVar);
        byte[] bArr = gVar.h_renamed;
        gVar2.h_renamed = bArr;
        gVar3.h_renamed = bArr;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("faces of_renamed front model:");
        int i7 = i_renamed * 3;
        sb.append(i7);
        sb.append("faces of_renamed back model:");
        int i8 = i2 * 3;
        sb.append(i8);
        com.b_renamed.a_renamed.b_renamed.d_renamed("SceneLoader", sb.toString());
        gVar3.f2353c = new int[i7];
        gVar2.f2353c = new int[i8];
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < gVar.f2353c.length; i11 += 3) {
            int i12 = gVar.f2353c[i11];
            int i13 = gVar.f2353c[i11 + 1];
            int i14 = gVar.f2353c[i11 + 2];
            if ((gVar.f2352b[(i12 * 4) + 3] & 255) == 255 && (gVar.f2352b[(i13 * 4) + 3] & 255) == 255 && (gVar.f2352b[(i14 * 4) + 3] & 255) == 255) {
                int i15 = i10 + 1;
                gVar2.f2353c[i10] = i12;
                int i16 = i15 + 1;
                gVar2.f2353c[i15] = i13;
                gVar2.f2353c[i16] = i14;
                i10 = i16 + 1;
            } else {
                int i17 = i9 + 1;
                gVar3.f2353c[i9] = i12;
                int i18 = i17 + 1;
                gVar3.f2353c[i17] = i13;
                gVar3.f2353c[i18] = i14;
                i9 = i18 + 1;
            }
        }
        return new com.b_renamed.a_renamed.g_renamed[]{gVar2, gVar3};
    }
}
