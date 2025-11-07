package com.oplus.camera.screen;

/* compiled from: ScreenModeManager.java */
/* loaded from: classes2.dex */
public class g_renamed implements com.oplus.camera.screen.a_renamed.a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.app.Activity f5375c;
    private com.oplus.camera.screen.b_renamed.a_renamed f_renamed;
    private com.oplus.camera.screen.a_renamed.e_renamed h_renamed;
    private com.oplus.camera.capmode.BaseMode j_renamed;
    private com.oplus.camera.screen.b_renamed d_renamed = null;

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.util.List<com.oplus.camera.screen.b_renamed.a_renamed> f5373a = new java.util.ArrayList();
    private com.oplus.camera.screen.b_renamed.a_renamed e_renamed = null;
    private com.oplus.camera.screen.e_renamed g_renamed = null;
    private boolean i_renamed = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    public com.oplus.camera.screen.f_renamed.a_renamed f5374b = com.oplus.camera.screen.f_renamed.a_renamed.out;
    private boolean k_renamed = false;
    private boolean l_renamed = false;
    private boolean m_renamed = false;
    private int n_renamed = 1;
    private boolean o_renamed = true;
    private boolean p_renamed = true;

    public void c_renamed() {
    }

    public g_renamed(android.app.Activity activity) {
        this.f5375c = null;
        this.f_renamed = null;
        this.h_renamed = null;
        this.f5375c = activity;
        this.h_renamed = new com.oplus.camera.screen.a_renamed.e_renamed(activity, this);
        int length = com.oplus.camera.screen.f_renamed.a_renamed.values().length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            switch (r5[i_renamed]) {
                case common:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.b_renamed());
                    break;
                case out:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.j_renamed());
                    break;
                case full:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.d_renamed());
                    break;
                case full90:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.f_renamed());
                    break;
                case full270:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.e_renamed());
                    break;
                case left:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.i_renamed());
                    break;
                case right:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.n_renamed());
                    break;
                case rack90:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.m_renamed());
                    break;
                case rack270:
                    this.f5373a.add(new com.oplus.camera.screen.b_renamed.l_renamed());
                    break;
            }
        }
        if (com.oplus.camera.util.Util.t_renamed()) {
            this.f_renamed = this.f5373a.get(com.oplus.camera.screen.f_renamed.a_renamed.out.ordinal());
            com.oplus.camera.statistics.DcsUtil.sFoldType = this.f_renamed.a_renamed(this.l_renamed);
        } else {
            this.f_renamed = this.f5373a.get(com.oplus.camera.screen.f_renamed.a_renamed.common.ordinal());
        }
    }

    public void a_renamed(com.oplus.camera.screen.f_renamed.a_renamed aVar, boolean z_renamed, boolean z2) {
        com.oplus.camera.screen.f_renamed.a_renamed aVar2;
        com.oplus.camera.screen.b_renamed.a_renamed aVar3;
        com.oplus.camera.e_renamed.f_renamed("ScreenModeManager", "changeScreenMode, screenMode: " + aVar + ", forceChange: " + z_renamed + ", fromClick: " + z2 + ", mbStopped: " + this.m_renamed);
        if (this.m_renamed) {
            return;
        }
        this.k_renamed = z_renamed;
        this.l_renamed = z2;
        boolean z3 = true;
        if (aVar == com.oplus.camera.screen.f_renamed.a_renamed.low90) {
            aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.rack90;
        } else if (aVar == com.oplus.camera.screen.f_renamed.a_renamed.low270) {
            aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.rack270;
        } else {
            z3 = false;
            aVar2 = aVar;
        }
        com.oplus.camera.screen.b_renamed.a_renamed aVar4 = this.f5373a.get(aVar2.ordinal());
        if (this.d_renamed == null || this.f5375c == null) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("changeScreenMode, targetScreenMode: ");
        sb.append(aVar4);
        sb.append(", mCurrentScreenMode: ");
        sb.append(this.f_renamed);
        sb.append(", mCapMode: ");
        com.oplus.camera.capmode.BaseMode baseMode = this.j_renamed;
        sb.append(baseMode == null ? null : baseMode.getCameraMode());
        com.oplus.camera.e_renamed.f_renamed("ScreenModeManager", sb.toString());
        if (this.j_renamed != null && aVar4.c_renamed().contains(this.j_renamed.getCameraMode())) {
            if (this.f_renamed.c_renamed().contains(this.j_renamed.getCameraMode())) {
                return;
            } else {
                aVar4 = this.f5373a.get(this.j_renamed.getPreferredScreenMode(this.h_renamed.c_renamed()).ordinal());
            }
        }
        if (z_renamed || (aVar3 = this.f_renamed) != aVar4) {
            a_renamed(aVar, aVar4);
            if (this.f_renamed.r_renamed()) {
                this.f_renamed.b_renamed(z3);
            }
            if (this.i_renamed) {
                if (this.g_renamed == null) {
                    this.g_renamed = new com.oplus.camera.screen.e_renamed(new com.oplus.camera.screen.e_renamed.b_renamed() { // from class: com.oplus.camera.screen.g_renamed.1
                        @Override // com.oplus.camera.screen.e_renamed.b_renamed
                        public android.view.View a_renamed() {
                            return com.oplus.camera.screen.g_renamed.this.f5375c.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
                        }

                        @Override // com.oplus.camera.screen.e_renamed.b_renamed
                        public android.view.View b_renamed() {
                            return com.oplus.camera.screen.g_renamed.this.f5375c.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container);
                        }

                        @Override // com.oplus.camera.screen.e_renamed.b_renamed
                        public void c_renamed() {
                            com.oplus.camera.screen.g_renamed.this.d_renamed.a_renamed(com.oplus.camera.screen.g_renamed.this.e_renamed, com.oplus.camera.screen.g_renamed.this.f_renamed);
                            com.oplus.camera.screen.g_renamed.this.d_renamed.a_renamed(com.oplus.camera.screen.g_renamed.this.f_renamed, com.oplus.camera.screen.g_renamed.this.k_renamed);
                            com.oplus.camera.screen.g_renamed.this.d_renamed.a_renamed(com.oplus.camera.screen.g_renamed.this.f_renamed);
                        }
                    });
                }
                this.g_renamed.a_renamed();
            } else {
                this.d_renamed.a_renamed(this.e_renamed, this.f_renamed);
                this.d_renamed.a_renamed(this.f_renamed, this.k_renamed);
                this.d_renamed.a_renamed(this.f_renamed);
            }
        } else if (aVar3.q_renamed() != z3) {
            a_renamed(aVar, aVar4);
            this.d_renamed.a_renamed(this.e_renamed, this.f_renamed);
            this.f_renamed.b_renamed(z3);
            this.d_renamed.a_renamed(this.f_renamed, this.k_renamed);
            this.d_renamed.a_renamed(this.f_renamed);
        }
        com.oplus.camera.statistics.DcsUtil.sFoldType = this.f_renamed.a_renamed(this.l_renamed);
    }

    private void a_renamed(com.oplus.camera.screen.f_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.a_renamed aVar2) {
        this.e_renamed = this.f_renamed;
        this.f_renamed = aVar2;
        this.f5374b = aVar;
        this.h_renamed.a_renamed(aVar);
    }

    @Override // com.oplus.camera.screen.a_renamed.a_renamed
    public com.oplus.camera.screen.b_renamed.a_renamed a_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.screen.a_renamed.e_renamed eVar = this.h_renamed;
        if (eVar != null) {
            eVar.a_renamed(i_renamed);
        }
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.screen.a_renamed.e_renamed eVar = this.h_renamed;
        if (eVar != null) {
            eVar.b_renamed(i_renamed);
        }
    }

    public int b_renamed() {
        if (this.f_renamed.a_renamed()) {
            return this.h_renamed.c_renamed();
        }
        return 0;
    }

    public void a_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    public void d_renamed() {
        this.i_renamed = true;
        this.m_renamed = false;
    }

    public void e_renamed() {
        com.oplus.camera.screen.e_renamed eVar = this.g_renamed;
        if (eVar != null) {
            eVar.b_renamed();
        }
        this.i_renamed = false;
    }

    public void f_renamed() {
        this.m_renamed = true;
    }

    public void g_renamed() {
        this.f5375c = null;
        com.oplus.camera.screen.a_renamed.e_renamed eVar = this.h_renamed;
        if (eVar != null) {
            eVar.a_renamed();
        }
    }

    public void a_renamed(com.oplus.camera.screen.b_renamed bVar) {
        this.d_renamed = bVar;
    }

    @Override // com.oplus.camera.screen.a_renamed.a_renamed
    public void b_renamed(com.oplus.camera.screen.f_renamed.a_renamed aVar, boolean z_renamed, boolean z2) {
        if (z_renamed || (aVar != null && !aVar.name().equals(this.f5374b.name()))) {
            com.oplus.camera.e_renamed.b_renamed("ScreenModeManager", "notifyFolderChange : " + aVar.name());
            a_renamed(aVar, z_renamed, z2);
        }
        com.oplus.camera.statistics.DcsUtil.sFoldType = this.f_renamed.a_renamed(z2);
    }

    public void h_renamed() {
        com.oplus.camera.screen.a_renamed.e_renamed eVar = this.h_renamed;
        if (eVar != null) {
            eVar.b_renamed();
        }
    }

    @Override // com.oplus.camera.screen.a_renamed.a_renamed
    public void a_renamed(com.oplus.camera.capmode.BaseMode baseMode) {
        this.j_renamed = baseMode;
        b_renamed(baseMode);
    }

    private void b_renamed(com.oplus.camera.capmode.BaseMode baseMode) {
        com.oplus.camera.screen.a_renamed.e_renamed eVar = this.h_renamed;
        com.oplus.camera.screen.f_renamed.a_renamed preferredScreenMode = (eVar == null || baseMode == null) ? null : baseMode.getPreferredScreenMode(eVar.c_renamed());
        if (com.oplus.camera.screen.f_renamed.a_renamed.left != preferredScreenMode && com.oplus.camera.screen.f_renamed.a_renamed.right != preferredScreenMode && com.oplus.camera.screen.f_renamed.a_renamed.common != preferredScreenMode) {
            this.o_renamed = false;
        } else {
            this.o_renamed = true;
        }
    }

    @Override // com.oplus.camera.screen.a_renamed.a_renamed
    public com.oplus.camera.screen.f_renamed.a_renamed i_renamed() {
        return this.f5374b;
    }

    public com.oplus.camera.screen.a_renamed.e_renamed j_renamed() {
        return this.h_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = (com.oplus.camera.ui.menu.facebeauty.RotateAnimationView) this.f5375c.findViewById(com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button);
        if (rotateAnimationView != null) {
            if (z_renamed) {
                rotateAnimationView.setImageResource(com.oplus.camera.R_renamed.drawable.ic_screen_mode_expand);
            } else {
                rotateAnimationView.setImageResource(com.oplus.camera.R_renamed.drawable.icon_screen_mode_switch);
            }
        }
    }

    public boolean k_renamed() {
        return this.f_renamed.i_renamed() && this.o_renamed && this.p_renamed;
    }

    public void l_renamed() {
        android.app.Activity activity = this.f5375c;
        if (activity != null) {
            activity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera).setAlpha(1.0f);
        }
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.screen.a_renamed.e_renamed eVar = this.h_renamed;
        if (eVar != null) {
            eVar.d_renamed(i_renamed);
        }
        int i2 = this.n_renamed;
        this.p_renamed = (2 == i2 || 3 == i2) ? false : true;
    }

    public boolean a_renamed(java.lang.String str) {
        com.oplus.camera.screen.a_renamed.e_renamed eVar;
        boolean z_renamed = true;
        if (this.j_renamed == null) {
            return true;
        }
        if (!this.f_renamed.c_renamed().contains(this.j_renamed.getCameraMode()) && ((eVar = this.h_renamed) == null || !eVar.a_renamed(str))) {
            z_renamed = false;
        }
        com.oplus.camera.e_renamed.b_renamed("ScreenModeManager", "checkIfScreenModeNeedChange, needChange: " + z_renamed);
        return z_renamed;
    }

    public com.oplus.camera.screen.b_renamed.a_renamed m_renamed() {
        return this.e_renamed;
    }
}
