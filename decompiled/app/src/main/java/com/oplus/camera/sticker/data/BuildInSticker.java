package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class BuildInSticker implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.camera.sticker.data.BuildInSticker> CREATOR = new android.os.Parcelable.Creator<com.oplus.camera.sticker.data.BuildInSticker>() { // from class: com.oplus.camera.sticker.data.BuildInSticker.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.BuildInSticker createFromParcel(android.os.Parcel parcel) {
            com.oplus.camera.sticker.data.BuildInSticker buildInSticker = new com.oplus.camera.sticker.data.BuildInSticker();
            buildInSticker.mStickerId = parcel.readLong();
            buildInSticker.mCategoryId = parcel.readString();
            buildInSticker.mCategoryPos = parcel.readInt();
            buildInSticker.mStickerUUID = parcel.readString();
            buildInSticker.mStickerName = parcel.readString();
            buildInSticker.mAssetFilePath = parcel.readString();
            buildInSticker.mAssetThumbnailPath = parcel.readString();
            buildInSticker.mVersion = parcel.readLong();
            buildInSticker.mProtocolVersion = parcel.readLong();
            buildInSticker.mPosition = parcel.readInt();
            buildInSticker.mAttribute = parcel.readInt();
            buildInSticker.mHasMusic = parcel.readInt() != 0;
            buildInSticker.mMaterialType = parcel.readInt();
            buildInSticker.mBackgroundColor = parcel.readString();
            return buildInSticker;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.BuildInSticker[] newArray(int i_renamed) {
            return new com.oplus.camera.sticker.data.BuildInSticker[i_renamed];
        }
    };

    @com.google.gson.annotations.Expose
    private int mMaterialType;

    @com.google.gson.annotations.Expose
    private long mStickerId = 0;

    @com.google.gson.annotations.Expose
    private java.lang.String mStickerUUID = null;

    @com.google.gson.annotations.Expose
    private java.lang.String mStickerName = null;

    @com.google.gson.annotations.Expose
    private java.lang.String mAssetFilePath = null;

    @com.google.gson.annotations.Expose
    private java.lang.String mAssetThumbnailPath = null;

    @com.google.gson.annotations.Expose
    private long mVersion = 0;

    @com.google.gson.annotations.Expose
    private long mProtocolVersion = 0;

    @com.google.gson.annotations.Expose
    private java.lang.String mCategoryId = null;

    @com.google.gson.annotations.Expose
    private int mCategoryPos = -1;

    @com.google.gson.annotations.Expose
    private int mPosition = 0;

    @com.google.gson.annotations.Expose
    private int mAttribute = 0;

    @com.google.gson.annotations.Expose
    private boolean mHasMusic = false;

    @com.google.gson.annotations.Expose
    private java.lang.String mBackgroundColor = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getStickerId() {
        return this.mStickerId;
    }

    public void setStickerId(long j_renamed) {
        this.mStickerId = j_renamed;
    }

    public java.lang.String getStickerUUID() {
        return this.mStickerUUID;
    }

    public void setStickerUUID(java.lang.String str) {
        this.mStickerUUID = str;
    }

    public java.lang.String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(java.lang.String str) {
        this.mCategoryId = str;
    }

    public void setCategoryPosition(int i_renamed) {
        this.mCategoryPos = i_renamed;
    }

    public int getCategoryPosition() {
        return this.mCategoryPos;
    }

    public java.lang.String getStickerName() {
        return this.mStickerName;
    }

    public void setStickerName(java.lang.String str) {
        this.mStickerName = str;
    }

    public java.lang.String getAssetFilePath() {
        return this.mAssetFilePath;
    }

    public void setAssetFilePath(java.lang.String str) {
        this.mAssetFilePath = str;
    }

    public java.lang.String getAssetThumbnailPath() {
        return this.mAssetThumbnailPath;
    }

    public void setAssetThumbnailPath(java.lang.String str) {
        this.mAssetThumbnailPath = str;
    }

    public long getVersion() {
        return this.mVersion;
    }

    public void setVersion(long j_renamed) {
        this.mVersion = j_renamed;
    }

    public long getProtocolVersion() {
        return this.mProtocolVersion;
    }

    public void setProtocolVersion(long j_renamed) {
        this.mProtocolVersion = j_renamed;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i_renamed) {
        this.mPosition = i_renamed;
    }

    public int getAttribute() {
        return this.mAttribute;
    }

    public void setAttribute(int i_renamed) {
        this.mAttribute = i_renamed;
    }

    public boolean getHasMusic() {
        return this.mHasMusic;
    }

    public void setHasMusic(boolean z_renamed) {
        this.mHasMusic = z_renamed;
    }

    public int getMaterialType() {
        return this.mMaterialType;
    }

    public void setMaterialType(int i_renamed) {
        this.mMaterialType = i_renamed;
    }

    public java.lang.String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setBackgroundColor(java.lang.String str) {
        this.mBackgroundColor = str;
    }

    public com.oplus.camera.sticker.data.StickerItemWrapper obtainStickerItem() {
        com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper = new com.oplus.camera.sticker.data.StickerItemWrapper();
        stickerItemWrapper.setStickerId(this.mStickerId);
        stickerItemWrapper.setStickerUUID(this.mStickerUUID);
        stickerItemWrapper.setStickerName(this.mStickerName);
        stickerItemWrapper.setVersion(this.mVersion);
        stickerItemWrapper.setProtocolVersion(this.mProtocolVersion);
        stickerItemWrapper.setCategoryId(this.mCategoryId);
        stickerItemWrapper.setCategoryPosition(this.mCategoryPos);
        stickerItemWrapper.setPosition(this.mPosition);
        stickerItemWrapper.setAttribute(this.mAttribute);
        stickerItemWrapper.setHasMusic(this.mHasMusic);
        stickerItemWrapper.setMaterialType(this.mMaterialType);
        return stickerItemWrapper;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.mStickerId);
        parcel.writeString(this.mCategoryId);
        parcel.writeInt(this.mCategoryPos);
        parcel.writeString(this.mStickerUUID);
        parcel.writeString(this.mStickerName);
        parcel.writeString(this.mAssetFilePath);
        parcel.writeString(this.mAssetThumbnailPath);
        parcel.writeLong(this.mVersion);
        parcel.writeLong(this.mProtocolVersion);
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mAttribute);
        parcel.writeInt(this.mHasMusic ? 1 : 0);
        parcel.writeInt(this.mMaterialType);
        parcel.writeString(this.mBackgroundColor);
    }

    public java.lang.String toString() {
        return "[pos: " + this.mPosition + ", attr: " + this.mAttribute + ", cPos: " + this.mCategoryPos + ", ver: " + this.mVersion + ", pVer: " + this.mProtocolVersion + ", music: " + this.mHasMusic + ", type: " + this.mMaterialType + ", color: " + this.mBackgroundColor + ", name: " + this.mStickerName + ", path: " + this.mAssetFilePath + ", tPath: " + this.mAssetThumbnailPath + "]";
    }
}
