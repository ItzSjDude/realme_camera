package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegUtil {
    private static final int AV_SAMPLE_FMT_FLT = 3;
    private static final int AV_SAMPLE_FMT_NONE = -1;
    private static final int AV_SAMPLE_FMT_S16 = 1;
    private static final int AV_SAMPLE_FMT_U8 = 0;
    public static final boolean DEBUG = false;
    private static final java.lang.String TAG = "FfmpegUtil";
    private static boolean isSpecialVideoCodec;

    public static void d_renamed(java.lang.String str, java.lang.String str2) {
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void dfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
    }

    public static java.lang.String getSeekWhenceString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? i_renamed != 65536 ? "unknown whence" : "AVSEEK_SIZE" : "SEEK_END" : "SEEK_CUR" : "SEEK_SET";
    }

    public static final int pcmEncodingToAVSampleFormat(int i_renamed) {
        if (i_renamed == 2) {
            return 1;
        }
        if (i_renamed != 3) {
            return i_renamed != 4 ? -1 : 3;
        }
        return 0;
    }

    public static boolean hasFfmpegCodecParameters(com.google.android.exoplayer2.Format format) {
        return isFfmpegExtractor(format) && format.initializationData != null && format.initializationData.size() > 0;
    }

    public static boolean isFfmpegExtraDataEmpty(com.google.android.exoplayer2.Format format) {
        return hasFfmpegCodecParameters(format) && format.initializationData.size() == 1;
    }

    public static boolean isFfmpegExtractor(com.google.android.exoplayer2.Format format) {
        return (format == null || format.label == null || !format.label.contains(com.oplus.tblplayer.ffmpeg.FfmpegExtractor.TAG)) ? false : true;
    }

    public static boolean isVideoPixelFormatHwNotSupported(com.google.android.exoplayer2.Format format) {
        return (format == null || format.label == null || !format.label.contains("VideoPixelFormatHwNotSupported")) ? false : true;
    }

    public static void setSpecialVideoCodecFlag(boolean z_renamed) {
        isSpecialVideoCodec = z_renamed;
    }

    public static boolean isSpecialVideoCodec() {
        return isSpecialVideoCodec;
    }

    public static byte[] getFfmpegCodecParametersData(com.google.android.exoplayer2.Format format) {
        if (isFfmpegExtractor(format) && hasFfmpegCodecParameters(format)) {
            return format.initializationData.get(format.initializationData.size() - 1);
        }
        return null;
    }

    public static com.google.android.exoplayer2.Format maybeRemoveFfmpegCodecParameters(com.google.android.exoplayer2.Format format) {
        if (!isFfmpegExtractor(format) || !hasFfmpegCodecParameters(format)) {
            return format;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(format.initializationData);
        arrayList.remove(format.initializationData.size() - 1);
        return copyWithInitializationData(format, arrayList);
    }

    public static com.google.android.exoplayer2.Format copyWithInitializationData(com.google.android.exoplayer2.Format format, java.util.List<byte[]> list) {
        if (format == null) {
            return format;
        }
        com.google.android.exoplayer2.Format formatCopyWithRotationDegrees = format.copyWithRotationDegrees(format.rotationDegrees);
        com.oplus.tblplayer.utils.ReflectUtil.setField(formatCopyWithRotationDegrees, java.util.List.class, "initializationData", list);
        return formatCopyWithRotationDegrees;
    }

    public static byte[] getFfmpegExtraData(com.google.android.exoplayer2.Format format) {
        int size;
        if (format == null || format.initializationData == null || (size = format.initializationData.size()) == 0) {
            return null;
        }
        if (isFfmpegExtractor(format)) {
            if (isFfmpegExtraDataEmpty(format)) {
                return null;
            }
            size--;
        }
        if (size == 1) {
            return format.initializationData.get(0);
        }
        if (size == 2) {
            byte[] bArr = format.initializationData.get(0);
            byte[] bArr2 = format.initializationData.get(1);
            byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
            bArr3[0] = (byte) (bArr.length >> 8);
            bArr3[1] = (byte) (bArr.length & 255);
            java.lang.System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
            bArr3[bArr.length + 2] = 0;
            bArr3[bArr.length + 3] = 0;
            bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
            bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
            java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
            return bArr3;
        }
        if (size == 3 && format.sampleMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_OPUS)) {
            return format.initializationData.get(0);
        }
        return null;
    }

    public static boolean isVorbisTrack(com.oplus.tblplayer.ffmpeg.Track track) {
        return track != null && track.getType() == 1 && track.getMimeType().equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_VORBIS);
    }

    public static boolean shouldRequireConvert2AnnexB(com.oplus.tblplayer.ffmpeg.Track track) {
        return track != null && track.getType() == 2 && (track.getMimeType().equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265) || track.getMimeType().equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264)) && (track.nalUnitLengthFieldLength == 3 || track.nalUnitLengthFieldLength == 4);
    }

    public static boolean shouldRequireParseConfiguration(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        try {
            boolean z_renamed = true;
            if (parsableByteArray.limit() <= 0 || (parsableByteArray.readUnsignedByte() != 1 && parsableByteArray.readUnsignedByte() != 1)) {
                z_renamed = false;
            }
            parsableByteArray.setPosition(0);
            return z_renamed;
        } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
            throw new com.google.android.exoplayer2.ParserException("Error reading form bytes.", e_renamed);
        }
    }

    protected static java.util.List<byte[]> parseVorbisConfiguration(byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        try {
            if (bArr[0] != 2) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
            }
            int i_renamed = 0;
            int i2 = 1;
            while (bArr[i2] == -1) {
                i_renamed += 255;
                i2++;
            }
            int i3 = i2 + 1;
            int i4 = i_renamed + bArr[i2];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            java.lang.System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            java.lang.System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            java.util.ArrayList arrayList = new java.util.ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
        }
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.i_renamed(str, str2);
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.i_renamed(str, str2, th);
    }

    public static void ifmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        android.util.Log.i_renamed(str, java.lang.String.format(str2, objArr));
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.e_renamed(str, str2);
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.e_renamed(str, str2, th);
    }

    public static java.lang.String getTrackTypeString(int i_renamed) {
        switch (i_renamed) {
            case 0:
                return "default";
            case 1:
                return com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO;
            case 2:
                return "video";
            case 3:
                return com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT;
            case 4:
                return com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_METADATA;
            case 5:
                return "camera motion";
            case 6:
                return "none";
            default:
                if (i_renamed < 10000) {
                    return "?";
                }
                return "custom (" + i_renamed + ")";
        }
    }

    public static void printExtraData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        i_renamed(TAG, com.oplus.tblplayer.utils.ByteUtil.toHexArrayString(bArr, 0, 20));
    }
}
