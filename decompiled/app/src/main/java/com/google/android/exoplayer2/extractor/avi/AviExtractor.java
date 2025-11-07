package com.google.android.exoplayer2.extractor.avi;

/* loaded from: classes.dex */
public final class AviExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.avi.-$$Lambda$AviExtractor$F542WxF9leWTgMzxAlUZN0u1pZk
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.avi.AviExtractor.lambda$static$0();
        }
    };
    private static final int MAX_AUDIO_STREAM_NUM = 36;
    private static final int STATE_READING_AVI_HEADER = 1;
    private static final int STATE_READING_INFO_LIST = 2;
    private static final int STATE_READING_MOVI_DATA = 3;
    private static final int STREAM_TYPE_AUDIO = 8;
    private static final int STREAM_TYPE_SCRIPT_DATA = 18;
    private static final int STREAM_TYPE_VIDEO = 9;
    private static final java.lang.String TAG = "AviUtils";
    private static final int ashLen = 26;
    private static final int aviEHLen = 256;
    private static final int aviMHLen = 64;
    private static final int aviSHLen = 64;
    private static long fileLen = 0;
    private static long hdrlLen = 0;
    private static final int vshLen = 48;
    com.google.android.exoplayer2.extractor.avi.AviExtractor.AudioStreamHeader aSH;
    private com.google.android.exoplayer2.extractor.avi.AviAudioCodecReader audioReader;
    java.util.ArrayList<java.lang.Long> audioSeekSizeList;
    com.google.android.exoplayer2.extractor.avi.AviExtractor.AviExtHeader aviEH;
    com.google.android.exoplayer2.extractor.avi.AviExtractor.AviMainHeader aviMH;
    java.util.ArrayList<com.google.android.exoplayer2.extractor.avi.AviExtractor.AviStreamHeader> aviSH;
    com.google.android.exoplayer2.extractor.avi.AviExtractor.AviStreamHeader aviSHTMP;
    private long dataChunkOffset;
    private android.net.Uri defaultUri;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    java.util.ArrayList<java.lang.Integer> keyFrameNumList;
    private int mapFrameCount;
    private long moviLen;
    private int parserState;
    public com.google.android.exoplayer2.extractor.ChunkIndex seekIdx;
    private int streamNum;
    com.google.android.exoplayer2.extractor.avi.AviExtractor.VideoStreamHeader vSH;
    private long videoFrameCount;
    private com.google.android.exoplayer2.extractor.avi.AviVideoCodecReader videoReader;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.avi.AviExtractor()};
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
        public long cb_renamed;
        public long fcc;

        AviMainHeader() {
        }
    }

    class AviExtHeader {
        public int[] Future = new int[61];
        public int GrandFrames;
        public int cb_renamed;
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
        public long cb_renamed;
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
        public long cb_renamed;
        public long fcc;

        VideoStreamHeader() {
        }
    }

    class AudioStreamHeader {
        public long cb_renamed;
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
        this.aviSH = new java.util.ArrayList<>();
        this.mapFrameCount = 0;
        this.videoFrameCount = 0L;
        this.keyFrameNumList = new java.util.ArrayList<>();
        this.seekIdx = null;
        this.audioSeekSizeList = new java.util.ArrayList<>();
        this.defaultUri = null;
    }

    public AviExtractor(android.net.Uri uri) {
        this.streamNum = 0;
        this.aviSH = new java.util.ArrayList<>();
        this.mapFrameCount = 0;
        this.videoFrameCount = 0L;
        this.keyFrameNumList = new java.util.ArrayList<>();
        this.seekIdx = null;
        this.audioSeekSizeList = new java.util.ArrayList<>();
        this.defaultUri = null;
        if (com.google.android.exoplayer2.util.Util.isLocalFileUri(uri)) {
            this.defaultUri = uri;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return PeekHeader(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        long j3;
        if (j_renamed == 0) {
            this.parserState = 1;
            return;
        }
        int chunkIndex = 0;
        com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex2 = this.seekIdx;
        if (chunkIndex2 != null) {
            chunkIndex = chunkIndex2.getChunkIndex(j2);
            long j4 = this.seekIdx.timesUs[chunkIndex];
            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Adjust seek time position:" + j2);
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
            this.videoReader.seek(j_renamed, j3, this.keyFrameNumList.get(chunkIndex).intValue());
        }
        com.google.android.exoplayer2.extractor.avi.AviAudioCodecReader aviAudioCodecReader = this.audioReader;
        if (aviAudioCodecReader != null) {
            aviAudioCodecReader.seek(j_renamed, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        while (true) {
            int i_renamed = this.parserState;
            if (i_renamed != 1) {
                if (i_renamed != 2) {
                    if (i_renamed == 3) {
                        return ReadMoviData(extractorInput) ? 0 : -1;
                    }
                    throw new java.lang.IllegalStateException();
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

    public static java.lang.String MapCodecTypeToMimeType(int i_renamed, int i2, short s_renamed) {
        if (i_renamed != 0) {
            if (i_renamed != 1) {
                return null;
            }
            if (s_renamed == 1) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW;
            }
            if (s_renamed == 80) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG_L2;
            }
            if (s_renamed == 85) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG;
            }
            if (s_renamed == 87) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_AMR_NB;
            }
            if (s_renamed == 88) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_AMR_WB;
            }
            if (s_renamed == 22127 || s_renamed == 26447 || s_renamed == 26448 || s_renamed == 26449) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_VORBIS;
            }
            if (s_renamed == 255) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC;
            }
            return null;
        }
        if (com.google.android.exoplayer2.util.Util.getIntegerCodeForString("XVID") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("Xvid") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("xvid") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("XVIX") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3IV2") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3iv2") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("DIV1") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("div1") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("DIVX") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("divx") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("DX50") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dx50") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("DXGM") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("EM4A") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("EPHV") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("FMP4") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("fmp4") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("FVFW") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("HDX4") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hdx4") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("M4CC") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("M4S2") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("m4s2") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("MP4S") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mp4s") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("MP4V") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mp4v") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("RMP4") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("SMP4") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("UMP4") == i2 || com.google.android.exoplayer2.util.Util.getIntegerCodeForString("WV1F") == i2) {
            com.google.android.exoplayer2.util.Log.d_renamed("HeyTap Player", "this is_renamed mpeg4v codec :" + i2);
            return com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4V;
        }
        if (com.google.android.exoplayer2.util.Util.getIntegerCodeForString("avc1") != i2 && com.google.android.exoplayer2.util.Util.getIntegerCodeForString("davc") != i2 && com.google.android.exoplayer2.util.Util.getIntegerCodeForString("x264") != i2 && com.google.android.exoplayer2.util.Util.getIntegerCodeForString(com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264) != i2 && com.google.android.exoplayer2.util.Util.getIntegerCodeForString("vssh") != i2) {
            return "video";
        }
        com.google.android.exoplayer2.util.Log.d_renamed("HeyTap Player", "this is_renamed h264 codec :" + i2);
        return com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264;
    }

    public static short getShortCodeForString(java.lang.String str) {
        int length = str.length();
        com.google.android.exoplayer2.util.Assertions.checkArgument(length <= 2);
        short sCharAt = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            sCharAt = (short) (((short) (sCharAt << 8)) | str.charAt(i_renamed));
        }
        return sCharAt;
    }

    public boolean PeekHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(extractorInput);
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(12);
        extractorInput.peekFully(parsableByteArray.data, 0, 8);
        parsableByteArray.setPosition(0);
        int i_renamed = parsableByteArray.readInt();
        fileLen = parsableByteArray.readLittleEndianUnsignedInt();
        if (i_renamed != com.google.android.exoplayer2.util.Util.getIntegerCodeForString("RIFF")) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "this is_renamed not RIFF format");
            return false;
        }
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int i2 = parsableByteArray.readInt();
        if (i2 != com.google.android.exoplayer2.util.Util.getIntegerCodeForString("AVI ")) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unsupported RIFF format: " + i2);
            return false;
        }
        extractorInput.peekFully(parsableByteArray.data, 0, 12);
        parsableByteArray.setPosition(0);
        parsableByteArray.readInt();
        hdrlLen = parsableByteArray.readLittleEndianUnsignedInt();
        if (parsableByteArray.readInt() == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hdrl")) {
            return true;
        }
        com.google.android.exoplayer2.util.Log.e_renamed(TAG, "There is_renamed no HDRL info");
        return false;
    }

    public boolean ReadAviHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.skipFully(24);
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(64);
        if (!extractorInput.readFully(parsableByteArray.data, 0, 64, true)) {
            return false;
        }
        parsableByteArray.setPosition(0);
        this.aviMH = new com.google.android.exoplayer2.extractor.avi.AviExtractor.AviMainHeader();
        this.aviMH.fcc = parsableByteArray.readUnsignedInt();
        this.aviMH.cb_renamed = parsableByteArray.readLittleEndianUnsignedInt();
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
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Media track number more than 36!! Let's_renamed fix it");
            return false;
        }
        long position = extractorInput.getPosition();
        while (position < hdrlLen + 8 + 12) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray(12);
            if (!extractorInput.readFully(parsableByteArray2.data, 0, 12, true)) {
                return false;
            }
            parsableByteArray2.setPosition(0);
            if (parsableByteArray2.readUnsignedInt() == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("LIST")) {
                parsableByteArray2.setPosition(8);
                if (parsableByteArray2.readUnsignedInt() == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("strl")) {
                    com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray3 = new com.google.android.exoplayer2.util.ParsableByteArray(64);
                    if (!extractorInput.readFully(parsableByteArray3.data, 0, 64, true)) {
                        return false;
                    }
                    parsableByteArray3.setPosition(0);
                    this.aviSHTMP = new com.google.android.exoplayer2.extractor.avi.AviExtractor.AviStreamHeader();
                    this.aviSHTMP.fcc = parsableByteArray3.readUnsignedInt();
                    this.aviSHTMP.cb_renamed = parsableByteArray3.readLittleEndianUnsignedInt();
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
                    if (this.aviSHTMP.fccType == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("vids")) {
                        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray4 = new com.google.android.exoplayer2.util.ParsableByteArray(8);
                        if (!extractorInput.readFully(parsableByteArray4.data, 0, 8, true)) {
                            return false;
                        }
                        parsableByteArray4.setPosition(0);
                        this.vSH = new com.google.android.exoplayer2.extractor.avi.AviExtractor.VideoStreamHeader();
                        this.vSH.fcc = parsableByteArray4.readUnsignedInt();
                        this.vSH.cb_renamed = parsableByteArray4.readLittleEndianUnsignedInt();
                        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray5 = new com.google.android.exoplayer2.util.ParsableByteArray((int) this.vSH.cb_renamed);
                        if (!extractorInput.readFully(parsableByteArray5.data, 0, (int) this.vSH.cb_renamed, true)) {
                            return false;
                        }
                        this.vSH.biSize = parsableByteArray5.readLittleEndianUnsignedInt();
                        this.vSH.biWidth = parsableByteArray5.readLittleEndianUnsignedInt();
                        this.vSH.biHeight = parsableByteArray5.readLittleEndianUnsignedInt();
                        this.vSH.biPlanes = parsableByteArray5.readLittleEndianUnsignedShort();
                        this.vSH.biBitCount = parsableByteArray5.readLittleEndianUnsignedShort();
                        this.vSH.biCompression = parsableByteArray5.readUnsignedInt();
                        this.videoReader = new com.google.android.exoplayer2.extractor.avi.AviVideoCodecReader(this.extractorOutput.track(this.streamNum, 2), MapCodecTypeToMimeType(0, (int) this.vSH.biCompression, (short) 0), this.aviSHTMP.Rate);
                        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Set video stream info: FPS :" + this.aviSHTMP.Rate + " WIDTH:" + this.vSH.biWidth + " HEIGHT:" + this.vSH.biHeight + ".");
                    } else if (this.aviSHTMP.fccType == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("auds")) {
                        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray6 = new com.google.android.exoplayer2.util.ParsableByteArray(8);
                        if (!extractorInput.readFully(parsableByteArray6.data, 0, 8, true)) {
                            return false;
                        }
                        parsableByteArray6.setPosition(0);
                        this.aSH = new com.google.android.exoplayer2.extractor.avi.AviExtractor.AudioStreamHeader();
                        this.aSH.fcc = parsableByteArray6.readUnsignedInt();
                        this.aSH.cb_renamed = parsableByteArray6.readLittleEndianUnsignedInt();
                        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray7 = new com.google.android.exoplayer2.util.ParsableByteArray((int) this.aSH.cb_renamed);
                        if (!extractorInput.readFully(parsableByteArray7.data, 0, (int) this.aSH.cb_renamed, true)) {
                            return false;
                        }
                        this.aSH.wFormatTag = parsableByteArray7.readLittleEndianUnsignedShort();
                        this.aSH.nChannels = parsableByteArray7.readLittleEndianUnsignedShort();
                        this.aSH.nSamplesPerSec = parsableByteArray7.readLittleEndianUnsignedInt();
                        this.aSH.nAvgBytesPerSec = parsableByteArray7.readLittleEndianUnsignedInt();
                        this.aSH.nBlockAlign = parsableByteArray7.readLittleEndianUnsignedShort();
                        this.aSH.wBitsPerSample = parsableByteArray7.readLittleEndianUnsignedShort();
                        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Set audio params: nChannel[" + this.aSH.nChannels + "] SPS[" + this.aSH.nSamplesPerSec + "] BPS[" + this.aSH.wBitsPerSample + "] ABPS[" + this.aSH.nAvgBytesPerSec + "]");
                        this.audioReader = new com.google.android.exoplayer2.extractor.avi.AviAudioCodecReader(this.extractorOutput.track(this.streamNum, 1), MapCodecTypeToMimeType(1, 0, (short) this.aSH.wFormatTag));
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

    public boolean ReadAviInfoHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(8);
        if (!extractorInput.readFully(parsableByteArray.data, 0, 8, true)) {
            return false;
        }
        parsableByteArray.readUnsignedInt();
        extractorInput.skipFully((int) parsableByteArray.readLittleEndianUnsignedInt());
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray(8);
        if (!extractorInput.readFully(parsableByteArray2.data, 0, 8, true)) {
            return false;
        }
        parsableByteArray2.setPosition(4);
        extractorInput.skipFully((int) parsableByteArray2.readLittleEndianUnsignedInt());
        return true;
    }

    public boolean ReadMoviData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        long littleEndianUnsignedInt;
        int unsignedShort;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(8);
        if (!extractorInput.readFully(parsableByteArray.data, 0, 8, true)) {
            return false;
        }
        parsableByteArray.setPosition(0);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        if (unsignedInt == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("LIST")) {
            this.moviLen = parsableByteArray.readLittleEndianUnsignedInt();
            this.dataChunkOffset = extractorInput.getPosition();
            this.extractorOutput.seekMap(BuildSeekMapIdx(extractorInput));
            this.extractorOutput.endTracks();
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray(12);
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
        if (unsignedShort != getShortCodeForString("dc_renamed") || littleEndianUnsignedInt == 0) {
            if (unsignedShort == getShortCodeForString("db_renamed")) {
                if (littleEndianUnsignedInt == 0) {
                    com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Video data chunk size is_renamed 0, return directly");
                    return true;
                }
                int i_renamed = (int) littleEndianUnsignedInt;
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray3 = new com.google.android.exoplayer2.util.ParsableByteArray(i_renamed);
                if (!extractorInput.readFully(parsableByteArray3.data, 0, i_renamed, true)) {
                    return false;
                }
                parsableByteArray3.setPosition(0);
                this.videoReader.parse(parsableByteArray3, 0L);
                if ((littleEndianUnsignedInt & 1) != 0) {
                    extractorInput.skipFully(1);
                }
            } else if (unsignedShort == getShortCodeForString(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_WHITE_BALANCE)) {
                if (littleEndianUnsignedInt == 0) {
                    com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Audio data chunk size is_renamed 0, return directly");
                    return true;
                }
                int i2 = (int) littleEndianUnsignedInt;
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray4 = new com.google.android.exoplayer2.util.ParsableByteArray(i2);
                if (!extractorInput.readFully(parsableByteArray4.data, 0, i2, true)) {
                    return false;
                }
                parsableByteArray4.setPosition(0);
                this.audioReader.parse(parsableByteArray4, 0L);
                if ((littleEndianUnsignedInt & 1) != 0) {
                    extractorInput.skipFully(1);
                }
            } else {
                if (unsignedInt == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("idx1")) {
                    extractorInput.skipFully((int) littleEndianUnsignedInt);
                    return true;
                }
                extractorInput.skipFully((int) littleEndianUnsignedInt);
                if ((littleEndianUnsignedInt & 1) != 0) {
                    extractorInput.skipFully(1);
                }
                if (littleEndianUnsignedInt == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("0000")) {
                    return false;
                }
            }
        } else {
            if (littleEndianUnsignedInt == 0) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Video data chunk size is_renamed 0, return directly");
                return true;
            }
            int i3 = (int) littleEndianUnsignedInt;
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray5 = new com.google.android.exoplayer2.util.ParsableByteArray(i3);
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

    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x01b8 A_renamed[LOOP:3: B_renamed:51:0x01b4->B_renamed:53:0x01b8, LOOP_END] */
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
