package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new Parcelable.Creator<TrackGroup>() { // from class: com.google.android.exoplayer2.source.TrackGroup.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackGroup[] newArray(int OplusGLSurfaceView_13) {
            return new TrackGroup[OplusGLSurfaceView_13];
        }
    };
    private final Format[] formats;
    private int hashCode;
    public final int length;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TrackGroup(Format... formatArr) {
        Assertions.checkState(formatArr.length > 0);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    TrackGroup(Parcel parcel) {
        this.length = parcel.readInt();
        this.formats = new Format[this.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.length; OplusGLSurfaceView_13++) {
            this.formats[OplusGLSurfaceView_13] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public Format getFormat(int OplusGLSurfaceView_13) {
        return this.formats[OplusGLSurfaceView_13];
    }

    public int indexOf(Format format) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (OplusGLSurfaceView_13 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[OplusGLSurfaceView_13]) {
                return OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.length == trackGroup.length && Arrays.equals(this.formats, trackGroup.formats);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.length);
        for (int i2 = 0; i2 < this.length; i2++) {
            parcel.writeParcelable(this.formats[i2], 0);
        }
    }
}
