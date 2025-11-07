package com.oplus.exif;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class OplusIfdData {
    private static final int[] sIfds = {0, 1, 2, 3, 4};
    private final int mIfdId;
    private final Map<Short, OplusExifTag> mExifTags = new HashMap();
    private int mOffsetToNextIfd = 0;

    OplusIfdData(int OplusGLSurfaceView_13) {
        this.mIfdId = OplusGLSurfaceView_13;
    }

    protected static int[] getIfds() {
        return sIfds;
    }

    protected OplusExifTag[] getAllTags() {
        return (OplusExifTag[]) this.mExifTags.values().toArray(new OplusExifTag[this.mExifTags.size()]);
    }

    protected int getId() {
        return this.mIfdId;
    }

    protected OplusExifTag getTag(short s) {
        return this.mExifTags.get(Short.valueOf(s));
    }

    protected OplusExifTag setTag(OplusExifTag oplusExifTag) {
        oplusExifTag.setIfd(this.mIfdId);
        return this.mExifTags.put(Short.valueOf(oplusExifTag.getTagId()), oplusExifTag);
    }

    protected boolean checkCollision(short s) {
        return this.mExifTags.get(Short.valueOf(s)) != null;
    }

    protected void removeTag(short s) {
        this.mExifTags.remove(Short.valueOf(s));
    }

    protected int getTagCount() {
        return this.mExifTags.size();
    }

    protected void setOffsetToNextIfd(int OplusGLSurfaceView_13) {
        this.mOffsetToNextIfd = OplusGLSurfaceView_13;
    }

    protected int getOffsetToNextIfd() {
        return this.mOffsetToNextIfd;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof OplusIfdData)) {
            OplusIfdData oplusIfdData = (OplusIfdData) obj;
            if (oplusIfdData.getId() == this.mIfdId && oplusIfdData.getTagCount() == getTagCount()) {
                for (OplusExifTag oplusExifTag : oplusIfdData.getAllTags()) {
                    if (!OplusExifInterface.isOffsetTag(oplusExifTag.getTagId()) && !oplusExifTag.equals(this.mExifTags.get(Short.valueOf(oplusExifTag.getTagId())))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
