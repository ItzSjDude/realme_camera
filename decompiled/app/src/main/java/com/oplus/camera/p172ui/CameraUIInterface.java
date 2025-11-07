package com.oplus.camera.p172ui;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p146gl.GLRootView;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.MicroscopeHintView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.p177a.ImageCallback;
import com.oplus.camera.timelapsepro.TimeLapseProMenuLayout;
import java.util.List;

/* loaded from: classes2.dex */
public interface CameraUIInterface {
    public static final String FLASH_TYPE_FLASH_LIGHT = "flash_light";
    public static final String FLASH_TYPE_INVERSE_LIGHT = "inverse_light";
    public static final String FLASH_TYPE_NONE = "none";
    public static final String FLASH_TYPE_SCREEN_LIGHT = "screen_light";
    public static final String KEY_10_BITS_HEIC_ENCODE = "pref_10bits_heic_encode_key";
    public static final String KEY_10_BITS_HEIC_ENCODE_BACKUP = "pref_10bits_heic_encode_backup_key";
    public static final String KEY_10_BITS_SUPPORT_IN_CURRENT_MODE = "pref_10bits_support_mode_key";
    public static final String KEY_3DPHOTO_FACEBEAUTY_LEVEL_MENU = "pref_3dphoto_facebeauty_level_menu";
    public static final String KEY_3D_PHOTO_FILTER_INDEX = "key_3d_photo_filter_index";
    public static final String KEY_ACCELEROMETER_USAGE = "key_accelerometer_usage";
    public static final String KEY_ADVANCE_SETTING_IMAGE = "pref_advance_setting_key";
    public static final String KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS = "key_ai_enhancement_closed_by_video_size_fps";
    public static final String KEY_AI_ENHANCEMENT_GUIDE_REMINDER_TIMES = "key_ai_enhancement_guide_reminder_times";
    public static final String KEY_AI_ENHANCEMENT_ON_VIDEO_SIZE = "key_ai_enhancement_on_video_size";
    public static final String KEY_AI_ENHANCEMENT_VIDEO = "key_ai_enhancement_video";
    public static final String KEY_AI_HIGH_PIXEL = "pref_camera_ai_high_pixel_key";
    public static final String KEY_AI_SCN = "pref_ai_scene_key";
    public static final String KEY_ASSISTANT_LINE = "pref_camera_assistant_line_key";
    public static final String KEY_ASSIST_GRADIENTER = "pref_assist_gradienter";
    public static final String KEY_AUTO_NIGHT_SCENCE = "pref_auto_night_scence_key";
    public static final String KEY_BEAUTY3D = "key_beauty3d";
    public static final String KEY_BEAUTY3D_MAIN_FACE_DETECT = "key_beauty3d_main_face_detect";
    public static final String KEY_BLUR_MODE = "pref_camera_blur_mode_key";
    public static final String KEY_BOTTOM_BLANK = "pref_bottom_blank";
    public static final String KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE = "key_bottom_guide_double_exposure";
    public static final String KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED = "key_bottom_guide_type_id_photo";
    public static final String KEY_BOTTOM_GUIDE_MAKEUP_TIPS_SHOWED = "key_bottom_guide_type_makeup";
    public static final String KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO = "key_bottom_guide_type_fast_video";
    public static final String KEY_BOTTOM_GUIDE_TYPE_NIGHT_TRIPOD = "key_bottom_guide_type_night_tripod";
    public static final String KEY_BUBBLE_MOVIE = "key_bubble_movie";
    public static final String KEY_BUBBLE_SHORT_VIDEO = "key_bubble_short_video";
    public static final String KEY_BUBBLE_STICKER = "key_bubble_sticker";
    public static final String KEY_BUBBLE_STREET_ROCKER_SHUTTER = "key_bubble_street_rocker_shutter";
    public static final String KEY_BUBBLE_TYPE_ADD_BEUTY3D = "key_bubble_type_add_beuty3d";
    public static final String KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO = "key_bubble_type_ai_enhancement_video";
    public static final String KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D = "key_bubble_type_custom_beuty3d";
    public static final String KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE = "key_bubble_type_custom_face_beauty_close";
    public static final String KEY_BUBBLE_TYPE_MULTI_VIDEO = "key_bubble_type_multi_video";
    public static final String KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE = "key_bubble_type_zoom_ultra_wide";
    public static final String KEY_BUILD_IMAGE_SETTING = "pref_build_image_setting_key";
    public static final String KEY_BURST_SHOT = "pref_burst_shot_key";
    public static final String KEY_CAMERA_AI_SCN_VERSION = "pref_camera_ai_scn_version_key";
    public static final String KEY_CAMERA_CODEC = "pref_camera_code_key";
    public static final String KEY_CAMERA_EXIT_TIME_STAMP = "pref_camera_exit_time_stamp_key";
    public static final String KEY_CAMERA_EXIT_TIME_STAMP_FROM_OTHER_APP = "pref_camera_exit_time_from_other_program_code";
    public static final String KEY_CAMERA_FINGERPRINT_SHUTTER = "pref_camera_fingerprint_shutter_key";
    public static final String KEY_CAMERA_GESTURE_SHUTTER = "pref_camera_gesture_shutter_key";
    public static final String KEY_CAMERA_GRID_VERSION = "pref_camera_grid_version_key";
    public static final String KEY_CAMERA_HDR_MODE = "pref_camera_hdr_mode_key";
    public static final String KEY_CAMERA_HDR_MODE_FROM_OTHER_APP = "pref_camera_hdr_mode_key_from_other_app";
    public static final String KEY_CAMERA_ID = "pref_camera_id_key";
    public static final String KEY_CAMERA_MODE = "pref_camera_mode_key";
    public static final String KEY_CAMERA_PID_HISTORY = "key_camera_pid_history";
    public static final String KEY_CAMERA_QUCIK_LAUNCH = "pref_camera_quick_launch_key";
    public static final String KEY_CAMERA_SLOGAN_VERSION = "pref_camera_slogan_version_key";
    public static final String KEY_CAMERA_SOUND = "pref_camera_sound_key";
    public static final String KEY_CAMERA_TAP_SHUTTER = "pref_camera_tap_shutter_key";
    public static final String KEY_CAMERA_TIMER_SHUTTER = "pref_camera_timer_shutter_key";
    public static final String KEY_CAMERA_TIMER_SHUTTER_FROM_OTHER_APP = "pref_camera_timer_shutter_key_from_other_app";
    public static final String KEY_COMMON_FACEBEAUTY_LEVEL_MENU = "pref_common_facebeauty_level_menu";
    public static final String KEY_COMMON_MAKEUP_TYPE = "pref_common_makeup_type";
    public static final String KEY_COMMON_VIDEO_MAKEUP_TYPE = "pref_common_video_makeup_type";
    public static final String KEY_CONTINUOUS_FOCUS = "pref_continuous_focus_key";
    public static final String KEY_COUNTDOWN_EFFECT_SHUTTER = "pref_camera_countdown_effect_key";
    public static final String KEY_CURRENT_STICKER_UUID = "pref_current_sticker_uuid";
    public static final String KEY_CURRENT_TEMPERATURE = "key_cur_temperature";
    public static final String KEY_DARK_ENVIRONMENT_TIPS = "key_dark_environment_tips";
    public static final String KEY_DISABLE_AI_ENHANCEMENT_VIDEO = "key_disable_ai_enhancement_video";
    public static final String KEY_DOUBLE_EXPOSURE_EFFECT_TYPE = "pref_double_exposure_effect_type";
    public static final String KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION = "key_double_exposure_guid_page_and_duration";
    public static final String KEY_DOUBLE_EXPOSURE_OPEN_COUNT = "pref_double_exposure_open_count";
    public static final String KEY_DOUBLE_EXPOSURE_TIPS = "pref_double_exposure_tips";
    public static final String KEY_DRAWER_ANCHOR_TIPS = "key_drawer_layout_anchor";
    public static final String KEY_DRAWER_SHOW_GUIDE_ANIMATION = "key_drawer_show_guide_animation";
    public static final String KEY_DUAL_CAMERA = "pref_dual_camera";
    public static final String KEY_ENTRY_BREENO_SCAN = "pref_entry_breeno_scan_key";
    public static final String KEY_EXPAND_POPBAR = "pref_expand_popbar_key";
    public static final String KEY_EXPLORER_CHIP_STATE = "key_explorer_chip_state";
    public static final String KEY_EXPORT_PERMISSION_REQUESTED = "key_export_permission_requested";
    public static final String KEY_EXPOSURE_FOCUS_SEPARATE_TIPS = "key_exposure_focus_separate_guide_animation";
    public static final String KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION = "pref_face_beauty_close_by_resolution";
    public static final String KEY_FACE_BEAUTY_LAST_TAB_INDEX = "key_face_beauty_last_tab_index";
    public static final String KEY_FACE_DETECTION = "pref_face_detection_key";
    public static final String KEY_FACE_RECTIFY = "pref_face_rectify_key";
    public static final String KEY_FACE_RECTIFY_SET_DEFAULT_VALUE = "pref_facerectify_set_default_value";
    public static final String KEY_FAST_VIDEO_SIZE = "pref_fast_video_size_key";
    public static final String KEY_FILM_MODE_EXPOSURE = "pref_film_mode_exposure";
    public static final String KEY_FILM_MODE_FOCUS = "pref_film_mode_focus";
    public static final String KEY_FILM_MODE_ISO = "pref_film_mode_iso";
    public static final String KEY_FILM_MODE_SHUTTER = "pref_film_mode_shutter";
    public static final String KEY_FILM_MODE_WHITE_BALANCE = "pref_film_mode_white_balance";
    public static final String KEY_FILM_SHOW_UI_DEFAULT = "pref_film_show_ui_default";
    public static final String KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE = "pref_film_video_eis_and_flash_enable";
    public static final String KEY_FILM_VIDEO_EIS_MENU = "pref_film_video_eis_menu";
    public static final String KEY_FILM_VIDEO_FILTER = "pref_film_video_filter";
    public static final String KEY_FILM_VIDEO_GUIDE_LINE = "pref_film_video_guide_line";
    public static final String KEY_FILM_VIDEO_HDR = "pref_film_video_hdr";
    public static final String KEY_FILM_VIDEO_HISTOGRAM = "pref_film_video_histogram";
    public static final String KEY_FILM_VIDEO_LOG = "pref_film_video_log";
    public static final String KEY_FILM_VIDEO_SWITCH_CAMERA = "pref_film_video_switch_camera_key";
    public static final String KEY_FILTER_ANC_INDEX = "key_filter_anc_index";
    public static final String KEY_FILTER_INDEX = "key_filter_index";
    public static final String KEY_FILTER_INDEX_OTHER_APP = "key_filter_index";
    public static final String KEY_FILTER_LIST_TYPE = "key_filter_list_type";
    public static final String KEY_FILTER_MENU = "pref_filter_menu";
    public static final String KEY_FILTER_MENU_UPDATED = "key_filter_menu_updated";
    public static final String KEY_FILTER_PREV_SELECTED_FILTERTYPE = "key_filter_prev_selected_filterType";
    public static final String KEY_FILTER_PREV_SELECTED_FILTERTYPE_OTHER_APP = "key_filter_prev_selected_filterType_other_app";
    public static final String KEY_FILTER_PROCESS = "pref_filter_process_key";
    public static final String KEY_FILTER_VERSION = "pref_filter_version_key";
    public static final String KEY_FIRST_BEAUTY_TIPS = "key_first_beauty_tip";
    public static final String KEY_FIRST_CHANGE_EIS = "key_first_change_eis";
    public static final String KEY_FISH_EYE_FILTER_INDEX = "key_fish_eye_filter_index";
    public static final String KEY_FISH_EYE_MODE = "pref_fish_eye_mode";
    public static final String KEY_FLASH_MODE = "pref_camera_flashmode_key";
    public static final String KEY_FLASH_MODE_FROM_OTHER_APP = "pref_camera_flashmode_key_from_other_app";
    public static final String KEY_FOCUS_PEAKING = "pref_focus_peaking_key";
    public static final String KEY_FRONT_CAMERA_FIRST_SWITCH = "key_front_camera_first_switch";
    public static final String KEY_FRONT_ZOOM_SWITCH = "pref_front_zoom_key";
    public static final String KEY_FUJI_FILTER_MENU = "pref_fuji_filter_menu";
    public static final String KEY_FULL_PIC_SIZE_TYPE = "key_full_pic_size_type";
    public static final String KEY_FULL_SCREEN_CENTER_SUPPORT = "key_full_screen_center_support";
    public static final String KEY_GRADIENTER = "pref_camera_gradienter_key";
    public static final String KEY_GROUPSHOT_FACEBEAUTY_LEVEL_MENU = "pref_groupshot_facebeauty_level_menu";
    public static final String KEY_HASSELBLAD_XPAN_FILTER_INDEX = "key_hasselblad_xpan_filter_index";
    public static final String KEY_HEADLINE_CONTROL_BY_MODE = "pref_headline_control_by_mode";
    public static final String KEY_HEIF_FORMAT = "pref_heif_format_key";
    public static final String KEY_HEIF_SUPPORT = "pref_heif_support_key";
    public static final String KEY_HELP_AND_FEEDBACK = "pref_help_and_feedback_key";
    public static final String KEY_HEVC_VIDEO_FORMAT = "pref_hevc_video_key";
    public static final String KEY_HIGH_PICTURE_PRO_MODE = "pref_high_picture_pro_mode_key";
    public static final String KEY_HIGH_PICTURE_SIZE = "key_high_picture_size";
    public static final String KEY_HIGH_RESOLUTION = "pref_high_resolution_key";
    public static final String KEY_HIGH_RESOLUTION_CANCEL_SNAPSHOT = "high_resolution_cancel_snapshot";
    public static final String KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN = "key_hyper_lapse_zoom_ultra_wide_open";
    public static final String KEY_IDPHOTO_FACEBEAUTY_LEVEL_MENU = "pref_idphoto_facebeauty_level_menu";
    public static final String KEY_INERTIAL_ZOOM = "pref_inertial_zoom_key";
    public static final String KEY_INTELLIGENT_HIGH_FRAME_SELECTED = "pref_intelligent_high_frame_selected_key";
    public static final String KEY_INTELLIGENT_HIGH_FRAME_USAGE = "key_intelligent_high_frame_usage_key";
    public static final String KEY_IS_ANDROID_S_DATA_MIGRATED = "pref_is_android_s_data_migrated";
    public static final String KEY_IS_CAPTURE_MODE = "key_is_capture_mode";
    public static final String KEY_IS_VIDEO_MODE = "key_is_video_mode";
    public static final String KEY_LASTED_VIDEO_CODEC = "pref_lasted_video_codec";
    public static final String KEY_LASTED_VIDEO_FPS = "pref_lasted_video_fps";
    public static final String KEY_LASTED_VIDEO_SAVE_STATUS = "pref_lasted_video_save_status";
    public static final String KEY_LASTED_VIDEO_SIZE = "pref_lasted_video_size";
    public static final String KEY_LAST_CAMERA_GESTURE_SHUTTER = "last_camera_gesture_shutter_key";
    public static final String KEY_LAST_CAMERA_TAP_SHUTTER = "last_camera_tap_shutter_key";
    public static final String KEY_LAST_MACRO_SWITCH = "pref_last_macro_switch";
    public static final String KEY_LENS_DIRTY_DETECTION = "pref_lens_dirty_detection_key";
    public static final String KEY_LINE_PHOTO = "pref_camera_line_photo";
    public static final String KEY_LINE_VIDEO = "pref_camera_line_video";
    public static final String KEY_LONG_EXPOSURE_FILTER_INDEX = "key_long_exposure_filter_index";
    public static final String KEY_LONG_EXPOSURE_SCENE_MENU_STATE = "pref_long_exposure_scene_menu_state";
    public static final String KEY_LONG_EXPOSURE_SCENE_TYPE = "pref_long_exposure_scene_type";
    public static final String KEY_LONG_PROCESS_SHUTTER_CHOICE = "pref_long_process_choice_key";
    public static final String KEY_MACRO_FILTER_INDEX = "key_macro_filter_index";
    public static final String KEY_MACRO_SWITCH = "pref_macro_switch";
    public static final String KEY_MAKEUP_LAST_CLOSE_INDEX = "pref_makeup_last_close_index";
    public static final String KEY_MANUAL_EXPOSURE = "pref_manual_exposure_key";
    public static final String KEY_MICROSCOPE_GUIDE_SHOW_NEED = "key_microscope_guide_show_need";
    public static final String KEY_MIRROR = "pref_mirror_key";
    public static final String KEY_MIRROR_SETTING = "pref_mirror_setting_key";
    public static final String KEY_MOVIE_FLASH_MODE = "pref_camera_film_mode_key";
    public static final String KEY_MULTI_CAMERA_SHOW_POSITION_STATE = "pref_multicamera_show_position_state_key";
    public static final String KEY_MULTI_CAMERA_TYPE_MENU = "key_multicamera_type_menu_key";
    public static final String KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM = "key_multicamera_type_menu_need_zoom_key";
    public static final String KEY_MULTI_CAMERA_TYPE_SELECTED = "pref_multicamera_type_selected_key";
    public static final String KEY_MULTI_VIDEO_FACEBEAUTY_LEVEL_MENU = "pref_multi_video_facebeauty_level_menu";
    public static final String KEY_NEED_INTERCEPT_TOUCH = "key_need_intercept_touch";
    public static final String KEY_NIGHT_FACEBEAUTY_LEVEL_MENU = "pref_night_facebeauty_level_menu";
    public static final String KEY_NIGHT_FILTER_INDEX = "key_night_filter_index";
    public static final String KEY_NIGHT_FILTER_MENU = "pref_night_filter_menu";
    public static final String KEY_NIGHT_MAKEUP_TYPE = "pref_night_makeup_type";
    public static final String KEY_NIGHT_PRO_MODE = "pref_night_pro_mode_key";
    public static final String KEY_NIGHT_STARBURST_MODE = "pref_night_starburst_mode";
    public static final String KEY_NIGHT_TRIPOD_MODE = "pref_night_tripod_mode_key";
    public static final String KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE = "key_night_tripod_zoom_hide_ultra_wide";
    public static final String KEY_NONE_SAT_TELE_ANGLE = "pref_none_sat_tele_angle_key";
    public static final String KEY_NONE_SAT_ULTRA_WIDE_ANGLE = "pref_none_sat_ultra_wide_angle_key";
    public static final String KEY_OLD_VIDEO_FPS = "pref_old_video_fps";
    public static final String KEY_OLD_VIDEO_SIZE = "pref_old_video_size";
    public static final String KEY_OLD_VIDEO_STATUS_FOR_SPECIAL = "pref_old_video_status_for_special";
    public static final String KEY_OMOJI_PROCESS = "pref_omoji_process_key";
    public static final String KEY_OUT_PREVIEW_GUIDE = "key_out_preview_guide";
    public static final String KEY_PARAMETER_SAVING = "pref_parameter_saving";
    public static final String KEY_PERMISSION_DIALOG_DISPLAYED = "key_permission_dialog_displayed";
    public static final String KEY_PHOTO_CODEC = "pref_photo_codec_key";
    public static final String KEY_PHOTO_CODEC_BACKUP = "pref_photo_codec_backup_key";
    public static final String KEY_PHOTO_CODEC_CLICK = "pref_photo_codec_click_key";
    public static final String KEY_PHOTO_HIGH_RESOLUTION = "pref_camera_high_resolution_key";
    public static final String KEY_PHOTO_MONO_FILTER = "key_photo_mode_filter";
    public static final String KEY_PHOTO_RATIO = "pref_camera_photo_ratio_key";
    public static final String KEY_PHOTO_RATIO_FROM_OTHER_APP = "pref_camera_photo_ratio_key_from_other_app";
    public static final String KEY_PI = "pref_camera_pi_mode_key";
    public static final String KEY_PI_AI = "pref_camera_pi_ai_mode_key";
    public static final String KEY_PLATFORM_SLOW_VIDEO_FPS = "pref_platform_slow_video_fps_key";
    public static final String KEY_PORTRAIT_BLUR_MENU = "pref_portrait_blur_menu";
    public static final String KEY_PORTRAIT_BLUR_MENU_INDEX = "pref_portrait_blur_menu_index";
    public static final String KEY_PORTRAIT_FACEBEAUTY_LEVEL_MENU = "pref_portrait_facebeauty_level_menu";
    public static final String KEY_PORTRAIT_HALF_BODY = "pref_portrait_half_body_key";
    public static final String KEY_PORTRAIT_HALF_BODY_REMOSAIC = "pref_portrait_half_body_remosaic_key";
    public static final String KEY_PORTRAIT_MAKEUP_TYPE = "pref_portrait_makeup_type";
    public static final String KEY_PORTRAIT_NEW_STYLE_INDEX = "key_portrait_new_style_index";
    public static final String KEY_PORTRAIT_NEW_STYLE_MENU = "pref_portrait_new_style_menu";
    public static final String KEY_PRO_HISTOGRAM = "pref_pro_histogram_key";
    public static final String KEY_QR_CODE = "pref_qr_code_key";
    public static final String KEY_QUICK_VIDEO = "key_quick_video";
    public static final String KEY_RAW = "pref_raw_key";
    public static final String KEY_RAW_CONTROL = "pref_raw_control_key";
    public static final String KEY_RECORD_LOCATION = "pref_camera_recordlocation_key";
    public static final String KEY_REFERENCE_LINE = "pref_camera_reference_line";
    public static final String KEY_REMOSAIC = "key_remosaic";
    public static final String KEY_REPORT_PERMISSION_TIME_STAMP = "pref_report_permission_timestamp";
    public static final String KEY_RESTORE_HIGH_PICTURE_PRO_PARAMS = "pref_restore_high_picture_pro_params";
    public static final String KEY_RESTORE_LONG_EXPOSURE_PARAMS = "pref_restore_long_exposure_params";
    public static final String KEY_RESTORE_NIGHT_PRO_PARAMS = "pref_restore_night_pro_params";
    public static final String KEY_RESTORE_PROFESSIONAL_PARAMS = "pref_restore_professional_params";
    public static final String KEY_RESTORE_TIMELAPSE_PRO_PARAMS = "pref_restore_time_lapse_pro_params";
    public static final String KEY_RESTORE_TYPE = "pref_restore_key";
    public static final String KEY_SAVE_JPG_AFTER_PAUSE = "pref_save_jpg_after_pause_key";
    public static final String KEY_SETTING = "pref_setting_key";
    public static final String KEY_SETTING_ABOUT = "pref_about_key";
    public static final String KEY_SETTING_MENU = "key_setting_menu";
    public static final String KEY_SETTING_SUPPORT = "key_setting_support";
    public static final String KEY_SHARE_AND_MARK = "pref_share_and_edit_key";
    public static final String KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND = "share_edit_video_show_expand";
    public static final String KEY_SHORT_VIDEO = "key_short_video";
    public static final String KEY_SHOULD_REOPEN_AI_ENHANCEMENT_VIDEO = "key_should_reopen_ai_enhancement_video";
    public static final String KEY_SHOW_PULL_DOWN_TIP = "key_show_pull_down_tip";
    public static final String KEY_SHUTTER_HELP = "pref_shutter_help_key";
    public static final String KEY_SHUTTER_SETTING_GUIDE = "pref_shutter_setting_guide_key";
    public static final String KEY_SLOGAN_CUSTOMIZE = "pref_slogan_customize_key";
    public static final String KEY_SLOGAN_OWNER = "pref_slogan_owner_key";
    public static final String KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU = "key_slow_video_frame_seek_bar_menu_key";
    public static final String KEY_SLOW_VIDEO_REAR_FPS = "pref_slow_video_rear_fps_key";
    public static final String KEY_SLOW_VIDEO_SIZE = "pref_slow_video_size_key";
    public static final String KEY_START_PREIVEW_SYNC = "pref_sstart_preview_sync";
    public static final String KEY_STAR_VIDEO_RECORD_TOTAL_TIME = "pref_star_video_record_total_time_key";
    public static final String KEY_STICKER_FACEBEAUTY_LEVEL_MENU = "pref_sticker_facebeauty_level_menu";
    public static final String KEY_STICKER_FILTER_INDEX = "key_sticker_filter_index";
    public static final String KEY_STICKER_PROCESS = "pref_sticker_process_key";
    public static final String KEY_STORAGE_PLACE = "pref_camera_storage_key";
    public static final String KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE = "key_ai_enhancement_off_video_size";
    public static final String KEY_STREET_FILTER_INDEX = "key_street_filter_index";
    public static final String KEY_STREET_FILTER_MENU = "pref_street_filter_menu";
    public static final String KEY_STREET_FIX_FOCUS_CONTROL = "pref_street_fix_focus_control_key";
    public static final String KEY_STREET_FIX_FOCUS_MANUAL_STATE = "pref_fix_focus_manual_state";
    public static final String KEY_STREET_FIX_FOCUS_VALUE = "pref_fix_focus_value";
    public static final String KEY_STREET_LONG_EXPOSURE_MENU = "pref_street_long_exposure_menu";
    public static final String KEY_STREET_TRACE_GUIDE = "pref_street_trace_guide";
    public static final String KEY_SUB_HOLD_SETTING = "pref_sub_hold_key";
    public static final String KEY_SUB_SETTING = "pref_subsetting_key";
    public static final String KEY_SUPER_CLEAR_PORTRAIT = "pref_super_clear_portrait";
    public static final String KEY_SUPER_EIS_WIDE = "pref_super_eis_wide_key";
    public static final String KEY_SUPER_EIS_WIDE_TIPS = "key_first_super_eis_wide_tip";
    public static final String KEY_SUPER_RAW_CONTROL = "pref_super_raw_control_key";
    public static final String KEY_SUPOORT_FOCUS_OUT_OF_RANGE = "support_focus_out_of_range";
    public static final String KEY_SUPPORT_BOKEH_HDR = "key_support_bokeh_hdr";
    public static final String KEY_SUPPORT_CAPTURE_PREVIEW = "pref_support_capture_preview";
    public static final String KEY_SUPPORT_DECREASE_BRIGHTNESS = "key_support_decrease_brightness";
    public static final String KEY_SUPPORT_EXPOSURE_FOCUS_SEPARATE = "pref_exposure_focus_separate_key";
    public static final String KEY_SUPPORT_FOVC = "key_support_fovc";
    public static final String KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION = "key_support_front_face_point_animation";
    public static final String KEY_SUPPORT_GIMBAL_CHANGE = "key_support_gimbal_change";
    public static final String KEY_SUPPORT_GRAND_TOUR_FILTERS = "key_support_grand_tour_fitlers";
    public static final String KEY_SUPPORT_INSENSOR_ZOOM_20X = "key_support_insensor_zoom_20x";
    public static final String KEY_SUPPORT_MAKEUP = "key_support_makeup";
    public static final String KEY_SUPPORT_MODE_CHANGE_VIBRATE = "key_support_mode_change_vibrate";
    public static final String KEY_SUPPORT_MULTI_FOCUS = "key_suppport_multi_focus";
    public static final String KEY_SUPPORT_NIGHT_PROCESS = "pref_support_night_process";
    public static final String KEY_SUPPORT_NO_FACE_FORBID_BEAUTY = "key_support_no_face_forbid_beauty";
    public static final String KEY_SUPPORT_POST_VIEW = "pref_support_post_view";
    public static final String KEY_SUPPORT_RAW_POST_PROCESS = "pref_support_raw_post_process";
    public static final String KEY_SUPPORT_RECORDING_CAPTURE = "pref_support_recording_capture";
    public static final String KEY_SUPPORT_ROTATE_HINT_VIEW = "pref_support_rotate_hint_view";
    public static final String KEY_SUPPORT_SHARE_EDIT_THUMB = "key_support_share_edit_thumb";
    public static final String KEY_SUPPORT_SHOW_DIM_HINT = "key_support_show_dim_hint";
    public static final String KEY_SUPPORT_SHOW_NO_FACE = "key_support_show_no_face";
    public static final String KEY_SUPPORT_SHOW_SOLOOP = "key_support_show_soloop";
    public static final String KEY_SUPPORT_SLOW_VIDEO_H265 = "key_support_slow_video_h265";
    public static final String KEY_SUPPORT_SUPER_EIS_WIDE_MENU = "key_support_super_eis_wide_menu";
    public static final String KEY_SUPPORT_SWITCH_CAMERA = "pref_support_switch_camera";
    public static final String KEY_SUPPORT_THUMBNAIL = "pref_support_thumbnail";
    public static final String KEY_SUPPORT_UPDATE_THUMBNAIL_USER_PICTURE = "key_support_update_thumbnail_user_picture";
    public static final String KEY_SUPPORT_VIDEO_COUNT_DOWN = "support_video_count_down";
    public static final String KEY_SUPPORT_VIDEO_RECORDER = "key_support_video_recorder";
    public static final String KEY_SUPPORT_VIDEO_THUMBNAIL_SIMULTANEOUS = "key_support_video_thumbnail_simultaneous";
    public static final String KEY_SUPPORT_ZOOM_REINIT = "pref_support_zoom_reinit";
    public static final String KEY_SUPPORT_ZSL = "key_support_zsl";
    public static final String KEY_SWITCH_CAMERA = "pref_switch_camera_key";
    public static final String KEY_SWITCH_CAMERA_BAR = "pref_switch_camera_bar_key";
    public static final String KEY_SWITCH_DUAL_CAMERA = "pref_switch_dual_camera_key";
    public static final String KEY_SWITCH_FRONT_DUAL_CAMERA = "pref_switch_front_dual_camera_key";
    public static final String KEY_TELE_SMALL_PREVIEW = "pref_tele_small_preview_key";
    public static final String KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING = "key_temperature_control_stop_video_recording";
    public static final String KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED = "pref_temp_intelligent_high_frame_selected_key";
    public static final String KEY_TEXTURE_UI = "pref_texture_ui_key";
    public static final String KEY_TILT_SHIFT_BLUR_MENU = "pref_tilt_shift_blur_menu";
    public static final String KEY_TILT_SHIFT_BLUR_MENU_INDEX = "pref_tilt_shift_blur_menu_index";
    public static final String KEY_TILT_SHIFT_FILTER_INDEX = "key_tilt_shift_filter_index";
    public static final String KEY_TILT_SHIFT_TYPE = "pref_tilt_shift_type";
    public static final String KEY_TIMELAPSE_PRO_TEMPLATE_SELECT = "key_timelapse_pro_template_select";
    public static final String KEY_TIMELAPSE_RECORD_TOTAL_TIME = "pref_timelapse_pro_record_total_time_key";
    public static final String KEY_TIME_LAPSE = "pref_time_lapse_key";
    public static final String KEY_TIME_LAPSE_PRO = "key_support_time_lapse_pro";
    public static final String KEY_TIME_LAPSE_PRO_RECORDING_PREVIEW_FREEZE = "key_support_time_lapse_pro_recording_preview_freeze";
    public static final String KEY_TIME_LAPSE_PRO_VIDEO_FRAMES = "pref_camera_time_lapse_pro_video_frames_key";
    public static final String KEY_TIME_LAPSE_PRO_VIDEO_SPEED = "pref_camera_time_lapse_pro_speed_key";
    public static final String KEY_TIME_LAPSE_RATE = "pref_camera_time_lapse_rate_key";
    public static final String KEY_TOF_DUAL_CAMERA = "pref_tof_dual_camera";
    public static final String KEY_TORCH_MODE = "pref_camera_torch_mode_key";
    public static final String KEY_TORCH_MODE_FROM_OTHER_APP = "pref_camera_torch_mode_key_from_other_app";
    public static final String KEY_TRACK_FOCUS = "pref_track_focus_key";
    public static final String KEY_ULTRA_HIGH_RESOLUTION_FILTER_INDEX = "key_ultra_high_resolution_filter_index";
    public static final String KEY_ULTRA_NIGHT_VIDEO = "key_ultra_night_video";
    public static final String KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE = "pref_ultra_wide_high_picture_size_key";
    public static final String KEY_UPDATE_SETTING_BAR_BACKGROUND = "pref_update_setting_background_bar_key";
    public static final String KEY_VIDEO_BLUR_MENU = "pref_video_blur_menu";
    public static final String KEY_VIDEO_BLUR_MENU_INDEX = "pref_video_blur_menu_index";
    public static final String KEY_VIDEO_BLUR_MENU_STATE = "pref_video_blur_menu_state";
    public static final String KEY_VIDEO_CLIP_SAVE_PATH = "PREF_VIDEO_CLIP_SAVE_PATH";
    public static final String KEY_VIDEO_CODEC = "pref_video_codec_key";
    public static final String KEY_VIDEO_CODEC_BACKUP = "pref_video_codec_backup_key";
    public static final String KEY_VIDEO_DURATION_LIMIT = "key_video_duration_limit";
    public static final String KEY_VIDEO_EIS = "pref_video_eis";
    public static final String KEY_VIDEO_FACEBEAUTY_LEVEL_MENU = "pref_video_facebeauty_level_menu";
    public static final String KEY_VIDEO_FACEBEAUTY_LEVEL_MENU_BACKUP = "pref_video_facebeauty_level_menu_backup";
    public static final String KEY_VIDEO_FILTER_INDEX = "key_video_filter_index";
    public static final String KEY_VIDEO_FILTER_MENU = "pref_video_filter_menu";
    public static final String KEY_VIDEO_FLASH_MODE = "pref_camera_videoflashmode_key";
    public static final String KEY_VIDEO_FPS = "pref_video_fps_key";
    public static final String KEY_VIDEO_HDR = "key_video_hdr";
    public static final String KEY_VIDEO_HIGH_FPS = "key_support_video_high_fps";
    public static final String KEY_VIDEO_HYPER_LAPSE_FOCUS_FIRST_HINTS = "key_video_hyper_lapse_focus_first_hints";
    public static final String KEY_VIDEO_HYPER_LAPSE_MENU = "pref_video_hyper_lapse_key";
    public static final String KEY_VIDEO_NOISE_FILTER = "pref_video_noise_filter_key";
    public static final String KEY_VIDEO_RATIO_FPS = "pref_video_ratio_key";
    public static final String KEY_VIDEO_SELL_EIS = "pref_video_sell_eis";
    public static final String KEY_VIDEO_SIZE = "pref_video_size_key";
    public static final String KEY_VIDEO_SOUND_EFFECT_KEY = "pref_video_sound_effect_key";
    public static final String KEY_VIDEO_SOUND_FRONT = "pref_sound_types_key_front";
    public static final String KEY_VIDEO_SOUND_KEY = "pref_video_sound_key";
    public static final String KEY_VIDEO_SOUND_MODE = "pref_sound_mode_types_key";
    public static final String KEY_VIDEO_SOUND_REAR = "pref_sound_types_key_rear";
    public static final String KEY_VIDEO_SUPER_EIS_MENU = "pref_video_super_eis_key";
    public static final String KEY_VIVID_EFFECT = "pref_camera_vivid_effect_key";
    public static final String KEY_VOLUME_KEY_FUNCTION = "pref_volume_key_function_key";
    public static final String KEY_WATERMARK_DEVICE = "pref_watermark_device";
    public static final String KEY_WATERMARK_SETTING_IMAGE = "pref_watermark_setting_key";
    public static final String KEY_XPAN_EXPOSURE = "pref_hasselblad_xpan_exposure_key";
    public static final String KEY_XPAN_SWITCH_CAMERA_BAR = "pref_hasselblad_xpan_switch_camera_bar_key";
    public static final String KEY_ZOOM = "pref_zoom_key";
    public static final String KEY_ZOOM_FROM_OTHER_APP = "pref_zoom_from_other_program_code";
    public static final String KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT = "key_zoom_wide_angle_open_default";
    public static final String PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED = "pref_face_beauty_filter_recommend_icon_clicked";
    public static final String PRE_FACE_BEAUTY_ICON_RECEOMMEND_CLICKED = "pref_face_beauty_recommend_icon_clicked";
    public static final String PRE_KEY_LEGACY_WATERMARK_TIME = "pref_watermark_time";
    public static final String PRE_KEY_WATERMARK_DATE_AND_TIME = "pref_watermark_date_and_time";
    public static final String PRE_KEY_WATERMARK_LOCATION = "pref_watermark_location";
    public static final String PRE_KEY_WATERMARK_PHONE = "pref_watermark_phone";
    public static final String PRE_KEY_WATERMARK_VISUAL_AUTHOR = "pref_watermark_author_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO = "pref_watermark_display_info_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN = "pref_watermark_first_open_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_FUNCTION = "pref_watermark_function_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION = "pref_watermark_makeup_function_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_MAKEUP_PREVIEW = "pref_watermark_makeup_preview_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_POSITION = "pref_watermark_position_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_PREVIEW = "pref_watermark_preview_key";
    public static final String PRE_KEY_WATERMARK_VISUAL_SIZE = "pref_watermark_size_key";
    public static final String PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED = "pref_recommended_menu_filter_icon_clicked_key";
    public static final String SHOW_ARROW_ANIMATION = "show_arrow_animation";
    public static final String[] KEY_STICKER_CUSTOM_FACEBEAUTY = {"key_beauty_custom_sticker_exfoliating", "key_beauty_custom_sticker_thin_face", "key_beauty_custom_sticker_big_eye", "key_beauty_custom_sticker_thin_nasal", "key_beauty_custom_sticker_chin", "key_beauty_custom_sticker_little_face", "key_beauty_custom_sticker_makeup", "key_beauty_custom_sticker_3d"};
    public static final String[] KEY_COMMON_CUSTOM_BEAUTY = {"key_beauty_custom_common_exfoliating", "key_beauty_custom_common_thin_face", "key_beauty_custom_common_big_eye", "key_beauty_custom_common_thin_nasal", "key_beauty_custom_common_chin", "key_beauty_custom_common_little_face", "key_beauty_custom_common_makeup", "key_beauty_custom_common_3d"};
    public static final String[] KEY_PORTRAIT_CUSTOM_BEAUTY = {"key_beauty_custom_portrait_exfoliating", "key_beauty_custom_portrait_thin_face", "key_beauty_custom_portrait_big_eye", "key_beauty_custom_portrait_thin_nasal", "key_beauty_custom_portrait_chin", "key_beauty_custom_portrait_little_face", "key_beauty_custom_portrait_makeup", "key_beauty_custom_portrait_3d"};
    public static final String[] KEY_VIDEO_CUSTOM_BEAUTY = {"key_beauty_custom_video_exfoliating", "key_beauty_custom_video_thin_face", "key_beauty_custom_video_big_eye", "key_beauty_custom_video_thin_nasal", "key_beauty_custom_video_chin", "key_beauty_custom_video_little_face", "key_beauty_custom_video_makeup", "key_beauty_custom_video_3d"};
    public static final String[] KEY_NIGHT_CUSTOM_BEAUTY = {"key_beauty_custom_night_exfoliating", "key_beauty_custom_night_thin_face", "key_beauty_custom_night_big_eye", "key_beauty_custom_night_thin_nasal", "key_beauty_custom_night_chin", "key_beauty_custom_night_little_face", "key_beauty_custom_night_makeup", "key_beauty_custom_night_3d"};
    public static final String[] KEY_GROUPSHOT_CUSTOM_BEAUTY = {"key_beauty_custom_night_exfoliating", "key_beauty_custom_night_thin_face", "key_beauty_custom_night_big_eye", "key_beauty_custom_night_thin_nasal", "key_beauty_custom_night_chin", "key_beauty_custom_night_little_face", "key_beauty_custom_night_makeup", "key_beauty_custom_night_3d"};
    public static final String[] KEY_MULTI_VIDEO_CUSTOM_BEAUTY = {"key_beauty_custom_multi_video_exfoliating", "key_beauty_custom_multi_video_thin_face", "key_beauty_custom_multi_video_big_eye", "key_beauty_custom_multi_video_thin_nasal", "key_beauty_custom_multi_video_chin", "key_beauty_custom_multi_video_little_face", "key_beauty_custom_multi_video_makeup", "key_beauty_custom_multi_video_3d"};
    public static final String[] KEY_IDPHOTO_CUSTOM_BEAUTY = {"key_beauty_custom_idphoto_exfoliating", "key_beauty_custom_idphoto_thin_face", "key_beauty_custom_idphoto_big_eye", "key_beauty_custom_idphoto_thin_nasal", "key_beauty_custom_idphoto_chin", "key_beauty_custom_idphoto_little_face", "key_beauty_custom_idphoto_makeup", "key_beauty_custom_idphoto_3d"};
    public static final String[] KEY_TIMELAPSE_PRO_TEMPLATES = {"key_timelapse_pro_no_template", "key_timelapse_pro_car_template", "key_timelapse_pro_star_template", "key_timelapse_pro_cloud_template"};

    /* renamed from: A */
    void mo18022A(boolean z);

    /* renamed from: A */
    boolean mo18023A();

    /* renamed from: B */
    void mo18024B(boolean z);

    /* renamed from: B */
    boolean mo18025B();

    /* renamed from: C */
    void mo18026C();

    /* renamed from: C */
    void mo18027C(boolean z);

    /* renamed from: D */
    void mo18028D();

    /* renamed from: D */
    void mo18029D(boolean z);

    /* renamed from: E */
    void mo18030E();

    /* renamed from: E */
    void mo18031E(boolean z);

    /* renamed from: F */
    void mo18032F();

    /* renamed from: F */
    void mo18033F(boolean z);

    /* renamed from: G */
    void mo18034G();

    /* renamed from: G */
    void mo18035G(boolean z);

    /* renamed from: H */
    void mo18036H();

    /* renamed from: H */
    void mo18037H(boolean z);

    /* renamed from: I */
    ImageCallback mo18038I();

    /* renamed from: I */
    void mo18039I(boolean z);

    /* renamed from: J */
    void mo18040J();

    /* renamed from: J */
    void mo18041J(boolean z);

    /* renamed from: K */
    void mo18042K(boolean z);

    /* renamed from: K */
    boolean mo18043K();

    /* renamed from: L */
    void mo18044L();

    /* renamed from: L */
    void mo18045L(boolean z);

    /* renamed from: M */
    void mo18046M();

    /* renamed from: M */
    void mo18047M(boolean z);

    /* renamed from: N */
    void mo18048N();

    /* renamed from: N */
    void mo18049N(boolean z);

    /* renamed from: O */
    void mo18050O(boolean z);

    /* renamed from: O */
    boolean mo18051O();

    /* renamed from: P */
    void mo18052P(boolean z);

    /* renamed from: P */
    boolean mo18053P();

    /* renamed from: Q */
    void mo18054Q(boolean z);

    /* renamed from: Q */
    boolean mo18055Q();

    /* renamed from: R */
    void mo18056R(boolean z);

    /* renamed from: R */
    boolean mo18057R();

    /* renamed from: S */
    boolean mo18058S();

    /* renamed from: T */
    boolean mo18059T();

    /* renamed from: U */
    void mo18060U();

    /* renamed from: V */
    void mo18061V();

    /* renamed from: W */
    boolean mo18062W();

    /* renamed from: X */
    boolean mo18063X();

    /* renamed from: Y */
    boolean mo18064Y();

    /* renamed from: Z */
    boolean mo18065Z();

    /* renamed from: PlatformImplementations.kt_3 */
    GLRootView mo18066a();

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18067a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18068a(int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18069a(int OplusGLSurfaceView_13, int i2, int i3, Object... objArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18070a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18071a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, int i3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18072a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18073a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, boolean z7);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18074a(int OplusGLSurfaceView_13, int i2, Object... objArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18075a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18076a(int OplusGLSurfaceView_13, String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18077a(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18078a(int OplusGLSurfaceView_13, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18079a(long OplusGLSurfaceView_15);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18080a(long OplusGLSurfaceView_15, long j2, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18081a(long OplusGLSurfaceView_15, long j2, boolean z, boolean z2, long j3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18082a(long OplusGLSurfaceView_15, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18083a(DialogInterface.OnCancelListener onCancelListener);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18084a(View.OnClickListener onClickListener);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18085a(View.OnClickListener onClickListener, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18086a(View view, int OplusGLSurfaceView_13, int i2, int i3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18087a(View view, String str, int OplusGLSurfaceView_13, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18088a(SurfaceTextureScreenNail.IntrinsicsJvm.kt_4 bVar, boolean z, boolean z2, String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18089a(DetectResult c3077a);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18090a(MicroscopeHintView.InterfaceC3097a interfaceC3097a, boolean z, int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18091a(MainShutterButtonInfo c3200b);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18092a(MainShutterButtonInfo c3200b, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18093a(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18094a(Thumbnail c3203e, int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18095a(OplusViewOutlineProvider c3464q);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18096a(Float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18097a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18098a(String str, int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18099a(String str, String str2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18100a(String str, String str2, String str3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18101a(String str, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18102a(String str, boolean z, int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18103a(String str, String... strArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18104a(List<Integer> list, long OplusGLSurfaceView_15);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18105a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18106a(boolean z, String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18107a(boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18108a(boolean z, boolean z2, boolean z3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18109a(boolean z, boolean z2, boolean z3, boolean z4);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo18110a(int... iArr);

    /* renamed from: aA */
    boolean mo18111aA();

    /* renamed from: aB */
    void mo18112aB();

    /* renamed from: aC */
    void mo18113aC();

    /* renamed from: aD */
    void mo18114aD();

    /* renamed from: aE */
    void mo18115aE();

    /* renamed from: aF */
    void mo18116aF();

    /* renamed from: aG */
    boolean mo18117aG();

    /* renamed from: aH */
    void mo18118aH();

    /* renamed from: aI */
    void mo18119aI();

    /* renamed from: aJ */
    void mo18120aJ();

    /* renamed from: aK */
    void mo18121aK();

    /* renamed from: aL */
    void mo18122aL();

    /* renamed from: aM */
    void mo18123aM();

    /* renamed from: aN */
    void mo18124aN();

    /* renamed from: aO */
    void mo18125aO();

    /* renamed from: aP */
    void mo18126aP();

    /* renamed from: aQ */
    boolean mo18127aQ();

    /* renamed from: aR */
    void mo18128aR();

    /* renamed from: aS */
    void mo18129aS();

    /* renamed from: aT */
    void mo18130aT();

    /* renamed from: aU */
    boolean mo18131aU();

    /* renamed from: aV */
    String mo18132aV();

    /* renamed from: aW */
    boolean mo18133aW();

    /* renamed from: aX */
    int mo18134aX();

    /* renamed from: aY */
    TimeLapseProMenuLayout mo18135aY();

    /* renamed from: aZ */
    void mo18136aZ();

    /* renamed from: aa */
    int mo18137aa();

    /* renamed from: ab */
    void mo18138ab();

    /* renamed from: ac */
    void mo18139ac();

    /* renamed from: ad */
    boolean mo18140ad();

    /* renamed from: ae */
    boolean mo18141ae();

    /* renamed from: af */
    boolean mo18142af();

    /* renamed from: ag */
    boolean mo18143ag();

    /* renamed from: ah */
    void mo18144ah();

    /* renamed from: ai */
    void mo18145ai();

    /* renamed from: aj */
    void mo18146aj();

    /* renamed from: ak */
    void mo18147ak();

    /* renamed from: al */
    void mo18148al();

    /* renamed from: am */
    int mo18149am();

    /* renamed from: an */
    int mo18150an();

    /* renamed from: ao */
    Uri mo18151ao();

    /* renamed from: ap */
    boolean mo18152ap();

    /* renamed from: aq */
    String mo18153aq();

    /* renamed from: ar */
    void mo18154ar();

    /* renamed from: as */
    void mo18155as();

    /* renamed from: at */
    void mo18156at();

    /* renamed from: au */
    void mo18157au();

    /* renamed from: av */
    boolean mo18158av();

    /* renamed from: aw */
    boolean mo18159aw();

    /* renamed from: ax */
    boolean mo18160ax();

    /* renamed from: ay */
    boolean mo18161ay();

    /* renamed from: az */
    Rect mo18162az();

    /* renamed from: IntrinsicsJvm.kt_4 */
    ViewGroup mo18163b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18164b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18165b(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18166b(int OplusGLSurfaceView_13, int i2, int i3, Object... objArr);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18167b(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18168b(long OplusGLSurfaceView_15);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18169b(String str);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18170b(String str, int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18171b(String str, String str2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18172b(String str, boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18173b(String str, String... strArr);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18174b(boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18175b(boolean z, boolean z2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18176b(boolean z, boolean z2, boolean z3, boolean z4);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo18177b(int... iArr);

    /* renamed from: ba */
    void mo18178ba();

    /* renamed from: bb */
    void mo18179bb();

    /* renamed from: bc */
    int mo18180bc();

    /* renamed from: bd */
    boolean mo18181bd();

    /* renamed from: be */
    boolean mo18182be();

    /* renamed from: IntrinsicsJvm.kt_3 */
    CameraScreenNail mo18183c();

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18184c(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18185c(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18186c(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18187c(String str);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18188c(String str, int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18189c(String str, boolean z);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18190c(boolean z);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18191c(boolean z, boolean z2);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo18192c(boolean z, boolean z2, boolean z3, boolean z4);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18193d(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18194d(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18195d(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18196d(String str);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18197d(String str, int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18198d(String str, boolean z);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18199d(boolean z);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo18200d(boolean z, boolean z2);

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean mo18201d();

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo18202e(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo18203e(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo18204e(String str);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo18205e(boolean z);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo18206e(boolean z, boolean z2);

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean mo18207e();

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean mo18208e(int OplusGLSurfaceView_13, int i2);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo18209f(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo18210f(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo18211f(String str);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo18212f(boolean z);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo18213f(boolean z, boolean z2);

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean mo18214f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo18215g(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo18216g(String str);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo18217g(boolean z);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo18218g(boolean z, boolean z2);

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean mo18219g();

    /* renamed from: COUIBaseListPopupWindow_10 */
    CameraMenuOption mo18220h(String str);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo18221h(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo18222h(boolean z);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo18223h(boolean z, boolean z2);

    /* renamed from: COUIBaseListPopupWindow_10 */
    boolean mo18224h();

    /* renamed from: OplusGLSurfaceView_13 */
    void mo18225i();

    /* renamed from: OplusGLSurfaceView_13 */
    void mo18226i(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo18227i(boolean z);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo18228i(boolean z, boolean z2);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo18229j();

    /* renamed from: OplusGLSurfaceView_15 */
    void mo18230j(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo18231j(boolean z);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo18232j(boolean z, boolean z2);

    /* renamed from: OplusGLSurfaceView_5 */
    HintManager mo18233k();

    /* renamed from: OplusGLSurfaceView_5 */
    void mo18234k(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_5 */
    void mo18235k(boolean z);

    /* renamed from: OplusGLSurfaceView_5 */
    void mo18236k(boolean z, boolean z2);

    /* renamed from: OplusGLSurfaceView_14 */
    String mo18237l();

    /* renamed from: OplusGLSurfaceView_14 */
    void mo18238l(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_14 */
    void mo18239l(boolean z);

    /* renamed from: OplusGLSurfaceView_14 */
    void mo18240l(boolean z, boolean z2);

    /* renamed from: OplusGLSurfaceView_6 */
    int mo18241m();

    /* renamed from: OplusGLSurfaceView_6 */
    void mo18242m(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_6 */
    void mo18243m(boolean z);

    /* renamed from: OplusGLSurfaceView_6 */
    void mo18244m(boolean z, boolean z2);

    /* renamed from: OplusGLSurfaceView_11 */
    void mo18245n();

    /* renamed from: OplusGLSurfaceView_11 */
    void mo18246n(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_11 */
    void mo18247n(boolean z);

    /* renamed from: OplusGLSurfaceView_11 */
    void mo18248n(boolean z, boolean z2);

    /* renamed from: o */
    void mo18249o();

    /* renamed from: o */
    void mo18250o(int OplusGLSurfaceView_13);

    /* renamed from: o */
    void mo18251o(boolean z);

    /* renamed from: o */
    void mo18252o(boolean z, boolean z2);

    /* renamed from: p */
    RelativeLayout mo18253p();

    /* renamed from: p */
    void mo18254p(int OplusGLSurfaceView_13);

    /* renamed from: p */
    void mo18255p(boolean z);

    /* renamed from: p */
    void mo18256p(boolean z, boolean z2);

    /* renamed from: q */
    RectF mo18257q(int OplusGLSurfaceView_13);

    /* renamed from: q */
    void mo18258q();

    /* renamed from: q */
    void mo18259q(boolean z);

    /* renamed from: q */
    void mo18260q(boolean z, boolean z2);

    /* renamed from: r */
    int mo18261r();

    /* renamed from: r */
    void mo18262r(int OplusGLSurfaceView_13);

    /* renamed from: r */
    void mo18263r(boolean z);

    /* renamed from: r */
    void mo18264r(boolean z, boolean z2);

    /* renamed from: s */
    int mo18265s();

    /* renamed from: s */
    void mo18266s(int OplusGLSurfaceView_13);

    /* renamed from: s */
    void mo18267s(boolean z);

    /* renamed from: s */
    void mo18268s(boolean z, boolean z2);

    /* renamed from: t */
    void mo18269t();

    /* renamed from: t */
    void mo18270t(int OplusGLSurfaceView_13);

    /* renamed from: t */
    void mo18271t(boolean z);

    /* renamed from: t */
    void mo18272t(boolean z, boolean z2);

    /* renamed from: u */
    void mo18273u();

    /* renamed from: u */
    void mo18274u(int OplusGLSurfaceView_13);

    /* renamed from: u */
    void mo18275u(boolean z);

    /* renamed from: u */
    void mo18276u(boolean z, boolean z2);

    /* renamed from: v */
    void mo18277v();

    /* renamed from: v */
    void mo18278v(int OplusGLSurfaceView_13);

    /* renamed from: v */
    void mo18279v(boolean z);

    /* renamed from: w */
    void mo18280w();

    /* renamed from: w */
    void mo18281w(int OplusGLSurfaceView_13);

    /* renamed from: w */
    void mo18282w(boolean z);

    /* renamed from: x */
    void mo18283x();

    /* renamed from: x */
    void mo18284x(boolean z);

    /* renamed from: y */
    String mo18285y();

    /* renamed from: y */
    void mo18286y(boolean z);

    /* renamed from: z */
    void mo18287z();

    /* renamed from: z */
    void mo18288z(boolean z);
}
