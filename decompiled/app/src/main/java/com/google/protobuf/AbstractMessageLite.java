package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class AbstractMessageLite<MessageType extends com.google.protobuf.AbstractMessageLite<MessageType, BuilderType>, BuilderType extends com.google.protobuf.AbstractMessageLite.Builder<MessageType, BuilderType>> implements com.google.protobuf.MessageLite {
    protected int memoizedHashCode = 0;

    protected interface InternalOneOfEnum {
        int getNumber();
    }

    @Override // com.google.protobuf.MessageLite
    public com.google.protobuf.ByteString toByteString() {
        try {
            com.google.protobuf.ByteString.CodedBuilder codedBuilderNewCodedBuilder = com.google.protobuf.ByteString.newCodedBuilder(getSerializedSize());
            writeTo(codedBuilderNewCodedBuilder.getCodedOutput());
            return codedBuilderNewCodedBuilder.build();
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException(this.getSerializingExceptionMessage("ByteString"), e_renamed);
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
            throw new java.lang.RuntimeException(getSerializingExceptionMessage("byte array"), e_renamed);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        com.google.protobuf.CodedOutputStream codedOutputStreamNewInstance = com.google.protobuf.CodedOutputStream.newInstance(outputStream, com.google.protobuf.CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(java.io.OutputStream outputStream) throws java.io.IOException {
        int serializedSize = getSerializedSize();
        com.google.protobuf.CodedOutputStream codedOutputStreamNewInstance = com.google.protobuf.CodedOutputStream.newInstance(outputStream, com.google.protobuf.CodedOutputStream.computePreferredBufferSize(com.google.protobuf.CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
        codedOutputStreamNewInstance.writeRawVarint32(serializedSize);
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }

    int getMemoizedSerializedSize() {
        throw new java.lang.UnsupportedOperationException();
    }

    void setMemoizedSerializedSize(int i_renamed) {
        throw new java.lang.UnsupportedOperationException();
    }

    int getSerializedSize(com.google.protobuf.Schema schema) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int serializedSize = schema.getSerializedSize(this);
        setMemoizedSerializedSize(serializedSize);
        return serializedSize;
    }

    com.google.protobuf.UninitializedMessageException newUninitializedMessageException() {
        return new com.google.protobuf.UninitializedMessageException(this);
    }

    private java.lang.String getSerializingExceptionMessage(java.lang.String str) {
        return "Serializing " + getClass().getName() + " to a_renamed " + str + " threw an_renamed IOException (should never happen).";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkByteStringIsUtf8(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
        if (!byteString.isValidUtf8()) {
            throw new java.lang.IllegalArgumentException("Byte string is_renamed not UTF-8.");
        }
    }

    @java.lang.Deprecated
    protected static <T_renamed> void addAll(java.lang.Iterable<T_renamed> iterable, java.util.Collection<? super T_renamed> collection) {
        com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) collection);
    }

    protected static <T_renamed> void addAll(java.lang.Iterable<T_renamed> iterable, java.util.List<? super T_renamed> list) {
        com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) list);
    }

    public static abstract class Builder<MessageType extends com.google.protobuf.AbstractMessageLite<MessageType, BuilderType>, BuilderType extends com.google.protobuf.AbstractMessageLite.Builder<MessageType, BuilderType>> implements com.google.protobuf.MessageLite.Builder {
        @Override // 
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public abstract BuilderType mo23clone();

        protected abstract BuilderType internalMergeFrom(MessageType messagetype);

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType mergeFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (BuilderType) mergeFrom(codedInputStream, com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            try {
                com.google.protobuf.CodedInputStream codedInputStreamNewCodedInput = byteString.newCodedInput();
                mergeFrom(codedInputStreamNewCodedInput);
                codedInputStreamNewCodedInput.checkLastTagWas(0);
                return this;
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed;
            } catch (java.io.IOException e2) {
                throw new java.lang.RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            try {
                com.google.protobuf.CodedInputStream codedInputStreamNewCodedInput = byteString.newCodedInput();
                mergeFrom(codedInputStreamNewCodedInput, extensionRegistryLite);
                codedInputStreamNewCodedInput.checkLastTagWas(0);
                return this;
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed;
            } catch (java.io.IOException e2) {
                throw new java.lang.RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            try {
                com.google.protobuf.CodedInputStream codedInputStreamNewInstance = com.google.protobuf.CodedInputStream.newInstance(bArr, i_renamed, i2);
                mergeFrom(codedInputStreamNewInstance);
                codedInputStreamNewInstance.checkLastTagWas(0);
                return this;
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed;
            } catch (java.io.IOException e2) {
                throw new java.lang.RuntimeException(getReadingExceptionMessage("byte array"), e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(bArr, 0, bArr.length, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr, int i_renamed, int i2, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            try {
                com.google.protobuf.CodedInputStream codedInputStreamNewInstance = com.google.protobuf.CodedInputStream.newInstance(bArr, i_renamed, i2);
                mergeFrom(codedInputStreamNewInstance, extensionRegistryLite);
                codedInputStreamNewInstance.checkLastTagWas(0);
                return this;
            } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                throw e_renamed;
            } catch (java.io.IOException e2) {
                throw new java.lang.RuntimeException(getReadingExceptionMessage("byte array"), e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(java.io.InputStream inputStream) throws java.io.IOException {
            com.google.protobuf.CodedInputStream codedInputStreamNewInstance = com.google.protobuf.CodedInputStream.newInstance(inputStream);
            mergeFrom(codedInputStreamNewInstance);
            codedInputStreamNewInstance.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            com.google.protobuf.CodedInputStream codedInputStreamNewInstance = com.google.protobuf.CodedInputStream.newInstance(inputStream);
            mergeFrom(codedInputStreamNewInstance, extensionRegistryLite);
            codedInputStreamNewInstance.checkLastTagWas(0);
            return this;
        }

        static final class LimitedInputStream extends java.io.FilterInputStream {
            private int limit;

            LimitedInputStream(java.io.InputStream inputStream, int i_renamed) {
                super(inputStream);
                this.limit = i_renamed;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws java.io.IOException {
                return java.lang.Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws java.io.IOException {
                if (this.limit <= 0) {
                    return -1;
                }
                int i_renamed = super.read();
                if (i_renamed >= 0) {
                    this.limit--;
                }
                return i_renamed;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
                int i3 = this.limit;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i_renamed, java.lang.Math.min(i2, i3));
                if (i4 >= 0) {
                    this.limit -= i4;
                }
                return i4;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j_renamed) throws java.io.IOException {
                long jSkip = super.skip(java.lang.Math.min(j_renamed, this.limit));
                if (jSkip >= 0) {
                    this.limit = (int) (this.limit - jSkip);
                }
                return jSkip;
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int i_renamed = inputStream.read();
            if (i_renamed == -1) {
                return false;
            }
            mergeFrom((java.io.InputStream) new com.google.protobuf.AbstractMessageLite.Builder.LimitedInputStream(inputStream, com.google.protobuf.CodedInputStream.readRawVarint32(i_renamed, inputStream)), extensionRegistryLite);
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return mergeDelimitedFrom(inputStream, com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(com.google.protobuf.MessageLite messageLite) {
            if (!getDefaultInstanceForType().getClass().isInstance(messageLite)) {
                throw new java.lang.IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of_renamed the same type.");
            }
            return (BuilderType) internalMergeFrom((com.google.protobuf.AbstractMessageLite) messageLite);
        }

        private java.lang.String getReadingExceptionMessage(java.lang.String str) {
            return "Reading " + getClass().getName() + " from a_renamed " + str + " threw an_renamed IOException (should never happen).";
        }

        private static <T_renamed> void addAllCheckingNulls(java.lang.Iterable<T_renamed> iterable, java.util.List<? super T_renamed> list) {
            if ((list instanceof java.util.ArrayList) && (iterable instanceof java.util.Collection)) {
                ((java.util.ArrayList) list).ensureCapacity(list.size() + ((java.util.Collection) iterable).size());
            }
            int size = list.size();
            for (T_renamed t_renamed : iterable) {
                if (t_renamed == null) {
                    java.lang.String str = "Element at_renamed index " + (list.size() - size) + " is_renamed null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new java.lang.NullPointerException(str);
                }
                list.add(t_renamed);
            }
        }

        protected static com.google.protobuf.UninitializedMessageException newUninitializedMessageException(com.google.protobuf.MessageLite messageLite) {
            return new com.google.protobuf.UninitializedMessageException(messageLite);
        }

        @java.lang.Deprecated
        protected static <T_renamed> void addAll(java.lang.Iterable<T_renamed> iterable, java.util.Collection<? super T_renamed> collection) {
            addAll((java.lang.Iterable) iterable, (java.util.List) collection);
        }

        protected static <T_renamed> void addAll(java.lang.Iterable<T_renamed> iterable, java.util.List<? super T_renamed> list) {
            com.google.protobuf.Internal.checkNotNull(iterable);
            if (iterable instanceof com.google.protobuf.LazyStringList) {
                java.util.List<?> underlyingElements = ((com.google.protobuf.LazyStringList) iterable).getUnderlyingElements();
                com.google.protobuf.LazyStringList lazyStringList = (com.google.protobuf.LazyStringList) list;
                int size = list.size();
                for (java.lang.Object obj : underlyingElements) {
                    if (obj == null) {
                        java.lang.String str = "Element at_renamed index " + (lazyStringList.size() - size) + " is_renamed null.";
                        for (int size2 = lazyStringList.size() - 1; size2 >= size; size2--) {
                            lazyStringList.remove(size2);
                        }
                        throw new java.lang.NullPointerException(str);
                    }
                    if (obj instanceof com.google.protobuf.ByteString) {
                        lazyStringList.add((com.google.protobuf.ByteString) obj);
                    } else {
                        lazyStringList.add((java.lang.String) obj);
                    }
                }
                return;
            }
            if (iterable instanceof com.google.protobuf.PrimitiveNonBoxingCollection) {
                list.addAll((java.util.Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }
    }
}
