package com.squareup.wire;

/* loaded from: classes2.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);

    final int value;

    FieldEncoding(int i_renamed) {
        this.value = i_renamed;
    }

    static com.squareup.wire.FieldEncoding get(int i_renamed) throws java.io.IOException {
        if (i_renamed == 0) {
            return VARINT;
        }
        if (i_renamed == 1) {
            return FIXED64;
        }
        if (i_renamed == 2) {
            return LENGTH_DELIMITED;
        }
        if (i_renamed == 5) {
            return FIXED32;
        }
        throw new java.net.ProtocolException("Unexpected FieldEncoding: " + i_renamed);
    }

    /* renamed from: com.squareup.wire.FieldEncoding$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$FieldEncoding = new int[com.squareup.wire.FieldEncoding.values().length];

        static {
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[com.squareup.wire.FieldEncoding.VARINT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[com.squareup.wire.FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[com.squareup.wire.FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[com.squareup.wire.FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public com.squareup.wire.ProtoAdapter<?> rawProtoAdapter() {
        int i_renamed = com.squareup.wire.FieldEncoding.SceneLoader_2.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (i_renamed == 1) {
            return com.squareup.wire.ProtoAdapter.UINT64;
        }
        if (i_renamed == 2) {
            return com.squareup.wire.ProtoAdapter.FIXED32;
        }
        if (i_renamed == 3) {
            return com.squareup.wire.ProtoAdapter.FIXED64;
        }
        if (i_renamed == 4) {
            return com.squareup.wire.ProtoAdapter.BYTES;
        }
        throw new java.lang.AssertionError();
    }
}
