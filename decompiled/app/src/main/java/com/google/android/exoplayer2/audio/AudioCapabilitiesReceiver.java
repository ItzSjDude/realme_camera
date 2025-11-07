package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class AudioCapabilitiesReceiver {
    com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities;
    private final android.content.Context context;
    private final android.os.Handler handler;
    private final com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.Listener listener;
    private final android.content.BroadcastReceiver receiver;

    public interface Listener {
        void onAudioCapabilitiesChanged(com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities);
    }

    public AudioCapabilitiesReceiver(android.content.Context context, com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.Listener listener) {
        this(context, null, listener);
    }

    public AudioCapabilitiesReceiver(android.content.Context context, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.Listener listener) {
        this.context = (android.content.Context) com.google.android.exoplayer2.util.Assertions.checkNotNull(context);
        this.handler = handler;
        this.listener = (com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.Listener) com.google.android.exoplayer2.util.Assertions.checkNotNull(listener);
        this.receiver = com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? new com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.HdmiAudioPlugBroadcastReceiver() : null;
    }

    public com.google.android.exoplayer2.audio.AudioCapabilities register() {
        android.content.Intent intentRegisterReceiver = null;
        if (this.receiver != null) {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter("android.media.action.HDMI_AUDIO_PLUG");
            android.os.Handler handler = this.handler;
            if (handler != null) {
                intentRegisterReceiver = this.context.registerReceiver(this.receiver, intentFilter, null, handler);
            } else {
                intentRegisterReceiver = this.context.registerReceiver(this.receiver, intentFilter);
            }
        }
        this.audioCapabilities = com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(intentRegisterReceiver);
        return this.audioCapabilities;
    }

    public void unregister() {
        android.content.BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
    }

    private final class HdmiAudioPlugBroadcastReceiver extends android.content.BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            com.google.android.exoplayer2.audio.AudioCapabilities capabilities = com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(intent);
            if (capabilities.equals(com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.this.audioCapabilities)) {
                return;
            }
            com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver audioCapabilitiesReceiver = com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.audioCapabilities = capabilities;
            audioCapabilitiesReceiver.listener.onAudioCapabilitiesChanged(capabilities);
        }
    }
}
