package com.google.protobuf;

/* loaded from: classes.dex */
public final class UnknownFieldSet implements com.google.protobuf.MessageLite {
    private final java.util.Map<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> fields;
    private final java.util.Map<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> fieldsDescending;
    private static final com.google.protobuf.UnknownFieldSet defaultInstance = new com.google.protobuf.UnknownFieldSet(java.util.Collections.emptyMap(), java.util.Collections.emptyMap());
    private static final com.google.protobuf.UnknownFieldSet.Parser PARSER = new com.google.protobuf.UnknownFieldSet.Parser();

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return true;
    }

    private UnknownFieldSet() {
        this.fields = null;
        this.fieldsDescending = null;
    }

    public static com.google.protobuf.UnknownFieldSet.Builder newBuilder() {
        return com.google.protobuf.UnknownFieldSet.Builder.create();
    }

    public static com.google.protobuf.UnknownFieldSet.Builder newBuilder(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        return newBuilder().mergeFrom(unknownFieldSet);
    }

    public static com.google.protobuf.UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    UnknownFieldSet(java.util.Map<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> map, java.util.Map<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> map2) {
        this.fields = map;
        this.fieldsDescending = map2;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof com.google.protobuf.UnknownFieldSet) && this.fields.equals(((com.google.protobuf.UnknownFieldSet) obj).fields);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public java.util.Map<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> asMap() {
        return this.fields;
    }

    public boolean hasField(int i_renamed) {
        return this.fields.containsKey(java.lang.Integer.valueOf(i_renamed));
    }

    public com.google.protobuf.UnknownFieldSet.Field getField(int i_renamed) {
        com.google.protobuf.UnknownFieldSet.Field field = this.fields.get(java.lang.Integer.valueOf(i_renamed));
        return field == null ? com.google.protobuf.UnknownFieldSet.Field.getDefaultInstance() : field;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry : this.fields.entrySet()) {
            entry.getValue().writeTo(entry.getKey().intValue(), codedOutputStream);
        }
    }

    public java.lang.String toString() {
        return com.google.protobuf.TextFormat.printer().printToString(this);
    }

    @Override // com.google.protobuf.MessageLite
    public com.google.protobuf.ByteString toByteString() {
        try {
            com.google.protobuf.ByteString.CodedBuilder codedBuilderNewCodedBuilder = com.google.protobuf.ByteString.newCodedBuilder(getSerializedSize());
            writeTo(codedBuilderNewCodedBuilder.getCodedOutput());
            return codedBuilderNewCodedBuilder.build();
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException("Serializing to a_renamed ByteString threw an_renamed IOException (should never happen).", e_renamed);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            com.google.protobuf.CodedOutputStream codedOutputStreamNewInstance = com.google.protobuf.CodedOutputStream.newInstance(bArr);
            writeTo(codedOutputStreamNewInstance);
            codedOutputStreamNewInstance.checkNoSpaceLeft();
            return bArr;
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException("Serializing to a_renamed byte array threw an_renamed IOException (should never happen).", e_renamed);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        com.google.protobuf.CodedOutputStream codedOutputStreamNewInstance = com.google.protobuf.CodedOutputStream.newInstance(outputStream);
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(java.io.OutputStream outputStream) throws java.io.IOException {
        com.google.protobuf.CodedOutputStream codedOutputStreamNewInstance = com.google.protobuf.CodedOutputStream.newInstance(outputStream);
        codedOutputStreamNewInstance.writeRawVarint32(getSerializedSize());
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int serializedSize = 0;
        for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry : this.fields.entrySet()) {
            serializedSize += entry.getValue().getSerializedSize(entry.getKey().intValue());
        }
        return serializedSize;
    }

    public void writeAsMessageSetTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry : this.fields.entrySet()) {
            entry.getValue().writeAsMessageSetExtensionTo(entry.getKey().intValue(), codedOutputStream);
        }
    }

    void writeTo(com.google.protobuf.Writer writer) throws java.io.IOException {
        if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.DESCENDING) {
            for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry : this.fieldsDescending.entrySet()) {
                entry.getValue().writeTo(entry.getKey().intValue(), writer);
            }
            return;
        }
        for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry2 : this.fields.entrySet()) {
            entry2.getValue().writeTo(entry2.getKey().intValue(), writer);
        }
    }

    void writeAsMessageSetTo(com.google.protobuf.Writer writer) throws java.io.IOException {
        if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.DESCENDING) {
            for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry : this.fieldsDescending.entrySet()) {
                entry.getValue().writeAsMessageSetExtensionTo(entry.getKey().intValue(), writer);
            }
            return;
        }
        for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry2 : this.fields.entrySet()) {
            entry2.getValue().writeAsMessageSetExtensionTo(entry2.getKey().intValue(), writer);
        }
    }

    public int getSerializedSizeAsMessageSet() {
        int serializedSizeAsMessageSetExtension = 0;
        for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry : this.fields.entrySet()) {
            serializedSizeAsMessageSetExtension += entry.getValue().getSerializedSizeAsMessageSetExtension(entry.getKey().intValue());
        }
        return serializedSizeAsMessageSetExtension;
    }

    public static com.google.protobuf.UnknownFieldSet parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return newBuilder().mergeFrom(codedInputStream).build();
    }

    public static com.google.protobuf.UnknownFieldSet parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return newBuilder().mergeFrom(byteString).build();
    }

    public static com.google.protobuf.UnknownFieldSet parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return newBuilder().mergeFrom(bArr).build();
    }

    public static com.google.protobuf.UnknownFieldSet parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return newBuilder().mergeFrom(inputStream).build();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.UnknownFieldSet.Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.UnknownFieldSet.Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    public static final class Builder implements com.google.protobuf.MessageLite.Builder {
        private java.util.Map<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> fields;
        private com.google.protobuf.UnknownFieldSet.Field.Builder lastField;
        private int lastFieldNumber;

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }

        private Builder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static com.google.protobuf.UnknownFieldSet.Builder create() {
            com.google.protobuf.UnknownFieldSet.Builder builder = new com.google.protobuf.UnknownFieldSet.Builder();
            builder.reinitialize();
            return builder;
        }

        private com.google.protobuf.UnknownFieldSet.Field.Builder getFieldBuilder(int i_renamed) {
            com.google.protobuf.UnknownFieldSet.Field.Builder builder = this.lastField;
            if (builder != null) {
                int i2 = this.lastFieldNumber;
                if (i_renamed == i2) {
                    return builder;
                }
                addField(i2, builder.build());
            }
            if (i_renamed == 0) {
                return null;
            }
            com.google.protobuf.UnknownFieldSet.Field field = this.fields.get(java.lang.Integer.valueOf(i_renamed));
            this.lastFieldNumber = i_renamed;
            this.lastField = com.google.protobuf.UnknownFieldSet.Field.newBuilder();
            if (field != null) {
                this.lastField.mergeFrom(field);
            }
            return this.lastField;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet build() {
            com.google.protobuf.UnknownFieldSet unknownFieldSet;
            getFieldBuilder(0);
            if (this.fields.isEmpty()) {
                unknownFieldSet = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
            } else {
                unknownFieldSet = new com.google.protobuf.UnknownFieldSet(java.util.Collections.unmodifiableMap(this.fields), java.util.Collections.unmodifiableMap(((java.util.TreeMap) this.fields).descendingMap()));
            }
            this.fields = null;
            return unknownFieldSet;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet buildPartial() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.google.protobuf.UnknownFieldSet.Builder m25clone() {
            getFieldBuilder(0);
            return com.google.protobuf.UnknownFieldSet.newBuilder().mergeFrom(new com.google.protobuf.UnknownFieldSet(this.fields, java.util.Collections.unmodifiableMap(((java.util.TreeMap) this.fields).descendingMap())));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.UnknownFieldSet getDefaultInstanceForType() {
            return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        private void reinitialize() {
            this.fields = java.util.Collections.emptyMap();
            this.lastFieldNumber = 0;
            this.lastField = null;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder clear() {
            reinitialize();
            return this;
        }

        public com.google.protobuf.UnknownFieldSet.Builder clearField(int i_renamed) {
            if (i_renamed == 0) {
                throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
            }
            if (this.lastField != null && this.lastFieldNumber == i_renamed) {
                this.lastField = null;
                this.lastFieldNumber = 0;
            }
            if (this.fields.containsKey(java.lang.Integer.valueOf(i_renamed))) {
                this.fields.remove(java.lang.Integer.valueOf(i_renamed));
            }
            return this;
        }

        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            if (unknownFieldSet != com.google.protobuf.UnknownFieldSet.getDefaultInstance()) {
                for (java.util.Map.Entry entry : unknownFieldSet.fields.entrySet()) {
                    mergeField(((java.lang.Integer) entry.getKey()).intValue(), (com.google.protobuf.UnknownFieldSet.Field) entry.getValue());
                }
            }
            return this;
        }

        public com.google.protobuf.UnknownFieldSet.Builder mergeField(int i_renamed, com.google.protobuf.UnknownFieldSet.Field field) {
            if (i_renamed == 0) {
                throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
            }
            if (hasField(i_renamed)) {
                getFieldBuilder(i_renamed).mergeFrom(field);
            } else {
                addField(i_renamed, field);
            }
            return this;
        }

        public com.google.protobuf.UnknownFieldSet.Builder mergeVarintField(int i_renamed, int i2) {
            if (i_renamed == 0) {
                throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
            }
            getFieldBuilder(i_renamed).addVarint(i2);
            return this;
        }

        public com.google.protobuf.UnknownFieldSet.Builder mergeLengthDelimitedField(int i_renamed, com.google.protobuf.ByteString byteString) {
            if (i_renamed == 0) {
                throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
            }
            getFieldBuilder(i_renamed).addLengthDelimited(byteString);
            return this;
        }

        public boolean hasField(int i_renamed) {
            if (i_renamed != 0) {
                return i_renamed == this.lastFieldNumber || this.fields.containsKey(java.lang.Integer.valueOf(i_renamed));
            }
            throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
        }

        public com.google.protobuf.UnknownFieldSet.Builder addField(int i_renamed, com.google.protobuf.UnknownFieldSet.Field field) {
            if (i_renamed == 0) {
                throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
            }
            if (this.lastField != null && this.lastFieldNumber == i_renamed) {
                this.lastField = null;
                this.lastFieldNumber = 0;
            }
            if (this.fields.isEmpty()) {
                this.fields = new java.util.TreeMap();
            }
            this.fields.put(java.lang.Integer.valueOf(i_renamed), field);
            return this;
        }

        public java.util.Map<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> asMap() {
            getFieldBuilder(0);
            return java.util.Collections.unmodifiableMap(this.fields);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            int tag;
            do {
                tag = codedInputStream.readTag();
                if (tag == 0) {
                    break;
                }
            } while (mergeFieldFrom(tag, codedInputStream));
            return this;
        }

        public boolean mergeFieldFrom(int i_renamed, com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            int tagFieldNumber = com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed);
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                getFieldBuilder(tagFieldNumber).addVarint(codedInputStream.readInt64());
                return true;
            }
            if (tagWireType == 1) {
                getFieldBuilder(tagFieldNumber).addFixed64(codedInputStream.readFixed64());
                return true;
            }
            if (tagWireType == 2) {
                getFieldBuilder(tagFieldNumber).addLengthDelimited(codedInputStream.readBytes());
                return true;
            }
            if (tagWireType == 3) {
                com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
                codedInputStream.readGroup(tagFieldNumber, builderNewBuilder, com.google.protobuf.ExtensionRegistry.getEmptyRegistry());
                getFieldBuilder(tagFieldNumber).addGroup(builderNewBuilder.build());
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                getFieldBuilder(tagFieldNumber).addFixed32(codedInputStream.readFixed32());
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            try {
                com.google.protobuf.CodedInputStream codedInputStreamNewCodedInput = byteString.newCodedInput();
                mergeFrom(codedInputStreamNewCodedInput);
                codedInputStreamNewCodedInput.checkLastTagWas(0);
                return this;
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed;
            } catch (java.io.IOException e2) {
                throw new java.lang.RuntimeException("Reading from a_renamed ByteString threw an_renamed IOException (should never happen).", e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            try {
                com.google.protobuf.CodedInputStream codedInputStreamNewInstance = com.google.protobuf.CodedInputStream.newInstance(bArr);
                mergeFrom(codedInputStreamNewInstance);
                codedInputStreamNewInstance.checkLastTagWas(0);
                return this;
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed;
            } catch (java.io.IOException e2) {
                throw new java.lang.RuntimeException("Reading from a_renamed byte array threw an_renamed IOException (should never happen).", e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(java.io.InputStream inputStream) throws java.io.IOException {
            com.google.protobuf.CodedInputStream codedInputStreamNewInstance = com.google.protobuf.CodedInputStream.newInstance(inputStream);
            mergeFrom(codedInputStreamNewInstance);
            codedInputStreamNewInstance.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            int i_renamed = inputStream.read();
            if (i_renamed == -1) {
                return false;
            }
            mergeFrom((java.io.InputStream) new com.google.protobuf.AbstractMessageLite.Builder.LimitedInputStream(inputStream, com.google.protobuf.CodedInputStream.readRawVarint32(i_renamed, inputStream)));
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return mergeDelimitedFrom(inputStream);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return mergeFrom(codedInputStream);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return mergeFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            try {
                com.google.protobuf.CodedInputStream codedInputStreamNewInstance = com.google.protobuf.CodedInputStream.newInstance(bArr, i_renamed, i2);
                mergeFrom(codedInputStreamNewInstance);
                codedInputStreamNewInstance.checkLastTagWas(0);
                return this;
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed;
            } catch (java.io.IOException e2) {
                throw new java.lang.RuntimeException("Reading from a_renamed byte array threw an_renamed IOException (should never happen).", e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return mergeFrom(bArr);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(byte[] bArr, int i_renamed, int i2, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return mergeFrom(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return mergeFrom(inputStream);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.MessageLite messageLite) {
            if (messageLite instanceof com.google.protobuf.UnknownFieldSet) {
                return mergeFrom((com.google.protobuf.UnknownFieldSet) messageLite);
            }
            throw new java.lang.IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of_renamed the same type.");
        }
    }

    public static final class Field {
        private static final com.google.protobuf.UnknownFieldSet.Field fieldDefaultInstance = newBuilder().build();
        private java.util.List<java.lang.Integer> fixed32;
        private java.util.List<java.lang.Long> fixed64;
        private java.util.List<com.google.protobuf.UnknownFieldSet> group;
        private java.util.List<com.google.protobuf.ByteString> lengthDelimited;
        private java.util.List<java.lang.Long> varint;

        private Field() {
        }

        public static com.google.protobuf.UnknownFieldSet.Field.Builder newBuilder() {
            return com.google.protobuf.UnknownFieldSet.Field.Builder.create();
        }

        public static com.google.protobuf.UnknownFieldSet.Field.Builder newBuilder(com.google.protobuf.UnknownFieldSet.Field field) {
            return newBuilder().mergeFrom(field);
        }

        public static com.google.protobuf.UnknownFieldSet.Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        public java.util.List<java.lang.Long> getVarintList() {
            return this.varint;
        }

        public java.util.List<java.lang.Integer> getFixed32List() {
            return this.fixed32;
        }

        public java.util.List<java.lang.Long> getFixed64List() {
            return this.fixed64;
        }

        public java.util.List<com.google.protobuf.ByteString> getLengthDelimitedList() {
            return this.lengthDelimited;
        }

        public java.util.List<com.google.protobuf.UnknownFieldSet> getGroupList() {
            return this.group;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof com.google.protobuf.UnknownFieldSet.Field) {
                return java.util.Arrays.equals(getIdentityArray(), ((com.google.protobuf.UnknownFieldSet.Field) obj).getIdentityArray());
            }
            return false;
        }

        public int hashCode() {
            return java.util.Arrays.hashCode(getIdentityArray());
        }

        private java.lang.Object[] getIdentityArray() {
            return new java.lang.Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
        }

        public com.google.protobuf.ByteString toByteString(int i_renamed) {
            try {
                com.google.protobuf.ByteString.CodedBuilder codedBuilderNewCodedBuilder = com.google.protobuf.ByteString.newCodedBuilder(getSerializedSize(i_renamed));
                writeTo(i_renamed, codedBuilderNewCodedBuilder.getCodedOutput());
                return codedBuilderNewCodedBuilder.build();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.RuntimeException("Serializing to a_renamed ByteString should never fail with an_renamed IOException", e_renamed);
            }
        }

        public void writeTo(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            java.util.Iterator<java.lang.Long> it = this.varint.iterator();
            while (it.hasNext()) {
                codedOutputStream.writeUInt64(i_renamed, it.next().longValue());
            }
            java.util.Iterator<java.lang.Integer> it2 = this.fixed32.iterator();
            while (it2.hasNext()) {
                codedOutputStream.writeFixed32(i_renamed, it2.next().intValue());
            }
            java.util.Iterator<java.lang.Long> it3 = this.fixed64.iterator();
            while (it3.hasNext()) {
                codedOutputStream.writeFixed64(i_renamed, it3.next().longValue());
            }
            java.util.Iterator<com.google.protobuf.ByteString> it4 = this.lengthDelimited.iterator();
            while (it4.hasNext()) {
                codedOutputStream.writeBytes(i_renamed, it4.next());
            }
            java.util.Iterator<com.google.protobuf.UnknownFieldSet> it5 = this.group.iterator();
            while (it5.hasNext()) {
                codedOutputStream.writeGroup(i_renamed, it5.next());
            }
        }

        public int getSerializedSize(int i_renamed) {
            java.util.Iterator<java.lang.Long> it = this.varint.iterator();
            int iComputeGroupSize = 0;
            while (it.hasNext()) {
                iComputeGroupSize += com.google.protobuf.CodedOutputStream.computeUInt64Size(i_renamed, it.next().longValue());
            }
            java.util.Iterator<java.lang.Integer> it2 = this.fixed32.iterator();
            while (it2.hasNext()) {
                iComputeGroupSize += com.google.protobuf.CodedOutputStream.computeFixed32Size(i_renamed, it2.next().intValue());
            }
            java.util.Iterator<java.lang.Long> it3 = this.fixed64.iterator();
            while (it3.hasNext()) {
                iComputeGroupSize += com.google.protobuf.CodedOutputStream.computeFixed64Size(i_renamed, it3.next().longValue());
            }
            java.util.Iterator<com.google.protobuf.ByteString> it4 = this.lengthDelimited.iterator();
            while (it4.hasNext()) {
                iComputeGroupSize += com.google.protobuf.CodedOutputStream.computeBytesSize(i_renamed, it4.next());
            }
            java.util.Iterator<com.google.protobuf.UnknownFieldSet> it5 = this.group.iterator();
            while (it5.hasNext()) {
                iComputeGroupSize += com.google.protobuf.CodedOutputStream.computeGroupSize(i_renamed, it5.next());
            }
            return iComputeGroupSize;
        }

        public void writeAsMessageSetExtensionTo(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            java.util.Iterator<com.google.protobuf.ByteString> it = this.lengthDelimited.iterator();
            while (it.hasNext()) {
                codedOutputStream.writeRawMessageSetExtension(i_renamed, it.next());
            }
        }

        void writeTo(int i_renamed, com.google.protobuf.Writer writer) throws java.io.IOException {
            writer.writeInt64List(i_renamed, this.varint, false);
            writer.writeFixed32List(i_renamed, this.fixed32, false);
            writer.writeFixed64List(i_renamed, this.fixed64, false);
            writer.writeBytesList(i_renamed, this.lengthDelimited);
            if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.ASCENDING) {
                for (int i2 = 0; i2 < this.group.size(); i2++) {
                    writer.writeStartGroup(i_renamed);
                    this.group.get(i2).writeTo(writer);
                    writer.writeEndGroup(i_renamed);
                }
                return;
            }
            for (int size = this.group.size() - 1; size >= 0; size--) {
                writer.writeEndGroup(i_renamed);
                this.group.get(size).writeTo(writer);
                writer.writeStartGroup(i_renamed);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeAsMessageSetExtensionTo(int i_renamed, com.google.protobuf.Writer writer) throws java.io.IOException {
            if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.DESCENDING) {
                java.util.List<com.google.protobuf.ByteString> list = this.lengthDelimited;
                java.util.ListIterator<com.google.protobuf.ByteString> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    writer.writeMessageSetItem(i_renamed, listIterator.previous());
                }
                return;
            }
            java.util.Iterator<com.google.protobuf.ByteString> it = this.lengthDelimited.iterator();
            while (it.hasNext()) {
                writer.writeMessageSetItem(i_renamed, it.next());
            }
        }

        public int getSerializedSizeAsMessageSetExtension(int i_renamed) {
            java.util.Iterator<com.google.protobuf.ByteString> it = this.lengthDelimited.iterator();
            int iComputeRawMessageSetExtensionSize = 0;
            while (it.hasNext()) {
                iComputeRawMessageSetExtensionSize += com.google.protobuf.CodedOutputStream.computeRawMessageSetExtensionSize(i_renamed, it.next());
            }
            return iComputeRawMessageSetExtensionSize;
        }

        public static final class Builder {
            private com.google.protobuf.UnknownFieldSet.Field result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static com.google.protobuf.UnknownFieldSet.Field.Builder create() {
                com.google.protobuf.UnknownFieldSet.Field.Builder builder = new com.google.protobuf.UnknownFieldSet.Field.Builder();
                builder.result = new com.google.protobuf.UnknownFieldSet.Field();
                return builder;
            }

            public com.google.protobuf.UnknownFieldSet.Field build() {
                if (this.result.varint == null) {
                    this.result.varint = java.util.Collections.emptyList();
                } else {
                    com.google.protobuf.UnknownFieldSet.Field field = this.result;
                    field.varint = java.util.Collections.unmodifiableList(field.varint);
                }
                if (this.result.fixed32 == null) {
                    this.result.fixed32 = java.util.Collections.emptyList();
                } else {
                    com.google.protobuf.UnknownFieldSet.Field field2 = this.result;
                    field2.fixed32 = java.util.Collections.unmodifiableList(field2.fixed32);
                }
                if (this.result.fixed64 == null) {
                    this.result.fixed64 = java.util.Collections.emptyList();
                } else {
                    com.google.protobuf.UnknownFieldSet.Field field3 = this.result;
                    field3.fixed64 = java.util.Collections.unmodifiableList(field3.fixed64);
                }
                if (this.result.lengthDelimited == null) {
                    this.result.lengthDelimited = java.util.Collections.emptyList();
                } else {
                    com.google.protobuf.UnknownFieldSet.Field field4 = this.result;
                    field4.lengthDelimited = java.util.Collections.unmodifiableList(field4.lengthDelimited);
                }
                if (this.result.group == null) {
                    this.result.group = java.util.Collections.emptyList();
                } else {
                    com.google.protobuf.UnknownFieldSet.Field field5 = this.result;
                    field5.group = java.util.Collections.unmodifiableList(field5.group);
                }
                com.google.protobuf.UnknownFieldSet.Field field6 = this.result;
                this.result = null;
                return field6;
            }

            public com.google.protobuf.UnknownFieldSet.Field.Builder clear() {
                this.result = new com.google.protobuf.UnknownFieldSet.Field();
                return this;
            }

            public com.google.protobuf.UnknownFieldSet.Field.Builder mergeFrom(com.google.protobuf.UnknownFieldSet.Field field) {
                if (!field.varint.isEmpty()) {
                    if (this.result.varint == null) {
                        this.result.varint = new java.util.ArrayList();
                    }
                    this.result.varint.addAll(field.varint);
                }
                if (!field.fixed32.isEmpty()) {
                    if (this.result.fixed32 == null) {
                        this.result.fixed32 = new java.util.ArrayList();
                    }
                    this.result.fixed32.addAll(field.fixed32);
                }
                if (!field.fixed64.isEmpty()) {
                    if (this.result.fixed64 == null) {
                        this.result.fixed64 = new java.util.ArrayList();
                    }
                    this.result.fixed64.addAll(field.fixed64);
                }
                if (!field.lengthDelimited.isEmpty()) {
                    if (this.result.lengthDelimited == null) {
                        this.result.lengthDelimited = new java.util.ArrayList();
                    }
                    this.result.lengthDelimited.addAll(field.lengthDelimited);
                }
                if (!field.group.isEmpty()) {
                    if (this.result.group == null) {
                        this.result.group = new java.util.ArrayList();
                    }
                    this.result.group.addAll(field.group);
                }
                return this;
            }

            public com.google.protobuf.UnknownFieldSet.Field.Builder addVarint(long j_renamed) {
                if (this.result.varint == null) {
                    this.result.varint = new java.util.ArrayList();
                }
                this.result.varint.add(java.lang.Long.valueOf(j_renamed));
                return this;
            }

            public com.google.protobuf.UnknownFieldSet.Field.Builder addFixed32(int i_renamed) {
                if (this.result.fixed32 == null) {
                    this.result.fixed32 = new java.util.ArrayList();
                }
                this.result.fixed32.add(java.lang.Integer.valueOf(i_renamed));
                return this;
            }

            public com.google.protobuf.UnknownFieldSet.Field.Builder addFixed64(long j_renamed) {
                if (this.result.fixed64 == null) {
                    this.result.fixed64 = new java.util.ArrayList();
                }
                this.result.fixed64.add(java.lang.Long.valueOf(j_renamed));
                return this;
            }

            public com.google.protobuf.UnknownFieldSet.Field.Builder addLengthDelimited(com.google.protobuf.ByteString byteString) {
                if (this.result.lengthDelimited == null) {
                    this.result.lengthDelimited = new java.util.ArrayList();
                }
                this.result.lengthDelimited.add(byteString);
                return this;
            }

            public com.google.protobuf.UnknownFieldSet.Field.Builder addGroup(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                if (this.result.group == null) {
                    this.result.group = new java.util.ArrayList();
                }
                this.result.group.add(unknownFieldSet);
                return this;
            }
        }
    }

    public static final class Parser extends com.google.protobuf.AbstractParser<com.google.protobuf.UnknownFieldSet> {
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.UnknownFieldSet parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                builderNewBuilder.mergeFrom(codedInputStream);
                return builderNewBuilder.buildPartial();
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed.setUnfinishedMessage(builderNewBuilder.buildPartial());
            } catch (java.io.IOException e2) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(builderNewBuilder.buildPartial());
            }
        }
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final com.google.protobuf.UnknownFieldSet.Parser getParserForType() {
        return PARSER;
    }
}
