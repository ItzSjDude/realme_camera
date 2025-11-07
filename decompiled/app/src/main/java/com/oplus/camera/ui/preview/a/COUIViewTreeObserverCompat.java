package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: PreviewEffectProcessImpl.java */
/* loaded from: classes2.dex */
public class u_renamed implements com.oplus.camera.ui.preview.a_renamed.t_renamed {
    private float[] g_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed k_renamed;
    private java.util.HashMap<java.lang.Integer, com.oplus.camera.ui.preview.a_renamed.y_renamed> l_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private volatile boolean f6953a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private volatile boolean f6954b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private volatile boolean f6955c = false;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private float[] f_renamed = null;
    private com.oplus.camera.gl_renamed.GLRootView h_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.t_renamed.a_renamed i_renamed = null;
    private com.oplus.camera.gl_renamed.t_renamed j_renamed = null;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> m_renamed = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.List<java.lang.Long> n_renamed = new java.util.ArrayList();
    private com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed o_renamed = new com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.1
        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public void a_renamed(java.lang.String str) {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed != null) {
                com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.b_renamed(str);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public void a_renamed() {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed != null) {
                com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.b_renamed();
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public android.graphics.Rect[] b_renamed() {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed != null) {
                return com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.a_renamed();
            }
            return null;
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public int a_renamed(int i_renamed, int i2) {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed != null) {
                return com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.a_renamed(i_renamed, i2);
            }
            return 0;
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public com.oplus.camera.u_renamed.a_renamed a_renamed(int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed, long j_renamed) {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed == null) {
                return null;
            }
            com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.a_renamed(i_renamed, i2, i3, i4, i5, z_renamed, j_renamed);
            return null;
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed != null) {
                com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.a_renamed(aVar);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3) {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed != null) {
                com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.a_renamed(i_renamed, i2, z_renamed, z2, z3, z4, z5, z6, i3);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed != null) {
                com.oplus.camera.ui.preview.a_renamed.u_renamed.this.i_renamed.a_renamed(i_renamed);
            }
        }
    };

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4) {
        return false;
    }

    public u_renamed(android.content.Context context) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVarA;
        int i_renamed = 0;
        this.g_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.l_renamed = new java.util.HashMap<>();
        while (true) {
            int i2 = (1 << i_renamed) & 4095;
            if (i2 != 0 && (yVarA = com.oplus.camera.ui.preview.a_renamed.z_renamed.a_renamed(context.getApplicationContext(), i2)) != null) {
                yVarA.a_renamed(this.o_renamed);
                this.l_renamed.put(java.lang.Integer.valueOf(i2), yVarA);
            }
            int i3 = i_renamed + 1;
            if ((4095 >> i_renamed) == 0) {
                this.k_renamed = new com.oplus.camera.ui.preview.a_renamed.aa_renamed();
                android.renderscript.Matrix4f matrix4f = new android.renderscript.Matrix4f();
                matrix4f.scale(1.0f, -1.0f, 1.0f);
                matrix4f.translate(0.0f, -1.0f, 0.0f);
                this.g_renamed = matrix4f.getArray();
                return;
            }
            i_renamed = i3;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed() {
        this.n_renamed.clear();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.t_renamed.a_renamed aVar) {
        this.i_renamed = aVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.GLRootView gLRootView) {
        this.h_renamed = gLRootView;
        java.util.Iterator<com.oplus.camera.ui.preview.a_renamed.y_renamed> it = this.l_renamed.values().iterator();
        while (it.hasNext()) {
            it.next().a_renamed(gLRootView);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.t_renamed tVar) {
        this.j_renamed = tVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(boolean z_renamed) {
        synchronized (this) {
            this.f6953a = z_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed aVar) {
        ((com.oplus.camera.ui.preview.a_renamed.l_renamed) this.l_renamed.get(2)).a_renamed(aVar);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(java.lang.String str, int i_renamed) {
        java.util.Iterator<com.oplus.camera.ui.preview.a_renamed.y_renamed> it = this.l_renamed.values().iterator();
        while (it.hasNext()) {
            it.next().a_renamed(str, i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed() {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.preview.a_renamed.u_renamed uVar = com.oplus.camera.ui.preview.a_renamed.u_renamed.this;
                    uVar.m_renamed(uVar.k_renamed());
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.preview.a_renamed.u_renamed uVar = com.oplus.camera.ui.preview.a_renamed.u_renamed.this;
                    uVar.m_renamed(uVar.k_renamed());
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void g_renamed() {
        this.l_renamed.get(8).c_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed(final int i_renamed) {
        c_renamed(this.d_renamed, this.e_renamed);
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.4
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.preview.a_renamed.u_renamed.this.m_renamed(i_renamed);
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void c_renamed(int i_renamed) {
        final int iK = k_renamed();
        com.oplus.camera.e_renamed.a_renamed("PreviewEffectProcessImpl", "destroyEngine, type: " + i_renamed);
        final int i2 = 16;
        final int i3 = 0;
        if (i_renamed == 0) {
            i2 = 1463;
        } else if (i_renamed == 1) {
            i3 = 16;
            i2 = 1430;
        } else if (i_renamed != 2) {
            i2 = 0;
        }
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.5
                @Override // java.lang.Runnable
                public void run() {
                    for (java.util.Map.Entry entry : com.oplus.camera.ui.preview.a_renamed.u_renamed.this.l_renamed.entrySet()) {
                        if ((i2 & ((java.lang.Integer) entry.getKey()).intValue()) != 0 && ((i3 & ((java.lang.Integer) entry.getKey()).intValue()) == 0 || (i3 & iK) != 0)) {
                            ((com.oplus.camera.ui.preview.a_renamed.y_renamed) entry.getValue()).e_renamed();
                        }
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, int i5) {
        boolean zBooleanValue = this.m_renamed.containsKey(2) ? this.m_renamed.get(2).booleanValue() : false;
        boolean zBooleanValue2 = this.m_renamed.containsKey(4) ? this.m_renamed.get(4).booleanValue() : false;
        boolean zBooleanValue3 = this.m_renamed.containsKey(8) ? this.m_renamed.get(8).booleanValue() : false;
        boolean zBooleanValue4 = this.m_renamed.containsKey(16) ? this.m_renamed.get(16).booleanValue() : false;
        boolean zBooleanValue5 = this.m_renamed.containsKey(32) ? this.m_renamed.get(32).booleanValue() : false;
        boolean zBooleanValue6 = this.m_renamed.containsKey(1024) ? this.m_renamed.get(1024).booleanValue() : false;
        boolean zA = this.l_renamed.get(128).a_renamed(k_renamed());
        boolean zA2 = this.l_renamed.get(256).a_renamed(k_renamed());
        boolean zA3 = this.l_renamed.get(512).a_renamed(k_renamed());
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVar = this.l_renamed.get(16);
        boolean z_renamed = yVar != null && yVar.a_renamed();
        boolean z2 = zBooleanValue5 && this.l_renamed.get(32).y_renamed();
        if (zBooleanValue4 && z_renamed) {
            f_renamed(hVar, i_renamed, i2, i3, i4, this.g_renamed);
            return true;
        }
        if (zBooleanValue3) {
            c_renamed(hVar, i_renamed, i2, i3, i4, this.g_renamed);
            return true;
        }
        if (zA) {
            return a_renamed(hVar, gVar, this.g_renamed, this.f_renamed, i_renamed, i2, i3, i4, z2, zBooleanValue, zBooleanValue2, zA2, zA3, zBooleanValue6, i5);
        }
        if (zBooleanValue) {
            d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            return true;
        }
        if (z2) {
            return g_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        if (zA3) {
            h_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            return true;
        }
        if (zBooleanValue2 && !zA2) {
            a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            return true;
        }
        if (zA2) {
            return i_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        if (zBooleanValue6) {
            return k_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.b_renamed.f_renamed fVar, com.oplus.camera.gl_renamed.s_renamed sVar, int i_renamed, int i2, int i3, int i4, int i5) {
        if (this.l_renamed.get(128).a_renamed(k_renamed())) {
            return a_renamed(hVar, sVar, this.f_renamed, i_renamed, i2, i3, i4, i5);
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public com.oplus.camera.ui.preview.a_renamed.y_renamed j_renamed(int i_renamed) {
        return this.l_renamed.get(java.lang.Integer.valueOf(i_renamed));
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, int i5, com.oplus.camera.aps.util.CameraApsResult cameraApsResult, boolean z_renamed) {
        boolean zK;
        boolean z2;
        int iK = k_renamed();
        boolean zA = this.l_renamed.get(1).a__renamed(iK) ? this.l_renamed.get(1).a_renamed(iK) : false;
        boolean zA2 = this.l_renamed.get(2).a__renamed(iK) ? this.l_renamed.get(2).a_renamed(iK) : false;
        boolean zA3 = this.l_renamed.get(4).a__renamed(iK) ? this.l_renamed.get(4).a_renamed(iK) : false;
        boolean zA4 = (this.l_renamed.get(8) == null || !this.l_renamed.get(8).a__renamed(iK)) ? false : this.l_renamed.get(8).a_renamed(iK);
        boolean zA5 = (this.l_renamed.get(16) == null || !this.l_renamed.get(16).a__renamed(iK)) ? false : this.l_renamed.get(16).a_renamed(iK);
        boolean zA6 = this.l_renamed.get(32).a__renamed(iK) ? this.l_renamed.get(32).a_renamed(iK) : false;
        boolean zA7 = this.l_renamed.get(512).a__renamed(iK) ? this.l_renamed.get(512).a_renamed(iK) : false;
        boolean zA8 = (this.l_renamed.get(64) == null || !this.l_renamed.get(64).a__renamed(iK)) ? false : this.l_renamed.get(64).a_renamed(iK);
        boolean zA9 = this.l_renamed.get(256).a__renamed(iK) ? this.l_renamed.get(256).a_renamed(iK) : false;
        boolean zA10 = this.l_renamed.get(1024).a__renamed(iK) ? this.l_renamed.get(1024).a_renamed(iK) : false;
        boolean zA11 = this.l_renamed.get(2048).a__renamed(iK) ? this.l_renamed.get(2048).a_renamed(iK) : false;
        this.m_renamed.put(2, java.lang.Boolean.valueOf(zA2));
        this.m_renamed.put(4, java.lang.Boolean.valueOf(zA3));
        this.m_renamed.put(8, java.lang.Boolean.valueOf(zA4));
        this.m_renamed.put(16, java.lang.Boolean.valueOf(zA5));
        this.m_renamed.put(32, java.lang.Boolean.valueOf(zA6));
        this.m_renamed.put(512, java.lang.Boolean.valueOf(zA7));
        if (zA10 || zA || zA2 || zA4 || zA5 || zA3 || zA6 || zA8 || zA9 || zA7 || zA11) {
            if (zA10) {
                zK = a_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, cameraApsResult);
            } else if (zA5) {
                zK = b_renamed(hVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA11) {
                if (zA2) {
                    zK = n_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
                } else {
                    zK = m_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
                }
            } else if (zA && !zA2 && !zA4 && !zA3) {
                zK = a_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA && !zA2 && zA4) {
                zK = c_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA && zA2 && !zA4 && !zA3) {
                zK = g_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA && zA2 && zA4) {
                zK = d_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA && !zA2 && !zA4 && zA3) {
                zK = b_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (zA && zA2 && !zA4 && zA3) {
                zK = c_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (!zA && zA2 && !zA4 && !zA3 && !zA6 && !zA7) {
                zK = a_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, z_renamed || l_renamed());
            } else if (!zA && zA2 && zA4 && !zA3) {
                zK = e_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (!zA && !zA2 && zA4 && !zA3) {
                zK = f_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (!zA && !zA7 && !zA2 && !zA4 && zA3 && !zA6 && !zA9) {
                zK = a_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (!zA && zA2 && !zA4 && zA3 && !zA6 && !zA7) {
                zK = d_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (!zA && !zA2 && zA4 && zA3) {
                zK = e_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (!zA && zA2 && zA4 && zA3) {
                zK = f_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (zA7 && !zA2 && !zA3) {
                zK = j_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA7 && zA2 && !zA3) {
                zK = k_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA7 && !zA2 && zA3) {
                zK = h_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (zA7 && zA2 && zA3) {
                zK = j_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (zA6 && !zA2 && !zA3) {
                zK = i_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA6 && zA2 && !zA3) {
                zK = o_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (zA6 && !zA2 && zA3) {
                zK = g_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (zA6 && zA2 && zA3) {
                zK = i_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
            } else if (zA8) {
                zK = b_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            } else if (!zA9 || zA6 || zA3) {
                if (zA9 && !zA6 && zA3) {
                    zK = k_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
                }
                z2 = false;
            } else {
                zK = p_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed);
            }
            z2 = zK;
        } else {
            z2 = false;
        }
        if (!z2 && !gVar.t_renamed()) {
            if (z_renamed || l_renamed()) {
                hVar.a_renamed((com.oplus.camera.gl_renamed.c_renamed) gVar, this.f_renamed, i_renamed, i2, i3, i4, true);
            } else {
                hVar.a_renamed(gVar, this.f_renamed, i_renamed, i2, i3, i4);
            }
        }
        int i6 = (zA ? 1 : 0) | (zA2 ? 2 : 0) | (zA3 ? 4 : 0) | (zA4 ? 8 : 0) | (zA5 ? 16 : 0) | (zA6 ? 32 : 0) | (zA7 ? 512 : 0) | (zA8 ? 64 : 0) | (zA9 ? 256 : 0) | (zA10 ? 1024 : 0);
        gVar.a_renamed(z2 ? i6 : 0);
        this.n_renamed.add(java.lang.Long.valueOf(gVar.k_renamed()));
        gVar.a_renamed((this.n_renamed.size() > l_renamed(i6) ? this.n_renamed.remove(0) : this.n_renamed.get(0)).longValue());
        return !gVar.t_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed) {
        int iK = k_renamed();
        boolean zBooleanValue = this.m_renamed.containsKey(2) ? this.m_renamed.get(2).booleanValue() : false;
        boolean zBooleanValue2 = this.m_renamed.containsKey(4) ? this.m_renamed.get(4).booleanValue() : false;
        boolean zBooleanValue3 = this.m_renamed.containsKey(8) ? this.m_renamed.get(8).booleanValue() : false;
        boolean zBooleanValue4 = this.m_renamed.containsKey(16) ? this.m_renamed.get(16).booleanValue() : false;
        boolean zBooleanValue5 = this.m_renamed.containsKey(32) ? this.m_renamed.get(32).booleanValue() : false;
        this.l_renamed.get(128).a_renamed(k_renamed());
        boolean zA = this.l_renamed.get(256).a_renamed(k_renamed());
        boolean z2 = zBooleanValue5 && this.l_renamed.get(32).y_renamed();
        boolean zA_ = this.l_renamed.get(1).a__renamed(iK);
        if (zBooleanValue4) {
            if (z_renamed) {
                f_renamed(hVar, i_renamed, i2, i3, i4, this.g_renamed);
            }
            return true;
        }
        if (zBooleanValue3) {
            if (z_renamed) {
                c_renamed(hVar, i_renamed, i2, i3, i4, this.g_renamed);
            }
            return true;
        }
        if (zBooleanValue) {
            if (z_renamed) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
            return true;
        }
        if (zA_) {
            if (z_renamed) {
                if (this.l_renamed.get(1).a_renamed(iK)) {
                    e_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
                } else {
                    hVar.a_renamed(gVar, this.f_renamed, i_renamed, i2, i3, i4);
                }
            }
            return true;
        }
        if (z2) {
            if (z_renamed) {
                return g_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        } else {
            if (zBooleanValue2 && !zA) {
                if (z_renamed) {
                    a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
                }
                return true;
            }
            if (zA && z_renamed) {
                return i_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, int i5) {
        int iK = k_renamed();
        if (this.l_renamed.get(4).a__renamed(iK) ? this.l_renamed.get(4).a_renamed(iK) : false) {
            return a_renamed(hVar, gVar, i_renamed, i2, i3, i4, this.g_renamed, i5);
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public com.oplus.camera.gl_renamed.s_renamed a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, com.oplus.camera.gl_renamed.s_renamed sVar, boolean z_renamed) {
        com.oplus.camera.gl_renamed.s_renamed sVarA;
        int iS = gVar.s_renamed();
        com.oplus.camera.e_renamed.a_renamed("PreviewEffectProcessImpl", "captureEffectPreview, flag: " + java.lang.Integer.toBinaryString(iS) + "b_renamed");
        if ((iS & 16) != 0) {
            sVarA = a_renamed(hVar, this.l_renamed.get(16).g_renamed(), sVar, this.g_renamed, !com.oplus.camera.util.Util.C_renamed());
        } else if ((iS & 8) != 0) {
            sVarA = a_renamed(hVar, this.l_renamed.get(8).g_renamed(), sVar, this.g_renamed, !com.oplus.camera.util.Util.C_renamed());
        } else if ((iS & 2) == 0 || this.l_renamed.get(2).g_renamed() == null || !this.l_renamed.get(2).g_renamed().n_renamed()) {
            if ((iS & 1) == 0 || this.l_renamed.get(1).g_renamed() == null || !this.l_renamed.get(1).g_renamed().n_renamed()) {
                if ((iS & 4) == 0 || this.l_renamed.get(4).g_renamed() == null || !this.l_renamed.get(4).g_renamed().n_renamed()) {
                    sVarA = a_renamed(hVar, gVar, sVar, (float[]) null);
                } else if (z_renamed) {
                    sVarA = a_renamed(hVar, 4, sVar);
                } else {
                    sVarA = a_renamed(hVar, this.l_renamed.get(4).g_renamed(), sVar, (float[]) null, !com.oplus.camera.util.Util.C_renamed());
                }
            } else if (z_renamed) {
                sVarA = a_renamed(hVar, 1, sVar);
            } else {
                sVarA = a_renamed(hVar, this.l_renamed.get(1).g_renamed(), sVar, (float[]) null, !com.oplus.camera.util.Util.C_renamed());
            }
        } else if (z_renamed) {
            sVarA = a_renamed(hVar, 2, sVar);
        } else {
            sVarA = a_renamed(hVar, this.l_renamed.get(2).g_renamed(), sVar, (float[]) null, !com.oplus.camera.util.Util.C_renamed());
        }
        sVarA.a_renamed(gVar.j_renamed());
        sVarA.b_renamed(gVar.k_renamed());
        return sVarA;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.g_renamed gVar, com.oplus.camera.gl_renamed.s_renamed sVar) {
        int iS = gVar.s_renamed();
        if ((iS & 16) != 0 || (iS & 8) != 0) {
            return false;
        }
        if ((iS & 2) != 0 && this.l_renamed.get(2).g_renamed() != null && this.l_renamed.get(2).g_renamed().n_renamed()) {
            return this.l_renamed.get(2).g_renamed().a_renamed(sVar);
        }
        if ((iS & 1) != 0 && this.l_renamed.get(1).g_renamed() != null && this.l_renamed.get(1).g_renamed().n_renamed()) {
            return this.l_renamed.get(1).g_renamed().a_renamed(sVar);
        }
        if ((iS & 4) == 0 || this.l_renamed.get(4).g_renamed() == null || !this.l_renamed.get(4).g_renamed().n_renamed()) {
            return false;
        }
        return this.l_renamed.get(4).g_renamed().a_renamed(sVar);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void c_renamed() {
        if (this.l_renamed.get(8) != null) {
            this.l_renamed.get(8).m_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void d_renamed() {
        if (this.l_renamed.get(8) != null) {
            this.l_renamed.get(8).n_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean f_renamed() {
        return this.l_renamed.get(8).a_renamed(k_renamed()) || this.l_renamed.get(16).a_renamed(k_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean e_renamed() {
        if (this.l_renamed.get(8) != null) {
            if (this.l_renamed.get(8).a_renamed(k_renamed())) {
                this.l_renamed.get(8).h_renamed();
            } else {
                this.l_renamed.get(8).o_renamed();
                this.l_renamed.get(8).p_renamed();
            }
        }
        if (this.l_renamed.get(16) == null) {
            return false;
        }
        if (u_renamed()) {
            this.l_renamed.get(16).a_renamed(this.k_renamed);
            this.l_renamed.get(16).h_renamed();
            return false;
        }
        this.l_renamed.get(16).e_renamed();
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(android.util.Size size, boolean z_renamed) {
        for (com.oplus.camera.ui.preview.a_renamed.y_renamed yVar : this.l_renamed.values()) {
            int iK = k_renamed();
            if (yVar.a__renamed(iK) && yVar.a_renamed(iK)) {
                yVar.a_renamed(size, z_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(long j_renamed) {
        for (com.oplus.camera.ui.preview.a_renamed.y_renamed yVar : this.l_renamed.values()) {
            int iK = k_renamed();
            if (yVar.a__renamed(iK) && yVar.a_renamed(iK)) {
                yVar.a_renamed(j_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(byte[] bArr, int i_renamed, int i2, int i3) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVar = this.l_renamed.get(java.lang.Integer.valueOf(i3));
        if (yVar == null || !yVar.a_renamed(i3)) {
            return false;
        }
        yVar.a_renamed(bArr, i_renamed, i2);
        return true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean a_renamed(byte[] bArr, byte[] bArr2, int i_renamed, int i2, int i3) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVar = this.l_renamed.get(java.lang.Integer.valueOf(i3));
        if (yVar == null || !yVar.a_renamed(i3)) {
            return false;
        }
        yVar.a_renamed(bArr, bArr2, i_renamed, i2);
        return true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void h_renamed() {
        this.m_renamed.clear();
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.6
                @Override // java.lang.Runnable
                public void run() {
                    java.util.Iterator it = com.oplus.camera.ui.preview.a_renamed.u_renamed.this.l_renamed.values().iterator();
                    while (it.hasNext()) {
                        ((com.oplus.camera.ui.preview.a_renamed.y_renamed) it.next()).j_renamed();
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void i_renamed() {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.7
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.preview.a_renamed.u_renamed.this.l_renamed != null) {
                        for (com.oplus.camera.ui.preview.a_renamed.y_renamed yVar : com.oplus.camera.ui.preview.a_renamed.u_renamed.this.l_renamed.values()) {
                            yVar.b_renamed();
                            yVar.a_renamed((com.oplus.camera.gl_renamed.GLRootView) null);
                            yVar.s_renamed();
                        }
                    }
                }
            });
            this.h_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed(int i_renamed, int i2) {
        this.d_renamed = i_renamed;
        this.e_renamed = i2;
        c_renamed(i_renamed, i2);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void d_renamed(int i_renamed) {
        java.util.Iterator<com.oplus.camera.ui.preview.a_renamed.y_renamed> it = this.l_renamed.values().iterator();
        while (it.hasNext()) {
            it.next().b_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void e_renamed(int i_renamed) {
        java.util.Iterator<com.oplus.camera.ui.preview.a_renamed.y_renamed> it = this.l_renamed.values().iterator();
        while (it.hasNext()) {
            it.next().d_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(byte[] bArr) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(bArr);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed(long j_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(j_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(float[] fArr) {
        this.f_renamed = fArr;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void f_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.c_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed.b_renamed bVar) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(bVar);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(java.lang.String str) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.b_renamed(str);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.g_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.h_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed(java.lang.String str) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(str);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void h_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.b_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.f_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void g_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(f_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.b_renamed(f_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.c_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void c_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.c_renamed(f_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParam) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(tiltShiftParam);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(stickerItem);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(int[] iArr) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.c_renamed(iArr);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.c_renamed.a_renamed aVar) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(aVar);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void f_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.j_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void g_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.k_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public com.oplus.camera.sticker.data.StickerItem j_renamed() {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            return aaVar.o_renamed();
        }
        return null;
    }

    public boolean s_renamed() {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            return aaVar.r_renamed();
        }
        return true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (j_renamed() == null || stickerItem == null || stickerItem.getStickerUUID() == null) {
            return false;
        }
        return stickerItem.getStickerUUID().equals(j_renamed().getStickerUUID());
    }

    public boolean t_renamed() {
        return j_renamed() != null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void i_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void j_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.m_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void i_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.f_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void l_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.d_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void m_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.e_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void b_renamed(int[] iArr) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(iArr);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void c_renamed(int[] iArr) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.b_renamed(iArr);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.d_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(android.graphics.Point point) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.a_renamed(point);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void h_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.b_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void k_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.i_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public int k_renamed() {
        com.oplus.camera.ui.preview.a_renamed.t_renamed.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return 0;
        }
        int i_renamed = aVar.a_renamed(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR) ? 1 : 0;
        if (this.i_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            i_renamed |= 2;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_PROCESS)) {
            i_renamed |= 8;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_OMOJI_PROCESS)) {
            i_renamed |= 16;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.FACE_SLENDER_PROCESS)) {
            i_renamed |= 4;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS)) {
            i_renamed |= 32;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT_GPU_PROCESS)) {
            i_renamed |= 64;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            i_renamed |= 128;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.VIDEO_RETENTION)) {
            i_renamed |= 256;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.TILT_SHIFT)) {
            i_renamed |= 512;
        }
        if (this.i_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.DOUBLE_EXPOSURE)) {
            i_renamed |= 1024;
        }
        return this.i_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.FISH_EYE) ? i_renamed | 2048 : i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void n_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.l_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public boolean l_renamed() {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            return aaVar.D_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void d_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.d_renamed(f_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void e_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.e_renamed(f_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public float m_renamed() {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            return aaVar.E_renamed();
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public float n_renamed() {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            return aaVar.F_renamed();
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(com.oplus.camera.doubleexposure.c_renamed cVar) {
        if (this.l_renamed.get(1024) != null) {
            this.l_renamed.get(1024).a_renamed(cVar);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void o_renamed() {
        if (this.l_renamed.get(1024) != null) {
            this.l_renamed.get(1024).u_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void p_renamed() {
        if (this.l_renamed.get(1024) != null) {
            this.l_renamed.get(1024).v_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void q_renamed() {
        if (this.l_renamed.get(1024) != null) {
            this.l_renamed.get(1024).w_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void r_renamed() {
        if (this.l_renamed.get(1024) != null) {
            this.l_renamed.get(1024).x_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        this.f6954b = z_renamed;
        this.f6955c = z2;
    }

    public int l_renamed(int i_renamed) {
        int iL = (i_renamed & 1) != 0 ? 0 + this.l_renamed.get(1).l_renamed() : 0;
        return (i_renamed & 4) != 0 ? iL + this.l_renamed.get(4).l_renamed() : iL;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.t_renamed
    public void k_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.k_renamed;
        if (aaVar != null) {
            aaVar.e_renamed(i_renamed);
        }
    }

    private boolean u_renamed() {
        return s_renamed() && t_renamed() && 2 == j_renamed().getMaterialType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed(int i_renamed) {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView == null || !gLRootView.getSurfaceState()) {
            com.oplus.camera.e_renamed.f_renamed("PreviewEffectProcessImpl", "onlyCreateEngines, mGLRootView: " + this.h_renamed);
            return;
        }
        synchronized (this) {
            if (!this.f6953a) {
                com.oplus.camera.e_renamed.a_renamed("PreviewEffectProcessImpl", "onlyCreateEngines, texture has been released");
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("PreviewEffectProcessImpl", "onlyCreateEngines, effectFlag: " + i_renamed);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            for (java.util.Map.Entry<java.lang.Integer, com.oplus.camera.ui.preview.a_renamed.y_renamed> entry : this.l_renamed.entrySet()) {
                if ((16 & entry.getKey().intValue()) == 0 && entry.getValue().a__renamed(i_renamed) && this.k_renamed != null) {
                    entry.getValue().a_renamed(this.k_renamed);
                }
            }
            if (this.l_renamed.get(16) != null && this.k_renamed != null) {
                if ((i_renamed & 16) != 0 && u_renamed()) {
                    this.l_renamed.get(16).a_renamed(this.k_renamed);
                } else {
                    this.l_renamed.get(16).e_renamed();
                }
            }
            com.oplus.camera.e_renamed.a_renamed("PreviewEffectProcessImpl", "onlyCreateEngines, cost time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    private void c_renamed(int i_renamed, int i2) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        d_renamed(i_renamed, i2);
        w_renamed();
        v_renamed();
        com.oplus.camera.e_renamed.a_renamed("PreviewEffectProcessImpl", "updateTextureRes, cost time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void d_renamed(int i_renamed, int i2) {
        for (com.oplus.camera.ui.preview.a_renamed.y_renamed yVar : this.l_renamed.values()) {
            if (yVar.a__renamed(k_renamed())) {
                yVar.a_renamed(i_renamed, i2);
            }
        }
    }

    private void v_renamed() {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.8
                @Override // java.lang.Runnable
                public void run() {
                    for (com.oplus.camera.ui.preview.a_renamed.y_renamed yVar : com.oplus.camera.ui.preview.a_renamed.u_renamed.this.l_renamed.values()) {
                        if (yVar.a__renamed(com.oplus.camera.ui.preview.a_renamed.u_renamed.this.k_renamed())) {
                            yVar.a_renamed(true);
                        }
                    }
                }
            });
        }
    }

    private void w_renamed() {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.h_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.u_renamed.9
                @Override // java.lang.Runnable
                public void run() {
                    for (com.oplus.camera.ui.preview.a_renamed.y_renamed yVar : com.oplus.camera.ui.preview.a_renamed.u_renamed.this.l_renamed.values()) {
                        if (yVar.a__renamed(com.oplus.camera.ui.preview.a_renamed.u_renamed.this.k_renamed())) {
                            yVar.j_renamed();
                            yVar.i_renamed();
                        }
                    }
                }
            });
        }
    }

    private com.oplus.camera.gl_renamed.s_renamed a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, com.oplus.camera.gl_renamed.s_renamed sVar) {
        com.oplus.camera.gl_renamed.s_renamed sVarG = this.l_renamed.get(java.lang.Integer.valueOf(i_renamed)).g_renamed();
        sVar.a_renamed(sVarG.f4611a, sVarG.f4612b);
        this.l_renamed.get(java.lang.Integer.valueOf(i_renamed)).a_renamed(sVar);
        if (!sVar.n_renamed()) {
            sVar.c_renamed(hVar);
        }
        if (sVarG.t_renamed() == null) {
            sVarG.a_renamed(new float[16]);
        }
        this.j_renamed.a_renamed(sVarG.t_renamed());
        com.oplus.camera.e_renamed.c_renamed("PreviewEffectProcessImpl", "swapTexture, inTexture: " + sVar.e_renamed() + ", outTexture: " + sVarG.e_renamed());
        return sVarG;
    }

    private com.oplus.camera.gl_renamed.s_renamed a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.c_renamed cVar, com.oplus.camera.gl_renamed.s_renamed sVar, float[] fArr) {
        return a_renamed(hVar, cVar, sVar, fArr, false);
    }

    private com.oplus.camera.gl_renamed.s_renamed a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.c_renamed cVar, com.oplus.camera.gl_renamed.s_renamed sVar, float[] fArr, boolean z_renamed) {
        if (sVar == null) {
            return null;
        }
        if (!sVar.n_renamed()) {
            sVar.c_renamed(hVar);
        }
        int iF = sVar.f_renamed();
        int iG = sVar.g_renamed();
        hVar.a_renamed(sVar);
        if (z_renamed) {
            android.opengl.GLES20.glFinish();
        }
        hVar.a_renamed(0.0f, iG);
        hVar.a_renamed(1.0f, -1.0f, 1.0f);
        this.j_renamed.a_renamed(this.f_renamed);
        if (fArr == null) {
            fArr = this.f_renamed;
        }
        hVar.a_renamed(cVar, fArr, 0, 0, iF, iG);
        hVar.h_renamed();
        return sVar;
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(1).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, false);
        if (zA && !gVar.t_renamed()) {
            e_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        return zA;
    }

    private boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(64).a_renamed(hVar);
        this.j_renamed.k_renamed();
        this.j_renamed.a_renamed(this.f_renamed);
        return h_renamed(hVar, gVar, i_renamed, i2, i3, i4, fArr);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, boolean z_renamed) {
        this.l_renamed.get(2).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, false, false, fArr, (com.oplus.camera.gl_renamed.s_renamed) null);
        if (zA && !gVar.t_renamed()) {
            a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed, z_renamed);
        }
        return zA;
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        if (zA && !gVar.t_renamed()) {
            a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        return zA;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(4).g_renamed(), fArr, i_renamed, i2, i3, i4);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, float[] fArr, float[] fArr2, int i_renamed, int i2, int i3, int i4, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i5) {
        this.l_renamed.get(128).a_renamed(hVar);
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(128).t_renamed();
        aVarT.f6975a = hVar;
        aVarT.f6977c = this.l_renamed.get(128).f_renamed();
        aVarT.f6976b = gVar;
        aVarT.i_renamed = fArr2;
        aVarT.j_renamed = i3;
        aVarT.k_renamed = i4;
        aVarT.l_renamed = i_renamed;
        aVarT.m_renamed = i2;
        aVarT.o_renamed = i5;
        if (z2) {
            aVarT.f6977c = this.l_renamed.get(2).g_renamed();
        } else if (z_renamed && (java.lang.Float.compare(this.k_renamed.g_renamed(), 0.0f) != 0 || this.k_renamed.i_renamed())) {
            aVarT.f6977c = this.l_renamed.get(32).g_renamed();
        } else if (z4) {
            aVarT.f6977c = this.l_renamed.get(256).g_renamed();
        } else if (z5) {
            aVarT.f6977c = this.l_renamed.get(512).g_renamed();
        } else if (z3) {
            aVarT.f6977c = this.l_renamed.get(4).g_renamed();
        } else if (z6) {
            aVarT.f6977c = this.l_renamed.get(1024).g_renamed();
        } else {
            a_renamed(hVar, gVar, this.l_renamed.get(128).f_renamed(), fArr);
        }
        return this.l_renamed.get(128).a_renamed(aVarT);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, float[] fArr, int i_renamed, int i2, int i3, int i4, int i5) {
        this.l_renamed.get(128).a_renamed(hVar);
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(128).t_renamed();
        aVarT.f6975a = hVar;
        aVarT.f6977c = sVar;
        android.opengl.Matrix.setIdentityM(fArr, 0);
        aVarT.i_renamed = fArr;
        aVarT.j_renamed = i3;
        aVarT.k_renamed = i4;
        aVarT.l_renamed = i_renamed;
        aVarT.m_renamed = i2;
        aVarT.o_renamed = i5;
        return this.l_renamed.get(128).a_renamed(aVarT);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, float[] fArr, int i_renamed) {
        a_renamed(hVar, gVar, this.l_renamed.get(4).f_renamed(), fArr);
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(4).t_renamed();
        aVarT.f6977c = this.l_renamed.get(4).f_renamed();
        aVarT.n_renamed = i_renamed;
        aVarT.h_renamed = this.f6955c ? this.f6954b : true;
        return this.l_renamed.get(4).a_renamed(aVarT);
    }

    private boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        boolean zA = a_renamed(hVar, i3, i4, fArr);
        if (zA) {
            f_renamed(hVar, i_renamed, i2, i3, i4, this.g_renamed);
        }
        return zA;
    }

    private void c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(8).g_renamed(), fArr, i_renamed, i2, i3, i4);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, boolean z_renamed, boolean z2, boolean z3) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(8).t_renamed();
        aVarT.f6975a = hVar;
        aVarT.f6977c = this.l_renamed.get(8).f_renamed();
        if (z2) {
            a_renamed(hVar, this.l_renamed.get(2).g_renamed(), this.l_renamed.get(8).f_renamed(), (float[]) null);
            return this.l_renamed.get(8).a_renamed(aVarT);
        }
        if (z_renamed) {
            a_renamed(hVar, this.l_renamed.get(1).g_renamed(), this.l_renamed.get(8).f_renamed(), (float[]) null);
            return this.l_renamed.get(8).a_renamed(aVarT);
        }
        if (z3) {
            a_renamed(hVar, this.l_renamed.get(4).g_renamed(), this.l_renamed.get(8).f_renamed(), (float[]) null);
            return this.l_renamed.get(8).a_renamed(aVarT);
        }
        a_renamed(hVar, gVar, this.l_renamed.get(8).f_renamed(), (float[]) null);
        return this.l_renamed.get(8).a_renamed(aVarT);
    }

    private boolean c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(1).a_renamed(hVar);
        this.l_renamed.get(8).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, false);
        boolean zA2 = a_renamed(hVar, gVar, zA, false, false);
        if (!gVar.t_renamed()) {
            if (zA2) {
                c_renamed(hVar, i_renamed, i2, i3, i4, fArr);
            } else if (zA) {
                e_renamed(hVar, i_renamed, i2, i3, i4, fArr);
            }
        }
        return zA2 || zA;
    }

    private boolean d_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(1).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        this.l_renamed.get(8).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, false);
        boolean zA2 = a_renamed(hVar, gVar, zA, false, fArr, this.l_renamed.get(1).g_renamed());
        boolean zA3 = a_renamed(hVar, gVar, zA, zA2, false);
        if (!gVar.t_renamed()) {
            if (zA3) {
                c_renamed(hVar, i_renamed, i2, i3, i4, fArr);
            } else if (zA2) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                e_renamed(hVar, i_renamed, i2, i3, i4, fArr);
            }
        }
        return zA3 || zA2 || zA;
    }

    private boolean e_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(2).a_renamed(hVar);
        this.l_renamed.get(8).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, false, false, fArr, (com.oplus.camera.gl_renamed.s_renamed) null);
        boolean zA2 = a_renamed(hVar, gVar, false, zA, false);
        if (!gVar.t_renamed()) {
            if (zA2) {
                c_renamed(hVar, i_renamed, i2, i3, i4, fArr);
            } else if (zA) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA2 || zA;
    }

    private boolean f_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(8).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, false, false, false);
        if (zA && !gVar.t_renamed()) {
            c_renamed(hVar, i_renamed, i2, i3, i4, fArr);
        }
        return zA;
    }

    private boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(1).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zA2 = a_renamed(hVar, gVar, fArr, zA);
        if (!gVar.t_renamed()) {
            if (zA2) {
                e_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA2 || zA;
    }

    private boolean c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(1).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zA2 = a_renamed(hVar, gVar, fArr, zA);
        boolean zA3 = a_renamed(hVar, gVar, zA2, false, fArr, this.l_renamed.get(1).g_renamed());
        if (!gVar.t_renamed()) {
            if (zA3) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA2) {
                e_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA3 || zA2 || zA;
    }

    private boolean d_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zA2 = a_renamed(hVar, gVar, false, zA, fArr, (com.oplus.camera.gl_renamed.s_renamed) null);
        if (!gVar.t_renamed()) {
            if (zA2) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA2 || zA;
    }

    private boolean e_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(8).a_renamed(hVar);
        this.j_renamed.k_renamed();
        this.j_renamed.a_renamed(this.f_renamed);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zA2 = a_renamed(hVar, gVar, false, false, zA);
        if (!gVar.t_renamed()) {
            if (zA2) {
                c_renamed(hVar, i_renamed, i2, i3, i4, fArr);
            } else if (zA) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA2 || zA;
    }

    private boolean f_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        this.l_renamed.get(8).a_renamed(hVar);
        this.j_renamed.k_renamed();
        this.j_renamed.a_renamed(this.f_renamed);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zA2 = a_renamed(hVar, gVar, false, zA, fArr, (com.oplus.camera.gl_renamed.s_renamed) null);
        boolean zA3 = a_renamed(hVar, gVar, false, zA2, zA);
        if (!gVar.t_renamed()) {
            if (zA3) {
                c_renamed(hVar, i_renamed, i2, i3, i4, fArr);
            } else if (zA2) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA3 || zA2 || zA;
    }

    private boolean g_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(1).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, false);
        boolean zA2 = a_renamed(hVar, gVar, zA, false, fArr, this.l_renamed.get(1).g_renamed());
        if (!gVar.t_renamed()) {
            if (zA2) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                e_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA2 || zA;
    }

    private boolean h_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(64).t_renamed();
        aVarT.f6975a = hVar;
        aVarT.j_renamed = i3;
        aVarT.k_renamed = i4;
        aVarT.f6976b = gVar;
        return this.l_renamed.get(64).a_renamed(aVarT);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, float[] fArr, boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(1).t_renamed();
        aVarT.f6975a = hVar;
        if (z_renamed) {
            aVarT.f6977c = this.l_renamed.get(4).g_renamed();
            return this.l_renamed.get(1).a_renamed(aVarT);
        }
        a_renamed(hVar, gVar, this.l_renamed.get(1).f_renamed(), fArr);
        aVarT.f6977c = this.l_renamed.get(1).f_renamed();
        return this.l_renamed.get(1).a_renamed(aVarT);
    }

    private boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, float[] fArr, boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(512).t_renamed();
        aVarT.f6975a = hVar;
        if (z_renamed) {
            aVarT.f6977c = this.l_renamed.get(4).g_renamed();
            return this.l_renamed.get(512).a_renamed(aVarT);
        }
        a_renamed(hVar, gVar, this.l_renamed.get(512).f_renamed(), fArr);
        aVarT.f6977c = this.l_renamed.get(512).f_renamed();
        return this.l_renamed.get(512).a_renamed(aVarT);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, boolean z_renamed, boolean z2, float[] fArr, com.oplus.camera.gl_renamed.s_renamed sVar) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(2).t_renamed();
        if (z_renamed) {
            aVarT.f6977c = sVar;
            return this.l_renamed.get(2).a_renamed(aVarT);
        }
        if (z2) {
            aVarT.f6977c = this.l_renamed.get(4).g_renamed();
            return this.l_renamed.get(2).a_renamed(aVarT);
        }
        a_renamed(hVar, gVar, this.l_renamed.get(2).f_renamed(), fArr);
        aVarT.f6977c = this.l_renamed.get(2).f_renamed();
        return this.l_renamed.get(2).a_renamed(aVarT);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, float[] fArr) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(16).t_renamed();
        aVarT.f6975a = hVar;
        aVarT.j_renamed = i_renamed;
        aVarT.k_renamed = i2;
        return this.l_renamed.get(16).a_renamed(aVarT);
    }

    private boolean i_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(32).a_renamed(hVar);
        boolean zC = c_renamed(hVar, gVar, fArr, false);
        return zC && ((!zC || gVar.t_renamed()) ? false : g_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed));
    }

    private boolean j_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(512).a_renamed(hVar);
        boolean zB = b_renamed(hVar, gVar, fArr, false);
        if (zB && !gVar.t_renamed()) {
            h_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        return zB;
    }

    private boolean k_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(512).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        boolean zB = b_renamed(hVar, gVar, fArr, false);
        boolean zA = a_renamed(hVar, gVar, zB, false, fArr, this.l_renamed.get(512).g_renamed());
        if (!gVar.t_renamed()) {
            if (zA) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zB) {
                h_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA || zB;
    }

    private boolean l_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVar = this.l_renamed.get(2048);
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = yVar.t_renamed();
        aVarT.f6975a = hVar;
        aVarT.i_renamed = fArr;
        return yVar.a_renamed(aVarT);
    }

    private boolean m_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVar = this.l_renamed.get(2048);
        yVar.a_renamed(hVar);
        a_renamed(hVar, gVar, yVar.g_renamed(), fArr);
        if (!l_renamed(hVar, gVar, i_renamed, i2, i3, i4, fArr)) {
            return false;
        }
        hVar.a_renamed(yVar.g_renamed(), this.f_renamed, i_renamed, i2, i3, i4);
        return true;
    }

    private boolean n_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVar = this.l_renamed.get(2);
        com.oplus.camera.ui.preview.a_renamed.y_renamed yVar2 = this.l_renamed.get(2048);
        yVar.a_renamed(hVar);
        yVar2.a_renamed(hVar);
        if (a_renamed(hVar, gVar, false, false, fArr, (com.oplus.camera.gl_renamed.s_renamed) null)) {
            a_renamed(hVar, yVar.g_renamed(), yVar2.g_renamed(), fArr);
        } else {
            a_renamed(hVar, gVar, yVar2.g_renamed(), fArr);
        }
        if (!l_renamed(hVar, gVar, i_renamed, i2, i3, i4, fArr)) {
            return false;
        }
        hVar.a_renamed(yVar2.g_renamed(), this.f_renamed, i_renamed, i2, i3, i4);
        return true;
    }

    private boolean c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, float[] fArr, boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(32).t_renamed();
        aVarT.f6975a = hVar;
        if (z_renamed) {
            aVarT.f6977c = this.l_renamed.get(4).g_renamed();
        } else {
            a_renamed(hVar, gVar, this.l_renamed.get(32).f_renamed(), fArr);
            aVarT.f6977c = this.l_renamed.get(32).f_renamed();
        }
        return this.l_renamed.get(32).a_renamed(aVarT);
    }

    private boolean o_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        boolean zG;
        this.l_renamed.get(32).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        boolean zC = c_renamed(hVar, gVar, fArr, false);
        boolean zA = a_renamed(hVar, gVar, zC, false, fArr, this.l_renamed.get(32).g_renamed());
        if (!zA || gVar.t_renamed()) {
            if (zC) {
                zG = !gVar.t_renamed() ? g_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed) : true;
            }
            return !zA || (zC && zG);
        }
        d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        zG = false;
        if (zA) {
        }
    }

    private boolean g_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        boolean zG;
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(32).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zC = c_renamed(hVar, gVar, fArr, zA);
        if (zC) {
            zG = !gVar.t_renamed() ? g_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed) : true;
        } else {
            zG = false;
        }
        if ((!zC || !zG) && zA && !gVar.t_renamed()) {
            a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        return (zC && zG) || zA;
    }

    private boolean h_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(512).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zB = b_renamed(hVar, gVar, fArr, zA);
        if (!gVar.t_renamed()) {
            if (zB) {
                h_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zB || zA;
    }

    private boolean i_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        boolean zG;
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(32).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        this.j_renamed.k_renamed();
        this.j_renamed.a_renamed(this.f_renamed);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zC = c_renamed(hVar, gVar, fArr, zA);
        boolean zA2 = a_renamed(hVar, gVar, zC, zA, fArr, this.l_renamed.get(32).g_renamed());
        if (zA2 && !gVar.t_renamed()) {
            d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            zG = false;
        } else {
            if (zC) {
                zG = !gVar.t_renamed() ? g_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed) : true;
            } else {
                zG = false;
            }
            if ((!zC || !zG) && zA && !gVar.t_renamed()) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        if (zA2) {
            return true;
        }
        return (zC && zG) || zA;
    }

    private boolean j_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(512).a_renamed(hVar);
        this.l_renamed.get(2).a_renamed(hVar);
        this.j_renamed.k_renamed();
        this.j_renamed.a_renamed(this.f_renamed);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zB = b_renamed(hVar, gVar, fArr, zA);
        boolean zA2 = a_renamed(hVar, gVar, zB, zA, fArr, this.l_renamed.get(512).g_renamed());
        if (!gVar.t_renamed()) {
            if (zA2) {
                d_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zB) {
                h_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            } else if (zA) {
                a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return zA2 || zB || zA;
    }

    private void d_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(2).g_renamed(), fArr, i_renamed, i2, i3, i4);
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr, boolean z_renamed) {
        if (z_renamed) {
            hVar.a_renamed((com.oplus.camera.gl_renamed.c_renamed) this.l_renamed.get(2).g_renamed(), fArr, i_renamed, i2, i3, i4, true);
        } else {
            hVar.a_renamed(this.l_renamed.get(2).g_renamed(), fArr, i_renamed, i2, i3, i4);
        }
    }

    private void e_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(1).g_renamed(), fArr, i_renamed, i2, i3, i4);
    }

    private void f_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(16).g_renamed(), fArr, i_renamed, i2, i3, i4);
    }

    private boolean g_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        if (java.lang.Float.compare(this.k_renamed.g_renamed(), 0.0f) == 0 && !this.k_renamed.i_renamed()) {
            return false;
        }
        hVar.a_renamed(this.l_renamed.get(32).g_renamed(), fArr, i_renamed, i2, i3, i4);
        return true;
    }

    private boolean p_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        this.l_renamed.get(256).a_renamed(hVar);
        return gVar.t_renamed() || (d_renamed(hVar, gVar, fArr, false) && i_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed));
    }

    private void h_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(512).g_renamed(), fArr, i_renamed, i2, i3, i4);
    }

    private boolean k_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, int i5) {
        boolean zI;
        this.l_renamed.get(4).a_renamed(hVar);
        this.l_renamed.get(256).a_renamed(hVar);
        boolean zA = a_renamed(hVar, gVar, fArr, i5);
        boolean zD = d_renamed(hVar, gVar, fArr, zA);
        if (zD) {
            zI = !gVar.t_renamed() ? i_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed) : true;
        } else {
            zI = false;
        }
        if ((!zD || !zI) && zA && !gVar.t_renamed()) {
            a_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
        }
        return (zD && zI) || zA;
    }

    private boolean d_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, float[] fArr, boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(256).t_renamed();
        aVarT.f6975a = hVar;
        if (z_renamed) {
            aVarT.f6977c = this.l_renamed.get(4).g_renamed();
        } else {
            a_renamed(hVar, gVar, this.l_renamed.get(256).f_renamed(), fArr);
            aVarT.f6977c = this.l_renamed.get(256).f_renamed();
        }
        return this.l_renamed.get(256).a_renamed(aVarT);
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4, float[] fArr, com.oplus.camera.aps.util.CameraApsResult cameraApsResult) {
        this.l_renamed.get(1024).a_renamed(hVar);
        com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVarT = this.l_renamed.get(1024).t_renamed();
        aVarT.f6975a = hVar;
        aVarT.j_renamed = i3;
        aVarT.k_renamed = i4;
        aVarT.e_renamed = cameraApsResult;
        boolean zA = this.l_renamed.get(1024).a_renamed(aVarT);
        this.m_renamed.put(1024, java.lang.Boolean.valueOf(zA));
        if (!gVar.t_renamed()) {
            if (aVarT.f_renamed) {
                hVar.a_renamed(aVarT.d_renamed, this.g_renamed, i_renamed, i2, i3, i4);
            } else if (zA) {
                j_renamed(hVar, i_renamed, i2, i3, i4, this.f_renamed);
            }
        }
        return aVarT.f_renamed || zA;
    }

    private boolean i_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        if (!this.k_renamed.h_renamed()) {
            return false;
        }
        hVar.a_renamed(this.l_renamed.get(256).g_renamed(), fArr, i_renamed, i2, i3, i4);
        return true;
    }

    private void j_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(1024).g_renamed(), fArr, i_renamed, i2, i3, i4);
    }

    private boolean k_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, float[] fArr) {
        hVar.a_renamed(this.l_renamed.get(1024).g_renamed(), fArr, i_renamed, i2, i3, i4);
        return true;
    }
}
