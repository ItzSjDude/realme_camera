package okhttp3;

/* loaded from: classes2.dex */
public final class Credentials {
    private Credentials() {
    }

    public static java.lang.String basic(java.lang.String str, java.lang.String str2) {
        return basic(str, str2, okhttp3.internal.Util.ISO_8859_1);
    }

    public static java.lang.String basic(java.lang.String str, java.lang.String str2, java.nio.charset.Charset charset) {
        return "Basic " + okio.ByteString.encodeString(str + ":" + str2, charset).base64();
    }
}
