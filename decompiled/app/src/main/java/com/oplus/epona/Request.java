package com.oplus.epona;

/* loaded from: classes2.dex */
public class Request implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.epona.Request> CREATOR = new android.os.Parcelable.Creator<com.oplus.epona.Request>() { // from class: com.oplus.epona.Request.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.epona.Request createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.epona.Request(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.epona.Request[] newArray(int i_renamed) {
            return new com.oplus.epona.Request[i_renamed];
        }
    };
    private final java.lang.String mActionName;
    private android.os.Bundle mBundle;
    private final java.lang.String mComponentName;
    private com.oplus.epona.route.RouteData mRouteData;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Request(java.lang.String str, java.lang.String str2, android.os.Bundle bundle, com.oplus.epona.route.RouteData routeData) {
        this.mBundle = new android.os.Bundle();
        this.mComponentName = str;
        this.mActionName = str2;
        this.mBundle.putAll(bundle);
        this.mRouteData = routeData;
    }

    private Request(android.os.Parcel parcel) {
        this.mBundle = new android.os.Bundle();
        this.mComponentName = parcel.readString();
        this.mActionName = parcel.readString();
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }

    public void putBundle(android.os.Bundle bundle) {
        this.mBundle.putAll(bundle);
    }

    public java.lang.String getComponentName() {
        return this.mComponentName;
    }

    public java.lang.String getActionName() {
        return this.mActionName;
    }

    public android.os.Bundle getBundle() {
        return this.mBundle;
    }

    public com.oplus.epona.route.RouteData getRouteData() {
        return this.mRouteData;
    }

    public java.lang.String toString() {
        return "Request{Component=" + this.mComponentName + ",Action=" + this.mActionName + ",Bundle=" + this.mBundle + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mComponentName);
        parcel.writeString(this.mActionName);
        parcel.writeBundle(this.mBundle);
    }

    public static class Builder {
        private java.lang.String mActionName;
        private android.os.Bundle mBundle = new android.os.Bundle();
        private java.lang.String mComponentName;
        private com.oplus.epona.route.RouteData mRouteData;

        public com.oplus.epona.Request.Builder setComponentName(java.lang.String str) {
            this.mComponentName = str;
            return this;
        }

        public com.oplus.epona.Request.Builder setActionName(java.lang.String str) {
            this.mActionName = str;
            return this;
        }

        public com.oplus.epona.Request.Builder withBoolean(java.lang.String str, boolean z_renamed) {
            this.mBundle.putBoolean(str, z_renamed);
            return this;
        }

        public com.oplus.epona.Request.Builder withByte(java.lang.String str, byte b2) {
            this.mBundle.putByte(str, b2);
            return this;
        }

        public com.oplus.epona.Request.Builder withChar(java.lang.String str, char c2) {
            this.mBundle.putChar(str, c2);
            return this;
        }

        public com.oplus.epona.Request.Builder withShort(java.lang.String str, short s_renamed) {
            this.mBundle.putShort(str, s_renamed);
            return this;
        }

        public com.oplus.epona.Request.Builder withInt(java.lang.String str, int i_renamed) {
            this.mBundle.putInt(str, i_renamed);
            return this;
        }

        public com.oplus.epona.Request.Builder withLong(java.lang.String str, long j_renamed) {
            this.mBundle.putLong(str, j_renamed);
            return this;
        }

        public com.oplus.epona.Request.Builder withFloat(java.lang.String str, float f_renamed) {
            this.mBundle.putFloat(str, f_renamed);
            return this;
        }

        public com.oplus.epona.Request.Builder withDouble(java.lang.String str, double d_renamed) {
            this.mBundle.putDouble(str, d_renamed);
            return this;
        }

        public com.oplus.epona.Request.Builder withString(java.lang.String str, java.lang.String str2) {
            this.mBundle.putString(str, str2);
            return this;
        }

        public com.oplus.epona.Request.Builder withCharSequence(java.lang.String str, java.lang.CharSequence charSequence) {
            this.mBundle.putCharSequence(str, charSequence);
            return this;
        }

        public com.oplus.epona.Request.Builder withIntegerArrayList(java.lang.String str, java.util.ArrayList<java.lang.Integer> arrayList) {
            this.mBundle.putIntegerArrayList(str, arrayList);
            return this;
        }

        public com.oplus.epona.Request.Builder withStringArrayList(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
            this.mBundle.putStringArrayList(str, arrayList);
            return this;
        }

        public com.oplus.epona.Request.Builder withCharSequenceList(java.lang.String str, java.util.ArrayList<java.lang.CharSequence> arrayList) {
            this.mBundle.putCharSequenceArrayList(str, arrayList);
            return this;
        }

        public com.oplus.epona.Request.Builder withSerializable(java.lang.String str, java.io.Serializable serializable) {
            this.mBundle.putSerializable(str, serializable);
            return this;
        }

        public com.oplus.epona.Request.Builder withBooleanArray(java.lang.String str, boolean[] zArr) {
            this.mBundle.putBooleanArray(str, zArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withByteArray(java.lang.String str, byte[] bArr) {
            this.mBundle.putByteArray(str, bArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withShortArray(java.lang.String str, short[] sArr) {
            this.mBundle.putShortArray(str, sArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withCharArray(java.lang.String str, char[] cArr) {
            this.mBundle.putCharArray(str, cArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withIntArray(java.lang.String str, int[] iArr) {
            this.mBundle.putIntArray(str, iArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withLongArray(java.lang.String str, long[] jArr) {
            this.mBundle.putLongArray(str, jArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withFloatArray(java.lang.String str, float[] fArr) {
            this.mBundle.putFloatArray(str, fArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withDoubleArray(java.lang.String str, double[] dArr) {
            this.mBundle.putDoubleArray(str, dArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withStringArray(java.lang.String str, java.lang.String[] strArr) {
            this.mBundle.putStringArray(str, strArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withCharSequenceArray(java.lang.String str, java.lang.CharSequence[] charSequenceArr) {
            this.mBundle.putCharSequenceArray(str, charSequenceArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withParcelable(java.lang.String str, android.os.Parcelable parcelable) {
            this.mBundle.putParcelable(str, parcelable);
            return this;
        }

        public com.oplus.epona.Request.Builder withParcelableArray(java.lang.String str, android.os.Parcelable[] parcelableArr) {
            this.mBundle.putParcelableArray(str, parcelableArr);
            return this;
        }

        public com.oplus.epona.Request.Builder withParcelableArrayList(java.lang.String str, java.util.ArrayList<? extends android.os.Parcelable> arrayList) {
            this.mBundle.putParcelableArrayList(str, arrayList);
            return this;
        }

        public com.oplus.epona.Request.Builder withBundle(java.lang.String str, android.os.Bundle bundle) {
            this.mBundle.putBundle(str, bundle);
            return this;
        }

        public com.oplus.epona.Request.Builder withBinder(java.lang.String str, android.os.IBinder iBinder) {
            this.mBundle.putBinder(str, iBinder);
            return this;
        }

        public com.oplus.epona.Request.Builder withRoute(android.content.Context context) {
            return withRoute(context, -1);
        }

        public com.oplus.epona.Request.Builder withRoute(android.content.Context context, int i_renamed) {
            this.mRouteData = new com.oplus.epona.route.RouteData(context, i_renamed);
            return this;
        }

        public com.oplus.epona.Request build() {
            return new com.oplus.epona.Request(this.mComponentName, this.mActionName, this.mBundle, this.mRouteData);
        }
    }
}
