package com.google.android.exoplayer2.mediacodec;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public final class MediaCodecInfo {
    public static final int MAX_SUPPORTED_INSTANCES_UNKNOWN = -1;
    public static final java.lang.String TAG = "MediaCodecInfo";
    public final boolean adaptive;
    public final android.media.MediaCodecInfo.CodecCapabilities capabilities;
    private final boolean isVideo;
    public final java.lang.String mimeType;
    public final java.lang.String name;
    public final boolean passthrough;
    public final boolean secure;
    public final boolean tunneling;

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo newPassthroughInstance(java.lang.String str) {
        return new com.google.android.exoplayer2.mediacodec.MediaCodecInfo(str, null, null, true, false, false);
    }

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo newInstance(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new com.google.android.exoplayer2.mediacodec.MediaCodecInfo(str, str2, codecCapabilities, false, false, false);
    }

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo newInstance(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z_renamed, boolean z2) {
        return new com.google.android.exoplayer2.mediacodec.MediaCodecInfo(str, str2, codecCapabilities, false, z_renamed, z2);
    }

    private MediaCodecInfo(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z_renamed, boolean z2, boolean z3) {
        this.name = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.capabilities = codecCapabilities;
        this.passthrough = z_renamed;
        boolean z4 = true;
        this.adaptive = (z2 || codecCapabilities == null || !isAdaptive(codecCapabilities)) ? false : true;
        this.tunneling = codecCapabilities != null && isTunneling(codecCapabilities);
        if (!z3 && (codecCapabilities == null || !isSecure(codecCapabilities))) {
            z4 = false;
        }
        this.secure = z4;
        this.isVideo = com.google.android.exoplayer2.util.MimeTypes.isVideo(str2);
    }

    public java.lang.String toString() {
        return this.name;
    }

    public android.media.MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new android.media.MediaCodecInfo.CodecProfileLevel[0] : this.capabilities.profileLevels;
    }

    public int getMaxSupportedInstances() {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 || (codecCapabilities = this.capabilities) == null) {
            return -1;
        }
        return getMaxSupportedInstancesV23(codecCapabilities);
    }

    public boolean isFormatSupported(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        if (!isCodecSupported(format.codecs)) {
            return false;
        }
        if (this.isVideo) {
            if (format.width <= 0 || format.height <= 0) {
                return true;
            }
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                return isVideoSizeAndRateSupportedV21(format.width, format.height, format.frameRate);
            }
            boolean z_renamed = format.width * format.height <= com.google.android.exoplayer2.mediacodec.MediaCodecUtil.maxH264DecodableFrameSize();
            if (!z_renamed) {
                logNoSupport("legacyFrameSize, " + format.width + "x_renamed" + format.height);
            }
            return z_renamed;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            if (format.sampleRate != -1 && !isAudioSampleRateSupportedV21(format.sampleRate)) {
                return false;
            }
            if (format.channelCount != -1 && !isAudioChannelCountSupportedV21(format.channelCount)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCodecSupported(java.lang.String str) {
        java.lang.String mediaMimeType;
        if (str == null || this.mimeType == null || (mediaMimeType = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(str)) == null) {
            return true;
        }
        if (!this.mimeType.equals(mediaMimeType)) {
            logNoSupport("codec.mime " + str + ", " + mediaMimeType);
            return false;
        }
        android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(str);
        if (codecProfileAndLevel == null) {
            return true;
        }
        int iIntValue = ((java.lang.Integer) codecProfileAndLevel.first).intValue();
        int iIntValue2 = ((java.lang.Integer) codecProfileAndLevel.second).intValue();
        if (!this.isVideo && iIntValue != 42) {
            return true;
        }
        for (android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2) {
                return true;
            }
        }
        logNoSupport("codec.profileLevel, " + str + ", " + mediaMimeType);
        return false;
    }

    public boolean isSeamlessAdaptationSupported(com.google.android.exoplayer2.Format format) {
        if (this.isVideo) {
            return this.adaptive;
        }
        android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format.codecs);
        return codecProfileAndLevel != null && ((java.lang.Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    public boolean isSeamlessAdaptationSupported(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2, boolean z_renamed) {
        if (this.isVideo) {
            return format.sampleMimeType.equals(format2.sampleMimeType) && format.rotationDegrees == format2.rotationDegrees && (this.adaptive || (format.width == format2.width && format.height == format2.height)) && ((!z_renamed && format2.colorInfo == null) || com.google.android.exoplayer2.util.Util.areEqual(format.colorInfo, format2.colorInfo));
        }
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC.equals(this.mimeType) && format.sampleMimeType.equals(format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate) {
            android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format.codecs);
            android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel2 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format2.codecs);
            if (codecProfileAndLevel != null && codecProfileAndLevel2 != null) {
                return ((java.lang.Integer) codecProfileAndLevel.first).intValue() == 42 && ((java.lang.Integer) codecProfileAndLevel2.first).intValue() == 42;
            }
        }
        return false;
    }

    @android.annotation.TargetApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i_renamed, int i2, double d_renamed) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sizeAndRate.caps");
            return false;
        }
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("sizeAndRate.vCaps");
            return false;
        }
        if (areSizeAndRateSupportedV21(videoCapabilities, i_renamed, i2, d_renamed)) {
            return true;
        }
        if (i_renamed >= i2 || !areSizeAndRateSupportedV21(videoCapabilities, i2, i_renamed, d_renamed)) {
            logNoSupport("sizeAndRate.support, " + i_renamed + "x_renamed" + i2 + "x_renamed" + d_renamed);
            return false;
        }
        logAssumedSupport("sizeAndRate.rotated, " + i_renamed + "x_renamed" + i2 + "x_renamed" + d_renamed);
        return true;
    }

    @android.annotation.TargetApi(21)
    public android.graphics.Point alignVideoSizeV21(int i_renamed, int i2) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("align.caps");
            return null;
        }
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new android.graphics.Point(com.google.android.exoplayer2.util.Util.ceilDivide(i_renamed, widthAlignment) * widthAlignment, com.google.android.exoplayer2.util.Util.ceilDivide(i2, heightAlignment) * heightAlignment);
    }

    @android.annotation.TargetApi(21)
    public boolean isAudioSampleRateSupportedV21(int i_renamed) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sampleRate.caps");
            return false;
        }
        android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i_renamed)) {
            return true;
        }
        logNoSupport("sampleRate.support, " + i_renamed);
        return false;
    }

    @android.annotation.TargetApi(21)
    public boolean isAudioChannelCountSupportedV21(int i_renamed) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("channelCount.caps");
            return false;
        }
        android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("channelCount.aCaps");
            return false;
        }
        if (adjustMaxInputChannelCount(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) >= i_renamed) {
            return true;
        }
        logNoSupport("channelCount.support, " + i_renamed);
        return false;
    }

    private void logNoSupport(java.lang.String str) {
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "NoSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO + "]");
    }

    private void logAssumedSupport(java.lang.String str) {
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "AssumedSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO + "]");
    }

    private static int adjustMaxInputChannelCount(java.lang.String str, java.lang.String str2, int i_renamed) {
        int i2;
        if (i_renamed > 1 || ((com.google.android.exoplayer2.util.Util.SDK_INT >= 26 && i_renamed > 0) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_AMR_NB.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_AMR_WB.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_VORBIS.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_OPUS.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_FLAC.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_ALAW.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_MLAW.equals(str2) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i_renamed;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC3.equals(str2)) {
            i2 = 6;
        } else {
            i2 = com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i_renamed + " to " + i2 + "]");
        return i2;
    }

    private static boolean isAdaptive(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities);
    }

    @android.annotation.TargetApi(19)
    private static boolean isAdaptiveV19(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean isTunneling(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 21 && isTunnelingV21(codecCapabilities);
    }

    @android.annotation.TargetApi(21)
    private static boolean isTunnelingV21(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean isSecure(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 21 && isSecureV21(codecCapabilities);
    }

    @android.annotation.TargetApi(21)
    private static boolean isSecureV21(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @android.annotation.TargetApi(21)
    private static boolean areSizeAndRateSupportedV21(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i_renamed, int i2, double d_renamed) {
        if (d_renamed == -1.0d || d_renamed <= 0.0d) {
            return videoCapabilities.isSizeSupported(i_renamed, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i_renamed, i2, d_renamed);
    }

    @android.annotation.TargetApi(23)
    private static int getMaxSupportedInstancesV23(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }
}
