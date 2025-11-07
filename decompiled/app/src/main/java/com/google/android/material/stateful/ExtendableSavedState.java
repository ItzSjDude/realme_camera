package com.google.android.material.stateful;

/* loaded from: classes.dex */
public class ExtendableSavedState extends androidx.customview.view.AbsSavedState {
    public static final android.os.Parcelable.Creator<com.google.android.material.stateful.ExtendableSavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.stateful.ExtendableSavedState>() { // from class: com.google.android.material.stateful.ExtendableSavedState.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public com.google.android.material.stateful.ExtendableSavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            return new com.google.android.material.stateful.ExtendableSavedState(parcel, classLoader);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.stateful.ExtendableSavedState createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.material.stateful.ExtendableSavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public com.google.android.material.stateful.ExtendableSavedState[] newArray(int i_renamed) {
            return new com.google.android.material.stateful.ExtendableSavedState[i_renamed];
        }
    };
    public final androidx.collection.SimpleArrayMap<java.lang.String, android.os.Bundle> extendableStates;

    public ExtendableSavedState(android.os.Parcelable parcelable) {
        super(parcelable);
        this.extendableStates = new androidx.collection.SimpleArrayMap<>();
    }

    private ExtendableSavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
        super(parcel, classLoader);
        int i_renamed = parcel.readInt();
        java.lang.String[] strArr = new java.lang.String[i_renamed];
        parcel.readStringArray(strArr);
        android.os.Bundle[] bundleArr = new android.os.Bundle[i_renamed];
        parcel.readTypedArray(bundleArr, android.os.Bundle.CREATOR);
        this.extendableStates = new androidx.collection.SimpleArrayMap<>(i_renamed);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            this.extendableStates.put(strArr[i2], bundleArr[i2]);
        }
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        super.writeToParcel(parcel, i_renamed);
        int size = this.extendableStates.size();
        parcel.writeInt(size);
        java.lang.String[] strArr = new java.lang.String[size];
        android.os.Bundle[] bundleArr = new android.os.Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.extendableStates.keyAt(i2);
            bundleArr[i2] = this.extendableStates.valueAt(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public java.lang.String toString() {
        return "ExtendableSavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }
}
