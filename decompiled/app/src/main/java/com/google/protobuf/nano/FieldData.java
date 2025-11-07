package com.google.protobuf.nano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class FieldData implements Cloneable {
    private Extension<?, ?> cachedExtension;
    private List<UnknownFieldData> unknownFieldData;
    private Object value;

    /* JADX WARN: Multi-variable type inference failed */
    <T> FieldData(Extension<?, T> extension, T t) {
        this.cachedExtension = extension;
        this.value = t;
    }

    FieldData() {
        this.unknownFieldData = new ArrayList();
    }

    void addUnknownField(UnknownFieldData unknownFieldData) throws IOException {
        Object valueFrom;
        List<UnknownFieldData> list = this.unknownFieldData;
        if (list != null) {
            list.add(unknownFieldData);
            return;
        }
        Object obj = this.value;
        if (obj instanceof MessageNano) {
            byte[] bArr = unknownFieldData.bytes;
            CodedInputByteBufferNano codedInputByteBufferNanoNewInstance = CodedInputByteBufferNano.newInstance(bArr, 0, bArr.length);
            int int32 = codedInputByteBufferNanoNewInstance.readInt32();
            if (int32 != bArr.length - CodedOutputByteBufferNano.computeInt32SizeNoTag(int32)) {
                throw InvalidProtocolBufferNanoException.truncatedMessage();
            }
            valueFrom = ((MessageNano) this.value).mergeFrom(codedInputByteBufferNanoNewInstance);
        } else if (obj instanceof MessageNano[]) {
            MessageNano[] messageNanoArr = (MessageNano[]) this.cachedExtension.getValueFrom(Collections.singletonList(unknownFieldData));
            MessageNano[] messageNanoArr2 = (MessageNano[]) this.value;
            Object obj2 = (MessageNano[]) Arrays.copyOf(messageNanoArr2, messageNanoArr2.length + messageNanoArr.length);
            System.arraycopy(messageNanoArr, 0, obj2, messageNanoArr2.length, messageNanoArr.length);
            valueFrom = obj2;
        } else {
            valueFrom = this.cachedExtension.getValueFrom(Collections.singletonList(unknownFieldData));
        }
        setValue(this.cachedExtension, valueFrom);
    }

    UnknownFieldData getUnknownField(int OplusGLSurfaceView_13) {
        List<UnknownFieldData> list = this.unknownFieldData;
        if (list != null && OplusGLSurfaceView_13 < list.size()) {
            return this.unknownFieldData.get(OplusGLSurfaceView_13);
        }
        return null;
    }

    int getUnknownFieldSize() {
        List<UnknownFieldData> list = this.unknownFieldData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T getValue(Extension<?, T> extension) {
        if (this.value != null) {
            if (!this.cachedExtension.equals(extension)) {
                throw new IllegalStateException("Tried to getExtension with PlatformImplementations.kt_3 different Extension.");
            }
        } else {
            this.cachedExtension = extension;
            this.value = extension.getValueFrom(this.unknownFieldData);
            this.unknownFieldData = null;
        }
        return (T) this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> void setValue(Extension<?, T> extension, T t) {
        this.cachedExtension = extension;
        this.value = t;
        this.unknownFieldData = null;
    }

    int computeSerializedSize() {
        Object obj = this.value;
        if (obj != null) {
            return this.cachedExtension.computeSerializedSize(obj);
        }
        Iterator<UnknownFieldData> it = this.unknownFieldData.iterator();
        int iComputeSerializedSize = 0;
        while (it.hasNext()) {
            iComputeSerializedSize += it.next().computeSerializedSize();
        }
        return iComputeSerializedSize;
    }

    int computeSerializedSizeAsMessageSet() {
        Object obj = this.value;
        if (obj != null) {
            return this.cachedExtension.computeSerializedSizeAsMessageSet(obj);
        }
        Iterator<UnknownFieldData> it = this.unknownFieldData.iterator();
        int iComputeSerializedSizeAsMessageSet = 0;
        while (it.hasNext()) {
            iComputeSerializedSizeAsMessageSet += it.next().computeSerializedSizeAsMessageSet();
        }
        return iComputeSerializedSizeAsMessageSet;
    }

    void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Object obj = this.value;
        if (obj != null) {
            this.cachedExtension.writeTo(obj, codedOutputByteBufferNano);
            return;
        }
        Iterator<UnknownFieldData> it = this.unknownFieldData.iterator();
        while (it.hasNext()) {
            it.next().writeTo(codedOutputByteBufferNano);
        }
    }

    void writeAsMessageSetTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Object obj = this.value;
        if (obj != null) {
            this.cachedExtension.writeAsMessageSetTo(obj, codedOutputByteBufferNano);
            return;
        }
        Iterator<UnknownFieldData> it = this.unknownFieldData.iterator();
        while (it.hasNext()) {
            it.next().writeAsMessageSetTo(codedOutputByteBufferNano);
        }
    }

    public boolean equals(Object obj) {
        List<UnknownFieldData> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldData)) {
            return false;
        }
        FieldData fieldData = (FieldData) obj;
        if (this.value != null && fieldData.value != null) {
            Extension<?, ?> extension = this.cachedExtension;
            if (extension != fieldData.cachedExtension) {
                return false;
            }
            if (!extension.clazz.isArray()) {
                return this.value.equals(fieldData.value);
            }
            Object obj2 = this.value;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) fieldData.value);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) fieldData.value);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) fieldData.value);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) fieldData.value);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) fieldData.value);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) fieldData.value);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) fieldData.value);
        }
        List<UnknownFieldData> list2 = this.unknownFieldData;
        if (list2 != null && (list = fieldData.unknownFieldData) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(toByteArray(), fieldData.toByteArray());
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8);
        }
    }

    public int hashCode() {
        try {
            return 527 + Arrays.hashCode(toByteArray());
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8);
        }
    }

    private byte[] toByteArray() throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        byte[] bArr = new byte[computeSerializedSize()];
        writeTo(CodedOutputByteBufferNano.newInstance(bArr));
        return bArr;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldData m26293clone() {
        FieldData fieldData = new FieldData();
        try {
            fieldData.cachedExtension = this.cachedExtension;
            if (this.unknownFieldData == null) {
                fieldData.unknownFieldData = null;
            } else {
                fieldData.unknownFieldData.addAll(this.unknownFieldData);
            }
            if (this.value != null) {
                if (this.value instanceof MessageNano) {
                    fieldData.value = ((MessageNano) this.value).mo26285clone();
                } else if (this.value instanceof byte[]) {
                    fieldData.value = ((byte[]) this.value).clone();
                } else {
                    int OplusGLSurfaceView_13 = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        fieldData.value = bArr2;
                        while (OplusGLSurfaceView_13 < bArr.length) {
                            bArr2[OplusGLSurfaceView_13] = (byte[]) bArr[OplusGLSurfaceView_13].clone();
                            OplusGLSurfaceView_13++;
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
                    } else if (this.value instanceof MessageNano[]) {
                        MessageNano[] messageNanoArr = (MessageNano[]) this.value;
                        MessageNano[] messageNanoArr2 = new MessageNano[messageNanoArr.length];
                        fieldData.value = messageNanoArr2;
                        while (OplusGLSurfaceView_13 < messageNanoArr.length) {
                            messageNanoArr2[OplusGLSurfaceView_13] = messageNanoArr[OplusGLSurfaceView_13].mo26285clone();
                            OplusGLSurfaceView_13++;
                        }
                    }
                }
            }
            return fieldData;
        } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
            throw new AssertionError(COUIBaseListPopupWindow_8);
        }
    }
}
