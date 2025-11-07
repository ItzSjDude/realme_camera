package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class BinaryFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.BinaryFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.BinaryFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.BinaryFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.BinaryFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.BinaryFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.BinaryFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.BinaryFrame[i_renamed];
        }
    };
    public final byte[] data;

    public BinaryFrame(java.lang.String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    BinaryFrame(android.os.Parcel parcel) {
        super((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString()));
        this.data = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.BinaryFrame binaryFrame = (com.google.android.exoplayer2.metadata.id3.BinaryFrame) obj;
        return this.id_renamed.equals(binaryFrame.id_renamed) && java.util.Arrays.equals(this.data, binaryFrame.data);
    }

    public int hashCode() {
        return ((527 + this.id_renamed.hashCode()) * 31) + java.util.Arrays.hashCode(this.data);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.id_renamed);
        parcel.writeByteArray(this.data);
    }
}
