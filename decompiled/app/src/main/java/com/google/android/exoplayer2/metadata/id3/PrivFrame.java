package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class PrivFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.PrivFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.PrivFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.PrivFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.PrivFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.PrivFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.PrivFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.PrivFrame[i_renamed];
        }
    };
    public static final java.lang.String ID_renamed = "PRIV";
    public final java.lang.String owner;
    public final byte[] privateData;

    public PrivFrame(java.lang.String str, byte[] bArr) {
        super(ID_renamed);
        this.owner = str;
        this.privateData = bArr;
    }

    PrivFrame(android.os.Parcel parcel) {
        super(ID_renamed);
        this.owner = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.privateData = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.PrivFrame privFrame = (com.google.android.exoplayer2.metadata.id3.PrivFrame) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.owner, privFrame.owner) && java.util.Arrays.equals(this.privateData, privFrame.privateData);
    }

    public int hashCode() {
        java.lang.String str = this.owner;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + java.util.Arrays.hashCode(this.privateData);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        return this.id_renamed + ": owner=" + this.owner;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.owner);
        parcel.writeByteArray(this.privateData);
    }
}
