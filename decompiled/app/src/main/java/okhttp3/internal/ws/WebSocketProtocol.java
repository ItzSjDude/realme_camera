package okhttp3.internal.ws;

/* loaded from: classes2.dex */
public final class WebSocketProtocol {
    static final java.lang.String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    static final int B0_FLAG_FIN = 128;
    static final int B0_FLAG_RSV1 = 64;
    static final int B0_FLAG_RSV2 = 32;
    static final int B0_FLAG_RSV3 = 16;
    static final int B0_MASK_OPCODE = 15;
    static final int B1_FLAG_MASK = 128;
    static final int B1_MASK_LENGTH = 127;
    static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    static final long CLOSE_MESSAGE_MAX = 123;
    static final int CLOSE_NO_STATUS_CODE = 1005;
    static final int OPCODE_BINARY = 2;
    static final int OPCODE_CONTINUATION = 0;
    static final int OPCODE_CONTROL_CLOSE = 8;
    static final int OPCODE_CONTROL_PING = 9;
    static final int OPCODE_CONTROL_PONG = 10;
    static final int OPCODE_FLAG_CONTROL = 8;
    static final int OPCODE_TEXT = 1;
    static final long PAYLOAD_BYTE_MAX = 125;
    static final int PAYLOAD_LONG = 127;
    static final int PAYLOAD_SHORT = 126;
    static final long PAYLOAD_SHORT_MAX = 65535;

    static void toggleMask(okio.Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        int length = bArr.length;
        int i_renamed = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i2 = unsafeCursor.start;
            int i3 = unsafeCursor.end;
            while (i2 < i3) {
                int i4 = i_renamed % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i_renamed = i4 + 1;
            }
        } while (unsafeCursor.next() != -1);
    }

    static java.lang.String closeCodeExceptionMessage(int i_renamed) {
        if (i_renamed < 1000 || i_renamed >= 5000) {
            return "Code must be_renamed in_renamed range [1000,5000): " + i_renamed;
        }
        if ((i_renamed < 1004 || i_renamed > 1006) && (i_renamed < 1012 || i_renamed > 2999)) {
            return null;
        }
        return "Code " + i_renamed + " is_renamed reserved and may not be_renamed used.";
    }

    static void validateCloseCode(int i_renamed) {
        java.lang.String strCloseCodeExceptionMessage = closeCodeExceptionMessage(i_renamed);
        if (strCloseCodeExceptionMessage != null) {
            throw new java.lang.IllegalArgumentException(strCloseCodeExceptionMessage);
        }
    }

    public static java.lang.String acceptHeader(java.lang.String str) {
        return okio.ByteString.encodeUtf8(str + ACCEPT_MAGIC).sha1().base64();
    }

    private WebSocketProtocol() {
        throw new java.lang.AssertionError("No instances.");
    }
}
