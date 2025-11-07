package com.oplus.camera.p172ui.preview.p177a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Size;
import androidx.core.p027a.p028a.ResourcesCompat;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.PolarrRender;
import co.polarr.renderer.entities.DrawingItem;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p172ui.menu.levelcontrol.GLModelParam;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraUnitClient;
import com.oplus.tblplayer.misc.MediaInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FilterHelper.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class FilterHelper {

    /* renamed from: r */
    private static final HashMap<String, ArrayList<String>> f21328r = new HashMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f21279a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String f21312b = MediaInfo.RENDERER_TYPE_NONE;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static HashMap<String, Integer> f21313c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static HashMap<String, Integer> f21314d = new HashMap<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static FilterGroup f21315e = new FilterGroup();

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static FilterGroup f21316f = new FilterGroup();

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static FilterGroup f21317g = new FilterGroup();

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static FilterGroup f21318h = new FilterGroup();

    /* renamed from: OplusGLSurfaceView_13 */
    public static FilterGroup f21319i = new FilterGroup();

    /* renamed from: OplusGLSurfaceView_15 */
    public static FilterGroup f21320j = new FilterGroup();

    /* renamed from: OplusGLSurfaceView_5 */
    public static FilterGroup f21321k = new FilterGroup();

    /* renamed from: OplusGLSurfaceView_14 */
    public static FilterGroup f21322l = new FilterGroup();

    /* renamed from: OplusGLSurfaceView_6 */
    public static FilterGroup f21323m = new FilterGroup();

    /* renamed from: OplusGLSurfaceView_11 */
    public static FilterGroup f21324n = new FilterGroup();

    /* renamed from: o */
    public static FilterGroup f21325o = new FilterGroup();

    /* renamed from: p */
    public static FilterGroup f21326p = new FilterGroup();

    /* renamed from: q */
    public static FilterGroup f21327q = new FilterGroup();

    /* renamed from: s */
    private static List<String> f21329s = null;

    /* renamed from: t */
    private static boolean f21330t = false;

    /* renamed from: u */
    private static boolean f21331u = false;

    /* renamed from: v */
    private static boolean f21332v = false;

    /* renamed from: w */
    private static boolean f21333w = false;

    /* renamed from: x */
    private static boolean f21334x = false;

    /* renamed from: y */
    private static boolean f21335y = false;

    /* renamed from: z */
    private static int f21336z = -1;

    /* renamed from: A */
    private static int f21253A = -1;

    /* renamed from: B */
    private static int f21254B = -1;

    /* renamed from: C */
    private static int f21255C = -1;

    /* renamed from: D */
    private static int f21256D = -1;

    /* renamed from: E */
    private static int f21257E = -1;

    /* renamed from: F */
    private static int f21258F = -1;

    /* renamed from: G */
    private static int f21259G = -1;

    /* renamed from: H */
    private static int f21260H = -1;

    /* renamed from: I */
    private static int f21261I = -1;

    /* renamed from: J */
    private static int f21262J = -1;

    /* renamed from: K */
    private static int f21263K = -1;

    /* renamed from: L */
    private static int f21264L = -1;

    /* renamed from: M */
    private static int f21265M = -1;

    /* renamed from: N */
    private static int f21266N = -1;

    /* renamed from: O */
    private static int f21267O = -1;

    /* renamed from: P */
    private static int f21268P = -1;

    /* renamed from: Q */
    private static int f21269Q = -1;

    /* renamed from: R */
    private static int f21270R = 0;

    /* renamed from: S */
    private static int f21271S = 0;

    /* renamed from: T */
    private static int f21272T = 0;

    /* renamed from: U */
    private static int f21273U = 0;

    /* renamed from: V */
    private static int f21274V = 0;

    /* renamed from: W */
    private static float f21275W = 0.0f;

    /* renamed from: X */
    private static float f21276X = 0.0f;

    /* renamed from: Y */
    private static float f21277Y = 0.0f;

    /* renamed from: Z */
    private static float f21278Z = 0.0f;

    /* renamed from: aa */
    private static int f21286aa = 0;

    /* renamed from: ab */
    private static float f21287ab = 0.0f;

    /* renamed from: ac */
    private static int f21288ac = 0;

    /* renamed from: ad */
    private static int f21289ad = 0;

    /* renamed from: ae */
    private static int f21290ae = 0;

    /* renamed from: af */
    private static int f21291af = 0;

    /* renamed from: ag */
    private static int f21292ag = 0;

    /* renamed from: ah */
    private static int f21293ah = 0;

    /* renamed from: ai */
    private static int f21294ai = 0;

    /* renamed from: aj */
    private static Bitmap f21295aj = null;

    /* renamed from: ak */
    private static Bitmap f21296ak = null;

    /* renamed from: al */
    private static Bitmap f21297al = null;

    /* renamed from: am */
    private static Bitmap f21298am = null;

    /* renamed from: an */
    private static TextPaint f21299an = null;

    /* renamed from: ao */
    private static int f21300ao = 0;

    /* renamed from: ap */
    private static int f21301ap = 0;

    /* renamed from: aq */
    private static int f21302aq = 0;

    /* renamed from: ar */
    private static int f21303ar = 0;

    /* renamed from: as */
    private static int f21304as = 4;

    /* renamed from: at */
    private static Rect f21305at = new Rect();

    /* renamed from: au */
    private static Paint.FontMetricsInt f21306au = null;

    /* renamed from: av */
    private static float f21307av = 0.0f;

    /* renamed from: aw */
    private static int f21308aw = 0;

    /* renamed from: ax */
    private static int f21309ax = 0;

    /* renamed from: ay */
    private static int f21310ay = 0;

    /* renamed from: az */
    private static int f21311az = 0;

    /* renamed from: aA */
    private static int f21280aA = 0;

    /* renamed from: aB */
    private static int f21281aB = 0;

    /* renamed from: aC */
    private static int f21282aC = 0;

    /* renamed from: aD */
    private static int f21283aD = 0;

    /* renamed from: aE */
    private static int f21284aE = 0;

    /* renamed from: aF */
    private static boolean f21285aF = false;

    static {
        FilterPackageUtil.setStaticLUTPath("/odm/etc/camera/filters_lut/");
        PolarrRender.SetStaticResPath("/odm/etc/camera/filters_res/");
        m22577F();
        m22579H();
        m22580I();
        m22627c();
        m22576E();
        m22578G();
        m22575D();
        m22581J();
        m22582K();
        m22586O();
        m22583L();
        m22584M();
        f21325o.m22564a(f21315e, true, false);
        f21318h.m22564a(f21315e, true, false);
        f21326p.m22564a(f21315e, true, false);
        m22611a(f21315e, f21325o);
    }

    /* renamed from: D */
    private static void m22575D() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FUJI_FILTER_SUPPORT)) {
            f21322l.m22571d("default", Integer.valueOf(R.string.camera_filter_none));
            f21322l.m22571d("type_fuji_provia", Integer.valueOf(R.string.camera_filter_fuji_provia));
            f21322l.m22571d("type_fuji_velvia", Integer.valueOf(R.string.camera_filter_fuji_vlevia));
            f21322l.m22571d("type_fuji_astia", Integer.valueOf(R.string.camera_filter_fuji_astia));
            f21322l.m22571d("type_fuji_chrome", Integer.valueOf(R.string.camera_filter_fuji_classic_chrome));
            f21322l.m22571d("type_fuji_acros", Integer.valueOf(R.string.camera_filter_fuji_acros));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m22611a(Object... objArr) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER)) {
            CameraLog.m12959b("FilterHelper", "addGrandTourToFilterGroup, isExport: " + Util.m24348ak());
            for (Object obj : objArr) {
                if (obj instanceof FilterGroup) {
                    if (Util.m24348ak()) {
                        FilterGroup c3412i = (FilterGroup) obj;
                        c3412i.m22571d("gt-lake.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_blue_wave));
                        c3412i.m22571d("gt-japan.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_clean));
                        c3412i.m22571d("gt-earth.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_classic));
                        c3412i.m22571d("gt-rosy.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_rosy));
                    } else {
                        FilterGroup c3412i2 = (FilterGroup) obj;
                        c3412i2.m22571d("gt-3dcity.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_three_dimen_city));
                        c3412i2.m22571d("gt-glazed-tile.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_glazed_tile));
                        c3412i2.m22571d("gt-desert.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_desert));
                        c3412i2.m22571d("gt-crisp-fall.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_crisp_fall));
                        c3412i2.m22571d("gt-mountainous.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_mountainous));
                        c3412i2.m22571d("gt-after-glow.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_after_glow));
                        c3412i2.m22571d("gt-coco-grove.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_coco_grove));
                        c3412i2.m22571d("gt-steaming.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_steaming));
                        c3412i2.m22571d("gt-24hour-city.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_night_city));
                        c3412i2.m22571d("gt-old-times.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_old_time));
                        c3412i2.m22571d("gt-azure-water.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_azure_water));
                        c3412i2.m22571d("gt-blue-water.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_blue_water));
                        c3412i2.m22571d("gt-quietly-ele.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_simple_elegant));
                        c3412i2.m22571d("gt-beach.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_gt_beach));
                    }
                }
            }
        }
    }

    /* renamed from: E */
    private static void m22576E() {
        boolean zM24350am = Util.m24350am();
        Integer numValueOf = Integer.valueOf(R.string.camera_bokeh_flare_portrait);
        Integer numValueOf2 = Integer.valueOf(R.string.video_filter_blue);
        Integer numValueOf3 = Integer.valueOf(R.string.video_filter_green);
        Integer numValueOf4 = Integer.valueOf(R.string.video_filter_red);
        Integer numValueOf5 = Integer.valueOf(R.string.camera_filter_none);
        if (zM24350am) {
            f21320j.m22568b("default", numValueOf5);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT)) {
                f21320j.m22571d(FilterPackageUtil.RED_RED_2020, numValueOf4);
                f21320j.m22571d(FilterPackageUtil.TREE_GREEN_2020, numValueOf3);
                f21320j.m22571d(FilterPackageUtil.SKY_BLUE_2020, numValueOf2);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON)) {
                f21320j.m22568b("oplus_video_filter_neon", numValueOf);
            }
            f21320j.m22568b("V01-landscape-2.6.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_pop));
            f21320j.m22568b("cyberpunk-neoMilitarism-2.4-final.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night_city));
            f21320j.m22568b("cyberpunk-kitsch-3.1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_north_california));
            f21320j.m22568b("V02-portrait-2.5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_vintage));
            f21320j.m22568b("V03-food-2.0.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_yummy));
            f21320j.m22568b("V04-night-1.3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night));
            f21320j.m22568b("V05-mono-3.3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_black_white));
            return;
        }
        f21320j.m22568b("default", numValueOf5);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT)) {
            f21320j.m22571d(FilterPackageUtil.RED_RED_2020, numValueOf4);
            f21320j.m22571d(FilterPackageUtil.TREE_GREEN_2020, numValueOf3);
            f21320j.m22571d(FilterPackageUtil.SKY_BLUE_2020, numValueOf2);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT)) {
            f21320j.m22568b("oplus_video_filter_portrait_retention", Integer.valueOf(R.string.camera_filter_retention));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON)) {
            f21320j.m22568b("oplus_video_filter_neon", numValueOf);
        }
        if (Util.m24348ak()) {
            f21320j.m22568b("delight-V1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_yuyue));
            f21320j.m22568b("sweet-V2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_ziran));
            f21320j.m22568b("mellow-V3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_yonglan));
            f21320j.m22568b("misty-V4.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_yinyun));
            f21320j.m22568b("calm-V5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_qingleng));
            f21320j.m22568b("oplus_video_filter_black_and_white", Integer.valueOf(R.string.camera_video_filter_danse));
            f21320j.m22568b("farewell-V7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_libie));
            return;
        }
        f21320j.m22568b("delight-V1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_youran));
        f21320j.m22568b("sweet-V2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_mingmei));
        f21320j.m22568b("mellow-V3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_xiangwang));
        f21320j.m22568b("misty-V4.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_liulian));
        f21320j.m22568b("calm-V5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_qingxin));
        f21320j.m22568b("oplus_video_filter_black_and_white", Integer.valueOf(R.string.camera_video_filter_jingmi));
        f21320j.m22568b("farewell-V7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_video_filter_anyong));
    }

    /* renamed from: F */
    private static void m22577F() {
        boolean zM24350am = Util.m24350am();
        Integer numValueOf = Integer.valueOf(R.string.camera_filter_none);
        if (zM24350am) {
            f21315e.m22568b("default", numValueOf);
            m22609a(ConfigDataBase.KEY_PHOTO_MASTER_FILTER_TYPE_LIST, f21315e);
            f21315e.m22568b("PP1-soft-2.6.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_soft));
            f21315e.m22568b("V01-landscape-2.6.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_pop));
            f21315e.m22568b("cyberpunk-neoMilitarism-2.4-final.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night_city));
            f21315e.m22568b("cyberpunk-kitsch-3.1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_north_california));
            f21315e.m22568b("B612Pretty.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_b612));
            f21315e.m22568b("InsJuno.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_insjuno));
            f21315e.m22568b("BeautyplusMellow-5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_beautyplus));
            f21315e.m22568b("InsValencia-2.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_insvalencia));
            f21315e.m22568b("YoucamAdorable80.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_youcam));
            f21315e.m22568b("InsClarendon.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_insclare));
            f21315e.m22568b("SweetSnapAlice-3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_sweetsnap));
            f21315e.m22568b("V05-mono-3.3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_black_white_new));
            f21315e.m22568b("FaceappGrayscale.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_faceApp));
            f21315e.m22568b("SnapseedBright.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_snapseed));
            return;
        }
        if (Util.m24348ak()) {
            f21315e.m22568b("default", numValueOf);
            f21315e.m22568b("natural-P1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_ziran));
            f21315e.m22568b("sweet-P2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_tianmei));
            f21315e.m22568b("delight-P3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yuyue));
            f21315e.m22568b(FilterPackageUtil.F_COMMON_3, Integer.valueOf(R.string.camera_filter_tongtou));
            f21315e.m22568b("misty-P5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yinyun));
            f21315e.m22568b(FilterPackageUtil.YUANQI_2020, Integer.valueOf(R.string.camera_filter_nuanyang));
            f21315e.m22568b("candy-P7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_mianhuatang));
            f21315e.m22568b("IntrinsicsJvm.kt_4-w-P8.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_heibai));
            f21315e.m22568b("serene-P9.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_baiyueguang));
            f21315e.m22568b(FilterPackageUtil.JIARI_2020, Integer.valueOf(R.string.camera_filter_tianye));
            return;
        }
        f21315e.m22568b("default", numValueOf);
        if (Util.m24352ao()) {
            m22609a(ConfigDataBase.KEY_PHOTO_MASTER_FILTER_TYPE_LIST, f21315e);
        }
        f21315e.m22568b("natural-P1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_mingmei));
        f21315e.m22568b("sweet-P2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_pianai));
        f21315e.m22568b("delight-P3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_youran));
        f21315e.m22568b(FilterPackageUtil.F_COMMON_3, Integer.valueOf(R.string.camera_filter_yuanqi));
        f21315e.m22568b("misty-P5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_liulian));
        f21315e.m22568b(FilterPackageUtil.YUANQI_2020, Integer.valueOf(R.string.camera_filter_jidong));
        f21315e.m22568b("candy-P7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_zhiyu));
        f21315e.m22568b("IntrinsicsJvm.kt_4-w-P8.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_jingmi));
        f21315e.m22568b("serene-P9.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yonglan));
        f21315e.m22568b(FilterPackageUtil.JIARI_2020, Integer.valueOf(R.string.camera_filter_xiaxiang));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m22609a(String str, FilterGroup c3412i) {
        List<String> configStringListValue = CameraConfig.getConfigStringListValue(str);
        if (configStringListValue != null) {
            for (String str2 : configStringListValue) {
                if (!TextUtils.isEmpty(str2)) {
                    char c2 = 65535;
                    int iHashCode = str2.hashCode();
                    if (iHashCode != -403567785) {
                        if (iHashCode != -264909480) {
                            if (iHashCode == 369929174 && str2.equals("Serenity.cube.rgb.bin")) {
                                c2 = 1;
                            }
                        } else if (str2.equals("Radiance.cube.rgb.bin")) {
                            c2 = 0;
                        }
                    } else if (str2.equals("Emerald.cube.rgb.bin")) {
                        c2 = 2;
                    }
                    if (c2 == 0) {
                        c3412i.m22568b(str2, Integer.valueOf(R.string.camera_filter_oplus_master_radiance));
                    } else if (c2 == 1) {
                        c3412i.m22568b(str2, Integer.valueOf(R.string.camera_filter_oplus_master_serenity));
                    } else if (c2 == 2) {
                        c3412i.m22568b(str2, Integer.valueOf(R.string.camera_filter_oplus_master_emerald));
                    }
                }
            }
        }
    }

    /* renamed from: G */
    private static void m22578G() {
        List<String> configStringListValue = CameraConfig.getConfigStringListValue(ConfigDataBase.KEY_STREET_FILTER_TYPE_LIST);
        if (configStringListValue != null) {
            f21324n.m22565a("default", Integer.valueOf(R.string.camera_filter_none));
            Iterator<String> it = configStringListValue.iterator();
            while (it.hasNext()) {
                switch (it.next()) {
                    case "OPLUSR0604.cube.rgb.bin":
                        f21324n.m22565a("OPLUSR0604.cube.rgb.bin", Integer.valueOf(R.string.street_filter_jie_pai));
                        break;
                    case "DL_L_B6.cube.rgb.bin":
                        f21324n.m22565a("DL_L_B6.cube.rgb.bin", Integer.valueOf(R.string.street_filter_guang_ying));
                        break;
                    case "DL_D_G4.cube.rgb.bin":
                        f21324n.m22565a("DL_D_G4.cube.rgb.bin", Integer.valueOf(R.string.street_filter_xi_ju));
                        break;
                    case "oplus-r-black-gold-1.1-RGB.CUBE.rgb.bin":
                        f21324n.m22565a(FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020, Integer.valueOf(R.string.night_filter_modern_gold_oplus_r));
                        break;
                    case "oplus-r-cyberpunk-RGB.CUBE.rgb.bin":
                        f21324n.m22565a(FilterPackageUtil.OPLUS_R_CYBERPUNK_2020, Integer.valueOf(R.string.night_filter_cyberpunk_oplus_r));
                        break;
                    case "oplus-r-infra-RGB.CUBE.rgb.bin":
                        f21324n.m22565a(FilterPackageUtil.OPLUS_R_INFRA_2020, Integer.valueOf(R.string.night_filter_flamingo_oplus_r));
                        break;
                    case "bright_coloured.bin":
                        f21324n.m22565a("bright_coloured.bin", Integer.valueOf(R.string.night_filter_bright_coloured));
                        break;
                    case "interstellar_space.bin":
                        f21324n.m22565a("interstellar_space.bin", Integer.valueOf(R.string.night_filter_interstellar_space));
                        break;
                }
            }
        }
    }

    /* renamed from: H */
    private static void m22579H() {
        f21316f.m22571d("default", Integer.valueOf(R.string.camera_filter_none));
        f21316f.m22571d("anc_filtert_polyspin", Integer.valueOf(R.string.camera_filter_anc_5));
        f21316f.m22571d("anc_filtert_hexagon", Integer.valueOf(R.string.camera_filter_anc_2));
        f21316f.m22571d("anc_filtert_concentric_circles", Integer.valueOf(R.string.camera_filter_anc_4));
        f21316f.m22571d("anc_filtert_spiral", Integer.valueOf(R.string.camera_filter_anc_3));
        f21316f.m22571d("anc_filtert_cell_greenorange", Integer.valueOf(R.string.camera_filter_anc_6));
    }

    /* renamed from: I */
    private static void m22580I() {
        f21319i.m22568b("default", Integer.valueOf(R.string.camera_filter_none));
        m22609a(ConfigDataBase.KEY_PORTRAIT_MASTER_FILTER_TYPE_LIST, f21319i);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_STREAMER_SUPPORT)) {
            f21319i.m22571d("portrait_streamer", Integer.valueOf(R.string.camera_filter_streamer));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_FRONT_RETENTION_SUPPORT)) {
                f21319i.m22570c("portrait_retention", Integer.valueOf(R.string.camera_filter_retention));
            }
            f21319i.m22571d("portrait_retention", Integer.valueOf(R.string.camera_filter_retention));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT)) {
            f21319i.m22571d("neon-2020.cube.rgb.bin", Integer.valueOf(R.string.camera_bokeh_flare_portrait));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT)) {
            f21319i.m22570c("neon-2020.cube.rgb.bin", Integer.valueOf(R.string.camera_bokeh_flare_portrait));
        }
        if (Util.m24348ak()) {
            f21319i.m22568b("natural-P1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_ziran));
            f21319i.m22568b("sweet-P2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_tianmei));
            f21319i.m22568b("delight-P3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yuyue));
            f21319i.m22568b(FilterPackageUtil.F_COMMON_3, Integer.valueOf(R.string.camera_filter_tongtou));
            f21319i.m22568b("misty-P5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yinyun));
            f21319i.m22568b(FilterPackageUtil.YUANQI_2020, Integer.valueOf(R.string.camera_filter_nuanyang));
            f21319i.m22568b("candy-P7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_mianhuatang));
            f21319i.m22568b("IntrinsicsJvm.kt_4-w-P8.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_heibai));
            f21319i.m22568b("serene-P9.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_baiyueguang));
            f21319i.m22568b(FilterPackageUtil.JIARI_2020, Integer.valueOf(R.string.camera_filter_tianye));
        } else {
            f21319i.m22568b("natural-P1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_mingmei));
            f21319i.m22568b("sweet-P2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_pianai));
            f21319i.m22568b("delight-P3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_youran));
            f21319i.m22568b(FilterPackageUtil.F_COMMON_3, Integer.valueOf(R.string.camera_filter_yuanqi));
            f21319i.m22568b("misty-P5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_liulian));
            f21319i.m22568b(FilterPackageUtil.YUANQI_2020, Integer.valueOf(R.string.camera_filter_jidong));
            f21319i.m22568b("candy-P7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_zhiyu));
            f21319i.m22568b("IntrinsicsJvm.kt_4-w-P8.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_jingmi));
            f21319i.m22568b("serene-P9.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yonglan));
            f21319i.m22568b(FilterPackageUtil.JIARI_2020, Integer.valueOf(R.string.camera_filter_xiaxiang));
        }
        f21274V = f21319i.f21248b.size();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22599a() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DIRECTOR_FILTER_SUPPORT) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DIRECTOR_FILTER_RUS) && RegionCommonFeatureAdapter.m14536e() && !f21315e.f21248b.contains("drjw1994.bin")) {
            f21315e.m22563a(1, "drjw1994.bin", Integer.valueOf(R.string.camera_filter_jangwen1994));
            f21315e.m22563a(2, "drjw2010.bin", Integer.valueOf(R.string.camera_filter_jangwen2010));
            f21320j.m22563a(1, "drjw1994.bin", Integer.valueOf(R.string.camera_filter_jangwen1994));
            f21320j.m22563a(2, "drjw2010.bin", Integer.valueOf(R.string.camera_filter_jangwen2010));
            m22586O();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m22621b() {
        if (!f21331u) {
            f21327q.m22564a(f21315e, true, true);
            f21331u = true;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MONO_FILTER_SUPPORT) && CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE) == 0) {
            if (f21332v && m22614a(f21327q, FilterPackageUtil.PORTRAIT4_1, f21336z)) {
                f21327q.m22562a(f21336z);
            } else if (f21333w && m22614a(f21327q, FilterPackageUtil.PORTRAIT4_3, f21253A)) {
                f21327q.m22562a(f21253A);
            } else if (f21334x && m22614a(f21327q, FilterPackageUtil.F_COMMON_5, f21254B)) {
                f21327q.m22562a(f21254B);
            } else if (f21335y && m22614a(f21327q, FilterPackageUtil.F_COMMON_6, f21255C)) {
                f21327q.m22562a(f21255C);
            }
        }
        m22585N();
    }

    /* renamed from: J */
    private static void m22581J() {
        if (Util.m24352ao()) {
            f21317g.m22571d("default", Integer.valueOf(R.string.camera_filter_none));
            f21317g.m22571d("Delta400.3dl.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_soft));
        }
    }

    /* renamed from: K */
    private static void m22582K() {
        boolean zM24350am = Util.m24350am();
        Integer numValueOf = Integer.valueOf(R.string.camera_filter_none);
        if (zM24350am) {
            f21323m.m22568b("default", numValueOf);
            f21323m.m22568b("PP1-soft-2.6.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_soft));
            f21323m.m22568b("V01-landscape-2.6.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_pop));
            f21323m.m22568b("cyberpunk-neoMilitarism-2.4-final.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night_city));
            f21323m.m22568b("cyberpunk-kitsch-3.1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_north_california));
            f21323m.m22568b("B612Pretty.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_b612));
            f21323m.m22568b("InsJuno.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_insjuno));
            f21323m.m22568b("BeautyplusMellow-5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_beautyplus));
            f21323m.m22568b("InsValencia-2.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_insvalencia));
            f21323m.m22568b("YoucamAdorable80.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_youcam));
            f21323m.m22568b("InsClarendon.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_insclare));
            f21323m.m22568b("SweetSnapAlice-3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_sweetsnap));
            f21323m.m22568b("V05-mono-3.3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_black_white_new));
            f21323m.m22568b("FaceappGrayscale.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_faceApp));
            f21323m.m22568b("SnapseedBright.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_snapseed));
            return;
        }
        if (Util.m24348ak()) {
            f21323m.m22568b("default", numValueOf);
            f21323m.m22568b("natural-P1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_ziran));
            f21323m.m22568b("sweet-P2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_tianmei));
            f21323m.m22568b("delight-P3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yuyue));
            f21323m.m22568b(FilterPackageUtil.F_COMMON_3, Integer.valueOf(R.string.camera_filter_tongtou));
            f21323m.m22568b("misty-P5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yinyun));
            f21323m.m22568b(FilterPackageUtil.YUANQI_2020, Integer.valueOf(R.string.camera_filter_nuanyang));
            f21323m.m22568b("candy-P7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_mianhuatang));
            f21323m.m22568b("IntrinsicsJvm.kt_4-w-P8.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_heibai));
            f21323m.m22568b("serene-P9.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_baiyueguang));
            f21323m.m22568b(FilterPackageUtil.JIARI_2020, Integer.valueOf(R.string.camera_filter_tianye));
            return;
        }
        f21323m.m22568b("default", numValueOf);
        f21323m.m22568b("natural-P1.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_mingmei));
        f21323m.m22568b("sweet-P2.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_pianai));
        f21323m.m22568b("delight-P3.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_youran));
        f21323m.m22568b(FilterPackageUtil.F_COMMON_3, Integer.valueOf(R.string.camera_filter_yuanqi));
        f21323m.m22568b("misty-P5.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_liulian));
        f21323m.m22568b(FilterPackageUtil.YUANQI_2020, Integer.valueOf(R.string.camera_filter_jidong));
        f21323m.m22568b("candy-P7.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_zhiyu));
        f21323m.m22568b("IntrinsicsJvm.kt_4-w-P8.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_jingmi));
        f21323m.m22568b("serene-P9.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_yonglan));
        f21323m.m22568b(FilterPackageUtil.JIARI_2020, Integer.valueOf(R.string.camera_filter_xiaxiang));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: L */
    private static void m22583L() {
        boolean zM24350am = Util.m24350am();
        Integer numValueOf = Integer.valueOf(R.string.camera_filter_none);
        if (zM24350am) {
            f21321k.m22571d("default", numValueOf);
            f21321k.m22571d("PP1-soft-2.6.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_soft));
            f21321k.m22571d("V01-landscape-2.6.CUBE.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_pop));
            f21321k.m22571d("oplus-black-gold.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night_black_gold));
            f21321k.m22571d("oplus-yellow-blue.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night_teal_orange));
            f21321k.m22571d("oplus-cyberpunk.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night_cyberpunk));
            f21321k.m22571d("oplus-nightcity.cube.rgb.bin", Integer.valueOf(R.string.camera_filter_oplus_night_city));
            return;
        }
        List<String> configStringListValue = CameraConfig.getConfigStringListValue(ConfigDataBase.KEY_NIGHT_FILTER_TYPE_LIST);
        if (configStringListValue != null) {
            f21321k.m22565a("default", numValueOf);
            for (String str : configStringListValue) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1597549145:
                        if (str.equals(FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1369240359:
                        if (str.equals("interstellar_space.bin")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -156016769:
                        if (str.equals(FilterPackageUtil.OPLUS_R_CYBERPUNK_2020)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 330539305:
                        if (str.equals("bright_coloured.bin")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 777381561:
                        if (str.equals("black_gold.bin")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 855419946:
                        if (str.equals(FilterPackageUtil.OPLUS_R_INFRA_2020)) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    f21321k.m22565a(FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020, Integer.valueOf(R.string.night_filter_modern_gold_oplus_r));
                    f21315e.m22571d(FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020, Integer.valueOf(R.string.night_filter_modern_gold_oplus_r));
                } else if (c2 == 1) {
                    f21321k.m22565a(FilterPackageUtil.OPLUS_R_CYBERPUNK_2020, Integer.valueOf(R.string.night_filter_cyberpunk_oplus_r));
                    f21315e.m22571d(FilterPackageUtil.OPLUS_R_CYBERPUNK_2020, Integer.valueOf(R.string.night_filter_cyberpunk_oplus_r));
                } else if (c2 == 2) {
                    f21321k.m22565a(FilterPackageUtil.OPLUS_R_INFRA_2020, Integer.valueOf(R.string.night_filter_flamingo_oplus_r));
                    f21315e.m22571d(FilterPackageUtil.OPLUS_R_INFRA_2020, Integer.valueOf(R.string.night_filter_flamingo_oplus_r));
                } else if (c2 == 3) {
                    f21321k.m22565a("black_gold.bin", Integer.valueOf(R.string.night_filter_black_gold));
                } else if (c2 == 4) {
                    f21321k.m22565a("interstellar_space.bin", Integer.valueOf(R.string.night_filter_interstellar_space));
                } else if (c2 == 5) {
                    f21321k.m22565a("bright_coloured.bin", Integer.valueOf(R.string.night_filter_bright_coloured));
                }
            }
        }
    }

    /* renamed from: M */
    private static void m22584M() {
        f21329s = new ArrayList();
        f21329s.add("neon-2020.cube.rgb.bin");
        f21329s.add("oplus_video_filter_neon");
        f21329s.add(FilterPackageUtil.RED_RED_2020);
        f21329s.add(FilterPackageUtil.TREE_GREEN_2020);
        f21329s.add(FilterPackageUtil.SKY_BLUE_2020);
        f21329s.add("portrait_retention");
        f21329s.add("oplus_video_filter_portrait_retention");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m22627c() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MONO_FILTER_SUPPORT)) {
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE);
            if (configIntValue == 0) {
                m22624b(f21315e);
                m22608a(f21315e);
            } else if (1 == configIntValue) {
                m22624b(f21319i);
                m22608a(f21319i);
            } else {
                m22624b(f21315e);
                m22608a(f21315e);
                m22624b(f21319i);
                m22608a(f21319i);
            }
        }
        m22585N();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m22608a(FilterGroup c3412i) {
        int size = c3412i.f21248b.size();
        int iM12970a = CameraCharacteristicsUtil.m12970a(CameraUnitClient.CameraType.REAR_PORTRAIT_MONO_1);
        CameraLog.m12959b("FilterHelper", "initialPortraitMonoFilter,rear_portrait_mono_1 id_renamed = " + iM12970a + ", sbHasMono1 is " + f21332v);
        if (!f21332v && iM12970a != 0) {
            f21332v = true;
            f21270R = iM12970a;
            f21336z = size;
            if (Util.m24348ak()) {
                CameraLog.m12959b("FilterHelper", "initialPortraitMonoFilter,add camera protrait filter xiaoxiang");
                c3412i.m22569c(f21336z, FilterPackageUtil.PORTRAIT4_1, Integer.valueOf(R.string.camera_protrait_filter_xiaoxiang));
            } else {
                c3412i.m22569c(f21336z, FilterPackageUtil.PORTRAIT4_1, Integer.valueOf(R.string.camera_protrait_filter_huiyi));
            }
        }
        int iM12970a2 = CameraCharacteristicsUtil.m12970a(CameraUnitClient.CameraType.REAR_PORTRAIT_MONO_2);
        if (f21333w || iM12970a2 == 0) {
            return;
        }
        f21333w = true;
        f21271S = iM12970a2;
        int OplusGLSurfaceView_13 = f21336z;
        if (-1 != OplusGLSurfaceView_13) {
            size = OplusGLSurfaceView_13 + 1;
        }
        f21253A = size;
        c3412i.m22569c(f21253A, FilterPackageUtil.PORTRAIT4_3, Integer.valueOf(R.string.camera_protrait_filter_louguang));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m22624b(FilterGroup c3412i) {
        int size = c3412i.f21248b.size();
        int iM12970a = CameraCharacteristicsUtil.m12970a(CameraUnitClient.CameraType.REAR_MONO_CAMERA_1);
        if (!f21334x && iM12970a != 0) {
            f21334x = true;
            f21272T = iM12970a;
            f21254B = size;
            c3412i.m22569c(f21254B, FilterPackageUtil.F_COMMON_5, Integer.valueOf(R.string.camera_filter_heibai));
        }
        int iM12970a2 = CameraCharacteristicsUtil.m12970a(CameraUnitClient.CameraType.REAR_MONO_CAMERA_2);
        if (f21335y || iM12970a2 == 0) {
            return;
        }
        f21335y = true;
        f21273U = iM12970a2;
        int OplusGLSurfaceView_13 = f21254B;
        if (-1 != OplusGLSurfaceView_13) {
            size = OplusGLSurfaceView_13 + 1;
        }
        f21255C = size;
        c3412i.m22569c(f21255C, FilterPackageUtil.F_COMMON_6, Integer.valueOf(R.string.camera_filter_oplus_faceApp));
    }

    /* renamed from: N */
    private static void m22585N() {
        f21264L = f21319i.f21247a.indexOf("portrait_retention");
        f21256D = f21319i.f21248b.indexOf("portrait_streamer");
        f21263K = f21319i.f21248b.indexOf("portrait_retention");
        f21258F = f21319i.f21247a.indexOf("neon-2020.cube.rgb.bin");
        f21257E = f21319i.f21248b.indexOf("neon-2020.cube.rgb.bin");
        f21266N = f21319i.f21247a.indexOf("default");
        f21265M = f21319i.f21248b.indexOf("default");
        f21269Q = f21315e.f21248b.indexOf("default");
    }

    /* renamed from: O */
    private static void m22586O() {
        f21260H = f21320j.f21247a.indexOf("oplus_video_filter_neon");
        f21259G = f21320j.f21248b.indexOf("oplus_video_filter_neon");
        f21262J = f21320j.f21247a.indexOf("oplus_video_filter_portrait_retention");
        f21261I = f21320j.f21248b.indexOf("oplus_video_filter_portrait_retention");
        f21268P = f21320j.f21247a.indexOf("default");
        f21267O = f21320j.f21248b.indexOf("default");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static Set<String> m22629d() {
        return f21328r.keySet();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ArrayList<String> m22597a(String str) {
        if (!f21328r.containsKey(str)) {
            CameraLog.m12966e("FilterHelper", "getGrandTourFilterListForCity, " + str + " is not in grand tour cities list");
            return new ArrayList<>();
        }
        return f21328r.get(str);
    }

    /* renamed from: P */
    private static void m22587P() throws Throwable {
        CameraLog.m12959b("FilterHelper", "parseGrandTourCityFilterFromAsset");
        String strM24429d = Util.m24429d("city_filter_oplus.json");
        if (strM24429d == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray(strM24429d);
        int length = jSONArray.length();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            JSONObject jSONObject = jSONArray.getJSONObject(OplusGLSurfaceView_13);
            if (!jSONObject.getString("Locality").equalsIgnoreCase("domestic") || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_FEATURE_GRAND_TOUR_DOMESTIC)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("Value");
                JSONArray jSONArray3 = jSONObject.getJSONArray("CityTag");
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(jSONArray2.get(i2).toString());
                }
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    f21328r.put(jSONArray3.get(i3).toString().toLowerCase(), arrayList);
                }
            }
        }
        CameraLog.m12959b("FilterHelper", "parseGrandTourCityFilterFromAsset, cityList: " + f21328r.keySet().toString());
        CameraLog.m12959b("FilterHelper", "parseGrandTourCityFilterFromAsset, cityFilterMap: " + f21328r.toString());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m22631e() {
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.-$$Lambda$OplusGLSurfaceView_15$k_H5ZO5vfj0viiqyT_sV-pkBL0c
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                FilterHelper.m22588Q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public static /* synthetic */ void m22588Q() throws Throwable {
        try {
            CameraLog.m12959b("FilterHelper", "parseGrandTourCityFilterList");
            f21328r.clear();
            m22587P();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static HashMap<String, Integer> m22598a(HashMap<String, Integer> map) {
        LinkedList<Map.Entry> linkedList = new LinkedList(map.entrySet());
        linkedList.sort(new Comparator() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.-$$Lambda$OplusGLSurfaceView_15$weIxL3OlhF4ShLQDmQgbnNgXpkA
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return FilterHelper.m22590a((Map.Entry) obj, (Map.Entry) obj2);
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedList) {
            linkedHashMap.put((String) entry.getKey(), (Integer) entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ int m22590a(Map.Entry entry, Map.Entry entry2) {
        return ((Integer) entry2.getValue()).compareTo((Integer) entry.getValue());
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m22632f() {
        CameraLog.m12954a("FilterHelper", "resetGrandTourFilters");
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER)) {
            HashMap<String, Integer> mapM22598a = m22598a(f21313c);
            for (String str : mapM22598a.keySet()) {
                int iIntValue = mapM22598a.get(str).intValue();
                int iIntValue2 = f21314d.get(str).intValue();
                f21315e.m22562a(f21315e.f21248b.indexOf(str));
                f21315e.m22569c(iIntValue, str, Integer.valueOf(iIntValue2));
            }
            f21313c.clear();
            f21314d.clear();
            f21312b = MediaInfo.RENDERER_TYPE_NONE;
            f21330t = false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m22625b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateGrandTourFilters, city: ");
        sb.append(str);
        sb.append(" has key: ");
        sb.append(!f21328r.containsKey(str));
        sb.append(" selectedCity :");
        sb.append(f21312b);
        CameraLog.m12959b("FilterHelper", sb.toString());
        if (str == null || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER) || !f21328r.containsKey(str) || f21312b.equalsIgnoreCase(str)) {
            CameraLog.m12966e("FilterHelper", "updateGrandTourFiltersList, - No need to update the filter list.");
            return;
        }
        ArrayList<String> arrayList = f21328r.get(str);
        if (arrayList == null || arrayList.size() == 0) {
            CameraLog.m12966e("FilterHelper", "updateGrandTourFiltersList, No filters for " + str + " city");
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
            String str2 = arrayList.get(OplusGLSurfaceView_13);
            int iIndexOf = f21315e.f21248b.indexOf(str2);
            if (iIndexOf != -1) {
                int iIntValue = f21315e.f21250d.get(iIndexOf).intValue();
                f21313c.put(str2, Integer.valueOf(iIndexOf));
                f21314d.put(str2, Integer.valueOf(iIntValue));
            }
        }
        int i2 = 1;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str3 = arrayList.get(i3);
            int iIndexOf2 = f21315e.f21248b.indexOf(str3);
            if (iIndexOf2 != -1) {
                int iIntValue2 = f21315e.f21250d.get(iIndexOf2).intValue();
                f21315e.m22562a(iIndexOf2);
                f21315e.m22569c(i2, str3, Integer.valueOf(iIntValue2));
                i2++;
            }
        }
        f21312b = str;
        f21330t = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m22612a(int OplusGLSurfaceView_13) {
        return f21330t && !f21312b.equalsIgnoreCase(MediaInfo.RENDERER_TYPE_NONE) && f21313c.containsKey(f21315e.f21248b.get(OplusGLSurfaceView_13));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m22633g() {
        return f21330t;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static int m22634h() {
        return f21336z;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static int m22635i() {
        return f21253A;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static int m22636j() {
        return f21254B;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static int m22637k() {
        return f21255C;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static int m22638l() {
        return f21256D;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static int m22639m() {
        return f21258F;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static int m22640n() {
        return f21257E;
    }

    /* renamed from: o */
    public static int m22641o() {
        return f21263K;
    }

    /* renamed from: p */
    public static int m22642p() {
        return f21265M;
    }

    /* renamed from: q */
    public static int m22643q() {
        return f21266N;
    }

    /* renamed from: r */
    public static int m22644r() {
        return f21267O;
    }

    /* renamed from: s */
    public static int m22645s() {
        return f21269Q;
    }

    /* renamed from: t */
    public static int m22646t() {
        return f21268P;
    }

    /* renamed from: u */
    public static int m22647u() {
        return f21270R;
    }

    /* renamed from: v */
    public static int m22648v() {
        return f21271S;
    }

    /* renamed from: w */
    public static int m22649w() {
        return f21272T;
    }

    /* renamed from: x */
    public static int m22650x() {
        return f21273U;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22600a(int OplusGLSurfaceView_13, int i2) {
        f21283aD = OplusGLSurfaceView_13;
        f21284aE = i2;
        m22651y();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22605a(Resources resources, String str, int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, List<FilterModel> list, ImageCallback interfaceC3419p, Size size, boolean z4) {
        float width = (size.getWidth() * 1.0f) / size.getHeight();
        if (1 == f21283aD) {
            if (f21284aE == 0) {
                m22603a(resources, str, OplusGLSurfaceView_13, i2, z, z2, list, interfaceC3419p, width);
                return;
            } else {
                m22623b(resources, str, OplusGLSurfaceView_13, i2, z, false, list, interfaceC3419p, width);
                return;
            }
        }
        m22604a(resources, str, OplusGLSurfaceView_13, i2, z, z2, z3, list, interfaceC3419p, width, z4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22604a(Resources resources, String str, int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, List<FilterModel> list, ImageCallback interfaceC3419p, float COUIBaseListPopupWindow_12, boolean z4) {
        CameraLog.m12954a("FilterHelper", "setImageResourceHorizontal");
        f21285aF = z4;
        if (f21284aE == 0) {
            f21275W = resources.getDimensionPixelOffset(R.dimen.horizontal_common_filter_menu_elements_width);
            f21287ab = resources.getDimensionPixelOffset(R.dimen.horizontal_common_filter_menu_elements_height);
            f21276X = resources.getDimensionPixelOffset(R.dimen.horizontal_common_menu_effect_filter_elements_gap);
        } else {
            f21287ab = resources.getDimensionPixelOffset(R.dimen.horizontal_common_filter_menu_elements_width);
            f21275W = resources.getDimensionPixelOffset(R.dimen.horizontal_common_filter_menu_elements_height);
            f21276X = resources.getDimensionPixelOffset(R.dimen.horizontal_rack_menu_effect_filter_elements_gap);
        }
        if (f21286aa == 0) {
            f21286aa = resources.getDimensionPixelOffset(R.dimen.horizontal_common_filter_menu_elment_image_size);
        }
        if (Float.compare(f21277Y, 0.0f) == 0) {
            f21277Y = resources.getDimension(R.dimen.horizontal_common_menu_effect_filter_elements_highlight_height);
        }
        if (f21288ac == 0) {
            f21288ac = resources.getDimensionPixelOffset(R.dimen.horizontal_common_filter_menu_text_top_margin);
        }
        if (f21309ax == 0) {
            f21309ax = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_text_sides_padding);
        }
        if (f21310ay == 0) {
            f21310ay = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_text_updown_padding);
        }
        if (f21311az == 0) {
            f21311az = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_row_offset);
        }
        if (Float.compare(f21278Z, 0.0f) == 0) {
            f21278Z = resources.getDimensionPixelOffset(R.dimen.menu_effect_grandtour_map_icon_negative_offset);
        }
        if (f21295aj == null) {
            f21295aj = Util.m24223a(resources.getDrawable(R.drawable.filter_select_highlight, null));
        }
        if (f21296ak == null) {
            if (Util.m24352ao()) {
                f21296ak = m22592a(resources, R.drawable.filter_select_highlight);
            } else {
                f21296ak = m22592a(resources, R.drawable.filter_select_highlight_inverse);
            }
        }
        if (f21297al == null) {
            f21297al = BitmapFactory.decodeResource(resources, R.drawable.filter_redpot);
        }
        if (f21298am == null) {
            f21298am = Util.m24223a(resources.getDrawable(R.drawable.filter_grand_tour_recommend_icon, null));
        }
        if (f21299an == null) {
            f21299an = new TextPaint();
            f21300ao = resources.getColor(R.color.color_white_with_full_percent_transparency);
            f21301ap = resources.getColor(R.color.color_black_with_full_percent_transparency);
            f21302aq = resources.getColor(R.color.color_black_with_30_percent_transparency);
            f21303ar = resources.getColor(R.color.color_black_with_0_percent_transparency);
            f21304as = resources.getDimensionPixelOffset(R.dimen.blur_menu_seekbar_value_text_shadow_radius);
            f21299an.setColor(f21300ao);
            f21299an.setAntiAlias(true);
            f21299an.setShadowLayer(f21304as, 0.0f, 0.0f, f21302aq);
            f21299an.setTextSize(resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_size));
        }
        f21289ad = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_margin_top);
        f21292ag = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_red_dot_margin_left);
        f21291af = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_max_width);
        f21293ah = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_element_margin_top);
        f21294ai = resources.getDimensionPixelSize(R.dimen.makeup_item_highlight_stroke_width);
        if (f21306au == null) {
            f21306au = f21299an.getFontMetricsInt();
        }
        f21280aA = f21306au.bottom - f21306au.top;
        f21281aB = f21306au.ascent;
        f21299an.setTypeface(Util.m24411c(true));
        f21299an.getTextBounds("...", 0, 3, f21305at);
        f21282aC = f21305at.width();
        f21307av = f21275W - (f21309ax * 2);
        float fFloor = COUIBaseListPopupWindow_12 > 1.0f ? (float) (Math.floor((r5 - r1) / 2.0f) / (f21286aa * COUIBaseListPopupWindow_12)) : 0.0f;
        GLModelParam c3284i = new GLModelParam(str);
        c3284i.m20912c((List<Bitmap>) null);
        c3284i.m20908b(list);
        c3284i.m20899a(f21295aj);
        c3284i.m20907b(f21296ak);
        c3284i.m20925f(OplusGLSurfaceView_13);
        c3284i.m20897a(60.0f);
        c3284i.m20905b(f21287ab);
        c3284i.m20910c(f21275W);
        c3284i.m20916d(f21276X);
        c3284i.m20920e(f21277Y);
        c3284i.m20924f(fFloor);
        c3284i.m20909b(z);
        c3284i.m20913c(z2);
        c3284i.m20918d(z3);
        c3284i.m20922e(true);
        c3284i.m20928g(f21293ah);
        if (z4) {
            Collections.reverse(list);
        }
        m22602a(resources, c3284i, list, i2, z, z2, (int) f21276X, (int) f21287ab, (int) f21275W, COUIBaseListPopupWindow_12);
        interfaceC3419p.mo12656a(c3284i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m22592a(Resources resources, int OplusGLSurfaceView_13) {
        Drawable drawableM2302a;
        if (resources == null || (drawableM2302a = ResourcesCompat.m2302a(resources, OplusGLSurfaceView_13, null)) == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableM2302a.getIntrinsicWidth(), drawableM2302a.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableM2302a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableM2302a.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22603a(Resources resources, String str, int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, List<FilterModel> list, ImageCallback interfaceC3419p, float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("FilterHelper", "setImageResourceVertical");
        if (f21286aa == 0) {
            f21286aa = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_element_image_size);
        }
        f21287ab = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_elements_height);
        f21275W = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_elements_width);
        f21276X = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_elements_gap);
        if (Float.compare(f21277Y, 0.0f) == 0) {
            f21277Y = resources.getDimension(R.dimen.vertical_filter_menu_elements_highlight_height);
        }
        if (f21308aw == 0) {
            f21308aw = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_bitmap_bottom_padding);
        }
        if (f21309ax == 0) {
            f21309ax = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_text_sides_padding);
        }
        if (f21310ay == 0) {
            f21310ay = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_text_updown_padding);
        }
        if (f21288ac == 0) {
            f21288ac = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_text_top_margin);
        }
        if (f21310ay == 0) {
            f21310ay = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_text_updown_padding);
        }
        if (f21311az == 0) {
            f21311az = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_row_offset);
        }
        if (f21295aj == null) {
            f21295aj = BitmapFactory.decodeResource(resources, R.drawable.filter_menu_selector);
        }
        if (f21296ak == null) {
            f21296ak = m22592a(resources, R.drawable.filter_select_highlight_inverse);
        }
        if (f21297al == null) {
            f21297al = BitmapFactory.decodeResource(resources, R.drawable.filter_redpot);
        }
        f21289ad = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_margin_top_vertical);
        f21292ag = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_red_dot_margin_left);
        f21290ae = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_vertical_offset);
        f21291af = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_max_width_vertical);
        if (f21299an == null) {
            f21299an = new TextPaint();
            f21300ao = resources.getColor(R.color.color_white_with_full_percent_transparency);
            f21301ap = resources.getColor(R.color.color_black_with_full_percent_transparency);
            f21302aq = resources.getColor(R.color.color_black_with_30_percent_transparency);
            f21303ar = resources.getColor(R.color.color_black_with_0_percent_transparency);
            f21299an.setColor(f21300ao);
            f21299an.setAntiAlias(true);
            f21299an.setShadowLayer(f21304as, 0.0f, 0.0f, f21302aq);
            f21299an.setTextSize(resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_size));
        }
        if (f21306au == null) {
            f21306au = f21299an.getFontMetricsInt();
        }
        f21280aA = f21306au.bottom - f21306au.top;
        f21281aB = f21306au.ascent;
        f21299an.setTypeface(Util.m24411c(true));
        f21299an.getTextBounds("...", 0, 3, f21305at);
        f21282aC = f21305at.width();
        f21307av = f21275W - (f21309ax * 2);
        float fFloor = COUIBaseListPopupWindow_12 > 1.0f ? (float) (Math.floor((r4 - r1) / 2.0f) / (f21286aa * COUIBaseListPopupWindow_12)) : 0.0f;
        GLModelParam c3284i = new GLModelParam(str);
        c3284i.m20912c((List<Bitmap>) null);
        c3284i.m20908b(list);
        c3284i.m20899a(f21295aj);
        c3284i.m20907b(f21296ak);
        c3284i.m20925f(OplusGLSurfaceView_13);
        c3284i.m20897a(60.0f);
        c3284i.m20905b(f21287ab);
        c3284i.m20910c(f21275W);
        c3284i.m20916d(f21276X);
        c3284i.m20920e(f21277Y);
        c3284i.m20924f(fFloor);
        c3284i.m20909b(z);
        c3284i.m20913c(z2);
        c3284i.m20922e(true);
        m22622b(resources, c3284i, list, i2, z, z2, (int) f21276X, (int) f21287ab, (int) f21275W, COUIBaseListPopupWindow_12);
        interfaceC3419p.mo12656a(c3284i);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m22623b(Resources resources, String str, int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, List<FilterModel> list, ImageCallback interfaceC3419p, float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("FilterHelper", "setImageResourceVertical90");
        f21286aa = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_element_image_size);
        f21275W = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_elements_height);
        f21287ab = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_elements_width);
        f21276X = resources.getDimensionPixelOffset(R.dimen.vertical_filter_menu_elements_gap);
        f21277Y = resources.getDimension(R.dimen.vertical_filter_menu_elements_highlight_height);
        if (f21288ac == 0) {
            f21288ac = resources.getDimensionPixelOffset(R.dimen.horizontal_common_filter_menu_text_top_margin);
        }
        if (f21309ax == 0) {
            f21309ax = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_text_sides_padding);
        }
        if (f21310ay == 0) {
            f21310ay = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_text_updown_padding);
        }
        if (f21311az == 0) {
            f21311az = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_row_offset);
        }
        if (Float.compare(f21278Z, 0.0f) == 0) {
            f21278Z = resources.getDimensionPixelOffset(R.dimen.menu_effect_grandtour_map_icon_negative_offset);
        }
        f21295aj = BitmapFactory.decodeResource(resources, R.drawable.filter_menu_selector);
        f21296ak = m22592a(resources, R.drawable.filter_select_highlight_inverse);
        if (f21297al == null) {
            f21297al = BitmapFactory.decodeResource(resources, R.drawable.filter_redpot);
        }
        if (f21298am == null) {
            f21298am = Util.m24223a(resources.getDrawable(R.drawable.filter_grand_tour_recommend_icon, null));
        }
        if (f21299an == null) {
            f21299an = new TextPaint();
            f21300ao = resources.getColor(R.color.color_white_with_full_percent_transparency);
            f21301ap = resources.getColor(R.color.color_black_with_full_percent_transparency);
            f21302aq = resources.getColor(R.color.color_black_with_30_percent_transparency);
            f21303ar = resources.getColor(R.color.color_black_with_0_percent_transparency);
            f21304as = resources.getDimensionPixelOffset(R.dimen.blur_menu_seekbar_value_text_shadow_radius);
            f21299an.setColor(f21300ao);
            f21299an.setAntiAlias(true);
            f21299an.setShadowLayer(f21304as, 0.0f, 0.0f, f21302aq);
            f21299an.setTextSize(resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_size));
        }
        f21289ad = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_margin_top);
        f21292ag = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_red_dot_margin_left);
        f21291af = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_max_width);
        f21293ah = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_element_margin_top);
        f21294ai = resources.getDimensionPixelSize(R.dimen.makeup_item_highlight_stroke_width);
        f21290ae = resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_vertical_offset);
        if (f21306au == null) {
            f21306au = f21299an.getFontMetricsInt();
        }
        f21280aA = f21306au.bottom - f21306au.top;
        f21281aB = f21306au.ascent;
        f21299an.setTypeface(Util.m24411c(true));
        f21299an.getTextBounds("...", 0, 3, f21305at);
        f21282aC = f21305at.width();
        f21307av = f21275W - (f21309ax * 2);
        float fFloor = COUIBaseListPopupWindow_12 > 1.0f ? (float) (Math.floor((r5 - r1) / 2.0f) / (f21286aa * COUIBaseListPopupWindow_12)) : 0.0f;
        GLModelParam c3284i = new GLModelParam(str);
        c3284i.m20912c((List<Bitmap>) null);
        c3284i.m20908b(list);
        c3284i.m20899a(f21295aj);
        c3284i.m20907b(f21296ak);
        c3284i.m20925f(OplusGLSurfaceView_13);
        c3284i.m20897a(60.0f);
        c3284i.m20905b(f21287ab);
        c3284i.m20910c(f21275W);
        c3284i.m20916d(f21276X);
        c3284i.m20920e(f21277Y);
        c3284i.m20924f(fFloor);
        c3284i.m20909b(z);
        c3284i.m20913c(z2);
        c3284i.m20922e(true);
        c3284i.m20928g(f21293ah);
        m22602a(resources, c3284i, list, i2, z, z2, (int) f21276X, (int) f21287ab, (int) f21275W, COUIBaseListPopupWindow_12);
        interfaceC3419p.mo12656a(c3284i);
    }

    /* renamed from: y */
    public static void m22651y() {
        f21286aa = 0;
        f21277Y = 0.0f;
        f21288ac = 0;
        f21309ax = 0;
        f21310ay = 0;
        f21311az = 0;
        f21306au = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22607a(GLModelParam c3284i, int OplusGLSurfaceView_13, int i2) {
        if (c3284i == null) {
            return;
        }
        float COUIBaseListPopupWindow_12 = (OplusGLSurfaceView_13 * 1.0f) / i2;
        c3284i.m20924f((float) (Math.floor((r9 - r8) / 2.0f) / (f21275W * COUIBaseListPopupWindow_12)));
        m22610a(c3284i.m20896a(), c3284i.m20935n(), c3284i.m20934m(), (int) f21276X, (int) f21287ab, (int) f21275W, COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m22615a(List<FilterModel> list) {
        CameraLog.m12954a("FilterHelper", "checkStaticFilter, filterModelList: " + list);
        Iterator<FilterModel> it = list.iterator();
        while (it.hasNext()) {
            if (f21329s.contains(it.next().f21337a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m22613a(int OplusGLSurfaceView_13, GLModelParam c3284i) {
        CameraLog.m12954a("FilterHelper", "checkStaticFilterIndex, index: " + OplusGLSurfaceView_13 + ", glModelParam: " + c3284i);
        Iterator<String> it = f21329s.iterator();
        while (it.hasNext()) {
            if (OplusGLSurfaceView_13 == c3284i.m20895a(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m22602a(Resources resources, GLModelParam c3284i, List<FilterModel> list, int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, float COUIBaseListPopupWindow_12) {
        List<FilterModel> list2 = list;
        CameraLog.m12954a("FilterHelper", "generateDrawingItemsHorizontal, isFrontCam: " + z + ", needRotate: " + z2);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int size = list.size();
        boolean zM22615a = m22615a(list);
        c3284i.m20902a(zM22615a);
        boolean z3 = z && 4 == f21283aD;
        int i5 = 90;
        if (z2 || 90 == f21284aE) {
            int i6 = size - 1;
            while (i6 >= 0) {
                int i7 = ((i5 != f21284aE || z3) && !((270 == f21284aE && z3) || c3284i.m20936o())) ? i6 : (size - i6) - 1;
                DrawingItem drawingItem = new DrawingItem();
                Rect rectM22596a = m22596a(i7, z2 || i5 == f21284aE, z, i2, i3, i4, COUIBaseListPopupWindow_12);
                FilterModel c3414k = list2.get(i6);
                drawingItem.rect = rectM22596a;
                m22601a(resources, c3284i, drawingItem, z, i6, c3414k.f21337a, OplusGLSurfaceView_13, Math.round(i4 * COUIBaseListPopupWindow_12), i4, zM22615a);
                copyOnWriteArrayList.add(drawingItem);
                i6--;
                list2 = list;
                i5 = i5;
            }
        } else {
            int i8 = 0;
            while (i8 < size) {
                DrawingItem drawingItem2 = new DrawingItem();
                Rect rectM22596a2 = m22596a(i8, z2, z, i2, i3, i4, COUIBaseListPopupWindow_12);
                FilterModel c3414k2 = list2.get(i8);
                drawingItem2.rect = rectM22596a2;
                boolean z4 = zM22615a;
                m22601a(resources, c3284i, drawingItem2, z, i8, c3414k2.f21337a, OplusGLSurfaceView_13, Math.round(i4 * COUIBaseListPopupWindow_12), i4, z4);
                copyOnWriteArrayList.add(drawingItem2);
                i8++;
                zM22615a = z4;
                size = size;
            }
        }
        c3284i.m20901a(copyOnWriteArrayList);
        c3284i.m20898a(copyOnWriteArrayList.size());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m22622b(Resources resources, GLModelParam c3284i, List<FilterModel> list, int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, float COUIBaseListPopupWindow_12) {
        List<FilterModel> list2 = list;
        CameraLog.m12954a("FilterHelper", "generateDrawingItemsVertical");
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int size = list.size();
        boolean zM22615a = m22615a(list);
        c3284i.m20902a(zM22615a);
        if (z2) {
            for (int i5 = 0; i5 < size; i5++) {
                DrawingItem drawingItem = new DrawingItem();
                Rect rectM22596a = m22596a(i5, z2, z, i2, i3, i4, COUIBaseListPopupWindow_12);
                FilterModel c3414k = list2.get(i5);
                drawingItem.rect = rectM22596a;
                m22601a(resources, c3284i, drawingItem, z, i5, c3414k.f21337a, OplusGLSurfaceView_13, Math.round(i4 * COUIBaseListPopupWindow_12), i4, zM22615a);
                copyOnWriteArrayList.add(drawingItem);
            }
        } else {
            int i6 = size - 1;
            int i7 = i6;
            while (i7 >= 0) {
                DrawingItem drawingItem2 = new DrawingItem();
                Rect rectM22596a2 = m22596a(i6 - i7, z2, z, i2, i3, i4, COUIBaseListPopupWindow_12);
                FilterModel c3414k2 = list2.get(i7);
                drawingItem2.rect = rectM22596a2;
                m22601a(resources, c3284i, drawingItem2, z, i7, c3414k2.f21337a, OplusGLSurfaceView_13, Math.round(i4 * COUIBaseListPopupWindow_12), i4, zM22615a);
                copyOnWriteArrayList.add(drawingItem2);
                i7--;
                list2 = list;
            }
        }
        c3284i.m20901a(copyOnWriteArrayList);
        c3284i.m20898a(copyOnWriteArrayList.size());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Rect m22596a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, float COUIBaseListPopupWindow_12) {
        int iRound;
        Rect rect;
        Rect rect2;
        int iRound2 = Math.round((i4 - f21286aa) / 2.0f);
        if (COUIBaseListPopupWindow_12 < 1.0f) {
            iRound = Math.round(f21286aa / 2.0f);
        } else {
            iRound = Math.round((f21286aa * COUIBaseListPopupWindow_12) / 2.0f);
        }
        if (1 == f21283aD) {
            if (f21284aE == 0) {
                int iRound3 = Math.round(f21286aa / 2.0f);
                if (z) {
                    int i5 = (OplusGLSurfaceView_13 * (i3 + i2)) + i2 + iRound3;
                    return new Rect(i5 - iRound, iRound2, i5 + iRound, i4 - iRound2);
                }
                int i6 = ((OplusGLSurfaceView_13 * (i2 + i3)) + i3) - iRound3;
                return new Rect(i6 - iRound, iRound2, i6 + iRound, i4 - iRound2);
            }
            if (z) {
                int iRound4 = (i3 - (COUIBaseListPopupWindow_12 < 1.0f ? f21286aa : Math.round(f21286aa * COUIBaseListPopupWindow_12))) / 2;
                int i7 = f21286aa;
                int i8 = ((OplusGLSurfaceView_13 * (i2 + i4)) + i4) - i7;
                rect2 = new Rect(iRound4, i8, i3 - iRound4, i7 + i8);
            } else {
                int iRound5 = (i3 - (COUIBaseListPopupWindow_12 < 1.0f ? f21286aa : Math.round(f21286aa * COUIBaseListPopupWindow_12))) / 2;
                int i9 = (OplusGLSurfaceView_13 * (i4 + i2)) + i2;
                rect2 = new Rect(iRound5, i9, i3 - iRound5, f21286aa + i9);
            }
            return rect2;
        }
        int i10 = f21284aE;
        if (i10 == 0) {
            int iRound6 = Math.round(f21286aa / 2.0f) + iRound2;
            int i11 = i4 + i2;
            int i12 = ((OplusGLSurfaceView_13 + 1) * i11) - iRound2;
            if (z) {
                return new Rect(iRound6 - iRound, (OplusGLSurfaceView_13 * i11) + i2 + iRound2, iRound6 + iRound, i12);
            }
            if (f21285aF) {
                int i13 = i3 - iRound6;
                return new Rect(i13 - iRound, (OplusGLSurfaceView_13 * i11) + iRound2, i13 + iRound, i12 - i2);
            }
            int i14 = i3 - iRound6;
            return new Rect(i14 - iRound, (OplusGLSurfaceView_13 * i11) + iRound2 + i2, i14 + iRound, i12);
        }
        if (90 == i10) {
            int iRound7 = Math.round(f21286aa / 2.0f);
            int i15 = f21293ah;
            int i16 = ((i3 + i2) * OplusGLSurfaceView_13) + iRound7 + i15;
            int i17 = i16 - iRound;
            int i18 = i16 + iRound;
            int i19 = f21286aa;
            int i20 = (i4 - i15) - i19;
            int i21 = i19 + i20;
            if (z2) {
                i17 += i2;
                i18 += i2;
            }
            rect = new Rect(i17, i20, i18, i21);
        } else {
            int iRound8 = Math.round(f21286aa / 2.0f) + i2;
            int i22 = f21293ah;
            int i23 = ((i3 + i2) * OplusGLSurfaceView_13) + iRound8 + i22;
            int i24 = i23 - iRound;
            int i25 = i23 + iRound;
            int i26 = f21286aa + i22;
            if (z2) {
                i24 -= i2;
                i25 -= i2;
            }
            rect = new Rect(i24, i22, i25, i26);
        }
        return rect;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m22589a(String str, int OplusGLSurfaceView_13) {
        List<String> listM22561a = f21315e.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        if (str == null) {
            return -1;
        }
        return listM22561a.indexOf(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22606a(DrawingItem drawingItem, String str, boolean z) {
        Rect rect = drawingItem.rect;
        drawingItem.overlayBitmap = null;
        drawingItem.overlayTop = rect.height() / 2;
        if (z) {
            drawingItem.overlayLeft = ((rect.width() + rect.height()) / 2) - f21308aw;
        } else {
            drawingItem.overlayLeft = ((rect.width() - rect.height()) / 2) + f21308aw;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:144:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m22601a(android.content.res.Resources r14, com.oplus.camera.p172ui.menu.levelcontrol.GLModelParam r15, co.polarr.renderer.entities.DrawingItem r16, boolean r17, int r18, java.lang.String r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.FilterHelper.m22601a(android.content.res.Resources, com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_13, co.polarr.renderer.entities.DrawingItem, boolean, int, java.lang.String, int, int, int, boolean):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m22610a(List<DrawingItem> list, boolean z, boolean z2, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
        if (list == null) {
            return;
        }
        int size = list.size();
        if (!z) {
            for (int i4 = 0; i4 < size; i4++) {
                DrawingItem drawingItem = list.get(i4);
                Rect rectM22596a = m22596a(i4, false, z2, OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
                drawingItem.rect = rectM22596a;
                int iWidth = (rectM22596a.width() - f21286aa) / 2;
                if (drawingItem.overlayBitmap != null) {
                    drawingItem.overlayLeft = (iWidth - f21288ac) - drawingItem.overlayBitmap.getWidth();
                }
                if (drawingItem.thumbBitmap != null) {
                    drawingItem.thumbBitmap = m22593a(drawingItem.thumbBitmap, i2, i3);
                }
            }
            return;
        }
        int i5 = size - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            DrawingItem drawingItem2 = list.get(i6);
            Rect rectM22596a2 = m22596a(i5 - i6, true, z2, OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
            drawingItem2.rect = rectM22596a2;
            int iWidth2 = (rectM22596a2.width() - f21286aa) / 2;
            if (drawingItem2.overlayBitmap != null) {
                drawingItem2.overlayLeft = (rectM22596a2.width() + f21288ac) - iWidth2;
            }
            if (drawingItem2.thumbBitmap != null) {
                drawingItem2.thumbBitmap = m22593a(drawingItem2.thumbBitmap, i2, i3);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m22620b(int OplusGLSurfaceView_13, int i2) {
        List<String> listM22561a = f21315e.m22561a(CameraCharacteristicsUtil.m12974a(i2));
        return (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > listM22561a.size()) ? "" : listM22561a.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m22619b(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > f21316f.f21248b.size()) ? "" : f21316f.f21248b.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m22626c(int OplusGLSurfaceView_13, int i2) {
        List<String> listM22561a = f21319i.m22561a(CameraCharacteristicsUtil.m12974a(i2));
        return (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > listM22561a.size()) ? "" : listM22561a.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m22628d(int OplusGLSurfaceView_13, int i2) {
        List<String> listM22561a = f21320j.m22561a(CameraCharacteristicsUtil.m12974a(i2));
        return (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > listM22561a.size()) ? "" : listM22561a.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m22591a(boolean z) {
        return z ? f21260H : f21259G;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m22616b(boolean z) {
        return z ? f21262J : f21261I;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static String m22630e(int OplusGLSurfaceView_13, int i2) {
        return (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > f21321k.f21251e.size() + (-1)) ? "" : f21321k.f21251e.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m22593a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2) {
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 / i2;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i3 = (int) (height * COUIBaseListPopupWindow_12);
        int i4 = f21294ai / 2;
        Bitmap bitmapM24215a = Util.m24215a(i3, height, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapM24215a).drawBitmap(bitmap, (Rect) null, new Rect(((i3 - width) - i4) / 2, 0, ((i3 + width) + i4) / 2, height), (Paint) null);
        return bitmapM24215a;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b4  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap m22594a(com.oplus.camera.p172ui.menu.levelcontrol.GLModelParam r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.FilterHelper.m22594a(com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_13, int, int, boolean):android.graphics.Bitmap");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m22595a(GLModelParam c3284i, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        f21299an.setColor(z ? f21301ap : f21300ao);
        float COUIBaseListPopupWindow_12 = 0.0f;
        f21299an.setShadowLayer(f21304as, 0.0f, 0.0f, z ? f21303ar : f21302aq);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        boolean z2 = false;
        float height = 0.0f;
        for (FilterModel c3414k : c3284i.m20904b()) {
            String str = c3414k.f21338b;
            float fMeasureText = f21299an.measureText(str);
            if (!z2) {
                z2 = true;
                Paint.FontMetrics fontMetrics = f21299an.getFontMetrics();
                float f2 = fontMetrics.descent - fontMetrics.ascent;
                COUIBaseListPopupWindow_12 = (f2 - fontMetrics.descent) + f21289ad;
                height = (f21289ad + (f2 / 2.0f)) - (f21297al.getHeight() / 2.0f);
            }
            canvas.drawText(str, (f21287ab - fMeasureText) / 2.0f, COUIBaseListPopupWindow_12, f21299an);
            if (c3414k.f21339c) {
                canvas.drawBitmap(f21297al, ((f21287ab + fMeasureText) / 2.0f) + f21292ag, height, (Paint) null);
            }
            int i4 = f21290ae;
            COUIBaseListPopupWindow_12 += i4;
            height += i4;
        }
        if (c3284i.m20935n()) {
            Matrix matrix = new Matrix();
            matrix.setScale(-1.0f, 1.0f);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        }
        Bitmap bitmapCreateBitmap2 = bitmapCreateBitmap;
        if (90 == i3) {
            Matrix matrix2 = new Matrix();
            matrix2.setScale(1.0f, -1.0f);
            bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap2, 0, 0, bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight(), matrix2, true);
        }
        Bitmap bitmap = bitmapCreateBitmap2;
        if (270 != i3 || !c3284i.m20934m()) {
            return bitmap;
        }
        Matrix matrix3 = new Matrix();
        matrix3.setScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix3, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a9 A[SYNTHETIC] */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap m22618b(com.oplus.camera.p172ui.menu.levelcontrol.GLModelParam r22, int r23, int r24, boolean r25, int r26) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.FilterHelper.m22618b(com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_13, int, int, boolean, int):android.graphics.Bitmap");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m22617b(GLModelParam c3284i, int OplusGLSurfaceView_13, int i2, boolean z) {
        boolean z2;
        float COUIBaseListPopupWindow_12;
        f21299an.setColor(z ? f21301ap : f21300ao);
        float f2 = 0.0f;
        f21299an.setShadowLayer(f21304as, 0.0f, 0.0f, z ? f21303ar : f21302aq);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        canvas.rotate(90.0f);
        canvas.translate(0.0f, -OplusGLSurfaceView_13);
        boolean z3 = false;
        float height = 0.0f;
        float f3 = 0.0f;
        for (FilterModel c3414k : c3284i.m20904b()) {
            String str = c3414k.f21338b;
            float fMeasureText = f21299an.measureText(str);
            int i3 = 1;
            if (z3) {
                float f4 = f2;
                z2 = z3;
                COUIBaseListPopupWindow_12 = f4;
            } else {
                Paint.FontMetrics fontMetrics = f21299an.getFontMetrics();
                float f5 = fontMetrics.descent - fontMetrics.ascent;
                COUIBaseListPopupWindow_12 = (f5 - fontMetrics.descent) + f21289ad;
                height = (f21289ad + (f5 / 2.0f)) - (f21297al.getHeight() / 2.0f);
                f3 = f5;
                z2 = true;
            }
            float f6 = (f21275W - fMeasureText) / 2.0f;
            if (Float.compare(fMeasureText, f21291af) <= 0) {
                canvas.drawText(str, f6, COUIBaseListPopupWindow_12, f21299an);
            } else {
                while (i3 < str.length() && Float.compare(f21299an.measureText(str.substring(0, i3)), f21291af) <= 0) {
                    i3++;
                }
                int i4 = i3 - 1;
                canvas.drawText(str.substring(0, i4), (f21275W - f21299an.measureText(str.substring(0, i4))) / 2.0f, COUIBaseListPopupWindow_12, f21299an);
                fMeasureText = f21299an.measureText(str.substring(i4));
                canvas.drawText(str.substring(i4), (f21275W - fMeasureText) / 2.0f, COUIBaseListPopupWindow_12 + f3, f21299an);
            }
            if (c3414k.f21339c) {
                canvas.drawBitmap(f21297al, ((f21275W + fMeasureText) / 2.0f) + f21292ag, height, (Paint) null);
            }
            int i5 = f21290ae;
            height += i5;
            boolean z4 = z2;
            f2 = COUIBaseListPopupWindow_12 + i5;
            z3 = z4;
        }
        if (c3284i.m20935n()) {
            Matrix matrix = new Matrix();
            matrix.setScale(-1.0f, 1.0f);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        }
        canvas.restore();
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m22614a(FilterGroup c3412i, String str, int OplusGLSurfaceView_13) {
        return c3412i.f21248b.contains(str) && c3412i.f21250d.size() > OplusGLSurfaceView_13;
    }

    /* renamed from: z */
    public static float m22652z() {
        return f21286aa;
    }

    /* renamed from: A */
    public static float m22572A() {
        return f21275W;
    }

    /* renamed from: B */
    public static float m22573B() {
        return f21287ab;
    }

    /* renamed from: C */
    public static float m22574C() {
        return f21276X;
    }
}
