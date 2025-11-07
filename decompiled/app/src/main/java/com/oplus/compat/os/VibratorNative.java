package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class VibratorNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.Vibrator";
    private static final java.lang.String TAG = "VibratorNative";
    public static int WEAK_AMPLITUDE = ((java.lang.Integer) getWeakAmplitudeCompat()).intValue();
    public static int MIDDLE_AMPLITUDE = ((java.lang.Integer) getMiddleAmplitudeCompat()).intValue();
    public static int STRONG_AMPLITUDE = ((java.lang.Integer) getStrongAmplitudeCompat()).intValue();
    public static long RAPID_WEAK_ONESHOT_TIME = ((java.lang.Long) getRapidWeakOneshotTimeCompat()).longValue();
    public static long RAPID_MIDDLE_ONESHOT_TIME = ((java.lang.Long) getRapidMiddleOneshotTimeCompat()).longValue();
    public static long LONG_MIDDLE_ONESHOT_TIME = ((java.lang.Long) getLongMiddleOneshotTimeCompat()).longValue();
    public static long LONG_STRONG_ONESHOT_TIME = ((java.lang.Long) getLongStrongOneshotTimeCompat()).longValue();
    public static long[] RAPID_MIDDLE_WAVEFORM_TIME = (long[]) getRapidMiddleWaveformTimeCompat();
    public static int[] RAPID_MIDDLE_WAVEFORM_AMPLITUDE = (int[]) getRapidMiddleWaveformAmplitudeCompat();
    public static long[] RAPID_STRONG_WAVEFORM_TIME = (long[]) getRapidStrongWaveformTimeCompat();
    public static int[] RAPID_STRONG_WAVEFORM_AMPLITUDE = (int[]) getRapidStrongWaveformAmplitudeCompat();

    private static void linerMotorVibrateQCompat(android.os.Vibrator vibrator, android.os.VibrationEffect vibrationEffect) {
    }

    private static void linerMotorVibrateQCompat(android.os.Vibrator vibrator, android.os.VibrationEffect vibrationEffect, android.media.AudioAttributes audioAttributes) {
    }

    private static java.lang.Object getWeakAmplitudeCompat() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? 100 : null;
    }

    private static java.lang.Object getMiddleAmplitudeCompat() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? 175 : null;
    }

    private static java.lang.Object getStrongAmplitudeCompat() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? 250 : null;
    }

    private static java.lang.Object getRapidWeakOneshotTimeCompat() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? 25L : null;
    }

    private static java.lang.Object getRapidMiddleOneshotTimeCompat() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? 50L : null;
    }

    private static java.lang.Object getLongMiddleOneshotTimeCompat() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? 150L : null;
    }

    private static java.lang.Object getLongStrongOneshotTimeCompat() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? 400L : null;
    }

    private static java.lang.Object getRapidMiddleWaveformTimeCompat() {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.os.OplusVibratorConstant.RAPID_MIDDLE_WAVEFORM_TIME;
        }
        return null;
    }

    private static java.lang.Object getRapidMiddleWaveformAmplitudeCompat() {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.os.OplusVibratorConstant.RAPID_MIDDLE_WAVEFORM_AMPLITUDE;
        }
        return null;
    }

    private static java.lang.Object getRapidStrongWaveformTimeCompat() {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.os.OplusVibratorConstant.RAPID_STRONG_WAVEFORM_TIME;
        }
        return null;
    }

    private static java.lang.Object getRapidStrongWaveformAmplitudeCompat() {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.os.OplusVibratorConstant.RAPID_STRONG_WAVEFORM_AMPLITUDE;
        }
        return null;
    }

    private VibratorNative() {
    }

    public static void linerMotorVibrate(android.os.Vibrator vibrator, android.os.VibrationEffect vibrationEffect) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported in_renamed R_renamed because of_renamed not exist");
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            linerMotorVibrateQCompat(vibrator, vibrationEffect);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    private static void linerMotorVibrate(android.os.Vibrator vibrator, android.os.VibrationEffect vibrationEffect, android.media.AudioAttributes audioAttributes) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported in_renamed R_renamed because of_renamed not exist");
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            linerMotorVibrateQCompat(vibrator, vibrationEffect, audioAttributes);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static void addVibratorStateListener(final com.oplus.compat.os.OnVibratorStateChangedListenerNative onVibratorStateChangedListenerNative) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Request requestBuild = new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("addVibratorStateListener").build();
            com.oplus.epona.Epona.newCall(requestBuild).asyncExecute(new com.oplus.epona.Call.Callback() { // from class: com.oplus.compat.os.VibratorNative.1
                @Override // com.oplus.epona.Call.Callback
                public void onReceive(com.oplus.epona.Response response) {
                    if (response.isSuccessful()) {
                        onVibratorStateChangedListenerNative.onVibratorStateChanged(response.getBundle().getBoolean("isVibrating"));
                    }
                }
            });
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    public static void removeVibratorStateListener() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("removeVibratorStateListener").build()).asyncExecute(null);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    public static boolean isVibrating() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("isVibrating").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean("isVibrating");
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }
}
