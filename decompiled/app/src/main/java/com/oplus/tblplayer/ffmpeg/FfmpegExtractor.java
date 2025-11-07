package com.oplus.tblplayer.ffmpeg;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.ColorInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class FfmpegExtractor implements Extractor {
    private static final int AUDIO_PTS_ERR = 1;
    private static final long MAX_PTS_GAP = 8000000;
    private static final int PTS_OK = 0;
    private static final long SEARCH_LENGTH = 4096;
    private static final int STATE_READING_FRAME_DATA = 2;
    private static final int STATE_READING_HEADER = 1;
    public static final String TAG = "FfmpegExtractor";
    private static final int VIDEO_PTS_DOWN_JUMP = 3;
    private static final int VIDEO_PTS_MAX_UP_JUMP_TIMES = 100;
    private static final int VIDEO_PTS_UP_JUMP = 2;
    private ExtractorOutput extractorOutput;
    private boolean needReselectExtractor;
    private boolean pendingExtractorSeek;
    private FfmpegSeekMap seekMap;
    private boolean upstreamKeyframeRequired;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.oplus.tblplayer.ffmpeg.-$$Lambda$FfmpegExtractor$gqGtM-Ydg0fbMHK31H_dqgZS1fs
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FfmpegExtractor.lambda$static$0();
        }
    };
    private static int videoUpJumpTimes = 0;
    private long durationUs = -9223372036854775807L;
    private long lastVideoTimeUs = -9223372036854775807L;
    private long lastVideoFrameDuration = -9223372036854775807L;
    private long lastAudioTimeUs = -9223372036854775807L;
    private int state = 1;
    private final SparseArray<Track> tracks = new SparseArray<>();
    private FfmpegParserJni ffmpegParserJni = new FfmpegParserJni();
    private final ParsableByteArray vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
    private final ParsableByteArray nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    private final ParsableByteArray nalLength = new ParsableByteArray(4);

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FfmpegExtractor()};
    }

    public FfmpegExtractor() {
        this.needReselectExtractor = false;
        this.needReselectExtractor = false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.ffmpegParserJni.init();
        this.extractorOutput = extractorOutput;
        this.state = 1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        long length = extractorInput.getLength();
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int OplusGLSurfaceView_13 = (int) length;
        int iNativeProbePaddingSize = FfmpegParserJni.nativeProbePaddingSize() + OplusGLSurfaceView_13;
        byte[] bArr = new byte[iNativeProbePaddingSize];
        Arrays.fill(bArr, OplusGLSurfaceView_13, iNativeProbePaddingSize, (byte) 0);
        extractorInput.peekFully(bArr, 0, OplusGLSurfaceView_13);
        return this.ffmpegParserJni.sniff(bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long OplusGLSurfaceView_15, long j2) {
        FfmpegUtil.m25442d(TAG, "seek: position = " + OplusGLSurfaceView_15 + ", timeUs = " + j2);
        FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni != null) {
            ffmpegParserJni.seekTo(-1, j2);
            this.pendingExtractorSeek = true;
            this.upstreamKeyframeRequired = true;
            this.lastVideoTimeUs = -9223372036854775807L;
            this.lastAudioTimeUs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        FfmpegUtil.m25442d(TAG, "******* Loadable thread read: input.getPosition = " + extractorInput.getPosition() + ", seekPosition = " + positionHolder.position);
        this.ffmpegParserJni.advance(extractorInput);
        updateSeekMapPosition();
        maybeThrowReadError();
        byte[] frameBuffer = this.ffmpegParserJni.getFrameBuffer();
        if (frameBuffer != null) {
            if (this.state == 1 && !readStreamInfo()) {
                FfmpegUtil.m25444e(TAG, "Ffmpeg extractor get AC4 track,currently not supported,will try exo extractor");
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
        throw new IOException("Invalid data found when processing input.");
    }

    private boolean readSampleData(byte[] bArr) {
        int iProcessErrPts;
        int frameIndex = this.ffmpegParserJni.getFrameIndex();
        long frameTimeUs = this.ffmpegParserJni.getFrameTimeUs();
        boolean zIsKeyFrame = this.ffmpegParserJni.isKeyFrame();
        long frameDuration = this.ffmpegParserJni.getFrameDuration();
        Track track = this.tracks.get(frameIndex);
        if (track != null && track.getType() == 2 && this.upstreamKeyframeRequired) {
            if (zIsKeyFrame) {
                this.upstreamKeyframeRequired = false;
            } else {
                FfmpegUtil.m25442d(TAG, "Continue load samples until read PlatformImplementations.kt_3 key frame.");
                return false;
            }
        }
        if (track == null || (iProcessErrPts = processErrPts(frameTimeUs, frameDuration, track)) == 1) {
            return true;
        }
        try {
            int iWriteSampleData = writeSampleData(track, new ParsableByteArray(bArr));
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
        } catch (ArrayIndexOutOfBoundsException | IllegalStateException COUIBaseListPopupWindow_8) {
            FfmpegUtil.m25445e(TAG, "Caught PlatformImplementations.kt_3 exception at time: " + frameTimeUs + ", read position: " + this.ffmpegParserJni.getCurrentReadPosition(), COUIBaseListPopupWindow_8);
            return true;
        }
    }

    private int processErrPts(long OplusGLSurfaceView_15, long j2, Track track) {
        if (this.tracks.size() > 2) {
            return 0;
        }
        if (track.getType() == 1) {
            long j3 = this.lastAudioTimeUs;
            if (j3 != -9223372036854775807L && OplusGLSurfaceView_15 <= j3) {
                FfmpegUtil.m25442d(TAG, "Ffmpeg extractor will drop rollback audio frame. current: " + OplusGLSurfaceView_15 + ", last: " + this.lastAudioTimeUs);
                return 1;
            }
            this.lastAudioTimeUs = OplusGLSurfaceView_15;
        } else if (track.getType() == 2) {
            long j4 = this.lastVideoTimeUs;
            if (j4 != -9223372036854775807L && j4 > 0 && OplusGLSurfaceView_15 > 0) {
                if (OplusGLSurfaceView_15 > j4 + MAX_PTS_GAP && this.lastVideoFrameDuration < MAX_PTS_GAP) {
                    FfmpegUtil.m25444e(TAG, "Ffmpeg extractor will fix incorrect video up jump frame. current: " + OplusGLSurfaceView_15 + ", last: " + this.lastVideoTimeUs);
                    videoUpJumpTimes = videoUpJumpTimes + 1;
                    this.lastVideoFrameDuration = j2;
                    return 2;
                }
                if (OplusGLSurfaceView_15 < this.lastVideoTimeUs - MAX_PTS_GAP) {
                    FfmpegUtil.m25444e(TAG, "Ffmpeg extractor will fix incorrect video down jump frame. current: " + OplusGLSurfaceView_15 + ", last: " + this.lastVideoTimeUs);
                    this.lastVideoFrameDuration = j2;
                    return 3;
                }
                videoUpJumpTimes = 0;
            }
            this.lastVideoTimeUs = OplusGLSurfaceView_15;
            this.lastVideoFrameDuration = j2;
        }
        return 0;
    }

    private void writeSampleMetadata(Track track, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) {
        track.getTrackOutput().sampleMetadata(OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2, 0, null);
    }

    private int writeSampleData(Track track, ParsableByteArray parsableByteArray) {
        if (FfmpegUtil.shouldRequireConvert2AnnexB(track)) {
            return writeConvertAnnexBSampleData(track, parsableByteArray);
        }
        int iLimit = parsableByteArray.limit();
        TrackOutput trackOutput = track.getTrackOutput();
        trackOutput.sampleData(parsableByteArray, iLimit);
        if (!FfmpegUtil.isVorbisTrack(track)) {
            return iLimit;
        }
        this.vorbisNumPageSamples.setPosition(0);
        trackOutput.sampleData(this.vorbisNumPageSamples, 4);
        return iLimit + 4;
    }

    private int writeConvertAnnexBSampleData(Track track, ParsableByteArray parsableByteArray) {
        TrackOutput trackOutput = track.getTrackOutput();
        byte[] bArr = this.nalLength.data;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int OplusGLSurfaceView_13 = track.nalUnitLengthFieldLength;
        int i2 = 4 - OplusGLSurfaceView_13;
        int i3 = 0;
        while (parsableByteArray.bytesLeft() > 0) {
            parsableByteArray.readBytes(this.nalLength.data, i2, OplusGLSurfaceView_13);
            this.nalLength.setPosition(0);
            int unsignedIntToInt = this.nalLength.readUnsignedIntToInt();
            if (unsignedIntToInt > parsableByteArray.bytesLeft()) {
                throw new ArrayIndexOutOfBoundsException("Write bytes length too large.");
            }
            this.nalStartCode.setPosition(0);
            trackOutput.sampleData(this.nalStartCode, 4);
            trackOutput.sampleData(parsableByteArray, unsignedIntToInt);
            i3 = i3 + 4 + unsignedIntToInt;
        }
        return i3;
    }

    public void maybeThrowReadError() throws InterruptedException, IOException {
        FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni != null) {
            try {
                ffmpegParserJni.maybeThrowReadError();
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw COUIBaseListPopupWindow_8;
            } catch (InterruptedException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public void updateSeekMapPosition() {
        FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni == null || this.state == 1) {
            return;
        }
        this.seekMap.setCurrentPosition(ffmpegParserJni.isEnd() ? 0L : this.ffmpegParserJni.getCurrentReadPosition());
    }

    private boolean readStreamInfo() throws ParserException {
        int trackType;
        int OplusGLSurfaceView_13;
        boolean z;
        int i2;
        boolean z2;
        String str;
        String containerMime = this.ffmpegParserJni.getContainerMime();
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
                        FfmpegUtil.m25442d(TAG, "Ffmpeg extractor readStreamInfo: AC-4 codec_tag");
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
                        FfmpegUtil.m25442d(TAG, "Ffmpeg extractor : video codec need sw decoder.");
                        FfmpegUtil.setSpecialVideoCodecFlag(z4);
                    } else {
                        FfmpegUtil.setSpecialVideoCodecFlag(z3);
                    }
                }
                String trackMime = this.ffmpegParserJni.getTrackMime(i4);
                TrackOutput trackOutputTrack = this.extractorOutput.track(i4, trackType);
                Track track = new Track(i4, trackType, trackMime, trackOutputTrack);
                FfmpegUtil.m25446i(TAG, track.toString());
                this.tracks.put(i4, track);
                long trackDuration = this.ffmpegParserJni.getTrackDuration(i4);
                if (trackDuration != Long.MIN_VALUE) {
                    this.durationUs = Math.max(this.durationUs, trackDuration);
                }
                FfmpegUtil.m25446i(TAG, "trackType: " + trackType + ", tarckduraiton: " + trackDuration + "us, duration: " + this.durationUs + "us");
                track.parseMediaCodecSpecificData(this.ffmpegParserJni.getTrackExtraData(i4));
                track.setTrackCodecParametersData(this.ffmpegParserJni.getTrackCodecParametersData(i4));
                if (trackType == z4) {
                    OplusGLSurfaceView_13 = i4;
                    z = z4;
                    trackOutputTrack.format(Format.createAudioContainerFormat(Integer.toString(i4), TAG, containerMime, trackMime, null, (int) this.ffmpegParserJni.getTrackBitrate(i4), this.ffmpegParserJni.getTrackChannels(i4), this.ffmpegParserJni.getTrackSampleRate(i4), track.initializationData, this.ffmpegParserJni.isDefaultTrack(i4) ? 1 : 0, null));
                } else {
                    OplusGLSurfaceView_13 = i4;
                    z = z4;
                    if (trackType == 2) {
                        i2 = OplusGLSurfaceView_13;
                        int trackVideoWidth = this.ffmpegParserJni.getTrackVideoWidth(i2);
                        int trackVideoHeight = this.ffmpegParserJni.getTrackVideoHeight(i2);
                        float trackVideoFrameRate = this.ffmpegParserJni.getTrackVideoFrameRate(i2);
                        long trackBitrate = this.ffmpegParserJni.getTrackBitrate(i2);
                        int trackVideoRotation = this.ffmpegParserJni.getTrackVideoRotation(i2);
                        float pixelWidthHeightRatio = this.ffmpegParserJni.getPixelWidthHeightRatio(i2);
                        ColorInfo trackVideoColorInfo = this.ffmpegParserJni.getTrackVideoColorInfo(i2);
                        Object[] objArr = new Object[7];
                        z2 = false;
                        objArr[0] = Integer.valueOf(trackVideoWidth);
                        objArr[z ? 1 : 0] = Integer.valueOf(trackVideoHeight);
                        objArr[2] = Float.valueOf(trackVideoFrameRate);
                        objArr[3] = Long.valueOf(trackBitrate);
                        objArr[4] = Integer.valueOf(trackVideoRotation);
                        objArr[5] = Float.valueOf(pixelWidthHeightRatio);
                        objArr[6] = trackVideoColorInfo;
                        FfmpegUtil.dfmt(TAG, "video [resolution: %IntrinsicsJvm.kt_5 x %IntrinsicsJvm.kt_5, frameRate: %COUIBaseListPopupWindow_12, bitrate: %IntrinsicsJvm.kt_5, rotationDegrees: %IntrinsicsJvm.kt_5, pixelWidthAspectRatio: %COUIBaseListPopupWindow_12, colorInfo: %s]", objArr);
                        Format formatCreateVideoSampleFormat = Format.createVideoSampleFormat(Integer.toString(i2), trackMime, null, (int) trackBitrate, -1, trackVideoWidth, trackVideoHeight, trackVideoFrameRate, track.initializationData, trackVideoRotation, pixelWidthHeightRatio, null, -1, trackVideoColorInfo, null);
                        if (this.ffmpegParserJni.isVideoPixelFormatHwSupported()) {
                            str = TAG;
                        } else {
                            str = TAG + ",VideoPixelFormatHwNotSupported";
                        }
                        trackOutputTrack.format(formatCreateVideoSampleFormat.copyWithContainerInfo(formatCreateVideoSampleFormat.f8979id, str, formatCreateVideoSampleFormat.sampleMimeType, formatCreateVideoSampleFormat.codecs, formatCreateVideoSampleFormat.bitrate, formatCreateVideoSampleFormat.width, formatCreateVideoSampleFormat.height, this.ffmpegParserJni.isDefaultTrack(i2) ? 1 : 0, formatCreateVideoSampleFormat.language));
                    }
                }
                i2 = OplusGLSurfaceView_13;
                z2 = false;
            } else {
                i2 = i4;
                z = z4;
                z2 = z3;
            }
            i4 = i2 + 1;
            z3 = z2;
            z4 = z;
        }
        boolean z7 = z4;
        this.extractorOutput.endTracks();
        this.seekMap = new FfmpegSeekMap(this.durationUs, this.ffmpegParserJni);
        this.extractorOutput.seekMap(this.seekMap);
        this.state = 2;
        return z7;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        FfmpegUtil.m25442d(TAG, "release");
        this.ffmpegParserJni.release();
    }

    public static class FfmpegSeekMap implements SeekMap {
        private long durationUs;
        private FfmpegParserJni ffmpegParserJni;
        private long position = 0;

        public FfmpegSeekMap(long OplusGLSurfaceView_15, FfmpegParserJni ffmpegParserJni) {
            this.durationUs = OplusGLSurfaceView_15;
            this.ffmpegParserJni = ffmpegParserJni;
        }

        public void setCurrentPosition(long OplusGLSurfaceView_15) {
            this.position = OplusGLSurfaceView_15;
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
        public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
            return new SeekMap.SeekPoints(new SeekPoint(OplusGLSurfaceView_15, this.position));
        }
    }
}
