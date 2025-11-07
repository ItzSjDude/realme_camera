package com.oplus.compat.p187os;

import android.media.AudioAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Call;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.os.OplusVibratorConstant;

/* loaded from: classes2.dex */
public class VibratorNative {
    private static final String COMPONENT_NAME = "android.os.Vibrator";
    private static final String TAG = "VibratorNative";
    public static int WEAK_AMPLITUDE = ((Integer) getWeakAmplitudeCompat()).intValue();
    public static int MIDDLE_AMPLITUDE = ((Integer) getMiddleAmplitudeCompat()).intValue();
    public static int STRONG_AMPLITUDE = ((Integer) getStrongAmplitudeCompat()).intValue();
    public static long RAPID_WEAK_ONESHOT_TIME = ((Long) getRapidWeakOneshotTimeCompat()).longValue();
    public static long RAPID_MIDDLE_ONESHOT_TIME = ((Long) getRapidMiddleOneshotTimeCompat()).longValue();
    public static long LONG_MIDDLE_ONESHOT_TIME = ((Long) getLongMiddleOneshotTimeCompat()).longValue();
    public static long LONG_STRONG_ONESHOT_TIME = ((Long) getLongStrongOneshotTimeCompat()).longValue();
    public static long[] RAPID_MIDDLE_WAVEFORM_TIME = (long[]) getRapidMiddleWaveformTimeCompat();
    public static int[] RAPID_MIDDLE_WAVEFORM_AMPLITUDE = (int[]) getRapidMiddleWaveformAmplitudeCompat();
    public static long[] RAPID_STRONG_WAVEFORM_TIME = (long[]) getRapidStrongWaveformTimeCompat();
    public static int[] RAPID_STRONG_WAVEFORM_AMPLITUDE = (int[]) getRapidStrongWaveformAmplitudeCompat();

    private static void linerMotorVibrateQCompat(Vibrator vibrator, VibrationEffect vibrationEffect) {
    }

    private static void linerMotorVibrateQCompat(Vibrator vibrator, VibrationEffect vibrationEffect, AudioAttributes audioAttributes) {
    }

    private static Object getWeakAmplitudeCompat() {
        return VersionUtils.m24886b() ? 100 : null;
    }

    private static Object getMiddleAmplitudeCompat() {
        return VersionUtils.m24886b() ? 175 : null;
    }

    private static Object getStrongAmplitudeCompat() {
        return VersionUtils.m24886b() ? 250 : null;
    }

    private static Object getRapidWeakOneshotTimeCompat() {
        return VersionUtils.m24886b() ? 25L : null;
    }

    private static Object getRapidMiddleOneshotTimeCompat() {
        return VersionUtils.m24886b() ? 50L : null;
    }

    private static Object getLongMiddleOneshotTimeCompat() {
        return VersionUtils.m24886b() ? 150L : null;
    }

    private static Object getLongStrongOneshotTimeCompat() {
        return VersionUtils.m24886b() ? 400L : null;
    }

    private static Object getRapidMiddleWaveformTimeCompat() {
        if (VersionUtils.m24886b()) {
            return OplusVibratorConstant.RAPID_MIDDLE_WAVEFORM_TIME;
        }
        return null;
    }

    private static Object getRapidMiddleWaveformAmplitudeCompat() {
        if (VersionUtils.m24886b()) {
            return OplusVibratorConstant.RAPID_MIDDLE_WAVEFORM_AMPLITUDE;
        }
        return null;
    }

    private static Object getRapidStrongWaveformTimeCompat() {
        if (VersionUtils.m24886b()) {
            return OplusVibratorConstant.RAPID_STRONG_WAVEFORM_TIME;
        }
        return null;
    }

    private static Object getRapidStrongWaveformAmplitudeCompat() {
        if (VersionUtils.m24886b()) {
            return OplusVibratorConstant.RAPID_STRONG_WAVEFORM_AMPLITUDE;
        }
        return null;
    }

    private VibratorNative() {
    }

    public static void linerMotorVibrate(Vibrator vibrator, VibrationEffect vibrationEffect) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            throw new UnSupportedApiVersionException("not supported in R because of not exist");
        }
        if (VersionUtils.m24889e()) {
            linerMotorVibrateQCompat(vibrator, vibrationEffect);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    private static void linerMotorVibrate(Vibrator vibrator, VibrationEffect vibrationEffect, AudioAttributes audioAttributes) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            throw new UnSupportedApiVersionException("not supported in R because of not exist");
        }
        if (VersionUtils.m24889e()) {
            linerMotorVibrateQCompat(vibrator, vibrationEffect, audioAttributes);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static void addVibratorStateListener(final OnVibratorStateChangedListenerNative onVibratorStateChangedListenerNative) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Request requestBuild = new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("addVibratorStateListener").build();
            Epona.newCall(requestBuild).asyncExecute(new Call.Callback() { // from class: com.oplus.compat.os.VibratorNative.1
                @Override // com.oplus.epona.Call.Callback
                public void onReceive(Response response) {
                    if (response.isSuccessful()) {
                        onVibratorStateChangedListenerNative.onVibratorStateChanged(response.getBundle().getBoolean("isVibrating"));
                    }
                }
            });
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static void removeVibratorStateListener() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("removeVibratorStateListener").build()).asyncExecute(null);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static boolean isVibrating() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("isVibrating").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean("isVibrating");
            }
            return false;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }
}
