package com.oplus.camera.aps.config;

/* loaded from: classes2.dex */
public class CameraConfig {
    private static final java.lang.String TAG = "CameraConfig";
    private static com.oplus.camera.aps.config.ConfigDataBase sConfigDataBase;
    private static boolean sbInit;

    public static synchronized void initialize(android.content.Context context) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "initialize, sbInit: " + sbInit);
        if (!sbInit) {
            com.oplus.camera.e_renamed.a_renamed("CameraConfig.initialize");
            sConfigDataBase = new com.oplus.camera.aps.config.ConfigDataBase();
            sConfigDataBase.parseDefaultProjectConfig();
            sConfigDataBase.parseProjectConfigFromConfigFile(context);
            sConfigDataBase.parseMenuPanel();
            sConfigDataBase.parseMenuSetting();
            sConfigDataBase.parseDefaultMenuSettingConfigMap();
            sConfigDataBase.parseOptionItemConfig();
            sbInit = true;
            com.oplus.camera.e_renamed.b_renamed("CameraConfig.initialize");
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "initialize X_renamed");
    }

    public static java.util.List<java.lang.String> getSupportedList(java.lang.String str, int i_renamed) {
        if (sConfigDataBase.getOptionItemConfigs() == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed) ? "_front_camera_supported" : "_back_camera_supported");
        java.lang.String string = sb.toString();
        for (com.oplus.camera.ui.menu.c_renamed cVar : sConfigDataBase.getOptionItemConfigs()) {
            if (cVar != null && (cVar.a_renamed().equals(str) || cVar.a_renamed().equals(string))) {
                return cVar.b_renamed();
            }
        }
        return null;
    }

    public static boolean getSupportSettingMenuKey(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || sConfigDataBase.getMenuSettingList() == null || !sConfigDataBase.getMenuSettingList().contains(str)) ? false : true;
    }

    public static java.lang.String getOptionKeyDefaultValue(java.lang.String str, int i_renamed) {
        try {
            if (sConfigDataBase.getDefaultMenuSettingConfig() == null) {
                return null;
            }
            java.lang.String str2 = str + "_default";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str2);
            sb.append(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed) ? "_front_camera" : "_back_camera");
            java.lang.String string = sb.toString();
            if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(str2)) {
                return sConfigDataBase.getDefaultMenuSettingConfig().get(str2);
            }
            if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(string)) {
                return sConfigDataBase.getDefaultMenuSettingConfig().get(string);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static boolean getConfigBooleanValue(java.lang.String str, int i_renamed) {
        if (sConfigDataBase.getDefaultMenuSettingConfig() == null) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed) ? "_front_camera_supported" : "_back_camera_supported");
        java.lang.String string = sb.toString();
        if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(str)) {
            return java.lang.Boolean.parseBoolean(sConfigDataBase.getDefaultMenuSettingConfig().get(str));
        }
        if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(string)) {
            return java.lang.Boolean.parseBoolean(sConfigDataBase.getDefaultMenuSettingConfig().get(string));
        }
        return false;
    }

    public static void setConfigBooleanValue(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.aps.config.ConfigDataBase configDataBase = sConfigDataBase;
        if (configDataBase != null) {
            configDataBase.getAppSettingMap().put(str, z_renamed ? "1" : "0");
        }
        com.oplus.ocs.camera.appinterface.adapter.CameraUnitUtils.setVendorTagConfigRus(str, z_renamed ? "1" : "0");
    }

    public static java.util.List<java.lang.String> getMenuPanelOptionList() {
        com.oplus.camera.aps.config.ConfigDataBase configDataBase = sConfigDataBase;
        if (configDataBase != null) {
            return configDataBase.getMenuPanelList();
        }
        return new java.util.ArrayList();
    }

    public static boolean checkKeyInMenuList(java.lang.String str) {
        if (str != null && !str.equals("")) {
            if (sConfigDataBase.getMenuPanelList() != null) {
                for (int i_renamed = 0; i_renamed < sConfigDataBase.getMenuPanelList().size(); i_renamed++) {
                    if (com.oplus.camera.ui.e_renamed.a_renamed(str, sConfigDataBase.getMenuPanelList().get(i_renamed))) {
                        return true;
                    }
                }
            }
            if (sConfigDataBase.getMenuSettingList() != null) {
                for (int i2 = 0; i2 < sConfigDataBase.getMenuSettingList().size(); i2++) {
                    if (com.oplus.camera.ui.e_renamed.a_renamed(str, sConfigDataBase.getMenuSettingList().get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static android.util.Size getSizeConfigValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (!android.text.TextUtils.isEmpty(configStringValue)) {
            try {
                return new android.util.Size(java.lang.Integer.parseInt(configStringValue.split("x_renamed")[0]), java.lang.Integer.parseInt(configStringValue.split("x_renamed")[1]));
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.f_renamed(TAG, e_renamed.getMessage());
            }
        }
        return null;
    }

    public static android.util.Size getSizeConfigValue(java.lang.String str, int i_renamed) {
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed)) {
            return getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE_FRONT);
        }
        return getSizeConfigValue(str);
    }

    public static int getConfigIntValue(java.lang.String str, int i_renamed) {
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed)) {
            return getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME_FRONT);
        }
        return getConfigIntValue(str);
    }

    public static java.util.List<android.util.Size> getConfigSizeListValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        java.lang.String[] strArrSplit = configStringValue.split("x_renamed");
        int length = strArrSplit.length / 2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            int i2 = i_renamed * 2;
            arrayList.add(new android.util.Size(java.lang.Integer.parseInt(strArrSplit[i2]), java.lang.Integer.parseInt(strArrSplit[i2 + 1])));
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> getConfigStringListValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        return java.util.Arrays.asList(configStringValue.split(","));
    }

    public static boolean isSupportMicroscope() {
        return getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICROSCOPE_SUPPORT) || getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LEGACY_MICROSCOPE_SUPPORT);
    }

    public static boolean isSupportMicroscopeFilter() {
        return getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICROSCOPE_FILTER_SUPPORT);
    }

    public static boolean getConfigBooleanValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return false;
        }
        try {
            return java.lang.Byte.parseByte(configStringValue) > 0;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "getConfigBooleanValue, key: " + str + ", value: " + configStringValue);
            e_renamed.printStackTrace();
            return true;
        }
    }

    public static java.lang.Byte getConfigByteValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (!android.text.TextUtils.isEmpty(configStringValue)) {
            return java.lang.Byte.valueOf(java.lang.Byte.parseByte(configStringValue));
        }
        return (byte) 0;
    }

    public static int getConfigIntValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return -1;
        }
        return java.lang.Integer.parseInt(configStringValue);
    }

    public static float getConfigFloatValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return 0.0f;
        }
        return java.lang.Float.parseFloat(configStringValue);
    }

    public static float[] getConfigFloatArrayValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        java.lang.String[] strArrSplit = configStringValue.split(",");
        float[] fArr = new float[strArrSplit.length];
        for (int i_renamed = 0; i_renamed < fArr.length; i_renamed++) {
            fArr[i_renamed] = java.lang.Float.parseFloat(strArrSplit[i_renamed]);
        }
        return fArr;
    }

    public static int[] getConfigIntArrayValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        java.lang.String[] strArrSplit = configStringValue.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            iArr[i_renamed] = java.lang.Integer.parseInt(strArrSplit[i_renamed]);
        }
        return iArr;
    }

    public static int getConfigColorValue(java.lang.String str) {
        try {
            return android.graphics.Color.parseColor(getConfigStringValue(str));
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return -1;
        }
    }

    public static java.lang.String getConfigStringValue(java.lang.String str) {
        java.lang.String vendorTagConfig = com.oplus.ocs.camera.appinterface.adapter.CameraUnitUtils.getVendorTagConfig(str);
        return (sConfigDataBase == null || !android.text.TextUtils.isEmpty(vendorTagConfig)) ? vendorTagConfig : sConfigDataBase.getAppSettingMap().get(str);
    }

    public static java.lang.String[] getConfigStringArrayValue(java.lang.String str) {
        java.lang.String configStringValue = getConfigStringValue(str);
        if (android.text.TextUtils.isEmpty(configStringValue)) {
            return null;
        }
        return configStringValue.split(",");
    }

    public static java.lang.String getConfigFpsValue(java.lang.String str) {
        java.lang.String[] configStringArrayValue = getConfigStringArrayValue(str);
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[0];
    }

    public static java.lang.String getConfigFpsVideoType(java.lang.String str) {
        java.lang.String[] configStringArrayValue = getConfigStringArrayValue(str);
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[1];
    }

    public static void release() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "release");
    }

    public static boolean isApsSupportVendorTag(java.lang.String str) {
        java.lang.String vendorTagConfig = com.oplus.ocs.camera.appinterface.adapter.CameraUnitUtils.getVendorTagConfig(str);
        com.oplus.camera.e_renamed.c_renamed(TAG, "isApsSupportVendorTag, key: " + str + ", value: " + vendorTagConfig);
        return vendorTagConfig != null;
    }
}
