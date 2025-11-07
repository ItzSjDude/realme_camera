package com.oplus.camera.filmvideomode;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.filmvideomode.FilmParamsContainer;
import com.oplus.camera.filmvideomode.FilmMenuLayout;
import com.oplus.camera.p136a.CaptureMsgDataReportUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.SwitchCameraBar;
import com.oplus.camera.p172ui.control.MainShutterButton;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FilmModeMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;

/* compiled from: BaseFilmUIControl.java */
/* renamed from: com.oplus.camera.filmvideomode.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class BaseFilmUIControl implements View.OnClickListener, FilmMenuLayout.PlatformImplementations.kt_3, FilmParamsContainer.PlatformImplementations.kt_3, FilmParamsContainer.IntrinsicsJvm.kt_4, FilmParamsContainer.IntrinsicsJvm.kt_3, FilmParamsContainer.IntrinsicsJvm.kt_5 {

    /* renamed from: s */
    private static final int[] f13581s = {R.drawable.zoom_seek_bar_ultra_angle, R.drawable.zoom_seek_bar_normal_len, R.drawable.zoom_seek_bar_tele};

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected RotateImageView f13584c;

    /* renamed from: PlatformImplementations.kt_3 */
    protected FilmParamsContainer f13582a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected Activity f13583b = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected CameraInterface f13585d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f13586e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected OneCamera f13587f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected FilmMenuLayout f13588g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected FilmMenuAdapter f13589h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    protected SharedPreferences f13590i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    protected SwitchCameraBar f13591j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    protected Drawable f13592k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    protected ThumbImageView f13593l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    protected MainShutterButton f13594m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    protected ViewGroup f13595n = null;

    /* renamed from: o */
    protected boolean f13596o = false;

    /* renamed from: p */
    protected boolean f13597p = false;

    /* renamed from: q */
    protected Rect f13598q = new Rect();

    /* renamed from: r */
    protected PlatformImplementations.kt_3 f13599r = null;

    /* renamed from: t */
    private boolean f13600t = false;

    /* renamed from: u */
    private String f13601u = "";

    /* renamed from: v */
    private String f13602v = "";

    /* renamed from: w */
    private String f13603w = "";

    /* renamed from: x */
    private String f13604x = "";

    /* renamed from: y */
    private int f13605y = -1;

    /* renamed from: z */
    private Handler f13606z = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.filmvideomode.PlatformImplementations.kt_3.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 0) {
                if (message.obj == null || BaseFilmUIControl.this.f13597p) {
                    return;
                }
                BaseFilmUIControl.this.m13391a((FilmParam) message.obj);
                return;
            }
            if (OplusGLSurfaceView_13 == 1) {
                if (BaseFilmUIControl.this.f13597p) {
                    return;
                }
                BaseFilmUIControl.this.mo13441j();
            } else if (OplusGLSurfaceView_13 == 2) {
                if (BaseFilmUIControl.this.f13597p) {
                    return;
                }
                BaseFilmUIControl.this.m13439h();
            } else {
                if (OplusGLSurfaceView_13 != 3 || BaseFilmUIControl.this.f13597p || BaseFilmUIControl.this.f13582a == null) {
                    return;
                }
                BaseFilmUIControl.this.f13582a.m13583c(message.arg1);
            }
        }
    };

    /* compiled from: BaseFilmUIControl.java */
    /* renamed from: com.oplus.camera.filmvideomode.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        Rect mo13457a();

        /* renamed from: PlatformImplementations.kt_3 */
        OplusCameraCharacteristics mo13458a(int OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m13395b(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? OplusGLSurfaceView_13 != 4 ? OplusGLSurfaceView_13 != 5 ? "" : FilmModeMsgData.FUNC_KEY_ID_WB : FilmModeMsgData.FUNC_KEY_ID_FOCUS : FilmModeMsgData.FUNC_KEY_ID_EV : FilmModeMsgData.FUNC_KEY_ID_SHUTTER : FilmModeMsgData.FUNC_KEY_ID_ISO;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13404a() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13413a(ViewGroup viewGroup) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13423a(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.oplus.camera.filmvideomode.FilmMenuLayout.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13426b(View view, View view2, int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13428b(boolean z, boolean z2) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13430c(boolean z) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13431c(boolean z, boolean z2) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13433d(boolean z) {
    }

    @Override // com.oplus.camera.filmvideomode.FilmParamsContainer.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13435e(boolean z) {
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void mo13441j() {
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13442k() {
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13443l() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* renamed from: y */
    public void m13456y() {
    }

    public BaseFilmUIControl(Activity activity) {
        this.f13584c = null;
        this.f13584c = (RotateImageView) activity.findViewById(R.id_renamed.movie_mode_back);
        if (this.f13584c == null) {
            this.f13584c = (RotateImageView) activity.getLayoutInflater().inflate(R.layout.view_movie_mode_back, (ViewGroup) activity.findViewById(R.id_renamed.camera)).findViewById(R.id_renamed.movie_mode_back);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13421a(boolean z, boolean z2) {
        if (m13440i() == null) {
            return;
        }
        boolean z3 = Util.m24451g() != this.f13605y;
        this.f13605y = Util.m24451g();
        if (this.f13582a == null || z3) {
            Activity activity = this.f13583b;
            CameraInterface interfaceC2646a = this.f13585d;
            this.f13582a = new FilmParamsContainer(activity, interfaceC2646a, this, this.f13599r.mo13458a(interfaceC2646a.mo10547aw()));
            this.f13582a.setFilmParamsStateChangeListener(this);
            this.f13582a.setId(R.id_renamed.movie_params_container_id);
            this.f13582a.setOnItemClickListener(this);
            this.f13582a.setStatisticDataWriter(this);
        }
        View viewFindViewById = this.f13595n.findViewById(R.id_renamed.movie_params_container_id);
        if (viewFindViewById == null) {
            this.f13595n.addView(this.f13582a);
        } else if (z3) {
            this.f13595n.removeView(viewFindViewById);
            this.f13595n.addView(this.f13582a);
        }
        this.f13582a.setLayoutParams(m13402z());
        this.f13582a.setVisibility(8);
        m13427b(true);
        m13389a(this.f13595n, z3);
        this.f13606z.post(new Runnable() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$PlatformImplementations.kt_3$DWeponS_FIz_4hJQLp9kz94h8Rc
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m13386F();
            }
        });
        if (this.f13591j == null || z3) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f13595n.findViewById(R.id_renamed.layout_film_switch_camera);
            if (relativeLayout != null) {
                this.f13595n.removeView(relativeLayout);
            }
            m13390a(this.f13595n, z, z2);
        } else if (!m13381A().equals(this.f13591j.getSelectValue())) {
            this.f13591j.setSelectValue(m13381A());
            this.f13591j.setSelectBg(m13381A());
            m13398b(m13381A());
        }
        this.f13606z.removeMessages(1);
        this.f13606z.sendEmptyMessageDelayed(1, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void m13386F() throws Resources.NotFoundException {
        m13383C();
        this.f13589h.m13502a(this.f13588g, false, false);
    }

    /* renamed from: z */
    private RelativeLayout.LayoutParams m13402z() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, m13440i().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_slide_bar_container_height));
        if (Util.m24498u()) {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = m13440i().getResources().getDimensionPixelOffset(R.dimen.fold_opened_movie_mode_params_left);
        } else {
            layoutParams.addRule(12);
            layoutParams.leftMargin = m13440i().getResources().getDimensionPixelOffset(R.dimen.movie_mode_params_left);
            layoutParams.rightMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_margin_right);
            layoutParams.bottomMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_bottom) + Util.m24318aG();
        }
        return layoutParams;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13389a(ViewGroup viewGroup, boolean z) throws Resources.NotFoundException {
        if (m13440i() == null) {
            return;
        }
        View view = this.f13588g;
        if (view == null || z) {
            View view2 = (FilmMenuLayout) viewGroup.findViewById(R.id_renamed.movie_menu_id);
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
            this.f13588g = new FilmMenuLayout(m13440i());
            this.f13588g.setId(R.id_renamed.movie_menu_id);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (Util.m24498u()) {
                layoutParams.addRule(14);
                layoutParams.topMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_margin_top) + (Util.getScreenWidth() / 2);
            } else {
                layoutParams.addRule(10);
                layoutParams.topMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_margin_top);
                layoutParams.leftMargin = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_margin_left);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                layoutParams.topMargin += m13440i().getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
            }
            int dimensionPixelSize = m13440i().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_width);
            this.f13588g.setMenuItemClickListener(this);
            mo13404a();
            int count = this.f13589h.getCount();
            int dimensionPixelSize2 = this.f13583b.getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_item_move_x);
            if (count < 5) {
                dimensionPixelSize2 = this.f13583b.getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_item_move_20x);
            }
            if (Util.m24498u()) {
                dimensionPixelSize2 = this.f13583b.getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_menu_item_distance);
            }
            layoutParams.width = (dimensionPixelSize * count) + ((this.f13589h.getCount() - 1) * dimensionPixelSize2);
            viewGroup.addView(this.f13588g, layoutParams);
        } else if (viewGroup.indexOfChild(view) < 0) {
            viewGroup.addView(this.f13588g);
        }
        this.f13588g.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13390a(ViewGroup viewGroup, boolean z, boolean z2) {
        if (this.f13583b == null || this.f13590i == null) {
            return;
        }
        if (!z && !z2) {
            CameraLog.m12967f("BaseFilmUIControl", "No need to display the selection SwitchCameraBar");
            return;
        }
        if (Util.m24498u()) {
            this.f13591j = (SwitchCameraBar) this.f13583b.getLayoutInflater().inflate(R.layout.switch_camera_layout_rack, viewGroup).findViewById(R.id_renamed.switch_camera_bar);
            this.f13591j.setItemRotation(270);
        } else {
            this.f13591j = (SwitchCameraBar) this.f13583b.getLayoutInflater().inflate(R.layout.switch_camera_layout, viewGroup).findViewById(R.id_renamed.switch_camera_bar);
        }
        this.f13591j.m18426a(m13381A(), z, z2, f13581s);
        this.f13591j.setRotation(90.0f);
        this.f13591j.setClickListener(new SwitchCameraBar.InterfaceC3128a() { // from class: com.oplus.camera.filmvideomode.PlatformImplementations.kt_3.2
            @Override // com.oplus.camera.p172ui.SwitchCameraBar.InterfaceC3128a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12792a(String str) {
                if (str.equals(BaseFilmUIControl.this.m13381A())) {
                    return;
                }
                BaseFilmUIControl.this.m13427b(false);
                BaseFilmUIControl.this.f13590i.edit().putString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, str).apply();
                BaseFilmUIControl.this.m13416a(FilmModeMsgData.FUNC_KEY_ID_SWITCH_CAMERA);
                BaseFilmUIControl.this.m13398b(str);
                BaseFilmUIControl.this.m13383C();
                BaseFilmUIControl.this.m13453v();
            }

            @Override // com.oplus.camera.p172ui.SwitchCameraBar.InterfaceC3128a
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12793a() {
                return (BaseFilmUIControl.this.f13585d == null || BaseFilmUIControl.this.f13585d.mo10462R() || !BaseFilmUIControl.this.f13585d.mo10540ap() || BaseFilmUIControl.this.f13585d.mo10570g() != 1 || BaseFilmUIControl.this.f13585d.mo10463S() || BaseFilmUIControl.this.f13582a == null || BaseFilmUIControl.this.f13596o || BaseFilmUIControl.this.f13582a.m13575a()) ? false : true;
            }
        });
        this.f13591j.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public String m13381A() {
        if (this.f13590i == null) {
            return "camera_main";
        }
        return this.f13590i.getString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) ? "camera_ultra_wide" : "camera_main");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean m13429b() {
        SharedPreferences sharedPreferences = this.f13590i;
        return sharedPreferences != null && sharedPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").equals("on");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean m13432c() {
        SharedPreferences sharedPreferences = this.f13590i;
        return sharedPreferences != null && sharedPreferences.getString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").equals(CameraParameter.FlashMode.FLASH_TORCH);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean m13434d() {
        SharedPreferences sharedPreferences = this.f13590i;
        return sharedPreferences != null && sharedPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, "off").equals("on");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean m13436e() {
        SharedPreferences sharedPreferences = this.f13590i;
        return sharedPreferences != null && sharedPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected boolean m13437f() {
        SharedPreferences sharedPreferences = this.f13590i;
        return sharedPreferences != null && sharedPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on").equals("on");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected boolean m13438g() {
        SharedPreferences sharedPreferences = this.f13590i;
        return sharedPreferences != null && sharedPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").equals("on");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m13439h() {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.m13574a(true);
            this.f13582a.m13586d();
        }
    }

    @Override // com.oplus.camera.filmvideomode.FilmParamsContainer.IntrinsicsJvm.kt_5
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13412a(View view, View view2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws NumberFormatException {
        if (mo13424a(view2)) {
            CameraLog.m12959b("BaseFilmUIControl", "onItemClick, position: " + OplusGLSurfaceView_13 + ", id_renamed: " + OplusGLSurfaceView_15);
            if (0 == OplusGLSurfaceView_15) {
                m13401f(true);
            } else {
                this.f13582a.m13569a(view, view2, OplusGLSurfaceView_13, OplusGLSurfaceView_15);
                m13416a(m13395b((int) OplusGLSurfaceView_15));
            }
        }
    }

    @Override // com.oplus.camera.filmvideomode.FilmParamsContainer.IntrinsicsJvm.kt_5
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13424a(View view) {
        CameraInterface interfaceC2646a;
        return (this.f13582a == null || view == null || !view.isEnabled() || (interfaceC2646a = this.f13585d) == null || !interfaceC2646a.mo10522aX()) ? false : true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m13401f(boolean z) throws NumberFormatException {
        OneCamera interfaceC2694d = this.f13587f;
        if (interfaceC2694d == null) {
            return;
        }
        interfaceC2694d.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
        m13400c(Integer.valueOf("100").intValue(), true, z);
        long OplusGLSurfaceView_15 = Long.parseLong(this.f13583b.getString(R.string.camera_exposure_time_default_value));
        this.f13587f.mo13030a(OplusGLSurfaceView_15);
        this.f13587f.mo13031a(OplusGLSurfaceView_15, false);
        this.f13587f.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
        this.f13587f.mo13103i(false);
        if (z) {
            this.f13587f.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        m13418a(true, 1);
        m13418a(true, 2);
        m13418a(true, 5);
        m13418a(true, 4);
        this.f13583b.runOnUiThread(new Runnable() { // from class: com.oplus.camera.filmvideomode.PlatformImplementations.kt_3.3
            @Override // java.lang.Runnable
            public void run() {
                BaseFilmUIControl.this.f13582a.m13589g();
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13417a(boolean z) {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.setAFEnable(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13408a(int OplusGLSurfaceView_13, boolean z) {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.m13567a(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13427b(boolean z) {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.setParamsBarEnable(z);
        }
    }

    @Override // com.oplus.camera.filmvideomode.FilmParamsContainer.IntrinsicsJvm.kt_5
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13411a(View view, View view2, int OplusGLSurfaceView_13) {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k == null) {
            return;
        }
        c2716k.m13574a(true);
    }

    @Override // com.oplus.camera.filmvideomode.FilmParamsContainer.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13407a(int OplusGLSurfaceView_13, String str, boolean z) throws Resources.NotFoundException {
        m13419a(z, str, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13419a(boolean z, String str, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        m13420a(z, str, OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13420a(boolean z, String str, int OplusGLSurfaceView_13, boolean z2) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            m13400c(Integer.parseInt(str), z, z2);
            m13399c(3);
        } else if (OplusGLSurfaceView_13 == 2) {
            m13410a(Long.parseLong(str), z, z2);
            m13399c(3);
        } else if (OplusGLSurfaceView_13 == 3) {
            m13425b(Integer.parseInt(str), z, z2);
        } else if (OplusGLSurfaceView_13 == 4) {
            m13405a(Float.parseFloat(str), z, z2);
        } else if (OplusGLSurfaceView_13 == 5) {
            m13409a(Integer.parseInt(str), z, z2);
        }
        m13399c(0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13399c(int OplusGLSurfaceView_13) {
        Message messageObtainMessage = this.f13606z.obtainMessage(3);
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.sendToTarget();
    }

    /* renamed from: B */
    private void m13382B() {
        if (!Camera.f10610l) {
            this.f13587f.mo13069b(m13432c() ? CameraParameter.FlashMode.FLASH_TORCH : "off");
        } else {
            this.f13587f.mo13069b("off");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13400c(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        if (this.f13587f != null) {
            if (z) {
                m13382B();
                this.f13587f.mo13065b(-1, z2);
                return;
            }
            CameraLog.m12954a("BaseFilmUIControl", "setISOValue, back ISOValue: " + OplusGLSurfaceView_13);
            mo13442k();
            this.f13587f.mo13065b(OplusGLSurfaceView_13, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13410a(long OplusGLSurfaceView_15, boolean z, boolean z2) {
        if (this.f13587f == null || m13440i() == null) {
            return;
        }
        if (z) {
            m13382B();
            this.f13587f.mo13031a(Long.valueOf(m13440i().getResources().getString(R.string.camera_exposure_time_default_value)).longValue(), z2);
        } else {
            CameraLog.m12954a("BaseFilmUIControl", "setExposureTime, slow shutter");
            mo13442k();
            this.f13587f.mo13031a(OplusGLSurfaceView_15, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13409a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        OneCamera interfaceC2694d = this.f13587f;
        if (interfaceC2694d == null) {
            return;
        }
        if (z) {
            interfaceC2694d.mo13028a(-1, false);
            this.f13587f.mo13103i(z2);
        } else {
            try {
                interfaceC2694d.mo13028a(OplusGLSurfaceView_13, z2);
            } catch (NumberFormatException unused) {
                this.f13587f.mo13103i(z2);
            }
        }
        CameraLog.m12954a("BaseFilmUIControl", "setWhiteBalance, whiteBalance: " + OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13405a(float COUIBaseListPopupWindow_12, boolean z, boolean z2) {
        CameraInterface interfaceC2646a;
        OneCamera interfaceC2694d = this.f13587f;
        if (interfaceC2694d == null || (interfaceC2646a = this.f13585d) == null) {
            return;
        }
        if (z) {
            int iMo13122p = interfaceC2694d.mo13122p();
            if (iMo13122p == 0) {
                this.f13600t = false;
            }
            if (3 != iMo13122p || this.f13600t) {
                this.f13587f.mo13029a(3, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                if (z2) {
                    this.f13587f.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                    return;
                }
                return;
            }
            return;
        }
        interfaceC2646a.mo10527ac();
        if (this.f13587f != null) {
            if (this.f13585d.mo10596z()) {
                this.f13585d.mo10556b(false, false);
            }
            this.f13587f.mo13023a(COUIBaseListPopupWindow_12, z2);
            this.f13600t = true;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13425b(int OplusGLSurfaceView_13, boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f13587f == null || m13440i() == null) {
            return;
        }
        if (z) {
            try {
                this.f13587f.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m13440i().getResources().getString(R.string.camera_exposure_compensation_default_value)));
                if (z2) {
                    this.f13587f.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
                CameraLog.m12954a("BaseFilmUIControl", "setExposureCompensation, defaultValue: " + OplusGLSurfaceView_13);
                return;
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("BaseFilmUIControl", "setExposureCompensation, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
                return;
            }
        }
        try {
            this.f13587f.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(OplusGLSurfaceView_13));
            if (z2) {
                this.f13587f.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            CameraLog.m12954a("BaseFilmUIControl", "setExposureCompensation, evValue: " + OplusGLSurfaceView_13);
        } catch (Exception e2) {
            CameraLog.m12967f("BaseFilmUIControl", "setExposureCompensation, COUIBaseListPopupWindow_8: " + e2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13418a(boolean z, int OplusGLSurfaceView_13) {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.m13584c(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13415a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        FilmParamsContainer c2716k;
        CaptureResult.Key<int[]> key;
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null || (c2716k = this.f13582a) == null || c2716k.getModeBarCount() == 0) {
            CameraLog.m12967f("BaseFilmUIControl", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (Util.m24169C()) {
            key = CameraMetadataKey.f13254T;
        } else {
            key = CameraMetadataKey.f13295ah;
        }
        Integer num = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        Long OplusGLSurfaceView_14 = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        int iValueOf = 0;
        Float COUIBaseListPopupWindow_12 = (Float) captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
        if (key != null) {
            try {
                iValueOf = Integer.valueOf(((int[]) captureResult.get(key))[0]);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        FilmParam filmParam = new FilmParam(iValueOf, num, OplusGLSurfaceView_14, COUIBaseListPopupWindow_12);
        Handler handler = this.f13606z;
        if (handler != null) {
            handler.removeMessages(0);
            this.f13606z.obtainMessage(0, filmParam).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m13391a(FilmParam filmParam) {
        this.f13601u = String.valueOf(filmParam.getCct());
        this.f13602v = String.valueOf(filmParam.getIso());
        this.f13603w = String.valueOf(filmParam.getExp());
        this.f13604x = String.valueOf(filmParam.getEv());
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k == null) {
            return;
        }
        c2716k.m13572a(filmParam.getIso());
        this.f13582a.m13573a(filmParam.getExp());
        this.f13582a.m13580b(filmParam.getCct());
        this.f13582a.m13571a(filmParam.getEv());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public Context m13440i() {
        Activity activity = this.f13583b;
        if (activity == null) {
            return null;
        }
        return activity;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13444m() {
        this.f13596o = true;
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.m13590h();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13445n() {
        this.f13596o = false;
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.m13591i();
        }
    }

    /* renamed from: o */
    public void m13446o() {
        ThumbImageView thumbImageView;
        if (m13440i() == null) {
            return;
        }
        this.f13597p = false;
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.setLayoutParams(m13402z());
        }
        if (this.f13594m != null) {
            ObjectAnimator.ofFloat(this.f13594m, "translationY", Util.m24498u() ? 0 : FilmAnimatorUtil.m13459a(m13440i().getResources())).setDuration(0L).start();
        }
        m13427b(true);
        if (Util.m24498u() || (thumbImageView = this.f13593l) == null) {
            return;
        }
        m13394a(thumbImageView);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13394a(ThumbImageView thumbImageView) {
        CameraLog.m12954a("BaseFilmUIControl", "resumeThumb, thumbImageView: " + thumbImageView + ", mActivity: " + this.f13583b);
        Activity activity = this.f13583b;
        if (activity != null) {
            Resources resources = activity.getResources();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = resources.getDimensionPixelSize(R.dimen.movie_mode_thumbnail_width);
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.movie_mode_thumbnail_height);
            layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.movie_mode_thumbnail_top);
            layoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.movie_mode_thumbnail_left);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                layoutParams.topMargin += resources.getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
            }
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            thumbImageView.setLayoutParams(layoutParams);
            thumbImageView.setPadding(0, 0, 0, 0);
            thumbImageView.setRotation(90.0f);
        }
    }

    /* renamed from: p */
    public void mo13447p() {
        this.f13597p = true;
        if (this.f13582a != null) {
            mo13411a((View) null, (View) null, this.f13586e);
            this.f13582a.m13586d();
        }
        Handler handler = this.f13606z;
        if (handler == null || !handler.hasMessages(1)) {
            return;
        }
        mo13441j();
    }

    /* renamed from: q */
    public void m13448q() {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k == null || c2716k.m13575a()) {
            return;
        }
        m13439h();
    }

    /* renamed from: r */
    public void m13449r() {
        this.f13582a.m13584c(4, true);
    }

    /* renamed from: s */
    public void m13450s() {
        Handler handler = this.f13606z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f13606z = null;
        }
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.setOnItemClickListener(null);
            this.f13582a.setStatisticDataWriter(null);
        }
        this.f13583b = null;
        this.f13590i = null;
        this.f13585d = null;
        this.f13587f = null;
    }

    /* renamed from: t */
    public void m13451t() {
        if (this.f13590i == null || this.f13583b == null) {
            return;
        }
        m13427b(true);
        String string = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_ISO, "auto");
        String string2 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_SHUTTER, "auto");
        String string3 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "auto");
        String string4 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto");
        String string5 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_EXPOSURE, null);
        CameraLog.m12959b("BaseFilmUIControl", "onBeforeStartPreview, iso: " + string + ", shutter: " + string2 + ", wb: " + string3 + ", af: " + string4 + ", ev: " + string5);
        if (!"auto".equals(string)) {
            m13420a(false, string, 1, false);
        } else {
            m13420a(true, "0", 1, false);
        }
        if (!"auto".equals(string2)) {
            m13420a(false, string2, 2, false);
        } else {
            m13420a(true, "0", 2, false);
        }
        if (!"auto".equals(string3)) {
            m13420a(false, string3, 5, false);
        } else {
            m13420a(true, "0", 5, false);
        }
        if (!"auto".equals(string4)) {
            m13420a(false, string4, 4, false);
        } else {
            m13420a(true, "0", 4, false);
        }
        if (string5 != null) {
            m13420a(false, string5, 3, false);
        } else {
            m13420a(true, "0", 3, false);
        }
    }

    /* renamed from: u */
    public void m13452u() {
        String string = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto");
        if (!"auto".equals(string)) {
            m13419a(false, string, 4);
        } else {
            m13419a(true, "0", 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m13383C() {
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.m13570a(this.f13599r.mo13458a(this.f13585d.mo10547aw()));
        }
    }

    /* renamed from: v */
    public void m13453v() {
        m13418a(true, 4);
        m13418a(true, 2);
        m13418a(true, 1);
        m13418a(true, 5);
    }

    /* renamed from: w */
    public void m13454w() {
        if (this.f13590i == null) {
            return;
        }
        CameraLog.m12954a("BaseFilmUIControl", "resetFilmModeParams");
        this.f13590i.edit().remove(CameraUIInterface.KEY_FILM_MODE_ISO).apply();
        this.f13590i.edit().remove(CameraUIInterface.KEY_FILM_MODE_SHUTTER).apply();
        this.f13590i.edit().remove(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE).apply();
        this.f13590i.edit().remove(CameraUIInterface.KEY_FILM_MODE_FOCUS).apply();
        this.f13590i.edit().remove(CameraUIInterface.KEY_FILM_MODE_EXPOSURE).apply();
        this.f13590i.edit().remove(CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT).apply();
        this.f13590i.edit().remove(CameraUIInterface.KEY_SWITCH_CAMERA_BAR).apply();
        m13419a(true, "0", 1);
        m13419a(true, "0", 2);
        m13419a(true, "0", 5);
        m13419a(true, "0", 4);
        m13419a(true, "0", 3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public DcsMsgData mo13403a(VideoRecordMsgData videoRecordMsgData) {
        CameraInterface interfaceC2646a = this.f13585d;
        if (interfaceC2646a != null) {
            videoRecordMsgData.mCameraId = interfaceC2646a.mo10547aw();
            videoRecordMsgData.mTouchXYValue = TextUtils.isEmpty(this.f13585d.mo10530af()) ? "0x0" : this.f13585d.mo10530af();
        }
        SharedPreferences sharedPreferences = this.f13590i;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off");
            videoRecordMsgData.mFlashTrigger = CaptureMsgDataReportUtil.m11167a(string);
            videoRecordMsgData.mFlashMode = string;
            videoRecordMsgData.mMovieCameraId = m13381A();
            videoRecordMsgData.mVideoMode = this.f13590i.getString(CameraUIInterface.KEY_CAMERA_MODE, "");
            videoRecordMsgData.mMovieSteady = m13437f() ? "on" : "off";
            String string2 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_ISO, "auto");
            String string3 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_SHUTTER, "auto");
            String string4 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "auto");
            String string5 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto");
            String string6 = this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "auto");
            videoRecordMsgData.mMovieExpTime = m13387a(2, string3, "auto");
            videoRecordMsgData.mMovieIsoValue = m13387a(1, string2, "auto");
            videoRecordMsgData.mMovieFocusValue = m13396b(4, string5, "auto");
            videoRecordMsgData.mMovieEvValue = m13396b(3, string6, "0");
            videoRecordMsgData.mMovieWbValue = m13387a(5, string4, "auto");
            videoRecordMsgData.mCct = m13387a(5, string4, this.f13601u);
            videoRecordMsgData.mIso = m13387a(1, string2, this.f13602v);
            videoRecordMsgData.mExp = m13387a(2, string3, this.f13603w);
            videoRecordMsgData.mTouchEVValue = m13387a(3, string6, this.f13604x);
        }
        videoRecordMsgData.mIsAssistantLine = Boolean.toString(m13436e());
        return videoRecordMsgData;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m13387a(int OplusGLSurfaceView_13, String str, String str2) {
        FilmParamsContainer c2716k = this.f13582a;
        return c2716k == null ? str2 : c2716k.m13564a(OplusGLSurfaceView_13, str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m13396b(int OplusGLSurfaceView_13, String str, String str2) {
        FilmParamsContainer c2716k = this.f13582a;
        return c2716k == null ? str2 : c2716k.m13577b(OplusGLSurfaceView_13, str, str2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13416a(String str) {
        if (this.f13583b == null) {
            return;
        }
        FilmModeMsgData filmModeMsgData = new FilmModeMsgData(m13440i());
        filmModeMsgData.buildEventId("funcValue_select");
        filmModeMsgData.mFuncKeyId = str;
        CameraInterface interfaceC2646a = this.f13585d;
        if (interfaceC2646a != null) {
            filmModeMsgData.mCameraId = interfaceC2646a.mo10547aw();
        }
        SharedPreferences sharedPreferences = this.f13590i;
        if (sharedPreferences != null) {
            filmModeMsgData.mCaptureMode = sharedPreferences.getString(CameraUIInterface.KEY_CAMERA_MODE, "");
            char c2 = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != 51) {
                if (iHashCode != 1636) {
                    if (iHashCode != 1638) {
                        if (iHashCode != 1699) {
                            switch (iHashCode) {
                                case 1660:
                                    if (str.equals(FilmModeMsgData.FUNC_KEY_ID_SHUTTER)) {
                                        c2 = 4;
                                        break;
                                    }
                                    break;
                                case 1661:
                                    if (str.equals(FilmModeMsgData.FUNC_KEY_ID_WB)) {
                                        c2 = 5;
                                        break;
                                    }
                                    break;
                                case 1662:
                                    if (str.equals(FilmModeMsgData.FUNC_KEY_ID_FOCUS)) {
                                        c2 = 6;
                                        break;
                                    }
                                    break;
                                case 1663:
                                    if (str.equals(FilmModeMsgData.FUNC_KEY_ID_EV)) {
                                        c2 = 7;
                                        break;
                                    }
                                    break;
                                case 1664:
                                    if (str.equals(FilmModeMsgData.FUNC_KEY_ID_ISO)) {
                                        c2 = '\IntrinsicsJvm.kt_4';
                                        break;
                                    }
                                    break;
                            }
                        } else if (str.equals(FilmModeMsgData.FUNC_KEY_ID_HISTOGRAM)) {
                            c2 = 2;
                        }
                    } else if (str.equals(FilmModeMsgData.FUNC_KEY_ID_SWITCH_CAMERA)) {
                        c2 = 0;
                    }
                } else if (str.equals(FilmModeMsgData.FUNC_KEY_ID_GRID)) {
                    c2 = 3;
                }
            } else if (str.equals("3")) {
                c2 = 1;
            }
            switch (c2) {
                case 0:
                    filmModeMsgData.mFuncKeyValue = m13381A();
                    break;
                case 1:
                    filmModeMsgData.mFuncKeyValue = m13432c() ? CameraParameter.FlashMode.FLASH_TORCH : "off";
                    break;
                case 2:
                    filmModeMsgData.mFuncKeyValue = m13434d() ? "on" : "off";
                    break;
                case 3:
                    filmModeMsgData.mFuncKeyValue = m13436e() ? "on" : "off";
                    break;
                case 4:
                    filmModeMsgData.mFuncKeyValue = m13387a(2, this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_SHUTTER, "auto"), "0");
                    break;
                case 5:
                    filmModeMsgData.mFuncKeyValue = m13387a(5, this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "auto"), "auto");
                    break;
                case 6:
                    filmModeMsgData.mFuncKeyValue = m13396b(4, this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto"), "auto");
                    break;
                case 7:
                    filmModeMsgData.mFuncKeyValue = m13396b(3, this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "auto"), "0");
                    break;
                case '\IntrinsicsJvm.kt_4':
                    filmModeMsgData.mFuncKeyValue = m13387a(1, this.f13590i.getString(CameraUIInterface.KEY_FILM_MODE_ISO, "auto"), "auto");
                    break;
            }
        }
        filmModeMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13422a(int OplusGLSurfaceView_13, int i2, boolean z) throws Resources.NotFoundException {
        Activity activity = this.f13583b;
        if (activity == null || this.f13597p) {
            return false;
        }
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.exposure_indicator_width) / 2;
        int bottom = this.f13588g.getBottom() + dimensionPixelSize;
        int iM24193U = Util.m24193U();
        int dimensionPixelSize2 = this.f13583b.getResources().getDimensionPixelSize(R.dimen.switch_camera_bar_margin_left);
        int screenWidth = Util.getScreenWidth() - this.f13583b.getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_margin_top);
        Rect rect = new Rect();
        MainShutterButton mainShutterButton = this.f13594m;
        if (mainShutterButton != null) {
            mainShutterButton.getGlobalVisibleRect(rect);
            iM24193U = rect.top;
            rect.top -= dimensionPixelSize;
        }
        this.f13598q.set(dimensionPixelSize2, bottom, screenWidth, iM24193U);
        Rect rect2 = new Rect();
        FilmParamsContainer c2716k = this.f13582a;
        if (c2716k != null) {
            c2716k.m13568a(rect2);
            rect2.top -= dimensionPixelSize;
        }
        Rect rect3 = new Rect();
        SwitchCameraBar switchCameraBar = this.f13591j;
        if (switchCameraBar != null) {
            float width = (switchCameraBar.getWidth() / 2) - (this.f13591j.getHeight() / 2);
            rect3.left = (int) (this.f13591j.getX() + width);
            rect3.top = ((int) (this.f13591j.getY() - width)) - dimensionPixelSize;
            rect3.right = rect3.left + this.f13591j.getHeight() + dimensionPixelSize;
            rect3.bottom = ((int) (this.f13591j.getY() - width)) + this.f13591j.getWidth() + dimensionPixelSize;
        }
        if (z) {
            rect3.top -= this.f13592k.getIntrinsicHeight();
        }
        Rect rect4 = new Rect();
        ThumbImageView thumbImageView = this.f13593l;
        if (thumbImageView != null) {
            rect4.left = (int) thumbImageView.getX();
            rect4.top = ((int) this.f13593l.getY()) - dimensionPixelSize;
            rect4.right = (this.f13593l.getRight() + dimensionPixelSize) - this.f13593l.getPaddingRight();
            rect4.bottom = this.f13593l.getBottom() + dimensionPixelSize;
        }
        return (!this.f13598q.contains(OplusGLSurfaceView_13, i2) || rect.contains(OplusGLSurfaceView_13, i2) || rect3.contains(OplusGLSurfaceView_13, i2) || rect4.contains(OplusGLSurfaceView_13, i2) || rect2.contains(OplusGLSurfaceView_13, i2)) ? false : true;
    }

    /* renamed from: x */
    public void m13455x() {
        CameraLog.m12954a("BaseFilmUIControl", "restoreDefaultMode, Restore UI");
        if (this.f13583b == null || this.f13582a == null || this.f13589h == null) {
            return;
        }
        m13383C();
        if (this instanceof FilmUIControlV1) {
            this.f13589h.getItem(2).m13508a(true);
        } else if (this instanceof FilmUIControlV2) {
            for (FilmMenuMode c2712g : this.f13589h.m13498a()) {
                if (4 == c2712g.m13509b()) {
                    c2712g.m13508a(true);
                }
            }
        }
        this.f13589h.m13502a(this.f13588g, false, false);
        this.f13582a.m13587e();
        if (this.f13591j != null && !m13381A().equals(this.f13591j.getSelectValue())) {
            this.f13591j.setSelectValue(m13381A());
            this.f13591j.setSelectBg(m13381A());
        }
        m13398b(m13381A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13398b(String str) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MOVIE_ULTRA_WIDE_FLASH_EIS_SUPPORT)) {
            return;
        }
        if ("camera_ultra_wide".equals(str)) {
            m13384D();
        } else {
            m13385E();
        }
    }

    /* renamed from: D */
    private void m13384D() {
        String string = this.f13590i.getString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off");
        String string2 = this.f13590i.getString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on");
        this.f13590i.edit().putString("pref_film_flash_mode_key", string).apply();
        this.f13590i.edit().putString("pref_film_eis_mode_key", string2).apply();
        this.f13590i.edit().putBoolean(CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE, false).apply();
        mo13428b(false, false);
        mo13431c(false, false);
        this.f13590i.edit().putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").apply();
        this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "off").apply();
    }

    /* renamed from: E */
    private void m13385E() {
        String string = this.f13590i.getString("pref_film_flash_mode_key", "off");
        String string2 = this.f13590i.getString("pref_film_eis_mode_key", "on");
        this.f13590i.edit().putBoolean(CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE, true).apply();
        mo13428b(CameraParameter.FlashMode.FLASH_TORCH.equals(string), true);
        mo13431c("on".equals(string2), true);
        this.f13590i.edit().putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, string).apply();
        this.f13590i.edit().putString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, string2).apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13414a(PlatformImplementations.kt_3 aVar) {
        this.f13599r = aVar;
    }

    @Override // com.oplus.camera.filmvideomode.FilmParamsContainer.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13406a(int OplusGLSurfaceView_13) {
        m13416a(m13395b(OplusGLSurfaceView_13));
    }
}
