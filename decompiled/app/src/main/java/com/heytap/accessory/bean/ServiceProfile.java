package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ServiceProfile implements Parcelable {
    public static final Parcelable.Creator<ServiceProfile> CREATOR = new Parcelable.Creator<ServiceProfile>() { // from class: com.heytap.accessory.bean.ServiceProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceProfile createFromParcel(Parcel parcel) {
            return new ServiceProfile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceProfile[] newArray(int OplusGLSurfaceView_13) {
            return new ServiceProfile[OplusGLSurfaceView_13];
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
    private String mId;
    private int mIsMexSupported;
    private int mIsSocketSupported;
    private String mName;
    private int mRole;
    private List<ServiceChannel> mServiceChannelList;
    private String mServiceImpl;
    private int mServiceLimit;
    private int mServiceTimeout;
    private int mTransportType;
    private String mVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ServiceProfile() {
        this.mServiceChannelList = new ArrayList();
    }

    public ServiceProfile(String str, String str2, int OplusGLSurfaceView_13, String str3, String str4, int i2, int i3, int i4, List<ServiceChannel> list, int i5, int i6, int i7) {
        this.mServiceChannelList = new ArrayList();
        this.mId = str;
        this.mName = str2;
        this.mRole = OplusGLSurfaceView_13;
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

    protected ServiceProfile(Parcel parcel) {
        this.mServiceChannelList = new ArrayList();
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

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.mRole;
    }

    public String getServiceImpl() {
        return this.mServiceImpl;
    }

    public String getVersion() {
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

    public List<ServiceChannel> getServiceChannelList() {
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

    public void setId(String str) {
        this.mId = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setServiceImpl(String str) {
        this.mServiceImpl = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public void setRole(int OplusGLSurfaceView_13) {
        this.mRole = OplusGLSurfaceView_13;
    }

    public void setServiceLimit(int OplusGLSurfaceView_13) {
        this.mServiceLimit = OplusGLSurfaceView_13;
    }

    public void setServiceTimeout(int OplusGLSurfaceView_13) {
        this.mServiceTimeout = OplusGLSurfaceView_13;
    }

    public void setTransportType(int OplusGLSurfaceView_13) {
        this.mTransportType = OplusGLSurfaceView_13;
    }

    public void setIsMexSupported(int OplusGLSurfaceView_13) {
        this.mIsMexSupported = OplusGLSurfaceView_13;
    }

    public void setIsSocketSupported(int OplusGLSurfaceView_13) {
        this.mIsSocketSupported = OplusGLSurfaceView_13;
    }

    public void setAwakenable(int OplusGLSurfaceView_13) {
        this.mAwakenable = OplusGLSurfaceView_13;
    }

    public void setServiceChannelList(List<ServiceChannel> list) {
        this.mServiceChannelList = list;
    }

    public String toString() {
        return "ServiceProfile{mId='" + this.mId + "', mName='" + this.mName + "', mServiceImpl='" + this.mServiceImpl + "', mVersion='" + this.mVersion + "', mRole='" + this.mRole + "', mServiceLimit=" + this.mServiceLimit + ", mServiceTimeout=" + this.mServiceTimeout + ", mTransportType=" + this.mTransportType + ", isMexSupported=" + this.mIsMexSupported + ", isSocketSupported=" + this.mIsSocketSupported + ", mServiceChannelList=" + this.mServiceChannelList + ", Awakenable=" + this.mAwakenable + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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
