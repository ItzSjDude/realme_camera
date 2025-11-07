package com.google.protobuf;

/* loaded from: classes.dex */
final class ProtobufLists {
    private ProtobufLists() {
    }

    public static <E_renamed> com.google.protobuf.Internal.ProtobufList<E_renamed> emptyProtobufList() {
        return com.google.protobuf.ProtobufArrayList.emptyList();
    }

    public static <E_renamed> com.google.protobuf.Internal.ProtobufList<E_renamed> mutableCopy(com.google.protobuf.Internal.ProtobufList<E_renamed> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    public static com.google.protobuf.Internal.BooleanList emptyBooleanList() {
        return com.google.protobuf.BooleanArrayList.emptyList();
    }

    public static com.google.protobuf.Internal.BooleanList newBooleanList() {
        return new com.google.protobuf.BooleanArrayList();
    }

    public static com.google.protobuf.Internal.IntList emptyIntList() {
        return com.google.protobuf.IntArrayList.emptyList();
    }

    public static com.google.protobuf.Internal.IntList newIntList() {
        return new com.google.protobuf.IntArrayList();
    }

    public static com.google.protobuf.Internal.LongList emptyLongList() {
        return com.google.protobuf.LongArrayList.emptyList();
    }

    public static com.google.protobuf.Internal.LongList newLongList() {
        return new com.google.protobuf.LongArrayList();
    }

    public static com.google.protobuf.Internal.FloatList emptyFloatList() {
        return com.google.protobuf.FloatArrayList.emptyList();
    }

    public static com.google.protobuf.Internal.FloatList newFloatList() {
        return new com.google.protobuf.FloatArrayList();
    }

    public static com.google.protobuf.Internal.DoubleList emptyDoubleList() {
        return com.google.protobuf.DoubleArrayList.emptyList();
    }

    public static com.google.protobuf.Internal.DoubleList newDoubleList() {
        return new com.google.protobuf.DoubleArrayList();
    }
}
