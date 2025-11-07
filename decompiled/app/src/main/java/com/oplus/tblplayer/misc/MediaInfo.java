package com.oplus.tblplayer.misc;

/* loaded from: classes2.dex */
public class MediaInfo extends com.oplus.tblplayer.Constants {
    public static final int RENDERER_SUPPORT_HARDWARE = 3;
    public static final int RENDERER_SUPPORT_HARDWARE_TO_SOFTWARE = 4;
    public static final int RENDERER_SUPPORT_NO_TRACK = 1;
    public static final int RENDERER_SUPPORT_SOFTWARE = 5;
    public static final int RENDERER_SUPPORT_UNSET = 0;
    public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACK = 2;
    public static final java.lang.String RENDERER_TYPE_FF_AUDIO = "FF_AUDIO";
    public static final java.lang.String RENDERER_TYPE_FF_VIDEO = "FF_VIDEO";
    public static final java.lang.String RENDERER_TYPE_MC_AUDIO = "MC_AUDIO";
    public static final java.lang.String RENDERER_TYPE_MC_VIDEO = "MC_VIDEO";
    public static final java.lang.String RENDERER_TYPE_METADATA = "METADATA";
    public static final java.lang.String RENDERER_TYPE_NONE = "None";
    public static final java.lang.String RENDERER_TYPE_NOT_LOAD = "NOT_LOAD";
    public static final java.lang.String RENDERER_TYPE_TEXT = "TEXT";
    public static final java.lang.String RENDERER_TYPE_UNKNOWN = "Unknown";
    public java.lang.String audioDecoder;
    public java.lang.String audioMimeType;
    public int audioRendererSupport;
    public int audioSampleRate;
    public int bitrate;
    public int height;
    public int mediaContentType;
    public java.lang.String mediaPlayerName;
    public java.lang.String mediaUrl;
    public java.lang.String videoDecoder;
    public float videoFps;
    public java.lang.String videoMimeType;
    public int videoRendererSupport;
    public int width;

    public MediaInfo() {
        this.width = -1;
        this.height = -1;
        this.bitrate = -1;
        this.videoFps = -1.0f;
        this.videoRendererSupport = 0;
        this.audioRendererSupport = 0;
    }

    public MediaInfo(java.lang.String str) {
        this(str, 3);
    }

    public MediaInfo(java.lang.String str, int i_renamed) {
        this.width = -1;
        this.height = -1;
        this.bitrate = -1;
        this.videoFps = -1.0f;
        this.videoRendererSupport = 0;
        this.audioRendererSupport = 0;
        this.mediaUrl = str;
        this.mediaContentType = i_renamed;
    }

    public java.lang.String getResolutionString() {
        if (this.width <= 0 || this.height <= 0) {
            return com.oplus.tblplayer.Constants.STRING_VALUE_UNSET;
        }
        return this.width + " x_renamed " + this.height;
    }

    public java.lang.String getVideoFpsString() {
        float f_renamed = this.videoFps;
        return f_renamed <= 0.0f ? com.oplus.tblplayer.Constants.STRING_VALUE_UNSET : java.lang.Float.toString(f_renamed);
    }

    public java.lang.String getBitrateString() {
        int i_renamed = this.bitrate;
        return i_renamed <= 0 ? com.oplus.tblplayer.Constants.STRING_VALUE_UNSET : java.lang.Integer.toString(i_renamed);
    }

    public java.lang.String toString() {
        return "MediaInfo{mediaPlayerName=" + this.mediaPlayerName + ", mediaUrl=" + this.mediaUrl + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", videoMimeType=" + this.videoMimeType + ", audioMimeType=" + this.audioMimeType + ", videoFps=" + this.videoFps + ", audioSampleRate=" + this.audioSampleRate + ", videoDecoder=" + this.videoDecoder + ", videoDecoderType=" + this.videoRendererSupport + ", audioDecoder=" + this.audioDecoder + ", audioDecoderType=" + this.audioRendererSupport + "}";
    }
}
