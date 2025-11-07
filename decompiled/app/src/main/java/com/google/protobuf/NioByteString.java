package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.oplus.ocs.camera.CameraParameter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, CameraParameter.WaterMarkParamKeys.YUV_BUFFER);
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int OplusGLSurfaceView_13) {
        try {
            return this.buffer.get(OplusGLSurfaceView_13);
        } catch (ArrayIndexOutOfBoundsException COUIBaseListPopupWindow_8) {
            throw COUIBaseListPopupWindow_8;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int OplusGLSurfaceView_13) {
        return byteAt(OplusGLSurfaceView_13);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int OplusGLSurfaceView_13, int i2) {
        try {
            return new NioByteString(slice(OplusGLSurfaceView_13, i2));
        } catch (ArrayIndexOutOfBoundsException COUIBaseListPopupWindow_8) {
            throw COUIBaseListPopupWindow_8;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        ByteBuffer byteBufferSlice = this.buffer.slice();
        byteBufferSlice.position(OplusGLSurfaceView_13);
        byteBufferSlice.get(bArr, i2, i3);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    @Override // com.google.protobuf.ByteString.LeafByteString
    boolean equalsRange(ByteString byteString, int OplusGLSurfaceView_13, int i2) {
        return substring(0, i2).equals(byteString.substring(OplusGLSurfaceView_13, i2 + OplusGLSurfaceView_13));
    }

    @Override // com.google.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int OplusGLSurfaceView_13, int i2) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + OplusGLSurfaceView_13, i2);
        } else {
            ByteBufferWriter.write(slice(OplusGLSurfaceView_13, i2 + OplusGLSurfaceView_13), outputStream);
        }
    }

    @Override // com.google.protobuf.ByteString
    void writeTo(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        byte[] byteArray;
        int iArrayOffset;
        int length;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            iArrayOffset = this.buffer.arrayOffset() + this.buffer.position();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            iArrayOffset = 0;
            length = byteArray.length;
        }
        return new String(byteArray, iArrayOffset, length, charset);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    protected int partialIsValidUtf8(int OplusGLSurfaceView_13, int i2, int i3) {
        return Utf8.partialIsValidUtf8(OplusGLSurfaceView_13, this.buffer, i2, i3 + i2);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    protected int partialHash(int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = OplusGLSurfaceView_13;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + this.buffer.get(i5);
        }
        return i4;
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new InputStream() { // from class: com.google.protobuf.NioByteString.1
            private final ByteBuffer buf;

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            {
                this.buf = NioByteString.this.buffer.slice();
            }

            @Override // java.io.InputStream
            public void mark(int OplusGLSurfaceView_13) {
                this.buf.mark();
            }

            @Override // java.io.InputStream
            public void reset() throws IOException {
                try {
                    this.buf.reset();
                } catch (InvalidMarkException COUIBaseListPopupWindow_8) {
                    throw new IOException(COUIBaseListPopupWindow_8);
                }
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                return this.buf.remaining();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (this.buf.hasRemaining()) {
                    return this.buf.get() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int iMin = Math.min(i2, this.buf.remaining());
                this.buf.get(bArr, OplusGLSurfaceView_13, iMin);
                return iMin;
            }
        };
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    private ByteBuffer slice(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < this.buffer.position() || i2 > this.buffer.limit() || OplusGLSurfaceView_13 > i2) {
            throw new IllegalArgumentException(String.format("Invalid indices [%IntrinsicsJvm.kt_5, %IntrinsicsJvm.kt_5]", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2)));
        }
        ByteBuffer byteBufferSlice = this.buffer.slice();
        byteBufferSlice.position(OplusGLSurfaceView_13 - this.buffer.position());
        byteBufferSlice.limit(i2 - this.buffer.position());
        return byteBufferSlice;
    }
}
