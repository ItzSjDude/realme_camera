package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class MultiStickerExtendedInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> CREATOR = new android.os.Parcelable.Creator<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>() { // from class: com.oplus.camera.sticker.data.MultiStickerExtendedInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.MultiStickerExtendedInfo createFromParcel(android.os.Parcel parcel) {
            com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo = new com.oplus.camera.sticker.data.MultiStickerExtendedInfo();
            multiStickerExtendedInfo.mStickerName = parcel.readString();
            multiStickerExtendedInfo.mIsFitToSize = parcel.readInt() != 0;
            multiStickerExtendedInfo.mPositionType = parcel.readInt();
            multiStickerExtendedInfo.mZPosition = parcel.readInt();
            multiStickerExtendedInfo.mBaseSize16x9 = parcel.readString();
            multiStickerExtendedInfo.mDisplayRect16x9 = parcel.readString();
            multiStickerExtendedInfo.mFileContentUri16x9 = parcel.readString();
            multiStickerExtendedInfo.mBaseSize4x3 = parcel.readString();
            multiStickerExtendedInfo.mDisplayRect4x3 = parcel.readString();
            multiStickerExtendedInfo.mFileContentUri4x3 = parcel.readString();
            multiStickerExtendedInfo.mBaseSize1x1 = parcel.readString();
            multiStickerExtendedInfo.mDisplayRect1x1 = parcel.readString();
            multiStickerExtendedInfo.mFileContentUri1x1 = parcel.readString();
            return multiStickerExtendedInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.MultiStickerExtendedInfo[] newArray(int i_renamed) {
            return new com.oplus.camera.sticker.data.MultiStickerExtendedInfo[i_renamed];
        }
    };
    public static final int POSITION_TYPE_BACKGROUND = 2;
    public static final int POSITION_TYPE_FOREGROUND = 0;
    public static final int POSITION_TYPE_NORMAL = 1;

    @com.google.gson.annotations.SerializedName("mBaseSize16_9")
    @com.google.gson.annotations.Expose
    private java.lang.String mBaseSize16x9;

    @com.google.gson.annotations.SerializedName("mBaseSize1_1")
    @com.google.gson.annotations.Expose
    private java.lang.String mBaseSize1x1;

    @com.google.gson.annotations.SerializedName("mBaseSize4_3")
    @com.google.gson.annotations.Expose
    private java.lang.String mBaseSize4x3;

    @com.google.gson.annotations.SerializedName("mDisplayRect16_9")
    @com.google.gson.annotations.Expose
    private java.lang.String mDisplayRect16x9;

    @com.google.gson.annotations.SerializedName("mDisplayRect1_1")
    @com.google.gson.annotations.Expose
    private java.lang.String mDisplayRect1x1;

    @com.google.gson.annotations.SerializedName("mDisplayRect4_3")
    @com.google.gson.annotations.Expose
    private java.lang.String mDisplayRect4x3;
    private java.lang.String mFileContentUri16x9;
    private java.lang.String mFileContentUri1x1;
    private java.lang.String mFileContentUri4x3;

    @com.google.gson.annotations.SerializedName("mbStickerFitToSize")
    @com.google.gson.annotations.Expose
    private boolean mIsFitToSize;

    @com.google.gson.annotations.Expose
    private int mPositionType;

    @com.google.gson.annotations.Expose
    private java.lang.String mStickerName;

    @com.google.gson.annotations.Expose
    private int mZPosition;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getStickerName() {
        return this.mStickerName;
    }

    public void setStickerName(java.lang.String str) {
        this.mStickerName = str;
    }

    public boolean getIsFitToSize() {
        return this.mIsFitToSize;
    }

    public void setIsFitToSize(boolean z_renamed) {
        this.mIsFitToSize = z_renamed;
    }

    public int getPositionType() {
        return this.mPositionType;
    }

    public void setPositionType(int i_renamed) {
        this.mPositionType = i_renamed;
    }

    public int getZPosition() {
        return this.mZPosition;
    }

    public void setZPosition(int i_renamed) {
        this.mZPosition = i_renamed;
    }

    public java.lang.String getBaseSize16x9() {
        return this.mBaseSize16x9;
    }

    public void setBaseSize16x9(java.lang.String str) {
        this.mBaseSize16x9 = str;
    }

    public java.lang.String getDisplayRect16x9() {
        return this.mDisplayRect16x9;
    }

    public void setDisplayRect16x9(java.lang.String str) {
        this.mDisplayRect16x9 = str;
    }

    public java.lang.String getBaseSize4x3() {
        return this.mBaseSize4x3;
    }

    public void setBaseSize4x3(java.lang.String str) {
        this.mBaseSize4x3 = str;
    }

    public java.lang.String getDisplayRect4x3() {
        return this.mDisplayRect4x3;
    }

    public void setDisplayRect4x3(java.lang.String str) {
        this.mDisplayRect4x3 = str;
    }

    public java.lang.String getBaseSize1x1() {
        return this.mBaseSize1x1;
    }

    public void setBaseSize1x1(java.lang.String str) {
        this.mBaseSize1x1 = str;
    }

    public java.lang.String getDisplayRect1x1() {
        return this.mDisplayRect1x1;
    }

    public void setDisplayRect1x1(java.lang.String str) {
        this.mDisplayRect1x1 = str;
    }

    public java.lang.String getFileContentUri16x9() {
        return this.mFileContentUri16x9;
    }

    public void setFileContentUri16x9(java.lang.String str) {
        this.mFileContentUri16x9 = str;
    }

    public java.lang.String getFileContentUri4x3() {
        return this.mFileContentUri4x3;
    }

    public void setFileContentUri4x3(java.lang.String str) {
        this.mFileContentUri4x3 = str;
    }

    public java.lang.String getFileContentUri1x1() {
        return this.mFileContentUri1x1;
    }

    public void setFileContentUri1x1(java.lang.String str) {
        this.mFileContentUri1x1 = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mStickerName);
        parcel.writeInt(this.mIsFitToSize ? 1 : 0);
        parcel.writeInt(this.mPositionType);
        parcel.writeInt(this.mZPosition);
        parcel.writeString(this.mBaseSize16x9);
        parcel.writeString(this.mDisplayRect16x9);
        parcel.writeString(this.mFileContentUri16x9);
        parcel.writeString(this.mBaseSize4x3);
        parcel.writeString(this.mDisplayRect4x3);
        parcel.writeString(this.mFileContentUri4x3);
        parcel.writeString(this.mBaseSize1x1);
        parcel.writeString(this.mDisplayRect1x1);
        parcel.writeString(this.mFileContentUri1x1);
    }

    public java.lang.String toString() {
        return "[name: " + this.mStickerName + ", fit: " + this.mIsFitToSize + ", pType: " + this.mPositionType + ", zPos: " + this.mZPosition + ", BS16: " + this.mBaseSize16x9 + ", DR16: " + this.mDisplayRect16x9 + ", BS4: " + this.mBaseSize4x3 + ", DR4: " + this.mDisplayRect4x3 + ", BS1: " + this.mBaseSize1x1 + ", DR1: " + this.mDisplayRect1x1 + "]";
    }
}
