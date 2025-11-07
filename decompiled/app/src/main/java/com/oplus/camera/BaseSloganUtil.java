package com.oplus.camera;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.os.ConditionVariable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Size;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.camera.LocationManager;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.jni.OplusSloganJNI;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.util.LocationHelper;
import com.oplus.camera.util.Util;
import com.oplus.p195os.OplusUsbEnvironment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: BaseSloganUtil.java */
/* renamed from: com.oplus.camera.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class BaseSloganUtil {

    /* renamed from: Z */
    private static final String[] f12557Z = {"150W"};

    /* renamed from: PlatformImplementations.kt_3 */
    protected static Typeface f12558a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected static Typeface f12559b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected static Typeface f12560c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected static Map<String, Bitmap> f12561d;

    /* renamed from: D */
    protected int f12565D;

    /* renamed from: L */
    protected String f12573L;

    /* renamed from: U */
    private String f12582U;

    /* renamed from: OplusGLSurfaceView_15 */
    protected String f12592j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected Activity f12593k;

    /* renamed from: OplusGLSurfaceView_14 */
    protected ComboPreferences f12594l;

    /* renamed from: OplusGLSurfaceView_6 */
    protected FormatConverter f12595m;

    /* renamed from: OplusGLSurfaceView_11 */
    protected Resources f12596n;

    /* renamed from: r */
    protected int f12600r;

    /* renamed from: s */
    protected float f12601s;

    /* renamed from: t */
    protected float f12602t;

    /* renamed from: u */
    protected float f12603u;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected final ConditionVariable f12587e = new ConditionVariable(true);

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected boolean f12588f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected int f12589g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int f12590h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    protected String f12591i = "";

    /* renamed from: o */
    protected Set<String> f12597o = new HashSet();

    /* renamed from: p */
    protected OplusSloganJNI f12598p = null;

    /* renamed from: q */
    protected Size f12599q = null;

    /* renamed from: v */
    protected Bitmap f12604v = null;

    /* renamed from: w */
    protected Bitmap f12605w = null;

    /* renamed from: x */
    protected boolean f12606x = false;

    /* renamed from: y */
    protected boolean f12607y = false;

    /* renamed from: z */
    protected boolean f12608z = false;

    /* renamed from: A */
    protected boolean f12562A = false;

    /* renamed from: B */
    protected boolean f12563B = false;

    /* renamed from: C */
    protected int f12564C = 0;

    /* renamed from: E */
    protected int f12566E = 0;

    /* renamed from: F */
    protected String f12567F = "";

    /* renamed from: G */
    protected String f12568G = "";

    /* renamed from: H */
    protected String f12569H = "";

    /* renamed from: I */
    protected String f12570I = "";

    /* renamed from: J */
    protected String f12571J = null;

    /* renamed from: K */
    protected String f12572K = "";

    /* renamed from: M */
    protected String f12574M = "";

    /* renamed from: N */
    protected volatile int f12575N = 0;

    /* renamed from: O */
    protected volatile int f12576O = 0;

    /* renamed from: P */
    protected volatile long f12577P = 0;

    /* renamed from: Q */
    protected long f12578Q = 0;

    /* renamed from: R */
    protected COUIBaseListPopupWindow_8 f12579R = new COUIBaseListPopupWindow_8();

    /* renamed from: S */
    private PlatformImplementations.kt_3 f12580S = new PlatformImplementations.kt_3();

    /* renamed from: T */
    private HashMap<Integer, PlatformImplementations.kt_3> f12581T = new HashMap<>();

    /* renamed from: V */
    private Paint f12583V = null;

    /* renamed from: W */
    private String f12584W = "";

    /* renamed from: X */
    private boolean f12585X = false;

    /* renamed from: Y */
    private boolean f12586Y = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected boolean m11705h() {
        return false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected boolean mo11283i() {
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected boolean mo11284j() {
        return false;
    }

    /* compiled from: BaseSloganUtil.java */
    /* renamed from: com.oplus.camera.IntrinsicsJvm.kt_3$COUIBaseListPopupWindow_8 */
    public static class COUIBaseListPopupWindow_8 implements Cloneable {

        /* renamed from: PlatformImplementations.kt_3 */
        public Size f12650a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String f12651b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String f12652c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public String f12653d = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public String f12654e = "";

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f12655f = -1;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f12656g = 0;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean f12657h = false;

        /* renamed from: OplusGLSurfaceView_13 */
        public boolean f12658i = true;

        /* renamed from: OplusGLSurfaceView_15 */
        public boolean f12659j = true;

        public String toString() {
            return "YuvInfo, size: " + this.f12650a + ", mWatermarkAuthor: " + this.f12651b + ", mWatermarkTime: " + this.f12652c + ", mWatermarkLocation: " + this.f12653d + ", mOrientation: " + this.f12656g + ", mWatermarkMakeupKey: " + this.f12654e + ", mbAllowLocation: " + this.f12659j;
        }

        public Object clone() {
            try {
                return (COUIBaseListPopupWindow_8) super.clone();
            } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return null;
            }
        }
    }

    public BaseSloganUtil(Activity activity, ComboPreferences comboPreferences, int OplusGLSurfaceView_13) {
        String str;
        this.f12592j = null;
        this.f12593k = null;
        this.f12594l = null;
        this.f12595m = null;
        this.f12596n = null;
        this.f12600r = 0;
        this.f12601s = 0.0f;
        this.f12602t = 0.0f;
        this.f12603u = 0.0f;
        this.f12565D = 0;
        this.f12573L = "";
        this.f12582U = "";
        this.f12593k = activity;
        this.f12594l = comboPreferences;
        this.f12565D = OplusGLSurfaceView_13;
        this.f12573L = Util.m24499v();
        this.f12582U = Util.m24461i("ro.hw.phone.color");
        CameraLog.m12954a("BaseSloganUtil", "SloganUtil, mMarketName: " + this.f12573L + ", mColorFlag: " + this.f12582U);
        if ("00FFF002".equals(this.f12582U) && (str = this.f12573L) != null && !str.toLowerCase().contains("Lamborghini".toLowerCase())) {
            this.f12573L += " Lamborghini";
        }
        m11688k();
        this.f12596n = this.f12593k.getResources();
        this.f12601s = this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_shadow_radius);
        this.f12602t = this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_shadow_x);
        this.f12603u = this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_shadow_y);
        this.f12600r = this.f12596n.getColor(R.color.slogan_text_shadow_color);
        this.f12595m = new FormatConverter();
        File internalSdDirectory = OplusUsbEnvironment.getInternalSdDirectory(this.f12593k);
        if (internalSdDirectory != null) {
            this.f12592j = internalSdDirectory.getAbsolutePath() + File.separator + ".SLOGAN" + File.separator;
            if (new File(this.f12592j).exists()) {
                return;
            }
            m11691n();
            if (DocumentUtil.m16210f(this.f12592j)) {
                return;
            }
            this.f12592j = null;
            CameraLog.m12967f("BaseSloganUtil", "file directory is not exist");
            return;
        }
        m11691n();
        this.f12592j = null;
        CameraLog.m12967f("BaseSloganUtil", "interDir is null");
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m11688k() {
        String str = this.f12573L;
        if (str != null && (str.contains("GT Exp. Master Edition") || this.f12573L.contains("GT Master Edition"))) {
            this.f12573L = "GT Master";
        }
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            String[] strArr = f12557Z;
            if (OplusGLSurfaceView_13 >= strArr.length || m11675a(strArr[OplusGLSurfaceView_13])) {
                break;
            } else {
                OplusGLSurfaceView_13++;
            }
        }
        if (this.f12573L == null || Util.m24348ak()) {
            return;
        }
        this.f12573L = this.f12573L.replace("realme ", "");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m11675a(String str) {
        String str2 = this.f12573L;
        if (str2 != null) {
            String[] strArrSplit = str2.split(" ");
            if (strArrSplit.length > 1 && strArrSplit[strArrSplit.length - 1].equals(str)) {
                this.f12573L = this.f12573L.substring(0, this.f12573L.lastIndexOf(str) - 1);
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11696a(Size size, LocationManager.PlatformImplementations.kt_3 aVar, HashSet<String> hashSet, boolean z, int OplusGLSurfaceView_13, int i2, boolean z2, String str) {
        Size sizeM11663a;
        Bitmap bitmap;
        Bitmap bitmap2;
        if (OplusGLSurfaceView_13 == 0 || 180 == OplusGLSurfaceView_13) {
            sizeM11663a = m11663a(size);
            this.f12575N = 0;
        } else {
            this.f12575N = 1;
            sizeM11663a = size;
        }
        this.f12576O = Util.m24426d(sizeM11663a.getHeight(), sizeM11663a.getWidth());
        this.f12597o = hashSet;
        this.f12577P = System.currentTimeMillis();
        boolean z3 = i2 != 0;
        String strM11687f = m11687f();
        String strM24551a = LocationHelper.m24551a(this.f12593k, aVar);
        String strM11694q = m11694q();
        this.f12588f = false;
        LocationManager.m16155a().m16176a(strM24551a);
        Set<String> stringSet = this.f12594l.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
        String[] stringArray = this.f12593k.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        boolean zContains = stringSet.contains(stringArray[0]);
        boolean zContains2 = stringSet.contains(stringArray[1]);
        boolean zContains3 = stringSet.contains(stringArray[2]);
        if (str.isEmpty()) {
            if (this.f12608z != zContains) {
                this.f12608z = zContains;
                this.f12588f = true;
            }
            if (this.f12606x != zContains3) {
                this.f12606x = zContains3;
                this.f12588f = true;
            }
            if (this.f12607y != zContains2) {
                this.f12607y = zContains2;
                this.f12588f = true;
            }
            String string = this.f12594l.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "");
            if (!string.isEmpty() && !this.f12574M.equals(string)) {
                this.f12574M = string;
                this.f12588f = true;
            }
            this.f12588f = this.f12588f || m11676a(strM11694q, strM11687f, strM24551a, stringSet) || this.f12562A != z3;
        }
        if (!this.f12584W.equals(str) || this.f12575N != this.f12566E) {
            CameraLog.m12954a("BaseSloganUtil", "updateSloganYuv, mMakeupKey: " + this.f12584W + " -> " + str + ", mSloganOrientation: " + this.f12566E + " -> " + this.f12575N);
            this.f12584W = str;
            this.f12588f = true;
        }
        this.f12588f = this.f12590h != 1 && (this.f12588f || (OplusGLSurfaceView_13 == 0 || 180 == OplusGLSurfaceView_13 ? !(!z3 || z || ((bitmap = this.f12604v) != null && !bitmap.isRecycled())) : !(!z3 || z || ((bitmap2 = this.f12605w) != null && !bitmap2.isRecycled()))) || ((z3 && z != this.f12563B) || !sizeM11663a.equals(this.f12599q) || 3 == i2 || (z3 && mo11284j() && mo11283i())));
        this.f12563B = z;
        this.f12562A = z3;
        this.f12578Q = this.f12577P;
        if (this.f12588f) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) && !z2) {
                m11690m();
            } else {
                m11682b(this.f12591i);
            }
            this.f12590h = 1;
            COUIBaseListPopupWindow_8 eVar = this.f12579R;
            eVar.f12650a = sizeM11663a;
            eVar.f12651b = strM11694q;
            eVar.f12652c = strM11687f;
            eVar.f12653d = strM24551a;
            eVar.f12656g = this.f12575N;
            COUIBaseListPopupWindow_8 eVar2 = this.f12579R;
            eVar2.f12654e = this.f12584W;
            eVar2.f12658i = zContains;
            this.f12587e.close();
            m11697a(this.f12579R, i2);
            this.f12587e.open();
            this.f12567F = strM11694q;
            this.f12568G = strM11687f;
            this.f12569H = strM24551a;
            this.f12570I = this.f12573L;
            this.f12571J = this.f12594l.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, null);
            this.f12572K = "2.0.3";
            this.f12564C = this.f12565D;
            this.f12566E = this.f12575N;
            this.f12599q = sizeM11663a;
            this.f12590h = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11697a(COUIBaseListPopupWindow_8 eVar, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        float height;
        int screenHeight;
        CameraLog.m12954a("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s0:create bitmap start");
        if ("".equals(eVar.f12654e)) {
            this.f12580S = mo11281a(this.f12593k, this.f12594l, eVar);
        } else {
            this.f12580S = m11664a(this.f12593k, eVar, this.f12594l);
        }
        CameraLog.m12954a("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s1:create yuv prepare");
        PlatformImplementations.kt_3 aVar = this.f12580S;
        if (aVar != null) {
            Bitmap bitmapM11720f = aVar.m11720f();
            this.f12581T.put(Integer.valueOf(this.f12575N), this.f12580S);
            int dimensionPixelSize = this.f12596n.getDimensionPixelSize(R.dimen.normal_slogan_text_margin_left);
            if (Util.m24498u()) {
                if (eVar.f12650a.getHeight() >= eVar.f12650a.getWidth()) {
                    height = (eVar.f12650a.getWidth() * 1.0f) / Util.getScreenHeight();
                    screenHeight = Util.getScreenWidth();
                } else {
                    height = (eVar.f12650a.getHeight() * 1.0f) / Util.getScreenHeight();
                    screenHeight = Util.getScreenHeight();
                }
            } else if (eVar.f12650a.getHeight() >= eVar.f12650a.getWidth()) {
                height = (eVar.f12650a.getWidth() * 1.0f) / Util.getScreenWidth();
                screenHeight = Util.getScreenWidth();
            } else {
                height = (eVar.f12650a.getHeight() * 1.0f) / Util.getScreenWidth();
                screenHeight = Util.getScreenHeight();
            }
            int i2 = screenHeight - (dimensionPixelSize * 2);
            int iFloor = (int) Math.floor(bitmapM11720f.getWidth() / height);
            if (iFloor > i2 + dimensionPixelSize) {
                float COUIBaseListPopupWindow_12 = (i2 * 1.0f) / (iFloor - dimensionPixelSize);
                int width = (int) (bitmapM11720f.getWidth() * COUIBaseListPopupWindow_12);
                int height2 = (int) (bitmapM11720f.getHeight() * COUIBaseListPopupWindow_12);
                if (width % 2 != 0) {
                    width++;
                }
                if (height2 % 2 != 0) {
                    height2++;
                }
                bitmapM11720f = Bitmap.createScaledBitmap(bitmapM11720f, width, height2, true);
                iFloor = i2 + (dimensionPixelSize * 2);
            }
            this.f12580S.m11709a(new Size(bitmapM11720f.getWidth(), bitmapM11720f.getHeight()));
            this.f12580S.m11707a(iFloor);
            this.f12591i = ".slogan_" + System.currentTimeMillis() + "_" + bitmapM11720f.getWidth() + "x" + bitmapM11720f.getHeight() + "_" + iFloor + ".yuv";
            StringBuilder sb = new StringBuilder();
            sb.append("generateSloganBuffer, waterMarkBitmap width: ");
            sb.append(bitmapM11720f.getWidth());
            sb.append(", height(): ");
            sb.append(bitmapM11720f.getHeight());
            sb.append(", watermarkWidthInScreen: ");
            sb.append(iFloor);
            CameraLog.m12954a("BaseSloganUtil", sb.toString());
            CameraLog.m12954a("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s2:create yuv start");
            boolean zM11673a = m11673a(bitmapM11720f, this.f12562A && this.f12563B, "".equals(eVar.f12654e));
            if (this.f12562A && !this.f12563B) {
                m11670a(bitmapM11720f);
            } else {
                bitmapM11720f.recycle();
            }
            CameraLog.m12954a("BaseSloganUtil", "generateSloganBuffer,slogan buffer build " + zM11673a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m11673a(Bitmap bitmap, boolean z, boolean z2) {
        if (bitmap == null || bitmap.isRecycled()) {
            CameraLog.m12967f("BaseSloganUtil", "generateYuvFile fail, bitmap: " + bitmap);
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int OplusGLSurfaceView_13 = width * height;
        int i2 = (int) (OplusGLSurfaceView_13 * 1.5f);
        byte[] bArr = new byte[i2 + OplusGLSurfaceView_13];
        byte[] bArr2 = new byte[OplusGLSurfaceView_13];
        FormatConverter formatConverter = this.f12595m;
        int sloganBuffer = -1;
        int iArgbToNv21 = formatConverter != null ? formatConverter.argbToNv21(bitmap, bArr, bArr2, 0, z2) : -1;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        CameraLog.m12954a("BaseSloganUtil", "generateYuvBuffer, width: " + width + ", height: " + height + ", flag: " + iArgbToNv21 + ", isPremultiplied: " + z2);
        if (iArgbToNv21 < 0) {
            CameraLog.m12967f("BaseSloganUtil", "generateYuvBuffer fail, yuvData: " + bArr);
            return false;
        }
        PlatformImplementations.kt_3 aVar = this.f12580S;
        if (aVar != null) {
            aVar.m11711a(bArr);
        }
        boolean zM16198a = true;
        if (2 == AlgoSwitchConfig.getApsVersion() && z && m11689l() != null) {
            sloganBuffer = m11689l().setSloganBuffer(bArr, width, height, bArr.length, this.f12591i);
        }
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            zM16198a = DocumentUtil.m16198a(this.f12592j + this.f12591i, "application/octet-stream", bArr);
        }
        CameraLog.m12954a("BaseSloganUtil", "generateYuvFile, setBufferResult: " + sloganBuffer);
        return zM16198a;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private OplusSloganJNI m11689l() {
        if (this.f12598p == null) {
            this.f12598p = new OplusSloganJNI();
        }
        return this.f12598p;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m11682b(String str) {
        CameraLog.m12954a("BaseSloganUtil", "deleteDir, yuvFileDir: " + str);
        if (this.f12592j == null) {
            return;
        }
        File file = new File(str);
        if (!file.isDirectory()) {
            CameraLog.m12959b("BaseSloganUtil", "deleteDir, dir is not directory");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            CameraLog.m12959b("BaseSloganUtil", "deleteDir, fileList is null");
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null && file2.isFile()) {
                String name = file2.getName();
                String absolutePath = file2.getAbsolutePath();
                String[] strArrSplit = name.split("_");
                if (strArrSplit.length == 4) {
                    String str2 = strArrSplit[1];
                    CameraLog.m12959b("BaseSloganUtil", "deleteDir, timeStamp: " + str2 + ", mYuvDoneTimeStamp: " + this.f12578Q + ", filePath: " + absolutePath);
                    try {
                        if (TextUtils.isEmpty(str2) || !TextUtils.isDigitsOnly(str2)) {
                            DocumentUtil.m16205c(absolutePath);
                        } else if (Math.abs(this.f12578Q - Long.parseLong(str2)) >= 300000 && !this.f12597o.contains(absolutePath)) {
                            DocumentUtil.m16205c(absolutePath);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        m11690m();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m11690m() {
        if (2 == AlgoSwitchConfig.getApsVersion() && this.f12562A && m11689l() != null) {
            CameraLog.m12959b("BaseSloganUtil", "deleteDir, JNI sloganFileDeleteAll result: " + m11689l().sloganFileDeleteAll());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m11676a(String str, String str2, String str3, Set<String> set) throws Resources.NotFoundException {
        String str4;
        CameraLog.m12954a("BaseSloganUtil", "isSloganInfoChange, currentAuthor: " + str + ", mWatermarkAuthor: " + this.f12567F + ", currentTime: " + str2 + ", mWatermarkTime: " + this.f12568G + ", VERSION: 2.0.3, mSloganVersion: " + this.f12572K + ", mMarketName: " + this.f12573L + ", mWatermarkMarketName: " + this.f12570I + ", mEnterType: " + this.f12565D + ", mSloganEnterType: " + this.f12564C + ", mCurrentOrientation" + this.f12575N + ", mSloganOrientation" + this.f12566E + ", mWatermarkSize: " + this.f12571J);
        String[] stringArray = this.f12593k.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        boolean zContains = set.contains(stringArray[1]);
        boolean zContains2 = set.contains(stringArray[2]);
        String string = this.f12594l.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, null);
        if (!str.equals(this.f12567F)) {
            return true;
        }
        if (str2.equals(this.f12568G) || !zContains) {
            return ((str3.equals(this.f12569H) || !zContains2) && this.f12573L.equals(this.f12570I) && "2.0.3".equals(this.f12572K) && this.f12565D == this.f12564C && this.f12575N == this.f12566E && (str4 = this.f12571J) != null && str4.equals(string)) ? false : true;
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m11691n() {
        CameraLog.m12954a("BaseSloganUtil", "clearAllPrefValue");
        this.f12567F = "";
        this.f12568G = "";
        this.f12569H = "";
        this.f12570I = "";
        this.f12572K = "";
        this.f12564C = 0;
        this.f12566E = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String m11684c(String str) {
        if (str == null) {
            return null;
        }
        String strReplaceAll = Pattern.compile("[一-龥]").matcher(str).replaceAll("");
        CameraLog.m12959b("BaseSloganUtil", "removeChineseOfString, repickStr: " + strReplaceAll);
        return strReplaceAll;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected static Typeface m11662a() {
        Typeface typeface = f12558a;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 850");
            f12558a = builder.build();
        } catch (Exception unused) {
            f12558a = Typeface.DEFAULT;
            CameraLog.m12967f("BaseSloganUtil", "getMarketFontTypeface, create special typeface fail");
        }
        return f12558a;
    }

    /* renamed from: o */
    private static Typeface m11692o() {
        Typeface typeface = f12559b;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 700");
            f12559b = builder.build();
        } catch (Exception unused) {
            f12559b = Typeface.DEFAULT;
            CameraLog.m12967f("BaseSloganUtil", "getNormalFontTypeface, create special typeface fail");
        }
        return f12559b;
    }

    /* renamed from: p */
    private static Typeface m11693p() {
        Typeface typeface = f12560c;
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface.Builder builder = new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 1000");
            f12560c = builder.build();
        } catch (Exception unused) {
            f12560c = Typeface.DEFAULT;
            CameraLog.m12967f("BaseSloganUtil", "getMakeupFontTypeface, create special typeface fail");
        }
        return f12560c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static float m11659a(Context context, COUIBaseListPopupWindow_8 eVar, int OplusGLSurfaceView_13) {
        int height;
        float COUIBaseListPopupWindow_12 = 1.0f;
        if (!eVar.f12657h) {
            if (eVar.f12650a.getWidth() < eVar.f12650a.getHeight()) {
                height = eVar.f12650a.getWidth();
            } else {
                height = eVar.f12650a.getHeight();
            }
            COUIBaseListPopupWindow_12 = (height * 1.0f) / OplusGLSurfaceView_13;
        }
        return Util.m24495t() ? (COUIBaseListPopupWindow_12 * 480.0f) / 440.0f : COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m11699b() {
        this.f12587e.block(3000L);
        return this.f12580S;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PlatformImplementations.kt_3 m11695a(int OplusGLSurfaceView_13) {
        this.f12587e.block(3000L);
        CameraLog.m12959b("BaseSloganUtil", "getVideoWatermarkBitmap, orientation: " + OplusGLSurfaceView_13);
        PlatformImplementations.kt_3 aVar = this.f12580S;
        if (aVar == null) {
            return null;
        }
        if (OplusGLSurfaceView_13 == 0 || 180 == OplusGLSurfaceView_13) {
            this.f12580S.m11708a(this.f12604v);
        } else {
            aVar.m11708a(this.f12605w);
        }
        return this.f12580S;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Map<Integer, PlatformImplementations.kt_3> m11701c() {
        this.f12587e.block(3000L);
        return this.f12581T;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m11702d() {
        this.f12587e.block(3000L);
        String str = this.f12592j + this.f12591i;
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            CameraLog.m12954a("BaseSloganUtil", "getYuvFilePath, return path: " + this.f12591i);
            return this.f12591i;
        }
        CameraLog.m12954a("BaseSloganUtil", "getYuvFilePath, return path: " + str);
        return str;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m11703e() {
        this.f12589g = 0;
        if (TextUtils.isEmpty(m11694q())) {
            this.f12589g = 1;
        } else {
            this.f12589g = 2;
        }
        return this.f12589g;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static String m11687f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault());
        TimeZone timeZone = TimeZone.getDefault();
        if (!timeZone.equals(simpleDateFormat.getTimeZone())) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: q */
    private String m11694q() {
        String string = this.f12594l.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        CameraLog.m12954a("BaseSloganUtil", "getWatermarkAuthor, author: " + string);
        return string;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected static IntrinsicsJvm.kt_5 m11666a(Context context, float COUIBaseListPopupWindow_12, ComboPreferences comboPreferences) throws Resources.NotFoundException {
        IntrinsicsJvm.kt_5 dVar = new IntrinsicsJvm.kt_5();
        dVar.f12643a = (int) (Util.m24202a(context, R.dimen.watermark_preview_transverse, Util.f22962a) * COUIBaseListPopupWindow_12);
        dVar.f12644b = (int) (Util.m24202a(context, R.dimen.watermark_preview_text_interval, Util.f22962a) * COUIBaseListPopupWindow_12);
        dVar.f12645c = (int) (Util.m24202a(context, R.dimen.watermark_preview_logo_corner_portrait_interval, Util.f22962a) * COUIBaseListPopupWindow_12);
        dVar.f12646d = (int) (Util.m24202a(context, R.dimen.watermark_preview_logo_portrait_interval, Util.f22962a) * COUIBaseListPopupWindow_12);
        dVar.f12647e = (int) (Util.m24202a(context, R.dimen.watermark_self_transverse_interval, Util.f22962a) * COUIBaseListPopupWindow_12);
        dVar.f12649g = (int) (Util.m24202a(context, R.dimen.watermark_logo_text_transverse, Util.f22962a) * COUIBaseListPopupWindow_12);
        String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_size_values);
        String string = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            dVar.f12648f = (int) (Util.m24202a(context, R.dimen.watermark_self_portrait_interval_large, Util.f22962a) * COUIBaseListPopupWindow_12);
        } else if (stringArray[1].equals(string)) {
            dVar.f12648f = (int) (Util.m24202a(context, R.dimen.watermark_self_portrait_interval_default, Util.f22962a) * COUIBaseListPopupWindow_12);
        } else {
            dVar.f12648f = (int) (Util.m24202a(context, R.dimen.watermark_self_portrait_interval_small, Util.f22962a) * COUIBaseListPopupWindow_12);
        }
        return dVar;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int m11685d(String str) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            if (str.charAt(OplusGLSurfaceView_13) != ' ') {
                return OplusGLSurfaceView_13;
            }
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m11667a(String str, Paint paint, int OplusGLSurfaceView_13, String str2) {
        if (m11674a(paint, str, OplusGLSurfaceView_13)) {
            int iMeasureText = str2 != null ? (int) paint.measureText(str2) : 0;
            int iM11685d = m11685d(str);
            int iMeasureText2 = str.startsWith(" ") ? (int) paint.measureText(str, 0, iM11685d) : 0;
            int iMeasureText3 = (int) paint.measureText(str, iM11685d, iM11685d + 1);
            int i2 = (OplusGLSurfaceView_13 - iMeasureText) - iMeasureText2;
            int length = (i2 / iMeasureText3) + iM11685d;
            String strSubstring = length > 0 ? str.substring(0, length) : "";
            if (length >= strSubstring.length()) {
                length = strSubstring.length();
            }
            String strSubstring2 = strSubstring.substring(0, length);
            if (str2 != null) {
                strSubstring2 = strSubstring2 + str2;
            }
            int iMeasureText4 = (int) ((OplusGLSurfaceView_13 - paint.measureText(strSubstring2)) / iMeasureText3);
            int i3 = length + iMeasureText4;
            String strSubstring3 = i3 > 0 ? str.substring(0, i3) : "";
            if (str2 != null) {
                str = strSubstring3 + str2;
            } else {
                str = strSubstring3;
            }
            CameraLog.m12959b("BaseSloganUtil", "createSplitString, inputString: " + strSubstring2 + ", endSymbol:" + str2 + ", endSymbolWidth: " + iMeasureText + ", remainingWidth: " + i2 + ", contentSize: " + i3 + ", limit: " + OplusGLSurfaceView_13 + ", deviationSize: " + iMeasureText4 + ", outputString: " + str);
        }
        return str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m11674a(Paint paint, String str, int OplusGLSurfaceView_13) {
        return paint.measureText(str) > ((float) OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11670a(Bitmap bitmap) {
        if (this.f12579R.f12650a == null || bitmap == null) {
            return;
        }
        if (this.f12575N == 0 || 180 == this.f12575N) {
            this.f12604v = bitmap;
        } else {
            this.f12605w = bitmap;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m11663a(Size size) {
        if (size != null) {
            return new Size(size.getHeight(), size.getWidth());
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m11704g() throws Resources.NotFoundException {
        if (Util.m24504x(this.f12593k)) {
            return;
        }
        String[] stringArray = this.f12593k.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        Set<String> stringSet = this.f12594l.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
        boolean zRemove = stringSet.remove(stringArray[2]);
        SharedPreferences.Editor editorEdit = this.f12594l.edit();
        if (zRemove) {
            editorEdit.putStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, stringSet);
        }
        if (stringSet.isEmpty()) {
            editorEdit.putBoolean(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN, true);
            editorEdit.putString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off");
        }
        editorEdit.apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11698a(boolean z) {
        this.f12585X = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11700b(boolean z) {
        this.f12586Y = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0946  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0211  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.oplus.camera.BaseSloganUtil.PlatformImplementations.kt_3 mo11281a(android.content.Context r32, com.oplus.camera.ComboPreferences r33, com.oplus.camera.BaseSloganUtil.COUIBaseListPopupWindow_8 r34) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.BaseSloganUtil.mo11281a(android.content.Context, com.oplus.camera.ComboPreferences, com.oplus.camera.IntrinsicsJvm.kt_3$COUIBaseListPopupWindow_8):com.oplus.camera.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Size m11680b(Size size) {
        int width = (int) (size.getWidth() * 1.0999999f);
        int width2 = (int) ((size.getWidth() * 0.32000002f) + size.getHeight());
        if (width % 2 != 0) {
            width++;
        }
        if (width2 % 2 != 0) {
            width2++;
        }
        return new Size(width, width2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PlatformImplementations.kt_3 m11664a(Context context, COUIBaseListPopupWindow_8 eVar, SharedPreferences sharedPreferences) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
        Paint paint = new Paint();
        int iM24406c = Util.m24406c(context, R.drawable.bg_watermark_makeup_visualization, 1.0f, Util.f22962a);
        int width = eVar.f12650a.getWidth();
        if (!eVar.f12657h) {
            eVar.f12650a = m11680b(eVar.f12650a);
        }
        float fM11659a = m11659a(context, eVar, iM24406c);
        Map<String, IntrinsicsJvm.kt_3> mapM11668a = m11668a(context, fM11659a, eVar, (ComboPreferences) sharedPreferences);
        IntrinsicsJvm.kt_3 cVar = mapM11668a.get("key_watermark_part_a_line");
        IntrinsicsJvm.kt_3 cVar2 = mapM11668a.get("key_watermark_part_b_line");
        IntrinsicsJvm.kt_3 cVar3 = mapM11668a.get("key_watermark_part_name_line");
        IntrinsicsJvm.kt_3 cVar4 = mapM11668a.get("key_watermark_part_c_line");
        if (cVar == null || cVar2 == null || cVar4 == null || cVar3 == null) {
            CameraLog.m12954a("BaseSloganUtil", "createWatermarkMakeupBitmapHold, hold is null");
            return null;
        }
        Bitmap bitmap = cVar3.f12638f;
        int iM11656a = (int) m11656a(context, R.dimen.watermark_makeup_transverse, fM11659a);
        int iM11656a2 = (int) m11656a(context, R.dimen.watermark_makeup_portrait, fM11659a);
        int iM11656a3 = (int) m11656a(context, R.dimen.watermark_makeup_a_self_portrait, fM11659a);
        int iM11656a4 = (int) m11656a(context, R.dimen.watermark_makeup_b_self_portrait, fM11659a);
        int iM11656a5 = (int) m11656a(context, R.dimen.watermark_makeup_c_self_portrait, fM11659a);
        int iM11678b = m11678b(context, eVar, eVar.f12650a.getWidth());
        int iM11656a6 = (int) m11656a(context, R.dimen.watermark_makeup_first_max_width, fM11659a);
        if (!eVar.f12657h) {
            iM11656a4 = (int) (iM11656a4 - 3.0f);
            iM11656a5 = (int) (iM11656a5 - 3.0f);
            iM11656a3 = (int) (iM11656a3 - 3.0f);
        }
        int OplusGLSurfaceView_13 = iM11678b - (iM11656a * 2);
        int height = bitmap.getHeight() + cVar.m11752d() + cVar4.m11752d();
        if (OplusGLSurfaceView_13 % 2 != 0) {
            OplusGLSurfaceView_13++;
        }
        if (height % 2 != 0) {
            height++;
        }
        Bitmap bitmapM24215a = Util.m24215a(OplusGLSurfaceView_13, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapM24215a);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.drawText(cVar.m11741a(), 0.0f, ((bitmap.getHeight() + cVar.m11752d()) - cVar.m11755g()) - iM11656a3, cVar.m11754f());
        if (cVar4.m11751c() > iM11656a6) {
            String strM11741a = cVar4.m11741a();
            String strM11667a = m11667a(strM11741a, cVar4.m11754f(), iM11656a6, "");
            String strReplace = cVar4.m11741a().replace(strM11667a, "");
            boolean z = cVar4.f12637e && (strM11667a.contains("Bobbi Brown") || strReplace.contains("Bobbi Brown"));
            int iIndexOf = strM11741a.indexOf("Bobbi Brown");
            if (!z && -1 != iIndexOf) {
                StringBuilder sb = new StringBuilder(strM11667a);
                sb.replace(iIndexOf, strM11667a.length(), "");
                StringBuilder sb2 = new StringBuilder(strReplace);
                sb2.replace(0, 11 - (strM11667a.length() - iIndexOf), "Bobbi Brown");
                strM11667a = sb.toString();
                strReplace = sb2.toString();
            }
            canvas.drawText(cVar2.m11741a(), OplusGLSurfaceView_13 - cVar2.m11751c(), (((height - (cVar4.m11752d() * 2)) - cVar2.m11755g()) - iM11656a5) - iM11656a4, cVar2.m11754f());
            float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
            canvas.drawText(strM11667a, COUIBaseListPopupWindow_12 - cVar4.m11754f().measureText(strM11667a), ((height - cVar4.m11755g()) - iM11656a5) - cVar4.m11752d(), cVar4.m11754f());
            canvas.drawText(strReplace, COUIBaseListPopupWindow_12 - cVar4.m11754f().measureText(strReplace), (height - cVar4.m11755g()) - iM11656a5, cVar4.m11754f());
        } else {
            canvas.drawText(cVar2.m11741a(), OplusGLSurfaceView_13 - cVar2.m11751c(), ((((height - cVar4.m11752d()) - cVar2.m11755g()) - iM11656a5) - iM11656a4) - cVar4.m11752d(), cVar2.m11754f());
            canvas.drawText(cVar4.m11741a(), OplusGLSurfaceView_13 - cVar4.m11751c(), ((height - cVar4.m11755g()) - iM11656a5) - cVar4.m11752d(), cVar4.m11754f());
        }
        aVar.m11708a(bitmapM24215a);
        aVar.m11712b(iM11656a);
        aVar.m11715c(iM11656a2 - cVar4.m11752d());
        aVar.m11710a(eVar);
        if (!eVar.f12657h) {
            int i2 = (int) (width * 0.05f);
            int i3 = i2 % 2;
            int i4 = i3 != 0 ? i2 + 1 : i2;
            if (i3 != 0) {
                i2++;
            }
            aVar.m11723g(eVar.f12650a.getWidth());
            aVar.m11725h(eVar.f12650a.getHeight());
            aVar.m11727i(i4);
            aVar.m11729j(i2);
        }
        CameraLog.m12954a("BaseSloganUtil", "createWatermarkMakeupBitmapHold, imageWidth: " + aVar.m11728j() + ", imageHeight: " + aVar.m11730k() + ", x: " + aVar.m11731l() + ", y: " + aVar.m11732m() + ", watermarkWidth: " + OplusGLSurfaceView_13 + ", watermarkHeight: " + height + ", scale: " + fM11659a);
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m11660a(Context context, float COUIBaseListPopupWindow_12, String str, int OplusGLSurfaceView_13) {
        if (f12561d == null) {
            f12561d = new HashMap();
        }
        Bitmap bitmap = f12561d.get(str + COUIBaseListPopupWindow_12);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapM24370b = Util.m24370b(context, OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, Util.f22962a);
        f12561d.put(str + COUIBaseListPopupWindow_12, bitmapM24370b);
        return bitmapM24370b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m11678b(Context context, COUIBaseListPopupWindow_8 eVar, int OplusGLSurfaceView_13) {
        return !eVar.f12657h ? eVar.f12650a.getWidth() : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<String, IntrinsicsJvm.kt_3> m11668a(Context context, float COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_8 eVar, ComboPreferences comboPreferences) {
        CameraLog.m12954a("BaseSloganUtil", "createWatermarkMakeupText");
        IntrinsicsJvm.kt_4 bVarM11665a = m11665a(context, eVar, COUIBaseListPopupWindow_12);
        IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3(context, comboPreferences, 1.0f);
        cVar.f12638f = bVarM11665a.f12631c;
        IntrinsicsJvm.kt_3 cVar2 = new IntrinsicsJvm.kt_3(context, comboPreferences, 1.0f, false);
        cVar2.m11754f().setTextSize(m11656a(context, R.dimen.watermark_makeup_name_size, COUIBaseListPopupWindow_12));
        cVar2.m11754f().setColor(bVarM11665a.f12630b);
        cVar2.m11754f().setTypeface(m11692o());
        cVar2.m11750b(bVarM11665a.f12629a);
        IntrinsicsJvm.kt_3 cVar3 = new IntrinsicsJvm.kt_3(context, comboPreferences, 1.0f, false);
        cVar3.m11754f().setTextSize(m11656a(context, R.dimen.watermark_makeup_device_size, COUIBaseListPopupWindow_12));
        cVar3.m11754f().setColor(context.getColor(R.color.color_black_with_full_percent_transparency));
        cVar3.m11754f().setTypeface(m11693p());
        cVar3.m11750b(m11684c(Util.m24499v()));
        IntrinsicsJvm.kt_3 cVar4 = new IntrinsicsJvm.kt_3(context, comboPreferences, 1.0f, false);
        cVar4.m11754f().setTextSize(m11656a(context, R.dimen.watermark_makeup_slogan_device, COUIBaseListPopupWindow_12));
        cVar4.m11754f().setColor(context.getColor(R.color.color_black_with_full_percent_transparency));
        cVar4.m11754f().setTypeface(m11692o());
        if (!bVarM11665a.f12632d) {
            cVar4.m11750b(context.getString(R.string.camera_beauty_makeup_watermark_normal_slogan));
        } else {
            cVar4.f12637e = true;
            cVar4.m11750b(context.getString(R.string.camera_beauty_makeup_watermark_custom_slogan));
        }
        HashMap map = new HashMap();
        map.put("key_watermark_part_a_line", cVar2);
        map.put("key_watermark_part_b_line", cVar3);
        map.put("key_watermark_part_c_line", cVar4);
        map.put("key_watermark_part_name_line", cVar);
        CameraLog.m12954a("BaseSloganUtil", "createWatermarkMakeupText, X");
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.BaseSloganUtil.IntrinsicsJvm.kt_4 m11665a(android.content.Context r7, com.oplus.camera.BaseSloganUtil.COUIBaseListPopupWindow_8 r8, float r9) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.BaseSloganUtil.m11665a(android.content.Context, com.oplus.camera.IntrinsicsJvm.kt_3$COUIBaseListPopupWindow_8, float):com.oplus.camera.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static float m11656a(Context context, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return Util.m24202a(context, OplusGLSurfaceView_13, Util.f22962a) * COUIBaseListPopupWindow_12;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static boolean m11686e(String str) {
        return TtmlNode.CENTER.equals(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m11671a(ComboPreferences comboPreferences, IntrinsicsJvm.kt_3 cVar, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= cVar.m11751c()) {
            return;
        }
        String string = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        int i2 = (string == null || string.isEmpty()) ? 0 : 1;
        for (int i3 = 0; i3 < cVar.m11749b().size(); i3++) {
            if (i3 != i2) {
                OplusGLSurfaceView_13 = (int) (((int) (((int) ((OplusGLSurfaceView_13 - cVar.m11748b(i3)) - cVar.m11756h())) - cVar.m11757i())) - cVar.m11758j());
            }
        }
        cVar.m11747a(m11667a(cVar.m11742a(i2), cVar.m11754f(), OplusGLSurfaceView_13, "..."), i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<String, IntrinsicsJvm.kt_3> m11669a(Context context, ComboPreferences comboPreferences, float COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_8 eVar) throws Resources.NotFoundException {
        boolean z;
        boolean zContains;
        boolean zContains2;
        Set<String> stringSet = comboPreferences.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
        String string = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        if ((stringSet == null || stringSet.isEmpty()) && ((string == null || string.isEmpty()) && 1 != CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEVICE_SERIES))) {
            CameraLog.m12954a("BaseSloganUtil", "createWatermarkText, chooseDisplayValues is null or empty");
            return new HashMap();
        }
        String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        ArrayList arrayList = new ArrayList();
        String strM11684c = m11684c(Util.m24499v());
        if (stringSet == null || stringSet.isEmpty()) {
            z = false;
            zContains = false;
            zContains2 = false;
        } else {
            zContains = stringSet.contains(stringArray[0]);
            zContains2 = stringSet.contains(stringArray[1]);
            z = stringSet.contains(stringArray[2]) && eVar.f12659j;
        }
        if (string != null && !string.isEmpty()) {
            arrayList.add(string);
        }
        if (z) {
            arrayList.add(eVar.f12653d);
        }
        if (zContains2) {
            arrayList.add(eVar.f12652c);
        }
        CameraLog.m12954a("BaseSloganUtil", "createWatermarkText, isWatermarkDevice: " + zContains + ", isWatermarkTime: " + zContains2 + ", isWatermarkLocation: " + z);
        HashMap map = new HashMap();
        float fM11658a = m11658a(context, comboPreferences, COUIBaseListPopupWindow_12, false);
        IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3(context, comboPreferences, COUIBaseListPopupWindow_12);
        map.put("key_watermark_part_a_line", cVar);
        if (!zContains) {
            cVar.m11743a(fM11658a);
            cVar.m11745a(m11692o());
            if (!eVar.f12657h) {
                cVar.m11754f().setLetterSpacing(0.007f);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!str.isEmpty()) {
                    cVar.m11746a(str);
                }
            }
            if (arrayList.isEmpty()) {
                cVar.m11746a(context.getString(R.string.camera_watermark_default_slogan));
            }
            return map;
        }
        if (!strM11684c.isEmpty()) {
            cVar.m11746a(strM11684c);
        }
        cVar.m11743a(m11658a(context, comboPreferences, COUIBaseListPopupWindow_12, true));
        cVar.m11745a(m11662a());
        cVar.m11754f().setLetterSpacing(0.03f);
        IntrinsicsJvm.kt_3 cVar2 = new IntrinsicsJvm.kt_3(context, comboPreferences, COUIBaseListPopupWindow_12);
        cVar2.m11743a(fM11658a);
        cVar2.m11745a(m11692o());
        if (!eVar.f12657h) {
            cVar2.m11754f().setLetterSpacing(0.007f);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (!str2.isEmpty()) {
                cVar2.m11746a(str2);
            }
        }
        map.put("key_watermark_part_b_line", cVar2);
        return map;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static float m11658a(Context context, ComboPreferences comboPreferences, float COUIBaseListPopupWindow_12, boolean z) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_size_values);
        String string = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            OplusGLSurfaceView_13 = z ? R.dimen.watermark_text_device_large : R.dimen.watermark_text_large;
        } else {
            OplusGLSurfaceView_13 = stringArray[1].equals(string) ? z ? R.dimen.watermark_text_device_default : R.dimen.watermark_text_default : z ? R.dimen.watermark_text_device_small : R.dimen.watermark_text_small;
        }
        return Util.m24202a(context, OplusGLSurfaceView_13, Util.f22962a) * COUIBaseListPopupWindow_12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m11677b(Context context, ComboPreferences comboPreferences, float COUIBaseListPopupWindow_12) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_size_values);
        String string = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            OplusGLSurfaceView_13 = R.dimen.watermark_divider_large_height;
        } else {
            OplusGLSurfaceView_13 = stringArray[1].equals(string) ? R.dimen.watermark_divider_default_height : R.dimen.watermark_divider_small_height;
        }
        return Util.m24202a(context, OplusGLSurfaceView_13, Util.f22962a) * COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Bitmap m11683c(Context context, ComboPreferences comboPreferences, float COUIBaseListPopupWindow_12) throws Resources.NotFoundException {
        String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_size_values);
        String string = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            return Util.m24217a(context, R.drawable.ic_copyright_large, COUIBaseListPopupWindow_12, Util.f22962a);
        }
        if (stringArray[1].equals(string)) {
            return Util.m24217a(context, R.drawable.ic_copyright_default, COUIBaseListPopupWindow_12, Util.f22962a);
        }
        return Util.m24217a(context, R.drawable.ic_copyright_small, COUIBaseListPopupWindow_12, Util.f22962a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Bitmap m11679b(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap.extractAlpha(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Paint m11661a(Context context) {
        Paint paint = new Paint();
        paint.setMaskFilter(new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.OUTER));
        paint.setColor(context.getResources().getColor(R.color.color_black_with_30_percent_transparency));
        return paint;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap mo11280a(Context context, float COUIBaseListPopupWindow_12) {
        if (Util.m24495t()) {
            return Util.m24217a(context, R.drawable.ic_watermark_logo_type_fold, COUIBaseListPopupWindow_12 / 4.0f, Util.f22962a);
        }
        if ("00FFF006".equals(this.f12582U) && this.f12608z) {
            return Util.m24217a(context, R.drawable.salah_logan, COUIBaseListPopupWindow_12 / 2.77777f, Util.f22962a);
        }
        if (CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEVICE_SERIES) == 0) {
            return Util.m24217a(context, R.drawable.ic_watermark_logo_type_reno, COUIBaseListPopupWindow_12 / 4.0f, Util.f22962a);
        }
        if (1 == CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEVICE_SERIES)) {
            return Util.m24217a(context, R.drawable.ic_watermark_logo_type_find, COUIBaseListPopupWindow_12 / 4.0f, Util.f22962a);
        }
        return Util.m24217a(context, R.drawable.ic_watermark_logo_type_reno, COUIBaseListPopupWindow_12 / 4.0f, Util.f22962a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m11672a(Context context, ComboPreferences comboPreferences) {
        Set<String> stringSet = comboPreferences.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
        if (stringSet == null || stringSet.isEmpty()) {
            CameraLog.m12967f("BaseSloganUtil", "isWatermarkLocationOpen, chooseDisplayValues is : " + stringSet);
            return false;
        }
        return stringSet.contains(context.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values)[2]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m11681b(Context context, ComboPreferences comboPreferences) throws Resources.NotFoundException {
        String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        Set<String> stringSet = comboPreferences.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
        if (stringSet != null && stringSet.remove(stringArray[2])) {
            comboPreferences.edit().putStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, stringSet).apply();
        }
    }

    /* compiled from: BaseSloganUtil.java */
    /* renamed from: com.oplus.camera.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private Size f12609a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private byte[] f12610b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f12611c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f12612d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f12613e = 0;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private Bitmap f12614f = null;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f12615g = 0;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f12616h = 0;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f12617i = 0;

        /* renamed from: OplusGLSurfaceView_15 */
        private COUIBaseListPopupWindow_8 f12618j = null;

        /* renamed from: OplusGLSurfaceView_5 */
        private int f12619k = 0;

        /* renamed from: OplusGLSurfaceView_14 */
        private int f12620l = 0;

        /* renamed from: OplusGLSurfaceView_6 */
        private int f12621m = 0;

        /* renamed from: OplusGLSurfaceView_11 */
        private int f12622n = 0;

        /* renamed from: PlatformImplementations.kt_3 */
        public Size m11706a() {
            return this.f12609a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11709a(Size size) {
            this.f12609a = size;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public byte[] m11713b() {
            return this.f12610b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11711a(byte[] bArr) {
            this.f12610b = bArr;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m11714c() {
            return this.f12611c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11707a(int OplusGLSurfaceView_13) {
            this.f12611c = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m11716d() {
            return this.f12612d;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m11712b(int OplusGLSurfaceView_13) {
            this.f12612d = OplusGLSurfaceView_13;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int m11718e() {
            return this.f12613e;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m11715c(int OplusGLSurfaceView_13) {
            this.f12613e = OplusGLSurfaceView_13;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public Bitmap m11720f() {
            return this.f12614f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11708a(Bitmap bitmap) {
            this.f12614f = bitmap;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int m11722g() {
            return this.f12615g;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m11717d(int OplusGLSurfaceView_13) {
            this.f12615g = OplusGLSurfaceView_13;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m11719e(int OplusGLSurfaceView_13) {
            this.f12616h = OplusGLSurfaceView_13;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int m11724h() {
            return this.f12617i;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public void m11721f(int OplusGLSurfaceView_13) {
            this.f12617i = OplusGLSurfaceView_13;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public COUIBaseListPopupWindow_8 m11726i() {
            return this.f12618j;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11710a(COUIBaseListPopupWindow_8 eVar) {
            this.f12618j = eVar;
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public int m11728j() {
            return this.f12619k;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public void m11723g(int OplusGLSurfaceView_13) {
            this.f12619k = OplusGLSurfaceView_13;
        }

        /* renamed from: OplusGLSurfaceView_5 */
        public int m11730k() {
            return this.f12620l;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public void m11725h(int OplusGLSurfaceView_13) {
            this.f12620l = OplusGLSurfaceView_13;
        }

        /* renamed from: OplusGLSurfaceView_14 */
        public int m11731l() {
            return this.f12621m;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public void m11727i(int OplusGLSurfaceView_13) {
            this.f12621m = OplusGLSurfaceView_13;
        }

        /* renamed from: OplusGLSurfaceView_6 */
        public int m11732m() {
            return this.f12622n;
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public void m11729j(int OplusGLSurfaceView_13) {
            this.f12622n = OplusGLSurfaceView_13;
        }
    }

    /* compiled from: BaseSloganUtil.java */
    /* renamed from: com.oplus.camera.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_5 */
    private static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f12643a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f12644b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f12645c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f12646d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f12647e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f12648f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f12649g;

        private IntrinsicsJvm.kt_5() {
            this.f12643a = 0;
            this.f12644b = 0;
            this.f12645c = 0;
            this.f12646d = 0;
            this.f12647e = 0;
            this.f12648f = 0;
            this.f12649g = 0;
        }

        public String toString() {
            return "WatermarkTextParameter, mPaddingTransverse: " + this.f12643a + ", mTextInterval: " + this.f12644b + ", mLogoCornerPortraitInterval: " + this.f12645c + ", mLogoPortraitInterval: " + this.f12646d + ", mWatermarkTransverseInterval: " + this.f12647e + ", mWatermarkPortraitInterval: " + this.f12648f;
        }
    }

    /* compiled from: BaseSloganUtil.java */
    /* renamed from: com.oplus.camera.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public String f12629a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f12630b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public Bitmap f12631c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean f12632d;

        private IntrinsicsJvm.kt_4() {
            this.f12629a = "";
            this.f12630b = 0;
            this.f12631c = null;
            this.f12632d = false;
        }
    }

    /* compiled from: BaseSloganUtil.java */
    /* renamed from: com.oplus.camera.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private ArrayList<String> f12633a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Paint.FontMetrics f12634b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private TextPaint f12635c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f12636d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f12637e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private Bitmap f12638f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f12639g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f12640h;

        /* renamed from: OplusGLSurfaceView_13 */
        private float f12641i;

        /* renamed from: OplusGLSurfaceView_15 */
        private float f12642j;

        public IntrinsicsJvm.kt_3(Context context, ComboPreferences comboPreferences, float COUIBaseListPopupWindow_12) {
            this(context, comboPreferences, COUIBaseListPopupWindow_12, true);
        }

        public IntrinsicsJvm.kt_3(Context context, ComboPreferences comboPreferences, float COUIBaseListPopupWindow_12, boolean z) throws Resources.NotFoundException {
            this.f12633a = null;
            this.f12634b = null;
            this.f12635c = null;
            this.f12636d = false;
            this.f12637e = false;
            this.f12638f = null;
            this.f12639g = 0.0f;
            this.f12640h = 0.0f;
            this.f12641i = 0.0f;
            this.f12642j = 0.0f;
            this.f12639g = Util.m24202a(context, R.dimen.watermark_divider_left, Util.f22962a) * COUIBaseListPopupWindow_12;
            this.f12640h = Util.m24202a(context, R.dimen.watermark_divider_right, Util.f22962a) * COUIBaseListPopupWindow_12;
            this.f12641i = Util.m24202a(context, R.dimen.watermark_divider_width, Util.f22962a) * COUIBaseListPopupWindow_12;
            this.f12642j = BaseSloganUtil.m11677b(context, comboPreferences, COUIBaseListPopupWindow_12);
            this.f12633a = new ArrayList<>();
            this.f12635c = new TextPaint();
            this.f12635c.setFlags(1);
            this.f12635c.setColor(context.getResources().getColor(R.color.camera_white));
            if (z) {
                this.f12635c.setShadowLayer(Util.m24202a(context, R.dimen.slogan_text_shadow_radius, Util.f22962a), Util.m24202a(context, R.dimen.slogan_text_shadow_x, Util.f22962a), Util.m24202a(context, R.dimen.slogan_text_shadow_y, Util.f22962a), context.getResources().getColor(R.color.color_black_with_30_percent_transparency));
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11746a(String str) {
            this.f12633a.add(str);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11747a(String str, int OplusGLSurfaceView_13) {
            this.f12633a.add(OplusGLSurfaceView_13, str);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m11750b(String str) {
            this.f12633a.clear();
            this.f12633a.add(str);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m11741a() {
            return String.join("", this.f12633a);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public ArrayList<String> m11749b() {
            return this.f12633a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m11742a(int OplusGLSurfaceView_13) {
            return this.f12633a.remove(OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m11751c() {
            return ((int) Math.ceil(this.f12635c.measureText(m11741a()))) + (((int) Math.ceil(this.f12639g)) * (this.f12633a.size() - 1)) + (((int) Math.ceil(this.f12640h)) * (this.f12633a.size() - 1)) + (((int) Math.ceil(this.f12641i)) * (this.f12633a.size() - 1));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m11748b(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0) {
                return 0;
            }
            return (int) this.f12635c.measureText(m11749b().get(OplusGLSurfaceView_13));
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m11752d() {
            if (this.f12634b == null) {
                this.f12634b = this.f12635c.getFontMetrics();
            }
            return (int) Math.abs(this.f12634b.descent - this.f12634b.ascent);
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean m11753e() {
            return this.f12636d;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11743a(float COUIBaseListPopupWindow_12) {
            this.f12634b = null;
            this.f12635c.setTextSize(COUIBaseListPopupWindow_12);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11745a(Typeface typeface) {
            this.f12635c.setTypeface(typeface);
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public Paint m11754f() {
            return this.f12635c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11744a(Paint.Align align) {
            this.f12635c.setTextAlign(align);
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int m11755g() {
            if (this.f12634b == null) {
                this.f12634b = this.f12635c.getFontMetrics();
            }
            return (int) this.f12634b.descent;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public float m11756h() {
            return this.f12639g;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public float m11757i() {
            return this.f12640h;
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public float m11758j() {
            return this.f12641i;
        }

        /* renamed from: OplusGLSurfaceView_5 */
        public float m11759k() {
            return this.f12642j;
        }
    }
}
