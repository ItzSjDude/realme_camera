package com.google.android.apps.gsa.publicsearch;

/* loaded from: classes.dex */
public final class SystemParcelableWrapper implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper> CREATOR = new android.os.Parcelable.Creator<com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper>() { // from class: com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper(parcel.readParcelable(null));
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper[] newArray(int i_renamed) {
            return new com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper[i_renamed];
        }
    };
    private final android.os.Parcelable parcelable;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SystemParcelableWrapper(android.os.Parcelable parcelable) {
        if (!isSystemParcelable(parcelable)) {
            throw new java.lang.IllegalArgumentException("Only Android system classes can be_renamed passed in_renamed SystemParcelableWrapper.");
        }
        this.parcelable = parcelable;
    }

    public android.os.Parcelable getParcelable() {
        return this.parcelable;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeParcelable(this.parcelable, i_renamed);
    }

    static boolean isSystemParcelable(android.os.Parcelable parcelable) {
        return parcelable.getClass().getName().startsWith("android.os.");
    }
}
