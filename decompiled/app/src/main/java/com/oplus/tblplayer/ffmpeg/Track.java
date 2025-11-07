package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class Track {
    private static final java.lang.String TAG = "FfmpegTrack";
    private int index;
    public java.util.List<byte[]> initializationData = new java.util.ArrayList();
    public java.lang.String mimeType;
    public int nalUnitLengthFieldLength;
    private com.google.android.exoplayer2.extractor.TrackOutput trackOutput;
    private int type;

    public Track(int i_renamed, int i2, java.lang.String str, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.index = i_renamed;
        this.type = i2;
        this.mimeType = str;
        this.trackOutput = trackOutput;
    }

    public java.lang.String toString() {
        return "Track {index=" + this.index + ", type=" + com.oplus.tblplayer.ffmpeg.FfmpegUtil.getTrackTypeString(this.type) + ", mimeType=" + this.mimeType + "}";
    }

    public int getIndex() {
        return this.index;
    }

    public int getType() {
        return this.type;
    }

    public java.lang.String getMimeType() {
        return this.mimeType;
    }

    public com.google.android.exoplayer2.extractor.TrackOutput getTrackOutput() {
        return this.trackOutput;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    public void parseMediaCodecSpecificData(byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        if (bArr == null || bArr.length == 0) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.i_renamed(TAG, "Track " + this.mimeType + " extra data is_renamed empty!");
            return;
        }
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.printExtraData(bArr);
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr);
        java.lang.String str = this.mimeType;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1662541442:
                if (str.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1003765268:
                if (str.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_VORBIS)) {
                    c2 = 0;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_OPUS)) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            this.initializationData.addAll(com.oplus.tblplayer.ffmpeg.FfmpegUtil.parseVorbisConfiguration(parsableByteArray.data));
            return;
        }
        if (c2 == 1) {
            this.initializationData.add(bArr);
            this.initializationData.add(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
            this.initializationData.add(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
            return;
        }
        if (c2 == 2) {
            if (com.oplus.tblplayer.ffmpeg.FfmpegUtil.shouldRequireParseConfiguration(parsableByteArray)) {
                com.google.android.exoplayer2.video.HevcConfig hevcConfig = com.google.android.exoplayer2.video.HevcConfig.parse(parsableByteArray);
                this.initializationData.addAll(hevcConfig.initializationData);
                this.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                return;
            }
            this.initializationData.add(parsableByteArray.data);
            return;
        }
        if (c2 == 3) {
            if (com.oplus.tblplayer.ffmpeg.FfmpegUtil.shouldRequireParseConfiguration(parsableByteArray)) {
                com.google.android.exoplayer2.video.AvcConfig avcConfig = com.google.android.exoplayer2.video.AvcConfig.parse(parsableByteArray);
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
