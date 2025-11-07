package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class TrackGroup implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroup> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroup>() { // from class: com.google.android.exoplayer2.source.TrackGroup.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.source.TrackGroup createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.source.TrackGroup(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.source.TrackGroup[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.source.TrackGroup[i_renamed];
        }
    };
    private final com.google.android.exoplayer2.Format[] formats;
    private int hashCode;
    public final int length;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TrackGroup(com.google.android.exoplayer2.Format... formatArr) {
        com.google.android.exoplayer2.util.Assertions.checkState(formatArr.length > 0);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    TrackGroup(android.os.Parcel parcel) {
        this.length = parcel.readInt();
        this.formats = new com.google.android.exoplayer2.Format[this.length];
        for (int i_renamed = 0; i_renamed < this.length; i_renamed++) {
            this.formats[i_renamed] = (com.google.android.exoplayer2.Format) parcel.readParcelable(com.google.android.exoplayer2.Format.class.getClassLoader());
        }
    }

    public com.google.android.exoplayer2.Format getFormat(int i_renamed) {
        return this.formats[i_renamed];
    }

    public int indexOf(com.google.android.exoplayer2.Format format) {
        int i_renamed = 0;
        while (true) {
            com.google.android.exoplayer2.Format[] formatArr = this.formats;
            if (i_renamed >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i_renamed]) {
                return i_renamed;
            }
            i_renamed++;
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + java.util.Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.TrackGroup trackGroup = (com.google.android.exoplayer2.source.TrackGroup) obj;
        return this.length == trackGroup.length && java.util.Arrays.equals(this.formats, trackGroup.formats);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.length);
        for (int i2 = 0; i2 < this.length; i2++) {
            parcel.writeParcelable(this.formats[i2], 0);
        }
    }
}
