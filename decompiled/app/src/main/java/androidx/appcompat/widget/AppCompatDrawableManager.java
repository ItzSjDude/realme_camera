package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

/* compiled from: AppCompatDrawableManager.java */
/* renamed from: androidx.appcompat.widget.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PorterDuff.Mode f1959a = PorterDuff.Mode.SRC_IN;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static AppCompatDrawableManager f1960b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ResourceManagerInternal f1961c;

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized void m1664a() {
        if (f1960b == null) {
            f1960b = new AppCompatDrawableManager();
            f1960b.f1961c = ResourceManagerInternal.m1462a();
            f1960b.f1961c.m1478a(new ResourceManagerInternal.COUIBaseListPopupWindow_8() { // from class: androidx.appcompat.widget.OplusGLSurfaceView_13.1

                /* renamed from: PlatformImplementations.kt_3 */
                private final int[] f1962a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

                /* renamed from: IntrinsicsJvm.kt_4 */
                private final int[] f1963b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

                /* renamed from: IntrinsicsJvm.kt_3 */
                private final int[] f1964c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};

                /* renamed from: IntrinsicsJvm.kt_5 */
                private final int[] f1965d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

                /* renamed from: COUIBaseListPopupWindow_8 */
                private final int[] f1966e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

                /* renamed from: COUIBaseListPopupWindow_12 */
                private final int[] f1967f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                /* renamed from: PlatformImplementations.kt_3 */
                private ColorStateList m1672a(Context context) {
                    return m1676b(context, ThemeUtils.m1529a(context, R.attr.colorButtonNormal));
                }

                /* renamed from: IntrinsicsJvm.kt_4 */
                private ColorStateList m1675b(Context context) {
                    return m1676b(context, 0);
                }

                /* renamed from: IntrinsicsJvm.kt_3 */
                private ColorStateList m1677c(Context context) {
                    return m1676b(context, ThemeUtils.m1529a(context, R.attr.colorAccent));
                }

                /* renamed from: IntrinsicsJvm.kt_4 */
                private ColorStateList m1676b(Context context, int OplusGLSurfaceView_13) {
                    int iM1529a = ThemeUtils.m1529a(context, R.attr.colorControlHighlight);
                    return new ColorStateList(new int[][]{ThemeUtils.f1855a, ThemeUtils.f1858d, ThemeUtils.f1856b, ThemeUtils.f1862h}, new int[]{ThemeUtils.m1533c(context, R.attr.colorButtonNormal), ColorUtils.m2544a(iM1529a, OplusGLSurfaceView_13), ColorUtils.m2544a(iM1529a, OplusGLSurfaceView_13), OplusGLSurfaceView_13});
                }

                /* renamed from: IntrinsicsJvm.kt_5 */
                private ColorStateList m1678d(Context context) {
                    int[][] iArr = new int[3][];
                    int[] iArr2 = new int[3];
                    ColorStateList colorStateListM1532b = ThemeUtils.m1532b(context, R.attr.colorSwitchThumbNormal);
                    if (colorStateListM1532b != null && colorStateListM1532b.isStateful()) {
                        iArr[0] = ThemeUtils.f1855a;
                        iArr2[0] = colorStateListM1532b.getColorForState(iArr[0], 0);
                        iArr[1] = ThemeUtils.f1859e;
                        iArr2[1] = ThemeUtils.m1529a(context, R.attr.colorControlActivated);
                        iArr[2] = ThemeUtils.f1862h;
                        iArr2[2] = colorStateListM1532b.getDefaultColor();
                    } else {
                        iArr[0] = ThemeUtils.f1855a;
                        iArr2[0] = ThemeUtils.m1533c(context, R.attr.colorSwitchThumbNormal);
                        iArr[1] = ThemeUtils.f1859e;
                        iArr2[1] = ThemeUtils.m1529a(context, R.attr.colorControlActivated);
                        iArr[2] = ThemeUtils.f1862h;
                        iArr2[2] = ThemeUtils.m1529a(context, R.attr.colorSwitchThumbNormal);
                    }
                    return new ColorStateList(iArr, iArr2);
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.COUIBaseListPopupWindow_8
                /* renamed from: PlatformImplementations.kt_3 */
                public Drawable mo1487a(ResourceManagerInternal c0312ah, Context context, int OplusGLSurfaceView_13) {
                    if (OplusGLSurfaceView_13 == R.drawable.abc_cab_background_top_material) {
                        return new LayerDrawable(new Drawable[]{c0312ah.m1474a(context, R.drawable.abc_cab_background_internal_bg), c0312ah.m1474a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                    }
                    return null;
                }

                /* renamed from: PlatformImplementations.kt_3 */
                private void m1673a(Drawable drawable, int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
                    if (DrawableUtils.m1397c(drawable)) {
                        drawable = drawable.mutate();
                    }
                    if (mode == null) {
                        mode = AppCompatDrawableManager.f1959a;
                    }
                    drawable.setColorFilter(AppCompatDrawableManager.m1663a(OplusGLSurfaceView_13, mode));
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.COUIBaseListPopupWindow_8
                /* renamed from: PlatformImplementations.kt_3 */
                public boolean mo1488a(Context context, int OplusGLSurfaceView_13, Drawable drawable) {
                    if (OplusGLSurfaceView_13 == R.drawable.abc_seekbar_track_material) {
                        LayerDrawable layerDrawable = (LayerDrawable) drawable;
                        m1673a(layerDrawable.findDrawableByLayerId(android.R.id_renamed.background), ThemeUtils.m1529a(context, R.attr.colorControlNormal), AppCompatDrawableManager.f1959a);
                        m1673a(layerDrawable.findDrawableByLayerId(android.R.id_renamed.secondaryProgress), ThemeUtils.m1529a(context, R.attr.colorControlNormal), AppCompatDrawableManager.f1959a);
                        m1673a(layerDrawable.findDrawableByLayerId(android.R.id_renamed.progress), ThemeUtils.m1529a(context, R.attr.colorControlActivated), AppCompatDrawableManager.f1959a);
                        return true;
                    }
                    if (OplusGLSurfaceView_13 != R.drawable.abc_ratingbar_material && OplusGLSurfaceView_13 != R.drawable.abc_ratingbar_indicator_material && OplusGLSurfaceView_13 != R.drawable.abc_ratingbar_small_material) {
                        return false;
                    }
                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                    m1673a(layerDrawable2.findDrawableByLayerId(android.R.id_renamed.background), ThemeUtils.m1533c(context, R.attr.colorControlNormal), AppCompatDrawableManager.f1959a);
                    m1673a(layerDrawable2.findDrawableByLayerId(android.R.id_renamed.secondaryProgress), ThemeUtils.m1529a(context, R.attr.colorControlActivated), AppCompatDrawableManager.f1959a);
                    m1673a(layerDrawable2.findDrawableByLayerId(android.R.id_renamed.progress), ThemeUtils.m1529a(context, R.attr.colorControlActivated), AppCompatDrawableManager.f1959a);
                    return true;
                }

                /* renamed from: PlatformImplementations.kt_3 */
                private boolean m1674a(int[] iArr, int OplusGLSurfaceView_13) {
                    for (int i2 : iArr) {
                        if (i2 == OplusGLSurfaceView_13) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.COUIBaseListPopupWindow_8
                /* renamed from: PlatformImplementations.kt_3 */
                public ColorStateList mo1485a(Context context, int OplusGLSurfaceView_13) {
                    if (OplusGLSurfaceView_13 == R.drawable.abc_edit_text_material) {
                        return AppCompatResources.m729a(context, R.color.abc_tint_edittext);
                    }
                    if (OplusGLSurfaceView_13 == R.drawable.abc_switch_track_mtrl_alpha) {
                        return AppCompatResources.m729a(context, R.color.abc_tint_switch_track);
                    }
                    if (OplusGLSurfaceView_13 == R.drawable.abc_switch_thumb_material) {
                        return m1678d(context);
                    }
                    if (OplusGLSurfaceView_13 == R.drawable.abc_btn_default_mtrl_shape) {
                        return m1672a(context);
                    }
                    if (OplusGLSurfaceView_13 == R.drawable.abc_btn_borderless_material) {
                        return m1675b(context);
                    }
                    if (OplusGLSurfaceView_13 == R.drawable.abc_btn_colored_material) {
                        return m1677c(context);
                    }
                    if (OplusGLSurfaceView_13 == R.drawable.abc_spinner_mtrl_am_alpha || OplusGLSurfaceView_13 == R.drawable.abc_spinner_textfield_background_material) {
                        return AppCompatResources.m729a(context, R.color.abc_tint_spinner);
                    }
                    if (m1674a(this.f1963b, OplusGLSurfaceView_13)) {
                        return ThemeUtils.m1532b(context, R.attr.colorControlNormal);
                    }
                    if (m1674a(this.f1966e, OplusGLSurfaceView_13)) {
                        return AppCompatResources.m729a(context, R.color.abc_tint_default);
                    }
                    if (m1674a(this.f1967f, OplusGLSurfaceView_13)) {
                        return AppCompatResources.m729a(context, R.color.abc_tint_btn_checkable);
                    }
                    if (OplusGLSurfaceView_13 == R.drawable.abc_seekbar_thumb_material) {
                        return AppCompatResources.m729a(context, R.color.abc_tint_seek_thumb);
                    }
                    return null;
                }

                /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[RETURN] */
                @Override // androidx.appcompat.widget.ResourceManagerInternal.COUIBaseListPopupWindow_8
                /* renamed from: IntrinsicsJvm.kt_4 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean mo1489b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                    /*
                        r6 = this;
                        android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.m1667c()
                        int[] r1 = r6.f1962a
                        boolean r1 = r6.m1674a(r1, r8)
                        r2 = 16842801(0x1010031, float:2.3693695E-38)
                        r3 = -1
                        r4 = 0
                        r5 = 1
                        if (r1 == 0) goto L17
                        int r2 = androidx.appcompat.R.attr.colorControlNormal
                    L14:
                        r8 = r3
                    L15:
                        r6 = r5
                        goto L45
                    L17:
                        int[] r1 = r6.f1964c
                        boolean r1 = r6.m1674a(r1, r8)
                        if (r1 == 0) goto L22
                        int r2 = androidx.appcompat.R.attr.colorControlActivated
                        goto L14
                    L22:
                        int[] r1 = r6.f1965d
                        boolean r6 = r6.m1674a(r1, r8)
                        if (r6 == 0) goto L2d
                        android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                        goto L14
                    L2d:
                        int r6 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                        if (r8 != r6) goto L3d
                        r2 = 16842800(0x1010030, float:2.3693693E-38)
                        r6 = 1109603123(0x42233333, float:40.8)
                        int r6 = java.lang.Math.round(r6)
                        r8 = r6
                        goto L15
                    L3d:
                        int r6 = androidx.appcompat.R.drawable.abc_dialog_material_background
                        if (r8 != r6) goto L42
                        goto L14
                    L42:
                        r8 = r3
                        r6 = r4
                        r2 = r6
                    L45:
                        if (r6 == 0) goto L62
                        boolean r6 = androidx.appcompat.widget.DrawableUtils.m1397c(r9)
                        if (r6 == 0) goto L51
                        android.graphics.drawable.Drawable r9 = r9.mutate()
                    L51:
                        int r6 = androidx.appcompat.widget.ThemeUtils.m1529a(r7, r2)
                        android.graphics.PorterDuffColorFilter r6 = androidx.appcompat.widget.AppCompatDrawableManager.m1663a(r6, r0)
                        r9.setColorFilter(r6)
                        if (r8 == r3) goto L61
                        r9.setAlpha(r8)
                    L61:
                        return r5
                    L62:
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.COUIBaseListPopupWindow_2.mo1489b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.COUIBaseListPopupWindow_8
                /* renamed from: PlatformImplementations.kt_3 */
                public PorterDuff.Mode mo1486a(int OplusGLSurfaceView_13) {
                    if (OplusGLSurfaceView_13 == R.drawable.abc_switch_thumb_material) {
                        return PorterDuff.Mode.MULTIPLY;
                    }
                    return null;
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static synchronized AppCompatDrawableManager m1666b() {
        if (f1960b == null) {
            m1664a();
        }
        return f1960b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized Drawable m1668a(Context context, int OplusGLSurfaceView_13) {
        return this.f1961c.m1474a(context, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    synchronized Drawable m1669a(Context context, int OplusGLSurfaceView_13, boolean z) {
        return this.f1961c.m1475a(context, OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m1670a(Context context) {
        this.f1961c.m1477a(context);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    synchronized ColorStateList m1671b(Context context, int OplusGLSurfaceView_13) {
        return this.f1961c.m1480b(context, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m1665a(Drawable drawable, TintInfo c0320ap, int[] iArr) {
        ResourceManagerInternal.m1464a(drawable, c0320ap, iArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized PorterDuffColorFilter m1663a(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        return ResourceManagerInternal.m1458a(OplusGLSurfaceView_13, mode);
    }
}
