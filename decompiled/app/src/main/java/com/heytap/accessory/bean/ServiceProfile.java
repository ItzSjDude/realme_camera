package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class ServiceProfile implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.ServiceProfile> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.ServiceProfile>() { // from class: com.heytap.accessory.bean.ServiceProfile.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.ServiceProfile createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.ServiceProfile(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.ServiceProfile[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.ServiceProfile[i_renamed];
        }
    };
    public static final int FEATURE_DISABLED = 0;
    public static final int FEATURE_ENABLED = 1;
    public static final int ROLE_CONSUMER = 1;
    public static final int ROLE_PROVIDER = 0;
    public static final int SERVICE_LIMIT_ANY = 0;
    public static final int SERVICE_LIMIT_ONE_ACCESSORY = 1;
    public static final int SERVICE_LIMIT_ONE_PEERAGENT = 2;
    private int mAwakenable;
    private java.lang.String mId;
    private int mIsMexSupported;
    private int mIsSocketSupported;
    private java.lang.String mName;
    private int mRole;
    private java.util.List<com.heytap.accessory.bean.ServiceChannel> mServiceChannelList;
    private java.lang.String mServiceImpl;
    private int mServiceLimit;
    private int mServiceTimeout;
    private int mTransportType;
    private java.lang.String mVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ServiceProfile() {
        this.mServiceChannelList = new java.util.ArrayList();
    }

    public ServiceProfile(java.lang.String str, java.lang.String str2, int i_renamed, java.lang.String str3, java.lang.String str4, int i2, int i3, int i4, java.util.List<com.heytap.accessory.bean.ServiceChannel> list, int i5, int i6, int i7) {
        this.mServiceChannelList = new java.util.ArrayList();
        this.mId = str;
        this.mName = str2;
        this.mRole = i_renamed;
        this.mServiceImpl = str3;
        this.mVersion = str4;
        this.mServiceLimit = i2;
        this.mServiceTimeout = i3;
        this.mTransportType = i4;
        this.mServiceChannelList = list;
        this.mIsMexSupported = i5;
        this.mIsSocketSupported = i6;
        this.mAwakenable = i7;
    }

    protected ServiceProfile(android.os.Parcel parcel) {
        this.mServiceChannelList = new java.util.ArrayList();
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mServiceImpl = parcel.readString();
        this.mVersion = parcel.readString();
        this.mRole = parcel.readInt();
        this.mServiceLimit = parcel.readInt();
        this.mServiceTimeout = parcel.readInt();
        this.mTransportType = parcel.readInt();
        this.mIsMexSupported = parcel.readInt();
        this.mIsSocketSupported = parcel.readInt();
    }

    public java.lang.String getId() {
        return this.mId;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.mRole;
    }

    public java.lang.String getServiceImpl() {
        return this.mServiceImpl;
    }

    public java.lang.String getVersion() {
        return this.mVersion;
    }

    public int getServiceLimit() {
        return this.mServiceLimit;
    }

    public int getServiceTimeout() {
        return this.mServiceTimeout;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public java.util.List<com.heytap.accessory.bean.ServiceChannel> getServiceChannelList() {
        return this.mServiceChannelList;
    }

    public int isMexSupported() {
        return this.mIsMexSupported;
    }

    public int isSocketSupported() {
        return this.mIsSocketSupported;
    }

    public int isAwakenable() {
        return this.mAwakenable;
    }

    public void setId(java.lang.String str) {
        this.mId = str;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public void setServiceImpl(java.lang.String str) {
        this.mServiceImpl = str;
    }

    public void setVersion(java.lang.String str) {
        this.mVersion = str;
    }

    public void setRole(int i_renamed) {
        this.mRole = i_renamed;
    }

    public void setServiceLimit(int i_renamed) {
        this.mServiceLimit = i_renamed;
    }

    public void setServiceTimeout(int i_renamed) {
        this.mServiceTimeout = i_renamed;
    }

    public void setTransportType(int i_renamed) {
        this.mTransportType = i_renamed;
    }

    public void setIsMexSupported(int i_renamed) {
        this.mIsMexSupported = i_renamed;
    }

    public void setIsSocketSupported(int i_renamed) {
        this.mIsSocketSupported = i_renamed;
    }

    public void setAwakenable(int i_renamed) {
        this.mAwakenable = i_renamed;
    }

    public void setServiceChannelList(java.util.List<com.heytap.accessory.bean.ServiceChannel> list) {
        this.mServiceChannelList = list;
    }

    public java.lang.String toString() {
        return "ServiceProfile{mId='" + this.mId + "', mName='" + this.mName + "', mServiceImpl='" + this.mServiceImpl + "', mVersion='" + this.mVersion + "', mRole='" + this.mRole + "', mServiceLimit=" + this.mServiceLimit + ", mServiceTimeout=" + this.mServiceTimeout + ", mTransportType=" + this.mTransportType + ", isMexSupported=" + this.mIsMexSupported + ", isSocketSupported=" + this.mIsSocketSupported + ", mServiceChannelList=" + this.mServiceChannelList + ", Awakenable=" + this.mAwakenable + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mServiceImpl);
        parcel.writeString(this.mVersion);
        parcel.writeInt(this.mRole);
        parcel.writeInt(this.mServiceLimit);
        parcel.writeInt(this.mServiceTimeout);
        parcel.writeInt(this.mTransportType);
        parcel.writeInt(this.mIsMexSupported);
        parcel.writeInt(this.mIsSocketSupported);
    }
}
