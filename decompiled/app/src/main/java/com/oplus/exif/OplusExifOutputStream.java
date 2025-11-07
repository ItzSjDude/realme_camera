package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusExifOutputStream extends java.io.FilterOutputStream {
    private static final boolean DEBUG = false;
    private static final int EXIF_HEADER = 1165519206;
    private static final int MAX_EXIF_SIZE = 65535;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final java.lang.String TAG = "ExifOutputStream";
    private static final short TAG_SIZE = 12;
    private static final short TIFF_BIG_ENDIAN = 19789;
    private static final short TIFF_HEADER = 42;
    private static final short TIFF_HEADER_SIZE = 8;
    private static final short TIFF_LITTLE_ENDIAN = 18761;
    private java.nio.ByteBuffer mBuffer;
    private int mByteToCopy;
    private int mByteToSkip;
    private com.oplus.exif.OplusExifData mExifData;
    private final com.oplus.exif.OplusExifInterface mInterface;
    private byte[] mSingleByteArray;
    private int mState;

    protected OplusExifOutputStream(java.io.OutputStream outputStream, com.oplus.exif.OplusExifInterface oplusExifInterface) {
        super(new java.io.BufferedOutputStream(outputStream, 65536));
        this.mState = 0;
        this.mSingleByteArray = new byte[1];
        this.mBuffer = java.nio.ByteBuffer.allocate(4);
        this.mInterface = oplusExifInterface;
    }

    protected void setExifData(com.oplus.exif.OplusExifData oplusExifData) {
        this.mExifData = oplusExifData;
    }

    protected com.oplus.exif.OplusExifData getExifData() {
        return this.mExifData;
    }

    private int requestByteToBuffer(int i_renamed, byte[] bArr, int i2, int i3) {
        int iPosition = i_renamed - this.mBuffer.position();
        if (i3 <= iPosition) {
            iPosition = i3;
        }
        this.mBuffer.put(bArr, i2, iPosition);
        return iPosition;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:51:0x00fc, code lost:
    
        if (r9 <= 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:52:0x00fe, code lost:
    
        r6.out.write(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:53:0x0103, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:67:?, code lost:
    
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
    public void write(int i_renamed) throws java.io.IOException {
        byte[] bArr = this.mSingleByteArray;
        bArr[0] = (byte) (i_renamed & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    private void writeExifData() throws java.io.IOException {
        com.oplus.exif.OplusExifData oplusExifData = this.mExifData;
        if (oplusExifData == null) {
            return;
        }
        java.util.ArrayList<com.oplus.exif.OplusExifTag> arrayListStripNullValueTags = stripNullValueTags(oplusExifData);
        createRequiredIfdAndTag();
        int iCalculateAllOffset = calculateAllOffset() + 8;
        if (iCalculateAllOffset > 65535) {
            throw new java.io.IOException("Exif header is_renamed too large (>64Kb)");
        }
        com.oplus.exif.OrderedDataOutputStream orderedDataOutputStream = new com.oplus.exif.OrderedDataOutputStream(this.out);
        orderedDataOutputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        orderedDataOutputStream.writeShort((short) -31);
        orderedDataOutputStream.writeShort((short) iCalculateAllOffset);
        orderedDataOutputStream.writeInt(EXIF_HEADER);
        orderedDataOutputStream.writeShort((short) 0);
        if (this.mExifData.getByteOrder() == java.nio.ByteOrder.BIG_ENDIAN) {
            orderedDataOutputStream.writeShort(TIFF_BIG_ENDIAN);
        } else {
            orderedDataOutputStream.writeShort(TIFF_LITTLE_ENDIAN);
        }
        orderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
        orderedDataOutputStream.writeShort(TIFF_HEADER);
        orderedDataOutputStream.writeInt(8);
        writeAllTags(orderedDataOutputStream);
        writeThumbnail(orderedDataOutputStream);
        java.util.Iterator<com.oplus.exif.OplusExifTag> it = arrayListStripNullValueTags.iterator();
        while (it.hasNext()) {
            this.mExifData.addTag(it.next());
        }
    }

    private java.util.ArrayList<com.oplus.exif.OplusExifTag> stripNullValueTags(com.oplus.exif.OplusExifData oplusExifData) {
        java.util.ArrayList<com.oplus.exif.OplusExifTag> arrayList = new java.util.ArrayList<>();
        java.util.List<com.oplus.exif.OplusExifTag> allTags = oplusExifData.getAllTags();
        if (allTags != null && allTags.size() > 0) {
            for (com.oplus.exif.OplusExifTag oplusExifTag : allTags) {
                if (oplusExifTag.getValue() == null && !com.oplus.exif.OplusExifInterface.isOffsetTag(oplusExifTag.getTagId())) {
                    oplusExifData.removeTag(oplusExifTag.getTagId(), oplusExifTag.getIfd());
                    arrayList.add(oplusExifTag);
                }
            }
        }
        return arrayList;
    }

    private void writeThumbnail(com.oplus.exif.OrderedDataOutputStream orderedDataOutputStream) throws java.io.IOException {
        if (this.mExifData.hasCompressedThumbnail()) {
            orderedDataOutputStream.write(this.mExifData.getCompressedThumbnail());
        } else if (this.mExifData.hasUncompressedStrip()) {
            for (int i_renamed = 0; i_renamed < this.mExifData.getStripCount(); i_renamed++) {
                orderedDataOutputStream.write(this.mExifData.getStrip(i_renamed));
            }
        }
    }

    private void writeAllTags(com.oplus.exif.OrderedDataOutputStream orderedDataOutputStream) throws java.io.IOException {
        writeIfd(this.mExifData.getIfdData(0), orderedDataOutputStream);
        writeIfd(this.mExifData.getIfdData(2), orderedDataOutputStream);
        com.oplus.exif.OplusIfdData ifdData = this.mExifData.getIfdData(3);
        if (ifdData != null) {
            writeIfd(ifdData, orderedDataOutputStream);
        }
        com.oplus.exif.OplusIfdData ifdData2 = this.mExifData.getIfdData(4);
        if (ifdData2 != null) {
            writeIfd(ifdData2, orderedDataOutputStream);
        }
        if (this.mExifData.getIfdData(1) != null) {
            writeIfd(this.mExifData.getIfdData(1), orderedDataOutputStream);
        }
    }

    private void writeIfd(com.oplus.exif.OplusIfdData oplusIfdData, com.oplus.exif.OrderedDataOutputStream orderedDataOutputStream) throws java.io.IOException {
        com.oplus.exif.OplusExifTag[] allTags = oplusIfdData.getAllTags();
        orderedDataOutputStream.writeShort((short) allTags.length);
        for (com.oplus.exif.OplusExifTag oplusExifTag : allTags) {
            orderedDataOutputStream.writeShort(oplusExifTag.getTagId());
            orderedDataOutputStream.writeShort(oplusExifTag.getDataType());
            orderedDataOutputStream.writeInt(oplusExifTag.getComponentCount());
            if (oplusExifTag.getDataSize() > 4) {
                orderedDataOutputStream.writeInt(oplusExifTag.getOffset());
            } else {
                writeTagValue(oplusExifTag, orderedDataOutputStream);
                int dataSize = 4 - oplusExifTag.getDataSize();
                for (int i_renamed = 0; i_renamed < dataSize; i_renamed++) {
                    orderedDataOutputStream.write(0);
                }
            }
        }
        orderedDataOutputStream.writeInt(oplusIfdData.getOffsetToNextIfd());
        for (com.oplus.exif.OplusExifTag oplusExifTag2 : allTags) {
            if (oplusExifTag2.getDataSize() > 4) {
                writeTagValue(oplusExifTag2, orderedDataOutputStream);
            }
        }
    }

    private int calculateOffsetOfIfd(com.oplus.exif.OplusIfdData oplusIfdData, int i_renamed) {
        int tagCount = i_renamed + (oplusIfdData.getTagCount() * 12) + 2 + 4;
        for (com.oplus.exif.OplusExifTag oplusExifTag : oplusIfdData.getAllTags()) {
            if (oplusExifTag.getDataSize() > 4) {
                oplusExifTag.setOffset(tagCount);
                tagCount += oplusExifTag.getDataSize();
            }
        }
        return tagCount;
    }

    private void createRequiredIfdAndTag() throws java.io.IOException {
        com.oplus.exif.OplusIfdData ifdData = this.mExifData.getIfdData(0);
        if (ifdData == null) {
            ifdData = new com.oplus.exif.OplusIfdData(0);
            this.mExifData.addIfdData(ifdData);
        }
        com.oplus.exif.OplusExifTag oplusExifTagBuildUninitializedTag = this.mInterface.buildUninitializedTag(com.oplus.exif.OplusExifInterface.TAG_EXIF_IFD);
        if (oplusExifTagBuildUninitializedTag == null) {
            throw new java.io.IOException("No definition for crucial exif tag: " + com.oplus.exif.OplusExifInterface.TAG_EXIF_IFD);
        }
        ifdData.setTag(oplusExifTagBuildUninitializedTag);
        com.oplus.exif.OplusIfdData ifdData2 = this.mExifData.getIfdData(2);
        if (ifdData2 == null) {
            ifdData2 = new com.oplus.exif.OplusIfdData(2);
            this.mExifData.addIfdData(ifdData2);
        }
        if (this.mExifData.getIfdData(4) != null) {
            com.oplus.exif.OplusExifTag oplusExifTagBuildUninitializedTag2 = this.mInterface.buildUninitializedTag(com.oplus.exif.OplusExifInterface.TAG_GPS_IFD);
            if (oplusExifTagBuildUninitializedTag2 == null) {
                throw new java.io.IOException("No definition for crucial exif tag: " + com.oplus.exif.OplusExifInterface.TAG_GPS_IFD);
            }
            ifdData.setTag(oplusExifTagBuildUninitializedTag2);
        }
        if (this.mExifData.getIfdData(3) != null) {
            com.oplus.exif.OplusExifTag oplusExifTagBuildUninitializedTag3 = this.mInterface.buildUninitializedTag(com.oplus.exif.OplusExifInterface.TAG_INTEROPERABILITY_IFD);
            if (oplusExifTagBuildUninitializedTag3 == null) {
                throw new java.io.IOException("No definition for crucial exif tag: " + com.oplus.exif.OplusExifInterface.TAG_INTEROPERABILITY_IFD);
            }
            ifdData2.setTag(oplusExifTagBuildUninitializedTag3);
        }
        com.oplus.exif.OplusIfdData ifdData3 = this.mExifData.getIfdData(1);
        if (this.mExifData.hasCompressedThumbnail()) {
            if (ifdData3 == null) {
                ifdData3 = new com.oplus.exif.OplusIfdData(1);
                this.mExifData.addIfdData(ifdData3);
            }
            com.oplus.exif.OplusExifTag oplusExifTagBuildUninitializedTag4 = this.mInterface.buildUninitializedTag(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
            if (oplusExifTagBuildUninitializedTag4 == null) {
                throw new java.io.IOException("No definition for crucial exif tag: " + com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
            }
            ifdData3.setTag(oplusExifTagBuildUninitializedTag4);
            com.oplus.exif.OplusExifTag oplusExifTagBuildUninitializedTag5 = this.mInterface.buildUninitializedTag(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (oplusExifTagBuildUninitializedTag5 == null) {
                throw new java.io.IOException("No definition for crucial exif tag: " + com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            }
            oplusExifTagBuildUninitializedTag5.setValue(this.mExifData.getCompressedThumbnail().length);
            ifdData3.setTag(oplusExifTagBuildUninitializedTag5);
            ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_STRIP_OFFSETS));
            ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_STRIP_BYTE_COUNTS));
            return;
        }
        if (!this.mExifData.hasUncompressedStrip()) {
            if (ifdData3 != null) {
                ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_STRIP_OFFSETS));
                ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_STRIP_BYTE_COUNTS));
                ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
                return;
            }
            return;
        }
        if (ifdData3 == null) {
            ifdData3 = new com.oplus.exif.OplusIfdData(1);
            this.mExifData.addIfdData(ifdData3);
        }
        int stripCount = this.mExifData.getStripCount();
        com.oplus.exif.OplusExifTag oplusExifTagBuildUninitializedTag6 = this.mInterface.buildUninitializedTag(com.oplus.exif.OplusExifInterface.TAG_STRIP_OFFSETS);
        if (oplusExifTagBuildUninitializedTag6 == null) {
            throw new java.io.IOException("No definition for crucial exif tag: " + com.oplus.exif.OplusExifInterface.TAG_STRIP_OFFSETS);
        }
        com.oplus.exif.OplusExifTag oplusExifTagBuildUninitializedTag7 = this.mInterface.buildUninitializedTag(com.oplus.exif.OplusExifInterface.TAG_STRIP_BYTE_COUNTS);
        if (oplusExifTagBuildUninitializedTag7 == null) {
            throw new java.io.IOException("No definition for crucial exif tag: " + com.oplus.exif.OplusExifInterface.TAG_STRIP_BYTE_COUNTS);
        }
        long[] jArr = new long[stripCount];
        for (int i_renamed = 0; i_renamed < this.mExifData.getStripCount(); i_renamed++) {
            jArr[i_renamed] = this.mExifData.getStrip(i_renamed).length;
        }
        oplusExifTagBuildUninitializedTag7.setValue(jArr);
        ifdData3.setTag(oplusExifTagBuildUninitializedTag6);
        ifdData3.setTag(oplusExifTagBuildUninitializedTag7);
        ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
        ifdData3.removeTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
    }

    private int calculateAllOffset() {
        com.oplus.exif.OplusIfdData ifdData = this.mExifData.getIfdData(0);
        int iCalculateOffsetOfIfd = calculateOffsetOfIfd(ifdData, 8);
        ifdData.getTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_EXIF_IFD)).setValue(iCalculateOffsetOfIfd);
        com.oplus.exif.OplusIfdData ifdData2 = this.mExifData.getIfdData(2);
        int iCalculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData2, iCalculateOffsetOfIfd);
        com.oplus.exif.OplusIfdData ifdData3 = this.mExifData.getIfdData(3);
        if (ifdData3 != null) {
            ifdData2.getTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_INTEROPERABILITY_IFD)).setValue(iCalculateOffsetOfIfd2);
            iCalculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData3, iCalculateOffsetOfIfd2);
        }
        com.oplus.exif.OplusIfdData ifdData4 = this.mExifData.getIfdData(4);
        if (ifdData4 != null) {
            ifdData.getTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_GPS_IFD)).setValue(iCalculateOffsetOfIfd2);
            iCalculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData4, iCalculateOffsetOfIfd2);
        }
        com.oplus.exif.OplusIfdData ifdData5 = this.mExifData.getIfdData(1);
        if (ifdData5 == null) {
            return iCalculateOffsetOfIfd2;
        }
        ifdData.setOffsetToNextIfd(iCalculateOffsetOfIfd2);
        int iCalculateOffsetOfIfd3 = calculateOffsetOfIfd(ifdData5, iCalculateOffsetOfIfd2);
        if (this.mExifData.hasCompressedThumbnail()) {
            ifdData5.getTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)).setValue(iCalculateOffsetOfIfd3);
            return iCalculateOffsetOfIfd3 + this.mExifData.getCompressedThumbnail().length;
        }
        if (!this.mExifData.hasUncompressedStrip()) {
            return iCalculateOffsetOfIfd3;
        }
        long[] jArr = new long[this.mExifData.getStripCount()];
        for (int i_renamed = 0; i_renamed < this.mExifData.getStripCount(); i_renamed++) {
            jArr[i_renamed] = iCalculateOffsetOfIfd3;
            iCalculateOffsetOfIfd3 += this.mExifData.getStrip(i_renamed).length;
        }
        ifdData5.getTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_STRIP_OFFSETS)).setValue(jArr);
        return iCalculateOffsetOfIfd3;
    }

    static void writeTagValue(com.oplus.exif.OplusExifTag oplusExifTag, com.oplus.exif.OrderedDataOutputStream orderedDataOutputStream) throws java.io.IOException {
        int i_renamed = 0;
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
                while (i_renamed < componentCount) {
                    orderedDataOutputStream.writeShort((short) oplusExifTag.getValueAt(i_renamed));
                    i_renamed++;
                }
                break;
            case 4:
            case 9:
                int componentCount2 = oplusExifTag.getComponentCount();
                while (i_renamed < componentCount2) {
                    orderedDataOutputStream.writeInt((int) oplusExifTag.getValueAt(i_renamed));
                    i_renamed++;
                }
                break;
            case 5:
            case 10:
                int componentCount3 = oplusExifTag.getComponentCount();
                while (i_renamed < componentCount3) {
                    orderedDataOutputStream.writeRational(oplusExifTag.getRational(i_renamed));
                    i_renamed++;
                }
                break;
        }
    }
}
