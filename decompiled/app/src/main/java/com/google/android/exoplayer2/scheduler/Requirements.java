package com.google.android.exoplayer2.scheduler;

/* loaded from: classes.dex */
public final class Requirements {
    private static final int DEVICE_CHARGING = 16;
    private static final int DEVICE_IDLE = 8;
    public static final int NETWORK_TYPE_ANY = 1;
    private static final int NETWORK_TYPE_MASK = 7;
    public static final int NETWORK_TYPE_METERED = 4;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_NOT_ROAMING = 3;
    private static final java.lang.String[] NETWORK_TYPE_STRINGS = null;
    public static final int NETWORK_TYPE_UNMETERED = 2;
    private static final java.lang.String TAG = "Requirements";
    private final int requirements;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    private static void logd(java.lang.String str) {
    }

    public Requirements(int i_renamed, boolean z_renamed, boolean z2) {
        this(i_renamed | (z_renamed ? 16 : 0) | (z2 ? 8 : 0));
    }

    public Requirements(int i_renamed) {
        this.requirements = i_renamed;
    }

    public int getRequiredNetworkType() {
        return this.requirements & 7;
    }

    public boolean isChargingRequired() {
        return (this.requirements & 16) != 0;
    }

    public boolean isIdleRequired() {
        return (this.requirements & 8) != 0;
    }

    public boolean checkRequirements(android.content.Context context) {
        return checkNetworkRequirements(context) && checkChargingRequirement(context) && checkIdleRequirement(context);
    }

    public int getRequirementsData() {
        return this.requirements;
    }

    private boolean checkNetworkRequirements(android.content.Context context) {
        int requiredNetworkType = getRequiredNetworkType();
        if (requiredNetworkType == 0) {
            return true;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            logd("No network info or no connection.");
            return false;
        }
        if (!checkInternetConnectivity(connectivityManager)) {
            return false;
        }
        if (requiredNetworkType == 1) {
            return true;
        }
        if (requiredNetworkType == 3) {
            boolean zIsRoaming = activeNetworkInfo.isRoaming();
            logd("Roaming: " + zIsRoaming);
            return !zIsRoaming;
        }
        boolean zIsActiveNetworkMetered = isActiveNetworkMetered(connectivityManager, activeNetworkInfo);
        logd("Metered network: " + zIsActiveNetworkMetered);
        if (requiredNetworkType == 2) {
            return !zIsActiveNetworkMetered;
        }
        if (requiredNetworkType == 4) {
            return zIsActiveNetworkMetered;
        }
        throw new java.lang.IllegalStateException();
    }

    private boolean checkChargingRequirement(android.content.Context context) {
        if (!isChargingRequired()) {
            return true;
        }
        android.content.Intent intentRegisterReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean checkIdleRequirement(android.content.Context context) {
        if (!isIdleRequired()) {
            return true;
        }
        android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 20) {
            if (!powerManager.isInteractive()) {
                return true;
            }
        } else if (!powerManager.isScreenOn()) {
            return true;
        }
        return false;
    }

    private static boolean checkInternetConnectivity(android.net.ConnectivityManager connectivityManager) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            return true;
        }
        android.net.Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            logd("No active network.");
            return false;
        }
        android.net.NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        boolean z_renamed = networkCapabilities == null || !networkCapabilities.hasCapability(16);
        logd("Network capability validated: " + z_renamed);
        return !z_renamed;
    }

    private static boolean isActiveNetworkMetered(android.net.ConnectivityManager connectivityManager, android.net.NetworkInfo networkInfo) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }

    public java.lang.String toString() {
        return super.toString();
    }
}
