package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: FilterHelper.java */
/* loaded from: classes2.dex */
public class j_renamed {
    private static final java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>> r_renamed = new java.util.HashMap<>();

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f6905a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static java.lang.String f6906b = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_NONE;

    /* renamed from: c_renamed, reason: collision with root package name */
    public static java.util.HashMap<java.lang.String, java.lang.Integer> f6907c = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.String, java.lang.Integer> d_renamed = new java.util.HashMap<>();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed e_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed f_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed g_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed h_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed i_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed j_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed k_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed l_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed m_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed n_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed o_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed p_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    public static com.oplus.camera.ui.preview.a_renamed.i_renamed q_renamed = new com.oplus.camera.ui.preview.a_renamed.i_renamed();
    private static java.util.List<java.lang.String> s_renamed = null;
    private static boolean t_renamed = false;
    private static boolean u_renamed = false;
    private static boolean v_renamed = false;
    private static boolean w_renamed = false;
    private static boolean x_renamed = false;
    private static boolean y_renamed = false;
    private static int z_renamed = -1;
    private static int A_renamed = -1;
    private static int B_renamed = -1;
    private static int C_renamed = -1;
    private static int D_renamed = -1;
    private static int E_renamed = -1;
    private static int F_renamed = -1;
    private static int G_renamed = -1;
    private static int H_renamed = -1;
    private static int I_renamed = -1;
    private static int J_renamed = -1;
    private static int K_renamed = -1;
    private static int L_renamed = -1;
    private static int M_renamed = -1;
    private static int N_renamed = -1;
    private static int O_renamed = -1;
    private static int P_renamed = -1;
    private static int Q_renamed = -1;
    private static int R_renamed = 0;
    private static int S_renamed = 0;
    private static int T_renamed = 0;
    private static int U_renamed = 0;
    private static int V_renamed = 0;
    private static float W_renamed = 0.0f;
    private static float X_renamed = 0.0f;
    private static float Y_renamed = 0.0f;
    private static float Z_renamed = 0.0f;
    private static int aa_renamed = 0;
    private static float ab_renamed = 0.0f;
    private static int ac_renamed = 0;
    private static int ad_renamed = 0;
    private static int ae_renamed = 0;
    private static int af_renamed = 0;
    private static int ag_renamed = 0;
    private static int ah_renamed = 0;
    private static int ai_renamed = 0;
    private static android.graphics.Bitmap aj_renamed = null;
    private static android.graphics.Bitmap ak_renamed = null;
    private static android.graphics.Bitmap al_renamed = null;
    private static android.graphics.Bitmap am_renamed = null;
    private static android.text.TextPaint an_renamed = null;
    private static int ao_renamed = 0;
    private static int ap_renamed = 0;
    private static int aq_renamed = 0;
    private static int ar_renamed = 0;
    private static int as_renamed = 4;
    private static android.graphics.Rect at_renamed = new android.graphics.Rect();
    private static android.graphics.Paint.FontMetricsInt au_renamed = null;
    private static float av_renamed = 0.0f;
    private static int aw_renamed = 0;
    private static int ax_renamed = 0;
    private static int ay_renamed = 0;
    private static int az_renamed = 0;
    private static int aA_renamed = 0;
    private static int aB_renamed = 0;
    private static int aC_renamed = 0;
    private static int aD_renamed = 0;
    private static int aE_renamed = 0;
    private static boolean aF_renamed = false;

    static {
        co_renamed.polarr.renderer.FilterPackageUtil.setStaticLUTPath("/odm/etc/camera/filters_lut/");
        co_renamed.polarr.renderer.PolarrRender.SetStaticResPath("/odm/etc/camera/filters_res/");
        F_renamed();
        H_renamed();
        I_renamed();
        c_renamed();
        E_renamed();
        G_renamed();
        D_renamed();
        J_renamed();
        K_renamed();
        O_renamed();
        L_renamed();
        M_renamed();
        o_renamed.a_renamed(e_renamed, true, false);
        h_renamed.a_renamed(e_renamed, true, false);
        p_renamed.a_renamed(e_renamed, true, false);
        a_renamed(e_renamed, o_renamed);
    }

    private static void D_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FUJI_FILTER_SUPPORT)) {
            l_renamed.d_renamed("default", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none));
            l_renamed.d_renamed("type_fuji_provia", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_fuji_provia));
            l_renamed.d_renamed("type_fuji_velvia", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_fuji_vlevia));
            l_renamed.d_renamed("type_fuji_astia", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_fuji_astia));
            l_renamed.d_renamed("type_fuji_chrome", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_fuji_classic_chrome));
            l_renamed.d_renamed("type_fuji_acros", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_fuji_acros));
        }
    }

    private static void a_renamed(java.lang.Object... objArr) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER)) {
            com.oplus.camera.e_renamed.b_renamed("FilterHelper", "addGrandTourToFilterGroup, isExport: " + com.oplus.camera.util.Util.ak_renamed());
            for (java.lang.Object obj : objArr) {
                if (obj instanceof com.oplus.camera.ui.preview.a_renamed.i_renamed) {
                    if (com.oplus.camera.util.Util.ak_renamed()) {
                        com.oplus.camera.ui.preview.a_renamed.i_renamed iVar = (com.oplus.camera.ui.preview.a_renamed.i_renamed) obj;
                        iVar.d_renamed("gt_renamed-lake.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_blue_wave));
                        iVar.d_renamed("gt_renamed-japan.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_clean));
                        iVar.d_renamed("gt_renamed-earth.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_classic));
                        iVar.d_renamed("gt_renamed-rosy.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_rosy));
                    } else {
                        com.oplus.camera.ui.preview.a_renamed.i_renamed iVar2 = (com.oplus.camera.ui.preview.a_renamed.i_renamed) obj;
                        iVar2.d_renamed("gt_renamed-3dcity.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_three_dimen_city));
                        iVar2.d_renamed("gt_renamed-glazed-tile.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_glazed_tile));
                        iVar2.d_renamed("gt_renamed-desert.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_desert));
                        iVar2.d_renamed("gt_renamed-crisp-fall.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_crisp_fall));
                        iVar2.d_renamed("gt_renamed-mountainous.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_mountainous));
                        iVar2.d_renamed("gt_renamed-after-glow.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_after_glow));
                        iVar2.d_renamed("gt_renamed-coco-grove.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_coco_grove));
                        iVar2.d_renamed("gt_renamed-steaming.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_steaming));
                        iVar2.d_renamed("gt_renamed-24hour-city.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_night_city));
                        iVar2.d_renamed("gt_renamed-old-times.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_old_time));
                        iVar2.d_renamed("gt_renamed-azure-water.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_azure_water));
                        iVar2.d_renamed("gt_renamed-blue-water.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_blue_water));
                        iVar2.d_renamed("gt_renamed-quietly-ele.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_simple_elegant));
                        iVar2.d_renamed("gt_renamed-beach.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_gt_beach));
                    }
                }
            }
        }
    }

    private static void E_renamed() {
        boolean zAm = com.oplus.camera.util.Util.am_renamed();
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_bokeh_flare_portrait);
        java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.video_filter_blue);
        java.lang.Integer numValueOf3 = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.video_filter_green);
        java.lang.Integer numValueOf4 = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.video_filter_red);
        java.lang.Integer numValueOf5 = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none);
        if (zAm) {
            j_renamed.b_renamed("default", numValueOf5);
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT)) {
                j_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.RED_RED_2020, numValueOf4);
                j_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.TREE_GREEN_2020, numValueOf3);
                j_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.SKY_BLUE_2020, numValueOf2);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON)) {
                j_renamed.b_renamed("oplus_video_filter_neon", numValueOf);
            }
            j_renamed.b_renamed("V01-landscape-2.6.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_pop));
            j_renamed.b_renamed("cyberpunk-neoMilitarism-2.4-final.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night_city));
            j_renamed.b_renamed("cyberpunk-kitsch-3.1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_north_california));
            j_renamed.b_renamed("V02-portrait-2.5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_vintage));
            j_renamed.b_renamed("V03-food-2.0.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_yummy));
            j_renamed.b_renamed("V04-night-1.3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night));
            j_renamed.b_renamed("V05-mono-3.3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_black_white));
            return;
        }
        j_renamed.b_renamed("default", numValueOf5);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT)) {
            j_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.RED_RED_2020, numValueOf4);
            j_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.TREE_GREEN_2020, numValueOf3);
            j_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.SKY_BLUE_2020, numValueOf2);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT)) {
            j_renamed.b_renamed("oplus_video_filter_portrait_retention", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_retention));
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON)) {
            j_renamed.b_renamed("oplus_video_filter_neon", numValueOf);
        }
        if (com.oplus.camera.util.Util.ak_renamed()) {
            j_renamed.b_renamed("delight-V1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_yuyue));
            j_renamed.b_renamed("sweet-V2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_ziran));
            j_renamed.b_renamed("mellow-V3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_yonglan));
            j_renamed.b_renamed("misty-V4.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_yinyun));
            j_renamed.b_renamed("calm-V5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_qingleng));
            j_renamed.b_renamed("oplus_video_filter_black_and_white", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_danse));
            j_renamed.b_renamed("farewell-V7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_libie));
            return;
        }
        j_renamed.b_renamed("delight-V1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_youran));
        j_renamed.b_renamed("sweet-V2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_mingmei));
        j_renamed.b_renamed("mellow-V3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_xiangwang));
        j_renamed.b_renamed("misty-V4.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_liulian));
        j_renamed.b_renamed("calm-V5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_qingxin));
        j_renamed.b_renamed("oplus_video_filter_black_and_white", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_jingmi));
        j_renamed.b_renamed("farewell-V7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_video_filter_anyong));
    }

    private static void F_renamed() {
        boolean zAm = com.oplus.camera.util.Util.am_renamed();
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none);
        if (zAm) {
            e_renamed.b_renamed("default", numValueOf);
            a_renamed(com.oplus.camera.aps.config.ConfigDataBase.KEY_PHOTO_MASTER_FILTER_TYPE_LIST, e_renamed);
            e_renamed.b_renamed("PP1-soft-2.6.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_soft));
            e_renamed.b_renamed("V01-landscape-2.6.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_pop));
            e_renamed.b_renamed("cyberpunk-neoMilitarism-2.4-final.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night_city));
            e_renamed.b_renamed("cyberpunk-kitsch-3.1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_north_california));
            e_renamed.b_renamed("B612Pretty.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_b612));
            e_renamed.b_renamed("InsJuno.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_insjuno));
            e_renamed.b_renamed("BeautyplusMellow-5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_beautyplus));
            e_renamed.b_renamed("InsValencia-2.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_insvalencia));
            e_renamed.b_renamed("YoucamAdorable80.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_youcam));
            e_renamed.b_renamed("InsClarendon.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_insclare));
            e_renamed.b_renamed("SweetSnapAlice-3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_sweetsnap));
            e_renamed.b_renamed("V05-mono-3.3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_black_white_new));
            e_renamed.b_renamed("FaceappGrayscale.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_faceApp));
            e_renamed.b_renamed("SnapseedBright.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_snapseed));
            return;
        }
        if (com.oplus.camera.util.Util.ak_renamed()) {
            e_renamed.b_renamed("default", numValueOf);
            e_renamed.b_renamed("natural-P1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_ziran));
            e_renamed.b_renamed("sweet-P2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tianmei));
            e_renamed.b_renamed("delight-P3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yuyue));
            e_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tongtou));
            e_renamed.b_renamed("misty-P5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yinyun));
            e_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.YUANQI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_nuanyang));
            e_renamed.b_renamed("candy-P7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_mianhuatang));
            e_renamed.b_renamed("b_renamed-w_renamed-P8.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_heibai));
            e_renamed.b_renamed("serene-P9.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_baiyueguang));
            e_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.JIARI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tianye));
            return;
        }
        e_renamed.b_renamed("default", numValueOf);
        if (com.oplus.camera.util.Util.ao_renamed()) {
            a_renamed(com.oplus.camera.aps.config.ConfigDataBase.KEY_PHOTO_MASTER_FILTER_TYPE_LIST, e_renamed);
        }
        e_renamed.b_renamed("natural-P1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_mingmei));
        e_renamed.b_renamed("sweet-P2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_pianai));
        e_renamed.b_renamed("delight-P3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_youran));
        e_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yuanqi));
        e_renamed.b_renamed("misty-P5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_liulian));
        e_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.YUANQI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jidong));
        e_renamed.b_renamed("candy-P7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_zhiyu));
        e_renamed.b_renamed("b_renamed-w_renamed-P8.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jingmi));
        e_renamed.b_renamed("serene-P9.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yonglan));
        e_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.JIARI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_xiaxiang));
    }

    private static void a_renamed(java.lang.String str, com.oplus.camera.ui.preview.a_renamed.i_renamed iVar) {
        java.util.List<java.lang.String> configStringListValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringListValue(str);
        if (configStringListValue != null) {
            for (java.lang.String str2 : configStringListValue) {
                if (!android.text.TextUtils.isEmpty(str2)) {
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
                        iVar.b_renamed(str2, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_master_radiance));
                    } else if (c2 == 1) {
                        iVar.b_renamed(str2, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_master_serenity));
                    } else if (c2 == 2) {
                        iVar.b_renamed(str2, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_master_emerald));
                    }
                }
            }
        }
    }

    private static void G_renamed() {
        java.util.List<java.lang.String> configStringListValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_FILTER_TYPE_LIST);
        if (configStringListValue != null) {
            n_renamed.a_renamed("default", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none));
            java.util.Iterator<java.lang.String> it = configStringListValue.iterator();
            while (it.hasNext()) {
                switch (it.next()) {
                    case "OPLUSR0604.cube.rgb.bin":
                        n_renamed.a_renamed("OPLUSR0604.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.street_filter_jie_pai));
                        break;
                    case "DL_L_B6.cube.rgb.bin":
                        n_renamed.a_renamed("DL_L_B6.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.street_filter_guang_ying));
                        break;
                    case "DL_D_G4.cube.rgb.bin":
                        n_renamed.a_renamed("DL_D_G4.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.street_filter_xi_ju));
                        break;
                    case "oplus-r_renamed-black-gold-1.1-RGB.CUBE.rgb.bin":
                        n_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_modern_gold_oplus_r));
                        break;
                    case "oplus-r_renamed-cyberpunk-RGB.CUBE.rgb.bin":
                        n_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_CYBERPUNK_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_cyberpunk_oplus_r));
                        break;
                    case "oplus-r_renamed-infra-RGB.CUBE.rgb.bin":
                        n_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_INFRA_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_flamingo_oplus_r));
                        break;
                    case "bright_coloured.bin":
                        n_renamed.a_renamed("bright_coloured.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_bright_coloured));
                        break;
                    case "interstellar_space.bin":
                        n_renamed.a_renamed("interstellar_space.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_interstellar_space));
                        break;
                }
            }
        }
    }

    private static void H_renamed() {
        f_renamed.d_renamed("default", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none));
        f_renamed.d_renamed("anc_filtert_polyspin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_anc_5));
        f_renamed.d_renamed("anc_filtert_hexagon", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_anc_2));
        f_renamed.d_renamed("anc_filtert_concentric_circles", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_anc_4));
        f_renamed.d_renamed("anc_filtert_spiral", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_anc_3));
        f_renamed.d_renamed("anc_filtert_cell_greenorange", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_anc_6));
    }

    private static void I_renamed() {
        i_renamed.b_renamed("default", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none));
        a_renamed(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_MASTER_FILTER_TYPE_LIST, i_renamed);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_STREAMER_SUPPORT)) {
            i_renamed.d_renamed("portrait_streamer", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_streamer));
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT)) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_FRONT_RETENTION_SUPPORT)) {
                i_renamed.c_renamed("portrait_retention", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_retention));
            }
            i_renamed.d_renamed("portrait_retention", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_retention));
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT)) {
            i_renamed.d_renamed("neon-2020.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_bokeh_flare_portrait));
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT)) {
            i_renamed.c_renamed("neon-2020.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_bokeh_flare_portrait));
        }
        if (com.oplus.camera.util.Util.ak_renamed()) {
            i_renamed.b_renamed("natural-P1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_ziran));
            i_renamed.b_renamed("sweet-P2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tianmei));
            i_renamed.b_renamed("delight-P3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yuyue));
            i_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tongtou));
            i_renamed.b_renamed("misty-P5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yinyun));
            i_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.YUANQI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_nuanyang));
            i_renamed.b_renamed("candy-P7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_mianhuatang));
            i_renamed.b_renamed("b_renamed-w_renamed-P8.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_heibai));
            i_renamed.b_renamed("serene-P9.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_baiyueguang));
            i_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.JIARI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tianye));
        } else {
            i_renamed.b_renamed("natural-P1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_mingmei));
            i_renamed.b_renamed("sweet-P2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_pianai));
            i_renamed.b_renamed("delight-P3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_youran));
            i_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yuanqi));
            i_renamed.b_renamed("misty-P5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_liulian));
            i_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.YUANQI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jidong));
            i_renamed.b_renamed("candy-P7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_zhiyu));
            i_renamed.b_renamed("b_renamed-w_renamed-P8.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jingmi));
            i_renamed.b_renamed("serene-P9.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yonglan));
            i_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.JIARI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_xiaxiang));
        }
        V_renamed = i_renamed.f6903b.size();
    }

    public static void a_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DIRECTOR_FILTER_SUPPORT) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DIRECTOR_FILTER_RUS) && com.oplus.camera.l_renamed.c_renamed.e_renamed() && !e_renamed.f6903b.contains("drjw1994.bin")) {
            e_renamed.a_renamed(1, "drjw1994.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jangwen1994));
            e_renamed.a_renamed(2, "drjw2010.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jangwen2010));
            j_renamed.a_renamed(1, "drjw1994.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jangwen1994));
            j_renamed.a_renamed(2, "drjw2010.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jangwen2010));
            O_renamed();
        }
    }

    public static void b_renamed() {
        if (!u_renamed) {
            q_renamed.a_renamed(e_renamed, true, true);
            u_renamed = true;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_SUPPORT) && com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE) == 0) {
            if (v_renamed && a_renamed(q_renamed, co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1, z_renamed)) {
                q_renamed.a_renamed(z_renamed);
            } else if (w_renamed && a_renamed(q_renamed, co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_3, A_renamed)) {
                q_renamed.a_renamed(A_renamed);
            } else if (x_renamed && a_renamed(q_renamed, co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_5, B_renamed)) {
                q_renamed.a_renamed(B_renamed);
            } else if (y_renamed && a_renamed(q_renamed, co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_6, C_renamed)) {
                q_renamed.a_renamed(C_renamed);
            }
        }
        N_renamed();
    }

    private static void J_renamed() {
        if (com.oplus.camera.util.Util.ao_renamed()) {
            g_renamed.d_renamed("default", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none));
            g_renamed.d_renamed("Delta400.3dl.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_soft));
        }
    }

    private static void K_renamed() {
        boolean zAm = com.oplus.camera.util.Util.am_renamed();
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none);
        if (zAm) {
            m_renamed.b_renamed("default", numValueOf);
            m_renamed.b_renamed("PP1-soft-2.6.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_soft));
            m_renamed.b_renamed("V01-landscape-2.6.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_pop));
            m_renamed.b_renamed("cyberpunk-neoMilitarism-2.4-final.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night_city));
            m_renamed.b_renamed("cyberpunk-kitsch-3.1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_north_california));
            m_renamed.b_renamed("B612Pretty.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_b612));
            m_renamed.b_renamed("InsJuno.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_insjuno));
            m_renamed.b_renamed("BeautyplusMellow-5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_beautyplus));
            m_renamed.b_renamed("InsValencia-2.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_insvalencia));
            m_renamed.b_renamed("YoucamAdorable80.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_youcam));
            m_renamed.b_renamed("InsClarendon.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_insclare));
            m_renamed.b_renamed("SweetSnapAlice-3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_sweetsnap));
            m_renamed.b_renamed("V05-mono-3.3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_black_white_new));
            m_renamed.b_renamed("FaceappGrayscale.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_faceApp));
            m_renamed.b_renamed("SnapseedBright.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_snapseed));
            return;
        }
        if (com.oplus.camera.util.Util.ak_renamed()) {
            m_renamed.b_renamed("default", numValueOf);
            m_renamed.b_renamed("natural-P1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_ziran));
            m_renamed.b_renamed("sweet-P2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tianmei));
            m_renamed.b_renamed("delight-P3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yuyue));
            m_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tongtou));
            m_renamed.b_renamed("misty-P5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yinyun));
            m_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.YUANQI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_nuanyang));
            m_renamed.b_renamed("candy-P7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_mianhuatang));
            m_renamed.b_renamed("b_renamed-w_renamed-P8.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_heibai));
            m_renamed.b_renamed("serene-P9.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_baiyueguang));
            m_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.JIARI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_tianye));
            return;
        }
        m_renamed.b_renamed("default", numValueOf);
        m_renamed.b_renamed("natural-P1.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_mingmei));
        m_renamed.b_renamed("sweet-P2.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_pianai));
        m_renamed.b_renamed("delight-P3.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_youran));
        m_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yuanqi));
        m_renamed.b_renamed("misty-P5.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_liulian));
        m_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.YUANQI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jidong));
        m_renamed.b_renamed("candy-P7.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_zhiyu));
        m_renamed.b_renamed("b_renamed-w_renamed-P8.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_jingmi));
        m_renamed.b_renamed("serene-P9.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_yonglan));
        m_renamed.b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.JIARI_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_xiaxiang));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    private static void L_renamed() {
        boolean zAm = com.oplus.camera.util.Util.am_renamed();
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_none);
        if (zAm) {
            k_renamed.d_renamed("default", numValueOf);
            k_renamed.d_renamed("PP1-soft-2.6.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_soft));
            k_renamed.d_renamed("V01-landscape-2.6.CUBE.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_pop));
            k_renamed.d_renamed("oplus-black-gold.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night_black_gold));
            k_renamed.d_renamed("oplus-yellow-blue.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night_teal_orange));
            k_renamed.d_renamed("oplus-cyberpunk.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night_cyberpunk));
            k_renamed.d_renamed("oplus-nightcity.cube.rgb.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_night_city));
            return;
        }
        java.util.List<java.lang.String> configStringListValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_FILTER_TYPE_LIST);
        if (configStringListValue != null) {
            k_renamed.a_renamed("default", numValueOf);
            for (java.lang.String str : configStringListValue) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1597549145:
                        if (str.equals(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020)) {
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
                        if (str.equals(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_CYBERPUNK_2020)) {
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
                        if (str.equals(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_INFRA_2020)) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    k_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_modern_gold_oplus_r));
                    e_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_modern_gold_oplus_r));
                } else if (c2 == 1) {
                    k_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_CYBERPUNK_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_cyberpunk_oplus_r));
                    e_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_CYBERPUNK_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_cyberpunk_oplus_r));
                } else if (c2 == 2) {
                    k_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_INFRA_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_flamingo_oplus_r));
                    e_renamed.d_renamed(co_renamed.polarr.renderer.FilterPackageUtil.OPLUS_R_INFRA_2020, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_flamingo_oplus_r));
                } else if (c2 == 3) {
                    k_renamed.a_renamed("black_gold.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_black_gold));
                } else if (c2 == 4) {
                    k_renamed.a_renamed("interstellar_space.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_interstellar_space));
                } else if (c2 == 5) {
                    k_renamed.a_renamed("bright_coloured.bin", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.night_filter_bright_coloured));
                }
            }
        }
    }

    private static void M_renamed() {
        s_renamed = new java.util.ArrayList();
        s_renamed.add("neon-2020.cube.rgb.bin");
        s_renamed.add("oplus_video_filter_neon");
        s_renamed.add(co_renamed.polarr.renderer.FilterPackageUtil.RED_RED_2020);
        s_renamed.add(co_renamed.polarr.renderer.FilterPackageUtil.TREE_GREEN_2020);
        s_renamed.add(co_renamed.polarr.renderer.FilterPackageUtil.SKY_BLUE_2020);
        s_renamed.add("portrait_retention");
        s_renamed.add("oplus_video_filter_portrait_retention");
    }

    public static void c_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_SUPPORT)) {
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE);
            if (configIntValue == 0) {
                b_renamed(e_renamed);
                a_renamed(e_renamed);
            } else if (1 == configIntValue) {
                b_renamed(i_renamed);
                a_renamed(i_renamed);
            } else {
                b_renamed(e_renamed);
                a_renamed(e_renamed);
                b_renamed(i_renamed);
                a_renamed(i_renamed);
            }
        }
        N_renamed();
    }

    private static void a_renamed(com.oplus.camera.ui.preview.a_renamed.i_renamed iVar) {
        int size = iVar.f6903b.size();
        int iA = com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_PORTRAIT_MONO_1);
        com.oplus.camera.e_renamed.b_renamed("FilterHelper", "initialPortraitMonoFilter,rear_portrait_mono_1 id_renamed = " + iA + ", sbHasMono1 is_renamed " + v_renamed);
        if (!v_renamed && iA != 0) {
            v_renamed = true;
            R_renamed = iA;
            z_renamed = size;
            if (com.oplus.camera.util.Util.ak_renamed()) {
                com.oplus.camera.e_renamed.b_renamed("FilterHelper", "initialPortraitMonoFilter,add camera protrait filter xiaoxiang");
                iVar.c_renamed(z_renamed, co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_protrait_filter_xiaoxiang));
            } else {
                iVar.c_renamed(z_renamed, co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_protrait_filter_huiyi));
            }
        }
        int iA2 = com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_PORTRAIT_MONO_2);
        if (w_renamed || iA2 == 0) {
            return;
        }
        w_renamed = true;
        S_renamed = iA2;
        int i2 = z_renamed;
        if (-1 != i2) {
            size = i2 + 1;
        }
        A_renamed = size;
        iVar.c_renamed(A_renamed, co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_protrait_filter_louguang));
    }

    private static void b_renamed(com.oplus.camera.ui.preview.a_renamed.i_renamed iVar) {
        int size = iVar.f6903b.size();
        int iA = com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MONO_CAMERA_1);
        if (!x_renamed && iA != 0) {
            x_renamed = true;
            T_renamed = iA;
            B_renamed = size;
            iVar.c_renamed(B_renamed, co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_5, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_heibai));
        }
        int iA2 = com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MONO_CAMERA_2);
        if (y_renamed || iA2 == 0) {
            return;
        }
        y_renamed = true;
        U_renamed = iA2;
        int i2 = B_renamed;
        if (-1 != i2) {
            size = i2 + 1;
        }
        C_renamed = size;
        iVar.c_renamed(C_renamed, co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_6, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_filter_oplus_faceApp));
    }

    private static void N_renamed() {
        L_renamed = i_renamed.f6902a.indexOf("portrait_retention");
        D_renamed = i_renamed.f6903b.indexOf("portrait_streamer");
        K_renamed = i_renamed.f6903b.indexOf("portrait_retention");
        F_renamed = i_renamed.f6902a.indexOf("neon-2020.cube.rgb.bin");
        E_renamed = i_renamed.f6903b.indexOf("neon-2020.cube.rgb.bin");
        N_renamed = i_renamed.f6902a.indexOf("default");
        M_renamed = i_renamed.f6903b.indexOf("default");
        Q_renamed = e_renamed.f6903b.indexOf("default");
    }

    private static void O_renamed() {
        H_renamed = j_renamed.f6902a.indexOf("oplus_video_filter_neon");
        G_renamed = j_renamed.f6903b.indexOf("oplus_video_filter_neon");
        J_renamed = j_renamed.f6902a.indexOf("oplus_video_filter_portrait_retention");
        I_renamed = j_renamed.f6903b.indexOf("oplus_video_filter_portrait_retention");
        P_renamed = j_renamed.f6902a.indexOf("default");
        O_renamed = j_renamed.f6903b.indexOf("default");
    }

    public static java.util.Set<java.lang.String> d_renamed() {
        return r_renamed.keySet();
    }

    public static java.util.ArrayList<java.lang.String> a_renamed(java.lang.String str) {
        if (!r_renamed.containsKey(str)) {
            com.oplus.camera.e_renamed.e_renamed("FilterHelper", "getGrandTourFilterListForCity, " + str + " is_renamed not in_renamed grand tour cities list");
            return new java.util.ArrayList<>();
        }
        return r_renamed.get(str);
    }

    private static void P_renamed() throws java.lang.Throwable {
        com.oplus.camera.e_renamed.b_renamed("FilterHelper", "parseGrandTourCityFilterFromAsset");
        java.lang.String strD = com.oplus.camera.util.Util.d_renamed("city_filter_oplus.json");
        if (strD == null) {
            return;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray(strD);
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            org.json.JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (!jSONObject.getString("Locality").equalsIgnoreCase("domestic") || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_FEATURE_GRAND_TOUR_DOMESTIC)) {
                org.json.JSONArray jSONArray2 = jSONObject.getJSONArray("Value");
                org.json.JSONArray jSONArray3 = jSONObject.getJSONArray("CityTag");
                java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList.add(jSONArray2.get(i3).toString());
                }
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    r_renamed.put(jSONArray3.get(i4).toString().toLowerCase(), arrayList);
                }
            }
        }
        com.oplus.camera.e_renamed.b_renamed("FilterHelper", "parseGrandTourCityFilterFromAsset, cityList: " + r_renamed.keySet().toString());
        com.oplus.camera.e_renamed.b_renamed("FilterHelper", "parseGrandTourCityFilterFromAsset, cityFilterMap: " + r_renamed.toString());
    }

    public static void e_renamed() {
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.-$$Lambda$j_renamed$k_H5ZO5vfj0viiqyT_sV-pkBL0c
            @Override // java.lang.Runnable
            public final void run() throws java.lang.Throwable {
                com.oplus.camera.ui.preview.a_renamed.j_renamed.Q_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q_renamed() throws java.lang.Throwable {
        try {
            com.oplus.camera.e_renamed.b_renamed("FilterHelper", "parseGrandTourCityFilterList");
            r_renamed.clear();
            P_renamed();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.Integer> a_renamed(java.util.HashMap<java.lang.String, java.lang.Integer> map) {
        java.util.LinkedList<java.util.Map.Entry> linkedList = new java.util.LinkedList(map.entrySet());
        linkedList.sort(new java.util.Comparator() { // from class: com.oplus.camera.ui.preview.a_renamed.-$$Lambda$j_renamed$weIxL3OlhF4ShLQDmQgbnNgXpkA
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed((java.util.Map.Entry) obj, (java.util.Map.Entry) obj2);
            }
        });
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry entry : linkedList) {
            linkedHashMap.put((java.lang.String) entry.getKey(), (java.lang.Integer) entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a_renamed(java.util.Map.Entry entry, java.util.Map.Entry entry2) {
        return ((java.lang.Integer) entry2.getValue()).compareTo((java.lang.Integer) entry.getValue());
    }

    public static void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "resetGrandTourFilters");
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER)) {
            java.util.HashMap<java.lang.String, java.lang.Integer> mapA = a_renamed(f6907c);
            for (java.lang.String str : mapA.keySet()) {
                int iIntValue = mapA.get(str).intValue();
                int iIntValue2 = d_renamed.get(str).intValue();
                e_renamed.a_renamed(e_renamed.f6903b.indexOf(str));
                e_renamed.c_renamed(iIntValue, str, java.lang.Integer.valueOf(iIntValue2));
            }
            f6907c.clear();
            d_renamed.clear();
            f6906b = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_NONE;
            t_renamed = false;
        }
    }

    public static void b_renamed(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("updateGrandTourFilters, city: ");
        sb.append(str);
        sb.append(" has key: ");
        sb.append(!r_renamed.containsKey(str));
        sb.append(" selectedCity :");
        sb.append(f6906b);
        com.oplus.camera.e_renamed.b_renamed("FilterHelper", sb.toString());
        if (str == null || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER) || !r_renamed.containsKey(str) || f6906b.equalsIgnoreCase(str)) {
            com.oplus.camera.e_renamed.e_renamed("FilterHelper", "updateGrandTourFiltersList, - No need to update the filter list.");
            return;
        }
        java.util.ArrayList<java.lang.String> arrayList = r_renamed.get(str);
        if (arrayList == null || arrayList.size() == 0) {
            com.oplus.camera.e_renamed.e_renamed("FilterHelper", "updateGrandTourFiltersList, No filters for " + str + " city");
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            java.lang.String str2 = arrayList.get(i2);
            int iIndexOf = e_renamed.f6903b.indexOf(str2);
            if (iIndexOf != -1) {
                int iIntValue = e_renamed.d_renamed.get(iIndexOf).intValue();
                f6907c.put(str2, java.lang.Integer.valueOf(iIndexOf));
                d_renamed.put(str2, java.lang.Integer.valueOf(iIntValue));
            }
        }
        int i3 = 1;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            java.lang.String str3 = arrayList.get(i4);
            int iIndexOf2 = e_renamed.f6903b.indexOf(str3);
            if (iIndexOf2 != -1) {
                int iIntValue2 = e_renamed.d_renamed.get(iIndexOf2).intValue();
                e_renamed.a_renamed(iIndexOf2);
                e_renamed.c_renamed(i3, str3, java.lang.Integer.valueOf(iIntValue2));
                i3++;
            }
        }
        f6906b = str;
        t_renamed = true;
    }

    public static boolean a_renamed(int i2) {
        return t_renamed && !f6906b.equalsIgnoreCase(com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_NONE) && f6907c.containsKey(e_renamed.f6903b.get(i2));
    }

    public static boolean g_renamed() {
        return t_renamed;
    }

    public static int h_renamed() {
        return z_renamed;
    }

    public static int i_renamed() {
        return A_renamed;
    }

    public static int j_renamed() {
        return B_renamed;
    }

    public static int k_renamed() {
        return C_renamed;
    }

    public static int l_renamed() {
        return D_renamed;
    }

    public static int m_renamed() {
        return F_renamed;
    }

    public static int n_renamed() {
        return E_renamed;
    }

    public static int o_renamed() {
        return K_renamed;
    }

    public static int p_renamed() {
        return M_renamed;
    }

    public static int q_renamed() {
        return N_renamed;
    }

    public static int r_renamed() {
        return O_renamed;
    }

    public static int s_renamed() {
        return Q_renamed;
    }

    public static int t_renamed() {
        return P_renamed;
    }

    public static int u_renamed() {
        return R_renamed;
    }

    public static int v_renamed() {
        return S_renamed;
    }

    public static int w_renamed() {
        return T_renamed;
    }

    public static int x_renamed() {
        return U_renamed;
    }

    public static void a_renamed(int i2, int i3) {
        aD_renamed = i2;
        aE_renamed = i3;
        y_renamed();
    }

    public static void a_renamed(android.content.res.Resources resources, java.lang.String str, int i2, int i3, boolean z2, boolean z3, boolean z4, java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list, com.oplus.camera.ui.preview.a_renamed.p_renamed pVar, android.util.Size size, boolean z5) {
        float width = (size.getWidth() * 1.0f) / size.getHeight();
        if (1 == aD_renamed) {
            if (aE_renamed == 0) {
                a_renamed(resources, str, i2, i3, z2, z3, list, pVar, width);
                return;
            } else {
                b_renamed(resources, str, i2, i3, z2, false, list, pVar, width);
                return;
            }
        }
        a_renamed(resources, str, i2, i3, z2, z3, z4, list, pVar, width, z5);
    }

    public static void a_renamed(android.content.res.Resources resources, java.lang.String str, int i2, int i3, boolean z2, boolean z3, boolean z4, java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list, com.oplus.camera.ui.preview.a_renamed.p_renamed pVar, float f2, boolean z5) {
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "setImageResourceHorizontal");
        aF_renamed = z5;
        if (aE_renamed == 0) {
            W_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_filter_menu_elements_width);
            ab_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_filter_menu_elements_height);
            X_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_menu_effect_filter_elements_gap);
        } else {
            ab_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_filter_menu_elements_width);
            W_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_filter_menu_elements_height);
            X_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_rack_menu_effect_filter_elements_gap);
        }
        if (aa_renamed == 0) {
            aa_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_filter_menu_elment_image_size);
        }
        if (java.lang.Float.compare(Y_renamed, 0.0f) == 0) {
            Y_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.horizontal_common_menu_effect_filter_elements_highlight_height);
        }
        if (ac_renamed == 0) {
            ac_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_filter_menu_text_top_margin);
        }
        if (ax_renamed == 0) {
            ax_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_sides_padding);
        }
        if (ay_renamed == 0) {
            ay_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_updown_padding);
        }
        if (az_renamed == 0) {
            az_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_filter_row_offset);
        }
        if (java.lang.Float.compare(Z_renamed, 0.0f) == 0) {
            Z_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_grandtour_map_icon_negative_offset);
        }
        if (aj_renamed == null) {
            aj_renamed = com.oplus.camera.util.Util.a_renamed(resources.getDrawable(com.oplus.camera.R_renamed.drawable.filter_select_highlight, null));
        }
        if (ak_renamed == null) {
            if (com.oplus.camera.util.Util.ao_renamed()) {
                ak_renamed = a_renamed(resources, com.oplus.camera.R_renamed.drawable.filter_select_highlight);
            } else {
                ak_renamed = a_renamed(resources, com.oplus.camera.R_renamed.drawable.filter_select_highlight_inverse);
            }
        }
        if (al_renamed == null) {
            al_renamed = android.graphics.BitmapFactory.decodeResource(resources, com.oplus.camera.R_renamed.drawable.filter_redpot);
        }
        if (am_renamed == null) {
            am_renamed = com.oplus.camera.util.Util.a_renamed(resources.getDrawable(com.oplus.camera.R_renamed.drawable.filter_grand_tour_recommend_icon, null));
        }
        if (an_renamed == null) {
            an_renamed = new android.text.TextPaint();
            ao_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
            ap_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency);
            aq_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
            ar_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_0_percent_transparency);
            as_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_value_text_shadow_radius);
            an_renamed.setColor(ao_renamed);
            an_renamed.setAntiAlias(true);
            an_renamed.setShadowLayer(as_renamed, 0.0f, 0.0f, aq_renamed);
            an_renamed.setTextSize(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_size));
        }
        ad_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_margin_top);
        ag_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_red_dot_margin_left);
        af_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_max_width);
        ah_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_element_margin_top);
        ai_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.makeup_item_highlight_stroke_width);
        if (au_renamed == null) {
            au_renamed = an_renamed.getFontMetricsInt();
        }
        aA_renamed = au_renamed.bottom - au_renamed.top;
        aB_renamed = au_renamed.ascent;
        an_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        an_renamed.getTextBounds("...", 0, 3, at_renamed);
        aC_renamed = at_renamed.width();
        av_renamed = W_renamed - (ax_renamed * 2);
        float fFloor = f2 > 1.0f ? (float) (java.lang.Math.floor((r5 - r1) / 2.0f) / (aa_renamed * f2)) : 0.0f;
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = new com.oplus.camera.ui.menu.levelcontrol.i_renamed(str);
        iVar.c_renamed((java.util.List<android.graphics.Bitmap>) null);
        iVar.b_renamed(list);
        iVar.a_renamed(aj_renamed);
        iVar.b_renamed(ak_renamed);
        iVar.f_renamed(i2);
        iVar.a_renamed(60.0f);
        iVar.b_renamed(ab_renamed);
        iVar.c_renamed(W_renamed);
        iVar.d_renamed(X_renamed);
        iVar.e_renamed(Y_renamed);
        iVar.f_renamed(fFloor);
        iVar.b_renamed(z2);
        iVar.c_renamed(z3);
        iVar.d_renamed(z4);
        iVar.e_renamed(true);
        iVar.g_renamed(ah_renamed);
        if (z5) {
            java.util.Collections.reverse(list);
        }
        a_renamed(resources, iVar, list, i3, z2, z3, (int) X_renamed, (int) ab_renamed, (int) W_renamed, f2);
        pVar.a_renamed(iVar);
    }

    private static android.graphics.Bitmap a_renamed(android.content.res.Resources resources, int i2) {
        android.graphics.drawable.Drawable drawableA;
        if (resources == null || (drawableA = androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(resources, i2, null)) == null) {
            return null;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(drawableA.getIntrinsicWidth(), drawableA.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawableA.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableA.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static void a_renamed(android.content.res.Resources resources, java.lang.String str, int i2, int i3, boolean z2, boolean z3, java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list, com.oplus.camera.ui.preview.a_renamed.p_renamed pVar, float f2) {
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "setImageResourceVertical");
        if (aa_renamed == 0) {
            aa_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_element_image_size);
        }
        ab_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_height);
        W_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_width);
        X_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_gap);
        if (java.lang.Float.compare(Y_renamed, 0.0f) == 0) {
            Y_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_highlight_height);
        }
        if (aw_renamed == 0) {
            aw_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_bitmap_bottom_padding);
        }
        if (ax_renamed == 0) {
            ax_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_text_sides_padding);
        }
        if (ay_renamed == 0) {
            ay_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_updown_padding);
        }
        if (ac_renamed == 0) {
            ac_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_text_top_margin);
        }
        if (ay_renamed == 0) {
            ay_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_text_updown_padding);
        }
        if (az_renamed == 0) {
            az_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_row_offset);
        }
        if (aj_renamed == null) {
            aj_renamed = android.graphics.BitmapFactory.decodeResource(resources, com.oplus.camera.R_renamed.drawable.filter_menu_selector);
        }
        if (ak_renamed == null) {
            ak_renamed = a_renamed(resources, com.oplus.camera.R_renamed.drawable.filter_select_highlight_inverse);
        }
        if (al_renamed == null) {
            al_renamed = android.graphics.BitmapFactory.decodeResource(resources, com.oplus.camera.R_renamed.drawable.filter_redpot);
        }
        ad_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_margin_top_vertical);
        ag_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_red_dot_margin_left);
        ae_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_vertical_offset);
        af_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_max_width_vertical);
        if (an_renamed == null) {
            an_renamed = new android.text.TextPaint();
            ao_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
            ap_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency);
            aq_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
            ar_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_0_percent_transparency);
            an_renamed.setColor(ao_renamed);
            an_renamed.setAntiAlias(true);
            an_renamed.setShadowLayer(as_renamed, 0.0f, 0.0f, aq_renamed);
            an_renamed.setTextSize(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_size));
        }
        if (au_renamed == null) {
            au_renamed = an_renamed.getFontMetricsInt();
        }
        aA_renamed = au_renamed.bottom - au_renamed.top;
        aB_renamed = au_renamed.ascent;
        an_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        an_renamed.getTextBounds("...", 0, 3, at_renamed);
        aC_renamed = at_renamed.width();
        av_renamed = W_renamed - (ax_renamed * 2);
        float fFloor = f2 > 1.0f ? (float) (java.lang.Math.floor((r4 - r1) / 2.0f) / (aa_renamed * f2)) : 0.0f;
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = new com.oplus.camera.ui.menu.levelcontrol.i_renamed(str);
        iVar.c_renamed((java.util.List<android.graphics.Bitmap>) null);
        iVar.b_renamed(list);
        iVar.a_renamed(aj_renamed);
        iVar.b_renamed(ak_renamed);
        iVar.f_renamed(i2);
        iVar.a_renamed(60.0f);
        iVar.b_renamed(ab_renamed);
        iVar.c_renamed(W_renamed);
        iVar.d_renamed(X_renamed);
        iVar.e_renamed(Y_renamed);
        iVar.f_renamed(fFloor);
        iVar.b_renamed(z2);
        iVar.c_renamed(z3);
        iVar.e_renamed(true);
        b_renamed(resources, iVar, list, i3, z2, z3, (int) X_renamed, (int) ab_renamed, (int) W_renamed, f2);
        pVar.a_renamed(iVar);
    }

    public static void b_renamed(android.content.res.Resources resources, java.lang.String str, int i2, int i3, boolean z2, boolean z3, java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list, com.oplus.camera.ui.preview.a_renamed.p_renamed pVar, float f2) {
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "setImageResourceVertical90");
        aa_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_element_image_size);
        W_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_height);
        ab_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_width);
        X_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_gap);
        Y_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.vertical_filter_menu_elements_highlight_height);
        if (ac_renamed == 0) {
            ac_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_filter_menu_text_top_margin);
        }
        if (ax_renamed == 0) {
            ax_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_sides_padding);
        }
        if (ay_renamed == 0) {
            ay_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_updown_padding);
        }
        if (az_renamed == 0) {
            az_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_filter_row_offset);
        }
        if (java.lang.Float.compare(Z_renamed, 0.0f) == 0) {
            Z_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.menu_effect_grandtour_map_icon_negative_offset);
        }
        aj_renamed = android.graphics.BitmapFactory.decodeResource(resources, com.oplus.camera.R_renamed.drawable.filter_menu_selector);
        ak_renamed = a_renamed(resources, com.oplus.camera.R_renamed.drawable.filter_select_highlight_inverse);
        if (al_renamed == null) {
            al_renamed = android.graphics.BitmapFactory.decodeResource(resources, com.oplus.camera.R_renamed.drawable.filter_redpot);
        }
        if (am_renamed == null) {
            am_renamed = com.oplus.camera.util.Util.a_renamed(resources.getDrawable(com.oplus.camera.R_renamed.drawable.filter_grand_tour_recommend_icon, null));
        }
        if (an_renamed == null) {
            an_renamed = new android.text.TextPaint();
            ao_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
            ap_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency);
            aq_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
            ar_renamed = resources.getColor(com.oplus.camera.R_renamed.color.color_black_with_0_percent_transparency);
            as_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_value_text_shadow_radius);
            an_renamed.setColor(ao_renamed);
            an_renamed.setAntiAlias(true);
            an_renamed.setShadowLayer(as_renamed, 0.0f, 0.0f, aq_renamed);
            an_renamed.setTextSize(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_size));
        }
        ad_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_margin_top);
        ag_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_red_dot_margin_left);
        af_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_max_width);
        ah_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_element_margin_top);
        ai_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.makeup_item_highlight_stroke_width);
        ae_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_effect_filter_text_vertical_offset);
        if (au_renamed == null) {
            au_renamed = an_renamed.getFontMetricsInt();
        }
        aA_renamed = au_renamed.bottom - au_renamed.top;
        aB_renamed = au_renamed.ascent;
        an_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        an_renamed.getTextBounds("...", 0, 3, at_renamed);
        aC_renamed = at_renamed.width();
        av_renamed = W_renamed - (ax_renamed * 2);
        float fFloor = f2 > 1.0f ? (float) (java.lang.Math.floor((r5 - r1) / 2.0f) / (aa_renamed * f2)) : 0.0f;
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = new com.oplus.camera.ui.menu.levelcontrol.i_renamed(str);
        iVar.c_renamed((java.util.List<android.graphics.Bitmap>) null);
        iVar.b_renamed(list);
        iVar.a_renamed(aj_renamed);
        iVar.b_renamed(ak_renamed);
        iVar.f_renamed(i2);
        iVar.a_renamed(60.0f);
        iVar.b_renamed(ab_renamed);
        iVar.c_renamed(W_renamed);
        iVar.d_renamed(X_renamed);
        iVar.e_renamed(Y_renamed);
        iVar.f_renamed(fFloor);
        iVar.b_renamed(z2);
        iVar.c_renamed(z3);
        iVar.e_renamed(true);
        iVar.g_renamed(ah_renamed);
        a_renamed(resources, iVar, list, i3, z2, z3, (int) X_renamed, (int) ab_renamed, (int) W_renamed, f2);
        pVar.a_renamed(iVar);
    }

    public static void y_renamed() {
        aa_renamed = 0;
        Y_renamed = 0.0f;
        ac_renamed = 0;
        ax_renamed = 0;
        ay_renamed = 0;
        az_renamed = 0;
        au_renamed = null;
    }

    public static void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, int i2, int i3) {
        if (iVar == null) {
            return;
        }
        float f2 = (i2 * 1.0f) / i3;
        iVar.f_renamed((float) (java.lang.Math.floor((r9 - r8) / 2.0f) / (W_renamed * f2)));
        a_renamed(iVar.a_renamed(), iVar.n_renamed(), iVar.m_renamed(), (int) X_renamed, (int) ab_renamed, (int) W_renamed, f2);
    }

    private static boolean a_renamed(java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list) {
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "checkStaticFilter, filterModelList: " + list);
        java.util.Iterator<com.oplus.camera.ui.preview.a_renamed.k_renamed> it = list.iterator();
        while (it.hasNext()) {
            if (s_renamed.contains(it.next().f6908a)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a_renamed(int i2, com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "checkStaticFilterIndex, index: " + i2 + ", glModelParam: " + iVar);
        java.util.Iterator<java.lang.String> it = s_renamed.iterator();
        while (it.hasNext()) {
            if (i2 == iVar.a_renamed(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static void a_renamed(android.content.res.Resources resources, com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list, int i2, boolean z2, boolean z3, int i3, int i4, int i5, float f2) {
        java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list2 = list;
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "generateDrawingItemsHorizontal, isFrontCam: " + z2 + ", needRotate: " + z3);
        java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList();
        int size = list.size();
        boolean zA = a_renamed(list);
        iVar.a_renamed(zA);
        boolean z4 = z2 && 4 == aD_renamed;
        int i6 = 90;
        if (z3 || 90 == aE_renamed) {
            int i7 = size - 1;
            while (i7 >= 0) {
                int i8 = ((i6 != aE_renamed || z4) && !((270 == aE_renamed && z4) || iVar.o_renamed())) ? i7 : (size - i7) - 1;
                co_renamed.polarr.renderer.entities.DrawingItem drawingItem = new co_renamed.polarr.renderer.entities.DrawingItem();
                android.graphics.Rect rectA = a_renamed(i8, z3 || i6 == aE_renamed, z2, i3, i4, i5, f2);
                com.oplus.camera.ui.preview.a_renamed.k_renamed kVar = list2.get(i7);
                drawingItem.rect = rectA;
                a_renamed(resources, iVar, drawingItem, z2, i7, kVar.f6908a, i2, java.lang.Math.round(i5 * f2), i5, zA);
                copyOnWriteArrayList.add(drawingItem);
                i7--;
                list2 = list;
                i6 = i6;
            }
        } else {
            int i9 = 0;
            while (i9 < size) {
                co_renamed.polarr.renderer.entities.DrawingItem drawingItem2 = new co_renamed.polarr.renderer.entities.DrawingItem();
                android.graphics.Rect rectA2 = a_renamed(i9, z3, z2, i3, i4, i5, f2);
                com.oplus.camera.ui.preview.a_renamed.k_renamed kVar2 = list2.get(i9);
                drawingItem2.rect = rectA2;
                boolean z5 = zA;
                a_renamed(resources, iVar, drawingItem2, z2, i9, kVar2.f6908a, i2, java.lang.Math.round(i5 * f2), i5, z5);
                copyOnWriteArrayList.add(drawingItem2);
                i9++;
                zA = z5;
                size = size;
            }
        }
        iVar.a_renamed(copyOnWriteArrayList);
        iVar.a_renamed(copyOnWriteArrayList.size());
    }

    private static void b_renamed(android.content.res.Resources resources, com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list, int i2, boolean z2, boolean z3, int i3, int i4, int i5, float f2) {
        java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> list2 = list;
        com.oplus.camera.e_renamed.a_renamed("FilterHelper", "generateDrawingItemsVertical");
        java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList();
        int size = list.size();
        boolean zA = a_renamed(list);
        iVar.a_renamed(zA);
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                co_renamed.polarr.renderer.entities.DrawingItem drawingItem = new co_renamed.polarr.renderer.entities.DrawingItem();
                android.graphics.Rect rectA = a_renamed(i6, z3, z2, i3, i4, i5, f2);
                com.oplus.camera.ui.preview.a_renamed.k_renamed kVar = list2.get(i6);
                drawingItem.rect = rectA;
                a_renamed(resources, iVar, drawingItem, z2, i6, kVar.f6908a, i2, java.lang.Math.round(i5 * f2), i5, zA);
                copyOnWriteArrayList.add(drawingItem);
            }
        } else {
            int i7 = size - 1;
            int i8 = i7;
            while (i8 >= 0) {
                co_renamed.polarr.renderer.entities.DrawingItem drawingItem2 = new co_renamed.polarr.renderer.entities.DrawingItem();
                android.graphics.Rect rectA2 = a_renamed(i7 - i8, z3, z2, i3, i4, i5, f2);
                com.oplus.camera.ui.preview.a_renamed.k_renamed kVar2 = list2.get(i8);
                drawingItem2.rect = rectA2;
                a_renamed(resources, iVar, drawingItem2, z2, i8, kVar2.f6908a, i2, java.lang.Math.round(i5 * f2), i5, zA);
                copyOnWriteArrayList.add(drawingItem2);
                i8--;
                list2 = list;
            }
        }
        iVar.a_renamed(copyOnWriteArrayList);
        iVar.a_renamed(copyOnWriteArrayList.size());
    }

    private static android.graphics.Rect a_renamed(int i2, boolean z2, boolean z3, int i3, int i4, int i5, float f2) {
        int iRound;
        android.graphics.Rect rect;
        android.graphics.Rect rect2;
        int iRound2 = java.lang.Math.round((i5 - aa_renamed) / 2.0f);
        if (f2 < 1.0f) {
            iRound = java.lang.Math.round(aa_renamed / 2.0f);
        } else {
            iRound = java.lang.Math.round((aa_renamed * f2) / 2.0f);
        }
        if (1 == aD_renamed) {
            if (aE_renamed == 0) {
                int iRound3 = java.lang.Math.round(aa_renamed / 2.0f);
                if (z2) {
                    int i6 = (i2 * (i4 + i3)) + i3 + iRound3;
                    return new android.graphics.Rect(i6 - iRound, iRound2, i6 + iRound, i5 - iRound2);
                }
                int i7 = ((i2 * (i3 + i4)) + i4) - iRound3;
                return new android.graphics.Rect(i7 - iRound, iRound2, i7 + iRound, i5 - iRound2);
            }
            if (z2) {
                int iRound4 = (i4 - (f2 < 1.0f ? aa_renamed : java.lang.Math.round(aa_renamed * f2))) / 2;
                int i8 = aa_renamed;
                int i9 = ((i2 * (i3 + i5)) + i5) - i8;
                rect2 = new android.graphics.Rect(iRound4, i9, i4 - iRound4, i8 + i9);
            } else {
                int iRound5 = (i4 - (f2 < 1.0f ? aa_renamed : java.lang.Math.round(aa_renamed * f2))) / 2;
                int i10 = (i2 * (i5 + i3)) + i3;
                rect2 = new android.graphics.Rect(iRound5, i10, i4 - iRound5, aa_renamed + i10);
            }
            return rect2;
        }
        int i11 = aE_renamed;
        if (i11 == 0) {
            int iRound6 = java.lang.Math.round(aa_renamed / 2.0f) + iRound2;
            int i12 = i5 + i3;
            int i13 = ((i2 + 1) * i12) - iRound2;
            if (z2) {
                return new android.graphics.Rect(iRound6 - iRound, (i2 * i12) + i3 + iRound2, iRound6 + iRound, i13);
            }
            if (aF_renamed) {
                int i14 = i4 - iRound6;
                return new android.graphics.Rect(i14 - iRound, (i2 * i12) + iRound2, i14 + iRound, i13 - i3);
            }
            int i15 = i4 - iRound6;
            return new android.graphics.Rect(i15 - iRound, (i2 * i12) + iRound2 + i3, i15 + iRound, i13);
        }
        if (90 == i11) {
            int iRound7 = java.lang.Math.round(aa_renamed / 2.0f);
            int i16 = ah_renamed;
            int i17 = ((i4 + i3) * i2) + iRound7 + i16;
            int i18 = i17 - iRound;
            int i19 = i17 + iRound;
            int i20 = aa_renamed;
            int i21 = (i5 - i16) - i20;
            int i22 = i20 + i21;
            if (z3) {
                i18 += i3;
                i19 += i3;
            }
            rect = new android.graphics.Rect(i18, i21, i19, i22);
        } else {
            int iRound8 = java.lang.Math.round(aa_renamed / 2.0f) + i3;
            int i23 = ah_renamed;
            int i24 = ((i4 + i3) * i2) + iRound8 + i23;
            int i25 = i24 - iRound;
            int i26 = i24 + iRound;
            int i27 = aa_renamed + i23;
            if (z3) {
                i25 -= i3;
                i26 -= i3;
            }
            rect = new android.graphics.Rect(i25, i23, i26, i27);
        }
        return rect;
    }

    public static int a_renamed(java.lang.String str, int i2) {
        java.util.List<java.lang.String> listA = e_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i2));
        if (str == null) {
            return -1;
        }
        return listA.indexOf(str);
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.DrawingItem drawingItem, java.lang.String str, boolean z2) {
        android.graphics.Rect rect = drawingItem.rect;
        drawingItem.overlayBitmap = null;
        drawingItem.overlayTop = rect.height() / 2;
        if (z2) {
            drawingItem.overlayLeft = ((rect.width() + rect.height()) / 2) - aw_renamed;
        } else {
            drawingItem.overlayLeft = ((rect.width() - rect.height()) / 2) + aw_renamed;
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:144:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:47:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a_renamed(android.content.res.Resources r14, com.oplus.camera.ui.menu.levelcontrol.i_renamed r15, co_renamed.polarr.renderer.entities.DrawingItem r16, boolean r17, int r18, java.lang.String r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(android.content.res.Resources, com.oplus.camera.ui.menu.levelcontrol.i_renamed, co_renamed.polarr.renderer.entities.DrawingItem, boolean, int, java.lang.String, int, int, int, boolean):void");
    }

    private static void a_renamed(java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, boolean z2, boolean z3, int i2, int i3, int i4, float f2) {
        if (list == null) {
            return;
        }
        int size = list.size();
        if (!z2) {
            for (int i5 = 0; i5 < size; i5++) {
                co_renamed.polarr.renderer.entities.DrawingItem drawingItem = list.get(i5);
                android.graphics.Rect rectA = a_renamed(i5, false, z3, i2, i3, i4, f2);
                drawingItem.rect = rectA;
                int iWidth = (rectA.width() - aa_renamed) / 2;
                if (drawingItem.overlayBitmap != null) {
                    drawingItem.overlayLeft = (iWidth - ac_renamed) - drawingItem.overlayBitmap.getWidth();
                }
                if (drawingItem.thumbBitmap != null) {
                    drawingItem.thumbBitmap = a_renamed(drawingItem.thumbBitmap, i3, i4);
                }
            }
            return;
        }
        int i6 = size - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            co_renamed.polarr.renderer.entities.DrawingItem drawingItem2 = list.get(i7);
            android.graphics.Rect rectA2 = a_renamed(i6 - i7, true, z3, i2, i3, i4, f2);
            drawingItem2.rect = rectA2;
            int iWidth2 = (rectA2.width() - aa_renamed) / 2;
            if (drawingItem2.overlayBitmap != null) {
                drawingItem2.overlayLeft = (rectA2.width() + ac_renamed) - iWidth2;
            }
            if (drawingItem2.thumbBitmap != null) {
                drawingItem2.thumbBitmap = a_renamed(drawingItem2.thumbBitmap, i3, i4);
            }
        }
    }

    public static java.lang.String b_renamed(int i2, int i3) {
        java.util.List<java.lang.String> listA = e_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i3));
        return (i2 < 0 || i2 > listA.size()) ? "" : listA.get(i2);
    }

    public static java.lang.String b_renamed(int i2) {
        return (i2 < 0 || i2 > f_renamed.f6903b.size()) ? "" : f_renamed.f6903b.get(i2);
    }

    public static java.lang.String c_renamed(int i2, int i3) {
        java.util.List<java.lang.String> listA = i_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i3));
        return (i2 < 0 || i2 > listA.size()) ? "" : listA.get(i2);
    }

    public static java.lang.String d_renamed(int i2, int i3) {
        java.util.List<java.lang.String> listA = j_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i3));
        return (i2 < 0 || i2 > listA.size()) ? "" : listA.get(i2);
    }

    public static int a_renamed(boolean z2) {
        return z2 ? H_renamed : G_renamed;
    }

    public static int b_renamed(boolean z2) {
        return z2 ? J_renamed : I_renamed;
    }

    public static java.lang.String e_renamed(int i2, int i3) {
        return (i2 < 0 || i2 > k_renamed.e_renamed.size() + (-1)) ? "" : k_renamed.e_renamed.get(i2);
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i2, int i3) {
        float f2 = i2 / i3;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i4 = (int) (height * f2);
        int i5 = ai_renamed / 2;
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(i4, height, android.graphics.Bitmap.Config.ARGB_8888);
        new android.graphics.Canvas(bitmapA).drawBitmap(bitmap, (android.graphics.Rect) null, new android.graphics.Rect(((i4 - width) - i5) / 2, 0, ((i4 + width) + i5) / 2, height), (android.graphics.Paint) null);
        return bitmapA;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:57:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:60:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed, int, int, boolean):android.graphics.Bitmap");
    }

    public static android.graphics.Bitmap a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, int i2, int i3, boolean z2, int i4) {
        an_renamed.setColor(z2 ? ap_renamed : ao_renamed);
        float f2 = 0.0f;
        an_renamed.setShadowLayer(as_renamed, 0.0f, 0.0f, z2 ? ar_renamed : aq_renamed);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i2, i3, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        boolean z3 = false;
        float height = 0.0f;
        for (com.oplus.camera.ui.preview.a_renamed.k_renamed kVar : iVar.b_renamed()) {
            java.lang.String str = kVar.f6909b;
            float fMeasureText = an_renamed.measureText(str);
            if (!z3) {
                z3 = true;
                android.graphics.Paint.FontMetrics fontMetrics = an_renamed.getFontMetrics();
                float f3 = fontMetrics.descent - fontMetrics.ascent;
                f2 = (f3 - fontMetrics.descent) + ad_renamed;
                height = (ad_renamed + (f3 / 2.0f)) - (al_renamed.getHeight() / 2.0f);
            }
            canvas.drawText(str, (ab_renamed - fMeasureText) / 2.0f, f2, an_renamed);
            if (kVar.f6910c) {
                canvas.drawBitmap(al_renamed, ((ab_renamed + fMeasureText) / 2.0f) + ag_renamed, height, (android.graphics.Paint) null);
            }
            int i5 = ae_renamed;
            f2 += i5;
            height += i5;
        }
        if (iVar.n_renamed()) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setScale(-1.0f, 1.0f);
            bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        }
        android.graphics.Bitmap bitmapCreateBitmap2 = bitmapCreateBitmap;
        if (90 == i4) {
            android.graphics.Matrix matrix2 = new android.graphics.Matrix();
            matrix2.setScale(1.0f, -1.0f);
            bitmapCreateBitmap2 = android.graphics.Bitmap.createBitmap(bitmapCreateBitmap2, 0, 0, bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight(), matrix2, true);
        }
        android.graphics.Bitmap bitmap = bitmapCreateBitmap2;
        if (270 != i4 || !iVar.m_renamed()) {
            return bitmap;
        }
        android.graphics.Matrix matrix3 = new android.graphics.Matrix();
        matrix3.setScale(-1.0f, 1.0f);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix3, true);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:59:0x01a9 A_renamed[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap b_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed r22, int r23, int r24, boolean r25, int r26) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed, int, int, boolean, int):android.graphics.Bitmap");
    }

    public static android.graphics.Bitmap b_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, int i2, int i3, boolean z2) {
        boolean z3;
        float f2;
        an_renamed.setColor(z2 ? ap_renamed : ao_renamed);
        float f3 = 0.0f;
        an_renamed.setShadowLayer(as_renamed, 0.0f, 0.0f, z2 ? ar_renamed : aq_renamed);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i2, i3, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        canvas.save();
        canvas.rotate(90.0f);
        canvas.translate(0.0f, -i2);
        boolean z4 = false;
        float height = 0.0f;
        float f4 = 0.0f;
        for (com.oplus.camera.ui.preview.a_renamed.k_renamed kVar : iVar.b_renamed()) {
            java.lang.String str = kVar.f6909b;
            float fMeasureText = an_renamed.measureText(str);
            int i4 = 1;
            if (z4) {
                float f5 = f3;
                z3 = z4;
                f2 = f5;
            } else {
                android.graphics.Paint.FontMetrics fontMetrics = an_renamed.getFontMetrics();
                float f6 = fontMetrics.descent - fontMetrics.ascent;
                f2 = (f6 - fontMetrics.descent) + ad_renamed;
                height = (ad_renamed + (f6 / 2.0f)) - (al_renamed.getHeight() / 2.0f);
                f4 = f6;
                z3 = true;
            }
            float f7 = (W_renamed - fMeasureText) / 2.0f;
            if (java.lang.Float.compare(fMeasureText, af_renamed) <= 0) {
                canvas.drawText(str, f7, f2, an_renamed);
            } else {
                while (i4 < str.length() && java.lang.Float.compare(an_renamed.measureText(str.substring(0, i4)), af_renamed) <= 0) {
                    i4++;
                }
                int i5 = i4 - 1;
                canvas.drawText(str.substring(0, i5), (W_renamed - an_renamed.measureText(str.substring(0, i5))) / 2.0f, f2, an_renamed);
                fMeasureText = an_renamed.measureText(str.substring(i5));
                canvas.drawText(str.substring(i5), (W_renamed - fMeasureText) / 2.0f, f2 + f4, an_renamed);
            }
            if (kVar.f6910c) {
                canvas.drawBitmap(al_renamed, ((W_renamed + fMeasureText) / 2.0f) + ag_renamed, height, (android.graphics.Paint) null);
            }
            int i6 = ae_renamed;
            height += i6;
            boolean z5 = z3;
            f3 = f2 + i6;
            z4 = z5;
        }
        if (iVar.n_renamed()) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setScale(-1.0f, 1.0f);
            bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        }
        canvas.restore();
        return bitmapCreateBitmap;
    }

    public static boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.i_renamed iVar, java.lang.String str, int i2) {
        return iVar.f6903b.contains(str) && iVar.d_renamed.size() > i2;
    }

    public static float z_renamed() {
        return aa_renamed;
    }

    public static float A_renamed() {
        return W_renamed;
    }

    public static float B_renamed() {
        return ab_renamed;
    }

    public static float C_renamed() {
        return X_renamed;
    }
}
