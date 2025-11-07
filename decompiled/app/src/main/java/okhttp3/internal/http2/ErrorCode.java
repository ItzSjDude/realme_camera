package okhttp3.internal.http2;

/* loaded from: classes2.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    public final int httpCode;

    ErrorCode(int i_renamed) {
        this.httpCode = i_renamed;
    }

    public static okhttp3.internal.http2.ErrorCode fromHttp2(int i_renamed) {
        for (okhttp3.internal.http2.ErrorCode errorCode : values()) {
            if (errorCode.httpCode == i_renamed) {
                return errorCode;
            }
        }
        return null;
    }
}
