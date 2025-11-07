package com.oplus.exif;

import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class OplusExifOutputStream extends FilterOutputStream {
    private static final boolean DEBUG = false;
    private static final int EXIF_HEADER = 1165519206;
    private static final int MAX_EXIF_SIZE = 65535;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private static final short TAG_SIZE = 12;
    private static final short TIFF_BIG_ENDIAN = 19789;
    private static final short TIFF_HEADER = 42;
    private static final short TIFF_HEADER_SIZE = 8;
    private static final short TIFF_LITTLE_ENDIAN = 18761;
    private ByteBuffer mBuffer;
    private int mByteToCopy;
    private int mByteToSkip;
    private OplusExifData mExifData;
    private final OplusExifInterface mInterface;
    private byte[] mSingleByteArray;
    private int mState;

    protected OplusExifOutputStream(OutputStream outputStream, OplusExifInterface oplusExifInterface) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.mState = 0;
        this.mSingleByteArray = new byte[1];
        this.mBuffer = ByteBuffer.allocate(4);
        this.mInterface = oplusExifInterface;
    }

    protected void setExifData(OplusExifData oplusExifData) {
        this.mExifData = oplusExifData;
    }

    protected OplusExifData getExifData() {
        return this.mExifData;
    }

    private int requestByteToBuffer(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) {
        int iPosition = OplusGLSurfaceView_13 - this.mBuffer.position();
        if (i3 <= iPosition) {
            iPosition = i3;
        }
        this.mBuffer.put(bArr, i2, iPosition);
        return iPosition;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fc, code lost:
    
        if (r9 <= 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fe, code lost:
    
        r6.out.write(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0103, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return;
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.exif.OplusExifOutputStream.write(byte[], int, int):void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int OplusGLSurfaceView_13) throws IOException {
        byte[] bArr = this.mSingleByteArray;
        bArr[0] = (byte) (OplusGLSurfaceView_13 & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    private void writeExifData() throws IOException {
        OplusExifData oplusExifData = this.mExifData;
        if (oplusExifData == null) {
            return;
        }
        ArrayList<OplusExifTag> arrayListStripNullValueTags = stripNullValueTags(oplusExifData);
        createRequiredIfdAndTag();
        int iCalculateAllOffset = calculateAllOffset() + 8;
        if (iCalculateAllOffset > 65535) {
            throw new IOException("Exif header is too large (>64Kb)");
        }
        OrderedDataOutputStream orderedDataOutputStream = new OrderedDataOutputStream(this.out);
        orderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        orderedDataOutputStream.writeShort((short) -31);
        orderedDataOutputStream.writeShort((short) iCalculateAllOffset);
        orderedDataOutputStream.writeInt(EXIF_HEADER);
        orderedDataOutputStream.writeShort((short) 0);
        if (this.mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN) {
            orderedDataOutputStream.writeShort(TIFF_BIG_ENDIAN);
        } else {
            orderedDataOutputStream.writeShort(TIFF_LITTLE_ENDIAN);
        }
        orderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
        orderedDataOutputStream.writeShort(TIFF_HEADER);
        orderedDataOutputStream.writeInt(8);
        writeAllTags(orderedDataOutputStream);
        writeThumbnail(orderedDataOutputStream);
        Iterator<OplusExifTag> it = arrayListStripNullValueTags.iterator();
        while (it.hasNext()) {
            this.mExifData.addTag(it.next());
        }
    }

    private ArrayList<OplusExifTag> stripNullValueTags(OplusExifData oplusExifData) {
        ArrayList<OplusExifTag> arrayList = new ArrayList<>();
        List<OplusExifTag> allTags = oplusExifData.getAllTags();
        if (allTags != null && allTags.size() > 0) {
            for (OplusExifTag oplusExifTag : allTags) {
                if (oplusExifTag.getValue() == null && !OplusExifInterface.isOffsetTag(oplusExifTag.getTagId())) {
                    oplusExifData.removeTag(oplusExifTag.getTagId(), oplusExifTag.getIfd());
                    arrayList.add(oplusExifTag);
                }
            }
        }
        return arrayList;
    }

    private void writeThumbnail(OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        if (this.mExifData.hasCompressedThumbnail()) {
            orderedDataOutputStream.write(this.mExifData.getCompressedThumbnail());
        } else if (this.mExifData.hasUncompressedStrip()) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mExifData.getStripCount(); OplusGLSurfaceView_13++) {
                orderedDataOutputStream.write(this.mExifData.getStrip(OplusGLSurfaceView_13));
            }
        }
    }

    private void writeAllTags(OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        writeIfd(this.mExifData.getIfdData(0), orderedDataOutputStream);
        writeIfd(this.mExifData.getIfdData(2), orderedDataOutputStream);
        OplusIfdData ifdData = this.mExifData.getIfdData(3);
        if (ifdData != null) {
            writeIfd(ifdData, orderedDataOutputStream);
        }
        OplusIfdData ifdData2 = this.mExifData.getIfdData(4);
        if (ifdData2 != null) {
            writeIfd(ifdData2, orderedDataOutputStream);
        }
        if (this.mExifData.getIfdData(1) != null) {
            writeIfd(this.mExifData.getIfdData(1), orderedDataOutputStream);
        }
    }

    private void writeIfd(OplusIfdData oplusIfdData, OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        OplusExifTag[] allTags = oplusIfdData.getAllTags();
        orderedDataOutputStream.writeShort((short) allTags.length);
        for (OplusExifTag oplusExifTag : allTags) {
            orderedDataOutputStream.writeShort(oplusExifTag.getTagId());
            orderedDataOutputStream.writeShort(oplusExifTag.getDataType());
            orderedDataOutputStream.writeInt(oplusExifTag.getComponentCount());
            if (oplusExifTag.getDataSize() > 4) {
                orderedDataOutputStream.writeInt(oplusExifTag.getOffset());
            } else {
                writeTagValue(oplusExifTag, orderedDataOutputStream);
                int dataSize = 4 - oplusExifTag.getDataSize();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < dataSize; OplusGLSurfaceView_13++) {
                    orderedDataOutputStream.write(0);
                }
            }
        }
        orderedDataOutputStream.writeInt(oplusIfdData.getOffsetToNextIfd());
        for (OplusExifTag oplusExifTag2 : allTags) {
            if (oplusExifTag2.getDataSize() > 4) {
                writeTagValue(oplusExifTag2, orderedDataOutputStream);
            }
        }
    }

    private int calculateOffsetOfIfd(OplusIfdData oplusIfdData, int OplusGLSurfaceView_13) {
        int tagCount = OplusGLSurfaceView_13 + (oplusIfdData.getTagCount() * 12) + 2 + 4;
        for (OplusExifTag oplusExifTag : oplusIfdData.getAllTags()) {
            if (oplusExifTag.getDataSize() > 4) {
                oplusExifTag.setOffset(tagCount);
                tagCount += oplusExifTag.getDataSize();
            }
        }
        return tagCount;
    }

    private void createRequiredIfdAndTag() throws IOException {
        OplusIfdData ifdData = this.mExifData.getIfdData(0);
        if (ifdData == null) {
            ifdData = new OplusIfdData(0);
            this.mExifData.addIfdData(ifdData);
        }
        OplusExifTag oplusExifTagBuildUninitializedTag = this.mInterface.buildUninitializedTag(OplusExifInterface.TAG_EXIF_IFD);
        if (oplusExifTagBuildUninitializedTag == null) {
            throw new IOException("No definition for crucial exif tag: " + OplusExifInterface.TAG_EXIF_IFD);
        }
        ifdData.setTag(oplusExifTagBuildUninitializedTag);
        OplusIfdData ifdData2 = this.mExifData.getIfdData(2);
        if (ifdData2 == null) {
            ifdData2 = new OplusIfdData(2);
            this.mExifData.addIfdData(ifdData2);
        }
        if (this.mExifData.getIfdData(4) != null) {
            OplusExifTag oplusExifTagBuildUninitializedTag2 = this.mInterface.buildUninitializedTag(OplusExifInterface.TAG_GPS_IFD);
            if (oplusExifTagBuildUninitializedTag2 == null) {
                throw new IOException("No definition for crucial exif tag: " + OplusExifInterface.TAG_GPS_IFD);
            }
            ifdData.setTag(oplusExifTagBuildUninitializedTag2);
        }
        if (this.mExifData.getIfdData(3) != null) {
            OplusExifTag oplusExifTagBuildUninitializedTag3 = this.mInterface.buildUninitializedTag(OplusExifInterface.TAG_INTEROPERABILITY_IFD);
            if (oplusExifTagBuildUninitializedTag3 == null) {
                throw new IOException("No definition for crucial exif tag: " + OplusExifInterface.TAG_INTEROPERABILITY_IFD);
            }
            ifdData2.setTag(oplusExifTagBuildUninitializedTag3);
        }
        OplusIfdData ifdData3 = this.mExifData.getIfdData(1);
        if (this.mExifData.hasCompressedThumbnail()) {
            if (ifdData3 == null) {
                ifdData3 = new OplusIfdData(1);
                this.mExifData.addIfdData(ifdData3);
            }
            OplusExifTag oplusExifTagBuildUninitializedTag4 = this.mInterface.buildUninitializedTag(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
            if (oplusExifTagBuildUninitializedTag4 == null) {
                throw new IOException("No definition for crucial exif tag: " + OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
            }
            ifdData3.setTag(oplusExifTagBuildUninitializedTag4);
            OplusExifTag oplusExifTagBuildUninitializedTag5 = this.mInterface.buildUninitializedTag(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (oplusExifTagBuildUninitializedTag5 == null) {
                throw new IOException("No definition for crucial exif tag: " + OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            }
            oplusExifTagBuildUninitializedTag5.setValue(this.mExifData.getCompressedThumbnail().length);
            ifdData3.setTag(oplusExifTagBuildUninitializedTag5);
            ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_STRIP_OFFSETS));
            ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_STRIP_BYTE_COUNTS));
            return;
        }
        if (!this.mExifData.hasUncompressedStrip()) {
            if (ifdData3 != null) {
                ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_STRIP_OFFSETS));
                ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_STRIP_BYTE_COUNTS));
                ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
                return;
            }
            return;
        }
        if (ifdData3 == null) {
            ifdData3 = new OplusIfdData(1);
            this.mExifData.addIfdData(ifdData3);
        }
        int stripCount = this.mExifData.getStripCount();
        OplusExifTag oplusExifTagBuildUninitializedTag6 = this.mInterface.buildUninitializedTag(OplusExifInterface.TAG_STRIP_OFFSETS);
        if (oplusExifTagBuildUninitializedTag6 == null) {
            throw new IOException("No definition for crucial exif tag: " + OplusExifInterface.TAG_STRIP_OFFSETS);
        }
        OplusExifTag oplusExifTagBuildUninitializedTag7 = this.mInterface.buildUninitializedTag(OplusExifInterface.TAG_STRIP_BYTE_COUNTS);
        if (oplusExifTagBuildUninitializedTag7 == null) {
            throw new IOException("No definition for crucial exif tag: " + OplusExifInterface.TAG_STRIP_BYTE_COUNTS);
        }
        long[] jArr = new long[stripCount];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mExifData.getStripCount(); OplusGLSurfaceView_13++) {
            jArr[OplusGLSurfaceView_13] = this.mExifData.getStrip(OplusGLSurfaceView_13).length;
        }
        oplusExifTagBuildUninitializedTag7.setValue(jArr);
        ifdData3.setTag(oplusExifTagBuildUninitializedTag6);
        ifdData3.setTag(oplusExifTagBuildUninitializedTag7);
        ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
        ifdData3.removeTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
    }

    private int calculateAllOffset() {
        OplusIfdData ifdData = this.mExifData.getIfdData(0);
        int iCalculateOffsetOfIfd = calculateOffsetOfIfd(ifdData, 8);
        ifdData.getTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_EXIF_IFD)).setValue(iCalculateOffsetOfIfd);
        OplusIfdData ifdData2 = this.mExifData.getIfdData(2);
        int iCalculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData2, iCalculateOffsetOfIfd);
        OplusIfdData ifdData3 = this.mExifData.getIfdData(3);
        if (ifdData3 != null) {
            ifdData2.getTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_INTEROPERABILITY_IFD)).setValue(iCalculateOffsetOfIfd2);
            iCalculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData3, iCalculateOffsetOfIfd2);
        }
        OplusIfdData ifdData4 = this.mExifData.getIfdData(4);
        if (ifdData4 != null) {
            ifdData.getTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_GPS_IFD)).setValue(iCalculateOffsetOfIfd2);
            iCalculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData4, iCalculateOffsetOfIfd2);
        }
        OplusIfdData ifdData5 = this.mExifData.getIfdData(1);
        if (ifdData5 == null) {
            return iCalculateOffsetOfIfd2;
        }
        ifdData.setOffsetToNextIfd(iCalculateOffsetOfIfd2);
        int iCalculateOffsetOfIfd3 = calculateOffsetOfIfd(ifdData5, iCalculateOffsetOfIfd2);
        if (this.mExifData.hasCompressedThumbnail()) {
            ifdData5.getTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)).setValue(iCalculateOffsetOfIfd3);
            return iCalculateOffsetOfIfd3 + this.mExifData.getCompressedThumbnail().length;
        }
        if (!this.mExifData.hasUncompressedStrip()) {
            return iCalculateOffsetOfIfd3;
        }
        long[] jArr = new long[this.mExifData.getStripCount()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mExifData.getStripCount(); OplusGLSurfaceView_13++) {
            jArr[OplusGLSurfaceView_13] = iCalculateOffsetOfIfd3;
            iCalculateOffsetOfIfd3 += this.mExifData.getStrip(OplusGLSurfaceView_13).length;
        }
        ifdData5.getTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_STRIP_OFFSETS)).setValue(jArr);
        return iCalculateOffsetOfIfd3;
    }

    static void writeTagValue(OplusExifTag oplusExifTag, OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        int OplusGLSurfaceView_13 = 0;
        switch (oplusExifTag.getDataType()) {
            case 1:
            case 7:
                byte[] bArr = new byte[oplusExifTag.getComponentCount()];
                oplusExifTag.getBytes(bArr);
                orderedDataOutputStream.write(bArr);
                break;
            case 2:
                byte[] stringByte = oplusExifTag.getStringByte();
                if (stringByte != null && stringByte.length != 0) {
                    if (stringByte.length == oplusExifTag.getComponentCount()) {
                        stringByte[stringByte.length - 1] = 0;
                        orderedDataOutputStream.write(stringByte);
                        break;
                    } else {
                        orderedDataOutputStream.write(stringByte);
                        orderedDataOutputStream.write(0);
                        break;
                    }
                }
                break;
            case 3:
                int componentCount = oplusExifTag.getComponentCount();
                while (OplusGLSurfaceView_13 < componentCount) {
                    orderedDataOutputStream.writeShort((short) oplusExifTag.getValueAt(OplusGLSurfaceView_13));
                    OplusGLSurfaceView_13++;
                }
                break;
            case 4:
            case 9:
                int componentCount2 = oplusExifTag.getComponentCount();
                while (OplusGLSurfaceView_13 < componentCount2) {
                    orderedDataOutputStream.writeInt((int) oplusExifTag.getValueAt(OplusGLSurfaceView_13));
                    OplusGLSurfaceView_13++;
                }
                break;
            case 5:
            case 10:
                int componentCount3 = oplusExifTag.getComponentCount();
                while (OplusGLSurfaceView_13 < componentCount3) {
                    orderedDataOutputStream.writeRational(oplusExifTag.getRational(OplusGLSurfaceView_13));
                    OplusGLSurfaceView_13++;
                }
                break;
        }
    }
}
