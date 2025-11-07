package com.google.android.apps.lens.library.base.proto.nano;

/* loaded from: classes.dex */
public abstract class LensSdkParamsProto {
    private LensSdkParamsProto() {
    }

    public static final class LensSdkParams extends com.google.protobuf.nano.ExtendableMessageNano<com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams> implements java.lang.Cloneable {
        private static volatile com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams[] _emptyArray;
        public java.lang.String agsaVersionName;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
        public int arStickersAvailabilityStatus;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
        public int lensAvailabilityStatus;
        public java.lang.String lensSdkVersion;

        public interface LensAvailabilityStatus {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_AVAILABILITY_UNKNOWN = -1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_READY = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE = 3;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_DEVICE_LOCKED = 5;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_INVALID_CURSOR = 4;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED = 2;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE = 6;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
        public static int checkLensAvailabilityStatusOrThrow(int i_renamed) {
            if (i_renamed >= -1 && i_renamed <= 6) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(54);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum LensAvailabilityStatus");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.class)
        public static int[] checkLensAvailabilityStatusOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkLensAvailabilityStatusOrThrow(i_renamed);
            }
            return iArr2;
        }

        public static com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LensSdkParams() {
            clear();
        }

        public com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams clear() {
            this.lensSdkVersion = "";
            this.agsaVersionName = "";
            this.lensAvailabilityStatus = -1;
            this.arStickersAvailabilityStatus = -1;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        /* renamed from: clone */
        public com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams mo19clone() {
            try {
                return (com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams) super.mo19clone();
            } catch (java.lang.CloneNotSupportedException e_renamed) {
                throw new java.lang.AssertionError(e_renamed);
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.lensSdkVersion;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.lensSdkVersion);
            }
            java.lang.String str2 = this.agsaVersionName;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.agsaVersionName);
            }
            int i_renamed = this.lensAvailabilityStatus;
            if (i_renamed != -1) {
                codedOutputByteBufferNano.writeInt32(3, i_renamed);
            }
            int i2 = this.arStickersAvailabilityStatus;
            if (i2 != -1) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.lensSdkVersion;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.lensSdkVersion);
            }
            java.lang.String str2 = this.agsaVersionName;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(2, this.agsaVersionName);
            }
            int i_renamed = this.lensAvailabilityStatus;
            if (i_renamed != -1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(3, i_renamed);
            }
            int i2 = this.arStickersAvailabilityStatus;
            return i2 != -1 ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.lensSdkVersion = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.agsaVersionName = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int position = codedInputByteBufferNano.getPosition();
                    try {
                        this.lensAvailabilityStatus = checkLensAvailabilityStatusOrThrow(codedInputByteBufferNano.readInt32());
                    } catch (java.lang.IllegalArgumentException unused) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, tag);
                    }
                } else if (tag != 32) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int position2 = codedInputByteBufferNano.getPosition();
                    try {
                        this.arStickersAvailabilityStatus = checkLensAvailabilityStatusOrThrow(codedInputByteBufferNano.readInt32());
                    } catch (java.lang.IllegalArgumentException unused2) {
                        codedInputByteBufferNano.rewindToPosition(position2);
                        storeUnknownField(codedInputByteBufferNano, tag);
                    }
                }
            }
        }

        public static com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams(), bArr);
        }

        public static com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams().mergeFrom(codedInputByteBufferNano);
        }
    }
}
