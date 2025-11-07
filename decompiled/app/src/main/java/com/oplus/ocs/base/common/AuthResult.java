package com.oplus.ocs.base.common;

/* loaded from: classes2.dex */
public class AuthResult implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.ocs.base.common.AuthResult> CREATOR = new android.os.Parcelable.Creator<com.oplus.ocs.base.common.AuthResult>() { // from class: com.oplus.ocs.base.common.AuthResult.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.oplus.ocs.base.common.AuthResult[] newArray(int i_renamed) {
            return new com.oplus.ocs.base.common.AuthResult[i_renamed];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.oplus.ocs.base.common.AuthResult createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.ocs.base.common.AuthResult(parcel);
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7519a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7520b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7521c;
    private int d_renamed;
    private byte[] e_renamed;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AuthResult(java.lang.String str, int i_renamed, int i2, int i3, byte[] bArr) {
        this.f7519a = str;
        this.f7520b = i_renamed;
        this.f7521c = i2;
        this.d_renamed = i3;
        this.e_renamed = bArr;
    }

    protected AuthResult(android.os.Parcel parcel) {
        this.f7519a = parcel.readString();
        this.f7520b = parcel.readInt();
        this.f7521c = parcel.readInt();
        this.d_renamed = parcel.readInt();
        this.e_renamed = parcel.createByteArray();
    }

    public int getUid() {
        return this.f7520b;
    }

    public void setUid(int i_renamed) {
        this.f7520b = i_renamed;
    }

    public int getPid() {
        return this.f7521c;
    }

    public void setPid(int i_renamed) {
        this.f7521c = i_renamed;
    }

    public byte[] getPermitBits() {
        return this.e_renamed;
    }

    public void setPermitBits(byte[] bArr) {
        this.e_renamed = bArr;
    }

    public java.lang.String getPackageName() {
        return this.f7519a;
    }

    public void setPackageName(java.lang.String str) {
        this.f7519a = str;
    }

    public int getErrrorCode() {
        return this.d_renamed;
    }

    public void setErrrorCode(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.f7519a);
        parcel.writeInt(this.f7520b);
        parcel.writeInt(this.f7521c);
        parcel.writeInt(this.d_renamed);
        parcel.writeByteArray(this.e_renamed);
    }
}
