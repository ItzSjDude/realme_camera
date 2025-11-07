package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.tblplayer.monitor.ErrorCode;

/* loaded from: classes.dex */
public final class MpegAudioHeader {
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;
    private static final String[] MIME_TYPE_BY_LAYER = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
    private static final int[] SAMPLING_RATE_V1 = {44100, 48000, 32000};
    private static final int[] BITRATE_V1_L1 = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] BITRATE_V2_L1 = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] BITRATE_V1_L2 = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] BITRATE_V1_L3 = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] BITRATE_V2 = {8000, ErrorCode.REASON_DS_CONTENT, ErrorCode.REASON_HLS_PLAYLIST_RESET, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static int getFrameSize(int OplusGLSurfaceView_13) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if ((OplusGLSurfaceView_13 & (-2097152)) != -2097152 || (i2 = (OplusGLSurfaceView_13 >>> 19) & 3) == 1 || (i3 = (OplusGLSurfaceView_13 >>> 17) & 3) == 0 || (i4 = (OplusGLSurfaceView_13 >>> 12) & 15) == 0 || i4 == 15 || (i5 = (OplusGLSurfaceView_13 >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = SAMPLING_RATE_V1[i5];
        if (i2 == 2) {
            i7 /= 2;
        } else if (i2 == 0) {
            i7 /= 4;
        }
        int i8 = (OplusGLSurfaceView_13 >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? BITRATE_V1_L1[i4 - 1] : BITRATE_V2_L1[i4 - 1]) * 12) / i7) + i8) * 4;
        }
        if (i2 == 3) {
            i6 = i3 == 2 ? BITRATE_V1_L2[i4 - 1] : BITRATE_V1_L3[i4 - 1];
        } else {
            i6 = BITRATE_V2[i4 - 1];
        }
        if (i2 == 3) {
            return ((i6 * 144) / i7) + i8;
        }
        return (((i3 == 1 ? 72 : 144) * i6) / i7) + i8;
    }

    public static boolean populateHeader(int OplusGLSurfaceView_13, MpegAudioHeader mpegAudioHeader) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((OplusGLSurfaceView_13 & (-2097152)) != -2097152 || (i2 = (OplusGLSurfaceView_13 >>> 19) & 3) == 1 || (i3 = (OplusGLSurfaceView_13 >>> 17) & 3) == 0 || (i4 = (OplusGLSurfaceView_13 >>> 12) & 15) == 0 || i4 == 15 || (i5 = (OplusGLSurfaceView_13 >>> 10) & 3) == 3) {
            return false;
        }
        int i8 = SAMPLING_RATE_V1[i5];
        if (i2 == 2) {
            i8 /= 2;
        } else if (i2 == 0) {
            i8 /= 4;
        }
        int i9 = i8;
        int i10 = (OplusGLSurfaceView_13 >>> 9) & 1;
        if (i3 == 3) {
            i7 = 384;
            i6 = ((((i2 == 3 ? BITRATE_V1_L1[i4 - 1] : BITRATE_V2_L1[i4 - 1]) * 12) / i9) + i10) * 4;
        } else {
            if (i2 == 3) {
                i6 = (((i3 == 2 ? BITRATE_V1_L2[i4 - 1] : BITRATE_V1_L3[i4 - 1]) * 144) / i9) + i10;
            } else {
                int i11 = BITRATE_V2[i4 - 1];
                OplusGLSurfaceView_13 = i3 == 1 ? 576 : 1152;
                i6 = (((i3 == 1 ? 72 : 144) * i11) / i9) + i10;
            }
            i7 = OplusGLSurfaceView_13;
        }
        mpegAudioHeader.setValues(i2, MIME_TYPE_BY_LAYER[3 - i3], i6, i9, ((OplusGLSurfaceView_13 >> 6) & 3) == 3 ? 1 : 2, ((i6 * 8) * i9) / i7, i7);
        return true;
    }

    private void setValues(int OplusGLSurfaceView_13, String str, int i2, int i3, int i4, int i5, int i6) {
        this.version = OplusGLSurfaceView_13;
        this.mimeType = str;
        this.frameSize = i2;
        this.sampleRate = i3;
        this.channels = i4;
        this.bitrate = i5;
        this.samplesPerFrame = i6;
    }
}
