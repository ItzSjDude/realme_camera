package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class CharacterScanFilter implements com.heytap.accessory.discovery.IScanFilter {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.CharacterScanFilter> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.CharacterScanFilter>() { // from class: com.heytap.accessory.bean.CharacterScanFilter.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.CharacterScanFilter createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.CharacterScanFilter(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.CharacterScanFilter[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.CharacterScanFilter[i_renamed];
        }
    };
    public static final java.lang.String KEY = "CharaScanFilter";
    private static final int LIMITED_DEVICEID_LENGTH = 6;
    private java.util.Set<byte[]> mDeviceIdSet = new java.util.HashSet();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public java.lang.String getKey() {
        return KEY;
    }

    private CharacterScanFilter() {
    }

    public static com.heytap.accessory.bean.CharacterScanFilter create() {
        return new com.heytap.accessory.bean.CharacterScanFilter();
    }

    public com.heytap.accessory.bean.CharacterScanFilter addDeviceId(byte[] bArr) {
        if (bArr == null || bArr.length != 6) {
            throw new java.lang.IllegalArgumentException("device id_renamed invalid (length must be_renamed 6 byte)");
        }
        this.mDeviceIdSet.add(bArr);
        return this;
    }

    public java.util.Set<byte[]> getDeviceIdSet() {
        return this.mDeviceIdSet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mDeviceIdSet.size());
        java.util.Iterator<byte[]> it = this.mDeviceIdSet.iterator();
        while (it.hasNext()) {
            parcel.writeByteArray(it.next());
        }
    }

    protected CharacterScanFilter(android.os.Parcel parcel) {
        int i_renamed = parcel.readInt();
        if (i_renamed > 0) {
            for (int i2 = 0; i2 < i_renamed; i2++) {
                this.mDeviceIdSet.add(parcel.createByteArray());
            }
        }
    }
}
