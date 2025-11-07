package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes.dex */
public final class SpliceScheduleCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand[i_renamed];
        }
    };
    public final java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event> events;

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        private Event(long j_renamed, boolean z_renamed, boolean z2, boolean z3, java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice> list, long j2, boolean z4, long j3, int i_renamed, int i2, int i3) {
            this.spliceEventId = j_renamed;
            this.spliceEventCancelIndicator = z_renamed;
            this.outOfNetworkIndicator = z2;
            this.programSpliceFlag = z3;
            this.componentSpliceList = java.util.Collections.unmodifiableList(list);
            this.utcSpliceTime = j2;
            this.autoReturn = z4;
            this.breakDurationUs = j3;
            this.uniqueProgramId = i_renamed;
            this.availNum = i2;
            this.availsExpected = i3;
        }

        private Event(android.os.Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int i_renamed = parcel.readInt();
            java.util.ArrayList arrayList = new java.util.ArrayList(i_renamed);
            for (int i2 = 0; i2 < i_renamed; i2++) {
                arrayList.add(com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice.createFromParcel(parcel));
            }
            this.componentSpliceList = java.util.Collections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            java.util.ArrayList arrayList;
            boolean z_renamed;
            long j_renamed;
            boolean z2;
            long j2;
            int i_renamed;
            int i2;
            int unsignedByte;
            boolean z3;
            boolean z4;
            long unsignedInt;
            long unsignedInt2 = parsableByteArray.readUnsignedInt();
            boolean z5 = (parsableByteArray.readUnsignedByte() & 128) != 0;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (z5) {
                arrayList = arrayList2;
                z_renamed = false;
                j_renamed = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i_renamed = 0;
                i2 = 0;
                unsignedByte = 0;
                z3 = false;
            } else {
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                boolean z6 = (unsignedByte2 & 128) != 0;
                boolean z7 = (unsignedByte2 & 64) != 0;
                boolean z8 = (unsignedByte2 & 32) != 0;
                long unsignedInt3 = z7 ? parsableByteArray.readUnsignedInt() : -9223372036854775807L;
                if (!z7) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(unsignedByte3);
                    for (int i3 = 0; i3 < unsignedByte3; i3++) {
                        arrayList3.add(new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long unsignedByte4 = parsableByteArray.readUnsignedByte();
                    z4 = (128 & unsignedByte4) != 0;
                    unsignedInt = ((((unsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                } else {
                    z4 = false;
                    unsignedInt = -9223372036854775807L;
                }
                int unsignedShort = parsableByteArray.readUnsignedShort();
                int unsignedByte5 = parsableByteArray.readUnsignedByte();
                unsignedByte = parsableByteArray.readUnsignedByte();
                z3 = z7;
                j_renamed = unsignedInt3;
                j2 = unsignedInt;
                arrayList = arrayList2;
                i_renamed = unsignedShort;
                i2 = unsignedByte5;
                z_renamed = z6;
                z2 = z4;
            }
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event(unsignedInt2, z5, z_renamed, z3, arrayList, j_renamed, z2, j2, i_renamed, i2, unsignedByte);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(android.os.Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.componentSpliceList.get(i_renamed).writeToParcel(parcel);
            }
            parcel.writeLong(this.utcSpliceTime);
            parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event(parcel);
        }
    }

    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        private ComponentSplice(int i_renamed, long j_renamed) {
            this.componentTag = i_renamed;
            this.utcSpliceTime = j_renamed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(android.os.Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.utcSpliceTime);
        }
    }

    private SpliceScheduleCommand(java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event> list) {
        this.events = java.util.Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(android.os.Parcel parcel) {
        int i_renamed = parcel.readInt();
        java.util.ArrayList arrayList = new java.util.ArrayList(i_renamed);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            arrayList.add(com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event.createFromParcel(parcel));
        }
        this.events = java.util.Collections.unmodifiableList(arrayList);
    }

    static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        java.util.ArrayList arrayList = new java.util.ArrayList(unsignedByte);
        for (int i_renamed = 0; i_renamed < unsignedByte; i_renamed++) {
            arrayList.add(com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event.parseFromSection(parsableByteArray));
        }
        return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.events.get(i2).writeToParcel(parcel);
        }
    }
}
