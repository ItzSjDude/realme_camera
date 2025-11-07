package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class InternalFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.InternalFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.InternalFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.InternalFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.InternalFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.InternalFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.InternalFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.InternalFrame[i_renamed];
        }
    };
    public static final java.lang.String ID_renamed = "----";
    public final java.lang.String description;
    public final java.lang.String domain;
    public final java.lang.String text;

    public InternalFrame(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(ID_renamed);
        this.domain = str;
        this.description = str2;
        this.text = str3;
    }

    InternalFrame(android.os.Parcel parcel) {
        super(ID_renamed);
        this.domain = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.description = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.text = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.InternalFrame internalFrame = (com.google.android.exoplayer2.metadata.id3.InternalFrame) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.description, internalFrame.description) && com.google.android.exoplayer2.util.Util.areEqual(this.domain, internalFrame.domain) && com.google.android.exoplayer2.util.Util.areEqual(this.text, internalFrame.text);
    }

    public int hashCode() {
        java.lang.String str = this.domain;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.text;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        return this.id_renamed + ": domain=" + this.domain + ", description=" + this.description;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.id_renamed);
        parcel.writeString(this.domain);
        parcel.writeString(this.text);
    }
}
