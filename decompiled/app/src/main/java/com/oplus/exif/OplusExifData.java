package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusExifData {
    private static final java.lang.String TAG = "ExifData";
    private static final byte[] USER_COMMENT_ASCII = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final byte[] USER_COMMENT_JIS = {74, 73, 83, 0, 0, 0, 0, 0};
    private static final byte[] USER_COMMENT_UNICODE = {85, 78, 73, 67, 79, 68, 69, 0};
    private final java.nio.ByteOrder mByteOrder;
    private final com.oplus.exif.OplusIfdData[] mIfdDatas = new com.oplus.exif.OplusIfdData[5];
    private java.util.ArrayList<byte[]> mStripBytes = new java.util.ArrayList<>();
    private byte[] mThumbnail;

    OplusExifData(java.nio.ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    protected byte[] getCompressedThumbnail() {
        return this.mThumbnail;
    }

    protected void setCompressedThumbnail(byte[] bArr) {
        this.mThumbnail = bArr;
    }

    protected boolean hasCompressedThumbnail() {
        return this.mThumbnail != null;
    }

    protected void setStripBytes(int i_renamed, byte[] bArr) {
        if (i_renamed < this.mStripBytes.size()) {
            this.mStripBytes.set(i_renamed, bArr);
            return;
        }
        for (int size = this.mStripBytes.size(); size < i_renamed; size++) {
            this.mStripBytes.add(null);
        }
        this.mStripBytes.add(bArr);
    }

    protected int getStripCount() {
        return this.mStripBytes.size();
    }

    protected byte[] getStrip(int i_renamed) {
        return this.mStripBytes.get(i_renamed);
    }

    protected boolean hasUncompressedStrip() {
        return this.mStripBytes.size() != 0;
    }

    protected java.nio.ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    protected com.oplus.exif.OplusIfdData getIfdData(int i_renamed) {
        if (com.oplus.exif.OplusExifTag.isValidIfd(i_renamed)) {
            return this.mIfdDatas[i_renamed];
        }
        return null;
    }

    protected void addIfdData(com.oplus.exif.OplusIfdData oplusIfdData) {
        this.mIfdDatas[oplusIfdData.getId()] = oplusIfdData;
    }

    protected com.oplus.exif.OplusIfdData getOrCreateIfdData(int i_renamed) {
        com.oplus.exif.OplusIfdData oplusIfdData = this.mIfdDatas[i_renamed];
        if (oplusIfdData != null) {
            return oplusIfdData;
        }
        com.oplus.exif.OplusIfdData oplusIfdData2 = new com.oplus.exif.OplusIfdData(i_renamed);
        this.mIfdDatas[i_renamed] = oplusIfdData2;
        return oplusIfdData2;
    }

    protected com.oplus.exif.OplusExifTag getTag(short s_renamed, int i_renamed) {
        com.oplus.exif.OplusIfdData oplusIfdData = this.mIfdDatas[i_renamed];
        if (oplusIfdData == null) {
            return null;
        }
        return oplusIfdData.getTag(s_renamed);
    }

    protected com.oplus.exif.OplusExifTag addTag(com.oplus.exif.OplusExifTag oplusExifTag) {
        if (oplusExifTag != null) {
            return addTag(oplusExifTag, oplusExifTag.getIfd());
        }
        return null;
    }

    protected com.oplus.exif.OplusExifTag addTag(com.oplus.exif.OplusExifTag oplusExifTag, int i_renamed) {
        if (oplusExifTag == null || !com.oplus.exif.OplusExifTag.isValidIfd(i_renamed)) {
            return null;
        }
        return getOrCreateIfdData(i_renamed).setTag(oplusExifTag);
    }

    protected void clearThumbnailAndStrips() {
        this.mThumbnail = null;
        this.mStripBytes.clear();
    }

    protected void removeThumbnailData() {
        clearThumbnailAndStrips();
        this.mIfdDatas[1] = null;
    }

    protected void removeTag(short s_renamed, int i_renamed) {
        com.oplus.exif.OplusIfdData oplusIfdData = this.mIfdDatas[i_renamed];
        if (oplusIfdData == null) {
            return;
        }
        oplusIfdData.removeTag(s_renamed);
    }

    protected java.lang.String getUserComment() {
        com.oplus.exif.OplusExifTag tag;
        com.oplus.exif.OplusIfdData oplusIfdData = this.mIfdDatas[0];
        if (oplusIfdData == null || (tag = oplusIfdData.getTag(com.oplus.exif.OplusExifInterface.getTrueTagKey(com.oplus.exif.OplusExifInterface.TAG_USER_COMMENT))) == null || tag.getComponentCount() < 8) {
            return null;
        }
        byte[] bArr = new byte[tag.getComponentCount()];
        tag.getBytes(bArr);
        byte[] bArr2 = new byte[8];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 8);
        try {
            if (java.util.Arrays.equals(bArr2, USER_COMMENT_ASCII)) {
                return new java.lang.String(bArr, 8, bArr.length - 8, "US-ASCII");
            }
            if (java.util.Arrays.equals(bArr2, USER_COMMENT_JIS)) {
                return new java.lang.String(bArr, 8, bArr.length - 8, "EUC-JP");
            }
            if (java.util.Arrays.equals(bArr2, USER_COMMENT_UNICODE)) {
                return new java.lang.String(bArr, 8, bArr.length - 8, "UTF-16");
            }
            return null;
        } catch (java.io.UnsupportedEncodingException unused) {
            android.util.Log.w_renamed(TAG, "Failed to decode the user comment");
            return null;
        }
    }

    protected java.util.List<com.oplus.exif.OplusExifTag> getAllTags() {
        com.oplus.exif.OplusExifTag[] allTags;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.oplus.exif.OplusIfdData oplusIfdData : this.mIfdDatas) {
            if (oplusIfdData != null && (allTags = oplusIfdData.getAllTags()) != null) {
                for (com.oplus.exif.OplusExifTag oplusExifTag : allTags) {
                    arrayList.add(oplusExifTag);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    protected java.util.List<com.oplus.exif.OplusExifTag> getAllTagsForIfd(int i_renamed) {
        com.oplus.exif.OplusExifTag[] allTags;
        com.oplus.exif.OplusIfdData oplusIfdData = this.mIfdDatas[i_renamed];
        if (oplusIfdData == null || (allTags = oplusIfdData.getAllTags()) == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(allTags.length);
        for (com.oplus.exif.OplusExifTag oplusExifTag : allTags) {
            arrayList.add(oplusExifTag);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    protected java.util.List<com.oplus.exif.OplusExifTag> getAllTagsForTagId(short s_renamed) {
        com.oplus.exif.OplusExifTag tag;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.oplus.exif.OplusIfdData oplusIfdData : this.mIfdDatas) {
            if (oplusIfdData != null && (tag = oplusIfdData.getTag(s_renamed)) != null) {
                arrayList.add(tag);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof com.oplus.exif.OplusExifData)) {
            com.oplus.exif.OplusExifData oplusExifData = (com.oplus.exif.OplusExifData) obj;
            if (oplusExifData.mByteOrder == this.mByteOrder && oplusExifData.mStripBytes.size() == this.mStripBytes.size() && java.util.Arrays.equals(oplusExifData.mThumbnail, this.mThumbnail)) {
                for (int i_renamed = 0; i_renamed < this.mStripBytes.size(); i_renamed++) {
                    if (!java.util.Arrays.equals(oplusExifData.mStripBytes.get(i_renamed), this.mStripBytes.get(i_renamed))) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < 5; i2++) {
                    com.oplus.exif.OplusIfdData ifdData = oplusExifData.getIfdData(i2);
                    com.oplus.exif.OplusIfdData ifdData2 = getIfdData(i2);
                    if (ifdData != ifdData2 && ifdData != null && !ifdData.equals(ifdData2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
