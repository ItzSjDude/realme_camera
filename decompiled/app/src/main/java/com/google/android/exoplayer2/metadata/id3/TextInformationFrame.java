package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class TextInformationFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.TextInformationFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.TextInformationFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.TextInformationFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.TextInformationFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.TextInformationFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame[i_renamed];
        }
    };
    public final java.lang.String description;
    public final java.lang.String value;

    public TextInformationFrame(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    TextInformationFrame(android.os.Parcel parcel) {
        super((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString()));
        this.description = parcel.readString();
        this.value = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.TextInformationFrame textInformationFrame = (com.google.android.exoplayer2.metadata.id3.TextInformationFrame) obj;
        return this.id_renamed.equals(textInformationFrame.id_renamed) && com.google.android.exoplayer2.util.Util.areEqual(this.description, textInformationFrame.description) && com.google.android.exoplayer2.util.Util.areEqual(this.value, textInformationFrame.value);
    }

    public int hashCode() {
        int iHashCode = (527 + this.id_renamed.hashCode()) * 31;
        java.lang.String str = this.description;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.value;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        return this.id_renamed + ": value=" + this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.id_renamed);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
