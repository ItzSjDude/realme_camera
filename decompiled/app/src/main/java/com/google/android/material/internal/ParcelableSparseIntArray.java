package com.google.android.material.internal;

/* loaded from: classes.dex */
public class ParcelableSparseIntArray extends android.util.SparseIntArray implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseIntArray> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseIntArray>() { // from class: com.google.android.material.internal.ParcelableSparseIntArray.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.internal.ParcelableSparseIntArray createFromParcel(android.os.Parcel parcel) {
            int i_renamed = parcel.readInt();
            com.google.android.material.internal.ParcelableSparseIntArray parcelableSparseIntArray = new com.google.android.material.internal.ParcelableSparseIntArray(i_renamed);
            int[] iArr = new int[i_renamed];
            int[] iArr2 = new int[i_renamed];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i2 = 0; i2 < i_renamed; i2++) {
                parcelableSparseIntArray.put(iArr[i2], iArr2[i2]);
            }
            return parcelableSparseIntArray;
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.internal.ParcelableSparseIntArray[] newArray(int i_renamed) {
            return new com.google.android.material.internal.ParcelableSparseIntArray[i_renamed];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(int i_renamed) {
        super(i_renamed);
    }

    public ParcelableSparseIntArray(android.util.SparseIntArray sparseIntArray) {
        for (int i_renamed = 0; i_renamed < sparseIntArray.size(); i_renamed++) {
            put(sparseIntArray.keyAt(i_renamed), sparseIntArray.valueAt(i_renamed));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            iArr2[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
