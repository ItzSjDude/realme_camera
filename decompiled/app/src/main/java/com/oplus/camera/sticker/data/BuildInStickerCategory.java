package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class BuildInStickerCategory implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.camera.sticker.data.BuildInStickerCategory> CREATOR = new android.os.Parcelable.Creator<com.oplus.camera.sticker.data.BuildInStickerCategory>() { // from class: com.oplus.camera.sticker.data.BuildInStickerCategory.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.BuildInStickerCategory createFromParcel(android.os.Parcel parcel) {
            com.oplus.camera.sticker.data.BuildInStickerCategory buildInStickerCategory = new com.oplus.camera.sticker.data.BuildInStickerCategory();
            buildInStickerCategory.mReadableId = parcel.readString();
            buildInStickerCategory.mCategoryName = parcel.readString();
            buildInStickerCategory.mIconPath = parcel.readString();
            buildInStickerCategory.mIconHighlightPath = parcel.readString();
            buildInStickerCategory.mPosition = parcel.readInt();
            buildInStickerCategory.mIconVersion = parcel.readLong();
            return buildInStickerCategory;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.BuildInStickerCategory[] newArray(int i_renamed) {
            return new com.oplus.camera.sticker.data.BuildInStickerCategory[i_renamed];
        }
    };

    @com.google.gson.annotations.Expose
    private java.lang.String mReadableId = null;

    @com.google.gson.annotations.Expose
    private java.lang.String mCategoryName = null;

    @com.google.gson.annotations.Expose
    private int mPosition = 0;

    @com.google.gson.annotations.Expose
    private java.lang.String mIconPath = null;

    @com.google.gson.annotations.Expose
    private java.lang.String mIconHighlightPath = null;

    @com.google.gson.annotations.Expose
    private long mIconVersion = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getReadableId() {
        return this.mReadableId;
    }

    public void setReadableId(java.lang.String str) {
        this.mReadableId = str;
    }

    public java.lang.String getCategoryName() {
        return this.mCategoryName;
    }

    public void setCategoryName(java.lang.String str) {
        this.mCategoryName = str;
    }

    public java.lang.String getIconPath() {
        return this.mIconPath;
    }

    public void setIconPath(java.lang.String str) {
        this.mIconPath = str;
    }

    public java.lang.String getIconHighlightPath() {
        return this.mIconHighlightPath;
    }

    public void setIconHighlightPath(java.lang.String str) {
        this.mIconHighlightPath = str;
    }

    public long getIconVersion() {
        return this.mIconVersion;
    }

    public void setIconVersion(long j_renamed) {
        this.mIconVersion = j_renamed;
    }

    public com.oplus.camera.sticker.data.StickerCategoryItemWrapper obtainStickerCategoryItem() {
        com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapper = new com.oplus.camera.sticker.data.StickerCategoryItemWrapper();
        stickerCategoryItemWrapper.setReadableId(this.mReadableId);
        stickerCategoryItemWrapper.setCategoryName(this.mCategoryName);
        stickerCategoryItemWrapper.setPosition(this.mPosition);
        stickerCategoryItemWrapper.setIconPath(this.mIconPath);
        stickerCategoryItemWrapper.setIconHighlightPath(this.mIconHighlightPath);
        stickerCategoryItemWrapper.setIconVersion(this.mIconVersion);
        return stickerCategoryItemWrapper;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i_renamed) {
        this.mPosition = i_renamed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mReadableId);
        parcel.writeString(this.mCategoryName);
        parcel.writeString(this.mIconPath);
        parcel.writeString(this.mIconHighlightPath);
        parcel.writeInt(this.mPosition);
        parcel.writeLong(this.mIconVersion);
    }

    public java.lang.String toString() {
        return "[id_renamed: " + this.mReadableId + ", pos: " + this.mPosition + ", name: " + this.mCategoryName + ", path: " + this.mIconPath + ", hPath: " + this.mIconHighlightPath + ", iVersion: " + this.mIconVersion + "]";
    }
}
