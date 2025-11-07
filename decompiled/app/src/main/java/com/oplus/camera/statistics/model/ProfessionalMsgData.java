package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class ProfessionalMsgData {
    public static final java.lang.String VALUE_PROFESSION_SAVE = "save";
    public static final java.lang.String VALUE_PROFESSION_SUPER_RAW = "super_raw";
    public static final java.lang.String VALUE_PROFESSION_USE = "use";

    public static java.lang.String buildPhotoFormat(java.lang.String str) {
        if ("off".equals(str)) {
            return com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
        }
        if ("on_renamed".equals(str)) {
            return "raw";
        }
        if ("super_raw".equals(str)) {
            return "super_raw";
        }
        return null;
    }

    public static java.lang.String buildParameterSaving(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || "off".equals(str)) ? str : str.toUpperCase(java.util.Locale.US);
    }
}
