package com.google.protobuf;

/* loaded from: classes.dex */
public final class ListValue extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.ListValueOrBuilder {
    private static final com.google.protobuf.ListValue DEFAULT_INSTANCE = new com.google.protobuf.ListValue();
    private static final com.google.protobuf.Parser<com.google.protobuf.ListValue> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.ListValue>() { // from class: com.google.protobuf.ListValue.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.ListValue parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.ListValue(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int VALUES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private java.util.List<com.google.protobuf.Value> values_;

    private ListValue(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private ListValue() {
        this.memoizedIsInitialized = (byte) -1;
        this.values_ = java.util.Collections.emptyList();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.ListValue();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ListValue(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw new java.lang.NullPointerException();
        }
        com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
        boolean z_renamed = false;
        boolean z2 = false;
        while (!z_renamed) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if (!(z2 & true)) {
                                    this.values_ = new java.util.ArrayList();
                                    z2 |= true;
                                }
                                this.values_.add(codedInputStream.readMessage(com.google.protobuf.Value.parser(), extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z_renamed = true;
                    } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                        throw e_renamed.setUnfinishedMessage(this);
                    }
                } catch (java.io.IOException e2) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                if (z2 & true) {
                    this.values_ = java.util.Collections.unmodifiableList(this.values_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.ListValue.class, com.google.protobuf.ListValue.Builder.class);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public java.util.List<com.google.protobuf.Value> getValuesList() {
        return this.values_;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public java.util.List<? extends com.google.protobuf.ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public int getValuesCount() {
        return this.values_.size();
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public com.google.protobuf.Value getValues(int i_renamed) {
        return this.values_.get(i_renamed);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public com.google.protobuf.ValueOrBuilder getValuesOrBuilder(int i_renamed) {
        return this.values_.get(i_renamed);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        for (int i_renamed = 0; i_renamed < this.values_.size(); i_renamed++) {
            codedOutputStream.writeMessage(1, this.values_.get(i_renamed));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.values_.size(); i2++) {
            iComputeMessageSize += com.google.protobuf.CodedOutputStream.computeMessageSize(1, this.values_.get(i2));
        }
        int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.ListValue)) {
            return super.equals(obj);
        }
        com.google.protobuf.ListValue listValue = (com.google.protobuf.ListValue) obj;
        return getValuesList().equals(listValue.getValuesList()) && this.unknownFields.equals(listValue.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = 779 + getDescriptor().hashCode();
        if (getValuesCount() > 0) {
            iHashCode = (((iHashCode * 37) + 1) * 53) + getValuesList().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.ListValue parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.ListValue parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.ListValue parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.ListValue parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.ListValue parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.ListValue parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.ListValue parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.ListValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.ListValue parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.ListValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.ListValue parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.ListValue) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.ListValue parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.ListValue) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.ListValue parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.ListValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.ListValue parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.ListValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.ListValue.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.ListValue.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.ListValue.Builder newBuilder(com.google.protobuf.ListValue listValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(listValue);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.ListValue.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.ListValue.Builder() : new com.google.protobuf.ListValue.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.ListValue.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.ListValue.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.ListValue.Builder> implements com.google.protobuf.ListValueOrBuilder {
        private int bitField0_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> valuesBuilder_;
        private java.util.List<com.google.protobuf.Value> values_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_ListValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.ListValue.class, com.google.protobuf.ListValue.Builder.class);
        }

        private Builder() {
            this.values_ = java.util.Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.values_ = java.util.Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                getValuesFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue.Builder clear() {
            super.clear();
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.values_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_ListValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.ListValue getDefaultInstanceForType() {
            return com.google.protobuf.ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue build() {
            com.google.protobuf.ListValue listValueBuildPartial = buildPartial();
            if (listValueBuildPartial.isInitialized()) {
                return listValueBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) listValueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue buildPartial() {
            com.google.protobuf.ListValue listValue = new com.google.protobuf.ListValue(this);
            int i_renamed = this.bitField0_;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i_renamed & 1) != 0) {
                    this.values_ = java.util.Collections.unmodifiableList(this.values_);
                    this.bitField0_ &= -2;
                }
                listValue.values_ = this.values_;
            } else {
                listValue.values_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return listValue;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.ListValue.Builder mo23clone() {
            return (com.google.protobuf.ListValue.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.ListValue.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.ListValue.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.ListValue.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.ListValue.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.ListValue.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.ListValue.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.ListValue) {
                return mergeFrom((com.google.protobuf.ListValue) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.ListValue.Builder mergeFrom(com.google.protobuf.ListValue listValue) {
            if (listValue == com.google.protobuf.ListValue.getDefaultInstance()) {
                return this;
            }
            if (this.valuesBuilder_ == null) {
                if (!listValue.values_.isEmpty()) {
                    if (this.values_.isEmpty()) {
                        this.values_ = listValue.values_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureValuesIsMutable();
                        this.values_.addAll(listValue.values_);
                    }
                    onChanged();
                }
            } else if (!listValue.values_.isEmpty()) {
                if (!this.valuesBuilder_.isEmpty()) {
                    this.valuesBuilder_.addAllMessages(listValue.values_);
                } else {
                    this.valuesBuilder_.dispose();
                    this.valuesBuilder_ = null;
                    this.values_ = listValue.values_;
                    this.bitField0_ &= -2;
                    this.valuesBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getValuesFieldBuilder() : null;
                }
            }
            mergeUnknownFields(listValue.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.ListValue.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.ListValue.access$400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.ListValue r3 = (com.google.protobuf.ListValue) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                if (r3 == 0) goto L10
                r2.mergeFrom(r3)
            L10:
                return r2
            L11:
                r3 = move-exception
                goto L21
            L13:
                r3 = move-exception
                com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                com.google.protobuf.ListValue r4 = (com.google.protobuf.ListValue) r4     // Catch: java.lang.Throwable -> L11
                java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                throw r3     // Catch: java.lang.Throwable -> L1f
            L1f:
                r3 = move-exception
                r0 = r4
            L21:
                if (r0 == 0) goto L26
                r2.mergeFrom(r0)
            L26:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ListValue.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.ListValue$Builder");
        }

        private void ensureValuesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.values_ = new java.util.ArrayList(this.values_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public java.util.List<com.google.protobuf.Value> getValuesList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.values_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public int getValuesCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.values_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public com.google.protobuf.Value getValues(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.values_.get(i_renamed);
            }
            return (com.google.protobuf.Value) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.ListValue.Builder setValues(int i_renamed, com.google.protobuf.Value value) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i_renamed, value);
            } else {
                if (value == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureValuesIsMutable();
                this.values_.set(i_renamed, value);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder setValues(int i_renamed, com.google.protobuf.Value.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureValuesIsMutable();
                this.values_.set(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder addValues(com.google.protobuf.Value value) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(value);
            } else {
                if (value == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureValuesIsMutable();
                this.values_.add(value);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder addValues(int i_renamed, com.google.protobuf.Value value) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i_renamed, value);
            } else {
                if (value == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureValuesIsMutable();
                this.values_.add(i_renamed, value);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder addValues(com.google.protobuf.Value.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureValuesIsMutable();
                this.values_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder addValues(int i_renamed, com.google.protobuf.Value.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureValuesIsMutable();
                this.values_.add(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder addAllValues(java.lang.Iterable<? extends com.google.protobuf.Value> iterable) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureValuesIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.values_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder clearValues() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.values_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder removeValues(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureValuesIsMutable();
                this.values_.remove(i_renamed);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i_renamed);
            }
            return this;
        }

        public com.google.protobuf.Value.Builder getValuesBuilder(int i_renamed) {
            return (com.google.protobuf.Value.Builder) getValuesFieldBuilder().getBuilder(i_renamed);
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public com.google.protobuf.ValueOrBuilder getValuesOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.values_.get(i_renamed);
            }
            return (com.google.protobuf.ValueOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public java.util.List<? extends com.google.protobuf.ValueOrBuilder> getValuesOrBuilderList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> repeatedFieldBuilderV3 = this.valuesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return java.util.Collections.unmodifiableList(this.values_);
        }

        public com.google.protobuf.Value.Builder addValuesBuilder() {
            return (com.google.protobuf.Value.Builder) getValuesFieldBuilder().addBuilder(com.google.protobuf.Value.getDefaultInstance());
        }

        public com.google.protobuf.Value.Builder addValuesBuilder(int i_renamed) {
            return (com.google.protobuf.Value.Builder) getValuesFieldBuilder().addBuilder(i_renamed, com.google.protobuf.Value.getDefaultInstance());
        }

        public java.util.List<com.google.protobuf.Value.Builder> getValuesBuilderList() {
            return getValuesFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Value, com.google.protobuf.Value.Builder, com.google.protobuf.ValueOrBuilder> getValuesFieldBuilder() {
            if (this.valuesBuilder_ == null) {
                this.valuesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.values_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.values_ = null;
            }
            return this.valuesBuilder_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.ListValue.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.ListValue.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.ListValue.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.ListValue.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.ListValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.ListValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.ListValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
