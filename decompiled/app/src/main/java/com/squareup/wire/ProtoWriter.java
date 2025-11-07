package com.squareup.wire;

/* loaded from: classes2.dex */
public final class ProtoWriter {
    private final okio.BufferedSink sink;

    static int decodeZigZag32(int i_renamed) {
        return (-(i_renamed & 1)) ^ (i_renamed >>> 1);
    }

    static long decodeZigZag64(long j_renamed) {
        return (-(j_renamed & 1)) ^ (j_renamed >>> 1);
    }

    static int encodeZigZag32(int i_renamed) {
        return (i_renamed >> 31) ^ (i_renamed << 1);
    }

    static long encodeZigZag64(long j_renamed) {
        return (j_renamed >> 63) ^ (j_renamed << 1);
    }

    static int varint32Size(int i_renamed) {
        if ((i_renamed & (-128)) == 0) {
            return 1;
        }
        if ((i_renamed & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i_renamed) == 0) {
            return 3;
        }
        return (i_renamed & (-268435456)) == 0 ? 4 : 5;
    }

    static int varint64Size(long j_renamed) {
        if (((-128) & j_renamed) == 0) {
            return 1;
        }
        if (((-16384) & j_renamed) == 0) {
            return 2;
        }
        if (((-2097152) & j_renamed) == 0) {
            return 3;
        }
        if (((-268435456) & j_renamed) == 0) {
            return 4;
        }
        if (((-34359738368L) & j_renamed) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j_renamed) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j_renamed) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j_renamed) == 0) {
            return 8;
        }
        return (j_renamed & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private static int makeTag(int i_renamed, com.squareup.wire.FieldEncoding fieldEncoding) {
        return (i_renamed << 3) | fieldEncoding.value;
    }

    static int tagSize(int i_renamed) {
        return varint32Size(makeTag(i_renamed, com.squareup.wire.FieldEncoding.VARINT));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:6:0x0010  */
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

    static int int32Size(int i_renamed) {
        if (i_renamed >= 0) {
            return varint32Size(i_renamed);
        }
        return 10;
    }

    public ProtoWriter(okio.BufferedSink bufferedSink) {
        this.sink = bufferedSink;
    }

    public void writeBytes(okio.ByteString byteString) throws java.io.IOException {
        this.sink.write(byteString);
    }

    public void writeString(java.lang.String str) throws java.io.IOException {
        this.sink.writeUtf8(str);
    }

    public void writeTag(int i_renamed, com.squareup.wire.FieldEncoding fieldEncoding) throws java.io.IOException {
        writeVarint32(makeTag(i_renamed, fieldEncoding));
    }

    void writeSignedVarint32(int i_renamed) throws java.io.IOException {
        if (i_renamed >= 0) {
            writeVarint32(i_renamed);
        } else {
            writeVarint64(i_renamed);
        }
    }

    public void writeVarint32(int i_renamed) throws java.io.IOException {
        while ((i_renamed & (-128)) != 0) {
            this.sink.writeByte((i_renamed & 127) | 128);
            i_renamed >>>= 7;
        }
        this.sink.writeByte(i_renamed);
    }

    public void writeVarint64(long j_renamed) throws java.io.IOException {
        while (((-128) & j_renamed) != 0) {
            this.sink.writeByte((((int) j_renamed) & 127) | 128);
            j_renamed >>>= 7;
        }
        this.sink.writeByte((int) j_renamed);
    }

    public void writeFixed32(int i_renamed) throws java.io.IOException {
        this.sink.writeIntLe(i_renamed);
    }

    public void writeFixed64(long j_renamed) throws java.io.IOException {
        this.sink.writeLongLe(j_renamed);
    }
}
