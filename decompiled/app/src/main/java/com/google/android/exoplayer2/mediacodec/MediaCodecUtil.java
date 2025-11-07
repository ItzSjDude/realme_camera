package com.google.android.exoplayer2.mediacodec;

@android.annotation.SuppressLint({"InlinedApi"})
@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public final class MediaCodecUtil {
    private static final android.util.SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    private static final java.lang.String CODEC_ID_AVC1 = "avc1";
    private static final java.lang.String CODEC_ID_AVC2 = "avc2";
    private static final java.lang.String CODEC_ID_HEV1 = "hev1";
    private static final java.lang.String CODEC_ID_HVC1 = "hvc1";
    private static final java.lang.String CODEC_ID_MP4A = "mp4a";
    private static final java.util.Map<java.lang.String, java.lang.Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    private static final android.util.SparseIntArray MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE;
    private static final java.lang.String TAG = "MediaCodecUtil";
    private static final java.util.regex.Pattern PROFILE_PATTERN = java.util.regex.Pattern.compile("^\\D_renamed?(\\d_renamed+)$");
    private static final java.util.HashMap<com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey, java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo>> decoderInfosCache = new java.util.HashMap<>();
    private static int maxH264DecodableFrameSize = -1;
    private static final android.util.SparseIntArray AVC_PROFILE_NUMBER_TO_CONST = new android.util.SparseIntArray();

    private interface MediaCodecListCompat {
        int getCodecCount();

        android.media.MediaCodecInfo getCodecInfoAt(int i_renamed);

        boolean isSecurePlaybackSupported(java.lang.String str, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    private static int avcLevelToMaxFrameSize(int i_renamed) {
        if (i_renamed == 1 || i_renamed == 2) {
            return 25344;
        }
        switch (i_renamed) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return com.oplus.tblplayer.config.PreCacheConfig.DEFAULT_MAX_CACHE_FILE_SIZE;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    public static class DecoderQueryException extends java.lang.Exception {
        public DecoderQueryException(java.lang.Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        AVC_PROFILE_NUMBER_TO_CONST.put(66, 1);
        AVC_PROFILE_NUMBER_TO_CONST.put(77, 2);
        AVC_PROFILE_NUMBER_TO_CONST.put(88, 4);
        AVC_PROFILE_NUMBER_TO_CONST.put(100, 8);
        AVC_PROFILE_NUMBER_TO_CONST.put(110, 16);
        AVC_PROFILE_NUMBER_TO_CONST.put(122, 32);
        AVC_PROFILE_NUMBER_TO_CONST.put(244, 64);
        AVC_LEVEL_NUMBER_TO_CONST = new android.util.SparseIntArray();
        AVC_LEVEL_NUMBER_TO_CONST.put(10, 1);
        AVC_LEVEL_NUMBER_TO_CONST.put(11, 4);
        AVC_LEVEL_NUMBER_TO_CONST.put(12, 8);
        AVC_LEVEL_NUMBER_TO_CONST.put(13, 16);
        AVC_LEVEL_NUMBER_TO_CONST.put(20, 32);
        AVC_LEVEL_NUMBER_TO_CONST.put(21, 64);
        AVC_LEVEL_NUMBER_TO_CONST.put(22, 128);
        AVC_LEVEL_NUMBER_TO_CONST.put(30, 256);
        AVC_LEVEL_NUMBER_TO_CONST.put(31, 512);
        AVC_LEVEL_NUMBER_TO_CONST.put(32, 1024);
        AVC_LEVEL_NUMBER_TO_CONST.put(40, 2048);
        AVC_LEVEL_NUMBER_TO_CONST.put(41, 4096);
        AVC_LEVEL_NUMBER_TO_CONST.put(42, 8192);
        AVC_LEVEL_NUMBER_TO_CONST.put(50, 16384);
        AVC_LEVEL_NUMBER_TO_CONST.put(51, 32768);
        AVC_LEVEL_NUMBER_TO_CONST.put(52, 65536);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL = new java.util.HashMap();
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L30", 1);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L60", 4);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L63", 16);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L90", 64);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L93", 256);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L120", 1024);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L123", 4096);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L150", 16384);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L153", 65536);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L156", java.lang.Integer.valueOf(com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE));
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L180", java.lang.Integer.valueOf(com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES));
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L183", 4194304);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L186", 16777216);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H30", 2);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H60", 8);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H63", 32);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H90", 128);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H93", 512);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H120", 2048);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H123", 8192);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H150", 32768);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H153", 131072);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H156", java.lang.Integer.valueOf(com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM));
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H180", java.lang.Integer.valueOf(com.oplus.tblplayer.config.PreCacheConfig.DEFAULT_MAX_CACHE_FILE_SIZE));
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H183", 8388608);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H186", 33554432);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE = new android.util.SparseIntArray();
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(1, 1);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(2, 2);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(3, 3);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(4, 4);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(5, 5);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(6, 6);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(17, 17);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(20, 20);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(23, 23);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(29, 29);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(39, 39);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(42, 42);
    }

    private MediaCodecUtil() {
    }

    public static void warmDecoderInfoCache(java.lang.String str, boolean z_renamed) {
        try {
            getDecoderInfos(str, z_renamed);
        } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Codec warming failed", e_renamed);
        }
    }

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo getPassthroughDecoderInfo() throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.MediaCodecInfo decoderInfo = getDecoderInfo(com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW, false);
        if (decoderInfo == null) {
            return null;
        }
        return com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newPassthroughInstance(decoderInfo.name);
    }

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo getDecoderInfo(java.lang.String str, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = getDecoderInfos(str, z_renamed);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(java.lang.String str, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey codecKey = new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey(str, z_renamed);
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> list = decoderInfosCache.get(codecKey);
        if (list != null) {
            return list;
        }
        com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat mediaCodecListCompatV21 = com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV21(z_renamed) : new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV16();
        java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompatV21, str);
        if (z_renamed && decoderInfosInternal.isEmpty() && 21 <= com.google.android.exoplayer2.util.Util.SDK_INT && com.google.android.exoplayer2.util.Util.SDK_INT <= 23) {
            mediaCodecListCompatV21 = new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV16();
            decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompatV21, str);
            if (!decoderInfosInternal.isEmpty()) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "MediaCodecList API didn't_renamed list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).name);
            }
        }
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
            decoderInfosInternal.addAll(getDecoderInfosInternal(new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey(com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3, codecKey.secure), mediaCodecListCompatV21, str));
        }
        applyWorkarounds(str, decoderInfosInternal);
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> listUnmodifiableList = java.util.Collections.unmodifiableList(decoderInfosInternal);
        decoderInfosCache.put(codecKey, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static int maxH264DecodableFrameSize() throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        if (maxH264DecodableFrameSize == -1) {
            int iMax = 0;
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo decoderInfo = getDecoderInfo(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264, false);
            if (decoderInfo != null) {
                android.media.MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = java.lang.Math.max(avcLevelToMaxFrameSize(profileLevels[iMax].level), iMax2);
                    iMax++;
                }
                iMax = java.lang.Math.max(iMax2, com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? 345600 : 172800);
            }
            maxH264DecodableFrameSize = iMax;
        }
        return maxH264DecodableFrameSize;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(java.lang.String r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L4_renamed
            return r0
        L4_renamed:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r10.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            switch(r5) {
                case 3006243: goto L41;
                case 3006244: goto L37;
                case 3199032: goto L2e;
                case 3214780: goto L24;
                case 3356560: goto L1a;
                default: goto L19;
            }
        L19:
            goto L4b
        L1a:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L4b
            r2 = r6
            goto L4c
        L24:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L4b
            r2 = r9
            goto L4c
        L2e:
            java.lang.String r5 = "hev1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L4b
            goto L4c
        L37:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L4b
            r2 = r7
            goto L4c
        L41:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L4b
            r2 = r8
            goto L4c
        L4b:
            r2 = r4
        L4c:
            if (r2 == 0) goto L61
            if (r2 == r9) goto L61
            if (r2 == r8) goto L5c
            if (r2 == r7) goto L5c
            if (r2 == r6) goto L57
            return r0
        L57:
            android.util.Pair r10 = getAacCodecProfileAndLevel(r10, r1)
            return r10
        L5c:
            android.util.Pair r10 = getAvcProfileAndLevel(r10, r1)
            return r10
        L61:
            android.util.Pair r10 = getHevcProfileAndLevel(r10, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(java.lang.String):android.util.Pair");
    }

    private static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfosInternal(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey codecKey, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat mediaCodecListCompat, java.lang.String str) throws java.lang.Exception {
        int i_renamed;
        com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
        try {
            java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> arrayList = new java.util.ArrayList<>();
            java.lang.String str2 = codecKey.mimeType;
            int codecCount = mediaCodecListCompat.getCodecCount();
            boolean zSecureDecodersExplicit = mediaCodecListCompat.secureDecodersExplicit();
            int i2 = 0;
            while (i2 < codecCount) {
                android.media.MediaCodecInfo codecInfoAt = mediaCodecListCompat2.getCodecInfoAt(i2);
                java.lang.String name = codecInfoAt.getName();
                if (isCodecUsableDecoder(codecInfoAt, name, zSecureDecodersExplicit, str)) {
                    java.lang.String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (i3 < length) {
                        java.lang.String str3 = supportedTypes[i3];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str3);
                                boolean zIsSecurePlaybackSupported = mediaCodecListCompat2.isSecurePlaybackSupported(str2, capabilitiesForType);
                                boolean zCodecNeedsDisableAdaptationWorkaround = codecNeedsDisableAdaptationWorkaround(name);
                                if (zSecureDecodersExplicit) {
                                    i_renamed = codecCount;
                                    try {
                                        if (codecKey.secure != zIsSecurePlaybackSupported) {
                                        }
                                        arrayList.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(name, str2, capabilitiesForType, zCodecNeedsDisableAdaptationWorkaround, false));
                                    } catch (java.lang.Exception e_renamed) {
                                        e_renamed = e_renamed;
                                        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 23 && !arrayList.isEmpty()) {
                                            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Skipping codec " + name + " (failed to query capabilities)");
                                            i3++;
                                            mediaCodecListCompat2 = mediaCodecListCompat;
                                            codecCount = i_renamed;
                                        } else {
                                            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Failed to query codec " + name + " (" + str3 + ")");
                                            throw e_renamed;
                                        }
                                    }
                                } else {
                                    i_renamed = codecCount;
                                }
                                if (!zSecureDecodersExplicit && !codecKey.secure) {
                                    arrayList.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(name, str2, capabilitiesForType, zCodecNeedsDisableAdaptationWorkaround, false));
                                } else if (!zSecureDecodersExplicit && zIsSecurePlaybackSupported) {
                                    arrayList.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(name + ".secure", str2, capabilitiesForType, zCodecNeedsDisableAdaptationWorkaround, true));
                                    return arrayList;
                                }
                            } catch (java.lang.Exception e2) {
                                e_renamed = e2;
                                i_renamed = codecCount;
                            }
                        } else {
                            i_renamed = codecCount;
                        }
                        i3++;
                        mediaCodecListCompat2 = mediaCodecListCompat;
                        codecCount = i_renamed;
                    }
                }
                i2++;
                mediaCodecListCompat2 = mediaCodecListCompat;
                codecCount = codecCount;
            }
            return arrayList;
        } catch (java.lang.Exception e3) {
            throw new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException(e3);
        }
    }

    private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo mediaCodecInfo, java.lang.String str, boolean z_renamed, java.lang.String str2) {
        if (mediaCodecInfo.isEncoder() || (!z_renamed && str.endsWith(".secure"))) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(com.google.android.exoplayer2.util.Util.DEVICE) || ("Xiaomi".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && com.google.android.exoplayer2.util.Util.DEVICE.startsWith("HM")))) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "protou".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "ville".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "villeplus".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "villec2".equals(com.google.android.exoplayer2.util.Util.DEVICE) || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("gee") || "C6602".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "C6603".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "C6606".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "C6616".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "L36h".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "SO-02E".equals(com.google.android.exoplayer2.util.Util.DEVICE))) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "C1505".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "C1604".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "C1605".equals(com.google.android.exoplayer2.util.Util.DEVICE))) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && (com.google.android.exoplayer2.util.Util.DEVICE.startsWith("zeroflte") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("zerolte") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("zenlte") || "SC-05G".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "marinelteatt".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "404SC".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "SC-04G".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "SCV31".equals(com.google.android.exoplayer2.util.Util.DEVICE)))) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && (com.google.android.exoplayer2.util.Util.DEVICE.startsWith("d2") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("serrano") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("jflte") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("santos") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("t0"))) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 19 && com.google.android.exoplayer2.util.Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static void applyWorkarounds(java.lang.String str, java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> list) {
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW.equals(str)) {
            java.util.Collections.sort(list, new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.RawAudioCodecComparator());
            return;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21 || list.size() <= 1) {
            return;
        }
        java.lang.String str2 = list.get(0).name;
        if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
            java.util.Collections.sort(list, new com.google.android.exoplayer2.mediacodec.MediaCodecUtil.PreferOmxGoogleCodecComparator());
        }
    }

    private static boolean codecNeedsDisableAdaptationWorkaround(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.SDK_INT <= 22 && ("ODROID-XU3".equals(com.google.android.exoplayer2.util.Util.MODEL) || "Nexus 10".equals(com.google.android.exoplayer2.util.Util.MODEL)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> getHevcProfileAndLevel(java.lang.String str, java.lang.String[] strArr) {
        int i_renamed;
        if (strArr.length < 4) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        java.util.regex.Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        java.lang.String strGroup = matcher.group(1);
        if ("1".equals(strGroup)) {
            i_renamed = 1;
        } else {
            if (!"2".equals(strGroup)) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i_renamed = 2;
        }
        java.lang.Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(strArr[3]);
        if (num == null) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        return new android.util.Pair<>(java.lang.Integer.valueOf(i_renamed), num);
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> getAvcProfileAndLevel(java.lang.String str, java.lang.String[] strArr) {
        java.lang.Integer numValueOf;
        java.lang.Integer numValueOf2;
        if (strArr.length < 2) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                java.lang.Integer numValueOf3 = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[1].substring(0, 2), 16));
                numValueOf2 = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[1].substring(4), 16));
                numValueOf = numValueOf3;
            } else if (strArr.length >= 3) {
                numValueOf = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[1]));
                numValueOf2 = java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArr[2]));
            } else {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int i_renamed = AVC_PROFILE_NUMBER_TO_CONST.get(numValueOf.intValue(), -1);
            if (i_renamed == -1) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unknown AVC profile: " + numValueOf);
                return null;
            }
            int i2 = AVC_LEVEL_NUMBER_TO_CONST.get(numValueOf2.intValue(), -1);
            if (i2 == -1) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unknown AVC level: " + numValueOf2);
                return null;
            }
            return new android.util.Pair<>(java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        } catch (java.lang.NumberFormatException unused) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> getAacCodecProfileAndLevel(java.lang.String str, java.lang.String[] strArr) throws java.lang.NumberFormatException {
        if (strArr.length != 3) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC.equals(com.google.android.exoplayer2.util.MimeTypes.getMimeTypeFromMp4ObjectType(java.lang.Integer.parseInt(strArr[1], 16)))) {
                int i_renamed = MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.get(java.lang.Integer.parseInt(strArr[2]), -1);
                if (i_renamed != -1) {
                    return new android.util.Pair<>(java.lang.Integer.valueOf(i_renamed), 0);
                }
            }
        } catch (java.lang.NumberFormatException unused) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @android.annotation.TargetApi(21)
    private static final class MediaCodecListCompatV21 implements com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat {
        private final int codecKind;
        private android.media.MediaCodecInfo[] mediaCodecInfos;

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return true;
        }

        public MediaCodecListCompatV21(boolean z_renamed) {
            this.codecKind = z_renamed ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i_renamed) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i_renamed];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(java.lang.String str, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new android.media.MediaCodecList(this.codecKind).getCodecInfos();
            }
        }
    }

    private static final class MediaCodecListCompatV16 implements com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat {
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return false;
        }

        private MediaCodecListCompatV16() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            return android.media.MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i_renamed) {
            return android.media.MediaCodecList.getCodecInfoAt(i_renamed);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(java.lang.String str, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264.equals(str);
        }
    }

    private static final class CodecKey {
        public final java.lang.String mimeType;
        public final boolean secure;

        public CodecKey(java.lang.String str, boolean z_renamed) {
            this.mimeType = str;
            this.secure = z_renamed;
        }

        public int hashCode() {
            java.lang.String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.secure ? 1231 : 1237);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey.class) {
                return false;
            }
            com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey codecKey = (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey) obj;
            return android.text.TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure;
        }
    }

    private static final class RawAudioCodecComparator implements java.util.Comparator<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> {
        private RawAudioCodecComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo2) {
            return scoreMediaCodecInfo(mediaCodecInfo) - scoreMediaCodecInfo(mediaCodecInfo2);
        }

        private static int scoreMediaCodecInfo(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
            java.lang.String str = mediaCodecInfo.name;
            if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
                return -1;
            }
            return (com.google.android.exoplayer2.util.Util.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : 1;
        }
    }

    private static final class PreferOmxGoogleCodecComparator implements java.util.Comparator<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> {
        private PreferOmxGoogleCodecComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo2) {
            return scoreMediaCodecInfo(mediaCodecInfo) - scoreMediaCodecInfo(mediaCodecInfo2);
        }

        private static int scoreMediaCodecInfo(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
            return mediaCodecInfo.name.startsWith("OMX.google") ? -1 : 0;
        }
    }
}
