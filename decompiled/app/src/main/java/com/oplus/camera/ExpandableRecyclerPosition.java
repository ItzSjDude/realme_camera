package com.oplus.camera;

/* compiled from: OtaUpdateManager.java */
/* loaded from: classes2.dex */
public class x_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7429a = "OtaUpdateManager";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ComboPreferences f7430b;

    public x_renamed(com.oplus.camera.ComboPreferences comboPreferences) {
        this.f7430b = null;
        this.f7430b = comboPreferences;
    }

    public void a_renamed(android.content.Context context) {
        com.oplus.camera.ComboPreferences comboPreferences = this.f7430b;
        if (comboPreferences == null || context == null) {
            return;
        }
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_SLOGAN_VERSION, null);
        if (android.text.TextUtils.isEmpty(string)) {
            this.f7430b.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_SLOGAN_VERSION, "2.0.3").apply();
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, "updateSloganFromOTA, apply slogan version: 2.0.3");
            return;
        }
        if ("2.0.3".equals(string)) {
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, "updateSloganFromOTA, current version is_renamed 2.0.3, no need to upgrade");
            return;
        }
        if (string.startsWith("1.0.") || string.startsWith("1.1.")) {
            b_renamed(context, "2.0.3", string);
        } else if (string.startsWith("2.0.")) {
            a_renamed(context, "2.0.3", string);
        }
        this.f7430b.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_SLOGAN_VERSION, "2.0.3").apply();
    }

    private void a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.util.Set<java.lang.String> stringSet = this.f7430b.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, java.util.Collections.EMPTY_SET);
        if (stringSet != null) {
            try {
                if (!stringSet.isEmpty()) {
                    java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
                    java.lang.String str3 = "on_renamed";
                    java.lang.String str4 = stringSet.contains(stringArray[0]) ? "on_renamed" : "off";
                    java.lang.String str5 = stringSet.contains(stringArray[2]) ? "on_renamed" : "off";
                    if (!stringSet.contains(stringArray[1])) {
                        str3 = "off";
                    }
                    this.f7430b.edit().putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_PHONE, str4).putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, str5).putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME, str3).apply();
                    com.oplus.camera.e_renamed.b_renamed(this.f7429a, "updateSloganFromOTAV2, isPhoneOn: " + str4 + ", isLocationOn: " + str5 + ", isTimeOn: " + str3);
                }
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.d_renamed(this.f7429a, "updateSloganFromOTAV2, fail to update preference", th);
            }
        }
        com.oplus.camera.e_renamed.b_renamed(this.f7429a, "updateSloganFromOTAV2, preSloganVersion: " + str2 + ", currentVersion: " + str);
        a_renamed("updateSloganFromOTAV2");
    }

    private void b_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = "on_renamed";
        java.lang.String string = this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOGAN_OWNER, null);
        java.lang.String string2 = this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOGAN_CUSTOMIZE, null);
        if (string2 != null) {
            string = string2;
        }
        if (string != null) {
            if (string.length() > 10) {
                string = string.substring(0, 10);
            }
            this.f7430b.edit().putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, string).apply();
        }
        try {
            boolean z_renamed = this.f7430b.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, false);
            boolean z2 = this.f7430b.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_LEGACY_WATERMARK_TIME, false);
            boolean z3 = this.f7430b.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_WATERMARK_DEVICE, false);
            if (z_renamed || z2 || z3) {
                java.util.HashSet hashSet = new java.util.HashSet();
                java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
                if (z_renamed) {
                    hashSet.add(stringArray[2]);
                }
                if (z2) {
                    hashSet.add(stringArray[1]);
                }
                if (z3) {
                    hashSet.add(stringArray[0]);
                }
                android.content.SharedPreferences.Editor editorPutString = this.f7430b.edit().putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "on_renamed").putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, z_renamed ? "on_renamed" : "off").putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME, z2 ? "on_renamed" : "off");
                if (!z3) {
                    str3 = "off";
                }
                editorPutString.putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_PHONE, str3).putStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, hashSet).remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_LEGACY_WATERMARK_TIME).remove(com.oplus.camera.ui.CameraUIInterface.KEY_WATERMARK_DEVICE).apply();
            } else {
                this.f7430b.edit().remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION).remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_LEGACY_WATERMARK_TIME).remove(com.oplus.camera.ui.CameraUIInterface.KEY_WATERMARK_DEVICE).apply();
            }
        } catch (java.lang.Throwable th) {
            com.oplus.camera.e_renamed.d_renamed(this.f7429a, "updateSloganFromOTAV1, preference is_renamed already upgraded", th);
        }
        com.oplus.camera.e_renamed.b_renamed(this.f7429a, "updateSloganFromOTAV1, preSloganVersion: " + str2 + ", currentVersion: " + str);
        a_renamed("updateSloganFromOTAV1");
    }

    private void a_renamed(java.lang.String str) {
        try {
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, str + ", function: " + this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, null));
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, str + ", author: " + this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, null));
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, str + ", device: " + this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_PHONE, null));
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, str + ", location: " + this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, null));
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, str + ", time: " + this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME, null));
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, str + ", display: " + this.f7430b.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, null));
        } catch (java.lang.Throwable th) {
            com.oplus.camera.e_renamed.d_renamed(this.f7429a, "printSloganSettings, fail to get preference", th);
        }
    }

    public void a_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences = this.f7430b;
        if (comboPreferences != null) {
            java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GRID_VERSION, null);
            if ("1.0.0".equals(string)) {
                return;
            }
            java.lang.String str = "on_renamed".equals(this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ASSISTANT_LINE, "off")) ? "grid" : "off";
            com.oplus.camera.ComboPreferences.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_PHOTO);
            com.oplus.camera.ComboPreferences.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO);
            if (!"off".equals(str)) {
                this.f7430b.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GRID_VERSION, "1.0.0").putString(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_PHOTO, str).putString(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO, str).apply();
            }
            com.oplus.camera.e_renamed.b_renamed(this.f7429a, "updateGridFromOTA, preGridVersion: " + string + ", currentVersion: 1.0.0, assistantLine: " + str);
        }
    }

    public void b_renamed(android.content.Context context) {
        if (this.f7430b == null || context == null) {
            return;
        }
        boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT);
        boolean configBooleanValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_RETENTION_V2_SUPPORT);
        boolean configBooleanValue3 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_SUPPORT);
        boolean configBooleanValue4 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT);
        if (this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_VERSION, null) == null) {
            int i_renamed = 0;
            android.content.SharedPreferences sharedPreferencesA = this.f7430b.a_renamed(context, 0);
            int i2 = 1;
            android.content.SharedPreferences sharedPreferencesA2 = this.f7430b.a_renamed(context, 1);
            int i3 = sharedPreferencesA.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX, -1);
            int i4 = sharedPreferencesA2.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX, -1);
            if (configBooleanValue || configBooleanValue2) {
                i_renamed = 1;
            } else {
                i2 = 0;
            }
            if (configBooleanValue3) {
                i_renamed++;
                i2++;
            }
            if (configBooleanValue4) {
                i_renamed += 3;
            }
            if (i_renamed == i3) {
                sharedPreferencesA.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX, com.oplus.camera.ui.preview.a_renamed.j_renamed.r_renamed()).apply();
            }
            if (i2 == i4) {
                sharedPreferencesA2.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX, com.oplus.camera.ui.preview.a_renamed.j_renamed.t_renamed()).apply();
            }
            android.content.SharedPreferences.Editor editorEdit = this.f7430b.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_VERSION, "20211026");
            editorEdit.apply();
            com.oplus.camera.e_renamed.a_renamed(this.f7429a, "updateFilterFromOTA, preBackFilterIndex: " + i3 + ", preFrontFilterIndex: " + i4 + ", preBackNoneFilterIndex: " + i_renamed + ", preFrontNoneFilterIndex: " + i2);
        }
    }

    public void b_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences = this.f7430b;
        if (comboPreferences == null || "1.0.0".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_AI_SCN_VERSION, null))) {
            return;
        }
        java.lang.String string = this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, null);
        if (android.text.TextUtils.equals("on_renamed", this.f7430b.getString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN, null)) || android.text.TextUtils.equals("on_renamed", string)) {
            this.f7430b.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_AI_SCN_VERSION, "1.0.0").putString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, "on_renamed").putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN, "on_renamed").apply();
        }
    }
}
