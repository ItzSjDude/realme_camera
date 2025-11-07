package com.google.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class DescriptorProtos {
    private DescriptorProtos() {
    }

    public static final class FileDescriptorSet extends ExtendableMessageNano<FileDescriptorSet> {
        private static volatile FileDescriptorSet[] _emptyArray;
        public FileDescriptorProto[] file;

        public static FileDescriptorSet[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileDescriptorSet[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FileDescriptorSet() {
            clear();
        }

        public FileDescriptorSet clear() {
            this.file = FileDescriptorProto.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            FileDescriptorProto[] fileDescriptorProtoArr = this.file;
            if (fileDescriptorProtoArr != null && fileDescriptorProtoArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    FileDescriptorProto[] fileDescriptorProtoArr2 = this.file;
                    if (OplusGLSurfaceView_13 >= fileDescriptorProtoArr2.length) {
                        break;
                    }
                    FileDescriptorProto fileDescriptorProto = fileDescriptorProtoArr2[OplusGLSurfaceView_13];
                    if (fileDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(1, fileDescriptorProto);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            FileDescriptorProto[] fileDescriptorProtoArr = this.file;
            if (fileDescriptorProtoArr != null && fileDescriptorProtoArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    FileDescriptorProto[] fileDescriptorProtoArr2 = this.file;
                    if (OplusGLSurfaceView_13 >= fileDescriptorProtoArr2.length) {
                        break;
                    }
                    FileDescriptorProto fileDescriptorProto = fileDescriptorProtoArr2[OplusGLSurfaceView_13];
                    if (fileDescriptorProto != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fileDescriptorProto);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public FileDescriptorSet mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    FileDescriptorProto[] fileDescriptorProtoArr = this.file;
                    int length = fileDescriptorProtoArr == null ? 0 : fileDescriptorProtoArr.length;
                    FileDescriptorProto[] fileDescriptorProtoArr2 = new FileDescriptorProto[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.file, 0, fileDescriptorProtoArr2, 0, length);
                    }
                    while (length < fileDescriptorProtoArr2.length - 1) {
                        fileDescriptorProtoArr2[length] = new FileDescriptorProto();
                        codedInputByteBufferNano.readMessage(fileDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    fileDescriptorProtoArr2[length] = new FileDescriptorProto();
                    codedInputByteBufferNano.readMessage(fileDescriptorProtoArr2[length]);
                    this.file = fileDescriptorProtoArr2;
                }
            }
        }

        public static FileDescriptorSet parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (FileDescriptorSet) MessageNano.mergeFrom(new FileDescriptorSet(), bArr);
        }

        public static FileDescriptorSet parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new FileDescriptorSet().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FileDescriptorProto extends ExtendableMessageNano<FileDescriptorProto> {
        private static volatile FileDescriptorProto[] _emptyArray;
        public String[] dependency;
        public EnumDescriptorProto[] enumType;
        public FieldDescriptorProto[] extension;
        public DescriptorProto[] messageType;
        public String name;
        public FileOptions options;
        public String package_;
        public int[] publicDependency;
        public ServiceDescriptorProto[] service;
        public SourceCodeInfo sourceCodeInfo;
        public String syntax;
        public int[] weakDependency;

        public static FileDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FileDescriptorProto() {
            clear();
        }

        public FileDescriptorProto clear() {
            this.name = "";
            this.package_ = "";
            this.dependency = WireFormatNano.EMPTY_STRING_ARRAY;
            this.publicDependency = WireFormatNano.EMPTY_INT_ARRAY;
            this.weakDependency = WireFormatNano.EMPTY_INT_ARRAY;
            this.messageType = DescriptorProto.emptyArray();
            this.enumType = EnumDescriptorProto.emptyArray();
            this.service = ServiceDescriptorProto.emptyArray();
            this.extension = FieldDescriptorProto.emptyArray();
            this.options = null;
            this.sourceCodeInfo = null;
            this.syntax = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            String str2 = this.package_;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.package_);
            }
            String[] strArr = this.dependency;
            int OplusGLSurfaceView_13 = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.dependency;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str3 = strArr2[i2];
                    if (str3 != null) {
                        codedOutputByteBufferNano.writeString(3, str3);
                    }
                    i2++;
                }
            }
            DescriptorProto[] descriptorProtoArr = this.messageType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.messageType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, descriptorProto);
                    }
                    i3++;
                }
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(5, enumDescriptorProto);
                    }
                    i4++;
                }
            }
            ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
            if (serviceDescriptorProtoArr != null && serviceDescriptorProtoArr.length > 0) {
                int i5 = 0;
                while (true) {
                    ServiceDescriptorProto[] serviceDescriptorProtoArr2 = this.service;
                    if (i5 >= serviceDescriptorProtoArr2.length) {
                        break;
                    }
                    ServiceDescriptorProto serviceDescriptorProto = serviceDescriptorProtoArr2[i5];
                    if (serviceDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(6, serviceDescriptorProto);
                    }
                    i5++;
                }
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i6 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i6];
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(7, fieldDescriptorProto);
                    }
                    i6++;
                }
            }
            FileOptions fileOptions = this.options;
            if (fileOptions != null) {
                codedOutputByteBufferNano.writeMessage(8, fileOptions);
            }
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo;
            if (sourceCodeInfo != null) {
                codedOutputByteBufferNano.writeMessage(9, sourceCodeInfo);
            }
            int[] iArr = this.publicDependency;
            if (iArr != null && iArr.length > 0) {
                int i7 = 0;
                while (true) {
                    int[] iArr2 = this.publicDependency;
                    if (i7 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(10, iArr2[i7]);
                    i7++;
                }
            }
            int[] iArr3 = this.weakDependency;
            if (iArr3 != null && iArr3.length > 0) {
                while (true) {
                    int[] iArr4 = this.weakDependency;
                    if (OplusGLSurfaceView_13 >= iArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(11, iArr4[OplusGLSurfaceView_13]);
                    OplusGLSurfaceView_13++;
                }
            }
            String str4 = this.syntax;
            if (str4 != null && !str4.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.syntax);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int[] iArr;
            int[] iArr2;
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            String str2 = this.package_;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.package_);
            }
            String[] strArr = this.dependency;
            int OplusGLSurfaceView_13 = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.dependency;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str3 = strArr2[i2];
                    if (str3 != null) {
                        i3++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            DescriptorProto[] descriptorProtoArr = this.messageType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.messageType;
                    if (i4 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i4];
                    if (descriptorProto != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, descriptorProto);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i5 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i5];
                    if (enumDescriptorProto != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(5, enumDescriptorProto);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
            if (serviceDescriptorProtoArr != null && serviceDescriptorProtoArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    ServiceDescriptorProto[] serviceDescriptorProtoArr2 = this.service;
                    if (i6 >= serviceDescriptorProtoArr2.length) {
                        break;
                    }
                    ServiceDescriptorProto serviceDescriptorProto = serviceDescriptorProtoArr2[i6];
                    if (serviceDescriptorProto != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(6, serviceDescriptorProto);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i7 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.extension;
                    if (i7 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i7];
                    if (fieldDescriptorProto != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(7, fieldDescriptorProto);
                    }
                    i7++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            FileOptions fileOptions = this.options;
            if (fileOptions != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, fileOptions);
            }
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo;
            if (sourceCodeInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, sourceCodeInfo);
            }
            int[] iArr3 = this.publicDependency;
            if (iArr3 != null && iArr3.length > 0) {
                int i8 = 0;
                int iComputeInt32SizeNoTag = 0;
                while (true) {
                    iArr2 = this.publicDependency;
                    if (i8 >= iArr2.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i8]);
                    i8++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr2.length * 1);
            }
            int[] iArr4 = this.weakDependency;
            if (iArr4 != null && iArr4.length > 0) {
                int iComputeInt32SizeNoTag2 = 0;
                while (true) {
                    iArr = this.weakDependency;
                    if (OplusGLSurfaceView_13 >= iArr.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[OplusGLSurfaceView_13]);
                    OplusGLSurfaceView_13++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag2 + (iArr.length * 1);
            }
            String str4 = this.syntax;
            return (str4 == null || str4.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.syntax);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public FileDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.package_ = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        String[] strArr = this.dependency;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.dependency, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr2[length] = codedInputByteBufferNano.readString();
                        this.dependency = strArr2;
                        break;
                    case 34:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        DescriptorProto[] descriptorProtoArr = this.messageType;
                        int length2 = descriptorProtoArr == null ? 0 : descriptorProtoArr.length;
                        DescriptorProto[] descriptorProtoArr2 = new DescriptorProto[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.messageType, 0, descriptorProtoArr2, 0, length2);
                        }
                        while (length2 < descriptorProtoArr2.length - 1) {
                            descriptorProtoArr2[length2] = new DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr2[length2] = new DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                        this.messageType = descriptorProtoArr2;
                        break;
                    case 42:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
                        int length3 = enumDescriptorProtoArr == null ? 0 : enumDescriptorProtoArr.length;
                        EnumDescriptorProto[] enumDescriptorProtoArr2 = new EnumDescriptorProto[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.enumType, 0, enumDescriptorProtoArr2, 0, length3);
                        }
                        while (length3 < enumDescriptorProtoArr2.length - 1) {
                            enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                        this.enumType = enumDescriptorProtoArr2;
                        break;
                    case 50:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
                        int length4 = serviceDescriptorProtoArr == null ? 0 : serviceDescriptorProtoArr.length;
                        ServiceDescriptorProto[] serviceDescriptorProtoArr2 = new ServiceDescriptorProto[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.service, 0, serviceDescriptorProtoArr2, 0, length4);
                        }
                        while (length4 < serviceDescriptorProtoArr2.length - 1) {
                            serviceDescriptorProtoArr2[length4] = new ServiceDescriptorProto();
                            codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr2[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        serviceDescriptorProtoArr2[length4] = new ServiceDescriptorProto();
                        codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr2[length4]);
                        this.service = serviceDescriptorProtoArr2;
                        break;
                    case 58:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
                        int length5 = fieldDescriptorProtoArr == null ? 0 : fieldDescriptorProtoArr.length;
                        FieldDescriptorProto[] fieldDescriptorProtoArr2 = new FieldDescriptorProto[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.extension, 0, fieldDescriptorProtoArr2, 0, length5);
                        }
                        while (length5 < fieldDescriptorProtoArr2.length - 1) {
                            fieldDescriptorProtoArr2[length5] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr2[length5] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                        this.extension = fieldDescriptorProtoArr2;
                        break;
                    case 66:
                        if (this.options == null) {
                            this.options = new FileOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        break;
                    case 74:
                        if (this.sourceCodeInfo == null) {
                            this.sourceCodeInfo = new SourceCodeInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.sourceCodeInfo);
                        break;
                    case 80:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                        int[] iArr = this.publicDependency;
                        int length6 = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.publicDependency, 0, iArr2, 0, length6);
                        }
                        while (length6 < iArr2.length - 1) {
                            iArr2[length6] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        iArr2[length6] = codedInputByteBufferNano.readInt32();
                        this.publicDependency = iArr2;
                        break;
                    case 82:
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int OplusGLSurfaceView_13 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            OplusGLSurfaceView_13++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.publicDependency;
                        int length7 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[OplusGLSurfaceView_13 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.publicDependency, 0, iArr4, 0, length7);
                        }
                        while (length7 < iArr4.length) {
                            iArr4[length7] = codedInputByteBufferNano.readInt32();
                            length7++;
                        }
                        this.publicDependency = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                        break;
                    case 88:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 88);
                        int[] iArr5 = this.weakDependency;
                        int length8 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[repeatedFieldArrayLength7 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.weakDependency, 0, iArr6, 0, length8);
                        }
                        while (length8 < iArr6.length - 1) {
                            iArr6[length8] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        iArr6[length8] = codedInputByteBufferNano.readInt32();
                        this.weakDependency = iArr6;
                        break;
                    case 90:
                        int iPushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position2 = codedInputByteBufferNano.getPosition();
                        int i2 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i2++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position2);
                        int[] iArr7 = this.weakDependency;
                        int length9 = iArr7 == null ? 0 : iArr7.length;
                        int[] iArr8 = new int[i2 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.weakDependency, 0, iArr8, 0, length9);
                        }
                        while (length9 < iArr8.length) {
                            iArr8[length9] = codedInputByteBufferNano.readInt32();
                            length9++;
                        }
                        this.weakDependency = iArr8;
                        codedInputByteBufferNano.popLimit(iPushLimit2);
                        break;
                    case 98:
                        this.syntax = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (FileDescriptorProto) MessageNano.mergeFrom(new FileDescriptorProto(), bArr);
        }

        public static FileDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new FileDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DescriptorProto extends ExtendableMessageNano<DescriptorProto> {
        private static volatile DescriptorProto[] _emptyArray;
        public EnumDescriptorProto[] enumType;
        public FieldDescriptorProto[] extension;
        public ExtensionRange[] extensionRange;
        public FieldDescriptorProto[] field;
        public String name;
        public DescriptorProto[] nestedType;
        public OneofDescriptorProto[] oneofDecl;
        public MessageOptions options;
        public String[] reservedName;
        public ReservedRange[] reservedRange;

        public static final class ExtensionRange extends ExtendableMessageNano<ExtensionRange> {
            private static volatile ExtensionRange[] _emptyArray;
            public int end;
            public ExtensionRangeOptions options;
            public int start;

            public static ExtensionRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ExtensionRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public ExtensionRange() {
                clear();
            }

            public ExtensionRange clear() {
                this.start = 0;
                this.end = 0;
                this.options = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
                int OplusGLSurfaceView_13 = this.start;
                if (OplusGLSurfaceView_13 != 0) {
                    codedOutputByteBufferNano.writeInt32(1, OplusGLSurfaceView_13);
                }
                int i2 = this.end;
                if (i2 != 0) {
                    codedOutputByteBufferNano.writeInt32(2, i2);
                }
                ExtensionRangeOptions extensionRangeOptions = this.options;
                if (extensionRangeOptions != null) {
                    codedOutputByteBufferNano.writeMessage(3, extensionRangeOptions);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int OplusGLSurfaceView_13 = this.start;
                if (OplusGLSurfaceView_13 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, OplusGLSurfaceView_13);
                }
                int i2 = this.end;
                if (i2 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
                }
                ExtensionRangeOptions extensionRangeOptions = this.options;
                return extensionRangeOptions != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, extensionRangeOptions) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public ExtensionRange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.start = codedInputByteBufferNano.readInt32();
                    } else if (tag == 16) {
                        this.end = codedInputByteBufferNano.readInt32();
                    } else if (tag != 26) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        if (this.options == null) {
                            this.options = new ExtensionRangeOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                    }
                }
            }

            public static ExtensionRange parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (ExtensionRange) MessageNano.mergeFrom(new ExtensionRange(), bArr);
            }

            public static ExtensionRange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new ExtensionRange().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static final class ReservedRange extends ExtendableMessageNano<ReservedRange> {
            private static volatile ReservedRange[] _emptyArray;
            public int end;
            public int start;

            public static ReservedRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ReservedRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public ReservedRange() {
                clear();
            }

            public ReservedRange clear() {
                this.start = 0;
                this.end = 0;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
                int OplusGLSurfaceView_13 = this.start;
                if (OplusGLSurfaceView_13 != 0) {
                    codedOutputByteBufferNano.writeInt32(1, OplusGLSurfaceView_13);
                }
                int i2 = this.end;
                if (i2 != 0) {
                    codedOutputByteBufferNano.writeInt32(2, i2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int OplusGLSurfaceView_13 = this.start;
                if (OplusGLSurfaceView_13 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, OplusGLSurfaceView_13);
                }
                int i2 = this.end;
                return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public ReservedRange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.start = codedInputByteBufferNano.readInt32();
                    } else if (tag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.end = codedInputByteBufferNano.readInt32();
                    }
                }
            }

            public static ReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (ReservedRange) MessageNano.mergeFrom(new ReservedRange(), bArr);
            }

            public static ReservedRange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new ReservedRange().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static DescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DescriptorProto() {
            clear();
        }

        public DescriptorProto clear() {
            this.name = "";
            this.field = FieldDescriptorProto.emptyArray();
            this.extension = FieldDescriptorProto.emptyArray();
            this.nestedType = emptyArray();
            this.enumType = EnumDescriptorProto.emptyArray();
            this.extensionRange = ExtensionRange.emptyArray();
            this.oneofDecl = OneofDescriptorProto.emptyArray();
            this.options = null;
            this.reservedRange = ReservedRange.emptyArray();
            this.reservedName = WireFormatNano.EMPTY_STRING_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
            int OplusGLSurfaceView_13 = 0;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.field;
                    if (i2 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i2];
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, fieldDescriptorProto);
                    }
                    i2++;
                }
            }
            DescriptorProto[] descriptorProtoArr = this.nestedType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.nestedType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(3, descriptorProto);
                    }
                    i3++;
                }
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, enumDescriptorProto);
                    }
                    i4++;
                }
            }
            ExtensionRange[] extensionRangeArr = this.extensionRange;
            if (extensionRangeArr != null && extensionRangeArr.length > 0) {
                int i5 = 0;
                while (true) {
                    ExtensionRange[] extensionRangeArr2 = this.extensionRange;
                    if (i5 >= extensionRangeArr2.length) {
                        break;
                    }
                    ExtensionRange extensionRange = extensionRangeArr2[i5];
                    if (extensionRange != null) {
                        codedOutputByteBufferNano.writeMessage(5, extensionRange);
                    }
                    i5++;
                }
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
            if (fieldDescriptorProtoArr3 != null && fieldDescriptorProtoArr3.length > 0) {
                int i6 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr4 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr4.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto2 = fieldDescriptorProtoArr4[i6];
                    if (fieldDescriptorProto2 != null) {
                        codedOutputByteBufferNano.writeMessage(6, fieldDescriptorProto2);
                    }
                    i6++;
                }
            }
            MessageOptions messageOptions = this.options;
            if (messageOptions != null) {
                codedOutputByteBufferNano.writeMessage(7, messageOptions);
            }
            OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
            if (oneofDescriptorProtoArr != null && oneofDescriptorProtoArr.length > 0) {
                int i7 = 0;
                while (true) {
                    OneofDescriptorProto[] oneofDescriptorProtoArr2 = this.oneofDecl;
                    if (i7 >= oneofDescriptorProtoArr2.length) {
                        break;
                    }
                    OneofDescriptorProto oneofDescriptorProto = oneofDescriptorProtoArr2[i7];
                    if (oneofDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(8, oneofDescriptorProto);
                    }
                    i7++;
                }
            }
            ReservedRange[] reservedRangeArr = this.reservedRange;
            if (reservedRangeArr != null && reservedRangeArr.length > 0) {
                int i8 = 0;
                while (true) {
                    ReservedRange[] reservedRangeArr2 = this.reservedRange;
                    if (i8 >= reservedRangeArr2.length) {
                        break;
                    }
                    ReservedRange reservedRange = reservedRangeArr2[i8];
                    if (reservedRange != null) {
                        codedOutputByteBufferNano.writeMessage(9, reservedRange);
                    }
                    i8++;
                }
            }
            String[] strArr = this.reservedName;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.reservedName;
                    if (OplusGLSurfaceView_13 >= strArr2.length) {
                        break;
                    }
                    String str2 = strArr2[OplusGLSurfaceView_13];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(10, str2);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
            int OplusGLSurfaceView_13 = 0;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.field;
                    if (i2 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i2];
                    if (fieldDescriptorProto != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, fieldDescriptorProto);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            DescriptorProto[] descriptorProtoArr = this.nestedType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.nestedType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(3, descriptorProto);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(4, enumDescriptorProto);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            ExtensionRange[] extensionRangeArr = this.extensionRange;
            if (extensionRangeArr != null && extensionRangeArr.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    ExtensionRange[] extensionRangeArr2 = this.extensionRange;
                    if (i5 >= extensionRangeArr2.length) {
                        break;
                    }
                    ExtensionRange extensionRange = extensionRangeArr2[i5];
                    if (extensionRange != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(5, extensionRange);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
            if (fieldDescriptorProtoArr3 != null && fieldDescriptorProtoArr3.length > 0) {
                int iComputeMessageSize5 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr4 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr4.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto2 = fieldDescriptorProtoArr4[i6];
                    if (fieldDescriptorProto2 != null) {
                        iComputeMessageSize5 += CodedOutputByteBufferNano.computeMessageSize(6, fieldDescriptorProto2);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize5;
            }
            MessageOptions messageOptions = this.options;
            if (messageOptions != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, messageOptions);
            }
            OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
            if (oneofDescriptorProtoArr != null && oneofDescriptorProtoArr.length > 0) {
                int iComputeMessageSize6 = iComputeSerializedSize;
                int i7 = 0;
                while (true) {
                    OneofDescriptorProto[] oneofDescriptorProtoArr2 = this.oneofDecl;
                    if (i7 >= oneofDescriptorProtoArr2.length) {
                        break;
                    }
                    OneofDescriptorProto oneofDescriptorProto = oneofDescriptorProtoArr2[i7];
                    if (oneofDescriptorProto != null) {
                        iComputeMessageSize6 += CodedOutputByteBufferNano.computeMessageSize(8, oneofDescriptorProto);
                    }
                    i7++;
                }
                iComputeSerializedSize = iComputeMessageSize6;
            }
            ReservedRange[] reservedRangeArr = this.reservedRange;
            if (reservedRangeArr != null && reservedRangeArr.length > 0) {
                int iComputeMessageSize7 = iComputeSerializedSize;
                int i8 = 0;
                while (true) {
                    ReservedRange[] reservedRangeArr2 = this.reservedRange;
                    if (i8 >= reservedRangeArr2.length) {
                        break;
                    }
                    ReservedRange reservedRange = reservedRangeArr2[i8];
                    if (reservedRange != null) {
                        iComputeMessageSize7 += CodedOutputByteBufferNano.computeMessageSize(9, reservedRange);
                    }
                    i8++;
                }
                iComputeSerializedSize = iComputeMessageSize7;
            }
            String[] strArr = this.reservedName;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int iComputeStringSizeNoTag = 0;
            int i9 = 0;
            while (true) {
                String[] strArr2 = this.reservedName;
                if (OplusGLSurfaceView_13 >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i9 * 1);
                }
                String str2 = strArr2[OplusGLSurfaceView_13];
                if (str2 != null) {
                    i9++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                OplusGLSurfaceView_13++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public DescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
                        int length = fieldDescriptorProtoArr == null ? 0 : fieldDescriptorProtoArr.length;
                        FieldDescriptorProto[] fieldDescriptorProtoArr2 = new FieldDescriptorProto[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.field, 0, fieldDescriptorProtoArr2, 0, length);
                        }
                        while (length < fieldDescriptorProtoArr2.length - 1) {
                            fieldDescriptorProtoArr2[length] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        fieldDescriptorProtoArr2[length] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length]);
                        this.field = fieldDescriptorProtoArr2;
                        break;
                    case 26:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        DescriptorProto[] descriptorProtoArr = this.nestedType;
                        int length2 = descriptorProtoArr == null ? 0 : descriptorProtoArr.length;
                        DescriptorProto[] descriptorProtoArr2 = new DescriptorProto[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.nestedType, 0, descriptorProtoArr2, 0, length2);
                        }
                        while (length2 < descriptorProtoArr2.length - 1) {
                            descriptorProtoArr2[length2] = new DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr2[length2] = new DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                        this.nestedType = descriptorProtoArr2;
                        break;
                    case 34:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
                        int length3 = enumDescriptorProtoArr == null ? 0 : enumDescriptorProtoArr.length;
                        EnumDescriptorProto[] enumDescriptorProtoArr2 = new EnumDescriptorProto[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.enumType, 0, enumDescriptorProtoArr2, 0, length3);
                        }
                        while (length3 < enumDescriptorProtoArr2.length - 1) {
                            enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                        this.enumType = enumDescriptorProtoArr2;
                        break;
                    case 42:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        ExtensionRange[] extensionRangeArr = this.extensionRange;
                        int length4 = extensionRangeArr == null ? 0 : extensionRangeArr.length;
                        ExtensionRange[] extensionRangeArr2 = new ExtensionRange[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.extensionRange, 0, extensionRangeArr2, 0, length4);
                        }
                        while (length4 < extensionRangeArr2.length - 1) {
                            extensionRangeArr2[length4] = new ExtensionRange();
                            codedInputByteBufferNano.readMessage(extensionRangeArr2[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        extensionRangeArr2[length4] = new ExtensionRange();
                        codedInputByteBufferNano.readMessage(extensionRangeArr2[length4]);
                        this.extensionRange = extensionRangeArr2;
                        break;
                    case 50:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
                        int length5 = fieldDescriptorProtoArr3 == null ? 0 : fieldDescriptorProtoArr3.length;
                        FieldDescriptorProto[] fieldDescriptorProtoArr4 = new FieldDescriptorProto[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.extension, 0, fieldDescriptorProtoArr4, 0, length5);
                        }
                        while (length5 < fieldDescriptorProtoArr4.length - 1) {
                            fieldDescriptorProtoArr4[length5] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr4[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr4[length5] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr4[length5]);
                        this.extension = fieldDescriptorProtoArr4;
                        break;
                    case 58:
                        if (this.options == null) {
                            this.options = new MessageOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        break;
                    case 66:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
                        int length6 = oneofDescriptorProtoArr == null ? 0 : oneofDescriptorProtoArr.length;
                        OneofDescriptorProto[] oneofDescriptorProtoArr2 = new OneofDescriptorProto[repeatedFieldArrayLength6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.oneofDecl, 0, oneofDescriptorProtoArr2, 0, length6);
                        }
                        while (length6 < oneofDescriptorProtoArr2.length - 1) {
                            oneofDescriptorProtoArr2[length6] = new OneofDescriptorProto();
                            codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr2[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        oneofDescriptorProtoArr2[length6] = new OneofDescriptorProto();
                        codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr2[length6]);
                        this.oneofDecl = oneofDescriptorProtoArr2;
                        break;
                    case 74:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        ReservedRange[] reservedRangeArr = this.reservedRange;
                        int length7 = reservedRangeArr == null ? 0 : reservedRangeArr.length;
                        ReservedRange[] reservedRangeArr2 = new ReservedRange[repeatedFieldArrayLength7 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.reservedRange, 0, reservedRangeArr2, 0, length7);
                        }
                        while (length7 < reservedRangeArr2.length - 1) {
                            reservedRangeArr2[length7] = new ReservedRange();
                            codedInputByteBufferNano.readMessage(reservedRangeArr2[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        reservedRangeArr2[length7] = new ReservedRange();
                        codedInputByteBufferNano.readMessage(reservedRangeArr2[length7]);
                        this.reservedRange = reservedRangeArr2;
                        break;
                    case 82:
                        int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        String[] strArr = this.reservedName;
                        int length8 = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength8 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.reservedName, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        strArr2[length8] = codedInputByteBufferNano.readString();
                        this.reservedName = strArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static DescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (DescriptorProto) MessageNano.mergeFrom(new DescriptorProto(), bArr);
        }

        public static DescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ExtensionRangeOptions extends ExtendableMessageNano<ExtensionRangeOptions> {
        private static volatile ExtensionRangeOptions[] _emptyArray;
        public UninterpretedOption[] uninterpretedOption;

        public static ExtensionRangeOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ExtensionRangeOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ExtensionRangeOptions() {
            clear();
        }

        public ExtensionRangeOptions clear() {
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public ExtensionRangeOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 7994) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (ExtensionRangeOptions) MessageNano.mergeFrom(new ExtensionRangeOptions(), bArr);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ExtensionRangeOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FieldDescriptorProto extends ExtendableMessageNano<FieldDescriptorProto> {
        private static volatile FieldDescriptorProto[] _emptyArray;
        public String defaultValue;
        public String extendee;
        public String jsonName;

        @NanoEnumValue(legacy = false, value = Label.class)
        public int label;
        public String name;
        public int number;
        public int oneofIndex;
        public FieldOptions options;

        @NanoEnumValue(legacy = false, value = Type.class)
        public int type;
        public String typeName;

        public interface Label {

            @NanoEnumValue(legacy = false, value = Label.class)
            public static final int LABEL_OPTIONAL = 1;

            @NanoEnumValue(legacy = false, value = Label.class)
            public static final int LABEL_REPEATED = 3;

            @NanoEnumValue(legacy = false, value = Label.class)
            public static final int LABEL_REQUIRED = 2;
        }

        public interface Type {

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_BOOL = 8;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_BYTES = 12;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_DOUBLE = 1;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_ENUM = 14;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_FIXED32 = 7;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_FIXED64 = 6;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_FLOAT = 2;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_GROUP = 10;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_INT32 = 5;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_INT64 = 3;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_MESSAGE = 11;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_SFIXED32 = 15;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_SFIXED64 = 16;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_SINT32 = 17;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_SINT64 = 18;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_STRING = 9;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_UINT32 = 13;

            @NanoEnumValue(legacy = false, value = Type.class)
            public static final int TYPE_UINT64 = 4;
        }

        @NanoEnumValue(legacy = false, value = Type.class)
        public static int checkTypeOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 1 && OplusGLSurfaceView_13 <= 18) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(36);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum Type");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = Type.class)
        public static int[] checkTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkTypeOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = Label.class)
        public static int checkLabelOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 1 && OplusGLSurfaceView_13 <= 3) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(37);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum Label");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = Label.class)
        public static int[] checkLabelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkLabelOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        public static FieldDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FieldDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FieldDescriptorProto() {
            clear();
        }

        public FieldDescriptorProto clear() {
            this.name = "";
            this.number = 0;
            this.label = 1;
            this.type = 1;
            this.typeName = "";
            this.extendee = "";
            this.defaultValue = "";
            this.oneofIndex = 0;
            this.jsonName = "";
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            String str2 = this.extendee;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.extendee);
            }
            int OplusGLSurfaceView_13 = this.number;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputByteBufferNano.writeInt32(3, OplusGLSurfaceView_13);
            }
            int i2 = this.label;
            if (i2 != 1) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            int i3 = this.type;
            if (i3 != 1) {
                codedOutputByteBufferNano.writeInt32(5, i3);
            }
            String str3 = this.typeName;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.typeName);
            }
            String str4 = this.defaultValue;
            if (str4 != null && !str4.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.defaultValue);
            }
            FieldOptions fieldOptions = this.options;
            if (fieldOptions != null) {
                codedOutputByteBufferNano.writeMessage(8, fieldOptions);
            }
            int i4 = this.oneofIndex;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(9, i4);
            }
            String str5 = this.jsonName;
            if (str5 != null && !str5.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.jsonName);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            String str2 = this.extendee;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.extendee);
            }
            int OplusGLSurfaceView_13 = this.number;
            if (OplusGLSurfaceView_13 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, OplusGLSurfaceView_13);
            }
            int i2 = this.label;
            if (i2 != 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            int i3 = this.type;
            if (i3 != 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
            }
            String str3 = this.typeName;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.typeName);
            }
            String str4 = this.defaultValue;
            if (str4 != null && !str4.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.defaultValue);
            }
            FieldOptions fieldOptions = this.options;
            if (fieldOptions != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, fieldOptions);
            }
            int i4 = this.oneofIndex;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i4);
            }
            String str5 = this.jsonName;
            return (str5 == null || str5.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.jsonName);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public FieldDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.extendee = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.number = codedInputByteBufferNano.readInt32();
                        break;
                    case 32:
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.label = checkLabelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 40:
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.type = checkTypeOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 50:
                        this.typeName = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.defaultValue = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        if (this.options == null) {
                            this.options = new FieldOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        break;
                    case 72:
                        this.oneofIndex = codedInputByteBufferNano.readInt32();
                        break;
                    case 82:
                        this.jsonName = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (FieldDescriptorProto) MessageNano.mergeFrom(new FieldDescriptorProto(), bArr);
        }

        public static FieldDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new FieldDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class OneofDescriptorProto extends ExtendableMessageNano<OneofDescriptorProto> {
        private static volatile OneofDescriptorProto[] _emptyArray;
        public String name;
        public OneofOptions options;

        public static OneofDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OneofDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public OneofDescriptorProto() {
            clear();
        }

        public OneofDescriptorProto clear() {
            this.name = "";
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            OneofOptions oneofOptions = this.options;
            if (oneofOptions != null) {
                codedOutputByteBufferNano.writeMessage(2, oneofOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            OneofOptions oneofOptions = this.options;
            return oneofOptions != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, oneofOptions) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public OneofDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.options == null) {
                        this.options = new OneofOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                }
            }
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (OneofDescriptorProto) MessageNano.mergeFrom(new OneofDescriptorProto(), bArr);
        }

        public static OneofDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new OneofDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumDescriptorProto extends ExtendableMessageNano<EnumDescriptorProto> {
        private static volatile EnumDescriptorProto[] _emptyArray;
        public String name;
        public EnumOptions options;
        public String[] reservedName;
        public EnumReservedRange[] reservedRange;
        public EnumValueDescriptorProto[] value;

        public static final class EnumReservedRange extends ExtendableMessageNano<EnumReservedRange> {
            private static volatile EnumReservedRange[] _emptyArray;
            public int end;
            public int start;

            public static EnumReservedRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new EnumReservedRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public EnumReservedRange() {
                clear();
            }

            public EnumReservedRange clear() {
                this.start = 0;
                this.end = 0;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
                int OplusGLSurfaceView_13 = this.start;
                if (OplusGLSurfaceView_13 != 0) {
                    codedOutputByteBufferNano.writeInt32(1, OplusGLSurfaceView_13);
                }
                int i2 = this.end;
                if (i2 != 0) {
                    codedOutputByteBufferNano.writeInt32(2, i2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int OplusGLSurfaceView_13 = this.start;
                if (OplusGLSurfaceView_13 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, OplusGLSurfaceView_13);
                }
                int i2 = this.end;
                return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public EnumReservedRange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.start = codedInputByteBufferNano.readInt32();
                    } else if (tag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.end = codedInputByteBufferNano.readInt32();
                    }
                }
            }

            public static EnumReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (EnumReservedRange) MessageNano.mergeFrom(new EnumReservedRange(), bArr);
            }

            public static EnumReservedRange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new EnumReservedRange().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static EnumDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumDescriptorProto() {
            clear();
        }

        public EnumDescriptorProto clear() {
            this.name = "";
            this.value = EnumValueDescriptorProto.emptyArray();
            this.options = null;
            this.reservedRange = EnumReservedRange.emptyArray();
            this.reservedName = WireFormatNano.EMPTY_STRING_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
            int OplusGLSurfaceView_13 = 0;
            if (enumValueDescriptorProtoArr != null && enumValueDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = this.value;
                    if (i2 >= enumValueDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumValueDescriptorProto enumValueDescriptorProto = enumValueDescriptorProtoArr2[i2];
                    if (enumValueDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, enumValueDescriptorProto);
                    }
                    i2++;
                }
            }
            EnumOptions enumOptions = this.options;
            if (enumOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, enumOptions);
            }
            EnumReservedRange[] enumReservedRangeArr = this.reservedRange;
            if (enumReservedRangeArr != null && enumReservedRangeArr.length > 0) {
                int i3 = 0;
                while (true) {
                    EnumReservedRange[] enumReservedRangeArr2 = this.reservedRange;
                    if (i3 >= enumReservedRangeArr2.length) {
                        break;
                    }
                    EnumReservedRange enumReservedRange = enumReservedRangeArr2[i3];
                    if (enumReservedRange != null) {
                        codedOutputByteBufferNano.writeMessage(4, enumReservedRange);
                    }
                    i3++;
                }
            }
            String[] strArr = this.reservedName;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.reservedName;
                    if (OplusGLSurfaceView_13 >= strArr2.length) {
                        break;
                    }
                    String str2 = strArr2[OplusGLSurfaceView_13];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(5, str2);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
            int OplusGLSurfaceView_13 = 0;
            if (enumValueDescriptorProtoArr != null && enumValueDescriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = this.value;
                    if (i2 >= enumValueDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumValueDescriptorProto enumValueDescriptorProto = enumValueDescriptorProtoArr2[i2];
                    if (enumValueDescriptorProto != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, enumValueDescriptorProto);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            EnumOptions enumOptions = this.options;
            if (enumOptions != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, enumOptions);
            }
            EnumReservedRange[] enumReservedRangeArr = this.reservedRange;
            if (enumReservedRangeArr != null && enumReservedRangeArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    EnumReservedRange[] enumReservedRangeArr2 = this.reservedRange;
                    if (i3 >= enumReservedRangeArr2.length) {
                        break;
                    }
                    EnumReservedRange enumReservedRange = enumReservedRangeArr2[i3];
                    if (enumReservedRange != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(4, enumReservedRange);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            String[] strArr = this.reservedName;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.reservedName;
                if (OplusGLSurfaceView_13 >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
                }
                String str2 = strArr2[OplusGLSurfaceView_13];
                if (str2 != null) {
                    i4++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                OplusGLSurfaceView_13++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public EnumDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
                    int length = enumValueDescriptorProtoArr == null ? 0 : enumValueDescriptorProtoArr.length;
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = new EnumValueDescriptorProto[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.value, 0, enumValueDescriptorProtoArr2, 0, length);
                    }
                    while (length < enumValueDescriptorProtoArr2.length - 1) {
                        enumValueDescriptorProtoArr2[length] = new EnumValueDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    enumValueDescriptorProtoArr2[length] = new EnumValueDescriptorProto();
                    codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr2[length]);
                    this.value = enumValueDescriptorProtoArr2;
                } else if (tag == 26) {
                    if (this.options == null) {
                        this.options = new EnumOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    EnumReservedRange[] enumReservedRangeArr = this.reservedRange;
                    int length2 = enumReservedRangeArr == null ? 0 : enumReservedRangeArr.length;
                    EnumReservedRange[] enumReservedRangeArr2 = new EnumReservedRange[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.reservedRange, 0, enumReservedRangeArr2, 0, length2);
                    }
                    while (length2 < enumReservedRangeArr2.length - 1) {
                        enumReservedRangeArr2[length2] = new EnumReservedRange();
                        codedInputByteBufferNano.readMessage(enumReservedRangeArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    enumReservedRangeArr2[length2] = new EnumReservedRange();
                    codedInputByteBufferNano.readMessage(enumReservedRangeArr2[length2]);
                    this.reservedRange = enumReservedRangeArr2;
                } else if (tag != 42) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    String[] strArr = this.reservedName;
                    int length3 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.reservedName, 0, strArr2, 0, length3);
                    }
                    while (length3 < strArr2.length - 1) {
                        strArr2[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr2[length3] = codedInputByteBufferNano.readString();
                    this.reservedName = strArr2;
                }
            }
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (EnumDescriptorProto) MessageNano.mergeFrom(new EnumDescriptorProto(), bArr);
        }

        public static EnumDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new EnumDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumValueDescriptorProto extends ExtendableMessageNano<EnumValueDescriptorProto> {
        private static volatile EnumValueDescriptorProto[] _emptyArray;
        public String name;
        public int number;
        public EnumValueOptions options;

        public static EnumValueDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumValueDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumValueDescriptorProto() {
            clear();
        }

        public EnumValueDescriptorProto clear() {
            this.name = "";
            this.number = 0;
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            int OplusGLSurfaceView_13 = this.number;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputByteBufferNano.writeInt32(2, OplusGLSurfaceView_13);
            }
            EnumValueOptions enumValueOptions = this.options;
            if (enumValueOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, enumValueOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            int OplusGLSurfaceView_13 = this.number;
            if (OplusGLSurfaceView_13 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, OplusGLSurfaceView_13);
            }
            EnumValueOptions enumValueOptions = this.options;
            return enumValueOptions != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, enumValueOptions) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public EnumValueDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.number = codedInputByteBufferNano.readInt32();
                } else if (tag != 26) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.options == null) {
                        this.options = new EnumValueOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                }
            }
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (EnumValueDescriptorProto) MessageNano.mergeFrom(new EnumValueDescriptorProto(), bArr);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new EnumValueDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ServiceDescriptorProto extends ExtendableMessageNano<ServiceDescriptorProto> {
        private static volatile ServiceDescriptorProto[] _emptyArray;
        public MethodDescriptorProto[] method;
        public String name;
        public ServiceOptions options;
        public StreamDescriptorProto[] stream;

        public static ServiceDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ServiceDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ServiceDescriptorProto() {
            clear();
        }

        public ServiceDescriptorProto clear() {
            this.name = "";
            this.method = MethodDescriptorProto.emptyArray();
            this.stream = StreamDescriptorProto.emptyArray();
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
            int OplusGLSurfaceView_13 = 0;
            if (methodDescriptorProtoArr != null && methodDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MethodDescriptorProto[] methodDescriptorProtoArr2 = this.method;
                    if (i2 >= methodDescriptorProtoArr2.length) {
                        break;
                    }
                    MethodDescriptorProto methodDescriptorProto = methodDescriptorProtoArr2[i2];
                    if (methodDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, methodDescriptorProto);
                    }
                    i2++;
                }
            }
            ServiceOptions serviceOptions = this.options;
            if (serviceOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, serviceOptions);
            }
            StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
            if (streamDescriptorProtoArr != null && streamDescriptorProtoArr.length > 0) {
                while (true) {
                    StreamDescriptorProto[] streamDescriptorProtoArr2 = this.stream;
                    if (OplusGLSurfaceView_13 >= streamDescriptorProtoArr2.length) {
                        break;
                    }
                    StreamDescriptorProto streamDescriptorProto = streamDescriptorProtoArr2[OplusGLSurfaceView_13];
                    if (streamDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, streamDescriptorProto);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
            int OplusGLSurfaceView_13 = 0;
            if (methodDescriptorProtoArr != null && methodDescriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    MethodDescriptorProto[] methodDescriptorProtoArr2 = this.method;
                    if (i2 >= methodDescriptorProtoArr2.length) {
                        break;
                    }
                    MethodDescriptorProto methodDescriptorProto = methodDescriptorProtoArr2[i2];
                    if (methodDescriptorProto != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, methodDescriptorProto);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            ServiceOptions serviceOptions = this.options;
            if (serviceOptions != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, serviceOptions);
            }
            StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
            if (streamDescriptorProtoArr != null && streamDescriptorProtoArr.length > 0) {
                while (true) {
                    StreamDescriptorProto[] streamDescriptorProtoArr2 = this.stream;
                    if (OplusGLSurfaceView_13 >= streamDescriptorProtoArr2.length) {
                        break;
                    }
                    StreamDescriptorProto streamDescriptorProto = streamDescriptorProtoArr2[OplusGLSurfaceView_13];
                    if (streamDescriptorProto != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, streamDescriptorProto);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public ServiceDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
                    int length = methodDescriptorProtoArr == null ? 0 : methodDescriptorProtoArr.length;
                    MethodDescriptorProto[] methodDescriptorProtoArr2 = new MethodDescriptorProto[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.method, 0, methodDescriptorProtoArr2, 0, length);
                    }
                    while (length < methodDescriptorProtoArr2.length - 1) {
                        methodDescriptorProtoArr2[length] = new MethodDescriptorProto();
                        codedInputByteBufferNano.readMessage(methodDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    methodDescriptorProtoArr2[length] = new MethodDescriptorProto();
                    codedInputByteBufferNano.readMessage(methodDescriptorProtoArr2[length]);
                    this.method = methodDescriptorProtoArr2;
                } else if (tag == 26) {
                    if (this.options == null) {
                        this.options = new ServiceOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (tag != 34) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
                    int length2 = streamDescriptorProtoArr == null ? 0 : streamDescriptorProtoArr.length;
                    StreamDescriptorProto[] streamDescriptorProtoArr2 = new StreamDescriptorProto[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.stream, 0, streamDescriptorProtoArr2, 0, length2);
                    }
                    while (length2 < streamDescriptorProtoArr2.length - 1) {
                        streamDescriptorProtoArr2[length2] = new StreamDescriptorProto();
                        codedInputByteBufferNano.readMessage(streamDescriptorProtoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    streamDescriptorProtoArr2[length2] = new StreamDescriptorProto();
                    codedInputByteBufferNano.readMessage(streamDescriptorProtoArr2[length2]);
                    this.stream = streamDescriptorProtoArr2;
                }
            }
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (ServiceDescriptorProto) MessageNano.mergeFrom(new ServiceDescriptorProto(), bArr);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ServiceDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MethodDescriptorProto extends ExtendableMessageNano<MethodDescriptorProto> {
        private static volatile MethodDescriptorProto[] _emptyArray;
        public boolean clientStreaming;
        public String inputType;
        public String name;
        public MethodOptions options;
        public String outputType;
        public boolean serverStreaming;

        public static MethodDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MethodDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MethodDescriptorProto() {
            clear();
        }

        public MethodDescriptorProto clear() {
            this.name = "";
            this.inputType = "";
            this.outputType = "";
            this.options = null;
            this.clientStreaming = false;
            this.serverStreaming = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            String str2 = this.inputType;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.inputType);
            }
            String str3 = this.outputType;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.outputType);
            }
            MethodOptions methodOptions = this.options;
            if (methodOptions != null) {
                codedOutputByteBufferNano.writeMessage(4, methodOptions);
            }
            boolean z = this.clientStreaming;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            boolean z2 = this.serverStreaming;
            if (z2) {
                codedOutputByteBufferNano.writeBool(6, z2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            String str2 = this.inputType;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.inputType);
            }
            String str3 = this.outputType;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.outputType);
            }
            MethodOptions methodOptions = this.options;
            if (methodOptions != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, methodOptions);
            }
            boolean z = this.clientStreaming;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            boolean z2 = this.serverStreaming;
            return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public MethodDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.inputType = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.outputType = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    if (this.options == null) {
                        this.options = new MethodOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (tag == 40) {
                    this.clientStreaming = codedInputByteBufferNano.readBool();
                } else if (tag != 48) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serverStreaming = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (MethodDescriptorProto) MessageNano.mergeFrom(new MethodDescriptorProto(), bArr);
        }

        public static MethodDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new MethodDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class StreamDescriptorProto extends ExtendableMessageNano<StreamDescriptorProto> {
        private static volatile StreamDescriptorProto[] _emptyArray;
        public String clientMessageType;
        public String name;
        public StreamOptions options;
        public String serverMessageType;

        public static StreamDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StreamDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public StreamDescriptorProto() {
            clear();
        }

        public StreamDescriptorProto clear() {
            this.name = "";
            this.clientMessageType = "";
            this.serverMessageType = "";
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            String str2 = this.clientMessageType;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.clientMessageType);
            }
            String str3 = this.serverMessageType;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.serverMessageType);
            }
            StreamOptions streamOptions = this.options;
            if (streamOptions != null) {
                codedOutputByteBufferNano.writeMessage(4, streamOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            String str2 = this.clientMessageType;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.clientMessageType);
            }
            String str3 = this.serverMessageType;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.serverMessageType);
            }
            StreamOptions streamOptions = this.options;
            return streamOptions != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, streamOptions) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public StreamDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.clientMessageType = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.serverMessageType = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.options == null) {
                        this.options = new StreamOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                }
            }
        }

        public static StreamDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (StreamDescriptorProto) MessageNano.mergeFrom(new StreamDescriptorProto(), bArr);
        }

        public static StreamDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new StreamDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FileOptions extends ExtendableMessageNano<FileOptions> {
        private static volatile FileOptions[] _emptyArray;
        public int ccApiVersion;
        public boolean ccEnableArenas;
        public boolean ccGenericServices;
        public boolean ccUtf8Verification;
        public String csharpNamespace;
        public boolean deprecated;
        public String goPackage;
        public String javaAltApiPackage;
        public int javaApiVersion;
        public boolean javaEnableDualGenerateMutableApi;
        public boolean javaGenericServices;
        public boolean javaJava5Enums;
        public boolean javaMultipleFiles;
        public String javaMultipleFilesMutablePackage;
        public boolean javaMutableApi;
        public String javaOuterClassname;
        public String javaPackage;
        public boolean javaStringCheckUtf8;
        public boolean javaUseJavaproto2;
        public boolean javaUseJavastrings;
        public String javascriptPackage;
        public String objcClassPrefix;

        @NanoEnumValue(legacy = false, value = OptimizeMode.class)
        public int optimizeFor;
        public String phpClassPrefix;
        public boolean phpGenericServices;
        public String phpNamespace;
        public int pyApiVersion;
        public boolean pyGenericServices;
        public String swiftPrefix;
        public int szlApiVersion;
        public UninterpretedOption[] uninterpretedOption;

        public interface CompatibilityLevel {

            @NanoEnumValue(legacy = false, value = CompatibilityLevel.class)
            public static final int NO_COMPATIBILITY = 0;

            @NanoEnumValue(legacy = false, value = CompatibilityLevel.class)
            public static final int PROTO1_COMPATIBLE = 100;
        }

        public interface OptimizeMode {

            @NanoEnumValue(legacy = false, value = OptimizeMode.class)
            public static final int CODE_SIZE = 2;

            @NanoEnumValue(legacy = false, value = OptimizeMode.class)
            public static final int LITE_RUNTIME = 3;

            @NanoEnumValue(legacy = false, value = OptimizeMode.class)
            public static final int SPEED = 1;
        }

        @NanoEnumValue(legacy = false, value = CompatibilityLevel.class)
        public static int checkCompatibilityLevelOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 0) {
                return OplusGLSurfaceView_13;
            }
            if (OplusGLSurfaceView_13 >= 100 && OplusGLSurfaceView_13 <= 100) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(50);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum CompatibilityLevel");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = CompatibilityLevel.class)
        public static int[] checkCompatibilityLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkCompatibilityLevelOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = OptimizeMode.class)
        public static int checkOptimizeModeOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 1 && OplusGLSurfaceView_13 <= 3) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(44);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum OptimizeMode");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = OptimizeMode.class)
        public static int[] checkOptimizeModeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkOptimizeModeOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        public static FileOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FileOptions() {
            clear();
        }

        public FileOptions clear() {
            this.ccApiVersion = 2;
            this.ccUtf8Verification = true;
            this.javaPackage = "";
            this.pyApiVersion = 2;
            this.javaApiVersion = 2;
            this.javaUseJavaproto2 = true;
            this.javaJava5Enums = true;
            this.javaUseJavastrings = false;
            this.javaAltApiPackage = "";
            this.javaEnableDualGenerateMutableApi = false;
            this.javaOuterClassname = "";
            this.javaMultipleFiles = false;
            this.javaStringCheckUtf8 = false;
            this.javaMutableApi = false;
            this.javaMultipleFilesMutablePackage = "";
            this.optimizeFor = 1;
            this.goPackage = "";
            this.javascriptPackage = "";
            this.szlApiVersion = 1;
            this.ccGenericServices = false;
            this.javaGenericServices = false;
            this.pyGenericServices = false;
            this.phpGenericServices = false;
            this.deprecated = false;
            this.ccEnableArenas = false;
            this.objcClassPrefix = "";
            this.csharpNamespace = "";
            this.swiftPrefix = "";
            this.phpClassPrefix = "";
            this.phpNamespace = "";
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.javaPackage;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.javaPackage);
            }
            int OplusGLSurfaceView_13 = this.ccApiVersion;
            if (OplusGLSurfaceView_13 != 2) {
                codedOutputByteBufferNano.writeInt32(2, OplusGLSurfaceView_13);
            }
            int i2 = this.pyApiVersion;
            if (i2 != 2) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            int i3 = this.javaApiVersion;
            if (i3 != 2) {
                codedOutputByteBufferNano.writeInt32(5, i3);
            }
            boolean z = this.javaUseJavaproto2;
            if (!z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            boolean z2 = this.javaJava5Enums;
            if (!z2) {
                codedOutputByteBufferNano.writeBool(7, z2);
            }
            String str2 = this.javaOuterClassname;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.javaOuterClassname);
            }
            int i4 = this.optimizeFor;
            if (i4 != 1) {
                codedOutputByteBufferNano.writeInt32(9, i4);
            }
            boolean z3 = this.javaMultipleFiles;
            if (z3) {
                codedOutputByteBufferNano.writeBool(10, z3);
            }
            String str3 = this.goPackage;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.goPackage);
            }
            String str4 = this.javascriptPackage;
            if (str4 != null && !str4.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.javascriptPackage);
            }
            int i5 = this.szlApiVersion;
            if (i5 != 1) {
                codedOutputByteBufferNano.writeInt32(14, i5);
            }
            boolean z4 = this.ccGenericServices;
            if (z4) {
                codedOutputByteBufferNano.writeBool(16, z4);
            }
            boolean z5 = this.javaGenericServices;
            if (z5) {
                codedOutputByteBufferNano.writeBool(17, z5);
            }
            boolean z6 = this.pyGenericServices;
            if (z6) {
                codedOutputByteBufferNano.writeBool(18, z6);
            }
            String str5 = this.javaAltApiPackage;
            if (str5 != null && !str5.equals("")) {
                codedOutputByteBufferNano.writeString(19, this.javaAltApiPackage);
            }
            boolean z7 = this.javaUseJavastrings;
            if (z7) {
                codedOutputByteBufferNano.writeBool(21, z7);
            }
            boolean z8 = this.deprecated;
            if (z8) {
                codedOutputByteBufferNano.writeBool(23, z8);
            }
            boolean z9 = this.ccUtf8Verification;
            if (!z9) {
                codedOutputByteBufferNano.writeBool(24, z9);
            }
            boolean z10 = this.javaEnableDualGenerateMutableApi;
            if (z10) {
                codedOutputByteBufferNano.writeBool(26, z10);
            }
            boolean z11 = this.javaStringCheckUtf8;
            if (z11) {
                codedOutputByteBufferNano.writeBool(27, z11);
            }
            boolean z12 = this.javaMutableApi;
            if (z12) {
                codedOutputByteBufferNano.writeBool(28, z12);
            }
            String str6 = this.javaMultipleFilesMutablePackage;
            if (str6 != null && !str6.equals("")) {
                codedOutputByteBufferNano.writeString(29, this.javaMultipleFilesMutablePackage);
            }
            boolean z13 = this.ccEnableArenas;
            if (z13) {
                codedOutputByteBufferNano.writeBool(31, z13);
            }
            String str7 = this.objcClassPrefix;
            if (str7 != null && !str7.equals("")) {
                codedOutputByteBufferNano.writeString(36, this.objcClassPrefix);
            }
            String str8 = this.csharpNamespace;
            if (str8 != null && !str8.equals("")) {
                codedOutputByteBufferNano.writeString(37, this.csharpNamespace);
            }
            String str9 = this.swiftPrefix;
            if (str9 != null && !str9.equals("")) {
                codedOutputByteBufferNano.writeString(39, this.swiftPrefix);
            }
            String str10 = this.phpClassPrefix;
            if (str10 != null && !str10.equals("")) {
                codedOutputByteBufferNano.writeString(40, this.phpClassPrefix);
            }
            String str11 = this.phpNamespace;
            if (str11 != null && !str11.equals("")) {
                codedOutputByteBufferNano.writeString(41, this.phpNamespace);
            }
            boolean z14 = this.phpGenericServices;
            if (z14) {
                codedOutputByteBufferNano.writeBool(42, z14);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i6++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.javaPackage;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.javaPackage);
            }
            int OplusGLSurfaceView_13 = this.ccApiVersion;
            if (OplusGLSurfaceView_13 != 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, OplusGLSurfaceView_13);
            }
            int i2 = this.pyApiVersion;
            if (i2 != 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            int i3 = this.javaApiVersion;
            if (i3 != 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
            }
            boolean z = this.javaUseJavaproto2;
            if (!z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
            }
            boolean z2 = this.javaJava5Enums;
            if (!z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z2);
            }
            String str2 = this.javaOuterClassname;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.javaOuterClassname);
            }
            int i4 = this.optimizeFor;
            if (i4 != 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i4);
            }
            boolean z3 = this.javaMultipleFiles;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z3);
            }
            String str3 = this.goPackage;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.goPackage);
            }
            String str4 = this.javascriptPackage;
            if (str4 != null && !str4.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.javascriptPackage);
            }
            int i5 = this.szlApiVersion;
            if (i5 != 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i5);
            }
            boolean z4 = this.ccGenericServices;
            if (z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, z4);
            }
            boolean z5 = this.javaGenericServices;
            if (z5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z5);
            }
            boolean z6 = this.pyGenericServices;
            if (z6) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, z6);
            }
            String str5 = this.javaAltApiPackage;
            if (str5 != null && !str5.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.javaAltApiPackage);
            }
            boolean z7 = this.javaUseJavastrings;
            if (z7) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, z7);
            }
            boolean z8 = this.deprecated;
            if (z8) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, z8);
            }
            boolean z9 = this.ccUtf8Verification;
            if (!z9) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(24, z9);
            }
            boolean z10 = this.javaEnableDualGenerateMutableApi;
            if (z10) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, z10);
            }
            boolean z11 = this.javaStringCheckUtf8;
            if (z11) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(27, z11);
            }
            boolean z12 = this.javaMutableApi;
            if (z12) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(28, z12);
            }
            String str6 = this.javaMultipleFilesMutablePackage;
            if (str6 != null && !str6.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, this.javaMultipleFilesMutablePackage);
            }
            boolean z13 = this.ccEnableArenas;
            if (z13) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(31, z13);
            }
            String str7 = this.objcClassPrefix;
            if (str7 != null && !str7.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(36, this.objcClassPrefix);
            }
            String str8 = this.csharpNamespace;
            if (str8 != null && !str8.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(37, this.csharpNamespace);
            }
            String str9 = this.swiftPrefix;
            if (str9 != null && !str9.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(39, this.swiftPrefix);
            }
            String str10 = this.phpClassPrefix;
            if (str10 != null && !str10.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(40, this.phpClassPrefix);
            }
            String str11 = this.phpNamespace;
            if (str11 != null && !str11.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(41, this.phpNamespace);
            }
            boolean z14 = this.phpGenericServices;
            if (z14) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(42, z14);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i6++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public FileOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.javaPackage = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.ccApiVersion = codedInputByteBufferNano.readInt32();
                        break;
                    case 32:
                        this.pyApiVersion = codedInputByteBufferNano.readInt32();
                        break;
                    case 40:
                        this.javaApiVersion = codedInputByteBufferNano.readInt32();
                        break;
                    case 48:
                        this.javaUseJavaproto2 = codedInputByteBufferNano.readBool();
                        break;
                    case 56:
                        this.javaJava5Enums = codedInputByteBufferNano.readBool();
                        break;
                    case 66:
                        this.javaOuterClassname = codedInputByteBufferNano.readString();
                        break;
                    case 72:
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.optimizeFor = checkOptimizeModeOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 80:
                        this.javaMultipleFiles = codedInputByteBufferNano.readBool();
                        break;
                    case 90:
                        this.goPackage = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.javascriptPackage = codedInputByteBufferNano.readString();
                        break;
                    case 112:
                        this.szlApiVersion = codedInputByteBufferNano.readInt32();
                        break;
                    case 128:
                        this.ccGenericServices = codedInputByteBufferNano.readBool();
                        break;
                    case 136:
                        this.javaGenericServices = codedInputByteBufferNano.readBool();
                        break;
                    case 144:
                        this.pyGenericServices = codedInputByteBufferNano.readBool();
                        break;
                    case 154:
                        this.javaAltApiPackage = codedInputByteBufferNano.readString();
                        break;
                    case 168:
                        this.javaUseJavastrings = codedInputByteBufferNano.readBool();
                        break;
                    case 184:
                        this.deprecated = codedInputByteBufferNano.readBool();
                        break;
                    case 192:
                        this.ccUtf8Verification = codedInputByteBufferNano.readBool();
                        break;
                    case 208:
                        this.javaEnableDualGenerateMutableApi = codedInputByteBufferNano.readBool();
                        break;
                    case 216:
                        this.javaStringCheckUtf8 = codedInputByteBufferNano.readBool();
                        break;
                    case 224:
                        this.javaMutableApi = codedInputByteBufferNano.readBool();
                        break;
                    case 234:
                        this.javaMultipleFilesMutablePackage = codedInputByteBufferNano.readString();
                        break;
                    case 248:
                        this.ccEnableArenas = codedInputByteBufferNano.readBool();
                        break;
                    case 290:
                        this.objcClassPrefix = codedInputByteBufferNano.readString();
                        break;
                    case 298:
                        this.csharpNamespace = codedInputByteBufferNano.readString();
                        break;
                    case 314:
                        this.swiftPrefix = codedInputByteBufferNano.readString();
                        break;
                    case 322:
                        this.phpClassPrefix = codedInputByteBufferNano.readString();
                        break;
                    case 330:
                        this.phpNamespace = codedInputByteBufferNano.readString();
                        break;
                    case 336:
                        this.phpGenericServices = codedInputByteBufferNano.readBool();
                        break;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static FileOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (FileOptions) MessageNano.mergeFrom(new FileOptions(), bArr);
        }

        public static FileOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new FileOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MessageOptions extends ExtendableMessageNano<MessageOptions> {
        private static volatile MessageOptions[] _emptyArray;
        public boolean deprecated;
        public String[] experimentalJavaBuilderInterface;
        public String[] experimentalJavaInterfaceExtends;
        public String[] experimentalJavaMessageInterface;
        public boolean mapEntry;
        public boolean messageSetWireFormat;
        public boolean noStandardDescriptorAccessor;
        public UninterpretedOption[] uninterpretedOption;

        public static MessageOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MessageOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MessageOptions() {
            clear();
        }

        public MessageOptions clear() {
            this.experimentalJavaMessageInterface = WireFormatNano.EMPTY_STRING_ARRAY;
            this.experimentalJavaBuilderInterface = WireFormatNano.EMPTY_STRING_ARRAY;
            this.experimentalJavaInterfaceExtends = WireFormatNano.EMPTY_STRING_ARRAY;
            this.messageSetWireFormat = false;
            this.noStandardDescriptorAccessor = false;
            this.deprecated = false;
            this.mapEntry = false;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            boolean z = this.messageSetWireFormat;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            boolean z2 = this.noStandardDescriptorAccessor;
            if (z2) {
                codedOutputByteBufferNano.writeBool(2, z2);
            }
            boolean z3 = this.deprecated;
            if (z3) {
                codedOutputByteBufferNano.writeBool(3, z3);
            }
            String[] strArr = this.experimentalJavaMessageInterface;
            int OplusGLSurfaceView_13 = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.experimentalJavaMessageInterface;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(4, str);
                    }
                    i2++;
                }
            }
            String[] strArr3 = this.experimentalJavaBuilderInterface;
            if (strArr3 != null && strArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr4 = this.experimentalJavaBuilderInterface;
                    if (i3 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i3];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(5, str2);
                    }
                    i3++;
                }
            }
            String[] strArr5 = this.experimentalJavaInterfaceExtends;
            if (strArr5 != null && strArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    String[] strArr6 = this.experimentalJavaInterfaceExtends;
                    if (i4 >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i4];
                    if (str3 != null) {
                        codedOutputByteBufferNano.writeString(6, str3);
                    }
                    i4++;
                }
            }
            boolean z4 = this.mapEntry;
            if (z4) {
                codedOutputByteBufferNano.writeBool(7, z4);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.messageSetWireFormat;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            boolean z2 = this.noStandardDescriptorAccessor;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
            }
            boolean z3 = this.deprecated;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z3);
            }
            String[] strArr = this.experimentalJavaMessageInterface;
            int OplusGLSurfaceView_13 = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.experimentalJavaMessageInterface;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            String[] strArr3 = this.experimentalJavaBuilderInterface;
            if (strArr3 != null && strArr3.length > 0) {
                int i4 = 0;
                int iComputeStringSizeNoTag2 = 0;
                int i5 = 0;
                while (true) {
                    String[] strArr4 = this.experimentalJavaBuilderInterface;
                    if (i4 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i4];
                    if (str2 != null) {
                        i5++;
                        iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag2 + (i5 * 1);
            }
            String[] strArr5 = this.experimentalJavaInterfaceExtends;
            if (strArr5 != null && strArr5.length > 0) {
                int i6 = 0;
                int iComputeStringSizeNoTag3 = 0;
                int i7 = 0;
                while (true) {
                    String[] strArr6 = this.experimentalJavaInterfaceExtends;
                    if (i6 >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i6];
                    if (str3 != null) {
                        i7++;
                        iComputeStringSizeNoTag3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag3 + (i7 * 1);
            }
            boolean z4 = this.mapEntry;
            if (z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z4);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public MessageOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.messageSetWireFormat = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.noStandardDescriptorAccessor = codedInputByteBufferNano.readBool();
                } else if (tag == 24) {
                    this.deprecated = codedInputByteBufferNano.readBool();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr = this.experimentalJavaMessageInterface;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.experimentalJavaMessageInterface, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.experimentalJavaMessageInterface = strArr2;
                } else if (tag == 42) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    String[] strArr3 = this.experimentalJavaBuilderInterface;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    String[] strArr4 = new String[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.experimentalJavaBuilderInterface, 0, strArr4, 0, length2);
                    }
                    while (length2 < strArr4.length - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.experimentalJavaBuilderInterface = strArr4;
                } else if (tag == 50) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr5 = this.experimentalJavaInterfaceExtends;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    String[] strArr6 = new String[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.experimentalJavaInterfaceExtends, 0, strArr6, 0, length3);
                    }
                    while (length3 < strArr6.length - 1) {
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    this.experimentalJavaInterfaceExtends = strArr6;
                } else if (tag == 56) {
                    this.mapEntry = codedInputByteBufferNano.readBool();
                } else if (tag != 7994) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length4 = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length4);
                    }
                    while (length4 < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length4] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    uninterpretedOptionArr2[length4] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length4]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static MessageOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (MessageOptions) MessageNano.mergeFrom(new MessageOptions(), bArr);
        }

        public static MessageOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new MessageOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FieldOptions extends ExtendableMessageNano<FieldOptions> {
        private static volatile FieldOptions[] _emptyArray;

        @NanoEnumValue(legacy = false, value = CType.class)
        public int ctype;
        public boolean deprecated;
        public boolean deprecatedRawMessage;
        public boolean enforceUtf8;

        @NanoEnumValue(legacy = false, value = JSType.class)
        public int jstype;
        public boolean lazy;
        public boolean packed;
        public UninterpretedOption[] uninterpretedOption;
        public UpgradedOption[] upgradedOption;
        public boolean weak;

        public interface CType {

            @NanoEnumValue(legacy = false, value = CType.class)
            public static final int CORD = 1;

            @NanoEnumValue(legacy = false, value = CType.class)
            public static final int STRING = 0;

            @NanoEnumValue(legacy = false, value = CType.class)
            public static final int STRING_PIECE = 2;
        }

        public interface JSType {

            @NanoEnumValue(legacy = false, value = JSType.class)
            public static final int JS_NORMAL = 0;

            @NanoEnumValue(legacy = false, value = JSType.class)
            public static final int JS_NUMBER = 2;

            @NanoEnumValue(legacy = false, value = JSType.class)
            public static final int JS_STRING = 1;
        }

        @NanoEnumValue(legacy = false, value = CType.class)
        public static int checkCTypeOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 2) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(37);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum CType");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = CType.class)
        public static int[] checkCTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkCTypeOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = JSType.class)
        public static int checkJSTypeOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 2) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(38);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum JSType");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = JSType.class)
        public static int[] checkJSTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkJSTypeOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        public static final class UpgradedOption extends ExtendableMessageNano<UpgradedOption> {
            private static volatile UpgradedOption[] _emptyArray;
            public String name;
            public String value;

            public static UpgradedOption[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new UpgradedOption[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public UpgradedOption() {
                clear();
            }

            public UpgradedOption clear() {
                this.name = "";
                this.value = "";
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
                String str = this.name;
                if (str != null && !str.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.name);
                }
                String str2 = this.value;
                if (str2 != null && !str2.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.value);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                String str = this.name;
                if (str != null && !str.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
                }
                String str2 = this.value;
                return (str2 == null || str2.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.value);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public UpgradedOption mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        this.name = codedInputByteBufferNano.readString();
                    } else if (tag != 18) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.value = codedInputByteBufferNano.readString();
                    }
                }
            }

            public static UpgradedOption parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (UpgradedOption) MessageNano.mergeFrom(new UpgradedOption(), bArr);
            }

            public static UpgradedOption parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new UpgradedOption().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static FieldOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FieldOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FieldOptions() {
            clear();
        }

        public FieldOptions clear() {
            this.ctype = 0;
            this.packed = false;
            this.jstype = 0;
            this.lazy = false;
            this.deprecated = false;
            this.weak = false;
            this.upgradedOption = UpgradedOption.emptyArray();
            this.deprecatedRawMessage = false;
            this.enforceUtf8 = true;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            int OplusGLSurfaceView_13 = this.ctype;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputByteBufferNano.writeInt32(1, OplusGLSurfaceView_13);
            }
            boolean z = this.packed;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                codedOutputByteBufferNano.writeBool(3, z2);
            }
            boolean z3 = this.lazy;
            if (z3) {
                codedOutputByteBufferNano.writeBool(5, z3);
            }
            int i2 = this.jstype;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i2);
            }
            boolean z4 = this.weak;
            if (z4) {
                codedOutputByteBufferNano.writeBool(10, z4);
            }
            UpgradedOption[] upgradedOptionArr = this.upgradedOption;
            int i3 = 0;
            if (upgradedOptionArr != null && upgradedOptionArr.length > 0) {
                int i4 = 0;
                while (true) {
                    UpgradedOption[] upgradedOptionArr2 = this.upgradedOption;
                    if (i4 >= upgradedOptionArr2.length) {
                        break;
                    }
                    UpgradedOption upgradedOption = upgradedOptionArr2[i4];
                    if (upgradedOption != null) {
                        codedOutputByteBufferNano.writeMessage(11, upgradedOption);
                    }
                    i4++;
                }
            }
            boolean z5 = this.deprecatedRawMessage;
            if (z5) {
                codedOutputByteBufferNano.writeBool(12, z5);
            }
            boolean z6 = this.enforceUtf8;
            if (!z6) {
                codedOutputByteBufferNano.writeBool(13, z6);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i3 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i3];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int OplusGLSurfaceView_13 = this.ctype;
            if (OplusGLSurfaceView_13 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, OplusGLSurfaceView_13);
            }
            boolean z = this.packed;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z2);
            }
            boolean z3 = this.lazy;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z3);
            }
            int i2 = this.jstype;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
            }
            boolean z4 = this.weak;
            if (z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z4);
            }
            UpgradedOption[] upgradedOptionArr = this.upgradedOption;
            int i3 = 0;
            if (upgradedOptionArr != null && upgradedOptionArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UpgradedOption[] upgradedOptionArr2 = this.upgradedOption;
                    if (i4 >= upgradedOptionArr2.length) {
                        break;
                    }
                    UpgradedOption upgradedOption = upgradedOptionArr2[i4];
                    if (upgradedOption != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(11, upgradedOption);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            boolean z5 = this.deprecatedRawMessage;
            if (z5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z5);
            }
            boolean z6 = this.enforceUtf8;
            if (!z6) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z6);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i3 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i3];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i3++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public FieldOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.ctype = checkCTypeOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 16:
                        this.packed = codedInputByteBufferNano.readBool();
                        break;
                    case 24:
                        this.deprecated = codedInputByteBufferNano.readBool();
                        break;
                    case 40:
                        this.lazy = codedInputByteBufferNano.readBool();
                        break;
                    case 48:
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.jstype = checkJSTypeOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 80:
                        this.weak = codedInputByteBufferNano.readBool();
                        break;
                    case 90:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        UpgradedOption[] upgradedOptionArr = this.upgradedOption;
                        int length = upgradedOptionArr == null ? 0 : upgradedOptionArr.length;
                        UpgradedOption[] upgradedOptionArr2 = new UpgradedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.upgradedOption, 0, upgradedOptionArr2, 0, length);
                        }
                        while (length < upgradedOptionArr2.length - 1) {
                            upgradedOptionArr2[length] = new UpgradedOption();
                            codedInputByteBufferNano.readMessage(upgradedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        upgradedOptionArr2[length] = new UpgradedOption();
                        codedInputByteBufferNano.readMessage(upgradedOptionArr2[length]);
                        this.upgradedOption = upgradedOptionArr2;
                        break;
                    case 96:
                        this.deprecatedRawMessage = codedInputByteBufferNano.readBool();
                        break;
                    case 104:
                        this.enforceUtf8 = codedInputByteBufferNano.readBool();
                        break;
                    case 7994:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length2 = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length2);
                        }
                        while (length2 < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length2] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        uninterpretedOptionArr2[length2] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length2]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static FieldOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (FieldOptions) MessageNano.mergeFrom(new FieldOptions(), bArr);
        }

        public static FieldOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new FieldOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class OneofOptions extends ExtendableMessageNano<OneofOptions> {
        private static volatile OneofOptions[] _emptyArray;
        public UninterpretedOption[] uninterpretedOption;

        public static OneofOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OneofOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public OneofOptions() {
            clear();
        }

        public OneofOptions clear() {
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public OneofOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 7994) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static OneofOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (OneofOptions) MessageNano.mergeFrom(new OneofOptions(), bArr);
        }

        public static OneofOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new OneofOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumOptions extends ExtendableMessageNano<EnumOptions> {
        private static volatile EnumOptions[] _emptyArray;
        public boolean allowAlias;
        public boolean deprecated;
        public String proto1Name;
        public UninterpretedOption[] uninterpretedOption;

        public static EnumOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumOptions() {
            clear();
        }

        public EnumOptions clear() {
            this.proto1Name = "";
            this.allowAlias = false;
            this.deprecated = false;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            String str = this.proto1Name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.proto1Name);
            }
            boolean z = this.allowAlias;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                codedOutputByteBufferNano.writeBool(3, z2);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String str = this.proto1Name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.proto1Name);
            }
            boolean z = this.allowAlias;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z2);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public EnumOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.proto1Name = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.allowAlias = codedInputByteBufferNano.readBool();
                } else if (tag == 24) {
                    this.deprecated = codedInputByteBufferNano.readBool();
                } else if (tag != 7994) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static EnumOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (EnumOptions) MessageNano.mergeFrom(new EnumOptions(), bArr);
        }

        public static EnumOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new EnumOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumValueOptions extends ExtendableMessageNano<EnumValueOptions> {
        private static volatile EnumValueOptions[] _emptyArray;
        public boolean deprecated;
        public UninterpretedOption[] uninterpretedOption;

        public static EnumValueOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumValueOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumValueOptions() {
            clear();
        }

        public EnumValueOptions clear() {
            this.deprecated = false;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            boolean z = this.deprecated;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.deprecated;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public EnumValueOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.deprecated = codedInputByteBufferNano.readBool();
                } else if (tag != 7994) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static EnumValueOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (EnumValueOptions) MessageNano.mergeFrom(new EnumValueOptions(), bArr);
        }

        public static EnumValueOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new EnumValueOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ServiceOptions extends ExtendableMessageNano<ServiceOptions> {
        private static volatile ServiceOptions[] _emptyArray;
        public boolean deprecated;
        public double failureDetectionDelay;
        public boolean multicastStub;
        public UninterpretedOption[] uninterpretedOption;

        public static ServiceOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ServiceOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ServiceOptions() {
            clear();
        }

        public ServiceOptions clear() {
            this.multicastStub = false;
            this.failureDetectionDelay = -1.0d;
            this.deprecated = false;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            if (Double.doubleToLongBits(this.failureDetectionDelay) != Double.doubleToLongBits(-1.0d)) {
                codedOutputByteBufferNano.writeDouble(16, this.failureDetectionDelay);
            }
            boolean z = this.multicastStub;
            if (z) {
                codedOutputByteBufferNano.writeBool(20, z);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                codedOutputByteBufferNano.writeBool(33, z2);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (Double.doubleToLongBits(this.failureDetectionDelay) != Double.doubleToLongBits(-1.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(16, this.failureDetectionDelay);
            }
            boolean z = this.multicastStub;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, z);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, z2);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (OplusGLSurfaceView_13 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[OplusGLSurfaceView_13];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public ServiceOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 129) {
                    this.failureDetectionDelay = codedInputByteBufferNano.readDouble();
                } else if (tag == 160) {
                    this.multicastStub = codedInputByteBufferNano.readBool();
                } else if (tag == 264) {
                    this.deprecated = codedInputByteBufferNano.readBool();
                } else if (tag != 7994) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static ServiceOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (ServiceOptions) MessageNano.mergeFrom(new ServiceOptions(), bArr);
        }

        public static ServiceOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ServiceOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MethodOptions extends ExtendableMessageNano<MethodOptions> {
        private static volatile MethodOptions[] _emptyArray;
        public int clientLogging;
        public boolean clientStreaming;
        public double deadline;
        public boolean deprecated;
        public boolean duplicateSuppression;
        public boolean endUserCredsRequested;
        public boolean failFast;
        public boolean goLegacyChannelApi;

        @NanoEnumValue(legacy = false, value = IdempotencyLevel.class)
        public int idempotencyLevel;
        public long legacyClientInitialTokens;
        public String legacyResultType;
        public long legacyServerInitialTokens;
        public String legacyStreamType;

        @NanoEnumValue(legacy = false, value = TokenUnit.class)
        public int legacyTokenUnit;

        @NanoEnumValue(legacy = false, value = LogLevel.class)
        public int logLevel;

        @NanoEnumValue(legacy = false, value = Protocol.class)
        public int protocol;

        @NanoEnumValue(legacy = false, value = Format.class)
        public int requestFormat;

        @NanoEnumValue(legacy = false, value = Format.class)
        public int responseFormat;
        public String securityLabel;

        @NanoEnumValue(legacy = false, value = SecurityLevel.class)
        public int securityLevel;
        public int serverLogging;
        public boolean serverStreaming;
        public String streamType;
        public UninterpretedOption[] uninterpretedOption;

        public interface Format {

            @NanoEnumValue(legacy = false, value = Format.class)
            public static final int UNCOMPRESSED = 0;

            @NanoEnumValue(legacy = false, value = Format.class)
            public static final int ZIPPY_COMPRESSED = 1;
        }

        public interface IdempotencyLevel {

            @NanoEnumValue(legacy = false, value = IdempotencyLevel.class)
            public static final int IDEMPOTENCY_UNKNOWN = 0;

            @NanoEnumValue(legacy = false, value = IdempotencyLevel.class)
            public static final int IDEMPOTENT = 2;

            @NanoEnumValue(legacy = false, value = IdempotencyLevel.class)
            public static final int NO_SIDE_EFFECTS = 1;
        }

        public interface LogLevel {

            @NanoEnumValue(legacy = false, value = LogLevel.class)
            public static final int LOG_HEADER_AND_FILTERED_PAYLOAD = 3;

            @NanoEnumValue(legacy = false, value = LogLevel.class)
            public static final int LOG_HEADER_AND_NON_PRIVATE_PAYLOAD_INTERNAL = 2;

            @NanoEnumValue(legacy = false, value = LogLevel.class)
            public static final int LOG_HEADER_AND_PAYLOAD = 4;

            @NanoEnumValue(legacy = false, value = LogLevel.class)
            public static final int LOG_HEADER_ONLY = 1;

            @NanoEnumValue(legacy = false, value = LogLevel.class)
            public static final int LOG_NONE = 0;
        }

        public interface Protocol {

            @NanoEnumValue(legacy = false, value = Protocol.class)
            public static final int TCP = 0;

            @NanoEnumValue(legacy = false, value = Protocol.class)
            public static final int UDP = 1;
        }

        public interface SecurityLevel {

            @NanoEnumValue(legacy = false, value = SecurityLevel.class)
            public static final int INTEGRITY = 1;

            @NanoEnumValue(legacy = false, value = SecurityLevel.class)
            public static final int NONE = 0;

            @NanoEnumValue(legacy = false, value = SecurityLevel.class)
            public static final int PRIVACY_AND_INTEGRITY = 2;

            @NanoEnumValue(legacy = false, value = SecurityLevel.class)
            public static final int STRONG_PRIVACY_AND_INTEGRITY = 3;
        }

        public interface TokenUnit {

            @NanoEnumValue(legacy = false, value = TokenUnit.class)
            public static final int BYTE = 1;

            @NanoEnumValue(legacy = false, value = TokenUnit.class)
            public static final int MESSAGE = 0;
        }

        @NanoEnumValue(legacy = false, value = Protocol.class)
        public static int checkProtocolOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 1) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum Protocol");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = Protocol.class)
        public static int[] checkProtocolOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkProtocolOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = SecurityLevel.class)
        public static int checkSecurityLevelOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 3) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(45);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum SecurityLevel");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = SecurityLevel.class)
        public static int[] checkSecurityLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkSecurityLevelOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = Format.class)
        public static int checkFormatOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 1) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(38);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum Format");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = Format.class)
        public static int[] checkFormatOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkFormatOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = LogLevel.class)
        public static int checkLogLevelOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 4) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum LogLevel");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = LogLevel.class)
        public static int[] checkLogLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkLogLevelOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = TokenUnit.class)
        public static int checkTokenUnitOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 1) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum TokenUnit");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = TokenUnit.class)
        public static int[] checkTokenUnitOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkTokenUnitOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        @NanoEnumValue(legacy = false, value = IdempotencyLevel.class)
        public static int checkIdempotencyLevelOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 2) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(48);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum IdempotencyLevel");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = IdempotencyLevel.class)
        public static int[] checkIdempotencyLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkIdempotencyLevelOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        public static MethodOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MethodOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MethodOptions() {
            clear();
        }

        public MethodOptions clear() {
            this.protocol = 0;
            this.deadline = -1.0d;
            this.duplicateSuppression = false;
            this.failFast = false;
            this.endUserCredsRequested = false;
            this.clientLogging = 256;
            this.serverLogging = 256;
            this.securityLevel = 0;
            this.responseFormat = 0;
            this.requestFormat = 0;
            this.streamType = "";
            this.securityLabel = "";
            this.clientStreaming = false;
            this.serverStreaming = false;
            this.legacyStreamType = "";
            this.legacyResultType = "";
            this.goLegacyChannelApi = false;
            this.legacyClientInitialTokens = -1L;
            this.legacyServerInitialTokens = -1L;
            this.legacyTokenUnit = 1;
            this.logLevel = 2;
            this.deprecated = false;
            this.idempotencyLevel = 0;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            int OplusGLSurfaceView_13 = this.protocol;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputByteBufferNano.writeInt32(7, OplusGLSurfaceView_13);
            }
            if (Double.doubleToLongBits(this.deadline) != Double.doubleToLongBits(-1.0d)) {
                codedOutputByteBufferNano.writeDouble(8, this.deadline);
            }
            boolean z = this.duplicateSuppression;
            if (z) {
                codedOutputByteBufferNano.writeBool(9, z);
            }
            boolean z2 = this.failFast;
            if (z2) {
                codedOutputByteBufferNano.writeBool(10, z2);
            }
            int i2 = this.clientLogging;
            if (i2 != 256) {
                codedOutputByteBufferNano.writeSInt32(11, i2);
            }
            int i3 = this.serverLogging;
            if (i3 != 256) {
                codedOutputByteBufferNano.writeSInt32(12, i3);
            }
            int i4 = this.securityLevel;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(13, i4);
            }
            int i5 = this.responseFormat;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(15, i5);
            }
            int i6 = this.requestFormat;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeInt32(17, i6);
            }
            String str = this.streamType;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(18, this.streamType);
            }
            String str2 = this.securityLabel;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(19, this.securityLabel);
            }
            boolean z3 = this.clientStreaming;
            if (z3) {
                codedOutputByteBufferNano.writeBool(20, z3);
            }
            boolean z4 = this.serverStreaming;
            if (z4) {
                codedOutputByteBufferNano.writeBool(21, z4);
            }
            String str3 = this.legacyStreamType;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(22, this.legacyStreamType);
            }
            String str4 = this.legacyResultType;
            if (str4 != null && !str4.equals("")) {
                codedOutputByteBufferNano.writeString(23, this.legacyResultType);
            }
            long OplusGLSurfaceView_15 = this.legacyClientInitialTokens;
            if (OplusGLSurfaceView_15 != -1) {
                codedOutputByteBufferNano.writeInt64(24, OplusGLSurfaceView_15);
            }
            long j2 = this.legacyServerInitialTokens;
            if (j2 != -1) {
                codedOutputByteBufferNano.writeInt64(25, j2);
            }
            boolean z5 = this.endUserCredsRequested;
            if (z5) {
                codedOutputByteBufferNano.writeBool(26, z5);
            }
            int i7 = this.logLevel;
            if (i7 != 2) {
                codedOutputByteBufferNano.writeInt32(27, i7);
            }
            int i8 = this.legacyTokenUnit;
            if (i8 != 1) {
                codedOutputByteBufferNano.writeInt32(28, i8);
            }
            boolean z6 = this.goLegacyChannelApi;
            if (z6) {
                codedOutputByteBufferNano.writeBool(29, z6);
            }
            boolean z7 = this.deprecated;
            if (z7) {
                codedOutputByteBufferNano.writeBool(33, z7);
            }
            int i9 = this.idempotencyLevel;
            if (i9 != 0) {
                codedOutputByteBufferNano.writeInt32(34, i9);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i10 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i10 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i10];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i10++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int OplusGLSurfaceView_13 = this.protocol;
            if (OplusGLSurfaceView_13 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, OplusGLSurfaceView_13);
            }
            if (Double.doubleToLongBits(this.deadline) != Double.doubleToLongBits(-1.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(8, this.deadline);
            }
            boolean z = this.duplicateSuppression;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
            }
            boolean z2 = this.failFast;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z2);
            }
            int i2 = this.clientLogging;
            if (i2 != 256) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(11, i2);
            }
            int i3 = this.serverLogging;
            if (i3 != 256) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(12, i3);
            }
            int i4 = this.securityLevel;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i4);
            }
            int i5 = this.responseFormat;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i5);
            }
            int i6 = this.requestFormat;
            if (i6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, i6);
            }
            String str = this.streamType;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.streamType);
            }
            String str2 = this.securityLabel;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.securityLabel);
            }
            boolean z3 = this.clientStreaming;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, z3);
            }
            boolean z4 = this.serverStreaming;
            if (z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, z4);
            }
            String str3 = this.legacyStreamType;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.legacyStreamType);
            }
            String str4 = this.legacyResultType;
            if (str4 != null && !str4.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.legacyResultType);
            }
            long OplusGLSurfaceView_15 = this.legacyClientInitialTokens;
            if (OplusGLSurfaceView_15 != -1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(24, OplusGLSurfaceView_15);
            }
            long j2 = this.legacyServerInitialTokens;
            if (j2 != -1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(25, j2);
            }
            boolean z5 = this.endUserCredsRequested;
            if (z5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, z5);
            }
            int i7 = this.logLevel;
            if (i7 != 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(27, i7);
            }
            int i8 = this.legacyTokenUnit;
            if (i8 != 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(28, i8);
            }
            boolean z6 = this.goLegacyChannelApi;
            if (z6) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(29, z6);
            }
            boolean z7 = this.deprecated;
            if (z7) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, z7);
            }
            int i9 = this.idempotencyLevel;
            if (i9 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(34, i9);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i10 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i10 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i10];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i10++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public MethodOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 56:
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.protocol = checkProtocolOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 65:
                        this.deadline = codedInputByteBufferNano.readDouble();
                        break;
                    case 72:
                        this.duplicateSuppression = codedInputByteBufferNano.readBool();
                        break;
                    case 80:
                        this.failFast = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        this.clientLogging = codedInputByteBufferNano.readSInt32();
                        break;
                    case 96:
                        this.serverLogging = codedInputByteBufferNano.readSInt32();
                        break;
                    case 104:
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.securityLevel = checkSecurityLevelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 120:
                        int position3 = codedInputByteBufferNano.getPosition();
                        try {
                            this.responseFormat = checkFormatOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused3) {
                            codedInputByteBufferNano.rewindToPosition(position3);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 136:
                        int position4 = codedInputByteBufferNano.getPosition();
                        try {
                            this.requestFormat = checkFormatOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused4) {
                            codedInputByteBufferNano.rewindToPosition(position4);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 146:
                        this.streamType = codedInputByteBufferNano.readString();
                        break;
                    case 154:
                        this.securityLabel = codedInputByteBufferNano.readString();
                        break;
                    case 160:
                        this.clientStreaming = codedInputByteBufferNano.readBool();
                        break;
                    case 168:
                        this.serverStreaming = codedInputByteBufferNano.readBool();
                        break;
                    case 178:
                        this.legacyStreamType = codedInputByteBufferNano.readString();
                        break;
                    case 186:
                        this.legacyResultType = codedInputByteBufferNano.readString();
                        break;
                    case 192:
                        this.legacyClientInitialTokens = codedInputByteBufferNano.readInt64();
                        break;
                    case 200:
                        this.legacyServerInitialTokens = codedInputByteBufferNano.readInt64();
                        break;
                    case 208:
                        this.endUserCredsRequested = codedInputByteBufferNano.readBool();
                        break;
                    case 216:
                        int position5 = codedInputByteBufferNano.getPosition();
                        try {
                            this.logLevel = checkLogLevelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused5) {
                            codedInputByteBufferNano.rewindToPosition(position5);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 224:
                        int position6 = codedInputByteBufferNano.getPosition();
                        try {
                            this.legacyTokenUnit = checkTokenUnitOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused6) {
                            codedInputByteBufferNano.rewindToPosition(position6);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 232:
                        this.goLegacyChannelApi = codedInputByteBufferNano.readBool();
                        break;
                    case 264:
                        this.deprecated = codedInputByteBufferNano.readBool();
                        break;
                    case 272:
                        int position7 = codedInputByteBufferNano.getPosition();
                        try {
                            this.idempotencyLevel = checkIdempotencyLevelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused7) {
                            codedInputByteBufferNano.rewindToPosition(position7);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static MethodOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (MethodOptions) MessageNano.mergeFrom(new MethodOptions(), bArr);
        }

        public static MethodOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new MethodOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class StreamOptions extends ExtendableMessageNano<StreamOptions> {
        private static volatile StreamOptions[] _emptyArray;
        public long clientInitialTokens;
        public int clientLogging;
        public double deadline;
        public boolean deprecated;
        public boolean endUserCredsRequested;
        public boolean failFast;

        @NanoEnumValue(legacy = false, value = MethodOptions.LogLevel.class)
        public int logLevel;
        public String securityLabel;

        @NanoEnumValue(legacy = false, value = MethodOptions.SecurityLevel.class)
        public int securityLevel;
        public long serverInitialTokens;
        public int serverLogging;

        @NanoEnumValue(legacy = false, value = TokenUnit.class)
        public int tokenUnit;
        public UninterpretedOption[] uninterpretedOption;

        public interface TokenUnit {

            @NanoEnumValue(legacy = false, value = TokenUnit.class)
            public static final int BYTE = 1;

            @NanoEnumValue(legacy = false, value = TokenUnit.class)
            public static final int MESSAGE = 0;
        }

        @NanoEnumValue(legacy = false, value = TokenUnit.class)
        public static int checkTokenUnitOrThrow(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 1) {
                return OplusGLSurfaceView_13;
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is not PlatformImplementations.kt_3 valid enum TokenUnit");
            throw new IllegalArgumentException(sb.toString());
        }

        @NanoEnumValue(legacy = false, value = TokenUnit.class)
        public static int[] checkTokenUnitOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int OplusGLSurfaceView_13 : iArr2) {
                checkTokenUnitOrThrow(OplusGLSurfaceView_13);
            }
            return iArr2;
        }

        public static StreamOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StreamOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public StreamOptions() {
            clear();
        }

        public StreamOptions clear() {
            this.clientInitialTokens = -1L;
            this.serverInitialTokens = -1L;
            this.tokenUnit = 0;
            this.securityLevel = 0;
            this.securityLabel = "";
            this.clientLogging = 256;
            this.serverLogging = 256;
            this.deadline = -1.0d;
            this.failFast = false;
            this.endUserCredsRequested = false;
            this.logLevel = 2;
            this.deprecated = false;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            long OplusGLSurfaceView_15 = this.clientInitialTokens;
            if (OplusGLSurfaceView_15 != -1) {
                codedOutputByteBufferNano.writeInt64(1, OplusGLSurfaceView_15);
            }
            long j2 = this.serverInitialTokens;
            if (j2 != -1) {
                codedOutputByteBufferNano.writeInt64(2, j2);
            }
            int OplusGLSurfaceView_13 = this.tokenUnit;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputByteBufferNano.writeInt32(3, OplusGLSurfaceView_13);
            }
            int i2 = this.securityLevel;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            String str = this.securityLabel;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.securityLabel);
            }
            int i3 = this.clientLogging;
            if (i3 != 256) {
                codedOutputByteBufferNano.writeInt32(6, i3);
            }
            int i4 = this.serverLogging;
            if (i4 != 256) {
                codedOutputByteBufferNano.writeInt32(7, i4);
            }
            if (Double.doubleToLongBits(this.deadline) != Double.doubleToLongBits(-1.0d)) {
                codedOutputByteBufferNano.writeDouble(8, this.deadline);
            }
            boolean z = this.failFast;
            if (z) {
                codedOutputByteBufferNano.writeBool(9, z);
            }
            boolean z2 = this.endUserCredsRequested;
            if (z2) {
                codedOutputByteBufferNano.writeBool(10, z2);
            }
            int i5 = this.logLevel;
            if (i5 != 2) {
                codedOutputByteBufferNano.writeInt32(11, i5);
            }
            boolean z3 = this.deprecated;
            if (z3) {
                codedOutputByteBufferNano.writeBool(33, z3);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i6++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long OplusGLSurfaceView_15 = this.clientInitialTokens;
            if (OplusGLSurfaceView_15 != -1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, OplusGLSurfaceView_15);
            }
            long j2 = this.serverInitialTokens;
            if (j2 != -1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j2);
            }
            int OplusGLSurfaceView_13 = this.tokenUnit;
            if (OplusGLSurfaceView_13 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, OplusGLSurfaceView_13);
            }
            int i2 = this.securityLevel;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            String str = this.securityLabel;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.securityLabel);
            }
            int i3 = this.clientLogging;
            if (i3 != 256) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
            }
            int i4 = this.serverLogging;
            if (i4 != 256) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i4);
            }
            if (Double.doubleToLongBits(this.deadline) != Double.doubleToLongBits(-1.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(8, this.deadline);
            }
            boolean z = this.failFast;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
            }
            boolean z2 = this.endUserCredsRequested;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z2);
            }
            int i5 = this.logLevel;
            if (i5 != 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i5);
            }
            boolean z3 = this.deprecated;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, z3);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i6++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public StreamOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.clientInitialTokens = codedInputByteBufferNano.readInt64();
                        break;
                    case 16:
                        this.serverInitialTokens = codedInputByteBufferNano.readInt64();
                        break;
                    case 24:
                        int position = codedInputByteBufferNano.getPosition();
                        try {
                            this.tokenUnit = checkTokenUnitOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 32:
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.securityLevel = MethodOptions.checkSecurityLevelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 42:
                        this.securityLabel = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        this.clientLogging = codedInputByteBufferNano.readInt32();
                        break;
                    case 56:
                        this.serverLogging = codedInputByteBufferNano.readInt32();
                        break;
                    case 65:
                        this.deadline = codedInputByteBufferNano.readDouble();
                        break;
                    case 72:
                        this.failFast = codedInputByteBufferNano.readBool();
                        break;
                    case 80:
                        this.endUserCredsRequested = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        int position3 = codedInputByteBufferNano.getPosition();
                        try {
                            this.logLevel = MethodOptions.checkLogLevelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (IllegalArgumentException unused3) {
                            codedInputByteBufferNano.rewindToPosition(position3);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 264:
                        this.deprecated = codedInputByteBufferNano.readBool();
                        break;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static StreamOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (StreamOptions) MessageNano.mergeFrom(new StreamOptions(), bArr);
        }

        public static StreamOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new StreamOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class UninterpretedOption extends ExtendableMessageNano<UninterpretedOption> {
        private static volatile UninterpretedOption[] _emptyArray;
        public String aggregateValue;
        public double doubleValue;
        public String identifierValue;
        public NamePart[] name;
        public long negativeIntValue;
        public long positiveIntValue;
        public byte[] stringValue;

        public static final class NamePart extends ExtendableMessageNano<NamePart> {
            private static volatile NamePart[] _emptyArray;
            public boolean isExtension;
            public String namePart;

            public static NamePart[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new NamePart[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public NamePart() {
                clear();
            }

            public NamePart clear() {
                this.namePart = "";
                this.isExtension = false;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
                codedOutputByteBufferNano.writeString(1, this.namePart);
                codedOutputByteBufferNano.writeBool(2, this.isExtension);
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.namePart) + CodedOutputByteBufferNano.computeBoolSize(2, this.isExtension);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public NamePart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        this.namePart = codedInputByteBufferNano.readString();
                    } else if (tag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.isExtension = codedInputByteBufferNano.readBool();
                    }
                }
            }

            public static NamePart parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (NamePart) MessageNano.mergeFrom(new NamePart(), bArr);
            }

            public static NamePart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new NamePart().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static UninterpretedOption[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UninterpretedOption[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UninterpretedOption() {
            clear();
        }

        public UninterpretedOption clear() {
            this.name = NamePart.emptyArray();
            this.identifierValue = "";
            this.positiveIntValue = 0L;
            this.negativeIntValue = 0L;
            this.doubleValue = 0.0d;
            this.stringValue = WireFormatNano.EMPTY_BYTES;
            this.aggregateValue = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            NamePart[] namePartArr = this.name;
            if (namePartArr != null && namePartArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    NamePart[] namePartArr2 = this.name;
                    if (OplusGLSurfaceView_13 >= namePartArr2.length) {
                        break;
                    }
                    NamePart namePart = namePartArr2[OplusGLSurfaceView_13];
                    if (namePart != null) {
                        codedOutputByteBufferNano.writeMessage(2, namePart);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            String str = this.identifierValue;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.identifierValue);
            }
            long OplusGLSurfaceView_15 = this.positiveIntValue;
            if (OplusGLSurfaceView_15 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, OplusGLSurfaceView_15);
            }
            long j2 = this.negativeIntValue;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeInt64(5, j2);
            }
            if (Double.doubleToLongBits(this.doubleValue) != Double.doubleToLongBits(0.0d)) {
                codedOutputByteBufferNano.writeDouble(6, this.doubleValue);
            }
            if (!Arrays.equals(this.stringValue, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(7, this.stringValue);
            }
            String str2 = this.aggregateValue;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.aggregateValue);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            NamePart[] namePartArr = this.name;
            if (namePartArr != null && namePartArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    NamePart[] namePartArr2 = this.name;
                    if (OplusGLSurfaceView_13 >= namePartArr2.length) {
                        break;
                    }
                    NamePart namePart = namePartArr2[OplusGLSurfaceView_13];
                    if (namePart != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, namePart);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            String str = this.identifierValue;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.identifierValue);
            }
            long OplusGLSurfaceView_15 = this.positiveIntValue;
            if (OplusGLSurfaceView_15 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, OplusGLSurfaceView_15);
            }
            long j2 = this.negativeIntValue;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j2);
            }
            if (Double.doubleToLongBits(this.doubleValue) != Double.doubleToLongBits(0.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, this.doubleValue);
            }
            if (!Arrays.equals(this.stringValue, WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.stringValue);
            }
            String str2 = this.aggregateValue;
            return (str2 == null || str2.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.aggregateValue);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public UninterpretedOption mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    NamePart[] namePartArr = this.name;
                    int length = namePartArr == null ? 0 : namePartArr.length;
                    NamePart[] namePartArr2 = new NamePart[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.name, 0, namePartArr2, 0, length);
                    }
                    while (length < namePartArr2.length - 1) {
                        namePartArr2[length] = new NamePart();
                        codedInputByteBufferNano.readMessage(namePartArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    namePartArr2[length] = new NamePart();
                    codedInputByteBufferNano.readMessage(namePartArr2[length]);
                    this.name = namePartArr2;
                } else if (tag == 26) {
                    this.identifierValue = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.positiveIntValue = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.negativeIntValue = codedInputByteBufferNano.readInt64();
                } else if (tag == 49) {
                    this.doubleValue = codedInputByteBufferNano.readDouble();
                } else if (tag == 58) {
                    this.stringValue = codedInputByteBufferNano.readBytes();
                } else if (tag != 66) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.aggregateValue = codedInputByteBufferNano.readString();
                }
            }
        }

        public static UninterpretedOption parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (UninterpretedOption) MessageNano.mergeFrom(new UninterpretedOption(), bArr);
        }

        public static UninterpretedOption parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new UninterpretedOption().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SourceCodeInfo extends ExtendableMessageNano<SourceCodeInfo> {
        private static volatile SourceCodeInfo[] _emptyArray;
        public Location[] location;

        public static final class Location extends ExtendableMessageNano<Location> {
            private static volatile Location[] _emptyArray;
            public String leadingComments;
            public String[] leadingDetachedComments;
            public int[] path;
            public int[] span;
            public String trailingComments;

            public static Location[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Location[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public Location() {
                clear();
            }

            public Location clear() {
                this.path = WireFormatNano.EMPTY_INT_ARRAY;
                this.span = WireFormatNano.EMPTY_INT_ARRAY;
                this.leadingComments = "";
                this.trailingComments = "";
                this.leadingDetachedComments = WireFormatNano.EMPTY_STRING_ARRAY;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
                int[] iArr = this.path;
                int OplusGLSurfaceView_13 = 0;
                if (iArr != null && iArr.length > 0) {
                    int i2 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(10);
                    codedOutputByteBufferNano.writeRawVarint32(iComputeInt32SizeNoTag);
                    int i3 = 0;
                    while (true) {
                        int[] iArr3 = this.path;
                        if (i3 >= iArr3.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32NoTag(iArr3[i3]);
                        i3++;
                    }
                }
                int[] iArr4 = this.span;
                if (iArr4 != null && iArr4.length > 0) {
                    int i4 = 0;
                    int iComputeInt32SizeNoTag2 = 0;
                    while (true) {
                        int[] iArr5 = this.span;
                        if (i4 >= iArr5.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr5[i4]);
                        i4++;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(18);
                    codedOutputByteBufferNano.writeRawVarint32(iComputeInt32SizeNoTag2);
                    int i5 = 0;
                    while (true) {
                        int[] iArr6 = this.span;
                        if (i5 >= iArr6.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32NoTag(iArr6[i5]);
                        i5++;
                    }
                }
                String str = this.leadingComments;
                if (str != null && !str.equals("")) {
                    codedOutputByteBufferNano.writeString(3, this.leadingComments);
                }
                String str2 = this.trailingComments;
                if (str2 != null && !str2.equals("")) {
                    codedOutputByteBufferNano.writeString(4, this.trailingComments);
                }
                String[] strArr = this.leadingDetachedComments;
                if (strArr != null && strArr.length > 0) {
                    while (true) {
                        String[] strArr2 = this.leadingDetachedComments;
                        if (OplusGLSurfaceView_13 >= strArr2.length) {
                            break;
                        }
                        String str3 = strArr2[OplusGLSurfaceView_13];
                        if (str3 != null) {
                            codedOutputByteBufferNano.writeString(6, str3);
                        }
                        OplusGLSurfaceView_13++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int[] iArr = this.path;
                int OplusGLSurfaceView_13 = 0;
                if (iArr != null && iArr.length > 0) {
                    int i2 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(iComputeInt32SizeNoTag);
                }
                int[] iArr3 = this.span;
                if (iArr3 != null && iArr3.length > 0) {
                    int i3 = 0;
                    int iComputeInt32SizeNoTag2 = 0;
                    while (true) {
                        int[] iArr4 = this.span;
                        if (i3 >= iArr4.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr4[i3]);
                        i3++;
                    }
                    iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(iComputeInt32SizeNoTag2);
                }
                String str = this.leadingComments;
                if (str != null && !str.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.leadingComments);
                }
                String str2 = this.trailingComments;
                if (str2 != null && !str2.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.trailingComments);
                }
                String[] strArr = this.leadingDetachedComments;
                if (strArr == null || strArr.length <= 0) {
                    return iComputeSerializedSize;
                }
                int iComputeStringSizeNoTag = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.leadingDetachedComments;
                    if (OplusGLSurfaceView_13 >= strArr2.length) {
                        return iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
                    }
                    String str3 = strArr2[OplusGLSurfaceView_13];
                    if (str3 != null) {
                        i4++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    OplusGLSurfaceView_13++;
                }
            }

            @Override // com.google.protobuf.nano.MessageNano
            public Location mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr = this.path;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.path, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        iArr2[length] = codedInputByteBufferNano.readInt32();
                        this.path = iArr2;
                    } else if (tag == 10) {
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int OplusGLSurfaceView_13 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            OplusGLSurfaceView_13++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.path;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[OplusGLSurfaceView_13 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.path, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                            length2++;
                        }
                        this.path = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                    } else if (tag == 16) {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        int[] iArr5 = this.span;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[repeatedFieldArrayLength2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.span, 0, iArr6, 0, length3);
                        }
                        while (length3 < iArr6.length - 1) {
                            iArr6[length3] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        iArr6[length3] = codedInputByteBufferNano.readInt32();
                        this.span = iArr6;
                    } else if (tag == 18) {
                        int iPushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position2 = codedInputByteBufferNano.getPosition();
                        int i2 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i2++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position2);
                        int[] iArr7 = this.span;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int[] iArr8 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.span, 0, iArr8, 0, length4);
                        }
                        while (length4 < iArr8.length) {
                            iArr8[length4] = codedInputByteBufferNano.readInt32();
                            length4++;
                        }
                        this.span = iArr8;
                        codedInputByteBufferNano.popLimit(iPushLimit2);
                    } else if (tag == 26) {
                        this.leadingComments = codedInputByteBufferNano.readString();
                    } else if (tag == 34) {
                        this.trailingComments = codedInputByteBufferNano.readString();
                    } else if (tag != 50) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        String[] strArr = this.leadingDetachedComments;
                        int length5 = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.leadingDetachedComments, 0, strArr2, 0, length5);
                        }
                        while (length5 < strArr2.length - 1) {
                            strArr2[length5] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        strArr2[length5] = codedInputByteBufferNano.readString();
                        this.leadingDetachedComments = strArr2;
                    }
                }
            }

            public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (Location) MessageNano.mergeFrom(new Location(), bArr);
            }

            public static Location parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new Location().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static SourceCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SourceCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SourceCodeInfo() {
            clear();
        }

        public SourceCodeInfo clear() {
            this.location = Location.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            Location[] locationArr = this.location;
            if (locationArr != null && locationArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    Location[] locationArr2 = this.location;
                    if (OplusGLSurfaceView_13 >= locationArr2.length) {
                        break;
                    }
                    Location location = locationArr2[OplusGLSurfaceView_13];
                    if (location != null) {
                        codedOutputByteBufferNano.writeMessage(1, location);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Location[] locationArr = this.location;
            if (locationArr != null && locationArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    Location[] locationArr2 = this.location;
                    if (OplusGLSurfaceView_13 >= locationArr2.length) {
                        break;
                    }
                    Location location = locationArr2[OplusGLSurfaceView_13];
                    if (location != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, location);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public SourceCodeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    Location[] locationArr = this.location;
                    int length = locationArr == null ? 0 : locationArr.length;
                    Location[] locationArr2 = new Location[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.location, 0, locationArr2, 0, length);
                    }
                    while (length < locationArr2.length - 1) {
                        locationArr2[length] = new Location();
                        codedInputByteBufferNano.readMessage(locationArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    locationArr2[length] = new Location();
                    codedInputByteBufferNano.readMessage(locationArr2[length]);
                    this.location = locationArr2;
                }
            }
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (SourceCodeInfo) MessageNano.mergeFrom(new SourceCodeInfo(), bArr);
        }

        public static SourceCodeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new SourceCodeInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class GeneratedCodeInfo extends ExtendableMessageNano<GeneratedCodeInfo> {
        private static volatile GeneratedCodeInfo[] _emptyArray;
        public Annotation[] annotation;

        public static final class Annotation extends ExtendableMessageNano<Annotation> {
            private static volatile Annotation[] _emptyArray;
            public int begin;
            public int end;
            public int[] path;
            public String sourceFile;

            public static Annotation[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Annotation[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public Annotation() {
                clear();
            }

            public Annotation clear() {
                this.path = WireFormatNano.EMPTY_INT_ARRAY;
                this.sourceFile = "";
                this.begin = 0;
                this.end = 0;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
                int[] iArr = this.path;
                if (iArr != null && iArr.length > 0) {
                    int OplusGLSurfaceView_13 = 0;
                    int i2 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(10);
                    codedOutputByteBufferNano.writeRawVarint32(iComputeInt32SizeNoTag);
                    while (true) {
                        int[] iArr3 = this.path;
                        if (OplusGLSurfaceView_13 >= iArr3.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32NoTag(iArr3[OplusGLSurfaceView_13]);
                        OplusGLSurfaceView_13++;
                    }
                }
                String str = this.sourceFile;
                if (str != null && !str.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.sourceFile);
                }
                int i3 = this.begin;
                if (i3 != 0) {
                    codedOutputByteBufferNano.writeInt32(3, i3);
                }
                int i4 = this.end;
                if (i4 != 0) {
                    codedOutputByteBufferNano.writeInt32(4, i4);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int[] iArr = this.path;
                if (iArr != null && iArr.length > 0) {
                    int OplusGLSurfaceView_13 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (OplusGLSurfaceView_13 >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[OplusGLSurfaceView_13]);
                        OplusGLSurfaceView_13++;
                    }
                    iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(iComputeInt32SizeNoTag);
                }
                String str = this.sourceFile;
                if (str != null && !str.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.sourceFile);
                }
                int i2 = this.begin;
                if (i2 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
                }
                int i3 = this.end;
                return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i3) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public Annotation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr = this.path;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.path, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        iArr2[length] = codedInputByteBufferNano.readInt32();
                        this.path = iArr2;
                    } else if (tag == 10) {
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int OplusGLSurfaceView_13 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            OplusGLSurfaceView_13++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.path;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[OplusGLSurfaceView_13 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.path, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                            length2++;
                        }
                        this.path = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                    } else if (tag == 18) {
                        this.sourceFile = codedInputByteBufferNano.readString();
                    } else if (tag == 24) {
                        this.begin = codedInputByteBufferNano.readInt32();
                    } else if (tag != 32) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.end = codedInputByteBufferNano.readInt32();
                    }
                }
            }

            public static Annotation parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
                return (Annotation) MessageNano.mergeFrom(new Annotation(), bArr);
            }

            public static Annotation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                return new Annotation().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static GeneratedCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GeneratedCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GeneratedCodeInfo() {
            clear();
        }

        public GeneratedCodeInfo clear() {
            this.annotation = Annotation.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            Annotation[] annotationArr = this.annotation;
            if (annotationArr != null && annotationArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    Annotation[] annotationArr2 = this.annotation;
                    if (OplusGLSurfaceView_13 >= annotationArr2.length) {
                        break;
                    }
                    Annotation annotation = annotationArr2[OplusGLSurfaceView_13];
                    if (annotation != null) {
                        codedOutputByteBufferNano.writeMessage(1, annotation);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Annotation[] annotationArr = this.annotation;
            if (annotationArr != null && annotationArr.length > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    Annotation[] annotationArr2 = this.annotation;
                    if (OplusGLSurfaceView_13 >= annotationArr2.length) {
                        break;
                    }
                    Annotation annotation = annotationArr2[OplusGLSurfaceView_13];
                    if (annotation != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, annotation);
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public GeneratedCodeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    Annotation[] annotationArr = this.annotation;
                    int length = annotationArr == null ? 0 : annotationArr.length;
                    Annotation[] annotationArr2 = new Annotation[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.annotation, 0, annotationArr2, 0, length);
                    }
                    while (length < annotationArr2.length - 1) {
                        annotationArr2[length] = new Annotation();
                        codedInputByteBufferNano.readMessage(annotationArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    annotationArr2[length] = new Annotation();
                    codedInputByteBufferNano.readMessage(annotationArr2[length]);
                    this.annotation = annotationArr2;
                }
            }
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (GeneratedCodeInfo) MessageNano.mergeFrom(new GeneratedCodeInfo(), bArr);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new GeneratedCodeInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
