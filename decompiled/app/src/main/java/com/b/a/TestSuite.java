package com.b_renamed.a_renamed;

/* compiled from: RenderEngineFactory.java */
/* loaded from: classes.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f2354a = "i_renamed";

    public static com.b_renamed.a_renamed.h_renamed a_renamed(android.app.Activity activity, com.b_renamed.a_renamed.g_renamed gVar) {
        return new com.b_renamed.a_renamed.i_renamed.a_renamed(activity, gVar);
    }

    /* compiled from: RenderEngineFactory.java */
    static class a_renamed implements com.b_renamed.a_renamed.h_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.app.Activity f2356a;

        /* renamed from: b_renamed, reason: collision with root package name */
        com.b_renamed.a_renamed.g_renamed f2357b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.view.Surface f2358c;
        int d_renamed;
        int e_renamed;
        com.b_renamed.a_renamed.k_renamed f_renamed;
        com.b_renamed.a_renamed.f_renamed g_renamed;
        com.b_renamed.a_renamed.f_renamed h_renamed;

        a_renamed(android.app.Activity activity, com.b_renamed.a_renamed.g_renamed gVar) {
            this.f2356a = activity;
            this.f2357b = gVar;
            c_renamed();
        }

        @Override // com.b_renamed.a_renamed.h_renamed
        public com.b_renamed.a_renamed.h_renamed a_renamed(android.view.Surface surface, int i_renamed, int i2) {
            this.f2358c = surface;
            this.d_renamed = i_renamed;
            this.e_renamed = i2;
            return this;
        }

        @Override // com.b_renamed.a_renamed.h_renamed
        public com.b_renamed.a_renamed.h_renamed a_renamed(com.b_renamed.a_renamed.k_renamed kVar) {
            this.f_renamed = kVar;
            return this;
        }

        @Override // com.b_renamed.a_renamed.h_renamed
        public void a_renamed() {
            if (this.f2356a != null && this.f2357b != null) {
                com.b_renamed.a_renamed.c_renamed.a_renamed();
                com.b_renamed.a_renamed.c_renamed.f2337b = this.f2357b;
                com.b_renamed.a_renamed.c_renamed.a_renamed().a_renamed(this.h_renamed, this.f2358c, this.d_renamed, this.e_renamed, this.f_renamed);
                com.b_renamed.a_renamed.c_renamed.a_renamed().e_renamed();
                return;
            }
            throw new java.lang.RuntimeException("Not initialized");
        }

        @Override // com.b_renamed.a_renamed.h_renamed
        public com.b_renamed.a_renamed.a_renamed.j_renamed a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed dVar, boolean z_renamed, com.b_renamed.a_renamed.a_renamed.a_renamed aVar) {
            com.b_renamed.a_renamed.j_renamed jVarC;
            if (com.b_renamed.a_renamed.c_renamed.a_renamed() == null || (jVarC = com.b_renamed.a_renamed.c_renamed.a_renamed().c_renamed()) == null) {
                return null;
            }
            int i_renamed = com.b_renamed.a_renamed.i_renamed.SceneLoader_2.f2355a[dVar.ordinal()];
            if (i_renamed == 1 || i_renamed == 2 || i_renamed == 3 || i_renamed == 4) {
                if (aVar == null) {
                    return jVarC.a_renamed(dVar, z_renamed);
                }
                return jVarC.a_renamed(dVar, z_renamed, aVar);
            }
            com.b_renamed.a_renamed.b_renamed.a_renamed(com.b_renamed.a_renamed.i_renamed.f2354a, "Invalid animationID:" + dVar);
            return null;
        }

        @Override // com.b_renamed.a_renamed.h_renamed
        public void b_renamed() {
            com.b_renamed.a_renamed.c_renamed.a_renamed().f_renamed();
            this.f2356a = null;
            this.f2357b = null;
            this.f2358c = null;
            this.d_renamed = 0;
            this.e_renamed = 0;
            this.f_renamed = null;
            this.g_renamed = null;
            this.h_renamed = null;
            com.b_renamed.a_renamed.c_renamed.b_renamed();
        }

        private void c_renamed() {
            this.h_renamed = new com.b_renamed.a_renamed.f_renamed() { // from class: com.b_renamed.a_renamed.i_renamed.a_renamed.1
                @Override // com.b_renamed.a_renamed.f_renamed
                public android.app.Activity a_renamed() {
                    return com.b_renamed.a_renamed.i_renamed.a_renamed.this.g_renamed == null ? com.b_renamed.a_renamed.i_renamed.a_renamed.this.f2356a : com.b_renamed.a_renamed.i_renamed.a_renamed.this.g_renamed.a_renamed();
                }
            };
        }
    }

    /* compiled from: RenderEngineFactory.java */
    /* renamed from: com.b_renamed.a_renamed.i_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2355a = new int[com.b_renamed.a_renamed.a_renamed.d_renamed.values().length];

        static {
            try {
                f2355a[com.b_renamed.a_renamed.a_renamed.d_renamed.FixedGaze.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2355a[com.b_renamed.a_renamed.a_renamed.d_renamed.DollyZoom.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f2355a[com.b_renamed.a_renamed.a_renamed.d_renamed.Circle.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f2355a[com.b_renamed.a_renamed.a_renamed.d_renamed.Swing.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    static {
        java.lang.System.setProperty("java.protocol.handler.pkgs", "org.andresoviedo.util.android");
        java.net.URL.setURLStreamHandlerFactory(new org.andresoviedo.a_renamed.a_renamed.a_renamed());
    }
}
