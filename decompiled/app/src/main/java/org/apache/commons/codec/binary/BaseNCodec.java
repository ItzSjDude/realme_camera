package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public abstract class BaseNCodec implements org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.BinaryEncoder {
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

    abstract void decode(byte[] bArr, int i_renamed, int i2);

    abstract void encode(byte[] bArr, int i_renamed, int i2);

    protected int getDefaultBufferSize() {
        return 8192;
    }

    protected abstract boolean isInAlphabet(byte b2);

    protected BaseNCodec(int i_renamed, int i2, int i3, int i4) {
        this.unencodedBlockSize = i_renamed;
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
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buffer = bArr2;
        }
    }

    protected void ensureBufferSize(int i_renamed) {
        byte[] bArr = this.buffer;
        if (bArr == null || bArr.length < this.pos + i_renamed) {
            resizeBuffer();
        }
    }

    int readResults(byte[] bArr, int i_renamed, int i2) {
        if (this.buffer == null) {
            return this.eof ? -1 : 0;
        }
        int iMin = java.lang.Math.min(available(), i2);
        java.lang.System.arraycopy(this.buffer, this.readPos, bArr, i_renamed, iMin);
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
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof byte[])) {
            throw new org.apache.commons.codec.EncoderException("Parameter supplied to Base-N_renamed encode is_renamed not a_renamed byte[]");
        }
        return encode((byte[]) obj);
    }

    public java.lang.String encodeToString(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encode(bArr));
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return decode((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.DecoderException("Parameter supplied to Base-N_renamed decode is_renamed not a_renamed byte[] or a_renamed String");
    }

    public byte[] decode(java.lang.String str) {
        return decode(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str));
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

    public java.lang.String encodeAsString(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encode(bArr));
    }

    public boolean isInAlphabet(byte[] bArr, boolean z_renamed) {
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            if (!isInAlphabet(bArr[i_renamed]) && (!z_renamed || (bArr[i_renamed] != 61 && !isWhiteSpace(bArr[i_renamed])))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(java.lang.String str) {
        return isInAlphabet(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str), true);
    }

    protected boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            if (61 == bArr[i_renamed] || isInAlphabet(bArr[i_renamed])) {
                return true;
            }
        }
        return false;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i_renamed = this.unencodedBlockSize;
        long j_renamed = (((length + i_renamed) - 1) / i_renamed) * this.encodedBlockSize;
        int i2 = this.lineLength;
        return i2 > 0 ? j_renamed + ((((i2 + j_renamed) - 1) / i2) * this.chunkSeparatorLength) : j_renamed;
    }
}
