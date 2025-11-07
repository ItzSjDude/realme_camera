package com.google.protobuf;

/* loaded from: classes.dex */
public enum Syntax implements com.google.protobuf.ProtocolMessageEnum {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);

    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private final int value;
    private static final com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Syntax> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Syntax>() { // from class: com.google.protobuf.Syntax.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public com.google.protobuf.Syntax findValueByNumber(int i_renamed) {
            return com.google.protobuf.Syntax.forNumber(i_renamed);
        }
    };
    private static final com.google.protobuf.Syntax[] VALUES = values();

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new java.lang.IllegalArgumentException("Can't_renamed get the number of_renamed an_renamed unknown enum value.");
        }
        return this.value;
    }

    @java.lang.Deprecated
    public static com.google.protobuf.Syntax valueOf(int i_renamed) {
        return forNumber(i_renamed);
    }

    public static com.google.protobuf.Syntax forNumber(int i_renamed) {
        if (i_renamed == 0) {
            return SYNTAX_PROTO2;
        }
        if (i_renamed != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Syntax> internalGetValueMap() {
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
        return com.google.protobuf.TypeProto.getDescriptor().getEnumTypes().get(0);
    }

    public static com.google.protobuf.Syntax valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException("EnumValueDescriptor is_renamed not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    Syntax(int i_renamed) {
        this.value = i_renamed;
    }
}
