package com.google.android.apps.gsa.search.shared.service.proto;

@com.google.protobuf.ProtoMessage(checkInitialized = {}, messageSetWireFormat = false, protoSyntax = com.google.protobuf.ProtoSyntax.PROTO2)
/* loaded from: classes.dex */
public final class LensServiceClientEventData extends com.google.protobuf.GeneratedMessageLite<com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData, com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.Builder> implements com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventDataOrBuilder {
    private static final com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData DEFAULT_INSTANCE = new com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData();
    private static volatile com.google.protobuf.Parser<com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData> PARSER = null;
    public static final int TARGET_SERVICE_API_VERSION_FIELD_NUMBER = 1;

    @com.google.protobuf.ProtoPresenceBits(id_renamed = 0)
    private int bitField0_;

    @com.google.protobuf.ProtoField(fieldNumber = 1, isRequired = false, type = com.google.protobuf.FieldType.INT32)
    @com.google.protobuf.ProtoPresenceCheckedField(mask = 1, presenceBitsId = 0)
    private int targetServiceApiVersion_;

    private LensServiceClientEventData() {
    }

    @Override // com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventDataOrBuilder
    public boolean hasTargetServiceApiVersion() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventDataOrBuilder
    public int getTargetServiceApiVersion() {
        return this.targetServiceApiVersion_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetServiceApiVersion(int i_renamed) {
        this.bitField0_ |= 1;
        this.targetServiceApiVersion_ = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetServiceApiVersion() {
        this.bitField0_ &= -2;
        this.targetServiceApiVersion_ = 0;
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.Builder newBuilder(com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData lensServiceClientEventData) {
        return DEFAULT_INSTANCE.createBuilder(lensServiceClientEventData);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData, com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.Builder> implements com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventDataOrBuilder {
        private Builder() {
            super(com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.DEFAULT_INSTANCE);
        }

        @Override // com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventDataOrBuilder
        public boolean hasTargetServiceApiVersion() {
            return ((com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) this.instance).hasTargetServiceApiVersion();
        }

        @Override // com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventDataOrBuilder
        public int getTargetServiceApiVersion() {
            return ((com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) this.instance).getTargetServiceApiVersion();
        }

        public com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.Builder setTargetServiceApiVersion(int i_renamed) {
            copyOnWrite();
            ((com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) this.instance).setTargetServiceApiVersion(i_renamed);
            return this;
        }

        public com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.Builder clearTargetServiceApiVersion() {
            copyOnWrite();
            ((com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData) this.instance).clearTargetServiceApiVersion();
            return this;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final java.lang.Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke methodToInvoke, java.lang.Object obj, java.lang.Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData();
            case NEW_BUILDER:
                return new com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.Builder();
            case BUILD_MESSAGE_INFO:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\u0004\u0000", new java.lang.Object[]{"bitField0_", "targetServiceApiVersion_"});
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                com.google.protobuf.Parser<com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    }
                }
                return defaultInstanceBasedParser;
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            default:
                throw new java.lang.UnsupportedOperationException();
        }
    }

    static {
        com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData.class, DEFAULT_INSTANCE);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.android.apps.gsa.search.shared.service.proto.LensServiceClientEventData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
