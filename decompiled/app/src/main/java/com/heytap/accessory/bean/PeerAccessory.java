package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class PeerAccessory implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.PeerAccessory> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.PeerAccessory>() { // from class: com.heytap.accessory.bean.PeerAccessory.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PeerAccessory createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.PeerAccessory(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PeerAccessory[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.PeerAccessory[i_renamed];
        }
    };
    static final int DEFAULT_APDU_SIZE = 1048576;
    static final int DEFAULT_ENCRYPTION_PADDING_LENGTH = 0;
    static final int DEFAULT_MXDU_SIZE = 65524;
    static final int DEFAULT_SSDU_SIZE = 65530;
    public static final java.lang.String TAG = "PeerAccessory";
    public static final java.lang.String VERSION_TAG = "newPA_V1";
    private final java.lang.String mAddress;
    private final int mApduSize;
    private byte[] mDeviceId;
    private int mDeviceType;
    private final int mEncryptionPaddingLength;
    private final long mId;
    private final int mMxduSize;
    private final java.lang.String mName;
    private final java.lang.String mPeerId;
    private final java.lang.String mProductId;
    private final int mSsduSize;
    private int mStatus;
    private final boolean mSupportCompression;
    private final boolean mSupportFile;
    private final boolean mSupportMessage;
    private final boolean mSupportStream;
    private final int mTransportType;
    private int mUUIDType;
    private final java.lang.String mVendorId;
    private final int mVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PeerAccessory(android.os.Parcel parcel) {
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
            java.lang.String string = parcel.readString();
            if (!VERSION_TAG.equals(string)) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "PeerAccessory: tag is_renamed not correct, reset position");
                parcel.setDataPosition(iDataPosition);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "PeerAccessory: tag not empty:".concat(java.lang.String.valueOf(string)));
            android.os.Bundle bundle = parcel.readBundle(com.heytap.accessory.bean.PeerAccessory.class.getClassLoader());
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "PeerAccessory: tag is_renamed not correct, reset position");
                parcel.setDataPosition(iDataPosition);
            } else {
                this.mUUIDType = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_UUID, 0);
                this.mStatus = bundle.getInt("status", 0);
                this.mDeviceId = bundle.getByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_DEVICE_ID);
                this.mDeviceType = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_DEVICE_TYPE, 0);
            }
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "PeerAccessory:  get tag exception," + e_renamed.getMessage());
            parcel.setDataPosition(iDataPosition);
        }
    }

    PeerAccessory(java.util.List<java.lang.String> list) {
        this.mVersion = java.lang.Integer.parseInt(list.get(0));
        this.mId = java.lang.Integer.parseInt(list.get(1));
        this.mAddress = list.get(2);
        this.mName = list.get(3);
        this.mTransportType = java.lang.Integer.parseInt(list.get(4));
        this.mProductId = list.get(5);
        this.mVendorId = list.get(6);
        this.mSsduSize = java.lang.Integer.parseInt(list.get(7));
        this.mPeerId = list.get(8);
        this.mMxduSize = java.lang.Integer.parseInt(list.get(9));
        this.mApduSize = java.lang.Integer.parseInt(list.get(10));
        this.mEncryptionPaddingLength = java.lang.Integer.parseInt(list.get(11));
        this.mSupportMessage = java.lang.Boolean.parseBoolean(list.get(12));
        this.mSupportFile = java.lang.Boolean.parseBoolean(list.get(13));
        this.mSupportCompression = java.lang.Boolean.parseBoolean(list.get(14));
        this.mSupportStream = java.lang.Boolean.parseBoolean(list.get(15));
        this.mUUIDType = java.lang.Integer.parseInt(list.get(16));
        this.mStatus = java.lang.Integer.parseInt(list.get(17));
        this.mDeviceId = com.heytap.accessory.b_renamed.e_renamed.a_renamed(list.get(18));
        this.mDeviceType = java.lang.Integer.parseInt(list.get(19));
    }

    public java.util.List<java.lang.String> getContent() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.toString(this.mVersion));
        arrayList.add(java.lang.Long.toString(this.mId));
        arrayList.add(this.mAddress);
        arrayList.add(this.mName);
        arrayList.add(java.lang.Integer.toString(this.mTransportType));
        arrayList.add(this.mProductId);
        arrayList.add(this.mVendorId);
        arrayList.add(java.lang.Integer.toString(this.mSsduSize));
        arrayList.add(this.mPeerId);
        arrayList.add(java.lang.Integer.toString(this.mMxduSize));
        arrayList.add(java.lang.Integer.toString(this.mApduSize));
        arrayList.add(java.lang.Integer.toString(this.mEncryptionPaddingLength));
        arrayList.add(java.lang.Boolean.toString(this.mSupportMessage));
        arrayList.add(java.lang.Boolean.toString(this.mSupportFile));
        arrayList.add(java.lang.Boolean.toString(this.mSupportCompression));
        arrayList.add(java.lang.Boolean.toString(this.mSupportStream));
        arrayList.add(java.lang.Integer.toString(this.mUUIDType));
        arrayList.add(java.lang.Integer.toString(this.mStatus));
        arrayList.add(com.heytap.accessory.b_renamed.e_renamed.a_renamed(this.mDeviceId));
        arrayList.add(java.lang.String.valueOf(this.mDeviceType));
        return arrayList;
    }

    public PeerAccessory(int i_renamed, long j_renamed, java.lang.String str, java.lang.String str2, int i2, int i3, java.lang.String str3, java.lang.String str4, int i4, int i5, int i6, int i7, java.lang.String str5, boolean z_renamed, boolean z2, boolean z3, boolean z4, int i8, byte[] bArr, int i9) {
        this.mVersion = i_renamed;
        this.mId = j_renamed;
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
        this.mSupportMessage = z_renamed;
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

    public java.lang.String getAddress() {
        return this.mAddress;
    }

    @java.lang.Deprecated
    public java.lang.String getAccessoryId() {
        return this.mPeerId;
    }

    public java.lang.String getPeerId() {
        return this.mPeerId;
    }

    public long getId() {
        return this.mId;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getProductId() {
        return this.mProductId;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public java.lang.String getVendorId() {
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

    public void setStatus(int i_renamed) {
        this.mStatus = i_renamed;
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
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
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
        if (com.heytap.accessory.b_renamed.g_renamed.f_renamed() > 0) {
            parcel.writeString(VERSION_TAG);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt(com.heytap.accessory.constant.AFConstants.EXTRA_UUID, this.mUUIDType);
            bundle.putInt("status", this.mStatus);
            bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_DEVICE_ID, this.mDeviceId);
            bundle.putInt(com.heytap.accessory.constant.AFConstants.EXTRA_DEVICE_TYPE, this.mDeviceType);
            parcel.writeBundle(bundle);
        }
    }

    public java.lang.String toString() {
        return "PeerAccessory{mVersion=" + this.mVersion + ", mId=" + this.mId + ", mAddress='" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mAddress) + "', mName='" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(this.mName) + "', mTransportType=" + this.mTransportType + ", mUUnameType=" + this.mUUIDType + ", mProductId='" + this.mProductId + "', mVendorId='" + this.mVendorId + "', mApduSize=" + this.mApduSize + ", mSsduSize=" + this.mSsduSize + ", mMxduSize=" + this.mMxduSize + ", mEncryptionPaddingLength=" + this.mEncryptionPaddingLength + ", mPeerId='" + this.mPeerId + "', mSupportMessage=" + this.mSupportMessage + ", mSupportFile=" + this.mSupportFile + ", mSupportCompression=" + this.mSupportCompression + ", mSupportStream=" + this.mSupportStream + ", mStatus=" + this.mStatus + ", mDeviceId=" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mDeviceId) + ", mDeviceType=" + this.mDeviceType + '}';
    }

    public java.lang.String toShortString() {
        return "PeerAccessory{, mAddress='" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mAddress) + "', fraVer='" + com.heytap.accessory.b_renamed.g_renamed.f_renamed() + "', mName='" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(this.mName) + "', mTransportType=" + this.mTransportType + ", mDeviceId=" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mDeviceId) + ", mDeviceType=" + this.mDeviceType + '}';
    }
}
