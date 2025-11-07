package com.oplus.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class StickerItem implements Parcelable {
    public static final Parcelable.Creator<StickerItem> CREATOR = new Parcelable.Creator<StickerItem>() { // from class: com.oplus.camera.sticker.data.StickerItem.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public StickerItem createFromParcel(Parcel parcel) {
            StickerItem stickerItem = new StickerItem();
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
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public StickerItem[] newArray(int OplusGLSurfaceView_13) {
            return new StickerItem[OplusGLSurfaceView_13];
        }
    };
    public static final int MATERIAL_TYPE_ANIEMOJI = 2;
    public static final int MATERIAL_TYPE_MULTI = 1;
    public static final int MATERIAL_TYPE_NORMAL = 0;
    public static final String RECYCLE_BIN_UUID = "68714002-1206-472f-a3c8-74eea52f7808";
    private int mMaterialType;
    private long mStickerId = 0;
    private String mStickerUUID = null;
    private String mStickerName = null;
    private String mFileDownloadUrl = null;
    private String mFileContentUri = null;
    private String mFileMd5 = null;
    private String mThumbnailUrl = null;
    private String mThumbnailFileUri = null;
    private String mThumbnailMd5 = null;
    private String mLogoUrl = null;
    private String mLogoFileUri = null;
    private String mLogoMd5 = null;
    private String mDownloadUid = null;
    private long mVersion = 0;
    private long mProtocolVersion = 0;
    private long mDownloadTime = 0;
    private long mLastRequestTime = 0;
    private String mCategoryId = null;
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

    public void setStickerId(long OplusGLSurfaceView_15) {
        this.mStickerId = OplusGLSurfaceView_15;
    }

    public String getStickerUUID() {
        return this.mStickerUUID;
    }

    public void setStickerUUID(String str) {
        this.mStickerUUID = str;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public void setCategoryPosition(int OplusGLSurfaceView_13) {
        this.mCategoryPos = OplusGLSurfaceView_13;
    }

    public int getCategoryPosition() {
        return this.mCategoryPos;
    }

    public String getStickerName() {
        return this.mStickerName;
    }

    public void setStickerName(String str) {
        this.mStickerName = str;
    }

    public String getFileDownloadUrl() {
        return this.mFileDownloadUrl;
    }

    public void setFileDownloadUrl(String str) {
        this.mFileDownloadUrl = str;
    }

    public String getFileContentUri() {
        return this.mFileContentUri;
    }

    public void setFileContentUri(String str) {
        this.mFileContentUri = str;
    }

    public String getFileMd5() {
        return this.mFileMd5;
    }

    public void setFileMd5(String str) {
        this.mFileMd5 = str;
    }

    public String getThumbnailUrl() {
        return this.mThumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.mThumbnailUrl = str;
    }

    public String getThumbnailFileUri() {
        return this.mThumbnailFileUri;
    }

    public void setThumbnailFileUri(String str) {
        this.mThumbnailFileUri = str;
    }

    public String getThumbnailMd5() {
        return this.mThumbnailMd5;
    }

    public void setThumbnailMd5(String str) {
        this.mThumbnailMd5 = str;
    }

    public String getLogoUrl() {
        return this.mLogoUrl;
    }

    public void setLogoUrl(String str) {
        this.mLogoUrl = str;
    }

    public String getLogoFileUri() {
        return this.mLogoFileUri;
    }

    public void setLogoFileUri(String str) {
        this.mLogoFileUri = str;
    }

    public String getLogoMd5() {
        return this.mLogoMd5;
    }

    public void setLogoMd5(String str) {
        this.mLogoMd5 = str;
    }

    public String getDownloadUid() {
        return this.mDownloadUid;
    }

    public void setDownloadUid(String str) {
        this.mDownloadUid = str;
    }

    public long getVersion() {
        return this.mVersion;
    }

    public void setVersion(long OplusGLSurfaceView_15) {
        this.mVersion = OplusGLSurfaceView_15;
    }

    public long getProtocolVersion() {
        return this.mProtocolVersion;
    }

    public void setProtocolVersion(long OplusGLSurfaceView_15) {
        this.mProtocolVersion = OplusGLSurfaceView_15;
    }

    public long getDownloadTime() {
        return this.mDownloadTime;
    }

    public void setDownloadTime(long OplusGLSurfaceView_15) {
        this.mDownloadTime = OplusGLSurfaceView_15;
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

    public int getDownloadState() {
        return this.mDownloadState;
    }

    public void setDownloadState(int OplusGLSurfaceView_13) {
        this.mDownloadState = OplusGLSurfaceView_13;
    }

    public long getAttribute() {
        return this.mAttribute;
    }

    public void setAttribute(long OplusGLSurfaceView_15) {
        this.mAttribute = OplusGLSurfaceView_15;
    }

    public boolean hasMusic() {
        return this.mHasMusic;
    }

    public void setHasMusic(boolean z) {
        this.mHasMusic = z;
    }

    public boolean needUpdate() {
        return this.mNeedUpdate;
    }

    public void setNeedUpdate(boolean z) {
        this.mNeedUpdate = z;
    }

    public boolean isBuildIn() {
        return this.mIsBuildIn;
    }

    public void setIsBuildIn(boolean z) {
        this.mIsBuildIn = z;
    }

    public boolean isStickerNew() {
        return this.mIsNew;
    }

    public void setStickerNew(boolean z) {
        this.mIsNew = z;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setValid(boolean z) {
        this.mIsValid = z;
    }

    public int getMaterialType() {
        return this.mMaterialType;
    }

    public void setMaterialType(int OplusGLSurfaceView_13) {
        this.mMaterialType = OplusGLSurfaceView_13;
    }

    public boolean isDownloaded() {
        return this.mDownloadState == 8;
    }

    public boolean isRecycleBin() {
        return RECYCLE_BIN_UUID.equals(this.mStickerUUID);
    }

    public boolean matchAppAttribute(long OplusGLSurfaceView_15) {
        return (this.mAttribute & OplusGLSurfaceView_15) == OplusGLSurfaceView_15;
    }

    public void copy(StickerItem stickerItem) {
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
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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

    public String toString() {
        return "[id_renamed: " + this.mStickerId + ", name: " + this.mStickerName + ", pos: " + this.mPosition + ", cPos: " + this.mCategoryPos + ", state: " + this.mDownloadState + ", dTime: " + this.mDownloadTime + ", ver: " + this.mVersion + ", music:" + this.mHasMusic + ", pVer: " + this.mProtocolVersion + ", attr: " + this.mAttribute + ", buildIn: " + this.mIsBuildIn + ", type: " + this.mMaterialType + "]";
    }
}
