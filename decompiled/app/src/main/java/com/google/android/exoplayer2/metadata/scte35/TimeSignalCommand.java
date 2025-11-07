package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes.dex */
public final class TimeSignalCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand[i_renamed];
        }
    };
    public final long playbackPositionUs;
    public final long ptsTime;

    private TimeSignalCommand(long j_renamed, long j2) {
        this.ptsTime = j_renamed;
        this.playbackPositionUs = j2;
    }

    static com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        long spliceTime = parseSpliceTime(parsableByteArray, j_renamed);
        return new com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand(spliceTime, timestampAdjuster.adjustTsTimestamp(spliceTime));
    }

    static long parseSpliceTime(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) {
        long unsignedByte = parsableByteArray.readUnsignedByte();
        if ((128 & unsignedByte) != 0) {
            return 8589934591L & ((((unsignedByte & 1) << 32) | parsableByteArray.readUnsignedInt()) + j_renamed);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.ptsTime);
        parcel.writeLong(this.playbackPositionUs);
    }
}
