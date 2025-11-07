package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.camera2.params.Face;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.p027a.ContextCompat;
import androidx.core.p034f.TextUtilsCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.coui.appcompat.widget.COUIToolTips;
import com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraTipsManager;
import com.oplus.camera.FeedbackUtils;
import com.oplus.camera.Camera;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.camera.doubleexposure.EffectType;
import com.oplus.camera.doubleexposure.VideoClipManager;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.filmvideomode.FilmAnimatorUtil;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p146gl.GLRootView;
import com.oplus.camera.p146gl.p148b.MultiVideoSmallSurfaceTouchEventHelper;
import com.oplus.camera.p151j.CommonBottomGuide;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.GalleryPreviewAdapter;
import com.oplus.camera.p172ui.MicroscopeHintView;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInfo;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintView;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInterface;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintListener;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.control.CameraControlButtonListener;
import com.oplus.camera.p172ui.control.ModeTypeChangedListener;
import com.oplus.camera.p172ui.control.ThumbnailClickListener;
import com.oplus.camera.p172ui.control.MainShutterButton;
import com.oplus.camera.p172ui.control.ShutterButton;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.control.CameraControlUI;
import com.oplus.camera.p172ui.inverse.InverseChangeModeData;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.p172ui.menu.facebeauty.RotateAnimationView;
import com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu;
import com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender;
import com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu;
import com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu;
import com.oplus.camera.p172ui.menu.levelcontrol.GLModelParam;
import com.oplus.camera.p172ui.menu.levelcontrol.SwitchFilterMenu;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import com.oplus.camera.p172ui.menu.setting.CameraDrawerSettingUI;
import com.oplus.camera.p172ui.menu.setting.CameraSettingUI;
import com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.p172ui.modepanel.DataBaseOperator;
import com.oplus.camera.p172ui.modepanel.ItemDragHelper;
import com.oplus.camera.p172ui.modepanel.ModePanelUIControl;
import com.oplus.camera.p172ui.modepanel.MoreUIControl;
import com.oplus.camera.p172ui.modepanel.ModeArrangeListener;
import com.oplus.camera.p172ui.modepanel.ModeTitle;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.p173a.HintModel;
import com.oplus.camera.p172ui.p174b.CameraSuperTextUI;
import com.oplus.camera.p172ui.preview.AISceneUI;
import com.oplus.camera.p172ui.preview.VideoRecordingTimeUI;
import com.oplus.camera.p172ui.preview.AiHintUI;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.CaptureCountDownTimeUI;
import com.oplus.camera.p172ui.preview.FocusIndicatorRotateLayout;
import com.oplus.camera.p172ui.preview.GradienterView;
import com.oplus.camera.p172ui.preview.NormalAISceneUI;
import com.oplus.camera.p172ui.preview.PIAISceneUI;
import com.oplus.camera.p172ui.preview.LongExposureTimeView;
import com.oplus.camera.p172ui.preview.NightTimeView;
import com.oplus.camera.p172ui.preview.ScreenHoleView;
import com.oplus.camera.p172ui.preview.CameraPreviewUI;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener;
import com.oplus.camera.p172ui.preview.p177a.ImageCallback;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.widget.SlowVideoModeSeekBar;
import com.oplus.camera.p172ui.widget.SuperColorToolTips;
import com.oplus.camera.p172ui.widget.SplitBackgroundView;
import com.oplus.camera.p172ui.widget.VideoClipView;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.screen.ScreenModeManager;
import com.oplus.camera.screen.IUIManager;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.out.OutPresentation;
import com.oplus.camera.screen.p163a.OutCaptureManager;
import com.oplus.camera.screen.p163a.OutPreviewManager;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.soloop.SoloopManager;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.p168ui.StickerMenu;
import com.oplus.camera.tiltshift.TiltShiftBlurMenu;
import com.oplus.camera.timelapsepro.TimeLapseProGuideLayout;
import com.oplus.camera.timelapsepro.TimeLapseProMenuLayout;
import com.oplus.camera.timelapsepro.TimeLapseProRecordView;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.DisableUitl;
import com.oplus.camera.util.ToastUtil;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.p125c.p126a.MediaDataManager.kt;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.tblplayer.misc.MediaInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CameraUIManager.java */
/* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class CameraUIManager implements CameraConstant, IUIManager, CameraUIInterface, CameraSettingUI.PlatformImplementations.kt_3, CameraPreviewUI.IntrinsicsJvm.kt_4, VideoClipView.IntrinsicsJvm.kt_4 {

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean f18338g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static boolean f18339h;

    /* renamed from: A */
    private CameraPreviewUI f18340A;

    /* renamed from: B */
    private ComboPreferences f18341B;

    /* renamed from: H */
    private CameraSettingUI f18347H;

    /* renamed from: I */
    private CameraDrawerSettingUI f18348I;

    /* renamed from: J */
    private CameraUIListener f18349J;

    /* renamed from: Y */
    private boolean f18364Y;

    /* renamed from: ac */
    private HintManager f18394ac;

    /* renamed from: ae */
    private CameraScreenHintView f18396ae;

    /* renamed from: af */
    private CameraScreenHintView f18397af;

    /* renamed from: ag */
    private CameraScreenHintView f18398ag;

    /* renamed from: bM */
    private RotateAnimationView f18430bM;

    /* renamed from: bN */
    private RotateAnimationView f18431bN;

    /* renamed from: bO */
    private RotateAnimationView f18432bO;

    /* renamed from: bP */
    private TimeLapseProMenuLayout f18433bP;

    /* renamed from: bQ */
    private TimeLapseProGuideLayout f18434bQ;

    /* renamed from: bR */
    private TimeLapseProRecordView f18435bR;

    /* renamed from: bS */
    private AnimatorSet f18436bS;

    /* renamed from: bT */
    private AnimatorSet f18437bT;

    /* renamed from: bU */
    private AnimatorSet f18438bU;

    /* renamed from: bV */
    private AnimatorSet f18439bV;

    /* renamed from: bx */
    private BaseScreenMode f18467bx;

    /* renamed from: cp */
    private View.OnClickListener f18486cp;

    /* renamed from: OplusGLSurfaceView_13 */
    private Activity f18497i;

    /* renamed from: OplusGLSurfaceView_15 */
    private OutPreviewManager f18498j;

    /* renamed from: OplusGLSurfaceView_5 */
    private OutCaptureManager f18499k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ScreenModeManager f18500l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f18501m;

    /* renamed from: y */
    private CameraSuperTextUI f18513y;

    /* renamed from: z */
    private CameraControlUI f18514z;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f18502n = false;

    /* renamed from: o */
    private boolean f18503o = false;

    /* renamed from: p */
    private boolean f18504p = false;

    /* renamed from: q */
    private boolean f18505q = false;

    /* renamed from: r */
    private boolean f18506r = false;

    /* renamed from: s */
    private boolean f18507s = false;

    /* renamed from: t */
    private boolean f18508t = false;

    /* renamed from: u */
    private boolean f18509u = false;

    /* renamed from: v */
    private boolean f18510v = false;

    /* renamed from: w */
    private boolean f18511w = false;

    /* renamed from: x */
    private boolean f18512x = false;

    /* renamed from: C */
    private SoloopManager f18342C = null;

    /* renamed from: D */
    private VideoRecordingTimeUI f18343D = null;

    /* renamed from: E */
    private CaptureCountDownTimeUI f18344E = null;

    /* renamed from: F */
    private NightTimeView f18345F = null;

    /* renamed from: G */
    private LongExposureTimeView f18346G = null;

    /* renamed from: K */
    private int f18350K = 1;

    /* renamed from: L */
    private int f18351L = 0;

    /* renamed from: M */
    private int f18352M = 0;

    /* renamed from: N */
    private int f18353N = 0;

    /* renamed from: O */
    private int f18354O = 0;

    /* renamed from: P */
    private int f18355P = 0;

    /* renamed from: Q */
    private int f18356Q = 0;

    /* renamed from: R */
    private int f18357R = -1;

    /* renamed from: S */
    private int f18358S = 0;

    /* renamed from: T */
    private int f18359T = 0;

    /* renamed from: U */
    private long f18360U = 0;

    /* renamed from: V */
    private long f18361V = 0;

    /* renamed from: W */
    private long f18362W = 0;

    /* renamed from: X */
    private long f18363X = 0;

    /* renamed from: Z */
    private ViewGroup f18365Z = null;

    /* renamed from: aa */
    private View f18392aa = null;

    /* renamed from: ab */
    private View f18393ab = null;

    /* renamed from: ad */
    private HintManager.PlatformImplementations.kt_3 f18395ad = null;

    /* renamed from: ah */
    private FilterEffectMenu f18399ah = null;

    /* renamed from: ai */
    private BlurMenu f18400ai = null;

    /* renamed from: aj */
    private CameraScreenHintView f18401aj = null;

    /* renamed from: ak */
    private SwitchFilterMenu f18402ak = null;

    /* renamed from: al */
    private View f18403al = null;

    /* renamed from: am */
    private CameraScreenHintView f18404am = null;

    /* renamed from: an */
    private MicroscopeHintView f18405an = null;

    /* renamed from: ao */
    private LottieAnimationView f18406ao = null;

    /* renamed from: ap */
    private LottieAnimationView f18407ap = null;

    /* renamed from: aq */
    private ImageView f18408aq = null;

    /* renamed from: ar */
    private COUIToolTips f18409ar = null;

    /* renamed from: as */
    private SuperColorToolTips f18410as = null;

    /* renamed from: at */
    private PopupWindow f18411at = null;

    /* renamed from: au */
    private COUIToolTips f18412au = null;

    /* renamed from: av */
    private PopupWindow f18413av = null;

    /* renamed from: aw */
    private SuperColorToolTips f18414aw = null;

    /* renamed from: ax */
    private SuperColorToolTips f18415ax = null;

    /* renamed from: ay */
    private SuperColorToolTips f18416ay = null;

    /* renamed from: az */
    private COUIToolTips f18417az = null;

    /* renamed from: aA */
    private SuperColorToolTips f18366aA = null;

    /* renamed from: aB */
    private SuperColorToolTips f18367aB = null;

    /* renamed from: aC */
    private SuperColorToolTips f18368aC = null;

    /* renamed from: aD */
    private SuperColorToolTips f18369aD = null;

    /* renamed from: aE */
    private byte f18370aE = 0;

    /* renamed from: aF */
    private Map<String, ConcurrentHashMap<Integer, View>> f18371aF = new HashMap();

    /* renamed from: aG */
    private Map<String, ExpandableMenuPanel> f18372aG = new HashMap();

    /* renamed from: aH */
    private AISceneUI f18373aH = null;

    /* renamed from: aI */
    private GradienterView f18374aI = null;

    /* renamed from: aJ */
    private ModePanelUIControl f18375aJ = null;

    /* renamed from: aK */
    private ExpandableMenuPanel f18376aK = null;

    /* renamed from: aL */
    private SplitBackgroundView f18377aL = null;

    /* renamed from: aM */
    private SplitBackgroundView f18378aM = null;

    /* renamed from: aN */
    private View.OnClickListener f18379aN = null;

    /* renamed from: aO */
    private int f18380aO = 0;

    /* renamed from: aP */
    private int f18381aP = 0;

    /* renamed from: aQ */
    private RotateAnimationView f18382aQ = null;

    /* renamed from: aR */
    private TouchDelegate f18383aR = null;

    /* renamed from: aS */
    private BlurMenu f18384aS = null;

    /* renamed from: aT */
    private FaceBeautyMenu f18385aT = null;

    /* renamed from: aU */
    private AnimatorSet f18386aU = null;

    /* renamed from: aV */
    private AnimatorSet f18387aV = null;

    /* renamed from: aW */
    private AnimatorSet f18388aW = null;

    /* renamed from: aX */
    private AnimatorSet f18389aX = null;

    /* renamed from: aY */
    private AnimatorSet f18390aY = null;

    /* renamed from: aZ */
    private AnimatorSet f18391aZ = null;

    /* renamed from: ba */
    private PathInterpolator f18444ba = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: bb */
    private PathInterpolator f18445bb = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: bc */
    private boolean f18446bc = false;

    /* renamed from: bd */
    private MoreUIControl f18447bd = null;

    /* renamed from: be */
    private boolean f18448be = false;

    /* renamed from: bf */
    private int f18449bf = 0;

    /* renamed from: bg_renamed */
    private CommonBottomGuide f18450bg = null;

    /* renamed from: bh */
    private SlowVideoModeSeekBar f18451bh = null;

    /* renamed from: bi */
    private Size f18452bi = null;

    /* renamed from: bj */
    private boolean f18453bj = false;

    /* renamed from: bk */
    private AiHintUI f18454bk = null;

    /* renamed from: bl */
    private boolean f18455bl = true;

    /* renamed from: bm */
    private boolean f18456bm = true;

    /* renamed from: bn */
    private boolean f18457bn = true;

    /* renamed from: bo */
    private boolean f18458bo = false;

    /* renamed from: bp */
    private boolean f18459bp = false;

    /* renamed from: bq */
    private boolean f18460bq = true;

    /* renamed from: br */
    private boolean f18461br = true;

    /* renamed from: bs */
    private VideoClipManager f18462bs = null;

    /* renamed from: bt */
    private ItemDragHelper f18463bt = null;

    /* renamed from: bu */
    private int f18464bu = 0;

    /* renamed from: bv */
    private int f18465bv = 0;

    /* renamed from: bw */
    private boolean f18466bw = false;

    /* renamed from: by */
    private SplitBackgroundView f18468by = null;

    /* renamed from: bz */
    private OutScreenButtonBoxView f18469bz = null;

    /* renamed from: bA */
    private RotateAnimationView f18418bA = null;

    /* renamed from: bB */
    private boolean f18419bB = false;

    /* renamed from: bC */
    private boolean f18420bC = false;

    /* renamed from: bD */
    private boolean f18421bD = false;

    /* renamed from: bE */
    private boolean f18422bE = false;

    /* renamed from: bF */
    private ViewGroup f18423bF = null;

    /* renamed from: bG */
    private GalleryBottomMenuLayout f18424bG = null;

    /* renamed from: bH */
    private GalleryPreviewAdapter f18425bH = null;

    /* renamed from: bI */
    private GalleryPreviewItemDecoration f18426bI = null;

    /* renamed from: bJ */
    private ViewPager2 f18427bJ = null;

    /* renamed from: bK */
    private InverseTextView f18428bK = null;

    /* renamed from: bL */
    private List<MediaItem.kt> f18429bL = new ArrayList();

    /* renamed from: bW */
    private int f18440bW = 0;

    /* renamed from: bX */
    private int f18441bX = 0;

    /* renamed from: bY */
    private boolean f18442bY = false;

    /* renamed from: bZ */
    private boolean f18443bZ = false;

    /* renamed from: ca */
    private int f18471ca = 0;

    /* renamed from: cb */
    private long f18472cb = -1;

    /* renamed from: cc */
    private List<SplitBackgroundView> f18473cc = new ArrayList();

    /* renamed from: cd */
    private RecyclerView.AbstractC0687c f18474cd = new RecyclerView.AbstractC0687c() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.1
        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onChanged() {
            super.onChanged();
            int itemCount = CameraUIManager.this.f18425bH.getItemCount();
            int OplusGLSurfaceView_13 = itemCount == 0 ? 4 : 0;
            int i2 = itemCount == 0 ? 0 : 4;
            if (CameraUIManager.this.f18424bG != null) {
                CameraUIManager.this.f18424bG.setVisibility(OplusGLSurfaceView_13);
            }
            if (CameraUIManager.this.f18428bK != null) {
                CameraUIManager.this.f18428bK.setVisibility(i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeChanged(int OplusGLSurfaceView_13, int i2) {
            super.onItemRangeChanged(OplusGLSurfaceView_13, i2);
            int itemCount = CameraUIManager.this.f18425bH.getItemCount();
            int i3 = itemCount == 0 ? 4 : 0;
            int i4 = itemCount == 0 ? 0 : 4;
            if (CameraUIManager.this.f18424bG != null) {
                CameraUIManager.this.f18424bG.setVisibility(i3);
            }
            if (CameraUIManager.this.f18428bK != null) {
                CameraUIManager.this.f18428bK.setVisibility(i4);
            }
        }
    };

    /* renamed from: ce */
    private TimeLapseProMenuLayout.COUIBaseListPopupWindow_8 f18475ce = new CameraUIManager_2();

    /* renamed from: cf */
    private Runnable f18476cf = new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$5JyfENlEQTRIbhQAMR65X0Nz7ks
        @Override // java.lang.Runnable
        public final void run() {
            this.COUIBaseListPopupWindow_12$0.m19548gH();
        }
    };

    /* renamed from: cg */
    private FaceBeautyFilterListener f18477cg = new FaceBeautyFilterListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.22
        @Override // com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20029a(boolean z) {
            CameraLog.m12954a("CameraUIManager", "showFilterEffectMenu, needAni: " + z);
            CameraUIManager.this.f18399ah.m20866a();
            SharedPreferences.Editor editorEdit = CameraUIManager.this.f18341B.edit();
            if (CameraUIManager.this.m19490fF()) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            }
            if (CameraUIManager.this.f18349J != null) {
                String strMo10700aE = CameraUIManager.this.f18349J.mo10700aE();
                if (CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(strMo10700aE) || CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(strMo10700aE) || CameraUIInterface.KEY_NIGHT_FILTER_MENU.equals(strMo10700aE)) {
                    CameraUIManager.this.f18349J.mo10718aW();
                }
                if (CameraUIManager.this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && FilterHelper.m22633g() && !CameraCharacteristicsUtil.m12974a(CameraUIManager.this.mo19845cv())) {
                    editorEdit.putBoolean(CameraUIInterface.PRE_FACE_BEAUTY_ICON_RECEOMMEND_CLICKED, true);
                }
            }
            editorEdit.apply();
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo20030b(boolean z) {
            if (CameraUIManager.this.f18399ah != null) {
                CameraUIManager.this.f18399ah.m20873a(z);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo20032c(boolean z) {
            if (CameraUIManager.this.f18399ah != null) {
                CameraUIManager.this.f18399ah.m20878b(z);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20028a(int OplusGLSurfaceView_13) {
            if (CameraUIManager.this.f18399ah != null) {
                CameraUIManager.this.f18399ah.setBeautyShowDelay(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20027a() {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10855j(false);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo20031b() {
            if (CameraUIManager.this.f18399ah != null) {
                return CameraUIManager.this.f18399ah.isAnimationRunning() || CameraUIManager.this.f18399ah.m20890h();
            }
            return false;
        }
    };

    /* renamed from: ch */
    private ImageCallback f18478ch = new ImageCallback() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.32
        @Override // com.oplus.camera.p172ui.preview.p177a.ImageCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12657a(ArrayList<StickerMenu.IntrinsicsJvm.kt_4> arrayList, int OplusGLSurfaceView_13, StickerItem stickerItem, boolean z) {
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.ImageCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12656a(GLModelParam c3284i) {
            CameraLog.m12954a("CameraUIManager", "imageReady");
            if (CameraUIManager.this.f18399ah == null || CameraUIManager.this.f18504p) {
                return;
            }
            CameraUIManager.this.f18399ah.m20871a(c3284i);
        }
    };

    /* renamed from: ci */
    private AISceneUI.PlatformImplementations.kt_3 f18479ci = new AISceneUI.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.43
        @Override // com.oplus.camera.p172ui.preview.AISceneUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20036a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
            CameraLog.m12954a("CameraUIManager", "setPIEnable, code: " + OplusGLSurfaceView_13 + ", enbalbe: " + z + ", changeByClick: " + z2);
            if (12 == OplusGLSurfaceView_13) {
                CameraUIManager.this.f18507s = true;
                CameraUIManager.this.f18355P = 0;
                if (CameraUIManager.this.f18483cm != null) {
                    CameraUIManager.this.f18483cm.removeMessages(1);
                }
            }
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10682a(OplusGLSurfaceView_13, z, z2);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.AISceneUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20034a() {
            CameraUIManager.this.f18394ac.m18473a(CameraUIManager.this.f18354O);
        }

        @Override // com.oplus.camera.p172ui.preview.AISceneUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo20037b() {
            CameraUIManager.this.f18394ac.m18500e();
        }

        @Override // com.oplus.camera.p172ui.preview.AISceneUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20035a(int OplusGLSurfaceView_13) {
            if (CameraUIManager.this.f18349J == null || CameraUIManager.this.f18349J.mo10878t()) {
                if (OplusGLSurfaceView_13 == 12) {
                    CameraUIManager.this.f18507s = true;
                    CameraUIManager.this.f18355P = 0;
                    if (CameraUIManager.this.f18483cm != null) {
                        CameraUIManager.this.f18483cm.removeMessages(1);
                    }
                    CameraUIManager.this.m19487fC();
                }
                if (CameraUIManager.this.f18349J != null) {
                    CameraUIManager.this.f18349J.mo10810c(OplusGLSurfaceView_13);
                    return;
                }
                return;
            }
            CameraLog.m12967f("CameraUIManager", "onAISceneClosed, canRespondTouch is false!");
        }

        @Override // com.oplus.camera.p172ui.preview.AISceneUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo20038b(int OplusGLSurfaceView_13) {
            m20033a(CameraUIManager.this.f18373aH != null && CameraUIManager.this.f18373aH.mo22232i());
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m20033a(boolean z) {
            if (CameraUIManager.this.f18341B == null || "on".equals(CameraUIManager.this.f18341B.getString(CameraUIInterface.KEY_SUB_SETTING, "off")) || CameraUIManager.this.f18349J == null || CameraUIManager.this.f18349J.mo10712aQ() || z) {
                return;
            }
            CameraUIManager.this.f18349J.mo10708aM();
        }
    };

    /* renamed from: cj */
    private CameraScreenHintListener f18480cj = new CameraScreenHintListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.54
        @Override // com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18856a(int OplusGLSurfaceView_13) {
            if (CameraUIManager.this.f18373aH != null) {
                CameraUIManager.this.f18373aH.mo22216a(OplusGLSurfaceView_13 == 0, CameraUIManager.this.mo19966j(CameraUIInterface.KEY_AI_SCN));
            }
        }

        @Override // com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintListener
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo18855a() {
            if (CameraUIManager.this.f18349J != null) {
                return CameraUIManager.this.f18349J.mo10868n();
            }
            return 0;
        }
    };

    /* renamed from: ck */
    private CameraScreenHintInterface f18481ck = new CameraScreenHintInterface() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.65
        @Override // com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo15097a() {
            if (CameraUIManager.this.f18349J != null) {
                return CameraUIManager.this.f18349J.mo10759bB();
            }
            return false;
        }
    };

    /* renamed from: cl */
    private View.OnLayoutChangeListener f18482cl = new View.OnLayoutChangeListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.75
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (CameraUIManager.this.f18479ci != null) {
                if (CameraUIManager.this.f18373aH.mo22221c()) {
                    CameraUIManager.this.f18479ci.mo20038b(i3 - OplusGLSurfaceView_13);
                } else {
                    CameraUIManager.this.f18479ci.mo20038b(0);
                }
            }
        }
    };

    /* renamed from: cm */
    private Handler f18483cm = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.79
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12954a("CameraUIManager", "handleMessage, msg: " + message.what);
            switch (message.what) {
                case 1:
                    if (!CameraUIManager.this.f18504p && CameraUIManager.this.f18373aH != null && CameraUIManager.this.f18349J != null && CameraUIManager.this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS)) {
                        CameraUIManager.this.f18355P = 2;
                        CameraUIManager c3208d = CameraUIManager.this;
                        c3208d.mo18242m(c3208d.f18354O);
                        break;
                    }
                    break;
                case 2:
                    if (message.obj != null && CameraUIManager.this.f18373aH != null && !CameraUIManager.this.f18503o) {
                        int iIntValue = ((Integer) message.obj).intValue();
                        CameraUIManager.this.f18373aH.mo22218b(iIntValue);
                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                            CameraUIManager.this.m19433ah(iIntValue);
                        } else if (CameraUIManager.this.m19864dH()) {
                            CameraUIManager.this.f18483cm.obtainMessage(2, Integer.valueOf(iIntValue)).sendToTarget();
                        } else if (!CameraUIManager.this.mo18059T()) {
                            CameraUIManager.this.m19436ai(iIntValue);
                        }
                        CameraUIManager.this.f18354O = iIntValue;
                        break;
                    }
                    break;
                case 3:
                    CameraUIManager.this.m19816cS();
                    break;
                case 4:
                    CameraUIManager.this.m19946et();
                    break;
                case 5:
                    if (CameraUIManager.this.f18454bk != null && CameraUIManager.this.f18454bk.m23173b()) {
                        CameraUIManager.this.mo18239l(true);
                    }
                    CameraUIManager.this.m19365U(1);
                    break;
                case 6:
                    CameraUIManager.this.f18455bl = false;
                    CameraUIManager.this.mo18239l(true);
                    if (!CameraUIManager.this.f18511w) {
                        if (CameraUIManager.this.f18349J != null) {
                            CameraUIManager.this.f18349J.mo10681a(CameraUIManager.this.f18454bk.m23168a(), false);
                            break;
                        }
                    } else {
                        CameraUIManager.this.f18511w = false;
                        break;
                    }
                    break;
                case 7:
                    CameraUIManager.this.f18406ao.m5507a();
                    break;
                case 8:
                    if (CameraUIManager.this.f18406ao != null && CameraUIManager.this.f18483cm != null) {
                        CameraUIManager.this.f18406ao.m5518e();
                        CameraUIManager.this.f18406ao.setProgress(0.0f);
                        CameraUIManager.this.f18406ao.setVisibility(8);
                        CameraUIManager.this.f18483cm.removeCallbacksAndMessages(null);
                        break;
                    }
                    break;
                case 9:
                    if (CameraUIManager.this.f18454bk != null && CameraUIManager.this.f18454bk.m23173b()) {
                        CameraUIManager.this.mo18239l(true);
                    }
                    CameraUIManager.this.m19365U(0);
                    break;
                case 10:
                    CameraUIManager.this.f18456bm = false;
                    CameraUIManager.this.mo18239l(true);
                    if (!CameraUIManager.this.f18511w) {
                        if (CameraUIManager.this.f18349J != null) {
                            CameraUIManager.this.f18349J.mo10681a(CameraUIManager.this.f18454bk.m23168a(), false);
                            break;
                        }
                    } else {
                        CameraUIManager.this.f18511w = false;
                        break;
                    }
                    break;
                case 11:
                    if (CameraUIManager.this.f18454bk != null && CameraUIManager.this.f18454bk.m23173b()) {
                        CameraUIManager.this.mo18239l(true);
                    }
                    CameraUIManager.this.m19365U(2);
                    break;
                case 12:
                    CameraUIManager.this.f18457bn = false;
                    CameraUIManager.this.mo18239l(true);
                    break;
                case 13:
                    CameraUIManager.this.mo18227i(true);
                    break;
                case 14:
                    if (CameraUIManager.this.f18407ap != null) {
                        CameraUIManager.this.f18407ap.setVisibility(0);
                        CameraUIManager.this.f18407ap.m5507a();
                        break;
                    }
                    break;
                case 15:
                    if (CameraUIManager.this.f18407ap != null && CameraUIManager.this.f18483cm != null) {
                        CameraUIManager.this.f18407ap.m5518e();
                        CameraUIManager.this.f18407ap.setProgress(0.0f);
                        CameraUIManager.this.f18407ap.setVisibility(8);
                        CameraUIManager.this.f18483cm.removeMessages(14);
                        break;
                    }
                    break;
            }
        }
    };

    /* renamed from: cn */
    private ModeArrangeListener f18484cn = new ModeArrangeListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.2
        @Override // com.oplus.camera.p172ui.modepanel.ModeArrangeListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20026a(boolean z) {
            CameraUIManager.this.m19411aL(z);
        }

        @Override // com.oplus.camera.p172ui.modepanel.ModeArrangeListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20025a() {
            CameraUIManager.this.m19918eF();
        }
    };

    /* renamed from: co */
    private View.OnClickListener f18485co = new View.OnClickListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strMo10701aF;
            if (CameraUIManager.this.f18349J == null || !(CameraUIManager.this.f18349J.mo10734am() || CameraUIManager.this.f18349J.mo10729ah() || CameraUIManager.this.f18349J.mo10730ai() || CameraUIManager.this.f18349J.mo10807bx())) {
                if (CameraUIManager.this.m19751bK() && Util.m24498u()) {
                    CameraUIManager.this.m19846cw();
                }
                if (CameraUIManager.this.f18349J != null && CameraUIManager.this.f18349J.mo10848h(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU)) {
                    boolean zEquals = "on".equals(CameraUIManager.this.f18341B.getString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, CameraUIManager.this.f18497i.getString(R.string.camera_multicamera_type_default)));
                    SharedPreferences.Editor editorEdit = CameraUIManager.this.f18341B.edit();
                    if (!zEquals) {
                        editorEdit.putString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM, "on");
                    }
                    editorEdit.putString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, zEquals ? "off" : "on").apply();
                }
                if (CameraUIManager.this.f18349J == null || !CameraUIManager.this.f18349J.mo10848h(CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU)) {
                    if (CameraUIManager.this.f18495cy.mo20015g()) {
                        if (CameraUIManager.this.f18400ai != null && !CameraUIManager.this.f18400ai.isMenuOpen() && CameraUIManager.this.f18348I != null && CameraUIManager.this.f18348I.m21413c()) {
                            CameraUIManager.this.f18348I.m21403a(8);
                        }
                        strMo10701aF = CameraUIInterface.KEY_VIDEO_BLUR_MENU;
                    } else if (CameraUIManager.this.f18495cy.mo20016h()) {
                        strMo10701aF = CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU;
                    } else {
                        strMo10701aF = CameraUIManager.this.f18495cy.mo20010b() ? CameraUIManager.this.f18349J.mo10701aF() : "";
                    }
                    CameraUIManager.this.f18349J.mo10695a(strMo10701aF, false, false);
                    return;
                }
                if (PreferenceManager.m3981a(CameraUIManager.this.f18497i).getBoolean("street_long_exposure_reddot_show", true)) {
                    PreferenceManager.m3981a(CameraUIManager.this.f18497i).edit().putBoolean("street_long_exposure_reddot_show", false).apply();
                }
                if (CameraUIManager.this.f18341B != null) {
                    CameraUIManager.this.f18341B.edit().putBoolean(CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU, !CameraUIManager.this.f18341B.getBoolean(CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU, true)).apply();
                }
            }
        }
    };

    /* renamed from: cq */
    private final View.OnClickListener f18487cq = new View.OnClickListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            int id_renamed = view.getId();
            if (id_renamed == R.id_renamed.time_lapse_pro_setting_button) {
                if (!CameraUIManager.this.m19950ex() || CameraUIManager.this.f18433bP.m17745c()) {
                    if (CameraUIManager.this.f18486cp != null) {
                        CameraUIManager.this.f18486cp.onClick(view);
                        return;
                    }
                    return;
                } else {
                    CameraUIManager.this.f18433bP.m17757o();
                    CameraUIManager.this.mo18054Q(true);
                    CameraUIManager c3208d = CameraUIManager.this;
                    c3208d.m19854d(false, true, c3208d.f18433bP.m17745c());
                    return;
                }
            }
            if (id_renamed != R.id_renamed.time_lapse_pro_template_button) {
                return;
            }
            if (!CameraUIManager.this.m19950ex() || !CameraUIManager.this.f18433bP.m17745c()) {
                if (CameraUIManager.this.f18486cp != null) {
                    CameraUIManager.this.f18486cp.onClick(view);
                }
            } else {
                CameraUIManager.this.f18433bP.m17757o();
                CameraUIManager.this.mo18054Q(true);
                CameraUIManager c3208d2 = CameraUIManager.this;
                c3208d2.m19854d(false, true, c3208d2.f18433bP.m17745c());
            }
        }
    };

    /* renamed from: cr */
    private View.OnClickListener f18488cr = new View.OnClickListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraUIManager.this.f18500l != null) {
                if (CameraUIManager.this.f18349J != null) {
                    CameraUIManager.this.f18349J.mo10836f(88, 3 == CameraUIManager.this.mo18134aX() ? 2 : 1);
                }
                CameraUIManager.this.f18500l.m16668h();
            }
        }
    };

    /* renamed from: cs */
    private OutCaptureManager.IntrinsicsJvm.kt_4 f18489cs = new OutCaptureManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.6
        @Override // com.oplus.camera.screen.p163a.OutCaptureManager.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16440a(boolean z) {
            if (CameraUIManager.this.f18514z != null) {
                if (CameraUIManager.this.m19864dH()) {
                    if (CameraUIManager.this.f18514z.m19136aw() && CameraUIManager.this.f18514z.m19137ax()) {
                        CameraUIManager.this.f18484cn.mo20025a();
                    }
                    CameraUIManager.this.m19437aj(-1);
                }
                if (z) {
                    CameraUIManager.this.f18514z.m19128ao();
                } else {
                    CameraUIManager.this.f18514z.m19082a(CameraUIManager.this.mo19845cv(), CameraUIManager.this.mo18132aV());
                }
                CameraUIManager.this.f18514z.m19189l(z);
            }
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.m19761bU();
                if (CameraUIManager.this.f18349J.mo10658L()) {
                    CameraUIManager.this.f18349J.mo10659M();
                }
                if (CameraUIManager.this.f18349J.mo10814c()) {
                    CameraUIManager.this.f18349J.mo10831e();
                }
            }
            if (!z && CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10783bZ();
            }
            if (CameraUIManager.this.f18385aT != null && CameraUIManager.this.f18385aT.m20689n()) {
                CameraUIManager.this.mo18109a(true, true, true, true);
                CameraUIManager.this.f18349J.mo10706aK();
            }
            CameraUIManager.this.mo18225i();
        }

        @Override // com.oplus.camera.screen.p163a.OutCaptureManager.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16439a() {
            CameraUIManager.this.f18499k.m16431a(CameraUIManager.this.f18497i, CameraUIManager.this.f18489cs);
        }
    };

    /* renamed from: ct */
    private OutPreviewManager.IntrinsicsJvm.kt_4 f18490ct = new OutPreviewManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.7
        @Override // com.oplus.camera.screen.p163a.OutPreviewManager.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16458a(OutPresentation presentationC2959e) {
            CameraUIManager.this.mo18183c().m14231a(presentationC2959e);
            CameraUIManager.this.f18340A.m23346a(presentationC2959e);
            CameraUIManager.this.f18469bz.setHighLight(true);
            CameraUIManager.this.f18394ac.m18475a(R.string.camera_out_small_preview_enable, false, true, 5500, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, 0, false, false, false, -1, new Object[0]);
            CameraUIManager.this.m19895dm();
        }

        @Override // com.oplus.camera.screen.p163a.OutPreviewManager.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo16461b(OutPresentation presentationC2959e) {
            CameraUIManager.this.mo18183c().m14231a((OutPresentation) null);
            CameraUIManager.this.f18340A.m23346a((OutPresentation) null);
            CameraUIManager.this.f18469bz.setHighLight(false);
            CameraUIManager.this.f18394ac.m18489a(R.string.camera_out_small_preview_enable);
            CameraUIManager.this.f18498j.m16454c();
        }

        @Override // com.oplus.camera.screen.p163a.OutPreviewManager.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16457a() {
            CameraUIManager.this.f18498j.m16451a(false);
            CameraUIManager.this.f18499k.m16431a(CameraUIManager.this.f18497i, CameraUIManager.this.f18489cs);
            CameraUIManager.this.f18349J.mo10680a(71, "1");
        }

        @Override // com.oplus.camera.screen.p163a.OutPreviewManager.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo16460b() {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10750b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_CAMERA_HIGH_TEMPERATURE_OUT_PREVIEW_DISABLE);
            }
        }

        @Override // com.oplus.camera.screen.p163a.OutPreviewManager.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo16459a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
            return CameraUIManager.this.f18349J.mo10692a(OplusGLSurfaceView_13, keyEvent);
        }

        @Override // com.oplus.camera.screen.p163a.OutPreviewManager.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo16462b(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
            return CameraUIManager.this.f18349J.mo10756b(OplusGLSurfaceView_13, keyEvent);
        }

        @Override // com.oplus.camera.screen.p163a.OutPreviewManager.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo16463c() {
            CameraUIManager.this.f18499k.m16430a();
        }
    };

    /* renamed from: cu */
    private View.OnClickListener f18491cu = new View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$rbzU_YuH03OjYyj20G982ZAoT9I
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.COUIBaseListPopupWindow_12$0.m19390a(view);
        }
    };

    /* renamed from: cv */
    private View.OnClickListener f18492cv = new View.OnClickListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick");
            CameraUIManager.this.mo18210f(17, true);
            CameraUIManager.this.mo18210f(20, true);
            if (CameraUIManager.this.f18349J != null && 1 == CameraUIManager.this.f18349J.mo10672Z() && CameraUIManager.this.f18514z.m19116ac()) {
                CameraUIManager.this.f18514z.m19117ad();
            }
            if (CameraUIManager.this.m19751bK() && Util.m24498u()) {
                CameraUIManager.this.m19846cw();
            }
            if (CameraUIManager.this.mo18111aA() || CameraUIManager.this.m19949ew()) {
                CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, MultiCameraTypeLayout is Visible");
                return;
            }
            if (!CameraUIManager.this.mo19929ec()) {
                CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, preview not started");
                return;
            }
            if (CameraUIManager.this.m19862dF()) {
                CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isHeadlineScrolling: true");
                return;
            }
            if (CameraUIManager.this.m19870dN()) {
                CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isMoreModePanelAnimRunning: true");
                return;
            }
            if (CameraUIManager.this.mo18057R()) {
                CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isMoreModeShown: true");
                return;
            }
            if (!CameraUIManager.this.mo19929ec()) {
                CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isPreviewStarted: false");
                return;
            }
            if (!CameraUIManager.this.mo18051O()) {
                if (CameraUIManager.this.f18349J == null || !CameraUIManager.this.f18349J.mo10658L()) {
                    if (CameraUIManager.this.f18349J == null || !CameraUIManager.this.f18349J.mo10729ah()) {
                        if (CameraUIManager.this.f18385aT != null && !CameraUIManager.this.f18385aT.m20688m() && !CameraUIManager.this.f18399ah.isAnimationRunning() && !CameraUIManager.this.f18400ai.isAnimationRunning() && (CameraUIManager.this.f18384aS == null || !CameraUIManager.this.f18384aS.isAnimationRunning())) {
                            if (!CameraUIManager.this.f18385aT.m20689n()) {
                                if (CameraUIManager.this.f18454bk != null && CameraUIManager.this.f18454bk.m23173b() && ((10 == CameraUIManager.this.f18356Q || 16 == CameraUIManager.this.f18356Q) && 2 == CameraUIManager.this.f18454bk.m23168a())) {
                                    CameraUIManager.this.f18483cm.sendEmptyMessage(12);
                                }
                                if (CameraUIManager.this.f18385aT.mo20591b() == 3 || CameraUIManager.this.f18349J.mo10705aJ()) {
                                    CameraUIManager.this.mo18275u(true);
                                }
                                if (CameraUIManager.this.f18348I != null && CameraUIManager.this.f18348I.m21413c()) {
                                    CameraUIManager.this.f18348I.m21403a(8);
                                }
                                CameraUIManager.this.m19408aI(true);
                                return;
                            }
                            CameraUIManager.this.mo18109a(true, true, true, true);
                            CameraUIManager.this.f18349J.mo10706aK();
                            CameraUIManager.this.m19408aI(false);
                            return;
                        }
                        CameraLog.m12966e("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, return");
                        return;
                    }
                    CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isZoomMenuExpand: true");
                    return;
                }
                CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isTimerSnapShotRunning: true");
                return;
            }
            CameraLog.m12954a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isBlurMenuOpen: true");
        }
    };

    /* renamed from: cw */
    private FaceBeautyMenu.PlatformImplementations.kt_3 f18493cw = new FaceBeautyMenu.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.9
        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20046a() {
            CameraUIManager.this.f18349J.resetFaceBeautyValues();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo20049b() {
            return CameraUIManager.this.f18349J.mo10722aa();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo20045a(int OplusGLSurfaceView_13) {
            return CameraUIManager.this.f18349J.getFaceBeautyItemValue(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo20050b(int OplusGLSurfaceView_13) {
            CameraUIManager.this.f18349J.onFaceBeautyItemChange(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20048a(View view) {
            if (CameraUIManager.this.f18341B.getBoolean(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE, true)) {
                CameraUIManager.this.mo18086a(view, 8, 0, 0);
            } else {
                CameraUIManager.this.mo18210f(8, false);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20047a(int OplusGLSurfaceView_13, int i2, boolean z) {
            if (CameraUIManager.this.f18349J == null) {
                return;
            }
            CameraUIManager.this.f18349J.onFaceBeautyItemValueChange(OplusGLSurfaceView_13, i2, z);
            mo20057g();
            if (!CameraUIManager.this.f18509u || 40 == i2) {
                return;
            }
            CameraUIManager.this.m19532fv();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo20052c() {
            return CameraUIManager.this.f18349J.mo10878t();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public int mo20053d() {
            return CameraUIManager.this.f18349J.mo10723ab();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_8 */
        public int[] mo20055e() {
            return CameraUIManager.this.f18349J.mo10724ac();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_12 */
        public int[] mo20056f() {
            return CameraUIManager.this.f18349J.mo10725ad();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public int mo20051c(int OplusGLSurfaceView_13) {
            return CameraUIManager.this.f18349J.mo10830e(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo20057g() {
            CameraUIManager.this.m19517fg();
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo20054d(int OplusGLSurfaceView_13) {
            if (CameraUIManager.this.f18341B != null) {
                CameraUIManager.this.f18341B.edit().putInt(CameraUIInterface.KEY_FACE_BEAUTY_LAST_TAB_INDEX, OplusGLSurfaceView_13).apply();
            }
        }

        @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_10 */
        public int mo20058h() {
            if (CameraUIManager.this.f18341B != null) {
                return CameraUIManager.this.f18341B.getInt(CameraUIInterface.KEY_FACE_BEAUTY_LAST_TAB_INDEX, 0);
            }
            return 0;
        }
    };

    /* renamed from: cx */
    private FilterEffectMenu.PlatformImplementations.kt_3 f18494cx = new FilterEffectMenu.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.10
        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo19993a() {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10870o();
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo19995a(GLProducerRender abstractC3285j) {
            if (CameraUIManager.this.f18340A != null) {
                CameraUIManager.this.f18340A.m23348a(abstractC3285j);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo19997a(boolean z) {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10689a(z);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo19994a(int OplusGLSurfaceView_13, boolean z) {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.onEffectItemChange(OplusGLSurfaceView_13, z, true);
                if (!CameraUIManager.this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) || CameraCharacteristicsUtil.m12974a(CameraUIManager.this.mo19845cv()) || !FilterHelper.m22612a(OplusGLSurfaceView_13) || CameraUIManager.this.f18341B.getBoolean(CameraUIInterface.PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED, false)) {
                    return;
                }
                CameraUIManager.this.f18341B.edit().putBoolean(CameraUIInterface.PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED, true).apply();
                CameraUIManager.this.f18385aT.m20680g();
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo19998a(int OplusGLSurfaceView_13) {
            if (CameraUIManager.this.f18349J != null) {
                return CameraUIManager.this.f18349J.mo10755b(OplusGLSurfaceView_13);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo20000b() {
            if (CameraUIManager.this.f18349J != null) {
                return CameraUIManager.this.f18349J.mo10878t();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo19996a(String str) {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10812c(str);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo19999b(String str) {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10827d(str);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo20001c() {
            if (CameraUIManager.this.f18349J != null) {
                return CameraUIManager.this.f18349J.mo10882x();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean mo20002d() {
            return !CameraUIManager.this.mo18025B();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_8 */
        public int mo20003e() {
            if (CameraUIManager.this.f18349J != null) {
                return CameraUIManager.this.f18349J.mo10880v();
            }
            return 0;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_12 */
        public int mo20004f() {
            if (CameraUIManager.this.f18365Z != null) {
                return CameraUIManager.this.f18365Z.indexOfChild(CameraUIManager.this.f18514z.m19071U()) + 1;
            }
            return -1;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.FilterEffectMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean mo20005g() {
            return CameraUIManager.this.mo18207e();
        }
    };

    /* renamed from: cy */
    private BlurMenu.PlatformImplementations.kt_3 f18495cy = new BlurMenu.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.11
        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo20009a() {
            return !CameraUIManager.this.mo18025B();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo20010b() {
            return CameraUIManager.this.f18349J.mo10709aN();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20008a(boolean z, boolean z2, boolean z3) {
            if (CameraUIManager.this.f18349J != null && z2) {
                if (!CameraUIManager.this.f18349J.mo10709aN()) {
                    CameraUIManager.this.f18349J.mo10703aH();
                }
                CameraUIManager.this.f18349J.mo10689a(z);
            }
            if (1 == CameraUIManager.this.mo18134aX()) {
                CameraUIManager.this.m19983w(true, z3);
                CameraUIManager.this.m19614A(false, z3);
            } else if (4 == CameraUIManager.this.mo18134aX() && !CameraUIManager.this.mo18159aw()) {
                CameraUIManager.this.mo18215g(0);
            }
            if (CameraUIManager.this.f18349J == null || CameraUIManager.this.f18503o) {
                return;
            }
            CameraUIManager.this.f18349J.mo10703aH();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo20011c() {
            if (CameraUIManager.this.f18349J == null || CameraUIManager.this.f18503o) {
                return;
            }
            CameraUIManager.this.f18349J.mo10703aH();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo20012d() {
            if (1 == CameraUIManager.this.mo18134aX()) {
                CameraUIManager.this.m19983w(false, true);
                CameraUIManager.this.m19614A(true, true);
                if (CameraUIManager.this.f18348I == null || !CameraUIManager.this.f18348I.m21413c()) {
                    return;
                }
                CameraUIManager.this.f18348I.m21403a(8);
                return;
            }
            if (4 == CameraUIManager.this.mo18134aX()) {
                CameraUIManager.this.mo18215g(8);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo20013e() {
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10702aG();
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20006a(int OplusGLSurfaceView_13, boolean z) {
            CameraUIManager.this.f18349J.setBlurIndex(OplusGLSurfaceView_13, z);
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20007a(boolean z, boolean z2) {
            CameraLog.m12954a("CameraUIManager", "mBlurMenuListener, onBlurStateChange, isBlurOpen: " + z);
            if (CameraUIManager.this.f18349J.mo10648B()) {
                return;
            }
            CameraUIManager.this.f18349J.mo10690a(z, z2);
            CameraUIManager.this.f18347H.m21559b(CameraUIInterface.KEY_VIDEO_BLUR_MENU, z);
            CameraUIManager.this.m19636S(z);
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_12 */
        public int mo20014f() {
            return CameraUIManager.this.f18349J.mo10707aL();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean mo20015g() {
            return (CameraUIManager.this.f18349J.mo10648B() || mo20016h()) ? false : true;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean mo20016h() {
            return CameraUIManager.this.f18349J.mo10710aO();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_13 */
        public boolean mo20017i() {
            return CameraUIManager.this.f18349J.mo10814c();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_15 */
        public boolean mo20018j() {
            return CameraUIManager.this.mo19966j(CameraFunction.SAT_CAMERA);
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_5 */
        public void mo20019k() {
            CameraUIManager.this.f18349J.mo10840g(0);
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_14 */
        public int mo20020l() {
            return CameraUIManager.this.f18349J.mo10772bO();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_6 */
        public int mo20021m() {
            return CameraUIManager.this.f18349J.mo10653G();
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_11 */
        public HintManager mo20022n() {
            return CameraUIManager.this.f18394ac;
        }
    };

    /* renamed from: cz */
    private ExpandableMenuPanel.IntrinsicsJvm.kt_4 f18496cz = new ExpandableMenuPanel.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.59
        @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20039a(String str) throws Resources.NotFoundException {
            CameraLog.m12954a("CameraUIManager", "onExpandMenuShow, key: " + str);
            CameraUIManager.this.m19978s(str);
            if (!CameraUIManager.this.m19898dp() || !CameraUIManager.this.m19518fh()) {
                if (CameraUIManager.this.f18514z != null && 1 != CameraUIManager.this.mo18134aX() && (!CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str) || !CameraUIManager.this.mo18224h())) {
                    CameraUIManager.this.f18514z.m19173h();
                }
            } else {
                CameraUIManager.this.m19794c(true, 0);
            }
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10874q();
            }
            if (4 != CameraUIManager.this.mo18134aX()) {
                CameraUIManager.this.mo18232j(true, true);
                CameraUIManager.this.mo18223h(true, true);
            }
            CameraUIManager.this.mo18210f(17, true);
            CameraUIManager.this.mo18210f(20, true);
            if (CameraUIManager.this.f18349J != null) {
                String strMo10700aE = CameraUIManager.this.f18349J.mo10700aE();
                if (TextUtils.equals(strMo10700aE, str)) {
                    CameraUIManager.this.mo18106a(true, str);
                }
                if (TextUtils.equals(strMo10700aE, str.concat("_from_other_app"))) {
                    CameraUIManager.this.mo18106a(true, strMo10700aE);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20040a(String str, boolean z, boolean z2) throws Resources.NotFoundException {
            if (CameraUIManager.this.f18349J != null) {
                String strMo10700aE = CameraUIManager.this.f18349J.mo10700aE();
                if (TextUtils.equals(strMo10700aE, str)) {
                    CameraUIManager.this.mo18106a(false, str);
                } else if (TextUtils.equals(strMo10700aE, str.concat("_from_other_app"))) {
                    CameraUIManager.this.mo18106a(false, strMo10700aE);
                } else {
                    CameraUIManager.this.m19956g(str, true);
                }
            }
            if (CameraUIManager.this.m19518fh()) {
                if (CameraUIManager.this.f18349J != null && !CameraUIManager.this.f18349J.mo10658L() && z && !z2) {
                    CameraUIManager.this.m19736b(true, 0);
                }
            } else if (CameraUIManager.this.f18514z != null && z && !z2 && 1 != CameraUIManager.this.mo18134aX()) {
                CameraUIManager.this.f18514z.m19147b(true, true);
            }
            if (z2) {
                return;
            }
            if (CameraUIManager.this.f18349J != null && ((!Util.m24498u() || !CameraUIManager.this.f18349J.mo10779bV()) && CameraUIManager.this.f18349J.mo10795bl())) {
                CameraUIManager.this.mo18240l(true, true);
            }
            if (CameraUIManager.this.f18349J != null) {
                if ((Util.m24498u() && CameraUIManager.this.f18349J.mo10779bV()) || !CameraUIManager.this.f18349J.mo10796bm() || CameraUIManager.this.f18503o) {
                    return;
                }
                CameraUIManager.this.mo18228i(true, true);
            }
        }
    };

    /* renamed from: cA */
    private MoreUIControl.IntrinsicsJvm.kt_4 f18470cA = new MoreUIControl.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.62
        @Override // com.oplus.camera.p172ui.modepanel.MoreUIControl.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20042a(int OplusGLSurfaceView_13) {
            if (CameraUIManager.this.m19442al(OplusGLSurfaceView_13)) {
                return;
            }
            boolean z = 3 == OplusGLSurfaceView_13 || 28 == OplusGLSurfaceView_13;
            boolean zM12974a = CameraCharacteristicsUtil.m12974a(CameraUIManager.this.mo19845cv());
            if (CameraUIManager.this.f18447bd != null) {
                if (CameraUIManager.this.f18514z.m19110a() || !CameraUIManager.this.f18349J.mo10671Y()) {
                    return;
                }
                if (CameraUIManager.this.f18349J.mo10720aY() && !CameraUIManager.this.m19767bf()) {
                    return;
                }
                if (!z) {
                    CameraUIManager.this.f18447bd.m22045b(false);
                }
            }
            if (CameraUIManager.this.f18349J != null) {
                CameraUIManager.this.f18349J.mo10825d(OplusGLSurfaceView_13);
                if (16 == OplusGLSurfaceView_13) {
                    CameraUIManager.this.f18341B.edit().putBoolean(CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true).apply();
                }
            }
            if (HeadlineHelper.m20351d(OplusGLSurfaceView_13).equals(CameraUIManager.this.mo18132aV())) {
                return;
            }
            CameraUIManager.this.m19764bX();
            CameraUIManager.this.mo18223h(false, false);
            CameraUIManager.this.mo18236k(false, false);
            CameraUIManager.this.m19410aK(false);
            CameraUIManager.this.m19409aJ(true);
            CameraUIManager.this.m19910e(z ? 0.0f : 1.0f);
            InverseManager.INS.setMaskAlpha(CameraUIManager.this.f18497i, true, true);
            InverseManager.INS.setExecuteDelayMsg(true);
            CameraUIManager.this.f18514z.m19209s(false);
            Util.m24253a(OplusGLSurfaceView_13, CameraUIManager.this.f18497i, zM12974a);
        }

        @Override // com.oplus.camera.p172ui.modepanel.MoreUIControl.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20041a() {
            CameraUIManager.this.m19785bx();
        }

        @Override // com.oplus.camera.p172ui.modepanel.MoreUIControl.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo20043b() {
            CameraUIManager.this.m19784bw();
        }

        @Override // com.oplus.camera.p172ui.modepanel.MoreUIControl.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo20044c() {
            CameraUIManager.this.m19437aj(-1);
        }
    };

    /* renamed from: ab */
    private boolean m19422ab(int OplusGLSurfaceView_13) {
        return 10 == OplusGLSurfaceView_13 || 16 == OplusGLSurfaceView_13 || 17 == OplusGLSurfaceView_13;
    }

    /* renamed from: ac */
    private boolean m19423ac(int OplusGLSurfaceView_13) {
        return 10 == OplusGLSurfaceView_13 || 16 == OplusGLSurfaceView_13 || 17 == OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0;
    }

    /* renamed from: ad */
    private boolean m19426ad(int OplusGLSurfaceView_13) {
        return (12 == OplusGLSurfaceView_13 || 19 == OplusGLSurfaceView_13) ? false : true;
    }

    /* renamed from: ae */
    private boolean m19428ae(int OplusGLSurfaceView_13) {
        return (12 == OplusGLSurfaceView_13 || 19 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13) ? false : true;
    }

    /* renamed from: af */
    private boolean m19430af(int OplusGLSurfaceView_13) {
        return (12 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13) ? false : true;
    }

    /* renamed from: N */
    public boolean m19630N(int OplusGLSurfaceView_13) {
        return 2 == OplusGLSurfaceView_13 || 11 == OplusGLSurfaceView_13 || 15 == OplusGLSurfaceView_13 || 25 == OplusGLSurfaceView_13 || 8 == OplusGLSurfaceView_13 || 1 == OplusGLSurfaceView_13;
    }

    /* renamed from: T */
    public boolean m19638T(int OplusGLSurfaceView_13) {
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: W */
    public boolean mo18062W() {
        return false;
    }

    /* renamed from: ag */
    public void m19708ag(boolean z) {
    }

    /* renamed from: ah */
    public void m19709ah(boolean z) {
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: av */
    public boolean mo18158av() {
        return false;
    }

    /* renamed from: ay */
    public void m19726ay(boolean z) {
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18164b(int OplusGLSurfaceView_13) {
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18169b(String str) {
    }

    /* renamed from: cO */
    public void m19812cO() {
    }

    /* renamed from: dA */
    public void m19857dA() {
    }

    /* renamed from: el */
    public boolean m19938el() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_6 */
    public int mo18241m() {
        return 0;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: w */
    public void mo18282w(boolean z) {
    }

    /* compiled from: CameraUIManager.java */
    /* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_5$12, reason: invalid class name */
    class CameraUIManager_2 implements TimeLapseProMenuLayout.COUIBaseListPopupWindow_8 {
        CameraUIManager_2() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17765a(int OplusGLSurfaceView_13) {
            boolean z = OplusGLSurfaceView_13 != 0;
            if (CameraUIManager.this.f18471ca <= 0 || OplusGLSurfaceView_13 <= 0) {
                if (CameraUIManager.this.f18471ca == 0 && OplusGLSurfaceView_13 == 0) {
                    return;
                }
                int iJ = CameraUIManager.this.f18467bx.mo16539j();
                int i2 = R.color.time_lapse_pro_seek_value_desc_color;
                if (4 == iJ) {
                    int color = CameraUIManager.this.f18497i.getColor(R.color.camera_white);
                    int color2 = CameraUIManager.this.f18497i.getColor(R.color.time_lapse_pro_seek_value_desc_color);
                    int[] iArr = new int[2];
                    iArr[0] = z ? color : color2;
                    if (z) {
                        color = color2;
                    }
                    iArr[1] = color;
                    ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(iArr);
                    valueAnimatorOfArgb.setInterpolator(CameraUIManager.this.f18444ba);
                    valueAnimatorOfArgb.setDuration(500L);
                    valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$12$wj8VuU-w4seV6e0pqKe7KMis6wA
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.COUIBaseListPopupWindow_12$0.m20023a(valueAnimator);
                        }
                    });
                    valueAnimatorOfArgb.start();
                } else {
                    RotateAnimationView rotateAnimationView = CameraUIManager.this.f18430bM;
                    Activity activity = CameraUIManager.this.f18497i;
                    if (!z) {
                        i2 = R.color.camera_white;
                    }
                    rotateAnimationView.setImageTintList(ColorStateList.valueOf(ContextCompat.m2254c(activity, i2)));
                }
                CameraUIManager.this.f18471ca = OplusGLSurfaceView_13;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m20023a(ValueAnimator valueAnimator) {
            CameraUIManager.this.f18430bM.setColorFilter(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17767a(String str) {
            CameraUIManager.this.f18349J.mo10840g(0);
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17766a(long OplusGLSurfaceView_15) {
            CameraUIManager.this.f18349J.mo10840g(0);
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17768a(String str, String str2) {
            CameraUIManager.this.f18349J.mo10840g(0);
            CameraUIManager.this.f18341B.edit().putString(str, str2).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gH */
    public /* synthetic */ void m19548gH() {
        CameraLog.m12954a("CameraUIManager", "mUpdateButtonBgRunnable, mSizeRatioType: " + this.f18352M);
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19192m(this.f18352M);
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10833e(this.f18364Y);
            this.f18349J.mo10845h(this.f18352M);
        }
        BaseScreenMode abstractC2934a = this.f18467bx;
        if (abstractC2934a != null) {
            if (this.f18364Y) {
                SplitBackgroundView splitBackgroundView = this.f18377aL;
                if (splitBackgroundView != null) {
                    splitBackgroundView.setLightBackground(true);
                }
                RotateAnimationView rotateAnimationView = this.f18382aQ;
                if (rotateAnimationView != null) {
                    rotateAnimationView.setLightBackground(true);
                }
                SplitBackgroundView splitBackgroundView2 = this.f18378aM;
                if (splitBackgroundView2 != null) {
                    splitBackgroundView2.setLightBackground(true);
                    return;
                }
                return;
            }
            abstractC2934a.mo16507b(this.f18497i, this.f18352M);
        }
    }

    /* renamed from: bf */
    public boolean m19767bf() {
        AiHintUI c3439b = this.f18454bk;
        return c3439b != null && c3439b.m23173b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19674a(SoloopManager c2963b) {
        this.f18342C = c2963b;
        if (this.f18341B.getBoolean("pref_allow_network_access", false)) {
            c2963b.m16726a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public void m19365U(int OplusGLSurfaceView_13) {
        int i2;
        int i3;
        ScreenModeManager c2953g;
        if (this.f18497i == null || !this.f18349J.mo10691a(OplusGLSurfaceView_13, this.f18357R)) {
            return;
        }
        if (this.f18454bk == null) {
            this.f18454bk = new AiHintUI(this.f18497i, OplusGLSurfaceView_13, this.f18349J);
        }
        this.f18454bk.m23169a(OplusGLSurfaceView_13);
        int i4 = -1;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 == 1) {
                i4 = 6;
                i2 = R.string.camera_ai_scene_ultra_wide_tip;
                i3 = R.drawable.hint_icon_ultra_wide;
            } else if (OplusGLSurfaceView_13 != 2) {
                i2 = -1;
                i3 = -1;
            } else {
                i4 = 12;
                i2 = R.string.camera_ai_scene_portrait_mode_hint;
                i3 = R.drawable.ai_scene_hint_portrait_mode;
            }
        } else {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT)) {
                return;
            }
            i4 = 10;
            i2 = R.string.camera_ai_scene_super_text_hint;
            i3 = R.drawable.ai_scene_hint_super_text;
        }
        if (!this.f18454bk.m23173b() && !mo18023A() && !mo18043K()) {
            CameraLog.m12959b("CameraUIManager", "showAiHint, aiHintType: " + OplusGLSurfaceView_13);
            if (Util.m24495t() && (c2953g = this.f18500l) != null) {
                this.f18454bk.m23170a(c2953g.mo16411a().mo16508c(this.f18497i), i2, i3, m19476eX());
            } else {
                this.f18454bk.m23170a(this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_layout_margin_top), i2, i3, m19476eX());
            }
            this.f18349J.mo10750b(ReminderMsgData.TYPE_ADVICE, ReminderMsgData.CODE_TRY_WIDE_ANGLE);
        } else {
            CameraTipsManager.m14374a().m14378c();
        }
        this.f18483cm.removeMessages(i4);
        Message messageObtainMessage = this.f18483cm.obtainMessage();
        messageObtainMessage.what = i4;
        this.f18483cm.sendMessageDelayed(messageObtainMessage, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: v */
    public void mo18278v(int OplusGLSurfaceView_13) {
        MoreUIControl.IntrinsicsJvm.kt_4 bVar = this.f18470cA;
        if (bVar != null) {
            bVar.mo20042a(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo18239l(boolean z) {
        if (this.f18454bk != null) {
            CameraLog.m12959b("CameraUIManager", "hideAiHint, remove: " + z);
            this.f18454bk.m23171a(z);
            if (this.f18454bk.m23174c()) {
                CameraTipsManager.m14374a().m14378c();
            }
        }
        if (this.f18483cm.hasMessages(10)) {
            this.f18483cm.removeMessages(10);
        }
        if (this.f18483cm.hasMessages(6)) {
            this.f18483cm.removeMessages(6);
        }
        if (this.f18483cm.hasMessages(12)) {
            this.f18483cm.removeMessages(12);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo18244m(boolean z, boolean z2) {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20879b(z, z2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: G */
    public void mo18034G() {
        this.f18514z.m19159d(true, false);
        mo18263r(false);
        if (mo18023A()) {
            this.f18399ah.m20879b(true, false);
        }
        Size sizeM19747bG = m19747bG();
        m19959h(sizeM19747bG != null ? Util.m24426d(sizeM19747bG.getWidth(), sizeM19747bG.getHeight()) : 0, true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: F */
    public void mo18032F() {
        this.f18514z.m19159d(false, true);
        if (mo18023A()) {
            this.f18399ah.m20879b(true, false);
        }
        mo18259q(false);
        mo18190c(false);
        mo18279v(false);
        Size sizeM19747bG = m19747bG();
        if (sizeM19747bG != null) {
            m19367V(Util.m24426d(sizeM19747bG.getWidth(), sizeM19747bG.getHeight()));
        }
    }

    /* renamed from: V */
    private void m19367V(int OplusGLSurfaceView_13) {
        if (Util.m24418c(OplusGLSurfaceView_13)) {
            m19707af(true);
            CameraControlUI viewOnClickListenerC3199a = this.f18514z;
            if (viewOnClickListenerC3199a != null) {
                viewOnClickListenerC3199a.m19199o(true);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: I */
    public ImageCallback mo18038I() {
        return this.f18478ch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m19390a(View view) {
        if (view.getId() == R.id_renamed.out_screen_preview_switch_button || view.getId() == R.id_renamed.out_capture_button) {
            if (this.f18349J.mo10848h(CameraFunction.OUT_CAPTURE_ENABLE)) {
                this.f18349J.mo10680a(71, Util.m24498u() ? "2" : "3");
                this.f18499k.m16430a();
                this.f18499k.m16431a(this.f18497i, this.f18489cs);
                return;
            } else {
                if (this.f18349J.mo10848h(CameraFunction.OUT_PREVIEW_ENABLE)) {
                    if (!this.f18498j.m16453b()) {
                        this.f18349J.mo10680a(71, "0");
                    }
                    this.f18498j.m16450a(this.f18497i, this.f18490ct);
                    this.f18341B.edit().putBoolean(CameraUIInterface.KEY_OUT_PREVIEW_GUIDE, false).apply();
                    this.f18349J.mo10782bY();
                    return;
                }
                return;
            }
        }
        if (view.getId() == R.id_renamed.out_screen_capture_exit_button) {
            this.f18499k.m16432a(true, true);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: R */
    public void mo18056R(boolean z) {
        this.f18498j.m16452b(z);
    }

    /* renamed from: x */
    public void m19985x(int OplusGLSurfaceView_13) {
        this.f18498j.m16448a(OplusGLSurfaceView_13);
    }

    public CameraUIManager(Activity activity, ComboPreferences comboPreferences, CameraUIListener cameraUIListener, ScreenModeManager c2953g) {
        this.f18497i = null;
        this.f18498j = null;
        this.f18499k = null;
        this.f18500l = null;
        this.f18513y = null;
        this.f18514z = null;
        this.f18340A = null;
        this.f18341B = null;
        this.f18347H = null;
        this.f18348I = null;
        this.f18349J = null;
        this.f18394ac = null;
        this.f18396ae = null;
        this.f18397af = null;
        this.f18398ag = null;
        this.f18467bx = null;
        this.f18497i = activity;
        this.f18498j = new OutPreviewManager();
        this.f18499k = new OutCaptureManager();
        this.f18499k.m16434b(activity, this.f18489cs);
        this.f18500l = c2953g;
        this.f18467bx = this.f18500l.mo16411a();
        this.f18500l.m16655a(this);
        this.f18341B = comboPreferences;
        this.f18349J = cameraUIListener;
        this.f18514z = new CameraControlUI(this.f18497i, this.f18341B, this.f18349J, this.f18500l);
        this.f18340A = new CameraPreviewUI(this.f18497i, this.f18341B, this);
        InverseManager.INS.setCameraPreviewUI(this.f18497i, this.f18340A);
        this.f18347H = new CameraSettingUI(this.f18497i, this.f18341B, cameraUIListener, false);
        this.f18348I = new CameraDrawerSettingUI(this.f18497i, this.f18341B, cameraUIListener, true);
        this.f18348I.m21542a(this);
        this.f18513y = new CameraSuperTextUI(this.f18497i, cameraUIListener, this.f18514z);
        this.f18394ac = new HintManager(Util.m24472l().getResources(), this);
        LayoutInflater layoutInflater = this.f18497i.getLayoutInflater();
        this.f18396ae = (CameraScreenHintView) layoutInflater.inflate(R.layout.camera_screen_hint, (ViewGroup) null);
        this.f18397af = (CameraScreenHintView) layoutInflater.inflate(R.layout.camera_screen_hint, (ViewGroup) null);
        this.f18398ag = (CameraScreenHintView) layoutInflater.inflate(R.layout.camera_screen_hint, (ViewGroup) null);
        this.f18396ae.setCameraScreenHintInterface(this.f18481ck);
        this.f18398ag.setCameraScreenHintInterface(this.f18481ck);
        this.f18397af.setCameraScreenHintInterface(this.f18481ck);
        this.f18394ac.m18485a(this.f18396ae, this.f18397af, this.f18398ag);
        this.f18501m = activity.getResources().getDimensionPixelSize(R.dimen.xpan_mode_thumbimageview_trans_x);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_5 */
    public HintManager mo18233k() {
        return this.f18394ac;
    }

    /* renamed from: S */
    public void m19636S(boolean z) {
        if (this.f18382aQ != null) {
            CameraUIListener cameraUIListener = this.f18349J;
            int OplusGLSurfaceView_13 = (cameraUIListener == null || !cameraUIListener.mo10848h(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU)) ? R.drawable.blur_menu_control_button : R.drawable.multi_video_type_menu_normal;
            if (OplusGLSurfaceView_13 != this.f18381aP) {
                this.f18381aP = OplusGLSurfaceView_13;
                this.f18382aQ.setImageResource(OplusGLSurfaceView_13);
            }
            if (R.drawable.blur_menu_control_button == OplusGLSurfaceView_13) {
                this.f18382aQ.setSelected(z);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: bg_renamed */
    public String mo19768bg() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null ? cameraUIListener.mo10789bf() : "";
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: bh */
    public String mo19769bh() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null ? cameraUIListener.mo10790bg() : "";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19677a(ModeTypeChangedListener interfaceC3201c) {
        this.f18514z.m19095a(interfaceC3201c);
    }

    /* renamed from: bi */
    public boolean m19770bi() {
        return this.f18514z.m19110a();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo18201d() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19160d();
        }
        return false;
    }

    /* renamed from: bj */
    public boolean m19771bj() {
        SuperColorToolTips c3520c = this.f18416ay;
        if (c3520c != null) {
            return c3520c.isShowing();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo18207e() {
        return mo18214f();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo18214f() {
        OutCaptureManager c2929b = this.f18499k;
        if (c2929b != null) {
            return c2929b.m16437e();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean mo18219g() {
        OutPreviewManager c2930c = this.f18498j;
        if (c2930c != null) {
            return c2930c.m16453b();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo18225i() {
        if (Util.m24495t()) {
            CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
            if (viewOnLayoutChangeListenerC3444g != null) {
                viewOnLayoutChangeListenerC3444g.m23411k(mo18207e());
            }
            CameraUIListener cameraUIListener = this.f18349J;
            if (cameraUIListener != null) {
                cameraUIListener.mo10823ch();
            }
        }
    }

    /* renamed from: y */
    public void m19988y(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19078a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: z */
    public void m19991z(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19140b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19682a(PreviewEffectProcess interfaceC3423t) {
        CameraLog.m12954a("CameraUIManager", "onCreateCameraPriorityUI");
        CameraLog.m12952a("UIManager.onCreateCameraPriorityUI");
        this.f18365Z = (ViewGroup) this.f18497i.findViewById(R.id_renamed.camera);
        this.f18392aa = this.f18497i.findViewById(R.id_renamed.camera_root);
        this.f18392aa.setBackgroundColor(BackgroundUtil.m24523a(this.f18497i.getColor(R.color.background_color)));
        this.f18394ac.m18482a(this.f18365Z);
        this.f18365Z.setMotionEventSplittingEnabled(false);
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23349a(interfaceC3423t);
        }
        m19521fk();
        CameraLog.m12958b("UIManager.onCreateCameraPriorityUI");
    }

    /* renamed from: bk */
    public void m19772bk() throws Resources.NotFoundException {
        CameraLog.m12954a("CameraUIManager", "onCreate");
        CameraLog.m12952a("UIManager.onCreate");
        this.f18502n = false;
        this.f18503o = false;
        this.f18500l.m16662c();
        CameraSuperTextUI c3133a = this.f18513y;
        if (c3133a != null) {
            c3133a.m18565a(this.f18365Z);
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19151c(this.f18350K);
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21525C();
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21525C();
        }
        this.f18399ah = new FilterEffectMenu(this.f18497i);
        this.f18399ah.setCameraEntryType(this.f18350K);
        this.f18399ah.m20867a(this.f18351L);
        this.f18399ah.setFilterEffectMenuListener(this.f18494cx);
        this.f18400ai = new BlurMenu(this.f18497i, this.f18495cy);
        this.f18400ai.setScreenMode(mo18134aX(), this.f18467bx.mo16570k());
        this.f18382aQ = (RotateAnimationView) this.f18497i.findViewById(R.id_renamed.camera_menu_left_enter_button);
        this.f18382aQ.setOnClickListener(this.f18485co);
        InverseManager.INS.registerInverse(this.f18497i, this.f18382aQ);
        BackgroundSplitManager.m18430a(this.f18497i).m18445a(this.f18382aQ, "MenuLeftEnterButton");
        this.f18465bv = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.face_beauty_enter_button_animation_y);
        this.f18377aL = (SplitBackgroundView) this.f18497i.findViewById(R.id_renamed.face_beauty_enter_button);
        this.f18377aL.setInterceptTouchEvent(true);
        this.f18377aL.setOnClickListener(this.f18492cv);
        InverseManager.INS.registerInverse(this.f18497i, this.f18377aL);
        BackgroundSplitManager.m18430a(this.f18497i).m18445a(this.f18377aL, "FaceBeautyEnterButton");
        this.f18378aM = (SplitBackgroundView) this.f18497i.findViewById(R.id_renamed.effect_menu_back_button);
        this.f18378aM.setOnClickListener(this.f18379aN);
        InverseManager.INS.registerInverse(this.f18497i, this.f18378aM);
        this.f18385aT = new FaceBeautyMenu(this.f18497i, this.f18493cw, this.f18350K, this.f18349J);
        this.f18385aT.m20667a(this.f18477cg);
        this.f18384aS = new TiltShiftBlurMenu(this.f18497i, this.f18495cy);
        this.f18384aS.setBlurType(1);
        if (this.f18463bt == null) {
            this.f18463bt = new ItemDragHelper(this.f18497i, this.f18500l);
        }
        if (this.f18350K == 1) {
            m19522fl();
            m19493fI();
        }
        if (f18339h) {
            f18339h = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FIRST_LAUNCH_ANIMATION);
            CameraLog.m12954a("CameraUIManager", "onCreate, show first launch animation : " + f18339h);
        }
        this.f18514z.m19102a(this.f18463bt);
        this.f18514z.m19103a(this.f18484cn);
        if (Util.m24495t()) {
            this.f18468by = (SplitBackgroundView) this.f18497i.findViewById(R.id_renamed.screen_mode_switch_button);
            this.f18469bz = (OutScreenButtonBoxView) this.f18497i.findViewById(R.id_renamed.out_screen_preview_switch_button);
            this.f18418bA = (RotateAnimationView) this.f18497i.findViewById(R.id_renamed.out_screen_capture_exit_button);
            this.f18468by.setOnClickListener(this.f18488cr);
            this.f18469bz.setOnClickListener(this.f18491cu);
            this.f18418bA.setOnClickListener(this.f18491cu);
            InverseManager.INS.registerInverse(this.f18497i, this.f18468by);
            InverseManager.INS.registerInverse(this.f18497i, this.f18469bz);
            this.f18473cc.add(this.f18377aL);
            this.f18473cc.add(this.f18378aM);
            this.f18473cc.add(this.f18468by);
            this.f18473cc.add(this.f18469bz.getBgView());
            if (Util.m24498u() && mo19881dY() && this.f18467bx != null) {
                this.f18467bx.m16503a(this.f18497i.findViewById(R.id_renamed.headline_view), this.f18497i.findViewById(R.id_renamed.thumbnail));
                this.f18514z.m19090a(this.f18467bx, true);
            }
        }
        CameraLog.m12958b("UIManager.onCreate");
    }

    /* renamed from: bl */
    public void m19773bl() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23391d();
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19161e();
        }
    }

    /* renamed from: eO */
    private void m19467eO() {
        boolean z = m19549ga() && this.f18349J.mo10786bc().m13359w();
        CameraLog.m12959b("CameraUIManager", "initGalleryPreview, isLocked: " + z + ", isDeviceLocked: " + m19549ga() + ", lockScreenLocked: " + this.f18349J.mo10786bc().m13359w());
        CameraThreadExector.m24695a().m24696a(new CameraUIManager_3(z), "Init GalleryData");
    }

    /* compiled from: CameraUIManager.java */
    /* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_5$13, reason: invalid class name */
    class CameraUIManager_3 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ boolean f18519a;

        CameraUIManager_3(boolean z) {
            this.f18519a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f18519a) {
                if (CameraUIManager.this.f18514z != null && CameraUIManager.this.f18514z.m19187k() && !CameraUIManager.this.f18514z.m19190l()) {
                    CameraUIManager.this.f18429bL = null;
                } else {
                    CameraUIManager c3208d = CameraUIManager.this;
                    c3208d.f18429bL = MediaDataManager.kt.m9517a(c3208d.f18497i, 50);
                }
            } else {
                CameraUIManager c3208d2 = CameraUIManager.this;
                c3208d2.f18429bL = MediaDataManager.kt.m9519b(c3208d2.f18497i, 50);
            }
            if (CameraUIManager.this.f18497i != null) {
                CameraUIManager.this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraUIManager.this.f18497i == null) {
                            return;
                        }
                        if (CameraUIManager.this.f18425bH != null) {
                            CameraUIManager.this.f18425bH.m20251b(CameraUIManager_3.this.f18519a);
                            if (CameraUIManager.this.m19745bE() != null) {
                                CameraUIManager.this.f18425bH.m20237a(CameraUIManager.this.m19745bE().m19294h());
                            }
                            CameraUIManager.this.f18425bH.m20245a(CameraUIManager.this.f18429bL);
                            if (CameraUIManager.this.f18500l != null) {
                                CameraUIManager.this.f18500l.mo16411a().m16503a(CameraUIManager.this.f18497i.findViewById(R.id_renamed.gallery_container));
                            }
                            CameraUIManager.this.f18427bJ.m5042a(CameraUIManager.this.f18425bH.getItemCount() - 1, false);
                            return;
                        }
                        CameraUIManager.this.f18423bF = (ViewGroup) CameraUIManager.this.f18497i.findViewById(R.id_renamed.gallery_container);
                        if (CameraUIManager.this.f18423bF == null) {
                            CameraUIManager.this.f18500l.mo16411a().m16511d(CameraUIManager.this.f18497i);
                            CameraUIManager.this.f18423bF = (ViewGroup) CameraUIManager.this.f18497i.findViewById(R.id_renamed.gallery_container);
                        }
                        CameraUIManager.this.f18425bH = new GalleryPreviewAdapter(CameraUIManager.this.f18497i, 0, CameraUIManager.this.f18349J);
                        CameraUIManager.this.f18425bH.m20243a(new GalleryPreviewAdapter.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.13.1.1
                            @Override // com.oplus.camera.p172ui.GalleryPreviewAdapter.IntrinsicsJvm.kt_3
                            /* renamed from: PlatformImplementations.kt_3 */
                            public void mo20024a(View view, Bitmap bitmap, int OplusGLSurfaceView_13) {
                                CameraLog.m12959b("CameraUIManager", "initGalleryPreview, onclick, bitmap: " + bitmap + ", pos: " + OplusGLSurfaceView_13);
                                CameraUIManager.this.f18514z.m19089a(CameraUIManager.this.f18425bH.m20235a(OplusGLSurfaceView_13), bitmap);
                            }
                        });
                        CameraUIManager.this.f18425bH.m20251b(CameraUIManager_3.this.f18519a);
                        if (CameraUIManager.this.m19745bE() != null) {
                            CameraUIManager.this.f18425bH.m20237a(CameraUIManager.this.m19745bE().m19294h());
                        }
                        CameraUIManager.this.f18425bH.m20245a(CameraUIManager.this.f18429bL);
                        CameraUIManager.this.f18426bI = new GalleryPreviewItemDecoration(CameraUIManager.this.f18497i, CameraUIManager.this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.gallery_preview_padding), CameraUIManager.this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.gallery_preview_padding), 0, 0);
                        CameraUIManager.this.f18427bJ = (ViewPager2) CameraUIManager.this.f18423bF.findViewById(R.id_renamed.gallery_pager);
                        CameraUIManager.this.f18427bJ.setAdapter(CameraUIManager.this.f18425bH);
                        CameraUIManager.this.f18427bJ.setClipToOutline(true);
                        CameraUIManager.this.f18427bJ.m5043a(CameraUIManager.this.f18426bI);
                        CameraUIManager.this.f18427bJ.m5042a(CameraUIManager.this.f18425bH.getItemCount() - 1, false);
                        CameraUIManager.this.f18427bJ.m5044a(new ViewPager2.AbstractC0845e() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.13.1.2
                            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
                            public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
                                super.onPageScrollStateChanged(OplusGLSurfaceView_13);
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
                            public void onPageSelected(int OplusGLSurfaceView_13) {
                                CameraUIManager.this.f18424bG.m20181a(OplusGLSurfaceView_13);
                                super.onPageSelected(OplusGLSurfaceView_13);
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
                            public void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
                                super.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
                            }
                        });
                        if (CameraUIManager.this.f18428bK == null) {
                            CameraUIManager.this.f18428bK = (InverseTextView) CameraUIManager.this.f18497i.findViewById(R.id_renamed.gallery_preview_empty_view);
                        }
                        CameraUIManager.this.f18428bK.setVisibility(8);
                        if (CameraUIManager.this.f18500l != null) {
                            CameraUIManager.this.f18500l.mo16411a().m16503a(CameraUIManager.this.f18497i.findViewById(R.id_renamed.gallery_container));
                        }
                        if (CameraUIManager.this.f18424bG == null) {
                            CameraUIManager.this.f18424bG = (GalleryBottomMenuLayout) CameraUIManager.this.f18497i.findViewById(R.id_renamed.gallery_menu_panel);
                            CameraUIManager.this.f18424bG.m20183a(CameraUIManager.this.f18349J, CameraUIManager.this.f18341B, CameraUIManager.this.f18497i, CameraUIManager.this.f18425bH);
                        }
                        if (CameraUIManager.this.f18474cd != null) {
                            CameraUIManager.this.f18425bH.registerAdapterDataObserver(CameraUIManager.this.f18474cd);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: bm */
    public void m19774bm() {
        SwitchFilterMenu c3293r = this.f18402ak;
        if (c3293r != null) {
            c3293r.m21029c();
        }
    }

    /* renamed from: bn */
    public void m19775bn() {
        SwitchFilterMenu c3293r = this.f18402ak;
        if (c3293r != null) {
            c3293r.m21028b();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: x */
    public void mo18284x(boolean z) {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21403a(z ? 0 : 8);
            this.f18394ac.m18496c(true);
        }
        if (z && mo18043K()) {
            mo18109a(true, true, true, true);
        }
        if (z && mo18051O()) {
            this.f18400ai.hideMenu(true, true, false, true);
        }
        if (4 == mo18134aX() && !m19518fh() && !mo18043K() && !this.f18385aT.m20688m() && !this.f18399ah.isEffectMenuOpen() && !this.f18399ah.isAnimationRunning() && !mo18051O() && !mo18053P() && !mo18159aw()) {
            mo18286y(!z);
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21543a(CameraUIInterface.KEY_SUB_SETTING, z ? 0 : 8);
            this.f18347H.m21535M();
        }
        if (z) {
            return;
        }
        this.f18357R = -1;
        m19431ag(this.f18354O);
    }

    /* renamed from: bo */
    public boolean m19776bo() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            return c3326f.m21413c();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m19911e(String str, boolean z) {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21548a(str, z);
        }
    }

    /* renamed from: bp */
    public void m19777bp() {
        GradienterView c3454q = this.f18374aI;
        if (c3454q != null) {
            c3454q.m23807b();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: T */
    public boolean mo18059T() {
        CameraDrawerSettingUI c3326f;
        return (this.f18504p || (c3326f = this.f18348I) == null || !c3326f.mo21419j()) ? false : true;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: U */
    public void mo18060U() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21415d(false);
        }
        ComboPreferences comboPreferences = this.f18341B;
        if (comboPreferences != null) {
            if ("off".equals(comboPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off"))) {
                CameraDrawerSettingUI c3326f2 = this.f18348I;
                if (c3326f2 != null) {
                    c3326f2.m21410b();
                    return;
                }
                return;
            }
            this.f18341B.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
            mo18211f(CameraUIInterface.KEY_SUB_SETTING);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: y */
    public void mo18286y(boolean z) throws Resources.NotFoundException {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            if (z) {
                viewOnClickListenerC3199a.m19147b(true, true);
            } else {
                viewOnClickListenerC3199a.m19173h();
            }
        }
    }

    /* renamed from: T */
    public void m19637T(boolean z) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19215v(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo18248n(boolean z, boolean z2) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21568c(z, z2);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21568c(z, z2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18106a(boolean z, String str) {
        int OplusGLSurfaceView_13;
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || this.f18341B == null || this.f18497i == null) {
            return;
        }
        if (FilterHelper.f21279a == this.f18341B.getInt(cameraUIListener.mo10699aD(), FilterHelper.f21279a)) {
            if (z) {
                OplusGLSurfaceView_13 = R.drawable.menu_effect_off_light_selector;
            } else {
                OplusGLSurfaceView_13 = (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER) || FilterHelper.f21312b.equalsIgnoreCase(MediaInfo.RENDERER_TYPE_NONE) || this.f18341B.getBoolean(CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, false) || !ApsConstant.CAPTURE_MODE_COMMON.equals(this.f18349J.mo10736ao()) || CameraCharacteristicsUtil.m12974a(mo19845cv())) ? R.drawable.menu_effect_off_selector : R.drawable.menu_effect_grandtour_recommend;
            }
            mo18170b(str, OplusGLSurfaceView_13);
            return;
        }
        mo18170b(str, R.drawable.menu_effect_on_selector);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18197d(String str, int OplusGLSurfaceView_13) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21566c(str, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19692a(final boolean z, final int OplusGLSurfaceView_13) {
        Activity activity = this.f18497i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.14
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraUIManager.this.f18374aI == null) {
                        int screenWidth = Util.getScreenWidth() / 2;
                        int top = (CameraUIManager.this.f18352M == 0 || CameraUIManager.this.f18352M == 2) ? CameraUIManager.this.f18340A.m23431y().getTop() + (CameraUIManager.this.f18340A.m23431y().getHeight() / 2) : CameraUIManager.this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.gradienter_full_margin_top);
                        CameraLog.m12959b("CameraUIManager", "showGradienterView, top: " + CameraUIManager.this.f18340A.m23431y().getTop() + ", height: " + CameraUIManager.this.f18340A.m23431y().getHeight() + ", centerY: " + top + ", mSizeRatioType: " + CameraUIManager.this.f18352M);
                        CameraUIManager c3208d = CameraUIManager.this;
                        c3208d.f18374aI = new GradienterView(c3208d.f18497i, screenWidth, top, OplusGLSurfaceView_13);
                        CameraUIManager.this.f18374aI.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                        CameraUIManager.this.f18365Z.addView(CameraUIManager.this.f18374aI);
                        CameraUIManager.this.f18374aI.setVisibility(4);
                    }
                    if (CameraUIManager.this.f18374aI == null || !z) {
                        return;
                    }
                    CameraUIManager.this.f18374aI.m23805a();
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19661a(int OplusGLSurfaceView_13, boolean z, String str) {
        CameraLog.m12959b("CameraUIManager", "updateGradienterView, orientation: " + OplusGLSurfaceView_13);
        if (this.f18374aI != null) {
            if (z && str.equals(ApsConstant.CAPTURE_MODE_PROFESSIONAL)) {
                this.f18374aI.setOrientation(OplusGLSurfaceView_13);
                this.f18374aI.m23807b();
            } else {
                this.f18374aI.m23806a(OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: bq */
    public void m19778bq() {
        GradienterView c3454q = this.f18374aI;
        if (c3454q == null || this.f18365Z == null) {
            return;
        }
        c3454q.m23808c();
        this.f18365Z.removeView(this.f18374aI);
        this.f18374aI = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19660a(int OplusGLSurfaceView_13, String str, boolean z) {
        CameraUIListener cameraUIListener;
        ScreenModeManager c2953g = this.f18500l;
        if (c2953g != null) {
            c2953g.m16664d();
            this.f18467bx = this.f18500l.mo16411a();
            this.f18467bx.mo16498a(this.f18497i, (ScreenRelativeLayout) this.f18365Z);
            this.f18399ah.m20868a(mo18134aX(), this.f18467bx.mo16570k());
            this.f18348I.m21404a(mo18134aX(), this.f18467bx.mo16570k(), this.f18467bx.mo16630q());
            this.f18347H.m21580g(mo18134aX());
            this.f18385aT.m20666a(mo18134aX(), this.f18467bx.mo16570k());
            this.f18394ac.m18483a(this.f18467bx);
            AISceneUI abstractC3391a = this.f18373aH;
            if (abstractC3391a != null) {
                abstractC3391a.mo22231h(mo18134aX());
            }
            if (Util.m24495t()) {
                this.f18421bD = true;
                m19558gj();
            }
            this.f18420bC = false;
        }
        mo18116aF();
        CameraSuperTextUI c3133a = this.f18513y;
        if (c3133a != null) {
            c3133a.m18562a();
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23395e();
            if (!this.f18349J.mo10808by()) {
                this.f18340A.m23375ao();
            }
        }
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23047a(false, mo19881dY());
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19083a(OplusGLSurfaceView_13, str, z);
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22045b(false);
            CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
            if (viewOnClickListenerC3199a2 != null) {
                viewOnClickListenerC3199a2.m19135av();
            }
            if (this.f18500l != null) {
                this.f18447bd.m22057h(mo18134aX());
            }
            m19853d(true, 1);
            CameraUIListener cameraUIListener2 = this.f18349J;
            if (cameraUIListener2 != null) {
                cameraUIListener2.mo10835f(1);
            }
        }
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20880c();
            m19686a(CameraUIInterface.KEY_FILTER_MENU, this.f18399ah);
            m19686a(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, this.f18399ah);
            m19686a(CameraUIInterface.KEY_VIDEO_FILTER_MENU, this.f18399ah);
            m19686a(CameraUIInterface.KEY_NIGHT_FILTER_MENU, this.f18399ah);
            m19686a(CameraUIInterface.KEY_STREET_FILTER_MENU, this.f18399ah);
        }
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            m19686a(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU, c3278c);
            m19686a(CameraUIInterface.KEY_VIDEO_BLUR_MENU, this.f18400ai);
        }
        BlurMenu c3278c2 = this.f18384aS;
        if (c3278c2 != null) {
            m19686a(CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU, c3278c2);
        }
        CameraUIListener cameraUIListener3 = this.f18349J;
        if (cameraUIListener3 != null) {
            cameraUIListener3.mo10686a((DetectResult) null);
            this.f18349J.mo10813c(false);
        }
        m19496fL();
        mo18211f(CameraUIInterface.KEY_VIDEO_SIZE);
        mo18211f(CameraUIInterface.KEY_VIDEO_FPS);
        mo18211f(CameraUIInterface.KEY_SLOW_VIDEO_SIZE);
        mo18211f(CameraUIInterface.KEY_FAST_VIDEO_SIZE);
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14462e();
        }
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g != null) {
            c2688g.m12940e();
            if (!this.f18462bs.m12950o() && (cameraUIListener = this.f18349J) != null && cameraUIListener.mo10848h(CameraFunction.DOUBLE_EXPOSURE) && this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB)) {
                mo18154ar();
            }
        }
        if (this.f18349J != null) {
            m19761bU();
        }
        SplitBackgroundView splitBackgroundView = this.f18377aL;
        if (splitBackgroundView != null) {
            splitBackgroundView.setLightBackground(m19469eQ());
        }
        RotateAnimationView rotateAnimationView = this.f18382aQ;
        if (rotateAnimationView != null) {
            rotateAnimationView.setLightBackground(m19469eQ());
        }
        SplitBackgroundView splitBackgroundView2 = this.f18378aM;
        if (splitBackgroundView2 != null) {
            splitBackgroundView2.setLightBackground(m19469eQ());
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20675e(this.f18352M);
        }
        if (this.f18467bx == null || !Util.m24488p(this.f18497i)) {
            return;
        }
        m19510fZ();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aF */
    public void mo18116aF() {
        CameraDrawerSettingUI c3326f;
        CameraLog.m12952a("checkAndStartArrowAnimation");
        if (this.f18483cm != null && !this.f18453bj && this.f18341B.getBoolean(CameraUIInterface.SHOW_ARROW_ANIMATION, false) && ((!this.f18341B.getBoolean(CameraUIInterface.KEY_DRAWER_SHOW_GUIDE_ANIMATION, true) || !f18338g) && (c3326f = this.f18348I) != null && c3326f.m21426s())) {
            this.f18483cm.sendEmptyMessage(3);
        }
        CameraLog.m12958b("checkAndStartArrowAnimation");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19737b(boolean z, boolean z2, boolean z3) {
        CameraLog.m12954a("CameraUIManager", "onResumeMessage");
        this.f18504p = false;
        this.f18505q = false;
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19181j();
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21418i();
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21418i();
        }
        if (!this.f18502n && !z && !z2) {
            m19640V(z3);
        }
        if (this.f18350K == 3) {
            mo18259q(false);
            mo18232j(false, false);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            if (viewOnLayoutChangeListenerC3444g.m23427u() && this.f18350K == 2) {
                m19835cl();
            }
            this.f18340A.m23397f();
        }
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18503h();
        }
        CameraScreenHintView cameraScreenHintView = this.f18401aj;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.m18814c();
        }
        if (!Camera.f10610l) {
            mo18067a(R.string.camera_low_battery_flash_disable);
        }
        if (!Camera.f10611m) {
            mo18067a(R.string.camera_high_temperature_flash_disable);
        }
        m19810cM();
        String string = this.f18341B.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.f18497i.getString(R.string.camera_tap_shutter_default_value));
        if (this.f18349J.mo10848h(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER) && string.equals("on") && m19491fG() && this.f18370aE != 2) {
            this.f18370aE = (byte) 1;
        }
        if (this.f18370aE == 1) {
            mo18070a(R.string.camera_tab_shutter_toast, -1, true, false, false);
            this.f18370aE = (byte) 2;
        }
    }

    /* renamed from: U */
    public void m19639U(boolean z) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19171g(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19735b(MainShutterButtonInfo c3200b, boolean z) throws Resources.NotFoundException {
        CameraControlUI viewOnClickListenerC3199a;
        ViewGroup viewGroup;
        CameraLog.m12954a("CameraUIManager", "onPause");
        this.f18504p = true;
        this.f18370aE = (byte) 0;
        this.f18355P = 0;
        this.f18354O = 0;
        this.f18507s = false;
        this.f18510v = false;
        this.f18352M = -1;
        this.f18448be = false;
        this.f18453bj = false;
        this.f18498j.m16447a();
        this.f18499k.m16436d();
        m19894dl();
        ScreenModeManager c2953g = this.f18500l;
        if (c2953g != null) {
            c2953g.m16665e();
        }
        if (m19491fG()) {
            SharedPreferences.Editor editorEdit = this.f18341B.edit();
            editorEdit.putString(CameraUIInterface.KEY_LAST_CAMERA_TAP_SHUTTER, this.f18341B.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.f18497i.getString(R.string.camera_tap_shutter_default_value)));
            editorEdit.apply();
        }
        Handler handler = this.f18483cm;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        CameraSuperTextUI c3133a = this.f18513y;
        if (c3133a != null) {
            c3133a.m18566b();
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21416g();
        }
        m19721at(true);
        m19908dz();
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21416g();
        }
        PopUpWindowManager.m20715g();
        CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
        if (viewOnClickListenerC3199a2 != null) {
            viewOnClickListenerC3199a2.m19093a(c3200b, z);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23404h();
        }
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23054d();
        }
        CaptureCountDownTimeUI c3446i = this.f18344E;
        if (c3446i != null) {
            c3446i.m23054d();
        }
        View view = this.f18403al;
        if (view != null) {
            view.setVisibility(8);
        }
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18504i();
        }
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20883d();
        }
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            if (c3278c.isMenuOpen()) {
                this.f18400ai.hideMenu(false, false, false, true);
            }
            this.f18400ai.setVideoRecordingHideMenu(false);
        }
        BlurMenu c3278c2 = this.f18384aS;
        if (c3278c2 != null) {
            if (c3278c2.isMenuOpen()) {
                this.f18384aS.hideMenu(false, false, false, true);
            }
            this.f18384aS.setVideoRecordingHideMenu(false);
        }
        CameraScreenHintView cameraScreenHintView = this.f18401aj;
        if (cameraScreenHintView != null) {
            this.f18365Z.removeView(cameraScreenHintView);
            this.f18401aj = null;
        }
        CameraScreenHintView cameraScreenHintView2 = this.f18404am;
        if (cameraScreenHintView2 != null && (viewGroup = this.f18365Z) != null) {
            viewGroup.removeView(cameraScreenHintView2);
            this.f18404am = null;
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            if (viewOnClickListenerC3261g.m20689n()) {
                mo18109a(false, true, true, false);
            }
            this.f18385aT.m20681g(false);
        }
        Map<String, ExpandableMenuPanel> map = this.f18372aG;
        if (map != null) {
            map.clear();
        }
        AiHintUI c3439b = this.f18454bk;
        if (c3439b != null) {
            c3439b.m23171a(true);
            if (this.f18454bk.m23174c()) {
                CameraTipsManager.m14374a().m14378c();
            }
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22060k();
        }
        this.f18376aK = null;
        mo18190c(true);
        mo18279v(true);
        m19903du();
        m19477eY();
        m19778bq();
        mo18048N();
        SwitchFilterMenu c3293r = this.f18402ak;
        if (c3293r != null) {
            c3293r.m21027a();
        }
        FaceBeautyMenu viewOnClickListenerC3261g2 = this.f18385aT;
        if (viewOnClickListenerC3261g2 != null) {
            viewOnClickListenerC3261g2.m20691p();
        }
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14463f();
        }
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g != null) {
            c2688g.m12936c();
        }
        if (mo18111aA()) {
            mo18192c(false, false, true, true);
            mo18041J(false);
        }
        if (m19950ex()) {
            mo18268s(false, false);
        }
        if (this.f18368aC != null) {
            mo18210f(18, true);
        }
        if (Util.m24498u() && this.f18425bH != null && (viewOnClickListenerC3199a = this.f18514z) != null && viewOnClickListenerC3199a.m19187k() && !this.f18514z.m19190l()) {
            this.f18425bH.m20246a(false);
            ViewGroup viewGroup2 = this.f18423bF;
            if (viewGroup2 != null) {
                if (this.f18506r) {
                    viewGroup2.setVisibility(4);
                } else {
                    Util.m24387b(viewGroup2);
                }
            }
        }
        m19727az(false);
        mo18245n();
    }

    /* renamed from: br */
    public void m19779br() {
        CameraLog.m12954a("CameraUIManager", "onStop");
        if (this.f18484cn != null && m19919eG()) {
            this.f18484cn.mo20025a();
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22059j();
        }
        ScreenModeManager c2953g = this.f18500l;
        if (c2953g != null) {
            c2953g.m16666f();
        }
        if (this.f18350K == 2) {
            m19835cl();
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23406i();
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19191m();
        }
        ComboPreferences comboPreferences = this.f18341B;
        if (comboPreferences == null || !comboPreferences.getBoolean("pref_camera_statement_key", false)) {
            return;
        }
        m19513fc();
    }

    /* renamed from: bs */
    public void m19780bs() {
        RecyclerView.AbstractC0687c abstractC0687c;
        CameraLog.m12954a("CameraUIManager", "onDestroy");
        if (!this.f18473cc.isEmpty()) {
            this.f18473cc.clear();
        }
        this.f18377aL = null;
        this.f18378aM = null;
        this.f18468by = null;
        this.f18399ah = null;
        this.f18375aJ = null;
        this.f18400ai = null;
        this.f18349J = null;
        this.f18497i = null;
        this.f18342C = null;
        this.f18385aT = null;
        Handler handler = this.f18483cm;
        if (handler != null) {
            handler.removeMessages(5);
            this.f18483cm.removeMessages(11);
        }
        GalleryPreviewAdapter c3230k = this.f18425bH;
        if (c3230k != null && (abstractC0687c = this.f18474cd) != null) {
            c3230k.unregisterAdapterDataObserver(abstractC0687c);
        }
        TimeLapseProMenuLayout c3071g = this.f18433bP;
        if (c3071g != null) {
            c3071g.m17759q();
            this.f18365Z.removeView(this.f18433bP);
            this.f18433bP = null;
        }
        TimeLapseProRecordView c3073i = this.f18435bR;
        if (c3073i != null) {
            c3073i.m17932b();
            this.f18365Z.removeView(this.f18435bR);
            this.f18435bR = null;
        }
        ScreenModeManager c2953g = this.f18500l;
        if (c2953g != null) {
            c2953g.m16667g();
        }
        CameraSuperTextUI c3133a = this.f18513y;
        if (c3133a != null) {
            c3133a.m18567c();
            this.f18513y = null;
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19194n();
            this.f18514z = null;
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22052f();
            this.f18447bd = null;
            this.f18463bt = null;
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21417h();
            this.f18347H = null;
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21417h();
            this.f18348I = null;
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23408j();
            this.f18340A = null;
        }
        ViewGroup viewGroup = this.f18365Z;
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            this.f18365Z.removeAllViews();
            this.f18365Z = null;
        }
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22222d();
            this.f18373aH.m22234k();
            this.f18373aH = null;
        }
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23060i();
            this.f18343D = null;
        }
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14464g();
            this.f18450bg = null;
        }
        if (this.f18409ar != null) {
            this.f18409ar = null;
        }
        AiHintUI c3439b = this.f18454bk;
        if (c3439b != null) {
            c3439b.m23175d();
            this.f18454bk = null;
        }
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g != null) {
            c2688g.m12938d();
            this.f18462bs = null;
        }
        CaptureCountDownTimeUI c3446i = this.f18344E;
        if (c3446i != null) {
            c3446i.m23060i();
            this.f18344E = null;
        }
        if (this.f18467bx != null) {
            this.f18467bx = null;
        }
        OutCaptureManager c2929b = this.f18499k;
        if (c2929b != null) {
            c2929b.m16435c();
        }
        GalleryBottomMenuLayout c3229j = this.f18424bG;
        if (c3229j != null) {
            c3229j.m20187c();
            this.f18424bG = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m19955g(int OplusGLSurfaceView_13, boolean z) {
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22211a(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: V */
    public void m19640V(boolean z) {
        m19781bt();
        mo18184c(0);
        mo18227i(true);
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19178i(0);
        }
        if (z) {
            m19367V(this.f18352M);
            mo18107a(false, true);
            return;
        }
        if (this.f18349J.mo10848h(CameraUIInterface.KEY_FILTER_PROCESS)) {
            mo18263r(false);
        } else {
            mo18259q(false);
        }
        if (this.f18349J.mo10795bl()) {
            mo18240l(false, false);
        } else {
            mo18232j(false, false);
        }
        if (this.f18349J.mo10796bm()) {
            mo18228i(false, false);
        } else {
            mo18223h(false, false);
        }
        if (this.f18349J.mo10797bn() && !this.f18349J.mo10814c()) {
            if (!CameraCharacteristicsUtil.m12974a(mo19845cv())) {
                mo18252o(true, false);
                mo18260q(true, false);
            }
        } else {
            mo18256p(false, false);
            mo18264r(false, false);
        }
        if (mo19966j(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            mo18049N(true);
        } else {
            mo18050O(true);
        }
        m19726ay(false);
        if (m19489fE()) {
            mo18046M();
        } else {
            mo18048N();
        }
        if (this.f18349J.mo10808by()) {
            return;
        }
        m19959h(this.f18352M, false);
    }

    /* renamed from: bt */
    public void m19781bt() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19106a(true);
        }
    }

    /* renamed from: W */
    public void m19641W(boolean z) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21575e(z);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21575e(z);
        }
    }

    /* renamed from: bu */
    public void m19782bu() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21527E();
        }
    }

    /* renamed from: bv */
    public void m19783bv() {
        if (this.f18347H == null || 3 != mo18134aX()) {
            return;
        }
        this.f18347H.m21539Q();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19734b(MainShutterButtonInfo c3200b) {
        CameraLog.m12954a("CameraUIManager", "switchToModeType, buttonType: " + c3200b.m19225a() + ", insideColor: " + c3200b.m19229b() + ", shape: " + c3200b.m19237d());
        PopUpWindowManager.m20704a(false);
        this.f18507s = false;
        this.f18354O = 0;
        Handler handler = this.f18483cm;
        if (handler != null) {
            handler.removeMessages(1);
        }
        if (m19787bz()) {
            m19848cy();
        }
        if (this.f18350K != 3) {
            this.f18514z.m19092a(c3200b);
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20686k();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19685a(String str, MainShutterButtonInfo c3200b, boolean z) {
        if (this.f18514z != null) {
            if (!m19875dS()) {
                this.f18514z.m19094a(c3200b, z, true);
            } else {
                this.f18514z.m19079a(8, 300);
            }
            if (this.f18350K != 3 && !this.f18504p && !this.f18349J.mo10791bh() && !m19875dS()) {
                this.f18514z.m19106a(false);
            }
        }
        if (this.f18350K != 3) {
            this.f18349J.mo10883y();
            m19641W(true);
        }
        if (!this.f18349J.mo10848h(CameraUIInterface.KEY_FILTER_PROCESS)) {
            mo18259q(false);
        }
        if (m19489fE()) {
            mo18046M();
        } else {
            mo18048N();
        }
        mo18206e(false, false);
        if (!this.f18349J.mo10719aX()) {
            mo18067a(R.string.camera_dark_environment_open_flash_toast);
        }
        if (m19938el()) {
            mo18108a(true, false, false);
        }
        if (!this.f18349J.mo10808by() || m19875dS()) {
            return;
        }
        mo18193d(0);
    }

    /* renamed from: bw */
    public void m19784bw() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19197o();
        }
    }

    /* renamed from: bx */
    public void m19785bx() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19200p();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19690a(List<String> list, String str, int OplusGLSurfaceView_13) {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20872a(list, str, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: by */
    public boolean m19786by() {
        return this.f18502n;
    }

    /* renamed from: A */
    public void m19613A(int OplusGLSurfaceView_13) {
        this.f18353N = OplusGLSurfaceView_13;
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23392d(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18088a(SurfaceTextureScreenNail.IntrinsicsJvm.kt_4 bVar, boolean z, boolean z2, String str) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23343a(bVar, z, z2, str);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo18247n(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23389c(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: o */
    public void mo18251o(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23393d(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18075a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23330a(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2);
        }
    }

    /* renamed from: B */
    public long m19615B(int OplusGLSurfaceView_13) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23394e(OplusGLSurfaceView_13);
        }
        return 0L;
    }

    /* renamed from: bz */
    public boolean m19787bz() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10656J();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: bA */
    public void mo19741bA() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10665S();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo19655a(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10678a(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo19953f(int OplusGLSurfaceView_13, int i2) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10811c(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface, com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: aw */
    public boolean mo18159aw() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10729ah();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ax */
    public boolean mo18160ax() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10864l();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: bB */
    public boolean mo19742bB() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10731aj();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public float mo19645a(float COUIBaseListPopupWindow_12) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10673a(COUIBaseListPopupWindow_12);
        }
        return 0.0f;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: bC */
    public void mo19743bC() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10732ak();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: F */
    public void mo18033F(boolean z) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10752b(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ay */
    public boolean mo18161ay() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10734am();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo18208e(int OplusGLSurfaceView_13, int i2) {
        return Util.m24294a(m19744bD(), OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: bd */
    public boolean mo18181bd() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && (ApsConstant.CAPTURE_MODE_MICROSCOPE.equals(cameraUIListener.mo10736ao()) || (this.f18349J.mo10737ap() && m19468eP()));
    }

    /* renamed from: eP */
    private boolean m19468eP() {
        ComboPreferences comboPreferences = this.f18341B;
        return comboPreferences != null && "square".equals(comboPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, null));
    }

    /* renamed from: bD */
    public ShutterButton m19744bD() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19206r();
        }
        return null;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m19963i(String str) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19105a(str);
        }
    }

    /* renamed from: bE */
    public Thumbnail m19745bE() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19210t();
        }
        return null;
    }

    /* renamed from: bF */
    public int m19746bF() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19212u();
        }
        return 0;
    }

    /* renamed from: bG */
    public Size m19747bG() {
        return this.f18340A.m23429w();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19668a(Size size) {
        this.f18452bi = size;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public CameraScreenNail mo18183c() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23430x();
        }
        return null;
    }

    /* renamed from: bH */
    public CameraDrawerSettingUI m19748bH() {
        return this.f18348I;
    }

    /* renamed from: bI */
    public CameraPreviewUI m19749bI() {
        return this.f18340A;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: p */
    public RelativeLayout mo18253p() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23431y();
        }
        return null;
    }

    /* renamed from: bJ */
    public Rect m19750bJ() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23309J();
        }
        return null;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18087a(View view, String str, int OplusGLSurfaceView_13, boolean z) {
        ConcurrentHashMap<Integer, View> concurrentHashMap = this.f18371aF.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        View view2 = concurrentHashMap.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (z && view2 != null) {
            this.f18365Z.removeView(view2);
            view2 = null;
        }
        if (view2 == null && this.f18365Z.indexOfChild(view) == -1) {
            view.setTag(R.id_renamed.tag_name_specific_mode_view_type, Integer.valueOf(OplusGLSurfaceView_13));
            this.f18365Z.addView(view);
        }
        view.clearAnimation();
        concurrentHashMap.put(Integer.valueOf(OplusGLSurfaceView_13), view);
        this.f18371aF.put(str, concurrentHashMap);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18172b(String str, boolean z) {
        for (String str2 : this.f18371aF.keySet()) {
            m19691a(this.f18371aF.get(str2), TextUtils.equals(str2, str), z, str2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19691a(ConcurrentHashMap<Integer, View> concurrentHashMap, final boolean z, boolean z2, final String str) throws Resources.NotFoundException {
        if (concurrentHashMap != null) {
            for (final View view : concurrentHashMap.values()) {
                if (view != null) {
                    if (z2) {
                        view.clearAnimation();
                        final Object tag = view.getTag(R.id_renamed.tag_name_specific_mode_view_type);
                        if (!z && tag != null) {
                            concurrentHashMap.remove(tag);
                        }
                        Util.m24271a(view, z ? 0 : 8, new Animation.AnimationListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.15
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                                if (CameraUIManager.this.f18349J != null) {
                                    CameraUIManager.this.f18349J.mo10687a(str, tag, z, false);
                                }
                                View view2 = view;
                                if (view2 != null) {
                                    view2.setVisibility(z ? 0 : 8);
                                }
                                CameraUIManager.this.mo18288z(true);
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                if (CameraUIManager.this.f18349J != null) {
                                    CameraUIManager.this.f18349J.mo10687a(str, tag, z, true);
                                }
                            }
                        }, 300, 0L, AnimationUtils.loadInterpolator(view.getContext(), R.anim.specific_view_alpha_interpolator));
                    } else {
                        Object tag2 = view.getTag(R.id_renamed.tag_name_specific_mode_view_type);
                        if (!z) {
                            view.setVisibility(8);
                            if (tag2 != null) {
                                concurrentHashMap.remove(tag2);
                            }
                        } else {
                            view.setVisibility(0);
                        }
                        this.f18349J.mo10687a(str, tag2, z, true);
                    }
                }
            }
        }
    }

    /* renamed from: bK */
    public boolean m19751bK() {
        return PopUpWindowManager.m20706a();
    }

    /* renamed from: C */
    public void m19617C(int OplusGLSurfaceView_13) {
        this.f18350K = OplusGLSurfaceView_13;
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19166f(this.f18350K);
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21573e(this.f18350K);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21573e(this.f18350K);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23379b(this.f18350K);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19675a(CameraControlButtonListener cameraControlButtonListener) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19091a(cameraControlButtonListener);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19683a(CameraScreenNail.IntrinsicsJvm.kt_5 dVar) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23351a(dVar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19680a(ThumbnailClickListener interfaceC3204f) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19101a(interfaceC3204f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19732b(View.OnClickListener onClickListener) {
        this.f18379aN = onClickListener;
        SplitBackgroundView splitBackgroundView = this.f18378aM;
        if (splitBackgroundView != null) {
            splitBackgroundView.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: X */
    public void m19642X(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23396e(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19667a(Rect rect, Size size) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23337a(rect, size);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19666a(Rect rect, Rect rect2, Size size) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23336a(rect, rect2, size);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19728b(float COUIBaseListPopupWindow_12) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23327a(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19788c(float COUIBaseListPopupWindow_12) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23378b(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19850d(float COUIBaseListPopupWindow_12) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23387c(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19696a(Face[] faceArr, int[] iArr) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g;
        if (m19864dH() || (viewOnLayoutChangeListenerC3444g = this.f18340A) == null) {
            return;
        }
        viewOnLayoutChangeListenerC3444g.m23359a(faceArr, iArr);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19795c(int[] iArr) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g;
        if (m19864dH() || (viewOnLayoutChangeListenerC3444g = this.f18340A) == null) {
            return;
        }
        viewOnLayoutChangeListenerC3444g.m23358a(iArr);
    }

    /* renamed from: Y */
    public void m19643Y(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23409j(z);
        }
    }

    /* renamed from: D */
    public void m19619D(int OplusGLSurfaceView_13) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23398f(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: E */
    public void m19621E(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        this.f18500l.m16654a(OplusGLSurfaceView_13);
        this.f18351L = this.f18500l.m16659b();
        ToastUtil.m24638a(mo19935ei());
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19170g(this.f18351L);
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21576f(this.f18351L);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21576f(this.f18351L);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23388c(this.f18351L);
        }
        int iM19476eX = m19476eX();
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null && iM19476eX != c3434ae.m23052c()) {
            this.f18343D.m23050b(m19475eW(), iM19476eX, mo19881dY(), true);
        }
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18495c(iM19476eX);
        }
        CameraScreenHintView cameraScreenHintView = this.f18401aj;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setOrientation(this.f18351L);
        }
        CameraScreenHintView cameraScreenHintView2 = this.f18404am;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.setOrientation(this.f18351L);
        }
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22229g(this.f18351L);
        }
        SplitBackgroundView splitBackgroundView = this.f18377aL;
        if (splitBackgroundView != null) {
            splitBackgroundView.m20509a(this.f18351L, true);
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22053f(this.f18351L);
        }
        CameraSuperTextUI c3133a = this.f18513y;
        if (c3133a != null) {
            c3133a.m18563a(this.f18351L);
        }
        SlowVideoModeSeekBar c3519b = this.f18451bh;
        if (c3519b != null) {
            c3519b.m24098a(this.f18351L, true);
        }
        AiHintUI c3439b = this.f18454bk;
        if (c3439b != null) {
            c3439b.m23172b(this.f18351L);
        }
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g != null) {
            c2688g.m12929a(this.f18351L);
        }
        RotateAnimationView rotateAnimationView = this.f18382aQ;
        if (rotateAnimationView != null) {
            rotateAnimationView.m20509a(this.f18351L, true);
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20678f(this.f18351L);
        }
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            c3278c.setOrientation(this.f18351L, true);
        }
        if (mo19966j(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            RotateAnimationView rotateAnimationView2 = this.f18432bO;
            if (rotateAnimationView2 != null) {
                rotateAnimationView2.m20509a(this.f18351L, true);
            }
            RotateAnimationView rotateAnimationView3 = this.f18430bM;
            if (rotateAnimationView3 != null) {
                rotateAnimationView3.m20509a(this.f18351L, true);
            }
            RotateAnimationView rotateAnimationView4 = this.f18431bN;
            if (rotateAnimationView4 != null) {
                rotateAnimationView4.m20509a(this.f18351L, true);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: G */
    public void mo18035G(boolean z) {
        this.f18364Y = z;
        m19825cb();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18107a(final boolean z, final boolean z2) {
        Activity activity = this.f18497i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.16
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraUIManager.this.f18514z != null) {
                        CameraUIManager.this.f18514z.m19159d(z, z2);
                    }
                }
            });
        }
    }

    /* renamed from: v */
    public void m19981v(final boolean z, final boolean z2) {
        Activity activity = this.f18497i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.17
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraUIManager.this.f18514z != null) {
                        CameraUIManager.this.f18514z.m19172g(z, z2);
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18190c(boolean z) {
        if (this.f18399ah != null) {
            if (!z || this.f18349J.mo10848h(CameraUIInterface.KEY_FILTER_PROCESS)) {
                this.f18399ah.setEnabled(z);
                this.f18399ah.setClickable(z);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: v */
    public void mo18279v(boolean z) {
        AnimatorSet animatorSet;
        if (this.f18377aL != null) {
            if (!z || this.f18349J.mo10795bl()) {
                if (z && m19486fB()) {
                    return;
                }
                m19517fg();
                if (z && (((animatorSet = this.f18387aV) == null || (!animatorSet.isRunning() && !this.f18387aV.isStarted())) && this.f18377aL.getVisibility() == 0)) {
                    this.f18377aL.setClickable(z);
                } else {
                    if (z) {
                        return;
                    }
                    this.f18377aL.setClickable(z);
                }
            }
        }
    }

    /* renamed from: bL */
    public void m19752bL() {
        ExpandableMenuPanel c3337q = this.f18376aK;
        if (c3337q != null) {
            c3337q.scrollToNext();
        }
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g == null || !c3282g.isEffectMenuOpen()) {
            return;
        }
        this.f18399ah.scrollToNext();
    }

    /* renamed from: bM */
    public void m19753bM() {
        ExpandableMenuPanel c3337q = this.f18376aK;
        if (c3337q != null) {
            c3337q.scrollToPrevious();
        }
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g == null || !c3282g.isEffectMenuOpen()) {
            return;
        }
        this.f18399ah.scrollToPrevious();
    }

    /* renamed from: bN */
    public int m19754bN() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            return c3282g.respondSingleTouchEventY();
        }
        return 0;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: A */
    public boolean mo18023A() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            return c3282g.isEffectMenuOpen();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: B */
    public boolean mo18025B() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2;
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a == null || this.f18399ah == null || this.f18349J == null || this.f18385aT == null || this.f18400ai == null) {
            return false;
        }
        return viewOnClickListenerC3199a.m19110a() || this.f18399ah.isAnimationRunning() || this.f18349J.mo10879u() || this.f18385aT.m20688m() || ((animatorSet = this.f18386aU) != null && animatorSet.isRunning()) || (((animatorSet2 = this.f18387aV) != null && animatorSet2.isRunning()) || this.f18442bY || this.f18400ai.isAnimationRunning());
    }

    /* renamed from: bO */
    public boolean m19755bO() {
        CameraSettingUI c3335o = this.f18347H;
        return c3335o == null || c3335o.m21531I();
    }

    /* renamed from: bP */
    public boolean m19756bP() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        return viewOnClickListenerC3199a != null && viewOnClickListenerC3199a.m19149b();
    }

    /* renamed from: bQ */
    public void m19757bQ() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19150c();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: C */
    public void mo18026C() {
        SwitchFilterMenu c3293r = this.f18402ak;
        if (c3293r != null) {
            c3293r.m21027a();
        }
    }

    /* renamed from: bR */
    public boolean m19758bR() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19216w();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18175b(boolean z, boolean z2) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19164e(z, z2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18191c(boolean z, boolean z2) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19168f(z, z2);
            this.f18514z.m19183j(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo18213f(boolean z, boolean z2) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21407a(z, z2);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21407a(z, z2);
        }
    }

    /* renamed from: bS */
    public boolean m19759bS() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            return c3335o.m21534L();
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            return c3326f.m21534L();
        }
        return false;
    }

    /* renamed from: bT */
    public int m19760bT() {
        return Util.m24184L();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: r */
    public int mo18261r() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19070T();
        }
        return 0;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18200d(boolean z, boolean z2) {
        CameraLog.m12954a("CameraUIManager", "enableAllCameraView, enable: " + z + ", ashed: " + z2);
        mo18107a(z, z2);
        mo18175b(z, z2);
        mo18191c(z, z2);
        mo18213f(z, z2);
        mo18190c(z);
        mo18279v(z);
        mo18031E(z);
        m19403aD(z);
        mo18105a(z);
        m19404aE(z);
    }

    /* renamed from: aD */
    private void m19403aD(boolean z) {
        SlowVideoModeSeekBar c3519b = this.f18451bh;
        if (c3519b != null) {
            c3519b.setEnabled(z);
        }
    }

    /* renamed from: aE */
    private void m19404aE(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23419o(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo18243m(boolean z) throws Resources.NotFoundException {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19163e(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo18218g(boolean z, boolean z2) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19156c(z2, false);
            this.f18514z.m19177i();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18184c(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19079a(OplusGLSurfaceView_13, 300);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18193d(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19141b(OplusGLSurfaceView_13, 250);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo18202e(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19185k(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo18209f(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19152c(OplusGLSurfaceView_13, 300);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18167b(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        CameraControlUI viewOnClickListenerC3199a;
        if (3 == this.f18350K || (viewOnClickListenerC3199a = this.f18514z) == null) {
            return;
        }
        viewOnClickListenerC3199a.m19142b(OplusGLSurfaceView_13, z);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo18215g(int OplusGLSurfaceView_13) {
        m19650a(OplusGLSurfaceView_13, 0.0f, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19650a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2) {
        CameraDrawerSettingUI c3326f;
        if (OplusGLSurfaceView_13 == 0) {
            if (mo18057R() || this.f18503o || this.f18502n) {
                return;
            }
            CameraUIListener cameraUIListener = this.f18349J;
            if (cameraUIListener != null && cameraUIListener.mo10658L()) {
                return;
            }
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21541a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, f2);
            if (OplusGLSurfaceView_13 != 0) {
                mo18045L(false);
            } else {
                if (this.f18504p || (c3326f = this.f18348I) == null) {
                    return;
                }
                c3326f.mo21420m();
            }
        }
    }

    /* renamed from: w */
    public void m19983w(boolean z, boolean z2) {
        if (mo19900dr() && mo19966j(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            return;
        }
        if (z) {
            if (mo18057R()) {
                return;
            }
            CameraUIListener cameraUIListener = this.f18349J;
            if (cameraUIListener != null && cameraUIListener.mo10658L()) {
                return;
            }
        }
        if (3 == this.f18350K || this.f18347H == null) {
            return;
        }
        PathInterpolator pathInterpolator = z2 ? this.f18445bb : null;
        long OplusGLSurfaceView_15 = z2 ? 400L : 0L;
        if (z) {
            this.f18347H.m21552a(true, 0.0f, this.f18465bv, this.f18444ba, 400L, pathInterpolator, OplusGLSurfaceView_15, z2 ? 150L : 0L);
        } else {
            this.f18347H.m21552a(false, 0.0f, this.f18465bv, this.f18444ba, 250L, pathInterpolator, OplusGLSurfaceView_15, 0L);
        }
    }

    /* renamed from: bU */
    public void m19761bU() {
        mo18052P(true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: P */
    public void mo18052P(boolean z) {
        BaseScreenMode abstractC2934a = this.f18467bx;
        if (abstractC2934a == null || this.f18349J == null) {
            return;
        }
        boolean zM16658a = this.f18500l.m16658a(abstractC2934a.mo16516h());
        if (this.f18469bz != null) {
            if (!z || this.f18349J.mo10814c() || this.f18349J.mo10658L() || this.f18349J.mo10739ar()) {
                this.f18469bz.setVisibility(8);
                this.f18499k.m16430a();
                this.f18498j.m16455c(false);
                this.f18418bA.setVisibility(8);
            } else if (!mo18057R()) {
                if (this.f18349J.mo10848h(CameraFunction.OUT_PREVIEW_ENABLE)) {
                    this.f18469bz.setImageResource(R.drawable.icon_out_screen_preview_switch);
                    this.f18499k.m16430a();
                } else if (this.f18349J.mo10848h(CameraFunction.OUT_CAPTURE_ENABLE)) {
                    this.f18469bz.setImageResource(R.drawable.icon_out_screen_capture_switch);
                } else {
                    this.f18499k.m16430a();
                }
                this.f18469bz.setVisibility(this.f18349J.mo10848h(CameraFunction.OUT_PREVIEW_BUTTON_SHOW) ? 0 : 8);
                this.f18498j.m16455c(this.f18349J.mo10848h(CameraFunction.OUT_PREVIEW_CAPTURE_ENABLE));
                this.f18418bA.setVisibility(this.f18349J.mo10848h(CameraFunction.OUT_CAPTURE_CLOSE_ENABLE) ? 0 : 8);
            }
        }
        boolean z2 = this.f18500l.m16670k() && !mo18057R();
        int OplusGLSurfaceView_13 = z2 ? 0 : 8;
        if (this.f18468by != null) {
            if (z2 && zM16658a) {
                return;
            }
            this.f18468by.setVisibility(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ap */
    public boolean mo18152ap() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23413l();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aq */
    public String mo18153aq() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        return viewOnLayoutChangeListenerC3444g != null ? viewOnLayoutChangeListenerC3444g.m23414m() : "";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19689a(String str, boolean z, boolean z2) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21550a(str, z, z2);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21550a(str, z, z2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m19910e(float COUIBaseListPopupWindow_12) {
        m19649a(COUIBaseListPopupWindow_12, false, 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19649a(float COUIBaseListPopupWindow_12, boolean z, long OplusGLSurfaceView_15) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21540a(COUIBaseListPopupWindow_12, z, OplusGLSurfaceView_15);
        }
    }

    /* renamed from: Z */
    public void m19644Z(boolean z) {
        if (z && f18339h) {
            f18339h = false;
        }
    }

    /* renamed from: bV */
    public boolean m19762bV() {
        if (this.f18350K != 1 || this.f18349J.mo10786bc().m13359w()) {
            return false;
        }
        return f18339h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19730b(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        CameraLog.m12954a("CameraUIManager", "afterOpenCameraUpdateUI");
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null && c3282g.isEffectMenuOpen()) {
            z = false;
        }
        if (4 == mo18134aX() && mo18051O()) {
            z = false;
        }
        if (this.f18347H != null) {
            if (1 != mo18134aX() || !mo19916eD()) {
                this.f18347H.mo21405a(OplusGLSurfaceView_13, false, !this.f18502n && z, z2);
            }
            if (this.f18502n) {
                this.f18347H.mo21407a(false, true);
                this.f18347H.m21565c(4);
            }
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21405a(OplusGLSurfaceView_13, false, !this.f18502n && z, z2);
            if (this.f18502n) {
                this.f18348I.mo21407a(false, true);
                this.f18348I.m21565c(4);
            }
        }
        m19825cb();
    }

    /* renamed from: bW */
    public void m19763bW() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21536N();
        }
    }

    /* renamed from: bX */
    public void m19764bX() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21537O();
        }
    }

    /* renamed from: bY */
    public void m19765bY() {
        CameraLog.m12954a("CameraUIManager", "afterEnterCameraStartPreviewDone");
        if (this.f18502n) {
            return;
        }
        mo18213f(true, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19665a(Bitmap bitmap, Thumbnail c3203e, int OplusGLSurfaceView_13, boolean z) {
        CameraSuperTextUI c3133a = this.f18513y;
        if (c3133a != null) {
            c3133a.m18564a(bitmap, c3203e, OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19678a(Thumbnail c3203e) {
        m19679a(c3203e, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19679a(Thumbnail c3203e, boolean z) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19100a(c3203e, z);
        }
        GalleryPreviewAdapter c3230k = this.f18425bH;
        if (c3230k != null) {
            c3230k.m20238a(c3203e, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19664a(Bitmap bitmap) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19087a(bitmap);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19790c(long OplusGLSurfaceView_15) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19086a(OplusGLSurfaceView_15);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19676a(CameraControlUI.IntrinsicsJvm.kt_3 cVar) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19097a((Thumbnail.IntrinsicsJvm.kt_5) null, true, cVar);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18094a(Thumbnail c3203e, int OplusGLSurfaceView_13) {
        if (this.f18514z != null) {
            CameraLog.m12955a("captureX preUpdateThumbnail animType: " + OplusGLSurfaceView_13, "12ct_preUpdateThumbnail", CameraConstant.f13119d.longValue());
            this.f18514z.m19099a(c3203e, OplusGLSurfaceView_13);
            CameraLog.m12964d("captureX preUpdateThumbnail animType: " + OplusGLSurfaceView_13, "12ct_preUpdateThumbnail");
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18199d(boolean z) {
        CameraLog.m12954a("CameraUIManager", "updateThumbnail, anim: " + z);
        mo18093a((Thumbnail.IntrinsicsJvm.kt_5) null, z);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18093a(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z) {
        CameraLog.m12954a("CameraUIManager", "updateThumbnail");
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19096a(dVar, z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m19954f(String str, boolean z) {
        CameraLog.m12954a("CameraUIManager", "updateGalleryPreviewUI");
        GalleryPreviewAdapter c3230k = this.f18425bH;
        if (c3230k != null) {
            c3230k.m20244a(str, z, 0);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18098a(String str, int OplusGLSurfaceView_13) {
        GalleryPreviewAdapter c3230k = this.f18425bH;
        if (c3230k != null) {
            c3230k.m20244a(str, false, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: bZ */
    public void m19766bZ() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19067Q();
        }
    }

    /* renamed from: ca */
    public boolean m19824ca() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19068R();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo18227i(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23355a(z);
            this.f18340A.m23383b(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo18231j(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23405h(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo18235k(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23355a(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m19739b(Size size) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23385b(size);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19792c(Size size) {
        CameraLog.m12954a("CameraUIManager", "notifyEffectMenuPreviewSizeChanged, previewSize: " + size.getWidth() + "x" + size.getHeight());
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            int textureWidth = c3282g.getTextureWidth();
            int textureHeight = this.f18399ah.getTextureHeight();
            int width = size.getWidth();
            int height = size.getHeight();
            if (this.f18353N % 180 == 0) {
                width = height;
                height = width;
            }
            if (textureWidth == height && textureHeight == width) {
                return;
            }
            this.f18399ah.m20877b(height, width);
        }
    }

    /* renamed from: aa */
    public void m19702aa(boolean z) {
        this.f18514z.m19196n(z);
    }

    /* renamed from: F */
    public void m19622F(int OplusGLSurfaceView_13) {
        this.f18352M = OplusGLSurfaceView_13;
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21555b(this.f18352M);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21555b(this.f18352M);
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19157d(this.f18352M);
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20675e(this.f18352M);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23328a(this.f18352M);
        }
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18491b(this.f18352M);
        }
        m19825cb();
    }

    /* renamed from: eQ */
    private boolean m19469eQ() {
        if (this.f18364Y) {
            return true;
        }
        int iMo18134aX = mo18134aX();
        if (iMo18134aX == 1) {
            int OplusGLSurfaceView_13 = this.f18352M;
            if (OplusGLSurfaceView_13 != 0 && 1 != OplusGLSurfaceView_13) {
                return false;
            }
        } else if (iMo18134aX == 2 || 2 != this.f18352M) {
            return false;
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19670a(Size size, Size size2, boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23341a(size, z);
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (Util.m24426d(size.getWidth(), size.getHeight()) == 2) {
            fArr[0] = 0.0f;
        }
        m19792c(size2);
    }

    /* renamed from: cb */
    public void m19825cb() {
        CameraLog.m12954a("CameraUIManager", "updateButtonBg, mSizeRatioType: " + this.f18352M);
        if (this.f18483cm.hasCallbacks(this.f18476cf)) {
            return;
        }
        this.f18483cm.post(this.f18476cf);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: x */
    public void mo18283x() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19066P();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m19959h(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("CameraUIManager", "previewType: " + OplusGLSurfaceView_13 + ", needControlAnimation: " + z);
        if (this.f18514z == null || mo18051O() || mo19881dY()) {
            return;
        }
        this.f18514z.m19153c(OplusGLSurfaceView_13, z);
    }

    /* renamed from: ab */
    public void m19703ab(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23407i(z);
        }
    }

    /* renamed from: cc */
    public void m19826cc() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23310K();
        }
    }

    /* renamed from: cd */
    public void m19827cd() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23311L();
        }
    }

    /* renamed from: ce */
    public void m19828ce() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23312M();
        }
    }

    /* renamed from: cf */
    public boolean m19829cf() {
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            return c3434ae.m23048a();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18096a(Float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, boolean z, boolean z2) {
        if (this.f18343D == null) {
            this.f18343D = new VideoRecordingTimeUI(this.f18497i);
        }
        this.f18343D.m23055d(mo18158av() && mo19881dY());
        int iM19476eX = m19476eX();
        if (this.f18500l != null && Util.m24495t()) {
            OplusGLSurfaceView_13 = this.f18500l.mo16411a().mo16494a(this.f18497i, OplusGLSurfaceView_13);
            this.f18343D.m23045a(this.f18500l.mo16411a());
        }
        int i2 = OplusGLSurfaceView_13;
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23040a(i2, m19475eW(), iM19476eX, z, mo19881dY(), z2);
            this.f18343D.m23058g();
        }
        m19708ag(true);
        m19709ah(true);
        m19812cO();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: u */
    public void mo18273u() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f18448be || jCurrentTimeMillis - this.f18362W < 3000) {
            return;
        }
        mo18070a(R.string.camera_slow_video_tips, -1, true, false, false);
        this.f18448be = true;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: v */
    public void mo18277v() {
        mo18070a(R.string.camera_video_binaural_recording_tips, -1, true, false, false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18081a(long OplusGLSurfaceView_15, long j2, boolean z, boolean z2, long j3) {
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23044a(OplusGLSurfaceView_15, j2, z, z2, j3);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo18205e(boolean z) {
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23051b(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo18212f(boolean z) {
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23046a(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo18226i(int OplusGLSurfaceView_13) {
        if (this.f18344E == null) {
            this.f18344E = new CaptureCountDownTimeUI(this.f18497i, OplusGLSurfaceView_13);
        }
        CaptureCountDownTimeUI c3446i = this.f18344E;
        if (c3446i != null) {
            c3446i.m23041a(OplusGLSurfaceView_13, m19475eW(), false, mo19881dY());
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo18217g(boolean z) {
        CaptureCountDownTimeUI c3446i = this.f18344E;
        if (c3446i != null) {
            c3446i.m23047a(z, mo19881dY());
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18082a(long OplusGLSurfaceView_15, boolean z) {
        CaptureCountDownTimeUI c3446i = this.f18344E;
        if (c3446i != null) {
            c3446i.m23043a(OplusGLSurfaceView_15, 0L, z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18079a(long OplusGLSurfaceView_15) {
        NightTimeView nightTimeView = this.f18345F;
        if (nightTimeView == null) {
            m19472eT();
        } else {
            nightTimeView.m22201a(OplusGLSurfaceView_15);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18186c(int OplusGLSurfaceView_13, boolean z) {
        NightTimeView nightTimeView;
        CameraLog.m12954a("CameraUIManager", "setNightCountDownUIVisible, visible: " + OplusGLSurfaceView_13 + ", needAnim: " + z);
        if (this.f18345F == null) {
            m19472eT();
        }
        if ((OplusGLSurfaceView_13 == 0 && m19875dS() && m19864dH()) || (nightTimeView = this.f18345F) == null) {
            return;
        }
        nightTimeView.m22200a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: eR */
    private void m19470eR() {
        NightTimeView nightTimeView = this.f18345F;
        if (nightTimeView != null) {
            ((RelativeLayout.LayoutParams) nightTimeView.getLayoutParams()).topMargin = m19471eS();
        }
    }

    /* renamed from: eS */
    private int m19471eS() {
        int iMo18134aX = mo18134aX();
        Resources resources = this.f18497i.getApplication().getResources();
        if (iMo18134aX == 1) {
            return resources.getDimensionPixelSize(R.dimen.night_countdown_time_text_margin_top_fold_full_mode);
        }
        if (iMo18134aX == 2) {
            return resources.getDimensionPixelSize(R.dimen.night_countdown_time_text_margin_top_fold_out_mode);
        }
        if (iMo18134aX == 3) {
            return resources.getDimensionPixelSize(R.dimen.night_countdown_time_text_margin_top_fold_split_mode);
        }
        if (iMo18134aX == 4) {
            return resources.getDimensionPixelSize(R.dimen.night_countdown_time_text_margin_top_fold_rack_mode);
        }
        return resources.getDimensionPixelSize(R.dimen.night_countdown_time_text_margin_top);
    }

    /* renamed from: eT */
    private void m19472eT() {
        Activity activity = this.f18497i;
        if (activity == null) {
            CameraLog.m12967f("CameraUIManager", "addNightCountDownTimeUI, failed, mActivity is null");
            return;
        }
        this.f18365Z = (RelativeLayout) activity.findViewById(R.id_renamed.camera);
        ViewGroup viewGroup = this.f18365Z;
        if (viewGroup == null) {
            return;
        }
        NightTimeView nightTimeView = this.f18345F;
        if (nightTimeView != null) {
            viewGroup.removeView(nightTimeView);
        }
        Resources resources = this.f18497i.getApplication().getResources();
        this.f18345F = (NightTimeView) LayoutInflater.from(this.f18497i).inflate(R.layout.night_mode_count_down_time_ui, (ViewGroup) null);
        this.f18345F.m22199a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.night_countdown_time_layout_width), resources.getDimensionPixelOffset(R.dimen.night_countdown_time_layout_height));
        layoutParams.topMargin = m19471eS();
        layoutParams.addRule(14);
        this.f18365Z.addView(this.f18345F, layoutParams);
        this.f18345F.bringToFront();
        this.f18345F.setVisibility(8);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18168b(long OplusGLSurfaceView_15) {
        if (this.f18346G == null) {
            m19473eU();
        }
        LongExposureTimeView longExposureTimeView = this.f18346G;
        if (longExposureTimeView != null) {
            longExposureTimeView.m22178a(OplusGLSurfaceView_15);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18195d(int OplusGLSurfaceView_13, boolean z) {
        LongExposureTimeView longExposureTimeView;
        CameraLog.m12954a("CameraUIManager", "setLongExposureCountDownUIVisible, visible: " + OplusGLSurfaceView_13 + ", needAnim: " + z);
        if (this.f18346G == null) {
            m19473eU();
        }
        if ((OplusGLSurfaceView_13 == 0 && m19875dS() && m19864dH()) || (longExposureTimeView = this.f18346G) == null) {
            return;
        }
        longExposureTimeView.m22177a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: eU */
    private void m19473eU() {
        this.f18365Z = (RelativeLayout) this.f18497i.findViewById(R.id_renamed.camera);
        ViewGroup viewGroup = this.f18365Z;
        if (viewGroup == null) {
            return;
        }
        LongExposureTimeView longExposureTimeView = this.f18346G;
        if (longExposureTimeView != null) {
            viewGroup.removeView(longExposureTimeView);
        }
        Resources resources = this.f18497i.getApplication().getResources();
        this.f18346G = (LongExposureTimeView) LayoutInflater.from(this.f18497i).inflate(R.layout.long_exposure_mode_count_down_time_ui, (ViewGroup) null);
        this.f18346G.m22176a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.night_countdown_time_layout_width), resources.getDimensionPixelOffset(R.dimen.night_countdown_time_layout_height));
        layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.night_countdown_time_text_margin_top);
        layoutParams.addRule(14);
        this.f18365Z.addView(this.f18346G, layoutParams);
        this.f18346G.bringToFront();
        this.f18346G.setVisibility(8);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: K */
    public void mo18042K(boolean z) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10846h(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aC */
    public void mo18113aC() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10805bv();
        }
    }

    /* renamed from: cg */
    public void m19830cg() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21528F();
        }
    }

    /* renamed from: ac */
    public void m19704ac(boolean z) {
        CameraLog.m12954a("CameraUIManager", "startVideoRecording");
        BlurMenu c3278c = this.f18384aS;
        if (c3278c != null && c3278c.isMenuOpen()) {
            this.f18384aS.hideMenu(false, false, false, true);
        }
        if (this.f18347H != null) {
            if (!m19755bO() && !mo19966j(CameraUIInterface.KEY_STICKER_PROCESS)) {
                if (1 == mo18134aX()) {
                    m19650a(0, 0.0f, this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.zoom_linkage_translate));
                } else {
                    m19650a(0, 0.0f, 0.0f);
                }
                this.f18347H.m21565c(0);
            } else {
                this.f18347H.mo21414d();
            }
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21414d();
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23313N();
            this.f18340A.m23399f(true);
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19193m(z);
        }
        mo18227i(mo19966j(CameraUIInterface.KEY_ASSISTANT_LINE));
        CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
        if (viewOnClickListenerC3199a2 != null) {
            viewOnClickListenerC3199a2.m19117ad();
        }
    }

    /* renamed from: ch */
    public void m19831ch() {
        CameraLog.m12954a("CameraUIManager", "beforeStopSlowVideoRecording");
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23046a(true);
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19180i(false, false);
        }
        if (this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB)) {
            mo18154ar();
        }
    }

    /* renamed from: ci */
    public void m19832ci() {
        CameraLog.m12954a("CameraUIManager", "afterStopSlowVideoRecording");
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21529G();
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21529G();
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23399f(false);
        }
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            c3278c.stopVideoRecording();
        }
        if (m19751bK()) {
            m19846cw();
        }
        mo18235k(true);
    }

    /* renamed from: x */
    public void m19987x(boolean z, boolean z2) {
        CameraLog.m12954a("CameraUIManager", "stopVideoRecording");
        m19708ag(false);
        m19709ah(false);
        m19812cO();
        CameraUIListener cameraUIListener = this.f18349J;
        boolean z3 = cameraUIListener != null && cameraUIListener.mo10847h();
        CameraUIListener cameraUIListener2 = this.f18349J;
        if (cameraUIListener2 != null && cameraUIListener2.mo10795bl() && !mo18224h()) {
            mo18240l(true, z3);
        }
        CameraUIListener cameraUIListener3 = this.f18349J;
        if (cameraUIListener3 != null && cameraUIListener3.mo10796bm() && !mo18224h()) {
            mo18228i(true, z3);
        }
        if (this.f18347H != null && (3 != this.f18350K || !mo18159aw() || 1 != mo19936ej().mo16539j())) {
            this.f18347H.m21529G();
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21529G();
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23399f(false);
        }
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23047a(!mo19966j(CameraUIInterface.KEY_STICKER_PROCESS), mo19881dY());
            this.f18343D.m23049b();
        }
        CameraUIListener cameraUIListener4 = this.f18349J;
        if (cameraUIListener4 != null && cameraUIListener4.mo10848h(CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB)) {
            CameraControlUI viewOnClickListenerC3199a = this.f18514z;
            if (viewOnClickListenerC3199a != null) {
                viewOnClickListenerC3199a.m19127an();
            }
            mo18154ar();
        }
        CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
        if (viewOnClickListenerC3199a2 != null) {
            viewOnClickListenerC3199a2.m19180i(z, z2);
        }
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            c3278c.stopVideoRecording();
        }
        if (m19751bK()) {
            m19846cw();
        }
        mo18227i(true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo18224h() {
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            return c3278c.isVideoRecordingHideMenu();
        }
        return false;
    }

    /* renamed from: cj */
    public void m19833cj() {
        if (this.f18502n) {
            return;
        }
        this.f18340A.m23304E();
    }

    /* renamed from: ck */
    public ImageView m19834ck() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g == null) {
            return null;
        }
        return viewOnLayoutChangeListenerC3444g.m23306G();
    }

    /* renamed from: cl */
    public void m19835cl() {
        CameraLog.m12954a("CameraUIManager", "hidePostCaptureAlert");
        this.f18503o = false;
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23426t();
        }
        mo18263r(true);
        mo18240l(true, false);
        if (this.f18349J.mo10796bm()) {
            mo18228i(true, false);
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21570d(0);
            this.f18347H.mo21407a(true, false);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21420m();
            this.f18348I.mo21407a(true, false);
        }
        if (this.f18514z != null) {
            if (Util.m24434d(this.f18352M)) {
                this.f18514z.m19142b(0, true);
            }
            this.f18514z.m19060I();
        }
        mo18068a(0, 1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19731b(Bitmap bitmap) {
        CameraLog.m12954a("CameraUIManager", "showPostCaptureAlert");
        this.f18503o = true;
        m19810cM();
        if (this.f18350K != 2) {
            return;
        }
        if (mo18023A()) {
            mo18267s(false);
        } else {
            mo18259q(false);
        }
        mo18232j(true, false);
        if (mo18051O()) {
            mo18176b(false, true, false, false);
        } else {
            mo18223h(true, false);
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21407a(false, true);
            if (Util.m24418c(this.f18352M)) {
                this.f18347H.m21570d(4);
            } else {
                this.f18347H.m21565c(4);
            }
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21407a(false, true);
        }
        mo18045L(false);
        mo18068a(4, 1);
        if (this.f18514z != null) {
            if (Util.m24434d(this.f18352M)) {
                this.f18514z.m19142b(4, true);
            }
            this.f18514z.m19059H();
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23335a(bitmap);
        }
        mo18108a(true, false, false);
        mo18138ab();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19793c(MainShutterButtonInfo c3200b, boolean z) {
        this.f18502n = false;
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19062K();
            this.f18514z.m19094a(c3200b, z, true);
            if (this.f18350K != 3 && !this.f18504p) {
                this.f18514z.m19106a(false);
            }
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21407a(true, false);
            this.f18347H.m21570d(0);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21407a(true, false);
        }
    }

    /* renamed from: cm */
    public void m19836cm() {
        CameraLog.m12954a("CameraUIManager", "hideVideoAlert");
        this.f18502n = false;
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23428v();
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19062K();
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21407a(true, false);
            this.f18347H.m21570d(0);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21407a(true, false);
            this.f18348I.m21570d(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19791c(Bitmap bitmap) {
        CameraLog.m12954a("CameraUIManager", "showVideoAlert");
        this.f18502n = true;
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23381b(bitmap);
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19061J();
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21407a(false, true);
            this.f18347H.m21570d(4);
            if (this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.third_video_preview_margin_top) > 0) {
                this.f18347H.m21572d(!Util.m24195W(), true);
            }
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21407a(false, true);
            this.f18348I.m21403a(4);
        }
        mo18108a(true, true, false);
    }

    /* renamed from: cn */
    public void m19837cn() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23308I();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m19957g(int OplusGLSurfaceView_13, int i2) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a == null || !viewOnClickListenerC3199a.m19116ac()) {
            return false;
        }
        this.f18514z.m19117ad();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m19738b(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        CameraLog.m12954a("CameraUIManager", "onSingleTapUp, x: " + OplusGLSurfaceView_13 + ", y: " + i2);
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null && c3358p.m22051e()) {
            return true;
        }
        ExpandableMenuPanel c3337q = this.f18376aK;
        if (c3337q != null && c3337q.onSingleTapUp(OplusGLSurfaceView_13, i2)) {
            return true;
        }
        if (mo18111aA()) {
            mo18041J(true);
            return true;
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null && viewOnClickListenerC3261g.m20689n()) {
            mo18109a(true, true, true, true);
            return true;
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            if (c3326f.m21408a(OplusGLSurfaceView_15)) {
                return true;
            }
            CameraLog.m12954a("CameraUIManager", "onSingleTapUp, isDrawerAnimationRun: " + this.f18348I.m21423p() + ", isSubSettingMenuOpen: " + this.f18348I.mo21419j());
            if (this.f18348I.mo21419j() || this.f18348I.m21423p()) {
                if (!this.f18348I.m21423p()) {
                    this.f18341B.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
                    mo18211f(CameraUIInterface.KEY_SUB_SETTING);
                }
                return true;
            }
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a == null || !viewOnClickListenerC3199a.m19116ac()) {
            return false;
        }
        this.f18514z.m19117ad();
        return true;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: o */
    public void mo18249o() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23301A();
        }
    }

    /* renamed from: co */
    public void m19838co() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23302B();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: cp */
    public boolean mo19839cp() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10648B();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: cq */
    public void mo19840cq() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10865m();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: cr */
    public void mo19841cr() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g == null || !c3282g.isEffectMenuOpen() || !this.f18349J.mo10848h(CameraUIInterface.KEY_FILTER_PROCESS) || this.f18349J.mo10814c() || this.f18503o) {
            return;
        }
        this.f18399ah.m20889g();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: cs */
    public void mo19842cs() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10650D();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ct */
    public void mo19843ct() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10651E();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: cu */
    public int mo19844cu() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10652F();
        }
        return 0;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: cv */
    public int mo19845cv() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10653G();
        }
        return 0;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo19966j(String str) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10848h(str);
        }
        return false;
    }

    /* renamed from: cw */
    public void m19846cw() {
        if (PopUpWindowManager.m20706a()) {
            PopUpWindowManager.m20712d();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: L */
    public void mo18045L(boolean z) {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21412c(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m19968k(String str) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            return c3335o.m21569c(str);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18099a(String str, String str2) {
        String strM13299b = CameraEntry.m13299b(str, this.f18350K);
        if (PopUpWindowManager.m20706a()) {
            PopUpWindowManager.m20712d();
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21544a(strM13299b, str2);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21544a(strM13299b, str2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18171b(String str, String str2) {
        String strM13299b = CameraEntry.m13299b(str, this.f18350K);
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21558b(strM13299b, str2);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21558b(strM13299b, str2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18103a(String str, String... strArr) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21551a(str, strArr);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21551a(str, strArr);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18173b(String str, String... strArr) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21560b(str, strArr);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21560b(str, strArr);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18196d(String str) {
        String strM13299b = CameraEntry.m13299b(str, this.f18350K);
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21571d(strM13299b);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21571d(strM13299b);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo18204e(String str) {
        String strM13299b = CameraEntry.m13299b(str, this.f18350K);
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21574e(strM13299b);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21574e(strM13299b);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo18211f(String str) {
        String strM13299b = CameraEntry.m13299b(str, this.f18350K);
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21577f(strM13299b);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21577f(strM13299b);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18170b(String str, int OplusGLSurfaceView_13) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21557b(str, OplusGLSurfaceView_13);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21557b(str, OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: q */
    public void mo18258q() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21425r();
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21425r();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19789c(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        CameraLog.m12952a("entryCameraUpdateSettingMenu");
        boolean z3 = false;
        if (this.f18347H != null) {
            if (mo19881dY()) {
                this.f18347H.m21554b(0.0f);
            }
            this.f18347H.m21556b(OplusGLSurfaceView_13, z2, (this.f18502n || z || (this.f18385aT.m20689n() && 1 == mo18134aX())) ? false : true, mo18057R());
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            if (!this.f18502n && !z) {
                z3 = true;
            }
            c3326f.m21556b(OplusGLSurfaceView_13, z2, z3, mo18057R());
        }
        CameraLog.m12958b("entryCameraUpdateSettingMenu");
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: V */
    public void mo18061V() {
        this.f18349J.mo10676a();
    }

    /* renamed from: cx */
    public void m19847cx() {
        this.f18400ai.hideMenu(true, true, false, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m19697a(MotionEvent motionEvent) {
        CameraDrawerSettingUI c3326f;
        if (m19862dF() || m19484f(motionEvent)) {
            return true;
        }
        if (!this.f18349J.mo10799bp() && !this.f18349J.mo10657K() && !mo19900dr()) {
            if (mo18043K() && !Util.m24294a(m19744bD(), motionEvent.getX(), motionEvent.getY()) && !m19492fH() && !mo19916eD()) {
                CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
                return viewOnLayoutChangeListenerC3444g != null && viewOnLayoutChangeListenerC3444g.m23360a(motionEvent);
            }
            if (this.f18348I != null && mo18059T() && !Util.m24294a(this.f18348I.m21524B(), motionEvent.getX(), motionEvent.getY()) && 1 == this.f18349J.mo10816ca()) {
                mo18060U();
            } else if (mo18051O()) {
                HintManager c3130a = this.f18394ac;
                if (c3130a != null) {
                    c3130a.m18488a(true);
                    this.f18394ac.m18492b(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
                }
                HintManager c3130a2 = this.f18394ac;
                if (c3130a2 != null) {
                    c3130a2.m18488a(false);
                    this.f18394ac.m18492b((String) null);
                }
            } else if (!m19942ep() && !this.f18349J.mo10658L() && !this.f18349J.mo10660N() && !this.f18349J.mo10661O() && mo19929ec() && mo19966j(CameraUIInterface.KEY_SUB_SETTING) && 1 != this.f18349J.mo10816ca() && this.f18348I.m21409a(motionEvent)) {
                return true;
            }
        } else if (this.f18349J.mo10799bp() && (c3326f = this.f18348I) != null && c3326f.m21413c()) {
            this.f18348I.m21415d(false);
            this.f18348I.m21403a(8);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g2 = this.f18340A;
        return viewOnLayoutChangeListenerC3444g2 != null && viewOnLayoutChangeListenerC3444g2.m23360a(motionEvent);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m19484f(MotionEvent motionEvent) {
        ComboPreferences comboPreferences;
        CameraPreviewUI viewOnLayoutChangeListenerC3444g;
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || !ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(cameraUIListener.mo10736ao()) || (comboPreferences = this.f18341B) == null || comboPreferences.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0) == 0 || (viewOnLayoutChangeListenerC3444g = this.f18340A) == null || viewOnLayoutChangeListenerC3444g.m23430x() == null) {
            return false;
        }
        boolean zM13882a = MultiVideoSmallSurfaceTouchEventHelper.m13880a().m13882a(motionEvent, this.f18340A.m23430x());
        if (zM13882a) {
            if (mo18111aA()) {
                CameraLog.m12959b("CameraUIManager", "touchMultiVideoSmallSurface, consumed by MultiVideoSmallSurface");
                mo18041J(true);
            }
            if (this.f18349J.mo10799bp()) {
                this.f18349J.mo10798bo();
            }
            if (1 == motionEvent.getAction()) {
                this.f18349J.mo10875q(FocusAimMsgData.KEY_MULTI_VIDEO_DRAG_SCREEN_FOCUS_TYPE);
            }
        }
        return zM13882a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m19740b(MotionEvent motionEvent) {
        if (this.f18348I == null || !mo18059T()) {
            return false;
        }
        return this.f18348I.m21563b(motionEvent);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: t */
    public void mo18269t() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23319T();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18083a(DialogInterface.OnCancelListener onCancelListener) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23333a(onCancelListener);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: y */
    public String mo18285y() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        return viewOnLayoutChangeListenerC3444g != null ? viewOnLayoutChangeListenerC3444g.m23315P() : "";
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo18222h(boolean z) throws Resources.NotFoundException {
        if (this.f18340A != null) {
            CommonBottomGuide c2785a = this.f18450bg;
            this.f18340A.m23384b(z, c2785a == null || !c2785a.m14461d());
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18165b(int OplusGLSurfaceView_13, int i2) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23329a(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m19958h(int OplusGLSurfaceView_13, int i2) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23380b(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18095a(OplusViewOutlineProvider c3464q) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23353a(c3464q);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public GLRootView mo18066a() {
        return this.f18340A.m23314O();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public ViewGroup mo18163b() {
        return this.f18365Z;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18078a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23331a(OplusGLSurfaceView_13, z, z2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo18206e(boolean z, boolean z2) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23357a(z, z2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18188c(String str, int OplusGLSurfaceView_13) {
        this.f18399ah.m20876b(OplusGLSurfaceView_13);
        if (mo19966j(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            mo18216g(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU);
            return;
        }
        if (mo19966j(CameraUIInterface.KEY_FILTER_MENU)) {
            mo18216g(CameraUIInterface.KEY_FILTER_MENU);
            return;
        }
        if (mo19966j(CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            mo18216g(CameraUIInterface.KEY_VIDEO_FILTER_MENU);
        } else if (mo19966j(CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            mo18216g(CameraUIInterface.KEY_NIGHT_FILTER_MENU);
        } else if (mo19966j(CameraUIInterface.KEY_STREET_FILTER_MENU)) {
            mo18216g(CameraUIInterface.KEY_STREET_FILTER_MENU);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18101a(String str, boolean z) {
        this.f18347H.m21567c(str, z);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo18230j(int OplusGLSurfaceView_13) {
        m19517fg();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: z */
    public void mo18287z() {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20699x();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: am */
    public int mo18149am() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            return c3335o.m21538P();
        }
        return 0;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: an */
    public int mo18150an() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19069S();
        }
        return 0;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aU */
    public boolean mo18131aU() {
        AISceneUI abstractC3391a = this.f18373aH;
        return abstractC3391a != null && abstractC3391a.mo22232i();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aV */
    public String mo18132aV() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10736ao();
        }
        return null;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aW */
    public boolean mo18133aW() {
        return mo18183c() != null && mo18183c().m23491v();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: bc */
    public int mo18180bc() {
        BaseScreenMode abstractC2934a = this.f18467bx;
        if (abstractC2934a != null) {
            return abstractC2934a.mo16572m();
        }
        return -1;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: w */
    public void mo18281w(int OplusGLSurfaceView_13) {
        this.f18359T = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ao */
    public Uri mo18151ao() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19210t().m19291e();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m19797c(boolean z, boolean z2, boolean z3) {
        if (m19864dH()) {
            return false;
        }
        if (z3 && !z && !z2) {
            CameraLog.m12962c("CameraUIManager", "showAEAFLockView, wait for AF lock, no prompts will be displayed temporarily.");
            return false;
        }
        m19815cR();
        this.f18394ac.m18495c(m19476eX());
        this.f18394ac.m18476a((!z3 || z2) ? R.string.camera_toast_lock_ae : R.string.camera_toast_lock_ae_af, false, true, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, this.f18359T, mo19881dY());
        m19405aF(false);
        return true;
    }

    /* renamed from: cy */
    public void m19848cy() {
        mo18067a(R.string.camera_toast_lock_ae);
        mo18067a(R.string.camera_toast_lock_ae_af);
    }

    /* renamed from: cz */
    public void m19849cz() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23422q();
        }
    }

    /* renamed from: cA */
    public void m19798cA() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23424r();
        }
    }

    /* renamed from: cB */
    public void m19799cB() throws Resources.NotFoundException {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23316Q();
        }
        if (Util.m24487p()) {
            Util.m24254a(this.f18497i, R.string.camera_camera_error_title);
        }
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14459c(this.f18497i);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19663a(SharedPreferences sharedPreferences, String str) {
        ComboPreferences comboPreferences;
        CameraUIListener cameraUIListener;
        if (this.f18504p) {
            return;
        }
        if (CameraUIInterface.KEY_TORCH_MODE.equals(str)) {
            String string = sharedPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.f18497i));
            if ("off".equals(string)) {
                m19808cK();
            } else {
                CameraUIListener cameraUIListener2 = this.f18349J;
                if (cameraUIListener2 != null && !cameraUIListener2.mo10848h(CameraFunction.TORCH_SOFT_LIGHT)) {
                    m19807cJ();
                }
            }
            if ("off".equals(string)) {
                InverseManager.INS.setInverseColor((Context) this.f18497i, false, true);
                mo18106a(mo18023A(), this.f18349J.mo10700aE());
                mo18287z();
                return;
            } else {
                if (!"on".equals(string) || (cameraUIListener = this.f18349J) == null || cameraUIListener.mo10848h(CameraFunction.TORCH_SOFT_LIGHT)) {
                    return;
                }
                InverseManager.INS.setInverseColor((Context) this.f18497i, true, true);
                mo18106a(mo18023A(), this.f18349J.mo10700aE());
                mo18287z();
                return;
            }
        }
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str) && !sharedPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, "off").equals("off") && sharedPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, "off").equals("on")) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            mo18171b(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
        if (!"pref_allow_network_access".equals(str) || (comboPreferences = this.f18341B) == null || this.f18342C == null || !comboPreferences.getBoolean("pref_allow_network_access", false)) {
            return;
        }
        this.f18342C.m16726a();
        FeedbackUtils.m14508a(MyApplication.m11092d());
    }

    /* renamed from: cC */
    public void m19800cC() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19063M();
        }
    }

    /* renamed from: cD */
    public void m19801cD() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19064N();
        }
    }

    /* renamed from: cE */
    public void m19802cE() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19065O();
        }
    }

    /* renamed from: cF */
    public boolean m19803cF() throws IllegalStateException {
        ExpandableMenuPanel c3337q;
        CommonBottomGuide c2785a;
        this.f18505q = true;
        this.f18360U = 0L;
        OutCaptureManager c2929b = this.f18499k;
        if (c2929b != null && c2929b.m16438f()) {
            this.f18499k.m16433b();
            return true;
        }
        if (this.f18368aC != null) {
            mo18210f(18, true);
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null && viewOnClickListenerC3261g.m20689n()) {
            mo18109a(true, true, true, true);
            return true;
        }
        CameraSettingUI c3335o = this.f18347H;
        if ((c3335o != null && c3335o.m21526D()) || (((c3337q = this.f18376aK) != null && c3337q.onBackPressed()) || ((c2785a = this.f18450bg) != null && c2785a.m14460c()))) {
            return true;
        }
        if (mo18057R()) {
            m19437aj(-1);
            return true;
        }
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g != null && c2688g.m12950o()) {
            mo19914eB();
            return true;
        }
        TimeLapseProGuideLayout c3070f = this.f18434bQ;
        if (c3070f == null || !c3070f.isShown()) {
            return false;
        }
        this.f18434bQ.m17634b();
        m19699aA(true);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19662a(int OplusGLSurfaceView_13, Object... objArr) {
        if (this.f18508t) {
            return;
        }
        mo18074a(OplusGLSurfaceView_13, 3000, objArr);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18074a(final int OplusGLSurfaceView_13, final int i2, final Object... objArr) {
        Activity activity;
        if (this.f18348I.mo21419j() || mo18057R() || (activity = this.f18497i) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.18
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.m19815cR();
                CameraUIManager.this.f18394ac.m18479a(OplusGLSurfaceView_13, false, true, i2, CameraUIManager.this.f18359T, false, CameraUIManager.this.mo19966j(CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, objArr);
            }
        });
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18069a(final int OplusGLSurfaceView_13, final int i2, final int i3, final Object... objArr) {
        Activity activity;
        if (this.f18348I.mo21419j() || mo18057R() || (activity = this.f18497i) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.19
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.m19815cR();
                CameraUIManager.this.f18394ac.m18478a(OplusGLSurfaceView_13, false, true, i2, CameraUIManager.this.f18359T, false, CameraUIManager.this.mo19966j(CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, i3, objArr);
            }
        });
    }

    /* renamed from: cG */
    public void m19804cG() {
        Activity activity;
        if (this.f18348I.mo21419j() || (activity = this.f18497i) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.20
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.m19815cR();
                CameraUIManager.this.f18394ac.m18475a(R.string.camera_toast_unfold_palm_shutter, false, true, 5000, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, 0, false, false, true, -1, null);
            }
        });
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18090a(MicroscopeHintView.InterfaceC3097a interfaceC3097a, boolean z, int OplusGLSurfaceView_13) {
        if (this.f18405an == null && this.f18365Z != null) {
            this.f18405an = (MicroscopeHintView) this.f18497i.getLayoutInflater().inflate(R.layout.microscope_hint, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = Util.m24184L() + Util.m24186N() + this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.microscope_guide_anim_margin_top) + this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.toast_margin_top_text) + OplusGLSurfaceView_13;
            layoutParams.addRule(14);
            this.f18365Z.addView(this.f18405an, layoutParams);
        }
        MicroscopeHintView microscopeHintView = this.f18405an;
        if (microscopeHintView != null) {
            if (z) {
                microscopeHintView.m18303a(interfaceC3097a, this, this.f18341B);
                mo18148al();
            } else {
                microscopeHintView.m18302a();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aQ */
    public boolean mo18127aQ() {
        MicroscopeHintView microscopeHintView = this.f18405an;
        if (microscopeHintView != null) {
            return microscopeHintView.m18304b();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18085a(View.OnClickListener onClickListener, boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f18408aq == null && this.f18365Z != null) {
            this.f18408aq = new RotateImageView(this.f18497i);
            this.f18408aq.setImageResource(R.drawable.professional_guide_tip);
            this.f18365Z.addView(this.f18408aq);
        }
        if (this.f18408aq != null) {
            int dimensionPixelSize = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_size);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.microscope_guide_entry_margin_right);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            if (z2) {
                layoutParams.topMargin = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.microscope_guide_entry_margin_capture_mode_top);
            } else {
                layoutParams.topMargin = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.microscope_guide_entry_margin_video_mode_top);
            }
            this.f18408aq.setLayoutParams(layoutParams);
            this.f18408aq.setOnClickListener(onClickListener);
            if (z) {
                Util.m24270a(this.f18408aq, 0, (Animation.AnimationListener) null, 500L);
            } else {
                Util.m24270a(this.f18408aq, 8, (Animation.AnimationListener) null, 180L);
            }
        }
    }

    /* renamed from: cH */
    public boolean m19805cH() {
        CameraScreenHintView cameraScreenHintView = this.f18404am;
        return cameraScreenHintView != null && cameraScreenHintView.isShown();
    }

    /* renamed from: ad */
    public void m19705ad(boolean z) {
        long jCurrentTimeMillis = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        if (!z || DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS > System.currentTimeMillis() - this.f18363X) {
            if (this.f18404am == null && this.f18365Z != null) {
                this.f18404am = (CameraScreenHintView) this.f18497i.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
                View view = this.f18403al;
                if (view != null) {
                    ViewGroup viewGroup = this.f18365Z;
                    viewGroup.addView(this.f18404am, viewGroup.indexOfChild(view));
                } else {
                    this.f18365Z.addView(this.f18404am);
                }
            }
            final String string = this.f18341B.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.f18497i.getString(R.string.camera_photo_ratio_default_value));
            final CameraScreenHintView cameraScreenHintView = this.f18396ae;
            if (cameraScreenHintView != null) {
                cameraScreenHintView.getHintTextView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.21
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() throws Resources.NotFoundException {
                        int dimensionPixelSize;
                        CameraScreenHintView cameraScreenHintView2 = cameraScreenHintView;
                        if (cameraScreenHintView2 != null) {
                            cameraScreenHintView2.getHintTextView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int iM24185M = 0;
                            if (!"square".equals(string)) {
                                if (CameraUIManager.this.f18404am != null) {
                                    boolean z2 = true;
                                    if (CameraUIManager.this.f18467bx == null || 1 != CameraUIManager.this.f18467bx.mo16539j()) {
                                        if (CameraUIManager.this.f18467bx != null && 4 == CameraUIManager.this.f18467bx.mo16539j() && CameraUIManager.this.f18467bx.mo16630q()) {
                                            iM24185M = Util.m24185M() + cameraScreenHintView.getIconWidth();
                                            dimensionPixelSize = CameraUIManager.this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.low_rack_mode_camera_screen_hint_view_margin_bottom) - iM24185M;
                                        } else {
                                            dimensionPixelSize = 0;
                                            z2 = false;
                                        }
                                    } else {
                                        z2 = false;
                                        iM24185M = CameraUIManager.this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.fold_full_gesture_hint_view_margin_top_offset);
                                        dimensionPixelSize = 0;
                                    }
                                    CameraUIManager.this.f18404am.m18802a(cameraScreenHintView.getHintTextView().getHeight() + Util.m24185M() + iM24185M, dimensionPixelSize, cameraScreenHintView.getHintTextView().getHeight() + cameraScreenHintView.getMarginLeft(), z2);
                                    return;
                                }
                                return;
                            }
                            int iM24185M2 = Util.m24185M();
                            if (CameraUIManager.this.f18404am != null) {
                                CameraUIManager.this.f18404am.m18802a(cameraScreenHintView.getHintTextView().getHeight() + CameraUIManager.this.m19760bT() + iM24185M2, 0, cameraScreenHintView.getHintTextView().getHeight() + cameraScreenHintView.getMarginLeft(), false);
                            }
                        }
                    }
                });
            }
            CameraScreenHintView cameraScreenHintView2 = this.f18404am;
            if (cameraScreenHintView2 != null) {
                cameraScreenHintView2.m18805a(this.f18467bx, this.f18351L);
                this.f18404am.setCameraScreenHintInterface(this.f18481ck);
                if (DcsMsgData.FULL.equals(string) || "16_9".equals(string)) {
                    this.f18404am.setIsGestureHintNeedInverse(true);
                }
                if (z) {
                    jCurrentTimeMillis = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS - (System.currentTimeMillis() - this.f18363X);
                } else {
                    this.f18363X = System.currentTimeMillis();
                }
                this.f18404am.m18803a(R.drawable.gesture_hint_selector, false, true, (int) jCurrentTimeMillis, false, this.f18359T);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18174b(boolean z) {
        CameraScreenHintView cameraScreenHintView = this.f18404am;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.m18808a(z);
        }
    }

    /* renamed from: ae */
    public void m19706ae(boolean z) {
        if (!z) {
            mo18107a(false, false);
        }
        mo18175b(false, false);
        mo18213f(false, false);
        mo18190c(false);
        mo18279v(false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18187c(String str) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19145b(str);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18091a(MainShutterButtonInfo c3200b) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19143b(c3200b);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18092a(final MainShutterButtonInfo c3200b, final boolean z) {
        Activity activity = this.f18497i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.23
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraUIManager.this.f18514z != null) {
                        CameraUIManager.this.f18514z.m19094a(c3200b, z, !CameraUIManager.this.m19864dH());
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18077a(int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 == 0) {
            if (this.f18443bZ) {
                m19736b(z, 1);
                this.f18443bZ = false;
                return;
            } else {
                m19736b(z, 0);
                return;
            }
        }
        m19794c(z, 0);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo18229j() {
        ModePanelUIControl c3355m = this.f18375aJ;
        if (c3355m != null) {
            c3355m.m21954c();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18097a(String str) throws Resources.NotFoundException {
        ModePanelUIControl c3355m = this.f18375aJ;
        if (c3355m != null) {
            c3355m.m21947a(str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19669a(Size size, Size size2, CameraPreviewUI.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23340a(size, size2, aVar, OplusGLSurfaceView_13, i2, i3, z);
        }
    }

    /* renamed from: G */
    public void m19623G(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19188l(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19647a(byte b2, boolean z) {
        if (this.f18514z != null) {
            if (mo19881dY() || mo19880dX()) {
                b2 = 2;
            } else if (Util.m24352ao()) {
                b2 = 1;
            }
            this.f18514z.m19077a(b2, z);
        }
    }

    /* renamed from: y */
    public void m19990y(boolean z, boolean z2) {
        if (this.f18514z != null) {
            this.f18347H.m21572d(z, z2);
        }
    }

    /* renamed from: af */
    public void m19707af(boolean z) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21583h(z);
        }
    }

    /* renamed from: cI */
    public void m19806cI() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23320U();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18068a(int OplusGLSurfaceView_13, int i2) {
        if ((this.f18503o || this.f18502n) && OplusGLSurfaceView_13 == 0) {
            return;
        }
        m19389a(OplusGLSurfaceView_13, false, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19389a(int OplusGLSurfaceView_13, boolean z, int i2) throws Resources.NotFoundException {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a == null || this.f18504p) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            this.f18514z.m19085a(i2, z, ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(this.f18341B.getString(CameraUIInterface.KEY_CAMERA_MODE, "")) && (this.f18349J.mo10734am() || this.f18349J.mo10729ah()));
        } else {
            viewOnClickListenerC3199a.m19084a(i2, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19658a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener) {
        m19659a(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2, timeInterpolator, animatorListener, 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19659a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, int i2) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19080a(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2, timeInterpolator, animatorListener, i2);
        }
    }

    /* renamed from: cJ */
    public void m19807cJ() {
        if (this.f18365Z != null && this.f18403al == null) {
            this.f18497i.getLayoutInflater().inflate(R.layout.screen_torch, this.f18365Z);
            this.f18403al = this.f18497i.findViewById(R.id_renamed.screen_torch);
            this.f18403al.setForceDarkAllowed(false);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREENHOLE)) {
                ScreenHoleView screenHoleView = (ScreenHoleView) this.f18497i.findViewById(R.id_renamed.screen_hole_view);
                Rect rectM24448f = Util.m24448f(Util.m24363az());
                if (rectM24448f != null) {
                    CameraLog.m12959b("CameraUIManager", "addScreenTorchView, show screen hole view");
                    screenHoleView.setHolePosition(rectM24448f);
                    screenHoleView.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: cK */
    public void m19808cK() {
        if (this.f18365Z == null || this.f18403al == null) {
            return;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREENHOLE)) {
            ScreenHoleView screenHoleView = (ScreenHoleView) this.f18497i.findViewById(R.id_renamed.screen_hole_view);
            if (screenHoleView.getVisibility() == 0) {
                CameraLog.m12959b("CameraUIManager", "addScreenTorchView, hide screen hole view");
                screenHoleView.setVisibility(8);
            }
        }
        this.f18365Z.removeView(this.f18403al);
        this.f18403al = null;
    }

    /* renamed from: cL */
    public void m19809cL() {
        CameraLog.m12954a("CameraUIManager", "startScreenTorch, mScreenTorchView: " + this.f18403al);
        m19807cJ();
        if (this.f18403al != null) {
            int configColorValue = CameraConfig.getConfigColorValue(ConfigDataBase.KEY_FRONT_TORCH_COLOR);
            if (-1 == configColorValue) {
                configColorValue = Color.parseColor("#FFC8C8C8");
            }
            if (this.f18349J.mo10721aZ()) {
                this.f18365Z.removeView(this.f18403al);
            }
            this.f18403al.setBackgroundColor(configColorValue);
            this.f18403al.setVisibility(0);
            CameraControlUI viewOnClickListenerC3199a = this.f18514z;
            if (viewOnClickListenerC3199a != null) {
                viewOnClickListenerC3199a.m19119af();
            }
        }
        m19988y(0);
        mo18176b(false, false, false, false);
    }

    /* renamed from: cM */
    public void m19810cM() {
        CameraUIListener cameraUIListener;
        CameraLog.m12954a("CameraUIManager", "stopScreenTorch");
        View view = this.f18403al;
        if (view != null && view.getVisibility() != 8) {
            this.f18403al.setVisibility(8);
            if (this.f18349J.mo10721aZ()) {
                this.f18365Z.removeView(this.f18403al);
                this.f18365Z.addView(this.f18403al);
            }
        }
        if (this.f18514z == null || (cameraUIListener = this.f18349J) == null || !cameraUIListener.mo10848h(CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB) || this.f18349J.mo10808by()) {
            return;
        }
        this.f18514z.m19120ag();
        this.f18514z.m19121ah();
    }

    /* renamed from: cN */
    public boolean m19811cN() {
        View view = this.f18403al;
        if (view != null) {
            return view.isShown();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18070a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3) {
        if (this.f18508t) {
            return;
        }
        m19652a(OplusGLSurfaceView_13, i2, this.f18359T, z, z2, z3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19652a(int OplusGLSurfaceView_13, int i2, int i3, boolean z, boolean z2, boolean z3) {
        if (this.f18508t) {
            return;
        }
        m19654a(OplusGLSurfaceView_13, i2, i3, z, z2, z3, false, mo19966j(CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, 3000, true, 0);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18071a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, int i3) {
        m19653a(OplusGLSurfaceView_13, i2, this.f18359T, z, z2, z3, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19653a(int OplusGLSurfaceView_13, int i2, int i3, boolean z, boolean z2, boolean z3, int i4) {
        m19654a(OplusGLSurfaceView_13, i2, i3, z, z2, z3, false, mo19966j(CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), false, 3000, true, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19657a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        m19654a(OplusGLSurfaceView_13, i2, this.f18359T, z, z2, z3, false, mo19966j(CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, 3000, z4, 0);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18072a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        m19654a(OplusGLSurfaceView_13, i2, this.f18359T, z, z2, z3, z4, mo19966j(CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), z5, 3000, true, 0);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18073a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, boolean z7) {
        m19654a(OplusGLSurfaceView_13, i2, this.f18359T, z, z2, z3, z4, z5, z6, i3, z7, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19654a(final int OplusGLSurfaceView_13, final int i2, final int i3, final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5, boolean z6, final int i4, final boolean z7, final int i5) {
        Activity activity;
        if (OplusGLSurfaceView_13 > 0 && (activity = this.f18497i) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.24
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraUIManager.this.m19369W(OplusGLSurfaceView_13)) {
                        return;
                    }
                    CameraUIManager.this.m19815cR();
                    CameraUIManager.this.f18464bu = i4;
                    if (i5 > 0) {
                        CameraUIManager.this.f18394ac.m18474a(OplusGLSurfaceView_13, z3, z, i4, i5, R.color.color_black_with_full_percent_transparency, i3, z4, z5, z7);
                    } else {
                        CameraUIManager.this.f18394ac.m18479a(OplusGLSurfaceView_13, z3, z, i4, i3, z4, z5, z7, new Object[0]);
                    }
                }
            });
        }
        if (i2 <= 0 || this.f18497i == null) {
            return;
        }
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a == null || !abstractC3391a.mo22232i()) {
            this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.25
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraUIManager.this.m19474eV()) {
                        if (CameraUIManager.this.f18373aH != null) {
                            CameraUIManager c3208d = CameraUIManager.this;
                            if (c3208d.m19634R(c3208d.f18373aH.mo22226f())) {
                                return;
                            }
                        }
                        CameraUIManager.this.m19815cR();
                        CameraUIManager.this.f18394ac.m18480a(i2, z2, false, 0, z5, i3);
                        CameraUIManager.this.m19405aF(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public boolean m19369W(int OplusGLSurfaceView_13) {
        return !m19474eV() || !(!mo18131aU() || R.string.camera_pi_ai_scenes_hint_off == OplusGLSurfaceView_13 || R.string.camera_ai_scn_microspur == OplusGLSurfaceView_13 || R.string.camera_high_temperature_flash_disable == OplusGLSurfaceView_13 || R.string.camera_stop_video_recording_hint == OplusGLSurfaceView_13 || R.string.camera_high_temperature_video_record_disable == OplusGLSurfaceView_13 || R.string.explorer_chip_damage_tip == OplusGLSurfaceView_13) || (R.string.camera_scene_tripod_night_fixed_phone_tips == OplusGLSurfaceView_13 && !mo19966j(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eV */
    public boolean m19474eV() {
        boolean zMo18059T = mo18059T();
        boolean zM19941eo = m19941eo();
        boolean zM19512fb = m19512fb();
        boolean zMo18057R = mo18057R();
        boolean zMo18058S = mo18058S();
        CameraLog.m12959b("CameraUIManager", "showCameraScreenHintView, mbPaused: " + this.f18504p + ", isSubMenuShowing: " + zMo18059T + ", isDrawerSettingGuideAniRunning: " + zM19941eo + ", isMoreModeShown: " + zMo18057R + ", isMoreModePanelEnterAnimRunning: " + zMo18058S + ", shouldShowDrawerSettingGuideAni: " + zM19512fb);
        return (this.f18504p || zMo18059T || zM19941eo || zMo18057R || zMo18058S || zM19512fb) ? false : true;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_14 */
    public String mo18237l() {
        HintManager c3130a = this.f18394ac;
        return c3130a != null ? c3130a.m18505j() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aF */
    public void m19405aF(boolean z) {
        VideoRecordingTimeUI c3434ae;
        CameraUIListener cameraUIListener = this.f18349J;
        if ((cameraUIListener == null || cameraUIListener.mo10754b()) && (c3434ae = this.f18343D) != null && c3434ae.m23062k()) {
            this.f18343D.m23053c(mo19881dY());
        }
    }

    /* renamed from: cP */
    public void m19813cP() {
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14460c();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18108a(boolean z, boolean z2, final boolean z3) {
        Activity activity;
        Activity activity2;
        if (z && (activity2 = this.f18497i) != null) {
            activity2.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.26
                @Override // java.lang.Runnable
                public void run() {
                    CameraUIManager.this.f18394ac.m18496c(z3);
                    CameraUIManager.this.m19405aF(true);
                }
            });
        }
        if (!z2 || (activity = this.f18497i) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.27
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.f18394ac.m18493b(z3);
                CameraUIManager.this.m19405aF(true);
            }
        });
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18067a(int OplusGLSurfaceView_13) {
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18489a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: cQ */
    public void m19814cQ() {
        mo18067a(R.string.camera_dark_environment_open_flash_toast);
        mo18067a(R.string.camera_ai_video_low_ambient_light_hint);
        mo18067a(R.string.camera_ai_video_back_light_hint);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18104a(final List<Integer> list, final long OplusGLSurfaceView_15) {
        Activity activity;
        if (this.f18348I.mo21419j() || list == null || list.isEmpty() || (activity = this.f18497i) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.28
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.m19815cR();
                CameraUIManager.this.f18394ac.m18487a(list, OplusGLSurfaceView_15);
            }
        });
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo18245n() {
        this.f18394ac.m18472a();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18110a(int... iArr) {
        this.f18394ac.m18489a(iArr);
    }

    /* renamed from: cR */
    public void m19815cR() {
        if (this.f18365Z == null || this.f18373aH == null) {
            return;
        }
        if (m19864dH() && !m19871dO()) {
            m19410aK(true);
        }
        this.f18394ac.m18495c(m19476eX());
    }

    /* renamed from: eW */
    private int m19475eW() {
        if (this.f18497i == null || !mo19881dY()) {
            return 0;
        }
        return this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.movie_time_view_horizontal_margin) + (((int) ((1.0f - mo19927ea() > 0.0f ? 1.0f - mo19927ea() : 0.0f) * Util.getScreenWidth())) / 2);
    }

    /* renamed from: eX */
    private int m19476eX() {
        BaseScreenMode abstractC2934a;
        if (this.f18497i == null) {
            return 0;
        }
        int OplusGLSurfaceView_13 = this.f18351L;
        MicroscopeHintView microscopeHintView = this.f18405an;
        boolean z = microscopeHintView != null && microscopeHintView.m18304b();
        boolean z2 = mo19881dY() || mo19880dX();
        boolean z3 = mo19881dY() && (abstractC2934a = this.f18467bx) != null && abstractC2934a.mo16631r();
        if (z || z3) {
            return 0;
        }
        if (z2) {
            return 270;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: eY */
    private void m19477eY() {
        if (this.f18365Z == null) {
            return;
        }
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18501f();
        }
        CameraScreenHintView cameraScreenHintView = this.f18404am;
        if (cameraScreenHintView != null) {
            this.f18365Z.removeView(cameraScreenHintView);
            this.f18404am = null;
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo18234k(int OplusGLSurfaceView_13) {
        m19478eZ();
        this.f18450bg.m14455a(this.f18497i, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo18203e(int OplusGLSurfaceView_13, boolean z) {
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14453a(OplusGLSurfaceView_13, z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: D */
    public void mo18028D() {
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14452a();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: at */
    public void mo18156at() {
        m19478eZ();
        this.f18450bg.m14454a(this.f18497i);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: au */
    public void mo18157au() {
        m19478eZ();
        this.f18450bg.m14458b(this.f18497i);
    }

    /* renamed from: eZ */
    private void m19478eZ() {
        if (this.f18450bg == null) {
            this.f18450bg = new CommonBottomGuide(this.f18341B, new COUIBasePopupWindow.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.29
                @Override // com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6984a() throws Resources.NotFoundException {
                    if (CameraUIManager.this.f18340A == null || CameraUIManager.this.f18341B.getBoolean(CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_FOCUS_FIRST_HINTS, false) || !CameraUIManager.this.f18349J.mo10822cg()) {
                        return;
                    }
                    CameraUIManager.this.f18340A.m23384b(true, false);
                }
            }, this.f18349J);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18086a(View view, int OplusGLSurfaceView_13, int i2, int i3) {
        float COUIBaseListPopupWindow_12;
        Rect rect;
        int i4;
        int iM19377a;
        String str;
        Activity activity;
        CameraLog.m12954a("CameraUIManager", "showBubble type: " + OplusGLSurfaceView_13 + " offsetX: " + i2 + " offsetY: " + i3);
        if (this.f18365Z == null) {
            CameraLog.m12967f("CameraUIManager", "showBubble, mCameraRootView: " + this.f18365Z + ", type: " + OplusGLSurfaceView_13);
        }
        switch (OplusGLSurfaceView_13) {
            case 4:
                if (this.f18410as == null) {
                    this.f18410as = new SuperColorToolTips(this.f18497i);
                    this.f18410as.m8139a(true);
                    this.f18410as.m8138a(this.f18497i.getString(R.string.camera_bubble_short_video));
                    this.f18410as.setFocusable(true);
                    this.f18410as.setBackgroundDrawable(new BitmapDrawable());
                    this.f18410as.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.30
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view2, MotionEvent motionEvent) {
                            CameraUIManager.this.mo18210f(4, true);
                            return false;
                        }
                    });
                    this.f18410as.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.31
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            CameraUIManager.this.mo18210f(4, true);
                        }
                    });
                }
                MainShutterButton mainShutterButtonM19206r = this.f18514z.m19206r();
                this.f18410as.m24104b(mainShutterButtonM19206r.getShutterPadding());
                try {
                    this.f18410as.m8134a(mainShutterButtonM19206r);
                    break;
                } catch (WindowManager.BadTokenException COUIBaseListPopupWindow_8) {
                    if (this.f18410as.isShowing()) {
                        this.f18410as.dismiss();
                        this.f18410as = null;
                    }
                    CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + COUIBaseListPopupWindow_8.getMessage());
                    return;
                }
            case 5:
                if (this.f18413av == null) {
                    this.f18413av = m19600o(R.drawable.bubble_down_right, R.string.beauty3d_customize_success);
                    this.f18413av.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.33
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view2, MotionEvent motionEvent) {
                            CameraUIManager.this.mo18210f(5, true);
                            return false;
                        }
                    });
                }
                if (!this.f18413av.isShowing()) {
                    try {
                        this.f18413av.showAtLocation(this.f18365Z, 85, i2, i3);
                        break;
                    } catch (WindowManager.BadTokenException e2) {
                        if (this.f18413av.isShowing()) {
                            this.f18413av.dismiss();
                        }
                        CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e2.getMessage());
                        return;
                    }
                }
                break;
            case 6:
                if (this.f18411at == null) {
                    this.f18411at = m19600o(R.drawable.bubble_down_left, R.string.beauty3d_add_hint);
                    this.f18411at.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.34
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view2, MotionEvent motionEvent) {
                            CameraUIManager.this.mo18210f(6, true);
                            return false;
                        }
                    });
                }
                if (!this.f18411at.isShowing()) {
                    try {
                        this.f18411at.showAtLocation(this.f18365Z, 83, i2, i3);
                        break;
                    } catch (WindowManager.BadTokenException e3) {
                        if (this.f18411at.isShowing()) {
                            this.f18411at.dismiss();
                        }
                        CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e3.getMessage());
                        return;
                    }
                }
                break;
            case 7:
                ComboPreferences comboPreferences = this.f18341B;
                if (comboPreferences == null || !"on".equals(comboPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off"))) {
                    m19687a(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO, this.f18497i.getString(R.string.camera_ai_enhancement_video_hint), i2, i3, m19511fa());
                    break;
                }
                break;
            case 8:
                if (this.f18412au == null) {
                    this.f18412au = new COUIToolTips(this.f18497i);
                    this.f18412au.m8139a(true);
                    this.f18412au.setFocusable(false);
                    this.f18412au.m8138a(this.f18497i.getString(R.string.camera_custom_face_beauty_close_hint));
                    this.f18412au.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$iZJUc3rWrIm7t8JrAfxHY7X2DIQ
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view2, MotionEvent motionEvent) {
                            return this.COUIBaseListPopupWindow_12$0.m19452b(view2, motionEvent);
                        }
                    });
                }
                if (!this.f18412au.isShowing() && view != null) {
                    try {
                        this.f18412au.m8136a(view, m19511fa(), this.f18385aT.m20687l());
                        break;
                    } catch (WindowManager.BadTokenException e4) {
                        if (this.f18412au.isShowing()) {
                            this.f18412au.dismiss();
                        }
                        CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e4.getMessage());
                        return;
                    }
                }
                break;
            case 9:
                if (!mo19966j(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE)) {
                    CameraLog.m12966e("CameraUIManager", "showBubble, BUBBLE_TYPE_ZOOM_ULTRA_WIDE not support, so return");
                    break;
                } else {
                    if (this.f18414aw == null) {
                        this.f18414aw = new SuperColorToolTips(Util.m24472l());
                        this.f18414aw.m8139a(true);
                        this.f18414aw.setFocusable(false);
                        this.f18414aw.m8138a(this.f18497i.getString(R.string.zoom_ultra_wide_switch_guide));
                        this.f18414aw.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$08FuFsaCe5Iqv_wCefB91ztpURw
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                                return this.COUIBaseListPopupWindow_12$0.m19400a(view2, motionEvent);
                            }
                        });
                        this.f18414aw.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$I9t7PzZTh7SQ8A13YFLOJm1E6EY
                            @Override // android.widget.PopupWindow.OnDismissListener
                            public final void onDismiss() {
                                this.COUIBaseListPopupWindow_12$0.m19547gG();
                            }
                        });
                    }
                    if (view != null && 8 != view.getVisibility() && !this.f18414aw.isShowing()) {
                        try {
                            this.f18414aw.m8135a(view, m19511fa());
                        } catch (WindowManager.BadTokenException e5) {
                            if (this.f18414aw.isShowing()) {
                                this.f18414aw.dismiss();
                            }
                            CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e5.getMessage());
                        }
                    }
                    if (this.f18349J.mo10729ah() && this.f18414aw.isShowing()) {
                        this.f18349J.mo10735an();
                        break;
                    }
                }
                break;
            default:
                switch (OplusGLSurfaceView_13) {
                    case 15:
                        m19688a(CameraUIInterface.KEY_SUPER_RAW_CONTROL, CameraUIInterface.KEY_SUPER_RAW_CONTROL, "super_raw", this.f18497i.getString(R.string.camera_raw_control_super_bubble_hint), i2, i3);
                        break;
                    case 16:
                        if (this.f18417az == null) {
                            this.f18417az = m19611z(this.f18497i.getString(R.string.camera_double_exposure_gallery_hint));
                            this.f18417az.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.35
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view2, MotionEvent motionEvent) {
                                    CameraUIManager.this.mo18210f(16, true);
                                    return false;
                                }
                            });
                            if (view != null && !m19864dH()) {
                                try {
                                    this.f18417az.m8134a(view);
                                    break;
                                } catch (WindowManager.BadTokenException e6) {
                                    if (this.f18417az.isShowing()) {
                                        this.f18417az.dismiss();
                                        this.f18417az = null;
                                    }
                                    CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e6.getMessage());
                                    return;
                                }
                            }
                        }
                        break;
                    case 17:
                        if (this.f18415ax == null) {
                            this.f18415ax = new SuperColorToolTips(Util.m24472l());
                            this.f18415ax.m8138a(this.f18497i.getString(R.string.camera_click_show_beauty_tip));
                            this.f18415ax.m8139a(false);
                            this.f18415ax.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$HJbudVZobRsGYX-gNdHcpafpsIo
                                @Override // android.widget.PopupWindow.OnDismissListener
                                public final void onDismiss() {
                                    this.COUIBaseListPopupWindow_12$0.m19546gF();
                                }
                            });
                        }
                        View viewFindViewById = this.f18497i.findViewById(R.id_renamed.face_beauty_enter_button);
                        if (viewFindViewById != null && 8 != viewFindViewById.getVisibility()) {
                            try {
                                this.f18415ax.m8134a(viewFindViewById);
                                break;
                            } catch (WindowManager.BadTokenException e7) {
                                if (this.f18415ax.isShowing()) {
                                    this.f18415ax.dismiss();
                                }
                                CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e7.getMessage());
                                return;
                            }
                        }
                        break;
                    case 18:
                        if (this.f18497i == null) {
                            CameraLog.m12962c("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", activity is null.");
                            break;
                        } else if (this.f18349J.mo10664R()) {
                            if (!mo19966j(CameraUIInterface.KEY_SUPPORT_EXPOSURE_FOCUS_SEPARATE)) {
                                CameraLog.m12962c("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", function unsupported.");
                                break;
                            } else if (mo18159aw()) {
                                CameraLog.m12962c("CameraUIManager", "showBubble, zoom adjusting, not show separate guide.");
                                break;
                            } else {
                                Rect rectM19750bJ = m19750bJ();
                                float fM19597n = m19597n(i2, i3);
                                float dimension = this.f18497i.getApplication().getResources().getDimension(R.dimen.exposure_indicator_min_margin);
                                float dimension2 = this.f18497i.getApplication().getResources().getDimension(R.dimen.exposure_indicator_width);
                                float dimension3 = this.f18497i.getApplication().getResources().getDimension(R.dimen.exposure_indicator_height);
                                if (rectM19750bJ != null) {
                                    int iM19376a = (int) m19376a(i2, rectM19750bJ.width(), dimension, dimension2);
                                    rect = rectM19750bJ;
                                    iM19377a = (int) m19377a(i3, rectM19750bJ.top, rectM19750bJ.height(), dimension, dimension3);
                                    COUIBaseListPopupWindow_12 = fM19597n;
                                    i4 = iM19376a;
                                } else {
                                    COUIBaseListPopupWindow_12 = fM19597n;
                                    rect = rectM19750bJ;
                                    i4 = i2;
                                    iM19377a = i3;
                                }
                                int dimensionPixelSize = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.exposure_focus_separate_anim_width);
                                int dimensionPixelSize2 = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.exposure_focus_separate_anim_height);
                                if (this.f18407ap == null && this.f18365Z != null) {
                                    this.f18407ap = new LottieAnimationView(this.f18497i);
                                    this.f18407ap.setAnimation(R.raw.exposure_focus_separate_guide_anim);
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                                    boolean z = this.f18365Z.getLayoutDirection() == 1;
                                    int iWidth = rect != null ? rect.width() : 0;
                                    if (z) {
                                        layoutParams.rightMargin = iWidth - ((dimensionPixelSize / 2) + i4);
                                    } else {
                                        layoutParams.leftMargin = i4 - (dimensionPixelSize / 2);
                                    }
                                    layoutParams.topMargin = iM19377a;
                                    this.f18365Z.addView(this.f18407ap, layoutParams);
                                    this.f18407ap.setPivotX(dimensionPixelSize / 2.0f);
                                    this.f18407ap.setPivotY(0.0f);
                                    this.f18407ap.setRotation(COUIBaseListPopupWindow_12);
                                    this.f18407ap.m5508a(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.36
                                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                        public void onAnimationEnd(Animator animator) {
                                            CameraUIManager.this.mo18210f(18, true);
                                        }
                                    });
                                    this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$AYeUrfLDOB2YtiXUx-4ES6wBabQ
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.COUIBaseListPopupWindow_12$0.m19545gE();
                                        }
                                    });
                                }
                                Handler handler = this.f18483cm;
                                if (handler != null) {
                                    str = ", exception: ";
                                    handler.sendMessageDelayed(handler.obtainMessage(14), 1000L);
                                } else {
                                    str = ", exception: ";
                                }
                                if (this.f18368aC == null && (activity = this.f18497i) != null) {
                                    int dimensionPixelOffset = activity.getApplication().getResources().getDimensionPixelOffset(R.dimen.exposure_focus_separate_tips_margin);
                                    this.f18368aC = new SuperColorToolTips(this.f18497i);
                                    this.f18368aC.m8138a(this.f18497i.getString(R.string.camera_focus_exposure_separate_hint));
                                    this.f18368aC.m8139a(true);
                                    this.f18368aC.setFocusable(false);
                                    this.f18368aC.m24101a();
                                    int[] iArrM19402a = m19402a(COUIBaseListPopupWindow_12, dimensionPixelSize, dimensionPixelSize2, i4, iM19377a, dimensionPixelOffset);
                                    this.f18368aC.m24103a(iArrM19402a[0], iArrM19402a[1], rect != null ? rect.top : 0);
                                    this.f18368aC.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.37
                                        @Override // android.view.View.OnTouchListener
                                        public boolean onTouch(View view2, MotionEvent motionEvent) {
                                            CameraUIManager.this.mo18210f(18, true);
                                            return false;
                                        }
                                    });
                                    this.f18368aC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.38
                                        @Override // android.widget.PopupWindow.OnDismissListener
                                        public void onDismiss() {
                                            CameraUIManager.this.m19890dh();
                                            CameraUIManager.this.mo18210f(18, true);
                                        }
                                    });
                                }
                                if (view != null) {
                                    try {
                                        if (this.f18368aC != null) {
                                            this.f18368aC.m8137a(view, false);
                                            break;
                                        }
                                    } catch (WindowManager.BadTokenException e8) {
                                        SuperColorToolTips c3520c = this.f18368aC;
                                        if (c3520c != null && c3520c.isShowing()) {
                                            this.f18368aC.dismiss();
                                            this.f18368aC = null;
                                            m19890dh();
                                        }
                                        CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + str + e8.getMessage());
                                        return;
                                    }
                                }
                            }
                        }
                        break;
                    case 19:
                        if (this.f18416ay == null) {
                            this.f18416ay = new SuperColorToolTips(Util.m24472l());
                            this.f18416ay.m8138a(this.f18497i.getString(R.string.camera_super_eis_tip));
                            this.f18416ay.m8139a(false);
                            this.f18416ay.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$vAqX1fLdnVruPjaI2LeM_tPhZWU
                                @Override // android.widget.PopupWindow.OnDismissListener
                                public final void onDismiss() {
                                    this.COUIBaseListPopupWindow_12$0.m19544gD();
                                }
                            });
                        }
                        if (view != null && 8 != view.getVisibility() && !this.f18416ay.isShowing()) {
                            try {
                                this.f18416ay.m24102a(i2, i3);
                                this.f18416ay.m8135a(view, m19511fa());
                                mo18200d(false, false);
                                m19981v(false, false);
                                break;
                            } catch (WindowManager.BadTokenException e9) {
                                if (this.f18416ay.isShowing()) {
                                    this.f18416ay.dismiss();
                                }
                                CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e9.getMessage());
                                return;
                            }
                        }
                        break;
                    case 20:
                        if (this.f18369aD == null) {
                            this.f18369aD = new SuperColorToolTips(Util.m24472l());
                            this.f18369aD.m8138a(this.f18497i.getString(R.string.camera_long_press_trigger_rocker_shutter_tip));
                            this.f18369aD.m8139a(false);
                            this.f18369aD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$WnWFNhT0Yubk8ZUFjWdW0SvU8x4
                                @Override // android.widget.PopupWindow.OnDismissListener
                                public final void onDismiss() {
                                    this.COUIBaseListPopupWindow_12$0.m19543gC();
                                }
                            });
                        }
                        MainShutterButton mainShutterButtonM19206r2 = this.f18514z.m19206r();
                        if (mainShutterButtonM19206r2 != null) {
                            this.f18369aD.m24104b(mainShutterButtonM19206r2.getShutterPadding());
                            try {
                                this.f18369aD.m8134a(mainShutterButtonM19206r2);
                                break;
                            } catch (WindowManager.BadTokenException e10) {
                                if (this.f18369aD.isShowing()) {
                                    this.f18369aD.dismiss();
                                    this.f18369aD = null;
                                }
                                CameraLog.m12966e("CameraUIManager", "showBubble, type: " + OplusGLSurfaceView_13 + ", exception: " + e10.getMessage());
                                return;
                            }
                        }
                        break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ boolean m19452b(View view, MotionEvent motionEvent) {
        mo18210f(8, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ boolean m19400a(View view, MotionEvent motionEvent) {
        mo18210f(9, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gG */
    public /* synthetic */ void m19547gG() {
        mo18210f(9, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gF */
    public /* synthetic */ void m19546gF() {
        mo18210f(17, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gE */
    public /* synthetic */ void m19545gE() {
        FocusIndicatorRotateLayout c3451n = (FocusIndicatorRotateLayout) this.f18497i.findViewById(R.id_renamed.focus_exposure_indicator_container);
        if (c3451n != null) {
            c3451n.setOnVisibilityChangedListener(new FocusIndicatorRotateLayout.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$JumLXN3Bb0MbPm1Hd-zUqFiFXlc
                @Override // com.oplus.camera.p172ui.preview.FocusIndicatorRotateLayout.IntrinsicsJvm.kt_3
                public final void onVisibilityChanged(View view, int OplusGLSurfaceView_13) {
                    this.COUIBaseListPopupWindow_12$0.m19391a(view, OplusGLSurfaceView_13);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m19391a(View view, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            mo18210f(18, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gD */
    public /* synthetic */ void m19544gD() {
        mo18210f(19, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gC */
    public /* synthetic */ void m19543gC() {
        mo18210f(20, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m19376a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        float f5 = f4 / 2.0f;
        return Util.m24201a(COUIBaseListPopupWindow_12, f5 + f3, (f2 - f5) - f3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m19377a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5) {
        float f6 = f5 / 2.0f;
        return Util.m24201a(COUIBaseListPopupWindow_12, f2 + f6 + f4, ((f2 + f3) - f6) - f4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] m19402a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int iSqrt;
        double IntrinsicsJvm.kt_5;
        double d2;
        double dSqrt;
        int[] iArr = {-1, -1};
        Rect rectM19750bJ = m19750bJ();
        if (rectM19750bJ != null) {
            i7 = rectM19750bJ.top;
            i6 = rectM19750bJ.bottom;
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (90.0f < COUIBaseListPopupWindow_12 && COUIBaseListPopupWindow_12 < 270.0f) {
            iSqrt = ((int) (OplusGLSurfaceView_13 / Math.sqrt(2.0d))) + i4;
            IntrinsicsJvm.kt_5 = i4;
            d2 = i2;
            dSqrt = Math.sqrt(2.0d);
        } else {
            iSqrt = ((int) (i2 / Math.sqrt(2.0d))) + i4;
            IntrinsicsJvm.kt_5 = i4;
            d2 = OplusGLSurfaceView_13;
            dSqrt = Math.sqrt(2.0d);
        }
        int i8 = (int) (IntrinsicsJvm.kt_5 - (d2 / dSqrt));
        int i9 = i8 - i5;
        if (i9 > i7) {
            iArr[0] = i9;
        }
        int i10 = iSqrt + i5;
        if (i10 < i6) {
            iArr[1] = i10;
        }
        CameraLog.m12959b("CameraUIManager", "getTipsMarginTop, animationAngle: " + COUIBaseListPopupWindow_12 + ", animWidth: " + OplusGLSurfaceView_13 + ", animHeight: " + i2 + ", touchX: " + i3 + ", touchY: " + i4 + ", topX: " + i3 + ", topY: " + i8 + ", previewTop: " + i7 + ", result: " + Arrays.toString(iArr));
        return iArr;
    }

    /* renamed from: fa */
    private int m19511fa() {
        return 1 == this.f18349J.mo10816ca() ? 8 : 4;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aE */
    public void mo18115aE() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10698aC();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aD */
    public void mo18114aD() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21428x();
        }
    }

    /* renamed from: fb */
    private boolean m19512fb() {
        CameraUIListener cameraUIListener;
        return f18338g && !this.f18504p && (cameraUIListener = this.f18349J) != null && this.f18341B != null && this.f18348I != null && cameraUIListener.mo10670X() && !this.f18349J.mo10814c() && this.f18348I.m21426s() && this.f18341B.getBoolean(CameraUIInterface.KEY_DRAWER_SHOW_GUIDE_ANIMATION, true) && mo19966j(CameraUIInterface.KEY_SHOW_PULL_DOWN_TIP);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo18210f(int OplusGLSurfaceView_13, boolean z) {
        String str;
        PopupWindow popupWindow = null;
        switch (OplusGLSurfaceView_13) {
            case 4:
                popupWindow = this.f18410as;
                str = CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO;
                break;
            case 5:
                popupWindow = this.f18413av;
                str = CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D;
                break;
            case 6:
                popupWindow = this.f18411at;
                str = CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D;
                break;
            case 7:
                if (z && m19982v(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO)) {
                    m19582i(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO, false);
                }
                m19980u(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
                str = null;
                break;
            case 8:
                popupWindow = this.f18412au;
                str = CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE;
                break;
            case 9:
                SuperColorToolTips c3520c = this.f18414aw;
                if (c3520c != null) {
                    if (c3520c.isShowing()) {
                        this.f18414aw.dismiss();
                        CameraTipsManager.m14374a().m14378c();
                    }
                    if (z) {
                        m19582i(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE, false);
                        this.f18414aw = null;
                    }
                }
                str = null;
                break;
            default:
                switch (OplusGLSurfaceView_13) {
                    case 16:
                        COUIToolTips c1508s = this.f18417az;
                        if (c1508s != null) {
                            if (c1508s.isShowing()) {
                                this.f18417az.dismiss();
                            }
                            if (z) {
                                m19582i(CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, false);
                                this.f18417az = null;
                                break;
                            }
                        }
                        break;
                    case 17:
                        SuperColorToolTips c3520c2 = this.f18415ax;
                        if (c3520c2 != null) {
                            if (c3520c2.isShowing()) {
                                this.f18415ax.dismiss();
                                this.f18415ax = null;
                            }
                            if (z) {
                                m19582i(CameraUIInterface.KEY_FIRST_BEAUTY_TIPS, false);
                                break;
                            }
                        }
                        break;
                    case 18:
                        Handler handler = this.f18483cm;
                        if (handler != null) {
                            handler.obtainMessage(15).sendToTarget();
                        }
                        SuperColorToolTips c3520c3 = this.f18368aC;
                        if (c3520c3 != null) {
                            if (c3520c3.isShowing()) {
                                this.f18368aC.dismiss();
                            }
                            if (z) {
                                m19582i(CameraUIInterface.KEY_EXPOSURE_FOCUS_SEPARATE_TIPS, false);
                                this.f18368aC = null;
                                break;
                            }
                        }
                        break;
                    case 19:
                        SuperColorToolTips c3520c4 = this.f18416ay;
                        if (c3520c4 != null) {
                            if (c3520c4.isShowing()) {
                                this.f18416ay.dismiss();
                                this.f18416ay = null;
                            }
                            if (z) {
                                m19582i(CameraUIInterface.KEY_SUPER_EIS_WIDE_TIPS, false);
                                mo18200d(true, false);
                                m19981v(true, false);
                                break;
                            }
                        }
                        break;
                    case 20:
                        SuperColorToolTips c3520c5 = this.f18369aD;
                        if (c3520c5 != null) {
                            if (c3520c5.isShowing()) {
                                this.f18369aD.dismiss();
                                this.f18369aD = null;
                            }
                            if (z) {
                                m19582i(CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER, false);
                                break;
                            }
                        }
                        break;
                }
                str = null;
                break;
        }
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
            if (z) {
                m19582i(str, false);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private float m19597n(int OplusGLSurfaceView_13, int i2) {
        Rect rectM19750bJ = m19750bJ();
        if (rectM19750bJ == null) {
            return 315.0f;
        }
        int i3 = (rectM19750bJ.left + rectM19750bJ.right) / 2;
        int i4 = (rectM19750bJ.top + rectM19750bJ.bottom) / 2;
        return OplusGLSurfaceView_13 <= i3 ? i2 <= i4 ? 315.0f : 225.0f : i2 <= i4 ? 45.0f : 135.0f;
    }

    /* renamed from: fc */
    private void m19513fc() {
        mo18210f(9, true);
        mo18210f(4, true);
    }

    /* renamed from: fd */
    private void m19514fd() {
        mo18210f(9, false);
        mo18210f(17, false);
        mo18210f(20, false);
        if (ApsConstant.REC_MODE_COMMON.equals(mo18132aV())) {
            mo18210f(7, true);
        } else {
            mo18210f(7, false);
        }
    }

    /* renamed from: fe */
    private void m19515fe() {
        if (this.f18365Z != null && this.f18401aj == null) {
            this.f18401aj = (CameraScreenHintView) this.f18497i.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
            View view = this.f18403al;
            if (view != null) {
                ViewGroup viewGroup = this.f18365Z;
                viewGroup.addView(this.f18401aj, viewGroup.indexOfChild(view));
            } else {
                this.f18365Z.addView(this.f18401aj);
            }
            this.f18401aj.setOrientation(this.f18351L);
            this.f18401aj.setCameraScreenHintInterface(this.f18481ck);
            if (this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_ROTATE_HINT_VIEW)) {
                return;
            }
            this.f18401aj.setSupportRotateScreen(2);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m19970l(String str) {
        if (this.f18401aj == null) {
            m19515fe();
            if (this.f18401aj != null) {
                this.f18401aj.m18802a(0, (this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.sticker_hint_bottom_margin_vertical) + Util.m24187O()) - this.f18401aj.getViewGap(), this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.sticker_hint_bottom_margin_horizontal) - this.f18401aj.getViewGap(), true);
            }
        }
        if (this.f18401aj != null) {
            this.f18401aj.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(str).m18846a(true).m18849b(false).m18844a(R.color.sticker_hint_background_color).m18848b(R.color.screen_hint_text_color).m18847a());
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: E */
    public void mo18030E() {
        CameraScreenHintView cameraScreenHintView = this.f18401aj;
        if (cameraScreenHintView == null || cameraScreenHintView.getHintTextView().getVisibility() != 0) {
            return;
        }
        this.f18401aj.m18813b(true);
    }

    /* renamed from: o */
    private PopupWindow m19600o(int OplusGLSurfaceView_13, int i2) {
        View viewInflate = LayoutInflater.from(this.f18497i).inflate(R.layout.camera_bubble, (ViewGroup) null);
        viewInflate.setBackgroundResource(OplusGLSurfaceView_13);
        ((OplusTextView) viewInflate.findViewById(R.id_renamed.camera_bubble_text)).setText(i2);
        PopupWindow popupWindow = new PopupWindow(this.f18497i);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setContentView(viewInflate);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.PopupWindowStyle);
        return popupWindow;
    }

    /* renamed from: z */
    private COUIToolTips m19611z(String str) {
        COUIToolTips c1508s = new COUIToolTips(this.f18497i);
        c1508s.m8138a(str);
        c1508s.m8139a(true);
        c1508s.setFocusable(false);
        return c1508s;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m19582i(String str, boolean z) {
        ComboPreferences comboPreferences = this.f18341B;
        if (comboPreferences == null) {
            CameraLog.m12967f("CameraUIManager", "updateBubbleValue, mPreference null");
            return;
        }
        SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: s */
    public int mo18265s() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19072V();
        }
        return 1;
    }

    /* renamed from: ai */
    public void m19710ai(boolean z) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19179i(z);
        }
    }

    /* renamed from: cS */
    public void m19816cS() {
        ComboPreferences comboPreferences;
        CameraLog.m12959b("CameraUIManager", "startArrowAnimation");
        if (this.f18348I == null || (comboPreferences = this.f18341B) == null) {
            return;
        }
        comboPreferences.edit().putBoolean(CameraUIInterface.SHOW_ARROW_ANIMATION, false).apply();
    }

    /* renamed from: cT */
    public void m19817cT() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20887f();
        }
    }

    /* renamed from: cU */
    public boolean m19818cU() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            return c3282g.m20890h();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: s */
    public void mo18267s(boolean z) {
        ExpandableMenuPanel c3337q = this.f18376aK;
        if (c3337q != null) {
            c3337q.hideWithoutAnim(z, true);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: J */
    public void mo18040J() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23432z();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: q */
    public void mo18259q(boolean z) {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20870a(4, z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo18240l(boolean z, boolean z2) {
        CameraUIListener cameraUIListener;
        CameraLog.m12954a("CameraUIManager", "showFaceBeautyMenu, needAnim: " + z + ", needTranslateAnim: " + z2);
        if ((m19875dS() && m19864dH()) || (cameraUIListener = this.f18349J) == null || !cameraUIListener.mo10838f() || this.f18349J.mo10814c() || this.f18349J.mo10658L() || this.f18349J.mo10729ah() || mo18043K()) {
            return;
        }
        if ((this.f18349J.mo10710aO() && !this.f18349J.mo10711aP()) || this.f18503o || this.f18385aT == null || this.f18399ah.isEffectMenuOpen() || mo18051O() || m19490fF() || this.f18349J.mo10743av() || m19948ev() || m19821cX()) {
            return;
        }
        if (this.f18349J.mo10763bF() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_CUSTOM_MENU_SUPPORT)) {
            return;
        }
        m19992z(z, z2);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo18228i(boolean z, boolean z2) {
        float COUIBaseListPopupWindow_12;
        int OplusGLSurfaceView_13;
        CameraLog.m12954a("CameraUIManager", "showBlurMenuButton, needAnim: " + z);
        if (m19875dS() && m19864dH()) {
            return;
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || cameraUIListener.mo10843g()) {
            m19516ff();
            AnimatorSet animatorSet = this.f18389aX;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.f18389aX.cancel();
            } else {
                RotateAnimationView rotateAnimationView = this.f18382aQ;
                if (rotateAnimationView == null || rotateAnimationView.isShown()) {
                    return;
                }
                AnimatorSet animatorSet2 = this.f18388aW;
                if (animatorSet2 != null && animatorSet2.isStarted()) {
                    return;
                }
            }
            if (z) {
                this.f18382aQ.setAlpha(0.0f);
                this.f18382aQ.setTranslationY(0.0f);
                this.f18382aQ.setVisibility(0);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18382aQ, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.f18444ba);
                objectAnimatorOfFloat.setDuration(z2 ? 400L : 250L);
                this.f18388aW = new AnimatorSet();
                AnimatorSet.Builder builderPlay = this.f18388aW.play(objectAnimatorOfFloat);
                if (z2) {
                    String str = "translationX";
                    if (1 == mo18134aX()) {
                        OplusGLSurfaceView_13 = 270 == this.f18467bx.mo16570k() ? -this.f18465bv : this.f18465bv;
                    } else if (4 == mo18134aX()) {
                        OplusGLSurfaceView_13 = this.f18465bv;
                    } else {
                        COUIBaseListPopupWindow_12 = -this.f18465bv;
                        str = "translationY";
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18382aQ, str, COUIBaseListPopupWindow_12, 0.0f);
                        objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
                        objectAnimatorOfFloat2.setDuration(400L);
                        builderPlay.with(objectAnimatorOfFloat2);
                        this.f18388aW.setStartDelay(150L);
                    }
                    COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
                    ObjectAnimator objectAnimatorOfFloat22 = ObjectAnimator.ofFloat(this.f18382aQ, str, COUIBaseListPopupWindow_12, 0.0f);
                    objectAnimatorOfFloat22.setInterpolator(this.f18445bb);
                    objectAnimatorOfFloat22.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat22);
                    this.f18388aW.setStartDelay(150L);
                } else {
                    this.f18382aQ.setTranslationY(0.0f);
                    this.f18382aQ.setTranslationX(0.0f);
                }
                this.f18388aW.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.39
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (CameraUIManager.this.f18382aQ != null) {
                            CameraUIManager.this.f18382aQ.setVisibility(0);
                        }
                    }
                });
                this.f18388aW.start();
            } else {
                RotateAnimationView rotateAnimationView2 = this.f18382aQ;
                if (rotateAnimationView2 != null) {
                    rotateAnimationView2.setVisibility(0);
                    this.f18382aQ.setAlpha(1.0f);
                    this.f18382aQ.setTranslationY(0.0f);
                    this.f18382aQ.setTranslationX(0.0f);
                }
            }
            RotateAnimationView rotateAnimationView3 = this.f18382aQ;
            if (rotateAnimationView3 != null) {
                rotateAnimationView3.setEnabled(true);
            }
        }
    }

    /* renamed from: ff */
    private void m19516ff() {
        RotateAnimationView rotateAnimationView = this.f18382aQ;
        if (rotateAnimationView != null) {
            rotateAnimationView.m20510a(false, 0, 0);
            CameraUIListener cameraUIListener = this.f18349J;
            if (cameraUIListener != null && cameraUIListener.mo10848h(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU)) {
                this.f18381aP = R.drawable.multi_video_type_menu_normal;
                this.f18382aQ.setSelected(false);
                this.f18382aQ.clearColorFilter();
                this.f18382aQ.setImageResource(this.f18381aP);
                return;
            }
            CameraUIListener cameraUIListener2 = this.f18349J;
            if (cameraUIListener2 != null && cameraUIListener2.mo10848h(CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU)) {
                this.f18381aP = R.drawable.ic_mode_long_exposure;
                this.f18382aQ.setSelected(false);
                this.f18382aQ.clearColorFilter();
                this.f18382aQ.setImageResource(this.f18381aP);
                this.f18382aQ.m20510a(m19868dL(), 0, 0);
                return;
            }
            if (this.f18495cy.mo20016h()) {
                m19636S(true);
            } else {
                m19636S(this.f18495cy.mo20010b());
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo18223h(boolean z, boolean z2) {
        float COUIBaseListPopupWindow_12;
        int OplusGLSurfaceView_13;
        CameraLog.m12954a("CameraUIManager", "hideBlurMenuButton, needAnim: " + z);
        AnimatorSet animatorSet = this.f18388aW;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f18388aW.cancel();
        } else {
            RotateAnimationView rotateAnimationView = this.f18382aQ;
            if (rotateAnimationView == null || !rotateAnimationView.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f18389aX;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18382aQ, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f18444ba);
            objectAnimatorOfFloat.setDuration(250L);
            this.f18389aX = new AnimatorSet();
            AnimatorSet.Builder builderPlay = this.f18389aX.play(objectAnimatorOfFloat);
            if (z2) {
                String str = "translationX";
                if (1 == mo18134aX()) {
                    OplusGLSurfaceView_13 = 270 == this.f18467bx.mo16570k() ? -this.f18465bv : this.f18465bv;
                } else if (4 == mo18134aX()) {
                    OplusGLSurfaceView_13 = this.f18465bv;
                } else {
                    COUIBaseListPopupWindow_12 = -this.f18465bv;
                    str = "translationY";
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18382aQ, str, 0.0f, COUIBaseListPopupWindow_12);
                    objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                }
                COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
                ObjectAnimator objectAnimatorOfFloat22 = ObjectAnimator.ofFloat(this.f18382aQ, str, 0.0f, COUIBaseListPopupWindow_12);
                objectAnimatorOfFloat22.setInterpolator(this.f18445bb);
                objectAnimatorOfFloat22.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat22);
            } else {
                this.f18382aQ.setTranslationY(0.0f);
                this.f18382aQ.setTranslationX(0.0f);
            }
            this.f18389aX.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.40
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (CameraUIManager.this.f18382aQ != null) {
                        CameraUIManager.this.f18382aQ.setEnabled(false);
                        CameraUIManager.this.f18382aQ.setTranslationY(0.0f);
                        CameraUIManager.this.f18382aQ.setTranslationX(0.0f);
                        CameraUIManager.this.f18382aQ.setAlpha(1.0f);
                        CameraUIManager.this.f18382aQ.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (CameraUIManager.this.f18382aQ != null) {
                        CameraUIManager.this.f18382aQ.setEnabled(true);
                        CameraUIManager.this.f18382aQ.setVisibility(8);
                        CameraUIManager.this.f18382aQ.setTranslationY(0.0f);
                        CameraUIManager.this.f18382aQ.setTranslationX(0.0f);
                        CameraUIManager.this.f18382aQ.setAlpha(0.0f);
                    }
                }
            });
            this.f18389aX.start();
            return;
        }
        RotateAnimationView rotateAnimationView2 = this.f18382aQ;
        if (rotateAnimationView2 != null) {
            rotateAnimationView2.setVisibility(8);
            this.f18382aQ.setTranslationY(0.0f);
            this.f18382aQ.setTranslationX(0.0f);
            this.f18382aQ.setAlpha(0.0f);
        }
    }

    /* renamed from: cV */
    public void m19819cV() {
        CameraUIListener cameraUIListener = this.f18349J;
        boolean z = cameraUIListener != null && cameraUIListener.mo10847h();
        mo18052P(false);
        mo18232j(true, z);
        mo18223h(true, z);
        mo18210f(17, true);
        mo18210f(20, true);
        GalleryPreviewAdapter c3230k = this.f18425bH;
        if (c3230k != null) {
            c3230k.m20248b();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: L */
    public void mo18044L() {
        GalleryPreviewAdapter c3230k = this.f18425bH;
        if (c3230k != null) {
            c3230k.m20252c();
        }
        m19761bU();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo18232j(boolean z, boolean z2) {
        CameraLog.m12954a("CameraUIManager", "hideFaceBeautyMenu, needAnim: " + z);
        if (mo18043K()) {
            mo18109a(z, false, false, false);
        } else {
            mo18236k(z, z2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: u */
    public void mo18275u(boolean z) {
        FaceBeautyMenu viewOnClickListenerC3261g;
        CameraLog.m12954a("CameraUIManager", "openFaceBeautyMenu, needAnim: " + z);
        if (this.f18504p || (viewOnClickListenerC3261g = this.f18385aT) == null || viewOnClickListenerC3261g.m20689n()) {
            CameraLog.m12966e("CameraUIManager", "openFaceBeautyMenu, return");
            return;
        }
        this.f18385aT.m20673d(true);
        this.f18399ah.setMenuOpen(true);
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            this.f18385aT.m20670c(cameraUIListener.mo10654H());
        }
        CameraUIListener cameraUIListener2 = this.f18349J;
        boolean z2 = false;
        int iMo10672Z = cameraUIListener2 != null ? cameraUIListener2.mo10672Z() : 0;
        m19464e(z, iMo10672Z);
        View viewM20668b = this.f18385aT.m20668b(iMo10672Z);
        ViewGroup.LayoutParams layoutParamsM20684i = this.f18385aT.m20684i();
        if (viewM20668b != null && layoutParamsM20684i != null) {
            viewM20668b.setVisibility(0);
            viewM20668b.setAlpha(0.0f);
            if (viewM20668b.getParent() == null) {
                this.f18365Z.addView(viewM20668b, Math.max(this.f18365Z.indexOfChild(this.f18514z.m19071U()) + 1, this.f18340A.m23366af() + 1), layoutParamsM20684i);
            }
            BaseScreenMode abstractC2934a = this.f18467bx;
            if (abstractC2934a != null) {
                this.f18385aT.m20682h(abstractC2934a.mo16528a(this.f18352M));
            }
            this.f18385aT.m20676e(z);
            if (this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && FilterHelper.m22633g() && !CameraCharacteristicsUtil.m12974a(mo19845cv()) && !this.f18341B.getBoolean(CameraUIInterface.PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED, false)) {
                z2 = true;
            }
            if (z2) {
                this.f18385aT.m20677f();
            } else {
                this.f18385aT.m20680g();
            }
        } else {
            CameraLog.m12967f("CameraUIManager", "openFaceBeautyMenu, view: " + viewM20668b + ", params: " + layoutParamsM20684i);
        }
        if (4 != mo18134aX()) {
            mo18236k(z, true);
            mo18223h(z, true);
        }
    }

    /* renamed from: z */
    public void m19992z(boolean z, boolean z2) {
        float COUIBaseListPopupWindow_12;
        CameraLog.m12954a("CameraUIManager", "showFaceBeautyButton, needAnim: " + z + ", needTranslate: " + z2);
        if (this.f18503o) {
            return;
        }
        if (!(m19875dS() && m19864dH()) && this.f18385aT.m20696u()) {
            m19517fg();
            this.f18377aL.setClickable(true);
            AnimatorSet animatorSet = this.f18387aV;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.f18387aV.end();
            } else {
                if (this.f18377aL.isShown()) {
                    return;
                }
                AnimatorSet animatorSet2 = this.f18386aU;
                if (animatorSet2 != null && animatorSet2.isStarted()) {
                    return;
                }
            }
            if (z) {
                String str = "translationX";
                if (1 == mo18134aX()) {
                    COUIBaseListPopupWindow_12 = 270 == this.f18467bx.mo16570k() ? -this.f18465bv : this.f18465bv;
                    this.f18377aL.setTranslationX(COUIBaseListPopupWindow_12);
                } else if (4 == mo18134aX()) {
                    COUIBaseListPopupWindow_12 = this.f18465bv;
                    this.f18377aL.setTranslationX(COUIBaseListPopupWindow_12);
                } else {
                    COUIBaseListPopupWindow_12 = -this.f18465bv;
                    this.f18377aL.setTranslationY(COUIBaseListPopupWindow_12);
                    str = "translationY";
                }
                this.f18377aL.setAlpha(0.0f);
                this.f18377aL.setVisibility(0);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18377aL, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.f18444ba);
                objectAnimatorOfFloat.setDuration(250L);
                this.f18386aU = new AnimatorSet();
                AnimatorSet.Builder builderPlay = this.f18386aU.play(objectAnimatorOfFloat);
                if (z2) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18377aL, str, COUIBaseListPopupWindow_12, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                    this.f18386aU.setStartDelay(150L);
                } else {
                    this.f18377aL.setTranslationY(0.0f);
                    this.f18377aL.setTranslationX(0.0f);
                }
                this.f18386aU.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.41
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (CameraUIManager.this.f18377aL != null) {
                            CameraUIManager.this.f18377aL.setTranslationY(0.0f);
                            CameraUIManager.this.f18377aL.setTranslationX(0.0f);
                            CameraUIManager.this.f18377aL.setAlpha(1.0f);
                            CameraUIManager.this.f18377aL.setVisibility(0);
                            CameraUIManager.this.m19556gh();
                        }
                    }
                });
                this.f18386aU.start();
            } else {
                this.f18377aL.setTranslationY(0.0f);
                this.f18377aL.setTranslationX(0.0f);
                this.f18377aL.setAlpha(1.0f);
                this.f18377aL.setVisibility(0);
                m19556gh();
            }
            if (m19486fB()) {
                return;
            }
            this.f18377aL.setEnabled(true);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo18236k(boolean z, boolean z2) {
        float COUIBaseListPopupWindow_12;
        int OplusGLSurfaceView_13;
        CameraLog.m12954a("CameraUIManager", "hideFaceBeautyButton, needAnim: " + z + ", needTranslate: " + z2);
        AnimatorSet animatorSet = this.f18386aU;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f18386aU.cancel();
        } else {
            SplitBackgroundView splitBackgroundView = this.f18377aL;
            if (splitBackgroundView == null || !splitBackgroundView.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f18387aV;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        this.f18377aL.setClickable(false);
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18377aL, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f18444ba);
            objectAnimatorOfFloat.setDuration(250L);
            this.f18387aV = new AnimatorSet();
            AnimatorSet.Builder builderPlay = this.f18387aV.play(objectAnimatorOfFloat);
            if (z2) {
                String str = "translationX";
                if (1 == mo18134aX()) {
                    OplusGLSurfaceView_13 = 270 == this.f18467bx.mo16570k() ? -this.f18465bv : this.f18465bv;
                } else if (4 == mo18134aX()) {
                    OplusGLSurfaceView_13 = this.f18465bv;
                } else {
                    COUIBaseListPopupWindow_12 = -this.f18465bv;
                    str = "translationY";
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18377aL, str, 0.0f, COUIBaseListPopupWindow_12);
                    objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                }
                COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
                ObjectAnimator objectAnimatorOfFloat22 = ObjectAnimator.ofFloat(this.f18377aL, str, 0.0f, COUIBaseListPopupWindow_12);
                objectAnimatorOfFloat22.setInterpolator(this.f18445bb);
                objectAnimatorOfFloat22.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat22);
            } else {
                this.f18377aL.setTranslationY(0.0f);
                this.f18377aL.setTranslationX(0.0f);
            }
            this.f18387aV.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.42
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (CameraUIManager.this.f18377aL != null) {
                        CameraUIManager.this.f18377aL.setEnabled(false);
                        CameraUIManager.this.f18377aL.setTranslationY(0.0f);
                        CameraUIManager.this.f18377aL.setTranslationX(0.0f);
                        CameraUIManager.this.f18377aL.setAlpha(1.0f);
                        CameraUIManager.this.f18377aL.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (CameraUIManager.this.f18377aL != null) {
                        if (!CameraUIManager.this.m19486fB() || !CameraUIManager.this.mo18131aU()) {
                            CameraUIManager.this.f18377aL.setEnabled(true);
                        }
                        CameraUIManager.this.f18377aL.setTranslationY(0.0f);
                        CameraUIManager.this.f18377aL.setTranslationX(0.0f);
                        CameraUIManager.this.f18377aL.setAlpha(0.0f);
                        CameraUIManager.this.m19557gi();
                        CameraUIManager.this.f18377aL.setVisibility(8);
                    }
                }
            });
            m19557gi();
            this.f18387aV.start();
            return;
        }
        m19557gi();
        this.f18377aL.setVisibility(8);
        this.f18377aL.setTranslationY(0.0f);
        this.f18377aL.setAlpha(0.0f);
    }

    /* renamed from: A */
    public void m19614A(boolean z, boolean z2) {
        CameraLog.m12959b("CameraUIManager", "setEffectMenuBackButtonVisibility, visible: " + z + ", needTranslateAnim: " + z2);
        if (1 != mo18134aX()) {
            return;
        }
        float COUIBaseListPopupWindow_12 = 270 == this.f18467bx.mo16570k() ? this.f18465bv : -this.f18465bv;
        if (!z2) {
            COUIBaseListPopupWindow_12 = 0.0f;
        }
        float f2 = COUIBaseListPopupWindow_12;
        if (z) {
            Util.m24274a((View) this.f18378aM, true, f2, 0.0f, (TimeInterpolator) this.f18444ba, 400L, (TimeInterpolator) this.f18445bb, 400L, (Animator.AnimatorListener) null, 150L);
        } else {
            Util.m24274a((View) this.f18378aM, false, f2, 0.0f, (TimeInterpolator) this.f18444ba, 250L, (TimeInterpolator) this.f18445bb, 400L, (Animator.AnimatorListener) null, 0L);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: B */
    public void mo18024B(boolean z) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            if (z) {
                viewOnClickListenerC3199a.m19119af();
            } else {
                viewOnClickListenerC3199a.m19117ad();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ar */
    public void mo18154ar() {
        if (this.f18514z != null) {
            VideoClipManager c2688g = this.f18462bs;
            if (c2688g == null || !c2688g.m12950o()) {
                this.f18514z.m19120ag();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: as */
    public void mo18155as() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19122ai();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18192c(boolean z, boolean z2, boolean z3, boolean z4) throws Resources.NotFoundException {
        RotateAnimationView rotateAnimationView = this.f18382aQ;
        if (rotateAnimationView != null && R.drawable.multi_video_type_menu_normal != this.f18381aP) {
            this.f18381aP = R.drawable.multi_video_type_menu_normal;
            rotateAnimationView.setImageResource(this.f18381aP);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23390c(z, z2);
            if (z3 && 1 == mo18134aX()) {
                m19614A(z, z2);
                if (z4) {
                    m19983w(!z, z2);
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18109a(boolean z, boolean z2, boolean z3, boolean z4) {
        m19695a(z, z2, z3, z4, -1L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19695a(boolean z, boolean z2, boolean z3, boolean z4, long OplusGLSurfaceView_15) throws Resources.NotFoundException {
        CameraLog.m12954a("CameraUIManager", "closeFaceBeautyMenu, needAnim: " + z + ", showEnterButton: " + z2 + ", showZoom: " + z4);
        if (this.f18385aT == null || !mo18043K()) {
            CameraLog.m12954a("CameraUIManager", "closeFaceBeautyMenu, mFaceBeautyMenu: " + this.f18385aT + ", isFaceBeautyMenuOpen(): " + mo18043K() + ", return.");
            return;
        }
        this.f18472cb = OplusGLSurfaceView_15;
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23402g(true);
        }
        this.f18349J.mo10855j(false);
        if (this.f18385aT.m20690o()) {
            this.f18349J.mo10706aK();
        }
        this.f18385aT.m20673d(false);
        this.f18385aT.m20679f(z);
        this.f18399ah.setMenuOpen(false);
        mo18210f(8, true);
        m19398a(z, this.f18385aT.m20674e(), z2, z4);
        if (4 == mo18134aX()) {
            return;
        }
        if (z3 && ((!Util.m24498u() || !this.f18349J.mo10779bV()) && this.f18349J.mo10796bm() && !this.f18503o)) {
            mo18228i(z, true);
        }
        if (z2 && ((!Util.m24498u() || !this.f18349J.mo10779bV()) && this.f18349J.mo10795bl() && !this.f18503o)) {
            m19992z(z, true);
        }
        m19614A(false, z);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: K */
    public boolean mo18043K() {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        return viewOnClickListenerC3261g != null && viewOnClickListenerC3261g.m20689n();
    }

    /* renamed from: cW */
    public boolean m19820cW() {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        return viewOnClickListenerC3261g != null && viewOnClickListenerC3261g.m20689n() && 1 == this.f18385aT.m20674e();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: O */
    public boolean mo18051O() {
        BlurMenu c3278c = this.f18400ai;
        return c3278c != null && c3278c.isMenuOpen();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: P */
    public boolean mo18053P() {
        BlurMenu c3278c = this.f18400ai;
        return c3278c != null && c3278c.isAnimationRunning();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: Q */
    public boolean mo18055Q() {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        return viewOnClickListenerC3261g != null && viewOnClickListenerC3261g.m20688m();
    }

    /* renamed from: cX */
    public boolean m19821cX() {
        BlurMenu c3278c = this.f18384aS;
        return c3278c != null && c3278c.isMenuOpen();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: r */
    public void mo18263r(boolean z) {
        if (this.f18399ah == null || !this.f18349J.mo10848h(CameraUIInterface.KEY_FILTER_PROCESS) || this.f18349J.mo10814c() || this.f18503o) {
            return;
        }
        if (this.f18349J.mo10839f(CameraUIInterface.KEY_FILTER_MENU) || this.f18349J.mo10839f(CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            this.f18399ah.m20870a(0, z);
        } else if (mo18023A() && this.f18349J.mo10705aJ()) {
            mo18275u(true);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m19962i(int OplusGLSurfaceView_13, boolean z) {
        FaceBeautyMenu viewOnClickListenerC3261g;
        if (z) {
            m19556gh();
        } else {
            m19557gi();
        }
        this.f18377aL.setClickable(z);
        this.f18377aL.setEnabled(z);
        m19371X(OplusGLSurfaceView_13);
        if (z || (viewOnClickListenerC3261g = this.f18385aT) == null || !viewOnClickListenerC3261g.m20689n()) {
            return;
        }
        mo18109a(true, true, true, true);
    }

    /* renamed from: X */
    private void m19371X(int OplusGLSurfaceView_13) {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20672d(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: aj */
    public void m19711aj(final boolean z) {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g == null || z == viewOnClickListenerC3261g.m20683h()) {
            return;
        }
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.44
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.f18385aT.m20671c(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fg */
    public void m19517fg() {
        final boolean z;
        final int OplusGLSurfaceView_13;
        int i2;
        CameraLog.m12954a("CameraUIManager", "updateFaceBeautyEnterButton");
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            final boolean zM20693r = viewOnClickListenerC3261g.m20693r();
            final boolean zM20695t = this.f18385aT.m20695t();
            final boolean zM20694s = this.f18385aT.m20694s();
            boolean z2 = this.f18349J.mo10848h(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && FilterHelper.m22633g() && !CameraCharacteristicsUtil.m12974a(mo19845cv()) && !this.f18341B.getBoolean(CameraUIInterface.PRE_FACE_BEAUTY_ICON_RECEOMMEND_CLICKED, false);
            SplitBackgroundView splitBackgroundView = this.f18377aL;
            if (splitBackgroundView != null) {
                splitBackgroundView.m20510a(z2, 0, 0);
            }
            CameraLog.m12954a("CameraUIManager", "setImageResource, supportFaceBeauty: " + zM20693r + ", supportFilter: " + zM20695t + " needShowRedDot " + z2);
            if (zM20693r && zM20695t) {
                i2 = R.drawable.face_beauty_menu_control_button;
            } else {
                if (!zM20693r) {
                    if (zM20695t) {
                        OplusGLSurfaceView_13 = R.drawable.face_beauty_menu_effect_button;
                        z = false;
                    } else {
                        z = true;
                        OplusGLSurfaceView_13 = 0;
                    }
                    this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.45
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void run() {
                            /*
                                r3 = this;
                                int r0 = r2
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r1 = com.oplus.camera.p172ui.CameraUIManager.this
                                int r1 = com.oplus.camera.p172ui.CameraUIManager.m19435ai(r1)
                                if (r0 == r1) goto L1c
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                int r1 = r2
                                com.oplus.camera.p172ui.CameraUIManager.m19584j(r0, r1)
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                                int r1 = r2
                                r0.setImageResource(r1)
                            L1c:
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                                if (r0 != 0) goto L2c
                                java.lang.String r3 = "CameraUIManager"
                                java.lang.String r0 = "updateFaceBeautyEnterButton, mCameraUIListener is null"
                                com.oplus.camera.CameraLog.m12967f(r3, r0)
                                return
                            L2c:
                                boolean r0 = r3
                                r1 = 0
                                if (r0 == 0) goto L41
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.CameraUIListener r2 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                                int r2 = r2.mo10722aa()
                                boolean r0 = com.oplus.camera.p172ui.CameraUIManager.m19591k(r0, r2)
                                if (r0 != 0) goto L61
                            L41:
                                boolean r0 = r4
                                if (r0 == 0) goto L51
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                                int r0 = r0.mo10726ae()
                                if (r0 != 0) goto L61
                            L51:
                                boolean r0 = r5
                                if (r0 == 0) goto La6
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                                boolean r0 = r0.mo10727af()
                                if (r0 == 0) goto La6
                            L61:
                                boolean r0 = r6
                                if (r0 != 0) goto L9b
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                                boolean r0 = r0.mo10727af()
                                if (r0 == 0) goto L9b
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                                r0.m20508a()
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                r2 = 2131232030(0x7f08051e, float:1.8080158E38)
                                com.oplus.camera.p172ui.CameraUIManager.m19584j(r0, r2)
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                                r0.setColorFilter(r1)
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.CameraUIManager.this
                                int r3 = com.oplus.camera.p172ui.CameraUIManager.m19435ai(r3)
                                r0.setImageResource(r3)
                                goto Laf
                            L9b:
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r3)
                                r0 = 1
                                r3.setSelected(r0)
                                goto Laf
                            La6:
                                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.CameraUIManager.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r3)
                                r3.setSelected(r1)
                            Laf:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.CameraUIManager.AnonymousClass45.run():void");
                        }
                    });
                }
                i2 = R.drawable.face_beauty_menu_control_button_facebeauty;
            }
            OplusGLSurfaceView_13 = i2;
            z = true;
            this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.45
                @Override // java.lang.Runnable
                public void run() {
                    /*
                        this = this;
                        int r0 = r2
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r1 = com.oplus.camera.p172ui.CameraUIManager.this
                        int r1 = com.oplus.camera.p172ui.CameraUIManager.m19435ai(r1)
                        if (r0 == r1) goto L1c
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        int r1 = r2
                        com.oplus.camera.p172ui.CameraUIManager.m19584j(r0, r1)
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                        int r1 = r2
                        r0.setImageResource(r1)
                    L1c:
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                        if (r0 != 0) goto L2c
                        java.lang.String r3 = "CameraUIManager"
                        java.lang.String r0 = "updateFaceBeautyEnterButton, mCameraUIListener is null"
                        com.oplus.camera.CameraLog.m12967f(r3, r0)
                        return
                    L2c:
                        boolean r0 = r3
                        r1 = 0
                        if (r0 == 0) goto L41
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.CameraUIListener r2 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                        int r2 = r2.mo10722aa()
                        boolean r0 = com.oplus.camera.p172ui.CameraUIManager.m19591k(r0, r2)
                        if (r0 != 0) goto L61
                    L41:
                        boolean r0 = r4
                        if (r0 == 0) goto L51
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                        int r0 = r0.mo10726ae()
                        if (r0 != 0) goto L61
                    L51:
                        boolean r0 = r5
                        if (r0 == 0) goto La6
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                        boolean r0 = r0.mo10727af()
                        if (r0 == 0) goto La6
                    L61:
                        boolean r0 = r6
                        if (r0 != 0) goto L9b
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.p172ui.CameraUIManager.m19580i(r0)
                        boolean r0 = r0.mo10727af()
                        if (r0 == 0) goto L9b
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                        r0.m20508a()
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        r2 = 2131232030(0x7f08051e, float:1.8080158E38)
                        com.oplus.camera.p172ui.CameraUIManager.m19584j(r0, r2)
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                        r0.setColorFilter(r1)
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r0)
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.CameraUIManager.this
                        int r3 = com.oplus.camera.p172ui.CameraUIManager.m19435ai(r3)
                        r0.setImageResource(r3)
                        goto Laf
                    L9b:
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r3)
                        r0 = 1
                        r3.setSelected(r0)
                        goto Laf
                    La6:
                        com.oplus.camera.ui.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.CameraUIManager.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.p172ui.CameraUIManager.m19427ae(r3)
                        r3.setSelected(r1)
                    Laf:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.CameraUIManager.AnonymousClass45.run():void");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public boolean m19373Y(int OplusGLSurfaceView_13) {
        if (!CameraCharacteristicsUtil.m12974a(mo19845cv())) {
            return OplusGLSurfaceView_13 != 0;
        }
        if (OplusGLSurfaceView_13 == 0) {
            return mo19966j(CameraUIInterface.KEY_SUPPORT_MAKEUP) && this.f18349J.mo10726ae() != 0;
        }
        return true;
    }

    /* renamed from: cY */
    public void m19822cY() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g == null || !viewOnLayoutChangeListenerC3444g.mo23373am()) {
            return;
        }
        this.f18340A.m23370aj();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m19464e(boolean z, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        boolean z2;
        if (1 == mo18134aX()) {
            m19983w(false, true);
            z2 = false;
        } else {
            z2 = true;
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (m19518fh()) {
                if (z2) {
                    m19794c(z, 0);
                }
                CameraUIListener cameraUIListener = this.f18349J;
                if (cameraUIListener != null) {
                    cameraUIListener.mo10874q();
                }
            } else {
                CameraControlUI viewOnClickListenerC3199a = this.f18514z;
                if (viewOnClickListenerC3199a != null && z2) {
                    if (z) {
                        viewOnClickListenerC3199a.m19173h();
                    } else {
                        viewOnClickListenerC3199a.m19078a(0);
                    }
                }
                CameraUIListener cameraUIListener2 = this.f18349J;
                if (cameraUIListener2 != null) {
                    cameraUIListener2.mo10874q();
                }
            }
            m19822cY();
        } else if (OplusGLSurfaceView_13 == 2) {
            if (!m19518fh()) {
                CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
                if (viewOnClickListenerC3199a2 != null && z2) {
                    if (z) {
                        viewOnClickListenerC3199a2.m19173h();
                    } else {
                        viewOnClickListenerC3199a2.m19078a(0);
                    }
                }
            } else if (z2) {
                m19794c(z, 0);
            }
            CameraUIListener cameraUIListener3 = this.f18349J;
            if (cameraUIListener3 != null) {
                cameraUIListener3.mo10874q();
            }
        }
        if (4 != mo18134aX()) {
            m19614A(true, z);
        } else {
            mo18215g(4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19398a(boolean z, int OplusGLSurfaceView_13, boolean z2, boolean z3) throws Resources.NotFoundException {
        boolean z4;
        CameraUIListener cameraUIListener;
        CameraUIListener cameraUIListener2;
        CameraControlUI viewOnClickListenerC3199a;
        CameraUIListener cameraUIListener3;
        if (1 == mo18134aX()) {
            m19983w(true, z);
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z2) {
            if (z3 && (cameraUIListener3 = this.f18349J) != null) {
                cameraUIListener3.mo10689a(false);
            }
            if (!mo18057R() || (viewOnClickListenerC3199a = this.f18514z) == null || viewOnClickListenerC3199a.m19160d() || !z4) {
                return;
            }
            if (z) {
                this.f18514z.m19147b(true, true);
                return;
            } else {
                this.f18514z.m19140b(0);
                return;
            }
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (m19518fh()) {
                if (z4) {
                    mo18077a(0, true);
                }
                CameraUIListener cameraUIListener4 = this.f18349J;
                if (cameraUIListener4 != null) {
                    cameraUIListener4.mo10689a(false);
                }
            } else {
                CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
                if (viewOnClickListenerC3199a2 != null && z4) {
                    if (z) {
                        viewOnClickListenerC3199a2.m19147b(true, true);
                    } else {
                        viewOnClickListenerC3199a2.m19140b(0);
                    }
                }
            }
            if (z3 && (cameraUIListener = this.f18349J) != null) {
                cameraUIListener.mo10689a(false);
            }
        } else if (OplusGLSurfaceView_13 == 2) {
            if (!m19518fh()) {
                CameraControlUI viewOnClickListenerC3199a3 = this.f18514z;
                if (viewOnClickListenerC3199a3 != null && z4) {
                    if (z) {
                        viewOnClickListenerC3199a3.m19147b(true, true);
                    } else {
                        viewOnClickListenerC3199a3.m19140b(0);
                    }
                }
            } else if (z4) {
                mo18077a(0, true);
            }
            if (z3 && (cameraUIListener2 = this.f18349J) != null) {
                cameraUIListener2.mo10689a(false);
            }
        }
        if (4 == mo18134aX()) {
            mo18215g(0);
        }
    }

    /* renamed from: cZ */
    public void m19823cZ() {
        CameraControlUI viewOnClickListenerC3199a;
        CameraControlUI viewOnClickListenerC3199a2;
        VideoRecordingTimeUI c3434ae;
        if (this.f18514z != null && this.f18349J.mo10808by()) {
            m19724aw(false);
            this.f18514z.m19217x();
        }
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null && !c3282g.isEffectMenuOpen()) {
            mo18259q(false);
        }
        if (mo18051O()) {
            mo18176b(false, true, false, false);
        }
        if (this.f18377aL != null) {
            mo18232j(true, true);
            mo18210f(17, true);
            mo18210f(20, true);
        }
        if (this.f18382aQ != null) {
            mo18223h(true, true);
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null && cameraUIListener.mo10814c() && (c3434ae = this.f18343D) != null) {
            c3434ae.m23046a(false);
        }
        if (m19751bK()) {
            m19846cw();
        }
        if (m19518fh()) {
            this.f18500l.mo16411a().mo16527a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$bgh1c-vo0262TYQZtUuG1W-iAEM
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m19592l(objArr);
                }
            }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$t2RD7SVil82Y0cg8dwEAGBde5s4
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m19590k(objArr);
                }
            }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$_kFif1W_0NzKSmfl28wlMFlUyKQ
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m19587j(objArr);
                }
            });
            this.f18443bZ = true;
            if (Util.m24352ao() && mo19900dr() && (viewOnClickListenerC3199a2 = this.f18514z) != null) {
                viewOnClickListenerC3199a2.m19077a((byte) 1, true);
            }
        } else {
            CameraUIListener cameraUIListener2 = this.f18349J;
            if (cameraUIListener2 != null && cameraUIListener2.mo10814c()) {
                VideoRecordingTimeUI c3434ae2 = this.f18343D;
                if (c3434ae2 != null) {
                    c3434ae2.m23046a(false);
                }
                if (Util.m24352ao() && (viewOnClickListenerC3199a = this.f18514z) != null) {
                    viewOnClickListenerC3199a.m19077a((byte) 1, true);
                }
            } else {
                m19647a((byte) 1, true);
                this.f18500l.mo16411a().mo16527a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$RKRAKXv9ATH5XyjNie1PSG7w3ko
                    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                    public final void call(Object[] objArr) {
                        this.COUIBaseListPopupWindow_12$0.m19583i(objArr);
                    }
                }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$Dti7p3yGPMOoqJh--XPNIzYqbc0
                    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                    public final void call(Object[] objArr) {
                        this.COUIBaseListPopupWindow_12$0.m19577h(objArr);
                    }
                }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$3az6q606Drt0UF4HYhFGvdUn4eM
                    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                    public final void call(Object[] objArr) {
                        this.COUIBaseListPopupWindow_12$0.m19540g(objArr);
                    }
                });
            }
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23375ao();
        }
        m19618C(true, false);
        if (m19950ex()) {
            m19855d(false, false, this.f18433bP.m17745c(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public /* synthetic */ void m19592l(Object[] objArr) {
        this.f18375aJ.m21951b(AnimationUtils.loadAnimation(this.f18497i, R.anim.zoom_panel_level_out));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public /* synthetic */ void m19590k(Object[] objArr) {
        m19650a(4, ((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public /* synthetic */ void m19587j(Object[] objArr) {
        mo18236k(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public /* synthetic */ void m19583i(Object[] objArr) {
        mo18068a(4, ((Integer) objArr[0]).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public /* synthetic */ void m19577h(Object[] objArr) {
        m19650a(4, ((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public /* synthetic */ void m19540g(Object[] objArr) {
        mo18236k(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fh */
    public boolean m19518fh() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10738aq();
    }

    /* renamed from: ak */
    public void m19712ak(boolean z) {
        CameraUIListener cameraUIListener;
        CameraUIListener cameraUIListener2;
        CameraControlUI viewOnClickListenerC3199a;
        if (this.f18514z != null && this.f18349J.mo10808by()) {
            mo18288z(true);
            this.f18514z.m19218y();
        }
        CameraUIListener cameraUIListener3 = this.f18349J;
        if (cameraUIListener3 != null) {
            if (cameraUIListener3.mo10859k()) {
                m19520fj();
                if (this.f18349J.mo10738aq()) {
                    m19650a(0, 0.0f, this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.zoom_linkage_translate));
                }
                if (Util.m24352ao() && (viewOnClickListenerC3199a = this.f18514z) != null) {
                    viewOnClickListenerC3199a.m19077a((byte) 2, true);
                }
            } else if (!this.f18349J.mo10814c()) {
                if (this.f18349J.mo10738aq()) {
                    this.f18500l.mo16411a().mo16527a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$g00CsLAAaszO-zgZ2W_K888s7lg
                        @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                        public final void call(Object[] objArr) throws Resources.NotFoundException {
                            this.COUIBaseListPopupWindow_12$0.m19483f(objArr);
                        }
                    }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$cPPw6xiAoSBKWnsy0T5nKm16tsI
                        @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                        public final void call(Object[] objArr) {
                            this.COUIBaseListPopupWindow_12$0.m19465e(objArr);
                        }
                    }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$zx8FXW_UYVZPxISuTbJVrt65vTM
                        @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                        public final void call(Object[] objArr) {
                            this.COUIBaseListPopupWindow_12$0.m19460d(objArr);
                        }
                    });
                } else {
                    this.f18500l.mo16411a().mo16527a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$4FdB5WcoivTm7faltDqQ4ULKjC4
                        @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                        public final void call(Object[] objArr) {
                            this.COUIBaseListPopupWindow_12$0.m19456c(objArr);
                        }
                    }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$nVy6BBaD4BIGUwL1UI0I9YMs70k
                        @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                        public final void call(Object[] objArr) {
                            this.COUIBaseListPopupWindow_12$0.m19451b(objArr);
                        }
                    }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$0l0b2x_FP4Fteftjd9AAkRMD6ic
                        @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                        public final void call(Object[] objArr) {
                            this.COUIBaseListPopupWindow_12$0.m19399a(objArr);
                        }
                    });
                }
            }
        }
        if (this.f18340A != null && (cameraUIListener2 = this.f18349J) != null && cameraUIListener2.mo10808by() && this.f18459bp) {
            CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
            viewOnLayoutChangeListenerC3444g.m23342a((View) viewOnLayoutChangeListenerC3444g.m23376ap(), this.f18349J.mo10809bz(), true);
        }
        CameraUIListener cameraUIListener4 = this.f18349J;
        if (cameraUIListener4 != null && cameraUIListener4.mo10808by() && this.f18461br) {
            m19618C(true, true);
        }
        if (this.f18377aL != null && z && !mo19900dr() && !this.f18503o && 1 != mo18134aX() && (cameraUIListener = this.f18349J) != null && !cameraUIListener.mo10864l()) {
            m19992z(true, true);
        }
        CameraUIListener cameraUIListener5 = this.f18349J;
        if (cameraUIListener5 == null || !cameraUIListener5.mo10796bm() || mo19900dr()) {
            return;
        }
        mo18228i(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public /* synthetic */ void m19483f(Object[] objArr) throws Resources.NotFoundException {
        m19519fi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public /* synthetic */ void m19465e(Object[] objArr) {
        m19650a(0, ((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m19460d(Object[] objArr) {
        m19992z(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m19456c(Object[] objArr) {
        m19375Z(((Integer) objArr[0]).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m19451b(Object[] objArr) {
        m19650a(0, ((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m19399a(Object[] objArr) {
        m19992z(true, true);
    }

    /* renamed from: Z */
    private void m19375Z(int OplusGLSurfaceView_13) {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g == null || !c3282g.isEffectMenuOpen()) {
            BlurMenu c3278c = this.f18400ai;
            if (c3278c == null || !c3278c.isEffectMenuOpen()) {
                CameraUIListener cameraUIListener = this.f18349J;
                if ((cameraUIListener == null || !cameraUIListener.mo10739ar()) && !mo19966j(CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) {
                    if (this.f18340A.m23427u() && this.f18350K == 2) {
                        return;
                    }
                    CameraUIListener cameraUIListener2 = this.f18349J;
                    if (cameraUIListener2 == null || !cameraUIListener2.mo10740as()) {
                        CameraUIListener cameraUIListener3 = this.f18349J;
                        if ((cameraUIListener3 != null && cameraUIListener3.mo10764bG() && mo18111aA()) || 3 == this.f18350K) {
                            return;
                        }
                        CameraUIListener cameraUIListener4 = this.f18349J;
                        if ((cameraUIListener4 == null || !cameraUIListener4.mo10768bK()) && this.f18349J != null) {
                            m19959h(this.f18352M, false);
                            mo18068a(0, OplusGLSurfaceView_13);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: fi */
    private void m19519fi() throws Resources.NotFoundException {
        FilterEffectMenu c3282g;
        if ((this.f18349J.mo10741at() && this.f18349J.mo10848h(CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) || mo18111aA() || this.f18349J.mo10739ar() || (c3282g = this.f18399ah) == null || c3282g.isEffectMenuOpen()) {
            return;
        }
        if ((this.f18460bq || !this.f18349J.mo10808by()) && !this.f18349J.mo10768bK()) {
            this.f18375aJ.m21944a(AnimationUtils.loadAnimation(this.f18497i, R.anim.zoom_panel_level_in));
        }
    }

    /* renamed from: fj */
    private void m19520fj() {
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae == null || c3434ae.m23059h()) {
            return;
        }
        mo18096a((Float) null, this.f18343D.m23056e(), this.f18343D.m23057f(), true);
    }

    /* renamed from: B */
    public void m19616B(boolean z, boolean z2) {
        if (z) {
            mo18263r(true);
        }
        this.f18357R = -1;
        m19431ag(this.f18354O);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo18221h(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19195n(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: da */
    public void m19883da() {
        if (m19787bz()) {
            m19848cy();
        }
        if (Util.m24498u()) {
            mo18258q();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19729b(int OplusGLSurfaceView_13, String str) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19082a(OplusGLSurfaceView_13, str);
        }
    }

    /* renamed from: db */
    public void m19884db() {
        if (this.f18349J.mo10707aL() == 0) {
            this.f18349J.mo10690a(false, false);
        }
    }

    /* renamed from: al */
    public void m19713al(boolean z) {
        mo18215g(4);
        mo18167b(4, z);
        mo18209f(8);
        mo18068a(8, 1);
        m19794c(true, 0);
        mo18191c(false, false);
        mo18107a(true, false);
        mo18213f(false, false);
        mo18193d(8);
        mo18190c(false);
        mo18279v(false);
        mo18052P(false);
        if (mo18023A()) {
            mo18267s(false);
        } else {
            mo18259q(false);
        }
        BlurMenu c3278c = this.f18400ai;
        if ((c3278c != null && c3278c.isMenuOpen()) || m19821cX()) {
            mo18176b(false, true, false, false);
            mo18223h(false, false);
        } else {
            mo18223h(true, false);
        }
        mo18232j(true, false);
        mo18210f(17, true);
        mo18210f(20, true);
    }

    /* renamed from: dc */
    public void m19885dc() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19114aa();
        }
    }

    /* renamed from: dd */
    public void m19886dd() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19115ab();
        }
    }

    /* renamed from: de */
    public void m19887de() {
        if (this.f18340A == null || mo18057R()) {
            return;
        }
        this.f18340A.m23326a();
    }

    /* renamed from: df */
    public void m19888df() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23386c();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ac */
    public void mo18139ac() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23377b();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18089a(DetectResult c3077a) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23347a(c3077a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19733b(final DetectResult c3077a) {
        CameraLog.m12954a("CameraUIManager", "executeSuperTextFrameColorAnimation");
        if (this.f18340A != null) {
            CameraLog.m12953a("CameraUIManager", this.f18483cm, "CameraUIManager");
            this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.46
                @Override // java.lang.Runnable
                public void run() {
                    CameraLog.m12954a("CameraUIManager", "executeSuperTextFrameColorAnimation, in handler");
                    CameraUIManager.this.f18340A.m23382b(c3077a);
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18177b(int... iArr) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19109a(iArr);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19856d(int... iArr) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19148b(iArr);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m19961i(int OplusGLSurfaceView_13, int i2) {
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22039a(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo18246n(int OplusGLSurfaceView_13) {
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22055g(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ah */
    public void mo18144ah() throws Resources.NotFoundException {
        if (this.f18514z != null) {
            View viewFindViewById = this.f18497i.findViewById(R.id_renamed.movie_mode_back);
            View viewFindViewById2 = this.f18497i.findViewById(R.id_renamed.movie_menu_id);
            View viewFindViewById3 = this.f18497i.findViewById(R.id_renamed.switch_camera_bar);
            if (!Util.m24498u()) {
                m19658a(0, 180L, 0L, (TimeInterpolator) null, (Animator.AnimatorListener) null);
            }
            FilmAnimatorUtil.m13478a(true);
            FilmAnimatorUtil.m13469a(this.f18365Z, m19744bD(), this.f18514z.m19208s(), this.f18514z.m19131ar(), viewFindViewById, viewFindViewById2, viewFindViewById3, this.f18351L);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ai */
    public void mo18145ai() throws Resources.NotFoundException {
        if (this.f18514z != null) {
            View viewFindViewById = this.f18497i.findViewById(R.id_renamed.movie_mode_back);
            View viewFindViewById2 = this.f18497i.findViewById(R.id_renamed.movie_menu_id);
            View viewFindViewById3 = this.f18497i.findViewById(R.id_renamed.switch_camera_bar);
            m19658a(4, 180L, 0L, (TimeInterpolator) null, (Animator.AnimatorListener) null);
            FilmAnimatorUtil.m13470a(this.f18365Z, m19744bD(), this.f18514z.m19208s(), this.f18514z.m19131ar(), this.f18447bd, this.f18514z.m19132as(), viewFindViewById, viewFindViewById2, viewFindViewById3);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ak */
    public void mo18147ak() {
        m19418aS(true);
        m19417aR(true);
        if (this.f18394ac != null && this.f18497i != null) {
            HintManager.PlatformImplementations.kt_3 aVar = this.f18395ad;
            if (aVar != null) {
                aVar.mo18506a();
                this.f18395ad = null;
            }
            this.f18395ad = this.f18394ac.m18471a(this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.xpan_mode_hint_extra_margin), 0);
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22045b(true);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aj */
    public void mo18146aj() {
        m19418aS(false);
        m19417aR(false);
        HintManager.PlatformImplementations.kt_3 aVar = this.f18395ad;
        if (aVar != null) {
            aVar.mo18506a();
            this.f18395ad = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG, reason: merged with bridge method [inline-methods] */
    public void m19418aS(final boolean z) {
        if (this.f18514z == null) {
            CameraLog.m12959b("CameraUIManager", "updateXpanThumbTranslation, no control ui");
            return;
        }
        float COUIBaseListPopupWindow_12 = 0.0f;
        if (z) {
            COUIBaseListPopupWindow_12 = TextUtilsCompat.m2525a(Locale.getDefault()) == 0 ? this.f18501m : this.f18501m * (-1);
        }
        ThumbImageView thumbImageViewM19208s = this.f18514z.m19208s();
        if (thumbImageViewM19208s != null) {
            if (thumbImageViewM19208s.getTranslationX() != COUIBaseListPopupWindow_12) {
                thumbImageViewM19208s.animate().translationX(COUIBaseListPopupWindow_12).setDuration(200L).start();
                return;
            } else {
                CameraLog.m12954a("CameraUIManager", "updateXpanThumbTranslation, no need translation");
                return;
            }
        }
        CameraLog.m12959b("CameraUIManager", "updateXpanThumbTranslation, thumb view is not ready yet");
        if (mo19880dX()) {
            this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$WlCfc1NCXjHuMmC4k4RXkElpCos
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m19418aS(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aH, reason: merged with bridge method [inline-methods] */
    public void m19417aR(final boolean z) {
        ScreenModeManager c2953g;
        if (this.f18514z == null || this.f18349J == null) {
            return;
        }
        int iM16659b = 270;
        if (!z && (c2953g = this.f18500l) != null) {
            iM16659b = c2953g.m16659b();
        }
        ThumbImageView thumbImageViewM19208s = this.f18514z.m19208s();
        if (thumbImageViewM19208s != null) {
            thumbImageViewM19208s.m18984a(iM16659b, true);
        } else if (mo19880dX()) {
            this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$Kj3OXT1-Giok7yAJ_jnNTypEFeg
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m19417aR(z);
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: al */
    public void mo18148al() {
        int iM19476eX = m19476eX();
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18495c(iM19476eX);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19681a(FilterTexturePreview.PlatformImplementations.kt_3 aVar) {
        this.f18399ah.setFilterCategory(aVar);
    }

    /* renamed from: am */
    public void m19714am(boolean z) {
        this.f18514z.m19146b(z);
    }

    /* renamed from: an */
    public void m19715an(boolean z) {
        this.f18514z.m19155c(z);
    }

    /* renamed from: ao */
    public void m19716ao(boolean z) {
        this.f18399ah.m20886e(z);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI.PlatformImplementations.kt_3
    /* renamed from: dg */
    public ArrayList<String> mo19889dg() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            return c3335o.m21533K();
        }
        return new ArrayList<>();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI.PlatformImplementations.kt_3
    /* renamed from: ap */
    public void mo19717ap(boolean z) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21561b(z, true);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo19694a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21562b(z, z2, OplusGLSurfaceView_13);
            this.f18347H.m21561b(z, false);
        }
    }

    /* renamed from: dh */
    public void m19890dh() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || this.f18504p) {
            return;
        }
        cameraUIListener.mo10669W();
    }

    /* renamed from: aq */
    public void m19718aq(boolean z) {
        if (z) {
            ViewStub viewStub = (ViewStub) this.f18497i.findViewById(R.id_renamed.statement_background_stub);
            if (viewStub != null) {
                viewStub.inflate();
                this.f18393ab = this.f18497i.findViewById(R.id_renamed.statement_background_container);
            }
            View view = this.f18393ab;
            if (view != null) {
                view.setBackgroundColor(Util.m24353ap() ? -16777216 : -1);
                return;
            }
            return;
        }
        View view2 = this.f18393ab;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI.PlatformImplementations.kt_3
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo19971m(String str) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21571d(str);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI.PlatformImplementations.kt_3
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo19973n(String str) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21574e(str);
        }
    }

    /* renamed from: H */
    public void m19624H(int OplusGLSurfaceView_13) {
        this.f18341B.edit().putInt(CameraUIInterface.KEY_FACE_BEAUTY_LAST_TAB_INDEX, OplusGLSurfaceView_13).apply();
    }

    /* renamed from: ar */
    public void m19719ar(boolean z) {
        AiHintUI c3439b = this.f18454bk;
        if (c3439b == null || 1 != c3439b.m23168a()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_SCENE_ULTRA_WIDE_HINT) && m19630N(this.f18354O)) {
                m19431ag(this.f18356Q);
                return;
            }
            return;
        }
        if (!z) {
            this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$HLY4M2Tg0ZnJS0EECYu5N09rA6c
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m19542gB();
                }
            });
        } else {
            m19431ag(this.f18356Q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gB */
    public /* synthetic */ void m19542gB() {
        mo18239l(true);
    }

    /* renamed from: di */
    public void m19891di() {
        this.f18511w = true;
    }

    /* renamed from: dj */
    public void m19892dj() {
        this.f18394ac.m18489a(R.string.hint_ratio_4_3);
        this.f18394ac.m18489a(R.string.hint_ratio_full);
        this.f18394ac.m18489a(R.string.hint_ratio_14_15);
        this.f18394ac.m18489a(R.string.hint_ratio_16_9);
        this.f18394ac.m18489a(R.string.hint_ratio_1_1);
    }

    /* renamed from: as */
    public void m19720as(boolean z) {
        this.f18512x = z;
    }

    /* renamed from: dk */
    public void m19893dk() {
        String strMo10701aF;
        CameraDrawerSettingUI c3326f;
        if (this.f18495cy.mo20015g()) {
            BlurMenu c3278c = this.f18400ai;
            if (c3278c != null && !c3278c.isMenuOpen() && (c3326f = this.f18348I) != null && c3326f.m21413c()) {
                this.f18348I.m21403a(8);
            }
            strMo10701aF = CameraUIInterface.KEY_VIDEO_BLUR_MENU;
        } else if (this.f18495cy.mo20016h()) {
            strMo10701aF = CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU;
        } else {
            strMo10701aF = this.f18495cy.mo20010b() ? this.f18349J.mo10701aF() : "";
        }
        if (m19978s(strMo10701aF)) {
            ExpandableMenuPanel c3337q = this.f18376aK;
            if (c3337q instanceof BlurMenu) {
                ((BlurMenu) c3337q).showMenuPanelWithoutAnim(strMo10701aF, false, true);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19851d(Size size) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23338a(size);
            this.f18483cm.postDelayed(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.47
                @Override // java.lang.Runnable
                public void run() {
                    CameraScreenNail c3445hMo18183c = CameraUIManager.this.mo18183c();
                    if (c3445hMo18183c != null) {
                        c3445hMo18183c.m23492w();
                        c3445hMo18183c.m23489t();
                    } else {
                        CameraLog.m12967f("CameraUIManager", "showRearMirrorBlurAnim, screenNail is null");
                    }
                }
            }, 400L);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: be */
    public boolean mo18182be() {
        if (this.f18349J.mo10848h(CameraFunction.OUT_PREVIEW_ENABLE) && mo19936ej().mo16577n()) {
            return this.f18469bz.m18343a(this.f18341B);
        }
        return false;
    }

    /* renamed from: dl */
    public void m19894dl() {
        OutScreenButtonBoxView outScreenButtonBoxView = this.f18469bz;
        if (outScreenButtonBoxView != null) {
            outScreenButtonBoxView.m18342a();
        }
        this.f18498j.m16454c();
    }

    /* renamed from: dm */
    public void m19895dm() {
        if (this.f18349J.mo10848h(CameraFunction.OUT_PREVIEW_ENABLE) && mo19936ej().mo16577n()) {
            this.f18498j.m16449a(this.f18497i, this.f18365Z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m19796c(MotionEvent motionEvent) {
        return motionEvent != null && motionEvent.getDownTime() == this.f18472cb;
    }

    /* compiled from: CameraUIManager.java */
    /* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements ModeTitle.PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        @Override // com.oplus.camera.p172ui.modepanel.ModeTitle.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20059a() {
            CameraUIManager.this.f18349J.mo10862l((String) null);
        }
    }

    /* renamed from: fk */
    private void m19521fk() {
        ScreenModeManager c2953g;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            this.f18373aH = new PIAISceneUI(this.f18497i, this.f18365Z, this.f18341B);
        } else {
            this.f18373aH = new NormalAISceneUI(this.f18497i, this.f18365Z, this.f18341B);
        }
        this.f18394ac.m18486a(this.f18373aH);
        this.f18373aH.mo22214a(this.f18479ci);
        this.f18373aH.mo22213a(this.f18482cl);
        this.f18373aH.mo22208a(this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.camera_up_hint_margin_top) - this.f18373aH.mo22207a());
        if (Util.m24495t() && (c2953g = this.f18500l) != null) {
            this.f18373aH.mo22231h(c2953g.mo16411a().mo16539j());
        }
        this.f18358S = this.f18373aH.mo22207a();
    }

    /* renamed from: fl */
    private void m19522fl() throws Resources.NotFoundException {
        if (this.f18375aJ == null) {
            this.f18375aJ = new ModePanelUIControl(this.f18497i, this.f18514z.m19071U());
            this.f18375aJ.m21946a(new PlatformImplementations.kt_3());
            this.f18375aJ.m21948a(false);
            this.f18375aJ.m21943a(mo18134aX(), mo19935ei());
        }
    }

    /* renamed from: o */
    public void m19974o(String str) {
        if (this.f18375aJ != null) {
            if (!(Util.m24498u() && mo19881dY()) && mo19881dY()) {
                return;
            }
            this.f18375aJ.m21947a(str);
        }
    }

    /* renamed from: dn */
    public String m19896dn() {
        ModePanelUIControl c3355m = this.f18375aJ;
        return c3355m != null ? c3355m.m21942a() : "";
    }

    /* renamed from: do */
    public void m19897do() {
        if (this.f18375aJ == null || mo19881dY() || m19861dE()) {
            return;
        }
        this.f18375aJ.m21950b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m19736b(boolean z, int OplusGLSurfaceView_13) {
        ModePanelUIControl c3355m;
        boolean z2 = 4 == mo18134aX();
        if ((mo19881dY() && !z2) || mo19880dX() || m19861dE() || (c3355m = this.f18375aJ) == null) {
            return;
        }
        c3355m.m21949a(z, OplusGLSurfaceView_13);
    }

    /* renamed from: I */
    public void m19625I(int OplusGLSurfaceView_13) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19162e(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19671a(Animation animation) throws Resources.NotFoundException {
        if (this.f18375aJ == null || mo19881dY()) {
            return;
        }
        this.f18375aJ.m21944a(animation);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19794c(boolean z, int OplusGLSurfaceView_13) {
        ModePanelUIControl c3355m = this.f18375aJ;
        if (c3355m != null) {
            c3355m.m21953b(z, OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18105a(boolean z) {
        ModePanelUIControl c3355m = this.f18375aJ;
        if (c3355m != null) {
            c3355m.m21952b(z);
        }
    }

    /* renamed from: dp */
    public boolean m19898dp() {
        ModePanelUIControl c3355m = this.f18375aJ;
        if (c3355m != null) {
            return c3355m.m21955d();
        }
        return false;
    }

    /* renamed from: dq */
    public boolean m19899dq() {
        ModePanelUIControl c3355m = this.f18375aJ;
        return c3355m != null && c3355m.m21956e();
    }

    /* renamed from: at */
    public void m19721at(boolean z) {
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22042a(z);
        }
    }

    /* renamed from: J */
    public void m19626J(int OplusGLSurfaceView_13) {
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22043b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: K */
    public void m19627K(int OplusGLSurfaceView_13) {
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22046c(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: p */
    public void mo18255p(boolean z) {
        FilterEffectMenu c3282g;
        CameraLog.m12954a("CameraUIManager", "hideAllCameraView");
        if (z && (c3282g = this.f18399ah) != null) {
            c3282g.m20888f(false);
        }
        this.f18347H.mo21412c(false);
        this.f18347H.mo21407a(false, false);
        mo18045L(false);
        this.f18348I.mo21407a(false, false);
        mo18259q(false);
        mo18232j(false, false);
        mo18190c(false);
        mo18279v(false);
        this.f18514z.m19158d(false);
        if (this.f18350K != 1) {
            this.f18514z.m19178i(8);
            this.f18514z.m19186k(false);
        }
        this.f18514z.m19176h(false, false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: H */
    public void mo18036H() {
        m19722au(false);
        mo18200d(true, false);
    }

    /* renamed from: au */
    public void m19722au(boolean z) {
        CameraUIListener cameraUIListener;
        if (this.f18350K != 3 || 1 != mo19936ej().mo16539j() || !z || !mo18159aw()) {
            this.f18347H.mo21420m();
            this.f18348I.mo21420m();
        }
        mo18263r(true);
        if (!z && (cameraUIListener = this.f18349J) != null) {
            this.f18514z.m19108a(true, cameraUIListener != null && cameraUIListener.mo10743av(), this.f18349J.mo10808by());
        }
        if (this.f18350K != 1) {
            this.f18514z.m19178i(0);
            this.f18514z.m19186k(true);
        }
        if (this.f18399ah.isEffectMenuOpen()) {
            CameraLog.m12954a("CameraUIManager", "showAllCameraView, mEffectLevelMenu is open, hideRollGLSurfaceView");
            m19988y(0);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: dr */
    public boolean mo19900dr() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10814c();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo19656a(int OplusGLSurfaceView_13, int i2, boolean z) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10748b(OplusGLSurfaceView_13, i2);
        }
        if (!Util.m24498u() || z) {
            m19964j(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m19964j(int OplusGLSurfaceView_13, int i2) {
        if (this.f18500l != null && 3 == mo18134aX()) {
            if (-1 == OplusGLSurfaceView_13 || -1 == i2) {
                if (this.f18340A == null) {
                    return;
                }
                Size sizeM19747bG = m19747bG();
                int width = sizeM19747bG.getWidth();
                i2 = sizeM19747bG.getHeight();
                OplusGLSurfaceView_13 = width;
            }
            Rect rectM19967k = m19967k(OplusGLSurfaceView_13, i2);
            InverseManager.INS.setMaskSplitScreenYOffset(this.f18497i, (rectM19967k.top + rectM19967k.bottom) / 2.0f);
        }
        if (this.f18500l != null && this.f18497i != null) {
            InverseManager.INS.setMaskRadius(this.f18497i, m19646a(this.f18352M, this.f18500l.mo16411a()));
            return;
        }
        CameraLog.m12967f("CameraUIManager", "updateInvserseMaskViewUI, mScreenModeManager: " + this.f18500l + ", mActivity: " + this.f18497i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m19646a(int OplusGLSurfaceView_13, BaseScreenMode abstractC2934a) {
        if (3 == abstractC2934a.mo16539j()) {
            if (OplusGLSurfaceView_13 == 0) {
                return this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius_split_screen_4_3);
            }
            return this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius_split_screen);
        }
        if (1 == abstractC2934a.mo16539j()) {
            if (1 == OplusGLSurfaceView_13) {
                return this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius_16_9);
            }
            return this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius);
        }
        if (4 == abstractC2934a.mo16539j()) {
            return this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius_rack_screen);
        }
        return this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius);
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ds */
    public String mo19901ds() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10744aw();
        }
        return null;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: dt */
    public void mo19902dt() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10746ay();
        }
    }

    /* renamed from: L */
    public void m19628L(int OplusGLSurfaceView_13) {
        if (mo19839cp()) {
            if (!m19426ad(OplusGLSurfaceView_13)) {
                m19524fn();
            } else if (m19904dv()) {
                m19525fo();
            }
            if (!m19428ae(OplusGLSurfaceView_13)) {
                m19526fp();
            } else if (m19905dw()) {
                m19527fq();
            }
            if (m19423ac(OplusGLSurfaceView_13)) {
                m19711aj(true);
                if (m19420aa(OplusGLSurfaceView_13)) {
                    m19531fu();
                } else if (!m19422ab(OplusGLSurfaceView_13)) {
                    if (this.f18509u) {
                        if (m19485fA()) {
                            m19533fw();
                        } else {
                            m19532fv();
                        }
                    } else if (m19486fB()) {
                        m19534fx();
                    }
                }
            } else if (18 == OplusGLSurfaceView_13) {
                m19530ft();
            } else {
                m19529fs();
            }
            if (!m19430af(OplusGLSurfaceView_13)) {
                m19535fy();
            } else if (m19907dy()) {
                m19536fz();
            }
        }
    }

    /* renamed from: du */
    public void m19903du() {
        m19523fm();
        if (mo19839cp()) {
            if (m19904dv()) {
                m19525fo();
            }
            if (m19905dw()) {
                m19527fq();
            }
            if (this.f18509u) {
                if (m19485fA()) {
                    m19533fw();
                } else {
                    m19532fv();
                }
            } else if (m19486fB()) {
                m19534fx();
            }
            if (m19907dy()) {
                m19536fz();
            }
        }
    }

    /* renamed from: fm */
    private void m19523fm() {
        this.f18455bl = true;
        this.f18456bm = true;
        this.f18457bn = true;
        this.f18357R = -1;
        mo18239l(true);
    }

    /* renamed from: fn */
    private void m19524fn() {
        m19450b(CameraUIInterface.KEY_FLASH_MODE, this.f18497i.getString(R.string.camera_flash_mode_default_value), "off");
    }

    /* renamed from: fo */
    private void m19525fo() {
        CameraUIListener cameraUIListener = this.f18349J;
        m19397a(CameraUIInterface.KEY_FLASH_MODE, this.f18497i.getString(R.string.camera_flash_mode_default_value), cameraUIListener != null ? cameraUIListener.mo10715aT() : true);
    }

    /* renamed from: fp */
    private void m19526fp() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            m19450b(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, cameraUIListener.mo10653G()), "off");
        }
    }

    /* renamed from: fq */
    private void m19527fq() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            m19397a(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, cameraUIListener.mo10653G()), true);
        }
    }

    /* renamed from: fr */
    private String m19528fr() {
        return CameraEntry.m13299b(CameraUIInterface.KEY_COMMON_CUSTOM_BEAUTY[0], this.f18350K);
    }

    /* renamed from: fs */
    private void m19529fs() {
        if (this.f18509u) {
            if (m19485fA()) {
                m19533fw();
            } else {
                m19532fv();
            }
        }
        if (!m19486fB() || this.f18377aL.isEnabled()) {
            String strM19528fr = m19528fr();
            String strM19975p = m19975p(strM19528fr);
            int OplusGLSurfaceView_13 = this.f18341B.getInt(strM19528fr, 0);
            this.f18509u = false;
            SharedPreferences.Editor editorEdit = this.f18341B.edit();
            editorEdit.putInt(strM19528fr, 0);
            editorEdit.putInt(strM19975p, OplusGLSurfaceView_13);
            editorEdit.apply();
            this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.48
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraUIManager.this.f18349J != null) {
                        CameraUIManager.this.m19962i(0, false);
                        CameraUIManager.this.f18349J.onFaceBeautyItemChange(0);
                    }
                }
            });
            CameraLog.m12959b("CameraUIManager", "disableFaceBeautyByAiScene, nowIndex: " + OplusGLSurfaceView_13);
        }
    }

    /* renamed from: ft */
    private void m19530ft() {
        if (this.f18509u) {
            if (m19485fA()) {
                m19533fw();
            } else {
                m19532fv();
            }
        }
        if (m19486fB()) {
            return;
        }
        String strM19528fr = m19528fr();
        String strM19975p = m19975p(strM19528fr);
        int OplusGLSurfaceView_13 = this.f18341B.getInt(strM19528fr, 0);
        this.f18509u = false;
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        editorEdit.putInt(strM19528fr, 0);
        editorEdit.putInt(strM19975p, OplusGLSurfaceView_13);
        editorEdit.apply();
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.49
            @Override // java.lang.Runnable
            public void run() {
                if (CameraUIManager.this.f18349J != null) {
                    CameraUIManager.this.f18349J.onFaceBeautyItemChange(0);
                }
            }
        });
        m19711aj(false);
        CameraLog.m12959b("CameraUIManager", "disableTabFaceViewByAiScene, nowIndex: " + OplusGLSurfaceView_13);
    }

    /* renamed from: fu */
    private void m19531fu() {
        String strM19528fr = m19528fr();
        String strM19975p = m19975p(strM19528fr);
        int OplusGLSurfaceView_13 = this.f18341B.getInt(strM19528fr, 0);
        int i2 = this.f18341B.getInt(strM19975p, Integer.MIN_VALUE);
        this.f18509u = true;
        final int i3 = (Integer.MIN_VALUE == i2 || i2 == 0) ? 40 : i2;
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        if (Integer.MIN_VALUE == i2) {
            editorEdit.putInt(strM19975p, OplusGLSurfaceView_13);
        }
        editorEdit.putInt(strM19528fr, i3);
        editorEdit.apply();
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.50
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.m19962i(i3, true);
                if (CameraUIManager.this.f18349J != null) {
                    CameraUIManager.this.f18349J.onFaceBeautyItemValueChange(0, i3, false);
                    if (i3 != 0) {
                        CameraUIManager.this.f18349J.onFaceBeautyItemChange(102);
                    }
                }
            }
        });
        CameraLog.m12959b("CameraUIManager", "openFaceBeautyByAIScene, nowValueIndex: " + OplusGLSurfaceView_13 + ", recordDisableValue: " + i2 + ", valueIndex: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fv */
    public void m19532fv() {
        String strM19975p = m19975p(m19528fr());
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        editorEdit.remove(strM19975p);
        editorEdit.apply();
    }

    /* renamed from: fw */
    private void m19533fw() {
        String strM19528fr = m19528fr();
        String strM19975p = m19975p(strM19528fr);
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        editorEdit.remove(strM19975p);
        editorEdit.putInt(strM19528fr, 0);
        editorEdit.apply();
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.51
            @Override // java.lang.Runnable
            public void run() {
                if (CameraUIManager.this.mo18043K() && CameraUIManager.this.f18399ah != null && !CameraUIManager.this.f18399ah.isEffectMenuOpen()) {
                    CameraUIManager.this.mo18109a(true, true, true, true);
                }
                CameraUIManager.this.m19517fg();
                if (CameraUIManager.this.f18349J != null) {
                    CameraUIManager.this.f18349J.onFaceBeautyItemChange(0);
                }
                if (CameraUIManager.this.m19486fB()) {
                    CameraUIManager.this.f18377aL.setEnabled(false);
                }
            }
        });
        CameraLog.m12959b("CameraUIManager", "setBeautyToOpenBeforeByAIScene");
    }

    /* renamed from: fx */
    private void m19534fx() {
        String strM19528fr = m19528fr();
        String strM19975p = m19975p(strM19528fr);
        final int OplusGLSurfaceView_13 = this.f18341B.getInt(strM19975p, 0);
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        if (OplusGLSurfaceView_13 != 0) {
            editorEdit.putInt(strM19528fr, OplusGLSurfaceView_13);
        }
        editorEdit.remove(strM19975p);
        editorEdit.apply();
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.52
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.m19962i(OplusGLSurfaceView_13, true);
                if (CameraUIManager.this.f18349J != null) {
                    CameraUIManager.this.f18349J.onFaceBeautyItemValueChange(0, OplusGLSurfaceView_13, false);
                    if (OplusGLSurfaceView_13 != 0) {
                        CameraUIManager.this.f18349J.onFaceBeautyItemChange(102);
                    }
                }
            }
        });
        CameraLog.m12959b("CameraUIManager", "openFaceBeautyByAIScene, lastValueIndex: " + OplusGLSurfaceView_13);
    }

    /* renamed from: fy */
    private void m19535fy() {
        String strM19975p = m19975p(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION);
        String strM19975p2 = m19975p(CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        if (m19976q(strM19975p)) {
            return;
        }
        final String string = this.f18341B.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard");
        boolean z = this.f18341B.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        if (z) {
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard");
            editorEdit.putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
        }
        editorEdit.putString(strM19975p, string);
        editorEdit.putBoolean(strM19975p2, z);
        editorEdit.apply();
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.53
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.mo18099a(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, string);
            }
        });
        CameraLog.m12959b("CameraUIManager", "disableHighResolutionByAiScene, isOpen: " + z + ", nowState: " + string);
    }

    /* renamed from: fz */
    private void m19536fz() {
        String strM19975p = m19975p(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION);
        String strM19975p2 = m19975p(CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        final String string = this.f18341B.getString(strM19975p, "ai_scene_last_default_value");
        boolean z = this.f18341B.getBoolean(strM19975p2, false);
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        if (z) {
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, string);
            editorEdit.putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, true);
        }
        editorEdit.remove(strM19975p);
        editorEdit.remove(strM19975p2);
        editorEdit.apply();
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.55
            @Override // java.lang.Runnable
            public void run() {
                CameraUIManager.this.mo18171b(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, string);
            }
        });
        CameraLog.m12959b("CameraUIManager", "enableHighResolutionByAiScene, lastHighPictureValue: " + z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m19450b(final String str, String str2, final String str3) {
        String strM19975p = m19975p(str);
        if (m19976q(strM19975p)) {
            return;
        }
        final String string = this.f18341B.getString(str, str2);
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        if (!TextUtils.equals(string, str3)) {
            editorEdit.putString(str, str3);
        }
        editorEdit.putString(strM19975p, string);
        editorEdit.apply();
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.56
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.equals(string, str3)) {
                    CameraUIManager.this.mo18099a(str, (String) null);
                } else {
                    CameraUIManager.this.mo18099a(str, str3);
                }
            }
        });
        CameraLog.m12959b("CameraUIManager", "disableByAiScene, disableFunctionKey: " + str + ", nowState: " + string);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19397a(final String str, String str2, boolean z) {
        String strM19975p = m19975p(str);
        String string = this.f18341B.getString(strM19975p, str2);
        SharedPreferences.Editor editorEdit = this.f18341B.edit();
        if (z) {
            editorEdit.putString(str, string);
        }
        editorEdit.remove(strM19975p);
        editorEdit.apply();
        if (z) {
            this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.57
                @Override // java.lang.Runnable
                public void run() {
                    CameraUIManager.this.mo18171b(str, (String) null);
                }
            });
        }
        CameraLog.m12959b("CameraUIManager", "enableByAiScene, enableFunction: " + str + ", lastState: " + string + ", enable: " + z);
    }

    /* renamed from: aa */
    private boolean m19420aa(int OplusGLSurfaceView_13) {
        return m19422ab(OplusGLSurfaceView_13) && this.f18341B.getInt(m19528fr(), 0) == 0;
    }

    /* renamed from: p */
    public String m19975p(String str) {
        return CameraEntry.m13299b(str, this.f18350K) + "_close_by_ai_last_state";
    }

    /* renamed from: dv */
    public boolean m19904dv() {
        return m19976q(m19975p(CameraUIInterface.KEY_FLASH_MODE));
    }

    /* renamed from: dw */
    public boolean m19905dw() {
        return m19976q(m19975p(CameraUIInterface.KEY_CAMERA_HDR_MODE));
    }

    /* renamed from: dx */
    public boolean m19906dx() {
        return m19976q(m19975p(CameraUIInterface.KEY_FILTER_MENU));
    }

    /* renamed from: dy */
    public boolean m19907dy() {
        return m19976q(m19975p(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION));
    }

    /* renamed from: q */
    public boolean m19976q(String str) {
        CameraLog.m12959b("CameraUIManager", "isDisabledByAiScene, recordDisableStateKey: " + str + ", state: " + this.f18341B.getString(str, "ai_scene_last_default_value"));
        return !TextUtils.equals("ai_scene_last_default_value", r3);
    }

    /* renamed from: fA */
    private boolean m19485fA() {
        String strM19528fr = m19528fr();
        return this.f18341B.getInt(m19975p(strM19528fr), Integer.MIN_VALUE) == 0 && 40 == this.f18341B.getInt(strM19528fr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fB */
    public boolean m19486fB() {
        if (this.f18509u) {
            return false;
        }
        int OplusGLSurfaceView_13 = this.f18341B.getInt(m19975p(m19528fr()), Integer.MIN_VALUE);
        CameraLog.m12959b("CameraUIManager", "isFaceBeautyDisabledByAIScene, lastFaceBeautyIndex: " + OplusGLSurfaceView_13);
        return Integer.MIN_VALUE != OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo18242m(int OplusGLSurfaceView_13) {
        if (this.f18348I.mo21419j() || this.f18483cm == null) {
            return;
        }
        HintManager c3130a = this.f18394ac;
        if (c3130a != null && c3130a.m18497c()) {
            m19488fD();
            return;
        }
        if (18 == OplusGLSurfaceView_13) {
            mo18070a(R.string.camera_ai_scn_microspur, -1, false, true, true);
            return;
        }
        this.f18483cm.removeMessages(2);
        Message messageObtainMessage = this.f18483cm.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.obj = Integer.valueOf(OplusGLSurfaceView_13);
        this.f18356Q = OplusGLSurfaceView_13;
        this.f18483cm.sendMessage(messageObtainMessage);
        m19431ag(OplusGLSurfaceView_13);
    }

    /* renamed from: ag */
    private void m19431ag(int OplusGLSurfaceView_13) {
        int i2;
        SuperColorToolTips c3520c;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_SCENE_ULTRA_WIDE_HINT)) {
            if (m19630N(OplusGLSurfaceView_13) && this.f18349J.mo10839f(CameraUIInterface.KEY_PI_AI) && "on".equals(this.f18341B.getString(CameraUIInterface.KEY_PI_AI, "off")) && this.f18455bl && (((c3520c = this.f18414aw) == null || !c3520c.isShowing()) && this.f18349J.mo10691a(1, OplusGLSurfaceView_13))) {
                CameraTipsManager.m14374a().m14377b(2);
            } else {
                AiHintUI c3439b = this.f18454bk;
                if (c3439b != null && c3439b.m23173b() && 1 == this.f18454bk.m23168a()) {
                    this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$MSpF5tMPs5yBwfuR1aZP7LrZETY
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.COUIBaseListPopupWindow_12$0.m19541gA();
                        }
                    });
                }
            }
        }
        if (this.f18456bm && 4 == OplusGLSurfaceView_13 && this.f18349J.mo10691a(0, OplusGLSurfaceView_13)) {
            CameraTipsManager.m14374a().m14377b(3);
        } else {
            AiHintUI c3439b2 = this.f18454bk;
            if (c3439b2 != null && c3439b2.m23173b() && 4 == this.f18357R && this.f18454bk.m23168a() == 0) {
                this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$pOzZBTs5iV1Xa9JGrSbpXWKTizM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m19574gz();
                    }
                });
            }
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_SCENE_PORTRAIT_HINT)) {
            if (this.f18457bn && ((10 == OplusGLSurfaceView_13 || 16 == OplusGLSurfaceView_13) && this.f18349J.mo10691a(2, OplusGLSurfaceView_13))) {
                CameraTipsManager.m14374a().m14377b(4);
            } else {
                AiHintUI c3439b3 = this.f18454bk;
                if (c3439b3 != null && c3439b3.m23173b() && ((10 == (i2 = this.f18357R) || 16 == i2) && 2 == this.f18454bk.m23168a())) {
                    this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$nEbVk7MKOj3o9JQSbxQ-HBon5pM
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.COUIBaseListPopupWindow_12$0.m19573gy();
                        }
                    });
                }
            }
        }
        this.f18357R = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gA */
    public /* synthetic */ void m19541gA() {
        mo18239l(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gz */
    public /* synthetic */ void m19574gz() {
        mo18239l(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gy */
    public /* synthetic */ void m19573gy() {
        mo18239l(true);
    }

    /* renamed from: M */
    public void m19629M(int OplusGLSurfaceView_13) {
        SuperColorToolTips c3520c;
        if (this.f18349J != null && OplusGLSurfaceView_13 == 0) {
            this.f18483cm.removeMessages(9);
            this.f18483cm.sendEmptyMessage(9);
            return;
        }
        if (this.f18349J != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_SCENE_ULTRA_WIDE_HINT) && (((c3520c = this.f18414aw) == null || !c3520c.isShowing()) && 1 == OplusGLSurfaceView_13)) {
            this.f18483cm.removeMessages(5);
            this.f18483cm.sendEmptyMessage(5);
        } else if (this.f18349J != null && 2 == OplusGLSurfaceView_13) {
            this.f18483cm.removeMessages(11);
            this.f18483cm.sendEmptyMessage(11);
        } else {
            CameraTipsManager.m14374a().m14378c();
        }
    }

    /* renamed from: dz */
    public void m19908dz() {
        Handler handler = this.f18483cm;
        if (handler != null) {
            handler.removeMessages(2);
        }
        boolean z = mo18158av() && this.f18497i != null;
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22215a(z);
            m19857dA();
        }
        this.f18354O = 0;
        this.f18507s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fC */
    public void m19487fC() {
        if (this.f18373aH != null) {
            m19433ah(this.f18354O);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ah */
    public void m19433ah(int OplusGLSurfaceView_13) {
        if (mo19966j(CameraUIInterface.KEY_PI_AI) && mo18059T()) {
            CameraLog.m12962c("CameraUIManager", "updateAISceneViewAndSetUpHint, return");
            return;
        }
        m19436ai(OplusGLSurfaceView_13);
        this.f18373aH.mo22217b();
        if (OplusGLSurfaceView_13 == 0) {
            m19857dA();
        }
    }

    /* renamed from: fD */
    private void m19488fD() {
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18484a(new HintManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.58
                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14771a(HintModel c3131b) {
                }

                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14770a(int OplusGLSurfaceView_13) {
                    int iMo10714aS = CameraUIManager.this.f18349J != null ? CameraUIManager.this.f18349J.mo10714aS() : 0;
                    if (iMo10714aS <= 0 || CameraUIManager.this.mo18131aU()) {
                        return;
                    }
                    CameraUIManager.this.mo18242m(iMo10714aS);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ai */
    public void m19436ai(int OplusGLSurfaceView_13) {
        String string = this.f18341B.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
        if (OplusGLSurfaceView_13 != 0 && !this.f18341B.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false) && "off".equals(string)) {
            mo18108a(true, false, false);
        }
        this.f18373aH.mo22209a(OplusGLSurfaceView_13, this.f18351L, this.f18355P);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ab */
    public void mo18138ab() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            this.f18483cm.removeMessages(2);
        }
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22230h();
            m19857dA();
        }
    }

    /* renamed from: fE */
    private boolean m19489fE() {
        Boolean boolValueOf = Boolean.valueOf(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE));
        CameraUIListener cameraUIListener = this.f18349J;
        Boolean boolValueOf2 = Boolean.valueOf(cameraUIListener != null && cameraUIListener.mo10848h(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU));
        return boolValueOf.booleanValue() ? boolValueOf2.booleanValue() && Boolean.valueOf("on".equals(this.f18341B.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"))).booleanValue() : boolValueOf2.booleanValue() && !Boolean.valueOf(CameraCharacteristicsUtil.m12974a(mo19845cv())).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fF */
    public boolean m19490fF() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || this.f18341B == null || !cameraUIListener.mo10848h(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU) || CameraCharacteristicsUtil.m12974a(mo19845cv())) {
            return false;
        }
        return "on".equals(this.f18341B.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
    }

    /* renamed from: dB */
    public Rect[] m19858dB() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23365ae();
        }
        return null;
    }

    /* renamed from: dC */
    public void m19859dC() {
        this.f18340A.m23321V();
    }

    /* renamed from: dD */
    public void m19860dD() {
        this.f18340A.m23322W();
    }

    /* renamed from: fG */
    private boolean m19491fG() {
        return !this.f18341B.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.f18497i.getString(R.string.camera_tap_shutter_default_value)).equals(this.f18341B.getString(CameraUIInterface.KEY_LAST_CAMERA_TAP_SHUTTER, this.f18497i.getString(R.string.camera_tap_shutter_default_value)));
    }

    /* renamed from: fH */
    private boolean m19492fH() {
        Activity activity;
        ComboPreferences comboPreferences = this.f18341B;
        if (comboPreferences == null || (activity = this.f18497i) == null) {
            return false;
        }
        return "on".equals(comboPreferences.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, activity.getString(R.string.camera_tap_shutter_default_value)));
    }

    /* renamed from: dE */
    public boolean m19861dE() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10768bK();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m19956g(String str, boolean z) {
        ExpandableMenuPanel c3337q = this.f18372aG.get(str);
        if (this.f18347H != null && c3337q != null) {
            if (c3337q.isEffectMenuOpen() && !z && !c3337q.openMenuCanDisableHighLight() && c3337q.isEffectOpen()) {
                this.f18347H.m21559b(str, true);
            } else {
                this.f18347H.m21559b(str, c3337q.isEffectOpen());
            }
        }
        if (this.f18348I == null || c3337q == null) {
            return;
        }
        if (c3337q.isEffectMenuOpen() && !z && !c3337q.openMenuCanDisableHighLight()) {
            this.f18348I.m21559b(str, true);
        } else {
            this.f18348I.m21559b(str, c3337q.isEffectOpen());
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: t */
    public void mo18271t(boolean z) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21581g(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo18216g(String str) {
        m19956g(str, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19686a(String str, ExpandableMenuPanel c3337q) {
        if (c3337q != null && !this.f18372aG.containsKey(str)) {
            this.f18372aG.put(str, c3337q);
        }
        CameraLog.m12954a("CameraUIManager", "addMenuToExpandMenuMap, Map size: " + this.f18372aG.size());
    }

    /* renamed from: O */
    public void m19631O(int OplusGLSurfaceView_13) {
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            c3278c.updateBlurMenuIndex(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: r */
    public void m19977r(String str) {
        if (m19979t(str)) {
            if (str.equals(CameraUIInterface.KEY_FILTER_MENU) && ApsConstant.CAPTURE_MODE_COMMON.equals(this.f18349J.mo10736ao()) && !CameraCharacteristicsUtil.m12974a(mo19845cv())) {
                this.f18341B.edit().putBoolean(CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, true).apply();
            }
            if (this.f18376aK == null) {
                if (m19978s(str)) {
                    this.f18376aK.showMenuPanel(str, false, true);
                    return;
                }
                return;
            }
            CameraLog.m12954a("CameraUIManager", "updateCameraSettingExpandMenu, mCurrentExpandPanel: " + this.f18376aK + ", key: " + str);
            if (str.equals(this.f18376aK.getCurrentMenuKey())) {
                this.f18376aK.hideMenuPanel(true, false);
                return;
            }
            if (ExpandableMenuPanel.DEFALUT_MENU.equals(this.f18376aK.getCurrentMenuKey())) {
                if (m19978s(str)) {
                    this.f18376aK.showMenuPanel(str, false, true);
                    return;
                }
                return;
            }
            ExpandableMenuPanel c3337q = this.f18372aG.get(str);
            this.f18376aK.hideMenuPanel(c3337q == null, c3337q != null);
            if (c3337q != null) {
                if (c3337q.mExpandMenuListener == null) {
                    c3337q.setExpandMenuListener(this.f18496cz);
                }
                c3337q.showMenuPanel(str, true, true);
                return;
            }
            return;
        }
        CameraLog.m12966e("CameraUIManager", "updateCameraSettingExpandMenu, key: " + str);
    }

    /* renamed from: s */
    public boolean m19978s(String str) {
        if (this.f18372aG.get(str) != null && this.f18372aG.get(str).mExpandMenuListener == null) {
            this.f18372aG.get(str).setExpandMenuListener(this.f18496cz);
        }
        this.f18376aK = this.f18372aG.get(str);
        return this.f18376aK != null;
    }

    /* renamed from: t */
    public boolean m19979t(String str) {
        return CameraUIInterface.KEY_FILTER_MENU.equals(str) || CameraUIInterface.KEY_NIGHT_FILTER_MENU.equals(str) || CameraUIInterface.KEY_STREET_FILTER_MENU.equals(str) || CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(str) || CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) || CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str) || CameraUIInterface.KEY_PORTRAIT_BLUR_MENU.equals(str) || CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU.equals(str);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18166b(int OplusGLSurfaceView_13, int i2, int i3, Object... objArr) {
        if (this.f18504p) {
            return;
        }
        AISceneUI abstractC3391a = this.f18373aH;
        if ((abstractC3391a != null && abstractC3391a.mo22232i() && !this.f18373aH.mo22233j()) || this.f18348I.mo21419j() || m19941eo() || mo18057R()) {
            return;
        }
        m19815cR();
        this.f18394ac.m18477a(OplusGLSurfaceView_13, true, false, i2, i3, 0, mo19881dY(), objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aj */
    public void m19437aj(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraUIManager", "exitFromMoreMode");
        if (!mo18057R()) {
            CameraLog.m12959b("CameraUIManager", "exitFromMoreMode, not in MoreMode");
            return;
        }
        if (this.f18514z.m19073W()) {
            CameraLog.m12959b("CameraUIManager", "exitFromMoreMode, Multiple finger operation in Headline");
            this.f18514z.m19201p(false);
            return;
        }
        if (this.f18463bt.m21900a()) {
            CameraLog.m12959b("CameraUIManager", "exitFromMoreMode, do not respond back event in the arranging state.");
            return;
        }
        if (this.f18514z.m19136aw() && this.f18514z.m19137ax()) {
            CameraLog.m12959b("CameraUIManager", "exitFromMoreMode, exit mode arrange.");
            this.f18484cn.mo20025a();
            return;
        }
        this.f18447bd.m22045b(true);
        this.f18514z.m19135av();
        m19410aK(false);
        if (PreferenceManager.m3981a(this.f18497i).getBoolean("mode_arrange_change_panel", false)) {
            CameraUIListener cameraUIListener = this.f18349J;
            if (cameraUIListener != null) {
                cameraUIListener.mo10825d(20);
            }
            m19409aJ(true);
            m19910e(1.0f);
            InverseManager.INS.setMaskAlpha(this.f18497i, true, true);
            InverseManager.INS.setExecuteDelayMsg(true);
            this.f18514z.m19209s(false);
        } else {
            m19723av(true);
        }
        CameraUIListener cameraUIListener2 = this.f18349J;
        if (cameraUIListener2 != null) {
            cameraUIListener2.mo10835f(OplusGLSurfaceView_13);
        }
        m19853d(true, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18176b(boolean z, boolean z2, boolean z3, boolean z4) {
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null && c3278c.isMenuOpen()) {
            this.f18400ai.hideMenu(z, z2, false, z3, z4);
        } else {
            BlurMenu c3278c2 = this.f18384aS;
            if (c3278c2 != null && c3278c2.isMenuOpen()) {
                this.f18384aS.hideMenu(z, z2, false, z3, z4);
            }
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            m19636S(cameraUIListener.mo10709aN() || this.f18349J.mo10710aO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aI */
    public void m19408aI(boolean z) {
        if (this.f18349J == null || this.f18385aT == null) {
            return;
        }
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f18497i);
        menuClickMsgData.buildEvent(false);
        if (this.f18385aT.m20695t() && !this.f18385aT.m20693r() && !this.f18385aT.m20694s()) {
            menuClickMsgData.mFuncKeyId = this.f18349J.mo10747az() ? 64 : 4;
        } else {
            menuClickMsgData.mFuncKeyId = 2;
        }
        menuClickMsgData.mCameraId = this.f18349J.mo10655I();
        menuClickMsgData.mOrientation = this.f18351L;
        menuClickMsgData.mCaptureType = !mo19839cp() ? 1 : 0;
        menuClickMsgData.mCaptureMode = this.f18349J.mo10736ao();
        menuClickMsgData.mCameraEnterType = String.valueOf(this.f18350K);
        if (z) {
            menuClickMsgData.mFuncKeyResult = 1;
        } else {
            menuClickMsgData.mFuncKeyResult = 2;
        }
        menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(menuClickMsgData.mCameraId) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18076a(int OplusGLSurfaceView_13, String str) {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20869a(OplusGLSurfaceView_13, str);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo18238l(int OplusGLSurfaceView_13) {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20881c(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: fI */
    private void m19493fI() {
        if (this.f18447bd == null) {
            this.f18447bd = new MoreUIControl(this.f18497i, this.f18365Z, this.f18351L, this.f18463bt, this.f18500l);
            this.f18447bd.m22041a(this.f18470cA);
            this.f18447bd.m22040a(this.f18484cn);
        }
    }

    /* renamed from: fJ */
    private void m19494fJ() {
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22215a(false);
            m19857dA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aJ */
    public void m19409aJ(boolean z) {
        if (this.f18347H != null) {
            CameraLog.m12954a("CameraUIManager", "showSettingMenu");
            this.f18347H.mo21420m();
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f == null || z) {
            return;
        }
        c3326f.mo21420m();
    }

    /* renamed from: av */
    public void m19723av(boolean z) {
        String string = this.f18341B.getString(CameraUIInterface.KEY_CAMERA_MODE, "");
        boolean zEquals = "on".equals(this.f18341B.getString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.f18497i.getString(R.string.camera_multicamera_type_default)));
        if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(string) && zEquals && m19518fh()) {
            CameraLog.m12954a("CameraUIManager", "backToLastHeadlineIndex, multi camera type menu is open, can't show headline.");
            z = false;
        }
        if (ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(string) && this.f18349J.mo10741at() && this.f18349J.mo10848h(CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) {
            CameraLog.m12954a("CameraUIManager", "backToLastHeadlineIndex, professional mode bar is open, can't show headline.");
            z = false;
        }
        if (this.f18514z != null) {
            CameraLog.m12954a("CameraUIManager", "backToLastHeadlineIndex, show: " + z);
            this.f18514z.m19175h(z);
        }
    }

    /* renamed from: dF */
    public boolean m19862dF() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            return viewOnClickListenerC3199a.m19205q();
        }
        return false;
    }

    /* renamed from: dG */
    public void m19863dG() {
        mo18200d(true, false);
        mo18227i(true);
        if (this.f18349J.mo10795bl()) {
            mo18240l(false, false);
        }
        if (this.f18349J.mo10796bm()) {
            mo18228i(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aK */
    public void m19410aK(boolean z) {
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18499d(z);
        }
        CameraScreenHintView cameraScreenHintView = this.f18404am;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setMoreMode(z);
        }
    }

    /* renamed from: dH */
    public boolean m19864dH() {
        MoreUIControl c3358p = this.f18447bd;
        return c3358p != null && c3358p.m22051e();
    }

    /* renamed from: dI */
    public float m19865dI() {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            return c3335o.m21530H();
        }
        return 1.0f;
    }

    /* renamed from: P */
    public void m19632P(int OplusGLSurfaceView_13) {
        if (this.f18447bd != null) {
            CameraLog.m12954a("CameraUIManager", "showMoreView");
            this.f18447bd.m22048d(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: dJ */
    public void m19866dJ() {
        if (this.f18447bd != null) {
            CameraLog.m12954a("CameraUIManager", "hideMoreView");
            this.f18447bd.m22045b(true);
            this.f18514z.m19135av();
        }
    }

    /* renamed from: dK */
    public void m19867dK() {
        CameraLog.m12954a("CameraUIManager", "onMoreModeShown");
        m19410aK(true);
        mo18052P(false);
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.mo21412c(false);
        }
        m19396a(ApsConstant.REC_MODE_COMMON, CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO, 7);
        m19396a(ApsConstant.CAPTURE_MODE_COMMON, CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE, 9);
        mo18210f(17, true);
        mo18210f(20, true);
        mo18045L(false);
        mo18249o();
        m19838co();
        m19494fJ();
        mo18174b(false);
        mo18282w(false);
        mo18108a(true, true, false);
        mo18232j(false, false);
        mo18176b(true, Util.m24498u(), false, false);
        mo18223h(false, false);
        mo18227i(false);
        mo18024B(false);
        mo18231j(false);
        if (m19950ex()) {
            m19614A(false, false);
            m19854d(false, false, this.f18433bP.m17745c());
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19176h(false, true);
            this.f18514z.m19167f(true);
            InverseManager.INS.setExecuteDelayMsg(false);
            if (InverseManager.INS.isInverseColor(this.f18497i.hashCode()) && !this.f18510v) {
                InverseManager.INS.setInverseColor((Context) this.f18497i, false, true);
                this.f18510v = true;
            }
        }
        m19888df();
        if (mo18059T()) {
            mo18060U();
        }
        m19495fK();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19396a(String str, String str2, int OplusGLSurfaceView_13) {
        CameraUIListener cameraUIListener;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (cameraUIListener = this.f18349J) == null || !str.equals(cameraUIListener.mo10736ao()) || !m19984w(str2)) {
            return;
        }
        mo18210f(OplusGLSurfaceView_13, true);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m19482f(boolean z, int OplusGLSurfaceView_13) {
        if (z) {
            m19961i(OplusGLSurfaceView_13, R.drawable.sticker_red_point);
        } else {
            mo18246n(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: fK */
    private void m19495fK() {
        m19482f(m19497fM(), 2);
        m19482f(m19498fN(), 13);
        m19482f(m19499fO(), 29);
        m19482f(m19501fQ(), 14);
        m19482f(m19505fU(), 18);
        m19482f(m19500fP(), 16);
        m19482f(m19506fV(), 26);
        m19482f(m19507fW(), 27);
        m19482f(m19502fR(), 31);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19853d(boolean z, int OplusGLSurfaceView_13) {
        CameraUIListener cameraUIListener = this.f18349J;
        m19693a(z, cameraUIListener != null ? cameraUIListener.mo10736ao() : null, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19693a(boolean z, String str, int OplusGLSurfaceView_13) {
        this.f18510v = false;
        m19410aK(false);
        mo18200d(true, false);
        m19761bU();
        if (1 != mo18134aX() || !mo19916eD()) {
            m19409aJ(false);
            m19910e(1.0f);
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null && !cameraUIListener.mo10720aY()) {
            mo18227i(true);
        }
        InverseManager.INS.setExecuteDelayMsg(true);
        if (InverseManager.INS.isInverseColor(this.f18497i.hashCode()) && this.f18510v) {
            InverseManager.INS.setMaskAlpha(this.f18497i, true, true);
            this.f18514z.m19209s(false);
            this.f18510v = false;
        }
        CameraUIListener cameraUIListener2 = this.f18349J;
        if (cameraUIListener2 != null && cameraUIListener2.mo10795bl()) {
            mo18240l(false, false);
        }
        CameraUIListener cameraUIListener3 = this.f18349J;
        if (cameraUIListener3 != null && cameraUIListener3.mo10796bm() && !mo18111aA()) {
            mo18228i(false, false);
        }
        CameraUIListener cameraUIListener4 = this.f18349J;
        if (cameraUIListener4 != null && cameraUIListener4.mo10797bn()) {
            mo18252o(false, false);
            mo18260q(false, false);
        }
        if (mo19966j(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            mo18049N(false);
        }
        if (m19938el()) {
            mo18108a(true, false, false);
        }
        if (!m19489fE()) {
            mo18048N();
        } else if (1 != OplusGLSurfaceView_13) {
            mo18046M();
        }
        this.f18514z.m19156c(true, false);
        this.f18514z.m19177i();
        if (m19771bj()) {
            mo18200d(false, false);
        }
    }

    /* renamed from: fL */
    private void m19496fL() {
        if (m19508fX()) {
            m19856d(R.string.camera_mode_more);
        }
        if (m19504fT()) {
            m19856d(R.string.camera_mode_arrange);
        } else {
            mo18177b(R.string.camera_mode_arrange);
        }
    }

    /* renamed from: fM */
    private boolean m19497fM() {
        return this.f18341B != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SLOW_VIDEO_RED_DOT_SUPPORT) && !CameraCharacteristicsUtil.m12974a(Integer.parseInt(this.f18341B.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0)))) && PreferenceManager.m3981a(this.f18497i).getBoolean("slow_video_high_frame_reddot_show", true);
    }

    /* renamed from: fN */
    private boolean m19498fN() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ID_PHOTO) && Util.m24500v(this.f18497i) && PreferenceManager.m3981a(this.f18497i).getBoolean("id_photo_reddot_show", false) && RegionCommonFeatureAdapter.m14538g();
    }

    /* renamed from: fO */
    private boolean m19499fO() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FISH_EYE) && PreferenceManager.m3981a(this.f18497i).getBoolean("fish_eye_reddot_show", true);
    }

    /* renamed from: fP */
    private boolean m19500fP() {
        return CameraConfig.isSupportMicroscope() && PreferenceManager.m3981a(this.f18497i).getBoolean("microscope_reddot_show", true);
    }

    /* renamed from: fQ */
    private boolean m19501fQ() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT) && PreferenceManager.m3981a(this.f18497i).getBoolean("multi_video_reddot_show", false);
    }

    /* renamed from: fR */
    private boolean m19502fR() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HIGH_PIXEL_SUPPORT) && PreferenceManager.m3981a(this.f18497i).getBoolean("mode_high_pixel_reddot_show", true);
    }

    /* renamed from: fS */
    private boolean m19503fS() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) && PreferenceManager.m3981a(this.f18497i).getBoolean("profession_reddot_show", true);
    }

    /* renamed from: fT */
    private boolean m19504fT() {
        return PreferenceManager.m3981a(this.f18497i).getBoolean("mode_arrange_reddot_show", true);
    }

    /* renamed from: fU */
    private boolean m19505fU() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT) && PreferenceManager.m3981a(this.f18497i).getBoolean("double_exposure_reddot_show", true);
    }

    /* renamed from: fV */
    private boolean m19506fV() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STREET_MODE) && PreferenceManager.m3981a(this.f18497i).getBoolean("street_reddot_show", true);
    }

    /* renamed from: fW */
    private boolean m19507fW() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LONG_EXPOSURE_MODE) && PreferenceManager.m3981a(this.f18497i).getBoolean("long_exposure_reddot_show", true);
    }

    /* renamed from: fX */
    private boolean m19508fX() {
        return (m19497fM() || m19498fN() || m19499fO() || m19501fQ() || m19503fS() || m19505fU() || m19500fP() || m19506fV() || m19507fW() || m19502fR()) && PreferenceManager.m3981a(this.f18497i).getBoolean("more_menu_reddot_show", true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: af */
    public boolean mo18142af() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT) && PreferenceManager.m3981a(this.f18497i).getBoolean("multi_video_setting_menu_reddot_show", false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ag */
    public boolean mo18143ag() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) && PreferenceManager.m3981a(this.f18497i).getBoolean("super_raw_setting_menu_reddot_show", true);
    }

    /* renamed from: dL */
    public boolean m19868dL() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT) && PreferenceManager.m3981a(this.f18497i).getBoolean("street_long_exposure_reddot_show", true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ae */
    public boolean mo18141ae() {
        return PreferenceManager.m3981a(this.f18497i).getBoolean("video_filter_reddot_show", true) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ad */
    public boolean mo18140ad() {
        return PreferenceManager.m3981a(this.f18497i).getBoolean("portrait_filter_reddot_show", true) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT);
    }

    /* renamed from: dM */
    public void m19869dM() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19118ae();
        }
    }

    /* renamed from: dN */
    public boolean m19870dN() {
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            return c3358p.m22044b();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: S */
    public boolean mo18058S() {
        MoreUIControl c3358p = this.f18447bd;
        return c3358p != null && c3358p.m22047c();
    }

    /* renamed from: dO */
    public boolean m19871dO() {
        MoreUIControl c3358p = this.f18447bd;
        return c3358p != null && c3358p.m22049d();
    }

    /* renamed from: dP */
    public boolean m19872dP() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            return c3282g.isAnimationRunning();
        }
        return false;
    }

    /* renamed from: dQ */
    public void m19873dQ() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20885e();
        }
    }

    /* renamed from: dR */
    public boolean m19874dR() {
        CaptureCountDownTimeUI c3446i = this.f18344E;
        if (c3446i != null) {
            return c3446i.m23059h();
        }
        return false;
    }

    /* renamed from: dS */
    public boolean m19875dS() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        return viewOnClickListenerC3199a != null && viewOnClickListenerC3199a.m19129ap();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: R */
    public boolean mo18057R() {
        return m19875dS() && m19864dH();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: z */
    public void mo18288z(boolean z) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10828d(z);
        }
    }

    /* renamed from: aw */
    public void m19724aw(boolean z) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10837f(z);
        }
    }

    /* renamed from: dT */
    public void m19876dT() {
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20891i();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: A */
    public void mo18022A(boolean z) {
        if (this.f18503o || this.f18502n) {
            CameraLog.m12966e("CameraUIManager", "updateDimHintView, mbShowCapAlert: " + this.f18503o + ", mbShowVideoAlert: " + this.f18502n);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!z) {
            if (jCurrentTimeMillis - this.f18360U < 3000) {
                CameraLog.m12954a("CameraUIManager", "updateDimHintView, hideDimScreenHint");
                mo18067a(R.string.camera_id_photo_mode_need_more_light);
                return;
            }
            return;
        }
        if (jCurrentTimeMillis - this.f18360U <= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || !this.f18349J.mo10719aX() || jCurrentTimeMillis - this.f18362W < 3000 || jCurrentTimeMillis - this.f18361V < 3000 || this.f18505q) {
            return;
        }
        CameraLog.m12954a("CameraUIManager", "updateDimHintView, showDimScreenHint");
        this.f18360U = jCurrentTimeMillis;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$3Y-hhGLqBIjp_YxnhWv35ZfVxrE
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m19572gx();
            }
        });
        mo18067a(R.string.hint_function_not_support_1080_60);
        mo18070a(R.string.camera_id_photo_mode_need_more_light, -1, true, false, false);
        this.f18349J.mo10750b(ReminderMsgData.TYPE_ADVICE, ReminderMsgData.CODE_FLASH_ON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gx */
    public /* synthetic */ void m19572gx() {
        this.f18394ac.m18502g();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: X */
    public boolean mo18063X() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f18362W <= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || jCurrentTimeMillis - this.f18360U < 3000 || jCurrentTimeMillis - this.f18361V < 3000 || m19941eo() || InverseManager.INS.isInverseColor(this.f18497i.hashCode()) || m19984w(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO) || mo19900dr() || this.f18508t) {
            return false;
        }
        CameraLog.m12954a("CameraUIManager", "showLowAmbientLightHintView, showHintView.");
        this.f18362W = jCurrentTimeMillis;
        mo18073a(R.string.camera_ai_video_low_ambient_light_hint, -1, true, false, false, false, false, true, 5000, true);
        return true;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: Y */
    public boolean mo18064Y() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f18361V <= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || jCurrentTimeMillis - this.f18360U < 3000 || jCurrentTimeMillis - this.f18362W < 3000 || m19941eo() || InverseManager.INS.isInverseColor(this.f18497i.hashCode()) || m19984w(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO) || mo19900dr()) {
            return false;
        }
        CameraLog.m12954a("CameraUIManager", "showBackLightHintView, showHintView.");
        this.f18361V = jCurrentTimeMillis;
        this.f18483cm.post(new Runnable() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.60
            @Override // java.lang.Runnable
            public void run() {
                if (CameraUIManager.this.f18367aB == null || !CameraUIManager.this.f18367aB.isShowing()) {
                    return;
                }
                CameraUIManager.this.f18367aB.dismiss();
                CameraUIManager.this.f18367aB = null;
                CameraUIManager.this.m19890dh();
            }
        });
        mo18073a(R.string.camera_ai_video_back_light_hint, -1, true, false, false, false, false, true, 5000, true);
        return true;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: Z */
    public boolean mo18065Z() {
        if (this.f18503o || this.f18502n) {
            CameraLog.m12966e("CameraUIManager", "showDirtyLensHintView, mbShowCapAlert or mbShowVideoAlert return");
            return false;
        }
        CameraScreenHintView cameraScreenHintView = this.f18404am;
        if (cameraScreenHintView != null && cameraScreenHintView.isShown()) {
            CameraLog.m12966e("CameraUIManager", "showDirtyLensHintView, mbShowCapAlert return");
            return false;
        }
        mo18070a(R.string.camera_toast_clean_lens_suggestion, -1, true, false, false);
        this.f18349J.mo10750b(ReminderMsgData.TYPE_ADVICE, ReminderMsgData.CODE_CLEAN_LENS);
        return true;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m19965j(int OplusGLSurfaceView_13, boolean z) {
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22219b(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: Q */
    public boolean m19633Q(int OplusGLSurfaceView_13) {
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            return abstractC3391a.mo22225e(OplusGLSurfaceView_13);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aa */
    public int mo18137aa() {
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            return abstractC3391a.mo22224e();
        }
        return 67108863;
    }

    /* renamed from: R */
    public boolean m19634R(int OplusGLSurfaceView_13) {
        CameraUIListener cameraUIListener;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 == 12) {
                String string = this.f18341B.getString(CameraUIInterface.KEY_FLASH_MODE, this.f18497i.getString(R.string.camera_flash_mode_default_value));
                return (TextUtils.equals("on", string) || TextUtils.equals(CameraParameter.FlashMode.FLASH_TORCH, string) || ((cameraUIListener = this.f18349J) != null && !cameraUIListener.mo10670X()) || TextUtils.equals("on", this.f18341B.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, mo19845cv())))) ? false : true;
            }
            if (OplusGLSurfaceView_13 == 4) {
                CameraUIListener cameraUIListener2 = this.f18349J;
                if (cameraUIListener2 != null) {
                    return cameraUIListener2.mo10670X();
                }
                return true;
            }
            if (OplusGLSurfaceView_13 != 5 && OplusGLSurfaceView_13 != 18) {
                if (OplusGLSurfaceView_13 != 19) {
                    return true;
                }
                if (!TextUtils.equals("off", this.f18341B.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, mo19845cv())))) {
                    return false;
                }
                String string2 = this.f18341B.getString(CameraUIInterface.KEY_FLASH_MODE, this.f18497i.getString(R.string.camera_flash_mode_default_value));
                return (TextUtils.equals("on", string2) || TextUtils.equals(CameraParameter.FlashMode.FLASH_TORCH, string2)) ? false : true;
            }
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18100a(String str, String str2, String str3) {
        String strM13299b = CameraEntry.m13299b(str, this.f18350K);
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21545a(strM13299b, str2, str3);
        }
    }

    /* renamed from: dU */
    public void m19877dU() {
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22222d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19852d(MotionEvent motionEvent) {
        CameraDrawerSettingUI c3326f;
        this.f18373aH.mo22212a(motionEvent);
        if (motionEvent.getAction() == 0) {
            m19727az(true);
        } else {
            if (3 != motionEvent.getAction() || (c3326f = this.f18348I) == null) {
                return;
            }
            c3326f.m21415d(false);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m19912e(MotionEvent motionEvent) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null && ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(cameraUIListener.mo10736ao()) && MultiVideoSmallSurfaceTouchEventHelper.m13880a().m13883b()) {
            return false;
        }
        if (2 == motionEvent.getPointerCount() || ((this.f18514z.m19112aA() && 1 == motionEvent.getPointerCount()) || 3 == motionEvent.getActionMasked() || motionEvent.getPointerId(motionEvent.getActionIndex()) == this.f18514z.m19113aB())) {
            CameraLog.m12954a("CameraUIManager", "handleDoubleFingerPic, PointerCount: " + motionEvent.getPointerCount() + ", Action: " + motionEvent.getActionMasked() + ", PointerId: " + motionEvent.getPointerId(motionEvent.getActionIndex()) + ", TouchPointId: " + this.f18514z.m19113aB());
            return this.f18514z.m19111a(motionEvent);
        }
        if (this.f18514z.m19112aA() && motionEvent.getPointerCount() >= 3) {
            return true;
        }
        CameraLog.m12954a("CameraUIManager", "handleDoubleFingerPic getPointerId: " + motionEvent.getPointerId(motionEvent.getActionIndex()) + " getTouchPointId: " + this.f18514z.m19113aB());
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19687a(String str, String str2, String str3, int OplusGLSurfaceView_13, int i2, int i3) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21546a(str, str2, str3, OplusGLSurfaceView_13, i2, i3);
        }
    }

    /* renamed from: u */
    public void m19980u(String str) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21582h(str);
        }
    }

    /* renamed from: v */
    public boolean m19982v(String str) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            return c3335o.m21584i(str);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19688a(String str, String str2, String str3, String str4, int OplusGLSurfaceView_13, int i2) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21547a(str, str2, str3, str4, OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18102a(String str, boolean z, int OplusGLSurfaceView_13, int i2) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21549a(str, z, OplusGLSurfaceView_13, i2);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21549a(str, z, OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: dV */
    public boolean m19878dV() {
        return this.f18422bE;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: M */
    public void mo18046M() {
        CameraLog.m12959b("CameraUIManager", "showVideoEisHint");
        if (this.f18365Z == null || this.f18504p || "off".equals(this.f18341B.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"))) {
            return;
        }
        this.f18422bE = true;
        int iM24445f = (mo19966j(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) && this.f18341B.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) ? Util.m24445f(R.string.camera_super_eis_pro) : R.string.camera_super_eis;
        if (mo18131aU()) {
            mo18138ab();
        }
        mo18108a(true, false, false);
        mo18166b(iM24445f, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: N */
    public void mo18048N() {
        CameraLog.m12959b("CameraUIManager", "hideVideoEisHint");
        if (this.f18365Z == null) {
            CameraLog.m12967f("CameraUIManager", "hideVideoEisHint, mCameraRootView is null");
            return;
        }
        this.f18422bE = false;
        mo18110a(Util.m24445f(R.string.camera_super_eis_pro));
        mo18110a(R.string.camera_super_eis);
    }

    /* renamed from: ax */
    public void m19725ax(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23412l(z);
        }
    }

    /* renamed from: dW */
    public boolean m19879dW() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10787bd();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: dX */
    public boolean mo19880dX() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10788be();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: dY */
    public boolean mo19881dY() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10791bh();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: dZ */
    public boolean mo19882dZ() {
        ComboPreferences comboPreferences;
        return mo19881dY() && (comboPreferences = this.f18341B) != null && comboPreferences.getString(CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid");
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ea */
    public float mo19927ea() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10792bi();
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: eb */
    public boolean mo19928eb() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10793bj();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: S */
    public void mo19635S(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("CameraUIManager", "onMultiCameraTypeChanged: " + OplusGLSurfaceView_13);
        if (this.f18349J != null) {
            m19440ak(OplusGLSurfaceView_13);
            this.f18349J.onMultiCameraTypeChanged(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: ak */
    private void m19440ak(int OplusGLSurfaceView_13) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f18497i);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mCaptureMode = this.f18349J.mo10736ao();
        menuClickMsgData.mCameraId = this.f18349J.mo10655I();
        menuClickMsgData.mFuncKeyId = 54;
        menuClickMsgData.mItemValue = String.valueOf(OplusGLSurfaceView_13);
        menuClickMsgData.mCaptureType = !this.f18349J.mo10648B() ? 1 : 0;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ec */
    public boolean mo19929ec() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10800bq();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo19672a(EffectType c2687f) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10685a(c2687f);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ed */
    public boolean mo19930ed() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10758bA();
        }
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ee */
    public void mo19931ee() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10760bC();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ef */
    public void mo19932ef() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10761bD();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: eg */
    public void mo19933eg() {
        if (this.f18421bD) {
            m19467eO();
            this.f18421bD = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: eh */
    public void mo19934eh() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10765bH();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: COUIBaseListPopupWindow_8 */
    public RelativeLayout.LayoutParams mo19909e(Size size) {
        return this.f18500l.mo16411a().mo16549a(size);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface, com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: aX */
    public int mo18134aX() {
        return this.f18500l.mo16411a().mo16539j();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ei */
    public int mo19935ei() {
        return this.f18500l.mo16411a().mo16570k();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ej */
    public BaseScreenMode mo19936ej() {
        return this.f18500l.mo16411a();
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo19698a(Size size, Size size2) {
        return this.f18500l.mo16411a().mo16557a(size, size2);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public Rect m19967k(int OplusGLSurfaceView_13, int i2) {
        return this.f18500l.mo16411a().mo16558b(OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: ek */
    public void mo19937ek() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10781bX();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: r */
    public void mo18262r(int OplusGLSurfaceView_13) {
        mo18170b(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "on".equals(this.f18341B.getString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.f18497i.getString(R.string.camera_multicamera_type_default))) ? R.drawable.multi_video_type_menu_selected : R.drawable.multi_video_type_menu_normal);
    }

    /* renamed from: em */
    public boolean m19939em() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            return c3326f.m21422o();
        }
        return false;
    }

    /* renamed from: en */
    public boolean m19940en() {
        SuperColorToolTips c3520c = this.f18414aw;
        if (c3520c != null) {
            return c3520c.isShowing();
        }
        return false;
    }

    /* renamed from: eo */
    public boolean m19941eo() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        return c3326f != null && c3326f.m21427t();
    }

    /* renamed from: ep */
    public boolean m19942ep() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            return c3326f.m21533K().isEmpty();
        }
        return true;
    }

    /* renamed from: eq */
    public boolean m19943eq() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            return c3326f.m21423p();
        }
        return false;
    }

    /* renamed from: er */
    public boolean m19944er() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            return c3326f.m21424q();
        }
        return false;
    }

    /* renamed from: es */
    public void m19945es() {
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.mo21420m();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aB */
    public void mo18112aB() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19125al();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: D */
    public void mo18029D(boolean z) {
        int configIntValue;
        CameraLog.m12959b("CameraUIManager", "showSlowVideoModeSeekBar, needAnimation: " + z);
        if (this.f18504p || "off".equals(this.f18341B.getString(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, this.f18497i.getString(R.string.camera_slow_video_mode_frame_default_value))) || mo18057R()) {
            return;
        }
        if (this.f18451bh == null) {
            this.f18451bh = new SlowVideoModeSeekBar(this.f18497i);
            this.f18451bh.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.61
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (CameraUIManager.this.f18483cm == null || CameraUIManager.this.f18504p) {
                        return false;
                    }
                    CameraUIManager.this.f18483cm.removeMessages(4);
                    CameraUIManager.this.f18483cm.sendMessageDelayed(CameraUIManager.this.f18483cm.obtainMessage(4), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                    return false;
                }
            });
            this.f18451bh.setModeFrameChangeListener(new IntrinsicsJvm.kt_4());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(120, this.f18497i.getString(R.string.camera_intelligent_high_frame_slow_1080p)));
            arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(240, this.f18497i.getString(R.string.camera_intelligent_high_frame_slow_720p)));
            arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(CameraParameter.VideoFps.FPS_480, this.f18497i.getString(R.string.camera_intelligent_high_frame_super_1080p)));
            arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(CameraParameter.VideoFps.FPS_960, this.f18497i.getString(R.string.camera_intelligent_high_frame_super_720p)));
            this.f18451bh.setFrameList(arrayList);
        }
        String string = this.f18341B.getString(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, Util.m24485o(mo19845cv()));
        if ("video_size_1080p".equals(string)) {
            configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE);
        } else {
            configIntValue = "video_size_720p".equals(string) ? CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE) : 0;
        }
        this.f18451bh.m24097a(this.f18341B.getInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, configIntValue));
        this.f18451bh.m24098a(this.f18351L, false);
        RelativeLayout relativeLayoutM23431y = this.f18340A.m23431y();
        int dimensionPixelSize = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.slow_video_seekbar_width);
        int dimensionPixelSize2 = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.slow_video_seekbar_height);
        int height = relativeLayoutM23431y.getHeight() - (this.f18514z.m19071U().getTop() - relativeLayoutM23431y.getTop());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, height);
        this.f18451bh.setLayoutParams(layoutParams);
        if (relativeLayoutM23431y.indexOfChild(this.f18451bh) < 0) {
            relativeLayoutM23431y.addView(this.f18451bh, relativeLayoutM23431y.indexOfChild(relativeLayoutM23431y.findViewById(R.id_renamed.slow_video_motion_detect_view)) - 1);
        }
        if (z) {
            Util.m24270a(this.f18451bh, 0, (Animation.AnimationListener) null, 300L);
        } else {
            this.f18451bh.setVisibility(0);
        }
        this.f18483cm.removeMessages(4);
        this.f18483cm.sendMessageDelayed(this.f18483cm.obtainMessage(4), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        this.f18514z.m19207r(false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: C */
    public void mo18027C(boolean z) {
        SlowVideoModeSeekBar c3519b;
        CameraLog.m12959b("CameraUIManager", "hideSlowVideoModeSeekBar, needAnimation: " + z);
        this.f18483cm.removeMessages(4);
        if (this.f18365Z != null && (c3519b = this.f18451bh) != null) {
            if (z) {
                Util.m24270a(c3519b, 8, (Animation.AnimationListener) null, 300L);
            } else {
                c3519b.setVisibility(8);
            }
            this.f18365Z.removeView(this.f18451bh);
        }
        this.f18514z.m19207r(true);
    }

    /* renamed from: et */
    public void m19946et() {
        CameraLog.m12959b("CameraUIManager", "hideSlowVideoSeekBarBySharedPreference");
        this.f18341B.edit().putString(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, "off").apply();
        mo18211f(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU);
    }

    /* renamed from: eu */
    public boolean m19947eu() {
        SlowVideoModeSeekBar c3519b = this.f18451bh;
        return c3519b != null && c3519b.getVisibility() == 0;
    }

    /* compiled from: CameraUIManager.java */
    /* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements SlowVideoModeSeekBar.IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m20060a(int OplusGLSurfaceView_13) {
            return 480 == OplusGLSurfaceView_13 || 960 == OplusGLSurfaceView_13;
        }

        private IntrinsicsJvm.kt_4() {
        }

        @Override // com.oplus.camera.p172ui.widget.SlowVideoModeSeekBar.IntrinsicsJvm.kt_4
        public void onSlowVideoFrameChange(int OplusGLSurfaceView_13) {
            CameraLog.m12959b("CameraUIManager", "onFrameChange, frame: " + OplusGLSurfaceView_13);
            if (CameraUIManager.this.m19879dW()) {
                CameraUIManager.this.mo18254p(OplusGLSurfaceView_13);
            }
            CameraUIManager.this.f18349J.mo10853j(OplusGLSurfaceView_13);
            String string = CameraUIManager.this.f18341B.getString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, CameraUIManager.this.f18497i.getString(R.string.camera_intelligent_high_frame_default_selected));
            String string2 = CameraUIManager.this.f18341B.getString(CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, "");
            if (m20060a(OplusGLSurfaceView_13)) {
                if (!TextUtils.isEmpty(string2)) {
                    CameraUIManager.this.mo18171b(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string2);
                } else {
                    CameraUIManager.this.mo18171b(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string);
                    CameraUIManager.this.f18341B.edit().putString(CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, string).apply();
                }
            } else {
                if (!TextUtils.isEmpty(string2)) {
                    CameraUIManager.this.f18341B.edit().putString(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, "off").apply();
                }
                CameraUIManager.this.mo18099a(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, "off");
            }
            CameraUIManager.this.mo18105a(false);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: p */
    public void mo18254p(int OplusGLSurfaceView_13) {
        int i2;
        int i3 = R.string.camera_intelligent_high_frame_super_selected;
        if (120 == OplusGLSurfaceView_13) {
            i2 = R.drawable.frame_120;
        } else {
            if (240 != OplusGLSurfaceView_13) {
                if (480 == OplusGLSurfaceView_13) {
                    i2 = R.drawable.frame_480;
                } else if (960 == OplusGLSurfaceView_13) {
                    i2 = R.drawable.frame_960;
                } else {
                    i3 = -1;
                    i2 = 0;
                }
                mo18170b(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, i2);
                mo18166b(i3, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
            }
            i2 = R.drawable.frame_240;
        }
        i3 = R.string.camera_intelligent_high_frame_slow_selected;
        mo18170b(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, i2);
        mo18166b(i3, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: o */
    public void mo18250o(int OplusGLSurfaceView_13) {
        if (this.f18340A != null) {
            if (OplusGLSurfaceView_13 == 0 && mo18057R()) {
                return;
            }
            this.f18340A.m23401g(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: E */
    public void mo18031E(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23421p(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: q */
    public RectF mo18257q(int OplusGLSurfaceView_13) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            return viewOnLayoutChangeListenerC3444g.m23403h(OplusGLSurfaceView_13);
        }
        return null;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: COUIBaseListPopupWindow_10 */
    public CameraMenuOption mo18220h(String str) {
        return this.f18347H.m21579g(str);
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo19969l(int OplusGLSurfaceView_13, int i2) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10826d(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: OplusGLSurfaceView_6 */
    public boolean mo19972m(int OplusGLSurfaceView_13, int i2) {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10834e(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: w */
    public boolean m19984w(String str) {
        ComboPreferences comboPreferences = this.f18341B;
        if (comboPreferences == null) {
            CameraLog.m12967f("CameraUIManager", "isBubbleOpen, mPreference null");
            return false;
        }
        return comboPreferences.getBoolean(str, true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: J */
    public void mo18041J(boolean z) {
        CameraLog.m12959b("CameraUIManager", "hideMultiCameraTypeLayoutBySharedPreference, needZoom: " + z);
        ComboPreferences comboPreferences = this.f18341B;
        if (comboPreferences != null) {
            SharedPreferences.Editor editorEdit = comboPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM, z ? "on" : "off");
            editorEdit.putString(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off");
            editorEdit.apply();
        }
        mo18211f(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aA */
    public boolean mo18111aA() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        return viewOnLayoutChangeListenerC3444g != null && viewOnLayoutChangeListenerC3444g.m23367ag();
    }

    /* renamed from: ev */
    public boolean m19948ev() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        return viewOnLayoutChangeListenerC3444g != null && viewOnLayoutChangeListenerC3444g.m23368ah();
    }

    /* renamed from: ew */
    public boolean m19949ew() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        return viewOnLayoutChangeListenerC3444g != null && viewOnLayoutChangeListenerC3444g.m23369ai();
    }

    /* renamed from: ex */
    public boolean m19950ex() {
        TimeLapseProMenuLayout c3071g = this.f18433bP;
        return c3071g != null && c3071g.getVisibility() == 0;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18185c(int OplusGLSurfaceView_13, int i2) {
        CameraScreenNail c3445hMo18183c = mo18183c();
        if (c3445hMo18183c != null) {
            c3445hMo18183c.m23474e(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: az */
    public Rect mo18162az() {
        CameraScreenNail c3445hMo18183c = mo18183c();
        if (c3445hMo18183c != null) {
            return c3445hMo18183c.m23462B();
        }
        return null;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: s */
    public void mo18266s(int OplusGLSurfaceView_13) {
        CameraScreenNail c3445hMo18183c = mo18183c();
        if (c3445hMo18183c != null) {
            c3445hMo18183c.m23473e(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: H */
    public void mo18037H(boolean z) {
        CameraScreenNail c3445hMo18183c = mo18183c();
        if (c3445hMo18183c != null) {
            c3445hMo18183c.m23482o(z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18194d(int OplusGLSurfaceView_13, int i2) {
        CameraScreenNail c3445hMo18183c = mo18183c();
        if (c3445hMo18183c != null) {
            c3445hMo18183c.m23472d(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: I */
    public void mo18039I(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g == null || viewOnLayoutChangeListenerC3444g.m23430x() == null) {
            return;
        }
        this.f18340A.m23430x().m14252h(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: al */
    public boolean m19442al(int OplusGLSurfaceView_13) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        if (m19862dF()) {
            CameraLog.m12954a("CameraUIManager", "onModeItemClick, headline is scrolling, can't response");
            return true;
        }
        if (17 == OplusGLSurfaceView_13) {
            this.f18342C.m16728a(this.f18497i, this.f18349J, this.f18351L);
            this.f18342C.m16727a(mo19845cv(), this.f18349J.mo10786bc().m13359w());
            return true;
        }
        String strM14541j = RegionCommonFeatureAdapter.m14541j();
        if (9 != OplusGLSurfaceView_13 || TextUtils.isEmpty(strM14541j) || !DisableUitl.m24536a(this.f18497i, strM14541j)) {
            return false;
        }
        DisableUitl.m24534a(this.f18497i, Util.m24348ak() ? R.string.camera_disable_smart_scan : R.string.camera_disable_scan, strM14541j, this.f18497i.getApplication().getResources().getString(R.string.camera_mode_breeno_scan));
        return true;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: w */
    public void mo18280w() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19126am();
        }
    }

    /* renamed from: ey */
    public void m19951ey() {
        VideoRecordingTimeUI c3434ae = this.f18343D;
        if (c3434ae != null) {
            c3434ae.m23047a(false, mo19881dY());
        }
    }

    /* renamed from: ez */
    public void m19952ez() {
        CommonBottomGuide c2785a = this.f18450bg;
        if (c2785a != null) {
            c2785a.m14457b();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aG */
    public boolean mo18117aG() {
        return this.f18458bo;
    }

    /* renamed from: az */
    public void m19727az(boolean z) {
        this.f18458bo = z;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aJ */
    public void mo18120aJ() {
        this.f18459bp = false;
        this.f18460bq = false;
        this.f18461br = false;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$_HVzvEg9xwHWq-68woFBN4oIRQw
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m19571gw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gw */
    public /* synthetic */ void m19571gw() {
        Activity activity = this.f18497i;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f18514z.m19054C();
        this.f18340A.m23375ao();
        this.f18349J.mo10753b(false, true);
        mo18288z(false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aH */
    public void mo18118aH() {
        this.f18459bp = false;
        this.f18461br = false;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$BPMFGbelw_AqB0T4c8TqzzGDM_Y
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m19570gv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gv */
    public /* synthetic */ void m19570gv() throws Resources.NotFoundException {
        this.f18514z.m19219z();
        this.f18340A.m23342a(this.f18349J.mo10809bz(), (View) this.f18340A.m23376ap(), true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aI */
    public void mo18119aI() {
        this.f18459bp = false;
        this.f18461br = false;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$84HDrIPoQg2Utp6Oij03Lgeh9U4
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m19569gu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gu */
    public /* synthetic */ void m19569gu() throws Resources.NotFoundException {
        this.f18514z.m19053B();
        this.f18340A.m23342a(this.f18349J.mo10809bz(), (View) this.f18340A.m23376ap(), false);
        mo18288z(true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aK */
    public void mo18121aK() {
        this.f18459bp = true;
        this.f18460bq = false;
        this.f18461br = false;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$DeAAmLRIrT7iXx3RTeFcoyj2twY
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m19568gt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gt */
    public /* synthetic */ void m19568gt() throws Resources.NotFoundException {
        Activity activity = this.f18497i;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f18514z.m19052A();
        if (this.f18349J.mo10738aq()) {
            m19794c(true, 0);
        } else {
            mo18068a(8, 1);
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        viewOnLayoutChangeListenerC3444g.m23342a((View) viewOnLayoutChangeListenerC3444g.m23376ap(), this.f18349J.mo10809bz(), true);
        mo18288z(false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aL */
    public void mo18122aL() {
        this.f18460bq = true;
        this.f18461br = true;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$dCHE2cY7luTltsp8m1qeWKaLNgg
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m19567gs();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gs */
    public /* synthetic */ void m19567gs() throws Resources.NotFoundException {
        this.f18514z.m19055D();
        if (this.f18349J.mo10738aq()) {
            m19974o(this.f18497i.getString(HeadlineHelper.m20344a(this.f18349J.mo10736ao())));
            m19736b(true, 0);
        } else {
            mo18068a(0, 1);
        }
        this.f18340A.m23342a(this.f18349J.mo10809bz(), (View) this.f18340A.m23376ap(), true);
        mo18288z(true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: M */
    public void mo18047M(final boolean z) {
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$mUqc7XiBA4_EbimhnqvUfzSjPYE
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m19416aQ(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aQ */
    public /* synthetic */ void m19416aQ(boolean z) throws Resources.NotFoundException {
        this.f18514z.m19056E();
        this.f18340A.m23342a(z ? this.f18349J.mo10809bz() : this.f18340A.m23376ap(), !z ? this.f18349J.mo10809bz() : this.f18340A.m23376ap(), true);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aM */
    public void mo18123aM() {
        this.f18459bp = false;
        this.f18460bq = true;
        this.f18461br = true;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$sgqQwMztWCXibyma-J3Ojbb1Wk8
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m19566gr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gr */
    public /* synthetic */ void m19566gr() throws Resources.NotFoundException {
        this.f18514z.m19057F();
        if (this.f18349J.mo10738aq()) {
            m19736b(true, 0);
        } else {
            mo18068a(0, 1);
        }
        this.f18340A.m23342a(this.f18349J.mo10809bz(), (View) this.f18340A.m23376ap(), true);
        mo18288z(false);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aN */
    public void mo18124aN() {
        this.f18459bp = true;
        this.f18460bq = false;
        this.f18461br = false;
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$1dn8rKs0GZ_ruqbH6rUL7Qat_Cw
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m19565gq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gq */
    public /* synthetic */ void m19565gq() throws Resources.NotFoundException {
        this.f18514z.m19058G();
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        viewOnLayoutChangeListenerC3444g.m23342a((View) viewOnLayoutChangeListenerC3444g.m23376ap(), this.f18349J.mo10809bz(), true);
        mo18288z(false);
    }

    /* renamed from: C */
    public void m19618C(boolean z, boolean z2) {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19107a(z, z2);
        }
    }

    /* renamed from: eA */
    public void m19913eA() {
        this.f18514z.m19165f();
    }

    /* renamed from: x */
    public void m19986x(String str) throws Resources.NotFoundException {
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g == null || !c2688g.m12933a(str)) {
            return;
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null && !cameraUIListener.mo10738aq()) {
            m19988y(0);
        }
        mo18024B(true);
        this.f18462bs.m12927a();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aO */
    public void mo18125aO() {
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g != null) {
            c2688g.m12932a(false);
        }
        ComboPreferences comboPreferences = this.f18341B;
        if (comboPreferences != null) {
            comboPreferences.edit().remove(CameraUIInterface.KEY_VIDEO_CLIP_SAVE_PATH);
        }
        mo18067a(R.string.camera_double_exposure_max_recording_hint);
    }

    @Override // com.oplus.camera.p172ui.widget.VideoClipView.IntrinsicsJvm.kt_4
    /* renamed from: eB */
    public void mo19914eB() {
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19211t(true);
        }
        mo18125aO();
    }

    @Override // com.oplus.camera.p172ui.widget.VideoClipView.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo19648a(float COUIBaseListPopupWindow_12, float f2) {
        VideoClipManager c2688g;
        if (this.f18341B == null || (c2688g = this.f18462bs) == null || c2688g.m12949n()) {
            return;
        }
        final String string = this.f18341B.getString(CameraUIInterface.KEY_VIDEO_CLIP_SAVE_PATH, "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            if (this.f18462bs != null) {
                if (new File(this.f18462bs.m12944i()).exists()) {
                    this.f18462bs.m12943h();
                    m19394a(this.f18462bs.m12945j());
                } else {
                    this.f18462bs.m12931a(string, new NvsStreamingContext.CompileCallback2() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$SdcDl4DHRNiaUSLeJIvNFfhSG24
                        @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback2
                        public final void onCompileCompleted(NvsTimeline nvsTimeline, boolean z) throws Throwable {
                            this.COUIBaseListPopupWindow_12$0.m19395a(string, nvsTimeline, z);
                        }
                    });
                }
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m19395a(String str, NvsTimeline nvsTimeline, boolean z) throws Throwable {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
            }
        } catch (Throwable th) {
            th = th;
            mediaMetadataRetriever = mediaMetadataRetriever2;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            ClipVideoInfo c2683b = new ClipVideoInfo(str);
            c2683b.m12895a(0L);
            c2683b.m12898b(Long.parseLong(strExtractMetadata));
            m19394a(c2683b);
            mediaMetadataRetriever.release();
            mediaMetadataRetriever.close();
        } catch (Exception e2) {
            COUIBaseListPopupWindow_8 = e2;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            this.f18462bs.m12948m();
            COUIBaseListPopupWindow_8.printStackTrace();
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.close();
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19394a(ClipVideoInfo c2683b) {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10684a(c2683b, new VideoClipManager.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$N2XrVKh_YFrWLAbbj_08ODB3-ts
                @Override // com.oplus.camera.doubleexposure.VideoClipManager.PlatformImplementations.kt_3
                public final void onVideoClipDone() {
                    this.COUIBaseListPopupWindow_12$0.m19563go();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: go */
    public /* synthetic */ void m19563go() {
        this.f18497i.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$WZkWHqo9hrMvHrU_dMgaEr01pUM
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m19564gp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gp */
    public /* synthetic */ void m19564gp() {
        VideoClipManager c2688g = this.f18462bs;
        if (c2688g != null) {
            c2688g.m12932a(true);
            this.f18462bs.m12942g();
        }
    }

    /* renamed from: eC */
    public boolean m19915eC() {
        VideoClipManager c2688g = this.f18462bs;
        return c2688g != null && c2688g.m12950o();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aP */
    public void mo18126aP() {
        Activity activity = this.f18497i;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$MnXjyMTZOJ-fOJ4sj15s3PR-Omg
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m19562gn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gn */
    public /* synthetic */ void m19562gn() {
        if (this.f18365Z != null) {
            VideoClipView viewOnClickListenerC3522e = new VideoClipView(this.f18497i);
            viewOnClickListenerC3522e.setVisibility(8);
            viewOnClickListenerC3522e.setId(R.id_renamed.video_clip_view);
            this.f18365Z.addView(viewOnClickListenerC3522e, new ViewGroup.MarginLayoutParams(-1, -1));
            this.f18462bs = new VideoClipManager(this.f18365Z, this.f18497i, this);
            this.f18462bs.m12930a(this);
            CameraControlUI viewOnClickListenerC3199a = this.f18514z;
            if (viewOnClickListenerC3199a != null) {
                viewOnClickListenerC3199a.m19104a(viewOnClickListenerC3522e);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: t */
    public void mo18270t(int OplusGLSurfaceView_13) {
        if (this.f18349J == null || !m19638T(OplusGLSurfaceView_13)) {
            return;
        }
        this.f18349J.mo10857k(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aR */
    public void mo18128aR() {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23364ad();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18189c(String str, boolean z) {
        if (m19899dq() || this.f18349J.mo10791bh() || !mo18111aA()) {
            this.f18349J.mo10751b(str, z);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo18198d(String str, boolean z) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21559b(str, z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: eD */
    public boolean mo19916eD() {
        CameraUIListener cameraUIListener = this.f18349J;
        return cameraUIListener != null && cameraUIListener.mo10764bG();
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aS */
    public void mo18129aS() {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20692q();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: u */
    public void mo18274u(int OplusGLSurfaceView_13) {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20669b(OplusGLSurfaceView_13, false);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aT */
    public void mo18130aT() {
        Activity activity = this.f18497i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$EAiH55woV0_RRHMrRpggFommunc
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m19561gm();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gm */
    public /* synthetic */ void m19561gm() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || cameraUIListener.mo10809bz() == null) {
            return;
        }
        this.f18349J.mo10809bz().setVisibility(0);
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: eE */
    public int mo19917eE() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10774bQ();
        }
        return 0;
    }

    /* renamed from: y */
    public void m19989y(String str) {
        this.f18514z.m19154c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aL */
    public void m19411aL(boolean z) {
        CameraUIListener cameraUIListener = this.f18349J;
        if ((cameraUIListener == null || !cameraUIListener.mo10712aQ()) && !m19871dO() && mo18057R()) {
            if (m19504fT()) {
                mo18234k(6);
            }
            CameraControlUI viewOnClickListenerC3199a = this.f18514z;
            if (viewOnClickListenerC3199a != null) {
                viewOnClickListenerC3199a.m19213u(m19504fT());
            }
            this.f18447bd.m22054g();
            CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
            if (viewOnClickListenerC3199a2 == null || viewOnClickListenerC3199a2.m19136aw()) {
                return;
            }
            this.f18349J.mo10850i(z ? MenuClickMsgData.MODE_FUNCKEY_ITEM_HOLD_EDIT : MenuClickMsgData.MODE_FUNCKEY_ITEM_EDIT_KEY);
        }
    }

    /* renamed from: eF */
    public void m19918eF() {
        this.f18349J.mo10850i("save");
        int iM20347b = HeadlineHelper.m20347b(this.f18341B.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON));
        if (-1 != iM20347b) {
            PreferenceManager.m3981a(this.f18497i).edit().putBoolean("mode_arrange_change_panel", "position_mode_panel".equals(DataBaseOperator.m21777a().m21781a(iM20347b).m21910c())).apply();
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19135av();
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22056h();
        }
    }

    /* renamed from: eG */
    public boolean m19919eG() {
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            return c3358p.m22058i();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m19960h(String str, boolean z) {
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            return c3335o.m21564b(str);
        }
        return false;
    }

    /* renamed from: eH */
    public ScreenModeManager m19920eH() {
        return this.f18500l;
    }

    @Override // com.oplus.camera.screen.IUIManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16493a(BaseScreenMode abstractC2934a, boolean z) throws Resources.NotFoundException {
        CameraLog.m12967f("CameraUIManager", "changeScreenMode, screenMode: " + abstractC2934a + ", isCapModChange: " + z);
        this.f18349J.mo10766bI();
        m19449b(abstractC2934a, z);
        abstractC2934a.mo16498a(this.f18497i, (ScreenRelativeLayout) this.f18365Z);
        abstractC2934a.m16503a(m19509fY());
        this.f18419bB = true;
    }

    /* renamed from: fY */
    private View[] m19509fY() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_container));
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_click));
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_display_text));
        arrayList.add(Integer.valueOf(R.id_renamed.headline_view));
        Integer numValueOf = Integer.valueOf(R.id_renamed.oplus_slide_downward);
        arrayList.add(numValueOf);
        arrayList.add(Integer.valueOf(R.id_renamed.face_beauty_enter_button));
        arrayList.add(Integer.valueOf(R.id_renamed.camera_menu_left_enter_button));
        arrayList.add(Integer.valueOf(R.id_renamed.effect_menu_back_button));
        arrayList.add(Integer.valueOf(R.id_renamed.control_panel_layout));
        arrayList.add(Integer.valueOf(R.id_renamed.control_panel_button_layout));
        arrayList.add(Integer.valueOf(R.id_renamed.shutter_button));
        arrayList.add(Integer.valueOf(R.id_renamed.switch_camera_button));
        arrayList.add(Integer.valueOf(R.id_renamed.thumbnail));
        arrayList.add(Integer.valueOf(R.id_renamed.recording_cap_button));
        arrayList.add(Integer.valueOf(R.id_renamed.video_pause_resume));
        arrayList.add(Integer.valueOf(R.id_renamed.mode_title_layout));
        arrayList.add(numValueOf);
        arrayList.add(Integer.valueOf(R.id_renamed.gallery_container));
        arrayList.add(Integer.valueOf(R.id_renamed.screen_mode_switch_button));
        arrayList.add(Integer.valueOf(R.id_renamed.out_screen_preview_switch_button));
        arrayList.add(Integer.valueOf(R.id_renamed.effects_menu_panel));
        arrayList.add(Integer.valueOf(R.id_renamed.camera_from_other_app_close_btn));
        arrayList.add(Integer.valueOf(R.id_renamed.done_button));
        arrayList.add(Integer.valueOf(R.id_renamed.btn_retake));
        arrayList.add(Integer.valueOf(R.id_renamed.review_control_layout));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_template_button));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_setting_button));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_guide_button));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_layout));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_record_layout));
        arrayList.add(Integer.valueOf(R.id_renamed.professional_params_bar_container));
        arrayList.add(Integer.valueOf(R.id_renamed.main_bar_id));
        arrayList.add(Integer.valueOf(R.id_renamed.professional_param_slide_bar_container));
        arrayList.add(Integer.valueOf(R.id_renamed.professional_parameter_bottom_guide_entry));
        arrayList.add(Integer.valueOf(R.id_renamed.multivideo_type_select_view));
        View[] viewArr = new View[arrayList.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
            viewArr[OplusGLSurfaceView_13] = this.f18497i.findViewById(((Integer) arrayList.get(OplusGLSurfaceView_13)).intValue());
        }
        return viewArr;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m19449b(BaseScreenMode abstractC2934a, boolean z) throws Resources.NotFoundException {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g;
        this.f18467bx = abstractC2934a;
        CameraPreviewUI viewOnLayoutChangeListenerC3444g2 = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g2 != null && !viewOnLayoutChangeListenerC3444g2.m23367ag()) {
            this.f18378aM.setVisibility(8);
        }
        abstractC2934a.m16513e(this.f18497i);
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null) {
            c3326f.m21404a(abstractC2934a.mo16539j(), abstractC2934a.mo16570k(), abstractC2934a.mo16630q());
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21580g(abstractC2934a.mo16539j());
        }
        FilterEffectMenu c3282g = this.f18399ah;
        if (c3282g != null) {
            c3282g.m20868a(abstractC2934a.mo16539j(), abstractC2934a.mo16570k());
        }
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        if (viewOnClickListenerC3261g != null) {
            viewOnClickListenerC3261g.m20666a(abstractC2934a.mo16539j(), abstractC2934a.mo16570k());
            this.f18385aT.m20682h(abstractC2934a.mo16528a(this.f18352M));
        }
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19090a(abstractC2934a, false);
        }
        MoreUIControl c3358p = this.f18447bd;
        if (c3358p != null) {
            c3358p.m22057h(abstractC2934a.mo16539j());
        }
        ModePanelUIControl c3355m = this.f18375aJ;
        if (c3355m != null) {
            c3355m.m21948a(mo19900dr());
            this.f18375aJ.m21943a(abstractC2934a.mo16539j(), abstractC2934a.mo16570k());
        }
        BlurMenu c3278c = this.f18400ai;
        if (c3278c != null) {
            c3278c.setScreenMode(abstractC2934a.mo16539j(), abstractC2934a.mo16570k());
        }
        HintManager c3130a = this.f18394ac;
        if (c3130a != null) {
            c3130a.m18483a(abstractC2934a);
        }
        this.f18467bx = abstractC2934a;
        this.f18500l.m16661b(this.f18467bx.mo16599o());
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10841g(abstractC2934a.mo16539j(), abstractC2934a.mo16570k());
            m19761bU();
        }
        TimeLapseProMenuLayout c3071g = this.f18433bP;
        if (c3071g != null) {
            c3071g.setCurrentScreenMode(abstractC2934a);
        }
        TimeLapseProGuideLayout c3070f = this.f18434bQ;
        if (c3070f != null) {
            c3070f.setCurrentScreenMode(abstractC2934a);
        }
        AISceneUI abstractC3391a = this.f18373aH;
        if (abstractC3391a != null) {
            abstractC3391a.mo22231h(abstractC2934a.mo16539j());
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444g3 = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g3 != null) {
            viewOnLayoutChangeListenerC3444g3.m23303C();
        }
        if (!Util.m24498u() || ((viewOnLayoutChangeListenerC3444g = this.f18340A) != null && !viewOnLayoutChangeListenerC3444g.m23323X())) {
            InverseManager.INS.setMaskLayoutMode(this.f18497i, abstractC2934a.mo16539j(), abstractC2934a.mo16630q(), abstractC2934a.mo16570k());
        }
        m19825cb();
    }

    /* renamed from: eI */
    public boolean m19921eI() {
        return this.f18512x;
    }

    /* renamed from: eJ */
    public boolean m19922eJ() {
        return this.f18420bC;
    }

    @Override // com.oplus.camera.screen.IUIManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16492a(BaseScreenMode abstractC2934a, BaseScreenMode abstractC2934a2) throws IllegalStateException, Resources.NotFoundException {
        CameraLog.m12967f("CameraUIManager", "beforeChangeScreenMode lastScreenMode: " + abstractC2934a + " currentScreenMode: " + abstractC2934a2);
        if (1 == abstractC2934a.mo16539j() || 1 == abstractC2934a2.mo16539j()) {
            this.f18512x = true;
        }
        this.f18420bC = true;
        if (this.f18349J.mo10729ah()) {
            this.f18349J.mo10752b(true);
            if (!(m19518fh() && (abstractC2934a2.mo16571l() || abstractC2934a2.mo16631r() || abstractC2934a2.mo16599o()))) {
                m19389a(0, true, 2);
            }
            this.f18349J.mo10733al();
        }
        mo18109a(false, true, true, true);
        mo18176b(true, false, true, false);
        mo18028D();
        mo18203e(6, true);
        mo18174b(false);
        Util.m24489q(this.f18497i);
        m19620D(false, false);
        m19894dl();
        if (!this.f18503o && !this.f18502n && !mo19900dr() && !this.f18349J.mo10829d() && 1 != mo18134aX()) {
            if (Util.m24451g() == 0) {
                this.f18347H.m21523A();
            }
            m19983w(true, false);
        }
        if (this.f18394ac != null) {
            mo18108a(true, true, false);
        }
        if (this.f18394ac != null && this.f18479ci != null) {
            mo18138ab();
            this.f18479ci.mo20037b();
            mo18239l(true);
        }
        if (m19864dH() && m19919eG()) {
            m19389a(4, false, 0);
        }
        this.f18349J.mo10817cb();
        m19514fd();
        if (PopUpWindowManager.m20706a()) {
            PopUpWindowManager.m20713e();
        }
        this.f18340A.m23418o();
        if (this.f18341B.getString(CameraUIInterface.KEY_ASSIST_GRADIENTER, "off").equals("on")) {
            mo18227i(false);
        }
        if (m19518fh() && !m19898dp() && !mo19900dr() && !this.f18349J.mo10658L() && !m19864dH()) {
            m19671a((Animation) null);
        }
        CameraDrawerSettingUI c3326f = this.f18348I;
        if (c3326f != null && c3326f.mo21419j()) {
            this.f18348I.m21430z();
            mo18060U();
        }
        TimeLapseProGuideLayout c3070f = this.f18434bQ;
        if (c3070f != null && c3070f.isShown()) {
            this.f18434bQ.m17634b();
            m19699aA(true);
        }
        this.f18340A.m23345a(abstractC2934a, abstractC2934a2);
        for (SplitBackgroundView splitBackgroundView : this.f18473cc) {
            if (splitBackgroundView != null) {
                String strMo16516h = abstractC2934a2.mo16516h();
                splitBackgroundView.setSplitBackground("full270".equals(strMo16516h) || "full90".equals(strMo16516h));
                splitBackgroundView.setOrientation(this.f18351L);
            }
        }
    }

    @Override // com.oplus.camera.screen.IUIManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16491a(BaseScreenMode abstractC2934a) throws Resources.NotFoundException {
        CameraLog.m12967f("CameraUIManager", "afterChangeScreenMode screenMode: " + abstractC2934a);
        this.f18349J.mo10828d(false);
        this.f18349J.mo10866m(abstractC2934a.mo16539j());
        this.f18349J.mo10819cd();
        if (this.f18349J.mo10795bl()) {
            mo18240l(true, false);
        }
        if (mo19900dr() && this.f18343D != null && !mo19966j(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            this.f18343D.m23045a(abstractC2934a);
            this.f18343D.m23058g();
        }
        GalleryBottomMenuLayout c3229j = this.f18424bG;
        if (c3229j != null) {
            c3229j.m20180a();
        }
        if (this.f18345F != null) {
            m19470eR();
        }
        if (this.f18394ac != null) {
            this.f18349J.mo10818cc();
        }
        CameraSettingUI c3335o = this.f18347H;
        if (c3335o != null) {
            c3335o.m21555b(this.f18352M);
        }
        if (this.f18348I != null && 3 == abstractC2934a.mo16539j()) {
            this.f18348I.m21411b(1 == mo19845cv());
        }
        this.f18483cm.removeMessages(13);
        this.f18483cm.sendEmptyMessageDelayed(13, 400L);
        CameraControlUI viewOnClickListenerC3199a = this.f18514z;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19184j(this.f18503o, this.f18502n);
        }
        if (!mo19900dr() && !this.f18349J.mo10658L() && 3 != this.f18350K) {
            if (!m19518fh() && !mo18201d() && !m19919eG()) {
                NightTimeView nightTimeView = this.f18345F;
                if (nightTimeView == null || nightTimeView.getVisibility() != 0) {
                    mo18068a(0, 1);
                }
            } else if (m19518fh() && !m19898dp() && !m19864dH()) {
                mo18077a(0, false);
                mo18105a(true);
            }
        }
        if (!m19755bO() && !this.f18349J.mo10829d()) {
            mo18215g(0);
        }
        this.f18420bC = false;
        m19558gj();
    }

    /* renamed from: fZ */
    private void m19510fZ() {
        CameraLog.m12954a("CameraUIManager", "relayoutViewForNavBarChange");
        this.f18467bx.mo16573a_(this.f18497i);
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo19673a(BaseScreenMode abstractC2934a, Size size, long OplusGLSurfaceView_15) {
        if (this.f18349J != null) {
            mo18095a((OplusViewOutlineProvider) null);
        }
        if (Util.m24498u()) {
            Rect rectB = abstractC2934a.mo16558b(size.getHeight(), size.getWidth());
            int iM19646a = m19646a(Util.m24426d(size.getWidth(), size.getHeight()), abstractC2934a);
            InverseChangeModeData c3224b = new InverseChangeModeData();
            c3224b.f18738a = abstractC2934a.mo16539j();
            c3224b.f18744g = abstractC2934a.mo16630q();
            c3224b.f18739b = abstractC2934a.mo16570k();
            c3224b.f18740c = iM19646a;
            c3224b.f18742e = (long) this.f18340A.m23307H();
            c3224b.f18741d = (rectB.top + rectB.bottom) / 2.0f;
            c3224b.f18743f = OplusGLSurfaceView_15;
            InverseManager.INS.setMaskToLayoutMode(this.f18497i, c3224b);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: eK */
    public void mo19923eK() {
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener != null) {
            cameraUIListener.mo10820ce();
            mo18095a(this.f18349J.mo10824ci());
        }
    }

    /* renamed from: ga */
    private boolean m19549ga() {
        KeyguardManager keyguardManager;
        Activity activity = this.f18497i;
        if (activity == null || (keyguardManager = (KeyguardManager) activity.getApplicationContext().getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.isDeviceLocked();
    }

    /* renamed from: gb */
    private void m19550gb() {
        this.f18430bM = new RotateAnimationView(this.f18497i);
        this.f18430bM.setLightBackground(m19469eQ());
        this.f18430bM.setId(R.id_renamed.time_lapse_pro_template_button);
        this.f18430bM.setImageResource(R.drawable.time_lapse_pro_template_button);
        this.f18430bM.setBackgroundResource(R.drawable.face_beauty_menu_control_button_background);
        int OplusGLSurfaceView_13 = this.f18341B.getInt("pref_time_lapse_pro_template_key", 0);
        boolean z = this.f18341B.getBoolean(CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS, false);
        if (OplusGLSurfaceView_13 != 0 && !z) {
            this.f18430bM.setImageTintList(ColorStateList.valueOf(ContextCompat.m2254c(this.f18497i, R.color.time_lapse_pro_seek_value_desc_color)));
        }
        this.f18430bM.setOnClickListener(this.f18487cq);
        Resources resources = this.f18497i.getApplication().getResources();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width), resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_height));
        layoutParams.addRule(9);
        layoutParams.addRule(2, R.id_renamed.control_panel_layout);
        layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.time_lapse_pro_button_margin_left), 0, 0, resources.getDimensionPixelSize(R.dimen.face_beauty_enter_button_margin_bottom));
        this.f18365Z.addView(this.f18430bM, layoutParams);
        mo19936ej().m16503a(this.f18430bM);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: o */
    public void mo18252o(boolean z, boolean z2) {
        CameraLog.m12954a("CameraUIManager", "showTimeLapseProTemplateButton, needAnim : " + z);
        if (mo18057R()) {
            return;
        }
        if (this.f18430bM == null) {
            m19550gb();
        }
        if (this.f18341B.getBoolean(CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS, false)) {
            this.f18475ce.mo17765a(0);
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || !cameraUIListener.mo10814c()) {
            AnimatorSet animatorSet = this.f18390aY;
            if (animatorSet != null && animatorSet.isRunning()) {
                CameraLog.m12954a("CameraUIManager", "showTimeLapseProTemplateButton, cancel");
                this.f18390aY.cancel();
            } else if (this.f18430bM.isShown()) {
                CameraLog.m12954a("CameraUIManager", "showTimeLapseProTemplateButton, return.");
                return;
            }
            if (z) {
                m19393a(this.f18430bM, z2, this.f18390aY, new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.63
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (CameraUIManager.this.f18430bM != null) {
                            CameraUIManager.this.f18430bM.setEnabled(false);
                            CameraUIManager.this.f18430bM.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (CameraUIManager.this.f18430bM != null) {
                            CameraUIManager.this.f18430bM.setEnabled(true);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (CameraUIManager.this.f18430bM != null) {
                            CameraUIManager.this.f18430bM.setEnabled(true);
                        }
                    }
                });
                return;
            }
            this.f18430bM.setEnabled(true);
            this.f18430bM.setVisibility(0);
            this.f18430bM.setAlpha(255);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: p */
    public void mo18256p(boolean z, boolean z2) {
        CameraLog.m12954a("CameraUIManager", "hideTimeLapseProTemplateButton, needAnim: " + z + ", needTranslateAni: " + z2);
        AnimatorSet animatorSet = this.f18390aY;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f18390aY.cancel();
        }
        RotateAnimationView rotateAnimationView = this.f18430bM;
        if (rotateAnimationView == null) {
            return;
        }
        if (z) {
            m19448b(rotateAnimationView, z2, this.f18390aY, new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.64
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator, boolean z3) {
                    if (CameraUIManager.this.f18430bM == null || !CameraUIManager.this.f18430bM.isShown()) {
                        return;
                    }
                    CameraUIManager.this.f18430bM.setEnabled(false);
                    CameraUIManager.this.f18430bM.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator, boolean z3) {
                    if (CameraUIManager.this.f18430bM != null) {
                        CameraUIManager.this.f18430bM.setEnabled(true);
                        CameraUIManager.this.f18430bM.setVisibility(8);
                    }
                }
            });
        } else {
            rotateAnimationView.setVisibility(8);
        }
    }

    /* renamed from: gc */
    private void m19551gc() {
        this.f18431bN = new RotateAnimationView(this.f18497i);
        this.f18431bN.setLightBackground(m19469eQ());
        this.f18431bN.setId(R.id_renamed.time_lapse_pro_setting_button);
        this.f18431bN.setImageResource(R.drawable.time_lapse_pro_setting_button);
        this.f18431bN.setBackgroundResource(R.drawable.face_beauty_menu_control_button_background);
        this.f18431bN.setOnClickListener(this.f18487cq);
        Resources resources = this.f18497i.getApplication().getResources();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width), resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_height));
        layoutParams.addRule(11);
        layoutParams.addRule(2, R.id_renamed.control_panel_layout);
        layoutParams.setMargins(0, 0, resources.getDimensionPixelSize(R.dimen.time_lapse_pro_button_margin_left), resources.getDimensionPixelSize(R.dimen.face_beauty_enter_button_margin_bottom));
        this.f18365Z.addView(this.f18431bN, layoutParams);
        mo19936ej().m16503a(this.f18431bN);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: q */
    public void mo18260q(boolean z, boolean z2) {
        if (mo18057R()) {
            return;
        }
        if (this.f18431bN == null) {
            m19551gc();
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || !cameraUIListener.mo10814c()) {
            AnimatorSet animatorSet = this.f18391aZ;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.f18391aZ.cancel();
            } else if (this.f18431bN.isShown()) {
                return;
            }
            if (z) {
                m19393a(this.f18431bN, z2, this.f18391aZ, new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.66
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (CameraUIManager.this.f18431bN != null) {
                            CameraUIManager.this.f18431bN.setEnabled(false);
                            CameraUIManager.this.f18431bN.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (CameraUIManager.this.f18431bN != null) {
                            CameraUIManager.this.f18431bN.setEnabled(true);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (CameraUIManager.this.f18431bN != null) {
                            CameraUIManager.this.f18431bN.setEnabled(true);
                        }
                    }
                });
            } else {
                this.f18431bN.setVisibility(0);
                this.f18431bN.setEnabled(true);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: r */
    public void mo18264r(boolean z, boolean z2) {
        AnimatorSet animatorSet = this.f18391aZ;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f18391aZ.cancel();
        }
        RotateAnimationView rotateAnimationView = this.f18431bN;
        if (rotateAnimationView == null) {
            return;
        }
        if (z) {
            m19448b(rotateAnimationView, z2, this.f18391aZ, new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.67
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator, boolean z3) {
                    if (CameraUIManager.this.f18431bN == null || !CameraUIManager.this.f18431bN.isShown()) {
                        return;
                    }
                    CameraUIManager.this.f18431bN.setEnabled(false);
                    CameraUIManager.this.f18431bN.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator, boolean z3) {
                    if (CameraUIManager.this.f18431bN != null) {
                        CameraUIManager.this.f18431bN.setEnabled(true);
                        CameraUIManager.this.f18431bN.setVisibility(8);
                    }
                }
            });
        } else {
            rotateAnimationView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aM */
    public void m19412aM(boolean z) throws IllegalStateException {
        int screenHeight;
        int screenWidth;
        int screenWidth2;
        final float COUIBaseListPopupWindow_12;
        if (this.f18434bQ == null) {
            m19552gd();
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || !cameraUIListener.mo10814c()) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                Util.getScreenHeight();
                final String str = "translationX";
                if (1 == this.f18467bx.mo16539j()) {
                    if (this.f18467bx.mo16570k() == 0) {
                        screenHeight = Util.getScreenHeight();
                        COUIBaseListPopupWindow_12 = screenHeight;
                        str = "translationY";
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18434bQ, str, COUIBaseListPopupWindow_12, 0.0f);
                        objectAnimatorOfFloat.setInterpolator(this.f18445bb);
                        objectAnimatorOfFloat.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        CameraUIManager.this.f18434bQ.setTranslationX(COUIBaseListPopupWindow_12);
                                    } else {
                                        CameraUIManager.this.f18434bQ.setTranslationY(COUIBaseListPopupWindow_12);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    } else if (90 == this.f18467bx.mo16570k()) {
                        screenWidth2 = Util.getScreenWidth();
                        screenWidth = -screenWidth2;
                        COUIBaseListPopupWindow_12 = screenWidth;
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18434bQ, str, COUIBaseListPopupWindow_12, 0.0f);
                        objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
                        objectAnimatorOfFloat2.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat2);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        CameraUIManager.this.f18434bQ.setTranslationX(COUIBaseListPopupWindow_12);
                                    } else {
                                        CameraUIManager.this.f18434bQ.setTranslationY(COUIBaseListPopupWindow_12);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    } else {
                        screenWidth = Util.getScreenWidth();
                        COUIBaseListPopupWindow_12 = screenWidth;
                        ObjectAnimator objectAnimatorOfFloat22 = ObjectAnimator.ofFloat(this.f18434bQ, str, COUIBaseListPopupWindow_12, 0.0f);
                        objectAnimatorOfFloat22.setInterpolator(this.f18445bb);
                        objectAnimatorOfFloat22.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat22);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        CameraUIManager.this.f18434bQ.setTranslationX(COUIBaseListPopupWindow_12);
                                    } else {
                                        CameraUIManager.this.f18434bQ.setTranslationY(COUIBaseListPopupWindow_12);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    }
                } else if (4 == this.f18467bx.mo16539j()) {
                    if (90 == this.f18467bx.mo16570k()) {
                        screenWidth2 = Util.getScreenWidth();
                        screenWidth = -screenWidth2;
                        COUIBaseListPopupWindow_12 = screenWidth;
                        ObjectAnimator objectAnimatorOfFloat222 = ObjectAnimator.ofFloat(this.f18434bQ, str, COUIBaseListPopupWindow_12, 0.0f);
                        objectAnimatorOfFloat222.setInterpolator(this.f18445bb);
                        objectAnimatorOfFloat222.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat222);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        CameraUIManager.this.f18434bQ.setTranslationX(COUIBaseListPopupWindow_12);
                                    } else {
                                        CameraUIManager.this.f18434bQ.setTranslationY(COUIBaseListPopupWindow_12);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    } else {
                        screenWidth = Util.getScreenWidth();
                        COUIBaseListPopupWindow_12 = screenWidth;
                        ObjectAnimator objectAnimatorOfFloat2222 = ObjectAnimator.ofFloat(this.f18434bQ, str, COUIBaseListPopupWindow_12, 0.0f);
                        objectAnimatorOfFloat2222.setInterpolator(this.f18445bb);
                        objectAnimatorOfFloat2222.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat2222);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        CameraUIManager.this.f18434bQ.setTranslationX(COUIBaseListPopupWindow_12);
                                    } else {
                                        CameraUIManager.this.f18434bQ.setTranslationY(COUIBaseListPopupWindow_12);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (CameraUIManager.this.f18434bQ != null) {
                                    CameraUIManager.this.f18434bQ.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    }
                } else {
                    screenHeight = Util.getScreenHeight();
                    COUIBaseListPopupWindow_12 = screenHeight;
                    str = "translationY";
                    ObjectAnimator objectAnimatorOfFloat22222 = ObjectAnimator.ofFloat(this.f18434bQ, str, COUIBaseListPopupWindow_12, 0.0f);
                    objectAnimatorOfFloat22222.setInterpolator(this.f18445bb);
                    objectAnimatorOfFloat22222.setDuration(400L);
                    animatorSet.play(objectAnimatorOfFloat22222);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.68
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            if (CameraUIManager.this.f18434bQ != null) {
                                CameraUIManager.this.f18434bQ.setVisibility(0);
                                if ("translationX".equals(str)) {
                                    CameraUIManager.this.f18434bQ.setTranslationX(COUIBaseListPopupWindow_12);
                                } else {
                                    CameraUIManager.this.f18434bQ.setTranslationY(COUIBaseListPopupWindow_12);
                                }
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (CameraUIManager.this.f18434bQ != null) {
                                CameraUIManager.this.f18434bQ.setTranslationY(0.0f);
                            }
                        }
                    });
                    animatorSet.start();
                }
            } else {
                TimeLapseProGuideLayout c3070f = this.f18434bQ;
                if (c3070f != null) {
                    c3070f.setVisibility(0);
                }
            }
            TimeLapseProGuideLayout c3070f2 = this.f18434bQ;
            if (c3070f2 != null) {
                c3070f2.setCurrentScreenMode(this.f18467bx);
                this.f18434bQ.m17633a();
            }
        }
    }

    /* renamed from: aA */
    public void m19699aA(boolean z) {
        int screenHeight;
        int screenWidth;
        int screenWidth2;
        float COUIBaseListPopupWindow_12;
        TimeLapseProGuideLayout c3070f = this.f18434bQ;
        if (c3070f == null) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            Util.getScreenHeight();
            final String str = "translationX";
            if (1 == this.f18467bx.mo16539j()) {
                if (this.f18467bx.mo16570k() == 0) {
                    screenHeight = Util.getScreenHeight();
                    COUIBaseListPopupWindow_12 = screenHeight;
                    str = "translationY";
                } else if (90 == this.f18467bx.mo16570k()) {
                    screenWidth2 = Util.getScreenWidth();
                    screenWidth = -screenWidth2;
                    COUIBaseListPopupWindow_12 = screenWidth;
                } else {
                    screenWidth = Util.getScreenWidth();
                    COUIBaseListPopupWindow_12 = screenWidth;
                }
            } else if (4 == this.f18467bx.mo16539j()) {
                if (90 == this.f18467bx.mo16570k()) {
                    screenWidth2 = Util.getScreenWidth();
                    screenWidth = -screenWidth2;
                    COUIBaseListPopupWindow_12 = screenWidth;
                } else {
                    screenWidth = Util.getScreenWidth();
                    COUIBaseListPopupWindow_12 = screenWidth;
                }
            } else {
                screenHeight = Util.getScreenHeight();
                COUIBaseListPopupWindow_12 = screenHeight;
                str = "translationY";
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18434bQ, str, 0.0f, COUIBaseListPopupWindow_12);
            objectAnimatorOfFloat.setInterpolator(this.f18445bb);
            objectAnimatorOfFloat.setDuration(400L);
            animatorSet.play(objectAnimatorOfFloat);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.69
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (CameraUIManager.this.f18434bQ != null) {
                        CameraUIManager.this.f18434bQ.setVisibility(8);
                        if ("translationX".equals(str)) {
                            CameraUIManager.this.f18434bQ.setTranslationX(0.0f);
                        } else {
                            CameraUIManager.this.f18434bQ.setTranslationY(0.0f);
                        }
                    }
                }
            });
            animatorSet.start();
            return;
        }
        c3070f.setVisibility(8);
    }

    /* renamed from: gd */
    private void m19552gd() {
        this.f18434bQ = new TimeLapseProGuideLayout(this.f18497i, new TimeLapseProGuideLayout.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.70
            @Override // com.oplus.camera.timelapsepro.TimeLapseProGuideLayout.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17635a() {
                CameraUIManager.this.m19699aA(true);
            }
        });
        this.f18434bQ.setVisibility(8);
        ((RelativeLayout) this.f18392aa).addView(this.f18434bQ);
        this.f18434bQ.setCurrentScreenMode(this.f18467bx);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aZ */
    public void mo18136aZ() {
        TimeLapseProGuideLayout c3070f = this.f18434bQ;
        if (c3070f != null) {
            ((RelativeLayout) this.f18392aa).removeView(c3070f);
            this.f18434bQ = null;
        }
    }

    /* renamed from: ge */
    private void m19553ge() throws Resources.NotFoundException {
        this.f18432bO = new RotateAnimationView(this.f18497i);
        this.f18432bO.setId(R.id_renamed.time_lapse_pro_guide_button);
        this.f18432bO.setImageResource(R.drawable.professional_mode_guide_icon);
        this.f18432bO.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.71
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws IllegalStateException {
                CameraUIManager.this.m19412aM(true);
            }
        });
        int dimensionPixelSize = (this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_touch_width) - this.f18432bO.getDrawable().getIntrinsicWidth()) / 2;
        this.f18432bO.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        int iM24186N = Util.m24186N();
        RelativeLayout relativeLayoutMo18253p = mo18253p();
        if (relativeLayoutMo18253p != null && relativeLayoutMo18253p.getTop() > iM24186N) {
            iM24186N = relativeLayoutMo18253p.getTop();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int dimensionPixelSize2 = iM24186N + this.f18497i.getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
        int dimensionPixelSize3 = this.f18497i.getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_guide_entry_margin_end);
        layoutParams.topMargin = dimensionPixelSize2 - dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize3 - dimensionPixelSize;
        this.f18365Z.addView(this.f18432bO, layoutParams);
        mo19936ej().m16503a(this.f18432bO);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: N */
    public void mo18049N(boolean z) {
        CameraLog.m12954a("CameraUIManager", "showTimeLapseProGuideButton, needAnim: " + z);
        if (mo18057R()) {
            return;
        }
        if (this.f18432bO == null) {
            m19553ge();
        }
        CameraUIListener cameraUIListener = this.f18349J;
        if (cameraUIListener == null || !cameraUIListener.mo10814c()) {
            if (z) {
                Util.m24266a(this.f18432bO, 250);
            } else {
                this.f18432bO.setVisibility(0);
                this.f18432bO.setEnabled(true);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: O */
    public void mo18050O(boolean z) {
        CameraLog.m12954a("CameraUIManager", "hideTimeLapseProGuideButton, needAnim: " + z);
        RotateAnimationView rotateAnimationView = this.f18432bO;
        if (rotateAnimationView == null) {
            return;
        }
        if (z) {
            Util.m24388b(rotateAnimationView, 250);
        } else {
            rotateAnimationView.setVisibility(8);
        }
    }

    /* renamed from: eL */
    public boolean m19924eL() {
        return this.f18442bY;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: s */
    public void mo18268s(boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f18340A != null) {
            int OplusGLSurfaceView_13 = this.f18440bW;
            if (OplusGLSurfaceView_13 < 0) {
                this.f18440bW = -OplusGLSurfaceView_13;
            }
            m19854d(z, z2, true);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: t */
    public void mo18272t(boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f18340A != null) {
            int OplusGLSurfaceView_13 = this.f18440bW;
            if (OplusGLSurfaceView_13 < 0) {
                this.f18440bW = -OplusGLSurfaceView_13;
            }
            m19854d(z, z2, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19393a(View view, boolean z, AnimatorSet animatorSet, AnimatorListenerAdapter animatorListenerAdapter) {
        m19392a(view, animatorSet, false, z, animatorListenerAdapter);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m19448b(View view, boolean z, AnimatorSet animatorSet, AnimatorListenerAdapter animatorListenerAdapter) {
        m19392a(view, animatorSet, true, z, animatorListenerAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m19392a(final android.view.View r7, android.animation.AnimatorSet r8, boolean r9, boolean r10, android.animation.AnimatorListenerAdapter r11) {
        /*
            r6 = this;
            if (r8 == 0) goto Lb
            boolean r0 = r8.isRunning()
            if (r0 == 0) goto Lb
            r8.cancel()
        Lb:
            java.lang.String r8 = "alpha"
            r0 = 2
            if (r9 == 0) goto L1a
            float[] r1 = new float[r0]
            r1 = {x00b0: FILL_ARRAY_DATA , data: [1065353216, 0} // fill-array
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r7, r8, r1)
            goto L23
        L1a:
            float[] r1 = new float[r0]
            r1 = {x00b8: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r7, r8, r1)
        L23:
            android.view.animation.PathInterpolator r1 = r6.f18444ba
            r8.setInterpolator(r1)
            if (r9 == 0) goto L2d
            r1 = 250(0xfa, double:1.235E-321)
            goto L35
        L2d:
            if (r10 == 0) goto L32
            r1 = 400(0x190, float:5.6E-43)
            goto L34
        L32:
            r1 = 250(0xfa, float:3.5E-43)
        L34:
            long r1 = (long) r1
        L35:
            r8.setDuration(r1)
            android.animation.AnimatorSet r1 = new android.animation.AnimatorSet
            r1.<init>()
            android.animation.AnimatorSet$Builder r8 = r1.play(r8)
            r2 = 0
            if (r10 == 0) goto L9e
            com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 r10 = r6.f18467bx
            int r10 = r10.mo16539j()
            java.lang.String r3 = "translationX"
            r4 = 1
            if (r4 != r10) goto L60
            r10 = 270(0x10e, float:3.78E-43)
            com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 r5 = r6.f18467bx
            int r5 = r5.mo16570k()
            if (r10 != r5) goto L5d
            int r10 = r6.f18465bv
            int r10 = -r10
            goto L6b
        L5d:
            int r10 = r6.f18465bv
            goto L6b
        L60:
            r10 = 4
            com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 r5 = r6.f18467bx
            int r5 = r5.mo16539j()
            if (r10 != r5) goto L6d
            int r10 = r6.f18465bv
        L6b:
            float r10 = (float) r10
            goto L73
        L6d:
            int r10 = r6.f18465bv
            int r10 = -r10
            float r10 = (float) r10
            java.lang.String r3 = "translationY"
        L73:
            r5 = 0
            if (r9 == 0) goto L81
            float[] r9 = new float[r0]
            r9[r5] = r2
            r9[r4] = r10
            android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofFloat(r7, r3, r9)
            goto L90
        L81:
            float[] r9 = new float[r0]
            r9[r5] = r10
            r9[r4] = r2
            android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofFloat(r7, r3, r9)
            r2 = 150(0x96, double:7.4E-322)
            r1.setStartDelay(r2)
        L90:
            android.view.animation.PathInterpolator r10 = r6.f18445bb
            r9.setInterpolator(r10)
            r2 = 400(0x190, double:1.976E-321)
            r9.setDuration(r2)
            r8.with(r9)
            goto La1
        L9e:
            r7.setTranslationY(r2)
        La1:
            r1.addListener(r11)
            com.oplus.camera.ui.IntrinsicsJvm.kt_5$72 r8 = new com.oplus.camera.ui.IntrinsicsJvm.kt_5$72
            r8.<init>()
            r1.addListener(r8)
            r1.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.CameraUIManager.m19392a(android.view.View, android.animation.AnimatorSet, boolean, boolean, android.animation.AnimatorListenerAdapter):void");
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: aY */
    public TimeLapseProMenuLayout mo18135aY() throws Resources.NotFoundException {
        if (this.f18433bP == null) {
            m19554gf();
        }
        return this.f18433bP;
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: ba */
    public void mo18178ba() {
        m19614A(true, true);
        if (1 == this.f18467bx.mo16539j()) {
            m19983w(false, true);
        } else if (4 == this.f18467bx.mo16539j()) {
            mo18215g(4);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: bb */
    public void mo18179bb() {
        m19614A(true, true);
        if (1 == this.f18467bx.mo16539j()) {
            m19983w(false, true);
        } else if (4 == this.f18467bx.mo16539j()) {
            mo18215g(4);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: Q */
    public void mo18054Q(boolean z) {
        m19614A(false, z);
        if (1 == this.f18467bx.mo16539j()) {
            m19983w(true, z);
        } else if (4 == this.f18467bx.mo16539j()) {
            mo18215g(0);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18084a(View.OnClickListener onClickListener) {
        this.f18486cp = onClickListener;
    }

    /* renamed from: eM */
    public void m19925eM() {
        mo18054Q(true);
        TimeLapseProMenuLayout c3071g = this.f18433bP;
        if (c3071g != null) {
            m19855d(false, false, c3071g.m17745c(), true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19854d(boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        m19855d(z, z2, z3, true);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m19855d(boolean z, boolean z2, boolean z3, boolean z4) throws Resources.NotFoundException {
        this.f18442bY = true;
        CameraLog.m12954a("CameraUIManager", "showTimeLapseProTemplatePanel, show : " + z + ", needAnimation : " + z2 + ", showTemplate : " + z3 + ", mbShowTimeLapseProPanel : " + this.f18442bY);
        if (z) {
            if (this.f18433bP == null) {
                m19554gf();
                this.f18433bP.setSettingValues(this.f18341B.getString(CameraUIInterface.KEY_TIME_LAPSE_PRO_VIDEO_SPEED, this.f18497i.getString(R.string.time_lapse_pro_speed_15x)));
            }
            this.f18471ca = this.f18341B.getInt("pref_time_lapse_pro_template_key", 0);
            this.f18433bP.m17741a(this.f18475ce);
            this.f18433bP.setShowTemplate(z3);
            if (1 != this.f18467bx.mo16539j() && !z3 && z4) {
                if (m19518fh()) {
                    if (this.f18375aJ != null) {
                        if (4 == this.f18467bx.mo16539j() && this.f18433bP.isShown()) {
                            this.f18375aJ.m21953b(false, -1);
                        } else {
                            this.f18375aJ.m21951b(AnimationUtils.loadAnimation(this.f18497i, R.anim.zoom_panel_level_out));
                        }
                    }
                } else if (this.f18514z != null) {
                    if (z2 && 4 != this.f18467bx.mo16539j()) {
                        this.f18514z.m19173h();
                    } else {
                        this.f18514z.m19078a(0);
                    }
                }
            }
            if (4 == this.f18467bx.mo16539j() && z3 && z4) {
                if (m19518fh()) {
                    ModePanelUIControl c3355m = this.f18375aJ;
                    if (c3355m != null) {
                        c3355m.m21949a(false, -1);
                    }
                } else {
                    CameraControlUI viewOnClickListenerC3199a = this.f18514z;
                    if (viewOnClickListenerC3199a != null) {
                        viewOnClickListenerC3199a.m19140b(0);
                    }
                }
            }
            if (4 == this.f18467bx.mo16539j()) {
                mo18050O(true);
            }
            if (z2) {
                m19413aN(true);
                return;
            } else {
                this.f18433bP.setVisibility(0);
                this.f18442bY = false;
                return;
            }
        }
        TimeLapseProMenuLayout c3071g = this.f18433bP;
        if (c3071g != null) {
            if (z2) {
                m19348E(true, z3);
            } else {
                c3071g.setVisibility(8);
                if (!z3) {
                    this.f18433bP.m17747e();
                }
                this.f18442bY = false;
            }
            this.f18433bP.m17755m();
            if (1 != this.f18467bx.mo16539j() && !z3 && !this.f18349J.mo10814c() && z4) {
                if (m19518fh()) {
                    ModePanelUIControl c3355m2 = this.f18375aJ;
                    if (c3355m2 != null) {
                        c3355m2.m21944a(AnimationUtils.loadAnimation(this.f18497i, R.anim.zoom_panel_level_in));
                    }
                } else {
                    CameraControlUI viewOnClickListenerC3199a2 = this.f18514z;
                    if (viewOnClickListenerC3199a2 != null) {
                        if (z2) {
                            viewOnClickListenerC3199a2.m19147b(true, true);
                        } else {
                            viewOnClickListenerC3199a2.m19140b(0);
                        }
                    }
                }
            }
            if (4 == this.f18467bx.mo16539j()) {
                mo18049N(true);
            }
        }
    }

    /* renamed from: aN */
    private void m19413aN(boolean z) {
        float COUIBaseListPopupWindow_12;
        String str;
        AnimatorSet animatorSet = this.f18437bT;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f18437bT.end();
        } else {
            if (this.f18433bP.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f18436bS;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            this.f18433bP.setAlpha(0.0f);
            this.f18433bP.setVisibility(0);
            this.f18436bS = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18433bP, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.f18444ba);
            objectAnimatorOfFloat.setDuration(400L);
            if (1 == this.f18467bx.mo16539j()) {
                COUIBaseListPopupWindow_12 = 270 == this.f18467bx.mo16570k() ? this.f18440bW : -this.f18440bW;
                str = "translationX";
            } else {
                COUIBaseListPopupWindow_12 = this.f18440bW;
                str = "translationY";
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18433bP, str, COUIBaseListPopupWindow_12, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
            objectAnimatorOfFloat2.setDuration(400L);
            this.f18436bS.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.f18436bS.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.73
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (CameraUIManager.this.f18433bP != null) {
                        CameraUIManager.this.f18433bP.setAnimationState(true);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (CameraUIManager.this.f18433bP != null) {
                        CameraUIManager.this.f18433bP.setAnimationState(false);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator, boolean z2) {
                    if (CameraUIManager.this.f18433bP != null) {
                        CameraUIManager.this.f18433bP.setAlpha(1.0f);
                        CameraUIManager.this.f18433bP.setTranslationY(0.0f);
                        CameraUIManager.this.f18433bP.setTranslationX(0.0f);
                        CameraUIManager.this.f18433bP.setVisibility(0);
                        CameraUIManager.this.f18433bP.setAnimationState(false);
                    }
                    CameraUIManager.this.f18442bY = false;
                }
            });
            this.f18436bS.setStartDelay(150L);
            this.f18436bS.start();
            return;
        }
        this.f18433bP.setVisibility(0);
    }

    /* renamed from: E */
    private void m19348E(boolean z, final boolean z2) throws Resources.NotFoundException {
        float COUIBaseListPopupWindow_12;
        String str;
        AnimatorSet animatorSet = this.f18436bS;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f18436bS.cancel();
        } else {
            TimeLapseProMenuLayout c3071g = this.f18433bP;
            if (c3071g != null && !c3071g.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f18437bT;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            this.f18437bT = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18433bP, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f18444ba);
            objectAnimatorOfFloat.setDuration(250L);
            if (1 == this.f18467bx.mo16539j()) {
                COUIBaseListPopupWindow_12 = 270 == this.f18467bx.mo16570k() ? this.f18440bW : -this.f18440bW;
                str = "translationX";
            } else {
                COUIBaseListPopupWindow_12 = this.f18440bW;
                str = "translationY";
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18433bP, str, 0.0f, COUIBaseListPopupWindow_12);
            objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
            objectAnimatorOfFloat2.setDuration(400L);
            this.f18437bT.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.f18437bT.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.74
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
                    if (CameraUIManager.this.f18433bP != null) {
                        CameraUIManager.this.f18433bP.setVisibility(8);
                        CameraUIManager.this.f18433bP.setTranslationY(0.0f);
                        CameraUIManager.this.f18433bP.setTranslationX(0.0f);
                        CameraUIManager.this.f18433bP.setAlpha(0.0f);
                        CameraUIManager.this.f18433bP.setAnimationState(false);
                        if (!z2) {
                            CameraUIManager.this.f18433bP.m17747e();
                        }
                    }
                    CameraUIManager.this.f18442bY = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (CameraUIManager.this.f18433bP != null) {
                        CameraUIManager.this.f18433bP.setAnimationState(false);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (CameraUIManager.this.f18433bP != null) {
                        CameraUIManager.this.f18433bP.setAnimationState(true);
                        CameraUIManager.this.f18433bP.setVisibility(0);
                        CameraUIManager.this.f18433bP.setTranslationY(0.0f);
                        CameraUIManager.this.f18433bP.setTranslationX(0.0f);
                        CameraUIManager.this.f18433bP.setAlpha(1.0f);
                    }
                }
            });
            this.f18437bT.start();
            return;
        }
        TimeLapseProMenuLayout c3071g2 = this.f18433bP;
        if (c3071g2 != null) {
            c3071g2.setVisibility(8);
            if (z2) {
                return;
            }
            this.f18433bP.m17747e();
        }
    }

    /* renamed from: gf */
    private void m19554gf() throws Resources.NotFoundException {
        this.f18440bW = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
        this.f18433bP = new TimeLapseProMenuLayout(this.f18497i, this.f18341B);
        this.f18433bP.setCurrentScreenMode(this.f18467bx);
        this.f18433bP.setId(R.id_renamed.time_lapse_pro_layout);
        this.f18433bP.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_panel_margin_bottom_vertical);
        this.f18433bP.setHintCallback(new TimeLapseProMenuLayout.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.76
            @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17760a(int OplusGLSurfaceView_13, boolean z, Object... objArr) {
                if (CameraUIManager.this.f18394ac != null) {
                    if (-1 != OplusGLSurfaceView_13) {
                        CameraUIManager.this.f18394ac.m18475a(OplusGLSurfaceView_13, !z, z, 3000, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, 0, false, false, true, -1, objArr);
                    } else {
                        CameraUIManager.this.f18394ac.m18496c(true);
                    }
                }
            }
        });
        this.f18365Z.addView(this.f18433bP, layoutParams);
        mo19936ej().mo16573a_(this.f18497i);
        mo19936ej().m16503a(this.f18433bP);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: u */
    public void mo18276u(boolean z, boolean z2) throws Resources.NotFoundException {
        CameraLog.m12954a("CameraUIManager", "showTimeLapseProRecord, show: " + z + ", needAnimation: " + z2);
        TimeLapseProMenuLayout c3071g = this.f18433bP;
        if (c3071g != null && c3071g.isShown()) {
            int OplusGLSurfaceView_13 = this.f18440bW;
            if (OplusGLSurfaceView_13 > 0) {
                this.f18440bW = -OplusGLSurfaceView_13;
            }
            m19854d(!z, 1 != this.f18467bx.mo16539j(), this.f18433bP.m17745c());
            if (1 == this.f18467bx.mo16539j()) {
                m19614A(false, false);
            }
        }
        if (z) {
            if (this.f18435bR == null) {
                m19555gg();
            }
            this.f18435bR.m17931a(0L, 0L, true);
            m19414aO(z2);
            return;
        }
        if (this.f18435bR != null) {
            m19415aP(z2);
        }
    }

    /* renamed from: aO */
    private void m19414aO(boolean z) {
        AnimatorSet animatorSet;
        CameraLog.m12954a("CameraUIManager", "showRecord, needAnim: " + z);
        if (!z) {
            this.f18435bR.setVisibility(0);
            return;
        }
        AnimatorSet animatorSet2 = this.f18439bV;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            CameraLog.m12954a("CameraUIManager", "hideRecord, end hide. ");
            this.f18439bV.end();
        } else if (this.f18435bR.isShown() || ((animatorSet = this.f18438bU) != null && animatorSet.isStarted())) {
            CameraLog.m12954a("CameraUIManager", "showRecord, return. ");
            return;
        }
        this.f18435bR.setAlpha(0.0f);
        if (1 != this.f18467bx.mo16539j()) {
            this.f18435bR.setTranslationY(-this.f18441bX);
        }
        this.f18435bR.setVisibility(0);
        this.f18438bU = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18435bR, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f18444ba);
        objectAnimatorOfFloat.setDuration(300L);
        if (1 != this.f18467bx.mo16539j()) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18435bR, "translationY", this.f18441bX, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
            objectAnimatorOfFloat2.setDuration(300L);
            this.f18438bU.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        } else {
            this.f18438bU.play(objectAnimatorOfFloat);
        }
        this.f18438bU.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.77
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CameraUIManager.this.f18435bR != null) {
                    CameraUIManager.this.f18435bR.setAlpha(1.0f);
                    CameraUIManager.this.f18435bR.setTranslationY(0.0f);
                    CameraUIManager.this.f18435bR.setVisibility(0);
                }
            }
        });
        this.f18438bU.setStartDelay(150L);
        this.f18438bU.start();
    }

    /* renamed from: aP */
    private void m19415aP(boolean z) {
        AnimatorSet animatorSet;
        CameraLog.m12954a("CameraUIManager", "hideRecord, needAnim: " + z);
        if (!z) {
            this.f18435bR.setVisibility(8);
            this.f18435bR.m17930a();
            return;
        }
        AnimatorSet animatorSet2 = this.f18438bU;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            CameraLog.m12954a("CameraUIManager", "hideRecord, cancel show. ");
            this.f18438bU.cancel();
        } else {
            TimeLapseProRecordView c3073i = this.f18435bR;
            if ((c3073i != null && !c3073i.isShown()) || ((animatorSet = this.f18439bV) != null && animatorSet.isStarted())) {
                CameraLog.m12954a("CameraUIManager", "hideRecord, return. ");
                return;
            }
        }
        this.f18439bV = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18435bR, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f18444ba);
        objectAnimatorOfFloat.setDuration(250L);
        if (1 != this.f18467bx.mo16539j()) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f18435bR, "translationY", 0.0f, this.f18441bX);
            objectAnimatorOfFloat2.setInterpolator(this.f18445bb);
            objectAnimatorOfFloat2.setDuration(300L);
            this.f18439bV.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        } else {
            this.f18439bV.play(objectAnimatorOfFloat);
        }
        this.f18439bV.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_5.78
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (CameraUIManager.this.f18435bR != null) {
                    CameraUIManager.this.f18435bR.setVisibility(0);
                    CameraUIManager.this.f18435bR.setTranslationY(0.0f);
                    CameraUIManager.this.f18435bR.setAlpha(1.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CameraUIManager.this.f18435bR != null) {
                    CameraUIManager.this.f18435bR.setVisibility(8);
                    CameraUIManager.this.f18435bR.setTranslationY(0.0f);
                    CameraUIManager.this.f18435bR.setAlpha(0.0f);
                    CameraUIManager.this.f18435bR.m17930a();
                }
            }
        });
        this.f18439bV.start();
    }

    /* renamed from: gg */
    private void m19555gg() {
        this.f18441bX = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
        this.f18435bR = new TimeLapseProRecordView(this.f18497i);
        this.f18435bR.setId(R.id_renamed.time_lapse_pro_record_layout);
        this.f18435bR.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (2 == this.f18467bx.mo16539j() || 3 == this.f18467bx.mo16539j()) {
            layoutParams.bottomMargin = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_panel_margin_bottom_vertical);
        } else {
            layoutParams.bottomMargin = this.f18497i.getApplication().getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_record_margin_bottom_full_screen);
        }
        this.f18365Z.addView(this.f18435bR, layoutParams);
    }

    @Override // com.oplus.camera.p172ui.CameraUIInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18080a(long OplusGLSurfaceView_15, long j2, boolean z) {
        TimeLapseProRecordView c3073i = this.f18435bR;
        if (c3073i != null) {
            c3073i.m17931a(OplusGLSurfaceView_15, j2, z);
        }
    }

    /* renamed from: D */
    public void m19620D(boolean z, boolean z2) {
        if (ApsConstant.REC_MODE_TIMELASPE_PRO.equals(mo18132aV())) {
            if (1 == this.f18467bx.mo16539j() || 4 == this.f18467bx.mo16539j()) {
                m19983w(true, z);
            }
            TimeLapseProMenuLayout c3071g = this.f18433bP;
            if (c3071g != null && c3071g.isShown()) {
                m19614A(false, false);
                m19854d(false, z, this.f18433bP.m17745c());
                this.f18433bP.m17757o();
            }
            RotateAnimationView rotateAnimationView = this.f18430bM;
            if (rotateAnimationView != null && !rotateAnimationView.isShown() && !CameraCharacteristicsUtil.m12974a(mo19845cv())) {
                mo18252o(z, z2);
            }
            RotateAnimationView rotateAnimationView2 = this.f18431bN;
            if (rotateAnimationView2 != null && !rotateAnimationView2.isShown() && !CameraCharacteristicsUtil.m12974a(mo19845cv())) {
                mo18260q(z, z2);
            }
            if (this.f18349J == null || mo19900dr()) {
                return;
            }
            this.f18349J.mo10689a(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gh */
    public void m19556gh() {
        int dimensionPixelSize;
        if (this.f18377aL == null) {
            return;
        }
        if (this.f18383aR == null && (dimensionPixelSize = mo18163b().getResources().getDimensionPixelSize(R.dimen.face_beauty_enter_button_extra_touch_offset)) > 0) {
            Rect rect = new Rect();
            this.f18377aL.getHitRect(rect);
            rect.top -= dimensionPixelSize;
            rect.bottom += dimensionPixelSize;
            rect.left -= dimensionPixelSize;
            rect.right += dimensionPixelSize;
            this.f18383aR = new TouchDelegate(rect, this.f18377aL);
        }
        this.f18377aL.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$z0tanxuDFc6k0cSWABJt1aRm6O4
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m19560gl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gl */
    public /* synthetic */ void m19560gl() {
        if (mo18163b() != null) {
            mo18163b().setTouchDelegate(this.f18383aR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gi */
    public void m19557gi() {
        SplitBackgroundView splitBackgroundView = this.f18377aL;
        if (splitBackgroundView != null) {
            splitBackgroundView.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$IntrinsicsJvm.kt_5$or4ynPWLgqFW2Og7DEsPz6PP_nA
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m19559gk();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gk */
    public /* synthetic */ void m19559gk() {
        if (mo18163b() != null) {
            Rect rect = new Rect();
            rect.setEmpty();
            mo18163b().setTouchDelegate(new TouchDelegate(rect, this.f18377aL));
        }
    }

    /* renamed from: aB */
    public void m19700aB(boolean z) {
        this.f18506r = z;
    }

    /* renamed from: gj */
    private void m19558gj() {
        WindowInsetsController insetsController;
        Activity activity = this.f18497i;
        if (activity == null || (insetsController = activity.getWindow().getInsetsController()) == null || !Util.m24495t()) {
            return;
        }
        if (1 == mo19936ej().mo16539j() && mo19936ej().mo16570k() != 0) {
            insetsController.hide(WindowInsets.Type.navigationBars());
        } else {
            insetsController.show(WindowInsets.Type.navigationBars());
        }
    }

    /* renamed from: aC */
    public void m19701aC(boolean z) {
        CameraPreviewUI viewOnLayoutChangeListenerC3444g = this.f18340A;
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23423q(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo19651a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        for (SplitBackgroundView splitBackgroundView : this.f18473cc) {
            if (splitBackgroundView != null) {
                splitBackgroundView.m24042a(OplusGLSurfaceView_13, i2, i3, i4);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19684a(Runnable runnable) {
        this.f18340A.m23354a(runnable);
    }

    /* renamed from: eN */
    public boolean m19926eN() {
        FaceBeautyMenu viewOnClickListenerC3261g = this.f18385aT;
        return viewOnClickListenerC3261g != null && viewOnClickListenerC3261g.m20685j();
    }
}
