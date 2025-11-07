package com.oplus.exif;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class OplusExifModifier {
    public static final boolean DEBUG = false;
    public static final String TAG = "ExifModifier";
    private final ByteBuffer mByteBuffer;
    private final OplusExifInterface mInterface;
    private int mOffsetBase;
    private final List<TagOffset> mTagOffsets = new ArrayList();
    private final OplusExifData mTagToModified;

    private static class TagOffset {
        final int mOffset;
        final OplusExifTag mTag;

        TagOffset(OplusExifTag oplusExifTag, int OplusGLSurfaceView_13) {
            this.mTag = oplusExifTag;
            this.mOffset = OplusGLSurfaceView_13;
        }
    }

    protected OplusExifModifier(ByteBuffer byteBuffer, OplusExifInterface oplusExifInterface) throws Throwable {
        OplusByteBufferInputStream oplusByteBufferInputStream;
        this.mByteBuffer = byteBuffer;
        this.mOffsetBase = byteBuffer.position();
        this.mInterface = oplusExifInterface;
        try {
            oplusByteBufferInputStream = new OplusByteBufferInputStream(byteBuffer);
        } catch (Throwable th) {
            th = th;
            oplusByteBufferInputStream = null;
        }
        try {
            OplusExifParser oplusExifParser = OplusExifParser.parse(oplusByteBufferInputStream, this.mInterface);
            this.mTagToModified = new OplusExifData(oplusExifParser.getByteOrder());
            this.mOffsetBase += oplusExifParser.getTiffStartPosition();
            this.mByteBuffer.position(0);
            OplusExifInterface.closeSilently(oplusByteBufferInputStream);
        } catch (Throwable th2) {
            th = th2;
            OplusExifInterface.closeSilently(oplusByteBufferInputStream);
            throw th;
        }
    }

    protected ByteOrder getByteOrder() {
        return this.mTagToModified.getByteOrder();
    }

    protected boolean commit() throws Throwable {
        OplusByteBufferInputStream oplusByteBufferInputStream;
        OplusExifTag tag;
        OplusExifTag tag2;
        OplusIfdData oplusIfdData = null;
        try {
            oplusByteBufferInputStream = new OplusByteBufferInputStream(this.mByteBuffer);
        } catch (Throwable th) {
            th = th;
            oplusByteBufferInputStream = null;
        }
        try {
            OplusIfdData[] oplusIfdDataArr = {this.mTagToModified.getIfdData(0), this.mTagToModified.getIfdData(1), this.mTagToModified.getIfdData(2), this.mTagToModified.getIfdData(3), this.mTagToModified.getIfdData(4)};
            int OplusGLSurfaceView_13 = oplusIfdDataArr[0] != null ? 1 : 0;
            if (oplusIfdDataArr[1] != null) {
                OplusGLSurfaceView_13 |= 2;
            }
            if (oplusIfdDataArr[2] != null) {
                OplusGLSurfaceView_13 |= 4;
            }
            if (oplusIfdDataArr[4] != null) {
                OplusGLSurfaceView_13 |= 8;
            }
            if (oplusIfdDataArr[3] != null) {
                OplusGLSurfaceView_13 |= 16;
            }
            OplusExifParser oplusExifParser = OplusExifParser.parse(oplusByteBufferInputStream, OplusGLSurfaceView_13, this.mInterface);
            for (int next = oplusExifParser.next(); next != 5; next = oplusExifParser.next()) {
                if (next == 0) {
                    oplusIfdData = oplusIfdDataArr[oplusExifParser.getCurrentIfd()];
                    if (oplusIfdData == null) {
                        oplusExifParser.skipRemainingTagsInCurrentIfd();
                    }
                } else if (next == 1 && (tag = oplusExifParser.getTag()) != null && oplusIfdData != null && (tag2 = oplusIfdData.getTag(tag.getTagId())) != null) {
                    if (tag2.getComponentCount() == tag.getComponentCount() && tag2.getDataType() == tag.getDataType()) {
                        this.mTagOffsets.add(new TagOffset(tag2, tag.getOffset()));
                        oplusIfdData.removeTag(tag.getTagId());
                        if (oplusIfdData.getTagCount() == 0) {
                            oplusExifParser.skipRemainingTagsInCurrentIfd();
                        }
                    }
                    OplusExifInterface.closeSilently(oplusByteBufferInputStream);
                    return false;
                }
            }
            for (OplusIfdData oplusIfdData2 : oplusIfdDataArr) {
                if (oplusIfdData2 != null && oplusIfdData2.getTagCount() > 0) {
                    OplusExifInterface.closeSilently(oplusByteBufferInputStream);
                    return false;
                }
            }
            modify();
            OplusExifInterface.closeSilently(oplusByteBufferInputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            OplusExifInterface.closeSilently(oplusByteBufferInputStream);
            throw th;
        }
    }

    private void modify() {
        this.mByteBuffer.order(getByteOrder());
        for (TagOffset tagOffset : this.mTagOffsets) {
            writeTagValue(tagOffset.mTag, tagOffset.mOffset);
        }
    }

    private void writeTagValue(OplusExifTag oplusExifTag, int OplusGLSurfaceView_13) {
        this.mByteBuffer.position(OplusGLSurfaceView_13 + this.mOffsetBase);
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
                    OplusRational rational = oplusExifTag.getRational(i2);
                    this.mByteBuffer.putInt((int) rational.getNumerator());
                    this.mByteBuffer.putInt((int) rational.getDenominator());
                    i2++;
                }
                break;
        }
    }

    public void modifyTag(OplusExifTag oplusExifTag) {
        this.mTagToModified.addTag(oplusExifTag);
    }
}
