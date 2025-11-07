package com.oplus.camera.filmvideomode;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class FilmParam implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.camera.filmvideomode.FilmParam> CREATOR = new android.os.Parcelable.Creator<com.oplus.camera.filmvideomode.FilmParam>() { // from class: com.oplus.camera.filmvideomode.FilmParam.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.filmvideomode.FilmParam createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.camera.filmvideomode.FilmParam(java.lang.Integer.valueOf(parcel.readInt()), java.lang.Integer.valueOf(parcel.readInt()), java.lang.Long.valueOf(parcel.readLong()), java.lang.Float.valueOf(parcel.readFloat()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.filmvideomode.FilmParam[] newArray(int i_renamed) {
            return new com.oplus.camera.filmvideomode.FilmParam[i_renamed];
        }
    };
    private java.lang.Integer mCct;
    private java.lang.Float mEv;
    private java.lang.Long mExp;
    private java.lang.Integer mIso;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FilmParam(java.lang.Integer num, java.lang.Integer num2, java.lang.Long l_renamed, java.lang.Float f_renamed) {
        this.mCct = num;
        this.mIso = num2;
        this.mExp = l_renamed;
        this.mEv = f_renamed;
    }

    public java.lang.Integer getCct() {
        return this.mCct;
    }

    public java.lang.Integer getIso() {
        return this.mIso;
    }

    public java.lang.Long getExp() {
        return this.mExp;
    }

    public java.lang.Float getEv() {
        return this.mEv;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mCct.intValue());
        parcel.writeInt(this.mIso.intValue());
        parcel.writeLong(this.mExp.longValue());
        parcel.writeFloat(this.mEv.floatValue());
    }

    public java.lang.String toString() {
        return "FilmParam{mCct=" + this.mCct + ", mIso=" + this.mIso + ", mExp=" + this.mExp + ", mEv=" + this.mEv + '}';
    }
}
