package com.oplus.tblplayer.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes2.dex */
public class ReportHttpSession {

    public static class SessionRequest implements Parcelable {
        public static final Parcelable.Creator<SessionRequest> CREATOR = new Parcelable.Creator<SessionRequest>() { // from class: com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionRequest createFromParcel(Parcel parcel) {
                return new SessionRequest(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionRequest[] newArray(int OplusGLSurfaceView_13) {
                return new SessionRequest[OplusGLSurfaceView_13];
            }
        };
        private String hostAddress;
        private String hostName;
        private String method;
        private Map<String, String> requestHeaders;
        private long timestamp;
        private String url;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SessionRequest() {
        }

        protected SessionRequest(Parcel parcel) {
            this.timestamp = parcel.readLong();
            this.url = parcel.readString();
            this.hostAddress = parcel.readString();
            this.method = parcel.readString();
            this.requestHeaders = parcel.readHashMap(String.class.getClassLoader());
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String getHostAddress() {
            return this.hostAddress;
        }

        public void setHostAddress(String str) {
            this.hostAddress = str;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        public String getHostName() {
            return this.hostName;
        }

        public String getMethod() {
            return this.method;
        }

        public void setMethod(String str) {
            this.method = str;
        }

        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public void setRequestHeaders(Map<String, String> map) {
            this.requestHeaders = map;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long OplusGLSurfaceView_15) {
            this.timestamp = OplusGLSurfaceView_15;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeLong(this.timestamp);
            parcel.writeString(this.url);
            parcel.writeString(this.hostAddress);
            parcel.writeString(this.method);
            parcel.writeMap(this.requestHeaders);
        }
    }

    public static class SessionResponse implements Parcelable {
        public static final Parcelable.Creator<SessionResponse> CREATOR = new Parcelable.Creator<SessionResponse>() { // from class: com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionResponse createFromParcel(Parcel parcel) {
                return new SessionResponse(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionResponse[] newArray(int OplusGLSurfaceView_13) {
                return new SessionResponse[OplusGLSurfaceView_13];
            }
        };
        private byte[] body;
        private int code;
        private String message;
        private String protocol;
        private Map<String, String> responseHeaders;
        private long timestamp;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SessionResponse() {
        }

        protected SessionResponse(Parcel parcel) {
            this.timestamp = parcel.readLong();
            this.responseHeaders = parcel.readHashMap(String.class.getClassLoader());
            this.protocol = parcel.readString();
            this.code = parcel.readInt();
            this.message = parcel.readString();
            int OplusGLSurfaceView_13 = parcel.readInt();
            if (OplusGLSurfaceView_13 > 0) {
                this.body = new byte[OplusGLSurfaceView_13];
                parcel.readByteArray(this.body);
            }
        }

        public Map<String, String> getResponseHeaders() {
            return this.responseHeaders;
        }

        public void setResponseHeader(Map<String, String> map) {
            this.responseHeaders = map;
        }

        public String getProtocol() {
            return this.protocol;
        }

        public void setProtocol(String str) {
            this.protocol = str;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int OplusGLSurfaceView_13) {
            this.code = OplusGLSurfaceView_13;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public byte[] getBody() {
            return this.body;
        }

        public void setBody(byte[] bArr) {
            this.body = bArr;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long OplusGLSurfaceView_15) {
            this.timestamp = OplusGLSurfaceView_15;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeLong(this.timestamp);
            parcel.writeMap(this.responseHeaders);
            parcel.writeString(this.protocol);
            parcel.writeInt(this.code);
            parcel.writeString(this.message);
            byte[] bArr = this.body;
            if (bArr != null && bArr.length > 0) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.body);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
