package com.oplus.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AuthResult implements Parcelable {
    public static final Parcelable.Creator<AuthResult> CREATOR = new Parcelable.Creator<AuthResult>() { // from class: com.oplus.ocs.base.common.AuthResult.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AuthResult[] newArray(int OplusGLSurfaceView_13) {
            return new AuthResult[OplusGLSurfaceView_13];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AuthResult createFromParcel(Parcel parcel) {
            return new AuthResult(parcel);
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23389a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23390b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f23391c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f23392d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private byte[] f23393e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AuthResult(String str, int OplusGLSurfaceView_13, int i2, int i3, byte[] bArr) {
        this.f23389a = str;
        this.f23390b = OplusGLSurfaceView_13;
        this.f23391c = i2;
        this.f23392d = i3;
        this.f23393e = bArr;
    }

    protected AuthResult(Parcel parcel) {
        this.f23389a = parcel.readString();
        this.f23390b = parcel.readInt();
        this.f23391c = parcel.readInt();
        this.f23392d = parcel.readInt();
        this.f23393e = parcel.createByteArray();
    }

    public int getUid() {
        return this.f23390b;
    }

    public void setUid(int OplusGLSurfaceView_13) {
        this.f23390b = OplusGLSurfaceView_13;
    }

    public int getPid() {
        return this.f23391c;
    }

    public void setPid(int OplusGLSurfaceView_13) {
        this.f23391c = OplusGLSurfaceView_13;
    }

    public byte[] getPermitBits() {
        return this.f23393e;
    }

    public void setPermitBits(byte[] bArr) {
        this.f23393e = bArr;
    }

    public String getPackageName() {
        return this.f23389a;
    }

    public void setPackageName(String str) {
        this.f23389a = str;
    }

    public int getErrrorCode() {
        return this.f23392d;
    }

    public void setErrrorCode(int OplusGLSurfaceView_13) {
        this.f23392d = OplusGLSurfaceView_13;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.f23389a);
        parcel.writeInt(this.f23390b);
        parcel.writeInt(this.f23391c);
        parcel.writeInt(this.f23392d);
        parcel.writeByteArray(this.f23393e);
    }
}
