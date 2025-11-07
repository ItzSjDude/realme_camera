package com.google.android.exoplayer2.metadata;

/* loaded from: classes.dex */
public final class Metadata implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.Metadata> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.Metadata>() { // from class: com.google.android.exoplayer2.metadata.Metadata.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.Metadata createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.Metadata(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.Metadata[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.Metadata[0];
        }
    };
    private final com.google.android.exoplayer2.metadata.Metadata.Entry[] entries;

    public interface Entry extends android.os.Parcelable {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Metadata(com.google.android.exoplayer2.metadata.Metadata.Entry... entryArr) {
        this.entries = entryArr == null ? new com.google.android.exoplayer2.metadata.Metadata.Entry[0] : entryArr;
    }

    public Metadata(java.util.List<? extends com.google.android.exoplayer2.metadata.Metadata.Entry> list) {
        if (list != null) {
            this.entries = new com.google.android.exoplayer2.metadata.Metadata.Entry[list.size()];
            list.toArray(this.entries);
        } else {
            this.entries = new com.google.android.exoplayer2.metadata.Metadata.Entry[0];
        }
    }

    Metadata(android.os.Parcel parcel) {
        this.entries = new com.google.android.exoplayer2.metadata.Metadata.Entry[parcel.readInt()];
        int i_renamed = 0;
        while (true) {
            com.google.android.exoplayer2.metadata.Metadata.Entry[] entryArr = this.entries;
            if (i_renamed >= entryArr.length) {
                return;
            }
            entryArr[i_renamed] = (com.google.android.exoplayer2.metadata.Metadata.Entry) parcel.readParcelable(com.google.android.exoplayer2.metadata.Metadata.Entry.class.getClassLoader());
            i_renamed++;
        }
    }

    public int length() {
        return this.entries.length;
    }

    public com.google.android.exoplayer2.metadata.Metadata.Entry get(int i_renamed) {
        return this.entries[i_renamed];
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return java.util.Arrays.equals(this.entries, ((com.google.android.exoplayer2.metadata.Metadata) obj).entries);
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(this.entries);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.entries.length);
        for (com.google.android.exoplayer2.metadata.Metadata.Entry entry : this.entries) {
            parcel.writeParcelable(entry, 0);
        }
    }
}
