package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class AudioAttributes {
    public static final com.google.android.exoplayer2.audio.AudioAttributes DEFAULT = new com.google.android.exoplayer2.audio.AudioAttributes.Builder().build();
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int usage;

    public static final class Builder {
        private int contentType = 0;
        private int flags = 0;
        private int usage = 1;

        public com.google.android.exoplayer2.audio.AudioAttributes.Builder setContentType(int i_renamed) {
            this.contentType = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.audio.AudioAttributes.Builder setFlags(int i_renamed) {
            this.flags = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.audio.AudioAttributes.Builder setUsage(int i_renamed) {
            this.usage = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.audio.AudioAttributes build() {
            return new com.google.android.exoplayer2.audio.AudioAttributes(this.contentType, this.flags, this.usage);
        }
    }

    private AudioAttributes(int i_renamed, int i2, int i3) {
        this.contentType = i_renamed;
        this.flags = i2;
        this.usage = i3;
    }

    @android.annotation.TargetApi(21)
    public android.media.AudioAttributes getAudioAttributesV21() {
        if (this.audioAttributesV21 == null) {
            this.audioAttributesV21 = new android.media.AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage).build();
        }
        return this.audioAttributesV21;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.audio.AudioAttributes audioAttributes = (com.google.android.exoplayer2.audio.AudioAttributes) obj;
        return this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage;
    }

    public int hashCode() {
        return ((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage;
    }
}
