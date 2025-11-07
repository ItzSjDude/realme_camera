package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class ReminderMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    public static final java.lang.String CODE_10BITS_UNSUPPORT_CONTINUOUS = "10bit_unsupport_continuous";
    public static final java.lang.String CODE_BATTERY_FLASH = "battery_flash";
    public static final java.lang.String CODE_BATTERY_VIDEO = "battery_video";
    public static final java.lang.String CODE_CAMERA_HIGH_TEMPERATURE_OUT_PREVIEW_DISABLE = "camera_high_temperature_out_preview_disable";
    public static final java.lang.String CODE_CHARGE_FALSE = "charge_false";
    public static final java.lang.String CODE_CHARGE_TRUE = "charge_true";
    public static final java.lang.String CODE_CLEAN_LENS = "clean_lens";
    public static final java.lang.String CODE_FLASH_ON = "flash_on";
    public static final java.lang.String CODE_IMMOVABLE_MODE = "immovable_mode";
    public static final java.lang.String CODE_MEMORY_CAPTURE = "memory_capture";
    public static final java.lang.String CODE_MORE_FACE = "more_face";
    public static final java.lang.String CODE_MOVE_CLOSER = "move_closer";
    public static final java.lang.String CODE_NO_FACE = "no_face";
    public static final java.lang.String CODE_TEMPS_CAM = "temps_cam";
    public static final java.lang.String CODE_TEMPS_FLASH = "temps_flash";
    public static final java.lang.String CODE_TEMPS_VIDEO = "temps_video";
    public static final java.lang.String CODE_TEMP_STOP_ALL_VIDEO = "temp_stop_all_video";
    public static final java.lang.String CODE_TEMP_STOP_HIGH_CONSUMPTION_VIDEO = "temp_stop_high_consumption_video";
    public static final java.lang.String CODE_TIME_SHORT = "time_short";
    public static final java.lang.String CODE_TRY_WIDE_ANGLE = "try_wide_angle";
    public static final java.lang.String CODE_VIDEO_SIZE_LIMIT = "size_limit";
    public static final java.lang.String CODE_VIDEO_UNPARSEABLE = "video_unparseable";
    public static final java.lang.String EVENT_AI_SCENE_CLICK = "ai_effect_click";
    public static final java.lang.String EVENT_ID = "reminder";
    private static final java.lang.String KEY_AI_LABEL_SWITCH = "ai_label_switch";
    public static final java.lang.String KEY_AI_SCENE = "ai_scene";
    private static final java.lang.String KEY_IS_RECORDING = "is_recording";
    private static final java.lang.String KEY_REMINDER_CODE = "reminder_code";
    private static final java.lang.String KEY_REMINDER_TRIGGER = "reminder_trigger";
    private static final java.lang.String KEY_REMINDER_TYPE = "reminder_type";
    private static final java.lang.String KEY_SUPER_TEXT_SWITCH = "superText_switch";
    private static final java.lang.String KEY_ULTRA_WIDE_SWITCH = "ultraWide_switch";
    private static final java.lang.String TAG = "ReminderMsgData";
    public static final java.lang.String TYPE_ADVICE = "advice";
    public static final java.lang.String TYPE_AI_SCENE = "ai_scene";
    public static final java.lang.String TYPE_BOKEH_CODE = "bokeh_code";
    public static final java.lang.String TYPE_DISABLE_CODE = "disable_code";
    public java.lang.String mReminderAILabelSwitch;
    public java.lang.String mReminderAIScene;
    public java.lang.String mReminderAISuperTextSwitch;
    public java.lang.String mReminderAIUltraWideSwitch;
    public java.lang.String mReminderCodeValue;
    public java.lang.String mReminderTriggerValue;
    public java.lang.String mReminderTypeValue;
    public boolean mbRecording;

    public ReminderMsgData(android.content.Context context, boolean z_renamed) {
        super(context, z_renamed ? com.oplus.camera.statistics.model.DcsMsgData.LOGTAG_CAPTURE : com.oplus.camera.statistics.model.DcsMsgData.LOGTAG_VIDEO, EVENT_ID);
        this.mReminderTypeValue = "";
        this.mReminderCodeValue = "";
        this.mReminderTriggerValue = "";
        this.mReminderAILabelSwitch = "";
        this.mReminderAIScene = "";
        this.mReminderAISuperTextSwitch = "";
        this.mReminderAIUltraWideSwitch = "";
        this.mbRecording = false;
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        checkEmptyCondition(KEY_REMINDER_TYPE, this.mReminderTypeValue);
        checkEmptyCondition(KEY_REMINDER_CODE, this.mReminderCodeValue);
        checkEmptyCondition(KEY_REMINDER_TRIGGER, this.mReminderTriggerValue);
        checkEmptyCondition("ai_scene", this.mReminderAIScene);
        checkEmptyCondition(KEY_AI_LABEL_SWITCH, this.mReminderAILabelSwitch);
        checkNoAnyCondition(KEY_IS_RECORDING, java.lang.String.valueOf(this.mbRecording));
        checkEmptyCondition(KEY_SUPER_TEXT_SWITCH, this.mReminderAISuperTextSwitch);
        checkEmptyCondition(KEY_ULTRA_WIDE_SWITCH, this.mReminderAIUltraWideSwitch);
        super.report();
    }

    public void buildAISceneItem() {
        this.mEventId = EVENT_AI_SCENE_CLICK;
    }
}
