package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public class Constants {
    public static final java.lang.String DEFAULT_APPLICATION_NAME = "TBLPlayer";
    public static final int INTEGER_VALUE_UNSET = -1;
    public static final int NETWORK_TYPE_2G = 3;
    public static final int NETWORK_TYPE_3G = 4;
    public static final int NETWORK_TYPE_4G = 5;
    public static final int NETWORK_TYPE_CELLULAR_UNKNOWN = 6;
    public static final int NETWORK_TYPE_ETHERNET = 7;
    public static final int NETWORK_TYPE_OFFLINE = 1;
    public static final int NETWORK_TYPE_OTHER = 8;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 2;
    public static final int RENDERER_DECODE_MODE_AUTO = 0;
    public static final int RENDERER_DECODE_MODE_HW = 1;
    public static final int RENDERER_DECODE_MODE_SW = 2;
    public static final int SOURCE_EXTRACTOR_MODE_ALL = 0;
    public static final int SOURCE_EXTRACTOR_MODE_EXO = 1;
    public static final int SOURCE_EXTRACTOR_MODE_FFMPEG = 2;
    public static final java.lang.String STRING_VALUE_UNSET = "N_renamed/A_renamed";
    public static final long TIME_END_OF_SOURCE = Long.MIN_VALUE;
    public static final long TIME_UNSET = -9223372036854775807L;
    public static final int TYPE_ASSET = 6;
    public static final int TYPE_CONTENT = 5;
    public static final int TYPE_DASH = 0;
    public static final int TYPE_HLS = 2;
    public static final int TYPE_LOCAL = 4;
    public static final int TYPE_OTHER = 3;
    public static final int TYPE_RAW = 7;
    public static final int TYPE_RTMP = 9;
    public static final int TYPE_SCHEME_DATA = 8;
    public static final int TYPE_SS = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final java.lang.String DEFAULT_USER_AGENT = "TBLPlayer/1.5.9-GALLERY (Linux;Android " + android.os.Build.VERSION.RELEASE + ") " + com.google.android.exoplayer2.ExoPlayerLibraryInfo.VERSION_SLASHY;
    public static java.lang.String SLOW_MOTION_HSR_HEAD = "slow_motion_hsr_";

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ContentType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ExtractorType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RendererType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }
}
