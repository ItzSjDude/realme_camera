package com.oplus.camera.aps.config;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUITool;
import com.oplus.camera.p172ui.menu.OptionItemConfig;
import com.oplus.ocs.camera.appinterface.adapter.CameraUnitUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraConfig {
    private static final String TAG = "CameraConfig";
    private static ConfigDataBase sConfigDataBase;
    private static boolean sbInit;

    public static synchronized void initialize(Context context) {
        CameraLog.m12954a(TAG, "initialize, sbInit: " + sbInit);
        if (!sbInit) {
            CameraLog.m12952a("CameraConfig.initialize");
            sConfigDataBase = new ConfigDataBase();
            sConfigDataBase.parseDefaultProjectConfig();
            sConfigDataBase.parseProjectConfigFromConfigFile(context);
            sConfigDataBase.parseMenuPanel();
            sConfigDataBase.parseMenuSetting();
            sConfigDataBase.parseDefaultMenuSettingConfigMap();
            sConfigDataBase.parseOptionItemConfig();
            sbInit = true;
            CameraLog.m12958b("CameraConfig.initialize");
        }
        CameraLog.m12954a(TAG, "initialize X");
    }

    public static List<String> getSupportedList(String str, int OplusGLSurfaceView_13) {
        if (sConfigDataBase.getOptionItemConfigs() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) ? "_front_camera_supported" : "_back_camera_supported");
        String string = sb.toString();
        for (OptionItemConfig c3241c : sConfigDataBase.getOptionItemConfigs()) {
            if (c3241c != null && (c3241c.m20468a().equals(str) || c3241c.m20468a().equals(string))) {
                return c3241c.m20470b();
            }
        }
        return null;
    }

    public static boolean getSupportSettingMenuKey(String str) {
        return (TextUtils.isEmpty(str) || sConfigDataBase.getMenuSettingList() == null || !sConfigDataBase.getMenuSettingList().contains(str)) ? false : true;
    }

    public static String getOptionKeyDefaultValue(String str, int OplusGLSurfaceView_13) {
        try {
            if (sConfigDataBase.getDefaultMenuSettingConfig() == null) {
                return null;
            }
            String str2 = str + "_default";
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) ? "_front_camera" : "_back_camera");
            String string = sb.toString();
            if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(str2)) {
                return sConfigDataBase.getDefaultMenuSettingConfig().get(str2);
            }
            if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(string)) {
                return sConfigDataBase.getDefaultMenuSettingConfig().get(string);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static boolean getConfigBooleanValue(String str, int OplusGLSurfaceView_13) {
        if (sConfigDataBase.getDefaultMenuSettingConfig() == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) ? "_front_camera_supported" : "_back_camera_supported");
        String string = sb.toString();
        if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(str)) {
            return Boolean.parseBoolean(sConfigDataBase.getDefaultMenuSettingConfig().get(str));
        }
        if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(string)) {
            return Boolean.parseBoolean(sConfigDataBase.getDefaultMenuSettingConfig().get(string));
        }
        return false;
    }

    public static void setConfigBooleanValue(String str, boolean z) {
        ConfigDataBase configDataBase = sConfigDataBase;
        if (configDataBase != null) {
            configDataBase.getAppSettingMap().put(str, z ? "1" : "0");
        }
        CameraUnitUtils.setVendorTagConfigRus(str, z ? "1" : "0");
    }

    public static List<String> getMenuPanelOptionList() {
        ConfigDataBase configDataBase = sConfigDataBase;
        if (configDataBase != null) {
            return configDataBase.getMenuPanelList();
        }
        return new ArrayList();
    }

    public static boolean checkKeyInMenuList(String str) {
        if (str != null && !str.equals("")) {
            if (sConfigDataBase.getMenuPanelList() != null) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < sConfigDataBase.getMenuPanelList().size(); OplusGLSurfaceView_13++) {
                    if (CameraUITool.m20063a(str, sConfigDataBase.getMenuPanelList().get(OplusGLSurfaceView_13))) {
                        return true;
                    }
                }
            }
            if (sConfigDataBase.getMenuSettingList() != null) {
                for (int i2 = 0; i2 < sConfigDataBase.getMenuSettingList().size(); i2++) {
                    if (CameraUITool.m20063a(str, sConfigDataBase.getMenuSettingList().get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Size getSizeConfigValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (!TextUtils.isEmpty(configStringValue)) {
            try {
                return new Size(Integer.parseInt(configStringValue.split("x")[0]), Integer.parseInt(configStringValue.split("x")[1]));
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12967f(TAG, COUIBaseListPopupWindow_8.getMessage());
            }
        }
        return null;
    }

    public static Size getSizeConfigValue(String str, int OplusGLSurfaceView_13) {
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            return getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_FRONT);
        }
        return getSizeConfigValue(str);
    }

    public static int getConfigIntValue(String str, int OplusGLSurfaceView_13) {
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            return getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME_FRONT);
        }
        return getConfigIntValue(str);
    }

    public static List<Size> getConfigSizeListValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        String[] strArrSplit = configStringValue.split("x");
        int length = strArrSplit.length / 2;
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            int i2 = OplusGLSurfaceView_13 * 2;
            arrayList.add(new Size(Integer.parseInt(strArrSplit[i2]), Integer.parseInt(strArrSplit[i2 + 1])));
        }
        return arrayList;
    }

    public static List<String> getConfigStringListValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        return Arrays.asList(configStringValue.split(","));
    }

    public static boolean isSupportMicroscope() {
        return getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_SUPPORT) || getConfigBooleanValue(ConfigDataBase.KEY_LEGACY_MICROSCOPE_SUPPORT);
    }

    public static boolean isSupportMicroscopeFilter() {
        return getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_FILTER_SUPPORT);
    }

    public static boolean getConfigBooleanValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return false;
        }
        try {
            return Byte.parseByte(configStringValue) > 0;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f(TAG, "getConfigBooleanValue, key: " + str + ", value: " + configStringValue);
            COUIBaseListPopupWindow_8.printStackTrace();
            return true;
        }
    }

    public static Byte getConfigByteValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (!TextUtils.isEmpty(configStringValue)) {
            return Byte.valueOf(Byte.parseByte(configStringValue));
        }
        return (byte) 0;
    }

    public static int getConfigIntValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return -1;
        }
        return Integer.parseInt(configStringValue);
    }

    public static float getConfigFloatValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return 0.0f;
        }
        return Float.parseFloat(configStringValue);
    }

    public static float[] getConfigFloatArrayValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        String[] strArrSplit = configStringValue.split(",");
        float[] fArr = new float[strArrSplit.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fArr.length; OplusGLSurfaceView_13++) {
            fArr[OplusGLSurfaceView_13] = Float.parseFloat(strArrSplit[OplusGLSurfaceView_13]);
        }
        return fArr;
    }

    public static int[] getConfigIntArrayValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        String[] strArrSplit = configStringValue.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            iArr[OplusGLSurfaceView_13] = Integer.parseInt(strArrSplit[OplusGLSurfaceView_13]);
        }
        return iArr;
    }

    public static int getConfigColorValue(String str) {
        try {
            return Color.parseColor(getConfigStringValue(str));
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return -1;
        }
    }

    public static String getConfigStringValue(String str) {
        String vendorTagConfig = CameraUnitUtils.getVendorTagConfig(str);
        return (sConfigDataBase == null || !TextUtils.isEmpty(vendorTagConfig)) ? vendorTagConfig : sConfigDataBase.getAppSettingMap().get(str);
    }

    public static String[] getConfigStringArrayValue(String str) {
        String configStringValue = getConfigStringValue(str);
        if (TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        return configStringValue.split(",");
    }

    public static String getConfigFpsValue(String str) {
        String[] configStringArrayValue = getConfigStringArrayValue(str);
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[0];
    }

    public static String getConfigFpsVideoType(String str) {
        String[] configStringArrayValue = getConfigStringArrayValue(str);
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[1];
    }

    public static void release() {
        CameraLog.m12954a(TAG, "release");
    }

    public static boolean isApsSupportVendorTag(String str) {
        String vendorTagConfig = CameraUnitUtils.getVendorTagConfig(str);
        CameraLog.m12962c(TAG, "isApsSupportVendorTag, key: " + str + ", value: " + vendorTagConfig);
        return vendorTagConfig != null;
    }
}
