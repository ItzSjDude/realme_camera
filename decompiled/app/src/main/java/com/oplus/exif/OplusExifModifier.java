package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusExifModifier {
    public static final boolean DEBUG = false;
    public static final java.lang.String TAG = "ExifModifier";
    private final java.nio.ByteBuffer mByteBuffer;
    private final com.oplus.exif.OplusExifInterface mInterface;
    private int mOffsetBase;
    private final java.util.List<com.oplus.exif.OplusExifModifier.TagOffset> mTagOffsets = new java.util.ArrayList();
    private final com.oplus.exif.OplusExifData mTagToModified;

    private static class TagOffset {
        final int mOffset;
        final com.oplus.exif.OplusExifTag mTag;

        TagOffset(com.oplus.exif.OplusExifTag oplusExifTag, int i_renamed) {
            this.mTag = oplusExifTag;
            this.mOffset = i_renamed;
        }
    }

    protected OplusExifModifier(java.nio.ByteBuffer byteBuffer, com.oplus.exif.OplusExifInterface oplusExifInterface) throws java.lang.Throwable {
        com.oplus.exif.OplusByteBufferInputStream oplusByteBufferInputStream;
        this.mByteBuffer = byteBuffer;
        this.mOffsetBase = byteBuffer.position();
        this.mInterface = oplusExifInterface;
        try {
            oplusByteBufferInputStream = new com.oplus.exif.OplusByteBufferInputStream(byteBuffer);
        } catch (java.lang.Throwable th) {
            th = th;
            oplusByteBufferInputStream = null;
        }
        try {
            com.oplus.exif.OplusExifParser oplusExifParser = com.oplus.exif.OplusExifParser.parse(oplusByteBufferInputStream, this.mInterface);
            this.mTagToModified = new com.oplus.exif.OplusExifData(oplusExifParser.getByteOrder());
            this.mOffsetBase += oplusExifParser.getTiffStartPosition();
            this.mByteBuffer.position(0);
            com.oplus.exif.OplusExifInterface.closeSilently(oplusByteBufferInputStream);
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.oplus.exif.OplusExifInterface.closeSilently(oplusByteBufferInputStream);
            throw th;
        }
    }

    protected java.nio.ByteOrder getByteOrder() {
        return this.mTagToModified.getByteOrder();
    }

    protected boolean commit() throws java.lang.Throwable {
        com.oplus.exif.OplusByteBufferInputStream oplusByteBufferInputStream;
        com.oplus.exif.OplusExifTag tag;
        com.oplus.exif.OplusExifTag tag2;
        com.oplus.exif.OplusIfdData oplusIfdData = null;
        try {
            oplusByteBufferInputStream = new com.oplus.exif.OplusByteBufferInputStream(this.mByteBuffer);
        } catch (java.lang.Throwable th) {
            th = th;
            oplusByteBufferInputStream = null;
        }
        try {
            com.oplus.exif.OplusIfdData[] oplusIfdDataArr = {this.mTagToModified.getIfdData(0), this.mTagToModified.getIfdData(1), this.mTagToModified.getIfdData(2), this.mTagToModified.getIfdData(3), this.mTagToModified.getIfdData(4)};
            int i_renamed = oplusIfdDataArr[0] != null ? 1 : 0;
            if (oplusIfdDataArr[1] != null) {
                i_renamed |= 2;
            }
            if (oplusIfdDataArr[2] != null) {
                i_renamed |= 4;
            }
            if (oplusIfdDataArr[4] != null) {
                i_renamed |= 8;
            }
            if (oplusIfdDataArr[3] != null) {
                i_renamed |= 16;
            }
            com.oplus.exif.OplusExifParser oplusExifParser = com.oplus.exif.OplusExifParser.parse(oplusByteBufferInputStream, i_renamed, this.mInterface);
            for (int next = oplusExifParser.next(); next != 5; next = oplusExifParser.next()) {
                if (next == 0) {
                    oplusIfdData = oplusIfdDataArr[oplusExifParser.getCurrentIfd()];
                    if (oplusIfdData == null) {
                        oplusExifParser.skipRemainingTagsInCurrentIfd();
                    }
                } else if (next == 1 && (tag = oplusExifParser.getTag()) != null && oplusIfdData != null && (tag2 = oplusIfdData.getTag(tag.getTagId())) != null) {
                    if (tag2.getComponentCount() == tag.getComponentCount() && tag2.getDataType() == tag.getDataType()) {
                        this.mTagOffsets.add(new com.oplus.exif.OplusExifModifier.TagOffset(tag2, tag.getOffset()));
                        oplusIfdData.removeTag(tag.getTagId());
                        if (oplusIfdData.getTagCount() == 0) {
                            oplusExifParser.skipRemainingTagsInCurrentIfd();
                        }
                    }
                    com.oplus.exif.OplusExifInterface.closeSilently(oplusByteBufferInputStream);
                    return false;
                }
            }
            for (com.oplus.exif.OplusIfdData oplusIfdData2 : oplusIfdDataArr) {
                if (oplusIfdData2 != null && oplusIfdData2.getTagCount() > 0) {
                    com.oplus.exif.OplusExifInterface.closeSilently(oplusByteBufferInputStream);
                    return false;
                }
            }
            modify();
            com.oplus.exif.OplusExifInterface.closeSilently(oplusByteBufferInputStream);
            return true;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.oplus.exif.OplusExifInterface.closeSilently(oplusByteBufferInputStream);
            throw th;
        }
    }

    private void modify() {
        this.mByteBuffer.order(getByteOrder());
        for (com.oplus.exif.OplusExifModifier.TagOffset tagOffset : this.mTagOffsets) {
            writeTagValue(tagOffset.mTag, tagOffset.mOffset);
        }
    }

    private void writeTagValue(com.oplus.exif.OplusExifTag oplusExifTag, int i_renamed) {
        this.mByteBuffer.position(i_renamed + this.mOffsetBase);
        int i2 = 0;
        switch (oplusExifTag.getDataType()) {
            case 1:
            case 7:
                byte[] bArr = new byte[oplusExifTag.getComponentCount()];
                oplusExifTag.getBytes(bArr);
                this.mByteBuffer.put(bArr);
                break;
            case 2:
                byte[] stringByte = oplusExifTag.getStringByte();
                if (stringByte.length == oplusExifTag.getComponentCount()) {
                    stringByte[stringByte.length - 1] = 0;
                    this.mByteBuffer.put(stringByte);
                    break;
                } else {
                    this.mByteBuffer.put(stringByte);
                    this.mByteBuffer.put((byte) 0);
                    break;
                }
            case 3:
                int componentCount = oplusExifTag.getComponentCount();
                while (i2 < componentCount) {
                    this.mByteBuffer.putShort((short) oplusExifTag.getValueAt(i2));
                    i2++;
                }
                break;
            case 4:
            case 9:
                int componentCount2 = oplusExifTag.getComponentCount();
                while (i2 < componentCount2) {
                    this.mByteBuffer.putInt((int) oplusExifTag.getValueAt(i2));
                    i2++;
                }
                break;
            case 5:
            case 10:
                int componentCount3 = oplusExifTag.getComponentCount();
                while (i2 < componentCount3) {
                    com.oplus.exif.OplusRational rational = oplusExifTag.getRational(i2);
                    this.mByteBuffer.putInt((int) rational.getNumerator());
                    this.mByteBuffer.putInt((int) rational.getDenominator());
                    i2++;
                }
                break;
        }
    }

    public void modifyTag(com.oplus.exif.OplusExifTag oplusExifTag) {
        this.mTagToModified.addTag(oplusExifTag);
    }
}
