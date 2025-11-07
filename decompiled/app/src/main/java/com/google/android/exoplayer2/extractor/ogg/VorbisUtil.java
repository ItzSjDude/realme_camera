package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
final class VorbisUtil {
    private static final java.lang.String TAG = "VorbisUtil";

    public static int iLog(int i_renamed) {
        int i2 = 0;
        while (i_renamed > 0) {
            i2++;
            i_renamed >>>= 1;
        }
        return i2;
    }

    public static com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader readVorbisIdentificationHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        long littleEndianUnsignedInt2 = parsableByteArray.readLittleEndianUnsignedInt();
        int littleEndianInt = parsableByteArray.readLittleEndianInt();
        int littleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int littleEndianInt3 = parsableByteArray.readLittleEndianInt();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        return new com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader(littleEndianUnsignedInt, unsignedByte, littleEndianUnsignedInt2, littleEndianInt, littleEndianInt2, littleEndianInt3, (int) java.lang.Math.pow(2.0d, unsignedByte2 & 15), (int) java.lang.Math.pow(2.0d, (unsignedByte2 & 240) >> 4), (parsableByteArray.readUnsignedByte() & 1) > 0, java.util.Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit()));
    }

    public static com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CommentHeader readVorbisCommentHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        java.lang.String string = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = 11 + string.length();
        long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        java.lang.String[] strArr = new java.lang.String[(int) littleEndianUnsignedInt];
        int length2 = length + 4;
        for (int i_renamed = 0; i_renamed < littleEndianUnsignedInt; i_renamed++) {
            strArr[i_renamed] = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            length2 = length2 + 4 + strArr[i_renamed].length();
        }
        if ((parsableByteArray.readUnsignedByte() & 1) == 0) {
            throw new com.google.android.exoplayer2.ParserException("framing bit expected to be_renamed set");
        }
        return new com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CommentHeader(string, strArr, length2 + 1);
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i_renamed, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z_renamed) throws com.google.android.exoplayer2.ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z_renamed) {
                return false;
            }
            throw new com.google.android.exoplayer2.ParserException("too short header: " + parsableByteArray.bytesLeft());
        }
        if (parsableByteArray.readUnsignedByte() != i_renamed) {
            if (z_renamed) {
                return false;
            }
            throw new com.google.android.exoplayer2.ParserException("expected header type " + java.lang.Integer.toHexString(i_renamed));
        }
        if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        }
        if (z_renamed) {
            return false;
        }
        throw new com.google.android.exoplayer2.ParserException("expected characters 'vorbis'");
    }

    public static com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode[] readVorbisModes(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws com.google.android.exoplayer2.ParserException {
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int unsignedByte = parsableByteArray.readUnsignedByte() + 1;
        com.google.android.exoplayer2.extractor.ogg.VorbisBitArray vorbisBitArray = new com.google.android.exoplayer2.extractor.ogg.VorbisBitArray(parsableByteArray.data);
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i2 = 0; i2 < unsignedByte; i2++) {
            readBook(vorbisBitArray);
        }
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i3 = 0; i3 < bits; i3++) {
            if (vorbisBitArray.readBits(16) != 0) {
                throw new com.google.android.exoplayer2.ParserException("placeholder of_renamed time domain transforms not zeroed out");
            }
        }
        readFloors(vorbisBitArray);
        readResidues(vorbisBitArray);
        readMappings(i_renamed, vorbisBitArray);
        com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode[] modes = readModes(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return modes;
        }
        throw new com.google.android.exoplayer2.ParserException("framing bit after modes not set as_renamed expected");
    }

    private static com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode[] readModes(com.google.android.exoplayer2.extractor.ogg.VorbisBitArray vorbisBitArray) {
        int bits = vorbisBitArray.readBits(6) + 1;
        com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode[] modeArr = new com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode[bits];
        for (int i_renamed = 0; i_renamed < bits; i_renamed++) {
            modeArr[i_renamed] = new com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    private static void readMappings(int i_renamed, com.google.android.exoplayer2.extractor.ogg.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i2 = 0; i2 < bits; i2++) {
            int bits2 = vorbisBitArray.readBits(16);
            if (bits2 == 0) {
                int bits3 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                if (vorbisBitArray.readBit()) {
                    int bits4 = vorbisBitArray.readBits(8) + 1;
                    for (int i3 = 0; i3 < bits4; i3++) {
                        int i4 = i_renamed - 1;
                        vorbisBitArray.skipBits(iLog(i4));
                        vorbisBitArray.skipBits(iLog(i4));
                    }
                }
                if (vorbisBitArray.readBits(2) != 0) {
                    throw new com.google.android.exoplayer2.ParserException("to reserved bits must be_renamed zero after mapping coupling steps");
                }
                if (bits3 > 1) {
                    for (int i5 = 0; i5 < i_renamed; i5++) {
                        vorbisBitArray.skipBits(4);
                    }
                }
                for (int i6 = 0; i6 < bits3; i6++) {
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                }
            } else {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "mapping type other than 0 not supported: " + bits2);
            }
        }
    }

    private static void readResidues(com.google.android.exoplayer2.extractor.ogg.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i_renamed = 0; i_renamed < bits; i_renamed++) {
            if (vorbisBitArray.readBits(16) > 2) {
                throw new com.google.android.exoplayer2.ParserException("residueType greater than 2 is_renamed not decodable");
            }
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            int bits2 = vorbisBitArray.readBits(6) + 1;
            vorbisBitArray.skipBits(8);
            int[] iArr = new int[bits2];
            for (int i2 = 0; i2 < bits2; i2++) {
                iArr[i2] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
            }
            for (int i3 = 0; i3 < bits2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        vorbisBitArray.skipBits(8);
                    }
                }
            }
        }
    }

    private static void readFloors(com.google.android.exoplayer2.extractor.ogg.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i_renamed = 0; i_renamed < bits; i_renamed++) {
            int bits2 = vorbisBitArray.readBits(16);
            if (bits2 == 0) {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int bits3 = vorbisBitArray.readBits(4) + 1;
                for (int i2 = 0; i2 < bits3; i2++) {
                    vorbisBitArray.skipBits(8);
                }
            } else if (bits2 == 1) {
                int bits4 = vorbisBitArray.readBits(5);
                int[] iArr = new int[bits4];
                int i3 = -1;
                for (int i4 = 0; i4 < bits4; i4++) {
                    iArr[i4] = vorbisBitArray.readBits(4);
                    if (iArr[i4] > i3) {
                        i3 = iArr[i4];
                    }
                }
                int[] iArr2 = new int[i3 + 1];
                for (int i5 = 0; i5 < iArr2.length; i5++) {
                    iArr2[i5] = vorbisBitArray.readBits(3) + 1;
                    int bits5 = vorbisBitArray.readBits(2);
                    if (bits5 > 0) {
                        vorbisBitArray.skipBits(8);
                    }
                    for (int i6 = 0; i6 < (1 << bits5); i6++) {
                        vorbisBitArray.skipBits(8);
                    }
                }
                vorbisBitArray.skipBits(2);
                int bits6 = vorbisBitArray.readBits(4);
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < bits4; i9++) {
                    i7 += iArr2[iArr[i9]];
                    while (i8 < i7) {
                        vorbisBitArray.skipBits(bits6);
                        i8++;
                    }
                }
            } else {
                throw new com.google.android.exoplayer2.ParserException("floor type greater than 1 not decodable: " + bits2);
            }
        }
    }

    private static com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CodeBook readBook(com.google.android.exoplayer2.extractor.ogg.VorbisBitArray vorbisBitArray) throws com.google.android.exoplayer2.ParserException {
        if (vorbisBitArray.readBits(24) != 5653314) {
            throw new com.google.android.exoplayer2.ParserException("expected code book to start with [0x56, 0x43, 0x42] at_renamed " + vorbisBitArray.getPosition());
        }
        int bits = vorbisBitArray.readBits(16);
        int bits2 = vorbisBitArray.readBits(24);
        long[] jArr = new long[bits2];
        boolean bit = vorbisBitArray.readBit();
        long jMapType1QuantValues = 0;
        if (!bit) {
            boolean bit2 = vorbisBitArray.readBit();
            for (int i_renamed = 0; i_renamed < jArr.length; i_renamed++) {
                if (bit2) {
                    if (vorbisBitArray.readBit()) {
                        jArr[i_renamed] = vorbisBitArray.readBits(5) + 1;
                    } else {
                        jArr[i_renamed] = 0;
                    }
                } else {
                    jArr[i_renamed] = vorbisBitArray.readBits(5) + 1;
                }
            }
        } else {
            int bits3 = vorbisBitArray.readBits(5) + 1;
            int i2 = 0;
            while (i2 < jArr.length) {
                int bits4 = vorbisBitArray.readBits(iLog(bits2 - i2));
                int i3 = i2;
                for (int i4 = 0; i4 < bits4 && i3 < jArr.length; i4++) {
                    jArr[i3] = bits3;
                    i3++;
                }
                bits3++;
                i2 = i3;
            }
        }
        int bits5 = vorbisBitArray.readBits(4);
        if (bits5 > 2) {
            throw new com.google.android.exoplayer2.ParserException("lookup type greater than 2 not decodable: " + bits5);
        }
        if (bits5 == 1 || bits5 == 2) {
            vorbisBitArray.skipBits(32);
            vorbisBitArray.skipBits(32);
            int bits6 = vorbisBitArray.readBits(4) + 1;
            vorbisBitArray.skipBits(1);
            if (bits5 != 1) {
                jMapType1QuantValues = bits2 * bits;
            } else if (bits != 0) {
                jMapType1QuantValues = mapType1QuantValues(bits2, bits);
            }
            vorbisBitArray.skipBits((int) (jMapType1QuantValues * bits6));
        }
        return new com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CodeBook(bits, bits2, jArr, bits5, bit);
    }

    private static long mapType1QuantValues(long j_renamed, long j2) {
        return (long) java.lang.Math.floor(java.lang.Math.pow(j_renamed, 1.0d / j2));
    }

    private VorbisUtil() {
    }

    public static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i_renamed, int i2, long[] jArr, int i3, boolean z_renamed) {
            this.dimensions = i_renamed;
            this.entries = i2;
            this.lengthMap = jArr;
            this.lookupType = i3;
            this.isOrdered = z_renamed;
        }
    }

    public static final class CommentHeader {
        public final java.lang.String[] comments;
        public final int length;
        public final java.lang.String vendor;

        public CommentHeader(java.lang.String str, java.lang.String[] strArr, int i_renamed) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i_renamed;
        }
    }

    public static final class VorbisIdHeader {
        public final int bitrateMax;
        public final int bitrateMin;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final long sampleRate;
        public final long version;

        public VorbisIdHeader(long j_renamed, int i_renamed, long j2, int i2, int i3, int i4, int i5, int i6, boolean z_renamed, byte[] bArr) {
            this.version = j_renamed;
            this.channels = i_renamed;
            this.sampleRate = j2;
            this.bitrateMax = i2;
            this.bitrateNominal = i3;
            this.bitrateMin = i4;
            this.blockSize0 = i5;
            this.blockSize1 = i6;
            this.framingFlag = z_renamed;
            this.data = bArr;
        }

        public int getApproximateBitrate() {
            int i_renamed = this.bitrateNominal;
            return i_renamed == 0 ? (this.bitrateMin + this.bitrateMax) / 2 : i_renamed;
        }
    }

    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z_renamed, int i_renamed, int i2, int i3) {
            this.blockFlag = z_renamed;
            this.windowType = i_renamed;
            this.transformType = i2;
            this.mapping = i3;
        }
    }
}
