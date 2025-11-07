package com.google.protobuf.nano;

/* loaded from: classes.dex */
public abstract class DescriptorProtos {
    private DescriptorProtos() {
    }

    public static final class FileDescriptorSet extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet[] _emptyArray;
        public com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] file;

        public static com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FileDescriptorSet() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet clear() {
            this.file = com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] fileDescriptorProtoArr = this.file;
            if (fileDescriptorProtoArr != null && fileDescriptorProtoArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] fileDescriptorProtoArr2 = this.file;
                    if (i_renamed >= fileDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto fileDescriptorProto = fileDescriptorProtoArr2[i_renamed];
                    if (fileDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(1, fileDescriptorProto);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] fileDescriptorProtoArr = this.file;
            if (fileDescriptorProtoArr != null && fileDescriptorProtoArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] fileDescriptorProtoArr2 = this.file;
                    if (i_renamed >= fileDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto fileDescriptorProto = fileDescriptorProtoArr2[i_renamed];
                    if (fileDescriptorProto != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(1, fileDescriptorProto);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] fileDescriptorProtoArr = this.file;
                    int length = fileDescriptorProtoArr == null ? 0 : fileDescriptorProtoArr.length;
                    com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] fileDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.file, 0, fileDescriptorProtoArr2, 0, length);
                    }
                    while (length < fileDescriptorProtoArr2.length - 1) {
                        fileDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto();
                        codedInputByteBufferNano.readMessage(fileDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    fileDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto();
                    codedInputByteBufferNano.readMessage(fileDescriptorProtoArr2[length]);
                    this.file = fileDescriptorProtoArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.FileDescriptorSet().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FileDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] _emptyArray;
        public java.lang.String[] dependency;
        public com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumType;
        public com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] extension;
        public com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] messageType;
        public java.lang.String name;
        public com.google.protobuf.nano.DescriptorProtos.FileOptions options;
        public java.lang.String package_;
        public int[] publicDependency;
        public com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] service;
        public com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo sourceCodeInfo;
        public java.lang.String syntax;
        public int[] weakDependency;

        public static com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FileDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto clear() {
            this.name = "";
            this.package_ = "";
            this.dependency = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
            this.publicDependency = com.google.protobuf.nano.WireFormatNano.EMPTY_INT_ARRAY;
            this.weakDependency = com.google.protobuf.nano.WireFormatNano.EMPTY_INT_ARRAY;
            this.messageType = com.google.protobuf.nano.DescriptorProtos.DescriptorProto.emptyArray();
            this.enumType = com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.emptyArray();
            this.service = com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto.emptyArray();
            this.extension = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.emptyArray();
            this.options = null;
            this.sourceCodeInfo = null;
            this.syntax = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            java.lang.String str2 = this.package_;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.package_);
            }
            java.lang.String[] strArr = this.dependency;
            int i_renamed = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    java.lang.String[] strArr2 = this.dependency;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    java.lang.String str3 = strArr2[i2];
                    if (str3 != null) {
                        codedOutputByteBufferNano.writeString(3, str3);
                    }
                    i2++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr = this.messageType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr2 = this.messageType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, descriptorProto);
                    }
                    i3++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(5, enumDescriptorProto);
                    }
                    i4++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
            if (serviceDescriptorProtoArr != null && serviceDescriptorProtoArr.length > 0) {
                int i5 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] serviceDescriptorProtoArr2 = this.service;
                    if (i5 >= serviceDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto = serviceDescriptorProtoArr2[i5];
                    if (serviceDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(6, serviceDescriptorProto);
                    }
                    i5++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i6];
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(7, fieldDescriptorProto);
                    }
                    i6++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.FileOptions fileOptions = this.options;
            if (fileOptions != null) {
                codedOutputByteBufferNano.writeMessage(8, fileOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo;
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
                    if (i_renamed >= iArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(11, iArr4[i_renamed]);
                    i_renamed++;
                }
            }
            java.lang.String str4 = this.syntax;
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
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            java.lang.String str2 = this.package_;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(2, this.package_);
            }
            java.lang.String[] strArr = this.dependency;
            int i_renamed = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    java.lang.String[] strArr2 = this.dependency;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    java.lang.String str3 = strArr2[i2];
                    if (str3 != null) {
                        i3++;
                        iComputeStringSizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr = this.messageType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr2 = this.messageType;
                    if (i4 >= descriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto descriptorProto = descriptorProtoArr2[i4];
                    if (descriptorProto != null) {
                        iComputeMessageSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(4, descriptorProto);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i5 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i5];
                    if (enumDescriptorProto != null) {
                        iComputeMessageSize2 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(5, enumDescriptorProto);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
            if (serviceDescriptorProtoArr != null && serviceDescriptorProtoArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] serviceDescriptorProtoArr2 = this.service;
                    if (i6 >= serviceDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto = serviceDescriptorProtoArr2[i6];
                    if (serviceDescriptorProto != null) {
                        iComputeMessageSize3 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(6, serviceDescriptorProto);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i7 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.extension;
                    if (i7 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i7];
                    if (fieldDescriptorProto != null) {
                        iComputeMessageSize4 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(7, fieldDescriptorProto);
                    }
                    i7++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            com.google.protobuf.nano.DescriptorProtos.FileOptions fileOptions = this.options;
            if (fileOptions != null) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(8, fileOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo;
            if (sourceCodeInfo != null) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(9, sourceCodeInfo);
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
                    iComputeInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i8]);
                    i8++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr2.length * 1);
            }
            int[] iArr4 = this.weakDependency;
            if (iArr4 != null && iArr4.length > 0) {
                int iComputeInt32SizeNoTag2 = 0;
                while (true) {
                    iArr = this.weakDependency;
                    if (i_renamed >= iArr.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag2 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i_renamed]);
                    i_renamed++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag2 + (iArr.length * 1);
            }
            java.lang.String str4 = this.syntax;
            return (str4 == null || str4.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(12, this.syntax);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        java.lang.String[] strArr = this.dependency;
                        int length = strArr == null ? 0 : strArr.length;
                        java.lang.String[] strArr2 = new java.lang.String[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.dependency, 0, strArr2, 0, length);
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
                        int repeatedFieldArrayLength2 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr = this.messageType;
                        int length2 = descriptorProtoArr == null ? 0 : descriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            java.lang.System.arraycopy(this.messageType, 0, descriptorProtoArr2, 0, length2);
                        }
                        while (length2 < descriptorProtoArr2.length - 1) {
                            descriptorProtoArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                        this.messageType = descriptorProtoArr2;
                        break;
                    case 42:
                        int repeatedFieldArrayLength3 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
                        int length3 = enumDescriptorProtoArr == null ? 0 : enumDescriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            java.lang.System.arraycopy(this.enumType, 0, enumDescriptorProtoArr2, 0, length3);
                        }
                        while (length3 < enumDescriptorProtoArr2.length - 1) {
                            enumDescriptorProtoArr2[length3] = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr2[length3] = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                        this.enumType = enumDescriptorProtoArr2;
                        break;
                    case 50:
                        int repeatedFieldArrayLength4 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
                        int length4 = serviceDescriptorProtoArr == null ? 0 : serviceDescriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] serviceDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            java.lang.System.arraycopy(this.service, 0, serviceDescriptorProtoArr2, 0, length4);
                        }
                        while (length4 < serviceDescriptorProtoArr2.length - 1) {
                            serviceDescriptorProtoArr2[length4] = new com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto();
                            codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr2[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        serviceDescriptorProtoArr2[length4] = new com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto();
                        codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr2[length4]);
                        this.service = serviceDescriptorProtoArr2;
                        break;
                    case 58:
                        int repeatedFieldArrayLength5 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
                        int length5 = fieldDescriptorProtoArr == null ? 0 : fieldDescriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            java.lang.System.arraycopy(this.extension, 0, fieldDescriptorProtoArr2, 0, length5);
                        }
                        while (length5 < fieldDescriptorProtoArr2.length - 1) {
                            fieldDescriptorProtoArr2[length5] = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr2[length5] = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                        this.extension = fieldDescriptorProtoArr2;
                        break;
                    case 66:
                        if (this.options == null) {
                            this.options = new com.google.protobuf.nano.DescriptorProtos.FileOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        break;
                    case 74:
                        if (this.sourceCodeInfo == null) {
                            this.sourceCodeInfo = new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.sourceCodeInfo);
                        break;
                    case 80:
                        int repeatedFieldArrayLength6 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                        int[] iArr = this.publicDependency;
                        int length6 = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength6 + length6];
                        if (length6 != 0) {
                            java.lang.System.arraycopy(this.publicDependency, 0, iArr2, 0, length6);
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
                        int i_renamed = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i_renamed++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.publicDependency;
                        int length7 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i_renamed + length7];
                        if (length7 != 0) {
                            java.lang.System.arraycopy(this.publicDependency, 0, iArr4, 0, length7);
                        }
                        while (length7 < iArr4.length) {
                            iArr4[length7] = codedInputByteBufferNano.readInt32();
                            length7++;
                        }
                        this.publicDependency = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                        break;
                    case 88:
                        int repeatedFieldArrayLength7 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 88);
                        int[] iArr5 = this.weakDependency;
                        int length8 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[repeatedFieldArrayLength7 + length8];
                        if (length8 != 0) {
                            java.lang.System.arraycopy(this.weakDependency, 0, iArr6, 0, length8);
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
                            java.lang.System.arraycopy(this.weakDependency, 0, iArr8, 0, length9);
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

        public static com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.FileDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.DescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] _emptyArray;
        public com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumType;
        public com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] extension;
        public com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] extensionRange;
        public com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] field;
        public java.lang.String name;
        public com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] nestedType;
        public com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] oneofDecl;
        public com.google.protobuf.nano.DescriptorProtos.MessageOptions options;
        public java.lang.String[] reservedName;
        public com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] reservedRange;

        public static final class ExtensionRange extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange> {
            private static volatile com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] _emptyArray;
            public int end;
            public com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions options;
            public int start;

            public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public ExtensionRange() {
                clear();
            }

            public com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange clear() {
                this.start = 0;
                this.end = 0;
                this.options = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
                int i_renamed = this.start;
                if (i_renamed != 0) {
                    codedOutputByteBufferNano.writeInt32(1, i_renamed);
                }
                int i2 = this.end;
                if (i2 != 0) {
                    codedOutputByteBufferNano.writeInt32(2, i2);
                }
                com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions extensionRangeOptions = this.options;
                if (extensionRangeOptions != null) {
                    codedOutputByteBufferNano.writeMessage(3, extensionRangeOptions);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int i_renamed = this.start;
                if (i_renamed != 0) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(1, i_renamed);
                }
                int i2 = this.end;
                if (i2 != 0) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(2, i2);
                }
                com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions extensionRangeOptions = this.options;
                return extensionRangeOptions != null ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(3, extensionRangeOptions) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                            this.options = new com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                    }
                }
            }

            public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
                return (com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange(), bArr);
            }

            public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                return new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static final class ReservedRange extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange> {
            private static volatile com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] _emptyArray;
            public int end;
            public int start;

            public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public ReservedRange() {
                clear();
            }

            public com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange clear() {
                this.start = 0;
                this.end = 0;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
                int i_renamed = this.start;
                if (i_renamed != 0) {
                    codedOutputByteBufferNano.writeInt32(1, i_renamed);
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
                int i_renamed = this.start;
                if (i_renamed != 0) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(1, i_renamed);
                }
                int i2 = this.end;
                return i2 != 0 ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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

            public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
                return (com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange(), bArr);
            }

            public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                return new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.DescriptorProto clear() {
            this.name = "";
            this.field = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.emptyArray();
            this.extension = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.emptyArray();
            this.nestedType = emptyArray();
            this.enumType = com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.emptyArray();
            this.extensionRange = com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange.emptyArray();
            this.oneofDecl = com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto.emptyArray();
            this.options = null;
            this.reservedRange = com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange.emptyArray();
            this.reservedName = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
            int i_renamed = 0;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.field;
                    if (i2 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i2];
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, fieldDescriptorProto);
                    }
                    i2++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr = this.nestedType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr2 = this.nestedType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(3, descriptorProto);
                    }
                    i3++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, enumDescriptorProto);
                    }
                    i4++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] extensionRangeArr = this.extensionRange;
            if (extensionRangeArr != null && extensionRangeArr.length > 0) {
                int i5 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] extensionRangeArr2 = this.extensionRange;
                    if (i5 >= extensionRangeArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange extensionRange = extensionRangeArr2[i5];
                    if (extensionRange != null) {
                        codedOutputByteBufferNano.writeMessage(5, extensionRange);
                    }
                    i5++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
            if (fieldDescriptorProtoArr3 != null && fieldDescriptorProtoArr3.length > 0) {
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr4 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr4.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto fieldDescriptorProto2 = fieldDescriptorProtoArr4[i6];
                    if (fieldDescriptorProto2 != null) {
                        codedOutputByteBufferNano.writeMessage(6, fieldDescriptorProto2);
                    }
                    i6++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.MessageOptions messageOptions = this.options;
            if (messageOptions != null) {
                codedOutputByteBufferNano.writeMessage(7, messageOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
            if (oneofDescriptorProtoArr != null && oneofDescriptorProtoArr.length > 0) {
                int i7 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] oneofDescriptorProtoArr2 = this.oneofDecl;
                    if (i7 >= oneofDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto oneofDescriptorProto = oneofDescriptorProtoArr2[i7];
                    if (oneofDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(8, oneofDescriptorProto);
                    }
                    i7++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] reservedRangeArr = this.reservedRange;
            if (reservedRangeArr != null && reservedRangeArr.length > 0) {
                int i8 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] reservedRangeArr2 = this.reservedRange;
                    if (i8 >= reservedRangeArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange reservedRange = reservedRangeArr2[i8];
                    if (reservedRange != null) {
                        codedOutputByteBufferNano.writeMessage(9, reservedRange);
                    }
                    i8++;
                }
            }
            java.lang.String[] strArr = this.reservedName;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    java.lang.String[] strArr2 = this.reservedName;
                    if (i_renamed >= strArr2.length) {
                        break;
                    }
                    java.lang.String str2 = strArr2[i_renamed];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(10, str2);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
            int i_renamed = 0;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.field;
                    if (i2 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i2];
                    if (fieldDescriptorProto != null) {
                        iComputeMessageSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(2, fieldDescriptorProto);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr = this.nestedType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr2 = this.nestedType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        iComputeMessageSize2 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(3, descriptorProto);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        iComputeMessageSize3 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(4, enumDescriptorProto);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] extensionRangeArr = this.extensionRange;
            if (extensionRangeArr != null && extensionRangeArr.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] extensionRangeArr2 = this.extensionRange;
                    if (i5 >= extensionRangeArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange extensionRange = extensionRangeArr2[i5];
                    if (extensionRange != null) {
                        iComputeMessageSize4 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(5, extensionRange);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
            if (fieldDescriptorProtoArr3 != null && fieldDescriptorProtoArr3.length > 0) {
                int iComputeMessageSize5 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr4 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr4.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto fieldDescriptorProto2 = fieldDescriptorProtoArr4[i6];
                    if (fieldDescriptorProto2 != null) {
                        iComputeMessageSize5 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(6, fieldDescriptorProto2);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize5;
            }
            com.google.protobuf.nano.DescriptorProtos.MessageOptions messageOptions = this.options;
            if (messageOptions != null) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(7, messageOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
            if (oneofDescriptorProtoArr != null && oneofDescriptorProtoArr.length > 0) {
                int iComputeMessageSize6 = iComputeSerializedSize;
                int i7 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] oneofDescriptorProtoArr2 = this.oneofDecl;
                    if (i7 >= oneofDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto oneofDescriptorProto = oneofDescriptorProtoArr2[i7];
                    if (oneofDescriptorProto != null) {
                        iComputeMessageSize6 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(8, oneofDescriptorProto);
                    }
                    i7++;
                }
                iComputeSerializedSize = iComputeMessageSize6;
            }
            com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] reservedRangeArr = this.reservedRange;
            if (reservedRangeArr != null && reservedRangeArr.length > 0) {
                int iComputeMessageSize7 = iComputeSerializedSize;
                int i8 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] reservedRangeArr2 = this.reservedRange;
                    if (i8 >= reservedRangeArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange reservedRange = reservedRangeArr2[i8];
                    if (reservedRange != null) {
                        iComputeMessageSize7 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(9, reservedRange);
                    }
                    i8++;
                }
                iComputeSerializedSize = iComputeMessageSize7;
            }
            java.lang.String[] strArr = this.reservedName;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int iComputeStringSizeNoTag = 0;
            int i9 = 0;
            while (true) {
                java.lang.String[] strArr2 = this.reservedName;
                if (i_renamed >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i9 * 1);
                }
                java.lang.String str2 = strArr2[i_renamed];
                if (str2 != null) {
                    i9++;
                    iComputeStringSizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i_renamed++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.DescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
                        int length = fieldDescriptorProtoArr == null ? 0 : fieldDescriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.field, 0, fieldDescriptorProtoArr2, 0, length);
                        }
                        while (length < fieldDescriptorProtoArr2.length - 1) {
                            fieldDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        fieldDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length]);
                        this.field = fieldDescriptorProtoArr2;
                        break;
                    case 26:
                        int repeatedFieldArrayLength2 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr = this.nestedType;
                        int length2 = descriptorProtoArr == null ? 0 : descriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto[] descriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            java.lang.System.arraycopy(this.nestedType, 0, descriptorProtoArr2, 0, length2);
                        }
                        while (length2 < descriptorProtoArr2.length - 1) {
                            descriptorProtoArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                        this.nestedType = descriptorProtoArr2;
                        break;
                    case 34:
                        int repeatedFieldArrayLength3 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
                        int length3 = enumDescriptorProtoArr == null ? 0 : enumDescriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] enumDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            java.lang.System.arraycopy(this.enumType, 0, enumDescriptorProtoArr2, 0, length3);
                        }
                        while (length3 < enumDescriptorProtoArr2.length - 1) {
                            enumDescriptorProtoArr2[length3] = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr2[length3] = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                        this.enumType = enumDescriptorProtoArr2;
                        break;
                    case 42:
                        int repeatedFieldArrayLength4 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] extensionRangeArr = this.extensionRange;
                        int length4 = extensionRangeArr == null ? 0 : extensionRangeArr.length;
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[] extensionRangeArr2 = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            java.lang.System.arraycopy(this.extensionRange, 0, extensionRangeArr2, 0, length4);
                        }
                        while (length4 < extensionRangeArr2.length - 1) {
                            extensionRangeArr2[length4] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange();
                            codedInputByteBufferNano.readMessage(extensionRangeArr2[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        extensionRangeArr2[length4] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ExtensionRange();
                        codedInputByteBufferNano.readMessage(extensionRangeArr2[length4]);
                        this.extensionRange = extensionRangeArr2;
                        break;
                    case 50:
                        int repeatedFieldArrayLength5 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
                        int length5 = fieldDescriptorProtoArr3 == null ? 0 : fieldDescriptorProtoArr3.length;
                        com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] fieldDescriptorProtoArr4 = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            java.lang.System.arraycopy(this.extension, 0, fieldDescriptorProtoArr4, 0, length5);
                        }
                        while (length5 < fieldDescriptorProtoArr4.length - 1) {
                            fieldDescriptorProtoArr4[length5] = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr4[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr4[length5] = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr4[length5]);
                        this.extension = fieldDescriptorProtoArr4;
                        break;
                    case 58:
                        if (this.options == null) {
                            this.options = new com.google.protobuf.nano.DescriptorProtos.MessageOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        break;
                    case 66:
                        int repeatedFieldArrayLength6 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
                        int length6 = oneofDescriptorProtoArr == null ? 0 : oneofDescriptorProtoArr.length;
                        com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] oneofDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[repeatedFieldArrayLength6 + length6];
                        if (length6 != 0) {
                            java.lang.System.arraycopy(this.oneofDecl, 0, oneofDescriptorProtoArr2, 0, length6);
                        }
                        while (length6 < oneofDescriptorProtoArr2.length - 1) {
                            oneofDescriptorProtoArr2[length6] = new com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto();
                            codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr2[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        oneofDescriptorProtoArr2[length6] = new com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto();
                        codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr2[length6]);
                        this.oneofDecl = oneofDescriptorProtoArr2;
                        break;
                    case 74:
                        int repeatedFieldArrayLength7 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] reservedRangeArr = this.reservedRange;
                        int length7 = reservedRangeArr == null ? 0 : reservedRangeArr.length;
                        com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[] reservedRangeArr2 = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange[repeatedFieldArrayLength7 + length7];
                        if (length7 != 0) {
                            java.lang.System.arraycopy(this.reservedRange, 0, reservedRangeArr2, 0, length7);
                        }
                        while (length7 < reservedRangeArr2.length - 1) {
                            reservedRangeArr2[length7] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange();
                            codedInputByteBufferNano.readMessage(reservedRangeArr2[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        reservedRangeArr2[length7] = new com.google.protobuf.nano.DescriptorProtos.DescriptorProto.ReservedRange();
                        codedInputByteBufferNano.readMessage(reservedRangeArr2[length7]);
                        this.reservedRange = reservedRangeArr2;
                        break;
                    case 82:
                        int repeatedFieldArrayLength8 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        java.lang.String[] strArr = this.reservedName;
                        int length8 = strArr == null ? 0 : strArr.length;
                        java.lang.String[] strArr2 = new java.lang.String[repeatedFieldArrayLength8 + length8];
                        if (length8 != 0) {
                            java.lang.System.arraycopy(this.reservedName, 0, strArr2, 0, length8);
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

        public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.DescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.DescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.DescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.DescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ExtensionRangeOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions[] _emptyArray;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public static com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ExtensionRangeOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions clear() {
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.ExtensionRangeOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FieldDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] _emptyArray;
        public java.lang.String defaultValue;
        public java.lang.String extendee;
        public java.lang.String jsonName;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Label.class)
        public int label;
        public java.lang.String name;
        public int number;
        public int oneofIndex;
        public com.google.protobuf.nano.DescriptorProtos.FieldOptions options;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
        public int type;
        public java.lang.String typeName;

        public interface Label {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Label.class)
            public static final int LABEL_OPTIONAL = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Label.class)
            public static final int LABEL_REPEATED = 3;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Label.class)
            public static final int LABEL_REQUIRED = 2;
        }

        public interface Type {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_BOOL = 8;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_BYTES = 12;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_DOUBLE = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_ENUM = 14;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_FIXED32 = 7;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_FIXED64 = 6;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_FLOAT = 2;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_GROUP = 10;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_INT32 = 5;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_INT64 = 3;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_MESSAGE = 11;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_SFIXED32 = 15;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_SFIXED64 = 16;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_SINT32 = 17;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_SINT64 = 18;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_STRING = 9;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_UINT32 = 13;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
            public static final int TYPE_UINT64 = 4;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
        public static int checkTypeOrThrow(int i_renamed) {
            if (i_renamed >= 1 && i_renamed <= 18) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(36);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum Type");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Type.class)
        public static int[] checkTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkTypeOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Label.class)
        public static int checkLabelOrThrow(int i_renamed) {
            if (i_renamed >= 1 && i_renamed <= 3) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(37);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum Label");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto.Label.class)
        public static int[] checkLabelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkLabelOrThrow(i_renamed);
            }
            return iArr2;
        }

        public static com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FieldDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto clear() {
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
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            java.lang.String str2 = this.extendee;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.extendee);
            }
            int i_renamed = this.number;
            if (i_renamed != 0) {
                codedOutputByteBufferNano.writeInt32(3, i_renamed);
            }
            int i2 = this.label;
            if (i2 != 1) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            int i3 = this.type;
            if (i3 != 1) {
                codedOutputByteBufferNano.writeInt32(5, i3);
            }
            java.lang.String str3 = this.typeName;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.typeName);
            }
            java.lang.String str4 = this.defaultValue;
            if (str4 != null && !str4.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.defaultValue);
            }
            com.google.protobuf.nano.DescriptorProtos.FieldOptions fieldOptions = this.options;
            if (fieldOptions != null) {
                codedOutputByteBufferNano.writeMessage(8, fieldOptions);
            }
            int i4 = this.oneofIndex;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(9, i4);
            }
            java.lang.String str5 = this.jsonName;
            if (str5 != null && !str5.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.jsonName);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            java.lang.String str2 = this.extendee;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(2, this.extendee);
            }
            int i_renamed = this.number;
            if (i_renamed != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(3, i_renamed);
            }
            int i2 = this.label;
            if (i2 != 1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            int i3 = this.type;
            if (i3 != 1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(5, i3);
            }
            java.lang.String str3 = this.typeName;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(6, this.typeName);
            }
            java.lang.String str4 = this.defaultValue;
            if (str4 != null && !str4.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(7, this.defaultValue);
            }
            com.google.protobuf.nano.DescriptorProtos.FieldOptions fieldOptions = this.options;
            if (fieldOptions != null) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(8, fieldOptions);
            }
            int i4 = this.oneofIndex;
            if (i4 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(9, i4);
            }
            java.lang.String str5 = this.jsonName;
            return (str5 == null || str5.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(10, this.jsonName);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        } catch (java.lang.IllegalArgumentException unused) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 40:
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.type = checkTypeOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (java.lang.IllegalArgumentException unused2) {
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
                            this.options = new com.google.protobuf.nano.DescriptorProtos.FieldOptions();
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

        public static com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.FieldDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class OneofDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] _emptyArray;
        public java.lang.String name;
        public com.google.protobuf.nano.DescriptorProtos.OneofOptions options;

        public static com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public OneofDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto clear() {
            this.name = "";
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.OneofOptions oneofOptions = this.options;
            if (oneofOptions != null) {
                codedOutputByteBufferNano.writeMessage(2, oneofOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.OneofOptions oneofOptions = this.options;
            return oneofOptions != null ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(2, oneofOptions) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        this.options = new com.google.protobuf.nano.DescriptorProtos.OneofOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.OneofDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] _emptyArray;
        public java.lang.String name;
        public com.google.protobuf.nano.DescriptorProtos.EnumOptions options;
        public java.lang.String[] reservedName;
        public com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] reservedRange;
        public com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] value;

        public static final class EnumReservedRange extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange> {
            private static volatile com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] _emptyArray;
            public int end;
            public int start;

            public static com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public EnumReservedRange() {
                clear();
            }

            public com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange clear() {
                this.start = 0;
                this.end = 0;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
                int i_renamed = this.start;
                if (i_renamed != 0) {
                    codedOutputByteBufferNano.writeInt32(1, i_renamed);
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
                int i_renamed = this.start;
                if (i_renamed != 0) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(1, i_renamed);
                }
                int i2 = this.end;
                return i2 != 0 ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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

            public static com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
                return (com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange(), bArr);
            }

            public static com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                return new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto clear() {
            this.name = "";
            this.value = com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto.emptyArray();
            this.options = null;
            this.reservedRange = com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange.emptyArray();
            this.reservedName = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
            int i_renamed = 0;
            if (enumValueDescriptorProtoArr != null && enumValueDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = this.value;
                    if (i2 >= enumValueDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto = enumValueDescriptorProtoArr2[i2];
                    if (enumValueDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, enumValueDescriptorProto);
                    }
                    i2++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.EnumOptions enumOptions = this.options;
            if (enumOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, enumOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] enumReservedRangeArr = this.reservedRange;
            if (enumReservedRangeArr != null && enumReservedRangeArr.length > 0) {
                int i3 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] enumReservedRangeArr2 = this.reservedRange;
                    if (i3 >= enumReservedRangeArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange enumReservedRange = enumReservedRangeArr2[i3];
                    if (enumReservedRange != null) {
                        codedOutputByteBufferNano.writeMessage(4, enumReservedRange);
                    }
                    i3++;
                }
            }
            java.lang.String[] strArr = this.reservedName;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    java.lang.String[] strArr2 = this.reservedName;
                    if (i_renamed >= strArr2.length) {
                        break;
                    }
                    java.lang.String str2 = strArr2[i_renamed];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(5, str2);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
            int i_renamed = 0;
            if (enumValueDescriptorProtoArr != null && enumValueDescriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = this.value;
                    if (i2 >= enumValueDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto = enumValueDescriptorProtoArr2[i2];
                    if (enumValueDescriptorProto != null) {
                        iComputeMessageSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(2, enumValueDescriptorProto);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            com.google.protobuf.nano.DescriptorProtos.EnumOptions enumOptions = this.options;
            if (enumOptions != null) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(3, enumOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] enumReservedRangeArr = this.reservedRange;
            if (enumReservedRangeArr != null && enumReservedRangeArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] enumReservedRangeArr2 = this.reservedRange;
                    if (i3 >= enumReservedRangeArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange enumReservedRange = enumReservedRangeArr2[i3];
                    if (enumReservedRange != null) {
                        iComputeMessageSize2 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(4, enumReservedRange);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            java.lang.String[] strArr = this.reservedName;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                java.lang.String[] strArr2 = this.reservedName;
                if (i_renamed >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
                }
                java.lang.String str2 = strArr2[i_renamed];
                if (str2 != null) {
                    i4++;
                    iComputeStringSizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i_renamed++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
                    int length = enumValueDescriptorProtoArr == null ? 0 : enumValueDescriptorProtoArr.length;
                    com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.value, 0, enumValueDescriptorProtoArr2, 0, length);
                    }
                    while (length < enumValueDescriptorProtoArr2.length - 1) {
                        enumValueDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    enumValueDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto();
                    codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr2[length]);
                    this.value = enumValueDescriptorProtoArr2;
                } else if (tag == 26) {
                    if (this.options == null) {
                        this.options = new com.google.protobuf.nano.DescriptorProtos.EnumOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] enumReservedRangeArr = this.reservedRange;
                    int length2 = enumReservedRangeArr == null ? 0 : enumReservedRangeArr.length;
                    com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[] enumReservedRangeArr2 = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        java.lang.System.arraycopy(this.reservedRange, 0, enumReservedRangeArr2, 0, length2);
                    }
                    while (length2 < enumReservedRangeArr2.length - 1) {
                        enumReservedRangeArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange();
                        codedInputByteBufferNano.readMessage(enumReservedRangeArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    enumReservedRangeArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto.EnumReservedRange();
                    codedInputByteBufferNano.readMessage(enumReservedRangeArr2[length2]);
                    this.reservedRange = enumReservedRangeArr2;
                } else if (tag != 42) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength3 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    java.lang.String[] strArr = this.reservedName;
                    int length3 = strArr == null ? 0 : strArr.length;
                    java.lang.String[] strArr2 = new java.lang.String[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        java.lang.System.arraycopy(this.reservedName, 0, strArr2, 0, length3);
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

        public static com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.EnumDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumValueDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] _emptyArray;
        public java.lang.String name;
        public int number;
        public com.google.protobuf.nano.DescriptorProtos.EnumValueOptions options;

        public static com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumValueDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto clear() {
            this.name = "";
            this.number = 0;
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            int i_renamed = this.number;
            if (i_renamed != 0) {
                codedOutputByteBufferNano.writeInt32(2, i_renamed);
            }
            com.google.protobuf.nano.DescriptorProtos.EnumValueOptions enumValueOptions = this.options;
            if (enumValueOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, enumValueOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            int i_renamed = this.number;
            if (i_renamed != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(2, i_renamed);
            }
            com.google.protobuf.nano.DescriptorProtos.EnumValueOptions enumValueOptions = this.options;
            return enumValueOptions != null ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(3, enumValueOptions) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        this.options = new com.google.protobuf.nano.DescriptorProtos.EnumValueOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.EnumValueDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ServiceDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] _emptyArray;
        public com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] method;
        public java.lang.String name;
        public com.google.protobuf.nano.DescriptorProtos.ServiceOptions options;
        public com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] stream;

        public static com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ServiceDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto clear() {
            this.name = "";
            this.method = com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto.emptyArray();
            this.stream = com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto.emptyArray();
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
            int i_renamed = 0;
            if (methodDescriptorProtoArr != null && methodDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] methodDescriptorProtoArr2 = this.method;
                    if (i2 >= methodDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto methodDescriptorProto = methodDescriptorProtoArr2[i2];
                    if (methodDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, methodDescriptorProto);
                    }
                    i2++;
                }
            }
            com.google.protobuf.nano.DescriptorProtos.ServiceOptions serviceOptions = this.options;
            if (serviceOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, serviceOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
            if (streamDescriptorProtoArr != null && streamDescriptorProtoArr.length > 0) {
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] streamDescriptorProtoArr2 = this.stream;
                    if (i_renamed >= streamDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto streamDescriptorProto = streamDescriptorProtoArr2[i_renamed];
                    if (streamDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, streamDescriptorProto);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
            int i_renamed = 0;
            if (methodDescriptorProtoArr != null && methodDescriptorProtoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] methodDescriptorProtoArr2 = this.method;
                    if (i2 >= methodDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto methodDescriptorProto = methodDescriptorProtoArr2[i2];
                    if (methodDescriptorProto != null) {
                        iComputeMessageSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(2, methodDescriptorProto);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            com.google.protobuf.nano.DescriptorProtos.ServiceOptions serviceOptions = this.options;
            if (serviceOptions != null) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(3, serviceOptions);
            }
            com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
            if (streamDescriptorProtoArr != null && streamDescriptorProtoArr.length > 0) {
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] streamDescriptorProtoArr2 = this.stream;
                    if (i_renamed >= streamDescriptorProtoArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto streamDescriptorProto = streamDescriptorProtoArr2[i_renamed];
                    if (streamDescriptorProto != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(4, streamDescriptorProto);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
                    int length = methodDescriptorProtoArr == null ? 0 : methodDescriptorProtoArr.length;
                    com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] methodDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.method, 0, methodDescriptorProtoArr2, 0, length);
                    }
                    while (length < methodDescriptorProtoArr2.length - 1) {
                        methodDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto();
                        codedInputByteBufferNano.readMessage(methodDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    methodDescriptorProtoArr2[length] = new com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto();
                    codedInputByteBufferNano.readMessage(methodDescriptorProtoArr2[length]);
                    this.method = methodDescriptorProtoArr2;
                } else if (tag == 26) {
                    if (this.options == null) {
                        this.options = new com.google.protobuf.nano.DescriptorProtos.ServiceOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (tag != 34) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
                    int length2 = streamDescriptorProtoArr == null ? 0 : streamDescriptorProtoArr.length;
                    com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] streamDescriptorProtoArr2 = new com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        java.lang.System.arraycopy(this.stream, 0, streamDescriptorProtoArr2, 0, length2);
                    }
                    while (length2 < streamDescriptorProtoArr2.length - 1) {
                        streamDescriptorProtoArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto();
                        codedInputByteBufferNano.readMessage(streamDescriptorProtoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    streamDescriptorProtoArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto();
                    codedInputByteBufferNano.readMessage(streamDescriptorProtoArr2[length2]);
                    this.stream = streamDescriptorProtoArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.ServiceDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MethodDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] _emptyArray;
        public boolean clientStreaming;
        public java.lang.String inputType;
        public java.lang.String name;
        public com.google.protobuf.nano.DescriptorProtos.MethodOptions options;
        public java.lang.String outputType;
        public boolean serverStreaming;

        public static com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MethodDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto clear() {
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
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            java.lang.String str2 = this.inputType;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.inputType);
            }
            java.lang.String str3 = this.outputType;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.outputType);
            }
            com.google.protobuf.nano.DescriptorProtos.MethodOptions methodOptions = this.options;
            if (methodOptions != null) {
                codedOutputByteBufferNano.writeMessage(4, methodOptions);
            }
            boolean z_renamed = this.clientStreaming;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(5, z_renamed);
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
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            java.lang.String str2 = this.inputType;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(2, this.inputType);
            }
            java.lang.String str3 = this.outputType;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(3, this.outputType);
            }
            com.google.protobuf.nano.DescriptorProtos.MethodOptions methodOptions = this.options;
            if (methodOptions != null) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(4, methodOptions);
            }
            boolean z_renamed = this.clientStreaming;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(5, z_renamed);
            }
            boolean z2 = this.serverStreaming;
            return z2 ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(6, z2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        this.options = new com.google.protobuf.nano.DescriptorProtos.MethodOptions();
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

        public static com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.MethodDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class StreamDescriptorProto extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] _emptyArray;
        public java.lang.String clientMessageType;
        public java.lang.String name;
        public com.google.protobuf.nano.DescriptorProtos.StreamOptions options;
        public java.lang.String serverMessageType;

        public static com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public StreamDescriptorProto() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto clear() {
            this.name = "";
            this.clientMessageType = "";
            this.serverMessageType = "";
            this.options = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.name);
            }
            java.lang.String str2 = this.clientMessageType;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.clientMessageType);
            }
            java.lang.String str3 = this.serverMessageType;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.serverMessageType);
            }
            com.google.protobuf.nano.DescriptorProtos.StreamOptions streamOptions = this.options;
            if (streamOptions != null) {
                codedOutputByteBufferNano.writeMessage(4, streamOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            java.lang.String str2 = this.clientMessageType;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(2, this.clientMessageType);
            }
            java.lang.String str3 = this.serverMessageType;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(3, this.serverMessageType);
            }
            com.google.protobuf.nano.DescriptorProtos.StreamOptions streamOptions = this.options;
            return streamOptions != null ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(4, streamOptions) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        this.options = new com.google.protobuf.nano.DescriptorProtos.StreamOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.StreamDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FileOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.FileOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.FileOptions[] _emptyArray;
        public int ccApiVersion;
        public boolean ccEnableArenas;
        public boolean ccGenericServices;
        public boolean ccUtf8Verification;
        public java.lang.String csharpNamespace;
        public boolean deprecated;
        public java.lang.String goPackage;
        public java.lang.String javaAltApiPackage;
        public int javaApiVersion;
        public boolean javaEnableDualGenerateMutableApi;
        public boolean javaGenericServices;
        public boolean javaJava5Enums;
        public boolean javaMultipleFiles;
        public java.lang.String javaMultipleFilesMutablePackage;
        public boolean javaMutableApi;
        public java.lang.String javaOuterClassname;
        public java.lang.String javaPackage;
        public boolean javaStringCheckUtf8;
        public boolean javaUseJavaproto2;
        public boolean javaUseJavastrings;
        public java.lang.String javascriptPackage;
        public java.lang.String objcClassPrefix;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.OptimizeMode.class)
        public int optimizeFor;
        public java.lang.String phpClassPrefix;
        public boolean phpGenericServices;
        public java.lang.String phpNamespace;
        public int pyApiVersion;
        public boolean pyGenericServices;
        public java.lang.String swiftPrefix;
        public int szlApiVersion;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public interface CompatibilityLevel {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.CompatibilityLevel.class)
            public static final int NO_COMPATIBILITY = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.CompatibilityLevel.class)
            public static final int PROTO1_COMPATIBLE = 100;
        }

        public interface OptimizeMode {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.OptimizeMode.class)
            public static final int CODE_SIZE = 2;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.OptimizeMode.class)
            public static final int LITE_RUNTIME = 3;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.OptimizeMode.class)
            public static final int SPEED = 1;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.CompatibilityLevel.class)
        public static int checkCompatibilityLevelOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 0) {
                return i_renamed;
            }
            if (i_renamed >= 100 && i_renamed <= 100) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(50);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum CompatibilityLevel");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.CompatibilityLevel.class)
        public static int[] checkCompatibilityLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkCompatibilityLevelOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.OptimizeMode.class)
        public static int checkOptimizeModeOrThrow(int i_renamed) {
            if (i_renamed >= 1 && i_renamed <= 3) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(44);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum OptimizeMode");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FileOptions.OptimizeMode.class)
        public static int[] checkOptimizeModeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkOptimizeModeOrThrow(i_renamed);
            }
            return iArr2;
        }

        public static com.google.protobuf.nano.DescriptorProtos.FileOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.FileOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FileOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.FileOptions clear() {
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
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.javaPackage;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.javaPackage);
            }
            int i_renamed = this.ccApiVersion;
            if (i_renamed != 2) {
                codedOutputByteBufferNano.writeInt32(2, i_renamed);
            }
            int i2 = this.pyApiVersion;
            if (i2 != 2) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            int i3 = this.javaApiVersion;
            if (i3 != 2) {
                codedOutputByteBufferNano.writeInt32(5, i3);
            }
            boolean z_renamed = this.javaUseJavaproto2;
            if (!z_renamed) {
                codedOutputByteBufferNano.writeBool(6, z_renamed);
            }
            boolean z2 = this.javaJava5Enums;
            if (!z2) {
                codedOutputByteBufferNano.writeBool(7, z2);
            }
            java.lang.String str2 = this.javaOuterClassname;
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
            java.lang.String str3 = this.goPackage;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.goPackage);
            }
            java.lang.String str4 = this.javascriptPackage;
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
            java.lang.String str5 = this.javaAltApiPackage;
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
            java.lang.String str6 = this.javaMultipleFilesMutablePackage;
            if (str6 != null && !str6.equals("")) {
                codedOutputByteBufferNano.writeString(29, this.javaMultipleFilesMutablePackage);
            }
            boolean z13 = this.ccEnableArenas;
            if (z13) {
                codedOutputByteBufferNano.writeBool(31, z13);
            }
            java.lang.String str7 = this.objcClassPrefix;
            if (str7 != null && !str7.equals("")) {
                codedOutputByteBufferNano.writeString(36, this.objcClassPrefix);
            }
            java.lang.String str8 = this.csharpNamespace;
            if (str8 != null && !str8.equals("")) {
                codedOutputByteBufferNano.writeString(37, this.csharpNamespace);
            }
            java.lang.String str9 = this.swiftPrefix;
            if (str9 != null && !str9.equals("")) {
                codedOutputByteBufferNano.writeString(39, this.swiftPrefix);
            }
            java.lang.String str10 = this.phpClassPrefix;
            if (str10 != null && !str10.equals("")) {
                codedOutputByteBufferNano.writeString(40, this.phpClassPrefix);
            }
            java.lang.String str11 = this.phpNamespace;
            if (str11 != null && !str11.equals("")) {
                codedOutputByteBufferNano.writeString(41, this.phpNamespace);
            }
            boolean z14 = this.phpGenericServices;
            if (z14) {
                codedOutputByteBufferNano.writeBool(42, z14);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
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
            java.lang.String str = this.javaPackage;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.javaPackage);
            }
            int i_renamed = this.ccApiVersion;
            if (i_renamed != 2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(2, i_renamed);
            }
            int i2 = this.pyApiVersion;
            if (i2 != 2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            int i3 = this.javaApiVersion;
            if (i3 != 2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(5, i3);
            }
            boolean z_renamed = this.javaUseJavaproto2;
            if (!z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(6, z_renamed);
            }
            boolean z2 = this.javaJava5Enums;
            if (!z2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(7, z2);
            }
            java.lang.String str2 = this.javaOuterClassname;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(8, this.javaOuterClassname);
            }
            int i4 = this.optimizeFor;
            if (i4 != 1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(9, i4);
            }
            boolean z3 = this.javaMultipleFiles;
            if (z3) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(10, z3);
            }
            java.lang.String str3 = this.goPackage;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(11, this.goPackage);
            }
            java.lang.String str4 = this.javascriptPackage;
            if (str4 != null && !str4.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(12, this.javascriptPackage);
            }
            int i5 = this.szlApiVersion;
            if (i5 != 1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(14, i5);
            }
            boolean z4 = this.ccGenericServices;
            if (z4) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(16, z4);
            }
            boolean z5 = this.javaGenericServices;
            if (z5) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(17, z5);
            }
            boolean z6 = this.pyGenericServices;
            if (z6) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(18, z6);
            }
            java.lang.String str5 = this.javaAltApiPackage;
            if (str5 != null && !str5.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(19, this.javaAltApiPackage);
            }
            boolean z7 = this.javaUseJavastrings;
            if (z7) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(21, z7);
            }
            boolean z8 = this.deprecated;
            if (z8) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(23, z8);
            }
            boolean z9 = this.ccUtf8Verification;
            if (!z9) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(24, z9);
            }
            boolean z10 = this.javaEnableDualGenerateMutableApi;
            if (z10) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(26, z10);
            }
            boolean z11 = this.javaStringCheckUtf8;
            if (z11) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(27, z11);
            }
            boolean z12 = this.javaMutableApi;
            if (z12) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(28, z12);
            }
            java.lang.String str6 = this.javaMultipleFilesMutablePackage;
            if (str6 != null && !str6.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(29, this.javaMultipleFilesMutablePackage);
            }
            boolean z13 = this.ccEnableArenas;
            if (z13) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(31, z13);
            }
            java.lang.String str7 = this.objcClassPrefix;
            if (str7 != null && !str7.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(36, this.objcClassPrefix);
            }
            java.lang.String str8 = this.csharpNamespace;
            if (str8 != null && !str8.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(37, this.csharpNamespace);
            }
            java.lang.String str9 = this.swiftPrefix;
            if (str9 != null && !str9.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(39, this.swiftPrefix);
            }
            java.lang.String str10 = this.phpClassPrefix;
            if (str10 != null && !str10.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(40, this.phpClassPrefix);
            }
            java.lang.String str11 = this.phpNamespace;
            if (str11 != null && !str11.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(41, this.phpNamespace);
            }
            boolean z14 = this.phpGenericServices;
            if (z14) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(42, z14);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i6++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.FileOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        } catch (java.lang.IllegalArgumentException unused) {
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
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
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

        public static com.google.protobuf.nano.DescriptorProtos.FileOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.FileOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.FileOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.FileOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.FileOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MessageOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.MessageOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.MessageOptions[] _emptyArray;
        public boolean deprecated;
        public java.lang.String[] experimentalJavaBuilderInterface;
        public java.lang.String[] experimentalJavaInterfaceExtends;
        public java.lang.String[] experimentalJavaMessageInterface;
        public boolean mapEntry;
        public boolean messageSetWireFormat;
        public boolean noStandardDescriptorAccessor;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public static com.google.protobuf.nano.DescriptorProtos.MessageOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.MessageOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MessageOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.MessageOptions clear() {
            this.experimentalJavaMessageInterface = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
            this.experimentalJavaBuilderInterface = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
            this.experimentalJavaInterfaceExtends = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
            this.messageSetWireFormat = false;
            this.noStandardDescriptorAccessor = false;
            this.deprecated = false;
            this.mapEntry = false;
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            boolean z_renamed = this.messageSetWireFormat;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(1, z_renamed);
            }
            boolean z2 = this.noStandardDescriptorAccessor;
            if (z2) {
                codedOutputByteBufferNano.writeBool(2, z2);
            }
            boolean z3 = this.deprecated;
            if (z3) {
                codedOutputByteBufferNano.writeBool(3, z3);
            }
            java.lang.String[] strArr = this.experimentalJavaMessageInterface;
            int i_renamed = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    java.lang.String[] strArr2 = this.experimentalJavaMessageInterface;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    java.lang.String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(4, str);
                    }
                    i2++;
                }
            }
            java.lang.String[] strArr3 = this.experimentalJavaBuilderInterface;
            if (strArr3 != null && strArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    java.lang.String[] strArr4 = this.experimentalJavaBuilderInterface;
                    if (i3 >= strArr4.length) {
                        break;
                    }
                    java.lang.String str2 = strArr4[i3];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(5, str2);
                    }
                    i3++;
                }
            }
            java.lang.String[] strArr5 = this.experimentalJavaInterfaceExtends;
            if (strArr5 != null && strArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    java.lang.String[] strArr6 = this.experimentalJavaInterfaceExtends;
                    if (i4 >= strArr6.length) {
                        break;
                    }
                    java.lang.String str3 = strArr6[i4];
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
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z_renamed = this.messageSetWireFormat;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(1, z_renamed);
            }
            boolean z2 = this.noStandardDescriptorAccessor;
            if (z2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(2, z2);
            }
            boolean z3 = this.deprecated;
            if (z3) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(3, z3);
            }
            java.lang.String[] strArr = this.experimentalJavaMessageInterface;
            int i_renamed = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    java.lang.String[] strArr2 = this.experimentalJavaMessageInterface;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    java.lang.String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iComputeStringSizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            java.lang.String[] strArr3 = this.experimentalJavaBuilderInterface;
            if (strArr3 != null && strArr3.length > 0) {
                int i4 = 0;
                int iComputeStringSizeNoTag2 = 0;
                int i5 = 0;
                while (true) {
                    java.lang.String[] strArr4 = this.experimentalJavaBuilderInterface;
                    if (i4 >= strArr4.length) {
                        break;
                    }
                    java.lang.String str2 = strArr4[i4];
                    if (str2 != null) {
                        i5++;
                        iComputeStringSizeNoTag2 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag2 + (i5 * 1);
            }
            java.lang.String[] strArr5 = this.experimentalJavaInterfaceExtends;
            if (strArr5 != null && strArr5.length > 0) {
                int i6 = 0;
                int iComputeStringSizeNoTag3 = 0;
                int i7 = 0;
                while (true) {
                    java.lang.String[] strArr6 = this.experimentalJavaInterfaceExtends;
                    if (i6 >= strArr6.length) {
                        break;
                    }
                    java.lang.String str3 = strArr6[i6];
                    if (str3 != null) {
                        i7++;
                        iComputeStringSizeNoTag3 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag3 + (i7 * 1);
            }
            boolean z4 = this.mapEntry;
            if (z4) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(7, z4);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.MessageOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    java.lang.String[] strArr = this.experimentalJavaMessageInterface;
                    int length = strArr == null ? 0 : strArr.length;
                    java.lang.String[] strArr2 = new java.lang.String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.experimentalJavaMessageInterface, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.experimentalJavaMessageInterface = strArr2;
                } else if (tag == 42) {
                    int repeatedFieldArrayLength2 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    java.lang.String[] strArr3 = this.experimentalJavaBuilderInterface;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    java.lang.String[] strArr4 = new java.lang.String[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        java.lang.System.arraycopy(this.experimentalJavaBuilderInterface, 0, strArr4, 0, length2);
                    }
                    while (length2 < strArr4.length - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.experimentalJavaBuilderInterface = strArr4;
                } else if (tag == 50) {
                    int repeatedFieldArrayLength3 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    java.lang.String[] strArr5 = this.experimentalJavaInterfaceExtends;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    java.lang.String[] strArr6 = new java.lang.String[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        java.lang.System.arraycopy(this.experimentalJavaInterfaceExtends, 0, strArr6, 0, length3);
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
                    int repeatedFieldArrayLength4 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length4 = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length4);
                    }
                    while (length4 < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length4] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    uninterpretedOptionArr2[length4] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length4]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.MessageOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.MessageOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.MessageOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.MessageOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.MessageOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FieldOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.FieldOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.FieldOptions[] _emptyArray;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.CType.class)
        public int ctype;
        public boolean deprecated;
        public boolean deprecatedRawMessage;
        public boolean enforceUtf8;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.JSType.class)
        public int jstype;
        public boolean lazy;
        public boolean packed;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;
        public com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] upgradedOption;
        public boolean weak;

        public interface CType {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.CType.class)
            public static final int CORD = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.CType.class)
            public static final int STRING = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.CType.class)
            public static final int STRING_PIECE = 2;
        }

        public interface JSType {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.JSType.class)
            public static final int JS_NORMAL = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.JSType.class)
            public static final int JS_NUMBER = 2;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.JSType.class)
            public static final int JS_STRING = 1;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.CType.class)
        public static int checkCTypeOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 2) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(37);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum CType");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.CType.class)
        public static int[] checkCTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkCTypeOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.JSType.class)
        public static int checkJSTypeOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 2) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(38);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum JSType");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.FieldOptions.JSType.class)
        public static int[] checkJSTypeOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkJSTypeOrThrow(i_renamed);
            }
            return iArr2;
        }

        public static final class UpgradedOption extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption> {
            private static volatile com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] _emptyArray;
            public java.lang.String name;
            public java.lang.String value;

            public static com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public UpgradedOption() {
                clear();
            }

            public com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption clear() {
                this.name = "";
                this.value = "";
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
                java.lang.String str = this.name;
                if (str != null && !str.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.name);
                }
                java.lang.String str2 = this.value;
                if (str2 != null && !str2.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.value);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                java.lang.String str = this.name;
                if (str != null && !str.equals("")) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.name);
                }
                java.lang.String str2 = this.value;
                return (str2 == null || str2.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(2, this.value);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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

            public static com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
                return (com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption(), bArr);
            }

            public static com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                return new com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.FieldOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.FieldOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FieldOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.FieldOptions clear() {
            this.ctype = 0;
            this.packed = false;
            this.jstype = 0;
            this.lazy = false;
            this.deprecated = false;
            this.weak = false;
            this.upgradedOption = com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption.emptyArray();
            this.deprecatedRawMessage = false;
            this.enforceUtf8 = true;
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            int i_renamed = this.ctype;
            if (i_renamed != 0) {
                codedOutputByteBufferNano.writeInt32(1, i_renamed);
            }
            boolean z_renamed = this.packed;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(2, z_renamed);
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
            com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] upgradedOptionArr = this.upgradedOption;
            int i3 = 0;
            if (upgradedOptionArr != null && upgradedOptionArr.length > 0) {
                int i4 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] upgradedOptionArr2 = this.upgradedOption;
                    if (i4 >= upgradedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption upgradedOption = upgradedOptionArr2[i4];
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
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i3 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i3];
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
            int i_renamed = this.ctype;
            if (i_renamed != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(1, i_renamed);
            }
            boolean z_renamed = this.packed;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(2, z_renamed);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(3, z2);
            }
            boolean z3 = this.lazy;
            if (z3) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(5, z3);
            }
            int i2 = this.jstype;
            if (i2 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(6, i2);
            }
            boolean z4 = this.weak;
            if (z4) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(10, z4);
            }
            com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] upgradedOptionArr = this.upgradedOption;
            int i3 = 0;
            if (upgradedOptionArr != null && upgradedOptionArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] upgradedOptionArr2 = this.upgradedOption;
                    if (i4 >= upgradedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption upgradedOption = upgradedOptionArr2[i4];
                    if (upgradedOption != null) {
                        iComputeMessageSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(11, upgradedOption);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            boolean z5 = this.deprecatedRawMessage;
            if (z5) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(12, z5);
            }
            boolean z6 = this.enforceUtf8;
            if (!z6) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(13, z6);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i3 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i3];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i3++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.FieldOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        } catch (java.lang.IllegalArgumentException unused) {
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
                        } catch (java.lang.IllegalArgumentException unused2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 80:
                        this.weak = codedInputByteBufferNano.readBool();
                        break;
                    case 90:
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] upgradedOptionArr = this.upgradedOption;
                        int length = upgradedOptionArr == null ? 0 : upgradedOptionArr.length;
                        com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[] upgradedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.upgradedOption, 0, upgradedOptionArr2, 0, length);
                        }
                        while (length < upgradedOptionArr2.length - 1) {
                            upgradedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption();
                            codedInputByteBufferNano.readMessage(upgradedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        upgradedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.FieldOptions.UpgradedOption();
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
                        int repeatedFieldArrayLength2 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length2 = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length2);
                        }
                        while (length2 < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        uninterpretedOptionArr2[length2] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
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

        public static com.google.protobuf.nano.DescriptorProtos.FieldOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.FieldOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.FieldOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.FieldOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.FieldOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class OneofOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.OneofOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.OneofOptions[] _emptyArray;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public static com.google.protobuf.nano.DescriptorProtos.OneofOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.OneofOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public OneofOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.OneofOptions clear() {
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.OneofOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.OneofOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.OneofOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.OneofOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.OneofOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.OneofOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.EnumOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.EnumOptions[] _emptyArray;
        public boolean allowAlias;
        public boolean deprecated;
        public java.lang.String proto1Name;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public static com.google.protobuf.nano.DescriptorProtos.EnumOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.EnumOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.EnumOptions clear() {
            this.proto1Name = "";
            this.allowAlias = false;
            this.deprecated = false;
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            java.lang.String str = this.proto1Name;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.proto1Name);
            }
            boolean z_renamed = this.allowAlias;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(2, z_renamed);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                codedOutputByteBufferNano.writeBool(3, z2);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            java.lang.String str = this.proto1Name;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.proto1Name);
            }
            boolean z_renamed = this.allowAlias;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(2, z_renamed);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(3, z2);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.EnumOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.EnumOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.EnumOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.EnumOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EnumValueOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.EnumValueOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.EnumValueOptions[] _emptyArray;
        public boolean deprecated;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public static com.google.protobuf.nano.DescriptorProtos.EnumValueOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.EnumValueOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EnumValueOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.EnumValueOptions clear() {
            this.deprecated = false;
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            boolean z_renamed = this.deprecated;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(1, z_renamed);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z_renamed = this.deprecated;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(1, z_renamed);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.EnumValueOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumValueOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.EnumValueOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.EnumValueOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.EnumValueOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.EnumValueOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ServiceOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.ServiceOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.ServiceOptions[] _emptyArray;
        public boolean deprecated;
        public double failureDetectionDelay;
        public boolean multicastStub;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public static com.google.protobuf.nano.DescriptorProtos.ServiceOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.ServiceOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ServiceOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.ServiceOptions clear() {
            this.multicastStub = false;
            this.failureDetectionDelay = -1.0d;
            this.deprecated = false;
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            if (java.lang.Double.doubleToLongBits(this.failureDetectionDelay) != java.lang.Double.doubleToLongBits(-1.0d)) {
                codedOutputByteBufferNano.writeDouble(16, this.failureDetectionDelay);
            }
            boolean z_renamed = this.multicastStub;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(20, z_renamed);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                codedOutputByteBufferNano.writeBool(33, z2);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (java.lang.Double.doubleToLongBits(this.failureDetectionDelay) != java.lang.Double.doubleToLongBits(-1.0d)) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeDoubleSize(16, this.failureDetectionDelay);
            }
            boolean z_renamed = this.multicastStub;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(20, z_renamed);
            }
            boolean z2 = this.deprecated;
            if (z2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(33, z2);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i_renamed >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i_renamed];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.ServiceOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < uninterpretedOptionArr2.length - 1) {
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.ServiceOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.ServiceOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.ServiceOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.ServiceOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.ServiceOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MethodOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.MethodOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.MethodOptions[] _emptyArray;
        public int clientLogging;
        public boolean clientStreaming;
        public double deadline;
        public boolean deprecated;
        public boolean duplicateSuppression;
        public boolean endUserCredsRequested;
        public boolean failFast;
        public boolean goLegacyChannelApi;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.IdempotencyLevel.class)
        public int idempotencyLevel;
        public long legacyClientInitialTokens;
        public java.lang.String legacyResultType;
        public long legacyServerInitialTokens;
        public java.lang.String legacyStreamType;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.TokenUnit.class)
        public int legacyTokenUnit;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
        public int logLevel;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Protocol.class)
        public int protocol;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Format.class)
        public int requestFormat;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Format.class)
        public int responseFormat;
        public java.lang.String securityLabel;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
        public int securityLevel;
        public int serverLogging;
        public boolean serverStreaming;
        public java.lang.String streamType;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public interface Format {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Format.class)
            public static final int UNCOMPRESSED = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Format.class)
            public static final int ZIPPY_COMPRESSED = 1;
        }

        public interface IdempotencyLevel {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.IdempotencyLevel.class)
            public static final int IDEMPOTENCY_UNKNOWN = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.IdempotencyLevel.class)
            public static final int IDEMPOTENT = 2;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.IdempotencyLevel.class)
            public static final int NO_SIDE_EFFECTS = 1;
        }

        public interface LogLevel {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
            public static final int LOG_HEADER_AND_FILTERED_PAYLOAD = 3;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
            public static final int LOG_HEADER_AND_NON_PRIVATE_PAYLOAD_INTERNAL = 2;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
            public static final int LOG_HEADER_AND_PAYLOAD = 4;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
            public static final int LOG_HEADER_ONLY = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
            public static final int LOG_NONE = 0;
        }

        public interface Protocol {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Protocol.class)
            public static final int TCP = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Protocol.class)
            public static final int UDP = 1;
        }

        public interface SecurityLevel {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
            public static final int INTEGRITY = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
            public static final int NONE = 0;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
            public static final int PRIVACY_AND_INTEGRITY = 2;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
            public static final int STRONG_PRIVACY_AND_INTEGRITY = 3;
        }

        public interface TokenUnit {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.TokenUnit.class)
            public static final int BYTE = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.TokenUnit.class)
            public static final int MESSAGE = 0;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Protocol.class)
        public static int checkProtocolOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 1) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(40);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum Protocol");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Protocol.class)
        public static int[] checkProtocolOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkProtocolOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
        public static int checkSecurityLevelOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 3) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(45);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum SecurityLevel");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
        public static int[] checkSecurityLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkSecurityLevelOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Format.class)
        public static int checkFormatOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 1) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(38);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum Format");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.Format.class)
        public static int[] checkFormatOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkFormatOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
        public static int checkLogLevelOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 4) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(40);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum LogLevel");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
        public static int[] checkLogLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkLogLevelOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.TokenUnit.class)
        public static int checkTokenUnitOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 1) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(41);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum TokenUnit");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.TokenUnit.class)
        public static int[] checkTokenUnitOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkTokenUnitOrThrow(i_renamed);
            }
            return iArr2;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.IdempotencyLevel.class)
        public static int checkIdempotencyLevelOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 2) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(48);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum IdempotencyLevel");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.IdempotencyLevel.class)
        public static int[] checkIdempotencyLevelOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkIdempotencyLevelOrThrow(i_renamed);
            }
            return iArr2;
        }

        public static com.google.protobuf.nano.DescriptorProtos.MethodOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.MethodOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MethodOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.MethodOptions clear() {
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
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            int i_renamed = this.protocol;
            if (i_renamed != 0) {
                codedOutputByteBufferNano.writeInt32(7, i_renamed);
            }
            if (java.lang.Double.doubleToLongBits(this.deadline) != java.lang.Double.doubleToLongBits(-1.0d)) {
                codedOutputByteBufferNano.writeDouble(8, this.deadline);
            }
            boolean z_renamed = this.duplicateSuppression;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(9, z_renamed);
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
            java.lang.String str = this.streamType;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(18, this.streamType);
            }
            java.lang.String str2 = this.securityLabel;
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
            java.lang.String str3 = this.legacyStreamType;
            if (str3 != null && !str3.equals("")) {
                codedOutputByteBufferNano.writeString(22, this.legacyStreamType);
            }
            java.lang.String str4 = this.legacyResultType;
            if (str4 != null && !str4.equals("")) {
                codedOutputByteBufferNano.writeString(23, this.legacyResultType);
            }
            long j_renamed = this.legacyClientInitialTokens;
            if (j_renamed != -1) {
                codedOutputByteBufferNano.writeInt64(24, j_renamed);
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
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i10 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i10 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i10];
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
            int i_renamed = this.protocol;
            if (i_renamed != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(7, i_renamed);
            }
            if (java.lang.Double.doubleToLongBits(this.deadline) != java.lang.Double.doubleToLongBits(-1.0d)) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeDoubleSize(8, this.deadline);
            }
            boolean z_renamed = this.duplicateSuppression;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(9, z_renamed);
            }
            boolean z2 = this.failFast;
            if (z2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(10, z2);
            }
            int i2 = this.clientLogging;
            if (i2 != 256) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeSInt32Size(11, i2);
            }
            int i3 = this.serverLogging;
            if (i3 != 256) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeSInt32Size(12, i3);
            }
            int i4 = this.securityLevel;
            if (i4 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(13, i4);
            }
            int i5 = this.responseFormat;
            if (i5 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(15, i5);
            }
            int i6 = this.requestFormat;
            if (i6 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(17, i6);
            }
            java.lang.String str = this.streamType;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(18, this.streamType);
            }
            java.lang.String str2 = this.securityLabel;
            if (str2 != null && !str2.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(19, this.securityLabel);
            }
            boolean z3 = this.clientStreaming;
            if (z3) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(20, z3);
            }
            boolean z4 = this.serverStreaming;
            if (z4) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(21, z4);
            }
            java.lang.String str3 = this.legacyStreamType;
            if (str3 != null && !str3.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(22, this.legacyStreamType);
            }
            java.lang.String str4 = this.legacyResultType;
            if (str4 != null && !str4.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(23, this.legacyResultType);
            }
            long j_renamed = this.legacyClientInitialTokens;
            if (j_renamed != -1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64Size(24, j_renamed);
            }
            long j2 = this.legacyServerInitialTokens;
            if (j2 != -1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64Size(25, j2);
            }
            boolean z5 = this.endUserCredsRequested;
            if (z5) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(26, z5);
            }
            int i7 = this.logLevel;
            if (i7 != 2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(27, i7);
            }
            int i8 = this.legacyTokenUnit;
            if (i8 != 1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(28, i8);
            }
            boolean z6 = this.goLegacyChannelApi;
            if (z6) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(29, z6);
            }
            boolean z7 = this.deprecated;
            if (z7) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(33, z7);
            }
            int i9 = this.idempotencyLevel;
            if (i9 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(34, i9);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i10 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i10 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i10];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i10++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.MethodOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        } catch (java.lang.IllegalArgumentException unused) {
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
                        } catch (java.lang.IllegalArgumentException unused2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 120:
                        int position3 = codedInputByteBufferNano.getPosition();
                        try {
                            this.responseFormat = checkFormatOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (java.lang.IllegalArgumentException unused3) {
                            codedInputByteBufferNano.rewindToPosition(position3);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 136:
                        int position4 = codedInputByteBufferNano.getPosition();
                        try {
                            this.requestFormat = checkFormatOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (java.lang.IllegalArgumentException unused4) {
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
                        } catch (java.lang.IllegalArgumentException unused5) {
                            codedInputByteBufferNano.rewindToPosition(position5);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 224:
                        int position6 = codedInputByteBufferNano.getPosition();
                        try {
                            this.legacyTokenUnit = checkTokenUnitOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (java.lang.IllegalArgumentException unused6) {
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
                        } catch (java.lang.IllegalArgumentException unused7) {
                            codedInputByteBufferNano.rewindToPosition(position7);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 7994:
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
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

        public static com.google.protobuf.nano.DescriptorProtos.MethodOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.MethodOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.MethodOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.MethodOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.MethodOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class StreamOptions extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.StreamOptions> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.StreamOptions[] _emptyArray;
        public long clientInitialTokens;
        public int clientLogging;
        public double deadline;
        public boolean deprecated;
        public boolean endUserCredsRequested;
        public boolean failFast;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.LogLevel.class)
        public int logLevel;
        public java.lang.String securityLabel;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.MethodOptions.SecurityLevel.class)
        public int securityLevel;
        public long serverInitialTokens;
        public int serverLogging;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.StreamOptions.TokenUnit.class)
        public int tokenUnit;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOption;

        public interface TokenUnit {

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.StreamOptions.TokenUnit.class)
            public static final int BYTE = 1;

            @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.StreamOptions.TokenUnit.class)
            public static final int MESSAGE = 0;
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.StreamOptions.TokenUnit.class)
        public static int checkTokenUnitOrThrow(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 1) {
                return i_renamed;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(41);
            sb.append(i_renamed);
            sb.append(" is_renamed not a_renamed valid enum TokenUnit");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.DescriptorProtos.StreamOptions.TokenUnit.class)
        public static int[] checkTokenUnitOrThrow(int[] iArr) {
            int[] iArr2 = (int[]) iArr.clone();
            for (int i_renamed : iArr2) {
                checkTokenUnitOrThrow(i_renamed);
            }
            return iArr2;
        }

        public static com.google.protobuf.nano.DescriptorProtos.StreamOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.StreamOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public StreamOptions() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.StreamOptions clear() {
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
            this.uninterpretedOption = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            long j_renamed = this.clientInitialTokens;
            if (j_renamed != -1) {
                codedOutputByteBufferNano.writeInt64(1, j_renamed);
            }
            long j2 = this.serverInitialTokens;
            if (j2 != -1) {
                codedOutputByteBufferNano.writeInt64(2, j2);
            }
            int i_renamed = this.tokenUnit;
            if (i_renamed != 0) {
                codedOutputByteBufferNano.writeInt32(3, i_renamed);
            }
            int i2 = this.securityLevel;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            java.lang.String str = this.securityLabel;
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
            if (java.lang.Double.doubleToLongBits(this.deadline) != java.lang.Double.doubleToLongBits(-1.0d)) {
                codedOutputByteBufferNano.writeDouble(8, this.deadline);
            }
            boolean z_renamed = this.failFast;
            if (z_renamed) {
                codedOutputByteBufferNano.writeBool(9, z_renamed);
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
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
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
            long j_renamed = this.clientInitialTokens;
            if (j_renamed != -1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64Size(1, j_renamed);
            }
            long j2 = this.serverInitialTokens;
            if (j2 != -1) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64Size(2, j2);
            }
            int i_renamed = this.tokenUnit;
            if (i_renamed != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(3, i_renamed);
            }
            int i2 = this.securityLevel;
            if (i2 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            java.lang.String str = this.securityLabel;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(5, this.securityLabel);
            }
            int i3 = this.clientLogging;
            if (i3 != 256) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(6, i3);
            }
            int i4 = this.serverLogging;
            if (i4 != 256) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(7, i4);
            }
            if (java.lang.Double.doubleToLongBits(this.deadline) != java.lang.Double.doubleToLongBits(-1.0d)) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeDoubleSize(8, this.deadline);
            }
            boolean z_renamed = this.failFast;
            if (z_renamed) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(9, z_renamed);
            }
            boolean z2 = this.endUserCredsRequested;
            if (z2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(10, z2);
            }
            int i5 = this.logLevel;
            if (i5 != 2) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(11, i5);
            }
            boolean z3 = this.deprecated;
            if (z3) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(33, z3);
            }
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i6 = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i6 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i6];
                    if (uninterpretedOption != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i6++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.StreamOptions mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                        } catch (java.lang.IllegalArgumentException unused) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 32:
                        int position2 = codedInputByteBufferNano.getPosition();
                        try {
                            this.securityLevel = com.google.protobuf.nano.DescriptorProtos.MethodOptions.checkSecurityLevelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (java.lang.IllegalArgumentException unused2) {
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
                            this.logLevel = com.google.protobuf.nano.DescriptorProtos.MethodOptions.checkLogLevelOrThrow(codedInputByteBufferNano.readInt32());
                            break;
                        } catch (java.lang.IllegalArgumentException unused3) {
                            codedInputByteBufferNano.rewindToPosition(position3);
                            storeUnknownField(codedInputByteBufferNano, tag);
                            break;
                        }
                    case 264:
                        this.deprecated = codedInputByteBufferNano.readBool();
                        break;
                    case 7994:
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] uninterpretedOptionArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < uninterpretedOptionArr2.length - 1) {
                            uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption();
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

        public static com.google.protobuf.nano.DescriptorProtos.StreamOptions parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.StreamOptions) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.StreamOptions(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.StreamOptions parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.StreamOptions().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class UninterpretedOption extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.UninterpretedOption> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] _emptyArray;
        public java.lang.String aggregateValue;
        public double doubleValue;
        public java.lang.String identifierValue;
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] name;
        public long negativeIntValue;
        public long positiveIntValue;
        public byte[] stringValue;

        public static final class NamePart extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart> {
            private static volatile com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] _emptyArray;
            public boolean isExtension;
            public java.lang.String namePart;

            public static com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public NamePart() {
                clear();
            }

            public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart clear() {
                this.namePart = "";
                this.isExtension = false;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
                codedOutputByteBufferNano.writeString(1, this.namePart);
                codedOutputByteBufferNano.writeBool(2, this.isExtension);
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                return super.computeSerializedSize() + com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(1, this.namePart) + com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(2, this.isExtension);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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

            public static com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
                return (com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart(), bArr);
            }

            public static com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                return new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UninterpretedOption() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption clear() {
            this.name = com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart.emptyArray();
            this.identifierValue = "";
            this.positiveIntValue = 0L;
            this.negativeIntValue = 0L;
            this.doubleValue = 0.0d;
            this.stringValue = com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES;
            this.aggregateValue = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] namePartArr = this.name;
            if (namePartArr != null && namePartArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] namePartArr2 = this.name;
                    if (i_renamed >= namePartArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart namePart = namePartArr2[i_renamed];
                    if (namePart != null) {
                        codedOutputByteBufferNano.writeMessage(2, namePart);
                    }
                    i_renamed++;
                }
            }
            java.lang.String str = this.identifierValue;
            if (str != null && !str.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.identifierValue);
            }
            long j_renamed = this.positiveIntValue;
            if (j_renamed != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j_renamed);
            }
            long j2 = this.negativeIntValue;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeInt64(5, j2);
            }
            if (java.lang.Double.doubleToLongBits(this.doubleValue) != java.lang.Double.doubleToLongBits(0.0d)) {
                codedOutputByteBufferNano.writeDouble(6, this.doubleValue);
            }
            if (!java.util.Arrays.equals(this.stringValue, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(7, this.stringValue);
            }
            java.lang.String str2 = this.aggregateValue;
            if (str2 != null && !str2.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.aggregateValue);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] namePartArr = this.name;
            if (namePartArr != null && namePartArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] namePartArr2 = this.name;
                    if (i_renamed >= namePartArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart namePart = namePartArr2[i_renamed];
                    if (namePart != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(2, namePart);
                    }
                    i_renamed++;
                }
            }
            java.lang.String str = this.identifierValue;
            if (str != null && !str.equals("")) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(3, this.identifierValue);
            }
            long j_renamed = this.positiveIntValue;
            if (j_renamed != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeUInt64Size(4, j_renamed);
            }
            long j2 = this.negativeIntValue;
            if (j2 != 0) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64Size(5, j2);
            }
            if (java.lang.Double.doubleToLongBits(this.doubleValue) != java.lang.Double.doubleToLongBits(0.0d)) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeDoubleSize(6, this.doubleValue);
            }
            if (!java.util.Arrays.equals(this.stringValue, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeBytesSize(7, this.stringValue);
            }
            java.lang.String str2 = this.aggregateValue;
            return (str2 == null || str2.equals("")) ? iComputeSerializedSize : iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(8, this.aggregateValue);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.UninterpretedOption mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 18) {
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] namePartArr = this.name;
                    int length = namePartArr == null ? 0 : namePartArr.length;
                    com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[] namePartArr2 = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.name, 0, namePartArr2, 0, length);
                    }
                    while (length < namePartArr2.length - 1) {
                        namePartArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart();
                        codedInputByteBufferNano.readMessage(namePartArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    namePartArr2[length] = new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption.NamePart();
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

        public static com.google.protobuf.nano.DescriptorProtos.UninterpretedOption parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.UninterpretedOption) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.UninterpretedOption parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.UninterpretedOption().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SourceCodeInfo extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo[] _emptyArray;
        public com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] location;

        public static final class Location extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location> {
            private static volatile com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] _emptyArray;
            public java.lang.String leadingComments;
            public java.lang.String[] leadingDetachedComments;
            public int[] path;
            public int[] span;
            public java.lang.String trailingComments;

            public static com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public Location() {
                clear();
            }

            public com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location clear() {
                this.path = com.google.protobuf.nano.WireFormatNano.EMPTY_INT_ARRAY;
                this.span = com.google.protobuf.nano.WireFormatNano.EMPTY_INT_ARRAY;
                this.leadingComments = "";
                this.trailingComments = "";
                this.leadingDetachedComments = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
                int[] iArr = this.path;
                int i_renamed = 0;
                if (iArr != null && iArr.length > 0) {
                    int i2 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
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
                        iComputeInt32SizeNoTag2 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr5[i4]);
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
                java.lang.String str = this.leadingComments;
                if (str != null && !str.equals("")) {
                    codedOutputByteBufferNano.writeString(3, this.leadingComments);
                }
                java.lang.String str2 = this.trailingComments;
                if (str2 != null && !str2.equals("")) {
                    codedOutputByteBufferNano.writeString(4, this.trailingComments);
                }
                java.lang.String[] strArr = this.leadingDetachedComments;
                if (strArr != null && strArr.length > 0) {
                    while (true) {
                        java.lang.String[] strArr2 = this.leadingDetachedComments;
                        if (i_renamed >= strArr2.length) {
                            break;
                        }
                        java.lang.String str3 = strArr2[i_renamed];
                        if (str3 != null) {
                            codedOutputByteBufferNano.writeString(6, str3);
                        }
                        i_renamed++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int[] iArr = this.path;
                int i_renamed = 0;
                if (iArr != null && iArr.length > 0) {
                    int i2 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + 1 + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(iComputeInt32SizeNoTag);
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
                        iComputeInt32SizeNoTag2 += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr4[i3]);
                        i3++;
                    }
                    iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag2 + 1 + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(iComputeInt32SizeNoTag2);
                }
                java.lang.String str = this.leadingComments;
                if (str != null && !str.equals("")) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(3, this.leadingComments);
                }
                java.lang.String str2 = this.trailingComments;
                if (str2 != null && !str2.equals("")) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(4, this.trailingComments);
                }
                java.lang.String[] strArr = this.leadingDetachedComments;
                if (strArr == null || strArr.length <= 0) {
                    return iComputeSerializedSize;
                }
                int iComputeStringSizeNoTag = 0;
                int i4 = 0;
                while (true) {
                    java.lang.String[] strArr2 = this.leadingDetachedComments;
                    if (i_renamed >= strArr2.length) {
                        return iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
                    }
                    java.lang.String str3 = strArr2[i_renamed];
                    if (str3 != null) {
                        i4++;
                        iComputeStringSizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i_renamed++;
                }
            }

            @Override // com.google.protobuf.nano.MessageNano
            public com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr = this.path;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.path, 0, iArr2, 0, length);
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
                        int i_renamed = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i_renamed++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.path;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i_renamed + length2];
                        if (length2 != 0) {
                            java.lang.System.arraycopy(this.path, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                            length2++;
                        }
                        this.path = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                    } else if (tag == 16) {
                        int repeatedFieldArrayLength2 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        int[] iArr5 = this.span;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[repeatedFieldArrayLength2 + length3];
                        if (length3 != 0) {
                            java.lang.System.arraycopy(this.span, 0, iArr6, 0, length3);
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
                            java.lang.System.arraycopy(this.span, 0, iArr8, 0, length4);
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
                        int repeatedFieldArrayLength3 = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        java.lang.String[] strArr = this.leadingDetachedComments;
                        int length5 = strArr == null ? 0 : strArr.length;
                        java.lang.String[] strArr2 = new java.lang.String[repeatedFieldArrayLength3 + length5];
                        if (length5 != 0) {
                            java.lang.System.arraycopy(this.leadingDetachedComments, 0, strArr2, 0, length5);
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

            public static com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
                return (com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location(), bArr);
            }

            public static com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                return new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SourceCodeInfo() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo clear() {
            this.location = com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] locationArr = this.location;
            if (locationArr != null && locationArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] locationArr2 = this.location;
                    if (i_renamed >= locationArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location location = locationArr2[i_renamed];
                    if (location != null) {
                        codedOutputByteBufferNano.writeMessage(1, location);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] locationArr = this.location;
            if (locationArr != null && locationArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] locationArr2 = this.location;
                    if (i_renamed >= locationArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location location = locationArr2[i_renamed];
                    if (location != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(1, location);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] locationArr = this.location;
                    int length = locationArr == null ? 0 : locationArr.length;
                    com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[] locationArr2 = new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.location, 0, locationArr2, 0, length);
                    }
                    while (length < locationArr2.length - 1) {
                        locationArr2[length] = new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location();
                        codedInputByteBufferNano.readMessage(locationArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    locationArr2[length] = new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo.Location();
                    codedInputByteBufferNano.readMessage(locationArr2[length]);
                    this.location = locationArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.SourceCodeInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class GeneratedCodeInfo extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo> {
        private static volatile com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo[] _emptyArray;
        public com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] annotation;

        public static final class Annotation extends com.google.protobuf.nano.ExtendableMessageNano<com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation> {
            private static volatile com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] _emptyArray;
            public int begin;
            public int end;
            public int[] path;
            public java.lang.String sourceFile;

            public static com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public Annotation() {
                clear();
            }

            public com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation clear() {
                this.path = com.google.protobuf.nano.WireFormatNano.EMPTY_INT_ARRAY;
                this.sourceFile = "";
                this.begin = 0;
                this.end = 0;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
                int[] iArr = this.path;
                if (iArr != null && iArr.length > 0) {
                    int i_renamed = 0;
                    int i2 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(10);
                    codedOutputByteBufferNano.writeRawVarint32(iComputeInt32SizeNoTag);
                    while (true) {
                        int[] iArr3 = this.path;
                        if (i_renamed >= iArr3.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32NoTag(iArr3[i_renamed]);
                        i_renamed++;
                    }
                }
                java.lang.String str = this.sourceFile;
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
                    int i_renamed = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i_renamed >= iArr2.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i_renamed]);
                        i_renamed++;
                    }
                    iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + 1 + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(iComputeInt32SizeNoTag);
                }
                java.lang.String str = this.sourceFile;
                if (str != null && !str.equals("")) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(2, this.sourceFile);
                }
                int i2 = this.begin;
                if (i2 != 0) {
                    iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(3, i2);
                }
                int i3 = this.end;
                return i3 != 0 ? iComputeSerializedSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(4, i3) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr = this.path;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            java.lang.System.arraycopy(this.path, 0, iArr2, 0, length);
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
                        int i_renamed = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i_renamed++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.path;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i_renamed + length2];
                        if (length2 != 0) {
                            java.lang.System.arraycopy(this.path, 0, iArr4, 0, length2);
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

            public static com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
                return (com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation(), bArr);
            }

            public static com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
                return new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GeneratedCodeInfo() {
            clear();
        }

        public com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo clear() {
            this.annotation = com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] annotationArr = this.annotation;
            if (annotationArr != null && annotationArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] annotationArr2 = this.annotation;
                    if (i_renamed >= annotationArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation annotation = annotationArr2[i_renamed];
                    if (annotation != null) {
                        codedOutputByteBufferNano.writeMessage(1, annotation);
                    }
                    i_renamed++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] annotationArr = this.annotation;
            if (annotationArr != null && annotationArr.length > 0) {
                int i_renamed = 0;
                while (true) {
                    com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] annotationArr2 = this.annotation;
                    if (i_renamed >= annotationArr2.length) {
                        break;
                    }
                    com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation annotation = annotationArr2[i_renamed];
                    if (annotation != null) {
                        iComputeSerializedSize += com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(1, annotation);
                    }
                    i_renamed++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo mergeFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
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
                    int repeatedFieldArrayLength = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] annotationArr = this.annotation;
                    int length = annotationArr == null ? 0 : annotationArr.length;
                    com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[] annotationArr2 = new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        java.lang.System.arraycopy(this.annotation, 0, annotationArr2, 0, length);
                    }
                    while (length < annotationArr2.length - 1) {
                        annotationArr2[length] = new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation();
                        codedInputByteBufferNano.readMessage(annotationArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    annotationArr2[length] = new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo.Annotation();
                    codedInputByteBufferNano.readMessage(annotationArr2[length]);
                    this.annotation = annotationArr2;
                }
            }
        }

        public static com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo parseFrom(byte[] bArr) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return (com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo) com.google.protobuf.nano.MessageNano.mergeFrom(new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo(), bArr);
        }

        public static com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo parseFrom(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) throws java.io.IOException {
            return new com.google.protobuf.nano.DescriptorProtos.GeneratedCodeInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
