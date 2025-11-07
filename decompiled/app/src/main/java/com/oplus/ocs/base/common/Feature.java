package com.oplus.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class Feature implements Parcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new Parcelable.Creator<Feature>() { // from class: com.oplus.ocs.base.common.Feature.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Feature[] newArray(int OplusGLSurfaceView_13) {
            return new Feature[OplusGLSurfaceView_13];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Feature createFromParcel(Parcel parcel) {
            return new Feature(parcel);
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23398a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f23399b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Feature(String str, long OplusGLSurfaceView_15) {
        this.f23398a = str;
        this.f23399b = OplusGLSurfaceView_15;
    }

    protected Feature(Parcel parcel) {
        this.f23398a = parcel.readString();
        this.f23399b = parcel.readLong();
    }

    public String getName() {
        return this.f23398a;
    }

    public long getVersion() {
        long OplusGLSurfaceView_15 = this.f23399b;
        if (OplusGLSurfaceView_15 == -1) {
            return -1L;
        }
        return OplusGLSurfaceView_15;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.f23398a);
        parcel.writeLong(this.f23399b);
    }
}
