package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class AnimojiStickerExtendedInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo> CREATOR = new android.os.Parcelable.Creator<com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo>() { // from class: com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo createFromParcel(android.os.Parcel parcel) {
            com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo animojiStickerExtendedInfo = new com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo();
            animojiStickerExtendedInfo.mBackgroundColor = parcel.readString();
            return animojiStickerExtendedInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo[] newArray(int i_renamed) {
            return new com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo[i_renamed];
        }
    };

    @com.google.gson.annotations.SerializedName("background_color")
    @com.google.gson.annotations.Expose
    private java.lang.String mBackgroundColor = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setBackgroundColor(java.lang.String str) {
        this.mBackgroundColor = str;
    }

    public java.lang.String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mBackgroundColor);
    }

    public java.lang.String toString() {
        return "[color: " + this.mBackgroundColor + "]";
    }
}
