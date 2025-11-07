package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class TrackGroupArray implements android.os.Parcelable {
    private int hashCode;
    public final int length;
    private final com.google.android.exoplayer2.source.TrackGroup[] trackGroups;
    public static final com.google.android.exoplayer2.source.TrackGroupArray EMPTY = new com.google.android.exoplayer2.source.TrackGroupArray(new com.google.android.exoplayer2.source.TrackGroup[0]);
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroupArray> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroupArray>() { // from class: com.google.android.exoplayer2.source.TrackGroupArray.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.source.TrackGroupArray createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.source.TrackGroupArray(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.source.TrackGroupArray[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.source.TrackGroupArray[i_renamed];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TrackGroupArray(com.google.android.exoplayer2.source.TrackGroup... trackGroupArr) {
        this.trackGroups = trackGroupArr;
        this.length = trackGroupArr.length;
    }

    TrackGroupArray(android.os.Parcel parcel) {
        this.length = parcel.readInt();
        this.trackGroups = new com.google.android.exoplayer2.source.TrackGroup[this.length];
        for (int i_renamed = 0; i_renamed < this.length; i_renamed++) {
            this.trackGroups[i_renamed] = (com.google.android.exoplayer2.source.TrackGroup) parcel.readParcelable(com.google.android.exoplayer2.source.TrackGroup.class.getClassLoader());
        }
    }

    public com.google.android.exoplayer2.source.TrackGroup get(int i_renamed) {
        return this.trackGroups[i_renamed];
    }

    public int indexOf(com.google.android.exoplayer2.source.TrackGroup trackGroup) {
        for (int i_renamed = 0; i_renamed < this.length; i_renamed++) {
            if (this.trackGroups[i_renamed] == trackGroup) {
                return i_renamed;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = java.util.Arrays.hashCode(this.trackGroups);
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
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray = (com.google.android.exoplayer2.source.TrackGroupArray) obj;
        return this.length == trackGroupArray.length && java.util.Arrays.equals(this.trackGroups, trackGroupArray.trackGroups);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.length);
        for (int i2 = 0; i2 < this.length; i2++) {
            parcel.writeParcelable(this.trackGroups[i2], 0);
        }
    }
}
