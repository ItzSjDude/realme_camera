package com.oplus.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class AnimojiStickerExtendedInfo implements Parcelable {
    public static final Parcelable.Creator<AnimojiStickerExtendedInfo> CREATOR = new Parcelable.Creator<AnimojiStickerExtendedInfo>() { // from class: com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public AnimojiStickerExtendedInfo createFromParcel(Parcel parcel) {
            AnimojiStickerExtendedInfo animojiStickerExtendedInfo = new AnimojiStickerExtendedInfo();
            animojiStickerExtendedInfo.mBackgroundColor = parcel.readString();
            return animojiStickerExtendedInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public AnimojiStickerExtendedInfo[] newArray(int OplusGLSurfaceView_13) {
            return new AnimojiStickerExtendedInfo[OplusGLSurfaceView_13];
        }
    };

    @SerializedName("background_color")
    @Expose
    private String mBackgroundColor = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setBackgroundColor(String str) {
        this.mBackgroundColor = str;
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.mBackgroundColor);
    }

    public String toString() {
        return "[color: " + this.mBackgroundColor + "]";
    }
}
