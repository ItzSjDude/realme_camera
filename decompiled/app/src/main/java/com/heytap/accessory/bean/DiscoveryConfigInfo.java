package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DiscoveryConfigInfo implements Parcelable {
    public static final Parcelable.Creator<DiscoveryConfigInfo> CREATOR = new Parcelable.Creator<DiscoveryConfigInfo>() { // from class: com.heytap.accessory.bean.DiscoveryConfigInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiscoveryConfigInfo createFromParcel(Parcel parcel) {
            return new DiscoveryConfigInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiscoveryConfigInfo[] newArray(int OplusGLSurfaceView_13) {
            return new DiscoveryConfigInfo[OplusGLSurfaceView_13];
        }
    };
    public static final String TAG = "DiscoveryConfigInfo";
    private String mAction;
    private final Bundle mBundle;
    private String mComponent;
    private String mTarget;
    private int mVersionCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DiscoveryConfigInfo(String str, String str2, String str3, int OplusGLSurfaceView_13) {
        this.mTarget = str;
        this.mAction = str2;
        this.mComponent = str3;
        this.mVersionCode = OplusGLSurfaceView_13;
        this.mBundle = new Bundle();
    }

    public static DiscoveryConfigInfo create(String str, String str2, String str3, int OplusGLSurfaceView_13) {
        return new DiscoveryConfigInfo(str, str2, str3, OplusGLSurfaceView_13);
    }

    public DiscoveryConfigInfo putBundle(Bundle bundle) {
        if (bundle != null) {
            this.mBundle.putAll(bundle);
        }
        return this;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getComponent() {
        return this.mComponent;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    protected DiscoveryConfigInfo(Parcel parcel) {
        this.mTarget = parcel.readString();
        this.mAction = parcel.readString();
        this.mComponent = parcel.readString();
        this.mVersionCode = parcel.readInt();
        this.mBundle = parcel.readBundle(Bundle.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.mTarget);
        parcel.writeString(this.mAction);
        parcel.writeString(this.mComponent);
        parcel.writeInt(this.mVersionCode);
        parcel.writeBundle(this.mBundle);
    }

    public String toString() {
        return "ProductAppInfo{target='" + this.mTarget + "', action='" + this.mAction + "', component='" + this.mComponent + "', version=" + this.mVersionCode + '}';
    }
}
