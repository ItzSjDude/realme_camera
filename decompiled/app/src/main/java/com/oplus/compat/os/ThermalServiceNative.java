package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class ThermalServiceNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.IThermalService";
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String TAG = "ThermalServiceNative";

    public static com.oplus.compat.os.TemperatureNative[] getCurrentTemperatures() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getCurrentTemperatures").build()).execute();
            int i_renamed = 0;
            if (responseExecute.isSuccessful()) {
                java.util.Map map = (java.util.Map) responseExecute.getBundle().getSerializable(RESULT);
                com.oplus.compat.os.TemperatureNative[] temperatureNativeArr = new com.oplus.compat.os.TemperatureNative[map.size()];
                for (java.util.Map.Entry entry : map.entrySet()) {
                    temperatureNativeArr[i_renamed] = new com.oplus.compat.os.TemperatureNative((java.lang.String) entry.getKey(), ((java.lang.Float) entry.getValue()).floatValue());
                    i_renamed++;
                }
                return temperatureNativeArr;
            }
            android.util.Log.e_renamed(TAG, "getPowerSaveState: " + responseExecute.getMessage());
            return new com.oplus.compat.os.TemperatureNative[0];
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }
}
