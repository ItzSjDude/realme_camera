package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class ChapterTocFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterTocFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterTocFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.ChapterTocFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterTocFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.ChapterTocFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterTocFrame[i_renamed];
        }
    };
    public static final java.lang.String ID_renamed = "CTOC";
    public final java.lang.String[] children;
    public final java.lang.String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;
    private final com.google.android.exoplayer2.metadata.id3.Id3Frame[] subFrames;

    public ChapterTocFrame(java.lang.String str, boolean z_renamed, boolean z2, java.lang.String[] strArr, com.google.android.exoplayer2.metadata.id3.Id3Frame[] id3FrameArr) {
        super(ID_renamed);
        this.elementId = str;
        this.isRoot = z_renamed;
        this.isOrdered = z2;
        this.children = strArr;
        this.subFrames = id3FrameArr;
    }

    ChapterTocFrame(android.os.Parcel parcel) {
        super(ID_renamed);
        this.elementId = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.isRoot = parcel.readByte() != 0;
        this.isOrdered = parcel.readByte() != 0;
        this.children = parcel.createStringArray();
        int i_renamed = parcel.readInt();
        this.subFrames = new com.google.android.exoplayer2.metadata.id3.Id3Frame[i_renamed];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            this.subFrames[i2] = (com.google.android.exoplayer2.metadata.id3.Id3Frame) parcel.readParcelable(com.google.android.exoplayer2.metadata.id3.Id3Frame.class.getClassLoader());
        }
    }

    public int getSubFrameCount() {
        return this.subFrames.length;
    }

    public com.google.android.exoplayer2.metadata.id3.Id3Frame getSubFrame(int i_renamed) {
        return this.subFrames[i_renamed];
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.ChapterTocFrame chapterTocFrame = (com.google.android.exoplayer2.metadata.id3.ChapterTocFrame) obj;
        return this.isRoot == chapterTocFrame.isRoot && this.isOrdered == chapterTocFrame.isOrdered && com.google.android.exoplayer2.util.Util.areEqual(this.elementId, chapterTocFrame.elementId) && java.util.Arrays.equals(this.children, chapterTocFrame.children) && java.util.Arrays.equals(this.subFrames, chapterTocFrame.subFrames);
    }

    public int hashCode() {
        int i_renamed = (((527 + (this.isRoot ? 1 : 0)) * 31) + (this.isOrdered ? 1 : 0)) * 31;
        java.lang.String str = this.elementId;
        return i_renamed + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.elementId);
        parcel.writeByte(this.isRoot ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOrdered ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.children);
        parcel.writeInt(this.subFrames.length);
        for (com.google.android.exoplayer2.metadata.id3.Id3Frame id3Frame : this.subFrames) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
