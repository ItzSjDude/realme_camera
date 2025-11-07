package com.oplus.epona;

/* loaded from: classes2.dex */
public class Response implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.epona.Response> CREATOR = new android.os.Parcelable.Creator<com.oplus.epona.Response>() { // from class: com.oplus.epona.Response.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.epona.Response createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.epona.Response(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.epona.Response[] newArray(int i_renamed) {
            return new com.oplus.epona.Response[i_renamed];
        }
    };
    private static final java.lang.String EXCEPTION_INFO = "epona_exception_info";
    private java.lang.Object data;
    private android.os.Bundle mBundle;
    private final int mCode;
    private final java.lang.String mMessage;
    private com.oplus.epona.ParcelableException mParcelableException;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Response(int i_renamed, java.lang.String str) {
        this.mCode = i_renamed;
        this.mMessage = str;
        this.mBundle = new android.os.Bundle();
    }

    private Response(android.os.Parcel parcel) {
        this.mCode = parcel.readInt();
        this.mMessage = parcel.readString();
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }

    public android.os.Bundle getBundle() {
        return this.mBundle;
    }

    private void setBundle(android.os.Bundle bundle) {
        this.mBundle = bundle;
    }

    public java.lang.Object getData() {
        return this.data;
    }

    public void setData(java.lang.Object obj) {
        this.data = obj;
    }

    public int getCode() {
        return this.mCode;
    }

    public java.lang.String getMessage() {
        return this.mMessage;
    }

    public java.lang.String toString() {
        return "Successful=" + isSuccessful() + ", Message=" + this.mMessage;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mCode);
        parcel.writeString(this.mMessage);
        parcel.writeBundle(this.mBundle);
    }

    public static com.oplus.epona.Response newResponse(android.os.Bundle bundle) {
        com.oplus.epona.Response response = new com.oplus.epona.Response(com.oplus.epona.ResponseCode.SUCCESS.getCode(), "");
        response.setBundle(bundle);
        return response;
    }

    public static com.oplus.epona.Response defaultErrorResponse() {
        return new com.oplus.epona.Response(com.oplus.epona.ResponseCode.FAILED.getCode(), "somethings not yet...");
    }

    public static com.oplus.epona.Response errorResponse(com.oplus.epona.ResponseCode responseCode, java.lang.String str) {
        return new com.oplus.epona.Response(responseCode.getCode(), str);
    }

    public static com.oplus.epona.Response errorResponse(java.lang.String str) {
        return new com.oplus.epona.Response(com.oplus.epona.ResponseCode.FAILED.getCode(), str);
    }

    public static com.oplus.epona.Response errorResponse(java.lang.Exception exc) {
        com.oplus.epona.Response response = new com.oplus.epona.Response(com.oplus.epona.ResponseCode.FAILED.getCode(), "response has exception");
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(EXCEPTION_INFO, new com.oplus.epona.ExceptionInfo(exc));
        response.setBundle(bundle);
        return response;
    }

    public <T_renamed extends java.lang.Throwable> void checkThrowable(java.lang.Class<T_renamed> cls) throws java.lang.Throwable {
        android.os.Bundle bundle = this.mBundle;
        if (bundle == null) {
            return;
        }
        if (this.mParcelableException == null) {
            com.oplus.epona.ExceptionInfo exceptionInfo = (com.oplus.epona.ExceptionInfo) bundle.getParcelable(EXCEPTION_INFO);
            if (exceptionInfo == null) {
                return;
            } else {
                this.mParcelableException = com.oplus.epona.ParcelableException.create(exceptionInfo);
            }
        }
        this.mParcelableException.maybeRethrow(cls);
    }

    public boolean isSuccessful() {
        return this.mCode == com.oplus.epona.ResponseCode.SUCCESS.getCode();
    }
}
