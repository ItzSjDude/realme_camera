package com.oplus.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: OtaUpdateManager.java */
/* renamed from: com.oplus.camera.x */
/* loaded from: classes2.dex */
public class OtaUpdateManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23234a = "OtaUpdateManager";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ComboPreferences f23235b;

    public OtaUpdateManager(ComboPreferences comboPreferences) {
        this.f23235b = null;
        this.f23235b = comboPreferences;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24828a(Context context) {
        ComboPreferences comboPreferences = this.f23235b;
        if (comboPreferences == null || context == null) {
            return;
        }
        String string = comboPreferences.getString(CameraUIInterface.KEY_CAMERA_SLOGAN_VERSION, null);
        if (TextUtils.isEmpty(string)) {
            this.f23235b.edit().putString(CameraUIInterface.KEY_CAMERA_SLOGAN_VERSION, "2.0.3").apply();
            CameraLog.m12959b(this.f23234a, "updateSloganFromOTA, apply slogan version: 2.0.3");
            return;
        }
        if ("2.0.3".equals(string)) {
            CameraLog.m12959b(this.f23234a, "updateSloganFromOTA, current version is 2.0.3, no need to upgrade");
            return;
        }
        if (string.startsWith("1.0.") || string.startsWith("1.1.")) {
            m24826b(context, "2.0.3", string);
        } else if (string.startsWith("2.0.")) {
            m24824a(context, "2.0.3", string);
        }
        this.f23235b.edit().putString(CameraUIInterface.KEY_CAMERA_SLOGAN_VERSION, "2.0.3").apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24824a(Context context, String str, String str2) {
        Set<String> stringSet = this.f23235b.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, Collections.EMPTY_SET);
        if (stringSet != null) {
            try {
                if (!stringSet.isEmpty()) {
                    String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
                    String str3 = "on";
                    String str4 = stringSet.contains(stringArray[0]) ? "on" : "off";
                    String str5 = stringSet.contains(stringArray[2]) ? "on" : "off";
                    if (!stringSet.contains(stringArray[1])) {
                        str3 = "off";
                    }
                    this.f23235b.edit().putString(CameraUIInterface.PRE_KEY_WATERMARK_PHONE, str4).putString(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, str5).putString(CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME, str3).apply();
                    CameraLog.m12959b(this.f23234a, "updateSloganFromOTAV2, isPhoneOn: " + str4 + ", isLocationOn: " + str5 + ", isTimeOn: " + str3);
                }
            } catch (Throwable th) {
                CameraLog.m12965d(this.f23234a, "updateSloganFromOTAV2, fail to update preference", th);
            }
        }
        CameraLog.m12959b(this.f23234a, "updateSloganFromOTAV2, preSloganVersion: " + str2 + ", currentVersion: " + str);
        m24825a("updateSloganFromOTAV2");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m24826b(Context context, String str, String str2) {
        String str3 = "on";
        String string = this.f23235b.getString(CameraUIInterface.KEY_SLOGAN_OWNER, null);
        String string2 = this.f23235b.getString(CameraUIInterface.KEY_SLOGAN_CUSTOMIZE, null);
        if (string2 != null) {
            string = string2;
        }
        if (string != null) {
            if (string.length() > 10) {
                string = string.substring(0, 10);
            }
            this.f23235b.edit().putString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, string).apply();
        }
        try {
            boolean z = this.f23235b.getBoolean(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, false);
            boolean z2 = this.f23235b.getBoolean(CameraUIInterface.PRE_KEY_LEGACY_WATERMARK_TIME, false);
            boolean z3 = this.f23235b.getBoolean(CameraUIInterface.KEY_WATERMARK_DEVICE, false);
            if (z || z2 || z3) {
                HashSet hashSet = new HashSet();
                String[] stringArray = context.getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
                if (z) {
                    hashSet.add(stringArray[2]);
                }
                if (z2) {
                    hashSet.add(stringArray[1]);
                }
                if (z3) {
                    hashSet.add(stringArray[0]);
                }
                SharedPreferences.Editor editorPutString = this.f23235b.edit().putString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "on").putString(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, z ? "on" : "off").putString(CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME, z2 ? "on" : "off");
                if (!z3) {
                    str3 = "off";
                }
                editorPutString.putString(CameraUIInterface.PRE_KEY_WATERMARK_PHONE, str3).putStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, hashSet).remove(CameraUIInterface.PRE_KEY_LEGACY_WATERMARK_TIME).remove(CameraUIInterface.KEY_WATERMARK_DEVICE).apply();
            } else {
                this.f23235b.edit().remove(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION).remove(CameraUIInterface.PRE_KEY_LEGACY_WATERMARK_TIME).remove(CameraUIInterface.KEY_WATERMARK_DEVICE).apply();
            }
        } catch (Throwable th) {
            CameraLog.m12965d(this.f23234a, "updateSloganFromOTAV1, preference is already upgraded", th);
        }
        CameraLog.m12959b(this.f23234a, "updateSloganFromOTAV1, preSloganVersion: " + str2 + ", currentVersion: " + str);
        m24825a("updateSloganFromOTAV1");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24825a(String str) {
        try {
            CameraLog.m12959b(this.f23234a, str + ", function: " + this.f23235b.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, null));
            CameraLog.m12959b(this.f23234a, str + ", author: " + this.f23235b.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, null));
            CameraLog.m12959b(this.f23234a, str + ", device: " + this.f23235b.getString(CameraUIInterface.PRE_KEY_WATERMARK_PHONE, null));
            CameraLog.m12959b(this.f23234a, str + ", location: " + this.f23235b.getString(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, null));
            CameraLog.m12959b(this.f23234a, str + ", time: " + this.f23235b.getString(CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME, null));
            CameraLog.m12959b(this.f23234a, str + ", display: " + this.f23235b.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, null));
        } catch (Throwable th) {
            CameraLog.m12965d(this.f23234a, "printSloganSettings, fail to get preference", th);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24827a() {
        ComboPreferences comboPreferences = this.f23235b;
        if (comboPreferences != null) {
            String string = comboPreferences.getString(CameraUIInterface.KEY_CAMERA_GRID_VERSION, null);
            if ("1.0.0".equals(string)) {
                return;
            }
            String str = "on".equals(this.f23235b.getString(CameraUIInterface.KEY_ASSISTANT_LINE, "off")) ? "grid" : "off";
            ComboPreferences.m11062a(CameraUIInterface.KEY_LINE_PHOTO);
            ComboPreferences.m11062a(CameraUIInterface.KEY_LINE_VIDEO);
            if (!"off".equals(str)) {
                this.f23235b.edit().putString(CameraUIInterface.KEY_CAMERA_GRID_VERSION, "1.0.0").putString(CameraUIInterface.KEY_LINE_PHOTO, str).putString(CameraUIInterface.KEY_LINE_VIDEO, str).apply();
            }
            CameraLog.m12959b(this.f23234a, "updateGridFromOTA, preGridVersion: " + string + ", currentVersion: 1.0.0, assistantLine: " + str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24830b(Context context) {
        if (this.f23235b == null || context == null) {
            return;
        }
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT);
        boolean configBooleanValue2 = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_V2_SUPPORT);
        boolean configBooleanValue3 = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_NEON_SUPPORT);
        boolean configBooleanValue4 = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT);
        if (this.f23235b.getString(CameraUIInterface.KEY_FILTER_VERSION, null) == null) {
            int OplusGLSurfaceView_13 = 0;
            SharedPreferences sharedPreferencesM11072a = this.f23235b.m11072a(context, 0);
            int i2 = 1;
            SharedPreferences sharedPreferencesM11072a2 = this.f23235b.m11072a(context, 1);
            int i3 = sharedPreferencesM11072a.getInt(CameraUIInterface.KEY_VIDEO_FILTER_INDEX, -1);
            int i4 = sharedPreferencesM11072a2.getInt(CameraUIInterface.KEY_VIDEO_FILTER_INDEX, -1);
            if (configBooleanValue || configBooleanValue2) {
                OplusGLSurfaceView_13 = 1;
            } else {
                i2 = 0;
            }
            if (configBooleanValue3) {
                OplusGLSurfaceView_13++;
                i2++;
            }
            if (configBooleanValue4) {
                OplusGLSurfaceView_13 += 3;
            }
            if (OplusGLSurfaceView_13 == i3) {
                sharedPreferencesM11072a.edit().putInt(CameraUIInterface.KEY_VIDEO_FILTER_INDEX, FilterHelper.m22644r()).apply();
            }
            if (i2 == i4) {
                sharedPreferencesM11072a2.edit().putInt(CameraUIInterface.KEY_VIDEO_FILTER_INDEX, FilterHelper.m22646t()).apply();
            }
            SharedPreferences.Editor editorEdit = this.f23235b.edit();
            editorEdit.putString(CameraUIInterface.KEY_FILTER_VERSION, "20211026");
            editorEdit.apply();
            CameraLog.m12954a(this.f23234a, "updateFilterFromOTA, preBackFilterIndex: " + i3 + ", preFrontFilterIndex: " + i4 + ", preBackNoneFilterIndex: " + OplusGLSurfaceView_13 + ", preFrontNoneFilterIndex: " + i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24829b() {
        ComboPreferences comboPreferences = this.f23235b;
        if (comboPreferences == null || "1.0.0".equals(comboPreferences.getString(CameraUIInterface.KEY_CAMERA_AI_SCN_VERSION, null))) {
            return;
        }
        String string = this.f23235b.getString(CameraUIInterface.KEY_PI_AI, null);
        if (TextUtils.equals("on", this.f23235b.getString(CameraUIInterface.KEY_AI_SCN, null)) || TextUtils.equals("on", string)) {
            this.f23235b.edit().putString(CameraUIInterface.KEY_CAMERA_AI_SCN_VERSION, "1.0.0").putString(CameraUIInterface.KEY_PI_AI, "on").putString(CameraUIInterface.KEY_AI_SCN, "on").apply();
        }
    }
}
