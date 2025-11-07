package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class GeneratedMessageV3 extends com.google.protobuf.AbstractMessage implements java.io.Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static boolean forTestUseReflection = false;
    private static final long serialVersionUID = 1;
    protected com.google.protobuf.UnknownFieldSet unknownFields;

    /* JADX INFO: Access modifiers changed from: protected */
    public interface BuilderParent extends com.google.protobuf.AbstractMessage.BuilderParent {
    }

    public interface ExtendableMessageOrBuilder<MessageType extends com.google.protobuf.GeneratedMessageV3.ExtendableMessage> extends com.google.protobuf.MessageOrBuilder {
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

    protected abstract com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable();

    protected void makeExtensionsImmutable() {
    }

    protected abstract com.google.protobuf.Message.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent);

    static void setForTestUseReflection(boolean z_renamed) {
        forTestUseReflection = z_renamed;
    }

    protected GeneratedMessageV3() {
        this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessageV3(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        this.unknownFields = builder.getUnknownFields();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<? extends com.google.protobuf.GeneratedMessageV3> getParserForType() {
        throw new java.lang.UnsupportedOperationException("This is_renamed supposed to be_renamed overridden by_renamed subclasses.");
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    static void setAlwaysUseFieldBuildersForTesting(boolean z_renamed) {
        alwaysUseFieldBuilders = z_renamed;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    protected void mergeFromAndMakeImmutableInternal(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        com.google.protobuf.Schema schemaSchemaFor = com.google.protobuf.Protobuf.getInstance().schemaFor((com.google.protobuf.Protobuf) this);
        try {
            schemaSchemaFor.mergeFrom(this, com.google.protobuf.CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
            schemaSchemaFor.makeImmutable(this);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.setUnfinishedMessage(this);
        } catch (java.io.IOException e2) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
        }
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
            com.google.protobuf.GeneratedMessageV3$FieldAccessorTable r1 = r6.internalGetFieldAccessorTable()
            com.google.protobuf.Descriptors$Descriptor r1 = com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.access$000(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageV3.getAllFieldsMutable(boolean):java.util.Map");
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

    public com.google.protobuf.UnknownFieldSet getUnknownFields() {
        throw new java.lang.UnsupportedOperationException("This is_renamed supposed to be_renamed overridden by_renamed subclasses.");
    }

    protected boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
        if (codedInputStream.shouldDiscardUnknownFields()) {
            return codedInputStream.skipField(i_renamed);
        }
        return builder.mergeFieldFrom(i_renamed, codedInputStream);
    }

    protected boolean parseUnknownFieldProto3(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
        return parseUnknownField(codedInputStream, builder, extensionRegistryLite, i_renamed);
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

    protected static boolean canUseUnsafe() {
        return com.google.protobuf.UnsafeUtil.hasUnsafeArrayOperations() && com.google.protobuf.UnsafeUtil.hasUnsafeByteBufferOperations();
    }

    protected static com.google.protobuf.Internal.IntList emptyIntList() {
        return com.google.protobuf.IntArrayList.emptyList();
    }

    protected static com.google.protobuf.Internal.IntList newIntList() {
        return new com.google.protobuf.IntArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$IntList] */
    protected static com.google.protobuf.Internal.IntList mutableCopy(com.google.protobuf.Internal.IntList intList) {
        int size = intList.size();
        return intList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static com.google.protobuf.Internal.LongList emptyLongList() {
        return com.google.protobuf.LongArrayList.emptyList();
    }

    protected static com.google.protobuf.Internal.LongList newLongList() {
        return new com.google.protobuf.LongArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$LongList] */
    protected static com.google.protobuf.Internal.LongList mutableCopy(com.google.protobuf.Internal.LongList longList) {
        int size = longList.size();
        return longList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static com.google.protobuf.Internal.FloatList emptyFloatList() {
        return com.google.protobuf.FloatArrayList.emptyList();
    }

    protected static com.google.protobuf.Internal.FloatList newFloatList() {
        return new com.google.protobuf.FloatArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$FloatList] */
    protected static com.google.protobuf.Internal.FloatList mutableCopy(com.google.protobuf.Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static com.google.protobuf.Internal.DoubleList emptyDoubleList() {
        return com.google.protobuf.DoubleArrayList.emptyList();
    }

    protected static com.google.protobuf.Internal.DoubleList newDoubleList() {
        return new com.google.protobuf.DoubleArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$DoubleList] */
    protected static com.google.protobuf.Internal.DoubleList mutableCopy(com.google.protobuf.Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static com.google.protobuf.Internal.BooleanList emptyBooleanList() {
        return com.google.protobuf.BooleanArrayList.emptyList();
    }

    protected static com.google.protobuf.Internal.BooleanList newBooleanList() {
        return new com.google.protobuf.BooleanArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$BooleanList] */
    protected static com.google.protobuf.Internal.BooleanList mutableCopy(com.google.protobuf.Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static final class UnusedPrivateParameter {
        static final com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter INSTANCE = new com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter();

        private UnusedPrivateParameter() {
        }
    }

    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        throw new java.lang.UnsupportedOperationException("This method must be_renamed overridden by_renamed the subclass.");
    }

    @Override // com.google.protobuf.AbstractMessage
    protected com.google.protobuf.Message.Builder newBuilderForType(final com.google.protobuf.AbstractMessage.BuilderParent builderParent) {
        return newBuilderForType(new com.google.protobuf.GeneratedMessageV3.BuilderParent() { // from class: com.google.protobuf.GeneratedMessageV3.1
            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                builderParent.markDirty();
            }
        });
    }

    public static abstract class Builder<BuilderType extends com.google.protobuf.GeneratedMessageV3.Builder<BuilderType>> extends com.google.protobuf.AbstractMessage.Builder<BuilderType> {
        private com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent;
        private boolean isClean;
        private com.google.protobuf.GeneratedMessageV3.Builder<BuilderType>.BuilderParentImpl meAsParent;
        private com.google.protobuf.UnknownFieldSet unknownFields;

        protected abstract com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable();

        protected Builder() {
            this(null);
        }

        protected Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
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

        public BuilderType setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).set(this, obj);
            return this;
        }

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

        public BuilderType setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).setRepeated(this, i_renamed, obj);
            return this;
        }

        public BuilderType addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).addRepeated(this, obj);
            return this;
        }

        private BuilderType setUnknownFieldsInternal(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            this.unknownFields = unknownFieldSet;
            onChanged();
            return this;
        }

        public BuilderType setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (BuilderType) setUnknownFieldsInternal(unknownFieldSet);
        }

        protected BuilderType setUnknownFieldsProto3(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (BuilderType) setUnknownFieldsInternal(unknownFieldSet);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (BuilderType) setUnknownFields(com.google.protobuf.UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build());
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

        private class BuilderParentImpl implements com.google.protobuf.GeneratedMessageV3.BuilderParent {
            private BuilderParentImpl() {
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                com.google.protobuf.GeneratedMessageV3.Builder.this.onChanged();
            }
        }

        protected com.google.protobuf.GeneratedMessageV3.BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new com.google.protobuf.GeneratedMessageV3.Builder.BuilderParentImpl();
            }
            return this.meAsParent;
        }

        protected final void onChanged() {
            com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent;
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

    public static abstract class ExtendableMessage<MessageType extends com.google.protobuf.GeneratedMessageV3.ExtendableMessage> extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder<MessageType> {
        private static final long serialVersionUID = 1;
        private final com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> extensions;

        protected ExtendableMessage() {
            this.extensions = com.google.protobuf.FieldSet.newFieldSet();
        }

        protected ExtendableMessage(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<MessageType, ?> extendableBuilder) {
            super(extendableBuilder);
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(com.google.protobuf.Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() == getDescriptorForType()) {
                return;
            }
            throw new java.lang.IllegalArgumentException("Extension is_renamed for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.getRepeatedFieldCount(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
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

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, int i_renamed) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return (Type) extensionCheckNotLite.singularFromReflectionType(this.extensions.getRepeatedField(extensionCheckNotLite.getDescriptor(), i_renamed));
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return hasExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return hasExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension, int i_renamed) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i_renamed) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) generatedExtension, i_renamed);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
            if (codedInputStream.shouldDiscardUnknownFields()) {
                builder = null;
            }
            return com.google.protobuf.MessageReflection.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), new com.google.protobuf.MessageReflection.ExtensionAdapter(this.extensions), i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected boolean parseUnknownFieldProto3(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i_renamed) throws java.io.IOException {
            return parseUnknownField(codedInputStream, builder, extensionRegistryLite, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        protected class ExtensionWriter {
            private final java.util.Iterator<java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object>> iter;
            private final boolean messageSetWireFormat;
            private java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> next;

            private ExtensionWriter(boolean z_renamed) {
                this.iter = com.google.protobuf.GeneratedMessageV3.ExtendableMessage.this.extensions.iterator();
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

        protected com.google.protobuf.GeneratedMessageV3.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new com.google.protobuf.GeneratedMessageV3.ExtendableMessage.ExtensionWriter(false);
        }

        protected com.google.protobuf.GeneratedMessageV3.ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new com.google.protobuf.GeneratedMessageV3.ExtendableMessage.ExtensionWriter(true);
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

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
            java.util.Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return java.util.Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFieldsRaw() {
            java.util.Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return java.util.Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.hasField(fieldDescriptor);
            }
            return super.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
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

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                return this.extensions.getRepeatedFieldCount(fieldDescriptor);
            }
            return super.getRepeatedFieldCount(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
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

    public static abstract class ExtendableBuilder<MessageType extends com.google.protobuf.GeneratedMessageV3.ExtendableMessage, BuilderType extends com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<MessageType, BuilderType>> extends com.google.protobuf.GeneratedMessageV3.Builder<BuilderType> implements com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder<MessageType> {
        private com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> extensions;

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
        }

        void internalSetExtensionSet(com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> fieldSet) {
            this.extensions = com.google.protobuf.FieldSet.Builder.fromFieldSet(fieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.extensions = null;
            return (BuilderType) super.clear();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions == null) {
                this.extensions = com.google.protobuf.FieldSet.newBuilder();
            }
        }

        private void verifyExtensionContainingType(com.google.protobuf.Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() == getDescriptorForType()) {
                return;
            }
            throw new java.lang.IllegalArgumentException("Extension is_renamed for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return false;
            }
            return builder.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            com.google.protobuf.Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return 0;
            }
            return builder.getRepeatedFieldCount(descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            com.google.protobuf.Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
            java.lang.Object field = builder == null ? null : builder.getField(descriptor);
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

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, int i_renamed) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            com.google.protobuf.Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                throw new java.lang.IndexOutOfBoundsException();
            }
            return (Type) extensionCheckNotLite.singularFromReflectionType(builder.getRepeatedField(descriptor, i_renamed));
        }

        public final <Type> BuilderType setExtension(com.google.protobuf.ExtensionLite<MessageType, Type> extensionLite, Type type) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.toReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType setExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, int i_renamed, Type type) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(extensionCheckNotLite.getDescriptor(), i_renamed, extensionCheckNotLite.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType addExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> extensionLite, Type type) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType clearExtension(com.google.protobuf.ExtensionLite<MessageType, ?> extensionLite) {
            com.google.protobuf.Extension<MessageType, ?> extensionCheckNotLite = com.google.protobuf.GeneratedMessageV3.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.clearField(extensionCheckNotLite.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return hasExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return hasExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension) {
            return getExtensionCount((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, Type> extension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessage.GeneratedExtension<MessageType, Type> generatedExtension) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.Extension<MessageType, java.util.List<Type>> extension, int i_renamed) {
            return (Type) getExtension((com.google.protobuf.ExtensionLite) extension, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
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
            com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return true;
            }
            return builder.isInitialized();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> buildExtensions() {
            com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return com.google.protobuf.FieldSet.emptySet();
            }
            return builder.build();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
            java.util.Map allFieldsMutable = getAllFieldsMutable();
            com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder != null) {
                allFieldsMutable.putAll(builder.getAllFields());
            }
            return java.util.Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
                java.lang.Object field = builder == null ? null : builder.getField(fieldDescriptor);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                if (fieldDescriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    throw new java.lang.UnsupportedOperationException("getFieldBuilder() called on_renamed a_renamed non-Message type.");
                }
                ensureExtensionsIsMutable();
                java.lang.Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(fieldDescriptor);
                if (fieldAllowBuilders == null) {
                    com.google.protobuf.DynamicMessage.Builder builderNewBuilder = com.google.protobuf.DynamicMessage.newBuilder(fieldDescriptor.getMessageType());
                    this.extensions.setField(fieldDescriptor, builderNewBuilder);
                    onChanged();
                    return builderNewBuilder;
                }
                if (fieldAllowBuilders instanceof com.google.protobuf.Message.Builder) {
                    return (com.google.protobuf.Message.Builder) fieldAllowBuilders;
                }
                if (fieldAllowBuilders instanceof com.google.protobuf.Message) {
                    com.google.protobuf.Message.Builder builder = ((com.google.protobuf.Message) fieldAllowBuilders).toBuilder();
                    this.extensions.setField(fieldDescriptor, builder);
                    onChanged();
                    return builder;
                }
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed non-Message type.");
            }
            return super.getFieldBuilder(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
                if (builder == null) {
                    return 0;
                }
                return builder.getRepeatedFieldCount(fieldDescriptor);
            }
            return super.getRepeatedFieldCount(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
                if (builder == null) {
                    throw new java.lang.IndexOutOfBoundsException();
                }
                return builder.getRepeatedField(fieldDescriptor, i_renamed);
            }
            return super.getRepeatedField(fieldDescriptor, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getRepeatedFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                if (fieldDescriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed non-Message type.");
                }
                java.lang.Object repeatedFieldAllowBuilders = this.extensions.getRepeatedFieldAllowBuilders(fieldDescriptor, i_renamed);
                if (repeatedFieldAllowBuilders instanceof com.google.protobuf.Message.Builder) {
                    return (com.google.protobuf.Message.Builder) repeatedFieldAllowBuilders;
                }
                if (repeatedFieldAllowBuilders instanceof com.google.protobuf.Message) {
                    com.google.protobuf.Message.Builder builder = ((com.google.protobuf.Message) repeatedFieldAllowBuilders).toBuilder();
                    this.extensions.setRepeatedField(fieldDescriptor, i_renamed, builder);
                    onChanged();
                    return builder;
                }
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed non-Message type.");
            }
            return super.getRepeatedFieldBuilder(fieldDescriptor, i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                com.google.protobuf.FieldSet.Builder<com.google.protobuf.Descriptors.FieldDescriptor> builder = this.extensions;
                if (builder == null) {
                    return false;
                }
                return builder.hasField(fieldDescriptor);
            }
            return super.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder newBuilderForField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                return com.google.protobuf.DynamicMessage.newBuilder(fieldDescriptor.getMessageType());
            }
            return super.newBuilderForField(fieldDescriptor);
        }

        protected final void mergeExtensionFields(com.google.protobuf.GeneratedMessageV3.ExtendableMessage extendableMessage) {
            if (extendableMessage.extensions != null) {
                ensureExtensionsIsMutable();
                this.extensions.mergeFrom(extendableMessage.extensions);
                onChanged();
            }
        }

        private void verifyContainingType(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new java.lang.IllegalArgumentException("FieldDescriptor does not match message type.");
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

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.RuntimeException handleException(java.lang.Throwable th) {
        if (th instanceof java.lang.ClassCastException) {
            throw new java.lang.IllegalArgumentException(th);
        }
        if (th instanceof java.lang.RuntimeException) {
            throw ((java.lang.RuntimeException) th);
        }
        if (th instanceof java.lang.Error) {
            throw ((java.lang.Error) th);
        }
        throw new java.lang.RuntimeException("Unexpected exception thrown by_renamed generated accessor method.", th);
    }

    protected com.google.protobuf.MapField internalGetMapField(int i_renamed) {
        throw new java.lang.RuntimeException("No map fields found in_renamed " + getClass().getName());
    }

    public static final class FieldAccessorTable {
        private java.lang.String[] camelCaseNames;
        private final com.google.protobuf.Descriptors.Descriptor descriptor;
        private final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor[] fields;
        private volatile boolean initialized;
        private final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.OneofAccessor[] oneofs;

        private interface FieldAccessor {
            void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj);

            void clear(com.google.protobuf.GeneratedMessageV3.Builder builder);

            java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder builder);

            java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

            com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder);

            java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3.Builder builder);

            java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

            java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed);

            java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed);

            com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed);

            int getRepeatedCount(com.google.protobuf.GeneratedMessageV3.Builder builder);

            int getRepeatedCount(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

            java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed);

            java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed);

            boolean has(com.google.protobuf.GeneratedMessageV3.Builder builder);

            boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

            com.google.protobuf.Message.Builder newBuilder();

            void set(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj);

            void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed, java.lang.Object obj);
        }

        public FieldAccessorTable(com.google.protobuf.Descriptors.Descriptor descriptor, java.lang.String[] strArr, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
            this(descriptor, strArr);
            ensureFieldAccessorsInitialized(cls, cls2);
        }

        public FieldAccessorTable(com.google.protobuf.Descriptors.Descriptor descriptor, java.lang.String[] strArr) {
            this.descriptor = descriptor;
            this.camelCaseNames = strArr;
            this.fields = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor[descriptor.getFields().size()];
            this.oneofs = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.OneofAccessor[descriptor.getOneofs().size()];
            this.initialized = false;
        }

        public com.google.protobuf.GeneratedMessageV3.FieldAccessorTable ensureFieldAccessorsInitialized(java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
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
                            if (fieldDescriptor.isMapField()) {
                                this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.MapFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                            } else {
                                this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                            }
                        } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                        } else {
                            this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2);
                        }
                    } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularStringFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    } else {
                        this.fields[i_renamed] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor(fieldDescriptor, this.camelCaseNames[i_renamed], cls, cls2, str);
                    }
                    i_renamed++;
                }
                int length2 = this.oneofs.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.oneofs[i2] = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.OneofAccessor(this.descriptor, this.camelCaseNames[i2 + length], cls, cls2);
                }
                this.initialized = true;
                this.camelCaseNames = null;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.descriptor) {
                throw new java.lang.IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (fieldDescriptor.isExtension()) {
                throw new java.lang.IllegalArgumentException("This type does not have extensions.");
            }
            return this.fields[fieldDescriptor.getIndex()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.OneofAccessor getOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
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

            OneofAccessor(com.google.protobuf.Descriptors.Descriptor descriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
                this.descriptor = descriptor;
                this.caseMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Case", new java.lang.Class[0]);
                this.caseMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Case", new java.lang.Class[0]);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("clear");
                sb.append(str);
                this.clearMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, sb.toString(), new java.lang.Class[0]);
            }

            public boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.caseMethod, generatedMessageV3, new java.lang.Object[0])).getNumber() != 0;
            }

            public boolean has(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, builder, new java.lang.Object[0])).getNumber() != 0;
            }

            public com.google.protobuf.Descriptors.FieldDescriptor get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                int number = ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.caseMethod, generatedMessageV3, new java.lang.Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            public com.google.protobuf.Descriptors.FieldDescriptor get(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                int number = ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, builder, new java.lang.Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            public void clear(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.clearMethod, builder, new java.lang.Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean supportFieldPresence(com.google.protobuf.Descriptors.FileDescriptor fileDescriptor) {
            return fileDescriptor.getSyntax() == com.google.protobuf.Descriptors.FileDescriptor.Syntax.PROTO2;
        }

        private static class SingularFieldAccessor implements com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor {
            protected final com.google.protobuf.Descriptors.FieldDescriptor field;
            protected final boolean hasHasMethod;
            protected final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker invoker;
            protected final boolean isOneofField;
            protected final java.lang.Class<?> type;

            private interface MethodInvoker {
                void clear(com.google.protobuf.GeneratedMessageV3.Builder<?> builder);

                java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder<?> builder);

                java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

                int getOneofFieldNumber(com.google.protobuf.GeneratedMessageV3.Builder<?> builder);

                int getOneofFieldNumber(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

                boolean has(com.google.protobuf.GeneratedMessageV3.Builder<?> builder);

                boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

                void set(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, java.lang.Object obj);
            }

            private static final class ReflectionInvoker implements com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker {
                protected final java.lang.reflect.Method caseMethod;
                protected final java.lang.reflect.Method caseMethodBuilder;
                protected final java.lang.reflect.Method clearMethod;
                protected final java.lang.reflect.Method getMethod;
                protected final java.lang.reflect.Method getMethodBuilder;
                protected final java.lang.reflect.Method hasMethod;
                protected final java.lang.reflect.Method hasMethodBuilder;
                protected final java.lang.reflect.Method setMethod;

                ReflectionInvoker(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2, java.lang.String str2, boolean z_renamed, boolean z2) {
                    java.lang.reflect.Method methodOrDie;
                    java.lang.reflect.Method methodOrDie2;
                    java.lang.reflect.Method methodOrDie3;
                    this.getMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str, new java.lang.Class[0]);
                    this.getMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str, new java.lang.Class[0]);
                    this.setMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "set" + str, this.getMethod.getReturnType());
                    java.lang.reflect.Method methodOrDie4 = null;
                    if (z2) {
                        methodOrDie = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "has" + str, new java.lang.Class[0]);
                    } else {
                        methodOrDie = null;
                    }
                    this.hasMethod = methodOrDie;
                    if (z2) {
                        methodOrDie2 = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "has" + str, new java.lang.Class[0]);
                    } else {
                        methodOrDie2 = null;
                    }
                    this.hasMethodBuilder = methodOrDie2;
                    this.clearMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "clear" + str, new java.lang.Class[0]);
                    if (z_renamed) {
                        methodOrDie3 = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str2 + "Case", new java.lang.Class[0]);
                    } else {
                        methodOrDie3 = null;
                    }
                    this.caseMethod = methodOrDie3;
                    if (z_renamed) {
                        methodOrDie4 = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str2 + "Case", new java.lang.Class[0]);
                    }
                    this.caseMethodBuilder = methodOrDie4;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getMethod, generatedMessageV3, new java.lang.Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, builder, new java.lang.Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.caseMethod, generatedMessageV3, new java.lang.Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    return ((com.google.protobuf.Internal.EnumLite) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, builder, new java.lang.Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void set(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, java.lang.Object obj) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.setMethod, builder, obj);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    return ((java.lang.Boolean) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.hasMethod, generatedMessageV3, new java.lang.Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    return ((java.lang.Boolean) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.hasMethodBuilder, builder, new java.lang.Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void clear(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.clearMethod, builder, new java.lang.Object[0]);
                }
            }

            private static final class MethodHandleInvoker implements com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker {
                protected final java.lang.invoke.MethodHandle caseMethod;
                protected final java.lang.invoke.MethodHandle caseMethodBuilder;
                protected final java.lang.invoke.MethodHandle clearMethod;
                protected final java.lang.invoke.MethodHandle getMethod;
                protected final java.lang.invoke.MethodHandle getMethodBuilder;
                protected final java.lang.invoke.MethodHandle hasMethod;
                protected final java.lang.invoke.MethodHandle hasMethodBuilder;
                protected final java.lang.invoke.MethodHandle setMethod;

                MethodHandleInvoker(com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.ReflectionInvoker reflectionInvoker) throws java.lang.IllegalAccessException {
                    java.lang.invoke.MethodHandles.Lookup lookupPublicLookup = java.lang.invoke.MethodHandles.publicLookup();
                    this.getMethod = lookupPublicLookup.unreflect(reflectionInvoker.getMethod);
                    this.getMethodBuilder = lookupPublicLookup.unreflect(reflectionInvoker.getMethodBuilder);
                    this.setMethod = lookupPublicLookup.unreflect(reflectionInvoker.setMethod);
                    this.hasMethod = reflectionInvoker.hasMethod != null ? lookupPublicLookup.unreflect(reflectionInvoker.hasMethod) : null;
                    this.hasMethodBuilder = reflectionInvoker.hasMethodBuilder != null ? lookupPublicLookup.unreflect(reflectionInvoker.hasMethodBuilder) : null;
                    this.clearMethod = lookupPublicLookup.unreflect(reflectionInvoker.clearMethod);
                    this.caseMethod = reflectionInvoker.caseMethod != null ? lookupPublicLookup.unreflect(reflectionInvoker.caseMethod) : null;
                    this.caseMethodBuilder = reflectionInvoker.caseMethodBuilder != null ? lookupPublicLookup.unreflect(reflectionInvoker.caseMethodBuilder) : null;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    try {
                        return (java.lang.Object) this.getMethod.invoke(generatedMessageV3);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    try {
                        return (java.lang.Object) this.getMethodBuilder.invoke(builder);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    try {
                        return (com.google.protobuf.Internal.EnumLite) this.caseMethod.invoke(generatedMessageV3).getNumber();
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    try {
                        return (com.google.protobuf.Internal.EnumLite) this.caseMethodBuilder.invoke(builder).getNumber();
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void set(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, java.lang.Object obj) {
                    try {
                        (void) this.setMethod.invoke(builder, obj);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    try {
                        return (java.lang.Boolean) this.hasMethod.invoke(generatedMessageV3).booleanValue();
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    try {
                        return (java.lang.Boolean) this.hasMethodBuilder.invoke(builder).booleanValue();
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void clear(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    try {
                        (void) this.clearMethod.invoke(builder);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }
            }

            SingularFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2, java.lang.String str2) {
                boolean z_renamed = true;
                this.isOneofField = fieldDescriptor.getContainingOneof() != null;
                if (!com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.supportFieldPresence(fieldDescriptor.getFile()) && (this.isOneofField || fieldDescriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE)) {
                    z_renamed = false;
                }
                this.hasHasMethod = z_renamed;
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.ReflectionInvoker reflectionInvoker = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.ReflectionInvoker(fieldDescriptor, str, cls, cls2, str2, this.isOneofField, this.hasHasMethod);
                this.field = fieldDescriptor;
                this.type = reflectionInvoker.getMethod.getReturnType();
                this.invoker = tryGetMethodHandleInvoke(reflectionInvoker);
            }

            static com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodInvoker tryGetMethodHandleInvoke(com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.ReflectionInvoker reflectionInvoker) {
                if (com.google.protobuf.GeneratedMessageV3.forTestUseReflection) {
                    return reflectionInvoker;
                }
                try {
                    return new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor.MethodHandleInvoker(reflectionInvoker);
                } catch (java.lang.IllegalAccessException e_renamed) {
                    throw new java.lang.RuntimeException(e_renamed);
                } catch (java.lang.NoClassDefFoundError unused) {
                    return reflectionInvoker;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return this.invoker.get(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return this.invoker.get((com.google.protobuf.GeneratedMessageV3.Builder<?>) builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return get(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                this.invoker.set(builder, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldRaw() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldRaw() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed, java.lang.Object obj) {
                throw new java.lang.UnsupportedOperationException("setRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                throw new java.lang.UnsupportedOperationException("addRepeatedField() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                if (!this.hasHasMethod) {
                    if (this.isOneofField) {
                        return this.invoker.getOneofFieldNumber(generatedMessageV3) == this.field.getNumber();
                    }
                    return !get(generatedMessageV3).equals(this.field.getDefaultValue());
                }
                return this.invoker.has(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                if (!this.hasHasMethod) {
                    if (this.isOneofField) {
                        return this.invoker.getOneofFieldNumber((com.google.protobuf.GeneratedMessageV3.Builder<?>) builder) == this.field.getNumber();
                    }
                    return !get(builder).equals(this.field.getDefaultValue());
                }
                return this.invoker.has((com.google.protobuf.GeneratedMessageV3.Builder<?>) builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldSize() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldSize() called on_renamed a_renamed singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void clear(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                this.invoker.clear(builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                throw new java.lang.UnsupportedOperationException("newBuilderForField() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                throw new java.lang.UnsupportedOperationException("getFieldBuilder() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed non-Message type.");
            }
        }

        private static class RepeatedFieldAccessor implements com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor {
            protected final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker invoker;
            protected final java.lang.Class type;

            interface MethodInvoker {
                void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, java.lang.Object obj);

                void clear(com.google.protobuf.GeneratedMessageV3.Builder<?> builder);

                java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder<?> builder);

                java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

                java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, int i_renamed);

                java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed);

                int getRepeatedCount(com.google.protobuf.GeneratedMessageV3.Builder<?> builder);

                int getRepeatedCount(com.google.protobuf.GeneratedMessageV3 generatedMessageV3);

                void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, int i_renamed, java.lang.Object obj);
            }

            private static final class ReflectionInvoker implements com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker {
                protected final java.lang.reflect.Method addRepeatedMethod;
                protected final java.lang.reflect.Method clearMethod;
                protected final java.lang.reflect.Method getCountMethod;
                protected final java.lang.reflect.Method getCountMethodBuilder;
                protected final java.lang.reflect.Method getMethod;
                protected final java.lang.reflect.Method getMethodBuilder;
                protected final java.lang.reflect.Method getRepeatedMethod;
                protected final java.lang.reflect.Method getRepeatedMethodBuilder;
                protected final java.lang.reflect.Method setRepeatedMethod;

                ReflectionInvoker(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
                    this.getMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "List", new java.lang.Class[0]);
                    this.getMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "List", new java.lang.Class[0]);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("get");
                    sb.append(str);
                    this.getRepeatedMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, sb.toString(), java.lang.Integer.TYPE);
                    this.getRepeatedMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str, java.lang.Integer.TYPE);
                    java.lang.Class<?> returnType = this.getRepeatedMethod.getReturnType();
                    this.setRepeatedMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "set" + str, java.lang.Integer.TYPE, returnType);
                    this.addRepeatedMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "add" + str, returnType);
                    this.getCountMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Count", new java.lang.Class[0]);
                    this.getCountMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Count", new java.lang.Class[0]);
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("clear");
                    sb2.append(str);
                    this.clearMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, sb2.toString(), new java.lang.Class[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getMethod, generatedMessageV3, new java.lang.Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, builder, new java.lang.Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getRepeatedMethod, generatedMessageV3, java.lang.Integer.valueOf(i_renamed));
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, int i_renamed) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getRepeatedMethodBuilder, builder, java.lang.Integer.valueOf(i_renamed));
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, int i_renamed, java.lang.Object obj) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.setRepeatedMethod, builder, java.lang.Integer.valueOf(i_renamed), obj);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, java.lang.Object obj) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.addRepeatedMethod, builder, obj);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    return ((java.lang.Integer) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getCountMethod, generatedMessageV3, new java.lang.Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    return ((java.lang.Integer) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getCountMethodBuilder, builder, new java.lang.Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void clear(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.clearMethod, builder, new java.lang.Object[0]);
                }
            }

            private static final class MethodHandleInvoker implements com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker {
                protected final java.lang.invoke.MethodHandle addRepeatedMethod;
                protected final java.lang.invoke.MethodHandle clearMethod;
                protected final java.lang.invoke.MethodHandle getCountMethod;
                protected final java.lang.invoke.MethodHandle getCountMethodBuilder;
                protected final java.lang.invoke.MethodHandle getMethod;
                protected final java.lang.invoke.MethodHandle getMethodBuilder;
                protected final java.lang.invoke.MethodHandle getRepeatedMethod;
                protected final java.lang.invoke.MethodHandle getRepeatedMethodBuilder;
                protected final java.lang.invoke.MethodHandle setRepeatedMethod;

                MethodHandleInvoker(com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.ReflectionInvoker reflectionInvoker) throws java.lang.IllegalAccessException {
                    java.lang.invoke.MethodHandles.Lookup lookup = java.lang.invoke.MethodHandles.lookup();
                    this.getMethod = lookup.unreflect(reflectionInvoker.getMethod);
                    this.getMethodBuilder = lookup.unreflect(reflectionInvoker.getMethodBuilder);
                    this.getRepeatedMethod = lookup.unreflect(reflectionInvoker.getRepeatedMethod);
                    this.getRepeatedMethodBuilder = lookup.unreflect(reflectionInvoker.getRepeatedMethodBuilder);
                    this.setRepeatedMethod = lookup.unreflect(reflectionInvoker.setRepeatedMethod);
                    this.addRepeatedMethod = lookup.unreflect(reflectionInvoker.addRepeatedMethod);
                    this.getCountMethod = lookup.unreflect(reflectionInvoker.getCountMethod);
                    this.getCountMethodBuilder = lookup.unreflect(reflectionInvoker.getCountMethodBuilder);
                    this.clearMethod = lookup.unreflect(reflectionInvoker.clearMethod);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    try {
                        return (java.lang.Object) this.getMethod.invoke(generatedMessageV3);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    try {
                        return (java.lang.Object) this.getMethodBuilder.invoke(builder);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                    try {
                        return (java.lang.Object) this.getRepeatedMethod.invoke(generatedMessageV3, i_renamed);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, int i_renamed) {
                    try {
                        return (java.lang.Object) this.getRepeatedMethodBuilder.invoke(builder, i_renamed);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, int i_renamed, java.lang.Object obj) {
                    try {
                        (void) this.setRepeatedMethod.invoke(builder, i_renamed, obj);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder<?> builder, java.lang.Object obj) {
                    try {
                        (void) this.addRepeatedMethod.invoke(builder, obj);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                    try {
                        return (java.lang.Integer) this.getCountMethod.invoke(generatedMessageV3).intValue();
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    try {
                        return (java.lang.Integer) this.getCountMethodBuilder.invoke(builder).intValue();
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void clear(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                    try {
                        (void) this.clearMethod.invoke(builder);
                    } catch (java.lang.Throwable th) {
                        throw com.google.protobuf.GeneratedMessageV3.handleException(th);
                    }
                }
            }

            RepeatedFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.ReflectionInvoker reflectionInvoker = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.ReflectionInvoker(fieldDescriptor, str, cls, cls2);
                this.type = reflectionInvoker.getRepeatedMethod.getReturnType();
                this.invoker = tryGetMethodHandleInvoke(reflectionInvoker);
            }

            static com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker tryGetMethodHandleInvoke(com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.ReflectionInvoker reflectionInvoker) {
                if (com.google.protobuf.GeneratedMessageV3.forTestUseReflection) {
                    return reflectionInvoker;
                }
                try {
                    return new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor.MethodHandleInvoker(reflectionInvoker);
                } catch (java.lang.IllegalAccessException e_renamed) {
                    throw new java.lang.RuntimeException(e_renamed);
                } catch (java.lang.NoClassDefFoundError unused) {
                    return reflectionInvoker;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return this.invoker.get(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return this.invoker.get((com.google.protobuf.GeneratedMessageV3.Builder<?>) builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return get(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                clear(builder);
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                return this.invoker.getRepeated(generatedMessageV3, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                return this.invoker.getRepeated((com.google.protobuf.GeneratedMessageV3.Builder<?>) builder, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                return getRepeated(generatedMessageV3, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                return getRepeated(builder, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed, java.lang.Object obj) {
                this.invoker.setRepeated(builder, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                this.invoker.addRepeated(builder, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                throw new java.lang.UnsupportedOperationException("hasField() called on_renamed a_renamed repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                throw new java.lang.UnsupportedOperationException("hasField() called on_renamed a_renamed repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return this.invoker.getRepeatedCount(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return this.invoker.getRepeatedCount((com.google.protobuf.GeneratedMessageV3.Builder<?>) builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void clear(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                this.invoker.clear(builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                throw new java.lang.UnsupportedOperationException("newBuilderForField() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                throw new java.lang.UnsupportedOperationException("getFieldBuilder() called on_renamed a_renamed non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed a_renamed non-Message type.");
            }
        }

        private static class MapFieldAccessor implements com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor {
            private final com.google.protobuf.Descriptors.FieldDescriptor field;
            private final com.google.protobuf.Message mapEntryMessageDefaultInstance;

            MapFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
                this.field = fieldDescriptor;
                this.mapEntryMessageDefaultInstance = getMapField((com.google.protobuf.GeneratedMessageV3) com.google.protobuf.GeneratedMessageV3.invokeOrDie(com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "getDefaultInstance", new java.lang.Class[0]), null, new java.lang.Object[0])).getMapEntryMessageDefaultInstance();
            }

            private com.google.protobuf.MapField<?, ?> getMapField(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return generatedMessageV3.internalGetMapField(this.field.getNumber());
            }

            private com.google.protobuf.MapField<?, ?> getMapField(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return builder.internalGetMapField(this.field.getNumber());
            }

            private com.google.protobuf.MapField<?, ?> getMutableMapField(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return builder.internalGetMutableMapField(this.field.getNumber());
            }

            private com.google.protobuf.Message coerceType(com.google.protobuf.Message message) {
                if (message == null) {
                    return null;
                }
                return this.mapEntryMessageDefaultInstance.getClass().isInstance(message) ? message : this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(message).build();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i_renamed = 0; i_renamed < getRepeatedCount(generatedMessageV3); i_renamed++) {
                    arrayList.add(getRepeated(generatedMessageV3, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i_renamed = 0; i_renamed < getRepeatedCount(builder); i_renamed++) {
                    arrayList.add(getRepeated(builder, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return get(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                clear(builder);
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                return getMapField(generatedMessageV3).getList().get(i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                return getMapField(builder).getList().get(i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                return getRepeated(generatedMessageV3, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeatedRaw(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                return getRepeated(builder, i_renamed);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed, java.lang.Object obj) {
                getMutableMapField(builder).getMutableList().set(i_renamed, coerceType((com.google.protobuf.Message) obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                getMutableMapField(builder).getMutableList().add(coerceType((com.google.protobuf.Message) obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                throw new java.lang.UnsupportedOperationException("hasField() is_renamed not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                throw new java.lang.UnsupportedOperationException("hasField() is_renamed not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return getMapField(generatedMessageV3).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return getMapField(builder).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void clear(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                getMutableMapField(builder).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                throw new java.lang.UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                throw new java.lang.UnsupportedOperationException("Nested builder not supported for map fields.");
            }
        }

        private static final class SingularEnumFieldAccessor extends com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor {
            private com.google.protobuf.Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private boolean supportUnknownEnumValue;
            private java.lang.reflect.Method valueOfMethod;

            SingularEnumFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2, java.lang.String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.valueOfMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(this.type, "valueOf", com.google.protobuf.Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(this.type, "getValueDescriptor", new java.lang.Class[0]);
                this.supportUnknownEnumValue = fieldDescriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getValueMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Value", new java.lang.Class[0]);
                    this.getValueMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Value", new java.lang.Class[0]);
                    this.setValueMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Value", java.lang.Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getValueMethod, generatedMessageV3, new java.lang.Object[0])).intValue());
                }
                return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.get(generatedMessageV3), new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getValueMethodBuilder, builder, new java.lang.Object[0])).intValue());
                }
                return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.get(builder), new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                if (this.supportUnknownEnumValue) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.setValueMethod, builder, java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.set(builder, com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }
        }

        private static final class RepeatedEnumFieldAccessor extends com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private com.google.protobuf.Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            RepeatedEnumFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.valueOfMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(this.type, "valueOf", com.google.protobuf.Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(this.type, "getValueDescriptor", new java.lang.Class[0]);
                this.supportUnknownEnumValue = fieldDescriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getRepeatedValueMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Value", java.lang.Integer.TYPE);
                    this.getRepeatedValueMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Value", java.lang.Integer.TYPE);
                    this.setRepeatedValueMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Value", java.lang.Integer.TYPE, java.lang.Integer.TYPE);
                    this.addRepeatedValueMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "add" + str + "Value", java.lang.Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int repeatedCount = getRepeatedCount(generatedMessageV3);
                for (int i_renamed = 0; i_renamed < repeatedCount; i_renamed++) {
                    arrayList.add(getRepeated(generatedMessageV3, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object get(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int repeatedCount = getRepeatedCount(builder);
                for (int i_renamed = 0; i_renamed < repeatedCount; i_renamed++) {
                    arrayList.add(getRepeated(builder, i_renamed));
                }
                return java.util.Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3 generatedMessageV3, int i_renamed) {
                if (!this.supportUnknownEnumValue) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(generatedMessageV3, i_renamed), new java.lang.Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getRepeatedValueMethod, generatedMessageV3, java.lang.Integer.valueOf(i_renamed))).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                if (!this.supportUnknownEnumValue) {
                    return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(builder, i_renamed), new java.lang.Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((java.lang.Integer) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getRepeatedValueMethodBuilder, builder, java.lang.Integer.valueOf(i_renamed))).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed, java.lang.Object obj) {
                if (this.supportUnknownEnumValue) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.setRepeatedValueMethod, builder, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.setRepeated(builder, i_renamed, com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                if (this.supportUnknownEnumValue) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.addRepeatedValueMethod, builder, java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.addRepeated(builder, com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }
        }

        private static final class SingularStringFieldAccessor extends com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method getBytesMethodBuilder;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            SingularStringFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2, java.lang.String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.getBytesMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Bytes", new java.lang.Class[0]);
                this.getBytesMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Bytes", new java.lang.Class[0]);
                this.setBytesMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Bytes", com.google.protobuf.ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3 generatedMessageV3) {
                return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getBytesMethod, generatedMessageV3, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public java.lang.Object getRaw(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getBytesMethodBuilder, builder, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                if (obj instanceof com.google.protobuf.ByteString) {
                    com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.setBytesMethodBuilder, builder, obj);
                } else {
                    super.set(builder, obj);
                }
            }
        }

        private static final class SingularMessageFieldAccessor extends com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            SingularMessageFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2, java.lang.String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.newBuilderMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(this.type, "newBuilder", new java.lang.Class[0]);
                this.getBuilderMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Builder", new java.lang.Class[0]);
            }

            private java.lang.Object coerceType(java.lang.Object obj) {
                return this.type.isInstance(obj) ? obj : ((com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0])).mergeFrom((com.google.protobuf.Message) obj).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                super.set(builder, coerceType(obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder) {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getBuilderMethodBuilder, builder, new java.lang.Object[0]);
            }
        }

        private static final class RepeatedMessageFieldAccessor extends com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            RepeatedMessageFieldAccessor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.String str, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3> cls, java.lang.Class<? extends com.google.protobuf.GeneratedMessageV3.Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.newBuilderMethod = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(this.type, "newBuilder", new java.lang.Class[0]);
                this.getBuilderMethodBuilder = com.google.protobuf.GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Builder", java.lang.Integer.TYPE);
            }

            private java.lang.Object coerceType(java.lang.Object obj) {
                return this.type.isInstance(obj) ? obj : ((com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0])).mergeFrom((com.google.protobuf.Message) obj).build();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed, java.lang.Object obj) {
                super.setRepeated(builder, i_renamed, coerceType(obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(com.google.protobuf.GeneratedMessageV3.Builder builder, java.lang.Object obj) {
                super.addRepeated(builder, coerceType(obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder newBuilder() {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new java.lang.Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public com.google.protobuf.Message.Builder getRepeatedBuilder(com.google.protobuf.GeneratedMessageV3.Builder builder, int i_renamed) {
                return (com.google.protobuf.Message.Builder) com.google.protobuf.GeneratedMessageV3.invokeOrDie(this.getBuilderMethodBuilder, builder, java.lang.Integer.valueOf(i_renamed));
            }
        }
    }

    protected java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new com.google.protobuf.GeneratedMessageLite.SerializedForm(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends com.google.protobuf.GeneratedMessageV3.ExtendableMessage<MessageType>, T_renamed> com.google.protobuf.Extension<MessageType, T_renamed> checkNotLite(com.google.protobuf.ExtensionLite<MessageType, T_renamed> extensionLite) {
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

    protected static <V_renamed> void serializeIntegerMapTo(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.MapField<java.lang.Integer, V_renamed> mapField, com.google.protobuf.MapEntry<java.lang.Integer, V_renamed> mapEntry, int i_renamed) throws java.io.IOException {
        java.util.Map<java.lang.Integer, V_renamed> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i_renamed);
            return;
        }
        int[] iArr = new int[map.size()];
        java.util.Iterator<java.lang.Integer> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        java.util.Arrays.sort(iArr);
        for (int i3 : iArr) {
            codedOutputStream.writeMessage(i_renamed, mapEntry.newBuilderForType().setKey(java.lang.Integer.valueOf(i3)).setValue(map.get(java.lang.Integer.valueOf(i3))).build());
        }
    }

    protected static <V_renamed> void serializeLongMapTo(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.MapField<java.lang.Long, V_renamed> mapField, com.google.protobuf.MapEntry<java.lang.Long, V_renamed> mapEntry, int i_renamed) throws java.io.IOException {
        java.util.Map<java.lang.Long, V_renamed> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i_renamed);
            return;
        }
        long[] jArr = new long[map.size()];
        java.util.Iterator<java.lang.Long> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        java.util.Arrays.sort(jArr);
        for (long j_renamed : jArr) {
            codedOutputStream.writeMessage(i_renamed, mapEntry.newBuilderForType().setKey(java.lang.Long.valueOf(j_renamed)).setValue(map.get(java.lang.Long.valueOf(j_renamed))).build());
        }
    }

    protected static <V_renamed> void serializeStringMapTo(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.MapField<java.lang.String, V_renamed> mapField, com.google.protobuf.MapEntry<java.lang.String, V_renamed> mapEntry, int i_renamed) throws java.io.IOException {
        java.util.Map<java.lang.String, V_renamed> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i_renamed);
            return;
        }
        java.lang.String[] strArr = (java.lang.String[]) map.keySet().toArray(new java.lang.String[map.size()]);
        java.util.Arrays.sort(strArr);
        for (java.lang.String str : strArr) {
            codedOutputStream.writeMessage(i_renamed, mapEntry.newBuilderForType().setKey(str).setValue(map.get(str)).build());
        }
    }

    protected static <V_renamed> void serializeBooleanMapTo(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.MapField<java.lang.Boolean, V_renamed> mapField, com.google.protobuf.MapEntry<java.lang.Boolean, V_renamed> mapEntry, int i_renamed) throws java.io.IOException {
        java.util.Map<java.lang.Boolean, V_renamed> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i_renamed);
        } else {
            maybeSerializeBooleanEntryTo(codedOutputStream, map, mapEntry, i_renamed, false);
            maybeSerializeBooleanEntryTo(codedOutputStream, map, mapEntry, i_renamed, true);
        }
    }

    private static <V_renamed> void maybeSerializeBooleanEntryTo(com.google.protobuf.CodedOutputStream codedOutputStream, java.util.Map<java.lang.Boolean, V_renamed> map, com.google.protobuf.MapEntry<java.lang.Boolean, V_renamed> mapEntry, int i_renamed, boolean z_renamed) throws java.io.IOException {
        if (map.containsKey(java.lang.Boolean.valueOf(z_renamed))) {
            codedOutputStream.writeMessage(i_renamed, mapEntry.newBuilderForType().setKey(java.lang.Boolean.valueOf(z_renamed)).setValue(map.get(java.lang.Boolean.valueOf(z_renamed))).build());
        }
    }

    private static <K_renamed, V_renamed> void serializeMapTo(com.google.protobuf.CodedOutputStream codedOutputStream, java.util.Map<K_renamed, V_renamed> map, com.google.protobuf.MapEntry<K_renamed, V_renamed> mapEntry, int i_renamed) throws java.io.IOException {
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : map.entrySet()) {
            codedOutputStream.writeMessage(i_renamed, mapEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
    }
}
