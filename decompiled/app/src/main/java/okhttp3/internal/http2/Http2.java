package okhttp3.internal.http2;

/* loaded from: classes2.dex */
public final class Http2 {
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    static final okio.ByteString CONNECTION_PREFACE = okio.ByteString.encodeUtf8("PRI * HTTP/2.0\r_renamed\n_renamed\r_renamed\nSM\r_renamed\n_renamed\r_renamed\n_renamed");
    private static final java.lang.String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final java.lang.String[] FLAGS = new java.lang.String[64];
    static final java.lang.String[] BINARY = new java.lang.String[256];

    static {
        int i_renamed = 0;
        int i2 = 0;
        while (true) {
            java.lang.String[] strArr = BINARY;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = okhttp3.internal.Util.format("%8s", java.lang.Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        java.lang.String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr) {
            FLAGS[i3 | 8] = FLAGS[i3] + "|PADDED";
        }
        java.lang.String[] strArr3 = FLAGS;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr) {
                int i6 = i5 | i4;
                FLAGS[i6] = FLAGS[i5] + '|' + FLAGS[i4];
                FLAGS[i6 | 8] = FLAGS[i5] + '|' + FLAGS[i4] + "|PADDED";
            }
        }
        while (true) {
            java.lang.String[] strArr4 = FLAGS;
            if (i_renamed >= strArr4.length) {
                return;
            }
            if (strArr4[i_renamed] == null) {
                strArr4[i_renamed] = BINARY[i_renamed];
            }
            i_renamed++;
        }
    }

    private Http2() {
    }

    static java.lang.IllegalArgumentException illegalArgument(java.lang.String str, java.lang.Object... objArr) {
        throw new java.lang.IllegalArgumentException(okhttp3.internal.Util.format(str, objArr));
    }

    static java.io.IOException ioException(java.lang.String str, java.lang.Object... objArr) throws java.io.IOException {
        throw new java.io.IOException(okhttp3.internal.Util.format(str, objArr));
    }

    static java.lang.String frameLog(boolean z_renamed, int i_renamed, int i2, byte b2, byte b3) {
        java.lang.String[] strArr = FRAME_NAMES;
        java.lang.String str = b2 < strArr.length ? strArr[b2] : okhttp3.internal.Util.format("0x%02x", java.lang.Byte.valueOf(b2));
        java.lang.String flags = formatFlags(b2, b3);
        java.lang.Object[] objArr = new java.lang.Object[5];
        objArr[0] = z_renamed ? "<<" : ">>";
        objArr[1] = java.lang.Integer.valueOf(i_renamed);
        objArr[2] = java.lang.Integer.valueOf(i2);
        objArr[3] = str;
        objArr[4] = flags;
        return okhttp3.internal.Util.format("%s_renamed 0x%08x %5d %-13s %s_renamed", objArr);
    }

    static java.lang.String formatFlags(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : BINARY[b3];
            }
            if (b2 != 7 && b2 != 8) {
                java.lang.String[] strArr = FLAGS;
                java.lang.String str = b3 < strArr.length ? strArr[b3] : BINARY[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return BINARY[b3];
    }
}
