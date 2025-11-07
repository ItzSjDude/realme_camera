package com.oplus.camera.capmode;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.p031c.MathUtils;
import androidx.core.p034f.TextUtilsCompat;
import com.oplus.camera.VibrateManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.SwitchCameraBar;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.widget.XPanExposureWheel;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.XPanMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: XPanMode.java */
/* renamed from: com.oplus.camera.capmode.y */
/* loaded from: classes2.dex */
public class XPanMode extends BaseMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final String f13086g = "y";

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final PathInterpolator f13087h = new PathInterpolator(0.8f, 0.0f, 0.15f, 0.65f);

    /* renamed from: OplusGLSurfaceView_13 */
    private static final Size f13088i = new Size(VideoMode.VIDEO_1080P_WIDTH, 864);

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f13089j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final int f13090k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f13091l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f13092m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f13093n;

    /* renamed from: o */
    private float f13094o;

    /* renamed from: p */
    private float f13095p;

    /* renamed from: q */
    private PlatformImplementations.kt_3 f13096q;

    /* renamed from: r */
    private ImageView f13097r;

    /* renamed from: s */
    private ImageView f13098s;

    /* renamed from: t */
    private ImageButton f13099t;

    /* renamed from: u */
    private ImageButton f13100u;

    /* renamed from: v */
    private SwitchCameraBar f13101v;

    /* renamed from: w */
    private ViewGroup f13102w;

    /* renamed from: x */
    private XPanExposureWheel f13103x;

    /* renamed from: y */
    private final Runnable f13104y;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(CameraApsDecision cameraApsDecision) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_XPAN;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_HASSELBLAD_XPAN_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32940;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showBeautyButton() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public /* synthetic */ void m12789m() {
        PlatformImplementations.kt_3 aVar = this.f13096q;
        if (aVar == null || aVar.f13112f == null) {
            CameraLog.m12966e(f13086g, "CaptureAnimation, No valid frame bitmap to draw");
            this.f13097r.setVisibility(8);
        } else {
            this.f13097r.setImageDrawable(this.f13096q);
            this.f13097r.setVisibility(0);
            m12764a(8);
            this.f13096q.m12800a(3500L, new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y$anCMw6uDgQakFdnTD2zxIzeSoAM
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m12790n();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public /* synthetic */ void m12790n() {
        m12764a(0);
        this.f13097r.animate().scaleX(0.15f).scaleY(0.06f).translationXBy(this.f13094o).translationYBy(this.f13095p).setDuration(300L).withEndAction(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y$MtkKmDs8tpx0JlYs03znV11n4ds
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12791o();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void m12791o() {
        this.f13097r.setScaleX(1.0f);
        this.f13097r.setScaleY(1.0f);
        this.f13097r.setTranslationX(0.0f);
        this.f13097r.setTranslationY(0.0f);
        this.f13097r.setImageDrawable(null);
        this.f13097r.setVisibility(8);
        this.f13096q.m12799a((Bitmap) null);
        this.f13091l = false;
    }

    public XPanMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f13091l = false;
        this.f13092m = Integer.MIN_VALUE;
        this.f13093n = -1;
        this.f13096q = null;
        this.f13097r = null;
        this.f13098s = null;
        this.f13099t = null;
        this.f13100u = null;
        this.f13101v = null;
        this.f13102w = null;
        this.f13103x = null;
        this.f13104y = new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y$pBNcj-Z7x4mKREDvjGd488n8qps
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12789m();
            }
        };
        boolean z = 1 == TextUtilsCompat.m2525a(Locale.getDefault());
        this.f13094o = activity.getResources().getDimensionPixelSize(R.dimen.xpan_mode_capture_animation_trans_x);
        this.f13094o *= z ? 1.0f : -1.0f;
        this.f13095p = activity.getResources().getDimensionPixelSize(R.dimen.xpan_mode_capture_animation_trans_y);
        this.f13089j = activity.getResources().getDimensionPixelSize(R.dimen.xpan_mode_switch_camera_bar_margin_left);
        this.f13090k = activity.getResources().getDimensionPixelSize(R.dimen.xpan_mode_ev_wheel_width);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12768a(ViewGroup viewGroup, boolean z) {
        if (this.mActivity == null || this.mPreferences == null) {
            return;
        }
        if (!z) {
            CameraLog.m12959b(f13086g, "No need to display the selection SwitchCameraBar");
            return;
        }
        this.f13101v = (SwitchCameraBar) this.mActivity.getLayoutInflater().inflate(R.layout.hasselblad_xpan_switch_camera_layout, viewGroup).findViewById(R.id_renamed.switch_camera_bar);
        this.f13101v.m18426a(m12779d(), false, true, new int[]{R.drawable.icon_xpan_zoom_30mm, R.drawable.icon_xpan_zoom_45mm});
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.f13101v.getLayoutParams());
        marginLayoutParams.leftMargin = this.f13089j;
        this.f13101v.m18427a(true);
        this.f13101v.m18424a(marginLayoutParams);
        this.f13101v.setRotation(90.0f);
        this.f13101v.setClickListener(new SwitchCameraBar.InterfaceC3128a() { // from class: com.oplus.camera.capmode.y.1
            @Override // com.oplus.camera.p172ui.SwitchCameraBar.InterfaceC3128a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12792a(String str) {
                if (str.equals(XPanMode.this.m12779d())) {
                    return;
                }
                XPanMode.this.m12788l();
                XPanMode.this.mPreferences.edit().putString(CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, str).apply();
            }

            @Override // com.oplus.camera.p172ui.SwitchCameraBar.InterfaceC3128a
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12793a() {
                return XPanMode.this.f13097r.getVisibility() == 8;
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12777c() {
        if (this.f13102w == null) {
            return;
        }
        SwitchCameraBar switchCameraBar = this.f13101v;
        if (switchCameraBar != null) {
            switchCameraBar.m18424a((ViewGroup.MarginLayoutParams) null);
            this.f13102w.removeView(this.f13101v);
        }
        Util.m24270a(this.f13102w, 8, (Animation.AnimationListener) null, 0L);
        Util.m24270a(this.f13098s, 8, (Animation.AnimationListener) null, 0L);
        Util.m24270a(this.f13103x, 8, (Animation.AnimationListener) null, 0L);
        Util.m24270a(this.f13099t, 8, (Animation.AnimationListener) null, 0L);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (1 != motionEvent.getAction()) {
            return false;
        }
        this.f13093n = -1;
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getJpegOrientation(int OplusGLSurfaceView_13, int i2) {
        return CameraCharacteristicsUtil.m12975b(getCameraInfo(OplusGLSurfaceView_13), 270);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        return f13088i;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        Size sizeConfigValue;
        if ("camera_main".equals(m12779d())) {
            sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HASSELBALD_XPAN_MAIN_PICTURE_SIZE, this.mCameraId);
        } else {
            sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HASSELBALD_XPAN_WIDE_PICTURE_SIZE, this.mCameraId);
        }
        return this.mCameraInterface.mo10591u() % 180 == 0 ? new Size(sizeConfigValue.getHeight(), sizeConfigValue.getWidth()) : sizeConfigValue;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        if (Util.m24352ao()) {
            if (this.mCameraUIInterface.mo18265s() == 28 || this.mCameraUIInterface.mo18265s() == 29 || this.mCameraUIInterface.mo18265s() == 26) {
                shutterButtonInfo.m19226a(26);
            } else {
                shutterButtonInfo.m19226a(23);
            }
        }
        return shutterButtonInfo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = com.oplus.camera.entry.CameraEntry.m13305d(r4)
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1842599352: goto La6;
                case -1693318428: goto L9c;
                case -1616879029: goto L91;
                case -1593450737: goto L86;
                case -100202123: goto L7c;
                case 121201516: goto L72;
                case 336270991: goto L67;
                case 516394958: goto L5d;
                case 638398481: goto L53;
                case 839269120: goto L49;
                case 1062270711: goto L3d;
                case 1599576324: goto L32;
                case 1706373443: goto L26;
                case 1961723364: goto L1a;
                case 2115588522: goto Lf;
                default: goto Ld;
            }
        Ld:
            goto Lb1
        Lf:
            java.lang.String r0 = "pref_filter_menu"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = r2
            goto Lb2
        L1a:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 10
            goto Lb2
        L26:
            java.lang.String r0 = "pref_support_capture_preview"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 12
            goto Lb2
        L32:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 3
            goto Lb2
        L3d:
            java.lang.String r0 = "pref_time_lapse_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 9
            goto Lb2
        L49:
            java.lang.String r0 = "key_setting_support"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 6
            goto Lb2
        L53:
            java.lang.String r0 = "key_support_share_edit_thumb"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 7
            goto Lb2
        L5d:
            java.lang.String r0 = "key_setting_menu"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 4
            goto Lb2
        L67:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 8
            goto Lb2
        L72:
            java.lang.String r0 = "pref_support_recording_capture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 5
            goto Lb2
        L7c:
            java.lang.String r0 = "pref_burst_shot_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = r1
            goto Lb2
        L86:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 11
            goto Lb2
        L91:
            java.lang.String r0 = "pref_hasselblad_xpan_exposure_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 14
            goto Lb2
        L9c:
            java.lang.String r0 = "pref_manual_exposure_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 2
            goto Lb2
        La6:
            java.lang.String r0 = "key_full_screen_center_support"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 13
            goto Lb2
        Lb1:
            r0 = -1
        Lb2:
            switch(r0) {
                case 0: goto Ld5;
                case 1: goto Ld5;
                case 2: goto Ld5;
                case 3: goto Ld5;
                case 4: goto Ld5;
                case 5: goto Ld5;
                case 6: goto Ld5;
                case 7: goto Ld5;
                case 8: goto Ld5;
                case 9: goto Ld5;
                case 10: goto Lc8;
                case 11: goto Lbb;
                case 12: goto Lba;
                case 13: goto Lba;
                case 14: goto Lba;
                default: goto Lb5;
            }
        Lb5:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        Lba:
            return r1
        Lbb:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_watermark"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        Lc8:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_filter"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        Ld5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.XPanMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21317g.m22561a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m12779d() {
        return this.mPreferences == null ? "camera_main" : this.mPreferences.getString(CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, "camera_main");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m12781e() {
        if (this.f13102w == null) {
            ViewStub viewStub = (ViewStub) this.mActivity.findViewById(R.id_renamed.xpan_mode_viewstub);
            if (viewStub == null) {
                CameraLog.m12967f(f13086g, "initXPanUI, Failed to inflate stub");
                return;
            }
            this.f13102w = (ViewGroup) viewStub.inflate().findViewById(R.id_renamed.xpan_mode_ui_container);
            if (this.f13102w == null) {
                CameraLog.m12967f(f13086g, "initXPanUI, Failed to find container");
                return;
            }
            CameraLog.m12954a(f13086g, "initXPanUI, XPAN ui inflated");
            this.f13103x = (XPanExposureWheel) this.f13102w.findViewById(R.id_renamed.xpan_exposure_wheel);
            if (this.f13103x != null) {
                OplusCameraCharacteristics c2698hM12971a = CameraCharacteristicsUtil.m12971a(getCameraMode(), this.mCameraInterface.mo10547aw());
                if (c2698hM12971a == null) {
                    CameraLog.m12967f(f13086g, "initXPanUI, Invalid CameraCharacteristics");
                    return;
                } else {
                    this.f13103x.m24077a(new XPanExposureWheel.InterfaceC3517b() { // from class: com.oplus.camera.capmode.-$$Lambda$y$sFV432XfGm3pEAO_gVncjNoLRd4
                        @Override // com.oplus.camera.p172ui.widget.XPanExposureWheel.InterfaceC3517b
                        public final void onExposureChanged(int OplusGLSurfaceView_13) {
                            this.COUIBaseListPopupWindow_12$0.m12772b(OplusGLSurfaceView_13);
                        }
                    });
                    this.f13103x.m24076a(c2698hM12971a.m13281p(), c2698hM12971a.m13282q());
                }
            }
            this.f13100u = (ImageButton) this.f13102w.findViewById(R.id_renamed.xpan_mode_filter_toggle_btn);
            ImageButton imageButton = this.f13100u;
            if (imageButton != null) {
                imageButton.setVisibility(0);
                this.f13100u.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y$NPbov7s7zng74yzpXMga034xqfc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.COUIBaseListPopupWindow_12$0.m12773b(view);
                    }
                });
            }
            this.f13098s = (ImageView) this.f13102w.findViewById(R.id_renamed.dash_line_view);
            this.f13099t = (ImageButton) this.f13102w.findViewById(R.id_renamed.xpan_mode_exit_btn);
            ImageButton imageButton2 = this.f13099t;
            if (imageButton2 != null) {
                imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y$jqK18NlDmC_5Lb1Sb68VL-bF5gI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.COUIBaseListPopupWindow_12$0.m12766a(view);
                    }
                });
            }
            this.f13097r = (ImageView) this.f13102w.findViewById(R.id_renamed.invertedColorPreviewCover);
        } else {
            CameraLog.m12954a(f13086g, "initXPanUI, container is already existed");
            this.f13102w.setVisibility(0);
        }
        m12768a(this.f13102w, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HASSELBALD_XPAN_WIDE_PICTURE_SIZE, 0) != null);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18147ak();
            this.mCameraUIInterface.mo18282w(true);
            this.mCameraUIInterface.mo18148al();
            this.mCameraUIInterface.mo18024B(true);
            this.mCameraUIInterface.mo18218g(true, true);
        } else {
            CameraLog.m12967f(f13086g, "initXPanUI, No mCameraUIInterface");
        }
        m12786j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m12772b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(f13086g, "onExposureChanged, value: " + OplusGLSurfaceView_13);
        if (this.f13092m == Integer.MIN_VALUE) {
            this.f13092m = OplusGLSurfaceView_13;
        }
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(OplusGLSurfaceView_13));
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        VibrateManager c2613aeMo10528ad = this.mCameraInterface.mo10528ad();
        if (c2613aeMo10528ad != null && this.f13092m != OplusGLSurfaceView_13) {
            c2613aeMo10528ad.m11292d();
        }
        this.f13092m = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m12773b(View view) {
        m12783g();
        m12786j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m12766a(View view) {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10501aC();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        m12782f();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m12782f() {
        new XPanMsgData(this.mActivity, isFilterEffectOpen(), this.mCameraId).report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        if (dcsMsgData == null || dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            return null;
        }
        CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
        captureMsgData.mCaptureMode = getCameraMode();
        if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
            captureMsgData.mFilterType = getCurrFilterType();
        }
        captureMsgData.mTouchEVValue = this.f13092m;
        return (CaptureMsgData) super.onGetBeforeCaptureMsgCommonData(captureMsgData);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetAfterCaptureMsgCommonData(DcsMsgData dcsMsgData, Storage.CameraPicture cameraPicture) {
        CaptureMsgData captureMsgData;
        if (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            captureMsgData = null;
        } else {
            captureMsgData = (CaptureMsgData) dcsMsgData;
            if (TextUtils.equals("camera_ultra_wide", this.mPreferences.getString(CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, "camera_main"))) {
                captureMsgData.mIsWideAngle = "on";
            } else {
                captureMsgData.mIsWideAngle = "off";
            }
        }
        return (CaptureMsgData) super.onGetAfterCaptureMsgCommonData(captureMsgData, cameraPicture);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        m12781e();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18167b(4, true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m12783g() {
        String filterEffectMenuPreferenceKey = getFilterEffectMenuPreferenceKey();
        if (this.mPreferences.getInt(filterEffectMenuPreferenceKey, FilterHelper.f21279a) == FilterHelper.f21279a) {
            this.mOneCamera.mo13046a("Delta400.3dl.rgb.bin", isFilterOpen("Delta400.3dl.rgb.bin"), false);
            this.mPreviewEffectProcess.mo22792a("Delta400.3dl.rgb.bin");
            this.mPreferences.edit().putInt(filterEffectMenuPreferenceKey, FilterHelper.f21317g.f21248b.indexOf("Delta400.3dl.rgb.bin")).apply();
        } else {
            this.mOneCamera.mo13046a("default", false, false);
            this.mPreviewEffectProcess.mo22792a("default");
            this.mPreferences.edit().putInt(filterEffectMenuPreferenceKey, FilterHelper.f21279a).apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        m12777c();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18146aj();
            this.mCameraUIInterface.mo18148al();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        PlatformImplementations.kt_3 aVar = this.f13096q;
        if ((aVar != null && (aVar.m12798a() == PlatformImplementations.kt_3.XPanMode_4.ANIMATION_ANIMATING || this.f13096q.m12798a() == PlatformImplementations.kt_3.XPanMode_4.ANIMATION_STARTED)) || this.f13097r.getVisibility() == 0) {
            CameraLog.m12959b(f13086g, "onBackPressed() - Invalid state, ignore back pressed");
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        m12784h();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        m12787k();
        if (this.f13096q == null || PlatformImplementations.kt_3.XPanMode_4.ANIMATION_ANIMATING != this.f13096q.m12798a()) {
            m12788l();
        }
        this.mCameraUIInterface.mo18232j(true, false);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m12784h() {
        if (this.f13092m != Integer.MIN_VALUE) {
            CameraLog.m12959b(f13086g, "syncExposureWithEvWheel, current ev: " + this.f13092m);
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(this.f13092m));
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        if ("camera_main".equals(m12779d())) {
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<int[]>>) CameraParameter.HASSELBLAD_XPAN_CROP_REGION, (CameraParameter.PreviewKey<int[]>) new int[]{64, 360, 7872, 2916});
            return true;
        }
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<int[]>>) CameraParameter.HASSELBLAD_XPAN_CROP_REGION, (CameraParameter.PreviewKey<int[]>) new int[]{320, 463, 7552, 2798});
        return true;
    }

    /* compiled from: XPanMode.java */
    /* renamed from: com.oplus.camera.capmode.y$2, reason: invalid class name */
    class XPanMode_2 extends SurfaceTextureScreenNail.IntrinsicsJvm.kt_4 {
        XPanMode_2() {
        }

        @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10414a(Integer num, final Bitmap bitmap, long OplusGLSurfaceView_15, long j2, CaptureResult captureResult) {
            CameraLog.m12954a(XPanMode.f13086g, "onPreviewCaptured, timestamp: " + j2 + ", bitmap: " + bitmap + ", width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
            XPanMode.this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y$2$RNKW3bNtx9oRl6GTyvUB2s4ClEo
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m12794b(bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m12794b(Bitmap bitmap) {
            XPanMode.this.m12765a(bitmap);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onStartCapturePreviewData() {
        this.mCameraUIInterface.mo18088a((SurfaceTextureScreenNail.IntrinsicsJvm.kt_4) new XPanMode_2(), true, getNeedCheckTimeStamp(), SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14255f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12765a(Bitmap bitmap) {
        CameraLog.m12959b(f13086g, "onPreviewFrameCaptured, bitmap width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
        PlatformImplementations.kt_3 aVar = this.f13096q;
        if (aVar == null) {
            this.f13096q = new PlatformImplementations.kt_3();
        } else {
            aVar.m12799a((Bitmap) null);
        }
        this.f13096q.m12799a(bitmap);
        if (this.f13091l) {
            m12785i();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        this.mCameraUIInterface.mo18200d(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        if (!z2) {
            CameraLog.m12954a(f13086g, "isBurstShot: " + z + ", isFirst: " + z2);
            return;
        }
        this.mCameraInterface.mo10558c(0);
        this.f13097r.setVisibility(0);
        m12785i();
        this.f13091l = true;
        super.onShutterCallback(z, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
        if (motionEvent2.getPointerCount() != 1) {
            CameraLog.m12959b(f13086g, "onScroll, Ignore multi-fingers.");
            return false;
        }
        if (Math.abs(COUIBaseListPopupWindow_12) >= Math.abs(f2)) {
            return m12770a(motionEvent, motionEvent2);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12770a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        XPanExposureWheel xPanExposureWheel = this.f13103x;
        if (xPanExposureWheel == null) {
            return false;
        }
        if (this.f13093n == -1) {
            this.f13093n = xPanExposureWheel.getValue();
        }
        int x = (int) ((((motionEvent.getX() - motionEvent2.getX()) / this.f13090k) * this.f13103x.getMaxValue()) / 10.0f);
        int OplusGLSurfaceView_13 = this.f13093n;
        int i2 = x * 10;
        if (OplusGLSurfaceView_13 + i2 >= 0 && OplusGLSurfaceView_13 + i2 < 5) {
            this.f13103x.setValue(0);
            return true;
        }
        if (this.f13103x.getMaxValue() - 5 <= this.f13093n + i2 && this.f13103x.getValue() < this.f13093n + i2) {
            XPanExposureWheel xPanExposureWheel2 = this.f13103x;
            xPanExposureWheel2.setValue(xPanExposureWheel2.getMaxValue());
            return true;
        }
        this.f13103x.setValue(this.f13093n + i2);
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m12785i() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.mActivity.runOnUiThread(this.f13104y);
        } else {
            this.f13104y.run();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12764a(int OplusGLSurfaceView_13) {
        Util.m24270a(this.f13098s, OplusGLSurfaceView_13, (Animation.AnimationListener) null, OplusGLSurfaceView_13 == 8 ? 0L : 300L);
        Util.m24270a(this.f13103x, OplusGLSurfaceView_13, (Animation.AnimationListener) null, OplusGLSurfaceView_13 == 8 ? 0L : 300L);
        Util.m24270a(this.f13100u, OplusGLSurfaceView_13, (Animation.AnimationListener) null, OplusGLSurfaceView_13 == 8 ? 0L : 300L);
        Util.m24270a(this.f13099t, OplusGLSurfaceView_13, (Animation.AnimationListener) null, OplusGLSurfaceView_13 == 8 ? 0L : 300L);
        Util.m24270a(this.f13101v, OplusGLSurfaceView_13, (Animation.AnimationListener) null, OplusGLSurfaceView_13 != 8 ? 300L : 0L);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m12786j() {
        if (this.f13100u == null) {
            return;
        }
        this.f13100u.setSelected(this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), FilterHelper.f21279a) != FilterHelper.f21279a);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m12787k() {
        if (this.f13102w == null || this.f13097r == null || this.mCameraUIInterface == null) {
            return;
        }
        RelativeLayout relativeLayoutMo18253p = this.mCameraUIInterface.mo18253p();
        if (relativeLayoutMo18253p == null) {
            CameraLog.m12959b(f13086g, "updateCaptureAnimationImageView, viewFinderLayout is not available");
            return;
        }
        CameraLog.m12959b(f13086g, "updateCaptureAnimationImageView, viewFinderLayout width: " + relativeLayoutMo18253p.getWidth() + ", height: " + relativeLayoutMo18253p.getHeight());
        ViewGroup.LayoutParams layoutParams = this.f13097r.getLayoutParams();
        layoutParams.width = relativeLayoutMo18253p.getWidth();
        layoutParams.height = relativeLayoutMo18253p.getHeight();
        this.f13097r.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m12788l() {
        if (this.f13102w == null || this.f13098s == null) {
            return;
        }
        float height = this.mCameraUIInterface.mo18253p().getHeight() * (TextUtils.equals("camera_ultra_wide", this.mPreferences.getString(CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, "camera_main")) ? 0.9218f : 0.984f);
        float screenHeight = (Util.getScreenHeight() - height) / 2.0f;
        float screenWidth = (Util.getScreenWidth() - (height / 2.7f)) / 2.0f;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ViewGroup.LayoutParams layoutParams = this.f13098s.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            float COUIBaseListPopupWindow_12 = marginLayoutParams.topMargin;
            float f2 = marginLayoutParams.bottomMargin;
            float f3 = marginLayoutParams.leftMargin;
            float f4 = marginLayoutParams.rightMargin;
            float f5 = screenHeight - 6.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(COUIBaseListPopupWindow_12, f5);
            valueAnimatorOfFloat.setDuration(150L);
            valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y$dStWm83G88wqCytSrPVCyEXmqxU
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m12780d(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat);
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f2, f5);
            valueAnimatorOfFloat2.setDuration(150L);
            valueAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y$PPGK-2zoX4P4w9shmtadKRd2zWE
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XPanMode.m12778c(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat2);
            float f6 = screenWidth - 6.0f;
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(f3, f6);
            valueAnimatorOfFloat3.setDuration(150L);
            valueAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y$NVrce6vqb5FteICerDiiS57fdI4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XPanMode.m12774b(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat3);
            ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(f4, f6);
            valueAnimatorOfFloat4.setDuration(150L);
            valueAnimatorOfFloat4.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y$7xuwn04CC0zVf09-ApgIKAcc75g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XPanMode.m12767a(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat4);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
        ImageView imageView = this.f13098s;
        if (imageView == null || 8 != imageView.getVisibility()) {
            return;
        }
        Util.m24270a(this.f13101v, 0, (Animation.AnimationListener) null, 0L);
        Util.m24270a(this.f13098s, 0, (Animation.AnimationListener) null, 0L);
        Util.m24270a(this.f13103x, 0, (Animation.AnimationListener) null, 0L);
        Util.m24270a(this.f13099t, 0, (Animation.AnimationListener) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m12780d(ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        marginLayoutParams.topMargin = ((Float) valueAnimator.getAnimatedValue()).intValue();
        this.f13098s.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static /* synthetic */ void m12778c(ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        marginLayoutParams.bottomMargin = ((Float) valueAnimator.getAnimatedValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ void m12774b(ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        marginLayoutParams.leftMargin = ((Float) valueAnimator.getAnimatedValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m12767a(ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        marginLayoutParams.rightMargin = ((Float) valueAnimator.getAnimatedValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XPanMode.java */
    /* renamed from: com.oplus.camera.capmode.y$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends Drawable {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Paint f13107a = new Paint();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Paint f13108b = new Paint();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Paint f13109c = new Paint();

        /* renamed from: IntrinsicsJvm.kt_5 */
        private long f13110d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private long f13111e = 0;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private Bitmap f13112f = null;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private Bitmap f13113g = null;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private Runnable f13114h = null;

        /* renamed from: OplusGLSurfaceView_13 */
        private XPanMode_4 f13115i = XPanMode_4.ANIMATION_IDLE;

        /* compiled from: XPanMode.java */
        /* renamed from: com.oplus.camera.capmode.y$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        enum XPanMode_4 {
            ANIMATION_IDLE,
            ANIMATION_STARTED,
            ANIMATION_ANIMATING,
            ANIMATING_COMPLETED
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int OplusGLSurfaceView_13) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public PlatformImplementations.kt_3() {
            this.f13108b.setColor(-16777216);
            this.f13108b.setStyle(Paint.Style.FILL);
            this.f13107a.setFilterBitmap(true);
            this.f13107a.setColorFilter(new ColorMatrixColorFilter(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
            this.f13109c.setFilterBitmap(true);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.drawRect(bounds, this.f13108b);
            Bitmap bitmap = this.f13113g;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, bounds, this.f13109c);
            }
            Bitmap bitmap2 = this.f13112f;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (Rect) null, bounds, this.f13107a);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public XPanMode_4 m12798a() {
            return this.f13115i;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m12799a(Bitmap bitmap) {
            this.f13112f = null;
            this.f13113g = null;
            this.f13115i = XPanMode_4.ANIMATION_IDLE;
            if (bitmap != null) {
                this.f13112f = bitmap.copy(bitmap.getConfig(), false);
                this.f13113g = bitmap.copy(bitmap.getConfig(), false);
            }
            invalidateSelf();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m12800a(Long OplusGLSurfaceView_14, Runnable runnable) {
            this.f13114h = runnable;
            this.f13110d = OplusGLSurfaceView_14.longValue();
            this.f13111e = SystemClock.elapsedRealtime();
            this.f13115i = XPanMode_4.ANIMATION_STARTED;
            m12797b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m12797b() {
            if (this.f13111e <= 0 || this.f13110d <= 0) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long OplusGLSurfaceView_15 = this.f13111e;
            long j2 = jElapsedRealtime - OplusGLSurfaceView_15;
            if (OplusGLSurfaceView_15 > 0 && j2 < this.f13110d) {
                this.f13115i = XPanMode_4.ANIMATION_ANIMATING;
                scheduleSelf(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y$PlatformImplementations.kt_3$cbTmxWegEk4ICSSIILDrMmgfU-0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m12797b();
                    }
                }, SystemClock.uptimeMillis() + 33);
                m12796a(Long.valueOf(j2));
                invalidateSelf();
            } else {
                this.f13115i = XPanMode_4.ANIMATING_COMPLETED;
                this.f13111e = 0L;
                this.f13114h.run();
            }
            invalidateSelf();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m12796a(Long OplusGLSurfaceView_14) {
            this.f13107a.setAlpha((int) ((1.0f - XPanMode.f13087h.getInterpolation(MathUtils.m2446a(OplusGLSurfaceView_14.floatValue() / this.f13110d, 0.0f, 1.0f))) * 255.0f));
        }
    }
}
