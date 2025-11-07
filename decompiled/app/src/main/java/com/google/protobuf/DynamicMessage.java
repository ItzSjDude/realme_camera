package com.google.protobuf;

/* loaded from: classes.dex */
public final class DynamicMessage extends com.google.protobuf.AbstractMessage {
    private final com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fields;
    private int memoizedSize = -1;
    private final com.google.protobuf.Descriptors.FieldDescriptor[] oneofCases;
    private final com.google.protobuf.Descriptors.Descriptor type;
    private final com.google.protobuf.UnknownFieldSet unknownFields;

    DynamicMessage(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fieldSet, com.google.protobuf.Descriptors.FieldDescriptor[] fieldDescriptorArr, com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        this.type = descriptor;
        this.fields = fieldSet;
        this.oneofCases = fieldDescriptorArr;
        this.unknownFields = unknownFieldSet;
    }

    public static com.google.protobuf.DynamicMessage getDefaultInstance(com.google.protobuf.Descriptors.Descriptor descriptor) {
        return new com.google.protobuf.DynamicMessage(descriptor, com.google.protobuf.FieldSet.emptySet(), new com.google.protobuf.Descriptors.FieldDescriptor[descriptor.toProto().getOneofDeclCount()], com.google.protobuf.UnknownFieldSet.getDefaultInstance());
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return newBuilder(descriptor).mergeFrom(codedInputStream).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistry extensionRegistry) throws java.io.IOException {
        return newBuilder(descriptor).mergeFrom(codedInputStream, (com.google.protobuf.ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return newBuilder(descriptor).mergeFrom(byteString).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistry extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return newBuilder(descriptor).mergeFrom(byteString, (com.google.protobuf.ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return newBuilder(descriptor).mergeFrom(bArr).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, byte[] bArr, com.google.protobuf.ExtensionRegistry extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return newBuilder(descriptor).mergeFrom(bArr, (com.google.protobuf.ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, java.io.InputStream inputStream) throws java.io.IOException {
        return newBuilder(descriptor).mergeFrom(inputStream).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage parseFrom(com.google.protobuf.Descriptors.Descriptor descriptor, java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistry extensionRegistry) throws java.io.IOException {
        return newBuilder(descriptor).mergeFrom(inputStream, (com.google.protobuf.ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static com.google.protobuf.DynamicMessage.Builder newBuilder(com.google.protobuf.Descriptors.Descriptor descriptor) {
        return new com.google.protobuf.DynamicMessage.Builder(descriptor);
    }

    public static com.google.protobuf.DynamicMessage.Builder newBuilder(com.google.protobuf.Message message) {
        return new com.google.protobuf.DynamicMessage.Builder(message.getDescriptorForType()).mergeFrom(message);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
        return this.fields.getAllFields();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
        verifyOneofContainingType(oneofDescriptor);
        return this.oneofCases[oneofDescriptor.getIndex()] != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
        verifyOneofContainingType(oneofDescriptor);
        return this.oneofCases[oneofDescriptor.getIndex()];
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        verifyContainingType(fieldDescriptor);
        return this.fields.hasField(fieldDescriptor);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        verifyContainingType(fieldDescriptor);
        java.lang.Object field = this.fields.getField(fieldDescriptor);
        if (field != null) {
            return field;
        }
        if (fieldDescriptor.isRepeated()) {
            return java.util.Collections.emptyList();
        }
        if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            return getDefaultInstance(fieldDescriptor.getMessageType());
        }
        return fieldDescriptor.getDefaultValue();
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        verifyContainingType(fieldDescriptor);
        return this.fields.getRepeatedFieldCount(fieldDescriptor);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
        verifyContainingType(fieldDescriptor);
        return this.fields.getRepeatedField(fieldDescriptor, i_renamed);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    static boolean isInitialized(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fieldSet) {
        for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : descriptor.getFields()) {
            if (fieldDescriptor.isRequired() && !fieldSet.hasField(fieldDescriptor)) {
                return false;
            }
        }
        return fieldSet.isInitialized();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        if (this.type.getOptions().getMessageSetWireFormat()) {
            this.fields.writeMessageSetTo(codedOutputStream);
            this.unknownFields.writeAsMessageSetTo(codedOutputStream);
        } else {
            this.fields.writeTo(codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int serializedSize;
        int serializedSize2;
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        if (this.type.getOptions().getMessageSetWireFormat()) {
            serializedSize = this.fields.getMessageSetSerializedSize();
            serializedSize2 = this.unknownFields.getSerializedSizeAsMessageSet();
        } else {
            serializedSize = this.fields.getSerializedSize();
            serializedSize2 = this.unknownFields.getSerializedSize();
        }
        int i2 = serializedSize + serializedSize2;
        this.memoizedSize = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.DynamicMessage.Builder newBuilderForType() {
        return new com.google.protobuf.DynamicMessage.Builder(this.type);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.DynamicMessage.Builder toBuilder() {
        return newBuilderForType().mergeFrom((com.google.protobuf.Message) this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.DynamicMessage> getParserForType() {
        return new com.google.protobuf.AbstractParser<com.google.protobuf.DynamicMessage>() { // from class: com.google.protobuf.DynamicMessage.1
            @Override // com.google.protobuf.Parser
            public com.google.protobuf.DynamicMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                com.google.protobuf.DynamicMessage.Builder builderNewBuilder = com.google.protobuf.DynamicMessage.newBuilder(com.google.protobuf.DynamicMessage.this.type);
                try {
                    builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return builderNewBuilder.buildPartial();
                } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                    throw e_renamed.setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (java.io.IOException e2) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(builderNewBuilder.buildPartial());
                }
            }
        };
    }

    private void verifyContainingType(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.getContainingType() != this.type) {
            throw new java.lang.IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    private void verifyOneofContainingType(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
        if (oneofDescriptor.getContainingType() != this.type) {
            throw new java.lang.IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }

    public static final class Builder extends com.google.protobuf.AbstractMessage.Builder<com.google.protobuf.DynamicMessage.Builder> {
        private com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fields;
        private final com.google.protobuf.Descriptors.FieldDescriptor[] oneofCases;
        private final com.google.protobuf.Descriptors.Descriptor type;
        private com.google.protobuf.UnknownFieldSet unknownFields;

        private Builder(com.google.protobuf.Descriptors.Descriptor descriptor) {
            this.type = descriptor;
            this.fields = com.google.protobuf.FieldSet.newFieldSet();
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
            this.oneofCases = new com.google.protobuf.Descriptors.FieldDescriptor[descriptor.toProto().getOneofDeclCount()];
            if (descriptor.getOptions().getMapEntry()) {
                populateMapEntry();
            }
        }

        private void populateMapEntry() {
            for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : this.type.getFields()) {
                if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    this.fields.setField(fieldDescriptor, com.google.protobuf.DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()));
                } else {
                    this.fields.setField(fieldDescriptor, fieldDescriptor.getDefaultValue());
                }
            }
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder clear() {
            if (this.fields.isImmutable()) {
                this.fields = com.google.protobuf.FieldSet.newFieldSet();
            } else {
                this.fields.clear();
            }
            if (this.type.getOptions().getMapEntry()) {
                populateMapEntry();
            }
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.DynamicMessage) {
                com.google.protobuf.DynamicMessage dynamicMessage = (com.google.protobuf.DynamicMessage) message;
                if (dynamicMessage.type != this.type) {
                    throw new java.lang.IllegalArgumentException("mergeFrom(Message) can only merge messages of_renamed the same type.");
                }
                ensureIsMutable();
                this.fields.mergeFrom(dynamicMessage.fields);
                mergeUnknownFields(dynamicMessage.unknownFields);
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
                    if (i_renamed >= fieldDescriptorArr.length) {
                        return this;
                    }
                    if (fieldDescriptorArr[i_renamed] == null) {
                        fieldDescriptorArr[i_renamed] = dynamicMessage.oneofCases[i_renamed];
                    } else if (dynamicMessage.oneofCases[i_renamed] != null && this.oneofCases[i_renamed] != dynamicMessage.oneofCases[i_renamed]) {
                        this.fields.clearField(this.oneofCases[i_renamed]);
                        this.oneofCases[i_renamed] = dynamicMessage.oneofCases[i_renamed];
                    }
                    i_renamed++;
                }
            } else {
                return (com.google.protobuf.DynamicMessage.Builder) super.mergeFrom(message);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage build() {
            if (!isInitialized()) {
                com.google.protobuf.Descriptors.Descriptor descriptor = this.type;
                com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fieldSet = this.fields;
                com.google.protobuf.Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
                throw newUninitializedMessageException((com.google.protobuf.Message) new com.google.protobuf.DynamicMessage(descriptor, fieldSet, (com.google.protobuf.Descriptors.FieldDescriptor[]) java.util.Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.unknownFields));
            }
            return buildPartial();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.DynamicMessage buildParsed() throws com.google.protobuf.InvalidProtocolBufferException {
            if (!isInitialized()) {
                com.google.protobuf.Descriptors.Descriptor descriptor = this.type;
                com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fieldSet = this.fields;
                com.google.protobuf.Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
                throw newUninitializedMessageException((com.google.protobuf.Message) new com.google.protobuf.DynamicMessage(descriptor, fieldSet, (com.google.protobuf.Descriptors.FieldDescriptor[]) java.util.Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.unknownFields)).asInvalidProtocolBufferException();
            }
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage buildPartial() {
            this.fields.makeImmutable();
            com.google.protobuf.Descriptors.Descriptor descriptor = this.type;
            com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fieldSet = this.fields;
            com.google.protobuf.Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
            return new com.google.protobuf.DynamicMessage(descriptor, fieldSet, (com.google.protobuf.Descriptors.FieldDescriptor[]) java.util.Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.DynamicMessage.Builder mo23clone() {
            com.google.protobuf.DynamicMessage.Builder builder = new com.google.protobuf.DynamicMessage.Builder(this.type);
            builder.fields.mergeFrom(this.fields);
            builder.mergeUnknownFields(this.unknownFields);
            com.google.protobuf.Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
            java.lang.System.arraycopy(fieldDescriptorArr, 0, builder.oneofCases, 0, fieldDescriptorArr.length);
            return builder;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return com.google.protobuf.DynamicMessage.isInitialized(this.type, this.fields);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return this.type;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.DynamicMessage getDefaultInstanceForType() {
            return com.google.protobuf.DynamicMessage.getDefaultInstance(this.type);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
            return this.fields.getAllFields();
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder newBuilderForField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            if (fieldDescriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                throw new java.lang.IllegalArgumentException("newBuilderForField is_renamed only valid for fields with message type.");
            }
            return new com.google.protobuf.DynamicMessage.Builder(fieldDescriptor.getMessageType());
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            verifyOneofContainingType(oneofDescriptor);
            return this.oneofCases[oneofDescriptor.getIndex()] != null;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            verifyOneofContainingType(oneofDescriptor);
            return this.oneofCases[oneofDescriptor.getIndex()];
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            verifyOneofContainingType(oneofDescriptor);
            com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor = this.oneofCases[oneofDescriptor.getIndex()];
            if (fieldDescriptor != null) {
                clearField(fieldDescriptor);
            }
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            return this.fields.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            java.lang.Object field = this.fields.getField(fieldDescriptor);
            if (field != null) {
                return field;
            }
            if (fieldDescriptor.isRepeated()) {
                return java.util.Collections.emptyList();
            }
            if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return com.google.protobuf.DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType());
            }
            return fieldDescriptor.getDefaultValue();
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            if (fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM) {
                ensureEnumValueDescriptor(fieldDescriptor, obj);
            }
            com.google.protobuf.Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
            if (containingOneof != null) {
                int index = containingOneof.getIndex();
                com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor2 = this.oneofCases[index];
                if (fieldDescriptor2 != null && fieldDescriptor2 != fieldDescriptor) {
                    this.fields.clearField(fieldDescriptor2);
                }
                this.oneofCases[index] = fieldDescriptor;
            } else if (fieldDescriptor.getFile().getSyntax() == com.google.protobuf.Descriptors.FileDescriptor.Syntax.PROTO3 && !fieldDescriptor.isRepeated() && fieldDescriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE && obj.equals(fieldDescriptor.getDefaultValue())) {
                this.fields.clearField(fieldDescriptor);
                return this;
            }
            this.fields.setField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            com.google.protobuf.Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
            if (containingOneof != null) {
                int index = containingOneof.getIndex();
                com.google.protobuf.Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
                if (fieldDescriptorArr[index] == fieldDescriptor) {
                    fieldDescriptorArr[index] = null;
                }
            }
            this.fields.clearField(fieldDescriptor);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            return this.fields.getRepeatedFieldCount(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            verifyContainingType(fieldDescriptor);
            return this.fields.getRepeatedField(fieldDescriptor, i_renamed);
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            this.fields.setRepeatedField(fieldDescriptor, i_renamed, obj);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            this.fields.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            this.unknownFields = unknownFieldSet;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.DynamicMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build();
            return this;
        }

        private void verifyContainingType(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.type) {
                throw new java.lang.IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void verifyOneofContainingType(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            if (oneofDescriptor.getContainingType() != this.type) {
                throw new java.lang.IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        private void ensureSingularEnumValueDescriptor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            com.google.protobuf.Internal.checkNotNull(obj);
            if (!(obj instanceof com.google.protobuf.Descriptors.EnumValueDescriptor)) {
                throw new java.lang.IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }

        private void ensureEnumValueDescriptor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            if (fieldDescriptor.isRepeated()) {
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    ensureSingularEnumValueDescriptor(fieldDescriptor, it.next());
                }
                return;
            }
            ensureSingularEnumValueDescriptor(fieldDescriptor, obj);
        }

        private void ensureIsMutable() {
            if (this.fields.isImmutable()) {
                this.fields = this.fields.m24clone();
            }
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            throw new java.lang.UnsupportedOperationException("getFieldBuilder() called on_renamed a_renamed dynamic message type.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getRepeatedFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed dynamic message type.");
        }
    }
}
