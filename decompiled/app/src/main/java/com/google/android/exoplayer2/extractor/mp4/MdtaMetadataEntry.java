package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
public final class MdtaMetadataEntry implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry>() { // from class: com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry[i_renamed];
        }
    };
    public final java.lang.String key;
    public final int localeIndicator;
    public final int typeIndicator;
    public final byte[] value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MdtaMetadataEntry(java.lang.String str, byte[] bArr, int i_renamed, int i2) {
        this.key = str;
        this.value = bArr;
        this.localeIndicator = i_renamed;
        this.typeIndicator = i2;
    }

    private MdtaMetadataEntry(android.os.Parcel parcel) {
        this.key = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.value = new byte[parcel.readInt()];
        parcel.readByteArray(this.value);
        this.localeIndicator = parcel.readInt();
        this.typeIndicator = parcel.readInt();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry mdtaMetadataEntry = (com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry) obj;
        return this.key.equals(mdtaMetadataEntry.key) && java.util.Arrays.equals(this.value, mdtaMetadataEntry.value) && this.localeIndicator == mdtaMetadataEntry.localeIndicator && this.typeIndicator == mdtaMetadataEntry.typeIndicator;
    }

    public int hashCode() {
        return ((((((527 + this.key.hashCode()) * 31) + java.util.Arrays.hashCode(this.value)) * 31) + this.localeIndicator) * 31) + this.typeIndicator;
    }

    public java.lang.String toString() {
        return "mdta: key=" + this.key;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.key);
        parcel.writeInt(this.value.length);
        parcel.writeByteArray(this.value);
        parcel.writeInt(this.localeIndicator);
        parcel.writeInt(this.typeIndicator);
    }
}
