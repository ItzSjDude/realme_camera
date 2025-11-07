package com.oplus.compat.p187os;

import android.util.Log;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import java.util.Map;

/* loaded from: classes2.dex */
public class ThermalServiceNative {
    private static final String COMPONENT_NAME = "android.os.IThermalService";
    private static final String RESULT = "result";
    private static final String TAG = "ThermalServiceNative";

    public static TemperatureNative[] getCurrentTemperatures() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getCurrentTemperatures").build()).execute();
            int OplusGLSurfaceView_13 = 0;
            if (responseExecute.isSuccessful()) {
                Map map = (Map) responseExecute.getBundle().getSerializable(RESULT);
                TemperatureNative[] temperatureNativeArr = new TemperatureNative[map.size()];
                for (Map.Entry entry : map.entrySet()) {
                    temperatureNativeArr[OplusGLSurfaceView_13] = new TemperatureNative((String) entry.getKey(), ((Float) entry.getValue()).floatValue());
                    OplusGLSurfaceView_13++;
                }
                return temperatureNativeArr;
            }
            Log.COUIBaseListPopupWindow_8(TAG, "getPowerSaveState: " + responseExecute.getMessage());
            return new TemperatureNative[0];
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }
}
