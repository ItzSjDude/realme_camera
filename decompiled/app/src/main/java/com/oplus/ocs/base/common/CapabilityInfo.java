package com.oplus.ocs.base.common;

/* loaded from: classes2.dex */
public class CapabilityInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.ocs.base.common.CapabilityInfo> CREATOR = new android.os.Parcelable.Creator<com.oplus.ocs.base.common.CapabilityInfo>() { // from class: com.oplus.ocs.base.common.CapabilityInfo.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.oplus.ocs.base.common.CapabilityInfo[] newArray(int i_renamed) {
            return new com.oplus.ocs.base.common.CapabilityInfo[i_renamed];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.oplus.ocs.base.common.CapabilityInfo createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.ocs.base.common.CapabilityInfo(parcel);
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.ocs.base.common.Feature> f7522a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7523b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.common.AuthResult f7524c;
    private android.os.IBinder d_renamed;
    public java.lang.String mClassName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CapabilityInfo(java.util.List<com.oplus.ocs.base.common.Feature> list, int i_renamed, com.oplus.ocs.base.common.AuthResult authResult) {
        this(list, i_renamed, authResult, null);
    }

    public CapabilityInfo(java.util.List<com.oplus.ocs.base.common.Feature> list, int i_renamed, com.oplus.ocs.base.common.AuthResult authResult, android.os.IBinder iBinder) {
        this.f7522a = list;
        this.f7523b = i_renamed;
        this.f7524c = authResult;
        this.d_renamed = iBinder;
    }

    public java.util.List<com.oplus.ocs.base.common.Feature> getFeatures() {
        return this.f7522a;
    }

    public int getVersion() {
        return this.f7523b;
    }

    public com.oplus.ocs.base.common.AuthResult getAuthResult() {
        return this.f7524c;
    }

    public android.os.IBinder getBinder() {
        return this.d_renamed;
    }

    public void setBinder(android.os.IBinder iBinder) {
        this.d_renamed = iBinder;
    }

    public java.lang.String getClassName() {
        return this.mClassName;
    }

    public void setClassName(java.lang.String str) {
        this.mClassName = str;
    }

    protected CapabilityInfo(android.os.Parcel parcel) {
        this.f7522a = parcel.readArrayList(com.oplus.ocs.base.common.Feature.class.getClassLoader());
        this.f7523b = parcel.readInt();
        this.f7524c = (com.oplus.ocs.base.common.AuthResult) com.oplus.ocs.base.b_renamed.c_renamed.a_renamed(parcel, com.oplus.ocs.base.common.AuthResult.class.getClassLoader(), android.text.TextUtils.isEmpty(this.mClassName) ? com.oplus.ocs.base.common.AuthResult.class.getName() : this.mClassName);
        this.d_renamed = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeList(this.f7522a);
        parcel.writeInt(this.f7523b);
        com.oplus.ocs.base.b_renamed.c_renamed.a_renamed(parcel, this.f7524c, android.text.TextUtils.isEmpty(this.mClassName) ? com.oplus.ocs.base.common.AuthResult.class.getName() : this.mClassName);
        parcel.writeStrongBinder(this.d_renamed);
    }
}
