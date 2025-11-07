package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes.dex */
public final class MlltFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.MlltFrame> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.MlltFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.MlltFrame.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.MlltFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.MlltFrame(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.id3.MlltFrame[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.id3.MlltFrame[i_renamed];
        }
    };
    public static final java.lang.String ID_renamed = "MLLT";
    public final int bytesBetweenReference;
    public final int[] bytesDeviations;
    public final int millisecondsBetweenReference;
    public final int[] millisecondsDeviations;
    public final int mpegFramesBetweenReference;

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MlltFrame(int i_renamed, int i2, int i3, int[] iArr, int[] iArr2) {
        super(ID_renamed);
        this.mpegFramesBetweenReference = i_renamed;
        this.bytesBetweenReference = i2;
        this.millisecondsBetweenReference = i3;
        this.bytesDeviations = iArr;
        this.millisecondsDeviations = iArr2;
    }

    MlltFrame(android.os.Parcel parcel) {
        super(ID_renamed);
        this.mpegFramesBetweenReference = parcel.readInt();
        this.bytesBetweenReference = parcel.readInt();
        this.millisecondsBetweenReference = parcel.readInt();
        this.bytesDeviations = parcel.createIntArray();
        this.millisecondsDeviations = parcel.createIntArray();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.MlltFrame mlltFrame = (com.google.android.exoplayer2.metadata.id3.MlltFrame) obj;
        return this.mpegFramesBetweenReference == mlltFrame.mpegFramesBetweenReference && this.bytesBetweenReference == mlltFrame.bytesBetweenReference && this.millisecondsBetweenReference == mlltFrame.millisecondsBetweenReference && java.util.Arrays.equals(this.bytesDeviations, mlltFrame.bytesDeviations) && java.util.Arrays.equals(this.millisecondsDeviations, mlltFrame.millisecondsDeviations);
    }

    public int hashCode() {
        return ((((((((527 + this.mpegFramesBetweenReference) * 31) + this.bytesBetweenReference) * 31) + this.millisecondsBetweenReference) * 31) + java.util.Arrays.hashCode(this.bytesDeviations)) * 31) + java.util.Arrays.hashCode(this.millisecondsDeviations);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mpegFramesBetweenReference);
        parcel.writeInt(this.bytesBetweenReference);
        parcel.writeInt(this.millisecondsBetweenReference);
        parcel.writeIntArray(this.bytesDeviations);
        parcel.writeIntArray(this.millisecondsDeviations);
    }
}
