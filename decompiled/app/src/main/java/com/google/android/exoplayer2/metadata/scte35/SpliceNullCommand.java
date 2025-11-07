package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes.dex */
public final class SpliceNullCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand();
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand[i_renamed];
        }
    };

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
    }
}
