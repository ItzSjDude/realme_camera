package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'PlatformImplementations.kt_3', 'IntrinsicsJvm.kt_4', 'IntrinsicsJvm.kt_3', 'IntrinsicsJvm.kt_5', 'COUIBaseListPopupWindow_8', 'COUIBaseListPopupWindow_12'};
    public static final ByteString EMPTY = m26009of(new byte[0]);

    ByteString(byte[] bArr) {
        this.data = bArr;
    }

    /* renamed from: of */
    public static ByteString m26009of(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new ByteString((byte[]) bArr.clone());
    }

    /* renamed from: of */
    public static ByteString m26010of(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        Util.checkOffsetAndCount(bArr.length, OplusGLSurfaceView_13, i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, OplusGLSurfaceView_13, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    /* renamed from: of */
    public static ByteString m26008of(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new ByteString(bArr);
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(Util.UTF_8));
        byteString.utf8 = str;
        return byteString;
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return new ByteString(str.getBytes(charset));
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, Util.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public String string(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return new String(this.data, charset);
    }

    public String base64() {
        return Base64.encode(this.data);
    }

    public ByteString md5() {
        return digest("MD5");
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String str) {
        try {
            return m26009of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException COUIBaseListPopupWindow_8) {
            throw new AssertionError(COUIBaseListPopupWindow_8);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    private ByteString hmac(String str, ByteString byteString) throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            return m26009of(mac.doFinal(this.data));
        } catch (InvalidKeyException COUIBaseListPopupWindow_8) {
            throw new IllegalArgumentException(COUIBaseListPopupWindow_8);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public String base64Url() {
        return Base64.encodeUrl(this.data);
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrDecode = Base64.decode(str);
        if (bArrDecode != null) {
            return new ByteString(bArrDecode);
        }
        return null;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int OplusGLSurfaceView_13 = 0;
        for (byte b2 : bArr) {
            int i2 = OplusGLSurfaceView_13 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[OplusGLSurfaceView_13] = cArr2[(b2 >> 4) & 15];
            OplusGLSurfaceView_13 = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            int i2 = OplusGLSurfaceView_13 * 2;
            bArr[OplusGLSurfaceView_13] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
        }
        return m26009of(bArr);
    }

    private static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'PlatformImplementations.kt_3';
        if (c2 < 'PlatformImplementations.kt_3' || c2 > 'COUIBaseListPopupWindow_12') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static ByteString read(InputStream inputStream, int OplusGLSurfaceView_13) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + OplusGLSurfaceView_13);
        }
        byte[] bArr = new byte[OplusGLSurfaceView_13];
        int i2 = 0;
        while (i2 < OplusGLSurfaceView_13) {
            int i3 = inputStream.read(bArr, i2, OplusGLSurfaceView_13 - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return new ByteString(bArr);
    }

    public ByteString toAsciiLowercase() {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (OplusGLSurfaceView_13 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[OplusGLSurfaceView_13];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[OplusGLSurfaceView_13] = (byte) (b2 + 32);
                for (int i2 = OplusGLSurfaceView_13 + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            OplusGLSurfaceView_13++;
        }
    }

    public ByteString toAsciiUppercase() {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (OplusGLSurfaceView_13 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[OplusGLSurfaceView_13];
            if (b2 >= 97 && b2 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[OplusGLSurfaceView_13] = (byte) (b2 - 32);
                for (int i2 = OplusGLSurfaceView_13 + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr2[i2] = (byte) (b3 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
            OplusGLSurfaceView_13++;
        }
    }

    public ByteString substring(int OplusGLSurfaceView_13) {
        return substring(OplusGLSurfaceView_13, this.data.length);
    }

    public ByteString substring(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.data;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
        }
        int i3 = i2 - OplusGLSurfaceView_13;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(this.data, OplusGLSurfaceView_13, bArr2, 0, i3);
        return new ByteString(bArr2);
    }

    public byte getByte(int OplusGLSurfaceView_13) {
        return this.data[OplusGLSurfaceView_13];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    byte[] internalArray() {
        return this.data;
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.data);
    }

    void write(Buffer buffer) {
        byte[] bArr = this.data;
        buffer.write(bArr, 0, bArr.length);
    }

    public boolean rangeEquals(int OplusGLSurfaceView_13, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.data, OplusGLSurfaceView_13, i3);
    }

    public boolean rangeEquals(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) {
        if (OplusGLSurfaceView_13 >= 0) {
            byte[] bArr2 = this.data;
            if (OplusGLSurfaceView_13 <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.arrayRangeEquals(bArr2, OplusGLSurfaceView_13, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    public final int indexOf(ByteString byteString, int OplusGLSurfaceView_13) {
        return indexOf(byteString.internalArray(), OplusGLSurfaceView_13);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public int indexOf(byte[] bArr, int OplusGLSurfaceView_13) {
        int length = this.data.length - bArr.length;
        for (int iMax = Math.max(OplusGLSurfaceView_13, 0); iMax <= length; iMax++) {
            if (Util.arrayRangeEquals(this.data, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public final int lastIndexOf(ByteString byteString, int OplusGLSurfaceView_13) {
        return lastIndexOf(byteString.internalArray(), OplusGLSurfaceView_13);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int lastIndexOf(byte[] bArr, int OplusGLSurfaceView_13) {
        for (int iMin = Math.min(OplusGLSurfaceView_13, this.data.length - bArr.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(this.data, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.data;
            if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int OplusGLSurfaceView_13 = this.hashCode;
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int iMin = Math.min(size, size2);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iMin; OplusGLSurfaceView_13++) {
            int i2 = getByte(OplusGLSurfaceView_13) & 255;
            int i3 = byteString.getByte(OplusGLSurfaceView_13) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String strUtf8 = utf8();
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(strUtf8, 64);
        if (iCodePointIndexToCharIndex == -1) {
            if (this.data.length <= 64) {
                return "[hex=" + hex() + "]";
            }
            return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
        }
        String strReplace = strUtf8.substring(0, iCodePointIndexToCharIndex).replace("\\", "\\\\").replace("\OplusGLSurfaceView_11", "\\OplusGLSurfaceView_11").replace("\r", "\\r");
        if (iCodePointIndexToCharIndex < strUtf8.length()) {
            return "[size=" + this.data.length + " text=" + strReplace + "…]";
        }
        return "[text=" + strReplace + "]";
    }

    static int codePointIndexToCharIndex(String str, int OplusGLSurfaceView_13) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == OplusGLSurfaceView_13) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        ByteString byteString = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, byteString.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
