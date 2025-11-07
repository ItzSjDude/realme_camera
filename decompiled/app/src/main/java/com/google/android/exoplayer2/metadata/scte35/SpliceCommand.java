package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes.dex */
public abstract class SpliceCommand implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
