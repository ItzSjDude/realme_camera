package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.discovery.IScanFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class CharacterScanFilter implements IScanFilter {
    public static final Parcelable.Creator<CharacterScanFilter> CREATOR = new Parcelable.Creator<CharacterScanFilter>() { // from class: com.heytap.accessory.bean.CharacterScanFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacterScanFilter createFromParcel(Parcel parcel) {
            return new CharacterScanFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacterScanFilter[] newArray(int OplusGLSurfaceView_13) {
            return new CharacterScanFilter[OplusGLSurfaceView_13];
        }
    };
    public static final String KEY = "CharaScanFilter";
    private static final int LIMITED_DEVICEID_LENGTH = 6;
    private Set<byte[]> mDeviceIdSet = new HashSet();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public String getKey() {
        return KEY;
    }

    private CharacterScanFilter() {
    }

    public static CharacterScanFilter create() {
        return new CharacterScanFilter();
    }

    public CharacterScanFilter addDeviceId(byte[] bArr) {
        if (bArr == null || bArr.length != 6) {
            throw new IllegalArgumentException("device id_renamed invalid (length must be 6 byte)");
        }
        this.mDeviceIdSet.add(bArr);
        return this;
    }

    public Set<byte[]> getDeviceIdSet() {
        return this.mDeviceIdSet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mDeviceIdSet.size());
        Iterator<byte[]> it = this.mDeviceIdSet.iterator();
        while (it.hasNext()) {
            parcel.writeByteArray(it.next());
        }
    }

    protected CharacterScanFilter(Parcel parcel) {
        int OplusGLSurfaceView_13 = parcel.readInt();
        if (OplusGLSurfaceView_13 > 0) {
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                this.mDeviceIdSet.add(parcel.createByteArray());
            }
        }
    }
}
