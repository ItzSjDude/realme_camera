package com.oplus.camera.statistics.model;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ProfessionalMsgData {
    public static final String VALUE_PROFESSION_SAVE = "save";
    public static final String VALUE_PROFESSION_SUPER_RAW = "super_raw";
    public static final String VALUE_PROFESSION_USE = "use";

    public static String buildPhotoFormat(String str) {
        if ("off".equals(str)) {
            return CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
        }
        if ("on".equals(str)) {
            return "raw";
        }
        if ("super_raw".equals(str)) {
            return "super_raw";
        }
        return null;
    }

    public static String buildParameterSaving(String str) {
        return (TextUtils.isEmpty(str) || "off".equals(str)) ? str : str.toUpperCase(Locale.US);
    }
}
