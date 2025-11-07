package com.oplus.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

/* loaded from: classes2.dex */
public class BuildInSticker implements Parcelable {
    public static final Parcelable.Creator<BuildInSticker> CREATOR = new Parcelable.Creator<BuildInSticker>() { // from class: com.oplus.camera.sticker.data.BuildInSticker.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BuildInSticker createFromParcel(Parcel parcel) {
            BuildInSticker buildInSticker = new BuildInSticker();
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
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BuildInSticker[] newArray(int OplusGLSurfaceView_13) {
            return new BuildInSticker[OplusGLSurfaceView_13];
        }
    };

    @Expose
    private int mMaterialType;

    @Expose
    private long mStickerId = 0;

    @Expose
    private String mStickerUUID = null;

    @Expose
    private String mStickerName = null;

    @Expose
    private String mAssetFilePath = null;

    @Expose
    private String mAssetThumbnailPath = null;

    @Expose
    private long mVersion = 0;

    @Expose
    private long mProtocolVersion = 0;

    @Expose
    private String mCategoryId = null;

    @Expose
    private int mCategoryPos = -1;

    @Expose
    private int mPosition = 0;

    @Expose
    private int mAttribute = 0;

    @Expose
    private boolean mHasMusic = false;

    @Expose
    private String mBackgroundColor = null;

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

    public String getAssetFilePath() {
        return this.mAssetFilePath;
    }

    public void setAssetFilePath(String str) {
        this.mAssetFilePath = str;
    }

    public String getAssetThumbnailPath() {
        return this.mAssetThumbnailPath;
    }

    public void setAssetThumbnailPath(String str) {
        this.mAssetThumbnailPath = str;
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

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int OplusGLSurfaceView_13) {
        this.mPosition = OplusGLSurfaceView_13;
    }

    public int getAttribute() {
        return this.mAttribute;
    }

    public void setAttribute(int OplusGLSurfaceView_13) {
        this.mAttribute = OplusGLSurfaceView_13;
    }

    public boolean getHasMusic() {
        return this.mHasMusic;
    }

    public void setHasMusic(boolean z) {
        this.mHasMusic = z;
    }

    public int getMaterialType() {
        return this.mMaterialType;
    }

    public void setMaterialType(int OplusGLSurfaceView_13) {
        this.mMaterialType = OplusGLSurfaceView_13;
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setBackgroundColor(String str) {
        this.mBackgroundColor = str;
    }

    public StickerItemWrapper obtainStickerItem() {
        StickerItemWrapper stickerItemWrapper = new StickerItemWrapper();
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
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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

    public String toString() {
        return "[pos: " + this.mPosition + ", attr: " + this.mAttribute + ", cPos: " + this.mCategoryPos + ", ver: " + this.mVersion + ", pVer: " + this.mProtocolVersion + ", music: " + this.mHasMusic + ", type: " + this.mMaterialType + ", color: " + this.mBackgroundColor + ", name: " + this.mStickerName + ", path: " + this.mAssetFilePath + ", tPath: " + this.mAssetThumbnailPath + "]";
    }
}
