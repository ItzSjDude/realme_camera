package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class MimeTypes {
    public static final java.lang.String APPLICATION_CAMERA_MOTION = "application/x_renamed-camera-motion";
    public static final java.lang.String APPLICATION_CEA608 = "application/cea-608";
    public static final java.lang.String APPLICATION_CEA708 = "application/cea-708";
    public static final java.lang.String APPLICATION_DVBSUBS = "application/dvbsubs";
    public static final java.lang.String APPLICATION_EMSG = "application/x_renamed-emsg";
    public static final java.lang.String APPLICATION_EXIF = "application/x_renamed-exif";
    public static final java.lang.String APPLICATION_ID3 = "application/id3";
    public static final java.lang.String APPLICATION_M3U8 = "application/x_renamed-mpegURL";
    public static final java.lang.String APPLICATION_MP4 = "application/mp4";
    public static final java.lang.String APPLICATION_MP4CEA608 = "application/x_renamed-mp4-cea-608";
    public static final java.lang.String APPLICATION_MP4VTT = "application/x_renamed-mp4-vtt";
    public static final java.lang.String APPLICATION_MPD = "application/dash+xml";
    public static final java.lang.String APPLICATION_PGS = "application/pgs";
    public static final java.lang.String APPLICATION_RAWCC = "application/x_renamed-rawcc";
    public static final java.lang.String APPLICATION_SCTE35 = "application/x_renamed-scte35";
    public static final java.lang.String APPLICATION_SS = "application/vnd.ms-sstr+xml";
    public static final java.lang.String APPLICATION_SUBRIP = "application/x_renamed-subrip";
    public static final java.lang.String APPLICATION_TTML = "application/ttml+xml";
    public static final java.lang.String APPLICATION_TX3G = "application/x_renamed-quicktime-tx3g";
    public static final java.lang.String APPLICATION_VOBSUB = "application/vobsub";
    public static final java.lang.String APPLICATION_WEBM = "application/webm";
    public static final java.lang.String AUDIO_AAC = "audio/mp4a-latm";
    public static final java.lang.String AUDIO_AC3 = "audio/ac3";
    public static final java.lang.String AUDIO_AC4 = "audio/ac4";
    public static final java.lang.String AUDIO_ALAC = "audio/alac";
    public static final java.lang.String AUDIO_ALAW = "audio/g711-alaw";
    public static final java.lang.String AUDIO_AMR_NB = "audio/3gpp";
    public static final java.lang.String AUDIO_AMR_WB = "audio/amr-wb";
    public static final java.lang.String AUDIO_DTS = "audio/vnd.dts";
    public static final java.lang.String AUDIO_DTS_EXPRESS = "audio/vnd.dts.hd;profile=lbr";
    public static final java.lang.String AUDIO_DTS_HD = "audio/vnd.dts.hd";
    public static final java.lang.String AUDIO_E_AC3 = "audio/eac3";
    public static final java.lang.String AUDIO_E_AC3_JOC = "audio/eac3-joc";
    public static final java.lang.String AUDIO_FLAC = "audio/flac";
    public static final java.lang.String AUDIO_MLAW = "audio/g711-mlaw";
    public static final java.lang.String AUDIO_MP4 = "audio/mp4";
    public static final java.lang.String AUDIO_MPEG = "audio/mpeg";
    public static final java.lang.String AUDIO_MPEG_L1 = "audio/mpeg-L1_renamed";
    public static final java.lang.String AUDIO_MPEG_L2 = "audio/mpeg-L2_renamed";
    public static final java.lang.String AUDIO_MSGSM = "audio/gsm";
    public static final java.lang.String AUDIO_OPUS = "audio/opus";
    public static final java.lang.String AUDIO_RAW = "audio/raw";
    public static final java.lang.String AUDIO_TRUEHD = "audio/true-hd";
    public static final java.lang.String AUDIO_UNKNOWN = "audio/x_renamed-unknown";
    public static final java.lang.String AUDIO_VORBIS = "audio/vorbis";
    public static final java.lang.String AUDIO_WEBM = "audio/webm";
    public static final java.lang.String BASE_TYPE_APPLICATION = "application";
    public static final java.lang.String BASE_TYPE_AUDIO = "audio";
    public static final java.lang.String BASE_TYPE_TEXT = "text";
    public static final java.lang.String BASE_TYPE_VIDEO = "video";
    public static final java.lang.String TEXT_SSA = "text/x_renamed-ssa";
    public static final java.lang.String TEXT_VTT = "text/vtt";
    public static final java.lang.String VIDEO_AV1 = "video/av01";
    public static final java.lang.String VIDEO_H263 = "video/3gpp";
    public static final java.lang.String VIDEO_H264 = "video/avc";
    public static final java.lang.String VIDEO_H265 = "video/hevc";
    public static final java.lang.String VIDEO_MP4 = "video/mp4";
    public static final java.lang.String VIDEO_MP4V = "video/mp4v-es_renamed";
    public static final java.lang.String VIDEO_MPEG = "video/mpeg";
    public static final java.lang.String VIDEO_MPEG2 = "video/mpeg2";
    public static final java.lang.String VIDEO_UNKNOWN = "video/x_renamed-unknown";
    public static final java.lang.String VIDEO_VC1 = "video/wvc1";
    public static final java.lang.String VIDEO_VP8 = "video/x_renamed-vnd.on2.vp8";
    public static final java.lang.String VIDEO_VP9 = "video/x_renamed-vnd.on2.vp9";
    public static final java.lang.String VIDEO_WEBM = "video/webm";
    private static final java.util.ArrayList<com.google.android.exoplayer2.util.MimeTypes.CustomMimeType> customMimeTypes = new java.util.ArrayList<>();

    public static java.lang.String getMimeTypeFromMp4ObjectType(int i_renamed) {
        if (i_renamed == 32) {
            return VIDEO_MP4V;
        }
        if (i_renamed == 33) {
            return VIDEO_H264;
        }
        if (i_renamed == 35) {
            return VIDEO_H265;
        }
        if (i_renamed == 64) {
            return AUDIO_AAC;
        }
        if (i_renamed == 163) {
            return VIDEO_VC1;
        }
        if (i_renamed == 177) {
            return VIDEO_VP9;
        }
        if (i_renamed == 165) {
            return AUDIO_AC3;
        }
        if (i_renamed == 166) {
            return AUDIO_E_AC3;
        }
        switch (i_renamed) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return AUDIO_AAC;
            case 105:
            case 107:
                return AUDIO_MPEG;
            case 106:
                return VIDEO_MPEG;
            default:
                switch (i_renamed) {
                    case 169:
                    case 172:
                        return AUDIO_DTS;
                    case 170:
                    case 171:
                        return AUDIO_DTS_HD;
                    case 173:
                        return AUDIO_OPUS;
                    case 174:
                        return AUDIO_AC4;
                    default:
                        return null;
                }
        }
    }

    public static void registerCustomMimeType(java.lang.String str, java.lang.String str2, int i_renamed) {
        com.google.android.exoplayer2.util.MimeTypes.CustomMimeType customMimeType = new com.google.android.exoplayer2.util.MimeTypes.CustomMimeType(str, str2, i_renamed);
        int size = customMimeTypes.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (str.equals(customMimeTypes.get(i2).mimeType)) {
                customMimeTypes.remove(i2);
                break;
            }
            i2++;
        }
        customMimeTypes.add(customMimeType);
    }

    public static boolean isAudio(java.lang.String str) {
        return BASE_TYPE_AUDIO.equals(getTopLevelType(str));
    }

    public static boolean isVideo(java.lang.String str) {
        return "video".equals(getTopLevelType(str));
    }

    public static boolean isText(java.lang.String str) {
        return BASE_TYPE_TEXT.equals(getTopLevelType(str));
    }

    public static boolean isApplication(java.lang.String str) {
        return BASE_TYPE_APPLICATION.equals(getTopLevelType(str));
    }

    public static java.lang.String getVideoMediaMimeType(java.lang.String str) {
        if (str == null) {
            return null;
        }
        for (java.lang.String str2 : com.google.android.exoplayer2.util.Util.splitCodecs(str)) {
            java.lang.String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isVideo(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static java.lang.String getAudioMediaMimeType(java.lang.String str) {
        if (str == null) {
            return null;
        }
        for (java.lang.String str2 : com.google.android.exoplayer2.util.Util.splitCodecs(str)) {
            java.lang.String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isAudio(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static java.lang.String getMediaMimeType(java.lang.String str) {
        java.lang.String mimeTypeFromMp4ObjectType = null;
        if (str == null) {
            return null;
        }
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(str.trim());
        if (lowerInvariant.startsWith("avc1") || lowerInvariant.startsWith("avc3")) {
            return VIDEO_H264;
        }
        if (lowerInvariant.startsWith("hev1") || lowerInvariant.startsWith("hvc1")) {
            return VIDEO_H265;
        }
        if (lowerInvariant.startsWith("vp9") || lowerInvariant.startsWith("vp09")) {
            return VIDEO_VP9;
        }
        if (lowerInvariant.startsWith("vp8") || lowerInvariant.startsWith("vp08")) {
            return VIDEO_VP8;
        }
        if (lowerInvariant.startsWith("av01")) {
            return VIDEO_AV1;
        }
        if (!lowerInvariant.startsWith("mp4a")) {
            return (lowerInvariant.startsWith("ac_renamed-3") || lowerInvariant.startsWith("dac3")) ? AUDIO_AC3 : (lowerInvariant.startsWith("ec_renamed-3") || lowerInvariant.startsWith("dec3")) ? AUDIO_E_AC3 : lowerInvariant.startsWith("ec_renamed+3") ? AUDIO_E_AC3_JOC : (lowerInvariant.startsWith("ac_renamed-4") || lowerInvariant.startsWith("dac4")) ? AUDIO_AC4 : (lowerInvariant.startsWith("dtsc") || lowerInvariant.startsWith("dtse")) ? AUDIO_DTS : (lowerInvariant.startsWith("dtsh") || lowerInvariant.startsWith("dtsl")) ? AUDIO_DTS_HD : lowerInvariant.startsWith("opus") ? AUDIO_OPUS : lowerInvariant.startsWith("vorbis") ? AUDIO_VORBIS : lowerInvariant.startsWith("flac") ? AUDIO_FLAC : getCustomMimeTypeForCodec(lowerInvariant);
        }
        if (lowerInvariant.startsWith("mp4a.")) {
            java.lang.String strSubstring = lowerInvariant.substring(5);
            if (strSubstring.length() >= 2) {
                try {
                    mimeTypeFromMp4ObjectType = getMimeTypeFromMp4ObjectType(java.lang.Integer.parseInt(com.google.android.exoplayer2.util.Util.toUpperInvariant(strSubstring.substring(0, 2)), 16));
                } catch (java.lang.NumberFormatException unused) {
                }
            }
        }
        return mimeTypeFromMp4ObjectType == null ? AUDIO_AAC : mimeTypeFromMp4ObjectType;
    }

    public static int getTrackType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (isAudio(str)) {
            return 1;
        }
        if (isVideo(str)) {
            return 2;
        }
        if (isText(str) || APPLICATION_CEA608.equals(str) || APPLICATION_CEA708.equals(str) || APPLICATION_MP4CEA608.equals(str) || APPLICATION_SUBRIP.equals(str) || APPLICATION_TTML.equals(str) || APPLICATION_TX3G.equals(str) || APPLICATION_MP4VTT.equals(str) || APPLICATION_RAWCC.equals(str) || APPLICATION_VOBSUB.equals(str) || APPLICATION_PGS.equals(str) || APPLICATION_DVBSUBS.equals(str)) {
            return 3;
        }
        if (APPLICATION_ID3.equals(str) || APPLICATION_EMSG.equals(str) || APPLICATION_SCTE35.equals(str)) {
            return 4;
        }
        if (APPLICATION_CAMERA_MOTION.equals(str)) {
            return 5;
        }
        return getTrackTypeForCustomMimeType(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getEncoding(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 6
            r2 = 5
            r3 = 0
            switch(r0) {
                case -2123537834: goto L47;
                case -1095064472: goto L3d;
                case 187078296: goto L33;
                case 187078297: goto L29;
                case 1504578661: goto L1f;
                case 1505942594: goto L15;
                case 1556697186: goto Lb;
                default: goto La;
            }
        La:
            goto L51
        Lb:
            java.lang.String r0 = "audio/true-hd"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L51
            r4 = r1
            goto L52
        L15:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L51
            r4 = r2
            goto L52
        L1f:
            java.lang.String r0 = "audio/eac3"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L51
            r4 = 1
            goto L52
        L29:
            java.lang.String r0 = "audio/ac4"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L51
            r4 = 3
            goto L52
        L33:
            java.lang.String r0 = "audio/ac3"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L51
            r4 = r3
            goto L52
        L3d:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L51
            r4 = 4
            goto L52
        L47:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L51
            r4 = 2
            goto L52
        L51:
            r4 = -1
        L52:
            switch(r4) {
                case 0: goto L62;
                case 1: goto L61;
                case 2: goto L61;
                case 3: goto L5e;
                case 4: goto L5c;
                case 5: goto L59;
                case 6: goto L56;
                default: goto L55;
            }
        L55:
            return r3
        L56:
            r4 = 14
            return r4
        L59:
            r4 = 8
            return r4
        L5c:
            r4 = 7
            return r4
        L5e:
            r4 = 17
            return r4
        L61:
            return r1
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.MimeTypes.getEncoding(java.lang.String):int");
    }

    public static int getTrackTypeOfCodec(java.lang.String str) {
        return getTrackType(getMediaMimeType(str));
    }

    private static java.lang.String getTopLevelType(java.lang.String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf == -1) {
            throw new java.lang.IllegalArgumentException("Invalid mime type: " + str);
        }
        return str.substring(0, iIndexOf);
    }

    private static java.lang.String getCustomMimeTypeForCodec(java.lang.String str) {
        int size = customMimeTypes.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.util.MimeTypes.CustomMimeType customMimeType = customMimeTypes.get(i_renamed);
            if (str.startsWith(customMimeType.codecPrefix)) {
                return customMimeType.mimeType;
            }
        }
        return null;
    }

    private static int getTrackTypeForCustomMimeType(java.lang.String str) {
        int size = customMimeTypes.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.util.MimeTypes.CustomMimeType customMimeType = customMimeTypes.get(i_renamed);
            if (str.equals(customMimeType.mimeType)) {
                return customMimeType.trackType;
            }
        }
        return -1;
    }

    private MimeTypes() {
    }

    private static final class CustomMimeType {
        public final java.lang.String codecPrefix;
        public final java.lang.String mimeType;
        public final int trackType;

        public CustomMimeType(java.lang.String str, java.lang.String str2, int i_renamed) {
            this.mimeType = str;
            this.codecPrefix = str2;
            this.trackType = i_renamed;
        }
    }
}
