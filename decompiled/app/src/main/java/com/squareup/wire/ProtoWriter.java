package com.squareup.wire;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class ProtoWriter {
    private final BufferedSink sink;

    static int decodeZigZag32(int OplusGLSurfaceView_13) {
        return (-(OplusGLSurfaceView_13 & 1)) ^ (OplusGLSurfaceView_13 >>> 1);
    }

    static long decodeZigZag64(long OplusGLSurfaceView_15) {
        return (-(OplusGLSurfaceView_15 & 1)) ^ (OplusGLSurfaceView_15 >>> 1);
    }

    static int encodeZigZag32(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 >> 31) ^ (OplusGLSurfaceView_13 << 1);
    }

    static long encodeZigZag64(long OplusGLSurfaceView_15) {
        return (OplusGLSurfaceView_15 >> 63) ^ (OplusGLSurfaceView_15 << 1);
    }

    static int varint32Size(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & (-128)) == 0) {
            return 1;
        }
        if ((OplusGLSurfaceView_13 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & OplusGLSurfaceView_13) == 0) {
            return 3;
        }
        return (OplusGLSurfaceView_13 & (-268435456)) == 0 ? 4 : 5;
    }

    static int varint64Size(long OplusGLSurfaceView_15) {
        if (((-128) & OplusGLSurfaceView_15) == 0) {
            return 1;
        }
        if (((-16384) & OplusGLSurfaceView_15) == 0) {
            return 2;
        }
        if (((-2097152) & OplusGLSurfaceView_15) == 0) {
            return 3;
        }
        if (((-268435456) & OplusGLSurfaceView_15) == 0) {
            return 4;
        }
        if (((-34359738368L) & OplusGLSurfaceView_15) == 0) {
            return 5;
        }
        if (((-4398046511104L) & OplusGLSurfaceView_15) == 0) {
            return 6;
        }
        if (((-562949953421312L) & OplusGLSurfaceView_15) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & OplusGLSurfaceView_15) == 0) {
            return 8;
        }
        return (OplusGLSurfaceView_15 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private static int makeTag(int OplusGLSurfaceView_13, FieldEncoding fieldEncoding) {
        return (OplusGLSurfaceView_13 << 3) | fieldEncoding.value;
    }

    static int tagSize(int OplusGLSurfaceView_13) {
        return varint32Size(makeTag(OplusGLSurfaceView_13, FieldEncoding.VARINT));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int utf8Length(java.lang.String r7) {
        /*
            int r0 = r7.length()
            r1 = 0
            r2 = r1
        L6:
            if (r1 >= r0) goto L46
            char r3 = r7.charAt(r1)
            r4 = 128(0x80, float:1.794E-43)
            if (r3 >= r4) goto L13
        L10:
            int r2 = r2 + 1
            goto L43
        L13:
            r4 = 2048(0x800, float:2.87E-42)
            if (r3 >= r4) goto L1a
            int r2 = r2 + 2
            goto L43
        L1a:
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r4) goto L41
            r4 = 57343(0xdfff, float:8.0355E-41)
            if (r3 <= r4) goto L25
            goto L41
        L25:
            r5 = 56319(0xdbff, float:7.892E-41)
            if (r3 > r5) goto L10
            int r3 = r1 + 1
            if (r3 >= r0) goto L10
            char r5 = r7.charAt(r3)
            r6 = 56320(0xdc00, float:7.8921E-41)
            if (r5 < r6) goto L10
            char r5 = r7.charAt(r3)
            if (r5 > r4) goto L10
            int r2 = r2 + 4
            r1 = r3
            goto L43
        L41:
            int r2 = r2 + 3
        L43:
            int r1 = r1 + 1
            goto L6
        L46:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.ProtoWriter.utf8Length(java.lang.String):int");
    }

    static int int32Size(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 0) {
            return varint32Size(OplusGLSurfaceView_13);
        }
        return 10;
    }

    public ProtoWriter(BufferedSink bufferedSink) {
        this.sink = bufferedSink;
    }

    public void writeBytes(ByteString byteString) throws IOException {
        this.sink.write(byteString);
    }

    public void writeString(String str) throws IOException {
        this.sink.writeUtf8(str);
    }

    public void writeTag(int OplusGLSurfaceView_13, FieldEncoding fieldEncoding) throws IOException {
        writeVarint32(makeTag(OplusGLSurfaceView_13, fieldEncoding));
    }

    void writeSignedVarint32(int OplusGLSurfaceView_13) throws IOException {
        if (OplusGLSurfaceView_13 >= 0) {
            writeVarint32(OplusGLSurfaceView_13);
        } else {
            writeVarint64(OplusGLSurfaceView_13);
        }
    }

    public void writeVarint32(int OplusGLSurfaceView_13) throws IOException {
        while ((OplusGLSurfaceView_13 & (-128)) != 0) {
            this.sink.writeByte((OplusGLSurfaceView_13 & 127) | 128);
            OplusGLSurfaceView_13 >>>= 7;
        }
        this.sink.writeByte(OplusGLSurfaceView_13);
    }

    public void writeVarint64(long OplusGLSurfaceView_15) throws IOException {
        while (((-128) & OplusGLSurfaceView_15) != 0) {
            this.sink.writeByte((((int) OplusGLSurfaceView_15) & 127) | 128);
            OplusGLSurfaceView_15 >>>= 7;
        }
        this.sink.writeByte((int) OplusGLSurfaceView_15);
    }

    public void writeFixed32(int OplusGLSurfaceView_13) throws IOException {
        this.sink.writeIntLe(OplusGLSurfaceView_13);
    }

    public void writeFixed64(long OplusGLSurfaceView_15) throws IOException {
        this.sink.writeLongLe(OplusGLSurfaceView_15);
    }
}
