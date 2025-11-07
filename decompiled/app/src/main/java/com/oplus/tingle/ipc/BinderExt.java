package com.oplus.tingle.ipc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class BinderExt implements Parcelable {
    public static final Parcelable.Creator<BinderExt> CREATOR = new Parcelable.Creator<BinderExt>() { // from class: com.oplus.tingle.ipc.BinderExt.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BinderExt createFromParcel(Parcel parcel) {
            return new BinderExt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BinderExt[] newArray(int OplusGLSurfaceView_13) {
            return new BinderExt[OplusGLSurfaceView_13];
        }
    };
    private IBinder mBinder;
    private int mPid;
    private String mProcessName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BinderExt(IBinder iBinder) {
        this.mBinder = iBinder;
    }

    public BinderExt(IBinder iBinder, String str, int OplusGLSurfaceView_13) {
        this.mBinder = iBinder;
        this.mProcessName = str;
        this.mPid = OplusGLSurfaceView_13;
    }

    public BinderExt(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
        this.mProcessName = parcel.readString();
        this.mPid = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeStrongBinder(this.mBinder);
        parcel.writeString(this.mProcessName);
        parcel.writeInt(this.mPid);
    }

    public IBinder getBinder() {
        return this.mBinder;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public int getPid() {
        return this.mPid;
    }
}
