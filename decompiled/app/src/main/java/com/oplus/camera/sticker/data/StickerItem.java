package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class StickerItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.camera.sticker.data.StickerItem> CREATOR = new android.os.Parcelable.Creator<com.oplus.camera.sticker.data.StickerItem>() { // from class: com.oplus.camera.sticker.data.StickerItem.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.StickerItem createFromParcel(android.os.Parcel parcel) {
            com.oplus.camera.sticker.data.StickerItem stickerItem = new com.oplus.camera.sticker.data.StickerItem();
            stickerItem.mStickerId = parcel.readLong();
            stickerItem.mCategoryId = parcel.readString();
            stickerItem.mCategoryPos = parcel.readInt();
            stickerItem.mStickerUUID = parcel.readString();
            stickerItem.mStickerName = parcel.readString();
            stickerItem.mFileContentUri = parcel.readString();
            stickerItem.mFileDownloadUrl = parcel.readString();
            stickerItem.mFileMd5 = parcel.readString();
            stickerItem.mThumbnailFileUri = parcel.readString();
            stickerItem.mThumbnailUrl = parcel.readString();
            stickerItem.mThumbnailMd5 = parcel.readString();
            stickerItem.mLogoFileUri = parcel.readString();
            stickerItem.mLogoUrl = parcel.readString();
            stickerItem.mLogoMd5 = parcel.readString();
            stickerItem.mDownloadUid = parcel.readString();
            stickerItem.mVersion = parcel.readLong();
            stickerItem.mProtocolVersion = parcel.readLong();
            stickerItem.mDownloadTime = parcel.readLong();
            stickerItem.mLastRequestTime = parcel.readLong();
            stickerItem.mPosition = parcel.readInt();
            stickerItem.mDownloadState = parcel.readInt();
            stickerItem.mAttribute = parcel.readLong();
            stickerItem.mHasMusic = parcel.readInt() != 0;
            stickerItem.mNeedUpdate = parcel.readInt() != 0;
            stickerItem.mIsBuildIn = parcel.readInt() != 0;
            stickerItem.mIsNew = parcel.readInt() != 0;
            stickerItem.mIsValid = parcel.readInt() != 0;
            stickerItem.mMaterialType = parcel.readInt();
            return stickerItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.StickerItem[] newArray(int i_renamed) {
            return new com.oplus.camera.sticker.data.StickerItem[i_renamed];
        }
    };
    public static final int MATERIAL_TYPE_ANIEMOJI = 2;
    public static final int MATERIAL_TYPE_MULTI = 1;
    public static final int MATERIAL_TYPE_NORMAL = 0;
    public static final java.lang.String RECYCLE_BIN_UUID = "68714002-1206-472f-a3c8-74eea52f7808";
    private int mMaterialType;
    private long mStickerId = 0;
    private java.lang.String mStickerUUID = null;
    private java.lang.String mStickerName = null;
    private java.lang.String mFileDownloadUrl = null;
    private java.lang.String mFileContentUri = null;
    private java.lang.String mFileMd5 = null;
    private java.lang.String mThumbnailUrl = null;
    private java.lang.String mThumbnailFileUri = null;
    private java.lang.String mThumbnailMd5 = null;
    private java.lang.String mLogoUrl = null;
    private java.lang.String mLogoFileUri = null;
    private java.lang.String mLogoMd5 = null;
    private java.lang.String mDownloadUid = null;
    private long mVersion = 0;
    private long mProtocolVersion = 0;
    private long mDownloadTime = 0;
    private long mLastRequestTime = 0;
    private java.lang.String mCategoryId = null;
    private int mCategoryPos = 0;
    private int mPosition = 0;
    private int mDownloadState = 0;
    private long mAttribute = 0;
    private boolean mHasMusic = false;
    private boolean mNeedUpdate = false;
    private boolean mIsBuildIn = false;
    private boolean mIsNew = false;
    private boolean mIsValid = true;

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

    public java.lang.String getFileDownloadUrl() {
        return this.mFileDownloadUrl;
    }

    public void setFileDownloadUrl(java.lang.String str) {
        this.mFileDownloadUrl = str;
    }

    public java.lang.String getFileContentUri() {
        return this.mFileContentUri;
    }

    public void setFileContentUri(java.lang.String str) {
        this.mFileContentUri = str;
    }

    public java.lang.String getFileMd5() {
        return this.mFileMd5;
    }

    public void setFileMd5(java.lang.String str) {
        this.mFileMd5 = str;
    }

    public java.lang.String getThumbnailUrl() {
        return this.mThumbnailUrl;
    }

    public void setThumbnailUrl(java.lang.String str) {
        this.mThumbnailUrl = str;
    }

    public java.lang.String getThumbnailFileUri() {
        return this.mThumbnailFileUri;
    }

    public void setThumbnailFileUri(java.lang.String str) {
        this.mThumbnailFileUri = str;
    }

    public java.lang.String getThumbnailMd5() {
        return this.mThumbnailMd5;
    }

    public void setThumbnailMd5(java.lang.String str) {
        this.mThumbnailMd5 = str;
    }

    public java.lang.String getLogoUrl() {
        return this.mLogoUrl;
    }

    public void setLogoUrl(java.lang.String str) {
        this.mLogoUrl = str;
    }

    public java.lang.String getLogoFileUri() {
        return this.mLogoFileUri;
    }

    public void setLogoFileUri(java.lang.String str) {
        this.mLogoFileUri = str;
    }

    public java.lang.String getLogoMd5() {
        return this.mLogoMd5;
    }

    public void setLogoMd5(java.lang.String str) {
        this.mLogoMd5 = str;
    }

    public java.lang.String getDownloadUid() {
        return this.mDownloadUid;
    }

    public void setDownloadUid(java.lang.String str) {
        this.mDownloadUid = str;
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

    public long getDownloadTime() {
        return this.mDownloadTime;
    }

    public void setDownloadTime(long j_renamed) {
        this.mDownloadTime = j_renamed;
    }

    public long getLastRequestTime() {
        return this.mLastRequestTime;
    }

    public void setLastRequestTime(long j_renamed) {
        this.mLastRequestTime = j_renamed;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i_renamed) {
        this.mPosition = i_renamed;
    }

    public int getDownloadState() {
        return this.mDownloadState;
    }

    public void setDownloadState(int i_renamed) {
        this.mDownloadState = i_renamed;
    }

    public long getAttribute() {
        return this.mAttribute;
    }

    public void setAttribute(long j_renamed) {
        this.mAttribute = j_renamed;
    }

    public boolean hasMusic() {
        return this.mHasMusic;
    }

    public void setHasMusic(boolean z_renamed) {
        this.mHasMusic = z_renamed;
    }

    public boolean needUpdate() {
        return this.mNeedUpdate;
    }

    public void setNeedUpdate(boolean z_renamed) {
        this.mNeedUpdate = z_renamed;
    }

    public boolean isBuildIn() {
        return this.mIsBuildIn;
    }

    public void setIsBuildIn(boolean z_renamed) {
        this.mIsBuildIn = z_renamed;
    }

    public boolean isStickerNew() {
        return this.mIsNew;
    }

    public void setStickerNew(boolean z_renamed) {
        this.mIsNew = z_renamed;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setValid(boolean z_renamed) {
        this.mIsValid = z_renamed;
    }

    public int getMaterialType() {
        return this.mMaterialType;
    }

    public void setMaterialType(int i_renamed) {
        this.mMaterialType = i_renamed;
    }

    public boolean isDownloaded() {
        return this.mDownloadState == 8;
    }

    public boolean isRecycleBin() {
        return RECYCLE_BIN_UUID.equals(this.mStickerUUID);
    }

    public boolean matchAppAttribute(long j_renamed) {
        return (this.mAttribute & j_renamed) == j_renamed;
    }

    public void copy(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        this.mStickerId = stickerItem.mStickerId;
        this.mStickerUUID = stickerItem.mStickerUUID;
        this.mStickerName = stickerItem.mStickerName;
        this.mFileDownloadUrl = stickerItem.mFileDownloadUrl;
        this.mFileContentUri = stickerItem.mFileContentUri;
        this.mFileMd5 = stickerItem.mFileMd5;
        this.mThumbnailUrl = stickerItem.mThumbnailUrl;
        this.mThumbnailFileUri = stickerItem.mThumbnailFileUri;
        this.mThumbnailMd5 = stickerItem.mThumbnailMd5;
        this.mLogoUrl = stickerItem.mLogoUrl;
        this.mLogoFileUri = stickerItem.mLogoFileUri;
        this.mLogoMd5 = stickerItem.mLogoMd5;
        this.mDownloadUid = stickerItem.mDownloadUid;
        this.mVersion = stickerItem.mVersion;
        this.mProtocolVersion = stickerItem.mProtocolVersion;
        this.mDownloadTime = stickerItem.mDownloadTime;
        this.mLastRequestTime = stickerItem.mLastRequestTime;
        this.mCategoryId = stickerItem.mCategoryId;
        this.mCategoryPos = stickerItem.mCategoryPos;
        this.mPosition = stickerItem.mPosition;
        this.mDownloadState = stickerItem.mDownloadState;
        this.mAttribute = stickerItem.mAttribute;
        this.mHasMusic = stickerItem.mHasMusic;
        this.mNeedUpdate = stickerItem.mNeedUpdate;
        this.mIsBuildIn = stickerItem.mIsBuildIn;
        this.mIsNew = stickerItem.mIsNew;
        this.mIsValid = stickerItem.mIsValid;
        this.mMaterialType = stickerItem.mMaterialType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.mStickerId);
        parcel.writeString(this.mCategoryId);
        parcel.writeInt(this.mCategoryPos);
        parcel.writeString(this.mStickerUUID);
        parcel.writeString(this.mStickerName);
        parcel.writeString(this.mFileContentUri);
        parcel.writeString(this.mFileDownloadUrl);
        parcel.writeString(this.mFileMd5);
        parcel.writeString(this.mThumbnailFileUri);
        parcel.writeString(this.mThumbnailUrl);
        parcel.writeString(this.mThumbnailMd5);
        parcel.writeString(this.mLogoFileUri);
        parcel.writeString(this.mLogoUrl);
        parcel.writeString(this.mLogoMd5);
        parcel.writeString(this.mDownloadUid);
        parcel.writeLong(this.mVersion);
        parcel.writeLong(this.mProtocolVersion);
        parcel.writeLong(this.mDownloadTime);
        parcel.writeLong(this.mLastRequestTime);
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mDownloadState);
        parcel.writeLong(this.mAttribute);
        parcel.writeInt(this.mHasMusic ? 1 : 0);
        parcel.writeInt(this.mNeedUpdate ? 1 : 0);
        parcel.writeInt(this.mIsBuildIn ? 1 : 0);
        parcel.writeInt(this.mIsNew ? 1 : 0);
        parcel.writeInt(this.mIsValid ? 1 : 0);
        parcel.writeInt(this.mMaterialType);
    }

    public java.lang.String toString() {
        return "[id_renamed: " + this.mStickerId + ", name: " + this.mStickerName + ", pos: " + this.mPosition + ", cPos: " + this.mCategoryPos + ", state: " + this.mDownloadState + ", dTime: " + this.mDownloadTime + ", ver: " + this.mVersion + ", music:" + this.mHasMusic + ", pVer: " + this.mProtocolVersion + ", attr: " + this.mAttribute + ", buildIn: " + this.mIsBuildIn + ", type: " + this.mMaterialType + "]";
    }
}
