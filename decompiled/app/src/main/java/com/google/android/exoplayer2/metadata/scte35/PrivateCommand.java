package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes.dex */
public final class PrivateCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.PrivateCommand> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.PrivateCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.PrivateCommand.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.PrivateCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.PrivateCommand(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.PrivateCommand[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.scte35.PrivateCommand[i_renamed];
        }
    };
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    private PrivateCommand(long j_renamed, byte[] bArr, long j2) {
        this.ptsAdjustment = j2;
        this.identifier = j_renamed;
        this.commandBytes = bArr;
    }

    private PrivateCommand(android.os.Parcel parcel) {
        this.ptsAdjustment = parcel.readLong();
        this.identifier = parcel.readLong();
        this.commandBytes = new byte[parcel.readInt()];
        parcel.readByteArray(this.commandBytes);
    }

    static com.google.android.exoplayer2.metadata.scte35.PrivateCommand parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, long j_renamed) {
        long unsignedInt = parsableByteArray.readUnsignedInt();
        byte[] bArr = new byte[i_renamed - 4];
        parsableByteArray.readBytes(bArr, 0, bArr.length);
        return new com.google.android.exoplayer2.metadata.scte35.PrivateCommand(unsignedInt, bArr, j_renamed);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.ptsAdjustment);
        parcel.writeLong(this.identifier);
        parcel.writeInt(this.commandBytes.length);
        parcel.writeByteArray(this.commandBytes);
    }
}
