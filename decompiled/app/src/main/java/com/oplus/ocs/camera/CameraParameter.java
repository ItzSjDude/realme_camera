package com.oplus.ocs.camera;

import android.graphics.RectF;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.os.Bundle;
import android.util.Range;
import com.oplus.camera.aps.config.ConfigDataBase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class CameraParameter {
    public static final PreviewKey<RectF> AE_REGIONS;
    public static final PreviewKey<RectF> AF_REGIONS;
    public static final ConfigureKey<String> AI_HIGH_PIXEL_ENABLE;
    public static final ConfigureKey<Integer> AI_NIGHT_VIDEO_MODE;
    public static final PreviewKey<String> AI_PHOTO;
    public static final PreviewKey<String> ALGO_VISUALIZATION_ENABLE;
    public static final ConfigureKey<String> ANTI_BANDING_ENABLE;
    public static final CaptureResultKey<HashMap> APS_PROC_TIMER;
    public static final PreviewKey<float[]> BLUR_LEVEL;
    public static final PreviewKey<Integer> BLUR_LEVEL_RANGE;
    public static final PreviewKey<String> BURST_SHOT_ENABLE;
    public static final PreviewKey<Long> BURST_SHOT_FLAG_ID;
    public static final PreviewKey<String> BURST_SHOT_PATH;
    public static final CaptureResultKey<Integer> CAPTURE_FAIL_CODE;
    public static final PreviewKey<Boolean> CAPTURE_FLIP_MODE_ENABLE;
    public static final PreviewKey<Boolean> CAPTURE_FOR_VIDEO;
    public static final PreviewKey<String> CAPTURE_HDR_MODE;
    public static final CaptureResultKey<Long> CAPTURE_RESULT_FIRST_EXPOSURE_TIME;
    public static final CaptureResultKey<Long> CAPTURE_RESULT_NIGHT_TOTAL_EXPTIME;
    public static final PreviewKey<Long> CAPTURE_TIME;
    public static final PreviewKey<Boolean> CAPTURE_WITH_DETACH;
    public static final PreviewKey<int[]> COLOR_TEMPERATURE;
    public static final PreviewKey<Integer> COLOR_TEMPERATURE_RANGE;
    public static final CaptureResultKey<Object> EXIF_ALTITUDE;
    public static final CaptureResultKey<Integer> EXIF_ALTITUDE_REF;
    public static final CaptureResultKey<Object> EXIF_APERTURE;
    public static final CaptureResultKey<Object> EXIF_BRIGHTNESS;
    public static final CaptureResultKey<Integer> EXIF_COLOR_SPACE;
    public static final CaptureResultKey<String> EXIF_COMMENTS;
    public static final CaptureResultKey<String> EXIF_COMPONENT_CONFIG;
    public static final CaptureResultKey<String> EXIF_DATE_TIME;
    public static final CaptureResultKey<Object> EXIF_EXPOSURE_BIAS;
    public static final CaptureResultKey<Integer> EXIF_EXPOSURE_MODE;
    public static final CaptureResultKey<Integer> EXIF_EXPOSURE_PROGRAM;
    public static final CaptureResultKey<Object> EXIF_EXP_TIME;
    public static final CaptureResultKey<String> EXIF_FLASH_PIX_VERSION;
    public static final CaptureResultKey<Integer> EXIF_FLASH_VALUE;
    public static final CaptureResultKey<Object> EXIF_FOCAL_LENGTH;
    public static final CaptureResultKey<Integer> EXIF_FOCAL_LENGTH_35MM;
    public static final CaptureResultKey<String> EXIF_GPS_DATE_STAMP;
    public static final CaptureResultKey<Object[]> EXIF_GPS_TIME_STAMP;
    public static final CaptureResultKey<Integer> EXIF_HEIC_QUALITY;
    public static final CaptureResultKey<Integer> EXIF_IMAGE_HEIGHT;
    public static final CaptureResultKey<Integer> EXIF_IMAGE_WIDTH;
    public static final CaptureResultKey<String> EXIF_INTEROP_INDEX_STR;
    public static final CaptureResultKey<String> EXIF_INTEROP_VERSION;
    public static final CaptureResultKey<Long> EXIF_ISO;
    public static final CaptureResultKey<Object[]> EXIF_LATITUDE;
    public static final CaptureResultKey<String> EXIF_LATITUDE_REF;
    public static final CaptureResultKey<Object[]> EXIF_LONGITUDE;
    public static final CaptureResultKey<String> EXIF_LONGITUDE_REF;
    public static final CaptureResultKey<String> EXIF_MAKER_NOTE;
    public static final CaptureResultKey<String> EXIF_MANUFACTURE;
    public static final CaptureResultKey<Object> EXIF_MAX_APERTURE;
    public static final CaptureResultKey<Integer> EXIF_METERING_MODE;
    public static final CaptureResultKey<Boolean> EXIF_MIRROR;
    public static final CaptureResultKey<String> EXIF_MODEL;
    public static final CaptureResultKey<Object> EXIF_NUMBER;
    public static final CaptureResultKey<Integer> EXIF_ROTATE;
    public static final CaptureResultKey<Integer> EXIF_SCENE_CAPTURE_TYPE;
    public static final CaptureResultKey<String> EXIF_SCENE_TYPE;
    public static final CaptureResultKey<Integer> EXIF_SENSING_METHOD;
    public static final CaptureResultKey<String> EXIF_SENSOR_NAME;
    public static final CaptureResultKey<Object> EXIF_SHUTTER_SPEED;
    public static final CaptureResultKey<String> EXIF_SUB_DATE_TIME;
    public static final CaptureResultKey<Boolean> EXIF_SUPPORT_DCIP3;
    public static final CaptureResultKey<Boolean> EXIF_SUPPORT_LOCATION;
    public static final CaptureResultKey<Boolean> EXIF_SUPPORT_LOCATION_TIME_STAMP;
    public static final CaptureResultKey<Object> EXIF_TIFFX_RESOLUTIION;
    public static final CaptureResultKey<Integer> EXIF_TIFFYCRCB_POSITIONING;
    public static final CaptureResultKey<Object> EXIF_TIFFY_RESOLUTION;
    public static final CaptureResultKey<Integer> EXIF_TIFF_RESOLUTION_UNIT;
    public static final CaptureResultKey<String> EXIF_VERSION;
    public static final CaptureResultKey<Integer> EXIF_WHITE_BALANCE_MODE;
    public static final PreviewKey<String> FACE_BEAUTY_ENABLE;
    public static final PreviewKey<int[]> FACE_BEAUTY_PARAM;
    public static final PreviewKey<String> FACE_BEAUTY_VERSION;
    public static final PreviewKey<String> FACE_DERED_EYE;
    public static final PreviewKey<Boolean> FACE_RECTIFY_ENABLE;
    public static final PreviewKey<Boolean> FILTER_OPEN;
    public static final PreviewKey<String> FILTER_TYPE;
    public static final PreviewKey<Boolean> FILTER_WITHVIGNETTE;
    public static final PreviewKey<Boolean> FISH_EYE_MODE;
    public static final PreviewKey<String> FLASH_MODE;
    public static final PreviewKey<Integer> FOCUS_MODE;
    public static final PreviewKey<Boolean> FOCUS_PEAKING_ENABLE;
    public static final PreviewKey<Integer> FRAME_FLAG;
    public static final PreviewKey<int[]> HASSELBLAD_XPAN_CROP_REGION;
    public static final CaptureResultKey<Boolean> HAS_SUPER_TEXT_RESULT;
    public static final CaptureResultKey<Boolean> HEIF_PROCESS_IN_APS;
    public static final ConfigureKey<String> HIGH_PICTURE_SIZE_ENABLE;
    public static final ConfigureKey<Byte> HVXSHDR_MODE_ENABLE;
    public static final ConfigureKey<String> HYPER_LAPSE;
    public static final CaptureResultKey<Integer> IMAGE_CATEGORY_BURST_COUNT;
    public static final CaptureResultKey<Boolean> IMAGE_CATEGORY_BURST_SHOT;
    public static final CaptureResultKey<Long> IMAGE_CATEGORY_BURST_SHOT_FLAG_ID;
    public static final CaptureResultKey<String> IMAGE_CATEGORY_CSHOT_PATH;
    public static final CaptureResultKey<int[]> IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM;
    public static final CaptureResultKey<Long> IMAGE_CATEGORY_DATE;
    public static final CaptureResultKey<Boolean> IMAGE_CATEGORY_END_OF_CAPTURE;
    public static final CaptureResultKey<Integer> IMAGE_CATEGORY_FORMAT;
    public static final CaptureResultKey<Integer> IMAGE_CATEGORY_HEIGHT;
    public static final CaptureResultKey<Long> IMAGE_CATEGORY_IMAGE_TIME_STAMP;
    public static final CaptureResultKey<Boolean> IMAGE_CATEGORY_IS_VALID;
    public static final CaptureResultKey<Long> IMAGE_CATEGORY_MERGE_IDENTITY;
    public static final CaptureResultKey<Long> IMAGE_CATEGORY_META_TIME_STAMP;
    public static final CaptureResultKey<Integer> IMAGE_CATEGORY_REC_BURST_NUMBER;
    public static final CaptureResultKey<String> IMAGE_CATEGORY_SUPER_TEXT_ENABLE;
    public static final CaptureResultKey<String> IMAGE_CATEGORY_WATERMARK_PATH;
    public static final CaptureResultKey<Integer> IMAGE_CATEGORY_WIDTH;
    public static final PreviewKey<Boolean> IS_FROM_MAIN_MENU;
    public static final PreviewResultKey<String> KEY_ALGO_VISUALIZATION_KEY;
    public static final PreviewResultKey<String> KEY_ALGO_VISUALIZATION_VALUE;
    public static final ConfigureKey<byte[]> KEY_CALLER_PACKAGE_NAME;
    public static final PreviewResultKey<String> KEY_CAMERA_RESULT_APS_INIT_FINISH;
    public static final PreviewResultKey<Long> KEY_CAMERA_RESULT_REF_TIMESTAMP;
    public static final ConfigureKey<Integer> KEY_DUAL_SCENE_MASTER;
    public static final PreviewKey<Boolean> KEY_EDGE_FILTER_ENABLE;
    public static final PreviewKey<String[]> KEY_EDGE_FILTER_PARAM;
    public static final ConfigureKey<Integer> KEY_EXPLORER_CHIP_STATE;
    public static final ConfigureKey<String> KEY_EXPLORER_ENABLE;
    public static final PreviewKey<String> KEY_GESTURE_ENABLE;
    public static final ConfigureKey<Boolean> KEY_IS_FROM_MAIN_MENU;
    public static final ConfigureKey<Byte> KEY_MOVIE_HDR_ENABLE;
    public static final ConfigureKey<Byte> KEY_MOVIE_LOG_ENABLE;
    public static final PreviewKey<Integer> KEY_NIGHT_OFFLINE_R2Y;
    public static final ConfigureKey<byte[]> KEY_REQUEST_ZSL_MODE;
    public static final PreviewKey<String> KEY_SINGLE_BLUR_ALGONAME;
    public static final PreviewKey<Integer> KEY_SINGLE_BLUR_LEVEL;
    public static final PreviewKey<Float> KEY_SINGLE_BLUR_SHOW;
    public static final PreviewKey<Integer> KEY_SINGLE_PORTRAIT_EFFECT_MODE;
    public static final ConfigureKey<Float> KEY_ZOOM_RATION_CONFIGURE;
    public static final ConfigureKey<Integer> MAKEUP_STATE;
    public static final PreviewKey<String> MAKEUP_TYPE;
    public static final PreviewKey<Integer> MAKEUP_VALUE;
    public static final CaptureResultKey<Long> MESH_PTR;
    public static final ConfigureKey<String> MIRROR_ENABLE;
    public static final ConfigureKey<String> MONO_FILTER_TYPE;
    public static final PreviewKey<Byte> MOVIE_HDR_ENABLE;
    public static final PreviewKey<Byte> MOVIE_LOG_ENABLE;
    public static final CaptureResultKey<Integer> NOISE_REDUCTION_STRENGTH;
    public static final ConfigureKey<String> PHOTO_10BIT_ENABLE;
    public static final PreviewKey<int[]> PICTURE_EXIF_FLAG;
    public static final CaptureResultKey<Long> PICTURE_IDENTITY;
    public static final PreviewKey<String> PICTURE_VISUALIZATION_ENABLE;
    public static final ConfigureKey<String> PORTAIT_BODY_TYPE;
    public static final ConfigureKey<String> PORTAIT_BOKEH_TYPE;
    public static final PreviewKey<String> PORTRAIT_NEON_ENABLE;
    public static final ConfigureKey<String> PORTRAIT_STREAMER_ENABLE;
    public static final PreviewKey<Integer> PREVIEW_AIS_BRACKET;
    public static final PreviewKey<Integer> PREVIEW_AIS_DCT_AINR_SUPPORT;
    public static final PreviewKey<Integer> PREVIEW_AIS_DCT_SUPPORT;
    public static final PreviewKey<int[]> PREVIEW_BRACKET_MODE;
    public static final PreviewKey<String> PREVIEW_IN_PREVIEW_ENABLE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_ACTIVE_MAP;
    public static final PreviewResultKey<String> PREVIEW_RESULT_AICOLOR;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_AIS_STATE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_AI_SCENE;
    public static final PreviewResultKey<Boolean> PREVIEW_RESULT_AI_SHUTTER;
    public static final PreviewResultKey<String[]> PREVIEW_RESULT_ALGO_FLAG;
    public static final PreviewResultKey<String> PREVIEW_RESULT_ANTIBANDING;
    public static final PreviewResultKey<String> PREVIEW_RESULT_ASD;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_BOKEN_STATE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_BRACKET_MODE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_CAMERA_ID;
    public static final PreviewResultKey<Image> PREVIEW_RESULT_CAMERA_IMAGE;
    public static final PreviewResultKey<String> PREVIEW_RESULT_CAMERA_MODE;
    public static final PreviewResultKey<String> PREVIEW_RESULT_CAMERA_TYPE;
    public static final PreviewResultKey<int[]> PREVIEW_RESULT_CAPTURE_EV_LIST;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_CROP_BOTTOM;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_CROP_LEFT;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_CROP_RIGHT;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_CROP_TOP;
    public static final PreviewResultKey<String> PREVIEW_RESULT_DRAWTEXT_BRACKET_MODE;
    public static final PreviewResultKey<String> PREVIEW_RESULT_DRAWTEXT_FEATURE_TYPE;
    public static final PreviewResultKey<String> PREVIEW_RESULT_DRAWTEXT_HDR_TYPE;
    public static final PreviewResultKey<String> PREVIEW_RESULT_DRAWTEXT_SCENE_MODE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_FEATURE_TYPE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_FRAME_ID;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_GESTURE_ACTION_TYPE;
    public static final PreviewResultKey<HardwareBuffer> PREVIEW_RESULT_HARDWARE_BUFFER;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_HDR_SCOPE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_HEIGHT;
    public static final PreviewResultKey<Long> PREVIEW_RESULT_IDENTITY;
    public static final PreviewResultKey<Boolean> PREVIEW_RESULT_IMAGE_IS_VALID;
    public static final PreviewResultKey<Long> PREVIEW_RESULT_IMAGE_TIME_STAMP;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_LAST_VDIEO_FRAME;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_LENS_DIRTY;
    public static final PreviewResultKey<String> PREVIEW_RESULT_LSD;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_MASTER_CAMERA_ID;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_MASTER_PIPELINE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_META_INDEX;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_MFSR_FRAME_COUNT;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_MOTION_DETECTED;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_MULTI_FRAME_COUNT;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_NIGHT_TOTAL_EXPTIME;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_OFFLINE_NIGHT_EXPTIME;
    public static final PreviewResultKey<String> PREVIEW_RESULT_PF;
    public static final PreviewResultKey<String> PREVIEW_RESULT_RECTIFY;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_REQUEST_FORMAT;
    public static final PreviewResultKey<String> PREVIEW_RESULT_RTB;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_SCENE_MODE;
    public static final PreviewResultKey<int[]> PREVIEW_RESULT_SENSOR_MASK;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_SHOW_HDR_ICON;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_START_INTERPOLATION_FRAME;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_SUPER_NIGHT_SCENE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_SUPPORT_ZOOM_FEATURE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_THUMBNAIL_INDEX;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_TUNING_SCENE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_VIDEO_EIS;
    public static final PreviewResultKey<String> PREVIEW_RESULT_VIDEO_HYPERLAPSE;
    public static final PreviewResultKey<Integer> PREVIEW_RESULT_WIDTH;
    public static final PreviewKey<Boolean> QUICK_JPEG;
    public static final ConfigureKey<Boolean> QUICK_JPEG_SWITCH;
    public static final PreviewKey<String> QUICK_VIDEO_RECORD_ENABLE;
    public static final PreviewKey<String> RAW_CONTROL;
    public static final PreviewKey<Boolean> REAR_MIRROR_ENABLE;
    public static final PreviewKey<Object> REQUEST_TAG;
    public static final CaptureResultKey<Boolean> RESULT_CAPTURE_FOR_VIDEO;
    public static final CaptureResultKey<Object> RESULT_REQUEST_TAG;
    public static final PreviewKey<Float> SAT_NONE_ZOOM_RATIO;
    public static final ConfigureKey<int[]> SESSION_REQUEST_CROP_REGION;
    public static final PreviewKey<Long> SHUTTER_BUTTON_CLICK_TIME;
    public static final ConfigureKey<String> SLOW_VIDEO_INTELLIGENT_HIGH_FRAME_ENABLE;

    @Deprecated
    public static final ConfigureKey<RectF> SLOW_VIDEO_MOTION_DETECT_COORDINATE;
    public static final PreviewKey<Boolean> STARBURST_MODE;
    public static final PreviewKey<String> STAR_VIDEO_ENABLE;
    public static final PreviewKey<String> SUPER_CLEAR_PORTRAIT_ENABLE;
    public static final PreviewKey<Boolean> SUPER_TEXT_ENABLE;
    public static final CaptureResultKey<Integer> SUPER_TEXT_HEIGHT;
    public static final PreviewKey<String> SUPER_TEXT_VERTICES;
    public static final CaptureResultKey<Integer> SUPER_TEXT_WIDTH;
    public static final PreviewKey<Boolean> TILT_SHIFT_ENABLE;
    public static final PreviewKey<Bundle> TILT_SHIFT_PARAM;
    public static final ConfigureKey<String> TORCH_FLASH_ENABLE;
    public static final PreviewKey<Boolean> TRIPOD_MODE_ENABLE;
    public static final PreviewKey<String> ULTRA_HIGH_RESOLUTION_ENABLE;
    public static final ConfigureKey<String> VIDEO_10BIT_ENABLE;
    public static final ConfigureKey<String> VIDEO_3HDR_MODE;
    public static final ConfigureKey<Integer> VIDEO_BITRATE;
    public static final ConfigureKey<String> VIDEO_BLUR;
    public static final PreviewKey<String> VIDEO_BLUR_ENABLE;
    public static final PreviewKey<String> VIDEO_BLUR_PARAMS;
    public static final ConfigureKey<Range> VIDEO_DYNAMIC_FPS;
    public static final PreviewKey<Bundle> VIDEO_EFFECT_PARAM;
    public static final PreviewKey<Integer> VIDEO_EIS_RECORD_STATE;
    public static final ConfigureKey<String> VIDEO_ENCODER;
    public static final ConfigureKey<String> VIDEO_FOVC_MODE;
    public static final ConfigureKey<String> VIDEO_FPS;
    public static final PreviewKey<Integer> VIDEO_FUSION_EFFECT;
    public static final PreviewKey<String> VIDEO_NEON_ENABLE;
    public static final PreviewKey<String> VIDEO_NEON_PARAMS;
    public static final ConfigureKey<String> VIDEO_NIGHT_MODE;
    public static final PreviewKey<String> VIDEO_RETENTION_OPEN;
    public static final ConfigureKey<String> VIDEO_STABILIZATION_MODE;
    public static final PreviewKey<String> WATERMARK_CAPTURE_ENABLE;
    public static final PreviewKey<Bundle> WATERMARK_PARAM;
    public static final ConfigureKey<String> WATERMARK_VIDEO_ENABLE;
    public static final PreviewKey<Boolean> ZOOM_ACTIVE;
    public static final PreviewKey<Float> ZOOM_RATIO;
    public static final PreviewKey<Float> ZOOM_TARGET;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AiNightVideoValues {
        public static final int AI_NIGHT_VIDEO_OFF = 0;
        public static final int AI_NIGHT_VIDEO_ON = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AiStablizationValues {
        public static final int AI_STABLIZATION_VIDEO_OFF = 0;
        public static final int AI_STABLIZATION_VIDEO_ON = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BokehType {
        public static final String SINGLE_BOKEH = "single_bokeh";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureFailCode {
        public static final int MEMORY_NOT_ENOUGH = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommonByteStateValue {
        public static final byte OFF = 0;

        /* renamed from: ON */
        public static final byte f23518ON = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommonStateValue {
        public static final String AUTO = "auto";
        public static final String OFF = "off";

        /* renamed from: ON */
        public static final String f23519ON = "on";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashMode {
        public static final String FLASH_AUTO = "auto";
        public static final String FLASH_OFF = "off";
        public static final String FLASH_ON = "on";
        public static final String FLASH_TORCH = "torch";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusMode {
        public static final int AF_MODE_AUTO = 3;
        public static final int AF_MODE_CONTINUOUS_PICTURE = 1;
        public static final int AF_MODE_CONTINUOUS_VIDEO = 2;
        public static final int AF_MODE_LOCK = 4;
        public static final int AF_MODE_OFF = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HyperLapse {
        public static final String HYPER_LAPSE = "hyper_lapse";
        public static final String OFF = "off";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MonoFilterType {
        public static final String BLACK_WHITE = "black_white";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NightVideo {
        public static final String NORMAL_NIGHT_VIDEO = "normal_night_video";
        public static final String ULTRA_NIGHT_VIDEO = "ultra_night_video";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PortraitBodyType {
        public static final String FULL_BODY = "full_body";
        public static final String HALF_BODY = "half_body";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RawValue {
        public static final String NONE = "none";
        public static final String RAW = "raw";
        public static final String SUPER_RAW = "super_raw";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecordingState {
        public static final int RECORDING_PAUSE = 2;
        public static final int RECORDING_RESUME = 3;
        public static final int RECORDING_START = 1;
        public static final int RECORDING_STOP = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TiltShiftParamKeys {
        public static final String BLUR_VALUE = "blurValue";
        public static final String CENTER_POSITION = "centerPosition";
        public static final String CLEAR_DISTANCE = "clearDistance";
        public static final String PREVIEW_SIZE = "previewSize";
        public static final String ROTATE_ANGLE = "rotateAngle";
        public static final String TYPE = "type";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoEffectParamKeys {
        public static final String BLUR_LEVEL = "blur_level";
        public static final String BLUR_SHOW = "blur_show";
        public static final String RETENTION_PROCESS = "retention_process";
        public static final String VIDEO_ORIENTATION = "orientation";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoEncoder {
        public static final String H264 = "H264";
        public static final String H265 = "H265";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoFps {
        public static final int FPS_120 = 120;
        public static final int FPS_240 = 240;
        public static final int FPS_30 = 30;
        public static final int FPS_480 = 480;
        public static final int FPS_60 = 60;
        public static final int FPS_960 = 960;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoFpsValue {
        public static final String VIDEO_FPS_120 = "video_120fps";
        public static final String VIDEO_FPS_240 = "video_240fps";
        public static final String VIDEO_FPS_30 = "video_30fps";
        public static final String VIDEO_FPS_480 = "video_480fps";
        public static final String VIDEO_FPS_60 = "video_60fps";
        public static final String VIDEO_FPS_960 = "video_960fps";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoStabilizationMode {
        public static final String SUPER_STABILIZATION = "super_stabilization";
        public static final String SUPER_STABILIZATION_FRONT = "super_stabilization_front";
        public static final String VIDEO_STABILIZATION = "video_stabilization";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WaterMarkParamKeys {
        public static final String FILE_PATH = "filePath";
        public static final String INPUT_WIDTH = "inputWidth";
        public static final String MAKEUP_ENABLE = "makeupEnable";
        public static final String MAKEUP_HEIGHT = "makeupHeight";
        public static final String MAKEUP_START_X = "makeupStartX";
        public static final String MAKEUP_START_Y = "makeupStartY";
        public static final String MAKEUP_WIDTH = "makeupWidth";
        public static final String NEED_SCALE = "needScale";
        public static final String ORIENTATION = "orientation";
        public static final String REF_WIDTH = "refWidth";
        public static final String SIZE = "size";
        public static final String WATERMARK_BORDER_X = "watermark_border_x";
        public static final String WATERMARK_BORDER_Y = "watermark_border_y";
        public static final String YUV_BUFFER = "buffer";
    }

    static {
        C36801 c36801 = null;
        VIDEO_FPS = new ConfigureKey<>("com.oplus.configure.video.fps", String.class);
        VIDEO_DYNAMIC_FPS = new ConfigureKey<>("com.oplus.configure.video.dynamic.fps", Range.class);
        VIDEO_STABILIZATION_MODE = new ConfigureKey<>("com.oplus.configure.video.stabilization", String.class);
        VIDEO_3HDR_MODE = new ConfigureKey<>("com.oplus.configure.video.3hdr", String.class);
        VIDEO_NIGHT_MODE = new ConfigureKey<>("com.oplus.configure.video.night", String.class);
        VIDEO_10BIT_ENABLE = new ConfigureKey<>("com.oplus.feature.video.10bit.enable", String.class);
        String str = "com.oplus.video.blur.enable";
        VIDEO_BLUR = new ConfigureKey<>(str, String.class);
        PHOTO_10BIT_ENABLE = new ConfigureKey<>("com.oplus.feature.photo.10bit.enable", String.class);
        HIGH_PICTURE_SIZE_ENABLE = new ConfigureKey<>("com.oplus.feature.photo.highPicture.enable", String.class);
        AI_HIGH_PIXEL_ENABLE = new ConfigureKey<>("com.oplus.feature.ai.high.pixel.enable", String.class);
        KEY_EXPLORER_CHIP_STATE = new ConfigureKey<>("com.oplus.explorer.chip.state", Integer.class);
        KEY_EXPLORER_ENABLE = new ConfigureKey<>("com.oplus.configure.explorer.enable", String.class);
        MAKEUP_STATE = new ConfigureKey<>("com.oplus.makeup.state", Integer.class);
        ANTI_BANDING_ENABLE = new ConfigureKey<>("com.oplus.feature.antibanding.enable", String.class);
        MIRROR_ENABLE = new ConfigureKey<>("com.oplus.feature.mirror.enable", String.class);
        WATERMARK_VIDEO_ENABLE = new ConfigureKey<>("com.oplus.camera.watermark.video.enable", String.class);
        VIDEO_FOVC_MODE = new ConfigureKey<>("com.oplus.configure.video.fovc", String.class);
        VIDEO_ENCODER = new ConfigureKey<>("com.oplus.configure.video.encoder", String.class);
        VIDEO_BITRATE = new ConfigureKey<>("com.oplus.configure.video.bitrate", Integer.class);
        PORTAIT_BOKEH_TYPE = new ConfigureKey<>("com.oplus.portrait.bokeh.type", String.class);
        PORTAIT_BODY_TYPE = new ConfigureKey<>("com.oplus.portrait.body.type", String.class);
        HYPER_LAPSE = new ConfigureKey<>("com.oplus.configure.fastvideo.hyperLapse", String.class);
        AI_NIGHT_VIDEO_MODE = new ConfigureKey<>("com.oplus.video.stabilization.mode", Integer.class);
        SLOW_VIDEO_INTELLIGENT_HIGH_FRAME_ENABLE = new ConfigureKey<>("com.oplus.slow.video.intelligent.high.frame.enable", String.class);
        SLOW_VIDEO_MOTION_DETECT_COORDINATE = new ConfigureKey<>("com.oplus.slow.video.motion.detect.coordinate", RectF.class);
        String str2 = "com.oplus.movie.hdr.enable";
        KEY_MOVIE_HDR_ENABLE = new ConfigureKey<>(str2, Byte.TYPE);
        String str3 = "com.oplus.movie.log.enable";
        KEY_MOVIE_LOG_ENABLE = new ConfigureKey<>(str3, Byte.TYPE);
        SESSION_REQUEST_CROP_REGION = new ConfigureKey<>("com.oplus.multicamfeature.multiCamConfigScalerCropRegion", int[].class);
        TORCH_FLASH_ENABLE = new ConfigureKey<>("com.oplus.torch.flash.enable", String.class);
        QUICK_JPEG_SWITCH = new ConfigureKey<>("com.oplus.quick.jpeg.switch", Boolean.class);
        HVXSHDR_MODE_ENABLE = new ConfigureKey<>("com.oplus.hvxshdr.mode.enable", Byte.TYPE);
        PORTRAIT_STREAMER_ENABLE = new ConfigureKey<>("com.oplus.portrait.streamer.enable", String.class);
        KEY_CALLER_PACKAGE_NAME = new ConfigureKey<>("com.oplus.caller.package.name", byte[].class);
        KEY_REQUEST_ZSL_MODE = new ConfigureKey<>("com.oplus.control.capture.zsl.mode", byte[].class);
        MONO_FILTER_TYPE = new ConfigureKey<>("com.oplus.mono.filter.type", String.class);
        KEY_DUAL_SCENE_MASTER = new ConfigureKey<>("com.oplus.dualscene.master", Integer.class);
        KEY_ZOOM_RATION_CONFIGURE = new ConfigureKey<>("com.oplus.original.zoomRatio", Float.class);
        KEY_IS_FROM_MAIN_MENU = new ConfigureKey<>("com.oplus.camera.is.from.main.menu", Boolean.class);
        CAPTURE_HDR_MODE = new PreviewKey<>("com.oplus.preview.capture.hdrMode", String.class);
        FLASH_MODE = new PreviewKey<>("com.oplus.preview.flash.mode", String.class);
        ZOOM_RATIO = new PreviewKey<>("com.oplus.preview.zoom.ratio", Float.class);
        ZOOM_TARGET = new PreviewKey<>("com.oplus.zoom.target", Float.class);
        ZOOM_ACTIVE = new PreviewKey<>("com.oplus.zoom.active", Boolean.class);
        FOCUS_MODE = new PreviewKey<>("com.oplus.preview.focus.mode", Integer.class);
        AF_REGIONS = new PreviewKey<>("com.oplus.preview.af.regions", RectF.class);
        AE_REGIONS = new PreviewKey<>("com.oplus.preview.ae.regions", RectF.class);
        TRIPOD_MODE_ENABLE = new PreviewKey<>("com.oplus.preview.tripod.mode", Boolean.TYPE);
        KEY_GESTURE_ENABLE = new PreviewKey<>("com.oplus.gesture.capture.enable", String.class);
        STARBURST_MODE = new PreviewKey<>("com.oplus.preview.starburst.mode", Boolean.TYPE);
        FISH_EYE_MODE = new PreviewKey<>("com.oplus.preview.fisheye.mode", Boolean.TYPE);
        CAPTURE_FLIP_MODE_ENABLE = new PreviewKey<>("com.oplus.preview.flip_mode", Boolean.TYPE);
        BLUR_LEVEL = new PreviewKey<>("com.oplus.bokeh.level", float[].class);
        HASSELBLAD_XPAN_CROP_REGION = new PreviewKey<>("com.oplus.opx.CropInfo", int[].class);
        BLUR_LEVEL_RANGE = new PreviewKey<>("com.oplus.blur.level.range", Integer.class);
        SAT_NONE_ZOOM_RATIO = new PreviewKey<>("com.oplus.sat.none.zoom.ratio", Float.class);
        SUPER_TEXT_VERTICES = new PreviewKey<>("com.oplus.super.text.vertices", String.class);
        SUPER_TEXT_ENABLE = new PreviewKey<>("com.oplus.super.text.enable", Boolean.class);
        String str4 = "com.oplus.request.tag";
        REQUEST_TAG = new PreviewKey<>(str4, Object.class);
        CAPTURE_TIME = new PreviewKey<>("com.oplus.capture.time", Long.class);
        WATERMARK_PARAM = new PreviewKey<>("com.oplus.feature.watermark.param", Bundle.class);
        AI_PHOTO = new PreviewKey<>("com.oplus.preview.capture.ai", String.class);
        ALGO_VISUALIZATION_ENABLE = new PreviewKey<>("com.oplus.camera.algo.visualization.enable", String.class);
        FILTER_TYPE = new PreviewKey<>("com.oplus.camera.filter.type", String.class);
        FILTER_OPEN = new PreviewKey<>("com.oplus.camera.filter.open", Boolean.class);
        VIDEO_RETENTION_OPEN = new PreviewKey<>("com.oplus.camera.video.retention.open", String.class);
        MAKEUP_TYPE = new PreviewKey<>("com.oplus.camera.makeup.type", String.class);
        MAKEUP_VALUE = new PreviewKey<>("com.oplus.camera.makeup.value", Integer.class);
        FILTER_WITHVIGNETTE = new PreviewKey<>("com.oplus.camera.filter.withvignette", Boolean.class);
        FACE_BEAUTY_ENABLE = new PreviewKey<>("com.oplus.camera.face.beauty.enable", String.class);
        FACE_BEAUTY_VERSION = new PreviewKey<>("com.oplus.camera.face.beauty.version", String.class);
        STAR_VIDEO_ENABLE = new PreviewKey<>("com.oplus.camera.star.video.enable", String.class);
        FRAME_FLAG = new PreviewKey<>("com.oplus.frame.flag", Integer.class);
        CAPTURE_FOR_VIDEO = new PreviewKey<>("com.oplus.capture.for.video", Boolean.class);
        REAR_MIRROR_ENABLE = new PreviewKey<>("rear.mirror.enable", Boolean.class);
        SHUTTER_BUTTON_CLICK_TIME = new PreviewKey<>("shutter.button.click.time", Long.class);
        PICTURE_VISUALIZATION_ENABLE = new PreviewKey<>("com.oplus.camera.picture.visualization.enable", String.class);
        FACE_BEAUTY_PARAM = new PreviewKey<>("com.oplus.camera.face.param", int[].class);
        FACE_DERED_EYE = new PreviewKey<>("com.oplus.camera.face.dered.eye.enable", String.class);
        BURST_SHOT_ENABLE = new PreviewKey<>("com.oplus.camera.burst.shot.enable", String.class);
        BURST_SHOT_PATH = new PreviewKey<>("com.oplus.camera.burst.shot.path", String.class);
        BURST_SHOT_FLAG_ID = new PreviewKey<>("com.oplus.camera.burst.shot.flag.id_renamed", Long.class);
        WATERMARK_CAPTURE_ENABLE = new PreviewKey<>("com.oplus.camera.watermark.capture.enable", String.class);
        COLOR_TEMPERATURE_RANGE = new PreviewKey<>("com.oplus.color.temperature.range", Integer.class);
        COLOR_TEMPERATURE = new PreviewKey<>("com.oplus.color.temperature", int[].class);
        RAW_CONTROL = new PreviewKey<>("com.oplus.raw.control", String.class);
        PICTURE_EXIF_FLAG = new PreviewKey<>("com.oplus.picture.exif.flag", int[].class);
        VIDEO_BLUR_ENABLE = new PreviewKey<>(str, String.class);
        VIDEO_EFFECT_PARAM = new PreviewKey<>("com.oplus.video.effect.param", Bundle.class);
        KEY_SINGLE_BLUR_ALGONAME = new PreviewKey<>("com.oplus.single.blur.algoname", String.class);
        KEY_SINGLE_PORTRAIT_EFFECT_MODE = new PreviewKey<>("com.oplus.single.portrait.effect.mode", Integer.class);
        KEY_SINGLE_BLUR_LEVEL = new PreviewKey<>("com.oplus.single.blur.level", Integer.class);
        KEY_SINGLE_BLUR_SHOW = new PreviewKey<>("com.oplus.single.blur.show", Float.class);
        FACE_RECTIFY_ENABLE = new PreviewKey<>("com.oplus.face_rectify.enable", Boolean.class);
        TILT_SHIFT_ENABLE = new PreviewKey<>("com.oplus.tilt.shift.enable", Boolean.class);
        TILT_SHIFT_PARAM = new PreviewKey<>("com.oplus.tilt.shift.param", Bundle.class);
        MOVIE_HDR_ENABLE = new PreviewKey<>(str2, Byte.class);
        MOVIE_LOG_ENABLE = new PreviewKey<>(str3, Byte.class);
        QUICK_VIDEO_RECORD_ENABLE = new PreviewKey<>("com.oplus.quick.video.record.enable", String.class);
        PREVIEW_IN_PREVIEW_ENABLE = new PreviewKey<>("com.oplus.preview.in.preview.enable", String.class);
        CAPTURE_WITH_DETACH = new PreviewKey<>(ConfigDataBase.KEY_CAPTURE_WITH_DETACH, Boolean.class);
        QUICK_JPEG = new PreviewKey<>("com.oplus.quick.jpeg", Boolean.class);
        VIDEO_NEON_ENABLE = new PreviewKey<>("com.oplus.video.neon.enable", String.class);
        VIDEO_FUSION_EFFECT = new PreviewKey<>("com.oplus.video.fusion.status", Integer.class);
        VIDEO_NEON_PARAMS = new PreviewKey<>("com.oplus.video.neon.params", String.class);
        VIDEO_BLUR_PARAMS = new PreviewKey<>("com.oplus.video.blur.params", String.class);
        SUPER_CLEAR_PORTRAIT_ENABLE = new PreviewKey<>("com.oplus.super.clear.portrait.enable", String.class);
        ULTRA_HIGH_RESOLUTION_ENABLE = new PreviewKey<>("com.oplus.ultra.high.resolution.enable", String.class);
        PORTRAIT_NEON_ENABLE = new PreviewKey<>("com.oplus.portrait.neon.enable", String.class);
        FOCUS_PEAKING_ENABLE = new PreviewKey<>("com.oplus.focus.peaking.enable", Boolean.class);
        KEY_EDGE_FILTER_ENABLE = new PreviewKey<>("com.oplus.camera.edge.filter.enable", Boolean.class);
        KEY_EDGE_FILTER_PARAM = new PreviewKey<>("com.oplus.camera.edge.filter.param", String[].class);
        KEY_NIGHT_OFFLINE_R2Y = new PreviewKey<>(ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y, Integer.class);
        IS_FROM_MAIN_MENU = new PreviewKey<>("com.oplus.camera.preview.is.from.main.menu", Boolean.class);
        VIDEO_EIS_RECORD_STATE = new PreviewKey<>("com.oplus.preview.eis.record.state", Integer.class);
        PREVIEW_AIS_DCT_SUPPORT = new PreviewKey<>("com.oplus.preview.ais.dct.support", Integer.class);
        PREVIEW_AIS_DCT_AINR_SUPPORT = new PreviewKey<>("com.oplus.preview.ais.dct.ainr.support", Integer.class);
        PREVIEW_AIS_BRACKET = new PreviewKey<>("com.oplus.preview.ais.bracket", Integer.class);
        PREVIEW_BRACKET_MODE = new PreviewKey<>("com.oplus.BracketMode", int[].class);
        boolean z = false;
        int OplusGLSurfaceView_13 = 0;
        HAS_SUPER_TEXT_RESULT = new CaptureResultKey<>("com.oplus.super.text.has_result", Boolean.class, z);
        SUPER_TEXT_WIDTH = new CaptureResultKey<>("com.oplus.super.text.width", Integer.class, OplusGLSurfaceView_13);
        SUPER_TEXT_HEIGHT = new CaptureResultKey<>("com.oplus.super.text.height", Integer.class, OplusGLSurfaceView_13);
        RESULT_REQUEST_TAG = new CaptureResultKey<>(str4, Object.class, c36801);
        CAPTURE_FAIL_CODE = new CaptureResultKey<>("com.oplus.capture.fail.code", Integer.class, OplusGLSurfaceView_13);
        long OplusGLSurfaceView_15 = 0L;
        String str5 = "com.oplus.picture.identity";
        PICTURE_IDENTITY = new CaptureResultKey<>(str5, Long.class, OplusGLSurfaceView_15);
        IMAGE_CATEGORY_HEIGHT = new CaptureResultKey<>("com.oplus.image.category.height", Integer.class, OplusGLSurfaceView_13);
        IMAGE_CATEGORY_WIDTH = new CaptureResultKey<>("com.oplus.image.category.width", Integer.class, OplusGLSurfaceView_13);
        IMAGE_CATEGORY_BURST_SHOT = new CaptureResultKey<>("com.oplus.image.category.burst_shot", Boolean.class, z);
        IMAGE_CATEGORY_BURST_COUNT = new CaptureResultKey<>("com.oplus.image.category.burst_count", Integer.class, OplusGLSurfaceView_13);
        long j2 = -1L;
        IMAGE_CATEGORY_BURST_SHOT_FLAG_ID = new CaptureResultKey<>("com.oplus.image.category.burst_shot_flag_id", Long.class, j2);
        IMAGE_CATEGORY_CSHOT_PATH = new CaptureResultKey<>("com.oplus.image.category.cshot_path", String.class, c36801);
        int i2 = -1;
        IMAGE_CATEGORY_REC_BURST_NUMBER = new CaptureResultKey<>("com.oplus.image.category.rec_burst_number", Integer.class, i2);
        IMAGE_CATEGORY_DATE = new CaptureResultKey<>("com.oplus.image.category.date", Long.class, OplusGLSurfaceView_15);
        IMAGE_CATEGORY_FORMAT = new CaptureResultKey<>("com.oplus.image.category.image_format", Integer.class, OplusGLSurfaceView_13);
        IMAGE_CATEGORY_IMAGE_TIME_STAMP = new CaptureResultKey<>("com.oplus.image.category.image_time_stamp", Long.class, OplusGLSurfaceView_15);
        IMAGE_CATEGORY_WATERMARK_PATH = new CaptureResultKey<>("com.oplus.image.category.watermark_path", String.class, c36801);
        IMAGE_CATEGORY_MERGE_IDENTITY = new CaptureResultKey<>("com.oplus.image.category.mergeIdentity", Long.class, j2);
        RESULT_CAPTURE_FOR_VIDEO = new CaptureResultKey<>("com.oplus.result.capture.for.video", Boolean.class, z);
        IMAGE_CATEGORY_META_TIME_STAMP = new CaptureResultKey<>("com.oplus.image.category.meta_time_stamp", Long.class, OplusGLSurfaceView_15);
        IMAGE_CATEGORY_SUPER_TEXT_ENABLE = new CaptureResultKey<>("com.oplus.image.category.super_text_enable", String.class, "0");
        IMAGE_CATEGORY_CUSTOM_BEAUTY_PARAM = new CaptureResultKey<>("com.oplus.image.category.custom_beauty_param", int[].class, c36801);
        IMAGE_CATEGORY_IS_VALID = new CaptureResultKey<>("com.oplus.image.category.is_valid", Boolean.class, z);
        IMAGE_CATEGORY_END_OF_CAPTURE = new CaptureResultKey<>("com.oplus.image.category.end_of_capture", Boolean.class, z);
        HEIF_PROCESS_IN_APS = new CaptureResultKey<>("com.oplus.result.heif_process_in_aps", Boolean.class, z);
        NOISE_REDUCTION_STRENGTH = new CaptureResultKey<>("com.oplus.result.noise_reduction_strength", Integer.class, OplusGLSurfaceView_13);
        APS_PROC_TIMER = new CaptureResultKey<>("com.oplus.result.aps_proc_timer", HashMap.class, new HashMap());
        MESH_PTR = new CaptureResultKey<>("com.oplus.result.mesh_ptr", Long.class, OplusGLSurfaceView_15);
        EXIF_SENSOR_NAME = new CaptureResultKey<>("com.oplus.exif.sensor_name", String.class, c36801);
        EXIF_ROTATE = new CaptureResultKey<>("com.oplus.exif.rotate", Integer.class, c36801);
        EXIF_ISO = new CaptureResultKey<>("com.oplus.exif.iso", Long.class, c36801);
        EXIF_WHITE_BALANCE_MODE = new CaptureResultKey<>("com.oplus.exif.white_balance_mode", Integer.class, c36801);
        EXIF_FLASH_VALUE = new CaptureResultKey<>("com.oplus.exif.flash_value", Integer.class, c36801);
        EXIF_LATITUDE_REF = new CaptureResultKey<>("com.oplus.exif.latitude_ref", String.class, c36801);
        EXIF_LONGITUDE_REF = new CaptureResultKey<>("com.oplus.exif.longitude_ref", String.class, c36801);
        EXIF_ALTITUDE_REF = new CaptureResultKey<>("com.oplus.exif.altitude_ref", Integer.class, c36801);
        EXIF_GPS_DATE_STAMP = new CaptureResultKey<>("com.oplus.exif.gps_date_stamp", String.class, c36801);
        EXIF_DATE_TIME = new CaptureResultKey<>("com.oplus.exif.date_time", String.class, c36801);
        EXIF_SUB_DATE_TIME = new CaptureResultKey<>("com.oplus.exif.sub_date_time", String.class, c36801);
        EXIF_MODEL = new CaptureResultKey<>("com.oplus.exif.model", String.class, c36801);
        EXIF_MANUFACTURE = new CaptureResultKey<>("com.oplus.exif.manufacture", String.class, c36801);
        EXIF_COMMENTS = new CaptureResultKey<>("com.oplus.exif.comments", String.class, c36801);
        EXIF_MIRROR = new CaptureResultKey<>("com.oplus.exif.mirror", Boolean.class, c36801);
        EXIF_NUMBER = new CaptureResultKey<>("com.oplus.exif.number", Object.class, c36801);
        EXIF_EXP_TIME = new CaptureResultKey<>("com.oplus.exif.exp_time", Object.class, c36801);
        EXIF_APERTURE = new CaptureResultKey<>("com.oplus.exif.aperture", Object.class, c36801);
        EXIF_EXPOSURE_BIAS = new CaptureResultKey<>("com.oplus.exif.exposure_bias", Object.class, c36801);
        EXIF_FOCAL_LENGTH = new CaptureResultKey<>("com.oplus.exif.focal_length", Object.class, c36801);
        EXIF_LATITUDE = new CaptureResultKey<>("com.oplus.exif.latitude", Object[].class, c36801);
        EXIF_LONGITUDE = new CaptureResultKey<>("com.oplus.exif.longitude", Object[].class, c36801);
        EXIF_ALTITUDE = new CaptureResultKey<>("com.oplus.exif.altitude", Object.class, c36801);
        EXIF_GPS_TIME_STAMP = new CaptureResultKey<>("com.oplus.exif.gps_time_stamp", Object[].class, c36801);
        EXIF_SUPPORT_DCIP3 = new CaptureResultKey<>("com.oplus.exif.support_dcip3", Boolean.class, c36801);
        EXIF_SUPPORT_LOCATION = new CaptureResultKey<>("com.oplus.exif.support_location", Boolean.class, c36801);
        EXIF_SUPPORT_LOCATION_TIME_STAMP = new CaptureResultKey<>("com.oplus.exif.support_location_time_stamp", Boolean.class, c36801);
        EXIF_IMAGE_WIDTH = new CaptureResultKey<>("com.oplus.exif.image_width", Integer.class, c36801);
        EXIF_IMAGE_HEIGHT = new CaptureResultKey<>("com.oplus.exif.image_height", Integer.class, c36801);
        EXIF_TIFFYCRCB_POSITIONING = new CaptureResultKey<>("com.oplus.exif.tiffycrcb_positioning", Integer.class, c36801);
        EXIF_TIFF_RESOLUTION_UNIT = new CaptureResultKey<>("com.oplus.exif.tiff_resolution_unit", Integer.class, c36801);
        EXIF_TIFFX_RESOLUTIION = new CaptureResultKey<>("com.oplus.exif.tiffx_resolution", Object.class, c36801);
        EXIF_TIFFY_RESOLUTION = new CaptureResultKey<>("com.oplus.exif.tiffy_resolution", Object.class, c36801);
        EXIF_EXPOSURE_PROGRAM = new CaptureResultKey<>("com.oplus.exif.exposure_program", Integer.class, c36801);
        EXIF_VERSION = new CaptureResultKey<>("com.oplus.exif.version", String.class, c36801);
        EXIF_COMPONENT_CONFIG = new CaptureResultKey<>("com.oplus.exif.component_config", String.class, c36801);
        EXIF_SHUTTER_SPEED = new CaptureResultKey<>("com.oplus.exif.shutter_speed", Object.class, c36801);
        EXIF_BRIGHTNESS = new CaptureResultKey<>("com.oplus.exif.brightness", Object.class, c36801);
        EXIF_MAX_APERTURE = new CaptureResultKey<>("com.oplus.exif.max_aperture", Object.class, c36801);
        EXIF_METERING_MODE = new CaptureResultKey<>("com.oplus.exif.metering_mode", Integer.class, c36801);
        EXIF_MAKER_NOTE = new CaptureResultKey<>("com.oplus.exif.maker_note", String.class, c36801);
        EXIF_FLASH_PIX_VERSION = new CaptureResultKey<>("com.oplus.exif.flash_pix_version", String.class, c36801);
        EXIF_COLOR_SPACE = new CaptureResultKey<>("com.oplus.exif.color_space", Integer.class, c36801);
        EXIF_SENSING_METHOD = new CaptureResultKey<>("com.oplus.exif.sensing_method", Integer.class, c36801);
        EXIF_SCENE_TYPE = new CaptureResultKey<>("com.oplus.exif.scene_type", String.class, c36801);
        EXIF_EXPOSURE_MODE = new CaptureResultKey<>("com.oplus.exif.exposure_mode", Integer.class, c36801);
        EXIF_FOCAL_LENGTH_35MM = new CaptureResultKey<>("com.oplus.exif.focal_length_35mm", Integer.class, c36801);
        EXIF_SCENE_CAPTURE_TYPE = new CaptureResultKey<>("com.oplus.exif.scene_capture_type", Integer.class, c36801);
        EXIF_INTEROP_INDEX_STR = new CaptureResultKey<>("com.oplus.exif.interop_index_str", String.class, c36801);
        EXIF_INTEROP_VERSION = new CaptureResultKey<>("com.oplus.exif.interop_version", String.class, c36801);
        EXIF_HEIC_QUALITY = new CaptureResultKey<>("com.oplus.exif.heic_quality", Integer.class, c36801);
        PREVIEW_RESULT_WIDTH = new PreviewResultKey<>("com.oplus.result.width", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_CROP_LEFT = new PreviewResultKey<>("com.oplus.result.crop_left", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_CROP_TOP = new PreviewResultKey<>("com.oplus.result.crop_top", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_CROP_RIGHT = new PreviewResultKey<>("com.oplus.result.crop_right", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_CROP_BOTTOM = new PreviewResultKey<>("com.oplus.result.crop_bottom", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_HEIGHT = new PreviewResultKey<>("com.oplus.result.height", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_IDENTITY = new PreviewResultKey<>(str5, Long.class, OplusGLSurfaceView_15);
        PREVIEW_RESULT_MOTION_DETECTED = new PreviewResultKey<>("com.oplus.result.motion_detected", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_START_INTERPOLATION_FRAME = new PreviewResultKey<>("com.oplus.result.start_interpolation_frame", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_LAST_VDIEO_FRAME = new PreviewResultKey<>("com.oplus.result.last_video_frame", Integer.class, OplusGLSurfaceView_13);
        KEY_CAMERA_RESULT_APS_INIT_FINISH = new PreviewResultKey<>("com.oplus.result.aps_init_finish", String.class, c36801);
        KEY_CAMERA_RESULT_REF_TIMESTAMP = new PreviewResultKey<>("com.oplus.result.ref_timestamp", Long.class, OplusGLSurfaceView_15);
        PREVIEW_RESULT_REQUEST_FORMAT = new PreviewResultKey<>("com.oplus.preview.request_format", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_MULTI_FRAME_COUNT = new PreviewResultKey<>("com.oplus.preview.multi_frame_count", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_SUPER_NIGHT_SCENE = new PreviewResultKey<>("com.oplus.preview.super_night_scene", Integer.class, OplusGLSurfaceView_13);
        int i3 = 1;
        PREVIEW_RESULT_META_INDEX = new PreviewResultKey<>("com.oplus.preview.meta_index", Integer.class, i3);
        PREVIEW_RESULT_NIGHT_TOTAL_EXPTIME = new PreviewResultKey<>("com.oplus.preview.night_total_exptime", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_OFFLINE_NIGHT_EXPTIME = new PreviewResultKey<>("com.oplus.preview.offline_night_exptime", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_SCENE_MODE = new PreviewResultKey<>("com.oplus.preview.scene_mode", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_SHOW_HDR_ICON = new PreviewResultKey<>("com.oplus.preview.show_hdr_icon", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_FEATURE_TYPE = new PreviewResultKey<>("com.oplus.preview.feature_type", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_THUMBNAIL_INDEX = new PreviewResultKey<>("com.oplus.preview.thumbnail_index", Integer.class, i3);
        CAPTURE_RESULT_NIGHT_TOTAL_EXPTIME = new CaptureResultKey<>("com.oplus.capture.night_total_exptime", Long.class, OplusGLSurfaceView_15);
        CAPTURE_RESULT_FIRST_EXPOSURE_TIME = new CaptureResultKey<>("com.oplus.capture.first_exposure_time", Long.class, OplusGLSurfaceView_15);
        PREVIEW_RESULT_ALGO_FLAG = new PreviewResultKey<>("com.oplus.preview.algo_flag", String[].class, c36801);
        PREVIEW_RESULT_CAPTURE_EV_LIST = new PreviewResultKey<>("com.oplus.preview.capture_ev_list", int[].class, c36801);
        PREVIEW_RESULT_SENSOR_MASK = new PreviewResultKey<>("com.oplus.preview.sensor_mask", int[].class, c36801);
        PREVIEW_RESULT_MASTER_PIPELINE = new PreviewResultKey<>("com.oplus.preview.master_pipeline", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_BRACKET_MODE = new PreviewResultKey<>("com.oplus.preview.bracket_mode", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_DRAWTEXT_BRACKET_MODE = new PreviewResultKey<>("com.oplus.preview.drawtext_bracket_mode", String.class, c36801);
        PREVIEW_RESULT_DRAWTEXT_SCENE_MODE = new PreviewResultKey<>("com.oplus.preview.drawtext_scene_mode", String.class, c36801);
        PREVIEW_RESULT_DRAWTEXT_FEATURE_TYPE = new PreviewResultKey<>("com.oplus.preview.drawtext_feature_type", String.class, c36801);
        PREVIEW_RESULT_DRAWTEXT_HDR_TYPE = new PreviewResultKey<>("com.oplus.preview.drawtext_hdr_type", String.class, c36801);
        PREVIEW_RESULT_ASD = new PreviewResultKey<>("com.oplus.preview.asd", String.class, c36801);
        PREVIEW_RESULT_ANTIBANDING = new PreviewResultKey<>("com.oplus.preview.antibanding", String.class, c36801);
        PREVIEW_RESULT_RECTIFY = new PreviewResultKey<>("com.oplus.preview.rectify", String.class, c36801);
        PREVIEW_RESULT_PF = new PreviewResultKey<>("com.oplus.preview.pf", String.class, c36801);
        PREVIEW_RESULT_LSD = new PreviewResultKey<>("com.oplus.preview.lsd", String.class, c36801);
        PREVIEW_RESULT_RTB = new PreviewResultKey<>("com.oplus.preview.rtb", String.class, c36801);
        PREVIEW_RESULT_AICOLOR = new PreviewResultKey<>("com.oplus.preview.aicolor", String.class, c36801);
        PREVIEW_RESULT_VIDEO_HYPERLAPSE = new PreviewResultKey<>("com.oplus.preview.hyperlapse", String.class, c36801);
        KEY_ALGO_VISUALIZATION_KEY = new PreviewResultKey<>("com.oplus.preview.algo.visualization.key", String.class, c36801);
        KEY_ALGO_VISUALIZATION_VALUE = new PreviewResultKey<>("com.oplus.preview.algo.visualization.value", String.class, c36801);
        PREVIEW_RESULT_MFSR_FRAME_COUNT = new PreviewResultKey<>("com.oplus.preview.mfsr_frame_count", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_SUPPORT_ZOOM_FEATURE = new PreviewResultKey<>("com.oplus.preview.support_zoom_feature", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_AI_SHUTTER = new PreviewResultKey<>("com.oplus.preview.ai_shutter", Boolean.class, z);
        PREVIEW_RESULT_BOKEN_STATE = new PreviewResultKey<>("com.oplus.preview.rtb_msg", Integer.class, i2);
        PREVIEW_RESULT_AI_SCENE = new PreviewResultKey<>("com.oplus.preview.asd_scene_icon", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_TUNING_SCENE = new PreviewResultKey<>("com.oplus.preview.asd_tuning_scene", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_HDR_SCOPE = new PreviewResultKey<>("com.oplus.preview.asd_hdr_scope", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_MASTER_CAMERA_ID = new PreviewResultKey<>("com.oplus.preview.sat_master_camera_id", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_ACTIVE_MAP = new PreviewResultKey<>("com.oplus.preview.sat_active_map", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_LENS_DIRTY = new PreviewResultKey<>("com.oplus.preview.lsd_is_dirty", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_GESTURE_ACTION_TYPE = new PreviewResultKey<>("com.oplus.preview.gesture.action.type", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_VIDEO_EIS = new PreviewResultKey<>("com.oplus.preview.video_eis_on", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_FRAME_ID = new PreviewResultKey<>("com.oplus.preview.frame_id", Integer.class, OplusGLSurfaceView_13);
        PREVIEW_RESULT_CAMERA_TYPE = new PreviewResultKey<>("com.oplus.result.camera.type", String.class, c36801);
        PREVIEW_RESULT_CAMERA_MODE = new PreviewResultKey<>("com.oplus.result.camera.mode", String.class, c36801);
        PREVIEW_RESULT_CAMERA_IMAGE = new PreviewResultKey<>("com.oplus.result.image_buffer_image", Image.class, c36801);
        PREVIEW_RESULT_HARDWARE_BUFFER = new PreviewResultKey<>("com.oplus.result.image_buffer_hardware_buffer", HardwareBuffer.class, c36801);
        PREVIEW_RESULT_IMAGE_TIME_STAMP = new PreviewResultKey<>("com.oplus.result.image_buffer_time_stamp", Long.class, OplusGLSurfaceView_15);
        PREVIEW_RESULT_IMAGE_IS_VALID = new PreviewResultKey<>("com.oplus.result.image_buffer_is_valid", Boolean.class, z);
        PREVIEW_RESULT_CAMERA_ID = new PreviewResultKey<>("com.oplus.preview.camera_id", Integer.class, i2);
        PREVIEW_RESULT_AIS_STATE = new PreviewResultKey<>("com.oplus.preview.ais_state", Integer.class, OplusGLSurfaceView_13);
    }

    public static final class ConfigureKey<T> {
        private String mKeyName;
        private Class<T> mType;

        private ConfigureKey(String str, Class<T> cls) {
            this.mKeyName = null;
            this.mType = null;
            this.mKeyName = str;
            this.mType = cls;
        }

        public String getKeyName() {
            return this.mKeyName;
        }

        public String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }

    public static final class PreviewKey<T> {
        private String mKeyName;
        private Class<T> mType;

        private PreviewKey(String str, Class<T> cls) {
            this.mKeyName = null;
            this.mType = null;
            this.mKeyName = str;
            this.mType = cls;
        }

        public String getKeyName() {
            return this.mKeyName;
        }

        public String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }

    public static final class CaptureResultKey<T> {
        private T mDefault;
        private String mKeyName;
        private Class<T> mType;

        private CaptureResultKey(String str, Class<T> cls, T t) {
            this.mKeyName = null;
            this.mType = null;
            this.mDefault = null;
            this.mKeyName = str;
            this.mType = cls;
            this.mDefault = t;
        }

        public String getKeyName() {
            return this.mKeyName;
        }

        public Class<T> getType() {
            return this.mType;
        }

        public T getDefault() {
            return this.mDefault;
        }

        public String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }

    public static final class PreviewResultKey<T> {
        private T mDefault;
        private String mKeyName;
        private Class<T> mType;

        private PreviewResultKey(String str, Class<T> cls, T t) {
            this.mKeyName = null;
            this.mType = null;
            this.mDefault = null;
            this.mKeyName = str;
            this.mType = cls;
            this.mDefault = t;
        }

        public String getKeyName() {
            return this.mKeyName;
        }

        public Class<T> getType() {
            return this.mType;
        }

        public T getDefault() {
            return this.mDefault;
        }

        public String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType;
        }
    }
}
