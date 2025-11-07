package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes2.dex */
public abstract class BaseNCodec implements BinaryDecoder, BinaryEncoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    protected final byte PAD = PAD_DEFAULT;
    protected byte[] buffer;
    private final int chunkSeparatorLength;
    protected int currentLinePos;
    private final int encodedBlockSize;
    protected boolean eof;
    protected final int lineLength;
    protected int modulus;
    protected int pos;
    private int readPos;
    private final int unencodedBlockSize;

    protected static boolean isWhiteSpace(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    abstract void decode(byte[] bArr, int OplusGLSurfaceView_13, int i2);

    abstract void encode(byte[] bArr, int OplusGLSurfaceView_13, int i2);

    protected int getDefaultBufferSize() {
        return 8192;
    }

    protected abstract boolean isInAlphabet(byte b2);

    protected BaseNCodec(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.unencodedBlockSize = OplusGLSurfaceView_13;
        this.encodedBlockSize = i2;
        this.lineLength = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.chunkSeparatorLength = i4;
    }

    boolean hasData() {
        return this.buffer != null;
    }

    int available() {
        if (this.buffer != null) {
            return this.pos - this.readPos;
        }
        return 0;
    }

    private void resizeBuffer() {
        byte[] bArr = this.buffer;
        if (bArr == null) {
            this.buffer = new byte[getDefaultBufferSize()];
            this.pos = 0;
            this.readPos = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buffer = bArr2;
        }
    }

    protected void ensureBufferSize(int OplusGLSurfaceView_13) {
        byte[] bArr = this.buffer;
        if (bArr == null || bArr.length < this.pos + OplusGLSurfaceView_13) {
            resizeBuffer();
        }
    }

    int readResults(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (this.buffer == null) {
            return this.eof ? -1 : 0;
        }
        int iMin = Math.min(available(), i2);
        System.arraycopy(this.buffer, this.readPos, bArr, OplusGLSurfaceView_13, iMin);
        this.readPos += iMin;
        if (this.readPos >= this.pos) {
            this.buffer = null;
        }
        return iMin;
    }

    private void reset() {
        this.buffer = null;
        this.pos = 0;
        this.readPos = 0;
        this.currentLinePos = 0;
        this.modulus = 0;
        this.eof = false;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base-N encode is not PlatformImplementations.kt_3 byte[]");
        }
        return encode((byte[]) obj);
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not PlatformImplementations.kt_3 byte[] or PlatformImplementations.kt_3 String");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        reset();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        decode(bArr, 0, bArr.length);
        decode(bArr, 0, -1);
        byte[] bArr2 = new byte[this.pos];
        readResults(bArr2, 0, bArr2.length);
        return bArr2;
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        reset();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        encode(bArr, 0, bArr.length);
        encode(bArr, 0, -1);
        byte[] bArr2 = new byte[this.pos - this.readPos];
        readResults(bArr2, 0, bArr2.length);
        return bArr2;
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            if (!isInAlphabet(bArr[OplusGLSurfaceView_13]) && (!z || (bArr[OplusGLSurfaceView_13] != 61 && !isWhiteSpace(bArr[OplusGLSurfaceView_13])))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    protected boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            if (61 == bArr[OplusGLSurfaceView_13] || isInAlphabet(bArr[OplusGLSurfaceView_13])) {
                return true;
            }
        }
        return false;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int OplusGLSurfaceView_13 = this.unencodedBlockSize;
        long OplusGLSurfaceView_15 = (((length + OplusGLSurfaceView_13) - 1) / OplusGLSurfaceView_13) * this.encodedBlockSize;
        int i2 = this.lineLength;
        return i2 > 0 ? OplusGLSurfaceView_15 + ((((i2 + OplusGLSurfaceView_15) - 1) / i2) * this.chunkSeparatorLength) : OplusGLSurfaceView_15;
    }
}
