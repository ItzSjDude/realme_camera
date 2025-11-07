package com.oplusos.sau.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AppUpdateInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C3820a();

    /* renamed from: PlatformImplementations.kt_3 */
    public int f24156a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f24157b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f24158c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f24159d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f24160e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int f24161f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f24162g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public long f24163h;

    /* renamed from: OplusGLSurfaceView_13 */
    public long f24164i;

    /* renamed from: OplusGLSurfaceView_15 */
    public long f24165j;

    /* renamed from: OplusGLSurfaceView_5 */
    public String f24166k;

    /* renamed from: OplusGLSurfaceView_14 */
    public String f24167l;

    /* renamed from: OplusGLSurfaceView_6 */
    public String f24168m;

    public AppUpdateInfo() {
        this.f24160e = -1;
    }

    protected AppUpdateInfo(Parcel parcel) {
        this.f24160e = -1;
        this.f24166k = parcel.readString();
        this.f24156a = parcel.readInt();
        this.f24167l = parcel.readString();
        this.f24168m = parcel.readString();
        this.f24163h = parcel.readLong();
        this.f24164i = parcel.readLong();
        this.f24165j = parcel.readLong();
        this.f24157b = parcel.readInt();
        this.f24158c = parcel.readInt();
        this.f24159d = parcel.readInt();
        this.f24160e = parcel.readInt();
        this.f24161f = parcel.readInt();
        this.f24162g = parcel.readInt();
    }

    public AppUpdateInfo(AppUpdateInfo appUpdateInfo) {
        this.f24160e = -1;
        this.f24166k = appUpdateInfo.f24166k;
        this.f24156a = appUpdateInfo.f24156a;
        this.f24167l = appUpdateInfo.f24167l;
        this.f24168m = appUpdateInfo.f24168m;
        this.f24163h = appUpdateInfo.f24163h;
        this.f24164i = appUpdateInfo.f24164i;
        this.f24165j = appUpdateInfo.f24165j;
        this.f24157b = appUpdateInfo.f24157b;
        this.f24158c = appUpdateInfo.f24158c;
        this.f24159d = appUpdateInfo.f24159d;
        this.f24160e = appUpdateInfo.f24160e;
        this.f24161f = appUpdateInfo.f24161f;
        this.f24162g = appUpdateInfo.f24162g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25518a() {
        return (this.f24161f & 8) != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "pkg=" + this.f24166k + ",newVersion=" + this.f24156a + ",verName=" + this.f24167l + ",currentSize=" + this.f24163h + ",totalSize=" + this.f24164i + ",downloadSpeed=" + this.f24165j + ",downloadState=" + this.f24160e + ",stateFlag=" + this.f24161f + ",isAutoDownload=" + this.f24157b + ",isAutoInstall=" + this.f24158c + ",canUseOld=" + this.f24159d + ",description=" + this.f24168m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.f24166k);
        parcel.writeInt(this.f24156a);
        parcel.writeString(this.f24167l);
        parcel.writeString(this.f24168m);
        parcel.writeLong(this.f24163h);
        parcel.writeLong(this.f24164i);
        parcel.writeLong(this.f24165j);
        parcel.writeInt(this.f24157b);
        parcel.writeInt(this.f24158c);
        parcel.writeInt(this.f24159d);
        parcel.writeInt(this.f24160e);
        parcel.writeInt(this.f24161f);
        parcel.writeInt(this.f24162g);
    }
}
