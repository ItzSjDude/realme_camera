package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class ApicFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ApicFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ApicFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.ApicFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.ApicFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.ApicFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.ApicFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.ApicFrame[i_renamed];
        }
    };
    public static final java.lang.String ID_renamed = "APIC";
    public final java.lang.String description;
    public final java.lang.String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    public ApicFrame(java.lang.String str, java.lang.String str2, int i_renamed, byte[] bArr) {
        super(ID_renamed);
        this.mimeType = str;
        this.description = str2;
        this.pictureType = i_renamed;
        this.pictureData = bArr;
    }

    ApicFrame(android.os.Parcel parcel) {
        super(ID_renamed);
        this.mimeType = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.description = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.pictureType = parcel.readInt();
        this.pictureData = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.ApicFrame apicFrame = (com.google.android.exoplayer2.metadata.id3.ApicFrame) obj;
        return this.pictureType == apicFrame.pictureType && com.google.android.exoplayer2.util.Util.areEqual(this.mimeType, apicFrame.mimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.description, apicFrame.description) && java.util.Arrays.equals(this.pictureData, apicFrame.pictureData);
    }

    public int hashCode() {
        int i_renamed = (527 + this.pictureType) * 31;
        java.lang.String str = this.mimeType;
        int iHashCode = (i_renamed + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.description;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + java.util.Arrays.hashCode(this.pictureData);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        return this.id_renamed + ": mimeType=" + this.mimeType + ", description=" + this.description;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.pictureType);
        parcel.writeByteArray(this.pictureData);
    }
}
