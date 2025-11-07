package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class C_renamed {
    public static final java.lang.String ASCII_NAME = "US-ASCII";
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    public static final int AUDIOFOCUS_NONE = 0;
    public static final int AUDIO_SESSION_ID_UNSET = 0;
    public static final int BITS_PER_BYTE = 8;
    public static final int BUFFER_FLAG_DECODE_ONLY = Integer.MIN_VALUE;
    public static final int BUFFER_FLAG_ENCRYPTED = 1073741824;
    public static final int BUFFER_FLAG_END_OF_STREAM = 4;
    public static final int BUFFER_FLAG_KEY_FRAME = 1;
    public static final int BUFFER_FLAG_LAST_SAMPLE = 536870912;
    public static final int BYTES_PER_FLOAT = 4;
    public static final java.lang.String CENC_TYPE_cbc1 = "cbc1";
    public static final java.lang.String CENC_TYPE_cbcs = "cbcs";
    public static final java.lang.String CENC_TYPE_cenc = "cenc";
    public static final java.lang.String CENC_TYPE_cens = "cens";
    public static final int COLOR_RANGE_FULL = 1;
    public static final int COLOR_RANGE_LIMITED = 2;
    public static final int COLOR_SPACE_BT2020 = 6;
    public static final int COLOR_SPACE_BT601 = 2;
    public static final int COLOR_SPACE_BT709 = 1;
    public static final int COLOR_TRANSFER_HLG = 7;
    public static final int COLOR_TRANSFER_SDR = 3;
    public static final int COLOR_TRANSFER_ST2084 = 6;
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int CRYPTO_MODE_AES_CBC = 2;
    public static final int CRYPTO_MODE_AES_CTR = 1;
    public static final int CRYPTO_MODE_UNENCRYPTED = 0;
    public static final int DATA_TYPE_AD = 6;
    public static final int DATA_TYPE_CUSTOM_BASE = 10000;
    public static final int DATA_TYPE_DRM = 3;
    public static final int DATA_TYPE_MANIFEST = 4;
    public static final int DATA_TYPE_MEDIA = 1;
    public static final int DATA_TYPE_MEDIA_INITIALIZATION = 2;
    public static final int DATA_TYPE_MEDIA_PROGRESSIVE_LIVE = 7;
    public static final int DATA_TYPE_TIME_SYNCHRONIZATION = 5;
    public static final int DATA_TYPE_UNKNOWN = 0;
    public static final int DEFAULT_BUFFER_SEGMENT_SIZE = 65536;
    public static final int ENCODING_AC3 = 5;
    public static final int ENCODING_AC4 = 17;
    public static final int ENCODING_DOLBY_TRUEHD = 14;
    public static final int ENCODING_DTS = 7;
    public static final int ENCODING_DTS_HD = 8;
    public static final int ENCODING_E_AC3 = 6;
    public static final int ENCODING_INVALID = 0;
    public static final int ENCODING_PCM_16BIT = 2;
    public static final int ENCODING_PCM_24BIT = Integer.MIN_VALUE;
    public static final int ENCODING_PCM_32BIT = 1073741824;
    public static final int ENCODING_PCM_8BIT = 3;
    public static final int ENCODING_PCM_A_LAW = 536870912;
    public static final int ENCODING_PCM_FLOAT = 4;
    public static final int ENCODING_PCM_MU_LAW = 268435456;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int INDEX_UNSET = -1;
    public static final java.lang.String LANGUAGE_UNDETERMINED = "und";
    public static final int LENGTH_UNSET = -1;
    public static final long MICROS_PER_SECOND = 1000000;
    public static final int MSG_CUSTOM_BASE = 10000;
    public static final int MSG_SET_AUDIO_ATTRIBUTES = 3;
    public static final int MSG_SET_AUX_EFFECT_INFO = 5;
    public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
    public static final int MSG_SET_DROP_FRAME_POLICY = 12;
    public static final int MSG_SET_MEDIAFORMAT_MSG = 11;
    public static final int MSG_SET_SCALING_MODE = 4;
    public static final int MSG_SET_SURFACE = 1;
    public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
    public static final int MSG_SET_VOLUME = 2;
    public static final int MSG_SET_VSYNC_OFFSET = 10;
    public static final long NANOS_PER_SECOND = 1000000000;
    public static final int NETWORK_TYPE_2G = 3;
    public static final int NETWORK_TYPE_3G = 4;
    public static final int NETWORK_TYPE_4G = 5;
    public static final int NETWORK_TYPE_CELLULAR_UNKNOWN = 6;
    public static final int NETWORK_TYPE_ETHERNET = 7;
    public static final int NETWORK_TYPE_OFFLINE = 1;
    public static final int NETWORK_TYPE_OTHER = 8;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 2;
    public static final int PERCENTAGE_UNSET = -1;
    public static final int POSITION_UNSET = -1;
    public static final int PRIORITY_DOWNLOAD = -1000;
    public static final int PRIORITY_PLAYBACK = 0;
    public static final int PROJECTION_CUBEMAP = 2;
    public static final int PROJECTION_EQUIRECTANGULAR = 1;
    public static final int PROJECTION_MESH = 3;
    public static final int PROJECTION_RECTANGULAR = 0;
    public static final int RESULT_BUFFER_READ = -4;
    public static final int RESULT_END_OF_INPUT = -1;
    public static final int RESULT_FORMAT_READ = -5;
    public static final int RESULT_MAX_LENGTH_EXCEEDED = -2;
    public static final int RESULT_NOTHING_READ = -3;
    public static final java.lang.String SANS_SERIF_NAME = "sans-serif";
    public static final int SELECTION_FLAG_AUTOSELECT = 4;
    public static final int SELECTION_FLAG_DEFAULT = 1;
    public static final int SELECTION_FLAG_FORCED = 2;
    public static final int SELECTION_REASON_ADAPTIVE = 3;
    public static final int SELECTION_REASON_CUSTOM_BASE = 10000;
    public static final int SELECTION_REASON_INITIAL = 1;
    public static final int SELECTION_REASON_MANUAL = 2;
    public static final int SELECTION_REASON_TRICK_PLAY = 4;
    public static final int SELECTION_REASON_UNKNOWN = 0;
    public static final java.lang.String SERIF_NAME = "serif";
    public static final int STEREO_MODE_LEFT_RIGHT = 2;
    public static final int STEREO_MODE_MONO = 0;
    public static final int STEREO_MODE_STEREO_MESH = 3;
    public static final int STEREO_MODE_TOP_BOTTOM = 1;
    public static final int STREAM_TYPE_ALARM = 4;
    public static final int STREAM_TYPE_DEFAULT = 3;
    public static final int STREAM_TYPE_DTMF = 8;
    public static final int STREAM_TYPE_MUSIC = 3;
    public static final int STREAM_TYPE_NOTIFICATION = 5;
    public static final int STREAM_TYPE_RING = 2;
    public static final int STREAM_TYPE_SYSTEM = 1;
    public static final int STREAM_TYPE_USE_DEFAULT = Integer.MIN_VALUE;
    public static final int STREAM_TYPE_VOICE_CALL = 0;
    public static final long TIME_END_OF_SOURCE = Long.MIN_VALUE;
    public static final long TIME_UNSET = -9223372036854775807L;
    public static final int TRACK_TYPE_AUDIO = 1;
    public static final int TRACK_TYPE_CAMERA_MOTION = 5;
    public static final int TRACK_TYPE_CUSTOM_BASE = 10000;
    public static final int TRACK_TYPE_DEFAULT = 0;
    public static final int TRACK_TYPE_METADATA = 4;
    public static final int TRACK_TYPE_NONE = 6;
    public static final int TRACK_TYPE_TEXT = 3;
    public static final int TRACK_TYPE_UNKNOWN = -1;
    public static final int TRACK_TYPE_VIDEO = 2;
    public static final int TYPE_DASH = 0;
    public static final int TYPE_HLS = 2;
    public static final int TYPE_OTHER = 3;
    public static final int TYPE_SS = 1;
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    public static final java.lang.String UTF16_NAME = "UTF-16";
    public static final java.lang.String UTF8_NAME = "UTF-8";
    public static final int VIDEO_SCALING_MODE_DEFAULT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final java.util.UUID UUID_NIL = new java.util.UUID(0, 0);
    public static final java.util.UUID COMMON_PSSH_UUID = new java.util.UUID(1186680826959645954L, -5988876978535335093L);
    public static final java.util.UUID CLEARKEY_UUID = new java.util.UUID(-2129748144642739255L, 8654423357094679310L);
    public static final java.util.UUID WIDEVINE_UUID = new java.util.UUID(-1301668207276963122L, -6645017420763422227L);
    public static final java.util.UUID PLAYREADY_UUID = new java.util.UUID(-7348484286925749626L, -6083546864340672619L);

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AudioContentType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AudioFlags {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AudioFocusGain {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AudioUsage {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BufferFlags {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ColorRange {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ColorSpace {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ColorTransfer {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ContentType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CryptoMode {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Encoding {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PcmEncoding {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Projection {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SelectionFlags {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface StereoMode {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    public static long msToUs(long j_renamed) {
        return (j_renamed == -9223372036854775807L || j_renamed == Long.MIN_VALUE) ? j_renamed : j_renamed * 1000;
    }

    private C_renamed() {
    }

    public static long usToMs(long j_renamed) {
        return (j_renamed == -9223372036854775807L || j_renamed == Long.MIN_VALUE) ? j_renamed : j_renamed / 1000;
    }

    @android.annotation.TargetApi(21)
    public static int generateAudioSessionIdV21(android.content.Context context) {
        return ((android.media.AudioManager) context.getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO)).generateAudioSessionId();
    }
}
