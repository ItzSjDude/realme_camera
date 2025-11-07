package com.oplus.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.bluetooth.OplusBluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.HardwareBuffer;
import android.hardware.cabc.CabcManager;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.fingerprint.OplusFingerprintManager;
import android.hardware.foss.FossManager;
import android.location.Address;
import android.location.Location;
import android.media.ExifInterface;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import android.util.Size;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.oplus.camera.SensorManagerClient;
import com.oplus.camera.ZoomManager;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.CameraPermission;
import com.oplus.camera.GestureEngineManager;
import com.oplus.camera.LocationManager;
import com.oplus.camera.PreviewImageProcess;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.service.ApsService;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.service.CaptureRequestParam;
import com.oplus.camera.aps.service.ThumbnailCategory;
import com.oplus.camera.aps.service.ThumbnailItem;
import com.oplus.camera.aps.service.ThumbnailProcessor;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CommonCapMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.capmode.ContentOperatedCallback;
import com.oplus.camera.capmode.ModeManager;
import com.oplus.camera.capmode.p139a.MultiCameraDecision;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.camera.doubleexposure.EffectType;
import com.oplus.camera.doubleexposure.VideoClipManager;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p136a.CaptureMsgDataReportUtil;
import com.oplus.camera.p136a.ImageProductProcessor;
import com.oplus.camera.p136a.PictureTakenCallback;
import com.oplus.camera.p136a.SuperTextResultProcessor;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCameraProxy;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OplusMeteringRectangle;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p143f.DiagnosisTools;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p146gl.GLRootView;
import com.oplus.camera.p146gl.p148b.MultiVideoSmallSurfaceTouchEventHelper;
import com.oplus.camera.p150i.FeatureFactory;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p154m.ProcessQueueThread;
import com.oplus.camera.p154m.CallGalleryPreDecodeThread;
import com.oplus.camera.p154m.ImageSaverThread;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p171u.SuperTextManager;
import com.oplus.camera.p172ui.CameraUIManager;
import com.oplus.camera.p172ui.OplusViewOutlineProvider;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.RecordingStopCountDownTimer;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.control.ThumbnailHolder;
import com.oplus.camera.p172ui.control.TimerSnapShotManager;
import com.oplus.camera.p172ui.control.CameraControlButtonListener;
import com.oplus.camera.p172ui.control.ModeTypeChangedListener;
import com.oplus.camera.p172ui.control.ThumbnailClickListener;
import com.oplus.camera.p172ui.control.CameraControlUI;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import com.oplus.camera.p172ui.menu.setting.CameraSettingFactory;
import com.oplus.camera.p172ui.modepanel.DataBaseOperator;
import com.oplus.camera.p172ui.modepanel.ModeDataInfo;
import com.oplus.camera.p172ui.modepanel.ModeInfo;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.preview.TeleSmallPreviewManager;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.FocusManager;
import com.oplus.camera.p172ui.preview.CameraFocusListener;
import com.oplus.camera.p172ui.preview.CameraPreviewUI;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.ImageBeautyTools;
import com.oplus.camera.p172ui.preview.p177a.ImageStickerTools;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcessImpl;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.widget.LockViewDragLayout;
import com.oplus.camera.p180v.TemperatureNotificationManager;
import com.oplus.camera.p180v.TemperatureProvider;
import com.oplus.camera.p180v.CameraTemperatureInterface;
import com.oplus.camera.p181w.CameraDataCollection;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.p181w.CameraHandler;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.perf.ComprehensivePerformance;
import com.oplus.camera.perf.FluencyPerformance;
import com.oplus.camera.perf.SwitchModePerformance;
import com.oplus.camera.screen.ScreenModeManager;
import com.oplus.camera.screen.GalleryPreviewUpdateCallback;
import com.oplus.camera.screen.p163a.ScreenSwitchController;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.soloop.SoloopManager;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.DcsUtil;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.statistics.model.PerformanceMsgData;
import com.oplus.camera.statistics.model.PreviewStaticInfoMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.statistics.model.SwitchCameraMsgData;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.tiltshift.TiltShiftManager;
import com.oplus.camera.tiltshift.TiltShiftParam;
import com.oplus.camera.util.AndroidTestHelper;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.ContentProviderUtil;
import com.oplus.camera.util.DisableUitl;
import com.oplus.camera.util.LocationHelper;
import com.oplus.camera.util.ThumbnailCacheUtil;
import com.oplus.camera.util.Util;
import com.oplus.camera.util.YuvUtil;
import com.oplus.camera.util.storage.SandBoxContentProvider;
import com.oplus.camera.watch.WatchAgentContract;
import com.oplus.camera.watch.WatchAgentService;
import com.oplus.compat.hardware.p186a.DisplayManagerNative;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.PowerManagerNative;
import com.oplus.compat.p187os.SystemPropertiesNative;
import com.oplus.gallery.bitmap.ICameraTransBitmap;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.ocs.camera.CameraUnitClient;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.p188d.AppSettings;
import com.oplusos.sauaar.client.C3825a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class CameraManager implements CameraConstant, PreviewImageProcess.IntrinsicsJvm.kt_4 {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final String f10690h = new String(Base64.decode("b3Bwb19pbl9jYW1lcmFfbW9kZQ==", 0), StandardCharsets.UTF_8);

    /* renamed from: OplusGLSurfaceView_13 */
    private static final long f10691i = ViewConfiguration.getDoubleTapTimeout();

    /* renamed from: OplusGLSurfaceView_15 */
    private static LinkedHashMap<Uri, String> f10692j = new LinkedHashMap<>();

    /* renamed from: E */
    private int[] f10697E;

    /* renamed from: F */
    private int[] f10698F;

    /* renamed from: G */
    private int f10699G;

    /* renamed from: U */
    private long f10713U;

    /* renamed from: V */
    private long f10714V;

    /* renamed from: W */
    private long f10715W;

    /* renamed from: X */
    private long f10716X;

    /* renamed from: aT */
    private volatile boolean f10738aT;

    /* renamed from: aU */
    private boolean f10739aU;

    /* renamed from: aV */
    private boolean f10740aV;

    /* renamed from: bk */
    private boolean f10807bk;

    /* renamed from: bl */
    private boolean f10808bl;

    /* renamed from: cB */
    private volatile SensorManagerClient f10824cB;

    /* renamed from: cC */
    private FossManager f10825cC;

    /* renamed from: cG */
    private VelocityTracker f10829cG;

    /* renamed from: cJ */
    private volatile TemperatureNotificationManager f10832cJ;

    /* renamed from: cP */
    private CabcManager f10838cP;

    /* renamed from: ca */
    private volatile Activity f10849ca;

    /* renamed from: ch */
    private volatile CameraManagerInterface f10856ch;

    /* renamed from: df */
    private GestureDetectorOnGestureListenerC2590r f10906df;

    /* renamed from: eg */
    private MagShellResponseStatus f10954eg;
    private volatile ModeManager mModeManager;

    /* renamed from: OplusGLSurfaceView_5 */
    private final Object f10975k = new Object();

    /* renamed from: OplusGLSurfaceView_14 */
    private final Object f10976l = new Object();

    /* renamed from: OplusGLSurfaceView_6 */
    private final Object f10977m = new Object();

    /* renamed from: OplusGLSurfaceView_11 */
    private final Object f10978n = new Object();

    /* renamed from: o */
    private final Object f10979o = new Object();

    /* renamed from: p */
    private final ExecutorService f10980p = Executors.newSingleThreadExecutor();

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected int f10974g = 100;

    /* renamed from: q */
    private int f10981q = 255;

    /* renamed from: r */
    private int f10982r = 0;

    /* renamed from: s */
    private int f10983s = 0;

    /* renamed from: t */
    private int f10984t = 0;

    /* renamed from: u */
    private int f10985u = 0;

    /* renamed from: v */
    private int f10986v = 0;

    /* renamed from: w */
    private int f10987w = 0;

    /* renamed from: x */
    private int f10988x = 0;

    /* renamed from: y */
    private int f10989y = -1;

    /* renamed from: z */
    private int f10990z = -1;

    /* renamed from: A */
    private int f10693A = 0;

    /* renamed from: B */
    private int f10694B = 300;

    /* renamed from: C */
    private int f10695C = 70;

    /* renamed from: D */
    private int f10696D = 300;

    /* renamed from: H */
    private int f10700H = 0;

    /* renamed from: I */
    private int f10701I = 0;

    /* renamed from: J */
    private int f10702J = 0;

    /* renamed from: K */
    private int f10703K = 0;

    /* renamed from: L */
    private int f10704L = -1;

    /* renamed from: M */
    private int f10705M = 0;

    /* renamed from: N */
    private int f10706N = -1;

    /* renamed from: O */
    private int f10707O = 0;

    /* renamed from: P */
    private int f10708P = 0;

    /* renamed from: Q */
    private int f10709Q = 0;

    /* renamed from: R */
    private volatile int f10710R = 0;

    /* renamed from: S */
    private long f10711S = 0;

    /* renamed from: T */
    private long f10712T = 0;

    /* renamed from: Y */
    private long f10717Y = 0;

    /* renamed from: Z */
    private long f10718Z = 0;

    /* renamed from: aa */
    private long f10745aa = 0;

    /* renamed from: ab */
    private long f10746ab = 0;

    /* renamed from: ac */
    private boolean f10747ac = false;

    /* renamed from: ad */
    private boolean f10748ad = false;

    /* renamed from: ae */
    private boolean f10749ae = false;

    /* renamed from: af */
    private boolean f10750af = false;

    /* renamed from: ag */
    private boolean f10751ag = false;

    /* renamed from: ah */
    private volatile boolean f10752ah = false;

    /* renamed from: ai */
    private volatile boolean f10753ai = false;

    /* renamed from: aj */
    private boolean f10754aj = false;

    /* renamed from: ak */
    private int f10755ak = 0;

    /* renamed from: al */
    private long f10756al = 0;

    /* renamed from: am */
    private boolean f10757am = false;

    /* renamed from: an */
    private boolean f10758an = false;

    /* renamed from: ao */
    private boolean f10759ao = false;

    /* renamed from: ap */
    private boolean f10760ap = false;

    /* renamed from: aq */
    private boolean f10761aq = false;

    /* renamed from: ar */
    private boolean f10762ar = false;

    /* renamed from: as */
    private boolean f10763as = false;

    /* renamed from: at */
    private boolean f10764at = false;

    /* renamed from: au */
    private boolean f10765au = false;

    /* renamed from: av */
    private boolean f10766av = false;

    /* renamed from: aw */
    private boolean f10767aw = false;

    /* renamed from: ax */
    private boolean f10768ax = true;

    /* renamed from: ay */
    private boolean f10769ay = false;

    /* renamed from: az */
    private boolean f10770az = true;

    /* renamed from: aA */
    private boolean f10719aA = false;

    /* renamed from: aB */
    private boolean f10720aB = false;

    /* renamed from: aC */
    private boolean f10721aC = false;

    /* renamed from: aD */
    private boolean f10722aD = false;

    /* renamed from: aE */
    private boolean f10723aE = false;

    /* renamed from: aF */
    private boolean f10724aF = false;

    /* renamed from: aG */
    private boolean f10725aG = false;

    /* renamed from: aH */
    private boolean f10726aH = false;

    /* renamed from: aI */
    private boolean f10727aI = false;

    /* renamed from: aJ */
    private boolean f10728aJ = false;

    /* renamed from: aK */
    private boolean f10729aK = false;

    /* renamed from: aL */
    private boolean f10730aL = true;

    /* renamed from: aM */
    private boolean f10731aM = false;

    /* renamed from: aN */
    private float f10732aN = 0.0f;

    /* renamed from: aO */
    private float f10733aO = 0.0f;

    /* renamed from: aP */
    private int f10734aP = 0;

    /* renamed from: aQ */
    private int f10735aQ = 0;

    /* renamed from: aR */
    private long f10736aR = -1;

    /* renamed from: aS */
    private String f10737aS = "";

    /* renamed from: aW */
    private boolean f10741aW = false;

    /* renamed from: aX */
    private boolean f10742aX = false;

    /* renamed from: aY */
    private boolean f10743aY = false;

    /* renamed from: aZ */
    private boolean f10744aZ = false;

    /* renamed from: ba */
    private boolean f10797ba = false;

    /* renamed from: bb */
    private boolean f10798bb = false;

    /* renamed from: bc */
    private boolean f10799bc = false;

    /* renamed from: bd */
    private boolean f10800bd = false;

    /* renamed from: be */
    private boolean f10801be = false;

    /* renamed from: bf */
    private boolean f10802bf = false;

    /* renamed from: bg_renamed */
    private boolean f10803bg = false;

    /* renamed from: bh */
    private boolean f10804bh = false;

    /* renamed from: bi */
    private boolean f10805bi = false;

    /* renamed from: bj */
    private boolean f10806bj = false;

    /* renamed from: bm */
    private boolean f10809bm = false;

    /* renamed from: bn */
    private boolean f10810bn = false;

    /* renamed from: bo */
    private boolean f10811bo = false;

    /* renamed from: bp */
    private boolean f10812bp = false;

    /* renamed from: bq */
    private boolean f10813bq = false;

    /* renamed from: br */
    private boolean f10814br = true;

    /* renamed from: bs */
    private boolean f10815bs = false;

    /* renamed from: bt */
    private boolean f10816bt = false;

    /* renamed from: bu */
    private boolean f10817bu = false;

    /* renamed from: bv */
    private boolean f10818bv = true;

    /* renamed from: bw */
    private boolean f10819bw = false;

    /* renamed from: bx */
    private boolean f10820bx = true;

    /* renamed from: by */
    private boolean f10821by = false;

    /* renamed from: bz */
    private boolean f10822bz = false;

    /* renamed from: bA */
    private boolean f10771bA = false;

    /* renamed from: bB */
    private boolean f10772bB = true;

    /* renamed from: bC */
    private boolean f10773bC = false;

    /* renamed from: bD */
    private boolean f10774bD = false;

    /* renamed from: bE */
    private boolean f10775bE = false;

    /* renamed from: bF */
    private boolean f10776bF = false;

    /* renamed from: bG */
    private boolean f10777bG = false;

    /* renamed from: bH */
    private boolean f10778bH = false;

    /* renamed from: bI */
    private boolean f10779bI = true;

    /* renamed from: bJ */
    private boolean f10780bJ = false;

    /* renamed from: bK */
    private boolean f10781bK = false;

    /* renamed from: bL */
    private boolean f10782bL = false;

    /* renamed from: bM */
    private boolean f10783bM = false;

    /* renamed from: bN */
    private String f10784bN = null;

    /* renamed from: bO */
    private String f10785bO = "off";

    /* renamed from: bP */
    private String f10786bP = "on";

    /* renamed from: bQ */
    private String f10787bQ = "off";

    /* renamed from: bR */
    private String f10788bR = "normal";

    /* renamed from: bS */
    private CaptureMsgData f10789bS = null;

    /* renamed from: bT */
    private Object f10790bT = new Object();

    /* renamed from: bU */
    private Object f10791bU = new Object();

    /* renamed from: bV */
    private Object f10792bV = new Object();

    /* renamed from: bW */
    private Object f10793bW = new Object();

    /* renamed from: bX */
    private Object f10794bX = new Object();

    /* renamed from: bY */
    private ConditionVariable f10795bY = new ConditionVariable();

    /* renamed from: bZ */
    private ConditionVariable f10796bZ = new ConditionVariable(true);

    /* renamed from: cb */
    private volatile ComboPreferences f10850cb = null;

    /* renamed from: cc */
    private SharedPreferences f10851cc = null;

    /* renamed from: cd */
    private OneCamera f10852cd = null;

    /* renamed from: ce */
    private OplusCameraCharacteristics f10853ce = null;

    /* renamed from: cf */
    private OneCamera.IntrinsicsJvm.kt_5 f10854cf = null;

    /* renamed from: cg */
    private OneCamera.COUIBaseListPopupWindow_8 f10855cg = null;

    /* renamed from: ci */
    private Face[] f10857ci = null;

    /* renamed from: cj */
    private int[] f10858cj = null;

    /* renamed from: ck */
    private int[] f10859ck = null;

    /* renamed from: cl */
    private int f10860cl = 0;

    /* renamed from: cm */
    private Rect f10861cm = null;

    /* renamed from: cn */
    private volatile OplusPlaySound f10862cn = null;
    private volatile CameraUIManager mCameraUIManager = null;

    /* renamed from: co */
    private FrontCameraZoomManager f10863co = null;

    /* renamed from: cp */
    private PreviewEffectProcess f10864cp = null;

    /* renamed from: cq */
    private volatile FocusManager f10865cq = null;

    /* renamed from: cr */
    private volatile ZoomManager f10866cr = null;

    /* renamed from: cs */
    private volatile TiltShiftManager f10867cs = null;

    /* renamed from: ct */
    private AISSnapshotManager f10868ct = null;

    /* renamed from: cu */
    private TeleSmallPreviewManager f10869cu = null;

    /* renamed from: cv */
    private float f10870cv = 1.0f;

    /* renamed from: cw */
    private float f10871cw = 1.0f;

    /* renamed from: cx */
    private String f10872cx = "";

    /* renamed from: cy */
    private String f10873cy = "";

    /* renamed from: cz */
    private volatile SuperTextManager f10874cz = null;

    /* renamed from: cA */
    private AsyncTask f10823cA = null;

    /* renamed from: cD */
    private volatile TimerSnapShotManager f10826cD = null;

    /* renamed from: cE */
    private RecordingStopCountDownTimer f10827cE = null;

    /* renamed from: cF */
    private volatile ThumbnailProcessor f10828cF = null;

    /* renamed from: cH */
    private GestureDetector f10830cH = null;

    /* renamed from: cI */
    private volatile SloganUtil f10831cI = null;

    /* renamed from: cK */
    private OplusFingerprintManager f10833cK = null;

    /* renamed from: cL */
    private Thread f10834cL = null;

    /* renamed from: cM */
    private volatile LocationManager.PlatformImplementations.kt_3 f10835cM = null;

    /* renamed from: cN */
    private volatile Address f10836cN = null;

    /* renamed from: cO */
    private LocationManager.PlatformImplementations.kt_3 f10837cO = null;

    /* renamed from: cQ */
    private volatile VibrateManager f10839cQ = null;

    /* renamed from: cR */
    private volatile Intent f10840cR = null;

    /* renamed from: cS */
    private Handler f10841cS = null;

    /* renamed from: cT */
    private HandlerThread f10842cT = null;

    /* renamed from: cU */
    private Uri f10843cU = null;

    /* renamed from: cV */
    private StickerItem f10844cV = null;

    /* renamed from: cW */
    private boolean f10845cW = false;

    /* renamed from: cX */
    private CameraEntry f10846cX = null;

    /* renamed from: cY */
    private Thumbnail f10847cY = null;

    /* renamed from: cZ */
    private CopyOnWriteArrayList<Thumbnail> f10848cZ = null;

    /* renamed from: da */
    private MotionEvent f10901da = null;

    /* renamed from: db */
    private MotionEvent f10902db = null;

    /* renamed from: dc */
    private Boolean f10903dc = false;

    /* renamed from: dd */
    private Boolean f10904dd = true;

    /* renamed from: de */
    private byte[] f10905de = null;

    /* renamed from: dg */
    private volatile GestureEngineManager f10907dg = null;

    /* renamed from: dh */
    private QrCodeManager f10908dh = null;

    /* renamed from: di */
    private Size f10909di = null;

    /* renamed from: dj */
    private OneCamera.IntrinsicsJvm.kt_4 f10910dj = null;

    /* renamed from: dk */
    private int f10911dk = 0;

    /* renamed from: dl */
    private boolean f10912dl = false;

    /* renamed from: dm */
    private C2586n f10913dm = null;

    /* renamed from: dn */
    private ModeFacade f10914dn = null;

    /* renamed from: do */
    private SoloopManager f10915do = null;

    /* renamed from: dp */
    private C3825a f10916dp = null;

    /* renamed from: dq */
    private OtaUpdateManager f10917dq = null;

    /* renamed from: dr */
    private byte f10918dr = 0;

    /* renamed from: ds */
    private boolean f10919ds = false;

    /* renamed from: dt */
    private boolean f10920dt = false;

    /* renamed from: du */
    private boolean f10921du = false;

    /* renamed from: dv */
    private boolean f10922dv = false;

    /* renamed from: dw */
    private boolean f10923dw = true;

    /* renamed from: dx */
    private boolean f10924dx = false;

    /* renamed from: dy */
    private boolean f10925dy = false;

    /* renamed from: dz */
    private boolean f10926dz = false;

    /* renamed from: dA */
    private boolean f10875dA = true;

    /* renamed from: dB */
    private ApsService f10876dB = null;

    /* renamed from: dC */
    private C2573a f10877dC = new C2573a();

    /* renamed from: dD */
    private ConditionVariable f10878dD = new ConditionVariable();

    /* renamed from: dE */
    private long f10879dE = -1;

    /* renamed from: dF */
    private long f10880dF = -1;

    /* renamed from: dG */
    private String f10881dG = "normal";

    /* renamed from: dH */
    private int f10882dH = 3;

    /* renamed from: dI */
    private Thumbnail.IntrinsicsJvm.kt_4 f10883dI = null;

    /* renamed from: dJ */
    private DetectResult f10884dJ = null;

    /* renamed from: dK */
    private Handler f10885dK = null;

    /* renamed from: dL */
    private long f10886dL = 0;

    /* renamed from: dM */
    private YuvUtil f10887dM = null;

    /* renamed from: dN */
    private TemperatureProvider f10888dN = null;

    /* renamed from: dO */
    private ScreenSwitchController f10889dO = null;

    /* renamed from: dP */
    private ScreenModeManager f10890dP = null;

    /* renamed from: dQ */
    private long f10891dQ = 0;

    /* renamed from: dR */
    private WatchAgentContract.IntrinsicsJvm.kt_4 f10892dR = null;

    /* renamed from: dS */
    private Rect f10893dS = new Rect();

    /* renamed from: dT */
    private boolean f10894dT = false;

    /* renamed from: dU */
    private boolean f10895dU = false;

    /* renamed from: dV */
    private CameraDeviceInfo f10896dV = null;

    /* renamed from: dW */
    private CaptureRequestParam f10897dW = null;

    /* renamed from: dX */
    private Thumbnail f10898dX = null;

    /* renamed from: dY */
    private CameraPictureCallback f10899dY = null;

    /* renamed from: dZ */
    private int f10900dZ = 0;

    /* renamed from: ea */
    private int f10948ea = 0;

    /* renamed from: eb */
    private ByteBuffer f10949eb = null;

    /* renamed from: ec */
    private boolean f10950ec = false;

    /* renamed from: ed */
    private boolean f10951ed = false;

    /* renamed from: ee */
    private boolean f10952ee = false;

    /* renamed from: ef */
    private boolean f10953ef = false;

    /* renamed from: eh */
    private CameraTansBitmapBinder f10955eh = new CameraTansBitmapBinder();

    /* renamed from: ei */
    private HashMap<Float, Float> f10956ei = new HashMap<>();

    /* renamed from: ej */
    private boolean f10957ej = false;

    /* renamed from: ek */
    private long f10958ek = 0;

    /* renamed from: el */
    private String f10959el = "";

    /* renamed from: em */
    private double f10960em = Double.NaN;

    /* renamed from: en */
    private double f10961en = Double.NaN;

    /* renamed from: eo */
    private Location f10962eo = null;

    /* renamed from: ep */
    private int f10963ep = -1;

    /* renamed from: eq */
    private ConditionVariable f10964eq = new ConditionVariable();

    /* renamed from: er */
    private boolean f10965er = false;

    /* renamed from: es */
    private Runnable f10966es = null;

    /* renamed from: et */
    private Handler f10967et = null;

    /* renamed from: eu */
    private HandlerThread f10968eu = null;

    /* renamed from: ev */
    private final ImageProductProcessor f10969ev = new C24971();

    /* renamed from: ew */
    private SuperTextResultProcessor f10970ew = new SuperTextResultProcessor() { // from class: com.oplus.camera.CameraManager.12
        @Override // com.oplus.camera.p136a.SuperTextResultProcessor
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10410a(final Bitmap bitmap, final Thumbnail c3203e, final boolean z, final int OplusGLSurfaceView_13, final boolean z2, final boolean z3, final long OplusGLSurfaceView_15) {
            if (CameraManager.this.f10849ca == null) {
                return;
            }
            CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.12.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!z) {
                        CameraManager.this.mCameraUIListener.mo10742au();
                        return;
                    }
                    if (CameraManager.this.mCameraUIManager == null || bitmap == null || CameraManager.this.mModeManager == null || !z2) {
                        return;
                    }
                    CameraManager.this.mCameraUIManager.m19665a(bitmap, c3203e, OplusGLSurfaceView_13, OplusGLSurfaceView_15 > CameraManager.this.f10958ek);
                    if (CameraManager.this.f10892dR == null || !z3) {
                        return;
                    }
                    CameraManager.this.f10892dR.mo24731a(2, bitmap);
                }
            });
        }
    };

    /* renamed from: ex */
    private final PictureTakenCallback f10971ex = new PictureTakenCallback() { // from class: com.oplus.camera.CameraManager.23
        @Override // com.oplus.camera.p136a.PictureTakenCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10415a(boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12122r(z);
                CameraManager.this.mModeManager.m11831a(null, 0, 0, CameraManager.this.mModeManager.m12001cj(), false, 0);
            }
            if (z || CameraManager.this.f10874cz == null) {
                return;
            }
            CameraManager.this.f10874cz.m17981a(false);
        }
    };

    /* renamed from: ey */
    private GestureEngineManager.IntrinsicsJvm.kt_3 f10972ey = new GestureEngineManager.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.CameraManager.45
        @Override // com.oplus.camera.GestureEngineManager.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10427a(Rect rect) {
            CameraLog.m12959b("CameraManager", "old gesture open Hand");
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.45.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean zM11974cI = CameraManager.this.mModeManager.m11974cI();
                    if (!CameraManager.this.f10752ah && zM11974cI && !CameraManager.this.m10312av() && CameraManager.this.mCameraUIManager.m19758bR() && !"gesture".equals(CameraManager.this.f10881dG) && !CameraManager.this.mCameraUIManager.m19862dF() && !CameraManager.this.m10224V()) {
                        CameraManager.this.f10881dG = "gesture";
                        CameraManager.this.f10907dg.m14787a(true);
                        String strM9937cN = CameraManager.this.m9937cN();
                        if (!"off".equals(strM9937cN)) {
                            CameraManager.this.m10022d(strM9937cN, false);
                        }
                        CameraManager.this.f10907dg.m14787a(false);
                        CameraManager.this.f10856ch.mo9570p();
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "old gesture open Hand, isSupportGestureCapture: " + zM11974cI + ", isTimerSnapShotRunning: " + CameraManager.this.m10312av() + ", isCameraShutterButtonEnabled: " + CameraManager.this.mCameraUIManager.m19758bR() + ", mShutterType: " + CameraManager.this.f10881dG + ", isHeadlineScrolling: " + CameraManager.this.mCameraUIManager.m19862dF() + ", isSnapShotProgress: " + CameraManager.this.m10224V());
                }
            });
            CameraLog.m12959b("CameraManager", "old gesture open Hand X");
        }
    };

    /* renamed from: ez */
    private C2579g f10973ez = null;

    /* renamed from: eA */
    private int f10927eA = 0;

    /* renamed from: eB */
    private C2575c f10928eB = new C2575c();

    /* renamed from: eC */
    private C2582j f10929eC = new C2582j();

    /* renamed from: eD */
    private C2595w f10930eD = new C2595w();

    /* renamed from: eE */
    private PreviewImageProcess f10931eE = null;

    /* renamed from: eF */
    private CameraHandler f10932eF = new CameraHandler(Looper.getMainLooper()) { // from class: com.oplus.camera.CameraManager.56
        @Override // android.os.Handler
        public void handleMessage(Message message) throws NumberFormatException {
            switch (message.what) {
                case 1:
                    if (!CameraManager.this.f10752ah) {
                        CameraLog.m12966e("CameraManager", "handleMessage, MSG_CODE_SWITCH_CAMERA_OVER_TIME");
                        CameraManager.this.m10340d(false);
                        if (!CameraManager.this.mCameraUIManager.mo18057R()) {
                            CameraManager.this.mCameraUIManager.mo18200d(true, true);
                        }
                        if (!CameraManager.this.mCameraUIManager.mo18059T() && CameraManager.this.mModeManager.m11917bN() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                            if (!TextUtils.isEmpty(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                                CameraManager.this.mCameraUIManager.mo18166b(R.string.camera_setting_menu_high_resolution_item, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                            } else {
                                CameraManager.this.mCameraUIManager.mo18166b(R.string.camera_picture_size_standard_high_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Double.valueOf(CameraManager.this.mModeManager.m11919bP()));
                            }
                        }
                        CameraManager.this.m10367j(1);
                        break;
                    }
                    break;
                case 2:
                    CameraManager.this.m9668a(96, false);
                    break;
                case 3:
                    CameraManager.this.m9668a(95, false);
                    break;
                case 5:
                    CameraLog.m12954a("CameraManager", "handleMessage, onPreviewStartedAsync OK");
                    CameraManager.this.m10367j(1);
                    CameraManager.this.f10738aT = false;
                    CameraManager.this.m10256a(true, message.arg1, String.valueOf(message.obj));
                    CameraManager.this.f10739aU = true;
                    if (CameraManager.this.f10799bc) {
                        CameraManager.this.f10932eF.postDelayed(new Runnable() { // from class: com.oplus.camera.CameraManager.56.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraManager.this.f10752ah) {
                                    return;
                                }
                                CameraManager.this.m10194x(1);
                            }
                        }, 200L);
                        break;
                    }
                    break;
                case 6:
                    CameraManager.this.f10932eF.removeMessages(6);
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.switchCamera(cameraManager.m10220R());
                    break;
                case 10:
                    CameraManager.this.m10374l(2);
                    break;
                case 11:
                    if (CameraManager.this.f10913dm != null) {
                        CameraManager.this.f10913dm.m11012f();
                        break;
                    }
                    break;
                case 13:
                    if (CameraManager.this.mCameraUIManager != null) {
                        boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                        if (!zBooleanValue) {
                            CameraManager.this.mCameraUIManager.mo18249o();
                        }
                        if (!zBooleanValue || CameraManager.this.f10865cq.m23641A() || CameraManager.this.f10760ap || (CameraManager.this.f10908dh != null && CameraManager.this.f10908dh.m11223h())) {
                            CameraManager.this.mCameraUIManager.mo18249o();
                            break;
                        } else {
                            CameraManager.this.mCameraUIManager.m19696a(CameraManager.this.f10857ci, CameraManager.this.f10858cj);
                            break;
                        }
                    }
                    break;
                case 14:
                    Bundle data = message.getData();
                    if (data != null) {
                        boolean zBooleanValue2 = ((Boolean) data.get("view_enable")).booleanValue();
                        boolean zBooleanValue3 = ((Boolean) data.get("view_ashed")).booleanValue();
                        if (CameraManager.this.mCameraUIManager != null) {
                            CameraManager.this.mCameraUIManager.mo18200d(zBooleanValue2, zBooleanValue3);
                            break;
                        }
                    }
                    break;
                case 15:
                    if (CameraManager.this.f10862cn != null && !CameraManager.this.f10752ah) {
                        CameraManager.this.f10862cn.m24680d();
                        break;
                    }
                    break;
                case 16:
                    if (CameraManager.this.f10846cX.m13315H()) {
                        if (CameraManager.this.f10849ca != null) {
                            CameraManager.this.f10849ca.finishAndRemoveTask();
                        }
                        MyApplication.m11090c();
                        break;
                    }
                    break;
                case 17:
                    float fFloatValue = message.obj != null ? ((Float) message.obj).floatValue() : 0.0f;
                    CameraManager cameraManager2 = CameraManager.this;
                    cameraManager2.m10231a(fFloatValue, cameraManager2.f10732aN);
                    break;
                case 19:
                    if (!CameraManager.this.f10766av && CameraManager.this.m10327b(CameraUIInterface.KEY_PI_AI) && CameraManager.this.mCameraUIManager != null) {
                        if (CameraManager.this.f10850cb == null || !"off".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_PI_AI, null))) {
                            CameraManager.this.mCameraUIManager.m19628L(message.arg1);
                            break;
                        } else {
                            CameraLog.m12959b("CameraManager", "handleMessage, AI is turn off, override scene to unknown");
                            if (18 == message.arg1) {
                                CameraManager.this.mCameraUIManager.m19628L(18);
                                break;
                            } else {
                                CameraManager.this.mCameraUIManager.m19628L(0);
                                break;
                            }
                        }
                    }
                    break;
                case 20:
                    if (CameraManager.this.f10848cZ != null && !CameraManager.this.f10848cZ.isEmpty()) {
                        Thumbnail c3203e = (Thumbnail) CameraManager.this.f10848cZ.get(0);
                        if (1 < CameraManager.this.f10848cZ.size()) {
                            CameraManager.this.f10848cZ.remove(0);
                        }
                        CameraManager.this.mCameraUIManager.mo18094a(c3203e, 2);
                    }
                    if (CameraManager.this.f10766av) {
                        sendEmptyMessageDelayed(20, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_BURSTSHOT_THUMB_ANIM_STEP_TIME));
                        break;
                    }
                    break;
                case 21:
                    CameraManager.this.m9770b(((Float) message.obj).floatValue(), false);
                    break;
                case 22:
                    if (CameraManager.this.m10260a(3)) {
                        if (CameraManager.this.f10846cX.m13360x()) {
                            CameraManager.this.m10098f(!r8.f10747ac, false);
                            break;
                        }
                    } else {
                        CameraManager.this.f10932eF.removeMessages(22);
                        CameraManager.this.f10932eF.sendEmptyMessageDelayed(22, 50L);
                        break;
                    }
                    break;
                case 23:
                    if (CameraManager.this.mCameraUIManager != null) {
                        if (!((Boolean) message.obj).booleanValue() || CameraManager.this.f10865cq.m23641A() || CameraManager.this.f10859ck == null) {
                            CameraManager.this.mCameraUIManager.m19838co();
                            break;
                        } else {
                            CameraManager.this.mCameraUIManager.m19795c(CameraManager.this.f10859ck);
                            break;
                        }
                    }
                    break;
                case 25:
                    CameraManager.this.m9851be();
                    break;
                case 26:
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19703ab(CameraManager.this.f10747ac);
                        break;
                    }
                    break;
                case 27:
                    if (CameraManager.this.mModeManager != null) {
                        CameraManager.this.mModeManager.m12142z(false);
                        break;
                    }
                    break;
            }
        }
    };

    /* renamed from: eG */
    private SensorManagerClient.COUIBaseListPopupWindow_8 f10933eG = new SensorManagerClient.COUIBaseListPopupWindow_8() { // from class: com.oplus.camera.CameraManager.67
        @Override // com.oplus.camera.SensorManagerClient.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10924a() {
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23712y();
            }
        }

        @Override // com.oplus.camera.SensorManagerClient.COUIBaseListPopupWindow_8
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10926b() {
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23713z();
            }
        }

        @Override // com.oplus.camera.SensorManagerClient.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10925a(int[] iArr) {
            if (Util.m24498u()) {
                if (Util.f23001i < 150) {
                    if (CameraManager.this.f10889dO != null) {
                        int OplusGLSurfaceView_13 = CameraManager.this.f10984t;
                        if (-1 == CameraManager.this.f10985u || CameraManager.this.f10985u == 0) {
                            int i2 = iArr[0];
                            int i3 = iArr[1];
                            if (i2 > 25 || i2 < -25) {
                                CameraManager.this.m10352f(0);
                            } else if (i3 < -15) {
                                CameraManager.this.m10352f(270);
                            } else {
                                CameraManager.this.m10352f(90);
                            }
                        }
                        if (OplusGLSurfaceView_13 == CameraManager.this.f10984t || 2 == CameraManager.this.f10846cX.m13317J() || 3 == CameraManager.this.f10846cX.m13317J()) {
                            return;
                        }
                        CameraManager.this.f10889dO.m16482a(CameraManager.this.f10984t, CameraManager.this.f10989y, false, false);
                        CameraLog.m12954a("CameraManager", "onOrientationAngleChanged, angles: " + Arrays.toString(iArr) + ", mOriginOrientation: " + CameraManager.this.f10985u + ", mOrientation: " + CameraManager.this.f10984t);
                        return;
                    }
                    return;
                }
                int i4 = iArr[0];
                if (i4 > 25 || i4 < -25) {
                    CameraManager.this.m10352f(0);
                }
            }
        }
    };

    /* renamed from: eH */
    private SensorManagerClient.IntrinsicsJvm.kt_5 f10934eH = new SensorManagerClient.IntrinsicsJvm.kt_5() { // from class: com.oplus.camera.CameraManager.75
        @Override // com.oplus.camera.SensorManagerClient.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10932a() {
            CameraManager.this.f10954eg.m16294a(true);
            CameraLog.m12959b("CameraManager", "onShellRise, preview started: " + CameraManager.this.m10222T() + ", front camera: " + CameraCharacteristicsUtil.m12974a(CameraManager.this.f10989y) + ", video record stopped: " + CameraManager.this.m10271aG() + ", mMagShellResponseStatus: " + CameraManager.this.f10954eg + ", mbFrameAvailable: " + CameraManager.this.f10801be);
            if (!CameraManager.this.m10222T() || !CameraManager.this.f10801be || CameraCharacteristicsUtil.m12974a(CameraManager.this.f10989y) || !CameraManager.this.m10271aG() || !CameraManager.this.f10954eg.m16306g()) {
                return CameraManager.this.m10222T() && CameraManager.this.f10801be;
            }
            CameraManager.this.f10954eg.m16298c(true);
            CameraManager.this.f10954eg.m16302e(true);
            if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19864dH()) {
                if (CameraManager.this.mCameraUIManager.m19919eG()) {
                    CameraManager.this.mCameraUIManager.m19918eF();
                }
                CameraManager.this.mCameraUIManager.m19866dJ();
                CameraManager.this.mCameraUIManager.m19693a(false, ApsConstant.CAPTURE_MODE_COMMON, 2);
                CameraManager.this.m9701a(false, false, 2);
            }
            String strM17195b = CameraManager.this.f10914dn.m17195b();
            String strM12105n = CameraManager.this.mModeManager.m12105n();
            if (TextUtils.equals(ApsConstant.CAPTURE_MODE_COMMON, strM17195b) || TextUtils.equals(ApsConstant.CAPTURE_MODE_COMMON, strM12105n)) {
                if (CameraManager.this.mCameraControlButtonListener != null) {
                    CameraManager.this.mCameraControlButtonListener.onSwitchCameraButtonClick();
                }
            } else {
                if (CameraManager.this.mCameraUIManager != null) {
                    CameraManager.this.mCameraUIManager.mo18068a(0, 1);
                    CameraManager.this.mCameraUIManager.m19729b(1, ApsConstant.CAPTURE_MODE_COMMON);
                }
                CameraManager.this.m10263a(ApsConstant.CAPTURE_MODE_COMMON, 1, true, false);
            }
            CameraManager.this.m10158p("2");
            CameraManager.this.f10954eg.m16302e(false);
            return true;
        }

        @Override // com.oplus.camera.SensorManagerClient.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo10933b() {
            CameraManager.this.f10954eg.m16294a(false);
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.mo18067a(R.string.rio_toast_shell_covered_camera_lens);
            }
            CameraLog.m12959b("CameraManager", "onShellDown");
            return true;
        }
    };

    /* renamed from: eI */
    private TexturePreviewRequest.IntrinsicsJvm.kt_4 f10935eI = new TexturePreviewRequest.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.CameraManager.32
        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10416a(float COUIBaseListPopupWindow_12) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19850d(COUIBaseListPopupWindow_12);
            }
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23677c(COUIBaseListPopupWindow_12);
            }
            CameraManager.this.f10871cw = COUIBaseListPopupWindow_12;
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10417a() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11982cQ();
            }
            return false;
        }
    };

    /* renamed from: eJ */
    private PreviewEffectProcess.PlatformImplementations.kt_3 f10936eJ = new PreviewEffectProcess.PlatformImplementations.kt_3() { // from class: com.oplus.camera.CameraManager.33
        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10423a(String str) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12091j(str);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo10418a(int OplusGLSurfaceView_13, int i2) {
            return CameraManager.this.m10016d(OplusGLSurfaceView_13, i2);
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public Rect[] mo10424a() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.m19858dB();
            }
            return null;
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10426b(final String str) {
            if (CameraManager.this.f10849ca != null) {
                CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.33.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.mCameraUIManager != null) {
                            CameraManager.this.mCameraUIManager.m19970l(str);
                        }
                    }
                });
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10425b() {
            if (CameraManager.this.f10849ca != null) {
                CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.33.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.mCameraUIManager != null) {
                            CameraManager.this.mCameraUIManager.mo18030E();
                        }
                    }
                });
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public DetectResult mo10419a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z, long OplusGLSurfaceView_15) {
            if (CameraManager.this.f10874cz == null || CameraManager.this.m10207E() || !CameraManager.this.mModeManager.m11926bW()) {
                CameraManager.this.mCameraUIManager.mo18089a((DetectResult) null);
            } else {
                CameraManager.this.f10874cz.m17983a(OplusGLSurfaceView_13, i2, i3, i5, OplusGLSurfaceView_15);
            }
            return null;
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10422a(DetectResult c3077a) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.mo18089a(c3077a);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10421a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.mo18073a(OplusGLSurfaceView_13, i2, z, z2, z3, z4, z5, z6, i3, true);
            }
            if (CameraManager.this.mCameraUIManager != null) {
                if (R.string.camera_double_exposure_nobody_hint == OplusGLSurfaceView_13 || R.string.mode_double_exposure_move_closer == OplusGLSurfaceView_13) {
                    CameraManager.this.mCameraUIManager.mo18270t(OplusGLSurfaceView_13);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10420a(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.mo18067a(OplusGLSurfaceView_13);
            }
        }
    };

    /* renamed from: eK */
    private OneCamera.IntrinsicsJvm.kt_3 f10937eK = new OneCamera.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.CameraManager.46

        /* renamed from: IntrinsicsJvm.kt_4 */
        private long f11067b = 0;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f11068c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private long f11069d = 0;

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10431a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            if (!CameraManager.this.m10327b(CameraFunction.AIS_SNAPSHOT) || CameraManager.this.f10753ai) {
                return;
            }
            int[] iArrMo13061a = CameraManager.this.f10852cd.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13349f, captureResult);
            int[] iArrMo13061a2 = CameraManager.this.f10852cd.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13350g, captureResult);
            int[] iArrMo13061a3 = CameraManager.this.f10852cd.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13351h, captureResult);
            if (CameraManager.this.f10868ct != null && iArrMo13061a != null && iArrMo13061a2 != null && iArrMo13061a3 != null) {
                CameraManager.this.f10868ct.m11645a(iArrMo13061a[0], iArrMo13061a2[0], iArrMo13061a3[0]);
            }
            try {
                int[] iArr = (int[]) captureResult.get(CameraMetadataKey.f13258X);
                Byte b2 = (Byte) captureResult.get(CameraMetadataKey.f13352i);
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_MODE);
                CameraManager.this.f10821by = false;
                if (CameraManager.this.f10865cq == null || num == null || num2 == null || b2 == null) {
                    return;
                }
                CameraManager.this.f10865cq.m23662a(num.intValue(), num2.intValue(), iArr, CameraManager.this.f10982r, b2.byteValue());
            } catch (Exception unused) {
                CameraManager.this.f10821by = true;
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10432a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult, int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10753ai || CameraManager.this.f10852cd == null || !(!CameraManager.this.f10752ah || CameraManager.this.mModeManager == null || CameraManager.this.mModeManager.m12090j())) {
                CameraLog.m12967f("CameraManager" + OplusGLSurfaceView_13, "onPreviewCaptureResult, mOneCamera: " + CameraManager.this.f10852cd);
                return;
            }
            if (captureResult == null) {
                CameraLog.m12954a("CameraManager" + OplusGLSurfaceView_13, "onPreviewCaptureResult, result is null.");
                return;
            }
            m10428a(captureResult, captureResult.getFrameNumber());
            if (CameraManager.this.m10268aD() && 2 == OplusGLSurfaceView_13) {
                CameraManager.this.m10241a(captureResult);
            }
            if ((CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12099l(-1)) && (CameraManager.this.f10762ar || CameraManager.this.f10760ap)) {
                CameraLog.m12967f("CameraManager", "onPreviewCaptureResult, mbCaptureModeChanging: " + CameraManager.this.f10762ar + ", mbSwitchingCamera: " + CameraManager.this.f10760ap);
                return;
            }
            AndroidTestHelper.onPreviewCaptureCompleted(captureRequest, captureResult);
            if ((CameraManager.this.f10914dn == null || !CameraManager.this.f10914dn.m17204f()) && CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11812a(captureResult);
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10433a(CaptureResult captureResult) {
            if (CameraManager.this.f10753ai) {
                return;
            }
            CameraManager.this.m9773b(captureResult);
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10430a(long OplusGLSurfaceView_15) {
            FluencyPerformance.m15125a(System.currentTimeMillis(), OplusGLSurfaceView_15);
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10437a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
            if (cameraPreviewResult == null || cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_REQUEST_FORMAT) == null || CameraManager.this.mModeManager == null || CameraManager.this.f10752ah) {
                return;
            }
            CameraManager.this.mModeManager.m11815a(new CameraApsDecision(cameraPreviewResult));
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10435a(Image image) {
            CameraManager.this.m9774b(image);
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Map<String, Object> mo10438b(Image image) {
            HashMap map = new HashMap();
            if (CameraManager.this.m10272aH() && CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.mo18183c() != null) {
                map.put(CameraUnitKeys.KEY_SKIP_PROCESS, String.valueOf(CameraManager.this.mCameraUIManager.mo18183c().m14238b().contains(Long.valueOf(image.getTimestamp()))));
                map.put(CameraUnitKeys.KEY_CAN_NOT_DROP, String.valueOf(CameraManager.this.mCameraUIManager.mo18183c().m14218a().contains(Long.valueOf(image.getTimestamp()))));
                if (CameraManager.this.f10747ac || CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11943bn()) {
                    map.put(CameraUnitKeys.KEY_FRAMES_CAN_NOT_SKIP, CameraManager.this.mCameraUIManager.mo18183c().m14218a());
                }
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11828a(map);
            }
            return map;
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10439b(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
            if (CameraManager.this.f10957ej) {
                CameraLog.m12967f("CameraManager", "onPreviewReceived, need to stop preview");
                cameraPreviewResult.close();
                return;
            }
            long jLongValue = ((Long) cameraPreviewResult.get(CameraParameter.KEY_CAMERA_RESULT_REF_TIMESTAMP)).longValue();
            long jLongValue2 = ((Long) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_IDENTITY)).longValue();
            if (jLongValue != -1 && CameraManager.this.mModeManager != null) {
                CameraManager.this.mCameraUIManager.mo18075a(CameraScreenNail.f14187b.intValue(), jLongValue2, jLongValue);
            }
            CameraManager.this.f10725aG = "true".equals(cameraPreviewResult.get(CameraParameter.KEY_CAMERA_RESULT_APS_INIT_FINISH));
            CameraScreenNail c3445hMo18183c = CameraManager.this.mCameraUIManager != null ? CameraManager.this.mCameraUIManager.mo18183c() : null;
            boolean z = true;
            if (CameraManager.this.m10268aD()) {
                String str = (String) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAMERA_TYPE);
                if (c3445hMo18183c != null) {
                    if (CameraUnitClient.CameraType.REAR_MAIN.equals(str)) {
                        c3445hMo18183c.m14225a((Image) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAMERA_IMAGE), 1);
                        return;
                    } else {
                        if (CameraUnitClient.CameraType.FRONT_MAIN.equals(str) || CameraUnitClient.CameraType.FRONT_WIDE.equals(str)) {
                            c3445hMo18183c.m14225a((Image) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAMERA_IMAGE), 2);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_IDENTITY) == null) {
                CameraLog.m12967f("CameraManager", "onPreviewReceived, preview frame is not processed by aps, so return.");
                return;
            }
            CameraApsResult cameraApsResult = new CameraApsResult(cameraPreviewResult);
            CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
            if (cameraApsResult.isValid()) {
                if (CameraManager.this.f10766av) {
                    CameraManager.this.f10898dX = Thumbnail.m19277a(cameraApsResult.getHardwareBuffer(), cameraApsResult.mWidth, cameraApsResult.mHeight, CameraManager.this.f10849ca.getResources().getDimensionPixelSize(R.dimen.thumbnail_width_nomal), CameraManager.this.f10983s, CameraManager.this.mCameraUIManager.mo18207e());
                }
                if (!CameraManager.this.f10752ah && CameraManager.this.mModeManager.m12091j(CameraFunction.SCALE_PREVIEW)) {
                    Size sizeM19747bG = CameraManager.this.mCameraUIManager.m19747bG();
                    float fIntValue = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CROP_RIGHT)).intValue() - ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CROP_LEFT)).intValue();
                    float fIntValue2 = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CROP_BOTTOM)).intValue() - ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CROP_TOP)).intValue();
                    CameraLog.m12959b("CameraManager", "cropH: " + fIntValue + ", cropW: " + fIntValue2);
                    if (fIntValue2 > 0.0f && fIntValue > 0.0f) {
                        float height = (sizeM19747bG.getHeight() * 1.0f) / fIntValue2;
                        CameraManager.this.f10864cp.mo22823d(height);
                        CameraManager.this.f10864cp.mo22826e((sizeM19747bG.getWidth() * 1.0f) / fIntValue);
                    }
                }
                if (CameraManager.this.f10753ai || CameraManager.this.mCameraUIManager == null) {
                    CameraLog.m12967f("CameraManager", "onPreviewReceived, mCameraUIManager is null");
                    cameraApsResult.closeImageBuffer();
                    return;
                }
                if (c3445hMo18183c != null) {
                    m10429b(cameraApsResult);
                    c3445hMo18183c.m14226a(cameraApsResult, !CameraManager.this.f10769ay);
                    if (!CameraManager.this.f10769ay) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onPreviewReceived, first frame received, frameNumber: ");
                        sb.append(captureResult != null ? Long.valueOf(captureResult.getFrameNumber()) : "null");
                        CameraLog.m12962c("CameraManager", sb.toString());
                        CameraLog.m12952a("CameraStartupPerformance.receivedFirstFrameFromAPS");
                        CameraManager.this.f10769ay = true;
                        CameraLog.m12958b("CameraStartupPerformance.receivedFirstFrameFromAPS");
                        if (CameraManager.this.mCameraUIManager != null) {
                            CameraManager.this.mCameraUIManager.m19725ax(CameraManager.this.f10989y == 0);
                            if (c3445hMo18183c != null) {
                                c3445hMo18183c.mo14259m();
                            }
                        }
                    }
                    if (!CameraManager.this.f10950ec) {
                        CameraManager.this.f10950ec = true;
                    }
                    if (!CameraManager.this.f10752ah && !CameraManager.this.f10762ar && !CameraManager.this.f10760ap && !CameraManager.this.f10763as && CameraManager.this.f10982r != 0) {
                        if (CameraManager.this.mModeManager != null) {
                            ModeManager modeManager = CameraManager.this.mModeManager;
                            if (!LockViewDragLayout.getLongPressState() && !LockViewDragLayout.getIsVolumeDownState()) {
                                z = false;
                            }
                            modeManager.m11825a(cameraPreviewResult, z);
                        }
                        if (cameraPreviewResult.getCaptureResult() != null) {
                            CameraManager.this.m10249a(cameraPreviewResult);
                        }
                        if (CameraManager.this.f10864cp == null || CameraManager.this.mModeManager == null) {
                            return;
                        }
                        CameraManager.this.f10864cp.mo22795a(CameraManager.this.f10725aG, CameraManager.this.mModeManager.m11841aB());
                        return;
                    }
                    CameraLog.m12967f("CameraManager", "onPreviewReceived, mbPaused: " + CameraManager.this.f10752ah + ", mbCaptureModeChanging: " + CameraManager.this.f10762ar + ", mbSwitchingCamera: " + CameraManager.this.f10760ap + ", mbSizeChanging: " + CameraManager.this.f10763as + ", cameraState: " + CameraManager.this.f10982r);
                    return;
                }
                CameraLog.m12967f("CameraManager", "onPreviewReceived, cameraScreenNail is null");
                cameraApsResult.closeImageBuffer();
                return;
            }
            CameraLog.m12967f("CameraManager", "onPreviewReceived, get null buffer.");
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m10429b(CameraApsResult cameraApsResult) {
            boolean zM10384p = CameraManager.this.m10384p();
            boolean z = false;
            boolean z2 = CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11890ay();
            if (CameraManager.this.f10908dh != null && !CameraManager.this.f10908dh.m11225j() && CameraManager.this.m10380n()) {
                z = true;
            }
            if (zM10384p || z2 || z) {
                HardwareBuffer hardwareBuffer = cameraApsResult.getHardwareBuffer();
                if (hardwareBuffer == null) {
                    CameraLog.m12959b("CameraManager", "onPreviewImageBufferReceived, hardwareBuffer is null");
                    return;
                }
                int width = hardwareBuffer.getWidth();
                int height = hardwareBuffer.getHeight();
                long jUptimeMillis = SystemClock.uptimeMillis();
                long OplusGLSurfaceView_15 = jUptimeMillis - CameraManager.this.f10712T;
                if (OplusGLSurfaceView_15 > 1000) {
                    OplusGLSurfaceView_15 = 0;
                }
                CameraManager.m9898c(CameraManager.this, OplusGLSurfaceView_15);
                CameraManager.m10020d(CameraManager.this, OplusGLSurfaceView_15);
                CameraManager.m10086e(CameraManager.this, OplusGLSurfaceView_15);
                CameraManager.this.f10712T = jUptimeMillis;
                if (CameraManager.this.f10949eb == null || width != CameraManager.this.f10900dZ || height != CameraManager.this.f10948ea) {
                    CameraManager.this.f10900dZ = width;
                    CameraManager.this.f10948ea = height;
                    CameraManager.this.f10949eb = ByteBuffer.allocateDirect((int) (width * height * 1.5f));
                }
                CameraManager.this.f10949eb.clear();
                if (!Util.nativeGetYuvDataWithoutPadding(cameraApsResult.getHardwareBuffer(), CameraManager.this.f10949eb, 17)) {
                    CameraLog.m12967f("CameraManager", "onPreviewImageBufferReceived, nativeGetYuvDataWithoutPadding failed");
                    return;
                }
                if (z2) {
                    long j2 = 33;
                    if (CameraManager.this.f10745aa >= j2) {
                        CameraManager.this.f10745aa -= j2;
                        CameraManager.this.f10885dK.obtainMessage(3, width, height, CameraManager.this.f10949eb.array()).sendToTarget();
                    }
                }
                if (zM10384p) {
                    long j3 = 76;
                    if (CameraManager.this.f10718Z >= j3 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_GESTURE_DETECT_IN_APS)) {
                        CameraManager.this.f10718Z -= j3;
                        CameraManager.this.f10885dK.obtainMessage(1, CameraManager.this.f10949eb.array()).sendToTarget();
                    }
                }
                if (!z || CameraManager.this.f10746ab < 250) {
                    return;
                }
                byte[] bArrArray = CameraManager.this.f10949eb.array();
                CameraManager.this.f10746ab -= 250;
                CameraManager.this.f10885dK.obtainMessage(4, width, height, bArrArray).sendToTarget();
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10436a(CameraApsResult cameraApsResult) {
            DiagnosisTools.m13377b(System.currentTimeMillis() - this.f11068c, this.f11069d);
            if (1 == cameraApsResult.mIsLastVideoFrame) {
                this.f11068c = 0L;
                this.f11069d = 0L;
            } else {
                this.f11068c = System.currentTimeMillis();
                this.f11069d++;
            }
            if (1 == cameraApsResult.mIsMotionDetected) {
                CameraLog.m12954a("CameraManager", "onVideoReceived,  motionDetectedFrame Come.");
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m11971cF();
                }
            }
            if (1 == cameraApsResult.mIsStartInterpolationFrame) {
                CameraLog.m12954a("CameraManager", "onVideoReceived, interpolationFrame Come.");
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m11970cE();
                }
            }
            if (1 == cameraApsResult.mIsLastVideoFrame) {
                CameraLog.m12954a("CameraManager", "onVideoReceived, lastVideoFrameCome");
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m11969cD();
                }
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10434a(CaptureResult captureResult, int OplusGLSurfaceView_13, String str) {
            CameraLog.m12967f("CameraManager", "onFirstCaptureResultArrived, cameraRole: " + OplusGLSurfaceView_13 + ", captureMode: " + str);
            if (!CameraManager.this.f10752ah) {
                if (!CameraManager.this.f10950ec && (2 == AlgoSwitchConfig.getApsVersion() || CameraManager.this.m10268aD())) {
                    CameraManager.this.f10950ec = true;
                }
                if (CameraManager.this.f10908dh != null) {
                    CameraManager.this.f10908dh.m11226k();
                    CameraManager.this.m9842bZ();
                    CameraManager.this.f10908dh.m11220e(false);
                }
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m11978cM();
                }
                if (1 == OplusGLSurfaceView_13) {
                    synchronized (CameraManager.this.f10978n) {
                        CameraManager.this.f10882dH = 0;
                    }
                }
                int i2 = CameraManager.this.f10739aU ? 100 : 0;
                Message messageObtain = Message.obtain(CameraManager.this.f10932eF, 5);
                messageObtain.arg1 = OplusGLSurfaceView_13;
                messageObtain.obj = str;
                CameraManager.this.f10932eF.sendMessageDelayed(messageObtain, i2);
                if (CameraManager.this.mCameraUIManager != null) {
                    CameraManager.this.m10007cw();
                    if (CameraManager.this.m10268aD()) {
                        if (1 == OplusGLSurfaceView_13) {
                            CameraManager.this.mCameraUIManager.mo18183c().m23478l(true);
                        } else {
                            CameraManager.this.mCameraUIManager.mo18183c().m23479m(true);
                        }
                    }
                    if (2 == AlgoSwitchConfig.getApsVersion() && CameraManager.this.mCameraUIManager.mo18183c() != null) {
                        CameraManager.this.mCameraUIManager.mo18183c().mo14259m();
                    }
                    if (CameraManager.this.m10327b(CameraUIInterface.KEY_GRADIENTER) && "on".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_GRADIENTER, "off"))) {
                        CameraManager.this.mCameraUIManager.m19692a(true, CameraManager.this.f10987w);
                    }
                    if (CameraManager.this.f10760ap) {
                        return;
                    }
                    CameraManager.this.mCameraUIManager.m19876dT();
                    return;
                }
                return;
            }
            CameraLog.m12967f("CameraManager", "onPause, the first frame come, so return");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m10428a(CaptureResult captureResult, long OplusGLSurfaceView_15) {
            if (captureResult == null || OplusGLSurfaceView_15 == -1) {
                return;
            }
            if (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11982cQ()) {
                Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13259Y);
                if ((objM13005a instanceof int[]) && 1 != ((int[]) objM13005a)[0]) {
                    DiagnosisTools.m13372a(System.currentTimeMillis() - this.f11067b, OplusGLSurfaceView_15);
                }
                this.f11067b = System.currentTimeMillis();
            }
        }
    };

    /* renamed from: eL */
    private ContentOperatedCallback f10938eL = new ContentOperatedCallback() { // from class: com.oplus.camera.CameraManager.48
        @Override // com.oplus.camera.capmode.ContentOperatedCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10440a() {
            if (CameraManager.this.m10303am()) {
                CameraManager.this.f10921du = true;
            }
        }
    };

    /* renamed from: eM */
    private CameraInterface f10939eM = new CameraInterface() { // from class: com.oplus.camera.CameraManager.49
        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: B */
        public void mo10446B() {
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10472a() {
            if (CameraManager.this.f10865cq == null || !CameraManager.this.f10865cq.m23708u()) {
                return;
            }
            CameraManager.this.f10865cq.m23687f(8);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_4 */
        public CameraEntry mo10551b() {
            return CameraManager.this.f10846cX;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo10560c() {
            if (!mo10522aX() || CameraManager.this.f10762ar) {
                return false;
            }
            CameraManager cameraManager = CameraManager.this;
            cameraManager.f10761aq = cameraManager.m10327b(CameraFunction.CACHE_CLICK_CAPTURE);
            CameraLog.m12954a("CameraManager", "beforeCaptureProcess, enableCacheClickCapture: " + CameraManager.this.f10761aq);
            if (CameraManager.this.f10849ca != null) {
                CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.f10752ah) {
                            return;
                        }
                        CameraManager.this.mCameraUIManager.m19706ae(CameraManager.this.f10761aq);
                    }
                });
            }
            CameraManager.this.m10367j(2);
            CameraManager cameraManager2 = CameraManager.this;
            cameraManager2.f10983s = cameraManager2.m10016d(cameraManager2.f10990z, CameraManager.this.f10984t);
            CameraManager cameraManager3 = CameraManager.this;
            cameraManager3.f10988x = cameraManager3.f10984t;
            if (CameraManager.this.mModeManager == null || CameraManager.this.f10865cq == null || !CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_TIME_LAPSE) || "off".equals(CameraManager.this.mModeManager.m11876ak())) {
                return true;
            }
            CameraManager.this.f10865cq.m23695j();
            return true;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10475a(int OplusGLSurfaceView_13, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
            DetectResult c3077aM17979a;
            CameraLog.m12952a("captureX burstCapture");
            if (CameraManager.this.f10876dB != null) {
                CameraManager.this.f10876dB.setCaptureCallback(aVar);
                CameraManager.this.f10876dB.setCameraPictureListener(CameraManager.this.f10899dY);
            }
            if (CameraManager.this.f10852cd != null) {
                mo10448D();
                if (CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11844aE()) {
                    CameraManager.this.f10875dA = false;
                }
                if (!CameraManager.this.f10766av) {
                    if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_STICKER_PROCESS)) {
                        CameraManager.this.f10864cp.mo22782a(CameraManager.this.mModeManager.m11956c(CameraManager.this.f10853ce), CameraManager.this.mCameraUIManager.mo19844cu() != 0);
                    }
                } else {
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.f10736aR = cameraManager.mModeManager.m12043dc();
                    CameraManager cameraManager2 = CameraManager.this;
                    cameraManager2.f10737aS = Storage.m11110a(String.valueOf(cameraManager2.f10736aR), "");
                }
                CameraManager.this.f10897dW.mBurstShotThumbnailCallBack = new Thumbnail.PlatformImplementations.kt_3() { // from class: com.oplus.camera.CameraManager.49.2
                    @Override // com.oplus.camera.p172ui.control.Thumbnail.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo10597a(long OplusGLSurfaceView_15, long j2, byte[] bArr) {
                        m10441a(OplusGLSurfaceView_15, j2, (Image) null);
                    }
                };
                CameraManager.this.f10897dW.mCaptureOrientation = CameraManager.this.f10984t;
                CameraManager.this.f10897dW.mThumbWidth = CameraManager.this.mCameraUIManager.m19746bF();
                CameraManager.this.f10897dW.mApsServiceListener = CameraManager.this.f10877dC;
                CameraManager.this.f10897dW.mbSuperTextOpen = false;
                CameraManager.this.f10897dW.mSuperTextResultProcessor = null;
                CameraManager.this.f10897dW.mPictureTakenCallback = null;
                if (!CameraManager.this.f10766av || !CameraManager.this.f10852cd.mo13086e().m13247D()) {
                    if (CameraManager.this.mModeManager.m11926bW()) {
                        CameraManager.this.f10897dW.mbSuperTextOpen = CameraManager.this.mModeManager.m11926bW();
                        CameraManager.this.f10897dW.mSuperTextResultProcessor = CameraManager.this.f10970ew;
                        CameraManager.this.f10897dW.mPictureTakenCallback = CameraManager.this.f10971ex;
                    }
                    if (!CameraManager.this.mModeManager.m11861aV()) {
                        CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.SUPER_TEXT_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(CameraManager.this.mModeManager.m11926bW()));
                        if (CameraManager.this.mModeManager.m11926bW() && CameraManager.this.mCameraUIListener != null && CameraManager.this.f10874cz != null && (c3077aM17979a = CameraManager.this.f10874cz.m17979a(System.currentTimeMillis())) != null && c3077aM17979a.m17956c()) {
                            float[] fArrM10443a = m10443a(c3077aM17979a.m17953a());
                            if (CameraManager.this.f10852cd != null) {
                                CameraManager.this.f10852cd.mo13043a(Arrays.toString(fArrM10443a));
                            }
                        }
                        if (CameraManager.this.m10327b(CameraFunction.BOKEH)) {
                            CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.KEY_SINGLE_BLUR_SHOW, (CameraParameter.PreviewKey<Float>) Float.valueOf(c2693c.f13390S));
                            CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.KEY_SINGLE_BLUR_LEVEL, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(c2693c.f13389R));
                        }
                        CameraManager.this.f10897dW.mThumbWidth = CameraManager.this.mCameraUIManager.m19746bF();
                        CameraManager.this.f10897dW.mApsServiceListener = CameraManager.this.f10877dC;
                        CameraManager.this.f10876dB.setCaptureRequestParam(CameraManager.this.f10897dW);
                        AndroidTestHelper.onReadyToCapture(true);
                        CameraManager.this.f10852cd.mo13026a(OplusGLSurfaceView_13, c2693c, aVar);
                        CameraManager.this.f10969ev.mo10406a();
                        if (!mo10575i() && ((!CameraManager.this.mModeManager.m11843aD() || CameraParameter.FlashMode.FLASH_TORCH.equals(CameraManager.this.mModeManager.m11787S())) && CameraManager.this.m9940cO())) {
                            CameraManager.this.f10852cd.mo13017F(false);
                            CameraManager.this.f10957ej = true;
                        }
                    } else {
                        String string = CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, CameraManager.this.f10989y));
                        if (2 != AlgoSwitchConfig.getApsVersion() && (ApsConstant.CAPTURE_MODE_COMMON.equals(CameraManager.this.mModeManager.m12105n()) || !"video_size_4kuhd".equals(string) || CameraManager.this.mModeManager.m11871af())) {
                            mo10521aW();
                        }
                        CameraManager.this.f10876dB.setCaptureRequestParam(CameraManager.this.f10897dW);
                        CameraManager.this.f10852cd.mo13026a(OplusGLSurfaceView_13, c2693c, aVar);
                    }
                } else {
                    CameraManager.this.f10876dB.setCaptureRequestParam(CameraManager.this.f10897dW);
                    CameraManager.this.f10852cd.mo13052a(true, c2693c, aVar);
                }
            }
            CameraLog.m12958b("captureX burstCapture");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m10441a(long OplusGLSurfaceView_15, long j2, Image image) {
            if (CameraManager.this.f10736aR == j2) {
                CameraManager.m9995cq(CameraManager.this);
            }
            if (2 == CameraManager.this.f10734aP && !CameraManager.this.f10766av) {
                CameraLog.m12959b("CameraManager", "updateBurstShotThumbnail, don't update first picture if just burstshot one picture");
                CameraManager.this.f10847cY = null;
            }
            if (CameraManager.this.f10736aR != j2) {
                CameraManager.this.m9848bd();
                return;
            }
            CameraManager cameraManager = CameraManager.this;
            cameraManager.f10735aQ = cameraManager.f10734aP;
            if (1 == CameraManager.this.f10734aP) {
                CameraManager cameraManager2 = CameraManager.this;
                cameraManager2.f10847cY = cameraManager2.f10898dX;
                if (CameraManager.this.f10848cZ != null) {
                    CameraManager.this.f10848cZ.clear();
                } else {
                    CameraManager.this.f10848cZ = new CopyOnWriteArrayList();
                }
            }
            if (CameraManager.this.f10898dX != null && CameraManager.this.f10848cZ != null) {
                CameraManager.this.f10848cZ.add(CameraManager.this.f10898dX);
            }
            if (1 == CameraManager.this.f10734aP) {
                CameraManager.this.f10932eF.removeMessages(20);
                CameraManager.this.f10932eF.sendEmptyMessage(20);
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11831a(null, 0, 0, 35, true, 0);
            }
            if (CameraManager.this.f10734aP > 1) {
                mo10478a(OplusGLSurfaceView_15, Util.m24247a(CameraManager.this.mModeManager.m12043dc(), true), false, false, true);
            }
            if (Util.f22996d == CameraManager.this.f10734aP) {
                CameraManager.this.m9848bd();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private float[] m10443a(PointF[] pointFArr) {
            if (pointFArr == null || pointFArr.length <= 0) {
                return null;
            }
            float[] fArr = new float[pointFArr.length * 2];
            int OplusGLSurfaceView_13 = 0;
            for (int i2 = 0; i2 < pointFArr.length; i2++) {
                int i3 = OplusGLSurfaceView_13 + 1;
                fArr[OplusGLSurfaceView_13] = pointFArr[i2].x;
                OplusGLSurfaceView_13 = i3 + 1;
                fArr[i3] = pointFArr[i2].y;
            }
            CameraLog.m12954a("CameraManager", "convertVertices, result: " + Arrays.toString(fArr));
            return fArr;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10561d() {
            if (CameraManager.this.f10846cX.m13317J() == 2 && CameraManager.this.mModeManager.m11878am()) {
                CameraManager.this.mCameraUIManager.mo18091a(new MainShutterButtonInfo(4, "button_color_inside_grey"));
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10493a(byte[] bArr) {
            CameraLog.m12954a("CameraManager", "beforePictureTaken");
            if (CameraManager.this.f10752ah) {
                return;
            }
            if (!CameraManager.this.m10225W() && mo10575i() && 5 != mo10570g() && CameraManager.this.f10739aU) {
                CameraManager.this.m10367j(1);
            }
            if (CameraManager.this.f10846cX.m13317J() != 2 || CameraManager.this.mCameraUIManager == null || CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11878am()) {
                return;
            }
            CameraManager.this.mCameraUIManager.mo18092a(CameraManager.this.mModeManager.m12076g(), CameraManager.this.m10047de());
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10494a(byte[] bArr, boolean z, int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraManager", "afterPictureTaken");
            if (CameraManager.this.f10752ah) {
                return;
            }
            if (CameraManager.this.f10797ba) {
                if (CameraManager.this.mCameraControlButtonListener != null) {
                    CameraManager.this.mCameraControlButtonListener.mo10901c(false);
                }
                CameraManager.this.m10347e(false);
            }
            if (CameraManager.this.m10327b(CameraUIInterface.KEY_SUPPORT_ZSL) && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_REQUEST_ZSL_MODE) || (30 < Build.VERSION.SDK_INT && Util.m24169C()))) {
                CameraManager.this.f10852cd.mo13115m(false);
                CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            if (CameraManager.this.f10811bo) {
                try {
                    if (CameraManager.this.mCameraUIManager != null && !CameraManager.this.f10752ah && CameraManager.this.f10852cd != null && CameraManager.this.f10856ch != null) {
                        CameraManager.this.f10811bo = false;
                        CameraManager.this.f10852cd.mo13069b("off");
                        CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                        CameraManager.this.m9793bA();
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            if (!z && OplusGLSurfaceView_13 != 0) {
                CameraManager.this.f10852cd.mo13076c(35 == OplusGLSurfaceView_13 ? 32 : 35);
            }
            if (Storage.f12097w == 0) {
                CameraManager.this.m9804bG();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo10564e() {
            if (CameraManager.this.f10932eF != null) {
                CameraLog.m12954a("CameraManager", "checkCacheCapture");
                if (CameraManager.this.f10932eF.hasMessages(24)) {
                    if (CameraManager.this.f10932eF.hasMessages(24, true)) {
                        CameraManager.this.f10947eU.mo10918b("off");
                    } else {
                        CameraManager.this.mCameraControlButtonListener.mo10906h();
                    }
                }
                CameraManager.this.f10932eF.removeMessages(24);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10567f() {
            CameraLog.m12954a("CameraManager", "resetVideoTakePicture, mbPaused: " + CameraManager.this.f10752ah);
            if (CameraManager.this.f10752ah) {
                return;
            }
            CameraManager.this.m10370k(0);
            CameraManager.this.mCameraUIManager.mo18213f(true, true);
            CameraManager.this.mCameraUIManager.mo18191c(!CameraManager.this.mModeManager.m11861aV(), false);
            CameraManager.this.m10367j(1);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10473a(int OplusGLSurfaceView_13) {
            CameraManager.this.m10152o(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10553b(int OplusGLSurfaceView_13) {
            CameraManager.this.m10157p(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_11 */
        public int mo10570g() {
            return CameraManager.this.f10982r;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10558c(int OplusGLSurfaceView_13) {
            CameraManager.this.m10319b(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo10572h() {
            if (CameraManager.this.mCameraUIManager.m19811cN()) {
                return;
            }
            CameraManager.this.mCameraUIManager.m19837cn();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10489a(boolean z) {
            CameraManager.this.m10377m(z);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10486a(Thumbnail c3203e) {
            CameraManager.this.f10847cY = c3203e;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_13 */
        public boolean mo10575i() {
            return CameraManager.this.m9861bj();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_15 */
        public int mo10576j() {
            return CameraManager.this.f10700H;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10562d(int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10827cE == null) {
                CameraManager.this.f10827cE = new RecordingStopCountDownTimer();
                CameraManager.this.f10827cE.m19256a(new C2593u(CameraManager.this, null));
            }
            CameraManager.this.f10827cE.m19255a(OplusGLSurfaceView_13, CameraManager.this.f10849ca, CameraManager.this.f10984t);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_5 */
        public boolean mo10579k() {
            return CameraManager.this.m9936cM();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_14 */
        public int mo10580l() {
            return CameraManager.this.f10702J;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_6 */
        public boolean mo10583m() {
            return CameraManager.this.m9863bk();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_11 */
        public void mo10584n() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19703ab(CameraManager.this.f10747ac);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: o */
        public void mo10585o() {
            if (Util.m24169C()) {
                return;
            }
            CameraManager.this.f10819bw = true;
            CameraManager.this.f10841cS.sendEmptyMessageDelayed(6, 800L);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: p */
        public boolean mo10586p() {
            String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_FRONT_ZOOM_RANGES);
            String[] configStringArrayValue2 = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_REAR_ZOOM_RANGES);
            return (CameraManager.this.mModeManager == null || CameraManager.this.f10868ct == null || !CameraManager.this.f10868ct.m11647a() || ((!CameraManager.this.f10747ac || !(configStringArrayValue != null && CameraManager.this.f10868ct.m11648a(configStringArrayValue, CameraManager.this.f10870cv))) && (CameraManager.this.f10747ac || !(configStringArrayValue2 != null && CameraManager.this.f10868ct.m11648a(configStringArrayValue2, CameraManager.this.f10870cv)))) || CameraManager.this.f10766av || CameraManager.this.f10699G != 0 || !CameraManager.this.mModeManager.m12091j(CameraFunction.AIS_SNAPSHOT) || CameraManager.this.mModeManager.m11843aD() || mo10529ae() || CameraManager.this.mModeManager.m11992ca() || CameraManager.this.mModeManager.m11995cd() || (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_MAKEUP) && "on".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off")))) ? false : true;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: q */
        public boolean mo10587q() {
            String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_DCT_FRONT_ZOOM_RANGES);
            String[] configStringArrayValue2 = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_DCT_REAR_ZOOM_RANGES);
            return (CameraManager.this.mModeManager == null || CameraManager.this.mModeManager.m11990cY() || ((!CameraManager.this.f10747ac || !(configStringArrayValue != null && CameraManager.this.f10868ct.m11648a(configStringArrayValue, CameraManager.this.f10870cv))) && (CameraManager.this.f10747ac || !(configStringArrayValue2 != null && CameraManager.this.f10868ct.m11648a(configStringArrayValue2, CameraManager.this.f10870cv)))) || CameraManager.this.f10766av || CameraManager.this.f10699G != 0 || !CameraManager.this.mModeManager.m12091j(CameraFunction.AIS_SNAPSHOT) || CameraManager.this.mModeManager.m11843aD() || mo10529ae() || CameraManager.this.mModeManager.m11992ca() || CameraManager.this.mModeManager.m11995cd() || ((CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_MAKEUP) && "on".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off"))) || ((CameraManager.this.mModeManager.m12091j(CameraFunction.FACE_BEAUTY_PROCESS) && CameraManager.this.mModeManager.m11906bC() != 0) || !"default".equals(CameraManager.this.mModeManager.m12052dl())))) ? false : true;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: r */
        public boolean mo10588r() {
            String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_DCT_AINR_FRONT_ZOOM_RANGES);
            String[] configStringArrayValue2 = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_DCT_AINR_REAR_ZOOM_RANGES);
            return (CameraManager.this.mModeManager == null || CameraManager.this.mModeManager.m11990cY() || ((!CameraManager.this.f10747ac || !(configStringArrayValue != null && CameraManager.this.f10868ct.m11648a(configStringArrayValue, CameraManager.this.f10870cv))) && (CameraManager.this.f10747ac || !(configStringArrayValue2 != null && CameraManager.this.f10868ct.m11648a(configStringArrayValue2, CameraManager.this.f10870cv)))) || CameraManager.this.f10766av || CameraManager.this.f10699G != 0 || !CameraManager.this.mModeManager.m12091j(CameraFunction.AIS_SNAPSHOT) || CameraManager.this.mModeManager.m11843aD() || mo10529ae() || CameraManager.this.mModeManager.m11992ca() || CameraManager.this.mModeManager.m11995cd() || ((CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_MAKEUP) && "on".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off"))) || ((CameraManager.this.mModeManager.m12091j(CameraFunction.FACE_BEAUTY_PROCESS) && CameraManager.this.mModeManager.m11906bC() != 0) || !"default".equals(CameraManager.this.mModeManager.m12052dl())))) ? false : true;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10555b(boolean z) {
            if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.mo18059T()) {
                CameraManager.this.mCameraUIManager.mo18060U();
            }
            CameraLog.m12952a("captureX onAISSnapshotCapture");
            CameraLog.m12954a("CameraManager", "doAISCapture, needCheckAFStatus: " + z);
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m10098f(z && !cameraManager.f10747ac, true);
            CameraLog.m12958b("captureX onAISSnapshotCapture");
            if (CameraManager.this.m10303am()) {
                CameraManager.this.m10392t(false);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10474a(int OplusGLSurfaceView_13, int i2, int i3) {
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.PREVIEW_AIS_BRACKET, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(OplusGLSurfaceView_13));
                CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.PREVIEW_AIS_DCT_SUPPORT, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(i2));
                CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.PREVIEW_AIS_DCT_AINR_SUPPORT, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(i3));
                CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                CameraLog.m12954a("CameraManager", "setAISBracket, aisBracket: " + OplusGLSurfaceView_13 + ", setDCTSupport, isSupportDCT: " + i2 + ", setDCTAndAINRSupport, isSupportDCTAndAINR: " + i3);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: s */
        public boolean mo10589s() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11996ce();
            }
            return false;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: t */
        public SharedPreferences mo10590t() {
            return CameraManager.this.f10850cb;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: u */
        public int mo10591u() {
            return CameraManager.this.f10984t;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: v */
        public int mo10592v() {
            return CameraManager.this.f10988x;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10483a(Storage.CameraPicture cameraPicture, boolean z) throws IOException {
            CameraManager.this.m10248a(cameraPicture, z);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10482a(Storage.CameraPicture cameraPicture) {
            CameraManager.this.m9783b(cameraPicture);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public Uri mo10471a(ThumbnailProcessor.DataRequest dataRequest) {
            if (CameraManager.this.f10828cF == null) {
                return null;
            }
            dataRequest.mContentOperatedCallback = CameraManager.this.f10938eL;
            CameraManager.this.f10828cF.addQueue(dataRequest);
            return null;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: w */
        public String mo10593w() {
            return CameraManager.this.f10737aS;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: x */
        public long mo10594x() {
            return CameraManager.this.f10736aR;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: y */
        public Location mo10595y() {
            if (LocationManager.m16155a() == null || !CameraManager.this.f10923dw || !"on".equals(LocationManager.m16155a().m16182e())) {
                return null;
            }
            if (LocationManager.m16155a().m16183f() && CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12091j(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
                CameraManager cameraManager = CameraManager.this;
                cameraManager.f10837cO = cameraManager.f10835cM;
                if (CameraManager.this.f10837cO == null) {
                    return null;
                }
                return CameraManager.this.f10837cO.f15847i;
            }
            Location locationM16180c = LocationManager.m16155a().m16180c();
            if (locationM16180c != null) {
                return locationM16180c;
            }
            CameraLog.m12954a("CameraManager", "current location is null, so use last location");
            return LocationManager.m16155a().m16181d();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: z */
        public boolean mo10596z() {
            return mo10529ae();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: A */
        public boolean mo10445A() {
            return CameraManager.this.m10312av();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: C */
        public boolean mo10447C() {
            return CameraManager.this.f10798bb;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: D */
        public void mo10448D() throws Resources.NotFoundException {
            CameraManager.this.m10391t();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: E */
        public boolean mo10449E() {
            return CameraManager.this.f10760ap;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: F */
        public boolean mo10450F() {
            return CameraManager.this.f10762ar;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10559c(boolean z) {
            CameraManager.this.m10359g(z);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10479a(AnimatorListenerAdapter animatorListenerAdapter, boolean z, boolean z2) {
            CameraManager.this.m10236a(animatorListenerAdapter, z, z2);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10492a(boolean z, boolean z2) {
            CameraManager.this.m10348e(z, z2);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: G */
        public boolean mo10451G() {
            return CameraManager.this.m10272aH();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: H */
        public boolean mo10452H() {
            return CameraManager.this.m10313aw();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: I */
        public boolean mo10453I() {
            if (CameraManager.this.f10874cz != null) {
                return CameraManager.this.f10874cz.m17986c();
            }
            return false;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10563d(boolean z) {
            CameraManager.this.m10398w(z);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: J */
        public boolean mo10454J() {
            return CameraManager.this.m10278aN();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: K */
        public boolean mo10455K() {
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            CameraManager.this.mCameraUIManager.m19826cc();
            CameraManager.this.mModeManager.m11772D();
            CameraManager.this.mCameraUIManager.mo18114aD();
            CameraManager.this.mCameraUIManager.mo18045L(true);
            CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_10bit_hint);
            if (CameraManager.this.mCameraUIManager.m19751bK()) {
                CameraManager.this.mCameraUIManager.m19846cw();
            }
            if (CameraManager.this.f10846cX.m13317J() != 3) {
                CameraManager.this.m9877br();
            }
            return true;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: L */
        public void mo10456L() {
            if (!CameraManager.this.mModeManager.m12091j(CameraFunction.SAT_CAMERA) || !CameraManager.this.mModeManager.isSatOpen() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) || CameraManager.this.mModeManager.m11900b(mo10535ak()) || CameraManager.this.m10115h(mo10535ak()) || CameraManager.this.mModeManager.m11931bb()) {
                if (CameraManager.this.mModeManager.m12022d(CameraUIInterface.KEY_TORCH_MODE)) {
                    CameraManager.this.mCameraUIManager.mo18171b(CameraUIInterface.KEY_TORCH_MODE, (String) null);
                } else if (CameraManager.this.mModeManager.m12022d(CameraUIInterface.KEY_VIDEO_FLASH_MODE) && CameraManager.this.m9950cT()) {
                    CameraManager.this.mCameraUIManager.mo18171b(CameraUIInterface.KEY_VIDEO_FLASH_MODE, (String) null);
                }
            }
            if (CameraManager.this.f10892dR != null) {
                CameraManager.this.f10892dR.mo24730a(1, 0L);
            }
            if (CameraManager.this.mModeManager.m11832a()) {
                CameraManager.this.mCameraUIManager.m19794c(true, 1 != mo10519aU().mo16539j() ? 1 : 0);
            } else {
                CameraManager.this.mCameraUIManager.mo18068a(4, 2);
            }
            if (CameraManager.this.mCameraUIManager.mo18111aA()) {
                CameraManager.this.mCameraUIManager.mo18041J(true);
            }
            if (CameraManager.this.mCameraUIManager.mo18043K()) {
                if (CameraManager.this.mModeManager.m11871af() || CameraManager.this.m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
                    CameraManager.this.mCameraUIManager.mo18109a(true, false, false, true);
                } else {
                    CameraManager.this.mCameraUIManager.mo18109a(true, false, false, false);
                }
            }
            if (CameraManager.this.mCameraUIManager.mo18051O()) {
                CameraManager.this.mCameraUIManager.mo18176b(false, false, false, true);
            }
            CameraManager.this.mCameraUIManager.m19704ac((CameraManager.this.m10327b(CameraUIInterface.KEY_SHORT_VIDEO) || CameraManager.this.m10327b(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) || CameraManager.this.m10327b(CameraUIInterface.KEY_TIME_LAPSE_PRO) || CameraManager.this.m10268aD() || CameraManager.this.mModeManager.m12056dp() || CameraManager.this.mModeManager.m11950bu()) ? false : true);
            CameraManager.this.mCameraUIManager.m19819cV();
            CameraManager.this.mCameraUIManager.mo18282w(false);
            CameraManager.this.mCameraUIManager.mo18048N();
            CameraManager.this.mCameraUIManager.m19814cQ();
            CameraManager.this.mCameraUIManager.m19618C(true, false);
            if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
                if (CameraManager.this.m9944cQ()) {
                    CameraManager.this.f10866cr.m11503b(8);
                } else {
                    float fMo10536al = mo10536al();
                    float fMo10537am = mo10537am();
                    if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE) && !CameraManager.this.mModeManager.m11931bb() && !CameraManager.this.mModeManager.m11932bc()) {
                        if (CameraManager.this.m9934cL()) {
                            fMo10537am = 2.0f;
                        } else {
                            fMo10536al = 1.9f;
                        }
                    }
                    CameraManager.this.f10866cr.m11489a(fMo10537am, fMo10536al, CameraManager.this.f10866cr.m11486a(), CameraManager.this.f10853ce.m13269d(), CameraManager.this.mModeManager.m12012cu(), false);
                }
            }
            CameraManager cameraManager = CameraManager.this;
            cameraManager.f10986v = cameraManager.f10984t;
            AndroidTestHelper.onReadyToVideo(true);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo10566e(boolean z) {
            CameraManager.this.f10856ch.mo9571q();
            CameraManager.this.mModeManager.m11773E();
            CameraManager.this.f10862cn.m24677b();
            if (CameraManager.this.f10932eF != null && z) {
                CameraManager.this.f10932eF.removeMessages(15);
                CameraManager.this.f10932eF.sendEmptyMessageDelayed(15, 250L);
            }
            CameraManager.this.m10259a((Face[]) null, (int[]) null);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: M */
        public void mo10457M() {
            if (CameraManager.this.f10862cn != null) {
                CameraManager.this.f10862cn.m24681e();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: N */
        public void mo10458N() {
            if (CameraManager.this.f10932eF != null) {
                CameraManager.this.f10932eF.removeMessages(15);
            }
            if (CameraManager.this.m10327b(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
                CameraManager.this.mCameraUIManager.m19831ch();
                if ("position_headline".equals(DataBaseOperator.m21777a().m21781a(HeadlineHelper.m20352e(HeadlineHelper.m20344a(CameraManager.this.mModeManager.m12105n()))).m21910c())) {
                    CameraManager.this.mCameraUIManager.mo18068a(0, 1);
                } else {
                    CameraManager.this.mCameraUIManager.m19736b(true, 1);
                }
                CameraManager.this.mCameraUIManager.mo18200d(false, false);
                CameraManager.this.mCameraUIManager.mo18171b(CameraUIInterface.KEY_VIDEO_FLASH_MODE, (String) null);
            } else {
                m10444ba();
                CameraManager.this.mCameraUIManager.m19722au(true);
                if (CameraManager.this.mModeManager.m12041da()) {
                    CameraManager.this.mCameraUIManager.mo18166b(R.string.camera_10bit_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                }
            }
            if (CameraManager.this.f10892dR == null || !CameraManager.this.m10270aF()) {
                return;
            }
            CameraManager.this.f10892dR.mo24730a(6, 0L);
        }

        /* renamed from: ba */
        private void m10444ba() {
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            boolean zM11937bh = CameraManager.this.mModeManager.m11937bh();
            boolean zM12049di = CameraManager.this.mModeManager.m12049di();
            if (CameraManager.this.f10846cX.m13317J() == 1 && !CameraManager.this.mCameraUIManager.mo18224h()) {
                if (!CameraManager.this.mModeManager.m11832a()) {
                    if (CameraManager.this.mCameraUIListener != null && !zM12049di && ((1 == mo10519aU().mo16539j() || !mo10454J()) && !CameraManager.this.mModeManager.m11937bh() && (!CameraManager.this.mCameraUIManager.mo18201d() || CameraManager.this.mCameraUIManager.m19770bi()))) {
                        CameraManager.this.mCameraUIManager.mo18068a(0, 2);
                    }
                } else if (!zM11937bh && !zM12049di && (1 == mo10519aU().mo16539j() || !mo10454J())) {
                    CameraManager.this.mCameraUIManager.m19736b(true, 1 != mo10519aU().mo16539j() ? 1 : 0);
                }
            }
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11515e();
            }
            if (CameraManager.this.mModeManager.m12056dp()) {
                CameraManager.this.mCameraUIManager.mo18105a(false);
            }
            CameraManager.this.mCameraUIManager.m19987x(zM11937bh, zM12049di);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: O */
        public void mo10459O() {
            CameraManager.this.mCameraUIManager.mo18227i(true);
            CameraManager.this.m9595E(false);
            if (CameraManager.this.m10327b(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
                CameraManager.this.f10865cq.m23703p();
                if (CameraManager.this.f10865cq.m23655O()) {
                    mo10581l(false);
                }
                CameraManager.this.mCameraUIManager.m19832ci();
            }
            if (!CameraManager.this.mModeManager.m11937bh()) {
                if ((CameraManager.this.mCameraUIManager.mo18043K() || CameraManager.this.mCameraUIManager.mo18023A() || CameraManager.this.mCameraUIManager.mo18051O()) && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM)) {
                    if (((!CameraManager.this.m9931cK() && !CameraManager.this.f10747ac) || CameraManager.this.mModeManager.m11977cL()) && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE) || (!CameraManager.this.mModeManager.m11975cJ() && !CameraManager.this.mModeManager.m11976cK()))) {
                        CameraManager.this.f10866cr.m11489a(mo10537am(), mo10536al(), CameraManager.this.f10866cr.m11486a(), CameraManager.this.f10853ce.m13269d(), CameraManager.this.mModeManager.m12012cu(), CameraManager.this.mModeManager.m11922bS());
                    }
                    mo10479a((AnimatorListenerAdapter) null, true, false);
                } else {
                    mo10452H();
                    mo10563d(true);
                    if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU)) {
                        CameraManager.this.mCameraUIManager.mo18029D(true);
                    }
                    if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU) && !CameraManager.this.f10747ac && !CameraManager.this.mCameraUIManager.m19878dV()) {
                        CameraManager.this.mCameraUIManager.mo18046M();
                    }
                    if (CameraManager.this.f10866cr != null) {
                        CameraManager.this.mCameraUIManager.mo18263r(true);
                    }
                    if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
                        if (((CameraManager.this.m9931cK() || CameraManager.this.f10747ac) && !CameraManager.this.mModeManager.m11977cL()) || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE) && (CameraManager.this.mModeManager.m11975cJ() || CameraManager.this.mModeManager.m11976cK()))) {
                            CameraManager.this.f10866cr.m11512d();
                            CameraManager.this.f10866cr.m11503b(0);
                        } else {
                            CameraManager.this.f10866cr.m11489a(mo10537am(), mo10536al(), CameraManager.this.f10866cr.m11486a(), CameraManager.this.f10853ce.m13269d(), CameraManager.this.mModeManager.m12012cu(), CameraManager.this.mModeManager.m11922bS());
                        }
                    }
                }
            }
            if (CameraManager.this.f10827cE != null && CameraManager.this.f10827cE.m19257b()) {
                CameraManager.this.f10827cE.m19258c();
            }
            CameraManager.this.mModeManager.m11774F();
            CameraManager.this.mCameraUIManager.mo18044L();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10485a(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z, boolean z2) {
            CameraLog.m12954a("CameraManager", "stopVideoRecordingProcess, failed: " + z);
            if (CameraManager.this.f10752ah) {
                if (CameraManager.this.f10846cX.m13317J() != 3 || z) {
                    return;
                }
                mo10479a((AnimatorListenerAdapter) null, true, false);
                CameraManager.this.mCameraUIManager.m19791c(CameraManager.this.mModeManager.m12088j(Util.getScreenWidth()));
                return;
            }
            if (CameraManager.this.f10846cX.m13317J() == 3) {
                if (!z) {
                    mo10479a((AnimatorListenerAdapter) null, true, false);
                    CameraManager.this.mCameraUIManager.m19791c(CameraManager.this.mModeManager.m12088j(Util.getScreenWidth()));
                } else {
                    mo10492a(true, false);
                    CameraManager.this.mCameraUIManager.m19793c(CameraManager.this.mModeManager.m12076g(), CameraManager.this.m10047de());
                }
                CameraManager.this.m9804bG();
            } else {
                CameraManager.this.m9875bq();
                if (!CameraManager.this.mModeManager.m12056dp() && !mo10463S()) {
                    CameraManager.this.mCameraUIManager.mo18200d(true, true);
                }
                if (!z && z2) {
                    ThumbnailHolder.m19300a();
                    CameraManager.this.mCameraUIManager.mo18093a(dVar, true);
                    if (dVar.f18291d != null && Util.m24495t()) {
                        CameraManager.this.mCameraUIManager.mo18098a(Util.m24381b(dVar.f18291d), dVar.f18289b);
                    }
                    CameraLog.m12967f("CameraManager", "CameraTest Video Thumbnail Saved");
                }
                CameraManager.this.m10370k(0);
                if (CameraManager.this.m10205C() && !CameraManager.this.f10865cq.m23641A()) {
                    if (CameraManager.this.mModeManager.m11852aM()) {
                        CameraManager.this.f10932eF.sendEmptyMessageDelayed(26, 150L);
                    } else {
                        CameraManager.this.mCameraUIManager.m19703ab(CameraManager.this.f10747ac);
                    }
                }
                CameraManager.this.m9804bG();
            }
            CameraManager.this.f10856ch.mo9570p();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10484a(Thumbnail.IntrinsicsJvm.kt_5 dVar) {
            CameraLog.m12954a("CameraManager", "updateThumbnail, mediaInfo: " + dVar);
            ThumbnailHolder.m19300a();
            CameraManager.this.mCameraUIManager.mo18093a(dVar, true);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10569f(boolean z) {
            CameraManager.this.m10253a(z);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: P */
        public boolean mo10460P() {
            return ImageSaverThread.m14696a().m14697a(CameraManager.this.f10849ca, CameraManager.this.mModeManager.m11785Q());
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: Q */
        public void mo10461Q() {
            if (CameraManager.this.f10856ch != null) {
                CameraManager.this.f10856ch.mo9567m();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: R */
        public boolean mo10462R() {
            return CameraManager.this.m10349e();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: S */
        public boolean mo10463S() {
            return CameraManager.this.f10757am;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: T */
        public void mo10464T() {
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m10088e(cameraManager.f10700H, 0);
            CameraManager.this.mCameraUIManager.mo18242m(CameraManager.this.f10700H);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: U */
        public void mo10465U() {
            CameraManager.this.m10210H();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: V */
        public int mo10466V() {
            return CameraManager.this.f10981q;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10491a(boolean z, List<String> list, String str, int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraManager", "updateEffectMenuData, currMenuName: " + str + ", currItemIndex: " + OplusGLSurfaceView_13);
            CameraManager.this.mCameraUIManager.m19690a(list, str, OplusGLSurfaceView_13);
            if (z && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_FILTER_PROCESS)) {
                CameraManager.this.mModeManager.m11821a(CameraManager.this.mCameraUIManager.mo18038I());
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: W */
        public void mo10467W() {
            CameraManager.this.f10932eF.removeMessages(10);
            CameraManager.this.f10932eF.sendEmptyMessage(10);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: X */
        public void mo10468X() {
            CameraManager.this.m9816bM();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10571g(boolean z) {
            Size sizeM19747bG = CameraManager.this.mCameraUIManager.m19747bG();
            int iM11789U = CameraManager.this.mModeManager.m11789U();
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m9705a(sizeM19747bG, sizeM19747bG, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2589q(cameraManager, null));
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10556b(boolean z, boolean z2) {
            CameraManager.this.m10336c(z, z2);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo10573h(boolean z) {
            if (!mo10463S()) {
                CameraManager.this.f10912dl = z;
                Size sizeM19747bG = CameraManager.this.mCameraUIManager.m19747bG();
                Size sizeM11796a = CameraManager.this.mModeManager != null ? CameraManager.this.mModeManager.m11796a(CameraManager.this.f10853ce) : null;
                if (sizeM11796a == null || sizeM19747bG == null) {
                    return;
                }
                int iM11789U = CameraManager.this.mModeManager.m11789U();
                CameraManager cameraManager = CameraManager.this;
                if (cameraManager.m9705a(sizeM19747bG, sizeM11796a, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) cameraManager.f10928eB)) {
                    CameraManager.this.m10353f(true);
                    return;
                }
                return;
            }
            CameraLog.m12954a("CameraManager", "onBeauty3DChange, BlurAnimRunning, return");
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: Y */
        public boolean mo10469Y() {
            return CameraManager.this.m10214L();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo10574i(boolean z) {
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23689g(z);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: Z */
        public void mo10470Z() {
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23642B();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aa */
        public void mo10525aa() {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11521g();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ab */
        public void mo10526ab() {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11523h();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_15 */
        public void mo10577j(boolean z) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11517e(z);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_5 */
        public void mo10578k(boolean z) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11520f(z);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ac */
        public void mo10527ac() {
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23703p();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10477a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11925bV();
            }
            mo10569f(true);
            CameraManager.this.f10875dA = true;
            CameraManager.this.f10957ej = false;
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12128t(false);
            }
            if (CameraManager.this.f10876dB == null || OplusGLSurfaceView_13 < 1) {
                return;
            }
            CameraManager.this.f10876dB.notifyErrorType(new ApsService.ApsFailure(1, -1L, OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2));
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ad */
        public VibrateManager mo10528ad() {
            if (CameraManager.this.f10839cQ != null) {
                return CameraManager.this.f10839cQ;
            }
            return null;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ae */
        public boolean mo10529ae() {
            return CameraManager.this.m10396v();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: af */
        public String mo10530af() {
            return CameraManager.this.m9797bC();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ag */
        public String mo10531ag() {
            return CameraManager.this.m9799bD();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ah */
        public String mo10532ah() {
            return CameraManager.this.f10881dG;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10488a(String str) {
            CameraManager.this.f10881dG = str;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ai */
        public int mo10533ai() {
            return CameraManager.this.f10699G;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10478a(long OplusGLSurfaceView_15, String str, boolean z, boolean z2, boolean z3) {
            CameraManager.this.m9671a(OplusGLSurfaceView_15, str, z, z2, z3);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aj */
        public int mo10534aj() {
            return CameraManager.this.m10393u();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ak */
        public float mo10535ak() {
            return CameraManager.this.m10279aO();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: al */
        public float mo10536al() {
            return CameraManager.this.f10853ce.m13268d(CameraManager.this.mModeManager.m12012cu());
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: am */
        public float mo10537am() {
            return CameraManager.this.f10853ce.m13266c(CameraManager.this.mModeManager.m12012cu());
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10495a(float COUIBaseListPopupWindow_12) {
            return CameraManager.this.m10343d(COUIBaseListPopupWindow_12);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: an */
        public void mo10538an() {
            CameraManager.this.m10296af();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ao */
        public boolean mo10539ao() {
            return CameraManager.this.m10269aE();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ap */
        public boolean mo10540ap() {
            return CameraManager.this.m10271aG();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo10565e(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mCameraUIManager == null || CameraManager.this.mCameraUIListener == null || CameraManager.this.f10700H == OplusGLSurfaceView_13) {
                return;
            }
            if (18 == OplusGLSurfaceView_13 && CameraManager.this.f10700H != 0 && CameraManager.this.mCameraUIManager.mo18131aU()) {
                CameraManager.this.f10730aL = false;
                CameraManager.this.mCameraUIManager.mo18138ab();
            }
            CameraManager.this.f10700H = OplusGLSurfaceView_13;
            CameraManager.this.mCameraUIManager.m19965j(OplusGLSurfaceView_13, true);
            if (18 != OplusGLSurfaceView_13 || !CameraManager.this.m10327b(CameraUIInterface.KEY_MACRO_SWITCH)) {
                CameraManager.this.mCameraUIManager.mo18242m(CameraManager.this.f10700H);
            } else {
                CameraManager.this.mCameraUIManager.mo18070a(R.string.camera_ai_scn_microspur, -1, false, true, true);
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_ULTRA_WIDE_AF)) {
                    CameraManager.this.mCameraUIManager.m19662a(R.string.camera_mode_macro_hint, new Object[0]);
                }
            }
            if (CameraManager.this.f10700H > 0) {
                CameraManager.this.mCameraUIListener.mo10682a(OplusGLSurfaceView_13, CameraManager.this.mCameraUIManager.m19633Q(OplusGLSurfaceView_13), false);
                CameraManager cameraManager = CameraManager.this;
                cameraManager.m9697a("ai_scene", String.valueOf(cameraManager.f10700H));
            } else {
                CameraManager.this.mCameraUIListener.mo10682a(0, false, false);
                CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_mode_macro_hint);
                CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_ai_scn_microspur);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aq */
        public SloganUtil mo10541aq() {
            if (CameraManager.this.f10831cI == null) {
                CameraManager cameraManager = CameraManager.this;
                cameraManager.f10831cI = new SloganUtil(cameraManager.f10849ca, CameraManager.this.f10850cb, CameraManager.this.f10846cX.m13317J());
            }
            return CameraManager.this.f10831cI;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ar */
        public BaseSloganUtil.PlatformImplementations.kt_3 mo10542ar() {
            return CameraManager.this.m10316az();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: as */
        public int mo10543as() {
            return CameraManager.this.f10846cX.m13329a(CameraManager.this.mModeManager.m12105n(), CameraManager.this.f10989y);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: at */
        public boolean mo10544at() {
            return CameraManager.this.m10284aT();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: au */
        public void mo10545au() {
            CameraManager.this.m9816bM();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: av */
        public void mo10546av() {
            CameraManager.this.blurModeChanged();
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x012d  */
        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void mo10490a(boolean r11, int r12, boolean r13, int r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 410
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.CameraManager.C254049.mo10490a(boolean, int, boolean, int, boolean):void");
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aw */
        public int mo10547aw() {
            return CameraManager.this.m10304an();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ax */
        public int mo10548ax() {
            return CameraManager.this.m10285aU();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: ay */
        public boolean mo10549ay() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12143z();
            }
            return false;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10552b(final float COUIBaseListPopupWindow_12) {
            CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.49.3
                @Override // java.lang.Runnable
                public void run() {
                    CameraManager.this.m10230a(COUIBaseListPopupWindow_12);
                }
            });
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: az */
        public void mo10550az() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager cameraManager = CameraManager.this;
                cameraManager.m10244a(cameraManager.mModeManager.m11796a(CameraManager.this.f10853ce), true);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aA */
        public boolean mo10499aA() {
            return CameraManager.this.f10765au;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10496a(float COUIBaseListPopupWindow_12, float f2) {
            if (CameraManager.this.mModeManager == null || !CameraManager.this.m10327b(CameraFunction.SAT_CAMERA)) {
                return false;
            }
            if (CameraManager.this.mModeManager.m11900b(COUIBaseListPopupWindow_12) && CameraManager.this.mModeManager.m11900b(f2)) {
                return false;
            }
            if (mo10495a(COUIBaseListPopupWindow_12) && mo10495a(f2)) {
                return false;
            }
            return (CameraManager.this.m10350e(COUIBaseListPopupWindow_12) && CameraManager.this.m10350e(f2)) ? false : true;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aB */
        public boolean mo10500aB() {
            if (CameraManager.this.mModeManager == null) {
                return false;
            }
            CameraManager.this.mModeManager.m12044dd();
            return false;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aC */
        public void mo10501aC() {
            if (CameraManager.this.mCameraUIListener != null) {
                CameraManager.this.mCameraUIListener.mo10862l((String) null);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aD */
        public boolean mo10502aD() {
            return CameraManager.this.f10772bB;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10487a(CameraPictureCallback cameraPictureCallback) {
            CameraManager.this.f10899dY = cameraPictureCallback;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aE */
        public CameraDeviceInfo mo10503aE() {
            return CameraManager.this.f10896dV;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aF */
        public boolean mo10504aF() {
            return CameraManager.this.m10228Z();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10568f(int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10735aQ <= Util.f22996d && CameraManager.this.f10735aQ > OplusGLSurfaceView_13) {
                OplusGLSurfaceView_13 = CameraManager.this.f10735aQ;
            }
            CameraManager.this.m9592D(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aG */
        public String mo10505aG() {
            return CameraManager.this.f10846cX.m13358v();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aH */
        public void mo10506aH() {
            CameraManager cameraManager = CameraManager.this;
            cameraManager.updateZoom(cameraManager.m10282aR(), true);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10557c(float COUIBaseListPopupWindow_12) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11502b(COUIBaseListPopupWindow_12);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aI */
        public void mo10507aI() {
            CameraManager.this.f10856ch.mo9571q();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aJ */
        public void mo10508aJ() {
            CameraManager.this.f10856ch.mo9570p();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aK */
        public float[] mo10509aK() {
            if (CameraManager.this.f10866cr != null) {
                return CameraManager.this.f10866cr.m11546z();
            }
            return null;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_14 */
        public void mo10581l(boolean z) {
            CameraManager.this.m9610J(z);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10481a(Size size) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19666a(CameraManager.this.f10861cm, CameraManager.this.f10853ce.m13269d(), size);
            }
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23665a(CameraManager.this.f10861cm, CameraManager.this.f10853ce.m13269d(), size);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aL */
        public void mo10510aL() {
            CameraManager.this.f10938eL.mo10440a();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10554b(Size size) {
            Size sizeM19747bG = CameraManager.this.mCameraUIManager.m19747bG();
            CameraLog.m12954a("CameraManager", "changePreviewSizeIfNeeded, newSize: " + size + ", currSize: " + sizeM19747bG + ", mCameraState: " + CameraManager.this.f10982r + ", mbSizeChanging: " + CameraManager.this.f10763as + ", mbSendCapturePictureRequest: " + CameraManager.this.f10922dv + "\OplusGLSurfaceView_11");
            if (sizeM19747bG == null || sizeM19747bG.toString().equals(size.toString()) || !mo10522aX() || CameraManager.this.f10763as || CameraManager.this.f10922dv) {
                return;
            }
            CameraManager.this.m9811bJ();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10476a(long OplusGLSurfaceView_15) {
            if (CameraManager.this.f10892dR != null) {
                CameraManager.this.f10892dR.mo24730a(7, OplusGLSurfaceView_15);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aM */
        public TiltShiftParam mo10511aM() {
            if (CameraManager.this.f10867cs != null) {
                return CameraManager.this.f10867cs.getTiltShiftCaptureParam();
            }
            return null;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aN */
        public boolean mo10512aN() {
            return CameraManager.this.f10753ai;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aO */
        public void mo10513aO() {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.updateZoom(mo10535ak(), false);
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10497a(boolean z, float COUIBaseListPopupWindow_12) {
            if (CameraManager.this.f10866cr == null || !((OneCameraProxy) CameraManager.this.f10852cd).m13225E() || CameraManager.this.f10757am) {
                return false;
            }
            return CameraManager.this.f10866cr.m11500a(z, COUIBaseListPopupWindow_12, 1.0f);
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aP */
        public MagShellResponseStatus mo10514aP() {
            return CameraManager.this.f10954eg;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aQ */
        public boolean mo10515aQ() {
            return CameraManager.this.f10806bj;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aR */
        public void mo10516aR() {
            CameraManager.this.f10806bj = false;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aS */
        public void mo10517aS() {
            if (CameraManager.this.f10855cg != null) {
                CameraManager.this.f10855cg.mo10954b();
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aT */
        public HintManager mo10518aT() {
            return CameraManager.this.mCameraUIManager.mo18233k();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: OplusGLSurfaceView_6 */
        public void mo10582m(boolean z) {
            if (CameraManager.this.f10865cq == null || !CameraManager.this.f10865cq.m23655O()) {
                return;
            }
            CameraManager.this.m10309as();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aU */
        public BaseScreenMode mo10519aU() {
            return mo10520aV();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aV */
        public BaseScreenMode mo10520aV() {
            return CameraManager.this.f10890dP.mo16411a();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public int[] mo10498a(Activity activity, int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10890dP != null) {
                return CameraManager.this.f10890dP.mo16411a().mo16565c(activity, OplusGLSurfaceView_13);
            }
            return null;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10480a(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult) {
            if (CameraManager.this.f10855cg != null) {
                CameraManager.this.f10855cg.mo10952a(cameraCaptureResult.getCaptureResult(), cameraCaptureResult.getRequestTag());
            }
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aW */
        public void mo10521aW() {
            CameraManager.this.m10005cv();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aX */
        public boolean mo10522aX() {
            return CameraManager.this.m10222T();
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aY */
        public boolean mo10523aY() {
            return CameraManager.this.f10731aM;
        }

        @Override // com.oplus.camera.capmode.CameraInterface
        /* renamed from: aZ */
        public void mo10524aZ() {
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.49.4
                @Override // java.lang.Runnable
                public void run() {
                    CameraManager.this.m9996cq();
                }
            }, "clearLockDB");
            CameraManager.this.f10920dt = true;
            CameraManager.this.f10731aM = false;
        }
    };

    /* renamed from: eN */
    private CameraTemperatureInterface f10940eN = new CameraTemperatureInterface() { // from class: com.oplus.camera.CameraManager.50
        @Override // com.oplus.camera.p180v.CameraTemperatureInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10598a() {
            if (CameraManager.this.f10752ah || CameraManager.this.f10852cd == null || CameraManager.this.f10747ac) {
                return;
            }
            if (CameraManager.this.mModeManager != null) {
                String strM11787S = CameraManager.this.mModeManager.m11787S();
                CameraLog.m12959b("CameraManager", "stopFlash torchMode: " + strM11787S);
                if ("off".equals(strM11787S) || CameraManager.this.mModeManager.m11871af()) {
                    return;
                }
            }
            CameraManager.this.f10852cd.mo13069b("off");
            CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            if (CameraManager.this.f10914dn != null) {
                CameraManager.this.f10914dn.m17206h().setFlashState();
            }
            CameraManager.this.m9893bz();
        }

        @Override // com.oplus.camera.p180v.CameraTemperatureInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10600a(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11893b(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p180v.CameraTemperatureInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10599a(float COUIBaseListPopupWindow_12) {
            CameraLog.m12959b("CameraManager", "adjustBrightness, brightness: " + COUIBaseListPopupWindow_12 + ", mMaxScreenBrightness: " + CameraManager.this.f10981q);
            if (CameraManager.this.f10914dn == null || CameraManager.this.f10914dn.m17206h().getBrightness() >= COUIBaseListPopupWindow_12) {
                if (CameraManager.this.f10849ca != null) {
                    Window window = CameraManager.this.f10849ca.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.screenBrightness = COUIBaseListPopupWindow_12 / CameraManager.this.f10981q;
                    window.setAttributes(attributes);
                    return;
                }
                return;
            }
            CameraLog.m12967f("CameraManager", "adjustBrightness, brightness: " + COUIBaseListPopupWindow_12 + ", mBrightness: " + CameraManager.this.f10914dn.m17206h().getBrightness() + ", so do not set brightness by system");
        }

        @Override // com.oplus.camera.p180v.CameraTemperatureInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10602a(boolean z, int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10849ca == null || 1 != OplusGLSurfaceView_13) {
                if (CameraManager.this.f10832cJ != null) {
                    CameraManager.this.f10832cJ.m24659b();
                    return;
                }
                return;
            }
            CameraLog.m12959b("CameraManager", "finishByHighTemperature isStartCamera: " + z + ", highTempProtectStatus: " + OplusGLSurfaceView_13);
            if (!z) {
                Toast.makeText(CameraManager.this.f10849ca, CameraManager.this.f10849ca.getString(R.string.camera_high_temperature_exit_toast), 0).show();
            }
            CameraManager.this.m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_CAM);
            CameraManager.this.f10849ca.finish();
        }

        @Override // com.oplus.camera.p180v.CameraTemperatureInterface
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10601a(int OplusGLSurfaceView_13, int i2) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11807a(OplusGLSurfaceView_13, i2);
            }
        }

        @Override // com.oplus.camera.p180v.CameraTemperatureInterface
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10603b(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19985x(OplusGLSurfaceView_13);
            }
        }
    };

    /* renamed from: eO */
    private CameraFocusListener f10941eO = new CameraFocusListener() { // from class: com.oplus.camera.CameraManager.51
        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10610a(int[] iArr, boolean z) {
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10852cd.mo13073b(iArr);
                if (z) {
                    CameraManager.this.f10852cd.mo13035a(CameraManager.this.f10937eK);
                }
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m12142z(CameraManager.this.f10865cq.m23655O());
                }
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10609a(boolean z, boolean z2) {
            mo10621c(z, z2);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10612a() {
            return (CameraManager.this.mModeManager == null || CameraManager.this.mModeManager.m11963c(MotionEvent.obtain(0L, 0L, 0, -1.0f, -1.0f, -1))) ? false : true;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo10620b() {
            return CameraManager.this.m10214L();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10613a(int OplusGLSurfaceView_13, int i2) {
            Rect rectM19750bJ;
            if (CameraManager.this.mCameraUIManager != null && (rectM19750bJ = CameraManager.this.mCameraUIManager.m19750bJ()) != null) {
                OplusGLSurfaceView_13 += rectM19750bJ.left;
                i2 += rectM19750bJ.top;
            }
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11838a(CameraManager.this.f10890dP.mo16411a().mo16529a(CameraManager.this.mCameraUIManager, OplusGLSurfaceView_13, i2), OplusGLSurfaceView_13, i2);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo10622c() {
            CameraManager cameraManager = CameraManager.this;
            return cameraManager.m10136k(cameraManager.f10870cv);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean mo10623d() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.mo18207e();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean mo10624e() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11942bm();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10625f() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19703ab(CameraManager.this.f10747ac);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10626g() {
            CameraManager.this.mCameraUIManager.m19826cc();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo10627h() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19827cd();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo10628i() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19828ce();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: OplusGLSurfaceView_15 */
        public boolean mo10629j() {
            return CameraManager.this.mModeManager.m12082h();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10614a(String str) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12091j(str);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10608a(boolean z) {
            if (CameraManager.this.f10865cq != null && CameraManager.this.f10865cq.m23691h()) {
                CameraManager.this.f10881dG = "tap";
            }
            CameraManager.this.m10098f(false, z);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10618b(boolean z, boolean z2) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.mo18200d(z, z2);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10617b(boolean z) {
            CameraManager.this.m9581A(z);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: OplusGLSurfaceView_5 */
        public boolean mo10630k() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.m19758bR();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: OplusGLSurfaceView_14 */
        public void mo10631l() {
            CameraManager.this.m10164q("2");
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: OplusGLSurfaceView_6 */
        public boolean mo10632m() {
            return (CameraManager.this.f10852cd == null || CameraManager.this.f10852cd.mo13086e() == null || Float.compare(CameraManager.this.f10852cd.mo13086e().m13279n(), 0.0f) != 0) ? false : true;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: OplusGLSurfaceView_11 */
        public boolean mo10633n() {
            return CameraManager.this.mModeManager.m11861aV();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: o */
        public boolean mo10634o() {
            return CameraManager.this.mCameraUIManager.m19786by();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10606a(int OplusGLSurfaceView_13, RectF rectF, RectF rectF2) {
            CameraManager.this.m10235a(OplusGLSurfaceView_13, rectF, rectF2);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10607a(Rect rect, Rect rect2) {
            if (1.0f > CameraManager.this.m10279aO()) {
                if (rect != null) {
                    CameraManager.this.f10852cd.mo13038a(new OplusMeteringRectangle(rect, AEAFHelp.m11157e()));
                }
                if (rect2 != null) {
                    CameraManager.this.f10852cd.mo13068b(new OplusMeteringRectangle(rect2, AEAFHelp.m11156d()));
                }
            } else {
                MeteringRectangle[] meteringRectangleArr = rect2 != null ? new MeteringRectangle[]{new MeteringRectangle(rect2, AEAFHelp.m11156d())} : null;
                CameraManager.this.f10852cd.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_REGIONS, (CaptureRequest.Key) (rect != null ? new MeteringRectangle[]{new MeteringRectangle(rect, AEAFHelp.m11157e())} : null));
                CameraManager.this.f10852cd.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AF_REGIONS, (CaptureRequest.Key) meteringRectangleArr);
            }
            CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10605a(int OplusGLSurfaceView_13, int i2, RectF rectF) {
            CameraManager.this.m10255a(true, OplusGLSurfaceView_13, i2);
            CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<RectF>>) CameraParameter.AE_REGIONS, (CameraParameter.PreviewKey<RectF>) rectF);
            CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10616b(int OplusGLSurfaceView_13, int i2, RectF rectF) {
            CameraManager.this.m10255a(false, OplusGLSurfaceView_13, i2);
            CameraManager.this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<RectF>>) CameraParameter.AF_REGIONS, (CameraParameter.PreviewKey<RectF>) rectF);
            CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10611a(MeteringRectangle[] meteringRectangleArr) {
            if (meteringRectangleArr != null) {
                CameraManager.this.f10852cd.mo13078c(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
                CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10619b(MeteringRectangle[] meteringRectangleArr) {
            if (meteringRectangleArr != null) {
                CameraManager.this.f10852cd.mo13078c(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
                CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10604a(int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10699G = OplusGLSurfaceView_13;
                CameraManager.this.f10852cd.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(CameraManager.this.f10699G));
                CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: p */
        public boolean mo10635p() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_MANUAL_EXPOSURE);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: q */
        public boolean mo10636q() {
            if (CameraManager.this.f10852cd == null || CameraManager.this.f10852cd.mo13086e() == null) {
                return false;
            }
            return CameraManager.this.f10852cd.mo13086e().m13285t();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: r */
        public boolean mo10637r() {
            if ((CameraManager.this.mModeManager != null && !CameraManager.this.mModeManager.m12028dE()) || CameraManager.this.f10852cd == null || CameraManager.this.f10852cd.mo13086e() == null) {
                return false;
            }
            return CameraManager.this.f10852cd.mo13086e().m13284s();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: s */
        public void mo10638s() {
            CameraManager.this.m10351f();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: t */
        public void mo10639t() {
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10852cd.mo13119o();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: u */
        public boolean mo10640u() {
            return CameraManager.this.m10342d();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: v */
        public boolean mo10641v() {
            return CameraManager.this.m10312av();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10615b(int OplusGLSurfaceView_13, int i2) {
            CameraManager.this.m10234a(OplusGLSurfaceView_13, i2);
            if (CameraManager.this.f10864cp != null) {
                CameraManager.this.f10864cp.mo22781a(new Point(OplusGLSurfaceView_13, i2));
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: w */
        public int mo10642w() {
            return CameraManager.this.m10356g();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: x */
        public int mo10643x() {
            if (CameraManager.this.f10853ce != null) {
                return CameraManager.this.f10853ce.m13282q();
            }
            return AEAFHelp.m11155c();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: y */
        public int mo10644y() {
            if (CameraManager.this.f10853ce != null) {
                return CameraManager.this.f10853ce.m13281p();
            }
            return AEAFHelp.m11155c();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: z */
        public Rect mo10645z() {
            CameraManager cameraManager = CameraManager.this;
            return cameraManager.m10331c(cameraManager.m10279aO());
        }

        @Override // com.oplus.camera.p172ui.preview.CameraFocusListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10621c(boolean z, boolean z2) {
            CameraManager.this.m10336c(z, z2);
        }
    };
    private CameraUIListener mCameraUIListener = new C254452();

    /* renamed from: eP */
    private PopUpWindowAnimationListener f10942eP = new PopUpWindowAnimationListener() { // from class: com.oplus.camera.CameraManager.54
        @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10885a(String str) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11895b(8, false);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10887b(String str) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11895b(8, true);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10886a(String str, boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11895b(9, false);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10888c(String str) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11895b(9, true);
            }
        }
    };

    /* renamed from: eQ */
    private ThumbnailProcessor.ThumbnailProcessListener f10943eQ = new ThumbnailProcessor.ThumbnailProcessListener() { // from class: com.oplus.camera.CameraManager.57
        @Override // com.oplus.camera.aps.service.ThumbnailProcessor.ThumbnailProcessListener
        public void updateLastThumbnailView(Uri uri, ContentResolver contentResolver) {
        }

        @Override // com.oplus.camera.aps.service.ThumbnailProcessor.ThumbnailProcessListener
        public void updateLastThumbnailView(boolean z) {
        }

        @Override // com.oplus.camera.aps.service.ThumbnailProcessor.ThumbnailProcessListener
        public void updateThumbnail(final Thumbnail c3203e, ThumbnailItem thumbnailItem, ContentResolver contentResolver) {
            if (CameraManager.this.f10892dR != null && thumbnailItem.mbWatchRequest) {
                CameraManager.this.f10892dR.mo24731a(2, c3203e.m19294h());
            }
            if (CameraManager.this.f10876dB != null && CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11844aE()) {
                thumbnailItem.mProductProcessor = CameraManager.this.f10969ev;
                thumbnailItem.mUpdateLastThumbTask = CameraManager.this.m9958cX();
                CameraManager.this.f10876dB.addThumbnailInfo(thumbnailItem);
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONLY_HIGH_PICTURE_SIZE_HEIF_IN_APS) && (("heic_8bits".equalsIgnoreCase(thumbnailItem.mPictureFormat) || "heic_10bits".equalsIgnoreCase(thumbnailItem.mPictureFormat)) && !CameraManager.this.mModeManager.m11917bN())) {
                    CameraManager.this.f10852cd.mo13083d(thumbnailItem.mIdentity);
                }
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11814a(thumbnailItem);
            }
            if (CameraManager.this.f10932eF != null && !CameraManager.this.f10752ah) {
                CameraManager.this.f10932eF.post(new Runnable() { // from class: com.oplus.camera.CameraManager.57.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.mCameraUIManager != null) {
                            CameraManager.this.mCameraUIManager.m19678a(c3203e);
                        }
                        CameraManager.this.m10253a(true);
                    }
                });
            } else {
                CameraManager.this.m10253a(true);
            }
            if (c3203e != null) {
                ThumbnailHolder.m19300a();
                ThumbnailHolder.m19301a(c3203e);
            }
        }

        @Override // com.oplus.camera.aps.service.ThumbnailProcessor.ThumbnailProcessListener
        public void updateQuickBitmap(Bitmap bitmap) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19664a(bitmap);
            }
        }
    };

    /* renamed from: eR */
    private View.OnClickListener f10944eR = new View.OnClickListener() { // from class: com.oplus.camera.CameraManager.58
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraManager.this.mCameraUIManager.m19948ev()) {
                CameraManager.this.mCameraUIManager.mo18041J(true);
                return;
            }
            if (CameraManager.this.mCameraUIManager.m19950ex()) {
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m12040dQ();
                }
                CameraManager.this.mCameraUIManager.m19620D(true, true);
            } else {
                CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
                CameraManager.this.mCameraUIManager.mo18176b(true, true, true, false);
            }
        }
    };

    /* renamed from: eS */
    private ThumbnailClickListener f10945eS = new ThumbnailClickListener() { // from class: com.oplus.camera.CameraManager.59

        /* renamed from: IntrinsicsJvm.kt_4 */
        private CameraControlUI.IntrinsicsJvm.kt_3 f11096b = new CameraControlUI.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.CameraManager.59.1
            @Override // com.oplus.camera.p172ui.control.CameraControlUI.IntrinsicsJvm.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo10895a(Thumbnail c3203e) throws Throwable {
                CameraLog.m12959b("CameraManager", "onThumbnailLoadSucceed: uri = " + c3203e.m19291e());
                CameraManager.this.m9696a(c3203e);
            }
        };

        @Override // com.oplus.camera.p172ui.control.ThumbnailClickListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10891a(Storage.CameraPicture cameraPicture) {
            CameraLog.m12954a("CameraManager", "notifyGalleryPreDecode");
            if (cameraPicture == null || cameraPicture.f12130c == null) {
                return;
            }
            CallGalleryPreDecodeThread.m14689a().m14692a(cameraPicture);
        }

        @Override // com.oplus.camera.p172ui.control.ThumbnailClickListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10892a(Thumbnail c3203e) throws Throwable {
            if (CameraManager.this.m9840bY() && c3203e != null) {
                Uri uriM19291e = c3203e.m19291e();
                boolean zM24290a = Util.m24290a(uriM19291e, CameraManager.this.f10849ca.getContentResolver());
                boolean z = CameraManager.this.m10303am() && CameraManager.this.f10921du;
                if ((CameraManager.this.f10846cX.m13359w() && !z) || !zM24290a) {
                    CameraLog.m12966e("CameraManager", "onThumbNailClick, imageSaveListIsEmpty: " + ImageSaverThread.m14696a().m14711g() + ", getDisplayOnLock: " + CameraManager.this.m10303am() + ", isLockAlbumHasPicture: " + z + ", isUriValid: " + zM24290a);
                    CameraManager.this.mCameraUIManager.m19676a(this.f11096b);
                    return;
                }
                CameraLog.m12967f("CameraManager", "CameraTest Camera View Picture Start, onThumbNailClick, mCurrentUri: " + uriM19291e);
                if (!CameraManager.this.f10846cX.m13359w() && CameraManager.this.f10846cX.m13311D()) {
                    CameraManager.this.f10846cX.m13310C();
                }
                CameraManager.this.m9696a(c3203e);
                return;
            }
            CameraLog.m12966e("CameraManager", "onThumbNailClick, cameraState: " + CameraManager.this.f10982r + ", thumbnail: " + c3203e);
        }

        @Override // com.oplus.camera.p172ui.control.ThumbnailClickListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10894a() {
            if (!CameraManager.this.f10846cX.m13359w() || !CameraManager.this.m10303am()) {
                return true;
            }
            if (!CameraManager.this.f10920dt && CameraManager.this.f10921du) {
                return true;
            }
            CameraLog.m12954a("CameraManager", "needGetLastThumbNail, LockAblum list is null");
            return false;
        }

        @Override // com.oplus.camera.p172ui.control.ThumbnailClickListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10893a(boolean z) {
            boolean z2 = Util.m24495t() && CameraManager.this.f10890dP != null && CameraManager.this.f10890dP.mo16411a() != null && 3 == CameraManager.this.f10890dP.mo16411a().mo16539j();
            if (z && !z2) {
                CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.59.2
                    @Override // java.lang.Runnable
                    public void run() {
                        m10890b();
                    }
                }, "query lock album");
            } else {
                m10890b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m10890b() {
            Uri uri = Uri.parse("content://com.open.gallery.smart.provider/locked_pictures");
            try {
                Cursor cursorM24530a = ContentProviderUtil.m24530a(uri, new String[]{"count(*)"}, (Bundle) null, (CancellationSignal) null);
                if (cursorM24530a != null) {
                    try {
                        if (cursorM24530a.moveToFirst()) {
                            CameraManager.this.f10921du = cursorM24530a.getLong(0) > 0;
                        }
                    } finally {
                    }
                }
                if (cursorM24530a != null) {
                    cursorM24530a.close();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12965d("CameraManager", "realUpdateLockAlbumHasPicture, Failed to query LOCK_SCREEN_URI uri: " + uri, COUIBaseListPopupWindow_8);
                CameraManager.this.f10921du = false;
            }
            CameraLog.m12954a("CameraManager", "realUpdateLockAlbumHasPicture, mbLockAlbumHasPicture: " + CameraManager.this.f10921du);
        }
    };
    private CameraControlButtonListener mCameraControlButtonListener = new CameraControlButtonListener() { // from class: com.oplus.camera.CameraManager.63
        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10896a() {
            if (!CameraManager.this.f10796bZ.block(20L)) {
                CameraLog.m12967f("CameraManager", "onCameraDoneButtonClick, failed, mWriteThirdImageLock blocked");
            } else {
                CameraManager.this.m10219Q();
            }
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10898b() {
            if (CameraManager.this.f10752ah || CameraManager.this.f10905de == null) {
                return;
            }
            if (CameraManager.this.f10796bZ.block(20L)) {
                CameraManager.this.mCameraUIManager.m19835cl();
                CameraManager.this.mCameraUIManager.mo18200d(true, false);
                if (CameraManager.this.m10327b(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
                    CameraManager.this.mModeManager.m11895b(6, true);
                }
                CameraManager.this.mModeManager.m11895b(5, true);
                CameraManager.this.m9926cH();
                CameraManager.this.mModeManager.m11827a(CameraManager.this.mModeManager.m11787S(), true);
                CameraManager.this.m10367j(1);
                if (CameraManager.this.f10846cX.m13317J() != 2 || CameraManager.this.f10747ac || CameraManager.this.f10852cd == null) {
                    return;
                }
                CameraManager.this.f10852cd.mo13119o();
                int iMo13122p = CameraManager.this.f10852cd.mo13122p();
                CameraLog.m12954a("CameraManager", "onCameraRetakeButtonClick, focusMode: " + iMo13122p);
                if (1 == iMo13122p) {
                    CameraManager.this.f10852cd.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                    CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
                if (CameraManager.this.f10865cq != null) {
                    CameraManager.this.f10865cq.m23676c();
                }
                CameraManager.this.mModeManager.m11845aF();
                return;
            }
            CameraLog.m12967f("CameraManager", "onCameraRetakeButtonClick, failed, mWriteThirdImageLock blocked");
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10900c() {
            CameraManager.this.mModeManager.m12109o(true);
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10902d() {
            CameraManager.this.mModeManager.m11851aL();
            CameraManager.this.mCameraUIManager.m19836cm();
            CameraManager.this.mCameraUIManager.m19703ab(CameraManager.this.f10747ac);
            CameraManager.this.m9926cH();
            CameraManager.this.mCameraUIManager.mo18171b(CameraUIInterface.KEY_VIDEO_FLASH_MODE, (String) null);
            CameraManager.this.mModeManager.m11854aO();
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo10903e() {
            CameraManager.this.f10804bh = true;
            CameraManager.this.mModeManager.m11853aN();
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10904f() {
            CameraManager.this.mModeManager.m12048dh();
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10897a(boolean z) {
            if (CameraManager.this.m10269aE()) {
                return;
            }
            CameraManager.this.mModeManager.m11766A(z);
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10905g() {
            CameraManager.this.mModeManager.m12141y(true);
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10899b(boolean z) {
            if (CameraManager.this.f10752ah || CameraManager.this.m10224V() || CameraManager.this.m10223U() || !z || !CameraManager.this.m10222T() || Storage.f12097w != 0) {
            }
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo10906h() {
            CameraLog.m12954a("CameraManager", "onCameraShutterButtonClick");
            if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_QUICK_VIDEO) || !CameraManager.this.mModeManager.m11862aW()) {
                CameraManager.this.f10748ad = true;
                if (CameraManager.this.mCameraUIManager != null) {
                    if (CameraManager.this.mCameraUIManager.mo18059T()) {
                        CameraManager.this.mCameraUIManager.mo18060U();
                    }
                    if (CameraManager.this.mCameraUIManager.mo18051O() && CameraEntry.m13302b(CameraManager.this.f10846cX.m13317J())) {
                        CameraManager.this.mCameraUIManager.m19847cx();
                    }
                }
                if (CameraManager.this.f10868ct == null || !CameraManager.this.f10868ct.m11652e()) {
                    if (CameraManager.this.f10865cq != null && CameraManager.this.f10865cq.m23653M()) {
                        CameraManager.this.f10748ad = false;
                        CameraLog.m12954a("CameraManager", "onCameraShutterButtonClick, wait AF so return");
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "onCameraShutterButtonClick, normal snapshot");
                    CameraLog.m12952a("captureX onCameraShutterButtonClick");
                    CameraManager.this.m9959cY();
                    CameraManager.this.f10748ad = false;
                    if (CameraManager.this.m10303am()) {
                        CameraManager.this.m10392t(false);
                    }
                    CameraLog.m12958b("captureX onCameraShutterButtonClick");
                    return;
                }
                CameraManager.this.f10748ad = false;
                return;
            }
            CameraLog.m12966e("CameraManager", "onCameraShutterButtonClick, isHalVideoRecording: " + CameraManager.this.mModeManager.m11862aW());
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo10907i() {
            boolean zM10260a = CameraManager.this.m10260a(1);
            if (!CameraManager.this.m10312av() && !CameraManager.this.mModeManager.m11861aV() && !CameraManager.this.mModeManager.m11791W() && zM10260a && !CameraManager.this.f10752ah && !CameraManager.this.f10760ap && !CameraManager.this.m10223U()) {
                if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.mo18059T()) {
                    CameraManager.this.mCameraUIManager.mo18060U();
                }
                if (Storage.f12097w == 0) {
                    if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SHORT_VIDEO)) {
                        if (CameraManager.this.mModeManager.m11937bh()) {
                            return;
                        }
                        CameraManager.this.f10932eF.removeMessages(9);
                        CameraManager.this.m10395v(true);
                        CameraManager.this.mModeManager.m12138x();
                        CameraManager.this.mModeManager.m12132v();
                        if (!LockViewDragLayout.getIsVolumeDownState()) {
                            LockViewDragLayout.setLongPressState(true);
                            LockViewDragLayout.setQuickRecordState(true);
                        }
                        if (CameraManager.this.m10303am()) {
                            CameraManager.this.m10392t(false);
                            return;
                        }
                        return;
                    }
                    if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_QUICK_VIDEO)) {
                        CameraManager.this.mCameraUIManager.m19826cc();
                        if (CameraManager.this.mCameraUIManager.mo18043K()) {
                            CameraManager.this.mCameraUIManager.mo18109a(false, false, false, false);
                        }
                        CameraManager.this.mModeManager.m12138x();
                        if (LockViewDragLayout.getIsVolumeDownState()) {
                            return;
                        }
                        LockViewDragLayout.setIsQuickVideoStartedByShutterButtonLongClick(true);
                        LockViewDragLayout.setLongPressState(true);
                        LockViewDragLayout.setQuickRecordState(true);
                        return;
                    }
                    LockViewDragLayout.setQuickRecordState(false);
                    boolean zM12091j = CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_BURST_SHOT);
                    boolean zM12075f = CameraManager.this.mModeManager.m12075f(false);
                    if (!ImageSaverThread.m14696a().m14697a(CameraManager.this.f10849ca, CameraManager.this.mModeManager.m11785Q())) {
                        CameraLog.m12966e("CameraManager", "checkReadyToCapture, memory or storage is not enough");
                        CameraManager.this.mModeManager.m11784P();
                        CameraManager.this.m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
                        return;
                    }
                    if (!ImageSaverThread.m14696a().m14710f() && zM12091j && !CameraManager.this.f10766av && !CameraManager.this.m10224V() && !CameraManager.this.f10762ar && !CameraManager.this.f10763as && !zM12075f) {
                        if ("heic_10bits".equals(CameraManager.this.mModeManager.m11929bZ())) {
                            CameraManager.this.mCameraUIManager.mo18070a(R.string.camera_10bits_not_support_continuous_shot_tips, -1, true, false, false);
                            CameraManager.this.m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_10BITS_UNSUPPORT_CONTINUOUS);
                            CameraLog.m12966e("CameraManager", "onCameraShutterButtonLongClick, 10 bit heif does not support continuous shot");
                            return;
                        }
                        CameraLog.m12967f("CameraManager", "onCameraShutterButtonLongClick");
                        if (CameraManager.this.mModeManager != null) {
                            CameraManager.this.mModeManager.m12115p(true);
                        }
                        CameraManager.this.m10395v(true);
                        CameraManager.this.m10347e(false);
                        CameraManager.this.f10734aP = 0;
                        CameraManager.this.f10735aQ = 0;
                        if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_FILTER_PROCESS)) {
                            CameraManager.this.mCameraUIManager.mo18267s(true);
                            CameraManager.this.mCameraUIManager.mo18190c(false);
                        }
                        if (CameraManager.this.mCameraUIManager.mo18043K()) {
                            CameraManager.this.mCameraUIManager.mo18279v(false);
                            CameraManager.this.mCameraUIManager.mo18109a(false, true, true, false);
                        }
                        CameraManager.this.mCameraUIManager.mo18024B(false);
                        CameraManager.this.m9832bU();
                        CameraManager.this.f10852cd.mo13041a(CameraManager.this.f10876dB.getCameraPictureCallback());
                        if (CameraManager.this.f10897dW == null) {
                            CameraManager.this.f10897dW = new CaptureRequestParam();
                        }
                        if (CameraManager.this.f10876dB != null) {
                            CameraManager.this.f10876dB.setHeicCodecOpen(false);
                        }
                        if (!CameraManager.this.mModeManager.m12131u()) {
                            CameraLog.m12959b("CameraManager", "onCameraShutterButtonLongClick, burstShotCapture return false!");
                            if (CameraManager.this.f10849ca != null) {
                                CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.63.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        CameraManager.this.m10348e(true, false);
                                        CameraManager.this.m10398w(true);
                                        if (CameraManager.this.mCameraUIManager != null) {
                                            CameraManager.this.mCameraUIManager.mo18200d(true, true);
                                        }
                                    }
                                });
                            }
                            CameraManager.this.m10379n(false);
                            CameraManager.this.m10367j(1);
                            return;
                        }
                        if (CameraManager.this.m10303am()) {
                            CameraManager.this.m10392t(false);
                            return;
                        }
                        return;
                    }
                    CameraLog.m12966e("CameraManager", "onCameraShutterButtonLongClick, checkQueueLimit: " + ImageSaverThread.m14696a().m14710f() + ", isBurstShotSupported: " + zM12091j + ", mbBurstShot: " + CameraManager.this.f10766av + ", isSnapShotProgress: " + CameraManager.this.m10224V() + ", mbCaptureModeChanging: " + CameraManager.this.f10762ar + ", mbSizeChanging: " + CameraManager.this.f10763as + ", stopTakePicture: " + zM12075f);
                    return;
                }
                CameraLog.m12966e("CameraManager", "onCameraShutterButtonLongClick, sStorageStatus is failed, so return");
                CameraManager.this.mCameraUIManager.mo18269t();
                return;
            }
            CameraLog.m12966e("CameraManager", "onCameraShutterButtonLongClick, isTimerSnapShotRunning: " + CameraManager.this.m10312av() + ", isVideoRecording: " + CameraManager.this.mModeManager.m11861aV() + ", isCapturingState: " + CameraManager.this.mModeManager.m11791W() + ", isSoundLoaded: " + zM10260a + ", mbPaused: " + CameraManager.this.f10752ah + ", mbSwitchingCamera: " + CameraManager.this.f10760ap + ", isPreviewStopped: " + CameraManager.this.m10223U());
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10901c(boolean z) {
            if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SHORT_VIDEO) || !CameraManager.this.mModeManager.m11861aV() || !z || (LockViewDragLayout.getIsReachBorder() && !LockViewDragLayout.getIsVolumeDownState())) {
                if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_QUICK_VIDEO) && CameraManager.this.mModeManager.m12143z() && z && (!LockViewDragLayout.getIsReachBorder() || LockViewDragLayout.getIsVolumeDownState())) {
                    CameraManager.this.mModeManager.m12140y();
                    CameraManager.this.mCameraUIManager.mo18280w();
                    CameraManager.this.mCameraUIListener.mo10805bv();
                    LockViewDragLayout.setVolumeDownState(false);
                }
                if (!LockViewDragLayout.getMoveStatus()) {
                    LockViewDragLayout.setLongPressState(false);
                }
                if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19776bo()) {
                    CameraManager.this.mCameraUIManager.mo18284x(false);
                }
                boolean zM12091j = CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_BURST_SHOT);
                if (!CameraManager.this.m10312av() && !CameraManager.this.mModeManager.m11861aV() && CameraManager.this.f10766av && !CameraManager.this.f10752ah && zM12091j) {
                    if (CameraManager.this.mModeManager.m11883ar() == 0 && CameraManager.this.m10224V()) {
                        CameraLog.m12954a("CameraManager", "onCameraShutterButtonLongClickReleased, waiting receive first burst picture, so return");
                        CameraManager.this.m10347e(true);
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "onCameraShutterButtonLongClickReleased");
                    CameraManager.this.m10379n(false);
                    CameraManager.this.mModeManager.m11770C();
                    int iMo13134t = CameraManager.this.f10852cd.mo13134t();
                    if (iMo13134t != 0 && (CameraManager.this.f10734aP >= Util.f22996d || (!Util.m24169C() && CameraManager.this.f10734aP >= iMo13134t))) {
                        CameraManager.this.m9852bf();
                    }
                    CameraManager.this.mCameraUIManager.mo18092a(CameraManager.this.mModeManager.m12076g(), CameraManager.this.m10047de());
                    return;
                }
                CameraLog.m12966e("CameraManager", "onCameraShutterButtonLongClickReleased, isTimerSnapShotRunning: " + CameraManager.this.m10312av() + ", isVideoRecording: " + CameraManager.this.mModeManager.m11861aV() + ", mbBurstShot: " + CameraManager.this.f10766av + ", mbPaused: " + CameraManager.this.f10752ah + ", supportBurstShot: " + zM12091j);
                return;
            }
            CameraManager.this.mModeManager.m12135w();
            CameraManager.this.mCameraUIManager.mo18280w();
            LockViewDragLayout.setVolumeDownState(false);
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: OplusGLSurfaceView_15 */
        public void mo10908j() {
            boolean z = CameraManager.this.f10862cn != null && CameraManager.this.f10862cn.m24679c();
            if (!CameraManager.this.f10752ah && ((CameraManager.this.m10222T() || CameraManager.this.mModeManager.m12105n().equals(ApsConstant.REC_MODE_TIMELASPE_PRO)) && CameraManager.this.f10807bk && !CameraManager.this.mModeManager.m12082h() && !CameraManager.this.mCameraUIManager.m19818cU() && CameraManager.this.m10260a(4) && CameraManager.this.m10260a(5) && !CameraManager.this.f10866cr.m11537q() && !CameraManager.this.m10207E() && z)) {
                CameraManager.this.f10932eF.removeMessages(9);
                CameraManager.this.f10703K = 0;
                CameraManager.this.m10395v(true);
                CameraManager.this.mModeManager.m11855aP();
                CameraManager.this.f10953ef = false;
                return;
            }
            CameraLog.m12954a("CameraManager", "onCameraVideoShutterButtonClick, mbPaused: " + CameraManager.this.f10752ah + ", isPreviewStarted: " + CameraManager.this.m10222T() + ", mbInitialized: " + CameraManager.this.f10807bk + ", isCaptureModeType: " + CameraManager.this.mModeManager.m12082h() + ", isEffectMenuScrolling: " + CameraManager.this.mCameraUIManager.m19818cU() + ", isStartSoundLoaded: " + CameraManager.this.m10260a(4) + ", isStopSoundLoaded: " + CameraManager.this.m10260a(5) + ", isBlurAnimRunning: " + CameraManager.this.m10207E() + ", isRingerModeReady:" + z);
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        public void onCameraVideoSnapshotButtonClick() {
            CameraManager.this.m10107g(!r2.f10747ac, false);
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        public void onSwitchCameraButtonClick() {
            if (CameraManager.this.m10222T() && !CameraManager.this.f10762ar && !CameraManager.this.m10312av() && !CameraManager.this.m10349e() && !CameraManager.this.f10760ap && CameraManager.this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.CAMERA) && !CameraManager.this.mCameraUIManager.m19818cU() && !CameraManager.this.mCameraUIManager.m19770bi() && CameraManager.this.f10801be && CameraManager.this.f10807bk && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA) && !CameraManager.this.mModeManager.m11937bh() && CameraManager.this.m10271aG() && !CameraManager.this.m10207E()) {
                if (CameraManager.this.m9961cZ()) {
                    CameraLog.m12954a("CameraManager", "onSwitchCameraButtonClick, interruptSwitchCameraClickEvent");
                    return;
                }
                CameraLog.m12954a("CameraManager", "onSwitchCameraButtonClick");
                int OplusGLSurfaceView_13 = 0;
                if (CameraManager.this.m10268aD() && CameraManager.this.mCameraUIManager.mo18183c().m23491v()) {
                    CameraLog.m12954a("CameraManager", "multi video intercept onSwitchCameraButtonClick");
                    CameraManager.this.mCameraUIManager.mo18183c().m23477k(false);
                    CameraManager.this.m10039da();
                }
                CameraLog.m12952a("onSwitchCameraButtonClick");
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM) && CameraManager.this.f10863co != null) {
                    if (CameraManager.this.mCameraUIManager.mo18159aw()) {
                        CameraManager.this.f10866cr.m11507b(true);
                    }
                    CameraManager.this.f10863co.m14685b();
                } else if (CameraCharacteristicsUtil.m12982e() && CameraManager.this.mCameraUIManager.mo18159aw()) {
                    CameraManager.this.f10866cr.m11507b(true);
                }
                if (!CameraManager.this.m10268aD()) {
                    if (CameraManager.this.m10220R() == 0) {
                        CameraManager.this.mCameraUIManager.m19963i(CameraManager.this.f10849ca.getResources().getString(R.string.camera_description_front_camera));
                        OplusGLSurfaceView_13 = 1;
                    } else {
                        CameraManager.this.mCameraUIManager.m19963i(CameraManager.this.f10849ca.getResources().getString(R.string.camera_description_rear_camera));
                    }
                    if (!CameraManager.this.f10954eg.m16299c()) {
                        CameraManager.this.f10806bj = true;
                    }
                    SharedPreferences.Editor editorEdit = CameraManager.this.f10850cb.edit();
                    editorEdit.putString(CameraUIInterface.KEY_CAMERA_ID, Integer.toString(OplusGLSurfaceView_13));
                    editorEdit.apply();
                }
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m11955bz();
                }
                CameraManager.this.m9588C(1);
                if (CameraManager.this.mCameraUIManager.m19811cN() && CameraManager.this.f10855cg != null && !CameraManager.this.m10268aD()) {
                    CameraManager.this.f10855cg.mo10954b();
                }
                AndroidTestHelper.onButtonReadyToClick(true);
                CameraLog.m12958b("onSwitchCameraButtonClick");
                return;
            }
            CameraLog.m12954a("CameraManager", "onSwitchCameraButtonClick, isPreviewStarted: " + CameraManager.this.m10222T() + ", mbCaptureModeChanging: " + CameraManager.this.f10762ar + ", isTimerSnapShotRunning: " + CameraManager.this.m10312av() + ", isAnimationRunning: " + CameraManager.this.m10349e() + ", mbSwitchingCamera: " + CameraManager.this.f10760ap + ", isAllowSwitch: " + CameraManager.this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.CAMERA) + ", isHeadLineAnimationRunning: " + CameraManager.this.mCameraUIManager.m19770bi() + ", isEffectMenuScrolling: " + CameraManager.this.mCameraUIManager.m19818cU() + ", mbFrameAvailable: " + CameraManager.this.f10801be + ", mbInitialized: " + CameraManager.this.f10807bk + ", support switch: " + CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA) + ", isStickerMenuOpen: " + CameraManager.this.mModeManager.m11937bh() + ", isVideoRecording(): " + CameraManager.this.m10269aE() + ", isBlurAnimRunning: " + CameraManager.this.m10207E());
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: OplusGLSurfaceView_5 */
        public void mo10909k() {
            CameraLog.m12954a("CameraManager", "onSwitchCameraButtonDown");
            CameraLog.m12952a("CameraStartupPerformance.onSwitchCameraButtonDown");
            if (CameraManager.this.f10973ez == null) {
                CameraManager cameraManager = CameraManager.this;
                cameraManager.f10973ez = cameraManager.new C2579g();
            }
            CameraManager.this.mCameraUIManager.m19885dc();
            if (!CameraManager.this.f10760ap && CameraManager.this.m10222T() && !CameraManager.this.f10762ar && !CameraManager.this.m10268aD()) {
                CameraManager.this.m9836bW();
                CameraManager.this.m10221S();
            }
            CameraLog.m12958b("CameraStartupPerformance.onSwitchCameraButtonDown");
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: OplusGLSurfaceView_14 */
        public void mo10910l() {
            CameraLog.m12954a("CameraManager", "onSwitchCameraButtonUp");
            CameraManager.this.mCameraUIManager.m19886dd();
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: OplusGLSurfaceView_6 */
        public boolean mo10911m() {
            if (CameraManager.this.m10222T()) {
                if (CameraManager.this.mModeManager == null) {
                    return false;
                }
                boolean zM11857aR = CameraManager.this.mModeManager.m11857aR();
                if (zM11857aR && CameraManager.this.f10827cE != null && CameraManager.this.f10827cE.m19257b()) {
                    CameraManager.this.f10827cE.m19258c();
                }
                if (zM11857aR && CameraManager.this.f10892dR != null) {
                    CameraManager.this.f10892dR.mo24730a(2, 0L);
                }
                return zM11857aR;
            }
            CameraLog.m12954a("CameraManager", "onVideoRecordingPause, preview not started.");
            return false;
        }

        @Override // com.oplus.camera.p172ui.control.CameraControlButtonListener
        /* renamed from: OplusGLSurfaceView_11 */
        public boolean mo10912n() {
            if (CameraManager.this.m10222T()) {
                if (CameraManager.this.mModeManager == null) {
                    return false;
                }
                boolean zM11858aS = CameraManager.this.mModeManager.m11858aS();
                if (zM11858aS && CameraManager.this.f10892dR != null) {
                    CameraManager.this.f10892dR.mo24730a(3, 0L);
                }
                return zM11858aS;
            }
            CameraLog.m12954a("CameraManager", "onVideoRecordingResume, preview not started.");
            return false;
        }
    };

    /* renamed from: eT */
    private LocationManager.COUIBaseListPopupWindow_12 f10946eT = new LocationManager.COUIBaseListPopupWindow_12() { // from class: com.oplus.camera.CameraManager.64
        @Override // com.oplus.camera.LocationManager.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10913a(Location location, boolean z) {
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m10238a(cameraManager.f10849ca.getApplicationContext(), location, z);
        }
    };

    /* renamed from: eU */
    private WatchAgentContract.PlatformImplementations.kt_3 f10947eU = new WatchAgentContract.PlatformImplementations.kt_3() { // from class: com.oplus.camera.CameraManager.65
        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10914a() {
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.65.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10856ch != null) {
                        CameraManager.this.f10856ch.mo9570p();
                    }
                }
            });
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10917b() {
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.65.2
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10849ca == null || CameraManager.this.f10849ca.isFinishing() || CameraManager.this.m10269aE() || CameraManager.this.f10952ee) {
                        return;
                    }
                    CameraManager.this.f10849ca.finish();
                }
            });
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public GLRootView mo10919c() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.mo18066a();
            }
            return null;
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10915a(Size size) {
            CameraLog.m12954a("CameraManager", "cameraContract.setWatchSize, size: " + size);
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19958h(size.getWidth(), size.getHeight());
            }
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public String mo10920d() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12105n();
            }
            return null;
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10916a(final String str) {
            CameraLog.m12954a("CameraManager", "cameraContract.watchSwitchMode, modeName: " + str);
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.65.3
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10856ch != null) {
                        CameraManager.this.f10856ch.mo9570p();
                    }
                    if (CameraManager.this.mModeManager == null) {
                        return;
                    }
                    if (CameraManager.this.mModeManager.m11832a()) {
                        CameraManager.this.mCameraUIListener.mo10862l(str);
                    } else if (CameraManager.this.isAllowSwitchMode() && !CameraManager.this.mModeManager.m12105n().equals(str)) {
                        CameraManager.this.f10806bj = true;
                        CameraManager.this.mCameraUIListener.mo10862l(str);
                    }
                }
            });
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10918b(final String str) {
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.65.4
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10856ch != null) {
                        CameraManager.this.f10856ch.mo9570p();
                    }
                    if (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m12082h() || !CameraManager.this.mCameraUIManager.m19758bR()) {
                        CameraLog.m12954a("CameraManager", "cameraContract.watchCapture, return");
                        return;
                    }
                    if (CameraManager.this.m10223U() || CameraManager.this.f10982r == 5 || CameraManager.this.f10982r == 4) {
                        CameraLog.m12954a("CameraManager", "cameraContract.watchCapture, mCameraState: " + CameraManager.this.f10982r + ", so return");
                        return;
                    }
                    if (!"off".equals(str)) {
                        CameraManager.this.m10022d(str, true);
                    } else {
                        CameraManager.this.m9905c(!CameraManager.this.f10747ac, false, true);
                    }
                }
            });
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_8 */
        public Size mo10921e() {
            if (CameraManager.this.f10914dn == null) {
                return null;
            }
            return CameraManager.this.f10914dn.m17187a(CameraManager.this.f10853ce);
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_12 */
        public int mo10922f() {
            return CameraManager.this.f10984t;
        }

        @Override // com.oplus.camera.watch.WatchAgentContract.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10923g() {
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.65.5
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12095k() && CameraManager.this.mCameraUIManager.m19758bR()) {
                        if (CameraManager.this.f10856ch != null) {
                            CameraManager.this.f10856ch.mo9570p();
                        }
                        CameraManager.this.mCameraControlButtonListener.mo10906h();
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "cameraContract.watchControlVideoShutter, return");
                }
            });
        }
    };

    /* renamed from: u */
    private int m10180u(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            return 28;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return 29;
        }
        if (OplusGLSurfaceView_13 == 6) {
            return 35;
        }
        if (OplusGLSurfaceView_13 == 19) {
            return 38;
        }
        if (OplusGLSurfaceView_13 == 8) {
            return 33;
        }
        if (OplusGLSurfaceView_13 == 9) {
            return 27;
        }
        if (OplusGLSurfaceView_13 == 22) {
            return 39;
        }
        if (OplusGLSurfaceView_13 == 23) {
            return 30;
        }
        switch (OplusGLSurfaceView_13) {
            case 11:
                return 31;
            case 12:
                return 36;
            case 13:
                return 37;
            case 14:
                return 34;
            case 15:
                return 32;
            default:
                return 0;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static /* synthetic */ long m9898c(CameraManager cameraManager, long OplusGLSurfaceView_15) {
        long j2 = cameraManager.f10745aa + OplusGLSurfaceView_15;
        cameraManager.f10745aa = j2;
        return j2;
    }

    /* renamed from: cq */
    static /* synthetic */ int m9995cq(CameraManager cameraManager) {
        int OplusGLSurfaceView_13 = cameraManager.f10734aP;
        cameraManager.f10734aP = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static /* synthetic */ long m10020d(CameraManager cameraManager, long OplusGLSurfaceView_15) {
        long j2 = cameraManager.f10718Z + OplusGLSurfaceView_15;
        cameraManager.f10718Z = j2;
        return j2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    static /* synthetic */ long m10086e(CameraManager cameraManager, long OplusGLSurfaceView_15) {
        long j2 = cameraManager.f10746ab + OplusGLSurfaceView_15;
        cameraManager.f10746ab = j2;
        return j2;
    }

    /* renamed from: com.oplus.camera.CameraManager$1 */
    class C24971 implements ImageProductProcessor {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f10992b = false;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private RenderScript f10993c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private ScriptIntrinsicYuvToRGB f10994d = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Type.Builder f10995e = null;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private Type.Builder f10996f = null;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private Allocation f10997g = null;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private Allocation f10998h = null;

        C24971() {
        }

        @Override // com.oplus.camera.p136a.ImageProductProcessor
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10406a() {
            this.f10992b = false;
            CameraManager.this.f10905de = null;
            CameraManager.this.f10879dE = System.currentTimeMillis();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m10407a(final Bitmap bitmap) {
            if (bitmap == null) {
                return;
            }
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10752ah || CameraManager.this.f10880dF > CameraManager.this.f10879dE) {
                        return;
                    }
                    CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, false);
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19731b(bitmap);
                        CameraManager.this.m10217O();
                        if (CameraManager.this.m10327b(CameraUIInterface.KEY_GRADIENTER) && "on".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_GRADIENTER, "off"))) {
                            CameraManager.this.mCameraUIManager.m19777bp();
                        }
                    }
                    CameraManager.this.mModeManager.m11895b(12, false);
                    CameraManager.this.f10700H = 0;
                    CameraManager.this.mModeManager.m11895b(5, false);
                    CameraManager.this.f10957ej = false;
                }
            });
        }

        @Override // com.oplus.camera.p136a.ImageProductProcessor
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10408a(Storage.CameraPicture cameraPicture) {
            if (CameraManager.this.f10846cX.m13317J() == 1) {
                CameraLog.m12959b("CameraManager", "onCameraPictureBuilt, uri: " + cameraPicture.f12130c);
                if (CameraManager.this.f10852cd != null) {
                    CameraManager.this.f10852cd.mo13131s();
                }
                if (CameraManager.this.mModeManager != null) {
                    cameraPicture.f12123U = CameraManager.this.mModeManager.m11972cG();
                }
                if (Util.m24495t()) {
                    CameraLog.m12959b("CameraManager", "onCameraPictureBuilt, needUpdateGalleryPreview");
                    cameraPicture.f12117O = new GalleryPreviewUpdateCallback() { // from class: com.oplus.camera.CameraManager.1.2
                        @Override // com.oplus.camera.screen.GalleryPreviewUpdateCallback
                        /* renamed from: PlatformImplementations.kt_3 */
                        public void mo10409a(String str) {
                            if (CameraManager.this.mCameraUIManager != null) {
                                CameraManager.this.mCameraUIManager.m19954f(str, false);
                            }
                        }
                    };
                }
                cameraPicture.f12124V = CameraManager.this.f10938eL;
                ImageSaverThread.m14696a().m14707c(cameraPicture);
                return;
            }
            m10405b(cameraPicture);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m10405b(final Storage.CameraPicture cameraPicture) {
            if (CameraManager.this.f10752ah || CameraManager.this.f10852cd == null) {
                return;
            }
            if (CameraManager.this.f10880dF > CameraManager.this.f10879dE) {
                CameraLog.m12967f("CameraManager", "processInThirdApp, mThirdPartyPauseTime: " + CameraManager.this.f10880dF + ", mThirdPartyCaptureTime: " + CameraManager.this.f10879dE);
                return;
            }
            CameraManager.this.f10905de = cameraPicture.f12132e;
            CameraLog.m12954a("CameraManager", "processInThirdApp, size: " + (CameraManager.this.f10905de.length / 1024) + "KB, width x height: " + cameraPicture.f12142o + " x " + cameraPicture.f12143p);
            if (CameraManager.this.f10796bZ.block(20L)) {
                CameraManager.this.m9834bV();
            } else {
                CameraLog.m12954a("CameraManager", "processInThirdApp, mWriteThirdImageLock blocked, can't save new Image");
            }
            if (this.f10992b) {
                CameraManager.this.f10852cd.mo13069b("off");
                CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                if (CameraManager.this.m9940cO()) {
                    CameraManager.this.f10852cd.mo13094g();
                }
                CameraManager.this.f10932eF.post(new Runnable() { // from class: com.oplus.camera.CameraManager.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraManager.this.m10367j(0);
                    }
                });
                return;
            }
            final int OplusGLSurfaceView_13 = -CameraManager.this.f10988x;
            new Thread(new Runnable() { // from class: com.oplus.camera.CameraManager.1.4
                @Override // java.lang.Runnable
                public void run() {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    if (cameraPicture.f12142o * cameraPicture.f12143p >= Integer.valueOf(BaseMode.PICTURE_SIZE_8M).intValue()) {
                        options.inSampleSize = Math.round(Math.min(cameraPicture.f12142o, cameraPicture.f12143p) / Util.getScreenWidth());
                    }
                    if (options.inSampleSize < 1) {
                        options.inSampleSize = 1;
                    }
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(cameraPicture.f12132e, 0, cameraPicture.f12132e.length, options);
                    int i2 = OplusGLSurfaceView_13;
                    if (i2 != 0) {
                        bitmapDecodeByteArray = Util.m24222a(bitmapDecodeByteArray, i2, false);
                    }
                    if (CameraManager.this.f10892dR != null && cameraPicture.f12127Y) {
                        CameraManager.this.f10892dR.mo24731a(2, bitmapDecodeByteArray);
                    }
                    C24971.this.m10407a(bitmapDecodeByteArray);
                    CameraManager.this.f10852cd.mo13069b("off");
                    CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                    CameraManager.this.f10932eF.post(new Runnable() { // from class: com.oplus.camera.CameraManager.1.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraManager.this.m10367j(0);
                        }
                    });
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bd */
    public void m9848bd() {
        if (this.f10752ah) {
            return;
        }
        this.f10932eF.removeMessages(20);
        if (this.f10849ca != null) {
            this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.34
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10847cY != null && CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.mo18094a(CameraManager.this.f10847cY, 2);
                        CameraManager.this.mCameraUIManager.m19954f((String) null, true);
                    }
                    if (CameraManager.this.f10848cZ != null) {
                        CameraManager.this.f10848cZ.clear();
                        CameraManager.this.f10848cZ = null;
                    }
                    CameraManager.this.f10847cY = null;
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10229a() {
        CameraLog.m12954a("CameraManager", "onStop");
        if (this.mModeManager != null) {
            this.mModeManager.m12115p(false);
            this.mModeManager.m11874ai();
        }
        ScreenModeManager c2953g = this.f10890dP;
        if (c2953g != null) {
            c2953g.m16666f();
        }
        m9968cc();
        m10157p(1);
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19779br();
            if (m10268aD() && this.mCameraUIManager.mo18183c() != null) {
                this.mCameraUIManager.mo18183c().m23477k(false);
            }
        }
        if (this.f10846cX.m13317J() == 2) {
            m9926cH();
        }
        if (!this.f10802bf || this.f10804bh) {
            return;
        }
        try {
            Thread.sleep(50L);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: be */
    public void m9851be() {
        if (this.f10723aE || this.mModeManager == null || this.mCameraUIManager == null) {
            return;
        }
        this.f10723aE = true;
        this.mCameraUIManager.m19789c(this.f10989y, this.mModeManager.m11947br(), true ^ this.mModeManager.m11953bx());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10252a(String str) {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19986x(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m10317b() {
        if (this.mCameraUIManager == null || this.mModeManager == null || this.mModeManager.m11832a()) {
            return;
        }
        this.mCameraUIManager.m19991z(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bf */
    public void m9852bf() {
        CameraLog.m12954a("CameraManager", "resetBurstShot");
        this.f10852cd.mo13143w();
        if (this.mModeManager != null) {
            this.mModeManager.m12078g(false);
            if (this.f10875dA) {
                this.mModeManager.m12081h(true);
            }
        }
        this.f10737aS = "";
        this.f10736aR = -1L;
        m9848bd();
        if (this.mModeManager != null) {
            this.mModeManager.m12115p(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9673a(Image image) {
        if (image != null) {
            TeleSmallPreviewManager c3431ab = this.f10869cu;
            if (c3431ab != null && c3431ab.m22999a()) {
                this.f10869cu.m22998a(false, true, false);
            } else {
                TeleSmallPreviewManager c3431ab2 = this.f10869cu;
                if (c3431ab2 != null && this.f10777bG && !this.f10780bJ) {
                    int iM22993a = c3431ab2.m22993a(image);
                    if (this.f10779bI) {
                        CameraLog.m12959b("CameraManager", "onTeleSmallPreviewReceived, showTeleSmallPreview");
                        this.f10869cu.m22998a(true, true, false);
                        this.f10779bI = false;
                    } else if (iM22993a >= 1) {
                        if (!this.f10869cu.m23003b()) {
                            this.f10869cu.m22998a(true, true, false);
                        }
                        this.f10869cu.m23004c();
                    }
                } else if ((!this.f10777bG && !this.f10779bI) || this.f10780bJ) {
                    this.f10779bI = true;
                    this.f10780bJ = false;
                }
            }
            image.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:121:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c1  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m9774b(android.media.Image r30) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.CameraManager.m9774b(android.media.Image):void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Size m9767b(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 >= i2) {
            int i3 = (OplusGLSurfaceView_13 * 384) / i2;
            if (i3 % 2 != 0) {
                i3++;
            }
            return new Size(i3, 384);
        }
        int i4 = (i2 * 384) / OplusGLSurfaceView_13;
        if (i4 % 2 != 0) {
            i4++;
        }
        return new Size(384, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9703a(byte[] bArr, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        if (this.f10874cz != null) {
            this.f10874cz.m17982a(bArr, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15);
        }
    }

    public CameraManager(Activity activity, CameraManagerInterface interfaceC2703f) {
        this.mModeManager = null;
        this.f10824cB = null;
        this.f10954eg = null;
        this.f10849ca = activity;
        this.f10856ch = interfaceC2703f;
        this.mModeManager = new ModeManager(activity);
        this.f10824cB = new SensorManagerClient(MyApplication.m11092d());
        this.f10824cB.m11263a(this.f10934eH);
        this.f10954eg = new MagShellResponseStatus();
    }

    /* renamed from: bg_renamed */
    private boolean m9855bg() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && "video_size_4kuhd".equals(this.f10850cb.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, this.f10989y))) && 60 == Integer.valueOf(this.f10850cb.getString(CameraUIInterface.KEY_VIDEO_FPS, this.f10849ca.getString(R.string.camera_video_default_fps))).intValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10247a(ComboPreferences comboPreferences, CameraEntry c2701b, boolean z) {
        CameraLog.m12952a("CameraManager.init");
        this.f10850cb = comboPreferences;
        this.f10846cX = c2701b;
        this.f10895dU = z;
        this.f10888dN = new TemperatureProvider(this.f10849ca.getApplicationContext(), this.f10850cb, this.f10940eN);
        this.f10890dP = new ScreenModeManager(this.f10849ca);
        this.f10889dO = this.f10890dP.m16669j();
        this.f10890dP.m16663c(this.f10846cX.m13317J());
        m10178t(this.f10846cX.m13350m());
        Application application = this.f10849ca.getApplication();
        if (application instanceof MyApplication) {
            ((MyApplication) application).m11104i();
        }
        BackgroundUtil.f23060a = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_WITH_HARDWARE_LINE);
        if (!m9988cm() || this.f10846cX.m13325R() || this.f10846cX.m13359w() || this.f10846cX.m13351n()) {
            m10297ag();
            if (m9965cb() && !m9988cm() && this.f10850cb.getInt(CameraUIInterface.KEY_CAMERA_PID_HISTORY, 0) != 0) {
                this.f10850cb.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
            }
        }
        this.f10913dm = new C2586n();
        if (this.f10846cX.m13339c()) {
            m10053dh();
            this.mModeManager.m12137w(false);
        }
        m10090e(m10305ao());
        m9857bh();
        if (z) {
            m10374l(0);
        }
        m9868bn();
        if (Util.m24342ae()) {
            m9867bm();
        }
        this.f10851cc = application.getSharedPreferences("rom_update_info", 0);
        try {
            this.f10981q = PowerManagerNative.getMaximumScreenBrightnessSetting((PowerManager) application.getSystemService("power"));
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f10914dn = new ModeFacade(this.mModeManager, this.f10913dm);
        this.f10917dq = new OtaUpdateManager(this.f10850cb);
        this.f10775bE = false;
        this.f10776bF = false;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
            this.f10915do = new SoloopManager(this.f10849ca);
        }
        CameraLog.m12958b("CameraManager.init");
    }

    /* renamed from: bh */
    private void m9857bh() {
        if (this.f10846cX.m13355s()) {
            if (Util.m24394b(ApsConstant.CAPTURE_MODE_COMMON, false) && Float.compare(ZoomManager.f12334a, this.f10846cX.m13357u()) == 0) {
                m10359g(true);
                this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                m10359g(false);
            } else {
                m10359g(true);
                this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                m10359g(false);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m10090e(String str) {
        if ("portrait".equals(str)) {
            FilterHelper.f21279a = this.f10747ac ? FilterHelper.m22643q() : FilterHelper.m22642p();
        } else if (ApsConstant.REC_MODE_COMMON.equals(str)) {
            FilterHelper.f21279a = this.f10747ac ? FilterHelper.m22646t() : FilterHelper.m22644r();
        } else {
            FilterHelper.f21279a = 0;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m10333c() {
        CameraLog.m12959b("CameraManager", "onScreenOffWhenLocked");
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13048a(false);
        }
        m10323b(false, true);
        if (this.mModeManager != null) {
            this.mModeManager.m11856aQ();
        }
        if (this.mModeManager == null || !this.mModeManager.m11865aZ()) {
            return;
        }
        this.f10932eF.removeMessages(16);
        this.f10932eF.sendEmptyMessage(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m10152o(int OplusGLSurfaceView_13) {
        if (this.f10841cS != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.arg1 = OplusGLSurfaceView_13;
            this.f10841cS.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m10157p(int OplusGLSurfaceView_13) {
        if (this.f10841cS != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.arg1 = OplusGLSurfaceView_13;
            this.f10841cS.sendMessage(messageObtain);
        }
    }

    /* renamed from: bi */
    private void m9858bi() {
        Handler handler = this.f10841cS;
        if (handler != null) {
            handler.removeMessages(5);
            this.f10841cS.sendEmptyMessage(5);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m10342d() {
        if (this.f10824cB != null) {
            return this.f10824cB.m11266b();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bj */
    public boolean m9861bj() {
        return 1 == this.f10846cX.m13317J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9671a(final long OplusGLSurfaceView_15, String str, boolean z, final boolean z2, boolean z3) {
        CameraLog.m12959b("CameraManager", "addEmptyThumbnail, identity: " + OplusGLSurfaceView_15 + ", jpegName: " + str + ", isUpdateThumbnail: " + z + ", watchRequest: " + z2 + ", burstShot: " + z3);
        if (this.mModeManager == null) {
            CameraLog.m12967f("CameraManager", "addEmptyThumbnail, mModeManager is null");
            return;
        }
        ThumbnailItem thumbnailItem = new ThumbnailItem();
        thumbnailItem.mUri = null;
        thumbnailItem.mResolver = this.f10849ca.getContentResolver();
        thumbnailItem.mPictureFormat = (this.mModeManager.m11929bZ() == null || this.f10734aP != 0) ? CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG : this.mModeManager.m11929bZ();
        thumbnailItem.mThumbBitmap = null;
        thumbnailItem.mIdentity = OplusGLSurfaceView_15;
        thumbnailItem.mProductProcessor = this.f10969ev;
        thumbnailItem.mbLockScreen = m10303am();
        thumbnailItem.mJpegName = str;
        thumbnailItem.mDate = this.mModeManager.m12043dc();
        thumbnailItem.mbBurstShot = z3;
        final int iHashCode = this.f10849ca.hashCode();
        if ((z || this.mModeManager.m11926bW() || this.mModeManager.m11927bX()) && !z3) {
            thumbnailItem.mThumbnailWidth = this.mCameraUIManager.m19746bF();
            thumbnailItem.mCameraUiUpdateThumbnail = new Thumbnail.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.CameraManager.76
                @Override // com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo10413a(final Thumbnail c3203e) {
                    if (CameraManager.this.f10849ca == null) {
                        return;
                    }
                    CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.76.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long jM12062dv = CameraManager.this.mModeManager != null ? CameraManager.this.mModeManager.m12062dv() : 0L;
                            boolean z4 = CameraManager.this.f10849ca == null || (iHashCode != CameraManager.this.f10849ca.hashCode() && CameraManager.this.m10303am());
                            if (CameraManager.this.mCameraUIManager != null && OplusGLSurfaceView_15 >= jM12062dv && !z4) {
                                CameraManager.this.mCameraUIManager.m19678a(c3203e);
                            }
                            if (CameraManager.this.mModeManager != null && OplusGLSurfaceView_15 == jM12062dv) {
                                CameraManager.this.mModeManager.m11831a(null, 0, 0, 256, false, 0);
                            }
                            if (CameraManager.this.f10892dR == null || !z2) {
                                return;
                            }
                            CameraManager.this.f10892dR.mo24731a(2, c3203e.m19294h());
                        }
                    });
                }
            };
        }
        ApsService apsService = this.f10876dB;
        if (apsService != null) {
            apsService.addThumbnailInfo(thumbnailItem);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONLY_HIGH_PICTURE_SIZE_HEIF_IN_APS)) {
                if (("heic_8bits".equalsIgnoreCase(thumbnailItem.mPictureFormat) || "heic_10bits".equalsIgnoreCase(thumbnailItem.mPictureFormat)) && !this.mModeManager.m11917bN()) {
                    this.f10852cd.mo13083d(thumbnailItem.mIdentity);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10253a(boolean z) {
        CameraLog.m12954a("CameraManager", "setCaptureThumbnailUpdated: " + this.f10726aH + "->" + z);
        this.f10726aH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bk */
    public boolean m9863bk() {
        return 3 == this.f10846cX.m13317J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public LocationManager.PlatformImplementations.kt_3 m9865bl() {
        if (!this.f10923dw) {
            return null;
        }
        if (LocationManager.m16155a() != null && "on".equals(LocationManager.m16155a().m16182e()) && LocationManager.m16155a().m16183f()) {
            return this.f10837cO;
        }
        return this.f10835cM;
    }

    /* renamed from: bm */
    private void m9867bm() {
        if (this.f10967et == null) {
            this.f10968eu = new HandlerThread("JavaHeapHandlerThread");
            this.f10968eu.start();
            this.f10967et = new Handler(this.f10842cT.getLooper()) { // from class: com.oplus.camera.CameraManager.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    CameraLog.m12954a("CameraManager", "initJavaHeapHandlerThread, handleMessage, what: " + message.what);
                }
            };
        }
    }

    /* renamed from: bn */
    private void m9868bn() {
        synchronized (this.f10792bV) {
            if (this.f10841cS == null) {
                this.f10842cT = new HandlerThread("CameraHandlerThread");
                this.f10842cT.start();
                this.f10841cS = new Handler(this.f10842cT.getLooper()) { // from class: com.oplus.camera.CameraManager.3
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        CameraLog.m12954a("CameraManager", "initHandlerThread, handleMessage, what: " + message.what);
                        switch (message.what) {
                            case 1:
                                CameraManager.this.m9872bp().openCabc();
                                break;
                            case 2:
                                CameraManager.this.m9872bp().closeCabc();
                                break;
                            case 3:
                                int OplusGLSurfaceView_13 = message.arg1;
                                if ((OplusGLSurfaceView_13 & 2) != 0) {
                                    CameraManager.this.f10954eg.m16300d(true);
                                }
                                if (CameraManager.this.f10824cB != null) {
                                    CameraManager.this.f10824cB.m11264a(CameraManager.this.f10933eG);
                                    CameraManager.this.f10824cB.m11262a(OplusGLSurfaceView_13);
                                    break;
                                }
                                break;
                            case 4:
                                int i2 = message.arg1;
                                if ((i2 & 2) != 0) {
                                    CameraManager.this.f10954eg.m16300d(false);
                                }
                                if (CameraManager.this.f10824cB != null) {
                                    CameraManager.this.f10824cB.m11265b(i2);
                                    break;
                                }
                                break;
                            case 5:
                                if (CameraManager.this.f10824cB != null) {
                                    CameraManager.this.f10824cB.m11267c();
                                    CameraManager.this.f10824cB = null;
                                    break;
                                }
                                break;
                            case 6:
                                CameraManager.this.m9803bF();
                                break;
                        }
                        CameraLog.m12954a("CameraManager", "initHandlerThread, handleMessage mWorkThreadHandler X");
                    }
                };
            }
        }
    }

    /* renamed from: bo */
    private void m9870bo() {
        if (this.f10885dK == null) {
            HandlerThread handlerThread = new HandlerThread("PreviewProcessThread");
            handlerThread.start();
            this.f10885dK = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.CameraManager.4
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    CameraLog.m12954a("CameraManager", "PreviewProcessThread, handleMessage, what: " + message.what);
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 == 1) {
                        if (CameraManager.this.f10907dg != null) {
                            CameraManager.this.f10907dg.m14788a((byte[]) message.obj, CameraManager.this.f10989y, CameraManager.this.f10984t);
                            return;
                        }
                        return;
                    }
                    if (OplusGLSurfaceView_13 == 2) {
                        if (CameraManager.this.f10864cp != null) {
                            CameraManager.this.f10864cp.mo22805a((byte[]) message.obj, message.arg1, message.arg2, 1);
                        }
                    } else {
                        if (OplusGLSurfaceView_13 != 3) {
                            if (OplusGLSurfaceView_13 == 4 && CameraManager.this.f10908dh != null) {
                                boolean zM9891by = CameraManager.this.m9891by();
                                CameraManager.this.f10908dh.m11216c(zM9891by);
                                if (!zM9891by || CameraManager.this.mCameraUIManager.m19767bf()) {
                                    return;
                                }
                                CameraManager.this.f10908dh.m11211a((byte[]) message.obj, null, null, message.arg1, message.arg2);
                                return;
                            }
                            return;
                        }
                        if (CameraManager.this.f10864cp != null) {
                            CameraManager.this.f10864cp.mo22805a((byte[]) message.obj, message.arg1, message.arg2, 16);
                        }
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bp */
    public CabcManager m9872bp() {
        if (this.f10838cP == null) {
            this.f10838cP = CabcManager.getCabcManagerInstance();
        }
        return this.f10838cP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bq */
    public void m9875bq() {
        Handler handler = this.f10841cS;
        if (handler != null) {
            handler.removeMessages(2);
            this.f10841cS.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: br */
    public void m9877br() {
        Handler handler = this.f10841cS;
        if (handler != null) {
            handler.removeMessages(1);
            this.f10841cS.sendEmptyMessage(1);
        }
    }

    /* renamed from: bs */
    private void m9879bs() {
        HandlerThread handlerThread = this.f10842cT;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        Handler handler = this.f10885dK;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f10885dK = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m10349e() {
        C2582j c2582j = this.f10929eC;
        if (c2582j != null) {
            return c2582j.m11000d();
        }
        return false;
    }

    /* renamed from: bt */
    private void m9880bt() {
        Bundle extras;
        this.f10862cn = new OplusPlaySound(this.f10849ca.getApplicationContext());
        this.f10862cn.m24675a();
        m9668a(96, false);
        if (this.f10846cX.m13317J() == 2 && (extras = this.f10849ca.getIntent().getExtras()) != null) {
            try {
                this.f10843cU = (Uri) extras.getParcelable("output");
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            try {
                this.f10784bN = extras.getString("crop");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.mModeManager.m12097l(this.f10744aZ);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m10260a(int OplusGLSurfaceView_13) {
        if (this.f10862cn != null) {
            return this.f10862cn.m24676a(OplusGLSurfaceView_13);
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m10351f() {
        if (this.f10852cd == null || this.f10760ap || this.mModeManager.m11859aT() || this.mModeManager.m12027dD()) {
            return;
        }
        this.f10852cd.mo13082d(this.mModeManager.m11786R());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10235a(int OplusGLSurfaceView_13, RectF rectF, RectF rectF2) {
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13025a(OplusGLSurfaceView_13, rectF, rectF2, true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m10356g() {
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            return interfaceC2694d.mo13122p();
        }
        return this.mModeManager.m11786R();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10234a(int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f10977m) {
            if (this.f10697E == null) {
                this.f10697E = new int[2];
            }
            this.f10697E[0] = OplusGLSurfaceView_13;
            this.f10697E[1] = i2;
            this.f10698F = null;
        }
        this.mModeManager.m12112p();
        m10164q(m9883bu());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10255a(boolean z, int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f10977m) {
            if (z) {
                if (this.f10697E == null) {
                    this.f10697E = new int[2];
                }
                this.f10697E[0] = OplusGLSurfaceView_13;
                this.f10697E[1] = i2;
            } else {
                if (this.f10698F == null) {
                    this.f10698F = new int[2];
                }
                this.f10698F[0] = OplusGLSurfaceView_13;
                this.f10698F[1] = i2;
            }
        }
        m10164q(FocusAimMsgData.KEY_SEPARATE_METERING_FOCUS);
    }

    /* renamed from: bu */
    private String m9883bu() {
        int OplusGLSurfaceView_13 = this.f10755ak;
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? "1" : "3" : "7" : "1";
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m10360h() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraManager.this.f10977m) {
                    CameraManager.this.f10697E = null;
                    CameraManager.this.f10698F = null;
                }
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m10319b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "playSound, cameraSound: " + OplusGLSurfaceView_13);
        if (this.f10862cn == null || !"on".equals(this.f10785bO)) {
            return;
        }
        this.f10862cn.m24678b(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m10363i() {
        if (this.f10808bl || this.f10852cd == null) {
            CameraLog.m12954a("CameraManager", "initializeFirstTime, mOneCamera: " + this.f10852cd + ", mbFirstTimeInitialized: " + this.f10808bl);
            return;
        }
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CameraManager.this.mModeManager.m11888aw();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        }, "initBaseModeMap");
        this.f10709Q = this.f10849ca.getResources().getDimensionPixelSize(R.dimen.video_tracking_focus_distance_between_two_points);
        this.f10694B = this.f10849ca.getResources().getDimensionPixelSize(R.dimen.switch_mode_distance_limit);
        this.f10695C = this.f10849ca.getResources().getDimensionPixelSize(R.dimen.switch_mode_distance_limit_min);
        this.f10696D = this.f10849ca.getResources().getDimensionPixelSize(R.dimen.switch_mode_velocity_limit);
        Size sizeM11796a = this.mModeManager.m11796a(this.f10853ce);
        Util.m24386b(sizeM11796a);
        m10163q(Util.m24426d(sizeM11796a.getWidth(), sizeM11796a.getHeight()));
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19825cb();
            if (this.mCameraUIManager.m19834ck() != null) {
                m9851be();
            }
        }
        this.f10750af = false;
        m9804bG();
        m9956cW();
        ImageSaverThread.m14696a().m14708d();
        ImageSaverThread.m14696a().m14706a(new C2591s(this));
        this.f10807bk = true;
        this.f10808bl = true;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m10366j() {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19869dM();
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$s */
    private static class C2591s implements ProcessQueueThread.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private WeakReference<CameraManager> f11204a;

        C2591s(CameraManager cameraManager) {
            this.f11204a = null;
            this.f11204a = new WeakReference<>(cameraManager);
        }

        @Override // com.oplus.camera.p154m.ProcessQueueThread.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11041a() {
            CameraManager cameraManager;
            WeakReference<CameraManager> weakReference = this.f11204a;
            if (weakReference == null || (cameraManager = weakReference.get()) == null) {
                return;
            }
            cameraManager.m10366j();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m10369k() {
        if (this.f10852cd == null) {
            CameraLog.m12954a("CameraManager", "initializeSecondTime, mOneCamera: " + this.f10852cd);
            return;
        }
        Size sizeM11796a = this.mModeManager.m11796a(this.f10853ce);
        Util.m24386b(sizeM11796a);
        m10163q(Util.m24426d(sizeM11796a.getWidth(), sizeM11796a.getHeight()));
        Storage.m11111a(this.f10849ca.getApplicationContext());
        this.mCameraUIManager.m19734b(this.mModeManager.m12076g());
        if (!this.mCameraUIManager.m19771bj()) {
            this.mCameraUIManager.mo18213f(true, false);
        }
        this.mCameraUIManager.m19789c(this.f10989y, this.mModeManager.m11947br(), !this.mModeManager.m11953bx());
        this.f10750af = false;
        m9804bG();
        m9956cW();
        ImageSaverThread.m14696a().m14708d();
        if (this.mModeManager.m12091j(CameraUIInterface.KEY_FILTER_PROCESS)) {
            this.mModeManager.m11821a(this.mCameraUIManager.mo18038I());
        }
        this.f10807bk = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10254a(boolean z, int OplusGLSurfaceView_13) {
        if (this.f10752ah) {
            return;
        }
        if (this.f10799bc || z) {
            CameraLog.m12954a("CameraManager", "notifyFirstFrame, sendBroadcast com.oplus.camera.start notifyFirstFrame");
        }
        m10322b(false, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m10322b(boolean z, int OplusGLSurfaceView_13) {
        if (this.f10752ah) {
            CameraLog.m12954a("CameraManager", "onPreviewOk, mbPaused: " + this.f10752ah);
            return;
        }
        CameraLog.m12952a("onPreviewOk: " + z);
        if (z && !this.f10801be) {
            this.f10801be = true;
            CameraLog.m12967f("CameraManager", "CameraTest Displayed com.oplus.camera");
            if (!this.f10799bc) {
                m10334c(OplusGLSurfaceView_13);
            }
            CameraLog.m12958b("onPreviewOk: " + z);
            return;
        }
        if (!this.f10799bc) {
            m10389s(true);
            CameraLog.m12954a("CameraManager", "onPreviewOk, mbDisplayOnLock: " + this.f10744aZ);
            this.f10856ch.mo9570p();
            m10334c(OplusGLSurfaceView_13);
        }
        CameraLog.m12958b("onPreviewOk: " + z);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m10334c(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "onPreviewOKMessage");
        if (this.f10799bc) {
            CameraLog.m12954a("CameraManager", "onPreviewOKMessage, mbPreviewOKMessageEnd is true, so return");
            return;
        }
        CameraLog.m12952a("onPreviewOKMessage");
        this.f10799bc = true;
        m9880bt();
        m10152o(1);
        m10298ah();
        this.f10856ch.mo9568n();
        if (!this.f10808bl) {
            m10363i();
        } else {
            m10369k();
        }
        CallGalleryPreDecodeThread.m14689a().m14708d();
        this.mCameraUIManager.m19765bY();
        if (this.f10866cr != null) {
            this.f10866cr.m11513d(this.f10927eA);
        }
        this.mCameraUIManager.m19825cb();
        m10256a(false, OplusGLSurfaceView_13, (String) null);
        if (m10303am()) {
            this.f10921du = false;
        }
        Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.oplus.camera.CameraManager.7
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                CameraLog.m12952a("onMessageQueueIdle");
                CameraManager.this.m10001ct();
                CameraLog.m12958b("onMessageQueueIdle");
                return false;
            }
        });
        CameraLog.m12958b("onPreviewOKMessage");
        CameraLog.m12954a("CameraManager", "onPreviewOKMessage X");
        if (Util.m24342ae()) {
            if (this.f10966es == null) {
                this.f10966es = new Runnable() { // from class: com.oplus.camera.CameraManager.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Runtime runtime = Runtime.getRuntime();
                        String shortFileSize = Formatter.formatShortFileSize(CameraManager.this.f10849ca, runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory()));
                        String str = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
                        if (CameraManager.this.f10967et != null) {
                            CameraManager.this.f10967et.postDelayed(this, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                        }
                        CameraLog.m12967f("CameraManager", "Available Java Heap Size : " + shortFileSize + ", catch time: " + str);
                    }
                };
            }
            Handler handler = this.f10967et;
            if (handler != null) {
                handler.postDelayed(this.f10966es, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
        }
    }

    /* renamed from: bv */
    private void m9884bv() {
        ImageStickerTools.m22687b(this.f10849ca).m22711a((Context) this.f10849ca);
        if (RegionCommonFeatureAdapter.m14534c() || this.f10850cb.getBoolean("pref_allow_network_access", false)) {
            ImageStickerTools.m22687b(this.f10849ca).m22724f();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10256a(boolean z, int OplusGLSurfaceView_13, String str) {
        CameraLog.m12954a("CameraManager", "afterStartPreview, mbFrameAvailable: " + this.f10801be + ", mbPaused: " + this.f10752ah + ", cameraRole: " + OplusGLSurfaceView_13 + ", fromAsync: " + z + ", captureMode: " + str);
        CameraLog.m12952a("afterStartPreview");
        if (1 == OplusGLSurfaceView_13) {
            m9608I(z);
        }
        m9970cd();
        if (this.f10752ah) {
            return;
        }
        int i2 = this.f10703K;
        if ((i2 == 0 || 2 == i2) && 1 == this.f10846cX.m13317J() && this.mModeManager.m12091j(CameraUIInterface.KEY_SETTING_MENU) && z) {
            ScreenModeManager c2953g = this.f10890dP;
            if (c2953g == null || 1 != c2953g.mo16411a().mo16539j()) {
                if (this.mCameraUIManager.m19762bV()) {
                    this.mCameraUIManager.m19649a(1.0f, true, 180L);
                } else {
                    this.mCameraUIManager.m19910e(1.0f);
                }
            }
        }
        if (TextUtils.equals(str, Util.m24475l(this.f10914dn.m17207i())) && (!m10268aD() || 1 == OplusGLSurfaceView_13)) {
            this.f10914dn.m17192a(z);
        }
        if (this.mModeManager.m12091j(CameraUIInterface.KEY_STICKER_PROCESS)) {
            this.f10844cV = ImageStickerTools.m22687b(this.f10849ca).m22706a(this.f10850cb);
        }
        this.mCameraUIManager.m19710ai(m10047de() && !this.mCameraUIManager.mo18057R());
        if (!this.f10762ar) {
            this.mCameraUIManager.mo18190c(true);
            this.mCameraUIManager.mo18279v(true);
            m10398w(true);
        }
        m9904c(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, this.f10850cb.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false));
        this.mCameraUIManager.m19689a(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, this.f10850cb.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false), true);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            this.f10700H = 0;
            this.mCameraUIManager.m19908dz();
            this.mCameraUIManager.m19903du();
        }
        this.mCameraUIManager.mo18067a(R.string.camera_ai_scn_microspur);
        this.mCameraUIManager.mo18067a(R.string.micro_lens_mode_toast);
        m9886bw();
        this.mCameraUIManager.m19644Z(z);
        if (z) {
            m9888bx();
        }
        CameraLog.m12958b("afterStartPreview");
    }

    /* renamed from: bw */
    private void m9886bw() {
        CameraUIListener cameraUIListener = this.mCameraUIListener;
        if (cameraUIListener == null || !m10327b(cameraUIListener.mo10700aE())) {
            return;
        }
        this.mCameraUIManager.mo18106a(this.mCameraUIManager.mo18023A(), this.mCameraUIListener.mo10700aE());
    }

    /* renamed from: bx */
    private void m9888bx() {
        if (this.f10846cX.m13360x() && this.mModeManager.m12082h()) {
            if (Util.m24287a(this.f10849ca, Camera.f10609k) || !this.f10850cb.getBoolean("pref_runtime_alert_first_show", true)) {
                this.f10932eF.removeMessages(22);
                this.f10932eF.sendEmptyMessageDelayed(22, 500L);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m10373l() {
        return "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.f10849ca.getString(R.string.camera_gesture_shutter_default_value))) && this.mModeManager.m12091j(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10257a(boolean z, boolean z2) {
        if (z) {
            this.mCameraUIManager.m19804cG();
        }
        if (z2) {
            this.mCameraUIManager.m19705ad(this.f10919ds);
            this.f10919ds = false;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_GESTURE_DETECT_IN_APS)) {
            return;
        }
        if (this.f10907dg == null) {
            this.f10907dg = new GestureEngineManager();
        }
        Size sizeM11796a = this.mModeManager.m11796a(this.f10853ce);
        this.f10907dg.m14785a(this.f10849ca.getApplicationContext(), sizeM11796a.getWidth(), sizeM11796a.getHeight());
        this.f10907dg.m14786a(this.f10972ey);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m10375m() {
        if (this.f10908dh == null) {
            this.f10908dh = new QrCodeManager(this.f10849ca, this.f10850cb, this.f10939eM, this.f10981q);
        }
        if (this.mCameraUIManager != null) {
            this.f10908dh.m11209a(this.mCameraUIManager.mo18163b(), this.f10984t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: by */
    public boolean m9891by() {
        QrCodeManager viewOnClickListenerC2609aa = this.f10908dh;
        return (viewOnClickListenerC2609aa == null || viewOnClickListenerC2609aa.m11225j() || this.mCameraUIManager == null || this.mCameraUIManager.m19864dH() || this.mCameraUIManager.mo18043K() || this.mCameraUIManager.m19940en() || this.f10762ar || !m10222T() || this.f10752ah || m10269aE() || m10349e() || m10207E() || m10278aN() || !this.f10801be || (this.f10826cD != null && this.f10826cD.m19331d())) ? false : true;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m10380n() {
        return this.mModeManager != null && this.mModeManager.m11968cC();
    }

    /* renamed from: o */
    public void m10381o() {
        if (this.f10907dg != null) {
            this.f10907dg.close();
        }
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.mo18067a(R.string.camera_toast_gesture_take_picture);
            this.mCameraUIManager.mo18174b(true);
        }
    }

    /* renamed from: p */
    public boolean m10384p() {
        return this.f10907dg != null && m10327b(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) && this.f10907dg.m14790b();
    }

    /* renamed from: q */
    public boolean m10386q() {
        if (this.f10907dg != null) {
            return this.f10907dg.m14789a();
        }
        return this.f10749ae;
    }

    /* renamed from: r */
    public void m10387r() {
        if (this.mCameraUIManager != null && ((this.mCameraUIManager.m19759bS() || m9861bj()) && (!this.f10747ac || (Util.m24320aI() && this.f10954eg.m16295a())))) {
            this.mCameraUIManager.mo18070a(R.string.camera_high_temperature_flash_disable, -1, true, false, false);
            Camera.f10613o = false;
            m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_FLASH);
            return;
        }
        Camera.f10613o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bz */
    public void m9893bz() {
        m10023d(this.f10850cb);
        if (m10327b(CameraFunction.TORCH_SOFT_LIGHT)) {
            m10091e(this.f10850cb.m11072a(this.f10849ca, 1));
        }
        m9795bB();
        m10387r();
    }

    /* renamed from: s */
    public boolean m10390s() {
        if (this.mCameraUIManager != null && this.mCameraUIManager.m19759bS() && !m10327b(CameraUIInterface.KEY_TIME_LAPSE_PRO) && ((!this.f10747ac || (Util.m24320aI() && this.f10954eg.m16295a())) && (m10327b(CameraUIInterface.KEY_FLASH_MODE) || m10327b(CameraUIInterface.KEY_VIDEO_FLASH_MODE) || m10327b(CameraUIInterface.KEY_MOVIE_FLASH_MODE)))) {
            this.mCameraUIManager.mo18070a(R.string.camera_low_battery_flash_disable, -1, true, false, false);
            Camera.f10612n = false;
            m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_FLASH);
            return true;
        }
        Camera.f10612n = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bA */
    public void m9793bA() {
        m10023d(this.f10850cb);
        if (m10327b(CameraFunction.TORCH_SOFT_LIGHT)) {
            m10091e(this.f10850cb.m11072a(this.f10849ca, 1));
        }
        m9795bB();
        m10390s();
    }

    /* renamed from: bB */
    private void m9795bB() {
        this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
        this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_VIDEO_FLASH_MODE);
        if (m10327b(CameraFunction.TORCH_SOFT_LIGHT)) {
            this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_TORCH_MODE);
        }
    }

    /* renamed from: t */
    public void m10391t() throws Resources.NotFoundException {
        String str;
        CameraLog.m12959b("CameraManager", "prepareRealTimeDcsMsgData");
        if (this.f10753ai) {
            return;
        }
        this.f10789bS = new CaptureMsgData(Util.m24472l());
        DcsUtil.fillSecondScreenStatus(this.f10789bS, this.mCameraUIManager.mo18214f(), this.mCameraUIManager.mo18219g());
        this.f10789bS.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
        CaptureMsgData captureMsgData = this.f10789bS;
        captureMsgData.mTouchEVValue = this.f10699G;
        captureMsgData.mMemoryValue = String.valueOf(Util.m24468k(Util.m24472l()));
        this.f10789bS.mPictureFps = PerformanceMsgData.getAverageFrameRate();
        this.f10789bS.parseFaceInfo(this.f10857ci);
        this.f10789bS.mMagneticShellStatus = Util.m24320aI() ? "on" : "off";
        if (this.mModeManager.m11871af()) {
            this.f10789bS.mAncFilterType = FilterHelper.f21316f.f21248b.get(this.f10850cb.getInt(this.mModeManager.m12053dm(), 0));
        }
        if (this.mModeManager.m12091j(CameraUIInterface.KEY_TORCH_MODE)) {
            CaptureMsgData captureMsgData2 = this.f10789bS;
            if (this.mModeManager.m12091j(ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) {
                str = CameraUIInterface.FLASH_TYPE_FLASH_LIGHT;
            } else {
                str = InverseManager.INS.isInverseAble(this.f10849ca) ? CameraUIInterface.FLASH_TYPE_INVERSE_LIGHT : CameraUIInterface.FLASH_TYPE_SCREEN_LIGHT;
            }
            captureMsgData2.mFlashType = str;
        } else if (this.mModeManager.m12091j(CameraUIInterface.KEY_FLASH_MODE)) {
            this.f10789bS.mFlashType = CameraUIInterface.FLASH_TYPE_FLASH_LIGHT;
        } else {
            this.f10789bS.mFlashType = "none";
        }
        this.f10789bS.mIsRecordLocation = String.valueOf("on".equals(this.f10850cb.getString(CameraUIInterface.KEY_RECORD_LOCATION, Util.m24472l().getString(R.string.camera_location_default_value))));
        this.f10789bS.mIsSDCard = String.valueOf("on".equals(this.f10850cb.getString(CameraUIInterface.KEY_STORAGE_PLACE, Util.m24472l().getString(R.string.camera_storage_default_value))));
        this.f10789bS.mVolumeFunction = this.f10850cb.getString(CameraUIInterface.KEY_VOLUME_KEY_FUNCTION, Util.m24472l().getString(R.string.camera_volume_key_function_default_value));
        this.f10789bS.mIsShutterVoice = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_SOUND, Util.m24472l().getString(R.string.camera_sound_default_value));
        this.f10789bS.mIsGestureCaptureType = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, Util.m24472l().getString(R.string.camera_gesture_shutter_default_value));
        this.f10789bS.mIsTapCaptureType = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, Util.m24472l().getString(R.string.camera_tap_shutter_default_value));
        this.f10789bS.mSpiritLevel = this.f10850cb.getString(CameraUIInterface.KEY_ASSIST_GRADIENTER, "off");
        if (this.mModeManager.m12050dj()) {
            this.f10789bS.mIsMirror = this.f10850cb.getString(CameraUIInterface.KEY_MIRROR, Util.m24472l().getString(R.string.camera_mirror_default_value));
        }
        CaptureMsgData captureMsgData3 = this.f10789bS;
        captureMsgData3.mPreviewCaptureCostTime = this.f10714V;
        captureMsgData3.mBetweenClickBtnCostTime = this.f10716X;
        captureMsgData3.mDelayTime = this.mModeManager.m11876ak();
        if (Util.m24459h("oplus.software.motor.breathled")) {
            this.f10789bS.mSelfieLight = this.f10850cb.getString(CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER, "off");
            if (this.f10747ac) {
                this.f10789bS.mSelfieLightTrigger = String.valueOf(!"off".equals(this.mModeManager.m11876ak()) && "on".equals(this.f10789bS.mSelfieLight) && m10327b(CameraUIInterface.KEY_TIME_LAPSE));
            }
        }
        this.f10789bS.mPhotoFormat = (!"HEIF".equals(this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG")) || this.mModeManager.m11926bW()) ? CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG : CaptureMsgData.TYPE_PHOTO_FORMAT_HEIF;
        if (this.mModeManager.m12087i(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && m10315ay()) {
            Set<String> stringSet = this.f10850cb.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
            if (stringSet != null && !stringSet.isEmpty()) {
                String[] stringArray = Util.m24472l().getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
                boolean zContains = stringSet.contains(stringArray[0]);
                boolean zContains2 = stringSet.contains(stringArray[1]);
                boolean zContains3 = stringSet.contains(stringArray[2]);
                this.f10789bS.mIsModelSlogan = zContains ? "on" : "off";
                this.f10789bS.mIsTimeSlogan = zContains2 ? "on" : "off";
                this.f10789bS.mIsLocationSlogan = zContains3 ? "on" : "off";
            }
            this.f10789bS.mSloganLocate = this.f10850cb.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "");
            this.f10789bS.mSloganSize = this.f10850cb.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, "");
            if (this.f10831cI != null) {
                this.f10789bS.mSloganType = this.f10831cI.m11703e();
            }
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            if (this.mModeManager.m12087i(CameraUIInterface.KEY_PI_AI)) {
                this.f10789bS.mIsPi = this.mCameraUIManager.m19633Q(this.f10700H) ? "on" : "off";
                this.f10789bS.mIsAiScene = String.valueOf(this.mModeManager.m11841aB());
            }
        } else {
            if (this.mModeManager.m12087i(CameraUIInterface.KEY_PI)) {
                this.f10789bS.mIsPi = this.f10850cb.getString(CameraUIInterface.KEY_PI, "off");
            }
            if (this.mModeManager.m12087i(CameraUIInterface.KEY_AI_SCN)) {
                this.f10789bS.mIsAiScene = String.valueOf(this.mModeManager.m11840aA());
            }
        }
        if (this.mModeManager.m12087i(CameraUIInterface.KEY_FACE_RECTIFY)) {
            this.f10789bS.mIsFaceRectify = this.mModeManager.m12017cz() ? "on" : "off";
        }
        if (this.mModeManager.m12087i(CameraUIInterface.KEY_ZOOM)) {
            this.f10789bS.mZoomValue = String.valueOf(m10279aO());
        }
        if (this.mModeManager.m12087i(CameraUIInterface.KEY_ASSISTANT_LINE)) {
            this.f10789bS.mIsAssistantLine = this.f10850cb.getString(CameraUIInterface.KEY_LINE_PHOTO, "off");
        }
        if (this.mModeManager.m12087i(CameraUIInterface.KEY_FLASH_MODE) || this.mModeManager.m12087i(CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
            this.f10789bS.mFlashMode = this.mModeManager.m11787S();
        } else if (this.mModeManager.m12087i(CameraUIInterface.KEY_TORCH_MODE)) {
            this.f10789bS.mFlashMode = this.f10850cb.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.f10849ca));
        }
        if (this.f10826cD != null && !"off".equals(this.f10789bS.mDelayTime)) {
            this.f10789bS.mTimerSize = this.f10826cD.m19329b();
            this.f10789bS.mTimerCoordinate = this.f10826cD.m19330c();
        }
        if (m10327b(CameraFunction.ID_PHOTO)) {
            synchronized (this.f10791bU) {
                if (this.f10860cl == 0) {
                    this.f10789bS.mFaceCode = "no_face";
                } else if (this.f10860cl > 1) {
                    this.f10789bS.mFaceCode = "more_face";
                }
            }
        }
        if (m10327b(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
            this.f10789bS.m10BitsEncode = this.f10850cb.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
        }
        if (this.mModeManager.m11872ag()) {
            this.f10789bS.mbIsFishEyeActive = "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_FISH_EYE_MODE, "off"));
        }
        if (m10327b(CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
            int iM11914bK = this.mModeManager.m11914bK();
            if (iM11914bK == 0) {
                CaptureMsgData captureMsgData4 = this.f10789bS;
                captureMsgData4.mMakeupType = "off";
                captureMsgData4.mMakeupValue = 0;
            } else {
                this.f10789bS.mMakeupType = DcsMsgData.sKeyMakeupList.get(iM11914bK);
                this.f10789bS.mMakeupValue = this.mModeManager.m12120r(iM11914bK);
            }
        }
        RegionCommonFeatureAdapter.m14529a(this.f10789bS, this.f10850cb.getBoolean("pref_camera_statement_agree", false), LocationManager.m16155a());
        this.f10789bS = (CaptureMsgData) this.mModeManager.m11801a(this.f10789bS);
        this.f10789bS.mRearOrFront = this.f10747ac ? DcsMsgData.FRONT : DcsMsgData.REAR;
        if (this.mModeManager != null) {
            this.f10789bS.mCaptureMode = this.mModeManager.m12105n();
            if (!TextUtils.isEmpty(this.f10789bS.mCaptureMode) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && ApsConstant.CAPTURE_MODE_COMMON.equals(this.f10789bS.mCaptureMode) && this.mModeManager.m12143z()) {
                this.f10789bS.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
            }
        }
        CaptureMsgData captureMsgData5 = this.f10789bS;
        captureMsgData5.mOrientation = this.f10984t;
        ApsService apsService = this.f10876dB;
        if (apsService != null) {
            apsService.setCaptureMsgData(captureMsgData5);
        }
        CameraLog.m12959b("CameraManager", "prepareRealTimeDcsMsgData X");
    }

    /* renamed from: u */
    public int m10393u() {
        int OplusGLSurfaceView_13;
        if (!m10205C()) {
            return 0;
        }
        synchronized (this.f10791bU) {
            OplusGLSurfaceView_13 = this.f10860cl;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10259a(Face[] faceArr, int[] iArr) {
        synchronized (this.f10791bU) {
            this.f10857ci = faceArr;
            if (!m10327b(CameraUIInterface.KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION)) {
                iArr = null;
            }
            this.f10858cj = iArr;
            this.f10860cl = this.f10857ci != null ? this.f10857ci.length : 0;
            CameraDataCollection.m24685a().m24690a(this.f10860cl);
            if (this.f10864cp != null && m10205C()) {
                this.f10864cp.mo22778a(this.f10857ci != null ? this.f10860cl : -1);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10258a(int[] iArr) {
        synchronized (this.f10793bW) {
            if (this.f10754aj) {
                this.f10859ck = iArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bC */
    public String m9797bC() {
        synchronized (this.f10977m) {
            if (this.f10697E == null || this.f10697E.length < 2) {
                return "";
            }
            return this.f10697E[0] + "x" + this.f10697E[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bD */
    public String m9799bD() {
        synchronized (this.f10977m) {
            if (this.f10698F == null || this.f10698F.length < 2) {
                return "";
            }
            return this.f10698F[0] + "x" + this.f10698F[1];
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10242a(final Size size, final Size size2) {
        int OplusGLSurfaceView_13;
        if (size == null) {
            CameraLog.m12967f("CameraManager", "onPreviewSurfaceSizeChanged, previewSize is null ");
            return;
        }
        CameraLog.m12952a("onPreviewSurfaceSizeChanged");
        Util.m24386b(size);
        m10163q(Util.m24426d(size.getWidth(), size.getHeight()));
        boolean z = Util.m24352ao() && (this.mCameraUIManager.mo19881dY() || this.mCameraUIManager.mo19880dX());
        if ((this.f10866cr == null || !this.f10866cr.m11528j()) && (1 == (OplusGLSurfaceView_13 = this.f10927eA) || 5 == OplusGLSurfaceView_13 || z || Util.m24495t())) {
            this.mCameraUIManager.m19647a((!Util.m24352ao() || z) ? (byte) 2 : (byte) 1, false);
        }
        CameraLog.m12954a("CameraManager", "onPreviewSurfaceSizeChanged");
        TeleSmallPreviewManager c3431ab = this.f10869cu;
        if (c3431ab != null) {
            c3431ab.m22994a(size);
        }
        this.f10841cS.post(new Runnable() { // from class: com.oplus.camera.CameraManager.9
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.mCameraUIManager != null) {
                    CameraManager.this.mCameraUIManager.m19670a(size, size2, true);
                    CameraManager.this.f10864cp.mo22809b(CameraManager.this.f10864cp.mo22845k());
                }
            }
        });
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.10
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("CameraManager", "onPreviewSurfaceSizeChanged, mbCaptureModeChanging: " + CameraManager.this.f10762ar);
                if (CameraManager.this.f10762ar || CameraManager.this.mModeManager == null || CameraManager.this.mModeManager.m11953bx() || CameraManager.this.mModeManager.m12049di() || CameraManager.this.f10866cr == null || CameraManager.this.f10866cr.m11528j()) {
                    return;
                }
                CameraManager cameraManager = CameraManager.this;
                cameraManager.m10244a(size, cameraManager.f10800bd);
            }
        });
        CameraLog.m12958b("onPreviewSizeChanged");
    }

    /* renamed from: v */
    public boolean m10396v() {
        if (this.f10865cq == null) {
            return false;
        }
        return this.f10865cq.mo23706s();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m10327b(String str) {
        if (this.mModeManager != null) {
            return this.mModeManager.m12091j(str);
        }
        return true;
    }

    /* renamed from: w */
    public void m10397w() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.11
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraManager.this.f10790bT) {
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19887de();
                    }
                }
            }
        });
    }

    /* renamed from: x */
    public void m10399x() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.13
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraManager.this.f10790bT) {
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19888df();
                    }
                }
            }
        });
    }

    /* renamed from: y */
    public void m10401y() {
        final Size sizeM17187a = this.f10914dn.m17187a(this.f10853ce);
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.14
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraManager.this.f10791bU) {
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "startFaceDetection, mbFaceDetectionStarted: " + CameraManager.this.f10751ag);
                    CameraManager.this.m10259a((Face[]) null, (int[]) null);
                    CameraManager.this.f10751ag = true;
                    CameraManager.this.f10740aV = CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_VIDEO_EIS);
                    CameraManager.this.mCameraUIManager.m19667a(CameraManager.this.f10861cm, sizeM17187a);
                    float configFloatValue = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_VIDEO_EIS_PREVIEW_SCALE);
                    if (!CameraManager.this.f10740aV || configFloatValue <= 1.0f) {
                        configFloatValue = 1.0f;
                    }
                    if (Util.m24169C()) {
                        CameraManager.this.mCameraUIManager.m19728b(configFloatValue);
                    }
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19703ab(CameraManager.this.f10747ac);
                    }
                }
            }
        });
    }

    /* renamed from: z */
    public void m10403z() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.15
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraManager.this.f10791bU) {
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "stopFaceDetection, mbFaceDetectionStarted: " + CameraManager.this.f10751ag);
                    CameraManager.this.f10751ag = false;
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19826cc();
                    }
                }
            }
        });
    }

    /* renamed from: A */
    public void m10203A() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.16
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraManager.this.f10793bW) {
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    CameraLog.m12959b("CameraManager", "startMultiFocus");
                    CameraManager.this.m10258a((int[]) null);
                    CameraManager.this.f10754aj = true;
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19827cd();
                    }
                }
            }
        });
    }

    /* renamed from: B */
    public void m10204B() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.17
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraManager.this.f10793bW) {
                    CameraManager.this.f10859ck = null;
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    CameraLog.m12959b("CameraManager", "stopMultiFocus");
                    CameraManager.this.f10754aj = false;
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19828ce();
                    }
                }
            }
        });
    }

    /* renamed from: C */
    public boolean m10205C() {
        boolean z;
        synchronized (this.f10791bU) {
            z = this.f10751ag;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m9581A(boolean z) {
        CameraLog.m12954a("CameraManager", "setTabCaptureStart, " + this.f10810bn + " -> " + z);
        this.f10810bn = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m10321b(boolean z) {
        CameraLog.m12954a("CameraManager", "setDoubleFinger, mbDoubleFinger: " + this.f10798bb + " -> " + z);
        this.f10798bb = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m10335c(boolean z) {
        CameraLog.m12954a("CameraManager", "setCaptureModeChangeState, " + this.f10762ar + " -> " + z);
        this.f10762ar = z;
    }

    /* renamed from: D */
    public boolean m10206D() {
        return this.f10760ap;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m10340d(boolean z) {
        CameraLog.m12954a("CameraManager", "setSwitchingCameraState, " + this.f10760ap + " -> " + z);
        this.f10760ap = z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m10347e(boolean z) {
        CameraLog.m12954a("CameraManager", "setDelayToDisableBustShot, " + this.f10797ba + " > " + z);
        this.f10797ba = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m10353f(boolean z) {
        CameraLog.m12954a("CameraManager", "setSizeChangeState: " + this.f10763as + " > " + z);
        this.f10763as = z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m10359g(boolean z) {
        CameraLog.m12954a("CameraManager", "setForceChangeRecSize: " + this.f10765au + " > " + z);
        this.f10765au = z;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m10362h(boolean z) {
        CameraLog.m12954a("CameraManager", "setNoneSatUltraWideAngleChanging, running: " + this.f10758an + " > " + z);
        this.f10758an = z;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m10365i(boolean z) {
        CameraLog.m12954a("CameraManager", "setNoneSatTeleAngleChanging, running: " + this.f10759ao + " > " + z);
        this.f10759ao = z;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m10368j(boolean z) {
        CameraLog.m12954a("CameraManager", "setBlurAnimRunning, running: " + this.f10757am + " > " + z);
        this.f10757am = z;
    }

    /* renamed from: E */
    public boolean m10207E() {
        return this.f10757am;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m10339d(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "setBlurAnimType, animType: " + this.f10704L + " > " + OplusGLSurfaceView_13);
        this.f10704L = OplusGLSurfaceView_13;
    }

    /* renamed from: q */
    private void m10163q(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "setSizeRatioType, type: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 != this.f10927eA && this.mCameraUIManager != null) {
            this.f10927eA = OplusGLSurfaceView_13;
            this.mCameraUIManager.m19622F(this.f10927eA);
        }
        Util.m24383b(OplusGLSurfaceView_13);
    }

    /* renamed from: F */
    public boolean m10208F() {
        CameraLog.m12954a("CameraManager", "needPreviewImage");
        PreviewImageProcess c3591z = this.f10931eE;
        return c3591z == null || !this.f10762ar || c3591z.m24842c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bE */
    public String m9801bE() {
        CameraLog.m12954a("CameraManager", "checkSmallInternalStorage");
        String string = this.f10849ca.getString(R.string.camera_storage_default_value);
        if (Storage.m11138d() && Storage.m11143g() <= 8.0d) {
            string = "on";
        }
        SharedPreferences.Editor editorEdit = this.f10850cb.edit();
        editorEdit.putString(CameraUIInterface.KEY_STORAGE_PLACE, string);
        editorEdit.apply();
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bF */
    public void m9803bF() {
        this.f10819bw = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.oplus.camera.CameraManager$18] */
    /* renamed from: bG */
    public void m9804bG() {
        CameraLog.m12954a("CameraManager", "checkStorage, mbCheckStorage: " + this.f10750af);
        if (this.f10750af) {
            return;
        }
        this.f10750af = true;
        this.f10823cA = new AsyncTask<Void, Void, Void>() { // from class: com.oplus.camera.CameraManager.18
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                CameraLog.m12954a("CameraManager", "onPreExecute");
                if (!CameraManager.this.f10752ah) {
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.f10786bP = cameraManager.f10850cb.getString(CameraUIInterface.KEY_STORAGE_PLACE, null);
                    if (CameraManager.this.f10786bP == null) {
                        CameraManager cameraManager2 = CameraManager.this;
                        cameraManager2.f10786bP = cameraManager2.m9801bE();
                    }
                }
                if (CameraManager.this.f10803bg) {
                    return;
                }
                if ("on".equals(CameraManager.this.f10786bP) && !Storage.m11138d()) {
                    SharedPreferences.Editor editorEdit = CameraManager.this.f10850cb.edit();
                    editorEdit.putString(CameraUIInterface.KEY_STORAGE_PLACE, "off");
                    editorEdit.apply();
                    CameraManager.this.f10786bP = "off";
                }
                CameraManager.this.f10803bg = true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                CameraLog.m12954a("CameraManager", "checkStorage, doInBackground");
                if (CameraManager.this.f10752ah) {
                    return null;
                }
                Storage.m11115a(CameraManager.this.f10850cb, CameraManager.this.f10786bP);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r5) {
                CameraLog.m12954a("CameraManager", "checkStorage, onPostExecute, mbPaused: " + CameraManager.this.f10752ah);
                if (!CameraManager.this.f10752ah) {
                    int OplusGLSurfaceView_13 = Storage.f12096v;
                    if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
                        if (CameraManager.this.mModeManager.m11861aV()) {
                            CameraManager.this.mModeManager.m12103m(false);
                            if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_QUICK_VIDEO)) {
                                CameraManager.this.mCameraUIManager.mo18280w();
                                LockViewDragLayout.setVolumeDownState(false);
                            }
                        }
                    } else if (OplusGLSurfaceView_13 == 5 && CameraManager.this.mModeManager.m11861aV() && CameraManager.this.f10856ch != null) {
                        CameraManager.this.f10856ch.mo9567m();
                    }
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.f10786bP = cameraManager.f10850cb.getString(CameraUIInterface.KEY_STORAGE_PLACE, CameraManager.this.f10849ca.getString(R.string.camera_storage_default_value));
                    CameraManager.this.mCameraUIManager.mo18269t();
                }
                CameraManager.this.f10750af = false;
            }
        }.execute(new Void[0]);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10231a(float COUIBaseListPopupWindow_12, float f2) throws NumberFormatException {
        float f3 = COUIBaseListPopupWindow_12 - f2;
        float f4 = Float.parseFloat(Util.m24314aC());
        if (Float.compare(f3, f4) < 0) {
            f3 = f4;
        }
        m10230a(f3);
        CameraLog.m12959b("CameraManager", "decreaseScreenBrightness, targetBrightness: " + f3 + ", targetBrightness:" + f3);
        if (Float.compare(f3, f4) > 0) {
            this.f10932eF.removeMessages(17);
            this.f10932eF.sendMessageDelayed(this.f10932eF.obtainMessage(17, Float.valueOf(f3)), 1000L);
        }
    }

    /* renamed from: G */
    public int m10209G() {
        return Settings.System.getInt(this.f10849ca.getApplicationContext().getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.f10981q * 0.4f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bH */
    public void m9807bH() throws NumberFormatException {
        long OplusGLSurfaceView_15 = Long.parseLong(Util.m24313aB());
        float fFloatValue = Float.valueOf(m10209G()).floatValue() / this.f10981q;
        float COUIBaseListPopupWindow_12 = Float.parseFloat(Util.m24314aC());
        if (Float.compare(fFloatValue, COUIBaseListPopupWindow_12) > 0) {
            CameraLog.m12959b("CameraManager", "delayDecreaseBrightness, decreaseScreenBrightnessDelay: " + OplusGLSurfaceView_15);
            this.f10732aN = (fFloatValue - COUIBaseListPopupWindow_12) / 30.0f;
            this.f10932eF.removeMessages(17);
            this.f10932eF.sendMessageDelayed(this.f10932eF.obtainMessage(17, Float.valueOf(fFloatValue)), OplusGLSurfaceView_15);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10230a(float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("CameraManager", "changeScreenBrightness, brightness: " + COUIBaseListPopupWindow_12 + ", mActivity: " + this.f10849ca);
        if (this.f10849ca == null) {
            return;
        }
        CameraLog.m12952a("changeScreenBrightness");
        if (COUIBaseListPopupWindow_12 == -1.0f) {
            m10210H();
        } else {
            float f2 = Settings.System.getInt(this.f10849ca.getApplicationContext().getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.f10981q * 0.4f));
            if (f2 > this.f10981q) {
                CameraLog.m12954a("CameraManager", "changeScreenBrightness, fSysBrightness: " + f2 + "fSysBrightness >= " + this.f10981q + ", so no need set window screenBrightness");
                if (this.mModeManager != null) {
                    this.mModeManager.m12092k((int) f2);
                    return;
                }
                return;
            }
            Window window = this.f10849ca.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = COUIBaseListPopupWindow_12;
            window.setAttributes(attributes);
            float f3 = this.f10981q * COUIBaseListPopupWindow_12;
            if (this.mModeManager != null) {
                this.mModeManager.m12092k((int) f3);
            }
        }
        CameraLog.m12958b("changeScreenBrightness");
    }

    /* renamed from: H */
    public void m10210H() {
        CameraLog.m12954a("CameraManager", "restoreScreenBrightnessForChangeOnRuningtime");
        if (this.f10849ca != null) {
            Window window = this.f10849ca.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = -1.0f;
            window.setAttributes(attributes);
        }
        int OplusGLSurfaceView_13 = Settings.System.getInt(Util.m24472l().getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.f10981q * 0.4f));
        if (this.mModeManager != null) {
            this.mModeManager.m12092k(OplusGLSurfaceView_13);
        }
        CameraLog.m12954a("CameraManager", "restoreScreenBrightnessForChangeOnRuningtime X");
    }

    /* renamed from: bI */
    private int m9808bI() throws NumberFormatException {
        int OplusGLSurfaceView_13 = this.f10981q;
        if (!Util.m24459h("oplus.software.display.multibits_dimming_support")) {
            return OplusGLSurfaceView_13;
        }
        String strM24461i = Util.m24461i("sys.oplus.multibrightness");
        if (TextUtils.isEmpty(strM24461i)) {
            try {
                strM24461i = SystemPropertiesNative.get("sys.oplus.multibrightness");
            } catch (UnSupportedApiVersionException unused) {
                CameraLog.m12967f("CameraManager", "getMaxForTempAutoBrightnessAdjust, get multibrightness failed");
            }
        }
        if (!TextUtils.isEmpty(strM24461i)) {
            OplusGLSurfaceView_13 = Integer.parseInt(strM24461i);
        }
        return OplusGLSurfaceView_13 == 0 ? this.f10981q : OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m10323b(boolean z, boolean z2) {
        synchronized (this.f10794bX) {
            if (this.f10742aX) {
                CameraLog.m12954a("CameraManager", "setAutoBrightnessAdjust, Process would be kill, don't set adjustValue!");
                return;
            }
            this.f10742aX = z2;
            final float fM9808bI = (m9808bI() * (z ? 300.0f : 500.0f)) / 255.0f;
            if (fM9808bI == 0.0f) {
                CameraLog.m12954a("CameraManager", "setAutoBrightnessAdjust, No need set adjustValue!");
                return;
            }
            CameraLog.m12954a("CameraManager", String.format(Locale.ENGLISH, "setAutoBrightnessAdjust %COUIBaseListPopupWindow_12 on sdk %IntrinsicsJvm.kt_5", Float.valueOf(fM9808bI), Integer.valueOf(Build.VERSION.SDK_INT)));
            if (27 < Build.VERSION.SDK_INT) {
                Util.m24279a(new Runnable() { // from class: com.oplus.camera.CameraManager.19
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DisplayManagerNative.m24912a(fM9808bI);
                        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m10371k(boolean z) {
        CameraLog.m12954a("CameraManager", "initScreenBrightness, bEnterCamera: " + z);
        m10323b(z, false);
        CameraLog.m12954a("CameraManager", "initScreenBrightness X");
    }

    /* renamed from: I */
    public void m10211I() {
        CameraLog.m12954a("CameraManager", "updateOtherSettingFlags");
        this.f10785bO = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_SOUND, this.f10849ca.getString(R.string.camera_sound_default_value));
        this.f10787bQ = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_FINGERPRINT_SHUTTER, this.f10849ca.getString(R.string.camera_fingerprint_capture_default_value));
        CameraLog.m12954a("CameraManager", "updateOtherSettingFlags, mFingerprintShutter: " + this.f10787bQ);
        this.f10786bP = this.f10850cb.getString(CameraUIInterface.KEY_STORAGE_PLACE, null);
        if (this.f10786bP == null) {
            this.f10786bP = m9801bE();
        }
        if (this.f10786bP.equals("off")) {
            Storage.f12095u = "off";
        } else {
            Storage.f12095u = "on";
        }
    }

    /* renamed from: J */
    public void m10212J() {
        m10230a(0.8f);
        this.mCameraUIManager.m19809cL();
        this.mModeManager.m11939bj();
    }

    /* renamed from: K */
    public boolean m10213K() {
        if (this.mModeManager != null) {
            return this.mModeManager.m11868ac();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bJ */
    public void m9811bJ() {
        CameraLog.m12954a("CameraManager", "onPictureSizeChanged");
        if (this.mCameraUIManager != null) {
            Size sizeM19747bG = this.mCameraUIManager.m19747bG();
            Size sizeM11796a = this.mModeManager.m11796a(this.f10853ce);
            int iM11789U = this.mModeManager.m11789U();
            boolean zM9705a = m9705a(sizeM19747bG, sizeM11796a, iM11789U, iM11789U, false, 100, (CameraPreviewUI.PlatformImplementations.kt_3) new C2592t());
            this.mCameraUIManager.mo18089a((DetectResult) null);
            this.f10884dJ = null;
            if (zM9705a) {
                m10353f(true);
            }
            this.mCameraUIManager.mo18138ab();
            int width = sizeM19747bG.getWidth();
            int height = sizeM19747bG.getHeight();
            int width2 = sizeM11796a.getWidth();
            int height2 = sizeM11796a.getHeight();
            if (width / height != width2 / height2 && ((width == height || width2 == height2) && this.mCameraUIManager.m19805cH())) {
                this.mCameraUIManager.mo18174b(false);
                this.f10919ds = true;
            }
        }
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13071b(false, false);
        }
        if (this.f10869cu != null) {
            this.f10777bG = false;
            this.f10780bJ = true;
            this.f10781bK = false;
        }
        this.f10700H = 0;
    }

    /* renamed from: bK */
    private void m9813bK() {
        CameraLog.m12954a("CameraManager", "onVideoSizeChanged");
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        Size sizeM17187a = this.f10914dn.m17187a(this.f10853ce);
        Size sizeM17186a = this.f10914dn.m17186a(sizeM17187a);
        Size size = sizeM17186a != null ? sizeM17186a : sizeM17187a;
        int iM11789U = this.mModeManager.m11789U();
        if (m9705a(sizeM19747bG, size, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2597y(this, null))) {
            m10353f(true);
            this.mCameraUIManager.m19641W(false);
            String string = this.f10850cb.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, this.f10989y));
            if (m9861bj() && "video_size_720p".equals(string)) {
                this.mCameraUIManager.m19817cT();
            }
        }
    }

    /* renamed from: bL */
    private void m9815bL() {
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        Size sizeM17187a = this.f10914dn.m17187a(this.f10853ce);
        Size sizeM17186a = this.f10914dn.m17186a(sizeM17187a);
        Size size = sizeM17186a != null ? sizeM17186a : sizeM17187a;
        if (this.f10850cb.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off").equals("on") && this.f10850cb.getBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false)) {
            this.f10850cb.edit().putBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false).apply();
        }
        if (this.f10722aD) {
            return;
        }
        int iM11789U = this.mModeManager.m11789U();
        if (m9705a(sizeM19747bG, size, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2576d(this, null))) {
            m10353f(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public OplusCameraCharacteristics m10166r(int OplusGLSurfaceView_13) {
        String strM10305ao;
        if (this.mModeManager != null && this.mModeManager.m12105n() != null) {
            strM10305ao = this.mModeManager.m12105n();
        } else {
            strM10305ao = m10305ao();
        }
        this.f10853ce = CameraCharacteristicsUtil.m12971a(strM10305ao, OplusGLSurfaceView_13);
        return this.f10853ce;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m9894c(int OplusGLSurfaceView_13, int i2) {
        return CameraCharacteristicsUtil.m12969a(m10166r(OplusGLSurfaceView_13), i2);
    }

    /* renamed from: s */
    private int m10171s(int OplusGLSurfaceView_13) {
        return CameraCharacteristicsUtil.m12968a(m10166r(OplusGLSurfaceView_13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m10016d(int OplusGLSurfaceView_13, int i2) {
        return CameraCharacteristicsUtil.m12975b(m10166r(OplusGLSurfaceView_13), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bM */
    public void m9816bM() {
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        Size sizeM11796a = this.mModeManager.m11796a(m10166r(this.f10846cX.m13329a(this.mModeManager.m12105n(), this.f10989y)));
        int iM11789U = this.mModeManager.m11789U();
        Size sizeM11795a = this.mModeManager.m11795a(sizeM11796a);
        if (m9705a(sizeM19747bG, sizeM11795a != null ? sizeM11795a : sizeM11796a, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2574b(this, null))) {
            m10353f(true);
        }
        this.f10846cX.m13347j();
    }

    /* renamed from: bN */
    private void m9819bN() {
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        Size sizeM11796a = this.mModeManager.m11796a(m10166r(this.f10846cX.m13329a(this.mModeManager.m12105n(), this.f10989y)));
        int iM11789U = this.mModeManager.m11789U();
        Size sizeM11795a = this.mModeManager.m11795a(sizeM11796a);
        if (m9705a(sizeM19747bG, sizeM11795a != null ? sizeM11795a : sizeM11796a, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2576d(this, null))) {
            m10353f(true);
        }
        this.f10846cX.m13347j();
    }

    /* renamed from: bO */
    private void m9820bO() {
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        Size sizeM11796a = this.mModeManager.m11796a(m10166r(this.f10846cX.m13329a(this.mModeManager.m12105n(), this.f10989y)));
        int iM11789U = this.mModeManager.m11789U();
        Size sizeM11795a = this.mModeManager.m11795a(sizeM11796a);
        Size size = sizeM11795a != null ? sizeM11795a : sizeM11796a;
        if (this.f10757am) {
            this.f10931eE.m24840b(false);
            this.mCameraUIManager.m19806cI();
            m10368j(false);
            m10339d(-1);
            this.mCameraUIManager.mo18183c().m23489t();
            CameraLog.m12954a("CameraManager", "noneSatTeleAngleChanged, resetBlurAnimation");
        }
        if (m9705a(sizeM19747bG, size, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2576d(this, null))) {
            m10353f(true);
        }
        this.f10846cX.m13347j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blurModeChanged() {
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        int iM11789U = this.mModeManager.m11789U();
        if (m9705a(sizeM19747bG, sizeM19747bG, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2576d(this, null))) {
            m10353f(true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m10097f(String str) {
        if (m10150n(str)) {
            Size sizeM19747bG = this.mCameraUIManager.m19747bG();
            int iM11789U = this.mModeManager.m11789U();
            if (m9705a(sizeM19747bG, sizeM19747bG, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2585m(this, null))) {
                m10353f(true);
            }
        }
        this.mModeManager.m12102m(str);
    }

    /* renamed from: bP */
    private void m9823bP() {
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        int iM11789U = this.mModeManager.m11789U();
        if (m9705a(sizeM19747bG, sizeM19747bG, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2583k(this, null))) {
            m10353f(true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m10106g(String str) {
        if (m10150n(str)) {
            Size sizeM19747bG = this.mCameraUIManager.m19747bG();
            int iM11789U = this.mModeManager.m11789U();
            if (m9705a(sizeM19747bG, sizeM19747bG, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2585m(this, null))) {
                m10353f(true);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m10337c(String str) {
        BaseMode baseModeM11800a = this.mModeManager.m11800a(str);
        Size sizeM9768b = m9768b(this.mModeManager.m11800a(this.mModeManager.m12105n()));
        Size sizeM9768b2 = m9768b(baseModeM11800a);
        int iM24426d = sizeM9768b != null ? Util.m24426d(sizeM9768b.getWidth(), sizeM9768b.getHeight()) : 0;
        int iM24426d2 = sizeM9768b2 != null ? Util.m24426d(sizeM9768b2.getWidth(), sizeM9768b2.getHeight()) : 0;
        PreviewImageProcess c3591z = this.f10931eE;
        if (c3591z != null) {
            c3591z.m24836a(sizeM9768b, sizeM9768b2);
        }
        if (sizeM9768b != null && sizeM9768b2 != null) {
            CameraLog.m12954a("CameraManager", "isModeSwitchNeedBlurAnimate, previewSize:(" + sizeM9768b.getWidth() + "x" + sizeM9768b.getHeight() + ") => (" + sizeM9768b2.getWidth() + "x" + sizeM9768b2.getHeight() + ")");
        }
        return (TextUtils.equals(str, this.mModeManager.m12105n()) && iM24426d == iM24426d2) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m10262a(String str, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "setCurrentMode, mode: " + str + ", cameraId: " + OplusGLSurfaceView_13);
        this.f10957ej = false;
        this.f10872cx = "";
        this.mModeManager.m11957c(OplusGLSurfaceView_13);
        boolean zM11965c = this.mModeManager.m11965c(str);
        if (this.f10876dB != null) {
            this.mModeManager.m11813a(this.f10876dB);
        }
        if (-1 == this.f10990z) {
            this.f10990z = m10304an();
        }
        if (this.f10852cd != null) {
            CameraLog.m12954a("CameraManager", "setCurrentMode, mOneCamera:" + this.f10852cd);
            ((OneCameraProxy) this.f10852cd).m13224D().m12152c(str);
        }
        if (ApsConstant.REC_MODE_COMMON.equals(str)) {
            this.mModeManager.m12124s(this.f10818bv);
        }
        this.mModeManager.m11829a(this.f10783bM);
        return zM11965c;
    }

    /* renamed from: bQ */
    private void m9824bQ() {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19734b(this.mModeManager.m12076g());
            if (!this.mModeManager.m11832a()) {
                this.mCameraUIManager.m19794c(false, 0);
            }
            this.mCameraUIManager.mo18112aB();
            this.mCameraUIManager.m19873dQ();
        }
    }

    /* renamed from: L */
    public boolean m10214L() {
        if (this.mModeManager == null || this.mCameraUIManager == null) {
            CameraLog.m12954a("CameraManager", "canRespondTouch, mModeManager: " + this.mModeManager + ", mCameraUIManager: " + this.mCameraUIManager);
            return false;
        }
        if (this.f10807bk && !this.mCameraUIManager.m19811cN() && ((this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_EXPOSURE_FOCUS_SEPARATE) || this.mModeManager.m11865aZ()) && !this.mModeManager.m11791W() && !m10224V() && !this.f10738aT && !this.f10763as && this.f10739aU && m9827bR() && this.f10801be && !this.f10810bn && this.mCameraUIManager.mo18265s() != 4 && this.mCameraUIManager.mo18265s() != 32 && this.f10846cX.m13317J() != 3 && !this.f10766av && ((this.f10762ar || m10222T()) && this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.MODE) && !m10312av() && !this.f10760ap))) {
            return true;
        }
        CameraLog.m12954a("CameraManager", "canRespondTouch, mbInitialized: " + this.f10807bk + ", getScreenTorchState: " + this.mCameraUIManager.m19811cN() + ", isVideoRecordStopped: " + this.mModeManager.m11865aZ() + ", getIsCapturingState: " + this.mModeManager.m11791W() + ", isSnapShotProgress: " + m10224V() + ", mbSwitchingVideoProfile: " + this.f10738aT + ", mbSizeChanging: " + this.f10763as + ", mbFirstPreviewOK: " + this.f10739aU + ", canScrollChangeMode: " + m9827bR() + ", mbFrameAvailable: " + this.f10801be + ", mbTabCaptureStart: " + this.f10810bn + ", getMainShutterButtonType: " + this.mCameraUIManager.mo18265s() + ", mCameraEntry.getCameraEntryType(): " + this.f10846cX.m13317J() + ", mbBurstShot: " + this.f10766av + ", mbCaptureModeChanging: " + this.f10762ar + ", isPreviewStarted: " + m10222T() + ", mModeManager.isAllowSwitch: " + this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.MODE) + ", isTimerSnapShotRunning: " + m10312av() + ", mbSwitchingCamera: " + this.f10760ap);
        return false;
    }

    /* renamed from: M */
    public boolean m10215M() {
        return (this.f10846cX == null || this.mModeManager == null || this.f10852cd == null || this.f10846cX.m13329a(this.mModeManager.m12105n(), this.f10989y) != this.f10852cd.mo13075c()) ? false : true;
    }

    public boolean isAllowSwitchMode() {
        if (this.mModeManager == null || this.mCameraUIManager == null) {
            CameraLog.m12954a("CameraManager", "isAllowSwitchMode, mModeManager: " + this.mModeManager + ", mCameraUIManager: " + this.mCameraUIManager);
            return false;
        }
        if (!this.f10807bk || this.mCameraUIManager.m19811cN() || !this.mModeManager.m11865aZ() || this.mModeManager.m11791W() || this.mModeManager.m11879an() || m10224V() || this.f10738aT || this.f10763as || !this.f10739aU || !m9827bR() || this.f10810bn || this.mCameraUIManager.mo18265s() == 4 || this.mCameraUIManager.mo18265s() == 32 || this.f10846cX.m13317J() == 3 || this.f10766av || !this.f10875dA || ((!this.f10762ar && !m10222T()) || !this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.MODE) || m10312av() || this.f10760ap || ((this.mCameraUIManager.mo18051O() && 1 != this.mCameraUIManager.mo18134aX()) || this.mCameraUIManager.mo18025B() || ((this.mCameraUIManager.mo18043K() && !this.mCameraUIManager.m19926eN() && !Util.m24498u()) || this.mModeManager.m11937bh() || this.mCameraUIManager.m19821cX() || ((m10280aP() && 1 != this.mCameraUIManager.mo18134aX()) || this.mCameraUIManager.m19872dP() || this.mCameraUIManager.m19874dR() || this.mCameraUIManager.m19943eq() || !this.f10950ec))))) {
            CameraLog.m12954a("CameraManager", "isAllowSwitchMode, mbInitialized: " + this.f10807bk + ", getScreenTorchState: " + this.mCameraUIManager.m19811cN() + ", isVideoRecordStopped: " + this.mModeManager.m11865aZ() + ", getIsCapturingState: " + this.mModeManager.m11791W() + ", getIsShowPostCaptureAlert: " + this.mModeManager.m11879an() + ", isSnapShotProgress: " + m10224V() + ", mbSwitchingVideoProfile: " + this.f10738aT + ", mbSizeChanging: " + this.f10763as + ", mbFirstPreviewOK: " + this.f10739aU + ", canScrollChangeMode: " + m9827bR() + ", mbTabCaptureStart: " + this.f10810bn + ", getMainShutterButtonType: " + this.mCameraUIManager.mo18265s() + ", mCameraEntry.getCameraEntryType(): " + this.f10846cX.m13317J() + ", mbBurstShot: " + this.f10766av + ", mbCaptureModeChanging: " + this.f10762ar + ", isPreviewStarted: " + m10222T() + ", mModeManager.isAllowSwitch: " + this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.MODE) + ", isTimerSnapShotRunning: " + m10312av() + ", mbSwitchingCamera: " + this.f10760ap + ", isBlurMenuOpen: " + this.mCameraUIManager.mo18051O() + ", isFolderOpened: " + Util.m24498u() + ", isAnyModeAnimationRunning: " + this.mCameraUIManager.mo18025B() + ", isFaceBeautyMenuOpen: " + this.mCameraUIManager.mo18043K() + ", faceBeautyMenuType: " + this.mModeManager.m11909bF() + ", isStickerMenuOpen: " + this.mModeManager.m11937bh() + ", isTiltShiftBlurMenuOpen: " + this.mCameraUIManager.m19821cX() + ", isZoomAnimRunning: " + m10280aP() + ", isFilterEffectMenuAnimRunning: " + this.mCameraUIManager.m19872dP() + ", isNightAnimationRunning: " + this.mCameraUIManager.m19874dR() + ", isDrawerAnimationRun: " + this.mCameraUIManager.m19943eq() + ", mbEntryFirstPreviewReceived: " + this.f10950ec);
            return false;
        }
        boolean z = PreferenceManager.m3981a(this.f10849ca).getBoolean("mode_arrange_change_panel", false);
        if (z) {
            CameraLog.m12954a("CameraManager", "isAllowSwitchMode, changePanel: " + z);
            return true;
        }
        if (!this.mModeManager.m11832a()) {
            return true;
        }
        CameraLog.m12954a("CameraManager", "isAllowSwitchMode, isPanelMode: " + this.mModeManager.m11832a());
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m10112h(MotionEvent motionEvent) {
        CameraUIListener cameraUIListener;
        CameraLog.m12954a("CameraManager", "onUp, mScrollChangeMode: " + this.f10693A);
        CameraLog.m12952a("onUp");
        if (this.mModeManager != null && this.mModeManager.m11879an()) {
            CameraLog.m12954a("CameraManager", "onUp, isShowPostCaptureAlert, return");
            return;
        }
        if (this.f10925dy) {
            CameraLog.m12954a("CameraManager", "onUp, mbTouchInTiltShiftRect: true");
            this.f10693A = 0;
            return;
        }
        if (this.mModeManager != null && this.mModeManager.m11833a(this.f10693A, motionEvent)) {
            CameraLog.m12954a("CameraManager", "onUp, getCurrentModeName: " + this.mModeManager.m12105n());
            this.f10693A = 0;
            CameraLog.m12958b("onUp");
            return;
        }
        if (Util.m24498u() && this.mCameraUIManager.m19919eG()) {
            CameraLog.m12954a("CameraManager", "onUp, isInModeArrange, return");
            this.f10693A = 0;
            return;
        }
        int OplusGLSurfaceView_13 = this.f10693A;
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 3) {
                    if (!this.f10757am && !this.mCameraUIManager.m19939em() && !this.mCameraUIManager.m19941eo() && this.mModeManager != null && this.f10723aE && ("off".equals(m9937cN()) || this.f10826cD == null || !this.f10826cD.m19331d())) {
                        CameraUIListener cameraUIListener2 = this.mCameraUIListener;
                        if (cameraUIListener2 != null) {
                            cameraUIListener2.mo10872p("2");
                        }
                        if (this.mCameraUIManager.mo18043K()) {
                            this.mCameraUIManager.mo18109a(true, true, true, true);
                        }
                    }
                } else if (OplusGLSurfaceView_13 == 4 && !this.f10757am && !this.mCameraUIManager.m19939em() && (("off".equals(m9937cN()) || this.f10826cD == null || !this.f10826cD.m19331d()) && (cameraUIListener = this.mCameraUIListener) != null)) {
                    cameraUIListener.mo10872p("2");
                }
            } else if (this.mModeManager != null && this.mModeManager.m11937bh() && !this.mModeManager.m11890ay()) {
                this.mCameraUIManager.m19775bn();
            } else if (this.mCameraUIManager.mo18023A()) {
                if (motionEvent.getY() < this.mCameraUIManager.m19754bN() && m10214L()) {
                    this.mCameraUIManager.m19753bM();
                }
            } else if (isAllowSwitchMode() && !this.f10894dT) {
                this.mCameraUIManager.m19785bx();
            }
        } else if (this.mModeManager != null && this.mModeManager.m11937bh() && !this.mModeManager.m11890ay()) {
            this.mCameraUIManager.m19774bm();
        } else if (this.mCameraUIManager.mo18023A()) {
            if (motionEvent.getY() < this.mCameraUIManager.m19754bN() && m10214L()) {
                this.mCameraUIManager.m19752bL();
            }
        } else if (isAllowSwitchMode() && !this.f10894dT) {
            this.mCameraUIManager.m19784bw();
        }
        this.f10693A = 0;
        CameraLog.m12958b("onUp");
    }

    /* renamed from: bR */
    private boolean m9827bR() {
        return (m10312av() || this.f10798bb) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10246a(MotionEvent motionEvent) {
        GestureDetectorOnGestureListenerC2590r gestureDetectorOnGestureListenerC2590r;
        m10372l(motionEvent.getPointerCount() >= 2);
        if (motionEvent.getAction() == 0) {
            this.f10733aO = motionEvent.getY();
        } else if (2 == motionEvent.getActionMasked() && this.f10798bb && (gestureDetectorOnGestureListenerC2590r = this.f10906df) != null) {
            this.f10693A = 0;
            gestureDetectorOnGestureListenerC2590r.m11040a(false);
        } else if (this.f10866cr != null && (motionEvent.getAction() & 255) == 6) {
            this.f10866cr.m11515e();
        }
        this.mCameraUIManager.m19852d(motionEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m10326b(MotionEvent motionEvent) {
        boolean zM19912e = this.mCameraUIManager.m19912e(motionEvent);
        if (zM19912e && this.f10866cr != null) {
            this.f10866cr.m11483A();
        }
        return zM19912e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public MotionEvent m10332c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount < 2 || m9828bS()) {
            if (this.f10904dd.booleanValue() && this.f10902db != motionEvent && motionEvent.getAction() == 0) {
                this.f10902db = MotionEvent.obtain(motionEvent);
                this.f10902db.setAction(1);
                this.f10904dd = false;
            }
            return motionEvent;
        }
        boolean z = false;
        int pointerId = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < motionEvent.getPointerCount(); OplusGLSurfaceView_13++) {
            if (m10324b(motionEvent.getX(OplusGLSurfaceView_13), motionEvent.getY(OplusGLSurfaceView_13))) {
                pointerId |= 1 << motionEvent.getPointerId(OplusGLSurfaceView_13);
                pointerCount--;
            } else {
                MotionEvent motionEvent2 = this.f10901da;
                if (motionEvent2 != null && m10324b(motionEvent2.getX(OplusGLSurfaceView_13), this.f10901da.getY(OplusGLSurfaceView_13)) && 2 == motionEvent.getActionMasked()) {
                    z = true;
                }
            }
        }
        if (pointerCount == motionEvent.getPointerCount() && z) {
            motionEvent.setAction(3);
        }
        CameraLog.m12959b("CameraManager", "handleEdgeTouch, pointercount in edge: " + pointerCount);
        if (pointerCount < motionEvent.getPointerCount() && pointerCount > 0) {
            motionEvent = Util.m24241a(motionEvent, pointerId);
            if (this.f10866cr != null) {
                this.f10866cr.m11515e();
                this.f10866cr.m11483A();
            }
        } else if (pointerCount == motionEvent.getPointerCount() && 3 != motionEvent.getActionMasked()) {
            if (!this.f10903dc.booleanValue()) {
                this.f10903dc = true;
            }
            motionEvent = null;
        }
        this.f10901da = motionEvent;
        return motionEvent;
    }

    /* renamed from: bS */
    private boolean m9828bS() {
        return this.mCameraUIManager != null && this.mCameraUIManager.mo18057R();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public MotionEvent m10338d(MotionEvent motionEvent) {
        if (!this.f10903dc.booleanValue() || 1 != motionEvent.getAction()) {
            return motionEvent;
        }
        this.f10904dd = true;
        this.f10903dc = false;
        return this.f10902db;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m10324b(float COUIBaseListPopupWindow_12, float f2) {
        CameraLog.m12959b("CameraManager", "isNotEdgeTouch, x: " + COUIBaseListPopupWindow_12 + " y: " + f2);
        return f2 <= 0.0f || f2 >= ((float) this.f10849ca.getResources().getDimensionPixelSize(R.dimen.menu_panel_layout_height));
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m10372l(boolean z) {
        m10321b(z);
        if (this.mModeManager != null) {
            this.mModeManager.m11897b(!z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m10346e(MotionEvent motionEvent) {
        if (this.f10829cG == null) {
            this.f10829cG = VelocityTracker.obtain();
        }
        this.f10829cG.addMovement(motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        BaseMode baseModeM11800a;
        CameraLog.m12954a("CameraManager", "onKeyDown, keycode: " + OplusGLSurfaceView_13);
        OnKeyEventManager.m17945a().m17946a(OplusGLSurfaceView_13, keyEvent);
        if (this.f10706N == OplusGLSurfaceView_13) {
            if (this.f10808bl && keyEvent.getRepeatCount() == 0) {
                m10114h("fingerprint");
                m10265aA();
            }
            return true;
        }
        if (OplusGLSurfaceView_13 != 27 && OplusGLSurfaceView_13 != 66) {
            if (OplusGLSurfaceView_13 != 82 && OplusGLSurfaceView_13 != 84) {
                if (OplusGLSurfaceView_13 != 319) {
                    if (OplusGLSurfaceView_13 != 706) {
                        if (OplusGLSurfaceView_13 == 717) {
                            if (1 == this.f10846cX.m13317J() && this.f10808bl && keyEvent.getRepeatCount() == 0) {
                                String strM12105n = this.mModeManager.m12105n();
                                String str = (TextUtils.isEmpty(strM12105n) || ApsConstant.REC_MODE_TIMELASPE_PRO.equals(strM12105n) || (baseModeM11800a = this.mModeManager.m11800a(strM12105n)) == null || !baseModeM11800a.isCaptureModeType()) ? ApsConstant.CAPTURE_MODE_COMMON : ApsConstant.REC_MODE_COMMON;
                                if (this.mCameraUIManager != null && this.mCameraUIManager.m19864dH()) {
                                    this.mCameraUIManager.m19866dJ();
                                    this.mCameraUIManager.m19853d(false, -1);
                                    m9701a(false, false, -1);
                                }
                                if ((this.mCameraUIManager != null && ((this.mCameraUIManager.mo18201d() && isAllowSwitchMode()) || this.mCameraUIManager.m19898dp())) || this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_GIMBAL_CHANGE)) {
                                    m10154o(str);
                                }
                            }
                            return true;
                        }
                        if (OplusGLSurfaceView_13 != 57) {
                            if (OplusGLSurfaceView_13 != 58) {
                                if (OplusGLSurfaceView_13 == 79) {
                                    long downTime = keyEvent.getDownTime();
                                    if (this.f10808bl && keyEvent.getRepeatCount() == 0 && downTime - this.f10711S <= 600) {
                                        return true;
                                    }
                                    if (this.f10808bl && keyEvent.getRepeatCount() == 0 && downTime - this.f10711S > 600 && m10314ax()) {
                                        this.f10711S = downTime;
                                        m10265aA();
                                    } else if (this.f10808bl && keyEvent.getRepeatCount() > 0) {
                                        this.f10711S = downTime;
                                    }
                                    return true;
                                }
                                if (OplusGLSurfaceView_13 == 80) {
                                    if (this.f10808bl && keyEvent.getRepeatCount() == 0) {
                                        m10265aA();
                                    }
                                    return true;
                                }
                                if (OplusGLSurfaceView_13 == 168 || OplusGLSurfaceView_13 == 169) {
                                    if ((this.mCameraUIManager.m19875dS() && this.mCameraUIManager.m19864dH()) || this.mCameraUIManager.m19862dF() || m10261a(OplusGLSurfaceView_13, keyEvent)) {
                                        return true;
                                    }
                                } else {
                                    switch (OplusGLSurfaceView_13) {
                                        case 19:
                                        case 20:
                                        case 21:
                                        case 22:
                                            if (Util.m24342ae()) {
                                                return true;
                                            }
                                            break;
                                        case 23:
                                            if (!Util.m24342ae()) {
                                                m10245a(keyEvent);
                                            }
                                            return true;
                                        case 24:
                                        case 25:
                                            if ((this.mCameraUIManager.m19875dS() && this.mCameraUIManager.m19864dH()) || this.mCameraUIManager.m19862dF() || this.mCameraUIManager.m19915eC() || LockViewDragLayout.getLongPressState() || m10325b(OplusGLSurfaceView_13, keyEvent)) {
                                                return true;
                                            }
                                            break;
                                    }
                                }
                            } else if (Util.m24342ae() && Util.m24345ah() && isAllowSwitchMode()) {
                                this.mCameraUIManager.m19784bw();
                            }
                        } else if (Util.m24342ae() && Util.m24345ah() && isAllowSwitchMode()) {
                            this.mCameraUIManager.m19785bx();
                        }
                        return false;
                    }
                    if (this.f10808bl && keyEvent.getRepeatCount() == 0) {
                        m10266aB();
                    }
                }
            }
            return true;
        }
        m10245a(keyEvent);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyUp(int r9, android.view.KeyEvent r10) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.CameraManager.onKeyUp(int, android.view.KeyEvent):boolean");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m10355f(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f10733aO = motionEvent.getY();
            if (this.f10867cs != null && this.mModeManager.m11849aJ() && this.f10867cs.isPointInTiltShift(motionEvent.getX(), motionEvent.getY())) {
                this.f10925dy = true;
            }
            if (this.f10866cr != null) {
                this.f10894dT = this.f10866cr.m11511c(motionEvent);
            } else {
                this.f10894dT = false;
            }
        } else if (motionEvent.getAction() == 1) {
            m10112h(motionEvent);
            if (this.f10867cs != null && this.mModeManager.m11849aJ()) {
                this.f10867cs.resetAjustingState();
            }
            this.f10925dy = false;
        } else if (motionEvent.getAction() == 3) {
            this.f10925dy = false;
            m10121i(motionEvent);
        }
        if (!m10223U()) {
            if (!m10224V() && !this.f10766av) {
                if (this.f10865cq != null && this.f10865cq.m23669a(motionEvent)) {
                    CameraLog.m12954a("CameraManager", "dispatchTouchEvent, do mFocus manager touchevent");
                    return true;
                }
                if (this.f10867cs != null && this.mModeManager.m11849aJ() && this.f10867cs.dispatchTouchEvent(motionEvent)) {
                    return true;
                }
                if (this.f10908dh != null && this.f10865cq != null && this.f10865cq.m23710w()) {
                    m10358g(motionEvent);
                }
                if (this.mCameraUIManager != null && this.mCameraUIManager.m19697a(motionEvent)) {
                    return true;
                }
                if (this.f10866cr != null && this.f10866cr.m11499a(motionEvent)) {
                    return true;
                }
                if (this.mModeManager != null && this.mModeManager.m12021d(motionEvent)) {
                    return true;
                }
                m10128j(motionEvent);
            } else if (1 == motionEvent.getAction() || 6 == motionEvent.getAction()) {
                if (this.f10866cr != null) {
                    this.f10866cr.m11499a(motionEvent);
                }
                if ((this.f10865cq == null || !this.f10865cq.m23669a(motionEvent)) && this.mCameraUIManager != null) {
                    this.mCameraUIManager.m19697a(motionEvent);
                }
                m10128j(motionEvent);
            } else if (motionEvent.getAction() == 0) {
                m10128j(motionEvent);
            }
        } else if (6 == motionEvent.getAction() || 262 == motionEvent.getAction()) {
            if (this.f10866cr != null) {
                this.f10866cr.m11499a(motionEvent);
            }
        } else if (!this.mModeManager.m11879an()) {
            m10128j(motionEvent);
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m10121i(MotionEvent motionEvent) {
        if (this.f10866cr != null) {
            this.f10866cr.m11499a(motionEvent);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m10358g(MotionEvent motionEvent) {
        QrCodeManager viewOnClickListenerC2609aa = this.f10908dh;
        if (viewOnClickListenerC2609aa != null) {
            viewOnClickListenerC2609aa.m11212a(motionEvent);
        }
    }

    /* renamed from: N */
    public void m10216N() {
        if (this.f10693A != 0) {
            CameraLog.m12954a("CameraManager", "needResetSlideFlag, the event consume by super, need reset mScrollChangeMode.");
            this.f10693A = 0;
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$r */
    private class GestureDetectorOnGestureListenerC2590r implements GestureDetector.OnGestureListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f11202b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f11203c;

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        private GestureDetectorOnGestureListenerC2590r() {
            this.f11202b = false;
        }

        /* synthetic */ GestureDetectorOnGestureListenerC2590r(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (CameraManager.this.mModeManager.m11835a(motionEvent)) {
                return false;
            }
            this.f11203c = true;
            this.f11202b = true;
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11040a(boolean z) {
            this.f11203c = z;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (CameraManager.this.f10752ah || !CameraManager.this.f10808bl || CameraManager.this.f10852cd == null || CameraManager.this.mCameraUIManager.mo18253p() == null || CameraManager.this.f10810bn || CameraManager.this.f10760ap || CameraManager.this.m10224V() || CameraManager.this.m10223U() || (CameraManager.this.f10866cr != null && CameraManager.this.f10866cr.m11506b(motionEvent))) {
                CameraLog.m12967f("CameraManager", "onLongPress, is not preview state,so return");
                return;
            }
            if (MultiVideoSmallSurfaceTouchEventHelper.m13880a().m13883b()) {
                CameraLog.m12967f("CameraManager", "onLongPress, small surface is moving, so return");
                return;
            }
            if (!MultiVideoSmallSurfaceTouchEventHelper.m13880a().m13883b()) {
                if (CameraManager.this.mCameraUIManager.m19751bK()) {
                    CameraManager.this.mCameraUIManager.m19846cw();
                    CameraLog.m12967f("CameraManager", "onLongPress, hidepopupwindow, so return");
                    return;
                }
                if (CameraManager.this.f10865cq.m23710w()) {
                    return;
                }
                if (!CameraManager.this.mCameraUIManager.m19740b(motionEvent)) {
                    if (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11963c(motionEvent)) {
                        CameraManager.this.m9666a((int) (motionEvent.getX() + 0.5d), (int) (motionEvent.getY() + 0.5d), motionEvent.getEventTime());
                        return;
                    }
                    return;
                }
                CameraLog.m12967f("CameraManager", "onLongPress, needSubSettingTouchEvent, so return");
                return;
            }
            CameraLog.m12967f("CameraManager", "onLongPress, small surface is moving, so return");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            if (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11861aV()) {
                if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19829cf()) {
                    CameraLog.m12967f("CameraManager", "onScroll, isRecordTimeViewShow, so return");
                    return false;
                }
                CameraLog.m12967f("CameraManager", "onScroll, mCameraProcessManager.isPreviewStarted() :" + CameraManager.this.m10222T());
                if (this.f11203c && !CameraManager.this.f10798bb && !CameraManager.this.m10224V()) {
                    if (CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11836a(motionEvent, motionEvent2, COUIBaseListPopupWindow_12, f2)) {
                        return false;
                    }
                    boolean z = CameraManager.this.f10890dP != null && 1 == CameraManager.this.f10890dP.mo16411a().mo16539j();
                    if (CameraManager.this.f10865cq != null && CameraManager.this.f10865cq.m23710w() && (CameraManager.this.f10984t % 180 != 0 || z)) {
                        return false;
                    }
                    if (!CameraManager.this.f10808bl) {
                        CameraLog.m12954a("CameraManager", "onScroll, mFirstTimeInitialized is false, so return.");
                        return false;
                    }
                    if (!CameraManager.this.m10278aN() || CameraManager.this.f10733aO < CameraManager.this.mCameraUIManager.mo18150an()) {
                        if (CameraManager.this.f10866cr != null && CameraManager.this.f10866cr.m11528j()) {
                            return false;
                        }
                        if (!CameraManager.this.isAllowSwitchMode()) {
                            CameraLog.m12954a("CameraManager", "onScroll, isAllowSwitchMode is false, so return.");
                            return false;
                        }
                        if (motionEvent == null || motionEvent2 == null) {
                            return false;
                        }
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        float x2 = motionEvent2.getX();
                        float y2 = motionEvent2.getY();
                        int iJ = CameraManager.this.f10890dP.mo16411a().mo16539j();
                        CameraLog.m12954a("CameraManager", "onScroll, eX1 - eX2: " + Math.abs(x - x2) + ", eY1 - eY2: " + Math.abs(y - y2) + ", screenMode: " + iJ);
                        if (1 == iJ && CameraManager.this.mModeManager != null && !CameraManager.this.mModeManager.m12070e(motionEvent)) {
                            CameraLog.m12954a("CameraManager", "onScroll, isInPreviewArea is false, so return.");
                            return false;
                        }
                        if (1 == iJ || 4 == iJ) {
                            return m11039b(x, x2, y, y2);
                        }
                        return m11036a(x, x2, y, y2);
                    }
                    CameraLog.m12954a("CameraManager", "isCanScrollHeadLine, isZoomSeekBarExpand: " + CameraManager.this.m10278aN());
                    return false;
                }
                CameraLog.m12954a("CameraManager", "onScroll, mbCanScroll: " + this.f11203c + ", mbDoubleFinger: " + CameraManager.this.f10798bb + ", isSnapShotProgress: " + CameraManager.this.m10224V());
                return false;
            }
            CameraLog.m12967f("CameraManager", "onScroll, isVideoRecording, so return");
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m11036a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            if (!CameraManager.this.mModeManager.m11861aV() && !CameraManager.this.mModeManager.m11791W() && !CameraManager.this.f10760ap && !CameraManager.this.mModeManager.m11792X() && !CameraManager.this.mModeManager.m11993cb()) {
                CameraManager.this.f10829cG.computeCurrentVelocity(400);
                CameraLog.m12954a("CameraManager", "handleScrollNormal, xVelocity: " + CameraManager.this.f10829cG.getXVelocity() + ", yVelocity: " + CameraManager.this.f10829cG.getYVelocity());
                float f5 = f3 - f4;
                float f6 = COUIBaseListPopupWindow_12 - f2;
                if (Math.abs(f5) < Math.abs(f6)) {
                    float xVelocity = CameraManager.this.f10829cG.getXVelocity();
                    float fAbs = Math.abs(f5) / Math.abs(f6);
                    if (3 == CameraManager.this.f10846cX.m13317J() || 1 <= Float.compare(fAbs, 0.58f) || (f6 <= CameraManager.this.f10694B && (xVelocity >= (-CameraManager.this.f10696D) || f6 <= CameraManager.this.f10695C))) {
                        if (3 != CameraManager.this.f10846cX.m13317J() && 1 > Float.compare(fAbs, 0.58f)) {
                            float f7 = f2 - COUIBaseListPopupWindow_12;
                            if (f7 > CameraManager.this.f10694B || (xVelocity > CameraManager.this.f10696D && f7 > CameraManager.this.f10695C)) {
                                CameraManager.this.f10693A = 2;
                                this.f11203c = false;
                                return false;
                            }
                        }
                    } else {
                        CameraManager.this.f10693A = 1;
                        this.f11203c = false;
                        return false;
                    }
                } else if (!CameraManager.this.m10223U() && !CameraManager.this.f10865cq.m23641A() && !CameraManager.this.f10865cq.m23710w()) {
                    float yVelocity = CameraManager.this.f10829cG.getYVelocity();
                    float fAbs2 = Math.abs(f6) / Math.abs(f5);
                    if (3 != CameraManager.this.f10846cX.m13317J() && 1 > Float.compare(fAbs2, 0.58f)) {
                        float f8 = f4 - f3;
                        if (f8 > CameraManager.this.f10694B || (yVelocity < (-CameraManager.this.f10696D) && f8 > CameraManager.this.f10695C)) {
                            CameraManager.this.f10693A = 3;
                            this.f11203c = false;
                            return false;
                        }
                    }
                    if (3 != CameraManager.this.f10846cX.m13317J() && 1 > Float.compare(fAbs2, 0.58f) && (f5 > CameraManager.this.f10694B || (yVelocity < (-CameraManager.this.f10696D) && f5 > CameraManager.this.f10695C))) {
                        CameraManager.this.f10693A = 4;
                        this.f11203c = false;
                    }
                }
            }
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m11039b(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            float f5;
            float f6 = f2 - COUIBaseListPopupWindow_12;
            float f7 = f4 - f3;
            float xVelocity = CameraManager.this.f10829cG.getXVelocity();
            float yVelocity = CameraManager.this.f10829cG.getYVelocity();
            int iK = CameraManager.this.f10890dP.mo16411a().mo16570k();
            int iJ = CameraManager.this.f10890dP.mo16411a().mo16539j();
            if (1 != iJ) {
                if (4 == iJ) {
                    xVelocity = CameraManager.this.f10829cG.getYVelocity();
                    yVelocity = CameraManager.this.f10829cG.getXVelocity();
                    f5 = f6;
                    f6 = f7;
                }
                f5 = f7;
            } else if (iK == 0) {
                xVelocity = CameraManager.this.f10829cG.getYVelocity();
                yVelocity = CameraManager.this.f10829cG.getXVelocity();
                f5 = f6;
                f6 = f7;
            } else if (90 == iK) {
                f6 = COUIBaseListPopupWindow_12 - f2;
                f5 = f3 - f4;
                xVelocity = -CameraManager.this.f10829cG.getXVelocity();
                yVelocity = -CameraManager.this.f10829cG.getYVelocity();
            } else {
                f5 = f7;
            }
            CameraLog.m12954a("CameraManager", "handleScrollVerticalMode, moveX: " + f6 + ", moveY: " + f5);
            if (!CameraManager.this.mModeManager.m11861aV() && !CameraManager.this.mModeManager.m11791W() && !CameraManager.this.f10760ap && !CameraManager.this.mModeManager.m11792X() && !CameraManager.this.mModeManager.m11993cb()) {
                CameraManager.this.f10829cG.computeCurrentVelocity(400);
                CameraLog.m12954a("CameraManager", "onScroll, xVelocity: " + CameraManager.this.f10829cG.getXVelocity() + ", yVelocity: " + CameraManager.this.f10829cG.getYVelocity());
                if (Math.abs(f5) < Math.abs(f6)) {
                    float fAbs = Math.abs(f5) / Math.abs(f6);
                    if (3 != CameraManager.this.f10846cX.m13317J() && 1 > Float.compare(fAbs, 0.58f)) {
                        float f8 = -f6;
                        if (f8 > CameraManager.this.f10694B || (xVelocity < (-CameraManager.this.f10696D) && f8 > CameraManager.this.f10695C)) {
                            if (4 != iJ || 270 != iK) {
                                CameraManager.this.f10693A = 1;
                            } else {
                                CameraManager.this.f10693A = 2;
                            }
                            this.f11203c = false;
                            return false;
                        }
                    }
                    if (3 != CameraManager.this.f10846cX.m13317J() && 1 > Float.compare(fAbs, 0.58f) && (f6 > CameraManager.this.f10694B || (xVelocity > CameraManager.this.f10696D && f6 > CameraManager.this.f10695C))) {
                        if (4 != iJ || 270 != iK) {
                            CameraManager.this.f10693A = 2;
                        } else {
                            CameraManager.this.f10693A = 1;
                        }
                        this.f11203c = false;
                        return false;
                    }
                } else if (!CameraManager.this.m10223U() && !CameraManager.this.f10865cq.m23641A() && !CameraManager.this.f10865cq.m23710w()) {
                    float fAbs2 = Math.abs(f6) / Math.abs(f5);
                    if (3 == CameraManager.this.f10846cX.m13317J() || 1 <= Float.compare(fAbs2, 0.58f) || (f5 <= CameraManager.this.f10694B && (yVelocity >= (-CameraManager.this.f10696D) || f5 <= CameraManager.this.f10695C))) {
                        if (3 != CameraManager.this.f10846cX.m13317J() && 1 > Float.compare(fAbs2, 0.58f)) {
                            float f9 = -f5;
                            if (f9 > CameraManager.this.f10694B || (yVelocity < (-CameraManager.this.f10696D) && f9 > CameraManager.this.f10695C)) {
                                CameraManager.this.f10693A = 4;
                                this.f11203c = false;
                            }
                        }
                    } else {
                        CameraManager.this.f10693A = 3;
                        this.f11203c = false;
                        return false;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean zM11037a;
            int actionIndex = motionEvent.getActionIndex();
            int x = (int) (motionEvent.getX(actionIndex) + 0.5d);
            int y = (int) (motionEvent.getY(actionIndex) + 0.5d);
            if (!CameraManager.this.f10752ah && CameraManager.this.f10852cd != null && !CameraManager.this.m10349e() && !CameraManager.this.m10224V() && !CameraManager.this.mModeManager.m11902b(motionEvent) && !CameraManager.this.f10760ap && CameraManager.this.m10222T() && this.f11202b) {
                if ((CameraManager.this.mCameraUIManager.mo18043K() || CameraManager.this.mCameraUIManager.m19796c(motionEvent)) && !Util.m24294a(CameraManager.this.mCameraUIManager.m19744bD(), x, y)) {
                    CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
                    return true;
                }
                if (!CameraManager.this.mCameraUIManager.m19740b(motionEvent)) {
                    Object[] objArr = CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19751bK();
                    Object[] objArr2 = CameraManager.this.f10866cr != null && CameraManager.this.f10866cr.m11528j();
                    if (objArr == true || objArr2 == true) {
                        if (objArr != false) {
                            CameraLog.m12959b("CameraManager", "onSingleTapUp, consumed by popupWindow");
                            CameraManager.this.mCameraUIManager.m19846cw();
                        }
                        if (objArr2 != false) {
                            CameraLog.m12959b("CameraManager", "onSingleTapUp, consumed by ZoomMenu");
                            CameraManager.this.f10866cr.m11507b(false);
                        }
                        return true;
                    }
                    if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19947eu()) {
                        CameraLog.m12959b("CameraManager", "onSingleTapUp, consumed by SlowVideoModeSeekBar");
                        CameraManager.this.mCameraUIManager.m19946et();
                        return true;
                    }
                    CameraManager.this.f10893dS.set(CameraManager.this.mCameraUIManager.mo18253p().getLeft(), CameraManager.this.mCameraUIManager.mo18253p().getTop(), CameraManager.this.mCameraUIManager.mo18253p().getRight(), CameraManager.this.mCameraUIManager.mo18253p().getBottom());
                    boolean zM11838a = CameraManager.this.mModeManager.m11838a(CameraManager.this.f10890dP.mo16411a().mo16529a(CameraManager.this.mCameraUIManager, x, y), x, y);
                    if (CameraManager.this.f10893dS.contains(x, y)) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (CameraManager.f10691i <= jCurrentTimeMillis - CameraManager.this.f10756al || ((int) Math.sqrt(Math.pow(CameraManager.this.f10707O - x, 2.0d) + Math.pow(CameraManager.this.f10708P - y, 2.0d))) > CameraManager.this.f10709Q) {
                            CameraManager.this.f10707O = x;
                            CameraManager.this.f10708P = y;
                            CameraManager.this.f10756al = jCurrentTimeMillis;
                            CameraManager cameraManager = CameraManager.this;
                            cameraManager.m10370k(cameraManager.mModeManager.m12015cx() ? 1 : 0);
                            zM11037a = false;
                        } else {
                            CameraManager.this.f10756al = 0L;
                            zM11037a = m11037a(x, y);
                            if (CameraManager.this.mModeManager.m12015cx()) {
                                CameraManager.this.m10370k(1);
                            } else if (!zM11037a) {
                                CameraManager.this.m10370k(0);
                            }
                        }
                        if (!zM11037a) {
                            if (zM11838a) {
                                CameraManager.this.m10336c(false, false);
                                CameraManager.this.m9667a(x, y, false, motionEvent.getEventTime());
                            } else {
                                CameraLog.m12954a("CameraManager", "onSingleTapUp, canTouch is false");
                                CameraManager.this.mCameraUIManager.m19957g(x, y);
                            }
                        }
                    } else {
                        CameraLog.m12954a("CameraManager", "onSingleTapUp, y is not in right area");
                        CameraManager.this.mCameraUIManager.m19957g(x, y);
                    }
                    this.f11202b = false;
                    return true;
                }
                CameraLog.m12959b("CameraManager", "onSingleTapUp, consumed by submenuSetting");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onSingleTapUp, mbPaused: ");
            sb.append(CameraManager.this.f10752ah);
            sb.append(", mbSwitchingCamera: ");
            sb.append(CameraManager.this.f10760ap);
            sb.append(", isSnapShotProgress: ");
            sb.append(CameraManager.this.m10224V());
            sb.append(", !isPreviewStarted: ");
            sb.append(!CameraManager.this.m10222T());
            sb.append(", mbHasReceiveDownEvent: ");
            sb.append(this.f11202b);
            CameraLog.m12954a("CameraManager", sb.toString());
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m11037a(int OplusGLSurfaceView_13, int i2) {
            Size sizeM11796a = CameraManager.this.mModeManager.m11796a(CameraManager.this.f10853ce);
            Rect rectB = CameraManager.this.m10300aj().mo16558b(sizeM11796a.getHeight(), sizeM11796a.getWidth());
            boolean zContains = i2 >= CameraManager.this.mCameraUIManager.mo18149am() && i2 <= CameraManager.this.mCameraUIManager.mo18150an();
            if (Util.m24498u() && rectB != null) {
                zContains = rectB.contains(OplusGLSurfaceView_13, i2);
            }
            if (!m11035a() || !CameraManager.this.m10268aD() || !zContains || CameraManager.this.m10269aE() || !CameraManager.this.m10222T() || !((OneCameraProxy) CameraManager.this.f10852cd).m13225E() || CameraManager.this.f10763as || !m11038b()) {
                return false;
            }
            CameraLog.m12954a("CameraManager", "onDoubleClick, x:" + OplusGLSurfaceView_13 + ", y: " + i2);
            CameraManager.this.m10039da();
            CameraManager.this.m10164q(FocusAimMsgData.KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE);
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m11035a() {
            if (!CameraManager.this.f10752ah && CameraManager.this.f10852cd != null && !CameraManager.this.m10349e() && !CameraManager.this.f10760ap && !CameraManager.this.m10224V() && CameraManager.this.m10222T()) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("checkCanTap, mbPaused: ");
            sb.append(CameraManager.this.f10752ah);
            sb.append(", mbSwitchingCamera: ");
            sb.append(CameraManager.this.f10760ap);
            sb.append(", isSnapShotProgress: ");
            sb.append(CameraManager.this.m10224V());
            sb.append(", !isPreviewStarted: ");
            sb.append(!CameraManager.this.m10222T());
            CameraLog.m12954a("CameraManager", sb.toString());
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m11038b() {
            return CameraManager.this.mCameraUIManager.mo18183c() != null && CameraManager.this.mCameraUIManager.mo18183c().m23490u() && CameraManager.this.mCameraUIManager.mo18183c().m23491v();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m10128j(MotionEvent motionEvent) {
        if (this.f10830cH == null) {
            this.f10906df = new GestureDetectorOnGestureListenerC2590r(this, null);
            this.f10830cH = new GestureDetector(this.f10849ca, this.f10906df);
        }
        this.f10830cH.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9667a(int OplusGLSurfaceView_13, int i2, boolean z, long OplusGLSurfaceView_15) {
        if (!new Rect(this.mCameraUIManager.mo18253p().getLeft(), this.mCameraUIManager.mo18253p().getTop(), this.mCameraUIManager.mo18253p().getRight(), this.mCameraUIManager.mo18253p().getBottom()).contains(OplusGLSurfaceView_13, i2) || this.mCameraUIManager.m19738b(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15) || !this.mModeManager.m12091j(CameraUIInterface.KEY_CONTINUOUS_FOCUS) || m9830bT() || this.f10865cq == null) {
            return;
        }
        CameraLog.m12967f("CameraManager", "CameraTest Camera Touch Focus Start");
        this.f10865cq.m23661a(OplusGLSurfaceView_13 - this.mCameraUIManager.mo18253p().getLeft(), i2 - this.mCameraUIManager.mo18253p().getTop(), true);
    }

    /* renamed from: bT */
    private boolean m9830bT() {
        if (this.mCameraUIManager.m19748bH() != null) {
            return this.mCameraUIManager.m19748bH().m21429y();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9666a(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        OneCamera interfaceC2694d;
        Rect rect = new Rect();
        rect.set(this.mCameraUIManager.mo18253p().getLeft(), this.mCameraUIManager.mo18253p().getTop(), this.mCameraUIManager.mo18253p().getRight(), this.mCameraUIManager.mo18253p().getBottom());
        boolean zM11838a = this.mModeManager.m11838a(this.f10890dP.mo16411a().mo16529a(this.mCameraUIManager, OplusGLSurfaceView_13, i2), OplusGLSurfaceView_13, i2);
        boolean z = !"camera_ultra_wide".equals(this.f10850cb.getString(CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_main")) || (interfaceC2694d = this.f10852cd) == null || interfaceC2694d.mo13086e() == null || this.f10852cd.mo13086e().m13284s() || !this.mCameraUIManager.mo19881dY();
        if (zM11838a && rect.contains(OplusGLSurfaceView_13, i2)) {
            if (this.mModeManager.m11871af() || this.f10865cq.mo23646F() || this.mModeManager.m11849aJ() || this.mModeManager.m11981cP()) {
                m10370k(0);
            } else if (z) {
                m10370k(2);
                m10336c(false, false);
            }
            m9667a(OplusGLSurfaceView_13, i2, true, OplusGLSurfaceView_15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bU */
    public void m9832bU() {
        if (this.f10865cq != null) {
            this.f10865cq.m23693i();
        }
    }

    /* renamed from: O */
    public void m10217O() {
        if (this.f10865cq != null) {
            this.f10865cq.m23703p();
            if (this.f10865cq.m23655O()) {
                m9610J(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9702a(boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        BaseMode baseMode;
        C2586n c2586n;
        PreviewImageProcess c3591z;
        CameraLog.m12967f("CameraManager", "CameraTest Camera Mode Change Start, isAsync: " + z + ", checkToAsync: " + z2 + ", fromAnimation: " + z3 + ", mbPaused: " + this.f10752ah);
        CameraPerformance.m15185a("switch_mode");
        if (this.f10752ah || this.mCameraUIManager == null) {
            return;
        }
        if (!z3) {
            this.f10724aF = true;
            m10335c(true);
        }
        if (!z) {
            this.mCameraUIManager.mo18200d(true, false);
        }
        m9832bU();
        String string = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, Util.m24382b(this.f10846cX.m13317J() == 3));
        FluencyPerformance.m15128a(string);
        if (Util.m24495t()) {
            BaseMode baseModeM11800a = this.mModeManager.m11800a(string);
            this.f10889dO.m16483a(baseModeM11800a);
            this.mCameraUIManager.m19701aC(true);
            Size sizeM9768b = m9768b(baseModeM11800a);
            Util.m24386b(sizeM9768b);
            m10163q(Util.m24426d(sizeM9768b.getWidth(), sizeM9768b.getHeight()));
        }
        if (!z && !z3) {
            this.mModeManager.m11896b(string);
        }
        if (!z) {
            this.mModeManager.m12025dB();
        }
        this.mModeManager.m11846aG();
        this.mModeManager.m11847aH();
        this.mCameraUIManager.m19945es();
        this.mCameraUIManager.m19641W(false);
        if (this.mModeManager.m11998cg()) {
            this.mCameraUIManager.mo18204e(CameraUIInterface.KEY_FLASH_MODE);
        }
        this.mCameraUIManager.mo18067a(R.string.rio_toast_shell_covered_camera_lens);
        this.mCameraUIManager.m19908dz();
        this.mCameraUIManager.m19778bq();
        this.f10700H = 0;
        this.mCameraUIManager.m19903du();
        if (z2 && m10337c(string)) {
            m10217O();
            if (!z3 && ((c3591z = this.f10931eE) == null || c3591z.m24841b() || this.f10929eC.m11000d())) {
                PreviewImageProcess c3591z2 = this.f10931eE;
                if (c3591z2 != null && c3591z2.m24841b()) {
                    this.f10931eE.m24840b(false);
                }
                this.mCameraUIManager.m19806cI();
                this.f10929eC.m10999c();
                m10130j(string);
                this.mCameraUIManager.m19701aC(false);
                return;
            }
            if (!m10130j(string)) {
                CameraLog.m12954a("CameraManager", "onCaptureModeChanged, mPreviewImageProcess: " + this.f10931eE);
                this.f10741aW = true;
            } else {
                CameraLog.m12954a("CameraManager", "onCaptureModeChanged, modeType or surfaceType changed, delay to call");
                this.mCameraUIManager.m19701aC(false);
                return;
            }
        }
        this.mCameraUIManager.m19701aC(false);
        boolean zM11945bp = this.mModeManager.m11945bp();
        int iM12067e = this.mModeManager.m12067e();
        String strM12105n = this.mModeManager.m12105n();
        int iM13329a = this.f10846cX.m13329a(strM12105n, this.f10989y);
        BaseMode baseModeM11800a2 = this.mModeManager.m11800a(strM12105n);
        BaseMode baseModeM11800a3 = this.mModeManager.m11800a(string);
        boolean zM10262a = m10262a(string, this.f10989y);
        int iM13329a2 = this.f10846cX.m13329a(string, this.f10989y);
        SwitchModePerformance.setSwitchMode(strM12105n, string);
        if (zM10262a) {
            this.mCameraUIManager.mo18183c().m23485p((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_BLUR_TO_CLEAN_ANIMATION) || ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(strM12105n) || ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(string) || ApsConstant.CAPTURE_MODE_MICROSCOPE.equals(strM12105n) || ApsConstant.CAPTURE_MODE_MICROSCOPE.equals(string)) ? false : true);
            m9824bQ();
            this.mCameraUIManager.m19761bU();
            this.mCameraUIManager.mo18056R(this.mModeManager.m12091j(CameraFunction.OUT_PREVIEW_ENABLE));
        }
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null && ((OneCameraProxy) interfaceC2694d).m13224D() != null) {
            if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(strM12105n)) {
                ((OneCameraProxy) this.f10852cd).m13224D().m12146a(strM12105n).m12150b(string).m12149b(iM13329a2).m12154d(-1).m12147a(true).m12144a();
                this.mCameraUIManager.mo18183c().m14255i(true);
            } else if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(string)) {
                ((OneCameraProxy) this.f10852cd).m13224D().m12146a(strM12105n).m12150b(string).m12145a(iM13329a).m12151c(-1).m12147a(false).m12148b();
                this.mCameraUIManager.mo18183c().m14255i(false);
            }
            CameraLog.m12967f("CameraManager", "multiCameraDecision: " + ((OneCameraProxy) this.f10852cd).m13224D());
        }
        CameraLog.m12959b("CameraManager", "onCaptureModeChanged, beforeModeName: " + strM12105n + ", beforeModeProperCameraId: " + iM13329a + ", afterModeName: " + string + ", afterModeProperCameraId: " + iM13329a2);
        if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(strM12105n)) {
            this.f10772bB = false;
        }
        boolean zM11945bp2 = this.mModeManager.m11945bp();
        if (iM13329a == iM13329a2 || this.f10760ap || this.f10852cd == null || (c2586n = this.f10913dm) == null) {
            z4 = false;
            z5 = false;
        } else {
            c2586n.m11004a(new C2587o().m11023a(strM12105n).m11028b(string).m11021a(iM13329a).m11026b(iM13329a2).m11031c(iM12067e).m11024a(zM11945bp).m11029b(zM11945bp2).m11022a(baseModeM11800a3).m11027b(baseModeM11800a2));
            z4 = false;
            this.f10724aF = false;
            z5 = true;
        }
        if (this.f10741aW) {
            baseModeM11800a2.changeModeAllViewWhenAnimation(18, z4);
            baseMode = baseModeM11800a2;
            this.mModeManager.m11895b(18, true);
            this.mModeManager.m11895b(19, true);
            this.mCameraUIManager.mo18172b(string, true);
        } else {
            baseMode = baseModeM11800a2;
        }
        CameraLog.m12959b("CameraManager", "onCaptureModeChanged, modeChange: " + zM10262a + ", hasOpenCamera: " + z5);
        if (zM10262a || m10223U()) {
            CameraLog.m12954a("CameraManager", "onCaptureModeChanged, isPreviewStopped: " + m10223U() + ", isAsync: " + z);
            m10370k(0);
            C2586n c2586n2 = this.f10913dm;
            if (c2586n2 != null && !z5) {
                c2586n2.m11004a(new C2587o().m11023a(strM12105n).m11028b(string).m11021a(iM13329a).m11026b(iM13329a2).m11031c(iM12067e).m11024a(zM11945bp).m11029b(zM11945bp2).m11022a(baseModeM11800a3).m11027b(baseMode));
                this.f10724aF = false;
            }
            if (!z) {
                m10302al();
            }
        } else {
            m10302al();
        }
        if (!z && !this.f10929eC.m11000d()) {
            this.mModeManager.m11895b(1, true);
            m10335c(false);
            m9926cH();
            this.mCameraUIManager.mo18200d(true, false);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TELE_SMALL_PREVIEW_SUPPORT)) {
            m10277aM();
        }
        m10273aI();
        CameraLog.m12967f("CameraManager", "CameraTest Camera Mode Change End, isAsync: " + z);
    }

    /* renamed from: P */
    public int m10218P() {
        Size sizeM11796a = this.mModeManager.m11796a(this.f10853ce);
        return (sizeM11796a == null || !Util.m24292a(sizeM11796a)) ? 10 : 9;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m10345e(int OplusGLSurfaceView_13) {
        this.f10985u = -1;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m10352f(int OplusGLSurfaceView_13) {
        this.f10984t = OplusGLSurfaceView_13;
        if (this.f10863co != null) {
            if (!this.f10760ap && m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
                this.f10863co.m14679a(this.f10984t);
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM)) {
                this.f10863co.m14686b(this.f10984t);
            }
        }
        if (this.mModeManager != null) {
            this.mModeManager.m11806a(this.f10984t);
        }
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19621E(this.f10984t);
        }
        PreviewEffectProcess interfaceC3423t = this.f10864cp;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22824d(this.f10984t);
        }
        WatchAgentContract.IntrinsicsJvm.kt_4 bVar = this.f10892dR;
        if (bVar != null) {
            bVar.mo24729a(this.f10984t);
        }
        if (this.f10865cq != null) {
            this.f10865cq.m23673b(OplusGLSurfaceView_13);
        }
        if (this.f10866cr != null && this.mCameraUIManager != null) {
            this.f10866cr.m11493a(m10300aj().mo16574b(this.f10984t), true);
        }
        QrCodeManager viewOnClickListenerC2609aa = this.f10908dh;
        if (viewOnClickListenerC2609aa != null) {
            viewOnClickListenerC2609aa.m11207a(OplusGLSurfaceView_13);
        }
        if (this.f10874cz != null) {
            this.f10874cz.m17980a(OplusGLSurfaceView_13);
        }
        if (this.f10852cd == null || this.f10846cX.m13317J() != 2 || m10224V()) {
            return;
        }
        this.f10852cd.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf(m10016d(this.f10990z, this.f10984t)));
        this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m10357g(int OplusGLSurfaceView_13) {
        PreviewEffectProcess interfaceC3423t = this.f10864cp;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22827e(OplusGLSurfaceView_13);
        }
        if (-1 == OplusGLSurfaceView_13) {
            return;
        }
        this.f10987w = OplusGLSurfaceView_13;
        if (!m10327b(CameraUIInterface.KEY_GRADIENTER) || !"on".equals(this.f10850cb.getString(CameraUIInterface.KEY_GRADIENTER, "off")) || !m10222T() || this.mCameraUIManager == null || this.f10866cr == null || this.mModeManager == null) {
            return;
        }
        this.mCameraUIManager.m19661a(OplusGLSurfaceView_13, this.f10866cr.m11528j(), this.mModeManager.m12105n());
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m10361h(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "onBatteryChanged, level: " + OplusGLSurfaceView_13 + ", sbLowBatteryState: " + Camera.f10610l);
        if (this.mModeManager != null) {
            int i2 = this.mModeManager.m12091j(CameraUIInterface.KEY_TIME_LAPSE_PRO) ? 5 : 2;
            int i3 = R.string.camera_low_battery_rec_disabled_time_lapse;
            if (OplusGLSurfaceView_13 > i2) {
                this.mModeManager.m12106n(false);
                CameraUIManager c3208d = this.mCameraUIManager;
                if (!this.mModeManager.m12091j(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
                    i3 = R.string.camera_low_battery_rec_disabled;
                }
                c3208d.mo18067a(i3);
            } else {
                this.mModeManager.m12106n(true);
                if (this.mModeManager.m11861aV()) {
                    this.mModeManager.m12103m(false);
                    if (this.mModeManager.m12091j(CameraUIInterface.KEY_QUICK_VIDEO)) {
                        this.mCameraUIManager.mo18280w();
                        LockViewDragLayout.setVolumeDownState(false);
                    }
                    this.mCameraUIManager.mo18070a(this.mModeManager.m12091j(CameraUIInterface.KEY_TIME_LAPSE_PRO) ? R.string.camera_low_battery_rec_disabled_time_lapse : R.string.camera_low_battery_rec_disabled, -1, true, false, false);
                    m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_VIDEO);
                }
            }
        }
        if (OplusGLSurfaceView_13 > 15) {
            if (Camera.f10610l) {
                Camera.f10610l = false;
                Camera.f10612n = false;
                if (this.f10752ah || this.mCameraUIManager == null) {
                    return;
                }
                this.mCameraUIManager.mo18067a(R.string.camera_low_battery_flash_disable);
                if (m9950cT()) {
                    this.mCameraUIManager.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                }
                this.mCameraUIManager.mo18171b(CameraUIInterface.KEY_VIDEO_FLASH_MODE, (String) null);
                return;
            }
            return;
        }
        if (Camera.f10610l) {
            return;
        }
        Camera.f10610l = true;
        Camera.f10612n = true;
        try {
            if (this.mCameraUIManager == null || this.f10752ah || this.f10852cd == null || this.f10856ch == null || this.mModeManager == null || this.mModeManager.m11871af()) {
                return;
            }
            if (!this.f10747ac) {
                if (this.mModeManager != null && !this.mModeManager.m11791W() && !"off".equals(this.f10852cd.mo13125q())) {
                    this.f10852cd.mo13069b("off");
                    this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                } else {
                    this.f10811bo = true;
                }
            } else if (m10327b(CameraFunction.TORCH_SOFT_LIGHT) && this.mModeManager != null && !this.mModeManager.m11791W() && !"off".equals(this.f10852cd.mo13125q())) {
                this.f10852cd.mo13069b("off");
                this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            m9793bA();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m10377m(boolean z) {
        CameraLog.m12954a("CameraManager", "setBurstCaptureEnable, enable: " + z + ", mbBurstShot: " + this.f10766av);
        m10379n(z);
        if (CameraMotorManager.m13703a(this.f10849ca.getApplicationContext()).m13709a()) {
            if (z) {
                CameraMotorManager.m13703a(this.f10849ca.getApplicationContext()).m13717g();
            } else {
                CameraMotorManager.m13703a(this.f10849ca.getApplicationContext()).m13715e();
            }
        }
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d == null || z) {
            return;
        }
        interfaceC2694d.mo13101i();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m10379n(boolean z) {
        this.f10766av = z;
        if (this.f10766av) {
            return;
        }
        this.f10736aR = -1L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10248a(Storage.CameraPicture cameraPicture, boolean z) throws IOException {
        CameraLog.m12954a("CameraManager", "storeImagePictureTakenDone, mJpegRotation: " + this.f10983s + ", orientation: " + cameraPicture.f12147t + ", mbBurstShot: " + this.f10766av + ", jpegName: " + cameraPicture.mPath + ", mbPaused: " + this.f10752ah + ", picture.mFormat: " + cameraPicture.f12135h + ", checkPause: " + z);
        if (this.f10752ah && z) {
            return;
        }
        m9694a(cameraPicture);
        m10360h();
        boolean z2 = false;
        this.f10699G = 0;
        cameraPicture.f12146s = this.f10989y;
        if (this.f10846cX.m13317J() == 1) {
            if (LocationManager.m16155a() != null && "on".equals(LocationManager.m16155a().m16182e())) {
                cameraPicture.f12131d = LocationManager.m16155a().m16180c();
            }
            if (!this.f10766av && (this.mModeManager == null || !this.mModeManager.m11861aV() || !cameraPicture.f12135h.equalsIgnoreCase("raw"))) {
                z2 = true;
            }
            if (this.mCameraUIManager != null) {
                cameraPicture.f12148u = this.mCameraUIManager.m19746bF();
            }
            if (this.mModeManager != null) {
                cameraPicture.f12136i = this.mModeManager.m12105n();
                cameraPicture.f12126X = this.mModeManager.m11917bN();
            }
            if (0 == cameraPicture.f12139l) {
                cameraPicture.f12139l = System.currentTimeMillis();
            }
            if (z2) {
                cameraPicture.f12152y = new Thumbnail.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.CameraManager.20
                    @Override // com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_4
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo10413a(final Thumbnail c3203e) {
                        if (CameraManager.this.f10849ca != null) {
                            CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (CameraManager.this.mCameraUIManager != null) {
                                        CameraManager.this.mCameraUIManager.m19678a(c3203e);
                                    }
                                }
                            });
                        }
                    }
                };
            }
        }
        m9783b(cameraPicture);
        this.f10969ev.mo10408a(cameraPicture);
        if (Storage.f12097w != 0) {
            return;
        }
        m9804bG();
        CameraLog.m12954a("CameraManager", "storeImagePictureTakenDone X");
    }

    /* renamed from: Q */
    public void m10219Q() {
        if (this.f10752ah || this.f10905de == null || this.f10849ca == null) {
            return;
        }
        CameraLog.m12954a("CameraManager", "doAttach, mCropValue: " + this.f10784bN + ", mSaveUri: " + this.f10843cU + ", mJpegImageData: " + this.f10905de.length + ", mResultState: " + this.f10710R);
        if (-1 == this.f10710R) {
            this.f10849ca.setResult(-1, this.f10840cR);
            this.f10849ca.finish();
            return;
        }
        if (this.f10710R == 0) {
            this.f10849ca.setResult(0);
            this.f10849ca.finish();
        } else if (1000 == this.f10710R) {
            if (this.f10840cR != null) {
                this.f10849ca.startActivityForResult(this.f10840cR, 1000);
            } else {
                this.f10849ca.setResult(0);
                this.f10849ca.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bV */
    public void m9834bV() {
        StringBuilder sb = new StringBuilder();
        sb.append("saveCropImage, mCropValue: ");
        sb.append(this.f10784bN);
        sb.append(", mSaveUri: ");
        sb.append(this.f10843cU);
        sb.append(", mJpegImageData: ");
        byte[] bArr = this.f10905de;
        sb.append(bArr == null ? null : Integer.valueOf(bArr.length));
        CameraLog.m12954a("CameraManager", sb.toString());
        this.f10796bZ.close();
        this.f10840cR = null;
        this.f10710R = 0;
        new Thread(new Runnable() { // from class: com.oplus.camera.CameraManager.21
            @Override // java.lang.Runnable
            public void run() throws IOException {
                byte[] bArr2 = CameraManager.this.f10905de;
                if (bArr2 == null) {
                    CameraManager.this.f10796bZ.open();
                    return;
                }
                String str = CameraManager.this.f10784bN;
                Uri uri = CameraManager.this.f10843cU;
                if (str == null) {
                    if (uri != null) {
                        Storage.m11112a(uri);
                        OutputStream outputStreamOpenOutputStream = null;
                        try {
                            try {
                                try {
                                    if (CameraManager.this.f10849ca != null) {
                                        outputStreamOpenOutputStream = CameraManager.this.f10849ca.getApplicationContext().getContentResolver().openOutputStream(uri);
                                        CameraLog.m12954a("CameraManager", "saveCropImage, open outputStream complete");
                                        if (outputStreamOpenOutputStream != null) {
                                            outputStreamOpenOutputStream.write(bArr2);
                                            CameraLog.m12954a("CameraManager", "saveCropImage, outputStream write complete");
                                            outputStreamOpenOutputStream.close();
                                        }
                                        CameraManager.this.f10710R = -1;
                                    }
                                } finally {
                                    Util.m24277a(outputStreamOpenOutputStream);
                                }
                            } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
                                CameraLog.m12967f("CameraManager", "saveCropImage, FileNotFoundException: " + COUIBaseListPopupWindow_8.getMessage());
                                CameraManager.this.f10840cR = CameraManager.this.m9647a(bArr2);
                                CameraManager.this.f10710R = -1;
                            }
                        } catch (IOException e2) {
                            CameraLog.m12965d("CameraManager", "saveCropImage, IOException error, exception: " + e2.getMessage(), e2);
                            e2.printStackTrace();
                            CameraManager.this.f10710R = 0;
                        } catch (SecurityException e3) {
                            CameraLog.m12967f("CameraManager", "saveCropImage, SecurityException error, exception: " + e3.getMessage());
                            CameraManager.this.f10710R = 0;
                        }
                    } else {
                        CameraManager cameraManager = CameraManager.this;
                        cameraManager.f10840cR = cameraManager.m9647a(bArr2);
                        CameraManager.this.f10710R = -1;
                    }
                } else if (CameraManager.this.f10849ca != null) {
                    File fileStreamPath = CameraManager.this.f10849ca.getFileStreamPath("crop-temp");
                    Intent intent = CameraManager.this.f10849ca.getIntent();
                    if (!DocumentUtil.m16203b(fileStreamPath.getAbsolutePath(), "image/jpeg", bArr2)) {
                        CameraManager.this.f10710R = 0;
                        CameraManager.this.f10796bZ.open();
                        return;
                    }
                    Uri uriFromFile = Uri.fromFile(fileStreamPath);
                    Bundle bundle = new Bundle();
                    if (CameraManager.this.f10784bN.equals("circle")) {
                        bundle.putString("circleCrop", "true");
                    }
                    if (uri != null) {
                        bundle.putParcelable("output", uri);
                    } else {
                        bundle.putBoolean("return-data", true);
                    }
                    CameraManager.this.f10840cR = new Intent("com.android.camera.action.CROP");
                    CameraManager.this.f10840cR.setData(uriFromFile);
                    if (intent != null) {
                        try {
                            if (intent.getExtras() != null) {
                                bundle.putInt("aspectX", intent.getExtras().getInt("aspectX"));
                                bundle.putInt("aspectY", intent.getExtras().getInt("aspectY"));
                                bundle.putInt("outputX", intent.getExtras().getInt("outputX"));
                                bundle.putInt("outputY", intent.getExtras().getInt("outputY"));
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            CameraManager.this.f10710R = 0;
                        }
                    }
                    CameraManager.this.f10840cR.setDataAndType(uriFromFile, "image/*");
                    CameraManager.this.f10840cR.putExtra("key_set_as_contract", "set_as_contract");
                    CameraManager.this.f10840cR.putExtras(bundle);
                    CameraManager.this.f10710R = 1000;
                }
                CameraManager.this.f10796bZ.open();
                CameraLog.m12954a("CameraManager", "saveCropImage, end");
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public Intent m9647a(byte[] bArr) {
        return new Intent("inline-data").putExtra("data", Util.m24373b(Util.m24224a(this.f10905de, 51200), Util.m24369b(bArr)));
    }

    /* renamed from: R */
    public int m10220R() {
        if (this.f10850cb != null) {
            return Integer.parseInt(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0)));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bW */
    public void m9836bW() {
        C2579g c2579g = this.f10973ez;
        c2579g.f11164a = false;
        c2579g.f11165b = false;
        c2579g.f11166c = false;
        if (c2579g.f11167d != null) {
            this.f10973ez.f11167d.recycle();
            this.f10973ez.f11167d = null;
        }
    }

    /* renamed from: S */
    public void m10221S() {
        CameraLog.m12954a("CameraManager", "setSwitchPreviewCb, mCameraSwitch: " + this.f10973ez);
        CameraLog.m12952a("CaptureOnePreview");
        this.mCameraUIManager.mo18088a(new SurfaceTextureScreenNail.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.CameraManager.22
            @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo10414a(Integer num, Bitmap bitmap, long OplusGLSurfaceView_15, long j2, CaptureResult captureResult) {
                CameraLog.m12958b("CaptureOnePreview");
                if (!CameraManager.this.f10752ah && CameraManager.this.f10973ez != null) {
                    int iM10218P = CameraManager.this.m10218P();
                    final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / iM10218P, bitmap.getHeight() / iM10218P, false);
                    CameraManager.this.f10932eF.removeMessages(1);
                    if (CameraManager.this.f10932eF != null) {
                        CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.22.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraManager.this.f10973ez != null) {
                                    CameraManager.this.f10973ez.f11167d = bitmapCreateScaledBitmap;
                                    CameraManager.this.f10973ez.f11164a = true;
                                    if (CameraManager.this.f10973ez.f11165b) {
                                        CameraManager.this.m9839bX();
                                    }
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                CameraLog.m12967f("CameraManager", "setSwitchPreviewCb, onPreviewCaptured, mCameraSwitch is null");
            }
        }, false, false, SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14252c);
        this.f10973ez.f11166c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bX */
    public void m9839bX() {
        C2579g c2579g = this.f10973ez;
        if (c2579g == null || !c2579g.f11164a || this.f10752ah) {
            CameraLog.m12966e("CameraManager", "onSwitchPreviewData, invalid data");
            return;
        }
        CameraLog.m12954a("CameraManager", "onSwitchPreviewData, getCurrentModeName: " + this.mModeManager.m12105n());
        Bitmap bitmap = this.f10973ez.f11167d;
        Bitmap bitmapM24219a = Util.m24219a(bitmap, 25.0f);
        if (this.mCameraUIManager != null && this.mCameraUIManager.mo18183c() != null) {
            this.mCameraUIManager.mo18183c().m23463a(bitmapM24219a, this.f10989y);
        }
        if (bitmap != null) {
            bitmap.recycle();
        }
        m9836bW();
        if (this.mCameraUIManager != null) {
            this.mModeManager.m11895b(2, false);
            this.mCameraUIManager.mo18227i(false);
            this.mCameraUIManager.mo18231j(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9669a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        if (this.f10752ah || !this.f10801be) {
            CameraLog.m12967f("CameraManager", "onCameraIdChange, mbPaused: " + this.f10752ah + ", mbFrameAvailable: " + this.f10801be);
            return;
        }
        if (this.mModeManager.isNoneSatUltraWideAngleOpen() && this.f10850cb != null) {
            m10359g(true);
            this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            m10359g(false);
        }
        if (this.mModeManager.m12006co() && this.f10850cb != null) {
            m10359g(true);
            this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
            m10359g(false);
        }
        CameraLog.m12967f("CameraManager", "CameraTest Camera Switch Start, cameraId: " + OplusGLSurfaceView_13);
        CameraPerformance.m15185a("switch_camera");
        m10340d(true);
        this.mCameraUIManager.m19641W(false);
        this.mCameraUIManager.mo18200d(false, false);
        this.mCameraUIManager.m19721at(true);
        this.mCameraUIManager.mo18248n(false, false);
        if (this.mModeManager.m11917bN()) {
            this.mCameraUIManager.mo18282w(true);
        }
        this.f10700H = 0;
        this.f10865cq.m23704q();
        m10367j(3);
        this.mCameraUIManager.m19783bv();
        if (z || z2) {
            if (this.f10973ez == null) {
                this.f10973ez = new C2579g();
            }
            if (this.f10973ez.f11164a) {
                m9839bX();
            } else {
                if (!this.f10973ez.f11166c) {
                    m10221S();
                }
                this.f10973ez.f11165b = true;
                this.f10932eF.removeMessages(1);
                this.f10932eF.sendEmptyMessageDelayed(1, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        } else {
            switchCamera(OplusGLSurfaceView_13);
            this.mCameraUIManager.m19641W(true);
            this.mCameraUIManager.mo18200d(true, true);
        }
        m9593D(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m10364i(int OplusGLSurfaceView_13) {
        String strM12105n = this.mModeManager.m12105n();
        if (m10262a(strM12105n, OplusGLSurfaceView_13)) {
            m9824bQ();
        }
        SharedPreferences.Editor editorEdit = this.f10850cb.edit();
        editorEdit.putString(CameraUIInterface.KEY_CAMERA_MODE, strM12105n);
        editorEdit.apply();
    }

    public void switchCamera(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "switchCamera, cameraId: " + OplusGLSurfaceView_13 + ", mbPaused: " + this.f10752ah);
        this.f10909di = null;
        if (this.f10752ah) {
            return;
        }
        CameraLog.m12954a("CameraManager", "startOperation, cameraId: " + OplusGLSurfaceView_13);
        FluencyPerformance.m15133b(System.currentTimeMillis(), true);
        this.f10813bq = this.f10989y != OplusGLSurfaceView_13;
        this.f10770az = this.f10989y != OplusGLSurfaceView_13;
        String strM12105n = this.mModeManager.m12105n();
        this.mCameraUIManager.m19729b(OplusGLSurfaceView_13, strM12105n);
        this.mCameraUIManager.m19884db();
        this.mCameraUIManager.m19903du();
        this.mCameraUIManager.m19711aj(true);
        this.mCameraUIManager.mo18210f(9, true);
        this.mCameraUIManager.m19894dl();
        m9886bw();
        m9784b(strM12105n, OplusGLSurfaceView_13);
        this.f10850cb.setLocalId(this.f10849ca, OplusGLSurfaceView_13);
        this.mModeManager.m11957c(OplusGLSurfaceView_13);
        m10364i(OplusGLSurfaceView_13);
        this.mModeManager.m11775G();
        if (this.mModeManager.m12082h()) {
            m10377m(false);
        }
        this.mCameraUIManager.m19826cc();
        this.mCameraUIManager.m19828ce();
        this.mCameraUIManager.m19908dz();
        this.mCameraUIManager.m19778bq();
        this.mCameraUIManager.m19761bU();
        this.mCameraUIManager.mo18056R(this.mModeManager.m12091j(CameraFunction.OUT_PREVIEW_ENABLE));
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.24
            @Override // java.lang.Runnable
            public void run() {
                CameraManager.this.mCameraUIManager.mo18249o();
                if (CameraManager.this.f10865cq != null) {
                    CameraManager.this.f10865cq.m23698k(false);
                }
            }
        });
        m10178t(OplusGLSurfaceView_13);
        this.f10864cp.mo22793a(this.mModeManager.m12105n(), OplusGLSurfaceView_13);
        m9589C(this.mModeManager.m12091j(CameraUIInterface.KEY_TORCH_MODE));
        this.mModeManager.m12094k(true);
        InverseManager.INS.setMaskAlpha(this.f10849ca, false, false);
        m10374l(1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m9784b(String str, int OplusGLSurfaceView_13) {
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        Size sizeM11796a = this.mModeManager.m11796a(m10166r(this.f10846cX.m13329a(str, OplusGLSurfaceView_13)));
        int iM11789U = this.mModeManager.m11789U();
        Size sizeM11795a = this.mModeManager.m11795a(sizeM11796a);
        if (sizeM11795a != null) {
            sizeM11796a = sizeM11795a;
        }
        CameraPreviewUI viewOnLayoutChangeListenerC3444gM19749bI = this.mCameraUIManager.m19749bI();
        if (viewOnLayoutChangeListenerC3444gM19749bI != null) {
            viewOnLayoutChangeListenerC3444gM19749bI.m23339a(sizeM19747bG, sizeM11796a, iM11789U, iM11789U);
        }
    }

    /* renamed from: t */
    private void m10178t(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "setCameraId, mCameraId: " + this.f10989y + ", cameraId: " + OplusGLSurfaceView_13);
        if (this.f10989y == OplusGLSurfaceView_13) {
            return;
        }
        this.f10989y = OplusGLSurfaceView_13;
        this.f10747ac = CameraCharacteristicsUtil.m12974a(this.f10989y);
        if (this.mModeManager != null) {
            this.mModeManager.m11957c(this.f10989y);
        }
        if (this.f10864cp != null && this.mModeManager != null) {
            this.f10864cp.mo22793a(this.mModeManager.m12105n(), OplusGLSurfaceView_13);
        }
        if (this.f10850cb != null) {
            this.f10850cb.setLocalId(this.f10849ca, this.f10989y);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m10367j(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "setCameraState, state: " + this.f10982r + "->" + OplusGLSurfaceView_13);
        this.f10982r = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bY */
    public boolean m9840bY() {
        return this.f10726aH;
    }

    /* renamed from: T */
    public boolean m10222T() {
        return this.f10982r == 1;
    }

    /* renamed from: U */
    public boolean m10223U() {
        return this.f10982r == 0;
    }

    /* renamed from: V */
    public boolean m10224V() {
        return this.f10982r == 2;
    }

    /* renamed from: W */
    public boolean m10225W() {
        return this.f10982r == 3;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m10370k(int OplusGLSurfaceView_13) {
        this.f10755ak = OplusGLSurfaceView_13;
        if (this.f10865cq != null) {
            this.f10865cq.m23684e(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: X */
    public boolean m10226X() {
        return this.f10728aJ;
    }

    @Override // com.oplus.camera.PreviewImageProcess.IntrinsicsJvm.kt_4
    /* renamed from: Y */
    public boolean mo10227Y() {
        return this.f10752ah;
    }

    /* renamed from: Z */
    public boolean m10228Z() {
        return this.f10804bh;
    }

    @Override // com.oplus.camera.PreviewImageProcess.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo10243a(Size size, Size size2, CameraPreviewUI.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        if (this.f10865cq != null) {
            this.f10865cq.m23698k(false);
        }
        if (!this.mCameraUIManager.mo19881dY()) {
            this.mCameraUIManager.mo18227i(false);
        }
        if (Util.m24495t()) {
            this.mCameraUIManager.m19647a((byte) 2, false);
        }
        this.mCameraUIManager.m19990y(true, false);
        this.mCameraUIManager.mo18249o();
        this.mCameraUIManager.m19838co();
        this.mCameraUIManager.m19669a(size, size2, aVar, OplusGLSurfaceView_13, i2, i3, z);
        this.mCameraUIManager.mo18231j(false);
    }

    @Override // com.oplus.camera.PreviewImageProcess.IntrinsicsJvm.kt_4
    /* renamed from: aa */
    public void mo10291aa() {
        this.f10741aW = true;
        m9702a(true, false, false);
        m10302al();
        this.mCameraUIManager.mo18258q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bZ */
    public void m9842bZ() {
        this.f10908dh.m11213b();
        this.f10908dh.m11206a();
        this.f10908dh.m11216c(m10380n() && m9891by());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10249a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        if (this.f10752ah || this.f10762ar || this.f10760ap || this.f10852cd == null) {
            CameraLog.m12967f("CameraManager", "onPreviewCaptureResult, mOneCamera: " + this.f10852cd + ", mbCaptureModeChanging: " + this.f10762ar + ", mbSwitchingCamera: " + this.f10760ap + ", mbPaused: " + this.f10752ah);
            return;
        }
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f("CameraManager", "onPreviewCaptureResult, previewResult: " + cameraPreviewResult);
            return;
        }
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        int iM9896c = m9896c(cameraPreviewResult);
        int iM10018d = m10018d(cameraPreviewResult);
        if (5 == m9764b(cameraPreviewResult)) {
            m9963ca();
        }
        CaptureMsgData captureMsgData = this.f10789bS;
        if (captureMsgData != null) {
            captureMsgData.mHdrScope = String.valueOf(cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_HDR_SCOPE));
        }
        if (iM9896c >= 0 && this.mModeManager != null && this.mModeManager.m11840aA() && !this.mModeManager.m11791W()) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || this.mModeManager.m11841aB()) {
                m10088e(iM9896c, iM10018d);
            } else if (12 != iM9896c) {
                m10088e(0, iM10018d);
            }
        }
        Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13239E);
        if (this.mCameraUIManager != null && objM13005a != null && (objM13005a instanceof int[])) {
            int[] iArr = (int[]) objM13005a;
            if (iArr.length > 0) {
                int OplusGLSurfaceView_13 = iArr[0];
                this.f10812bp = OplusGLSurfaceView_13 == 1;
                if (this.f10812bp) {
                    CameraLog.m12959b("CameraManager", "onPreviewCaptureResult, apertureSwitchValue: " + OplusGLSurfaceView_13);
                    this.mCameraUIManager.mo18183c().m23481n(false);
                } else {
                    this.mCameraUIManager.mo18183c().m23481n(true);
                }
            }
        }
        Object objM13005a2 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13244J);
        if (objM13005a2 != null && (objM13005a2 instanceof int[])) {
            int[] iArr2 = (int[]) objM13005a2;
            this.f10817bu = (iArr2.length > 0 ? iArr2[0] : 0) == 1;
        } else {
            this.f10817bu = false;
        }
        Object objM13005a3 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13245K);
        if (objM13005a3 != null && (objM13005a3 instanceof Integer)) {
            m9668a(((Integer) objM13005a3).intValue(), true);
        }
        Object objM13005a4 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13246L);
        if (objM13005a4 != null && (objM13005a4 instanceof Integer)) {
            Integer num = (Integer) objM13005a4;
            if (2 == num.intValue() || 100 == num.intValue()) {
                if (this.f10849ca == null || this.f10849ca.isFinishing()) {
                    return;
                } else {
                    this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CameraManager.this.f10849ca == null || CameraManager.this.f10849ca.isFinishing()) {
                                return;
                            }
                            CameraManager.this.f10849ca.finish();
                        }
                    });
                }
            }
        }
        Object objM13005a5 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13304aq);
        if (objM13005a5 != null && (objM13005a5 instanceof int[])) {
            int[] iArr3 = (int[]) objM13005a5;
            if (1 == iArr3[2] && !this.f10778bH) {
                if (this.f10782bL) {
                    this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.PREVIEW_IN_PREVIEW_ENABLE, (CameraParameter.PreviewKey<String>) "on");
                    this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                    this.f10778bH = true;
                }
                this.f10781bK = true;
            } else if (1 != iArr3[2] && this.f10781bK) {
                this.f10781bK = false;
            }
        }
        if (this.mModeManager != null) {
            this.mModeManager.m11824a(cameraPreviewResult);
        }
    }

    /* renamed from: ca */
    private void m9963ca() {
        CameraLog.m12959b("CameraManager", "new gesture open hand");
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.26
            @Override // java.lang.Runnable
            public void run() {
                boolean zM11974cI = CameraManager.this.mModeManager.m11974cI();
                if (!CameraManager.this.f10752ah && zM11974cI && !CameraManager.this.m10312av() && CameraManager.this.mCameraUIManager.m19758bR() && !"gesture".equals(CameraManager.this.f10881dG) && !CameraManager.this.mCameraUIManager.m19862dF() && !CameraManager.this.m10224V()) {
                    CameraManager.this.f10881dG = "gesture";
                    CameraManager.this.f10749ae = true;
                    String strM9937cN = CameraManager.this.m9937cN();
                    if (!"off".equals(strM9937cN)) {
                        CameraManager.this.m10022d(strM9937cN, false);
                    }
                    CameraManager.this.f10749ae = false;
                    CameraManager.this.f10856ch.mo9570p();
                    return;
                }
                CameraLog.m12954a("CameraManager", "new gesture open Hand, isSupportGestureCapture: " + zM11974cI + ", isTimerSnapShotRunning: " + CameraManager.this.m10312av() + ", isCameraShutterButtonEnabled: " + CameraManager.this.mCameraUIManager.m19758bR() + ", mShutterType: " + CameraManager.this.f10881dG + ", isHeadlineScrolling: " + CameraManager.this.mCameraUIManager.m19862dF() + ", isSnapShotProgress: " + CameraManager.this.m10224V());
            }
        });
        CameraLog.m12959b("CameraManager", "new gesture open hand X");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m9764b(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_GESTURE_DETECT_IN_APS) || cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_GESTURE_ACTION_TYPE) == null) {
            return -1;
        }
        return ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_GESTURE_ACTION_TYPE)).intValue();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m9896c(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        int[] iArr;
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (AlgoSwitchConfig.getApsVersion() <= 2) {
            Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13297aj);
            if (objM13005a == null || !(objM13005a instanceof int[]) || (iArr = (int[]) objM13005a) == null || iArr.length <= 0) {
                return -1;
            }
            return iArr[0];
        }
        if (cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_AI_SCENE) != null) {
            return ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_AI_SCENE)).intValue();
        }
        return -1;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m10018d(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        if (AlgoSwitchConfig.getApsVersion() != 3 || cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_TUNING_SCENE) == null) {
            return 0;
        }
        return ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_TUNING_SCENE)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m10088e(int OplusGLSurfaceView_13, int i2) {
        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && !this.mCameraUIManager.m19634R(OplusGLSurfaceView_13)) || ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_AUTO_MICRO) && 18 == OplusGLSurfaceView_13) || ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_SCENE_NIGHT_SUPPORT) && 12 == OplusGLSurfaceView_13 && ApsConstant.CAPTURE_MODE_COMMON.equals(this.mModeManager.m12105n())) || ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y) && 12 == OplusGLSurfaceView_13) || this.mCameraUIManager.m19864dH())))) {
            OplusGLSurfaceView_13 = 0;
        }
        if (OplusGLSurfaceView_13 == 0 || this.f10700H == 0) {
            this.f10730aL = true;
        }
        if (this.mCameraUIManager == null || this.mCameraUIListener == null || 18 == OplusGLSurfaceView_13 || !this.f10730aL) {
            return;
        }
        if (this.f10700H == OplusGLSurfaceView_13 && this.f10701I == i2 && (this.mCameraUIManager.mo18158av() || this.mCameraUIManager.mo18131aU() || OplusGLSurfaceView_13 <= 0)) {
            return;
        }
        CameraLog.m12954a("CameraManager", "updateAIScene, aiScnValue: " + OplusGLSurfaceView_13 + ", aiTuningValue: " + i2);
        m10186v(OplusGLSurfaceView_13);
        if (18 != this.f10700H || OplusGLSurfaceView_13 != 0) {
            this.f10700H = OplusGLSurfaceView_13;
        }
        this.f10701I = i2;
        this.mCameraUIManager.mo18242m(OplusGLSurfaceView_13);
        boolean zM19633Q = this.mCameraUIManager.m19633Q(this.f10700H);
        if (this.f10852cd != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.AI_PHOTO, (CameraParameter.PreviewKey<String>) (zM19633Q ? "on" : "off"));
        }
        int i3 = this.f10700H;
        if (i3 > 0) {
            this.mCameraUIListener.mo10682a(i3, zM19633Q, false);
            if (16 == this.f10700H && i2 != 0 && m10327b(CameraFunction.PF_V3)) {
                this.f10702J = m10180u(i2);
                int i4 = this.f10702J;
                if (i4 != 0) {
                    m9697a("ai_scene", String.valueOf(i4));
                    return;
                }
                return;
            }
            m9697a("ai_scene", String.valueOf(this.f10700H));
            return;
        }
        this.mCameraUIListener.mo10682a(0, false, false);
    }

    /* renamed from: v */
    private void m10186v(int OplusGLSurfaceView_13) {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || this.mCameraUIManager == null) {
            return;
        }
        if (m10190w(OplusGLSurfaceView_13)) {
            this.mCameraUIManager.m19965j(OplusGLSurfaceView_13, !this.mModeManager.m11917bN());
        } else if (18 == OplusGLSurfaceView_13) {
            this.mCameraUIManager.m19965j(18, this.f10768ax);
        }
    }

    /* renamed from: w */
    private boolean m10190w(int OplusGLSurfaceView_13) {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION) ? 12 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13 || 16 == OplusGLSurfaceView_13 || 17 == OplusGLSurfaceView_13 || 10 == OplusGLSurfaceView_13 : 12 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m10336c(boolean z, boolean z2) {
        CameraLog.m12954a("CameraManager", "setAEAFLocked, locked: " + z + ", update: " + z2);
        if (this.mModeManager.m11791W()) {
            CameraLog.m12954a("CameraManager", "setAEAFLocked, isCapturing, so return!");
            return;
        }
        CameraLog.m12952a("setAEAFLocked");
        if (this.mCameraUIManager != null) {
            if (z) {
                this.f10755ak = 0;
                this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.27
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.mCameraUIManager != null) {
                            CameraManager.this.mCameraUIManager.m19797c(true, CameraManager.this.f10865cq.m23655O(), CameraManager.this.f10865cq.m23643C());
                        }
                    }
                });
                if (m10327b(CameraUIInterface.KEY_FLASH_MODE) && "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_FLASH_MODE, this.f10849ca.getString(R.string.camera_flash_mode_default_value)))) {
                    SharedPreferences.Editor editorEdit = this.f10850cb.edit();
                    editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
                    editorEdit.apply();
                    this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.28
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CameraManager.this.mCameraUIManager != null) {
                                CameraManager.this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
                            }
                        }
                    });
                }
            } else {
                this.mCameraUIManager.m19848cy();
            }
            if (this.f10865cq != null) {
                this.f10865cq.m23688f(z);
            }
        }
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13071b(z, true);
            if (z2) {
                this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
        CameraLog.m12958b("setAEAFLocked");
    }

    /* renamed from: ab */
    public void m10292ab() {
        if (!this.f10739aU || this.f10760ap) {
            return;
        }
        if (this.f10804bh) {
            this.mCameraUIManager.m19790c(300L);
        }
        this.f10965er = false;
        this.mCameraUIManager.mo18088a(new SurfaceTextureScreenNail.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.CameraManager.29
            @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo10414a(Integer num, Bitmap bitmap, long OplusGLSurfaceView_15, long j2, CaptureResult captureResult) {
                CameraPreviewUI.m23262c(bitmap);
                CameraManager.this.f10964eq.open();
                CameraManager.this.f10965er = true;
            }
        }, false, false, SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14254e);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m10114h(String str) {
        if (str == null || str.equals(this.f10788bR)) {
            return;
        }
        CameraLog.m12954a("CameraManager", "setCameraTriggerShutterType, shutterTriggerType: " + this.f10788bR + " -> " + str);
        this.f10788bR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m10194x(int OplusGLSurfaceView_13) {
        if (Util.m24459h("oplus.software.fingerprint.shutter")) {
            if (this.f10833cK == null) {
                this.f10833cK = new OplusFingerprintManager(this.f10849ca.getApplicationContext());
                this.f10706N = Util.m24464j("KEYCODE_SYSTEM_FINGERPRINT_KEYMODE");
            }
            if (this.f10833cK == null || !"on".equals(this.f10787bQ)) {
                return;
            }
            try {
                this.f10833cK.setFingerKeymode(OplusGLSurfaceView_13, -1);
            } catch (NoSuchMethodError unused) {
                CameraLog.m12967f("CameraManager", "setFingerKeymode, OplusFingerprintManager NoSuchMethodError");
            }
            CameraLog.m12954a("CameraManager", "setFingerKeymode, enable: " + OplusGLSurfaceView_13);
        }
    }

    /* renamed from: o */
    public void m10382o(boolean z) {
        CameraLog.m12954a("CameraManager", "onPause, mbSwitchingCamera: " + this.f10760ap + ", mCameraId: " + this.f10989y);
        this.f10850cb.edit().putInt(CameraUIInterface.KEY_CAMERA_PID_HISTORY, Process.myPid()).apply();
        m10194x(0);
        this.f10918dr = (byte) 0;
        if (!this.f10804bh && !this.f10805bi) {
            this.f10954eg.m16304f();
            this.f10824cB.m11261a();
            if (this.f10895dU) {
                this.f10846cX.m13332a(false);
            }
        }
        this.f10727aI = false;
        if (m10050df()) {
            SharedPreferences.Editor editorEdit = this.f10850cb.edit();
            editorEdit.putString(CameraUIInterface.KEY_LAST_CAMERA_GESTURE_SHUTTER, this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.f10849ca.getString(R.string.camera_gesture_shutter_default_value)));
            editorEdit.apply();
        }
        this.f10752ah = true;
        this.f10807bk = false;
        this.f10800bd = false;
        this.f10801be = false;
        this.f10822bz = false;
        this.f10771bA = false;
        this.f10960em = Double.NaN;
        this.f10961en = Double.NaN;
        this.f10924dx = false;
        this.f10926dz = false;
        this.f10950ec = false;
        this.f10957ej = false;
        this.f10873cy = "";
        this.f10872cx = "";
        AISSnapshotManager c2629b = this.f10868ct;
        if (c2629b != null) {
            c2629b.m11650c();
        }
        if (m9861bj()) {
            if (this.mModeManager != null) {
                this.f10815bs = this.mModeManager.isNoneSatUltraWideAngleOpen();
            }
            this.f10816bt = m9965cb();
            this.f10850cb.edit().putFloat(CameraUIInterface.KEY_ZOOM, this.f10870cv).apply();
            if (this.f10814br && this.mModeManager != null) {
                this.mModeManager.m11800a(this.mModeManager.m12105n()).resetMonoFilter();
            }
        }
        if (!this.f10805bi && !this.f10804bh) {
            this.f10813bq = true;
            m10056di();
            this.mCameraUIManager.m19877dU();
        }
        m10003cu();
        this.f10880dF = System.currentTimeMillis();
        m10157p(3);
        m10372l(false);
        ApsService apsService = this.f10876dB;
        m10253a((apsService == null || apsService.isApsProcessing()) ? false : true);
        this.mModeManager.m11873ah();
        m9877br();
        FossManager fossManager = this.f10825cC;
        if (fossManager != null) {
            fossManager.enableFoss();
        }
        if (this.f10826cD != null && m10312av()) {
            this.f10826cD.m19333f();
        }
        m10347e(false);
        this.f10738aT = false;
        this.f10973ez = null;
        this.f10755ak = 0;
        m10336c(false, false);
        this.f10766av = false;
        this.f10905de = null;
        this.f10812bp = false;
        this.f10884dJ = null;
        synchronized (this.f10978n) {
            this.f10882dH = 3;
        }
        this.mCameraUIListener.mo10686a((DetectResult) null);
        if (this.f10907dg != null && this.f10907dg.m14790b()) {
            m10381o();
        }
        m10398w(false);
        this.f10909di = null;
        this.f10927eA = -1;
        WatchAgentContract.IntrinsicsJvm.kt_4 bVar = this.f10892dR;
        if (bVar != null) {
            bVar.mo24734b();
        }
        PreviewImageProcess c3591z = this.f10931eE;
        if (c3591z != null) {
            c3591z.m24835a();
            this.f10931eE = null;
        }
        this.f10932eF.removeMessages(9);
        this.f10932eF.removeMessages(11);
        this.f10932eF.removeMessages(22);
        this.f10932eF.removeMessages(24);
        this.f10761aq = false;
        this.f10846cX.m13362z();
        this.f10846cX.m13356t();
        C2586n c2586n = this.f10913dm;
        if (c2586n != null) {
            c2586n.m11016j();
        }
        this.mModeManager.m11875aj();
        if (this.f10865cq != null) {
            this.f10865cq.m23680d();
        }
        m10307aq();
        this.f10739aU = false;
        if (!z) {
            m10371k(false);
        }
        ImageSaverThread.m14696a().m14698c();
        CallGalleryPreDecodeThread.m14689a().m14695c();
        this.f10932eF.removeCallbacksAndMessages(null);
        Util.m24490q();
        AsyncTask asyncTask = this.f10823cA;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f10823cA = null;
        }
        if (this.f10907dg != null) {
            this.f10907dg.m14791c();
        }
        m9972ce();
        if (this.f10866cr != null) {
            this.f10866cr.m11534n();
        }
        if (this.f10874cz != null) {
            this.mCameraUIManager.mo18066a().m14132a(new Runnable() { // from class: com.oplus.camera.CameraManager.30
                @Override // java.lang.Runnable
                public void run() {
                    CameraManager.this.f10874cz.m17988e();
                }
            });
        }
        this.mCameraUIManager.m19735b(this.mModeManager.m12076g(), m10047de());
        long jM19615B = this.mCameraUIManager.m19615B(CameraScreenNail.f14185a.intValue());
        this.mCameraUIManager.mo18075a(CameraScreenNail.f14185a.intValue(), 0L, 0L);
        if (0 != jM19615B) {
            m9671a(jM19615B, Util.m24246a(this.mModeManager.m12043dc()), true, false, false);
        }
        if (m10207E()) {
            this.mCameraUIManager.m19859dC();
            if (this.mCameraUIManager.mo18183c() != null) {
                this.mCameraUIManager.mo18183c().m23492w();
            }
        }
        this.f10724aF = false;
        this.f10929eC.m10999c();
        if (this.f10867cs != null) {
            this.f10867cs.onPause();
        }
        if (LocationManager.m16155a() != null) {
            LocationManager.m16155a().m16179b(this.f10946eT);
        }
        TemperatureProvider c3559c = this.f10888dN;
        if (c3559c != null) {
            c3559c.m24666a(false);
            this.f10888dN.m24665a("off");
        }
        QrCodeManager viewOnClickListenerC2609aa = this.f10908dh;
        if (viewOnClickListenerC2609aa != null) {
            viewOnClickListenerC2609aa.m11221f();
        }
        TeleSmallPreviewManager c3431ab = this.f10869cu;
        if (c3431ab != null) {
            c3431ab.m23008e();
        }
        if (this.f10827cE != null && m9936cM()) {
            this.f10827cE.m19258c();
        }
        SoloopManager c2963b = this.f10915do;
        if (c2963b != null) {
            c2963b.m16730b();
        }
        if (this.f10760ap) {
            this.mCameraUIManager.m19964j(-1, -1);
            InverseManager.INS.setMaskAlpha(this.f10849ca, true, false);
        }
        PopUpWindowManager.m20708b(this.f10942eP);
        this.f10700H = 0;
        if (this.f10805bi) {
            if (this.f10747ac || !"off".equals(this.mModeManager.m11787S())) {
                CameraMotorManager.m13703a(this.f10849ca.getApplicationContext()).m13717g();
            }
        } else {
            CameraMotorManager.m13703a(this.f10849ca.getApplicationContext()).m13716f();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TELE_SMALL_PREVIEW_SUPPORT)) {
            m10277aM();
        }
        if (Util.m24495t() && this.f10824cB != null) {
            this.f10824cB.m11265b(4);
        }
        DiagnosisTools.m13370a();
        CameraLog.m12954a("CameraManager", "onPause X");
    }

    /* renamed from: cb */
    private boolean m9965cb() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off"));
    }

    /* renamed from: cc */
    private void m9968cc() {
        CameraLog.m12954a("CameraManager", "exitOneCamera");
        m10367j(4);
        this.f10875dA = true;
        if (this.mModeManager != null) {
            this.mModeManager.m11925bV();
            this.mModeManager.m12128t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m10198y(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "closeImageReader, role: " + OplusGLSurfaceView_13);
        this.f10852cd.mo13064b(OplusGLSurfaceView_13);
        ModeFacade c3020t = this.f10914dn;
        if (c3020t != null && 1 == OplusGLSurfaceView_13) {
            c3020t.m17211m();
        }
        CameraLog.m12954a("CameraManager", "closeImageReader X, role: " + OplusGLSurfaceView_13);
    }

    /* renamed from: cd */
    private void m9970cd() {
        this.f10713U = System.currentTimeMillis();
        this.f10715W = 0L;
        this.f10716X = 0L;
        this.f10714V = 0L;
        m10360h();
        this.f10699G = 0;
    }

    /* renamed from: ce */
    private void m9972ce() {
        m10360h();
        this.f10699G = 0;
        this.f10713U = 0L;
        this.f10714V = 0L;
        this.f10715W = 0L;
        this.f10716X = 0L;
    }

    public boolean onBackPressed() {
        if (!m10222T() && (!m10223U() || this.f10846cX.m13317J() != 2)) {
            if (!(this.mModeManager != null ? this.mModeManager.m11985cT() : false) && this.mModeManager != null && !this.mModeManager.m12105n().equals(ApsConstant.REC_MODE_TIMELASPE_PRO)) {
                OneCamera interfaceC2694d = this.f10852cd;
                if (interfaceC2694d != null) {
                    interfaceC2694d.mo13110l().post(new Runnable() { // from class: com.oplus.camera.CameraManager.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CameraManager.this.mModeManager != null) {
                                CameraManager.this.mModeManager.m12075f(false);
                            }
                        }
                    });
                }
                CameraLog.m12954a("CameraManager", "onBackPressed, cameraState return");
                if (this.f10856ch != null) {
                    this.f10856ch.mo9570p();
                }
                return false;
            }
        }
        if (this.mCameraUIManager != null && this.mCameraUIManager.m19803cF() && this.mModeManager != null && !this.mModeManager.m11946bq()) {
            CameraLog.m12954a("CameraManager", "onBackPressed, mCameraUIManager return");
            if (this.f10856ch != null) {
                this.f10856ch.mo9570p();
            }
            return false;
        }
        if (this.f10826cD != null && m10312av() && this.mCameraUIManager != null) {
            this.f10881dG = "normal";
            m9583B(0);
            this.f10826cD.m19333f();
            this.mCameraUIManager.mo18107a(true, false);
            this.mCameraUIManager.mo18175b(true, false);
            this.mCameraUIManager.mo18191c(true, false);
            this.mCameraUIManager.mo18213f(true, false);
            if (this.f10856ch != null) {
                this.f10856ch.mo9570p();
            }
            return false;
        }
        if (m10206D()) {
            return false;
        }
        if (this.mModeManager != null && !m10206D() && this.mModeManager.m12098l()) {
            CameraLog.m12954a("CameraManager", "onBackPressed, Capmode processing other,so return");
            if (this.f10856ch != null) {
                this.f10856ch.mo9570p();
            }
            return false;
        }
        if (this.f10922dv) {
            CameraLog.m12954a("CameraManager", "onBackPressed, Taking pictures, so return");
            if (this.f10856ch != null) {
                this.f10856ch.mo9570p();
            }
            return false;
        }
        if (m9861bj() && !m9840bY()) {
            CameraLog.m12954a("CameraManager", "onBackPressed, Thumbnail is processing, so return");
            return false;
        }
        this.f10814br = false;
        TeleSmallPreviewManager c3431ab = this.f10869cu;
        if (c3431ab != null && c3431ab.m23003b()) {
            this.f10869cu.m22998a(false, false, false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cf */
    public void m9973cf() {
        CameraLog.m12954a("CameraManager", "backToLastMode");
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19863dG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cg */
    public void m9976cg() {
        if (this.f10849ca == null) {
            return;
        }
        try {
            RegionCommonFeatureAdapter.m14524a(this.f10849ca);
            if (this.f10850cb != null) {
                this.f10850cb.edit().putBoolean(CameraUIInterface.KEY_ENTRY_BREENO_SCAN, true).apply();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$p */
    private class C2588p implements ModeTypeChangedListener {
        private C2588p() {
        }

        /* synthetic */ C2588p(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.control.ModeTypeChangedListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11034a(String str) {
            boolean z;
            CameraLog.m12954a("CameraManager", "onModeTypeChanged, switch mode to: " + str);
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11846aG();
                CameraManager.this.mModeManager.m11847aH();
                if (ApsConstant.CAPTURE_MODE_MORE.equals(str)) {
                    if (CameraManager.this.f10908dh != null) {
                        CameraManager.this.f10908dh.m11216c(false);
                    }
                    CameraManager.this.m9977ch();
                    CameraManager.this.m9832bU();
                    if (CameraManager.this.f10908dh != null) {
                        CameraManager.this.f10908dh.m11216c(false);
                    }
                    if (CameraManager.this.mCameraUIManager != null) {
                        CameraManager.this.mCameraUIManager.m19632P(CameraManager.this.f10989y);
                        CameraManager.this.mCameraUIManager.m19867dK();
                    }
                    CameraManager.this.m9605H(true);
                    CameraManager.this.mCameraUIManager.mo18177b(R.string.camera_mode_more);
                    PreferenceManager.m3981a(CameraManager.this.f10849ca).edit().putBoolean("more_menu_reddot_show", false).apply();
                    return;
                }
                if (CameraManager.this.mModeManager.m12105n().equals(str)) {
                    if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19864dH()) {
                        CameraManager.this.mCameraUIManager.m19866dJ();
                        CameraManager.this.mCameraUIManager.m19853d(true, -1);
                        CameraManager.this.m9701a(true, true, -1);
                    }
                } else {
                    if (CameraManager.this.mCameraUIManager != null && CameraManager.this.m10327b(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU)) {
                        CameraManager.this.mCameraUIManager.mo18041J(false);
                    }
                    if (CameraManager.this.mCameraUIManager == null || !CameraManager.this.mCameraUIManager.m19864dH()) {
                        z = false;
                    } else {
                        CameraManager.this.mCameraUIManager.m19866dJ();
                        CameraManager.this.mCameraUIManager.m19693a(false, str, 2);
                        CameraManager.this.m9701a(false, false, 2);
                        z = true;
                    }
                    CameraManager.this.m9700a(true, CameraUIInterface.KEY_CAMERA_MODE);
                    CameraManager.this.m10328b(str, z);
                    CameraManager.this.m9700a(false, (String) null);
                }
                Util.m24253a(HeadlineHelper.m20347b(str), CameraManager.this.f10849ca, CameraManager.this.f10747ac);
                return;
            }
            CameraLog.m12967f("CameraManager", "onModeTypeChanged, ModeManager is null, CameraManager has been destroyed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9700a(boolean z, String str) {
        HintManager c3130aMo18233k;
        if (this.mCameraUIManager == null || (c3130aMo18233k = this.mCameraUIManager.mo18233k()) == null) {
            return;
        }
        c3130aMo18233k.m18488a(z);
        c3130aMo18233k.m18492b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ch */
    public void m9977ch() {
        if (this.mModeManager != null) {
            this.mModeManager.m12042db();
        }
        if (this.f10865cq != null) {
            this.f10865cq.m23696j(true);
            this.f10865cq.m23687f(8);
            if (!m10396v() && m10069dp()) {
                this.f10865cq.m23699l();
            }
        }
        this.mCameraUIManager.mo18210f(9, true);
        m10236a((AnimatorListenerAdapter) null, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9701a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "onMoreModeHidden, needDisplayHint: " + z + ", needUpdateOpticalZoomMenu: " + z2 + ", hideReason: " + OplusGLSurfaceView_13);
        if (this.mModeManager != null) {
            this.mModeManager.m12129u(OplusGLSurfaceView_13);
            m9589C(this.mModeManager.m12091j(CameraUIInterface.KEY_TORCH_MODE));
        }
        this.mCameraUIManager.mo18242m(this.f10700H);
        if (this.mModeManager != null && z) {
            this.mModeManager.m11783O();
        }
        if (this.f10865cq != null) {
            this.f10865cq.m23696j(false);
            if (this.f10895dU && m10396v()) {
                this.f10865cq.m23687f(0);
            }
        }
        if (z2) {
            if (this.f10866cr != null && this.mModeManager != null && 1 == OplusGLSurfaceView_13 && (this.f10813bq || !this.f10814br)) {
                ZoomConfigure c2614afM12012cu = this.mModeManager.m12012cu();
                if ((c2614afM12012cu != null && c2614afM12012cu.m11341f()) || this.mModeManager.m12013cv() || m9965cb() || (c2614afM12012cu.m11309G() && !c2614afM12012cu.m11311H())) {
                    this.f10866cr.m11490a(ZoomManager.f12334a, false);
                } else {
                    this.f10866cr.m11490a(m10009cx(), false);
                }
            }
            m9926cH();
        }
        if (this.f10908dh != null) {
            m9842bZ();
        }
    }

    /* renamed from: ac */
    public void m10293ac() {
        SharedPreferences sharedPreferences = this.f10851cc;
        String string = null;
        if (sharedPreferences != null) {
            string = sharedPreferences.getString("director_filter_switch", null);
            CameraLog.m12954a("CameraManager", "updateDirectorFilterFromRUS, directorFilterModeSwitch: " + string);
        }
        if (string != null) {
            if (TextUtils.equals(string, "on")) {
                CameraConfig.setConfigBooleanValue(ConfigDataBase.KEY_DIRECTOR_FILTER_RUS, true);
            } else {
                CameraConfig.setConfigBooleanValue(ConfigDataBase.KEY_DIRECTOR_FILTER_RUS, false);
            }
        }
        FilterHelper.m22599a();
        FilterHelper.m22621b();
    }

    /* renamed from: ad */
    public void m10294ad() {
        SharedPreferences sharedPreferences = this.f10851cc;
        String string = null;
        if (sharedPreferences != null) {
            string = sharedPreferences.getString("sticker_switch", null);
            CameraLog.m12954a("CameraManager", "updateStickerModeFromRUS, stikerModeSwitch: " + string);
        }
        if (string != null) {
            if (TextUtils.equals(string, "on")) {
                CameraConfig.setConfigBooleanValue(ConfigDataBase.KEY_STICKER, true);
            } else {
                CameraConfig.setConfigBooleanValue(ConfigDataBase.KEY_STICKER, false);
            }
        }
    }

    /* renamed from: ae */
    public void m10295ae() {
        boolean zM10262a;
        CameraLog.m12952a("CameraManager.onCreate");
        if (Util.m24495t()) {
            Util.m24386b(new Size(0, 0));
        }
        m10294ad();
        m10293ac();
        m9982cj();
        this.f10864cp = new PreviewEffectProcessImpl(this.f10849ca);
        this.f10864cp.mo22791a(this.f10936eJ);
        this.f10864cp.mo22789a(this.f10935eI);
        C24971 c24971 = null;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM)) {
            this.f10863co = new FrontCameraZoomManager();
            this.f10863co.m14680a(this.f10846cX.m13317J(), this.f10939eM);
            this.f10863co.m14681a(new C2581i(this, c24971));
        }
        this.mCameraUIManager = new CameraUIManager(this.f10849ca, this.f10850cb, this.mCameraUIListener, this.f10890dP);
        this.mCameraUIManager.m19617C(this.f10846cX.m13317J());
        this.mCameraUIManager.m19675a(this.mCameraControlButtonListener);
        this.mCameraUIManager.m19677a(new C2588p(this, c24971));
        this.mCameraUIManager.m19680a(this.f10945eS);
        this.mCameraUIManager.m19732b(this.f10944eR);
        this.mCameraUIManager.m19683a(this.f10930eD);
        this.mCameraUIManager.m19682a(this.f10864cp);
        this.mCameraUIManager.m19684a(new Runnable() { // from class: com.oplus.camera.CameraManager.35
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.f10965er) {
                    return;
                }
                CameraManager.this.f10964eq.close();
                CameraManager.this.f10964eq.block(100L);
            }
        });
        this.mModeManager.m11816a(this.f10939eM, this.mCameraUIManager, this.f10864cp);
        CameraLog.m12967f("CameraManager", "onCreate, camera manager mode: " + this.f10846cX.m13340d());
        this.mModeManager.m12093k(this.f10846cX.m13340d());
        this.mModeManager.m11818a(this.f10852cd);
        if (this.f10954eg.m16295a()) {
            zM10262a = m10262a(ApsConstant.CAPTURE_MODE_COMMON, 1);
        } else {
            zM10262a = m10262a(this.f10846cX.m13340d(), this.f10989y);
        }
        this.f10795bY.open();
        CameraLog.m12954a("CameraManager", "onCreate, open the block");
        this.mCameraUIManager.m19772bk();
        if (Util.m24495t() && 2 != this.f10846cX.m13317J() && 3 != this.f10846cX.m13317J()) {
            this.f10889dO.m16482a(this.f10984t, this.f10989y, false, true);
            this.f10727aI = true;
        }
        if (-1 != this.f10990z) {
            this.mCameraUIManager.m19613A(m9894c(this.f10990z, 0));
        }
        this.mModeManager.m12060dt();
        if (this.f10853ce != null) {
            this.mCameraUIManager.m19792c(this.mModeManager.m11796a(this.f10853ce));
        }
        if (zM10262a) {
            m9824bQ();
        }
        this.f10864cp.mo22790a(this.mModeManager.m12000ci());
        this.mCameraUIManager.m19681a(this.mModeManager.m12000ci());
        this.mCameraUIManager.m19773bl();
        this.f10865cq = new FocusManager(this.f10849ca, this.f10850cb, this.f10941eO);
        this.f10865cq.m23659a(this.f10846cX.m13317J());
        if (-1 != this.f10990z) {
            this.f10865cq.m23678c(m10171s(this.f10990z));
        }
        this.f10865cq.m23656a();
        this.f10865cq.m23667a(this.f10747ac);
        m9870bo();
        this.f10888dN.m24664a();
        m9956cW();
        ImageSaverThread.m14696a().m14708d();
        this.f10864cp.mo22793a(this.mModeManager.m12105n(), this.f10989y);
        if (this.mModeManager.m11832a()) {
            this.mCameraUIManager.m19974o(this.f10849ca.getString(HeadlineHelper.m20344a(this.mModeManager.m12105n())));
            this.mCameraUIManager.m19736b(false, 0);
        }
        this.f10721aC = Util.m24459h("oplus.software.vibrator_lmvibrator");
        this.f10832cJ = new TemperatureNotificationManager(this.f10849ca.getApplicationContext(), this.f10940eN);
        this.f10719aA = TextUtils.isEmpty(this.f10850cb.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, ""));
        this.f10720aB = TextUtils.isEmpty(this.f10850cb.getString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, ""));
        if (this.f10915do != null) {
            this.mCameraUIManager.m19674a(this.f10915do);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TELE_SMALL_PREVIEW_SUPPORT)) {
            this.f10869cu = new TeleSmallPreviewManager(this.f10849ca, this.mCameraUIListener);
            this.f10869cu.m22996a(this.mCameraUIManager.m19748bH());
            this.f10869cu.m22997a(this.mCameraUIManager.m19749bI());
            this.f10869cu.m22994a(this.mCameraUIManager.m19747bG());
            m10277aM();
            m10127j(this.f10870cv);
        }
        CameraLog.m12958b("CameraManager.onCreate");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10239a(Intent intent) {
        this.f10813bq = true;
        if ((intent != null && intent.hasExtra("com.android.systemui.camera_launch_source")) || this.f10846cX.m13326S() || this.f10846cX.m13324Q() || ((intent != null && "quick_launch_from_framework".equals(intent.getStringExtra("android_camera_launch_type"))) || (intent != null && "com.oplus.gesture".equals(intent.getStringExtra("extra_key_caller_package_name"))))) {
            m10297ag();
        }
        if (this.f10846cX.m13359w()) {
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.36
                @Override // java.lang.Runnable
                public void run() {
                    CameraManager.this.m9996cq();
                }
            }, "clearLockDB");
            this.f10920dt = true;
        }
        if (this.mModeManager != null) {
            String strM13340d = this.f10846cX.m13340d();
            if (this.mModeManager.m11800a(strM13340d) == null) {
                this.mModeManager.m12093k(strM13340d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ci */
    public void m9980ci() {
        if (this.mModeManager == null || this.mModeManager.m12082h() || !this.mModeManager.m12091j(CameraFunction.SAT_CAMERA) || !this.mModeManager.isNoneSatUltraWideAngleOpen()) {
            return;
        }
        this.f10822bz = true;
        this.f10771bA = true;
        this.f10850cb.edit().remove(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9672a(SharedPreferences sharedPreferences, boolean z) {
        HintManager c3130aMo18233k = this.mCameraUIManager != null ? this.mCameraUIManager.mo18233k() : null;
        if (c3130aMo18233k != null && z) {
            c3130aMo18233k.m18488a(true);
            c3130aMo18233k.m18492b(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        editorEdit.apply();
        if (c3130aMo18233k == null || !z) {
            return;
        }
        c3130aMo18233k.m18488a(false);
        c3130aMo18233k.m18492b((String) null);
    }

    /* renamed from: af */
    public void m10296af() {
        this.f10822bz = true;
    }

    /* renamed from: cj */
    private void m9982cj() {
        if (this.f10850cb != null && this.f10850cb.getBoolean("pref_camera_statement_agree", false) && Util.m24320aI() && 1 == this.f10846cX.m13317J()) {
            m10152o(2);
        }
    }

    /* renamed from: ck */
    private void m9984ck() {
        float COUIBaseListPopupWindow_12 = Settings.System.getInt(this.f10849ca.getContentResolver(), "oplus.camera.brightness", this.f10981q);
        float f2 = Settings.System.getInt(this.f10849ca.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, 130);
        if (f2 > COUIBaseListPopupWindow_12) {
            CameraLog.m12959b("CameraManager", "decreaseBrightnessOnHighTemperature, maxBrightness: " + COUIBaseListPopupWindow_12 + ", currentBrightness: " + f2);
            m10230a(COUIBaseListPopupWindow_12 / ((float) this.f10981q));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0205  */
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10341d(boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.CameraManager.m10341d(boolean, boolean):void");
    }

    /* renamed from: cl */
    private boolean m9986cl() throws NoSuchMethodException, SecurityException {
        try {
            OplusBluetoothAdapter oplusBluetoothAdapter = OplusBluetoothAdapter.getOplusBluetoothAdapter();
            Method declaredMethod = OplusBluetoothAdapter.class.getDeclaredMethod("isBluetoothRecordConnected", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(oplusBluetoothAdapter, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: ag */
    public void m10297ag() {
        m10383p(true);
    }

    /* renamed from: p */
    public void m10383p(boolean z) {
        this.f10850cb.edit().remove(CameraUIInterface.KEY_ZOOM).apply();
        this.f10850cb.edit().remove(CameraUIInterface.KEY_ZOOM_FROM_OTHER_APP).apply();
        this.f10774bD = false;
        if (this.mModeManager != null && this.mModeManager.m12105n() != null && !this.mModeManager.m12057dq() && !this.mModeManager.m11976cK() && !this.f10846cX.m13355s()) {
            Util.m24416c(new Runnable() { // from class: com.oplus.camera.-$$Lambda$CameraManager$MiR4DwKnczpbA3zff4EXs2n3c-Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m10077dt();
                }
            });
            return;
        }
        if (z && this.mModeManager != null && this.mModeManager.m12057dq() && m10327b(CameraUIInterface.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && m10327b(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            Util.m24416c(new Runnable() { // from class: com.oplus.camera.-$$Lambda$CameraManager$QEUkMkJg37fIfnvl9_JlbI5UDb8
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m10076ds();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dt */
    public /* synthetic */ void m10077dt() {
        m10359g(true);
        this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
        m10359g(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ds */
    public /* synthetic */ void m10076ds() {
        this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
    }

    /* renamed from: cm */
    private boolean m9988cm() {
        int OplusGLSurfaceView_13 = this.f10850cb.getInt(CameraUIInterface.KEY_CAMERA_PID_HISTORY, 0);
        int iMyPid = Process.myPid();
        CameraLog.m12954a("CameraManager", "isCurrentPid, oldPid: " + OplusGLSurfaceView_13 + ", currentPid: " + iMyPid);
        return OplusGLSurfaceView_13 == iMyPid;
    }

    /* renamed from: q */
    public void m10385q(boolean z) {
        this.f10846cX.m13335b(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m9708a(BaseMode baseMode) {
        if (baseMode.isMicroscopeMode()) {
            return true;
        }
        if ((ApsConstant.CAPTURE_MODE_TILT_SHIFT.equals(baseMode.getCameraMode()) || ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO.equals(baseMode.getCameraMode())) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_FAST_VIDEO)) {
            return true;
        }
        return baseMode.isStarryMode() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m10123i(String str) {
        if (ApsConstant.REC_MODE_MICROSCOPE.equals(str)) {
            return true;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO) && ApsConstant.REC_MODE_STAR_VIDEO.equals(str)) {
            return true;
        }
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_FAST_VIDEO) && ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO.equals(str);
    }

    /* renamed from: cn */
    private void m9990cn() {
        String string;
        SharedPreferences sharedPreferences = this.f10851cc;
        if (sharedPreferences != null) {
            string = sharedPreferences.getString("video_blur_switch", "on");
            CameraLog.m12966e("CameraManager", "updateVideoBlurFromRUS, videoBlurSwitch: " + string);
        } else {
            string = "on";
        }
        this.f10818bv = TextUtils.equals(string, "on");
        this.mModeManager.m12124s(this.f10818bv);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* renamed from: ah */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10298ah() {
        /*
            Method dump skipped, instructions count: 1232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.CameraManager.m10298ah():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: co */
    public int m9991co() {
        int iM13343f = this.f10846cX.m13343f();
        if (7 == this.f10846cX.m13342e() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT)) {
            return FilterHelper.m22641o();
        }
        return (8 == this.f10846cX.m13342e() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT)) ? FilterHelper.m22640n() : iM13343f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cp */
    public void m9994cp() {
        this.f10866cr = new ZoomManager(this.f10849ca, this.f10850cb, this.f10939eM, this.mCameraUIManager.mo18163b(), this.f10890dP);
        this.f10866cr.m11509c(this.mCameraUIManager.mo18163b().getLayoutDirection());
        this.f10866cr.m11496a(new C2581i(this, null));
        this.f10866cr.m11493a(m10300aj().mo16574b(this.f10984t), false);
        this.f10866cr.m11513d(this.f10927eA);
        this.f10866cr.m11492a(m10300aj().mo16539j(), m10300aj().mo16570k());
        this.f10866cr.m11505b(this.mCameraUIManager.mo18163b());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m10318b(float COUIBaseListPopupWindow_12) {
        updateZoom(COUIBaseListPopupWindow_12, false);
    }

    public void updateZoom(float COUIBaseListPopupWindow_12, boolean z) {
        m10233a(COUIBaseListPopupWindow_12, z, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10233a(float COUIBaseListPopupWindow_12, boolean z, boolean z2) {
        if (z2) {
            m10232a(COUIBaseListPopupWindow_12, z);
        }
        m9770b(COUIBaseListPopupWindow_12, true);
        ScreenModeManager c2953g = this.f10890dP;
        if (c2953g != null && c2953g.mo16411a().mo16631r()) {
            m10104g(COUIBaseListPopupWindow_12);
            return;
        }
        if (m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH) || this.f10939eM.mo10515aQ() || (this.mCameraUIManager != null && !this.mCameraUIManager.mo18051O() && !this.mCameraUIManager.mo18053P())) {
            m10104g(COUIBaseListPopupWindow_12);
            return;
        }
        if (this.f10890dP == null || 1 != m10300aj().mo16539j() || !this.f10762ar || this.mCameraUIManager == null) {
            return;
        }
        if (this.mCameraUIManager.mo18051O() || this.mCameraUIManager.mo18053P()) {
            m10104g(COUIBaseListPopupWindow_12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m10104g(final float COUIBaseListPopupWindow_12) {
        if (this.f10849ca == null) {
            return;
        }
        this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.37
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.f10752ah) {
                    return;
                }
                CameraLog.m12952a("updateZoomView");
                if (CameraManager.this.f10866cr == null) {
                    CameraManager.this.m9994cp();
                }
                if (CameraManager.this.mModeManager != null) {
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.m10394u(cameraManager.mModeManager.m12029dF());
                }
                if (!CameraManager.this.f10846cX.m13346i() || !CameraManager.this.m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
                    CameraManager.this.f10866cr.m11489a(CameraManager.this.getMinZoomValue(), CameraManager.this.m10283aS(), COUIBaseListPopupWindow_12, CameraManager.this.f10853ce.m13269d(), CameraManager.this.mModeManager.m12012cu(), CameraManager.this.mModeManager.m11922bS());
                }
                CameraManager.this.m9584B(true);
                CameraManager.this.m9926cH();
                CameraLog.m12958b("updateZoomView");
            }
        });
    }

    /* renamed from: ai */
    public void m10299ai() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.38
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.f10752ah) {
                    return;
                }
                if (CameraManager.this.f10867cs == null) {
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.f10867cs = new TiltShiftManager(cameraManager.f10849ca, CameraManager.this.f10850cb, CameraManager.this.f10939eM, CameraManager.this.mCameraUIManager);
                }
                C24971 c24971 = null;
                if (CameraManager.this.mCameraUIManager == null || !CameraManager.this.mModeManager.m11849aJ()) {
                    CameraManager.this.f10867cs.setCameraTiltShiftListener(null);
                    return;
                }
                CameraManager.this.f10867cs.setCameraTiltShiftListener(new C2580h(CameraManager.this, c24971));
                if (CameraManager.this.mCameraUIManager.m19750bJ() == null || CameraManager.this.mCameraUIManager.m19747bG() == null) {
                    return;
                }
                CameraManager.this.f10867cs.initialize(CameraManager.this.mCameraUIManager.m19747bG(), CameraManager.this.mCameraUIManager.m19750bJ());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m9584B(final boolean z) {
        final int iM11908bE;
        Size sizeM19747bG = this.mCameraUIManager.m19747bG();
        if (sizeM19747bG != null && 4 == Util.m24426d(sizeM19747bG.getWidth(), sizeM19747bG.getHeight())) {
            iM11908bE = this.mModeManager.m11908bE() + ((int) (Util.getScreenWidth() * 0.11111111111111094d));
        } else {
            iM11908bE = this.mModeManager.m11908bE();
        }
        m10300aj().m16503a(this.f10866cr.m11518f(), this.f10849ca.findViewById(R.id_renamed.zoom_seek_bar_click), this.f10849ca.findViewById(R.id_renamed.zoom_seek_bar_display_text));
        m10300aj().mo16525a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.-$$Lambda$CameraManager$_OKM5nrAkrHzA-qJ85F2Wf67I5I
            @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
            public final void call(Object[] objArr) {
                this.COUIBaseListPopupWindow_12$0.m9670a(iM11908bE, z, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m9670a(int OplusGLSurfaceView_13, boolean z, Object[] objArr) {
        this.f10866cr.m11504b(OplusGLSurfaceView_13, z);
    }

    /* renamed from: aj */
    public BaseScreenMode m10300aj() {
        return this.f10890dP.mo16411a();
    }

    /* renamed from: ak */
    public void m10301ak() {
        CameraLog.m12954a("CameraManager", "onDestroy");
        this.f10878dD.open();
        this.f10753ai = true;
        this.f10959el = "";
        this.f10960em = Double.NaN;
        this.f10961en = Double.NaN;
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13070b(true);
        }
        CameraDataCollection.m24687b();
        FeatureFactory.m14365a().m14370b();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            ImageStickerTools.m22687b(this.f10849ca).m22721c(this.f10849ca);
        }
        WatchAgentContract.IntrinsicsJvm.kt_4 bVar = this.f10892dR;
        if (bVar != null) {
            bVar.mo24728a();
        }
        SandBoxContentProvider.m24647a(this.f10849ca);
        if (this.f10850cb != null) {
            m10056di();
        }
        if (this.f10874cz != null) {
            this.f10874cz.m17989f();
            this.f10874cz = null;
        }
        AISSnapshotManager c2629b = this.f10868ct;
        if (c2629b != null) {
            c2629b.m11651d();
            this.f10868ct = null;
        }
        if (this.f10826cD != null) {
            this.f10826cD.m19333f();
            this.f10826cD.m19325a();
            this.f10826cD = null;
        }
        if (this.f10828cF != null) {
            this.f10828cF.onDestroy();
            this.f10828cF = null;
        }
        if (this.mModeManager != null) {
            this.mModeManager.m11877al();
            this.mModeManager = null;
        }
        if (this.f10907dg != null) {
            this.f10907dg.m14792d();
            this.f10907dg = null;
        }
        this.f10863co = null;
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19780bs();
            this.mCameraUIManager = null;
        }
        if (this.f10865cq != null) {
            this.f10865cq.m23683e();
            this.f10865cq = null;
        }
        if (this.f10867cs != null) {
            this.f10867cs.onDestroy();
            this.f10867cs = null;
        }
        if (this.f10866cr != null) {
            this.f10866cr.m11538r();
            this.f10866cr = null;
        }
        if (this.f10839cQ != null) {
            this.f10839cQ.m11290b();
            this.f10839cQ = null;
        }
        TemperatureProvider c3559c = this.f10888dN;
        if (c3559c != null) {
            c3559c.m24668c();
            this.f10888dN = null;
        }
        if (this.f10832cJ != null) {
            this.f10832cJ.m24660c();
            this.f10832cJ = null;
        }
        TeleSmallPreviewManager c3431ab = this.f10869cu;
        if (c3431ab != null) {
            c3431ab.m23010f();
            this.f10869cu = null;
        }
        ScreenSwitchController c2932e = this.f10889dO;
        if (c2932e != null) {
            c2932e.m16480a();
            this.f10889dO = null;
        }
        m9858bi();
        m9879bs();
        ExecutorService executorService = this.f10980p;
        if (executorService != null) {
            executorService.shutdown();
        }
        RecordingStopCountDownTimer c3202d = this.f10827cE;
        if (c3202d != null) {
            c3202d.m19258c();
            this.f10827cE.m19253a();
            this.f10827cE = null;
        }
        if (this.f10862cn != null) {
            this.f10862cn.m24682f();
            this.f10862cn = null;
        }
        SoloopManager c2963b = this.f10915do;
        if (c2963b != null) {
            c2963b.m16731c();
            this.f10915do = null;
        }
        if (this.f10864cp != null) {
            this.f10864cp = null;
        }
        QrCodeManager viewOnClickListenerC2609aa = this.f10908dh;
        if (viewOnClickListenerC2609aa != null) {
            viewOnClickListenerC2609aa.m11222g();
            this.f10908dh = null;
        }
        FluencyPerformance.m15137d();
        this.f10970ew = null;
        this.f10738aT = false;
        this.f10849ca = null;
        this.f10856ch = null;
        this.f10835cM = null;
        this.f10833cK = null;
        this.f10916dp = null;
        this.f10831cI = null;
        if (Storage.m11134c()) {
            ThumbnailCacheUtil.m24610a().m24625c();
        } else {
            ThumbnailCacheUtil.m24610a().m24622b();
        }
        if (this.f10966es != null) {
            this.f10966es = null;
        }
        Handler handler = this.f10967et;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10967et = null;
        }
        HandlerThread handlerThread = this.f10968eu;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f10968eu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9668a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("CameraManager", "useIsoSetDisplay, messageType: " + OplusGLSurfaceView_13 + ", delay: " + z);
        CameraLog.m12952a("useIsoSetDisplay");
        if (this.f10802bf) {
            this.f10932eF.removeMessages(3);
            this.f10932eF.removeMessages(2);
            if (OplusGLSurfaceView_13 != 95) {
                if (OplusGLSurfaceView_13 == 96) {
                    if (z) {
                        this.f10932eF.sendEmptyMessageDelayed(2, 800L);
                    } else if (AppSettings.IntrinsicsJvm.kt_5.m24995b(this.f10849ca.getApplicationContext().getContentResolver(), f10690h, 0) == 2) {
                        AppSettings.IntrinsicsJvm.kt_5.m24996c(this.f10849ca.getApplicationContext().getContentResolver(), f10690h, 0);
                    }
                }
            } else if (z) {
                this.f10932eF.sendEmptyMessageDelayed(3, 800L);
            }
        }
        CameraLog.m12958b("useIsoSetDisplay");
    }

    /* renamed from: al */
    public void m10302al() {
        CameraLog.m12954a("CameraManager", "switchUIByCurrentModeType, getCurrentModeName: " + this.mModeManager.m12105n());
        this.mCameraUIManager.m19734b(this.mModeManager.m12076g());
        this.mCameraUIManager.m19685a(this.mModeManager.m12105n(), this.mModeManager.m12076g(), m10047de());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Size m9768b(BaseMode baseMode) {
        if (baseMode == null) {
            CameraLog.m12954a("CameraManager", "getModePreviewSize, mode: " + baseMode);
            return null;
        }
        baseMode.setCameraId(this.f10989y);
        baseMode.updateOneCamera(this.f10852cd);
        Size previewSize = baseMode.getPreviewSize(CameraCharacteristicsUtil.m12971a(baseMode.getCameraMode(), this.f10846cX.m13329a(baseMode.getCameraMode(), this.f10989y)));
        Size previewSurfaceSize = baseMode.getPreviewSurfaceSize(previewSize);
        if (previewSurfaceSize != null) {
            previewSize = previewSurfaceSize;
        }
        CameraLog.m12966e("CameraManager", "getModePreviewSize, previewSize: " + previewSize.getWidth() + "x" + previewSize.getHeight());
        return previewSize;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10244a(Size size, boolean z) {
        if (size == null) {
            return;
        }
        int iM24426d = Util.m24426d(size.getWidth(), size.getHeight());
        this.mCameraUIManager.m19959h(iM24426d, z);
        CameraLog.m12959b("CameraManager", "updateSettingControlBg, type: " + iM24426d + ", needControllerAnimation: " + z);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m10130j(String str) {
        BaseMode baseModeM11800a = this.mModeManager.m11800a(str);
        Size sizeM9768b = m9768b(baseModeM11800a);
        boolean z = !TextUtils.equals(baseModeM11800a.getCameraMode(), this.mModeManager.m12105n());
        if (sizeM9768b == null) {
            CameraLog.m12967f("CameraManager", "showCaptureModeChangeBlurAnim, null == newSize!");
            return false;
        }
        return m9705a(this.mCameraUIManager.m19747bG(), sizeM9768b, this.mModeManager.m11789U(), baseModeM11800a.getPreviewDispalyWidth(), z, 0, this.f10929eC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m9705a(Size size, Size size2, int OplusGLSurfaceView_13, int i2, boolean z, int i3, CameraPreviewUI.PlatformImplementations.kt_3 aVar) {
        int iMo10945b = aVar != null ? aVar.mo10945b() : -1;
        CameraLog.m12954a("CameraManager", "showBlurAnim, animType: " + iMo10945b + ", mbBlurAnimRunning: " + this.f10757am);
        if (this.f10752ah) {
            return false;
        }
        QrCodeManager viewOnClickListenerC2609aa = this.f10908dh;
        if (viewOnClickListenerC2609aa != null) {
            viewOnClickListenerC2609aa.m11216c(false);
        }
        if (this.f10757am && !this.mModeManager.m11780L()) {
            CameraLog.m12954a("CameraManager", "showBlurAnim, return!");
            return false;
        }
        if (this.f10931eE == null) {
            this.f10931eE = new PreviewImageProcess(this);
        }
        if (m10208F()) {
            this.f10931eE.m24838a(size, size2, z, i3);
        }
        if (!this.f10931eE.m24839a(aVar, OplusGLSurfaceView_13, i2, z)) {
            return false;
        }
        m10368j(true);
        m10339d(iMo10945b);
        this.f10932eF.removeMessages(13);
        this.f10932eF.removeMessages(23);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cq */
    public void m9996cq() {
        CameraLog.m12954a("CameraManager", "clearLockDB, mbLockDbCleared: " + this.f10920dt + ", mActivity: " + this.f10849ca);
        ContentProviderUtil.m24528a(Uri.parse("content://com.open.gallery.smart.provider/locked_pictures"), "0==0", (String[]) null);
    }

    /* renamed from: r */
    public void m10388r(boolean z) {
        this.f10743aY = z;
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19639U(this.f10743aY);
        }
    }

    /* renamed from: s */
    public void m10389s(boolean z) {
        if (((KeyguardManager) this.f10849ca.getApplicationContext().getSystemService("keyguard")).isKeyguardLocked()) {
            this.f10744aZ = true;
            if (z && !this.f10920dt) {
                CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.39
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraManager.this.m9996cq();
                    }
                }, "clearLockDB");
                m10392t(true);
            }
        } else {
            this.f10744aZ = false;
        }
        if (this.mModeManager != null) {
            this.mModeManager.m12097l(this.f10744aZ);
        }
    }

    /* renamed from: t */
    public void m10392t(boolean z) {
        CameraLog.m12954a("CameraManager", "updateLockDbClearFlag, clear: " + z);
        this.f10920dt = z;
    }

    /* renamed from: am */
    public boolean m10303am() {
        return this.f10744aZ;
    }

    /* renamed from: com.oplus.camera.CameraManager$COUIBaseListPopupWindow_11 */
    public class C2579g {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f11164a = false;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean f11165b = false;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean f11166c = false;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Bitmap f11167d = null;

        public C2579g() {
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m10374l(int OplusGLSurfaceView_13) {
        if (this.f10910dj == null) {
            this.f10910dj = new C2577e(this, null);
        }
        m10309as();
        boolean z = false;
        if (this.f10852cd == null) {
            this.f10852cd = MyApplication.m11085a();
            OneCamera interfaceC2694d = this.f10852cd;
            if (interfaceC2694d == null) {
                CameraLog.m12967f("CameraManager", "onResume, openCamera failed! mOneCamera is null.");
                return false;
            }
            interfaceC2694d.mo13024a(this.f10846cX.m13317J());
            ((OneCameraProxy) this.f10852cd).m13224D().m12155d();
            ((OneCameraProxy) this.f10852cd).m13224D().m12152c(this.f10846cX.m13340d());
        }
        int iM10306ap = m10306ap();
        CameraLog.m12959b("CameraManager", "openCamera, properCameraId: " + iM10306ap + ", cameraId: " + this.f10989y + ", openType: " + OplusGLSurfaceView_13);
        TemperatureProvider c3559c = this.f10888dN;
        if (c3559c != null) {
            this.f10852cd.mo13039a(c3559c);
        }
        if (this.f10849ca.getApplication() != null && (this.f10849ca.getApplication() instanceof MyApplication)) {
            ((MyApplication) this.f10849ca.getApplication()).m11105j();
        }
        this.f10703K = OplusGLSurfaceView_13;
        this.f10853ce = m10166r(iM10306ap);
        this.f10852cd.mo13037a(this.f10853ce);
        this.f10852cd.mo13113m();
        CameraLog.m12954a("CameraManager", "openCamera, not has close message now, normal open");
        this.f10852cd.mo13027a(iM10306ap, this.f10910dj, OplusGLSurfaceView_13);
        this.f10990z = iM10306ap;
        this.f10911dk++;
        if (this.f10865cq != null) {
            this.f10865cq.m23678c(m10171s(this.f10990z));
        }
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19613A(m9894c(this.f10990z, 0));
            if (Util.m24495t() && this.f10889dO != null) {
                this.f10890dP.m16660b(this.f10989y);
            }
        }
        this.f10809bm = true;
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.40
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.f10853ce != null) {
                    CameraManager.this.f10853ce.m13257a();
                    CameraManager.this.f10853ce.m13258a(256);
                    CameraManager.this.f10853ce.m13258a(32);
                    CameraLog.m12967f("CameraManager", "openCamera, preload finish");
                }
            }
        }, "pre init keys");
        if (4 != OplusGLSurfaceView_13 && 3 != OplusGLSurfaceView_13 && (1 != OplusGLSurfaceView_13 || this.f10770az)) {
            if (m10268aD() || (this.mModeManager != null && this.mModeManager.m12105n() == null && ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.f10846cX.m13340d()))) {
                z = true;
            }
            if (2 != OplusGLSurfaceView_13 || !m10327b(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
                Util.m24466j(z ? 1 : this.f10989y);
            }
        }
        return true;
    }

    /* renamed from: an */
    public int m10304an() {
        return this.f10846cX.m13329a(m10305ao(), this.f10989y);
    }

    /* renamed from: ao */
    public String m10305ao() {
        C2586n c2586n = this.f10913dm;
        String str = null;
        if (c2586n == null) {
            CameraLog.m12967f("CameraManager", "getCurrentSessionModeName, mModeChangeExecutor is null");
            return null;
        }
        C2587o c2587oM11014h = c2586n.m11014h();
        if (this.f10913dm != null && c2587oM11014h != null) {
            str = c2587oM11014h.f11190c;
        }
        return str == null ? this.f10846cX.m13340d() : str;
    }

    /* renamed from: ap */
    public int m10306ap() {
        C2586n c2586n = this.f10913dm;
        int OplusGLSurfaceView_13 = 0;
        if (c2586n == null) {
            CameraLog.m12967f("CameraManager", "getCurrentProperCameraId, mModeChangeExecutor is null");
            return 0;
        }
        C2587o c2587oM11014h = c2586n.m11014h();
        if (this.f10913dm != null && c2587oM11014h != null) {
            OplusGLSurfaceView_13 = c2587oM11014h.f11195h;
        }
        return OplusGLSurfaceView_13 == 0 ? this.f10846cX.m13329a(m10305ao(), this.f10989y) : OplusGLSurfaceView_13;
    }

    /* renamed from: aq */
    public void m10307aq() {
        Util.m24470k(this.f10989y);
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.STATISTICS_FACE_DETECT_MODE, (CaptureRequest.Key) 0);
            this.f10852cd.mo13050a(false, (CameraDevice) null, true);
            this.f10932eF.removeMessages(5);
        }
        synchronized (this.f10791bU) {
            this.f10751ag = false;
        }
        synchronized (this.f10793bW) {
            this.f10754aj = false;
        }
        m10367j(0);
        this.f10809bm = false;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m10376m(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraManager", "afterStartUpCamera, mbPaused: " + this.f10752ah + ", mFirstTimeInitialized: " + this.f10808bl);
        if (this.f10752ah) {
            CameraLog.m12966e("CameraManager", "afterStartUpCamera, activity paused, return.");
            return;
        }
        CameraLog.m12952a("afterStartUpCamera");
        this.f10795bY.block();
        this.mModeManager.m11957c(this.f10989y);
        this.mModeManager.m11818a(this.f10852cd);
        if (this.f10865cq != null) {
            this.f10865cq.m23667a(this.f10747ac);
        }
        m10370k(0);
        m10336c(false, false);
        if (this.f10752ah) {
            CameraLog.m12967f("CameraManager", "afterStartUpCamera, activity paused, so return");
            return;
        }
        if (this.f10846cX.m13353q() && this.mModeManager.m12091j(CameraUIInterface.KEY_BEAUTY3D)) {
            this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.41
                @Override // java.lang.Runnable
                public void run() {
                    CameraManager.this.mModeManager.m11895b(13, true);
                }
            });
        }
        m10378n(OplusGLSurfaceView_13);
        if (this.f10799bc && !this.f10752ah) {
            this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.42
                @Override // java.lang.Runnable
                public void run() {
                    if (!CameraManager.this.f10808bl) {
                        CameraManager.this.m10363i();
                    } else {
                        CameraManager.this.m10369k();
                    }
                }
            });
        }
        this.f10841cS.post(new Runnable() { // from class: com.oplus.camera.CameraManager.43
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.f10752ah) {
                    return;
                }
                CameraManager.this.m10371k(true);
                if (CameraManager.this.mCameraUIManager != null) {
                    CameraManager.this.mCameraUIManager.m19825cb();
                }
            }
        });
        CameraLog.m12958b("afterStartUpCamera");
    }

    /* renamed from: cr */
    private void m9998cr() {
        if (this.f10854cf == null) {
            this.f10854cf = new C2594v(this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cs */
    public OneCamera.COUIBaseListPopupWindow_8 m9999cs() {
        if (this.f10855cg == null) {
            this.f10855cg = new C2578f(this, null);
        }
        return this.f10855cg;
    }

    /* renamed from: com.oplus.camera.CameraManager$COUIBaseListPopupWindow_12 */
    private final class C2578f implements OneCamera.COUIBaseListPopupWindow_8 {
        private C2578f() {
        }

        /* synthetic */ C2578f(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p141e.OneCamera.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10951a() {
            if (CameraManager.this.f10932eF == null || CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11788T() || InverseManager.INS.isInverseAble(CameraManager.this.f10849ca)) {
                return;
            }
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.COUIBaseListPopupWindow_12.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "openFrontFlash");
                    CameraManager.this.m10212J();
                }
            });
        }

        @Override // com.oplus.camera.p141e.OneCamera.COUIBaseListPopupWindow_8
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10954b() {
            if (CameraManager.this.f10932eF != null) {
                CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.COUIBaseListPopupWindow_12.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.f10752ah || !CameraManager.this.m10213K() || InverseManager.INS.isInverseAble(CameraManager.this.f10849ca)) {
                            return;
                        }
                        CameraLog.m12954a("CameraManager", "closeFrontFlash");
                        CameraManager.this.mCameraUIManager.m19810cM();
                        if (!CameraManager.this.mCameraUIManager.mo18023A() && !CameraManager.this.mCameraUIManager.mo18043K() && !CameraManager.this.mModeManager.m11832a() && !CameraManager.this.mModeManager.m11973cH()) {
                            CameraManager.this.mCameraUIManager.m19991z(0);
                        }
                        CameraManager.this.mModeManager.m11940bk();
                    }
                });
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10953a(boolean z) {
            if (CameraManager.this.m9950cT() && CameraManager.this.mModeManager != null) {
                CameraManager.this.f10852cd.mo13069b(CameraManager.this.mModeManager.m11787S());
            }
            boolean z2 = false;
            if (CameraManager.this.f10866cr != null && CameraManager.this.f10866cr.m11544x()) {
                CameraManager.this.f10866cr.m11532l(false);
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m11978cM();
                }
                CameraManager.this.m10286aV();
            }
            if (CameraManager.this.mModeManager != null && z) {
                CameraManager.this.m10367j(1);
                CameraManager.this.mModeManager.m12139x(true);
            }
            if (CameraManager.this.mCameraUIManager != null) {
                CameraUIManager c3208d = CameraManager.this.mCameraUIManager;
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_SCENE_ULTRA_WIDE_HINT)) {
                    CameraManager cameraManager = CameraManager.this;
                    if (!cameraManager.m10136k(cameraManager.m10279aO()) && !CameraManager.this.mModeManager.isNoneSatUltraWideAngleOpen() && !CameraManager.this.mModeManager.m11918bO() && CameraManager.this.m10327b(CameraUIInterface.KEY_ZOOM)) {
                        z2 = true;
                    }
                }
                c3208d.m19719ar(z2);
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10952a(CaptureResult captureResult, CameraRequestTag c2693c) {
            CameraLog.m12952a("onCaptureCompleted captureX CameraManager");
            if (CameraManager.this.mModeManager != null) {
                if (CameraManager.this.mModeManager != null && CameraManager.this.f10852cd != null && !CameraManager.this.mModeManager.m12099l(-1) && c2693c != null && (c2693c.f13407b || !"none".equals(c2693c.f13410e))) {
                    CameraManager.this.m10241a(captureResult);
                }
                Size sizeM11956c = CameraManager.this.f10884dJ != null ? CameraManager.this.mModeManager.m11956c(CameraManager.this.f10853ce) : null;
                int iM12045de = 0;
                long jM12046df = 0;
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                    iM12045de = CameraManager.this.mModeManager.m12045de();
                    jM12046df = CameraManager.this.mModeManager.m12046df();
                }
                CameraManager cameraManager = CameraManager.this;
                cameraManager.f10789bS = CaptureMsgDataReportUtil.m11158a(cameraManager.f10789bS, captureResult, c2693c, CameraManager.this.f10884dJ, sizeM11956c, iM12045de, jM12046df);
                CameraLog.m12958b("onCaptureCompleted captureX CameraManager");
                return;
            }
            CameraLog.m12967f("CameraManager", "onCaptureCompleted, mModeManager is null");
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$v */
    private final class C2594v implements OneCamera.IntrinsicsJvm.kt_5 {
        private C2594v() {
        }

        /* synthetic */ C2594v(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11046a(LinkedHashMap<String, Surface> linkedHashMap, int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10914dn.m17193a("type_multi_main_preview_frame")) {
                linkedHashMap.put(CameraUnitClient.CameraType.REAR_MAIN, null);
                if (Util.m24451g() == 0) {
                    linkedHashMap.put(CameraUnitClient.CameraType.FRONT_WIDE, null);
                } else {
                    linkedHashMap.put(CameraUnitClient.CameraType.FRONT_MAIN, null);
                }
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11045a(CameraDeviceConfig.Builder builder) {
            if (CameraManager.this.f10914dn != null) {
                CameraManager.this.f10914dn.m17190a(builder);
            }
            if (CameraManager.this.f10892dR != null) {
                CameraManager.this.f10892dR.mo24733a(CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11931bb());
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo11047a(final int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10852cd != null && !CameraManager.this.f10752ah && !CameraManager.this.f10753ai) {
                CameraManager.this.f10725aG = false;
                CameraManager.this.f10722aD = false;
                CameraManager.this.m9803bF();
                CameraLog.m12954a("CameraManager", "onSessionConfigured, cameraRole: " + OplusGLSurfaceView_13);
                CameraManager.this.mCameraUIManager.mo18066a().post(new Runnable() { // from class: com.oplus.camera.CameraManager.v.1
                    @Override // java.lang.Runnable
                    public void run() throws NumberFormatException {
                        if (CameraManager.this.f10849ca == null || CameraManager.this.f10849ca.isFinishing() || CameraManager.this.f10752ah) {
                            return;
                        }
                        CameraLog.m12952a("onCaptureSessionOk");
                        CameraManager.this.m10254a(false, OplusGLSurfaceView_13);
                        if (CameraManager.this.m10327b(CameraUIInterface.KEY_SUPPORT_DECREASE_BRIGHTNESS)) {
                            CameraManager.this.m9807bH();
                        }
                        if (Camera.f10611m && Camera.f10613o) {
                            CameraManager.this.m9893bz();
                        } else if (Camera.f10610l && Camera.f10612n) {
                            CameraManager.this.m9793bA();
                        }
                        if (!CameraManager.this.m10373l()) {
                            if (CameraManager.this.f10907dg != null && CameraManager.this.f10907dg.m14790b()) {
                                CameraManager.this.m10381o();
                            }
                        } else {
                            String string = CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, CameraManager.this.f10849ca.getString(R.string.camera_gesture_shutter_default_value));
                            boolean z = true;
                            if (CameraManager.this.mCameraUIListener.mo10848h(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) && string.equals("on") && CameraManager.this.m10050df() && CameraManager.this.f10918dr != 2) {
                                CameraManager.this.f10918dr = (byte) 1;
                            }
                            CameraManager cameraManager = CameraManager.this;
                            boolean z2 = CameraManager.this.f10918dr == 1;
                            if (CameraManager.this.f10918dr != 1 && !CameraManager.this.f10919ds) {
                                z = false;
                            }
                            cameraManager.m10257a(z2, z);
                            CameraManager.this.f10918dr = (byte) 2;
                        }
                        CameraManager.this.f10919ds = false;
                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_GESTURE_DETECT_IN_APS) && CameraManager.this.f10852cd != null) {
                            CameraManager.this.f10852cd.mo13096g(CameraManager.this.m10373l() ? "on" : "off");
                            CameraManager.this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                        }
                        if (CameraManager.this.m10380n()) {
                            CameraManager.this.m10375m();
                        }
                        CameraLog.m12958b("onCaptureSessionOk");
                    }
                });
                if (CameraManager.this.m10327b(CameraUIInterface.KEY_FACE_DETECTION)) {
                    CameraManager.this.f10852cd.mo13107k();
                } else {
                    CameraManager.this.f10852cd.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.STATISTICS_FACE_DETECT_MODE, (CaptureRequest.Key) 0);
                }
                CameraManager.this.f10914dn.m17189a();
                if (!CameraManager.this.m10327b(CameraUIInterface.KEY_TIME_LAPSE_PRO) || CameraManager.this.f10703K != 2) {
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.m10233a(cameraManager.f10870cv, false, true);
                }
                CameraLog.m12952a("setRepeatingRequest");
                CameraManager.this.f10769ay = false;
                CameraManager.this.f10924dx = false;
                CameraManager.this.m10012cy();
                CameraManager.this.f10852cd.mo13035a(CameraManager.this.f10937eK);
                CameraLog.m12958b("setRepeatingRequest");
                CameraManager.this.f10914dn.m17203e();
                CameraManager.this.mCameraUIManager.mo18225i();
                CameraManager.this.f10878dD.block();
                if (CameraManager.this.f10876dB != null) {
                    CameraManager.this.f10876dB.setStateObserver(CameraManager.this.m9999cs());
                }
                CameraLog.m12954a("CameraManager", "onSessionConfigured, unlock");
                if (CameraManager.this.f10913dm != null) {
                    CameraManager.this.f10913dm.m11008b(OplusGLSurfaceView_13);
                }
                if (CameraManager.this.f10924dx) {
                    CameraManager.this.m10007cw();
                }
                return true;
            }
            CameraLog.m12967f("CameraManager", "onSessionConfigured, Camera closed, aborting");
            return false;
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11043a() {
            CameraLog.m12959b("CameraManager", "onSessionConfigureFailed");
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.v.2
                @Override // java.lang.Runnable
                public void run() {
                    CameraManager.this.m10367j(0);
                }
            });
            if (CameraManager.this.m10207E()) {
                CameraManager.this.mCameraUIManager.m19859dC();
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11044a(CameraRequestTag c2693c, int OplusGLSurfaceView_13) {
            CameraLog.m12959b("CameraManager", "onSessionClosed, role: " + OplusGLSurfaceView_13);
            if (!CameraManager.this.f10753ai && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT) && CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.mo18183c() != null) {
                CameraManager.this.mCameraUIManager.mo18183c().m23475f(OplusGLSurfaceView_13);
            }
            if (2 == OplusGLSurfaceView_13) {
                return;
            }
            CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.v.3
                @Override // java.lang.Runnable
                public void run() {
                    CameraManager.this.m10367j(0);
                    CameraManager.this.f10801be = false;
                }
            });
            if (CameraManager.this.f10913dm != null) {
                CameraManager.this.f10913dm.m11010d();
            }
            if (!CameraManager.this.f10752ah && 1 == CameraManager.this.f10703K && CameraManager.this.f10747ac && Util.m24459h("oplus.software.motor_support")) {
                CameraMotorManager.m13703a((Context) CameraManager.this.f10849ca).m13710b(CameraManager.this.f10846cX.m13329a(CameraManager.this.mModeManager.m12105n(), CameraManager.this.f10989y));
            }
            CameraManager.this.m10003cu();
            CameraManager.this.m9803bF();
            CameraManager.this.f10817bu = false;
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo11048b(int OplusGLSurfaceView_13) {
            CameraScreenNail c3445hMo18183c;
            if (!CameraManager.this.m10268aD() || (c3445hMo18183c = CameraManager.this.mCameraUIManager.mo18183c()) == null) {
                return;
            }
            c3445hMo18183c.m23478l(false);
            c3445hMo18183c.m23479m(false);
            c3445hMo18183c.m23475f(1);
            c3445hMo18183c.m23475f(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ct */
    public void m10001ct() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            m9884bv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cu */
    public void m10003cu() {
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13146x();
        }
        if (this.f10866cr != null) {
            this.f10866cr.m11532l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cv */
    public void m10005cv() {
        if (this.f10849ca == null || !InverseManager.INS.isInverseColor(this.f10849ca.hashCode())) {
            return;
        }
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.44
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.f10752ah) {
                    return;
                }
                CameraLog.m12954a("CameraManager", "startInverseMaskAnimation");
                InverseManager.INS.startMaskScaleAnimation(CameraManager.this.f10849ca);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9773b(CaptureResult captureResult) {
        Face[] faceArr;
        OneCamera interfaceC2694d;
        FrontCameraZoomManager c2808m;
        if (captureResult == null) {
            CameraLog.m12967f("CameraManager", "onReceivePreviewCaptureResult, invalid result");
            return;
        }
        Face[] faceArr2 = (Face[]) captureResult.get(CaptureResult.STATISTICS_FACES);
        if (!this.f10760ap && m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH) && (c2808m = this.f10863co) != null) {
            c2808m.m14684a(faceArr2);
        }
        OneCamera interfaceC2694d2 = this.f10852cd;
        m10259a(faceArr2, interfaceC2694d2 != null ? interfaceC2694d2.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13249O, captureResult) : null);
        if (this.mModeManager != null && this.mModeManager.m12015cx() && this.f10865cq != null && (interfaceC2694d = this.f10852cd) != null) {
            int[] iArrMo13061a = interfaceC2694d.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13363t, captureResult);
            this.f10865cq.m23668a(iArrMo13061a);
            String string = this.f10850cb.getString(this.f10747ac ? CameraUIInterface.KEY_VIDEO_SOUND_FRONT : CameraUIInterface.KEY_VIDEO_SOUND_REAR, "all_around");
            if (m10269aE() && Util.m24175F() && "all_around".equals(string) && this.f10865cq.m23655O() && iArrMo13061a != null && this.f10861cm != null && !this.f10783bM) {
                boolean z = iArrMo13061a[0] != 0;
                if (z) {
                    this.f10932eF.removeMessages(27);
                    this.mModeManager.m12142z(true);
                } else if (!this.f10932eF.hasMessages(27)) {
                    this.f10932eF.sendEmptyMessageDelayed(27, 3000L);
                }
                Matrix matrix = new Matrix();
                RectF rectF = new RectF();
                RectF rectF2 = new RectF(iArrMo13061a[0], iArrMo13061a[1], iArrMo13061a[2], iArrMo13061a[3]);
                float screenWidth = (Util.getScreenWidth() / this.f10861cm.height()) * this.f10871cw;
                matrix.reset();
                matrix.setTranslate((-this.f10861cm.width()) / 2.0f, (-this.f10861cm.height()) / 2.0f);
                matrix.postRotate(m9894c(this.f10990z, 0));
                matrix.postScale(screenWidth, screenWidth);
                matrix.postTranslate(Util.getScreenWidth() / 2.0f, Util.getScreenHeight() / 2.0f);
                matrix.mapRect(rectF, rectF2);
                this.mModeManager.m11805a(rectF.centerX(), rectF.centerY());
                if (z && !this.f10953ef) {
                    this.f10953ef = true;
                    this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.-$$Lambda$CameraManager$u5n251AbyVHgAuVZX8uGSL6RO_g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.COUIBaseListPopupWindow_12$0.m10074dr();
                        }
                    });
                }
            }
        }
        try {
            m10258a((int[]) captureResult.get(CameraMetadataKey.f13300am));
            if (this.f10868ct != null && !this.f10753ai) {
                this.f10868ct.m11646a(captureResult);
            }
        } catch (IllegalArgumentException unused) {
        }
        if (m10312av()) {
            this.f10826cD.m19327a(m10331c(m10279aO()), faceArr2, this.f10984t);
        }
        if (m9936cM()) {
            this.f10827cE.m19254a(this.f10984t);
        }
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19643Y(false);
        }
        Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13249O);
        ModeFacade c3020t = this.f10914dn;
        if (c3020t != null && c3020t.m17198b(CameraUIInterface.KEY_BEAUTY3D_MAIN_FACE_DETECT) && objM13005a != null && (objM13005a instanceof int[])) {
            int[] iArr = (int[]) objM13005a;
            if (iArr.length >= 3) {
                CameraLog.m12954a("CameraManager", "onReceivePreviewCaptureResult, mainFaceIndex: " + iArr[2]);
                if (this.mCameraUIManager != null) {
                    this.mCameraUIManager.m19643Y(true);
                    this.mCameraUIManager.m19619D(iArr[2]);
                }
            }
        }
        Long OplusGLSurfaceView_14 = (Long) captureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (this.f10852cd != null && this.mModeManager != null) {
            ModeManager modeManager = this.mModeManager;
            if (modeManager.m11906bC() != 0 || modeManager.m11907bD()) {
                m10241a(captureResult);
            }
        }
        Object objM13005a2 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13247M);
        byte[] bArr = (objM13005a2 == null || !(objM13005a2 instanceof byte[])) ? null : (byte[]) objM13005a2;
        PreviewEffectProcess interfaceC3423t = this.f10864cp;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22796a(bArr);
            this.f10864cp.mo22780a(OplusGLSurfaceView_14 != null ? OplusGLSurfaceView_14.longValue() : 0L);
        }
        if (this.f10914dn != null && m10327b(CameraUIInterface.KEY_SUPPORT_SHOW_NO_FACE) && this.mCameraUIManager != null && !this.mCameraUIManager.m19875dS() && this.mCameraUIManager != null && !this.mCameraUIManager.m19864dH()) {
            if (this.mCameraUIManager != null) {
                if (this.f10739aU && ((faceArr = this.f10857ci) == null || faceArr.length == 0)) {
                    this.mCameraUIManager.m19849cz();
                } else {
                    this.mCameraUIManager.m19798cA();
                }
            }
        } else if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19798cA();
        }
        if (this.mCameraUIManager != null) {
            if (m10327b(CameraUIInterface.KEY_FACE_DETECTION) && this.mModeManager != null) {
                boolean z2 = (this.f10766av || this.mCameraUIManager.m19751bK() || (!m10222T() && !this.mModeManager.m11790V()) || m10207E() || !this.mModeManager.m11928bY()) ? false : true;
                if ((this.f10865cq != null && (!z2 || !this.f10865cq.m23641A())) || this.mModeManager.m12015cx()) {
                    this.f10932eF.removeMessages(13);
                    this.f10932eF.obtainMessage(13, Boolean.valueOf(z2)).sendToTarget();
                }
            }
            if (!Util.m24169C() || !m10327b(CameraFunction.AIS_SNAPSHOT) || this.f10821by) {
                int[] iArr2 = (int[]) captureResult.get(CameraMetadataKey.f13258X);
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_MODE);
                if (num != null && num2 != null && !m10268aD() && this.f10865cq != null) {
                    this.f10865cq.m23662a(num.intValue(), num2.intValue(), iArr2, this.f10982r, -1);
                }
            }
            boolean z3 = (PopUpWindowManager.m20706a() || !m10222T() || m10207E()) ? false : true;
            if (z3 && this.f10865cq != null && this.f10865cq.m23641A()) {
                return;
            }
            this.f10932eF.removeMessages(23);
            this.f10932eF.obtainMessage(23, Boolean.valueOf(z3)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dr */
    public /* synthetic */ void m10074dr() {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19662a(R.string.camera_auto_focus_on_tips, new Object[0]);
            this.mCameraUIManager.mo18138ab();
            this.f10700H = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cw */
    public void m10007cw() {
        if (this.mCameraUIManager == null || !m10207E()) {
            return;
        }
        this.mCameraUIManager.m19860dD();
        if (this.f10913dm.m11005a() || this.f10724aF) {
            return;
        }
        this.mCameraUIManager.m19859dC();
        if (this.mCameraUIManager.mo18183c() != null) {
            this.mCameraUIManager.mo18183c().m23492w();
        }
    }

    /* renamed from: ar */
    public void m10308ar() {
        CameraLog.m12954a("CameraManager", "closeCaptureSession, mCameraState: " + this.f10982r + ", mOneCamera: " + this.f10852cd);
        if (this.f10852cd == null || this.f10752ah) {
            return;
        }
        CameraLog.m12952a("CameraSwitchModePerformance.closeCaptureSession");
        FluencyPerformance.m15133b(System.currentTimeMillis(), true);
        m10367j(5);
        this.f10852cd.mo13090f();
        this.f10932eF.removeMessages(5);
        AISSnapshotManager c2629b = this.f10868ct;
        if (c2629b != null) {
            c2629b.m11649b();
        }
        m10309as();
        this.mCameraUIManager.mo18067a(R.string.camera_toast_lock_ae_af);
        CameraLog.m12958b("CameraSwitchModePerformance.closeCaptureSession");
    }

    /* renamed from: as */
    public void m10309as() {
        if (this.f10865cq == null) {
            return;
        }
        this.f10865cq.m23700m();
        this.f10865cq.m23704q();
        this.f10755ak = 0;
        if (this.f10865cq.mo23706s()) {
            this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.47
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    CameraManager.this.f10865cq.m23688f(false);
                    CameraManager.this.mCameraUIManager.m19848cy();
                }
            });
        }
    }

    /* renamed from: at */
    public int m10310at() {
        return Float.compare(this.f10852cd.mo13086e().m13279n(), 0.0f) != 0 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) ? Util.m24445f(R.string.toast_ultra_wide_micro_lens) : R.string.toast_ultra_wide_angel_lens;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m10378n(int OplusGLSurfaceView_13) {
        String string;
        int iMo13075c;
        float fM10279aO;
        FrontCameraZoomManager c2808m;
        FrontCameraZoomManager c2808m2;
        FrontCameraZoomManager c2808m3;
        C2587o c2587oM11014h;
        CameraLog.m12952a("createCaptureSession");
        synchronized (this.f10976l) {
            if (this.f10913dm == null || (c2587oM11014h = this.f10913dm.m11014h()) == null) {
                string = "";
                iMo13075c = -1;
            } else {
                string = c2587oM11014h.toString();
                iMo13075c = c2587oM11014h.f11195h;
            }
        }
        CameraLog.m12967f("CameraManager", "createCaptureSession, mCameraState: " + this.f10982r + ", mOneCamera: " + this.f10852cd + ", mbPaused: " + this.f10752ah + ", modeChangeTask: " + string + ", role: " + OplusGLSurfaceView_13);
        if (this.f10852cd == null || this.f10752ah || this.f10849ca == null || this.f10849ca.isFinishing()) {
            StringBuilder sb = new StringBuilder();
            sb.append("createCaptureSession, mOneCamera: ");
            sb.append(this.f10852cd);
            sb.append(", mbPaused: ");
            sb.append(this.f10752ah);
            sb.append(", mActivity: ");
            sb.append(this.f10849ca);
            sb.append(", isFinish: ");
            sb.append(this.f10849ca != null ? Boolean.valueOf(this.f10849ca.isFinishing()) : "NA");
            CameraLog.m12966e("CameraManager", sb.toString());
            return;
        }
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d == null || interfaceC2694d.mo13060a() || this.f10852cd.mo13074b()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("createCaptureSession, not create, mOneCamera: ");
            sb2.append(this.f10852cd);
            sb2.append(", isCloseState: ");
            OneCamera interfaceC2694d2 = this.f10852cd;
            sb2.append(interfaceC2694d2 != null ? Boolean.valueOf(interfaceC2694d2.mo13060a()) : "NA");
            sb2.append(", isCameraClosingState: ");
            OneCamera interfaceC2694d3 = this.f10852cd;
            sb2.append(interfaceC2694d3 != null ? Boolean.valueOf(interfaceC2694d3.mo13074b()) : "NA");
            CameraLog.m12966e("CameraManager", sb2.toString());
            return;
        }
        if (-1 == iMo13075c) {
            iMo13075c = this.f10852cd.mo13075c();
        }
        String strM12978b = CameraCharacteristicsUtil.m12978b(iMo13075c);
        String strM24475l = Util.m24475l(this.f10914dn.m17207i());
        this.f10896dV = this.f10852cd.mo13019a(strM24475l, strM12978b);
        FluencyPerformance.m15123a(this.mModeManager.m12036dM());
        if (this.f10896dV == null) {
            CameraLog.m12967f("CameraManager", "createCaptureSession, cameraDevice is null, so stop");
            return;
        }
        CameraDeviceConfig.Builder builderMo13149y = this.f10852cd.mo13149y();
        builderMo13149y.setMode(strM24475l);
        if ((Camera.f10611m && Camera.f10613o) || (Camera.f10610l && Camera.f10612n)) {
            m10023d(this.f10850cb);
        }
        Size sizeM17187a = this.f10914dn.m17187a(this.f10853ce);
        Size sizeM17186a = this.f10914dn.m17186a(sizeM17187a);
        if (sizeM17186a == null) {
            sizeM17186a = sizeM17187a;
        }
        m10242a(sizeM17186a, sizeM17187a);
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19668a(sizeM17186a);
            this.mCameraUIManager.mo18233k().m18481a(sizeM17186a);
        }
        if (this.f10806bj) {
            m10297ag();
        }
        boolean zM17198b = this.f10914dn.m17198b(CameraUIInterface.KEY_ZOOM);
        if (this.f10822bz && this.f10914dn.m17198b(CameraFunction.SAT_CAMERA)) {
            fM10279aO = getMinZoomValue();
            this.f10822bz = false;
        } else if ((!m10327b(CameraUIInterface.KEY_PORTRAIT_HALF_BODY) && this.f10813bq && !this.mModeManager.m12006co()) || this.f10866cr == null || !zM17198b) {
            fM10279aO = m10009cx();
            if (this.mModeManager != null) {
                this.mModeManager.m12134v(false);
            }
        } else {
            fM10279aO = m10279aO();
            if (!m10354f(fM10279aO)) {
                fM10279aO = m10282aR();
                this.f10914dn.m17196b(false);
            }
        }
        if (m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH) && (c2808m3 = this.f10863co) != null) {
            fM10279aO = c2808m3.m14677a();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM) && (c2808m2 = this.f10863co) != null) {
            c2808m2.m14682a(this.f10914dn.m17207i());
        }
        if (this.f10914dn.m17209k()) {
            Rect rectM10331c = m10331c(fM10279aO);
            builderMo13149y.setParameter(CameraParameter.SESSION_REQUEST_CROP_REGION, new int[]{rectM10331c.left, rectM10331c.top, rectM10331c.right, rectM10331c.bottom});
        }
        this.f10700H = 0;
        this.f10886dL = 0L;
        this.f10914dn.m17208j();
        this.f10772bB = true;
        this.f10861cm = this.f10853ce.m13255a(sizeM17186a);
        if (m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH) && (c2808m = this.f10863co) != null) {
            c2808m.m14678a(this.f10861cm.width() * this.f10861cm.height());
        }
        if (this.f10846cX.m13355s() && m10354f(this.f10846cX.m13357u())) {
            fM10279aO = this.f10846cX.m13357u();
        }
        if (!m10327b(CameraUIInterface.KEY_TIME_LAPSE_PRO) || this.f10703K != 2) {
            m10318b(fM10279aO);
        }
        if (m10327b(CameraFunction.TILT_SHIFT)) {
            m10299ai();
        }
        C2586n c2586n = this.f10913dm;
        if (c2586n != null && c2586n.m11007b() <= 1 && !this.f10752ah) {
            this.f10813bq = false;
        }
        m9998cr();
        if (!CameraCharacteristicsUtil.m12974a(this.mCameraUIListener.mo10654H()) && CameraCharacteristicsUtil.m12983f() && Float.compare(this.f10853ce.m13279n(), 0.0f) != 0) {
            this.f10768ax = false;
        }
        if (!this.f10747ac) {
            if (this.f10914dn.m17212n()) {
                this.f10852cd.mo13029a(this.f10914dn.m17199c(), AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
            }
            this.f10852cd.mo13071b(false, false);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CAPTURE_WITH_RAW10) && !this.f10914dn.m17207i().equals(ApsConstant.CAPTURE_MODE_NIGHT)) {
            this.f10852cd.mo13132s(1);
        }
        if (this.mCameraUIManager != null && this.mModeManager != null) {
            GLRootView gLRootViewMo18066a = this.mCameraUIManager.mo18066a();
            if (gLRootViewMo18066a != null) {
                gLRootViewMo18066a.setNeedLutTexture(this.mModeManager.m11991cZ());
            }
            this.mCameraUIManager.mo18183c().m23476j(this.mModeManager.m11982cQ());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CameraDeviceConfig.PreviewConfig(strM12978b, sizeM17186a, 5));
        if (this.f10914dn.m17193a("type_preview_frame")) {
            arrayList.add(new CameraDeviceConfig.PreviewConfig(strM12978b, this.f10914dn.m17200c(this.f10853ce), 6));
        }
        builderMo13149y.setPreviewConfig(arrayList);
        if (this.f10914dn.m17193a("type_capture")) {
            Size sizeM17194b = this.f10914dn.m17194b(this.f10853ce);
            builderMo13149y.setPictureConfig(Arrays.asList(new CameraDeviceConfig.PictureConfig(strM12978b, sizeM17194b, 35)));
            CameraLog.m12962c("CameraManager", "createCaptureSession, pictureSize: " + sizeM17194b);
        }
        ((OneCameraProxy) this.f10852cd).m13228a(builderMo13149y, this.f10854cf, this.f10914dn.m17202d());
        this.f10778bH = false;
        this.f10722aD = true;
        m10013cz();
        m9912cA();
        m9913cB();
        CameraLog.m12958b("createCaptureSession");
    }

    /* renamed from: cx */
    private float m10009cx() {
        float COUIBaseListPopupWindow_12 = this.f10850cb.getFloat(CameraUIInterface.KEY_ZOOM, 0.0f);
        if (!m9861bj()) {
            COUIBaseListPopupWindow_12 = this.f10850cb.getFloat(CameraUIInterface.KEY_ZOOM_FROM_OTHER_APP, 0.0f);
        }
        if (this.f10846cX.m13355s()) {
            float fM13357u = this.f10846cX.m13357u();
            if (m10354f(fM13357u) || (Util.m24394b(ApsConstant.CAPTURE_MODE_COMMON, false) && Float.compare(ZoomManager.f12334a, fM13357u) == 0)) {
                COUIBaseListPopupWindow_12 = fM13357u;
            }
        }
        return (COUIBaseListPopupWindow_12 != 0.0f && m9988cm() && (m9930cJ() || this.mModeManager.m12020d())) ? COUIBaseListPopupWindow_12 : m10282aR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cy */
    public void m10012cy() {
        if (!m10268aD() || Util.m24169C()) {
            return;
        }
        ((OneCameraProxy) this.f10852cd).m13223C(2);
    }

    /* renamed from: cz */
    private void m10013cz() {
        if (m10327b(CameraUIInterface.KEY_FACE_DETECTION)) {
            m10401y();
        } else {
            m10403z();
        }
    }

    /* renamed from: cA */
    private void m9912cA() {
        if (m10327b(CameraUIInterface.KEY_SUPPORT_MULTI_FOCUS)) {
            m10203A();
        } else {
            m10204B();
        }
    }

    /* renamed from: cB */
    private void m9913cB() {
        if (this.mModeManager != null && this.mModeManager.m11926bW()) {
            m10397w();
        } else {
            m10399x();
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$COUIBaseListPopupWindow_8 */
    private class C2577e implements OneCamera.IntrinsicsJvm.kt_4 {
        private C2577e() {
        }

        /* synthetic */ C2577e(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10946a(int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraManager", "CameraOpenCallback onCameraOpened, mOneCamera: " + CameraManager.this.f10852cd + ", mOpenCameraType: " + CameraManager.this.f10703K + ", cameraRole: " + OplusGLSurfaceView_13);
            if (!CameraManager.this.f10752ah && CameraManager.this.f10852cd != null) {
                synchronized (CameraManager.this.f10975k) {
                    CameraManager.this.f10852cd.mo13036a(CameraManager.this.m9999cs());
                    if (CameraManager.this.f10876dB != null) {
                        CameraManager.this.f10876dB.setStateObserver(CameraManager.this.m9999cs());
                    }
                }
                int i2 = CameraManager.this.f10703K;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    return;
                                }
                            } else if (!CameraManager.this.mModeManager.m11982cQ() && ((OneCameraProxy) CameraManager.this.f10852cd).m13224D() != null) {
                                ((OneCameraProxy) CameraManager.this.f10852cd).m13224D().m12155d();
                            }
                        }
                    }
                    CameraManager.this.f10875dA = true;
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.f10909di = cameraManager.f10914dn.m17187a(CameraManager.this.f10853ce);
                    Size sizeM17186a = CameraManager.this.f10914dn.m17186a(CameraManager.this.f10909di);
                    if (sizeM17186a != null) {
                        CameraManager.this.f10909di = sizeM17186a;
                    }
                    if (CameraManager.this.mModeManager != null) {
                        CameraManager.this.mModeManager.m12128t(false);
                    }
                    CameraManager.this.f10865cq.m23674b(CameraManager.this.f10747ac);
                    CameraManager.this.mCameraUIManager.m19642X(CameraManager.this.f10747ac);
                    CameraManager.this.mModeManager.m11818a(CameraManager.this.f10852cd);
                    CameraManager.this.mModeManager.m12019d(CameraManager.this.f10989y);
                    if (CameraManager.this.f10913dm != null) {
                        CameraManager.this.f10913dm.m11011e();
                    }
                    CameraManager.this.m10370k(0);
                    CameraManager.this.m10336c(false, false);
                    CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.COUIBaseListPopupWindow_8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CameraManager.this.f10752ah) {
                                return;
                            }
                            CameraManager.this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_VIDEO_SIZE);
                            CameraManager.this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_VIDEO_FPS);
                            CameraManager.this.m9922cF();
                            CameraManager.this.mCameraUIManager.m19792c(CameraManager.this.f10914dn.m17187a(CameraManager.this.f10853ce));
                        }
                    });
                    if (!CameraManager.this.mCameraUIManager.m19739b(CameraManager.this.f10914dn.m17187a(CameraManager.this.f10853ce)) || CameraManager.this.f10752ah) {
                        return;
                    }
                    CameraManager.this.m10378n(OplusGLSurfaceView_13);
                    return;
                }
                CameraManager.this.f10875dA = true;
                CameraManager.this.f10911dk = 0;
                CameraManager.this.m9668a(96, false);
                Util.m24490q();
                CameraManager.this.m10376m(OplusGLSurfaceView_13);
                if (CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m12128t(false);
                    return;
                }
                return;
            }
            CameraLog.m12966e("CameraManager", "CameraOpenCallback onCameraOpened, mbPaused: " + CameraManager.this.f10752ah + " mOneCamera: " + CameraManager.this.f10852cd + ", CameraManager: " + CameraManager.this + ", CameraActivity: " + CameraManager.this.f10849ca);
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10948a(boolean z, int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraManager", "CameraOpenCallback onFailure, cameraRole: " + OplusGLSurfaceView_13 + " mOneCamera: " + CameraManager.this.f10852cd + ", mOpenCameraTime: " + CameraManager.this.f10911dk + ", mOpenCameraType: " + CameraManager.this.f10703K + ", disconnected: " + z);
            if (2 == OplusGLSurfaceView_13) {
                ((OneCameraProxy) CameraManager.this.f10852cd).m13226F();
            }
            if (CameraManager.this.f10913dm != null) {
                CameraManager.this.f10913dm.m11016j();
            }
            synchronized (CameraManager.this.f10975k) {
                if (CameraManager.this.f10852cd != null) {
                    CameraManager.this.f10852cd.mo13036a((OneCamera.COUIBaseListPopupWindow_8) null);
                }
                if (CameraManager.this.f10876dB != null) {
                    CameraManager.this.f10876dB.setStateObserver(null);
                }
            }
            if (CameraManager.this.f10849ca == null || CameraManager.this.f10849ca.isFinishing()) {
                return;
            }
            if (z) {
                CameraManager.this.f10932eF.removeMessages(10);
                CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.COUIBaseListPopupWindow_8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.f10849ca == null || CameraManager.this.f10849ca.isFinishing()) {
                            return;
                        }
                        CameraLog.m12967f("CameraManager", "onFailure, camera will finish");
                        CameraManager.this.f10849ca.finish();
                    }
                });
            } else {
                CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.COUIBaseListPopupWindow_8.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.f10752ah) {
                            return;
                        }
                        if (CameraManager.this.f10911dk <= 3) {
                            CameraManager.this.f10932eF.removeMessages(10);
                            CameraManager.this.f10932eF.sendEmptyMessageDelayed(10, 100L);
                        } else {
                            Util.m24254a(CameraManager.this.f10849ca, R.string.camera_camera_error_title);
                        }
                    }
                });
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10947a(int OplusGLSurfaceView_13, int i2) {
            CameraLog.m12954a("CameraManager", "CameraOpenCallback onError, cameraRole: " + i2 + ", mOneCamera: " + CameraManager.this.f10852cd + ", errorCode: " + OplusGLSurfaceView_13 + ", mOpenCameraType: " + CameraManager.this.f10703K);
            if (2 == i2) {
                ((OneCameraProxy) CameraManager.this.f10852cd).m13226F();
            }
            if (CameraManager.this.f10913dm != null) {
                CameraManager.this.f10913dm.m11016j();
            }
            synchronized (CameraManager.this.f10975k) {
                if (CameraManager.this.f10852cd != null) {
                    CameraManager.this.f10852cd.mo13036a((OneCamera.COUIBaseListPopupWindow_8) null);
                }
                if (CameraManager.this.f10876dB != null) {
                    CameraManager.this.f10876dB.setStateObserver(null);
                }
            }
            if (CameraManager.this.f10775bE) {
                if (CameraManager.this.mCameraUIManager != null) {
                    CameraManager.this.mCameraUIManager.mo19840cq();
                    return;
                }
                return;
            }
            CameraManager.this.f10776bF = true;
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10949b(int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraManager", "CameraOpenCallback onCameraClosed, mOneCamera: " + CameraManager.this.f10852cd + ", mOpenCameraType: " + CameraManager.this.f10703K + ", cameraRole: " + OplusGLSurfaceView_13);
            if (1 == OplusGLSurfaceView_13) {
                CameraManager.this.f10852cd.mo13131s();
                CameraManager.this.m10198y(1);
                CameraManager.this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.COUIBaseListPopupWindow_8.4
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraManager.this.m10367j(0);
                    }
                });
            } else if (2 == OplusGLSurfaceView_13) {
                CameraManager.this.m10198y(2);
                ((OneCameraProxy) CameraManager.this.f10852cd).m13226F();
            }
        }

        @Override // com.oplus.camera.p141e.OneCamera.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10950c(int OplusGLSurfaceView_13) {
            MultiCameraDecision c2647aM13224D;
            if (!(CameraManager.this.f10852cd instanceof OneCameraProxy) || (c2647aM13224D = ((OneCameraProxy) CameraManager.this.f10852cd).m13224D()) == null) {
                return;
            }
            c2647aM13224D.m12157e(OplusGLSurfaceView_13);
            CameraLog.m12959b("CameraManager", "openCamera mMultiCameraDecision: " + c2647aM13224D);
        }
    }

    /* renamed from: au */
    public void m10311au() {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19799cB();
        }
        if (this.mModeManager != null) {
            this.mModeManager.m11889ax();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m10135k(String str) {
        FeatureFactory.m14365a().m14369a(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10240a(SharedPreferences sharedPreferences, String str) {
        int OplusGLSurfaceView_13;
        boolean zM9916cC;
        String string;
        CameraLog.m12954a("CameraManager", "onSharedPreferenceChanged, key: " + str);
        String strM13305d = CameraEntry.m13305d(str);
        m10135k(strM13305d);
        if ("pref_camera_statement_agree".equals(strM13305d)) {
            m9982cj();
        }
        if (!CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE.equals(strM13305d) && !CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX.equals(strM13305d) && !CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED.equals(strM13305d) && !CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS.equals(strM13305d) && !CameraConfig.getMenuPanelOptionList().contains(strM13305d)) {
            m10169r(strM13305d);
        }
        boolean z = true;
        if (!Util.m24169C() && CameraUIInterface.KEY_FLASH_MODE.equals(strM13305d)) {
            this.f10819bw = true;
            this.f10841cS.sendEmptyMessageDelayed(6, 800L);
        }
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19663a(sharedPreferences, strM13305d);
        }
        if (this.f10865cq != null) {
            this.f10865cq.m23663a(sharedPreferences, strM13305d);
        }
        if (this.mModeManager != null) {
            this.mModeManager.m11811a(sharedPreferences, strM13305d);
        }
        if (CameraUIInterface.KEY_CAMERA_ID.equals(strM13305d)) {
            int iM10220R = m10220R();
            if (this.f10989y == iM10220R) {
                return;
            }
            this.f10846cX.m13347j();
            m9669a(iM10220R, true, false);
            return;
        }
        if (this.mModeManager == null) {
            return;
        }
        if (CameraUIInterface.KEY_CAMERA_MODE.equals(strM13305d)) {
            String strM12105n = this.mModeManager.m12105n();
            String string2 = sharedPreferences.getString(strM13305d, Util.m24382b(this.f10846cX.m13317J() == 3));
            if (string2.equals(strM12105n)) {
                return;
            }
            this.f10741aW = false;
            if (ApsConstant.REC_MODE_COMMON.equals(string2) && this.f10850cb != null && (m9855bg() || m10145m(string2))) {
                m10359g(true);
                this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                m10359g(false);
            } else if ((this.mModeManager.isNoneSatUltraWideAngleOpen() || this.mModeManager.m12013cv() || this.mModeManager.m12006co()) && this.f10850cb != null) {
                m10359g(true);
                this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                m10359g(false);
            }
            this.f10846cX.m13347j();
            m9702a(false, true, false);
            if (this.f10954eg.m16299c()) {
                return;
            }
            m10158p("1");
            return;
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(strM13305d) && this.f10850cb != null) {
            if (this.mCameraUIManager != null) {
                boolean zEquals = "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_SUB_SETTING, "off"));
                this.mCameraUIManager.mo18284x(zEquals);
                this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_SUB_SETTING);
                if (zEquals) {
                    if (this.f10866cr.m11528j()) {
                        this.f10866cr.m11507b(false);
                    }
                    if (this.f10865cq.m23641A()) {
                        this.f10865cq.m23703p();
                        if (this.f10865cq.m23655O()) {
                            m9610J(false);
                        }
                    }
                    this.mCameraUIManager.mo18239l(true);
                    this.mCameraUIManager.mo18138ab();
                    this.mCameraUIManager.mo18174b(false);
                } else if (18 == this.f10700H && m10327b(CameraUIInterface.KEY_MACRO_SWITCH)) {
                    this.mCameraUIManager.mo18070a(R.string.camera_ai_scn_microspur, -1, false, true, true);
                } else {
                    this.mCameraUIManager.mo18242m(this.f10700H);
                }
                if (m9916cC() && !this.mCameraUIManager.mo19839cp() && !m10207E()) {
                    this.mCameraUIManager.mo18046M();
                }
                if (this.mModeManager.m11990cY()) {
                    this.mCameraUIManager.mo18166b(R.string.camera_10bit_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                }
                if (this.mModeManager.m12033dJ() && this.mModeManager.m12031dH() && m10271aG()) {
                    this.mCameraUIManager.mo18166b(R.string.camera_video_hdr, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                }
                if (this.mModeManager.m11975cJ() && m10271aG() && this.mModeManager.m12032dI()) {
                    this.mCameraUIManager.mo18166b(R.string.camera_ultra_video_night, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                }
                this.mModeManager.m11898b(this.mModeManager.m11996ce(), this.mModeManager.m12030dG());
                if (zEquals || this.f10762ar || !this.mModeManager.m11917bN() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                    return;
                }
                if (TextUtils.isEmpty(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                    this.mCameraUIManager.mo18166b(R.string.camera_picture_size_standard_high_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Double.valueOf(this.mModeManager.m11919bP()));
                    return;
                } else {
                    this.mCameraUIManager.mo18166b(R.string.camera_setting_menu_high_resolution_item, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                    return;
                }
            }
            return;
        }
        if (CameraUIInterface.KEY_SETTING.equals(strM13305d)) {
            if (this.mCameraUIManager != null) {
                this.mCameraUIManager.mo18210f(17, true);
                this.mCameraUIManager.mo18210f(20, true);
            }
            Intent intent = new Intent("com.oplus.camera.action.SETTING_MENU");
            Bundle bundleM21516a = CameraSettingFactory.m21516a(this.mModeManager);
            bundleM21516a.putInt(CameraUIInterface.KEY_CAMERA_ID, this.f10989y);
            bundleM21516a.putInt("camera_enter_type", this.f10846cX.m13317J());
            bundleM21516a.putBoolean("camera_enter_form_lock_screen", this.f10846cX.m13359w());
            bundleM21516a.putInt("camera_property_camera_id", this.f10990z);
            bundleM21516a.putBoolean(CameraUIInterface.KEY_PHOTO_CODEC, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PHOTO_CODEC));
            bundleM21516a.putBoolean(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT));
            bundleM21516a.putBoolean(CameraUIInterface.KEY_10_BITS_SUPPORT_IN_CURRENT_MODE, m10327b(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE));
            bundleM21516a.putBoolean(CameraUIInterface.KEY_QR_CODE, m10327b(CameraUIInterface.KEY_QR_CODE));
            bundleM21516a.putBoolean("allow_location", this.f10923dw);
            intent.putExtra("camera_intent_data", bundleM21516a);
            m10400x(true);
            this.f10814br = false;
            m10064dm();
            this.f10849ca.startActivity(intent);
        }
        if (CameraUIInterface.KEY_NIGHT_PRO_MODE.equals(strM13305d)) {
            this.f10774bD = false;
        }
        if ((CameraUIInterface.KEY_VIDEO_SIZE.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_FPS.equals(strM13305d) || CameraUIInterface.KEY_SLOW_VIDEO_SIZE.equals(strM13305d) || CameraUIInterface.KEY_FAST_VIDEO_SIZE.equals(strM13305d) || CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(strM13305d)) && this.f10850cb != null) {
            if (m10327b(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE) && m9934cL() && ((this.mModeManager.m11931bb() || this.mModeManager.m11932bc()) && m10279aO() > m10283aS())) {
                m10359g(true);
                this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                m10359g(false);
            }
            this.f10850cb.edit().remove(CameraUIInterface.KEY_ZOOM).apply();
            if (CameraUIInterface.KEY_VIDEO_SIZE.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_FPS.equals(strM13305d)) {
                this.mModeManager.m12051dk();
            }
            if (!this.mModeManager.m11861aV() && !this.f10765au) {
                if (this.f10846cX.m13329a(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON), this.f10989y) != this.f10852cd.mo13075c()) {
                    blurModeChanged();
                } else {
                    m9813bK();
                }
            }
            this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_VIDEO_SIZE);
            this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_VIDEO_FPS);
            this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_SLOW_VIDEO_SIZE);
            this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_FAST_VIDEO_SIZE);
            return;
        }
        if (m10327b(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) && CameraUIInterface.KEY_10_BITS_HEIC_ENCODE.equals(strM13305d) && this.f10850cb != null && !this.mModeManager.m11861aV() && this.f10846cX.m13329a(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.REC_MODE_COMMON), this.f10989y) == this.f10852cd.mo13075c() && !this.f10765au) {
            m9815bL();
        }
        if (CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(strM13305d)) {
            string = this.f10850cb != null ? this.f10850cb.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "") : null;
            if (!this.f10765au && (!this.f10719aA || "on".equals(string))) {
                m9918cD();
            }
            if ("on".equals(string)) {
                this.f10870cv = 1.0f;
                this.f10850cb.edit().remove(CameraUIInterface.KEY_ZOOM).apply();
            }
            if (this.f10850cb != null && !TextUtils.isEmpty(string)) {
                z = false;
            }
            this.f10719aA = z;
            return;
        }
        if (CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE.equals(strM13305d)) {
            string = this.f10850cb != null ? this.f10850cb.getString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "") : null;
            if (!this.f10765au && (!this.f10720aB || "on".equals(string))) {
                m9920cE();
            }
            if (this.f10850cb != null && !TextUtils.isEmpty(string)) {
                z = false;
            }
            this.f10720aB = z;
            return;
        }
        if (CameraUIInterface.KEY_EXPLORER_CHIP_STATE.equals(strM13305d) && this.f10850cb.getInt(CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1) == 0) {
            this.mCameraUIManager.mo18074a(R.string.explorer_chip_damage_tip, 2000, new Object[0]);
        }
        if (CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(strM13305d)) {
            if (this.f10765au) {
                if (!m9916cC() && this.mCameraUIManager != null) {
                    this.mCameraUIManager.mo18048N();
                }
            } else {
                boolean zIsNoneSatUltraWideAngleOpen = this.mModeManager.isNoneSatUltraWideAngleOpen();
                boolean z2 = this.f10747ac;
                boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE);
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT)) {
                    zM9916cC = this.mModeManager.m12013cv();
                } else {
                    zM9916cC = m9916cC();
                }
                this.mModeManager.m12004cm();
                if (zIsNoneSatUltraWideAngleOpen && zM9916cC) {
                    if (!configBooleanValue) {
                        CameraLog.m12954a("CameraManager", "onSharedPreferenceChanged, return");
                        return;
                    } else if (!z2) {
                        return;
                    }
                }
                if (configBooleanValue && !zIsNoneSatUltraWideAngleOpen && z2) {
                    m9816bM();
                }
                if (this.mModeManager.m12091j(CameraFunction.SAT_CAMERA)) {
                    blurModeChanged();
                    return;
                } else {
                    m9813bK();
                    return;
                }
            }
        }
        if (CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE.equals(strM13305d)) {
            if (!this.f10765au && !this.f10760ap && !this.mModeManager.m11924bU()) {
                if (this.mModeManager.m12091j(CameraFunction.SAT_CAMERA) || m10327b(CameraFunction.BLUR_NOT_SUPPORT_EXPLORER)) {
                    blurModeChanged();
                } else {
                    CameraInterface interfaceC2646a = this.f10939eM;
                    if (interfaceC2646a != null) {
                        interfaceC2646a.mo10513aO();
                    }
                }
            }
            this.mCameraUIManager.m19636S(this.f10850cb.getBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false));
            return;
        }
        if (CameraUIInterface.KEY_SWITCH_CAMERA_BAR.equals(strM13305d) && !this.f10765au) {
            m9816bM();
            return;
        }
        if (CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR.equals(strM13305d)) {
            m9816bM();
            return;
        }
        if (CameraUIInterface.KEY_SWITCH_CAMERA.equals(strM13305d)) {
            m9816bM();
            return;
        }
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(strM13305d) && this.f10850cb != null) {
            if ("standard_high".equals(this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard_high"))) {
                String string3 = this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard");
                if (!"standard_high".equals(string3)) {
                    this.f10850cb.edit().putString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, string3).apply();
                    this.f10850cb.edit().putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false).apply();
                    if (this.mCameraUIManager != null) {
                        this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION);
                    }
                }
            }
            if ("super_raw".equals(this.f10850cb.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off")) && !"standard".equals(this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard"))) {
                this.f10850cb.edit().putString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "on").apply();
                if (this.mCameraUIManager != null) {
                    this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_SUPER_RAW_CONTROL);
                }
            }
            m9811bJ();
            return;
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strM13305d) && this.f10850cb != null) {
            String string4 = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.f10849ca.getString(R.string.camera_shutter_mode_default_value));
            MainShutterButtonInfo c3200bM12076g = this.mModeManager.m12076g();
            if ("normal".equals(string4)) {
                m9904c(strM13305d, false);
                c3200bM12076g.m19235c("button_shape_ring_none");
            } else if ("3".equals(string4)) {
                m9904c(strM13305d, true);
                c3200bM12076g.m19235c("button_shape_countdown_three_seconds");
            } else if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string4)) {
                m9904c(strM13305d, true);
                c3200bM12076g.m19235c("button_shape_countdown_ten_seconds");
            }
            this.mCameraUIManager.mo18091a(c3200bM12076g);
            return;
        }
        if (this.f10850cb != null && CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(strM13305d)) {
            String string5 = this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard_high");
            String string6 = this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard");
            if ("standard_high".equals(string5)) {
                this.f10850cb.edit().putString(CameraUIInterface.KEY_PHOTO_RATIO, "standard_high").apply();
                this.f10850cb.edit().putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, true).apply();
                if (this.mCameraUIManager != null) {
                    this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_PHOTO_RATIO);
                    this.mCameraUIManager.m19911e(strM13305d, true);
                }
                float fM10279aO = m10279aO();
                if (fM10279aO > ZoomManager.f12334a && fM10279aO < 1.0f) {
                    this.f10866cr.m11502b(ZoomManager.f12334a);
                }
                if (string5.equals("standard_high") && !m10327b(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
                    m10236a((AnimatorListenerAdapter) null, true, false);
                    this.f10870cv = 1.0f;
                    this.f10850cb.edit().remove(CameraUIInterface.KEY_ZOOM).apply();
                }
                if (this.mModeManager.isNoneSatUltraWideAngleOpen()) {
                    CameraLog.m12954a("CameraManager", "onSharedPreferenceChanged, turn off wideAngleMode");
                    m10359g(true);
                    this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                    m10359g(false);
                }
            } else if ("standard_high".equals(string6)) {
                this.f10850cb.edit().putString(CameraUIInterface.KEY_PHOTO_RATIO, "standard").apply();
                this.f10850cb.edit().putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false).apply();
                m9904c(strM13305d, false);
            }
            if (this.mCameraUIManager == null || !this.f10850cb.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false)) {
                return;
            }
            if (!this.mModeManager.m11866aa()) {
                if (this.mCameraUIManager.mo18043K()) {
                    this.mCameraUIManager.mo18109a(false, false, true, false);
                }
                this.mCameraUIManager.mo18232j(false, false);
            }
            if (this.mCameraUIManager.mo19966j(CameraUIInterface.KEY_FILTER_PROCESS)) {
                return;
            }
            this.mCameraUIManager.mo18244m(true, false);
            return;
        }
        if (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_HDR.equals(strM13305d)) {
            if (CameraUIInterface.KEY_VIDEO_HDR.equals(strM13305d) && !m10327b(CameraFunction.VIDEO_HDR)) {
                CameraLog.m12966e("CameraManager", "onSharedPreferenceChanged, not support KEY_VIDEO_HDR");
                return;
            }
            if (!this.f10765au) {
                m10097f(strM13305d);
            }
            if (!m10327b(CameraFunction.VIDEO_HDR) || this.f10850cb == null) {
                return;
            }
            m9904c(strM13305d, "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_VIDEO_HDR, this.f10849ca.getResources().getString(R.string.camera_video_hdr_default_value))));
            return;
        }
        if (CameraUIInterface.KEY_FILM_VIDEO_LOG.equals(strM13305d) && !this.f10765au) {
            m10141l(strM13305d);
            if (this.f10850cb != null && this.f10850cb.getString(CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").equals("on")) {
                this.mCameraUIManager.mo18070a(R.string.movie_mode_log_hint, -1, true, false, false);
            } else {
                this.mCameraUIManager.mo18067a(R.string.movie_mode_log_hint);
            }
        }
        if (CameraUIInterface.KEY_FILM_VIDEO_HDR.equals(strM13305d) && !this.f10765au) {
            blurModeChanged();
            if (this.f10850cb != null && this.f10850cb.getString(CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").equals("on")) {
                this.mCameraUIManager.mo18070a(R.string.movie_mode_hdr_hint, -1, true, false, false);
            } else {
                this.mCameraUIManager.mo18067a(R.string.movie_mode_hdr_hint);
            }
        }
        if (CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(strM13305d)) {
            if (this.f10765au) {
                return;
            }
            m10106g(strM13305d);
            return;
        }
        if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(strM13305d)) {
            if (this.f10765au) {
                return;
            }
            m10106g(strM13305d);
            return;
        }
        if (CameraUIInterface.KEY_NIGHT_PRO_MODE.equals(strM13305d)) {
            if (2 == this.f10927eA) {
                this.f10866cr.m11539s();
            }
            if (!this.f10765au && CameraCharacteristicsUtil.m12983f()) {
                blurModeChanged();
                return;
            }
        }
        if (CameraUIInterface.KEY_FLASH_MODE.equals(strM13305d)) {
            String string7 = sharedPreferences.getString(CameraEntry.m13299b(CameraUIInterface.KEY_FLASH_MODE, this.f10846cX.m13317J()), this.f10849ca.getString(R.string.camera_flash_mode_default_value));
            if (!"off".equals(string7)) {
                Settings.System.putInt(this.f10849ca.getContentResolver(), "oplus.camera.flash", 0);
            }
            if ("on".equals(string7) && m10396v()) {
                m10370k(0);
                m10336c(false, true);
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(strM13305d)) {
            if (this.mCameraUIManager != null) {
                String strM11787S = this.mModeManager.m11787S();
                if (!"off".equals(strM11787S)) {
                    Settings.System.putInt(this.f10849ca.getContentResolver(), "oplus.camera.flash", 0);
                }
                if (Camera.f10611m || Camera.f10610l) {
                    if (!"off".equals(strM11787S)) {
                        if (Camera.f10611m) {
                            this.mCameraUIManager.mo18070a(R.string.camera_high_temperature_flash_disable, -1, true, false, false);
                            m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_FLASH);
                        } else if (Camera.f10610l) {
                            this.mCameraUIManager.mo18070a(R.string.camera_low_battery_flash_disable, -1, true, false, false);
                            m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_FLASH);
                        }
                        if (this.f10850cb != null) {
                            SharedPreferences.Editor editorEdit = this.f10850cb.edit();
                            editorEdit.putString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off");
                            editorEdit.apply();
                        }
                        this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_VIDEO_FLASH_MODE);
                    }
                    this.mModeManager.m11898b(false, false);
                    return;
                }
                this.mModeManager.m11783O();
                OneCamera interfaceC2694d = this.f10852cd;
                if (interfaceC2694d != null) {
                    interfaceC2694d.mo13069b(strM11787S);
                    this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                    return;
                }
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_TORCH_MODE.equals(strM13305d)) {
            String string8 = sharedPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.f10849ca));
            if (this.mModeManager.m12091j(CameraFunction.TORCH_SOFT_LIGHT)) {
                if ("on".equals(string8)) {
                    this.f10852cd.mo13069b(CameraParameter.FlashMode.FLASH_TORCH);
                } else {
                    this.f10852cd.mo13069b("off");
                }
                this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_MOVIE_FLASH_MODE.equals(strM13305d)) {
            if ("off".equals(sharedPreferences.getString(strM13305d, "off"))) {
                return;
            }
            Settings.System.putInt(this.f10849ca.getContentResolver(), "oplus.camera.flash", 0);
            return;
        }
        if (CameraUIInterface.KEY_VIVID_EFFECT.equals(strM13305d)) {
            if (this.f10766av) {
                return;
            }
            int i2 = R.string.camera_vivid_close_toast;
            if (this.mModeManager.m11842aC()) {
                i2 = R.string.camera_vivid_open_toast;
            }
            int i3 = i2;
            if (this.mCameraUIManager != null) {
                this.mCameraUIManager.mo18070a(i3, -1, true, false, false);
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_CURRENT_STICKER_UUID.equals(strM13305d)) {
            StickerItem stickerItemM22706a = ImageStickerTools.m22687b(this.f10849ca).m22706a(this.f10850cb);
            if (ImageStickerTools.m22691b(this.f10844cV) && !ImageStickerTools.m22691b(stickerItemM22706a)) {
                if (2 == AlgoSwitchConfig.getApsVersion() && !m10384p()) {
                    this.f10852cd.mo13088e("type_preview_frame");
                } else {
                    this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
            }
            this.f10844cV = stickerItemM22706a;
        }
        if (CameraUIInterface.KEY_SWITCH_DUAL_CAMERA.equals(strM13305d)) {
            m9669a(m10220R(), true, true);
            return;
        }
        if (CameraUIInterface.KEY_SUPER_EIS_WIDE.equals(strM13305d) && !this.f10765au) {
            blurModeChanged();
        }
        if (CameraUIInterface.KEY_PI_AI.equals(strM13305d)) {
            if (this.mCameraUIManager != null && 18 != this.f10700H) {
                this.f10700H = 0;
                this.mCameraUIManager.m19908dz();
                this.mCameraUIManager.m19903du();
                this.mModeManager.m11783O();
            }
            this.mModeManager.m11886au();
            this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            return;
        }
        if (CameraUIInterface.KEY_PI.equals(strM13305d)) {
            this.mModeManager.m11887av();
            this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            return;
        }
        if (CameraUIInterface.KEY_AI_HIGH_PIXEL.equals(strM13305d)) {
            m9811bJ();
            return;
        }
        if (CameraUIInterface.KEY_HIGH_PICTURE_SIZE.equals(strM13305d) && this.f10850cb != null) {
            this.f10767aw = this.f10850cb.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
            SharedPreferences.Editor editorEdit2 = this.f10850cb.edit();
            if (!this.f10767aw) {
                this.mCameraUIManager.mo18110a(R.string.camera_picture_size_standard_high_hint);
                this.mCameraUIManager.mo18282w(true);
                this.f10700H = 0;
                if (this.f10850cb.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE_BACKUP, "off").equals("on")) {
                    editorEdit2.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "on");
                    editorEdit2.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE_BACKUP, "off");
                    editorEdit2.apply();
                }
            } else if (this.mModeManager.m11990cY()) {
                editorEdit2.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
                editorEdit2.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE_BACKUP, "on");
                editorEdit2.apply();
            }
            CameraLog.m12962c("CameraManager", "onSharedPreferenceChanged, mbHighPictureResolutionOn: " + this.f10767aw);
            return;
        }
        if (CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(strM13305d) && m10327b(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE)) {
            this.f10866cr.m11489a(getMinZoomValue(), m10283aS(), this.f10866cr.m11486a(), this.f10853ce.m13269d(), this.mModeManager.m12012cu(), this.mModeManager.m11922bS());
            return;
        }
        if (CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU.equals(strM13305d)) {
            if (this.mModeManager.m12091j(CameraFunction.SAT_CAMERA)) {
                blurModeChanged();
                return;
            } else {
                if (this.f10765au || !"movie".equals(this.mModeManager.m12105n())) {
                    return;
                }
                m9813bK();
                return;
            }
        }
        if (CameraUIInterface.KEY_FISH_EYE_MODE.equals(strM13305d)) {
            if (this.mCameraUIManager != null) {
                this.mCameraUIManager.mo18035G("on".equals(sharedPreferences.getString(strM13305d, "off")));
            }
            m9823bP();
            return;
        }
        if (CameraUIInterface.KEY_FILTER_LIST_TYPE.equals(strM13305d) && m10327b(CameraUIInterface.KEY_FUJI_FILTER_MENU) && this.mCameraUIManager != null) {
            this.mCameraUIManager.m19716ao(true);
        }
        if ("mode_arrange_reddot_show".equals(strM13305d)) {
            this.mCameraUIManager.mo18177b(R.string.camera_mode_arrange);
        }
        if (CameraUIInterface.KEY_MACRO_SWITCH.equals(CameraEntry.m13305d(strM13305d))) {
            if ("off".equals(this.f10850cb.getString(strM13305d, "auto"))) {
                OplusGLSurfaceView_13 = R.string.camera_macro_mode_notice_off;
                z = false;
            } else {
                OplusGLSurfaceView_13 = R.string.camera_macro_mode_notice_on;
            }
            this.mCameraUIManager.m19955g(18, z);
            if (this.mCameraUIManager.mo18233k().m18490a(CameraUIInterface.KEY_MACRO_SWITCH)) {
                this.mCameraUIManager.mo18067a(z ? R.string.camera_macro_mode_notice_off : R.string.camera_macro_mode_notice_on);
                this.mCameraUIManager.mo18070a(OplusGLSurfaceView_13, -1, true, false, false);
            }
        }
        if (!CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU.equals(CameraEntry.m13305d(strM13305d)) || "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, this.f10849ca.getString(R.string.camera_slow_video_mode_frame_default_value)))) {
            return;
        }
        m10318b(this.f10870cv);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m10141l(String str) {
        if (m10150n(str)) {
            Size sizeM19747bG = this.mCameraUIManager.m19747bG();
            int iM11789U = this.mModeManager.m11789U();
            if (m9705a(sizeM19747bG, sizeM19747bG, iM11789U, iM11789U, false, 0, (CameraPreviewUI.PlatformImplementations.kt_3) new C2585m(this, null))) {
                m10353f(true);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean m10145m(String str) {
        BaseMode baseModeM11800a = this.mModeManager.m11800a(str);
        if (baseModeM11800a != null) {
            return baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && baseModeM11800a.isAiEnhancementVideoOpen() && baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT);
        }
        CameraLog.m12954a("CameraManager", "openVideoAiEnhancementUltraWide, mode is null");
        return false;
    }

    /* renamed from: cC */
    private boolean m9916cC() {
        return this.f10850cb != null && "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
    }

    /* renamed from: cD */
    private void m9918cD() {
        m10362h(true);
        if (this.mModeManager != null) {
            if (this.mModeManager.isNoneSatUltraWideAngleOpen()) {
                this.mModeManager.m12002ck();
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && (m10327b(CameraUIInterface.KEY_FLASH_MODE) || m10327b(CameraUIInterface.KEY_VIDEO_FLASH_MODE))) {
                    this.mModeManager.m12134v(true);
                    if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM) && this.mModeManager.m12095k()) {
                        this.mModeManager.m12134v(false);
                    }
                    this.mModeManager.m11827a(this.mModeManager.m11787S(), !this.f10758an);
                }
                if (this.mCameraUIManager != null && this.mCameraUIManager.mo18051O()) {
                    this.mCameraUIManager.mo18176b(true, false, true, false);
                }
            } else if (m10327b(CameraUIInterface.KEY_FLASH_MODE) || m10327b(CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
                this.mModeManager.m12134v(this.mModeManager.m12006co());
                this.mModeManager.m11827a(this.mModeManager.m11787S(), true ^ this.f10758an);
            }
        }
        m9819bN();
    }

    /* renamed from: cE */
    private void m9920cE() {
        if (this.f10846cX.m13329a(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON), this.f10989y) == this.f10852cd.mo13075c()) {
            return;
        }
        m10365i(true);
        if (this.mModeManager != null) {
            if (this.mModeManager.m12006co()) {
                this.mModeManager.m12003cl();
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && (m10327b(CameraUIInterface.KEY_FLASH_MODE) || m10327b(CameraUIInterface.KEY_VIDEO_FLASH_MODE))) {
                    this.mModeManager.m12134v(true);
                    this.mModeManager.m11827a(this.mModeManager.m11787S(), !this.f10759ao);
                }
                if (this.mCameraUIManager != null && this.mCameraUIManager.mo18051O()) {
                    this.mCameraUIManager.mo18176b(true, false, true, false);
                }
            } else if (m10327b(CameraUIInterface.KEY_FLASH_MODE) || m10327b(CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
                this.mModeManager.m12134v(this.mModeManager.isNoneSatUltraWideAngleOpen());
                this.mModeManager.m11827a(this.mModeManager.m11787S(), true ^ this.f10759ao);
            }
        }
        m9820bO();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m9904c(String str, boolean z) {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19911e(str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cF */
    public void m9922cF() {
        boolean z = (this.mModeManager.m11946bq() || this.mModeManager.m11947br() || this.mCameraUIManager.m19875dS() || this.mCameraUIManager.m19864dH() || !this.f10760ap) ? false : true;
        if (m10269aE()) {
            return;
        }
        this.mCameraUIManager.m19730b(this.f10989y, z, this.mCameraUIManager.mo18057R());
    }

    /* renamed from: com.oplus.camera.CameraManager$y */
    private class C2597y implements CameraPreviewUI.PlatformImplementations.kt_3 {
        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return -1;
        }

        private C2597y() {
        }

        /* synthetic */ C2597y(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            Size sizeM19747bG = CameraManager.this.mCameraUIManager.m19747bG();
            CameraLog.m12954a("CameraManager", "VideoSizeChangeAnimationListenerImpl, onAnimationStart, currSize: " + sizeM19747bG.getWidth() + "x" + sizeM19747bG.getHeight() + ", toSize: " + size.getWidth() + "x" + size.getHeight());
            if (CameraManager.this.mModeManager.m11861aV()) {
                return;
            }
            if (TextUtils.equals(ApsConstant.REC_MODE_COMMON, CameraManager.this.mModeManager.m12105n()) || TextUtils.equals(ApsConstant.REC_MODE_SLOW_VIDEO, CameraManager.this.mModeManager.m12105n()) || TextUtils.equals(ApsConstant.REC_MODE_FAST_VIDEO, CameraManager.this.mModeManager.m12105n()) || TextUtils.equals("movie", CameraManager.this.mModeManager.m12105n()) || TextUtils.equals(ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO, CameraManager.this.mModeManager.m12105n())) {
                CameraManager.this.f10738aT = true;
                if (CameraManager.this.f10846cX.m13329a(CameraManager.this.mModeManager.m12105n(), CameraManager.this.f10989y) != CameraManager.this.f10852cd.mo13075c()) {
                    CameraManager.this.m10374l(4);
                    return;
                }
                CameraManager.this.m10308ar();
                CameraManager.this.m10378n(1);
                if (ApsConstant.REC_MODE_COMMON.equals(CameraManager.this.mModeManager.m12105n())) {
                    CameraManager.this.m9922cF();
                }
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            CameraLog.m12954a("CameraManager", "VideoSizeChangeAnimationListenerImpl, onAnimationMiddle");
            CameraManager.this.m10244a(size2, true);
            CameraManager.this.mModeManager.m11895b(mo10945b(), true);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            CameraLog.m12954a("CameraManager", "VideoSizeChangeAnimationListenerImpl, onAnimationEnd");
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            CameraManager.this.mCameraUIManager.mo18200d(true, false);
            CameraManager.this.m10335c(false);
            CameraManager.this.m10353f(false);
            CameraManager.this.m10368j(false);
            CameraManager.this.m10339d(-1);
            CameraManager.this.m10362h(false);
            CameraManager.this.mCameraUIManager.m19641W(true);
            CameraManager.this.mCameraUIManager.mo18227i(true);
            if (PopUpWindowManager.m20706a()) {
                PopUpWindowManager.m20712d();
            }
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$OplusGLSurfaceView_6 */
    private class C2585m implements CameraPreviewUI.PlatformImplementations.kt_3 {
        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return 6;
        }

        private C2585m() {
        }

        /* synthetic */ C2585m(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraLog.m12954a("CameraManager", "HdrAnimationListenerImpl, onAnimationStart");
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            if (CameraManager.this.f10846cX.m13329a(CameraManager.this.mModeManager.m12105n(), CameraManager.this.f10989y) != CameraManager.this.f10852cd.mo13075c()) {
                if (!CameraManager.this.f10762ar && CameraManager.this.f10913dm != null && CameraManager.this.f10913dm.m11007b() == 0) {
                    CameraLog.m12962c("CameraManager", "onAnimationStart, open camera");
                    CameraManager.this.m10374l(1);
                    return;
                } else {
                    CameraLog.m12962c("CameraManager", "onAnimationStart, mode is changing or will change soon, don't open camera");
                    return;
                }
            }
            CameraManager.this.m10308ar();
            CameraManager.this.m10378n(1);
            if (ApsConstant.REC_MODE_COMMON.equals(CameraManager.this.mModeManager.m12105n())) {
                CameraManager.this.m9922cF();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            CameraLog.m12967f("CameraManager", "HdrAnimationListenerImpl, onAnimationMiddle");
            if (PopUpWindowManager.m20706a()) {
                PopUpWindowManager.m20712d();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            CameraLog.m12967f("CameraManager", "HdrAnimationListenerImpl, onAnimationEnd");
            CameraManager.this.mModeManager.m11895b(mo10945b(), true);
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            CameraManager.this.mCameraUIManager.mo18200d(true, false);
            CameraManager.this.m10353f(false);
            CameraManager.this.m10368j(false);
            CameraManager.this.m10362h(false);
            CameraManager.this.m10339d(-1);
            CameraManager.this.mCameraUIManager.mo18227i(true);
            CameraManager.this.mModeManager.m11895b(13, true);
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$IntrinsicsJvm.kt_5 */
    private class C2576d implements CameraPreviewUI.PlatformImplementations.kt_3 {
        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return 16;
        }

        private C2576d() {
        }

        /* synthetic */ C2576d(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraLog.m12954a("CameraManager", "BlurModeAnimationListenerImpl, onAnimationStart");
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            CameraManager.this.mCameraUIManager.mo18067a(R.string.toast_ultra_wide_angel_lens);
            CameraManager.this.mCameraUIManager.mo18067a(R.string.toast_ultra_wide_micro_lens);
            if (!CameraManager.this.m10268aD() && CameraManager.this.f10846cX.m13329a(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON), CameraManager.this.f10989y) != CameraManager.this.f10852cd.mo13075c()) {
                CameraManager.this.m10374l(1);
                return;
            }
            CameraManager.this.m10308ar();
            CameraManager.this.m10378n(1);
            if (ApsConstant.REC_MODE_COMMON.equals(CameraManager.this.mModeManager.m12105n())) {
                CameraManager.this.m9922cF();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            CameraLog.m12967f("CameraManager", "BlurModeAnimationListenerImpl, onAnimationMiddle");
            if (PopUpWindowManager.m20706a()) {
                PopUpWindowManager.m20704a(true);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            CameraLog.m12967f("CameraManager", "BlurModeAnimationListenerImpl, onAnimationEnd");
            CameraManager.this.mModeManager.m11895b(mo10945b(), true);
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m9580A(cameraManager.mModeManager.m12007cp());
            boolean z = false;
            CameraManager.this.mCameraUIManager.mo18200d(true, false);
            CameraManager.this.m10353f(false);
            CameraManager.this.m10368j(false);
            CameraManager.this.m10362h(false);
            CameraManager.this.m10365i(false);
            CameraManager.this.m10339d(-1);
            CameraManager.this.mCameraUIManager.mo18227i(true);
            if (1 == CameraManager.this.m10300aj().mo16539j() && CameraManager.this.mCameraUIManager.mo18051O()) {
                z = true;
            }
            CameraManager.this.mCameraUIManager.m19730b(CameraManager.this.f10989y, !z, CameraManager.this.mCameraUIManager.mo18057R());
            CameraManager.this.mModeManager.m11895b(13, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.oplus.camera.CameraManager$OplusGLSurfaceView_5 */
    class C2583k implements CameraPreviewUI.PlatformImplementations.kt_3 {
        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return 16;
        }

        private C2583k() {
        }

        /* synthetic */ C2583k(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraLog.m12967f("CameraManager", "FishEyeAnimationListenerImpl, onAnimationStart");
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            CameraManager.this.f10932eF.postDelayed(new Runnable() { // from class: com.oplus.camera.-$$Lambda$CameraManager$OplusGLSurfaceView_5$NzB-1003wfsZ8QYkRJ30Cb0OFK0
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m11001c();
                }
            }, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_3 */
        public /* synthetic */ void m11001c() {
            CameraManager.this.m10007cw();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            CameraLog.m12967f("CameraManager", "FishEyeAnimationListenerImpl, onAnimationMiddle");
            if (PopUpWindowManager.m20706a()) {
                PopUpWindowManager.m20704a(false);
            }
            if (CameraManager.this.mCameraUIManager == null || !CameraManager.this.m10207E()) {
                return;
            }
            CameraManager.this.mCameraUIManager.mo18183c().mo14259m();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            CameraLog.m12967f("CameraManager", "FishEyeAnimationListenerImpl, onAnimationEnd");
            CameraManager.this.mModeManager.m11895b(mo10945b(), true);
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m9580A(cameraManager.mModeManager.m12007cp());
            CameraManager.this.mCameraUIManager.mo18200d(true, false);
            CameraManager.this.m10353f(false);
            CameraManager.this.m10368j(false);
            CameraManager.this.m10339d(-1);
            CameraManager.this.mCameraUIManager.mo18227i(true);
            CameraManager.this.mModeManager.m11895b(13, true);
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$IntrinsicsJvm.kt_4 */
    private class C2574b implements CameraPreviewUI.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Size f11150b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Size f11151c;

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return 17;
        }

        private C2574b() {
            this.f11150b = null;
            this.f11151c = null;
        }

        /* synthetic */ C2574b(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraLog.m12954a("CameraManager", "BaseSwitchDualCameraAnimationListenerImpl, onAnimationStart");
            CameraManager.this.mModeManager.m11895b(mo10945b(), false);
            CameraManager.this.mCameraUIManager.mo18067a(CameraManager.this.m10310at());
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            CameraManager cameraManager = CameraManager.this;
            cameraManager.switchCamera(cameraManager.m10220R());
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseSwitchDualCameraAnimationListenerImpl, onAnimationMiddle , fromSize: ");
            sb.append(size != null ? size.toString() : null);
            sb.append(", toSize: ");
            sb.append(size2 != null ? size2.toString() : null);
            CameraLog.m12954a("CameraManager", sb.toString());
            this.f11150b = size2;
            this.f11151c = size;
            if (PopUpWindowManager.m20706a()) {
                PopUpWindowManager.m20712d();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            CameraLog.m12967f("CameraManager", "BaseSwitchDualCameraAnimationListenerImpl, onAnimationEnd");
            CameraManager.this.mModeManager.m11895b(mo10945b(), true);
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            if (!CameraManager.this.mModeManager.m11953bx()) {
                CameraManager.this.m10244a(this.f11150b, true);
            }
            CameraManager.this.mCameraUIManager.mo18200d(true, false);
            CameraManager.this.m10353f(false);
            CameraManager.this.m10368j(false);
            InverseManager.INS.setMaskAlpha(CameraManager.this.f10849ca, true, false);
            CameraManager.this.m10362h(false);
            CameraManager.this.m10339d(-1);
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m9580A(cameraManager.mModeManager.m12007cp());
            CameraManager.this.mCameraUIManager.mo18227i(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m10201z(int OplusGLSurfaceView_13) {
        if (-1 == OplusGLSurfaceView_13 || this.mCameraUIManager == null) {
            return;
        }
        this.mCameraUIManager.mo18067a(OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m9580A(int OplusGLSurfaceView_13) {
        if (-1 == OplusGLSurfaceView_13 || this.mCameraUIManager == null) {
            return;
        }
        this.mCameraUIManager.mo18070a(OplusGLSurfaceView_13, -1, true, false, false);
    }

    /* renamed from: com.oplus.camera.CameraManager$q */
    private class C2589q implements CameraPreviewUI.PlatformImplementations.kt_3 {
        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return -1;
        }

        private C2589q() {
        }

        /* synthetic */ C2589q(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraManager.this.m10308ar();
            if (CameraManager.this.m10215M()) {
                CameraManager.this.m10378n(1);
            } else {
                CameraManager.this.m10374l(1);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
                CameraManager.this.m10368j(false);
                CameraManager.this.m10339d(-1);
                CameraManager.this.mModeManager.m11895b(20, false);
            }
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$t */
    public class C2592t implements CameraPreviewUI.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Size f11206b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Size f11207c = null;

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return -1;
        }

        public C2592t() {
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraLog.m12954a("CameraManager", "PictureSizeAnimationListenerImpl, onAnimationStart");
            if (CameraManager.this.f10757am || 2 != CameraManager.this.f10846cX.m13317J()) {
                if (Util.m24495t()) {
                    CameraManager.this.mCameraUIManager.m19892dj();
                }
                CameraManager.this.mCameraUIManager.mo18200d(false, false);
                if (2 == Util.m24426d(size.getWidth(), size.getHeight())) {
                    CameraManager.this.mModeManager.m11895b(13, true);
                }
                CameraManager.this.m10308ar();
                if (CameraManager.this.m10215M()) {
                    CameraManager.this.m10378n(1);
                } else {
                    CameraManager.this.m10374l(4);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            StringBuilder sb = new StringBuilder();
            sb.append("PictureSizeAnimationListenerImpl, onAnimationMiddle , fromSize: ");
            sb.append(size != null ? size.toString() : null);
            sb.append(", toSize: ");
            sb.append(size2 != null ? size2.toString() : null);
            CameraLog.m12954a("CameraManager", sb.toString());
            this.f11206b = size2;
            this.f11207c = size;
            if (PopUpWindowManager.m20706a()) {
                PopUpWindowManager.m20712d();
            }
            CameraManager.this.mModeManager.m11895b(mo10945b(), true);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            CameraLog.m12954a("CameraManager", "PictureSizeAnimationListenerImpl, onAnimationEnd");
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            if (!CameraManager.this.mModeManager.m11953bx()) {
                CameraManager.this.m10244a(this.f11206b, true);
            }
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11513d(CameraManager.this.f10927eA);
            }
            CameraManager.this.mCameraUIManager.m19825cb();
            CameraManager.this.m10398w(true);
            CameraManager.this.mCameraUIManager.mo18200d(true, false);
            CameraManager.this.mCameraUIManager.m19711aj(true);
            CameraManager.this.m10335c(false);
            CameraManager.this.m10353f(false);
            CameraManager.this.m10368j(false);
            CameraManager.this.m10339d(-1);
            CameraManager.this.mCameraUIManager.mo18227i(true);
            if (Util.m24495t() && !this.f11207c.equals(this.f11206b) && !"standard_high".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard_high"))) {
                CameraManager.this.mModeManager.m12080h(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard"));
            }
            CameraManager.this.mModeManager.m11895b(13, true);
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$OplusGLSurfaceView_15 */
    public class C2582j implements CameraPreviewUI.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f11172b = false;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f11173c = false;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f11174d = false;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Size f11175e = null;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f11176f = 0;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f11177g = 0;

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return 1;
        }

        public C2582j() {
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean m10998e() {
            if (Util.m24418c(this.f11176f)) {
                return true;
            }
            return (Util.m24454g(this.f11176f) || (Util.m24346ai() && Util.m24442e(this.f11176f, this.f11177g) && !Util.m24418c(this.f11177g))) ? false : true;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraLog.m12954a("CameraManager", "switch camera mode, onAnimationStart");
            this.f11172b = true;
            this.f11173c = true;
            this.f11174d = false;
            CameraManager.this.mCameraUIManager.m19763bW();
            String string = CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, Util.m24382b(CameraManager.this.f10846cX.m13317J() == 3));
            BaseMode baseModeM11800a = CameraManager.this.mModeManager.m11800a(string);
            if (!baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
                CameraManager.this.mCameraUIManager.mo18259q(true);
            }
            if (CameraManager.this.mCameraUIManager.mo18043K()) {
                CameraManager.this.mCameraUIManager.mo18109a(Util.m24495t(), true, true, true);
            }
            if (CameraManager.this.mCameraUIManager.mo18051O()) {
                CameraManager.this.mCameraUIManager.m19847cx();
            }
            if (CameraManager.this.mCameraUIManager.m19950ex()) {
                CameraManager.this.mCameraUIManager.m19925eM();
            }
            CameraManager.this.mCameraUIManager.mo18024B(false);
            if (CameraManager.this.mModeManager.m11849aJ() && CameraManager.this.f10867cs != null) {
                CameraManager.this.f10867cs.resetTiltShiftParams();
            }
            if (!baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
                CameraManager.this.mCameraUIManager.mo18048N();
            }
            CameraManager.this.mCameraUIManager.mo18067a(CameraManager.this.m10310at());
            CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_slow_video_tips);
            CameraManager.this.mCameraUIManager.m19814cQ();
            if (baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_ZOOM) && !baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_EXPAND_POPBAR)) {
                if (CameraManager.this.f10866cr != null && CameraManager.this.f10866cr.m11528j()) {
                    CameraManager.this.m10313aw();
                }
            } else {
                CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, false);
            }
            if (CameraManager.this.m10327b(CameraUIInterface.KEY_MACRO_SWITCH)) {
                CameraManager.this.mCameraUIManager.m19711aj(true);
                CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_ai_scn_microspur);
                CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_mode_macro_hint);
            }
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m10201z(cameraManager.mModeManager.m12007cp());
            CameraManager.this.mModeManager.m11895b(18, false);
            CameraManager.this.mCameraUIManager.mo18172b(baseModeM11800a.getCameraMode(), true);
            CameraManager.this.m9702a(true, false, true);
            CameraManager.this.mModeManager.m11895b(18, true);
            if (!baseModeM11800a.showBeautyButton()) {
                CameraManager.this.mCameraUIManager.mo18232j(true, false);
            } else {
                CameraManager.this.mCameraUIManager.mo18240l(true, Util.m24498u() && (CameraManager.this.mCameraUIManager.mo18053P() || CameraManager.this.mCameraUIManager.mo18055Q()));
            }
            if (baseModeM11800a.showMenuLeftButton()) {
                CameraManager.this.mCameraUIManager.mo18228i(true, Util.m24498u() && (CameraManager.this.mCameraUIManager.mo18053P() || CameraManager.this.mCameraUIManager.mo18055Q()));
            } else if (!ApsConstant.CAPTURE_MODE_NIGHT.equals(string) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_PRO_MODE_SUPPORT)) {
                CameraManager.this.mCameraUIManager.mo18223h(true, false);
            } else {
                CameraManager.this.mCameraUIManager.mo18223h(false, false);
            }
            if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) && !CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_EXPAND_POPBAR)) {
                if (CameraManager.this.mModeManager.m12012cu().m11317K() && !CameraManager.this.mModeManager.m11921bR()) {
                    CameraManager cameraManager2 = CameraManager.this;
                    cameraManager2.m10318b(cameraManager2.m10282aR());
                } else if (ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(string)) {
                    CameraManager cameraManager3 = CameraManager.this;
                    cameraManager3.m10318b(cameraManager3.m10282aR());
                    CameraManager.this.mCameraUIManager.mo18288z(true);
                }
            }
            if (baseModeM11800a.canShowTimeLapseProButtons()) {
                CameraManager.this.mCameraUIManager.mo18252o(true, false);
                CameraManager.this.mCameraUIManager.mo18260q(true, false);
            } else {
                CameraManager.this.mCameraUIManager.mo18256p(true, false);
                CameraManager.this.mCameraUIManager.mo18264r(true, false);
            }
            if (CameraManager.this.m10327b(CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
                CameraManager.this.mCameraUIManager.mo18049N(true);
            } else {
                CameraManager.this.mCameraUIManager.mo18050O(true);
            }
            CameraManager.this.mCameraUIManager.m19913eA();
            CameraManager.this.mCameraUIManager.m19685a(CameraManager.this.mModeManager.m12105n(), CameraManager.this.mModeManager.m12076g(), CameraManager.this.m10047de());
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            StringBuilder sb = new StringBuilder();
            sb.append("switch camera mode, onAnimationMiddle, mbCancle: ");
            sb.append(this.f11174d);
            sb.append(", fromSize: ");
            sb.append(size != null ? size.toString() : null);
            sb.append(", toSize: ");
            sb.append(size2 != null ? size2.toString() : null);
            CameraLog.m12954a("CameraManager", sb.toString());
            this.f11173c = false;
            this.f11175e = size2;
            if (size2 != null) {
                this.f11177g = Util.m24426d(size2.getWidth(), size2.getHeight());
            }
            if (size != null) {
                this.f11176f = Util.m24426d(size.getWidth(), size.getHeight());
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() {
            CameraLog.m12954a("CameraManager", "switch camera mode, onAnimationEnd, mbCancle: " + this.f11174d);
            if (this.f11174d) {
                return;
            }
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            if (!m10998e() && !CameraManager.this.mCameraUIManager.m19864dH()) {
                CameraManager.this.m10244a(this.f11175e, true);
            }
            if (CameraManager.this.mCameraUIManager != null && !CameraManager.this.mCameraUIManager.mo19881dY() && !CameraManager.this.mCameraUIManager.m19864dH() && 0.0f == CameraManager.this.mCameraUIManager.m19865dI()) {
                CameraManager.this.mCameraUIManager.m19910e(1.0f);
            }
            CameraManager.this.m10335c(false);
            CameraManager.this.m10367j(1);
            CameraManager.this.m10368j(false);
            CameraManager.this.m10339d(-1);
            if (!CameraManager.this.f10752ah) {
                if (!CameraManager.this.mCameraUIManager.m19875dS() || !CameraManager.this.mCameraUIManager.m19864dH()) {
                    CameraManager.this.mCameraUIManager.mo18200d(true, false);
                    CameraManager.this.mCameraUIManager.mo18227i(true);
                } else {
                    CameraManager.this.mCameraUIManager.mo18200d(false, true);
                    CameraManager.this.mCameraUIManager.mo18227i(false);
                }
                CameraManager.this.mCameraUIManager.m19730b(CameraManager.this.f10989y, true, CameraManager.this.mCameraUIManager.mo18057R());
                this.f11172b = false;
                CameraManager.this.mModeManager.m11895b(13, true);
                CameraManager.this.mModeManager.m11895b(19, true);
                CameraManager.this.m9926cH();
                return;
            }
            this.f11172b = false;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m10999c() {
            CameraLog.m12954a("CameraManager", "switch camera mode, cancleAnimation");
            CameraManager.this.m10368j(false);
            CameraManager.this.m10339d(-1);
            CameraManager.this.mCameraUIManager.mo18183c().m23489t();
            this.f11174d = true;
            this.f11172b = false;
            this.f11173c = false;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m11000d() {
            CameraLog.m12954a("CameraManager", "switch camera mode, isAnimationRunning, mbRunning: " + this.f11172b);
            return this.f11172b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cG */
    public boolean m9923cG() {
        CameraLog.m12954a("CameraManager", "canRunSwitchAnim, mbPaused: " + this.f10752ah + ", mAfterSwitchPrvSize: " + this.f10909di);
        return (this.f10752ah || this.f10909di == null) ? false : true;
    }

    /* renamed from: com.oplus.camera.CameraManager$w */
    public class C2595w implements CameraScreenNail.IntrinsicsJvm.kt_5 {
        public C2595w() {
        }

        @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11050a() {
            CameraLog.m12954a("CameraManager", "onSwitchAnimStart");
            if (CameraManager.this.f10752ah) {
                return;
            }
            CameraManager.this.mCameraUIManager.m19763bW();
            if (CameraManager.this.mCameraUIManager.mo18023A()) {
                CameraManager.this.mCameraUIManager.mo18259q(false);
                CameraManager.this.mCameraUIManager.m19873dQ();
            }
            if (CameraManager.this.mCameraUIManager.mo18043K()) {
                CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
            }
            CameraManager.this.mCameraUIManager.mo18024B(false);
            if (CameraManager.this.mCameraUIManager.mo18051O()) {
                CameraManager.this.mCameraUIManager.mo18176b(true, true, true, false);
            }
            CameraManager.this.mCameraUIManager.mo18067a(CameraManager.this.m10310at());
            CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_slow_video_tips);
            CameraManager.this.mCameraUIManager.m19814cQ();
            CameraManager.this.mCameraUIManager.m19883da();
            if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) || CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_EXPAND_POPBAR)) {
                CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, false);
            }
            if (!CameraManager.this.mModeManager.m11950bu()) {
                CameraManager.this.mCameraUIManager.mo18256p(true, false);
                CameraManager.this.mCameraUIManager.mo18264r(true, false);
            }
            CameraManager.this.mModeManager.m11895b(13, false);
            CameraManager.this.mModeManager.m11895b(12, false);
            CameraManager.this.f10926dz = true;
            CameraManager.this.m10302al();
        }

        @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo11051b() {
            CameraLog.m12954a("CameraManager", "onSwitchAnimMiddle, mAfterSwitchPrvSize: " + CameraManager.this.f10909di);
            if (!CameraManager.this.m9923cG() || CameraManager.this.mModeManager.m12049di()) {
                return;
            }
            CameraManager.this.mCameraUIManager.m19670a(CameraManager.this.f10909di, CameraManager.this.f10909di, false);
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m10244a(cameraManager.f10909di, false);
            if (CameraManager.this.mModeManager.m12082h()) {
                return;
            }
            CameraManager.this.mCameraUIManager.m19670a(CameraManager.this.f10909di, CameraManager.this.f10909di, true);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo11052c() {
            CameraLog.m12967f("CameraManager", "onSwitchAnimEnd");
            if (CameraManager.this.f10752ah) {
                return;
            }
            if (!CameraManager.this.f10954eg.m16299c()) {
                CameraManager.this.m10158p("0");
            }
            if (CameraManager.this.m9923cG()) {
                CameraManager.this.mModeManager.m11895b(2, true);
                CameraManager.this.mCameraUIManager.m19670a(CameraManager.this.f10909di, CameraManager.this.mModeManager.m11796a(CameraManager.this.f10853ce), true);
                CameraManager.this.mCameraUIManager.m19641W(true);
                CameraManager.this.mCameraUIManager.mo18213f(true, false);
                CameraManager.this.m10211I();
                CameraManager.this.mCameraUIManager.mo18200d(true, false);
                if (CameraManager.this.f10849ca != null) {
                    CameraManager.this.f10849ca.onUserInteraction();
                }
                CameraManager.this.mModeManager.m11884as();
                if (CameraManager.this.mCameraUIManager.mo18043K()) {
                    CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
                }
                if (CameraManager.this.mCameraUIManager.mo18023A() && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_FILTER_PROCESS) && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
                    CameraManager.this.f10850cb.edit().putBoolean(CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, true).apply();
                }
                String str = null;
                if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
                    str = CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU;
                } else if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_FILTER_MENU)) {
                    str = CameraUIInterface.KEY_FILTER_MENU;
                } else if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
                    str = CameraUIInterface.KEY_VIDEO_FILTER_MENU;
                } else if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
                    str = CameraUIInterface.KEY_NIGHT_FILTER_MENU;
                }
                if (str != null) {
                    CameraManager.this.mCameraUIManager.mo18216g(str);
                }
                if (CameraManager.this.mModeManager.m11866aa()) {
                    CameraManager.this.mCameraUIManager.mo18240l(true, false);
                } else {
                    CameraManager.this.mCameraUIManager.mo18232j(true, false);
                }
                if (!CameraManager.this.mModeManager.m11949bt()) {
                    CameraManager.this.mCameraUIManager.mo18223h(true, false);
                } else if (CameraManager.this.mModeManager.m11949bt() && !CameraManager.this.mCameraUIManager.mo18043K() && !CameraManager.this.mCameraUIManager.mo18051O()) {
                    CameraManager.this.mCameraUIManager.mo18228i(true, false);
                }
                CameraManager.this.m9926cH();
                CameraManager.this.m10340d(false);
                CameraManager.this.m10353f(false);
                CameraManager.this.m10368j(false);
                CameraManager.this.m10339d(-1);
                CameraManager.this.mModeManager.m11895b(13, true);
                if (CameraManager.this.f10909di != null && !CameraManager.this.mModeManager.m12049di()) {
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.m10244a(cameraManager.f10909di, false);
                }
            }
            InverseManager.INS.setMaskAlpha(CameraManager.this.f10849ca, true, true);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo11049a(int OplusGLSurfaceView_13) {
            int iM12108o = CameraManager.this.mModeManager.m12108o(OplusGLSurfaceView_13);
            CameraLog.m12954a("CameraManager", "getSwitchAnimTime, switchTime: " + iM12108o + ", cameraId: " + OplusGLSurfaceView_13);
            return iM12108o;
        }

        @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo11053d() {
            CameraLog.m12954a("CameraManager", "onSwitchAnimCancel");
            CameraManager.this.m10367j(1);
            CameraManager.this.m10340d(false);
            CameraManager.this.f10926dz = false;
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$IntrinsicsJvm.kt_3 */
    public class C2575c implements CameraPreviewUI.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Size f11153b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Size f11154c = null;

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo10945b() {
            return 2;
        }

        public C2575c() {
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10943a(Size size) {
            CameraLog.m12954a("CameraManager", "onSwitchAnimStart, Beauty3DState: " + CameraManager.this.mModeManager.m11952bw());
            this.f11153b = size;
            CameraManager.this.mCameraUIManager.mo18200d(false, false);
            CameraManager.this.mCameraUIManager.mo18227i(false);
            if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) || CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_EXPAND_POPBAR)) {
                CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, false);
            }
            int iM11952bw = CameraManager.this.mModeManager.m11952bw();
            if (iM11952bw != 0) {
                if (iM11952bw == 1) {
                    CameraManager.this.mCameraUIManager.m19883da();
                    CameraManager.this.mModeManager.m11895b(10, false);
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.switchCamera(cameraManager.m10220R());
                    return;
                }
                if (iM11952bw == 4) {
                    CameraManager.this.mCameraUIManager.mo18036H();
                    CameraManager.this.mCameraUIManager.mo18200d(false, true);
                    CameraManager cameraManager2 = CameraManager.this;
                    cameraManager2.switchCamera(cameraManager2.m10220R());
                    return;
                }
                if (iM11952bw == 6) {
                    CameraManager.this.mModeManager.m11895b(14, true);
                    CameraManager cameraManager3 = CameraManager.this;
                    cameraManager3.switchCamera(cameraManager3.m10220R());
                    return;
                } else {
                    if (iM11952bw != 8) {
                        return;
                    }
                    CameraManager.this.mModeManager.m11895b(10, false);
                    CameraManager.this.mModeManager.m11895b(14, true);
                }
            }
            CameraManager.this.m10308ar();
            CameraManager.this.m10378n(1);
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10944a(Size size, Size size2) {
            CameraLog.m12954a("CameraManager", "onSwitchAnimMiddle, mAfterSwitchPrvSize: " + CameraManager.this.f10909di);
            this.f11154c = size;
            this.f11153b = size2;
            if (this.f11153b != null) {
                CameraUIManager c3208d = CameraManager.this.mCameraUIManager;
                Size size3 = this.f11153b;
                c3208d.m19670a(size3, size3, false);
                if (CameraManager.this.mModeManager.m11952bw() == 0 || CameraManager.this.mModeManager.m11952bw() == 4) {
                    CameraManager.this.m10244a(this.f11153b, false);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10942a() throws Resources.NotFoundException {
            CameraManager.this.mCameraUIManager.m19641W(true);
            CameraLog.m12967f("CameraManager", "onSwitchAnimEnd, Beauty3DState: " + CameraManager.this.mModeManager.m11952bw());
            if (CameraManager.this.f10931eE != null) {
                CameraManager.this.f10931eE.m24840b(true);
            }
            int iM11952bw = CameraManager.this.mModeManager.m11952bw();
            if (CameraManager.this.mModeManager.m11952bw() == 0 || CameraManager.this.mModeManager.m11952bw() == 4) {
                CameraManager.this.m10211I();
                CameraManager.this.m10302al();
                if (CameraManager.this.f10849ca != null) {
                    CameraManager.this.f10849ca.onUserInteraction();
                }
                CameraManager.this.m10244a(this.f11153b, true);
                CameraManager.this.mCameraUIManager.mo18036H();
                CameraManager.this.mModeManager.m11895b(10, true);
                CameraManager.this.m9926cH();
                if (CameraManager.this.f10850cb.getBoolean(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D, true) && CameraManager.this.f10912dl && !CameraManager.this.mCameraUIManager.mo18023A() && ImageBeautyTools.m22674a(CameraManager.this.f10849ca) == 1) {
                    CameraManager.this.mCameraUIManager.mo18086a((View) null, 5, CameraManager.this.f10849ca.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_custom_offset_x), CameraManager.this.f10849ca.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_custom_offset_y));
                }
                CameraManager.this.f10912dl = false;
                if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.mo18023A() && CameraManager.this.mModeManager != null) {
                    CameraManager.this.mModeManager.m11821a(CameraManager.this.mCameraUIManager.mo18038I());
                }
                if (CameraManager.this.mModeManager.m11952bw() == 4) {
                    CameraLog.m12967f("CameraManager", "onSwitchAnimEnd, retsetBeauty3DState");
                    CameraManager.this.mModeManager.m12101m(0);
                }
            } else if (iM11952bw == 1 || iM11952bw == 6 || iM11952bw == 7 || iM11952bw == 8 || iM11952bw == 10) {
                CameraManager.this.mModeManager.m11895b(15, true);
            }
            CameraManager.this.m10368j(false);
            CameraManager.this.m10339d(-1);
            CameraManager.this.m10353f(false);
            CameraManager.this.m10340d(false);
            CameraManager.this.mCameraUIManager.mo18227i(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cH */
    public void m9926cH() {
        if (m9930cJ()) {
            m10348e(true, false);
            m10398w(true);
        } else {
            m10236a((AnimatorListenerAdapter) null, true, this.mCameraUIManager != null && this.mCameraUIManager.mo18051O());
            m10398w(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cI */
    public boolean m9928cI() {
        if (!Util.m24498u() || !this.f10762ar || this.mModeManager == null) {
            return this.mModeManager != null && this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM);
        }
        BaseMode baseModeM11800a = this.mModeManager.m11800a(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, ""));
        if (baseModeM11800a != null) {
            return baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_ZOOM);
        }
        return this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM);
    }

    /* renamed from: cJ */
    private boolean m9930cJ() {
        ScreenModeManager c2953g = this.f10890dP;
        return (c2953g == null || !c2953g.mo16411a().mo16631r()) ? (this.mModeManager == null || !m9928cI() || this.mModeManager.m12091j(CameraUIInterface.KEY_EXPAND_POPBAR) || this.mModeManager.m11937bh() || this.mModeManager.m11994cc() || this.mCameraUIManager == null || this.mCameraUIManager.m19786by() || this.mCameraUIManager.mo18043K() || this.mCameraUIManager.mo18051O() || this.mCameraUIManager.m19948ev() || this.mCameraUIManager.m19821cX() || m10312av() || (m10269aE() && (!m10269aE() || m10327b(CameraUIInterface.KEY_INERTIAL_ZOOM))) || (m10269aE() && this.mModeManager.m12091j(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && m9944cQ())) ? false : true : (this.mModeManager == null || !m9928cI() || this.mModeManager.m11937bh() || this.mModeManager.m11994cc() || this.mCameraUIManager == null || this.mCameraUIManager.m19786by() || this.mCameraUIManager.m19948ev() || this.mCameraUIManager.m19821cX() || m10312av() || (m10269aE() && (!m10269aE() || m10327b(CameraUIInterface.KEY_INERTIAL_ZOOM))) || (m10269aE() && this.mModeManager.m12091j(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && m9944cQ())) ? false : true;
    }

    /* renamed from: u */
    public void m10394u(boolean z) {
        if (this.f10866cr != null) {
            this.f10866cr.m11529k(z);
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$OplusGLSurfaceView_13 */
    private class C2581i implements ZoomManager.PlatformImplementations.kt_3 {
        private C2581i() {
        }

        /* synthetic */ C2581i(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10964a() {
            return (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) || CameraManager.this.mCameraUIManager.m19811cN() || CameraManager.this.m10312av() || CameraManager.this.mCameraUIManager.mo18057R()) ? false : true;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo10970b() {
            return (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) || CameraManager.this.mCameraUIManager.m19811cN()) ? false : true;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10966a(String str) {
            return CameraManager.this.m10327b(str);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10961a(float COUIBaseListPopupWindow_12, boolean z, float f2) {
            CameraLog.m12954a("CameraManager", "onZoomChange, zoomValue: " + COUIBaseListPopupWindow_12);
            if (CameraManager.this.f10866cr != null) {
                boolean zM10115h = CameraManager.this.m10115h(COUIBaseListPopupWindow_12);
                CameraManager cameraManager = CameraManager.this;
                if (Boolean.compare(zM10115h, cameraManager.m10115h(cameraManager.f10866cr.m11501b())) != 0) {
                    CameraManager.this.f10932eF.removeMessages(21);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 21;
                    messageObtain.obj = Float.valueOf(COUIBaseListPopupWindow_12);
                    float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE);
                    CameraManager.this.f10932eF.sendMessageDelayed(messageObtain, (configFloatArrayValue == null || 2 != configFloatArrayValue.length || Float.compare(CameraManager.this.f10866cr.m11501b(), configFloatArrayValue[0]) >= 0 || !CameraManager.this.m10115h(COUIBaseListPopupWindow_12)) ? 0L : 480L);
                }
            }
            if (CameraManager.this.mModeManager != null && !CameraManager.this.mModeManager.m11917bN() && !CameraManager.this.mModeManager.m11977cL()) {
                m10955d(f2);
            }
            if ("on".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_SUB_SETTING, "off"))) {
                CameraManager.this.f10850cb.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
            }
            if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19751bK()) {
                CameraManager.this.mCameraUIManager.m19846cw();
            }
            if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.mo18043K()) {
                CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
            }
            mo10960a(COUIBaseListPopupWindow_12, true);
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11951bv();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m10955d(float COUIBaseListPopupWindow_12) {
            int iM10310at = CameraManager.this.m10310at();
            if (m10965a(COUIBaseListPopupWindow_12)) {
                if (!CameraManager.this.f10774bD) {
                    CameraManager.this.f10774bD = true;
                    CameraManager.this.mCameraUIManager.mo18108a(true, false, false);
                    CameraManager.this.m9580A(iM10310at);
                }
            } else {
                CameraManager.this.f10774bD = false;
                CameraManager.this.mCameraUIManager.mo18067a(iM10310at);
            }
            if (CameraManager.this.mModeManager.m12033dJ() && CameraManager.this.mModeManager.m12031dH() && CameraManager.this.m10271aG()) {
                CameraManager.this.mCameraUIManager.mo18166b(R.string.camera_video_hdr, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10971c() {
            CameraManager.this.f10856ch.mo9571q();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10974d() {
            CameraManager.this.f10856ch.mo9570p();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m10965a(float COUIBaseListPopupWindow_12) {
            return CameraManager.this.m10343d(COUIBaseListPopupWindow_12);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean mo10976e() {
            if (CameraManager.this.f10852cd != null && CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) && !CameraManager.this.mModeManager.m11859aT() && !CameraManager.this.mModeManager.m11930ba() && !CameraManager.this.mModeManager.m11791W() && ((CameraManager.this.m10222T() || (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.mo18183c() != null && CameraManager.this.mCameraUIManager.mo18183c().m23490u() && CameraManager.this.m10278aN())) && !CameraManager.this.f10763as && !CameraManager.this.f10760ap && !CameraManager.this.f10762ar && !CameraManager.this.f10922dv)) {
                if (CameraManager.this.mCameraUIManager != null && !CameraManager.this.mCameraUIManager.m19862dF() && (!CameraManager.this.mCameraUIManager.m19944er() || CameraManager.this.mCameraUIManager.m19939em())) {
                    return true;
                }
                CameraLog.m12954a("CameraManager", "getZoomMenuEnabled, headline is scrolling, disable ZoomMenu: " + CameraManager.this.mCameraUIManager.m19862dF() + ", isDrawerDrag: " + CameraManager.this.mCameraUIManager.m19944er() + ", isDrawerLayoutHeightNone: " + CameraManager.this.mCameraUIManager.m19939em());
                return false;
            }
            CameraLog.m12967f("CameraManager", "getZoomMenuEnabled, isPreviewStarted: " + CameraManager.this.m10222T() + ", mbSizeChanging: " + CameraManager.this.f10763as + ", mbSwitchingCamera: " + CameraManager.this.f10760ap + ", mbCaptureModeChanging: " + CameraManager.this.f10762ar + ", mbSendCapturePictureRequest: " + CameraManager.this.f10922dv);
            return false;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10977f() {
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10852cd.mo13151y(true);
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11778J();
            }
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19823cZ();
            }
            if (CameraManager.this.f10908dh != null) {
                CameraManager.this.f10908dh.m11216c(false);
            }
            mo10987p();
            Util.m24323aL();
            FluencyPerformance.m15131b();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10963a(boolean z) {
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10852cd.mo13151y(z);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10967b(float COUIBaseListPopupWindow_12) {
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10852cd.mo13063b(COUIBaseListPopupWindow_12);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10969b(boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12130u(z);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10978g() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11776H();
            }
            if (CameraManager.this.mCameraUIManager != null && !CameraManager.this.m10312av()) {
                CameraManager.this.mCameraUIManager.m19712ak((CameraManager.this.mModeManager.m11791W() || !CameraManager.this.mCameraUIListener.mo10795bl() || CameraManager.this.mModeManager.m12035dL()) ? false : true);
            }
            FluencyPerformance.m15135c();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo10979h() {
            if (CameraManager.this.mModeManager == null || CameraManager.this.mCameraUIManager == null) {
                return;
            }
            boolean z = false;
            if (CameraManager.this.f10852cd != null) {
                CameraManager.this.f10852cd.mo13151y(false);
            }
            CameraManager.this.mModeManager.m11777I();
            if (!CameraManager.this.m10312av()) {
                CameraManager.this.mCameraUIManager.m19616B(CameraManager.this.mModeManager.m11936bg(), !(CameraManager.this.mModeManager.m11880ao() && CameraManager.this.mModeManager.m11791W()) && CameraManager.this.mModeManager.m11866aa());
            }
            if (CameraManager.this.m10269aE()) {
                CameraManager.this.mCameraUIManager.m19623G(Color.argb(0, 0, 0, 0));
            }
            if (!CameraManager.this.mModeManager.m11861aV() && (CameraManager.this.mCameraUIManager.mo18023A() || CameraManager.this.mCameraUIManager.mo18043K())) {
                CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, false);
            }
            if (CameraManager.this.f10908dh != null) {
                QrCodeManager viewOnClickListenerC2609aa = CameraManager.this.f10908dh;
                if (CameraManager.this.m10380n() && CameraManager.this.m9891by()) {
                    z = true;
                }
                viewOnClickListenerC2609aa.m11216c(z);
                CameraManager.this.f10908dh.m11228m();
            }
            if (mo10966a(CameraUIInterface.KEY_GRADIENTER) && "on".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_GRADIENTER, "off")) && CameraManager.this.mModeManager.m12105n().equals(ApsConstant.CAPTURE_MODE_PROFESSIONAL)) {
                CameraManager.this.mCameraUIManager.m19692a(CameraManager.this.m10222T(), CameraManager.this.f10987w);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo10980i() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19637T(true);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_15 */
        public void mo10981j() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19637T(false);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_5 */
        public void mo10982k() {
            double dM11919bP = CameraManager.this.mModeManager != null ? CameraManager.this.mModeManager.m11919bP() : 0.0d;
            if (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11917bN() || CameraManager.this.f10747ac || dM11919bP <= 0.0d || CameraManager.this.mCameraUIManager == null) {
                return;
            }
            if (!TextUtils.isEmpty(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                CameraManager.this.mCameraUIManager.m19662a(R.string.camera_zoom_not_support_high_resolution, new Object[0]);
            } else {
                CameraManager.this.mCameraUIManager.m19662a(R.string.camera_zoom_not_support, Double.valueOf(dM11919bP));
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10962a(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12068e(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10972c(float COUIBaseListPopupWindow_12) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11804a(COUIBaseListPopupWindow_12);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_14 */
        public boolean mo10983l() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12082h();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_6 */
        public boolean mo10984m() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11832a();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_11 */
        public String mo10985n() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12105n();
            }
            return null;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: o */
        public boolean mo10986o() {
            return (CameraManager.this.mModeManager == null || CameraManager.this.mModeManager.m11861aV() || (CameraManager.this.f10839cQ != null && !CameraManager.this.f10839cQ.m11291c())) ? false : true;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: p */
        public void mo10987p() {
            CameraManager.this.m9588C(68);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: q */
        public void mo10988q() {
            CameraManager.this.m9588C(0);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: r */
        public void mo10989r() {
            CameraManager.this.m9588C(1);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: s */
        public boolean mo10990s() {
            return CameraManager.this.m9931cK();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: t */
        public boolean mo10991t() {
            return CameraManager.this.m9934cL();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: u */
        public boolean mo10992u() {
            return CameraManager.this.f10758an;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: v */
        public boolean mo10993v() {
            return CameraManager.this.f10759ao;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: w */
        public boolean mo10994w() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12013cv();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10968b(int OplusGLSurfaceView_13) {
            if (!Util.m24352ao()) {
                CameraManager.this.mCameraUIManager.m19623G(OplusGLSurfaceView_13);
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12073f(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: x */
        public boolean mo10995x() {
            return CameraManager.this.m10207E();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: y */
        public boolean mo10996y() {
            return CameraManager.this.mCameraUIManager.mo18043K();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: z */
        public boolean mo10997z() {
            return CameraManager.this.mCameraUIManager.mo18051O();
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: A */
        public boolean mo10956A() {
            return CameraManager.this.f10752ah;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10973c(boolean z) {
            if (!mo10966a(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH) || CameraManager.this.f10863co == null) {
                return;
            }
            CameraManager.this.f10863co.m14683a(z);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10960a(float COUIBaseListPopupWindow_12, boolean z) {
            CameraManager.this.m10232a(COUIBaseListPopupWindow_12, z);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10975d(boolean z) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11526i(z);
            }
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: B */
        public boolean mo10957B() {
            return !CameraManager.this.f10747ac && mo10966a(CameraFunction.BOKEH);
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: C */
        public boolean mo10958C() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12035dL();
            }
            return false;
        }

        @Override // com.oplus.camera.ZoomManager.PlatformImplementations.kt_3
        /* renamed from: D */
        public int mo10959D() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.mo18265s();
            }
            return 1;
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$COUIBaseListPopupWindow_10 */
    private class C2580h implements TiltShiftManager.CameraTiltShiftListener {
        private C2580h() {
        }

        /* synthetic */ C2580h(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener
        public boolean getSupportTiltShif() {
            return (!CameraManager.this.mModeManager.m12091j(CameraFunction.TILT_SHIFT) || CameraManager.this.mCameraUIManager.m19811cN() || CameraManager.this.m10312av()) ? false : true;
        }

        @Override // com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener
        public boolean getTiltShifGestureEnabled() {
            if (CameraManager.this.f10852cd != null && CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12091j(CameraFunction.TILT_SHIFT) && !CameraManager.this.mModeManager.m11859aT() && !CameraManager.this.mModeManager.m11930ba() && !CameraManager.this.mModeManager.m11791W() && CameraManager.this.m10222T() && !CameraManager.this.f10763as && !CameraManager.this.f10760ap && !CameraManager.this.f10762ar && !CameraManager.this.f10922dv) {
                if (CameraManager.this.mCameraUIManager == null || !CameraManager.this.mCameraUIManager.m19862dF()) {
                    return true;
                }
                CameraLog.m12954a("CameraManager", "getTiltShifGestureEnabled, headline is scrolling, disable ZoomMenu");
                return false;
            }
            CameraLog.m12967f("CameraManager", "getTiltShifGestureEnabled, isPreviewStarted: " + CameraManager.this.m10222T() + ", mbSizeChanging: " + CameraManager.this.f10763as + ", mbSwitchingCamera: " + CameraManager.this.f10760ap + ", mbCaptureModeChanging: " + CameraManager.this.f10762ar + ", mbSendCapturePictureRequest: " + CameraManager.this.f10922dv);
            return false;
        }

        @Override // com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener
        public boolean isEffectMenuAnimRunning() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.m19872dP();
            }
            return false;
        }

        @Override // com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener
        public void setTiltShiftParams(TiltShiftParam tiltShiftParam) {
            CameraLog.m12954a("CameraManager", "setTiltShiftParams, params: " + tiltShiftParam);
            CameraManager.this.mModeManager.m11819a(tiltShiftParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cK */
    public boolean m9931cK() {
        return this.mModeManager != null && this.mModeManager.isNoneSatUltraWideAngleOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cL */
    public boolean m9934cL() {
        return this.mModeManager != null && this.mModeManager.m12006co();
    }

    /* renamed from: v */
    public void m10395v(boolean z) {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19702aa(z);
        }
    }

    /* renamed from: av */
    public boolean m10312av() {
        if (this.f10826cD != null) {
            return this.f10826cD.m19331d();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cM */
    public boolean m9936cM() {
        RecordingStopCountDownTimer c3202d = this.f10827cE;
        if (c3202d != null) {
            return c3202d.m19257b();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m10022d(String str, boolean z) {
        if (m10327b(CameraUIInterface.KEY_QUICK_VIDEO) && this.mCameraUIManager != null) {
            if (this.mCameraUIManager.m19755bO() && this.mCameraUIManager.m19756bP()) {
                this.mCameraUIManager.m19757bQ();
            } else {
                CameraLog.m12966e("CameraManager", "startTimerSnapshot, camera setting ui or thumb image view not visible");
                return;
            }
        }
        if (this.f10826cD == null) {
            this.f10826cD = new TimerSnapShotManager();
            this.f10826cD.m19328a(new C2596x(this, null));
        }
        String strM11904bA = this.mModeManager.m11904bA();
        if (strM11904bA == null) {
            strM11904bA = this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard");
        }
        boolean zEquals = DcsMsgData.FULL.equals(strM11904bA);
        m9583B(Integer.valueOf(str).intValue());
        this.f10826cD.m19326a(Integer.valueOf(str).intValue(), this.f10849ca, this.f10984t, zEquals, z);
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.mo18060U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cN */
    public String m9937cN() {
        if (!m10222T() || this.mModeManager == null || !this.mModeManager.m12091j(CameraUIInterface.KEY_TIME_LAPSE) || this.f10846cX.m13317J() == 3) {
            return "off";
        }
        String strM11876ak = this.mModeManager != null ? this.mModeManager.m11876ak() : "off";
        if (m10386q() && "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.f10849ca.getString(R.string.camera_gesture_shutter_default_value))) && "off".equals(strM11876ak)) {
            strM11876ak = "3";
        }
        if (!this.f10846cX.m13360x()) {
            return strM11876ak;
        }
        String strValueOf = String.valueOf(this.f10846cX.m13308A());
        this.f10846cX.m13362z();
        return strValueOf;
    }

    /* renamed from: B */
    private void m9583B(int OplusGLSurfaceView_13) {
        String string = this.f10850cb.getString(CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER, "on");
        if (Util.m24459h("oplus.software.motor.breathled") && "on".equals(string) && this.f10747ac) {
            CameraMotorManager.m13703a((Context) this.f10849ca).m13706a(OplusGLSurfaceView_13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cO */
    public boolean m9940cO() {
        return (Util.m24320aI() && this.f10747ac) ? false : true;
    }

    /* renamed from: com.oplus.camera.CameraManager$u */
    private class C2593u implements RecordingStopCountDownTimer.IntrinsicsJvm.kt_4 {
        private C2593u() {
        }

        /* synthetic */ C2593u(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.control.RecordingStopCountDownTimer.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11042a() {
            CameraLog.m12954a("CameraManager", "onTimeOut, stop video recording because of the high temperature");
            if (CameraManager.this.m10269aE()) {
                CameraManager.this.mModeManager.m12103m(false);
                if (CameraManager.this.f10827cE != null) {
                    CameraManager.this.f10827cE.m19258c();
                }
            }
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$x */
    private class C2596x implements TimerSnapShotManager.IntrinsicsJvm.kt_4 {
        private C2596x() {
        }

        /* synthetic */ C2596x(CameraManager cameraManager, C24971 c24971) {
            this();
        }

        @Override // com.oplus.camera.p172ui.control.TimerSnapShotManager.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11055a(boolean z) {
            CameraLog.m12954a("CameraManager", "onTimeOut, getCurrentModeName: " + CameraManager.this.mModeManager.m12105n());
            CameraManager.this.m9905c(false, false, z);
        }

        @Override // com.oplus.camera.p172ui.control.TimerSnapShotManager.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo11056b(boolean z) {
            CameraManager cameraManager = CameraManager.this;
            cameraManager.f10729aK = cameraManager.mModeManager.m11832a() && !CameraManager.this.mCameraUIManager.m19898dp();
            CameraManager.this.mCameraUIManager.m19713al(Util.m24420c(CameraManager.this.mModeManager.m11796a(CameraManager.this.f10853ce)));
            CameraManager.this.mModeManager.m11794Z();
            CameraManager.this.mModeManager.m11895b(3, false);
            CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, false);
            CameraManager.this.m10398w(false);
            if (CameraManager.this.f10892dR == null || !z) {
                return;
            }
            CameraManager.this.f10892dR.mo24731a(0, (Bitmap) null);
        }

        @Override // com.oplus.camera.p172ui.control.TimerSnapShotManager.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11054a() {
            CameraLog.m12954a("CameraManager", "onTimeUpdated, mbPaused: " + CameraManager.this.f10752ah + ", mPhoneState: " + CameraManager.this.f10705M);
            if (CameraManager.this.f10752ah || CameraManager.this.f10705M != 0) {
                return;
            }
            CameraManager.this.m10319b(3);
        }

        @Override // com.oplus.camera.p172ui.control.TimerSnapShotManager.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo11057c(boolean z) {
            if (CameraManager.this.f10892dR != null && !z) {
                CameraManager.this.f10892dR.mo24731a(1, (Bitmap) null);
            }
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.mo18200d(true, false);
                if (!z || (CameraManager.this.mModeManager != null && !CameraManager.this.mModeManager.m11880ao() && CameraManager.this.mModeManager.m11881ap())) {
                    CameraManager.this.mCameraUIManager.mo18209f(0);
                    CameraManager.this.mCameraUIManager.mo18215g(0);
                    CameraManager.this.mCameraUIManager.m19910e(1.0f);
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.m10244a(cameraManager.mModeManager.m11796a(CameraManager.this.f10853ce), true);
                    CameraManager.this.mModeManager.m12085i(z);
                    CameraManager.this.mCameraUIManager.mo18258q();
                    CameraManager.this.mCameraUIManager.mo18190c(true);
                    CameraManager.this.mCameraUIManager.mo18279v(true);
                    CameraManager.this.mCameraUIManager.mo18263r(true);
                    CameraManager.this.mCameraUIManager.mo18240l(true, false);
                    CameraManager.this.mCameraUIManager.m19761bU();
                    if (CameraManager.this.mModeManager.m11949bt()) {
                        CameraManager.this.mCameraUIManager.mo18228i(true, false);
                    }
                    CameraManager.this.mModeManager.m11895b(3, true);
                    if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_EXPAND_POPBAR)) {
                        CameraManager.this.m10348e(true, false);
                        CameraManager.this.m10398w(true);
                    }
                }
                if (CameraManager.this.f10846cX.m13317J() != 3 && (!z || (CameraManager.this.mModeManager != null && !CameraManager.this.mModeManager.m11880ao() && CameraManager.this.mModeManager.m11881ap()))) {
                    if (CameraManager.this.mModeManager.m11832a()) {
                        if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) {
                            CameraManager.this.mCameraUIManager.m19736b(false, CameraManager.this.f10729aK ? 1 : 0);
                        }
                    } else if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) {
                        CameraManager.this.mCameraUIManager.mo18068a(0, 1);
                    }
                    if (CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
                        CameraManager.this.mCameraUIManager.mo18193d(0);
                    } else {
                        CameraManager.this.mCameraUIManager.mo18193d(4);
                    }
                }
            }
            if (CameraManager.this.f10869cu != null) {
                CameraManager.this.f10869cu.m23005c(false);
            }
            if (CameraManager.this.f10729aK) {
                CameraManager.this.f10729aK = false;
            }
        }

        @Override // com.oplus.camera.p172ui.control.TimerSnapShotManager.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo11058d(boolean z) {
            if (z || CameraManager.this.f10869cu == null) {
                return;
            }
            CameraManager.this.f10869cu.m23005c(true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10236a(AnimatorListenerAdapter animatorListenerAdapter, boolean z, boolean z2) {
        CameraLog.m12954a("CameraManager", "hideZoomMenu, listener: " + animatorListenerAdapter);
        if (this.f10866cr != null) {
            this.f10866cr.m11494a(animatorListenerAdapter, z, z2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m10348e(boolean z, boolean z2) {
        CameraLog.m12954a("CameraManager", "showOpticalZoomMenu");
        if (this.mCameraUIManager != null && this.mCameraUIManager.m19875dS() && this.mCameraUIManager.m19864dH()) {
            return;
        }
        if ((this.mModeManager == null || this.mModeManager.m12065dy()) && !LockViewDragLayout.getLongPressState()) {
            if ((m10327b(CameraUIInterface.KEY_TIME_LAPSE_PRO) && m10269aE()) || this.f10866cr == null) {
                return;
            }
            if (m10327b(CameraUIInterface.KEY_SUPPORT_ZOOM_REINIT)) {
                m10318b(this.f10870cv);
            }
            this.f10866cr.m11498a(z, z2);
        }
    }

    /* renamed from: aw */
    public boolean m10313aw() {
        CameraLog.m12954a("CameraManager", "collapseOpticalZoomMenu");
        if (this.f10866cr != null) {
            return this.f10866cr.m11507b(false);
        }
        return false;
    }

    /* renamed from: w */
    public void m10398w(boolean z) {
        CameraLog.m12954a("CameraManager", "enableOpticalZoomMenu, enable: " + z);
        if (this.f10866cr != null) {
            this.f10866cr.m11497a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cP */
    public boolean m9942cP() {
        if (this.mModeManager != null && this.mModeManager.m12091j(CameraFunction.TORCH_SOFT_LIGHT)) {
            return false;
        }
        String string = this.f10850cb.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.f10849ca));
        String string2 = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.f10989y));
        if ("off".equals(string) || !"on".equals(string2)) {
            return "on".equals(string) && "auto".equals(string2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cQ */
    public boolean m9944cQ() {
        if (this.mModeManager != null) {
            return m9931cK() || this.f10747ac || this.mModeManager.m11976cK() || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE) && this.mModeManager.m11975cJ());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m10150n(String str) {
        if (this.f10760ap || this.f10762ar) {
            return false;
        }
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_VIDEO_SIZE.equals(strM13305d) || CameraUIInterface.KEY_PHOTO_RATIO.equals(strM13305d) || CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(strM13305d)) {
            return true;
        }
        if (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_HDR.equals(strM13305d)) {
            return m10327b(CameraFunction.VIDEO_HDR);
        }
        if (CameraUIInterface.KEY_TORCH_MODE.equals(strM13305d)) {
            return m10327b(CameraUIInterface.KEY_CAMERA_HDR_MODE) && m9942cP();
        }
        if (CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(strM13305d)) {
            return m10327b(CameraFunction.ULTRA_NIGHT_VIDEO);
        }
        if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(strM13305d)) {
            return m10327b(CameraFunction.AI_ENHANCEMENT_VIDEO);
        }
        if (CameraUIInterface.KEY_FILM_VIDEO_LOG.equals(strM13305d)) {
            return m10327b(CameraUIInterface.KEY_FILM_VIDEO_LOG);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cR */
    public boolean m9946cR() {
        if (this.mModeManager.m12091j(CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
            return this.mCameraUIManager.m19968k(CameraUIInterface.KEY_VIDEO_FLASH_MODE);
        }
        if (this.mModeManager.m12091j(CameraUIInterface.KEY_FLASH_MODE)) {
            return this.mCameraUIManager.m19968k(CameraUIInterface.KEY_FLASH_MODE);
        }
        return m9950cT();
    }

    /* renamed from: com.oplus.camera.CameraManager$52 */
    class C254452 implements CameraUIListener {
        C254452() {
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10676a() {
            CameraManager.this.m10398w(false);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo10754b() {
            return CameraManager.this.mModeManager.m11882aq();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo10814c() {
            return CameraManager.this.mModeManager.m11861aV();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean mo10829d() {
            return CameraManager.this.mModeManager.m11791W();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo10831e() {
            CameraManager.this.mModeManager.m12103m(false);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public boolean mo10838f() {
            return CameraManager.this.mModeManager.m11864aY();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean mo10843g() {
            return CameraManager.this.mModeManager.m11863aX();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean mo10847h() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11983cR();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_13 */
        public boolean mo10852i() {
            return CameraManager.this.f10865cq != null && 1 == CameraManager.this.f10865cq.m23654N();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_15 */
        public boolean mo10856j() {
            return CameraManager.this.mModeManager.m11930ba();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_5 */
        public boolean mo10859k() {
            return CameraManager.this.mModeManager.m11860aU();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_14 */
        public boolean mo10864l() {
            return CameraManager.this.mModeManager.m11767A();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_6 */
        public void mo10865m() {
            CameraManager.this.f10856ch.mo9567m();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_11 */
        public int mo10868n() {
            return CameraManager.this.f10982r;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: o */
        public void mo10870o() {
            CameraManager.this.mModeManager.m11781M();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10693a(String str) {
            if (CameraUIInterface.KEY_FLASH_MODE.equals(str) && CameraManager.this.f10747ac) {
                return false;
            }
            if ((CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) && CameraManager.this.f10747ac && !mo10764bG()) || CameraManager.this.mCameraUIManager.m19976q(CameraManager.this.mCameraUIManager.m19975p(str))) {
                return false;
            }
            return !CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED.equals(str) || CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo10757b(String str) {
            return CameraManager.this.mModeManager.m12079g(str);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: p */
        public boolean mo10873p() {
            return CameraManager.this.f10798bb;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: q */
        public void mo10874q() {
            if (CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) && CameraManager.this.f10890dP != null && 4 != mo10816ca()) {
                CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, true);
                CameraManager.this.m10398w(false);
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11935bf();
            }
            if (CameraManager.this.f10908dh != null) {
                CameraManager.this.f10908dh.m11216c(false);
            }
            if (CameraManager.this.mCameraUIManager.mo18111aA()) {
                CameraManager.this.mCameraUIManager.mo18041J(false);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10689a(boolean z) {
            if (CameraManager.this.mModeManager != null && CameraManager.this.m9928cI() && CameraManager.this.mCameraUIManager != null && !CameraManager.this.mCameraUIManager.m19786by() && !CameraManager.this.f10766av && !z && !CameraManager.this.mModeManager.m11767A() && (!mo10814c() || !CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) || !CameraManager.this.m9944cQ())) {
                CameraManager.this.m10348e(true, true);
                CameraManager.this.m10398w(true);
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12119q(z);
            }
            if (CameraManager.this.f10908dh != null) {
                CameraManager.this.f10908dh.m11216c(CameraManager.this.m10380n() && CameraManager.this.m9891by());
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void onEffectItemChange(int OplusGLSurfaceView_13, boolean z, boolean z2) {
            CameraManager.this.m9772b(OplusGLSurfaceView_13, z, z2);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: r */
        public void mo10876r() {
            CameraManager.this.m10296af();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: s */
        public float mo10877s() {
            return CameraManager.this.m10279aO();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10677a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                CameraManager.this.mCameraUIManager.mo18278v(8);
            } else if (OplusGLSurfaceView_13 == 1) {
                CameraManager.this.f10866cr.m11535o();
            } else if (OplusGLSurfaceView_13 == 2) {
                CameraManager.this.mCameraUIManager.mo18278v(22);
            }
            mo10681a(OplusGLSurfaceView_13, true);
            CameraManager.this.mCameraUIManager.m19891di();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        
            if (r3 != 2) goto L33;
         */
        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean mo10691a(int r3, int r4) {
            /*
                r2 = this;
                com.oplus.camera.CameraManager r0 = com.oplus.camera.CameraManager.this
                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.CameraManager.m10103g(r0)
                r1 = 0
                if (r0 == 0) goto L88
                com.oplus.camera.CameraManager r0 = com.oplus.camera.CameraManager.this
                com.oplus.camera.capmode.ModeManager r0 = com.oplus.camera.CameraManager.m10119i(r0)
                if (r0 == 0) goto L88
                com.oplus.camera.CameraManager r0 = com.oplus.camera.CameraManager.this
                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.CameraManager.m10103g(r0)
                boolean r0 = r0.mo18159aw()
                if (r0 != 0) goto L88
                com.oplus.camera.CameraManager r0 = com.oplus.camera.CameraManager.this
                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.CameraManager.m10103g(r0)
                boolean r0 = r0.m19864dH()
                if (r0 != 0) goto L88
                if (r3 == 0) goto L7d
                r0 = 1
                if (r3 == r0) goto L32
                r0 = 2
                if (r3 == r0) goto L7d
                goto L88
            L32:
                com.oplus.camera.CameraManager r3 = com.oplus.camera.CameraManager.this
                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.CameraManager.m10103g(r3)
                boolean r3 = r3.m19633Q(r4)
                if (r3 == 0) goto L7b
                com.oplus.camera.CameraManager r3 = com.oplus.camera.CameraManager.this
                float r4 = r2.mo10877s()
                boolean r3 = com.oplus.camera.CameraManager.m9788b(r3, r4)
                if (r3 != 0) goto L7b
                com.oplus.camera.CameraManager r3 = com.oplus.camera.CameraManager.this
                com.oplus.camera.capmode.ModeManager r3 = com.oplus.camera.CameraManager.m10119i(r3)
                float r4 = r2.mo10877s()
                boolean r3 = r3.m11900b(r4)
                if (r3 == 0) goto L7b
                com.oplus.camera.CameraManager r3 = com.oplus.camera.CameraManager.this
                com.oplus.camera.capmode.ModeManager r3 = com.oplus.camera.CameraManager.m10119i(r3)
                boolean r3 = r3.isNoneSatUltraWideAngleOpen()
                if (r3 != 0) goto L7b
                com.oplus.camera.CameraManager r3 = com.oplus.camera.CameraManager.this
                com.oplus.camera.capmode.ModeManager r3 = com.oplus.camera.CameraManager.m10119i(r3)
                boolean r3 = r3.m11918bO()
                if (r3 != 0) goto L7b
                java.lang.String r3 = "pref_zoom_key"
                boolean r2 = r2.mo10848h(r3)
                if (r2 == 0) goto L7b
                goto L7c
            L7b:
                r0 = r1
            L7c:
                return r0
            L7d:
                com.oplus.camera.CameraManager r2 = com.oplus.camera.CameraManager.this
                com.oplus.camera.ui.IntrinsicsJvm.kt_5 r2 = com.oplus.camera.CameraManager.m10103g(r2)
                boolean r2 = r2.m19633Q(r4)
                return r2
            L88:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.CameraManager.C254452.mo10691a(int, int):boolean");
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: t */
        public boolean mo10878t() {
            return CameraManager.this.m10214L();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo10755b(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12083h(OplusGLSurfaceView_13);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: u */
        public boolean mo10879u() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11779K();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: v */
        public int mo10880v() {
            return (CameraManager.this.mModeManager == null || 1 != CameraManager.this.mModeManager.m12104n(0)) ? 0 : 1;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: w */
        public boolean mo10881w() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUB_SETTING);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10812c(String str) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mModeManager.m11821a(CameraManager.this.mCameraUIManager.mo18038I());
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10827d(String str) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12074f(str);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: x */
        public boolean mo10882x() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11782N();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10695a(String str, boolean z, boolean z2) {
            String strM13305d = CameraEntry.m13305d(str);
            if ((!CameraUIInterface.KEY_VIDEO_SIZE.equals(strM13305d) && !CameraUIInterface.KEY_VIDEO_FPS.equals(strM13305d)) || (!z2 && !z)) {
                CameraManager.this.m9698a(strM13305d, z, PopUpWindowManager.m20706a(), CameraManager.this.mCameraUIManager.mo18023A() || CameraManager.this.mCameraUIManager.mo18051O(), z2);
            }
            if (CameraManager.this.f10752ah || CameraManager.this.f10798bb || !CameraManager.this.f10807bk || !CameraManager.this.f10801be || !mo10800bq() || CameraManager.this.f10763as || CameraManager.this.f10762ar || CameraManager.this.m10349e() || CameraManager.this.f10760ap || CameraManager.this.mCameraUIManager.m19818cU() || !CameraManager.this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.MENU) || ((CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_BURST_SHOT) && CameraManager.this.f10766av) || mo10658L() || CameraManager.this.mModeManager.m11859aT() || CameraManager.this.mCameraUIManager.mo18025B() || (CameraManager.this.mModeManager.m11930ba() && !CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)))) {
                StringBuilder sb = new StringBuilder();
                sb.append("onMenuButtonClick, key: ");
                sb.append(strM13305d);
                sb.append(", mbPaused: ");
                sb.append(CameraManager.this.f10752ah);
                sb.append(", mbDoubleFinger: ");
                sb.append(CameraManager.this.f10798bb);
                sb.append(", !mbInitialized: ");
                sb.append(!CameraManager.this.f10807bk);
                sb.append(", !mbFrameAvailable: ");
                sb.append(!CameraManager.this.f10801be);
                sb.append(", !isPreviewStarted: ");
                sb.append(!mo10800bq());
                sb.append(", mbSizeChanging: ");
                sb.append(CameraManager.this.f10763as);
                sb.append(", CaptureModeChangeState: ");
                sb.append(CameraManager.this.f10762ar);
                sb.append(", isAnimationRunning: ");
                sb.append(CameraManager.this.m10349e());
                sb.append(", mbSwitchingCamera: ");
                sb.append(CameraManager.this.f10760ap);
                sb.append(", isEffectMenuScrolling: ");
                sb.append(CameraManager.this.mCameraUIManager.m19818cU());
                sb.append(", !mModeManager.isAllowSwitch: ");
                sb.append(!CameraManager.this.mModeManager.m11837a(CameraConstant.PlatformImplementations.kt_3.MENU));
                sb.append(", mbBurstShot: ");
                sb.append(CameraManager.this.f10766av);
                sb.append(", isTimerSnapShotRunning: ");
                sb.append(mo10658L());
                sb.append(", mModeManager.isVideoRecordStarting: ");
                sb.append(CameraManager.this.mModeManager.m11859aT());
                sb.append(", mCameraUIManager.isAnimationRunning: ");
                sb.append(CameraManager.this.mCameraUIManager.mo18025B());
                sb.append(", mModeManager.isVideoRecordStopping: ");
                sb.append(CameraManager.this.mModeManager.m11930ba());
                CameraLog.m12967f("CameraManager", sb.toString());
                return false;
            }
            if (strM13305d.equals(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION)) {
                CameraManager.this.mCameraUIManager.mo18067a(R.string.camera_zoom_not_support);
            }
            if (!CameraManager.this.mCameraUIManager.mo18025B() && CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(strM13305d)) {
                if (CameraManager.this.mCameraUIManager.mo18051O()) {
                    if (mo10707aL() == 0) {
                        CameraManager.this.mCameraUIManager.m19631O(60);
                        return true;
                    }
                    CameraManager.this.m9980ci();
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.m9672a((SharedPreferences) cameraManager.f10850cb, true);
                    setBlurIndex(0, false);
                } else if (mo10709aN()) {
                    CameraManager.this.m9980ci();
                    CameraManager cameraManager2 = CameraManager.this;
                    cameraManager2.m9672a((SharedPreferences) cameraManager2.f10850cb, true);
                    setBlurIndex(0, false);
                    CameraManager.this.mModeManager.m11768B(false);
                    return true;
                }
                CameraManager.this.m9953cV();
            }
            if (CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(strM13305d) || CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU.equals(strM13305d) || CameraUIInterface.KEY_FILTER_MENU.equals(strM13305d) || CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(strM13305d) || CameraUIInterface.KEY_PORTRAIT_BLUR_MENU.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(strM13305d)) {
                CameraManager.this.mCameraUIManager.mo18024B(false);
            }
            CameraManager.this.mCameraUIManager.m19977r(strM13305d);
            if (CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(strM13305d) || CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(strM13305d) || CameraUIInterface.KEY_NIGHT_FILTER_MENU.equals(strM13305d)) {
                mo10718aW();
            }
            if (CameraManager.this.f10866cr == null || !CameraManager.this.f10866cr.m11528j()) {
                CameraManager.this.f10866cr.m11527j(false);
            } else {
                CameraLog.m12959b("CameraManager", "onMenuButtonClick(), consumed by ZoomMenu");
                if (!CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(strM13305d) || !mo10848h(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE)) {
                    CameraManager.this.f10866cr.m11507b(false);
                    CameraManager.this.f10866cr.m11527j(false);
                } else {
                    CameraManager.this.f10866cr.m11507b(true);
                    CameraManager.this.f10866cr.m11527j(true);
                }
            }
            if (CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(strM13305d) && CameraManager.this.mCameraUIManager.mo18142af()) {
                CameraManager.this.mCameraUIManager.mo18102a(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, false, 0, 0);
                PreferenceManager.m3981a(CameraManager.this.f10849ca).edit().putBoolean("multi_video_setting_menu_reddot_show", false).apply();
            }
            if (CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(strM13305d) && CameraManager.this.mCameraUIManager.mo18143ag()) {
                CameraManager.this.mCameraUIManager.mo18102a(CameraUIInterface.KEY_SUPER_RAW_CONTROL, false, 0, 0);
                PreferenceManager.m3981a(CameraManager.this.f10849ca).edit().putBoolean("super_raw_setting_menu_reddot_show", false).apply();
            }
            if (CameraUIInterface.KEY_FOCUS_PEAKING.equals(strM13305d) && !PreferenceManager.m3981a(CameraManager.this.f10849ca).getBoolean("focus_peaking_clicked", false)) {
                PreferenceManager.m3981a(CameraManager.this.f10849ca).edit().putBoolean("focus_peaking_clicked", true).apply();
            }
            if (TextUtils.equals(ApsConstant.CAPTURE_MODE_COMMON, CameraManager.this.mModeManager.m12105n()) && CameraManager.this.mModeManager.m11840aA()) {
                CameraManager.this.mCameraUIManager.mo18239l(false);
            }
            return true;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10694a(String str, boolean z) {
            String strM13305d = CameraEntry.m13305d(str);
            boolean zM10150n = CameraManager.this.m10150n(strM13305d);
            if (CameraUIInterface.KEY_TORCH_MODE.equals(strM13305d) && CameraManager.this.m9942cP()) {
                SharedPreferences.Editor editorEdit = CameraManager.this.f10850cb.edit();
                editorEdit.putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
                editorEdit.apply();
                CameraManager.this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_CAMERA_HDR_MODE);
            }
            return zM10150n;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public String mo10675a(String str, int OplusGLSurfaceView_13, int i2) {
            if (CameraManager.this.mCameraUIManager.mo18043K() && CameraManager.this.m10150n(str) && OplusGLSurfaceView_13 != i2) {
                CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
            }
            if (!CameraManager.this.mCameraUIManager.mo18051O() || !CameraManager.this.m10150n(str) || OplusGLSurfaceView_13 == i2) {
                return null;
            }
            CameraManager.this.mCameraUIManager.mo18176b(true, true, true, false);
            return null;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10688a(String str, String str2) {
            if (CameraManager.this.mCameraUIManager.mo18043K() && CameraManager.this.m10150n(str)) {
                CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo10832e(String str) {
            CameraManager.this.m10169r(str);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: y */
        public void mo10883y() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12126t();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public boolean mo10839f(String str) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12022d(str);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean mo10844g(String str) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12071e(str);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean mo10848h(String str) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12091j(str);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: z */
        public boolean mo10884z() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11867ab();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: A */
        public void mo10647A() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12135w();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: B */
        public boolean mo10648B() {
            return CameraManager.this.mModeManager.m12082h();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: C */
        public boolean mo10649C() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12086i();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: D */
        public void mo10650D() {
            CameraLog.m12954a("CameraManager", "onPreviewTextureCopied");
            CameraManager.this.f10932eF.removeMessages(6);
            CameraManager.this.f10932eF.sendEmptyMessage(6);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: E */
        public void mo10651E() {
            CameraManager.this.m10322b(true, 1);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: F */
        public int mo10652F() {
            String string = CameraManager.this.f10850cb != null ? CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_MIRROR, CameraManager.this.f10849ca.getString(R.string.camera_mirror_default_value)) : "off";
            boolean z = CameraManager.this.f10984t == 0 || CameraManager.this.f10984t == 180;
            if (CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12050dj() && TextUtils.equals(string, "on")) {
                return z ? 1 : 2;
            }
            return 0;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: G */
        public int mo10653G() {
            return CameraManager.this.f10989y;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: H */
        public int mo10654H() {
            return CameraManager.this.m10304an();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: I */
        public int mo10655I() {
            return CameraManager.this.m10285aU();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: J */
        public boolean mo10656J() {
            if (CameraManager.this.f10865cq != null) {
                return CameraManager.this.f10865cq.mo23706s();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: K */
        public boolean mo10657K() {
            if (CameraManager.this.f10865cq != null) {
                return CameraManager.this.f10865cq.m23707t();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: L */
        public boolean mo10658L() {
            return CameraManager.this.m10312av();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: M */
        public void mo10659M() {
            if (CameraManager.this.f10826cD != null) {
                CameraManager.this.f10826cD.m19333f();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: N */
        public boolean mo10660N() {
            return (CameraManager.this.mModeManager != null && (CameraManager.this.mModeManager.m11791W() || CameraManager.this.mModeManager.m11861aV())) || CameraManager.this.f10922dv;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: O */
        public boolean mo10661O() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11792X();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: P */
        public boolean mo10662P() {
            return CameraManager.this.f10758an;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: Q */
        public boolean mo10663Q() {
            return CameraManager.this.mModeManager.m11865aZ();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: R */
        public boolean mo10664R() {
            if (CameraManager.this.f10865cq != null) {
                return CameraManager.this.f10865cq.mo23646F();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10748b(int OplusGLSurfaceView_13, int i2) {
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23660a(OplusGLSurfaceView_13, i2);
            }
            if (CameraManager.this.mCameraUIManager == null || CameraManager.this.f10867cs == null || !mo10710aO()) {
                return;
            }
            if (CameraManager.this.mCameraUIManager.m19750bJ() != null) {
                CameraManager.this.f10867cs.initialize(CameraManager.this.mModeManager.m11796a(CameraManager.this.f10853ce), CameraManager.this.mCameraUIManager.m19750bJ());
            }
            CameraManager.this.f10867cs.setPreviewSize(OplusGLSurfaceView_13, i2);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: S */
        public void mo10665S() {
            CameraManager.this.m10059dk();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10678a(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
            CameraManager.this.m10370k(0);
            CameraManager.this.m10336c(false, false);
            CameraManager.this.m9667a(OplusGLSurfaceView_13, i2, false, OplusGLSurfaceView_15);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo10850i(String str) {
            CameraManager.this.m10174s(str);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10811c(int OplusGLSurfaceView_13, int i2) {
            CameraManager.this.m9666a(OplusGLSurfaceView_13, i2, 0L);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: T */
        public void mo10666T() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11885at();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_15 */
        public void mo10854j(String str) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12096l(str);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10682a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11810a(OplusGLSurfaceView_13, z);
            }
            if (CameraManager.this.f10932eF != null) {
                CameraManager.this.f10932eF.removeMessages(19);
                Message messageObtainMessage = CameraManager.this.f10932eF.obtainMessage(19);
                messageObtainMessage.arg1 = z ? OplusGLSurfaceView_13 : 0;
                CameraManager.this.f10932eF.sendMessage(messageObtainMessage);
            }
            if (z2) {
                CameraManager.this.m9771b(OplusGLSurfaceView_13, z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10810c(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12084i(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: U */
        public void mo10667U() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11846aG();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: V */
        public void mo10668V() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11847aH();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: W */
        public void mo10669W() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11848aI();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: X */
        public boolean mo10670X() {
            return CameraManager.this.m9861bj();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: Y */
        public boolean mo10671Y() {
            return CameraManager.this.isAllowSwitchMode();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_5 */
        public boolean mo10860k(String str) {
            if (!mo10671Y()) {
                return false;
            }
            if (ApsConstant.CAPTURE_MODE_MORE.equals(str)) {
                return true;
            }
            if (CameraManager.this.mModeManager != null) {
                String strM12105n = CameraManager.this.mModeManager.m12105n();
                CameraLog.m12954a("CameraManager", "isHeadlineCanTouch, modeName: " + str + ", currentModeName: " + strM12105n);
                if (TextUtils.equals(str, strM12105n) || ((ApsConstant.CAPTURE_MODE_MICROSCOPE.equals(str) && ApsConstant.REC_MODE_MICROSCOPE.equals(strM12105n)) || ((ApsConstant.CAPTURE_MODE_STARRY.equals(str) && ApsConstant.REC_MODE_STAR_VIDEO.equals(strM12105n)) || (ApsConstant.CAPTURE_MODE_TILT_SHIFT.equals(str) && ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO.equals(strM12105n))))) {
                    return true;
                }
            }
            if (CameraManager.this.f10914dn == null) {
                return false;
            }
            String strM17195b = CameraManager.this.f10914dn.m17195b();
            CameraLog.m12954a("CameraManager", "isHeadlineCanTouch, modeName: " + str + ", lastModeName: " + strM17195b);
            return TextUtils.equals(str, strM17195b);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_14 */
        public void mo10862l(String str) {
            mo10751b(str, true);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10751b(String str, boolean z) {
            CameraLog.m12954a("CameraManager", "onModeTitleClick, modeName: " + str);
            if (mo10800bq() && CameraManager.this.f10801be) {
                if (CameraManager.this.mCameraUIManager.m19924eL()) {
                    CameraLog.m12954a("CameraManager", "onModeTitleClick, TimeLapseProMenu's animation is running, so return.");
                    return;
                }
                if (CameraManager.this.m10280aP()) {
                    return;
                }
                if (mo10658L()) {
                    CameraLog.m12954a("CameraManager", "onModeTitleTouch, can not touch, timesnap is running");
                    return;
                }
                if (mo10814c()) {
                    CameraLog.m12954a("CameraManager", "onModeTitleTouch, can not touch, video record started");
                    return;
                }
                if (str == null) {
                    str = CameraManager.this.mModeManager.m12072f();
                }
                if (str.equals(ApsConstant.CAPTURE_MODE_NIGHT) && CameraManager.this.f10747ac && !CameraManager.this.mModeManager.m11800a(str).getSupportFunction(CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS)) {
                    str = CameraManager.this.mModeManager.m12117q();
                }
                String strM11803a = CameraManager.this.mModeManager.m11803a(CameraManager.this.f10989y, str);
                if (TextUtils.equals(CameraManager.this.mModeManager.m12105n(), strM11803a)) {
                    strM11803a = ApsConstant.CAPTURE_MODE_COMMON;
                }
                CameraManager.this.mCameraUIManager.mo18028D();
                CameraManager.this.mCameraUIManager.m19729b(CameraManager.this.f10989y, strM11803a);
                int iJ = (CameraManager.this.f10890dP == null || CameraManager.this.f10890dP.mo16411a() == null) ? 0 : CameraManager.this.f10890dP.mo16411a().mo16539j();
                int iJ2 = (CameraManager.this.f10890dP == null || CameraManager.this.f10890dP.m16672m() == null) ? 0 : CameraManager.this.f10890dP.m16672m().mo16539j();
                boolean z2 = 1 == iJ;
                int OplusGLSurfaceView_13 = z2 ? 1 : 3;
                if (CameraManager.this.mCameraUIManager.mo19881dY()) {
                    if (mo10769bL().mo16631r() && 150 > Util.f23001i && CameraManager.this.f10984t != 0) {
                        CameraManager.this.mCameraUIManager.mo18068a(0, OplusGLSurfaceView_13);
                    }
                } else if (!Util.m24498u() || 1 == iJ2 || 150 < Util.f23001i || (150 > Util.f23001i && 1 != iJ)) {
                    CameraManager.this.mCameraUIManager.mo18068a(0, OplusGLSurfaceView_13);
                }
                if (z2) {
                    CameraManager.this.mCameraUIManager.m19794c(true, 0);
                } else {
                    CameraManager.this.mCameraUIManager.mo18229j();
                }
                CameraManager.this.f10806bj = true;
                if (CameraManager.this.m10264a(strM11803a, z)) {
                    return;
                }
                CameraManager.this.f10806bj = false;
                CameraManager.this.mCameraUIManager.m19736b(true, 0);
                CameraManager.this.mCameraUIManager.mo18068a(4, 1);
                return;
            }
            CameraLog.m12954a("CameraManager", "onModeTitleTouch, return false, state: " + CameraManager.this.f10982r + ", mbFrameAvailable: " + CameraManager.this.f10801be);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10825d(int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraManager", "onModeItemClick, itemId: " + OplusGLSurfaceView_13);
            boolean z = (3 == OplusGLSurfaceView_13 && !Util.m24498u()) || 28 == OplusGLSurfaceView_13;
            String strM20351d = HeadlineHelper.m20351d(OplusGLSurfaceView_13);
            if (CameraManager.this.mModeManager.m12105n().equals(strM20351d)) {
                CameraManager cameraManager = CameraManager.this;
                cameraManager.m9699a(z, OplusGLSurfaceView_13, TextUtils.equals(cameraManager.mModeManager.m12105n(), strM20351d));
                return;
            }
            if (9 == OplusGLSurfaceView_13) {
                CameraManager.this.m9976cg();
                CameraManager.this.mCameraUIManager.m19723av(true);
                CameraManager.this.m9701a(true, true, -1);
                CameraManager.this.m9601G(true);
                return;
            }
            if (mo10671Y()) {
                CameraManager.this.f10866cr.m11545y();
                CameraManager.this.f10865cq.m23696j(false);
                if (mo10848h(CameraUIInterface.KEY_ZOOM)) {
                    CameraManager.this.m10236a((AnimatorListenerAdapter) null, true, false);
                    CameraManager.this.m10398w(false);
                }
                CameraManager.this.m9605H(false);
                CameraManager cameraManager2 = CameraManager.this;
                cameraManager2.m9699a(z, OplusGLSurfaceView_13, TextUtils.equals(cameraManager2.mModeManager.m12105n(), strM20351d));
                CameraManager.this.mCameraUIManager.mo18259q(true);
                CameraManager.this.f10806bj = true;
                if (OplusGLSurfaceView_13 == 0 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_PANORAMA_SUPPORT)) {
                    CameraManager.this.m10263a(strM20351d, 0, true, false);
                    return;
                } else {
                    CameraManager.this.m10344d(strM20351d);
                    return;
                }
            }
            CameraLog.m12954a("CameraManager", "onModeItemClick, is not allowed to switch mode");
            CameraManager.this.m9973cf();
            CameraManager.this.mCameraUIManager.m19723av(true);
            CameraManager.this.m9701a(true, true, -1);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void resetFaceBeautyValues() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11910bG();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: Z */
        public int mo10672Z() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11909bF();
            }
            return 0;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aa */
        public int mo10722aa() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11906bC();
            }
            return 0;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public int getFaceBeautyItemValue(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12116q(OplusGLSurfaceView_13);
            }
            return -100000;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void onFaceBeautyItemChange(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12113p(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void onFaceBeautyItemValueChange(int OplusGLSurfaceView_13, int i2, boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11894b(OplusGLSurfaceView_13, i2, z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ab */
        public int mo10723ab() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11911bH();
            }
            return 40;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ac */
        public int[] mo10724ac() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11912bI();
            }
            return CameraConstant.f13116a;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ad */
        public int[] mo10725ad() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11913bJ();
            }
            return FaceBeautyHelp.f21226a;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public int mo10830e(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12120r(OplusGLSurfaceView_13);
            }
            return -100000;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void onMakeupTypeChanged(int OplusGLSurfaceView_13, boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11958c(OplusGLSurfaceView_13, z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void onMakeupValueChanged(int OplusGLSurfaceView_13, int i2, boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11808a(OplusGLSurfaceView_13, i2, z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ae */
        public int mo10726ae() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11914bK();
            }
            return 0;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: af */
        public boolean mo10727af() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11999ch();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ag */
        public boolean mo10728ag() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11915bL();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10835f(int OplusGLSurfaceView_13) {
            CameraLog.m12954a("CameraManager", "onBackFromMoreMode");
            CameraManager.this.m9701a(true, true, OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ah */
        public boolean mo10729ah() {
            if (CameraManager.this.f10866cr != null) {
                return CameraManager.this.f10866cr.m11528j();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ai */
        public boolean mo10730ai() {
            if (CameraManager.this.f10866cr != null) {
                return CameraManager.this.f10866cr.m11530k();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public float mo10673a(float COUIBaseListPopupWindow_12) {
            synchronized (CameraManager.this.f10979o) {
                if (CameraManager.this.f10866cr == null || CameraManager.this.f10956ei == null || !CameraManager.this.f10956ei.containsKey(Float.valueOf(COUIBaseListPopupWindow_12))) {
                    return 0.0f;
                }
                return ((Float) CameraManager.this.f10956ei.get(Float.valueOf(COUIBaseListPopupWindow_12))).floatValue();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aj */
        public boolean mo10731aj() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11941bl();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ak */
        public void mo10732ak() {
            synchronized (CameraManager.this.f10979o) {
                if (CameraManager.this.f10956ei != null) {
                    CameraManager.this.f10956ei = null;
                }
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10752b(boolean z) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11507b(z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: al */
        public void mo10733al() {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11508c();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: am */
        public boolean mo10734am() {
            return CameraManager.this.f10866cr != null && CameraManager.this.f10866cr.m11533m();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: an */
        public void mo10735an() {
            CameraManager.this.m10313aw();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ao */
        public String mo10736ao() {
            return CameraManager.this.mModeManager != null ? CameraManager.this.mModeManager.m12105n() : "";
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ap */
        public boolean mo10737ap() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11979cN();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aq */
        public boolean mo10738aq() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11832a();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ar */
        public boolean mo10739ar() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11899b();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: as */
        public boolean mo10740as() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11961c();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: at */
        public boolean mo10741at() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12020d();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_6 */
        public boolean mo10867m(String str) {
            if (CameraManager.this.mCameraUIManager != null) {
                if (CameraUIInterface.KEY_FLASH_MODE.equals(str) && CameraManager.this.mCameraUIManager.m19904dv()) {
                    return false;
                }
                if (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(str) && CameraManager.this.mCameraUIManager.m19905dw()) {
                    return false;
                }
                if (CameraUIInterface.KEY_FILTER_MENU.equals(str) && CameraManager.this.mCameraUIManager.m19906dx()) {
                    return false;
                }
            }
            if (CameraUIInterface.KEY_FLASH_MODE.equals(str) || CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str)) {
                return CameraManager.this.m9950cT();
            }
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12111o(str);
            }
            return true;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public Size mo10674a(double IntrinsicsJvm.kt_5) {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11797a(CameraManager.this.f10853ce, IntrinsicsJvm.kt_5);
            }
            return null;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10686a(final DetectResult c3077a) {
            if (CameraManager.this.f10849ca == null) {
                return;
            }
            CameraManager.this.f10884dJ = c3077a;
            CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.52.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.mModeManager == null || CameraManager.this.mCameraUIManager == null) {
                        return;
                    }
                    if ((C254452.this.mo10720aY() || !CameraManager.this.mModeManager.m11926bW()) && CameraManager.this.f10939eM.mo10576j() != 4) {
                        CameraManager.this.mCameraUIManager.mo18089a((DetectResult) null);
                    } else {
                        CameraManager.this.mCameraUIManager.mo18089a(c3077a);
                    }
                }
            });
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10749b(DetectResult c3077a) {
            CameraManager.this.mCameraUIManager.m19733b(c3077a);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo10813c(boolean z) {
            if (CameraManager.this.f10874cz != null) {
                CameraManager.this.f10874cz.m17981a(z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: au */
        public void mo10742au() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12014cw();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: av */
        public boolean mo10743av() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11937bh();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aw */
        public String mo10744aw() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11986cU();
            }
            return null;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ax */
        public Size mo10745ax() {
            if (CameraManager.this.f10914dn != null) {
                return CameraManager.this.f10914dn.m17200c(CameraManager.this.f10853ce);
            }
            return null;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ay */
        public void mo10746ay() {
            CameraManager.this.m9588C(68);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10840g(int OplusGLSurfaceView_13) {
            CameraManager.this.m9588C(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: az */
        public boolean mo10747az() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11871af();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aA */
        public void mo10696aA() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12009cr();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aB */
        public void mo10697aB() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12010cs();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aC */
        public void mo10698aC() {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11536p();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aD */
        public String mo10699aD() {
            return CameraManager.this.mModeManager != null ? CameraManager.this.mModeManager.m12053dm() : "key_filter_index";
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aE */
        public String mo10700aE() {
            return CameraManager.this.mModeManager != null ? CameraManager.this.mModeManager.m12054dn() : CameraUIInterface.KEY_FILTER_MENU;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aF */
        public String mo10701aF() {
            return CameraManager.this.mModeManager != null ? CameraManager.this.mModeManager.m12055do() : CameraUIInterface.KEY_VIDEO_BLUR_MENU;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aG */
        public void mo10702aG() {
            CameraManager cameraManager = CameraManager.this;
            if (!cameraManager.m10354f(cameraManager.f10870cv)) {
                CameraManager cameraManager2 = CameraManager.this;
                cameraManager2.f10870cv = cameraManager2.m10282aR();
            }
            if (4 != mo10816ca()) {
                CameraManager cameraManager3 = CameraManager.this;
                cameraManager3.m10104g(cameraManager3.f10870cv);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aH */
        public void mo10703aH() {
            if (4 == mo10816ca() || mo10710aO()) {
                return;
            }
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m10104g(cameraManager.f10870cv);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aI */
        public boolean mo10704aI() {
            if (CameraManager.this.mModeManager == null) {
                return false;
            }
            if (mo10747az()) {
                return true;
            }
            if (CameraManager.this.mModeManager.m11849aJ() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_FAST_VIDEO)) {
                return true;
            }
            return CameraManager.this.mModeManager.m11984cS() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aJ */
        public boolean mo10705aJ() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11916bM();
            }
            return true;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aK */
        public void mo10706aK() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12047dg();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aL */
        public int mo10707aL() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11920bQ();
            }
            return 60;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void setBlurIndex(int OplusGLSurfaceView_13, boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12127t(OplusGLSurfaceView_13);
                if (z) {
                    if (CameraManager.this.mModeManager.m12091j(CameraFunction.VIDEO_BLUR_PROCESS)) {
                        CameraManager.this.m10169r(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
                    } else if (CameraManager.this.mModeManager.m12091j(CameraFunction.FACE_BLUR) || CameraManager.this.mModeManager.m12091j(CameraFunction.BOKEH)) {
                        CameraManager.this.m10169r(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX);
                    }
                }
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aM */
        public void mo10708aM() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11783O();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10690a(boolean z, boolean z2) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11960c(z, z2);
                if (z2) {
                    CameraManager.this.m10169r(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aN */
        public boolean mo10709aN() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11921bR();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aO */
        public boolean mo10710aO() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11849aJ();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aP */
        public boolean mo10711aP() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11850aK();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aQ */
        public boolean mo10712aQ() {
            return CameraManager.this.f10762ar;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aR */
        public HintManager mo10713aR() {
            return CameraManager.this.mCameraUIManager.mo18233k();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aS */
        public int mo10714aS() {
            return CameraManager.this.f10700H;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aT */
        public boolean mo10715aT() {
            return CameraManager.this.m9950cT();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aU */
        public boolean mo10716aU() {
            return CameraManager.this.m10047de();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aV */
        public void mo10717aV() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12011ct();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10828d(boolean z) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.m9584B(z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo10845h(int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11513d(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo10833e(boolean z) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11524h(z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10837f(final boolean z) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.m10300aj().m16503a(CameraManager.this.f10866cr.m11518f(), CameraManager.this.f10849ca.findViewById(R.id_renamed.zoom_seek_bar_click), CameraManager.this.f10849ca.findViewById(R.id_renamed.zoom_seek_bar_display_text));
                CameraManager.this.m10300aj().mo16525a(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.-$$Lambda$CameraManager$52$8mPIJ5CIxhoxA1L9oEI1KuoAtDc
                    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                    public final void call(Object[] objArr) {
                        this.COUIBaseListPopupWindow_12$0.m10646a(z, objArr);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m10646a(boolean z, Object[] objArr) {
            CameraManager.this.f10866cr.m11504b(0, z);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aW */
        public void mo10718aW() {
            CameraManager.this.m9951cU();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aX */
        public boolean mo10719aX() {
            return (CameraManager.this.mCameraUIManager.mo18057R() || CameraManager.this.mCameraUIManager.m19941eo() || Camera.f10610l || Camera.f10611m || CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_SHOW_DIM_HINT) || !"off".equals(CameraManager.this.mModeManager.m11787S()) || !CameraManager.this.m9946cR() || mo10814c()) ? false : true;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10750b(String str, String str2) {
            CameraManager.this.m9697a(str, str2);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10681a(int OplusGLSurfaceView_13, boolean z) {
            CameraManager.this.m9901c(OplusGLSurfaceView_13, z);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_11 */
        public void mo10869n(String str) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12114p(str);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: o */
        public void mo10871o(String str) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12118q(str);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aY */
        public boolean mo10720aY() {
            return CameraManager.this.m10207E();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: aZ */
        public boolean mo10721aZ() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11973cH();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ba */
        public boolean mo10784ba() {
            return mo10848h(CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB) && "on".equals(CameraManager.this.f10850cb != null ? CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_SHARE_AND_MARK, CameraManager.this.f10849ca.getString(R.string.camera_share_default_value)) : "off");
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bb */
        public void mo10785bb() {
            if (CameraManager.this.mCameraUIManager.mo18051O() || CameraManager.this.mCameraUIManager.m19821cX()) {
                CameraManager.this.mCameraUIManager.mo18176b(true, true, true, false);
            }
            if (CameraManager.this.mCameraUIManager.mo18043K()) {
                CameraManager.this.mCameraUIManager.mo18109a(true, true, true, true);
            }
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11793Y();
            }
            if (CameraManager.this.f10866cr == null || CameraManager.this.mCameraUIManager == null || CameraManager.this.mCameraUIManager.mo18111aA() || CameraManager.this.mCameraUIManager.mo18043K() || m10794bk() || CameraManager.this.mModeManager == null || CameraManager.this.mModeManager.m11994cc()) {
                return;
            }
            CameraManager.this.f10866cr.m11498a(true, false);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo10849i(int OplusGLSurfaceView_13) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(CameraManager.this.f10849ca);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = OplusGLSurfaceView_13;
            menuClickMsgData.mFuncKeyResult = 1;
            menuClickMsgData.mCaptureMode = mo10736ao();
            menuClickMsgData.mCameraId = CameraManager.this.m10285aU();
            menuClickMsgData.mOrientation = CameraManager.this.f10984t;
            menuClickMsgData.mCaptureType = !mo10648B() ? 1 : 0;
            menuClickMsgData.report();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bc */
        public CameraEntry mo10786bc() {
            return CameraManager.this.f10846cX;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: p */
        public void mo10872p(String str) {
            if (CameraManager.this.mModeManager != null) {
                MenuClickMsgData menuClickMsgData = new MenuClickMsgData(CameraManager.this.f10849ca);
                menuClickMsgData.buildEvent(false);
                menuClickMsgData.mCameraId = mo10655I();
                menuClickMsgData.mCaptureMode = CameraManager.this.mModeManager.m12105n();
                menuClickMsgData.mToolbarType = str;
                menuClickMsgData.mFuncKeyId = 26;
                menuClickMsgData.mFuncKeyResult = "off".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_SUB_SETTING, "off")) ? 2 : 1;
                menuClickMsgData.report();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bd */
        public boolean mo10787bd() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11980cO();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: be */
        public boolean mo10788be() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11981cP();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bf */
        public String mo10789bf() {
            return CameraManager.this.f10872cx;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bg_renamed */
        public String mo10790bg() {
            return CameraManager.this.f10873cy;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bh */
        public boolean mo10791bh() {
            return CameraManager.this.f10850cb != null && "movie".equals(CameraManager.this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, Util.m24382b(CameraManager.this.m9863bk())));
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bi */
        public float mo10792bi() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11987cV();
            }
            return 1.0f;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bj */
        public boolean mo10793bj() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11988cW();
        }

        /* renamed from: bk */
        public boolean m10794bk() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11948bs();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bl */
        public boolean mo10795bl() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11866aa();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bm */
        public boolean mo10796bm() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11949bt();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bn */
        public boolean mo10797bn() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11950bu();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_15 */
        public void mo10853j(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12133v(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo10826d(int OplusGLSurfaceView_13, int i2) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11809a(OplusGLSurfaceView_13, i2, mo10656J(), CameraManager.this.f10699G);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean mo10834e(int OplusGLSurfaceView_13, int i2) {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m11838a(CameraManager.this.f10890dP.mo16411a().mo16529a(CameraManager.this.mCameraUIManager, OplusGLSurfaceView_13, i2), OplusGLSurfaceView_13, i2);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        public void onMultiCameraTypeChanged(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.f10850cb.edit().putInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, OplusGLSurfaceView_13).apply();
                CameraManager.this.blurModeChanged();
                CameraManager.this.mCameraUIManager.mo18266s(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bo */
        public void mo10798bo() {
            if (CameraManager.this.f10865cq != null) {
                CameraManager.this.f10865cq.m23642B();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bp */
        public boolean mo10799bp() {
            return CameraManager.this.f10865cq != null && CameraManager.this.f10865cq.m23641A();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bq */
        public boolean mo10800bq() {
            return CameraManager.this.m10222T();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: q */
        public void mo10875q(String str) {
            CameraManager.this.m10164q(str);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: br */
        public void mo10801br() {
            if (CameraManager.this.f10915do != null) {
                CameraManager.this.f10915do.m16729a(CameraManager.this.f10846cX.m13359w());
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10687a(String str, Object obj, boolean z, boolean z2) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11826a(str, obj, z, z2);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bs */
        public void mo10802bs() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12140y();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bt */
        public boolean mo10803bt() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12143z();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bu */
        public boolean mo10804bu() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11769B();
            }
            return true;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10842g(boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12069e(z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bv */
        public void mo10805bv() {
            CameraManager.this.m10348e(true, false);
            CameraManager.this.m10398w(true);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bw */
        public void mo10806bw() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.m9947cS();
                CameraManager.this.m9595E(true);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bx */
        public boolean mo10807bx() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.mo18043K();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo10846h(boolean z) {
            CameraManager.this.m10392t(z);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo10851i(boolean z) {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19727az(z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: by */
        public boolean mo10808by() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12049di();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo10753b(boolean z, boolean z2) {
            if (CameraManager.this.f10866cr != null) {
                if (z) {
                    CameraManager.this.f10866cr.m11514d(z2);
                } else {
                    CameraManager.this.f10866cr.m11510c(z2);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10685a(EffectType c2687f) {
            if (CameraManager.this.f10864cp == null || c2687f == null) {
                return;
            }
            CameraManager.this.f10864cp.mo22846k(c2687f.m12922a());
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10684a(ClipVideoInfo c2683b, VideoClipManager.PlatformImplementations.kt_3 aVar) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11817a(c2683b, aVar);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_5 */
        public void mo10857k(int OplusGLSurfaceView_13) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12136w(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bz */
        public View mo10809bz() {
            if (CameraManager.this.f10866cr != null) {
                return CameraManager.this.f10866cr.m11518f();
            }
            return null;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bA */
        public boolean mo10758bA() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12058dr();
            }
            return true;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bB */
        public boolean mo10759bB() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12059ds();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bC */
        public void mo10760bC() {
            if (!CameraManager.this.f10926dz || CameraManager.this.mModeManager == null) {
                return;
            }
            CameraManager.this.mModeManager.m12060dt();
            CameraManager.this.f10926dz = false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bD */
        public void mo10761bD() {
            if (CameraManager.this.f10723aE) {
                return;
            }
            CameraManager.this.f10932eF.sendEmptyMessage(25);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bE */
        public void mo10762bE() {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m12061du();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_15 */
        public void mo10855j(boolean z) {
            if (CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11771C(z);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bF */
        public boolean mo10763bF() {
            if (CameraManager.this.f10846cX != null) {
                return CameraManager.this.f10846cX.m13346i();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_5 */
        public void mo10858k(boolean z) {
            CameraManager.this.m10253a(z);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bG */
        public boolean mo10764bG() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m11982cQ();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo10815c(String str, boolean z) {
            return CameraManager.this.mCameraUIManager.m19960h(str, z);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bH */
        public void mo10765bH() {
            if (CameraManager.this.f10864cp != null) {
                CameraManager.this.f10864cp.mo22819c(0);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10679a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
            CameraManager.this.mCameraUIManager.m19657a(OplusGLSurfaceView_13, i2, z, z2, z3, z4);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bI */
        public void mo10766bI() {
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m10352f(cameraManager.f10984t);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bJ */
        public boolean mo10767bJ() {
            return CameraManager.this.mModeManager != null && CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUB_SETTING);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bK */
        public boolean mo10768bK() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12026dC();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_14 */
        public void mo10861l(int OplusGLSurfaceView_13) {
            if (7 == OplusGLSurfaceView_13 && CameraManager.this.f10850cb.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_MAKEUP_TIPS_SHOWED, true)) {
                CameraManager.this.mCameraUIManager.mo18234k(7);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bL */
        public BaseScreenMode mo10769bL() {
            return CameraManager.this.f10890dP.mo16411a();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bM */
        public int mo10770bM() {
            return CameraManager.this.f10984t;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bN */
        public int mo10771bN() {
            return CameraManager.this.f10890dP.mo16411a().m16505b();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bO */
        public int mo10772bO() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12034dK();
            }
            return 60;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bP */
        public int mo10773bP() {
            return CameraManager.this.f10927eA;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bQ */
        public int mo10774bQ() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12024dA();
            }
            return 0;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bR */
        public void mo10775bR() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.mo18060U();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bS */
        public boolean mo10776bS() {
            if (CameraManager.this.mCameraUIManager != null) {
                return CameraManager.this.mCameraUIManager.mo18059T();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bT */
        public boolean mo10777bT() {
            if (CameraManager.this.f10828cF != null) {
                return CameraManager.this.f10726aH && CameraManager.this.f10828cF.isEmpty();
            }
            return true;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bU */
        public boolean mo10778bU() {
            if (CameraManager.this.mCameraUIManager == null || !Util.m24495t()) {
                return false;
            }
            return CameraManager.this.mCameraUIManager.m19921eI();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_14 */
        public void mo10863l(boolean z) {
            if (CameraManager.this.mCameraUIManager == null || !Util.m24495t()) {
                return;
            }
            CameraManager.this.mCameraUIManager.m19720as(z);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo10692a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
            if (CameraManager.this.f10752ah) {
                return false;
            }
            return CameraManager.this.onKeyDown(OplusGLSurfaceView_13, keyEvent);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo10756b(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
            if (CameraManager.this.f10752ah) {
                return false;
            }
            return CameraManager.this.onKeyUp(OplusGLSurfaceView_13, keyEvent);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bV */
        public boolean mo10779bV() {
            return CameraManager.this.f10762ar;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bW */
        public boolean mo10780bW() {
            return CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19922eJ();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo10836f(int OplusGLSurfaceView_13, int i2) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(CameraManager.this.f10849ca);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = OplusGLSurfaceView_13;
            menuClickMsgData.mFuncKeyResult = i2;
            menuClickMsgData.mCaptureMode = mo10736ao();
            menuClickMsgData.mCameraId = CameraManager.this.m10285aU();
            menuClickMsgData.mOrientation = CameraManager.this.f10984t;
            menuClickMsgData.mCaptureType = !mo10648B() ? 1 : 0;
            menuClickMsgData.report();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10680a(int OplusGLSurfaceView_13, String str) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(CameraManager.this.f10849ca);
            menuClickMsgData.buildEvent(true);
            menuClickMsgData.mFuncKeyId = OplusGLSurfaceView_13;
            menuClickMsgData.mItemValue = str;
            menuClickMsgData.mCaptureMode = mo10736ao();
            menuClickMsgData.mCameraId = CameraManager.this.m10285aU();
            menuClickMsgData.mOrientation = CameraManager.this.f10984t;
            menuClickMsgData.mCaptureType = !mo10648B() ? 1 : 0;
            menuClickMsgData.report();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bX */
        public void mo10781bX() {
            if (CameraManager.this.mModeManager == null || !CameraManager.this.mModeManager.m11849aJ()) {
                return;
            }
            CameraManager.this.m10299ai();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bY */
        public void mo10782bY() {
            if (CameraManager.this.f10888dN != null) {
                CameraManager.this.f10888dN.m24667b();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: bZ */
        public void mo10783bZ() {
            if (CameraManager.this.mModeManager == null || CameraManager.this.mCameraUIManager == null) {
                return;
            }
            CameraManager.this.mCameraUIManager.m19851d(CameraManager.this.mCameraUIManager.m19747bG());
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo10841g(int OplusGLSurfaceView_13, int i2) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11492a(OplusGLSurfaceView_13, i2);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: OplusGLSurfaceView_6 */
        public void mo10866m(int OplusGLSurfaceView_13) {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11519f(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ca */
        public int mo10816ca() {
            return CameraManager.this.mCameraUIManager.m19920eH().mo16411a().mo16539j();
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10683a(MediaItem.kt c2436a, Bitmap bitmap) {
            CameraManager.this.m9674a(c2436a, bitmap);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: cb */
        public void mo10817cb() {
            if (CameraManager.this.f10869cu == null || !CameraManager.this.f10869cu.m23003b()) {
                return;
            }
            CameraManager.this.f10869cu.m23007d(true);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: cc */
        public void mo10818cc() {
            if (Util.m24495t() && CameraManager.this.mModeManager != null) {
                CameraManager.this.mModeManager.m11959c(false);
            }
            CameraPreviewUI viewOnLayoutChangeListenerC3444gM19749bI = CameraManager.this.mCameraUIManager.m19749bI();
            if (CameraManager.this.f10869cu == null || viewOnLayoutChangeListenerC3444gM19749bI == null || viewOnLayoutChangeListenerC3444gM19749bI.m23323X()) {
                return;
            }
            CameraManager.this.f10869cu.m23007d(false);
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: cd */
        public void mo10819cd() {
            if (CameraManager.this.f10866cr != null) {
                CameraManager.this.f10866cr.m11485C();
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ce */
        public void mo10820ce() {
            if (CameraManager.this.f10869cu != null) {
                CameraManager.this.f10869cu.m23007d(false);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: cf */
        public void mo10821cf() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19676a((CameraControlUI.IntrinsicsJvm.kt_3) null);
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: cg */
        public boolean mo10822cg() {
            if (CameraManager.this.mModeManager != null) {
                return CameraManager.this.mModeManager.m12125s();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ch */
        public void mo10823ch() {
            if (CameraManager.this.mCameraUIManager != null) {
                CameraManager.this.mCameraUIManager.m19725ax(CameraManager.this.f10989y == 0);
                if (CameraManager.this.f10869cu != null) {
                    CameraManager.this.f10869cu.m23002b(CameraManager.this.mCameraUIManager.mo18207e());
                }
            }
        }

        @Override // com.oplus.camera.p172ui.CameraUIListener
        /* renamed from: ci */
        public OplusViewOutlineProvider mo10824ci() {
            return CameraManager.this.mModeManager.m12039dP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cS */
    public void m9947cS() {
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f10849ca.getResources().getDimensionPixelSize(R.dimen.record_quick_time_margin_top), this.f10849ca.getResources().getDimensionPixelSize(R.dimen.record_time_margin_top));
        valueAnimatorOfInt.setDuration(250L);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.CameraManager.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraManager.this.mCameraUIManager.mo18096a((Float) null, ((Integer) valueAnimator.getAnimatedValue()).intValue(), false, false);
                if (CameraManager.this.mCameraUIListener != null) {
                    if ((CameraManager.this.mCameraUIListener.mo10803bt() || CameraManager.this.mCameraUIListener.mo10814c()) && !CameraManager.this.mCameraUIListener.mo10729ah()) {
                        return;
                    }
                    valueAnimatorOfInt.cancel();
                    CameraManager.this.mCameraUIManager.m19951ey();
                }
            }
        });
        if (valueAnimatorOfInt.isRunning()) {
            return;
        }
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m10115h(float COUIBaseListPopupWindow_12) {
        if (this.mModeManager == null) {
            return false;
        }
        if (this.mModeManager.m11872ag()) {
            return true;
        }
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) ? this.mModeManager.m11962c(COUIBaseListPopupWindow_12) : (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM) && !this.mModeManager.m12082h()) || this.mModeManager.m11900b(COUIBaseListPopupWindow_12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cT */
    public boolean m9950cT() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            return true;
        }
        if (this.mModeManager != null && this.mModeManager.isSatOpen()) {
            if (this.f10771bA) {
                this.f10771bA = false;
                return false;
            }
            return m10115h(m10279aO());
        }
        if (this.mModeManager != null && this.mModeManager.m12091j(CameraUIInterface.KEY_SWITCH_DUAL_CAMERA) && this.f10850cb != null && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            return "camera_main".equals(this.f10850cb.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        if (this.mModeManager != null && ((this.mModeManager.isNoneSatUltraWideAngleOpen() || this.mModeManager.m12006co()) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM))) {
            return false;
        }
        if (this.mModeManager == null || !this.mModeManager.m11918bO()) {
            return (this.mModeManager != null && m9916cC() && this.mModeManager.m12013cv()) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cU */
    public void m9951cU() {
        if (this.mModeManager != null) {
            this.mModeManager.m11923bT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cV */
    public void m9953cV() {
        if (!this.mModeManager.m11921bR() && !this.mCameraUIManager.mo18051O()) {
            this.mCameraUIManager.mo18048N();
        } else if (!this.mModeManager.m11921bR() && this.mCameraUIManager.mo18051O()) {
            this.mCameraUIManager.mo18067a(R.string.camera_one_subject_hint);
            if (this.mModeManager.m12091j(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU) && !this.f10747ac) {
                this.mCameraUIManager.mo18046M();
            }
        }
        this.mCameraUIManager.mo18024B(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9772b(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        if (this.mModeManager != null) {
            this.mModeManager.m12077g(OplusGLSurfaceView_13);
            if (this.f10752ah || !z) {
                return;
            }
            m9588C(68);
        }
    }

    /* renamed from: cW */
    private void m9956cW() {
        if (this.f10828cF == null) {
            this.f10828cF = new ThumbnailProcessor();
            this.f10828cF.setThumbNailProcessListener(this.f10943eQ);
        }
        this.f10828cF.setApsService(this.f10876dB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cX */
    public Thumbnail.IntrinsicsJvm.kt_4 m9958cX() {
        if (this.f10883dI == null) {
            this.f10883dI = new Thumbnail.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.CameraManager.55
                @Override // com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo10413a(Thumbnail c3203e) {
                    if (CameraManager.this.f10849ca != null) {
                        CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.55.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraManager.this.mCameraUIManager != null) {
                                    CameraManager.this.mCameraUIManager.mo18199d(true);
                                }
                            }
                        });
                    }
                }
            };
        }
        return this.f10883dI;
    }

    /* renamed from: ax */
    public boolean m10314ax() {
        if (this.mModeManager == null || this.mCameraUIManager == null || this.mCameraUIManager.m19744bD() == null || this.mCameraUIManager.m19744bD().getVisibility() != 0 || !this.mCameraUIManager.m19744bD().isClickable() || !this.mCameraUIManager.m19744bD().isEnabled() || (m10269aE() && this.mModeManager.m12091j(CameraUIInterface.KEY_STICKER_PROCESS))) {
            return false;
        }
        CameraLog.m12954a("CameraManager", "checkVolumeCanCapture, getCurrentModeName: " + this.mModeManager.m12105n());
        return (ApsConstant.CAPTURE_MODE_COMMON.equals(this.mModeManager.m12105n()) && this.f10766av) ? false : true;
    }

    /* renamed from: ay */
    public boolean m10315ay() {
        return "on".equals(this.f10850cb.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"));
    }

    /* renamed from: az */
    public BaseSloganUtil.PlatformImplementations.kt_3 m10316az() {
        if (this.f10831cI == null || this.f10914dn == null || !m10315ay() || !this.f10914dn.m17198b(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            return null;
        }
        return this.f10831cI.m11699b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10245a(KeyEvent keyEvent) {
        long downTime = keyEvent.getDownTime();
        if (this.f10808bl && keyEvent.getRepeatCount() == 0 && downTime - this.f10711S > 600) {
            this.f10711S = downTime;
            m10265aA();
        } else {
            if (!this.f10808bl || keyEvent.getRepeatCount() <= 0) {
                return;
            }
            this.f10711S = downTime;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m10263a(String str, int OplusGLSurfaceView_13, boolean z, boolean z2) {
        boolean zEquals;
        ModeDataInfo c3351iM21781a;
        String strM17195b = this.f10914dn.m17195b();
        String strM12105n = this.mModeManager.m12105n();
        CameraLog.m12967f("CameraManager", "checkToSwitchMode, lastModeName: " + strM17195b + ", modeName: " + str + ", curModeName: " + strM12105n);
        if (str == null || TextUtils.equals(str, strM17195b) || TextUtils.equals(str, strM12105n)) {
            return false;
        }
        if (-2 == OplusGLSurfaceView_13 && (c3351iM21781a = DataBaseOperator.m21777a().m21781a(HeadlineHelper.m20347b(str))) != null && !c3351iM21781a.m21913f()) {
            OplusGLSurfaceView_13 = 0;
        }
        if (-2 != OplusGLSurfaceView_13) {
            m10178t(OplusGLSurfaceView_13);
            this.mModeManager.m11957c(OplusGLSurfaceView_13);
            this.f10864cp.mo22793a(this.mModeManager.m12105n(), OplusGLSurfaceView_13);
            SharedPreferences.Editor editorEdit = this.f10850cb.edit();
            editorEdit.putString(CameraUIInterface.KEY_CAMERA_ID, Integer.toString(OplusGLSurfaceView_13));
            zEquals = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, "").equals(str);
            editorEdit.apply();
        } else {
            zEquals = false;
        }
        QrCodeManager viewOnClickListenerC2609aa = this.f10908dh;
        if (viewOnClickListenerC2609aa != null) {
            viewOnClickListenerC2609aa.m11216c(false);
        }
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19782bu();
        }
        CameraLog.m12952a("CameraSwitchModePerformance.checkToSwitchMode");
        this.f10873cy = strM12105n;
        this.f10872cx = str;
        BaseMode baseModeM11800a = this.mModeManager.m11800a(str);
        if (baseModeM11800a == null) {
            CameraLog.m12967f("CameraManager", "checkToSwitchMode, the device is not support the mode:" + str);
            return false;
        }
        baseModeM11800a.setCameraId(this.f10989y);
        baseModeM11800a.updateOneCamera(this.f10852cd);
        C2586n c2586n = this.f10913dm;
        baseModeM11800a.beforeSwitchToMode(c2586n != null && c2586n.m11005a());
        C2586n c2586n2 = this.f10913dm;
        if (c2586n2 != null && !c2586n2.m11009c()) {
            this.f10913dm.m11003k();
            m10308ar();
        }
        this.f10813bq = true;
        m10383p(false);
        m10367j(0);
        SharedPreferences.Editor editorEdit2 = this.f10850cb.edit();
        editorEdit2.putString(CameraUIInterface.KEY_CAMERA_MODE, str);
        editorEdit2.apply();
        if (zEquals) {
            m10240a(this.f10850cb, CameraUIInterface.KEY_CAMERA_MODE);
        }
        MainShutterButtonInfo shutterButtonInfo = baseModeM11800a.getShutterButtonInfo();
        if (!Util.m24352ao()) {
            shutterButtonInfo.m19236c(!z2);
        }
        shutterButtonInfo.m19228a(baseModeM11800a.enterNeedShutterButtonAlphaTransition());
        this.mCameraUIManager.m19734b(shutterButtonInfo);
        this.mModeManager.m11895b(13, false);
        m9589C(baseModeM11800a.getSupportFunction(CameraUIInterface.KEY_TORCH_MODE));
        baseModeM11800a.updateInversePositionRatio(true);
        this.f10864cp.mo22790a(baseModeM11800a.getFilterCategory());
        this.mCameraUIManager.m19681a(baseModeM11800a.getFilterCategory());
        this.mCameraUIManager.m19714am(m9708a(baseModeM11800a));
        this.mCameraUIManager.m19715an(m10123i(str));
        this.mCameraUIManager.m19894dl();
        String strM21910c = DataBaseOperator.m21777a().m21781a(HeadlineHelper.m20347b(baseModeM11800a.getCameraMode())).m21910c();
        if (z && "position_headline".equals(strM21910c)) {
            m9588C(1);
        }
        CameraLog.m12958b("CameraSwitchModePerformance.checkToSwitchMode");
        return true;
    }

    /* renamed from: C */
    private void m9589C(boolean z) {
        boolean zEquals;
        if (z) {
            String string = this.f10850cb.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.f10849ca));
            zEquals = string.equals("on");
            if (string.equals("auto")) {
                return;
            }
        } else {
            zEquals = false;
        }
        InverseManager.INS.setInverseColor((Context) this.f10849ca, zEquals, true);
        m9886bw();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m10344d(String str) {
        return m10263a(str, -2, true, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m10264a(String str, boolean z) {
        return m10263a(str, -2, z, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m10328b(String str, boolean z) {
        return m10263a(str, -2, true, z);
    }

    /* renamed from: o */
    private void m10154o(String str) {
        if (!m10222T() || !this.f10801be) {
            CameraLog.m12954a("CameraManager", "gimbalChangeModeFunction, return , mCameraState: " + this.f10982r + ", mbFrameAvailable: " + this.f10801be);
            return;
        }
        if (m10280aP()) {
            CameraLog.m12954a("CameraManager", "gimbalChangeModeFunction invalid, zoom animation is running");
            return;
        }
        if (m10312av()) {
            CameraLog.m12954a("CameraManager", "gimbalChangeModeFunction invalid, timesnap is running");
            return;
        }
        if (m10269aE()) {
            CameraLog.m12954a("CameraManager", "gimbalChangeModeFunction invalid, video record started");
            return;
        }
        m9699a(true, ApsConstant.REC_MODE_COMMON == str ? 21 : 20, false);
        this.mCameraUIManager.m19729b(this.f10989y, str);
        this.mCameraUIManager.mo18068a(0, 1);
        this.mCameraUIManager.m19945es();
        if (m10344d(str)) {
            return;
        }
        this.mCameraUIManager.m19736b(true, 0);
        this.mCameraUIManager.mo18068a(4, 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m10261a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (!this.f10760ap && this.f10807bk && !this.mCameraUIManager.m19811cN() && !this.mCameraUIManager.m19786by() && m10222T() && !m10207E() && !this.f10762ar && !m10312av() && this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) && !this.mModeManager.m11791W()) {
            if (168 == OplusGLSurfaceView_13) {
                if (this.f10866cr != null) {
                    this.f10866cr.m11522g(true);
                }
            } else if (169 == OplusGLSurfaceView_13 && this.f10866cr != null) {
                this.f10866cr.m11522g(false);
            }
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m10325b(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        long downTime = keyEvent.getDownTime();
        String string = this.f10850cb.getString(CameraUIInterface.KEY_VOLUME_KEY_FUNCTION, this.f10849ca.getString(R.string.camera_volume_key_function_default_value));
        if (this.f10808bl && keyEvent.getRepeatCount() == 0 && 600 >= downTime - this.f10711S) {
            return true;
        }
        if ("shutter".equals(string)) {
            if (this.f10808bl && keyEvent.getRepeatCount() == 0 && m10314ax()) {
                this.f10764at = false;
            } else if (!this.f10764at && keyEvent.getRepeatCount() > 0 && 600 < downTime - this.f10711S) {
                this.f10764at = true;
                this.f10711S = downTime;
                m10267aC();
            }
            return true;
        }
        if (!CameraStatisticsUtil.PORTRAIT_ZOOM.equals(string)) {
            return false;
        }
        if (!this.f10760ap && this.f10807bk && !this.mCameraUIManager.m19811cN() && !this.mCameraUIManager.m19786by() && m10222T() && !this.f10762ar && !m10207E() && !m10312av() && this.mModeManager.m12091j(CameraUIInterface.KEY_ZOOM) && !this.mModeManager.m11791W() && !this.mCameraUIManager.m19944er()) {
            if (OplusGLSurfaceView_13 == 24) {
                if (this.f10866cr != null) {
                    this.f10866cr.m11522g(true);
                }
            } else if (this.f10866cr != null) {
                this.f10866cr.m11522g(false);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m9790b(boolean z, boolean z2, boolean z3) {
        boolean zM10260a;
        if (this.mModeManager == null) {
            return false;
        }
        if (this.mCameraUIManager.m19786by()) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, video alert showing, so return");
            return false;
        }
        if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.mModeManager.m12105n())) {
            zM10260a = m10260a(4) && m10260a(5);
        } else {
            zM10260a = m10260a(0);
        }
        if (this.f10752ah || !this.f10807bk || !zM10260a) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, mbPaused: " + this.f10752ah + ", mbInitialized: " + this.f10807bk + ", isSoundLoaded: " + zM10260a);
            return false;
        }
        if (this.mCameraUIManager.m19818cU()) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, isEffectMenuScrolling, so return");
            return false;
        }
        if (this.f10819bw) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, mbFlashStateChanging is true so return");
            return false;
        }
        if (this.f10817bu || (this.f10866cr != null && this.f10866cr.m11544x())) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, mZoomExecutor is excuting, so return, mbZoomStateChanging: " + this.f10817bu);
            return false;
        }
        if (!m10281aQ()) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, zoomValue is not fit sensor mask, so return");
            return false;
        }
        if (!ImageSaverThread.m14696a().m14697a(this.f10849ca, this.mModeManager.m11785Q())) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, memory or storage is not enough");
            this.mModeManager.m11784P();
            m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
            return false;
        }
        if (Storage.f12097w != 0) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, sStorageStatus is failed, so return");
            if (this.f10849ca != null) {
                this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.60
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.mCameraUIManager != null) {
                            CameraManager.this.mCameraUIManager.mo18269t();
                        }
                    }
                });
            }
            return false;
        }
        if (PopUpWindowManager.m20706a() && this.f10849ca != null) {
            this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.61
                @Override // java.lang.Runnable
                public void run() {
                    PopUpWindowManager.m20712d();
                }
            });
        }
        int iE = ImageSaverThread.m14696a().m14709e();
        if (this.mModeManager != null && ((this.mModeManager.m12091j(CameraUIInterface.KEY_RAW_CONTROL) || this.mModeManager.m12091j(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) && iE > 3)) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, rawCount: " + iE);
            this.mCameraUIManager.mo18070a(R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
            m9697a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
            return false;
        }
        if (this.f10760ap || this.f10766av || m10349e() || this.f10762ar || this.f10763as) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, mbSwitchingCamera: " + this.f10760ap + ", mbBurstShot: " + this.f10766av + ", isAnimationRunning: " + m10349e() + ", mbCaptureModeChanging: " + this.f10762ar + ", mbSizeChanging: " + this.f10763as);
            return false;
        }
        if (this.mModeManager.m12075f(false)) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, stopTakePicture sucess, so return");
            return false;
        }
        if (!this.f10875dA) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, mbApsFinishAddFrame: " + this.f10875dA);
            if (this.f10761aq) {
                this.f10932eF.removeMessages(24);
                Message message = new Message();
                message.what = 24;
                message.obj = Boolean.valueOf(z3);
                this.f10932eF.sendMessageDelayed(message, 1000L);
            }
            return false;
        }
        if (!m10222T() && !m10224V()) {
            CameraLog.m12966e("CameraManager", "checkReadyToCapture, mCameraState: " + this.f10982r + ", so return");
            return false;
        }
        if (!z || this.f10865cq == null || !this.f10865cq.m23679c(z2)) {
            return true;
        }
        CameraLog.m12966e("CameraManager", "checkReadyToCapture, checkStateBeforeCapture true, so return");
        return false;
    }

    /* renamed from: aA */
    public void m10265aA() {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19800cC();
        }
    }

    /* renamed from: aB */
    public void m10266aB() {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19802cE();
        }
    }

    /* renamed from: aC */
    public void m10267aC() {
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19801cD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cY */
    public void m9959cY() {
        if (this.mModeManager.m12082h()) {
            m10098f(!this.f10747ac, false);
        } else {
            this.mCameraControlButtonListener.mo10908j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m10098f(boolean z, boolean z2) {
        int OplusGLSurfaceView_13;
        if (m10223U() || (OplusGLSurfaceView_13 = this.f10982r) == 5 || OplusGLSurfaceView_13 == 4) {
            CameraLog.m12966e("CameraManager", "capturePhoto, mCameraState: " + this.f10982r + ", so return");
            return;
        }
        if (!this.f10725aG && (this.mCameraUIListener.mo10848h(CameraFunction.LONG_EXPOSURE) || this.mModeManager.m11992ca())) {
            CameraLog.m12966e("CameraManager", "capturePhoto, mbApsAlgoInitFinish: " + this.f10725aG + ", so return");
            return;
        }
        String strM9937cN = m9937cN();
        if (m10312av() && !this.f10826cD.m19332e()) {
            m9583B(0);
            this.f10826cD.m19333f();
            this.f10881dG = "normal";
        } else if (!"off".equals(strM9937cN)) {
            m10022d(strM9937cN, false);
        } else {
            m10107g(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m10107g(boolean z, boolean z2) {
        m9905c(z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m9905c(final boolean z, final boolean z2, final boolean z3) {
        this.f10922dv = true;
        if (this.f10852cd == null) {
            CameraLog.m12967f("CameraManager", "capture, mOneCamera is null, so return");
            this.f10922dv = false;
            return;
        }
        CameraLog.m12954a("CameraManager", "capture, mbSendCapturePictureRequest: " + this.f10922dv + ", needCheckAFStatus: " + z);
        if (this.mCameraUIManager != null && this.mCameraUIManager.mo19880dX() && this.mCameraUIManager.m19758bR()) {
            this.mCameraUIManager.mo18107a(false, false);
        }
        this.mModeManager.m12037dN();
        ApsService apsService = this.f10876dB;
        if (apsService != null) {
            this.f10852cd.mo13041a(apsService.getCameraPictureCallback());
        }
        if (this.f10897dW == null) {
            this.f10897dW = new CaptureRequestParam();
        }
        this.f10852cd.mo13110l().post(new Runnable() { // from class: com.oplus.camera.CameraManager.62
            @Override // java.lang.Runnable
            public void run() {
                if (!CameraManager.this.m9790b(z, z2, z3)) {
                    if (CameraManager.this.f10932eF != null && !CameraManager.this.m10224V()) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("view_enable", true);
                        bundle.putBoolean("view_ashed", false);
                        CameraManager.this.f10932eF.removeMessages(14);
                        Message messageObtainMessage = CameraManager.this.f10932eF.obtainMessage(14);
                        messageObtainMessage.setData(bundle);
                        messageObtainMessage.sendToTarget();
                    }
                    CameraManager.this.f10881dG = "normal";
                    if (CameraManager.this.f10849ca != null) {
                        CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.62.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraManager.this.m10312av()) {
                                    CameraManager.this.f10826cD.m19333f();
                                }
                            }
                        });
                    }
                    CameraManager.this.f10922dv = false;
                    CameraManager.this.m10253a(true);
                    CameraManager.this.mModeManager.m12038dO();
                    return;
                }
                CameraManager.this.f10734aP = 0;
                CameraManager.this.m10395v(true);
                if (CameraManager.this.f10849ca != null) {
                    CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.62.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CameraManager.this.m10312av()) {
                                CameraManager.this.f10826cD.m19333f();
                            }
                        }
                    });
                }
                if (CameraManager.this.f10874cz != null && CameraManager.this.mModeManager.m11926bW()) {
                    CameraManager.this.f10874cz.m17981a(true);
                }
                if (CameraManager.this.f10876dB != null) {
                    CameraManager.this.f10876dB.setHeicCodecOpen(CameraManager.this.mModeManager.m11929bZ() != null);
                    CameraManager.this.f10876dB.setHighPictureSize(CameraManager.this.mModeManager.m11917bN());
                }
                if (!CameraManager.this.m10213K()) {
                    if (CameraManager.this.f10713U <= 0 || CameraManager.this.f10714V != 0) {
                        CameraManager.this.f10714V = -1L;
                    } else {
                        CameraManager.this.f10714V = System.currentTimeMillis() - CameraManager.this.f10713U;
                    }
                    if (CameraManager.this.f10715W > 0) {
                        CameraManager.this.f10716X = System.currentTimeMillis() - CameraManager.this.f10715W;
                    }
                    CameraManager.this.f10715W = System.currentTimeMillis();
                    CameraLog.m12967f("CameraManager", "CameraTest Shutter Respond Start");
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (!ApsConstant.CAPTURE_MODE_PANORAMA.equals(CameraManager.this.mModeManager.m12105n()) && !CameraManager.this.mModeManager.m11861aV()) {
                        CameraPerformance.m15185a("capture");
                        ComprehensivePerformance.m15119c(jCurrentTimeMillis);
                        FluencyPerformance.m15132b(jCurrentTimeMillis);
                    } else {
                        FluencyPerformance.m15133b(jCurrentTimeMillis, false);
                    }
                    if (CameraManager.this.mModeManager.m11926bW() && CameraManager.this.mCameraUIListener != null && CameraManager.this.f10874cz != null) {
                        DetectResult c3077aM17979a = CameraManager.this.f10874cz.m17979a(System.currentTimeMillis());
                        CameraManager.this.mModeManager.m11820a(c3077aM17979a);
                        if (c3077aM17979a == null || !c3077aM17979a.m17956c() || CameraManager.this.m10207E()) {
                            CameraManager.this.mCameraUIManager.mo18089a((DetectResult) null);
                        } else {
                            CameraManager.this.mCameraUIManager.mo18089a(c3077aM17979a);
                            CameraManager.this.mCameraUIListener.mo10749b(c3077aM17979a);
                        }
                    }
                    CameraLog.m12952a("CameraCapturePerformance.capture");
                    if (!CameraManager.this.mModeManager.m12023d(z3)) {
                        CameraLog.m12966e("CameraManager", "doCapture, capture failed for some reason!");
                        if (CameraManager.this.f10849ca != null) {
                            CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.62.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    CameraManager.this.m10398w(true);
                                    if (CameraManager.this.mModeManager == null || CameraManager.this.mCameraUIManager == null) {
                                        return;
                                    }
                                    CameraManager.this.mModeManager.m11895b(12, true);
                                    CameraManager.this.mCameraUIManager.mo18200d(true, true);
                                    if (CameraManager.this.m10269aE()) {
                                        return;
                                    }
                                    CameraManager.this.mCameraUIManager.mo18092a(CameraManager.this.mModeManager.m12076g(), CameraManager.this.m10047de());
                                }
                            });
                        }
                        CameraManager.this.m10367j(1);
                        CameraManager.this.m10253a(true);
                    }
                    CameraLog.m12958b("CameraCapturePerformance.capture");
                    CameraManager.this.f10881dG = "normal";
                    CameraManager.this.f10922dv = false;
                    return;
                }
                CameraLog.m12967f("CameraManager", "CameraTest Shutter Respond Start");
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (!CameraManager.this.mModeManager.m11861aV()) {
                    CameraPerformance.m15185a("capture");
                    ComprehensivePerformance.m15119c(jCurrentTimeMillis2);
                    FluencyPerformance.m15132b(jCurrentTimeMillis2);
                } else {
                    FluencyPerformance.m15133b(jCurrentTimeMillis2, false);
                }
                if (!CameraManager.this.mModeManager.m12023d(z3)) {
                    if (CameraManager.this.f10849ca != null) {
                        CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.62.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraManager.this.mCameraUIManager != null) {
                                    CameraManager.this.mCameraUIManager.mo18200d(true, false);
                                }
                            }
                        });
                    }
                    CameraManager.this.m10367j(1);
                    CameraManager.this.m10253a(true);
                }
                CameraManager.this.f10881dG = "normal";
                CameraManager.this.f10922dv = false;
                CameraManager.this.mModeManager.m12038dO();
            }
        });
        if (m10303am()) {
            m10392t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cZ */
    public boolean m9961cZ() {
        if (this.mModeManager == null) {
            return false;
        }
        if (this.mModeManager.m11871af()) {
            if (this.mModeManager.m12105n().equals(ApsConstant.CAPTURE_MODE_MICROSCOPE)) {
                m10344d(ApsConstant.REC_MODE_MICROSCOPE);
            } else {
                m10344d(ApsConstant.CAPTURE_MODE_MICROSCOPE);
            }
            this.mCameraUIManager.mo18267s(true);
            return true;
        }
        if (this.mModeManager.m11984cS() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO)) {
            if (this.mModeManager.m12105n().equals(ApsConstant.CAPTURE_MODE_STARRY)) {
                m10344d(ApsConstant.REC_MODE_STAR_VIDEO);
            } else {
                m10344d(ApsConstant.CAPTURE_MODE_STARRY);
            }
            return true;
        }
        if (!this.mModeManager.m11849aJ() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_FAST_VIDEO)) {
            return false;
        }
        if (this.mModeManager.m12105n().equals(ApsConstant.CAPTURE_MODE_TILT_SHIFT)) {
            m10344d(ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO);
        } else {
            m10344d(ApsConstant.CAPTURE_MODE_TILT_SHIFT);
        }
        this.mCameraUIManager.mo18176b(true, false, true, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: da */
    public void m10039da() {
        int OplusGLSurfaceView_13 = this.f10850cb.getInt(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1) == 1 ? 2 : 1;
        this.f10850cb.edit().putInt(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, OplusGLSurfaceView_13).apply();
        int i2 = this.f10850cb.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
        CameraLog.m12959b("CameraManager", "switchMultiVideoSurface: type: " + i2 + ", currentState: " + OplusGLSurfaceView_13);
        if (i2 == 0) {
            this.mCameraUIManager.mo18037H(1 == OplusGLSurfaceView_13);
        } else {
            blurModeChanged();
        }
        this.mCameraUIListener.mo10798bo();
        if (this.mCameraUIManager.mo18111aA()) {
            CameraLog.m12959b("CameraManager", "switchMultiVideoSurface, consumed by MultiVideoSmallSurface");
            this.mCameraUIManager.mo18041J(true);
        }
    }

    /* renamed from: aD */
    public boolean m10268aD() {
        ModeFacade c3020t = this.f10914dn;
        return c3020t != null && c3020t.m17210l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m9588C(int OplusGLSurfaceView_13) {
        if (this.f10839cQ == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            this.f10839cQ.m11294f();
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            this.f10839cQ.m11293e();
        } else if (OplusGLSurfaceView_13 == 68) {
            this.f10839cQ.m11292d();
        } else {
            if (OplusGLSurfaceView_13 != 69) {
                return;
            }
            this.f10839cQ.m11295g();
        }
    }

    /* renamed from: aE */
    public boolean m10269aE() {
        return this.mModeManager != null && this.mModeManager.m11861aV();
    }

    /* renamed from: aF */
    public boolean m10270aF() {
        return this.mModeManager != null && this.mModeManager.m11930ba();
    }

    /* renamed from: aG */
    public boolean m10271aG() {
        return this.mModeManager != null && this.mModeManager.m11865aZ();
    }

    /* renamed from: aH */
    public boolean m10272aH() {
        return this.mModeManager != null && this.mModeManager.m11791W();
    }

    /* renamed from: aI */
    public void m10273aI() {
        if (LocationManager.m16155a() != null) {
            LocationManager.m16155a().m16178b(this.f10850cb);
        }
    }

    /* renamed from: aJ */
    public void m10274aJ() {
        if (this.mModeManager != null) {
            this.mModeManager.m11967cB();
            this.mModeManager.m11957c(this.f10989y);
        }
        this.f10747ac = CameraCharacteristicsUtil.m12974a(this.f10989y);
        if (this.f10864cp == null || this.mModeManager == null) {
            return;
        }
        this.f10864cp.mo22793a(this.mModeManager.m12105n(), this.f10989y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10237a(ComponentName componentName, IBinder iBinder) {
        if (componentName.getClassName().equals(ApsService.class.getName())) {
            try {
                this.f10876dB = ((ApsService.LocalBinder) iBinder).getService();
                if (this.mModeManager != null) {
                    this.mModeManager.m11813a(this.f10876dB);
                }
                this.f10878dD.open();
                CameraLog.m12954a("CameraManager", "onServiceConnected, mApsService: " + this.f10876dB);
                return;
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12966e("CameraManager", "onServiceConnected, ex: " + COUIBaseListPopupWindow_8.getMessage());
                return;
            }
        }
        if (componentName.getClassName().equals(WatchAgentService.class.getName())) {
            this.f10892dR = ((WatchAgentService.BinderC3565a) iBinder).m24704a();
            this.f10892dR.mo24732a(this.f10947eU);
            CameraLog.m12954a("CameraManager", "onServiceConnected, mWatchAgentProxy: " + this.f10892dR);
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$PlatformImplementations.kt_3 */
    public class C2573a {
        public C2573a() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m10937a(int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
            CameraLog.m12954a("CameraManager", "onFinishAddFrame");
            if (CameraManager.this.mModeManager != null && !CameraManager.this.f10753ai) {
                if (z) {
                    CameraManager.this.mModeManager.m12081h(true);
                } else if (!CameraManager.this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_UPDATE_THUMBNAIL_USER_PICTURE)) {
                    CameraManager.this.mModeManager.m11831a(null, OplusGLSurfaceView_13, i2, 256, z, i3);
                }
            }
            CameraManager.this.f10875dA = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m10939a(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
            CameraLog.m12955a("captureX consumeImage size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "27ct_ImageReceived - consumeImage", CameraConstant.f13119d.longValue());
            boolean zM17197b = CameraManager.this.f10914dn.m17197b(cameraPictureImage);
            CameraLog.m12964d("captureX consumeImage size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "27ct_ImageReceived - consumeImage");
            return zM17197b;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m10940b(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
            CameraLog.m12955a("captureX onRawImageReceived size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "26ct_RawImageReceived", CameraConstant.f13119d.longValue());
            CameraManager.this.f10914dn.m17191a(cameraPictureImage);
            CameraLog.m12964d("captureX onRawImageReceived size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "26ct_RawImageReceived");
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m10941c(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
            return CameraManager.this.f10914dn.m17201c(cameraPictureImage);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m10938a(Object obj, Object obj2) {
            if (obj == null || obj2 == null) {
                return;
            }
            ThumbnailCategory thumbnailCategory = (ThumbnailCategory) obj;
            Storage.CameraPicture cameraPicture = (Storage.CameraPicture) obj2;
            CaptureMsgData captureMsgDataM11159a = CaptureMsgDataReportUtil.m11159a(CaptureMsgDataReportUtil.m11160a(thumbnailCategory.mCaptureMsgData, thumbnailCategory), cameraPicture);
            if (CameraManager.this.mModeManager != null) {
                captureMsgDataM11159a = (CaptureMsgData) CameraManager.this.mModeManager.m11802a(captureMsgDataM11159a, cameraPicture);
            }
            if (captureMsgDataM11159a != null) {
                captureMsgDataM11159a.mProcessDuration = String.valueOf(PerformanceMsgData.getPointTime(CaptureMsgData.PROCESS_DURATION));
                captureMsgDataM11159a.report();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m10320b(Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        CameraLog.m12967f("CameraManager", "onReceiver, intent action: " + action + ", packageName: " + (extras != null ? extras.getString("android.media.EXTRA_RECORD_START_PACKAGE_TYPE") : null));
        if (action == null) {
            return;
        }
        if (action.equals("android.intent.action.MEDIA_MOUNTED") || action.equals("android.intent.action.MEDIA_CHECKING")) {
            m9804bG();
            return;
        }
        if (action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
            Storage.m11111a(this.f10849ca.getApplicationContext());
            m9804bG();
            if (this.f10744aZ || this.f10743aY) {
                return;
            }
            if (!ImageSaverThread.m14696a().m14711g()) {
                CameraLog.m12959b("CameraManager", "onReceiver, imageSaveList is not Empty, so return.");
                return;
            } else {
                if (this.f10846cX.m13317J() != 1 || this.mModeManager == null || this.mModeManager.m11861aV() || m10224V()) {
                    return;
                }
                this.mCameraUIManager.mo18199d(false);
                return;
            }
        }
        if (action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
            if (this.mModeManager.m11861aV() && "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_STORAGE_PLACE, this.f10849ca.getString(R.string.camera_storage_default_value)))) {
                this.f10856ch.mo9567m();
            }
            m9804bG();
            this.mCameraUIManager.mo18199d(false);
            return;
        }
        if (action.equals("android.intent.action.MEDIA_PRE_SHARED") || action.equals("android.intent.action.MEDIA_SHARED")) {
            if (this.mModeManager.m11861aV() && "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_STORAGE_PLACE, this.f10849ca.getString(R.string.camera_storage_default_value)))) {
                this.f10849ca.finish();
                return;
            }
            return;
        }
        if ("android.intent.action.MEDIA_EJECT".equals(action)) {
            if (this.mModeManager.m11861aV() && "on".equals(this.f10850cb.getString(CameraUIInterface.KEY_STORAGE_PLACE, this.f10849ca.getString(R.string.camera_storage_default_value)))) {
                this.f10856ch.mo9567m();
                return;
            }
            return;
        }
        if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            this.f10974g = intent.getIntExtra("level", -1);
            m10361h(this.f10974g);
            this.f10845cW = intent.getIntExtra("plugged", 0) != 0;
            CameraLog.m12954a("CameraManager", "onReceiver, temperature: " + intent.getIntExtra("temperature", -1));
            return;
        }
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && !this.f10820bx) {
            Display defaultDisplay = ((WindowManager) this.f10849ca.getSystemService("window")).getDefaultDisplay();
            m10041db();
            if (1 != defaultDisplay.getState()) {
                return;
            }
            if ((this.f10850cb != null && m10045dd() && this.f10895dU) || !m9861bj()) {
                this.f10846cX.m13332a(false);
                this.f10846cX.m13335b(true);
            }
            m10056di();
            if (this.mCameraUIManager != null) {
                this.mCameraUIManager.m19877dU();
            }
            if (this.mModeManager != null && this.f10752ah) {
                this.mModeManager.m12097l(false);
            }
            if (!this.f10920dt) {
                CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.66
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19824ca() && CameraManager.this.f10849ca != null) {
                            CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.66.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (CameraManager.this.mCameraUIManager != null) {
                                        CameraManager.this.mCameraUIManager.m19766bZ();
                                    }
                                }
                            });
                        }
                        CameraManager.this.m9996cq();
                    }
                }, "clearLockDB");
                m10392t(true);
            }
            if (this.f10846cX.m13359w()) {
                m10333c();
                this.f10849ca.finish();
                return;
            }
            return;
        }
        if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            if (this.f10752ah) {
                return;
            }
            if (this.f10744aZ) {
                m10389s(true);
            }
            if (this.mCameraUIManager == null || this.mCameraUIManager.m19745bE() != null) {
                return;
            }
            this.mCameraUIManager.m19766bZ();
            return;
        }
        if ("android.intent.action.PHONE_STATE".equals(action)) {
            String stringExtra = intent.getStringExtra("state");
            this.f10705M = ((TelephonyManager) this.f10849ca.getSystemService("phone")).getCallState();
            if (stringExtra != null) {
                CameraLog.m12954a("CameraManager", "onReceiver, phone state: " + stringExtra + ", mPhoneState: " + this.f10705M);
                if (!TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra) || this.f10752ah || this.mModeManager == null || !this.mModeManager.m11861aV()) {
                    return;
                }
                CameraLog.m12954a("CameraManager", "onReceiver, phone offhook, forceStopVideoRecording");
                this.mModeManager.m12103m(true);
                if (this.mModeManager.m12091j(CameraUIInterface.KEY_QUICK_VIDEO)) {
                    this.mCameraUIManager.mo18280w();
                    LockViewDragLayout.setVolumeDownState(false);
                    return;
                }
                return;
            }
            return;
        }
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
            String stringExtra2 = intent.getStringExtra("reason");
            CameraLog.m12954a("CameraManager", "onReceiver, ACTION_CLOSE_SYSTEM_DIALOGS, reason: " + stringExtra2);
            if ("homekey".equals(stringExtra2)) {
                MagShellResponseStatus c2918s = this.f10954eg;
                if (c2918s != null) {
                    c2918s.m16304f();
                }
                if (this.f10824cB != null) {
                    this.f10824cB.m11261a();
                }
            }
            if ("homekey".equals(stringExtra2) || "recentapps".equals(stringExtra2)) {
                TeleSmallPreviewManager c3431ab = this.f10869cu;
                if (c3431ab != null && c3431ab.m23003b()) {
                    this.f10869cu.m22998a(false, false, false);
                }
                this.f10728aJ = true;
                m10041db();
                if (this.mModeManager != null) {
                    this.mModeManager.m11966cA();
                }
                if (this.f10895dU) {
                    this.f10846cX.m13332a(false);
                }
                m10056di();
                if (this.mCameraUIManager != null) {
                    this.mCameraUIManager.m19877dU();
                    this.mCameraUIManager.m19700aB(true);
                }
                if (this.f10846cX.m13359w()) {
                    if (this.mModeManager != null) {
                        this.mModeManager.m12097l(false);
                    }
                    if (!this.f10920dt) {
                        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.CameraManager.68
                            @Override // java.lang.Runnable
                            public void run() {
                                CameraManager.this.m9996cq();
                            }
                        }, "clearLockDB");
                        this.f10920dt = true;
                    }
                    if (this.f10752ah) {
                        return;
                    }
                    if (this.f10849ca != null) {
                        this.f10849ca.finishAndRemoveTask();
                    }
                    MyApplication.m11090c();
                    return;
                }
                return;
            }
            return;
        }
        if ("com.heytap.speechassist.intent.action.WINDOW_MANAGER_OCCUPIED".equals(action) && !this.f10752ah) {
            if (this.mModeManager != null && this.mModeManager.m11791W()) {
                this.mModeManager.m12075f(true);
                return;
            }
            if (this.f10826cD != null && this.f10826cD.m19331d()) {
                this.f10826cD.m19333f();
                return;
            }
            if (this.mModeManager == null || !this.mModeManager.m11861aV()) {
                return;
            }
            this.mModeManager.m12103m(false);
            if (this.mModeManager.m12091j(CameraUIInterface.KEY_QUICK_VIDEO)) {
                this.mCameraUIManager.mo18280w();
                LockViewDragLayout.setVolumeDownState(false);
                return;
            }
            return;
        }
        if ("com.heytap.speechassist.intent.action.FLOAT_ACTIVITY_START".equals(action)) {
            this.f10849ca.finish();
            return;
        }
        if ("android.location.MODE_CHANGED".equals(action)) {
            if (this.f10831cI != null) {
                this.f10831cI.m11704g();
            }
            if (LocationManager.m16155a() != null) {
                LocationManager.m16155a().m16173a((SharedPreferences) this.f10850cb);
                return;
            }
            return;
        }
        if (action.equals("com.oplus.camera.TIPS_MANAGER_BR_ACTION")) {
            if (this.mCameraUIManager != null) {
                int intExtra = intent.getIntExtra("com.oplus.camera.TIPS_MANAGER_DATA", 1);
                CameraLog.m12959b("CameraManager", "onReceiver, tips type : " + intExtra);
                if (intExtra == 1) {
                    BaseMode baseModeM11800a = this.mModeManager.m11800a(ApsConstant.CAPTURE_MODE_COMMON);
                    if (baseModeM11800a instanceof CommonCapMode) {
                        ((CommonCapMode) baseModeM11800a).showUltraWideTips();
                        return;
                    }
                    return;
                }
                if (intExtra == 2) {
                    this.mCameraUIManager.m19629M(1);
                    return;
                } else if (intExtra == 3) {
                    this.mCameraUIManager.m19629M(0);
                    return;
                } else {
                    if (intExtra != 4) {
                        return;
                    }
                    this.mCameraUIManager.m19629M(2);
                    return;
                }
            }
            return;
        }
        if ("com.oplus.camera.IOT_CAPTURE".equals(action)) {
            m10044dc();
            return;
        }
        if ("android.bluetooth.binauralrecord.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
            int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            CameraLog.m12954a("CameraManager", "onReceiver, INTENT_BINAURAL_RECORD_STATE_ACTION, state: " + intExtra2);
            if (this.mModeManager != null) {
                if (2 == intExtra2) {
                    this.f10783bM = true;
                    this.mModeManager.m11829a(true);
                    return;
                } else {
                    if (intExtra2 == 0 || 3 == intExtra2) {
                        this.f10783bM = false;
                        this.mModeManager.m11829a(false);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && 10 == intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) && this.f10783bM && this.mModeManager != null) {
            this.f10783bM = false;
            this.mModeManager.m11829a(false);
        }
    }

    /* renamed from: aK */
    public void m10275aK() {
        if (this.mCameraUIManager == null || this.f10752ah) {
            return;
        }
        this.mCameraUIManager.mo18199d(false);
    }

    /* renamed from: db */
    private void m10041db() {
        if (2 == this.f10846cX.m13317J() && this.f10752ah) {
            this.f10850cb.edit().putFloat(CameraUIInterface.KEY_ZOOM_FROM_OTHER_APP, this.f10870cv).apply();
            return;
        }
        CameraLog.m12954a("CameraManager", "resaveZoomValue, start");
        this.f10814br = false;
        if (this.f10752ah) {
            CameraLog.m12954a("CameraManager", "resaveZoomValue,  mZoomValue： " + this.f10870cv + ", mbisUltraWideAngleOpen： " + this.f10815bs);
            this.f10850cb.edit().putFloat(CameraUIInterface.KEY_ZOOM, this.f10870cv).apply();
            if (this.f10815bs) {
                this.f10815bs = false;
                if (!this.mModeManager.m12005cn()) {
                    this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                }
            }
            if (this.f10816bt) {
                this.f10816bt = false;
                this.f10850cb.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "on").apply();
            }
        }
    }

    /* renamed from: dc */
    private void m10044dc() {
        this.f10932eF.mo13242a(new Runnable() { // from class: com.oplus.camera.CameraManager.69
            @Override // java.lang.Runnable
            public void run() {
                if (CameraManager.this.mModeManager != null && CameraManager.this.m9861bj() && CameraManager.this.m10327b(CameraFunction.IOT_CAPTURE)) {
                    if (CameraManager.this.mModeManager != null && CameraManager.this.mCameraUIManager != null && CameraManager.this.mCameraUIManager.m19758bR() && ((!CameraManager.this.mModeManager.m11861aV() || CameraManager.this.mModeManager.m12095k()) && !CameraManager.this.mModeManager.m11791W() && !CameraManager.this.f10951ed && !CameraManager.this.f10766av)) {
                        if (CameraManager.this.f10856ch != null) {
                            CameraManager.this.f10856ch.mo9570p();
                        }
                        CameraManager.this.mCameraUIManager.m19813cP();
                        if (CameraManager.this.mModeManager.m12095k()) {
                            CameraManager.this.f10881dG = "earphone";
                            CameraManager.this.mCameraControlButtonListener.mo10906h();
                            return;
                        }
                        if (CameraManager.this.mModeManager.m12082h()) {
                            if (!CameraManager.this.m10223U() && CameraManager.this.f10982r != 5 && CameraManager.this.f10982r != 4) {
                                String strM9937cN = CameraManager.this.m9937cN();
                                if ("off".equals(strM9937cN)) {
                                    strM9937cN = "3";
                                }
                                if (CameraManager.this.f10826cD == null || !CameraManager.this.f10826cD.m19331d()) {
                                    CameraManager.this.f10881dG = "earphone";
                                    CameraManager.this.m10022d(strM9937cN, true);
                                    return;
                                } else {
                                    CameraLog.m12954a("CameraManager", "doIotCapture, TimerSnap is running, return");
                                    return;
                                }
                            }
                            CameraLog.m12954a("CameraManager", "doIotCapture, mCameraState: " + CameraManager.this.f10982r + ", so return");
                            return;
                        }
                        return;
                    }
                    CameraLog.m12954a("CameraManager", "doIotCapture, return");
                    return;
                }
                CameraLog.m12954a("CameraManager", "doIotCapture, do not support");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9695a(LocationManager.PlatformImplementations.kt_3 aVar) {
        if (aVar == null) {
            CameraLog.m12966e("CameraManager", "isGrandTourCity() - Camera address is null. Ignore!");
            return;
        }
        String lowerCase = LocationHelper.m24552a(aVar).replace(" ", "").toLowerCase();
        boolean zContains = FilterHelper.m22629d().contains(lowerCase);
        CameraLog.m12959b("CameraManager", "isGrandTourCity() - PrevCity : " + this.f10959el + "city : " + lowerCase + " Is GrandTour city " + zContains);
        if (!zContains) {
            this.f10959el = "";
            this.mCameraUIListener.mo10666T();
        } else {
            if (this.f10959el.equalsIgnoreCase(lowerCase) && FilterHelper.m22633g()) {
                return;
            }
            this.mCameraUIListener.mo10666T();
            this.f10959el = lowerCase;
            this.mCameraUIListener.mo10854j(lowerCase);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m9593D(boolean z) {
        LocationManager.PlatformImplementations.kt_3 aVarM24550a;
        CameraLog.m12959b("CameraManager", "updateGrandTourFilters");
        if (z) {
            CameraLog.m12966e("CameraManager", "UpdateGrandTourFilters, Grand tour filters won't support for front camera.");
            return;
        }
        if (this.f10962eo == null || this.f10836cN == null) {
            CameraLog.m12966e("CameraManager", "updateGrandTourFilters, location or address is null");
            return;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER) && this.f10846cX.m13317J() != 2 && this.mModeManager.m12091j(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
            if (Double.isNaN(this.f10960em) && Double.isNaN(this.f10961en)) {
                this.f10960em = this.f10962eo.getLatitude();
                this.f10961en = this.f10962eo.getLongitude();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.f10962eo.getLatitude(), this.f10962eo.getLongitude(), this.f10960em, this.f10961en, fArr);
                CameraLog.m12959b("CameraManager", "updateGrandTourFilters, Result length: " + fArr.length + " , Gap: " + fArr[0]);
                if (fArr[0] < 500.0f) {
                    CameraLog.m12966e("CameraManager", "updateGrandTourFilters, No need to update the grand tour list. Ignore");
                    return;
                }
            }
            this.f10960em = this.f10962eo.getLatitude();
            this.f10961en = this.f10962eo.getLongitude();
            if (this.f10836cN == null || (aVarM24550a = LocationHelper.m24550a(this.f10836cN)) == null) {
                return;
            }
            m9695a(aVarM24550a);
            return;
        }
        CameraLog.m12959b("CameraManager", "updateGrandTourFilters, Reset the filter list");
        if (this.f10959el != null) {
            this.f10959el = "";
            this.f10960em = Double.NaN;
            this.f10961en = Double.NaN;
            this.mCameraUIListener.mo10666T();
        }
    }

    /* renamed from: dd */
    private boolean m10045dd() throws SecurityException {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f10849ca.getApplicationContext().getSystemService("activity")).getRunningTasks(1);
        return Camera.class.getName().equals((runningTasks == null || runningTasks.size() <= 0 || (runningTaskInfo = runningTasks.get(0)) == null || runningTaskInfo.topActivity == null) ? null : runningTaskInfo.topActivity.getClassName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9694a(Storage.CameraPicture cameraPicture) throws IOException {
        boolean z;
        ExifInterface exifInterfaceM24231a;
        CameraStatisticsUtil.MakerNote makerNoteM11933bd;
        CameraStatisticsUtil.MakerNote makerNote;
        if (cameraPicture == null) {
            return;
        }
        if (cameraPicture.mPath == null || cameraPicture.mPath.isEmpty()) {
            if (cameraPicture.f12132e == null || cameraPicture.f12132e.length <= 0 || "heic_8bits".equalsIgnoreCase(cameraPicture.f12135h) || "heic_10bits".equalsIgnoreCase(cameraPicture.f12135h)) {
                CameraLog.m12959b("CameraManager", "writeOplusDateToExif, picture is invalid");
                return;
            }
            z = false;
        } else {
            z = true;
        }
        CameraLog.m12959b("CameraManager", "writeOplusDateToExif, isJpegPath: " + z);
        if (z) {
            exifInterfaceM24231a = Util.m24377b(cameraPicture.mPath);
        } else {
            exifInterfaceM24231a = Util.m24231a(cameraPicture.f12132e);
        }
        if (exifInterfaceM24231a == null || (makerNoteM11933bd = this.mModeManager.m11933bd()) == null) {
            return;
        }
        makerNoteM11933bd.f16148J = String.valueOf(this.f10989y);
        makerNoteM11933bd.f16149K = String.valueOf(this.mModeManager.m12105n());
        makerNoteM11933bd.f16151M = String.valueOf(m10393u());
        Face[] faceArr = this.f10857ci;
        if (faceArr != null && faceArr.length > 0) {
            ArrayList<CameraStatisticsUtil.FaceSize> arrayList = new ArrayList<>();
            ArrayList<CameraStatisticsUtil.FaceCoordinate> arrayList2 = new ArrayList<>();
            for (Face face : this.f10857ci) {
                CameraStatisticsUtil.FaceSize faceSize = new CameraStatisticsUtil.FaceSize();
                faceSize.f16141N1 = String.valueOf(face.getBounds().width());
                faceSize.f16142N2 = String.valueOf(face.getBounds().height());
                arrayList.add(faceSize);
                CameraStatisticsUtil.FaceCoordinate faceCoordinate = new CameraStatisticsUtil.FaceCoordinate();
                faceCoordinate.f16137L1 = String.valueOf(face.getBounds().left);
                faceCoordinate.f16138L2 = String.valueOf(face.getBounds().top);
                faceCoordinate.f16139L3 = String.valueOf(face.getBounds().right);
                faceCoordinate.f16140L4 = String.valueOf(face.getBounds().bottom);
                arrayList2.add(faceCoordinate);
            }
            makerNoteM11933bd.f16152N = arrayList;
            makerNoteM11933bd.f16150L = arrayList2;
            makerNoteM11933bd.f16157S = String.valueOf(this.f10699G);
        }
        makerNoteM11933bd.f16156R = String.valueOf(this.mModeManager.m11906bC());
        Gson gson = new Gson();
        String attribute = exifInterfaceM24231a.getAttribute("MakerNote");
        if (attribute == null || attribute.isEmpty()) {
            makerNote = null;
        } else {
            try {
                makerNote = (CameraStatisticsUtil.MakerNote) gson.fromJson(attribute, CameraStatisticsUtil.MakerNote.class);
            } catch (JsonSyntaxException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        if (makerNote != null) {
            makerNoteM11933bd.f16143A = makerNote.f16143A;
            makerNoteM11933bd.f16144B = makerNote.f16144B;
            makerNoteM11933bd.f16145C = makerNote.f16145C;
            makerNoteM11933bd.f16147I = makerNote.f16147I;
            makerNoteM11933bd.f16154P = makerNote.f16154P;
            makerNoteM11933bd.f16155Q = makerNote.f16155Q;
            makerNoteM11933bd.f16159U = makerNote.f16159U;
            makerNoteM11933bd.f16160V = makerNote.f16160V;
            makerNoteM11933bd.PiFlag = makerNote.PiFlag;
            makerNoteM11933bd.nightFlag = makerNote.nightFlag;
            makerNoteM11933bd.asdOut = makerNote.asdOut;
            makerNoteM11933bd.iso = makerNote.iso;
            makerNoteM11933bd.expTime = makerNote.expTime;
        }
        String json = gson.toJson(makerNoteM11933bd);
        if (json == null || json.isEmpty()) {
            return;
        }
        cameraPicture.f12109G = json;
    }

    /* renamed from: aL */
    public long m10276aL() {
        if (this.mModeManager != null) {
            return this.mModeManager.m11934be();
        }
        return 0L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10238a(Context context, Location location, boolean z) {
        if (location == null || context == null) {
            return;
        }
        this.f10962eo = location;
        if (z && "zh-CN".equals(Util.m24361ax())) {
            LocationManager.PlatformImplementations.kt_3 aVarM24549a = LocationHelper.m24549a(context, location);
            CameraLog.m12954a("CameraManager", "onLocationUpdated, isLastKnownLcation: " + z);
            if (aVarM24549a != null) {
                aVarM24549a.f15847i = location;
                this.f10835cM = aVarM24549a;
                return;
            }
        }
        Thread thread = this.f10834cL;
        if (thread != null && thread.isAlive()) {
            CameraLog.m12954a("CameraManager", "onLocationUpdated, GetAddressThread is running");
        } else if (this.f10980p != null) {
            this.f10834cL = new C2584l("get_address_thread", context, location);
            this.f10980p.submit(this.f10834cL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: de */
    public boolean m10047de() {
        return !this.mCameraUIManager.mo18057R() && (m10327b(CameraUIInterface.KEY_BURST_SHOT) || m10327b(CameraUIInterface.KEY_SHORT_VIDEO) || m10327b(CameraUIInterface.KEY_QUICK_VIDEO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: df */
    public boolean m10050df() {
        return !this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.f10849ca.getString(R.string.camera_gesture_shutter_default_value)).equals(this.f10850cb.getString(CameraUIInterface.KEY_LAST_CAMERA_GESTURE_SHUTTER, this.f10849ca.getString(R.string.camera_gesture_shutter_default_value)));
    }

    /* renamed from: com.oplus.camera.CameraManager$OplusGLSurfaceView_14 */
    private class C2584l extends Thread {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private WeakReference<Context> f11180b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Location f11181c;

        public C2584l(String str, Context context, Location location) {
            super(str);
            this.f11180b = null;
            this.f11181c = null;
            this.f11180b = new WeakReference<>(context);
            this.f11181c = location;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            Location location;
            if (BaseSloganUtil.m11672a(this.f11180b.get(), CameraManager.this.f10850cb)) {
                Address addressM24229a = Util.m24229a(this.f11180b.get(), this.f11181c, true);
                if (addressM24229a == null) {
                    CameraLog.m12966e("CameraManager", "GetAddressThread run, address is null, return");
                    CameraManager.this.m9695a((LocationManager.PlatformImplementations.kt_3) null);
                    if (CameraManager.this.f10835cM.f15847i == null || this.f11181c == null) {
                        return;
                    }
                    if (CameraManager.this.f10835cM.f15847i.getLatitude() == this.f11181c.getLatitude() && CameraManager.this.f10835cM.f15847i.getLongitude() == this.f11181c.getLongitude()) {
                        return;
                    }
                    CameraManager.this.f10835cM = null;
                    return;
                }
                LocationManager.PlatformImplementations.kt_3 aVarM24550a = LocationHelper.m24550a(addressM24229a);
                CameraLog.m12959b("CameraManager", "GetAddressThread");
                if (aVarM24550a != null && (location = this.f11181c) != null) {
                    aVarM24550a.f15847i = location;
                    CameraManager.this.f10835cM = aVarM24550a;
                }
            }
            CameraManager.this.f10836cN = Util.m24229a(this.f11180b.get(), this.f11181c, false);
            CameraManager cameraManager = CameraManager.this;
            cameraManager.m9593D(CameraCharacteristicsUtil.m12974a(cameraManager.f10989y));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Rect m10331c(float COUIBaseListPopupWindow_12) {
        Rect rectM13269d = this.f10853ce.m13269d();
        Rect rect = new Rect();
        int iWidth = rectM13269d.width() / 2;
        int iHeight = rectM13269d.height() / 2;
        float f2 = COUIBaseListPopupWindow_12 * 2.0f;
        int iWidth2 = (int) (rectM13269d.width() / f2);
        int iHeight2 = (int) (rectM13269d.height() / f2);
        rect.set(iWidth - iWidth2, iHeight - iHeight2, iWidth + iWidth2, iHeight + iHeight2);
        return rect;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m10120i(float COUIBaseListPopupWindow_12) {
        synchronized (this.f10979o) {
            if (this.f10866cr != null && this.mModeManager != null && this.mModeManager.m11941bl()) {
                if (this.f10956ei == null || this.f10956ei.size() > 500) {
                    this.f10956ei = new HashMap<>();
                }
                this.f10956ei.put(Float.valueOf(COUIBaseListPopupWindow_12), Float.valueOf(this.f10866cr.m11531l()));
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10232a(float COUIBaseListPopupWindow_12, boolean z) {
        if (this.f10752ah) {
            return;
        }
        if (this.mModeManager != null && this.mModeManager.m12091j(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE) && m9934cL() && !this.mModeManager.m11931bb() && !this.mModeManager.m11932bc()) {
            COUIBaseListPopupWindow_12 = (COUIBaseListPopupWindow_12 - 2.0f) + m10282aR();
        }
        CameraLog.m12959b("CameraManager", "updateZoomValue, value: " + COUIBaseListPopupWindow_12 + ", submit: " + z);
        if (this.mModeManager != null && this.f10852cd != null) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_NEED_SET_ZOOMRATIO) && m9931cK() && COUIBaseListPopupWindow_12 - ZoomManager.f12334a < 1.0E-6f) {
                COUIBaseListPopupWindow_12 = 1.0f;
            }
            m10120i(COUIBaseListPopupWindow_12);
            this.f10870cv = COUIBaseListPopupWindow_12;
            if (m10327b(CameraUIInterface.KEY_PORTRAIT_HALF_BODY)) {
                COUIBaseListPopupWindow_12 = 1.0f;
            }
            this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(COUIBaseListPopupWindow_12));
            m10127j(COUIBaseListPopupWindow_12);
            FluencyPerformance.m15142f(System.currentTimeMillis());
            if (z) {
                this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            if (Util.m24459h("oplus.software.video.surround_record_support") && Util.m24173E() && (this.mModeManager.m12091j(CameraUIInterface.KEY_VIDEO_SOUND_REAR) || this.mModeManager.m12091j(CameraUIInterface.KEY_VIDEO_SOUND_FRONT))) {
                int OplusGLSurfaceView_13 = (int) ((COUIBaseListPopupWindow_12 - 1.0f) * 10.0f);
                if (OplusGLSurfaceView_13 <= 0) {
                    OplusGLSurfaceView_13 = 1;
                }
                CameraLog.m12954a("CameraManager", "updateZoomValue soundValue: " + OplusGLSurfaceView_13);
                this.mModeManager.m12123s(OplusGLSurfaceView_13);
                this.mModeManager.m12018d(COUIBaseListPopupWindow_12);
            }
            if (this.mCameraUIManager != null) {
                if (this.mModeManager.m11918bO()) {
                    this.mCameraUIManager.m19788c(1.0f);
                } else if (TextUtils.equals("portrait", this.mModeManager.m12105n()) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_FACEVIEW_INSENSOR_ZOOM_SUPPORT)) {
                    this.mCameraUIManager.m19788c(1.0f);
                } else {
                    this.mCameraUIManager.m19788c(COUIBaseListPopupWindow_12);
                }
            }
        }
        if (this.mModeManager != null) {
            this.mModeManager.m12016cy();
        }
        if (this.f10849ca != null) {
            this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.-$$Lambda$CameraManager$PPrBpEZFE-U8HGd4AiOOEqOUc-U
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m10072dq();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dq */
    public /* synthetic */ void m10072dq() {
        if (this.f10752ah || this.f10865cq == null) {
            return;
        }
        this.f10865cq.m23671b(this.f10870cv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m9595E(boolean z) {
        String strM11787S = this.mModeManager.m11787S();
        boolean zM12974a = CameraCharacteristicsUtil.m12974a(this.f10989y);
        String str = zM12974a ? CameraUIInterface.KEY_TORCH_MODE : CameraUIInterface.KEY_FLASH_MODE;
        if (z) {
            if ("on".equals(strM11787S) || "auto".equals(strM11787S)) {
                this.mModeManager.m12134v(true);
                this.mModeManager.m11827a("off", true);
                this.mCameraUIManager.mo18171b(str, "off");
            }
            if (!zM12974a) {
                this.mCameraUIManager.mo18173b(str, "on", "auto");
            } else {
                this.mCameraUIManager.mo18173b(str, "auto");
            }
            this.mCameraUIManager.m19830cg();
            return;
        }
        this.mModeManager.m12134v(false);
        if (!zM12974a) {
            this.mCameraUIManager.mo18103a(str, "on", "auto");
        } else {
            this.mCameraUIManager.mo18103a(str, "auto");
        }
        this.mCameraUIManager.mo18171b(str, (String) null);
        m9770b(m10279aO(), true);
    }

    /* renamed from: F */
    private float m9598F(boolean z) {
        boolean z2 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        boolean zMo19881dY = this.mCameraUIManager != null ? this.mCameraUIManager.mo19881dY() : false;
        if (!z) {
            return zMo19881dY ? 0.112f : 0.915f;
        }
        if (zMo19881dY || !z2) {
            return zMo19881dY ? 0.105f : 0.14f;
        }
        return 0.86f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9770b(final float COUIBaseListPopupWindow_12, boolean z) {
        if (this.f10753ai || this.f10849ca == null || this.mModeManager == null) {
            return;
        }
        if (this.mModeManager.isSatOpen() || this.mModeManager.m11872ag()) {
            this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.70
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    if (CameraManager.this.mModeManager.m12082h()) {
                        str = CameraUIInterface.KEY_FLASH_MODE;
                    } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM)) {
                        return;
                    } else {
                        str = CameraUIInterface.KEY_VIDEO_FLASH_MODE;
                    }
                    String strM11787S = CameraManager.this.mModeManager.m11787S();
                    if (CameraManager.this.m10115h(COUIBaseListPopupWindow_12)) {
                        CameraManager.this.mModeManager.m12134v(false);
                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                            CameraManager.this.mCameraUIManager.mo18103a(str, "on", "auto");
                        }
                        CameraManager.this.mCameraUIManager.mo18171b(str, (String) null);
                        String strM11787S2 = CameraManager.this.mModeManager.m11787S();
                        if (!"off".equals(strM11787S) || !"off".equals(strM11787S2)) {
                            CameraManager.this.mModeManager.m11827a(strM11787S2, true);
                        }
                    } else {
                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                            if ("on".equals(strM11787S) || "auto".equals(strM11787S)) {
                                CameraManager.this.mModeManager.m12134v(true);
                                CameraManager.this.mModeManager.m11827a("off", true);
                                CameraManager.this.mCameraUIManager.mo18171b(str, "off");
                            } else if (CameraParameter.FlashMode.FLASH_TORCH.equals(strM11787S) && CameraManager.this.mModeManager.m12082h()) {
                                CameraManager.this.mModeManager.m12134v(false);
                                CameraManager.this.mModeManager.m11827a(CameraManager.this.mModeManager.m11787S(), true);
                                CameraManager.this.mCameraUIManager.mo18171b(str, (String) null);
                            }
                            CameraManager.this.mCameraUIManager.mo18173b(str, "on", "auto");
                        } else {
                            if (!"off".equals(strM11787S)) {
                                CameraManager.this.mModeManager.m12134v(true);
                                CameraManager.this.mModeManager.m11827a("off", true);
                            }
                            CameraManager.this.mCameraUIManager.mo18099a(str, "off");
                        }
                        CameraManager.this.mCameraUIManager.mo18022A(false);
                    }
                    CameraManager.this.mCameraUIManager.mo18211f(str);
                }
            });
            return;
        }
        if (z) {
            if ((!m10327b(CameraFunction.SAT_CAMERA) && !m10327b(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) || this.mModeManager.m12013cv() || this.mModeManager.isNoneSatUltraWideAngleOpen() || this.mModeManager.m12006co() || this.mModeManager.m11918bO()) {
                return;
            }
            this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.71
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraManager.this.f10752ah) {
                        return;
                    }
                    String str = !CameraManager.this.mModeManager.m12082h() ? CameraUIInterface.KEY_VIDEO_FLASH_MODE : CameraUIInterface.KEY_FLASH_MODE;
                    CameraManager.this.mModeManager.m12134v(false);
                    if (CameraManager.this.mModeManager.m12082h() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                        CameraManager.this.mCameraUIManager.mo18103a(str, "on", "auto");
                    }
                    CameraManager.this.mCameraUIManager.mo18171b(str, (String) null);
                    CameraManager.this.mModeManager.m11827a(CameraManager.this.mModeManager.m11787S(), true);
                    CameraManager.this.mCameraUIManager.mo18211f(str);
                }
            });
        }
    }

    /* renamed from: aM */
    public void m10277aM() {
        this.f10777bG = false;
        this.f10778bH = false;
        this.f10779bI = true;
        this.f10780bJ = false;
        this.f10781bK = false;
        this.f10782bL = false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m10127j(float COUIBaseListPopupWindow_12) {
        if (this.mModeManager.m12091j(CameraUIInterface.KEY_TELE_SMALL_PREVIEW)) {
            TeleSmallPreviewManager c3431ab = this.f10869cu;
            boolean zM23000a = c3431ab != null ? c3431ab.m23000a(COUIBaseListPopupWindow_12) : false;
            this.f10782bL = zM23000a;
            TeleSmallPreviewManager c3431ab2 = this.f10869cu;
            if (c3431ab2 != null && zM23000a) {
                c3431ab2.m23001b(COUIBaseListPopupWindow_12);
            }
            if (zM23000a && !this.f10777bG) {
                this.f10777bG = true;
                this.f10779bI = true;
                TeleSmallPreviewManager c3431ab3 = this.f10869cu;
                if (c3431ab3 != null) {
                    c3431ab3.m23009e(true);
                    return;
                }
                return;
            }
            if (zM23000a || !this.f10777bG) {
                return;
            }
            this.f10852cd.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.PREVIEW_IN_PREVIEW_ENABLE, (CameraParameter.PreviewKey<String>) "off");
            this.f10852cd.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            this.f10778bH = false;
            this.f10777bG = false;
            this.f10780bJ = false;
            TeleSmallPreviewManager c3431ab4 = this.f10869cu;
            if (c3431ab4 != null) {
                c3431ab4.m23009e(false);
                this.f10869cu.m22998a(false, true, false);
                return;
            }
            return;
        }
        this.f10777bG = false;
        this.f10778bH = false;
        TeleSmallPreviewManager c3431ab5 = this.f10869cu;
        if (c3431ab5 != null) {
            c3431ab5.m22998a(false, true, false);
        }
    }

    /* renamed from: aN */
    public boolean m10278aN() {
        if (this.f10866cr != null) {
            return this.f10866cr.m11528j();
        }
        return false;
    }

    /* renamed from: aO */
    public float m10279aO() {
        FrontCameraZoomManager c2808m;
        if (m10327b(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH) && (c2808m = this.f10863co) != null) {
            return c2808m.m14688d();
        }
        if (this.mCameraUIManager != null && this.mCameraUIManager.mo18051O() && this.mCameraUIManager.mo18053P()) {
            if (!m10354f(this.f10870cv)) {
                this.f10870cv = m10282aR();
            }
            return this.f10870cv;
        }
        if (this.f10866cr != null) {
            return this.f10866cr.m11486a();
        }
        return m10282aR();
    }

    /* renamed from: aP */
    public boolean m10280aP() {
        if (this.f10866cr != null) {
            return this.f10866cr.m11542v();
        }
        return false;
    }

    /* renamed from: aQ */
    public boolean m10281aQ() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
            return true;
        }
        float fM10279aO = m10279aO();
        return this.mModeManager.m11839a(m10343d(fM10279aO), m10350e(fM10279aO));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m10343d(float COUIBaseListPopupWindow_12) {
        if (m10327b(CameraFunction.SAT_CAMERA)) {
            return m10136k(COUIBaseListPopupWindow_12);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m10136k(float COUIBaseListPopupWindow_12) {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_ULTRAWIDE_ZOOM_RANGE);
        return configFloatArrayValue != null && configFloatArrayValue.length == 2 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[0]) >= 0 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[1]) < 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m10350e(float COUIBaseListPopupWindow_12) {
        float[] configFloatArrayValue;
        return m10327b(CameraFunction.SAT_CAMERA) && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_TELE_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[0]) >= 0 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[1]) <= 0;
    }

    /* renamed from: aR */
    public float m10282aR() {
        ModeFacade c3020t = this.f10914dn;
        if (c3020t != null && 32784 == c3020t.m17202d()) {
            return 2.0f;
        }
        if (this.f10853ce == null || this.mModeManager == null) {
            return 1.0f;
        }
        return this.f10853ce.m13263b(this.mModeManager.m12012cu());
    }

    public float getMinZoomValue() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION) || !this.mModeManager.m12012cu().m11355m() || this.f10866cr.m11541u()) {
            return this.f10853ce.m13266c(this.mModeManager.m12012cu());
        }
        return 1.0f;
    }

    /* renamed from: aS */
    public float m10283aS() {
        return this.f10853ce.m13268d(this.mModeManager.m12012cu());
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m10354f(float COUIBaseListPopupWindow_12) {
        return this.f10853ce.m13260a(this.mModeManager.m12012cu(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: com.oplus.camera.CameraManager$OplusGLSurfaceView_11 */
    protected class C2586n {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Vector<C2587o> f11184b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f11185c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f11186d = false;

        protected C2586n() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m11005a() {
            boolean z;
            synchronized (CameraManager.this.f10976l) {
                z = this.f11184b != null && this.f11184b.size() > 0;
            }
            return z;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m11007b() {
            int size;
            synchronized (CameraManager.this.f10976l) {
                size = this.f11184b != null ? this.f11184b.size() : 0;
            }
            return size;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m11009c() {
            boolean z;
            synchronized (CameraManager.this.f10976l) {
                z = this.f11184b != null && this.f11184b.size() > 0 && this.f11185c == 0;
            }
            return z;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m11006a(int OplusGLSurfaceView_13) {
            CameraLog.m12959b("ModeChangeExecutor", "isSwitchCamera, mProperCameraId: " + CameraManager.this.f10990z + ", properCameraId: " + OplusGLSurfaceView_13);
            return CameraManager.this.f10990z != OplusGLSurfaceView_13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: OplusGLSurfaceView_5 */
        public void m11003k() {
            synchronized (CameraManager.this.f10976l) {
                C2587o c2587oM11014h = m11014h();
                if (c2587oM11014h == null) {
                    CameraLog.m12967f("ModeChangeExecutor", "handleOnSessionClosing, firstTask is null ");
                    this.f11185c = 1;
                } else {
                    c2587oM11014h.m11033d();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m11010d() {
            synchronized (CameraManager.this.f10976l) {
                C2587o c2587oM11014h = m11014h();
                if (c2587oM11014h == null) {
                    CameraLog.m12967f("ModeChangeExecutor", "handleOnSessionClosed, firstTask is null ");
                    this.f11185c = 2;
                    return;
                }
                if (c2587oM11014h != null && c2587oM11014h.f11198k != null) {
                    c2587oM11014h.f11198k.closeImageReader();
                }
                c2587oM11014h.m11032c();
                CameraManager.this.f10849ca.runOnUiThread(new Runnable() { // from class: com.oplus.camera.CameraManager.OplusGLSurfaceView_11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C2586n.this.m11012f();
                    }
                });
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m11008b(int OplusGLSurfaceView_13) {
            C2587o c2587oM11014h = m11014h();
            CameraLog.m12959b("ModeChangeExecutor", "handleOnSessionConfigured, cameraRole: " + OplusGLSurfaceView_13 + ", firstTask: " + c2587oM11014h);
            if (c2587oM11014h != null) {
                this.f11186d = c2587oM11014h.f11188a;
                CameraLog.m12959b("ModeChangeExecutor", "handleOnSessionConfigured, mbCurrentHFR: " + this.f11186d);
            }
            if (OplusGLSurfaceView_13 == 1) {
                m11013g();
            }
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m11011e() {
            CameraLog.m12959b("ModeChangeExecutor", "handleOnCameraOpened");
            C2587o c2587oM11014h = m11014h();
            if (c2587oM11014h != null) {
                c2587oM11014h.m11030b();
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public void m11012f() {
            int size;
            int size2;
            CameraManager.this.f10932eF.removeMessages(11);
            C2587o c2587oM11014h = m11014h();
            synchronized (CameraManager.this.f10976l) {
                size = this.f11184b != null ? this.f11184b.size() : 0;
            }
            if (c2587oM11014h != null) {
                CameraLog.m12959b("ModeChangeExecutor", "looperExecuteModeChangeTask, firstTask: " + c2587oM11014h.toString() + ", size: " + size);
                int OplusGLSurfaceView_13 = c2587oM11014h.f11192e;
                if (OplusGLSurfaceView_13 == 0) {
                    c2587oM11014h.m11025a();
                } else if (OplusGLSurfaceView_13 == 2) {
                    if (size > 1) {
                        m11013g();
                        C2587o c2587oM11014h2 = m11014h();
                        if (c2587oM11014h2 != null) {
                            c2587oM11014h2.f11192e = 2;
                            c2587oM11014h2.m11025a();
                        }
                    } else {
                        c2587oM11014h.m11025a();
                    }
                }
            }
            synchronized (CameraManager.this.f10976l) {
                size2 = this.f11184b != null ? this.f11184b.size() : 0;
            }
            CameraLog.m12959b("ModeChangeExecutor", "looperExecuteModeChangeTask, after size : " + size2);
            if (size2 > 0) {
                CameraManager.this.f10932eF.sendEmptyMessageDelayed(11, 100L);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11004a(C2587o c2587o) {
            if (c2587o == null) {
                return;
            }
            synchronized (CameraManager.this.f10976l) {
                if (this.f11184b == null) {
                    this.f11184b = new Vector<>();
                }
                CameraLog.m12959b("ModeChangeExecutor", "addModeChangeTask, task: " + c2587o + ", size: " + this.f11184b.size());
                if (this.f11185c == 1) {
                    c2587o.m11033d();
                } else if (this.f11185c == 2) {
                    c2587o.m11032c();
                }
                if (this.f11184b.size() >= 1) {
                    CameraManager.this.f10813bq = true;
                }
                this.f11185c = 0;
                if (this.f11184b.size() <= 1) {
                    this.f11184b.add(c2587o);
                } else {
                    this.f11184b.removeElementAt(1);
                    this.f11184b.add(c2587o);
                }
            }
            m11012f();
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public void m11013g() {
            synchronized (CameraManager.this.f10976l) {
                if (this.f11184b != null && this.f11184b.size() > 0) {
                    this.f11184b.remove(0);
                    CameraLog.m12959b("ModeChangeExecutor", "popFirstModeChangeTask X ");
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public C2587o m11014h() {
            C2587o c2587o;
            synchronized (CameraManager.this.f10976l) {
                c2587o = (this.f11184b == null || this.f11184b.size() <= 0) ? null : this.f11184b.get(0);
            }
            return c2587o;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public C2587o m11015i() {
            synchronized (CameraManager.this.f10976l) {
                if (this.f11184b == null || this.f11184b.size() <= 0) {
                    return null;
                }
                return this.f11184b.lastElement();
            }
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public void m11016j() {
            CameraLog.m12959b("ModeChangeExecutor", "release");
            synchronized (CameraManager.this.f10976l) {
                if (this.f11184b != null) {
                    this.f11184b.clear();
                }
            }
        }
    }

    /* renamed from: com.oplus.camera.CameraManager$o */
    protected class C2587o {

        /* renamed from: PlatformImplementations.kt_3 */
        protected boolean f11188a = false;

        /* renamed from: IntrinsicsJvm.kt_4 */
        protected BaseMode f11189b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected String f11190c = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f11192e = 0;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private String f11193f = null;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f11194g = 0;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f11195h = 0;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f11196i = 0;

        /* renamed from: OplusGLSurfaceView_15 */
        private boolean f11197j = false;

        /* renamed from: OplusGLSurfaceView_5 */
        private BaseMode f11198k = null;

        protected C2587o() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11025a() {
            CameraLog.m12959b("ModeChangeTask", "execute task: " + toString());
            int OplusGLSurfaceView_13 = this.f11192e;
            if (OplusGLSurfaceView_13 == 0) {
                this.f11192e = 1;
                CameraLog.m12959b("ModeChangeTask", "execute, send closeCaptureSession");
                CameraManager.this.m10308ar();
                CameraLog.m12952a("ModeChangeTaskDelay");
                return;
            }
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            CameraLog.m12958b("closeSession");
            CameraLog.m12959b("ModeChangeTask", "execute, STATUS_SESSION_CLOSED after mOneCamera.endOfStream X, mAfterModeProperCameraId: " + this.f11195h);
            if ((CameraManager.this.f10913dm != null && CameraManager.this.f10913dm.m11006a(this.f11195h)) || (((OneCameraProxy) CameraManager.this.f10852cd).m13224D() != null && ((OneCameraProxy) CameraManager.this.f10852cd).m13224D().m12153c())) {
                CameraManager.this.f10703K = 3;
                CameraLog.m12959b("ModeChangeTask", "execute, openCamera");
                this.f11192e = 4;
                CameraManager.this.m10374l(3);
                return;
            }
            this.f11192e = 3;
            CameraLog.m12959b("ModeChangeTask", "execute, STATUS_SESSION_CLOSED createCaptureSession");
            CameraManager cameraManager = CameraManager.this;
            cameraManager.f10853ce = cameraManager.m10166r(cameraManager.f10852cd.mo13075c());
            CameraManager.this.f10852cd.mo13037a(CameraManager.this.f10853ce);
            CameraManager.this.m10378n(1);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m11030b() {
            CameraLog.m12959b("ModeChangeTask", "handleOnCameraOpened mStatus: " + this.f11192e);
            if (this.f11192e == 4) {
                this.f11192e = 5;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m11032c() {
            CameraLog.m12959b("ModeChangeTask", "handleOnSessionClosed mStatus: " + this.f11192e);
            this.f11192e = 2;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m11033d() {
            CameraLog.m12959b("ModeChangeTask", "handleOnSessionClosing mStatus: " + this.f11192e);
            this.f11192e = 1;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public C2587o m11023a(String str) {
            this.f11193f = str;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public C2587o m11028b(String str) {
            this.f11190c = str;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public C2587o m11021a(int OplusGLSurfaceView_13) {
            this.f11194g = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public C2587o m11026b(int OplusGLSurfaceView_13) {
            this.f11195h = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public C2587o m11031c(int OplusGLSurfaceView_13) {
            this.f11196i = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public C2587o m11024a(boolean z) {
            this.f11197j = z;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public C2587o m11029b(boolean z) {
            this.f11188a = z;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public C2587o m11022a(BaseMode baseMode) {
            synchronized (CameraManager.this.f10914dn) {
                this.f11189b = baseMode;
            }
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public C2587o m11027b(BaseMode baseMode) {
            this.f11198k = baseMode;
            return this;
        }

        public String toString() {
            return "mStatus: " + this.f11192e + ", mBeforeModeName: " + this.f11193f + ", mAfterModeName: " + this.f11190c + ", mBeforeModeProperCameraId: " + this.f11194g + ", mAfterModeProperCameraId: " + this.f11195h + ", mbBeforeHFR: " + this.f11197j + " ,mbAfterHFR : " + this.f11188a + ", mBeforeOperatingMode: " + this.f11196i;
        }
    }

    /* renamed from: x */
    public void m10400x(boolean z) {
        this.f10805bi = z;
        CameraLog.m12959b("CameraManager", "setExitCameraToSetting, mbSettingClickCausedPause: " + this.f10805bi + " > " + z);
    }

    /* renamed from: aT */
    public boolean m10284aT() {
        return m10228Z() || this.f10805bi || !this.f10814br;
    }

    /* renamed from: dg */
    private void m10051dg() {
        if (this.mModeManager != null) {
            this.mModeManager.m11818a(this.f10852cd);
            this.mModeManager.m12089j(false);
            this.mModeManager.m12100m();
        }
    }

    /* renamed from: dh */
    private void m10053dh() {
        FrontCameraZoomManager c2808m;
        CameraLog.m12959b("CameraManager", "restoreAppConfig");
        m10057dj();
        SharedPreferences sharedPreferencesM11072a = this.f10850cb.m11072a(this.f10849ca, 1);
        SharedPreferences sharedPreferencesM11072a2 = this.f10850cb.m11072a(this.f10849ca, 0);
        SharedPreferences.Editor editorEdit = this.f10850cb.edit();
        SharedPreferences.Editor editorEdit2 = sharedPreferencesM11072a.edit();
        SharedPreferences.Editor editorEdit3 = sharedPreferencesM11072a2.edit();
        if ("standard".equals(this.f10850cb.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard"))) {
            editorEdit.remove(CameraUIInterface.KEY_LAST_MACRO_SWITCH);
            editorEdit.remove(CameraUIInterface.KEY_MACRO_SWITCH);
        }
        editorEdit.putBoolean(CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS, true);
        editorEdit.putBoolean(CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS, true);
        editorEdit.putBoolean(CameraUIInterface.KEY_RESTORE_LONG_EXPOSURE_PARAMS, true);
        editorEdit.remove(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER);
        editorEdit.remove(CameraUIInterface.KEY_SWITCH_CAMERA);
        editorEdit.remove(CameraUIInterface.KEY_CAMERA_ID);
        editorEdit.remove(CameraUIInterface.KEY_ZOOM);
        editorEdit.remove(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL);
        editorEdit.remove(CameraUIInterface.KEY_ZOOM_FROM_OTHER_APP);
        boolean z = this.f10846cX.m13333a() && this.mModeManager.m12057dq();
        m10359g(true);
        this.f10850cb.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, z ? "on" : "off").apply();
        sharedPreferencesM11072a2.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
        sharedPreferencesM11072a.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
        m10359g(false);
        editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
        editorEdit.putString(CameraUIInterface.KEY_RAW_CONTROL, this.f10849ca.getString(R.string.camera_raw_control_off));
        editorEdit.putString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, this.f10849ca.getString(R.string.camera_raw_control_off));
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU);
        editorEdit.remove(CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE);
        editorEdit.remove(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX);
        editorEdit.remove(CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION);
        m9672a(sharedPreferencesM11072a, false);
        m9672a(sharedPreferencesM11072a2, false);
        editorEdit2.putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "auto");
        editorEdit2.putString(CameraUIInterface.KEY_TIME_LAPSE_RATE, this.f10849ca.getString(R.string.camera_time_lapse_speed_default_value));
        editorEdit3.remove(CameraUIInterface.KEY_FILM_MODE_ISO);
        editorEdit3.remove(CameraUIInterface.KEY_FILM_MODE_SHUTTER);
        editorEdit3.remove(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE);
        editorEdit3.remove(CameraUIInterface.KEY_FILM_MODE_FOCUS);
        editorEdit3.remove(CameraUIInterface.KEY_FILM_MODE_EXPOSURE);
        editorEdit3.remove(CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT);
        editorEdit3.remove(CameraUIInterface.KEY_SWITCH_CAMERA_BAR);
        editorEdit3.remove(CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR);
        editorEdit3.putString(CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on");
        editorEdit3.putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "auto");
        editorEdit3.putString(CameraUIInterface.KEY_TIME_LAPSE_RATE, this.f10849ca.getString(R.string.camera_time_lapse_speed_default_value));
        editorEdit3.putString(CameraUIInterface.KEY_VIDEO_HDR, this.f10849ca.getResources().getString(R.string.camera_video_hdr_default_value));
        editorEdit3.putString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, this.f10849ca.getResources().getString(R.string.camera_ultra_night_video_default_value));
        editorEdit3.remove(CameraUIInterface.KEY_TILT_SHIFT_TYPE);
        editorEdit3.remove(CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU_INDEX);
        editorEdit3.remove(CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE);
        editorEdit3.remove(CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE);
        editorEdit.remove(CameraUIInterface.KEY_NIGHT_PRO_MODE);
        editorEdit.putBoolean(CameraUIInterface.KEY_RESTORE_NIGHT_PRO_PARAMS, true);
        editorEdit.remove(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE);
        editorEdit.putBoolean(CameraUIInterface.KEY_RESTORE_HIGH_PICTURE_PRO_PARAMS, true);
        if (m9786b(sharedPreferencesM11072a)) {
            editorEdit2.remove(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
        if (m9704a(sharedPreferencesM11072a2)) {
            editorEdit3.remove(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
        editorEdit2.apply();
        m10359g(true);
        editorEdit3.apply();
        m10359g(false);
        editorEdit.apply();
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            ((OneCameraProxy) interfaceC2694d).m13224D().m12155d();
        }
        if (this.mCameraUIManager != null) {
            this.mCameraUIManager.m19952ez();
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM) || (c2808m = this.f10863co) == null) {
            return;
        }
        c2808m.m14685b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m9704a(SharedPreferences sharedPreferences) throws NumberFormatException {
        String string = sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, 0));
        int OplusGLSurfaceView_13 = Integer.parseInt(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS));
        return "off".equals(Util.m24438e(false)) || (Util.m24397b(CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION), string) && 30 == OplusGLSurfaceView_13) || (m10327b(CameraFunction.AI_ENHANCEMENT_VIDEO) && "video_size_1080p".equals(string) && 30 == OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m9786b(SharedPreferences sharedPreferences) throws NumberFormatException {
        String string = sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, 1));
        int OplusGLSurfaceView_13 = Integer.parseInt(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS));
        String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION);
        if ("off".equals(Util.m24438e(true))) {
            return true;
        }
        if (Util.m24397b(configStringArrayValue, string) && 30 == OplusGLSurfaceView_13) {
            return true;
        }
        return m10327b(CameraFunction.AI_ENHANCEMENT_VIDEO) && "video_size_1080p".equals(string) && 30 == OplusGLSurfaceView_13;
    }

    /* renamed from: di */
    private void m10056di() {
        boolean configBooleanValue = false;
        if (CameraMotorManager.m13703a((Context) this.f10849ca).m13713c()) {
            if (this.f10747ac) {
                configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MOTOR_FLASHLIGHT);
            } else if (CameraMotorManager.m13703a((Context) this.f10849ca).m13712b() || CameraMotorManager.m13703a((Context) this.f10849ca).m13709a()) {
                configBooleanValue = true;
            }
        }
        CameraLog.m12954a("CameraManager", "setFlashAndTorchOffIfMotorFlash, motorFlash: " + configBooleanValue);
        if (configBooleanValue) {
            m10057dj();
        }
    }

    /* renamed from: dj */
    private void m10057dj() {
        if (this.f10849ca == null || this.f10850cb == null) {
            return;
        }
        if (this.f10747ac) {
            if (m9906c(this.f10850cb) && this.mCameraUIManager != null) {
                if (!this.mCameraUIManager.m19759bS()) {
                    this.mCameraUIManager.mo18213f(true, false);
                }
                this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_TORCH_MODE);
            }
            m10023d(this.f10850cb.m11072a(this.f10849ca, 0));
            return;
        }
        if (m10023d(this.f10850cb) && this.mCameraUIManager != null) {
            if (!this.mCameraUIManager.m19759bS()) {
                this.mCameraUIManager.mo18213f(true, false);
            }
            this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
            this.mCameraUIManager.mo18211f(CameraUIInterface.KEY_VIDEO_FLASH_MODE);
        }
        m9906c(this.f10850cb.m11072a(this.f10849ca, 1));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m9906c(SharedPreferences sharedPreferences) {
        CameraLog.m12954a("CameraManager", "applyTorchModeDefault");
        String strM24174F = Util.m24174F(this.f10849ca);
        if (strM24174F.equals(sharedPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, strM24174F))) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_TORCH_MODE, strM24174F);
        editorEdit.apply();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m10023d(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit;
        CameraLog.m12954a("CameraManager", "applyFlashModeOff");
        if ("off".equals(sharedPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, "off"))) {
            editorEdit = null;
        } else {
            editorEdit = sharedPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
        }
        if (!"off".equals(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off"))) {
            if (editorEdit == null) {
                editorEdit = sharedPreferences.edit();
            }
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off");
        }
        if (!"off".equals(sharedPreferences.getString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off"))) {
            editorEdit = sharedPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off");
        }
        if (editorEdit == null) {
            return false;
        }
        editorEdit.apply();
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m10091e(SharedPreferences sharedPreferences) {
        CameraLog.m12954a("CameraManager", "applyTorchModeOff");
        if ("off".equals(sharedPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, "off"))) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_TORCH_MODE, "off");
        editorEdit.apply();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m10158p(String str) {
        if (this.mModeManager != null) {
            SwitchCameraMsgData switchCameraMsgData = new SwitchCameraMsgData(this.f10849ca);
            switchCameraMsgData.mCameraId = m10285aU();
            switchCameraMsgData.mCaptureMode = this.mModeManager.m12105n();
            switchCameraMsgData.mOrientation = this.f10984t;
            switchCameraMsgData.mScreenBrightness = Settings.System.getInt(this.f10849ca.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.f10981q * 0.4f));
            switchCameraMsgData.mToCaptureMode = this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_MODE, "");
            switchCameraMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            switchCameraMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            switchCameraMsgData.mOperType = str;
            switchCameraMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            switchCameraMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m9601G(boolean z) {
        if (this.mModeManager != null) {
            SwitchCameraMsgData switchCameraMsgData = new SwitchCameraMsgData(this.f10849ca);
            switchCameraMsgData.mCaptureMode = z ? this.mModeManager.m12105n() : "smartRecogni";
            switchCameraMsgData.mToCaptureMode = z ? "smartRecogni" : this.mModeManager.m12105n();
            switchCameraMsgData.mCameraId = m10285aU();
            switchCameraMsgData.mOrientation = this.f10984t;
            switchCameraMsgData.mOperType = "1";
            switchCameraMsgData.mScreenBrightness = Settings.System.getInt(this.f10849ca.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.f10981q * 0.4f));
            switchCameraMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            switchCameraMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dk */
    public void m10059dk() {
        String strM9797bC = m9797bC();
        if ((!TextUtils.isEmpty(strM9797bC) || this.mModeManager.m12012cu().m11371u()) && this.mModeManager != null) {
            FocusAimMsgData focusAimMsgData = new FocusAimMsgData(this.f10849ca);
            focusAimMsgData.mCameraId = m10285aU();
            focusAimMsgData.mCaptureMode = this.mModeManager.m12105n();
            focusAimMsgData.mOrientation = this.f10984t;
            boolean z = true;
            focusAimMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            focusAimMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            focusAimMsgData.mbVideoRecording = m10269aE();
            focusAimMsgData.mTouchXY = strM9797bC;
            if (!this.f10747ac) {
                if (2 != this.f10755ak && !m10396v()) {
                    z = false;
                }
                focusAimMsgData.mAeAfLock = String.valueOf(z);
            }
            focusAimMsgData.mTouchEV = String.valueOf(this.f10699G);
            if (this.mModeManager.m12012cu().m11371u()) {
                if (this.mCameraUIManager != null) {
                    focusAimMsgData.mHyperLapseFocusViewXY = this.mCameraUIManager.mo18285y();
                }
                if (!TextUtils.isEmpty(focusAimMsgData.mHyperLapseFocusViewXY)) {
                    focusAimMsgData.mActType = "4";
                }
            }
            focusAimMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            focusAimMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m10164q(String str) {
        String strM9797bC = m9797bC();
        String strM9799bD = m9799bD();
        if ((!TextUtils.isEmpty(strM9797bC) || this.mModeManager.m12012cu().m11371u() || m10268aD()) && this.mModeManager != null) {
            FocusAimMsgData focusAimMsgData = new FocusAimMsgData(this.f10849ca);
            focusAimMsgData.mCameraId = m10285aU();
            focusAimMsgData.mCaptureMode = this.mModeManager.m12105n();
            focusAimMsgData.mOrientation = this.f10984t;
            focusAimMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            focusAimMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            focusAimMsgData.mbVideoRecording = m10269aE();
            if (TextUtils.isEmpty(strM9799bD)) {
                focusAimMsgData.mTouchXY = strM9797bC;
            } else {
                focusAimMsgData.mTouchXY = strM9799bD;
                focusAimMsgData.mTouchEVXY = strM9797bC;
            }
            if (!this.f10747ac) {
                focusAimMsgData.mAeAfLock = String.valueOf(2 == this.f10755ak || m10396v());
            }
            focusAimMsgData.mTouchEV = String.valueOf(this.f10699G);
            if (this.mModeManager.m12012cu().m11371u()) {
                if (this.mCameraUIManager != null) {
                    focusAimMsgData.mHyperLapseFocusViewXY = this.mCameraUIManager.mo18285y();
                }
                if (!TextUtils.isEmpty(focusAimMsgData.mHyperLapseFocusViewXY)) {
                    focusAimMsgData.mActType = "4";
                }
            }
            focusAimMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            if (!str.isEmpty()) {
                if ("on".equals(this.f10850cb.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.f10849ca.getString(R.string.camera_tap_shutter_default_value))) && !str.equals("2")) {
                    focusAimMsgData.mActType = FocusAimMsgData.KEY_TOUCH_TAKE_PICTURE;
                } else {
                    focusAimMsgData.mActType = str;
                }
            }
            if (m10268aD()) {
                int OplusGLSurfaceView_13 = this.f10850cb.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
                if (this.mCameraUIManager != null && OplusGLSurfaceView_13 != 0) {
                    focusAimMsgData.mSubScreenValue = String.valueOf(this.mCameraUIManager.mo18162az());
                }
            }
            if (!TextUtils.isEmpty(focusAimMsgData.mCaptureMode) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && ApsConstant.CAPTURE_MODE_COMMON.equals(focusAimMsgData.mCaptureMode) && this.mModeManager.m12143z()) {
                focusAimMsgData.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
                focusAimMsgData.mCaptureType = 1;
            }
            focusAimMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9698a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mModeManager != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f10849ca);
            menuClickMsgData.mCaptureMode = this.mModeManager.m12105n();
            menuClickMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            menuClickMsgData.mCameraId = m10285aU();
            menuClickMsgData.mOrientation = this.f10984t;
            menuClickMsgData.buildMenuClick(this.f10850cb, str, z, z2, z3, z4, this.mModeManager.m11871af());
            menuClickMsgData.mbVideoRecording = m10269aE();
            if (CameraUIInterface.KEY_PHOTO_RATIO.equals(str) && m10327b(CameraUIInterface.KEY_STICKER_PROCESS) && DcsMsgData.FULL.equals(menuClickMsgData.mItemValue)) {
                menuClickMsgData.mItemValue = this.mModeManager.m11869ad();
            }
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            if (!TextUtils.isEmpty(menuClickMsgData.mCaptureMode) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && ApsConstant.CAPTURE_MODE_COMMON.equals(menuClickMsgData.mCaptureMode) && this.mModeManager.m12143z()) {
                menuClickMsgData.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
                menuClickMsgData.mCaptureType = 1;
            }
            if (Util.m24495t() && CameraUIInterface.KEY_PHOTO_RATIO.equals(str) && DcsMsgData.FULL.equals(menuClickMsgData.mItemValue)) {
                if (Util.m24451g() == 0) {
                    menuClickMsgData.mItemValue = "second_full";
                } else if (1 == Util.m24451g()) {
                    menuClickMsgData.mItemValue = "15_14";
                }
            }
            menuClickMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m10169r(String str) {
        if (this.mModeManager != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f10849ca);
            menuClickMsgData.mCaptureMode = this.mModeManager.m12105n();
            menuClickMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            menuClickMsgData.mCameraId = m10285aU();
            menuClickMsgData.mOrientation = this.f10984t;
            menuClickMsgData.mbVideoRecording = m10269aE();
            int iM10304an = this.f10990z;
            if (-1 == iM10304an) {
                iM10304an = m10304an();
            }
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(iM10304an) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            if (!TextUtils.isEmpty(menuClickMsgData.mCaptureMode) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && ApsConstant.CAPTURE_MODE_COMMON.equals(menuClickMsgData.mCaptureMode) && this.mModeManager.m12143z()) {
                menuClickMsgData.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
                menuClickMsgData.mCaptureType = 1;
            }
            menuClickMsgData.buildMenuItem(str, this.f10850cb, this.f10989y);
            menuClickMsgData.report();
        }
    }

    /* renamed from: aU */
    public int m10285aU() {
        if (this.mModeManager == null || this.f10850cb == null || !this.mModeManager.m11982cQ()) {
            return this.f10990z;
        }
        return 1 == this.f10850cb.getInt(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9771b(int OplusGLSurfaceView_13, boolean z) {
        if (this.mModeManager != null) {
            ReminderMsgData reminderMsgData = new ReminderMsgData(this.f10849ca, this.mModeManager.m12082h());
            reminderMsgData.mCaptureMode = this.mModeManager.m12105n();
            reminderMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            reminderMsgData.mCameraId = m10285aU();
            reminderMsgData.mOrientation = this.f10984t;
            reminderMsgData.mReminderAIScene = String.valueOf(OplusGLSurfaceView_13);
            reminderMsgData.mReminderAILabelSwitch = z ? "on" : "off";
            reminderMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            reminderMsgData.buildAISceneItem();
            reminderMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m9901c(int OplusGLSurfaceView_13, boolean z) {
        if (this.mModeManager != null) {
            ReminderMsgData reminderMsgData = new ReminderMsgData(this.f10849ca, this.mModeManager.m12082h());
            reminderMsgData.mCaptureMode = this.mModeManager.m12105n();
            reminderMsgData.mCameraId = m10285aU();
            if (OplusGLSurfaceView_13 == 0) {
                reminderMsgData.mReminderAISuperTextSwitch = z ? "on" : "off";
            } else if (OplusGLSurfaceView_13 == 1) {
                reminderMsgData.mReminderAIUltraWideSwitch = z ? "on" : "off";
            }
            reminderMsgData.buildAISceneItem();
            reminderMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m9605H(boolean z) {
        if (this.mModeManager != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f10849ca);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = 1;
            menuClickMsgData.mCaptureMode = this.mModeManager.m12105n();
            menuClickMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            menuClickMsgData.mCameraId = m10285aU();
            menuClickMsgData.mOrientation = this.f10984t;
            menuClickMsgData.mbVideoRecording = m10269aE();
            menuClickMsgData.mFuncKeyResult = z ? 1 : 2;
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    /* renamed from: dl */
    private void m10061dl() {
        if (this.mModeManager != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f10849ca);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = 6;
            menuClickMsgData.mCaptureMode = this.mModeManager.m12105n();
            menuClickMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            menuClickMsgData.mCameraId = m10285aU();
            menuClickMsgData.mOrientation = this.f10984t;
            menuClickMsgData.mbVideoRecording = m10269aE();
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    /* renamed from: dm */
    private void m10064dm() {
        if (this.mModeManager != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f10849ca);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = 5;
            menuClickMsgData.mCaptureMode = this.mModeManager.m12105n();
            menuClickMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            menuClickMsgData.mCameraId = m10285aU();
            menuClickMsgData.mOrientation = this.f10984t;
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    /* renamed from: I */
    private void m9608I(boolean z) {
        if (z && this.mModeManager != null) {
            PreviewStaticInfoMsgData previewStaticInfoMsgData = new PreviewStaticInfoMsgData(this.f10849ca);
            previewStaticInfoMsgData.mCaptureMode = this.mModeManager.m12105n();
            previewStaticInfoMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            if (this.mModeManager.m12091j(CameraUIInterface.KEY_STICKER_PROCESS)) {
                previewStaticInfoMsgData.mStickerCount = ImageStickerTools.m22687b(this.f10849ca).m22707a().intValue();
            }
            previewStaticInfoMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            previewStaticInfoMsgData.mCameraId = m10285aU();
            previewStaticInfoMsgData.mOrientation = this.f10984t;
            previewStaticInfoMsgData.mScreenBrightness = Settings.System.getInt(this.f10849ca.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.f10981q * 0.4f));
            previewStaticInfoMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            previewStaticInfoMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9783b(Storage.CameraPicture cameraPicture) {
        CaptureMsgData captureMsgData;
        if (cameraPicture == null || (captureMsgData = this.f10789bS) == null) {
            return;
        }
        captureMsgData.mCaptureMode = this.mModeManager.m12105n();
        this.f10789bS.mCameraId = m10285aU();
        this.f10789bS.mOrientation = this.f10984t;
        this.f10789bS = (CaptureMsgData) this.mModeManager.m11802a(this.f10789bS, cameraPicture);
        this.f10789bS.mFilePath = CaptureMsgDataReportUtil.m11164a(cameraPicture);
        this.f10789bS.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f10990z) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        this.f10789bS.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m9610J(boolean z) {
        if (this.f10865cq != null) {
            this.f10865cq.m23698k(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m9592D(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0 || this.f10789bS == null || this.mModeManager == null) {
            return;
        }
        this.f10789bS.mCaptureMode = this.mModeManager.m12105n();
        this.f10789bS.mCameraId = m10285aU();
        CaptureMsgData captureMsgData = this.f10789bS;
        captureMsgData.mOrientation = this.f10984t;
        captureMsgData.mBurstCount = OplusGLSurfaceView_13;
        captureMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9697a(String str, String str2) {
        if (this.mModeManager != null) {
            ReminderMsgData reminderMsgData = new ReminderMsgData(this.f10849ca, this.mModeManager.m12082h());
            reminderMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            reminderMsgData.mCaptureMode = this.mModeManager.m12105n();
            reminderMsgData.mCaptureType = !this.mModeManager.m12082h() ? 1 : 0;
            reminderMsgData.mCameraId = m10285aU();
            reminderMsgData.mOrientation = this.f10984t;
            reminderMsgData.mReminderTypeValue = str;
            reminderMsgData.mReminderCodeValue = str2;
            if (ReminderMsgData.CODE_TEMPS_FLASH.equals(str2)) {
                reminderMsgData.mReminderTriggerValue = this.f10845cW ? ReminderMsgData.CODE_CHARGE_TRUE : ReminderMsgData.CODE_CHARGE_FALSE;
            } else {
                reminderMsgData.mReminderTriggerValue = "";
            }
            reminderMsgData.mRearOrFront = this.f10747ac ? DcsMsgData.FRONT : DcsMsgData.REAR;
            reminderMsgData.report();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10241a(CaptureResult captureResult) {
        PreviewEffectProcess interfaceC3423t;
        PreviewEffectProcess interfaceC3423t2;
        long jLongValue = ((Long) captureResult.get(CaptureResult.SENSOR_TIMESTAMP)).longValue();
        int[] iArrMo13061a = this.f10852cd.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13249O, captureResult);
        byte[] bArrM9710a = iArrMo13061a != null ? m9710a(iArrMo13061a, jLongValue) : null;
        if (m10327b(CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
            byte[] bArrM9710a2 = m9710a(this.f10852cd.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13250P, captureResult), jLongValue);
            if (bArrM9710a != null && bArrM9710a2 != null && (interfaceC3423t2 = this.f10864cp) != null) {
                interfaceC3423t2.mo22806a(bArrM9710a, bArrM9710a2, 0, 0, 4);
                return;
            }
        }
        if (bArrM9710a == null || (interfaceC3423t = this.f10864cp) == null) {
            return;
        }
        interfaceC3423t.mo22805a(bArrM9710a, 0, 0, 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private byte[] m9710a(int[] iArr, long OplusGLSurfaceView_15) {
        if (iArr == null) {
            return null;
        }
        byte[] bArr = new byte[(iArr.length * Util.f22998f) + Util.f22999g];
        byte[] bArrM24422c = Util.m24422c(OplusGLSurfaceView_15);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < Util.f22999g; OplusGLSurfaceView_13++) {
            bArr[OplusGLSurfaceView_13] = bArrM24422c[OplusGLSurfaceView_13];
        }
        byte[] bArrM24303a = new byte[Util.f22998f];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            bArrM24303a = Util.m24303a(iArr[i2], bArrM24303a);
            for (int i3 = 0; i3 < Util.f22998f; i3++) {
                bArr[Util.f22999g + (Util.f22998f * i2) + i3] = bArrM24303a[i3];
            }
        }
        return bArr;
    }

    /* renamed from: dn */
    private boolean m10066dn() throws PackageManager.NameNotFoundException {
        try {
            String callingPackage = this.f10849ca.getCallingPackage();
            new Intent("android.intent.action.MAIN", (Uri) null).addCategory("android.intent.category.LAUNCHER");
            PackageManager packageManager = this.f10849ca.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(callingPackage, 4096);
            if (packageInfo != null) {
                return packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageInfo.packageName) == 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: y */
    public void m10402y(boolean z) {
        this.f10820bx = z;
    }

    /* renamed from: aV */
    public void m10286aV() {
        CameraLog.m12954a("CameraManager", "resetAPSDecisionPreviewFrameCount");
        synchronized (this.f10978n) {
            this.f10882dH = 3;
        }
    }

    /* renamed from: aW */
    public CameraPermission.IntrinsicsJvm.kt_4 m10287aW() {
        return new CameraPermission.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.CameraManager.72
            @Override // com.oplus.camera.CameraPermission.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo10927a() {
                if (CameraManager.this.mCameraUIManager == null || CameraManager.this.m10289aY()) {
                    return;
                }
                CameraLog.m12959b("CameraManager", "onStartFacePointAnimation");
                CameraManager.this.mCameraUIManager.m19822cY();
            }
        };
    }

    /* renamed from: aX */
    public CameraPermission.PlatformImplementations.kt_3 m10288aX() {
        return new CameraPermission.PlatformImplementations.kt_3() { // from class: com.oplus.camera.CameraManager.73
            @Override // com.oplus.camera.CameraPermission.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo10929a(boolean z) {
                CameraManager.this.f10951ed = z;
                if (CameraManager.this.mCameraUIManager != null) {
                    CameraManager.this.mCameraUIManager.m19718aq(z);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
            @Override // com.oplus.camera.CameraPermission.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void mo10928a() {
                /*
                    Method dump skipped, instructions count: 340
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.CameraManager.C256773.mo10928a():void");
            }

            @Override // com.oplus.camera.CameraPermission.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo10930b() {
                CameraManager.this.m10067do();
            }

            @Override // com.oplus.camera.CameraPermission.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo10931b(boolean z) {
                CameraManager.this.f10952ee = z;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do */
    public void m10067do() {
        if (this.f10809bm) {
            return;
        }
        if (!this.f10856ch.mo9569o()) {
            CameraLog.m12967f("CameraManager", "onDisagreeEnter, openCamera failed! permission missing.");
            return;
        }
        this.f10731aM = this.f10846cX.m13359w() && this.mModeManager.m11930ba();
        m10392t(this.f10731aM);
        m9857bh();
        if (!m10374l(0) && this.f10852cd != null) {
            CameraLog.m12966e("CameraManager", "onDisagreeEnter, not opened, just update surface texture.");
            this.mCameraUIManager.m19739b(this.f10914dn.m17187a(this.f10853ce));
        }
        m10298ah();
    }

    /* renamed from: aY */
    public boolean m10289aY() {
        return (this.f10849ca == null || !Util.m24504x(this.f10849ca) || this.f10850cb == null || !"on".equals(this.f10850cb.getString(CameraUIInterface.KEY_RECORD_LOCATION, "on")) || this.f10856ch == null || this.f10856ch.mo9572r()) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10251a(Runnable runnable, long OplusGLSurfaceView_15) {
        Handler handler = this.f10841cS;
        if (handler != null) {
            handler.postDelayed(runnable, OplusGLSurfaceView_15);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m10250a(Runnable runnable) {
        Handler handler = this.f10841cS;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    /* renamed from: dp */
    private boolean m10069dp() {
        if (this.mModeManager != null) {
            return this.mModeManager.m12064dx();
        }
        return true;
    }

    /* renamed from: aZ */
    public void m10290aZ() {
        if (this.f10954eg.m16297b()) {
            CameraLog.m12954a("CameraManager", "onInteractEffectively, will not respond to shell rise.");
            this.f10954eg.m16296b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m10174s(String str) {
        if (this.mModeManager != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f10849ca);
            menuClickMsgData.buildEvent(true);
            menuClickMsgData.mFuncKeyId = 1;
            menuClickMsgData.mItem = str;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.f10846cX.m13317J());
            menuClickMsgData.mCameraId = m10285aU();
            menuClickMsgData.mOrientation = this.f10984t;
            menuClickMsgData.mbVideoRecording = m10269aE();
            int iM10304an = this.f10990z;
            if (-1 == iM10304an) {
                iM10304an = m10304an();
            }
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(iM10304an) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            if (!TextUtils.isEmpty(menuClickMsgData.mCaptureMode) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && ApsConstant.CAPTURE_MODE_COMMON.equals(menuClickMsgData.mCaptureMode) && this.mModeManager.m12143z()) {
                menuClickMsgData.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
                menuClickMsgData.mCaptureType = 1;
            }
            if ("save".equals(str)) {
                menuClickMsgData.mItemValue = "ext_mode_order:" + Util.getModeNameByRank("position_headline").toString() + ";more_mode_order:" + Util.getModeNameByRank("position_mode_panel").toString();
            }
            menuClickMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9699a(boolean z, final int OplusGLSurfaceView_13, final boolean z2) {
        if (!z) {
            final boolean zEquals = "position_headline".equals(DataBaseOperator.m21777a().m21781a(OplusGLSurfaceView_13).m21910c());
            ScreenModeManager c2953g = this.f10890dP;
            boolean z3 = c2953g != null && 1 == c2953g.mo16411a().mo16539j();
            int i2 = zEquals ? 0 : 4;
            int i3 = (zEquals || z3) ? 1 : 3;
            if (!zEquals) {
                this.mCameraUIManager.m19974o(ModeInfo.m21914a(this.f10849ca, OplusGLSurfaceView_13));
                if (z3) {
                    this.mCameraUIManager.m19736b(true, 0);
                } else {
                    this.mCameraUIManager.m19897do();
                }
            }
            this.mCameraUIManager.m19659a(i2, 0L, 0L, (TimeInterpolator) null, new Animator.AnimatorListener() { // from class: com.oplus.camera.CameraManager.74
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (zEquals) {
                        CameraManager.this.mCameraUIManager.m19989y(CameraManager.this.f10849ca.getString(HeadlineHelper.m20344a(HeadlineHelper.m20351d(OplusGLSurfaceView_13))));
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CameraManager.this.m9785b(zEquals, OplusGLSurfaceView_13, z2);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    CameraManager.this.m9785b(zEquals, OplusGLSurfaceView_13, z2);
                }
            }, i3);
            return;
        }
        this.mCameraUIManager.m19723av(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9785b(boolean z, int OplusGLSurfaceView_13, boolean z2) {
        if (!z) {
            this.mCameraUIManager.m19723av(false);
            this.mCameraUIManager.m19866dJ();
            this.mCameraUIManager.m19853d(true, -1);
            if (z2) {
                m9701a(true, true, -1);
            }
        }
        PreferenceManager.m3981a(this.f10849ca).edit().putBoolean("mode_arrange_change_panel", false).apply();
    }

    public static class CameraTansBitmapBinder extends ICameraTransBitmap.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        public HashMap<String, Bitmap> f11147a = new HashMap<>();

        /* renamed from: PlatformImplementations.kt_3 */
        public void m10935a(String str, Bitmap bitmap) {
            m10934a();
            this.f11147a.put(str, bitmap);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m10934a() {
            HashMap<String, Bitmap> map = this.f11147a;
            if (map == null || map.isEmpty()) {
                return;
            }
            for (Bitmap bitmap : this.f11147a.values()) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.f11147a.clear();
        }

        @Override // com.oplus.gallery.bitmap.ICameraTransBitmap
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Map<String, Bitmap> mo10936b() throws RemoteException {
            return this.f11147a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9696a(Thumbnail c3203e) throws Throwable {
        m10061dl();
        this.f10814br = false;
        String strM24327aP = Util.m24327aP();
        if (Util.m24419c(this.f10849ca, strM24327aP)) {
            try {
                if (DisableUitl.m24536a(this.f10849ca, strM24327aP)) {
                    DisableUitl.m24534a(this.f10849ca, R.string.camera_disable_album, strM24327aP, "");
                    return;
                }
                this.f10804bh = true;
                Bitmap bitmapM19295i = c3203e.m19295i();
                if (bitmapM19295i == null) {
                    CameraLog.m12959b("CameraManager", "quick bitmap is null, use temp bitmap");
                }
                String str = bitmapM19295i != null ? "quickBitmap" : "tempBitmap";
                Bitmap bitmapM19295i2 = bitmapM19295i != null ? c3203e.m19295i() : c3203e.m19294h();
                Bundle bundle = new Bundle();
                if (bitmapM19295i2 == null) {
                    CameraLog.m12967f("CameraManager", "startGallery, the bitmap is null.");
                    return;
                }
                this.f10955eh.m10935a(str, bitmapM19295i2.copy(Bitmap.Config.ARGB_8888, true));
                bundle.putBinder("key_camera_transfer_bitmap_to_gallery", this.f10955eh);
                Intent intent = new Intent();
                if (Util.m24322aK() && Util.m24350am()) {
                    intent.setAction("com.oneplus.gallery.intent.action.LAUNCH_GALLERY");
                    intent.setClassName(Util.m24327aP(), "com.oneplus.gallery.FilmstripServiceActivity");
                    intent.putExtra("OPGalleryActivity.StartPage", "FILMSTRIP");
                    intent.putExtra("media-from", "from_camera");
                    long length = 0;
                    byte[] bArrM24304a = null;
                    for (int OplusGLSurfaceView_13 = 100; OplusGLSurfaceView_13 >= 30; OplusGLSurfaceView_13 -= 20) {
                        bArrM24304a = Util.m24304a(bitmapM19295i2, OplusGLSurfaceView_13);
                        if (bArrM24304a != null) {
                            length = bArrM24304a.length;
                            if (length <= 819200) {
                                break;
                            }
                        }
                    }
                    if (bArrM24304a != null && length <= 819200) {
                        intent.putExtra("SharedElementThumb", bArrM24304a);
                    }
                    intent.putExtra("StartMediaId", "MediaStore/" + c3203e.m19291e().getLastPathSegment());
                    intent.putExtra("SavingBurstCount", this.f10735aQ);
                    intent.putExtra("CameraBright", (float) Settings.System.getInt(this.f10849ca.getApplicationContext().getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.f10981q) * 0.4f)));
                    if (this.f10846cX.m13359w()) {
                        intent.addFlags(65536);
                        intent.putExtra("IsSecureMode", true);
                        if (f10692j.size() >= 1) {
                            intent.putStringArrayListExtra("SpecialModeSavedMedia", new ArrayList<>(f10692j.values()));
                            CameraLog.m12959b("CameraManager", "Goto gallery, sLockScreenUriList:" + f10692j.values().toString());
                        }
                    } else {
                        boolean z = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
                        Rect rect = new Rect(132, 1983, 264, 2115);
                        if (z) {
                            rect = new Rect(816, 1983, 948, 2115);
                        }
                        intent.putExtra("ThumbnailBarRect", rect);
                        intent.putExtra("ThumbnailBarCornerX", 90);
                        intent.putExtra("ThumbnailBarCornerY", 90);
                        intent.putExtra("ThumbnailBarExitAnimationDuration", 320L);
                    }
                } else {
                    intent.setAction("com.android.camera.action.REVIEW");
                    intent.setDataAndType(c3203e.m19291e(), c3203e.m19298l());
                    intent.putExtra("media-from", "from_camera");
                    if (!Util.m24495t()) {
                        intent.putExtra("animation_pivotX", m9598F(true));
                        intent.putExtra("animation_pivotY", m9598F(false));
                    }
                    intent.putExtras(bundle);
                    intent.setPackage(Util.m24327aP());
                }
                this.f10849ca.startActivity(intent);
                this.f10849ca.overridePendingTransition(this.mModeManager.m11989cX(), R.anim.gallery_in_camera_out);
                if (this.f10895dU) {
                    this.f10846cX.m13332a(true);
                }
            } catch (ActivityNotFoundException COUIBaseListPopupWindow_8) {
                CameraLog.m12956a("CameraManager", "startGallery, Exception: ActivityNotFoundException.", COUIBaseListPopupWindow_8);
                this.f10804bh = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9674a(MediaItem.kt c2436a, Bitmap bitmap) {
        m10061dl();
        this.f10814br = false;
        if (Util.m24419c(this.f10849ca, Util.m24327aP())) {
            try {
                this.f10804bh = true;
                Bundle bundle = new Bundle();
                if (bitmap == null) {
                    CameraLog.m12967f("CameraManager", "startGallery, the bitmap is null.");
                    return;
                }
                this.f10955eh.m10935a("tempBitmap", bitmap.copy(Bitmap.Config.ARGB_8888, true));
                bundle.putBinder("key_camera_transfer_bitmap_to_gallery", this.f10955eh);
                Intent intent = new Intent("com.android.camera.action.REVIEW");
                intent.setDataAndType(c2436a.m9434g(), c2436a.m9431d());
                intent.putExtra("media-from", "from_camera");
                if (!Util.m24495t()) {
                    intent.putExtra("animation_pivotX", m9598F(true));
                    intent.putExtra("animation_pivotY", m9598F(false));
                }
                intent.putExtras(bundle);
                intent.setPackage(Util.m24327aP());
                this.f10849ca.startActivity(intent);
                this.f10849ca.overridePendingTransition(this.mModeManager.m11989cX(), 0);
                if (this.f10895dU) {
                    this.f10846cX.m13332a(true);
                }
            } catch (ActivityNotFoundException COUIBaseListPopupWindow_8) {
                CameraLog.m12956a("CameraManager", "startGallery, Exception: ActivityNotFoundException.", COUIBaseListPopupWindow_8);
                this.f10804bh = false;
            }
        }
    }

    /* renamed from: ba */
    public void m10329ba() {
        OneCamera interfaceC2694d = this.f10852cd;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13013C();
        }
    }

    /* renamed from: bb */
    public boolean m10330bb() {
        return this.f10776bF;
    }

    /* renamed from: z */
    public void m10404z(boolean z) {
        this.f10775bE = z;
    }
}
