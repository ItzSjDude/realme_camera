package com.oplus.camera.filmvideomode;

/* compiled from: FilmUIControlV2Rack.java */
/* loaded from: classes2.dex */
public class r_renamed extends com.oplus.camera.filmvideomode.q_renamed {
    private android.widget.RelativeLayout z_renamed;

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed
    public void l_renamed() {
    }

    public r_renamed(android.app.Activity activity, com.oplus.camera.e_renamed.d_renamed dVar, com.oplus.camera.capmode.a_renamed aVar, android.view.ViewGroup viewGroup) {
        super(activity, dVar, aVar, viewGroup);
        this.z_renamed = null;
        this.z_renamed = (android.widget.RelativeLayout) this.f4466b.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_root);
    }

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed
    public void j_renamed() throws android.content.res.Resources.NotFoundException {
        if (i_renamed() == null || this.h_renamed == null || this.g_renamed == null || this.i_renamed == null || this.f4465a == null || this.h_renamed.getCount() == 0) {
            return;
        }
        if (com.oplus.camera.util.Util.u_renamed() || !this.h_renamed.b_renamed()) {
            this.f4465a.b_renamed();
            this.h_renamed.a_renamed(this.g_renamed, 0, true, true);
        }
    }

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed
    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FilmUIControlV2Rack", "initMenuList");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().b_renamed(false).c_renamed(true).a_renamed(c_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.camera_menu_flash_on).c_renamed(com.oplus.camera.R_renamed.drawable.camera_menu_flash_off));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(f_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.super_eis_light).c_renamed(com.oplus.camera.R_renamed.drawable.super_eis_normal));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(b_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.menu_log_on).c_renamed(com.oplus.camera.R_renamed.drawable.menu_log_off));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(d_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.ic_histogram_on).c_renamed(com.oplus.camera.R_renamed.drawable.ic_histogram_off));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(e_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.icon_tool_grid_light).c_renamed(com.oplus.camera.R_renamed.drawable.ic_gride_off));
        if (this.h_renamed == null) {
            this.h_renamed = new com.oplus.camera.filmvideomode.e_renamed(arrayList, this.i_renamed, false, true);
        }
        this.g_renamed.setAdapter(this.h_renamed);
    }

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed
    public void a_renamed(android.view.ViewGroup viewGroup) {
        if (this.f4465a == null || viewGroup == null || viewGroup.indexOfChild(this.f4465a) < 0) {
            return;
        }
        i_renamed(false);
        viewGroup.removeView(this.f4465a);
    }

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed, com.oplus.camera.filmvideomode.f_renamed.a_renamed
    public void b_renamed(android.view.View view, android.view.View view2, int i_renamed) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed = false;
        boolean zBooleanValue = view2.getTag() instanceof java.lang.Boolean ? ((java.lang.Boolean) view2.getTag()).booleanValue() : false;
        if (this.d_renamed != null && !this.d_renamed.R_renamed() && !this.d_renamed.S_renamed() && !zBooleanValue) {
            z_renamed = true;
        }
        if (i_renamed() == null || this.h_renamed == null || this.f4465a == null || this.f4465a.a_renamed() || !z_renamed) {
            com.oplus.camera.e_renamed.b_renamed("FilmUIControlV2Rack", "onMenuItemClick is_renamed intercepted, return");
            return;
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(i_renamed);
        item.a_renamed(!item.e_renamed());
        this.h_renamed.a_renamed(this.g_renamed, i_renamed);
        if (3 == i_renamed) {
            l_renamed(item.e_renamed());
        }
        if (4 == i_renamed) {
            k_renamed(item.e_renamed());
        }
        if (2 == i_renamed) {
            d_renamed(item);
        }
        if (1 == i_renamed) {
            a_renamed(item);
        }
        if (i_renamed == 0) {
            j_renamed(item.e_renamed());
        }
        if (this.i_renamed != null) {
            this.i_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, item.e_renamed()).apply();
        }
        b_renamed(i_renamed, item.e_renamed());
    }

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed
    public void k_renamed() {
        j_renamed(false);
    }

    private void C_renamed() {
        if (this.g_renamed != null) {
            com.oplus.camera.util.Util.a_renamed(this.g_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
            this.g_renamed.setMenuItemClickListener(null);
        }
    }

    private void D_renamed() {
        if (this.g_renamed != null) {
            com.oplus.camera.util.Util.a_renamed(this.g_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
            this.g_renamed.setMenuItemClickListener(this);
        }
    }

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed
    public void m_renamed() {
        this.o_renamed = true;
        C_renamed();
        if (this.j_renamed != null) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
        }
        if (this.f4465a == null || this.f4465a.getVisibility() == 0 || this.h_renamed == null || !this.h_renamed.b_renamed()) {
            return;
        }
        com.oplus.camera.util.Util.a_renamed(this.f4465a, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
    }

    @Override // com.oplus.camera.filmvideomode.q_renamed, com.oplus.camera.filmvideomode.a_renamed
    public void n_renamed() {
        this.o_renamed = false;
        if (this.f4465a != null && !this.f4465a.j_renamed()) {
            D_renamed();
        }
        if (this.j_renamed != null) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
        }
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed, com.oplus.camera.filmvideomode.k_renamed.a_renamed
    public void e_renamed(boolean z_renamed) {
        if (z_renamed) {
            C_renamed();
        } else {
            if (this.d_renamed.ao_renamed()) {
                return;
            }
            D_renamed();
        }
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public boolean a_renamed(int i_renamed, int i2, boolean z_renamed) {
        if (this.f4466b == null || this.p_renamed) {
            return false;
        }
        this.q_renamed.set(this.r_renamed.a_renamed());
        this.q_renamed.bottom -= com.oplus.camera.util.Util.Z_renamed();
        android.graphics.Rect rect = new android.graphics.Rect();
        if (this.m_renamed != null) {
            this.m_renamed.getGlobalVisibleRect(rect);
        }
        android.graphics.Rect rect2 = new android.graphics.Rect();
        if (this.f4465a != null) {
            this.f4465a.a_renamed(rect2);
        }
        android.graphics.Rect rect3 = new android.graphics.Rect();
        if (this.j_renamed != null) {
            this.j_renamed.getGlobalVisibleRect(rect3);
        }
        android.graphics.Rect rect4 = new android.graphics.Rect();
        if (this.l_renamed != null) {
            this.l_renamed.getGlobalVisibleRect(rect4);
        }
        return (!this.q_renamed.contains(i_renamed, i2) || rect.contains(i_renamed, i2) || rect2.contains(i_renamed, i2) || rect3.contains(i_renamed, i2) || rect4.contains(i_renamed, i2)) ? false : true;
    }
}
