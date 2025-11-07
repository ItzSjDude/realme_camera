package com.google.android.material.internal;

/* loaded from: classes.dex */
public class ParcelableSparseArray extends android.util.SparseArray<android.os.Parcelable> implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseArray> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.internal.ParcelableSparseArray>() { // from class: com.google.android.material.internal.ParcelableSparseArray.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public com.google.android.material.internal.ParcelableSparseArray createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            return new com.google.android.material.internal.ParcelableSparseArray(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public com.google.android.material.internal.ParcelableSparseArray createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.material.internal.ParcelableSparseArray(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public com.google.android.material.internal.ParcelableSparseArray[] newArray(int i_renamed) {
            return new com.google.android.material.internal.ParcelableSparseArray[i_renamed];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableSparseArray() {
    }

    public ParcelableSparseArray(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
        int i_renamed = parcel.readInt();
        int[] iArr = new int[i_renamed];
        parcel.readIntArray(iArr);
        android.os.Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            put(iArr[i2], parcelableArray[i2]);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        int size = size();
        int[] iArr = new int[size];
        android.os.Parcelable[] parcelableArr = new android.os.Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = keyAt(i2);
            parcelableArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i_renamed);
    }
}
