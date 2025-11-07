package com.google.protobuf;

/* loaded from: classes.dex */
public enum NullValue implements com.google.protobuf.ProtocolMessageEnum {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);

    public static final int NULL_VALUE_VALUE = 0;
    private final int value;
    private static final com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.NullValue> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.NullValue>() { // from class: com.google.protobuf.NullValue.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public com.google.protobuf.NullValue findValueByNumber(int i_renamed) {
            return com.google.protobuf.NullValue.forNumber(i_renamed);
        }
    };
    private static final com.google.protobuf.NullValue[] VALUES = values();

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new java.lang.IllegalArgumentException("Can't_renamed get the number of_renamed an_renamed unknown enum value.");
        }
        return this.value;
    }

    @java.lang.Deprecated
    public static com.google.protobuf.NullValue valueOf(int i_renamed) {
        return forNumber(i_renamed);
    }

    public static com.google.protobuf.NullValue forNumber(int i_renamed) {
        if (i_renamed != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
        return com.google.protobuf.StructProto.getDescriptor().getEnumTypes().get(0);
    }

    public static com.google.protobuf.NullValue valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException("EnumValueDescriptor is_renamed not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    NullValue(int i_renamed) {
        this.value = i_renamed;
    }
}
