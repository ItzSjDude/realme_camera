package com.oplus.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class StickerCategoryItem implements Parcelable {
    public static final Parcelable.Creator<StickerCategoryItem> CREATOR = new Parcelable.Creator<StickerCategoryItem>() { // from class: com.oplus.camera.sticker.data.StickerCategoryItem.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public StickerCategoryItem createFromParcel(Parcel parcel) {
            StickerCategoryItem stickerCategoryItem = new StickerCategoryItem();
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
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public StickerCategoryItem[] newArray(int OplusGLSurfaceView_13) {
            return new StickerCategoryItem[OplusGLSurfaceView_13];
        }
    };
    public static final String MY_CATEGORY_ID = "my_category_e5a3fe9c";
    private String mReadableId = null;
    private String mCategoryName = null;
    private int mPosition = 0;
    private String mIconUrl = null;
    private String mIconFileUri = null;
    private String mIconMd5 = null;
    private String mIconHighlightUrl = null;
    private String mIconHighlightFileUri = null;
    private String mIconHighlightMd5 = null;
    private long mLastRequestTime = 0;
    private boolean mIsNew = false;
    private boolean mIsValid = true;
    private long mIconVersion = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReadableId() {
        return this.mReadableId;
    }

    public void setReadableId(String str) {
        this.mReadableId = str;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public String getIconFileUri() {
        return this.mIconFileUri;
    }

    public void setIconFileUri(String str) {
        this.mIconFileUri = str;
    }

    public String getIconMd5() {
        return this.mIconMd5;
    }

    public void setIconMd5(String str) {
        this.mIconMd5 = str;
    }

    public String getIconHighlightUrl() {
        return this.mIconHighlightUrl;
    }

    public void setIconHighlightUrl(String str) {
        this.mIconHighlightUrl = str;
    }

    public String getIconHighlightFileUri() {
        return this.mIconHighlightFileUri;
    }

    public void setIconHighlightFileUri(String str) {
        this.mIconHighlightFileUri = str;
    }

    public String getIconHighlightMd5() {
        return this.mIconHighlightMd5;
    }

    public void setIconHighlightMd5(String str) {
        this.mIconHighlightMd5 = str;
    }

    public long getLastRequestTime() {
        return this.mLastRequestTime;
    }

    public void setLastRequestTime(long OplusGLSurfaceView_15) {
        this.mLastRequestTime = OplusGLSurfaceView_15;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int OplusGLSurfaceView_13) {
        this.mPosition = OplusGLSurfaceView_13;
    }

    public boolean isCategoryNew() {
        return this.mIsNew;
    }

    public void setCategoryNew(boolean z) {
        this.mIsNew = z;
    }

    public boolean isCategoryValid() {
        return this.mIsValid;
    }

    public void setCategoryValid(boolean z) {
        this.mIsValid = z;
    }

    public long getIconVersion() {
        return this.mIconVersion;
    }

    public void setIconVersion(long OplusGLSurfaceView_15) {
        this.mIconVersion = OplusGLSurfaceView_15;
    }

    public void copy(StickerCategoryItem stickerCategoryItem) {
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

    public static boolean isMyCategory(String str) {
        return MY_CATEGORY_ID.equals(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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

    public String toString() {
        return "[id_renamed: " + this.mReadableId + ", name: " + this.mCategoryName + ", pos: " + this.mPosition + ", isNew: " + this.mIsNew + ", uri: " + this.mIconFileUri + ", hUri: " + this.mIconHighlightFileUri + ", iVersion: " + this.mIconVersion + "]";
    }
}
