package com.oplus.tblplayer.ffmpeg;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.oplus.tblplayer.utils.ByteUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class FfmpegUtil {
    private static final int AV_SAMPLE_FMT_FLT = 3;
    private static final int AV_SAMPLE_FMT_NONE = -1;
    private static final int AV_SAMPLE_FMT_S16 = 1;
    private static final int AV_SAMPLE_FMT_U8 = 0;
    public static final boolean DEBUG = false;
    private static final String TAG = "FfmpegUtil";
    private static boolean isSpecialVideoCodec;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m25442d(String str, String str2) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m25443d(String str, String str2, Throwable th) {
    }

    public static void dfmt(String str, String str2, Object... objArr) {
    }

    public static String getSeekWhenceString(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 65536 ? "unknown whence" : "AVSEEK_SIZE" : "SEEK_END" : "SEEK_CUR" : "SEEK_SET";
    }

    public static final int pcmEncodingToAVSampleFormat(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 2) {
            return 1;
        }
        if (OplusGLSurfaceView_13 != 3) {
            return OplusGLSurfaceView_13 != 4 ? -1 : 3;
        }
        return 0;
    }

    public static boolean hasFfmpegCodecParameters(Format format) {
        return isFfmpegExtractor(format) && format.initializationData != null && format.initializationData.size() > 0;
    }

    public static boolean isFfmpegExtraDataEmpty(Format format) {
        return hasFfmpegCodecParameters(format) && format.initializationData.size() == 1;
    }

    public static boolean isFfmpegExtractor(Format format) {
        return (format == null || format.label == null || !format.label.contains(FfmpegExtractor.TAG)) ? false : true;
    }

    public static boolean isVideoPixelFormatHwNotSupported(Format format) {
        return (format == null || format.label == null || !format.label.contains("VideoPixelFormatHwNotSupported")) ? false : true;
    }

    public static void setSpecialVideoCodecFlag(boolean z) {
        isSpecialVideoCodec = z;
    }

    public static boolean isSpecialVideoCodec() {
        return isSpecialVideoCodec;
    }

    public static byte[] getFfmpegCodecParametersData(Format format) {
        if (isFfmpegExtractor(format) && hasFfmpegCodecParameters(format)) {
            return format.initializationData.get(format.initializationData.size() - 1);
        }
        return null;
    }

    public static Format maybeRemoveFfmpegCodecParameters(Format format) {
        if (!isFfmpegExtractor(format) || !hasFfmpegCodecParameters(format)) {
            return format;
        }
        ArrayList arrayList = new ArrayList(format.initializationData);
        arrayList.remove(format.initializationData.size() - 1);
        return copyWithInitializationData(format, arrayList);
    }

    public static Format copyWithInitializationData(Format format, List<byte[]> list) {
        if (format == null) {
            return format;
        }
        Format formatCopyWithRotationDegrees = format.copyWithRotationDegrees(format.rotationDegrees);
        ReflectUtil.setField(formatCopyWithRotationDegrees, List.class, "initializationData", list);
        return formatCopyWithRotationDegrees;
    }

    public static byte[] getFfmpegExtraData(Format format) {
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
            System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
            bArr3[bArr.length + 2] = 0;
            bArr3[bArr.length + 3] = 0;
            bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
            bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
            System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
            return bArr3;
        }
        if (size == 3 && format.sampleMimeType.equals(MimeTypes.AUDIO_OPUS)) {
            return format.initializationData.get(0);
        }
        return null;
    }

    public static boolean isVorbisTrack(Track track) {
        return track != null && track.getType() == 1 && track.getMimeType().equals(MimeTypes.AUDIO_VORBIS);
    }

    public static boolean shouldRequireConvert2AnnexB(Track track) {
        return track != null && track.getType() == 2 && (track.getMimeType().equals(MimeTypes.VIDEO_H265) || track.getMimeType().equals(MimeTypes.VIDEO_H264)) && (track.nalUnitLengthFieldLength == 3 || track.nalUnitLengthFieldLength == 4);
    }

    public static boolean shouldRequireParseConfiguration(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            boolean z = true;
            if (parsableByteArray.limit() <= 0 || (parsableByteArray.readUnsignedByte() != 1 && parsableByteArray.readUnsignedByte() != 1)) {
                z = false;
            }
            parsableByteArray.setPosition(0);
            return z;
        } catch (ArrayIndexOutOfBoundsException COUIBaseListPopupWindow_8) {
            throw new ParserException("Error reading form bytes.", COUIBaseListPopupWindow_8);
        }
    }

    protected static List<byte[]> parseVorbisConfiguration(byte[] bArr) throws ParserException {
        try {
            if (bArr[0] != 2) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            int OplusGLSurfaceView_13 = 0;
            int i2 = 1;
            while (bArr[i2] == -1) {
                OplusGLSurfaceView_13 += 255;
                i2++;
            }
            int i3 = i2 + 1;
            int i4 = OplusGLSurfaceView_13 + bArr[i2];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ParserException("Error parsing vorbis codec private");
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m25446i(String str, String str2) {
        Log.OplusGLSurfaceView_13(str, str2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m25447i(String str, String str2, Throwable th) {
        Log.OplusGLSurfaceView_13(str, str2, th);
    }

    public static void ifmt(String str, String str2, Object... objArr) {
        Log.OplusGLSurfaceView_13(str, String.format(str2, objArr));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25444e(String str, String str2) {
        Log.COUIBaseListPopupWindow_8(str, str2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25445e(String str, String str2, Throwable th) {
        Log.COUIBaseListPopupWindow_8(str, str2, th);
    }

    public static String getTrackTypeString(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 0:
                return "default";
            case 1:
                return MimeTypes.BASE_TYPE_AUDIO;
            case 2:
                return "video";
            case 3:
                return MimeTypes.BASE_TYPE_TEXT;
            case 4:
                return TtmlNode.TAG_METADATA;
            case 5:
                return "camera motion";
            case 6:
                return "none";
            default:
                if (OplusGLSurfaceView_13 < 10000) {
                    return "?";
                }
                return "custom (" + OplusGLSurfaceView_13 + ")";
        }
    }

    public static void printExtraData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        m25446i(TAG, ByteUtil.toHexArrayString(bArr, 0, 20));
    }
}
