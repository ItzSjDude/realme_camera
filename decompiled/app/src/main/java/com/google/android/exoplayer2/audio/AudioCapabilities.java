package com.google.android.exoplayer2.audio;

@android.annotation.TargetApi(21)
/* loaded from: classes.dex */
public final class AudioCapabilities {
    public static final com.google.android.exoplayer2.audio.AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new com.google.android.exoplayer2.audio.AudioCapabilities(new int[]{2}, 8);
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private final int maxChannelCount;
    private final int[] supportedEncodings;

    public static com.google.android.exoplayer2.audio.AudioCapabilities getCapabilities(android.content.Context context) {
        return getCapabilities(context.registerReceiver(null, new android.content.IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    static com.google.android.exoplayer2.audio.AudioCapabilities getCapabilities(android.content.Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return DEFAULT_AUDIO_CAPABILITIES;
        }
        return new com.google.android.exoplayer2.audio.AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    public AudioCapabilities(int[] iArr, int i_renamed) {
        if (iArr != null) {
            this.supportedEncodings = java.util.Arrays.copyOf(iArr, iArr.length);
            java.util.Arrays.sort(this.supportedEncodings);
        } else {
            this.supportedEncodings = new int[0];
        }
        this.maxChannelCount = i_renamed;
    }

    public boolean supportsEncoding(int i_renamed) {
        return java.util.Arrays.binarySearch(this.supportedEncodings, i_renamed) >= 0;
    }

    public int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.exoplayer2.audio.AudioCapabilities)) {
            return false;
        }
        com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities = (com.google.android.exoplayer2.audio.AudioCapabilities) obj;
        return java.util.Arrays.equals(this.supportedEncodings, audioCapabilities.supportedEncodings) && this.maxChannelCount == audioCapabilities.maxChannelCount;
    }

    public int hashCode() {
        return this.maxChannelCount + (java.util.Arrays.hashCode(this.supportedEncodings) * 31);
    }

    public java.lang.String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + java.util.Arrays.toString(this.supportedEncodings) + "]";
    }
}
