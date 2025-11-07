package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: GLProducerRender2DHorizontal.java */
/* loaded from: classes2.dex */
public class l_renamed extends com.oplus.camera.ui.menu.levelcontrol.k_renamed {
    public l_renamed(android.content.Context context, int i_renamed, int i2) {
        super(context, i_renamed);
        this.H_renamed = i2;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.k_renamed
    protected void k_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(180.0f, 1.0f, 0.0f, 0.0f);
        float f_renamed = -1.0f;
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed(this.d_renamed.n_renamed, this.E_renamed ? -1.0f : 1.0f, 1.0f);
        if (1 == this.G_renamed) {
            com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed((this.f_renamed / this.d_renamed.d_renamed) * 1.0f * 2.0f, 0.0f, 0.0f);
            com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(180.0f, 0.0f, 0.0f, 1.0f);
        } else if (this.H_renamed == 0) {
            float fS_renamed = (this.f_renamed / this.d_renamed.d_renamed) * (-1.0f) * 2.0f;
            if (this.p_renamed.o_renamed()) {
                fS_renamed = ((this.f_renamed - this.p_renamed.s_renamed()) / this.d_renamed.d_renamed) * (-1.0f) * 2.0f;
            }
            com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(fS_renamed, 0.0f, 0.0f);
            if (this.p_renamed.n_renamed()) {
                if (!this.p_renamed.o_renamed()) {
                    com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(180.0f, 0.0f, 1.0f, 0.0f);
                }
            } else if (!this.E_renamed) {
                com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(180.0f, 0.0f, 0.0f, 1.0f);
            }
        } else {
            if (this.p_renamed.n_renamed()) {
                com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed(-1.0f, 1.0f, 1.0f);
                f_renamed = 1.0f;
            }
            float fS2 = (this.f_renamed / this.d_renamed.f6474c) * f_renamed * 2.0f;
            if (this.p_renamed.o_renamed()) {
                fS2 = f_renamed * ((this.f_renamed - this.p_renamed.s_renamed()) / this.d_renamed.f6474c) * 2.0f;
            }
            com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(fS2, 0.0f, 0.0f);
            com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(this.H_renamed, 0.0f, 0.0f, 1.0f);
        }
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.k_renamed
    protected int c_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        if (this.H_renamed == 0) {
            return java.lang.Math.round((iVar.r_renamed() + iVar.s_renamed()) * iVar.a_renamed().size());
        }
        return java.lang.Math.round(iVar.r_renamed());
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.k_renamed
    protected int d_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        if (this.H_renamed == 0) {
            return java.lang.Math.round(iVar.q_renamed());
        }
        return java.lang.Math.round(java.lang.Math.round((iVar.q_renamed() + iVar.s_renamed()) * iVar.a_renamed().size()));
    }
}
