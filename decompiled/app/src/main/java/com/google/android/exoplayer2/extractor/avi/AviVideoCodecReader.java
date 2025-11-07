package com.google.android.exoplayer2.extractor.avi;

/* loaded from: classes.dex */
final class AviVideoCodecReader extends com.google.android.exoplayer2.extractor.avi.AviCodecReader {
    private static final int AVC_PACKET_TYPE_AVC_NALU = 1;
    private static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int SHAPE_BINARY = 1;
    private static final int SHAPE_BINARY_ONLY = 2;
    private static final int SHAPE_GRAY_SCALE = 3;
    private static final int SHAPE_RECTANGULAR = 0;
    private static final java.lang.String TAG = "AviVideoCodec";
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
    private java.lang.String mMimeType;
    private int maxFrameNum;
    private int mmcoType;
    private com.google.android.exoplayer2.util.ParsableByteArray nalLength;
    private com.google.android.exoplayer2.util.ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;
    private int numRefFramesInPicOrderCntCycle;
    private int offsetForNonRefPic;
    private int[] offsetForRefFrame;
    private int offsetForTopToBottom;
    private int packageType;
    private long playStartTime;
    private com.google.android.exoplayer2.util.NalUnitUtil.PpsData ppsData;
    private int prevFrameNum;
    private int prevFrameNumOffset;
    private int prevPicOrderCntLsb;
    private int prevPicOrderCntMsb;
    private int redundantPicCntPresentFlag;
    private com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData;
    private int topPoc;
    private int weightedBipredIdc;
    private int weightedPredFlag;

    private static final int LogTransfer(int i_renamed) {
        int i2 = 16;
        int[] iArr = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        if (((-65536) & i_renamed) != 0) {
            i_renamed >>= 16;
        } else {
            i2 = 0;
        }
        if ((65280 & i_renamed) != 0) {
            i_renamed >>= 8;
            i2 += 8;
        }
        if ((i_renamed & 240) != 0) {
            i_renamed >>= 4;
            i2 += 4;
        }
        return i2 + iArr[i_renamed];
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:63:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:66:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:90:0x0183 A_renamed[PHI: r2
      0x0183: PHI (r2v8 float) = (r2v7 float), (r2v7 float), (r2v7 float), (r2v7 float), (r2v7 float), (r2v10 float) binds: [B_renamed:77:0x0140, B_renamed:79:0x0146, B_renamed:89:0x016d, B_renamed:83:0x015a, B_renamed:84:0x015c, B_renamed:85:0x015e] A_renamed[DONT_GENERATE, DONT_INLINE]] */
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

    public com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsInfo(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position;
        int i_renamed = 0;
        int position2 = 0;
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                position = 0;
                break;
            }
            int unsignedByte = parsableByteArray.readUnsignedByte() & 255;
            if (i_renamed == 3 || i_renamed == 2) {
                if (unsignedByte == 1) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                    if (unsignedByte2 != 7) {
                        if (unsignedByte2 == 8) {
                            position = (parsableByteArray.getPosition() - i_renamed) - 2;
                            break;
                        }
                    } else {
                        position2 = parsableByteArray.getPosition();
                    }
                    i_renamed = 0;
                }
            } else if (unsignedByte == 0) {
                i_renamed++;
            }
            if (unsignedByte != 0) {
                i_renamed = 0;
            }
        }
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "H264: sps pos :" + position2 + "~" + position);
        int i2 = position - position2;
        byte[] bArr = new byte[i2];
        parsableByteArray.setPosition(position2);
        parsableByteArray.readBytes(bArr, 0, i2);
        return parseSpsNalUnit(bArr, 0, i2);
    }

    public com.google.android.exoplayer2.util.NalUnitUtil.PpsData parsePpsNalUnit(byte[] bArr, int i_renamed, int i2) {
        com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(bArr, i_renamed, i2);
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
        return new com.google.android.exoplayer2.util.NalUnitUtil.PpsData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, bit);
    }

    public com.google.android.exoplayer2.util.NalUnitUtil.PpsData parsePpsInfo(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position;
        int i_renamed = 0;
        int position2 = 0;
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                position = 0;
                break;
            }
            int unsignedByte = parsableByteArray.readUnsignedByte() & 255;
            if (i_renamed == 3 || i_renamed == 2) {
                if (unsignedByte == 1) {
                    if ((parsableByteArray.readUnsignedByte() & 31) == 8) {
                        position2 = parsableByteArray.getPosition();
                        i_renamed = 0;
                    } else {
                        position = (parsableByteArray.getPosition() - i_renamed) - 2;
                        break;
                    }
                }
            } else if (unsignedByte == 0) {
                i_renamed++;
            }
            if (unsignedByte != 0) {
                i_renamed = 0;
            }
        }
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "H264: pps pos :" + position2 + "~" + position);
        int i2 = position - position2;
        byte[] bArr = new byte[i2];
        parsableByteArray.setPosition(position2);
        parsableByteArray.readBytes(bArr, 0, i2);
        return parsePpsNalUnit(bArr, 0, i2);
    }

    public void parseDts(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i_renamed = this.packageType;
        if (i_renamed != 7 && i_renamed != 8) {
            if (i_renamed == 5) {
                this.absFrameCount++;
                parseSliceHeader(parsableByteArray);
                return;
            } else {
                if (i_renamed == 1) {
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

    /* JADX WARN: Removed duplicated region for block: B_renamed:104:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:124:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:199:0x014a A_renamed[ADDED_TO_REGION, EDGE_INSN: B_renamed:199:0x014a->B_renamed:95:0x014a BREAK  A_renamed[LOOP:0: B_renamed:81:0x0120->B_renamed:94:0x0145], REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:64:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:66:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:69:0x00fb A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:75:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:78:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:92:0x0142 A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:97:0x0152  */
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

    public AviVideoCodecReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, java.lang.String str, long j_renamed) {
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
        this.frameRate = j_renamed;
        if (this.mMimeType == com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264) {
            this.nalStartCode = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
            this.nalLength = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        }
    }

    public void seek(long j_renamed, long j2, int i_renamed) {
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Seek video internal process to time:" + j2 + "; position:" + j_renamed + "; count:" + i_renamed);
        this.frameCount = -1L;
        this.playStartTime = j2;
        this.absFrameCount = (long) (i_renamed + (-1));
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviCodecReader
    protected boolean parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.extractor.avi.AviCodecReader.UnsupportedFormatException {
        java.lang.String str = this.mMimeType;
        if (str == "video") {
            throw new com.google.android.exoplayer2.extractor.avi.AviCodecReader.UnsupportedFormatException("Video codec format not supported");
        }
        if (str == com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264) {
            if (parsableByteArray.readUnsignedInt() == 1) {
                parsableByteArray.setPosition(0);
                return true;
            }
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "this is_renamed not h264 video");
            return false;
        }
        if (str == com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4V) {
            if (parsableByteArray.readUnsignedInt24() == 1) {
                parsableByteArray.setPosition(0);
                return true;
            }
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "this is_renamed not mpeg4 video");
            return false;
        }
        com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unknown video codec, maybe not MPEG4/AVC");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:92:0x021f, code lost:
    
        r19 = 0;
        r20 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B_renamed:60:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:66:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:75:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:78:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:81:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:83:0x01e5  */
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
