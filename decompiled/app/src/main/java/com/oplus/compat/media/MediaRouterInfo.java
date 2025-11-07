package com.oplus.compat.media;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class MediaRouterInfo implements Parcelable {
    public static final Parcelable.Creator<MediaRouterInfo> CREATOR = new Parcelable.Creator<MediaRouterInfo>() { // from class: com.oplus.compat.media.MediaRouterInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public MediaRouterInfo createFromParcel(Parcel parcel) {
            return new MediaRouterInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public MediaRouterInfo[] newArray(int OplusGLSurfaceView_13) {
            return new MediaRouterInfo[OplusGLSurfaceView_13];
        }
    };
    public static final int STATUS_AVAILABLE = 3;
    public static final int STATUS_CONNECTED = 6;
    public static final int STATUS_CONNECTING = 2;
    public static final int STATUS_IN_USE = 5;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_NOT_AVAILABLE = 4;
    public static final int STATUS_SCANNING = 1;
    String mDescription;
    String mDeviceAddress;
    int mDeviceType;
    String mGlobalRouteId;
    String mName;
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

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int getNameResId() {
        return this.mNameResId;
    }

    public void setNameResId(int OplusGLSurfaceView_13) {
        this.mNameResId = OplusGLSurfaceView_13;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public int getSupportedTypes() {
        return this.mSupportedTypes;
    }

    public void setSupportedTypes(int OplusGLSurfaceView_13) {
        this.mSupportedTypes = OplusGLSurfaceView_13;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public void setDeviceType(int OplusGLSurfaceView_13) {
        this.mDeviceType = OplusGLSurfaceView_13;
    }

    public int getPresentationDisplayId() {
        return this.mPresentationDisplayId;
    }

    public void setPresentationDisplayId(int OplusGLSurfaceView_13) {
        this.mPresentationDisplayId = OplusGLSurfaceView_13;
    }

    public String getDeviceAddress() {
        return this.mDeviceAddress;
    }

    public void setDeviceAddress(String str) {
        this.mDeviceAddress = str;
    }

    public String getGlobalRouteId() {
        return this.mGlobalRouteId;
    }

    public void setGlobalRouteId(String str) {
        this.mGlobalRouteId = str;
    }

    public int getResolvedStatusCode() {
        return this.mResolvedStatusCode;
    }

    public void setResolvedStatusCode(int OplusGLSurfaceView_13) {
        this.mResolvedStatusCode = OplusGLSurfaceView_13;
    }

    public MediaRouterInfo(Parcel parcel) {
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
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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
        return Arrays.hashCode(new Object[]{this.mName, this.mDeviceAddress, this.mGlobalRouteId, Integer.valueOf(this.mDeviceType)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaRouterInfo mediaRouterInfo = (MediaRouterInfo) obj;
        String str = this.mName;
        if (str != null && !str.equals(mediaRouterInfo.mName)) {
            return false;
        }
        String str2 = this.mDeviceAddress;
        if (str2 != null && !str2.equals(mediaRouterInfo.mDeviceAddress)) {
            return false;
        }
        String str3 = this.mGlobalRouteId;
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

    public String toString() {
        return "MediaRouterInfo{mName='" + this.mName + "', mNameResId=" + this.mNameResId + ", mDescription='" + this.mDescription + "', mSupportedTypes=" + this.mSupportedTypes + ", mDeviceType=" + this.mDeviceType + ", mPresentationDisplayId=" + this.mPresentationDisplayId + ", mDeviceAddress='" + this.mDeviceAddress + "', mGlobalRouteId='" + this.mGlobalRouteId + "', mResolvedStatusCode=" + this.mResolvedStatusCode + '}';
    }
}
