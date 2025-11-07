package com.google.android.apps.gsa.search.shared.service.proto.nano;

/* loaded from: classes.dex */
public final class ServiceEventProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto> implements java.lang.Cloneable {
    private static volatile com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto[] _emptyArray;
    private int bitField0_;
    private int eventId_;

    public static com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto[0];
                }
            }
        }
        return _emptyArray;
    }

    public int getEventId() {
        return this.eventId_;
    }

    public boolean hasEventId() {
        return (this.bitField0_ & 1) != 0;
    }

    public com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto clearEventId() {
        this.eventId_ = 0;
        this.bitField0_ &= -2;
        return this;
    }

    public com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto setEventId(int i_renamed) {
        this.bitField0_ |= 1;
        this.eventId_ = i_renamed;
        return this;
    }

    public ServiceEventProto() {
        clear();
    }

    public com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto clear() {
        this.bitField0_ = 0;
        this.eventId_ = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    /* renamed from: clone */
    public com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto mo19clone() {
        try {
            return (com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto) super.mo19clone();
        } catch (java.lang.CloneNotSupportedException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if ((this.bitField0_ & 1) != 0) {
            codedOutputByteBufferNano.writeInt32(1, this.eventId_);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return (this.bitField0_ & 1) != 0 ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(1, this.eventId_) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.eventId_ = codedInputByteBufferNano.readInt32();
                this.bitField0_ |= 1;
            }
        }
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
        return (com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto(), bArr);
    }

    public static com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
        return new com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto().mergeFrom(codedInputByteBufferNano);
    }
}
