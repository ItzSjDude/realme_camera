package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusExifParser {
    protected static final short BIG_ENDIAN_TAG = 19789;
    protected static final int DEFAULT_IFD0_OFFSET = 8;
    public static final int EVENT_COMPRESSED_IMAGE = 3;
    public static final int EVENT_END = 5;
    public static final int EVENT_NEW_TAG = 1;
    public static final int EVENT_START_OF_IFD = 0;
    public static final int EVENT_UNCOMPRESSED_STRIP = 4;
    public static final int EVENT_VALUE_OF_REGISTERED_TAG = 2;
    protected static final int EXIF_HEADER = 1165519206;
    protected static final short EXIF_HEADER_TAIL = 0;
    protected static final short LITTLE_ENDIAN_TAG = 18761;
    private static final boolean LOGV = false;
    protected static final int OFFSET_SIZE = 2;
    public static final int OPTION_IFD_0 = 1;
    public static final int OPTION_IFD_1 = 2;
    public static final int OPTION_IFD_EXIF = 4;
    public static final int OPTION_IFD_GPS = 8;
    public static final int OPTION_IFD_INTEROPERABILITY = 16;
    public static final int OPTION_THUMBNAIL = 32;
    private static final java.lang.String TAG = "ExifParser";
    protected static final int TAG_SIZE = 12;
    protected static final short TIFF_HEADER_TAIL = 42;
    private int mApp1End;
    private boolean mContainExifData;
    private byte[] mDataAboveIfd0;
    private int mIfd0Position;
    private int mIfdType;
    private com.oplus.exif.OplusExifParser.ImageEvent mImageEvent;
    private final com.oplus.exif.OplusExifInterface mInterface;
    private com.oplus.exif.OplusExifTag mJpegSizeTag;
    private boolean mNeedToParseOffsetsInCurrentIfd;
    private final int mOptions;
    private int mStripCount;
    private com.oplus.exif.OplusExifTag mStripSizeTag;
    private com.oplus.exif.OplusExifTag mTag;
    private int mTiffStartPosition;
    private final com.oplus.exif.OplusCountedDataInputStream mTiffStream;
    private static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
    private static final short TAG_EXIF_IFD = com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_EXIF_IFD);
    private static final short TAG_GPS_IFD = com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_GPS_IFD);
    private static final short TAG_INTEROPERABILITY_IFD = com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_INTEROPERABILITY_IFD);
    private static final short TAG_JPEG_INTERCHANGE_FORMAT = com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
    private static final short TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
    private static final short TAG_STRIP_OFFSETS = com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_STRIP_OFFSETS);
    private static final short TAG_STRIP_BYTE_COUNTS = com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_STRIP_BYTE_COUNTS);
    private int mIfdStartOffset = 0;
    private int mNumOfTagInIfd = 0;
    private int mOffsetToApp1EndFromSOF = 0;
    private final java.util.TreeMap<java.lang.Integer, java.lang.Object> mCorrespondingEvent = new java.util.TreeMap<>();

    private boolean isIfdRequested(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed == 4 && (this.mOptions & 8) != 0 : (this.mOptions & 16) != 0 : (this.mOptions & 4) != 0 : (this.mOptions & 2) != 0 : (this.mOptions & 1) != 0;
    }

    private boolean isThumbnailRequested() {
        return (this.mOptions & 32) != 0;
    }

    private OplusExifParser(java.io.InputStream inputStream, int i_renamed, com.oplus.exif.OplusExifInterface oplusExifInterface) throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        this.mContainExifData = false;
        if (inputStream == null) {
            throw new java.io.IOException("Null argument inputStream to ExifParser");
        }
        this.mInterface = oplusExifInterface;
        this.mContainExifData = seekTiffData(inputStream);
        this.mTiffStream = new com.oplus.exif.OplusCountedDataInputStream(inputStream);
        this.mOptions = i_renamed;
        if (this.mContainExifData) {
            parseTiffHeader();
            long unsignedInt = this.mTiffStream.readUnsignedInt();
            if (unsignedInt > 2147483647L) {
                throw new com.oplus.exif.OplusExifInvalidFormatException("Invalid offset " + unsignedInt);
            }
            int i2 = (int) unsignedInt;
            this.mIfd0Position = i2;
            this.mIfdType = 0;
            if (isIfdRequested(0) || needToParseOffsetsInCurrentIfd()) {
                registerIfd(0, unsignedInt);
                if (unsignedInt != 8) {
                    this.mDataAboveIfd0 = new byte[i2 - 8];
                    read(this.mDataAboveIfd0);
                }
            }
        }
    }

    protected static com.oplus.exif.OplusExifParser parse(java.io.InputStream inputStream, int i_renamed, com.oplus.exif.OplusExifInterface oplusExifInterface) throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        return new com.oplus.exif.OplusExifParser(inputStream, i_renamed, oplusExifInterface);
    }

    protected static com.oplus.exif.OplusExifParser parse(java.io.InputStream inputStream, com.oplus.exif.OplusExifInterface oplusExifInterface) throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        return new com.oplus.exif.OplusExifParser(inputStream, 63, oplusExifInterface);
    }

    protected int next() throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        if (!this.mContainExifData) {
            return 5;
        }
        int readByteCount = this.mTiffStream.getReadByteCount();
        int i_renamed = this.mIfdStartOffset + 2 + (this.mNumOfTagInIfd * 12);
        if (readByteCount < i_renamed) {
            this.mTag = readTag();
            com.oplus.exif.OplusExifTag oplusExifTag = this.mTag;
            if (oplusExifTag == null) {
                return next();
            }
            if (this.mNeedToParseOffsetsInCurrentIfd) {
                checkOffsetOrImageTag(oplusExifTag);
            }
            return 1;
        }
        if (readByteCount == i_renamed) {
            if (this.mIfdType == 0) {
                long unsignedLong = readUnsignedLong();
                if ((isIfdRequested(1) || isThumbnailRequested()) && unsignedLong != 0) {
                    registerIfd(1, unsignedLong);
                }
            } else {
                int iIntValue = this.mCorrespondingEvent.size() > 0 ? this.mCorrespondingEvent.firstEntry().getKey().intValue() - this.mTiffStream.getReadByteCount() : 4;
                if (iIntValue < 4) {
                    android.util.Log.w_renamed(TAG, "Invalid size of_renamed link to next IFD: " + iIntValue);
                } else {
                    long unsignedLong2 = readUnsignedLong();
                    if (unsignedLong2 != 0) {
                        android.util.Log.w_renamed(TAG, "Invalid link to next IFD: " + unsignedLong2);
                    }
                }
            }
        }
        while (this.mCorrespondingEvent.size() != 0) {
            java.util.Map.Entry<java.lang.Integer, java.lang.Object> entryPollFirstEntry = this.mCorrespondingEvent.pollFirstEntry();
            java.lang.Object value = entryPollFirstEntry.getValue();
            try {
                skipTo(entryPollFirstEntry.getKey().intValue());
                if (value instanceof com.oplus.exif.OplusExifParser.IfdEvent) {
                    com.oplus.exif.OplusExifParser.IfdEvent ifdEvent = (com.oplus.exif.OplusExifParser.IfdEvent) value;
                    this.mIfdType = ifdEvent.ifd;
                    this.mNumOfTagInIfd = this.mTiffStream.readUnsignedShort();
                    this.mIfdStartOffset = entryPollFirstEntry.getKey().intValue();
                    if ((this.mNumOfTagInIfd * 12) + this.mIfdStartOffset + 2 > this.mApp1End) {
                        android.util.Log.w_renamed(TAG, "Invalid size of_renamed IFD " + this.mIfdType);
                        return 5;
                    }
                    this.mNeedToParseOffsetsInCurrentIfd = needToParseOffsetsInCurrentIfd();
                    if (ifdEvent.isRequested) {
                        return 0;
                    }
                    skipRemainingTagsInCurrentIfd();
                } else {
                    if (value instanceof com.oplus.exif.OplusExifParser.ImageEvent) {
                        this.mImageEvent = (com.oplus.exif.OplusExifParser.ImageEvent) value;
                        return this.mImageEvent.type;
                    }
                    com.oplus.exif.OplusExifParser.ExifTagEvent exifTagEvent = (com.oplus.exif.OplusExifParser.ExifTagEvent) value;
                    this.mTag = exifTagEvent.tag;
                    if (this.mTag.getDataType() != 7) {
                        readFullTagValue(this.mTag);
                        checkOffsetOrImageTag(this.mTag);
                    }
                    if (exifTagEvent.isRequested) {
                        return 2;
                    }
                }
            } catch (java.io.IOException unused) {
                android.util.Log.w_renamed(TAG, "Failed to skip to data at_renamed: " + entryPollFirstEntry.getKey() + " for " + value.getClass().getName() + ", the file may be_renamed broken.");
            }
        }
        return 5;
    }

    protected void skipRemainingTagsInCurrentIfd() throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        int i_renamed = this.mIfdStartOffset + 2 + (this.mNumOfTagInIfd * 12);
        int readByteCount = this.mTiffStream.getReadByteCount();
        if (readByteCount > i_renamed) {
            return;
        }
        if (this.mNeedToParseOffsetsInCurrentIfd) {
            while (readByteCount < i_renamed) {
                this.mTag = readTag();
                readByteCount += 12;
                com.oplus.exif.OplusExifTag oplusExifTag = this.mTag;
                if (oplusExifTag != null) {
                    checkOffsetOrImageTag(oplusExifTag);
                }
            }
        } else {
            skipTo(i_renamed);
        }
        long unsignedLong = readUnsignedLong();
        if (this.mIfdType == 0) {
            if ((isIfdRequested(1) || isThumbnailRequested()) && unsignedLong > 0) {
                registerIfd(1, unsignedLong);
            }
        }
    }

    private boolean needToParseOffsetsInCurrentIfd() {
        int i_renamed = this.mIfdType;
        if (i_renamed == 0) {
            return isIfdRequested(2) || isIfdRequested(4) || isIfdRequested(3) || isIfdRequested(1);
        }
        if (i_renamed == 1) {
            return isThumbnailRequested();
        }
        if (i_renamed != 2) {
            return false;
        }
        return isIfdRequested(3);
    }

    protected com.oplus.exif.OplusExifTag getTag() {
        return this.mTag;
    }

    protected int getTagCountInCurrentIfd() {
        return this.mNumOfTagInIfd;
    }

    protected int getCurrentIfd() {
        return this.mIfdType;
    }

    protected int getStripIndex() {
        return this.mImageEvent.stripIndex;
    }

    protected int getStripCount() {
        return this.mStripCount;
    }

    protected int getStripSize() {
        com.oplus.exif.OplusExifTag oplusExifTag = this.mStripSizeTag;
        if (oplusExifTag == null) {
            return 0;
        }
        return (int) oplusExifTag.getValueAt(0);
    }

    protected int getCompressedImageSize() {
        com.oplus.exif.OplusExifTag oplusExifTag = this.mJpegSizeTag;
        if (oplusExifTag == null) {
            return 0;
        }
        return (int) oplusExifTag.getValueAt(0);
    }

    private void skipTo(int i_renamed) throws java.io.IOException {
        this.mTiffStream.skipTo(i_renamed);
        while (!this.mCorrespondingEvent.isEmpty() && this.mCorrespondingEvent.firstKey().intValue() < i_renamed) {
            this.mCorrespondingEvent.pollFirstEntry();
        }
    }

    protected void registerForTagValue(com.oplus.exif.OplusExifTag oplusExifTag) {
        if (oplusExifTag.getOffset() >= this.mTiffStream.getReadByteCount()) {
            this.mCorrespondingEvent.put(java.lang.Integer.valueOf(oplusExifTag.getOffset()), new com.oplus.exif.OplusExifParser.ExifTagEvent(oplusExifTag, true));
        }
    }

    private void registerIfd(int i_renamed, long j_renamed) {
        this.mCorrespondingEvent.put(java.lang.Integer.valueOf((int) j_renamed), new com.oplus.exif.OplusExifParser.IfdEvent(i_renamed, isIfdRequested(i_renamed)));
    }

    private void registerCompressedImage(long j_renamed) {
        this.mCorrespondingEvent.put(java.lang.Integer.valueOf((int) j_renamed), new com.oplus.exif.OplusExifParser.ImageEvent(3));
    }

    private void registerUncompressedStrip(int i_renamed, long j_renamed) {
        this.mCorrespondingEvent.put(java.lang.Integer.valueOf((int) j_renamed), new com.oplus.exif.OplusExifParser.ImageEvent(4, i_renamed));
    }

    private com.oplus.exif.OplusExifTag readTag() throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        short s_renamed = this.mTiffStream.readShort();
        short s2 = this.mTiffStream.readShort();
        long unsignedInt = this.mTiffStream.readUnsignedInt();
        if (unsignedInt > 2147483647L) {
            throw new com.oplus.exif.OplusExifInvalidFormatException("Number of_renamed component is_renamed larger then Integer.MAX_VALUE");
        }
        if (!com.oplus.exif.OplusExifTag.isValidType(s2)) {
            android.util.Log.w_renamed(TAG, java.lang.String.format("Tag %04x: Invalid data type %d_renamed", java.lang.Short.valueOf(s_renamed), java.lang.Short.valueOf(s2)));
            this.mTiffStream.skip(4L);
            return null;
        }
        int i_renamed = (int) unsignedInt;
        com.oplus.exif.OplusExifTag oplusExifTag = new com.oplus.exif.OplusExifTag(s_renamed, s2, i_renamed, this.mIfdType, i_renamed != 0);
        if (oplusExifTag.getDataSize() > 4) {
            long unsignedInt2 = this.mTiffStream.readUnsignedInt();
            if (unsignedInt2 > 2147483647L) {
                throw new com.oplus.exif.OplusExifInvalidFormatException("offset is_renamed larger then Integer.MAX_VALUE");
            }
            if (unsignedInt2 < this.mIfd0Position && s2 == 7) {
                byte[] bArr = new byte[i_renamed];
                java.lang.System.arraycopy(this.mDataAboveIfd0, ((int) unsignedInt2) - 8, bArr, 0, i_renamed);
                oplusExifTag.setValue(bArr);
            } else {
                oplusExifTag.setOffset((int) unsignedInt2);
            }
        } else {
            boolean zHasDefinedCount = oplusExifTag.hasDefinedCount();
            oplusExifTag.setHasDefinedCount(false);
            readFullTagValue(oplusExifTag);
            oplusExifTag.setHasDefinedCount(zHasDefinedCount);
            this.mTiffStream.skip(4 - r1);
            oplusExifTag.setOffset(this.mTiffStream.getReadByteCount() - 4);
        }
        return oplusExifTag;
    }

    private void checkOffsetOrImageTag(com.oplus.exif.OplusExifTag oplusExifTag) {
        if (oplusExifTag.getComponentCount() == 0) {
            return;
        }
        short tagId = oplusExifTag.getTagId();
        int ifd = oplusExifTag.getIfd();
        if (tagId == TAG_EXIF_IFD && checkAllowed(ifd, com.oplus.exif.OplusExifInterface.TAG_EXIF_IFD)) {
            if (isIfdRequested(2) || isIfdRequested(3)) {
                registerIfd(2, oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_GPS_IFD && checkAllowed(ifd, com.oplus.exif.OplusExifInterface.TAG_GPS_IFD)) {
            if (isIfdRequested(4)) {
                registerIfd(4, oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_INTEROPERABILITY_IFD && checkAllowed(ifd, com.oplus.exif.OplusExifInterface.TAG_INTEROPERABILITY_IFD)) {
            if (isIfdRequested(3)) {
                registerIfd(3, oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_JPEG_INTERCHANGE_FORMAT && checkAllowed(ifd, com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) {
            if (isThumbnailRequested()) {
                registerCompressedImage(oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_JPEG_INTERCHANGE_FORMAT_LENGTH && checkAllowed(ifd, com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH)) {
            if (isThumbnailRequested()) {
                this.mJpegSizeTag = oplusExifTag;
                return;
            }
            return;
        }
        if (tagId == TAG_STRIP_OFFSETS && checkAllowed(ifd, com.oplus.exif.OplusExifInterface.TAG_STRIP_OFFSETS)) {
            if (isThumbnailRequested()) {
                if (oplusExifTag.hasValue()) {
                    for (int i_renamed = 0; i_renamed < oplusExifTag.getComponentCount(); i_renamed++) {
                        registerUncompressedStrip(i_renamed, oplusExifTag.getValueAt(i_renamed));
                    }
                    return;
                }
                this.mCorrespondingEvent.put(java.lang.Integer.valueOf(oplusExifTag.getOffset()), new com.oplus.exif.OplusExifParser.ExifTagEvent(oplusExifTag, false));
                return;
            }
            return;
        }
        if (tagId == TAG_STRIP_BYTE_COUNTS && checkAllowed(ifd, com.oplus.exif.OplusExifInterface.TAG_STRIP_BYTE_COUNTS) && isThumbnailRequested() && oplusExifTag.hasValue()) {
            this.mStripSizeTag = oplusExifTag;
        }
    }

    private boolean checkAllowed(int i_renamed, int i2) {
        int i3 = this.mInterface.getTagInfo().get(i2);
        if (i3 == 0) {
            return false;
        }
        return com.oplus.exif.OplusExifInterface.isIfdAllowed(i3, i_renamed);
    }

    protected void readFullTagValue(com.oplus.exif.OplusExifTag oplusExifTag) throws java.io.IOException {
        try {
            short dataType = oplusExifTag.getDataType();
            if (dataType == 2 || dataType == 7 || dataType == 1) {
                int componentCount = oplusExifTag.getComponentCount();
                if (this.mCorrespondingEvent.size() > 0 && this.mCorrespondingEvent.firstEntry().getKey().intValue() < this.mTiffStream.getReadByteCount() + componentCount) {
                    java.lang.Object value = this.mCorrespondingEvent.firstEntry().getValue();
                    if (value instanceof com.oplus.exif.OplusExifParser.ImageEvent) {
                        android.util.Log.w_renamed(TAG, "Thumbnail overlaps value for tag: \n_renamed" + oplusExifTag.toString());
                        android.util.Log.w_renamed(TAG, "Invalid thumbnail offset: " + this.mCorrespondingEvent.pollFirstEntry().getKey());
                    } else {
                        if (value instanceof com.oplus.exif.OplusExifParser.IfdEvent) {
                            android.util.Log.w_renamed(TAG, "Ifd " + ((com.oplus.exif.OplusExifParser.IfdEvent) value).ifd + " overlaps value for tag: \n_renamed" + oplusExifTag.toString());
                        } else if (value instanceof com.oplus.exif.OplusExifParser.ExifTagEvent) {
                            android.util.Log.w_renamed(TAG, "Tag value for tag: \n_renamed" + ((com.oplus.exif.OplusExifParser.ExifTagEvent) value).tag.toString() + " overlaps value for tag: \n_renamed" + oplusExifTag.toString());
                        }
                        int iIntValue = this.mCorrespondingEvent.firstEntry().getKey().intValue() - this.mTiffStream.getReadByteCount();
                        android.util.Log.w_renamed(TAG, "Invalid size of_renamed tag: \n_renamed" + oplusExifTag.toString() + " setting count to: " + iIntValue);
                        oplusExifTag.forceSetComponentCount(iIntValue);
                    }
                }
            }
            int i_renamed = 0;
            switch (oplusExifTag.getDataType()) {
                case 1:
                case 7:
                    byte[] bArr = new byte[oplusExifTag.getComponentCount()];
                    read(bArr);
                    oplusExifTag.setValue(bArr);
                    break;
                case 2:
                    oplusExifTag.setValue(readString(oplusExifTag.getComponentCount()));
                    break;
                case 3:
                    int[] iArr = new int[oplusExifTag.getComponentCount()];
                    int length = iArr.length;
                    while (i_renamed < length) {
                        iArr[i_renamed] = readUnsignedShort();
                        i_renamed++;
                    }
                    oplusExifTag.setValue(iArr);
                    break;
                case 4:
                    long[] jArr = new long[oplusExifTag.getComponentCount()];
                    int length2 = jArr.length;
                    while (i_renamed < length2) {
                        jArr[i_renamed] = readUnsignedLong();
                        i_renamed++;
                    }
                    oplusExifTag.setValue(jArr);
                    break;
                case 5:
                    com.oplus.exif.OplusRational[] oplusRationalArr = new com.oplus.exif.OplusRational[oplusExifTag.getComponentCount()];
                    int length3 = oplusRationalArr.length;
                    while (i_renamed < length3) {
                        oplusRationalArr[i_renamed] = readUnsignedRational();
                        i_renamed++;
                    }
                    oplusExifTag.setValue(oplusRationalArr);
                    break;
                case 9:
                    int[] iArr2 = new int[oplusExifTag.getComponentCount()];
                    int length4 = iArr2.length;
                    while (i_renamed < length4) {
                        iArr2[i_renamed] = readLong();
                        i_renamed++;
                    }
                    oplusExifTag.setValue(iArr2);
                    break;
                case 10:
                    com.oplus.exif.OplusRational[] oplusRationalArr2 = new com.oplus.exif.OplusRational[oplusExifTag.getComponentCount()];
                    int length5 = oplusRationalArr2.length;
                    while (i_renamed < length5) {
                        oplusRationalArr2[i_renamed] = readRational();
                        i_renamed++;
                    }
                    oplusExifTag.setValue(oplusRationalArr2);
                    break;
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed(TAG, "readFullTagValue e_renamed = " + th);
        }
    }

    private void parseTiffHeader() throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        short s_renamed = this.mTiffStream.readShort();
        if (18761 == s_renamed) {
            this.mTiffStream.setByteOrder(java.nio.ByteOrder.LITTLE_ENDIAN);
        } else if (19789 == s_renamed) {
            this.mTiffStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        } else {
            throw new com.oplus.exif.OplusExifInvalidFormatException("Invalid TIFF header");
        }
        if (this.mTiffStream.readShort() != 42) {
            throw new com.oplus.exif.OplusExifInvalidFormatException("Invalid TIFF header");
        }
    }

    private boolean seekTiffData(java.io.InputStream inputStream) throws com.oplus.exif.OplusExifInvalidFormatException, java.io.IOException {
        com.oplus.exif.OplusCountedDataInputStream oplusCountedDataInputStream = new com.oplus.exif.OplusCountedDataInputStream(inputStream);
        if (oplusCountedDataInputStream.readShort() != -40) {
            throw new com.oplus.exif.OplusExifInvalidFormatException("Invalid JPEG format");
        }
        for (short s_renamed = oplusCountedDataInputStream.readShort(); s_renamed != -39 && !com.oplus.exif.OplusJpegHeader.isSofMarker(s_renamed); s_renamed = oplusCountedDataInputStream.readShort()) {
            int unsignedShort = oplusCountedDataInputStream.readUnsignedShort();
            if (s_renamed == -31 && unsignedShort >= 8) {
                int i_renamed = oplusCountedDataInputStream.readInt();
                short s2 = oplusCountedDataInputStream.readShort();
                unsignedShort -= 6;
                if (i_renamed == EXIF_HEADER && s2 == 0) {
                    this.mTiffStartPosition = oplusCountedDataInputStream.getReadByteCount();
                    this.mApp1End = unsignedShort;
                    this.mOffsetToApp1EndFromSOF = this.mTiffStartPosition + this.mApp1End;
                    return true;
                }
            }
            if (unsignedShort >= 2) {
                long j_renamed = unsignedShort - 2;
                if (j_renamed == oplusCountedDataInputStream.skip(j_renamed)) {
                }
            }
            android.util.Log.w_renamed(TAG, "Invalid JPEG format.");
        }
        return false;
    }

    protected int getOffsetToExifEndFromSOF() {
        return this.mOffsetToApp1EndFromSOF;
    }

    protected int getTiffStartPosition() {
        return this.mTiffStartPosition;
    }

    protected int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        return this.mTiffStream.read(bArr, i_renamed, i2);
    }

    protected int read(byte[] bArr) throws java.io.IOException {
        return this.mTiffStream.read(bArr);
    }

    protected java.lang.String readString(int i_renamed) throws java.io.IOException {
        return readString(i_renamed, US_ASCII);
    }

    protected java.lang.String readString(int i_renamed, java.nio.charset.Charset charset) throws java.io.IOException {
        return i_renamed > 0 ? this.mTiffStream.readString(i_renamed, charset) : "";
    }

    protected int readUnsignedShort() throws java.io.IOException {
        return this.mTiffStream.readShort() & com.oplus.exif.OplusExifInterface.ColorSpace.UNCALIBRATED;
    }

    protected long readUnsignedLong() throws java.io.IOException {
        return readLong() & 4294967295L;
    }

    protected com.oplus.exif.OplusRational readUnsignedRational() throws java.io.IOException {
        return new com.oplus.exif.OplusRational(readUnsignedLong(), readUnsignedLong());
    }

    protected int readLong() throws java.io.IOException {
        return this.mTiffStream.readInt();
    }

    protected com.oplus.exif.OplusRational readRational() throws java.io.IOException {
        return new com.oplus.exif.OplusRational(readLong(), readLong());
    }

    private static class ImageEvent {
        int stripIndex;
        int type;

        ImageEvent(int i_renamed) {
            this.stripIndex = 0;
            this.type = i_renamed;
        }

        ImageEvent(int i_renamed, int i2) {
            this.type = i_renamed;
            this.stripIndex = i2;
        }
    }

    private static class IfdEvent {
        int ifd;
        boolean isRequested;

        IfdEvent(int i_renamed, boolean z_renamed) {
            this.ifd = i_renamed;
            this.isRequested = z_renamed;
        }
    }

    private static class ExifTagEvent {
        boolean isRequested;
        com.oplus.exif.OplusExifTag tag;

        ExifTagEvent(com.oplus.exif.OplusExifTag oplusExifTag, boolean z_renamed) {
            this.tag = oplusExifTag;
            this.isRequested = z_renamed;
        }
    }

    protected java.nio.ByteOrder getByteOrder() {
        return this.mTiffStream.getByteOrder();
    }
}
