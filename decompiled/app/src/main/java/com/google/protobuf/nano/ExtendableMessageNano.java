package com.google.protobuf.nano;

/* loaded from: classes.dex */
public abstract class ExtendableMessageNano<M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>> extends com.google.protobuf.nano.MessageNano {
    protected com.google.protobuf.nano.FieldArray unknownFieldData;

    @Override // com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        if (this.unknownFieldData == null) {
            return 0;
        }
        int iComputeSerializedSize = 0;
        for (int i_renamed = 0; i_renamed < this.unknownFieldData.size(); i_renamed++) {
            iComputeSerializedSize += this.unknownFieldData.dataAt(i_renamed).computeSerializedSize();
        }
        return iComputeSerializedSize;
    }

    protected int computeSerializedSizeAsMessageSet() {
        if (this.unknownFieldData == null) {
            return 0;
        }
        int iComputeSerializedSizeAsMessageSet = 0;
        for (int i_renamed = 0; i_renamed < this.unknownFieldData.size(); i_renamed++) {
            iComputeSerializedSizeAsMessageSet += this.unknownFieldData.dataAt(i_renamed).computeSerializedSizeAsMessageSet();
        }
        return iComputeSerializedSizeAsMessageSet;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if (this.unknownFieldData == null) {
            return;
        }
        for (int i_renamed = 0; i_renamed < this.unknownFieldData.size(); i_renamed++) {
            this.unknownFieldData.dataAt(i_renamed).writeTo(codedOutputByteBufferNano);
        }
    }

    protected void writeAsMessageSetTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if (this.unknownFieldData == null) {
            return;
        }
        for (int i_renamed = 0; i_renamed < this.unknownFieldData.size(); i_renamed++) {
            this.unknownFieldData.dataAt(i_renamed).writeAsMessageSetTo(codedOutputByteBufferNano);
        }
    }

    public final boolean hasExtension(com.google.protobuf.nano.Extension<M_renamed, ?> extension) {
        com.google.protobuf.nano.FieldArray fieldArray = this.unknownFieldData;
        return (fieldArray == null || fieldArray.get(com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(extension.tag)) == null) ? false : true;
    }

    public final <T_renamed> T_renamed getExtension(com.google.protobuf.nano.Extension<M_renamed, T_renamed> extension) {
        com.google.protobuf.nano.FieldData fieldData;
        com.google.protobuf.nano.FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null || (fieldData = fieldArray.get(com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(extension.tag))) == null) {
            return null;
        }
        return (T_renamed) fieldData.getValue(extension);
    }

    public final <T_renamed> M_renamed setExtension(com.google.protobuf.nano.Extension<M_renamed, T_renamed> extension, T_renamed t_renamed) {
        int tagFieldNumber = com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(extension.tag);
        com.google.protobuf.nano.FieldData fieldData = null;
        if (t_renamed == null) {
            com.google.protobuf.nano.FieldArray fieldArray = this.unknownFieldData;
            if (fieldArray != null) {
                fieldArray.remove(tagFieldNumber);
                if (this.unknownFieldData.isEmpty()) {
                    this.unknownFieldData = null;
                }
            }
        } else {
            com.google.protobuf.nano.FieldArray fieldArray2 = this.unknownFieldData;
            if (fieldArray2 == null) {
                this.unknownFieldData = new com.google.protobuf.nano.FieldArray();
            } else {
                fieldData = fieldArray2.get(tagFieldNumber);
            }
            if (fieldData == null) {
                this.unknownFieldData.put(tagFieldNumber, new com.google.protobuf.nano.FieldData(extension, t_renamed));
            } else {
                fieldData.setValue(extension, t_renamed);
            }
        }
        return this;
    }

    protected final boolean storeUnknownField(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano, int i_renamed) throws java.io.IOException {
        int position = codedInputByteBufferNano.getPosition();
        if (!codedInputByteBufferNano.skipField(i_renamed)) {
            return false;
        }
        storeUnknownFieldData(com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(i_renamed), new com.google.protobuf.nano.UnknownFieldData(i_renamed, codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position)));
        return true;
    }

    private void storeUnknownFieldData(int i_renamed, com.google.protobuf.nano.UnknownFieldData unknownFieldData) throws java.io.IOException {
        com.google.protobuf.nano.FieldData fieldData;
        com.google.protobuf.nano.FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null) {
            this.unknownFieldData = new com.google.protobuf.nano.FieldArray();
            fieldData = null;
        } else {
            fieldData = fieldArray.get(i_renamed);
        }
        if (fieldData == null) {
            fieldData = new com.google.protobuf.nano.FieldData();
            this.unknownFieldData.put(i_renamed, fieldData);
        }
        fieldData.addUnknownField(unknownFieldData);
    }

    protected final boolean storeUnknownFieldAsMessageSet(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano, int i_renamed) throws java.io.IOException {
        if (i_renamed != com.google.protobuf.nano.WireFormatNano.MESSAGE_SET_ITEM_TAG) {
            return storeUnknownField(codedInputByteBufferNano, i_renamed);
        }
        int uInt32 = 0;
        byte[] data = null;
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == com.google.protobuf.nano.WireFormatNano.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = codedInputByteBufferNano.readUInt32();
            } else if (tag == com.google.protobuf.nano.WireFormatNano.MESSAGE_SET_MESSAGE_TAG) {
                int position = codedInputByteBufferNano.getPosition();
                codedInputByteBufferNano.skipField(tag);
                data = codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position);
            } else if (!codedInputByteBufferNano.skipField(tag)) {
                break;
            }
        }
        codedInputByteBufferNano.checkLastTagWas(com.google.protobuf.nano.WireFormatNano.MESSAGE_SET_ITEM_END_TAG);
        if (data == null || uInt32 == 0) {
            return true;
        }
        storeUnknownFieldData(uInt32, new com.google.protobuf.nano.UnknownFieldData(uInt32, data));
        return true;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: clone */
    public M_renamed mo19clone() throws java.lang.CloneNotSupportedException {
        M_renamed m_renamed = (M_renamed) super.mo19clone();
        com.google.protobuf.nano.InternalNano.cloneUnknownFieldData(this, m_renamed);
        return m_renamed;
    }

    public final com.google.protobuf.nano.FieldArray getUnknownFieldArray() {
        return this.unknownFieldData;
    }
}
