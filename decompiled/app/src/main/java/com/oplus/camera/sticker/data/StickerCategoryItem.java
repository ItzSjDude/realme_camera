package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class StickerCategoryItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.camera.sticker.data.StickerCategoryItem> CREATOR = new android.os.Parcelable.Creator<com.oplus.camera.sticker.data.StickerCategoryItem>() { // from class: com.oplus.camera.sticker.data.StickerCategoryItem.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.StickerCategoryItem createFromParcel(android.os.Parcel parcel) {
            com.oplus.camera.sticker.data.StickerCategoryItem stickerCategoryItem = new com.oplus.camera.sticker.data.StickerCategoryItem();
            stickerCategoryItem.mReadableId = parcel.readString();
            stickerCategoryItem.mCategoryName = parcel.readString();
            stickerCategoryItem.mIconUrl = parcel.readString();
            stickerCategoryItem.mIconFileUri = parcel.readString();
            stickerCategoryItem.mIconMd5 = parcel.readString();
            stickerCategoryItem.mIconHighlightUrl = parcel.readString();
            stickerCategoryItem.mIconHighlightFileUri = parcel.readString();
            stickerCategoryItem.mIconHighlightMd5 = parcel.readString();
            stickerCategoryItem.mLastRequestTime = parcel.readLong();
            stickerCategoryItem.mPosition = parcel.readInt();
            stickerCategoryItem.mIsNew = parcel.readInt() != 0;
            stickerCategoryItem.mIsValid = parcel.readInt() != 0;
            stickerCategoryItem.mIconVersion = parcel.readLong();
            return stickerCategoryItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.StickerCategoryItem[] newArray(int i_renamed) {
            return new com.oplus.camera.sticker.data.StickerCategoryItem[i_renamed];
        }
    };
    public static final java.lang.String MY_CATEGORY_ID = "my_category_e5a3fe9c";
    private java.lang.String mReadableId = null;
    private java.lang.String mCategoryName = null;
    private int mPosition = 0;
    private java.lang.String mIconUrl = null;
    private java.lang.String mIconFileUri = null;
    private java.lang.String mIconMd5 = null;
    private java.lang.String mIconHighlightUrl = null;
    private java.lang.String mIconHighlightFileUri = null;
    private java.lang.String mIconHighlightMd5 = null;
    private long mLastRequestTime = 0;
    private boolean mIsNew = false;
    private boolean mIsValid = true;
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

    public java.lang.String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(java.lang.String str) {
        this.mIconUrl = str;
    }

    public java.lang.String getIconFileUri() {
        return this.mIconFileUri;
    }

    public void setIconFileUri(java.lang.String str) {
        this.mIconFileUri = str;
    }

    public java.lang.String getIconMd5() {
        return this.mIconMd5;
    }

    public void setIconMd5(java.lang.String str) {
        this.mIconMd5 = str;
    }

    public java.lang.String getIconHighlightUrl() {
        return this.mIconHighlightUrl;
    }

    public void setIconHighlightUrl(java.lang.String str) {
        this.mIconHighlightUrl = str;
    }

    public java.lang.String getIconHighlightFileUri() {
        return this.mIconHighlightFileUri;
    }

    public void setIconHighlightFileUri(java.lang.String str) {
        this.mIconHighlightFileUri = str;
    }

    public java.lang.String getIconHighlightMd5() {
        return this.mIconHighlightMd5;
    }

    public void setIconHighlightMd5(java.lang.String str) {
        this.mIconHighlightMd5 = str;
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

    public boolean isCategoryNew() {
        return this.mIsNew;
    }

    public void setCategoryNew(boolean z_renamed) {
        this.mIsNew = z_renamed;
    }

    public boolean isCategoryValid() {
        return this.mIsValid;
    }

    public void setCategoryValid(boolean z_renamed) {
        this.mIsValid = z_renamed;
    }

    public long getIconVersion() {
        return this.mIconVersion;
    }

    public void setIconVersion(long j_renamed) {
        this.mIconVersion = j_renamed;
    }

    public void copy(com.oplus.camera.sticker.data.StickerCategoryItem stickerCategoryItem) {
        this.mReadableId = stickerCategoryItem.mReadableId;
        this.mCategoryName = stickerCategoryItem.mCategoryName;
        this.mIconUrl = stickerCategoryItem.mIconUrl;
        this.mIconMd5 = stickerCategoryItem.mIconMd5;
        this.mIconFileUri = stickerCategoryItem.mIconFileUri;
        this.mIconHighlightUrl = stickerCategoryItem.mIconHighlightUrl;
        this.mIconHighlightMd5 = stickerCategoryItem.mIconHighlightMd5;
        this.mIconHighlightFileUri = stickerCategoryItem.mIconHighlightFileUri;
        this.mLastRequestTime = stickerCategoryItem.mLastRequestTime;
        this.mPosition = stickerCategoryItem.mPosition;
        this.mIsNew = stickerCategoryItem.mIsNew;
        this.mIsValid = stickerCategoryItem.mIsValid;
        this.mIconVersion = stickerCategoryItem.mIconVersion;
    }

    public static boolean isMyCategory(java.lang.String str) {
        return MY_CATEGORY_ID.equals(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mReadableId);
        parcel.writeString(this.mCategoryName);
        parcel.writeString(this.mIconUrl);
        parcel.writeString(this.mIconFileUri);
        parcel.writeString(this.mIconMd5);
        parcel.writeString(this.mIconHighlightUrl);
        parcel.writeString(this.mIconHighlightFileUri);
        parcel.writeString(this.mIconHighlightMd5);
        parcel.writeLong(this.mLastRequestTime);
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mIsNew ? 1 : 0);
        parcel.writeInt(this.mIsValid ? 1 : 0);
        parcel.writeLong(this.mIconVersion);
    }

    public java.lang.String toString() {
        return "[id_renamed: " + this.mReadableId + ", name: " + this.mCategoryName + ", pos: " + this.mPosition + ", isNew: " + this.mIsNew + ", uri: " + this.mIconFileUri + ", hUri: " + this.mIconHighlightFileUri + ", iVersion: " + this.mIconVersion + "]";
    }
}
