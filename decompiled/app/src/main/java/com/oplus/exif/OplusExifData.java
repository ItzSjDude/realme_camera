package com.oplus.exif;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
class OplusExifData {
    private static final String TAG = "ExifData";
    private static final byte[] USER_COMMENT_ASCII = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final byte[] USER_COMMENT_JIS = {74, 73, 83, 0, 0, 0, 0, 0};
    private static final byte[] USER_COMMENT_UNICODE = {85, 78, 73, 67, 79, 68, 69, 0};
    private final ByteOrder mByteOrder;
    private final OplusIfdData[] mIfdDatas = new OplusIfdData[5];
    private ArrayList<byte[]> mStripBytes = new ArrayList<>();
    private byte[] mThumbnail;

    OplusExifData(ByteOrder byteOrder) {
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

    protected void setStripBytes(int OplusGLSurfaceView_13, byte[] bArr) {
        if (OplusGLSurfaceView_13 < this.mStripBytes.size()) {
            this.mStripBytes.set(OplusGLSurfaceView_13, bArr);
            return;
        }
        for (int size = this.mStripBytes.size(); size < OplusGLSurfaceView_13; size++) {
            this.mStripBytes.add(null);
        }
        this.mStripBytes.add(bArr);
    }

    protected int getStripCount() {
        return this.mStripBytes.size();
    }

    protected byte[] getStrip(int OplusGLSurfaceView_13) {
        return this.mStripBytes.get(OplusGLSurfaceView_13);
    }

    protected boolean hasUncompressedStrip() {
        return this.mStripBytes.size() != 0;
    }

    protected ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    protected OplusIfdData getIfdData(int OplusGLSurfaceView_13) {
        if (OplusExifTag.isValidIfd(OplusGLSurfaceView_13)) {
            return this.mIfdDatas[OplusGLSurfaceView_13];
        }
        return null;
    }

    protected void addIfdData(OplusIfdData oplusIfdData) {
        this.mIfdDatas[oplusIfdData.getId()] = oplusIfdData;
    }

    protected OplusIfdData getOrCreateIfdData(int OplusGLSurfaceView_13) {
        OplusIfdData oplusIfdData = this.mIfdDatas[OplusGLSurfaceView_13];
        if (oplusIfdData != null) {
            return oplusIfdData;
        }
        OplusIfdData oplusIfdData2 = new OplusIfdData(OplusGLSurfaceView_13);
        this.mIfdDatas[OplusGLSurfaceView_13] = oplusIfdData2;
        return oplusIfdData2;
    }

    protected OplusExifTag getTag(short s, int OplusGLSurfaceView_13) {
        OplusIfdData oplusIfdData = this.mIfdDatas[OplusGLSurfaceView_13];
        if (oplusIfdData == null) {
            return null;
        }
        return oplusIfdData.getTag(s);
    }

    protected OplusExifTag addTag(OplusExifTag oplusExifTag) {
        if (oplusExifTag != null) {
            return addTag(oplusExifTag, oplusExifTag.getIfd());
        }
        return null;
    }

    protected OplusExifTag addTag(OplusExifTag oplusExifTag, int OplusGLSurfaceView_13) {
        if (oplusExifTag == null || !OplusExifTag.isValidIfd(OplusGLSurfaceView_13)) {
            return null;
        }
        return getOrCreateIfdData(OplusGLSurfaceView_13).setTag(oplusExifTag);
    }

    protected void clearThumbnailAndStrips() {
        this.mThumbnail = null;
        this.mStripBytes.clear();
    }

    protected void removeThumbnailData() {
        clearThumbnailAndStrips();
        this.mIfdDatas[1] = null;
    }

    protected void removeTag(short s, int OplusGLSurfaceView_13) {
        OplusIfdData oplusIfdData = this.mIfdDatas[OplusGLSurfaceView_13];
        if (oplusIfdData == null) {
            return;
        }
        oplusIfdData.removeTag(s);
    }

    protected String getUserComment() {
        OplusExifTag tag;
        OplusIfdData oplusIfdData = this.mIfdDatas[0];
        if (oplusIfdData == null || (tag = oplusIfdData.getTag(OplusExifInterface.getTrueTagKey(OplusExifInterface.TAG_USER_COMMENT))) == null || tag.getComponentCount() < 8) {
            return null;
        }
        byte[] bArr = new byte[tag.getComponentCount()];
        tag.getBytes(bArr);
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        try {
            if (Arrays.equals(bArr2, USER_COMMENT_ASCII)) {
                return new String(bArr, 8, bArr.length - 8, "US-ASCII");
            }
            if (Arrays.equals(bArr2, USER_COMMENT_JIS)) {
                return new String(bArr, 8, bArr.length - 8, "EUC-JP");
            }
            if (Arrays.equals(bArr2, USER_COMMENT_UNICODE)) {
                return new String(bArr, 8, bArr.length - 8, "UTF-16");
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            Log.w(TAG, "Failed to decode the user comment");
            return null;
        }
    }

    protected List<OplusExifTag> getAllTags() {
        OplusExifTag[] allTags;
        ArrayList arrayList = new ArrayList();
        for (OplusIfdData oplusIfdData : this.mIfdDatas) {
            if (oplusIfdData != null && (allTags = oplusIfdData.getAllTags()) != null) {
                for (OplusExifTag oplusExifTag : allTags) {
                    arrayList.add(oplusExifTag);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    protected List<OplusExifTag> getAllTagsForIfd(int OplusGLSurfaceView_13) {
        OplusExifTag[] allTags;
        OplusIfdData oplusIfdData = this.mIfdDatas[OplusGLSurfaceView_13];
        if (oplusIfdData == null || (allTags = oplusIfdData.getAllTags()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allTags.length);
        for (OplusExifTag oplusExifTag : allTags) {
            arrayList.add(oplusExifTag);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    protected List<OplusExifTag> getAllTagsForTagId(short s) {
        OplusExifTag tag;
        ArrayList arrayList = new ArrayList();
        for (OplusIfdData oplusIfdData : this.mIfdDatas) {
            if (oplusIfdData != null && (tag = oplusIfdData.getTag(s)) != null) {
                arrayList.add(tag);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof OplusExifData)) {
            OplusExifData oplusExifData = (OplusExifData) obj;
            if (oplusExifData.mByteOrder == this.mByteOrder && oplusExifData.mStripBytes.size() == this.mStripBytes.size() && Arrays.equals(oplusExifData.mThumbnail, this.mThumbnail)) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mStripBytes.size(); OplusGLSurfaceView_13++) {
                    if (!Arrays.equals(oplusExifData.mStripBytes.get(OplusGLSurfaceView_13), this.mStripBytes.get(OplusGLSurfaceView_13))) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < 5; i2++) {
                    OplusIfdData ifdData = oplusExifData.getIfdData(i2);
                    OplusIfdData ifdData2 = getIfdData(i2);
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
