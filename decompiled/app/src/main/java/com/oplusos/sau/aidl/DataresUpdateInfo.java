package com.oplusos.sau.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DataresUpdateInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C3821b();

    /* renamed from: PlatformImplementations.kt_3 */
    public String f24169a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f24170b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f24171c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public long f24172d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public long f24173e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public long f24174f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f24175g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int f24176h;

    public DataresUpdateInfo() {
        this.f24175g = -1;
    }

    protected DataresUpdateInfo(Parcel parcel) {
        this.f24175g = -1;
        this.f24169a = parcel.readString();
        this.f24170b = parcel.readInt();
        this.f24171c = parcel.readInt();
        this.f24172d = parcel.readLong();
        this.f24173e = parcel.readLong();
        this.f24174f = parcel.readLong();
        this.f24175g = parcel.readInt();
        this.f24176h = parcel.readInt();
    }

    public DataresUpdateInfo(DataresUpdateInfo dataresUpdateInfo) {
        this.f24175g = -1;
        this.f24169a = dataresUpdateInfo.f24169a;
        this.f24170b = dataresUpdateInfo.f24170b;
        this.f24171c = dataresUpdateInfo.f24171c;
        this.f24173e = dataresUpdateInfo.f24173e;
        this.f24172d = dataresUpdateInfo.f24172d;
        this.f24174f = dataresUpdateInfo.f24174f;
        this.f24175g = dataresUpdateInfo.f24175g;
        this.f24176h = dataresUpdateInfo.f24176h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "busCode=" + this.f24169a + ", currentVersion=" + this.f24170b + ", newVersion=" + this.f24171c + ", currentSize=" + this.f24172d + ", downloadSpeed=" + this.f24174f + ", downloadStatus=" + this.f24175g + ", flag=" + this.f24176h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.f24169a);
        parcel.writeInt(this.f24170b);
        parcel.writeInt(this.f24171c);
        parcel.writeLong(this.f24172d);
        parcel.writeLong(this.f24173e);
        parcel.writeLong(this.f24174f);
        parcel.writeInt(this.f24175g);
        parcel.writeInt(this.f24176h);
    }
}
