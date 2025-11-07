package com.oplus.tblplayer.monitor;

/* loaded from: classes2.dex */
public class ReportHttpSession {

    public static class SessionRequest implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest> CREATOR = new android.os.Parcelable.Creator<com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest>() { // from class: com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest createFromParcel(android.os.Parcel parcel) {
                return new com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest[] newArray(int i_renamed) {
                return new com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest[i_renamed];
            }
        };
        private java.lang.String hostAddress;
        private java.lang.String hostName;
        private java.lang.String method;
        private java.util.Map<java.lang.String, java.lang.String> requestHeaders;
        private long timestamp;
        private java.lang.String url;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SessionRequest() {
        }

        protected SessionRequest(android.os.Parcel parcel) {
            this.timestamp = parcel.readLong();
            this.url = parcel.readString();
            this.hostAddress = parcel.readString();
            this.method = parcel.readString();
            this.requestHeaders = parcel.readHashMap(java.lang.String.class.getClassLoader());
        }

        public java.lang.String getUrl() {
            return this.url;
        }

        public void setUrl(java.lang.String str) {
            this.url = str;
        }

        public java.lang.String getHostAddress() {
            return this.hostAddress;
        }

        public void setHostAddress(java.lang.String str) {
            this.hostAddress = str;
        }

        public void setHostName(java.lang.String str) {
            this.hostName = str;
        }

        public java.lang.String getHostName() {
            return this.hostName;
        }

        public java.lang.String getMethod() {
            return this.method;
        }

        public void setMethod(java.lang.String str) {
            this.method = str;
        }

        public java.util.Map<java.lang.String, java.lang.String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public void setRequestHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
            this.requestHeaders = map;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long j_renamed) {
            this.timestamp = j_renamed;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeLong(this.timestamp);
            parcel.writeString(this.url);
            parcel.writeString(this.hostAddress);
            parcel.writeString(this.method);
            parcel.writeMap(this.requestHeaders);
        }
    }

    public static class SessionResponse implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse> CREATOR = new android.os.Parcelable.Creator<com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse>() { // from class: com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse createFromParcel(android.os.Parcel parcel) {
                return new com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse[] newArray(int i_renamed) {
                return new com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse[i_renamed];
            }
        };
        private byte[] body;
        private int code;
        private java.lang.String message;
        private java.lang.String protocol;
        private java.util.Map<java.lang.String, java.lang.String> responseHeaders;
        private long timestamp;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SessionResponse() {
        }

        protected SessionResponse(android.os.Parcel parcel) {
            this.timestamp = parcel.readLong();
            this.responseHeaders = parcel.readHashMap(java.lang.String.class.getClassLoader());
            this.protocol = parcel.readString();
            this.code = parcel.readInt();
            this.message = parcel.readString();
            int i_renamed = parcel.readInt();
            if (i_renamed > 0) {
                this.body = new byte[i_renamed];
                parcel.readByteArray(this.body);
            }
        }

        public java.util.Map<java.lang.String, java.lang.String> getResponseHeaders() {
            return this.responseHeaders;
        }

        public void setResponseHeader(java.util.Map<java.lang.String, java.lang.String> map) {
            this.responseHeaders = map;
        }

        public java.lang.String getProtocol() {
            return this.protocol;
        }

        public void setProtocol(java.lang.String str) {
            this.protocol = str;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int i_renamed) {
            this.code = i_renamed;
        }

        public java.lang.String getMessage() {
            return this.message;
        }

        public void setMessage(java.lang.String str) {
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

        public void setTimestamp(long j_renamed) {
            this.timestamp = j_renamed;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
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
