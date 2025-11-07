package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class DiscoveryConfigInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.DiscoveryConfigInfo> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.DiscoveryConfigInfo>() { // from class: com.heytap.accessory.bean.DiscoveryConfigInfo.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.DiscoveryConfigInfo createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.DiscoveryConfigInfo(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.DiscoveryConfigInfo[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.DiscoveryConfigInfo[i_renamed];
        }
    };
    public static final java.lang.String TAG = "DiscoveryConfigInfo";
    private java.lang.String mAction;
    private final android.os.Bundle mBundle;
    private java.lang.String mComponent;
    private java.lang.String mTarget;
    private int mVersionCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DiscoveryConfigInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed) {
        this.mTarget = str;
        this.mAction = str2;
        this.mComponent = str3;
        this.mVersionCode = i_renamed;
        this.mBundle = new android.os.Bundle();
    }

    public static com.heytap.accessory.bean.DiscoveryConfigInfo create(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed) {
        return new com.heytap.accessory.bean.DiscoveryConfigInfo(str, str2, str3, i_renamed);
    }

    public com.heytap.accessory.bean.DiscoveryConfigInfo putBundle(android.os.Bundle bundle) {
        if (bundle != null) {
            this.mBundle.putAll(bundle);
        }
        return this;
    }

    public android.os.Bundle getBundle() {
        return this.mBundle;
    }

    public java.lang.String getTarget() {
        return this.mTarget;
    }

    public java.lang.String getAction() {
        return this.mAction;
    }

    public java.lang.String getComponent() {
        return this.mComponent;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    protected DiscoveryConfigInfo(android.os.Parcel parcel) {
        this.mTarget = parcel.readString();
        this.mAction = parcel.readString();
        this.mComponent = parcel.readString();
        this.mVersionCode = parcel.readInt();
        this.mBundle = parcel.readBundle(android.os.Bundle.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mTarget);
        parcel.writeString(this.mAction);
        parcel.writeString(this.mComponent);
        parcel.writeInt(this.mVersionCode);
        parcel.writeBundle(this.mBundle);
    }

    public java.lang.String toString() {
        return "ProductAppInfo{target='" + this.mTarget + "', action='" + this.mAction + "', component='" + this.mComponent + "', version=" + this.mVersionCode + '}';
    }
}
