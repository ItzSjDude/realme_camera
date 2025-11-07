package com.oplus.exif;

import android.util.Log;
import com.oplus.exif.OplusExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

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
    private static final String TAG = "ExifParser";
    protected static final int TAG_SIZE = 12;
    protected static final short TIFF_HEADER_TAIL = 42;
    private int mApp1End;
    private boolean mContainExifData;
    private byte[] mDataAboveIfd0;
    private int mIfd0Position;
    private int mIfdType;
    private ImageEvent mImageEvent;
    private final OplusExifInterface mInterface;
    private OplusExifTag mJpegSizeTag;
    private boolean mNeedToParseOffsetsInCurrentIfd;
    private final int mOptions;
    private int mStripCount;
    private OplusExifTag mStripSizeTag;
    private OplusExifTag mTag;
    private int mTiffStartPosition;
    private final OplusCountedDataInputStream mTiffStream;
    private static final Charset US_ASCII = Charset.forName("US-ASCII");
    private static final short TAG_EXIF_IFD = OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_EXIF_IFD);
    private static final short TAG_GPS_IFD = OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_GPS_IFD);
    private static final short TAG_INTEROPERABILITY_IFD = OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_INTEROPERABILITY_IFD);
    private static final short TAG_JPEG_INTERCHANGE_FORMAT = OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
    private static final short TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
    private static final short TAG_STRIP_OFFSETS = OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_STRIP_OFFSETS);
    private static final short TAG_STRIP_BYTE_COUNTS = OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_STRIP_BYTE_COUNTS);
    private int mIfdStartOffset = 0;
    private int mNumOfTagInIfd = 0;
    private int mOffsetToApp1EndFromSOF = 0;
    private final TreeMap<Integer, Object> mCorrespondingEvent = new TreeMap<>();

    private boolean isIfdRequested(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? OplusGLSurfaceView_13 == 4 && (this.mOptions & 8) != 0 : (this.mOptions & 16) != 0 : (this.mOptions & 4) != 0 : (this.mOptions & 2) != 0 : (this.mOptions & 1) != 0;
    }

    private boolean isThumbnailRequested() {
        return (this.mOptions & 32) != 0;
    }

    private OplusExifParser(InputStream inputStream, int OplusGLSurfaceView_13, OplusExifInterface oplusExifInterface) throws OplusExifInvalidFormatException, IOException {
        this.mContainExifData = false;
        if (inputStream == null) {
            throw new IOException("Null argument inputStream to ExifParser");
        }
        this.mInterface = oplusExifInterface;
        this.mContainExifData = seekTiffData(inputStream);
        this.mTiffStream = new OplusCountedDataInputStream(inputStream);
        this.mOptions = OplusGLSurfaceView_13;
        if (this.mContainExifData) {
            parseTiffHeader();
            long unsignedInt = this.mTiffStream.readUnsignedInt();
            if (unsignedInt > 2147483647L) {
                throw new OplusExifInvalidFormatException("Invalid offset " + unsignedInt);
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

    protected static OplusExifParser parse(InputStream inputStream, int OplusGLSurfaceView_13, OplusExifInterface oplusExifInterface) throws OplusExifInvalidFormatException, IOException {
        return new OplusExifParser(inputStream, OplusGLSurfaceView_13, oplusExifInterface);
    }

    protected static OplusExifParser parse(InputStream inputStream, OplusExifInterface oplusExifInterface) throws OplusExifInvalidFormatException, IOException {
        return new OplusExifParser(inputStream, 63, oplusExifInterface);
    }

    protected int next() throws OplusExifInvalidFormatException, IOException {
        if (!this.mContainExifData) {
            return 5;
        }
        int readByteCount = this.mTiffStream.getReadByteCount();
        int OplusGLSurfaceView_13 = this.mIfdStartOffset + 2 + (this.mNumOfTagInIfd * 12);
        if (readByteCount < OplusGLSurfaceView_13) {
            this.mTag = readTag();
            OplusExifTag oplusExifTag = this.mTag;
            if (oplusExifTag == null) {
                return next();
            }
            if (this.mNeedToParseOffsetsInCurrentIfd) {
                checkOffsetOrImageTag(oplusExifTag);
            }
            return 1;
        }
        if (readByteCount == OplusGLSurfaceView_13) {
            if (this.mIfdType == 0) {
                long unsignedLong = readUnsignedLong();
                if ((isIfdRequested(1) || isThumbnailRequested()) && unsignedLong != 0) {
                    registerIfd(1, unsignedLong);
                }
            } else {
                int iIntValue = this.mCorrespondingEvent.size() > 0 ? this.mCorrespondingEvent.firstEntry().getKey().intValue() - this.mTiffStream.getReadByteCount() : 4;
                if (iIntValue < 4) {
                    Log.w(TAG, "Invalid size of link to next IFD: " + iIntValue);
                } else {
                    long unsignedLong2 = readUnsignedLong();
                    if (unsignedLong2 != 0) {
                        Log.w(TAG, "Invalid link to next IFD: " + unsignedLong2);
                    }
                }
            }
        }
        while (this.mCorrespondingEvent.size() != 0) {
            Map.Entry<Integer, Object> entryPollFirstEntry = this.mCorrespondingEvent.pollFirstEntry();
            Object value = entryPollFirstEntry.getValue();
            try {
                skipTo(entryPollFirstEntry.getKey().intValue());
                if (value instanceof IfdEvent) {
                    IfdEvent ifdEvent = (IfdEvent) value;
                    this.mIfdType = ifdEvent.ifd;
                    this.mNumOfTagInIfd = this.mTiffStream.readUnsignedShort();
                    this.mIfdStartOffset = entryPollFirstEntry.getKey().intValue();
                    if ((this.mNumOfTagInIfd * 12) + this.mIfdStartOffset + 2 > this.mApp1End) {
                        Log.w(TAG, "Invalid size of IFD " + this.mIfdType);
                        return 5;
                    }
                    this.mNeedToParseOffsetsInCurrentIfd = needToParseOffsetsInCurrentIfd();
                    if (ifdEvent.isRequested) {
                        return 0;
                    }
                    skipRemainingTagsInCurrentIfd();
                } else {
                    if (value instanceof ImageEvent) {
                        this.mImageEvent = (ImageEvent) value;
                        return this.mImageEvent.type;
                    }
                    ExifTagEvent exifTagEvent = (ExifTagEvent) value;
                    this.mTag = exifTagEvent.tag;
                    if (this.mTag.getDataType() != 7) {
                        readFullTagValue(this.mTag);
                        checkOffsetOrImageTag(this.mTag);
                    }
                    if (exifTagEvent.isRequested) {
                        return 2;
                    }
                }
            } catch (IOException unused) {
                Log.w(TAG, "Failed to skip to data at: " + entryPollFirstEntry.getKey() + " for " + value.getClass().getName() + ", the file may be broken.");
            }
        }
        return 5;
    }

    protected void skipRemainingTagsInCurrentIfd() throws OplusExifInvalidFormatException, IOException {
        int OplusGLSurfaceView_13 = this.mIfdStartOffset + 2 + (this.mNumOfTagInIfd * 12);
        int readByteCount = this.mTiffStream.getReadByteCount();
        if (readByteCount > OplusGLSurfaceView_13) {
            return;
        }
        if (this.mNeedToParseOffsetsInCurrentIfd) {
            while (readByteCount < OplusGLSurfaceView_13) {
                this.mTag = readTag();
                readByteCount += 12;
                OplusExifTag oplusExifTag = this.mTag;
                if (oplusExifTag != null) {
                    checkOffsetOrImageTag(oplusExifTag);
                }
            }
        } else {
            skipTo(OplusGLSurfaceView_13);
        }
        long unsignedLong = readUnsignedLong();
        if (this.mIfdType == 0) {
            if ((isIfdRequested(1) || isThumbnailRequested()) && unsignedLong > 0) {
                registerIfd(1, unsignedLong);
            }
        }
    }

    private boolean needToParseOffsetsInCurrentIfd() {
        int OplusGLSurfaceView_13 = this.mIfdType;
        if (OplusGLSurfaceView_13 == 0) {
            return isIfdRequested(2) || isIfdRequested(4) || isIfdRequested(3) || isIfdRequested(1);
        }
        if (OplusGLSurfaceView_13 == 1) {
            return isThumbnailRequested();
        }
        if (OplusGLSurfaceView_13 != 2) {
            return false;
        }
        return isIfdRequested(3);
    }

    protected OplusExifTag getTag() {
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
        OplusExifTag oplusExifTag = this.mStripSizeTag;
        if (oplusExifTag == null) {
            return 0;
        }
        return (int) oplusExifTag.getValueAt(0);
    }

    protected int getCompressedImageSize() {
        OplusExifTag oplusExifTag = this.mJpegSizeTag;
        if (oplusExifTag == null) {
            return 0;
        }
        return (int) oplusExifTag.getValueAt(0);
    }

    private void skipTo(int OplusGLSurfaceView_13) throws IOException {
        this.mTiffStream.skipTo(OplusGLSurfaceView_13);
        while (!this.mCorrespondingEvent.isEmpty() && this.mCorrespondingEvent.firstKey().intValue() < OplusGLSurfaceView_13) {
            this.mCorrespondingEvent.pollFirstEntry();
        }
    }

    protected void registerForTagValue(OplusExifTag oplusExifTag) {
        if (oplusExifTag.getOffset() >= this.mTiffStream.getReadByteCount()) {
            this.mCorrespondingEvent.put(Integer.valueOf(oplusExifTag.getOffset()), new ExifTagEvent(oplusExifTag, true));
        }
    }

    private void registerIfd(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        this.mCorrespondingEvent.put(Integer.valueOf((int) OplusGLSurfaceView_15), new IfdEvent(OplusGLSurfaceView_13, isIfdRequested(OplusGLSurfaceView_13)));
    }

    private void registerCompressedImage(long OplusGLSurfaceView_15) {
        this.mCorrespondingEvent.put(Integer.valueOf((int) OplusGLSurfaceView_15), new ImageEvent(3));
    }

    private void registerUncompressedStrip(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        this.mCorrespondingEvent.put(Integer.valueOf((int) OplusGLSurfaceView_15), new ImageEvent(4, OplusGLSurfaceView_13));
    }

    private OplusExifTag readTag() throws OplusExifInvalidFormatException, IOException {
        short s = this.mTiffStream.readShort();
        short s2 = this.mTiffStream.readShort();
        long unsignedInt = this.mTiffStream.readUnsignedInt();
        if (unsignedInt > 2147483647L) {
            throw new OplusExifInvalidFormatException("Number of component is larger then Integer.MAX_VALUE");
        }
        if (!OplusExifTag.isValidType(s2)) {
            Log.w(TAG, String.format("Tag %04x: Invalid data type %IntrinsicsJvm.kt_5", Short.valueOf(s), Short.valueOf(s2)));
            this.mTiffStream.skip(4L);
            return null;
        }
        int OplusGLSurfaceView_13 = (int) unsignedInt;
        OplusExifTag oplusExifTag = new OplusExifTag(s, s2, OplusGLSurfaceView_13, this.mIfdType, OplusGLSurfaceView_13 != 0);
        if (oplusExifTag.getDataSize() > 4) {
            long unsignedInt2 = this.mTiffStream.readUnsignedInt();
            if (unsignedInt2 > 2147483647L) {
                throw new OplusExifInvalidFormatException("offset is larger then Integer.MAX_VALUE");
            }
            if (unsignedInt2 < this.mIfd0Position && s2 == 7) {
                byte[] bArr = new byte[OplusGLSurfaceView_13];
                System.arraycopy(this.mDataAboveIfd0, ((int) unsignedInt2) - 8, bArr, 0, OplusGLSurfaceView_13);
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

    private void checkOffsetOrImageTag(OplusExifTag oplusExifTag) {
        if (oplusExifTag.getComponentCount() == 0) {
            return;
        }
        short tagId = oplusExifTag.getTagId();
        int ifd = oplusExifTag.getIfd();
        if (tagId == TAG_EXIF_IFD && checkAllowed(ifd, OplusExifInterface.TAG_EXIF_IFD)) {
            if (isIfdRequested(2) || isIfdRequested(3)) {
                registerIfd(2, oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_GPS_IFD && checkAllowed(ifd, OplusExifInterface.TAG_GPS_IFD)) {
            if (isIfdRequested(4)) {
                registerIfd(4, oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_INTEROPERABILITY_IFD && checkAllowed(ifd, OplusExifInterface.TAG_INTEROPERABILITY_IFD)) {
            if (isIfdRequested(3)) {
                registerIfd(3, oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_JPEG_INTERCHANGE_FORMAT && checkAllowed(ifd, OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) {
            if (isThumbnailRequested()) {
                registerCompressedImage(oplusExifTag.getValueAt(0));
                return;
            }
            return;
        }
        if (tagId == TAG_JPEG_INTERCHANGE_FORMAT_LENGTH && checkAllowed(ifd, OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH)) {
            if (isThumbnailRequested()) {
                this.mJpegSizeTag = oplusExifTag;
                return;
            }
            return;
        }
        if (tagId == TAG_STRIP_OFFSETS && checkAllowed(ifd, OplusExifInterface.TAG_STRIP_OFFSETS)) {
            if (isThumbnailRequested()) {
                if (oplusExifTag.hasValue()) {
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < oplusExifTag.getComponentCount(); OplusGLSurfaceView_13++) {
                        registerUncompressedStrip(OplusGLSurfaceView_13, oplusExifTag.getValueAt(OplusGLSurfaceView_13));
                    }
                    return;
                }
                this.mCorrespondingEvent.put(Integer.valueOf(oplusExifTag.getOffset()), new ExifTagEvent(oplusExifTag, false));
                return;
            }
            return;
        }
        if (tagId == TAG_STRIP_BYTE_COUNTS && checkAllowed(ifd, OplusExifInterface.TAG_STRIP_BYTE_COUNTS) && isThumbnailRequested() && oplusExifTag.hasValue()) {
            this.mStripSizeTag = oplusExifTag;
        }
    }

    private boolean checkAllowed(int OplusGLSurfaceView_13, int i2) {
        int i3 = this.mInterface.getTagInfo().get(i2);
        if (i3 == 0) {
            return false;
        }
        return OplusExifInterface.isIfdAllowed(i3, OplusGLSurfaceView_13);
    }

    protected void readFullTagValue(OplusExifTag oplusExifTag) throws IOException {
        try {
            short dataType = oplusExifTag.getDataType();
            if (dataType == 2 || dataType == 7 || dataType == 1) {
                int componentCount = oplusExifTag.getComponentCount();
                if (this.mCorrespondingEvent.size() > 0 && this.mCorrespondingEvent.firstEntry().getKey().intValue() < this.mTiffStream.getReadByteCount() + componentCount) {
                    Object value = this.mCorrespondingEvent.firstEntry().getValue();
                    if (value instanceof ImageEvent) {
                        Log.w(TAG, "Thumbnail overlaps value for tag: \OplusGLSurfaceView_11" + oplusExifTag.toString());
                        Log.w(TAG, "Invalid thumbnail offset: " + this.mCorrespondingEvent.pollFirstEntry().getKey());
                    } else {
                        if (value instanceof IfdEvent) {
                            Log.w(TAG, "Ifd " + ((IfdEvent) value).ifd + " overlaps value for tag: \OplusGLSurfaceView_11" + oplusExifTag.toString());
                        } else if (value instanceof ExifTagEvent) {
                            Log.w(TAG, "Tag value for tag: \OplusGLSurfaceView_11" + ((ExifTagEvent) value).tag.toString() + " overlaps value for tag: \OplusGLSurfaceView_11" + oplusExifTag.toString());
                        }
                        int iIntValue = this.mCorrespondingEvent.firstEntry().getKey().intValue() - this.mTiffStream.getReadByteCount();
                        Log.w(TAG, "Invalid size of tag: \OplusGLSurfaceView_11" + oplusExifTag.toString() + " setting count to: " + iIntValue);
                        oplusExifTag.forceSetComponentCount(iIntValue);
                    }
                }
            }
            int OplusGLSurfaceView_13 = 0;
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
                    while (OplusGLSurfaceView_13 < length) {
                        iArr[OplusGLSurfaceView_13] = readUnsignedShort();
                        OplusGLSurfaceView_13++;
                    }
                    oplusExifTag.setValue(iArr);
                    break;
                case 4:
                    long[] jArr = new long[oplusExifTag.getComponentCount()];
                    int length2 = jArr.length;
                    while (OplusGLSurfaceView_13 < length2) {
                        jArr[OplusGLSurfaceView_13] = readUnsignedLong();
                        OplusGLSurfaceView_13++;
                    }
                    oplusExifTag.setValue(jArr);
                    break;
                case 5:
                    OplusRational[] oplusRationalArr = new OplusRational[oplusExifTag.getComponentCount()];
                    int length3 = oplusRationalArr.length;
                    while (OplusGLSurfaceView_13 < length3) {
                        oplusRationalArr[OplusGLSurfaceView_13] = readUnsignedRational();
                        OplusGLSurfaceView_13++;
                    }
                    oplusExifTag.setValue(oplusRationalArr);
                    break;
                case 9:
                    int[] iArr2 = new int[oplusExifTag.getComponentCount()];
                    int length4 = iArr2.length;
                    while (OplusGLSurfaceView_13 < length4) {
                        iArr2[OplusGLSurfaceView_13] = readLong();
                        OplusGLSurfaceView_13++;
                    }
                    oplusExifTag.setValue(iArr2);
                    break;
                case 10:
                    OplusRational[] oplusRationalArr2 = new OplusRational[oplusExifTag.getComponentCount()];
                    int length5 = oplusRationalArr2.length;
                    while (OplusGLSurfaceView_13 < length5) {
                        oplusRationalArr2[OplusGLSurfaceView_13] = readRational();
                        OplusGLSurfaceView_13++;
                    }
                    oplusExifTag.setValue(oplusRationalArr2);
                    break;
            }
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8(TAG, "readFullTagValue COUIBaseListPopupWindow_8 = " + th);
        }
    }

    private void parseTiffHeader() throws OplusExifInvalidFormatException, IOException {
        short s = this.mTiffStream.readShort();
        if (18761 == s) {
            this.mTiffStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        } else if (19789 == s) {
            this.mTiffStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        } else {
            throw new OplusExifInvalidFormatException("Invalid TIFF header");
        }
        if (this.mTiffStream.readShort() != 42) {
            throw new OplusExifInvalidFormatException("Invalid TIFF header");
        }
    }

    private boolean seekTiffData(InputStream inputStream) throws OplusExifInvalidFormatException, IOException {
        OplusCountedDataInputStream oplusCountedDataInputStream = new OplusCountedDataInputStream(inputStream);
        if (oplusCountedDataInputStream.readShort() != -40) {
            throw new OplusExifInvalidFormatException("Invalid JPEG format");
        }
        for (short s = oplusCountedDataInputStream.readShort(); s != -39 && !OplusJpegHeader.isSofMarker(s); s = oplusCountedDataInputStream.readShort()) {
            int unsignedShort = oplusCountedDataInputStream.readUnsignedShort();
            if (s == -31 && unsignedShort >= 8) {
                int OplusGLSurfaceView_13 = oplusCountedDataInputStream.readInt();
                short s2 = oplusCountedDataInputStream.readShort();
                unsignedShort -= 6;
                if (OplusGLSurfaceView_13 == EXIF_HEADER && s2 == 0) {
                    this.mTiffStartPosition = oplusCountedDataInputStream.getReadByteCount();
                    this.mApp1End = unsignedShort;
                    this.mOffsetToApp1EndFromSOF = this.mTiffStartPosition + this.mApp1End;
                    return true;
                }
            }
            if (unsignedShort >= 2) {
                long OplusGLSurfaceView_15 = unsignedShort - 2;
                if (OplusGLSurfaceView_15 == oplusCountedDataInputStream.skip(OplusGLSurfaceView_15)) {
                }
            }
            Log.w(TAG, "Invalid JPEG format.");
        }
        return false;
    }

    protected int getOffsetToExifEndFromSOF() {
        return this.mOffsetToApp1EndFromSOF;
    }

    protected int getTiffStartPosition() {
        return this.mTiffStartPosition;
    }

    protected int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        return this.mTiffStream.read(bArr, OplusGLSurfaceView_13, i2);
    }

    protected int read(byte[] bArr) throws IOException {
        return this.mTiffStream.read(bArr);
    }

    protected String readString(int OplusGLSurfaceView_13) throws IOException {
        return readString(OplusGLSurfaceView_13, US_ASCII);
    }

    protected String readString(int OplusGLSurfaceView_13, Charset charset) throws IOException {
        return OplusGLSurfaceView_13 > 0 ? this.mTiffStream.readString(OplusGLSurfaceView_13, charset) : "";
    }

    protected int readUnsignedShort() throws IOException {
        return this.mTiffStream.readShort() & OplusExifInterface.ColorSpace.UNCALIBRATED;
    }

    protected long readUnsignedLong() throws IOException {
        return readLong() & 4294967295L;
    }

    protected OplusRational readUnsignedRational() throws IOException {
        return new OplusRational(readUnsignedLong(), readUnsignedLong());
    }

    protected int readLong() throws IOException {
        return this.mTiffStream.readInt();
    }

    protected OplusRational readRational() throws IOException {
        return new OplusRational(readLong(), readLong());
    }

    private static class ImageEvent {
        int stripIndex;
        int type;

        ImageEvent(int OplusGLSurfaceView_13) {
            this.stripIndex = 0;
            this.type = OplusGLSurfaceView_13;
        }

        ImageEvent(int OplusGLSurfaceView_13, int i2) {
            this.type = OplusGLSurfaceView_13;
            this.stripIndex = i2;
        }
    }

    private static class IfdEvent {
        int ifd;
        boolean isRequested;

        IfdEvent(int OplusGLSurfaceView_13, boolean z) {
            this.ifd = OplusGLSurfaceView_13;
            this.isRequested = z;
        }
    }

    private static class ExifTagEvent {
        boolean isRequested;
        OplusExifTag tag;

        ExifTagEvent(OplusExifTag oplusExifTag, boolean z) {
            this.tag = oplusExifTag;
            this.isRequested = z;
        }
    }

    protected ByteOrder getByteOrder() {
        return this.mTiffStream.getByteOrder();
    }
}
