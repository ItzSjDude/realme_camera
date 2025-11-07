package okio;

/* loaded from: classes2.dex */
public final class HashingSource extends okio.ForwardingSource {
    private final javax.crypto.Mac mac;
    private final java.security.MessageDigest messageDigest;

    public static okio.HashingSource md5(okio.Source source) {
        return new okio.HashingSource(source, "MD5");
    }

    public static okio.HashingSource sha1(okio.Source source) {
        return new okio.HashingSource(source, "SHA-1");
    }

    public static okio.HashingSource sha256(okio.Source source) {
        return new okio.HashingSource(source, "SHA-256");
    }

    public static okio.HashingSource hmacSha1(okio.Source source, okio.ByteString byteString) {
        return new okio.HashingSource(source, byteString, "HmacSHA1");
    }

    public static okio.HashingSource hmacSha256(okio.Source source, okio.ByteString byteString) {
        return new okio.HashingSource(source, byteString, "HmacSHA256");
    }

    private HashingSource(okio.Source source, java.lang.String str) {
        super(source);
        try {
            this.messageDigest = java.security.MessageDigest.getInstance(str);
            this.mac = null;
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    private HashingSource(okio.Source source, okio.ByteString byteString, java.lang.String str) throws java.security.InvalidKeyException {
        super(source);
        try {
            this.mac = javax.crypto.Mac.getInstance(str);
            this.mac.init(new javax.crypto.spec.SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (java.security.InvalidKeyException e_renamed) {
            throw new java.lang.IllegalArgumentException(e_renamed);
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(okio.Buffer buffer, long j_renamed) throws java.lang.IllegalStateException, java.io.IOException {
        long j2 = super.read(buffer, j_renamed);
        if (j2 != -1) {
            long j3 = buffer.size - j2;
            long j4 = buffer.size;
            okio.Segment segment = buffer.head;
            while (j4 > j3) {
                segment = segment.prev;
                j4 -= segment.limit - segment.pos;
            }
            while (j4 < buffer.size) {
                int i_renamed = (int) ((segment.pos + j3) - j4);
                java.security.MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i_renamed, segment.limit - i_renamed);
                } else {
                    this.mac.update(segment.data, i_renamed, segment.limit - i_renamed);
                }
                j3 = (segment.limit - segment.pos) + j4;
                segment = segment.next;
                j4 = j3;
            }
        }
        return j2;
    }

    public final okio.ByteString hash() {
        java.security.MessageDigest messageDigest = this.messageDigest;
        return okio.ByteString.of_renamed(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }
}
