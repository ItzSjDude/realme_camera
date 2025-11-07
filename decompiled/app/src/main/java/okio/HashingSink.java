package okio;

/* loaded from: classes2.dex */
public final class HashingSink extends okio.ForwardingSink {

    @javax.annotation.Nullable
    private final javax.crypto.Mac mac;

    @javax.annotation.Nullable
    private final java.security.MessageDigest messageDigest;

    public static okio.HashingSink md5(okio.Sink sink) {
        return new okio.HashingSink(sink, "MD5");
    }

    public static okio.HashingSink sha1(okio.Sink sink) {
        return new okio.HashingSink(sink, "SHA-1");
    }

    public static okio.HashingSink sha256(okio.Sink sink) {
        return new okio.HashingSink(sink, "SHA-256");
    }

    public static okio.HashingSink sha512(okio.Sink sink) {
        return new okio.HashingSink(sink, "SHA-512");
    }

    public static okio.HashingSink hmacSha1(okio.Sink sink, okio.ByteString byteString) {
        return new okio.HashingSink(sink, byteString, "HmacSHA1");
    }

    public static okio.HashingSink hmacSha256(okio.Sink sink, okio.ByteString byteString) {
        return new okio.HashingSink(sink, byteString, "HmacSHA256");
    }

    public static okio.HashingSink hmacSha512(okio.Sink sink, okio.ByteString byteString) {
        return new okio.HashingSink(sink, byteString, "HmacSHA512");
    }

    private HashingSink(okio.Sink sink, java.lang.String str) {
        super(sink);
        try {
            this.messageDigest = java.security.MessageDigest.getInstance(str);
            this.mac = null;
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    private HashingSink(okio.Sink sink, okio.ByteString byteString, java.lang.String str) throws java.security.InvalidKeyException {
        super(sink);
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

    @Override // okio.ForwardingSink, okio.Sink
    public void write(okio.Buffer buffer, long j_renamed) throws java.lang.IllegalStateException, java.io.IOException {
        okio.Util.checkOffsetAndCount(buffer.size, 0L, j_renamed);
        okio.Segment segment = buffer.head;
        long j2 = 0;
        while (j2 < j_renamed) {
            int iMin = (int) java.lang.Math.min(j_renamed - j2, segment.limit - segment.pos);
            java.security.MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                this.mac.update(segment.data, segment.pos, iMin);
            }
            j2 += iMin;
            segment = segment.next;
        }
        super.write(buffer, j_renamed);
    }

    public final okio.ByteString hash() {
        java.security.MessageDigest messageDigest = this.messageDigest;
        return okio.ByteString.of_renamed(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }
}
