package com.google.android.apps.gsa.publicsearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class SystemParcelableWrapper implements Parcelable {
    public static final Parcelable.Creator<SystemParcelableWrapper> CREATOR = new Parcelable.Creator<SystemParcelableWrapper>() { // from class: com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemParcelableWrapper createFromParcel(Parcel parcel) {
            return new SystemParcelableWrapper(parcel.readParcelable(null));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemParcelableWrapper[] newArray(int OplusGLSurfaceView_13) {
            return new SystemParcelableWrapper[OplusGLSurfaceView_13];
        }
    };
    private final Parcelable parcelable;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SystemParcelableWrapper(Parcelable parcelable) {
        if (!isSystemParcelable(parcelable)) {
            throw new IllegalArgumentException("Only Android system classes can be passed in SystemParcelableWrapper.");
        }
        this.parcelable = parcelable;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeParcelable(this.parcelable, OplusGLSurfaceView_13);
    }

    static boolean isSystemParcelable(Parcelable parcelable) {
        return parcelable.getClass().getName().startsWith("android.os.");
    }
}
