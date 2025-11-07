package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class FfmpegExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    private static final int AUDIO_PTS_ERR = 1;
    private static final long MAX_PTS_GAP = 8000000;
    private static final int PTS_OK = 0;
    private static final long SEARCH_LENGTH = 4096;
    private static final int STATE_READING_FRAME_DATA = 2;
    private static final int STATE_READING_HEADER = 1;
    public static final java.lang.String TAG = "FfmpegExtractor";
    private static final int VIDEO_PTS_DOWN_JUMP = 3;
    private static final int VIDEO_PTS_MAX_UP_JUMP_TIMES = 100;
    private static final int VIDEO_PTS_UP_JUMP = 2;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private boolean needReselectExtractor;
    private boolean pendingExtractorSeek;
    private com.oplus.tblplayer.ffmpeg.FfmpegExtractor.FfmpegSeekMap seekMap;
    private boolean upstreamKeyframeRequired;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.oplus.tblplayer.ffmpeg.-$$Lambda$FfmpegExtractor$gqGtM-Ydg0fbMHK31H_dqgZS1fs
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.oplus.tblplayer.ffmpeg.FfmpegExtractor.lambda$static$0();
        }
    };
    private static int videoUpJumpTimes = 0;
    private long durationUs = -9223372036854775807L;
    private long lastVideoTimeUs = -9223372036854775807L;
    private long lastVideoFrameDuration = -9223372036854775807L;
    private long lastAudioTimeUs = -9223372036854775807L;
    private int state = 1;
    private final android.util.SparseArray<com.oplus.tblplayer.ffmpeg.Track> tracks = new android.util.SparseArray<>();
    private com.oplus.tblplayer.ffmpeg.FfmpegParserJni ffmpegParserJni = new com.oplus.tblplayer.ffmpeg.FfmpegParserJni();
    private final com.google.android.exoplayer2.util.ParsableByteArray vorbisNumPageSamples = new com.google.android.exoplayer2.util.ParsableByteArray(java.nio.ByteBuffer.allocate(4).putInt(-1).array());
    private final com.google.android.exoplayer2.util.ParsableByteArray nalStartCode = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
    private final com.google.android.exoplayer2.util.ParsableByteArray nalLength = new com.google.android.exoplayer2.util.ParsableByteArray(4);

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.oplus.tblplayer.ffmpeg.FfmpegExtractor()};
    }

    public FfmpegExtractor() {
        this.needReselectExtractor = false;
        this.needReselectExtractor = false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.ffmpegParserJni.init();
        this.extractorOutput = extractorOutput;
        this.state = 1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        long length = extractorInput.getLength();
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int i_renamed = (int) length;
        int iNativeProbePaddingSize = com.oplus.tblplayer.ffmpeg.FfmpegParserJni.nativeProbePaddingSize() + i_renamed;
        byte[] bArr = new byte[iNativeProbePaddingSize];
        java.util.Arrays.fill(bArr, i_renamed, iNativeProbePaddingSize, (byte) 0);
        extractorInput.peekFully(bArr, 0, i_renamed);
        return this.ffmpegParserJni.sniff(bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "seek: position = " + j_renamed + ", timeUs = " + j2);
        com.oplus.tblplayer.ffmpeg.FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni != null) {
            ffmpegParserJni.seekTo(-1, j2);
            this.pendingExtractorSeek = true;
            this.upstreamKeyframeRequired = true;
            this.lastVideoTimeUs = -9223372036854775807L;
            this.lastAudioTimeUs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "******* Loadable thread read: input.getPosition = " + extractorInput.getPosition() + ", seekPosition = " + positionHolder.position);
        this.ffmpegParserJni.advance(extractorInput);
        updateSeekMapPosition();
        maybeThrowReadError();
        byte[] frameBuffer = this.ffmpegParserJni.getFrameBuffer();
        if (frameBuffer != null) {
            if (this.state == 1 && !readStreamInfo()) {
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.e_renamed(TAG, "Ffmpeg extractor get AC4 track,currently not supported,will try exo extractor");
                return 2;
            }
            if (!readSampleData(frameBuffer) || !this.pendingExtractorSeek) {
                return 0;
            }
            positionHolder.position = this.ffmpegParserJni.getCurrentReadPosition();
            this.pendingExtractorSeek = false;
            return 1;
        }
        if (this.state != 1) {
            return -1;
        }
        throw new java.io.IOException("Invalid data found when processing input.");
    }

    private boolean readSampleData(byte[] bArr) {
        int iProcessErrPts;
        int frameIndex = this.ffmpegParserJni.getFrameIndex();
        long frameTimeUs = this.ffmpegParserJni.getFrameTimeUs();
        boolean zIsKeyFrame = this.ffmpegParserJni.isKeyFrame();
        long frameDuration = this.ffmpegParserJni.getFrameDuration();
        com.oplus.tblplayer.ffmpeg.Track track = this.tracks.get(frameIndex);
        if (track != null && track.getType() == 2 && this.upstreamKeyframeRequired) {
            if (zIsKeyFrame) {
                this.upstreamKeyframeRequired = false;
            } else {
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "Continue load samples until read a_renamed key frame.");
                return false;
            }
        }
        if (track == null || (iProcessErrPts = processErrPts(frameTimeUs, frameDuration, track)) == 1) {
            return true;
        }
        try {
            int iWriteSampleData = writeSampleData(track, new com.google.android.exoplayer2.util.ParsableByteArray(bArr));
            if (iProcessErrPts == 2) {
                frameTimeUs = this.lastVideoTimeUs + frameDuration;
                if (videoUpJumpTimes > 100) {
                    videoUpJumpTimes = 0;
                    this.lastVideoTimeUs = this.ffmpegParserJni.getFrameTimeUs();
                } else {
                    this.lastVideoTimeUs = frameTimeUs;
                }
            } else if (iProcessErrPts == 3) {
                videoUpJumpTimes = 0;
                this.lastVideoTimeUs = frameTimeUs;
            }
            writeSampleMetadata(track, frameTimeUs, zIsKeyFrame ? 1 : 0, iWriteSampleData);
            return true;
        } catch (java.lang.ArrayIndexOutOfBoundsException | java.lang.IllegalStateException e_renamed) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.e_renamed(TAG, "Caught a_renamed exception at_renamed time: " + frameTimeUs + ", read position: " + this.ffmpegParserJni.getCurrentReadPosition(), e_renamed);
            return true;
        }
    }

    private int processErrPts(long j_renamed, long j2, com.oplus.tblplayer.ffmpeg.Track track) {
        if (this.tracks.size() > 2) {
            return 0;
        }
        if (track.getType() == 1) {
            long j3 = this.lastAudioTimeUs;
            if (j3 != -9223372036854775807L && j_renamed <= j3) {
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "Ffmpeg extractor will drop rollback audio frame. current: " + j_renamed + ", last: " + this.lastAudioTimeUs);
                return 1;
            }
            this.lastAudioTimeUs = j_renamed;
        } else if (track.getType() == 2) {
            long j4 = this.lastVideoTimeUs;
            if (j4 != -9223372036854775807L && j4 > 0 && j_renamed > 0) {
                if (j_renamed > j4 + MAX_PTS_GAP && this.lastVideoFrameDuration < MAX_PTS_GAP) {
                    com.oplus.tblplayer.ffmpeg.FfmpegUtil.e_renamed(TAG, "Ffmpeg extractor will fix incorrect video up_renamed jump frame. current: " + j_renamed + ", last: " + this.lastVideoTimeUs);
                    videoUpJumpTimes = videoUpJumpTimes + 1;
                    this.lastVideoFrameDuration = j2;
                    return 2;
                }
                if (j_renamed < this.lastVideoTimeUs - MAX_PTS_GAP) {
                    com.oplus.tblplayer.ffmpeg.FfmpegUtil.e_renamed(TAG, "Ffmpeg extractor will fix incorrect video down jump frame. current: " + j_renamed + ", last: " + this.lastVideoTimeUs);
                    this.lastVideoFrameDuration = j2;
                    return 3;
                }
                videoUpJumpTimes = 0;
            }
            this.lastVideoTimeUs = j_renamed;
            this.lastVideoFrameDuration = j2;
        }
        return 0;
    }

    private void writeSampleMetadata(com.oplus.tblplayer.ffmpeg.Track track, long j_renamed, int i_renamed, int i2) {
        track.getTrackOutput().sampleMetadata(j_renamed, i_renamed, i2, 0, null);
    }

    private int writeSampleData(com.oplus.tblplayer.ffmpeg.Track track, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (com.oplus.tblplayer.ffmpeg.FfmpegUtil.shouldRequireConvert2AnnexB(track)) {
            return writeConvertAnnexBSampleData(track, parsableByteArray);
        }
        int iLimit = parsableByteArray.limit();
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = track.getTrackOutput();
        trackOutput.sampleData(parsableByteArray, iLimit);
        if (!com.oplus.tblplayer.ffmpeg.FfmpegUtil.isVorbisTrack(track)) {
            return iLimit;
        }
        this.vorbisNumPageSamples.setPosition(0);
        trackOutput.sampleData(this.vorbisNumPageSamples, 4);
        return iLimit + 4;
    }

    private int writeConvertAnnexBSampleData(com.oplus.tblplayer.ffmpeg.Track track, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = track.getTrackOutput();
        byte[] bArr = this.nalLength.data;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int i_renamed = track.nalUnitLengthFieldLength;
        int i2 = 4 - i_renamed;
        int i3 = 0;
        while (parsableByteArray.bytesLeft() > 0) {
            parsableByteArray.readBytes(this.nalLength.data, i2, i_renamed);
            this.nalLength.setPosition(0);
            int unsignedIntToInt = this.nalLength.readUnsignedIntToInt();
            if (unsignedIntToInt > parsableByteArray.bytesLeft()) {
                throw new java.lang.ArrayIndexOutOfBoundsException("Write bytes length too large.");
            }
            this.nalStartCode.setPosition(0);
            trackOutput.sampleData(this.nalStartCode, 4);
            trackOutput.sampleData(parsableByteArray, unsignedIntToInt);
            i3 = i3 + 4 + unsignedIntToInt;
        }
        return i3;
    }

    public void maybeThrowReadError() throws java.lang.InterruptedException, java.io.IOException {
        com.oplus.tblplayer.ffmpeg.FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni != null) {
            try {
                ffmpegParserJni.maybeThrowReadError();
            } catch (java.io.IOException e_renamed) {
                throw e_renamed;
            } catch (java.lang.InterruptedException e2) {
                throw e2;
            } catch (java.lang.Throwable th) {
                throw new java.lang.RuntimeException(th);
            }
        }
    }

    public void updateSeekMapPosition() {
        com.oplus.tblplayer.ffmpeg.FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni == null || this.state == 1) {
            return;
        }
        this.seekMap.setCurrentPosition(ffmpegParserJni.isEnd() ? 0L : this.ffmpegParserJni.getCurrentReadPosition());
    }

    private boolean readStreamInfo() throws com.google.android.exoplayer2.ParserException {
        int trackType;
        int i_renamed;
        boolean z_renamed;
        int i2;
        boolean z2;
        java.lang.String str;
        java.lang.String containerMime = this.ffmpegParserJni.getContainerMime();
        int trackCount = this.ffmpegParserJni.getTrackCount();
        this.durationUs = this.ffmpegParserJni.getDuration();
        boolean z3 = false;
        boolean z4 = true;
        if (!this.needReselectExtractor) {
            int i3 = 0;
            boolean z5 = false;
            boolean z6 = false;
            while (i3 < trackCount) {
                if (!this.ffmpegParserJni.isCoverTrack(i3)) {
                    if (this.ffmpegParserJni.getTrackCodecTag(i3) != null && this.ffmpegParserJni.getTrackCodecTag(i3).toUpperCase().contains("AC-4")) {
                        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "Ffmpeg extractor readStreamInfo: AC-4 codec_tag");
                        this.needReselectExtractor = true;
                        return false;
                    }
                    int trackType2 = this.ffmpegParserJni.getTrackType(i3);
                    if (trackType2 == -1 && this.ffmpegParserJni.getTrackMime(i3) != null && this.ffmpegParserJni.getTrackMime(i3).contains("unknown/bin-data")) {
                        z5 = true;
                    } else if (trackType2 == 1) {
                        z6 = true;
                    }
                }
                i3++;
                z5 = z5;
                z6 = z6;
            }
            if (z5 && !z6) {
                this.needReselectExtractor = true;
                return false;
            }
        }
        int i4 = 0;
        while (i4 < trackCount) {
            if (!this.ffmpegParserJni.isCoverTrack(i4) && ((trackType = this.ffmpegParserJni.getTrackType(i4)) == z4 || trackType == 2)) {
                if (trackType == 2 && this.ffmpegParserJni.getTrackCodecTag(i4) != null) {
                    if (this.ffmpegParserJni.getTrackCodecTag(i4).toUpperCase().contains("XVID") || this.ffmpegParserJni.getTrackCodecTag(i4).toUpperCase().contains("DIVX") || this.ffmpegParserJni.getTrackCodecTag(i4).toUpperCase().contains("DX50")) {
                        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "Ffmpeg extractor : video codec need sw decoder.");
                        com.oplus.tblplayer.ffmpeg.FfmpegUtil.setSpecialVideoCodecFlag(z4);
                    } else {
                        com.oplus.tblplayer.ffmpeg.FfmpegUtil.setSpecialVideoCodecFlag(z3);
                    }
                }
                java.lang.String trackMime = this.ffmpegParserJni.getTrackMime(i4);
                com.google.android.exoplayer2.extractor.TrackOutput trackOutputTrack = this.extractorOutput.track(i4, trackType);
                com.oplus.tblplayer.ffmpeg.Track track = new com.oplus.tblplayer.ffmpeg.Track(i4, trackType, trackMime, trackOutputTrack);
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.i_renamed(TAG, track.toString());
                this.tracks.put(i4, track);
                long trackDuration = this.ffmpegParserJni.getTrackDuration(i4);
                if (trackDuration != Long.MIN_VALUE) {
                    this.durationUs = java.lang.Math.max(this.durationUs, trackDuration);
                }
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.i_renamed(TAG, "trackType: " + trackType + ", tarckduraiton: " + trackDuration + "us, duration: " + this.durationUs + "us");
                track.parseMediaCodecSpecificData(this.ffmpegParserJni.getTrackExtraData(i4));
                track.setTrackCodecParametersData(this.ffmpegParserJni.getTrackCodecParametersData(i4));
                if (trackType == z4) {
                    i_renamed = i4;
                    z_renamed = z4;
                    trackOutputTrack.format(com.google.android.exoplayer2.Format.createAudioContainerFormat(java.lang.Integer.toString(i4), TAG, containerMime, trackMime, null, (int) this.ffmpegParserJni.getTrackBitrate(i4), this.ffmpegParserJni.getTrackChannels(i4), this.ffmpegParserJni.getTrackSampleRate(i4), track.initializationData, this.ffmpegParserJni.isDefaultTrack(i4) ? 1 : 0, null));
                } else {
                    i_renamed = i4;
                    z_renamed = z4;
                    if (trackType == 2) {
                        i2 = i_renamed;
                        int trackVideoWidth = this.ffmpegParserJni.getTrackVideoWidth(i2);
                        int trackVideoHeight = this.ffmpegParserJni.getTrackVideoHeight(i2);
                        float trackVideoFrameRate = this.ffmpegParserJni.getTrackVideoFrameRate(i2);
                        long trackBitrate = this.ffmpegParserJni.getTrackBitrate(i2);
                        int trackVideoRotation = this.ffmpegParserJni.getTrackVideoRotation(i2);
                        float pixelWidthHeightRatio = this.ffmpegParserJni.getPixelWidthHeightRatio(i2);
                        com.google.android.exoplayer2.video.ColorInfo trackVideoColorInfo = this.ffmpegParserJni.getTrackVideoColorInfo(i2);
                        java.lang.Object[] objArr = new java.lang.Object[7];
                        z2 = false;
                        objArr[0] = java.lang.Integer.valueOf(trackVideoWidth);
                        objArr[z_renamed ? 1 : 0] = java.lang.Integer.valueOf(trackVideoHeight);
                        objArr[2] = java.lang.Float.valueOf(trackVideoFrameRate);
                        objArr[3] = java.lang.Long.valueOf(trackBitrate);
                        objArr[4] = java.lang.Integer.valueOf(trackVideoRotation);
                        objArr[5] = java.lang.Float.valueOf(pixelWidthHeightRatio);
                        objArr[6] = trackVideoColorInfo;
                        com.oplus.tblplayer.ffmpeg.FfmpegUtil.dfmt(TAG, "video [resolution: %d_renamed x_renamed %d_renamed, frameRate: %f_renamed, bitrate: %d_renamed, rotationDegrees: %d_renamed, pixelWidthAspectRatio: %f_renamed, colorInfo: %s_renamed]", objArr);
                        com.google.android.exoplayer2.Format formatCreateVideoSampleFormat = com.google.android.exoplayer2.Format.createVideoSampleFormat(java.lang.Integer.toString(i2), trackMime, null, (int) trackBitrate, -1, trackVideoWidth, trackVideoHeight, trackVideoFrameRate, track.initializationData, trackVideoRotation, pixelWidthHeightRatio, null, -1, trackVideoColorInfo, null);
                        if (this.ffmpegParserJni.isVideoPixelFormatHwSupported()) {
                            str = TAG;
                        } else {
                            str = TAG + ",VideoPixelFormatHwNotSupported";
                        }
                        trackOutputTrack.format(formatCreateVideoSampleFormat.copyWithContainerInfo(formatCreateVideoSampleFormat.id_renamed, str, formatCreateVideoSampleFormat.sampleMimeType, formatCreateVideoSampleFormat.codecs, formatCreateVideoSampleFormat.bitrate, formatCreateVideoSampleFormat.width, formatCreateVideoSampleFormat.height, this.ffmpegParserJni.isDefaultTrack(i2) ? 1 : 0, formatCreateVideoSampleFormat.language));
                    }
                }
                i2 = i_renamed;
                z2 = false;
            } else {
                i2 = i4;
                z_renamed = z4;
                z2 = z3;
            }
            i4 = i2 + 1;
            z3 = z2;
            z4 = z_renamed;
        }
        boolean z7 = z4;
        this.extractorOutput.endTracks();
        this.seekMap = new com.oplus.tblplayer.ffmpeg.FfmpegExtractor.FfmpegSeekMap(this.durationUs, this.ffmpegParserJni);
        this.extractorOutput.seekMap(this.seekMap);
        this.state = 2;
        return z7;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "release");
        this.ffmpegParserJni.release();
    }

    public static class FfmpegSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
        private long durationUs;
        private com.oplus.tblplayer.ffmpeg.FfmpegParserJni ffmpegParserJni;
        private long position = 0;

        public FfmpegSeekMap(long j_renamed, com.oplus.tblplayer.ffmpeg.FfmpegParserJni ffmpegParserJni) {
            this.durationUs = j_renamed;
            this.ffmpegParserJni = ffmpegParserJni;
        }

        public void setCurrentPosition(long j_renamed) {
            this.position = j_renamed;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return this.ffmpegParserJni.isSeekable();
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(j_renamed, this.position));
        }
    }
}
