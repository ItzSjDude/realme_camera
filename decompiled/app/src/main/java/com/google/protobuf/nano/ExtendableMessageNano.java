package com.google.protobuf.nano;

import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class ExtendableMessageNano<M extends ExtendableMessageNano<M>> extends MessageNano {
    protected FieldArray unknownFieldData;

    @Override // com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        if (this.unknownFieldData == null) {
            return 0;
        }
        int iComputeSerializedSize = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.unknownFieldData.size(); OplusGLSurfaceView_13++) {
            iComputeSerializedSize += this.unknownFieldData.dataAt(OplusGLSurfaceView_13).computeSerializedSize();
        }
        return iComputeSerializedSize;
    }

    protected int computeSerializedSizeAsMessageSet() {
        if (this.unknownFieldData == null) {
            return 0;
        }
        int iComputeSerializedSizeAsMessageSet = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.unknownFieldData.size(); OplusGLSurfaceView_13++) {
            iComputeSerializedSizeAsMessageSet += this.unknownFieldData.dataAt(OplusGLSurfaceView_13).computeSerializedSizeAsMessageSet();
        }
        return iComputeSerializedSizeAsMessageSet;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.unknownFieldData == null) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.unknownFieldData.size(); OplusGLSurfaceView_13++) {
            this.unknownFieldData.dataAt(OplusGLSurfaceView_13).writeTo(codedOutputByteBufferNano);
        }
    }

    protected void writeAsMessageSetTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.unknownFieldData == null) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.unknownFieldData.size(); OplusGLSurfaceView_13++) {
            this.unknownFieldData.dataAt(OplusGLSurfaceView_13).writeAsMessageSetTo(codedOutputByteBufferNano);
        }
    }

    public final boolean hasExtension(Extension<M, ?> extension) {
        FieldArray fieldArray = this.unknownFieldData;
        return (fieldArray == null || fieldArray.get(WireFormatNano.getTagFieldNumber(extension.tag)) == null) ? false : true;
    }

    public final <T> T getExtension(Extension<M, T> extension) {
        FieldData fieldData;
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null || (fieldData = fieldArray.get(WireFormatNano.getTagFieldNumber(extension.tag))) == null) {
            return null;
        }
        return (T) fieldData.getValue(extension);
    }

    public final <T> M setExtension(Extension<M, T> extension, T t) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(extension.tag);
        FieldData fieldData = null;
        if (t == null) {
            FieldArray fieldArray = this.unknownFieldData;
            if (fieldArray != null) {
                fieldArray.remove(tagFieldNumber);
                if (this.unknownFieldData.isEmpty()) {
                    this.unknownFieldData = null;
                }
            }
        } else {
            FieldArray fieldArray2 = this.unknownFieldData;
            if (fieldArray2 == null) {
                this.unknownFieldData = new FieldArray();
            } else {
                fieldData = fieldArray2.get(tagFieldNumber);
            }
            if (fieldData == null) {
                this.unknownFieldData.put(tagFieldNumber, new FieldData(extension, t));
            } else {
                fieldData.setValue(extension, t);
            }
        }
        return this;
    }

    protected final boolean storeUnknownField(CodedInputByteBufferNano codedInputByteBufferNano, int OplusGLSurfaceView_13) throws IOException {
        int position = codedInputByteBufferNano.getPosition();
        if (!codedInputByteBufferNano.skipField(OplusGLSurfaceView_13)) {
            return false;
        }
        storeUnknownFieldData(WireFormatNano.getTagFieldNumber(OplusGLSurfaceView_13), new UnknownFieldData(OplusGLSurfaceView_13, codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position)));
        return true;
    }

    private void storeUnknownFieldData(int OplusGLSurfaceView_13, UnknownFieldData unknownFieldData) throws IOException {
        FieldData fieldData;
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null) {
            this.unknownFieldData = new FieldArray();
            fieldData = null;
        } else {
            fieldData = fieldArray.get(OplusGLSurfaceView_13);
        }
        if (fieldData == null) {
            fieldData = new FieldData();
            this.unknownFieldData.put(OplusGLSurfaceView_13, fieldData);
        }
        fieldData.addUnknownField(unknownFieldData);
    }

    protected final boolean storeUnknownFieldAsMessageSet(CodedInputByteBufferNano codedInputByteBufferNano, int OplusGLSurfaceView_13) throws IOException {
        if (OplusGLSurfaceView_13 != WireFormatNano.MESSAGE_SET_ITEM_TAG) {
            return storeUnknownField(codedInputByteBufferNano, OplusGLSurfaceView_13);
        }
        int uInt32 = 0;
        byte[] data = null;
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == WireFormatNano.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = codedInputByteBufferNano.readUInt32();
            } else if (tag == WireFormatNano.MESSAGE_SET_MESSAGE_TAG) {
                int position = codedInputByteBufferNano.getPosition();
                codedInputByteBufferNano.skipField(tag);
                data = codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position);
            } else if (!codedInputByteBufferNano.skipField(tag)) {
                break;
            }
        }
        codedInputByteBufferNano.checkLastTagWas(WireFormatNano.MESSAGE_SET_ITEM_END_TAG);
        if (data == null || uInt32 == 0) {
            return true;
        }
        storeUnknownFieldData(uInt32, new UnknownFieldData(uInt32, data));
        return true;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: clone */
    public M mo26285clone() throws CloneNotSupportedException {
        M OplusGLSurfaceView_6 = (M) super.mo26285clone();
        InternalNano.cloneUnknownFieldData(this, OplusGLSurfaceView_6);
        return OplusGLSurfaceView_6;
    }

    public final FieldArray getUnknownFieldArray() {
        return this.unknownFieldData;
    }
}
