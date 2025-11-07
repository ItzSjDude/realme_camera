package com.google.protobuf.nano;

/* loaded from: classes.dex */
class FieldData implements java.lang.Cloneable {
    private com.google.protobuf.nano.Extension<?, ?> cachedExtension;
    private java.util.List<com.google.protobuf.nano.UnknownFieldData> unknownFieldData;
    private java.lang.Object value;

    /* JADX WARN: Multi-variable type inference failed */
    <T_renamed> FieldData(com.google.protobuf.nano.Extension<?, T_renamed> extension, T_renamed t_renamed) {
        this.cachedExtension = extension;
        this.value = t_renamed;
    }

    FieldData() {
        this.unknownFieldData = new java.util.ArrayList();
    }

    void addUnknownField(com.google.protobuf.nano.UnknownFieldData unknownFieldData) throws java.io.IOException {
        java.lang.Object valueFrom;
        java.util.List<com.google.protobuf.nano.UnknownFieldData> list = this.unknownFieldData;
        if (list != null) {
            list.add(unknownFieldData);
            return;
        }
        java.lang.Object obj = this.value;
        if (obj instanceof com.google.protobuf.nano.MessageNano) {
            byte[] bArr = unknownFieldData.bytes;
            com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNanoNewInstance = com.google.protobuf.nano.CodedInputByteBufferNano.newInstance(bArr, 0, bArr.length);
            int int32 = codedInputByteBufferNanoNewInstance.readInt32();
            if (int32 != bArr.length - com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(int32)) {
                throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
            }
            valueFrom = ((com.google.protobuf.nano.MessageNano) this.value).mergeFrom(codedInputByteBufferNanoNewInstance);
        } else if (obj instanceof com.google.protobuf.nano.MessageNano[]) {
            com.google.protobuf.nano.MessageNano[] messageNanoArr = (com.google.protobuf.nano.MessageNano[]) this.cachedExtension.getValueFrom(java.util.Collections.singletonList(unknownFieldData));
            com.google.protobuf.nano.MessageNano[] messageNanoArr2 = (com.google.protobuf.nano.MessageNano[]) this.value;
            java.lang.Object obj2 = (com.google.protobuf.nano.MessageNano[]) java.util.Arrays.copyOf(messageNanoArr2, messageNanoArr2.length + messageNanoArr.length);
            java.lang.System.arraycopy(messageNanoArr, 0, obj2, messageNanoArr2.length, messageNanoArr.length);
            valueFrom = obj2;
        } else {
            valueFrom = this.cachedExtension.getValueFrom(java.util.Collections.singletonList(unknownFieldData));
        }
        setValue(this.cachedExtension, valueFrom);
    }

    com.google.protobuf.nano.UnknownFieldData getUnknownField(int i_renamed) {
        java.util.List<com.google.protobuf.nano.UnknownFieldData> list = this.unknownFieldData;
        if (list != null && i_renamed < list.size()) {
            return this.unknownFieldData.get(i_renamed);
        }
        return null;
    }

    int getUnknownFieldSize() {
        java.util.List<com.google.protobuf.nano.UnknownFieldData> list = this.unknownFieldData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T_renamed> T_renamed getValue(com.google.protobuf.nano.Extension<?, T_renamed> extension) {
        if (this.value != null) {
            if (!this.cachedExtension.equals(extension)) {
                throw new java.lang.IllegalStateException("Tried to getExtension with a_renamed different Extension.");
            }
        } else {
            this.cachedExtension = extension;
            this.value = extension.getValueFrom(this.unknownFieldData);
            this.unknownFieldData = null;
        }
        return (T_renamed) this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T_renamed> void setValue(com.google.protobuf.nano.Extension<?, T_renamed> extension, T_renamed t_renamed) {
        this.cachedExtension = extension;
        this.value = t_renamed;
        this.unknownFieldData = null;
    }

    int computeSerializedSize() {
        java.lang.Object obj = this.value;
        if (obj != null) {
            return this.cachedExtension.computeSerializedSize(obj);
        }
        java.util.Iterator<com.google.protobuf.nano.UnknownFieldData> it = this.unknownFieldData.iterator();
        int iComputeSerializedSize = 0;
        while (it.hasNext()) {
            iComputeSerializedSize += it.next().computeSerializedSize();
        }
        return iComputeSerializedSize;
    }

    int computeSerializedSizeAsMessageSet() {
        java.lang.Object obj = this.value;
        if (obj != null) {
            return this.cachedExtension.computeSerializedSizeAsMessageSet(obj);
        }
        java.util.Iterator<com.google.protobuf.nano.UnknownFieldData> it = this.unknownFieldData.iterator();
        int iComputeSerializedSizeAsMessageSet = 0;
        while (it.hasNext()) {
            iComputeSerializedSizeAsMessageSet += it.next().computeSerializedSizeAsMessageSet();
        }
        return iComputeSerializedSizeAsMessageSet;
    }

    void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        java.lang.Object obj = this.value;
        if (obj != null) {
            this.cachedExtension.writeTo(obj, codedOutputByteBufferNano);
            return;
        }
        java.util.Iterator<com.google.protobuf.nano.UnknownFieldData> it = this.unknownFieldData.iterator();
        while (it.hasNext()) {
            it.next().writeTo(codedOutputByteBufferNano);
        }
    }

    void writeAsMessageSetTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        java.lang.Object obj = this.value;
        if (obj != null) {
            this.cachedExtension.writeAsMessageSetTo(obj, codedOutputByteBufferNano);
            return;
        }
        java.util.Iterator<com.google.protobuf.nano.UnknownFieldData> it = this.unknownFieldData.iterator();
        while (it.hasNext()) {
            it.next().writeAsMessageSetTo(codedOutputByteBufferNano);
        }
    }

    public boolean equals(java.lang.Object obj) {
        java.util.List<com.google.protobuf.nano.UnknownFieldData> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.nano.FieldData)) {
            return false;
        }
        com.google.protobuf.nano.FieldData fieldData = (com.google.protobuf.nano.FieldData) obj;
        if (this.value != null && fieldData.value != null) {
            com.google.protobuf.nano.Extension<?, ?> extension = this.cachedExtension;
            if (extension != fieldData.cachedExtension) {
                return false;
            }
            if (!extension.clazz.isArray()) {
                return this.value.equals(fieldData.value);
            }
            java.lang.Object obj2 = this.value;
            if (obj2 instanceof byte[]) {
                return java.util.Arrays.equals((byte[]) obj2, (byte[]) fieldData.value);
            }
            if (obj2 instanceof int[]) {
                return java.util.Arrays.equals((int[]) obj2, (int[]) fieldData.value);
            }
            if (obj2 instanceof long[]) {
                return java.util.Arrays.equals((long[]) obj2, (long[]) fieldData.value);
            }
            if (obj2 instanceof float[]) {
                return java.util.Arrays.equals((float[]) obj2, (float[]) fieldData.value);
            }
            if (obj2 instanceof double[]) {
                return java.util.Arrays.equals((double[]) obj2, (double[]) fieldData.value);
            }
            if (obj2 instanceof boolean[]) {
                return java.util.Arrays.equals((boolean[]) obj2, (boolean[]) fieldData.value);
            }
            return java.util.Arrays.deepEquals((java.lang.Object[]) obj2, (java.lang.Object[]) fieldData.value);
        }
        java.util.List<com.google.protobuf.nano.UnknownFieldData> list2 = this.unknownFieldData;
        if (list2 != null && (list = fieldData.unknownFieldData) != null) {
            return list2.equals(list);
        }
        try {
            return java.util.Arrays.equals(toByteArray(), fieldData.toByteArray());
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed);
        }
    }

    public int hashCode() {
        try {
            return 527 + java.util.Arrays.hashCode(toByteArray());
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed);
        }
    }

    private byte[] toByteArray() throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        byte[] bArr = new byte[computeSerializedSize()];
        writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano.newInstance(bArr));
        return bArr;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.google.protobuf.nano.FieldData m27clone() {
        com.google.protobuf.nano.FieldData fieldData = new com.google.protobuf.nano.FieldData();
        try {
            fieldData.cachedExtension = this.cachedExtension;
            if (this.unknownFieldData == null) {
                fieldData.unknownFieldData = null;
            } else {
                fieldData.unknownFieldData.addAll(this.unknownFieldData);
            }
            if (this.value != null) {
                if (this.value instanceof com.google.protobuf.nano.MessageNano) {
                    fieldData.value = ((com.google.protobuf.nano.MessageNano) this.value).mo19clone();
                } else if (this.value instanceof byte[]) {
                    fieldData.value = ((byte[]) this.value).clone();
                } else {
                    int i_renamed = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        fieldData.value = bArr2;
                        while (i_renamed < bArr.length) {
                            bArr2[i_renamed] = (byte[]) bArr[i_renamed].clone();
                            i_renamed++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        fieldData.value = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        fieldData.value = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        fieldData.value = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        fieldData.value = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        fieldData.value = ((double[]) this.value).clone();
                    } else if (this.value instanceof com.google.protobuf.nano.MessageNano[]) {
                        com.google.protobuf.nano.MessageNano[] messageNanoArr = (com.google.protobuf.nano.MessageNano[]) this.value;
                        com.google.protobuf.nano.MessageNano[] messageNanoArr2 = new com.google.protobuf.nano.MessageNano[messageNanoArr.length];
                        fieldData.value = messageNanoArr2;
                        while (i_renamed < messageNanoArr.length) {
                            messageNanoArr2[i_renamed] = messageNanoArr[i_renamed].mo19clone();
                            i_renamed++;
                        }
                    }
                }
            }
            return fieldData;
        } catch (java.lang.CloneNotSupportedException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }
}
