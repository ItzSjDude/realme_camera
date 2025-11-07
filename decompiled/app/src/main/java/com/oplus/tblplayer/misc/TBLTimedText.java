package com.oplus.tblplayer.misc;

/* loaded from: classes2.dex */
public final class TBLTimedText implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.tblplayer.misc.TBLTimedText> CREATOR = new android.os.Parcelable.Creator<com.oplus.tblplayer.misc.TBLTimedText>() { // from class: com.oplus.tblplayer.misc.TBLTimedText.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.misc.TBLTimedText createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.tblplayer.misc.TBLTimedText(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.misc.TBLTimedText[] newArray(int i_renamed) {
            return new com.oplus.tblplayer.misc.TBLTimedText[i_renamed];
        }
    };
    private android.graphics.Rect mTextBounds;
    private java.lang.String mTextChars;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TBLTimedText(android.graphics.Rect rect, java.lang.String str) {
        this.mTextBounds = null;
        this.mTextChars = null;
        this.mTextBounds = rect;
        this.mTextChars = str;
    }

    protected TBLTimedText(android.os.Parcel parcel) {
        this.mTextBounds = null;
        this.mTextChars = null;
        this.mTextBounds = (android.graphics.Rect) parcel.readParcelable(android.graphics.Rect.class.getClassLoader());
        this.mTextChars = parcel.readString();
    }

    public android.graphics.Rect getBounds() {
        return this.mTextBounds;
    }

    public java.lang.String getText() {
        return this.mTextChars;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeParcelable(this.mTextBounds, i_renamed);
        parcel.writeString(this.mTextChars);
    }
}
