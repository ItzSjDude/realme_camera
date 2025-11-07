package com.oplus.camera.util;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Configuration;
import android.content.res.OplusBaseConfiguration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import android.hardware.display.DisplayManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.media.Image;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.LocaleList;
import android.os.Looper;
import android.os.RemoteException;
import android.p011os.OplusSystemProperties;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OplusWindowManager;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.p099a.COUIThemeOverlay;
import com.coui.appcompat.p099a.COUITintUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.meicam.sdk.NvsMediaFileConvertor;
import com.oplus.camera.CameraLog;
import com.oplus.camera.DimenConstants;
import com.oplus.camera.OplusConfigure;
import com.oplus.camera.MyApplication;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.VideoRecorder;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p146gl.BasicTexture;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.ILightBackgroundView;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.modepanel.DataBaseOperator;
import com.oplus.camera.p172ui.modepanel.ModeDataInfo;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.compat.content.ContextNative;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.SystemPropertiesNative;
import com.oplus.compat.p187os.UserHandleNative;
import com.oplus.compat.view.WindowManagerNative;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.p195os.OplusUsbEnvironment;
import com.oplus.util.OplusFontUtils;
import com.oplus.util.OplusTypeCastingHelper;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes2.dex */
public class Util {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f22962a = 480;

    /* renamed from: aw */
    private static DecimalFormat f22990aw = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int f22994b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float f22995c = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int f22996d = 20;

    /* renamed from: OplusGLSurfaceView_14 */
    private static Field f23004l;

    /* renamed from: OplusGLSurfaceView_6 */
    private static final String f23005m = OplusConfigure.m24654d();

    /* renamed from: OplusGLSurfaceView_11 */
    private static final String f23006n = OplusConfigure.m24652b();

    /* renamed from: o */
    private static float f23007o = 1.0f;

    /* renamed from: p */
    private static C3539a f23008p = null;

    /* renamed from: q */
    private static boolean f23009q = false;

    /* renamed from: r */
    private static boolean f23010r = false;

    /* renamed from: s */
    private static boolean f23011s = false;

    /* renamed from: t */
    private static boolean f23012t = false;

    /* renamed from: u */
    private static boolean f23013u = false;

    /* renamed from: v */
    private static boolean f23014v = false;

    /* renamed from: w */
    private static boolean f23015w = false;

    /* renamed from: x */
    private static boolean f23016x = false;

    /* renamed from: y */
    private static boolean f23017y = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static String f22997e = null;

    /* renamed from: z */
    private static String f23018z = null;

    /* renamed from: A */
    private static String f22936A = null;

    /* renamed from: B */
    private static Typeface f22937B = null;

    /* renamed from: C */
    private static String f22938C = null;

    /* renamed from: D */
    private static String f22939D = null;

    /* renamed from: E */
    private static String f22940E = null;

    /* renamed from: F */
    private static String f22941F = null;

    /* renamed from: G */
    private static Object f22942G = new Object();

    /* renamed from: H */
    private static Object f22943H = new Object();

    /* renamed from: I */
    private static LocationManager f22944I = null;

    /* renamed from: J */
    private static Context f22945J = null;

    /* renamed from: K */
    private static Handler f22946K = null;

    /* renamed from: L */
    private static COUIAlertDialog f22947L = null;

    /* renamed from: M */
    private static Thread f22948M = null;

    /* renamed from: N */
    private static RenderScript f22949N = null;

    /* renamed from: O */
    private static ScriptIntrinsicBlur f22950O = null;

    /* renamed from: P */
    private static HashMap<String, Boolean> f22951P = null;

    /* renamed from: Q */
    private static HandlerThread f22952Q = null;

    /* renamed from: R */
    private static Handler f22953R = null;

    /* renamed from: S */
    private static Display f22954S = null;

    /* renamed from: T */
    private static ArrayMap<Integer, Integer> f22955T = new ArrayMap<>();

    /* renamed from: U */
    private static Typeface f22956U = null;

    /* renamed from: V */
    private static Typeface f22957V = null;

    /* renamed from: W */
    private static Typeface f22958W = null;

    /* renamed from: X */
    private static Typeface f22959X = null;

    /* renamed from: Y */
    private static Typeface f22960Y = null;

    /* renamed from: Z */
    private static Typeface f22961Z = null;

    /* renamed from: aa */
    private static Typeface f22968aa = null;

    /* renamed from: ab */
    private static int f22969ab = 0;

    /* renamed from: ac */
    private static int f22970ac = 0;

    /* renamed from: ad */
    private static int f22971ad = 0;

    /* renamed from: ae */
    private static int f22972ae = 0;

    /* renamed from: af */
    private static int f22973af = 0;

    /* renamed from: ag */
    private static int f22974ag = 0;

    /* renamed from: ah */
    private static int f22975ah = 0;

    /* renamed from: ai */
    private static int f22976ai = 0;

    /* renamed from: aj */
    private static int f22977aj = 0;

    /* renamed from: ak */
    private static int f22978ak = 0;

    /* renamed from: al */
    private static int f22979al = 0;

    /* renamed from: am */
    private static int f22980am = 120000;

    /* renamed from: an */
    private static double f22981an = 0.8d;

    /* renamed from: ao */
    private static boolean f22982ao = false;

    /* renamed from: ap */
    private static boolean f22983ap = false;

    /* renamed from: aq */
    private static boolean f22984aq = false;

    /* renamed from: ar */
    private static boolean f22985ar = false;

    /* renamed from: as */
    private static boolean f22986as = false;

    /* renamed from: at */
    private static Object f22987at = new Object();

    /* renamed from: au */
    private static Object f22988au = new Object();

    /* renamed from: av */
    private static Boolean f22989av = null;

    /* renamed from: ax */
    private static HashMap<Integer, AnimatorSet> f22991ax = new HashMap<>();

    /* renamed from: ay */
    private static Size f22992ay = new Size(0, 0);

    /* renamed from: az */
    private static Boolean f22993az = null;

    /* renamed from: aA */
    private static Boolean f22963aA = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int f22998f = 4;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static int f22999g = 8;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static int f23000h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    public static int f23001i = -1;

    /* renamed from: OplusGLSurfaceView_15 */
    public static int f23002j = -2;

    /* renamed from: OplusGLSurfaceView_5 */
    public static boolean f23003k = false;

    /* renamed from: aB */
    private static WindowManager f22964aB = null;

    /* renamed from: aC */
    private static int f22965aC = -1;

    /* renamed from: aD */
    private static boolean f22966aD = false;

    /* renamed from: aE */
    private static final int[] f22967aE = new int[2];

    /* renamed from: V */
    public static int m24194V() {
        return 988;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m24201a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 > f3 ? f3 : COUIBaseListPopupWindow_12 < f2 ? f2 : COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24205a(int OplusGLSurfaceView_13, int i2, int i3) {
        return OplusGLSurfaceView_13 > i3 ? i3 : OplusGLSurfaceView_13 < i2 ? i2 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24243a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 17) {
            return "yuv420sp";
        }
        if (OplusGLSurfaceView_13 == 32) {
            return "raw";
        }
        if (OplusGLSurfaceView_13 == 256) {
            return CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
        }
        switch (OplusGLSurfaceView_13) {
            case 35:
                return "yuv420sp";
            case 36:
            case 37:
            case 38:
                return "raw";
            default:
                return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24291a(Uri uri, String str, int OplusGLSurfaceView_13, int i2) {
        return uri != null && str != null && OplusGLSurfaceView_13 < 0 && i2 < 0;
    }

    /* renamed from: ak */
    public static boolean m24348ak() {
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m24364b(float COUIBaseListPopupWindow_12) {
        float f2 = 4.0f > COUIBaseListPopupWindow_12 ? 5.0f * ((COUIBaseListPopupWindow_12 - 1.0f) / 3.0f) : 5.0f;
        if (0.0f > f2) {
            return 0.0f;
        }
        return f2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m24366b(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 > 45) {
            return 180;
        }
        if (OplusGLSurfaceView_13 < -45) {
            return 0;
        }
        if (i2 >= 45) {
            return 90;
        }
        return i2 > -45 ? 0 : 270;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m24382b(boolean z) {
        return z ? ApsConstant.REC_MODE_COMMON : ApsConstant.CAPTURE_MODE_COMMON;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m24434d(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 5;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m24454g(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 2;
    }

    public static native boolean nativeGetYuvDataWithoutPadding(HardwareBuffer hardwareBuffer, ByteBuffer byteBuffer, int OplusGLSurfaceView_13);

    static {
        System.loadLibrary("preview_show");
        f22955T.put(Integer.valueOf(VideoMode.VIDEO_720P_HEIGHT), 420);
        f22955T.put(Integer.valueOf(VideoMode.VIDEO_1080P_HEIGHT), Integer.valueOf(CameraParameter.VideoFps.FPS_480));
        f22955T.put(1440, 640);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24257a(Context context) {
        CameraLog.m12954a("Util", "attachBaseContext, context: " + context);
        f22945J = context;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24385b(Context context) {
        CameraLog.m12952a("attachApplication");
        f22945J = context;
        f23009q = m24459h("oplus.software.video.wnr_support");
        CameraLog.m12958b("attachApplication");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static synchronized void m24415c(Context context) {
        CameraLog.m12954a("Util", "initialize, sbInit: " + f22985ar);
        if (!f22985ar) {
            CameraLog.m12952a("initialize");
            Thumbnail.m19280a();
            m24357at();
            DocumentUtil.m16194a(context, (DocumentUtil.PlatformImplementations.kt_3) null);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            CameraLog.m12954a("Util", "displaycontent, getDefaultDisplay().getHeight(): " + windowManager.getDefaultDisplay().getHeight() + " wm.getDefaultDisplay().getWidth(): " + windowManager.getDefaultDisplay().getWidth() + " metrics.density: " + displayMetrics.density + " metrics.densityDpi: " + displayMetrics.densityDpi);
            f23007o = displayMetrics.density;
            f22946K = new Handler(context.getMainLooper());
            m24450f(context);
            m24489q(f22945J);
            m24477m();
            m24282a(true);
            m24341ad();
            CameraLog.m12958b("initialize");
        }
        CameraLog.m12954a("Util", "initialize X");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static synchronized void m24430d(Context context) {
        if (!f22986as) {
            m24179H(context);
            m24181I(context);
            m24440e(context);
            f22986as = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        com.oplus.camera.util.Util.f23016x = true;
     */
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m24179H(android.content.Context r2) {
        /*
            java.lang.String r0 = "audio"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            java.util.List r2 = r2.getMicrophones()     // Catch: java.io.IOException -> L28
            java.util.Iterator r2 = r2.iterator()     // Catch: java.io.IOException -> L28
        L10:
            boolean r0 = r2.hasNext()     // Catch: java.io.IOException -> L28
            if (r0 == 0) goto L2c
            java.lang.Object r0 = r2.next()     // Catch: java.io.IOException -> L28
            android.media.MicrophoneInfo r0 = (android.media.MicrophoneInfo) r0     // Catch: java.io.IOException -> L28
            r1 = 15
            int r0 = r0.getType()     // Catch: java.io.IOException -> L28
            if (r1 != r0) goto L10
            r2 = 1
            com.oplus.camera.util.Util.f23016x = r2     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            r2 = move-exception
            r2.printStackTrace()
        L2c:
            boolean r2 = com.oplus.camera.util.Util.f23016x
            if (r2 != 0) goto L37
            java.lang.String r2 = "Util"
            java.lang.String r0 = "checkMicrophoneDevice, No Microphone Device!"
            com.oplus.camera.CameraLog.m12967f(r2, r0)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.m24179H(android.content.Context):void");
    }

    /* renamed from: I */
    private static void m24181I(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        f22940E = audioManager.getParameters("surround_record");
        f22941F = audioManager.getParameters("vendor_audiorecord_track_support");
        CameraLog.m12962c("Util", "checkAudioSurroundRecord, sSurroundRecord: " + f22940E);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m24440e(Context context) {
        if ("yes".equals(((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getParameters("binaural_recording_standby"))) {
            f22983ap = true;
        }
        CameraLog.m12962c("Util", "checkAudioBinauralRecord, sbBinauralRecordSupport: " + f22983ap);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24284a() {
        CameraLog.m12954a("Util", "isBinauralRecordSupport, sbBinauralRecordSupport: " + f22983ap);
        return f22983ap;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24390b() {
        return f23011s;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m24417c() {
        return f23012t;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m24433d() {
        return f23013u;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static synchronized void m24450f(Context context) {
        boolean zM24506y = m24506y(context);
        if (f22954S.getDisplayId() == 0 && zM24506y) {
            f22962a = f22955T.get(Integer.valueOf(f22954S.getMode().getPhysicalWidth())).intValue();
        } else {
            try {
                f22962a = WindowManagerNative.getInitialDisplayDensity(0);
            } catch (RemoteException | UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        if (-1 != f22965aC) {
            f23001i = f22965aC;
        } else {
            f23001i = m24436e();
        }
        CameraLog.m12959b("Util", "initializeDefaultDisplay, acquire sDefaultDensity: " + f22962a);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static int m24436e() {
        int OplusGLSurfaceView_13 = Settings.Global.getInt(f22945J.getContentResolver(), "oplus_system_folding_angle", -1);
        CameraLog.m12954a("Util", "getFolderAngle, folderAngle: " + OplusGLSurfaceView_13);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m24449f() {
        int OplusGLSurfaceView_13 = f22965aC;
        if (OplusGLSurfaceView_13 != -1) {
            f23001i = OplusGLSurfaceView_13;
        } else {
            f23001i = m24436e();
        }
        CameraLog.m12959b("Util", "updateFolderAngle, sFoldAngle: " + f23001i);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static int m24451g() {
        int OplusGLSurfaceView_13;
        if (m24495t()) {
            OplusGLSurfaceView_13 = m24498u() ? 1 : 0;
        } else {
            OplusGLSurfaceView_13 = -1;
        }
        CameraLog.m12959b("Util", "getFoldingMode, foldingMode: " + OplusGLSurfaceView_13);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static int m24457h() {
        return Settings.Global.getInt(f22945J.getContentResolver(), "oplus_emulate_software_folding_mode", -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24251a(int OplusGLSurfaceView_13, int i2) {
        int[] iArr = f22967aE;
        iArr[0] = OplusGLSurfaceView_13;
        iArr[1] = i2;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static boolean m24462i() {
        boolean z;
        CameraLog.m12954a("Util", "getInitState, sbInit: " + f22985ar);
        synchronized (f22987at) {
            z = f22985ar;
        }
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24282a(boolean z) {
        CameraLog.m12954a("Util", "setInitState, sbInit: " + z);
        synchronized (f22987at) {
            f22985ar = z;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static void m24465j() {
        synchronized (f22988au) {
            if (f22952Q == null) {
                f22952Q = new HandlerThread("WorkerThread");
                f22952Q.start();
            }
            if (f22953R == null) {
                f22953R = new Handler(f22952Q.getLooper());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24279a(Runnable runnable) {
        if (f22953R == null) {
            m24465j();
        }
        f22953R.post(runnable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24389b(Runnable runnable) {
        Handler handler = f22953R;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static void m24469k() {
        Handler handler = f22953R;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            f22953R = null;
        }
        HandlerThread handlerThread = f22952Q;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            f22952Q = null;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static Context m24472l() {
        return f22945J;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m24477m() {
        if (f22948M != null) {
            CameraLog.m12959b("Util", "initRenderScript, sRSInitThread not null, so return");
        } else {
            f22948M = new Thread(new Runnable() { // from class: com.oplus.camera.util.Util.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraLog.m12959b("Util", "intRenderScript");
                    if (Util.f22945J == null) {
                        return;
                    }
                    synchronized (Util.f22942G) {
                        RenderScript unused = Util.f22949N = RenderScript.create(Util.f22945J);
                        ScriptIntrinsicBlur unused2 = Util.f22950O = ScriptIntrinsicBlur.create(Util.f22949N, Element.U8_4(Util.f22949N));
                    }
                    CameraLog.m12959b("Util", "intRenderScript X");
                }
            });
            f22948M.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] m24304a(android.graphics.Bitmap r3, int r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 == 0) goto L46
            boolean r1 = r3.isRecycled()
            if (r1 == 0) goto La
            goto L46
        La:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r1.<init>()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            r3.compress(r2, r4, r1)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            byte[] r3 = r1.toByteArray()     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            int r4 = r4.length     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            byte[] r0 = java.util.Arrays.copyOf(r3, r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            r1.close()     // Catch: java.lang.Exception -> L25
            goto L39
        L25:
            r3 = move-exception
            r3.printStackTrace()
            goto L39
        L2a:
            r3 = move-exception
            goto L31
        L2c:
            r3 = move-exception
            r1 = r0
            goto L3b
        L2f:
            r3 = move-exception
            r1 = r0
        L31:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.lang.Exception -> L25
        L39:
            return r0
        L3a:
            r3 = move-exception
        L3b:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Exception -> L41
            goto L45
        L41:
            r4 = move-exception
            r4.printStackTrace()
        L45:
            throw r3
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.m24304a(android.graphics.Bitmap, int):byte[]");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24218a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m24371b(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static void m24481n() throws InterruptedException {
        Thread thread = f22948M;
        if (thread != null) {
            try {
                thread.join();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        synchronized (f22942G) {
            if (f22950O != null) {
                f22950O.destroy();
                f22950O = null;
            }
            if (f22949N != null) {
                try {
                    f22949N.destroy();
                    f22949N = null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    CameraLog.m12967f("Util", "finishRSInitThread, renderScript destroy, exception: " + e2.getMessage());
                }
            }
        }
        CameraLog.m12959b("Util", "finishRSInitThread X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24204a(float COUIBaseListPopupWindow_12) {
        return Math.round(f23007o * COUIBaseListPopupWindow_12);
    }

    /* renamed from: o */
    public static float m24483o() {
        return f23007o;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m24373b(Bitmap bitmap, int OplusGLSurfaceView_13) {
        return m24222a(bitmap, OplusGLSurfaceView_13, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24222a(Bitmap bitmap, int OplusGLSurfaceView_13, boolean z) {
        if ((OplusGLSurfaceView_13 == 0 && !z) || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            OplusGLSurfaceView_13 = (OplusGLSurfaceView_13 + 360) % 360;
            if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 180) {
                matrix.postTranslate(bitmap.getWidth(), 0.0f);
            } else if (OplusGLSurfaceView_13 == 90 || OplusGLSurfaceView_13 == 270) {
                matrix.postTranslate(bitmap.getHeight(), 0.0f);
            } else {
                throw new IllegalArgumentException("Invalid degrees: " + OplusGLSurfaceView_13);
            }
        }
        if (OplusGLSurfaceView_13 != 0) {
            matrix.postRotate(OplusGLSurfaceView_13, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        }
        try {
            Bitmap bitmapM24221a = m24221a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapM24221a) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapM24221a;
        } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return bitmap;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24209a(BitmapFactory.Options options, int OplusGLSurfaceView_13, int i2) {
        int iM24367b = m24367b(options, OplusGLSurfaceView_13, i2);
        if (iM24367b > 8) {
            return 8 * ((iM24367b + 7) / 8);
        }
        int i3 = 1;
        while (i3 < iM24367b) {
            i3 <<= 1;
        }
        return i3;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m24367b(BitmapFactory.Options options, int OplusGLSurfaceView_13, int i2) {
        int iMin;
        double IntrinsicsJvm.kt_5 = options.outWidth;
        double d2 = options.outHeight;
        int iCeil = i2 < 0 ? 1 : (int) Math.ceil(Math.sqrt((IntrinsicsJvm.kt_5 * d2) / i2));
        if (OplusGLSurfaceView_13 < 0) {
            iMin = 128;
        } else {
            double d3 = OplusGLSurfaceView_13;
            iMin = (int) Math.min(Math.floor(IntrinsicsJvm.kt_5 / d3), Math.floor(d2 / d3));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i2 >= 0 || OplusGLSurfaceView_13 >= 0) {
            return OplusGLSurfaceView_13 < 0 ? iCeil : iMin;
        }
        return 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24224a(byte[] bArr, int OplusGLSurfaceView_13) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                options.inSampleSize = m24209a(options, -1, OplusGLSurfaceView_13);
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
            return null;
        } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("Util", "Got oom exception ", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24277a(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: p */
    public static boolean m24487p() {
        COUIAlertDialog dialogInterfaceC1289b = f22947L;
        return dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24254a(final Activity activity, final int OplusGLSurfaceView_13) {
        CameraLog.m12967f("Util", "showErrorAndFinish, Some Error occurs, Error id_renamed: " + OplusGLSurfaceView_13 + ", activty: " + activity);
        if (activity == null) {
            return;
        }
        f22946K.post(new Runnable() { // from class: com.oplus.camera.util.Util.3
            @Override // java.lang.Runnable
            public void run() {
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.util.Util.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        activity.finish();
                    }
                };
                if (Util.f22947L != null) {
                    Util.f22947L.cancel();
                    COUIAlertDialog unused = Util.f22947L = null;
                }
                COUIAlertDialog unused2 = Util.f22947L = new COUIAlertDialog.PlatformImplementations.kt_3(activity).setCancelable(false).setIconAttribute(R.attr.alertDialogIcon).setTitle(OplusGLSurfaceView_13).setNeutralButton(com.oplus.camera.R.string.camera_button_ok, onClickListener).show();
            }
        });
    }

    /* renamed from: q */
    public static void m24490q() {
        Handler handler = f22946K;
        if (handler == null || f22947L == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.oplus.camera.util.Util.4
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("Util", "cancleOpenCameraFailDialog(), sOpenCameraFailDialog: " + Util.f22947L);
                if (Util.f22947L != null) {
                    Util.f22947L.cancel();
                    COUIAlertDialog unused = Util.f22947L = null;
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24207a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m24405c(int OplusGLSurfaceView_13, int i2) {
        boolean z = true;
        if (i2 != -1) {
            int iAbs = Math.abs(OplusGLSurfaceView_13 - i2);
            if (Math.min(iAbs, 360 - iAbs) < 65) {
                z = false;
            }
        }
        return z ? (((OplusGLSurfaceView_13 + 30) / 90) * 90) % 360 : i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m24235a(List<Size> list, double IntrinsicsJvm.kt_5) {
        return m24236a(list, IntrinsicsJvm.kt_5, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m24236a(List<Size> list, double IntrinsicsJvm.kt_5, int OplusGLSurfaceView_13) {
        Size size = null;
        if (list == null) {
            return null;
        }
        int iAbs = Integer.MAX_VALUE;
        int i2 = f22969ab;
        for (Size size2 : list) {
            double width = size2.getWidth() / size2.getHeight();
            double d2 = 538982489 == OplusGLSurfaceView_13 ? 0.002d : 0.01d;
            if (Math.abs(width - IntrinsicsJvm.kt_5) <= d2) {
                if (m24498u()) {
                    i2 = Math.abs(width - 0.9333333333333333d) < d2 ? 1440 : VideoMode.VIDEO_1080P_HEIGHT;
                }
                int iAbs2 = Math.abs(size2.getHeight() - i2);
                if (iAbs2 < iAbs) {
                    iAbs = Math.abs(size2.getHeight() - i2);
                } else if (iAbs2 != iAbs || size2.getHeight() <= i2) {
                }
                size = size2;
            }
        }
        if (size == null) {
            for (Size size3 : list) {
                if (Math.abs((size3.getWidth() / size3.getHeight()) - IntrinsicsJvm.kt_5) <= 0.03d) {
                    int iAbs3 = Math.abs(size3.getHeight() - i2);
                    if (iAbs3 < iAbs) {
                        iAbs = Math.abs(size3.getHeight() - i2);
                    } else if (iAbs3 != iAbs || size3.getHeight() <= i2) {
                    }
                    size = size3;
                }
            }
        }
        if (size != null) {
            CameraLog.m12954a("Util", "getOptimalPreviewSize, screen: " + f22969ab + "x" + f22970ac + ", targetRatio: " + IntrinsicsJvm.kt_5 + ", optimalSize: " + size.getHeight() + "x" + size.getWidth());
        } else {
            CameraLog.m12967f("Util", "getOptimalPreviewSize, optimalSize is null");
        }
        return size;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24293a(Size size, double IntrinsicsJvm.kt_5) {
        return Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - IntrinsicsJvm.kt_5) < 0.05d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m24238a(List<Size> list, final int OplusGLSurfaceView_13, final int i2) {
        if (list == null || list.isEmpty()) {
            CameraLog.m12966e("Util", "getOptimalBigSizeByTargetSize, size is empty");
            return null;
        }
        return list.stream().filter($$Lambda$bdDB5qtJ9up3KI34bjHEph1ELg.INSTANCE).filter(new Predicate() { // from class: com.oplus.camera.util.-$$Lambda$Util$DBGNOagioPDoHzan1N4T4F80efc
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Util.m24285a(OplusGLSurfaceView_13, i2, (Size) obj);
            }
        }).min(new Comparator() { // from class: com.oplus.camera.util.-$$Lambda$Util$bocYwBQLMmJRgXeP5jItCElMHEU
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Util.m24368b((Size) obj, (Size) obj2);
            }
        }).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ boolean m24285a(int OplusGLSurfaceView_13, int i2, Size size) {
        return 0.05d >= Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - (((double) OplusGLSurfaceView_13) / ((double) i2))) && size.getWidth() >= OplusGLSurfaceView_13 && size.getHeight() >= i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ int m24368b(Size size, Size size2) {
        return (size.getHeight() + size.getWidth()) - (size2.getWidth() + size2.getHeight());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Size m24378b(List<Size> list, double IntrinsicsJvm.kt_5) {
        return m24379b(list, IntrinsicsJvm.kt_5, -1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Size m24379b(List<Size> list, double IntrinsicsJvm.kt_5, int OplusGLSurfaceView_13) {
        return m24237a(list, IntrinsicsJvm.kt_5, OplusGLSurfaceView_13, -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m24237a(List<Size> list, double IntrinsicsJvm.kt_5, int OplusGLSurfaceView_13, int i2) {
        Size size = null;
        if (list != null && list.size() != 0) {
            for (Size size2 : list) {
                if (Math.abs((size2.getWidth() / size2.getHeight()) - IntrinsicsJvm.kt_5) <= 0.01d && (-1 == OplusGLSurfaceView_13 || size2.getHeight() <= OplusGLSurfaceView_13)) {
                    if (-1 == i2 || size2.getWidth() <= i2) {
                        if (size == null || size.getHeight() < size2.getHeight()) {
                            size = size2;
                        }
                    }
                }
            }
            if (size != null) {
                CameraLog.m12954a("Util", "getMaxSizeByRatio, size: " + size.getHeight() + "x" + size.getWidth() + ", targetRatio: " + IntrinsicsJvm.kt_5);
            } else {
                CameraLog.m12967f("Util", "getMaxSizeByRatio, optimalSize is null");
            }
        }
        return size;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Size m24412c(List<Size> list, double IntrinsicsJvm.kt_5) {
        return m24413c(list, IntrinsicsJvm.kt_5, -1);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Size m24413c(List<Size> list, double IntrinsicsJvm.kt_5, int OplusGLSurfaceView_13) {
        Size size = null;
        if (list != null && list.size() != 0) {
            for (Size size2 : list) {
                if (Math.abs((size2.getWidth() / size2.getHeight()) - IntrinsicsJvm.kt_5) <= 0.05d && (-1 == OplusGLSurfaceView_13 || size2.getHeight() <= OplusGLSurfaceView_13)) {
                    if (size == null || size.getHeight() < size2.getHeight()) {
                        size = size2;
                    }
                }
            }
            if (size != null) {
                CameraLog.m12954a("Util", "getImpreciseMaxSizeByRatio, size: " + size.getHeight() + "x" + size.getWidth() + ", targetRatio: " + IntrinsicsJvm.kt_5);
            } else {
                CameraLog.m12967f("Util", "getImpreciseMaxSizeByRatio, optimalSize is null");
            }
        }
        return size;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m24234a(int OplusGLSurfaceView_13, List<Size> list, double IntrinsicsJvm.kt_5) {
        int iAbs = Integer.MAX_VALUE;
        Size size = null;
        for (Size size2 : list) {
            if (Math.abs((size2.getWidth() / size2.getHeight()) - IntrinsicsJvm.kt_5) <= 0.01d && Math.abs(size2.getHeight() - OplusGLSurfaceView_13) < iAbs) {
                iAbs = Math.abs(size2.getHeight() - OplusGLSurfaceView_13);
                size = size2;
            }
        }
        return size;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24211a(String str) {
        if ("standard".equals(str) || "standard_high".equals(str)) {
            return 0;
        }
        if (DcsMsgData.FULL.equals(str)) {
            return m24197Y();
        }
        if ("square".equals(str)) {
            return 2;
        }
        return "16_9".equals(str) ? 1 : -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24248a(Size size, int OplusGLSurfaceView_13) {
        if (size == null) {
            return DcsMsgData.FULL;
        }
        Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, OplusGLSurfaceView_13);
        return (sizeConfigValue != null && sizeConfigValue.getWidth() == size.getWidth() && sizeConfigValue.getHeight() == size.getHeight()) ? "standard_high" : Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.3333333333333333d) < 0.01d ? "standard" : Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.0d) < 0.01d ? "square" : Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.7777777777777777d) < 0.01d ? "16_9" : DcsMsgData.FULL;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m24239a(List<Size> list, String str, int OplusGLSurfaceView_13) {
        Size size = null;
        if (list == null || list.size() == 0 || str == null) {
            CameraLog.m12967f("Util", "getMinDiffPictureSize error!");
            return null;
        }
        long jAbs = Long.MAX_VALUE;
        for (Size size2 : list) {
            if (m24426d(size2.getWidth(), size2.getHeight()) == OplusGLSurfaceView_13 && jAbs > Math.abs(Long.valueOf(str).longValue() - (size2.getWidth() * size2.getHeight()))) {
                jAbs = Math.abs(Long.valueOf(str).longValue() - (size2.getWidth() * size2.getHeight()));
                size = size2;
            }
        }
        return size;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[Catch: all -> 0x00d0, PHI: r2
      0x00b5: PHI (r2v1 android.database.Cursor) = (r2v0 android.database.Cursor), (r2v2 android.database.Cursor) binds: [B:47:0x00c1, B:40:0x00b3] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:8:0x0024, B:18:0x0049, B:30:0x009a, B:36:0x00aa, B:41:0x00b5, B:53:0x00cc, B:54:0x00cf, B:20:0x0063, B:22:0x0069, B:24:0x0088, B:28:0x0093, B:34:0x00a3, B:46:0x00bc), top: B:66:0x001c, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m24290a(android.net.Uri r12, android.content.ContentResolver r13) throws java.lang.Throwable {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isUriValid, uri: "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Util"
            com.oplus.camera.CameraLog.m12954a(r1, r0)
            r0 = 0
            if (r12 != 0) goto L1a
            return r0
        L1a:
            r2 = 0
            r3 = 1
            java.lang.String r4 = "r"
            android.os.ParcelFileDescriptor r4 = r13.openFileDescriptor(r12, r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            if (r4 != 0) goto L3e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            r5.<init>()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            java.lang.String r6 = "isUriValid, Fail to open uri: "
            r5.append(r6)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            r5.append(r12)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            com.oplus.camera.CameraLog.m12967f(r1, r5)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            if (r4 == 0) goto L3d
            r4.close()     // Catch: java.lang.Exception -> L3d
        L3d:
            return r0
        L3e:
            if (r4 == 0) goto L43
            r4.close()     // Catch: java.lang.Exception -> L43
        L43:
            return r3
        L44:
            r12 = move-exception
            r4 = r2
            goto Ld1
        L48:
            r4 = r2
        L49:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            r5.<init>()     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r6 = "isUriValid, IOException: "
            r5.append(r6)     // Catch: java.lang.Throwable -> Ld0
            r5.append(r12)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Ld0
            com.oplus.camera.CameraLog.m12967f(r1, r5)     // Catch: java.lang.Throwable -> Ld0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r6 = r13
            r7 = r12
            android.database.Cursor r2 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r2 == 0) goto Lb3
            r2.moveToFirst()     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r12 = "_data"
            int r12 = r2.getColumnIndex(r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r12 = r2.getString(r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r13 = "is_pending"
            int r13 = r2.getColumnIndex(r13)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            int r13 = r2.getInt(r13)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r5 = "_tmp"
            boolean r5 = r12.contains(r5)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r5 != 0) goto La3
            java.lang.String r5 = "dng"
            boolean r12 = r12.contains(r5)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r12 == 0) goto L91
            goto La3
        L91:
            if (r3 != r13) goto Lb3
            java.lang.String r12 = "isUriValid, but from IS_PENDING file!"
            com.oplus.camera.CameraLog.m12967f(r1, r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r2 == 0) goto L9d
            r2.close()     // Catch: java.lang.Throwable -> Ld0
        L9d:
            if (r4 == 0) goto La2
            r4.close()     // Catch: java.lang.Exception -> La2
        La2:
            return r3
        La3:
            java.lang.String r12 = "isUriValid, but from tmp file!"
            com.oplus.camera.CameraLog.m12967f(r1, r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r2 == 0) goto Lad
            r2.close()     // Catch: java.lang.Throwable -> Ld0
        Lad:
            if (r4 == 0) goto Lb2
            r4.close()     // Catch: java.lang.Exception -> Lb2
        Lb2:
            return r3
        Lb3:
            if (r2 == 0) goto Lc4
        Lb5:
            r2.close()     // Catch: java.lang.Throwable -> Ld0
            goto Lc4
        Lb9:
            r12 = move-exception
            goto Lca
        Lbb:
            r12 = move-exception
            java.lang.String r13 = "isUriValid, get cursor failed!"
            com.oplus.camera.CameraLog.m12965d(r1, r13, r12)     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto Lc4
            goto Lb5
        Lc4:
            if (r4 == 0) goto Lc9
            r4.close()     // Catch: java.lang.Exception -> Lc9
        Lc9:
            return r0
        Lca:
            if (r2 == 0) goto Lcf
            r2.close()     // Catch: java.lang.Throwable -> Ld0
        Lcf:
            throw r12     // Catch: java.lang.Throwable -> Ld0
        Ld0:
            r12 = move-exception
        Ld1:
            if (r4 == 0) goto Ld6
            r4.close()     // Catch: java.lang.Exception -> Ld6
        Ld6:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.m24290a(android.net.Uri, android.content.ContentResolver):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized String m24246a(long OplusGLSurfaceView_15) {
        return m24247a(OplusGLSurfaceView_15, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized String m24247a(long OplusGLSurfaceView_15, boolean z) {
        if (f23008p == null) {
            f23008p = new C3539a(f22945J.getString(com.oplus.camera.R.string.camera_image_file_name_format));
        }
        return f23008p.m24510a(OplusGLSurfaceView_15, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static synchronized String m24380b(long OplusGLSurfaceView_15) {
        if (f23008p == null) {
            f23008p = new C3539a(f22945J.getString(com.oplus.camera.R.string.camera_image_file_name_format));
        }
        return f23008p.m24509a(OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24283a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < (OplusGLSurfaceView_13 >> 1); i7++) {
                int i8 = i5 + i7;
                byte b2 = bArr[i8];
                int i9 = ((i5 + OplusGLSurfaceView_13) - 1) - i7;
                bArr[i8] = bArr[i9];
                bArr[i9] = b2;
            }
            i5 += i3;
        }
        int i10 = i4 * i3;
        for (int i11 = 0; i11 < (i2 >> 1); i11++) {
            for (int i12 = 0; i12 < (OplusGLSurfaceView_13 >> 1); i12 += 2) {
                int i13 = i10 + i12;
                byte b3 = bArr[i13];
                int i14 = i10 + OplusGLSurfaceView_13;
                int i15 = (i14 - 2) - i12;
                bArr[i13] = bArr[i15];
                bArr[i15] = b3;
                int i16 = i13 + 1;
                byte b4 = bArr[i16];
                int i17 = (i14 - 1) - i12;
                bArr[i16] = bArr[i17];
                bArr[i17] = b4;
            }
            i10 += i3;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24310a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z) {
        byte[] bArr2 = new byte[((OplusGLSurfaceView_13 * i2) * 3) >> 1];
        int i5 = i2 >> 1;
        int i6 = (i2 - 1) * i3;
        int i7 = 0;
        int i8 = 0;
        while (i7 < OplusGLSurfaceView_13) {
            int i9 = i6;
            int i10 = i8;
            int i11 = 0;
            while (i11 < i2) {
                bArr2[i10] = bArr[i9 + i7];
                i9 -= i3;
                i11++;
                i10++;
            }
            i7++;
            i8 = i10;
        }
        int i12 = (((i2 / 2) + i4) - 1) * i3;
        for (int i13 = 0; i13 < OplusGLSurfaceView_13; i13 += 2) {
            int i14 = i12;
            for (int i15 = 0; i15 < i5; i15++) {
                if (z) {
                    int i16 = i8 + 1;
                    bArr2[i8] = bArr[i14 + 1 + i13];
                    i8 = i16 + 1;
                    bArr2[i16] = bArr[i14 + i13];
                } else {
                    int i17 = i8 + 1;
                    bArr2[i8] = bArr[i14 + i13];
                    i8 = i17 + 1;
                    bArr2[i17] = bArr[i14 + 1 + i13];
                }
                i14 -= i3;
            }
        }
        return bArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24308a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 * i2;
        byte[] bArr2 = new byte[(i3 * 3) >> 1];
        int i4 = 0;
        for (int i5 = 0; i5 < OplusGLSurfaceView_13; i5++) {
            int i6 = i2 - 1;
            while (i6 >= 0) {
                bArr2[i4] = bArr[(OplusGLSurfaceView_13 * i6) + i5];
                i6--;
                i4++;
            }
        }
        for (int i7 = 0; i7 < OplusGLSurfaceView_13; i7 += 2) {
            for (int i8 = (i2 >> 1) - 1; i8 >= 0; i8--) {
                int i9 = (OplusGLSurfaceView_13 * i8) + i3 + i7;
                bArr2[i4] = bArr[i9];
                bArr2[i4 + 1] = bArr[i9 + 1];
                i4 += 2;
            }
        }
        return bArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m24398b(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = i2 >> 1;
        int i4 = OplusGLSurfaceView_13 * i2;
        byte[] bArr2 = new byte[(i4 * 3) >> 1];
        int i5 = OplusGLSurfaceView_13 - 1;
        int i6 = i5;
        int i7 = 0;
        while (i6 >= 0) {
            int i8 = i7;
            int i9 = 0;
            while (i9 < i2) {
                bArr2[i8] = bArr[(OplusGLSurfaceView_13 * i9) + i6];
                i9++;
                i8++;
            }
            i6--;
            i7 = i8;
        }
        while (i5 > 0) {
            for (int i10 = 0; i10 < i3; i10++) {
                int i11 = i7 + 1;
                int i12 = (OplusGLSurfaceView_13 * i10) + i4 + i5;
                bArr2[i7] = bArr[i12 - 1];
                i7 = i11 + 1;
                bArr2[i11] = bArr[i12];
            }
            i5 -= 2;
        }
        return bArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24261a(Bitmap bitmap, File file) throws IOException {
        try {
            OutputStream outputStreamM16193a = DocumentUtil.m16193a(file.getAbsolutePath(), "image/png");
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamM16193a);
                outputStreamM16193a.flush();
                if (outputStreamM16193a != null) {
                    outputStreamM16193a.close();
                }
            } finally {
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24262a(Bitmap bitmap, String str) throws IOException {
        String absolutePath = f22945J.getExternalFilesDir(str).getAbsolutePath();
        if (!new File(absolutePath).exists() && !DocumentUtil.m16210f(absolutePath)) {
            CameraLog.m12967f("Util", "saveBitmap, mkdirs fail");
            return;
        }
        m24261a(bitmap, new File(absolutePath, m24246a(System.currentTimeMillis()) + ".png"));
    }

    /* renamed from: r */
    public static synchronized void m24492r() {
        if (f23008p != null) {
            f23008p.m24511a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String[] m24402b(int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = (((((OplusGLSurfaceView_13 * (-38)) - (i2 * 74)) + (i3 * 112)) + 128) >> 8) + 128;
        int i5 = (((((OplusGLSurfaceView_13 * 112) - (i2 * 94)) - (i3 * 18)) + 128) >> 8) + 128;
        int i6 = 255;
        if (i5 < 0) {
            i5 = 0;
        } else if (i5 > 255) {
            i5 = 255;
        }
        if (i4 < 0) {
            i6 = 0;
        } else if (i4 <= 255) {
            i6 = i4;
        }
        return new String[]{String.valueOf(i5), String.valueOf(i6)};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24260a(Context context, String str) {
        if (str != null) {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24258a(Context context, Uri uri, String str) {
        CameraLog.m12954a("Util", "broadcastNewPicture, uri: " + uri);
        context.sendBroadcast(new Intent("android.hardware.action.NEW_PICTURE", uri));
        context.sendBroadcast(new Intent("com.android.camera.NEW_PICTURE", uri));
        m24259a(context, uri, "com.oplus.camera.NEW_PICTURE", m24327aP());
        m24259a(context, uri, "com.oplus.camera.NEW_PICTURE", "com.heytap.cloud");
        if (str != null) {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, null);
        }
        CameraLog.m12954a("Util", "++broadcastNewPicture, uri: " + uri);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24259a(Context context, Uri uri, String str, String str2) {
        Intent intent = new Intent(str, uri);
        intent.setPackage(str2);
        context.sendBroadcast(intent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24269a(final View view, final int OplusGLSurfaceView_13, int i2, Interpolator interpolator, Animator.AnimatorListener animatorListener) {
        if (view == null || i2 < 0) {
            return;
        }
        if (i2 == 0) {
            view.setBackgroundColor(OplusGLSurfaceView_13);
            return;
        }
        view.animate().cancel();
        Drawable background = view.getBackground();
        final int alpha = background != null ? background.getAlpha() : 0;
        final int iAlpha = Color.alpha(OplusGLSurfaceView_13) - alpha;
        if (iAlpha == 0) {
            return;
        }
        view.animate().setInterpolator(interpolator).setListener(animatorListener).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.util.Util.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float COUIBaseListPopupWindow_12 = (Float) valueAnimator.getAnimatedValue();
                View view2 = view;
                if (view2 != null) {
                    view2.setBackgroundColor(Color.argb(alpha + ((int) (iAlpha * COUIBaseListPopupWindow_12.floatValue())), Color.red(OplusGLSurfaceView_13), Color.green(OplusGLSurfaceView_13), Color.blue(OplusGLSurfaceView_13)));
                }
            }
        }).setDuration(i2).start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24270a(View view, int OplusGLSurfaceView_13, Animation.AnimationListener animationListener, long OplusGLSurfaceView_15) {
        m24271a(view, OplusGLSurfaceView_13, animationListener, OplusGLSurfaceView_15, 0L, (Interpolator) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24271a(View view, int OplusGLSurfaceView_13, Animation.AnimationListener animationListener, long OplusGLSurfaceView_15, long j2, Interpolator interpolator) {
        m24272a(view, OplusGLSurfaceView_13, animationListener, OplusGLSurfaceView_15, j2, interpolator, 0.0f, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24272a(View view, int OplusGLSurfaceView_13, Animation.AnimationListener animationListener, long OplusGLSurfaceView_15, long j2, Interpolator interpolator, float COUIBaseListPopupWindow_12, float f2) {
        AlphaAnimation alphaAnimation;
        TranslateAnimation translateAnimation;
        if (view == null || view.getVisibility() == OplusGLSurfaceView_13) {
            return;
        }
        if (8 == OplusGLSurfaceView_13 && 4 == view.getVisibility()) {
            return;
        }
        if (4 == OplusGLSurfaceView_13 && 8 == view.getVisibility()) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        if (OplusGLSurfaceView_13 == 0) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        animationSet.addAnimation(alphaAnimation);
        if (OplusGLSurfaceView_13 == 0) {
            translateAnimation = new TranslateAnimation(COUIBaseListPopupWindow_12, 0.0f, f2, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(0.0f, COUIBaseListPopupWindow_12, 0.0f, f2);
        }
        animationSet.addAnimation(translateAnimation);
        if (animationListener == null) {
            view.setVisibility(OplusGLSurfaceView_13);
        }
        if (interpolator != null) {
            animationSet.setInterpolator(interpolator);
        }
        animationSet.setAnimationListener(animationListener);
        animationSet.setDuration(OplusGLSurfaceView_15);
        animationSet.setStartOffset(j2);
        view.clearAnimation();
        view.startAnimation(animationSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24267a(View view, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2, Interpolator interpolator, long OplusGLSurfaceView_15, Interpolator interpolator2, long j2, Animation.AnimationListener animationListener, long j3) {
        AlphaAnimation alphaAnimation;
        TranslateAnimation translateAnimation;
        if (view == null || view.getVisibility() == OplusGLSurfaceView_13) {
            return;
        }
        if (8 == OplusGLSurfaceView_13 && 4 == view.getVisibility()) {
            return;
        }
        if (4 == OplusGLSurfaceView_13 && 8 == view.getVisibility()) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        if (OplusGLSurfaceView_13 == 0) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        if (interpolator != null) {
            alphaAnimation.setInterpolator(interpolator);
        }
        alphaAnimation.setDuration(OplusGLSurfaceView_15);
        animationSet.addAnimation(alphaAnimation);
        if (OplusGLSurfaceView_13 == 0) {
            translateAnimation = new TranslateAnimation(COUIBaseListPopupWindow_12, 0.0f, f2, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(0.0f, COUIBaseListPopupWindow_12, 0.0f, f2);
        }
        if (interpolator2 != null) {
            animationSet.setInterpolator(interpolator2);
        }
        translateAnimation.setDuration(j2);
        animationSet.addAnimation(translateAnimation);
        if (animationListener == null) {
            view.setVisibility(OplusGLSurfaceView_13);
        }
        animationSet.setAnimationListener(animationListener);
        animationSet.setStartOffset(j3);
        view.clearAnimation();
        view.startAnimation(animationSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24274a(final View view, final boolean z, float COUIBaseListPopupWindow_12, float f2, TimeInterpolator timeInterpolator, long OplusGLSurfaceView_15, TimeInterpolator timeInterpolator2, long j2, Animator.AnimatorListener animatorListener, long j3) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        Animator.AnimatorListener animatorListener2 = animatorListener;
        CameraLog.m12954a("Util", "setViewVisibilityWithAnimator, view: " + view + ", visible: " + z + ", listener: " + animatorListener2);
        if (view == null) {
            return;
        }
        if (f22991ax.get(Integer.valueOf(view.getId())) != null) {
            f22991ax.get(Integer.valueOf(view.getId())).end();
            f22991ax.remove(Integer.valueOf(view.getId()));
        }
        if (z) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        }
        ObjectAnimator objectAnimator = objectAnimatorOfFloat;
        objectAnimator.setInterpolator(timeInterpolator);
        objectAnimator.setDuration(OplusGLSurfaceView_15);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builderPlay = animatorSet.play(objectAnimator);
        final float translationX = view.getTranslationX();
        final float translationY = view.getTranslationY();
        view.setTag(com.oplus.camera.R.id_renamed.animating_view_translation, new PointF(translationX, translationY));
        if (z) {
            if (0.0f != COUIBaseListPopupWindow_12) {
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", translationX + COUIBaseListPopupWindow_12, translationX);
            } else {
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", translationY + f2, translationY);
            }
        } else if (0.0f != COUIBaseListPopupWindow_12) {
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", translationX, translationX + COUIBaseListPopupWindow_12);
        } else {
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", translationY, translationY + f2);
        }
        ObjectAnimator objectAnimator2 = objectAnimatorOfFloat2;
        objectAnimator2.setInterpolator(timeInterpolator2);
        objectAnimator2.setDuration(j2);
        builderPlay.with(objectAnimator2);
        animatorSet.setStartDelay(j3);
        final boolean zIsClickable = view.isClickable();
        if (animatorListener2 == null) {
            animatorListener2 = new AnimatorListenerAdapter() { // from class: com.oplus.camera.util.Util.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (z) {
                        view.setAlpha(0.0f);
                    } else {
                        view.setAlpha(1.0f);
                    }
                    view.setVisibility(0);
                    view.setClickable(false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    CameraLog.m12954a("Util", "onAnimationCancel, view: " + view + ", visible: " + z);
                    view.setVisibility(z ? 0 : 8);
                    view.setAlpha(z ? 1.0f : 0.0f);
                    Object tag = view.getTag(com.oplus.camera.R.id_renamed.animating_view_translation);
                    if (tag instanceof PointF) {
                        PointF pointF = (PointF) tag;
                        view.setTranslationX(pointF.x);
                        view.setTranslationY(pointF.y);
                    } else {
                        view.setTranslationX(translationX);
                        view.setTranslationY(translationY);
                    }
                    view.setClickable(zIsClickable);
                    Util.f22991ax.remove(Integer.valueOf(view.getId()));
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CameraLog.m12954a("Util", "onAnimationEnd, view: " + view + ", visible: " + z);
                    if (!z) {
                        view.setVisibility(4);
                    }
                    view.setAlpha(z ? 1.0f : 0.0f);
                    Object tag = view.getTag(com.oplus.camera.R.id_renamed.animating_view_translation);
                    if (tag instanceof PointF) {
                        PointF pointF = (PointF) tag;
                        view.setTranslationX(pointF.x);
                        view.setTranslationY(pointF.y);
                    } else {
                        view.setTranslationX(translationX);
                        view.setTranslationY(translationY);
                    }
                    Util.f22991ax.remove(Integer.valueOf(view.getId()));
                    view.setClickable(zIsClickable);
                }
            };
        }
        f22991ax.put(Integer.valueOf(view.getId()), animatorSet);
        animatorSet.addListener(animatorListener2);
        animatorSet.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24264a(View view, float COUIBaseListPopupWindow_12, float f2, long OplusGLSurfaceView_15, long j2, Animation.AnimationListener animationListener, Interpolator interpolator) {
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(COUIBaseListPopupWindow_12, f2);
        alphaAnimation.setAnimationListener(animationListener);
        alphaAnimation.setDuration(OplusGLSurfaceView_15);
        alphaAnimation.setStartOffset(j2);
        if (interpolator != null) {
            alphaAnimation.setInterpolator(interpolator);
        }
        view.startAnimation(alphaAnimation);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24265a(View view, float COUIBaseListPopupWindow_12, float f2, long OplusGLSurfaceView_15, Animation.AnimationListener animationListener, Interpolator interpolator) {
        m24264a(view, COUIBaseListPopupWindow_12, f2, OplusGLSurfaceView_15, 0L, animationListener, interpolator);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24263a(View view) {
        m24266a(view, 400);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24266a(View view, int OplusGLSurfaceView_13) {
        if (view == null) {
            return;
        }
        m24265a(view, 0.0f, 1.0f, OplusGLSurfaceView_13, (Animation.AnimationListener) null, (Interpolator) null);
        view.setEnabled(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24273a(View view, int OplusGLSurfaceView_13, Interpolator interpolator) {
        if (view == null) {
            return;
        }
        m24265a(view, 0.0f, 1.0f, OplusGLSurfaceView_13, (Animation.AnimationListener) null, interpolator);
        view.setEnabled(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24387b(View view) {
        m24388b(view, 400);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24388b(View view, int OplusGLSurfaceView_13) {
        m24268a(view, OplusGLSurfaceView_13, 0, (Interpolator) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24268a(View view, int OplusGLSurfaceView_13, int i2, Interpolator interpolator) {
        if (view != null && view.getVisibility() == 0) {
            view.setEnabled(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(OplusGLSurfaceView_13);
            alphaAnimation.setStartOffset(i2);
            if (interpolator != null) {
                alphaAnimation.setInterpolator(interpolator);
            }
            view.startAnimation(alphaAnimation);
            view.setVisibility(8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Bitmap m24410c(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(bitmap.getWidth(), 0.0f);
        try {
            Bitmap bitmapM24221a = m24221a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapM24221a) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapM24221a;
        } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return bitmap;
        }
    }

    /* renamed from: s */
    public static void m24493s() {
        synchronized (f22943H) {
            if (f22951P != null) {
                f22951P.clear();
                f22951P = null;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24309a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        if (bArr == null) {
            CameraLog.m12967f("Util", "cutYUV420SP, Error: data is null!");
            return null;
        }
        int i4 = OplusGLSurfaceView_13 * i2;
        if (bArr.length < i4 * 1.5f) {
            CameraLog.m12967f("Util", "cutYUV420SP, Error, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", data.length: " + bArr.length);
            return null;
        }
        int i5 = (OplusGLSurfaceView_13 - (OplusGLSurfaceView_13 % i3)) / i3;
        int i6 = (i2 - (i2 % i3)) / i3;
        if (i6 % 2 != 0) {
            i6++;
        }
        byte[] bArr2 = new byte[((i5 * i6) * 3) / 2];
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i8;
            for (int i10 = 0; i10 < i5; i10++) {
                bArr2[i9] = bArr[(i7 * i3 * OplusGLSurfaceView_13) + (i10 * i3)];
                i9++;
            }
            i7++;
            i8 = i9;
        }
        int i11 = 0;
        while (i11 < i6 / 2) {
            int i12 = i8;
            for (int i13 = 0; i13 < i5 / 2; i13++) {
                int i14 = (i11 * i3 * OplusGLSurfaceView_13) + i4;
                int i15 = i13 * 2 * i3;
                bArr2[i12] = bArr[i14 + i15];
                int i16 = i12 + 1;
                bArr2[i16] = bArr[i14 + i15 + 1];
                i12 = i16 + 1;
            }
            i11++;
            i8 = i12;
        }
        return bArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int[] m24425c(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("Util", "decodeYUV420SP, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        int i3 = OplusGLSurfaceView_13 * i2;
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = 0;
            int i7 = 0;
            int i8 = ((i4 >> 1) * OplusGLSurfaceView_13) + i3;
            int i9 = i5;
            int i10 = 0;
            while (i10 < OplusGLSurfaceView_13) {
                int i11 = (bArr[i9] & 255) - 16;
                if (i11 < 0) {
                    i11 = 0;
                }
                if ((i10 & 1) == 0) {
                    int i12 = i8 + 1;
                    int i13 = (bArr[i8] & 255) - 128;
                    int i14 = i12 + 1;
                    i6 = (bArr[i12] & 255) - 128;
                    i7 = i13;
                    i8 = i14;
                }
                int i15 = (i11 + 10) * 1192;
                int i16 = (i7 * 1634) + i15;
                int i17 = (i15 - (i7 * 833)) - (i6 * 400);
                int i18 = i15 + (i6 * 2066);
                int i19 = 262143;
                if (i16 < 0) {
                    i16 = 0;
                } else if (i16 > 262143) {
                    i16 = 262143;
                }
                if (i17 < 0) {
                    i17 = 0;
                } else if (i17 > 262143) {
                    i17 = 262143;
                }
                if (i18 < 0) {
                    i19 = 0;
                } else if (i18 <= 262143) {
                    i19 = i18;
                }
                iArr[i9] = (-16777216) | ((i16 << 6) & 16711680) | ((i17 >> 2) & 65280) | ((i19 >> 10) & 255);
                i10++;
                i9++;
            }
            i4++;
            i5 = i9;
        }
        CameraLog.m12954a("Util", "decodeYUV420SP X");
        return iArr;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m24400b(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CameraLog.m12954a("Util", "yuvDropPadding, nv21: " + bArr + ", width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", stride: " + i3 + ", scanLine: " + i4);
        if (OplusGLSurfaceView_13 == i3 && i2 == i4) {
            return bArr;
        }
        if (i4 > i2) {
            bArr = m24424c(bArr, i3, i2, i4);
        }
        return i3 > OplusGLSurfaceView_13 ? m24399b(bArr, OplusGLSurfaceView_13, i2, i3) : bArr;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static byte[] m24399b(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        byte[] bArr2 = new byte[((i2 * OplusGLSurfaceView_13) * 3) >> 1];
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            System.arraycopy(bArr, i4, bArr2, i5, OplusGLSurfaceView_13);
            i5 += OplusGLSurfaceView_13;
            i4 += i3;
        }
        return bArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static byte[] m24424c(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = i2 * OplusGLSurfaceView_13;
        int i5 = OplusGLSurfaceView_13 * i3;
        int i6 = (i4 * 3) >> 1;
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        System.arraycopy(bArr, i5, bArr2, i4, i6 - i4);
        return bArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m24432d(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 * i2;
        int i4 = (i3 * 3) >> 1;
        while (i3 < i4) {
            byte b2 = bArr[i3];
            int i5 = i3 + 1;
            bArr[i3] = bArr[i5];
            bArr[i5] = b2;
            i3 += 2;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static byte[] m24444e(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 * i2;
        byte[] bArr2 = new byte[(i3 * 3) >> 1];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        int i4 = i3 - 1;
        int i5 = (i3 * 5) / 4;
        int i6 = 0;
        for (int i7 = 0; i7 < i3 / 2; i7 += 2) {
            bArr2[i3 + i6] = bArr[i4 + i7];
            bArr2[i5 + i6] = bArr[i3 + i7];
            i6++;
        }
        return bArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m24375b(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z) {
        CameraLog.m12954a("Util", "yuvToBitmap, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", orientation: " + i3 + ", scale: " + i4 + ", mirror: " + z);
        int i5 = i2 / i4;
        if (i5 % 2 != 0) {
            i5++;
        }
        byte[] bArrM24309a = m24309a(bArr, OplusGLSurfaceView_13, i2, i4);
        if (bArrM24309a == null) {
            return null;
        }
        int i6 = OplusGLSurfaceView_13 / i4;
        Bitmap bitmapM24222a = m24222a(m24225a(m24425c(bArrM24309a, i6, i5), i6, i5, Bitmap.Config.ARGB_8888), i3, z);
        CameraLog.m12954a("Util", "yuvToBitmap X, bitmap width: " + bitmapM24222a.getWidth() + ", height: " + bitmapM24222a.getHeight());
        return bitmapM24222a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24219a(Bitmap bitmap, float COUIBaseListPopupWindow_12) {
        Bitmap bitmapM24215a;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        synchronized (f22942G) {
            if (f22949N == null) {
                f22949N = RenderScript.create(f22945J);
            }
            if (f22950O == null) {
                f22950O = ScriptIntrinsicBlur.create(f22949N, Element.U8_4(f22949N));
            }
            System.currentTimeMillis();
            f22950O.setRadius(COUIBaseListPopupWindow_12);
            bitmapM24215a = m24215a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(f22949N, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(f22949N, bitmapM24215a);
            f22950O.setInput(allocationCreateFromBitmap);
            f22950O.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapM24215a);
            allocationCreateFromBitmap.destroy();
            allocationCreateFromBitmap2.destroy();
        }
        return bitmapM24215a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24276a(BasicTexture abstractC2752c, String str) throws IOException {
        CameraLog.m12967f("Util", "dumpAndSaveTexture, dumpDir: " + str);
        m24262a(m24409c(abstractC2752c.m13934e(), abstractC2752c.m13937h(), abstractC2752c.m13938i()), str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24252a(int OplusGLSurfaceView_13, int i2, int i3, String str) throws IOException {
        CameraLog.m12967f("Util", "dumpAndSaveTexture, dumpDir: " + str);
        m24262a(m24409c(OplusGLSurfaceView_13, i2, i3), str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Bitmap m24409c(int OplusGLSurfaceView_13, int i2, int i3) {
        int[] iArr = new int[1];
        Bitmap bitmapM24215a = m24215a(i2, i3, Bitmap.Config.ARGB_8888);
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, OplusGLSurfaceView_13, 0);
        new FormatConverter().glReadPixelsToBitmap(bitmapM24215a, i2, i3, 6408, 5121);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return bitmapM24215a;
    }

    /* renamed from: aZ */
    private static String m24337aZ() {
        String strM24461i = m24461i("ro.vendor.oplus.market.watermark");
        CameraLog.m12967f("Util", "getVendorMarketName, marketName: " + strM24461i);
        if (!TextUtils.equals(strM24461i, "")) {
            return strM24461i;
        }
        String strM24461i2 = m24461i("ro.vendor.oplus.market.enname");
        return TextUtils.equals(strM24461i2, "") ? m24461i("ro.vendor.oplus.market.name") : strM24461i2;
    }

    /* renamed from: t */
    public static boolean m24495t() {
        if (f22964aB == null) {
            f22964aB = (WindowManager) f22945J.getSystemService("window");
            Point point = new Point();
            f22964aB.getDefaultDisplay().getRealSize(point);
            f22966aD = 988 == Math.min(point.x, point.y) || 1920 == Math.max(point.x, point.y);
        }
        return f22966aD;
    }

    /* renamed from: u */
    public static boolean m24498u() {
        if (!m24495t()) {
            return false;
        }
        if (f22964aB == null) {
            f22964aB = (WindowManager) f22945J.getSystemService("window");
        }
        Point point = new Point();
        f22964aB.getDefaultDisplay().getRealSize(point);
        return 988 != Math.min(point.x, point.y);
    }

    /* renamed from: v */
    public static String m24499v() {
        String str = f23018z;
        if (str != null) {
            return str;
        }
        f23018z = m24337aZ();
        if (!TextUtils.isEmpty(f23018z)) {
            return f23018z;
        }
        f23018z = m24461i("ro.vendor.oplus.market.enname");
        if (TextUtils.equals(f23018z, "")) {
            f23018z = m24461i("ro.vendor.oplus.market.name");
            if (TextUtils.equals(f23018z, "")) {
                f23018z = Build.MODEL;
            }
        }
        return f23018z;
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0059: MOVE (r1 I:??[long, double]) = (r9 I:??[long, double]), block:B:30:0x0058 */
    /* renamed from: w */
    public static long[] m24502w() throws Throwable {
        long OplusGLSurfaceView_15;
        FileReader fileReader;
        long j2;
        long j3;
        BufferedReader bufferedReader;
        int OplusGLSurfaceView_13;
        long j4 = -1;
        try {
            fileReader = new FileReader("/proc/meminfo");
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
            OplusGLSurfaceView_15 = -1;
        }
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(fileReader, 8192);
                } catch (Exception e2) {
                    COUIBaseListPopupWindow_8 = e2;
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return new long[]{OplusGLSurfaceView_15, j4};
                }
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.readLine();
                    String line2 = bufferedReader.readLine();
                    OplusGLSurfaceView_15 = (line == null ? 0 : Integer.parseInt(line.split("\\s+")[1])) * 1024;
                    if (line2 == null) {
                        OplusGLSurfaceView_13 = 0;
                    } else {
                        try {
                            OplusGLSurfaceView_13 = Integer.parseInt(line2.split("\\s+")[1]);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    j4 = OplusGLSurfaceView_13 * 1024;
                    bufferedReader.close();
                    fileReader.close();
                    return new long[]{OplusGLSurfaceView_15, j4};
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                j2 = -1;
                try {
                    try {
                        fileReader.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                    throw th;
                } catch (Exception e3) {
                    COUIBaseListPopupWindow_8 = e3;
                    OplusGLSurfaceView_15 = j4;
                    j4 = j2;
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return new long[]{OplusGLSurfaceView_15, j4};
                }
            }
        } catch (Throwable th6) {
            th = th6;
            j2 = -1;
            j4 = j3;
            fileReader.close();
            throw th;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static ActivityManager.MemoryInfo m24452g(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
        } catch (Exception unused) {
        }
        CameraLog.m12967f("Util", "getMemoryInfo, mi.totalMem" + memoryInfo.totalMem + ", mi.availMem: " + memoryInfo.availMem);
        return memoryInfo;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static boolean m24458h(Context context) {
        return STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 >= m24452g(context).totalMem;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static boolean m24463i(Context context) {
        return 3221225472L >= m24452g(context).totalMem;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static void m24467j(Context context) {
        if (m24463i(context)) {
            f22996d = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_LOW_MEMORY_MAX_BURST_SHOT_NUM);
        } else {
            f22996d = 20;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static long m24468k(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
        } catch (Exception unused) {
        }
        CameraLog.m12967f("Util", "getAvailMemory, mi.availMem: " + memoryInfo.availMem);
        return memoryInfo.availMem;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24208a(Context context, float COUIBaseListPopupWindow_12) {
        return (int) ((COUIBaseListPopupWindow_12 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static Typeface m24473l(Context context) {
        if (f22937B == null) {
            f22937B = m24226a(context, false);
        }
        return f22937B;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m24226a(Context context, boolean z) {
        Typeface typefaceBuild;
        Typeface typeface = Typeface.DEFAULT;
        try {
            OplusBaseConfiguration oplusBaseConfiguration = (OplusBaseConfiguration) OplusTypeCastingHelper.typeCasting(OplusBaseConfiguration.class, context.getResources().getConfiguration());
            int OplusGLSurfaceView_13 = (oplusBaseConfiguration.mOplusExtraConfiguration.mFontVariationSettings & 61440) >> 12;
            int i2 = oplusBaseConfiguration.mOplusExtraConfiguration.mFontVariationSettings & 4095;
            if (OplusFontUtils.isFlipFontUsed) {
                return typeface;
            }
            int i3 = 700;
            try {
                if (OplusGLSurfaceView_13 != 0) {
                    Typeface.Builder fontVariationSettings = new Typeface.Builder("sys-sans-en").setFontVariationSettings("'wght' " + i2);
                    if (!z) {
                        i3 = 400;
                    }
                    typefaceBuild = fontVariationSettings.setWeight(i3).build();
                } else {
                    Typeface.Builder builder = new Typeface.Builder("sys-sans-en");
                    if (!z) {
                        i3 = 400;
                    }
                    typefaceBuild = builder.setWeight(i3).build();
                }
                typeface = typefaceBuild;
                return typeface;
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return typeface;
            }
        } catch (NoSuchFieldError | NoSuchMethodError e2) {
            CameraLog.m12967f("Util", "getFontTypeface, error: " + e2.getMessage());
            return typeface;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Typeface m24411c(boolean z) {
        Typeface typeface = Typeface.DEFAULT;
        if (z) {
            try {
                return Typeface.create("sys-sans-en", 1);
            } catch (RuntimeException unused) {
                CameraLog.m12966e("Util", "getSansEnTypeface, Create Typeface from /system/fonts/SysSans-En-Medium.otf failed!");
                return Typeface.DEFAULT_BOLD;
            }
        }
        try {
            return Typeface.create("sys-sans-en", 0);
        } catch (RuntimeException unused2) {
            CameraLog.m12966e("Util", "getSansEnTypeface, Create Typeface from /system/fonts/SysSans-En-Regular.otf failed!");
            return Typeface.DEFAULT;
        }
    }

    /* renamed from: x */
    public static Typeface m24503x() {
        Typeface typeface = f22968aa;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 550");
            f22968aa = builder.build();
        } catch (Exception unused) {
            f22968aa = Typeface.DEFAULT;
            CameraLog.m12967f("Util", "getSansEnRegularTypeface, create special typeface fail");
        }
        return f22968aa;
    }

    /* renamed from: y */
    public static Typeface m24505y() {
        Typeface typeface = f22960Y;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 350");
            f22960Y = builder.build();
        } catch (Exception unused) {
            f22960Y = Typeface.DEFAULT;
            CameraLog.m12967f("Util", "getSansEnLightTypeface, create special typeface fail");
        }
        return f22960Y;
    }

    /* renamed from: z */
    public static Typeface m24507z() {
        Typeface typeface = f22956U;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 350");
            f22956U = builder.build();
        } catch (Exception unused) {
            f22956U = Typeface.DEFAULT;
            CameraLog.m12967f("Util", "getSansEnLightTypeface, create 350 weight sans typeface fail");
        }
        return f22956U;
    }

    /* renamed from: A */
    public static Typeface m24165A() {
        Typeface typeface = f22961Z;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("sys-sans-en");
            builder.setFontVariationSettings("'wght' 750");
            f22961Z = builder.build();
        } catch (Exception unused) {
            f22961Z = Typeface.DEFAULT;
            CameraLog.m12967f("Util", "getSansEnMediumTypeface, create special typeface fail");
        }
        return f22961Z;
    }

    /* renamed from: B */
    public static void m24166B() {
        f22937B = null;
        f22938C = null;
        f22939D = null;
        f22993az = null;
        f22963aA = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24250a(byte[] bArr, String str, String str2) {
        CameraLog.m12954a("Util", "saveBytesToFile, bytes: " + bArr + ", customDir: " + str + ", fileName: " + str2);
        if (bArr == null || bArr.length == 0) {
            CameraLog.m12967f("Util", "saveBytesToJpeg, bytes is empty");
            return null;
        }
        String absolutePath = new File(f22945J.getExternalFilesDir(str).getAbsolutePath(), str2).getAbsolutePath();
        if (DocumentUtil.m16203b(absolutePath, "image/jpeg", bArr)) {
            return absolutePath;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24307a(File file) {
        return DocumentUtil.m16208d(file.getAbsolutePath());
    }

    /* renamed from: C */
    public static boolean m24169C() {
        return f23017y;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m24431d(boolean z) {
        f23017y = z;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static boolean m24478m(Context context) {
        try {
            Display displayM24900a = ContextNative.m24900a(context);
            if (displayM24900a != null) {
                return WindowManagerNative.hasNavigationBar(displayM24900a.getDisplayId());
            }
            return false;
        } catch (RemoteException | UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24301a(Object[] objArr) {
        return objArr == null || objArr.length <= 0;
    }

    /* renamed from: D */
    public static boolean m24170D() {
        return f23009q;
    }

    /* renamed from: E */
    public static boolean m24173E() {
        String str = f22940E;
        return str == null || TextUtils.isEmpty(str) || "surround_record=ozo".equals(f22940E);
    }

    /* renamed from: F */
    public static boolean m24175F() {
        return "surround_record=lvacfs".equals(f22940E);
    }

    /* renamed from: G */
    public static boolean m24176G() {
        return "vendor_audiorecord_track_support=true".equals(f22941F);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24292a(Size size) {
        return m24418c(m24426d(size.getWidth(), size.getHeight()));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24383b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("Util", "setSizeRatioType, type: " + OplusGLSurfaceView_13);
        f23000h = OplusGLSurfaceView_13;
    }

    /* renamed from: H */
    public static int m24178H() {
        return f23000h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24386b(Size size) {
        CameraLog.m12959b("Util", "setPreviewSize, size: " + size);
        f22992ay = size;
    }

    /* renamed from: I */
    public static Size m24180I() {
        return f22992ay;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m24426d(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == 0 || i2 == 0) {
            return -1;
        }
        double IntrinsicsJvm.kt_5 = OplusGLSurfaceView_13 / i2;
        if (Math.abs(IntrinsicsJvm.kt_5 - 1.3333333333333333d) < 0.01d) {
            return 0;
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 1.7777777777777777d) < 0.01d) {
            return 1;
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 1.0d) < 0.01d) {
            return 2;
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 1.5d) < 0.01d) {
            return 3;
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 1.2222222222222223d) < 0.01d) {
            return 4;
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 0.9333333333333333d) < 0.01d) {
            return 6;
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 2.3333333333333335d) < 0.01d) {
            return 7;
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - m24196X()) >= 0.01d) {
            return (!m24350am() || Math.abs(IntrinsicsJvm.kt_5 - m24196X()) >= 0.03d) ? -1 : 5;
        }
        return 5;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m24418c(int OplusGLSurfaceView_13) {
        return !(OplusGLSurfaceView_13 != 1 || f23010r || m24495t()) || OplusGLSurfaceView_13 == 5;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m24420c(Size size) {
        return m24434d(m24426d(size.getWidth(), size.getHeight()));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24384b(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        int OplusGLSurfaceView_13 = !m24498u() ? 1 : 0;
        if (requestedOrientation != OplusGLSurfaceView_13) {
            CameraLog.m12954a("Util", "setRequestedOrientation: " + requestedOrientation + " -> " + OplusGLSurfaceView_13);
            activity.setRequestedOrientation(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m24439e(int OplusGLSurfaceView_13) {
        if (f23001i != OplusGLSurfaceView_13) {
            CameraLog.m12959b("Util", "setFolderAngle, sFoldAngle: " + f23001i + ", current: " + OplusGLSurfaceView_13);
        }
        f22965aC = OplusGLSurfaceView_13;
        f23001i = OplusGLSurfaceView_13;
    }

    /* renamed from: com.oplus.camera.util.Util$PlatformImplementations.kt_3 */
    private static class C3539a {

        /* renamed from: PlatformImplementations.kt_3 */
        private String f23037a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private SimpleDateFormat f23038b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f23039c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f23040d;

        public C3539a(String str) {
            this.f23037a = str;
            this.f23038b = new SimpleDateFormat(this.f23037a, Locale.US);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m24511a() {
            String str = this.f23037a;
            if (str != null) {
                this.f23038b = new SimpleDateFormat(str, Locale.US);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m24510a(long OplusGLSurfaceView_15, boolean z) {
            Date date = new Date(OplusGLSurfaceView_15);
            String str = this.f23038b.format(date);
            if (z) {
                if (OplusGLSurfaceView_15 / 1000 != this.f23039c / 1000) {
                    this.f23039c = OplusGLSurfaceView_15;
                    this.f23040d = 0;
                }
                if (this.f23040d < 10) {
                    str = str + "_BURST00" + this.f23040d;
                } else {
                    str = str + "_BURST0" + this.f23040d;
                }
                if (this.f23040d == 0) {
                    str = str + "_COVER";
                }
                this.f23040d++;
            } else if (OplusGLSurfaceView_15 / 1000 == this.f23039c / 1000) {
                this.f23040d++;
                if (this.f23040d < 10) {
                    str = str + "_0" + this.f23040d;
                } else {
                    str = str + "_" + this.f23040d;
                }
            } else {
                this.f23039c = OplusGLSurfaceView_15;
                this.f23040d = 0;
            }
            if (!Util.m24350am() || !z || !Util.m24322aK()) {
                return str;
            }
            String str2 = new SimpleDateFormat("'IMG_'yyyyMMdd'_'HHmmss", Locale.US).format(date);
            if (OplusGLSurfaceView_15 / 1000 != this.f23039c / 1000) {
                this.f23039c = OplusGLSurfaceView_15;
                this.f23040d = 0;
            }
            if (this.f23040d < 10) {
                return str2 + "_00" + this.f23040d;
            }
            return str2 + "_0" + this.f23040d;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m24509a(long OplusGLSurfaceView_15) {
            return this.f23038b.format(new Date(OplusGLSurfaceView_15));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m24365b(byte[] bArr, int OplusGLSurfaceView_13) {
        if (bArr == null) {
            return 0.0f;
        }
        return Float.intBitsToFloat((int) ((bArr[OplusGLSurfaceView_13 + 3] << 24) | (((int) ((((int) ((bArr[OplusGLSurfaceView_13 + 0] & 255) | (bArr[OplusGLSurfaceView_13 + 1] << 8))) & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN) | (bArr[OplusGLSurfaceView_13 + 2] << 16))) & 16777215)));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int m24447f(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0 || bArr == null) {
            CameraLog.m12967f("Util", "parseDataByteToInt, from index or data is error!");
            return 0;
        }
        if (bArr.length < i2) {
            CameraLog.m12967f("Util", "parseDataByteToInt, to index is error!");
            return 0;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        while (OplusGLSurfaceView_13 <= i2) {
            StringBuffer stringBuffer2 = new StringBuffer(Integer.toBinaryString(bArr[OplusGLSurfaceView_13]));
            if (stringBuffer2.length() > 8) {
                stringBuffer2 = new StringBuffer(stringBuffer2.substring(stringBuffer2.length() - 8));
            } else if (stringBuffer2.length() < 8) {
                while (stringBuffer2.length() < 8) {
                    StringBuffer stringBuffer3 = new StringBuffer("0");
                    stringBuffer3.append(stringBuffer2);
                    stringBuffer2 = stringBuffer3;
                }
            }
            stringBuffer2.append(stringBuffer);
            OplusGLSurfaceView_13++;
            stringBuffer = stringBuffer2;
        }
        return new BigInteger(stringBuffer.toString(), 2).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.media.ExifInterface m24231a(byte[] r4) throws java.io.IOException {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.io.IOException -> L1f
            r1.<init>(r4)     // Catch: java.io.IOException -> L1f
            android.media.ExifInterface r2 = new android.media.ExifInterface     // Catch: java.lang.Throwable -> L15 java.io.IOException -> L1f
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> L1f
            r1.close()     // Catch: java.io.IOException -> L12
            goto L3c
        L12:
            r0 = move-exception
            r1 = r0
            goto L21
        L15:
            r2 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1f
            goto L1e
        L1a:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.io.IOException -> L1f
        L1e:
            throw r2     // Catch: java.io.IOException -> L1f
        L1f:
            r1 = move-exception
            r2 = r0
        L21:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "getExif error, jpeg: "
            r0.append(r3)
            if (r4 != 0) goto L2f
            r4 = -1
            goto L30
        L2f:
            int r4 = r4.length
        L30:
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "Util"
            com.oplus.camera.CameraLog.m12965d(r0, r4, r1)
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.m24231a(byte[]):android.media.ExifInterface");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static ExifInterface m24377b(String str) {
        try {
            return new ExifInterface(str);
        } catch (IOException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("Util", "getExif error, path: " + str, COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Location m24230a(ExifInterface exifInterface) {
        if (exifInterface == null) {
            return null;
        }
        if (!exifInterface.getLatLong(new float[2])) {
            return null;
        }
        Location location = new Location(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
        location.setLatitude(r1[0]);
        location.setLongitude(r1[1]);
        return location;
    }

    /* renamed from: J */
    public static void m24182J() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Display defaultDisplay = ((WindowManager) f22945J.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        CameraLog.m12967f("Util", "initScreenHeightWidth, point: " + point.toString());
        if (m24498u()) {
            CameraLog.m12967f("Util", "initScreenHeightWidth, open");
            f22970ac = Math.min(point.x, point.y);
            f22969ab = Math.max(point.x, point.y);
            boolean zContains = f22945J.getResources().getConfiguration().toString().contains("oplus-magic-windows");
            CameraLog.m12967f("Util", "initScreenHeightWidth, isInMagicWindow: " + zContains);
            if (zContains) {
                try {
                    Object objInvoke = DisplayManager.class.getDeclaredMethod("getStableDisplaySize", new Class[0]).invoke((DisplayManager) f22945J.getSystemService("display"), new Object[0]);
                    if (objInvoke instanceof Point) {
                        Point point2 = (Point) objInvoke;
                        f22970ac = Math.min(point2.x, point2.y);
                        f22969ab = Math.max(point2.x, point2.y);
                    }
                    CameraLog.m12967f("Util", "initScreenHeightWidth, sScreenHeight: " + f22970ac + ", sScreenWidth: " + f22969ab);
                    return;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return;
                }
            }
            return;
        }
        CameraLog.m12967f("Util", "initScreenHeightWidth, fold");
        f22970ac = Math.max(point.x, point.y);
        f22969ab = Math.min(point.x, point.y);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static void m24482n(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Resources resources = f22945J.getResources();
        m24182J();
        double IntrinsicsJvm.kt_5 = f22970ac / f22969ab;
        f23010r = IntrinsicsJvm.kt_5 > 1.7777777777777777d;
        f22971ad = resources.getDimensionPixelSize(com.oplus.camera.R.dimen.top_bar_layout_height);
        f22972ae = resources.getDimensionPixelSize(com.oplus.camera.R.dimen.menu_panel_layout_height);
        f22976ai = resources.getDimensionPixelSize(com.oplus.camera.R.dimen.head_line_height);
        f22973af = (int) ((getScreenHeight() - f22972ae) - (getScreenWidth() * 1.3333333333333333d));
        if (m24495t()) {
            f22973af = (int) (((getScreenHeight() - f22972ae) - (getScreenWidth() * 1.3333333333333333d)) + resources.getDimensionPixelSize(com.oplus.camera.R.dimen.control_panel_button_height_fold_offset));
        }
        if (m24478m(context)) {
            f22979al = m24183K();
        }
        if (f23010r) {
            f22974ag = resources.getDimensionPixelSize(com.oplus.camera.R.dimen.control_panel_button_height);
            int OplusGLSurfaceView_13 = f22972ae;
            f22975ah = OplusGLSurfaceView_13;
            f22977aj = OplusGLSurfaceView_13;
            f22978ak = f22979al;
        } else {
            f22974ag = resources.getDimensionPixelSize(com.oplus.camera.R.dimen.control_panel_button_height);
            f22975ah = resources.getDimensionPixelSize(com.oplus.camera.R.dimen.menu_tool_item_size);
            f22977aj = 0;
            f22978ak = 0;
        }
        DimenConstants.m14482a(context);
        CameraLog.m12959b("Util", "initMenuControlPanelHeight, sbLongScreen: " + f23010r + ", isFoldProject: " + m24495t() + ", sSettingMenuPanelHeight: " + f22972ae + ", sControlPanelHeight: " + f22973af + ", sControlPanelButtonHeight: " + f22974ag + ", sSettingMenuItemHeight: " + f22975ah + ", sPreviewMarginTop: " + f22977aj + ", sHeadLineHeight: " + f22976ai + ", sNavigationBarHeight: " + f22979al + ", ratio: " + IntrinsicsJvm.kt_5 + ", screenHeight: " + getScreenHeight());
    }

    /* renamed from: K */
    public static int m24183K() {
        int identifier = f22945J.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return f22945J.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: L */
    public static int m24184L() {
        if (m24495t()) {
            return f22945J.getResources().getDimensionPixelSize(com.oplus.camera.R.dimen.top_margin_1_1);
        }
        return f22945J.getResources().getDimensionPixelSize(com.oplus.camera.R.dimen.top_margin_1_1_normal);
    }

    /* renamed from: M */
    public static int m24185M() {
        return f22945J.getResources().getDimensionPixelSize(com.oplus.camera.R.dimen.top_margin_16_9);
    }

    public static int getSettingMenuPanelHeight() {
        return f22972ae;
    }

    /* renamed from: N */
    public static int m24186N() {
        return f22971ad;
    }

    /* renamed from: O */
    public static int m24187O() {
        return f22973af;
    }

    /* renamed from: P */
    public static int m24188P() {
        return f22974ag;
    }

    /* renamed from: Q */
    public static int m24189Q() {
        return f22975ah;
    }

    /* renamed from: R */
    public static int m24190R() {
        return f22977aj;
    }

    /* renamed from: S */
    public static int m24191S() {
        return f22978ak;
    }

    /* renamed from: T */
    public static int m24192T() {
        return f22976ai;
    }

    public static int getScreenHeight() {
        return f22970ac;
    }

    /* renamed from: U */
    public static int m24193U() {
        return getScreenHeight() - f22979al;
    }

    public static int getScreenWidth() {
        return f22969ab;
    }

    /* renamed from: W */
    public static boolean m24195W() {
        return f23010r;
    }

    /* renamed from: X */
    public static double m24196X() {
        return f22970ac / f22969ab;
    }

    /* renamed from: Y */
    public static int m24197Y() {
        return Math.abs((((double) f22970ac) / ((double) f22969ab)) - 1.7777777777777777d) < 0.01d ? 1 : 5;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m24369b(byte[] bArr) {
        int OplusGLSurfaceView_13;
        int i2;
        if (bArr == null) {
            return 0;
        }
        int i3 = 0;
        while (i3 + 3 < bArr.length) {
            int i4 = i3 + 1;
            if ((bArr[i3] & 255) == 255) {
                int i5 = bArr[i4] & 255;
                if (i5 != 255) {
                    i4++;
                    if (i5 != 216 && i5 != 1) {
                        if (i5 != 217 && i5 != 218) {
                            int iM24214a = m24214a(bArr, i4, 2, false);
                            if (iM24214a < 2 || (i2 = i4 + iM24214a) > bArr.length) {
                                CameraLog.m12967f("Util", "getOrientation, Invalid length");
                                return 0;
                            }
                            if (i5 == 225 && iM24214a >= 8 && m24214a(bArr, i4 + 2, 4, false) == 1165519206 && m24214a(bArr, i4 + 6, 2, false) == 0) {
                                i3 = i4 + 8;
                                OplusGLSurfaceView_13 = iM24214a - 8;
                                break;
                            }
                            i3 = i2;
                        }
                    }
                }
                i3 = i4;
            }
            i3 = i4;
        }
        OplusGLSurfaceView_13 = 0;
        if (OplusGLSurfaceView_13 > 8) {
            int iM24214a2 = m24214a(bArr, i3, 4, false);
            if (iM24214a2 != 1229531648 && iM24214a2 != 1296891946) {
                CameraLog.m12967f("Util", "getOrientation, Invalid byte order");
                return 0;
            }
            boolean z = iM24214a2 == 1229531648;
            int iM24214a3 = m24214a(bArr, i3 + 4, 4, z) + 2;
            if (iM24214a3 < 10 || iM24214a3 > OplusGLSurfaceView_13) {
                CameraLog.m12967f("Util", "getOrientation, Invalid offset");
                return 0;
            }
            int i6 = i3 + iM24214a3;
            int i7 = OplusGLSurfaceView_13 - iM24214a3;
            int iM24214a4 = m24214a(bArr, i6 - 2, 2, z);
            while (true) {
                int i8 = iM24214a4 - 1;
                if (iM24214a4 <= 0 || i7 < 12) {
                    break;
                }
                if (m24214a(bArr, i6, 2, z) == 274) {
                    int iM24214a5 = m24214a(bArr, i6 + 8, 2, z);
                    if (iM24214a5 == 1) {
                        return 0;
                    }
                    if (iM24214a5 == 3) {
                        return 180;
                    }
                    if (iM24214a5 == 6) {
                        return 90;
                    }
                    if (iM24214a5 == 8) {
                        return 270;
                    }
                    CameraLog.m12962c("Util", "getOrientation, Unsupported orientation");
                    return 0;
                }
                i6 += 12;
                i7 -= 12;
                iM24214a4 = i8;
            }
        }
        CameraLog.m12962c("Util", "getOrientation, Orientation not found");
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m24214a(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) {
        int i3;
        if (z) {
            OplusGLSurfaceView_13 += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[OplusGLSurfaceView_13] & 255) | (i4 << 8);
            OplusGLSurfaceView_13 += i3;
            i2 = i5;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static byte[] m24423c(String str) {
        CameraLog.m12954a("Util", "getThumbnail, filepath: " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            if (exifInterface.hasThumbnail()) {
                return exifInterface.getThumbnail();
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24206a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        double dMin = Math.min(OplusGLSurfaceView_13 / i3, i2 / i4);
        float COUIBaseListPopupWindow_12 = 1.0f;
        while (true) {
            float f2 = 2.0f * COUIBaseListPopupWindow_12;
            if (f2 > dMin) {
                return (int) COUIBaseListPopupWindow_12;
            }
            COUIBaseListPopupWindow_12 = f2;
        }
    }

    /* renamed from: Z */
    public static int m24198Z() {
        return f22979al;
    }

    /* renamed from: o */
    public static int m24484o(Context context) throws Settings.SettingNotFoundException {
        int OplusGLSurfaceView_13;
        try {
            OplusGLSurfaceView_13 = Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture");
        } catch (Settings.SettingNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            OplusGLSurfaceView_13 = 0;
        }
        int iM24183K = OplusGLSurfaceView_13 == 0 ? m24183K() : 0;
        CameraLog.m12954a("Util", "getNavigationBarHeight, navBarHeight: " + iM24183K);
        f22979al = iM24183K;
        return iM24183K;
    }

    /* renamed from: p */
    public static boolean m24488p(Context context) {
        return f22979al != m24484o(context);
    }

    /* renamed from: aa */
    public static boolean m24338aa() {
        int OplusGLSurfaceView_13 = Settings.Secure.getInt(f22945J.getContentResolver(), "hide_navigationbar_enable", 0);
        return (2 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13) ? false : true;
    }

    /* renamed from: ab */
    public static boolean m24339ab() {
        return 2 == Settings.Secure.getInt(f22945J.getContentResolver(), "navigation_mode", 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Address m24229a(Context context, Location location, boolean z) throws IOException {
        Geocoder geocoder;
        CameraLog.m12954a("Util", "getAddressFromLocation");
        Address address = null;
        if (location != null && context != null) {
            if (z) {
                geocoder = new Geocoder(context);
            } else {
                geocoder = new Geocoder(context, Locale.ENGLISH);
            }
            try {
                List<Address> fromLocation = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (fromLocation != null && fromLocation.size() > 0) {
                    address = fromLocation.get(0);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("Util", "getAddressFromLocation, Error: " + COUIBaseListPopupWindow_8.getMessage().toString());
            }
            if (address != null) {
                address.setLatitude(location.getLatitude());
                address.setLongitude(location.getLongitude());
            }
        }
        return address;
    }

    /* renamed from: ac */
    public static boolean m24340ac() {
        try {
            return UserHandleNative.myUserId() == 0;
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Util", "getCurrentUser Exception " + COUIBaseListPopupWindow_8);
            return true;
        }
    }

    /* renamed from: ad */
    public static void m24341ad() {
        f22982ao = ActivityManager.isUserAMonkey();
        try {
            f22984aq = m24421c("persist.sys.oplus.autotest.monkeyRunning", false);
        } catch (NoSuchMethodError COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Util", "updateMonkeyRunningState, error: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    /* renamed from: ae */
    public static boolean m24342ae() {
        return f22982ao || f22984aq;
    }

    /* renamed from: af */
    public static boolean m24343af() {
        return f22982ao;
    }

    /* renamed from: ag */
    public static boolean m24344ag() {
        return f22984aq;
    }

    /* renamed from: ah */
    public static boolean m24345ah() {
        return m24421c("sys.oplus.otest.monkey.enable", false);
    }

    /* renamed from: ai */
    public static boolean m24346ai() {
        return m24459h("oplus.software.display.screen_heteromorphism");
    }

    /* renamed from: aj */
    public static int m24347aj() {
        if (m24346ai()) {
            return m24403ba();
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int m24445f(int OplusGLSurfaceView_13) {
        if (!m24349al()) {
            return OplusGLSurfaceView_13;
        }
        switch (OplusGLSurfaceView_13) {
            case com.oplus.camera.R.string.camera_long_exposure_type_busy_traffic /* 2131755557 */:
                break;
            case com.oplus.camera.R.string.camera_long_exposure_type_light_painting /* 2131755559 */:
                break;
            case com.oplus.camera.R.string.camera_long_exposure_type_light_rail_portrait /* 2131755561 */:
                break;
            case com.oplus.camera.R.string.camera_pi_off_hint /* 2131755724 */:
                break;
            case com.oplus.camera.R.string.camera_pi_on_hint /* 2131755728 */:
                break;
            case com.oplus.camera.R.string.camera_pi_title /* 2131755731 */:
                break;
            case com.oplus.camera.R.string.camera_scene_ultra_dark_mode_tips /* 2131755823 */:
                break;
            case com.oplus.camera.R.string.camera_super_eis_pro /* 2131756068 */:
                break;
            case com.oplus.camera.R.string.camera_switch_main /* 2131756079 */:
                break;
            case com.oplus.camera.R.string.camera_switch_ultra_wide /* 2131756084 */:
                break;
            case com.oplus.camera.R.string.camera_switch_ultra_wide_micro_lens /* 2131756085 */:
                break;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: al */
    public static boolean m24349al() {
        return "OPLUS_R".equals(OplusConfigure.m24655e());
    }

    /* renamed from: am */
    public static boolean m24350am() {
        return "OPLUS_P".equals(OplusConfigure.m24655e());
    }

    /* renamed from: an */
    public static boolean m24351an() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HASSELBLAD_WATERMARK);
    }

    /* renamed from: ao */
    public static boolean m24352ao() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_USE_HASSELBLAD_STYLE);
    }

    /* renamed from: ap */
    public static boolean m24353ap() {
        return (m24472l().getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* renamed from: ba */
    private static int m24403ba() {
        int identifier = f22945J.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return f22945J.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m24429d(java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getAssertData, close stream failed!"
            java.lang.String r1 = "Util"
            r2 = 0
            android.content.Context r3 = com.oplus.camera.util.Util.f22945J     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            java.io.InputStream r6 = r3.open(r6)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            int r3 = r6.available()     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            r6.read(r3)     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            java.lang.String r4 = new java.lang.String     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            r4.<init>(r3)     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            if (r6 == 0) goto L26
            r6.close()     // Catch: java.io.IOException -> L23
            goto L26
        L23:
            com.oplus.camera.CameraLog.m12967f(r1, r0)
        L26:
            return r4
        L27:
            r3 = move-exception
            goto L30
        L29:
            r6 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L3e
        L2e:
            r3 = move-exception
            r6 = r2
        L30:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            if (r6 == 0) goto L3c
            r6.close()     // Catch: java.io.IOException -> L39
            goto L3c
        L39:
            com.oplus.camera.CameraLog.m12967f(r1, r0)
        L3c:
            return r2
        L3d:
            r2 = move-exception
        L3e:
            if (r6 == 0) goto L47
            r6.close()     // Catch: java.io.IOException -> L44
            goto L47
        L44:
            com.oplus.camera.CameraLog.m12967f(r1, r0)
        L47:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.m24429d(java.lang.String):java.lang.String");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m24442e(int OplusGLSurfaceView_13, int i2) {
        return m24346ai() && OplusGLSurfaceView_13 != i2 && (OplusGLSurfaceView_13 == 1 || i2 == 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24305a(Image image, int OplusGLSurfaceView_13) {
        return m24306a(image, OplusGLSurfaceView_13, (byte[]) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24306a(Image image, int OplusGLSurfaceView_13, byte[] bArr) {
        if (image == null || image.getFormat() != 35) {
            CameraLog.m12967f("Util", "getYuvDataWithoutPadding, only support YUV_420_888");
            return null;
        }
        int width = image.getWidth();
        int height = image.getHeight();
        int format = image.getFormat();
        Rect cropRect = image.getCropRect();
        int iWidth = ((cropRect.width() * cropRect.height()) * ImageFormat.getBitsPerPixel(format)) / 8;
        if (bArr == null || (bArr != null && bArr.length < iWidth)) {
            bArr = new byte[iWidth];
        }
        Image.Plane[] planes = image.getPlanes();
        int i2 = 0;
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        if (17 == OplusGLSurfaceView_13) {
            buffer2 = planes[2].getBuffer();
        }
        if (image.getPlanes()[0].getRowStride() == image.getWidth()) {
            buffer.get(bArr, 0, buffer.remaining());
            buffer2.get(bArr, buffer.position(), buffer2.remaining());
        } else {
            int rowStride = image.getPlanes()[0].getRowStride() - width;
            int i3 = 0;
            int i4 = 0;
            while (i3 < height) {
                buffer.get(bArr, i4, width);
                if (i3 != height - 1) {
                    buffer.position(buffer.position() + rowStride);
                }
                i3++;
                i4 += width;
            }
            while (true) {
                int i5 = height / 2;
                if (i2 >= i5) {
                    break;
                }
                if (i2 != i5 - 1) {
                    buffer2.get(bArr, i4, width);
                    buffer2.position(buffer2.position() + rowStride);
                } else {
                    buffer2.get(bArr, i4, width - 1);
                }
                i2++;
                i4 += width;
            }
        }
        return bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24298a(List<Size> list, Size size) {
        if (list != null && size != null) {
            for (Size size2 : list) {
                if (size2 != null && size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static float m24456h(int OplusGLSurfaceView_13) {
        return f22945J.getResources().getDimensionPixelSize(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static int m24460i(int OplusGLSurfaceView_13) {
        return f22945J.getResources().getDimensionPixelOffset(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24296a(final View view, final int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, final Animation.AnimationListener animationListener) throws Resources.NotFoundException {
        if (view == null) {
            CameraLog.m12954a("Util", "setViewVisibilityWithAnimation, view: " + view);
            return false;
        }
        int iM24407c = m24407c(view);
        if (iM24407c == OplusGLSurfaceView_13) {
            CameraLog.m12954a("Util", "setViewVisibilityWithAnimation, viewVisibilityOrAnimationTo is same as visibility (" + OplusGLSurfaceView_13 + ")");
            return false;
        }
        if ((8 == OplusGLSurfaceView_13 && 4 == iM24407c) || (4 == OplusGLSurfaceView_13 && 8 == iM24407c)) {
            CameraLog.m12954a("Util", "setViewVisibilityWithAnimation, visibility: " + OplusGLSurfaceView_13 + ", viewVisibilityOrAnimationTo: " + iM24407c);
            return false;
        }
        if (view.getAnimation() != null && !view.getAnimation().hasEnded()) {
            if (z) {
                view.clearAnimation();
            } else {
                CameraLog.m12954a("Util", "setViewVisibilityWithAnimation, view had animation but not cancel");
                return false;
            }
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), i2);
        if (animationLoadAnimation == null) {
            CameraLog.m12954a("Util", "setViewVisibilityWithAnimation, animation: " + animationLoadAnimation);
            return false;
        }
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.util.Util.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationStart(animation);
                    return;
                }
                int i3 = OplusGLSurfaceView_13;
                if (i3 == 0) {
                    view.setVisibility(i3);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationEnd(animation);
                    return;
                }
                int i3 = OplusGLSurfaceView_13;
                if (i3 != 0) {
                    view.setVisibility(i3);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationRepeat(animation);
                }
            }
        });
        view.setTag(com.oplus.camera.R.id_renamed.view_tag_key_animation_visibility, Integer.valueOf(OplusGLSurfaceView_13));
        view.startAnimation(animationLoadAnimation);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m24407c(View view) {
        Animation animation = view.getAnimation();
        if (animation != null && (!animation.hasStarted() || !animation.hasEnded())) {
            Object tag = view.getTag(com.oplus.camera.R.id_renamed.view_tag_key_animation_visibility);
            CameraLog.m12954a("Util", "getViewVisibilityOrAnimationTo, visibilityObj: " + tag);
            return tag == null ? view.getVisibility() : ((Integer) tag).intValue();
        }
        return view.getVisibility();
    }

    /* renamed from: q */
    public static Context m24489q(Context context) {
        if (Build.VERSION.SDK_INT > 23) {
            Configuration configuration = context.getResources().getConfiguration();
            if (f22994b == 0) {
                f22994b = configuration.densityDpi;
            }
            configuration.densityDpi = f22962a;
            CameraLog.m12959b("Util", "setDefaultDisplay, config sDefaultDensity: " + f22962a + ", sysDensityDpi: " + f22994b);
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        return context;
    }

    /* renamed from: r */
    public static Context m24491r(Context context) {
        if (Build.VERSION.SDK_INT > 23) {
            Configuration configuration = context.getResources().getConfiguration();
            if (f22994b != 0) {
                CameraLog.m12959b("Util", "followSystemDisplay, densityDpi: " + configuration.densityDpi + " -> " + f22994b);
                configuration.densityDpi = f22994b;
            }
            if (0.0f != f22995c) {
                CameraLog.m12959b("Util", "followSystemDisplay, fontScale: " + configuration.fontScale + " -> " + f22995c);
                configuration.fontScale = f22995c;
            }
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        return context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24215a(int OplusGLSurfaceView_13, int i2, Bitmap.Config config) {
        return m24437e(Bitmap.createBitmap(OplusGLSurfaceView_13, i2, config));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24221a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2, int i3, int i4, Matrix matrix, boolean z) {
        return m24437e(Bitmap.createBitmap(bitmap, OplusGLSurfaceView_13, i2, i3, i4, matrix, z));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24225a(int[] iArr, int OplusGLSurfaceView_13, int i2, Bitmap.Config config) {
        return m24437e(Bitmap.createBitmap(iArr, OplusGLSurfaceView_13, i2, config));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static Bitmap m24428d(Bitmap bitmap) {
        return m24437e(Bitmap.createBitmap(bitmap));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Bitmap m24437e(Bitmap bitmap) {
        bitmap.setDensity(f22962a);
        return bitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static BitmapDrawable m24227a(Context context, Bitmap bitmap) {
        context.getResources().getDisplayMetrics().densityDpi = f22962a;
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24223a(Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m24372b(Bitmap bitmap, float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        try {
            return m24221a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24220a(Bitmap bitmap, float COUIBaseListPopupWindow_12, Size size, int OplusGLSurfaceView_13) {
        int height;
        int height2;
        int i2;
        int i3;
        if (COUIBaseListPopupWindow_12 <= 0.0f || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        if (size.getWidth() >= size.getHeight()) {
            height = bitmap.getWidth();
            height2 = (int) (bitmap.getWidth() * ((size.getHeight() * 1.0f) / size.getWidth()));
        } else {
            height = (int) (((bitmap.getHeight() * size.getWidth()) * 1.0f) / size.getHeight());
            height2 = bitmap.getHeight();
        }
        CameraLog.m12954a("Util", "scaleBitmap, newWidth: " + height + ", newHeight: " + height2 + " targetSize: " + size);
        if (height2 < height || (bitmap.getWidth() == bitmap.getHeight() && (90 == OplusGLSurfaceView_13 || 270 == OplusGLSurfaceView_13))) {
            i2 = height;
            i3 = height2;
        } else {
            i3 = height;
            i2 = height2;
        }
        try {
            return m24221a(bitmap, 0, 0, i3, i2, matrix, true);
        } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: s */
    public static boolean m24494s(Context context) {
        Locale localeM24404bb = m24404bb();
        return m24299a(localeM24404bb) && m24395b(localeM24404bb);
    }

    /* renamed from: aq */
    public static boolean m24354aq() {
        return m24299a(m24404bb());
    }

    /* renamed from: t */
    public static boolean m24496t(Context context) {
        Locale locale;
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        return (locales == null || locales.isEmpty() || (locale = locales.get(0)) == null || (!"zh".equalsIgnoreCase(locale.getLanguage()) && !"cn".equalsIgnoreCase(locale.getCountry()))) ? false : true;
    }

    /* renamed from: bb */
    private static Locale m24404bb() {
        LocaleList locales = MyApplication.m11092d().getResources().getConfiguration().getLocales();
        if (locales == null || locales.isEmpty()) {
            return null;
        }
        return locales.get(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m24299a(Locale locale) {
        return locale != null && "zh".equalsIgnoreCase(locale.getLanguage());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m24395b(Locale locale) {
        return locale != null && "cn".equalsIgnoreCase(locale.getCountry());
    }

    /* renamed from: ar */
    public static boolean m24355ar() {
        try {
            String str = SystemPropertiesNative.get("ro.build.version.ota");
            String str2 = SystemPropertiesNative.get("ro.build.mea");
            if (str == null || !str.toLowerCase(Locale.US).contains("pre")) {
                if (str2 == null) {
                    return false;
                }
                if (!str2.equals("1")) {
                    return false;
                }
            }
            return true;
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Util", "isMeaVersion Exception " + COUIBaseListPopupWindow_8);
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static double m24199a(Context context, Size size) {
        if (size != null) {
            return (size.getWidth() * size.getHeight()) / 1000000.0f;
        }
        return 0.0d;
    }

    /* renamed from: u */
    public static void m24497u(Context context) {
        try {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService("shortcut");
            List<ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
            if (dynamicShortcuts != null && dynamicShortcuts.size() > 0) {
                shortcutManager.removeAllDynamicShortcuts();
            }
            CameraLog.m12962c("Util", "removeDynamicShortcuts, successful.");
        } catch (Exception unused) {
            CameraLog.m12962c("Util", "removeDynamicShortcuts, failed.");
        }
    }

    /* renamed from: as */
    public static boolean m24356as() {
        return f23016x;
    }

    /* renamed from: at */
    public static synchronized boolean m24357at() {
        if (f22989av != null) {
            return f22989av.booleanValue();
        }
        List<String> supportedList = CameraConfig.getSupportedList(CameraUIInterface.KEY_VIDEO_SIZE, 0);
        if (supportedList != null) {
            if (supportedList.contains("video_size_8k")) {
                f22989av = Boolean.valueOf(m24455g(VideoMode.VIDEO_8K_FRAME_WIDTH, VideoMode.VIDEO_8K_FRAME_HEIGHT));
            } else if (supportedList.contains("video_size_4kuhd")) {
                f22989av = Boolean.valueOf(m24455g(VideoMode.VIDEO_4K_FRAME_WIDTH, VideoMode.VIDEO_4K_FRAME_HEIGHT));
            } else if (supportedList.contains("video_size_1080p")) {
                f22989av = Boolean.valueOf(m24455g(VideoMode.VIDEO_1080P_WIDTH, VideoMode.VIDEO_1080P_HEIGHT));
            } else if (supportedList.contains("video_size_720p")) {
                f22989av = Boolean.valueOf(m24455g(VideoMode.VIDEO_720P_WIDTH, VideoMode.VIDEO_720P_HEIGHT));
            }
        }
        if (f22989av == null) {
            f22989av = false;
        }
        return f22989av.booleanValue();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static boolean m24455g(int OplusGLSurfaceView_13, int i2) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        boolean z = false;
        if (codecInfos != null) {
            boolean z2 = false;
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (supportedTypes != null && mediaCodecInfo.isEncoder()) {
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            String str = supportedTypes[i3];
                            if (MimeTypes.VIDEO_H265.equals(str) && (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str)) != null && capabilitiesForType.getVideoCapabilities() != null && capabilitiesForType.getVideoCapabilities().isSizeSupported(OplusGLSurfaceView_13, i2)) {
                                z2 = true;
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            z = z2;
        }
        CameraLog.m12954a("Util", "isSupportH265Encoder, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", support: " + z);
        return z;
    }

    /* renamed from: au */
    public static boolean m24358au() {
        return (AlgoSwitchConfig.getSupportCaptureAlgo(ApsConstant.CAPTURE_MODE_NIGHT, 1, CameraUnitKeys.ALGO_NAME_FRONT_PORTRAIT_SUPERNIGHT) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_SUPERNIGHT_SUPPORT);
    }

    /* renamed from: av */
    public static boolean m24359av() {
        return AlgoSwitchConfig.getSupportCaptureAlgo(ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, 1, CameraUnitKeys.ALGO_NAME_SUPERPHOTO);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24391b(Context context, String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            z = context.getPackageManager().getPackageInfo(m24327aP(), 128).applicationInfo.metaData.getBoolean(str);
            CameraLog.m12962c("Util", "isGallerySupportFeature, feature: " + str + ", support: " + z);
            return z;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return z;
        }
    }

    /* renamed from: v */
    public static boolean m24500v(Context context) {
        if (f22963aA == null) {
            f22963aA = Boolean.valueOf(m24391b(context, "isSupportAIIDPhoto"));
        }
        return f22963aA.booleanValue();
    }

    /* renamed from: w */
    public static boolean m24501w(Context context) {
        if (f22993az == null) {
            f22993az = Boolean.valueOf(m24391b(context, "isSupportQuickPhoto"));
        }
        return f22993az.booleanValue();
    }

    /* renamed from: x */
    public static boolean m24504x(Context context) {
        if (f22944I == null) {
            f22944I = (LocationManager) context.getApplicationContext().getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION);
        }
        boolean zIsLocationEnabled = f22944I.isLocationEnabled();
        boolean zIsProviderEnabled = f22944I.isProviderEnabled(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
        CameraLog.m12959b("Util", "getLocationAvailable, locationAvailable: " + zIsLocationEnabled + ", netAvailable: " + zIsProviderEnabled);
        return zIsLocationEnabled && zIsProviderEnabled;
    }

    /* renamed from: aw */
    public static String m24360aw() {
        if (f22938C == null) {
            f22938C = m24461i("persist.sys.oplus.region");
        }
        return f22938C;
    }

    /* renamed from: ax */
    public static String m24361ax() {
        if (f22939D == null) {
            try {
                f22939D = SystemPropertiesNative.get("persist.sys.locale");
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        return f22939D;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24302a(String[] strArr, String str) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static byte[] m24422c(long OplusGLSurfaceView_15) {
        byte[] bArr = new byte[f22999g];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            bArr[OplusGLSurfaceView_13] = Long.valueOf(255 & OplusGLSurfaceView_15).byteValue();
            OplusGLSurfaceView_15 >>= f22999g;
        }
        return bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24303a(int OplusGLSurfaceView_13, byte[] bArr) {
        if (bArr == null || bArr.length != f22998f) {
            bArr = new byte[f22998f];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = Integer.valueOf(OplusGLSurfaceView_13 & 255).byteValue();
            OplusGLSurfaceView_13 >>= f22999g;
        }
        return bArr;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m24393b(String str, String str2) {
        String[] configStringArrayValue;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (configStringArrayValue = CameraConfig.getConfigStringArrayValue(str2)) == null || configStringArrayValue.length <= 0) {
            return false;
        }
        for (String str3 : configStringArrayValue) {
            if (str.equals(str3)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24297a(String str, boolean z) {
        return m24393b(str, z ? ConfigDataBase.KEY_NONE_SAT_FRONT_MODE : ConfigDataBase.KEY_NONE_SAT_REAR_MODE);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24394b(String str, boolean z) {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT) && m24297a(str, z);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m24443e(String str) {
        return m24393b(str, ConfigDataBase.KEY_PROFESSIONAL_RAW_CAMERA_TYPE_SUPPORT);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int[] m24311a(int[] iArr) {
        return (iArr == null || iArr.length != 8) ? iArr : new int[]{iArr[0], iArr[1], iArr[5], iArr[4], iArr[2], iArr[3], iArr[6], iArr[7]};
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int[] m24401b(int[] iArr) {
        return (iArr == null || iArr.length != 8) ? iArr : new int[]{iArr[0], iArr[1], iArr[4], iArr[5], iArr[3], iArr[2], iArr[6], iArr[7]};
    }

    /* renamed from: ay */
    public static Handler m24362ay() {
        if (f22946K == null) {
            f22946K = new Handler(Looper.getMainLooper());
        }
        return f22946K;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m24416c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            runnable.run();
        } else {
            m24362ay().post(runnable);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m24408c(int... iArr) {
        if (iArr == null) {
            return 0;
        }
        int OplusGLSurfaceView_13 = 1;
        for (int i2 : iArr) {
            OplusGLSurfaceView_13 = ((OplusGLSurfaceView_13 << 5) - OplusGLSurfaceView_13) ^ i2;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m24419c(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("Util", "isPackageExist, packageName: " + str + ", COUIBaseListPopupWindow_8: ", COUIBaseListPopupWindow_8);
            applicationInfo = null;
        }
        return applicationInfo != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <K, V> boolean m24300a(Map<K, V> map) {
        return map == null || map.size() <= 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static <K, V> boolean m24396b(Map<K, V> map) {
        return !m24300a(map);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static void m24466j(int OplusGLSurfaceView_13) {
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) && m24312aA()) {
            CameraLog.m12959b("Util", "broadcastFrontCameraOpened");
            m24279a(new Runnable() { // from class: com.oplus.camera.util.Util.8
                @Override // java.lang.Runnable
                public void run() {
                    Util.f22945J.sendBroadcast(new Intent("oplus.intent.action.start.PINHOLE"));
                }
            });
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static void m24470k(int OplusGLSurfaceView_13) {
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) && m24312aA()) {
            CameraLog.m12959b("Util", "broadcastFrontCameraClosed");
            m24279a(new Runnable() { // from class: com.oplus.camera.util.Util.9
                @Override // java.lang.Runnable
                public void run() {
                    Util.f22945J.sendBroadcast(new Intent("oplus.intent.action.stop.PINHOLE"));
                }
            });
        }
    }

    /* renamed from: az */
    public static String m24363az() {
        return m24461i("ro.oplus.display.screenhole.positon");
    }

    /* renamed from: aA */
    public static boolean m24312aA() {
        return !TextUtils.isEmpty(m24363az());
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static Rect m24448f(String str) {
        if (m24312aA()) {
            try {
                String[] strArrSplit = str.split(":");
                String[] strArrSplit2 = strArrSplit[0].split(",");
                String[] strArrSplit3 = strArrSplit[1].split(",");
                return new Rect(Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1]), Integer.parseInt(strArrSplit3[0]), Integer.parseInt(strArrSplit3[1]));
            } catch (Exception unused) {
                CameraLog.m12967f("Util", "getScreenHolePosition, hole position is incorrect");
            }
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int m24446f(int OplusGLSurfaceView_13, int i2) {
        return (((OplusGLSurfaceView_13 + i2) - 1) / i2) * i2;
    }

    /* renamed from: aB */
    public static String m24313aB() {
        return String.valueOf(f22980am);
    }

    /* renamed from: aC */
    public static String m24314aC() {
        return String.valueOf(f22981an);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24289a(Uri uri) {
        return (uri == null || uri.toString().contains("/video/media")) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* renamed from: aD */
    public static int m24315aD() throws Throwable {
        FileReader fileReader;
        Exception COUIBaseListPopupWindow_8;
        BufferedReader bufferedReader;
        CameraLog.m12959b("Util", "getTotalRam");
        ?? r1 = "/proc/meminfo";
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader, 8192);
                        try {
                            String line = bufferedReader.readLine();
                            String str = line != null ? line.split("\\s+")[1] : null;
                            iCeil = str != null ? (int) Math.ceil(new Float(Float.valueOf(str).floatValue() / 1048576.0f).doubleValue()) : 0;
                            bufferedReader.close();
                            fileReader.close();
                        } catch (Exception e2) {
                            COUIBaseListPopupWindow_8 = e2;
                            COUIBaseListPopupWindow_8.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            CameraLog.m12959b("Util", "getTotalRam X, totalRam: " + iCeil);
                            return iCeil;
                        }
                    } catch (Exception e3) {
                        COUIBaseListPopupWindow_8 = e3;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        r1 = 0;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } catch (Exception e6) {
                fileReader = null;
                COUIBaseListPopupWindow_8 = e6;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                fileReader = null;
            }
            CameraLog.m12959b("Util", "getTotalRam X, totalRam: " + iCeil);
            return iCeil;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: aE */
    public static void m24316aE() {
        if (f22990aw == null) {
            f22990aw = new DecimalFormat();
        }
    }

    /* renamed from: aF */
    public static void m24317aF() {
        f22990aw = null;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static String m24474l(int OplusGLSurfaceView_13) {
        DecimalFormat decimalFormat = f22990aw;
        if (decimalFormat == null) {
            return String.valueOf(OplusGLSurfaceView_13);
        }
        return decimalFormat.format(OplusGLSurfaceView_13);
    }

    /* renamed from: aG */
    public static int m24318aG() throws Settings.SettingNotFoundException {
        int OplusGLSurfaceView_13;
        try {
            OplusGLSurfaceView_13 = Settings.Secure.getInt(f22945J.getContentResolver(), "navigation_mode");
        } catch (Settings.SettingNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            OplusGLSurfaceView_13 = 0;
        }
        if (2 == OplusGLSurfaceView_13) {
            return 0;
        }
        return m24198Z();
    }

    /* renamed from: aH */
    public static int m24319aH() {
        double dM24199a = m24199a((Context) null, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE));
        CameraLog.m12954a("Util", "getHighPictureSize, highPictureSize: " + dM24199a);
        if (Math.abs(dM24199a - 48.0d) < 1.0d) {
            return 48;
        }
        if (Math.abs(dM24199a - 50.0d) < 1.0d) {
            return 50;
        }
        if (Math.abs(dM24199a - 64.0d) < 1.0d) {
            return 64;
        }
        return Math.abs(dM24199a - 108.0d) < 1.0d ? 108 : -1;
    }

    /* renamed from: y */
    public static boolean m24506y(Context context) {
        f22954S = ((DisplayManager) context.getSystemService("display")).getDisplay(0);
        Display.Mode[] supportedModes = f22954S.getSupportedModes();
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < supportedModes.length; OplusGLSurfaceView_13++) {
            if (-1 == arrayList.indexOf(Integer.valueOf(supportedModes[OplusGLSurfaceView_13].getPhysicalWidth()))) {
                arrayList.add(Integer.valueOf(supportedModes[OplusGLSurfaceView_13].getPhysicalWidth()));
                CameraLog.m12954a("Util", "supportResolutionSwitch, getPhysicalWidth: " + supportedModes[OplusGLSurfaceView_13].getPhysicalWidth());
            }
        }
        return 1 != arrayList.size() && 1 < arrayList.size();
    }

    /* renamed from: z */
    public static boolean m24508z(Context context) {
        if (!f23015w && context.checkCallingOrSelfPermission("android.permission.CAMERA") != 0) {
            CameraLog.m12967f("Util", "checkCameraPermission not granted");
            return false;
        }
        f23015w = true;
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m24203a(CaptureResult captureResult) {
        CaptureResult.Key<float[]> key = CameraMetadataKey.f13255U;
        if (key == null) {
            return 0.0f;
        }
        try {
            float[] fArr = (float[]) captureResult.get(key);
            if (fArr == null || fArr.length <= 0) {
                return 0.0f;
            }
            return fArr[0];
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static float m24476m(int OplusGLSurfaceView_13) {
        return (float) ((5.0d / Math.log10(VideoRecorder.f13063a)) * Math.log10(OplusGLSurfaceView_13));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static String m24453g(String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        if (str.startsWith("HTTP://")) {
            return "http" + str.substring(4);
        }
        if (str.startsWith("HTTPS://")) {
            return "https" + str.substring(5);
        }
        return "http://" + str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m24200a(float COUIBaseListPopupWindow_12, float f2) {
        return new BigDecimal(Float.toString(COUIBaseListPopupWindow_12)).subtract(new BigDecimal(Float.toString(f2))).floatValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24216a(Context context, int OplusGLSurfaceView_13) {
        Drawable drawableM2248a = ContextCompat.m2248a(context, OplusGLSurfaceView_13);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableM2248a.getIntrinsicWidth(), drawableM2248a.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableM2248a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableM2248a.draw(canvas);
        m24437e(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24217a(Context context, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        Drawable drawableM2248a = ContextCompat.m2248a(context, OplusGLSurfaceView_13);
        if (context.getResources().getDisplayMetrics().densityDpi != i2) {
            float f2 = i2;
            intrinsicWidth = (int) (((drawableM2248a.getIntrinsicWidth() * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f2 * COUIBaseListPopupWindow_12);
            intrinsicHeight = (int) (((drawableM2248a.getIntrinsicHeight() * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f2 * COUIBaseListPopupWindow_12);
        } else {
            intrinsicWidth = (int) (drawableM2248a.getIntrinsicWidth() * COUIBaseListPopupWindow_12);
            intrinsicHeight = (int) (drawableM2248a.getIntrinsicHeight() * COUIBaseListPopupWindow_12);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableM2248a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableM2248a.draw(canvas);
        bitmapCreateBitmap.setDensity(f22962a);
        return bitmapCreateBitmap;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m24370b(Context context, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        int i3;
        int i4;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), OplusGLSurfaceView_13, options);
        if (context.getResources().getDisplayMetrics().densityDpi != i2) {
            float f2 = i2;
            i3 = (int) (((options.outWidth * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f2 * COUIBaseListPopupWindow_12);
            i4 = (int) (((options.outHeight * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f2 * COUIBaseListPopupWindow_12);
        } else {
            i3 = (int) (options.outWidth * COUIBaseListPopupWindow_12);
            i4 = (int) (options.outHeight * COUIBaseListPopupWindow_12);
        }
        options.inJustDecodeBounds = false;
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), OplusGLSurfaceView_13, options), i3, i4, false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m24406c(Context context, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        int i3;
        float f2;
        int i4;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), OplusGLSurfaceView_13, options);
        if (!m24506y(context)) {
            if (context.getResources().getDisplayMetrics().densityDpi != i2) {
                f2 = options.outWidth * 1.0f;
                i3 = context.getResources().getDisplayMetrics().densityDpi;
            } else {
                i4 = (int) (options.outWidth * COUIBaseListPopupWindow_12);
                CameraLog.m12954a("Util", "getBitmapFromVectorDrawableWidth, options.outWidth: " + options.outWidth + ", width: " + i4);
                return i4;
            }
        } else {
            i3 = CameraParameter.VideoFps.FPS_480;
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DEVICE_ULTRA_HIGH_DENSITY_SUPPORT)) {
                i3 = f22962a;
            }
            f2 = options.outWidth * 1.0f;
        }
        i4 = (int) ((f2 / i3) * i2 * COUIBaseListPopupWindow_12);
        CameraLog.m12954a("Util", "getBitmapFromVectorDrawableWidth, options.outWidth: " + options.outWidth + ", width: " + i4);
        return i4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m24202a(Context context, int OplusGLSurfaceView_13, int i2) {
        return ((context.getResources().getDimensionPixelSize(OplusGLSurfaceView_13) * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * i2;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static Bitmap m24480n(int OplusGLSurfaceView_13) {
        return m24428d(BitmapFactory.decodeResource(MyApplication.m11092d().getResources(), OplusGLSurfaceView_13));
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static boolean m24459h(String str) {
        return false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static String m24461i(String str) {
        try {
            return OplusSystemProperties.get(str, "");
        } catch (Throwable unused) {
            CameraLog.m12967f("Util", "getSystemProperties fail, return default value");
            return "";
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24212a(String str, int OplusGLSurfaceView_13) {
        try {
            return OplusSystemProperties.getInt(str, OplusGLSurfaceView_13);
        } catch (Exception unused) {
            CameraLog.m12967f("Util", "getSystemProperties fail, return default value");
            return OplusGLSurfaceView_13;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m24421c(String str, boolean z) {
        try {
            return OplusSystemProperties.getBoolean(str, z);
        } catch (Exception unused) {
            CameraLog.m12967f("Util", "getSystemProperties fail, return default value");
            return z;
        }
    }

    /* renamed from: aI */
    public static boolean m24320aI() {
        try {
            String str = SystemPropertiesNative.get("ro.oplus.flashlight.rio.switch");
            CameraLog.m12954a("Util", "isRioFlashLightFuncOpen, key: " + str);
            if (!TextUtils.isEmpty(str)) {
                return 1 == SystemPropertiesNative.getInt(str, 0);
            }
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return false;
    }

    /* renamed from: aJ */
    public static boolean m24321aJ() {
        try {
            return "12".equals(SystemPropertiesNative.get("ro.build.version.release"));
        } catch (Throwable unused) {
            CameraLog.m12967f("Util", "isAndroidSMigrationAvailable, fail to check system property: ro.build.version.release");
            return false;
        }
    }

    /* renamed from: aK */
    public static boolean m24322aK() {
        try {
            return FocusAimMsgData.KEY_SEPARATE_METERING_FOCUS.equals(SystemPropertiesNative.get("ro.build.version.release"));
        } catch (Throwable unused) {
            CameraLog.m12967f("Util", "isAndroidRMigrationAvailable, fail to check system property: ro.build.version.release");
            return false;
        }
    }

    /* renamed from: A */
    public static int m24164A(Context context) {
        return COUIContextUtil.m6399a(context, com.oplus.camera.R.attr.couiTintControlNormal, context.getColor(com.oplus.camera.R.color.color_primary_light_yellow));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Drawable m24376b(Context context, int OplusGLSurfaceView_13) {
        return m24228a(context, context.getDrawable(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Drawable m24228a(Context context, Drawable drawable) {
        if (drawable == null || !m24352ao()) {
            return (drawable == null || !COUIThemeOverlay.m6468a().m6481b(context)) ? drawable : COUITintUtil.m6499a(drawable, m24164A(context));
        }
        return COUITintUtil.m6499a(drawable, context.getColor(com.oplus.camera.R.color.color_primary_light_hasselblad));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24287a(Activity activity, List<String> list) {
        for (String str : list) {
            if (activity.checkSelfPermission(str) != 0) {
                CameraLog.m12954a("Util", "checkRuntimePermission, ungrant permission: " + str);
                return false;
            }
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static int m24464j(String str) {
        try {
            return ((Integer) Class.forName("android.view.KeyEvent").getField(str).get(null)).intValue();
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Util", "getFingerKeyCode, exception: " + COUIBaseListPopupWindow_8);
            return -1;
        }
    }

    /* renamed from: B */
    public static boolean m24167B(Context context) {
        return m24419c(context, "com.heytap.market");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m24435d(Context context, String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str) != null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m24441e(final Context context, final String str) {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.util.Util.10
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    if (TextUtils.isEmpty(Util.f23005m)) {
                        CameraLog.m12966e("Util", "notifyAthena, cleaner package is null");
                        return;
                    }
                    Intent intent = new Intent("oplus.intent.action.SCENE_CHANGE_NOTIFY");
                    intent.setPackage(Util.f23005m);
                    Bundle bundle = new Bundle();
                    bundle.putString(CameraStatisticsUtil.CALLER_PACKAGE, context.getPackageName());
                    bundle.putString("scene", str);
                    intent.putExtras(bundle);
                    context.startService(intent);
                    CameraLog.m12966e("Util", "notifyAthena, started service, action: oplus.intent.action.SCENE_CHANGE_NOTIFY, scene: " + str);
                    return;
                }
                CameraLog.m12967f("Util", "notifyAthena, activity is recycled, return.");
            }
        }, "notifyAthena");
    }

    /* renamed from: aL */
    public static void m24323aL() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ATHENA_SUPPORT)) {
            long configFloatValue = (long) (CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_ATHENA_MEMORY_THRESHOLD) * 1.07374182E9f);
            long OplusGLSurfaceView_15 = m24452g(MyApplication.m11092d()).availMem;
            long j2 = m24502w()[1];
            CameraLog.m12954a("Util", "checkNotifyAthena, athenaMemoryThreshold: " + configFloatValue + ", availableMemoryFromProc: " + j2 + ", availableMemory: " + OplusGLSurfaceView_15);
            if (j2 > 0) {
                OplusGLSurfaceView_15 = j2;
            }
            if (m24458h(MyApplication.m11092d()) || (configFloatValue > 0 && OplusGLSurfaceView_15 < configFloatValue)) {
                m24168C(MyApplication.m11092d());
            }
        }
    }

    /* renamed from: C */
    public static void m24168C(final Context context) {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.util.Util.2
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    if (TextUtils.isEmpty(Util.f23005m)) {
                        CameraLog.m12966e("Util", "notifyAthena, cleaner package is null");
                        return;
                    }
                    try {
                        Intent intent = new Intent("oplus.intent.action.REQUEST_APP_CLEAN_RUNNING");
                        intent.setPackage(Util.f23005m);
                        intent.putExtra(CameraStatisticsUtil.CALLER_PACKAGE, context.getPackageName());
                        intent.putExtra("reason", "camera_startup_clear");
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add("com.oplus.gallery3d.provider.GalleryOpenProvider");
                        arrayList.add(Util.f23006n);
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList(CameraStatisticsUtil.FILTER_APP_LIST, arrayList);
                        intent.putExtras(bundle);
                        context.startService(intent);
                        CameraLog.m12966e("Util", "notifyAthena, started service, action: oplus.intent.action.REQUEST_APP_CLEAN_RUNNING");
                        return;
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        return;
                    }
                }
                CameraLog.m12967f("Util", "notifyAthena, activity is recycled, return.");
            }
        }, "notifyAthena");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24288a(Context context, String str, int OplusGLSurfaceView_13) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return false;
            }
            return ((long) OplusGLSurfaceView_13) <= packageInfo.getLongVersionCode();
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: D */
    public static boolean m24171D(Context context) {
        String string;
        boolean z;
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
            CameraLog.m12967f("Util", "isSoloopSupported, project config is off.");
            return false;
        }
        SharedPreferences sharedPreferences = f22945J.getSharedPreferences("rom_update_info", 0);
        if (sharedPreferences != null) {
            string = sharedPreferences.getString("soloop_switch", "on");
            CameraLog.m12966e("Util", "isSoloopSupported, soloopSwitch: " + string);
        } else {
            string = "on";
        }
        if (!TextUtils.equals(string, "on")) {
            CameraLog.m12967f("Util", "isSoloopSupported, rus switch is off.");
            return false;
        }
        SharedPreferences sharedPreferences2 = f22945J.getSharedPreferences("soloop_info", 0);
        if (sharedPreferences2 != null) {
            z = sharedPreferences2.getBoolean("key_market_soloop_support_jump", false);
            CameraLog.m12966e("Util", "isSoloopSupported, isMarketSoloopSupportJump: " + z);
        } else {
            z = false;
        }
        return z || m24288a(context, "com.oplus.videoeditor", 12400);
    }

    /* renamed from: aM */
    public static String m24324aM() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    /* renamed from: aN */
    public static boolean m24325aN() {
        try {
            return !"0".equals(SystemPropertiesNative.get("vendor.camera.mem.debug.enable", "0"));
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("Util", "debugApsMem error.", COUIBaseListPopupWindow_8);
            return false;
        }
    }

    /* renamed from: E */
    public static File m24172E(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = new File(OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + context.getPackageName() + File.separator + "cache");
            if (!externalCacheDir.exists() && !externalCacheDir.mkdirs()) {
                CameraLog.m12967f("Util", "getExternalCacheDir, cacheDir.mkdirs fail");
            }
        }
        return externalCacheDir;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m24240a(Size[] sizeArr) {
        return (Size) Arrays.stream(sizeArr).filter($$Lambda$bdDB5qtJ9up3KI34bjHEph1ELg.INSTANCE).max(new Comparator() { // from class: com.oplus.camera.util.-$$Lambda$Util$pyPrMXEwCpKAIaarngXQqcplqhE
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Util.m24210a((Size) obj, (Size) obj2);
            }
        }).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ int m24210a(Size size, Size size2) {
        return (size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight());
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m24427d(long OplusGLSurfaceView_15) {
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date(OplusGLSurfaceView_15));
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    /* renamed from: F */
    public static String m24174F(Context context) {
        return (context == null || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) ? "off" : context.getResources().getString(com.oplus.camera.R.string.camera_torch_mode_default_value);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static List<String> m24414c(Context context, int OplusGLSurfaceView_13) {
        ArrayList arrayList = new ArrayList(Arrays.asList(context.getResources().getStringArray(com.oplus.camera.R.array.video_resolution_values)));
        if (!m24392b("video_size_720p", OplusGLSurfaceView_13)) {
            arrayList.remove(context.getString(com.oplus.camera.R.string.camera_video_size_value_720p));
        }
        if (!m24392b("video_size_4kuhd", OplusGLSurfaceView_13)) {
            arrayList.remove(context.getString(com.oplus.camera.R.string.camera_video_size_value_4k));
        }
        if (!m24392b("video_size_8k", OplusGLSurfaceView_13)) {
            arrayList.remove(context.getString(com.oplus.camera.R.string.camera_video_size_value_8k));
        }
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24392b(String str, int OplusGLSurfaceView_13) {
        List<String> supportedList = CameraConfig.getSupportedList(CameraUIInterface.KEY_VIDEO_SIZE, OplusGLSurfaceView_13);
        boolean z = false;
        if (supportedList != null) {
            Iterator<String> it = supportedList.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24286a(int OplusGLSurfaceView_13, String str) {
        if ("video_size_720p".equals(str)) {
            return !CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS);
        }
        if ("video_size_1080p".equals(str)) {
            if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS);
            }
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS);
        }
        if ("video_size_4kuhd".equals(str)) {
            return !CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS);
        }
        return false;
    }

    /* renamed from: o */
    public static String m24485o(int OplusGLSurfaceView_13) {
        return (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_720P_SLOW_VIDEO)) ? "video_size_1080p" : "video_size_720p";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24280a(String str, String str2) throws Throwable {
        String[] list;
        CameraLog.m12954a("Util", "copySourceToTarget, sourcePath: " + str + " , targetPath: " + str2);
        if (!TextUtils.isEmpty(str) && (list = new File(str).list()) != null && list.length > 0) {
            for (String str3 : list) {
                try {
                    m24278a(new FileInputStream(str + File.separator + str3), str2 + File.separator + str3);
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        }
        CameraLog.m12954a("Util", "copySourceToTarget X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24278a(InputStream inputStream, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(str));
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int OplusGLSurfaceView_13 = inputStream.read(bArr);
                    if (-1 == OplusGLSurfaceView_13) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                    }
                }
                fileOutputStream.flush();
                if (inputStream != null) {
                    inputStream.close();
                }
                fileOutputStream.close();
            } catch (Exception e2) {
                COUIBaseListPopupWindow_8 = e2;
                fileOutputStream2 = fileOutputStream;
                COUIBaseListPopupWindow_8.printStackTrace();
                fileOutputStream2.flush();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    fileOutputStream2.flush();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24397b(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: aO */
    public static boolean m24326aO() {
        CameraLog.m12954a("Util", "requestKeyguard");
        try {
            new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            return true;
        } catch (RemoteException | NoSuchMethodError COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Util", "requestKeyguard: " + COUIBaseListPopupWindow_8.toString());
            return false;
        }
    }

    /* renamed from: G */
    public static boolean m24177G(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            z = context.getPackageManager().getPackageInfo(m24327aP(), 128).applicationInfo.metaData.getBoolean("isSupportDoubleExposure");
            CameraLog.m12962c("Util", "isGallerySupportDoubleExposure, support: " + z);
            return z;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return z;
        }
    }

    /* renamed from: aP */
    public static String m24327aP() {
        return OplusConfigure.m24652b();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static byte[] m24471k(String str) throws Throwable {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[102400];
        try {
            fileInputStream = new FileInputStream(str);
            while (true) {
                try {
                    int OplusGLSurfaceView_13 = fileInputStream.read(bArr);
                    if (OplusGLSurfaceView_13 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                } catch (IOException unused) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            try {
                fileInputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015f  */
    /* renamed from: OplusGLSurfaceView_14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m24475l(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.m24475l(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x004b  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m24253a(int r1, android.content.Context r2, boolean r3) {
        /*
            r0 = 2
            if (r1 == r0) goto L46
            r0 = 4
            if (r1 == r0) goto L43
            r0 = 16
            if (r1 == r0) goto L3e
            r0 = 18
            if (r1 == r0) goto L3b
            r0 = 29
            if (r1 == r0) goto L38
            r0 = 31
            if (r1 == r0) goto L35
            r0 = 13
            if (r1 == r0) goto L32
            r0 = 14
            if (r1 == r0) goto L2f
            r0 = 26
            if (r1 == r0) goto L2a
            r3 = 27
            if (r1 == r3) goto L27
            goto L4b
        L27:
            java.lang.String r1 = "long_exposure_reddot_show"
            goto L4c
        L2a:
            if (r3 != 0) goto L4b
            java.lang.String r1 = "street_reddot_show"
            goto L4c
        L2f:
            java.lang.String r1 = "multi_video_reddot_show"
            goto L4c
        L32:
            java.lang.String r1 = "id_photo_reddot_show"
            goto L4c
        L35:
            java.lang.String r1 = "mode_high_pixel_reddot_show"
            goto L4c
        L38:
            java.lang.String r1 = "fish_eye_reddot_show"
            goto L4c
        L3b:
            java.lang.String r1 = "double_exposure_reddot_show"
            goto L4c
        L3e:
            if (r3 != 0) goto L4b
            java.lang.String r1 = "microscope_reddot_show"
            goto L4c
        L43:
            java.lang.String r1 = "profession_reddot_show"
            goto L4c
        L46:
            if (r3 != 0) goto L4b
            java.lang.String r1 = "slow_video_high_frame_reddot_show"
            goto L4c
        L4b:
            r1 = 0
        L4c:
            if (r1 == 0) goto L5e
            android.content.SharedPreferences r2 = androidx.preference.PreferenceManager.m3981a(r2)
            android.content.SharedPreferences$Editor r2 = r2.edit()
            r3 = 0
            android.content.SharedPreferences$Editor r1 = r2.putBoolean(r1, r3)
            r1.apply()
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.m24253a(int, android.content.Context, boolean):void");
    }

    public static ArrayList<String> getModeNameByRank(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<ModeDataInfo> listM21782a = DataBaseOperator.m21777a().m21782a(str);
        if (listM21782a != null && !listM21782a.isEmpty()) {
            Iterator it = ((List) listM21782a.stream().sorted(Comparator.comparing(new Function() { // from class: com.oplus.camera.util.-$$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((ModeDataInfo) obj).m21911d());
                }
            })).collect(Collectors.toList())).iterator();
            while (it.hasNext()) {
                arrayList.add(((ModeDataInfo) it.next()).m21908a());
            }
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24281a(List<Size> list, final boolean z) {
        if (list != null) {
            Collections.sort(list, new Comparator() { // from class: com.oplus.camera.util.-$$Lambda$Util$_wWOSaQw6lIk4_hbUdcJDEydh44
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Util.m24213a(z, (Size) obj, (Size) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ int m24213a(boolean z, Size size, Size size2) {
        int width = (size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight());
        return z ? width : -width;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static MotionEvent m24241a(MotionEvent motionEvent, int OplusGLSurfaceView_13) {
        int i2;
        int i3;
        int pointerCount = motionEvent.getPointerCount();
        int i4 = 0;
        int pointerId = 0;
        while (true) {
            if (i4 >= pointerCount) {
                break;
            }
            pointerId |= 1 << motionEvent.getPointerId(i4);
            i4++;
        }
        CameraLog.m12959b("Util", "split, idBitsTemp: " + pointerId);
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        int[] iArr = new int[pointerCount];
        for (int i5 = 0; i5 < pointerCount; i5++) {
            pointerPropertiesArr[i5] = new MotionEvent.PointerProperties();
            pointerCoordsArr[i5] = new MotionEvent.PointerCoords();
        }
        int action = motionEvent.getAction();
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int i6 = 0;
        int i7 = -1;
        for (int i8 = 0; i8 < pointerCount; i8++) {
            motionEvent.getPointerProperties(i8, pointerPropertiesArr[i6]);
            if (((1 << pointerPropertiesArr[i6].id_renamed) & OplusGLSurfaceView_13) != 0) {
                if (i8 == actionIndex) {
                    i7 = i6;
                }
                iArr[i6] = i8;
                i6++;
            }
        }
        if (i6 == 0) {
            return null;
        }
        if (5 == actionMasked || 6 == actionMasked) {
            if (i7 < 0) {
                i2 = 2;
            } else if (1 == i6) {
                i3 = actionMasked == 5 ? 0 : 1;
            } else {
                i2 = (i7 << 8) | actionMasked;
            }
            i3 = i2;
        } else {
            i3 = action;
        }
        for (int i9 = 0; i9 < i6; i9++) {
            motionEvent.getPointerCoords(iArr[i9], pointerCoordsArr[i9]);
        }
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i3, i6, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
    }

    /* renamed from: aQ */
    public static boolean m24328aQ() {
        try {
            return "0".equals(SystemPropertiesNative.get("persist.sys.oplus.camera.open.torch", "1"));
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("Util", "isGovernmentTorchDisable error.", COUIBaseListPopupWindow_8);
            return false;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static String m24438e(boolean z) {
        return z ? CameraConfig.getConfigBooleanValue(ConfigDataBase.f12541xacd6d020) ? "on" : "off" : CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_REAR_OPEN_DEFAULT_SUPPORT) ? "on" : "off";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24294a(View view, float COUIBaseListPopupWindow_12, float f2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int OplusGLSurfaceView_13 = iArr[0];
        int i2 = iArr[1];
        return f2 >= ((float) i2) && f2 <= ((float) (view.getMeasuredHeight() + i2)) && COUIBaseListPopupWindow_12 >= ((float) OplusGLSurfaceView_13) && COUIBaseListPopupWindow_12 <= ((float) (view.getMeasuredWidth() + OplusGLSurfaceView_13));
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static boolean m24479m(String str) {
        return "video_size_1080p".equals(str) || ("video_size_4kuhd".equals(str) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_4K));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m24381b(Uri uri) {
        String string = uri.toString();
        return string.substring(string.lastIndexOf(47) + 1);
    }

    /* renamed from: aR */
    public static boolean m24329aR() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24256a(Activity activity, int OplusGLSurfaceView_13, boolean z) {
        KeyEvent.Callback callbackFindViewById = activity.findViewById(OplusGLSurfaceView_13);
        if (callbackFindViewById != null && (callbackFindViewById instanceof ILightBackgroundView)) {
            ((ILightBackgroundView) callbackFindViewById).setLightBackground(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24255a(Activity activity, int OplusGLSurfaceView_13, int i2) {
        View viewFindViewById = activity.findViewById(OplusGLSurfaceView_13);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24275a(TextView textView) throws Resources.NotFoundException {
        Context context = textView.getContext();
        float fM24202a = m24202a(textView.getContext(), com.oplus.camera.R.dimen.level_panel_text_shadow_radius, f22962a);
        int color = context.getResources().getColor(com.oplus.camera.R.color.color_black_with_20_percent_transparency);
        int OplusGLSurfaceView_13 = (int) fM24202a;
        textView.setPadding(OplusGLSurfaceView_13, OplusGLSurfaceView_13, OplusGLSurfaceView_13, OplusGLSurfaceView_13);
        textView.setShadowLayer(fM24202a, 0.0f, 0.0f, color);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24295a(View view, int OplusGLSurfaceView_13, int i2) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        Rect rect2 = (Rect) view.getTag(com.oplus.camera.R.id_renamed.touch_area_tag);
        if (rect2 == null) {
            return rect.contains(OplusGLSurfaceView_13, i2);
        }
        if (!rect2.contains(OplusGLSurfaceView_13, i2)) {
            view.getDrawingRect(rect2);
        }
        Rect rect3 = new Rect();
        rect3.set(rect2);
        rect3.offset(rect.left, rect.top);
        return rect3.contains(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m24374b(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        m24437e(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24244a(int OplusGLSurfaceView_13, int i2, Object[] objArr) {
        try {
            return m24472l().getResources().getQuantityString(OplusGLSurfaceView_13, i2, objArr);
        } catch (Exception unused) {
            return m24472l().getResources().getQuantityString(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24245a(int OplusGLSurfaceView_13, Object[] objArr) {
        try {
            return m24472l().getResources().getString(OplusGLSurfaceView_13, objArr);
        } catch (Exception unused) {
            return m24472l().getResources().getString(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: p */
    public static int m24486p(int OplusGLSurfaceView_13) {
        int i2 = 1;
        if (OplusGLSurfaceView_13 != 1 && OplusGLSurfaceView_13 != 2) {
            if (OplusGLSurfaceView_13 != 3) {
                i2 = 4;
                if (OplusGLSurfaceView_13 != 4) {
                    if (OplusGLSurfaceView_13 != 13) {
                        if (OplusGLSurfaceView_13 == 21) {
                            return 3;
                        }
                        if (OplusGLSurfaceView_13 != 22) {
                            throw new IllegalArgumentException("Bad audio format " + OplusGLSurfaceView_13);
                        }
                    }
                }
            }
            return i2;
        }
        return 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24249a(String str, String str2, String str3) {
        return str.replaceFirst(str2, new String(Base64.decode(str3, 0), StandardCharsets.UTF_8));
    }
}
