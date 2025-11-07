package androidx.appcompat.widget;

/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.graphics.PorterDuff.Mode f617a = android.graphics.PorterDuff.Mode.SRC_IN;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static androidx.appcompat.widget.i_renamed f618b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ah_renamed f619c;

    public static synchronized void a_renamed() {
        if (f618b == null) {
            f618b = new androidx.appcompat.widget.i_renamed();
            f618b.f619c = androidx.appcompat.widget.ah_renamed.a_renamed();
            f618b.f619c.a_renamed(new androidx.appcompat.widget.ah_renamed.e_renamed() { // from class: androidx.appcompat.widget.i_renamed.1

                /* renamed from: a_renamed, reason: collision with root package name */
                private final int[] f620a = {androidx.appcompat.R_renamed.drawable.abc_textfield_search_default_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_textfield_default_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_ab_share_pack_mtrl_alpha};

                /* renamed from: b_renamed, reason: collision with root package name */
                private final int[] f621b = {androidx.appcompat.R_renamed.drawable.abc_ic_commit_search_api_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_seekbar_tick_mark_material, androidx.appcompat.R_renamed.drawable.abc_ic_menu_share_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_ic_menu_copy_mtrl_am_alpha, androidx.appcompat.R_renamed.drawable.abc_ic_menu_cut_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_ic_menu_selectall_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_ic_menu_paste_mtrl_am_alpha};

                /* renamed from: c_renamed, reason: collision with root package name */
                private final int[] f622c = {androidx.appcompat.R_renamed.drawable.abc_textfield_activated_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_textfield_search_activated_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_cab_background_top_mtrl_alpha, androidx.appcompat.R_renamed.drawable.abc_text_cursor_material, androidx.appcompat.R_renamed.drawable.abc_text_select_handle_left_mtrl_dark, androidx.appcompat.R_renamed.drawable.abc_text_select_handle_middle_mtrl_dark, androidx.appcompat.R_renamed.drawable.abc_text_select_handle_right_mtrl_dark, androidx.appcompat.R_renamed.drawable.abc_text_select_handle_left_mtrl_light, androidx.appcompat.R_renamed.drawable.abc_text_select_handle_middle_mtrl_light, androidx.appcompat.R_renamed.drawable.abc_text_select_handle_right_mtrl_light};
                private final int[] d_renamed = {androidx.appcompat.R_renamed.drawable.abc_popup_background_mtrl_mult, androidx.appcompat.R_renamed.drawable.abc_cab_background_internal_bg, androidx.appcompat.R_renamed.drawable.abc_menu_hardkey_panel_mtrl_mult};
                private final int[] e_renamed = {androidx.appcompat.R_renamed.drawable.abc_tab_indicator_material, androidx.appcompat.R_renamed.drawable.abc_textfield_search_material};
                private final int[] f_renamed = {androidx.appcompat.R_renamed.drawable.abc_btn_check_material, androidx.appcompat.R_renamed.drawable.abc_btn_radio_material, androidx.appcompat.R_renamed.drawable.abc_btn_check_material_anim, androidx.appcompat.R_renamed.drawable.abc_btn_radio_material_anim};

                private android.content.res.ColorStateList a_renamed(android.content.Context context) {
                    return b_renamed(context, androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorButtonNormal));
                }

                private android.content.res.ColorStateList b_renamed(android.content.Context context) {
                    return b_renamed(context, 0);
                }

                private android.content.res.ColorStateList c_renamed(android.content.Context context) {
                    return b_renamed(context, androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorAccent));
                }

                private android.content.res.ColorStateList b_renamed(android.content.Context context, int i_renamed) {
                    int iA = androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlHighlight);
                    return new android.content.res.ColorStateList(new int[][]{androidx.appcompat.widget.am_renamed.f567a, androidx.appcompat.widget.am_renamed.d_renamed, androidx.appcompat.widget.am_renamed.f568b, androidx.appcompat.widget.am_renamed.h_renamed}, new int[]{androidx.appcompat.widget.am_renamed.c_renamed(context, androidx.appcompat.R_renamed.attr.colorButtonNormal), androidx.core.graphics.d_renamed.a_renamed(iA, i_renamed), androidx.core.graphics.d_renamed.a_renamed(iA, i_renamed), i_renamed});
                }

                private android.content.res.ColorStateList d_renamed(android.content.Context context) {
                    int[][] iArr = new int[3][];
                    int[] iArr2 = new int[3];
                    android.content.res.ColorStateList colorStateListB = androidx.appcompat.widget.am_renamed.b_renamed(context, androidx.appcompat.R_renamed.attr.colorSwitchThumbNormal);
                    if (colorStateListB != null && colorStateListB.isStateful()) {
                        iArr[0] = androidx.appcompat.widget.am_renamed.f567a;
                        iArr2[0] = colorStateListB.getColorForState(iArr[0], 0);
                        iArr[1] = androidx.appcompat.widget.am_renamed.e_renamed;
                        iArr2[1] = androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlActivated);
                        iArr[2] = androidx.appcompat.widget.am_renamed.h_renamed;
                        iArr2[2] = colorStateListB.getDefaultColor();
                    } else {
                        iArr[0] = androidx.appcompat.widget.am_renamed.f567a;
                        iArr2[0] = androidx.appcompat.widget.am_renamed.c_renamed(context, androidx.appcompat.R_renamed.attr.colorSwitchThumbNormal);
                        iArr[1] = androidx.appcompat.widget.am_renamed.e_renamed;
                        iArr2[1] = androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlActivated);
                        iArr[2] = androidx.appcompat.widget.am_renamed.h_renamed;
                        iArr2[2] = androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorSwitchThumbNormal);
                    }
                    return new android.content.res.ColorStateList(iArr, iArr2);
                }

                @Override // androidx.appcompat.widget.ah_renamed.e_renamed
                public android.graphics.drawable.Drawable a_renamed(androidx.appcompat.widget.ah_renamed ahVar, android.content.Context context, int i_renamed) {
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_cab_background_top_material) {
                        return new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{ahVar.a_renamed(context, androidx.appcompat.R_renamed.drawable.abc_cab_background_internal_bg), ahVar.a_renamed(context, androidx.appcompat.R_renamed.drawable.abc_cab_background_top_mtrl_alpha)});
                    }
                    return null;
                }

                private void a_renamed(android.graphics.drawable.Drawable drawable, int i_renamed, android.graphics.PorterDuff.Mode mode) {
                    if (androidx.appcompat.widget.aa_renamed.c_renamed(drawable)) {
                        drawable = drawable.mutate();
                    }
                    if (mode == null) {
                        mode = androidx.appcompat.widget.i_renamed.f617a;
                    }
                    drawable.setColorFilter(androidx.appcompat.widget.i_renamed.a_renamed(i_renamed, mode));
                }

                @Override // androidx.appcompat.widget.ah_renamed.e_renamed
                public boolean a_renamed(android.content.Context context, int i_renamed, android.graphics.drawable.Drawable drawable) {
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_seekbar_track_material) {
                        android.graphics.drawable.LayerDrawable layerDrawable = (android.graphics.drawable.LayerDrawable) drawable;
                        a_renamed(layerDrawable.findDrawableByLayerId(android.R_renamed.id_renamed.background), androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlNormal), androidx.appcompat.widget.i_renamed.f617a);
                        a_renamed(layerDrawable.findDrawableByLayerId(android.R_renamed.id_renamed.secondaryProgress), androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlNormal), androidx.appcompat.widget.i_renamed.f617a);
                        a_renamed(layerDrawable.findDrawableByLayerId(android.R_renamed.id_renamed.progress), androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlActivated), androidx.appcompat.widget.i_renamed.f617a);
                        return true;
                    }
                    if (i_renamed != androidx.appcompat.R_renamed.drawable.abc_ratingbar_material && i_renamed != androidx.appcompat.R_renamed.drawable.abc_ratingbar_indicator_material && i_renamed != androidx.appcompat.R_renamed.drawable.abc_ratingbar_small_material) {
                        return false;
                    }
                    android.graphics.drawable.LayerDrawable layerDrawable2 = (android.graphics.drawable.LayerDrawable) drawable;
                    a_renamed(layerDrawable2.findDrawableByLayerId(android.R_renamed.id_renamed.background), androidx.appcompat.widget.am_renamed.c_renamed(context, androidx.appcompat.R_renamed.attr.colorControlNormal), androidx.appcompat.widget.i_renamed.f617a);
                    a_renamed(layerDrawable2.findDrawableByLayerId(android.R_renamed.id_renamed.secondaryProgress), androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlActivated), androidx.appcompat.widget.i_renamed.f617a);
                    a_renamed(layerDrawable2.findDrawableByLayerId(android.R_renamed.id_renamed.progress), androidx.appcompat.widget.am_renamed.a_renamed(context, androidx.appcompat.R_renamed.attr.colorControlActivated), androidx.appcompat.widget.i_renamed.f617a);
                    return true;
                }

                private boolean a_renamed(int[] iArr, int i_renamed) {
                    for (int i2 : iArr) {
                        if (i2 == i_renamed) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // androidx.appcompat.widget.ah_renamed.e_renamed
                public android.content.res.ColorStateList a_renamed(android.content.Context context, int i_renamed) {
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_edit_text_material) {
                        return androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, androidx.appcompat.R_renamed.color.abc_tint_edittext);
                    }
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_switch_track_mtrl_alpha) {
                        return androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, androidx.appcompat.R_renamed.color.abc_tint_switch_track);
                    }
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_switch_thumb_material) {
                        return d_renamed(context);
                    }
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_btn_default_mtrl_shape) {
                        return a_renamed(context);
                    }
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_btn_borderless_material) {
                        return b_renamed(context);
                    }
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_btn_colored_material) {
                        return c_renamed(context);
                    }
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_spinner_mtrl_am_alpha || i_renamed == androidx.appcompat.R_renamed.drawable.abc_spinner_textfield_background_material) {
                        return androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, androidx.appcompat.R_renamed.color.abc_tint_spinner);
                    }
                    if (a_renamed(this.f621b, i_renamed)) {
                        return androidx.appcompat.widget.am_renamed.b_renamed(context, androidx.appcompat.R_renamed.attr.colorControlNormal);
                    }
                    if (a_renamed(this.e_renamed, i_renamed)) {
                        return androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, androidx.appcompat.R_renamed.color.abc_tint_default);
                    }
                    if (a_renamed(this.f_renamed, i_renamed)) {
                        return androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, androidx.appcompat.R_renamed.color.abc_tint_btn_checkable);
                    }
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_seekbar_thumb_material) {
                        return androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, androidx.appcompat.R_renamed.color.abc_tint_seek_thumb);
                    }
                    return null;
                }

                /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0047  */
                /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0062 A_renamed[RETURN] */
                @Override // androidx.appcompat.widget.ah_renamed.e_renamed
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean b_renamed(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                    /*
                        r6 = this;
                        android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.i_renamed.c_renamed()
                        int[] r1 = r6.f620a
                        boolean r1 = r6.a_renamed(r1, r8)
                        r2 = 16842801(0x1010031, float:2.3693695E-38)
                        r3 = -1
                        r4 = 0
                        r5 = 1
                        if (r1 == 0) goto L17
                        int r2 = androidx.appcompat.R_renamed.attr.colorControlNormal
                    L14:
                        r8 = r3
                    L15:
                        r6 = r5
                        goto L45
                    L17:
                        int[] r1 = r6.f622c
                        boolean r1 = r6.a_renamed(r1, r8)
                        if (r1 == 0) goto L22
                        int r2 = androidx.appcompat.R_renamed.attr.colorControlActivated
                        goto L14
                    L22:
                        int[] r1 = r6.d_renamed
                        boolean r6 = r6.a_renamed(r1, r8)
                        if (r6 == 0) goto L2d
                        android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                        goto L14
                    L2d:
                        int r6 = androidx.appcompat.R_renamed.drawable.abc_list_divider_mtrl_alpha
                        if (r8 != r6) goto L3d
                        r2 = 16842800(0x1010030, float:2.3693693E-38)
                        r6 = 1109603123(0x42233333, float:40.8)
                        int r6 = java.lang.Math.round(r6)
                        r8 = r6
                        goto L15
                    L3d:
                        int r6 = androidx.appcompat.R_renamed.drawable.abc_dialog_material_background
                        if (r8 != r6) goto L42
                        goto L14
                    L42:
                        r8 = r3
                        r6 = r4
                        r2 = r6
                    L45:
                        if (r6 == 0) goto L62
                        boolean r6 = androidx.appcompat.widget.aa_renamed.c_renamed(r9)
                        if (r6 == 0) goto L51
                        android.graphics.drawable.Drawable r9 = r9.mutate()
                    L51:
                        int r6 = androidx.appcompat.widget.am_renamed.a_renamed(r7, r2)
                        android.graphics.PorterDuffColorFilter r6 = androidx.appcompat.widget.i_renamed.a_renamed(r6, r0)
                        r9.setColorFilter(r6)
                        if (r8 == r3) goto L61
                        r9.setAlpha(r8)
                    L61:
                        return r5
                    L62:
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i_renamed.SceneLoader_2.b_renamed(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                }

                @Override // androidx.appcompat.widget.ah_renamed.e_renamed
                public android.graphics.PorterDuff.Mode a_renamed(int i_renamed) {
                    if (i_renamed == androidx.appcompat.R_renamed.drawable.abc_switch_thumb_material) {
                        return android.graphics.PorterDuff.Mode.MULTIPLY;
                    }
                    return null;
                }
            });
        }
    }

    public static synchronized androidx.appcompat.widget.i_renamed b_renamed() {
        if (f618b == null) {
            a_renamed();
        }
        return f618b;
    }

    public synchronized android.graphics.drawable.Drawable a_renamed(android.content.Context context, int i_renamed) {
        return this.f619c.a_renamed(context, i_renamed);
    }

    synchronized android.graphics.drawable.Drawable a_renamed(android.content.Context context, int i_renamed, boolean z_renamed) {
        return this.f619c.a_renamed(context, i_renamed, z_renamed);
    }

    public synchronized void a_renamed(android.content.Context context) {
        this.f619c.a_renamed(context);
    }

    synchronized android.content.res.ColorStateList b_renamed(android.content.Context context, int i_renamed) {
        return this.f619c.b_renamed(context, i_renamed);
    }

    static void a_renamed(android.graphics.drawable.Drawable drawable, androidx.appcompat.widget.ap_renamed apVar, int[] iArr) {
        androidx.appcompat.widget.ah_renamed.a_renamed(drawable, apVar, iArr);
    }

    public static synchronized android.graphics.PorterDuffColorFilter a_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        return androidx.appcompat.widget.ah_renamed.a_renamed(i_renamed, mode);
    }
}
