package com.oplus.epona;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class Response implements Parcelable {
    public static final Parcelable.Creator<Response> CREATOR = new Parcelable.Creator<Response>() { // from class: com.oplus.epona.Response.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Response createFromParcel(Parcel parcel) {
            return new Response(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Response[] newArray(int OplusGLSurfaceView_13) {
            return new Response[OplusGLSurfaceView_13];
        }
    };
    private static final String EXCEPTION_INFO = "epona_exception_info";
    private Object data;
    private Bundle mBundle;
    private final int mCode;
    private final String mMessage;
    private ParcelableException mParcelableException;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Response(int OplusGLSurfaceView_13, String str) {
        this.mCode = OplusGLSurfaceView_13;
        this.mMessage = str;
        this.mBundle = new Bundle();
    }

    private Response(Parcel parcel) {
        this.mCode = parcel.readInt();
        this.mMessage = parcel.readString();
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    private void setBundle(Bundle bundle) {
        this.mBundle = bundle;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String toString() {
        return "Successful=" + isSuccessful() + ", Message=" + this.mMessage;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mCode);
        parcel.writeString(this.mMessage);
        parcel.writeBundle(this.mBundle);
    }

    public static Response newResponse(Bundle bundle) {
        Response response = new Response(ResponseCode.SUCCESS.getCode(), "");
        response.setBundle(bundle);
        return response;
    }

    public static Response defaultErrorResponse() {
        return new Response(ResponseCode.FAILED.getCode(), "somethings not yet...");
    }

    public static Response errorResponse(ResponseCode responseCode, String str) {
        return new Response(responseCode.getCode(), str);
    }

    public static Response errorResponse(String str) {
        return new Response(ResponseCode.FAILED.getCode(), str);
    }

    public static Response errorResponse(Exception exc) {
        Response response = new Response(ResponseCode.FAILED.getCode(), "response has exception");
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXCEPTION_INFO, new ExceptionInfo(exc));
        response.setBundle(bundle);
        return response;
    }

    public <T extends Throwable> void checkThrowable(Class<T> cls) throws Throwable {
        Bundle bundle = this.mBundle;
        if (bundle == null) {
            return;
        }
        if (this.mParcelableException == null) {
            ExceptionInfo exceptionInfo = (ExceptionInfo) bundle.getParcelable(EXCEPTION_INFO);
            if (exceptionInfo == null) {
                return;
            } else {
                this.mParcelableException = ParcelableException.create(exceptionInfo);
            }
        }
        this.mParcelableException.maybeRethrow(cls);
    }

    public boolean isSuccessful() {
        return this.mCode == ResponseCode.SUCCESS.getCode();
    }
}
