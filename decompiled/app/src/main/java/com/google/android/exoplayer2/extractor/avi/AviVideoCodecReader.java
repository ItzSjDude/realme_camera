package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.avi.AviCodecReader;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;

/* loaded from: classes.dex */
final class AviVideoCodecReader extends AviCodecReader {
    private static final int AVC_PACKET_TYPE_AVC_NALU = 1;
    private static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int SHAPE_BINARY = 1;
    private static final int SHAPE_BINARY_ONLY = 2;
    private static final int SHAPE_GRAY_SCALE = 3;
    private static final int SHAPE_RECTANGULAR = 0;
    private static final String TAG = "AviVideoCodec";
    private static final int VIDEO_FRAME_BFRAME = 3;
    private static final int VIDEO_FRAME_KEYFRAME = 1;
    private static final int VIDEO_FRAME_PFRAME = 2;
    private static final int VIDEO_FRAME_SFRAME = 4;
    private static final int VIDEO_FRAME_UNKNOWN = 0;
    private static final int VIDEO_FRAME_VIDEO_INFO = 5;
    private long absFrameCount;
    private int absFrameNum;
    private long avcGopFrameCount;
    private int bottomPoc;
    private long frameCount;
    private int frameNumOffset;
    private long frameRate;
    private int frameType;
    private boolean hasOutputFormat;
    private int idrPicId;
    private boolean lastBottomFieldFlag;
    private int lastMmcoType;
    private String mMimeType;
    private int maxFrameNum;
    private int mmcoType;
    private ParsableByteArray nalLength;
    private ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;
    private int numRefFramesInPicOrderCntCycle;
    private int offsetForNonRefPic;
    private int[] offsetForRefFrame;
    private int offsetForTopToBottom;
    private int packageType;
    private long playStartTime;
    private NalUnitUtil.PpsData ppsData;
    private int prevFrameNum;
    private int prevFrameNumOffset;
    private int prevPicOrderCntLsb;
    private int prevPicOrderCntMsb;
    private int redundantPicCntPresentFlag;
    private NalUnitUtil.SpsData spsData;
    private int topPoc;
    private int weightedBipredIdc;
    private int weightedPredFlag;

    private static final int LogTransfer(int OplusGLSurfaceView_13) {
        int i2 = 16;
        int[] iArr = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        if (((-65536) & OplusGLSurfaceView_13) != 0) {
            OplusGLSurfaceView_13 >>= 16;
        } else {
            i2 = 0;
        }
        if ((65280 & OplusGLSurfaceView_13) != 0) {
            OplusGLSurfaceView_13 >>= 8;
            i2 += 8;
        }
        if ((OplusGLSurfaceView_13 & 240) != 0) {
            OplusGLSurfaceView_13 >>= 4;
            i2 += 4;
        }
        return i2 + iArr[OplusGLSurfaceView_13];
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0183 A[PHI: r2
      0x0183: PHI (r2v8 float) = (r2v7 float), (r2v7 float), (r2v7 float), (r2v7 float), (r2v7 float), (r2v10 float) binds: [B:77:0x0140, B:79:0x0146, B:89:0x016d, B:83:0x015a, B:84:0x015c, B:85:0x015e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.avi.AviVideoCodecReader.parseSpsNalUnit(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$SpsData");
    }

    public NalUnitUtil.SpsData parseSpsInfo(ParsableByteArray parsableByteArray) {
        int position;
        int OplusGLSurfaceView_13 = 0;
        int position2 = 0;
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                position = 0;
                break;
            }
            int unsignedByte = parsableByteArray.readUnsignedByte() & 255;
            if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 2) {
                if (unsignedByte == 1) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                    if (unsignedByte2 != 7) {
                        if (unsignedByte2 == 8) {
                            position = (parsableByteArray.getPosition() - OplusGLSurfaceView_13) - 2;
                            break;
                        }
                    } else {
                        position2 = parsableByteArray.getPosition();
                    }
                    OplusGLSurfaceView_13 = 0;
                }
            } else if (unsignedByte == 0) {
                OplusGLSurfaceView_13++;
            }
            if (unsignedByte != 0) {
                OplusGLSurfaceView_13 = 0;
            }
        }
        Log.m8318d(TAG, "H264: sps pos :" + position2 + "~" + position);
        int i2 = position - position2;
        byte[] bArr = new byte[i2];
        parsableByteArray.setPosition(position2);
        parsableByteArray.readBytes(bArr, 0, i2);
        return parseSpsNalUnit(bArr, 0, i2);
    }

    public NalUnitUtil.PpsData parsePpsNalUnit(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, OplusGLSurfaceView_13, i2);
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        boolean bit = parsableNalUnitBitArray.readBit();
        int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (unsignedExpGolombCodedInt3 > 0) {
            int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i3 = 0;
            if (unsignedExpGolombCodedInt4 == 0) {
                while (i3 <= unsignedExpGolombCodedInt3) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    i3++;
                }
            } else if (unsignedExpGolombCodedInt4 == 2) {
                while (i3 < unsignedExpGolombCodedInt3) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    i3++;
                }
            } else if (unsignedExpGolombCodedInt4 == 3 || unsignedExpGolombCodedInt4 == 4 || unsignedExpGolombCodedInt4 == 5) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            } else if (unsignedExpGolombCodedInt4 == 6) {
                int unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int i4 = 0;
                while (unsignedExpGolombCodedInt3 > 0) {
                    i4++;
                    unsignedExpGolombCodedInt3 >>= 1;
                }
                while (i3 < unsignedExpGolombCodedInt5 + 1) {
                    parsableNalUnitBitArray.skipBits(i4);
                    i3++;
                }
            }
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readBit();
        this.weightedBipredIdc = parsableNalUnitBitArray.readBits(2);
        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
            this.redundantPicCntPresentFlag = parsableNalUnitBitArray.readBits(3) & 1;
        }
        return new NalUnitUtil.PpsData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, bit);
    }

    public NalUnitUtil.PpsData parsePpsInfo(ParsableByteArray parsableByteArray) {
        int position;
        int OplusGLSurfaceView_13 = 0;
        int position2 = 0;
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                position = 0;
                break;
            }
            int unsignedByte = parsableByteArray.readUnsignedByte() & 255;
            if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 2) {
                if (unsignedByte == 1) {
                    if ((parsableByteArray.readUnsignedByte() & 31) == 8) {
                        position2 = parsableByteArray.getPosition();
                        OplusGLSurfaceView_13 = 0;
                    } else {
                        position = (parsableByteArray.getPosition() - OplusGLSurfaceView_13) - 2;
                        break;
                    }
                }
            } else if (unsignedByte == 0) {
                OplusGLSurfaceView_13++;
            }
            if (unsignedByte != 0) {
                OplusGLSurfaceView_13 = 0;
            }
        }
        Log.m8318d(TAG, "H264: pps pos :" + position2 + "~" + position);
        int i2 = position - position2;
        byte[] bArr = new byte[i2];
        parsableByteArray.setPosition(position2);
        parsableByteArray.readBytes(bArr, 0, i2);
        return parsePpsNalUnit(bArr, 0, i2);
    }

    public void parseDts(ParsableByteArray parsableByteArray) {
        int OplusGLSurfaceView_13 = this.packageType;
        if (OplusGLSurfaceView_13 != 7 && OplusGLSurfaceView_13 != 8) {
            if (OplusGLSurfaceView_13 == 5) {
                this.absFrameCount++;
                parseSliceHeader(parsableByteArray);
                return;
            } else {
                if (OplusGLSurfaceView_13 == 1) {
                    this.absFrameCount++;
                    parseSliceHeader(parsableByteArray);
                    return;
                }
                return;
            }
        }
        while (true) {
            int i2 = 0;
            while (parsableByteArray.bytesLeft() > 0) {
                int unsignedByte = parsableByteArray.readUnsignedByte() & 255;
                if (i2 == 3 || i2 == 2) {
                    if (unsignedByte == 1) {
                        if ((parsableByteArray.readUnsignedByte() & 31) == 5) {
                            this.packageType = 5;
                            this.absFrameCount++;
                            parseSliceHeader(parsableByteArray);
                            return;
                        }
                        i2 = 0;
                    }
                } else if (unsignedByte == 0) {
                    i2++;
                }
                if (unsignedByte != 0) {
                    break;
                }
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x014a A[ADDED_TO_REGION, EDGE_INSN: B:199:0x014a->B:95:0x014a BREAK  A[LOOP:0: B:81:0x0120->B:94:0x0145], REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0142 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parseSliceHeader(com.google.android.exoplayer2.util.ParsableByteArray r20) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.avi.AviVideoCodecReader.parseSliceHeader(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    public AviVideoCodecReader(TrackOutput trackOutput, String str, long OplusGLSurfaceView_15) {
        super(trackOutput);
        this.hasOutputFormat = false;
        this.maxFrameNum = 0;
        this.prevPicOrderCntMsb = 0;
        this.prevPicOrderCntLsb = 0;
        this.redundantPicCntPresentFlag = 0;
        this.weightedPredFlag = 0;
        this.weightedBipredIdc = 0;
        this.mmcoType = 0;
        this.lastMmcoType = 0;
        this.lastBottomFieldFlag = false;
        this.topPoc = 0;
        this.bottomPoc = 0;
        this.prevFrameNumOffset = 0;
        this.prevFrameNum = 0;
        this.frameNumOffset = 0;
        this.offsetForRefFrame = new int[255];
        this.numRefFramesInPicOrderCntCycle = 0;
        this.offsetForNonRefPic = 0;
        this.offsetForTopToBottom = 0;
        this.absFrameNum = 0;
        this.idrPicId = 0;
        this.frameCount = -1L;
        this.absFrameCount = -1L;
        this.avcGopFrameCount = -1L;
        this.playStartTime = 0L;
        this.spsData = null;
        this.ppsData = null;
        this.mMimeType = str;
        this.frameRate = OplusGLSurfaceView_15;
        if (this.mMimeType == MimeTypes.VIDEO_H264) {
            this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
            this.nalLength = new ParsableByteArray(4);
        }
    }

    public void seek(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        Log.m8318d(TAG, "Seek video internal process to time:" + j2 + "; position:" + OplusGLSurfaceView_15 + "; count:" + OplusGLSurfaceView_13);
        this.frameCount = -1L;
        this.playStartTime = j2;
        this.absFrameCount = (long) (OplusGLSurfaceView_13 + (-1));
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviCodecReader
    protected boolean parseHeader(ParsableByteArray parsableByteArray) throws AviCodecReader.UnsupportedFormatException {
        String str = this.mMimeType;
        if (str == "video") {
            throw new AviCodecReader.UnsupportedFormatException("Video codec format not supported");
        }
        if (str == MimeTypes.VIDEO_H264) {
            if (parsableByteArray.readUnsignedInt() == 1) {
                parsableByteArray.setPosition(0);
                return true;
            }
            Log.m8320e(TAG, "this is not h264 video");
            return false;
        }
        if (str == MimeTypes.VIDEO_MP4V) {
            if (parsableByteArray.readUnsignedInt24() == 1) {
                parsableByteArray.setPosition(0);
                return true;
            }
            Log.m8320e(TAG, "this is not mpeg4 video");
            return false;
        }
        Log.m8320e(TAG, "Unknown video codec, maybe not MPEG4/AVC");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x021f, code lost:
    
        r19 = 0;
        r20 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e5  */
    @Override // com.google.android.exoplayer2.extractor.avi.AviCodecReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void parseData(com.google.android.exoplayer2.util.ParsableByteArray r27, long r28) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.avi.AviVideoCodecReader.parseData(com.google.android.exoplayer2.util.ParsableByteArray, long):void");
    }
}
