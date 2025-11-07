package com.google.android.exoplayer2.extractor.avi;

/* loaded from: classes.dex */
final class AviAudioCodecReader extends com.google.android.exoplayer2.extractor.avi.AviCodecReader {
    private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int AUDIO_FORMAT_AAC = 10;
    private static final int AUDIO_FORMAT_FLAC = 7;
    private static final int AUDIO_FORMAT_MP3 = 2;
    private static final int AUDIO_FORMAT_WAVE = 11;
    private static final java.lang.String TAG = "AviAudioCodecReader";
    private long averageBitPerSec;
    private long bitPerSecSpec;
    private int channelsNumSpec;
    private long frameCount;
    private long frameDuration;
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;
    private java.lang.String mMimeType;
    public int pcmEncodingType;
    private long playStartTime;
    private long sampleRateSpec;
    private static final int[] AAC_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, com.oplus.tblplayer.monitor.ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_CONTENT, com.oplus.tblplayer.monitor.ErrorCode.REASON_TEE, 11025, 8000, 7350};
    private static final int[][] MPEG_SAMPLE_RATE_TABLE = {new int[]{11025, 0, 22050, 44100}, new int[]{com.oplus.tblplayer.monitor.ErrorCode.REASON_TEE, 0, com.oplus.tblplayer.monitor.ErrorCode.REASON_HLS_PLAYLIST_RESET, 48000}, new int[]{8000, 0, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_CONTENT, 32000}};
    private static final int[][] MPEG_SAMPLE_COUNT_TABLE = {new int[]{0, 0, 0, 0}, new int[]{576, 0, 576, 1152}, new int[]{1152, 0, 1152, 1152}, new int[]{384, 0, 384, 384}};

    public AviAudioCodecReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, java.lang.String str) {
        super(trackOutput);
        this.hasParsedAudioDataHeader = false;
        this.hasOutputFormat = false;
        this.frameDuration = 0L;
        this.frameCount = 0L;
        this.bitPerSecSpec = 0L;
        this.averageBitPerSec = 0L;
        this.sampleRateSpec = 0L;
        this.channelsNumSpec = 0;
        this.playStartTime = 0L;
        this.mMimeType = str;
    }

    public void seek(long j_renamed, long j2) {
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Seek audio internal process to time:" + j2 + "; pos:" + j_renamed);
        this.frameCount = 0L;
        this.playStartTime = j2;
        java.lang.String str = this.mMimeType;
        if (str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG || str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG_L2) {
            return;
        }
        this.frameDuration = 0L;
    }

    public void setPCMEncodingType(int i_renamed) {
        if (i_renamed == 8) {
            this.pcmEncodingType = 3;
            return;
        }
        if (i_renamed == 16) {
            this.pcmEncodingType = 2;
        } else if (i_renamed == 24) {
            this.pcmEncodingType = Integer.MIN_VALUE;
        } else {
            if (i_renamed != 32) {
                return;
            }
            this.pcmEncodingType = 1073741824;
        }
    }

    public void setBitPerSec(long j_renamed) {
        this.bitPerSecSpec = j_renamed;
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Set Audio frame bit per sec :" + j_renamed);
    }

    public void setSampleRate(long j_renamed) {
        this.sampleRateSpec = j_renamed;
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Set Audio frame sample rate :" + j_renamed);
    }

    public void setChannelsNum(int i_renamed) {
        this.channelsNumSpec = i_renamed;
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Set Audio frame channels number :" + i_renamed);
    }

    public void setAverageBitPerSec(long j_renamed) {
        this.averageBitPerSec = j_renamed;
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Set average bit per sec :" + j_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviCodecReader
    protected boolean parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.extractor.avi.AviCodecReader.UnsupportedFormatException {
        int i_renamed;
        int i2;
        int i3;
        int i4;
        if (!this.hasParsedAudioDataHeader) {
            java.lang.String str = this.mMimeType;
            if (str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG || str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG_L2) {
                parsableByteArray.setPosition(1);
                int unsignedByte = parsableByteArray.readUnsignedByte() & 31;
                int i5 = unsignedByte >> 3;
                int i6 = (unsignedByte >> 1) & 3;
                parsableByteArray.setPosition(2);
                int i7 = MPEG_SAMPLE_RATE_TABLE[(parsableByteArray.readUnsignedByte() >> 2) & 3][i5];
                parsableByteArray.setPosition(3);
                int i8 = ((parsableByteArray.readUnsignedByte() >> 6) & 15) == 3 ? 1 : 2;
                this.frameDuration = (MPEG_SAMPLE_COUNT_TABLE[i6][i5] * 1000000) / i7;
                this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, this.mMimeType, null, -1, 4096, i8, i7, null, null, 0, null));
                this.hasOutputFormat = true;
            } else if (str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC) {
                int i9 = 0;
                int[] iArr = {parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedByte()};
                if (iArr[0] == 255 && (iArr[1] & 240) == 240 && (iArr[1] & 6) == 0 && ((iArr[2] >> 2) & 15) < 12 && (iArr[3] & 2) == 0) {
                    i4 = iArr[2] >> 6;
                    int i10 = (iArr[3] >> 6) | ((iArr[2] & 3) << 2);
                    i2 = (iArr[2] >> 2) & 15;
                    i_renamed = AAC_SAMPLING_RATE_TABLE[i2];
                    android.util.Log.d_renamed(TAG, "parseHeader: aacObjectType = " + i4);
                    i3 = i10;
                } else {
                    com.google.android.exoplayer2.util.Log.d_renamed(TAG, "this is_renamed not ADTS AAC, so use avi pre-setting:" + iArr[0] + iArr[1] + iArr[2] + iArr[3]);
                    int i11 = this.channelsNumSpec;
                    i_renamed = (int) this.sampleRateSpec;
                    while (true) {
                        if (i9 >= 13) {
                            i2 = 8;
                            break;
                        }
                        if (AAC_SAMPLING_RATE_TABLE[i9] == i_renamed) {
                            i2 = i9;
                            break;
                        }
                        i9++;
                    }
                    i3 = i11;
                    i4 = 2;
                }
                this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(java.lang.Integer.toString(2), this.mMimeType, null, -1, -1, i3, i_renamed, java.util.Collections.singletonList(com.google.android.exoplayer2.util.CodecSpecificDataUtil.buildAacAudioSpecificConfig(i4, i2, i3)), null, 0, null));
                this.hasOutputFormat = true;
            } else if (str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW) {
                this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, str, null, -1, -1, -1, -1, this.pcmEncodingType, null, null, 0, null));
                this.hasOutputFormat = true;
            } else {
                this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, str, null, -1, -1, -1, -1, -1, null, null, 0, null));
                this.hasOutputFormat = true;
            }
            this.hasParsedAudioDataHeader = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviCodecReader
    protected void parseData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        parsableByteArray.setPosition(0);
        int iBytesLeft = parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, iBytesLeft);
        java.lang.String str = this.mMimeType;
        if (str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG || str == com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG_L2) {
            this.output.sampleMetadata((this.frameDuration * this.frameCount) + this.playStartTime, 1, iBytesLeft, 0, null);
        } else {
            this.output.sampleMetadata(this.frameDuration + this.playStartTime, 1, iBytesLeft, 0, null);
            this.frameDuration += ((iBytesLeft * 8) * 1000000) / this.bitPerSecSpec;
        }
        this.frameCount++;
    }
}
