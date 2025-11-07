package com.google.android.apps.lens.library.base.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.NanoEnumValue;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class LensSdkParamsProto {
    private LensSdkParamsProto() {
    }

    public static final class LensSdkParams extends ExtendableMessageNano<LensSdkParams> implements Cloneable {
        private static volatile LensSdkParams[] _emptyArray;
        public String agsaVersionName;

        @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
        public int arStickersAvailabilityStatus;

        @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
        public int lensAvailabilityStatus;
        public String lensSdkVersion;

        public interface LensAvailabilityStatus {

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_AVAILABILITY_UNKNOWN = -1;

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_READY = 0;

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE = 1;

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE = 3;

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_DEVICE_LOCKED = 5;

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_INVALID_CURSOR = 4;

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED = 2;

            @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
            public static final int LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE = 6;
        }

        @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
        public static int checkLensAvailabilityStatusOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= -1 && OplusGLSurfaceView_13 <= 6) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(54);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum LensAvailabilityStatus");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = LensAvailabilityStatus.class)
        public static int[] checkLensAvailabilityStatusOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkLensAvailabilityStatusOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        public static LensSdkParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LensSdkParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LensSdkParams() {
            clear();
        }

        public LensSdkParams clear() {
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
        public LensSdkParams mo26285clone() {
            try {
                return (LensSdkParams) super.mo26285clone();
            } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
                throw new AssertionError(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.lensSdkVersion;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.lensSdkVersion);
            }
            String str2 = this.agsaVersionName;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.agsaVersionName);
            }
            int OplusGLSurfaceView_13 = this.lensAvailabilityStatus;
            if (OplusGLSurfaceView_13 != -1) {
                codedOutputByteBufferNano.writeInt32(3, OplusGLSurfaceView_13);
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
            String str = this.lensSdkVersion;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.lensSdkVersion);
            }
            String str2 = this.agsaVersionName;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.agsaVersionName);
            }
            int OplusGLSurfaceView_13 = this.lensAvailabilityStatus;
            if (OplusGLSurfaceView_13 != -1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, OplusGLSurfaceView_13);
            }
            int i2 = this.arStickersAvailabilityStatus;
            return i2 != -1 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public LensSdkParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    } catch (IllegalArgumentException unused) {
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
                    } catch (IllegalArgumentException unused2) {
                        codedInputByteBufferNano.rewindToPosition(position2);
                        storeUnknownField(codedInputByteBufferNano, tag);
                    }
                }
            }
        }

        public static LensSdkParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (LensSdkParams) MessageNano.mergeFrom(new LensSdkParams(), bArr);
        }

        public static LensSdkParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new LensSdkParams().mergeFrom(codedInputByteBufferNano);
        }
    }
}
