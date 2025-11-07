package com.google.android.apps.lens.library.base.proto;

/* loaded from: classes.dex */
public final class LensSdkParamsProto {

    public interface LensSdkParamsOrBuilder extends com.google.protobuf.MessageLiteOrBuilder {
        java.lang.String getAgsaVersionName();

        com.google.protobuf.ByteString getAgsaVersionNameBytes();

        com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus getArStickersAvailabilityStatus();

        com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus getLensAvailabilityStatus();

        java.lang.String getLensSdkVersion();

        com.google.protobuf.ByteString getLensSdkVersionBytes();

        boolean hasAgsaVersionName();

        boolean hasArStickersAvailabilityStatus();

        boolean hasLensAvailabilityStatus();

        boolean hasLensSdkVersion();
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
    }

    private LensSdkParamsProto() {
    }

    @com.google.protobuf.ProtoMessage(checkInitialized = {}, messageSetWireFormat = false, protoSyntax = com.google.protobuf.ProtoSyntax.PROTO2)
    public static final class LensSdkParams extends com.google.protobuf.GeneratedMessageLite<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams, com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder> implements com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder {
        public static final int AGSA_VERSION_NAME_FIELD_NUMBER = 2;
        public static final int AR_STICKERS_AVAILABILITY_STATUS_FIELD_NUMBER = 4;
        private static final com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams DEFAULT_INSTANCE = new com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams();
        public static final int LENS_AVAILABILITY_STATUS_FIELD_NUMBER = 3;
        public static final int LENS_SDK_VERSION_FIELD_NUMBER = 1;
        private static volatile com.google.protobuf.Parser<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams> PARSER;

        @com.google.protobuf.ProtoPresenceBits(id_renamed = 0)
        private int bitField0_;

        @com.google.protobuf.ProtoField(fieldNumber = 1, isEnforceUtf8 = false, isRequired = false, type = com.google.protobuf.FieldType.STRING)
        @com.google.protobuf.ProtoPresenceCheckedField(mask = 1, presenceBitsId = 0)
        private java.lang.String lensSdkVersion_ = "";

        @com.google.protobuf.ProtoField(fieldNumber = 2, isEnforceUtf8 = false, isRequired = false, type = com.google.protobuf.FieldType.STRING)
        @com.google.protobuf.ProtoPresenceCheckedField(mask = 2, presenceBitsId = 0)
        private java.lang.String agsaVersionName_ = "";

        @com.google.protobuf.ProtoField(fieldNumber = 3, isRequired = false, type = com.google.protobuf.FieldType.ENUM)
        @com.google.protobuf.ProtoPresenceCheckedField(mask = 4, presenceBitsId = 0)
        private int lensAvailabilityStatus_ = -1;

        @com.google.protobuf.ProtoField(fieldNumber = 4, isRequired = false, type = com.google.protobuf.FieldType.ENUM)
        @com.google.protobuf.ProtoPresenceCheckedField(mask = 8, presenceBitsId = 0)
        private int arStickersAvailabilityStatus_ = -1;

        private LensSdkParams() {
        }

        public enum LensAvailabilityStatus implements com.google.protobuf.Internal.EnumLite {
            LENS_AVAILABILITY_UNKNOWN(-1),
            LENS_READY(0),
            LENS_UNAVAILABLE(1),
            LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED(2),
            LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE(3),
            LENS_UNAVAILABLE_INVALID_CURSOR(4),
            LENS_UNAVAILABLE_DEVICE_LOCKED(5),
            LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE(6);

            public static final int LENS_AVAILABILITY_UNKNOWN_VALUE = -1;
            public static final int LENS_READY_VALUE = 0;
            public static final int LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE_VALUE = 3;
            public static final int LENS_UNAVAILABLE_DEVICE_LOCKED_VALUE = 5;
            public static final int LENS_UNAVAILABLE_INVALID_CURSOR_VALUE = 4;
            public static final int LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED_VALUE = 2;
            public static final int LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE_VALUE = 6;
            public static final int LENS_UNAVAILABLE_VALUE = 1;
            private static final com.google.protobuf.Internal.EnumLiteMap<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus>() { // from class: com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus findValueByNumber(int i_renamed) {
                    return com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.forNumber(i_renamed);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus forNumber(int i_renamed) {
                switch (i_renamed) {
                    case -1:
                        return LENS_AVAILABILITY_UNKNOWN;
                    case 0:
                        return LENS_READY;
                    case 1:
                        return LENS_UNAVAILABLE;
                    case 2:
                        return LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED;
                    case 3:
                        return LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE;
                    case 4:
                        return LENS_UNAVAILABLE_INVALID_CURSOR;
                    case 5:
                        return LENS_UNAVAILABLE_DEVICE_LOCKED;
                    case 6:
                        return LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus> internalGetValueMap() {
                return internalValueMap;
            }

            LensAvailabilityStatus(int i_renamed) {
                this.value = i_renamed;
            }
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public boolean hasLensSdkVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public java.lang.String getLensSdkVersion() {
            return this.lensSdkVersion_;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public com.google.protobuf.ByteString getLensSdkVersionBytes() {
            return com.google.protobuf.ByteString.copyFromUtf8(this.lensSdkVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLensSdkVersion(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.bitField0_ |= 1;
            this.lensSdkVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLensSdkVersion() {
            this.bitField0_ &= -2;
            this.lensSdkVersion_ = getDefaultInstance().getLensSdkVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLensSdkVersionBytes(com.google.protobuf.ByteString byteString) {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            this.bitField0_ |= 1;
            this.lensSdkVersion_ = byteString.toStringUtf8();
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public boolean hasAgsaVersionName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public java.lang.String getAgsaVersionName() {
            return this.agsaVersionName_;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public com.google.protobuf.ByteString getAgsaVersionNameBytes() {
            return com.google.protobuf.ByteString.copyFromUtf8(this.agsaVersionName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAgsaVersionName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.bitField0_ |= 2;
            this.agsaVersionName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAgsaVersionName() {
            this.bitField0_ &= -3;
            this.agsaVersionName_ = getDefaultInstance().getAgsaVersionName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAgsaVersionNameBytes(com.google.protobuf.ByteString byteString) {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            this.bitField0_ |= 2;
            this.agsaVersionName_ = byteString.toStringUtf8();
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public boolean hasLensAvailabilityStatus() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus getLensAvailabilityStatus() {
            com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus lensAvailabilityStatusForNumber = com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.forNumber(this.lensAvailabilityStatus_);
            return lensAvailabilityStatusForNumber == null ? com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.LENS_AVAILABILITY_UNKNOWN : lensAvailabilityStatusForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLensAvailabilityStatus(com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus lensAvailabilityStatus) {
            if (lensAvailabilityStatus == null) {
                throw new java.lang.NullPointerException();
            }
            this.bitField0_ |= 4;
            this.lensAvailabilityStatus_ = lensAvailabilityStatus.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLensAvailabilityStatus() {
            this.bitField0_ &= -5;
            this.lensAvailabilityStatus_ = -1;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public boolean hasArStickersAvailabilityStatus() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus getArStickersAvailabilityStatus() {
            com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus lensAvailabilityStatusForNumber = com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.forNumber(this.arStickersAvailabilityStatus_);
            return lensAvailabilityStatusForNumber == null ? com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.LENS_AVAILABILITY_UNKNOWN : lensAvailabilityStatusForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setArStickersAvailabilityStatus(com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus lensAvailabilityStatus) {
            if (lensAvailabilityStatus == null) {
                throw new java.lang.NullPointerException();
            }
            this.bitField0_ |= 8;
            this.arStickersAvailabilityStatus_ = lensAvailabilityStatus.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearArStickersAvailabilityStatus() {
            this.bitField0_ &= -9;
            this.arStickersAvailabilityStatus_ = -1;
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder newBuilder(com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams lensSdkParams) {
            return DEFAULT_INSTANCE.createBuilder(lensSdkParams);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams, com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder> implements com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder {
            private Builder() {
                super(com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.DEFAULT_INSTANCE);
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasLensSdkVersion() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).hasLensSdkVersion();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public java.lang.String getLensSdkVersion() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).getLensSdkVersion();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public com.google.protobuf.ByteString getLensSdkVersionBytes() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).getLensSdkVersionBytes();
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder setLensSdkVersion(java.lang.String str) {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).setLensSdkVersion(str);
                return this;
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder clearLensSdkVersion() {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).clearLensSdkVersion();
                return this;
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder setLensSdkVersionBytes(com.google.protobuf.ByteString byteString) {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).setLensSdkVersionBytes(byteString);
                return this;
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasAgsaVersionName() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).hasAgsaVersionName();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public java.lang.String getAgsaVersionName() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).getAgsaVersionName();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public com.google.protobuf.ByteString getAgsaVersionNameBytes() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).getAgsaVersionNameBytes();
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder setAgsaVersionName(java.lang.String str) {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).setAgsaVersionName(str);
                return this;
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder clearAgsaVersionName() {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).clearAgsaVersionName();
                return this;
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder setAgsaVersionNameBytes(com.google.protobuf.ByteString byteString) {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).setAgsaVersionNameBytes(byteString);
                return this;
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasLensAvailabilityStatus() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).hasLensAvailabilityStatus();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus getLensAvailabilityStatus() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).getLensAvailabilityStatus();
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder setLensAvailabilityStatus(com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus lensAvailabilityStatus) {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).setLensAvailabilityStatus(lensAvailabilityStatus);
                return this;
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder clearLensAvailabilityStatus() {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).clearLensAvailabilityStatus();
                return this;
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasArStickersAvailabilityStatus() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).hasArStickersAvailabilityStatus();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus getArStickersAvailabilityStatus() {
                return ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).getArStickersAvailabilityStatus();
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder setArStickersAvailabilityStatus(com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus lensAvailabilityStatus) {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).setArStickersAvailabilityStatus(lensAvailabilityStatus);
                return this;
            }

            public com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder clearArStickersAvailabilityStatus() {
                copyOnWrite();
                ((com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams) this.instance).clearArStickersAvailabilityStatus();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final java.lang.Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke methodToInvoke, java.lang.Object obj, java.lang.Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams();
                case NEW_BUILDER:
                    return new com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\b_renamed\u0000\u0002\b_renamed\u0001\u0003\f_renamed\u0002\u0004\f_renamed\u0003", new java.lang.Object[]{"bitField0_", "lensSdkVersion_", "agsaVersionName_", "lensAvailabilityStatus_", com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.internalGetValueMap(), "arStickersAvailabilityStatus_", com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.internalGetValueMap()});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    com.google.protobuf.Parser<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        }
                    }
                    return defaultInstanceBasedParser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new java.lang.UnsupportedOperationException();
            }
        }

        static {
            com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.class, DEFAULT_INSTANCE);
        }

        public static com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
