package com.google.protobuf.nano;

/* loaded from: classes.dex */
public abstract class MessageNano {
    public static final int UNSET_ENUM_VALUE = Integer.MIN_VALUE;
    protected volatile int cachedSize = -1;

    public interface GeneratedMapEntry {
    }

    protected int computeSerializedSize() {
        return 0;
    }

    public abstract com.google.protobuf.nano.MessageNano mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException;

    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException {
    }

    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getSerializedSize() {
        int iComputeSerializedSize = computeSerializedSize();
        this.cachedSize = iComputeSerializedSize;
        return iComputeSerializedSize;
    }

    public static final byte[] toByteArray(com.google.protobuf.nano.MessageNano messageNano) {
        byte[] bArr = new byte[messageNano.getSerializedSize()];
        toByteArray(messageNano, bArr, 0, bArr.length);
        return bArr;
    }

    public static final void toByteArray(com.google.protobuf.nano.MessageNano messageNano, byte[] bArr, int i_renamed, int i2) {
        try {
            com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNanoNewInstance = com.google.protobuf.nano.CodedOutputByteBufferNano.newInstance(bArr, i_renamed, i2);
            messageNano.writeTo(codedOutputByteBufferNanoNewInstance);
            codedOutputByteBufferNanoNewInstance.checkNoSpaceLeft();
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException("Serializing to a_renamed byte array threw an_renamed IOException (should never happen).", e_renamed);
        }
    }

    public static final <T_renamed extends com.google.protobuf.nano.MessageNano> T_renamed mergeFrom(T_renamed t_renamed, byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
        return (T_renamed) mergeFrom(t_renamed, bArr, 0, bArr.length);
    }

    public static final <T_renamed extends com.google.protobuf.nano.MessageNano> T_renamed mergeFrom(T_renamed t_renamed, byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
        try {
            com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNanoNewInstance = com.google.protobuf.nano.CodedInputByteBufferNano.newInstance(bArr, i_renamed, i2);
            t_renamed.mergeFrom(codedInputByteBufferNanoNewInstance);
            codedInputByteBufferNanoNewInstance.checkLastTagWas(0);
            return t_renamed;
        } catch (com.google.protobuf.nano.InvalidProtocolBufferNanoException e_renamed) {
            throw e_renamed;
        } catch (java.io.IOException e2) {
            throw new java.lang.RuntimeException("Reading from a_renamed byte array threw an_renamed IOException (should never happen).", e2);
        }
    }

    public static final <T_renamed extends com.google.protobuf.nano.MessageNano> T_renamed cloneUsingSerialization(T_renamed t_renamed) {
        try {
            return (T_renamed) mergeFrom((com.google.protobuf.nano.MessageNano) t_renamed.getClass().getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]), toByteArray(t_renamed));
        } catch (com.google.protobuf.nano.InvalidProtocolBufferNanoException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.IllegalStateException(e2);
        } catch (java.lang.InstantiationException e3) {
            throw new java.lang.IllegalStateException(e3);
        } catch (java.lang.NoSuchMethodException e4) {
            throw new java.lang.IllegalStateException(e4);
        } catch (java.lang.reflect.InvocationTargetException e5) {
            throw new java.lang.IllegalStateException(e5);
        }
    }

    public static final boolean messageNanoEquals(com.google.protobuf.nano.MessageNano messageNano, com.google.protobuf.nano.MessageNano messageNano2) {
        int serializedSize;
        if (messageNano == messageNano2) {
            return true;
        }
        if (messageNano == null || messageNano2 == null || messageNano.getClass() != messageNano2.getClass() || messageNano2.getSerializedSize() != (serializedSize = messageNano.getSerializedSize())) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(messageNano, bArr, 0, serializedSize);
        toByteArray(messageNano2, bArr2, 0, serializedSize);
        return java.util.Arrays.equals(bArr, bArr2);
    }

    public java.lang.String toString() {
        return com.google.protobuf.nano.MessageNanoPrinter.print(this);
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.google.protobuf.nano.MessageNano mo19clone() throws java.lang.CloneNotSupportedException {
        return (com.google.protobuf.nano.MessageNano) super.clone();
    }
}
