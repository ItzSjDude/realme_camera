package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.HexUtils;
import com.heytap.accessory.p104b.SdkConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PeerAccessory implements Parcelable {
    public static final Parcelable.Creator<PeerAccessory> CREATOR = new Parcelable.Creator<PeerAccessory>() { // from class: com.heytap.accessory.bean.PeerAccessory.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAccessory createFromParcel(Parcel parcel) {
            return new PeerAccessory(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAccessory[] newArray(int OplusGLSurfaceView_13) {
            return new PeerAccessory[OplusGLSurfaceView_13];
        }
    };
    static final int DEFAULT_APDU_SIZE = 1048576;
    static final int DEFAULT_ENCRYPTION_PADDING_LENGTH = 0;
    static final int DEFAULT_MXDU_SIZE = 65524;
    static final int DEFAULT_SSDU_SIZE = 65530;
    public static final String TAG = "PeerAccessory";
    public static final String VERSION_TAG = "newPA_V1";
    private final String mAddress;
    private final int mApduSize;
    private byte[] mDeviceId;
    private int mDeviceType;
    private final int mEncryptionPaddingLength;
    private final long mId;
    private final int mMxduSize;
    private final String mName;
    private final String mPeerId;
    private final String mProductId;
    private final int mSsduSize;
    private int mStatus;
    private final boolean mSupportCompression;
    private final boolean mSupportFile;
    private final boolean mSupportMessage;
    private final boolean mSupportStream;
    private final int mTransportType;
    private int mUUIDType;
    private final String mVendorId;
    private final int mVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PeerAccessory(Parcel parcel) {
        this.mVersion = parcel.readInt();
        this.mId = parcel.readLong();
        this.mAddress = parcel.readString();
        this.mName = parcel.readString();
        this.mTransportType = parcel.readInt();
        this.mProductId = parcel.readString();
        this.mVendorId = parcel.readString();
        this.mSsduSize = parcel.readInt();
        this.mPeerId = parcel.readString();
        this.mMxduSize = parcel.readInt();
        this.mApduSize = parcel.readInt();
        this.mEncryptionPaddingLength = parcel.readInt();
        this.mSupportMessage = parcel.readInt() == 1;
        this.mSupportFile = parcel.readInt() == 1;
        this.mSupportCompression = parcel.readInt() == 1;
        this.mSupportStream = parcel.readInt() == 1;
        int iDataPosition = parcel.dataPosition();
        try {
            String string = parcel.readString();
            if (!VERSION_TAG.equals(string)) {
                SdkLog.m8378b(TAG, "PeerAccessory: tag is not correct, reset position");
                parcel.setDataPosition(iDataPosition);
                return;
            }
            SdkLog.m8378b(TAG, "PeerAccessory: tag not empty:".concat(String.valueOf(string)));
            Bundle bundle = parcel.readBundle(PeerAccessory.class.getClassLoader());
            if (bundle == null) {
                SdkLog.m8378b(TAG, "PeerAccessory: tag is not correct, reset position");
                parcel.setDataPosition(iDataPosition);
            } else {
                this.mUUIDType = bundle.getInt(AFConstants.EXTRA_UUID, 0);
                this.mStatus = bundle.getInt("status", 0);
                this.mDeviceId = bundle.getByteArray(AFConstants.EXTRA_DEVICE_ID);
                this.mDeviceType = bundle.getInt(AFConstants.EXTRA_DEVICE_TYPE, 0);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8378b(TAG, "PeerAccessory:  get tag exception," + COUIBaseListPopupWindow_8.getMessage());
            parcel.setDataPosition(iDataPosition);
        }
    }

    PeerAccessory(List<String> list) {
        this.mVersion = Integer.parseInt(list.get(0));
        this.mId = Integer.parseInt(list.get(1));
        this.mAddress = list.get(2);
        this.mName = list.get(3);
        this.mTransportType = Integer.parseInt(list.get(4));
        this.mProductId = list.get(5);
        this.mVendorId = list.get(6);
        this.mSsduSize = Integer.parseInt(list.get(7));
        this.mPeerId = list.get(8);
        this.mMxduSize = Integer.parseInt(list.get(9));
        this.mApduSize = Integer.parseInt(list.get(10));
        this.mEncryptionPaddingLength = Integer.parseInt(list.get(11));
        this.mSupportMessage = Boolean.parseBoolean(list.get(12));
        this.mSupportFile = Boolean.parseBoolean(list.get(13));
        this.mSupportCompression = Boolean.parseBoolean(list.get(14));
        this.mSupportStream = Boolean.parseBoolean(list.get(15));
        this.mUUIDType = Integer.parseInt(list.get(16));
        this.mStatus = Integer.parseInt(list.get(17));
        this.mDeviceId = HexUtils.m8588a(list.get(18));
        this.mDeviceType = Integer.parseInt(list.get(19));
    }

    public List<String> getContent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.toString(this.mVersion));
        arrayList.add(Long.toString(this.mId));
        arrayList.add(this.mAddress);
        arrayList.add(this.mName);
        arrayList.add(Integer.toString(this.mTransportType));
        arrayList.add(this.mProductId);
        arrayList.add(this.mVendorId);
        arrayList.add(Integer.toString(this.mSsduSize));
        arrayList.add(this.mPeerId);
        arrayList.add(Integer.toString(this.mMxduSize));
        arrayList.add(Integer.toString(this.mApduSize));
        arrayList.add(Integer.toString(this.mEncryptionPaddingLength));
        arrayList.add(Boolean.toString(this.mSupportMessage));
        arrayList.add(Boolean.toString(this.mSupportFile));
        arrayList.add(Boolean.toString(this.mSupportCompression));
        arrayList.add(Boolean.toString(this.mSupportStream));
        arrayList.add(Integer.toString(this.mUUIDType));
        arrayList.add(Integer.toString(this.mStatus));
        arrayList.add(HexUtils.m8586a(this.mDeviceId));
        arrayList.add(String.valueOf(this.mDeviceType));
        return arrayList;
    }

    public PeerAccessory(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, String str, String str2, int i2, int i3, String str3, String str4, int i4, int i5, int i6, int i7, String str5, boolean z, boolean z2, boolean z3, boolean z4, int i8, byte[] bArr, int i9) {
        this.mVersion = OplusGLSurfaceView_13;
        this.mId = OplusGLSurfaceView_15;
        this.mAddress = str;
        this.mName = str2;
        this.mTransportType = i2;
        this.mUUIDType = i3;
        this.mProductId = str3;
        this.mVendorId = str4;
        this.mSsduSize = i4;
        this.mApduSize = i5;
        this.mMxduSize = i6;
        this.mEncryptionPaddingLength = i7;
        this.mPeerId = str5;
        this.mSupportMessage = z;
        this.mSupportFile = z2;
        this.mSupportCompression = z3;
        this.mSupportStream = z4;
        this.mStatus = i8;
        this.mDeviceId = bArr;
        this.mDeviceType = i9;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String getAddress() {
        return this.mAddress;
    }

    @Deprecated
    public String getAccessoryId() {
        return this.mPeerId;
    }

    public String getPeerId() {
        return this.mPeerId;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public String getVendorId() {
        return this.mVendorId;
    }

    public int getApduSize() {
        return this.mApduSize;
    }

    public int getSsduSize() {
        return this.mSsduSize;
    }

    public int getMxduSize() {
        return this.mMxduSize;
    }

    public int getEncryptionPaddingLength() {
        return this.mEncryptionPaddingLength;
    }

    public boolean supportMessage() {
        return this.mSupportMessage;
    }

    public boolean supportFile() {
        return this.mSupportFile;
    }

    public boolean supportCompression() {
        return this.mSupportCompression;
    }

    public boolean supportStream() {
        return this.mSupportStream;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int OplusGLSurfaceView_13) {
        this.mStatus = OplusGLSurfaceView_13;
    }

    public int getUUIDType() {
        return this.mUUIDType;
    }

    public byte[] getDeviceId() {
        return this.mDeviceId;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mVersion);
        parcel.writeLong(this.mId);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mTransportType);
        parcel.writeString(this.mProductId);
        parcel.writeString(this.mVendorId);
        parcel.writeInt(this.mSsduSize);
        parcel.writeString(this.mPeerId);
        parcel.writeInt(this.mMxduSize);
        parcel.writeInt(this.mApduSize);
        parcel.writeInt(this.mEncryptionPaddingLength);
        parcel.writeInt(this.mSupportMessage ? 1 : 0);
        parcel.writeInt(this.mSupportFile ? 1 : 0);
        parcel.writeInt(this.mSupportCompression ? 1 : 0);
        parcel.writeInt(this.mSupportStream ? 1 : 0);
        if (SdkConfig.m8603f() > 0) {
            parcel.writeString(VERSION_TAG);
            Bundle bundle = new Bundle();
            bundle.putInt(AFConstants.EXTRA_UUID, this.mUUIDType);
            bundle.putInt("status", this.mStatus);
            bundle.putByteArray(AFConstants.EXTRA_DEVICE_ID, this.mDeviceId);
            bundle.putInt(AFConstants.EXTRA_DEVICE_TYPE, this.mDeviceType);
            parcel.writeBundle(bundle);
        }
    }

    public String toString() {
        return "PeerAccessory{mVersion=" + this.mVersion + ", mId=" + this.mId + ", mAddress='" + HexUtils.m8589b(this.mAddress) + "', mName='" + HexUtils.m8591c(this.mName) + "', mTransportType=" + this.mTransportType + ", mUUnameType=" + this.mUUIDType + ", mProductId='" + this.mProductId + "', mVendorId='" + this.mVendorId + "', mApduSize=" + this.mApduSize + ", mSsduSize=" + this.mSsduSize + ", mMxduSize=" + this.mMxduSize + ", mEncryptionPaddingLength=" + this.mEncryptionPaddingLength + ", mPeerId='" + this.mPeerId + "', mSupportMessage=" + this.mSupportMessage + ", mSupportFile=" + this.mSupportFile + ", mSupportCompression=" + this.mSupportCompression + ", mSupportStream=" + this.mSupportStream + ", mStatus=" + this.mStatus + ", mDeviceId=" + HexUtils.m8590b(this.mDeviceId) + ", mDeviceType=" + this.mDeviceType + '}';
    }

    public String toShortString() {
        return "PeerAccessory{, mAddress='" + HexUtils.m8589b(this.mAddress) + "', fraVer='" + SdkConfig.m8603f() + "', mName='" + HexUtils.m8591c(this.mName) + "', mTransportType=" + this.mTransportType + ", mDeviceId=" + HexUtils.m8590b(this.mDeviceId) + ", mDeviceType=" + this.mDeviceType + '}';
    }
}
