package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class Track {
    private static final String TAG = "FfmpegTrack";
    private int index;
    public List<byte[]> initializationData = new ArrayList();
    public String mimeType;
    public int nalUnitLengthFieldLength;
    private TrackOutput trackOutput;
    private int type;

    public Track(int OplusGLSurfaceView_13, int i2, String str, TrackOutput trackOutput) {
        this.index = OplusGLSurfaceView_13;
        this.type = i2;
        this.mimeType = str;
        this.trackOutput = trackOutput;
    }

    public String toString() {
        return "Track {index=" + this.index + ", type=" + FfmpegUtil.getTrackTypeString(this.type) + ", mimeType=" + this.mimeType + "}";
    }

    public int getIndex() {
        return this.index;
    }

    public int getType() {
        return this.type;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public TrackOutput getTrackOutput() {
        return this.trackOutput;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    public void parseMediaCodecSpecificData(byte[] bArr) throws ParserException {
        if (bArr == null || bArr.length == 0) {
            FfmpegUtil.m25446i(TAG, "Track " + this.mimeType + " extra data is empty!");
            return;
        }
        FfmpegUtil.printExtraData(bArr);
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        String str = this.mimeType;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1003765268:
                if (str.equals(MimeTypes.AUDIO_VORBIS)) {
                    c2 = 0;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals(MimeTypes.AUDIO_OPUS)) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            this.initializationData.addAll(FfmpegUtil.parseVorbisConfiguration(parsableByteArray.data));
            return;
        }
        if (c2 == 1) {
            this.initializationData.add(bArr);
            this.initializationData.add(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
            this.initializationData.add(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
            return;
        }
        if (c2 == 2) {
            if (FfmpegUtil.shouldRequireParseConfiguration(parsableByteArray)) {
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                this.initializationData.addAll(hevcConfig.initializationData);
                this.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                return;
            }
            this.initializationData.add(parsableByteArray.data);
            return;
        }
        if (c2 == 3) {
            if (FfmpegUtil.shouldRequireParseConfiguration(parsableByteArray)) {
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                this.initializationData = avcConfig.initializationData;
                this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                return;
            }
            this.initializationData.add(parsableByteArray.data);
            return;
        }
        this.initializationData.add(parsableByteArray.data);
    }

    public void setTrackCodecParametersData(byte[] bArr) {
        this.initializationData.add(bArr);
    }
}
