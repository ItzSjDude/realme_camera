package com.oplus.camera.t_renamed;

/* compiled from: StreetTrackHelper.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f5615a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.CameraUIInterface f5617c;
    private com.oplus.camera.capmode.a_renamed d_renamed;
    private com.oplus.camera.t_renamed.a_renamed e_renamed;
    private android.content.SharedPreferences g_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.t_renamed.h_renamed f5616b = null;
    private com.oplus.camera.t_renamed.g_renamed.a_renamed f_renamed = null;
    private com.oplus.camera.t_renamed.f_renamed h_renamed = null;

    /* compiled from: StreetTrackHelper.java */
    interface a_renamed {
        void a_renamed(int i_renamed);

        void g_renamed();

        void h_renamed();

        void i_renamed();

        boolean j_renamed();

        boolean k_renamed();
    }

    public g_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.e_renamed.d_renamed dVar) {
        this.f5615a = null;
        this.f5617c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.g_renamed = null;
        this.f5615a = activity;
        this.f5617c = cameraUIInterface;
        this.d_renamed = aVar;
        this.g_renamed = this.d_renamed.t_renamed();
        this.e_renamed = new com.oplus.camera.t_renamed.a_renamed(dVar, aVar, activity, cameraUIInterface);
        g_renamed();
    }

    public boolean a_renamed() {
        return this.f5616b.f_renamed();
    }

    public boolean b_renamed() {
        return this.e_renamed.g_renamed();
    }

    public void c_renamed() {
        this.f5616b.c_renamed();
    }

    public void d_renamed() {
        com.oplus.camera.t_renamed.h_renamed hVar = this.f5616b;
        if (hVar != null) {
            hVar.setVisibility(4);
            this.f5616b.removeAllViewsInLayout();
            this.f5616b = null;
        }
    }

    private void g_renamed() {
        this.f5616b = new com.oplus.camera.t_renamed.h_renamed(this.f5615a);
        this.f5616b.b_renamed();
        this.f5616b.setTrackListener(new com.oplus.camera.t_renamed.h_renamed.b_renamed() { // from class: com.oplus.camera.t_renamed.g_renamed.1
            @Override // com.oplus.camera.t_renamed.h_renamed.b_renamed
            public void a_renamed() {
                com.oplus.camera.t_renamed.g_renamed.this.l_renamed();
                if (com.oplus.camera.t_renamed.g_renamed.this.f_renamed != null) {
                    com.oplus.camera.t_renamed.g_renamed.this.f_renamed.k_renamed();
                }
            }

            @Override // com.oplus.camera.t_renamed.h_renamed.b_renamed
            public boolean b_renamed() {
                if (com.oplus.camera.t_renamed.g_renamed.this.f_renamed != null) {
                    return com.oplus.camera.t_renamed.g_renamed.this.f_renamed.j_renamed();
                }
                return com.oplus.camera.t_renamed.g_renamed.this.d_renamed.A_renamed();
            }

            @Override // com.oplus.camera.t_renamed.h_renamed.b_renamed
            public void c_renamed() {
                if (com.oplus.camera.t_renamed.g_renamed.this.f5617c != null) {
                    com.oplus.camera.t_renamed.g_renamed.this.f5617c.p_renamed(false);
                    com.oplus.camera.t_renamed.g_renamed.this.f5617c.h_renamed(false, false);
                    com.oplus.camera.t_renamed.g_renamed.this.d_renamed.a_renamed(true, false);
                }
                if (com.oplus.camera.t_renamed.g_renamed.this.f_renamed != null) {
                    com.oplus.camera.t_renamed.g_renamed.this.f_renamed.g_renamed();
                }
                com.oplus.camera.t_renamed.g_renamed.this.l_renamed();
                com.oplus.camera.t_renamed.g_renamed.this.i_renamed();
                com.oplus.camera.t_renamed.g_renamed.this.n_renamed();
                com.oplus.camera.t_renamed.g_renamed gVar = com.oplus.camera.t_renamed.g_renamed.this;
                gVar.a_renamed(gVar.f5616b.getY());
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x004e  */
            @Override // com.oplus.camera.t_renamed.h_renamed.b_renamed
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a_renamed(int r3) {
                /*
                    r2 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "onTouch: motionEvent onTracKMove:"
                    r0.append(r1)
                    r0.append(r3)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "StreetTrackHelp"
                    com.oplus.camera.e_renamed.a_renamed(r1, r0)
                    if (r3 == 0) goto L3f
                    r0 = 1
                    if (r3 == r0) goto L30
                    r0 = 2
                    if (r3 == r0) goto L29
                    r0 = 3
                    if (r3 == r0) goto L22
                    goto L4e
                L22:
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    boolean r0 = r0.f_renamed()
                    goto L4f
                L29:
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    boolean r0 = com.oplus.camera.t_renamed.g_renamed.j_renamed(r0)
                    goto L4f
                L30:
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    boolean r0 = com.oplus.camera.t_renamed.g_renamed.h_renamed(r0)
                    if (r0 != 0) goto L4e
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    boolean r0 = com.oplus.camera.t_renamed.g_renamed.i_renamed(r0)
                    goto L4f
                L3f:
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    boolean r0 = com.oplus.camera.t_renamed.g_renamed.h_renamed(r0)
                    if (r0 != 0) goto L4e
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    boolean r0 = r0.e_renamed()
                    goto L4f
                L4e:
                    r0 = 0
                L4f:
                    if (r0 == 0) goto L56
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    com.oplus.camera.t_renamed.g_renamed.a_renamed(r0)
                L56:
                    com.oplus.camera.t_renamed.g_renamed r0 = com.oplus.camera.t_renamed.g_renamed.this
                    com.oplus.camera.t_renamed.g_renamed$a_renamed r0 = com.oplus.camera.t_renamed.g_renamed.b_renamed(r0)
                    if (r0 == 0) goto L67
                    com.oplus.camera.t_renamed.g_renamed r2 = com.oplus.camera.t_renamed.g_renamed.this
                    com.oplus.camera.t_renamed.g_renamed$a_renamed r2 = com.oplus.camera.t_renamed.g_renamed.b_renamed(r2)
                    r2.a_renamed(r3)
                L67:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.t_renamed.g_renamed.SceneLoader_2.a_renamed(int):void");
            }

            @Override // com.oplus.camera.t_renamed.h_renamed.b_renamed
            public void d_renamed() {
                com.oplus.camera.t_renamed.g_renamed.this.h_renamed();
                if (com.oplus.camera.t_renamed.g_renamed.this.f_renamed != null) {
                    com.oplus.camera.t_renamed.g_renamed.this.f_renamed.h_renamed();
                }
                com.oplus.camera.t_renamed.g_renamed.this.p_renamed();
                com.oplus.camera.t_renamed.g_renamed.this.e_renamed.e_renamed();
            }

            @Override // com.oplus.camera.t_renamed.h_renamed.b_renamed
            public void e_renamed() {
                if (com.oplus.camera.t_renamed.g_renamed.this.f_renamed != null) {
                    com.oplus.camera.t_renamed.g_renamed.this.f_renamed.i_renamed();
                }
            }
        });
        if (this.g_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_TRACE_GUIDE, true)) {
            this.h_renamed = new com.oplus.camera.t_renamed.f_renamed(this.f5615a, this.f5616b.getTrackMaxRadius());
            this.f5617c.a_renamed((android.view.View) this.h_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET, 5, true);
        }
        this.f5617c.a_renamed((android.view.View) this.f5616b, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET, 3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed) {
        if (this.h_renamed == null || !this.g_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_TRACE_GUIDE, true)) {
            return;
        }
        this.h_renamed.a_renamed(f_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h_renamed() {
        com.oplus.camera.t_renamed.f_renamed fVar = this.h_renamed;
        if (fVar != null) {
            fVar.a_renamed();
            this.g_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_TRACE_GUIDE, false).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed() {
        android.content.SharedPreferences sharedPreferences;
        if (this.d_renamed == null || (sharedPreferences = this.g_renamed) == null || !sharedPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER, true)) {
            return;
        }
        this.f5617c.f_renamed(20, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StreetTrackHelp", "zoomIn");
        if (m_renamed()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < 2; i_renamed++) {
            this.d_renamed.a_renamed(false, 0.03f);
        }
        return this.d_renamed.a_renamed(false, 0.03f);
    }

    public boolean e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StreetTrackHelp", "zoomOut");
        if (m_renamed()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < 2; i_renamed++) {
            this.d_renamed.a_renamed(true, 0.03f);
        }
        return this.d_renamed.a_renamed(true, 0.03f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StreetTrackHelp", "fixFocusIn");
        if (m_renamed()) {
            return false;
        }
        return this.e_renamed.b_renamed();
    }

    public boolean f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StreetTrackHelp", "fixFocusOut");
        if (m_renamed()) {
            return false;
        }
        return this.e_renamed.c_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        com.oplus.camera.ae_renamed aeVarAd = this.d_renamed.ad_renamed();
        if (aeVarAd != null) {
            aeVarAd.d_renamed();
        }
    }

    public void a_renamed(com.oplus.camera.t_renamed.g_renamed.a_renamed aVar) {
        this.f_renamed = aVar;
    }

    private boolean m_renamed() {
        android.app.Activity activity;
        android.content.SharedPreferences sharedPreferences = this.g_renamed;
        if (sharedPreferences == null || (activity = this.f5615a) == null) {
            return false;
        }
        return "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, activity.getString(com.oplus.camera.R_renamed.string.ultra_wide_angle_default_value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed() {
        if (this.d_renamed.J_renamed()) {
            this.d_renamed.H_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o_renamed() {
        return "on_renamed".equals(this.g_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p_renamed() {
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.f5617c;
        if (cameraUIInterface != null) {
            cameraUIInterface.H_renamed();
            this.f5617c.l_renamed(true, false);
            this.f5617c.i_renamed(true, false);
            if (this.e_renamed.g_renamed()) {
                return;
            }
            this.f5617c.a_renamed(0, 1);
        }
    }
}
