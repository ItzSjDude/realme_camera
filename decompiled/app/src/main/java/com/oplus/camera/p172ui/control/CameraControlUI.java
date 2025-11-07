package com.oplus.camera.p172ui.control;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ConditionVariable;
import android.os.Process;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.app.OPlusAccessControlManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.algovisualization.DataProcessorUtils;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.CameraUIAttributes;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.control.ShutterButton;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.p175a.HeadlineBackground;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import com.oplus.camera.p172ui.menu.p175a.ModeArrangeDecoration;
import com.oplus.camera.p172ui.menu.p175a.ModePickerView;
import com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu;
import com.oplus.camera.p172ui.modepanel.ItemDragHelper;
import com.oplus.camera.p172ui.modepanel.ModeAdapter;
import com.oplus.camera.p172ui.modepanel.ModeInfo;
import com.oplus.camera.p172ui.modepanel.ModeArrangeListener;
import com.oplus.camera.p172ui.modepanel.SmoothScrollLayoutManager;
import com.oplus.camera.p172ui.widget.AnimationButton;
import com.oplus.camera.p172ui.widget.LockViewDragLayout;
import com.oplus.camera.p172ui.widget.VideoClipView;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.screen.ScreenModeManager;
import com.oplus.camera.screen.p163a.OutCaptureManager;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.Util;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.p078a.p079a.SimpleSpringListener;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import com.p078a.p079a.SpringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CameraControlUI.java */
/* renamed from: com.oplus.camera.ui.control.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CameraControlUI implements View.OnClickListener, CameraConstant, ShutterButton.OnShutterButtonListener, ModePickerView.COUIBaseListPopupWindow_8 {

    /* renamed from: A */
    private Activity f18137A;

    /* renamed from: B */
    private ComboPreferences f18138B;

    /* renamed from: D */
    private CameraUIListener f18140D;

    /* renamed from: ah */
    private ContentResolver f18179ah;

    /* renamed from: al */
    private ScreenModeManager f18183al;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f18201j;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f18203l;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f18198g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f18199h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f18200i = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f18202k = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f18204m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f18205n = false;

    /* renamed from: o */
    private boolean f18206o = false;

    /* renamed from: p */
    private boolean f18207p = false;

    /* renamed from: q */
    private boolean f18208q = true;

    /* renamed from: r */
    private boolean f18209r = false;

    /* renamed from: s */
    private boolean f18210s = false;

    /* renamed from: t */
    private int f18211t = 1;

    /* renamed from: u */
    private int f18212u = 0;

    /* renamed from: v */
    private int f18213v = -1;

    /* renamed from: w */
    private long f18214w = 0;

    /* renamed from: x */
    private int f18215x = 0;

    /* renamed from: y */
    private AsyncTask<Void, Void, Thumbnail> f18216y = null;

    /* renamed from: z */
    private Bitmap f18217z = null;

    /* renamed from: C */
    private CameraControlButtonListener f18139C = null;

    /* renamed from: E */
    private RelativeLayout f18141E = null;

    /* renamed from: F */
    private View f18142F = null;

    /* renamed from: G */
    private LockViewDragLayout f18143G = null;

    /* renamed from: H */
    private RelativeLayout f18144H = null;

    /* renamed from: I */
    private RelativeLayout f18145I = null;

    /* renamed from: J */
    private RotateImageView f18146J = null;

    /* renamed from: K */
    private RotateImageView f18147K = null;

    /* renamed from: L */
    private RotateImageView f18148L = null;

    /* renamed from: M */
    private ShutterButton f18149M = null;

    /* renamed from: N */
    private MainShutterButton f18150N = null;

    /* renamed from: O */
    private ShutterButton f18151O = null;

    /* renamed from: P */
    private ShutterButton f18152P = null;

    /* renamed from: Q */
    private ShutterButton f18153Q = null;

    /* renamed from: R */
    private ShutterButton f18154R = null;

    /* renamed from: S */
    private ShutterButton f18155S = null;

    /* renamed from: T */
    private ThumbImageView f18156T = null;

    /* renamed from: U */
    private Thumbnail f18157U = null;

    /* renamed from: V */
    private ThumbnailClickListener f18158V = null;

    /* renamed from: W */
    private ConditionVariable f18159W = new ConditionVariable();

    /* renamed from: X */
    private ShareEditThumbMenu f18160X = null;

    /* renamed from: Y */
    private TextView f18161Y = null;

    /* renamed from: Z */
    private TextView f18162Z = null;

    /* renamed from: aa */
    private ModeTypeChangedListener f18172aa = null;

    /* renamed from: ab */
    private LinearLayoutManager f18173ab = null;

    /* renamed from: ac */
    private HeadlineBackground f18174ac = null;

    /* renamed from: ad */
    private ModePickerView f18175ad = null;

    /* renamed from: ae */
    private HeadlineHelper f18176ae = new HeadlineHelper();

    /* renamed from: af */
    private List<Integer> f18177af = null;

    /* renamed from: ag */
    private int f18178ag = 0;

    /* renamed from: ai */
    private Thumbnail f18180ai = null;

    /* renamed from: aj */
    private RotateImageView f18181aj = null;

    /* renamed from: ak */
    private VideoClipView f18182ak = null;

    /* renamed from: am */
    private Spring f18184am = null;

    /* renamed from: an */
    private Spring f18185an = null;

    /* renamed from: ao */
    private boolean f18186ao = false;

    /* renamed from: ap */
    private boolean f18187ap = false;

    /* renamed from: aq */
    private boolean f18188aq = false;

    /* renamed from: ar */
    private boolean f18189ar = false;

    /* renamed from: as */
    private COUIRecyclerView f18190as = null;

    /* renamed from: at */
    private ModeArrangeDecoration f18191at = null;

    /* renamed from: au */
    private ModeAdapter f18192au = null;

    /* renamed from: av */
    private GestureDetector f18193av = null;

    /* renamed from: aw */
    private ItemDragHelper f18194aw = null;

    /* renamed from: ax */
    private ViewGroup f18195ax = null;

    /* renamed from: ay */
    private ImageView f18196ay = null;

    /* renamed from: az */
    private ViewGroup f18197az = null;

    /* renamed from: aA */
    private AnimationButton f18163aA = null;

    /* renamed from: aB */
    private ValueAnimator f18164aB = null;

    /* renamed from: aC */
    private ModeArrangeListener f18165aC = null;

    /* renamed from: aD */
    private View f18166aD = null;

    /* renamed from: aE */
    private int f18167aE = 0;

    /* renamed from: aF */
    private ShutterButton.OnShutterButtonListener f18168aF = new ShutterButton.OnShutterButtonListener() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.1
        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: L */
        public boolean mo18968L() {
            return true;
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18970a(ShutterButton shutterButton, boolean z) {
            if (CameraControlUI.this.f18139C != null) {
                CameraControlUI.this.f18139C.mo10899b(z);
            }
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18969a(ShutterButton shutterButton) {
            CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, ShutterButton.id_renamed: " + shutterButton.getId());
            DataProcessorUtils.m11623a(System.currentTimeMillis());
            if (!CameraControlUI.this.m19129ap()) {
                if (CameraControlUI.this.f18175ad != null && CameraControlUI.this.f18175ad.m20455d(1)) {
                    CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, ModePickerView follow finger can't response");
                    return;
                }
                if (PopUpWindowManager.m20706a()) {
                    PopUpWindowManager.m20704a(true);
                    CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, camera menu is popup....");
                }
                CameraLog.m12955a("CameraCapturePerformance.onShutterButtonClick", "00ct_ShutterButtonClick", CameraConstant.f13119d.longValue());
                if (CameraControlUI.this.f18211t == 3) {
                    CameraControlUI.this.f18139C.mo10908j();
                } else if (CameraControlUI.this.f18140D.mo10803bt()) {
                    CameraControlUI.this.f18140D.mo10802bs();
                    CameraControlUI.this.m19126am();
                    CameraControlUI.this.f18140D.mo10805bv();
                    LockViewDragLayout.setVolumeDownState(false);
                } else if (!CameraControlUI.this.f18140D.mo10814c() || !CameraControlUI.this.f18140D.mo10848h(CameraUIInterface.KEY_SHORT_VIDEO)) {
                    CameraControlUI.this.f18139C.mo10906h();
                } else {
                    CameraControlUI.this.f18140D.mo10647A();
                    CameraControlUI.this.m19126am();
                    LockViewDragLayout.setVolumeDownState(false);
                }
                CameraLog.m12964d("CameraCapturePerformance.onShutterButtonClick", "00ct_ShutterButtonClick");
                return;
            }
            CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, moreTab is showing....");
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo18971b(ShutterButton shutterButton) {
            CameraLog.m12954a("CameraControlUI", "onShutterButtonLongClick, ShutterButton.id_renamed: " + shutterButton.getId());
            if (!CameraControlUI.this.m19129ap()) {
                if (CameraControlUI.this.f18175ad != null && CameraControlUI.this.f18175ad.m20455d(1)) {
                    CameraLog.m12954a("CameraControlUI", "onShutterButtonLongClick, ModePickerView follow finger can't response");
                    return;
                }
                if (PopUpWindowManager.m20706a()) {
                    PopUpWindowManager.m20712d();
                }
                CameraLog.m12955a("CameraCapturePerformance.onShutterButtonLongClick", "01ct_ShutterButtonLongClick", CameraConstant.f13119d.longValue());
                if (CameraControlUI.this.f18139C != null && shutterButton.getId() == R.id_renamed.shutter_button) {
                    CameraControlUI.this.f18139C.mo10907i();
                }
                CameraLog.m12964d("CameraCapturePerformance.onShutterButtonLongClick", "01ct_ShutterButtonLongClick");
                return;
            }
            CameraLog.m12954a("CameraControlUI", "onShutterButtonLongClick, moreTab is showing....");
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo18972c(ShutterButton shutterButton) throws Resources.NotFoundException {
            if (CameraControlUI.this.f18139C == null || shutterButton == null || shutterButton.getId() != R.id_renamed.shutter_button) {
                return;
            }
            CameraControlUI.this.f18139C.mo10901c(false);
            if (CameraControlUI.this.f18140D == null || !CameraControlUI.this.f18140D.mo10803bt() || LockViewDragLayout.getMoveStatus()) {
                if (CameraControlUI.this.f18140D == null || !CameraControlUI.this.f18140D.mo10848h(CameraUIInterface.KEY_SHORT_VIDEO) || LockViewDragLayout.getMoveStatus()) {
                    return;
                }
                CameraControlUI.this.f18140D.mo10647A();
                CameraControlUI.this.f18143G.setShowAdhesion(false);
                CameraControlUI.this.f18143G.setShowLine(false);
                CameraControlUI.this.f18143G.m24027d();
                LockViewDragLayout.setVolumeDownState(false);
                return;
            }
            CameraControlUI.this.f18140D.mo10802bs();
            CameraControlUI.this.f18143G.setShowAdhesion(false);
            CameraControlUI.this.f18143G.setShowLine(false);
            CameraControlUI.this.f18143G.m24027d();
            CameraControlUI.this.m19140b(0);
            CameraControlUI.this.f18140D.mo10805bv();
            LockViewDragLayout.setVolumeDownState(false);
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo18973d(ShutterButton shutterButton) {
            if (CameraControlUI.this.f18140D != null) {
                CameraControlUI.this.f18140D.mo10775bR();
                if (LockViewDragLayout.m23984a() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE))) {
                    return;
                }
                if (CameraControlUI.this.f18140D.mo10649C() && CameraControlUI.this.f18140D.mo10814c() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE))) {
                    return;
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONEPLUS_VIBRATE_SUPPORT)) {
                    CameraControlUI.this.f18140D.mo10840g(1);
                } else {
                    CameraControlUI.this.f18140D.mo10840g(68);
                }
            }
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo18974e(ShutterButton shutterButton) {
            if ((LockViewDragLayout.m23984a() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE))) || CameraControlUI.this.f18140D == null) {
                return;
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONEPLUS_VIBRATE_SUPPORT)) {
                CameraControlUI.this.f18140D.mo10840g(1);
            } else {
                CameraControlUI.this.f18140D.mo10840g(68);
            }
        }
    };

    /* renamed from: aG */
    private ShutterButton.OnShutterButtonListener f18169aG = new ShutterButton.OnShutterButtonListener() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.7
        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18970a(ShutterButton shutterButton, boolean z) {
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo18971b(ShutterButton shutterButton) {
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo18972c(ShutterButton shutterButton) {
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18969a(ShutterButton shutterButton) {
            CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, switch_camera_button");
            if (PopUpWindowManager.m20706a()) {
                PopUpWindowManager.m20704a(false);
            }
            CameraControlUI.this.f18139C.onSwitchCameraButtonClick();
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo18973d(ShutterButton shutterButton) {
            if (CameraControlUI.this.f18139C != null) {
                CameraControlUI.this.f18139C.mo10909k();
            }
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo18974e(ShutterButton shutterButton) {
            if (CameraControlUI.this.f18139C != null) {
                CameraControlUI.this.f18139C.mo10910l();
            }
        }

        @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
        /* renamed from: L */
        public boolean mo18968L() {
            if (CameraControlUI.this.f18151O != null) {
                return CameraControlUI.this.f18151O.isEnabled();
            }
            return true;
        }
    };

    /* renamed from: aH */
    private LockViewDragLayout.InterfaceC3501a f18170aH = new LockViewDragLayout.InterfaceC3501a() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.8
        @Override // com.oplus.camera.p172ui.widget.LockViewDragLayout.InterfaceC3501a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo19221a(boolean z) throws Resources.NotFoundException {
            StringBuilder sb = new StringBuilder();
            sb.append("onViewReleased, isReachBorder: ");
            sb.append(z);
            sb.append(", isQuickVideoRecord: ");
            sb.append(CameraControlUI.this.f18140D != null ? Boolean.valueOf(CameraControlUI.this.f18140D.mo10803bt()) : "null");
            CameraLog.m12954a("CameraControlUI", sb.toString());
            if (CameraControlUI.this.f18140D != null && CameraControlUI.this.f18140D.mo10803bt()) {
                CameraControlUI.this.f18140D.mo10842g(z);
                if (z) {
                    if (CameraControlUI.this.f18150N != null) {
                        CameraControlUI.this.f18150N.setButtonTypeAndInvalidate(new MainShutterButtonInfo(2, 1));
                    }
                    LockViewDragLayout.setReachBorderState(false);
                    CameraControlUI.this.f18140D.mo10806bw();
                    Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(CameraControlUI.this.f18137A, R.anim.quick_video_shutter_scale_path_interpolator);
                    Util.m24273a(CameraControlUI.this.f18152P, 250, interpolatorLoadInterpolator);
                    Util.m24273a(CameraControlUI.this.f18153Q, 250, interpolatorLoadInterpolator);
                    CameraControlUI.this.f18152P.setClickable(true);
                    CameraControlUI.this.f18152P.setEnabled(true);
                } else {
                    CameraControlUI.this.f18140D.mo10802bs();
                }
                LockViewDragLayout.setLongPressState(false);
                if (CameraControlUI.this.f18138B != null && !CameraControlUI.this.f18138B.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false) && CameraControlUI.this.f18140D.mo10803bt()) {
                    CameraControlUI.this.f18140D.mo10805bv();
                }
            }
            if (CameraControlUI.this.f18140D.mo10848h(CameraUIInterface.KEY_SHORT_VIDEO)) {
                if (!z) {
                    CameraControlUI.this.f18140D.mo10647A();
                } else if (z) {
                    if (CameraControlUI.this.f18150N != null) {
                        CameraControlUI.this.f18150N.setButtonTypeAndInvalidate(new MainShutterButtonInfo(2, 1));
                    }
                    LockViewDragLayout.setReachBorderState(false);
                    CameraControlUI.this.f18140D.mo10806bw();
                }
                LockViewDragLayout.setLongPressState(false);
            }
        }
    };

    /* renamed from: aI */
    private Animation.AnimationListener f18171aI = new Animation.AnimationListener() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.14
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (CameraControlUI.this.f18156T != null) {
                CameraControlUI.this.f18156T.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CameraControlUI.this.m19119af();
        }
    };

    /* compiled from: CameraControlUI.java */
    /* renamed from: com.oplus.camera.ui.control.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10895a(Thumbnail c3203e);
    }

    @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
    /* renamed from: L */
    public boolean mo18968L() {
        return true;
    }

    @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18973d(ShutterButton shutterButton) {
    }

    @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo18974e(ShutterButton shutterButton) {
    }

    public CameraControlUI(Activity activity, ComboPreferences comboPreferences, CameraUIListener cameraUIListener, ScreenModeManager c2953g) {
        this.f18137A = null;
        this.f18138B = null;
        this.f18140D = null;
        this.f18179ah = null;
        this.f18183al = null;
        this.f18137A = activity;
        this.f18138B = comboPreferences;
        this.f18140D = cameraUIListener;
        this.f18179ah = this.f18137A.getContentResolver();
        this.f18183al = c2953g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19078a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        m19084a(OplusGLSurfaceView_13, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19084a(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20430a(4, OplusGLSurfaceView_13, z, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19080a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, int i2) throws Resources.NotFoundException {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20431a(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2, timeInterpolator, animatorListener, false, i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19140b(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        m19085a(OplusGLSurfaceView_13, true, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19085a(int OplusGLSurfaceView_13, boolean z, boolean z2) throws Resources.NotFoundException {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20430a(0, OplusGLSurfaceView_13, z, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m19110a() {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            return c3239e.m20463k();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m19149b() {
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView == null || thumbImageView.getVisibility() == 0) {
            return true;
        }
        CameraLog.m12959b("CameraControlUI", "isThumbImageViewVisible, mThumbImageView not visible");
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19150c() {
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.m18966i();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m19160d() {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            return c3239e.m20467o();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19092a(MainShutterButtonInfo c3200b) {
        if (this.f18150N.m18947b(c3200b)) {
            return;
        }
        this.f18150N.m18945a(c3200b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19106a(boolean z) {
        if (this.f18140D.mo10808by()) {
            return;
        }
        if (this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA) && (this.f18140D.mo10663Q() || m19050w(z))) {
            m19141b(0, 300);
            if (m19050w(z)) {
                m19164e(false, false);
            }
        } else {
            m19141b(4, 300);
        }
        if (this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_THUMBNAIL) && (this.f18140D.mo10663Q() || m19050w(z))) {
            m19152c(0, 300);
            if (m19050w(z)) {
                m19168f(false, false);
                return;
            }
            return;
        }
        m19152c(4, 300);
    }

    /* renamed from: w */
    private boolean m19050w(boolean z) {
        return 1 == this.f18211t && z && this.f18140D.mo10856j();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19151c(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        this.f18207p = Util.m24338aa();
        m19169g();
        this.f18150N = (MainShutterButton) this.f18137A.findViewById(R.id_renamed.shutter_button);
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo(1, "button_color_inside_none");
        this.f18150N.setButtonTypeAndInvalidate(c3200b);
        this.f18150N.setOnShutterButtonListener(this.f18168aF);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) {
            this.f18150N.setBackgroundResource(R.drawable.button_shutter_low_shadow_background);
        }
        this.f18150N.setVisibility(0);
        this.f18150N.setCameraUIListener(this.f18140D);
        InverseManager.INS.registerInverse(this.f18137A, this.f18150N);
        this.f18151O = (ShutterButton) this.f18137A.findViewById(R.id_renamed.switch_camera_button);
        this.f18151O.setOnShutterButtonListener(this.f18169aG);
        this.f18151O.setForceHide(OutCaptureManager.m16423g());
        this.f18151O.setCameraUIListener(this.f18140D);
        this.f18151O.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return CameraControlUI.this.f18140D != null && CameraControlUI.this.f18140D.mo10873p();
            }
        });
        InverseManager.INS.registerInverse(this.f18137A, this.f18151O);
        BackgroundSplitManager.m18430a(this.f18137A).m18445a(this.f18151O, "SwitchCameraButton");
        if (this.f18211t != 1) {
            ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
            if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
                sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21751f();
            }
            if (this.f18149M == null) {
                this.f18149M = (ShutterButton) this.f18137A.getLayoutInflater().inflate(R.layout.view_stub_camera_from_other_app_close_btn, this.f18143G).findViewById(R.id_renamed.camera_from_other_app_close_btn);
            }
            this.f18149M.setOnShutterButtonListener(this);
            this.f18149M.setVisibility(0);
            this.f18149M.setCameraUIListener(this.f18140D);
            BackgroundSplitManager.m18430a(this.f18137A).m18445a(this.f18149M, "CloseCameraButton");
            if (this.f18211t == 3) {
                c3200b.m19227a("button_color_inside_red");
                this.f18150N.setButtonTypeAndInvalidate(c3200b);
                this.f18150N.requestFocus();
            }
        }
        m19041r(OplusGLSurfaceView_13);
        this.f18182ak = (VideoClipView) this.f18137A.findViewById(R.id_renamed.video_clip_view);
        final int dimensionPixelSize = this.f18137A.getResources().getDimensionPixelSize(R.dimen.switch_camera_button_extra_touch_offset);
        this.f18166aD = (View) this.f18151O.getParent();
        Runnable runnable = new Runnable() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.10
            @Override // java.lang.Runnable
            public void run() {
                if (CameraControlUI.this.f18151O == null || CameraControlUI.this.f18166aD == null) {
                    return;
                }
                Rect rect = new Rect();
                CameraControlUI.this.f18151O.getHitRect(rect);
                if (dimensionPixelSize > 0) {
                    rect.left -= dimensionPixelSize;
                    rect.top -= dimensionPixelSize;
                    rect.right += dimensionPixelSize;
                    rect.bottom += dimensionPixelSize;
                    CameraControlUI.this.f18166aD.setTouchDelegate(new TouchDelegate(rect, CameraControlUI.this.f18151O));
                }
            }
        };
        this.f18166aD.removeCallbacks(runnable);
        this.f18166aD.post(runnable);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m19161e() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT)) {
            if (this.f18181aj == null) {
                this.f18181aj = (RotateImageView) this.f18137A.getLayoutInflater().inflate(R.layout.view_load_video_button, (ViewGroup) this.f18137A.findViewById(R.id_renamed.camera)).findViewById(R.id_renamed.load_video_button);
                this.f18181aj.setOnClickListener(this);
                this.f18181aj.setVisibility(4);
            }
            if (this.f18154R == null) {
                this.f18154R = (ShutterButton) this.f18137A.getLayoutInflater().inflate(R.layout.view_double_exposure_revert_button, this.f18143G).findViewById(R.id_renamed.revert_button);
                this.f18154R.setOnClickListener(this);
                this.f18154R.setVisibility(4);
                this.f18154R.setCameraUIListener(this.f18140D);
            }
            if (this.f18155S == null) {
                this.f18155S = (ShutterButton) this.f18137A.getLayoutInflater().inflate(R.layout.view_double_exposure_cancel_button, this.f18143G).findViewById(R.id_renamed.cancel_button);
                this.f18155S.setOnClickListener(this);
                this.f18155S.setVisibility(4);
                this.f18155S.setCameraUIListener(this.f18140D);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19083a(int OplusGLSurfaceView_13, String str, boolean z) {
        this.f18204m = false;
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21754i();
        }
        if (Util.m24338aa() != this.f18207p) {
            this.f18207p = Util.m24338aa();
            m18998aC();
        }
        List<Integer> listM20355b = this.f18176ae.m20355b();
        int iM20344a = HeadlineHelper.m20344a(str);
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= listM20355b.size()) {
                break;
            }
            if (listM20355b.get(i3).intValue() == iM20344a) {
                i2 = i3;
                break;
            }
            i3++;
        }
        this.f18177af = listM20355b;
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20438a(listM20355b, i2);
            this.f18175ad.m20466n();
        }
        if (z && !this.f18206o && this.f18140D.mo10663Q()) {
            this.f18151O.setVisibility(0);
        } else {
            this.f18151O.setVisibility(8);
        }
        m19146b(this.f18140D.mo10704aI());
        if (m19124ak()) {
            this.f18156T.m18986a(Util.m24216a((Context) this.f18137A, R.drawable.thumbnail_bg_normal), 0, false, true);
        }
        if (!CameraEntry.m13302b(this.f18211t)) {
            AsyncTask<Void, Void, Thumbnail> asyncTask = this.f18216y;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                this.f18216y = null;
            }
            this.f18216y = new PlatformImplementations.kt_3(null, false, !m19124ak(), true, null).executeOnExecutor(ThumbnailLoadExecutor.m19302a(), new Void[0]);
        }
        ModePickerView c3239e2 = this.f18175ad;
        if (c3239e2 != null) {
            c3239e2.m20465m();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19146b(boolean z) {
        if (this.f18151O != null) {
            boolean zM13302b = CameraEntry.m13302b(this.f18211t);
            int OplusGLSurfaceView_13 = R.drawable.btn_switch_camera_selector;
            if (zM13302b) {
                this.f18151O.setImageResource(R.drawable.btn_switch_camera_selector);
                return;
            }
            if (this.f18188aq) {
                OplusGLSurfaceView_13 = R.drawable.btn_switch_camera_with_bg;
            }
            if (z) {
                OplusGLSurfaceView_13 = R.drawable.btn_switch_camera_microscope_selector;
            }
            this.f18151O.setImageDrawable(this.f18137A.getDrawable(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19155c(boolean z) {
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setSelected(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m19165f() {
        m19107a(true, true);
        if (this.f18140D.mo10808by()) {
            return;
        }
        if (this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB)) {
            m19120ag();
        }
        ShutterButton shutterButton = this.f18154R;
        if (shutterButton != null) {
            shutterButton.setVisibility(4);
        }
        ShutterButton shutterButton2 = this.f18155S;
        if (shutterButton2 != null) {
            shutterButton2.setVisibility(4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19107a(boolean z, boolean z2) {
        if (this.f18140D.mo10808by() && z2 && m19011aP()) {
            if (z) {
                Util.m24270a(this.f18181aj, 0, (Animation.AnimationListener) null, 300L);
                return;
            } else {
                this.f18181aj.setVisibility(0);
                return;
            }
        }
        if (z) {
            Util.m24270a(this.f18181aj, 4, (Animation.AnimationListener) null, 300L);
        } else {
            this.f18181aj.setVisibility(4);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19157d(int OplusGLSurfaceView_13) {
        this.f18178ag = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m19169g() {
        this.f18141E = (RelativeLayout) this.f18137A.findViewById(R.id_renamed.control_panel_layout);
        this.f18141E.setMotionEventSplittingEnabled(false);
        if (!Util.m24498u()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Util.m24187O());
            layoutParams.addRule(12);
            this.f18141E.setLayoutParams(layoutParams);
        }
        this.f18143G = (LockViewDragLayout) this.f18137A.findViewById(R.id_renamed.control_panel_button_layout);
        this.f18143G.setVDHLayoutListener(this.f18170aH);
        this.f18143G.setMotionEventSplittingEnabled(false);
        if (this.f18211t == 1) {
            this.f18137A.getLayoutInflater().inflate(R.layout.camera_thumbnail, this.f18143G);
            this.f18156T = (ThumbImageView) this.f18143G.findViewById(R.id_renamed.thumbnail);
            this.f18156T.setOnClickListener(this);
            this.f18156T.m18986a(BitmapFactory.decodeResource(this.f18137A.getResources(), R.drawable.thumbnail_bg_normal), 0, false, true);
            this.f18156T.setVisibility(0);
            this.f18212u = this.f18156T.getLayoutParams().width;
            this.f18208q = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SHARE_EDIT_SUPPORT);
            if (this.f18208q) {
                this.f18144H = (RelativeLayout) View.inflate(this.f18137A, R.layout.share_and_edit_layout, null);
                this.f18160X = new ShareEditThumbMenu(this.f18144H, this, this.f18137A, this.f18138B, new ShareEditThumbMenu.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.11
                    @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.IntrinsicsJvm.kt_4
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo19220a() {
                        CameraControlUI.this.f18140D.mo10785bb();
                    }
                }, this.f18140D, this.f18156T);
            }
        }
        if (Util.m24498u()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, Util.m24188P());
        layoutParams2.addRule(10);
        layoutParams2.topMargin = m19008aM();
        this.f18143G.setLayoutParams(layoutParams2);
    }

    /* renamed from: aC */
    private void m18998aC() {
        LockViewDragLayout lockViewDragLayout = this.f18143G;
        if (lockViewDragLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lockViewDragLayout.getLayoutParams();
            layoutParams.topMargin = m19008aM();
            this.f18143G.setLayoutParams(layoutParams);
        }
        RelativeLayout relativeLayout = this.f18145I;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams2.topMargin = m19008aM();
            this.f18145I.setLayoutParams(layoutParams2);
        }
        COUIRecyclerView cOUIRecyclerView = this.f18190as;
        if (cOUIRecyclerView != null) {
            ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) cOUIRecyclerView.getLayoutParams();
            c0398a.topMargin = this.f18137A.getResources().getDimensionPixelSize(R.dimen.mode_edit_headline_margin_top);
            this.f18190as.setLayoutParams(c0398a);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m19173h() throws Resources.NotFoundException {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20432a(4, 250L, 0L, (TimeInterpolator) null, false, 2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19147b(boolean z, boolean z2) throws Resources.NotFoundException {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e == null || !z) {
            return;
        }
        if (z2) {
            c3239e.m20432a(0, 180L, 117L, (TimeInterpolator) null, false, 2);
        } else {
            m19140b(1);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m19162e(int OplusGLSurfaceView_13) {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20457e(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19158d(boolean z) throws Resources.NotFoundException {
        m19117ad();
        if (z) {
            m19078a(1);
            m19152c(8, 300);
            m19079a(8, 300);
            m19141b(8, 300);
            return;
        }
        m19078a(0);
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView != null) {
            thumbImageView.setVisibility(8);
        }
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.setVisibility(8);
        }
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setVisibility(8);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m19163e(boolean z) throws Resources.NotFoundException {
        m19117ad();
        if (z) {
            m19078a(1);
            m19152c(8, 300);
            m19141b(8, 300);
            return;
        }
        m19078a(0);
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView != null) {
            thumbImageView.setVisibility(8);
        }
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setVisibility(8);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m19167f(boolean z) {
        m19117ad();
        if (z) {
            m19152c(8, 180);
            m19079a(8, 180);
            m19141b(8, 180);
            return;
        }
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView != null) {
            thumbImageView.setVisibility(8);
        }
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.setVisibility(8);
        }
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setVisibility(8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19108a(boolean z, boolean z2, boolean z3) {
        ShutterButton shutterButton;
        ThumbImageView thumbImageView;
        if (z) {
            if (!z3 && !z2) {
                m19152c(0, 300);
            }
            m19079a(0, 300);
            if (!this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA) || z3 || z2) {
                return;
            }
            m19141b(0, 300);
            return;
        }
        if (!z2 && (thumbImageView = this.f18156T) != null) {
            thumbImageView.setVisibility(0);
        }
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.setVisibility(0);
        }
        if (!this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA) || z2 || (shutterButton = this.f18151O) == null) {
            return;
        }
        shutterButton.setVisibility(0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19156c(boolean z, boolean z2) {
        m19108a(z, z2, false);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m19177i() {
        m19159d(true, true);
        m19164e(true, true);
        m19168f(true, true);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m19181j() {
        this.f18205n = true;
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setAlpha(1.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19093a(MainShutterButtonInfo c3200b, boolean z) {
        CameraLog.m12954a("CameraControlUI", "onPause");
        this.f18205n = false;
        this.f18204m = true;
        this.f18200i = false;
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21755j();
        }
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.m18946b();
        }
        ShutterButton shutterButton = this.f18149M;
        if (shutterButton != null) {
            shutterButton.clearAnimation();
        }
        AsyncTask<Void, Void, Thumbnail> asyncTask = this.f18216y;
        if (asyncTask != null) {
            asyncTask.cancel(false);
            this.f18216y = null;
        }
        m19176h(true, false);
        RelativeLayout relativeLayout = this.f18141E;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.f18141E.setAlpha(1.0f);
        }
        m19117ad();
        m19094a(c3200b, z, true);
        m19214v();
        MainShutterButton mainShutterButton2 = this.f18150N;
        if (mainShutterButton2 == null || mainShutterButton2.getShutterButtonInfo() != null) {
            return;
        }
        CameraLog.m12967f("CameraControlUI", "onPause, null == currentButtonInfo");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m19171g(boolean z) {
        CameraLog.m12954a("CameraControlUI", "setPhotoEncrypted, isPhotoEncrypted: " + z);
        this.f18201j = z;
        if (this.f18201j) {
            this.f18202k = OPlusAccessControlManager.getInstance().isEncryptPass(Util.m24327aP(), OPlusAccessControlManager.USER_CURRENT);
            CameraLog.m12959b("CameraControlUI", "setPhotoEncrypted, mbPhotoEncryptPass: " + this.f18202k);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m19187k() {
        return this.f18201j;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m19190l() {
        return this.f18202k;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m19191m() {
        if (this.f18156T == null || !this.f18201j) {
            return;
        }
        this.f18156T.m18986a(BitmapFactory.decodeResource(this.f18137A.getResources(), R.drawable.thumbnail_bg_normal), 0, false, true);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m19194n() {
        CameraLog.m12954a("CameraControlUI", "onDestroy");
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.m18942a();
        }
        Bitmap bitmap = this.f18217z;
        if (bitmap != null) {
            bitmap.recycle();
            this.f18217z = null;
        }
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView != null) {
            thumbImageView.m18986a(null, 0, false, true);
            this.f18156T.m18987b();
            this.f18156T = null;
        }
        Thumbnail c3203e = this.f18157U;
        if (c3203e != null) {
            c3203e.m19297k();
            this.f18157U = null;
        }
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21738a();
            this.f18160X = null;
        }
        m19005aJ();
        this.f18137A = null;
        this.f18150N = null;
        this.f18149M = null;
        this.f18139C = null;
        View view = this.f18166aD;
        if (view != null && view.getHandler() != null) {
            this.f18166aD.getHandler().removeCallbacksAndMessages(null);
        }
        this.f18151O = null;
        this.f18152P = null;
        this.f18153Q = null;
        this.f18158V = null;
        this.f18140D = null;
        this.f18198g = false;
        this.f18161Y = null;
        this.f18162Z = null;
        this.f18185an = null;
        this.f18184am = null;
    }

    /* renamed from: o */
    public void m19197o() {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20450c();
        }
    }

    /* renamed from: p */
    public void m19200p() {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20454d();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m19175h(boolean z) {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20440a(z);
        }
    }

    /* renamed from: q */
    public boolean m19205q() {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            return c3239e.m20458f();
        }
        return false;
    }

    /* renamed from: r */
    private void m19041r(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraLog.m12954a("CameraControlUI", "initHeadline, entryType: " + OplusGLSurfaceView_13);
        if (this.f18174ac == null) {
            this.f18174ac = new HeadlineBackground(this.f18137A);
            this.f18174ac.setId(R.id_renamed.headline_background);
            this.f18174ac.setForceDarkAllowed(false);
            InverseManager.INS.registerInverse(this.f18137A, this.f18174ac);
        }
        if (this.f18175ad == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Util.m24192T());
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            this.f18176ae.m20354a(this.f18137A.getApplicationContext(), this.f18211t, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PORTRAIT), CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT));
            this.f18176ae.m20353a();
            this.f18175ad = new ModePickerView(this.f18137A, this.f18140D);
            this.f18175ad.setClipToOutline(true);
            this.f18175ad.m20428a(this.f18211t);
            this.f18175ad.setHeadlineBackground(this.f18174ac);
            this.f18175ad.setListener(this);
            this.f18175ad.setTextArray(this.f18176ae.m20355b());
            this.f18175ad.setLayoutParams(layoutParams);
            this.f18175ad.setId(R.id_renamed.headline_view);
            layoutParams.width = Util.getScreenWidth();
            layoutParams.height = Util.m24192T();
            this.f18141E.addView(this.f18174ac, layoutParams);
            this.f18141E.addView(this.f18175ad);
            if (!this.f18205n) {
                this.f18175ad.setVisibility(4);
            }
            CameraLog.m12954a("CameraControlUI", "initHeadline X");
        }
    }

    /* renamed from: aD */
    private void m18999aD() {
        RelativeLayout.LayoutParams layoutParams;
        ModeArrangeDecoration c3238d = this.f18191at;
        if (c3238d != null) {
            c3238d.m20357a(this.f18175ad.getLastTextWidth());
            this.f18190as.invalidateItemDecorations();
        }
        if (this.f18195ax != null) {
            return;
        }
        Util.m24489q(this.f18137A);
        if (4 == this.f18167aE) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.f18137A.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_height));
            layoutParams.topMargin = this.f18137A.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_margin_top);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.f18141E.getHeight());
        }
        this.f18195ax = (ViewGroup) this.f18137A.getLayoutInflater().inflate(R.layout.mode_edit_confirm_layout, (ViewGroup) null);
        this.f18195ax.setLayoutParams(layoutParams);
        this.f18195ax.setVisibility(4);
        this.f18141E.addView(this.f18195ax);
        this.f18192au = new ModeAdapter(this.f18137A);
        this.f18192au.m21906c(this.f18167aE);
        this.f18191at = new ModeArrangeDecoration();
        this.f18191at.m20358b(this.f18167aE);
        this.f18190as = (COUIRecyclerView) this.f18195ax.findViewById(R.id_renamed.mode_edit_headline_recycle);
        this.f18183al.mo16411a().mo16523a(this.f18137A, this.f18190as);
        this.f18190as.addItemDecoration(this.f18191at);
        this.f18190as.addOnItemTouchListener(new RecyclerView.InterfaceC0697m() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.12
            @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4163a(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo4164a(RecyclerView recyclerView, MotionEvent motionEvent) {
                if (CameraControlUI.this.f18193av == null) {
                    CameraControlUI viewOnClickListenerC3199a = CameraControlUI.this;
                    viewOnClickListenerC3199a.f18193av = new GestureDetector(viewOnClickListenerC3199a.f18137A, new IntrinsicsJvm.kt_4());
                }
                CameraControlUI.this.f18194aw.m21896a(motionEvent);
                return CameraControlUI.this.f18193av.onTouchEvent(motionEvent) || CameraControlUI.this.f18194aw.m21900a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4165b(RecyclerView recyclerView, MotionEvent motionEvent) {
                CameraControlUI.this.f18194aw.m21896a(motionEvent);
            }
        });
        this.f18197az = (ViewGroup) this.f18137A.getLayoutInflater().inflate(R.layout.arrange_complete_button_layout, (ViewGroup) null);
        ((ViewGroup) this.f18137A.findViewById(R.id_renamed.camera)).addView(this.f18197az);
        this.f18163aA = (AnimationButton) this.f18197az.findViewById(R.id_renamed.arrange_complete_button);
        m19002aG();
        this.f18163aA.setTextSize(0, this.f18137A.getResources().getDimensionPixelSize(R.dimen.mode_edit_button_text_size));
        m19003aH();
        this.f18197az.setVisibility(4);
        this.f18163aA.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$2xJhixnacuNHSqAd3HYpb2ZqXMs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m18992a(view);
            }
        });
        this.f18190as.setItemViewCacheSize(Integer.MAX_VALUE);
        this.f18183al.mo16411a().mo16526a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$3hSE48jLhDe3MYvSX1IVI369Zjc
            @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
            public final void call(Object[] objArr) {
                this.COUIBaseListPopupWindow_12$0.m19027d(objArr);
            }
        }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$NFt6NxgdpSJcW3dvByroFrbF5zs
            @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
            public final void call(Object[] objArr) {
                this.COUIBaseListPopupWindow_12$0.m19025c(objArr);
            }
        });
        this.f18190as.setAdapter(this.f18192au);
        this.f18190as.getItemAnimator().m4125a(0L);
        this.f18194aw.m21899a(this.f18190as, this.f18140D);
        this.f18190as.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18992a(View view) {
        if (this.f18194aw.m21900a() || this.f18175ad.m20464l()) {
            return;
        }
        this.f18163aA.setClickable(false);
        this.f18165aC.mo20025a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m19027d(Object[] objArr) {
        this.f18190as.setLayoutManager(new SmoothScrollLayoutManager(this.f18137A, 0, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m19025c(Object[] objArr) {
        this.f18190as.setLayoutManager(new SmoothScrollLayoutManager(this.f18137A, 1, false));
    }

    /* renamed from: r */
    public MainShutterButton m19206r() {
        return this.f18150N;
    }

    /* renamed from: s */
    public ThumbImageView m19208s() {
        return this.f18156T;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19088a(Bitmap bitmap, int OplusGLSurfaceView_13, boolean z) {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21740a(bitmap, OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19105a(String str) {
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setContentDescription(str);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m19179i(boolean z) {
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.setLongClickable(z);
        }
    }

    /* renamed from: t */
    public Thumbnail m19210t() {
        return this.f18157U;
    }

    /* renamed from: u */
    public int m19212u() {
        return this.f18212u;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m19166f(int OplusGLSurfaceView_13) {
        this.f18211t = OplusGLSurfaceView_13;
        this.f18198g = OplusGLSurfaceView_13 == 3;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m19170g(int OplusGLSurfaceView_13) {
        int i2;
        CameraUIListener cameraUIListener;
        this.f18215x = OplusGLSurfaceView_13;
        ShutterButton shutterButton = this.f18153Q;
        if (shutterButton != null) {
            shutterButton.m18348a(OplusGLSurfaceView_13, true);
        }
        ShutterButton shutterButton2 = this.f18151O;
        if (shutterButton2 != null) {
            shutterButton2.m18348a(OplusGLSurfaceView_13, true);
        }
        if (this.f18156T != null && (cameraUIListener = this.f18140D) != null) {
            if (cameraUIListener.mo10791bh() || this.f18140D.mo10788be()) {
                CameraLog.m12959b("CameraControlUI", "setOrientation, ThumbImageView ignore orientation change intentionally");
            } else {
                this.f18156T.m18984a(OplusGLSurfaceView_13, true);
            }
        }
        RotateImageView rotateImageView = this.f18146J;
        if (rotateImageView != null) {
            rotateImageView.m18348a(OplusGLSurfaceView_13, true);
        }
        RotateImageView rotateImageView2 = this.f18147K;
        if (rotateImageView2 != null) {
            rotateImageView2.m18348a(OplusGLSurfaceView_13, true);
        }
        RotateImageView rotateImageView3 = this.f18148L;
        if (rotateImageView3 != null) {
            rotateImageView3.m18348a(OplusGLSurfaceView_13, true);
        }
        if (this.f18149M != null && (3 == (i2 = this.f18211t) || 2 == i2)) {
            this.f18149M.m18348a(OplusGLSurfaceView_13, true);
        }
        ShutterButton shutterButton3 = this.f18152P;
        if (shutterButton3 != null) {
            shutterButton3.m18348a(OplusGLSurfaceView_13, true);
        }
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21739a(OplusGLSurfaceView_13, true);
        }
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.m18348a(OplusGLSurfaceView_13, true);
        }
        ShutterButton shutterButton4 = this.f18154R;
        if (shutterButton4 != null) {
            shutterButton4.m18348a(OplusGLSurfaceView_13, true);
        }
        ShutterButton shutterButton5 = this.f18155S;
        if (shutterButton5 != null) {
            shutterButton5.m18348a(OplusGLSurfaceView_13, true);
        }
        RotateImageView rotateImageView4 = this.f18181aj;
        if (rotateImageView4 != null) {
            rotateImageView4.m18348a(OplusGLSurfaceView_13, true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m19174h(int OplusGLSurfaceView_13) {
        ModeAdapter c3349g;
        this.f18167aE = OplusGLSurfaceView_13;
        ItemDragHelper c3348f = this.f18194aw;
        if (c3348f != null) {
            if (c3348f.m21900a() && (c3349g = this.f18192au) != null) {
                for (ModeInfo c3353k : c3349g.m21774b()) {
                    c3353k.m21926c(this.f18137A.getColor(R.color.color_white_with_0_percent_transparency));
                    c3353k.m21923b(0);
                }
            }
            ModeAdapter c3349g2 = this.f18192au;
            if (c3349g2 != null) {
                c3349g2.notifyDataSetChanged();
            }
            this.f18194aw.m21895a(this.f18167aE);
        }
        if (this.f18195ax != null) {
            m19000aE();
            m19001aF();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19090a(BaseScreenMode abstractC2934a, boolean z) throws Resources.NotFoundException {
        m19174h(abstractC2934a.mo16539j());
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20436a(abstractC2934a, z);
        }
    }

    /* renamed from: aE */
    private void m19000aE() {
        RelativeLayout.LayoutParams layoutParams;
        if (4 == this.f18167aE) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.f18137A.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_height));
            layoutParams.topMargin = this.f18137A.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_margin_top);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        ViewGroup viewGroup = this.f18195ax;
        if (viewGroup != null) {
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: aF */
    private void m19001aF() {
        ScreenModeManager c2953g = this.f18183al;
        if (c2953g != null) {
            c2953g.mo16411a().mo16526a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$9lMzWLgURrQWsjY_pVIjtYUoU7A
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m19022b(objArr);
                }
            }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$mgkERGlShbdvwPnA62txbTOEMsc
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m18997a(objArr);
                }
            });
            m19002aG();
            ModeArrangeDecoration c3238d = this.f18191at;
            if (c3238d != null) {
                c3238d.m20358b(this.f18167aE);
            }
            ModeAdapter c3349g = this.f18192au;
            if (c3349g != null) {
                c3349g.m21906c(this.f18167aE);
                this.f18190as.setAdapter(this.f18192au);
                int itemCount = this.f18192au.getItemCount() - 1;
                if (itemCount >= 0) {
                    this.f18190as.scrollToPosition(itemCount);
                }
            }
            this.f18183al.mo16411a().mo16523a(this.f18137A, this.f18190as);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m19022b(Object[] objArr) {
        this.f18190as.setLayoutManager(new SmoothScrollLayoutManager(this.f18137A, 0, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18997a(Object[] objArr) {
        this.f18190as.setLayoutManager(new SmoothScrollLayoutManager(this.f18137A, 1, false));
    }

    /* renamed from: aG */
    private void m19002aG() {
        AnimationButton animationButton;
        RelativeLayout.LayoutParams layoutParams;
        if (this.f18197az == null || (animationButton = this.f18163aA) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) animationButton.getLayoutParams();
        Resources resources = this.f18137A.getResources();
        int OplusGLSurfaceView_13 = this.f18167aE;
        if (OplusGLSurfaceView_13 == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            if (this.f18183al.mo16411a() != null && this.f18183al.mo16411a().mo16570k() == 0) {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.mode_vertical_edit_button_margin_bottom) + Util.m24484o(this.f18137A);
            } else {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.mode_vertical_edit_button_margin_bottom);
            }
            layoutParams2.width = resources.getDimensionPixelSize(R.dimen.mode_edit_button_width);
            layoutParams2.height = resources.getDimensionPixelSize(R.dimen.mode_edit_button_height);
            this.f18163aA.setAnimType(1);
        } else if (OplusGLSurfaceView_13 == 3) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.mode_edit_button_margin_bottom) + Util.m24484o(this.f18137A);
            layoutParams2.width = resources.getDimensionPixelSize(R.dimen.mode_edit_button_width);
            layoutParams2.height = resources.getDimensionPixelSize(R.dimen.mode_edit_button_height);
            this.f18163aA.setAnimType(1);
        } else if (OplusGLSurfaceView_13 == 4) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.rack_mode_mode_edit_head_line_recycle_margin_bottom);
            layoutParams.rightMargin = resources.getDimensionPixelSize(R.dimen.rack_mode_arrange_complete_button_margin_right);
            layoutParams2.width = resources.getDimensionPixelSize(R.dimen.rack_mode_arrange_complete_button_width);
            layoutParams2.height = resources.getDimensionPixelSize(R.dimen.rack_mode_mode_edit_head_line_recycle_height);
            this.f18163aA.setAnimType(0);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            if (Util.m24495t()) {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.mode_edit_button_margin_bottom) + Util.m24484o(this.f18137A);
            } else {
                layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.mode_edit_button_margin_bottom);
            }
            layoutParams2.width = resources.getDimensionPixelSize(R.dimen.mode_edit_button_width);
            layoutParams2.height = this.f18137A.getResources().getDimensionPixelSize(R.dimen.mode_edit_button_height);
            this.f18163aA.setAnimType(1);
        }
        this.f18163aA.setLayoutParams(layoutParams2);
        this.f18197az.setLayoutParams(layoutParams);
    }

    /* renamed from: aH */
    private void m19003aH() {
        if (this.f18163aA != null) {
            if (Util.m24495t()) {
                this.f18163aA.setDrawableColor(R.color.color_white_with_20_percent_transparency);
            } else {
                this.f18163aA.setDrawableColor(R.color.color_white_with_10_percent_transparency);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19091a(CameraControlButtonListener cameraControlButtonListener) {
        this.f18139C = cameraControlButtonListener;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19145b(String str) {
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.setContentDescription(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19143b(MainShutterButtonInfo c3200b) {
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.setButtonTypeAndInvalidate(c3200b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19094a(MainShutterButtonInfo c3200b, boolean z, boolean z2) {
        CameraLog.m12954a("CameraControlUI", "resetShutterButton");
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            if (3 == this.f18211t) {
                this.f18150N.setButtonTypeAndInvalidate(new MainShutterButtonInfo(1, "button_color_inside_red"));
            } else {
                if (c3200b != null) {
                    mainShutterButton.setButtonTypeAndInvalidate(c3200b);
                }
                if (this.f18204m) {
                    if (2 == this.f18211t) {
                        this.f18150N.setEnabled(true);
                        this.f18150N.setClickable(true);
                        this.f18150N.setAlpha(1.0f);
                    }
                } else if (z2) {
                    this.f18150N.setVisibility(0);
                }
            }
            if (this.f18150N.isPressed()) {
                this.f18150N.setPressed(false);
            }
            this.f18150N.setLongClickable(z);
        }
    }

    /* renamed from: v */
    public void m19214v() {
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setScaleX(1.0f);
            this.f18151O.setScaleY(1.0f);
            this.f18151O.setAlpha(1.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19101a(ThumbnailClickListener interfaceC3204f) {
        this.f18158V = interfaceC3204f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19159d(boolean z, boolean z2) {
        CameraLog.m12954a("CameraControlUI", "enableCameraShutterButton, enable: " + z + ", ashed: " + z2);
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            mainShutterButton.setEnabled(z);
            this.f18150N.setClickable(z);
            this.f18150N.setLongClickable(z && this.f18140D.mo10716aU() && this.f18140D.mo10800bq());
            if (z) {
                this.f18150N.setAlpha(1.0f);
            } else if (z2) {
                this.f18150N.setAlpha(0.5f);
            } else {
                if (z2) {
                    return;
                }
                this.f18150N.setAlpha(1.0f);
            }
        }
    }

    /* renamed from: w */
    public boolean m19216w() {
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            return mainShutterButton.isEnabled();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m19164e(boolean z, boolean z2) {
        ShutterButton shutterButton;
        CameraLog.m12954a("CameraControlUI", "enableSwitchCameraButton, enable: " + z);
        if ((!z || this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) && (shutterButton = this.f18151O) != null) {
            shutterButton.setEnabled(z);
            this.f18151O.setClickable(z);
            if (z) {
                this.f18151O.setAlpha(1.0f);
            } else if (z2) {
                this.f18151O.setAlpha(0.5f);
            } else {
                if (z2) {
                    return;
                }
                this.f18151O.setAlpha(1.0f);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m19168f(boolean z, boolean z2) {
        CameraLog.m12954a("CameraControlUI", "enableThumbView(), enable: " + z + ", ashed: " + z2);
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView != null) {
            thumbImageView.setEnabled(z);
            this.f18156T.setClickable(z);
            if (z) {
                this.f18156T.setAlpha(1.0f);
            } else if (z2) {
                this.f18156T.setAlpha(InverseManager.INS.isInverseColor(this.f18137A.hashCode()) ? 0.3f : 0.5f);
            } else {
                if (z2) {
                    return;
                }
                this.f18156T.setAlpha(1.0f);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m19172g(boolean z, boolean z2) {
        CameraLog.m12954a("CameraControlUI", "enableHeadline(), enable: " + z + ", ashed: " + z2);
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            if (z) {
                c3239e.setListener(this);
            } else {
                c3239e.setListener(null);
            }
            if (z) {
                this.f18175ad.setAlpha(1.0f);
            } else if (z2) {
                this.f18175ad.setAlpha(InverseManager.INS.isInverseColor(this.f18137A.hashCode()) ? 0.3f : 0.5f);
            } else {
                if (z2) {
                    return;
                }
                this.f18175ad.setAlpha(1.0f);
            }
        }
    }

    /* renamed from: x */
    public void m19217x() throws Resources.NotFoundException {
        if (this.f18186ao) {
            m19153c(1, true);
        }
    }

    /* renamed from: y */
    public void m19218y() {
        if (this.f18187ap) {
            if (Util.m24352ao()) {
                m19188l(Color.argb(77, 0, 0, 0));
            } else {
                m19188l(Color.argb(0, 0, 0, 0));
            }
        }
    }

    /* renamed from: z */
    public void m19219z() {
        this.f18186ao = false;
        this.f18187ap = false;
    }

    /* renamed from: A */
    public void m19052A() {
        m19141b(0, 300);
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21751f();
        }
        this.f18156T.setVisibility(4);
        m19081a(0, (Animation.AnimationListener) null);
        this.f18181aj.setVisibility(4);
        if (Util.m24352ao()) {
            m19188l(Color.argb(77, 0, 0, 0));
        } else {
            m19188l(Color.argb(0, 0, 0, 0));
        }
        this.f18186ao = true;
        this.f18187ap = true;
        this.f18188aq = true;
        m19146b(false);
    }

    /* renamed from: B */
    public void m19053B() {
        m19081a(4, (Animation.AnimationListener) null);
        this.f18186ao = false;
        this.f18187ap = false;
    }

    /* renamed from: C */
    public void m19054C() {
        m19081a(0, (Animation.AnimationListener) null);
        m19182j(0);
        m19119af();
        this.f18156T.setVisibility(4);
        this.f18151O.setVisibility(4);
        this.f18181aj.setVisibility(4);
        if (Util.m24352ao()) {
            m19188l(Color.argb(77, 0, 0, 0));
        } else {
            m19188l(Color.argb(0, 0, 0, 0));
        }
    }

    /* renamed from: D */
    public void m19055D() throws Resources.NotFoundException {
        m19204q(true);
        m19081a(4, (Animation.AnimationListener) null);
        m19182j(4);
        m19108a(true, false, false);
        m19107a(true, true);
        m19153c(1, true);
        this.f18186ao = false;
        this.f18187ap = false;
        this.f18188aq = false;
        m19146b(false);
    }

    /* renamed from: E */
    public void m19056E() {
        ShutterButton shutterButton = this.f18154R;
        if (shutterButton != null) {
            shutterButton.setVisibility(4);
        }
        this.f18155S.setVisibility(4);
        m19107a(false, false);
        this.f18188aq = false;
        m19146b(false);
    }

    /* renamed from: F */
    public void m19057F() throws Resources.NotFoundException {
        ShutterButton shutterButton = this.f18154R;
        if (shutterButton != null) {
            shutterButton.setVisibility(4);
        }
        m19120ag();
        m19108a(true, false, false);
        m19107a(true, true);
        this.f18155S.setVisibility(4);
        m19153c(1, true);
        this.f18188aq = false;
        this.f18187ap = false;
        m19146b(false);
    }

    /* renamed from: G */
    public void m19058G() {
        this.f18155S.setVisibility(4);
        this.f18151O.setVisibility(0);
        if (Util.m24352ao()) {
            m19188l(Color.argb(77, 0, 0, 0));
        } else {
            m19188l(Color.argb(0, 0, 0, 0));
        }
        this.f18188aq = true;
        m19146b(false);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m19183j(boolean z) {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21746b(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m19176h(boolean z, boolean z2) {
        m19159d(z, z2);
        m19164e(z, z2);
        m19168f(z, z2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m19178i(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraControlUI", "setCloseFromOtherAppButtonVisibility(), visibility: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 0) {
            Util.m24263a(this.f18149M);
        } else {
            Util.m24387b(this.f18149M);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m19186k(boolean z) {
        ShutterButton shutterButton = this.f18149M;
        if (shutterButton != null) {
            shutterButton.setEnabled(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19079a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("CameraControlUI", "setCameraShutterButtonVisibilityWithAnimation, visibility: " + OplusGLSurfaceView_13);
        Util.m24270a(this.f18150N, OplusGLSurfaceView_13, (Animation.AnimationListener) null, (long) i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19141b(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("CameraControlUI", "setSwitchCameraButtonVisibilityWithAnimation, visibility: " + OplusGLSurfaceView_13);
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton == null || shutterButton.m18967j()) {
            return;
        }
        Util.m24270a(this.f18151O, OplusGLSurfaceView_13, (Animation.AnimationListener) null, i2);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m19189l(boolean z) {
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setForceHide(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19081a(int OplusGLSurfaceView_13, Animation.AnimationListener animationListener) {
        ShutterButton shutterButton = this.f18154R;
        if (shutterButton != null) {
            Util.m24270a(shutterButton, OplusGLSurfaceView_13, animationListener, 300L);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m19182j(int OplusGLSurfaceView_13) {
        ShutterButton shutterButton = this.f18155S;
        if (shutterButton != null) {
            Util.m24270a(shutterButton, OplusGLSurfaceView_13, (Animation.AnimationListener) null, 300L);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m19185k(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraControlUI", "setSwitchCameraButtonVisibility, visibility: " + OplusGLSurfaceView_13);
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null) {
            shutterButton.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19152c(final int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("CameraControlUI", "setThumbViewVisibilityWithAnimation, visibility: " + OplusGLSurfaceView_13);
        if (this.f18156T == null) {
            return;
        }
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null && OplusGLSurfaceView_13 != 0) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21743a(false, false);
        }
        if ((this.f18156T.getVisibility() == 0) != (OplusGLSurfaceView_13 == 0)) {
            this.f18156T.setVisibility(OplusGLSurfaceView_13);
        }
        Util.m24270a(this.f18156T, OplusGLSurfaceView_13, new Animation.AnimationListener() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (CameraControlUI.this.f18160X == null || OplusGLSurfaceView_13 == 0) {
                    return;
                }
                CameraControlUI.this.f18160X.m21749d();
            }
        }, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19142b(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        RelativeLayout relativeLayout = this.f18141E;
        if (relativeLayout != null) {
            if (OplusGLSurfaceView_13 == 0) {
                if (Util.m24352ao()) {
                    m19077a((byte) 1, true);
                    return;
                } else if (z) {
                    m19077a((byte) 2, true);
                    return;
                } else {
                    if (this.f18198g) {
                        m19077a((byte) 2, true);
                        return;
                    }
                    return;
                }
            }
            Util.m24269a(relativeLayout, CameraUIAttributes.m18766a(this.f18137A, 3), 400, AnimationUtils.loadInterpolator(this.f18137A, R.anim.zoom_interpolator_out), (Animator.AnimatorListener) null);
        }
    }

    /* renamed from: aI */
    private void m19004aI() throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        RelativeLayout.LayoutParams layoutParams;
        if (this.f18141E != null && this.f18145I == null) {
            LayoutInflater layoutInflater = this.f18137A.getLayoutInflater();
            if (1 == this.f18167aE) {
                Resources resources = this.f18137A.getResources();
                int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.shutter_button_length);
                int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.control_panel_margin_right);
                if (270 == this.f18140D.mo10769bL().mo16570k()) {
                    dimensionPixelOffset2 = 0;
                }
                OplusGLSurfaceView_13 = R.layout.review_control_vertical;
                layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset, -1);
                layoutParams.addRule(21);
                layoutParams.rightMargin = dimensionPixelOffset2;
            } else {
                OplusGLSurfaceView_13 = R.layout.review_control;
                layoutParams = new RelativeLayout.LayoutParams(-1, Util.m24188P());
                layoutParams.topMargin = m19008aM();
                layoutParams.addRule(10);
            }
            layoutInflater.inflate(OplusGLSurfaceView_13, this.f18141E);
            this.f18145I = (RelativeLayout) this.f18137A.findViewById(R.id_renamed.review_control_layout);
            this.f18145I.setLayoutParams(layoutParams);
            this.f18146J = (RotateImageView) this.f18137A.findViewById(R.id_renamed.done_button);
            this.f18146J.setOnClickListener(this);
            this.f18146J.m18348a(this.f18215x, false);
            this.f18147K = (RotateImageView) this.f18137A.findViewById(R.id_renamed.btn_retake);
            this.f18147K.setOnClickListener(this);
            this.f18147K.m18348a(this.f18215x, false);
            this.f18148L = (RotateImageView) this.f18137A.findViewById(R.id_renamed.btn_play);
            this.f18148L.setOnClickListener(this);
            this.f18148L.m18348a(this.f18215x, false);
        }
    }

    /* renamed from: aJ */
    private void m19005aJ() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2 = this.f18141E;
        if (relativeLayout2 == null || (relativeLayout = this.f18145I) == null) {
            return;
        }
        relativeLayout2.removeView(relativeLayout);
        this.f18145I = null;
        this.f18146J = null;
        this.f18147K = null;
        this.f18148L = null;
    }

    /* renamed from: H */
    public void m19059H() throws Resources.NotFoundException {
        m19004aI();
        Util.m24387b(this.f18150N);
        m19141b(8, 300);
        m19007aL();
        Util.m24263a(this.f18147K);
        Util.m24263a(this.f18146J);
        Util.m24387b(this.f18149M);
        m19159d(false, true);
        TextView textView = this.f18162Z;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: I */
    public void m19060I() {
        Util.m24387b(this.f18147K);
        Util.m24387b(this.f18146J);
        Util.m24263a(this.f18150N);
        if (this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
            m19141b(0, 300);
        }
        Util.m24263a(this.f18149M);
        m19159d(true, true);
        m19164e(true, true);
        TextView textView = this.f18162Z;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    /* renamed from: J */
    public void m19061J() throws Resources.NotFoundException {
        m19004aI();
        Util.m24387b(this.f18150N);
        m19007aL();
        Util.m24263a(this.f18147K);
        Util.m24263a(this.f18146J);
        Util.m24263a(this.f18148L);
        Util.m24387b(this.f18149M);
        Util.m24387b(this.f18151O);
        m19159d(false, true);
        m19164e(false, true);
        TextView textView = this.f18161Y;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.f18206o = true;
    }

    /* renamed from: K */
    public void m19062K() {
        Util.m24387b(this.f18146J);
        Util.m24387b(this.f18147K);
        Util.m24387b(this.f18148L);
        Util.m24263a(this.f18150N);
        Util.m24263a(this.f18149M);
        m19159d(true, true);
        m19164e(true, true);
        m19141b(0, 300);
        this.f18206o = false;
    }

    @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18970a(ShutterButton shutterButton, boolean z) {
        CameraControlButtonListener cameraControlButtonListener = this.f18139C;
        if (cameraControlButtonListener != null) {
            cameraControlButtonListener.mo10899b(z);
        }
    }

    @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18969a(ShutterButton shutterButton) {
        if (shutterButton == null) {
            CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, ShutterButton is null.");
            return;
        }
        if (PopUpWindowManager.m20706a()) {
            PopUpWindowManager.m20712d();
            CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, camera menu is popup....");
        }
        if (this.f18139C != null) {
            int id_renamed = shutterButton.getId();
            if (id_renamed != R.id_renamed.camera_from_other_app_close_btn) {
                if (id_renamed != R.id_renamed.shutter_button) {
                    return;
                }
                if (this.f18211t == 3) {
                    this.f18139C.mo10908j();
                    return;
                } else {
                    this.f18139C.mo10906h();
                    return;
                }
            }
            int OplusGLSurfaceView_13 = this.f18211t;
            if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                CameraLog.m12954a("CameraControlUI", "onShutterButtonClick, camera_from_other_app_close_btn");
                this.f18137A.finish();
            }
        }
    }

    @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18971b(ShutterButton shutterButton) {
        if (PopUpWindowManager.m20706a()) {
            PopUpWindowManager.m20712d();
        }
        if (this.f18139C == null || shutterButton.getId() != R.id_renamed.shutter_button) {
            return;
        }
        this.f18139C.mo10907i();
    }

    @Override // com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18972c(ShutterButton shutterButton) {
        if (this.f18139C == null || R.id_renamed.shutter_button != shutterButton.getId()) {
            return;
        }
        this.f18139C.mo10901c(false);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m19193m(boolean z) throws Resources.NotFoundException {
        CameraUIListener cameraUIListener;
        CameraLog.m12967f("CameraControlUI", "startVideoRecording()");
        boolean z2 = false;
        if (this.f18152P == null) {
            this.f18152P = (ShutterButton) this.f18137A.getLayoutInflater().inflate(R.layout.view_stub_recording_cap_button, this.f18143G).findViewById(R.id_renamed.recording_cap_button);
            this.f18152P.setOnClickListener(this);
            this.f18152P.setVisibility(4);
            this.f18152P.setCameraUIListener(this.f18140D);
            this.f18152P.m18348a(this.f18215x, false);
            InverseManager.INS.registerInverse(this.f18137A, this.f18152P);
            CameraUIListener cameraUIListener2 = this.f18140D;
            if (cameraUIListener2 != null) {
                cameraUIListener2.mo10769bL().m16503a(this.f18152P);
            }
        }
        if (this.f18153Q == null) {
            this.f18153Q = (ShutterButton) this.f18137A.getLayoutInflater().inflate(R.layout.view_stub_video_pause_resume, this.f18143G).findViewById(R.id_renamed.video_pause_resume);
            this.f18153Q.setOnClickListener(this);
            this.f18153Q.setVisibility(4);
            this.f18153Q.setCameraUIListener(this.f18140D);
            this.f18153Q.m18348a(this.f18215x, false);
            this.f18153Q.setLightBackground(true);
            InverseManager.INS.registerInverse(this.f18137A, this.f18153Q);
            CameraUIListener cameraUIListener3 = this.f18140D;
            if (cameraUIListener3 != null) {
                cameraUIListener3.mo10769bL().m16503a(this.f18153Q);
            }
        }
        CameraUIListener cameraUIListener4 = this.f18140D;
        if (cameraUIListener4 != null) {
            cameraUIListener4.mo10769bL().mo16507b(this.f18137A, this.f18178ag);
        }
        if (1 == this.f18211t) {
            m19168f(false, true);
            CameraUIListener cameraUIListener5 = this.f18140D;
            if (cameraUIListener5 != null && cameraUIListener5.mo10848h(CameraUIInterface.KEY_QUICK_VIDEO)) {
                if (!this.f18140D.mo10803bt()) {
                    this.f18143G.m24028e();
                    this.f18143G.m24026c();
                }
            } else {
                CameraUIListener cameraUIListener6 = this.f18140D;
                if (cameraUIListener6 != null && cameraUIListener6.mo10848h(CameraUIInterface.KEY_SUPPORT_RECORDING_CAPTURE) && !String.valueOf(120).equals(this.f18138B.getString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30)))) {
                    this.f18152P.m18964b(true, true);
                } else {
                    CameraUIListener cameraUIListener7 = this.f18140D;
                    if (cameraUIListener7 != null && cameraUIListener7.mo10848h(CameraUIInterface.KEY_SHORT_VIDEO)) {
                        this.f18143G.m24028e();
                        this.f18143G.m24026c();
                    }
                }
            }
            CameraUIListener cameraUIListener8 = this.f18140D;
            if (cameraUIListener8 != null && cameraUIListener8.mo10791bh()) {
                Util.m24270a(this.f18156T, 8, this.f18171aI, 200L);
            } else {
                CameraUIListener cameraUIListener9 = this.f18140D;
                if (cameraUIListener9 != null && cameraUIListener9.mo10808by()) {
                    m19152c(4, 300);
                } else {
                    ThumbImageView thumbImageView = this.f18156T;
                    CameraUIListener cameraUIListener10 = this.f18140D;
                    thumbImageView.m18988b(8, cameraUIListener10 != null && cameraUIListener10.mo10848h(CameraUIInterface.KEY_SUPPORT_RECORDING_CAPTURE));
                }
            }
            CameraUIListener cameraUIListener11 = this.f18140D;
            if (cameraUIListener11 != null && !cameraUIListener11.mo10729ah() && !this.f18140D.mo10734am()) {
                m19142b(4, true);
            }
        }
        if (z && this.f18153Q != null && (cameraUIListener = this.f18140D) != null && !cameraUIListener.mo10791bh()) {
            this.f18153Q.setImageResource(R.drawable.btn_video_pause_selector);
            this.f18199h = false;
            if (this.f18140D.mo10804bu()) {
                this.f18153Q.m18964b(true, this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA));
            }
        }
        ShutterButton shutterButton = this.f18151O;
        CameraUIListener cameraUIListener12 = this.f18140D;
        if (cameraUIListener12 != null && z && cameraUIListener12.mo10804bu()) {
            z2 = true;
        }
        shutterButton.m18965c(true, z2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m19180i(boolean z, boolean z2) throws Resources.NotFoundException {
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener == null) {
            return;
        }
        boolean zMo10791bh = cameraUIListener.mo10791bh();
        if (!zMo10791bh) {
            this.f18153Q.m18965c(true, this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA));
            this.f18152P.m18965c(true, this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_RECORDING_CAPTURE));
        }
        if (this.f18211t == 1) {
            if (!z) {
                if (!z2 && this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
                    this.f18151O.m18964b(true, this.f18140D.mo10804bu());
                }
                if (zMo10791bh) {
                    Util.m24266a(this.f18156T, 200);
                } else if (!z2) {
                    this.f18156T.m18988b(0, this.f18140D.mo10848h(CameraUIInterface.KEY_SUPPORT_RECORDING_CAPTURE));
                }
            }
            if (z2 || this.f18140D.mo10729ah()) {
                return;
            }
            m19142b(0, true);
            this.f18140D.mo10762bE();
        }
    }

    /* renamed from: M */
    public void m19063M() {
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton == null || !mainShutterButton.isClickable()) {
            return;
        }
        this.f18150N.performClick();
    }

    /* renamed from: N */
    public void m19064N() {
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton == null || !mainShutterButton.isClickable()) {
            return;
        }
        if (this.f18140D.mo10848h(CameraUIInterface.KEY_QUICK_VIDEO) || this.f18140D.mo10848h(CameraUIInterface.KEY_SHORT_VIDEO)) {
            LockViewDragLayout.setIsVolumeDown(true);
        }
        this.f18150N.performLongClick();
    }

    /* renamed from: O */
    public void m19065O() {
        ShutterButton shutterButton = this.f18151O;
        if (shutterButton != null && shutterButton.isClickable() && this.f18151O.isEnabled()) {
            this.f18151O.performClick();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CameraUIListener cameraUIListener;
        if (this.f18204m) {
            CameraLog.m12954a("CameraControlUI", "onClick, Activity is paused, so return!");
        }
        switch (view.getId()) {
            case R.id_renamed.btn_play /* 2131296398 */:
                CameraLog.m12954a("CameraControlUI", "onClick, btn_play");
                CameraControlButtonListener cameraControlButtonListener = this.f18139C;
                if (cameraControlButtonListener != null) {
                    cameraControlButtonListener.mo10903e();
                    break;
                }
                break;
            case R.id_renamed.btn_retake /* 2131296399 */:
                CameraLog.m12954a("CameraControlUI", "onClick, btn_retake");
                if (this.f18211t == 3) {
                    this.f18150N.setButtonTypeAndInvalidate(new MainShutterButtonInfo(1, "button_color_inside_red"));
                    CameraControlButtonListener cameraControlButtonListener2 = this.f18139C;
                    if (cameraControlButtonListener2 != null) {
                        cameraControlButtonListener2.mo10902d();
                        break;
                    }
                } else {
                    CameraControlButtonListener cameraControlButtonListener3 = this.f18139C;
                    if (cameraControlButtonListener3 != null) {
                        cameraControlButtonListener3.mo10898b();
                        break;
                    }
                }
                break;
            case R.id_renamed.cancel_button /* 2131296437 */:
                this.f18139C.mo10905g();
                break;
            case R.id_renamed.done_button /* 2131296567 */:
                CameraLog.m12954a("CameraControlUI", "onClick, done_button");
                CameraControlButtonListener cameraControlButtonListener4 = this.f18139C;
                if (cameraControlButtonListener4 != null) {
                    int OplusGLSurfaceView_13 = this.f18211t;
                    if (OplusGLSurfaceView_13 != 2) {
                        if (OplusGLSurfaceView_13 == 3) {
                            cameraControlButtonListener4.mo10900c();
                            break;
                        }
                    } else {
                        cameraControlButtonListener4.mo10896a();
                        break;
                    }
                }
                break;
            case R.id_renamed.load_video_button /* 2131296800 */:
                this.f18139C.mo10897a(false);
                break;
            case R.id_renamed.popup_thumbnail /* 2131296975 */:
            case R.id_renamed.thumbnail /* 2131297204 */:
                CameraLog.m12954a("CameraControlUI", "onClick, thumbnail");
                CameraUIListener cameraUIListener2 = this.f18140D;
                if (cameraUIListener2 != null) {
                    cameraUIListener2.mo10667U();
                    this.f18140D.mo10668V();
                }
                if (this.f18158V != null && (cameraUIListener = this.f18140D) != null && !cameraUIListener.mo10873p()) {
                    this.f18158V.mo10892a(this.f18157U);
                    break;
                }
                break;
            case R.id_renamed.recording_cap_button /* 2131296999 */:
                this.f18139C.onCameraVideoSnapshotButtonClick();
                break;
            case R.id_renamed.revert_button /* 2131297007 */:
                CameraControlButtonListener cameraControlButtonListener5 = this.f18139C;
                if (cameraControlButtonListener5 != null) {
                    cameraControlButtonListener5.mo10904f();
                    break;
                }
                break;
            case R.id_renamed.video_pause_resume /* 2131297305 */:
                CameraLog.m12954a("CameraControlUI", "onClick, video_pause_resume");
                m19006aK();
                break;
            default:
                CameraLog.m12954a("CameraControlUI", "onClick, default");
                break;
        }
    }

    /* renamed from: P */
    public void m19066P() {
        this.f18150N.m18950e();
    }

    /* renamed from: aK */
    private void m19006aK() {
        CameraLog.m12954a("CameraControlUI", "onVideoPauseResumeClicked, mbVideoRecordingPaused: " + this.f18199h);
        if (this.f18153Q != null) {
            if (this.f18139C == null) {
                CameraLog.m12954a("CameraControlUI", "onVideoPauseResumeClicked, mCameraControlButtonListener is null.");
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (jUptimeMillis - this.f18214w < 1000) {
                CameraLog.m12954a("CameraControlUI", "onVideoPauseResumeClicked, onVideoPauseResumeClicked time less than 1000ms");
                return;
            }
            this.f18214w = jUptimeMillis;
            if (this.f18199h) {
                if (this.f18139C.mo10912n()) {
                    if (2 == this.f18150N.getButtonType() && "button_shape_dial_rotate".equals(this.f18150N.getRingShape())) {
                        this.f18150N.m18953h();
                    } else {
                        CameraUIListener cameraUIListener = this.f18140D;
                        if (cameraUIListener != null && cameraUIListener.mo10808by()) {
                            this.f18150N.m18951f();
                        }
                    }
                    this.f18153Q.setResIdWithAnimation(R.drawable.btn_video_pause_selector);
                    this.f18199h = false;
                    return;
                }
                return;
            }
            if (this.f18139C.mo10911m()) {
                if (2 == this.f18150N.getButtonType() && "button_shape_dial_rotate".equals(this.f18150N.getRingShape())) {
                    this.f18150N.m18950e();
                } else {
                    CameraUIListener cameraUIListener2 = this.f18140D;
                    if (cameraUIListener2 != null && cameraUIListener2.mo10808by()) {
                        this.f18150N.m18952g();
                    }
                }
                this.f18153Q.setResIdWithAnimation(R.drawable.btn_record_resume_selector);
                this.f18199h = true;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19099a(Thumbnail c3203e, int OplusGLSurfaceView_13) {
        AsyncTask<Void, Void, Thumbnail> asyncTask = this.f18216y;
        if (asyncTask != null && (asyncTask instanceof PlatformImplementations.kt_3) && ((PlatformImplementations.kt_3) asyncTask).m19224a()) {
            this.f18216y.cancel(true);
            this.f18216y = null;
        }
        this.f18180ai = c3203e;
        this.f18156T.m18986a(c3203e.m19294h(), OplusGLSurfaceView_13, false, true);
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21740a(c3203e.m19294h(), OplusGLSurfaceView_13, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19100a(Thumbnail c3203e, boolean z) {
        ThumbImageView thumbImageView;
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a;
        CameraLog.m12954a("CameraControlUI", "updateThumbnailView, isAnimate: " + z + ", thumbnail: " + c3203e);
        AsyncTask<Void, Void, Thumbnail> asyncTask = this.f18216y;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f18216y = null;
        }
        if (this.f18204m) {
            return;
        }
        CameraLog.m12955a("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z, "14ct_updateThumbnailView", CameraConstant.f13119d.longValue());
        this.f18157U = c3203e;
        if (c3203e != null && c3203e.m19296j()) {
            this.f18159W.close();
        } else {
            this.f18159W.open();
        }
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a2 = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a2 != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a2.m21741a(this.f18157U);
        }
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            cameraUIListener.mo10858k(true);
        }
        Thumbnail c3203e2 = this.f18180ai;
        if (c3203e2 == null || this.f18157U == null || ((c3203e2.m19290b() != this.f18157U.m19290b() && this.f18180ai.m19293g() < this.f18157U.m19293g()) || this.f18157U.m19290b() == 0)) {
            m19051x(z);
        } else if (z && (sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X) != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21745b(c3203e);
        }
        CameraUIListener cameraUIListener2 = this.f18140D;
        if (cameraUIListener2 != null && cameraUIListener2.mo10814c() && (thumbImageView = this.f18156T) != null) {
            thumbImageView.setVisibility(4);
        }
        if (this.f18200i) {
            CameraLog.m12967f("CameraControlUI", "CameraTest Thumbnail Updated");
        } else {
            CameraLog.m12954a("CameraControlUI", "updateThumbnailView, mbFirstCallHasExcuted: " + this.f18200i + ", mCurThumbnail: " + this.f18157U);
        }
        if (!this.f18200i && this.f18157U != null && this.f18158V != null) {
            this.f18200i = true;
            Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
            cameraPicture.f12130c = this.f18157U.m19291e();
            cameraPicture.mPath = this.f18157U.m19292f();
            cameraPicture.f12139l = this.f18157U.m19293g();
            cameraPicture.f12104B = false;
            cameraPicture.f12105C = true;
            this.f18158V.mo10891a(cameraPicture);
        }
        m19144b(this.f18157U);
        CameraLog.m12964d("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z, "14ct_updateThumbnailView");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19087a(Bitmap bitmap) {
        CameraLog.m12954a("CameraControlUI", "updateQuickBitmap, update for gallery");
        this.f18159W.open();
        Thumbnail c3203e = this.f18157U;
        if (c3203e != null) {
            c3203e.m19287a(bitmap);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19086a(long OplusGLSurfaceView_15) {
        Thumbnail c3203e = this.f18157U;
        if (c3203e != null && c3203e.m19296j() && this.f18157U.m19295i() == null) {
            CameraLog.m12966e("CameraControlUI", "waitCapturePreviewDone, blocking...");
            boolean zBlock = this.f18159W.block(OplusGLSurfaceView_15);
            StringBuilder sb = new StringBuilder();
            sb.append("waitCapturePreviewDone, state: ");
            sb.append(zBlock ? "done" : "timeout");
            CameraLog.m12966e("CameraControlUI", sb.toString());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19098a(Thumbnail c3203e) {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21745b(c3203e);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19144b(Thumbnail c3203e) {
        this.f18157U = c3203e;
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21741a(this.f18157U);
        }
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            cameraUIListener.mo10858k(true);
        }
        if (this.f18200i || this.f18157U == null || this.f18158V == null) {
            return;
        }
        this.f18200i = true;
        Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
        cameraPicture.f12130c = this.f18157U.m19291e();
        cameraPicture.mPath = this.f18157U.m19292f();
        cameraPicture.f12139l = this.f18157U.m19293g();
        cameraPicture.f12104B = false;
        cameraPicture.f12105C = true;
        this.f18158V.mo10891a(cameraPicture);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19089a(MediaItem.kt c2436a, Bitmap bitmap) {
        String strSubstring;
        if (c2436a == null) {
            return;
        }
        Thumbnail c3203e = this.f18157U;
        if (c3203e != null) {
            String string = c3203e.m19291e().toString();
            strSubstring = string.substring(string.lastIndexOf(47) + 1);
        } else {
            strSubstring = "";
        }
        if (this.f18158V != null && this.f18157U != null && strSubstring.equals(c2436a.m9432e())) {
            this.f18158V.mo10892a(this.f18157U);
            return;
        }
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            cameraUIListener.mo10683a(c2436a, bitmap);
        }
    }

    /* renamed from: x */
    private void m19051x(boolean z) {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a;
        CameraLog.m12954a("CameraControlUI", "updateThumbnailView, isAnimate: " + z);
        CameraLog.m12955a("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z, "14ct_updateThumbnailView", CameraConstant.f13119d.longValue());
        if (this.f18156T != null && !this.f18204m) {
            Thumbnail c3203e = this.f18157U;
            if (c3203e != null) {
                Bitmap bitmapM19294h = c3203e.m19294h();
                Uri uriM19291e = this.f18157U.m19291e();
                this.f18156T.setContentDescription(this.f18137A.getResources().getString(R.string.camera_description_review_thumbnail));
                if (bitmapM19294h != null && uriM19291e != null && uriM19291e.toString().startsWith("content://media/external/video")) {
                    this.f18156T.setContentDescription(this.f18137A.getResources().getString(R.string.camera_description_current_video_thumbnail));
                }
                if (bitmapM19294h == null || (!m19124ak() && this.f18201j && !this.f18202k && !this.f18203l)) {
                    CameraLog.m12954a("CameraControlUI", "updateThumbnailView, use normal bitmap: " + bitmapM19294h);
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.f18137A.getResources(), R.drawable.thumbnail_bg_normal);
                    this.f18157U.f18277a = true;
                    this.f18156T.m18986a(bitmapDecodeResource, 0, false, true);
                } else {
                    this.f18157U.f18277a = false;
                    this.f18156T.m18986a(bitmapM19294h, z ? 1 : 0, bitmapM19294h == null, true);
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a2 = this.f18160X;
                    if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a2 != null) {
                        sharedPreferencesOnSharedPreferenceChangeListenerC3340a2.m21740a(bitmapM19294h, z ? 1 : 0, bitmapM19294h == null);
                    }
                }
            } else {
                CameraLog.m12954a("CameraControlUI", "updateThumbnailView, mCurThumbnail is null");
                this.f18156T.m18986a(BitmapFactory.decodeResource(this.f18137A.getResources(), R.drawable.thumbnail_bg_normal), 0, false, true);
            }
            if (z && (sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X) != null) {
                sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21745b(this.f18157U);
            }
        }
        CameraLog.m12964d("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z, "14ct_updateThumbnailView");
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m19196n(boolean z) {
        this.f18203l = z;
    }

    /* renamed from: Q */
    public void m19067Q() {
        CameraLog.m12954a("CameraControlUI", "initThumbnail()");
        if (this.f18211t == 1) {
            if (this.f18158V.mo10894a()) {
                m19096a((Thumbnail.IntrinsicsJvm.kt_5) null, false);
            } else {
                m19100a((Thumbnail) null, false);
            }
        }
    }

    /* renamed from: R */
    public boolean m19068R() {
        Thumbnail c3203e = this.f18157U;
        return c3203e != null && Util.m24290a(c3203e.m19291e(), this.f18137A.getContentResolver());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19096a(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z) {
        this.f18157U = ThumbnailHolder.m19299a(this.f18137A.getContentResolver());
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21741a(this.f18157U);
        }
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            cameraUIListener.mo10858k(true);
        }
        CameraLog.m12954a("CameraControlUI", "updateThumbnail, mCurThumbnail: " + this.f18157U);
        Thumbnail c3203e = this.f18157U;
        if (c3203e != null && Util.m24290a(c3203e.m19291e(), this.f18137A.getContentResolver())) {
            m19051x(z);
        } else {
            m19097a(dVar, z, (IntrinsicsJvm.kt_3) null);
        }
        CameraPerformance.m15188b("video_save");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19097a(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z, IntrinsicsJvm.kt_3 cVar) {
        CameraLog.m12954a("CameraControlUI", "updateThumbnailFromContentResolver");
        AsyncTask<Void, Void, Thumbnail> asyncTask = this.f18216y;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f18216y = null;
        }
        this.f18216y = new PlatformImplementations.kt_3(dVar, z, true, false, cVar).executeOnExecutor(ThumbnailLoadExecutor.m19302a(), new Void[0]);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19153c(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("CameraControlUI", "updateControlPanelBgColor, previewType: " + OplusGLSurfaceView_13 + ", needAnimation: " + z);
        if (Util.m24352ao()) {
            if (this.f18140D.mo10791bh() || this.f18140D.mo10788be()) {
                m19077a((byte) 2, z);
                return;
            } else {
                m19077a((byte) 1, z);
                return;
            }
        }
        if (3 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13 || ((1 == OplusGLSurfaceView_13 && Util.m24495t()) || ((OplusGLSurfaceView_13 == 0 && Util.m24495t()) || (5 == OplusGLSurfaceView_13 && Util.m24495t())))) {
            m19077a((byte) 2, z);
        } else if (-1 != OplusGLSurfaceView_13) {
            m19077a((byte) 2, z);
        }
    }

    /* renamed from: o */
    public void m19199o(boolean z) {
        if (this.f18141E == null) {
            return;
        }
        int color = this.f18137A.getColor(R.color.beauty3d_guide_background);
        if (z) {
            Util.m24269a(this.f18141E, color, 200, (Interpolator) null, (Animator.AnimatorListener) null);
        } else {
            this.f18141E.setBackgroundColor(color);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m19188l(int OplusGLSurfaceView_13) {
        RelativeLayout relativeLayout = this.f18141E;
        if (relativeLayout != null) {
            relativeLayout.animate().cancel();
            this.f18141E.setBackgroundColor(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19077a(byte b2, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("CameraControlUI", "updateControlPanelBgColor, bgType: " + ((int) b2) + ", needAnimation: " + z);
        if (this.f18141E == null) {
            return;
        }
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null && cameraUIListener.mo10791bh()) {
            b2 = 2;
        }
        final int iM18766a = CameraUIAttributes.m18766a(this.f18137A, 3);
        if (b2 == 1) {
            iM18766a = CameraUIAttributes.m18766a(this.f18137A, 1);
        } else if (b2 == 2) {
            iM18766a = CameraUIAttributes.m18766a(this.f18137A, 3);
        } else if (b2 == 3) {
            iM18766a = this.f18137A.getColor(R.color.background_color);
        }
        if (z) {
            Util.m24269a(this.f18141E, iM18766a, 200, (Interpolator) null, (Animator.AnimatorListener) null);
        } else {
            this.f18141E.animate().cancel();
            this.f18137A.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.2
                @Override // java.lang.Runnable
                public void run() {
                    CameraControlUI.this.f18141E.setBackgroundColor(iM18766a);
                }
            });
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m19192m(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 0) {
            m18993a(this.f18151O, R.drawable.switch_camera_button_gray_bg);
            m18993a(this.f18149M, R.drawable.switch_camera_button_gray_bg);
        } else {
            m18993a(this.f18151O, R.drawable.switch_camera_button_bg);
            m18993a(this.f18149M, R.drawable.switch_camera_button_bg);
        }
    }

    /* renamed from: aL */
    private void m19007aL() {
        int iJ = this.f18183al.mo16411a().mo16539j();
        if (1 == iJ) {
            if (this.f18140D.mo10769bL().mo16570k() == 0) {
                int OplusGLSurfaceView_13 = this.f18178ag;
                if (2 == OplusGLSurfaceView_13 || 6 == OplusGLSurfaceView_13) {
                    m18993a(this.f18147K, R.drawable.switch_camera_button_bg);
                    m18993a(this.f18146J, R.drawable.switch_camera_button_bg);
                } else {
                    m18993a(this.f18147K, R.drawable.switch_camera_button_gray_bg);
                    m18993a(this.f18146J, R.drawable.switch_camera_button_gray_bg);
                }
                m18993a(this.f18148L, R.drawable.switch_camera_button_gray_bg);
                return;
            }
            m18993a(this.f18147K, R.drawable.switch_camera_button_bg);
            m18993a(this.f18146J, R.drawable.switch_camera_button_bg);
            m18993a(this.f18148L, R.drawable.switch_camera_button_bg);
            return;
        }
        if (3 == iJ) {
            if (1 == this.f18178ag) {
                m18993a(this.f18147K, R.drawable.switch_camera_button_bg);
                m18993a(this.f18146J, R.drawable.switch_camera_button_bg);
                return;
            } else {
                m18993a(this.f18147K, R.drawable.switch_camera_button_gray_bg);
                m18993a(this.f18146J, R.drawable.switch_camera_button_gray_bg);
                return;
            }
        }
        int i2 = this.f18178ag;
        if (2 == i2 || i2 == 0) {
            m18993a(this.f18147K, R.drawable.switch_camera_button_gray_bg);
            m18993a(this.f18146J, R.drawable.switch_camera_button_gray_bg);
        } else {
            m18993a(this.f18147K, R.drawable.switch_camera_button_bg);
            m18993a(this.f18146J, R.drawable.switch_camera_button_bg);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18993a(final View view, final int OplusGLSurfaceView_13) {
        Activity activity = this.f18137A;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.3
                @Override // java.lang.Runnable
                public void run() {
                    View view2 = view;
                    if (view2 != null) {
                        view2.setBackgroundResource(OplusGLSurfaceView_13);
                    }
                }
            });
        }
    }

    /* renamed from: S */
    public int m19069S() {
        RelativeLayout relativeLayout = this.f18141E;
        if (relativeLayout != null) {
            return relativeLayout.getTop();
        }
        return Util.m24193U();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19095a(ModeTypeChangedListener interfaceC3201c) {
        this.f18172aa = interfaceC3201c;
    }

    /* renamed from: T */
    public int m19070T() {
        return Util.m24187O();
    }

    /* renamed from: U */
    public RelativeLayout m19071U() {
        return this.f18141E;
    }

    /* renamed from: V */
    public int m19072V() {
        MainShutterButton mainShutterButton = this.f18150N;
        if (mainShutterButton != null) {
            return mainShutterButton.getButtonType();
        }
        return 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19082a(int OplusGLSurfaceView_13, String str) {
        List<Integer> listM20355b = this.f18176ae.m20355b();
        int iM20344a = HeadlineHelper.m20344a(str);
        boolean zContains = listM20355b.contains(Integer.valueOf(iM20344a));
        int iIndexOf = listM20355b.indexOf(Integer.valueOf(iM20344a));
        this.f18177af = listM20355b;
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            if (zContains) {
                c3239e.m20438a(listM20355b, iIndexOf);
            } else {
                c3239e.m20439a(listM20355b, false, this.f18138B.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON));
            }
        }
    }

    /* renamed from: W */
    public boolean m19073W() {
        ModePickerView c3239e = this.f18175ad;
        return c3239e != null && c3239e.m20459g();
    }

    /* renamed from: p */
    public void m19201p(boolean z) {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.setMultiFinger(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m19195n(int OplusGLSurfaceView_13) {
        this.f18150N.setShutterButtonTime(OplusGLSurfaceView_13);
    }

    /* renamed from: aM */
    private int m19008aM() {
        return this.f18137A.getResources().getDimensionPixelSize(R.dimen.control_panel_margin_top);
    }

    @Override // com.oplus.camera.p172ui.menu.p175a.ModePickerView.COUIBaseListPopupWindow_8
    /* renamed from: o */
    public void mo19198o(int OplusGLSurfaceView_13) {
        String strM20345a = HeadlineHelper.m20345a(this.f18177af.get(OplusGLSurfaceView_13).intValue());
        if (ApsConstant.CAPTURE_MODE_MORE.equals(strM20345a)) {
            m18999aD();
        }
        ModeTypeChangedListener interfaceC3201c = this.f18172aa;
        if (interfaceC3201c != null) {
            interfaceC3201c.mo11034a(strM20345a);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.p175a.ModePickerView.COUIBaseListPopupWindow_8
    /* renamed from: p */
    public boolean mo19202p(int OplusGLSurfaceView_13) {
        String strM20345a = HeadlineHelper.m20345a(this.f18177af.get(OplusGLSurfaceView_13).intValue());
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10860k(strM20345a);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.p175a.ModePickerView.COUIBaseListPopupWindow_8
    /* renamed from: X */
    public boolean mo19074X() {
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10658L();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.p175a.ModePickerView.COUIBaseListPopupWindow_8
    /* renamed from: Y */
    public boolean mo19075Y() {
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10660N();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.p175a.ModePickerView.COUIBaseListPopupWindow_8
    /* renamed from: Z */
    public boolean mo19076Z() {
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10662P();
        }
        return false;
    }

    /* renamed from: aa */
    public void m19114aa() {
        if (this.f18184am == null) {
            m19009aN();
        }
        this.f18184am.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.4
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                double dM5478c = c1032f.m5478c();
                float fM5495a = (float) SpringUtil.m5495a(dM5478c, 0.0d, 1.0d, 1.0d, 0.8999999761581421d);
                float fM5495a2 = (float) SpringUtil.m5495a(dM5478c, 0.0d, 1.0d, 1.0d, 0.6000000238418579d);
                if (CameraControlUI.this.f18151O != null) {
                    CameraControlUI.this.f18151O.setScaleX(fM5495a);
                    CameraControlUI.this.f18151O.setScaleY(fM5495a);
                    CameraControlUI.this.f18151O.setAlpha(fM5495a2);
                }
            }
        }).m5470a(0.0d).m5476b(1.0d);
    }

    /* renamed from: ab */
    public void m19115ab() {
        if (this.f18185an == null) {
            m19010aO();
        }
        this.f18185an.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.5
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                double dM5478c = c1032f.m5478c();
                float fM5495a = (float) SpringUtil.m5495a(dM5478c, 0.0d, 1.0d, 0.8999999761581421d, 1.0d);
                float fM5495a2 = (float) SpringUtil.m5495a(dM5478c, 0.0d, 1.0d, 0.6000000238418579d, 1.0d);
                if (CameraControlUI.this.f18151O != null) {
                    CameraControlUI.this.f18151O.setScaleX(fM5495a);
                    CameraControlUI.this.f18151O.setScaleY(fM5495a);
                    CameraControlUI.this.f18151O.setAlpha(fM5495a2);
                }
            }
        }).m5470a(0.0d).m5476b(1.0d);
    }

    /* renamed from: aN */
    private void m19009aN() {
        this.f18184am = SpringSystem.m5492c().m5449b().m5472a(SpringConfig.m5490b(5.0d, 10.0d));
    }

    /* renamed from: aO */
    private void m19010aO() {
        this.f18185an = SpringSystem.m5492c().m5449b().m5472a(SpringConfig.m5490b(5.0d, 10.0d));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19109a(int... iArr) {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20441a(iArr);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19148b(int... iArr) {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20445b(iArr);
        }
    }

    /* renamed from: ac */
    public boolean m19116ac() {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        return sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null && sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21753h();
    }

    /* renamed from: ad */
    public void m19117ad() {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21743a(true, true);
        }
    }

    /* renamed from: ae */
    public void m19118ae() {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21750e();
        }
    }

    /* renamed from: af */
    public void m19119af() {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a == null || 1 != this.f18211t) {
            return;
        }
        sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21751f();
    }

    /* renamed from: ag */
    public void m19120ag() {
        if (this.f18160X == null || 1 != this.f18211t) {
            return;
        }
        VideoClipView viewOnClickListenerC3522e = this.f18182ak;
        if (viewOnClickListenerC3522e == null || !viewOnClickListenerC3522e.m24132d()) {
            this.f18160X.m21752g();
        }
    }

    /* renamed from: q */
    public void m19204q(boolean z) {
        if (this.f18160X == null || 1 != this.f18211t) {
            return;
        }
        VideoClipView viewOnClickListenerC3522e = this.f18182ak;
        if (viewOnClickListenerC3522e == null || !viewOnClickListenerC3522e.m24132d()) {
            this.f18160X.m21742a(z);
        }
    }

    /* renamed from: ah */
    public void m19121ah() {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a == null || 1 != this.f18211t) {
            return;
        }
        sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21747c();
    }

    /* renamed from: q */
    public void m19203q(int OplusGLSurfaceView_13) {
        this.f18140D.mo10849i(OplusGLSurfaceView_13);
    }

    /* renamed from: ai */
    public void m19122ai() {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21745b(this.f18157U);
        }
    }

    /* renamed from: aj */
    public boolean m19123aj() {
        return this.f18140D.mo10670X();
    }

    /* renamed from: ak */
    public boolean m19124ak() {
        CameraUIListener cameraUIListener = this.f18140D;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10786bc().m13359w();
        }
        return false;
    }

    /* renamed from: al */
    public void m19125al() {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21756k();
        }
    }

    /* renamed from: r */
    public void m19207r(boolean z) {
        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = this.f18160X;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC3340a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21748c(z);
        }
    }

    /* renamed from: s */
    public void m19209s(boolean z) {
        AnimationButton animationButton;
        if (this.f18142F == null && z) {
            this.f18142F = this.f18137A.getLayoutInflater().inflate(R.layout.view_stub_more_mode_mask, this.f18141E).findViewById(R.id_renamed.more_mode_mask);
            this.f18142F.setBackgroundColor(BackgroundUtil.m24523a(this.f18137A.getColor(R.color.more_mode_mask_color)));
        }
        View view = this.f18142F;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            if (z && (animationButton = this.f18163aA) != null && animationButton.getVisibility() == 0) {
                this.f18195ax.bringToFront();
            }
        }
    }

    /* renamed from: am */
    public void m19126am() {
        LockViewDragLayout lockViewDragLayout = this.f18143G;
        if (lockViewDragLayout != null) {
            lockViewDragLayout.m24027d();
        }
    }

    /* renamed from: an */
    public void m19127an() {
        CameraLog.m12959b("CameraControlUI", "cancelThumbnailAnim.");
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView != null && thumbImageView.getAnimation() != null) {
            CameraLog.m12959b("CameraControlUI", "cancelThumbnailAnim, set thumbnail animation to null.");
            this.f18156T.getAnimation().setAnimationListener(null);
            this.f18156T.clearAnimation();
        }
        CameraLog.m12959b("CameraControlUI", "cancelThumbnailAnim end.");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m19184j(boolean z, boolean z2) throws Resources.NotFoundException {
        m19005aJ();
        if (z) {
            m19059H();
        }
        if (z2) {
            m19061J();
        }
    }

    /* renamed from: ao */
    public void m19128ao() {
        CameraControlButtonListener cameraControlButtonListener = this.f18139C;
        if (cameraControlButtonListener != null) {
            cameraControlButtonListener.onSwitchCameraButtonClick();
        }
    }

    /* compiled from: CameraControlUI.java */
    /* renamed from: com.oplus.camera.ui.control.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends AsyncTask<Void, Void, Thumbnail> {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Thumbnail f18238b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Thumbnail.IntrinsicsJvm.kt_5 f18239c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f18240d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f18241e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f18242f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private IntrinsicsJvm.kt_3 f18243g;

        public PlatformImplementations.kt_3(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z, boolean z2, boolean z3, IntrinsicsJvm.kt_3 cVar) {
            this.f18239c = null;
            this.f18240d = false;
            this.f18242f = false;
            this.f18239c = dVar;
            this.f18240d = z;
            this.f18241e = z2;
            this.f18242f = z3;
            this.f18243g = cVar;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m19224a() {
            return this.f18242f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Thumbnail doInBackground(Void... voidArr) throws Throwable {
            CameraLog.m12954a("CameraControlUI", "doInBackground, mMediaInfo: " + this.f18239c);
            boolean z = false;
            Process.setThreadPriority(0);
            if (isCancelled() || CameraControlUI.this.f18204m || CameraControlUI.this.f18179ah == null) {
                CameraLog.m12967f("CameraControlUI", "doInBackground, isCancelled: " + isCancelled() + ", mbPaused: " + CameraControlUI.this.f18204m + ", mContentResolver: " + CameraControlUI.this.f18179ah);
                return null;
            }
            if (this.f18238b == null && this.f18241e) {
                Thumbnail c3203e = new Thumbnail();
                c3203e.m19288a(this.f18239c);
                if ("on".equals(Storage.f12095u) && Storage.m11138d()) {
                    z = true;
                }
                int iM19263a = Thumbnail.m19263a(CameraControlUI.this.f18179ah, c3203e, z);
                if (Storage.m11138d() && Util.m24340ac() && iM19263a == 0) {
                    iM19263a = Thumbnail.m19263a(CameraControlUI.this.f18179ah, c3203e, !z);
                }
                CameraLog.m12954a("CameraControlUI", "doInBackground, code: " + iM19263a);
                if (iM19263a != 0) {
                    if (iM19263a == 1) {
                        this.f18238b = c3203e;
                    } else if (iM19263a == 2) {
                        cancel(true);
                    }
                }
            }
            if (CameraControlUI.this.f18158V != null && CameraControlUI.this.m19124ak()) {
                CameraControlUI.this.f18158V.mo10893a(this.f18241e);
            }
            return this.f18238b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Thumbnail c3203e) {
            IntrinsicsJvm.kt_3 cVar;
            CameraLog.m12954a("CameraControlUI", "LoadThumbnailTask, onPostExecute, thumbnail: " + c3203e + ", cancel: " + isCancelled());
            if (isCancelled() || CameraControlUI.this.f18204m) {
                return;
            }
            if (this.f18241e) {
                if (CameraControlUI.this.f18158V.mo10894a()) {
                    CameraControlUI.this.m19100a(c3203e, this.f18240d);
                } else {
                    CameraControlUI.this.m19100a((Thumbnail) null, false);
                }
                Thumbnail c3203e2 = this.f18238b;
                if (c3203e2 == null || (cVar = this.f18243g) == null) {
                    return;
                }
                cVar.mo10895a(c3203e2);
                return;
            }
            CameraControlUI.this.m19067Q();
        }
    }

    /* renamed from: ap */
    public boolean m19129ap() {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            return c3239e.m20446b();
        }
        return false;
    }

    /* renamed from: aq */
    public RelativeLayout m19130aq() {
        return this.f18143G;
    }

    /* renamed from: ar */
    public RelativeLayout m19131ar() {
        return this.f18143G;
    }

    /* renamed from: as */
    public ShutterButton m19132as() {
        return this.f18151O;
    }

    /* renamed from: at */
    public boolean m19133at() {
        CameraUIListener cameraUIListener = this.f18140D;
        return cameraUIListener != null && cameraUIListener.mo10784ba();
    }

    /* renamed from: au */
    public boolean m19134au() {
        CameraUIListener cameraUIListener = this.f18140D;
        return cameraUIListener != null && cameraUIListener.mo10814c();
    }

    /* renamed from: t */
    public void m19211t(boolean z) {
        CameraControlButtonListener cameraControlButtonListener = this.f18139C;
        if (cameraControlButtonListener != null) {
            cameraControlButtonListener.mo10897a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19104a(VideoClipView viewOnClickListenerC3522e) {
        this.f18182ak = viewOnClickListenerC3522e;
    }

    /* renamed from: aP */
    private boolean m19011aP() {
        return Util.m24177G(this.f18137A);
    }

    /* renamed from: u */
    public void m19213u(boolean z) {
        if (m19136aw()) {
            return;
        }
        m18999aD();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.f18177af.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (R.string.camera_mode_more != iIntValue) {
                ModeInfo c3353k = new ModeInfo(this.f18137A, HeadlineHelper.m20352e(iIntValue), HeadlineHelper.m20349c(HeadlineHelper.m20352e(iIntValue)));
                c3353k.m21926c(this.f18137A.getColor(R.color.color_white_with_0_percent_transparency));
                arrayList.add(c3353k);
            }
        }
        if (this.f18190as.getTag(R.id_renamed.tag_arrange_first_time) == null) {
            this.f18190as.setTag(R.id_renamed.tag_arrange_first_time, false);
            this.f18190as.postDelayed(new Runnable() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$S2Mo8ynTjlng6uE_mEMGJdO1RQI
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m19018aW();
                }
            }, 100L);
        } else {
            this.f18190as.setTag(R.id_renamed.tag_arrange_status, true);
        }
        this.f18163aA.setClickable(true);
        m19003aH();
        this.f18192au.m21772a(arrayList);
        if (z) {
            this.f18190as.postDelayed(new Runnable() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$EoxHkP74-oxwpLHi1OraVD7vu8E
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m19017aV();
                }
            }, 300L);
            this.f18189ar = true;
        } else {
            m19017aV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aW */
    public /* synthetic */ void m19018aW() {
        this.f18190as.setTag(R.id_renamed.tag_arrange_status, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aQ, reason: merged with bridge method [inline-methods] */
    public void m19017aV() {
        this.f18189ar = false;
        if (m19129ap() && !m19136aw()) {
            ModePickerView c3239e = this.f18175ad;
            if (c3239e == null || !c3239e.m20464l()) {
                ModePickerView c3239e2 = this.f18175ad;
                if (c3239e2 != null) {
                    c3239e2.setVisibility(0);
                    this.f18190as.scrollToPosition(this.f18192au.getItemCount() - 1);
                    int OplusGLSurfaceView_13 = this.f18167aE;
                    if (3 == OplusGLSurfaceView_13) {
                        this.f18190as.scrollBy(Util.getScreenWidth() / 2, 0);
                    } else if (4 == OplusGLSurfaceView_13) {
                        this.f18190as.scrollBy(-this.f18137A.getResources().getDimensionPixelOffset(R.dimen.rack_mode_mode_edit_head_line_recycle_scroll_offset), 0);
                    } else {
                        this.f18190as.scrollBy(Util.getScreenWidth(), 0);
                    }
                    Runnable runnable = new Runnable() { // from class: com.oplus.camera.ui.control.PlatformImplementations.kt_3.6
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraControlUI.this.m19044s(255);
                            if (CameraControlUI.this.f18190as.getVisibility() != 0) {
                                CameraControlUI.this.f18190as.setVisibility(0);
                            }
                            CameraControlUI.this.f18175ad.setVisibility(8);
                            CameraControlUI.this.f18175ad.setClipToOutline(true);
                        }
                    };
                    if (1 == this.f18167aE) {
                        int[] iArrM19013aR = m19013aR();
                        this.f18175ad.setVisibility(0);
                        this.f18175ad.setClipToOutline(false);
                        this.f18175ad.m20443a(iArrM19013aR, runnable, this.f18183al.mo16411a().mo16570k());
                    } else {
                        this.f18175ad.m20433a(m19014aS(), runnable);
                    }
                }
                Interpolator interpolatorM2772a = PathInterpolatorCompat_2.m2772a(0.33f, 0.0f, 0.67f, 1.0f);
                this.f18164aB = ValueAnimator.ofInt(0, 255);
                this.f18164aB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$uhqZ26rYvPO23QlkxfUSiTlDpaY
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.COUIBaseListPopupWindow_12$0.m19024c(valueAnimator);
                    }
                });
                this.f18164aB.setDuration(200L).setInterpolator(interpolatorM2772a);
                this.f18164aB.setStartDelay(20L);
                this.f18164aB.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m19024c(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f18156T.setImageAlpha(255 - iIntValue);
        m19046t(iIntValue);
        if (this.f18195ax.getVisibility() != 0) {
            this.f18195ax.setVisibility(0);
            this.f18197az.setVisibility(0);
        }
        this.f18195ax.bringToFront();
    }

    /* renamed from: aR */
    private int[] m19013aR() {
        CameraLog.m12954a("CameraControlUI", "getArrangeViewBottoms");
        if (this.f18190as.getLayoutManager() == null) {
            CameraLog.m12954a("CameraControlUI", "getArrangeViewBottoms, layoutManager is null.");
            return new int[1];
        }
        int childCount = this.f18190as.getLayoutManager().getChildCount();
        int[] iArr = new int[childCount];
        Rect rect = new Rect();
        int iK = this.f18183al.mo16411a().mo16570k();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = this.f18190as.getLayoutManager().getChildAt(OplusGLSurfaceView_13);
            if (childAt != null) {
                childAt.getGlobalVisibleRect(rect);
                if (90 == iK) {
                    iArr[OplusGLSurfaceView_13] = rect.left;
                } else if (270 == iK) {
                    iArr[OplusGLSurfaceView_13] = rect.right;
                } else {
                    iArr[OplusGLSurfaceView_13] = rect.bottom;
                }
            }
        }
        return iArr;
    }

    /* renamed from: aS */
    private int m19014aS() {
        if (this.f18190as == null) {
            CameraLog.m12967f("CameraControlUI", "getArrangeViewRight, mModeArrangeView is null");
            return -1;
        }
        View childAt = this.f18190as.getLayoutManager().getChildAt(r0.getLayoutManager().getChildCount() - 1);
        if (childAt == null) {
            return 0;
        }
        return childAt.getLeft();
    }

    /* renamed from: aT */
    private int[] m19015aT() {
        RecyclerView.AbstractC0693i layoutManager;
        View childAt;
        int[] iArr = {0, 0};
        COUIRecyclerView cOUIRecyclerView = this.f18190as;
        if (cOUIRecyclerView == null || (layoutManager = cOUIRecyclerView.getLayoutManager()) == null || (childAt = layoutManager.getChildAt(0)) == null) {
            return iArr;
        }
        iArr[1] = childAt.getLeft();
        iArr[0] = layoutManager.getPosition(childAt);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m19044s(final int OplusGLSurfaceView_13) {
        COUIRecyclerView cOUIRecyclerView = this.f18190as;
        if (cOUIRecyclerView == null) {
            CameraLog.m12967f("CameraControlUI", "updateArrageViewItemsAlpha, mModeArrangeView is null");
            return;
        }
        int childCount = cOUIRecyclerView.getLayoutManager().getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            final View childAt = this.f18190as.getChildAt(i2);
            final TextView textView = (TextView) childAt.findViewById(R.id_renamed.item_mode);
            this.f18183al.mo16411a().mo16534b(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$Rdk-4Mq7MhI7Fxi4OyZQtccSx5s
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m18995a(textView, OplusGLSurfaceView_13, objArr);
                }
            }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$JVZ8lDUixD2DsH43D4sdAD_RlYc
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m18994a(childAt, OplusGLSurfaceView_13, objArr);
                }
            });
            ModeInfo c3353k = (ModeInfo) childAt.getTag(R.id_renamed.tag_recycle_view_mode_info);
            if (c3353k == null) {
                CameraLog.m12967f("CameraControlUI", "updateArrageViewItemsAlpha, OplusGLSurfaceView_13: " + i2 + " info is null, count: " + this.f18192au.getItemCount());
            } else {
                textView.setTextColor(c3353k.m21933g() ? Color.argb(OplusGLSurfaceView_13, 255, 255, 255) : Color.argb(OplusGLSurfaceView_13 / 10, 255, 255, 255));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18995a(TextView textView, int OplusGLSurfaceView_13, Object[] objArr) {
        m19021b(textView, OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18994a(View view, int OplusGLSurfaceView_13, Object[] objArr) {
        m19021b(view, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m19021b(View view, int OplusGLSurfaceView_13) {
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        if (gradientDrawable != null) {
            gradientDrawable.setColor(Color.argb(OplusGLSurfaceView_13 / 10, 255, 255, 255));
            view.setBackground(gradientDrawable);
        }
    }

    /* renamed from: av */
    public void m19135av() {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null && c3239e.m20461i()) {
            this.f18175ad.m20462j();
        }
        COUIRecyclerView cOUIRecyclerView = this.f18190as;
        if (cOUIRecyclerView == null || 4 == cOUIRecyclerView.getVisibility()) {
            CameraLog.m12967f("CameraControlUI", "endArrangeMode, mModeArrangeView: " + this.f18190as);
            return;
        }
        ValueAnimator valueAnimator = this.f18164aB;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        this.f18190as.setTag(R.id_renamed.tag_arrange_status, false);
        this.f18176ae.m20353a();
        this.f18177af = this.f18176ae.m20355b();
        ModePickerView c3239e2 = this.f18175ad;
        if (c3239e2 != null) {
            c3239e2.m20439a(this.f18177af, true, this.f18137A.getString(HeadlineHelper.m20344a(this.f18138B.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON))));
            this.f18175ad.setVisibility(0);
            this.f18175ad.setClipToOutline(false);
            this.f18190as.getViewFlinger().m4038b();
            this.f18190as.clearAnimation();
            this.f18190as.stopScroll();
            if (1 == this.f18167aE) {
                this.f18175ad.m20442a(m19013aR(), this.f18183al.mo16411a().mo16570k());
            } else {
                this.f18175ad.m20453c(m19015aT());
            }
        }
        this.f18190as.setVisibility(4);
        int OplusGLSurfaceView_13 = this.f18204m ? 0 : 200;
        Interpolator interpolatorM2772a = PathInterpolatorCompat_2.m2772a(0.33f, 0.0f, 0.67f, 1.0f);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$2_eaCMU2noyS0VVBT0mh9WiY0b4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.COUIBaseListPopupWindow_12$0.m19020b(valueAnimator2);
            }
        });
        valueAnimatorOfInt.setInterpolator(interpolatorM2772a);
        long OplusGLSurfaceView_15 = OplusGLSurfaceView_13;
        valueAnimatorOfInt.setDuration(OplusGLSurfaceView_15).start();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.08f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(interpolatorM2772a);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$sMKmrjgrvN_VQzsU_lwCwWKiYWQ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.COUIBaseListPopupWindow_12$0.m18991a(valueAnimator2);
            }
        });
        valueAnimatorOfFloat.setDuration(OplusGLSurfaceView_15).start();
        this.f18190as.postDelayed(new Runnable() { // from class: com.oplus.camera.ui.control.-$$Lambda$PlatformImplementations.kt_3$TB4FZXnTCC3wghQyjDwuPEs_oVc
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m19016aU();
            }
        }, OplusGLSurfaceView_15);
        Iterator<ModeInfo> it = this.f18192au.m21774b().iterator();
        while (it.hasNext()) {
            it.next().m21926c(this.f18137A.getColor(R.color.color_white_with_0_percent_transparency));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m19020b(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ThumbImageView thumbImageView = this.f18156T;
        if (thumbImageView != null) {
            thumbImageView.setImageAlpha(255 - iIntValue);
        }
        m19046t(iIntValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18991a(ValueAnimator valueAnimator) {
        this.f18163aA.setDrawableColor(Color.argb((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f), 255, 255, 255));
        this.f18163aA.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aU */
    public /* synthetic */ void m19016aU() {
        this.f18190as.setVisibility(4);
        this.f18195ax.setVisibility(4);
        this.f18197az.setVisibility(4);
    }

    /* renamed from: t */
    private void m19046t(int OplusGLSurfaceView_13) {
        this.f18163aA.setTextColor(Color.argb(OplusGLSurfaceView_13, 255, 255, 255));
        this.f18163aA.setDrawableColor(Color.argb((int) (OplusGLSurfaceView_13 * (Util.m24495t() ? 0.2f : 0.1f)), 255, 255, 255));
        this.f18163aA.invalidate();
    }

    /* renamed from: aw */
    public boolean m19136aw() {
        ViewGroup viewGroup = this.f18195ax;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    /* renamed from: ax */
    public boolean m19137ax() {
        Object tag = this.f18190as.getTag(R.id_renamed.tag_arrange_status);
        if (tag != null) {
            return ((Boolean) tag).booleanValue();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19102a(ItemDragHelper c3348f) {
        this.f18194aw = c3348f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19103a(ModeArrangeListener interfaceC3350h) {
        this.f18165aC = interfaceC3350h;
    }

    @Override // com.oplus.camera.p172ui.menu.p175a.ModePickerView.COUIBaseListPopupWindow_8
    /* renamed from: ay */
    public void mo19138ay() {
        this.f18165aC.mo20026a(false);
    }

    @Override // com.oplus.camera.p172ui.menu.p175a.ModePickerView.COUIBaseListPopupWindow_8
    /* renamed from: az */
    public boolean mo19139az() {
        return this.f18189ar;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19154c(String str) {
        ModePickerView c3239e = this.f18175ad;
        if (c3239e != null) {
            c3239e.m20452c(str);
        }
    }

    /* compiled from: CameraControlUI.java */
    /* renamed from: com.oplus.camera.ui.control.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends GestureDetector.SimpleOnGestureListener {
        private IntrinsicsJvm.kt_4() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (CameraControlUI.this.f18194aw.m21900a() || CameraControlUI.this.f18194aw.m21901b()) {
                return;
            }
            if (CameraControlUI.this.f18163aA.isClickable()) {
                View viewFindChildViewUnder = CameraControlUI.this.f18190as.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (viewFindChildViewUnder != null) {
                    CameraControlUI.this.f18165aC.mo20026a(false);
                    CameraControlUI.this.f18194aw.m21898a(CameraControlUI.this.f18190as, viewFindChildViewUnder, CameraControlUI.this.f18190as.getChildAdapterPosition(viewFindChildViewUnder), motionEvent);
                    return;
                } else {
                    CameraLog.m12967f("CameraControlUI", "onLongPress, can't find child under COUIBaseListPopupWindow_8: " + motionEvent);
                    return;
                }
            }
            CameraLog.m12967f("CameraControlUI", "onLongPress, mConfirmImageView isn't clickable.");
        }
    }

    /* renamed from: aA */
    public boolean m19112aA() {
        return this.f18209r;
    }

    /* renamed from: aB */
    public int m19113aB() {
        return this.f18213v;
    }

    /* renamed from: v */
    public void m19215v(boolean z) {
        this.f18210s = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m19111a(MotionEvent motionEvent) {
        CameraLog.m12954a("CameraControlUI", "handleTouchEvent, event in: " + motionEvent);
        Rect rect = new Rect();
        this.f18150N.getGlobalVisibleRect(rect);
        RectF rectF = new RectF(rect);
        if (this.f18210s || this.f18140D.mo10852i()) {
            CameraLog.m12954a("CameraControlUI", "handleTouchEvent, return when inertialzoom or focusexposure is changing");
            return true;
        }
        int actionIndex = motionEvent.getActionIndex();
        int actionMasked = motionEvent.getActionMasked();
        if (rectF.contains(motionEvent.getRawX(0), motionEvent.getRawY(0)) && 2 == motionEvent.getPointerCount() && 1 == actionIndex) {
            CameraLog.m12954a("CameraControlUI", "handleTouchEvent, return when the first finger is on button");
            return true;
        }
        if (-1 != this.f18213v && 2 != actionMasked && 3 != actionMasked && motionEvent.getPointerId(actionIndex) != this.f18213v) {
            CameraLog.m12954a("CameraControlUI", "handleTouchEvent, return when the second finger is on button: pointerId: " + this.f18213v + " ActionPointerId: " + motionEvent.getPointerId(actionIndex) + " ActionIndex: " + actionIndex);
            return true;
        }
        if (2 == motionEvent.getPointerCount() && (((rectF.contains(motionEvent.getRawX(1), motionEvent.getRawY(1)) && !rectF.contains(motionEvent.getRawX(0), motionEvent.getRawY(0))) || (!rectF.contains(motionEvent.getRawX(1), motionEvent.getRawY(1)) && rectF.contains(motionEvent.getRawX(0), motionEvent.getRawY(0)))) && !this.f18209r)) {
            this.f18209r = true;
            this.f18213v = motionEvent.getPointerId(actionIndex);
            CameraLog.m12954a("CameraControlUI", "handleTouchEvent, there is PlatformImplementations.kt_3 finger on button, pointerId: " + this.f18213v);
        }
        if (this.f18209r && ((6 == actionMasked && this.f18213v == motionEvent.getPointerId(actionIndex)) || 1 == actionMasked || 3 == actionMasked)) {
            this.f18209r = false;
            this.f18213v = -1;
            CameraLog.m12954a("CameraControlUI", "handleTouchEvent, button-finger release/up");
        }
        int OplusGLSurfaceView_13 = 5 == actionMasked ? 0 : (6 == actionMasked || 1 == actionMasked) ? 1 : 3 == actionMasked ? 3 : 2;
        int i2 = this.f18213v;
        int iFindPointerIndex = -1 != i2 ? motionEvent.findPointerIndex(i2) : motionEvent.getPointerCount() - 1;
        if (-1 == iFindPointerIndex) {
            iFindPointerIndex = motionEvent.getPointerCount() - 1;
        }
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        motionEvent.getPointerProperties(iFindPointerIndex, pointerProperties);
        int i3 = this.f18213v;
        if (-1 == i3) {
            i3 = iFindPointerIndex;
        }
        pointerProperties.id_renamed = i3;
        MotionEvent.PointerProperties[] pointerPropertiesArr = {pointerProperties};
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        motionEvent.getPointerCoords(iFindPointerIndex, pointerCoords);
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), OplusGLSurfaceView_13, 1, pointerPropertiesArr, new MotionEvent.PointerCoords[]{pointerCoords}, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        this.f18143G.getGlobalVisibleRect(new Rect());
        motionEventObtain.setLocation(motionEvent.getRawX(iFindPointerIndex) - r5.left, motionEvent.getRawY(iFindPointerIndex) - r5.top);
        CameraLog.m12954a("CameraControlUI", "handleTouchEvent, event out: " + motionEventObtain);
        return this.f18143G.dispatchTouchEvent(motionEventObtain);
    }
}
