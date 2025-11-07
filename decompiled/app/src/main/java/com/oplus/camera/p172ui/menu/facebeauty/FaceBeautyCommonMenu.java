package com.oplus.camera.p172ui.menu.facebeauty;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.OplusNumAISeekBar;
import com.oplus.camera.p172ui.OplusNumSeekBar;
import com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu;
import com.oplus.camera.util.Util;

/* compiled from: FaceBeautyCommonMenu.java */
/* renamed from: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class FaceBeautyCommonMenu extends FaceBeautyBaseMenu implements BeautyMenuInterface {

    /* renamed from: A */
    private int f19286A;

    /* renamed from: B */
    private OplusNumAISeekBar f19287B;

    /* renamed from: C */
    private RelativeLayout.LayoutParams f19288C = null;

    /* renamed from: z */
    private View f19289z;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m20594c(int OplusGLSurfaceView_13, int i2) {
        return 1 == OplusGLSurfaceView_13 ? 270 == i2 ? R.layout.face_beauty_common_vertical_270 : R.layout.face_beauty_common_vertical : R.layout.face_beauty_common;
    }

    public FaceBeautyCommonMenu(Activity activity, OplusNumSeekBar.InterfaceC3101a interfaceC3101a, FaceBeautyBaseMenu.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2) {
        this.f19289z = null;
        this.f19286A = 0;
        this.f19287B = null;
        Util.m24489q(activity.getApplicationContext());
        this.f19275w = OplusGLSurfaceView_13;
        this.f19277y = activity;
        this.f19276x = i2;
        this.f19267o = aVar;
        this.f19289z = activity.getLayoutInflater().inflate(m20594c(OplusGLSurfaceView_13, i2), (ViewGroup) null);
        this.f19253a = (LinearLayout) this.f19289z.findViewById(R.id_renamed.tab_container);
        this.f19286A = m20595a(activity);
        this.f19287B = (OplusNumAISeekBar) this.f19289z.findViewById(R.id_renamed.face_beauty_seekbar);
        this.f19287B.setOnProgressChangedListener(interfaceC3101a);
        this.f19287B.setFrontStyle(true);
        this.f19287B.setmThumbTextShadowBlur(activity.getResources().getDimensionPixelSize(R.dimen.level_panel_text_shadow_radius));
        this.f19287B.setmThumbTextShadowColor(activity.getResources().getColor(R.color.color_black_with_20_percent_transparency));
        this.f19274v = activity.getResources().getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m20595a(Activity activity) {
        if (3 == this.f19275w) {
            return activity.getResources().getDimensionPixelOffset(R.dimen.fold_split_screen_face_beauty_tab_margin_bottom);
        }
        return Util.m24187O() - activity.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_container_height);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20596a(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == -100000) {
            OplusGLSurfaceView_13 = 0;
        }
        this.f19287B.m18321b(0).m18316a(100).m18325d(i2).m18323c(OplusGLSurfaceView_13).postInvalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ViewGroup.LayoutParams m20598b(int OplusGLSurfaceView_13, int i2) {
        if (1 == OplusGLSurfaceView_13) {
            this.f19288C = new RelativeLayout.LayoutParams(-1, -1);
        } else if (4 == OplusGLSurfaceView_13) {
            this.f19288C = new RelativeLayout.LayoutParams(this.f19277y.getResources().getDimensionPixelOffset(R.dimen.rack_mode_face_beauty_common_layout_width), -2);
            this.f19288C.addRule(12);
            this.f19288C.addRule(14);
            this.f19288C.setMargins(0, 0, 0, this.f19277y.getResources().getDimensionPixelSize(R.dimen.rack_mode_face_beauty_layout_margin_bottom));
            this.f19288C.setLayoutDirection(15);
        } else {
            this.f19288C = new RelativeLayout.LayoutParams(-1, -2);
            this.f19288C.addRule(12);
            this.f19288C.setMargins(0, 0, 0, this.f19286A);
        }
        return this.f19288C;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20597a(boolean z, boolean z2) {
        this.f19260h = z;
        this.f19262j = z2;
        m20558c();
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo20564e(boolean z) {
        CameraLog.m12954a("FaceBeautyCommonMenu", "showFaceBeauty, needAnimation: " + z);
        m20577l(z);
        if (this.f19287B.m18324c()) {
            CameraLog.m12954a("FaceBeautyCommonMenu", "showFaceBeauty, isThumbOnDragging");
            this.f19287B.m18322b();
        }
        this.f19257e = 1;
        this.f19269q = m20547a(this.f19287B, z);
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo20566f(boolean z) {
        CameraLog.m12954a("FaceBeautyCommonMenu", "hideFaceBeauty, needAni: " + z);
        this.f19269q = m20553b(this.f19287B, z);
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo20568g(boolean z) {
        CameraLog.m12954a("FaceBeautyCommonMenu", "hideFaceBeauty, needAni: " + z);
        m20557c(this.f19287B, z);
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.BeautyMenuInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20527a() {
        this.f19257e = 0;
        m20579m(false);
        if (this.f19266n != null) {
            this.f19266n.mo20027a();
        }
        ViewGroup viewGroup = (ViewGroup) this.f19289z.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f19289z);
        }
    }

    /* renamed from: s */
    public View m20599s() {
        return this.f19289z;
    }

    /* renamed from: t */
    public OplusNumAISeekBar m20600t() {
        return this.f19287B;
    }
}
