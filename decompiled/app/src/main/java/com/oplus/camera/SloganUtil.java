package com.oplus.camera;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Size;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.LocationManager;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SloganUtil.java */
/* renamed from: com.oplus.camera.ad */
/* loaded from: classes2.dex */
public class SloganUtil extends BaseSloganUtil {

    /* renamed from: S */
    private static Typeface f12244S;

    /* renamed from: T */
    private String f12245T;

    /* renamed from: U */
    private String f12246U;

    /* renamed from: V */
    private String f12247V;

    /* renamed from: W */
    private String f12248W;

    /* renamed from: X */
    private String f12249X;

    /* renamed from: Y */
    private String f12250Y;

    /* renamed from: Z */
    private String f12251Z;

    /* renamed from: aa */
    private String f12252aa;

    /* renamed from: ab */
    private String f12253ab;

    /* renamed from: ac */
    private String f12254ac;

    /* renamed from: ad */
    private String f12255ad;

    /* renamed from: ae */
    private String f12256ae;

    /* renamed from: af */
    private boolean f12257af;

    /* renamed from: ag */
    private int f12258ag;

    /* renamed from: ah */
    private boolean f12259ah;

    /* compiled from: SloganUtil.java */
    /* renamed from: com.oplus.camera.ad$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f12260a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f12261b = 0;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f12262c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f12263d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f12264e = 0;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f12265f = 0;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f12266g = 0;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int f12267h = 0;

        /* renamed from: OplusGLSurfaceView_13 */
        public int f12268i = 0;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f12269j = 0;

        /* renamed from: OplusGLSurfaceView_5 */
        public int f12270k = 0;

        /* renamed from: OplusGLSurfaceView_14 */
        public int f12271l = R.drawable.slogan_copyright_normal;

        /* renamed from: OplusGLSurfaceView_6 */
        public int f12272m = 0;

        /* renamed from: OplusGLSurfaceView_11 */
        public int f12273n = 0;

        /* renamed from: o */
        public int f12274o = 0;

        /* renamed from: p */
        public float f12275p = 0.0f;

        /* renamed from: q */
        public float f12276q = 0.0f;

        /* renamed from: r */
        public float f12277r = 0.0f;

        /* renamed from: s */
        public float f12278s = 0.0f;
    }

    public SloganUtil(Activity activity, ComboPreferences comboPreferences, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(activity, comboPreferences, OplusGLSurfaceView_13);
        this.f12245T = null;
        this.f12246U = null;
        this.f12247V = "Shot on ";
        this.f12248W = "Shot by ";
        this.f12249X = "MP";
        this.f12250Y = " AI ";
        this.f12251Z = " Camera";
        this.f12252aa = "";
        this.f12253ab = "";
        this.f12254ac = "";
        this.f12255ad = "";
        this.f12256ae = "";
        boolean z = false;
        this.f12257af = false;
        this.f12258ag = -1;
        this.f12259ah = false;
        if (Util.getScreenWidth() == 0 || Util.getScreenHeight() == 0) {
            Util.m24182J();
        }
        if (!TextUtils.isEmpty(this.f12573L) && ("realme 8".equals(this.f12573L) || "realme 8 Pro".equals(this.f12573L))) {
            z = true;
        }
        this.f12257af = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11282a(Size size, LocationManager.PlatformImplementations.kt_3 aVar, HashSet<String> hashSet, boolean z, int OplusGLSurfaceView_13, int i2, int i3, boolean z2, String str) {
        this.f12579R.f12655f = i3;
        if (this.f12258ag != i3) {
            this.f12258ag = i3;
            this.f12259ah = true;
        } else {
            this.f12259ah = false;
        }
        super.m11696a(size, aVar, hashSet, z, OplusGLSurfaceView_13, i2, z2, str);
    }

    @Override // com.oplus.camera.BaseSloganUtil
    /* renamed from: OplusGLSurfaceView_13 */
    protected boolean mo11283i() {
        return this.f12259ah;
    }

    @Override // com.oplus.camera.BaseSloganUtil
    /* renamed from: OplusGLSurfaceView_15 */
    protected boolean mo11284j() {
        return this.f12257af;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float m11278c(Size size) {
        float height;
        int screenWidth;
        if (size.getHeight() >= size.getWidth()) {
            height = size.getWidth() * 1.0f;
            screenWidth = Util.getScreenWidth();
        } else {
            height = size.getHeight() * 1.0f;
            screenWidth = Util.getScreenWidth();
        }
        return height / screenWidth;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private Typeface m11279k() {
        Typeface typeface = f12244S;
        if (typeface != null) {
            return typeface;
        }
        try {
            f12244S = Typeface.createFromAsset(this.f12593k.getAssets(), "fonts/RadomirTinkovGilroy-Medium.otf");
            CameraLog.m12954a("BaseSloganUtil", "create RadomirTinkovGilroy-Medium.otf typeface successful");
        } catch (Exception unused) {
            f12244S = Typeface.DEFAULT;
            CameraLog.m12967f("BaseSloganUtil", "create RadomirTinkovGilroy-Medium.otf typeface fail");
        }
        return f12244S;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m11277b(int OplusGLSurfaceView_13) {
        this.f12252aa = this.f12247V + this.f12573L;
        if (!CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            int iM24319aH = Util.m24319aH();
            CameraLog.m12959b("BaseSloganUtil", "getSloganInfo, highPictureMP: " + iM24319aH);
            if (48 <= iM24319aH) {
                this.f12254ac = iM24319aH + this.f12249X;
            }
            if (this.f12257af && iM24319aH == 108) {
                this.f12252aa += " | " + iM24319aH + this.f12249X;
            }
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CUSTOM_CAMERA_REAR_NUM);
            CameraLog.m12959b("BaseSloganUtil", "getSloganInfo, physicalBackCameraNum: " + configIntValue);
            if (configIntValue == -1 || configIntValue == 1) {
                this.f12255ad = null;
            } else if (configIntValue == 2) {
                this.f12255ad = this.f12596n.getString(R.string.camera_watermark_back_camera_num_2);
            } else if (configIntValue == 3) {
                this.f12255ad = this.f12596n.getString(R.string.camera_watermark_back_camera_num_3);
            } else if (configIntValue == 4) {
                this.f12255ad = this.f12596n.getString(R.string.camera_watermark_back_camera_num_4);
            } else {
                this.f12255ad = this.f12596n.getString(R.string.camera_watermark_back_camera_num_super);
            }
            if (this.f12255ad != null) {
                this.f12256ae = (this.f12254ac + this.f12250Y + this.f12255ad + this.f12251Z).trim().toUpperCase();
            } else {
                this.f12256ae = (this.f12254ac + this.f12250Y + this.f12251Z.trim()).trim().toUpperCase();
            }
        } else {
            this.f12256ae = (this.f12250Y + this.f12251Z.trim()).trim().toUpperCase();
        }
        CameraLog.m12959b("BaseSloganUtil", "getSloganInfo, mXXMPAIBackCameraNumCamera: " + this.f12256ae);
        return this.f12256ae;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11275a(Canvas canvas, Bitmap bitmap, float COUIBaseListPopupWindow_12, float f2) {
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.postTranslate(COUIBaseListPopupWindow_12, f2);
        paint.setAlpha(255);
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11276a(Canvas canvas, String str, float COUIBaseListPopupWindow_12, float f2, Paint paint) {
        canvas.drawText(str, COUIBaseListPopupWindow_12, f2, paint);
    }

    @Override // com.oplus.camera.BaseSloganUtil
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseSloganUtil.PlatformImplementations.kt_3 mo11281a(Context context, ComboPreferences comboPreferences, BaseSloganUtil.COUIBaseListPopupWindow_8 eVar) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        int iHeight;
        int iMeasureText;
        int iHeight2;
        String str;
        int iMeasureText2;
        Canvas canvas;
        boolean z;
        BaseSloganUtil.PlatformImplementations.kt_3 aVar = new BaseSloganUtil.PlatformImplementations.kt_3();
        int i2 = eVar.f12655f;
        Size size = eVar.f12650a;
        String string = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        String str2 = eVar.f12653d;
        String str3 = eVar.f12652c;
        String string2 = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "bottom_left_corner");
        this.f12257af = !TextUtils.isEmpty(this.f12573L) && ("realme 8".equals(this.f12573L) || "realme 8 Pro".equals(this.f12573L));
        if (!"bottom_center".equals(string2)) {
            comboPreferences.edit().putString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "bottom_center").apply();
        }
        CameraLog.m12954a("BaseSloganUtil", "createWatermarkBitmapHold, cameraId: " + i2 + ", pictureSize: Width x Height = " + size.getWidth() + "x" + size.getHeight());
        Set<String> stringSet = comboPreferences.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
        if ((stringSet == null || stringSet.isEmpty()) && TextUtils.isEmpty(string)) {
            CameraLog.m12954a("BaseSloganUtil", "chooseDisplayValues is null or empty");
            return null;
        }
        String string3 = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, context.getResources().getStringArray(R.array.camera_setting_watermark_size_values)[1]);
        String[] stringArray = this.f12593k.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        boolean zContains = stringSet.contains(stringArray[0]);
        boolean zContains2 = stringSet.contains(stringArray[1]);
        boolean zContains3 = stringSet.contains(stringArray[2]);
        CameraLog.m12967f("BaseSloganUtil", "createWatermarkBitmapHold, deviceOn: " + zContains + ", locationOn: " + zContains3 + ", timeOn: " + zContains2);
        float dimensionPixelSize = (float) this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_shadow_radius);
        float dimensionPixelSize2 = (float) this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_shadow_x);
        float dimensionPixelSize3 = (float) this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_shadow_y);
        float fM11272a = (m11272a(context, string3) * m11278c(size)) / 2.77777f;
        float dimensionPixelSize4 = ((float) this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_padding_ai_shot_gap)) * fM11272a;
        float dimensionPixelSize5 = ((float) this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_padding_r_shot_gap)) * fM11272a;
        int color = this.f12596n.getColor(R.color.slogan_text_shadow_color);
        float dimensionPixelSize6 = this.f12596n.getDimensionPixelSize(R.dimen.slogan_logo_shot_gap) * fM11272a;
        PlatformImplementations.kt_3 aVarM11274a = m11274a(fM11272a);
        Bitmap bitmapM11273a = m11273a(aVarM11274a.f12271l, fM11272a);
        Paint paint = new Paint();
        paint.setTypeface(m11279k());
        paint.setTextSize(aVarM11274a.f12278s);
        paint.setColor(this.f12593k.getColor(R.color.camera_white));
        paint.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        paint.setAlpha(253);
        int height = aVarM11274a.f12272m + bitmapM11273a.getHeight() + aVarM11274a.f12266g;
        if (zContains || !TextUtils.isEmpty(string)) {
            m11277b(i2);
            if (!TextUtils.isEmpty(string)) {
                this.f12253ab = this.f12248W + string;
            }
            Rect rect = new Rect();
            String str4 = this.f12256ae;
            OplusGLSurfaceView_13 = 0;
            paint.getTextBounds(str4, 0, str4.length(), rect);
            iHeight = rect.height();
        } else {
            iHeight = 0;
            OplusGLSurfaceView_13 = 0;
        }
        if (zContains3) {
            iMeasureText = (int) paint.measureText(str2);
            Rect rect2 = new Rect();
            paint.getTextBounds(str2, OplusGLSurfaceView_13, str2.length(), rect2);
            iHeight2 = rect2.height();
        } else {
            iMeasureText = 0;
            iHeight2 = 0;
        }
        if (zContains2) {
            str = str3;
            iMeasureText2 = (int) paint.measureText(str);
        } else {
            str = str3;
            iMeasureText2 = 0;
        }
        int i3 = iMeasureText2 > iMeasureText ? iMeasureText2 : iMeasureText;
        if (iHeight > 0) {
            iHeight2 = iHeight;
        }
        StringBuilder sb = new StringBuilder();
        String str5 = str;
        sb.append("createWatermarkBitmapHold, timeWidth: ");
        sb.append(iMeasureText2);
        sb.append(", locationWidth:");
        sb.append(iMeasureText);
        sb.append(", locationHeight: ");
        sb.append(iHeight2);
        sb.append(", textAICameraHeight:");
        sb.append(iHeight);
        sb.append(", locationTimeMaxPadding: ");
        sb.append(i3);
        CameraLog.m12954a("BaseSloganUtil", sb.toString());
        int width = size.getWidth();
        if (width % 2 != 0) {
            width++;
        }
        int i4 = width;
        if (height % 2 != 0) {
            height++;
        }
        int i5 = height;
        CameraLog.m12959b("BaseSloganUtil", "createWatermarkBitmapHold, composeWidth: " + i4 + ", composeHeight: " + i5);
        Bitmap bitmapM24215a = Util.m24215a(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapM24215a);
        canvas2.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (zContains || !TextUtils.isEmpty(string)) {
            paint.setTextSize(aVarM11274a.f12278s);
            float width2 = (((size.getWidth() - paint.measureText(TextUtils.isEmpty(string) ? this.f12252aa : this.f12253ab)) - bitmapM11273a.getWidth()) - dimensionPixelSize6) / 2.0f;
            m11275a(canvas2, bitmapM11273a, width2, aVarM11274a.f12272m);
            canvas = canvas2;
            z = zContains3;
            m11276a(canvas2, TextUtils.isEmpty(string) ? this.f12252aa : this.f12253ab, width2 + bitmapM11273a.getWidth() + dimensionPixelSize6, aVarM11274a.f12272m + dimensionPixelSize5, paint);
        } else {
            canvas = canvas2;
            z = zContains3;
        }
        if (z) {
            paint.setTextSize(aVarM11274a.f12277r);
            m11276a(canvas, str2, (i4 - i3) - aVarM11274a.f12265f, aVarM11274a.f12272m + dimensionPixelSize5, paint);
            CameraLog.m12954a("BaseSloganUtil", "createWatermarkBitmapHold, drawText mCurrentAdress: " + str2);
        }
        if (zContains2) {
            paint.setTextSize(aVarM11274a.f12277r);
            m11276a(canvas, str5, (i4 - paint.measureText(str5)) / 2.0f, aVarM11274a.f12272m + dimensionPixelSize5 + dimensionPixelSize4, paint);
            CameraLog.m12954a("BaseSloganUtil", "createWatermarkBitmapHold, drawText mDateTime: " + str5);
        }
        if (i4 > size.getWidth() && bitmapM24215a != null) {
            float COUIBaseListPopupWindow_12 = i4;
            float width3 = (1.0f * COUIBaseListPopupWindow_12) / size.getWidth();
            int i6 = (int) (COUIBaseListPopupWindow_12 / width3);
            int i7 = (int) (i5 / width3);
            if (i6 % 2 != 0) {
                i6--;
            }
            if (i7 % 2 != 0) {
                i7--;
            }
            bitmapM24215a = Bitmap.createScaledBitmap(bitmapM24215a, i6, i7, true);
            CameraLog.m12966e("BaseSloganUtil", "createWatermarkBitmapHold, createScaledBitmap now");
        }
        aVar.m11708a(bitmapM24215a);
        aVar.m11710a(eVar);
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m11274a(float COUIBaseListPopupWindow_12) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
        aVar.f12271l = R.drawable.oplusr_slogan_copyright_normal;
        if (this.f12257af) {
            aVar.f12271l = R.drawable.watermark_infinite_logo;
        }
        aVar.f12272m = (int) (this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_margin_top) * COUIBaseListPopupWindow_12);
        aVar.f12265f = (int) (this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_padding_left) * COUIBaseListPopupWindow_12);
        aVar.f12266g = (int) (this.f12596n.getDimensionPixelSize(R.dimen.slogan_text_padding_bottom) * COUIBaseListPopupWindow_12);
        aVar.f12277r = (int) (this.f12596n.getDimension(R.dimen.slogan_ai_camera_text_size) * COUIBaseListPopupWindow_12);
        aVar.f12278s = (int) (this.f12596n.getDimension(R.dimen.slogan_shot_on_by_text_size) * COUIBaseListPopupWindow_12);
        aVar.f12273n = (int) (this.f12596n.getDimension(R.dimen.slogan_shot_on_by_text_size) * COUIBaseListPopupWindow_12);
        aVar.f12274o = (int) (this.f12596n.getDimension(R.dimen.slogan_shot_on_by_text_size) * COUIBaseListPopupWindow_12);
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m11273a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.f12593k.getResources(), OplusGLSurfaceView_13);
        Matrix matrix = new Matrix();
        matrix.postScale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        return Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true);
    }

    @Override // com.oplus.camera.BaseSloganUtil
    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap mo11280a(Context context, float COUIBaseListPopupWindow_12) {
        CameraLog.m12959b("BaseSloganUtil", "getLogoBitmap");
        return m11273a(R.drawable.oplusr_slogan_copyright_normal, COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m11272a(Context context, String str) throws Resources.NotFoundException {
        CameraLog.m12959b("BaseSloganUtil", "getSloganSize sizeType: " + str);
        String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_size_values);
        if (stringArray[2].equals(str)) {
            return 1.1f;
        }
        return stringArray[0].equals(str) ? 0.9f : 1.0f;
    }
}
