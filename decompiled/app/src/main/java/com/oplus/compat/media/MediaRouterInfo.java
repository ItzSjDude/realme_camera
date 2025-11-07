package com.oplus.compat.media;

/* loaded from: classes2.dex */
public class MediaRouterInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.compat.media.MediaRouterInfo> CREATOR = new android.os.Parcelable.Creator<com.oplus.compat.media.MediaRouterInfo>() { // from class: com.oplus.compat.media.MediaRouterInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.compat.media.MediaRouterInfo createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.compat.media.MediaRouterInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.compat.media.MediaRouterInfo[] newArray(int i_renamed) {
            return new com.oplus.compat.media.MediaRouterInfo[i_renamed];
        }
    };
    public static final int STATUS_AVAILABLE = 3;
    public static final int STATUS_CONNECTED = 6;
    public static final int STATUS_CONNECTING = 2;
    public static final int STATUS_IN_USE = 5;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_NOT_AVAILABLE = 4;
    public static final int STATUS_SCANNING = 1;
    java.lang.String mDescription;
    java.lang.String mDeviceAddress;
    int mDeviceType;
    java.lang.String mGlobalRouteId;
    java.lang.String mName;
    int mNameResId;
    int mPresentationDisplayId;
    int mResolvedStatusCode;
    int mSupportedTypes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediaRouterInfo() {
        this.mPresentationDisplayId = -1;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public int getNameResId() {
        return this.mNameResId;
    }

    public void setNameResId(int i_renamed) {
        this.mNameResId = i_renamed;
    }

    public java.lang.String getDescription() {
        return this.mDescription;
    }

    public void setDescription(java.lang.String str) {
        this.mDescription = str;
    }

    public int getSupportedTypes() {
        return this.mSupportedTypes;
    }

    public void setSupportedTypes(int i_renamed) {
        this.mSupportedTypes = i_renamed;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public void setDeviceType(int i_renamed) {
        this.mDeviceType = i_renamed;
    }

    public int getPresentationDisplayId() {
        return this.mPresentationDisplayId;
    }

    public void setPresentationDisplayId(int i_renamed) {
        this.mPresentationDisplayId = i_renamed;
    }

    public java.lang.String getDeviceAddress() {
        return this.mDeviceAddress;
    }

    public void setDeviceAddress(java.lang.String str) {
        this.mDeviceAddress = str;
    }

    public java.lang.String getGlobalRouteId() {
        return this.mGlobalRouteId;
    }

    public void setGlobalRouteId(java.lang.String str) {
        this.mGlobalRouteId = str;
    }

    public int getResolvedStatusCode() {
        return this.mResolvedStatusCode;
    }

    public void setResolvedStatusCode(int i_renamed) {
        this.mResolvedStatusCode = i_renamed;
    }

    public MediaRouterInfo(android.os.Parcel parcel) {
        this.mPresentationDisplayId = -1;
        this.mName = parcel.readString();
        this.mNameResId = parcel.readInt();
        this.mDescription = parcel.readString();
        this.mSupportedTypes = parcel.readInt();
        this.mDeviceType = parcel.readInt();
        this.mPresentationDisplayId = parcel.readInt();
        this.mDeviceAddress = parcel.readString();
        this.mGlobalRouteId = parcel.readString();
        this.mResolvedStatusCode = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mName);
        parcel.writeInt(this.mNameResId);
        parcel.writeString(this.mDescription);
        parcel.writeInt(this.mSupportedTypes);
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mPresentationDisplayId);
        parcel.writeString(this.mDeviceAddress);
        parcel.writeString(this.mGlobalRouteId);
        parcel.writeInt(this.mResolvedStatusCode);
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{this.mName, this.mDeviceAddress, this.mGlobalRouteId, java.lang.Integer.valueOf(this.mDeviceType)});
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.oplus.compat.media.MediaRouterInfo mediaRouterInfo = (com.oplus.compat.media.MediaRouterInfo) obj;
        java.lang.String str = this.mName;
        if (str != null && !str.equals(mediaRouterInfo.mName)) {
            return false;
        }
        java.lang.String str2 = this.mDeviceAddress;
        if (str2 != null && !str2.equals(mediaRouterInfo.mDeviceAddress)) {
            return false;
        }
        java.lang.String str3 = this.mGlobalRouteId;
        return str3 == null || str3.equals(mediaRouterInfo.mGlobalRouteId);
    }

    public void clear() {
        this.mName = null;
        this.mNameResId = 0;
        this.mDescription = null;
        this.mSupportedTypes = -1;
        this.mDeviceType = -1;
        this.mPresentationDisplayId = -1;
        this.mDeviceAddress = null;
        this.mGlobalRouteId = null;
        this.mResolvedStatusCode = 0;
    }

    public java.lang.String toString() {
        return "MediaRouterInfo{mName='" + this.mName + "', mNameResId=" + this.mNameResId + ", mDescription='" + this.mDescription + "', mSupportedTypes=" + this.mSupportedTypes + ", mDeviceType=" + this.mDeviceType + ", mPresentationDisplayId=" + this.mPresentationDisplayId + ", mDeviceAddress='" + this.mDeviceAddress + "', mGlobalRouteId='" + this.mGlobalRouteId + "', mResolvedStatusCode=" + this.mResolvedStatusCode + '}';
    }
}
