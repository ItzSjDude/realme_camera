package com.oplus.camera.statistics;

/* loaded from: classes2.dex */
public class CameraStatisticsUtil extends com.oplus.statistics.d_renamed {
    public static final java.lang.String AES_TOKEN = "token";
    public static final java.lang.String AE_AF_LOCK = "ae_af_lock";
    public static final java.lang.String AF_STATUS = "afStatus";
    public static final java.lang.String AI_CLASS_ONE = "ai_class_one";
    public static final java.lang.String AI_EXP_TIME = "ai_exp_time";
    public static final java.lang.String AI_ISO = "ai_iso";
    public static final java.lang.String AI_SCENE = "ai_scene";
    public static final java.lang.String AI_SCENE_OPEN = "ai_scene_open";
    public static final java.lang.String AVAILABLE_STORAGE = "available_storage";
    public static final java.lang.String BEAUTY3D_CHEEKBONE = "beauty3d_cheekbone_value";
    public static final java.lang.String BEAUTY3D_CHIN = "beauty3d_chin_value";
    public static final java.lang.String BEAUTY3D_CHOSE_STYLE = "beauty3d_chose_style";
    public static final java.lang.String BEAUTY3D_DELETE_CLICK = "beauty3d_delete_click";
    public static final java.lang.String BEAUTY3D_EYE = "beauty3d_eye_value";
    public static final java.lang.String BEAUTY3D_FIX_FACE = "beauty3d_fix_face_value";
    public static final java.lang.String BEAUTY3D_GOOSE = "beauty3d_style_goose";
    public static final java.lang.String BEAUTY3D_HIGH_NOSE = "beauty3d_high_nose_value";
    public static final java.lang.String BEAUTY3D_LOLITA = "beauty3d_style_lolita";
    public static final java.lang.String BEAUTY3D_MODE = "beauty3d_style_mode";
    public static final java.lang.String BEAUTY3D_NATURAL = "beauty3d_style_natural";
    public static final java.lang.String BEAUTY3D_SAVE_CLICK = "beauty3d_save_click";
    public static final java.lang.String BEAUTY3D_SCAN_CLICK = "beauty3d_scan_click";
    public static final java.lang.String BEAUTY3D_SCAN_TIME = "beauty3d_scan_time";
    public static final java.lang.String BEAUTY3D_SMALL_FACE = "beauty3d_small_face_value";
    public static final java.lang.String BEAUTY3D_SMALL_NOSE = "beauty3d_small_nose_value";
    public static final java.lang.String BEAUTY3D_START_EDIT_CLICK = "beauty3d_start_edit_click";
    public static final java.lang.String BEAUTY_FACE_COUNT = "beauty_face_count";
    public static final java.lang.String BETWEEN_CLICK_BUTTON_COST_TIME = "between_click_btn_cost_time";
    public static final java.lang.String CALLER_PACKAGE = "caller_package";
    public static final java.lang.String CAMERA_ENTER_TIME_GAP = "camera_enter_time_gap";
    public static final java.lang.String CAMERA_ID = "camera_id";
    public static final java.lang.String[] CUSTOM_BEAUTY_CLICK_NUMS = {"beauty_custom_exfoliating_click", "beauty_custom_thin_face_click", "beauty_custom_big_eye_click", "beauty_custom_thin_nasal_click", "beauty_custom_chin_click", "beauty_custom_little_face_click", "beauty_custom_makeup_click", "beauty_custom_3d_click"};
    public static final java.lang.String ENCODE_TYPE = "enc";
    public static final java.lang.String ENTRY_TYPE = "entry_type";
    public static final java.lang.String EVENT_BEAUTY3D = "beauty3d";
    public static final java.lang.String EVENT_CAPTURE = "portrait";
    public static final java.lang.String EVENT_ENTER = "enter";
    public static final java.lang.String EVENT_ENTER_STICKER = "enterSticker";
    public static final java.lang.String EVENT_EXIT = "exit";
    public static final java.lang.String EVENT_MENU_CLICK = "menuClick";
    public static final java.lang.String EVENT_RUS = "RUS";
    public static final java.lang.String EVENT_STICKER_DOWNLOAD = "sticker_download";
    public static final java.lang.String EVENT_VIDEO = "videoRecord";
    public static final java.lang.String EXIT_TO_GALLERY = "to_gallery";
    public static final java.lang.String FACE_BEAUTY_COMMON_SHOW = "face_beauty_common_show";
    public static final java.lang.String FACE_BEAUTY_LEVEL = "smooth";
    public static final java.lang.String FACE_BEAUTY_RESET_CANCEL = "face_beauty_rest_cancel";
    public static final java.lang.String FACE_BEAUTY_RESET_OK = "face_beauty_rest_ok";
    public static final java.lang.String FACE_BEAUTY_RESET_SHOW = "face_beauty_rest_show";
    public static final java.lang.String FILTER_APP_LIST = "filterapplist";
    public static final java.lang.String FILTER_MENU_STATE = "filter_menu_state";
    public static final java.lang.String FILTER_TYPE = "filter_type";
    public static final java.lang.String FLASH = "menu_flash";
    public static final java.lang.String FLASH_STATUS = "flashMode";
    public static final java.lang.String FOCAL_LENGTH = "focal_length";
    public static final java.lang.String FOCUS_DISTANCE = "focus_distance";
    public static final java.lang.String FUNC_KEY_SETTING = "5";
    public static final java.lang.String GRADIENTER_STATUS = "gradienter_status";
    public static final java.lang.String HDR = "menu_hdr";
    public static final java.lang.String HIGH_RESOLUTION = "high_resolution";
    public static final java.lang.String IMAGE_HEIGHT = "height";
    public static final java.lang.String IMAGE_WIDTH = "width";
    public static final java.lang.String INTELLIGENT_BEAUTY = "intelligent_beauty";
    public static final java.lang.String KEY_FUNC_KEY_ID = "funcKey_id";
    public static final java.lang.String KEY_FUNC_KEY_ITEM = "funcKey_item";
    public static final java.lang.String KEY_FUNC_KEY_VALUE = "funcKey_value";
    private static final java.lang.String LOGTAG_ENTER = "201";
    private static final java.lang.String LOGTAG_PORTRAIT = "200";
    private static final java.lang.String LOGTAG_PREVIEW = "203";
    private static final java.lang.String LOGTAG_STICKER = "205";
    private static final java.lang.String LOGTAG_VIDEO = "202";
    public static final java.lang.String LUX = "lux";
    public static final java.lang.String MODE_PANEL_STATE = "mode_panel_state";
    public static final java.lang.String NIGHT_CLOSED_NUM = "close_night_num";
    public static final java.lang.String NIGHT_STATE = "night_state";
    public static final java.lang.String OMOJI_HUMAN_CLOTHING = "human_clothing";
    public static final java.lang.String OMOJI_HUMAN_DELETE = "human_delete";
    public static final java.lang.String OMOJI_HUMAN_ENTER = "human_enter";
    public static final java.lang.String OMOJI_HUMAN_FACE_STYLE = "human_face_style";
    public static final java.lang.String OMOJI_HUMAN_GENDER = "human_gender";
    public static final java.lang.String OMOJI_HUMAN_GENERATE_GIF = "human_generate_gif";
    public static final java.lang.String OMOJI_HUMAN_GLASSES = "human_glasses";
    public static final java.lang.String OMOJI_HUMAN_HAIR_COLOR = "human_hair_color";
    public static final java.lang.String OMOJI_HUMAN_HAIR_STYLE = "human_hair_style";
    public static final java.lang.String OMOJI_HUMAN_SAVE_GIF = "human_save_gif";
    public static final java.lang.String OMOJI_HUMAN_SKIN_COLOR = "human_skin_color";
    public static final java.lang.String PANORAMA_DIRECTION = "panorama_direction";
    public static final java.lang.String PI_FLAG = "pi_flag";
    public static final java.lang.String PORTRAIT_ASSISTANT_LINE = "assistant_line";
    public static final java.lang.String PORTRAIT_BLUR = "blur";
    public static final java.lang.String PORTRAIT_BOKEH_CODE = "bokeh_code";
    public static final java.lang.String PORTRAIT_BURST_COUNT = "burst_count";
    public static final java.lang.String PORTRAIT_CAPTURE_MODE = "capture_mode";
    public static final java.lang.String PORTRAIT_CAPTURE_TYPE = "capture_type";
    public static final java.lang.String PORTRAIT_CCT = "cct";
    public static final java.lang.String PORTRAIT_DELAYTIME = "delay_time";
    public static final java.lang.String PORTRAIT_EXP = "exp";
    public static final java.lang.String PORTRAIT_EXPOSURE_COMPENSATION = "ev_renamed";
    public static final java.lang.String PORTRAIT_FACE_COORDINATE = "face_coordinate";
    public static final java.lang.String PORTRAIT_FACE_COUNT = "face_count";
    public static final java.lang.String PORTRAIT_FACE_SIZE = "face_size";
    public static final java.lang.String PORTRAIT_FOCUS = "focus";
    public static final java.lang.String PORTRAIT_HALF_BODY = "half_body";
    public static final java.lang.String PORTRAIT_HDR_STATUS = "hdr";
    public static final java.lang.String PORTRAIT_ISO = "iso";
    public static final java.lang.String PORTRAIT_IS_SELF_LIGHT = "is_self_light";
    public static final java.lang.String PORTRAIT_LOCATION = "location";
    public static final java.lang.String PORTRAIT_MIRROR = "mirror";
    public static final java.lang.String PORTRAIT_MOVIE_MODE = "movie_mode";
    public static final java.lang.String PORTRAIT_NEW_STYLE_MENU_STATE = "portrait_new_style_menu_state";
    public static final java.lang.String PORTRAIT_NEW_STYLE_TYPE = "portrait_new_style_type";
    public static final java.lang.String PORTRAIT_ORIENTATION = "orientation";
    public static final java.lang.String PORTRAIT_PICSIZETYPE = "picSize_type";
    public static final java.lang.String PORTRAIT_PROFESSION_EXPOSURE_TIME = "profession_exposure_time";
    public static final java.lang.String PORTRAIT_PROFESSION_ISO = "profession_ISO";
    public static final java.lang.String PORTRAIT_RECORD_LOCATION = "record_location";
    public static final java.lang.String PORTRAIT_SD_CARD = "sd";
    public static final java.lang.String PORTRAIT_SELFIE_LIGHT_TRIGGER = "selfie_light_trigger";
    public static final java.lang.String PORTRAIT_TOUCH_EXPOSURE_COMPENSATION = "touch_ev";
    public static final java.lang.String PORTRAIT_TOUCH_XY = "touch_x_y";
    public static final java.lang.String PORTRAIT_VOLUME_FUNCTION = "volume_function";
    public static final java.lang.String PORTRAIT_WHITE_BALANCE = "wb";
    public static final java.lang.String PORTRAIT_ZOOM = "zoom";
    public static final java.lang.String PREVIEW_CAPTURE_COST_TIME = "preview_capture_cost_time";
    public static final java.lang.String RESUME_PAUSE_DURATION_TIME = "resume_pause_time";
    public static final java.lang.String RESUME_PAUSE_VIDEO_TIME = "resume_pause_video_time";
    public static final java.lang.String RUS_FILE_NAME = "fileName";
    public static final java.lang.String RUS_FILE_VERSION = "version";
    public static final java.lang.String SCREEN_BRIGHTNESS = "screen_brightness";
    public static final java.lang.String SECONDARY_CAMERA_SCENE_MODE = "secondary_cameraScene";
    public static final java.lang.String SELFIE_LIGHT = "selfie_light";
    public static final java.lang.String SHORTCUT_ITEM = "shortcut_item";
    public static final java.lang.String SHORTCUT_TYPE = "shortcut_type";
    public static final java.lang.String SLOGAN = "slogan";
    public static final java.lang.String SLOGAN_EXIST = "slogan_exist";
    public static final java.lang.String SLOGAN_TYPE = "slogan_type";
    public static final java.lang.String SOUND = "sound";
    public static final java.lang.String STICKER_DOWNLOAD_COST_TIME = "sticker_download_cost_time";
    public static final java.lang.String STICKER_DOWNLOAD_RESULT = "sticker_download_result";
    public static final java.lang.String STICKER_MENU_CATERGORY_CLICK = "sticker_menu_catergory_click";
    public static final java.lang.String STICKER_MENU_CATERGORY_FLING = "sticker_menu_catergory_fling";
    public static final java.lang.String STICKER_MENU_ITEM_SELECTED = "sticker_menu_item_selected";
    public static final java.lang.String STICKER_MENU_ITEM_UNSELECTED = "sticker_menu_item_unselected";
    public static final java.lang.String STICKER_MENU_ITEM_USETIME = "sticker_menu_item_usetime";
    public static final java.lang.String STICKER_MODE_CLICK_FILTER_INDEX = "sticker_mode_click_filter_index";
    public static final java.lang.String STICKER_MODE_CLICK_FILTER_MENU = "sticker_mode_click_filter_menu";
    public static final java.lang.String STICKER_MODE_CLICK_SMOOTH_LEVEL = "sticker_mode_click_smooth_level";
    public static final java.lang.String STICKER_MODE_CLICK_SMOOTH_MENU = "sticker_mode_click_smooth_menu";
    public static final java.lang.String STICKER_MODE_CLICK_STICKER_MENU = "sticker_mode_click_sticker_menu";
    public static final java.lang.String STICKER_MODE_SWITCH_CAMERA = "sticker_mode_switch_camera";
    public static final java.lang.String STICKER_MODE_USE_TIME = "sticker_mode_use_time";
    public static final java.lang.String STICKER_NAME = "sticker_name";
    public static final java.lang.String STICKER_NETWORK = "sticker_network";
    public static final java.lang.String STICKER_RECYCLEBIN_CLICK = "sticker_recyclebin_click";
    public static final java.lang.String STICKER_RECYCLEBIN_DELETEALL = "sticker_recyclebin_deleteall";
    public static final java.lang.String STICKER_RECYCLEBIN_ITEM_DELETE = "sticker_recyclebin_item_delete";
    public static final java.lang.String STICKER_TYPE = "sticker_type";
    public static final java.lang.String STICKER_UUID = "sticker_uuid";
    public static final java.lang.String SUPER_NIGHT_FLAG = "night_flag";
    private static java.lang.String TAG = "CameraStatisticsUtil";
    public static final java.lang.String ULTRA_WIDE_STATE = "ultra_wide_state";
    public static final java.lang.String USER_DATA = "ud";
    public static final java.lang.String VIDEO_ASD_TIMESTAMPS = "video_time_stamps";
    public static final java.lang.String VIDEO_CODEC = "video_codec";
    public static final java.lang.String VIDEO_FACE_BEAUTY = "video_face_beauty";
    public static final java.lang.String VIDEO_FPS = "video_fps";
    public static final java.lang.String VIDEO_MODE = "video_mode";
    public static final java.lang.String VIDEO_NOISE_FILTER = "video_noise_filter";
    public static final java.lang.String VIDEO_ORIENTATION = "video_orientation";
    public static final java.lang.String VIDEO_RECORDER_SOUND = "video_recorder_sound";
    public static final java.lang.String VIDEO_REC_MODE = "video_rec_mode";
    public static final java.lang.String VIDEO_TIME = "video_time";
    public static final java.lang.String VIVID_EFFECT = "vivid_effect";

    public static class Face {
        public java.lang.String D_renamed;
        public java.lang.String E_renamed;
        public java.lang.String F_renamed;
        public java.lang.String G_renamed;
    }

    public static class FaceCoordinate {
        public java.lang.String L1_renamed;
        public java.lang.String L2_renamed;
        public java.lang.String L3_renamed;
        public java.lang.String L4_renamed;
    }

    public static class FaceSize {
        public java.lang.String N1_renamed;
        public java.lang.String N2_renamed;
    }

    public static class MakerNote {
        public java.lang.String A_renamed;
        public java.lang.String B_renamed;
        public java.util.ArrayList<com.oplus.camera.statistics.CameraStatisticsUtil.Face> C_renamed;
        public java.lang.String H_renamed;
        public java.lang.String I_renamed;
        public java.lang.String J_renamed;
        public java.lang.String K_renamed;
        public java.util.ArrayList<com.oplus.camera.statistics.CameraStatisticsUtil.FaceCoordinate> L_renamed;
        public java.lang.String M_renamed;
        public java.util.ArrayList<com.oplus.camera.statistics.CameraStatisticsUtil.FaceSize> N_renamed;
        public java.lang.String O_renamed;
        public java.lang.String P_renamed;
        public java.lang.String PiFlag;
        public java.lang.String Q_renamed;
        public java.lang.String R_renamed;
        public java.lang.String S_renamed;
        public com.oplus.camera.statistics.CameraStatisticsUtil.TouchCenter T_renamed;
        public java.lang.String U_renamed;
        public java.lang.String V_renamed;
        public java.lang.String W_renamed;
        public java.util.ArrayList<java.lang.String> asdOut;
        public java.lang.String expTime;
        public java.lang.String iso;
        public java.lang.String nightFlag;
    }

    public static class TouchCenter {
        public java.lang.String T1_renamed;
        public java.lang.String T2_renamed;
    }

    public static void onDebug(android.content.Context context, boolean z_renamed) {
        com.oplus.statistics.d_renamed.onDebug(context, z_renamed);
    }

    public static void setSessionTimeOut(android.content.Context context, int i_renamed) {
        com.oplus.statistics.d_renamed.setSessionTimeOut(context, i_renamed);
    }

    public static java.lang.String format(java.lang.String str, java.lang.String str2) {
        return str + ":" + str2 + " ";
    }

    public static void onCommon(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if (com.oplus.camera.util.Util.ae_renamed()) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "onCommon, monkey is_renamed running do not report");
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> mapPutEventMap = putEventMap(str2, new java.util.HashMap());
        switch (str) {
            case "enter":
            case "exit":
            case "RUS":
                str3 = "201";
                break;
            case "videoRecord":
                str3 = "202";
                break;
            case "portrait":
                str3 = "200";
                break;
            case "sticker_download":
                str3 = LOGTAG_STICKER;
                break;
            case "menuClick":
            case "beauty3d":
            case "enterSticker":
                str3 = LOGTAG_PREVIEW;
                break;
            default:
                str3 = "";
                break;
        }
        com.oplus.statistics.d_renamed.onCommon(context, str3, str, mapPutEventMap);
    }

    private static java.util.HashMap<java.lang.String, java.lang.String> putEventMap(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        if (str != null) {
            for (java.lang.String str2 : str.split("\\s_renamed+")) {
                java.lang.String[] strArrSplit = str2.split(":");
                if (strArrSplit.length == 2 && !"".equals(strArrSplit[1])) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }
}
