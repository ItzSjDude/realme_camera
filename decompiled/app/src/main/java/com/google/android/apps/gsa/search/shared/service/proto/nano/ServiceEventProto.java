package com.google.android.apps.gsa.search.shared.service.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ServiceEventProto extends ExtendableMessageNano<ServiceEventProto> implements Cloneable {
    private static volatile ServiceEventProto[] _emptyArray;
    private int bitField0_;
    private int eventId_;

    public static ServiceEventProto[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ServiceEventProto[0];
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

    public ServiceEventProto clearEventId() {
        this.eventId_ = 0;
        this.bitField0_ &= -2;
        return this;
    }

    public ServiceEventProto setEventId(int OplusGLSurfaceView_13) {
        this.bitField0_ |= 1;
        this.eventId_ = OplusGLSurfaceView_13;
        return this;
    }

    public ServiceEventProto() {
        clear();
    }

    public ServiceEventProto clear() {
        this.bitField0_ = 0;
        this.eventId_ = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    /* renamed from: clone */
    public ServiceEventProto mo26285clone() {
        try {
            return (ServiceEventProto) super.mo26285clone();
        } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
            throw new AssertionError(COUIBaseListPopupWindow_8);
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if ((this.bitField0_ & 1) != 0) {
            codedOutputByteBufferNano.writeInt32(1, this.eventId_);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return (this.bitField0_ & 1) != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, this.eventId_) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ServiceEventProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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

    public static ServiceEventProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ServiceEventProto) MessageNano.mergeFrom(new ServiceEventProto(), bArr);
    }

    public static ServiceEventProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ServiceEventProto().mergeFrom(codedInputByteBufferNano);
    }
}
