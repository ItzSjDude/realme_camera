package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    static final int TAG_FIELD_ENCODING_BITS = 3;
    private FieldEncoding nextFieldEncoding;
    private int recursionDepth;
    private final BufferedSource source;
    private long pos = 0;
    private long limit = Long.MAX_VALUE;
    private int state = 2;
    private int tag = -1;
    private long pushedLimit = -1;

    public ProtoReader(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public long beginMessage() throws IOException {
        if (this.state != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int OplusGLSurfaceView_13 = this.recursionDepth + 1;
        this.recursionDepth = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long OplusGLSurfaceView_15 = this.pushedLimit;
        this.pushedLimit = -1L;
        this.state = 6;
        return OplusGLSurfaceView_15;
    }

    public void endMessage(long OplusGLSurfaceView_15) throws IOException {
        if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int OplusGLSurfaceView_13 = this.recursionDepth - 1;
        this.recursionDepth = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 < 0 || this.pushedLimit != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.pos != this.limit && this.recursionDepth != 0) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        this.limit = OplusGLSurfaceView_15;
    }

    public int nextTag() throws IOException {
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 == 7) {
            this.state = 2;
            return this.tag;
        }
        if (OplusGLSurfaceView_13 != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.pos < this.limit && !this.source.exhausted()) {
            int iInternalReadVarint32 = internalReadVarint32();
            if (iInternalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            this.tag = iInternalReadVarint32 >> 3;
            int i2 = iInternalReadVarint32 & 7;
            if (i2 == 0) {
                this.nextFieldEncoding = FieldEncoding.VARINT;
                this.state = 0;
                return this.tag;
            }
            if (i2 == 1) {
                this.nextFieldEncoding = FieldEncoding.FIXED64;
                this.state = 1;
                return this.tag;
            }
            if (i2 == 2) {
                this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                this.state = 2;
                int iInternalReadVarint322 = internalReadVarint32();
                if (iInternalReadVarint322 < 0) {
                    throw new ProtocolException("Negative length: " + iInternalReadVarint322);
                }
                if (this.pushedLimit != -1) {
                    throw new IllegalStateException();
                }
                this.pushedLimit = this.limit;
                this.limit = this.pos + iInternalReadVarint322;
                if (this.limit > this.pushedLimit) {
                    throw new EOFException();
                }
                return this.tag;
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i2 == 5) {
                    this.nextFieldEncoding = FieldEncoding.FIXED32;
                    this.state = 5;
                    return this.tag;
                }
                throw new ProtocolException("Unexpected field encoding: " + i2);
            }
            skipGroup(this.tag);
        }
        return -1;
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public void skip() throws IOException {
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 == 0) {
            readVarint64();
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            readFixed64();
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            this.source.skip(beforeLengthDelimitedScalar());
        } else {
            if (OplusGLSurfaceView_13 == 5) {
                readFixed32();
                return;
            }
            throw new IllegalStateException("Unexpected call to skip()");
        }
    }

    private void skipGroup(int OplusGLSurfaceView_13) throws IOException {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int iInternalReadVarint32 = internalReadVarint32();
            if (iInternalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iInternalReadVarint32 >> 3;
            int i3 = iInternalReadVarint32 & 7;
            if (i3 == 0) {
                this.state = 0;
                readVarint64();
            } else if (i3 == 1) {
                this.state = 1;
                readFixed64();
            } else if (i3 == 2) {
                long jInternalReadVarint32 = internalReadVarint32();
                this.pos += jInternalReadVarint32;
                this.source.skip(jInternalReadVarint32);
            } else if (i3 == 3) {
                skipGroup(i2);
            } else if (i3 == 4) {
                if (i2 != OplusGLSurfaceView_13) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i3 == 5) {
                this.state = 5;
                readFixed32();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i3);
            }
        }
        throw new EOFException();
    }

    public ByteString readBytes() throws IOException {
        return this.source.readByteString(beforeLengthDelimitedScalar());
    }

    public String readString() throws IOException {
        return this.source.readUtf8(beforeLengthDelimitedScalar());
    }

    public int readVarint32() throws IOException {
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_13 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        int iInternalReadVarint32 = internalReadVarint32();
        afterPackableScalar(0);
        return iInternalReadVarint32;
    }

    private int internalReadVarint32() throws IOException {
        int OplusGLSurfaceView_13;
        this.pos++;
        byte b2 = this.source.readByte();
        if (b2 >= 0) {
            return b2;
        }
        int i2 = b2 & 127;
        this.pos++;
        byte b3 = this.source.readByte();
        if (b3 >= 0) {
            OplusGLSurfaceView_13 = b3 << 7;
        } else {
            i2 |= (b3 & 127) << 7;
            this.pos++;
            byte b4 = this.source.readByte();
            if (b4 >= 0) {
                OplusGLSurfaceView_13 = b4 << 14;
            } else {
                i2 |= (b4 & 127) << 14;
                this.pos++;
                byte b5 = this.source.readByte();
                if (b5 < 0) {
                    int i3 = i2 | ((b5 & 127) << 21);
                    this.pos++;
                    byte b6 = this.source.readByte();
                    int i4 = i3 | (b6 << 28);
                    if (b6 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.pos++;
                        if (this.source.readByte() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                OplusGLSurfaceView_13 = b5 << 21;
            }
        }
        return OplusGLSurfaceView_13 | i2;
    }

    public long readVarint64() throws IOException {
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_13 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        long OplusGLSurfaceView_15 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.pos++;
            OplusGLSurfaceView_15 |= (r1 & 127) << i2;
            if ((this.source.readByte() & 128) == 0) {
                afterPackableScalar(0);
                return OplusGLSurfaceView_15;
            }
        }
        throw new ProtocolException("WireInput encountered PlatformImplementations.kt_3 malformed varint");
    }

    public int readFixed32() throws IOException {
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 != 5 && OplusGLSurfaceView_13 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(4L);
        this.pos += 4;
        int intLe = this.source.readIntLe();
        afterPackableScalar(5);
        return intLe;
    }

    public long readFixed64() throws IOException {
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 != 1 && OplusGLSurfaceView_13 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(8L);
        this.pos += 8;
        long longLe = this.source.readLongLe();
        afterPackableScalar(1);
        return longLe;
    }

    private void afterPackableScalar(int OplusGLSurfaceView_13) throws IOException {
        if (this.state == OplusGLSurfaceView_13) {
            this.state = 6;
            return;
        }
        long OplusGLSurfaceView_15 = this.pos;
        long j2 = this.limit;
        if (OplusGLSurfaceView_15 > j2) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        if (OplusGLSurfaceView_15 == j2) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            this.state = 6;
            return;
        }
        this.state = 7;
    }

    private long beforeLengthDelimitedScalar() throws IOException {
        if (this.state != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
        }
        long OplusGLSurfaceView_15 = this.limit - this.pos;
        this.source.require(OplusGLSurfaceView_15);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1L;
        return OplusGLSurfaceView_15;
    }
}
