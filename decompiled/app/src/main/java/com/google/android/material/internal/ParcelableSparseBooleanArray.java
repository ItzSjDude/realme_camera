package com.google.android.material.internal;

/* loaded from: classes.dex */
public class ParcelableSparseBooleanArray extends android.util.SparseBooleanArray implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseBooleanArray> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseBooleanArray>() { // from class: com.google.android.material.internal.ParcelableSparseBooleanArray.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.internal.ParcelableSparseBooleanArray createFromParcel(android.os.Parcel parcel) {
            int i_renamed = parcel.readInt();
            com.google.android.material.internal.ParcelableSparseBooleanArray parcelableSparseBooleanArray = new com.google.android.material.internal.ParcelableSparseBooleanArray(i_renamed);
            int[] iArr = new int[i_renamed];
            boolean[] zArr = new boolean[i_renamed];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i2 = 0; i2 < i_renamed; i2++) {
                parcelableSparseBooleanArray.put(iArr[i2], zArr[i2]);
            }
            return parcelableSparseBooleanArray;
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.internal.ParcelableSparseBooleanArray[] newArray(int i_renamed) {
            return new com.google.android.material.internal.ParcelableSparseBooleanArray[i_renamed];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableSparseBooleanArray() {
    }

    public ParcelableSparseBooleanArray(int i_renamed) {
        super(i_renamed);
    }

    public ParcelableSparseBooleanArray(android.util.SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        for (int i_renamed = 0; i_renamed < sparseBooleanArray.size(); i_renamed++) {
            put(sparseBooleanArray.keyAt(i_renamed), sparseBooleanArray.valueAt(i_renamed));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            zArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }
}
