package com.google.android.exoplayer2.extractor.avi;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.ocs.camera.CameraParameter;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AviExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.avi.-$$Lambda$AviExtractor$F542WxF9leWTgMzxAlUZN0u1pZk
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return AviExtractor.lambda$static$0();
        }
    };
    private static final int MAX_AUDIO_STREAM_NUM = 36;
    private static final int STATE_READING_AVI_HEADER = 1;
    private static final int STATE_READING_INFO_LIST = 2;
    private static final int STATE_READING_MOVI_DATA = 3;
    private static final int STREAM_TYPE_AUDIO = 8;
    private static final int STREAM_TYPE_SCRIPT_DATA = 18;
    private static final int STREAM_TYPE_VIDEO = 9;
    private static final String TAG = "AviUtils";
    private static final int ashLen = 26;
    private static final int aviEHLen = 256;
    private static final int aviMHLen = 64;
    private static final int aviSHLen = 64;
    private static long fileLen = 0;
    private static long hdrlLen = 0;
    private static final int vshLen = 48;
    AudioStreamHeader aSH;
    private AviAudioCodecReader audioReader;
    ArrayList<Long> audioSeekSizeList;
    AviExtHeader aviEH;
    AviMainHeader aviMH;
    ArrayList<AviStreamHeader> aviSH;
    AviStreamHeader aviSHTMP;
    private long dataChunkOffset;
    private Uri defaultUri;
    private ExtractorOutput extractorOutput;
    ArrayList<Integer> keyFrameNumList;
    private int mapFrameCount;
    private long moviLen;
    private int parserState;
    public ChunkIndex seekIdx;
    private int streamNum;
    VideoStreamHeader vSH;
    private long videoFrameCount;
    private AviVideoCodecReader videoReader;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new AviExtractor()};
    }

    class AviMainHeader {
        public long Flags;
        public long Height;
        public long InitialFrames;
        public long MaxBytesPerSec;
        public long MicroSecPerFrame;
        public long PaddingGranularity;
        public long[] Reserved = new long[4];
        public long Streams;
        public long SuggestedBufferSize;
        public long TotalFrames;
        public long Width;

        /* renamed from: cb */
        public long f8985cb;
        public long fcc;

        AviMainHeader() {
        }
    }

    class AviExtHeader {
        public int[] Future = new int[61];
        public int GrandFrames;

        /* renamed from: cb */
        public int f8984cb;
        public int fcc;

        AviExtHeader() {
        }
    }

    class AviStreamHeader {
        public long Flags;
        public long InitialFrames;
        public int Language;
        public long Length;
        public int Priority;
        public long Quality;
        public long Rate;
        public short RcFrameBottom;
        public short RcFrameLeft;
        public short RcFrameRight;
        public short RcFrameTop;
        public long SampleSize;
        public long Scale;
        public long Start;
        public long SuggestedBufferSize;

        /* renamed from: cb */
        public long f8986cb;
        public long fcc;
        public long fccHandler;
        public long fccType;

        AviStreamHeader() {
        }
    }

    class VideoStreamHeader {
        public int biBitCount;
        public long biClrImportant;
        public long biClrUsed;
        public long biCompression;
        public long biHeight;
        public int biPlanes;
        public long biSize;
        public long biSizeImage;
        public long biWidth;
        public long biXPelsPerMeter;
        public long biYPelsPerMeter;

        /* renamed from: cb */
        public long f8987cb;
        public long fcc;

        VideoStreamHeader() {
        }
    }

    class AudioStreamHeader {

        /* renamed from: cb */
        public long f8983cb;
        public int cbSize;
        public long fcc;
        public long nAvgBytesPerSec;
        public int nBlockAlign;
        public int nChannels;
        public long nSamplesPerSec;
        public int wBitsPerSample;
        public int wFormatTag;

        AudioStreamHeader() {
        }
    }

    public AviExtractor() {
        this.streamNum = 0;
        this.aviSH = new ArrayList<>();
        this.mapFrameCount = 0;
        this.videoFrameCount = 0L;
        this.keyFrameNumList = new ArrayList<>();
        this.seekIdx = null;
        this.audioSeekSizeList = new ArrayList<>();
        this.defaultUri = null;
    }

    public AviExtractor(Uri uri) {
        this.streamNum = 0;
        this.aviSH = new ArrayList<>();
        this.mapFrameCount = 0;
        this.videoFrameCount = 0L;
        this.keyFrameNumList = new ArrayList<>();
        this.seekIdx = null;
        this.audioSeekSizeList = new ArrayList<>();
        this.defaultUri = null;
        if (Util.isLocalFileUri(uri)) {
            this.defaultUri = uri;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        return PeekHeader(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long OplusGLSurfaceView_15, long j2) {
        long j3;
        if (OplusGLSurfaceView_15 == 0) {
            this.parserState = 1;
            return;
        }
        int chunkIndex = 0;
        ChunkIndex chunkIndex2 = this.seekIdx;
        if (chunkIndex2 != null) {
            chunkIndex = chunkIndex2.getChunkIndex(j2);
            long j4 = this.seekIdx.timesUs[chunkIndex];
            Log.m8318d(TAG, "Adjust seek time position:" + j2);
            if (this.aSH.wFormatTag == 80 || this.aSH.wFormatTag == 85 || this.aSH.nAvgBytesPerSec == 0) {
                j2 = j4;
                j3 = j2;
            } else {
                j2 = (this.audioSeekSizeList.get(chunkIndex).longValue() * 1000000) / this.aSH.nAvgBytesPerSec;
                j3 = j4;
            }
        } else {
            j3 = j2;
        }
        if (this.videoReader != null) {
            this.videoReader.seek(OplusGLSurfaceView_15, j3, this.keyFrameNumList.get(chunkIndex).intValue());
        }
        AviAudioCodecReader aviAudioCodecReader = this.audioReader;
        if (aviAudioCodecReader != null) {
            aviAudioCodecReader.seek(OplusGLSurfaceView_15, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        while (true) {
            int OplusGLSurfaceView_13 = this.parserState;
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 != 2) {
                    if (OplusGLSurfaceView_13 == 3) {
                        return ReadMoviData(extractorInput) ? 0 : -1;
                    }
                    throw new IllegalStateException();
                }
                if (!ReadAviInfoHeader(extractorInput)) {
                    return -1;
                }
                this.parserState = 3;
            } else {
                if (!ReadAviHeader(extractorInput)) {
                    return -1;
                }
                this.parserState = 2;
            }
        }
    }

    public static String MapCodecTypeToMimeType(int OplusGLSurfaceView_13, int i2, short s) {
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 1) {
                return null;
            }
            if (s == 1) {
                return MimeTypes.AUDIO_RAW;
            }
            if (s == 80) {
                return MimeTypes.AUDIO_MPEG_L2;
            }
            if (s == 85) {
                return MimeTypes.AUDIO_MPEG;
            }
            if (s == 87) {
                return MimeTypes.AUDIO_AMR_NB;
            }
            if (s == 88) {
                return MimeTypes.AUDIO_AMR_WB;
            }
            if (s == 22127 || s == 26447 || s == 26448 || s == 26449) {
                return MimeTypes.AUDIO_VORBIS;
            }
            if (s == 255) {
                return MimeTypes.AUDIO_AAC;
            }
            return null;
        }
        if (Util.getIntegerCodeForString("XVID") == i2 || Util.getIntegerCodeForString("Xvid") == i2 || Util.getIntegerCodeForString("xvid") == i2 || Util.getIntegerCodeForString("XVIX") == i2 || Util.getIntegerCodeForString("3IV2") == i2 || Util.getIntegerCodeForString("3iv2") == i2 || Util.getIntegerCodeForString("DIV1") == i2 || Util.getIntegerCodeForString("div1") == i2 || Util.getIntegerCodeForString("DIVX") == i2 || Util.getIntegerCodeForString("divx") == i2 || Util.getIntegerCodeForString("DX50") == i2 || Util.getIntegerCodeForString("dx50") == i2 || Util.getIntegerCodeForString("DXGM") == i2 || Util.getIntegerCodeForString("EM4A") == i2 || Util.getIntegerCodeForString("EPHV") == i2 || Util.getIntegerCodeForString("FMP4") == i2 || Util.getIntegerCodeForString("fmp4") == i2 || Util.getIntegerCodeForString("FVFW") == i2 || Util.getIntegerCodeForString("HDX4") == i2 || Util.getIntegerCodeForString("hdx4") == i2 || Util.getIntegerCodeForString("M4CC") == i2 || Util.getIntegerCodeForString("M4S2") == i2 || Util.getIntegerCodeForString("m4s2") == i2 || Util.getIntegerCodeForString("MP4S") == i2 || Util.getIntegerCodeForString("mp4s") == i2 || Util.getIntegerCodeForString("MP4V") == i2 || Util.getIntegerCodeForString("mp4v") == i2 || Util.getIntegerCodeForString("RMP4") == i2 || Util.getIntegerCodeForString("SMP4") == i2 || Util.getIntegerCodeForString("UMP4") == i2 || Util.getIntegerCodeForString("WV1F") == i2) {
            Log.m8318d("HeyTap Player", "this is mpeg4v codec :" + i2);
            return MimeTypes.VIDEO_MP4V;
        }
        if (Util.getIntegerCodeForString("avc1") != i2 && Util.getIntegerCodeForString("davc") != i2 && Util.getIntegerCodeForString("x264") != i2 && Util.getIntegerCodeForString(CameraParameter.VideoEncoder.H264) != i2 && Util.getIntegerCodeForString("vssh") != i2) {
            return "video";
        }
        Log.m8318d("HeyTap Player", "this is h264 codec :" + i2);
        return MimeTypes.VIDEO_H264;
    }

    public static short getShortCodeForString(String str) {
        int length = str.length();
        Assertions.checkArgument(length <= 2);
        short sCharAt = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            sCharAt = (short) (((short) (sCharAt << 8)) | str.charAt(OplusGLSurfaceView_13));
        }
        return sCharAt;
    }

    public boolean PeekHeader(ExtractorInput extractorInput) throws InterruptedException, IOException {
        Assertions.checkNotNull(extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(12);
        extractorInput.peekFully(parsableByteArray.data, 0, 8);
        parsableByteArray.setPosition(0);
        int OplusGLSurfaceView_13 = parsableByteArray.readInt();
        fileLen = parsableByteArray.readLittleEndianUnsignedInt();
        if (OplusGLSurfaceView_13 != Util.getIntegerCodeForString("RIFF")) {
            Log.m8320e(TAG, "this is not RIFF format");
            return false;
        }
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int i2 = parsableByteArray.readInt();
        if (i2 != Util.getIntegerCodeForString("AVI ")) {
            Log.m8320e(TAG, "Unsupported RIFF format: " + i2);
            return false;
        }
        extractorInput.peekFully(parsableByteArray.data, 0, 12);
        parsableByteArray.setPosition(0);
        parsableByteArray.readInt();
        hdrlLen = parsableByteArray.readLittleEndianUnsignedInt();
        if (parsableByteArray.readInt() == Util.getIntegerCodeForString("hdrl")) {
            return true;
        }
        Log.m8320e(TAG, "There is no HDRL info");
        return false;
    }

    public boolean ReadAviHeader(ExtractorInput extractorInput) throws InterruptedException, IOException {
        extractorInput.skipFully(24);
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        if (!extractorInput.readFully(parsableByteArray.data, 0, 64, true)) {
            return false;
        }
        parsableByteArray.setPosition(0);
        this.aviMH = new AviMainHeader();
        this.aviMH.fcc = parsableByteArray.readUnsignedInt();
        this.aviMH.f8985cb = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.MicroSecPerFrame = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.MaxBytesPerSec = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.PaddingGranularity = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Flags = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.TotalFrames = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Streams = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.SuggestedBufferSize = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Width = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Height = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Reserved[0] = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Reserved[1] = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Reserved[2] = parsableByteArray.readLittleEndianUnsignedInt();
        this.aviMH.Reserved[3] = parsableByteArray.readLittleEndianUnsignedInt();
        if (this.aviMH.Streams > 36) {
            Log.m8320e(TAG, "Media track number more than 36!! Let's fix it");
            return false;
        }
        long position = extractorInput.getPosition();
        while (position < hdrlLen + 8 + 12) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(12);
            if (!extractorInput.readFully(parsableByteArray2.data, 0, 12, true)) {
                return false;
            }
            parsableByteArray2.setPosition(0);
            if (parsableByteArray2.readUnsignedInt() == Util.getIntegerCodeForString("LIST")) {
                parsableByteArray2.setPosition(8);
                if (parsableByteArray2.readUnsignedInt() == Util.getIntegerCodeForString("strl")) {
                    ParsableByteArray parsableByteArray3 = new ParsableByteArray(64);
                    if (!extractorInput.readFully(parsableByteArray3.data, 0, 64, true)) {
                        return false;
                    }
                    parsableByteArray3.setPosition(0);
                    this.aviSHTMP = new AviStreamHeader();
                    this.aviSHTMP.fcc = parsableByteArray3.readUnsignedInt();
                    this.aviSHTMP.f8986cb = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.fccType = parsableByteArray3.readUnsignedInt();
                    this.aviSHTMP.fccHandler = parsableByteArray3.readUnsignedInt();
                    this.aviSHTMP.Flags = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.Priority = parsableByteArray3.readLittleEndianUnsignedShort();
                    this.aviSHTMP.Language = parsableByteArray3.readLittleEndianUnsignedShort();
                    this.aviSHTMP.InitialFrames = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.Scale = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.Rate = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.Start = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.Length = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.SuggestedBufferSize = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.Quality = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.SampleSize = parsableByteArray3.readLittleEndianUnsignedInt();
                    this.aviSHTMP.RcFrameLeft = parsableByteArray3.readLittleEndianShort();
                    this.aviSHTMP.RcFrameTop = parsableByteArray3.readLittleEndianShort();
                    this.aviSHTMP.RcFrameRight = parsableByteArray3.readLittleEndianShort();
                    this.aviSHTMP.RcFrameBottom = parsableByteArray3.readLittleEndianShort();
                    this.aviSH.add(this.aviSHTMP);
                    if (this.aviSHTMP.fccType == Util.getIntegerCodeForString("vids")) {
                        ParsableByteArray parsableByteArray4 = new ParsableByteArray(8);
                        if (!extractorInput.readFully(parsableByteArray4.data, 0, 8, true)) {
                            return false;
                        }
                        parsableByteArray4.setPosition(0);
                        this.vSH = new VideoStreamHeader();
                        this.vSH.fcc = parsableByteArray4.readUnsignedInt();
                        this.vSH.f8987cb = parsableByteArray4.readLittleEndianUnsignedInt();
                        ParsableByteArray parsableByteArray5 = new ParsableByteArray((int) this.vSH.f8987cb);
                        if (!extractorInput.readFully(parsableByteArray5.data, 0, (int) this.vSH.f8987cb, true)) {
                            return false;
                        }
                        this.vSH.biSize = parsableByteArray5.readLittleEndianUnsignedInt();
                        this.vSH.biWidth = parsableByteArray5.readLittleEndianUnsignedInt();
                        this.vSH.biHeight = parsableByteArray5.readLittleEndianUnsignedInt();
                        this.vSH.biPlanes = parsableByteArray5.readLittleEndianUnsignedShort();
                        this.vSH.biBitCount = parsableByteArray5.readLittleEndianUnsignedShort();
                        this.vSH.biCompression = parsableByteArray5.readUnsignedInt();
                        this.videoReader = new AviVideoCodecReader(this.extractorOutput.track(this.streamNum, 2), MapCodecTypeToMimeType(0, (int) this.vSH.biCompression, (short) 0), this.aviSHTMP.Rate);
                        Log.m8318d(TAG, "Set video stream info: FPS :" + this.aviSHTMP.Rate + " WIDTH:" + this.vSH.biWidth + " HEIGHT:" + this.vSH.biHeight + ".");
                    } else if (this.aviSHTMP.fccType == Util.getIntegerCodeForString("auds")) {
                        ParsableByteArray parsableByteArray6 = new ParsableByteArray(8);
                        if (!extractorInput.readFully(parsableByteArray6.data, 0, 8, true)) {
                            return false;
                        }
                        parsableByteArray6.setPosition(0);
                        this.aSH = new AudioStreamHeader();
                        this.aSH.fcc = parsableByteArray6.readUnsignedInt();
                        this.aSH.f8983cb = parsableByteArray6.readLittleEndianUnsignedInt();
                        ParsableByteArray parsableByteArray7 = new ParsableByteArray((int) this.aSH.f8983cb);
                        if (!extractorInput.readFully(parsableByteArray7.data, 0, (int) this.aSH.f8983cb, true)) {
                            return false;
                        }
                        this.aSH.wFormatTag = parsableByteArray7.readLittleEndianUnsignedShort();
                        this.aSH.nChannels = parsableByteArray7.readLittleEndianUnsignedShort();
                        this.aSH.nSamplesPerSec = parsableByteArray7.readLittleEndianUnsignedInt();
                        this.aSH.nAvgBytesPerSec = parsableByteArray7.readLittleEndianUnsignedInt();
                        this.aSH.nBlockAlign = parsableByteArray7.readLittleEndianUnsignedShort();
                        this.aSH.wBitsPerSample = parsableByteArray7.readLittleEndianUnsignedShort();
                        Log.m8318d(TAG, "Set audio params: nChannel[" + this.aSH.nChannels + "] SPS[" + this.aSH.nSamplesPerSec + "] BPS[" + this.aSH.wBitsPerSample + "] ABPS[" + this.aSH.nAvgBytesPerSec + "]");
                        this.audioReader = new AviAudioCodecReader(this.extractorOutput.track(this.streamNum, 1), MapCodecTypeToMimeType(1, 0, (short) this.aSH.wFormatTag));
                        this.audioReader.setPCMEncodingType(this.aSH.wBitsPerSample);
                        this.audioReader.setBitPerSec(this.aSH.nAvgBytesPerSec * 8);
                        this.audioReader.setSampleRate(this.aSH.nSamplesPerSec);
                        this.audioReader.setChannelsNum(this.aSH.nChannels);
                    }
                    this.streamNum++;
                } else {
                    parsableByteArray2.setPosition(4);
                    int littleEndianUnsignedInt = (int) parsableByteArray2.readLittleEndianUnsignedInt();
                    extractorInput.skipFully(littleEndianUnsignedInt - 4);
                    if ((littleEndianUnsignedInt & 1) != 0) {
                        extractorInput.skipFully(1);
                    }
                }
                position = extractorInput.getPosition();
            } else {
                parsableByteArray2.setPosition(4);
                int littleEndianUnsignedInt2 = (int) parsableByteArray2.readLittleEndianUnsignedInt();
                extractorInput.skipFully(littleEndianUnsignedInt2 - 4);
                if ((littleEndianUnsignedInt2 & 1) != 0) {
                    extractorInput.skipFully(1);
                }
                position = extractorInput.getPosition();
            }
        }
        return true;
    }

    public boolean ReadAviInfoHeader(ExtractorInput extractorInput) throws InterruptedException, IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        if (!extractorInput.readFully(parsableByteArray.data, 0, 8, true)) {
            return false;
        }
        parsableByteArray.readUnsignedInt();
        extractorInput.skipFully((int) parsableByteArray.readLittleEndianUnsignedInt());
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(8);
        if (!extractorInput.readFully(parsableByteArray2.data, 0, 8, true)) {
            return false;
        }
        parsableByteArray2.setPosition(4);
        extractorInput.skipFully((int) parsableByteArray2.readLittleEndianUnsignedInt());
        return true;
    }

    public boolean ReadMoviData(ExtractorInput extractorInput) throws InterruptedException, IOException {
        long littleEndianUnsignedInt;
        int unsignedShort;
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        if (!extractorInput.readFully(parsableByteArray.data, 0, 8, true)) {
            return false;
        }
        parsableByteArray.setPosition(0);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        if (unsignedInt == Util.getIntegerCodeForString("LIST")) {
            this.moviLen = parsableByteArray.readLittleEndianUnsignedInt();
            this.dataChunkOffset = extractorInput.getPosition();
            this.extractorOutput.seekMap(BuildSeekMapIdx(extractorInput));
            this.extractorOutput.endTracks();
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(12);
            if (!extractorInput.readFully(parsableByteArray2.data, 0, 12, true)) {
                return false;
            }
            parsableByteArray2.setPosition(6);
            int unsignedShort2 = parsableByteArray2.readUnsignedShort();
            parsableByteArray2.setPosition(8);
            long littleEndianUnsignedInt2 = parsableByteArray2.readLittleEndianUnsignedInt();
            unsignedShort = unsignedShort2;
            littleEndianUnsignedInt = littleEndianUnsignedInt2;
        } else {
            littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
            parsableByteArray.setPosition(2);
            unsignedShort = parsableByteArray.readUnsignedShort();
        }
        if (unsignedShort != getShortCodeForString("dc") || littleEndianUnsignedInt == 0) {
            if (unsignedShort == getShortCodeForString("db")) {
                if (littleEndianUnsignedInt == 0) {
                    Log.m8320e(TAG, "Video data chunk size is 0, return directly");
                    return true;
                }
                int OplusGLSurfaceView_13 = (int) littleEndianUnsignedInt;
                ParsableByteArray parsableByteArray3 = new ParsableByteArray(OplusGLSurfaceView_13);
                if (!extractorInput.readFully(parsableByteArray3.data, 0, OplusGLSurfaceView_13, true)) {
                    return false;
                }
                parsableByteArray3.setPosition(0);
                this.videoReader.parse(parsableByteArray3, 0L);
                if ((littleEndianUnsignedInt & 1) != 0) {
                    extractorInput.skipFully(1);
                }
            } else if (unsignedShort == getShortCodeForString(CameraStatisticsUtil.PORTRAIT_WHITE_BALANCE)) {
                if (littleEndianUnsignedInt == 0) {
                    Log.m8320e(TAG, "Audio data chunk size is 0, return directly");
                    return true;
                }
                int i2 = (int) littleEndianUnsignedInt;
                ParsableByteArray parsableByteArray4 = new ParsableByteArray(i2);
                if (!extractorInput.readFully(parsableByteArray4.data, 0, i2, true)) {
                    return false;
                }
                parsableByteArray4.setPosition(0);
                this.audioReader.parse(parsableByteArray4, 0L);
                if ((littleEndianUnsignedInt & 1) != 0) {
                    extractorInput.skipFully(1);
                }
            } else {
                if (unsignedInt == Util.getIntegerCodeForString("idx1")) {
                    extractorInput.skipFully((int) littleEndianUnsignedInt);
                    return true;
                }
                extractorInput.skipFully((int) littleEndianUnsignedInt);
                if ((littleEndianUnsignedInt & 1) != 0) {
                    extractorInput.skipFully(1);
                }
                if (littleEndianUnsignedInt == Util.getIntegerCodeForString("0000")) {
                    return false;
                }
            }
        } else {
            if (littleEndianUnsignedInt == 0) {
                Log.m8320e(TAG, "Video data chunk size is 0, return directly");
                return true;
            }
            int i3 = (int) littleEndianUnsignedInt;
            ParsableByteArray parsableByteArray5 = new ParsableByteArray(i3);
            if (!extractorInput.readFully(parsableByteArray5.data, 0, i3, true)) {
                return false;
            }
            parsableByteArray5.setPosition(0);
            this.videoReader.parse(parsableByteArray5, 0L);
            if ((littleEndianUnsignedInt & 1) != 0) {
                extractorInput.skipFully(1);
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x01b8 A[LOOP:3: B:51:0x01b4->B:53:0x01b8, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.extractor.SeekMap BuildSeekMapIdx(com.google.android.exoplayer2.extractor.ExtractorInput r29) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.avi.AviExtractor.BuildSeekMapIdx(com.google.android.exoplayer2.extractor.ExtractorInput):com.google.android.exoplayer2.extractor.SeekMap");
    }
}
