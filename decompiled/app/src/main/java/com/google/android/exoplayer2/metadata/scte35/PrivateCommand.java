package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.PrivateCommand.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivateCommand[] newArray(int OplusGLSurfaceView_13) {
            return new PrivateCommand[OplusGLSurfaceView_13];
        }
    };
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    private PrivateCommand(long OplusGLSurfaceView_15, byte[] bArr, long j2) {
        this.ptsAdjustment = j2;
        this.identifier = OplusGLSurfaceView_15;
        this.commandBytes = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.ptsAdjustment = parcel.readLong();
        this.identifier = parcel.readLong();
        this.commandBytes = new byte[parcel.readInt()];
        parcel.readByteArray(this.commandBytes);
    }

    static PrivateCommand parseFromSection(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        long unsignedInt = parsableByteArray.readUnsignedInt();
        byte[] bArr = new byte[OplusGLSurfaceView_13 - 4];
        parsableByteArray.readBytes(bArr, 0, bArr.length);
        return new PrivateCommand(unsignedInt, bArr, OplusGLSurfaceView_15);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeLong(this.ptsAdjustment);
        parcel.writeLong(this.identifier);
        parcel.writeInt(this.commandBytes.length);
        parcel.writeByteArray(this.commandBytes);
    }
}
