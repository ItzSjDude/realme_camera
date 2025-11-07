package com.oplus.camera.filmvideomode;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButton;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.statistics.model.FilmModeMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;

/* compiled from: FilmUIControlV1.java */
/* renamed from: com.oplus.camera.filmvideomode.p */
/* loaded from: classes2.dex */
public class FilmUIControlV1 extends BaseFilmUIControl {
    public FilmUIControlV1(Activity activity, OneCamera interfaceC2694d, CameraInterface interfaceC2646a, ViewGroup viewGroup) {
        super(activity);
        this.f13583b = activity;
        this.f13584c.setRotation(90.0f);
        this.f13584c.setOnClickListener(this);
        this.f13587f = interfaceC2694d;
        this.f13585d = interfaceC2646a;
        this.f13590i = interfaceC2646a.mo10590t();
        this.f13592k = Util.m24376b(activity, R.drawable.exposure_control_bar_bottom);
        this.f13593l = (ThumbImageView) this.f13583b.findViewById(R.id_renamed.thumbnail);
        this.f13594m = (MainShutterButton) this.f13583b.findViewById(R.id_renamed.shutter_button);
        this.f13595n = viewGroup;
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR) || this.f13584c.getLayoutParams() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13584c.getLayoutParams();
        layoutParams.topMargin = this.f13583b.getResources().getDimensionPixelSize(R.dimen.movie_mode_back_top) + m13440i().getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
        this.f13584c.setLayoutParams(layoutParams);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13404a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilmMenuMode().m13511b(false).m13514c(true).m13516d(R.drawable.movie_mode_menu_bg).m13513c(R.drawable.icon_show).m13507a(R.drawable.icon_hide));
        arrayList.add(new FilmMenuMode().m13508a(m13436e()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.icon_tool_grid_light).m13513c(R.drawable.icon_tool_grid));
        arrayList.add(new FilmMenuMode().m13508a(m13437f()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.super_eis_light).m13513c(R.drawable.super_eis_normal));
        arrayList.add(new FilmMenuMode().m13508a(m13432c()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.menu_flash_torch_light).m13513c(R.drawable.camera_menu_flash_off));
        if (this.f13589h == null) {
            this.f13589h = new FilmMenuAdapter(arrayList, this.f13590i, false, false);
        }
        this.f13588g.setAdapter(this.f13589h);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m13660f(boolean z) {
        if (this.f13582a != null) {
            this.f13582a.m13581b(z);
            this.f13582a.m13586d();
        }
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13413a(ViewGroup viewGroup) throws Resources.NotFoundException {
        if (this.f13582a != null && viewGroup != null && viewGroup.indexOfChild(this.f13582a) >= 0) {
            m13660f(false);
            viewGroup.removeView(this.f13582a);
        }
        if (this.f13589h == null || this.f13588g == null) {
            return;
        }
        this.f13589h.getItem(0).m13508a(false);
        this.f13589h.getItem(0).m13520f(false);
        this.f13589h.getItem(0).m13518e(true);
        this.f13589h.m13500a(this.f13588g, 0, false);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id_renamed.movie_mode_back) {
            return;
        }
        if (this.f13585d != null) {
            this.f13585d.mo10501aC();
        }
        this.f13590i.edit().remove(CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE).apply();
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl, com.oplus.camera.filmvideomode.FilmMenuLayout.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13426b(View view, View view2, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        boolean z = (this.f13585d == null || this.f13585d.mo10462R() || this.f13585d.mo10463S() || (view2.getTag() instanceof Boolean ? ((Boolean) view2.getTag()).booleanValue() : false)) ? false : true;
        if (m13440i() == null || this.f13589h == null || this.f13582a == null || this.f13582a.m13575a() || !z) {
            return;
        }
        if (this.f13585d != null && this.f13585d.mo10518aT() != null) {
            this.f13585d.mo10518aT().m18488a(true);
        }
        FilmMenuMode item = this.f13589h.getItem(OplusGLSurfaceView_13);
        item.m13508a(!item.m13519e());
        boolean z2 = OplusGLSurfaceView_13 == 0;
        if (z2) {
            boolean zM13585c = this.f13582a.m13585c();
            item.m13518e(true);
            if (item.m13519e() && !zM13585c) {
                this.f13582a.m13578b();
            } else {
                m13660f(false);
            }
            if (this.f13585d != null && !this.f13585d.mo10539ao() && !zM13585c) {
                item.m13520f(false);
                this.f13589h.m13500a(this.f13588g, OplusGLSurfaceView_13, true);
            } else {
                item.m13520f(true);
                this.f13589h.m13503b(this.f13588g, OplusGLSurfaceView_13, this.f13589h.m13505b(), !item.m13519e());
            }
        } else {
            this.f13589h.m13499a(this.f13588g, OplusGLSurfaceView_13);
        }
        if (3 == OplusGLSurfaceView_13) {
            m13656a(item);
        }
        if (2 == OplusGLSurfaceView_13) {
            m13658b(item);
        }
        if (1 == OplusGLSurfaceView_13) {
            m13659c(item);
        }
        if (this.f13590i != null && z2) {
            this.f13590i.edit().putBoolean(CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, item.m13519e()).apply();
        }
        m13661z();
        m13657b(OplusGLSurfaceView_13, item.m13519e());
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo13441j() throws Resources.NotFoundException {
        if (m13440i() == null || this.f13589h == null || this.f13588g == null || this.f13590i == null || this.f13582a == null || this.f13589h.getCount() == 0 || this.f13589h.m13505b() || !this.f13590i.getBoolean(CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, true)) {
            return;
        }
        FilmMenuMode item = this.f13589h.getItem(0);
        item.m13508a(true);
        item.m13520f(false);
        item.m13518e(true);
        this.f13582a.m13578b();
        this.f13589h.m13500a(this.f13588g, 0, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13656a(FilmMenuMode c2712g) {
        if (c2712g == null || this.f13587f == null || this.f13590i == null) {
            return;
        }
        this.f13585d.mo10518aT().m18488a(true);
        this.f13585d.mo10518aT().m18492b(CameraUIInterface.KEY_MOVIE_FLASH_MODE);
        if (c2712g.m13519e()) {
            m13418a(true, 2);
            m13418a(true, 1);
            this.f13590i.edit().putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, CameraParameter.FlashMode.FLASH_TORCH).apply();
        } else {
            this.f13590i.edit().putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").apply();
        }
        m13661z();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13658b(FilmMenuMode c2712g) {
        if (c2712g == null || this.f13590i == null) {
            return;
        }
        if (c2712g.m13519e()) {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on").apply();
        } else {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "off").apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13659c(FilmMenuMode c2712g) {
        if (c2712g == null || this.f13590i == null) {
            return;
        }
        this.f13585d.mo10518aT().m18492b(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE);
        if (c2712g.m13519e()) {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "grid").apply();
        } else {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").apply();
        }
        m13661z();
    }

    /* renamed from: z */
    private void m13661z() {
        HintManager c3130aMo10518aT;
        if (this.f13585d == null || (c3130aMo10518aT = this.f13585d.mo10518aT()) == null) {
            return;
        }
        c3130aMo10518aT.m18492b((String) null);
        c3130aMo10518aT.m18488a(false);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13442k() throws Resources.NotFoundException {
        if (this.f13589h == null || !m13432c()) {
            return;
        }
        FilmMenuMode item = this.f13589h.getItem(3);
        item.m13508a(false);
        m13656a(item);
        this.f13589h.m13499a(this.f13588g, 3);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13443l() throws Resources.NotFoundException {
        if (this.f13589h == null || this.f13588g == null) {
            return;
        }
        FilmMenuMode item = this.f13589h.getItem(3);
        if (item.m13519e() != m13432c()) {
            item.m13508a(m13432c());
            this.f13589h.m13499a(this.f13588g, 3);
        }
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13444m() throws Resources.NotFoundException {
        super.mo13444m();
        if (this.f13585d != null && this.f13589h != null && this.f13589h.m13505b() && this.f13589h.getCount() > 0) {
            FilmMenuMode item = this.f13589h.getItem(0);
            item.m13508a(true);
            item.m13518e(false);
            item.m13520f(false);
            this.f13589h.m13503b(this.f13588g, 0, true, false);
        }
        if (this.f13591j != null) {
            Util.m24270a(this.f13591j, 8, (Animation.AnimationListener) null, 200L);
        }
        if (this.f13584c != null) {
            Util.m24270a(this.f13584c, 8, (Animation.AnimationListener) null, 200L);
        }
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13445n() throws Resources.NotFoundException {
        super.mo13445n();
        boolean z = this.f13582a != null && this.f13582a.m13585c();
        if (this.f13585d != null && this.f13589h != null && !this.f13589h.m13505b() && z && this.f13589h.getCount() > 0) {
            FilmMenuMode item = this.f13589h.getItem(0);
            item.m13508a(true);
            item.m13518e(false);
            item.m13520f(false);
            this.f13589h.m13500a(this.f13588g, 0, true);
        }
        if (this.f13591j != null) {
            Util.m24270a(this.f13591j, 0, (Animation.AnimationListener) null, 200L);
        }
        if (this.f13584c != null) {
            Util.m24270a(this.f13584c, 0, (Animation.AnimationListener) null, 200L);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13657b(int OplusGLSurfaceView_13, boolean z) {
        if (this.f13583b == null) {
            return;
        }
        FilmModeMsgData filmModeMsgData = new FilmModeMsgData(m13440i());
        filmModeMsgData.buildEventId("funcKey_click");
        if (this.f13585d != null) {
            filmModeMsgData.mCameraId = this.f13585d.mo10547aw();
        }
        if (this.f13590i != null) {
            filmModeMsgData.mCaptureMode = this.f13590i.getString(CameraUIInterface.KEY_CAMERA_MODE, "");
        }
        if (OplusGLSurfaceView_13 == 0) {
            filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_MENU_SWITCH;
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        } else if (OplusGLSurfaceView_13 == 1) {
            filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_GRID;
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        } else if (OplusGLSurfaceView_13 == 2) {
            filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_EIS;
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        } else if (OplusGLSurfaceView_13 == 3) {
            filmModeMsgData.mFuncKeyId = "3";
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        }
        filmModeMsgData.report();
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13428b(boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f13589h == null || this.f13588g == null) {
            return;
        }
        FilmMenuMode item = this.f13589h.getItem(3);
        item.m13508a(z);
        item.m13517d(z2);
        this.f13589h.m13499a(this.f13588g, 3);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13431c(boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f13589h == null || this.f13588g == null) {
            return;
        }
        FilmMenuMode item = this.f13589h.getItem(2);
        item.m13508a(z);
        item.m13517d(z2);
        this.f13589h.m13499a(this.f13588g, 2);
    }
}
