package com.google.android.exoplayer2.scheduler;

/* loaded from: classes.dex */
public final class RequirementsWatcher {
    private static final java.lang.String TAG = "RequirementsWatcher";
    private final android.content.Context context;
    private final com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener listener;
    private com.google.android.exoplayer2.scheduler.RequirementsWatcher.CapabilityValidatedCallback networkCallback;
    private com.google.android.exoplayer2.scheduler.RequirementsWatcher.DeviceStatusChangeReceiver receiver;
    private final com.google.android.exoplayer2.scheduler.Requirements requirements;
    private boolean requirementsWereMet;

    public interface Listener {
        void requirementsMet(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher);

        void requirementsNotMet(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logd(java.lang.String str) {
    }

    public RequirementsWatcher(android.content.Context context, com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener listener, com.google.android.exoplayer2.scheduler.Requirements requirements) {
        this.requirements = requirements;
        this.listener = listener;
        this.context = context.getApplicationContext();
        logd(this + " created");
    }

    public void start() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(android.os.Looper.myLooper());
        this.requirementsWereMet = this.requirements.checkRequirements(this.context);
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        if (this.requirements.getRequiredNetworkType() != 0) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
                registerNetworkCallbackV23();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.requirements.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.requirements.isIdleRequired()) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        this.receiver = new com.google.android.exoplayer2.scheduler.RequirementsWatcher.DeviceStatusChangeReceiver();
        this.context.registerReceiver(this.receiver, intentFilter, null, new android.os.Handler());
        logd(this + " started");
    }

    public void stop() {
        this.context.unregisterReceiver(this.receiver);
        this.receiver = null;
        if (this.networkCallback != null) {
            unregisterNetworkCallback();
        }
        logd(this + " stopped");
    }

    public com.google.android.exoplayer2.scheduler.Requirements getRequirements() {
        return this.requirements;
    }

    public java.lang.String toString() {
        return super.toString();
    }

    @android.annotation.TargetApi(23)
    private void registerNetworkCallbackV23() {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) this.context.getSystemService("connectivity");
        android.net.NetworkRequest networkRequestBuild = new android.net.NetworkRequest.Builder().addCapability(16).build();
        this.networkCallback = new com.google.android.exoplayer2.scheduler.RequirementsWatcher.CapabilityValidatedCallback();
        connectivityManager.registerNetworkCallback(networkRequestBuild, this.networkCallback);
    }

    private void unregisterNetworkCallback() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            ((android.net.ConnectivityManager) this.context.getSystemService("connectivity")).unregisterNetworkCallback(this.networkCallback);
            this.networkCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRequirements() {
        boolean zCheckRequirements = this.requirements.checkRequirements(this.context);
        if (zCheckRequirements == this.requirementsWereMet) {
            logd("requirementsAreMet is_renamed still " + zCheckRequirements);
            return;
        }
        this.requirementsWereMet = zCheckRequirements;
        if (zCheckRequirements) {
            logd("start job");
            this.listener.requirementsMet(this);
        } else {
            logd("stop job");
            this.listener.requirementsNotMet(this);
        }
    }

    private class DeviceStatusChangeReceiver extends android.content.BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.logd(com.google.android.exoplayer2.scheduler.RequirementsWatcher.this + " received " + intent.getAction());
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.checkRequirements();
        }
    }

    private final class CapabilityValidatedCallback extends android.net.ConnectivityManager.NetworkCallback {
        private CapabilityValidatedCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.logd(com.google.android.exoplayer2.scheduler.RequirementsWatcher.this + " NetworkCallback.onAvailable");
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.checkRequirements();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
            super.onLost(network);
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.logd(com.google.android.exoplayer2.scheduler.RequirementsWatcher.this + " NetworkCallback.onLost");
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.checkRequirements();
        }
    }
}
