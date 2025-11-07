package com.oplus.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class MultiStickerExtendedInfo implements Parcelable {
    public static final Parcelable.Creator<MultiStickerExtendedInfo> CREATOR = new Parcelable.Creator<MultiStickerExtendedInfo>() { // from class: com.oplus.camera.sticker.data.MultiStickerExtendedInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public MultiStickerExtendedInfo createFromParcel(Parcel parcel) {
            MultiStickerExtendedInfo multiStickerExtendedInfo = new MultiStickerExtendedInfo();
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
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public MultiStickerExtendedInfo[] newArray(int OplusGLSurfaceView_13) {
            return new MultiStickerExtendedInfo[OplusGLSurfaceView_13];
        }
    };
    public static final int POSITION_TYPE_BACKGROUND = 2;
    public static final int POSITION_TYPE_FOREGROUND = 0;
    public static final int POSITION_TYPE_NORMAL = 1;

    @SerializedName("mBaseSize16_9")
    @Expose
    private String mBaseSize16x9;

    @SerializedName("mBaseSize1_1")
    @Expose
    private String mBaseSize1x1;

    @SerializedName("mBaseSize4_3")
    @Expose
    private String mBaseSize4x3;

    @SerializedName("mDisplayRect16_9")
    @Expose
    private String mDisplayRect16x9;

    @SerializedName("mDisplayRect1_1")
    @Expose
    private String mDisplayRect1x1;

    @SerializedName("mDisplayRect4_3")
    @Expose
    private String mDisplayRect4x3;
    private String mFileContentUri16x9;
    private String mFileContentUri1x1;
    private String mFileContentUri4x3;

    @SerializedName("mbStickerFitToSize")
    @Expose
    private boolean mIsFitToSize;

    @Expose
    private int mPositionType;

    @Expose
    private String mStickerName;

    @Expose
    private int mZPosition;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getStickerName() {
        return this.mStickerName;
    }

    public void setStickerName(String str) {
        this.mStickerName = str;
    }

    public boolean getIsFitToSize() {
        return this.mIsFitToSize;
    }

    public void setIsFitToSize(boolean z) {
        this.mIsFitToSize = z;
    }

    public int getPositionType() {
        return this.mPositionType;
    }

    public void setPositionType(int OplusGLSurfaceView_13) {
        this.mPositionType = OplusGLSurfaceView_13;
    }

    public int getZPosition() {
        return this.mZPosition;
    }

    public void setZPosition(int OplusGLSurfaceView_13) {
        this.mZPosition = OplusGLSurfaceView_13;
    }

    public String getBaseSize16x9() {
        return this.mBaseSize16x9;
    }

    public void setBaseSize16x9(String str) {
        this.mBaseSize16x9 = str;
    }

    public String getDisplayRect16x9() {
        return this.mDisplayRect16x9;
    }

    public void setDisplayRect16x9(String str) {
        this.mDisplayRect16x9 = str;
    }

    public String getBaseSize4x3() {
        return this.mBaseSize4x3;
    }

    public void setBaseSize4x3(String str) {
        this.mBaseSize4x3 = str;
    }

    public String getDisplayRect4x3() {
        return this.mDisplayRect4x3;
    }

    public void setDisplayRect4x3(String str) {
        this.mDisplayRect4x3 = str;
    }

    public String getBaseSize1x1() {
        return this.mBaseSize1x1;
    }

    public void setBaseSize1x1(String str) {
        this.mBaseSize1x1 = str;
    }

    public String getDisplayRect1x1() {
        return this.mDisplayRect1x1;
    }

    public void setDisplayRect1x1(String str) {
        this.mDisplayRect1x1 = str;
    }

    public String getFileContentUri16x9() {
        return this.mFileContentUri16x9;
    }

    public void setFileContentUri16x9(String str) {
        this.mFileContentUri16x9 = str;
    }

    public String getFileContentUri4x3() {
        return this.mFileContentUri4x3;
    }

    public void setFileContentUri4x3(String str) {
        this.mFileContentUri4x3 = str;
    }

    public String getFileContentUri1x1() {
        return this.mFileContentUri1x1;
    }

    public void setFileContentUri1x1(String str) {
        this.mFileContentUri1x1 = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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

    public String toString() {
        return "[name: " + this.mStickerName + ", fit: " + this.mIsFitToSize + ", pType: " + this.mPositionType + ", zPos: " + this.mZPosition + ", BS16: " + this.mBaseSize16x9 + ", DR16: " + this.mDisplayRect16x9 + ", BS4: " + this.mBaseSize4x3 + ", DR4: " + this.mDisplayRect4x3 + ", BS1: " + this.mBaseSize1x1 + ", DR1: " + this.mDisplayRect1x1 + "]";
    }
}
