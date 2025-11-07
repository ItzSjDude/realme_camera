package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class WireFormatNano {
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;
    static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final java.lang.String[] EMPTY_STRING_ARRAY = new java.lang.String[0];
    public static final byte[][] EMPTY_BYTES_ARRAY = new byte[0][];
    public static final byte[] EMPTY_BYTES = new byte[0];

    public static int getTagFieldNumber(int i_renamed) {
        return i_renamed >>> 3;
    }

    static int getTagWireType(int i_renamed) {
        return i_renamed & 7;
    }

    public static int makeTag(int i_renamed, int i2) {
        return (i_renamed << 3) | i2;
    }

    private WireFormatNano() {
    }

    public static boolean parseUnknownField(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano, int i_renamed) throws java.io.IOException {
        return codedInputByteBufferNano.skipField(i_renamed);
    }

    public static final int getRepeatedFieldArrayLength(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano, int i_renamed) throws java.io.IOException {
        int position = codedInputByteBufferNano.getPosition();
        codedInputByteBufferNano.skipField(i_renamed);
        int i2 = 1;
        while (codedInputByteBufferNano.readTag() == i_renamed) {
            codedInputByteBufferNano.skipField(i_renamed);
            i2++;
        }
        codedInputByteBufferNano.rewindToPositionAndTag(position, i_renamed);
        return i2;
    }
}
