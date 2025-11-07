package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes.dex */
public final class MatroskaExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final java.lang.String CODEC_ID_AAC = "A_AAC";
    private static final java.lang.String CODEC_ID_AC3 = "A_AC3";
    private static final java.lang.String CODEC_ID_ACM = "A_MS/ACM";
    private static final java.lang.String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final java.lang.String CODEC_ID_AV1 = "V_AV1";
    private static final java.lang.String CODEC_ID_DTS = "A_DTS";
    private static final java.lang.String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final java.lang.String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final java.lang.String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final java.lang.String CODEC_ID_E_AC3 = "A_EAC3";
    private static final java.lang.String CODEC_ID_FLAC = "A_FLAC";
    private static final java.lang.String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final java.lang.String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final java.lang.String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final java.lang.String CODEC_ID_MP2 = "A_MPEG/L2_renamed";
    private static final java.lang.String CODEC_ID_MP3 = "A_MPEG/L3_renamed";
    private static final java.lang.String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final java.lang.String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final java.lang.String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final java.lang.String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final java.lang.String CODEC_ID_OPUS = "A_OPUS";
    private static final java.lang.String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final java.lang.String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final java.lang.String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final java.lang.String CODEC_ID_THEORA = "V_THEORA";
    private static final java.lang.String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final java.lang.String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final java.lang.String CODEC_ID_VORBIS = "A_VORBIS";
    private static final java.lang.String CODEC_ID_VP8 = "V_VP8";
    private static final java.lang.String CODEC_ID_VP9 = "V_VP9";
    private static final java.lang.String DOC_TYPE_MATROSKA = "matroska";
    private static final java.lang.String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final java.lang.String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final java.lang.String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final java.lang.String TAG = "MatroskaExtractor";
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private long blockDurationUs;
    private int blockFlags;
    private int blockLacingSampleCount;
    private int blockLacingSampleIndex;
    private int[] blockLacingSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private com.google.android.exoplayer2.util.LongArray cueClusterPositions;
    private com.google.android.exoplayer2.util.LongArray cueTimesUs;
    private long cuesContentPosition;
    private com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final com.google.android.exoplayer2.util.ParsableByteArray encryptionInitializationVector;
    private final com.google.android.exoplayer2.util.ParsableByteArray encryptionSubsampleData;
    private java.nio.ByteBuffer encryptionSubsampleDataBuffer;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalLength;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalStartCode;
    private final com.google.android.exoplayer2.extractor.mkv.EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private boolean sampleRead;
    private boolean sampleSeenReferenceBlock;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final com.google.android.exoplayer2.util.ParsableByteArray sampleStrippedBytes;
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch;
    private int seekEntryId;
    private final com.google.android.exoplayer2.util.ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final com.google.android.exoplayer2.util.ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final android.util.SparseArray<com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track> tracks;
    private final com.google.android.exoplayer2.extractor.mkv.VarintReader varintReader;
    private final com.google.android.exoplayer2.util.ParsableByteArray vorbisNumPageSamples;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mkv.-$$Lambda$MatroskaExtractor$jNXW0tyYIOPE6N2jicocV6rRvBs
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.lambda$static$0();
        }
    };
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] SUBRIP_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] SSA_DIALOGUE_FORMAT = com.google.android.exoplayer2.util.Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] SSA_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final java.util.UUID WAVE_SUBFORMAT_PCM = new java.util.UUID(72057594037932032L, -9223371306706625679L);

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor()};
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int i_renamed) {
        this(new com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader(), i_renamed);
    }

    MatroskaExtractor(com.google.android.exoplayer2.extractor.mkv.EbmlReader ebmlReader, int i_renamed) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = ebmlReader;
        this.reader.init(new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.InnerEbmlReaderOutput());
        this.seekForCuesEnabled = (i_renamed & 1) == 0;
        this.varintReader = new com.google.android.exoplayer2.extractor.mkv.VarintReader();
        this.tracks = new android.util.SparseArray<>();
        this.scratch = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.vorbisNumPageSamples = new com.google.android.exoplayer2.util.ParsableByteArray(java.nio.ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.nalStartCode = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.nalLength = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.sampleStrippedBytes = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.subtitleSample = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.encryptionInitializationVector = new com.google.android.exoplayer2.util.ParsableByteArray(8);
        this.encryptionSubsampleData = new com.google.android.exoplayer2.util.ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return new com.google.android.exoplayer2.extractor.mkv.Sniffer().sniff(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetSample();
        for (int i_renamed = 0; i_renamed < this.tracks.size(); i_renamed++) {
            this.tracks.valueAt(i_renamed).reset();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        this.sampleRead = false;
        boolean z_renamed = true;
        while (z_renamed && !this.sampleRead) {
            z_renamed = this.reader.read(extractorInput);
            if (z_renamed && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z_renamed) {
            return 0;
        }
        for (int i_renamed = 0; i_renamed < this.tracks.size(); i_renamed++) {
            this.tracks.valueAt(i_renamed).outputPendingSampleMetadata();
        }
        return -1;
    }

    void startMasterElement(int i_renamed, long j_renamed, long j2) throws com.google.android.exoplayer2.ParserException {
        if (i_renamed == 160) {
            this.sampleSeenReferenceBlock = false;
            return;
        }
        if (i_renamed == 174) {
            this.currentTrack = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track();
            return;
        }
        if (i_renamed == 187) {
            this.seenClusterPositionForCurrentCuePoint = false;
            return;
        }
        if (i_renamed == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
            return;
        }
        if (i_renamed == ID_CONTENT_ENCRYPTION) {
            this.currentTrack.hasContentEncryption = true;
            return;
        }
        if (i_renamed == ID_MASTERING_METADATA) {
            this.currentTrack.hasColorInfo = true;
            return;
        }
        if (i_renamed != ID_CONTENT_ENCODING) {
            if (i_renamed == ID_SEGMENT) {
                long j3 = this.segmentContentPosition;
                if (j3 != -1 && j3 != j_renamed) {
                    throw new com.google.android.exoplayer2.ParserException("Multiple Segment elements not supported");
                }
                this.segmentContentPosition = j_renamed;
                this.segmentContentSize = j2;
                return;
            }
            if (i_renamed == ID_CUES) {
                this.cueTimesUs = new com.google.android.exoplayer2.util.LongArray();
                this.cueClusterPositions = new com.google.android.exoplayer2.util.LongArray();
            } else if (i_renamed == ID_CLUSTER && !this.sentSeekMap) {
                if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                    this.seekForCues = true;
                } else {
                    this.extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.durationUs));
                    this.sentSeekMap = true;
                }
            }
        }
    }

    void endMasterElement(int i_renamed) throws com.google.android.exoplayer2.ParserException {
        if (i_renamed == 160) {
            if (this.blockState != 2) {
                return;
            }
            if (!this.sampleSeenReferenceBlock) {
                this.blockFlags |= 1;
            }
            commitSampleToOutput(this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
            this.blockState = 0;
            return;
        }
        if (i_renamed == 174) {
            if (isCodecSupported(this.currentTrack.codecId)) {
                com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track = this.currentTrack;
                track.initializeOutput(this.extractorOutput, track.number);
                this.tracks.put(this.currentTrack.number, this.currentTrack);
            }
            this.currentTrack = null;
            return;
        }
        if (i_renamed == ID_SEEK) {
            int i2 = this.seekEntryId;
            if (i2 != -1) {
                long j_renamed = this.seekEntryPosition;
                if (j_renamed != -1) {
                    if (i2 == ID_CUES) {
                        this.cuesContentPosition = j_renamed;
                        return;
                    }
                    return;
                }
            }
            throw new com.google.android.exoplayer2.ParserException("Mandatory element SeekID or SeekPosition not found");
        }
        if (i_renamed == ID_CONTENT_ENCODING) {
            if (this.currentTrack.hasContentEncryption) {
                if (this.currentTrack.cryptoData == null) {
                    throw new com.google.android.exoplayer2.ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.currentTrack.drmInitData = new com.google.android.exoplayer2.drm.DrmInitData(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(com.google.android.exoplayer2.C_renamed.UUID_NIL, com.google.android.exoplayer2.util.MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
                return;
            }
            return;
        }
        if (i_renamed == ID_CONTENT_ENCODINGS) {
            if (this.currentTrack.hasContentEncryption && this.currentTrack.sampleStrippedBytes != null) {
                throw new com.google.android.exoplayer2.ParserException("Combining encryption and compression is_renamed not supported");
            }
            return;
        }
        if (i_renamed == 357149030) {
            if (this.timecodeScale == -9223372036854775807L) {
                this.timecodeScale = 1000000L;
            }
            long j2 = this.durationTimecode;
            if (j2 != -9223372036854775807L) {
                this.durationUs = scaleTimecodeToUs(j2);
                return;
            }
            return;
        }
        if (i_renamed != ID_TRACKS) {
            if (i_renamed == ID_CUES && !this.sentSeekMap) {
                this.extractorOutput.seekMap(buildSeekMap());
                this.sentSeekMap = true;
                return;
            }
            return;
        }
        if (this.tracks.size() == 0) {
            throw new com.google.android.exoplayer2.ParserException("No valid tracks were found");
        }
        this.extractorOutput.endTracks();
    }

    void integerElement(int i_renamed, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        if (i_renamed == ID_CONTENT_ENCODING_ORDER) {
            if (j_renamed == 0) {
                return;
            }
            throw new com.google.android.exoplayer2.ParserException("ContentEncodingOrder " + j_renamed + " not supported");
        }
        if (i_renamed == ID_CONTENT_ENCODING_SCOPE) {
            if (j_renamed == 1) {
                return;
            }
            throw new com.google.android.exoplayer2.ParserException("ContentEncodingScope " + j_renamed + " not supported");
        }
        switch (i_renamed) {
            case 131:
                this.currentTrack.type = (int) j_renamed;
                return;
            case 136:
                this.currentTrack.flagDefault = j_renamed == 1;
                return;
            case 155:
                this.blockDurationUs = scaleTimecodeToUs(j_renamed);
                return;
            case ID_CHANNELS /* 159 */:
                this.currentTrack.channelCount = (int) j_renamed;
                return;
            case 176:
                this.currentTrack.width = (int) j_renamed;
                return;
            case 179:
                this.cueTimesUs.add(scaleTimecodeToUs(j_renamed));
                return;
            case 186:
                this.currentTrack.height = (int) j_renamed;
                return;
            case 215:
                this.currentTrack.number = (int) j_renamed;
                return;
            case 231:
                this.clusterTimecodeUs = scaleTimecodeToUs(j_renamed);
                return;
            case 241:
                if (this.seenClusterPositionForCurrentCuePoint) {
                    return;
                }
                this.cueClusterPositions.add(j_renamed);
                this.seenClusterPositionForCurrentCuePoint = true;
                return;
            case 251:
                this.sampleSeenReferenceBlock = true;
                return;
            case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                if (j_renamed == 3) {
                    return;
                }
                throw new com.google.android.exoplayer2.ParserException("ContentCompAlgo " + j_renamed + " not supported");
            case ID_DOC_TYPE_READ_VERSION /* 17029 */:
                if (j_renamed < 1 || j_renamed > 2) {
                    throw new com.google.android.exoplayer2.ParserException("DocTypeReadVersion " + j_renamed + " not supported");
                }
                return;
            case ID_EBML_READ_VERSION /* 17143 */:
                if (j_renamed == 1) {
                    return;
                }
                throw new com.google.android.exoplayer2.ParserException("EBMLReadVersion " + j_renamed + " not supported");
            case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                if (j_renamed == 5) {
                    return;
                }
                throw new com.google.android.exoplayer2.ParserException("ContentEncAlgo " + j_renamed + " not supported");
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                if (j_renamed == 1) {
                    return;
                }
                throw new com.google.android.exoplayer2.ParserException("AESSettingsCipherMode " + j_renamed + " not supported");
            case ID_SEEK_POSITION /* 21420 */:
                this.seekEntryPosition = j_renamed + this.segmentContentPosition;
                return;
            case ID_STEREO_MODE /* 21432 */:
                int i2 = (int) j_renamed;
                if (i2 == 0) {
                    this.currentTrack.stereoMode = 0;
                    return;
                }
                if (i2 == 1) {
                    this.currentTrack.stereoMode = 2;
                    return;
                } else if (i2 == 3) {
                    this.currentTrack.stereoMode = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.currentTrack.stereoMode = 3;
                    return;
                }
            case ID_DISPLAY_WIDTH /* 21680 */:
                this.currentTrack.displayWidth = (int) j_renamed;
                return;
            case ID_DISPLAY_UNIT /* 21682 */:
                this.currentTrack.displayUnit = (int) j_renamed;
                return;
            case ID_DISPLAY_HEIGHT /* 21690 */:
                this.currentTrack.displayHeight = (int) j_renamed;
                return;
            case ID_FLAG_FORCED /* 21930 */:
                this.currentTrack.flagForced = j_renamed == 1;
                return;
            case ID_CODEC_DELAY /* 22186 */:
                this.currentTrack.codecDelayNs = j_renamed;
                return;
            case ID_SEEK_PRE_ROLL /* 22203 */:
                this.currentTrack.seekPreRollNs = j_renamed;
                return;
            case ID_AUDIO_BIT_DEPTH /* 25188 */:
                this.currentTrack.audioBitDepth = (int) j_renamed;
                return;
            case ID_PROJECTION_TYPE /* 30321 */:
                int i3 = (int) j_renamed;
                if (i3 == 0) {
                    this.currentTrack.projectionType = 0;
                    return;
                }
                if (i3 == 1) {
                    this.currentTrack.projectionType = 1;
                    return;
                } else if (i3 == 2) {
                    this.currentTrack.projectionType = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.currentTrack.projectionType = 3;
                    return;
                }
            case ID_DEFAULT_DURATION /* 2352003 */:
                this.currentTrack.defaultSampleDurationNs = (int) j_renamed;
                return;
            case ID_TIMECODE_SCALE /* 2807729 */:
                this.timecodeScale = j_renamed;
                return;
            default:
                switch (i_renamed) {
                    case ID_COLOUR_RANGE /* 21945 */:
                        int i4 = (int) j_renamed;
                        if (i4 == 1) {
                            this.currentTrack.colorRange = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.currentTrack.colorRange = 1;
                            return;
                        }
                    case ID_COLOUR_TRANSFER /* 21946 */:
                        int i5 = (int) j_renamed;
                        if (i5 != 1) {
                            if (i5 == 16) {
                                this.currentTrack.colorTransfer = 6;
                                return;
                            } else if (i5 == 18) {
                                this.currentTrack.colorTransfer = 7;
                                return;
                            } else if (i5 != 6 && i5 != 7) {
                                return;
                            }
                        }
                        this.currentTrack.colorTransfer = 3;
                        return;
                    case ID_COLOUR_PRIMARIES /* 21947 */:
                        com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track = this.currentTrack;
                        track.hasColorInfo = true;
                        int i6 = (int) j_renamed;
                        if (i6 == 1) {
                            track.colorSpace = 1;
                            return;
                        }
                        if (i6 == 9) {
                            track.colorSpace = 6;
                            return;
                        } else {
                            if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                this.currentTrack.colorSpace = 2;
                                return;
                            }
                            return;
                        }
                    case ID_MAX_CLL /* 21948 */:
                        this.currentTrack.maxContentLuminance = (int) j_renamed;
                        return;
                    case ID_MAX_FALL /* 21949 */:
                        this.currentTrack.maxFrameAverageLuminance = (int) j_renamed;
                        return;
                    default:
                        return;
                }
        }
    }

    void floatElement(int i_renamed, double d_renamed) {
        if (i_renamed == 181) {
            this.currentTrack.sampleRate = (int) d_renamed;
        }
        if (i_renamed == ID_DURATION) {
            this.durationTimecode = (long) d_renamed;
            return;
        }
        switch (i_renamed) {
            case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                this.currentTrack.primaryRChromaticityX = (float) d_renamed;
                break;
            case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                this.currentTrack.primaryRChromaticityY = (float) d_renamed;
                break;
            case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                this.currentTrack.primaryGChromaticityX = (float) d_renamed;
                break;
            case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                this.currentTrack.primaryGChromaticityY = (float) d_renamed;
                break;
            case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                this.currentTrack.primaryBChromaticityX = (float) d_renamed;
                break;
            case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                this.currentTrack.primaryBChromaticityY = (float) d_renamed;
                break;
            case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                this.currentTrack.whitePointChromaticityX = (float) d_renamed;
                break;
            case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                this.currentTrack.whitePointChromaticityY = (float) d_renamed;
                break;
            case ID_LUMNINANCE_MAX /* 21977 */:
                this.currentTrack.maxMasteringLuminance = (float) d_renamed;
                break;
            case ID_LUMNINANCE_MIN /* 21978 */:
                this.currentTrack.minMasteringLuminance = (float) d_renamed;
                break;
            default:
                switch (i_renamed) {
                    case ID_PROJECTION_POSE_YAW /* 30323 */:
                        this.currentTrack.projectionPoseYaw = (float) d_renamed;
                        break;
                    case ID_PROJECTION_POSE_PITCH /* 30324 */:
                        this.currentTrack.projectionPosePitch = (float) d_renamed;
                        break;
                    case ID_PROJECTION_POSE_ROLL /* 30325 */:
                        this.currentTrack.projectionPoseRoll = (float) d_renamed;
                        break;
                }
        }
    }

    void stringElement(int i_renamed, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
        if (i_renamed == 134) {
            this.currentTrack.codecId = str;
            return;
        }
        if (i_renamed != ID_DOC_TYPE) {
            if (i_renamed == ID_NAME) {
                this.currentTrack.name = str;
                return;
            } else {
                if (i_renamed != ID_LANGUAGE) {
                    return;
                }
                this.currentTrack.language = str;
                return;
            }
        }
        if (DOC_TYPE_WEBM.equals(str) || DOC_TYPE_MATROSKA.equals(str)) {
            return;
        }
        throw new com.google.android.exoplayer2.ParserException("DocType " + str + " not supported");
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:74:0x01fe, code lost:
    
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of_renamed range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void binaryElement(int r20, int r21, com.google.android.exoplayer2.extractor.ExtractorInput r22) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.binaryElement(int, int, com.google.android.exoplayer2.extractor.ExtractorInput):void");
    }

    private void commitSampleToOutput(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, long j_renamed) {
        if (track.trueHdSampleRechunker != null) {
            track.trueHdSampleRechunker.sampleMetadata(track, j_renamed);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId)) {
                commitSubtitleSample(track, SUBRIP_TIMECODE_FORMAT, 19, 1000L, SUBRIP_TIMECODE_EMPTY);
            } else if (CODEC_ID_ASS.equals(track.codecId)) {
                commitSubtitleSample(track, SSA_TIMECODE_FORMAT, 21, SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR, SSA_TIMECODE_EMPTY);
            }
            track.output.sampleMetadata(j_renamed, this.blockFlags, this.sampleBytesWritten, 0, track.cryptoData);
        }
        this.sampleRead = true;
        resetSample();
    }

    private void resetSample() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private void readScratch(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (this.scratch.limit() >= i_renamed) {
            return;
        }
        if (this.scratch.capacity() < i_renamed) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.scratch;
            parsableByteArray.reset(java.util.Arrays.copyOf(parsableByteArray.data, java.lang.Math.max(this.scratch.data.length * 2, i_renamed)), this.scratch.limit());
        }
        extractorInput.readFully(this.scratch.data, this.scratch.limit(), i_renamed - this.scratch.limit());
        this.scratch.setLimit(i_renamed);
    }

    private void writeSampleData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int i2;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i_renamed);
            return;
        }
        if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i_renamed);
            return;
        }
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = track.output;
        if (!this.sampleEncodingHandled) {
            if (track.hasContentEncryption) {
                this.blockFlags &= -1073741825;
                if (!this.sampleSignalByteRead) {
                    extractorInput.readFully(this.scratch.data, 0, 1);
                    this.sampleBytesRead++;
                    if ((this.scratch.data[0] & 128) == 128) {
                        throw new com.google.android.exoplayer2.ParserException("Extension bit is_renamed set in_renamed signal byte");
                    }
                    this.sampleSignalByte = this.scratch.data[0];
                    this.sampleSignalByteRead = true;
                }
                if ((this.sampleSignalByte & 1) == 1) {
                    boolean z_renamed = (this.sampleSignalByte & 2) == 2;
                    this.blockFlags |= 1073741824;
                    if (!this.sampleInitializationVectorRead) {
                        extractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        this.scratch.data[0] = (byte) ((z_renamed ? 128 : 0) | 8);
                        this.scratch.setPosition(0);
                        trackOutput.sampleData(this.scratch, 1);
                        this.sampleBytesWritten++;
                        this.encryptionInitializationVector.setPosition(0);
                        trackOutput.sampleData(this.encryptionInitializationVector, 8);
                        this.sampleBytesWritten += 8;
                    }
                    if (z_renamed) {
                        if (!this.samplePartitionCountRead) {
                            extractorInput.readFully(this.scratch.data, 0, 1);
                            this.sampleBytesRead++;
                            this.scratch.setPosition(0);
                            this.samplePartitionCount = this.scratch.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int i3 = this.samplePartitionCount * 4;
                        this.scratch.reset(i3);
                        extractorInput.readFully(this.scratch.data, 0, i3);
                        this.sampleBytesRead += i3;
                        short s_renamed = (short) ((this.samplePartitionCount / 2) + 1);
                        int i4 = (s_renamed * 6) + 2;
                        java.nio.ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.encryptionSubsampleDataBuffer = java.nio.ByteBuffer.allocate(i4);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s_renamed);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.samplePartitionCount;
                            if (i5 >= i2) {
                                break;
                            }
                            int unsignedIntToInt = this.scratch.readUnsignedIntToInt();
                            if (i5 % 2 == 0) {
                                this.encryptionSubsampleDataBuffer.putShort((short) (unsignedIntToInt - i6));
                            } else {
                                this.encryptionSubsampleDataBuffer.putInt(unsignedIntToInt - i6);
                            }
                            i5++;
                            i6 = unsignedIntToInt;
                        }
                        int i7 = (i_renamed - this.sampleBytesRead) - i6;
                        if (i2 % 2 == 1) {
                            this.encryptionSubsampleDataBuffer.putInt(i7);
                        } else {
                            this.encryptionSubsampleDataBuffer.putShort((short) i7);
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i4);
                        trackOutput.sampleData(this.encryptionSubsampleData, i4);
                        this.sampleBytesWritten += i4;
                    }
                }
            } else if (track.sampleStrippedBytes != null) {
                this.sampleStrippedBytes.reset(track.sampleStrippedBytes, track.sampleStrippedBytes.length);
            }
            this.sampleEncodingHandled = true;
        }
        int iLimit = i_renamed + this.sampleStrippedBytes.limit();
        if (CODEC_ID_H264.equals(track.codecId) || CODEC_ID_H265.equals(track.codecId)) {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i8 = track.nalUnitLengthFieldLength;
            int i9 = 4 - track.nalUnitLengthFieldLength;
            while (this.sampleBytesRead < iLimit) {
                int i10 = this.sampleCurrentNalBytesRemaining;
                if (i10 == 0) {
                    readToTarget(extractorInput, bArr, i9, i8);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                } else {
                    this.sampleCurrentNalBytesRemaining = i10 - readToOutput(extractorInput, trackOutput, i10);
                }
            }
        } else {
            if (track.trueHdSampleRechunker != null) {
                com.google.android.exoplayer2.util.Assertions.checkState(this.sampleStrippedBytes.limit() == 0);
                track.trueHdSampleRechunker.startSample(extractorInput, this.blockFlags, iLimit);
            }
            while (true) {
                int i11 = this.sampleBytesRead;
                if (i11 >= iLimit) {
                    break;
                } else {
                    readToOutput(extractorInput, trackOutput, iLimit - i11);
                }
            }
        }
        if (CODEC_ID_VORBIS.equals(track.codecId)) {
            this.vorbisNumPageSamples.setPosition(0);
            trackOutput.sampleData(this.vorbisNumPageSamples, 4);
            this.sampleBytesWritten += 4;
        }
    }

    private void writeSubtitleSampleData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int length = bArr.length + i_renamed;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.data = java.util.Arrays.copyOf(bArr, length + i_renamed);
        } else {
            java.lang.System.arraycopy(bArr, 0, this.subtitleSample.data, 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.data, bArr.length, i_renamed);
        this.subtitleSample.reset(length);
    }

    private void commitSubtitleSample(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, java.lang.String str, int i_renamed, long j_renamed, byte[] bArr) {
        setSampleDuration(this.subtitleSample.data, this.blockDurationUs, str, i_renamed, j_renamed, bArr);
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = track.output;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.subtitleSample;
        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
        this.sampleBytesWritten += this.subtitleSample.limit();
    }

    private static void setSampleDuration(byte[] bArr, long j_renamed, java.lang.String str, int i_renamed, long j2, byte[] bArr2) {
        byte[] utf8Bytes;
        if (j_renamed == -9223372036854775807L) {
            utf8Bytes = bArr2;
        } else {
            int i2 = (int) (j_renamed / 3600000000L);
            long j3 = j_renamed - ((i2 * 3600) * 1000000);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - ((i3 * 60) * 1000000);
            int i4 = (int) (j4 / 1000000);
            utf8Bytes = com.google.android.exoplayer2.util.Util.getUtf8Bytes(java.lang.String.format(java.util.Locale.US, str, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf((int) ((j4 - (i4 * 1000000)) / j2))));
        }
        java.lang.System.arraycopy(utf8Bytes, 0, bArr, i_renamed, bArr2.length);
    }

    private void readToTarget(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
        int iMin = java.lang.Math.min(i2, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i_renamed + iMin, i2 - iMin);
        if (iMin > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i_renamed, iMin);
        }
        this.sampleBytesRead += i2;
    }

    private int readToOutput(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.TrackOutput trackOutput, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int iSampleData;
        int iBytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (iBytesLeft > 0) {
            iSampleData = java.lang.Math.min(i_renamed, iBytesLeft);
            trackOutput.sampleData(this.sampleStrippedBytes, iSampleData);
        } else {
            iSampleData = trackOutput.sampleData(extractorInput, i_renamed, false);
        }
        this.sampleBytesRead += iSampleData;
        this.sampleBytesWritten += iSampleData;
        return iSampleData;
    }

    private com.google.android.exoplayer2.extractor.SeekMap buildSeekMap() {
        com.google.android.exoplayer2.util.LongArray longArray;
        com.google.android.exoplayer2.util.LongArray longArray2;
        if (this.segmentContentPosition == -1 || this.durationUs == -9223372036854775807L || (longArray = this.cueTimesUs) == null || longArray.size() == 0 || (longArray2 = this.cueClusterPositions) == null || longArray2.size() != this.cueTimesUs.size()) {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.durationUs);
        }
        int size = this.cueTimesUs.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i_renamed = 0;
        for (int i2 = 0; i2 < size; i2++) {
            jArr3[i2] = this.cueTimesUs.get(i2);
            jArr[i2] = this.segmentContentPosition + this.cueClusterPositions.get(i2);
        }
        while (true) {
            int i3 = size - 1;
            if (i_renamed < i3) {
                int i4 = i_renamed + 1;
                iArr[i_renamed] = (int) (jArr[i4] - jArr[i_renamed]);
                jArr2[i_renamed] = jArr3[i4] - jArr3[i_renamed];
                i_renamed = i4;
            } else {
                iArr[i3] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i3]);
                jArr2[i3] = this.durationUs - jArr3[i3];
                this.cueTimesUs = null;
                this.cueClusterPositions = null;
                return new com.google.android.exoplayer2.extractor.ChunkIndex(iArr, jArr, jArr2, jArr3);
            }
        }
    }

    private boolean maybeSeekForCues(com.google.android.exoplayer2.extractor.PositionHolder positionHolder, long j_renamed) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j_renamed;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j2 = this.seekPositionAfterBuildingCues;
            if (j2 != -1) {
                positionHolder.position = j2;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    private long scaleTimecodeToUs(long j_renamed) throws com.google.android.exoplayer2.ParserException {
        long j2 = this.timecodeScale;
        if (j2 == -9223372036854775807L) {
            throw new com.google.android.exoplayer2.ParserException("Can't_renamed scale timecode prior to timecodeScale being set.");
        }
        return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j_renamed, j2, 1000L);
    }

    private static boolean isCodecSupported(java.lang.String str) {
        return CODEC_ID_VP8.equals(str) || CODEC_ID_VP9.equals(str) || CODEC_ID_AV1.equals(str) || CODEC_ID_MPEG2.equals(str) || CODEC_ID_MPEG4_SP.equals(str) || CODEC_ID_MPEG4_ASP.equals(str) || CODEC_ID_MPEG4_AP.equals(str) || CODEC_ID_H264.equals(str) || CODEC_ID_H265.equals(str) || CODEC_ID_FOURCC.equals(str) || CODEC_ID_THEORA.equals(str) || CODEC_ID_OPUS.equals(str) || CODEC_ID_VORBIS.equals(str) || CODEC_ID_AAC.equals(str) || CODEC_ID_MP2.equals(str) || CODEC_ID_MP3.equals(str) || CODEC_ID_AC3.equals(str) || CODEC_ID_E_AC3.equals(str) || CODEC_ID_TRUEHD.equals(str) || CODEC_ID_DTS.equals(str) || CODEC_ID_DTS_EXPRESS.equals(str) || CODEC_ID_DTS_LOSSLESS.equals(str) || CODEC_ID_FLAC.equals(str) || CODEC_ID_ACM.equals(str) || CODEC_ID_PCM_INT_LIT.equals(str) || CODEC_ID_SUBRIP.equals(str) || CODEC_ID_ASS.equals(str) || CODEC_ID_VOBSUB.equals(str) || CODEC_ID_PGS.equals(str) || CODEC_ID_DVBSUB.equals(str);
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i_renamed) {
        if (iArr == null) {
            return new int[i_renamed];
        }
        return iArr.length >= i_renamed ? iArr : new int[java.lang.Math.max(iArr.length * 2, i_renamed)];
    }

    private final class InnerEbmlReaderOutput implements com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput {
        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public int getElementType(int i_renamed) {
            switch (i_renamed) {
                case 131:
                case 136:
                case 155:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CHANNELS /* 159 */:
                case 176:
                case 179:
                case 186:
                case 215:
                case 231:
                case 241:
                case 251:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_DOC_TYPE_READ_VERSION /* 17029 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_EBML_READ_VERSION /* 17143 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCODING_ORDER /* 20529 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCODING_SCOPE /* 20530 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_SEEK_POSITION /* 21420 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_STEREO_MODE /* 21432 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_DISPLAY_WIDTH /* 21680 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_DISPLAY_UNIT /* 21682 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_DISPLAY_HEIGHT /* 21690 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_FLAG_FORCED /* 21930 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_COLOUR_RANGE /* 21945 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_COLOUR_TRANSFER /* 21946 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_COLOUR_PRIMARIES /* 21947 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_MAX_CLL /* 21948 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_MAX_FALL /* 21949 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CODEC_DELAY /* 22186 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_SEEK_PRE_ROLL /* 22203 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_AUDIO_BIT_DEPTH /* 25188 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PROJECTION_TYPE /* 30321 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_DEFAULT_DURATION /* 2352003 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_TIMECODE_SCALE /* 2807729 */:
                    return 2;
                case 134:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_DOC_TYPE /* 17026 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_NAME /* 21358 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_LANGUAGE /* 2274716 */:
                    return 3;
                case 160:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS /* 18407 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_SEEK /* 19899 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_COMPRESSION /* 20532 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCRYPTION /* 20533 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_COLOUR /* 21936 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_MASTERING_METADATA /* 21968 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCODING /* 25152 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCODINGS /* 28032 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PROJECTION /* 30320 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_SEEK_HEAD /* 290298740 */:
                case 357149030:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_TRACKS /* 374648427 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_SEGMENT /* 408125543 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_EBML /* 440786851 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CUES /* 475249515 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CLUSTER /* 524531317 */:
                    return 1;
                case 161:
                case 163:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_COMPRESSION_SETTINGS /* 16981 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CONTENT_ENCRYPTION_KEY_ID /* 18402 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_SEEK_ID /* 21419 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CODEC_PRIVATE /* 25506 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PROJECTION_PRIVATE /* 30322 */:
                    return 4;
                case 181:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_DURATION /* 17545 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_LUMNINANCE_MAX /* 21977 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_LUMNINANCE_MIN /* 21978 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PROJECTION_POSE_YAW /* 30323 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PROJECTION_POSE_PITCH /* 30324 */:
                case com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_PROJECTION_POSE_ROLL /* 30325 */:
                    return 5;
                default:
                    return 0;
            }
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public boolean isLevel1Element(int i_renamed) {
            return i_renamed == 357149030 || i_renamed == com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CLUSTER || i_renamed == com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_CUES || i_renamed == com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.ID_TRACKS;
        }

        private InnerEbmlReaderOutput() {
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void startMasterElement(int i_renamed, long j_renamed, long j2) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.startMasterElement(i_renamed, j_renamed, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void endMasterElement(int i_renamed) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.endMasterElement(i_renamed);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void integerElement(int i_renamed, long j_renamed) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.integerElement(i_renamed, j_renamed);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void floatElement(int i_renamed, double d_renamed) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.floatElement(i_renamed, d_renamed);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void stringElement(int i_renamed, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.stringElement(i_renamed, str);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void binaryElement(int i_renamed, int i2, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.binaryElement(i_renamed, i2, extractorInput);
        }
    }

    private static final class TrueHdSampleRechunker {
        private int blockFlags;
        private int chunkSize;
        private boolean foundSyncframe;
        private int sampleCount;
        private final byte[] syncframePrefix = new byte[10];
        private long timeUs;

        public void reset() {
            this.foundSyncframe = false;
        }

        public void startSample(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
            if (!this.foundSyncframe) {
                extractorInput.peekFully(this.syncframePrefix, 0, 10);
                extractorInput.resetPeekPosition();
                if (com.google.android.exoplayer2.audio.Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) == 0) {
                    return;
                }
                this.foundSyncframe = true;
                this.sampleCount = 0;
            }
            if (this.sampleCount == 0) {
                this.blockFlags = i_renamed;
                this.chunkSize = 0;
            }
            this.chunkSize += i2;
        }

        public void sampleMetadata(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, long j_renamed) {
            if (this.foundSyncframe) {
                int i_renamed = this.sampleCount;
                this.sampleCount = i_renamed + 1;
                if (i_renamed == 0) {
                    this.timeUs = j_renamed;
                }
                if (this.sampleCount < 16) {
                    return;
                }
                track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
                this.sampleCount = 0;
            }
        }

        public void outputPendingSampleMetadata(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track) {
            if (!this.foundSyncframe || this.sampleCount <= 0) {
                return;
            }
            track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
            this.sampleCount = 0;
        }
    }

    private static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public java.lang.String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public com.google.android.exoplayer2.drm.DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        private java.lang.String language;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public java.lang.String name;
        public int number;
        public com.google.android.exoplayer2.extractor.TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public float projectionPosePitch;
        public float projectionPoseRoll;
        public float projectionPoseYaw;
        public int projectionType;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionType = -1;
            this.projectionPoseYaw = 0.0f;
            this.projectionPosePitch = 0.0f;
            this.projectionPoseRoll = 0.0f;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0L;
            this.seekPreRollNs = 0L;
            this.flagDefault = true;
            this.language = "eng";
        }

        /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B_renamed:147:0x033e  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:148:0x0340  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:151:0x0348  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:152:0x036d  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:95:0x016a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput r33, int r34) throws com.google.android.exoplayer2.ParserException {
            /*
                Method dump skipped, instructions count: 1458
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput, int):void");
        }

        public void outputPendingSampleMetadata() {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this);
            }
        }

        public void reset() {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
            byteBufferWrap.put((byte) 0);
            byteBufferWrap.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) (this.maxMasteringLuminance + 0.5f));
            byteBufferWrap.putShort((short) (this.minMasteringLuminance + 0.5f));
            byteBufferWrap.putShort((short) this.maxContentLuminance);
            byteBufferWrap.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static android.util.Pair<java.lang.String, java.util.List<byte[]>> parseFourCcPrivate(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (littleEndianUnsignedInt == 1482049860) {
                    return new android.util.Pair<>(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H263, null);
                }
                if (littleEndianUnsignedInt == 826496599) {
                    byte[] bArr = parsableByteArray.data;
                    for (int position = parsableByteArray.getPosition() + 20; position < bArr.length - 4; position++) {
                        if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                            return new android.util.Pair<>(com.google.android.exoplayer2.util.MimeTypes.VIDEO_VC1, java.util.Collections.singletonList(java.util.Arrays.copyOfRange(bArr, position, bArr.length)));
                        }
                    }
                    throw new com.google.android.exoplayer2.ParserException("Failed to find FourCC VC1 initialization data");
                }
                com.google.android.exoplayer2.util.Log.w_renamed(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x_renamed-unknown");
                return new android.util.Pair<>(com.google.android.exoplayer2.util.MimeTypes.VIDEO_UNKNOWN, null);
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing FourCC private data");
            }
        }

        private static java.util.List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws com.google.android.exoplayer2.ParserException {
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

        private static boolean parseMsAcmCodecPrivate(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
            try {
                int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (littleEndianUnsignedShort == 1) {
                    return true;
                }
                if (littleEndianUnsignedShort != com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.WAVE_FORMAT_EXTENSIBLE) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                if (parsableByteArray.readLong() == com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits()) {
                    if (parsableByteArray.readLong() == com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing MS/ACM codec private");
            }
        }
    }
}
