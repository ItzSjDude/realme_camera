package com.oplus.camera.filmvideomode;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.filmvideomode.FilmSubMenuItem;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButton;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.preview.PreviewFrameLayout;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FilmModeMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;

/* compiled from: FilmUIControlV2.java */
/* renamed from: com.oplus.camera.filmvideomode.q */
/* loaded from: classes2.dex */
public class FilmUIControlV2 extends BaseFilmUIControl {

    /* renamed from: s */
    protected RelativeLayout f13720s;

    /* renamed from: t */
    protected FilmSubMenuPanel f13721t;

    /* renamed from: u */
    protected FilmSubMenuAdapter f13722u;

    /* renamed from: v */
    protected GestureDetector f13723v;

    /* renamed from: w */
    protected PreviewFrameLayout f13724w;

    /* renamed from: x */
    protected ObjectAnimator f13725x;

    /* renamed from: y */
    protected ObjectAnimator f13726y;

    public FilmUIControlV2(Activity activity, OneCamera interfaceC2694d, CameraInterface interfaceC2646a, ViewGroup viewGroup) {
        super(activity);
        this.f13720s = null;
        this.f13721t = null;
        this.f13722u = null;
        this.f13723v = null;
        this.f13724w = null;
        this.f13725x = null;
        this.f13726y = null;
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
        this.f13724w = (PreviewFrameLayout) this.f13583b.findViewById(R.id_renamed.frame_layout);
        this.f13723v = new GestureDetector(m13440i(), new PlatformImplementations.kt_3());
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR) || this.f13584c.getLayoutParams() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13584c.getLayoutParams();
        layoutParams.topMargin = this.f13583b.getResources().getDimensionPixelSize(R.dimen.movie_mode_back_top) + m13440i().getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
        this.f13584c.setLayoutParams(layoutParams);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m13676f(boolean z) {
        if (this.f13720s == null) {
            this.f13721t = new FilmSubMenuPanel(m13440i());
            this.f13720s = new RelativeLayout(m13440i());
            this.f13720s.setBackground(m13440i().getResources().getDrawable(R.drawable.film_submenu_panel_bg));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_padding_top);
            layoutParams.bottomMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_padding_bottom);
            this.f13720s.addView(this.f13721t, layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(m13440i().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_width), m13440i().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_height));
        layoutParams2.addRule(10);
        layoutParams2.topMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_margin_top);
        layoutParams2.leftMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_margin_left);
        m13667A();
        this.f13720s.setRotation(90.0f);
        this.f13724w.removeView(this.f13720s);
        this.f13720s.setVisibility(8);
        this.f13724w.addView(this.f13720s, layoutParams2);
        if (z) {
            m13671b(this.f13720s);
        } else {
            this.f13720s.setVisibility(0);
        }
        m13683z();
    }

    /* renamed from: z */
    protected void m13683z() {
        this.f13593l = (ThumbImageView) this.f13583b.findViewById(R.id_renamed.thumbnail);
        if (this.f13593l != null) {
            this.f13593l.setVisibility(8);
        }
        if (this.f13591j != null) {
            this.f13591j.setVisibility(8);
        }
        if (this.f13582a != null) {
            this.f13582a.setVisibility(8);
        }
        if (this.f13585d != null) {
            this.f13585d.mo10582m(false);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void m13677g(boolean z) {
        RelativeLayout relativeLayout = this.f13720s;
        if (relativeLayout != null) {
            if (z) {
                m13673c(relativeLayout);
            } else {
                relativeLayout.setVisibility(8);
                this.f13724w.removeView(this.f13720s);
            }
        }
        m13678h(z);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void m13678h(boolean z) {
        this.f13593l = (ThumbImageView) this.f13583b.findViewById(R.id_renamed.thumbnail);
        if (this.f13593l != null) {
            if (z) {
                Util.m24271a(this.f13593l, 0, (Animation.AnimationListener) null, 50L, 150L, (Interpolator) null);
            } else {
                this.f13593l.setVisibility(0);
            }
        }
        if (this.f13591j != null) {
            Util.m24271a(this.f13591j, 0, (Animation.AnimationListener) null, 50L, 150L, (Interpolator) null);
        }
        if (this.f13582a != null) {
            Util.m24271a(this.f13582a, 0, (Animation.AnimationListener) null, 50L, 150L, (Interpolator) null);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m13671b(View view) {
        CameraLog.m12954a("FilmUIControlV2", "showSubMenuPanelAnim");
        if (this.f13725x == null) {
            this.f13725x = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            this.f13725x.setDuration(200L);
        }
        view.setVisibility(0);
        this.f13725x.start();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m13673c(final View view) {
        CameraLog.m12954a("FilmUIControlV2", "hideSubMenuPanelAnim");
        if (this.f13726y == null) {
            this.f13726y = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            this.f13726y.setDuration(200L);
            this.f13726y.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.filmvideomode.q.1
                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    view.setVisibility(8);
                    FilmUIControlV2.this.f13724w.removeView(FilmUIControlV2.this.f13720s);
                }

                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    view.setVisibility(8);
                    FilmUIControlV2.this.f13724w.removeView(FilmUIControlV2.this.f13720s);
                }
            });
        }
        this.f13726y.start();
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13404a() {
        CameraLog.m12954a("FilmUIControlV2", "initMenuList");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilmMenuMode().m13511b(false).m13514c(true).m13510b(0).m13516d(R.drawable.movie_mode_menu_bg).m13513c(R.drawable.icon_show).m13507a(R.drawable.icon_hide));
        arrayList.add(new FilmMenuMode().m13508a(m13662C()).m13510b(1).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.submenu_open).m13513c(R.drawable.submenu_close));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MOVIE_MODE_HDR_LOG)) {
            arrayList.add(new FilmMenuMode().m13508a(m13438g()).m13510b(2).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.menu_hdr_mode_on_light).m13513c(R.drawable.menu_hdr_mode_off_dark));
            arrayList.add(new FilmMenuMode().m13508a(m13429b()).m13510b(3).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.menu_log_on).m13513c(R.drawable.menu_log_off));
        }
        arrayList.add(new FilmMenuMode().m13508a(m13437f()).m13510b(4).m13516d(R.drawable.movie_mode_menu_bg).m13507a(R.drawable.super_eis_light).m13513c(R.drawable.super_eis_normal));
        if (this.f13589h == null) {
            this.f13589h = new FilmMenuAdapter(arrayList, this.f13590i, true, false);
        }
        this.f13588g.setAdapter(this.f13589h);
    }

    /* renamed from: A */
    protected void m13667A() {
        ArrayList<FilmSubMenuItem> arrayList = new ArrayList<>();
        Resources resources = m13440i().getResources();
        arrayList.add(new FilmSubMenuItem().m13650a(resources.getString(R.string.camera_film_flash_mode)).m13651a(m13432c()).m13649a(new FilmSubMenuItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.filmvideomode.q.2
            @Override // com.oplus.camera.filmvideomode.FilmSubMenuItem.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo13655a(boolean z) {
                FilmUIControlV2.this.m13680j(z);
            }
        }));
        arrayList.add(new FilmSubMenuItem().m13650a(resources.getString(R.string.camera_histogram)).m13651a(m13434d()).m13649a(new FilmSubMenuItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.filmvideomode.q.3
            @Override // com.oplus.camera.filmvideomode.FilmSubMenuItem.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo13655a(boolean z) {
                FilmUIControlV2.this.m13682l(z);
            }
        }));
        arrayList.add(new FilmSubMenuItem().m13650a(resources.getString(R.string.camera_setting_reference_line_grid)).m13651a(m13436e()).m13649a(new FilmSubMenuItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.filmvideomode.q.4
            @Override // com.oplus.camera.filmvideomode.FilmSubMenuItem.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo13655a(boolean z) {
                FilmUIControlV2.this.m13681k(z);
            }
        }));
        FilmSubMenuAdapter c2718m = this.f13722u;
        if (c2718m == null) {
            this.f13722u = new FilmSubMenuAdapter(m13440i(), arrayList);
        } else {
            c2718m.m13648a(arrayList);
        }
        this.f13721t.setAdapter((ListAdapter) this.f13722u);
    }

    /* renamed from: B */
    protected boolean m13668B() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.f13725x;
        return (objectAnimator2 != null && objectAnimator2.isRunning()) || ((objectAnimator = this.f13726y) != null && objectAnimator.isRunning());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public boolean m13662C() {
        RelativeLayout relativeLayout = this.f13720s;
        return (relativeLayout == null || relativeLayout.getVisibility() != 0 || -1 == this.f13724w.indexOfChild(this.f13720s)) ? false : true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected void m13679i(boolean z) throws Resources.NotFoundException {
        if (this.f13582a != null) {
            this.f13582a.m13581b(z);
            this.f13582a.m13586d();
        }
        if (m13662C()) {
            m13677g(true);
            this.f13589h.getItem(1).m13508a(false);
            this.f13589h.m13499a(this.f13588g, 1);
        }
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13413a(ViewGroup viewGroup) throws Resources.NotFoundException {
        if (this.f13582a != null && viewGroup != null && viewGroup.indexOfChild(this.f13582a) >= 0) {
            m13679i(false);
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
    public void onClick(View view) throws Resources.NotFoundException {
        if (view.getId() != R.id_renamed.movie_mode_back) {
            return;
        }
        if (m13662C()) {
            m13677g(false);
            this.f13589h.getItem(1).m13508a(false);
            this.f13589h.m13499a(this.f13588g, 1);
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
        if (m13440i() == null || this.f13589h == null || this.f13582a == null || this.f13582a.m13575a() || m13668B() || !z) {
            CameraLog.m12959b("FilmUIControlV2", "onMenuItemClick is intercepted, return");
            return;
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
                m13679i(false);
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
        int iM13509b = item.m13509b();
        if (iM13509b == 1) {
            m13674c(item);
        } else if (iM13509b == 2) {
            m13672b(item);
        } else if (iM13509b == 3) {
            m13675d(item);
        } else if (iM13509b == 4) {
            m13669a(item);
        }
        if (this.f13590i != null && z2) {
            this.f13590i.edit().putBoolean(CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, item.m13519e()).apply();
        }
        m13670b(item.m13509b(), item.m13519e());
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: p */
    public void mo13447p() throws Resources.NotFoundException {
        super.mo13447p();
        if (m13662C()) {
            m13677g(false);
            this.f13589h.getItem(1).m13508a(false);
            this.f13589h.m13499a(this.f13588g, 1);
        }
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

    /* renamed from: OplusGLSurfaceView_15 */
    protected void m13680j(boolean z) {
        if (this.f13587f == null || this.f13590i == null) {
            return;
        }
        m13666b(CameraUIInterface.KEY_MOVIE_FLASH_MODE);
        if (z) {
            m13418a(true, 2);
            m13418a(true, 1);
            this.f13590i.edit().putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, CameraParameter.FlashMode.FLASH_TORCH).apply();
        } else {
            this.f13590i.edit().putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").apply();
        }
        m13663D();
        m13416a("3");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13669a(FilmMenuMode c2712g) {
        if (c2712g == null || this.f13590i == null) {
            return;
        }
        m13666b(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU);
        if (c2712g.m13519e()) {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on").apply();
        } else {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "off").apply();
        }
        m13663D();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m13672b(FilmMenuMode c2712g) {
        if (c2712g == null || this.f13590i == null) {
            return;
        }
        if (c2712g.m13519e()) {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_HDR, "on").apply();
        } else {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").apply();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected void m13681k(boolean z) {
        if (this.f13590i != null) {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, z ? "grid" : "off").apply();
            m13416a(FilmModeMsgData.FUNC_KEY_ID_GRID);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    protected void m13682l(boolean z) {
        if (this.f13590i != null) {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, z ? "on" : "off").apply();
            m13416a(FilmModeMsgData.FUNC_KEY_ID_HISTOGRAM);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13666b(String str) {
        HintManager c3130aMo10518aT;
        if (this.f13585d == null || (c3130aMo10518aT = this.f13585d.mo10518aT()) == null) {
            return;
        }
        c3130aMo10518aT.m18488a(true);
        c3130aMo10518aT.m18492b(str);
    }

    /* renamed from: D */
    private void m13663D() {
        HintManager c3130aMo10518aT;
        if (this.f13585d == null || (c3130aMo10518aT = this.f13585d.mo10518aT()) == null) {
            return;
        }
        c3130aMo10518aT.m18488a(false);
        c3130aMo10518aT.m18492b((String) null);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m13674c(FilmMenuMode c2712g) {
        if (c2712g != null) {
            if (c2712g.m13519e()) {
                m13676f(true);
            } else {
                m13677g(true);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void m13675d(FilmMenuMode c2712g) {
        if (c2712g == null || this.f13590i == null) {
            return;
        }
        if (c2712g.m13519e()) {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_LOG, "on").apply();
        } else {
            this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").apply();
        }
    }

    /* renamed from: E */
    private void m13664E() {
        this.f13583b.runOnUiThread(new Runnable() { // from class: com.oplus.camera.filmvideomode.q.5
            @Override // java.lang.Runnable
            public void run() {
                if (FilmUIControlV2.this.f13722u != null) {
                    FilmUIControlV2.this.f13722u.notifyDataSetChanged();
                }
            }
        });
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13442k() {
        FilmSubMenuAdapter c2718m = this.f13722u;
        if (c2718m != null) {
            FilmSubMenuItem item = c2718m.getItem(0);
            if (item.m13652a()) {
                item.m13651a(false);
            }
            m13664E();
        }
        m13680j(false);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13443l() {
        FilmSubMenuAdapter c2718m = this.f13722u;
        if (c2718m != null) {
            FilmSubMenuItem item = c2718m.getItem(0);
            if (item.m13652a() != m13432c()) {
                item.m13651a(m13432c());
            }
            m13664E();
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
        if (this.f13582a != null && this.f13582a.getVisibility() != 0 && this.f13589h != null && (this.f13589h.m13505b() || m13662C())) {
            Util.m24270a(this.f13582a, 0, (Animation.AnimationListener) null, 200L);
        }
        if (this.f13720s == null || this.f13589h == null) {
            return;
        }
        Util.m24270a(this.f13720s, 8, (Animation.AnimationListener) null, 200L);
        this.f13589h.getItem(1).m13508a(false);
        this.f13589h.m13499a(this.f13588g, 1);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public DcsMsgData mo13403a(VideoRecordMsgData videoRecordMsgData) {
        videoRecordMsgData.mIsHistogramOpen = m13434d() ? "on" : "off";
        videoRecordMsgData.mIsLog = m13429b() ? "on" : "off";
        videoRecordMsgData.mIsMovieHdr = m13438g() ? "on" : "off";
        return videoRecordMsgData;
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
    protected void m13670b(int OplusGLSurfaceView_13, boolean z) {
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
            filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_SUBMENU;
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        } else if (OplusGLSurfaceView_13 == 2) {
            filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_HDR;
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        } else if (OplusGLSurfaceView_13 == 3) {
            filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_LOG;
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        } else if (OplusGLSurfaceView_13 == 4) {
            filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_EIS;
            filmModeMsgData.mFuncKeyResult = z ? "1" : "2";
        }
        filmModeMsgData.report();
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13431c(boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f13589h == null || this.f13588g == null) {
            return;
        }
        FilmMenuMode item = this.f13589h.getItem(4);
        item.m13508a(z);
        item.m13517d(z2);
        this.f13589h.m13499a(this.f13588g, 4);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13430c(boolean z) throws Resources.NotFoundException {
        if (this.f13589h == null || this.f13588g == null) {
            return;
        }
        this.f13589h.getItem(3).m13508a(z);
        this.f13589h.m13499a(this.f13588g, 3);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13433d(boolean z) throws Resources.NotFoundException {
        if (this.f13589h == null || this.f13588g == null) {
            return;
        }
        this.f13589h.getItem(2).m13508a(z);
        this.f13589h.m13499a(this.f13588g, 2);
    }

    @Override // com.oplus.camera.filmvideomode.BaseFilmUIControl
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13423a(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f13723v;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* compiled from: FilmUIControlV2.java */
    /* renamed from: com.oplus.camera.filmvideomode.q$PlatformImplementations.kt_3 */
    protected class PlatformImplementations.kt_3 extends GestureDetector.SimpleOnGestureListener {
        protected PlatformImplementations.kt_3() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) throws Resources.NotFoundException {
            if (FilmUIControlV2.this.m13662C()) {
                FilmUIControlV2.this.m13677g(true);
                FilmUIControlV2.this.f13589h.getItem(1).m13508a(false);
                FilmUIControlV2.this.f13589h.m13499a(FilmUIControlV2.this.f13588g, 1);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) throws Resources.NotFoundException {
            super.onLongPress(motionEvent);
            if (FilmUIControlV2.this.m13662C()) {
                FilmUIControlV2.this.m13677g(true);
                FilmUIControlV2.this.f13589h.getItem(1).m13508a(false);
                FilmUIControlV2.this.f13589h.m13499a(FilmUIControlV2.this.f13588g, 1);
            }
        }
    }
}
