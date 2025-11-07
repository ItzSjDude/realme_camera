package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public final class CameraParameter {
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<android.graphics.RectF> AE_REGIONS;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<android.graphics.RectF> AF_REGIONS;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> AI_HIGH_PIXEL_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Integer> AI_NIGHT_VIDEO_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> AI_PHOTO;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> ALGO_VISUALIZATION_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> ANTI_BANDING_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.util.HashMap> APS_PROC_TIMER;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<float[]> BLUR_LEVEL;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> BLUR_LEVEL_RANGE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> BURST_SHOT_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Long> BURST_SHOT_FLAG_ID;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> BURST_SHOT_PATH;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> CAPTURE_FAIL_CODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> CAPTURE_FLIP_MODE_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> CAPTURE_FOR_VIDEO;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> CAPTURE_HDR_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> CAPTURE_RESULT_FIRST_EXPOSURE_TIME;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> CAPTURE_RESULT_NIGHT_TOTAL_EXPTIME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Long> CAPTURE_TIME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> CAPTURE_WITH_DETACH;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]> COLOR_TEMPERATURE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> COLOR_TEMPERATURE_RANGE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_ALTITUDE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_ALTITUDE_REF;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_APERTURE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_BRIGHTNESS;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_COLOR_SPACE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_COMMENTS;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_COMPONENT_CONFIG;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_DATE_TIME;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_EXPOSURE_BIAS;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_EXPOSURE_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_EXPOSURE_PROGRAM;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_EXP_TIME;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_FLASH_PIX_VERSION;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_FLASH_VALUE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_FOCAL_LENGTH;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_FOCAL_LENGTH_35MM;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_GPS_DATE_STAMP;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object[]> EXIF_GPS_TIME_STAMP;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_HEIC_QUALITY;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_IMAGE_HEIGHT;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_IMAGE_WIDTH;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_INTEROP_INDEX_STR;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_INTEROP_VERSION;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> EXIF_ISO;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object[]> EXIF_LATITUDE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_LATITUDE_REF;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object[]> EXIF_LONGITUDE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_LONGITUDE_REF;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_MAKER_NOTE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_MANUFACTURE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_MAX_APERTURE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_METERING_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> EXIF_MIRROR;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_MODEL;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_NUMBER;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_ROTATE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_SCENE_CAPTURE_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_SCENE_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_SENSING_METHOD;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_SENSOR_NAME;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_SHUTTER_SPEED;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_SUB_DATE_TIME;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> EXIF_SUPPORT_DCIP3;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> EXIF_SUPPORT_LOCATION;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> EXIF_SUPPORT_LOCATION_TIME_STAMP;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_TIFFX_RESOLUTIION;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_TIFFYCRCB_POSITIONING;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> EXIF_TIFFY_RESOLUTION;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_TIFF_RESOLUTION_UNIT;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> EXIF_VERSION;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> EXIF_WHITE_BALANCE_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> FACE_BEAUTY_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]> FACE_BEAUTY_PARAM;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> FACE_BEAUTY_VERSION;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> FACE_DERED_EYE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> FACE_RECTIFY_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> FILTER_OPEN;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> FILTER_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> FILTER_WITHVIGNETTE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> FISH_EYE_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> FLASH_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> FOCUS_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> FOCUS_PEAKING_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> FRAME_FLAG;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]> HASSELBLAD_XPAN_CROP_REGION;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> HAS_SUPER_TEXT_RESULT;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> HEIF_PROCESS_IN_APS;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> HIGH_PICTURE_SIZE_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Byte> HVXSHDR_MODE_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> HYPER_LAPSE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> IMAGE_CATEGORY_BURST_COUNT;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> IMAGE_CATEGORY_BURST_SHOT;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> IMAGE_CATEGORY_BURST_SHOT_FLAG_ID;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> IMAGE_CATEGORY_CSHOT_PATH;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<int[]> IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> IMAGE_CATEGORY_DATE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> IMAGE_CATEGORY_END_OF_CAPTURE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> IMAGE_CATEGORY_FORMAT;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> IMAGE_CATEGORY_HEIGHT;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> IMAGE_CATEGORY_IMAGE_TIME_STAMP;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> IMAGE_CATEGORY_IS_VALID;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> IMAGE_CATEGORY_MERGE_IDENTITY;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> IMAGE_CATEGORY_META_TIME_STAMP;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> IMAGE_CATEGORY_REC_BURST_NUMBER;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> IMAGE_CATEGORY_SUPER_TEXT_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.String> IMAGE_CATEGORY_WATERMARK_PATH;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> IMAGE_CATEGORY_WIDTH;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> IS_FROM_MAIN_MENU;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> KEY_ALGO_VISUALIZATION_KEY;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> KEY_ALGO_VISUALIZATION_VALUE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<byte[]> KEY_CALLER_PACKAGE_NAME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> KEY_CAMERA_RESULT_APS_INIT_FINISH;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Long> KEY_CAMERA_RESULT_REF_TIMESTAMP;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Integer> KEY_DUAL_SCENE_MASTER;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> KEY_EDGE_FILTER_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String[]> KEY_EDGE_FILTER_PARAM;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Integer> KEY_EXPLORER_CHIP_STATE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> KEY_EXPLORER_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> KEY_GESTURE_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Boolean> KEY_IS_FROM_MAIN_MENU;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Byte> KEY_MOVIE_HDR_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Byte> KEY_MOVIE_LOG_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> KEY_NIGHT_OFFLINE_R2Y;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<byte[]> KEY_REQUEST_ZSL_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> KEY_SINGLE_BLUR_ALGONAME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> KEY_SINGLE_BLUR_LEVEL;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float> KEY_SINGLE_BLUR_SHOW;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> KEY_SINGLE_PORTRAIT_EFFECT_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Float> KEY_ZOOM_RATION_CONFIGURE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Integer> MAKEUP_STATE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> MAKEUP_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> MAKEUP_VALUE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> MESH_PTR;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> MIRROR_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> MONO_FILTER_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Byte> MOVIE_HDR_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Byte> MOVIE_LOG_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> NOISE_REDUCTION_STRENGTH;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> PHOTO_10BIT_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]> PICTURE_EXIF_FLAG;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Long> PICTURE_IDENTITY;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> PICTURE_VISUALIZATION_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> PORTAIT_BODY_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> PORTAIT_BOKEH_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> PORTRAIT_NEON_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> PORTRAIT_STREAMER_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> PREVIEW_AIS_BRACKET;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> PREVIEW_AIS_DCT_AINR_SUPPORT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> PREVIEW_AIS_DCT_SUPPORT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]> PREVIEW_BRACKET_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> PREVIEW_IN_PREVIEW_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_ACTIVE_MAP;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_AICOLOR;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_AIS_STATE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_AI_SCENE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Boolean> PREVIEW_RESULT_AI_SHUTTER;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String[]> PREVIEW_RESULT_ALGO_FLAG;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_ANTIBANDING;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_ASD;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_BOKEN_STATE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_BRACKET_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_CAMERA_ID;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<android.media.Image> PREVIEW_RESULT_CAMERA_IMAGE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_CAMERA_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_CAMERA_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<int[]> PREVIEW_RESULT_CAPTURE_EV_LIST;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_CROP_BOTTOM;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_CROP_LEFT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_CROP_RIGHT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_CROP_TOP;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_DRAWTEXT_BRACKET_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_DRAWTEXT_FEATURE_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_DRAWTEXT_HDR_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_DRAWTEXT_SCENE_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_FEATURE_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_FRAME_ID;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_GESTURE_ACTION_TYPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<android.hardware.HardwareBuffer> PREVIEW_RESULT_HARDWARE_BUFFER;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_HDR_SCOPE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_HEIGHT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Long> PREVIEW_RESULT_IDENTITY;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Boolean> PREVIEW_RESULT_IMAGE_IS_VALID;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Long> PREVIEW_RESULT_IMAGE_TIME_STAMP;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_LAST_VDIEO_FRAME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_LENS_DIRTY;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_LSD;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_MASTER_CAMERA_ID;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_MASTER_PIPELINE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_META_INDEX;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_MFSR_FRAME_COUNT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_MOTION_DETECTED;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_MULTI_FRAME_COUNT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_NIGHT_TOTAL_EXPTIME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_OFFLINE_NIGHT_EXPTIME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_PF;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_RECTIFY;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_REQUEST_FORMAT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_RTB;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_SCENE_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<int[]> PREVIEW_RESULT_SENSOR_MASK;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_SHOW_HDR_ICON;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_START_INTERPOLATION_FRAME;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_SUPER_NIGHT_SCENE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_SUPPORT_ZOOM_FEATURE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_THUMBNAIL_INDEX;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_TUNING_SCENE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_VIDEO_EIS;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.String> PREVIEW_RESULT_VIDEO_HYPERLAPSE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewResultKey<java.lang.Integer> PREVIEW_RESULT_WIDTH;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> QUICK_JPEG;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Boolean> QUICK_JPEG_SWITCH;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> QUICK_VIDEO_RECORD_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> RAW_CONTROL;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> REAR_MIRROR_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Object> REQUEST_TAG;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Boolean> RESULT_CAPTURE_FOR_VIDEO;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Object> RESULT_REQUEST_TAG;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float> SAT_NONE_ZOOM_RATIO;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<int[]> SESSION_REQUEST_CROP_REGION;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Long> SHUTTER_BUTTON_CLICK_TIME;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> SLOW_VIDEO_INTELLIGENT_HIGH_FRAME_ENABLE;

    @java.lang.Deprecated
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<android.graphics.RectF> SLOW_VIDEO_MOTION_DETECT_COORDINATE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> STARBURST_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> STAR_VIDEO_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> SUPER_CLEAR_PORTRAIT_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> SUPER_TEXT_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> SUPER_TEXT_HEIGHT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> SUPER_TEXT_VERTICES;
    public static final com.oplus.ocs.camera.CameraParameter.CaptureResultKey<java.lang.Integer> SUPER_TEXT_WIDTH;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> TILT_SHIFT_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle> TILT_SHIFT_PARAM;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> TORCH_FLASH_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> TRIPOD_MODE_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> ULTRA_HIGH_RESOLUTION_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_10BIT_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_3HDR_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.Integer> VIDEO_BITRATE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_BLUR;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> VIDEO_BLUR_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> VIDEO_BLUR_PARAMS;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<android.util.Range> VIDEO_DYNAMIC_FPS;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle> VIDEO_EFFECT_PARAM;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> VIDEO_EIS_RECORD_STATE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_ENCODER;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_FOVC_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_FPS;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer> VIDEO_FUSION_EFFECT;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> VIDEO_NEON_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> VIDEO_NEON_PARAMS;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_NIGHT_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> VIDEO_RETENTION_OPEN;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> VIDEO_STABILIZATION_MODE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String> WATERMARK_CAPTURE_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle> WATERMARK_PARAM;
    public static final com.oplus.ocs.camera.CameraParameter.ConfigureKey<java.lang.String> WATERMARK_VIDEO_ENABLE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean> ZOOM_ACTIVE;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float> ZOOM_RATIO;
    public static final com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float> ZOOM_TARGET;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AiNightVideoValues {
        public static final int AI_NIGHT_VIDEO_OFF = 0;
        public static final int AI_NIGHT_VIDEO_ON = 1;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AiStablizationValues {
        public static final int AI_STABLIZATION_VIDEO_OFF = 0;
        public static final int AI_STABLIZATION_VIDEO_ON = 1;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BokehType {
        public static final java.lang.String SINGLE_BOKEH = "single_bokeh";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CaptureFailCode {
        public static final int MEMORY_NOT_ENOUGH = 1;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CommonByteStateValue {
        public static final byte OFF = 0;
        public static final byte ON_renamed = 1;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CommonStateValue {
        public static final java.lang.String AUTO = "auto";
        public static final java.lang.String OFF = "off";
        public static final java.lang.String ON_renamed = "on_renamed";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FlashMode {
        public static final java.lang.String FLASH_AUTO = "auto";
        public static final java.lang.String FLASH_OFF = "off";
        public static final java.lang.String FLASH_ON = "on_renamed";
        public static final java.lang.String FLASH_TORCH = "torch";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FocusMode {
        public static final int AF_MODE_AUTO = 3;
        public static final int AF_MODE_CONTINUOUS_PICTURE = 1;
        public static final int AF_MODE_CONTINUOUS_VIDEO = 2;
        public static final int AF_MODE_LOCK = 4;
        public static final int AF_MODE_OFF = 0;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface HyperLapse {
        public static final java.lang.String HYPER_LAPSE = "hyper_lapse";
        public static final java.lang.String OFF = "off";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MonoFilterType {
        public static final java.lang.String BLACK_WHITE = "black_white";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface NightVideo {
        public static final java.lang.String NORMAL_NIGHT_VIDEO = "normal_night_video";
        public static final java.lang.String ULTRA_NIGHT_VIDEO = "ultra_night_video";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PortraitBodyType {
        public static final java.lang.String FULL_BODY = "full_body";
        public static final java.lang.String HALF_BODY = "half_body";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RawValue {
        public static final java.lang.String NONE = "none";
        public static final java.lang.String RAW = "raw";
        public static final java.lang.String SUPER_RAW = "super_raw";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RecordingState {
        public static final int RECORDING_PAUSE = 2;
        public static final int RECORDING_RESUME = 3;
        public static final int RECORDING_START = 1;
        public static final int RECORDING_STOP = 4;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TiltShiftParamKeys {
        public static final java.lang.String BLUR_VALUE = "blurValue";
        public static final java.lang.String CENTER_POSITION = "centerPosition";
        public static final java.lang.String CLEAR_DISTANCE = "clearDistance";
        public static final java.lang.String PREVIEW_SIZE = "previewSize";
        public static final java.lang.String ROTATE_ANGLE = "rotateAngle";
        public static final java.lang.String TYPE = "type";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoEffectParamKeys {
        public static final java.lang.String BLUR_LEVEL = "blur_level";
        public static final java.lang.String BLUR_SHOW = "blur_show";
        public static final java.lang.String RETENTION_PROCESS = "retention_process";
        public static final java.lang.String VIDEO_ORIENTATION = "orientation";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoEncoder {
        public static final java.lang.String H264 = "H264";
        public static final java.lang.String H265 = "H265";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoFps {
        public static final int FPS_120 = 120;
        public static final int FPS_240 = 240;
        public static final int FPS_30 = 30;
        public static final int FPS_480 = 480;
        public static final int FPS_60 = 60;
        public static final int FPS_960 = 960;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoFpsValue {
        public static final java.lang.String VIDEO_FPS_120 = "video_120fps";
        public static final java.lang.String VIDEO_FPS_240 = "video_240fps";
        public static final java.lang.String VIDEO_FPS_30 = "video_30fps";
        public static final java.lang.String VIDEO_FPS_480 = "video_480fps";
        public static final java.lang.String VIDEO_FPS_60 = "video_60fps";
        public static final java.lang.String VIDEO_FPS_960 = "video_960fps";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoStabilizationMode {
        public static final java.lang.String SUPER_STABILIZATION = "super_stabilization";
        public static final java.lang.String SUPER_STABILIZATION_FRONT = "super_stabilization_front";
        public static final java.lang.String VIDEO_STABILIZATION = "video_stabilization";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface WaterMarkParamKeys {
        public static final java.lang.String FILE_PATH = "filePath";
        public static final java.lang.String INPUT_WIDTH = "inputWidth";
        public static final java.lang.String MAKEUP_ENABLE = "makeupEnable";
        public static final java.lang.String MAKEUP_HEIGHT = "makeupHeight";
        public static final java.lang.String MAKEUP_START_X = "makeupStartX";
        public static final java.lang.String MAKEUP_START_Y = "makeupStartY";
        public static final java.lang.String MAKEUP_WIDTH = "makeupWidth";
        public static final java.lang.String NEED_SCALE = "needScale";
        public static final java.lang.String ORIENTATION = "orientation";
        public static final java.lang.String REF_WIDTH = "refWidth";
        public static final java.lang.String SIZE = "size";
        public static final java.lang.String WATERMARK_BORDER_X = "watermark_border_x";
        public static final java.lang.String WATERMARK_BORDER_Y = "watermark_border_y";
        public static final java.lang.String YUV_BUFFER = "buffer";
    }

    static {
        com.oplus.ocs.camera.CameraParameter.SceneLoader_2 anonymousClass1 = null;
        VIDEO_FPS = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.fps", java.lang.String.class);
        VIDEO_DYNAMIC_FPS = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.dynamic.fps", android.util.Range.class);
        VIDEO_STABILIZATION_MODE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.stabilization", java.lang.String.class);
        VIDEO_3HDR_MODE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.3hdr", java.lang.String.class);
        VIDEO_NIGHT_MODE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.night", java.lang.String.class);
        VIDEO_10BIT_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.feature.video.10bit.enable", java.lang.String.class);
        java.lang.String str = "com.oplus.video.blur.enable";
        VIDEO_BLUR = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>(str, java.lang.String.class);
        PHOTO_10BIT_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.feature.photo.10bit.enable", java.lang.String.class);
        HIGH_PICTURE_SIZE_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.feature.photo.highPicture.enable", java.lang.String.class);
        AI_HIGH_PIXEL_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.feature.ai_renamed.high.pixel.enable", java.lang.String.class);
        KEY_EXPLORER_CHIP_STATE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.explorer.chip.state", java.lang.Integer.class);
        KEY_EXPLORER_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.explorer.enable", java.lang.String.class);
        MAKEUP_STATE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.makeup.state", java.lang.Integer.class);
        ANTI_BANDING_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.feature.antibanding.enable", java.lang.String.class);
        MIRROR_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.feature.mirror.enable", java.lang.String.class);
        WATERMARK_VIDEO_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.camera.watermark.video.enable", java.lang.String.class);
        VIDEO_FOVC_MODE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.fovc", java.lang.String.class);
        VIDEO_ENCODER = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.encoder", java.lang.String.class);
        VIDEO_BITRATE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.video.bitrate", java.lang.Integer.class);
        PORTAIT_BOKEH_TYPE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.portrait.bokeh.type", java.lang.String.class);
        PORTAIT_BODY_TYPE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.portrait.body.type", java.lang.String.class);
        HYPER_LAPSE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.configure.fastvideo.hyperLapse", java.lang.String.class);
        AI_NIGHT_VIDEO_MODE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.video.stabilization.mode", java.lang.Integer.class);
        SLOW_VIDEO_INTELLIGENT_HIGH_FRAME_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.slow.video.intelligent.high.frame.enable", java.lang.String.class);
        SLOW_VIDEO_MOTION_DETECT_COORDINATE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.slow.video.motion.detect.coordinate", android.graphics.RectF.class);
        java.lang.String str2 = "com.oplus.movie.hdr.enable";
        KEY_MOVIE_HDR_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>(str2, java.lang.Byte.TYPE);
        java.lang.String str3 = "com.oplus.movie.log.enable";
        KEY_MOVIE_LOG_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>(str3, java.lang.Byte.TYPE);
        SESSION_REQUEST_CROP_REGION = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.multicamfeature.multiCamConfigScalerCropRegion", int[].class);
        TORCH_FLASH_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.torch.flash.enable", java.lang.String.class);
        QUICK_JPEG_SWITCH = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.quick.jpeg.switch", java.lang.Boolean.class);
        HVXSHDR_MODE_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.hvxshdr.mode.enable", java.lang.Byte.TYPE);
        PORTRAIT_STREAMER_ENABLE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.portrait.streamer.enable", java.lang.String.class);
        KEY_CALLER_PACKAGE_NAME = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.caller.package.name", byte[].class);
        KEY_REQUEST_ZSL_MODE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.control.capture.zsl.mode", byte[].class);
        MONO_FILTER_TYPE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.mono.filter.type", java.lang.String.class);
        KEY_DUAL_SCENE_MASTER = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.dualscene.master", java.lang.Integer.class);
        KEY_ZOOM_RATION_CONFIGURE = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.original.zoomRatio", java.lang.Float.class);
        KEY_IS_FROM_MAIN_MENU = new com.oplus.ocs.camera.CameraParameter.ConfigureKey<>("com.oplus.camera.is_renamed.from.main.menu", java.lang.Boolean.class);
        CAPTURE_HDR_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.capture.hdrMode", java.lang.String.class);
        FLASH_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.flash.mode", java.lang.String.class);
        ZOOM_RATIO = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.zoom.ratio", java.lang.Float.class);
        ZOOM_TARGET = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.zoom.target", java.lang.Float.class);
        ZOOM_ACTIVE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.zoom.active", java.lang.Boolean.class);
        FOCUS_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.focus.mode", java.lang.Integer.class);
        AF_REGIONS = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.af_renamed.regions", android.graphics.RectF.class);
        AE_REGIONS = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.ae_renamed.regions", android.graphics.RectF.class);
        TRIPOD_MODE_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.tripod.mode", java.lang.Boolean.TYPE);
        KEY_GESTURE_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.gesture.capture.enable", java.lang.String.class);
        STARBURST_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.starburst.mode", java.lang.Boolean.TYPE);
        FISH_EYE_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.fisheye.mode", java.lang.Boolean.TYPE);
        CAPTURE_FLIP_MODE_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.flip_mode", java.lang.Boolean.TYPE);
        BLUR_LEVEL = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.bokeh.level", float[].class);
        HASSELBLAD_XPAN_CROP_REGION = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.opx.CropInfo", int[].class);
        BLUR_LEVEL_RANGE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.blur.level.range", java.lang.Integer.class);
        SAT_NONE_ZOOM_RATIO = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.sat.none.zoom.ratio", java.lang.Float.class);
        SUPER_TEXT_VERTICES = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.super.text.vertices", java.lang.String.class);
        SUPER_TEXT_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.super.text.enable", java.lang.Boolean.class);
        java.lang.String str4 = "com.oplus.request.tag";
        REQUEST_TAG = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>(str4, java.lang.Object.class);
        CAPTURE_TIME = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.capture.time", java.lang.Long.class);
        WATERMARK_PARAM = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.feature.watermark.param", android.os.Bundle.class);
        AI_PHOTO = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.capture.ai_renamed", java.lang.String.class);
        ALGO_VISUALIZATION_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.algo.visualization.enable", java.lang.String.class);
        FILTER_TYPE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.filter.type", java.lang.String.class);
        FILTER_OPEN = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.filter.open", java.lang.Boolean.class);
        VIDEO_RETENTION_OPEN = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.video.retention.open", java.lang.String.class);
        MAKEUP_TYPE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.makeup.type", java.lang.String.class);
        MAKEUP_VALUE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.makeup.value", java.lang.Integer.class);
        FILTER_WITHVIGNETTE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.filter.withvignette", java.lang.Boolean.class);
        FACE_BEAUTY_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.face.beauty.enable", java.lang.String.class);
        FACE_BEAUTY_VERSION = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.face.beauty.version", java.lang.String.class);
        STAR_VIDEO_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.star.video.enable", java.lang.String.class);
        FRAME_FLAG = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.frame.flag", java.lang.Integer.class);
        CAPTURE_FOR_VIDEO = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.capture.for.video", java.lang.Boolean.class);
        REAR_MIRROR_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("rear.mirror.enable", java.lang.Boolean.class);
        SHUTTER_BUTTON_CLICK_TIME = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("shutter.button.click.time", java.lang.Long.class);
        PICTURE_VISUALIZATION_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.picture.visualization.enable", java.lang.String.class);
        FACE_BEAUTY_PARAM = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.face.param", int[].class);
        FACE_DERED_EYE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.face.dered.eye.enable", java.lang.String.class);
        BURST_SHOT_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.burst.shot.enable", java.lang.String.class);
        BURST_SHOT_PATH = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.burst.shot.path", java.lang.String.class);
        BURST_SHOT_FLAG_ID = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.burst.shot.flag.id_renamed", java.lang.Long.class);
        WATERMARK_CAPTURE_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.watermark.capture.enable", java.lang.String.class);
        COLOR_TEMPERATURE_RANGE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.color.temperature.range", java.lang.Integer.class);
        COLOR_TEMPERATURE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.color.temperature", int[].class);
        RAW_CONTROL = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.raw.control", java.lang.String.class);
        PICTURE_EXIF_FLAG = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.picture.exif.flag", int[].class);
        VIDEO_BLUR_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>(str, java.lang.String.class);
        VIDEO_EFFECT_PARAM = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.video.effect.param", android.os.Bundle.class);
        KEY_SINGLE_BLUR_ALGONAME = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.single.blur.algoname", java.lang.String.class);
        KEY_SINGLE_PORTRAIT_EFFECT_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.single.portrait.effect.mode", java.lang.Integer.class);
        KEY_SINGLE_BLUR_LEVEL = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.single.blur.level", java.lang.Integer.class);
        KEY_SINGLE_BLUR_SHOW = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.single.blur.show", java.lang.Float.class);
        FACE_RECTIFY_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.face_rectify.enable", java.lang.Boolean.class);
        TILT_SHIFT_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.tilt.shift.enable", java.lang.Boolean.class);
        TILT_SHIFT_PARAM = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.tilt.shift.param", android.os.Bundle.class);
        MOVIE_HDR_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>(str2, java.lang.Byte.class);
        MOVIE_LOG_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>(str3, java.lang.Byte.class);
        QUICK_VIDEO_RECORD_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.quick.video.record.enable", java.lang.String.class);
        PREVIEW_IN_PREVIEW_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.in_renamed.preview.enable", java.lang.String.class);
        CAPTURE_WITH_DETACH = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>(com.oplus.camera.aps.config.ConfigDataBase.KEY_CAPTURE_WITH_DETACH, java.lang.Boolean.class);
        QUICK_JPEG = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.quick.jpeg", java.lang.Boolean.class);
        VIDEO_NEON_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.video.neon.enable", java.lang.String.class);
        VIDEO_FUSION_EFFECT = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.video.fusion.status", java.lang.Integer.class);
        VIDEO_NEON_PARAMS = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.video.neon.params", java.lang.String.class);
        VIDEO_BLUR_PARAMS = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.video.blur.params", java.lang.String.class);
        SUPER_CLEAR_PORTRAIT_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.super.clear.portrait.enable", java.lang.String.class);
        ULTRA_HIGH_RESOLUTION_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.ultra.high.resolution.enable", java.lang.String.class);
        PORTRAIT_NEON_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.portrait.neon.enable", java.lang.String.class);
        FOCUS_PEAKING_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.focus.peaking.enable", java.lang.Boolean.class);
        KEY_EDGE_FILTER_ENABLE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.edge.filter.enable", java.lang.Boolean.class);
        KEY_EDGE_FILTER_PARAM = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.edge.filter.param", java.lang.String[].class);
        KEY_NIGHT_OFFLINE_R2Y = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y, java.lang.Integer.class);
        IS_FROM_MAIN_MENU = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.camera.preview.is_renamed.from.main.menu", java.lang.Boolean.class);
        VIDEO_EIS_RECORD_STATE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.eis.record.state", java.lang.Integer.class);
        PREVIEW_AIS_DCT_SUPPORT = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.ais.dct.support", java.lang.Integer.class);
        PREVIEW_AIS_DCT_AINR_SUPPORT = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.ais.dct.ainr.support", java.lang.Integer.class);
        PREVIEW_AIS_BRACKET = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.preview.ais.bracket", java.lang.Integer.class);
        PREVIEW_BRACKET_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewKey<>("com.oplus.BracketMode", int[].class);
        boolean z_renamed = false;
        int i_renamed = 0;
        HAS_SUPER_TEXT_RESULT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.super.text.has_result", java.lang.Boolean.class, z_renamed);
        SUPER_TEXT_WIDTH = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.super.text.width", java.lang.Integer.class, i_renamed);
        SUPER_TEXT_HEIGHT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.super.text.height", java.lang.Integer.class, i_renamed);
        RESULT_REQUEST_TAG = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>(str4, java.lang.Object.class, anonymousClass1);
        CAPTURE_FAIL_CODE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.capture.fail.code", java.lang.Integer.class, i_renamed);
        long j_renamed = 0L;
        java.lang.String str5 = "com.oplus.picture.identity";
        PICTURE_IDENTITY = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>(str5, java.lang.Long.class, j_renamed);
        IMAGE_CATEGORY_HEIGHT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.height", java.lang.Integer.class, i_renamed);
        IMAGE_CATEGORY_WIDTH = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.width", java.lang.Integer.class, i_renamed);
        IMAGE_CATEGORY_BURST_SHOT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.burst_shot", java.lang.Boolean.class, z_renamed);
        IMAGE_CATEGORY_BURST_COUNT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.burst_count", java.lang.Integer.class, i_renamed);
        long j2 = -1L;
        IMAGE_CATEGORY_BURST_SHOT_FLAG_ID = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.burst_shot_flag_id", java.lang.Long.class, j2);
        IMAGE_CATEGORY_CSHOT_PATH = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.cshot_path", java.lang.String.class, anonymousClass1);
        int i2 = -1;
        IMAGE_CATEGORY_REC_BURST_NUMBER = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.rec_burst_number", java.lang.Integer.class, i2);
        IMAGE_CATEGORY_DATE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.date", java.lang.Long.class, j_renamed);
        IMAGE_CATEGORY_FORMAT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.image_format", java.lang.Integer.class, i_renamed);
        IMAGE_CATEGORY_IMAGE_TIME_STAMP = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.image_time_stamp", java.lang.Long.class, j_renamed);
        IMAGE_CATEGORY_WATERMARK_PATH = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.watermark_path", java.lang.String.class, anonymousClass1);
        IMAGE_CATEGORY_MERGE_IDENTITY = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.mergeIdentity", java.lang.Long.class, j2);
        RESULT_CAPTURE_FOR_VIDEO = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.result.capture.for.video", java.lang.Boolean.class, z_renamed);
        IMAGE_CATEGORY_META_TIME_STAMP = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.meta_time_stamp", java.lang.Long.class, j_renamed);
        IMAGE_CATEGORY_SUPER_TEXT_ENABLE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.super_text_enable", java.lang.String.class, "0");
        IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.custom_beauty_param", int[].class, anonymousClass1);
        IMAGE_CATEGORY_IS_VALID = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.is_valid", java.lang.Boolean.class, z_renamed);
        IMAGE_CATEGORY_END_OF_CAPTURE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.image.category.end_of_capture", java.lang.Boolean.class, z_renamed);
        HEIF_PROCESS_IN_APS = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.result.heif_process_in_aps", java.lang.Boolean.class, z_renamed);
        NOISE_REDUCTION_STRENGTH = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.result.noise_reduction_strength", java.lang.Integer.class, i_renamed);
        APS_PROC_TIMER = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.result.aps_proc_timer", java.util.HashMap.class, new java.util.HashMap());
        MESH_PTR = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.result.mesh_ptr", java.lang.Long.class, j_renamed);
        EXIF_SENSOR_NAME = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.sensor_name", java.lang.String.class, anonymousClass1);
        EXIF_ROTATE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.rotate", java.lang.Integer.class, anonymousClass1);
        EXIF_ISO = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.iso", java.lang.Long.class, anonymousClass1);
        EXIF_WHITE_BALANCE_MODE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.white_balance_mode", java.lang.Integer.class, anonymousClass1);
        EXIF_FLASH_VALUE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.flash_value", java.lang.Integer.class, anonymousClass1);
        EXIF_LATITUDE_REF = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.latitude_ref", java.lang.String.class, anonymousClass1);
        EXIF_LONGITUDE_REF = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.longitude_ref", java.lang.String.class, anonymousClass1);
        EXIF_ALTITUDE_REF = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.altitude_ref", java.lang.Integer.class, anonymousClass1);
        EXIF_GPS_DATE_STAMP = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.gps_date_stamp", java.lang.String.class, anonymousClass1);
        EXIF_DATE_TIME = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.date_time", java.lang.String.class, anonymousClass1);
        EXIF_SUB_DATE_TIME = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.sub_date_time", java.lang.String.class, anonymousClass1);
        EXIF_MODEL = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.model", java.lang.String.class, anonymousClass1);
        EXIF_MANUFACTURE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.manufacture", java.lang.String.class, anonymousClass1);
        EXIF_COMMENTS = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.comments", java.lang.String.class, anonymousClass1);
        EXIF_MIRROR = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.mirror", java.lang.Boolean.class, anonymousClass1);
        EXIF_NUMBER = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.number", java.lang.Object.class, anonymousClass1);
        EXIF_EXP_TIME = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.exp_time", java.lang.Object.class, anonymousClass1);
        EXIF_APERTURE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.aperture", java.lang.Object.class, anonymousClass1);
        EXIF_EXPOSURE_BIAS = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.exposure_bias", java.lang.Object.class, anonymousClass1);
        EXIF_FOCAL_LENGTH = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.focal_length", java.lang.Object.class, anonymousClass1);
        EXIF_LATITUDE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.latitude", java.lang.Object[].class, anonymousClass1);
        EXIF_LONGITUDE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.longitude", java.lang.Object[].class, anonymousClass1);
        EXIF_ALTITUDE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.altitude", java.lang.Object.class, anonymousClass1);
        EXIF_GPS_TIME_STAMP = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.gps_time_stamp", java.lang.Object[].class, anonymousClass1);
        EXIF_SUPPORT_DCIP3 = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.support_dcip3", java.lang.Boolean.class, anonymousClass1);
        EXIF_SUPPORT_LOCATION = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.support_location", java.lang.Boolean.class, anonymousClass1);
        EXIF_SUPPORT_LOCATION_TIME_STAMP = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.support_location_time_stamp", java.lang.Boolean.class, anonymousClass1);
        EXIF_IMAGE_WIDTH = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.image_width", java.lang.Integer.class, anonymousClass1);
        EXIF_IMAGE_HEIGHT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.image_height", java.lang.Integer.class, anonymousClass1);
        EXIF_TIFFYCRCB_POSITIONING = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.tiffycrcb_positioning", java.lang.Integer.class, anonymousClass1);
        EXIF_TIFF_RESOLUTION_UNIT = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.tiff_resolution_unit", java.lang.Integer.class, anonymousClass1);
        EXIF_TIFFX_RESOLUTIION = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.tiffx_resolution", java.lang.Object.class, anonymousClass1);
        EXIF_TIFFY_RESOLUTION = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.tiffy_resolution", java.lang.Object.class, anonymousClass1);
        EXIF_EXPOSURE_PROGRAM = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.exposure_program", java.lang.Integer.class, anonymousClass1);
        EXIF_VERSION = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.version", java.lang.String.class, anonymousClass1);
        EXIF_COMPONENT_CONFIG = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.component_config", java.lang.String.class, anonymousClass1);
        EXIF_SHUTTER_SPEED = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.shutter_speed", java.lang.Object.class, anonymousClass1);
        EXIF_BRIGHTNESS = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.brightness", java.lang.Object.class, anonymousClass1);
        EXIF_MAX_APERTURE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.max_aperture", java.lang.Object.class, anonymousClass1);
        EXIF_METERING_MODE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.metering_mode", java.lang.Integer.class, anonymousClass1);
        EXIF_MAKER_NOTE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.maker_note", java.lang.String.class, anonymousClass1);
        EXIF_FLASH_PIX_VERSION = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.flash_pix_version", java.lang.String.class, anonymousClass1);
        EXIF_COLOR_SPACE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.color_space", java.lang.Integer.class, anonymousClass1);
        EXIF_SENSING_METHOD = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.sensing_method", java.lang.Integer.class, anonymousClass1);
        EXIF_SCENE_TYPE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.scene_type", java.lang.String.class, anonymousClass1);
        EXIF_EXPOSURE_MODE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.exposure_mode", java.lang.Integer.class, anonymousClass1);
        EXIF_FOCAL_LENGTH_35MM = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.focal_length_35mm", java.lang.Integer.class, anonymousClass1);
        EXIF_SCENE_CAPTURE_TYPE = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.scene_capture_type", java.lang.Integer.class, anonymousClass1);
        EXIF_INTEROP_INDEX_STR = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.interop_index_str", java.lang.String.class, anonymousClass1);
        EXIF_INTEROP_VERSION = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.interop_version", java.lang.String.class, anonymousClass1);
        EXIF_HEIC_QUALITY = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.exif.heic_quality", java.lang.Integer.class, anonymousClass1);
        PREVIEW_RESULT_WIDTH = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.width", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_CROP_LEFT = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.crop_left", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_CROP_TOP = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.crop_top", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_CROP_RIGHT = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.crop_right", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_CROP_BOTTOM = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.crop_bottom", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_HEIGHT = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.height", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_IDENTITY = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>(str5, java.lang.Long.class, j_renamed);
        PREVIEW_RESULT_MOTION_DETECTED = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.motion_detected", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_START_INTERPOLATION_FRAME = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.start_interpolation_frame", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_LAST_VDIEO_FRAME = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.last_video_frame", java.lang.Integer.class, i_renamed);
        KEY_CAMERA_RESULT_APS_INIT_FINISH = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.aps_init_finish", java.lang.String.class, anonymousClass1);
        KEY_CAMERA_RESULT_REF_TIMESTAMP = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.ref_timestamp", java.lang.Long.class, j_renamed);
        PREVIEW_RESULT_REQUEST_FORMAT = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.request_format", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_MULTI_FRAME_COUNT = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.multi_frame_count", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_SUPER_NIGHT_SCENE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.super_night_scene", java.lang.Integer.class, i_renamed);
        int i3 = 1;
        PREVIEW_RESULT_META_INDEX = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.meta_index", java.lang.Integer.class, i3);
        PREVIEW_RESULT_NIGHT_TOTAL_EXPTIME = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.night_total_exptime", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_OFFLINE_NIGHT_EXPTIME = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.offline_night_exptime", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_SCENE_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.scene_mode", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_SHOW_HDR_ICON = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.show_hdr_icon", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_FEATURE_TYPE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.feature_type", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_THUMBNAIL_INDEX = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.thumbnail_index", java.lang.Integer.class, i3);
        CAPTURE_RESULT_NIGHT_TOTAL_EXPTIME = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.capture.night_total_exptime", java.lang.Long.class, j_renamed);
        CAPTURE_RESULT_FIRST_EXPOSURE_TIME = new com.oplus.ocs.camera.CameraParameter.CaptureResultKey<>("com.oplus.capture.first_exposure_time", java.lang.Long.class, j_renamed);
        PREVIEW_RESULT_ALGO_FLAG = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.algo_flag", java.lang.String[].class, anonymousClass1);
        PREVIEW_RESULT_CAPTURE_EV_LIST = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.capture_ev_list", int[].class, anonymousClass1);
        PREVIEW_RESULT_SENSOR_MASK = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.sensor_mask", int[].class, anonymousClass1);
        PREVIEW_RESULT_MASTER_PIPELINE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.master_pipeline", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_BRACKET_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.bracket_mode", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_DRAWTEXT_BRACKET_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.drawtext_bracket_mode", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_DRAWTEXT_SCENE_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.drawtext_scene_mode", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_DRAWTEXT_FEATURE_TYPE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.drawtext_feature_type", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_DRAWTEXT_HDR_TYPE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.drawtext_hdr_type", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_ASD = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.asd", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_ANTIBANDING = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.antibanding", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_RECTIFY = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.rectify", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_PF = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.pf", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_LSD = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.lsd", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_RTB = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.rtb", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_AICOLOR = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.aicolor", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_VIDEO_HYPERLAPSE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.hyperlapse", java.lang.String.class, anonymousClass1);
        KEY_ALGO_VISUALIZATION_KEY = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.algo.visualization.key", java.lang.String.class, anonymousClass1);
        KEY_ALGO_VISUALIZATION_VALUE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.algo.visualization.value", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_MFSR_FRAME_COUNT = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.mfsr_frame_count", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_SUPPORT_ZOOM_FEATURE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.support_zoom_feature", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_AI_SHUTTER = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.ai_shutter", java.lang.Boolean.class, z_renamed);
        PREVIEW_RESULT_BOKEN_STATE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.rtb_msg", java.lang.Integer.class, i2);
        PREVIEW_RESULT_AI_SCENE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.asd_scene_icon", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_TUNING_SCENE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.asd_tuning_scene", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_HDR_SCOPE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.asd_hdr_scope", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_MASTER_CAMERA_ID = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.sat_master_camera_id", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_ACTIVE_MAP = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.sat_active_map", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_LENS_DIRTY = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.lsd_is_dirty", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_GESTURE_ACTION_TYPE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.gesture.action.type", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_VIDEO_EIS = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.video_eis_on", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_FRAME_ID = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.frame_id", java.lang.Integer.class, i_renamed);
        PREVIEW_RESULT_CAMERA_TYPE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.camera.type", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_CAMERA_MODE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.camera.mode", java.lang.String.class, anonymousClass1);
        PREVIEW_RESULT_CAMERA_IMAGE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.image_buffer_image", android.media.Image.class, anonymousClass1);
        PREVIEW_RESULT_HARDWARE_BUFFER = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.image_buffer_hardware_buffer", android.hardware.HardwareBuffer.class, anonymousClass1);
        PREVIEW_RESULT_IMAGE_TIME_STAMP = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.image_buffer_time_stamp", java.lang.Long.class, j_renamed);
        PREVIEW_RESULT_IMAGE_IS_VALID = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.result.image_buffer_is_valid", java.lang.Boolean.class, z_renamed);
        PREVIEW_RESULT_CAMERA_ID = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.camera_id", java.lang.Integer.class, i2);
        PREVIEW_RESULT_AIS_STATE = new com.oplus.ocs.camera.CameraParameter.PreviewResultKey<>("com.oplus.preview.ais_state", java.lang.Integer.class, i_renamed);
    }

    public static final class ConfigureKey<T_renamed> {
        private java.lang.String mKeyName;
        private java.lang.Class<T_renamed> mType;

        private ConfigureKey(java.lang.String str, java.lang.Class<T_renamed> cls) {
            this.mKeyName = null;
            this.mType = null;
            this.mKeyName = str;
            this.mType = cls;
        }

        public java.lang.String getKeyName() {
            return this.mKeyName;
        }

        public java.lang.String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }

    public static final class PreviewKey<T_renamed> {
        private java.lang.String mKeyName;
        private java.lang.Class<T_renamed> mType;

        private PreviewKey(java.lang.String str, java.lang.Class<T_renamed> cls) {
            this.mKeyName = null;
            this.mType = null;
            this.mKeyName = str;
            this.mType = cls;
        }

        public java.lang.String getKeyName() {
            return this.mKeyName;
        }

        public java.lang.String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }

    public static final class CaptureResultKey<T_renamed> {
        private T_renamed mDefault;
        private java.lang.String mKeyName;
        private java.lang.Class<T_renamed> mType;

        private CaptureResultKey(java.lang.String str, java.lang.Class<T_renamed> cls, T_renamed t_renamed) {
            this.mKeyName = null;
            this.mType = null;
            this.mDefault = null;
            this.mKeyName = str;
            this.mType = cls;
            this.mDefault = t_renamed;
        }

        public java.lang.String getKeyName() {
            return this.mKeyName;
        }

        public java.lang.Class<T_renamed> getType() {
            return this.mType;
        }

        public T_renamed getDefault() {
            return this.mDefault;
        }

        public java.lang.String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }

    public static final class PreviewResultKey<T_renamed> {
        private T_renamed mDefault;
        private java.lang.String mKeyName;
        private java.lang.Class<T_renamed> mType;

        private PreviewResultKey(java.lang.String str, java.lang.Class<T_renamed> cls, T_renamed t_renamed) {
            this.mKeyName = null;
            this.mType = null;
            this.mDefault = null;
            this.mKeyName = str;
            this.mType = cls;
            this.mDefault = t_renamed;
        }

        public java.lang.String getKeyName() {
            return this.mKeyName;
        }

        public java.lang.Class<T_renamed> getType() {
            return this.mType;
        }

        public T_renamed getDefault() {
            return this.mDefault;
        }

        public java.lang.String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }
}
