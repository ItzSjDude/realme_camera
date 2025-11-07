package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class GeneratedMessage extends com.google.protobuf.AbstractMessage implements java.io.Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected com.google.protobuf.UnknownFieldSet unknownFields;

    protected interface BuilderParent extends com.google.protobuf.AbstractMessage.BuilderParent {
    }

    public interface ExtendableMessageOrBuilder<MessageType extends com.google.protobuf.GeneratedMessage.ExtendableMessage> extends com.google.protobuf.MessageOrBuilder {
        @Override // com.google.protobuf.MessageOrBuilder
        com.google.protobuf.Message getDefaultInstanceForType();

        <Type> Type getExtension(com.google.protobuf.Extension<MessageType, Type> extension);

        <Type> Type getExtension(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension, int i_renamed);

        <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, int i_renamed);

        <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i_renamed);

        <Type> int getExtensionCount(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension);

        <Type> int getExtensionCount(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite);

        <Type> int getExtensionCount(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension);

        <Type> boolean hasExtension(com.google.protobuf.Extension<MessageType, Type> extension);

        <Type> boolean hasExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite);

        <Type> boolean hasExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension);
    }

    interface ExtensionDescriptorRetriever {
        com.google.protobuf.Descriptors.FieldDescriptor getDescriptor();
    }

    protected abstract com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable();

    protected void makeExtensionsImmutable() {
    }

    protected abstract com.google.protobuf.Message.Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderParent);

    protected GeneratedMessage() {
        this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
        this.unknownFields = builder.getUnknownFields();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<? extends com.google.protobuf.GeneratedMessage> getParserForType() {
        throw new java.lang.UnsupportedOperationException("This is_renamed supposed to be_renamed overridden by_renamed subclasses.");
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFieldsMutable(boolean r7) {
        /*
            r6 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            com.google.protobuf.GeneratedMessage$FieldAccessorTable r1 = r6.internalGetFieldAccessorTable()
            com.google.protobuf.Descriptors$Descriptor r1 = com.google.protobuf.GeneratedMessage.FieldAccessorTable.access$000(r1)
            java.util.List r1 = r1.getFields()
            r2 = 0
        L12:
            int r3 = r1.size()
            if (r2 >= r3) goto L70
            java.lang.Object r3 = r1.get(r2)
            com.google.protobuf.Descriptors$FieldDescriptor r3 = (com.google.protobuf.Descriptors.FieldDescriptor) r3
            com.google.protobuf.Descriptors$OneofDescriptor r4 = r3.getContainingOneof()
            if (r4 == 0) goto L37
            int r3 = r4.getFieldCount()
            int r3 = r3 + (-1)
            int r2 = r2 + r3
            boolean r3 = r6.hasOneof(r4)
            if (r3 != 0) goto L32
            goto L6d
        L32:
            com.google.protobuf.Descriptors$FieldDescriptor r3 = r6.getOneofFieldDescriptor(r4)
            goto L54
        L37:
            boolean r4 = r3.isRepeated()
            if (r4 == 0) goto L4d
            java.lang.Object r4 = r6.getField(r3)
            java.util.List r4 = (java.util.List) r4
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L6d
            r0.put(r3, r4)
            goto L6d
        L4d:
            boolean r4 = r6.hasField(r3)
            if (r4 != 0) goto L54
            goto L6d
        L54:
            if (r7 == 0) goto L66
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r4 = r3.getJavaType()
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r5 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.STRING
            if (r4 != r5) goto L66
            java.lang.Object r4 = r6.getFieldRaw(r3)
            r0.put(r3, r4)
            goto L6d
        L66:
            java.lang.Object r4 = r6.getField(r3)
            r0.put(r3, r4)
        L6d:
            int r2 = r2 + 1
            goto L12
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessage.getAllFieldsMutable(boolean):java.util.Map");
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !hasField(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.isRepeated()) {
                    java.util.Iterator it = ((java.util.List) getField(fieldDescriptor)).iterator();
                    while (it.hasNext()) {
                        if (!((com.google.protobuf.Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (hasField(fieldDescriptor) && !((com.google.protobuf.Message) getField(fieldDescriptor)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
        return java.util.Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFieldsRaw() {
        return java.util.Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
        return internalGetFieldAccessorTable().getOneof(oneofDescriptor).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
        return internalGetFieldAccessorTable().getOneof(oneofDescriptor).get(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).has(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).get(this);
    }

    java.lang.Object getFieldRaw(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRaw(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeated(this, i_renamed);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.UnknownFieldSet getUnknownFields() {
        throw new java.lang.UnsupportedOperationException("This is_renamed supposed to be_renamed overridden by_renamed subclasses.");
    }

    protected boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
        return builder.mergeFieldFrom(i_renamed, codedInputStream);
    }

    protected static <M_renamed extends com.google.protobuf.Message> M_renamed parseWithIOException(com.google.protobuf.Parser<M_renamed> parser, java.io.InputStream inputStream) throws java.io.IOException {
        try {
            return parser.parseFrom(inputStream);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.unwrapIOException();
        }
    }

    protected static <M_renamed extends com.google.protobuf.Message> M_renamed parseWithIOException(com.google.protobuf.Parser<M_renamed> parser, java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        try {
            return parser.parseFrom(inputStream, extensionRegistryLite);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.unwrapIOException();
        }
    }

    protected static <M_renamed extends com.google.protobuf.Message> M_renamed parseWithIOException(com.google.protobuf.Parser<M_renamed> parser, com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        try {
            return parser.parseFrom(codedInputStream);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.unwrapIOException();
        }
    }

    protected static <M_renamed extends com.google.protobuf.Message> M_renamed parseWithIOException(com.google.protobuf.Parser<M_renamed> parser, com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        try {
            return parser.parseFrom(codedInputStream, extensionRegistryLite);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.unwrapIOException();
        }
    }

    protected static <M_renamed extends com.google.protobuf.Message> M_renamed parseDelimitedWithIOException(com.google.protobuf.Parser<M_renamed> parser, java.io.InputStream inputStream) throws java.io.IOException {
        try {
            return parser.parseDelimitedFrom(inputStream);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.unwrapIOException();
        }
    }

    protected static <M_renamed extends com.google.protobuf.Message> M_renamed parseDelimitedWithIOException(com.google.protobuf.Parser<M_renamed> parser, java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        try {
            return parser.parseDelimitedFrom(inputStream, extensionRegistryLite);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.unwrapIOException();
        }
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        com.google.protobuf.MessageReflection.writeMessageTo(this, getAllFieldsRaw(), codedOutputStream, false);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        this.memoizedSize = com.google.protobuf.MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        return this.memoizedSize;
    }

    @Override // com.google.protobuf.AbstractMessage
    protected com.google.protobuf.Message.Builder newBuilderForType(final com.google.protobuf.AbstractMessage.BuilderParent builderParent) {
        return newBuilderForType(new com.google.protobuf.GeneratedMessage.BuilderParent() { // from class: com.google.protobuf.GeneratedMessage.1
            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                builderParent.markDirty();
            }
        });
    }

    public static abstract class Builder<BuilderType extends com.google.protobuf.GeneratedMessage.Builder<BuilderType>> extends com.google.protobuf.AbstractMessage.Builder<BuilderType> {
        private com.google.protobuf.GeneratedMessage.BuilderParent builderParent;
        private boolean isClean;
        private com.google.protobuf.GeneratedMessage.Builder<BuilderType>.BuilderParentImpl meAsParent;
        private com.google.protobuf.UnknownFieldSet unknownFields;

        protected abstract com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable();

        protected Builder() {
            this(null);
        }

        protected Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderParent) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
            this.builderParent = builderParent;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        void dispose() {
            this.builderParent = null;
        }

        protected void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        protected void markClean() {
            this.isClean = true;
        }

        protected boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo23clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return internalGetFieldAccessorTable().descriptor;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
            return java.util.Collections.unmodifiableMap(getAllFieldsMutable());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFieldsMutable() {
            java.util.TreeMap treeMap = new java.util.TreeMap();
            java.util.List<com.google.protobuf.Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
            int fieldCount = 0;
            while (fieldCount < fields.size()) {
                com.google.protobuf.Descriptors.FieldDescriptor oneofFieldDescriptor = fields.get(fieldCount);
                com.google.protobuf.Descriptors.OneofDescriptor containingOneof = oneofFieldDescriptor.getContainingOneof();
                if (containingOneof != null) {
                    fieldCount += containingOneof.getFieldCount() - 1;
                    if (hasOneof(containingOneof)) {
                        oneofFieldDescriptor = getOneofFieldDescriptor(containingOneof);
                        treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                    }
                } else if (oneofFieldDescriptor.isRepeated()) {
                    java.util.List list = (java.util.List) getField(oneofFieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(oneofFieldDescriptor, list);
                    }
                } else if (hasField(oneofFieldDescriptor)) {
                    treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                }
                fieldCount++;
            }
            return treeMap;
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder newBuilderForField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).newBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getRepeatedFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedBuilder(this, i_renamed);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return internalGetFieldAccessorTable().getOneof(oneofDescriptor).has(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return internalGetFieldAccessorTable().getOneof(oneofDescriptor).get(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).has(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            java.lang.Object obj = internalGetFieldAccessorTable().getField(fieldDescriptor).get(this);
            return fieldDescriptor.isRepeated() ? java.util.Collections.unmodifiableList((java.util.List) obj) : obj;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).set(this, obj);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            internalGetFieldAccessorTable().getOneof(oneofDescriptor).clear(this);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeated(this, i_renamed);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).setRepeated(this, i_renamed, obj);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).addRepeated(this, obj);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            this.unknownFields = unknownFieldSet;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().getFields()) {
                if (fieldDescriptor.isRequired() && !hasField(fieldDescriptor)) {
                    return false;
                }
                if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (fieldDescriptor.isRepeated()) {
                        java.util.Iterator it = ((java.util.List) getField(fieldDescriptor)).iterator();
                        while (it.hasNext()) {
                            if (!((com.google.protobuf.Message) it.next()).isInitialized()) {
                                return false;
                            }
                        }
                    } else if (hasField(fieldDescriptor) && !((com.google.protobuf.Message) getField(fieldDescriptor)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        protected boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
            return builder.mergeFieldFrom(i_renamed, codedInputStream);
        }

        private class BuilderParentImpl implements com.google.protobuf.GeneratedMessage.BuilderParent {
            private BuilderParentImpl() {
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                com.google.protobuf.GeneratedMessage.Builder.this.onChanged();
            }
        }

        protected com.google.protobuf.GeneratedMessage.BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new com.google.protobuf.GeneratedMessage.Builder.BuilderParentImpl();
            }
            return this.meAsParent;
        }

        protected final void onChanged() {
            com.google.protobuf.GeneratedMessage.BuilderParent builderParent;
            if (!this.isClean || (builderParent = this.builderParent) == null) {
                return;
            }
            builderParent.markDirty();
            this.isClean = false;
        }

        protected com.google.protobuf.MapField internalGetMapField(int i_renamed) {
            throw new java.lang.RuntimeException("No map fields found in_renamed " + getClass().getName());
        }

        protected com.google.protobuf.MapField internalGetMutableMapField(int i_renamed) {
            throw new java.lang.RuntimeException("No map fields found in_renamed " + getClass().getName());
        }
    }

    public static abstract class ExtendableMessage<MessageType extends com.google.protobuf.GeneratedMessage.ExtendableMessage> extends com.google.protobuf.GeneratedMessage implements com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder<MessageType> {
        private static final long serialVersionUID = 1;
        private final com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> extensions;

        protected ExtendableMessage() {
            this.extensions = com.google.protobuf.FieldSet.newFieldSet();
        }

        protected ExtendableMessage(com.google.protobuf.GeneratedMessage.ExtendableBuilder<MessageType, ?> extendableBuilder) {
            super(extendableBuilder);
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(com.google.protobuf.Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() == getDescriptorForType()) {
                return;
            }
            throw new java.lang.IllegalArgumentException("Extension is_renamed for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.getRepeatedFieldCount(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            com.google.protobuf.Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            java.lang.Object field = this.extensions.getField(descriptor);
            if (field == null) {
                if (descriptor.isRepeated()) {
                    return (Type) java.util.Collections.emptyList();
                }
                if (descriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return (Type) extensionCheckNotLite.getMessageDefaultInstance();
                }
                return (Type) extensionCheckNotLite.fromReflectionType(descriptor.getDefaultValue());
            }
            return (Type) extensionCheckNotLite.fromReflectionType(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, int i_renamed) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return (Type) extensionCheckNotLite.singularFromReflectionType(this.extensions.getRepeatedField(extensionCheckNotLite.getDescriptor(), i_renamed));
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return hasExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return hasExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension, int i_renamed) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i_renamed) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) generatedExtension, i_renamed);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
            return com.google.protobuf.MessageReflection.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), new com.google.protobuf.MessageReflection.ExtensionAdapter(this.extensions), i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        protected class ExtensionWriter {
            private final java.util.Iterator<java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object>> iter;
            private final boolean messageSetWireFormat;
            private java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> next;

            private ExtensionWriter(boolean z_renamed) {
                this.iter = com.google.protobuf.GeneratedMessage.ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z_renamed;
            }

            public void writeUntil(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
                while (true) {
                    java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> entry = this.next;
                    if (entry == null || entry.getKey().getNumber() >= i_renamed) {
                        return;
                    }
                    com.google.protobuf.Descriptors.FieldDescriptor key = this.next.getKey();
                    if (this.messageSetWireFormat && key.getLiteJavaType() == com.google.protobuf.WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                        if (this.next instanceof com.google.protobuf.LazyField.LazyEntry) {
                            codedOutputStream.writeRawMessageSetExtension(key.getNumber(), ((com.google.protobuf.LazyField.LazyEntry) this.next).getField().toByteString());
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (com.google.protobuf.Message) this.next.getValue());
                        }
                    } else {
                        com.google.protobuf.FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected com.google.protobuf.GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionWriter(false);
        }

        protected com.google.protobuf.GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionWriter(true);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        protected java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
            java.util.Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return java.util.Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFieldsRaw() {
            java.util.Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return java.util.Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.hasField(fieldDescriptor);
            }
            return super.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                java.lang.Object field = this.extensions.getField(fieldDescriptor);
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
            return super.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.getRepeatedFieldCount(fieldDescriptor);
            }
            return super.getRepeatedFieldCount(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.getRepeatedField(fieldDescriptor, i_renamed);
            }
            return super.getRepeatedField(fieldDescriptor, i_renamed);
        }

        private void verifyContainingType(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new java.lang.IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends com.google.protobuf.GeneratedMessage.ExtendableMessage, BuilderType extends com.google.protobuf.GeneratedMessage.ExtendableBuilder<MessageType, BuilderType>> extends com.google.protobuf.GeneratedMessage.Builder<BuilderType> implements com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder<MessageType> {
        private com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> extensions;

        protected ExtendableBuilder() {
            this.extensions = com.google.protobuf.FieldSet.emptySet();
        }

        protected ExtendableBuilder(com.google.protobuf.GeneratedMessage.BuilderParent builderParent) {
            super(builderParent);
            this.extensions = com.google.protobuf.FieldSet.emptySet();
        }

        void internalSetExtensionSet(com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fieldSet) {
            this.extensions = fieldSet;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.extensions = com.google.protobuf.FieldSet.emptySet();
            return (BuilderType) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo23clone() {
            return (BuilderType) super.mo23clone();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.m24clone();
            }
        }

        private void verifyExtensionContainingType(com.google.protobuf.Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() == getDescriptorForType()) {
                return;
            }
            throw new java.lang.IllegalArgumentException("Extension is_renamed for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.getRepeatedFieldCount(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            com.google.protobuf.Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            java.lang.Object field = this.extensions.getField(descriptor);
            if (field == null) {
                if (descriptor.isRepeated()) {
                    return (Type) java.util.Collections.emptyList();
                }
                if (descriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return (Type) extensionCheckNotLite.getMessageDefaultInstance();
                }
                return (Type) extensionCheckNotLite.fromReflectionType(descriptor.getDefaultValue());
            }
            return (Type) extensionCheckNotLite.fromReflectionType(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, int i_renamed) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return (Type) extensionCheckNotLite.singularFromReflectionType(this.extensions.getRepeatedField(extensionCheckNotLite.getDescriptor(), i_renamed));
        }

        public final <Type> BuilderType setExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite, Type type) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.toReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType setExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, int i_renamed, Type type) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(extensionCheckNotLite.getDescriptor(), i_renamed, extensionCheckNotLite.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType addExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, Type type) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType clearExtension(com.google.protobuf.ExtensionLite<MessageType, ?> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.clearField(extensionCheckNotLite.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return hasExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return hasExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension, int i_renamed) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i_renamed) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) generatedExtension, i_renamed);
        }

        public final <Type> BuilderType setExtension(com.google.protobuf.Extension<MessageType, Type> extension, Type type) {
            return (BuilderType) setExtension(extension, (com.google.protobuf.Extension<MessageType, Type>) type);
        }

        public <Type> BuilderType setExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension, Type type) {
            return (BuilderType) setExtension((com.google.protobuf.ExtensionLite<MessageType, com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type>>) generatedExtension, (com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type>) type);
        }

        public final <Type> BuilderType setExtension(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension, int i_renamed, Type type) {
            return (BuilderType) setExtension((com.google.protobuf.ExtensionLite<MessageType, java.util.List<int>>) extension, i_renamed, (int) type);
        }

        public <Type> BuilderType setExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i_renamed, Type type) {
            return (BuilderType) setExtension((com.google.protobuf.ExtensionLite<MessageType, java.util.List<int>>) generatedExtension, i_renamed, (int) type);
        }

        public final <Type> BuilderType addExtension(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension, Type type) {
            return (BuilderType) addExtension(extension, (com.google.protobuf.Extension<MessageType, java.util.List<Type>>) type);
        }

        public <Type> BuilderType addExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, Type type) {
            return (BuilderType) addExtension((com.google.protobuf.ExtensionLite<MessageType, java.util.List<com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>>>>) generatedExtension, (com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>>) type);
        }

        public final <Type> BuilderType clearExtension(com.google.protobuf.Extension<MessageType, ?> extension) {
            return (BuilderType) clearExtension((com.google.protobuf.ExtensionLite) extension);
        }

        public <Type> BuilderType clearExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, ?> generatedExtension) {
            return (BuilderType) clearExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            return this.extensions;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
            return com.google.protobuf.MessageReflection.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), new com.google.protobuf.MessageReflection.BuilderAdapter(this), i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
            java.util.Map allFieldsMutable = getAllFieldsMutable();
            allFieldsMutable.putAll(this.extensions.getAllFields());
            return java.util.Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                java.lang.Object field = this.extensions.getField(fieldDescriptor);
                if (field != null) {
                    return field;
                }
                if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return com.google.protobuf.DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType());
                }
                return fieldDescriptor.getDefaultValue();
            }
            return super.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.getRepeatedFieldCount(fieldDescriptor);
            }
            return super.getRepeatedFieldCount(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.getRepeatedField(fieldDescriptor, i_renamed);
            }
            return super.getRepeatedField(fieldDescriptor, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.hasField(fieldDescriptor);
            }
            return super.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.setField(fieldDescriptor, obj);
                onChanged();
                return this;
            }
            return (BuilderType) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.clearField(fieldDescriptor);
                onChanged();
                return this;
            }
            return (BuilderType) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.setRepeatedField(fieldDescriptor, i_renamed, obj);
                onChanged();
                return this;
            }
            return (BuilderType) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.addRepeatedField(fieldDescriptor, obj);
                onChanged();
                return this;
            }
            return (BuilderType) super.addRepeatedField(fieldDescriptor, obj);
        }

        protected final void mergeExtensionFields(com.google.protobuf.GeneratedMessage.ExtendableMessage extendableMessage) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(extendableMessage.extensions);
            onChanged();
        }

        private void verifyContainingType(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new java.lang.IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static <ContainingType extends com.google.protobuf.Message, Type> com.google.protobuf.GeneratedMessage.GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final com.google.protobuf.Message message, final int i_renamed, java.lang.Class cls, com.google.protobuf.Message message2) {
        return new com.google.protobuf.GeneratedMessage.GeneratedExtension<>(new com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.2
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
            public com.google.protobuf.Descriptors.FieldDescriptor loadDescriptor() {
                return message.getDescriptorForType().getExtensions().get(i_renamed);
            }
        }, cls, message2, com.google.protobuf.Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingType extends com.google.protobuf.Message, Type> com.google.protobuf.GeneratedMessage.GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(java.lang.Class cls, com.google.protobuf.Message message) {
        return new com.google.protobuf.GeneratedMessage.GeneratedExtension<>(null, cls, message, com.google.protobuf.Extension.ExtensionType.IMMUTABLE);
    }

    private static abstract class CachedDescriptorRetriever implements com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever {
        private volatile com.google.protobuf.Descriptors.FieldDescriptor descriptor;

        protected abstract com.google.protobuf.Descriptors.FieldDescriptor loadDescriptor();

        private CachedDescriptorRetriever() {
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public com.google.protobuf.Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor == null) {
                synchronized (this) {
                    if (this.descriptor == null) {
                        this.descriptor = loadDescriptor();
                    }
                }
            }
            return this.descriptor;
        }
    }

    public static <ContainingType extends com.google.protobuf.Message, Type> com.google.protobuf.GeneratedMessage.GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final com.google.protobuf.Message message, final java.lang.String str, java.lang.Class cls, com.google.protobuf.Message message2) {
        return new com.google.protobuf.GeneratedMessage.GeneratedExtension<>(new com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.3
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
            protected com.google.protobuf.Descriptors.FieldDescriptor loadDescriptor() {
                return message.getDescriptorForType().findFieldByName(str);
            }
        }, cls, message2, com.google.protobuf.Extension.ExtensionType.MUTABLE);
    }

    public static <ContainingType extends com.google.protobuf.Message, Type> com.google.protobuf.GeneratedMessage.GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(final java.lang.Class cls, com.google.protobuf.Message message, final java.lang.String str, final java.lang.String str2) {
        return new com.google.protobuf.GeneratedMessage.GeneratedExtension<>(new com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.4
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
            protected com.google.protobuf.Descriptors.FieldDescriptor loadDescriptor() {
                try {
                    return ((com.google.protobuf.Descriptors.FileDescriptor) cls.getClassLoader().loadClass(str).getField("descriptor").get(null)).findExtensionByName(str2);
                } catch (java.lang.Exception e_renamed) {
                    throw new java.lang.RuntimeException("Cannot load descriptors: " + str + " is_renamed not a_renamed valid descriptor class name", e_renamed);
                }
            }
        }, cls, message, com.google.protobuf.Extension.ExtensionType.MUTABLE);
    }

    public static class GeneratedExtension<ContainingType extends com.google.protobuf.Message, Type> extends com.google.protobuf.Extension<ContainingType, Type> {
        private com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever descriptorRetriever;
        private final java.lang.reflect.Method enumGetValueDescriptor;
        private final java.lang.reflect.Method enumValueOf;
        private final com.google.protobuf.Extension.ExtensionType extensionType;
        private final com.google.protobuf.Message messageDefaultInstance;
        private final java.lang.Class singularType;

        GeneratedExtension(com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever extensionDescriptorRetriever, java.lang.Class cls, com.google.protobuf.Message message, com.google.protobuf.Extension.ExtensionType extensionType) {
            if (com.google.protobuf.Message.class.isAssignableFrom(cls) && !cls.isInstance(message)) {
                throw new java.lang.IllegalArgumentException("Bad messageDefaultInstance for " + cls.getName());
            }
            this.descriptorRetriever = extensionDescriptorRetriever;
            this.singularType = cls;
            this.messageDefaultInstance = message;
            if (com.google.protobuf.ProtocolMessageEnum.class.isAssignableFrom(cls)) {
                this.enumValueOf = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "valueOf", com.google.protobuf.Descriptors.EnumValueDescriptor.class);
                this.enumGetValueDescriptor = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "getValueDescriptor", new java.lang.Class[0]);
            } else {
                this.enumValueOf = null;
                this.enumGetValueDescriptor = null;
            }
            this.extensionType = extensionType;
        }

        public void internalInit(final com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (this.descriptorRetriever != null) {
                throw new java.lang.IllegalStateException("Already initialized.");
            }
            this.descriptorRetriever = new com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.GeneratedExtension.1
                @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
                public com.google.protobuf.Descriptors.FieldDescriptor getDescriptor() {
                    return fieldDescriptor;
                }
            };
        }

        @Override // com.google.protobuf.Extension
        public com.google.protobuf.Descriptors.FieldDescriptor getDescriptor() {
            com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever extensionDescriptorRetriever = this.descriptorRetriever;
            if (extensionDescriptorRetriever == null) {
                throw new java.lang.IllegalStateException("getDescriptor() called before internalInit()");
            }
            return extensionDescriptorRetriever.getDescriptor();
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public com.google.protobuf.Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.Extension
        protected com.google.protobuf.Extension.ExtensionType getExtensionType() {
            return this.extensionType;
        }

        @Override // com.google.protobuf.Extension
        protected java.lang.Object fromReflectionType(java.lang.Object obj) {
            com.google.protobuf.Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (descriptor.isRepeated()) {
                if (descriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE && descriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM) {
                    return obj;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(singularFromReflectionType(it.next()));
                }
                return arrayList;
            }
            return singularFromReflectionType(obj);
        }

        @Override // com.google.protobuf.Extension
        protected java.lang.Object singularFromReflectionType(java.lang.Object obj) {
            int i_renamed = com.google.protobuf.GeneratedMessage.ParameterContainer_7.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()];
            return i_renamed != 1 ? i_renamed != 2 ? obj : com.google.protobuf.GeneratedMessage.invokeOrDie(this.enumValueOf, null, (com.google.protobuf.Descriptors.EnumValueDescriptor) obj) : this.singularType.isInstance(obj) ? obj : this.messageDefaultInstance.newBuilderForType().mergeFrom((com.google.protobuf.Message) obj).build();
        }

        @Override // com.google.protobuf.Extension
        protected java.lang.Object toReflectionType(java.lang.Object obj) {
            com.google.protobuf.Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (descriptor.isRepeated()) {
                if (descriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM) {
                    return obj;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(singularToReflectionType(it.next()));
                }
                return arrayList;
            }
            return singularToReflectionType(obj);
        }

        @Override // com.google.protobuf.Extension
        protected java.lang.Object singularToReflectionType(java.lang.Object obj) {
            return com.google.protobuf.GeneratedMessage.ParameterContainer_7.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()] != 2 ? obj : com.google.protobuf.GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, obj, new java.lang.Object[0]);
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return getDescriptor().getNumber();
        }

        @Override // com.google.protobuf.ExtensionLite
        public com.google.protobuf.WireFormat.FieldType getLiteType() {
            return getDescriptor().getLiteType();
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.ExtensionLite
        public Type getDefaultValue() {
            if (isRepeated()) {
                return (Type) java.util.Collections.emptyList();
            }
            if (getDescriptor().getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return (Type) this.messageDefaultInstance;
            }
            return (Type) singularFromReflectionType(getDescriptor().getDefaultValue());
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessage$5, reason: invalid class name */
    static /* synthetic */ class ParameterContainer_7 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = new int[com.google.protobuf.Descriptors.FieldDescriptor.JavaType.values().length];

        static {
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Method getMethodOrDie(java.lang.Class cls, java.lang.String str, java.lang.Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException e_renamed) {
            throw new java.lang.RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object invokeOrDie(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (java.lang.IllegalAccessException e_renamed) {
            throw new java.lang.RuntimeException("Couldn't_renamed use Java reflection to implement protocol message reflection.", e_renamed);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            java.lang.Throwable cause = e2.getCause();
            if (cause instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) cause);
            }
            if (cause instanceof java.lang.Error) {
                throw ((java.lang.Error) cause);
            }
            throw new java.lang.RuntimeException("Unexpected exception thrown by_renamed generated accessor method.", cause);
        }
    }

    protected com.google.protobuf.MapField internalGetMapField(int i_renamed) {
        throw new java.lang.RuntimeException("No map fields found in_renamed " + getClass().getName());
    }

    public static final class FieldAccessorTable {
        private java.lang.String[] camelCaseNames;
        private final com.google.protobuf.Descriptors.Descriptor descriptor;
        private final com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor[] fields;
        private volatile boolean initialized;
        private final com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor[] oneofs;

        private interface FieldAccessor {
            void addRepeated(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj);

            void clear(com.google.protobuf.GeneratedMessage.Builder builder);

            java.lang.Object get(com.google.protobuf.GeneratedMessage.Builder builder);

            java.lang.Object get(com.google.protobuf.GeneratedMessage generatedMessage);

            com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessage.Builder builder);

            java.lang.Object getRaw(com.google.protobuf.GeneratedMessage.Builder builder);

            java.lang.Object getRaw(com.google.protobuf.GeneratedMessage generatedMessage);

            java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed);

            java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed);

            com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed);

            int getRepeatedCount(com.google.protobuf.GeneratedMessage.Builder builder);

            int getRepeatedCount(com.google.protobuf.GeneratedMessage generatedMessage);

            java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed);

            java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed);

            boolean has(com.google.protobuf.GeneratedMessage.Builder builder);

            boolean has(com.google.protobuf.GeneratedMessage generatedMessage);

            com.google.protobuf.Message.Builder newBuilder();

            void set(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj);

            void setRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed, java.lang.Object obj);
        }

        private boolean isMapFieldEnabled(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return true;
        }

        public FieldAccessorTable(com.google.protobuf.Descriptors.Descriptor descriptor, java.lang.String[] strArr, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2) {
            this(descriptor, strArr);
            ensureFieldAccessorsInitialized(cls, cls2);
        }

        public FieldAccessorTable(com.google.protobuf.Descriptors.Descriptor descriptor, java.lang.String[] strArr) {
            this.descriptor = descriptor;
            this.camelCaseNames = strArr;
            this.fields = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor[descriptor.getFields().size()];
            this.oneofs = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor[descriptor.getOneofs().size()];
            this.initialized = false;
        }

        public com.google.protobuf.GeneratedMessage.FieldAccessorTable ensureFieldAccessorsInitialized(java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2) {
            if (this.initialized) {
                return this;
            }
            synchronized (this) {
                if (this.initialized) {
                    return this;
                }
                int length = this.fields.length;
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= length) {
                        break;
                    }
                    com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor = this.descriptor.getFields().get(i_renamed);
                    java.lang.String str = fieldDescriptor.getContainingOneof() != null ? this.camelCaseNames[fieldDescriptor.getContainingOneof().getIndex() + length] : null;
                    if (fieldDescriptor.isRepeated()) {
                        if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (fieldDescriptor.isMapField() && isMapFieldEnabled(fieldDescriptor)) {
                                this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.MapFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                            } else {
                                this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                            }
                        } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                        } else {
                            this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                        }
                    } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularStringFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    } else {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    }
                    i_renamed++;
                }
                int length2 = this.oneofs.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.oneofs[i2] = new com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor(this.descriptor, this.camelCaseNames[i2 + length], cls, cls2);
                }
                this.initialized = true;
                this.camelCaseNames = null;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.descriptor) {
                throw new java.lang.IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (fieldDescriptor.isExtension()) {
                throw new java.lang.IllegalArgumentException("This type does not have extensions.");
            }
            return this.fields[fieldDescriptor.getIndex()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor getOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            if (oneofDescriptor.getContainingType() != this.descriptor) {
                throw new java.lang.IllegalArgumentException("OneofDescriptor does not match message type.");
            }
            return this.oneofs[oneofDescriptor.getIndex()];
        }

        private static class OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final com.google.protobuf.Descriptors.Descriptor descriptor;

            OneofAccessor(com.google.protobuf.Descriptors.Descriptor descriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2) {
                this.descriptor = descriptor;
                this.caseMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str + "Case", new java.lang.Class[0]);
                this.caseMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Case", new java.lang.Class[0]);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("clear");
                sb.append(str);
                this.clearMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, sb.toString(), new java.lang.Class[0]);
            }

            public boolean has(com.google.protobuf.GeneratedMessage generatedMessage) {
                return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new java.lang.Object[0])).getNumber() != 0;
            }

            public boolean has(com.google.protobuf.GeneratedMessage.Builder builder) {
                return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new java.lang.Object[0])).getNumber() != 0;
            }

            public com.google.protobuf.Descriptors.FieldDescriptor get(com.google.protobuf.GeneratedMessage generatedMessage) {
                int number = ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new java.lang.Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            public com.google.protobuf.Descriptors.FieldDescriptor get(com.google.protobuf.GeneratedMessage.Builder builder) {
                int number = ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new java.lang.Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            public void clear(com.google.protobuf.GeneratedMessage.Builder builder) {
                com.google.protobuf.GeneratedMessage.invokeOrDie(this.clearMethod, builder, new java.lang.Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean supportFieldPresence(com.google.protobuf.Descriptors.FileDescriptor fileDescriptor) {
            return fileDescriptor.getSyntax() == com.google.protobuf.Descriptors.FileDescriptor.Syntax.PROTO2;
        }

        private static class SingularFieldAccessor implements com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor {
            protected final java.lang.reflect.Method caseMethod;
            protected final java.lang.reflect.Method caseMethodBuilder;
            protected final java.lang.reflect.Method clearMethod;
            protected final com.google.protobuf.Descriptors.FieldDescriptor field;
            protected final java.lang.reflect.Method getMethod;
            protected final java.lang.reflect.Method getMethodBuilder;
            protected final boolean hasHasMethod;
            protected final java.lang.reflect.Method hasMethod;
            protected final java.lang.reflect.Method hasMethodBuilder;
            protected final boolean isOneofField;
            protected final java.lang.reflect.Method setMethod;
            protected final java.lang.Class<?> type;

            SingularFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2, java.lang.String str2) {
                java.lang.reflect.Method methodOrDie;
                java.lang.reflect.Method methodOrDie2;
                java.lang.reflect.Method methodOrDie3;
                this.field = fieldDescriptor;
                this.isOneofField = fieldDescriptor.getContainingOneof() != null;
                this.hasHasMethod = com.google.protobuf.GeneratedMessage.FieldAccessorTable.supportFieldPresence(fieldDescriptor.getFile()) || (!this.isOneofField && fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE);
                this.getMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str, new java.lang.Class[0]);
                this.getMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str, new java.lang.Class[0]);
                this.type = this.getMethod.getReturnType();
                this.setMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "set" + str, this.type);
                java.lang.reflect.Method methodOrDie4 = null;
                if (this.hasHasMethod) {
                    methodOrDie = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "has" + str, new java.lang.Class[0]);
                } else {
                    methodOrDie = null;
                }
                this.hasMethod = methodOrDie;
                if (this.hasHasMethod) {
                    methodOrDie2 = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "has" + str, new java.lang.Class[0]);
                } else {
                    methodOrDie2 = null;
                }
                this.hasMethodBuilder = methodOrDie2;
                this.clearMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "clear" + str, new java.lang.Class[0]);
                if (this.isOneofField) {
                    methodOrDie3 = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str2 + "Case", new java.lang.Class[0]);
                } else {
                    methodOrDie3 = null;
                }
                this.caseMethod = methodOrDie3;
                if (this.isOneofField) {
                    methodOrDie4 = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str2 + "Case", new java.lang.Class[0]);
                }
                this.caseMethodBuilder = methodOrDie4;
            }

            private int getOneofFieldNumber(com.google.protobuf.GeneratedMessage generatedMessage) {
                return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new java.lang.Object[0])).getNumber();
            }

            private int getOneofFieldNumber(com.google.protobuf.GeneratedMessage.Builder builder) {
                return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new java.lang.Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage generatedMessage) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage.Builder builder) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage.Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                com.google.protobuf.GeneratedMessage.invokeOrDie(this.setMethod, builder, obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldRaw() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldRaw() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed, java.lang.Object obj) {
                throw new java.lang.UnsupportedOperationException("setRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                throw new java.lang.UnsupportedOperationException("addRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessage generatedMessage) {
                if (this.hasHasMethod) {
                    return ((java.lang.Boolean) com.google.protobuf.GeneratedMessage.invokeOrDie(this.hasMethod, generatedMessage, new java.lang.Object[0])).booleanValue();
                }
                if (this.isOneofField) {
                    return getOneofFieldNumber(generatedMessage) == this.field.getNumber();
                }
                return !get(generatedMessage).equals(this.field.getDefaultValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessage.Builder builder) {
                if (this.hasHasMethod) {
                    return ((java.lang.Boolean) com.google.protobuf.GeneratedMessage.invokeOrDie(this.hasMethodBuilder, builder, new java.lang.Object[0])).booleanValue();
                }
                if (this.isOneofField) {
                    return getOneofFieldNumber(builder) == this.field.getNumber();
                }
                return !get(builder).equals(this.field.getDefaultValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessage generatedMessage) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldSize() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessage.Builder builder) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldSize() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(com.google.protobuf.GeneratedMessage.Builder builder) {
                com.google.protobuf.GeneratedMessage.invokeOrDie(this.clearMethod, builder, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                throw new java.lang.UnsupportedOperationException("newBuilderForField() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessage.Builder builder) {
                throw new java.lang.UnsupportedOperationException("getFieldBuilder() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed non-Message type.");
            }
        }

        private static class RepeatedFieldAccessor implements com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor {
            protected final java.lang.reflect.Method addRepeatedMethod;
            protected final java.lang.reflect.Method clearMethod;
            protected final java.lang.reflect.Method getCountMethod;
            protected final java.lang.reflect.Method getCountMethodBuilder;
            protected final java.lang.reflect.Method getMethod;
            protected final java.lang.reflect.Method getMethodBuilder;
            protected final java.lang.reflect.Method getRepeatedMethod;
            protected final java.lang.reflect.Method getRepeatedMethodBuilder;
            protected final java.lang.reflect.Method setRepeatedMethod;
            protected final java.lang.Class type;

            RepeatedFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2) {
                this.getMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str + "List", new java.lang.Class[0]);
                this.getMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "List", new java.lang.Class[0]);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get");
                sb.append(str);
                this.getRepeatedMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, sb.toString(), java.lang.Integer.TYPE);
                this.getRepeatedMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str, java.lang.Integer.TYPE);
                this.type = this.getRepeatedMethod.getReturnType();
                this.setRepeatedMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "set" + str, java.lang.Integer.TYPE, this.type);
                this.addRepeatedMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "add" + str, this.type);
                this.getCountMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str + "Count", new java.lang.Class[0]);
                this.getCountMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Count", new java.lang.Class[0]);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("clear");
                sb2.append(str);
                this.clearMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, sb2.toString(), new java.lang.Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage generatedMessage) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage.Builder builder) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage.Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                clear(builder);
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getRepeatedMethod, generatedMessage, java.lang.Integer.valueOf(i_renamed));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getRepeatedMethodBuilder, builder, java.lang.Integer.valueOf(i_renamed));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed) {
                return getRepeated(generatedMessage, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                return getRepeated(builder, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed, java.lang.Object obj) {
                com.google.protobuf.GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, java.lang.Integer.valueOf(i_renamed), obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                com.google.protobuf.GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessage generatedMessage) {
                throw new java.lang.UnsupportedOperationException("hasField() called on_renamed a_renamed repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessage.Builder builder) {
                throw new java.lang.UnsupportedOperationException("hasField() called on_renamed a_renamed repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessage generatedMessage) {
                return ((java.lang.Integer) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getCountMethod, generatedMessage, new java.lang.Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessage.Builder builder) {
                return ((java.lang.Integer) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getCountMethodBuilder, builder, new java.lang.Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(com.google.protobuf.GeneratedMessage.Builder builder) {
                com.google.protobuf.GeneratedMessage.invokeOrDie(this.clearMethod, builder, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                throw new java.lang.UnsupportedOperationException("newBuilderForField() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessage.Builder builder) {
                throw new java.lang.UnsupportedOperationException("getFieldBuilder() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed non-Message type.");
            }
        }

        private static class MapFieldAccessor implements com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor {
            private final com.google.protobuf.Descriptors.FieldDescriptor field;
            private final com.google.protobuf.Message mapEntryMessageDefaultInstance;

            MapFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2) {
                this.field = fieldDescriptor;
                this.mapEntryMessageDefaultInstance = getMapField((com.google.protobuf.GeneratedMessage) com.google.protobuf.GeneratedMessage.invokeOrDie(com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "getDefaultInstance", new java.lang.Class[0]), null, new java.lang.Object[0])).getMapEntryMessageDefaultInstance();
            }

            private com.google.protobuf.MapField<?, ?> getMapField(com.google.protobuf.GeneratedMessage generatedMessage) {
                return generatedMessage.internalGetMapField(this.field.getNumber());
            }

            private com.google.protobuf.MapField<?, ?> getMapField(com.google.protobuf.GeneratedMessage.Builder builder) {
                return builder.internalGetMapField(this.field.getNumber());
            }

            private com.google.protobuf.MapField<?, ?> getMutableMapField(com.google.protobuf.GeneratedMessage.Builder builder) {
                return builder.internalGetMutableMapField(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage generatedMessage) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i_renamed = 0; i_renamed < getRepeatedCount(generatedMessage); i_renamed++) {
                    arrayList.add(getRepeated(generatedMessage, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage.Builder builder) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i_renamed = 0; i_renamed < getRepeatedCount(builder); i_renamed++) {
                    arrayList.add(getRepeated(builder, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage.Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                clear(builder);
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed) {
                return getMapField(generatedMessage).getList().get(i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                return getMapField(builder).getList().get(i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed) {
                return getRepeated(generatedMessage, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                return getRepeated(builder, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed, java.lang.Object obj) {
                getMutableMapField(builder).getMutableList().set(i_renamed, (com.google.protobuf.Message) obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                getMutableMapField(builder).getMutableList().add((com.google.protobuf.Message) obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessage generatedMessage) {
                throw new java.lang.UnsupportedOperationException("hasField() is_renamed not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessage.Builder builder) {
                throw new java.lang.UnsupportedOperationException("hasField() is_renamed not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessage generatedMessage) {
                return getMapField(generatedMessage).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessage.Builder builder) {
                return getMapField(builder).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(com.google.protobuf.GeneratedMessage.Builder builder) {
                getMutableMapField(builder).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessage.Builder builder) {
                throw new java.lang.UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("Nested builder not supported for map fields.");
            }
        }

        private static final class SingularEnumFieldAccessor extends com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor {
            private com.google.protobuf.Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private boolean supportUnknownEnumValue;
            private java.lang.reflect.Method valueOfMethod;

            SingularEnumFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2, java.lang.String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.valueOfMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(this.type, "valueOf", com.google.protobuf.Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new java.lang.Class[0]);
                this.supportUnknownEnumValue = fieldDescriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getValueMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str + "Value", new java.lang.Class[0]);
                    this.getValueMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Value", new java.lang.Class[0]);
                    this.setValueMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Value", java.lang.Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage generatedMessage) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getValueMethod, generatedMessage, new java.lang.Object[0])).intValue());
                }
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(generatedMessage), new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage.Builder builder) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getValueMethodBuilder, builder, new java.lang.Object[0])).intValue());
                }
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(builder), new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                if (this.supportUnknownEnumValue) {
                    com.google.protobuf.GeneratedMessage.invokeOrDie(this.setValueMethod, builder, java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.set(builder, com.google.protobuf.GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }
        }

        private static final class RepeatedEnumFieldAccessor extends com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private com.google.protobuf.Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            RepeatedEnumFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.valueOfMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(this.type, "valueOf", com.google.protobuf.Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new java.lang.Class[0]);
                this.supportUnknownEnumValue = fieldDescriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getRepeatedValueMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str + "Value", java.lang.Integer.TYPE);
                    this.getRepeatedValueMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Value", java.lang.Integer.TYPE);
                    this.setRepeatedValueMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Value", java.lang.Integer.TYPE, java.lang.Integer.TYPE);
                    this.addRepeatedValueMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "add" + str + "Value", java.lang.Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage generatedMessage) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int repeatedCount = getRepeatedCount(generatedMessage);
                for (int i_renamed = 0; i_renamed < repeatedCount; i_renamed++) {
                    arrayList.add(getRepeated(generatedMessage, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessage.Builder builder) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int repeatedCount = getRepeatedCount(builder);
                for (int i_renamed = 0; i_renamed < repeatedCount; i_renamed++) {
                    arrayList.add(getRepeated(builder, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage generatedMessage, int i_renamed) {
                if (!this.supportUnknownEnumValue) {
                    return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(generatedMessage, i_renamed), new java.lang.Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getRepeatedValueMethod, generatedMessage, java.lang.Integer.valueOf(i_renamed))).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                if (!this.supportUnknownEnumValue) {
                    return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(builder, i_renamed), new java.lang.Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getRepeatedValueMethodBuilder, builder, java.lang.Integer.valueOf(i_renamed))).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed, java.lang.Object obj) {
                if (this.supportUnknownEnumValue) {
                    com.google.protobuf.GeneratedMessage.invokeOrDie(this.setRepeatedValueMethod, builder, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.setRepeated(builder, i_renamed, com.google.protobuf.GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                if (this.supportUnknownEnumValue) {
                    com.google.protobuf.GeneratedMessage.invokeOrDie(this.addRepeatedValueMethod, builder, java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.addRepeated(builder, com.google.protobuf.GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }
        }

        private static final class SingularStringFieldAccessor extends com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method getBytesMethodBuilder;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            SingularStringFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2, java.lang.String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.getBytesMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls, "get" + str + "Bytes", new java.lang.Class[0]);
                this.getBytesMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Bytes", new java.lang.Class[0]);
                this.setBytesMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Bytes", com.google.protobuf.ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage generatedMessage) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getBytesMethod, generatedMessage, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessage.Builder builder) {
                return com.google.protobuf.GeneratedMessage.invokeOrDie(this.getBytesMethodBuilder, builder, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                if (obj instanceof com.google.protobuf.ByteString) {
                    com.google.protobuf.GeneratedMessage.invokeOrDie(this.setBytesMethodBuilder, builder, obj);
                } else {
                    super.set(builder, obj);
                }
            }
        }

        private static final class SingularMessageFieldAccessor extends com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            SingularMessageFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2, java.lang.String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.newBuilderMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new java.lang.Class[0]);
                this.getBuilderMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Builder", new java.lang.Class[0]);
            }

            private java.lang.Object coerceType(java.lang.Object obj) {
                return this.type.isInstance(obj) ? obj : ((com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0])).mergeFrom((com.google.protobuf.Message) obj).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                super.set(builder, coerceType(obj));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessage.Builder builder) {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, new java.lang.Object[0]);
            }
        }

        private static final class RepeatedMessageFieldAccessor extends com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            RepeatedMessageFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessage> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessage.Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.newBuilderMethod = com.google.protobuf.GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new java.lang.Class[0]);
                this.getBuilderMethodBuilder = com.google.protobuf.GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Builder", java.lang.Integer.TYPE);
            }

            private java.lang.Object coerceType(java.lang.Object obj) {
                return this.type.isInstance(obj) ? obj : ((com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0])).mergeFrom((com.google.protobuf.Message) obj).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed, java.lang.Object obj) {
                super.setRepeated(builder, i_renamed, coerceType(obj));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessage.Builder builder, java.lang.Object obj) {
                super.addRepeated(builder, coerceType(obj));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessage.Builder builder, int i_renamed) {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, java.lang.Integer.valueOf(i_renamed));
            }
        }
    }

    protected java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new com.google.protobuf.GeneratedMessageLite.SerializedForm(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends com.google.protobuf.GeneratedMessage.ExtendableMessage<MessageType>, T_renamed> com.google.protobuf.Extension<MessageType, T_renamed> checkNotLite(com.google.protobuf.ExtensionLite<MessageType, T_renamed> extensionLite) {
        if (extensionLite.isLite()) {
            throw new java.lang.IllegalArgumentException("Expected non-lite extension.");
        }
        return (com.google.protobuf.Extension) extensionLite;
    }

    protected static int computeStringSize(int i_renamed, java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return com.google.protobuf.CodedOutputStream.computeStringSize(i_renamed, (java.lang.String) obj);
        }
        return com.google.protobuf.CodedOutputStream.computeBytesSize(i_renamed, (com.google.protobuf.ByteString) obj);
    }

    protected static int computeStringSizeNoTag(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return com.google.protobuf.CodedOutputStream.computeStringSizeNoTag((java.lang.String) obj);
        }
        return com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag((com.google.protobuf.ByteString) obj);
    }

    protected static void writeString(com.google.protobuf.CodedOutputStream codedOutputStream, int i_renamed, java.lang.Object obj) throws java.io.IOException {
        if (obj instanceof java.lang.String) {
            codedOutputStream.writeString(i_renamed, (java.lang.String) obj);
        } else {
            codedOutputStream.writeBytes(i_renamed, (com.google.protobuf.ByteString) obj);
        }
    }

    protected static void writeStringNoTag(com.google.protobuf.CodedOutputStream codedOutputStream, java.lang.Object obj) throws java.io.IOException {
        if (obj instanceof java.lang.String) {
            codedOutputStream.writeStringNoTag((java.lang.String) obj);
        } else {
            codedOutputStream.writeBytesNoTag((com.google.protobuf.ByteString) obj);
        }
    }
}
