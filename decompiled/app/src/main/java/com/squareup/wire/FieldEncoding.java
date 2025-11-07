package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes2.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);

    final int value;

    FieldEncoding(int OplusGLSurfaceView_13) {
        this.value = OplusGLSurfaceView_13;
    }

    static FieldEncoding get(int OplusGLSurfaceView_13) throws IOException {
        if (OplusGLSurfaceView_13 == 0) {
            return VARINT;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return FIXED64;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return LENGTH_DELIMITED;
        }
        if (OplusGLSurfaceView_13 == 5) {
            return FIXED32;
        }
        throw new ProtocolException("Unexpected FieldEncoding: " + OplusGLSurfaceView_13);
    }

    /* renamed from: com.squareup.wire.FieldEncoding$1 */
    static /* synthetic */ class C38321 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$FieldEncoding = new int[FieldEncoding.values().length];

        static {
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int OplusGLSurfaceView_13 = C38321.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            return ProtoAdapter.UINT64;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return ProtoAdapter.FIXED32;
        }
        if (OplusGLSurfaceView_13 == 3) {
            return ProtoAdapter.FIXED64;
        }
        if (OplusGLSurfaceView_13 == 4) {
            return ProtoAdapter.BYTES;
        }
        throw new AssertionError();
    }
}
