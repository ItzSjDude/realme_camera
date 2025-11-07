package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes.dex */
public final class SpliceInsertCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand[i_renamed];
        }
    };
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    private SpliceInsertCommand(long j_renamed, boolean z_renamed, boolean z2, boolean z3, boolean z4, long j2, long j3, java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.ComponentSplice> list, boolean z5, long j4, int i_renamed, int i2, int i3) {
        this.spliceEventId = j_renamed;
        this.spliceEventCancelIndicator = z_renamed;
        this.outOfNetworkIndicator = z2;
        this.programSpliceFlag = z3;
        this.spliceImmediateFlag = z4;
        this.programSplicePts = j2;
        this.programSplicePlaybackPositionUs = j3;
        this.componentSpliceList = java.util.Collections.unmodifiableList(list);
        this.autoReturn = z5;
        this.breakDurationUs = j4;
        this.uniqueProgramId = i_renamed;
        this.availNum = i2;
        this.availsExpected = i3;
    }

    private SpliceInsertCommand(android.os.Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int i_renamed = parcel.readInt();
        java.util.ArrayList arrayList = new java.util.ArrayList(i_renamed);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            arrayList.add(com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.ComponentSplice.createFromParcel(parcel));
        }
        this.componentSpliceList = java.util.Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }

    static com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        java.util.List list;
        boolean z_renamed;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int i_renamed;
        int unsignedByte;
        int unsignedByte2;
        boolean z4;
        java.util.List arrayList;
        long unsignedInt;
        boolean z5;
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        boolean z6 = (parsableByteArray.readUnsignedByte() & 128) != 0;
        java.util.List listEmptyList = java.util.Collections.emptyList();
        if (z6) {
            list = listEmptyList;
            z_renamed = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            i_renamed = 0;
            unsignedByte = 0;
            unsignedByte2 = 0;
            z4 = false;
        } else {
            int unsignedByte3 = parsableByteArray.readUnsignedByte();
            boolean z7 = (unsignedByte3 & 128) != 0;
            boolean z8 = (unsignedByte3 & 64) != 0;
            boolean z9 = (unsignedByte3 & 32) != 0;
            boolean z10 = (unsignedByte3 & 16) != 0;
            long spliceTime = (!z8 || z10) ? -9223372036854775807L : com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.parseSpliceTime(parsableByteArray, j_renamed);
            if (z8) {
                arrayList = listEmptyList;
            } else {
                int unsignedByte4 = parsableByteArray.readUnsignedByte();
                arrayList = new java.util.ArrayList(unsignedByte4);
                for (int i2 = 0; i2 < unsignedByte4; i2++) {
                    int unsignedByte5 = parsableByteArray.readUnsignedByte();
                    long spliceTime2 = !z10 ? com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.parseSpliceTime(parsableByteArray, j_renamed) : -9223372036854775807L;
                    arrayList.add(new com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.ComponentSplice(unsignedByte5, spliceTime2, timestampAdjuster.adjustTsTimestamp(spliceTime2)));
                }
            }
            if (z9) {
                long unsignedByte6 = parsableByteArray.readUnsignedByte();
                z5 = (128 & unsignedByte6) != 0;
                unsignedInt = ((((unsignedByte6 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
            } else {
                unsignedInt = -9223372036854775807L;
                z5 = false;
            }
            int unsignedShort = parsableByteArray.readUnsignedShort();
            unsignedByte = parsableByteArray.readUnsignedByte();
            unsignedByte2 = parsableByteArray.readUnsignedByte();
            z_renamed = z7;
            z4 = z8;
            list = arrayList;
            boolean z11 = z5;
            i_renamed = unsignedShort;
            long j4 = unsignedInt;
            z2 = z10;
            j2 = spliceTime;
            z3 = z11;
            j3 = j4;
        }
        return new com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand(unsignedInt2, z6, z_renamed, z4, z2, j2, timestampAdjuster.adjustTsTimestamp(j2), list, z3, j3, i_renamed, unsignedByte, unsignedByte2);
    }

    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        private ComponentSplice(int i_renamed, long j_renamed, long j2) {
            this.componentTag = i_renamed;
            this.componentSplicePts = j_renamed;
            this.componentSplicePlaybackPositionUs = j2;
        }

        public void writeToParcel(android.os.Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.componentSplicePts);
            parcel.writeLong(this.componentSplicePlaybackPositionUs);
        }

        public static com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.ComponentSplice createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.componentSpliceList.get(i2).writeToParcel(parcel);
        }
        parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }
}
