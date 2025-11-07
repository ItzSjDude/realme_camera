package com.google.protobuf;

/* loaded from: classes.dex */
final class MessageSetSchema<T_renamed> implements com.google.protobuf.Schema<T_renamed> {
    private final com.google.protobuf.MessageLite defaultInstance;
    private final com.google.protobuf.ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema, com.google.protobuf.ExtensionSchema<?> extensionSchema, com.google.protobuf.MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = extensionSchema.hasExtensions(messageLite);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
    }

    static <T_renamed> com.google.protobuf.MessageSetSchema<T_renamed> newSchema(com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema, com.google.protobuf.ExtensionSchema<?> extensionSchema, com.google.protobuf.MessageLite messageLite) {
        return new com.google.protobuf.MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageLite);
    }

    @Override // com.google.protobuf.Schema
    public T_renamed newInstance() {
        return (T_renamed) this.defaultInstance.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T_renamed t_renamed, T_renamed t2) {
        if (!this.unknownFieldSchema.getFromMessage(t_renamed).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t_renamed).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T_renamed t_renamed) {
        int iHashCode = this.unknownFieldSchema.getFromMessage(t_renamed).hashCode();
        return this.hasExtensions ? (iHashCode * 53) + this.extensionSchema.getExtensions(t_renamed).hashCode() : iHashCode;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T_renamed t_renamed, T_renamed t2) {
        com.google.protobuf.SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t_renamed, t2);
        if (this.hasExtensions) {
            com.google.protobuf.SchemaUtil.mergeExtensions(this.extensionSchema, t_renamed, t2);
        }
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException {
        java.util.Iterator it = this.extensionSchema.getExtensions(t_renamed).iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            com.google.protobuf.FieldSet.FieldDescriptorLite fieldDescriptorLite = (com.google.protobuf.FieldSet.FieldDescriptorLite) entry.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != com.google.protobuf.WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new java.lang.IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof com.google.protobuf.LazyField.LazyEntry) {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((com.google.protobuf.LazyField.LazyEntry) entry).getField().toByteString());
            } else {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), entry.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, t_renamed, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema, T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException {
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(t_renamed), writer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:58:0x00cb A_renamed[EDGE_INSN: B_renamed:58:0x00cb->B_renamed:34:0x00cb BREAK  A_renamed[LOOP:1: B_renamed:18:0x006d->B_renamed:61:0x006d], SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mergeFrom(T_renamed r11, byte[] r12, int r13, int r14, com.google.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            com.google.protobuf.UnknownFieldSetLite r2 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L11
            com.google.protobuf.UnknownFieldSetLite r1 = com.google.protobuf.UnknownFieldSetLite.newInstance()
            r0.unknownFields = r1
        L11:
            com.google.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.google.protobuf.FieldSet r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.protobuf.ArrayDecoders.decodeVarint32(r12, r13, r15)
            int r13 = r15.int1
            int r3 = com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_TAG
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.protobuf.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L66
            com.google.protobuf.ExtensionSchema<?> r2 = r10.extensionSchema
            com.google.protobuf.ExtensionRegistryLite r3 = r15.extensionRegistry
            com.google.protobuf.MessageLite r5 = r10.defaultInstance
            int r6 = com.google.protobuf.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.findExtensionByNumber(r3, r5, r6)
            r8 = r2
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L5b
            com.google.protobuf.Protobuf r13 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.Schema r13 = r13.schemaFor(r2)
            int r13 = com.google.protobuf.ArrayDecoders.decodeMessageField(r13, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.descriptor
            java.lang.Object r3 = r15.object1
            r11.setField(r2, r3)
            goto L64
        L5b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.ArrayDecoders.decodeUnknownField(r2, r3, r4, r5, r6, r7)
        L64:
            r2 = r8
            goto L19
        L66:
            int r13 = com.google.protobuf.ArrayDecoders.skipField(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r15)
            int r6 = r15.int1
            int r7 = com.google.protobuf.WireFormat.getTagFieldNumber(r6)
            int r8 = com.google.protobuf.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.protobuf.Protobuf r6 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.Schema r6 = r6.schemaFor(r7)
            int r4 = com.google.protobuf.ArrayDecoders.decodeMessageField(r6, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.descriptor
            java.lang.Object r7 = r15.object1
            r11.setField(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.protobuf.ArrayDecoders.decodeBytes(r12, r4, r15)
            java.lang.Object r3 = r15.object1
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r15)
            int r13 = r15.int1
            com.google.protobuf.ExtensionSchema<?> r2 = r10.extensionSchema
            com.google.protobuf.ExtensionRegistryLite r6 = r15.extensionRegistry
            com.google.protobuf.MessageLite r7 = r10.defaultInstance
            java.lang.Object r2 = r2.findExtensionByNumber(r6, r7, r13)
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L6d
        Lc1:
            int r7 = com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_END_TAG
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.protobuf.ArrayDecoders.skipField(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.protobuf.WireFormat.makeTag(r13, r5)
            r1.storeField(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.protobuf.InvalidProtocolBufferException r10 = com.google.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):void");
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T_renamed t_renamed, com.google.protobuf.Reader reader, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t_renamed, reader, extensionRegistryLite);
    }

    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema, com.google.protobuf.ExtensionSchema<ET> extensionSchema, T_renamed t_renamed, com.google.protobuf.Reader reader, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        UB builderFromMessage = unknownFieldSchema.getBuilderFromMessage(t_renamed);
        com.google.protobuf.FieldSet<ET> mutableExtensions = extensionSchema.getMutableExtensions(t_renamed);
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            try {
                if (!parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema, mutableExtensions, unknownFieldSchema, builderFromMessage)) {
                    return;
                }
            } finally {
                unknownFieldSchema.setBuilderToMessage(t_renamed, builderFromMessage);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T_renamed t_renamed) {
        this.unknownFieldSchema.makeImmutable(t_renamed);
        this.extensionSchema.makeImmutable(t_renamed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(com.google.protobuf.Reader reader, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, com.google.protobuf.ExtensionSchema<ET> extensionSchema, com.google.protobuf.FieldSet<ET> fieldSet, com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema, UB ub) throws java.io.IOException {
        int tag = reader.getTag();
        if (tag != com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_TAG) {
            if (com.google.protobuf.WireFormat.getTagWireType(tag) == 2) {
                java.lang.Object objFindExtensionByNumber = extensionSchema.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, com.google.protobuf.WireFormat.getTagFieldNumber(tag));
                if (objFindExtensionByNumber != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(reader, objFindExtensionByNumber, extensionRegistryLite, fieldSet);
                    return true;
                }
                return unknownFieldSchema.mergeOneFieldFrom(ub, reader);
            }
            return reader.skipField();
        }
        java.lang.Object objFindExtensionByNumber2 = null;
        int uInt32 = 0;
        com.google.protobuf.ByteString bytes = null;
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = reader.getTag();
            if (tag2 == com.google.protobuf.WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = reader.readUInt32();
                objFindExtensionByNumber2 = extensionSchema.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, uInt32);
            } else if (tag2 == com.google.protobuf.WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (objFindExtensionByNumber2 != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(reader, objFindExtensionByNumber2, extensionRegistryLite, fieldSet);
                } else {
                    bytes = reader.readBytes();
                }
            } else if (!reader.skipField()) {
                break;
            }
        }
        if (reader.getTag() != com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_END_TAG) {
            throw com.google.protobuf.InvalidProtocolBufferException.invalidEndTag();
        }
        if (bytes != null) {
            if (objFindExtensionByNumber2 != null) {
                extensionSchema.parseMessageSetItem(bytes, objFindExtensionByNumber2, extensionRegistryLite, fieldSet);
            } else {
                unknownFieldSchema.addLengthDelimited(ub, uInt32, bytes);
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T_renamed t_renamed) {
        return this.extensionSchema.getExtensions(t_renamed).isInitialized();
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T_renamed t_renamed) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, t_renamed) + 0;
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t_renamed).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema, T_renamed t_renamed) {
        return unknownFieldSchema.getSerializedSizeAsMessageSet(unknownFieldSchema.getFromMessage(t_renamed));
    }
}
