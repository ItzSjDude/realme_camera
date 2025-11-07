package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public abstract class Id3Frame implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public final java.lang.String id_renamed;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Id3Frame(java.lang.String str) {
        this.id_renamed = str;
    }

    public java.lang.String toString() {
        return this.id_renamed;
    }
}
