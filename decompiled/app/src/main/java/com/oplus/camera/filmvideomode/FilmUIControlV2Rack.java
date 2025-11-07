package com.oplus.camera.filmvideomode;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: FilmUIControlV2Rack.java */
/* renamed from: com.oplus.camera.filmvideomode.r */
/* loaded from: classes2.dex */
public class FilmUIControlV2Rack extends FilmUIControlV2 {

    /* renamed from: z */
    private RelativeLayout f13734z;

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13443l() {
    }

    public FilmUIControlV2Rack(Activity activity, OneCamera interfaceC2694d, CameraInterface interfaceC2646a, ViewGroup viewGroup) {
        super(activity, interfaceC2694d, interfaceC2646a, viewGroup);
        this.f13734z = null;
        this.f13734z = (RelativeLayout) this.f13583b.findViewById(R.id_renamed.camera_root);
    }

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo13441j() throws Resources.NotFoundException {
        if (m13440i() == null || this.f13589h == null || this.f13588g == null || this.f13590i == null || this.f13582a == null || this.f13589h.getCount() == 0) {
            return;
        }
        if (Util.m24498u() || !this.f13589h.m13505b()) {
            this.f13582a.m13578b();
            this.f13589h.m13501a(this.f13588g, 0, true, true);
        }
    }

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13404a() {
        CameraLog.m12954a("FilmUIControlV2Rack", "initMenuList");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilmMenuMode().m13511b(false).m13514c(true).m13508a(m13432c()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.camera_menu_flash_on).m13513c(R.drawable.camera_menu_flash_off));
        arrayList.add(new FilmMenuMode().m13508a(m13437f()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.super_eis_light).m13513c(R.drawable.super_eis_normal));
        arrayList.add(new FilmMenuMode().m13508a(m13429b()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.menu_log_on).m13513c(R.drawable.menu_log_off));
        arrayList.add(new FilmMenuMode().m13508a(m13434d()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.ic_histogram_on).m13513c(R.drawable.ic_histogram_off));
        arrayList.add(new FilmMenuMode().m13508a(m13436e()).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.icon_tool_grid_light).m13513c(R.drawable.ic_gride_off));
        if (this.f13589h == null) {
            this.f13589h = new FilmMenuAdapter(arrayList, this.f13590i, false, true);
        }
        this.f13588g.setAdapter(this.f13589h);
    }

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13413a(ViewGroup viewGroup) {
        if (this.f13582a == null || viewGroup == null || viewGroup.indexOfChild(this.f13582a) < 0) {
            return;
        }
        m13679i(false);
        viewGroup.removeView(this.f13582a);
    }

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl, com.oplus.camera.filmvideomode.FilmMenuLayout.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13426b(View view, View view2, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        boolean z = false;
        boolean zBooleanValue = view2.getTag() instanceof Boolean ? ((Boolean) view2.getTag()).booleanValue() : false;
        if (this.f13585d != null && !this.f13585d.mo10462R() && !this.f13585d.mo10463S() && !zBooleanValue) {
            z = true;
        }
        if (m13440i() == null || this.f13589h == null || this.f13582a == null || this.f13582a.m13575a() || !z) {
            CameraLog.m12959b("FilmUIControlV2Rack", "onMenuItemClick is intercepted, return");
            return;
        }
        FilmMenuMode item = this.f13589h.getItem(OplusGLSurfaceView_13);
        item.m13508a(!item.m13519e());
        this.f13589h.m13499a(this.f13588g, OplusGLSurfaceView_13);
        if (3 == OplusGLSurfaceView_13) {
            m13682l(item.m13519e());
        }
        if (4 == OplusGLSurfaceView_13) {
            m13681k(item.m13519e());
        }
        if (2 == OplusGLSurfaceView_13) {
            m13675d(item);
        }
        if (1 == OplusGLSurfaceView_13) {
            m13669a(item);
        }
        if (OplusGLSurfaceView_13 == 0) {
            m13680j(item.m13519e());
        }
        if (this.f13590i != null) {
            this.f13590i.edit().putBoolean(CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, item.m13519e()).apply();
        }
        m13670b(OplusGLSurfaceView_13, item.m13519e());
    }

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13442k() {
        m13680j(false);
    }

    /* renamed from: C */
    private void m13684C() {
        if (this.f13588g != null) {
            Util.m24270a(this.f13588g, 8, (Animation.AnimationListener) null, 200L);
            this.f13588g.setMenuItemClickListener(null);
        }
    }

    /* renamed from: D */
    private void m13685D() {
        if (this.f13588g != null) {
            Util.m24270a(this.f13588g, 0, (Animation.AnimationListener) null, 200L);
            this.f13588g.setMenuItemClickListener(this);
        }
    }

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13444m() {
        this.f13596o = true;
        m13684C();
        if (this.f13591j != null) {
            Util.m24270a(this.f13591j, 8, (Animation.AnimationListener) null, 200L);
        }
        if (this.f13582a == null || this.f13582a.getVisibility() == 0 || this.f13589h == null || !this.f13589h.m13505b()) {
            return;
        }
        Util.m24270a(this.f13582a, 0, (Animation.AnimationListener) null, 200L);
    }

    @Override // com.oplus.camera.filmvideomode.FilmUIControlV2, com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13445n() {
        this.f13596o = false;
        if (this.f13582a != null && !this.f13582a.m13592j()) {
            m13685D();
        }
        if (this.f13591j != null) {
            Util.m24270a(this.f13591j, 0, (Animation.AnimationListener) null, 200L);
        }
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl, com.oplus.camera.filmvideomode.FilmParamsContainer.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13435e(boolean z) {
        if (z) {
            m13684C();
        } else {
            if (this.f13585d.mo10539ao()) {
                return;
            }
            m13685D();
        }
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13422a(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (this.f13583b == null || this.f13597p) {
            return false;
        }
        this.f13598q.set(this.f13599r.mo13457a());
        this.f13598q.bottom -= Util.m24198Z();
        Rect rect = new Rect();
        if (this.f13594m != null) {
            this.f13594m.getGlobalVisibleRect(rect);
        }
        Rect rect2 = new Rect();
        if (this.f13582a != null) {
            this.f13582a.m13568a(rect2);
        }
        Rect rect3 = new Rect();
        if (this.f13591j != null) {
            this.f13591j.getGlobalVisibleRect(rect3);
        }
        Rect rect4 = new Rect();
        if (this.f13593l != null) {
            this.f13593l.getGlobalVisibleRect(rect4);
        }
        return (!this.f13598q.contains(OplusGLSurfaceView_13, i2) || rect.contains(OplusGLSurfaceView_13, i2) || rect2.contains(OplusGLSurfaceView_13, i2) || rect3.contains(OplusGLSurfaceView_13, i2) || rect4.contains(OplusGLSurfaceView_13, i2)) ? false : true;
    }
}
