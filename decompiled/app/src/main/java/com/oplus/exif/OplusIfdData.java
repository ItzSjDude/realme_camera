package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusIfdData {
    private static final int[] sIfds = {0, 1, 2, 3, 4};
    private final int mIfdId;
    private final java.util.Map<java.lang.Short, com.oplus.exif.OplusExifTag> mExifTags = new java.util.HashMap();
    private int mOffsetToNextIfd = 0;

    OplusIfdData(int i_renamed) {
        this.mIfdId = i_renamed;
    }

    protected static int[] getIfds() {
        return sIfds;
    }

    protected com.oplus.exif.OplusExifTag[] getAllTags() {
        return (com.oplus.exif.OplusExifTag[]) this.mExifTags.values().toArray(new com.oplus.exif.OplusExifTag[this.mExifTags.size()]);
    }

    protected int getId() {
        return this.mIfdId;
    }

    protected com.oplus.exif.OplusExifTag getTag(short s_renamed) {
        return this.mExifTags.get(java.lang.Short.valueOf(s_renamed));
    }

    protected com.oplus.exif.OplusExifTag setTag(com.oplus.exif.OplusExifTag oplusExifTag) {
        oplusExifTag.setIfd(this.mIfdId);
        return this.mExifTags.put(java.lang.Short.valueOf(oplusExifTag.getTagId()), oplusExifTag);
    }

    protected boolean checkCollision(short s_renamed) {
        return this.mExifTags.get(java.lang.Short.valueOf(s_renamed)) != null;
    }

    protected void removeTag(short s_renamed) {
        this.mExifTags.remove(java.lang.Short.valueOf(s_renamed));
    }

    protected int getTagCount() {
        return this.mExifTags.size();
    }

    protected void setOffsetToNextIfd(int i_renamed) {
        this.mOffsetToNextIfd = i_renamed;
    }

    protected int getOffsetToNextIfd() {
        return this.mOffsetToNextIfd;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof com.oplus.exif.OplusIfdData)) {
            com.oplus.exif.OplusIfdData oplusIfdData = (com.oplus.exif.OplusIfdData) obj;
            if (oplusIfdData.getId() == this.mIfdId && oplusIfdData.getTagCount() == getTagCount()) {
                for (com.oplus.exif.OplusExifTag oplusExifTag : oplusIfdData.getAllTags()) {
                    if (!com.oplus.exif.OplusExifInterface.isOffsetTag(oplusExifTag.getTagId()) && !oplusExifTag.equals(this.mExifTags.get(java.lang.Short.valueOf(oplusExifTag.getTagId())))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
