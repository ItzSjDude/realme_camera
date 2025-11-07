package com.oplus.camera.filmvideomode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes2.dex */
public class FilmParam implements Parcelable {
    public static final Parcelable.Creator<FilmParam> CREATOR = new Parcelable.Creator<FilmParam>() { // from class: com.oplus.camera.filmvideomode.FilmParam.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public FilmParam createFromParcel(Parcel parcel) {
            return new FilmParam(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Long.valueOf(parcel.readLong()), Float.valueOf(parcel.readFloat()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public FilmParam[] newArray(int OplusGLSurfaceView_13) {
            return new FilmParam[OplusGLSurfaceView_13];
        }
    };
    private Integer mCct;
    private Float mEv;
    private Long mExp;
    private Integer mIso;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FilmParam(Integer num, Integer num2, Long OplusGLSurfaceView_14, Float COUIBaseListPopupWindow_12) {
        this.mCct = num;
        this.mIso = num2;
        this.mExp = OplusGLSurfaceView_14;
        this.mEv = COUIBaseListPopupWindow_12;
    }

    public Integer getCct() {
        return this.mCct;
    }

    public Integer getIso() {
        return this.mIso;
    }

    public Long getExp() {
        return this.mExp;
    }

    public Float getEv() {
        return this.mEv;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mCct.intValue());
        parcel.writeInt(this.mIso.intValue());
        parcel.writeLong(this.mExp.longValue());
        parcel.writeFloat(this.mEv.floatValue());
    }

    public String toString() {
        return "FilmParam{mCct=" + this.mCct + ", mIso=" + this.mIso + ", mExp=" + this.mExp + ", mEv=" + this.mEv + '}';
    }
}
