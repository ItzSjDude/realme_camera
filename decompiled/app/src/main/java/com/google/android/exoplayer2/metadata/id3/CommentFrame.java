package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class CommentFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.CommentFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.CommentFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.CommentFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.CommentFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.CommentFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.CommentFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.CommentFrame[i_renamed];
        }
    };
    public static final java.lang.String ID_renamed = "COMM";
    public final java.lang.String description;
    public final java.lang.String language;
    public final java.lang.String text;

    public CommentFrame(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(ID_renamed);
        this.language = str;
        this.description = str2;
        this.text = str3;
    }

    CommentFrame(android.os.Parcel parcel) {
        super(ID_renamed);
        this.language = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
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
        com.google.android.exoplayer2.metadata.id3.CommentFrame commentFrame = (com.google.android.exoplayer2.metadata.id3.CommentFrame) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.description, commentFrame.description) && com.google.android.exoplayer2.util.Util.areEqual(this.language, commentFrame.language) && com.google.android.exoplayer2.util.Util.areEqual(this.text, commentFrame.text);
    }

    public int hashCode() {
        java.lang.String str = this.language;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.text;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        return this.id_renamed + ": language=" + this.language + ", description=" + this.description;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.id_renamed);
        parcel.writeString(this.language);
        parcel.writeString(this.text);
    }
}
