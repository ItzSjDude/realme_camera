package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegLibrary {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final java.lang.String AUDIO_APE = "audio/ape";
    static final java.lang.String AUDIO_ATRAC3 = "audio/atrac3";
    static final java.lang.String AUDIO_COOK = "audio/cook";
    static final java.lang.String AUDIO_WMA1 = "audio/wmav1";
    static final java.lang.String AUDIO_WMA2 = "audio/wmav2";
    static final java.lang.String AUDIO_WMALOSSLESS = "audio/wmalossless";
    static final java.lang.String AUDIO_WMAPRO = "audio/wmapro";
    private static final com.google.android.exoplayer2.util.LibraryLoader LOADER;
    private static final java.lang.String MIME_TYPE_PREFIX_APPLICATION = "application/";
    private static final java.lang.String MIME_TYPE_PREFIX_AUDIO = "audio/";
    private static final java.lang.String MIME_TYPE_PREFIX_TEXT = "text/";
    private static final java.lang.String MIME_TYPE_PREFIX_VIDEO = "video/";
    private static final java.lang.String TAG = "FfmpegLibrary";
    private static final java.lang.String VIDEO_FLV = "video/flv";
    private static final java.lang.String VIDEO_MSMPEG4 = "video/msmpeg4";
    private static final java.lang.String VIDEO_WMV1 = "video/wmv1";
    private static final java.lang.String VIDEO_WMV2 = "video/wmv2";
    private static final java.lang.String VIDEO_WMV3 = "video/wmv3";
    private static final java.lang.String[] containerWhiteList;

    private static native java.lang.String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(java.lang.String str);

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.ffmpeg.tbl");
        LOADER = new com.google.android.exoplayer2.util.LibraryLoader("ffmpeg", "ffmpegJNI");
        containerWhiteList = new java.lang.String[]{"aac", "aiff", "amr", "ape", "asf", "flac", "loas", "mov,mp4,m4a,3gp,3g2,mj2", "mp3", "ogg", "rm", "wav"};
    }

    private FfmpegLibrary() {
    }

    public static void setLibraries(java.lang.String... strArr) {
        LOADER.setLibraries(strArr);
    }

    public static boolean isAvailable() {
        return LOADER.isAvailable();
    }

    public static java.lang.String getVersion() {
        if (isAvailable()) {
            return ffmpegGetVersion();
        }
        return null;
    }

    static boolean supportsFormat(com.google.android.exoplayer2.Format format) {
        java.lang.String codecName;
        return isAvailable() && (codecName = getCodecName(format.sampleMimeType)) != null && ffmpegHasDecoder(codecName);
    }

    private static boolean containerInWhiteList(java.lang.String str) {
        if (str == null) {
            return true;
        }
        for (java.lang.String str2 : containerWhiteList) {
            if (str2.compareTo(str) == 0) {
                return true;
            }
        }
        return false;
    }

    static java.lang.String getCodecName(java.lang.String str) {
        if (str == null || str.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN) || str.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_UNKNOWN)) {
            return null;
        }
        switch (str) {
            case "audio/mp4a-latm":
                return "aac";
            case "audio/mpeg":
            case "audio/mpeg-L1_renamed":
                return "mp3";
            case "audio/mpeg-L2_renamed":
                return "mp2";
            case "audio/ac3":
                return "ac3";
            case "audio/eac3":
            case "audio/eac3-joc":
                return "eac3";
            case "audio/true-hd":
                return "truehd";
            case "audio/vnd.dts":
            case "audio/vnd.dts.hd":
                return "dca";
            case "audio/vorbis":
                return "vorbis";
            case "audio/opus":
                return "opus";
            case "audio/3gpp":
                return "amrnb";
            case "audio/amr-wb":
                return "amrwb";
            case "audio/flac":
                return "flac";
            case "audio/alac":
                return "alac";
            case "audio/g711-mlaw":
                return "pcm_mulaw";
            case "audio/g711-alaw":
                return "pcm_alaw";
            case "audio/wmav2":
                return "wmav2";
            case "audio/ape":
                return "ape";
            case "audio/cook":
                return "cook";
            case "video/3gpp":
                return "h263";
            case "video/avc":
                return "h264";
            case "video/hevc":
                return "hevc";
            case "video/wvc1":
                return "vc1";
            case "video/webm":
            case "video/x_renamed-vnd.on2.vp8":
                return "vp8";
            case "video/x_renamed-vnd.on2.vp9":
                return "vp9";
            case "video/mp4":
                return "h264";
            case "video/mp4v-es_renamed":
                return "mpeg4";
            case "video/mpeg":
                return "mpegvideo";
            case "video/mpeg2":
                return "mpeg2video";
            case "video/msmpeg4":
                return "msmpeg4";
            case "video/wmv1":
                return "wmv1";
            case "video/wmv2":
                return "wmv2";
            case "video/wmv3":
                return "wmv3";
            case "video/flv":
                return "flv";
            default:
                return parseFfmpegCodecName(str);
        }
    }

    private static java.lang.String parseFfmpegCodecName(java.lang.String str) {
        if (str.startsWith(MIME_TYPE_PREFIX_AUDIO)) {
            return str.substring(6);
        }
        if (str.startsWith(MIME_TYPE_PREFIX_VIDEO)) {
            return str.substring(6);
        }
        if (str.startsWith(MIME_TYPE_PREFIX_TEXT)) {
            return str.substring(5);
        }
        return null;
    }
}
