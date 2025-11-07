package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public interface CameraUIInterface {
    public static final java.lang.String FLASH_TYPE_FLASH_LIGHT = "flash_light";
    public static final java.lang.String FLASH_TYPE_INVERSE_LIGHT = "inverse_light";
    public static final java.lang.String FLASH_TYPE_NONE = "none";
    public static final java.lang.String FLASH_TYPE_SCREEN_LIGHT = "screen_light";
    public static final java.lang.String KEY_10_BITS_HEIC_ENCODE = "pref_10bits_heic_encode_key";
    public static final java.lang.String KEY_10_BITS_HEIC_ENCODE_BACKUP = "pref_10bits_heic_encode_backup_key";
    public static final java.lang.String KEY_10_BITS_SUPPORT_IN_CURRENT_MODE = "pref_10bits_support_mode_key";
    public static final java.lang.String KEY_3DPHOTO_FACEBEAUTY_LEVEL_MENU = "pref_3dphoto_facebeauty_level_menu";
    public static final java.lang.String KEY_3D_PHOTO_FILTER_INDEX = "key_3d_photo_filter_index";
    public static final java.lang.String KEY_ACCELEROMETER_USAGE = "key_accelerometer_usage";
    public static final java.lang.String KEY_ADVANCE_SETTING_IMAGE = "pref_advance_setting_key";
    public static final java.lang.String KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS = "key_ai_enhancement_closed_by_video_size_fps";
    public static final java.lang.String KEY_AI_ENHANCEMENT_GUIDE_REMINDER_TIMES = "key_ai_enhancement_guide_reminder_times";
    public static final java.lang.String KEY_AI_ENHANCEMENT_ON_VIDEO_SIZE = "key_ai_enhancement_on_video_size";
    public static final java.lang.String KEY_AI_ENHANCEMENT_VIDEO = "key_ai_enhancement_video";
    public static final java.lang.String KEY_AI_HIGH_PIXEL = "pref_camera_ai_high_pixel_key";
    public static final java.lang.String KEY_AI_SCN = "pref_ai_scene_key";
    public static final java.lang.String KEY_ASSISTANT_LINE = "pref_camera_assistant_line_key";
    public static final java.lang.String KEY_ASSIST_GRADIENTER = "pref_assist_gradienter";
    public static final java.lang.String KEY_AUTO_NIGHT_SCENCE = "pref_auto_night_scence_key";
    public static final java.lang.String KEY_BEAUTY3D = "key_beauty3d";
    public static final java.lang.String KEY_BEAUTY3D_MAIN_FACE_DETECT = "key_beauty3d_main_face_detect";
    public static final java.lang.String KEY_BLUR_MODE = "pref_camera_blur_mode_key";
    public static final java.lang.String KEY_BOTTOM_BLANK = "pref_bottom_blank";
    public static final java.lang.String KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE = "key_bottom_guide_double_exposure";
    public static final java.lang.String KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED = "key_bottom_guide_type_id_photo";
    public static final java.lang.String KEY_BOTTOM_GUIDE_MAKEUP_TIPS_SHOWED = "key_bottom_guide_type_makeup";
    public static final java.lang.String KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO = "key_bottom_guide_type_fast_video";
    public static final java.lang.String KEY_BOTTOM_GUIDE_TYPE_NIGHT_TRIPOD = "key_bottom_guide_type_night_tripod";
    public static final java.lang.String KEY_BUBBLE_MOVIE = "key_bubble_movie";
    public static final java.lang.String KEY_BUBBLE_SHORT_VIDEO = "key_bubble_short_video";
    public static final java.lang.String KEY_BUBBLE_STICKER = "key_bubble_sticker";
    public static final java.lang.String KEY_BUBBLE_STREET_ROCKER_SHUTTER = "key_bubble_street_rocker_shutter";
    public static final java.lang.String KEY_BUBBLE_TYPE_ADD_BEUTY3D = "key_bubble_type_add_beuty3d";
    public static final java.lang.String KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO = "key_bubble_type_ai_enhancement_video";
    public static final java.lang.String KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D = "key_bubble_type_custom_beuty3d";
    public static final java.lang.String KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE = "key_bubble_type_custom_face_beauty_close";
    public static final java.lang.String KEY_BUBBLE_TYPE_MULTI_VIDEO = "key_bubble_type_multi_video";
    public static final java.lang.String KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE = "key_bubble_type_zoom_ultra_wide";
    public static final java.lang.String KEY_BUILD_IMAGE_SETTING = "pref_build_image_setting_key";
    public static final java.lang.String KEY_BURST_SHOT = "pref_burst_shot_key";
    public static final java.lang.String KEY_CAMERA_AI_SCN_VERSION = "pref_camera_ai_scn_version_key";
    public static final java.lang.String KEY_CAMERA_CODEC = "pref_camera_code_key";
    public static final java.lang.String KEY_CAMERA_EXIT_TIME_STAMP = "pref_camera_exit_time_stamp_key";
    public static final java.lang.String KEY_CAMERA_EXIT_TIME_STAMP_FROM_OTHER_APP = "pref_camera_exit_time_from_other_program_code";
    public static final java.lang.String KEY_CAMERA_FINGERPRINT_SHUTTER = "pref_camera_fingerprint_shutter_key";
    public static final java.lang.String KEY_CAMERA_GESTURE_SHUTTER = "pref_camera_gesture_shutter_key";
    public static final java.lang.String KEY_CAMERA_GRID_VERSION = "pref_camera_grid_version_key";
    public static final java.lang.String KEY_CAMERA_HDR_MODE = "pref_camera_hdr_mode_key";
    public static final java.lang.String KEY_CAMERA_HDR_MODE_FROM_OTHER_APP = "pref_camera_hdr_mode_key_from_other_app";
    public static final java.lang.String KEY_CAMERA_ID = "pref_camera_id_key";
    public static final java.lang.String KEY_CAMERA_MODE = "pref_camera_mode_key";
    public static final java.lang.String KEY_CAMERA_PID_HISTORY = "key_camera_pid_history";
    public static final java.lang.String KEY_CAMERA_QUCIK_LAUNCH = "pref_camera_quick_launch_key";
    public static final java.lang.String KEY_CAMERA_SLOGAN_VERSION = "pref_camera_slogan_version_key";
    public static final java.lang.String KEY_CAMERA_SOUND = "pref_camera_sound_key";
    public static final java.lang.String KEY_CAMERA_TAP_SHUTTER = "pref_camera_tap_shutter_key";
    public static final java.lang.String KEY_CAMERA_TIMER_SHUTTER = "pref_camera_timer_shutter_key";
    public static final java.lang.String KEY_CAMERA_TIMER_SHUTTER_FROM_OTHER_APP = "pref_camera_timer_shutter_key_from_other_app";
    public static final java.lang.String KEY_COMMON_FACEBEAUTY_LEVEL_MENU = "pref_common_facebeauty_level_menu";
    public static final java.lang.String KEY_COMMON_MAKEUP_TYPE = "pref_common_makeup_type";
    public static final java.lang.String KEY_COMMON_VIDEO_MAKEUP_TYPE = "pref_common_video_makeup_type";
    public static final java.lang.String KEY_CONTINUOUS_FOCUS = "pref_continuous_focus_key";
    public static final java.lang.String KEY_COUNTDOWN_EFFECT_SHUTTER = "pref_camera_countdown_effect_key";
    public static final java.lang.String KEY_CURRENT_STICKER_UUID = "pref_current_sticker_uuid";
    public static final java.lang.String KEY_CURRENT_TEMPERATURE = "key_cur_temperature";
    public static final java.lang.String KEY_DARK_ENVIRONMENT_TIPS = "key_dark_environment_tips";
    public static final java.lang.String KEY_DISABLE_AI_ENHANCEMENT_VIDEO = "key_disable_ai_enhancement_video";
    public static final java.lang.String KEY_DOUBLE_EXPOSURE_EFFECT_TYPE = "pref_double_exposure_effect_type";
    public static final java.lang.String KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION = "key_double_exposure_guid_page_and_duration";
    public static final java.lang.String KEY_DOUBLE_EXPOSURE_OPEN_COUNT = "pref_double_exposure_open_count";
    public static final java.lang.String KEY_DOUBLE_EXPOSURE_TIPS = "pref_double_exposure_tips";
    public static final java.lang.String KEY_DRAWER_ANCHOR_TIPS = "key_drawer_layout_anchor";
    public static final java.lang.String KEY_DRAWER_SHOW_GUIDE_ANIMATION = "key_drawer_show_guide_animation";
    public static final java.lang.String KEY_DUAL_CAMERA = "pref_dual_camera";
    public static final java.lang.String KEY_ENTRY_BREENO_SCAN = "pref_entry_breeno_scan_key";
    public static final java.lang.String KEY_EXPAND_POPBAR = "pref_expand_popbar_key";
    public static final java.lang.String KEY_EXPLORER_CHIP_STATE = "key_explorer_chip_state";
    public static final java.lang.String KEY_EXPORT_PERMISSION_REQUESTED = "key_export_permission_requested";
    public static final java.lang.String KEY_EXPOSURE_FOCUS_SEPARATE_TIPS = "key_exposure_focus_separate_guide_animation";
    public static final java.lang.String KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION = "pref_face_beauty_close_by_resolution";
    public static final java.lang.String KEY_FACE_BEAUTY_LAST_TAB_INDEX = "key_face_beauty_last_tab_index";
    public static final java.lang.String KEY_FACE_DETECTION = "pref_face_detection_key";
    public static final java.lang.String KEY_FACE_RECTIFY = "pref_face_rectify_key";
    public static final java.lang.String KEY_FACE_RECTIFY_SET_DEFAULT_VALUE = "pref_facerectify_set_default_value";
    public static final java.lang.String KEY_FAST_VIDEO_SIZE = "pref_fast_video_size_key";
    public static final java.lang.String KEY_FILM_MODE_EXPOSURE = "pref_film_mode_exposure";
    public static final java.lang.String KEY_FILM_MODE_FOCUS = "pref_film_mode_focus";
    public static final java.lang.String KEY_FILM_MODE_ISO = "pref_film_mode_iso";
    public static final java.lang.String KEY_FILM_MODE_SHUTTER = "pref_film_mode_shutter";
    public static final java.lang.String KEY_FILM_MODE_WHITE_BALANCE = "pref_film_mode_white_balance";
    public static final java.lang.String KEY_FILM_SHOW_UI_DEFAULT = "pref_film_show_ui_default";
    public static final java.lang.String KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE = "pref_film_video_eis_and_flash_enable";
    public static final java.lang.String KEY_FILM_VIDEO_EIS_MENU = "pref_film_video_eis_menu";
    public static final java.lang.String KEY_FILM_VIDEO_FILTER = "pref_film_video_filter";
    public static final java.lang.String KEY_FILM_VIDEO_GUIDE_LINE = "pref_film_video_guide_line";
    public static final java.lang.String KEY_FILM_VIDEO_HDR = "pref_film_video_hdr";
    public static final java.lang.String KEY_FILM_VIDEO_HISTOGRAM = "pref_film_video_histogram";
    public static final java.lang.String KEY_FILM_VIDEO_LOG = "pref_film_video_log";
    public static final java.lang.String KEY_FILM_VIDEO_SWITCH_CAMERA = "pref_film_video_switch_camera_key";
    public static final java.lang.String KEY_FILTER_ANC_INDEX = "key_filter_anc_index";
    public static final java.lang.String KEY_FILTER_INDEX = "key_filter_index";
    public static final java.lang.String KEY_FILTER_INDEX_OTHER_APP = "key_filter_index";
    public static final java.lang.String KEY_FILTER_LIST_TYPE = "key_filter_list_type";
    public static final java.lang.String KEY_FILTER_MENU = "pref_filter_menu";
    public static final java.lang.String KEY_FILTER_MENU_UPDATED = "key_filter_menu_updated";
    public static final java.lang.String KEY_FILTER_PREV_SELECTED_FILTERTYPE = "key_filter_prev_selected_filterType";
    public static final java.lang.String KEY_FILTER_PREV_SELECTED_FILTERTYPE_OTHER_APP = "key_filter_prev_selected_filterType_other_app";
    public static final java.lang.String KEY_FILTER_PROCESS = "pref_filter_process_key";
    public static final java.lang.String KEY_FILTER_VERSION = "pref_filter_version_key";
    public static final java.lang.String KEY_FIRST_BEAUTY_TIPS = "key_first_beauty_tip";
    public static final java.lang.String KEY_FIRST_CHANGE_EIS = "key_first_change_eis";
    public static final java.lang.String KEY_FISH_EYE_FILTER_INDEX = "key_fish_eye_filter_index";
    public static final java.lang.String KEY_FISH_EYE_MODE = "pref_fish_eye_mode";
    public static final java.lang.String KEY_FLASH_MODE = "pref_camera_flashmode_key";
    public static final java.lang.String KEY_FLASH_MODE_FROM_OTHER_APP = "pref_camera_flashmode_key_from_other_app";
    public static final java.lang.String KEY_FOCUS_PEAKING = "pref_focus_peaking_key";
    public static final java.lang.String KEY_FRONT_CAMERA_FIRST_SWITCH = "key_front_camera_first_switch";
    public static final java.lang.String KEY_FRONT_ZOOM_SWITCH = "pref_front_zoom_key";
    public static final java.lang.String KEY_FUJI_FILTER_MENU = "pref_fuji_filter_menu";
    public static final java.lang.String KEY_FULL_PIC_SIZE_TYPE = "key_full_pic_size_type";
    public static final java.lang.String KEY_FULL_SCREEN_CENTER_SUPPORT = "key_full_screen_center_support";
    public static final java.lang.String KEY_GRADIENTER = "pref_camera_gradienter_key";
    public static final java.lang.String KEY_GROUPSHOT_FACEBEAUTY_LEVEL_MENU = "pref_groupshot_facebeauty_level_menu";
    public static final java.lang.String KEY_HASSELBLAD_XPAN_FILTER_INDEX = "key_hasselblad_xpan_filter_index";
    public static final java.lang.String KEY_HEADLINE_CONTROL_BY_MODE = "pref_headline_control_by_mode";
    public static final java.lang.String KEY_HEIF_FORMAT = "pref_heif_format_key";
    public static final java.lang.String KEY_HEIF_SUPPORT = "pref_heif_support_key";
    public static final java.lang.String KEY_HELP_AND_FEEDBACK = "pref_help_and_feedback_key";
    public static final java.lang.String KEY_HEVC_VIDEO_FORMAT = "pref_hevc_video_key";
    public static final java.lang.String KEY_HIGH_PICTURE_PRO_MODE = "pref_high_picture_pro_mode_key";
    public static final java.lang.String KEY_HIGH_PICTURE_SIZE = "key_high_picture_size";
    public static final java.lang.String KEY_HIGH_RESOLUTION = "pref_high_resolution_key";
    public static final java.lang.String KEY_HIGH_RESOLUTION_CANCEL_SNAPSHOT = "high_resolution_cancel_snapshot";
    public static final java.lang.String KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN = "key_hyper_lapse_zoom_ultra_wide_open";
    public static final java.lang.String KEY_IDPHOTO_FACEBEAUTY_LEVEL_MENU = "pref_idphoto_facebeauty_level_menu";
    public static final java.lang.String KEY_INERTIAL_ZOOM = "pref_inertial_zoom_key";
    public static final java.lang.String KEY_INTELLIGENT_HIGH_FRAME_SELECTED = "pref_intelligent_high_frame_selected_key";
    public static final java.lang.String KEY_INTELLIGENT_HIGH_FRAME_USAGE = "key_intelligent_high_frame_usage_key";
    public static final java.lang.String KEY_IS_ANDROID_S_DATA_MIGRATED = "pref_is_android_s_data_migrated";
    public static final java.lang.String KEY_IS_CAPTURE_MODE = "key_is_capture_mode";
    public static final java.lang.String KEY_IS_VIDEO_MODE = "key_is_video_mode";
    public static final java.lang.String KEY_LASTED_VIDEO_CODEC = "pref_lasted_video_codec";
    public static final java.lang.String KEY_LASTED_VIDEO_FPS = "pref_lasted_video_fps";
    public static final java.lang.String KEY_LASTED_VIDEO_SAVE_STATUS = "pref_lasted_video_save_status";
    public static final java.lang.String KEY_LASTED_VIDEO_SIZE = "pref_lasted_video_size";
    public static final java.lang.String KEY_LAST_CAMERA_GESTURE_SHUTTER = "last_camera_gesture_shutter_key";
    public static final java.lang.String KEY_LAST_CAMERA_TAP_SHUTTER = "last_camera_tap_shutter_key";
    public static final java.lang.String KEY_LAST_MACRO_SWITCH = "pref_last_macro_switch";
    public static final java.lang.String KEY_LENS_DIRTY_DETECTION = "pref_lens_dirty_detection_key";
    public static final java.lang.String KEY_LINE_PHOTO = "pref_camera_line_photo";
    public static final java.lang.String KEY_LINE_VIDEO = "pref_camera_line_video";
    public static final java.lang.String KEY_LONG_EXPOSURE_FILTER_INDEX = "key_long_exposure_filter_index";
    public static final java.lang.String KEY_LONG_EXPOSURE_SCENE_MENU_STATE = "pref_long_exposure_scene_menu_state";
    public static final java.lang.String KEY_LONG_EXPOSURE_SCENE_TYPE = "pref_long_exposure_scene_type";
    public static final java.lang.String KEY_LONG_PROCESS_SHUTTER_CHOICE = "pref_long_process_choice_key";
    public static final java.lang.String KEY_MACRO_FILTER_INDEX = "key_macro_filter_index";
    public static final java.lang.String KEY_MACRO_SWITCH = "pref_macro_switch";
    public static final java.lang.String KEY_MAKEUP_LAST_CLOSE_INDEX = "pref_makeup_last_close_index";
    public static final java.lang.String KEY_MANUAL_EXPOSURE = "pref_manual_exposure_key";
    public static final java.lang.String KEY_MICROSCOPE_GUIDE_SHOW_NEED = "key_microscope_guide_show_need";
    public static final java.lang.String KEY_MIRROR = "pref_mirror_key";
    public static final java.lang.String KEY_MIRROR_SETTING = "pref_mirror_setting_key";
    public static final java.lang.String KEY_MOVIE_FLASH_MODE = "pref_camera_film_mode_key";
    public static final java.lang.String KEY_MULTI_CAMERA_SHOW_POSITION_STATE = "pref_multicamera_show_position_state_key";
    public static final java.lang.String KEY_MULTI_CAMERA_TYPE_MENU = "key_multicamera_type_menu_key";
    public static final java.lang.String KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM = "key_multicamera_type_menu_need_zoom_key";
    public static final java.lang.String KEY_MULTI_CAMERA_TYPE_SELECTED = "pref_multicamera_type_selected_key";
    public static final java.lang.String KEY_MULTI_VIDEO_FACEBEAUTY_LEVEL_MENU = "pref_multi_video_facebeauty_level_menu";
    public static final java.lang.String KEY_NEED_INTERCEPT_TOUCH = "key_need_intercept_touch";
    public static final java.lang.String KEY_NIGHT_FACEBEAUTY_LEVEL_MENU = "pref_night_facebeauty_level_menu";
    public static final java.lang.String KEY_NIGHT_FILTER_INDEX = "key_night_filter_index";
    public static final java.lang.String KEY_NIGHT_FILTER_MENU = "pref_night_filter_menu";
    public static final java.lang.String KEY_NIGHT_MAKEUP_TYPE = "pref_night_makeup_type";
    public static final java.lang.String KEY_NIGHT_PRO_MODE = "pref_night_pro_mode_key";
    public static final java.lang.String KEY_NIGHT_STARBURST_MODE = "pref_night_starburst_mode";
    public static final java.lang.String KEY_NIGHT_TRIPOD_MODE = "pref_night_tripod_mode_key";
    public static final java.lang.String KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE = "key_night_tripod_zoom_hide_ultra_wide";
    public static final java.lang.String KEY_NONE_SAT_TELE_ANGLE = "pref_none_sat_tele_angle_key";
    public static final java.lang.String KEY_NONE_SAT_ULTRA_WIDE_ANGLE = "pref_none_sat_ultra_wide_angle_key";
    public static final java.lang.String KEY_OLD_VIDEO_FPS = "pref_old_video_fps";
    public static final java.lang.String KEY_OLD_VIDEO_SIZE = "pref_old_video_size";
    public static final java.lang.String KEY_OLD_VIDEO_STATUS_FOR_SPECIAL = "pref_old_video_status_for_special";
    public static final java.lang.String KEY_OMOJI_PROCESS = "pref_omoji_process_key";
    public static final java.lang.String KEY_OUT_PREVIEW_GUIDE = "key_out_preview_guide";
    public static final java.lang.String KEY_PARAMETER_SAVING = "pref_parameter_saving";
    public static final java.lang.String KEY_PERMISSION_DIALOG_DISPLAYED = "key_permission_dialog_displayed";
    public static final java.lang.String KEY_PHOTO_CODEC = "pref_photo_codec_key";
    public static final java.lang.String KEY_PHOTO_CODEC_BACKUP = "pref_photo_codec_backup_key";
    public static final java.lang.String KEY_PHOTO_CODEC_CLICK = "pref_photo_codec_click_key";
    public static final java.lang.String KEY_PHOTO_HIGH_RESOLUTION = "pref_camera_high_resolution_key";
    public static final java.lang.String KEY_PHOTO_MONO_FILTER = "key_photo_mode_filter";
    public static final java.lang.String KEY_PHOTO_RATIO = "pref_camera_photo_ratio_key";
    public static final java.lang.String KEY_PHOTO_RATIO_FROM_OTHER_APP = "pref_camera_photo_ratio_key_from_other_app";
    public static final java.lang.String KEY_PI = "pref_camera_pi_mode_key";
    public static final java.lang.String KEY_PI_AI = "pref_camera_pi_ai_mode_key";
    public static final java.lang.String KEY_PLATFORM_SLOW_VIDEO_FPS = "pref_platform_slow_video_fps_key";
    public static final java.lang.String KEY_PORTRAIT_BLUR_MENU = "pref_portrait_blur_menu";
    public static final java.lang.String KEY_PORTRAIT_BLUR_MENU_INDEX = "pref_portrait_blur_menu_index";
    public static final java.lang.String KEY_PORTRAIT_FACEBEAUTY_LEVEL_MENU = "pref_portrait_facebeauty_level_menu";
    public static final java.lang.String KEY_PORTRAIT_HALF_BODY = "pref_portrait_half_body_key";
    public static final java.lang.String KEY_PORTRAIT_HALF_BODY_REMOSAIC = "pref_portrait_half_body_remosaic_key";
    public static final java.lang.String KEY_PORTRAIT_MAKEUP_TYPE = "pref_portrait_makeup_type";
    public static final java.lang.String KEY_PORTRAIT_NEW_STYLE_INDEX = "key_portrait_new_style_index";
    public static final java.lang.String KEY_PORTRAIT_NEW_STYLE_MENU = "pref_portrait_new_style_menu";
    public static final java.lang.String KEY_PRO_HISTOGRAM = "pref_pro_histogram_key";
    public static final java.lang.String KEY_QR_CODE = "pref_qr_code_key";
    public static final java.lang.String KEY_QUICK_VIDEO = "key_quick_video";
    public static final java.lang.String KEY_RAW = "pref_raw_key";
    public static final java.lang.String KEY_RAW_CONTROL = "pref_raw_control_key";
    public static final java.lang.String KEY_RECORD_LOCATION = "pref_camera_recordlocation_key";
    public static final java.lang.String KEY_REFERENCE_LINE = "pref_camera_reference_line";
    public static final java.lang.String KEY_REMOSAIC = "key_remosaic";
    public static final java.lang.String KEY_REPORT_PERMISSION_TIME_STAMP = "pref_report_permission_timestamp";
    public static final java.lang.String KEY_RESTORE_HIGH_PICTURE_PRO_PARAMS = "pref_restore_high_picture_pro_params";
    public static final java.lang.String KEY_RESTORE_LONG_EXPOSURE_PARAMS = "pref_restore_long_exposure_params";
    public static final java.lang.String KEY_RESTORE_NIGHT_PRO_PARAMS = "pref_restore_night_pro_params";
    public static final java.lang.String KEY_RESTORE_PROFESSIONAL_PARAMS = "pref_restore_professional_params";
    public static final java.lang.String KEY_RESTORE_TIMELAPSE_PRO_PARAMS = "pref_restore_time_lapse_pro_params";
    public static final java.lang.String KEY_RESTORE_TYPE = "pref_restore_key";
    public static final java.lang.String KEY_SAVE_JPG_AFTER_PAUSE = "pref_save_jpg_after_pause_key";
    public static final java.lang.String KEY_SETTING = "pref_setting_key";
    public static final java.lang.String KEY_SETTING_ABOUT = "pref_about_key";
    public static final java.lang.String KEY_SETTING_MENU = "key_setting_menu";
    public static final java.lang.String KEY_SETTING_SUPPORT = "key_setting_support";
    public static final java.lang.String KEY_SHARE_AND_MARK = "pref_share_and_edit_key";
    public static final java.lang.String KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND = "share_edit_video_show_expand";
    public static final java.lang.String KEY_SHORT_VIDEO = "key_short_video";
    public static final java.lang.String KEY_SHOULD_REOPEN_AI_ENHANCEMENT_VIDEO = "key_should_reopen_ai_enhancement_video";
    public static final java.lang.String KEY_SHOW_PULL_DOWN_TIP = "key_show_pull_down_tip";
    public static final java.lang.String KEY_SHUTTER_HELP = "pref_shutter_help_key";
    public static final java.lang.String KEY_SHUTTER_SETTING_GUIDE = "pref_shutter_setting_guide_key";
    public static final java.lang.String KEY_SLOGAN_CUSTOMIZE = "pref_slogan_customize_key";
    public static final java.lang.String KEY_SLOGAN_OWNER = "pref_slogan_owner_key";
    public static final java.lang.String KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU = "key_slow_video_frame_seek_bar_menu_key";
    public static final java.lang.String KEY_SLOW_VIDEO_REAR_FPS = "pref_slow_video_rear_fps_key";
    public static final java.lang.String KEY_SLOW_VIDEO_SIZE = "pref_slow_video_size_key";
    public static final java.lang.String KEY_START_PREIVEW_SYNC = "pref_sstart_preview_sync";
    public static final java.lang.String KEY_STAR_VIDEO_RECORD_TOTAL_TIME = "pref_star_video_record_total_time_key";
    public static final java.lang.String KEY_STICKER_FACEBEAUTY_LEVEL_MENU = "pref_sticker_facebeauty_level_menu";
    public static final java.lang.String KEY_STICKER_FILTER_INDEX = "key_sticker_filter_index";
    public static final java.lang.String KEY_STICKER_PROCESS = "pref_sticker_process_key";
    public static final java.lang.String KEY_STORAGE_PLACE = "pref_camera_storage_key";
    public static final java.lang.String KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE = "key_ai_enhancement_off_video_size";
    public static final java.lang.String KEY_STREET_FILTER_INDEX = "key_street_filter_index";
    public static final java.lang.String KEY_STREET_FILTER_MENU = "pref_street_filter_menu";
    public static final java.lang.String KEY_STREET_FIX_FOCUS_CONTROL = "pref_street_fix_focus_control_key";
    public static final java.lang.String KEY_STREET_FIX_FOCUS_MANUAL_STATE = "pref_fix_focus_manual_state";
    public static final java.lang.String KEY_STREET_FIX_FOCUS_VALUE = "pref_fix_focus_value";
    public static final java.lang.String KEY_STREET_LONG_EXPOSURE_MENU = "pref_street_long_exposure_menu";
    public static final java.lang.String KEY_STREET_TRACE_GUIDE = "pref_street_trace_guide";
    public static final java.lang.String KEY_SUB_HOLD_SETTING = "pref_sub_hold_key";
    public static final java.lang.String KEY_SUB_SETTING = "pref_subsetting_key";
    public static final java.lang.String KEY_SUPER_CLEAR_PORTRAIT = "pref_super_clear_portrait";
    public static final java.lang.String KEY_SUPER_EIS_WIDE = "pref_super_eis_wide_key";
    public static final java.lang.String KEY_SUPER_EIS_WIDE_TIPS = "key_first_super_eis_wide_tip";
    public static final java.lang.String KEY_SUPER_RAW_CONTROL = "pref_super_raw_control_key";
    public static final java.lang.String KEY_SUPOORT_FOCUS_OUT_OF_RANGE = "support_focus_out_of_range";
    public static final java.lang.String KEY_SUPPORT_BOKEH_HDR = "key_support_bokeh_hdr";
    public static final java.lang.String KEY_SUPPORT_CAPTURE_PREVIEW = "pref_support_capture_preview";
    public static final java.lang.String KEY_SUPPORT_DECREASE_BRIGHTNESS = "key_support_decrease_brightness";
    public static final java.lang.String KEY_SUPPORT_EXPOSURE_FOCUS_SEPARATE = "pref_exposure_focus_separate_key";
    public static final java.lang.String KEY_SUPPORT_FOVC = "key_support_fovc";
    public static final java.lang.String KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION = "key_support_front_face_point_animation";
    public static final java.lang.String KEY_SUPPORT_GIMBAL_CHANGE = "key_support_gimbal_change";
    public static final java.lang.String KEY_SUPPORT_GRAND_TOUR_FILTERS = "key_support_grand_tour_fitlers";
    public static final java.lang.String KEY_SUPPORT_INSENSOR_ZOOM_20X = "key_support_insensor_zoom_20x";
    public static final java.lang.String KEY_SUPPORT_MAKEUP = "key_support_makeup";
    public static final java.lang.String KEY_SUPPORT_MODE_CHANGE_VIBRATE = "key_support_mode_change_vibrate";
    public static final java.lang.String KEY_SUPPORT_MULTI_FOCUS = "key_suppport_multi_focus";
    public static final java.lang.String KEY_SUPPORT_NIGHT_PROCESS = "pref_support_night_process";
    public static final java.lang.String KEY_SUPPORT_NO_FACE_FORBID_BEAUTY = "key_support_no_face_forbid_beauty";
    public static final java.lang.String KEY_SUPPORT_POST_VIEW = "pref_support_post_view";
    public static final java.lang.String KEY_SUPPORT_RAW_POST_PROCESS = "pref_support_raw_post_process";
    public static final java.lang.String KEY_SUPPORT_RECORDING_CAPTURE = "pref_support_recording_capture";
    public static final java.lang.String KEY_SUPPORT_ROTATE_HINT_VIEW = "pref_support_rotate_hint_view";
    public static final java.lang.String KEY_SUPPORT_SHARE_EDIT_THUMB = "key_support_share_edit_thumb";
    public static final java.lang.String KEY_SUPPORT_SHOW_DIM_HINT = "key_support_show_dim_hint";
    public static final java.lang.String KEY_SUPPORT_SHOW_NO_FACE = "key_support_show_no_face";
    public static final java.lang.String KEY_SUPPORT_SHOW_SOLOOP = "key_support_show_soloop";
    public static final java.lang.String KEY_SUPPORT_SLOW_VIDEO_H265 = "key_support_slow_video_h265";
    public static final java.lang.String KEY_SUPPORT_SUPER_EIS_WIDE_MENU = "key_support_super_eis_wide_menu";
    public static final java.lang.String KEY_SUPPORT_SWITCH_CAMERA = "pref_support_switch_camera";
    public static final java.lang.String KEY_SUPPORT_THUMBNAIL = "pref_support_thumbnail";
    public static final java.lang.String KEY_SUPPORT_UPDATE_THUMBNAIL_USER_PICTURE = "key_support_update_thumbnail_user_picture";
    public static final java.lang.String KEY_SUPPORT_VIDEO_COUNT_DOWN = "support_video_count_down";
    public static final java.lang.String KEY_SUPPORT_VIDEO_RECORDER = "key_support_video_recorder";
    public static final java.lang.String KEY_SUPPORT_VIDEO_THUMBNAIL_SIMULTANEOUS = "key_support_video_thumbnail_simultaneous";
    public static final java.lang.String KEY_SUPPORT_ZOOM_REINIT = "pref_support_zoom_reinit";
    public static final java.lang.String KEY_SUPPORT_ZSL = "key_support_zsl";
    public static final java.lang.String KEY_SWITCH_CAMERA = "pref_switch_camera_key";
    public static final java.lang.String KEY_SWITCH_CAMERA_BAR = "pref_switch_camera_bar_key";
    public static final java.lang.String KEY_SWITCH_DUAL_CAMERA = "pref_switch_dual_camera_key";
    public static final java.lang.String KEY_SWITCH_FRONT_DUAL_CAMERA = "pref_switch_front_dual_camera_key";
    public static final java.lang.String KEY_TELE_SMALL_PREVIEW = "pref_tele_small_preview_key";
    public static final java.lang.String KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING = "key_temperature_control_stop_video_recording";
    public static final java.lang.String KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED = "pref_temp_intelligent_high_frame_selected_key";
    public static final java.lang.String KEY_TEXTURE_UI = "pref_texture_ui_key";
    public static final java.lang.String KEY_TILT_SHIFT_BLUR_MENU = "pref_tilt_shift_blur_menu";
    public static final java.lang.String KEY_TILT_SHIFT_BLUR_MENU_INDEX = "pref_tilt_shift_blur_menu_index";
    public static final java.lang.String KEY_TILT_SHIFT_FILTER_INDEX = "key_tilt_shift_filter_index";
    public static final java.lang.String KEY_TILT_SHIFT_TYPE = "pref_tilt_shift_type";
    public static final java.lang.String KEY_TIMELAPSE_PRO_TEMPLATE_SELECT = "key_timelapse_pro_template_select";
    public static final java.lang.String KEY_TIMELAPSE_RECORD_TOTAL_TIME = "pref_timelapse_pro_record_total_time_key";
    public static final java.lang.String KEY_TIME_LAPSE = "pref_time_lapse_key";
    public static final java.lang.String KEY_TIME_LAPSE_PRO = "key_support_time_lapse_pro";
    public static final java.lang.String KEY_TIME_LAPSE_PRO_RECORDING_PREVIEW_FREEZE = "key_support_time_lapse_pro_recording_preview_freeze";
    public static final java.lang.String KEY_TIME_LAPSE_PRO_VIDEO_FRAMES = "pref_camera_time_lapse_pro_video_frames_key";
    public static final java.lang.String KEY_TIME_LAPSE_PRO_VIDEO_SPEED = "pref_camera_time_lapse_pro_speed_key";
    public static final java.lang.String KEY_TIME_LAPSE_RATE = "pref_camera_time_lapse_rate_key";
    public static final java.lang.String KEY_TOF_DUAL_CAMERA = "pref_tof_dual_camera";
    public static final java.lang.String KEY_TORCH_MODE = "pref_camera_torch_mode_key";
    public static final java.lang.String KEY_TORCH_MODE_FROM_OTHER_APP = "pref_camera_torch_mode_key_from_other_app";
    public static final java.lang.String KEY_TRACK_FOCUS = "pref_track_focus_key";
    public static final java.lang.String KEY_ULTRA_HIGH_RESOLUTION_FILTER_INDEX = "key_ultra_high_resolution_filter_index";
    public static final java.lang.String KEY_ULTRA_NIGHT_VIDEO = "key_ultra_night_video";
    public static final java.lang.String KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE = "pref_ultra_wide_high_picture_size_key";
    public static final java.lang.String KEY_UPDATE_SETTING_BAR_BACKGROUND = "pref_update_setting_background_bar_key";
    public static final java.lang.String KEY_VIDEO_BLUR_MENU = "pref_video_blur_menu";
    public static final java.lang.String KEY_VIDEO_BLUR_MENU_INDEX = "pref_video_blur_menu_index";
    public static final java.lang.String KEY_VIDEO_BLUR_MENU_STATE = "pref_video_blur_menu_state";
    public static final java.lang.String KEY_VIDEO_CLIP_SAVE_PATH = "PREF_VIDEO_CLIP_SAVE_PATH";
    public static final java.lang.String KEY_VIDEO_CODEC = "pref_video_codec_key";
    public static final java.lang.String KEY_VIDEO_CODEC_BACKUP = "pref_video_codec_backup_key";
    public static final java.lang.String KEY_VIDEO_DURATION_LIMIT = "key_video_duration_limit";
    public static final java.lang.String KEY_VIDEO_EIS = "pref_video_eis";
    public static final java.lang.String KEY_VIDEO_FACEBEAUTY_LEVEL_MENU = "pref_video_facebeauty_level_menu";
    public static final java.lang.String KEY_VIDEO_FACEBEAUTY_LEVEL_MENU_BACKUP = "pref_video_facebeauty_level_menu_backup";
    public static final java.lang.String KEY_VIDEO_FILTER_INDEX = "key_video_filter_index";
    public static final java.lang.String KEY_VIDEO_FILTER_MENU = "pref_video_filter_menu";
    public static final java.lang.String KEY_VIDEO_FLASH_MODE = "pref_camera_videoflashmode_key";
    public static final java.lang.String KEY_VIDEO_FPS = "pref_video_fps_key";
    public static final java.lang.String KEY_VIDEO_HDR = "key_video_hdr";
    public static final java.lang.String KEY_VIDEO_HIGH_FPS = "key_support_video_high_fps";
    public static final java.lang.String KEY_VIDEO_HYPER_LAPSE_FOCUS_FIRST_HINTS = "key_video_hyper_lapse_focus_first_hints";
    public static final java.lang.String KEY_VIDEO_HYPER_LAPSE_MENU = "pref_video_hyper_lapse_key";
    public static final java.lang.String KEY_VIDEO_NOISE_FILTER = "pref_video_noise_filter_key";
    public static final java.lang.String KEY_VIDEO_RATIO_FPS = "pref_video_ratio_key";
    public static final java.lang.String KEY_VIDEO_SELL_EIS = "pref_video_sell_eis";
    public static final java.lang.String KEY_VIDEO_SIZE = "pref_video_size_key";
    public static final java.lang.String KEY_VIDEO_SOUND_EFFECT_KEY = "pref_video_sound_effect_key";
    public static final java.lang.String KEY_VIDEO_SOUND_FRONT = "pref_sound_types_key_front";
    public static final java.lang.String KEY_VIDEO_SOUND_KEY = "pref_video_sound_key";
    public static final java.lang.String KEY_VIDEO_SOUND_MODE = "pref_sound_mode_types_key";
    public static final java.lang.String KEY_VIDEO_SOUND_REAR = "pref_sound_types_key_rear";
    public static final java.lang.String KEY_VIDEO_SUPER_EIS_MENU = "pref_video_super_eis_key";
    public static final java.lang.String KEY_VIVID_EFFECT = "pref_camera_vivid_effect_key";
    public static final java.lang.String KEY_VOLUME_KEY_FUNCTION = "pref_volume_key_function_key";
    public static final java.lang.String KEY_WATERMARK_DEVICE = "pref_watermark_device";
    public static final java.lang.String KEY_WATERMARK_SETTING_IMAGE = "pref_watermark_setting_key";
    public static final java.lang.String KEY_XPAN_EXPOSURE = "pref_hasselblad_xpan_exposure_key";
    public static final java.lang.String KEY_XPAN_SWITCH_CAMERA_BAR = "pref_hasselblad_xpan_switch_camera_bar_key";
    public static final java.lang.String KEY_ZOOM = "pref_zoom_key";
    public static final java.lang.String KEY_ZOOM_FROM_OTHER_APP = "pref_zoom_from_other_program_code";
    public static final java.lang.String KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT = "key_zoom_wide_angle_open_default";
    public static final java.lang.String PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED = "pref_face_beauty_filter_recommend_icon_clicked";
    public static final java.lang.String PRE_FACE_BEAUTY_ICON_RECEOMMEND_CLICKED = "pref_face_beauty_recommend_icon_clicked";
    public static final java.lang.String PRE_KEY_LEGACY_WATERMARK_TIME = "pref_watermark_time";
    public static final java.lang.String PRE_KEY_WATERMARK_DATE_AND_TIME = "pref_watermark_date_and_time";
    public static final java.lang.String PRE_KEY_WATERMARK_LOCATION = "pref_watermark_location";
    public static final java.lang.String PRE_KEY_WATERMARK_PHONE = "pref_watermark_phone";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_AUTHOR = "pref_watermark_author_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO = "pref_watermark_display_info_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN = "pref_watermark_first_open_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_FUNCTION = "pref_watermark_function_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION = "pref_watermark_makeup_function_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_MAKEUP_PREVIEW = "pref_watermark_makeup_preview_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_POSITION = "pref_watermark_position_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_PREVIEW = "pref_watermark_preview_key";
    public static final java.lang.String PRE_KEY_WATERMARK_VISUAL_SIZE = "pref_watermark_size_key";
    public static final java.lang.String PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED = "pref_recommended_menu_filter_icon_clicked_key";
    public static final java.lang.String SHOW_ARROW_ANIMATION = "show_arrow_animation";
    public static final java.lang.String[] KEY_STICKER_CUSTOM_FACEBEAUTY = {"key_beauty_custom_sticker_exfoliating", "key_beauty_custom_sticker_thin_face", "key_beauty_custom_sticker_big_eye", "key_beauty_custom_sticker_thin_nasal", "key_beauty_custom_sticker_chin", "key_beauty_custom_sticker_little_face", "key_beauty_custom_sticker_makeup", "key_beauty_custom_sticker_3d"};
    public static final java.lang.String[] KEY_COMMON_CUSTOM_BEAUTY = {"key_beauty_custom_common_exfoliating", "key_beauty_custom_common_thin_face", "key_beauty_custom_common_big_eye", "key_beauty_custom_common_thin_nasal", "key_beauty_custom_common_chin", "key_beauty_custom_common_little_face", "key_beauty_custom_common_makeup", "key_beauty_custom_common_3d"};
    public static final java.lang.String[] KEY_PORTRAIT_CUSTOM_BEAUTY = {"key_beauty_custom_portrait_exfoliating", "key_beauty_custom_portrait_thin_face", "key_beauty_custom_portrait_big_eye", "key_beauty_custom_portrait_thin_nasal", "key_beauty_custom_portrait_chin", "key_beauty_custom_portrait_little_face", "key_beauty_custom_portrait_makeup", "key_beauty_custom_portrait_3d"};
    public static final java.lang.String[] KEY_VIDEO_CUSTOM_BEAUTY = {"key_beauty_custom_video_exfoliating", "key_beauty_custom_video_thin_face", "key_beauty_custom_video_big_eye", "key_beauty_custom_video_thin_nasal", "key_beauty_custom_video_chin", "key_beauty_custom_video_little_face", "key_beauty_custom_video_makeup", "key_beauty_custom_video_3d"};
    public static final java.lang.String[] KEY_NIGHT_CUSTOM_BEAUTY = {"key_beauty_custom_night_exfoliating", "key_beauty_custom_night_thin_face", "key_beauty_custom_night_big_eye", "key_beauty_custom_night_thin_nasal", "key_beauty_custom_night_chin", "key_beauty_custom_night_little_face", "key_beauty_custom_night_makeup", "key_beauty_custom_night_3d"};
    public static final java.lang.String[] KEY_GROUPSHOT_CUSTOM_BEAUTY = {"key_beauty_custom_night_exfoliating", "key_beauty_custom_night_thin_face", "key_beauty_custom_night_big_eye", "key_beauty_custom_night_thin_nasal", "key_beauty_custom_night_chin", "key_beauty_custom_night_little_face", "key_beauty_custom_night_makeup", "key_beauty_custom_night_3d"};
    public static final java.lang.String[] KEY_MULTI_VIDEO_CUSTOM_BEAUTY = {"key_beauty_custom_multi_video_exfoliating", "key_beauty_custom_multi_video_thin_face", "key_beauty_custom_multi_video_big_eye", "key_beauty_custom_multi_video_thin_nasal", "key_beauty_custom_multi_video_chin", "key_beauty_custom_multi_video_little_face", "key_beauty_custom_multi_video_makeup", "key_beauty_custom_multi_video_3d"};
    public static final java.lang.String[] KEY_IDPHOTO_CUSTOM_BEAUTY = {"key_beauty_custom_idphoto_exfoliating", "key_beauty_custom_idphoto_thin_face", "key_beauty_custom_idphoto_big_eye", "key_beauty_custom_idphoto_thin_nasal", "key_beauty_custom_idphoto_chin", "key_beauty_custom_idphoto_little_face", "key_beauty_custom_idphoto_makeup", "key_beauty_custom_idphoto_3d"};
    public static final java.lang.String[] KEY_TIMELAPSE_PRO_TEMPLATES = {"key_timelapse_pro_no_template", "key_timelapse_pro_car_template", "key_timelapse_pro_star_template", "key_timelapse_pro_cloud_template"};

    void A_renamed(boolean z_renamed);

    boolean A_renamed();

    void B_renamed(boolean z_renamed);

    boolean B_renamed();

    void C_renamed();

    void C_renamed(boolean z_renamed);

    void D_renamed();

    void D_renamed(boolean z_renamed);

    void E_renamed();

    void E_renamed(boolean z_renamed);

    void F_renamed();

    void F_renamed(boolean z_renamed);

    void G_renamed();

    void G_renamed(boolean z_renamed);

    void H_renamed();

    void H_renamed(boolean z_renamed);

    com.oplus.camera.ui.preview.a_renamed.p_renamed I_renamed();

    void I_renamed(boolean z_renamed);

    void J_renamed();

    void J_renamed(boolean z_renamed);

    void K_renamed(boolean z_renamed);

    boolean K_renamed();

    void L_renamed();

    void L_renamed(boolean z_renamed);

    void M_renamed();

    void M_renamed(boolean z_renamed);

    void N_renamed();

    void N_renamed(boolean z_renamed);

    void O_renamed(boolean z_renamed);

    boolean O_renamed();

    void P_renamed(boolean z_renamed);

    boolean P_renamed();

    void Q_renamed(boolean z_renamed);

    boolean Q_renamed();

    void R_renamed(boolean z_renamed);

    boolean R_renamed();

    boolean S_renamed();

    boolean T_renamed();

    void U_renamed();

    void V_renamed();

    boolean W_renamed();

    boolean X_renamed();

    boolean Y_renamed();

    boolean Z_renamed();

    com.oplus.camera.gl_renamed.GLRootView a_renamed();

    void a_renamed(int i_renamed);

    void a_renamed(int i_renamed, int i2);

    void a_renamed(int i_renamed, int i2, int i3, java.lang.Object... objArr);

    void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3);

    void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, int i3);

    void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5);

    void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, boolean z7);

    void a_renamed(int i_renamed, int i2, java.lang.Object... objArr);

    void a_renamed(int i_renamed, long j_renamed, long j2);

    void a_renamed(int i_renamed, java.lang.String str);

    void a_renamed(int i_renamed, boolean z_renamed);

    void a_renamed(int i_renamed, boolean z_renamed, boolean z2);

    void a_renamed(long j_renamed);

    void a_renamed(long j_renamed, long j2, boolean z_renamed);

    void a_renamed(long j_renamed, long j2, boolean z_renamed, boolean z2, long j3);

    void a_renamed(long j_renamed, boolean z_renamed);

    void a_renamed(android.content.DialogInterface.OnCancelListener onCancelListener);

    void a_renamed(android.view.View.OnClickListener onClickListener);

    void a_renamed(android.view.View.OnClickListener onClickListener, boolean z_renamed, boolean z2);

    void a_renamed(android.view.View view, int i_renamed, int i2, int i3);

    void a_renamed(android.view.View view, java.lang.String str, int i_renamed, boolean z_renamed);

    void a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar, boolean z_renamed, boolean z2, java.lang.String str);

    void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar);

    void a_renamed(com.oplus.camera.ui.MicroscopeHintView.a_renamed aVar, boolean z_renamed, int i_renamed);

    void a_renamed(com.oplus.camera.ui.control.b_renamed bVar);

    void a_renamed(com.oplus.camera.ui.control.b_renamed bVar, boolean z_renamed);

    void a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed dVar, boolean z_renamed);

    void a_renamed(com.oplus.camera.ui.control.e_renamed eVar, int i_renamed);

    void a_renamed(com.oplus.camera.ui.q_renamed qVar);

    void a_renamed(java.lang.Float f_renamed, int i_renamed, boolean z_renamed, boolean z2);

    void a_renamed(java.lang.String str);

    void a_renamed(java.lang.String str, int i_renamed);

    void a_renamed(java.lang.String str, java.lang.String str2);

    void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void a_renamed(java.lang.String str, boolean z_renamed);

    void a_renamed(java.lang.String str, boolean z_renamed, int i_renamed, int i2);

    void a_renamed(java.lang.String str, java.lang.String... strArr);

    void a_renamed(java.util.List<java.lang.Integer> list, long j_renamed);

    void a_renamed(boolean z_renamed);

    void a_renamed(boolean z_renamed, java.lang.String str);

    void a_renamed(boolean z_renamed, boolean z2);

    void a_renamed(boolean z_renamed, boolean z2, boolean z3);

    void a_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4);

    void a_renamed(int... iArr);

    boolean aA_renamed();

    void aB_renamed();

    void aC_renamed();

    void aD_renamed();

    void aE_renamed();

    void aF_renamed();

    boolean aG_renamed();

    void aH_renamed();

    void aI_renamed();

    void aJ_renamed();

    void aK_renamed();

    void aL_renamed();

    void aM_renamed();

    void aN_renamed();

    void aO_renamed();

    void aP_renamed();

    boolean aQ_renamed();

    void aR_renamed();

    void aS_renamed();

    void aT_renamed();

    boolean aU_renamed();

    java.lang.String aV_renamed();

    boolean aW_renamed();

    int aX_renamed();

    com.oplus.camera.timelapsepro.g_renamed aY_renamed();

    void aZ_renamed();

    int aa_renamed();

    void ab_renamed();

    void ac_renamed();

    boolean ad_renamed();

    boolean ae_renamed();

    boolean af_renamed();

    boolean ag_renamed();

    void ah_renamed();

    void ai_renamed();

    void aj_renamed();

    void ak_renamed();

    void al_renamed();

    int am_renamed();

    int an_renamed();

    android.net.Uri ao_renamed();

    boolean ap_renamed();

    java.lang.String aq_renamed();

    void ar_renamed();

    void as_renamed();

    void at_renamed();

    void au_renamed();

    boolean av_renamed();

    boolean aw_renamed();

    boolean ax_renamed();

    boolean ay_renamed();

    android.graphics.Rect az_renamed();

    android.view.ViewGroup b_renamed();

    void b_renamed(int i_renamed);

    void b_renamed(int i_renamed, int i2);

    void b_renamed(int i_renamed, int i2, int i3, java.lang.Object... objArr);

    void b_renamed(int i_renamed, boolean z_renamed);

    void b_renamed(long j_renamed);

    void b_renamed(java.lang.String str);

    void b_renamed(java.lang.String str, int i_renamed);

    void b_renamed(java.lang.String str, java.lang.String str2);

    void b_renamed(java.lang.String str, boolean z_renamed);

    void b_renamed(java.lang.String str, java.lang.String... strArr);

    void b_renamed(boolean z_renamed);

    void b_renamed(boolean z_renamed, boolean z2);

    void b_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4);

    void b_renamed(int... iArr);

    void ba_renamed();

    void bb_renamed();

    int bc_renamed();

    boolean bd_renamed();

    boolean be_renamed();

    com.oplus.camera.ui.preview.h_renamed c_renamed();

    void c_renamed(int i_renamed);

    void c_renamed(int i_renamed, int i2);

    void c_renamed(int i_renamed, boolean z_renamed);

    void c_renamed(java.lang.String str);

    void c_renamed(java.lang.String str, int i_renamed);

    void c_renamed(java.lang.String str, boolean z_renamed);

    void c_renamed(boolean z_renamed);

    void c_renamed(boolean z_renamed, boolean z2);

    void c_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4);

    void d_renamed(int i_renamed);

    void d_renamed(int i_renamed, int i2);

    void d_renamed(int i_renamed, boolean z_renamed);

    void d_renamed(java.lang.String str);

    void d_renamed(java.lang.String str, int i_renamed);

    void d_renamed(java.lang.String str, boolean z_renamed);

    void d_renamed(boolean z_renamed);

    void d_renamed(boolean z_renamed, boolean z2);

    boolean d_renamed();

    void e_renamed(int i_renamed);

    void e_renamed(int i_renamed, boolean z_renamed);

    void e_renamed(java.lang.String str);

    void e_renamed(boolean z_renamed);

    void e_renamed(boolean z_renamed, boolean z2);

    boolean e_renamed();

    boolean e_renamed(int i_renamed, int i2);

    void f_renamed(int i_renamed);

    void f_renamed(int i_renamed, boolean z_renamed);

    void f_renamed(java.lang.String str);

    void f_renamed(boolean z_renamed);

    void f_renamed(boolean z_renamed, boolean z2);

    boolean f_renamed();

    void g_renamed(int i_renamed);

    void g_renamed(java.lang.String str);

    void g_renamed(boolean z_renamed);

    void g_renamed(boolean z_renamed, boolean z2);

    boolean g_renamed();

    com.oplus.camera.ui.menu.setting.CameraMenuOption h_renamed(java.lang.String str);

    void h_renamed(int i_renamed);

    void h_renamed(boolean z_renamed);

    void h_renamed(boolean z_renamed, boolean z2);

    boolean h_renamed();

    void i_renamed();

    void i_renamed(int i_renamed);

    void i_renamed(boolean z_renamed);

    void i_renamed(boolean z_renamed, boolean z2);

    void j_renamed();

    void j_renamed(int i_renamed);

    void j_renamed(boolean z_renamed);

    void j_renamed(boolean z_renamed, boolean z2);

    com.oplus.camera.ui.a_renamed.a_renamed k_renamed();

    void k_renamed(int i_renamed);

    void k_renamed(boolean z_renamed);

    void k_renamed(boolean z_renamed, boolean z2);

    java.lang.String l_renamed();

    void l_renamed(int i_renamed);

    void l_renamed(boolean z_renamed);

    void l_renamed(boolean z_renamed, boolean z2);

    int m_renamed();

    void m_renamed(int i_renamed);

    void m_renamed(boolean z_renamed);

    void m_renamed(boolean z_renamed, boolean z2);

    void n_renamed();

    void n_renamed(int i_renamed);

    void n_renamed(boolean z_renamed);

    void n_renamed(boolean z_renamed, boolean z2);

    void o_renamed();

    void o_renamed(int i_renamed);

    void o_renamed(boolean z_renamed);

    void o_renamed(boolean z_renamed, boolean z2);

    android.widget.RelativeLayout p_renamed();

    void p_renamed(int i_renamed);

    void p_renamed(boolean z_renamed);

    void p_renamed(boolean z_renamed, boolean z2);

    android.graphics.RectF q_renamed(int i_renamed);

    void q_renamed();

    void q_renamed(boolean z_renamed);

    void q_renamed(boolean z_renamed, boolean z2);

    int r_renamed();

    void r_renamed(int i_renamed);

    void r_renamed(boolean z_renamed);

    void r_renamed(boolean z_renamed, boolean z2);

    int s_renamed();

    void s_renamed(int i_renamed);

    void s_renamed(boolean z_renamed);

    void s_renamed(boolean z_renamed, boolean z2);

    void t_renamed();

    void t_renamed(int i_renamed);

    void t_renamed(boolean z_renamed);

    void t_renamed(boolean z_renamed, boolean z2);

    void u_renamed();

    void u_renamed(int i_renamed);

    void u_renamed(boolean z_renamed);

    void u_renamed(boolean z_renamed, boolean z2);

    void v_renamed();

    void v_renamed(int i_renamed);

    void v_renamed(boolean z_renamed);

    void w_renamed();

    void w_renamed(int i_renamed);

    void w_renamed(boolean z_renamed);

    void x_renamed();

    void x_renamed(boolean z_renamed);

    java.lang.String y_renamed();

    void y_renamed(boolean z_renamed);

    void z_renamed();

    void z_renamed(boolean z_renamed);
}
