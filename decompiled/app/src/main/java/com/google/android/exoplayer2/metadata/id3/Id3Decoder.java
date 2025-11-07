package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class Id3Decoder implements com.google.android.exoplayer2.metadata.MetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    private static final java.lang.String TAG = "Id3Decoder";
    private final com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate;
    public static final com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate NO_FRAMES_PREDICATE = new com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate() { // from class: com.google.android.exoplayer2.metadata.id3.-$$Lambda$Id3Decoder$7M0gB-IGKaTbyTVX-WCb62bIHyc
        @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
        public final boolean evaluate(int i_renamed, int i2, int i3, int i4, int i5) {
            return com.google.android.exoplayer2.metadata.id3.Id3Decoder.lambda$static$0(i_renamed, i2, i3, i4, i5);
        }
    };
    public static final int ID3_TAG = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ID3");

    public interface FramePredicate {
        boolean evaluate(int i_renamed, int i2, int i3, int i4, int i5);
    }

    private static int delimiterLength(int i_renamed) {
        return (i_renamed == 0 || i_renamed == 3) ? 1 : 2;
    }

    private static java.lang.String getCharsetName(int i_renamed) {
        return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? org.apache.commons.codec.CharEncoding.ISO_8859_1 : "UTF-8" : org.apache.commons.codec.CharEncoding.UTF_16BE : "UTF-16";
    }

    static /* synthetic */ boolean lambda$static$0(int i_renamed, int i2, int i3, int i4, int i5) {
        return false;
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) {
        this.framePredicate = framePredicate;
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer) {
        java.nio.ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public com.google.android.exoplayer2.metadata.Metadata decode(byte[] bArr, int i_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr, i_renamed);
        com.google.android.exoplayer2.metadata.id3.Id3Decoder.Id3Header id3HeaderDecodeHeader = decodeHeader(parsableByteArray);
        if (id3HeaderDecodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i2 = id3HeaderDecodeHeader.majorVersion == 2 ? 6 : 10;
        int iRemoveUnsynchronization = id3HeaderDecodeHeader.framesSize;
        if (id3HeaderDecodeHeader.isUnsynchronized) {
            iRemoveUnsynchronization = removeUnsynchronization(parsableByteArray, id3HeaderDecodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + iRemoveUnsynchronization);
        boolean z_renamed = false;
        if (!validateFrames(parsableByteArray, id3HeaderDecodeHeader.majorVersion, i2, false)) {
            if (id3HeaderDecodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i2, true)) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to validate ID3 tag with majorVersion=" + id3HeaderDecodeHeader.majorVersion);
                return null;
            }
            z_renamed = true;
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            com.google.android.exoplayer2.metadata.id3.Id3Frame id3FrameDecodeFrame = decodeFrame(id3HeaderDecodeHeader.majorVersion, parsableByteArray, z_renamed, i2, this.framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new com.google.android.exoplayer2.metadata.Metadata(arrayList);
    }

    private static com.google.android.exoplayer2.metadata.id3.Id3Decoder.Id3Header decodeHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 10) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Data too short to be_renamed an_renamed ID3 tag");
            return null;
        }
        int unsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (unsignedInt24 != ID3_TAG) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unexpected first three bytes of_renamed ID3 tag header: " + unsignedInt24);
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        int synchSafeInt = parsableByteArray.readSynchSafeInt();
        if (unsignedByte == 2) {
            if ((unsignedByte2 & 64) != 0) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (unsignedByte == 3) {
            if ((unsignedByte2 & 64) != 0) {
                int i_renamed = parsableByteArray.readInt();
                parsableByteArray.skipBytes(i_renamed);
                synchSafeInt -= i_renamed + 4;
            }
        } else {
            if (unsignedByte != 4) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipped ID3 tag with unsupported majorVersion=" + unsignedByte);
                return null;
            }
            if ((unsignedByte2 & 64) != 0) {
                int synchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(synchSafeInt2 - 4);
                synchSafeInt -= synchSafeInt2;
            }
            if ((unsignedByte2 & 16) != 0) {
                synchSafeInt -= 10;
            }
        }
        return new com.google.android.exoplayer2.metadata.id3.Id3Decoder.Id3Header(unsignedByte, unsignedByte < 4 && (unsignedByte2 & 128) != 0, synchSafeInt);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x0078 A_renamed[PHI: r3
      0x0078: PHI (r3v15 boolean) = (r3v5 boolean), (r3v18 boolean) binds: [B_renamed:40:0x0087, B_renamed:31:0x0076] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x007a A_renamed[PHI: r3
      0x007a: PHI (r3v7 boolean) = (r3v5 boolean), (r3v18 boolean) binds: [B_renamed:40:0x0087, B_renamed:31:0x0076] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean validateFrames(com.google.android.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.validateFrames(com.google.android.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:142:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:149:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:154:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:161:0x01f1 A_renamed[Catch: all -> 0x012f, UnsupportedEncodingException -> 0x021f, TryCatch #0 {UnsupportedEncodingException -> 0x021f, blocks: (B_renamed:91:0x011d, B_renamed:163:0x01fb, B_renamed:93:0x0125, B_renamed:102:0x013e, B_renamed:105:0x0148, B_renamed:113:0x0162, B_renamed:122:0x017a, B_renamed:134:0x0195, B_renamed:141:0x01a7, B_renamed:148:0x01b8, B_renamed:153:0x01d0, B_renamed:160:0x01ec, B_renamed:161:0x01f1), top: B_renamed:173:0x0113, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame decodeFrame(int r19, com.google.android.exoplayer2.util.ParsableByteArray r20, boolean r21, int r22, com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r23) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.decodeFrame(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame decodeTxxxFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws java.io.UnsupportedEncodingException {
        if (i_renamed < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String charsetName = getCharsetName(unsignedByte);
        int i2 = i_renamed - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int iIndexOfEos = indexOfEos(bArr, 0, unsignedByte);
        java.lang.String str = new java.lang.String(bArr, 0, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame("TXXX", str, decodeStringIfValid(bArr, iDelimiterLength, indexOfEos(bArr, iDelimiterLength, unsignedByte), charsetName));
    }

    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame decodeTextInformationFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, java.lang.String str) throws java.io.UnsupportedEncodingException {
        if (i_renamed < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String charsetName = getCharsetName(unsignedByte);
        int i2 = i_renamed - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, new java.lang.String(bArr, 0, indexOfEos(bArr, 0, unsignedByte), charsetName));
    }

    private static com.google.android.exoplayer2.metadata.id3.UrlLinkFrame decodeWxxxFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws java.io.UnsupportedEncodingException {
        if (i_renamed < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String charsetName = getCharsetName(unsignedByte);
        int i2 = i_renamed - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int iIndexOfEos = indexOfEos(bArr, 0, unsignedByte);
        java.lang.String str = new java.lang.String(bArr, 0, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, iDelimiterLength, indexOfZeroByte(bArr, iDelimiterLength), org.apache.commons.codec.CharEncoding.ISO_8859_1));
    }

    private static com.google.android.exoplayer2.metadata.id3.UrlLinkFrame decodeUrlLinkFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, java.lang.String str) throws java.io.UnsupportedEncodingException {
        byte[] bArr = new byte[i_renamed];
        parsableByteArray.readBytes(bArr, 0, i_renamed);
        return new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame(str, null, new java.lang.String(bArr, 0, indexOfZeroByte(bArr, 0), org.apache.commons.codec.CharEncoding.ISO_8859_1));
    }

    private static com.google.android.exoplayer2.metadata.id3.PrivFrame decodePrivFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws java.io.UnsupportedEncodingException {
        byte[] bArr = new byte[i_renamed];
        parsableByteArray.readBytes(bArr, 0, i_renamed);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new com.google.android.exoplayer2.metadata.id3.PrivFrame(new java.lang.String(bArr, 0, iIndexOfZeroByte, org.apache.commons.codec.CharEncoding.ISO_8859_1), copyOfRangeIfValid(bArr, iIndexOfZeroByte + 1, bArr.length));
    }

    private static com.google.android.exoplayer2.metadata.id3.GeobFrame decodeGeobFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws java.io.UnsupportedEncodingException {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String charsetName = getCharsetName(unsignedByte);
        int i2 = i_renamed - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        java.lang.String str = new java.lang.String(bArr, 0, iIndexOfZeroByte, org.apache.commons.codec.CharEncoding.ISO_8859_1);
        int i3 = iIndexOfZeroByte + 1;
        int iIndexOfEos = indexOfEos(bArr, i3, unsignedByte);
        java.lang.String strDecodeStringIfValid = decodeStringIfValid(bArr, i3, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        int iIndexOfEos2 = indexOfEos(bArr, iDelimiterLength, unsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.GeobFrame(str, strDecodeStringIfValid, decodeStringIfValid(bArr, iDelimiterLength, iIndexOfEos2, charsetName), copyOfRangeIfValid(bArr, iIndexOfEos2 + delimiterLength(unsignedByte), bArr.length));
    }

    private static com.google.android.exoplayer2.metadata.id3.ApicFrame decodeApicFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, int i2) throws java.io.UnsupportedEncodingException {
        int iIndexOfZeroByte;
        java.lang.String str;
        int unsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String charsetName = getCharsetName(unsignedByte);
        int i3 = i_renamed - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + com.google.android.exoplayer2.util.Util.toLowerInvariant(new java.lang.String(bArr, 0, 3, org.apache.commons.codec.CharEncoding.ISO_8859_1));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            iIndexOfZeroByte = 2;
        } else {
            iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
            java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(new java.lang.String(bArr, 0, iIndexOfZeroByte, org.apache.commons.codec.CharEncoding.ISO_8859_1));
            if (lowerInvariant.indexOf(47) == -1) {
                str = "image/" + lowerInvariant;
            } else {
                str = lowerInvariant;
            }
        }
        int i4 = bArr[iIndexOfZeroByte + 1] & 255;
        int i5 = iIndexOfZeroByte + 2;
        int iIndexOfEos = indexOfEos(bArr, i5, unsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.ApicFrame(str, new java.lang.String(bArr, i5, iIndexOfEos - i5, charsetName), i4, copyOfRangeIfValid(bArr, iIndexOfEos + delimiterLength(unsignedByte), bArr.length));
    }

    private static com.google.android.exoplayer2.metadata.id3.CommentFrame decodeCommentFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws java.io.UnsupportedEncodingException {
        if (i_renamed < 4) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        java.lang.String charsetName = getCharsetName(unsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        java.lang.String str = new java.lang.String(bArr, 0, 3);
        int i2 = i_renamed - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int iIndexOfEos = indexOfEos(bArr2, 0, unsignedByte);
        java.lang.String str2 = new java.lang.String(bArr2, 0, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        return new com.google.android.exoplayer2.metadata.id3.CommentFrame(str, str2, decodeStringIfValid(bArr2, iDelimiterLength, indexOfEos(bArr2, iDelimiterLength, unsignedByte), charsetName));
    }

    private static com.google.android.exoplayer2.metadata.id3.ChapterFrame decodeChapterFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, int i2, boolean z_renamed, int i3, com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) throws java.io.UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int iIndexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        java.lang.String str = new java.lang.String(parsableByteArray.data, position, iIndexOfZeroByte - position, org.apache.commons.codec.CharEncoding.ISO_8859_1);
        parsableByteArray.setPosition(iIndexOfZeroByte + 1);
        int i4 = parsableByteArray.readInt();
        int i5 = parsableByteArray.readInt();
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long j_renamed = unsignedInt == 4294967295L ? -1L : unsignedInt;
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        long j2 = unsignedInt2 == 4294967295L ? -1L : unsignedInt2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i6 = position + i_renamed;
        while (parsableByteArray.getPosition() < i6) {
            com.google.android.exoplayer2.metadata.id3.Id3Frame id3FrameDecodeFrame = decodeFrame(i2, parsableByteArray, z_renamed, i3, framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        com.google.android.exoplayer2.metadata.id3.Id3Frame[] id3FrameArr = new com.google.android.exoplayer2.metadata.id3.Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new com.google.android.exoplayer2.metadata.id3.ChapterFrame(str, i4, i5, j_renamed, j2, id3FrameArr);
    }

    private static com.google.android.exoplayer2.metadata.id3.ChapterTocFrame decodeChapterTOCFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, int i2, boolean z_renamed, int i3, com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate framePredicate) throws java.io.UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int iIndexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        java.lang.String str = new java.lang.String(parsableByteArray.data, position, iIndexOfZeroByte - position, org.apache.commons.codec.CharEncoding.ISO_8859_1);
        parsableByteArray.setPosition(iIndexOfZeroByte + 1);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (unsignedByte & 2) != 0;
        boolean z3 = (unsignedByte & 1) != 0;
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        java.lang.String[] strArr = new java.lang.String[unsignedByte2];
        for (int i4 = 0; i4 < unsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int iIndexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, position2);
            strArr[i4] = new java.lang.String(parsableByteArray.data, position2, iIndexOfZeroByte2 - position2, org.apache.commons.codec.CharEncoding.ISO_8859_1);
            parsableByteArray.setPosition(iIndexOfZeroByte2 + 1);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i5 = position + i_renamed;
        while (parsableByteArray.getPosition() < i5) {
            com.google.android.exoplayer2.metadata.id3.Id3Frame id3FrameDecodeFrame = decodeFrame(i2, parsableByteArray, z_renamed, i3, framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        com.google.android.exoplayer2.metadata.id3.Id3Frame[] id3FrameArr = new com.google.android.exoplayer2.metadata.id3.Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new com.google.android.exoplayer2.metadata.id3.ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static com.google.android.exoplayer2.metadata.id3.MlltFrame decodeMlltFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedInt24 = parsableByteArray.readUnsignedInt24();
        int unsignedInt242 = parsableByteArray.readUnsignedInt24();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i2 = ((i_renamed - 10) * 8) / (unsignedByte + unsignedByte2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int bits = parsableBitArray.readBits(unsignedByte);
            int bits2 = parsableBitArray.readBits(unsignedByte2);
            iArr[i3] = bits;
            iArr2[i3] = bits2;
        }
        return new com.google.android.exoplayer2.metadata.id3.MlltFrame(unsignedShort, unsignedInt24, unsignedInt242, iArr, iArr2);
    }

    private static com.google.android.exoplayer2.metadata.id3.BinaryFrame decodeBinaryFrame(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, java.lang.String str) {
        byte[] bArr = new byte[i_renamed];
        parsableByteArray.readBytes(bArr, 0, i_renamed);
        return new com.google.android.exoplayer2.metadata.id3.BinaryFrame(str, bArr);
    }

    private static int removeUnsynchronization(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i2 = position + 1;
            if (i2 >= i_renamed) {
                return i_renamed;
            }
            if ((bArr[position] & 255) == 255 && bArr[i2] == 0) {
                java.lang.System.arraycopy(bArr, position + 2, bArr, i2, (i_renamed - position) - 2);
                i_renamed--;
            }
            position = i2;
        }
    }

    private static java.lang.String getFrameId(int i_renamed, int i2, int i3, int i4, int i5) {
        return i_renamed == 2 ? java.lang.String.format(java.util.Locale.US, "%c_renamed%c_renamed%c_renamed", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4)) : java.lang.String.format(java.util.Locale.US, "%c_renamed%c_renamed%c_renamed%c_renamed", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5));
    }

    private static int indexOfEos(byte[] bArr, int i_renamed, int i2) {
        int iIndexOfZeroByte = indexOfZeroByte(bArr, i_renamed);
        if (i2 == 0 || i2 == 3) {
            return iIndexOfZeroByte;
        }
        while (iIndexOfZeroByte < bArr.length - 1) {
            if (iIndexOfZeroByte % 2 == 0 && bArr[iIndexOfZeroByte + 1] == 0) {
                return iIndexOfZeroByte;
            }
            iIndexOfZeroByte = indexOfZeroByte(bArr, iIndexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i_renamed) {
        while (i_renamed < bArr.length) {
            if (bArr[i_renamed] == 0) {
                return i_renamed;
            }
            i_renamed++;
        }
        return bArr.length;
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i_renamed, int i2) {
        if (i2 <= i_renamed) {
            return com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
        }
        return java.util.Arrays.copyOfRange(bArr, i_renamed, i2);
    }

    private static java.lang.String decodeStringIfValid(byte[] bArr, int i_renamed, int i2, java.lang.String str) throws java.io.UnsupportedEncodingException {
        return (i2 <= i_renamed || i2 > bArr.length) ? "" : new java.lang.String(bArr, i_renamed, i2 - i_renamed, str);
    }

    private static final class Id3Header {
        private final int framesSize;
        private final boolean isUnsynchronized;
        private final int majorVersion;

        public Id3Header(int i_renamed, boolean z_renamed, int i2) {
            this.majorVersion = i_renamed;
            this.isUnsynchronized = z_renamed;
            this.framesSize = i2;
        }
    }
}
