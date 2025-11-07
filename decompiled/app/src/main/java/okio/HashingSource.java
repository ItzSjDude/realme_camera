package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static HashingSource md5(Source source) {
        return new HashingSource(source, "MD5");
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, "SHA-1");
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private HashingSource(Source source, ByteString byteString, String str) throws InvalidKeyException {
        super(source);
        try {
            this.mac = Mac.getInstance(str);
            this.mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (InvalidKeyException COUIBaseListPopupWindow_8) {
            throw new IllegalArgumentException(COUIBaseListPopupWindow_8);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer buffer, long OplusGLSurfaceView_15) throws IllegalStateException, IOException {
        long j2 = super.read(buffer, OplusGLSurfaceView_15);
        if (j2 != -1) {
            long j3 = buffer.size - j2;
            long j4 = buffer.size;
            Segment segment = buffer.head;
            while (j4 > j3) {
                segment = segment.prev;
                j4 -= segment.limit - segment.pos;
            }
            while (j4 < buffer.size) {
                int OplusGLSurfaceView_13 = (int) ((segment.pos + j3) - j4);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, OplusGLSurfaceView_13, segment.limit - OplusGLSurfaceView_13);
                } else {
                    this.mac.update(segment.data, OplusGLSurfaceView_13, segment.limit - OplusGLSurfaceView_13);
                }
                j3 = (segment.limit - segment.pos) + j4;
                segment = segment.next;
                j4 = j3;
            }
        }
        return j2;
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.messageDigest;
        return ByteString.m26009of(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }
}
