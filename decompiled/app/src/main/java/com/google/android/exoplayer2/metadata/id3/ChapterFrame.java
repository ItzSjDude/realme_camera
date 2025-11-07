package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class ChapterFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.ChapterFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.ChapterFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.ChapterFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterFrame[i_renamed];
        }
    };
    public static final java.lang.String ID_renamed = "CHAP";
    public final java.lang.String chapterId;
    public final long endOffset;
    public final int endTimeMs;
    public final long startOffset;
    public final int startTimeMs;
    private final com.google.android.exoplayer2.metadata.id3.Id3Frame[] subFrames;

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ChapterFrame(java.lang.String str, int i_renamed, int i2, long j_renamed, long j2, com.google.android.exoplayer2.metadata.id3.Id3Frame[] id3FrameArr) {
        super(ID_renamed);
        this.chapterId = str;
        this.startTimeMs = i_renamed;
        this.endTimeMs = i2;
        this.startOffset = j_renamed;
        this.endOffset = j2;
        this.subFrames = id3FrameArr;
    }

    ChapterFrame(android.os.Parcel parcel) {
        super(ID_renamed);
        this.chapterId = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.startTimeMs = parcel.readInt();
        this.endTimeMs = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.endOffset = parcel.readLong();
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
        com.google.android.exoplayer2.metadata.id3.ChapterFrame chapterFrame = (com.google.android.exoplayer2.metadata.id3.ChapterFrame) obj;
        return this.startTimeMs == chapterFrame.startTimeMs && this.endTimeMs == chapterFrame.endTimeMs && this.startOffset == chapterFrame.startOffset && this.endOffset == chapterFrame.endOffset && com.google.android.exoplayer2.util.Util.areEqual(this.chapterId, chapterFrame.chapterId) && java.util.Arrays.equals(this.subFrames, chapterFrame.subFrames);
    }

    public int hashCode() {
        int i_renamed = (((((((527 + this.startTimeMs) * 31) + this.endTimeMs) * 31) + ((int) this.startOffset)) * 31) + ((int) this.endOffset)) * 31;
        java.lang.String str = this.chapterId;
        return i_renamed + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.chapterId);
        parcel.writeInt(this.startTimeMs);
        parcel.writeInt(this.endTimeMs);
        parcel.writeLong(this.startOffset);
        parcel.writeLong(this.endOffset);
        parcel.writeInt(this.subFrames.length);
        for (com.google.android.exoplayer2.metadata.id3.Id3Frame id3Frame : this.subFrames) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
