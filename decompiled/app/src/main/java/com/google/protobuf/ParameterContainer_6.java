package com.google.protobuf;

/* loaded from: classes.dex */
final class DescriptorMessageInfoFactory implements com.google.protobuf.MessageInfoFactory {
    private static final java.lang.String GET_DEFAULT_INSTANCE_METHOD_NAME = "getDefaultInstance";
    private static final com.google.protobuf.DescriptorMessageInfoFactory instance = new com.google.protobuf.DescriptorMessageInfoFactory();
    private static final java.util.Set<java.lang.String> specialFieldNames = new java.util.HashSet(java.util.Arrays.asList("cached_size", "serialized_size", "class"));
    private static com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer isInitializedCheckAnalyzer = new com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer();

    private DescriptorMessageInfoFactory() {
    }

    public static com.google.protobuf.DescriptorMessageInfoFactory getInstance() {
        return instance;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(java.lang.Class<?> cls) {
        return com.google.protobuf.GeneratedMessageV3.class.isAssignableFrom(cls);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public com.google.protobuf.MessageInfo messageInfoFor(java.lang.Class<?> cls) {
        if (!com.google.protobuf.GeneratedMessageV3.class.isAssignableFrom(cls)) {
            throw new java.lang.IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        return convert(cls, descriptorForType(cls));
    }

    private static com.google.protobuf.Message getDefaultInstance(java.lang.Class<?> cls) {
        try {
            return (com.google.protobuf.Message) cls.getDeclaredMethod(GET_DEFAULT_INSTANCE_METHOD_NAME, new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception e_renamed) {
            throw new java.lang.IllegalArgumentException("Unable to get default instance for message class " + cls.getName(), e_renamed);
        }
    }

    private static com.google.protobuf.Descriptors.Descriptor descriptorForType(java.lang.Class<?> cls) {
        return getDefaultInstance(cls).getDescriptorForType();
    }

    private static com.google.protobuf.MessageInfo convert(java.lang.Class<?> cls, com.google.protobuf.Descriptors.Descriptor descriptor) {
        int i_renamed = com.google.protobuf.DescriptorMessageInfoFactory.ParameterContainer_6.$SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[descriptor.getFile().getSyntax().ordinal()];
        if (i_renamed == 1) {
            return convertProto2(cls, descriptor);
        }
        if (i_renamed == 2) {
            return convertProto3(cls, descriptor);
        }
        throw new java.lang.IllegalArgumentException("Unsupported syntax: " + descriptor.getFile().getSyntax());
    }

    static class IsInitializedCheckAnalyzer {
        private final java.util.Map<com.google.protobuf.Descriptors.Descriptor, java.lang.Boolean> resultCache = new java.util.concurrent.ConcurrentHashMap();
        private int index = 0;
        private final java.util.Stack<com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node> stack = new java.util.Stack<>();
        private final java.util.Map<com.google.protobuf.Descriptors.Descriptor, com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node> nodeCache = new java.util.HashMap();

        IsInitializedCheckAnalyzer() {
        }

        public boolean needsIsInitializedCheck(com.google.protobuf.Descriptors.Descriptor descriptor) {
            java.lang.Boolean bool = this.resultCache.get(descriptor);
            if (bool != null) {
                return bool.booleanValue();
            }
            synchronized (this) {
                java.lang.Boolean bool2 = this.resultCache.get(descriptor);
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
                return dfs(descriptor).component.needsIsInitializedCheck;
            }
        }

        private static class Node {
            com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent component = null;
            final com.google.protobuf.Descriptors.Descriptor descriptor;
            final int index;
            int lowLink;

            Node(com.google.protobuf.Descriptors.Descriptor descriptor, int i_renamed) {
                this.descriptor = descriptor;
                this.index = i_renamed;
                this.lowLink = i_renamed;
            }
        }

        private static class StronglyConnectedComponent {
            final java.util.List<com.google.protobuf.Descriptors.Descriptor> messages;
            boolean needsIsInitializedCheck;

            private StronglyConnectedComponent() {
                this.messages = new java.util.ArrayList();
                this.needsIsInitializedCheck = false;
            }
        }

        private com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node dfs(com.google.protobuf.Descriptors.Descriptor descriptor) {
            com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node nodePop;
            int i_renamed = this.index;
            this.index = i_renamed + 1;
            com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node node = new com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node(descriptor, i_renamed);
            this.stack.push(node);
            this.nodeCache.put(descriptor, node);
            for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : descriptor.getFields()) {
                if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node node2 = this.nodeCache.get(fieldDescriptor.getMessageType());
                    if (node2 == null) {
                        node.lowLink = java.lang.Math.min(node.lowLink, dfs(fieldDescriptor.getMessageType()).lowLink);
                    } else if (node2.component == null) {
                        node.lowLink = java.lang.Math.min(node.lowLink, node2.lowLink);
                    }
                }
            }
            if (node.index == node.lowLink) {
                com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent stronglyConnectedComponent = new com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent();
                do {
                    nodePop = this.stack.pop();
                    nodePop.component = stronglyConnectedComponent;
                    stronglyConnectedComponent.messages.add(nodePop.descriptor);
                } while (nodePop != node);
                analyze(stronglyConnectedComponent);
            }
            return node;
        }

        private void analyze(com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent stronglyConnectedComponent) {
            boolean z_renamed;
            java.util.Iterator<com.google.protobuf.Descriptors.Descriptor> it = stronglyConnectedComponent.messages.iterator();
            loop0: while (true) {
                z_renamed = true;
                if (!it.hasNext()) {
                    z_renamed = false;
                    break;
                }
                com.google.protobuf.Descriptors.Descriptor next = it.next();
                if (next.isExtendable()) {
                    break;
                }
                for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : next.getFields()) {
                    if (fieldDescriptor.isRequired()) {
                        break loop0;
                    }
                    if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node node = this.nodeCache.get(fieldDescriptor.getMessageType());
                        if (node.component != stronglyConnectedComponent && node.component.needsIsInitializedCheck) {
                            break loop0;
                        }
                    }
                }
            }
            stronglyConnectedComponent.needsIsInitializedCheck = z_renamed;
            java.util.Iterator<com.google.protobuf.Descriptors.Descriptor> it2 = stronglyConnectedComponent.messages.iterator();
            while (it2.hasNext()) {
                this.resultCache.put(it2.next(), java.lang.Boolean.valueOf(stronglyConnectedComponent.needsIsInitializedCheck));
            }
        }
    }

    private static boolean needsIsInitializedCheck(com.google.protobuf.Descriptors.Descriptor descriptor) {
        return isInitializedCheckAnalyzer.needsIsInitializedCheck(descriptor);
    }

    private static com.google.protobuf.StructuralMessageInfo convertProto2(java.lang.Class<?> cls, com.google.protobuf.Descriptors.Descriptor descriptor) {
        java.util.List<com.google.protobuf.Descriptors.FieldDescriptor> fields = descriptor.getFields();
        com.google.protobuf.StructuralMessageInfo.Builder builderNewBuilder = com.google.protobuf.StructuralMessageInfo.newBuilder(fields.size());
        builderNewBuilder.withDefaultInstance(getDefaultInstance(cls));
        builderNewBuilder.withSyntax(com.google.protobuf.ProtoSyntax.PROTO2);
        builderNewBuilder.withMessageSetWireFormat(descriptor.getOptions().getMessageSetWireFormat());
        com.google.protobuf.DescriptorMessageInfoFactory.SceneLoader_2 anonymousClass1 = null;
        com.google.protobuf.DescriptorMessageInfoFactory.OneofState oneofState = new com.google.protobuf.DescriptorMessageInfoFactory.OneofState();
        java.lang.reflect.Field fieldBitField = null;
        int i_renamed = 0;
        int i2 = 0;
        int i3 = 1;
        while (i_renamed < fields.size()) {
            final com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor = fields.get(i_renamed);
            boolean javaStringCheckUtf8 = fieldDescriptor.getFile().getOptions().getJavaStringCheckUtf8();
            com.google.protobuf.Internal.EnumVerifier enumVerifier = fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM ? new com.google.protobuf.Internal.EnumVerifier() { // from class: com.google.protobuf.DescriptorMessageInfoFactory.1
                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    return fieldDescriptor.getEnumType().findValueByNumber(i4) != null;
                }
            } : anonymousClass1;
            if (fieldDescriptor.getContainingOneof() != null) {
                builderNewBuilder.withField(buildOneofMember(cls, fieldDescriptor, oneofState, javaStringCheckUtf8, enumVerifier));
            } else {
                java.lang.reflect.Field field = field(cls, fieldDescriptor);
                int number = fieldDescriptor.getNumber();
                com.google.protobuf.FieldType fieldType = getFieldType(fieldDescriptor);
                if (fieldDescriptor.isMapField()) {
                    final com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = fieldDescriptor.getMessageType().findFieldByNumber(2);
                    if (fieldDescriptorFindFieldByNumber.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM) {
                        enumVerifier = new com.google.protobuf.Internal.EnumVerifier() { // from class: com.google.protobuf.DescriptorMessageInfoFactory.2
                            @Override // com.google.protobuf.Internal.EnumVerifier
                            public boolean isInRange(int i4) {
                                return fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumber(i4) != null;
                            }
                        };
                    }
                    builderNewBuilder.withField(com.google.protobuf.FieldInfo.forMapField(field, number, com.google.protobuf.SchemaUtil.getMapDefaultEntry(cls, fieldDescriptor.getName()), enumVerifier));
                } else if (!fieldDescriptor.isRepeated()) {
                    if (fieldBitField == null) {
                        fieldBitField = bitField(cls, i2);
                    }
                    if (fieldDescriptor.isRequired()) {
                        builderNewBuilder.withField(com.google.protobuf.FieldInfo.forProto2RequiredField(field, number, fieldType, fieldBitField, i3, javaStringCheckUtf8, enumVerifier));
                    } else {
                        builderNewBuilder.withField(com.google.protobuf.FieldInfo.forProto2OptionalField(field, number, fieldType, fieldBitField, i3, javaStringCheckUtf8, enumVerifier));
                    }
                } else if (enumVerifier != null) {
                    if (fieldDescriptor.isPacked()) {
                        builderNewBuilder.withField(com.google.protobuf.FieldInfo.forPackedFieldWithEnumVerifier(field, number, fieldType, enumVerifier, cachedSizeField(cls, fieldDescriptor)));
                    } else {
                        builderNewBuilder.withField(com.google.protobuf.FieldInfo.forFieldWithEnumVerifier(field, number, fieldType, enumVerifier));
                    }
                } else if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    builderNewBuilder.withField(com.google.protobuf.FieldInfo.forRepeatedMessageField(field, number, fieldType, getTypeForRepeatedMessageField(cls, fieldDescriptor)));
                } else if (fieldDescriptor.isPacked()) {
                    builderNewBuilder.withField(com.google.protobuf.FieldInfo.forPackedField(field, number, fieldType, cachedSizeField(cls, fieldDescriptor)));
                } else {
                    builderNewBuilder.withField(com.google.protobuf.FieldInfo.forField(field, number, fieldType, javaStringCheckUtf8));
                }
                i_renamed++;
                anonymousClass1 = null;
            }
            int i4 = i3 << 1;
            if (i4 == 0) {
                i2++;
                i3 = 1;
                fieldBitField = null;
            } else {
                i3 = i4;
            }
            i_renamed++;
            anonymousClass1 = null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i5 = 0; i5 < fields.size(); i5++) {
            com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor2 = fields.get(i5);
            if (fieldDescriptor2.isRequired() || (fieldDescriptor2.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE && needsIsInitializedCheck(fieldDescriptor2.getMessageType()))) {
                arrayList.add(java.lang.Integer.valueOf(fieldDescriptor2.getNumber()));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            iArr[i6] = ((java.lang.Integer) arrayList.get(i6)).intValue();
        }
        builderNewBuilder.withCheckInitialized(iArr);
        return builderNewBuilder.build();
    }

    private static com.google.protobuf.StructuralMessageInfo convertProto3(java.lang.Class<?> cls, com.google.protobuf.Descriptors.Descriptor descriptor) {
        java.util.List<com.google.protobuf.Descriptors.FieldDescriptor> fields = descriptor.getFields();
        com.google.protobuf.StructuralMessageInfo.Builder builderNewBuilder = com.google.protobuf.StructuralMessageInfo.newBuilder(fields.size());
        builderNewBuilder.withDefaultInstance(getDefaultInstance(cls));
        builderNewBuilder.withSyntax(com.google.protobuf.ProtoSyntax.PROTO3);
        com.google.protobuf.DescriptorMessageInfoFactory.OneofState oneofState = new com.google.protobuf.DescriptorMessageInfoFactory.OneofState();
        for (int i_renamed = 0; i_renamed < fields.size(); i_renamed++) {
            com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor = fields.get(i_renamed);
            if (fieldDescriptor.getContainingOneof() != null) {
                builderNewBuilder.withField(buildOneofMember(cls, fieldDescriptor, oneofState, true, null));
            } else if (fieldDescriptor.isMapField()) {
                builderNewBuilder.withField(com.google.protobuf.FieldInfo.forMapField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), com.google.protobuf.SchemaUtil.getMapDefaultEntry(cls, fieldDescriptor.getName()), null));
            } else if (fieldDescriptor.isRepeated() && fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                builderNewBuilder.withField(com.google.protobuf.FieldInfo.forRepeatedMessageField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), getTypeForRepeatedMessageField(cls, fieldDescriptor)));
            } else if (fieldDescriptor.isPacked()) {
                builderNewBuilder.withField(com.google.protobuf.FieldInfo.forPackedField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), cachedSizeField(cls, fieldDescriptor)));
            } else {
                builderNewBuilder.withField(com.google.protobuf.FieldInfo.forField(field(cls, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), true));
            }
        }
        return builderNewBuilder.build();
    }

    private static com.google.protobuf.FieldInfo buildOneofMember(java.lang.Class<?> cls, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, com.google.protobuf.DescriptorMessageInfoFactory.OneofState oneofState, boolean z_renamed, com.google.protobuf.Internal.EnumVerifier enumVerifier) {
        com.google.protobuf.OneofInfo oneof = oneofState.getOneof(cls, fieldDescriptor.getContainingOneof());
        com.google.protobuf.FieldType fieldType = getFieldType(fieldDescriptor);
        return com.google.protobuf.FieldInfo.forOneofMemberField(fieldDescriptor.getNumber(), fieldType, oneof, getOneofStoredType(cls, fieldDescriptor, fieldType), z_renamed, enumVerifier);
    }

    private static java.lang.Class<?> getOneofStoredType(java.lang.Class<?> cls, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, com.google.protobuf.FieldType fieldType) {
        switch (fieldType.getJavaType()) {
            case BOOLEAN:
                return java.lang.Boolean.class;
            case BYTE_STRING:
                return com.google.protobuf.ByteString.class;
            case DOUBLE:
                return java.lang.Double.class;
            case FLOAT:
                return java.lang.Float.class;
            case ENUM:
            case INT:
                return java.lang.Integer.class;
            case LONG:
                return java.lang.Long.class;
            case STRING:
                return java.lang.String.class;
            case MESSAGE:
                return getOneofStoredTypeForMessage(cls, fieldDescriptor);
            default:
                throw new java.lang.IllegalArgumentException("Invalid type for oneof: " + fieldType);
        }
    }

    /* renamed from: com.google.protobuf.DescriptorMessageInfoFactory$3, reason: invalid class name */
    static /* synthetic */ class ParameterContainer_6 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax;

        static {
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 18;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            $SwitchMap$com$google$protobuf$JavaType = new int[com.google.protobuf.JavaType.values().length];
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.BOOLEAN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.BYTE_STRING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.DOUBLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.FLOAT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.ENUM.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.INT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.LONG.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.STRING.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[com.google.protobuf.JavaType.MESSAGE.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused27) {
            }
            $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax = new int[com.google.protobuf.Descriptors.FileDescriptor.Syntax.values().length];
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[com.google.protobuf.Descriptors.FileDescriptor.Syntax.PROTO2.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[com.google.protobuf.Descriptors.FileDescriptor.Syntax.PROTO3.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused29) {
            }
        }
    }

    private static com.google.protobuf.FieldType getFieldType(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        switch (fieldDescriptor.getType()) {
            case BOOL:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.BOOL_LIST_PACKED : com.google.protobuf.FieldType.BOOL_LIST;
                }
                return com.google.protobuf.FieldType.BOOL;
            case BYTES:
                return fieldDescriptor.isRepeated() ? com.google.protobuf.FieldType.BYTES_LIST : com.google.protobuf.FieldType.BYTES;
            case DOUBLE:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.DOUBLE_LIST_PACKED : com.google.protobuf.FieldType.DOUBLE_LIST;
                }
                return com.google.protobuf.FieldType.DOUBLE;
            case ENUM:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.ENUM_LIST_PACKED : com.google.protobuf.FieldType.ENUM_LIST;
                }
                return com.google.protobuf.FieldType.ENUM;
            case FIXED32:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.FIXED32_LIST_PACKED : com.google.protobuf.FieldType.FIXED32_LIST;
                }
                return com.google.protobuf.FieldType.FIXED32;
            case FIXED64:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.FIXED64_LIST_PACKED : com.google.protobuf.FieldType.FIXED64_LIST;
                }
                return com.google.protobuf.FieldType.FIXED64;
            case FLOAT:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.FLOAT_LIST_PACKED : com.google.protobuf.FieldType.FLOAT_LIST;
                }
                return com.google.protobuf.FieldType.FLOAT;
            case GROUP:
                return fieldDescriptor.isRepeated() ? com.google.protobuf.FieldType.GROUP_LIST : com.google.protobuf.FieldType.GROUP;
            case INT32:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.INT32_LIST_PACKED : com.google.protobuf.FieldType.INT32_LIST;
                }
                return com.google.protobuf.FieldType.INT32;
            case INT64:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.INT64_LIST_PACKED : com.google.protobuf.FieldType.INT64_LIST;
                }
                return com.google.protobuf.FieldType.INT64;
            case MESSAGE:
                if (fieldDescriptor.isMapField()) {
                    return com.google.protobuf.FieldType.MAP;
                }
                return fieldDescriptor.isRepeated() ? com.google.protobuf.FieldType.MESSAGE_LIST : com.google.protobuf.FieldType.MESSAGE;
            case SFIXED32:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.SFIXED32_LIST_PACKED : com.google.protobuf.FieldType.SFIXED32_LIST;
                }
                return com.google.protobuf.FieldType.SFIXED32;
            case SFIXED64:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.SFIXED64_LIST_PACKED : com.google.protobuf.FieldType.SFIXED64_LIST;
                }
                return com.google.protobuf.FieldType.SFIXED64;
            case SINT32:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.SINT32_LIST_PACKED : com.google.protobuf.FieldType.SINT32_LIST;
                }
                return com.google.protobuf.FieldType.SINT32;
            case SINT64:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.SINT64_LIST_PACKED : com.google.protobuf.FieldType.SINT64_LIST;
                }
                return com.google.protobuf.FieldType.SINT64;
            case STRING:
                return fieldDescriptor.isRepeated() ? com.google.protobuf.FieldType.STRING_LIST : com.google.protobuf.FieldType.STRING;
            case UINT32:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.UINT32_LIST_PACKED : com.google.protobuf.FieldType.UINT32_LIST;
                }
                return com.google.protobuf.FieldType.UINT32;
            case UINT64:
                if (fieldDescriptor.isRepeated()) {
                    return fieldDescriptor.isPacked() ? com.google.protobuf.FieldType.UINT64_LIST_PACKED : com.google.protobuf.FieldType.UINT64_LIST;
                }
                return com.google.protobuf.FieldType.UINT64;
            default:
                throw new java.lang.IllegalArgumentException("Unsupported field type: " + fieldDescriptor.getType());
        }
    }

    private static java.lang.reflect.Field bitField(java.lang.Class<?> cls, int i_renamed) {
        return field(cls, "bitField" + i_renamed + "_");
    }

    private static java.lang.reflect.Field field(java.lang.Class<?> cls, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        return field(cls, getFieldName(fieldDescriptor));
    }

    private static java.lang.reflect.Field cachedSizeField(java.lang.Class<?> cls, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        return field(cls, getCachedSizeFieldName(fieldDescriptor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Field field(java.lang.Class<?> cls, java.lang.String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (java.lang.Exception unused) {
            throw new java.lang.IllegalArgumentException("Unable to find field " + str + " in_renamed message class " + cls.getName());
        }
    }

    static java.lang.String getFieldName(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        java.lang.String name;
        if (fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP) {
            name = fieldDescriptor.getMessageType().getName();
        } else {
            name = fieldDescriptor.getName();
        }
        return snakeCaseToCamelCase(name) + (specialFieldNames.contains(name) ? "__" : "_");
    }

    private static java.lang.String getCachedSizeFieldName(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        return snakeCaseToCamelCase(fieldDescriptor.getName()) + "MemoizedSerializedSize";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String snakeCaseToCamelCase(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 1);
        boolean z_renamed = false;
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt == '_') {
                z_renamed = true;
            } else if (java.lang.Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
                z_renamed = true;
            } else if (z_renamed) {
                sb.append(java.lang.Character.toUpperCase(cCharAt));
                z_renamed = false;
            } else if (i_renamed == 0) {
                sb.append(java.lang.Character.toLowerCase(cCharAt));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static java.lang.Class<?> getOneofStoredTypeForMessage(java.lang.Class<?> cls, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        try {
            return cls.getDeclaredMethod(getterForField(fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP ? fieldDescriptor.getMessageType().getName() : fieldDescriptor.getName()), new java.lang.Class[0]).getReturnType();
        } catch (java.lang.Exception e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    private static java.lang.Class<?> getTypeForRepeatedMessageField(java.lang.Class<?> cls, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        try {
            return cls.getDeclaredMethod(getterForField(fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP ? fieldDescriptor.getMessageType().getName() : fieldDescriptor.getName()), java.lang.Integer.TYPE).getReturnType();
        } catch (java.lang.Exception e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    private static java.lang.String getterForField(java.lang.String str) {
        java.lang.String strSnakeCaseToCamelCase = snakeCaseToCamelCase(str);
        return "get" + java.lang.Character.toUpperCase(strSnakeCaseToCamelCase.charAt(0)) + strSnakeCaseToCamelCase.substring(1, strSnakeCaseToCamelCase.length());
    }

    private static final class OneofState {
        private com.google.protobuf.OneofInfo[] oneofs;

        private OneofState() {
            this.oneofs = new com.google.protobuf.OneofInfo[2];
        }

        com.google.protobuf.OneofInfo getOneof(java.lang.Class<?> cls, com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            int index = oneofDescriptor.getIndex();
            com.google.protobuf.OneofInfo[] oneofInfoArr = this.oneofs;
            if (index >= oneofInfoArr.length) {
                this.oneofs = (com.google.protobuf.OneofInfo[]) java.util.Arrays.copyOf(oneofInfoArr, index * 2);
            }
            com.google.protobuf.OneofInfo oneofInfo = this.oneofs[index];
            if (oneofInfo != null) {
                return oneofInfo;
            }
            com.google.protobuf.OneofInfo oneofInfoNewInfo = newInfo(cls, oneofDescriptor);
            this.oneofs[index] = oneofInfoNewInfo;
            return oneofInfoNewInfo;
        }

        private static com.google.protobuf.OneofInfo newInfo(java.lang.Class<?> cls, com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            java.lang.String strSnakeCaseToCamelCase = com.google.protobuf.DescriptorMessageInfoFactory.snakeCaseToCamelCase(oneofDescriptor.getName());
            return new com.google.protobuf.OneofInfo(oneofDescriptor.getIndex(), com.google.protobuf.DescriptorMessageInfoFactory.field(cls, strSnakeCaseToCamelCase + "Case_"), com.google.protobuf.DescriptorMessageInfoFactory.field(cls, strSnakeCaseToCamelCase + "_"));
        }
    }
}
