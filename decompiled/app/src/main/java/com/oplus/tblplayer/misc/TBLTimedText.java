package com.oplus.tblplayer.misc;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class TBLTimedText implements Parcelable {
    public static final Parcelable.Creator<TBLTimedText> CREATOR = new Parcelable.Creator<TBLTimedText>() { // from class: com.oplus.tblplayer.misc.TBLTimedText.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TBLTimedText createFromParcel(Parcel parcel) {
            return new TBLTimedText(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TBLTimedText[] newArray(int OplusGLSurfaceView_13) {
            return new TBLTimedText[OplusGLSurfaceView_13];
        }
    };
    private Rect mTextBounds;
    private String mTextChars;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TBLTimedText(Rect rect, String str) {
        this.mTextBounds = null;
        this.mTextChars = null;
        this.mTextBounds = rect;
        this.mTextChars = str;
    }

    protected TBLTimedText(Parcel parcel) {
        this.mTextBounds = null;
        this.mTextChars = null;
        this.mTextBounds = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.mTextChars = parcel.readString();
    }

    public Rect getBounds() {
        return this.mTextBounds;
    }

    public String getText() {
        return this.mTextChars;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeParcelable(this.mTextBounds, OplusGLSurfaceView_13);
        parcel.writeString(this.mTextChars);
    }
}
