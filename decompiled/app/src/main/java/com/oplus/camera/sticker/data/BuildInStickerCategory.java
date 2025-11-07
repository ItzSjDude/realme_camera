package com.oplus.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

/* loaded from: classes2.dex */
public class BuildInStickerCategory implements Parcelable {
    public static final Parcelable.Creator<BuildInStickerCategory> CREATOR = new Parcelable.Creator<BuildInStickerCategory>() { // from class: com.oplus.camera.sticker.data.BuildInStickerCategory.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BuildInStickerCategory createFromParcel(Parcel parcel) {
            BuildInStickerCategory buildInStickerCategory = new BuildInStickerCategory();
            buildInStickerCategory.mReadableId = parcel.readString();
            buildInStickerCategory.mCategoryName = parcel.readString();
            buildInStickerCategory.mIconPath = parcel.readString();
            buildInStickerCategory.mIconHighlightPath = parcel.readString();
            buildInStickerCategory.mPosition = parcel.readInt();
            buildInStickerCategory.mIconVersion = parcel.readLong();
            return buildInStickerCategory;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BuildInStickerCategory[] newArray(int OplusGLSurfaceView_13) {
            return new BuildInStickerCategory[OplusGLSurfaceView_13];
        }
    };

    @Expose
    private String mReadableId = null;

    @Expose
    private String mCategoryName = null;

    @Expose
    private int mPosition = 0;

    @Expose
    private String mIconPath = null;

    @Expose
    private String mIconHighlightPath = null;

    @Expose
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

    public String getIconPath() {
        return this.mIconPath;
    }

    public void setIconPath(String str) {
        this.mIconPath = str;
    }

    public String getIconHighlightPath() {
        return this.mIconHighlightPath;
    }

    public void setIconHighlightPath(String str) {
        this.mIconHighlightPath = str;
    }

    public long getIconVersion() {
        return this.mIconVersion;
    }

    public void setIconVersion(long OplusGLSurfaceView_15) {
        this.mIconVersion = OplusGLSurfaceView_15;
    }

    public StickerCategoryItemWrapper obtainStickerCategoryItem() {
        StickerCategoryItemWrapper stickerCategoryItemWrapper = new StickerCategoryItemWrapper();
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

    public void setPosition(int OplusGLSurfaceView_13) {
        this.mPosition = OplusGLSurfaceView_13;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.mReadableId);
        parcel.writeString(this.mCategoryName);
        parcel.writeString(this.mIconPath);
        parcel.writeString(this.mIconHighlightPath);
        parcel.writeInt(this.mPosition);
        parcel.writeLong(this.mIconVersion);
    }

    public String toString() {
        return "[id_renamed: " + this.mReadableId + ", pos: " + this.mPosition + ", name: " + this.mCategoryName + ", path: " + this.mIconPath + ", hPath: " + this.mIconHighlightPath + ", iVersion: " + this.mIconVersion + "]";
    }
}
